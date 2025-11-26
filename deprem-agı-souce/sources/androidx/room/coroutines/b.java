package androidx.room.coroutines;

import androidx.sqlite.SQLiteDriver;
import k3.C2616a;

public final /* synthetic */ class b implements C2616a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteDriver f426a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f427b;

    public /* synthetic */ b(SQLiteDriver sQLiteDriver, String str) {
        this.f426a = sQLiteDriver;
        this.f427b = str;
    }

    public final Object invoke() {
        return ConnectionPoolImpl._init_$lambda$4(this.f426a, this.f427b);
    }
}
