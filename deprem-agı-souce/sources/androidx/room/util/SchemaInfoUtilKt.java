package androidx.room.util;

import W2.J;
import X2.C2241h;
import X2.C2250q;
import X2.M;
import X2.T;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.room.ColumnInfo;
import androidx.room.util.TableInfo;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import i3.C2579a;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.t;
import t3.s;

public final class SchemaInfoUtilKt {
    private static final String[] FTS_OPTIONS = {"tokenize=", "compress=", "content=", "languageid=", "matchinfo=", "notindexed=", "order=", "prefix=", "uncompress="};

    @ColumnInfo.SQLiteTypeAffinity
    public static final int findAffinity(String str) {
        if (str == null) {
            return 5;
        }
        String upperCase = str.toUpperCase(Locale.ROOT);
        t.d(upperCase, "toUpperCase(...)");
        if (s.V(upperCase, "INT", false, 2, (Object) null)) {
            return 3;
        }
        if (s.V(upperCase, "CHAR", false, 2, (Object) null) || s.V(upperCase, "CLOB", false, 2, (Object) null) || s.V(upperCase, "TEXT", false, 2, (Object) null)) {
            return 2;
        }
        if (s.V(upperCase, "BLOB", false, 2, (Object) null)) {
            return 5;
        }
        if (s.V(upperCase, "REAL", false, 2, (Object) null) || s.V(upperCase, "FLOA", false, 2, (Object) null) || s.V(upperCase, "DOUB", false, 2, (Object) null)) {
            return 4;
        }
        return 1;
    }

    public static final Set<String> parseFtsOptions(String str) {
        int i5;
        boolean z4;
        Character ch;
        t.e(str, "createStatement");
        if (str.length() == 0) {
            return T.d();
        }
        String str2 = str;
        String substring = str2.substring(s.e0(str2, '(', 0, false, 6, (Object) null) + 1, s.k0(str2, ')', 0, false, 6, (Object) null));
        t.d(substring, "substring(...)");
        ArrayList arrayList = new ArrayList();
        C2241h hVar = new C2241h();
        int i6 = -1;
        int i7 = 0;
        int i8 = 0;
        while (i7 < substring.length()) {
            char charAt = substring.charAt(i7);
            int i9 = i8 + 1;
            if (!(charAt == '\"' || charAt == '\'')) {
                if (charAt != ',') {
                    if (charAt != '[') {
                        if (charAt != ']') {
                            if (charAt != '`') {
                            }
                        } else if (!hVar.isEmpty() && (ch = (Character) hVar.l()) != null && ch.charValue() == '[') {
                            C2250q.z(hVar);
                        }
                    } else if (hVar.isEmpty()) {
                        hVar.addFirst(Character.valueOf(charAt));
                    }
                } else if (hVar.isEmpty()) {
                    String substring2 = substring.substring(i6 + 1, i8);
                    t.d(substring2, "substring(...)");
                    int length = substring2.length() - 1;
                    int i10 = 0;
                    boolean z5 = false;
                    while (i10 <= length) {
                        if (!z5) {
                            i5 = i10;
                        } else {
                            i5 = length;
                        }
                        if (t.g(substring2.charAt(i5), 32) <= 0) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (!z5) {
                            if (!z4) {
                                z5 = true;
                            } else {
                                i10++;
                            }
                        } else if (!z4) {
                            break;
                        } else {
                            length--;
                        }
                    }
                    arrayList.add(substring2.subSequence(i10, length + 1).toString());
                    i6 = i8;
                }
                i7++;
                i8 = i9;
            }
            if (hVar.isEmpty()) {
                hVar.addFirst(Character.valueOf(charAt));
            } else {
                Character ch2 = (Character) hVar.l();
                if (ch2 != null && ch2.charValue() == charAt) {
                    C2250q.z(hVar);
                }
            }
            i7++;
            i8 = i9;
        }
        String substring3 = substring.substring(i6 + 1);
        t.d(substring3, "substring(...)");
        arrayList.add(s.W0(substring3).toString());
        ArrayList arrayList2 = new ArrayList();
        int size = arrayList.size();
        int i11 = 0;
        while (i11 < size) {
            Object obj = arrayList.get(i11);
            i11++;
            String str3 = (String) obj;
            String[] strArr = FTS_OPTIONS;
            int length2 = strArr.length;
            int i12 = 0;
            while (true) {
                if (i12 >= length2) {
                    break;
                } else if (s.P(str3, strArr[i12], false, 2, (Object) null)) {
                    arrayList2.add(obj);
                    break;
                } else {
                    i12++;
                }
            }
        }
        return C2250q.r0(arrayList2);
    }

