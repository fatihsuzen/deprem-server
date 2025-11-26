package androidx.profileinstaller;

import android.content.Context;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Context f416a;

    public /* synthetic */ g(Context context) {
        this.f416a = context;
    }

    public final void run() {
        ProfileInstaller.writeProfile(this.f416a);
    }
}
