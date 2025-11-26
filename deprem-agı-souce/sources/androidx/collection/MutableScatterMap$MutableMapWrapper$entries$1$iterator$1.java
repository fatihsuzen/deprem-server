package androidx.collection;

import W2.J;
import b3.C2308e;
import java.util.Iterator;
import java.util.Map;
import k3.p;
import kotlin.coroutines.jvm.internal.f;
import kotlin.coroutines.jvm.internal.k;
import kotlin.jvm.internal.t;
import l3.C2677a;
import s3.C2753g;
import s3.C2754h;

public final class MutableScatterMap$MutableMapWrapper$entries$1$iterator$1 implements Iterator<Map.Entry<K, V>>, C2677a {
    private int current = -1;
    private Iterator<? extends Map.Entry<K, V>> iterator;
    final /* synthetic */ MutableScatterMap<K, V> this$0;

    @f(c = "androidx.collection.MutableScatterMap$MutableMapWrapper$entries$1$iterator$1$1", f = "ScatterMap.kt", l = {1328}, m = "invokeSuspend")
    /* renamed from: androidx.collection.MutableScatterMap$MutableMapWrapper$entries$1$iterator$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends k implements p {
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

        public final C2308e create(Object obj, C2308e eVar) {
            AnonymousClass1 r02 = new AnonymousClass1(mutableScatterMap, this, eVar);
            r02.L$0 = obj;
            return r02;
        }

        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions count limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
            	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
            */
        /* JADX WARNING: Removed duplicated region for block: B:15:0x0078  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00b3  */
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
                androidx.collection.MutableScatterMap r12 = (androidx.collection.MutableScatterMap) r12
                java.lang.Object r13 = r0.L$1
                androidx.collection.MutableScatterMap$MutableMapWrapper$entries$1$iterator$1 r13 = (androidx.collection.MutableScatterMap$MutableMapWrapper$entries$1$iterator$1) r13
                java.lang.Object r14 = r0.L$0
                s3.g r14 = (s3.C2753g) r14
                W2.u.b(r22)
                goto L_0x00a9
            L_0x002e:
                java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
                java.lang.String r2 = "call to 'resume' before 'invoke' with coroutine"
                r1.<init>(r2)
                throw r1
            L_0x0036:
                W2.u.b(r22)
                java.lang.Object r2 = r0.L$0
                s3.g r2 = (s3.C2753g) r2
                androidx.collection.MutableScatterMap<K, V> r6 = r3
                androidx.collection.MutableScatterMap$MutableMapWrapper$entries$1$iterator$1 r7 = r2
                long[] r8 = r6.metadata
                int r9 = r8.length
                int r9 = r9 + -2
                if (r9 < 0) goto L_0x00c5
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
                if (r13 == 0) goto L_0x00be
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
                if (r2 >= r6) goto L_0x00b3
                r15 = 255(0xff, double:1.26E-321)
                long r15 = r15 & r7
                r17 = 128(0x80, double:6.32E-322)
                int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
                if (r15 >= 0) goto L_0x00a9
                int r15 = r9 << 3
                int r15 = r15 + r2
                r13.setCurrent(r15)
                androidx.collection.MutableMapEntry r15 = new androidx.collection.MutableMapEntry
                java.lang.Object[] r3 = r12.keys
                r17 = r4
                java.lang.Object[] r4 = r12.values
                int r5 = r13.getCurrent()
                r15.<init>(r3, r4, r5)
                r0.L$0 = r14
                r0.L$1 = r13
                r0.L$2 = r12
                r0.L$3 = r11
                r0.I$0 = r10
                r0.I$1 = r9
                r0.J$0 = r7
                r0.I$2 = r6
                r0.I$3 = r2
                r3 = 1
                r0.label = r3
                java.lang.Object r4 = r14.a(r15, r0)
                if (r4 != r1) goto L_0x00ac
                return r1
            L_0x00a9:
                r17 = r4
                r3 = r5
            L_0x00ac:
                long r7 = r7 >> r17
                int r2 = r2 + r3
                r5 = r3
                r4 = r17
                goto L_0x006d
            L_0x00b3:
                r3 = r5
                if (r6 != r4) goto L_0x00c5
                r2 = r10
                r10 = r9
                r9 = r2
                r8 = r11
                r6 = r12
                r7 = r13
                r2 = r14
                goto L_0x00bf
            L_0x00be:
                r3 = r5
            L_0x00bf:
                if (r10 == r9) goto L_0x00c5
                int r10 = r10 + 1
                r5 = r3
                goto L_0x0049
            L_0x00c5:
                W2.J r1 = W2.J.f19942a
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.collection.MutableScatterMap$MutableMapWrapper$entries$1$iterator$1.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(C2753g gVar, C2308e eVar) {
            return ((AnonymousClass1) create(gVar, eVar)).invokeSuspend(J.f19942a);
        }
    }

    MutableScatterMap$MutableMapWrapper$entries$1$iterator$1(final MutableScatterMap<K, V> mutableScatterMap) {
        this.this$0 = mutableScatterMap;
        this.iterator = C2754h.a(new AnonymousClass1((C2308e) null));
    }

    public final int getCurrent() {
        return this.current;
    }

    public final Iterator<Map.Entry<K, V>> getIterator() {
        return this.iterator;
    }

    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    public void remove() {
        int i5 = this.current;
        if (i5 != -1) {
            this.this$0.removeValueAt(i5);
            this.current = -1;
        }
    }

    public final void setCurrent(int i5) {
        this.current = i5;
    }

    public final void setIterator(Iterator<? extends Map.Entry<K, V>> it) {
        t.e(it, "<set-?>");
        this.iterator = it;
    }

    public Map.Entry<K, V> next() {
        return (Map.Entry) this.iterator.next();
    }
}
