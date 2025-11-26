package androidx.profileinstaller;

import androidx.profileinstaller.ProfileInstaller;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ProfileInstaller.DiagnosticsCallback f410a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f411b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f412c;

    public /* synthetic */ d(ProfileInstaller.DiagnosticsCallback diagnosticsCallback, int i5, Object obj) {
        this.f410a = diagnosticsCallback;
        this.f411b = i5;
        this.f412c = obj;
    }

    public final void run() {
        this.f410a.onDiagnosticReceived(this.f411b, this.f412c);
    }
}
