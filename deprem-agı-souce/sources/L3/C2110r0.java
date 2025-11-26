package L3;

import H3.b;
import H3.k;
import J3.f;
import K3.e;
import kotlin.jvm.internal.t;

/* renamed from: L3.r0  reason: case insensitive filesystem */
public final class C2110r0 implements b {

    /* renamed from: a  reason: collision with root package name */
    public static final C2110r0 f18581a = new C2110r0();

    /* renamed from: b  reason: collision with root package name */
    private static final f f18582b = C2109q0.f18574a;

    private C2110r0() {
    }

    /* renamed from: a */
    public Void deserialize(e eVar) {
        t.e(eVar, "decoder");
        throw new k("'kotlin.Nothing' does not have instances");
    }

    /* renamed from: b */
    public void serialize(K3.f fVar, Void voidR) {
        t.e(fVar, "encoder");
        t.e(voidR, "value");
        throw new k("'kotlin.Nothing' cannot be serialized");
    }

    public f getDescriptor() {
        return f18582b;
    }
}
