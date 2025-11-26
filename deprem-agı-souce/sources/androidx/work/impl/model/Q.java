package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class Q implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ WorkSpecDao_Impl f603a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WorkSpec f604b;

    public /* synthetic */ Q(WorkSpecDao_Impl workSpecDao_Impl, WorkSpec workSpec) {
        this.f603a = workSpecDao_Impl;
        this.f604b = workSpec;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.updateWorkSpec$lambda$1(this.f603a, this.f604b, (SQLiteConnection) obj);
    }
}
