package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

/* renamed from: androidx.work.impl.model.d  reason: case insensitive filesystem */
public final /* synthetic */ class C0430d implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f632a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f633b;

    public /* synthetic */ C0430d(String str, String str2) {
        this.f632a = str;
        this.f633b = str2;
    }

    public final Object invoke(Object obj) {
        return Boolean.valueOf(DependencyDao_Impl.hasCompletedAllPrerequisites$lambda$1(this.f632a, this.f633b, (SQLiteConnection) obj));
    }
}
