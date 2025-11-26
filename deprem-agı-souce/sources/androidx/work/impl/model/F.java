package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class F implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f580a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f581b;

    public /* synthetic */ F(String str, String str2) {
        this.f580a = str;
        this.f581b = str2;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.delete$lambda$37(this.f580a, this.f581b, (SQLiteConnection) obj);
    }
}
