package androidx.room.coroutines;

import androidx.sqlite.SQLiteDriver;
import k3.C2616a;

public final /* synthetic */ class d implements C2616a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteDriver f430a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f431b;

    public /* synthetic */ d(SQLiteDriver sQLiteDriver, String str) {
        this.f430a = sQLiteDriver;
        this.f431b = str;
    }

    public final Object invoke() {
        return ConnectionPoolImpl._init_$lambda$0(this.f430a, this.f431b);
    }
}
