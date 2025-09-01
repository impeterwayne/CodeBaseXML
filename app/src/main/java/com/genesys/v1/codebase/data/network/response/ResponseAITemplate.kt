package com.genesys.v1.codebase.data.network.response

import com.squareup.moshi.Json
import androidx.annotation.Keep
import com.genesys.v1.codebase.domain.model.pagination.Meta
import com.genesys.v1.codebase.domain.model.template.TemplateCollections

@Keep
data class ResponseAITemplate(
    @Json(name = "data")
    val `data`: List<TemplateCollections> = listOf(),
    @Json(name = "meta")
    val meta: Meta = Meta()
)