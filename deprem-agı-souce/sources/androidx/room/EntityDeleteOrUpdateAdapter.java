package androidx.room;

import W2.J;
import androidx.annotation.RestrictTo;
import androidx.room.util.SQLiteConnectionUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import i3.C2579a;
import java.util.Iterator;
import kotlin.jvm.internal.C2625c;
import kotlin.jvm.internal.t;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class EntityDeleteOrUpdateAdapter<T> {
    /* access modifiers changed from: protected */
    public abstract void bind(SQLiteStatement sQLiteStatement, T t5);

    /* access modifiers changed from: protected */
    public abstract String createQuery();

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0022, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        i3.C2579a.a(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0026, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int handle(androidx.sqlite.SQLiteConnection r2, T r3) {
        /*
            r1 = this;
            java.lang.String r0 = "connection"
            kotlin.jvm.internal.t.e(r2, r0)
            if (r3 != 0) goto L_0x0009
            r2 = 0
            return r2
        L_0x0009:
            java.lang.String r0 = r1.createQuery()
            androidx.sqlite.SQLiteStatement r0 = r2.prepare(r0)
            r1.bind(r0, r3)     // Catch:{ all -> 0x0020 }
            r0.step()     // Catch:{ all -> 0x0020 }
            r3 = 0
            i3.C2579a.a(r0, r3)
            int r2 = androidx.room.util.SQLiteConnectionUtil.getTotalChangedRows(r2)
            return r2
        L_0x0020:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0022 }
        L_0x0022:
            r3 = move-exception
            i3.C2579a.a(r0, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.EntityDeleteOrUpdateAdapter.handle(androidx.sqlite.SQLiteConnection, java.lang.Object):int");
    }

    public final int handleMultiple(SQLiteConnection sQLiteConnection, Iterable<? extends T> iterable) {
        t.e(sQLiteConnection, "connection");
        int i5 = 0;
        if (iterable == null) {
            return 0;
        }
        SQLiteStatement prepare = sQLiteConnection.prepare(createQuery());
        try {
            for (Object next : iterable) {
                if (next != null) {
                    bind(prepare, next);
                    prepare.step();
                    prepare.reset();
                    i5 += SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection);
                }
            }
            J j5 = J.f19942a;
            C2579a.a(prepare, (Throwable) null);
            return i5;
        } catch (Throwable th) {
            C2579a.a(prepare, th);
            throw th;
        }
    }

    public final int handleMultiple(SQLiteConnection sQLiteConnection, T[] tArr) {
        t.e(sQLiteConnection, "connection");
        int i5 = 0;
        if (tArr == null) {
            return 0;
        }
        SQLiteStatement prepare = sQLiteConnection.prepare(createQuery());
        try {
            Iterator a5 = C2625c.a(tArr);
            while (a5.hasNext()) {
                Object next = a5.next();
                if (next != null) {
                    bind(prepare, next);
                    prepare.step();
                    prepare.reset();
                    i5 += SQLiteConnectionUtil.getTotalChangedRows(sQLiteConnection);
                }
            }
            J j5 = J.f19942a;
            C2579a.a(prepare, (Throwable) null);
            return i5;
        } catch (Throwable th) {
            C2579a.a(prepare, th);
            throw th;
        }
    }
}
