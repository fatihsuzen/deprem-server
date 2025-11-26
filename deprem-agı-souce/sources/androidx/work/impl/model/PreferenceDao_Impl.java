package androidx.work.impl.model;

import W2.J;
import X2.C2250q;
import androidx.lifecycle.LiveData;
import androidx.room.EntityInsertAdapter;
import androidx.room.RoomDatabase;
import androidx.room.util.DBUtil;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import java.util.List;
import k3.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import r3.C2733c;

public final class PreferenceDao_Impl implements PreferenceDao {
    public static final Companion Companion = new Companion((C2633k) null);
    private final RoomDatabase __db;
    private final EntityInsertAdapter<Preference> __insertAdapterOfPreference = new EntityInsertAdapter<Preference>() {
        /* access modifiers changed from: protected */
        public String createQuery() {
            return "INSERT OR REPLACE INTO `Preference` (`key`,`long_value`) VALUES (?,?)";
        }

        /* access modifiers changed from: protected */
        public void bind(SQLiteStatement sQLiteStatement, Preference preference) {
            t.e(sQLiteStatement, "statement");
            t.e(preference, "entity");
            sQLiteStatement.bindText(1, preference.getKey());
            Long value = preference.getValue();
            if (value == null) {
                sQLiteStatement.bindNull(2);
            } else {
                sQLiteStatement.bindLong(2, value.longValue());
            }
        }
    };

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public final List<C2733c> getRequiredConverters() {
            return C2250q.g();
        }

        private Companion() {
        }
    }

    public PreferenceDao_Impl(RoomDatabase roomDatabase) {
        t.e(roomDatabase, "__db");
        this.__db = roomDatabase;
    }

    /* access modifiers changed from: private */
    public static final Long getLongValue$lambda$1(String str, String str2, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.bindText(1, str2);
            Long l5 = null;
            if (prepare.step()) {
                if (!prepare.isNull(0)) {
                    l5 = Long.valueOf(prepare.getLong(0));
                }
            }
            return l5;
        } finally {
            prepare.close();
        }
    }

    /* access modifiers changed from: private */
    public static final Long getObservableLongValue$lambda$2(String str, String str2, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        SQLiteStatement prepare = sQLiteConnection.prepare(str);
        try {
            prepare.bindText(1, str2);
            Long l5 = null;
            if (prepare.step()) {
                if (!prepare.isNull(0)) {
                    l5 = Long.valueOf(prepare.getLong(0));
                }
            }
            return l5;
        } finally {
            prepare.close();
        }
    }

    /* access modifiers changed from: private */
    public static final J insertPreference$lambda$0(PreferenceDao_Impl preferenceDao_Impl, Preference preference, SQLiteConnection sQLiteConnection) {
        t.e(sQLiteConnection, "_connection");
        preferenceDao_Impl.__insertAdapterOfPreference.insert(sQLiteConnection, preference);
        return J.f19942a;
    }

    public Long getLongValue(String str) {
        t.e(str, "key");
        return (Long) DBUtil.performBlocking(this.__db, true, false, new C0434h("SELECT long_value FROM Preference where `key`=?", str));
    }

    public LiveData<Long> getObservableLongValue(String str) {
        t.e(str, "key");
        return this.__db.getInvalidationTracker().createLiveData(new String[]{"Preference"}, false, (l) new C0433g("SELECT long_value FROM Preference where `key`=?", str));
    }

    public void insertPreference(Preference preference) {
        t.e(preference, "preference");
        DBUtil.performBlocking(this.__db, false, true, new C0432f(this, preference));
    }
}
