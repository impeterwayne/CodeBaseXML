package com.genesys.core.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.viewbinding.ViewBinding
import com.gyf.immersionbar.BarHide
import com.gyf.immersionbar.ktx.fitsTitleBar
import com.gyf.immersionbar.ktx.immersionBar
import com.gyf.immersionbar.ktx.showStatusBar

typealias OnPerformBackPressed = () -> Unit

abstract class BaseActivity<VB : ViewBinding>(
    private val inflate: (LayoutInflater) -> VB
) : AppCompatActivity() {

    lateinit var mBinding: VB

    private var onPerformBackPressed: OnPerformBackPressed? = null
    private var onBackPressedCallback = object : OnBackPressedCallback(enabled = true) {
        override fun handleOnBackPressed() {
            onPerformBackPressed?.invoke()
        }
    }

    protected open fun statusBarInsetTarget(): View? = null
    protected open fun isForceDarkMode(): Boolean = true
    protected open fun isFitsSystemWindows(): Boolean = false
    protected open fun isHideSystemBars(): Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        setupInit()
        super.onCreate(savedInstanceState)
        requestWindow()
        mBinding = inflate(layoutInflater)
        setContentView(mBinding.root)
        registerBackPressedDispatcher()
        setupWindowInsets()
        initImmersiveBar()
        initViews()
        onResizeViews()
        onClickViews()
        observeData()
    }

    open fun requestWindow() = Unit
    open fun initViews() = Unit
    open fun onResizeViews() = Unit
    open fun onClickViews() = Unit
    open fun observeData() = Unit

    protected open fun setupInit() = Unit

    open fun initImmersiveBar() {
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

    private fun setupWindowInsets() {
        applyStatusBarPadding(statusBarInsetTarget())
    }

    private fun applyStatusBarPadding(view: View?) {
        view?.let { fitsTitleBar(it) }
    }
}
