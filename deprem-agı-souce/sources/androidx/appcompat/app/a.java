package androidx.appcompat.app;

import android.content.Context;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f201a;

    public /* synthetic */ a(Context context) {
        this.f201a = context;
    }

    public final void run() {
        AppCompatDelegate.a(this.f201a);
    }
}
