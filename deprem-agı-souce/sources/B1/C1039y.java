package b1;

import H3.j;
import H3.w;
import J3.f;
import K3.c;
import K3.d;
import K3.e;
import L3.C0;
import L3.H0;
import L3.M;
import L3.R0;
import L3.W;
import L3.W0;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

@j
/* renamed from: b1.y  reason: case insensitive filesystem */
public final class C1039y {
    public static final b Companion = new b((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final int f4739a;

    /* renamed from: b  reason: collision with root package name */
    private final String f4740b;

    /* renamed from: b1.y$a */
    public /* synthetic */ class a implements M {

        /* renamed from: a  reason: collision with root package name */
        public static final a f4741a;
        private static final f descriptor;

        static {
            a aVar = new a();
            f4741a = aVar;
            H0 h02 = new H0("com.google.firebase.sessions.ProcessData", aVar, 2);
            h02.o("pid", false);
            h02.o("uuid", false);
            descriptor = h02;
        }

        private a() {
        }

        /* renamed from: a */
        public final C1039y deserialize(e eVar) {
            int i5;
            String str;
            int i6;
            t.e(eVar, "decoder");
            f fVar = descriptor;
            c beginStructure = eVar.beginStructure(fVar);
            if (beginStructure.decodeSequentially()) {
                i6 = beginStructure.decodeIntElement(fVar, 0);
                str = beginStructure.decodeStringElement(fVar, 1);
                i5 = 3;
            } else {
                boolean z4 = true;
                i6 = 0;
                int i7 = 0;
                String str2 = null;
                while (z4) {
                    int decodeElementIndex = beginStructure.decodeElementIndex(fVar);
                    if (decodeElementIndex == -1) {
                        z4 = false;
                    } else if (decodeElementIndex == 0) {
                        i6 = beginStructure.decodeIntElement(fVar, 0);
                        i7 |= 1;
                    } else if (decodeElementIndex == 1) {
                        str2 = beginStructure.decodeStringElement(fVar, 1);
                        i7 |= 2;
                    } else {
                        throw new w(decodeElementIndex);
                    }
                }
                str = str2;
                i5 = i7;
            }
            beginStructure.endStructure(fVar);
            return new C1039y(i5, i6, str, (R0) null);
        }

        /* renamed from: b */
        public final void serialize(K3.f fVar, C1039y yVar) {
            t.e(fVar, "encoder");
            t.e(yVar, "value");
            f fVar2 = descriptor;
            d beginStructure = fVar.beginStructure(fVar2);
            C1039y.c(yVar, beginStructure, fVar2);
            beginStructure.endStructure(fVar2);
        }

        public final H3.b[] childSerializers() {
            return new H3.b[]{W.f18492a, W0.f18494a};
        }

        public final f getDescriptor() {
            return descriptor;
        }

        public H3.b[] typeParametersSerializers() {
            return M.a.a(this);
        }
    }

    /* renamed from: b1.y$b */
    public static final class b {
        private b() {
        }

        public final H3.b serializer() {
            return a.f4741a;
        }

        public /* synthetic */ b(C2633k kVar) {
            this();
        }
    }

    public /* synthetic */ C1039y(int i5, int i6, String str, R0 r02) {
        if (3 != (i5 & 3)) {
            C0.a(i5, 3, a.f4741a.getDescriptor());
        }
        this.f4739a = i6;
        this.f4740b = str;
    }

    public static final /* synthetic */ void c(C1039y yVar, d dVar, f fVar) {
        dVar.encodeIntElement(fVar, 0, yVar.f4739a);
        dVar.encodeStringElement(fVar, 1, yVar.f4740b);
    }

    public final int a() {
        return this.f4739a;
    }

    public final String b() {
        return this.f4740b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C1039y)) {
            return false;
        }
        C1039y yVar = (C1039y) obj;
        if (this.f4739a == yVar.f4739a && t.a(this.f4740b, yVar.f4740b)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (this.f4739a * 31) + this.f4740b.hashCode();
    }

    public String toString() {
        return "ProcessData(pid=" + this.f4739a + ", uuid=" + this.f4740b + ')';
    }

    public C1039y(int i5, String str) {
        t.e(str, "uuid");
        this.f4739a = i5;
        this.f4740b = str;
    }
}
