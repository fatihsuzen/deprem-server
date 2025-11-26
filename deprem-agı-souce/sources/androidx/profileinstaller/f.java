package androidx.profileinstaller;

import android.content.Context;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f415a;

    public /* synthetic */ f(Context context) {
        this.f415a = context;
    }

    public final void run() {
        ProfileInstallerInitializer.writeInBackground(this.f415a);
    }
}
