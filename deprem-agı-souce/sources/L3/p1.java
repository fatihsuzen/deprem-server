package L3;

import H3.b;
import K3.e;
import K3.f;
import W2.J;
import kotlin.jvm.internal.t;

public final class p1 implements b {

    /* renamed from: b  reason: collision with root package name */
    public static final p1 f18571b = new p1();

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ C2118v0 f18572a = new C2118v0("kotlin.Unit", J.f19942a);

    private p1() {
    }

    public void a(e eVar) {
        t.e(eVar, "decoder");
        this.f18572a.deserialize(eVar);
    }

    /* renamed from: b */
    public void serialize(f fVar, J j5) {
        t.e(fVar, "encoder");
        t.e(j5, "value");
        this.f18572a.serialize(fVar, j5);
    }

    public /* bridge */ /* synthetic */ Object deserialize(e eVar) {
        a(eVar);
        return J.f19942a;
    }

    public J3.f getDescriptor() {
        return this.f18572a.getDescriptor();
    }
}
