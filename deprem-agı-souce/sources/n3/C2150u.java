package N3;

import J3.f;
import K3.a;
import M3.C2128b;
import O3.d;
import W2.C2219h;
import kotlin.jvm.internal.t;
import t3.O;

/* renamed from: N3.u  reason: case insensitive filesystem */
public final class C2150u extends a {

    /* renamed from: a  reason: collision with root package name */
    private final C2131a f18797a;

    /* renamed from: b  reason: collision with root package name */
    private final d f18798b;

    public C2150u(C2131a aVar, C2128b bVar) {
        t.e(aVar, "lexer");
        t.e(bVar, "json");
        this.f18797a = aVar;
        this.f18798b = bVar.d();
    }

    public byte decodeByte() {
        C2131a aVar = this.f18797a;
        String q5 = aVar.q();
        try {
            return O.a(q5);
        } catch (IllegalArgumentException unused) {
            C2131a.x(aVar, "Failed to parse type '" + "UByte" + "' for input '" + q5 + '\'', 0, (String) null, 6, (Object) null);
            throw new C2219h();
        }
    }

    public int decodeElementIndex(f fVar) {
        t.e(fVar, "descriptor");
        throw new IllegalStateException("unsupported");
    }

    public int decodeInt() {
        C2131a aVar = this.f18797a;
        String q5 = aVar.q();
        try {
            return O.d(q5);
        } catch (IllegalArgumentException unused) {
            C2131a.x(aVar, "Failed to parse type '" + "UInt" + "' for input '" + q5 + '\'', 0, (String) null, 6, (Object) null);
            throw new C2219h();
        }
    }

    public long decodeLong() {
        C2131a aVar = this.f18797a;
        String q5 = aVar.q();
        try {
            return O.g(q5);
        } catch (IllegalArgumentException unused) {
            C2131a.x(aVar, "Failed to parse type '" + "ULong" + "' for input '" + q5 + '\'', 0, (String) null, 6, (Object) null);
            throw new C2219h();
        }
    }

    public short decodeShort() {
        C2131a aVar = this.f18797a;
        String q5 = aVar.q();
        try {
            return O.j(q5);
        } catch (IllegalArgumentException unused) {
            C2131a.x(aVar, "Failed to parse type '" + "UShort" + "' for input '" + q5 + '\'', 0, (String) null, 6, (Object) null);
            throw new C2219h();
        }
    }

    public d getSerializersModule() {
        return this.f18798b;
    }
}
