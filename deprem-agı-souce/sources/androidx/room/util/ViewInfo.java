package androidx.room.util;

import androidx.annotation.RestrictTo;
import androidx.room.driver.SupportSQLiteConnection;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class ViewInfo {
    public static final Companion Companion = new Companion((C2633k) null);
    public final String name;
    public final String sql;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public final ViewInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
            t.e(supportSQLiteDatabase, "database");
            t.e(str, "viewName");
            return read((SQLiteConnection) new SupportSQLiteConnection(supportSQLiteDatabase), str);
        }

        private Companion() {
        }

        public final ViewInfo read(SQLiteConnection sQLiteConnection, String str) {
            t.e(sQLiteConnection, "connection");
            t.e(str, "viewName");
            return SchemaInfoUtilKt.readViewInfo(sQLiteConnection, str);
        }
    }

    public ViewInfo(String str, String str2) {
        t.e(str, RewardPlus.NAME);
        this.name = str;
        this.sql = str2;
    }

    public static final ViewInfo read(SQLiteConnection sQLiteConnection, String str) {
        return Companion.read(sQLiteConnection, str);
    }

    public boolean equals(Object obj) {
        return ViewInfoKt.equalsCommon(this, obj);
    }

    public int hashCode() {
        return ViewInfoKt.hashCodeCommon(this);
    }

    public String toString() {
        return ViewInfoKt.toStringCommon(this);
    }

    public static final ViewInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        return Companion.read(supportSQLiteDatabase, str);
    }
}
