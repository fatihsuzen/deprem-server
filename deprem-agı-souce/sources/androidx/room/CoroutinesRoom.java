package androidx.room;

import android.os.CancellationSignal;
import androidx.annotation.RestrictTo;
import androidx.room.coroutines.FlowUtil;
import androidx.sqlite.SQLiteConnection;
import b3.C2308e;
import java.util.concurrent.Callable;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import z3.C2972e;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public final class CoroutinesRoom {
    public static final Companion Companion = new Companion((C2633k) null);

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        /* access modifiers changed from: private */
        public static final Object createFlow$lambda$1(Callable callable, SQLiteConnection sQLiteConnection) {
            t.e(sQLiteConnection, "it");
            return callable.call();
        }

        public final <R> C2972e createFlow(RoomDatabase roomDatabase, boolean z4, String[] strArr, Callable<R> callable) {
            t.e(roomDatabase, "db");
            t.e(strArr, "tableNames");
            t.e(callable, "callable");
            return FlowUtil.createFlow(roomDatabase, z4, strArr, new e(callable));
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: java.util.concurrent.Callable<R>} */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0059, code lost:
            if (r9 == r1) goto L_0x006e;
         */
        /* JADX WARNING: Multi-variable type inference failed */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x003d  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x006e A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x006f A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final <R> java.lang.Object execute(androidx.room.RoomDatabase r6, boolean r7, java.util.concurrent.Callable<R> r8, b3.C2308e r9) {
            /*
                r5 = this;
                boolean r0 = r9 instanceof androidx.room.CoroutinesRoom$Companion$execute$1
                if (r0 == 0) goto L_0x0013
                r0 = r9
                androidx.room.CoroutinesRoom$Companion$execute$1 r0 = (androidx.room.CoroutinesRoom$Companion$execute$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L_0x0013
                int r1 = r1 - r2
                r0.label = r1
                goto L_0x0018
            L_0x0013:
                androidx.room.CoroutinesRoom$Companion$execute$1 r0 = new androidx.room.CoroutinesRoom$Companion$execute$1
                r0.<init>(r5, r9)
            L_0x0018:
                java.lang.Object r9 = r0.result
                java.lang.Object r1 = c3.C2316b.f()
                int r2 = r0.label
                r3 = 2
                r4 = 1
                if (r2 == 0) goto L_0x003d
                if (r2 == r4) goto L_0x0034
                if (r2 != r3) goto L_0x002c
                W2.u.b(r9)
                return r9
            L_0x002c:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L_0x0034:
                java.lang.Object r6 = r0.L$0
                r8 = r6
                java.util.concurrent.Callable r8 = (java.util.concurrent.Callable) r8
                W2.u.b(r9)
                goto L_0x005c
            L_0x003d:
                W2.u.b(r9)
                boolean r9 = r6.isOpenInternal()
                if (r9 == 0) goto L_0x0051
                boolean r9 = r6.inTransaction()
                if (r9 == 0) goto L_0x0051
                java.lang.Object r6 = r8.call()
                return r6
            L_0x0051:
                r0.L$0 = r8
                r0.label = r4
                java.lang.Object r9 = androidx.room.util.DBUtil.getCoroutineContext(r6, r7, r0)
                if (r9 != r1) goto L_0x005c
                goto L_0x006e
            L_0x005c:
                b3.i r9 = (b3.C2312i) r9
                androidx.room.CoroutinesRoom$Companion$execute$2 r6 = new androidx.room.CoroutinesRoom$Companion$execute$2
                r7 = 0
                r6.<init>(r8, r7)
                r0.L$0 = r7
                r0.label = r3
                java.lang.Object r6 = w3.C2872g.g(r9, r6, r0)
                if (r6 != r1) goto L_0x006f
            L_0x006e:
                return r1
            L_0x006f:
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.CoroutinesRoom.Companion.execute(androidx.room.RoomDatabase, boolean, java.util.concurrent.Callable, b3.e):java.lang.Object");
        }

        private Companion() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0087, code lost:
            if (r8 == r4) goto L_0x00cb;
         */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0061  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x00c6  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x00cb A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x00cc A[RETURN] */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final <R> java.lang.Object execute(androidx.room.RoomDatabase r17, boolean r18, android.os.CancellationSignal r19, java.util.concurrent.Callable<R> r20, b3.C2308e r21) {
            /*
                r16 = this;
                r0 = r17
                r1 = r21
                boolean r2 = r1 instanceof androidx.room.CoroutinesRoom$Companion$execute$3
                if (r2 == 0) goto L_0x0019
                r2 = r1
                androidx.room.CoroutinesRoom$Companion$execute$3 r2 = (androidx.room.CoroutinesRoom$Companion$execute$3) r2
                int r3 = r2.label
                r4 = -2147483648(0xffffffff80000000, float:-0.0)
                r5 = r3 & r4
                if (r5 == 0) goto L_0x0019
                int r3 = r3 - r4
                r2.label = r3
                r3 = r16
                goto L_0x0020
            L_0x0019:
                androidx.room.CoroutinesRoom$Companion$execute$3 r2 = new androidx.room.CoroutinesRoom$Companion$execute$3
                r3 = r16
                r2.<init>(r3, r1)
            L_0x0020:
                java.lang.Object r1 = r2.result
                java.lang.Object r4 = c3.C2316b.f()
                int r5 = r2.label
                r6 = 2
                r7 = 1
                if (r5 == 0) goto L_0x0061
                if (r5 == r7) goto L_0x004c
                if (r5 != r6) goto L_0x0044
                java.lang.Object r0 = r2.L$3
                b3.i r0 = (b3.C2312i) r0
                java.lang.Object r0 = r2.L$2
                java.util.concurrent.Callable r0 = (java.util.concurrent.Callable) r0
                java.lang.Object r0 = r2.L$1
                android.os.CancellationSignal r0 = (android.os.CancellationSignal) r0
                java.lang.Object r0 = r2.L$0
                androidx.room.RoomDatabase r0 = (androidx.room.RoomDatabase) r0
                W2.u.b(r1)
                return r1
            L_0x0044:
                java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
                java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
                r0.<init>(r1)
                throw r0
            L_0x004c:
                java.lang.Object r0 = r2.L$2
                java.util.concurrent.Callable r0 = (java.util.concurrent.Callable) r0
                java.lang.Object r5 = r2.L$1
                android.os.CancellationSignal r5 = (android.os.CancellationSignal) r5
                java.lang.Object r8 = r2.L$0
                androidx.room.RoomDatabase r8 = (androidx.room.RoomDatabase) r8
                W2.u.b(r1)
                r15 = r5
                r5 = r0
                r0 = r8
                r8 = r1
                r1 = r15
                goto L_0x008a
            L_0x0061:
                W2.u.b(r1)
                boolean r1 = r0.isOpenInternal()
                if (r1 == 0) goto L_0x0075
                boolean r1 = r0.inTransaction()
                if (r1 == 0) goto L_0x0075
                java.lang.Object r0 = r20.call()
                return r0
            L_0x0075:
                r2.L$0 = r0
                r1 = r19
                r2.L$1 = r1
                r5 = r20
                r2.L$2 = r5
                r2.label = r7
                r8 = r18
                java.lang.Object r8 = androidx.room.util.DBUtil.getCoroutineContext(r0, r8, r2)
                if (r8 != r4) goto L_0x008a
                goto L_0x00cb
            L_0x008a:
                r10 = r8
                b3.i r10 = (b3.C2312i) r10
                r2.L$0 = r0
                r2.L$1 = r1
                r2.L$2 = r5
                r2.L$3 = r10
                r2.label = r6
                w3.n r6 = new w3.n
                b3.e r8 = c3.C2316b.c(r2)
                r6.<init>(r8, r7)
                r6.D()
                w3.M r9 = r0.getCoroutineScope()
                androidx.room.CoroutinesRoom$Companion$execute$4$job$1 r12 = new androidx.room.CoroutinesRoom$Companion$execute$4$job$1
                r0 = 0
                r12.<init>(r5, r6, r0)
                r13 = 2
                r14 = 0
                r11 = 0
                w3.y0 r0 = w3.C2876i.d(r9, r10, r11, r12, r13, r14)
                androidx.room.CoroutinesRoom$Companion$execute$4$1 r5 = new androidx.room.CoroutinesRoom$Companion$execute$4$1
                r5.<init>(r1, r0)
                r6.g(r5)
                java.lang.Object r0 = r6.x()
                java.lang.Object r1 = c3.C2316b.f()
                if (r0 != r1) goto L_0x00c9
                kotlin.coroutines.jvm.internal.h.c(r2)
            L_0x00c9:
                if (r0 != r4) goto L_0x00cc
            L_0x00cb:
                return r4
            L_0x00cc:
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.CoroutinesRoom.Companion.execute(androidx.room.RoomDatabase, boolean, android.os.CancellationSignal, java.util.concurrent.Callable, b3.e):java.lang.Object");
        }
    }

    private CoroutinesRoom() {
    }

    public static final <R> C2972e createFlow(RoomDatabase roomDatabase, boolean z4, String[] strArr, Callable<R> callable) {
        return Companion.createFlow(roomDatabase, z4, strArr, callable);
    }

    public static final <R> Object execute(RoomDatabase roomDatabase, boolean z4, CancellationSignal cancellationSignal, Callable<R> callable, C2308e eVar) {
        return Companion.execute(roomDatabase, z4, cancellationSignal, callable, eVar);
    }

    public static final <R> Object execute(RoomDatabase roomDatabase, boolean z4, Callable<R> callable, C2308e eVar) {
        return Companion.execute(roomDatabase, z4, callable, eVar);
    }
}
