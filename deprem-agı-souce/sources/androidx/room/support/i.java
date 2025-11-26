package androidx.room.support;

import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;
import k3.l;

public final /* synthetic */ class i implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f462a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Object[] f463b;

    public /* synthetic */ i(String str, Object[] objArr) {
        this.f462a = str;
        this.f463b = objArr;
    }

    public final Object invoke(Object obj) {
        return AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.execSQL$lambda$8(this.f462a, this.f463b, (SupportSQLiteDatabase) obj);
    }
}
