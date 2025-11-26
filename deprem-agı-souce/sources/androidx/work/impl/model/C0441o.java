package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

/* renamed from: androidx.work.impl.model.o  reason: case insensitive filesystem */
public final /* synthetic */ class C0441o implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SystemIdInfoDao_Impl f680a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SystemIdInfo f681b;

    public /* synthetic */ C0441o(SystemIdInfoDao_Impl systemIdInfoDao_Impl, SystemIdInfo systemIdInfo) {
        this.f680a = systemIdInfoDao_Impl;
        this.f681b = systemIdInfo;
    }

    public final Object invoke(Object obj) {
        return SystemIdInfoDao_Impl.insertSystemIdInfo$lambda$0(this.f680a, this.f681b, (SQLiteConnection) obj);
    }
}
