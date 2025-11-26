package androidx.core.view;

import android.view.View;
import k3.l;

public final class ViewKt$doOnAttach$1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ l $action;
    final /* synthetic */ View $this_doOnAttach;

    public ViewKt$doOnAttach$1(View view, l lVar) {
        this.$this_doOnAttach = view;
        this.$action = lVar;
    }

    public void onViewAttachedToWindow(View view) {
        this.$this_doOnAttach.removeOnAttachStateChangeListener(this);
        this.$action.invoke(view);
    }

    public void onViewDetachedFromWindow(View view) {
    }
}
