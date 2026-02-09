package com.genesys.codebase

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.genesys.codebase.databinding.ActivityMainBinding
import com.genesys.core.common.base.BaseActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>() {

    override fun getLazyViewBinding(): Lazy<ActivityMainBinding> = lazy<ActivityMainBinding> {
        DataBindingUtil.setContentView(this, R.layout.activity_main)
    }

    override fun initViews(savedInstanceState: Bundle?) {

    }
}
