package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class j0 implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f660a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f661b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WorkSpecDao_Impl f662c;

    public /* synthetic */ j0(String str, String str2, WorkSpecDao_Impl workSpecDao_Impl) {
        this.f660a = str;
        this.f661b = str2;
        this.f662c = workSpecDao_Impl;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.getWorkStatusPojoLiveDataForName$lambda$16(this.f660a, this.f661b, this.f662c, (SQLiteConnection) obj);
    }
}
