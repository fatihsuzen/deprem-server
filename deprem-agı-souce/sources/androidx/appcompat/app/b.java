package androidx.appcompat.app;

import android.content.Context;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f202a;

    public /* synthetic */ b(Context context) {
        this.f202a = context;
    }

    public final void run() {
        AppCompatDelegate.syncRequestedAndStoredLocales(this.f202a);
    }
}
