package androidx.room.util;

import androidx.annotation.RestrictTo;
import androidx.room.driver.SupportSQLiteConnection;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.util.Set;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class FtsTableInfo {
    public static final Companion Companion = new Companion((C2633k) null);
    public final Set<String> columns;
    public final String name;
    public final Set<String> options;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public final FtsTableInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
            t.e(supportSQLiteDatabase, "database");
            t.e(str, "tableName");
            return read((SQLiteConnection) new SupportSQLiteConnection(supportSQLiteDatabase), str);
        }

        private Companion() {
        }

        public final FtsTableInfo read(SQLiteConnection sQLiteConnection, String str) {
            t.e(sQLiteConnection, "connection");
            t.e(str, "tableName");
            return new FtsTableInfo(str, SchemaInfoUtilKt.readFtsColumns(sQLiteConnection, str), SchemaInfoUtilKt.readFtsOptions(sQLiteConnection, str));
        }
    }

    public FtsTableInfo(String str, Set<String> set, Set<String> set2) {
        t.e(str, RewardPlus.NAME);
        t.e(set, "columns");
        t.e(set2, "options");
        this.name = str;
        this.columns = set;
        this.options = set2;
    }

    public static final FtsTableInfo read(SQLiteConnection sQLiteConnection, String str) {
        return Companion.read(sQLiteConnection, str);
    }

    public boolean equals(Object obj) {
        return FtsTableInfoKt.equalsCommon(this, obj);
    }

    public int hashCode() {
        return FtsTableInfoKt.hashCodeCommon(this);
    }

    public String toString() {
        return FtsTableInfoKt.toStringCommon(this);
    }

    public static final FtsTableInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        return Companion.read(supportSQLiteDatabase, str);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FtsTableInfo(String str, Set<String> set, String str2) {
        this(str, set, SchemaInfoUtilKt.parseFtsOptions(str2));
        t.e(str, RewardPlus.NAME);
        t.e(set, "columns");
        t.e(str2, "createSql");
    }
}
