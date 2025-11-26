package androidx.room.support;

import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;
import k3.l;

public final /* synthetic */ class m implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f468a;

    public /* synthetic */ m(int i5) {
        this.f468a = i5;
    }

    public final Object invoke(Object obj) {
        return Boolean.valueOf(AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.needUpgrade$lambda$9(this.f468a, (SupportSQLiteDatabase) obj));
    }
}
