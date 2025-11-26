package androidx.room.support;

import android.content.ContentValues;
import androidx.room.support.AutoClosingRoomOpenHelper;
import androidx.sqlite.db.SupportSQLiteDatabase;
import k3.l;

public final /* synthetic */ class g implements l {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f456a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ int f457b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ContentValues f458c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f459d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Object[] f460e;

    public /* synthetic */ g(String str, int i5, ContentValues contentValues, String str2, Object[] objArr) {
        this.f456a = str;
        this.f457b = i5;
        this.f458c = contentValues;
        this.f459d = str2;
        this.f460e = objArr;
    }

    public final Object invoke(Object obj) {
        return Integer.valueOf(AutoClosingRoomOpenHelper.AutoClosingSupportSQLiteDatabase.update$lambda$6(this.f456a, this.f457b, this.f458c, this.f459d, this.f460e, (SupportSQLiteDatabase) obj));
    }
}
