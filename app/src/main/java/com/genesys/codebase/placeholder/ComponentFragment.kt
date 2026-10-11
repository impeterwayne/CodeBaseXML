package com.genesys.codebase.placeholder

import com.genesys.codebase.databinding.FragmentComponentBinding
import com.genesys.core.ui.R as UiR
import com.genesys.core.ui.base.BaseFragment

/**
 * Placeholder fragment for Component tab destination.
 */
class ComponentFragment : BaseFragment<FragmentComponentBinding>(FragmentComponentBinding::inflate) {

    override fun initViews() {
        viewBinding.tvTitle.setText(UiR.string.nav_feature1)
    }
}
