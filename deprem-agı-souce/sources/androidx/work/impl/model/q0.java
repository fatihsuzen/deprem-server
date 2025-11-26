package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class q0 implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f692a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f693b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WorkSpecDao_Impl f694c;

    public /* synthetic */ q0(String str, String str2, WorkSpecDao_Impl workSpecDao_Impl) {
        this.f692a = str;
        this.f693b = str2;
        this.f694c = workSpecDao_Impl;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.getWorkStatusPojoLiveDataForTag$lambda$14(this.f692a, this.f693b, this.f694c, (SQLiteConnection) obj);
    }
}
