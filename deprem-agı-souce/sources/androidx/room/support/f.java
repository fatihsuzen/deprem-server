package androidx.room.support;

import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;
import k3.l;

public final /* synthetic */ class f implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f455a;

    public /* synthetic */ f(int i5) {
        this.f455a = i5;
    }

    public final Object invoke(Object obj) {
        return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase._set_version_$lambda$1(this.f455a, (SupportSQLiteDatabase) obj);
    }
}
