package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import k3.C2616a;

public final /* synthetic */ class u implements C2616a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkDatabase f767a;

    public /* synthetic */ u(WorkDatabase workDatabase) {
        this.f767a = workDatabase;
    }

    public final Object invoke() {
        return PruneWorkRunnableKt.pruneWork$lambda$0(this.f767a);
    }
}
