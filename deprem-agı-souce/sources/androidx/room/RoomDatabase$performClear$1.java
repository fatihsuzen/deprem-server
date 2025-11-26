package androidx.room;

import W2.J;
import W2.u;
import b3.C2308e;
import c3.C2316b;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import w3.M;

@f(c = "androidx.room.RoomDatabase$performClear$1", f = "RoomDatabase.android.kt", l = {502}, m = "invokeSuspend")
final class RoomDatabase$performClear$1 extends l implements p {
    final /* synthetic */ boolean $hasForeignKeys;
    final /* synthetic */ String[] $tableNames;
    int label;
    final /* synthetic */ RoomDatabase this$0;

    @f(c = "androidx.room.RoomDatabase$performClear$1$1", f = "RoomDatabase.android.kt", l = {503, 504, 506, 512, 513, 514}, m = "invokeSuspend")
    /* renamed from: androidx.room.RoomDatabase$performClear$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends l implements p {
        /* synthetic */ Object L$0;
        int label;

        public final C2308e create(Object obj, C2308e eVar) {
            AnonymousClass1 r02 = new AnonymousClass1(roomDatabase, z4, strArr, eVar);
            r02.L$0 = obj;
            return r02;
        }

        public final Object invoke(Transactor transactor, C2308e eVar) {
            return ((AnonymousClass1) create(transactor, eVar)).invokeSuspend(J.f19942a);
        }

        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x006e, code lost:
            if (r8.sync$room_runtime_release(r7) == r0) goto L_0x00b7;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0071, code lost:
            r8 = androidx.room.Transactor.SQLiteTransactionType.IMMEDIATE;
            r4 = r5;
            r5 = r6;
            r3 = new androidx.room.RoomDatabase$performClear$1.AnonymousClass1.AnonymousClass1((b3.C2308e) null);
            r7.L$0 = r1;
            r7.label = 3;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0085, code lost:
            if (r1.withTransaction(r8, r3, r7) != r0) goto L_0x0088;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0088, code lost:
            r7.L$0 = r1;
            r7.label = 4;
            r8 = r1.inTransaction(r7);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0091, code lost:
            if (r8 != r0) goto L_0x0094;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x009a, code lost:
            if (((java.lang.Boolean) r8).booleanValue() != false) goto L_0x00c1;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x009c, code lost:
            r7.L$0 = r1;
            r7.label = 5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00a7, code lost:
            if (androidx.room.TransactorKt.execSQL(r1, "PRAGMA wal_checkpoint(FULL)", r7) != r0) goto L_0x00aa;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00aa, code lost:
            r7.L$0 = null;
            r7.label = 6;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00b5, code lost:
            if (androidx.room.TransactorKt.execSQL(r1, "VACUUM", r7) != r0) goto L_0x00b8;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00b7, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00b8, code lost:
            r4.getInvalidationTracker().refreshAsync();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:0x00c3, code lost:
            return W2.J.f19942a;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r8) {
            /*
                r7 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r7.label
                r2 = 0
                switch(r1) {
                    case 0: goto L_0x0041;
                    case 1: goto L_0x0039;
                    case 2: goto L_0x0031;
                    case 3: goto L_0x0029;
                    case 4: goto L_0x0020;
                    case 5: goto L_0x0017;
                    case 6: goto L_0x0012;
                    default: goto L_0x000a;
                }
            L_0x000a:
                java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r8.<init>(r0)
                throw r8
            L_0x0012:
                W2.u.b(r8)
                goto L_0x00b8
            L_0x0017:
                java.lang.Object r1 = r7.L$0
                androidx.room.Transactor r1 = (androidx.room.Transactor) r1
                W2.u.b(r8)
                goto L_0x00aa
            L_0x0020:
                java.lang.Object r1 = r7.L$0
                androidx.room.Transactor r1 = (androidx.room.Transactor) r1
                W2.u.b(r8)
                goto L_0x0094
            L_0x0029:
                java.lang.Object r1 = r7.L$0
                androidx.room.Transactor r1 = (androidx.room.Transactor) r1
                W2.u.b(r8)
                goto L_0x0088
            L_0x0031:
                java.lang.Object r1 = r7.L$0
                androidx.room.Transactor r1 = (androidx.room.Transactor) r1
                W2.u.b(r8)
                goto L_0x0071
            L_0x0039:
                java.lang.Object r1 = r7.L$0
                androidx.room.Transactor r1 = (androidx.room.Transactor) r1
                W2.u.b(r8)
                goto L_0x0057
            L_0x0041:
                W2.u.b(r8)
                java.lang.Object r8 = r7.L$0
                androidx.room.Transactor r8 = (androidx.room.Transactor) r8
                r7.L$0 = r8
                r1 = 1
                r7.label = r1
                java.lang.Object r1 = r8.inTransaction(r7)
                if (r1 != r0) goto L_0x0054
                goto L_0x00b7
            L_0x0054:
                r6 = r1
                r1 = r8
                r8 = r6
            L_0x0057:
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                if (r8 != 0) goto L_0x0071
                androidx.room.RoomDatabase r8 = r4
                androidx.room.InvalidationTracker r8 = r8.getInvalidationTracker()
                r7.L$0 = r1
                r3 = 2
                r7.label = r3
                java.lang.Object r8 = r8.sync$room_runtime_release(r7)
                if (r8 != r0) goto L_0x0071
                goto L_0x00b7
            L_0x0071:
                androidx.room.Transactor$SQLiteTransactionType r8 = androidx.room.Transactor.SQLiteTransactionType.IMMEDIATE
                androidx.room.RoomDatabase$performClear$1$1$1 r3 = new androidx.room.RoomDatabase$performClear$1$1$1
                boolean r4 = r5
                java.lang.String[] r5 = r6
                r3.<init>(r4, r5, r2)
                r7.L$0 = r1
                r4 = 3
                r7.label = r4
                java.lang.Object r8 = r1.withTransaction(r8, r3, r7)
                if (r8 != r0) goto L_0x0088
                goto L_0x00b7
            L_0x0088:
                r7.L$0 = r1
                r8 = 4
                r7.label = r8
                java.lang.Object r8 = r1.inTransaction(r7)
                if (r8 != r0) goto L_0x0094
                goto L_0x00b7
            L_0x0094:
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                if (r8 != 0) goto L_0x00c1
                r7.L$0 = r1
                r8 = 5
                r7.label = r8
                java.lang.String r8 = "PRAGMA wal_checkpoint(FULL)"
                java.lang.Object r8 = androidx.room.TransactorKt.execSQL(r1, r8, r7)
                if (r8 != r0) goto L_0x00aa
                goto L_0x00b7
            L_0x00aa:
                r7.L$0 = r2
                r8 = 6
                r7.label = r8
                java.lang.String r8 = "VACUUM"
                java.lang.Object r8 = androidx.room.TransactorKt.execSQL(r1, r8, r7)
                if (r8 != r0) goto L_0x00b8
            L_0x00b7:
                return r0
            L_0x00b8:
                androidx.room.RoomDatabase r8 = r4
                androidx.room.InvalidationTracker r8 = r8.getInvalidationTracker()
                r8.refreshAsync()
            L_0x00c1:
                W2.J r8 = W2.J.f19942a
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.RoomDatabase$performClear$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    RoomDatabase$performClear$1(RoomDatabase roomDatabase, boolean z4, String[] strArr, C2308e eVar) {
        super(2, eVar);
        this.this$0 = roomDatabase;
        this.$hasForeignKeys = z4;
        this.$tableNames = strArr;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        return new RoomDatabase$performClear$1(this.this$0, this.$hasForeignKeys, this.$tableNames, eVar);
    }

    public final Object invokeSuspend(Object obj) {
        Object f5 = C2316b.f();
        int i5 = this.label;
        if (i5 == 0) {
            u.b(obj);
            RoomConnectionManager access$getConnectionManager$p = this.this$0.connectionManager;
            if (access$getConnectionManager$p == null) {
                t.w("connectionManager");
                access$getConnectionManager$p = null;
            }
            final RoomDatabase roomDatabase = this.this$0;
            final boolean z4 = this.$hasForeignKeys;
            final String[] strArr = this.$tableNames;
            AnonymousClass1 r32 = new AnonymousClass1((C2308e) null);
            this.label = 1;
            if (access$getConnectionManager$p.useConnection(false, r32, this) == f5) {
                return f5;
            }
        } else if (i5 == 1) {
            u.b(obj);
        } else {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        return J.f19942a;
    }

    public final Object invoke(M m5, C2308e eVar) {
        return ((RoomDatabase$performClear$1) create(m5, eVar)).invokeSuspend(J.f19942a);
    }
}
