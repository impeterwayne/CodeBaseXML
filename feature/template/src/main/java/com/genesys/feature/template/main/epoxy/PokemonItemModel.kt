package com.genesys.feature.template.main.epoxy

import com.airbnb.epoxy.EpoxyAttribute
import com.airbnb.epoxy.EpoxyModelClass
import com.bumptech.glide.Glide
import com.genesys.core.model.pokemon.Pokemon
import com.genesys.core.ui.epoxy.BaseEpoxyViewBindingHolder
import com.genesys.feature.template.R
import com.genesys.feature.template.databinding.ItemTemplateBinding

@EpoxyModelClass
abstract class PokemonItemModel : BaseEpoxyViewBindingHolder<ItemTemplateBinding>() {

    @EpoxyAttribute
    open var pokemon: Pokemon = Pokemon()

    @EpoxyAttribute(EpoxyAttribute.Option.DoNotHash)
    open var onItemClick: (() -> Unit)? = null

    override fun getDefaultLayout(): Int = R.layout.item_template

    override fun ItemTemplateBinding.bind() {
        tvPokemonNumber.text = pokemon.getFormattedNumber()
        tvPokemonName.text = pokemon.getDisplayName()

        Glide.with(imgArtwork)
            .load(pokemon.imageUrl)
            .placeholder(android.R.drawable.ic_menu_gallery)
            .error(android.R.drawable.ic_menu_gallery)
            .into(imgArtwork)

        root.setOnClickListener { onItemClick?.invoke() }
    }

    override fun ItemTemplateBinding.unbind() {
        Glide.with(imgArtwork).clear(imgArtwork)
        root.setOnClickListener(null)
    }
}
