package com.genesys.v1.codebase.domain.repository.template

import androidx.annotation.WorkerThread
import com.genesys.v1.codebase.domain.model.template.TemplateCollections
import kotlinx.coroutines.flow.Flow

interface TemplateRepository {
    @WorkerThread
    fun getAllTemplates(
        onStart: () -> Unit,
        onCompleted: () -> Unit,
        onError: (String?) -> Unit
    ): Flow<List<TemplateCollections>>
} 