    private static final Map<String, TableInfo.Column> readColumns(SQLiteConnection sQLiteConnection, String str) {
        Throwable th;
        boolean z4;
        String str2;
        SQLiteStatement prepare = sQLiteConnection.prepare("PRAGMA table_info(`" + str + "`)");
        try {
            if (!prepare.step()) {
                Map<String, TableInfo.Column> h5 = M.h();
                C2579a.a(prepare, (Throwable) null);
                return h5;
            }
            int columnIndexOf = SQLiteStatementUtil.columnIndexOf(prepare, RewardPlus.NAME);
            int columnIndexOf2 = SQLiteStatementUtil.columnIndexOf(prepare, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY);
            int columnIndexOf3 = SQLiteStatementUtil.columnIndexOf(prepare, "notnull");
            int columnIndexOf4 = SQLiteStatementUtil.columnIndexOf(prepare, "pk");
            int columnIndexOf5 = SQLiteStatementUtil.columnIndexOf(prepare, "dflt_value");
            Map c5 = M.c();
            do {
                String text = prepare.getText(columnIndexOf);
                String text2 = prepare.getText(columnIndexOf2);
                if (prepare.getLong(columnIndexOf3) != 0) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                boolean z5 = z4;
                int i5 = (int) prepare.getLong(columnIndexOf4);
                if (prepare.isNull(columnIndexOf5)) {
                    str2 = null;
                } else {
                    str2 = prepare.getText(columnIndexOf5);
                }
                c5.put(text, new TableInfo.Column(text, text2, z5, i5, str2, 2));
            } while (prepare.step());
            Map<String, TableInfo.Column> b5 = M.b(c5);
            C2579a.a(prepare, (Throwable) null);
            return b5;
        } catch (Throwable th2) {
            C2579a.a(prepare, th);
            throw th2;
        }
    }

