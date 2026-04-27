package com.genesys.feature.template.main

import com.genesys.core.common.base.BaseViewModel
import com.genesys.core.common.base.Result
import com.genesys.core.domain.usecase.template.GetAllTemplatesUseCase
import com.genesys.core.model.template.Template
import com.genesys.core.model.template.TemplateCollections
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getAllTemplatesUseCase: GetAllTemplatesUseCase
) : BaseViewModel<MainViewModel.MainEvent>() {

    private val _result = MutableStateFlow<Result<List<TemplateCollections>>>(Result.Initial())
    val result: StateFlow<Result<List<TemplateCollections>>> = _result.asStateFlow()

    override fun onEvent(state: MainEvent) {
        when (state) {
            is MainEvent.LoadTemplates -> loadTemplates()
            is MainEvent.OnTemplateClicked -> onTemplateClicked(state.template)
        }
    }

    init {
        loadTemplates()
    }

    private fun loadTemplates() {
        launchBlock(Dispatchers.IO) {
            getAllTemplatesUseCase().collect { result ->
                _result.update{result}
            }
        }
    }

    private fun onTemplateClicked(template: Template) {
        // Handle template click - can be expanded for navigation, detail view, etc.
    }

    sealed class MainEvent : IEvent {
        data object LoadTemplates : MainEvent()
        data class OnTemplateClicked(val template: Template) : MainEvent()
    }
}
