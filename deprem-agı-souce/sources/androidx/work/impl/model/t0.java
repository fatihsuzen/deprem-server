package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class t0 implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f707a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f708b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f709c;

    public /* synthetic */ t0(String str, long j5, String str2) {
        this.f707a = str;
        this.f708b = j5;
        this.f709c = str2;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.setLastEnqueueTime$lambda$42(this.f707a, this.f708b, this.f709c, (SQLiteConnection) obj);
    }
}
