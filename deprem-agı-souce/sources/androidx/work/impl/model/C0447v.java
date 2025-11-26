package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

/* renamed from: androidx.work.impl.model.v  reason: case insensitive filesystem */
public final /* synthetic */ class C0447v implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkNameDao_Impl f714a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WorkName f715b;

    public /* synthetic */ C0447v(WorkNameDao_Impl workNameDao_Impl, WorkName workName) {
        this.f714a = workNameDao_Impl;
        this.f715b = workName;
    }

    public final Object invoke(Object obj) {
        return WorkNameDao_Impl.insert$lambda$0(this.f714a, this.f715b, (SQLiteConnection) obj);
    }
}
