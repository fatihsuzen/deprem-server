package androidx.profileinstaller;

import androidx.profileinstaller.ProfileInstaller;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProfileInstaller.DiagnosticsCallback f407a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f408b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f409c;

    public /* synthetic */ c(ProfileInstaller.DiagnosticsCallback diagnosticsCallback, int i5, Object obj) {
        this.f407a = diagnosticsCallback;
        this.f408b = i5;
        this.f409c = obj;
    }

    public final void run() {
        this.f407a.onResultReceived(this.f408b, this.f409c);
    }
}
