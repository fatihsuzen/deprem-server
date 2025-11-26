package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

/* renamed from: androidx.work.impl.model.z  reason: case insensitive filesystem */
public final /* synthetic */ class C0451z implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkProgressDao_Impl f726a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WorkProgress f727b;

    public /* synthetic */ C0451z(WorkProgressDao_Impl workProgressDao_Impl, WorkProgress workProgress) {
        this.f726a = workProgressDao_Impl;
        this.f727b = workProgress;
    }

    public final Object invoke(Object obj) {
        return WorkProgressDao_Impl.insert$lambda$0(this.f726a, this.f727b, (SQLiteConnection) obj);
    }
}
