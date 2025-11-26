package androidx.core.database.sqlite;

import android.database.sqlite.SQLiteDatabase;
import k3.l;
import kotlin.jvm.internal.r;

public final class SQLiteDatabaseKt {
    public static final <T> T transaction(SQLiteDatabase sQLiteDatabase, boolean z4, l lVar) {
        if (z4) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            T invoke = lVar.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return invoke;
        } finally {
            r.b(1);
            sQLiteDatabase.endTransaction();
            r.a(1);
        }
    }

    public static /* synthetic */ Object transaction$default(SQLiteDatabase sQLiteDatabase, boolean z4, l lVar, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z4 = true;
        }
        if (z4) {
            sQLiteDatabase.beginTransaction();
        } else {
            sQLiteDatabase.beginTransactionNonExclusive();
        }
        try {
            Object invoke = lVar.invoke(sQLiteDatabase);
            sQLiteDatabase.setTransactionSuccessful();
            return invoke;
        } finally {
            r.b(1);
            sQLiteDatabase.endTransaction();
            r.a(1);
        }
    }
}
