package Y1;

import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class e {

    /* renamed from: c  reason: collision with root package name */
    public static final a f20136c = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final int f20137a;

    /* renamed from: b  reason: collision with root package name */
    private final long f20138b = System.currentTimeMillis();

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final boolean a(e eVar, e eVar2) {
            t.e(eVar2, "newEvent");
            if (eVar != null && eVar.a() == eVar2.a() && eVar2.b() - eVar.b() < 600) {
                return true;
            }
            return false;
        }

        private a() {
        }
    }

    public e(int i5) {
        this.f20137a = i5;
    }

    public final int a() {
        return this.f20137a;
    }

    public final long b() {
        return this.f20138b;
    }
}
