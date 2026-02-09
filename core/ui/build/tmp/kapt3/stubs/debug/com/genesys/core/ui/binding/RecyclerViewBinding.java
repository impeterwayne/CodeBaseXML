package com.genesys.core.ui.binding;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\n\u0010\u0007\u001a\u0006\u0012\u0002\b\u00030\bH\u0007J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\nH\u0007\u00a8\u0006\u000b"}, d2 = {"Lcom/genesys/core/ui/binding/RecyclerViewBinding;", "", "()V", "bindAdapter", "", "view", "Landroidx/recyclerview/widget/RecyclerView;", "adapter", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Landroidx/viewpager2/widget/ViewPager2;", "Landroidx/viewpager2/adapter/FragmentStateAdapter;", "ui_debug"})
public final class RecyclerViewBinding {
    @org.jetbrains.annotations.NotNull()
    public static final com.genesys.core.ui.binding.RecyclerViewBinding INSTANCE = null;
    
    private RecyclerViewBinding() {
        super();
    }
    
    @kotlin.jvm.JvmStatic()
    @androidx.databinding.BindingAdapter(value = {"adapter"})
    public static final void bindAdapter(@org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView view, @org.jetbrains.annotations.NotNull()
    androidx.recyclerview.widget.RecyclerView.Adapter<?> adapter) {
    }
    
    @kotlin.jvm.JvmStatic()
    @androidx.databinding.BindingAdapter(value = {"adapter"})
    public static final void bindAdapter(@org.jetbrains.annotations.NotNull()
    androidx.viewpager2.widget.ViewPager2 view, @org.jetbrains.annotations.NotNull()
    androidx.viewpager2.adapter.FragmentStateAdapter adapter) {
    }
}