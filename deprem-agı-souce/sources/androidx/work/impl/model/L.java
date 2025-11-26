package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class L implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f589a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f590b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ WorkSpecDao_Impl f591c;

    public /* synthetic */ L(String str, String str2, WorkSpecDao_Impl workSpecDao_Impl) {
        this.f589a = str;
        this.f590b = str2;
        this.f591c = workSpecDao_Impl;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.getWorkStatusPojoFlowForTag$lambda$13(this.f589a, this.f590b, this.f591c, (SQLiteConnection) obj);
    }
}
