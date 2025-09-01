package com.genesys.v1.codebase.domain.model.pagination


import com.squareup.moshi.Json
import androidx.annotation.Keep

@Keep
data class Meta(
    @Json(name = "pagination")
    val pagination: Pagination = Pagination()
)