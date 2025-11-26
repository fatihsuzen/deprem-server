package androidx.room.util;

import X2.T;
import androidx.annotation.RestrictTo;
import androidx.room.ColumnInfo;
import androidx.room.driver.SupportSQLiteConnection;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class TableInfo {
    public static final int CREATED_FROM_DATABASE = 2;
    public static final int CREATED_FROM_ENTITY = 1;
    public static final int CREATED_FROM_UNKNOWN = 0;
    public static final Companion Companion = new Companion((C2633k) null);
    public final Map<String, Column> columns;
    public final Set<ForeignKey> foreignKeys;
    public final Set<Index> indices;
    public final String name;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public final TableInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
            t.e(supportSQLiteDatabase, "database");
            t.e(str, "tableName");
            return read((SQLiteConnection) new SupportSQLiteConnection(supportSQLiteDatabase), str);
        }

        private Companion() {
        }

        public final TableInfo read(SQLiteConnection sQLiteConnection, String str) {
            t.e(sQLiteConnection, "connection");
            t.e(str, "tableName");
            return SchemaInfoUtilKt.readTableInfo(sQLiteConnection, str);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface CreatedFrom {
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final class ForeignKey {
        public final List<String> columnNames;
        public final String onDelete;
        public final String onUpdate;
        public final List<String> referenceColumnNames;
        public final String referenceTable;

        public ForeignKey(String str, String str2, String str3, List<String> list, List<String> list2) {
            t.e(str, "referenceTable");
            t.e(str2, "onDelete");
            t.e(str3, "onUpdate");
            t.e(list, "columnNames");
            t.e(list2, "referenceColumnNames");
            this.referenceTable = str;
            this.onDelete = str2;
            this.onUpdate = str3;
            this.columnNames = list;
            this.referenceColumnNames = list2;
        }

        public boolean equals(Object obj) {
            return TableInfoKt.equalsCommon(this, obj);
        }

        public int hashCode() {
            return TableInfoKt.hashCodeCommon(this);
        }

        public String toString() {
            return TableInfoKt.toStringCommon(this);
        }
    }

    public TableInfo(String str, Map<String, Column> map, Set<ForeignKey> set, Set<Index> set2) {
        t.e(str, RewardPlus.NAME);
        t.e(map, "columns");
        t.e(set, "foreignKeys");
        this.name = str;
        this.columns = map;
        this.foreignKeys = set;
        this.indices = set2;
    }

    public static final TableInfo read(SQLiteConnection sQLiteConnection, String str) {
        return Companion.read(sQLiteConnection, str);
    }

    public boolean equals(Object obj) {
        return TableInfoKt.equalsCommon(this, obj);
    }

    public int hashCode() {
        return TableInfoKt.hashCodeCommon(this);
    }

    public String toString() {
        return TableInfoKt.toStringCommon(this);
    }

    public static final TableInfo read(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        return Companion.read(supportSQLiteDatabase, str);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final class Index {
        public static final Companion Companion = new Companion((C2633k) null);
        public static final String DEFAULT_PREFIX = "index_";
        public final List<String> columns;
        public final String name;
        public List<String> orders;
        public final boolean unique;

        public static final class Companion {
            public /* synthetic */ Companion(C2633k kVar) {
                this();
            }

            private Companion() {
            }
        }

        public Index(String str, boolean z4, List<String> list, List<String> list2) {
            t.e(str, RewardPlus.NAME);
            t.e(list, "columns");
            t.e(list2, "orders");
            this.name = str;
            this.unique = z4;
            this.columns = list;
            this.orders = list2;
            Collection collection = list2;
            boolean isEmpty = collection.isEmpty();
            ArrayList arrayList = collection;
            if (isEmpty) {
                int size = list.size();
                ArrayList arrayList2 = new ArrayList(size);
                for (int i5 = 0; i5 < size; i5++) {
                    arrayList2.add("ASC");
                }
                arrayList = arrayList2;
            }
            this.orders = (List) arrayList;
        }

        public boolean equals(Object obj) {
            return TableInfoKt.equalsCommon(this, obj);
        }

        public int hashCode() {
            return TableInfoKt.hashCodeCommon(this);
        }

        public String toString() {
            return TableInfoKt.toStringCommon(this);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public Index(java.lang.String r5, boolean r6, java.util.List<java.lang.String> r7) {
            /*
                r4 = this;
                java.lang.String r0 = "name"
                kotlin.jvm.internal.t.e(r5, r0)
                java.lang.String r0 = "columns"
                kotlin.jvm.internal.t.e(r7, r0)
                int r0 = r7.size()
                java.util.ArrayList r1 = new java.util.ArrayList
                r1.<init>(r0)
                r2 = 0
            L_0x0014:
                if (r2 >= r0) goto L_0x001e
                java.lang.String r3 = "ASC"
                r1.add(r3)
                int r2 = r2 + 1
                goto L_0x0014
            L_0x001e:
                r4.<init>(r5, r6, r7, r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.TableInfo.Index.<init>(java.lang.String, boolean, java.util.List):void");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TableInfo(String str, Map map, Set set, Set set2, int i5, C2633k kVar) {
        this(str, map, set, (i5 & 8) != 0 ? null : set2);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public TableInfo(String str, Map<String, Column> map, Set<ForeignKey> set) {
        this(str, map, set, T.d());
        t.e(str, RewardPlus.NAME);
        t.e(map, "columns");
        t.e(set, "foreignKeys");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final class Column {
        public static final Companion Companion = new Companion((C2633k) null);
        public final int affinity;
        public final int createdFrom;
        public final String defaultValue;
        public final String name;
        public final boolean notNull;
        public final int primaryKeyPosition;
        public final String type;

        public static final class Companion {
            public /* synthetic */ Companion(C2633k kVar) {
                this();
            }

            public final boolean defaultValueEquals(String str, String str2) {
                t.e(str, "current");
                return TableInfoKt.defaultValueEqualsCommon(str, str2);
            }

            private Companion() {
            }
        }

        public Column(String str, String str2, boolean z4, int i5, String str3, int i6) {
            t.e(str, RewardPlus.NAME);
            t.e(str2, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            this.name = str;
            this.type = str2;
            this.notNull = z4;
            this.primaryKeyPosition = i5;
            this.defaultValue = str3;
            this.createdFrom = i6;
            this.affinity = SchemaInfoUtilKt.findAffinity(str2);
        }

        public static final boolean defaultValueEquals(String str, String str2) {
            return Companion.defaultValueEquals(str, str2);
        }

        @ColumnInfo.SQLiteTypeAffinity
        public static /* synthetic */ void getAffinity$annotations() {
        }

        public boolean equals(Object obj) {
            return TableInfoKt.equalsCommon(this, obj);
        }

        public int hashCode() {
            return TableInfoKt.hashCodeCommon(this);
        }

        public final boolean isPrimaryKey() {
            if (this.primaryKeyPosition > 0) {
                return true;
            }
            return false;
        }

        public String toString() {
            return TableInfoKt.toStringCommon(this);
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public Column(String str, String str2, boolean z4, int i5) {
            this(str, str2, z4, i5, (String) null, 0);
            t.e(str, RewardPlus.NAME);
            t.e(str2, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
        }
    }
}
