package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class g0 implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f647a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f648b;

    public /* synthetic */ g0(String str, String str2) {
        this.f647a = str;
        this.f648b = str2;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.getUnfinishedWorkWithTag$lambda$19(this.f647a, this.f648b, (SQLiteConnection) obj);
    }
}
