package androidx.room;

import androidx.sqlite.db.SupportSQLiteDatabase;

public final /* synthetic */ class l implements k3.l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RoomDatabase f442a;

    public /* synthetic */ l(RoomDatabase roomDatabase) {
        this.f442a = roomDatabase;
    }

    public final Object invoke(Object obj) {
        return RoomDatabase.beginTransaction$lambda$8(this.f442a, (SupportSQLiteDatabase) obj);
    }
}
