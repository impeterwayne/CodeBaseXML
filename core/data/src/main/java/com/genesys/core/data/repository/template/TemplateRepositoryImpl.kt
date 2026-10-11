package com.genesys.core.data.repository.template

import com.genesys.core.common.base.Result
import com.genesys.core.domain.repository.template.TemplateRepository
import com.genesys.core.model.pokemon.Pokemon
import com.genesys.core.network.service.ApiService
import com.skydoves.sandwich.message
import com.skydoves.sandwich.suspendOnFailure
import com.skydoves.sandwich.suspendOnSuccess
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class TemplateRepositoryImpl @Inject constructor(
    private val apiService: ApiService
) : TemplateRepository {

    override fun getAllTemplates(page: Int): Flow<Result<List<Pokemon>>> = flow {
        emit(Result.Loading())

        val limit = 40
        val offset = page * limit
        val response = apiService.fetchPokemonList(limit = limit, offset = offset)

        response.suspendOnSuccess {
            val pokemonList = data.results.map { dto ->
                Pokemon(
                    page = page,
                    name = dto.name,
                    url = dto.url
                )
            }
            emit(Result.Success(pokemonList))
        }.suspendOnFailure {
            emit(Result.Error(message()))
        }
    }.flowOn(Dispatchers.IO)
}
