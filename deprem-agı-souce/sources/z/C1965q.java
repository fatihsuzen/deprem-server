package z;

import android.database.sqlite.SQLiteDatabase;
import u.C1885c;
import z.M;

/* renamed from: z.q  reason: case insensitive filesystem */
public final /* synthetic */ class C1965q implements M.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f17160a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C1885c.b f17161b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ long f17162c;

    public /* synthetic */ C1965q(String str, C1885c.b bVar, long j5) {
        this.f17160a = str;
        this.f17161b = bVar;
        this.f17162c = j5;
    }

    public final Object apply(Object obj) {
        return M.I(this.f17160a, this.f17161b, this.f17162c, (SQLiteDatabase) obj);
    }
}
