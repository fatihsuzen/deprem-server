package androidx.collection;

import W2.J;
import b3.C2308e;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.k;
import s3.C2753g;

@f(c = "androidx.collection.MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1", f = "ScatterSet.kt", l = {1060}, m = "invokeSuspend")
final class MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1 extends k implements p {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    int label;
    final /* synthetic */ MutableScatterSet<E> this$0;
    final /* synthetic */ MutableScatterSet$MutableSetWrapper$iterator$1 this$1;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1(MutableScatterSet mutableScatterSet, MutableScatterSet$MutableSetWrapper$iterator$1 mutableScatterSet$MutableSetWrapper$iterator$1, C2308e eVar) {
        super(2, eVar);
        this.this$0 = mutableScatterSet;
        this.this$1 = mutableScatterSet$MutableSetWrapper$iterator$1;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1 mutableScatterSet$MutableSetWrapper$iterator$1$iterator$1 = new MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1(this.this$0, this.this$1, eVar);
        mutableScatterSet$MutableSetWrapper$iterator$1$iterator$1.L$0 = obj;
        return mutableScatterSet$MutableSetWrapper$iterator$1$iterator$1;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x00a0  */
    public final java.lang.Object invokeSuspend(java.lang.Object r22) {
        /*
            r21 = this;
            r0 = r21
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r4 = 8
            r5 = 1
            if (r2 == 0) goto L_0x0036
            if (r2 != r5) goto L_0x002e
            int r2 = r0.I$3
            int r6 = r0.I$2
            long r7 = r0.J$0
            int r9 = r0.I$1
            int r10 = r0.I$0
            java.lang.Object r11 = r0.L$3
            long[] r11 = (long[]) r11
            java.lang.Object r12 = r0.L$2
            androidx.collection.MutableScatterSet r12 = (androidx.collection.MutableScatterSet) r12
            java.lang.Object r13 = r0.L$1
            androidx.collection.MutableScatterSet$MutableSetWrapper$iterator$1 r13 = (androidx.collection.MutableScatterSet$MutableSetWrapper$iterator$1) r13
            java.lang.Object r14 = r0.L$0
            s3.g r14 = (s3.C2753g) r14
            W2.u.b(r22)
            goto L_0x009d
        L_0x002e:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0036:
            W2.u.b(r22)
            java.lang.Object r2 = r0.L$0
            s3.g r2 = (s3.C2753g) r2
            androidx.collection.MutableScatterSet<E> r6 = r0.this$0
            androidx.collection.MutableScatterSet$MutableSetWrapper$iterator$1 r7 = r0.this$1
            long[] r8 = r6.metadata
            int r9 = r8.length
            int r9 = r9 + -2
            if (r9 < 0) goto L_0x00ae
            r10 = 0
        L_0x0049:
            r11 = r8[r10]
            long r13 = ~r11
            r15 = 7
            long r13 = r13 << r15
            long r13 = r13 & r11
            r15 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r13 = r13 & r15
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 == 0) goto L_0x00a9
            int r13 = r10 - r9
            int r13 = ~r13
            int r13 = r13 >>> 31
            int r13 = 8 - r13
            r14 = r10
            r10 = r9
            r9 = r14
            r14 = r2
            r2 = 0
            r19 = r11
            r12 = r6
            r11 = r8
            r6 = r13
            r13 = r7
            r7 = r19
        L_0x006d:
            if (r2 >= r6) goto L_0x00a0
            r15 = 255(0xff, double:1.26E-321)
            long r15 = r15 & r7
            r17 = 128(0x80, double:6.32E-322)
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 >= 0) goto L_0x009d
            int r15 = r9 << 3
            int r15 = r15 + r2
            r13.setCurrent(r15)
            java.lang.Object[] r3 = r12.elements
            r3 = r3[r15]
            r0.L$0 = r14
            r0.L$1 = r13
            r0.L$2 = r12
            r0.L$3 = r11
            r0.I$0 = r10
            r0.I$1 = r9
            r0.J$0 = r7
            r0.I$2 = r6
            r0.I$3 = r2
            r0.label = r5
            java.lang.Object r3 = r14.a(r3, r0)
            if (r3 != r1) goto L_0x009d
            return r1
        L_0x009d:
            long r7 = r7 >> r4
            int r2 = r2 + r5
            goto L_0x006d
        L_0x00a0:
            if (r6 != r4) goto L_0x00ae
            r2 = r10
            r10 = r9
            r9 = r2
            r8 = r11
            r6 = r12
            r7 = r13
            r2 = r14
        L_0x00a9:
            if (r10 == r9) goto L_0x00ae
            int r10 = r10 + 1
            goto L_0x0049
        L_0x00ae:
            W2.J r1 = W2.J.f19942a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    public final Object invoke(C2753g gVar, C2308e eVar) {
        return ((MutableScatterSet$MutableSetWrapper$iterator$1$iterator$1) create(gVar, eVar)).invokeSuspend(J.f19942a);
    }
}
