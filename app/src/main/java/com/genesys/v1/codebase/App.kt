package com.genesys.v1.codebase

import android.app.Application
import com.tencent.mmkv.MMKV

/**
 * @author : CuongNK
 * @created : 9/1/2025
 **/

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        MMKV.initialize(this)
    }
}