package com.genesys.core.ui.epoxy

import android.view.View
import android.view.ViewParent
import androidx.viewbinding.ViewBinding
import com.airbnb.epoxy.EpoxyHolder
import com.airbnb.epoxy.EpoxyModelWithHolder
import java.lang.reflect.Method
import java.lang.reflect.ParameterizedType
import java.util.concurrent.ConcurrentHashMap

/**
 * @author : CuongNK
 * @created : 10/4/2024
 **/
abstract class BaseEpoxyViewBindingHolder<in T : ViewBinding> : EpoxyModelWithHolder<ViewBindingHolder>() {

    @Suppress("UNCHECKED_CAST")
    override fun bind(holder: ViewBindingHolder) {
        (holder.viewBinding as T).bind()
    }

    abstract fun T.bind()

    @Suppress("UNCHECKED_CAST")
    override fun unbind(holder: ViewBindingHolder) {
        (holder.viewBinding as T).unbind()
    }

    open fun T.unbind() {}

    override fun createNewHolder(parent: ViewParent): ViewBindingHolder {
        return ViewBindingHolder(this::class.java)
    }
}

private val sBindingMethodByClass = ConcurrentHashMap<Class<*>, Method>()

@Suppress("UNCHECKED_CAST")
@Synchronized
private fun getBindMethodFrom(javaClass: Class<*>): Method =
    sBindingMethodByClass.getOrPut(javaClass) {
        val actualTypeOfThis = getSuperclassParameterizedType(javaClass)
        val viewBindingClass = actualTypeOfThis.actualTypeArguments[0] as Class<ViewBinding>
        viewBindingClass.getDeclaredMethod("bind", View::class.java)
            ?: error("The binder class ${javaClass.canonicalName} should have a method bind(View)")
    }

private fun getSuperclassParameterizedType(klass: Class<*>): ParameterizedType {
    val genericSuperclass = klass.genericSuperclass
    return (genericSuperclass as? ParameterizedType)
        ?: getSuperclassParameterizedType(genericSuperclass as Class<*>)
}

class ViewBindingHolder(private val epoxyModelClass: Class<*>) : EpoxyHolder() {
    private val bindingMethod by lazy { getBindMethodFrom(epoxyModelClass) }

    internal lateinit var viewBinding: ViewBinding
    override fun bindView(itemView: View) {
        viewBinding = bindingMethod.invoke(null, itemView) as ViewBinding
    }
}
