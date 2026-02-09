package com.genesys.core.common;

/**
 * @author : CuongNK
 * @created : 5/21/2025
 *
 * TimeUtils provides time-range validation for data fetching.
 * Note: The lastFetchTime must be provided by the caller (e.g., from MMKVData in :core:data).
 */
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\b"}, d2 = {"Lcom/genesys/core/common/TimeUtils;", "", "()V", "ONE_DAY_IN_MILLI_SEC", "", "isTimeRangeValidForFetchingData", "", "lastFetchTime", "common_debug"})
public final class TimeUtils {
    private static final long ONE_DAY_IN_MILLI_SEC = 86400000L;
    @org.jetbrains.annotations.NotNull()
    public static final com.genesys.core.common.TimeUtils INSTANCE = null;
    
    private TimeUtils() {
        super();
    }
    
    /**
     * Check if enough time has passed since the last fetch.
     * @param lastFetchTime The timestamp of the last fetch in milliseconds
     * @return true if more than one day has passed since lastFetchTime
     */
    public final boolean isTimeRangeValidForFetchingData(long lastFetchTime) {
        return false;
    }
}