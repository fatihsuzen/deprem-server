package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import androidx.work.Data;
import k3.l;

public final /* synthetic */ class M implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f592a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Data f593b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f594c;

    public /* synthetic */ M(String str, Data data, String str2) {
        this.f592a = str;
        this.f593b = data;
        this.f594c = str2;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.setOutput$lambda$41(this.f592a, this.f593b, this.f594c, (SQLiteConnection) obj);
    }
}
