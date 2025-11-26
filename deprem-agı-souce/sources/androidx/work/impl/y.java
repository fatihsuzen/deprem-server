package androidx.work.impl;

import androidx.work.WorkRequest;
import k3.C2616a;

public final /* synthetic */ class y implements C2616a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkRequest f782a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WorkManagerImpl f783b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f784c;

    public /* synthetic */ y(WorkRequest workRequest, WorkManagerImpl workManagerImpl, String str) {
        this.f782a = workRequest;
        this.f783b = workManagerImpl;
        this.f784c = str;
    }

    public final Object invoke() {
        return WorkerUpdater.enqueueUniquelyNamedPeriodic$lambda$6$lambda$5(this.f782a, this.f783b, this.f784c);
    }
}
