package androidx.core.view;

import android.view.View;
import k3.l;

public final class ViewKt$doOnNextLayout$1 implements View.OnLayoutChangeListener {
    final /* synthetic */ l $action;

    public ViewKt$doOnNextLayout$1(l lVar) {
        this.$action = lVar;
    }

    public void onLayoutChange(View view, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12) {
        view.removeOnLayoutChangeListener(this);
        this.$action.invoke(view);
    }
}
