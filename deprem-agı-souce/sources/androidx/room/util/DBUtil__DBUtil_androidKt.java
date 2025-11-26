package androidx.room.util;

import android.database.AbstractWindowedCursor;
import android.database.Cursor;
import android.os.CancellationSignal;
import androidx.annotation.RestrictTo;
import androidx.room.RoomDatabase;
import androidx.room.RoomDatabaseKt;
import androidx.room.TransactionElement;
import androidx.room.coroutines.RunBlockingUninterruptible_androidKt;
import androidx.room.driver.SupportSQLiteConnection;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteQuery;
import b3.C2308e;
import b3.C2309f;
import b3.C2312i;
import h3.C2453b;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import k3.l;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.t;
import w3.C2872g;

final /* synthetic */ class DBUtil__DBUtil_androidKt {
    private static final <R> Object compatCoroutineExecute$DBUtil__DBUtil_androidKt(RoomDatabase roomDatabase, boolean z4, l lVar, C2308e eVar) {
        if (roomDatabase.inCompatibilityMode$room_runtime_release() && roomDatabase.isOpenInternal() && roomDatabase.inTransaction()) {
            return lVar.invoke(eVar);
        }
        r.c(0);
        Object coroutineContext = DBUtil.getCoroutineContext(roomDatabase, z4, eVar);
        r.c(1);
        DBUtil__DBUtil_androidKt$compatCoroutineExecute$2 dBUtil__DBUtil_androidKt$compatCoroutineExecute$2 = new DBUtil__DBUtil_androidKt$compatCoroutineExecute$2(lVar, (C2308e) null);
        r.c(0);
        Object g5 = C2872g.g((C2312i) coroutineContext, dBUtil__DBUtil_androidKt$compatCoroutineExecute$2, eVar);
        r.c(1);
        return g5;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final CancellationSignal createCancellationSignal() {
        return new CancellationSignal();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final void dropFtsSyncTriggers(SupportSQLiteDatabase supportSQLiteDatabase) {
        t.e(supportSQLiteDatabase, "db");
        DBUtil.dropFtsSyncTriggers((SQLiteConnection) new SupportSQLiteConnection(supportSQLiteDatabase));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final void foreignKeyCheck(SupportSQLiteDatabase supportSQLiteDatabase, String str) {
        t.e(supportSQLiteDatabase, "db");
        t.e(str, "tableName");
        DBUtil.foreignKeyCheck((SQLiteConnection) new SupportSQLiteConnection(supportSQLiteDatabase), str);
    }

    public static final Object getCoroutineContext(RoomDatabase roomDatabase, boolean z4, C2308e eVar) {
        C2309f transactionDispatcher$room_runtime_release;
        C2312i plus;
        if (!roomDatabase.inCompatibilityMode$room_runtime_release()) {
            return roomDatabase.getCoroutineScope().getCoroutineContext();
        }
        TransactionElement transactionElement = (TransactionElement) eVar.getContext().get(TransactionElement.Key);
        if (transactionElement != null && (transactionDispatcher$room_runtime_release = transactionElement.getTransactionDispatcher$room_runtime_release()) != null && (plus = roomDatabase.getQueryContext().plus(transactionDispatcher$room_runtime_release)) != null) {
            return plus;
        }
        if (z4) {
            return roomDatabase.getTransactionContext$room_runtime_release();
        }
        return roomDatabase.getQueryContext();
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <R> R performBlocking(RoomDatabase roomDatabase, boolean z4, boolean z5, l lVar) {
        t.e(roomDatabase, "db");
        t.e(lVar, "block");
        roomDatabase.assertNotMainThread();
        roomDatabase.assertNotSuspendingTransaction();
        return RunBlockingUninterruptible_androidKt.runBlockingUninterruptible(new DBUtil__DBUtil_androidKt$performBlocking$1(roomDatabase, z4, z5, lVar, (C2308e) null));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final <R> Object performInTransactionSuspending(RoomDatabase roomDatabase, l lVar, C2308e eVar) {
        if (roomDatabase.inCompatibilityMode$room_runtime_release()) {
            return RoomDatabaseKt.withTransactionContext(roomDatabase, new DBUtil__DBUtil_androidKt$performInTransactionSuspending$2(roomDatabase, lVar, (C2308e) null), eVar);
        }
        return C2872g.g(roomDatabase.getCoroutineScope().getCoroutineContext(), new DBUtil__DBUtil_androidKt$performInTransactionSuspending$3(roomDatabase, lVar, (C2308e) null), eVar);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00ae A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00af A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0029  */
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final <R> java.lang.Object performSuspending(androidx.room.RoomDatabase r14, boolean r15, boolean r16, k3.l r17, b3.C2308e r18) {
        /*
            r0 = r18
            boolean r1 = r0 instanceof androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$1
            if (r1 == 0) goto L_0x0016
            r1 = r0
            androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$1 r1 = (androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$1) r1
            int r2 = r1.label
            r3 = -2147483648(0xffffffff80000000, float:-0.0)
            r4 = r2 & r3
            if (r4 == 0) goto L_0x0016
            int r2 = r2 - r3
            r1.label = r2
        L_0x0014:
            r6 = r1
            goto L_0x001c
        L_0x0016:
            androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$1 r1 = new androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$1
            r1.<init>(r0)
            goto L_0x0014
        L_0x001c:
            java.lang.Object r0 = r6.result
            java.lang.Object r7 = c3.C2316b.f()
            int r1 = r6.label
            r2 = 3
            r3 = 2
            r8 = 1
            if (r1 == 0) goto L_0x0053
            if (r1 == r8) goto L_0x004f
            if (r1 == r3) goto L_0x003b
            if (r1 != r2) goto L_0x0033
            W2.u.b(r0)
            return r0
        L_0x0033:
            java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
            java.lang.String r15 = "call to 'resume' before 'invoke' with coroutine"
            r14.<init>(r15)
            throw r14
        L_0x003b:
            boolean r14 = r6.Z$1
            boolean r15 = r6.Z$0
            java.lang.Object r1 = r6.L$1
            k3.l r1 = (k3.l) r1
            java.lang.Object r3 = r6.L$0
            androidx.room.RoomDatabase r3 = (androidx.room.RoomDatabase) r3
            W2.u.b(r0)
            r12 = r14
            r13 = r1
            r10 = r3
        L_0x004d:
            r11 = r15
            goto L_0x0099
        L_0x004f:
            W2.u.b(r0)
            return r0
        L_0x0053:
            W2.u.b(r0)
            boolean r0 = r14.inCompatibilityMode$room_runtime_release()
            if (r0 == 0) goto L_0x007f
            boolean r0 = r14.isOpenInternal()
            if (r0 == 0) goto L_0x007f
            boolean r0 = r14.inTransaction()
            if (r0 == 0) goto L_0x007f
            androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1 r0 = new androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$lambda$1$$inlined$internalPerform$1
            r4 = 0
            r3 = r14
            r2 = r15
            r1 = r16
            r5 = r17
            r0.<init>(r1, r2, r3, r4, r5)
            r2 = r0
            r6.label = r8
            java.lang.Object r14 = r14.useConnection$room_runtime_release(r15, r2, r6)
            if (r14 != r7) goto L_0x007e
            goto L_0x00ae
        L_0x007e:
            return r14
        L_0x007f:
            r4 = r16
            r6.L$0 = r14
            r5 = r17
            r6.L$1 = r5
            r6.Z$0 = r15
            r6.Z$1 = r4
            r6.label = r3
            java.lang.Object r3 = androidx.room.util.DBUtil.getCoroutineContext(r14, r4, r6)
            if (r3 != r7) goto L_0x0094
            goto L_0x00ae
        L_0x0094:
            r10 = r14
            r0 = r3
            r12 = r4
            r13 = r5
            goto L_0x004d
        L_0x0099:
            b3.i r0 = (b3.C2312i) r0
            androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$$inlined$compatCoroutineExecute$DBUtil__DBUtil_androidKt$1 r8 = new androidx.room.util.DBUtil__DBUtil_androidKt$performSuspending$$inlined$compatCoroutineExecute$DBUtil__DBUtil_androidKt$1
            r9 = 0
            r8.<init>(r9, r10, r11, r12, r13)
            r14 = 0
            r6.L$0 = r14
            r6.L$1 = r14
            r6.label = r2
            java.lang.Object r14 = w3.C2872g.g(r0, r8, r6)
            if (r14 != r7) goto L_0x00af
        L_0x00ae:
            return r7
        L_0x00af:
            return r14
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.util.DBUtil__DBUtil_androidKt.performSuspending(androidx.room.RoomDatabase, boolean, boolean, k3.l, b3.e):java.lang.Object");
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final Cursor query(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, boolean z4) {
        t.e(roomDatabase, "db");
        t.e(supportSQLiteQuery, "sqLiteQuery");
        return DBUtil.query(roomDatabase, supportSQLiteQuery, z4, (CancellationSignal) null);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final int readVersion(File file) throws IOException {
        Throwable th;
        t.e(file, "databaseFile");
        FileChannel channel = new FileInputStream(file).getChannel();
        try {
            ByteBuffer allocate = ByteBuffer.allocate(4);
            channel.tryLock(60, 4, true);
            channel.position(60);
            if (channel.read(allocate) == 4) {
                allocate.rewind();
                int i5 = allocate.getInt();
                C2453b.a(channel, (Throwable) null);
                return i5;
            }
            throw new IOException("Bad database header, unable to read 4 bytes at offset 60");
        } catch (Throwable th2) {
            C2453b.a(channel, th);
            throw th2;
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final SQLiteConnection toSQLiteConnection(SupportSQLiteDatabase supportSQLiteDatabase) {
        t.e(supportSQLiteDatabase, "db");
        return new SupportSQLiteConnection(supportSQLiteDatabase);
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
    public static final Cursor query(RoomDatabase roomDatabase, SupportSQLiteQuery supportSQLiteQuery, boolean z4, CancellationSignal cancellationSignal) {
        t.e(roomDatabase, "db");
        t.e(supportSQLiteQuery, "sqLiteQuery");
        Cursor query = roomDatabase.query(supportSQLiteQuery, cancellationSignal);
        if (!z4 || !(query instanceof AbstractWindowedCursor)) {
            return query;
        }
        AbstractWindowedCursor abstractWindowedCursor = (AbstractWindowedCursor) query;
        int count = abstractWindowedCursor.getCount();
        return (abstractWindowedCursor.hasWindow() ? abstractWindowedCursor.getWindow().getNumRows() : count) < count ? CursorUtil.copyAndClose(query) : query;
    }
}
