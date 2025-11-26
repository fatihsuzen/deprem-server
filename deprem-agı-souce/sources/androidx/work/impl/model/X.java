package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class X implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f614a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f615b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f616c;

    public /* synthetic */ X(String str, long j5, String str2) {
        this.f614a = str;
        this.f615b = j5;
        this.f616c = str2;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.setNextScheduleTimeOverride$lambda$45(this.f614a, this.f615b, this.f616c, (SQLiteConnection) obj);
    }
}
