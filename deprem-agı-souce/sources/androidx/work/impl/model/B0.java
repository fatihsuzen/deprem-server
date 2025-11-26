package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class B0 implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f571a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f572b;

    public /* synthetic */ B0(String str, String str2) {
        this.f571a = str;
        this.f572b = str2;
    }

    public final Object invoke(Object obj) {
        return WorkTagDao_Impl.getWorkSpecIdsWithTag$lambda$1(this.f571a, this.f572b, (SQLiteConnection) obj);
    }
}
