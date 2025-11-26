package z;

import android.database.sqlite.SQLiteDatabase;
import z.M;

/* renamed from: z.I  reason: case insensitive filesystem */
public final /* synthetic */ class C1948I implements M.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ M f17098a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ long f17099b;

    public /* synthetic */ C1948I(M m5, long j5) {
        this.f17098a = m5;
        this.f17099b = j5;
    }

    public final Object apply(Object obj) {
        return M.K(this.f17098a, this.f17099b, (SQLiteDatabase) obj);
    }
}
