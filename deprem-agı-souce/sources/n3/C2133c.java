package N3;

import H3.a;
import H3.k;
import J3.d;
import J3.n;
import J3.o;
import K3.c;
import K3.e;
import L3.C2078b;
import L3.C2105o0;
import M3.B;
import M3.C2128b;
import M3.C2129c;
import M3.f;
import M3.g;
import M3.h;
import M3.w;
import M3.z;
import W2.C2219h;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.foundation.same.report.i;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import t3.s;

/* renamed from: N3.c  reason: case insensitive filesystem */
abstract class C2133c extends C2105o0 implements g {

    /* renamed from: c  reason: collision with root package name */
    private final C2128b f18779c;

    /* renamed from: d  reason: collision with root package name */
    private final h f18780d;

    /* renamed from: e  reason: collision with root package name */
    private final String f18781e;

    /* renamed from: f  reason: collision with root package name */
    protected final f f18782f;

    public /* synthetic */ C2133c(C2128b bVar, h hVar, String str, C2633k kVar) {
        this(bVar, hVar, str);
    }

    private final Void V(B b5, String str, String str2) {
        StringBuilder sb;
        String str3;
        if (s.P(str, i.f9538a, false, 2, (Object) null)) {
            sb = new StringBuilder();
            str3 = "an ";
        } else {
            sb = new StringBuilder();
            str3 = "a ";
        }
        sb.append(str3);
        sb.append(str);
        String sb2 = sb.toString();
        throw z.e(-1, "Failed to parse literal '" + b5 + "' as " + sb2 + " value at element: " + U(str2), G().toString());
    }

    /* access modifiers changed from: protected */
    public abstract h F(String str);

    /* access modifiers changed from: protected */
    public final h G() {
        h F4;
        String str = (String) s();
        if (str == null || (F4 = F(str)) == null) {
            return T();
        }
        return F4;
    }

