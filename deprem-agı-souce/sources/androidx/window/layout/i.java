package androidx.window.layout;

import androidx.window.layout.SidecarWindowBackend;

public final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SidecarWindowBackend.WindowLayoutChangeCallbackWrapper f495a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WindowLayoutInfo f496b;

    public /* synthetic */ i(SidecarWindowBackend.WindowLayoutChangeCallbackWrapper windowLayoutChangeCallbackWrapper, WindowLayoutInfo windowLayoutInfo) {
        this.f495a = windowLayoutChangeCallbackWrapper;
        this.f496b = windowLayoutInfo;
    }

    public final void run() {
        SidecarWindowBackend.WindowLayoutChangeCallbackWrapper.m204accept$lambda0(this.f495a, this.f496b);
    }
}
