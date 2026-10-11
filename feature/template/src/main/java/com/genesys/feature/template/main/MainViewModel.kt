package com.genesys.feature.template.main

import com.genesys.core.common.base.BaseViewModel
import com.genesys.core.common.base.Result
import com.genesys.core.domain.usecase.template.GetAllTemplatesUseCase
import com.genesys.core.model.pokemon.Pokemon
import dagger.hilt.android.lifecycle.HiltViewModel
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.viewmodel.container
import javax.inject.Inject

data class MainUiState(
    val pokemonList: List<Pokemon> = emptyList(),
    val isLoading: Boolean = false,
    val isLoadMoreLoading: Boolean = false,
    val searchQuery: String = "",
    val currentPage: Int = 0,
    val errorMessage: String? = null
) {
    val filteredPokemon: List<Pokemon>
        get() = if (searchQuery.isBlank()) {
            pokemonList
        } else {
            pokemonList.filter { it.name.contains(searchQuery, ignoreCase = true) }
        }
}

sealed class MainEvent : BaseViewModel.IEvent {
    data object LoadTemplates : MainEvent()
    data object LoadNextPage : MainEvent()
    data class OnSearchQueryChanged(val query: String) : MainEvent()
    data class OnPokemonClicked(val pokemon: Pokemon) : MainEvent()
}

sealed interface MainSideEffect {
    data class OpenPokemonDetail(val pokemonName: String) : MainSideEffect
}

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllTemplatesUseCase: GetAllTemplatesUseCase
) : BaseViewModel<MainEvent>(), ContainerHost<MainUiState, MainSideEffect> {

    override val container = container<MainUiState, MainSideEffect>(MainUiState())

    init {
        loadTemplates()
    }

    override fun onEvent(state: MainEvent) {
        when (state) {
            MainEvent.LoadTemplates -> loadTemplates()
            MainEvent.LoadNextPage -> loadNextPage()
            is MainEvent.OnSearchQueryChanged -> updateSearchQuery(state.query)
            is MainEvent.OnPokemonClicked -> onPokemonClicked(state.pokemon)
        }
    }

    private fun loadTemplates() {
        intent {
            if (state.isLoading) return@intent

            getAllTemplatesUseCase(page = 0).collect { result ->
                when (result) {
                    is Result.Loading -> reduce {
                        state.copy(
                            isLoading = true,
                            errorMessage = null
                        )
                    }

                    is Result.Success -> reduce {
                        state.copy(
                            pokemonList = result.data,
                            currentPage = 0,
                            isLoading = false,
                            errorMessage = null
                        )
                    }

                    is Result.Error -> reduce {
                        state.copy(
                            isLoading = false,
                            errorMessage = result.msg
                        )
                    }
                }
            }
        }
    }

    private fun loadNextPage() {
        intent {
            if (state.searchQuery.isNotBlank() || state.isLoadMoreLoading || state.isLoading) return@intent
            val nextPage = state.currentPage + 1

            getAllTemplatesUseCase(page = nextPage).collect { result ->
                when (result) {
                    is Result.Loading -> reduce {
                        state.copy(isLoadMoreLoading = true)
                    }

                    is Result.Success -> reduce {
                        val combined = (state.pokemonList + result.data).distinctBy { it.name }
                        state.copy(
                            pokemonList = combined,
                            currentPage = nextPage,
                            isLoadMoreLoading = false
                        )
                    }

                    is Result.Error -> reduce {
                        state.copy(isLoadMoreLoading = false)
                    }
                }
            }
        }
    }

    private fun updateSearchQuery(query: String) {
        intent {
            reduce {
                state.copy(searchQuery = query)
            }
        }
    }

    private fun onPokemonClicked(pokemon: Pokemon) {
        intent {
            postSideEffect(MainSideEffect.OpenPokemonDetail(pokemon.name))
        }
    }
}
