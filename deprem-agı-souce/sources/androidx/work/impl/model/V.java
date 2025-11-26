package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class V implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f611a;

    public /* synthetic */ V(String str) {
        this.f611a = str;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.getScheduledWork$lambda$31(this.f611a, (SQLiteConnection) obj);
    }
}
