package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

/* renamed from: androidx.work.impl.model.a  reason: case insensitive filesystem */
public final /* synthetic */ class C0425a implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f620a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f621b;

    public /* synthetic */ C0425a(String str, String str2) {
        this.f620a = str;
        this.f621b = str2;
    }

    public final Object invoke(Object obj) {
        return DependencyDao_Impl.getDependentWorkIds$lambda$3(this.f620a, this.f621b, (SQLiteConnection) obj);
    }
}
