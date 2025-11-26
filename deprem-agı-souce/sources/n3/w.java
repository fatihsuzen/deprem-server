package N3;

import J3.f;
import L3.E;
import k3.p;
import kotlin.jvm.internal.C2639q;
import kotlin.jvm.internal.t;

public final class w {

    /* renamed from: a  reason: collision with root package name */
    private final E f18799a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f18800b;

    /* synthetic */ class a extends C2639q implements p {
        a(Object obj) {
            super(2, obj, w.class, "readIfAbsent", "readIfAbsent(Lkotlinx/serialization/descriptors/SerialDescriptor;I)Z", 0);
        }

        public final Boolean g(f fVar, int i5) {
            t.e(fVar, "p0");
            return Boolean.valueOf(((w) this.receiver).e(fVar, i5));
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            return g((f) obj, ((Number) obj2).intValue());
        }
    }

    public w(f fVar) {
        t.e(fVar, "descriptor");
        this.f18799a = new E(fVar, new a(this));
    }

    /* access modifiers changed from: private */
    public final boolean e(f fVar, int i5) {
        boolean z4;
        if (fVar.i(i5) || !fVar.h(i5).c()) {
            z4 = false;
        } else {
            z4 = true;
        }
        this.f18800b = z4;
        return z4;
    }

    public final boolean b() {
        return this.f18800b;
    }

    public final void c(int i5) {
        this.f18799a.a(i5);
    }

    public final int d() {
        return this.f18799a.d();
    }
}
