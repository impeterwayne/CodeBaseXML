package com.genesys.v1.codebase.presenter.components.main

import com.genesys.v1.codebase.presenter.base.common.BaseViewModel

/**
 * @author : CuongNK
 * @created : 9/1/2025
 **/

class MainViewModel : BaseViewModel<MainViewModel.MainEvent>(){
    override fun onEvent(state: MainEvent) {

    }

    sealed class  MainEvent : IEvent{
        object Init : MainEvent()
    }
}