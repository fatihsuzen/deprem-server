package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class e0 implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f638a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f639b;

    public /* synthetic */ e0(String str, String str2) {
        this.f638a = str;
        this.f639b = str2;
    }

    public final Object invoke(Object obj) {
        return Integer.valueOf(WorkSpecDao_Impl.setCancelledState$lambda$39(this.f638a, this.f639b, (SQLiteConnection) obj));
    }
}
