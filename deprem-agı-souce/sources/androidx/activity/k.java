package androidx.activity;

import android.window.OnBackInvokedCallback;
import androidx.activity.OnBackPressedDispatcher;
import k3.C2616a;

public final /* synthetic */ class k implements OnBackInvokedCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ C2616a f188a;

    public /* synthetic */ k(C2616a aVar) {
        this.f188a = aVar;
    }

    public final void onBackInvoked() {
        OnBackPressedDispatcher.Api33Impl.createOnBackInvokedCallback$lambda$0(this.f188a);
    }
}
