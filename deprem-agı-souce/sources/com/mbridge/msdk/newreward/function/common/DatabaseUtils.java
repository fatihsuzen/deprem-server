package com.mbridge.msdk.newreward.function.common;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.af;

public final class DatabaseUtils {
    private DatabaseUtils() {
    }

    public static void beginTransaction(SQLiteDatabase sQLiteDatabase) {
        if (isDatabaseAvailable(sQLiteDatabase)) {
            try {
                sQLiteDatabase.beginTransaction();
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("DatabaseUtils", "beginTransaction", e5);
                }
            }
        }
    }

    public static void closeCursor(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("DatabaseUtils", "closeCursor", e5);
                }
            }
        }
    }

    public static void endTransaction(SQLiteDatabase sQLiteDatabase) {
        if (isDatabaseAvailable(sQLiteDatabase) && sQLiteDatabase.inTransaction()) {
            try {
                sQLiteDatabase.endTransaction();
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("DatabaseUtils", "endTransaction", e5);
                }
            }
        }
    }

    public static boolean isDatabaseAvailable(SQLiteDatabase sQLiteDatabase) {
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

    public static void setTransactionSuccessful(SQLiteDatabase sQLiteDatabase) {
        if (isDatabaseAvailable(sQLiteDatabase)) {
            try {
                sQLiteDatabase.setTransactionSuccessful();
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b("DatabaseUtils", "setTransactionSuccessful", e5);
                }
            }
        }
    }
}
