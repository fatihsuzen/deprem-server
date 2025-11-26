package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class N implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f595a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f596b;

    public /* synthetic */ N(String str, String str2) {
        this.f595a = str;
        this.f596b = str2;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.getUnfinishedWorkWithName$lambda$20(this.f595a, this.f596b, (SQLiteConnection) obj);
    }
}
