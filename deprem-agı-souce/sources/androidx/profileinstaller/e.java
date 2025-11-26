package androidx.profileinstaller;

import android.content.Context;
import android.view.Choreographer;

public final /* synthetic */ class e implements Choreographer.FrameCallback {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProfileInstallerInitializer f413a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f414b;

    public /* synthetic */ e(ProfileInstallerInitializer profileInstallerInitializer, Context context) {
        this.f413a = profileInstallerInitializer;
        this.f414b = context;
    }

    public final void doFrame(long j5) {
        this.f413a.installAfterDelay(this.f414b);
    }
}
