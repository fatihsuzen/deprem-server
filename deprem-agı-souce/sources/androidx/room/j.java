package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;
import k3.l;

public final /* synthetic */ class j implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RoomDatabase f440a;

    public /* synthetic */ j(RoomDatabase roomDatabase) {
        this.f440a = roomDatabase;
    }

    public final Object invoke(Object obj) {
        return RoomDatabase.endTransaction$lambda$9(this.f440a, (SupportSQLiteDatabase) obj);
    }
}
