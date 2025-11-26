package androidx.sqlite.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.util.Log;
import java.io.Closeable;
import java.io.File;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import t3.s;

public interface SupportSQLiteOpenHelper extends Closeable {

    public static abstract class Callback {
        public static final Companion Companion = new Companion((C2633k) null);
        private static final String TAG = "SupportSQLite";
        public final int version;

        public static final class Companion {
            public /* synthetic */ Companion(C2633k kVar) {
                this();
            }

            private Companion() {
            }
        }

        public Callback(int i5) {
            this.version = i5;
        }

        private final void deleteDatabaseFile(String str) {
            int i5;
            boolean z4;
            if (!s.E(str, ":memory:", true)) {
                int length = str.length() - 1;
                int i6 = 0;
                boolean z5 = false;
                while (i6 <= length) {
                    if (!z5) {
                        i5 = i6;
                    } else {
                        i5 = length;
                    }
                    if (t.g(str.charAt(i5), 32) <= 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (!z5) {
                        if (!z4) {
                            z5 = true;
                        } else {
                            i6++;
                        }
                    } else if (!z4) {
                        break;
                    } else {
                        length--;
                    }
                }
                if (str.subSequence(i6, length + 1).toString().length() != 0) {
                    Log.w(TAG, "deleting the database file: " + str);
                    try {
                        SQLiteDatabase.deleteDatabase(new File(str));
                    } catch (Exception e5) {
                        Log.w(TAG, "delete failed: ", e5);
                    }
                }
            }
        }

        public void onConfigure(SupportSQLiteDatabase supportSQLiteDatabase) {
            t.e(supportSQLiteDatabase, "db");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:12:0x003e, code lost:
            if (r1 != null) goto L_0x0040;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0040, code lost:
            r4 = r1.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:15:0x004a, code lost:
            if (r4.hasNext() != false) goto L_0x004c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x004c, code lost:
            r1 = ((android.util.Pair) r4.next()).second;
            kotlin.jvm.internal.t.d(r1, "second");
            deleteDatabaseFile((java.lang.String) r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x005d, code lost:
            r4 = r4.getPath();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0061, code lost:
            if (r4 != null) goto L_0x0063;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0063, code lost:
            deleteDatabaseFile(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0066, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0038, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x003a */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0069  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x0086  */
        /* JADX WARNING: Removed duplicated region for block: B:9:0x0038 A[ExcHandler: all (r2v3 'th' java.lang.Throwable A[CUSTOM_DECLARE]), PHI: r1 
          PHI: (r1v12 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) = (r1v4 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r1v5 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>), (r1v5 java.util.List<android.util.Pair<java.lang.String, java.lang.String>>) binds: [B:7:0x0033, B:10:0x003a, B:11:?] A[DONT_GENERATE, DONT_INLINE], Splitter:B:7:0x0033] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onCorruption(androidx.sqlite.db.SupportSQLiteDatabase r4) {
            /*
                r3 = this;
                java.lang.String r0 = "second"
                java.lang.String r1 = "db"
                kotlin.jvm.internal.t.e(r4, r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Corruption reported by sqlite on database: "
                r1.append(r2)
                r1.append(r4)
                java.lang.String r2 = ".path"
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                java.lang.String r2 = "SupportSQLite"
                android.util.Log.e(r2, r1)
                boolean r1 = r4.isOpen()
                if (r1 != 0) goto L_0x0032
                java.lang.String r4 = r4.getPath()
                if (r4 == 0) goto L_0x008f
                r3.deleteDatabaseFile(r4)
                return
            L_0x0032:
                r1 = 0
                java.util.List r1 = r4.getAttachedDbs()     // Catch:{ SQLiteException -> 0x003a, all -> 0x0038 }
                goto L_0x003a
            L_0x0038:
                r2 = move-exception
                goto L_0x003e
            L_0x003a:
                r4.close()     // Catch:{ IOException -> 0x0067, all -> 0x0038 }
                goto L_0x0067
            L_0x003e:
                if (r1 == 0) goto L_0x005d
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.Iterator r4 = r1.iterator()
            L_0x0046:
                boolean r1 = r4.hasNext()
                if (r1 == 0) goto L_0x0066
                java.lang.Object r1 = r4.next()
                android.util.Pair r1 = (android.util.Pair) r1
                java.lang.Object r1 = r1.second
                kotlin.jvm.internal.t.d(r1, r0)
                java.lang.String r1 = (java.lang.String) r1
                r3.deleteDatabaseFile(r1)
                goto L_0x0046
            L_0x005d:
                java.lang.String r4 = r4.getPath()
                if (r4 == 0) goto L_0x0066
                r3.deleteDatabaseFile(r4)
            L_0x0066:
                throw r2
            L_0x0067:
                if (r1 == 0) goto L_0x0086
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.Iterator r4 = r1.iterator()
            L_0x006f:
                boolean r1 = r4.hasNext()
                if (r1 == 0) goto L_0x008f
                java.lang.Object r1 = r4.next()
                android.util.Pair r1 = (android.util.Pair) r1
                java.lang.Object r1 = r1.second
                kotlin.jvm.internal.t.d(r1, r0)
                java.lang.String r1 = (java.lang.String) r1
                r3.deleteDatabaseFile(r1)
                goto L_0x006f
            L_0x0086:
                java.lang.String r4 = r4.getPath()
                if (r4 == 0) goto L_0x008f
                r3.deleteDatabaseFile(r4)
            L_0x008f:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.sqlite.db.SupportSQLiteOpenHelper.Callback.onCorruption(androidx.sqlite.db.SupportSQLiteDatabase):void");
        }

        public abstract void onCreate(SupportSQLiteDatabase supportSQLiteDatabase);

        public void onDowngrade(SupportSQLiteDatabase supportSQLiteDatabase, int i5, int i6) {
            t.e(supportSQLiteDatabase, "db");
            throw new SQLiteException("Can't downgrade database from version " + i5 + " to " + i6);
        }

        public void onOpen(SupportSQLiteDatabase supportSQLiteDatabase) {
            t.e(supportSQLiteDatabase, "db");
        }

        public abstract void onUpgrade(SupportSQLiteDatabase supportSQLiteDatabase, int i5, int i6);
    }

    public interface Factory {
        SupportSQLiteOpenHelper create(Configuration configuration);
    }

    void close();

    String getDatabaseName();

    SupportSQLiteDatabase getReadableDatabase();

    SupportSQLiteDatabase getWritableDatabase();

    void setWriteAheadLoggingEnabled(boolean z4);

    public static final class Configuration {
        public static final Companion Companion = new Companion((C2633k) null);
        public final boolean allowDataLossOnRecovery;
        public final Callback callback;
        public final Context context;
        public final String name;
        public final boolean useNoBackupDirectory;

        public static class Builder {
            private boolean allowDataLossOnRecovery;
            private Callback callback;
            private final Context context;
            private String name;
            private boolean useNoBackupDirectory;

            public Builder(Context context2) {
                t.e(context2, "context");
                this.context = context2;
            }

            public Builder allowDataLossOnRecovery(boolean z4) {
                this.allowDataLossOnRecovery = z4;
                return this;
            }

            public Configuration build() {
                String str;
                Callback callback2 = this.callback;
                if (callback2 == null) {
                    throw new IllegalArgumentException("Must set a callback to create the configuration.");
                } else if (!this.useNoBackupDirectory || ((str = this.name) != null && str.length() != 0)) {
                    return new Configuration(this.context, this.name, callback2, this.useNoBackupDirectory, this.allowDataLossOnRecovery);
                } else {
                    throw new IllegalArgumentException("Must set a non-null database name to a configuration that uses the no backup directory.");
                }
            }

            public Builder callback(Callback callback2) {
                t.e(callback2, "callback");
                this.callback = callback2;
                return this;
            }

            public Builder name(String str) {
                this.name = str;
                return this;
            }

            public Builder noBackupDirectory(boolean z4) {
                this.useNoBackupDirectory = z4;
                return this;
            }
        }

        public static final class Companion {
            public /* synthetic */ Companion(C2633k kVar) {
                this();
            }

            public final Builder builder(Context context) {
                t.e(context, "context");
                return new Builder(context);
            }

            private Companion() {
            }
        }

        public Configuration(Context context2, String str, Callback callback2, boolean z4, boolean z5) {
            t.e(context2, "context");
            t.e(callback2, "callback");
            this.context = context2;
            this.name = str;
            this.callback = callback2;
            this.useNoBackupDirectory = z4;
            this.allowDataLossOnRecovery = z5;
        }

        public static final Builder builder(Context context2) {
            return Companion.builder(context2);
        }

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public /* synthetic */ Configuration(android.content.Context r2, java.lang.String r3, androidx.sqlite.db.SupportSQLiteOpenHelper.Callback r4, boolean r5, boolean r6, int r7, kotlin.jvm.internal.C2633k r8) {
            /*
                r1 = this;
                r8 = r7 & 8
                r0 = 0
                if (r8 == 0) goto L_0x0006
                r5 = r0
            L_0x0006:
                r7 = r7 & 16
                if (r7 == 0) goto L_0x0011
                r7 = r0
            L_0x000b:
                r6 = r5
                r5 = r4
                r4 = r3
                r3 = r2
                r2 = r1
                goto L_0x0013
            L_0x0011:
                r7 = r6
                goto L_0x000b
            L_0x0013:
                r2.<init>(r3, r4, r5, r6, r7)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.sqlite.db.SupportSQLiteOpenHelper.Configuration.<init>(android.content.Context, java.lang.String, androidx.sqlite.db.SupportSQLiteOpenHelper$Callback, boolean, boolean, int, kotlin.jvm.internal.k):void");
        }
    }
}
