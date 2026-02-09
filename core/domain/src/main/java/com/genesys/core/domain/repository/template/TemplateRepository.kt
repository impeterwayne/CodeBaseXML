package com.genesys.core.domain.repository.template

import androidx.annotation.WorkerThread
import com.genesys.core.model.template.TemplateCollections
import kotlinx.coroutines.flow.Flow

interface TemplateRepository {
    @WorkerThread
    fun getAllTemplates(
        onStart: () -> Unit,
        onCompleted: () -> Unit,
        onError: (String?) -> Unit
    ): Flow<List<TemplateCollections>>
}
