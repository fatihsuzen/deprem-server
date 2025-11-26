package androidx.core.app;

import android.app.Activity;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Activity f242a;

    public /* synthetic */ a(Activity activity) {
        this.f242a = activity;
    }

    public final void run() {
        ActivityCompat.a(this.f242a);
    }
}
