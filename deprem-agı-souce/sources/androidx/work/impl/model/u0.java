package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class u0 implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkSpecDao_Impl f712a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WorkSpec f713b;

    public /* synthetic */ u0(WorkSpecDao_Impl workSpecDao_Impl, WorkSpec workSpec) {
        this.f712a = workSpecDao_Impl;
        this.f713b = workSpec;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.insertWorkSpec$lambda$0(this.f712a, this.f713b, (SQLiteConnection) obj);
    }
}
