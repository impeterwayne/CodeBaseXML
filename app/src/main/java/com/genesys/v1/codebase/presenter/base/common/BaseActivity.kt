package com.genesys.v1.codebase.presenter.base.common

import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.WindowCompat
import androidx.databinding.ViewDataBinding
import com.genesys.v1.codebase.presenter.base.extension.collectLatestRepeatOnLifecycle
import com.gyf.immersionbar.BarHide
import com.gyf.immersionbar.ktx.fitsTitleBar
import com.gyf.immersionbar.ktx.immersionBar
import com.gyf.immersionbar.ktx.showStatusBar

typealias OnPerformBackPressed = () -> Unit

abstract class BaseActivity<VB, VM, Event> : AppCompatActivity()
        where VB : ViewDataBinding, VM : BaseViewModel<Event>, Event : BaseViewModel.IEvent {

    protected val viewModel: VM by this.getLazyViewModel()
    abstract fun getLazyViewModel(): Lazy<VM>

    protected val viewBinding: VB by this.getLazyViewBinding()
    abstract fun getLazyViewBinding(): Lazy<VB>

    private var onPerformBackPressed: OnPerformBackPressed? = null
    private var onBackPressedCallback = object : OnBackPressedCallback(enabled = true) {
        override fun handleOnBackPressed() {
            onPerformBackPressed?.invoke()
        }
    }
    protected open fun statusBarInsetTargets(): List<View> = emptyList()

    private val connectivityManager: ConnectivityManager? by lazy {
        ContextCompat.getSystemService(this@BaseActivity, ConnectivityManager::class.java)
    }
    private val networkCallback = object : ConnectivityManager.NetworkCallback() {
        override fun onAvailable(network: Network) {
            super.onAvailable(network)
            runOnUiThread {
                viewModel.setNetworkState(true)
            }
        }

        override fun onLost(network: Network) {
            super.onLost(network)
            runOnUiThread {
                viewModel.setNetworkState(false)
            }
        }
    }

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
        observerNetworkState()
        observerHasPurchase()
    }
    protected open fun isForceDarkMode() : Boolean = true
    protected open fun isFitsSystemWindows(): Boolean = true
    protected open fun isHideSystemBars(): Boolean = true

    private fun initImmersiveBar() {
        immersionBar {
            transparentBar()
            if(isForceDarkMode()){
                statusBarDarkFont(true)
            }else{
                autoDarkModeEnable(true)
            }
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
    protected open fun initObservers() {
        viewModel
    }

    protected open fun initListeners() = Unit

    private fun observerNetworkState() {
        collectLatestRepeatOnLifecycle(viewModel.networkState) {
            onNetworkState(it)
        }
    }

    protected open fun onNetworkState(connected: Boolean) = Unit
    private fun observerHasPurchase() {
        collectLatestRepeatOnLifecycle(viewModel.purchaseState) {
            onDeviceHasPurchase(it)
        }
    }

    protected open fun onDeviceHasPurchase(hasPurchase: Boolean) = Unit

    protected fun registerNetworkCallback() {
        connectivityManager?.runCatching {
            try {
                val request = NetworkRequest.Builder()
                    .addCapability(NetworkCapabilities.NET_CAPABILITY_NOT_VPN)
                    .build()
                requestNetwork(request, networkCallback)
            } catch (e: Exception) {
                registerDefaultNetworkCallback(networkCallback)
            }
        }
    }

    protected fun unregisterNetworkCallback() {
        connectivityManager?.runCatching {
            unregisterNetworkCallback(networkCallback)
        }
    }

    protected fun withViewModels(block: VM.() -> Unit) {
        with(viewModel, block)
    }

    protected fun withViewBindings(block: VB.() -> Unit) {
        with(viewBinding, block)
    }
    private fun setupWindowInsets() {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        val targets = statusBarInsetTargets()
        if (targets.isNotEmpty()) {
            applyStatusBarPadding(*targets.toTypedArray())
        } else {
            applyStatusBarPadding()
        }
    }

    private fun applyStatusBarPadding(vararg views: View) {
        views.forEach { view ->
            fitsTitleBar(view)
        }
    }

    override fun onDestroy() {
        unregisterNetworkCallback()
        super.onDestroy()
    }
}
