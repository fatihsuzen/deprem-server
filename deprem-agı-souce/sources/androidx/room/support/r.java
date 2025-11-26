package androidx.room.support;

import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;
import k3.l;

public final /* synthetic */ class r implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteStatement f470a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l f471b;

    public /* synthetic */ r(AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteStatement autoClosingSupportSQLiteStatement, l lVar) {
        this.f470a = autoClosingSupportSQLiteStatement;
        this.f471b = lVar;
    }

    public final Object invoke(Object obj) {
        return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteStatement.executeWithRefCount$lambda$5(this.f470a, this.f471b, (SupportSQLiteDatabase) obj);
    }
}
