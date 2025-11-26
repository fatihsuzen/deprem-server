package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class s0 implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f703a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f704b;

    public /* synthetic */ s0(String str, String str2) {
        this.f703a = str;
        this.f704b = str2;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.getState$lambda$7(this.f703a, this.f704b, (SQLiteConnection) obj);
    }
}
