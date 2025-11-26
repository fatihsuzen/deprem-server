package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

/* renamed from: androidx.work.impl.model.p  reason: case insensitive filesystem */
public final /* synthetic */ class C0442p implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f685a;

    public /* synthetic */ C0442p(String str) {
        this.f685a = str;
    }

    public final Object invoke(Object obj) {
        return SystemIdInfoDao_Impl.getWorkSpecIds$lambda$2(this.f685a, (SQLiteConnection) obj);
    }
}
