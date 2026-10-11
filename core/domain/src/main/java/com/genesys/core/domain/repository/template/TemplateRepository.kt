package com.genesys.core.domain.repository.template

import com.genesys.core.common.base.Result
import com.genesys.core.model.pokemon.Pokemon
import kotlinx.coroutines.flow.Flow

interface TemplateRepository {
    fun getAllTemplates(page: Int = 0): Flow<Result<List<Pokemon>>>
}
