package androidx.appcompat.widget;

import android.window.OnBackInvokedCallback;

public final /* synthetic */ class x implements OnBackInvokedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Runnable f211a;

    public /* synthetic */ x(Runnable runnable) {
        this.f211a = runnable;
    }

    public final void onBackInvoked() {
        this.f211a.run();
    }
}
