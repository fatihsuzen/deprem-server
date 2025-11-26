package androidx.room.support;

import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;
import k3.l;

public final /* synthetic */ class e implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f454a;

    public /* synthetic */ e(long j5) {
        this.f454a = j5;
    }

    public final Object invoke(Object obj) {
        return Long.valueOf(AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.setMaximumSize$lambda$2(this.f454a, (SupportSQLiteDatabase) obj));
    }
}
