package androidx.work.impl;

import androidx.work.WorkerParameters;

public final /* synthetic */ class r implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkLauncherImpl f733a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ StartStopToken f734b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WorkerParameters.RuntimeExtras f735c;

    public /* synthetic */ r(WorkLauncherImpl workLauncherImpl, StartStopToken startStopToken, WorkerParameters.RuntimeExtras runtimeExtras) {
        this.f733a = workLauncherImpl;
        this.f734b = startStopToken;
        this.f735c = runtimeExtras;
    }

    public final void run() {
        WorkLauncherImpl.startWork$lambda$0(this.f733a, this.f734b, this.f735c);
    }
}
