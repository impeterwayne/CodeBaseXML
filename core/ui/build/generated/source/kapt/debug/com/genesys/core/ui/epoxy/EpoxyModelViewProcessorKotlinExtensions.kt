@file:Suppress("DEPRECATION")

package com.genesys.core.ui.epoxy

import com.airbnb.epoxy.ModelCollector
import kotlin.Suppress
import kotlin.Unit

public inline
    fun ModelCollector.carouselNoSnap(modelInitializer: CarouselNoSnapModelBuilder.() -> Unit):
    Unit {
  add(
  CarouselNoSnapModel_().apply {
    modelInitializer()
  }
  )
}
