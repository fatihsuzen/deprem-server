package androidx.room.support;

import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;
import k3.l;

public final /* synthetic */ class h implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f461a;

    public /* synthetic */ h(String str) {
        this.f461a = str;
    }

    public final Object invoke(Object obj) {
        return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.execSQL$lambda$7(this.f461a, (SupportSQLiteDatabase) obj);
    }
}
