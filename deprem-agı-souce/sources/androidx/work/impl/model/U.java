package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class U implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f609a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f610b;

    public /* synthetic */ U(String str, long j5) {
        this.f609a = str;
        this.f610b = j5;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.getRecentlyCompletedWork$lambda$35(this.f609a, this.f610b, (SQLiteConnection) obj);
    }
}
