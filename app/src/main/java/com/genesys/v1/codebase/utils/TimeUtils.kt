package com.genesys.v1.codebase.utils

import com.genesys.v1.codebase.data.mmkv.MMKVData


/**
 * @author : CuongNK
 * @created : 5/21/2025
 **/
object TimeUtils {
    private const val ONE_DAY_IN_MILLI_SEC: Long = 24 * 60 * 60 * 1000 // 1 day in milliseconds

    fun isTimeRangeValidForFetchingData(): Boolean {
        val currentTime = System.currentTimeMillis()
        val lastFetchTime = MMKVData.lastFetchTemplateTime
        return (currentTime - lastFetchTime) > ONE_DAY_IN_MILLI_SEC
    }
}