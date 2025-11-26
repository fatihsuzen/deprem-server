package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class D implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f576a;

    public /* synthetic */ D(String str) {
        this.f576a = str;
    }

    public final Object invoke(Object obj) {
        return Integer.valueOf(WorkSpecDao_Impl.countNonFinishedContentUriTriggerWorkers$lambda$36(this.f576a, (SQLiteConnection) obj));
    }
}
