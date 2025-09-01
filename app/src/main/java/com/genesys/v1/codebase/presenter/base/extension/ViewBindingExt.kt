package com.genesys.v1.codebase.presenter.base.extension

import android.content.Context
import androidx.viewbinding.ViewBinding

val ViewBinding.context: Context
    get() = root.context
