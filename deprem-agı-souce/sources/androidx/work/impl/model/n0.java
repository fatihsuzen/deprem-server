package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class n0 implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f677a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f678b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WorkSpecDao_Impl f679c;

    public /* synthetic */ n0(String str, String str2, WorkSpecDao_Impl workSpecDao_Impl) {
        this.f677a = str;
        this.f678b = str2;
        this.f679c = workSpecDao_Impl;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.getWorkStatusPojoFlowForName$lambda$17(this.f677a, this.f678b, this.f679c, (SQLiteConnection) obj);
    }
}
