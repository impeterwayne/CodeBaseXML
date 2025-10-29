package com.genesys.v1.codebase.domain.repository.template

import androidx.annotation.WorkerThread
import com.genesys.v1.codebase.data.database.dao.TemplateCollectionsDao
import com.genesys.v1.codebase.data.database.entity.mapper.asDomain
import com.genesys.v1.codebase.data.database.entity.mapper.asEntity
import com.genesys.v1.codebase.data.mmkv.MMKVData
import com.genesys.v1.codebase.data.network.service.ApiService
import com.genesys.v1.codebase.domain.model.template.TemplateCollections
import com.genesys.v1.codebase.utils.TimeUtils
import com.skydoves.sandwich.message
import com.skydoves.sandwich.suspendOnFailure
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

class TemplateRepositoryImpl @Inject constructor(
    private val apiService: ApiService,
    private val templateCollectionsDao: TemplateCollectionsDao
) : TemplateRepository {
    @WorkerThread
    override fun getAllTemplates(
        onStart: () -> Unit,
        onCompleted: () -> Unit,
        onError: (String?) -> Unit
    ): Flow<List<TemplateCollections>> = flow {
        val cached = templateCollectionsDao.getAllTemplateCollections().asDomain()
        val shouldFetchFromNetwork = TimeUtils.isTimeRangeValidForFetchingData() || cached.isEmpty()
        if (!shouldFetchFromNetwork) {
            emit(cached)
        } else {
            val response = apiService.getAITemplates()
            response.suspendOnSuccess {
                val collections = data.data
                emit(collections)
                templateCollectionsDao.clearAllTemplateCollections()
                templateCollectionsDao.insertTemplateCollections(collections.asEntity())
                MMKVData.lastFetchTemplateTime = System.currentTimeMillis()
            }.suspendOnFailure {
                emit(cached)
                if(cached.isEmpty()){
                    onError(message())
                }
            }
        }
    }.onStart { onStart() }
     .onCompletion { onCompleted() }
     .flowOn(Dispatchers.IO)
} 