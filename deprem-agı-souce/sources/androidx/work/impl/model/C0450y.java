package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

/* renamed from: androidx.work.impl.model.y  reason: case insensitive filesystem */
public final /* synthetic */ class C0450y implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f722a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f723b;

    public /* synthetic */ C0450y(String str, String str2) {
        this.f722a = str;
        this.f723b = str2;
    }

    public final Object invoke(Object obj) {
        return WorkProgressDao_Impl.delete$lambda$2(this.f722a, this.f723b, (SQLiteConnection) obj);
    }
}
