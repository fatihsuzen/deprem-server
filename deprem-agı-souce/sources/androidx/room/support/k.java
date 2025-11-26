package androidx.room.support;

import android.content.ContentValues;
import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;
import k3.l;

public final /* synthetic */ class k implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f464a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f465b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ContentValues f466c;

    public /* synthetic */ k(String str, int i5, ContentValues contentValues) {
        this.f464a = str;
        this.f465b = i5;
        this.f466c = contentValues;
    }

    public final Object invoke(Object obj) {
        return Long.valueOf(AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.insert$lambda$4(this.f464a, this.f465b, this.f466c, (SupportSQLiteDatabase) obj));
    }
}
