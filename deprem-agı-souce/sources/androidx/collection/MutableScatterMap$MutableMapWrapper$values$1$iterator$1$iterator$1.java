package androidx.collection;

import W2.J;
import b3.C2308e;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.k;
import s3.C2753g;

@f(c = "androidx.collection.MutableScatterMap$MutableMapWrapper$values$1$iterator$1$iterator$1", f = "ScatterMap.kt", l = {1511}, m = "invokeSuspend")
final class MutableScatterMap$MutableMapWrapper$values$1$iterator$1$iterator$1 extends k implements p {
    int I$0;
    int I$1;
    int I$2;
    int I$3;
    long J$0;
    private /* synthetic */ Object L$0;
    Object L$1;
    int label;
    final /* synthetic */ MutableScatterMap<K, V> this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    MutableScatterMap$MutableMapWrapper$values$1$iterator$1$iterator$1(MutableScatterMap<K, V> mutableScatterMap, C2308e eVar) {
        super(2, eVar);
        this.this$0 = mutableScatterMap;
    }

    public final C2308e create(Object obj, C2308e eVar) {
        MutableScatterMap$MutableMapWrapper$values$1$iterator$1$iterator$1 mutableScatterMap$MutableMapWrapper$values$1$iterator$1$iterator$1 = new MutableScatterMap$MutableMapWrapper$values$1$iterator$1$iterator$1(this.this$0, eVar);
        mutableScatterMap$MutableMapWrapper$values$1$iterator$1$iterator$1.L$0 = obj;
        return mutableScatterMap$MutableMapWrapper$values$1$iterator$1$iterator$1;
    }

    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x008d  */
    public final java.lang.Object invokeSuspend(java.lang.Object r20) {
        /*
            r19 = this;
            r0 = r19
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r3 = 0
            r4 = 8
            r5 = 1
            if (r2 == 0) goto L_0x002e
            if (r2 != r5) goto L_0x0026
            int r2 = r0.I$3
            int r6 = r0.I$2
            long r7 = r0.J$0
            int r9 = r0.I$1
            int r10 = r0.I$0
            java.lang.Object r11 = r0.L$1
            long[] r11 = (long[]) r11
            java.lang.Object r12 = r0.L$0
            s3.g r12 = (s3.C2753g) r12
            W2.u.b(r20)
            goto L_0x008a
        L_0x0026:
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
            r1.<init>(r2)
            throw r1
        L_0x002e:
            W2.u.b(r20)
            java.lang.Object r2 = r0.L$0
            s3.g r2 = (s3.C2753g) r2
            androidx.collection.MutableScatterMap<K, V> r6 = r0.this$0
            long[] r6 = r6.metadata
            int r7 = r6.length
            int r7 = r7 + -2
            if (r7 < 0) goto L_0x0098
            r8 = r3
        L_0x003f:
            r9 = r6[r8]
            long r11 = ~r9
            r13 = 7
            long r11 = r11 << r13
            long r11 = r11 & r9
            r13 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r11 = r11 & r13
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 == 0) goto L_0x0093
            int r11 = r8 - r7
            int r11 = ~r11
            int r11 = r11 >>> 31
            int r11 = 8 - r11
            r12 = r11
            r11 = r6
            r6 = r12
            r12 = r2
            r2 = r3
            r17 = r9
            r10 = r7
            r9 = r8
            r7 = r17
        L_0x0061:
            if (r2 >= r6) goto L_0x008d
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r7
            r15 = 128(0x80, double:6.32E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L_0x008a
            int r13 = r9 << 3
            int r13 = r13 + r2
            java.lang.Integer r13 = kotlin.coroutines.jvm.internal.b.b(r13)
            r0.L$0 = r12
            r0.L$1 = r11
            r0.I$0 = r10
            r0.I$1 = r9
            r0.J$0 = r7
            r0.I$2 = r6
            r0.I$3 = r2
            r0.label = r5
            java.lang.Object r13 = r12.a(r13, r0)
            if (r13 != r1) goto L_0x008a
            return r1
        L_0x008a:
            long r7 = r7 >> r4
            int r2 = r2 + r5
            goto L_0x0061
        L_0x008d:
            if (r6 != r4) goto L_0x0098
            r8 = r9
            r7 = r10
            r6 = r11
            r2 = r12
        L_0x0093:
            if (r8 == r7) goto L_0x0098
            int r8 = r8 + 1
            goto L_0x003f
        L_0x0098:
            W2.J r1 = W2.J.f19942a
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterMap$MutableMapWrapper$values$1$iterator$1$iterator$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    public final Object invoke(C2753g gVar, C2308e eVar) {
        return ((MutableScatterMap$MutableMapWrapper$values$1$iterator$1$iterator$1) create(gVar, eVar)).invokeSuspend(J.f19942a);
    }
}
