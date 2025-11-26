package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class Z implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f619a;

    public /* synthetic */ Z(String str) {
        this.f619a = str;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.getAllWorkSpecIds$lambda$5(this.f619a, (SQLiteConnection) obj);
    }
}
