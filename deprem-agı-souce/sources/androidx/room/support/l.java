package androidx.room.support;

import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;

public final /* synthetic */ class l implements k3.l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ long f467a;

    public /* synthetic */ l(long j5) {
        this.f467a = j5;
    }

    public final Object invoke(Object obj) {
        return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase._set_pageSize_$lambda$3(this.f467a, (SupportSQLiteDatabase) obj);
    }
}
