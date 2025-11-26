package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class h0 implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f651a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f652b;

    public /* synthetic */ h0(String str, String str2) {
        this.f651a = str;
        this.f652b = str2;
    }

    public final Object invoke(Object obj) {
        return Integer.valueOf(WorkSpecDao_Impl.incrementWorkSpecRunAttemptCount$lambda$43(this.f651a, this.f652b, (SQLiteConnection) obj));
    }
}
