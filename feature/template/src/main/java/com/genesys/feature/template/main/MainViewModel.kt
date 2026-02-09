package com.genesys.feature.template.main

import com.genesys.core.common.base.BaseViewModel
import com.genesys.core.domain.repository.template.TemplateRepository
import com.genesys.core.model.template.Template
import com.genesys.core.model.template.TemplateCollections
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val templateRepository: TemplateRepository
) : BaseViewModel<MainViewModel.MainEvent>() {

    private val _templateCollections = MutableStateFlow<List<TemplateCollections>>(emptyList())
    val templateCollections: StateFlow<List<TemplateCollections>> = _templateCollections.asStateFlow()

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage.asStateFlow()

    override fun onEvent(state: MainEvent) {
        when (state) {
            is MainEvent.LoadTemplates -> loadTemplates()
            is MainEvent.OnTemplateClicked -> onTemplateClicked(state.template)
        }
    }

    private fun loadTemplates() {
        launchBlock {
            templateRepository.getAllTemplates(
                onStart = {
                    _isLoading.value = true
                    _errorMessage.value = null
                },
                onCompleted = {
                    _isLoading.value = false
                },
                onError = { message ->
                    _errorMessage.value = message ?: "Failed to load templates"
                }
            ).collect { collections ->
                _templateCollections.value = collections
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
