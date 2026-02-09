package com.genesys.codebase

import android.app.Application
import com.tencent.mmkv.MMKV
import dagger.hilt.android.HiltAndroidApp

/**
 * @author : CuongNK
 * @created : 9/1/2025
 **/

@HiltAndroidApp
class App : Application() {
    override fun onCreate() {
        super.onCreate()
        MMKV.initialize(this)
    }
}