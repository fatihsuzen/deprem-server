package androidx.room;

import W2.J;
import X2.C2242i;
import android.annotation.SuppressLint;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.sqlite.SQLiteStatement;
import androidx.sqlite.db.SupportSQLiteProgram;
import androidx.sqlite.db.SupportSQLiteQuery;
import com.mbridge.msdk.MBridgeConstans;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

@SuppressLint({"WrongConstant"})
@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class RoomSQLiteQuery implements SupportSQLiteQuery, SupportSQLiteProgram {
    private static final int BLOB = 5;
    public static final Companion Companion = new Companion((C2633k) null);
    public static final int DESIRED_POOL_SIZE = 10;
    private static final int DOUBLE = 3;
    private static final int LONG = 2;
    private static final int NULL = 1;
    public static final int POOL_LIMIT = 15;
    private static final int STRING = 4;
    public static final TreeMap<Integer, RoomSQLiteQuery> queryPool = new TreeMap<>();
    private int argCount;
    private final int[] bindingTypes;
    public final byte[][] blobBindings;
    @VisibleForTesting
    private final int capacity;
    public final double[] doubleBindings;
    public final long[] longBindings;
    private volatile String query;
    public final String[] stringBindings;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Binding {
    }

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        @VisibleForTesting
        public static /* synthetic */ void getDESIRED_POOL_SIZE$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getPOOL_LIMIT$annotations() {
        }

        @VisibleForTesting
        public static /* synthetic */ void getQueryPool$annotations() {
        }

        public final RoomSQLiteQuery acquire(String str, int i5) {
            t.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
            TreeMap<Integer, RoomSQLiteQuery> treeMap = RoomSQLiteQuery.queryPool;
            synchronized (treeMap) {
                Map.Entry<Integer, RoomSQLiteQuery> ceilingEntry = treeMap.ceilingEntry(Integer.valueOf(i5));
                if (ceilingEntry != null) {
                    treeMap.remove(ceilingEntry.getKey());
                    RoomSQLiteQuery value = ceilingEntry.getValue();
                    value.init(str, i5);
                    t.b(value);
                    return value;
                }
                J j5 = J.f19942a;
                RoomSQLiteQuery roomSQLiteQuery = new RoomSQLiteQuery(i5, (C2633k) null);
                roomSQLiteQuery.init(str, i5);
                return roomSQLiteQuery;
            }
        }

        public final RoomSQLiteQuery copyFrom(SupportSQLiteQuery supportSQLiteQuery) {
            t.e(supportSQLiteQuery, "supportSQLiteQuery");
            RoomSQLiteQuery acquire = acquire(supportSQLiteQuery.getSql(), supportSQLiteQuery.getArgCount());
            supportSQLiteQuery.bindTo(new RoomSQLiteQuery$Companion$copyFrom$1(acquire));
            return acquire;
        }

        public final void prunePoolLocked$room_runtime_release() {
            TreeMap<Integer, RoomSQLiteQuery> treeMap = RoomSQLiteQuery.queryPool;
            if (treeMap.size() > 15) {
                int size = treeMap.size() - 10;
                Iterator<Integer> it = treeMap.descendingKeySet().iterator();
                t.d(it, "iterator(...)");
                while (true) {
                    int i5 = size - 1;
                    if (size > 0) {
                        it.next();
                        it.remove();
                        size = i5;
                    } else {
                        return;
                    }
                }
            }
        }

        private Companion() {
        }
    }

    public /* synthetic */ RoomSQLiteQuery(int i5, C2633k kVar) {
        this(i5);
    }

    public static final RoomSQLiteQuery acquire(String str, int i5) {
        return Companion.acquire(str, i5);
    }

    public static final RoomSQLiteQuery copyFrom(SupportSQLiteQuery supportSQLiteQuery) {
        return Companion.copyFrom(supportSQLiteQuery);
    }

    private static /* synthetic */ void getBindingTypes$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getBlobBindings$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getDoubleBindings$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getLongBindings$annotations() {
    }

    @VisibleForTesting
    public static /* synthetic */ void getStringBindings$annotations() {
    }

    /* access modifiers changed from: private */
    public static final J toRoomRawQuery$lambda$1(RoomSQLiteQuery roomSQLiteQuery, SQLiteStatement sQLiteStatement) {
        t.e(sQLiteStatement, "it");
        roomSQLiteQuery.bindTo(sQLiteStatement);
        return J.f19942a;
    }

    public void bindBlob(int i5, byte[] bArr) {
        t.e(bArr, "value");
        this.bindingTypes[i5] = 5;
        this.blobBindings[i5] = bArr;
    }

    public void bindDouble(int i5, double d5) {
        this.bindingTypes[i5] = 3;
        this.doubleBindings[i5] = d5;
    }

    public void bindLong(int i5, long j5) {
        this.bindingTypes[i5] = 2;
        this.longBindings[i5] = j5;
    }

    public void bindNull(int i5) {
        this.bindingTypes[i5] = 1;
    }

    public void bindString(int i5, String str) {
        t.e(str, "value");
        this.bindingTypes[i5] = 4;
        this.stringBindings[i5] = str;
    }

    public final void bindText(int i5, String str) {
        t.e(str, "value");
        bindString(i5, str);
    }

    public void bindTo(SupportSQLiteProgram supportSQLiteProgram) {
        t.e(supportSQLiteProgram, "statement");
        int argCount2 = getArgCount();
        if (1 <= argCount2) {
            int i5 = 1;
            while (true) {
                int i6 = this.bindingTypes[i5];
                if (i6 == 1) {
                    supportSQLiteProgram.bindNull(i5);
                } else if (i6 == 2) {
                    supportSQLiteProgram.bindLong(i5, this.longBindings[i5]);
                } else if (i6 == 3) {
                    supportSQLiteProgram.bindDouble(i5, this.doubleBindings[i5]);
                } else if (i6 == 4) {
                    String str = this.stringBindings[i5];
                    if (str != null) {
                        supportSQLiteProgram.bindString(i5, str);
                    } else {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                } else if (i6 == 5) {
                    byte[] bArr = this.blobBindings[i5];
                    if (bArr != null) {
                        supportSQLiteProgram.bindBlob(i5, bArr);
                    } else {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                }
                if (i5 != argCount2) {
                    i5++;
                } else {
                    return;
                }
            }
        }
    }

    public void clearBindings() {
        C2242i.x(this.bindingTypes, 1, 0, 0, 6, (Object) null);
        C2242i.z(this.stringBindings, (Object) null, 0, 0, 6, (Object) null);
        C2242i.z(this.blobBindings, (Object) null, 0, 0, 6, (Object) null);
        this.query = null;
    }

    public void close() {
    }

    public final void copyArgumentsFrom(RoomSQLiteQuery roomSQLiteQuery) {
        t.e(roomSQLiteQuery, "other");
        int argCount2 = roomSQLiteQuery.getArgCount() + 1;
        System.arraycopy(roomSQLiteQuery.bindingTypes, 0, this.bindingTypes, 0, argCount2);
        System.arraycopy(roomSQLiteQuery.longBindings, 0, this.longBindings, 0, argCount2);
        System.arraycopy(roomSQLiteQuery.stringBindings, 0, this.stringBindings, 0, argCount2);
        System.arraycopy(roomSQLiteQuery.blobBindings, 0, this.blobBindings, 0, argCount2);
        System.arraycopy(roomSQLiteQuery.doubleBindings, 0, this.doubleBindings, 0, argCount2);
    }

    public int getArgCount() {
        return this.argCount;
    }

    public final int getCapacity() {
        return this.capacity;
    }

    public String getSql() {
        String str = this.query;
        if (str != null) {
            return str;
        }
        throw new IllegalStateException("Required value was null.");
    }

    public final void init(String str, int i5) {
        t.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
        this.query = str;
        this.argCount = i5;
    }

    public final void release() {
        TreeMap<Integer, RoomSQLiteQuery> treeMap = queryPool;
        synchronized (treeMap) {
            treeMap.put(Integer.valueOf(this.capacity), this);
            Companion.prunePoolLocked$room_runtime_release();
            J j5 = J.f19942a;
        }
    }

    public final RoomRawQuery toRoomRawQuery() {
        return new RoomRawQuery(getSql(), new o(this));
    }

    private RoomSQLiteQuery(int i5) {
        this.capacity = i5;
        int i6 = i5 + 1;
        this.bindingTypes = new int[i6];
        this.longBindings = new long[i6];
        this.doubleBindings = new double[i6];
        this.stringBindings = new String[i6];
        this.blobBindings = new byte[i6][];
    }

    public final void bindTo(SQLiteStatement sQLiteStatement) {
        t.e(sQLiteStatement, "statement");
        int argCount2 = getArgCount();
        if (1 <= argCount2) {
            int i5 = 1;
            while (true) {
                int i6 = this.bindingTypes[i5];
                if (i6 == 1) {
                    sQLiteStatement.bindNull(i5);
                } else if (i6 == 2) {
                    sQLiteStatement.bindLong(i5, this.longBindings[i5]);
                } else if (i6 == 3) {
                    sQLiteStatement.bindDouble(i5, this.doubleBindings[i5]);
                } else if (i6 == 4) {
                    String str = this.stringBindings[i5];
                    if (str != null) {
                        sQLiteStatement.bindText(i5, str);
                    } else {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                } else if (i6 == 5) {
                    byte[] bArr = this.blobBindings[i5];
                    if (bArr != null) {
                        sQLiteStatement.bindBlob(i5, bArr);
                    } else {
                        throw new IllegalArgumentException("Required value was null.");
                    }
                }
                if (i5 != argCount2) {
                    i5++;
                } else {
                    return;
                }
            }
        }
    }
}
