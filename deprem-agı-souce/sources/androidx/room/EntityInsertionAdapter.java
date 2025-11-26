package androidx.room;

import X2.C2250q;
import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.C2625c;
import kotlin.jvm.internal.t;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class EntityInsertionAdapter<T> extends SharedSQLiteStatement {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EntityInsertionAdapter(RoomDatabase roomDatabase) {
        super(roomDatabase);
        t.e(roomDatabase, "database");
    }

    /* access modifiers changed from: protected */
    public abstract void bind(SupportSQLiteStatement supportSQLiteStatement, T t5);

    public final void insert(T t5) {
        SupportSQLiteStatement acquire = acquire();
        try {
            bind(acquire, t5);
            acquire.executeInsert();
        } finally {
            release(acquire);
        }
    }

    public final long insertAndReturnId(T t5) {
        SupportSQLiteStatement acquire = acquire();
        try {
            bind(acquire, t5);
            return acquire.executeInsert();
        } finally {
            release(acquire);
        }
    }

    public final long[] insertAndReturnIdsArray(Collection<? extends T> collection) {
        t.e(collection, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            long[] jArr = new long[collection.size()];
            int i5 = 0;
            for (Object next : collection) {
                int i6 = i5 + 1;
                if (i5 < 0) {
                    C2250q.o();
                }
                bind(acquire, next);
                jArr[i5] = acquire.executeInsert();
                i5 = i6;
            }
            release(acquire);
            return jArr;
        } catch (Throwable th) {
            release(acquire);
            throw th;
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(Collection<? extends T> collection) {
        t.e(collection, "entities");
        SupportSQLiteStatement acquire = acquire();
        Iterator<? extends T> it = collection.iterator();
        try {
            int size = collection.size();
            Long[] lArr = new Long[size];
            for (int i5 = 0; i5 < size; i5++) {
                bind(acquire, it.next());
                lArr[i5] = Long.valueOf(acquire.executeInsert());
            }
            return lArr;
        } finally {
            release(acquire);
        }
    }

    public final List<Long> insertAndReturnIdsList(T[] tArr) {
        t.e(tArr, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            List c5 = C2250q.c();
            for (T bind : tArr) {
                bind(acquire, bind);
                c5.add(Long.valueOf(acquire.executeInsert()));
            }
            List<Long> a5 = C2250q.a(c5);
            release(acquire);
            return a5;
        } catch (Throwable th) {
            release(acquire);
            throw th;
        }
    }

    public final void insert(T[] tArr) {
        t.e(tArr, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            for (T bind : tArr) {
                bind(acquire, bind);
                acquire.executeInsert();
            }
        } finally {
            release(acquire);
        }
    }

    public final long[] insertAndReturnIdsArray(T[] tArr) {
        t.e(tArr, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            long[] jArr = new long[tArr.length];
            int length = tArr.length;
            int i5 = 0;
            int i6 = 0;
            while (i5 < length) {
                int i7 = i6 + 1;
                bind(acquire, tArr[i5]);
                jArr[i6] = acquire.executeInsert();
                i5++;
                i6 = i7;
            }
            return jArr;
        } finally {
            release(acquire);
        }
    }

    public final Long[] insertAndReturnIdsArrayBox(T[] tArr) {
        t.e(tArr, "entities");
        SupportSQLiteStatement acquire = acquire();
        Iterator a5 = C2625c.a(tArr);
        try {
            int length = tArr.length;
            Long[] lArr = new Long[length];
            for (int i5 = 0; i5 < length; i5++) {
                bind(acquire, a5.next());
                lArr[i5] = Long.valueOf(acquire.executeInsert());
            }
            return lArr;
        } finally {
            release(acquire);
        }
    }

    public final List<Long> insertAndReturnIdsList(Collection<? extends T> collection) {
        t.e(collection, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            List c5 = C2250q.c();
            for (Object bind : collection) {
                bind(acquire, bind);
                c5.add(Long.valueOf(acquire.executeInsert()));
            }
            List<Long> a5 = C2250q.a(c5);
            release(acquire);
            return a5;
        } catch (Throwable th) {
            release(acquire);
            throw th;
        }
    }

    public final void insert(Iterable<? extends T> iterable) {
        t.e(iterable, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            for (Object bind : iterable) {
                bind(acquire, bind);
                acquire.executeInsert();
            }
        } finally {
            release(acquire);
        }
    }
}
