package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class A0 implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkTagDao_Impl f568a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WorkTag f569b;

    public /* synthetic */ A0(WorkTagDao_Impl workTagDao_Impl, WorkTag workTag) {
        this.f568a = workTagDao_Impl;
        this.f569b = workTag;
    }

    public final Object invoke(Object obj) {
        return WorkTagDao_Impl.insert$lambda$0(this.f568a, this.f569b, (SQLiteConnection) obj);
    }
}
