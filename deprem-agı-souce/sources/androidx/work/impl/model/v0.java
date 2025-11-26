package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class v0 implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f716a;

    public /* synthetic */ v0(String str) {
        this.f716a = str;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.getEligibleWorkForSchedulingWithContentUris$lambda$27(this.f716a, (SQLiteConnection) obj);
    }
}
