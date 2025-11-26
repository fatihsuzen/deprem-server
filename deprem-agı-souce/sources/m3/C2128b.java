package M3;

import H3.l;
import N3.C2148s;
import N3.E;
import N3.F;
import N3.L;
import N3.O;
import N3.P;
import N3.U;
import O3.d;
import O3.f;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

/* renamed from: M3.b  reason: case insensitive filesystem */
public abstract class C2128b {

    /* renamed from: d  reason: collision with root package name */
    public static final a f18665d = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final f f18666a;

    /* renamed from: b  reason: collision with root package name */
    private final d f18667b;

    /* renamed from: c  reason: collision with root package name */
    private final C2148s f18668c;

    /* renamed from: M3.b$a */
    public static final class a extends C2128b {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
            super(new f(false, false, false, false, false, false, (String) null, false, false, (String) null, false, false, (v) null, false, false, false, (C2127a) null, 131071, (C2633k) null), f.a(), (C2633k) null);
        }
    }

    public /* synthetic */ C2128b(f fVar, d dVar, C2633k kVar) {
        this(fVar, dVar);
    }

    public final Object a(H3.a aVar, String str) {
        t.e(aVar, "deserializer");
        t.e(str, TypedValues.Custom.S_STRING);
        O a5 = P.a(this, str);
        Object decodeSerializableValue = new L(this, U.OBJ, a5, aVar.getDescriptor(), (L.a) null).decodeSerializableValue(aVar);
        a5.v();
        return decodeSerializableValue;
    }

    public final String b(l lVar, Object obj) {
        t.e(lVar, "serializer");
        F f5 = new F();
        try {
            E.a(this, f5, lVar, obj);
            return f5.toString();
        } finally {
            f5.g();
        }
    }

    public final f c() {
        return this.f18666a;
    }

    public d d() {
        return this.f18667b;
    }

    public final C2148s e() {
        return this.f18668c;
    }

    private C2128b(f fVar, d dVar) {
        this.f18666a = fVar;
        this.f18667b = dVar;
        this.f18668c = new C2148s();
    }
}
