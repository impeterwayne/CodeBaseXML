package com.genesys.core.common

/**
 * @author : CuongNK
 * @created : 5/21/2025
 **/
object TimeUtils {
    private const val ONE_DAY_IN_MILLI_SEC: Long = 24 * 60 * 60 * 1000 // 1 day in milliseconds

    fun isTimeRangeValidForFetchingData(lastFetchTime: Long): Boolean {
        val currentTime = System.currentTimeMillis()
        return (currentTime - lastFetchTime) > ONE_DAY_IN_MILLI_SEC
    }
}
