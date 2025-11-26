package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class c0 implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f629a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f630b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f631c;

    public /* synthetic */ c0(String str, long j5, String str2) {
        this.f629a = str;
        this.f630b = j5;
        this.f631c = str2;
    }

    public final Object invoke(Object obj) {
        return Integer.valueOf(WorkSpecDao_Impl.markWorkSpecScheduled$lambda$47(this.f629a, this.f630b, this.f631c, (SQLiteConnection) obj));
    }
}
