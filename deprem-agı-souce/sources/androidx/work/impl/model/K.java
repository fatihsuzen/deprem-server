package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class K implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f587a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f588b;

    public /* synthetic */ K(String str, String str2) {
        this.f587a = str;
        this.f588b = str2;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.getWorkSpecIdAndStatesForName$lambda$4(this.f587a, this.f588b, (SQLiteConnection) obj);
    }
}