    /* access modifiers changed from: protected */
    /* renamed from: H */
    public boolean h(String str) {
        t.e(str, "tag");
        h F4 = F(str);
        if (F4 instanceof B) {
            B b5 = (B) F4;
            try {
                Boolean c5 = M3.i.c(b5);
                if (c5 != null) {
                    return c5.booleanValue();
                }
                V(b5, TypedValues.Custom.S_BOOLEAN, str);
                throw new C2219h();
            } catch (IllegalArgumentException unused) {
                V(b5, TypedValues.Custom.S_BOOLEAN, str);
                throw new C2219h();
            }
        } else {
            throw z.e(-1, "Expected " + M.b(B.class).c() + ", but had " + M.b(F4.getClass()).c() + " as the serialized body of " + TypedValues.Custom.S_BOOLEAN + " at element: " + U(str), F4.toString());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: I */
    public byte i(String str) {
        Byte b5;
        t.e(str, "tag");
        h F4 = F(str);
        if (F4 instanceof B) {
            B b6 = (B) F4;
            try {
                int g5 = M3.i.g(b6);
                if (-128 > g5 || g5 > 127) {
                    b5 = null;
                } else {
                    b5 = Byte.valueOf((byte) g5);
                }
                if (b5 != null) {
                    return b5.byteValue();
                }
                V(b6, "byte", str);
                throw new C2219h();
            } catch (IllegalArgumentException unused) {
                V(b6, "byte", str);
                throw new C2219h();
            }
        } else {
            throw z.e(-1, "Expected " + M.b(B.class).c() + ", but had " + M.b(F4.getClass()).c() + " as the serialized body of " + "byte" + " at element: " + U(str), F4.toString());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: J */
    public char j(String str) {
        t.e(str, "tag");
        h F4 = F(str);
        if (F4 instanceof B) {
            B b5 = (B) F4;
            try {
                return s.b1(b5.c());
            } catch (IllegalArgumentException unused) {
                V(b5, "char", str);
                throw new C2219h();
            }
        } else {
            throw z.e(-1, "Expected " + M.b(B.class).c() + ", but had " + M.b(F4.getClass()).c() + " as the serialized body of " + "char" + " at element: " + U(str), F4.toString());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: K */
    public double k(String str) {
        t.e(str, "tag");
        h F4 = F(str);
        if (F4 instanceof B) {
            B b5 = (B) F4;
            try {
                double e5 = M3.i.e(b5);
                if (a().c().b()) {
                    return e5;
                }
                if (!Double.isInfinite(e5) && !Double.isNaN(e5)) {
                    return e5;
                }
                throw z.a(Double.valueOf(e5), str, G().toString());
            } catch (IllegalArgumentException unused) {
                V(b5, "double", str);
                throw new C2219h();
            }
        } else {
            throw z.e(-1, "Expected " + M.b(B.class).c() + ", but had " + M.b(F4.getClass()).c() + " as the serialized body of " + "double" + " at element: " + U(str), F4.toString());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: L */
    public int l(String str, J3.f fVar) {
        t.e(str, "tag");
        t.e(fVar, "enumDescriptor");
        C2128b a5 = a();
        h D4 = F(str);
        String a6 = fVar.a();
        if (D4 instanceof B) {
            return B.k(fVar, a5, ((B) D4).c(), (String) null, 4, (Object) null);
        }
        throw z.e(-1, "Expected " + M.b(B.class).c() + ", but had " + M.b(D4.getClass()).c() + " as the serialized body of " + a6 + " at element: " + U(str), D4.toString());
    }

    /* access modifiers changed from: protected */
    /* renamed from: M */
    public float m(String str) {
        t.e(str, "tag");
        h F4 = F(str);
        if (F4 instanceof B) {
            B b5 = (B) F4;
            try {
                float f5 = M3.i.f(b5);
                if (a().c().b()) {
                    return f5;
                }
                if (!Float.isInfinite(f5) && !Float.isNaN(f5)) {
                    return f5;
                }
                throw z.a(Float.valueOf(f5), str, G().toString());
            } catch (IllegalArgumentException unused) {
                V(b5, TypedValues.Custom.S_FLOAT, str);
                throw new C2219h();
            }
        } else {
            throw z.e(-1, "Expected " + M.b(B.class).c() + ", but had " + M.b(F4.getClass()).c() + " as the serialized body of " + TypedValues.Custom.S_FLOAT + " at element: " + U(str), F4.toString());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: N */
    public e n(String str, J3.f fVar) {
        t.e(str, "tag");
        t.e(fVar, "inlineDescriptor");
        if (!N.b(fVar)) {
            return super.n(str, fVar);
        }
        C2128b a5 = a();
        h D4 = F(str);
        String a6 = fVar.a();
        if (D4 instanceof B) {
            return new C2150u(P.a(a5, ((B) D4).c()), a());
        }
        throw z.e(-1, "Expected " + M.b(B.class).c() + ", but had " + M.b(D4.getClass()).c() + " as the serialized body of " + a6 + " at element: " + U(str), D4.toString());
    }

    /* access modifiers changed from: protected */
    /* renamed from: O */
    public int o(String str) {
        t.e(str, "tag");
        h F4 = F(str);
        if (F4 instanceof B) {
            B b5 = (B) F4;
            try {
                return M3.i.g(b5);
            } catch (IllegalArgumentException unused) {
                V(b5, "int", str);
                throw new C2219h();
            }
        } else {
            throw z.e(-1, "Expected " + M.b(B.class).c() + ", but had " + M.b(F4.getClass()).c() + " as the serialized body of " + "int" + " at element: " + U(str), F4.toString());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: P */
    public long p(String str) {
        t.e(str, "tag");
        h F4 = F(str);
        if (F4 instanceof B) {
            B b5 = (B) F4;
            try {
                return M3.i.j(b5);
            } catch (IllegalArgumentException unused) {
                V(b5, "long", str);
                throw new C2219h();
            }
        } else {
            throw z.e(-1, "Expected " + M.b(B.class).c() + ", but had " + M.b(F4.getClass()).c() + " as the serialized body of " + "long" + " at element: " + U(str), F4.toString());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: Q */
    public short q(String str) {
        Short sh;
        t.e(str, "tag");
        h F4 = F(str);
        if (F4 instanceof B) {
            B b5 = (B) F4;
            try {
                int g5 = M3.i.g(b5);
                if (-32768 > g5 || g5 > 32767) {
                    sh = null;
                } else {
                    sh = Short.valueOf((short) g5);
                }
                if (sh != null) {
                    return sh.shortValue();
                }
                V(b5, "short", str);
                throw new C2219h();
            } catch (IllegalArgumentException unused) {
                V(b5, "short", str);
                throw new C2219h();
            }
        } else {
            throw z.e(-1, "Expected " + M.b(B.class).c() + ", but had " + M.b(F4.getClass()).c() + " as the serialized body of " + "short" + " at element: " + U(str), F4.toString());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: R */
    public String r(String str) {
        t.e(str, "tag");
        h F4 = F(str);
        if (F4 instanceof B) {
            B b5 = (B) F4;
            if (b5 instanceof M3.s) {
                M3.s sVar = (M3.s) b5;
                if (sVar.g() || a().c().q()) {
                    return sVar.c();
                }
                throw z.e(-1, "String literal for key '" + str + "' should be quoted at element: " + U(str) + ".\nUse 'isLenient = true' in 'Json {}' builder to accept non-compliant JSON.", G().toString());
            }
            throw z.e(-1, "Expected string value for a non-null key '" + str + "', got null literal instead at element: " + U(str), G().toString());
        }
        throw z.e(-1, "Expected " + M.b(B.class).c() + ", but had " + M.b(F4.getClass()).c() + " as the serialized body of " + TypedValues.Custom.S_STRING + " at element: " + U(str), F4.toString());
    }

    /* access modifiers changed from: protected */
    public final String S() {
        return this.f18781e;
    }

    public abstract h T();

    public final String U(String str) {
        t.e(str, "currentTag");
        return C() + '.' + str;
    }

    public C2128b a() {
        return this.f18779c;
    }

    public h b() {
        return G();
    }

    public c beginStructure(J3.f fVar) {
        t.e(fVar, "descriptor");
        h G4 = G();
        n kind = fVar.getKind();
        Class<C2129c> cls = C2129c.class;
        if (t.a(kind, o.b.f18391a) || (kind instanceof d)) {
            h hVar = G4;
            C2128b a5 = a();
            String a6 = fVar.a();
            if (hVar instanceof C2129c) {
                return new H(a5, (C2129c) hVar);
            }
            throw z.e(-1, "Expected " + M.b(cls).c() + ", but had " + M.b(hVar.getClass()).c() + " as the serialized body of " + a6 + " at element: " + C(), hVar.toString());
        }
        Class<z> cls2 = z.class;
        if (t.a(kind, o.c.f18392a)) {
            C2128b a7 = a();
            J3.f a8 = V.a(fVar.h(0), a7.d());
            n kind2 = a8.getKind();
            if ((kind2 instanceof J3.e) || t.a(kind2, n.b.f18389a)) {
                C2128b a9 = a();
                String a10 = fVar.a();
                if (G4 instanceof z) {
                    return new I(a9, (z) G4);
                }
                throw z.e(-1, "Expected " + M.b(cls2).c() + ", but had " + M.b(G4.getClass()).c() + " as the serialized body of " + a10 + " at element: " + C(), G4.toString());
            } else if (a7.c().c()) {
                C2128b a11 = a();
                String a12 = fVar.a();
                if (G4 instanceof C2129c) {
                    return new H(a11, (C2129c) G4);
                }
                throw z.e(-1, "Expected " + M.b(cls).c() + ", but had " + M.b(G4.getClass()).c() + " as the serialized body of " + a12 + " at element: " + C(), G4.toString());
            } else {
                throw z.c(a8);
            }
        } else {
            h hVar2 = G4;
            C2128b a13 = a();
            String a14 = fVar.a();
            if (hVar2 instanceof z) {
                return new G(a13, (z) hVar2, this.f18781e, (J3.f) null, 8, (C2633k) null);
            }
            throw z.e(-1, "Expected " + M.b(cls2).c() + ", but had " + M.b(hVar2.getClass()).c() + " as the serialized body of " + a14 + " at element: " + C(), hVar2.toString());
        }
    }

    public e decodeInline(J3.f fVar) {
        t.e(fVar, "descriptor");
        if (s() != null) {
            return super.decodeInline(fVar);
        }
        return new D(a(), T(), this.f18781e).decodeInline(fVar);
    }

    public boolean decodeNotNullMark() {
        return !(G() instanceof w);
    }

    public Object decodeSerializableValue(a aVar) {
        String str;
        B h5;
        t.e(aVar, "deserializer");
        if (!(aVar instanceof C2078b) || a().c().p()) {
            return aVar.deserialize(this);
        }
        C2078b bVar = (C2078b) aVar;
        String c5 = K.c(bVar.getDescriptor(), a());
        h b5 = b();
        String a5 = bVar.getDescriptor().a();
        if (b5 instanceof z) {
            z zVar = (z) b5;
            h hVar = (h) zVar.get(c5);
            if (hVar == null || (h5 = M3.i.h(hVar)) == null) {
                str = null;
            } else {
                str = M3.i.d(h5);
            }
            try {
                a a6 = H3.h.a((C2078b) aVar, this, str);
                t.c(a6, "null cannot be cast to non-null type kotlinx.serialization.DeserializationStrategy<T of kotlinx.serialization.json.internal.PolymorphicKt.decodeSerializableValuePolymorphic>");
                return T.a(a(), c5, zVar, a6);
            } catch (k e5) {
                String message = e5.getMessage();
                t.b(message);
                throw z.e(-1, message, zVar.toString());
            }
        } else {
            throw z.e(-1, "Expected " + M.b(z.class).c() + ", but had " + M.b(b5.getClass()).c() + " as the serialized body of " + a5 + " at element: " + C(), b5.toString());
        }
    }

    public void endStructure(J3.f fVar) {
        t.e(fVar, "descriptor");
    }

    public O3.d getSerializersModule() {
        return a().d();
    }

    /* access modifiers changed from: protected */
    public String y(String str, String str2) {
        t.e(str, "parentName");
        t.e(str2, "childName");
        return str2;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ C2133c(C2128b bVar, h hVar, String str, int i5, C2633k kVar) {
        this(bVar, hVar, (i5 & 4) != 0 ? null : str, (C2633k) null);
    }

    private C2133c(C2128b bVar, h hVar, String str) {
        this.f18779c = bVar;
        this.f18780d = hVar;
        this.f18781e = str;
        this.f18782f = a().c();
    }
}
