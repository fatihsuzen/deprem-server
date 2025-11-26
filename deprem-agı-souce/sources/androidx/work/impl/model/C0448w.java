package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

/* renamed from: androidx.work.impl.model.w  reason: case insensitive filesystem */
public final /* synthetic */ class C0448w implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f717a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f718b;

    public /* synthetic */ C0448w(String str, String str2) {
        this.f717a = str;
        this.f718b = str2;
    }

    public final Object invoke(Object obj) {
        return WorkProgressDao_Impl.getProgressForWorkSpecId$lambda$1(this.f717a, this.f718b, (SQLiteConnection) obj);
    }
}
