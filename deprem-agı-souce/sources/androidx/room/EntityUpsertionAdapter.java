package androidx.room;

import X2.C2250q;
import android.database.sqlite.SQLiteConstraintException;
import androidx.annotation.RestrictTo;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.t;
import t3.s;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class EntityUpsertionAdapter<T> {
    private final EntityInsertionAdapter<T> insertionAdapter;
    private final EntityDeletionOrUpdateAdapter<T> updateAdapter;

    public EntityUpsertionAdapter(EntityInsertionAdapter<T> entityInsertionAdapter, EntityDeletionOrUpdateAdapter<T> entityDeletionOrUpdateAdapter) {
        t.e(entityInsertionAdapter, "insertionAdapter");
        t.e(entityDeletionOrUpdateAdapter, "updateAdapter");
        this.insertionAdapter = entityInsertionAdapter;
        this.updateAdapter = entityDeletionOrUpdateAdapter;
    }

    private final void checkUniquenessException(SQLiteConstraintException sQLiteConstraintException) {
        String message = sQLiteConstraintException.getMessage();
        if (message == null) {
            throw sQLiteConstraintException;
        } else if (!s.T(message, "unique", true) && !s.V(message, "2067", false, 2, (Object) null) && !s.V(message, "1555", false, 2, (Object) null)) {
            throw sQLiteConstraintException;
        }
    }

    public final void upsert(T t5) {
        try {
            this.insertionAdapter.insert(t5);
        } catch (SQLiteConstraintException e5) {
            checkUniquenessException(e5);
            this.updateAdapter.handle(t5);
        }
    }

    public final long upsertAndReturnId(T t5) {
        try {
            return this.insertionAdapter.insertAndReturnId(t5);
        } catch (SQLiteConstraintException e5) {
            checkUniquenessException(e5);
            this.updateAdapter.handle(t5);
            return -1;
        }
    }

    public final long[] upsertAndReturnIdsArray(T[] tArr) {
        long j5;
        t.e(tArr, "entities");
        int length = tArr.length;
        long[] jArr = new long[length];
        for (int i5 = 0; i5 < length; i5++) {
            try {
                j5 = this.insertionAdapter.insertAndReturnId(tArr[i5]);
            } catch (SQLiteConstraintException e5) {
                checkUniquenessException(e5);
                this.updateAdapter.handle(tArr[i5]);
                j5 = -1;
            }
            jArr[i5] = j5;
        }
        return jArr;
    }

    public final Long[] upsertAndReturnIdsArrayBox(T[] tArr) {
        long j5;
        t.e(tArr, "entities");
        int length = tArr.length;
        Long[] lArr = new Long[length];
        for (int i5 = 0; i5 < length; i5++) {
            try {
                j5 = this.insertionAdapter.insertAndReturnId(tArr[i5]);
            } catch (SQLiteConstraintException e5) {
                checkUniquenessException(e5);
                this.updateAdapter.handle(tArr[i5]);
                j5 = -1;
            }
            lArr[i5] = Long.valueOf(j5);
        }
        return lArr;
    }

    public final List<Long> upsertAndReturnIdsList(T[] tArr) {
        t.e(tArr, "entities");
        List c5 = C2250q.c();
        for (T t5 : tArr) {
            try {
                c5.add(Long.valueOf(this.insertionAdapter.insertAndReturnId(t5)));
            } catch (SQLiteConstraintException e5) {
                checkUniquenessException(e5);
                this.updateAdapter.handle(t5);
                c5.add(-1L);
            }
        }
        return C2250q.a(c5);
    }

    public final void upsert(T[] tArr) {
        t.e(tArr, "entities");
        for (T t5 : tArr) {
            try {
                this.insertionAdapter.insert(t5);
            } catch (SQLiteConstraintException e5) {
                checkUniquenessException(e5);
                this.updateAdapter.handle(t5);
            }
        }
    }

    public final long[] upsertAndReturnIdsArray(Collection<? extends T> collection) {
        long j5;
        t.e(collection, "entities");
        Iterator<? extends T> it = collection.iterator();
        int size = collection.size();
        long[] jArr = new long[size];
        for (int i5 = 0; i5 < size; i5++) {
            Object next = it.next();
            try {
                j5 = this.insertionAdapter.insertAndReturnId(next);
            } catch (SQLiteConstraintException e5) {
                checkUniquenessException(e5);
                this.updateAdapter.handle(next);
                j5 = -1;
            }
            jArr[i5] = j5;
        }
        return jArr;
    }

    public final Long[] upsertAndReturnIdsArrayBox(Collection<? extends T> collection) {
        long j5;
        t.e(collection, "entities");
        Iterator<? extends T> it = collection.iterator();
        int size = collection.size();
        Long[] lArr = new Long[size];
        for (int i5 = 0; i5 < size; i5++) {
            Object next = it.next();
            try {
                j5 = this.insertionAdapter.insertAndReturnId(next);
            } catch (SQLiteConstraintException e5) {
                checkUniquenessException(e5);
                this.updateAdapter.handle(next);
                j5 = -1;
            }
            lArr[i5] = Long.valueOf(j5);
        }
        return lArr;
    }

    public final void upsert(Iterable<? extends T> iterable) {
        t.e(iterable, "entities");
        for (Object next : iterable) {
            try {
                this.insertionAdapter.insert(next);
            } catch (SQLiteConstraintException e5) {
                checkUniquenessException(e5);
                this.updateAdapter.handle(next);
            }
        }
    }

    public final List<Long> upsertAndReturnIdsList(Collection<? extends T> collection) {
        t.e(collection, "entities");
        List c5 = C2250q.c();
        for (Object next : collection) {
            try {
                c5.add(Long.valueOf(this.insertionAdapter.insertAndReturnId(next)));
            } catch (SQLiteConstraintException e5) {
                checkUniquenessException(e5);
                this.updateAdapter.handle(next);
                c5.add(-1L);
            }
        }
        return C2250q.a(c5);
    }
}
