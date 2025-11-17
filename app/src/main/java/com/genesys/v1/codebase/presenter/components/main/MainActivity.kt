package com.genesys.v1.codebase.presenter.components.main

import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.genesys.v1.codebase.R
import com.genesys.v1.codebase.databinding.ActivityMainBinding
import com.genesys.v1.codebase.presenter.base.common.BaseActivity

class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLazyViewBinding(): Lazy<ActivityMainBinding> = lazy<ActivityMainBinding> {
        DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    override fun initViews(savedInstanceState: Bundle?) {

    }
}