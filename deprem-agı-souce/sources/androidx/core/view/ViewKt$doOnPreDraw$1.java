package androidx.core.view;

import android.view.View;
import k3.l;

public final class ViewKt$doOnPreDraw$1 implements Runnable {
    final /* synthetic */ l $action;
    final /* synthetic */ View $this_doOnPreDraw;

    public ViewKt$doOnPreDraw$1(l lVar, View view) {
        this.$action = lVar;
        this.$this_doOnPreDraw = view;
    }

    public final void run() {
        this.$action.invoke(this.$this_doOnPreDraw);
    }
}
