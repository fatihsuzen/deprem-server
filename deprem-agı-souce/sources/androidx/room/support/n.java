package androidx.room.support;

import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;
import k3.l;

public final /* synthetic */ class n implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ boolean f469a;

    public /* synthetic */ n(boolean z4) {
        this.f469a = z4;
    }

    public final Object invoke(Object obj) {
        return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.setForeignKeyConstraintsEnabled$lambda$12(this.f469a, (SupportSQLiteDatabase) obj);
    }
}
