package androidx.sqlite.db;

import java.util.regex.Pattern;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class SupportSQLiteQueryBuilder {
    public static final Companion Companion = new Companion((C2633k) null);
    private static final Pattern limitPattern = Pattern.compile("\\s*\\d+\\s*(,\\s*\\d+\\s*)?");
    private Object[] bindArgs;
    private String[] columns;
    private boolean distinct;
    private String groupBy;
    private String having;
    private String limit;
    private String orderBy;
    private String selection;
    private final String table;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public final SupportSQLiteQueryBuilder builder(String str) {
            t.e(str, "tableName");
            return new SupportSQLiteQueryBuilder(str, (C2633k) null);
        }

        private Companion() {
        }
    }

    public /* synthetic */ SupportSQLiteQueryBuilder(String str, C2633k kVar) {
        this(str);
    }

    private final void appendClause(StringBuilder sb, String str, String str2) {
        if (str2 != null && str2.length() != 0) {
            sb.append(str);
            sb.append(str2);
        }
    }

    private final void appendColumns(StringBuilder sb, String[] strArr) {
        int length = strArr.length;
        for (int i5 = 0; i5 < length; i5++) {
            String str = strArr[i5];
            if (i5 > 0) {
                sb.append(", ");
            }
            sb.append(str);
        }
        sb.append(' ');
    }

    public static final SupportSQLiteQueryBuilder builder(String str) {
        return Companion.builder(str);
    }

    public final SupportSQLiteQueryBuilder columns(String[] strArr) {
        this.columns = strArr;
        return this;
    }

    public final SupportSQLiteQuery create() {
        String str;
        String str2 = this.groupBy;
        if ((str2 != null && str2.length() != 0) || (str = this.having) == null || str.length() == 0) {
            StringBuilder sb = new StringBuilder(120);
            sb.append("SELECT ");
            if (this.distinct) {
                sb.append("DISTINCT ");
            }
            String[] strArr = this.columns;
            if (strArr == null || strArr.length == 0) {
                sb.append("* ");
            } else {
                t.b(strArr);
                appendColumns(sb, strArr);
            }
            sb.append("FROM ");
            sb.append(this.table);
            appendClause(sb, " WHERE ", this.selection);
            appendClause(sb, " GROUP BY ", this.groupBy);
            appendClause(sb, " HAVING ", this.having);
            appendClause(sb, " ORDER BY ", this.orderBy);
            appendClause(sb, " LIMIT ", this.limit);
            return new SimpleSQLiteQuery(sb.toString(), this.bindArgs);
        }
        throw new IllegalArgumentException("HAVING clauses are only permitted when using a groupBy clause");
    }

    public final SupportSQLiteQueryBuilder distinct() {
        this.distinct = true;
        return this;
    }

    public final SupportSQLiteQueryBuilder groupBy(String str) {
        this.groupBy = str;
        return this;
    }

    public final SupportSQLiteQueryBuilder having(String str) {
        this.having = str;
        return this;
    }

    public final SupportSQLiteQueryBuilder limit(String str) {
        t.e(str, "limit");
        boolean matches = limitPattern.matcher(str).matches();
        if (str.length() != 0 && !matches) {
            throw new IllegalArgumentException(("invalid LIMIT clauses:" + str).toString());
        }
        this.limit = str;
        return this;
    }

    public final SupportSQLiteQueryBuilder orderBy(String str) {
        this.orderBy = str;
        return this;
    }

    public final SupportSQLiteQueryBuilder selection(String str, Object[] objArr) {
        this.selection = str;
        this.bindArgs = objArr;
        return this;
    }

    private SupportSQLiteQueryBuilder(String str) {
        this.table = str;
    }
}
