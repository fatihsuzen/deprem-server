package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class W implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f612a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f613b;

    public /* synthetic */ W(String str, int i5) {
        this.f612a = str;
        this.f613b = i5;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.getEligibleWorkForScheduling$lambda$25(this.f612a, this.f613b, (SQLiteConnection) obj);
    }
}
