package e1;

import H3.j;
import H3.w;
import J3.f;
import K3.c;
import K3.d;
import K3.e;
import L3.C;
import L3.C0;
import L3.C2091h0;
import L3.C2092i;
import L3.H0;
import L3.M;
import L3.R0;
import L3.W;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

@j
public final class h {
    public static final b Companion = new b((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final Boolean f15266a;

    /* renamed from: b  reason: collision with root package name */
    private final Double f15267b;

    /* renamed from: c  reason: collision with root package name */
    private final Integer f15268c;

    /* renamed from: d  reason: collision with root package name */
    private final Integer f15269d;

    /* renamed from: e  reason: collision with root package name */
    private final Long f15270e;

    public /* synthetic */ class a implements M {

        /* renamed from: a  reason: collision with root package name */
        public static final a f15271a;
        private static final f descriptor;

        static {
            a aVar = new a();
            f15271a = aVar;
            H0 h02 = new H0("com.google.firebase.sessions.settings.SessionConfigs", aVar, 5);
            h02.o("sessionsEnabled", false);
            h02.o("sessionSamplingRate", false);
            h02.o("sessionTimeoutSeconds", false);
            h02.o("cacheDurationSeconds", false);
            h02.o("cacheUpdatedTimeSeconds", false);
            descriptor = h02;
        }

        private a() {
        }

        /* renamed from: a */
        public final h deserialize(e eVar) {
            Long l5;
            Integer num;
            Integer num2;
            Double d5;
            Boolean bool;
            int i5;
            e eVar2 = eVar;
            t.e(eVar2, "decoder");
            f fVar = descriptor;
            c beginStructure = eVar2.beginStructure(fVar);
            Boolean bool2 = null;
            if (beginStructure.decodeSequentially()) {
                W w4 = W.f18492a;
                bool = (Boolean) beginStructure.decodeNullableSerializableElement(fVar, 0, C2092i.f18534a, (Object) null);
                num = (Integer) beginStructure.decodeNullableSerializableElement(fVar, 3, w4, (Object) null);
                l5 = (Long) beginStructure.decodeNullableSerializableElement(fVar, 4, C2091h0.f18531a, (Object) null);
                num2 = (Integer) beginStructure.decodeNullableSerializableElement(fVar, 2, w4, (Object) null);
                d5 = (Double) beginStructure.decodeNullableSerializableElement(fVar, 1, C.f18428a, (Object) null);
                i5 = 31;
            } else {
                boolean z4 = true;
                int i6 = 0;
                Double d6 = null;
                Integer num3 = null;
                Integer num4 = null;
                Long l6 = null;
                while (z4) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(fVar);
                    if (decodeElementIndex == -1) {
                        z4 = false;
                    } else if (decodeElementIndex == 0) {
                        bool2 = (Boolean) beginStructure.decodeNullableSerializableElement(fVar, 0, C2092i.f18534a, bool2);
                        i6 |= 1;
                    } else if (decodeElementIndex == 1) {
                        d6 = (Double) beginStructure.decodeNullableSerializableElement(fVar, 1, C.f18428a, d6);
                        i6 |= 2;
                    } else if (decodeElementIndex == 2) {
                        num3 = (Integer) beginStructure.decodeNullableSerializableElement(fVar, 2, W.f18492a, num3);
                        i6 |= 4;
                    } else if (decodeElementIndex == 3) {
                        num4 = (Integer) beginStructure.decodeNullableSerializableElement(fVar, 3, W.f18492a, num4);
                        i6 |= 8;
                    } else if (decodeElementIndex == 4) {
                        l6 = (Long) beginStructure.decodeNullableSerializableElement(fVar, 4, C2091h0.f18531a, l6);
                        i6 |= 16;
                    } else {
                        throw new w(decodeElementIndex);
                    }
                }
                i5 = i6;
                bool = bool2;
                d5 = d6;
                num2 = num3;
                num = num4;
                l5 = l6;
            }
            beginStructure.endStructure(fVar);
            return new h(i5, bool, d5, num2, num, l5, (R0) null);
        }

        /* renamed from: b */
        public final void serialize(K3.f fVar, h hVar) {
            t.e(fVar, "encoder");
            t.e(hVar, "value");
            f fVar2 = descriptor;
            d beginStructure = fVar.beginStructure(fVar2);
            h.f(hVar, beginStructure, fVar2);
            beginStructure.endStructure(fVar2);
        }

        public final H3.b[] childSerializers() {
            H3.b t5 = I3.a.t(C2092i.f18534a);
            H3.b t6 = I3.a.t(C.f18428a);
            W w4 = W.f18492a;
            return new H3.b[]{t5, t6, I3.a.t(w4), I3.a.t(w4), I3.a.t(C2091h0.f18531a)};
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
            return a.f15271a;
        }

        public /* synthetic */ b(C2633k kVar) {
            this();
        }
    }

    public /* synthetic */ h(int i5, Boolean bool, Double d5, Integer num, Integer num2, Long l5, R0 r02) {
        if (31 != (i5 & 31)) {
            C0.a(i5, 31, a.f15271a.getDescriptor());
        }
        this.f15266a = bool;
        this.f15267b = d5;
        this.f15268c = num;
        this.f15269d = num2;
        this.f15270e = l5;
    }

    public static final /* synthetic */ void f(h hVar, d dVar, f fVar) {
        dVar.encodeNullableSerializableElement(fVar, 0, C2092i.f18534a, hVar.f15266a);
        dVar.encodeNullableSerializableElement(fVar, 1, C.f18428a, hVar.f15267b);
        W w4 = W.f18492a;
        dVar.encodeNullableSerializableElement(fVar, 2, w4, hVar.f15268c);
        dVar.encodeNullableSerializableElement(fVar, 3, w4, hVar.f15269d);
        dVar.encodeNullableSerializableElement(fVar, 4, C2091h0.f18531a, hVar.f15270e);
    }

    public final Integer a() {
        return this.f15269d;
    }

    public final Long b() {
        return this.f15270e;
    }

    public final Double c() {
        return this.f15267b;
    }

    public final Integer d() {
        return this.f15268c;
    }

    public final Boolean e() {
        return this.f15266a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof h)) {
            return false;
        }
        h hVar = (h) obj;
        if (t.a(this.f15266a, hVar.f15266a) && t.a(this.f15267b, hVar.f15267b) && t.a(this.f15268c, hVar.f15268c) && t.a(this.f15269d, hVar.f15269d) && t.a(this.f15270e, hVar.f15270e)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        int i5;
        int i6;
        int i7;
        int i8;
        Boolean bool = this.f15266a;
        int i9 = 0;
        if (bool == null) {
            i5 = 0;
        } else {
            i5 = bool.hashCode();
        }
        int i10 = i5 * 31;
        Double d5 = this.f15267b;
        if (d5 == null) {
            i6 = 0;
        } else {
            i6 = d5.hashCode();
        }
        int i11 = (i10 + i6) * 31;
        Integer num = this.f15268c;
        if (num == null) {
            i7 = 0;
        } else {
            i7 = num.hashCode();
        }
        int i12 = (i11 + i7) * 31;
        Integer num2 = this.f15269d;
        if (num2 == null) {
            i8 = 0;
        } else {
            i8 = num2.hashCode();
        }
        int i13 = (i12 + i8) * 31;
        Long l5 = this.f15270e;
        if (l5 != null) {
            i9 = l5.hashCode();
        }
        return i13 + i9;
    }

    public String toString() {
        return "SessionConfigs(sessionsEnabled=" + this.f15266a + ", sessionSamplingRate=" + this.f15267b + ", sessionTimeoutSeconds=" + this.f15268c + ", cacheDurationSeconds=" + this.f15269d + ", cacheUpdatedTimeSeconds=" + this.f15270e + ')';
    }

    public h(Boolean bool, Double d5, Integer num, Integer num2, Long l5) {
        this.f15266a = bool;
        this.f15267b = d5;
        this.f15268c = num;
        this.f15269d = num2;
        this.f15270e = l5;
    }
}
