package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class E implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f577a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f578b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f579c;

    public /* synthetic */ E(String str, String str2, int i5) {
        this.f577a = str;
        this.f578b = str2;
        this.f579c = i5;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.resetWorkSpecNextScheduleTimeOverride$lambda$46(this.f577a, this.f578b, this.f579c, (SQLiteConnection) obj);
    }
}
