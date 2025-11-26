package H3;

import J3.a;
import J3.b;
import J3.d;
import J3.f;
import J3.n;
import L3.C2078b;
import W2.C2223l;
import W2.J;
import W2.m;
import W2.p;
import X2.C2250q;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import java.util.List;
import k3.l;
import kotlin.jvm.internal.Q;
import kotlin.jvm.internal.t;
import r3.C2733c;

public final class g extends C2078b {

    /* renamed from: a  reason: collision with root package name */
    private final C2733c f18191a;

    /* renamed from: b  reason: collision with root package name */
    private List f18192b = C2250q.g();

    /* renamed from: c  reason: collision with root package name */
    private final C2223l f18193c = m.a(p.PUBLICATION, new e(this));

    public g(C2733c cVar) {
        t.e(cVar, "baseClass");
        this.f18191a = cVar;
    }

    /* access modifiers changed from: private */
    public static final f h(g gVar) {
        return b.c(J3.m.h("kotlinx.serialization.Polymorphic", d.a.f18357a, new f[0], new f(gVar)), gVar.e());
    }

    /* access modifiers changed from: private */
    public static final J i(g gVar, a aVar) {
        t.e(aVar, "$this$buildSerialDescriptor");
        a.b(aVar, ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, I3.a.H(Q.f24695a).getDescriptor(), (List) null, false, 12, (Object) null);
        a.b(aVar, "value", J3.m.i("kotlinx.serialization.Polymorphic<" + gVar.e().c() + '>', n.a.f18388a, new f[0], (l) null, 8, (Object) null), (List) null, false, 12, (Object) null);
        aVar.h(gVar.f18192b);
        return J.f19942a;
    }

    public C2733c e() {
        return this.f18191a;
    }

    public f getDescriptor() {
        return (f) this.f18193c.getValue();
    }

    public String toString() {
        return "kotlinx.serialization.PolymorphicSerializer(baseClass: " + e() + ')';
    }
}
