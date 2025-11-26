package androidx.room;

import W2.J;
import W2.y;
import X2.M;
import X2.T;
import androidx.sqlite.SQLite;
import androidx.sqlite.SQLiteConnection;
import androidx.sqlite.SQLiteStatement;
import b3.C2308e;
import i3.C2579a;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import k3.C2616a;
import k3.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import t3.s;
import w3.C2908y0;
import w3.L;
import w3.O;
import z3.C2972e;
import z3.C2974g;

public final class TriggerBasedInvalidationTracker {
    private static final String CREATE_TRACKING_TABLE_SQL = "CREATE TEMP TABLE IF NOT EXISTS room_table_modification_log (table_id INTEGER PRIMARY KEY, invalidated INTEGER NOT NULL DEFAULT 0)";
    public static final Companion Companion = new Companion((C2633k) null);
    private static final String DROP_TRACKING_TABLE_SQL = "DROP TABLE IF EXISTS room_table_modification_log";
    private static final String INVALIDATED_COLUMN_NAME = "invalidated";
    private static final String RESET_UPDATED_TABLES_SQL = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1";
    private static final String SELECT_UPDATED_TABLES_SQL = "SELECT * FROM room_table_modification_log WHERE invalidated = 1";
    private static final String TABLE_ID_COLUMN_NAME = "table_id";
    private static final String[] TRIGGERS = {"INSERT", "UPDATE", "DELETE"};
    private static final String UPDATE_TABLE_NAME = "room_table_modification_log";
    /* access modifiers changed from: private */
    public final RoomDatabase database;
    /* access modifiers changed from: private */
    public final ObservedTableStates observedTableStates;
    /* access modifiers changed from: private */
    public final ObservedTableVersions observedTableVersions;
    private C2616a onAllowRefresh = new y();
    private final l onInvalidatedTablesIds;
    private final AtomicBoolean pendingRefresh = new AtomicBoolean(false);
    private final Map<String, String> shadowTablesMap;
    private final Map<String, Integer> tableIdLookup = new LinkedHashMap();
    private final String[] tablesNames;
    private final boolean useTempTable;
    private final Map<String, Set<String>> viewTables;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        /* access modifiers changed from: private */
        public final String getTriggerName(String str, String str2) {
            return "room_table_modification_trigger_" + str + '_' + str2;
        }

