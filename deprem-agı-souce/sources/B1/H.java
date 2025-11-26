package b1;

import H3.j;
import H3.w;
import J3.f;
import K3.c;
import K3.d;
import K3.e;
import L3.C0;
import L3.C2079b0;
import L3.H0;
import L3.M;
import L3.R0;
import L3.W0;
import b1.C1039y;
import b1.K;
import b1.Z;
import java.util.Map;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

@j
public final class H {
    public static final b Companion = new b((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final H3.b[] f4532d = {null, null, new C2079b0(W0.f18494a, C1039y.a.f4741a)};

    /* renamed from: a  reason: collision with root package name */
    private final K f4533a;

    /* renamed from: b  reason: collision with root package name */
    private final Z f4534b;

    /* renamed from: c  reason: collision with root package name */
    private final Map f4535c;

    public /* synthetic */ class a implements M {

        /* renamed from: a  reason: collision with root package name */
        public static final a f4536a;
        private static final f descriptor;

        static {
            a aVar = new a();
            f4536a = aVar;
            H0 h02 = new H0("com.google.firebase.sessions.SessionData", aVar, 3);
            h02.o("sessionDetails", false);
            h02.o("backgroundTime", true);
            h02.o("processDataMap", true);
            descriptor = h02;
        }

        private a() {
        }

        /* renamed from: a */
        public final H deserialize(e eVar) {
            Map map;
            Z z4;
            K k5;
            int i5;
            e eVar2 = eVar;
            t.e(eVar2, "decoder");
            f fVar = descriptor;
            c beginStructure = eVar2.beginStructure(fVar);
            H3.b[] a5 = H.f4532d;
            K k6 = null;
            if (beginStructure.decodeSequentially()) {
                map = (Map) beginStructure.decodeNullableSerializableElement(fVar, 2, a5[2], (Object) null);
                k5 = (K) beginStructure.decodeSerializableElement(fVar, 0, K.a.f4543a, (Object) null);
                i5 = 7;
                z4 = (Z) beginStructure.decodeNullableSerializableElement(fVar, 1, Z.a.f4639a, (Object) null);
            } else {
                boolean z5 = true;
                int i6 = 0;
                Z z6 = null;
                Map map2 = null;
                while (z5) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(fVar);
                    if (decodeElementIndex == -1) {
                        z5 = false;
                    } else if (decodeElementIndex == 0) {
                        k6 = (K) beginStructure.decodeSerializableElement(fVar, 0, K.a.f4543a, k6);
                        i6 |= 1;
                    } else if (decodeElementIndex == 1) {
                        z6 = (Z) beginStructure.decodeNullableSerializableElement(fVar, 1, Z.a.f4639a, z6);
                        i6 |= 2;
                    } else if (decodeElementIndex == 2) {
                        map2 = (Map) beginStructure.decodeNullableSerializableElement(fVar, 2, a5[2], map2);
                        i6 |= 4;
                    } else {
                        throw new w(decodeElementIndex);
                    }
                }
                i5 = i6;
                k5 = k6;
                z4 = z6;
                map = map2;
            }
            beginStructure.endStructure(fVar);
            return new H(i5, k5, z4, map, (R0) null);
        }

        /* renamed from: b */
        public final void serialize(K3.f fVar, H h5) {
            t.e(fVar, "encoder");
            t.e(h5, "value");
            f fVar2 = descriptor;
            d beginStructure = fVar.beginStructure(fVar2);
            H.g(h5, beginStructure, fVar2);
            beginStructure.endStructure(fVar2);
        }

        public final H3.b[] childSerializers() {
            H3.b[] a5 = H.f4532d;
            return new H3.b[]{K.a.f4543a, I3.a.t(Z.a.f4639a), I3.a.t(a5[2])};
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
            return a.f4536a;
        }

        public /* synthetic */ b(C2633k kVar) {
            this();
        }
    }

    public /* synthetic */ H(int i5, K k5, Z z4, Map map, R0 r02) {
        if (1 != (i5 & 1)) {
            C0.a(i5, 1, a.f4536a.getDescriptor());
        }
        this.f4533a = k5;
        if ((i5 & 2) == 0) {
            this.f4534b = null;
        } else {
            this.f4534b = z4;
        }
        if ((i5 & 4) == 0) {
            this.f4535c = null;
        } else {
            this.f4535c = map;
        }
    }

    public static /* synthetic */ H c(H h5, K k5, Z z4, Map map, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            k5 = h5.f4533a;
        }
        if ((i5 & 2) != 0) {
            z4 = h5.f4534b;
        }
        if ((i5 & 4) != 0) {
            map = h5.f4535c;
        }
        return h5.b(k5, z4, map);
    }

    public static final /* synthetic */ void g(H h5, d dVar, f fVar) {
        H3.b[] bVarArr = f4532d;
        dVar.encodeSerializableElement(fVar, 0, K.a.f4543a, h5.f4533a);
        if (dVar.shouldEncodeElementDefault(fVar, 1) || h5.f4534b != null) {
            dVar.encodeNullableSerializableElement(fVar, 1, Z.a.f4639a, h5.f4534b);
        }
        if (dVar.shouldEncodeElementDefault(fVar, 2) || h5.f4535c != null) {
            dVar.encodeNullableSerializableElement(fVar, 2, bVarArr[2], h5.f4535c);
        }
    }

    public final H b(K k5, Z z4, Map map) {
        t.e(k5, "sessionDetails");
        return new H(k5, z4, map);
    }

    public final Z d() {
        return this.f4534b;
    }

    public final Map e() {
        return this.f4535c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof H)) {
            return false;
        }
        H h5 = (H) obj;
        if (t.a(this.f4533a, h5.f4533a) && t.a(this.f4534b, h5.f4534b) && t.a(this.f4535c, h5.f4535c)) {
            return true;
        }
        return false;
    }

    public final K f() {
        return this.f4533a;
    }

    public int hashCode() {
        int i5;
        int hashCode = this.f4533a.hashCode() * 31;
        Z z4 = this.f4534b;
        int i6 = 0;
        if (z4 == null) {
            i5 = 0;
        } else {
            i5 = z4.hashCode();
        }
        int i7 = (hashCode + i5) * 31;
        Map map = this.f4535c;
        if (map != null) {
            i6 = map.hashCode();
        }
        return i7 + i6;
    }

    public String toString() {
        return "SessionData(sessionDetails=" + this.f4533a + ", backgroundTime=" + this.f4534b + ", processDataMap=" + this.f4535c + ')';
    }

    public H(K k5, Z z4, Map map) {
        t.e(k5, "sessionDetails");
        this.f4533a = k5;
        this.f4534b = z4;
        this.f4535c = map;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ H(K k5, Z z4, Map map, int i5, C2633k kVar) {
        this(k5, (i5 & 2) != 0 ? null : z4, (i5 & 4) != 0 ? null : map);
    }
}
