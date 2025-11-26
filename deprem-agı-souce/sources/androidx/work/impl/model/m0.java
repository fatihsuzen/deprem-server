package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class m0 implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f674a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f675b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WorkSpecDao_Impl f676c;

    public /* synthetic */ m0(String str, String str2, WorkSpecDao_Impl workSpecDao_Impl) {
        this.f674a = str;
        this.f675b = str2;
        this.f676c = workSpecDao_Impl;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.getWorkStatusPojoForName$lambda$15(this.f674a, this.f675b, this.f676c, (SQLiteConnection) obj);
    }
}
