package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

/* renamed from: androidx.work.impl.model.b0  reason: case insensitive filesystem */
public final /* synthetic */ class C0428b0 implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f626a;

    public /* synthetic */ C0428b0(String str) {
        this.f626a = str;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.getAllWorkSpecIdsLiveData$lambda$6(this.f626a, (SQLiteConnection) obj);
    }
}
