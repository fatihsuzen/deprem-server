package z;

import android.database.sqlite.SQLiteDatabase;
import z.M;

/* renamed from: z.l  reason: case insensitive filesystem */
public final /* synthetic */ class C1960l implements M.d {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SQLiteDatabase f17151a;

    public /* synthetic */ C1960l(SQLiteDatabase sQLiteDatabase) {
        this.f17151a = sQLiteDatabase;
    }

    public final Object a() {
        return this.f17151a.beginTransaction();
    }
}
