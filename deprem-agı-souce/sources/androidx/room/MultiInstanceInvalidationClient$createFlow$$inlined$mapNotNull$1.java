package androidx.room;

import W2.J;
import b3.C2308e;
import c3.C2316b;
import z3.C2972e;
import z3.C2973f;

public final class MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1 implements C2972e {
    final /* synthetic */ String[] $resolvedTableNames$inlined;
    final /* synthetic */ C2972e $this_unsafeTransform$inlined;

    public MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1(C2972e eVar, String[] strArr) {
        this.$this_unsafeTransform$inlined = eVar;
        this.$resolvedTableNames$inlined = strArr;
    }

    public Object collect(final C2973f fVar, C2308e eVar) {
        C2972e eVar2 = this.$this_unsafeTransform$inlined;
        final String[] strArr = this.$resolvedTableNames$inlined;
        Object collect = eVar2.collect(new C2973f() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r11, b3.C2308e r12) {
                /*
                    r10 = this;
                    boolean r0 = r12 instanceof androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r12
                    androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2$1 r0 = (androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L_0x0018
                L_0x0013:
                    androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2$1 r0 = new androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1$2$1
                    r0.<init>(r10, r12)
                L_0x0018:
                    java.lang.Object r12 = r0.result
                    java.lang.Object r1 = c3.C2316b.f()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    W2.u.b(r12)
                    goto L_0x0077
                L_0x0029:
                    java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                    java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                    r11.<init>(r12)
                    throw r11
                L_0x0031:
                    W2.u.b(r12)
                    z3.f r12 = r4
                    java.util.Set r11 = (java.util.Set) r11
                    java.util.Set r2 = X2.T.b()
                    java.lang.String[] r4 = r2
                    int r5 = r4.length
                    r6 = 0
                L_0x0040:
                    if (r6 >= r5) goto L_0x0061
                    r7 = r4[r6]
                    java.util.Iterator r8 = r11.iterator()
                L_0x0048:
                    boolean r9 = r8.hasNext()
                    if (r9 == 0) goto L_0x005e
                    java.lang.Object r9 = r8.next()
                    java.lang.String r9 = (java.lang.String) r9
                    boolean r9 = t3.s.E(r7, r9, r3)
                    if (r9 == 0) goto L_0x0048
                    r2.add(r7)
                    goto L_0x0048
                L_0x005e:
                    int r6 = r6 + 1
                    goto L_0x0040
                L_0x0061:
                    java.util.Set r11 = X2.T.a(r2)
                    boolean r2 = r11.isEmpty()
                    if (r2 == 0) goto L_0x006c
                    r11 = 0
                L_0x006c:
                    if (r11 == 0) goto L_0x0077
                    r0.label = r3
                    java.lang.Object r11 = r12.emit(r11, r0)
                    if (r11 != r1) goto L_0x0077
                    return r1
                L_0x0077:
                    W2.J r11 = W2.J.f19942a
                    return r11
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.room.MultiInstanceInvalidationClient$createFlow$$inlined$mapNotNull$1.AnonymousClass2.emit(java.lang.Object, b3.e):java.lang.Object");
            }
        }, eVar);
        if (collect == C2316b.f()) {
            return collect;
        }
        return J.f19942a;
    }
}
