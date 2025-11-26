package L3;

import J3.f;
import X2.C2242i;
import k3.p;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class E {

    /* renamed from: e  reason: collision with root package name */
    private static final a f18433e = new a((C2633k) null);

    /* renamed from: f  reason: collision with root package name */
    private static final long[] f18434f = new long[0];

    /* renamed from: a  reason: collision with root package name */
    private final f f18435a;

    /* renamed from: b  reason: collision with root package name */
    private final p f18436b;

    /* renamed from: c  reason: collision with root package name */
    private long f18437c;

    /* renamed from: d  reason: collision with root package name */
    private final long[] f18438d;

    private static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public E(f fVar, p pVar) {
        t.e(fVar, "descriptor");
        t.e(pVar, "readIfAbsent");
        this.f18435a = fVar;
        this.f18436b = pVar;
        int e5 = fVar.e();
        long j5 = 0;
        if (e5 <= 64) {
            this.f18437c = e5 != 64 ? -1 << e5 : j5;
            this.f18438d = f18434f;
            return;
        }
        this.f18437c = 0;
        this.f18438d = e(e5);
    }

    private final void b(int i5) {
        int i6 = (i5 >>> 6) - 1;
        long[] jArr = this.f18438d;
        jArr[i6] = jArr[i6] | (1 << (i5 & 63));
    }

    private final int c() {
        int length = this.f18438d.length;
        int i5 = 0;
        while (i5 < length) {
            int i6 = i5 + 1;
            int i7 = i6 * 64;
            long j5 = this.f18438d[i5];
            while (j5 != -1) {
                int numberOfTrailingZeros = Long.numberOfTrailingZeros(~j5);
                j5 |= 1 << numberOfTrailingZeros;
                int i8 = numberOfTrailingZeros + i7;
                if (((Boolean) this.f18436b.invoke(this.f18435a, Integer.valueOf(i8))).booleanValue()) {
                    this.f18438d[i5] = j5;
                    return i8;
                }
            }
            this.f18438d[i5] = j5;
            i5 = i6;
        }
        return -1;
    }

    private final long[] e(int i5) {
        long[] jArr = new long[((i5 - 1) >>> 6)];
        if ((i5 & 63) != 0) {
            jArr[C2242i.R(jArr)] = -1 << i5;
        }
        return jArr;
    }

    public final void a(int i5) {
        if (i5 < 64) {
            this.f18437c |= 1 << i5;
        } else {
            b(i5);
        }
    }

    public final int d() {
        int numberOfTrailingZeros;
        int e5 = this.f18435a.e();
        do {
            long j5 = this.f18437c;
            if (j5 != -1) {
                numberOfTrailingZeros = Long.numberOfTrailingZeros(~j5);
                this.f18437c |= 1 << numberOfTrailingZeros;
            } else if (e5 > 64) {
                return c();
            } else {
                return -1;
            }
        } while (!((Boolean) this.f18436b.invoke(this.f18435a, Integer.valueOf(numberOfTrailingZeros))).booleanValue());
        return numberOfTrailingZeros;
    }
}
