package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

/* renamed from: androidx.work.impl.model.u  reason: case insensitive filesystem */
public final /* synthetic */ class C0446u implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f710a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f711b;

    public /* synthetic */ C0446u(String str, String str2) {
        this.f710a = str;
        this.f711b = str2;
    }

    public final Object invoke(Object obj) {
        return WorkNameDao_Impl.getNamesForWorkSpecId$lambda$2(this.f710a, this.f711b, (SQLiteConnection) obj);
    }
}
