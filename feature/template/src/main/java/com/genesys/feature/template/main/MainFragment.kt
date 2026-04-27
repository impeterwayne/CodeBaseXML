package com.genesys.feature.template.main

import android.view.View
import androidx.fragment.app.viewModels
import com.airbnb.epoxy.Carousel
import com.genesys.core.common.base.BaseFragment
import com.genesys.core.common.base.Result
import com.genesys.core.common.extension.collectRepeatOnLifecycle
import com.genesys.core.model.template.TemplateCollections
import com.genesys.core.ui.epoxy.carouselNoSnapBuilder
import com.genesys.feature.template.databinding.FragmentMainBinding
import com.genesys.feature.template.main.epoxy.templateCollectionHeader
import com.genesys.feature.template.main.epoxy.templateItem
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : BaseFragment<FragmentMainBinding>(FragmentMainBinding::inflate) {

    private val mainViewModel: MainViewModel by viewModels()

    override fun initViews() {

    }

    override fun initObservers() {
        viewLifecycleOwner.collectRepeatOnLifecycle(mainViewModel.result) { result ->
            renderResult(result)
        }
    }

    override fun initListeners() {
        viewBinding.layoutError.btnMessageStateAction.setOnClickListener {
            mainViewModel.onEvent(MainViewModel.MainEvent.LoadTemplates)
        }
    }

    private fun renderResult(result: Result<List<TemplateCollections>>) {
        when (result) {
            is Result.Initial -> {
                viewBinding.progressLoading.visibility = View.GONE
                viewBinding.rcvTemplates.visibility = View.VISIBLE
                viewBinding.layoutError.root.visibility = View.GONE
            }

            is Result.Loading -> {
                viewBinding.progressLoading.visibility = View.VISIBLE
                viewBinding.rcvTemplates.visibility = View.GONE
                viewBinding.layoutError.root.visibility = View.GONE
            }

            is Result.Success -> {
                viewBinding.progressLoading.visibility = View.GONE
                viewBinding.rcvTemplates.visibility = View.VISIBLE
                viewBinding.layoutError.root.visibility = View.GONE
                setupEpoxy(result.data)
            }

            is Result.Error -> {
                viewBinding.progressLoading.visibility = View.GONE
                viewBinding.rcvTemplates.visibility = View.VISIBLE
                viewBinding.layoutError.root.visibility = View.VISIBLE
                viewBinding.layoutError.tvMessageStateText.text =
                    result.msg ?: "Failed to load templates"
            }
        }
    }

    private fun setupEpoxy(collections: List<TemplateCollections>) {
        viewBinding.rcvTemplates.withModels {
            collections.forEach { collection ->
                // Section Header
                templateCollectionHeader {
                    id("header_${collection.id}")
                    collectionName(collection.name)
                }

                // Horizontal carousel of template items
                carouselNoSnapBuilder {
                    id("carousel_${collection.id}")
                    padding(Carousel.Padding.dp(16, 0, 16, 0, 8))

                    collection.templates.forEach { template ->
                        templateItem {
                            id("template_${template.id}")
                            template(template)
                            onItemClick {
                                mainViewModel.onEvent(
                                    MainViewModel.MainEvent.OnTemplateClicked(template)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