        private Companion() {
        }
    }

    public TriggerBasedInvalidationTracker(RoomDatabase roomDatabase, Map<String, String> map, Map<String, ? extends Set<String>> map2, String[] strArr, boolean z4, l lVar) {
        String str;
        t.e(roomDatabase, "database");
        t.e(map, "shadowTablesMap");
        t.e(map2, "viewTables");
        t.e(strArr, "tableNames");
        t.e(lVar, "onInvalidatedTablesIds");
        this.database = roomDatabase;
        this.shadowTablesMap = map;
        this.viewTables = map2;
        this.useTempTable = z4;
        this.onInvalidatedTablesIds = lVar;
        int length = strArr.length;
        String[] strArr2 = new String[length];
        for (int i5 = 0; i5 < length; i5++) {
            String str2 = strArr[i5];
            Locale locale = Locale.ROOT;
            String lowerCase = str2.toLowerCase(locale);
            t.d(lowerCase, "toLowerCase(...)");
            this.tableIdLookup.put(lowerCase, Integer.valueOf(i5));
            String str3 = this.shadowTablesMap.get(strArr[i5]);
            if (str3 != null) {
                str = str3.toLowerCase(locale);
                t.d(str, "toLowerCase(...)");
            } else {
                str = null;
            }
            if (str != null) {
                lowerCase = str;
            }
            strArr2[i5] = lowerCase;
        }
        this.tablesNames = strArr2;
        for (Map.Entry next : this.shadowTablesMap.entrySet()) {
            Locale locale2 = Locale.ROOT;
            String lowerCase2 = ((String) next.getValue()).toLowerCase(locale2);
            t.d(lowerCase2, "toLowerCase(...)");
            if (this.tableIdLookup.containsKey(lowerCase2)) {
                String lowerCase3 = ((String) next.getKey()).toLowerCase(locale2);
                t.d(lowerCase3, "toLowerCase(...)");
                Map<String, Integer> map3 = this.tableIdLookup;
                map3.put(lowerCase3, M.i(map3, lowerCase2));
            }
        }
        this.observedTableStates = new ObservedTableStates(this.tablesNames.length);
        this.observedTableVersions = new ObservedTableVersions(this.tablesNames.length);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0052, code lost:
        if (r7 == r1) goto L_0x0069;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object checkInvalidatedTables(androidx.room.PooledConnection r6, b3.C2308e r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof androidx.room.TriggerBasedInvalidationTracker$checkInvalidatedTables$1
            if (r0 == 0) goto L_0x0013
            r0 = r7
            androidx.room.TriggerBasedInvalidationTracker$checkInvalidatedTables$1 r0 = (androidx.room.TriggerBasedInvalidationTracker$checkInvalidatedTables$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.room.TriggerBasedInvalidationTracker$checkInvalidatedTables$1 r0 = new androidx.room.TriggerBasedInvalidationTracker$checkInvalidatedTables$1
            r0.<init>(r5, r7)
        L_0x0018:
            java.lang.Object r7 = r0.result
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L_0x0040
            if (r2 == r4) goto L_0x0038
            if (r2 != r3) goto L_0x0030
            java.lang.Object r6 = r0.L$0
            java.util.Set r6 = (java.util.Set) r6
            W2.u.b(r7)
            return r6
        L_0x0030:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L_0x0038:
            java.lang.Object r6 = r0.L$0
            androidx.room.PooledConnection r6 = (androidx.room.PooledConnection) r6
            W2.u.b(r7)
            goto L_0x0055
        L_0x0040:
            W2.u.b(r7)
            androidx.room.v r7 = new androidx.room.v
            r7.<init>()
            r0.L$0 = r6
            r0.label = r4
            java.lang.String r2 = "SELECT * FROM room_table_modification_log WHERE invalidated = 1"
            java.lang.Object r7 = r6.usePrepared(r2, r7, r0)
            if (r7 != r1) goto L_0x0055
            goto L_0x0069
        L_0x0055:
            java.util.Set r7 = (java.util.Set) r7
            boolean r2 = r7.isEmpty()
            if (r2 != 0) goto L_0x006a
            r0.L$0 = r7
            r0.label = r3
            java.lang.String r2 = "UPDATE room_table_modification_log SET invalidated = 0 WHERE invalidated = 1"
            java.lang.Object r6 = androidx.room.TransactorKt.execSQL(r6, r2, r0)
            if (r6 != r1) goto L_0x006a
        L_0x0069:
            return r1
        L_0x006a:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker.checkInvalidatedTables(androidx.room.PooledConnection, b3.e):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final Set checkInvalidatedTables$lambda$14(SQLiteStatement sQLiteStatement) {
        t.e(sQLiteStatement, "statement");
        Set b5 = T.b();
        while (sQLiteStatement.step()) {
            b5.add(Integer.valueOf((int) sQLiteStatement.getLong(0)));
        }
        return T.a(b5);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x0096 A[Catch:{ all -> 0x0031 }] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object notifyInvalidation(b3.C2308e r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$1
            if (r0 == 0) goto L_0x0013
            r0 = r8
            androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$1 r0 = (androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$1 r0 = new androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$1
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x003c
            if (r2 != r3) goto L_0x0034
            java.lang.Object r1 = r0.L$1
            androidx.room.concurrent.CloseBarrier r1 = (androidx.room.concurrent.CloseBarrier) r1
            java.lang.Object r0 = r0.L$0
            androidx.room.TriggerBasedInvalidationTracker r0 = (androidx.room.TriggerBasedInvalidationTracker) r0
            W2.u.b(r8)     // Catch:{ all -> 0x0031 }
            goto L_0x008e
        L_0x0031:
            r8 = move-exception
            goto L_0x00a4
        L_0x0034:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x003c:
            W2.u.b(r8)
            androidx.room.RoomDatabase r8 = r7.database
            androidx.room.concurrent.CloseBarrier r8 = r8.getCloseBarrier$room_runtime_release()
            boolean r2 = r8.block$room_runtime_release()
            if (r2 == 0) goto L_0x00a8
            java.util.concurrent.atomic.AtomicBoolean r2 = r7.pendingRefresh     // Catch:{ all -> 0x005c }
            r4 = 0
            boolean r2 = r2.compareAndSet(r3, r4)     // Catch:{ all -> 0x005c }
            if (r2 != 0) goto L_0x0060
            java.util.Set r0 = X2.T.d()     // Catch:{ all -> 0x005c }
            r8.unblock$room_runtime_release()
            return r0
        L_0x005c:
            r0 = move-exception
            r1 = r8
            r8 = r0
            goto L_0x00a4
        L_0x0060:
            k3.a r2 = r7.onAllowRefresh     // Catch:{ all -> 0x005c }
            java.lang.Object r2 = r2.invoke()     // Catch:{ all -> 0x005c }
            java.lang.Boolean r2 = (java.lang.Boolean) r2     // Catch:{ all -> 0x005c }
            boolean r2 = r2.booleanValue()     // Catch:{ all -> 0x005c }
            if (r2 != 0) goto L_0x0076
            java.util.Set r0 = X2.T.d()     // Catch:{ all -> 0x005c }
            r8.unblock$room_runtime_release()
            return r0
        L_0x0076:
            androidx.room.RoomDatabase r2 = r7.database     // Catch:{ all -> 0x005c }
            androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1 r5 = new androidx.room.TriggerBasedInvalidationTracker$notifyInvalidation$2$invalidatedTableIds$1     // Catch:{ all -> 0x005c }
            r6 = 0
            r5.<init>(r7, r6)     // Catch:{ all -> 0x005c }
            r0.L$0 = r7     // Catch:{ all -> 0x005c }
            r0.L$1 = r8     // Catch:{ all -> 0x005c }
            r0.label = r3     // Catch:{ all -> 0x005c }
            java.lang.Object r0 = r2.useConnection$room_runtime_release(r4, r5, r0)     // Catch:{ all -> 0x005c }
            if (r0 != r1) goto L_0x008b
            return r1
        L_0x008b:
            r1 = r8
            r8 = r0
            r0 = r7
        L_0x008e:
            java.util.Set r8 = (java.util.Set) r8     // Catch:{ all -> 0x0031 }
            boolean r2 = r8.isEmpty()     // Catch:{ all -> 0x0031 }
            if (r2 != 0) goto L_0x00a0
            androidx.room.ObservedTableVersions r2 = r0.observedTableVersions     // Catch:{ all -> 0x0031 }
            r2.increment(r8)     // Catch:{ all -> 0x0031 }
            k3.l r0 = r0.onInvalidatedTablesIds     // Catch:{ all -> 0x0031 }
            r0.invoke(r8)     // Catch:{ all -> 0x0031 }
        L_0x00a0:
            r1.unblock$room_runtime_release()
            return r8
        L_0x00a4:
            r1.unblock$room_runtime_release()
            throw r8
        L_0x00a8:
            java.util.Set r8 = X2.T.d()
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker.notifyInvalidation(b3.e):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final boolean onAllowRefresh$lambda$0() {
        return true;
    }

    /* access modifiers changed from: private */
    public static final J refreshInvalidation$lambda$7() {
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final J refreshInvalidation$lambda$8() {
        return J.f19942a;
    }

    public static /* synthetic */ Object refreshInvalidation$room_runtime_release$default(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, String[] strArr, C2616a aVar, C2616a aVar2, C2308e eVar, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            new t
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0006: CONSTRUCTOR  (r2v2 ? I:androidx.room.t) =  call: androidx.room.t.<init>():void type: CONSTRUCTOR in method: androidx.room.TriggerBasedInvalidationTracker.refreshInvalidation$room_runtime_release$default(androidx.room.TriggerBasedInvalidationTracker, java.lang.String[], k3.a, k3.a, b3.e, int, java.lang.Object):java.lang.Object, dex: classes.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                	at java.util.ArrayList.forEach(ArrayList.java:1259)
                	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r2v2 ?
                	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:620)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                	... 34 more
                */
            /*
                r6 = r5 & 2
                if (r6 == 0) goto L_0x0009
                androidx.room.t r2 = new androidx.room.t
                r2.<init>()
            L_0x0009:
                r5 = r5 & 4
                if (r5 == 0) goto L_0x0012
                androidx.room.u r3 = new androidx.room.u
                r3.<init>()
            L_0x0012:
                java.lang.Object r0 = r0.refreshInvalidation$room_runtime_release(r1, r2, r3, r4)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker.refreshInvalidation$room_runtime_release$default(androidx.room.TriggerBasedInvalidationTracker, java.lang.String[], k3.a, k3.a, b3.e, int, java.lang.Object):java.lang.Object");
        }

        /* access modifiers changed from: private */
        public static final J refreshInvalidationAsync$lambda$10() {
            return J.f19942a;
        }

        /* access modifiers changed from: private */
        public static final J refreshInvalidationAsync$lambda$11() {
            return J.f19942a;
        }

        public static /* synthetic */ void refreshInvalidationAsync$room_runtime_release$default(TriggerBasedInvalidationTracker triggerBasedInvalidationTracker, C2616a aVar, C2616a aVar2, int i5, Object obj) {
            if ((i5 & 1) != 0) {
                new w
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0006: CONSTRUCTOR  (r1v2 ? I:androidx.room.w) =  call: androidx.room.w.<init>():void type: CONSTRUCTOR in method: androidx.room.TriggerBasedInvalidationTracker.refreshInvalidationAsync$room_runtime_release$default(androidx.room.TriggerBasedInvalidationTracker, k3.a, k3.a, int, java.lang.Object):void, dex: classes.dex
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:256)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:221)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:109)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:55)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:98)
                    	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:142)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:62)
                    	at jadx.core.codegen.RegionGen.makeSimpleRegion(RegionGen.java:92)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:58)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:211)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:204)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:318)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:271)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:240)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.util.ArrayList.forEach(ArrayList.java:1259)
                    	at java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    	at java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:483)
                    	at java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:472)
                    	at java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)
                    	at java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)
                    	at java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)
                    	at java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:485)
                    	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:236)
                    	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:227)
                    	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:112)
                    	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:78)
                    	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:44)
                    	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:33)
                    	at jadx.core.codegen.CodeGen.generate(CodeGen.java:21)
                    	at jadx.core.ProcessClass.generateCode(ProcessClass.java:61)
                    	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:273)
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Code variable not set in r1v2 ?
                    	at jadx.core.dex.instructions.args.SSAVar.getCodeVar(SSAVar.java:189)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:620)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:364)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:250)
                    	... 34 more
                    */
                /*
                    r4 = r3 & 1
                    if (r4 == 0) goto L_0x0009
                    androidx.room.w r1 = new androidx.room.w
                    r1.<init>()
                L_0x0009:
                    r3 = r3 & 2
                    if (r3 == 0) goto L_0x0012
                    androidx.room.x r2 = new androidx.room.x
                    r2.<init>()
                L_0x0012:
                    r0.refreshInvalidationAsync$room_runtime_release(r1, r2)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker.refreshInvalidationAsync$room_runtime_release$default(androidx.room.TriggerBasedInvalidationTracker, k3.a, k3.a, int, java.lang.Object):void");
            }

            private final String[] resolveViews(String[] strArr) {
                Set b5 = T.b();
                for (String str : strArr) {
                    Map<String, Set<String>> map = this.viewTables;
                    String lowerCase = str.toLowerCase(Locale.ROOT);
                    t.d(lowerCase, "toLowerCase(...)");
                    Set set = map.get(lowerCase);
                    if (set != null) {
                        b5.addAll(set);
                    } else {
                        b5.add(str);
                    }
                }
                return (String[]) T.a(b5).toArray(new String[0]);
            }

            /* access modifiers changed from: private */
            /* JADX WARNING: Code restructure failed: missing block: B:24:0x00ff, code lost:
                if (androidx.room.TransactorKt.execSQL(r11, r3, r4) == r5) goto L_0x0101;
             */
            /* JADX WARNING: Removed duplicated region for block: B:14:0x0068  */
            /* JADX WARNING: Removed duplicated region for block: B:19:0x00a2  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x002c  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object startTrackingTable(androidx.room.PooledConnection r18, int r19, b3.C2308e r20) {
                /*
                    r17 = this;
                    r0 = r17
                    r1 = r18
                    r2 = r19
                    r3 = r20
                    boolean r4 = r3 instanceof androidx.room.TriggerBasedInvalidationTracker$startTrackingTable$1
                    if (r4 == 0) goto L_0x001b
                    r4 = r3
                    androidx.room.TriggerBasedInvalidationTracker$startTrackingTable$1 r4 = (androidx.room.TriggerBasedInvalidationTracker$startTrackingTable$1) r4
                    int r5 = r4.label
                    r6 = -2147483648(0xffffffff80000000, float:-0.0)
                    r7 = r5 & r6
                    if (r7 == 0) goto L_0x001b
                    int r5 = r5 - r6
                    r4.label = r5
                    goto L_0x0020
                L_0x001b:
                    androidx.room.TriggerBasedInvalidationTracker$startTrackingTable$1 r4 = new androidx.room.TriggerBasedInvalidationTracker$startTrackingTable$1
                    r4.<init>(r0, r3)
                L_0x0020:
                    java.lang.Object r3 = r4.result
                    java.lang.Object r5 = c3.C2316b.f()
                    int r6 = r4.label
                    r7 = 2
                    r8 = 1
                    if (r6 == 0) goto L_0x0068
                    if (r6 == r8) goto L_0x0055
                    if (r6 != r7) goto L_0x004d
                    int r1 = r4.I$2
                    int r2 = r4.I$1
                    int r6 = r4.I$0
                    java.lang.Object r9 = r4.L$3
                    java.lang.String[] r9 = (java.lang.String[]) r9
                    java.lang.Object r10 = r4.L$2
                    java.lang.String r10 = (java.lang.String) r10
                    java.lang.Object r11 = r4.L$1
                    androidx.room.PooledConnection r11 = (androidx.room.PooledConnection) r11
                    java.lang.Object r12 = r4.L$0
                    androidx.room.TriggerBasedInvalidationTracker r12 = (androidx.room.TriggerBasedInvalidationTracker) r12
                    W2.u.b(r3)
                    r20 = r8
                    goto L_0x0102
                L_0x004d:
                    java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                    java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                    r1.<init>(r2)
                    throw r1
                L_0x0055:
                    int r1 = r4.I$0
                    java.lang.Object r2 = r4.L$1
                    androidx.room.PooledConnection r2 = (androidx.room.PooledConnection) r2
                    java.lang.Object r6 = r4.L$0
                    androidx.room.TriggerBasedInvalidationTracker r6 = (androidx.room.TriggerBasedInvalidationTracker) r6
                    W2.u.b(r3)
                    r16 = r2
                    r2 = r1
                    r1 = r16
                    goto L_0x0092
                L_0x0068:
                    W2.u.b(r3)
                    java.lang.StringBuilder r3 = new java.lang.StringBuilder
                    r3.<init>()
                    java.lang.String r6 = "INSERT OR IGNORE INTO room_table_modification_log VALUES("
                    r3.append(r6)
                    r3.append(r2)
                    java.lang.String r6 = ", 0)"
                    r3.append(r6)
                    java.lang.String r3 = r3.toString()
                    r4.L$0 = r0
                    r4.L$1 = r1
                    r4.I$0 = r2
                    r4.label = r8
                    java.lang.Object r3 = androidx.room.TransactorKt.execSQL(r1, r3, r4)
                    if (r3 != r5) goto L_0x0091
                    goto L_0x0101
                L_0x0091:
                    r6 = r0
                L_0x0092:
                    java.lang.String[] r3 = r6.tablesNames
                    r3 = r3[r2]
                    java.lang.String[] r9 = TRIGGERS
                    int r10 = r9.length
                    r11 = 0
                    r12 = r6
                    r6 = r2
                    r2 = r11
                    r11 = r1
                    r1 = r10
                    r10 = r3
                L_0x00a0:
                    if (r2 >= r1) goto L_0x0107
                    r3 = r9[r2]
                    boolean r13 = r12.useTempTable
                    if (r13 == 0) goto L_0x00ab
                    java.lang.String r13 = "TEMP"
                    goto L_0x00ad
                L_0x00ab:
                    java.lang.String r13 = ""
                L_0x00ad:
                    androidx.room.TriggerBasedInvalidationTracker$Companion r14 = Companion
                    java.lang.String r14 = r14.getTriggerName(r10, r3)
                    java.lang.StringBuilder r15 = new java.lang.StringBuilder
                    r15.<init>()
                    r20 = r8
                    java.lang.String r8 = "CREATE "
                    r15.append(r8)
                    r15.append(r13)
                    java.lang.String r8 = " TRIGGER IF NOT EXISTS `"
                    r15.append(r8)
                    r15.append(r14)
                    java.lang.String r8 = "` AFTER "
                    r15.append(r8)
                    r15.append(r3)
                    java.lang.String r3 = " ON `"
                    r15.append(r3)
                    r15.append(r10)
                    java.lang.String r3 = "` BEGIN UPDATE room_table_modification_log SET invalidated = 1 WHERE table_id = "
                    r15.append(r3)
                    r15.append(r6)
                    java.lang.String r3 = " AND invalidated = 0; END"
                    r15.append(r3)
                    java.lang.String r3 = r15.toString()
                    r4.L$0 = r12
                    r4.L$1 = r11
                    r4.L$2 = r10
                    r4.L$3 = r9
                    r4.I$0 = r6
                    r4.I$1 = r2
                    r4.I$2 = r1
                    r4.label = r7
                    java.lang.Object r3 = androidx.room.TransactorKt.execSQL(r11, r3, r4)
                    if (r3 != r5) goto L_0x0102
                L_0x0101:
                    return r5
                L_0x0102:
                    int r2 = r2 + 1
                    r8 = r20
                    goto L_0x00a0
                L_0x0107:
                    W2.J r1 = W2.J.f19942a
                    return r1
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker.startTrackingTable(androidx.room.PooledConnection, int, b3.e):java.lang.Object");
            }

            /* access modifiers changed from: private */
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0042  */
            /* JADX WARNING: Removed duplicated region for block: B:14:0x0054  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object stopTrackingTable(androidx.room.PooledConnection r10, int r11, b3.C2308e r12) {
                /*
                    r9 = this;
                    boolean r0 = r12 instanceof androidx.room.TriggerBasedInvalidationTracker$stopTrackingTable$1
                    if (r0 == 0) goto L_0x0013
                    r0 = r12
                    androidx.room.TriggerBasedInvalidationTracker$stopTrackingTable$1 r0 = (androidx.room.TriggerBasedInvalidationTracker$stopTrackingTable$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L_0x0018
                L_0x0013:
                    androidx.room.TriggerBasedInvalidationTracker$stopTrackingTable$1 r0 = new androidx.room.TriggerBasedInvalidationTracker$stopTrackingTable$1
                    r0.<init>(r9, r12)
                L_0x0018:
                    java.lang.Object r12 = r0.result
                    java.lang.Object r1 = c3.C2316b.f()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x0042
                    if (r2 != r3) goto L_0x003a
                    int r10 = r0.I$1
                    int r11 = r0.I$0
                    java.lang.Object r2 = r0.L$2
                    java.lang.String[] r2 = (java.lang.String[]) r2
                    java.lang.Object r4 = r0.L$1
                    java.lang.String r4 = (java.lang.String) r4
                    java.lang.Object r5 = r0.L$0
                    androidx.room.PooledConnection r5 = (androidx.room.PooledConnection) r5
                    W2.u.b(r12)
                    r12 = r4
                    goto L_0x0087
                L_0x003a:
                    java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
                    java.lang.String r11 = "call to 'resume' before 'invoke' with coroutine"
                    r10.<init>(r11)
                    throw r10
                L_0x0042:
                    W2.u.b(r12)
                    java.lang.String[] r12 = r9.tablesNames
                    r11 = r12[r11]
                    java.lang.String[] r12 = TRIGGERS
                    int r2 = r12.length
                    r4 = 0
                    r8 = r11
                    r11 = r10
                    r10 = r2
                    r2 = r12
                    r12 = r8
                L_0x0052:
                    if (r4 >= r10) goto L_0x008b
                    r5 = r2[r4]
                    androidx.room.TriggerBasedInvalidationTracker$Companion r6 = Companion
                    java.lang.String r5 = r6.getTriggerName(r12, r5)
                    java.lang.StringBuilder r6 = new java.lang.StringBuilder
                    r6.<init>()
                    java.lang.String r7 = "DROP TRIGGER IF EXISTS `"
                    r6.append(r7)
                    r6.append(r5)
                    r5 = 96
                    r6.append(r5)
                    java.lang.String r5 = r6.toString()
                    r0.L$0 = r11
                    r0.L$1 = r12
                    r0.L$2 = r2
                    r0.I$0 = r4
                    r0.I$1 = r10
                    r0.label = r3
                    java.lang.Object r5 = androidx.room.TransactorKt.execSQL(r11, r5, r0)
                    if (r5 != r1) goto L_0x0085
                    return r1
                L_0x0085:
                    r5 = r11
                    r11 = r4
                L_0x0087:
                    int r4 = r11 + 1
                    r11 = r5
                    goto L_0x0052
                L_0x008b:
                    W2.J r10 = W2.J.f19942a
                    return r10
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker.stopTrackingTable(androidx.room.PooledConnection, int, b3.e):java.lang.Object");
            }

            public final void configureConnection(SQLiteConnection sQLiteConnection) {
                Throwable th;
                t.e(sQLiteConnection, "connection");
                SQLiteStatement prepare = sQLiteConnection.prepare("PRAGMA query_only");
                try {
                    prepare.step();
                    boolean z4 = prepare.getBoolean(0);
                    C2579a.a(prepare, (Throwable) null);
                    if (!z4) {
                        SQLite.execSQL(sQLiteConnection, "PRAGMA temp_store = MEMORY");
                        SQLite.execSQL(sQLiteConnection, "PRAGMA recursive_triggers = 1");
                        SQLite.execSQL(sQLiteConnection, DROP_TRACKING_TABLE_SQL);
                        if (this.useTempTable) {
                            SQLite.execSQL(sQLiteConnection, CREATE_TRACKING_TABLE_SQL);
                        } else {
                            SQLite.execSQL(sQLiteConnection, s.L(CREATE_TRACKING_TABLE_SQL, "TEMP", "", false, 4, (Object) null));
                        }
                        this.observedTableStates.forceNeedSync$room_runtime_release();
                    }
                } catch (Throwable th2) {
                    C2579a.a(prepare, th);
                    throw th2;
                }
            }

            public final C2972e createFlow$room_runtime_release(String[] strArr, int[] iArr, boolean z4) {
                t.e(strArr, "resolvedTableNames");
                t.e(iArr, "tableIds");
                return C2974g.q(new TriggerBasedInvalidationTracker$createFlow$1(this, iArr, z4, strArr, (C2308e) null));
            }

            public final C2616a getOnAllowRefresh$room_runtime_release() {
                return this.onAllowRefresh;
            }

            public final boolean onObserverAdded$room_runtime_release(int[] iArr) {
                t.e(iArr, "tableIds");
                return this.observedTableStates.onObserverAdded$room_runtime_release(iArr);
            }

            public final boolean onObserverRemoved$room_runtime_release(int[] iArr) {
                t.e(iArr, "tableIds");
                return this.observedTableStates.onObserverRemoved$room_runtime_release(iArr);
            }

            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.lang.Object} */
            /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v3, resolved type: k3.a} */
            /* JADX WARNING: Code restructure failed: missing block: B:33:0x007e, code lost:
                if (r8.isEmpty() == false) goto L_0x0080;
             */
            /* JADX WARNING: Multi-variable type inference failed */
            /* JADX WARNING: Removed duplicated region for block: B:15:0x003c  */
            /* JADX WARNING: Removed duplicated region for block: B:22:0x005f A[Catch:{ all -> 0x0032 }] */
            /* JADX WARNING: Removed duplicated region for block: B:23:0x0061 A[Catch:{ all -> 0x0032 }] */
            /* JADX WARNING: Removed duplicated region for block: B:25:0x0064 A[Catch:{ all -> 0x0032 }] */
            /* JADX WARNING: Removed duplicated region for block: B:32:0x007a A[Catch:{ all -> 0x0032 }] */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object refreshInvalidation$room_runtime_release(java.lang.String[] r5, k3.C2616a r6, k3.C2616a r7, b3.C2308e r8) {
                /*
                    r4 = this;
                    boolean r0 = r8 instanceof androidx.room.TriggerBasedInvalidationTracker$refreshInvalidation$1
                    if (r0 == 0) goto L_0x0013
                    r0 = r8
                    androidx.room.TriggerBasedInvalidationTracker$refreshInvalidation$1 r0 = (androidx.room.TriggerBasedInvalidationTracker$refreshInvalidation$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L_0x0018
                L_0x0013:
                    androidx.room.TriggerBasedInvalidationTracker$refreshInvalidation$1 r0 = new androidx.room.TriggerBasedInvalidationTracker$refreshInvalidation$1
                    r0.<init>(r4, r8)
                L_0x0018:
                    java.lang.Object r8 = r0.result
                    java.lang.Object r1 = c3.C2316b.f()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x003c
                    if (r2 != r3) goto L_0x0034
                    java.lang.Object r5 = r0.L$1
                    int[] r5 = (int[]) r5
                    java.lang.Object r6 = r0.L$0
                    r7 = r6
                    k3.a r7 = (k3.C2616a) r7
                    W2.u.b(r8)     // Catch:{ all -> 0x0032 }
                    goto L_0x0059
                L_0x0032:
                    r5 = move-exception
                    goto L_0x0088
                L_0x0034:
                    java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                    java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                    r5.<init>(r6)
                    throw r5
                L_0x003c:
                    W2.u.b(r8)
                    W2.s r5 = r4.validateTableNames$room_runtime_release(r5)
                    java.lang.Object r5 = r5.b()
                    int[] r5 = (int[]) r5
                    r6.invoke()
                    r0.L$0 = r7     // Catch:{ all -> 0x0032 }
                    r0.L$1 = r5     // Catch:{ all -> 0x0032 }
                    r0.label = r3     // Catch:{ all -> 0x0032 }
                    java.lang.Object r8 = r4.notifyInvalidation(r0)     // Catch:{ all -> 0x0032 }
                    if (r8 != r1) goto L_0x0059
                    return r1
                L_0x0059:
                    java.util.Set r8 = (java.util.Set) r8     // Catch:{ all -> 0x0032 }
                    int r6 = r5.length     // Catch:{ all -> 0x0032 }
                    r0 = 0
                    if (r6 != 0) goto L_0x0061
                    r6 = r3
                    goto L_0x0062
                L_0x0061:
                    r6 = r0
                L_0x0062:
                    if (r6 != 0) goto L_0x007a
                    int r6 = r5.length     // Catch:{ all -> 0x0032 }
                    r1 = r0
                L_0x0066:
                    if (r1 >= r6) goto L_0x0078
                    r2 = r5[r1]     // Catch:{ all -> 0x0032 }
                    java.lang.Integer r2 = kotlin.coroutines.jvm.internal.b.b(r2)     // Catch:{ all -> 0x0032 }
                    boolean r2 = r8.contains(r2)     // Catch:{ all -> 0x0032 }
                    if (r2 == 0) goto L_0x0075
                    goto L_0x0080
                L_0x0075:
                    int r1 = r1 + 1
                    goto L_0x0066
                L_0x0078:
                    r3 = r0
                    goto L_0x0080
                L_0x007a:
                    boolean r5 = r8.isEmpty()     // Catch:{ all -> 0x0032 }
                    if (r5 != 0) goto L_0x0078
                L_0x0080:
                    java.lang.Boolean r5 = kotlin.coroutines.jvm.internal.b.a(r3)     // Catch:{ all -> 0x0032 }
                    r7.invoke()
                    return r5
                L_0x0088:
                    r7.invoke()
                    throw r5
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker.refreshInvalidation$room_runtime_release(java.lang.String[], k3.a, k3.a, b3.e):java.lang.Object");
            }

            public final void refreshInvalidationAsync$room_runtime_release(C2616a aVar, C2616a aVar2) {
                t.e(aVar, "onRefreshScheduled");
                t.e(aVar2, "onRefreshCompleted");
                if (this.pendingRefresh.compareAndSet(false, true)) {
                    aVar.invoke();
                    C2908y0 unused = C2876i.d(this.database.getCoroutineScope(), new L("Room Invalidation Tracker Refresh"), (O) null, new TriggerBasedInvalidationTracker$refreshInvalidationAsync$3(this, aVar2, (C2308e) null), 2, (Object) null);
                }
            }

            public final void resetSync$room_runtime_release() {
                this.observedTableStates.resetTriggerState$room_runtime_release();
            }

            public final void setOnAllowRefresh$room_runtime_release(C2616a aVar) {
                t.e(aVar, "<set-?>");
                this.onAllowRefresh = aVar;
            }

            /* JADX WARNING: Removed duplicated region for block: B:15:0x0037  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object syncTriggers$room_runtime_release(b3.C2308e r8) {
                /*
                    r7 = this;
                    boolean r0 = r8 instanceof androidx.room.TriggerBasedInvalidationTracker$syncTriggers$1
                    if (r0 == 0) goto L_0x0013
                    r0 = r8
                    androidx.room.TriggerBasedInvalidationTracker$syncTriggers$1 r0 = (androidx.room.TriggerBasedInvalidationTracker$syncTriggers$1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L_0x0018
                L_0x0013:
                    androidx.room.TriggerBasedInvalidationTracker$syncTriggers$1 r0 = new androidx.room.TriggerBasedInvalidationTracker$syncTriggers$1
                    r0.<init>(r7, r8)
                L_0x0018:
                    java.lang.Object r8 = r0.result
                    java.lang.Object r1 = c3.C2316b.f()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x0037
                    if (r2 != r3) goto L_0x002f
                    java.lang.Object r0 = r0.L$0
                    androidx.room.concurrent.CloseBarrier r0 = (androidx.room.concurrent.CloseBarrier) r0
                    W2.u.b(r8)     // Catch:{ all -> 0x002d }
                    goto L_0x005b
                L_0x002d:
                    r8 = move-exception
                    goto L_0x0063
                L_0x002f:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r0)
                    throw r8
                L_0x0037:
                    W2.u.b(r8)
                    androidx.room.RoomDatabase r8 = r7.database
                    androidx.room.concurrent.CloseBarrier r8 = r8.getCloseBarrier$room_runtime_release()
                    boolean r2 = r8.block$room_runtime_release()
                    if (r2 == 0) goto L_0x0067
                    androidx.room.RoomDatabase r2 = r7.database     // Catch:{ all -> 0x005f }
                    androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1 r4 = new androidx.room.TriggerBasedInvalidationTracker$syncTriggers$2$1     // Catch:{ all -> 0x005f }
                    r5 = 0
                    r4.<init>(r7, r5)     // Catch:{ all -> 0x005f }
                    r0.L$0 = r8     // Catch:{ all -> 0x005f }
                    r0.label = r3     // Catch:{ all -> 0x005f }
                    r3 = 0
                    java.lang.Object r0 = r2.useConnection$room_runtime_release(r3, r4, r0)     // Catch:{ all -> 0x005f }
                    if (r0 != r1) goto L_0x005a
                    return r1
                L_0x005a:
                    r0 = r8
                L_0x005b:
                    r0.unblock$room_runtime_release()
                    goto L_0x0067
                L_0x005f:
                    r0 = move-exception
                    r6 = r0
                    r0 = r8
                    r8 = r6
                L_0x0063:
                    r0.unblock$room_runtime_release()
                    throw r8
                L_0x0067:
                    W2.J r8 = W2.J.f19942a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.room.TriggerBasedInvalidationTracker.syncTriggers$room_runtime_release(b3.e):java.lang.Object");
            }

            public final W2.s validateTableNames$room_runtime_release(String[] strArr) {
                t.e(strArr, "names");
                String[] resolveViews = resolveViews(strArr);
                int length = resolveViews.length;
                int[] iArr = new int[length];
                int i5 = 0;
                while (i5 < length) {
                    String str = resolveViews[i5];
                    Map<String, Integer> map = this.tableIdLookup;
                    String lowerCase = str.toLowerCase(Locale.ROOT);
                    t.d(lowerCase, "toLowerCase(...)");
                    Integer num = map.get(lowerCase);
                    if (num != null) {
                        iArr[i5] = num.intValue();
                        i5++;
                    } else {
                        throw new IllegalArgumentException("There is no table with name " + str);
                    }
                }
                return y.a(resolveViews, iArr);
            }
        }
