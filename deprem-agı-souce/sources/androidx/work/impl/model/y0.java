package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class y0 implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f724a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f725b;

    public /* synthetic */ y0(String str, String str2) {
        this.f724a = str;
        this.f725b = str2;
    }

    public final Object invoke(Object obj) {
        return WorkTagDao_Impl.deleteByWorkSpecId$lambda$3(this.f724a, this.f725b, (SQLiteConnection) obj);
    }
}
