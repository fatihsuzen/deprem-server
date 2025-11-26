package androidx.room.util;

import W2.J;
import X2.C2250q;
import androidx.room.util.TableInfo;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import k3.l;
import kotlin.jvm.internal.t;
import t3.s;

public final class TableInfoKt {
    private static final boolean containsSurroundingParenthesis(String str) {
        if (str.length() == 0) {
            return false;
        }
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        while (i5 < str.length()) {
            char charAt = str.charAt(i5);
            int i8 = i7 + 1;
            if (i7 == 0 && charAt != '(') {
                return false;
            }
            if (charAt == '(') {
                i6++;
            } else if (charAt == ')' && i6 - 1 == 0 && i7 != str.length() - 1) {
                return false;
            }
            i5++;
            i7 = i8;
        }
        if (i6 == 0) {
            return true;
        }
        return false;
    }

    public static final boolean defaultValueEqualsCommon(String str, String str2) {
        t.e(str, "current");
        if (t.a(str, str2)) {
            return true;
        }
        if (!containsSurroundingParenthesis(str)) {
            return false;
        }
        String substring = str.substring(1, str.length() - 1);
        t.d(substring, "substring(...)");
        return t.a(s.W0(substring).toString(), str2);
    }

    public static final boolean equalsCommon(TableInfo tableInfo, Object obj) {
        Set<TableInfo.Index> set;
        t.e(tableInfo, "<this>");
        if (tableInfo == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo)) {
            return false;
        }
        TableInfo tableInfo2 = (TableInfo) obj;
        if (!t.a(tableInfo.name, tableInfo2.name) || !t.a(tableInfo.columns, tableInfo2.columns) || !t.a(tableInfo.foreignKeys, tableInfo2.foreignKeys)) {
            return false;
        }
        Set<TableInfo.Index> set2 = tableInfo.indices;
        if (set2 == null || (set = tableInfo2.indices) == null) {
            return true;
        }
        return t.a(set2, set);
    }

    public static final String formatString(Collection<?> collection) {
        t.e(collection, "collection");
        if (collection.isEmpty()) {
            return " }";
        }
        return s.j(C2250q.V(collection, ",\n", "\n", "\n", 0, (CharSequence) null, (l) null, 56, (Object) null), (String) null, 1, (Object) null) + "},";
    }

    public static final int hashCodeCommon(TableInfo tableInfo) {
        t.e(tableInfo, "<this>");
        return (((tableInfo.name.hashCode() * 31) + tableInfo.columns.hashCode()) * 31) + tableInfo.foreignKeys.hashCode();
    }

    private static final void joinToStringEndWithIndent(Collection<?> collection) {
        s.j(C2250q.V(collection, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (l) null, 62, (Object) null), (String) null, 1, (Object) null);
        s.j(" }", (String) null, 1, (Object) null);
    }

    private static final void joinToStringMiddleWithIndent(Collection<?> collection) {
        s.j(C2250q.V(collection, ",", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (l) null, 62, (Object) null), (String) null, 1, (Object) null);
        s.j("},", (String) null, 1, (Object) null);
    }

    public static final String toStringCommon(TableInfo tableInfo) {
        List list;
        t.e(tableInfo, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append("\n            |TableInfo {\n            |    name = '");
        sb.append(tableInfo.name);
        sb.append("',\n            |    columns = {");
        sb.append(formatString(C2250q.h0(tableInfo.columns.values(), new TableInfoKt$toStringCommon$$inlined$sortedBy$1())));
        sb.append("\n            |    foreignKeys = {");
        sb.append(formatString(tableInfo.foreignKeys));
        sb.append("\n            |    indices = {");
        Set<TableInfo.Index> set = tableInfo.indices;
        if (set == null || (list = C2250q.h0(set, new TableInfoKt$toStringCommon$$inlined$sortedBy$2())) == null) {
            list = C2250q.g();
        }
        sb.append(formatString(list));
        sb.append("\n            |}\n        ");
        return s.p(sb.toString(), (String) null, 1, (Object) null);
    }

    public static final int hashCodeCommon(TableInfo.Column column) {
        t.e(column, "<this>");
        return (((((column.name.hashCode() * 31) + column.affinity) * 31) + (column.notNull ? 1231 : 1237)) * 31) + column.primaryKeyPosition;
    }

    public static final boolean equalsCommon(TableInfo.Column column, Object obj) {
        t.e(column, "<this>");
        if (column == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo.Column)) {
            return false;
        }
        TableInfo.Column column2 = (TableInfo.Column) obj;
        if (column.isPrimaryKey() != column2.isPrimaryKey() || !t.a(column.name, column2.name) || column.notNull != column2.notNull) {
            return false;
        }
        String str = column.defaultValue;
        String str2 = column2.defaultValue;
        if (column.createdFrom == 1 && column2.createdFrom == 2 && str != null && !defaultValueEqualsCommon(str, str2)) {
            return false;
        }
        if (column.createdFrom == 2 && column2.createdFrom == 1 && str2 != null && !defaultValueEqualsCommon(str2, str)) {
            return false;
        }
        int i5 = column.createdFrom;
        return (i5 == 0 || i5 != column2.createdFrom || (str == null ? str2 == null : defaultValueEqualsCommon(str, str2))) && column.affinity == column2.affinity;
    }

    public static final int hashCodeCommon(TableInfo.ForeignKey foreignKey) {
        t.e(foreignKey, "<this>");
        return (((((((foreignKey.referenceTable.hashCode() * 31) + foreignKey.onDelete.hashCode()) * 31) + foreignKey.onUpdate.hashCode()) * 31) + foreignKey.columnNames.hashCode()) * 31) + foreignKey.referenceColumnNames.hashCode();
    }

    public static final int hashCodeCommon(TableInfo.Index index) {
        int i5;
        t.e(index, "<this>");
        if (s.P(index.name, TableInfo.Index.DEFAULT_PREFIX, false, 2, (Object) null)) {
            i5 = -1184239155;
        } else {
            i5 = index.name.hashCode();
        }
        return (((((i5 * 31) + (index.unique ? 1 : 0)) * 31) + index.columns.hashCode()) * 31) + index.orders.hashCode();
    }

    public static final boolean equalsCommon(TableInfo.ForeignKey foreignKey, Object obj) {
        t.e(foreignKey, "<this>");
        if (foreignKey == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo.ForeignKey)) {
            return false;
        }
        TableInfo.ForeignKey foreignKey2 = (TableInfo.ForeignKey) obj;
        if (t.a(foreignKey.referenceTable, foreignKey2.referenceTable) && t.a(foreignKey.onDelete, foreignKey2.onDelete) && t.a(foreignKey.onUpdate, foreignKey2.onUpdate) && t.a(foreignKey.columnNames, foreignKey2.columnNames)) {
            return t.a(foreignKey.referenceColumnNames, foreignKey2.referenceColumnNames);
        }
        return false;
    }

    public static final String toStringCommon(TableInfo.Column column) {
        t.e(column, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append("\n            |Column {\n            |   name = '");
        sb.append(column.name);
        sb.append("',\n            |   type = '");
        sb.append(column.type);
        sb.append("',\n            |   affinity = '");
        sb.append(column.affinity);
        sb.append("',\n            |   notNull = '");
        sb.append(column.notNull);
        sb.append("',\n            |   primaryKeyPosition = '");
        sb.append(column.primaryKeyPosition);
        sb.append("',\n            |   defaultValue = '");
        String str = column.defaultValue;
        if (str == null) {
            str = "undefined";
        }
        sb.append(str);
        sb.append("'\n            |}\n        ");
        return s.j(s.p(sb.toString(), (String) null, 1, (Object) null), (String) null, 1, (Object) null);
    }

    public static final boolean equalsCommon(TableInfo.Index index, Object obj) {
        t.e(index, "<this>");
        if (index == obj) {
            return true;
        }
        if (!(obj instanceof TableInfo.Index)) {
            return false;
        }
        TableInfo.Index index2 = (TableInfo.Index) obj;
        if (index.unique != index2.unique || !t.a(index.columns, index2.columns) || !t.a(index.orders, index2.orders)) {
            return false;
        }
        if (s.P(index.name, TableInfo.Index.DEFAULT_PREFIX, false, 2, (Object) null)) {
            return s.P(index2.name, TableInfo.Index.DEFAULT_PREFIX, false, 2, (Object) null);
        }
        return t.a(index.name, index2.name);
    }

    public static final String toStringCommon(TableInfo.ForeignKey foreignKey) {
        t.e(foreignKey, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append("\n            |ForeignKey {\n            |   referenceTable = '");
        sb.append(foreignKey.referenceTable);
        sb.append("',\n            |   onDelete = '");
        sb.append(foreignKey.onDelete);
        sb.append("',\n            |   onUpdate = '");
        sb.append(foreignKey.onUpdate);
        sb.append("',\n            |   columnNames = {");
        joinToStringMiddleWithIndent(C2250q.g0(foreignKey.columnNames));
        J j5 = J.f19942a;
        sb.append(j5);
        sb.append("\n            |   referenceColumnNames = {");
        joinToStringEndWithIndent(C2250q.g0(foreignKey.referenceColumnNames));
        sb.append(j5);
        sb.append("\n            |}\n        ");
        return s.j(s.p(sb.toString(), (String) null, 1, (Object) null), (String) null, 1, (Object) null);
    }

    public static final String toStringCommon(TableInfo.Index index) {
        t.e(index, "<this>");
        StringBuilder sb = new StringBuilder();
        sb.append("\n            |Index {\n            |   name = '");
        sb.append(index.name);
        sb.append("',\n            |   unique = '");
        sb.append(index.unique);
        sb.append("',\n            |   columns = {");
        joinToStringMiddleWithIndent(index.columns);
        J j5 = J.f19942a;
        sb.append(j5);
        sb.append("\n            |   orders = {");
        joinToStringEndWithIndent(index.orders);
        sb.append(j5);
        sb.append("\n            |}\n        ");
        return s.j(s.p(sb.toString(), (String) null, 1, (Object) null), (String) null, 1, (Object) null);
    }
}