    private static final List<ForeignKeyWithSequence> readForeignKeyFieldMappings(SQLiteStatement sQLiteStatement) {
        int columnIndexOf = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, "id");
        int columnIndexOf2 = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, "seq");
        int columnIndexOf3 = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, TypedValues.TransitionType.S_FROM);
        int columnIndexOf4 = SQLiteStatementUtil.columnIndexOf(sQLiteStatement, TypedValues.TransitionType.S_TO);
        List c5 = C2250q.c();
        while (sQLiteStatement.step()) {
            c5.add(new ForeignKeyWithSequence((int) sQLiteStatement.getLong(columnIndexOf), (int) sQLiteStatement.getLong(columnIndexOf2), sQLiteStatement.getText(columnIndexOf3), sQLiteStatement.getText(columnIndexOf4)));
        }
        return C2250q.g0(C2250q.a(c5));
    }

    private static final Set<TableInfo.ForeignKey> readForeignKeys(SQLiteConnection sQLiteConnection, String str) {
        Throwable th;
        SQLiteStatement prepare = sQLiteConnection.prepare("PRAGMA foreign_key_list(`" + str + "`)");
        try {
            int columnIndexOf = SQLiteStatementUtil.columnIndexOf(prepare, "id");
            int columnIndexOf2 = SQLiteStatementUtil.columnIndexOf(prepare, "seq");
            int columnIndexOf3 = SQLiteStatementUtil.columnIndexOf(prepare, "table");
            int columnIndexOf4 = SQLiteStatementUtil.columnIndexOf(prepare, "on_delete");
            int columnIndexOf5 = SQLiteStatementUtil.columnIndexOf(prepare, "on_update");
            List<ForeignKeyWithSequence> readForeignKeyFieldMappings = readForeignKeyFieldMappings(prepare);
            prepare.reset();
            Set b5 = T.b();
            while (prepare.step()) {
                if (prepare.getLong(columnIndexOf2) == 0) {
                    int i5 = (int) prepare.getLong(columnIndexOf);
                    ArrayList arrayList = new ArrayList();
                    ArrayList arrayList2 = new ArrayList();
                    ArrayList arrayList3 = new ArrayList();
                    for (Object next : readForeignKeyFieldMappings) {
                        if (((ForeignKeyWithSequence) next).getId() == i5) {
                            arrayList3.add(next);
                        }
                    }
                    int size = arrayList3.size();
                    int i6 = 0;
                    while (i6 < size) {
                        Object obj = arrayList3.get(i6);
                        i6++;
                        ForeignKeyWithSequence foreignKeyWithSequence = (ForeignKeyWithSequence) obj;
                        arrayList.add(foreignKeyWithSequence.getFrom());
                        arrayList2.add(foreignKeyWithSequence.getTo());
                    }
                    b5.add(new TableInfo.ForeignKey(prepare.getText(columnIndexOf3), prepare.getText(columnIndexOf4), prepare.getText(columnIndexOf5), arrayList, arrayList2));
                }
            }
            Set<TableInfo.ForeignKey> a5 = T.a(b5);
            C2579a.a(prepare, (Throwable) null);
            return a5;
        } catch (Throwable th2) {
            C2579a.a(prepare, th);
            throw th2;
        }
    }

    public static final Set<String> readFtsColumns(SQLiteConnection sQLiteConnection, String str) {
        t.e(sQLiteConnection, "connection");
        t.e(str, "tableName");
        Set b5 = T.b();
        SQLiteStatement prepare = sQLiteConnection.prepare("PRAGMA table_info(`" + str + "`)");
        try {
            if (prepare.step()) {
                int columnIndexOf = SQLiteStatementUtil.columnIndexOf(prepare, RewardPlus.NAME);
                do {
                    b5.add(prepare.getText(columnIndexOf));
                } while (prepare.step());
            }
            J j5 = J.f19942a;
            C2579a.a(prepare, (Throwable) null);
            return T.a(b5);
        } catch (Throwable th) {
            C2579a.a(prepare, th);
            throw th;
        }
    }

    public static final Set<String> readFtsOptions(SQLiteConnection sQLiteConnection, String str) {
        String str2;
        t.e(sQLiteConnection, "connection");
        t.e(str, "tableName");
        SQLiteStatement prepare = sQLiteConnection.prepare("SELECT * FROM sqlite_master WHERE `name` = '" + str + '\'');
        try {
            if (prepare.step()) {
                str2 = prepare.getText(SQLiteStatementUtil.columnIndexOf(prepare, "sql"));
            } else {
                str2 = "";
            }
            C2579a.a(prepare, (Throwable) null);
            return parseFtsOptions(str2);
        } catch (Throwable th) {
            C2579a.a(prepare, th);
            throw th;
        }
    }

    private static final TableInfo.Index readIndex(SQLiteConnection sQLiteConnection, String str, boolean z4) {
        String str2;
        SQLiteStatement prepare = sQLiteConnection.prepare("PRAGMA index_xinfo(`" + str + "`)");
        try {
            int columnIndexOf = SQLiteStatementUtil.columnIndexOf(prepare, "seqno");
            int columnIndexOf2 = SQLiteStatementUtil.columnIndexOf(prepare, "cid");
            int columnIndexOf3 = SQLiteStatementUtil.columnIndexOf(prepare, RewardPlus.NAME);
            int columnIndexOf4 = SQLiteStatementUtil.columnIndexOf(prepare, CampaignEx.JSON_KEY_DESC);
            if (!(columnIndexOf == -1 || columnIndexOf2 == -1 || columnIndexOf3 == -1)) {
                if (columnIndexOf4 != -1) {
                    LinkedHashMap linkedHashMap = new LinkedHashMap();
                    LinkedHashMap linkedHashMap2 = new LinkedHashMap();
                    while (prepare.step()) {
                        if (((int) prepare.getLong(columnIndexOf2)) >= 0) {
                            int i5 = (int) prepare.getLong(columnIndexOf);
                            String text = prepare.getText(columnIndexOf3);
                            if (prepare.getLong(columnIndexOf4) > 0) {
                                str2 = "DESC";
                            } else {
                                str2 = "ASC";
                            }
                            linkedHashMap.put(Integer.valueOf(i5), text);
                            linkedHashMap2.put(Integer.valueOf(i5), str2);
                        }
                    }
                    Iterable<Map.Entry> h02 = C2250q.h0(linkedHashMap.entrySet(), new SchemaInfoUtilKt$readIndex$lambda$13$$inlined$sortedBy$1());
                    ArrayList arrayList = new ArrayList(C2250q.p(h02, 10));
                    for (Map.Entry value : h02) {
                        arrayList.add((String) value.getValue());
                    }
                    List n02 = C2250q.n0(arrayList);
                    Iterable<Map.Entry> h03 = C2250q.h0(linkedHashMap2.entrySet(), new SchemaInfoUtilKt$readIndex$lambda$13$$inlined$sortedBy$2());
                    ArrayList arrayList2 = new ArrayList(C2250q.p(h03, 10));
                    for (Map.Entry value2 : h03) {
                        arrayList2.add((String) value2.getValue());
                    }
                    TableInfo.Index index = new TableInfo.Index(str, z4, n02, C2250q.n0(arrayList2));
                    C2579a.a(prepare, (Throwable) null);
                    return index;
                }
            }
            C2579a.a(prepare, (Throwable) null);
            return null;
        } catch (Throwable th) {
            C2579a.a(prepare, th);
            throw th;
        }
    }

    private static final Set<TableInfo.Index> readIndices(SQLiteConnection sQLiteConnection, String str) {
        boolean z4;
        SQLiteStatement prepare = sQLiteConnection.prepare("PRAGMA index_list(`" + str + "`)");
        try {
            int columnIndexOf = SQLiteStatementUtil.columnIndexOf(prepare, RewardPlus.NAME);
            int columnIndexOf2 = SQLiteStatementUtil.columnIndexOf(prepare, TtmlNode.ATTR_TTS_ORIGIN);
            int columnIndexOf3 = SQLiteStatementUtil.columnIndexOf(prepare, "unique");
            if (!(columnIndexOf == -1 || columnIndexOf2 == -1)) {
                if (columnIndexOf3 != -1) {
                    Set b5 = T.b();
                    while (prepare.step()) {
                        if (t.a("c", prepare.getText(columnIndexOf2))) {
                            String text = prepare.getText(columnIndexOf);
                            if (prepare.getLong(columnIndexOf3) == 1) {
                                z4 = true;
                            } else {
                                z4 = false;
                            }
                            TableInfo.Index readIndex = readIndex(sQLiteConnection, text, z4);
                            if (readIndex == null) {
                                C2579a.a(prepare, (Throwable) null);
                                return null;
                            }
                            b5.add(readIndex);
                        }
                    }
                    Set<TableInfo.Index> a5 = T.a(b5);
                    C2579a.a(prepare, (Throwable) null);
                    return a5;
                }
            }
            C2579a.a(prepare, (Throwable) null);
            return null;
        } catch (Throwable th) {
            C2579a.a(prepare, th);
            throw th;
        }
    }

    public static final TableInfo readTableInfo(SQLiteConnection sQLiteConnection, String str) {
        t.e(sQLiteConnection, "connection");
        t.e(str, "tableName");
        return new TableInfo(str, readColumns(sQLiteConnection, str), readForeignKeys(sQLiteConnection, str), readIndices(sQLiteConnection, str));
    }

    public static final ViewInfo readViewInfo(SQLiteConnection sQLiteConnection, String str) {
        ViewInfo viewInfo;
        t.e(sQLiteConnection, "connection");
        t.e(str, "viewName");
        SQLiteStatement prepare = sQLiteConnection.prepare("SELECT name, sql FROM sqlite_master WHERE type = 'view' AND name = '" + str + '\'');
        try {
            if (prepare.step()) {
                viewInfo = new ViewInfo(prepare.getText(0), prepare.getText(1));
            } else {
                viewInfo = new ViewInfo(str, (String) null);
            }
            C2579a.a(prepare, (Throwable) null);
            return viewInfo;
        } catch (Throwable th) {
            C2579a.a(prepare, th);
            throw th;
        }
    }
}
