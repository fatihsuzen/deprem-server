package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import k3.l;

public final /* synthetic */ class x implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f771a;

    public /* synthetic */ x(String str) {
        this.f771a = str;
    }

    public final Object invoke(Object obj) {
        return StatusRunnable.forUniqueWork$lambda$3(this.f771a, (WorkDatabase) obj);
    }
}
