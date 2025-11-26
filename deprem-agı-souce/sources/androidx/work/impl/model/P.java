package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class P implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f600a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f601b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WorkSpecDao_Impl f602c;

    public /* synthetic */ P(String str, String str2, WorkSpecDao_Impl workSpecDao_Impl) {
        this.f600a = str;
        this.f601b = str2;
        this.f602c = workSpecDao_Impl;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.getWorkStatusPojoForTag$lambda$12(this.f600a, this.f601b, this.f602c, (SQLiteConnection) obj);
    }
}
