package androidx.collection;

import W2.J;
import b3.C2308e;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.k;
import s3.C2753g;

@f(c = "androidx.collection.ScatterMap$MapWrapper$entries$1$iterator$1", f = "ScatterMap.kt", l = {701}, m = "invokeSuspend")
final class ScatterMap$MapWrapper$entries$1$iterator$1 extends k implements p {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    Object L$2;
    int label;
    final /* synthetic */ ScatterMap<K, V> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    ScatterMap$MapWrapper$entries$1$iterator$1(ScatterMap<K, V> scatterMap, C2308e eVar) {
        super(2, eVar);
        this.this$0 = scatterMap;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        ScatterMap$MapWrapper$entries$1$iterator$1 scatterMap$MapWrapper$entries$1$iterator$1 = new ScatterMap$MapWrapper$entries$1$iterator$1(this.this$0, eVar);
        scatterMap$MapWrapper$entries$1$iterator$1.L$0 = obj;
        return scatterMap$MapWrapper$entries$1$iterator$1;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a3  */
    public final java.lang.Object invokeSuspend(java.lang.Object r21) {
        /*
            r20 = this;
            r0 = r20
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r4 = 8
            r5 = 1
            if (r2 == 0) goto L_0x0032
            if (r2 != r5) goto L_0x002a
            int r2 = r0.I$3
            int r6 = r0.I$2
            long r7 = r0.J$0
            int r9 = r0.I$1
            int r10 = r0.I$0
            java.lang.Object r11 = r0.L$2
            long[] r11 = (long[]) r11
            java.lang.Object r12 = r0.L$1
            androidx.collection.ScatterMap r12 = (androidx.collection.ScatterMap) r12
            java.lang.Object r13 = r0.L$0
            s3.g r13 = (s3.C2753g) r13
            W2.u.b(r21)
            goto L_0x009b
        L_0x002a:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x0032:
            W2.u.b(r21)
            java.lang.Object r2 = r0.L$0
            s3.g r2 = (s3.C2753g) r2
            androidx.collection.ScatterMap<K, V> r6 = r0.this$0
            long[] r7 = r6.metadata
            int r8 = r7.length
            int r8 = r8 + -2
            if (r8 < 0) goto L_0x00b2
            r9 = 0
        L_0x0043:
            r10 = r7[r9]
            long r12 = ~r10
            r14 = 7
            long r12 = r12 << r14
            long r12 = r12 & r10
            r14 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r12 = r12 & r14
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 == 0) goto L_0x00ab
            int r12 = r9 - r8
            int r12 = ~r12
            int r12 = r12 >>> 31
            int r12 = 8 - r12
            r13 = r12
            r12 = r6
            r6 = r13
            r13 = r2
            r2 = 0
            r18 = r10
            r11 = r7
            r10 = r8
            r7 = r18
        L_0x0065:
            if (r2 >= r6) goto L_0x00a3
            r14 = 255(0xff, double:1.26E-321)
            long r14 = r14 & r7
            r16 = 128(0x80, double:6.32E-322)
            int r14 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r14 >= 0) goto L_0x009b
            int r14 = r9 << 3
            int r14 = r14 + r2
            androidx.collection.MapEntry r15 = new androidx.collection.MapEntry
            java.lang.Object[] r3 = r12.keys
            r3 = r3[r14]
            r17 = r4
            java.lang.Object[] r4 = r12.values
            r4 = r4[r14]
            r15.<init>(r3, r4)
            r0.L$0 = r13
            r0.L$1 = r12
            r0.L$2 = r11
            r0.I$0 = r10
            r0.I$1 = r9
            r0.J$0 = r7
            r0.I$2 = r6
            r0.I$3 = r2
            r0.label = r5
            java.lang.Object r3 = r13.a(r15, r0)
            if (r3 != r1) goto L_0x009d
            return r1
        L_0x009b:
            r17 = r4
        L_0x009d:
            long r7 = r7 >> r17
            int r2 = r2 + r5
            r4 = r17
            goto L_0x0065
        L_0x00a3:
            r3 = r4
            if (r6 != r3) goto L_0x00b2
            r8 = r10
            r7 = r11
            r6 = r12
            r2 = r13
            goto L_0x00ac
        L_0x00ab:
            r3 = r4
        L_0x00ac:
            if (r9 == r8) goto L_0x00b2
            int r9 = r9 + 1
            r4 = r3
            goto L_0x0043
        L_0x00b2:
            W2.J r1 = W2.J.f19942a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.ScatterMap$MapWrapper$entries$1$iterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    public final Object invoke(C2753g gVar, C2308e eVar) {
        return ((ScatterMap$MapWrapper$entries$1$iterator$1) create(gVar, eVar)).invokeSuspend(J.f19942a);
    }
}
