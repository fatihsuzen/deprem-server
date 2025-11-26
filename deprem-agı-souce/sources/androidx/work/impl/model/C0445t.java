package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

/* renamed from: androidx.work.impl.model.t  reason: case insensitive filesystem */
public final /* synthetic */ class C0445t implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f705a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f706b;

    public /* synthetic */ C0445t(String str, String str2) {
        this.f705a = str;
        this.f706b = str2;
    }

    public final Object invoke(Object obj) {
        return WorkNameDao_Impl.getWorkSpecIdsWithName$lambda$1(this.f705a, this.f706b, (SQLiteConnection) obj);
    }
}
