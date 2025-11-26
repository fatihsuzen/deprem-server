package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

/* renamed from: androidx.work.impl.model.c  reason: case insensitive filesystem */
public final /* synthetic */ class C0429c implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f627a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f628b;

    public /* synthetic */ C0429c(String str, String str2) {
        this.f627a = str;
        this.f628b = str2;
    }

    public final Object invoke(Object obj) {
        return Boolean.valueOf(DependencyDao_Impl.hasDependents$lambda$4(this.f627a, this.f628b, (SQLiteConnection) obj));
    }
}
