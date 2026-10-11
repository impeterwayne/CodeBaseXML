package com.genesys.feature.template.main

import android.view.View
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.genesys.core.common.extension.collectRepeatOnLifecycle
import com.genesys.core.model.pokemon.Pokemon
import com.genesys.core.ui.base.BaseFragment
import com.genesys.feature.template.R
import com.genesys.feature.template.databinding.FragmentMainBinding
import com.genesys.feature.template.main.epoxy.pokemonItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private val mainViewModel: MainViewModel by viewModels()

    override fun initViews() {
        val layoutManager = GridLayoutManager(requireContext(), 2)
        viewBinding.rcvTemplates.layoutManager = layoutManager

        viewBinding.rcvTemplates.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0) {
                    val visibleItemCount = layoutManager.childCount
                    val totalItemCount = layoutManager.itemCount
                    val firstVisibleItemPosition = layoutManager.findFirstVisibleItemPosition()

                    if (visibleItemCount + firstVisibleItemPosition >= totalItemCount - 4 && firstVisibleItemPosition >= 0) {
                        mainViewModel.onEvent(MainEvent.LoadNextPage)
                    }
                }
            }
        })
    }

    override fun initListeners() {
        viewBinding.etSearch.addTextChangedListener { text ->
            mainViewModel.onEvent(MainEvent.OnSearchQueryChanged(text?.toString().orEmpty()))
        }

        viewBinding.layoutError.btnMessageStateAction.setOnClickListener {
            mainViewModel.onEvent(MainEvent.LoadTemplates)
        }
    }

    override fun initObservers() {
        viewLifecycleOwner.collectRepeatOnLifecycle(mainViewModel.container.stateFlow) { state ->
            renderUiState(state)
        }

        viewLifecycleOwner.collectRepeatOnLifecycle(mainViewModel.container.sideEffectFlow) { effect ->
            handleSideEffect(effect)
        }
    }

    private fun renderUiState(state: MainUiState) {
        val isInitialLoading = state.isLoading && state.pokemonList.isEmpty()
        viewBinding.progressLoading.visibility = if (isInitialLoading) View.VISIBLE else View.GONE

        val hasError = state.errorMessage != null && state.pokemonList.isEmpty()
        viewBinding.layoutError.root.visibility = if (hasError) View.VISIBLE else View.GONE
        if (hasError) {
            viewBinding.layoutError.tvMessageStateText.text =
                state.errorMessage ?: getString(R.string.template_failed_to_load)
        }

        val showGrid = !isInitialLoading && !hasError
        viewBinding.rcvTemplates.visibility = if (showGrid) View.VISIBLE else View.GONE
        if (showGrid) {
            setupEpoxy(state.filteredPokemon)
        }
    }

    private fun setupEpoxy(pokemonList: List<Pokemon>) {
        viewBinding.rcvTemplates.withModels {
            pokemonList.forEach { pokemon ->
                pokemonItem {
                    id("pokemon_${pokemon.name}_${pokemon.index}")
                    pokemon(pokemon)
                    onItemClick {
                        mainViewModel.onEvent(MainEvent.OnPokemonClicked(pokemon))
                    }
                }
            }
        }
    }

    private fun handleSideEffect(effect: MainSideEffect) {
        when (effect) {
            is MainSideEffect.OpenPokemonDetail -> Unit
        }
    }
}
