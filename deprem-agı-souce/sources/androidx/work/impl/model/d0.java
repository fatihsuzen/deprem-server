package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class d0 implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f634a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f635b;

    public /* synthetic */ d0(String str, String str2) {
        this.f634a = str;
        this.f635b = str2;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.incrementGeneration$lambda$50(this.f634a, this.f635b, (SQLiteConnection) obj);
    }
}
