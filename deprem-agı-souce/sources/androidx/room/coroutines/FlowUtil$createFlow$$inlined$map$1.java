package androidx.room.coroutines;

import W2.J;
import androidx.room.RoomDatabase;
import b3.C2308e;
import c3.C2316b;
import k3.l;
import z3.C2972e;
import z3.C2973f;

public final class FlowUtil$createFlow$$inlined$map$1 implements C2972e {
    final /* synthetic */ l $block$inlined;
    final /* synthetic */ RoomDatabase $db$inlined;
    final /* synthetic */ boolean $inTransaction$inlined;
    final /* synthetic */ C2972e $this_unsafeTransform$inlined;

    public FlowUtil$createFlow$$inlined$map$1(C2972e eVar, RoomDatabase roomDatabase, boolean z4, l lVar) {
        this.$this_unsafeTransform$inlined = eVar;
        this.$db$inlined = roomDatabase;
        this.$inTransaction$inlined = z4;
        this.$block$inlined = lVar;
    }

    public Object collect(final C2973f fVar, C2308e eVar) {
        C2972e eVar2 = this.$this_unsafeTransform$inlined;
        final RoomDatabase roomDatabase = this.$db$inlined;
        final boolean z4 = this.$inTransaction$inlined;
        final l lVar = this.$block$inlined;
        Object collect = eVar2.collect(new C2973f() {
            /* JADX WARNING: Code restructure failed: missing block: B:18:0x0060, code lost:
                if (r8.emit(r9, r0) != r1) goto L_0x0063;
             */
            /* JADX WARNING: Removed duplicated region for block: B:14:0x003c  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0024  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r8, b3.C2308e r9) {
                /*
                    r7 = this;
                    boolean r0 = r9 instanceof androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r9
                    androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1$2$1 r0 = (androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L_0x0018
                L_0x0013:
                    androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1$2$1 r0 = new androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1$2$1
                    r0.<init>(r7, r9)
                L_0x0018:
                    java.lang.Object r9 = r0.result
                    java.lang.Object r1 = c3.C2316b.f()
                    int r2 = r0.label
                    r3 = 2
                    r4 = 1
                    if (r2 == 0) goto L_0x003c
                    if (r2 == r4) goto L_0x0034
                    if (r2 != r3) goto L_0x002c
                    W2.u.b(r9)
                    goto L_0x0063
                L_0x002c:
                    java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
                    java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
                    r8.<init>(r9)
                    throw r8
                L_0x0034:
                    java.lang.Object r8 = r0.L$0
                    z3.f r8 = (z3.C2973f) r8
                    W2.u.b(r9)
                    goto L_0x0057
                L_0x003c:
                    W2.u.b(r9)
                    z3.f r9 = r6
                    java.util.Set r8 = (java.util.Set) r8
                    androidx.room.RoomDatabase r8 = r2
                    boolean r2 = r3
                    k3.l r5 = r4
                    r0.L$0 = r9
                    r0.label = r4
                    java.lang.Object r8 = androidx.room.util.DBUtil.performSuspending(r8, r4, r2, r5, r0)
                    if (r8 != r1) goto L_0x0054
                    goto L_0x0062
                L_0x0054:
                    r6 = r9
                    r9 = r8
                    r8 = r6
                L_0x0057:
                    r2 = 0
                    r0.L$0 = r2
                    r0.label = r3
                    java.lang.Object r8 = r8.emit(r9, r0)
                    if (r8 != r1) goto L_0x0063
                L_0x0062:
                    return r1
                L_0x0063:
                    W2.J r8 = W2.J.f19942a
                    return r8
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.room.coroutines.FlowUtil$createFlow$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, b3.e):java.lang.Object");
            }
        }, eVar);
        if (collect == C2316b.f()) {
            return collect;
        }
        return J.f19942a;
    }
}
