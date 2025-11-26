package b1;

import H3.j;
import H3.w;
import J3.f;
import K3.c;
import K3.d;
import K3.e;
import L3.C0;
import L3.C2091h0;
import L3.H0;
import L3.M;
import L3.R0;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import u3.C2795a;
import u3.C2797c;
import u3.C2798d;

@j
public final class Z {
    public static final b Companion = new b((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final long f4636a;

    /* renamed from: b  reason: collision with root package name */
    private final long f4637b;

    /* renamed from: c  reason: collision with root package name */
    private final long f4638c;

    public /* synthetic */ class a implements M {

        /* renamed from: a  reason: collision with root package name */
        public static final a f4639a;
        private static final f descriptor;

        static {
            a aVar = new a();
            f4639a = aVar;
            H0 h02 = new H0("com.google.firebase.sessions.Time", aVar, 3);
            h02.o("ms", false);
            h02.o("us", true);
            h02.o("seconds", true);
            descriptor = h02;
        }

        private a() {
        }

        /* renamed from: a */
        public final Z deserialize(e eVar) {
            long j5;
            long j6;
            long j7;
            int i5;
            e eVar2 = eVar;
            t.e(eVar2, "decoder");
            f fVar = descriptor;
            c beginStructure = eVar2.beginStructure(fVar);
            if (beginStructure.decodeSequentially()) {
                long decodeLongElement = beginStructure.decodeLongElement(fVar, 0);
                long decodeLongElement2 = beginStructure.decodeLongElement(fVar, 1);
                j5 = beginStructure.decodeLongElement(fVar, 2);
                i5 = 7;
                j7 = decodeLongElement;
                j6 = decodeLongElement2;
            } else {
                long j8 = 0;
                boolean z4 = true;
                int i6 = 0;
                long j9 = 0;
                long j10 = 0;
                while (z4) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(fVar);
                    if (decodeElementIndex == -1) {
                        z4 = false;
                    } else if (decodeElementIndex == 0) {
                        j9 = beginStructure.decodeLongElement(fVar, 0);
                        i6 |= 1;
                    } else if (decodeElementIndex == 1) {
                        j10 = beginStructure.decodeLongElement(fVar, 1);
                        i6 |= 2;
                    } else if (decodeElementIndex == 2) {
                        j8 = beginStructure.decodeLongElement(fVar, 2);
                        i6 |= 4;
                    } else {
                        throw new w(decodeElementIndex);
                    }
                }
                i5 = i6;
                j5 = j8;
                j7 = j9;
                j6 = j10;
            }
            beginStructure.endStructure(fVar);
            return new Z(i5, j7, j6, j5, (R0) null);
        }

        /* renamed from: b */
        public final void serialize(K3.f fVar, Z z4) {
            t.e(fVar, "encoder");
            t.e(z4, "value");
            f fVar2 = descriptor;
            d beginStructure = fVar.beginStructure(fVar2);
            Z.d(z4, beginStructure, fVar2);
            beginStructure.endStructure(fVar2);
        }

        public final H3.b[] childSerializers() {
            C2091h0 h0Var = C2091h0.f18531a;
            return new H3.b[]{h0Var, h0Var, h0Var};
        }

        public final f getDescriptor() {
            return descriptor;
        }

        public H3.b[] typeParametersSerializers() {
            return M.a.a(this);
        }
    }

    public static final class b {
        private b() {
        }

        public final H3.b serializer() {
            return a.f4639a;
        }

        public /* synthetic */ b(C2633k kVar) {
            this();
        }
    }

    public /* synthetic */ Z(int i5, long j5, long j6, long j7, R0 r02) {
        if (1 != (i5 & 1)) {
            C0.a(i5, 1, a.f4639a.getDescriptor());
        }
        this.f4636a = j5;
        this.f4637b = (i5 & 2) == 0 ? ((long) 1000) * j5 : j6;
        if ((i5 & 4) == 0) {
            this.f4638c = j5 / ((long) 1000);
        } else {
            this.f4638c = j7;
        }
    }

    public static final /* synthetic */ void d(Z z4, d dVar, f fVar) {
        dVar.encodeLongElement(fVar, 0, z4.f4636a);
        if (dVar.shouldEncodeElementDefault(fVar, 1) || z4.f4637b != z4.f4636a * ((long) 1000)) {
            dVar.encodeLongElement(fVar, 1, z4.f4637b);
        }
        if (dVar.shouldEncodeElementDefault(fVar, 2) || z4.f4638c != z4.f4636a / ((long) 1000)) {
            dVar.encodeLongElement(fVar, 2, z4.f4638c);
        }
    }

    public final long a() {
        return this.f4638c;
    }

    public final long b() {
        return this.f4637b;
    }

    public final long c(Z z4) {
        t.e(z4, "time");
        C2795a.C0262a aVar = C2795a.f25994b;
        return C2797c.t(this.f4636a - z4.f4636a, C2798d.MILLISECONDS);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if ((obj instanceof Z) && this.f4636a == ((Z) obj).f4636a) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return androidx.collection.a.a(this.f4636a);
    }

    public String toString() {
        return "Time(ms=" + this.f4636a + ')';
    }

    public Z(long j5) {
        this.f4636a = j5;
        long j6 = (long) 1000;
        this.f4637b = j5 * j6;
        this.f4638c = j5 / j6;
    }
}
