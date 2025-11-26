package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import k3.C2616a;
import k3.l;

public final /* synthetic */ class v implements C2616a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f768a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WorkDatabase f769b;

    public /* synthetic */ v(l lVar, WorkDatabase workDatabase) {
        this.f768a = lVar;
        this.f769b = workDatabase;
    }

    public final Object invoke() {
        return StatusRunnable.loadStatusFuture$lambda$5(this.f768a, this.f769b);
    }
}
