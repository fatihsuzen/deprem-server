package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class p0 implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f686a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f687b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WorkSpecDao_Impl f688c;

    public /* synthetic */ p0(String str, String str2, WorkSpecDao_Impl workSpecDao_Impl) {
        this.f686a = str;
        this.f687b = str2;
        this.f688c = workSpecDao_Impl;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.getWorkStatusPojoForId$lambda$8(this.f686a, this.f687b, this.f688c, (SQLiteConnection) obj);
    }
}
