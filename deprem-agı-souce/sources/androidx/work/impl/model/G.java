package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class G implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f582a;

    public /* synthetic */ G(String str) {
        this.f582a = str;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.pruneFinishedWorkWithZeroDependentsIgnoringKeepForAtLeast$lambda$49(this.f582a, (SQLiteConnection) obj);
    }
}
