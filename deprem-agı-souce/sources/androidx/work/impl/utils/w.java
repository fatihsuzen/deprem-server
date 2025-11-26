package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import java.util.UUID;
import k3.l;

public final /* synthetic */ class w implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UUID f770a;

    public /* synthetic */ w(UUID uuid) {
        this.f770a = uuid;
    }

    public final Object invoke(Object obj) {
        return StatusRunnable.forUUID$lambda$1(this.f770a, (WorkDatabase) obj);
    }
}
