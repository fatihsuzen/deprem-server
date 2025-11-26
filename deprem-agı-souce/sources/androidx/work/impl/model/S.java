package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class S implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f605a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f606b;

    public /* synthetic */ S(String str, String str2) {
        this.f605a = str;
        this.f606b = str2;
    }

    public final Object invoke(Object obj) {
        return Integer.valueOf(WorkSpecDao_Impl.resetWorkSpecRunAttemptCount$lambda$44(this.f605a, this.f606b, (SQLiteConnection) obj));
    }
}
