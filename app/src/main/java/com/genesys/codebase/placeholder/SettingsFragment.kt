package com.genesys.codebase.placeholder

import com.genesys.codebase.databinding.FragmentSettingsBinding
import com.genesys.core.ui.R as UiR
import com.genesys.core.ui.base.BaseFragment

/**
 * Placeholder fragment for Settings tab destination.
 */
class SettingsFragment : BaseFragment<FragmentSettingsBinding>(FragmentSettingsBinding::inflate) {

    override fun initViews() {
        viewBinding.tvTitle.setText(UiR.string.nav_feature3)
    }
}
