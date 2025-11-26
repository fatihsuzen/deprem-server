package androidx.room.support;

import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;
import k3.l;

public final /* synthetic */ class d implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f451a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f452b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object[] f453c;

    public /* synthetic */ d(String str, String str2, Object[] objArr) {
        this.f451a = str;
        this.f452b = str2;
        this.f453c = objArr;
    }

    public final Object invoke(Object obj) {
        return Integer.valueOf(AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.delete$lambda$5(this.f451a, this.f452b, this.f453c, (SupportSQLiteDatabase) obj));
    }
}
