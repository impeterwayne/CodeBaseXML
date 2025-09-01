package com.genesys.v1.codebase.ui.base.extension

import android.content.Context
import androidx.viewbinding.ViewBinding

val ViewBinding.context: Context
    get() = root.context
