package androidx.room;

import W2.J;
import X2.C2250q;
import androidx.annotation.RestrictTo;
import androidx.room.util.SQLiteConnectionUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import i3.C2579a;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.C2625c;
import kotlin.jvm.internal.t;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class EntityInsertAdapter<T> {
    /* access modifiers changed from: protected */
    public abstract void bind(SQLiteStatement sQLiteStatement, T t5);

    /* access modifiers changed from: protected */
    public abstract String createQuery();

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001e, code lost:
        i3.C2579a.a(r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0021, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void insert(androidx.sqlite.SQLiteConnection r2, T r3) {
        /*
            r1 = this;
            java.lang.String r0 = "connection"
            kotlin.jvm.internal.t.e(r2, r0)
            if (r3 != 0) goto L_0x0008
            return
        L_0x0008:
            java.lang.String r0 = r1.createQuery()
            androidx.sqlite.SQLiteStatement r2 = r2.prepare(r0)
            r1.bind(r2, r3)     // Catch:{ all -> 0x001b }
            r2.step()     // Catch:{ all -> 0x001b }
            r3 = 0
            i3.C2579a.a(r2, r3)
            return
        L_0x001b:
            r3 = move-exception
            throw r3     // Catch:{ all -> 0x001d }
        L_0x001d:
            r0 = move-exception
            i3.C2579a.a(r2, r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.EntityInsertAdapter.insert(androidx.sqlite.SQLiteConnection, java.lang.Object):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0023, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0024, code lost:
        i3.C2579a.a(r0, r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long insertAndReturnId(androidx.sqlite.SQLiteConnection r2, T r3) {
        /*
            r1 = this;
            java.lang.String r0 = "connection"
            kotlin.jvm.internal.t.e(r2, r0)
            if (r3 != 0) goto L_0x000a
            r2 = -1
            return r2
        L_0x000a:
            java.lang.String r0 = r1.createQuery()
            androidx.sqlite.SQLiteStatement r0 = r2.prepare(r0)
            r1.bind(r0, r3)     // Catch:{ all -> 0x0021 }
            r0.step()     // Catch:{ all -> 0x0021 }
            r3 = 0
            i3.C2579a.a(r0, r3)
            long r2 = androidx.room.util.SQLiteConnectionUtil.getLastInsertedRowId(r2)
            return r2
        L_0x0021:
            r2 = move-exception
            throw r2     // Catch:{ all -> 0x0023 }
        L_0x0023:
            r3 = move-exception
            i3.C2579a.a(r0, r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.EntityInsertAdapter.insertAndReturnId(androidx.sqlite.SQLiteConnection, java.lang.Object):long");
    }

    public final long[] insertAndReturnIdsArray(SQLiteConnection sQLiteConnection, Collection<? extends T> collection) {
        long j5;
        t.e(sQLiteConnection, "connection");
        if (collection == null) {
            return new long[0];
        }
        SQLiteStatement prepare = sQLiteConnection.prepare(createQuery());
        try {
            int size = collection.size();
            long[] jArr = new long[size];
            for (int i5 = 0; i5 < size; i5++) {
                Object G4 = C2250q.G(collection, i5);
                if (G4 != null) {
                    bind(prepare, G4);
                    prepare.step();
                    prepare.reset();
                    j5 = SQLiteConnectionUtil.getLastInsertedRowId(sQLiteConnection);
                } else {
                    j5 = -1;
                }
                jArr[i5] = j5;
            }
            C2579a.a(prepare, (Throwable) null);
            return jArr;
        } catch (Throwable th) {
            C2579a.a(prepare, th);
            throw th;
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(SQLiteConnection sQLiteConnection, Collection<? extends T> collection) {
        long j5;
        t.e(sQLiteConnection, "connection");
        if (collection == null) {
            return new Long[0];
        }
        SQLiteStatement prepare = sQLiteConnection.prepare(createQuery());
        try {
            int size = collection.size();
            Long[] lArr = new Long[size];
            for (int i5 = 0; i5 < size; i5++) {
                Object G4 = C2250q.G(collection, i5);
                if (G4 != null) {
                    bind(prepare, G4);
                    prepare.step();
                    prepare.reset();
                    j5 = SQLiteConnectionUtil.getLastInsertedRowId(sQLiteConnection);
                } else {
                    j5 = -1;
                }
                lArr[i5] = Long.valueOf(j5);
            }
            C2579a.a(prepare, (Throwable) null);
            return lArr;
        } catch (Throwable th) {
            C2579a.a(prepare, th);
            throw th;
        }
    }

    public final List<Long> insertAndReturnIdsList(SQLiteConnection sQLiteConnection, T[] tArr) {
        t.e(sQLiteConnection, "connection");
        if (tArr == null) {
            return C2250q.g();
        }
        List c5 = C2250q.c();
        SQLiteStatement prepare = sQLiteConnection.prepare(createQuery());
        try {
            for (T t5 : tArr) {
                if (t5 != null) {
                    bind(prepare, t5);
                    prepare.step();
                    prepare.reset();
                    c5.add(Long.valueOf(SQLiteConnectionUtil.getLastInsertedRowId(sQLiteConnection)));
                } else {
                    c5.add(-1L);
                }
            }
            J j5 = J.f19942a;
            C2579a.a(prepare, (Throwable) null);
            return C2250q.a(c5);
        } catch (Throwable th) {
            C2579a.a(prepare, th);
            throw th;
        }
    }

    public final void insert(SQLiteConnection sQLiteConnection, T[] tArr) {
        t.e(sQLiteConnection, "connection");
        if (tArr != null) {
            SQLiteStatement prepare = sQLiteConnection.prepare(createQuery());
            try {
                Iterator a5 = C2625c.a(tArr);
                while (a5.hasNext()) {
                    Object next = a5.next();
                    if (next != null) {
                        bind(prepare, next);
                        prepare.step();
                        prepare.reset();
                    }
                }
                J j5 = J.f19942a;
                C2579a.a(prepare, (Throwable) null);
            } catch (Throwable th) {
                C2579a.a(prepare, th);
                throw th;
            }
        }
    }

    public final long[] insertAndReturnIdsArray(SQLiteConnection sQLiteConnection, T[] tArr) {
        long j5;
        t.e(sQLiteConnection, "connection");
        if (tArr == null) {
            return new long[0];
        }
        SQLiteStatement prepare = sQLiteConnection.prepare(createQuery());
        try {
            int length = tArr.length;
            long[] jArr = new long[length];
            for (int i5 = 0; i5 < length; i5++) {
                T t5 = tArr[i5];
                if (t5 != null) {
                    bind(prepare, t5);
                    prepare.step();
                    prepare.reset();
                    j5 = SQLiteConnectionUtil.getLastInsertedRowId(sQLiteConnection);
                } else {
                    j5 = -1;
                }
                jArr[i5] = j5;
            }
            C2579a.a(prepare, (Throwable) null);
            return jArr;
        } catch (Throwable th) {
            C2579a.a(prepare, th);
            throw th;
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(SQLiteConnection sQLiteConnection, T[] tArr) {
        long j5;
        t.e(sQLiteConnection, "connection");
        if (tArr == null) {
            return new Long[0];
        }
        SQLiteStatement prepare = sQLiteConnection.prepare(createQuery());
        try {
            int length = tArr.length;
            Long[] lArr = new Long[length];
            for (int i5 = 0; i5 < length; i5++) {
                T t5 = tArr[i5];
                if (t5 != null) {
                    bind(prepare, t5);
                    prepare.step();
                    prepare.reset();
                    j5 = SQLiteConnectionUtil.getLastInsertedRowId(sQLiteConnection);
                } else {
                    j5 = -1;
                }
                lArr[i5] = Long.valueOf(j5);
            }
            C2579a.a(prepare, (Throwable) null);
            return lArr;
        } catch (Throwable th) {
            C2579a.a(prepare, th);
            throw th;
        }
    }

    public final void insert(SQLiteConnection sQLiteConnection, Iterable<? extends T> iterable) {
        t.e(sQLiteConnection, "connection");
        if (iterable != null) {
            SQLiteStatement prepare = sQLiteConnection.prepare(createQuery());
            try {
                for (Object next : iterable) {
                    if (next != null) {
                        bind(prepare, next);
                        prepare.step();
                        prepare.reset();
                    }
                }
                J j5 = J.f19942a;
                C2579a.a(prepare, (Throwable) null);
            } catch (Throwable th) {
                C2579a.a(prepare, th);
                throw th;
            }
        }
    }

    public final List<Long> insertAndReturnIdsList(SQLiteConnection sQLiteConnection, Collection<? extends T> collection) {
        t.e(sQLiteConnection, "connection");
        if (collection == null) {
            return C2250q.g();
        }
        List c5 = C2250q.c();
        SQLiteStatement prepare = sQLiteConnection.prepare(createQuery());
        try {
            for (Object next : collection) {
                if (next != null) {
                    bind(prepare, next);
                    prepare.step();
                    prepare.reset();
                    c5.add(Long.valueOf(SQLiteConnectionUtil.getLastInsertedRowId(sQLiteConnection)));
                } else {
                    c5.add(-1L);
                }
            }
            J j5 = J.f19942a;
            C2579a.a(prepare, (Throwable) null);
            return C2250q.a(c5);
        } catch (Throwable th) {
            C2579a.a(prepare, th);
            throw th;
        }
    }
}
