package com.genesys.core.network.response

import androidx.annotation.Keep
import com.genesys.core.model.pagination.Meta
import com.genesys.core.model.template.TemplateCollections
import com.google.gson.annotations.SerializedName

@Keep
data class ResponseAITemplate(
    @SerializedName("data")
    val `data`: List<TemplateCollections> = listOf(),
    @SerializedName("meta")
    val meta: Meta = Meta()
)
