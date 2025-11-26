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
import L3.W;
import L3.W0;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

@j
public final class K {
    public static final b Companion = new b((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final String f4539a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4540b;

    /* renamed from: c  reason: collision with root package name */
    private final int f4541c;

    /* renamed from: d  reason: collision with root package name */
    private final long f4542d;

    public /* synthetic */ class a implements M {

        /* renamed from: a  reason: collision with root package name */
        public static final a f4543a;
        private static final f descriptor;

        static {
            a aVar = new a();
            f4543a = aVar;
            H0 h02 = new H0("com.google.firebase.sessions.SessionDetails", aVar, 4);
            h02.o("sessionId", false);
            h02.o("firstSessionId", false);
            h02.o("sessionIndex", false);
            h02.o("sessionStartTimestampUs", false);
            descriptor = h02;
        }

        private a() {
        }

        /* renamed from: a */
        public final K deserialize(e eVar) {
            String str;
            int i5;
            int i6;
            String str2;
            long j5;
            e eVar2 = eVar;
            t.e(eVar2, "decoder");
            f fVar = descriptor;
            c beginStructure = eVar2.beginStructure(fVar);
            if (beginStructure.decodeSequentially()) {
                str = beginStructure.decodeStringElement(fVar, 0);
                String decodeStringElement = beginStructure.decodeStringElement(fVar, 1);
                i5 = 15;
                i6 = beginStructure.decodeIntElement(fVar, 2);
                str2 = decodeStringElement;
                j5 = beginStructure.decodeLongElement(fVar, 3);
            } else {
                str = null;
                String str3 = null;
                boolean z4 = true;
                long j6 = 0;
                int i7 = 0;
                int i8 = 0;
                while (z4) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(fVar);
                    if (decodeElementIndex == -1) {
                        z4 = false;
                    } else if (decodeElementIndex == 0) {
                        str = beginStructure.decodeStringElement(fVar, 0);
                        i7 |= 1;
                    } else if (decodeElementIndex == 1) {
                        str3 = beginStructure.decodeStringElement(fVar, 1);
                        i7 |= 2;
                    } else if (decodeElementIndex == 2) {
                        i8 = beginStructure.decodeIntElement(fVar, 2);
                        i7 |= 4;
                    } else if (decodeElementIndex == 3) {
                        j6 = beginStructure.decodeLongElement(fVar, 3);
                        i7 |= 8;
                    } else {
                        throw new w(decodeElementIndex);
                    }
                }
                i5 = i7;
                i6 = i8;
                str2 = str3;
                j5 = j6;
            }
            String str4 = str;
            beginStructure.endStructure(fVar);
            return new K(i5, str4, str2, i6, j5, (R0) null);
        }

        /* renamed from: b */
        public final void serialize(K3.f fVar, K k5) {
            t.e(fVar, "encoder");
            t.e(k5, "value");
            f fVar2 = descriptor;
            d beginStructure = fVar.beginStructure(fVar2);
            K.e(k5, beginStructure, fVar2);
            beginStructure.endStructure(fVar2);
        }

        public final H3.b[] childSerializers() {
            W0 w02 = W0.f18494a;
            return new H3.b[]{w02, w02, W.f18492a, C2091h0.f18531a};
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
            return a.f4543a;
        }

        public /* synthetic */ b(C2633k kVar) {
            this();
        }
    }

    public /* synthetic */ K(int i5, String str, String str2, int i6, long j5, R0 r02) {
        if (15 != (i5 & 15)) {
            C0.a(i5, 15, a.f4543a.getDescriptor());
        }
        this.f4539a = str;
        this.f4540b = str2;
        this.f4541c = i6;
        this.f4542d = j5;
    }

    public static final /* synthetic */ void e(K k5, d dVar, f fVar) {
        dVar.encodeStringElement(fVar, 0, k5.f4539a);
        dVar.encodeStringElement(fVar, 1, k5.f4540b);
        dVar.encodeIntElement(fVar, 2, k5.f4541c);
        dVar.encodeLongElement(fVar, 3, k5.f4542d);
    }

    public final String a() {
        return this.f4540b;
    }

    public final String b() {
        return this.f4539a;
    }

    public final int c() {
        return this.f4541c;
    }

    public final long d() {
        return this.f4542d;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof K)) {
            return false;
        }
        K k5 = (K) obj;
        if (t.a(this.f4539a, k5.f4539a) && t.a(this.f4540b, k5.f4540b) && this.f4541c == k5.f4541c && this.f4542d == k5.f4542d) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (((((this.f4539a.hashCode() * 31) + this.f4540b.hashCode()) * 31) + this.f4541c) * 31) + androidx.collection.a.a(this.f4542d);
    }

    public String toString() {
        return "SessionDetails(sessionId=" + this.f4539a + ", firstSessionId=" + this.f4540b + ", sessionIndex=" + this.f4541c + ", sessionStartTimestampUs=" + this.f4542d + ')';
    }

    public K(String str, String str2, int i5, long j5) {
        t.e(str, "sessionId");
        t.e(str2, "firstSessionId");
        this.f4539a = str;
        this.f4540b = str2;
        this.f4541c = i5;
        this.f4542d = j5;
    }
}
