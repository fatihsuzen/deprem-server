package androidx.constraintlayout.motion.widget;

import android.view.View;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ViewTransition f240a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View[] f241b;

    public /* synthetic */ a(ViewTransition viewTransition, View[] viewArr) {
        this.f240a = viewTransition;
        this.f241b = viewArr;
    }

    public final void run() {
        ViewTransition.a(this.f240a, this.f241b);
    }
}
