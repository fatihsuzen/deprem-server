package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class H implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f583a;

    public /* synthetic */ H(String str) {
        this.f583a = str;
    }

    public final Object invoke(Object obj) {
        return Boolean.valueOf(WorkSpecDao_Impl.hasUnfinishedWorkFlow$lambda$22(this.f583a, (SQLiteConnection) obj));
    }
}
