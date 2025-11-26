package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class J implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f586a;

    public /* synthetic */ J(String str) {
        this.f586a = str;
    }

    public final Object invoke(Object obj) {
        return Integer.valueOf(WorkSpecDao_Impl.resetScheduledState$lambda$48(this.f586a, (SQLiteConnection) obj));
    }
}
