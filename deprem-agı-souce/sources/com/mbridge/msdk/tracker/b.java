package com.mbridge.msdk.tracker;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

final class b extends SQLiteOpenHelper {

    /* renamed from: a  reason: collision with root package name */
    private final String f11491a;

    public b(Context context, String str, String str2) {
        super(context, str, (SQLiteDatabase.CursorFactory) null, 1);
        this.f11491a = str2;
    }

    public final void onCreate(SQLiteDatabase sQLiteDatabase) {
        if (!y.a((Object) sQLiteDatabase)) {
            try {
                sQLiteDatabase.execSQL(String.format(i.f11514a, new Object[]{this.f11491a}));
            } catch (Exception e5) {
                if (a.f11490a) {
                    Log.e("TrackManager", "create table error", e5);
                }
            }
        }
    }

    public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i5, int i6) {
        if (!y.a((Object) sQLiteDatabase)) {
            try {
                sQLiteDatabase.execSQL(String.format(i.f11515b, new Object[]{this.f11491a}));
                sQLiteDatabase.execSQL(String.format(i.f11514a, new Object[]{this.f11491a}));
            } catch (Exception e5) {
                if (a.f11490a) {
                    Log.e("TrackManager", "downgrade table error", e5);
                }
            }
        }
    }

    public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i5, int i6) {
        if (!y.a((Object) sQLiteDatabase)) {
            try {
                sQLiteDatabase.execSQL(String.format(i.f11515b, new Object[]{this.f11491a}));
                sQLiteDatabase.execSQL(String.format(i.f11514a, new Object[]{this.f11491a}));
            } catch (Exception e5) {
                if (a.f11490a) {
                    Log.e("TrackManager", "upgrade table error", e5);
                }
            }
        }
    }
}
