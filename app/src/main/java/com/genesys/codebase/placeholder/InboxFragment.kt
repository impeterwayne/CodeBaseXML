package com.genesys.codebase.placeholder

import com.genesys.codebase.databinding.FragmentInboxBinding
import com.genesys.core.ui.R as UiR
import com.genesys.core.ui.base.BaseFragment

/**
 * Placeholder fragment for Inbox tab destination.
 */
class InboxFragment : BaseFragment<FragmentInboxBinding>(FragmentInboxBinding::inflate) {

    override fun initViews() {
        viewBinding.tvTitle.setText(UiR.string.nav_feature2)
    }
}
