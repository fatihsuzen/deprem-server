package com.mbridge.msdk.e;

import android.database.sqlite.SQLiteDatabase;

public final class d {
    public static boolean a(SQLiteDatabase sQLiteDatabase) {
        if (sQLiteDatabase != null) {
            try {
                if (!sQLiteDatabase.isOpen() || sQLiteDatabase.isReadOnly()) {
                    return false;
                }
                return true;
            } catch (Exception unused) {
            }
        }
        return false;
    }
}
