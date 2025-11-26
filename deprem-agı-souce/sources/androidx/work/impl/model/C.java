package androidx.work.impl.model;

import androidx.sqlite.SQLiteConnection;
import k3.l;

public final /* synthetic */ class C implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f573a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f574b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f575c;

    public /* synthetic */ C(String str, int i5, String str2) {
        this.f573a = str;
        this.f574b = i5;
        this.f575c = str2;
    }

    public final Object invoke(Object obj) {
        return WorkSpecDao_Impl.setStopReason$lambda$51(this.f573a, this.f574b, this.f575c, (SQLiteConnection) obj);
    }
}
