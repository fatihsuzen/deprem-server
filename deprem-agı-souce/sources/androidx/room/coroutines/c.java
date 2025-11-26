package androidx.room.coroutines;

import androidx.sqlite.SQLiteDriver;
import k3.C2616a;

public final /* synthetic */ class c implements C2616a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteDriver f428a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f429b;

    public /* synthetic */ c(SQLiteDriver sQLiteDriver, String str) {
        this.f428a = sQLiteDriver;
        this.f429b = str;
    }

    public final Object invoke() {
        return ConnectionPoolImpl._init_$lambda$5(this.f428a, this.f429b);
    }
}
