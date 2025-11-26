package androidx.room;

import W2.J;
import androidx.sqlite.SQLiteStatement;
import k3.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class RoomRawQuery {
    private final l bindingFunction;
    private final String sql;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public RoomRawQuery(String str) {
        this(str, (l) null, 2, (C2633k) null);
        t.e(str, "sql");
    }

    /* access modifiers changed from: private */
    public static final J _init_$lambda$0(SQLiteStatement sQLiteStatement) {
        t.e(sQLiteStatement, "it");
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final J bindingFunction$lambda$1(l lVar, SQLiteStatement sQLiteStatement) {
        t.e(sQLiteStatement, "it");
        lVar.invoke(new BindOnlySQLiteStatement(sQLiteStatement));
        return J.f19942a;
    }

    public final l getBindingFunction() {
        return this.bindingFunction;
    }

    public final String getSql() {
        return this.sql;
    }

    public RoomRawQuery(String str, l lVar) {
        t.e(str, "sql");
        t.e(lVar, "onBindStatement");
        this.sql = str;
        this.bindingFunction = new m(lVar);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ RoomRawQuery(java.lang.String r1, k3.l r2, int r3, kotlin.jvm.internal.C2633k r4) {
        /*
            r0 = this;
            r3 = r3 & 2
            if (r3 == 0) goto L_0x0009
            androidx.room.n r2 = new androidx.room.n
            r2.<init>()
        L_0x0009:
            r0.<init>(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomRawQuery.<init>(java.lang.String, k3.l, int, kotlin.jvm.internal.k):void");
    }
}
