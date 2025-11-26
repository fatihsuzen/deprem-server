package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class B implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f570a;

    public /* synthetic */ B(String str) {
        this.f570a = str;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.getAllUnfinishedWork$lambda$21(this.f570a, (SQLiteConnection) obj);
    }
}
