package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import k3.l;

public final /* synthetic */ class y implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f772a;

    public /* synthetic */ y(String str) {
        this.f772a = str;
    }

    public final Object invoke(Object obj) {
        return StatusRunnable.forTag$lambda$2(this.f772a, (WorkDatabase) obj);
    }
}
