package com.genesys.feature.template.main

import com.genesys.core.common.base.BaseViewModel

/**
 * @author : CuongNK
 * @created : 9/1/2025
 **/

class MainViewModel : BaseViewModel<MainViewModel.MainEvent>() {
    override fun onEvent(state: MainEvent) {

    }

    sealed class MainEvent : IEvent {
        object Init : MainEvent()
    }
}
