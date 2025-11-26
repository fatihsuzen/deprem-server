package androidx.room.support;

import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;
import k3.l;

public final /* synthetic */ class b implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f449a;

    public /* synthetic */ b(int i5) {
        this.f449a = i5;
    }

    public final Object invoke(Object obj) {
        return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.setMaxSqlCacheSize$lambda$11(this.f449a, (SupportSQLiteDatabase) obj);
    }
}
