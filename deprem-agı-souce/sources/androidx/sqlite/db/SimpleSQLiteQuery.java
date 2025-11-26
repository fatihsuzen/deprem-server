package androidx.sqlite.db;

import com.mbridge.msdk.MBridgeConstans;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class SimpleSQLiteQuery implements SupportSQLiteQuery {
    public static final Companion Companion = new Companion((C2633k) null);
    private final Object[] bindArgs;
    private final String query;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public final void bind(SupportSQLiteProgram supportSQLiteProgram, Object[] objArr) {
            t.e(supportSQLiteProgram, "statement");
            if (objArr != null) {
                int length = objArr.length;
                int i5 = 0;
                while (i5 < length) {
                    Object obj = objArr[i5];
                    i5++;
                    bind(supportSQLiteProgram, i5, obj);
                }
            }
        }

        private Companion() {
        }

        private final void bind(SupportSQLiteProgram supportSQLiteProgram, int i5, Object obj) {
            if (obj == null) {
                supportSQLiteProgram.bindNull(i5);
            } else if (obj instanceof byte[]) {
                supportSQLiteProgram.bindBlob(i5, (byte[]) obj);
            } else if (obj instanceof Float) {
                supportSQLiteProgram.bindDouble(i5, (double) ((Number) obj).floatValue());
            } else if (obj instanceof Double) {
                supportSQLiteProgram.bindDouble(i5, ((Number) obj).doubleValue());
            } else if (obj instanceof Long) {
                supportSQLiteProgram.bindLong(i5, ((Number) obj).longValue());
            } else if (obj instanceof Integer) {
                supportSQLiteProgram.bindLong(i5, (long) ((Number) obj).intValue());
            } else if (obj instanceof Short) {
                supportSQLiteProgram.bindLong(i5, (long) ((Number) obj).shortValue());
            } else if (obj instanceof Byte) {
                supportSQLiteProgram.bindLong(i5, (long) ((Number) obj).byteValue());
            } else if (obj instanceof String) {
                supportSQLiteProgram.bindString(i5, (String) obj);
            } else if (obj instanceof Boolean) {
                supportSQLiteProgram.bindLong(i5, ((Boolean) obj).booleanValue() ? 1 : 0);
            } else {
                throw new IllegalArgumentException("Cannot bind " + obj + " at index " + i5 + " Supported types: Null, ByteArray, Float, Double, Long, Int, Short, Byte, String");
            }
        }
    }

    public SimpleSQLiteQuery(String str, Object[] objArr) {
        t.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
        this.query = str;
        this.bindArgs = objArr;
    }

    public static final void bind(SupportSQLiteProgram supportSQLiteProgram, Object[] objArr) {
        Companion.bind(supportSQLiteProgram, objArr);
    }

    public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
        t.e(supportSQLiteProgram, "statement");
        Companion.bind(supportSQLiteProgram, this.bindArgs);
    }

    public int getArgCount() {
        Object[] objArr = this.bindArgs;
        if (objArr != null) {
            return objArr.length;
        }
        return 0;
    }

    public String getSql() {
        return this.query;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public SimpleSQLiteQuery(String str) {
        this(str, (Object[]) null);
        t.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
    }
}
