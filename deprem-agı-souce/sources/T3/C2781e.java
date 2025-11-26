package t3;

import java.util.Iterator;
import java.util.NoSuchElementException;
import k3.p;
import kotlin.jvm.internal.t;
import l3.C2677a;
import q3.C2728d;
import q3.C2729e;
import s3.C2751e;

/* renamed from: t3.e  reason: case insensitive filesystem */
final class C2781e implements C2751e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f25894a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final int f25895b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final int f25896c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final p f25897d;

    /* renamed from: t3.e$a */
    public static final class a implements Iterator, C2677a {

        /* renamed from: a  reason: collision with root package name */
        private int f25898a = -1;

        /* renamed from: b  reason: collision with root package name */
        private int f25899b;

        /* renamed from: c  reason: collision with root package name */
        private int f25900c;

        /* renamed from: d  reason: collision with root package name */
        private C2728d f25901d;

        /* renamed from: e  reason: collision with root package name */
        private int f25902e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ C2781e f25903f;

        a(C2781e eVar) {
            this.f25903f = eVar;
            int h5 = C2729e.h(eVar.f25895b, 0, eVar.f25894a.length());
            this.f25899b = h5;
            this.f25900c = h5;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
            if (r0 < t3.C2781e.c(r6.f25903f)) goto L_0x0022;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        private final void a() {
            /*
                r6 = this;
                int r0 = r6.f25900c
                r1 = 0
                if (r0 >= 0) goto L_0x000b
                r6.f25898a = r1
                r0 = 0
                r6.f25901d = r0
                return
            L_0x000b:
                t3.e r0 = r6.f25903f
                int r0 = r0.f25896c
                r2 = -1
                r3 = 1
                if (r0 <= 0) goto L_0x0022
                int r0 = r6.f25902e
                int r0 = r0 + r3
                r6.f25902e = r0
                t3.e r4 = r6.f25903f
                int r4 = r4.f25896c
                if (r0 >= r4) goto L_0x0030
            L_0x0022:
                int r0 = r6.f25900c
                t3.e r4 = r6.f25903f
                java.lang.CharSequence r4 = r4.f25894a
                int r4 = r4.length()
                if (r0 <= r4) goto L_0x0046
            L_0x0030:
                q3.d r0 = new q3.d
                int r1 = r6.f25899b
                t3.e r4 = r6.f25903f
                java.lang.CharSequence r4 = r4.f25894a
                int r4 = t3.C2771H.Z(r4)
                r0.<init>(r1, r4)
                r6.f25901d = r0
                r6.f25900c = r2
                goto L_0x009b
            L_0x0046:
                t3.e r0 = r6.f25903f
                k3.p r0 = r0.f25897d
                t3.e r4 = r6.f25903f
                java.lang.CharSequence r4 = r4.f25894a
                int r5 = r6.f25900c
                java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
                java.lang.Object r0 = r0.invoke(r4, r5)
                W2.s r0 = (W2.s) r0
                if (r0 != 0) goto L_0x0076
                q3.d r0 = new q3.d
                int r1 = r6.f25899b
                t3.e r4 = r6.f25903f
                java.lang.CharSequence r4 = r4.f25894a
                int r4 = t3.C2771H.Z(r4)
                r0.<init>(r1, r4)
                r6.f25901d = r0
                r6.f25900c = r2
                goto L_0x009b
            L_0x0076:
                java.lang.Object r2 = r0.a()
                java.lang.Number r2 = (java.lang.Number) r2
                int r2 = r2.intValue()
                java.lang.Object r0 = r0.b()
                java.lang.Number r0 = (java.lang.Number) r0
                int r0 = r0.intValue()
                int r4 = r6.f25899b
                q3.d r4 = q3.C2729e.l(r4, r2)
                r6.f25901d = r4
                int r2 = r2 + r0
                r6.f25899b = r2
                if (r0 != 0) goto L_0x0098
                r1 = r3
            L_0x0098:
                int r2 = r2 + r1
                r6.f25900c = r2
            L_0x009b:
                r6.f25898a = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: t3.C2781e.a.a():void");
        }

        /* renamed from: b */
        public C2728d next() {
            if (this.f25898a == -1) {
                a();
            }
            if (this.f25898a != 0) {
                C2728d dVar = this.f25901d;
                t.c(dVar, "null cannot be cast to non-null type kotlin.ranges.IntRange");
                this.f25901d = null;
                this.f25898a = -1;
                return dVar;
            }
            throw new NoSuchElementException();
        }

        public boolean hasNext() {
            if (this.f25898a == -1) {
                a();
            }
            if (this.f25898a == 1) {
                return true;
            }
            return false;
        }

        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }

    public C2781e(CharSequence charSequence, int i5, int i6, p pVar) {
        t.e(charSequence, "input");
        t.e(pVar, "getNextMatch");
        this.f25894a = charSequence;
        this.f25895b = i5;
        this.f25896c = i6;
        this.f25897d = pVar;
    }

    public Iterator iterator() {
        return new a(this);
    }
}
