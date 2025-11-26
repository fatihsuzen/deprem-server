package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/* renamed from: com.google.android.gms.internal.measurement.d0  reason: case insensitive filesystem */
public abstract class C1075d0 extends SQLiteOpenHelper {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1075d0(Context context, String str, SQLiteDatabase.CursorFactory cursorFactory, int i5) {
        super(context, true == str.equals("") ? null : str, (SQLiteDatabase.CursorFactory) null, 1);
        int i6 = C1102g0.f5355b;
        C1048a0.a();
    }
}
