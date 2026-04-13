package com.genesys.core.common.base

import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.databinding.ViewDataBinding
import com.gyf.immersionbar.BarHide
import com.gyf.immersionbar.ktx.fitsTitleBar
import com.gyf.immersionbar.ktx.immersionBar
import com.gyf.immersionbar.ktx.showStatusBar

typealias OnPerformBackPressed = () -> Unit

abstract class BaseActivity<VB> : AppCompatActivity()
        where VB : ViewDataBinding {

    protected val viewBinding: VB by this.getLazyViewBinding()
    abstract fun getLazyViewBinding(): Lazy<VB>

    private var onPerformBackPressed: OnPerformBackPressed? = null
    private var onBackPressedCallback = object : OnBackPressedCallback(enabled = true) {
        override fun handleOnBackPressed() {
            onPerformBackPressed?.invoke()
        }
    }
    protected open fun statusBarInsetTarget(): View? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        setupInit()
        super.onCreate(savedInstanceState)

        viewBinding.lifecycleOwner = this@BaseActivity
        registerBackPressedDispatcher()
        setupWindowInsets()
        initViews(savedInstanceState)
        initAds()
        initListeners()
        initImmersiveBar()
        initObservers()
    }
    protected open fun isForceDarkMode() : Boolean = true
    protected open fun isFitsSystemWindows(): Boolean = false
    protected open fun isHideSystemBars(): Boolean = true

    private fun initImmersiveBar() {
        immersionBar {
            transparentBar()
            statusBarDarkFont(isForceDarkMode())
            fitsSystemWindows(isFitsSystemWindows())
            if (isHideSystemBars()) {
                hideBar(BarHide.FLAG_HIDE_NAVIGATION_BAR)
                navigationBarEnable(false)
                navigationBarWithKitkatEnable(false)
                navigationBarWithEMUI3Enable(false)
            }
        }
        showStatusBar()
    }

    private fun registerBackPressedDispatcher() {
        onBackPressedDispatcher.addCallback(this@BaseActivity, onBackPressedCallback)
        onBackPressedCallback.isEnabled = onHandleBackPressed()
    }

    @CallSuper
    protected open fun onHandleBackPressed(onBackPressed: OnPerformBackPressed? = null): Boolean {
        this.onPerformBackPressed = onBackPressed
        return onBackPressed != null
    }

    protected open fun setupInit() = Unit

    abstract fun initViews(savedInstanceState: Bundle?)
    protected open fun initAds() = Unit
    protected open fun initObservers() = Unit

    protected open fun initListeners() = Unit

    protected fun withViewBindings(block: VB.() -> Unit) {
        with(viewBinding, block)
    }
    private fun setupWindowInsets() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        applyStatusBarPadding(statusBarInsetTarget())
    }

    private fun applyStatusBarPadding(view: View?) {
        view?.let { fitsTitleBar(it) }
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
