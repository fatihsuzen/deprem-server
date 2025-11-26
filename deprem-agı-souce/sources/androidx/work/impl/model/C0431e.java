package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

/* renamed from: androidx.work.impl.model.e  reason: case insensitive filesystem */
public final /* synthetic */ class C0431e implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f636a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f637b;

    public /* synthetic */ C0431e(String str, String str2) {
        this.f636a = str;
        this.f637b = str2;
    }

    public final Object invoke(Object obj) {
        return DependencyDao_Impl.getPrerequisites$lambda$2(this.f636a, this.f637b, (SQLiteConnection) obj);
    }
}
