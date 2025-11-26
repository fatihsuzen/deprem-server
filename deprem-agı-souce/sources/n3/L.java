package N3;

import H3.k;
import J3.n;
import K3.c;
import K3.e;
import L3.C2078b;
import M3.B;
import M3.C2128b;
import M3.f;
import M3.g;
import M3.h;
import M3.i;
import M3.z;
import O3.d;
import W2.C2219h;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import b.w;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import t3.s;

public class L extends K3.a implements g {

    /* renamed from: a  reason: collision with root package name */
    private final C2128b f18743a;

    /* renamed from: b  reason: collision with root package name */
    private final U f18744b;

    /* renamed from: c  reason: collision with root package name */
    public final C2131a f18745c;

    /* renamed from: d  reason: collision with root package name */
    private final d f18746d;

    /* renamed from: e  reason: collision with root package name */
    private int f18747e = -1;

    /* renamed from: f  reason: collision with root package name */
    private a f18748f;

    /* renamed from: g  reason: collision with root package name */
    private final f f18749g;

    /* renamed from: h  reason: collision with root package name */
    private final w f18750h;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public String f18751a;

        public a(String str) {
            this.f18751a = str;
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f18752a;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                N3.U[] r0 = N3.U.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                N3.U r1 = N3.U.LIST     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                N3.U r1 = N3.U.MAP     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                N3.U r1 = N3.U.POLY_OBJ     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                N3.U r1 = N3.U.OBJ     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                f18752a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: N3.L.b.<clinit>():void");
        }
    }

    public L(C2128b bVar, U u5, C2131a aVar, J3.f fVar, a aVar2) {
        w wVar;
        t.e(bVar, "json");
        t.e(u5, "mode");
        t.e(aVar, "lexer");
        t.e(fVar, "descriptor");
        this.f18743a = bVar;
        this.f18744b = u5;
        this.f18745c = aVar;
        this.f18746d = bVar.d();
        this.f18748f = aVar2;
        f c5 = bVar.c();
        this.f18749g = c5;
        if (c5.j()) {
            wVar = null;
        } else {
            wVar = new w(fVar);
        }
        this.f18750h = wVar;
    }

    private final void c() {
        if (this.f18745c.F() == 4) {
            C2131a.x(this.f18745c, "Unexpected leading comma", 0, (String) null, 6, (Object) null);
            throw new C2219h();
        }
    }

    private final boolean d(J3.f fVar, int i5) {
        String G4;
        boolean z4;
        C2128b bVar = this.f18743a;
        boolean i6 = fVar.i(i5);
        J3.f h5 = fVar.h(i5);
        if (i6 && !h5.c() && this.f18745c.N(true)) {
            return true;
        }
        if (!t.a(h5.getKind(), n.b.f18389a) || ((h5.c() && this.f18745c.N(false)) || (G4 = this.f18745c.G(this.f18749g.q())) == null)) {
            return false;
        }
        int i7 = B.i(h5, bVar, G4);
        if (bVar.c().j() || !h5.c()) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (i7 == -3 && (i6 || z4)) {
            this.f18745c.o();
            return true;
        }
        return false;
    }

    private final int e() {
        boolean M4 = this.f18745c.M();
        if (this.f18745c.e()) {
            int i5 = this.f18747e;
            if (i5 == -1 || M4) {
                int i6 = i5 + 1;
                this.f18747e = i6;
                return i6;
            }
            C2131a.x(this.f18745c, "Expected end of the array or comma", 0, (String) null, 6, (Object) null);
            throw new C2219h();
        } else if (!M4 || this.f18743a.c().d()) {
            return -1;
        } else {
            z.g(this.f18745c, "array");
            throw new C2219h();
        }
    }

    private final int f() {
        boolean z4;
        int i5 = this.f18747e;
        boolean z5 = false;
        if (i5 % 2 != 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (!z4) {
            this.f18745c.l(':');
        } else if (i5 != -1) {
            z5 = this.f18745c.M();
        }
        if (this.f18745c.e()) {
            if (z4) {
                if (this.f18747e == -1) {
                    C2131a aVar = this.f18745c;
                    int i6 = aVar.f18775a;
                    if (z5) {
                        C2131a.x(aVar, "Unexpected leading comma", i6, (String) null, 4, (Object) null);
                        throw new C2219h();
                    }
                } else {
                    C2131a aVar2 = this.f18745c;
                    boolean z6 = z5;
                    int i7 = aVar2.f18775a;
                    if (!z6) {
                        C2131a.x(aVar2, "Expected comma after the key-value pair", i7, (String) null, 4, (Object) null);
                        throw new C2219h();
                    }
                }
            }
            int i8 = this.f18747e + 1;
            this.f18747e = i8;
            return i8;
        } else if (!z5 || this.f18743a.c().d()) {
            return -1;
        } else {
            z.h(this.f18745c, (String) null, 1, (Object) null);
            throw new C2219h();
        }
    }

    private final int g(J3.f fVar) {
        int i5;
        boolean z4;
        boolean M4 = this.f18745c.M();
        while (true) {
            boolean z5 = true;
            if (this.f18745c.e()) {
                String h5 = h();
                this.f18745c.l(':');
                i5 = B.i(fVar, this.f18743a, h5);
                if (i5 == -3) {
                    z4 = false;
                } else if (!this.f18749g.g() || !d(fVar, i5)) {
                    w wVar = this.f18750h;
                } else {
                    z4 = this.f18745c.M();
                    z5 = false;
                }
                if (z5) {
                    M4 = i(h5);
                } else {
                    M4 = z4;
                }
            } else if (!M4 || this.f18743a.c().d()) {
                w wVar2 = this.f18750h;
                if (wVar2 != null) {
                    return wVar2.d();
                }
                return -1;
            } else {
                z.h(this.f18745c, (String) null, 1, (Object) null);
                throw new C2219h();
            }
        }
        w wVar3 = this.f18750h;
        if (wVar3 != null) {
            wVar3.c(i5);
        }
        return i5;
    }

    private final String h() {
        if (this.f18749g.q()) {
            return this.f18745c.r();
        }
        return this.f18745c.i();
    }

    private final boolean i(String str) {
        if (this.f18749g.k() || k(this.f18748f, str)) {
            this.f18745c.I(this.f18749g.q());
        } else {
            this.f18745c.A(str);
        }
        return this.f18745c.M();
    }

    private final void j(J3.f fVar) {
        do {
        } while (decodeElementIndex(fVar) != -1);
    }

    private final boolean k(a aVar, String str) {
        if (aVar == null || !t.a(aVar.f18751a, str)) {
            return false;
        }
        aVar.f18751a = null;
        return true;
    }

    public final C2128b a() {
        return this.f18743a;
    }

    public h b() {
        return new J(this.f18743a.c(), this.f18745c).e();
    }

    public c beginStructure(J3.f fVar) {
        t.e(fVar, "descriptor");
        U b5 = V.b(this.f18743a, fVar);
        this.f18745c.f18776b.c(fVar);
        this.f18745c.l(b5.f18773a);
        c();
        int i5 = b.f18752a[b5.ordinal()];
        if (i5 == 1 || i5 == 2 || i5 == 3) {
            return new L(this.f18743a, b5, this.f18745c, fVar, this.f18748f);
        } else if (this.f18744b == b5 && this.f18743a.c().j()) {
            return this;
        } else {
            return new L(this.f18743a, b5, this.f18745c, fVar, this.f18748f);
        }
    }

    public boolean decodeBoolean() {
        return this.f18745c.g();
    }

    public byte decodeByte() {
        long m5 = this.f18745c.m();
        byte b5 = (byte) ((int) m5);
        if (m5 == ((long) b5)) {
            return b5;
        }
        C2131a aVar = this.f18745c;
        C2131a.x(aVar, "Failed to parse byte for input '" + m5 + '\'', 0, (String) null, 6, (Object) null);
        throw new C2219h();
    }

    public char decodeChar() {
        String q5 = this.f18745c.q();
        if (q5.length() == 1) {
            return q5.charAt(0);
        }
        C2131a aVar = this.f18745c;
        C2131a.x(aVar, "Expected single char, but got '" + q5 + '\'', 0, (String) null, 6, (Object) null);
        throw new C2219h();
    }

    public double decodeDouble() {
        C2131a aVar = this.f18745c;
        String q5 = aVar.q();
        try {
            double parseDouble = Double.parseDouble(q5);
            if (this.f18743a.c().b()) {
                return parseDouble;
            }
            if (!Double.isInfinite(parseDouble) && !Double.isNaN(parseDouble)) {
                return parseDouble;
            }
            z.k(this.f18745c, Double.valueOf(parseDouble));
            throw new C2219h();
        } catch (IllegalArgumentException unused) {
            C2131a.x(aVar, "Failed to parse type '" + "double" + "' for input '" + q5 + '\'', 0, (String) null, 6, (Object) null);
            throw new C2219h();
        }
    }

    public int decodeElementIndex(J3.f fVar) {
        int i5;
        t.e(fVar, "descriptor");
        int i6 = b.f18752a[this.f18744b.ordinal()];
        if (i6 == 2) {
            i5 = f();
        } else if (i6 != 4) {
            i5 = e();
        } else {
            i5 = g(fVar);
        }
        if (this.f18744b != U.MAP) {
            this.f18745c.f18776b.g(i5);
        }
        return i5;
    }

    public int decodeEnum(J3.f fVar) {
        t.e(fVar, "enumDescriptor");
        C2128b bVar = this.f18743a;
        String decodeString = decodeString();
        return B.j(fVar, bVar, decodeString, " at path " + this.f18745c.f18776b.a());
    }

    public float decodeFloat() {
        C2131a aVar = this.f18745c;
        String q5 = aVar.q();
        try {
            float parseFloat = Float.parseFloat(q5);
            if (this.f18743a.c().b()) {
                return parseFloat;
            }
            if (!Float.isInfinite(parseFloat) && !Float.isNaN(parseFloat)) {
                return parseFloat;
            }
            z.k(this.f18745c, Float.valueOf(parseFloat));
            throw new C2219h();
        } catch (IllegalArgumentException unused) {
            C2131a.x(aVar, "Failed to parse type '" + TypedValues.Custom.S_FLOAT + "' for input '" + q5 + '\'', 0, (String) null, 6, (Object) null);
            throw new C2219h();
        }
    }

    public e decodeInline(J3.f fVar) {
        t.e(fVar, "descriptor");
        if (N.b(fVar)) {
            return new C2150u(this.f18745c, this.f18743a);
        }
        return super.decodeInline(fVar);
    }

    public int decodeInt() {
        long m5 = this.f18745c.m();
        int i5 = (int) m5;
        if (m5 == ((long) i5)) {
            return i5;
        }
        C2131a aVar = this.f18745c;
        C2131a.x(aVar, "Failed to parse int for input '" + m5 + '\'', 0, (String) null, 6, (Object) null);
        throw new C2219h();
    }

    public long decodeLong() {
        return this.f18745c.m();
    }

    public boolean decodeNotNullMark() {
        boolean z4;
        w wVar = this.f18750h;
        if (wVar != null) {
            z4 = wVar.b();
        } else {
            z4 = false;
        }
        if (z4 || C2131a.O(this.f18745c, false, 1, (Object) null)) {
            return false;
        }
        return true;
    }

    public Void decodeNull() {
        return null;
    }

    public Object decodeSerializableElement(J3.f fVar, int i5, H3.a aVar, Object obj) {
        boolean z4;
        t.e(fVar, "descriptor");
        t.e(aVar, "deserializer");
        if (this.f18744b == U.MAP && (i5 & 1) == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (z4) {
            this.f18745c.f18776b.d();
        }
        Object decodeSerializableElement = super.decodeSerializableElement(fVar, i5, aVar, obj);
        if (z4) {
            this.f18745c.f18776b.f(decodeSerializableElement);
        }
        return decodeSerializableElement;
    }

    public Object decodeSerializableValue(H3.a aVar) {
        z zVar;
        String str;
        B h5;
        t.e(aVar, "deserializer");
        try {
            if (aVar instanceof C2078b) {
                if (!this.f18743a.c().p()) {
                    String c5 = K.c(((C2078b) aVar).getDescriptor(), this.f18743a);
                    String E4 = this.f18745c.E(c5, this.f18749g.q());
                    if (E4 == null) {
                        if (w.a(aVar)) {
                            if (!a().c().p()) {
                                String c6 = K.c(((C2078b) aVar).getDescriptor(), a());
                                h b5 = b();
                                String a5 = ((C2078b) aVar).getDescriptor().a();
                                if (b5 instanceof z) {
                                    zVar = (z) b5;
                                    h hVar = (h) zVar.get(c6);
                                    if (hVar == null || (h5 = i.h(hVar)) == null) {
                                        str = null;
                                    } else {
                                        str = i.d(h5);
                                    }
                                    H3.a a6 = H3.h.a((C2078b) aVar, this, str);
                                    t.c(a6, "null cannot be cast to non-null type kotlinx.serialization.DeserializationStrategy<T of kotlinx.serialization.json.internal.PolymorphicKt.decodeSerializableValuePolymorphic>");
                                    return T.a(a(), c6, zVar, a6);
                                }
                                throw z.e(-1, "Expected " + M.b(z.class).c() + ", but had " + M.b(b5.getClass()).c() + " as the serialized body of " + a5 + " at element: " + this.f18745c.f18776b.a(), b5.toString());
                            }
                        }
                        return aVar.deserialize(this);
                    }
                    H3.a a7 = H3.h.a((C2078b) aVar, this, E4);
                    t.c(a7, "null cannot be cast to non-null type kotlinx.serialization.DeserializationStrategy<T of kotlinx.serialization.json.internal.StreamingJsonDecoder.decodeSerializableValue>");
                    this.f18748f = new a(c5);
                    return a7.deserialize(this);
                }
            }
            return aVar.deserialize(this);
        } catch (k e5) {
            k kVar = e5;
            String message = kVar.getMessage();
            t.b(message);
            String A02 = s.A0(s.S0(message, 10, (String) null, 2, (Object) null), ".");
            String message2 = kVar.getMessage();
            t.b(message2);
            C2131a.x(this.f18745c, A02, 0, s.L0(message2, 10, ""), 2, (Object) null);
            throw new C2219h();
        } catch (k e6) {
            String message3 = e6.getMessage();
            t.b(message3);
            throw z.e(-1, message3, zVar.toString());
        } catch (H3.c e7) {
            H3.c cVar = e7;
            String message4 = cVar.getMessage();
            t.b(message4);
            if (s.V(message4, "at path", false, 2, (Object) null)) {
                throw cVar;
            }
            throw new H3.c(cVar.a(), cVar.getMessage() + " at path: " + this.f18745c.f18776b.a(), cVar);
        }
    }

    public short decodeShort() {
        long m5 = this.f18745c.m();
        short s5 = (short) ((int) m5);
        if (m5 == ((long) s5)) {
            return s5;
        }
        C2131a aVar = this.f18745c;
        C2131a.x(aVar, "Failed to parse short for input '" + m5 + '\'', 0, (String) null, 6, (Object) null);
        throw new C2219h();
    }

    public String decodeString() {
        if (this.f18749g.q()) {
            return this.f18745c.r();
        }
        return this.f18745c.o();
    }

    public void endStructure(J3.f fVar) {
        t.e(fVar, "descriptor");
        if (this.f18743a.c().k() && fVar.e() == 0) {
            j(fVar);
        }
        if (!this.f18745c.M() || this.f18743a.c().d()) {
            this.f18745c.l(this.f18744b.f18774b);
            this.f18745c.f18776b.b();
            return;
        }
        z.g(this.f18745c, "");
        throw new C2219h();
    }

    public d getSerializersModule() {
        return this.f18746d;
    }
}
