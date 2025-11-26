package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

/* renamed from: androidx.work.impl.model.x  reason: case insensitive filesystem */
public final /* synthetic */ class C0449x implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f721a;

    public /* synthetic */ C0449x(String str) {
        this.f721a = str;
    }

    public final Object invoke(Object obj) {
        return WorkProgressDao_Impl.deleteAll$lambda$3(this.f721a, (SQLiteConnection) obj);
    }
}
