package androidx.room;

import X2.C2250q;
import android.database.SQLException;
import androidx.annotation.RestrictTo;
import androidx.sqlite.SQLiteConnection;
import java.util.Collection;
import java.util.List;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import t3.s;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class EntityUpsertAdapter<T> {
    public static final Companion Companion = new Companion((C2633k) null);
    private static final String ErrorMsg = "unique";
    private static final String SQLITE_CONSTRAINT_PRIMARYKEY = "1555";
    private static final String SQLITE_CONSTRAINT_UNIQUE = "2067";
    private final EntityInsertAdapter<T> entityInsertAdapter;
    private final EntityDeleteOrUpdateAdapter<T> updateAdapter;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        private Companion() {
        }
    }

    public EntityUpsertAdapter(EntityInsertAdapter<T> entityInsertAdapter2, EntityDeleteOrUpdateAdapter<T> entityDeleteOrUpdateAdapter) {
        t.e(entityInsertAdapter2, "entityInsertAdapter");
        t.e(entityDeleteOrUpdateAdapter, "updateAdapter");
        this.entityInsertAdapter = entityInsertAdapter2;
        this.updateAdapter = entityDeleteOrUpdateAdapter;
    }

    private final void checkUniquenessException(SQLException sQLException) {
        String message = sQLException.getMessage();
        if (message == null) {
            throw sQLException;
        } else if (!s.T(message, ErrorMsg, true) && !s.V(message, SQLITE_CONSTRAINT_UNIQUE, false, 2, (Object) null) && !s.V(message, SQLITE_CONSTRAINT_PRIMARYKEY, false, 2, (Object) null)) {
            throw sQLException;
        }
    }

    public final void upsert(SQLiteConnection sQLiteConnection, T t5) {
        t.e(sQLiteConnection, "connection");
        try {
            this.entityInsertAdapter.insert(sQLiteConnection, t5);
        } catch (SQLException e5) {
            checkUniquenessException(e5);
            this.updateAdapter.handle(sQLiteConnection, t5);
        }
    }

    public final long upsertAndReturnId(SQLiteConnection sQLiteConnection, T t5) {
        t.e(sQLiteConnection, "connection");
        try {
            return this.entityInsertAdapter.insertAndReturnId(sQLiteConnection, t5);
        } catch (SQLException e5) {
            checkUniquenessException(e5);
            this.updateAdapter.handle(sQLiteConnection, t5);
            return -1;
        }
    }

    public final long[] upsertAndReturnIdsArray(SQLiteConnection sQLiteConnection, T[] tArr) {
        long j5;
        t.e(sQLiteConnection, "connection");
        if (tArr == null) {
            return new long[0];
        }
        int length = tArr.length;
        long[] jArr = new long[length];
        for (int i5 = 0; i5 < length; i5++) {
            try {
                j5 = this.entityInsertAdapter.insertAndReturnId(sQLiteConnection, tArr[i5]);
            } catch (SQLException e5) {
                checkUniquenessException(e5);
                this.updateAdapter.handle(sQLiteConnection, tArr[i5]);
                j5 = -1;
            }
            jArr[i5] = j5;
        }
        return jArr;
    }

    public final Long[] upsertAndReturnIdsArrayBox(SQLiteConnection sQLiteConnection, T[] tArr) {
        long j5;
        t.e(sQLiteConnection, "connection");
        if (tArr == null) {
            return new Long[0];
        }
        int length = tArr.length;
        Long[] lArr = new Long[length];
        for (int i5 = 0; i5 < length; i5++) {
            try {
                j5 = this.entityInsertAdapter.insertAndReturnId(sQLiteConnection, tArr[i5]);
            } catch (SQLException e5) {
                checkUniquenessException(e5);
                this.updateAdapter.handle(sQLiteConnection, tArr[i5]);
                j5 = -1;
            }
            lArr[i5] = Long.valueOf(j5);
        }
        return lArr;
    }

    public final List<Long> upsertAndReturnIdsList(SQLiteConnection sQLiteConnection, T[] tArr) {
        t.e(sQLiteConnection, "connection");
        if (tArr == null) {
            return C2250q.g();
        }
        List c5 = C2250q.c();
        for (T t5 : tArr) {
            try {
                c5.add(Long.valueOf(this.entityInsertAdapter.insertAndReturnId(sQLiteConnection, t5)));
            } catch (SQLException e5) {
                checkUniquenessException(e5);
                this.updateAdapter.handle(sQLiteConnection, t5);
                c5.add(-1L);
            }
        }
        return C2250q.a(c5);
    }

    public final void upsert(SQLiteConnection sQLiteConnection, T[] tArr) {
        t.e(sQLiteConnection, "connection");
        if (tArr != null) {
            for (T t5 : tArr) {
                try {
                    this.entityInsertAdapter.insert(sQLiteConnection, t5);
                } catch (SQLException e5) {
                    checkUniquenessException(e5);
                    this.updateAdapter.handle(sQLiteConnection, t5);
                }
            }
        }
    }

    public final long[] upsertAndReturnIdsArray(SQLiteConnection sQLiteConnection, Collection<? extends T> collection) {
        long j5;
        t.e(sQLiteConnection, "connection");
        if (collection == null) {
            return new long[0];
        }
        int size = collection.size();
        long[] jArr = new long[size];
        for (int i5 = 0; i5 < size; i5++) {
            try {
                j5 = this.entityInsertAdapter.insertAndReturnId(sQLiteConnection, C2250q.G(collection, i5));
            } catch (SQLException e5) {
                checkUniquenessException(e5);
                this.updateAdapter.handle(sQLiteConnection, C2250q.G(collection, i5));
                j5 = -1;
            }
            jArr[i5] = j5;
        }
        return jArr;
    }

    public final Long[] upsertAndReturnIdsArrayBox(SQLiteConnection sQLiteConnection, Collection<? extends T> collection) {
        long j5;
        t.e(sQLiteConnection, "connection");
        if (collection == null) {
            return new Long[0];
        }
        int size = collection.size();
        Long[] lArr = new Long[size];
        for (int i5 = 0; i5 < size; i5++) {
            try {
                j5 = this.entityInsertAdapter.insertAndReturnId(sQLiteConnection, C2250q.G(collection, i5));
            } catch (SQLException e5) {
                checkUniquenessException(e5);
                this.updateAdapter.handle(sQLiteConnection, C2250q.G(collection, i5));
                j5 = -1;
            }
            lArr[i5] = Long.valueOf(j5);
        }
        return lArr;
    }

    public final void upsert(SQLiteConnection sQLiteConnection, Iterable<? extends T> iterable) {
        t.e(sQLiteConnection, "connection");
        if (iterable != null) {
            for (Object next : iterable) {
                try {
                    this.entityInsertAdapter.insert(sQLiteConnection, next);
                } catch (SQLException e5) {
                    checkUniquenessException(e5);
                    this.updateAdapter.handle(sQLiteConnection, next);
                }
            }
        }
    }

    public final List<Long> upsertAndReturnIdsList(SQLiteConnection sQLiteConnection, Collection<? extends T> collection) {
        t.e(sQLiteConnection, "connection");
        if (collection == null) {
            return C2250q.g();
        }
        List c5 = C2250q.c();
        for (Object next : collection) {
            try {
                c5.add(Long.valueOf(this.entityInsertAdapter.insertAndReturnId(sQLiteConnection, next)));
            } catch (SQLException e5) {
                checkUniquenessException(e5);
                this.updateAdapter.handle(sQLiteConnection, next);
                c5.add(-1L);
            }
        }
        return C2250q.a(c5);
    }
}
