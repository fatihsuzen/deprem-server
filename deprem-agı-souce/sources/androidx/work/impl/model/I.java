package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class I implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f584a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f585b;

    public /* synthetic */ I(String str, int i5) {
        this.f584a = str;
        this.f585b = i5;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.getAllEligibleWorkSpecsForScheduling$lambda$29(this.f584a, this.f585b, (SQLiteConnection) obj);
    }
}
