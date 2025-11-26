package androidx.work.impl;

import androidx.work.WorkRequest;
import k3.C2616a;

public final /* synthetic */ class A implements C2616a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkManagerImpl f519a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f520b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WorkRequest f521c;

    public /* synthetic */ A(WorkManagerImpl workManagerImpl, String str, WorkRequest workRequest) {
        this.f519a = workManagerImpl;
        this.f520b = str;
        this.f521c = workRequest;
    }

    public final Object invoke() {
        return WorkerUpdater.enqueueUniquelyNamedPeriodic$lambda$6(this.f519a, this.f520b, this.f521c);
    }
}
