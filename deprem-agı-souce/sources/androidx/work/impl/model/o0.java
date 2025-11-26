package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import androidx.work.WorkInfo;
import k3.l;

public final /* synthetic */ class o0 implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f682a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WorkInfo.State f683b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f684c;

    public /* synthetic */ o0(String str, WorkInfo.State state, String str2) {
        this.f682a = str;
        this.f683b = state;
        this.f684c = str2;
    }

    public final Object invoke(Object obj) {
        return Integer.valueOf(WorkSpecDao_Impl.setState$lambda$38(this.f682a, this.f683b, this.f684c, (SQLiteConnection) obj));
    }
}
