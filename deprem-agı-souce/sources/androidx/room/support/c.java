package androidx.room.support;

import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;
import java.util.Locale;
import k3.l;

public final /* synthetic */ class c implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Locale f450a;

    public /* synthetic */ c(Locale locale) {
        this.f450a = locale;
    }

    public final Object invoke(Object obj) {
        return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.setLocale$lambda$10(this.f450a, (SupportSQLiteDatabase) obj);
    }
}
