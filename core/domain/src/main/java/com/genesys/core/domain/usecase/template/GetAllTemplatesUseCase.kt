package com.genesys.core.domain.usecase.template

import com.genesys.core.common.base.Result
import com.genesys.core.domain.repository.template.TemplateRepository
import com.genesys.core.model.pokemon.Pokemon
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllTemplatesUseCase @Inject constructor(
    private val templateRepository: TemplateRepository
) {
    operator fun invoke(page: Int = 0): Flow<Result<List<Pokemon>>> {
        return templateRepository.getAllTemplates(page)
    }
}
