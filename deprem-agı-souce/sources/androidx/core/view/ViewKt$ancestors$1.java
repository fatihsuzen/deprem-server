package androidx.core.view;

import android.view.ViewParent;
import k3.l;
import kotlin.jvm.internal.C2639q;

/* synthetic */ class ViewKt$ancestors$1 extends C2639q implements l {
    public static final ViewKt$ancestors$1 INSTANCE = new ViewKt$ancestors$1();

    ViewKt$ancestors$1() {
        super(1, ViewParent.class, "getParent", "getParent()Landroid/view/ViewParent;", 0);
    }

    public final ViewParent invoke(ViewParent viewParent) {
        return viewParent.getParent();
    }
}
