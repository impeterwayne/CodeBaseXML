package com.genesys.v1.codebase.ui.base.common

import android.graphics.Color
import android.net.ConnectivityManager
import android.net.Network
import android.net.NetworkCapabilities
import android.net.NetworkRequest
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.activity.enableEdgeToEdge
import androidx.annotation.CallSuper
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.databinding.ViewDataBinding
import com.genesys.v1.codebase.ui.base.extension.collectLatestRepeatOnLifecycle

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
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setLocale()

        viewBinding.lifecycleOwner = this@BaseActivity
        makeDarkStatusBars()
        registerBackPressedDispatcher()

        initViews(savedInstanceState)
        initAds()
        initObservers()
        initListeners()

        observerNetworkState()
        observerHasPurchase()
    }

    private fun makeDarkStatusBars() {
        WindowCompat.setDecorFitsSystemWindows(window, isFitsSystemWindows())
        WindowInsetsControllerCompat(window, window.decorView).let { controller ->
            controller.isAppearanceLightStatusBars = false
            controller.isAppearanceLightNavigationBars = false
            if (isHideSystemBars()) {
                controller.hide(WindowInsetsCompat.Type.systemBars())
            } else {
                controller.hide(WindowInsetsCompat.Type.navigationBars())
            }
            controller.systemBarsBehavior =
                WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
        }
    }

    protected open fun setupStatusBar() {
        window.statusBarColor = Color.TRANSPARENT
        window.decorView.systemUiVisibility =
            View.SYSTEM_UI_FLAG_LAYOUT_STABLE or
                    View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN

    }

    protected open fun isFitsSystemWindows(): Boolean = true
    protected open fun isHideSystemBars(): Boolean = false

    protected fun applyInsetToView(
        targetView: View,
        block: (view: View, insets: WindowInsetsCompat) -> Unit
    ) {
        ViewCompat.setOnApplyWindowInsetsListener(targetView) { view, insetCompact ->
            block(view, insetCompact)
            return@setOnApplyWindowInsetsListener WindowInsetsCompat.CONSUMED
        }
    }

    private fun registerBackPressedDispatcher() {
        onBackPressedDispatcher.addCallback(this@BaseActivity, onBackPressedCallback)
        onBackPressedCallback.isEnabled = onHandleBackPressed()
    }

    /**
     * Custom BackPressed
     * ```
     * override fun onHandleBackPressed(onBackPressed: OnPerformBackPressed?): Boolean {
     *     return super.onHandleBackPressed {
     *         finish()
     *     }
     * }
     * ```
     * @param onBackPressed The callback to add
     *
     * @return The default enabled state for this callback.
     */
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

    private fun setLocale() {
//        val language = SystemUtil.getPreLanguage(this)
//        language?.let {
//            val locale = Locale(it)
//            Locale.setDefault(locale)
//            val config = Configuration().apply {
//                setLocale(locale)
//            }
//            resources.updateConfiguration(config, resources.displayMetrics)
//        }
    }

    protected fun withViewModels(block: VM.() -> Unit) {
        with(viewModel, block)
    }

    protected fun withViewBindings(block: VB.() -> Unit) {
        with(viewBinding, block)
    }

    override fun onDestroy() {
        unregisterNetworkCallback()
        super.onDestroy()
    }
}
