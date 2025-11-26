package androidx.work.impl.model;

import W2.J;
import b3.C2308e;
import c3.C2316b;
import z3.C2972e;
import z3.C2973f;

public final class WorkSpecDaoKt$dedup$$inlined$map$1 implements C2972e {
    final /* synthetic */ C2972e $this_unsafeTransform$inlined;

    public WorkSpecDaoKt$dedup$$inlined$map$1(C2972e eVar) {
        this.$this_unsafeTransform$inlined = eVar;
    }

    public Object collect(final C2973f fVar, C2308e eVar) {
        Object collect = this.$this_unsafeTransform$inlined.collect(new C2973f() {
            /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
            /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final java.lang.Object emit(java.lang.Object r6, b3.C2308e r7) {
                /*
                    r5 = this;
                    boolean r0 = r7 instanceof androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1.AnonymousClass2.AnonymousClass1
                    if (r0 == 0) goto L_0x0013
                    r0 = r7
                    androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1$2$1 r0 = (androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1.AnonymousClass2.AnonymousClass1) r0
                    int r1 = r0.label
                    r2 = -2147483648(0xffffffff80000000, float:-0.0)
                    r3 = r1 & r2
                    if (r3 == 0) goto L_0x0013
                    int r1 = r1 - r2
                    r0.label = r1
                    goto L_0x0018
                L_0x0013:
                    androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1$2$1 r0 = new androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1$2$1
                    r0.<init>(r5, r7)
                L_0x0018:
                    java.lang.Object r7 = r0.result
                    java.lang.Object r1 = c3.C2316b.f()
                    int r2 = r0.label
                    r3 = 1
                    if (r2 == 0) goto L_0x0031
                    if (r2 != r3) goto L_0x0029
                    W2.u.b(r7)
                    goto L_0x0066
                L_0x0029:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r7)
                    throw r6
                L_0x0031:
                    W2.u.b(r7)
                    z3.f r7 = r3
                    java.util.List r6 = (java.util.List) r6
                    java.lang.Iterable r6 = (java.lang.Iterable) r6
                    java.util.ArrayList r2 = new java.util.ArrayList
                    r4 = 10
                    int r4 = X2.C2250q.p(r6, r4)
                    r2.<init>(r4)
                    java.util.Iterator r6 = r6.iterator()
                L_0x0049:
                    boolean r4 = r6.hasNext()
                    if (r4 == 0) goto L_0x005d
                    java.lang.Object r4 = r6.next()
                    androidx.work.impl.model.WorkSpec$WorkInfoPojo r4 = (androidx.work.impl.model.WorkSpec.WorkInfoPojo) r4
                    androidx.work.WorkInfo r4 = r4.toWorkInfo()
                    r2.add(r4)
                    goto L_0x0049
                L_0x005d:
                    r0.label = r3
                    java.lang.Object r6 = r7.emit(r2, r0)
                    if (r6 != r1) goto L_0x0066
                    return r1
                L_0x0066:
                    W2.J r6 = W2.J.f19942a
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: androidx.work.impl.model.WorkSpecDaoKt$dedup$$inlined$map$1.AnonymousClass2.emit(java.lang.Object, b3.e):java.lang.Object");
            }
        }, eVar);
        if (collect == C2316b.f()) {
            return collect;
        }
        return J.f19942a;
    }
}
