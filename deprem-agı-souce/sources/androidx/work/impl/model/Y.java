package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class Y implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f617a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f618b;

    public /* synthetic */ Y(String str, String str2) {
        this.f617a = str;
        this.f618b = str2;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.getWorkSpec$lambda$3(this.f617a, this.f618b, (SQLiteConnection) obj);
    }
}
