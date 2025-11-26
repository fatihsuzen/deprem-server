package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

/* renamed from: androidx.work.impl.model.h  reason: case insensitive filesystem */
public final /* synthetic */ class C0434h implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f649a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f650b;

    public /* synthetic */ C0434h(String str, String str2) {
        this.f649a = str;
        this.f650b = str2;
    }

    public final Object invoke(Object obj) {
        return PreferenceDao_Impl.getLongValue$lambda$1(this.f649a, this.f650b, (SQLiteConnection) obj);
    }
}
