package androidx.room;

import androidx.annotation.RestrictTo;
import androidx.sqlite.db.SupportSQLiteStatement;
import kotlin.jvm.internal.t;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public abstract class EntityDeletionOrUpdateAdapter<T> extends SharedSQLiteStatement {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public EntityDeletionOrUpdateAdapter(RoomDatabase roomDatabase) {
        super(roomDatabase);
        t.e(roomDatabase, "database");
    }

    /* access modifiers changed from: protected */
    public abstract void bind(SupportSQLiteStatement supportSQLiteStatement, T t5);

    /* access modifiers changed from: protected */
    public abstract String createQuery();

    public final int handle(T t5) {
        SupportSQLiteStatement acquire = acquire();
        try {
            bind(acquire, t5);
            return acquire.executeUpdateDelete();
        } finally {
            release(acquire);
        }
    }

    public final int handleMultiple(Iterable<? extends T> iterable) {
        t.e(iterable, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            int i5 = 0;
            for (Object bind : iterable) {
                bind(acquire, bind);
                i5 += acquire.executeUpdateDelete();
            }
            return i5;
        } finally {
            release(acquire);
        }
    }

    public final int handleMultiple(T[] tArr) {
        t.e(tArr, "entities");
        SupportSQLiteStatement acquire = acquire();
        try {
            int i5 = 0;
            for (T bind : tArr) {
                bind(acquire, bind);
                i5 += acquire.executeUpdateDelete();
            }
            return i5;
        } finally {
            release(acquire);
        }
    }
}
