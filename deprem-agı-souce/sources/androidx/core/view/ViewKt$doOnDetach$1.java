package androidx.core.view;

import android.view.View;
import k3.l;

public final class ViewKt$doOnDetach$1 implements View.OnAttachStateChangeListener {
    final /* synthetic */ l $action;
    final /* synthetic */ View $this_doOnDetach;

    public ViewKt$doOnDetach$1(View view, l lVar) {
        this.$this_doOnDetach = view;
        this.$action = lVar;
    }

    public void onViewAttachedToWindow(View view) {
    }

    public void onViewDetachedFromWindow(View view) {
        this.$this_doOnDetach.removeOnAttachStateChangeListener(this);
        this.$action.invoke(view);
    }
}
