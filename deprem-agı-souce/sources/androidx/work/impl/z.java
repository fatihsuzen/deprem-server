package androidx.work.impl;

import androidx.work.WorkRequest;
import k3.C2616a;

public final /* synthetic */ class z implements C2616a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkManagerImpl f785a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WorkRequest f786b;

    public /* synthetic */ z(WorkManagerImpl workManagerImpl, WorkRequest workRequest) {
        this.f785a = workManagerImpl;
        this.f786b = workRequest;
    }

    public final Object invoke() {
        return WorkerUpdater.updateWorkImpl$lambda$4(this.f785a, this.f786b);
    }
}
