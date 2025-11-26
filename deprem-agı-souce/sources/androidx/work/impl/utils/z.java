package androidx.work.impl.utils;

import androidx.work.WorkQuery;
import androidx.work.impl.WorkDatabase;
import k3.l;

public final /* synthetic */ class z implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkQuery f773a;

    public /* synthetic */ z(WorkQuery workQuery) {
        this.f773a = workQuery;
    }

    public final Object invoke(Object obj) {
        return StatusRunnable.forWorkQuerySpec$lambda$4(this.f773a, (WorkDatabase) obj);
    }
}
