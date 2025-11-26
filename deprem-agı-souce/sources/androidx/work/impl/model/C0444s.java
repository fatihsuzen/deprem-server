package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

/* renamed from: androidx.work.impl.model.s  reason: case insensitive filesystem */
public final /* synthetic */ class C0444s implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f701a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f702b;

    public /* synthetic */ C0444s(String str, String str2) {
        this.f701a = str;
        this.f702b = str2;
    }

    public final Object invoke(Object obj) {
        return SystemIdInfoDao_Impl.removeSystemIdInfo$lambda$4(this.f701a, this.f702b, (SQLiteConnection) obj);
    }
}
