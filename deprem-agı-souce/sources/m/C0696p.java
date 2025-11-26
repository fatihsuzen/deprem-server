package M;

import K.C0657d;
import L.C0668a;
import N.C0722p;
import k0.C1699m;

/* renamed from: M.p  reason: case insensitive filesystem */
public abstract class C0696p {

    /* renamed from: a  reason: collision with root package name */
    private final C0657d[] f2925a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f2926b;

    /* renamed from: c  reason: collision with root package name */
    private final int f2927c;

    /* renamed from: M.p$a */
    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public C0692l f2928a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f2929b = true;

        /* renamed from: c  reason: collision with root package name */
        private C0657d[] f2930c;

        /* renamed from: d  reason: collision with root package name */
        private int f2931d = 0;

        /* synthetic */ a(T t5) {
        }

        public C0696p a() {
            boolean z4;
            if (this.f2928a != null) {
                z4 = true;
            } else {
                z4 = false;
            }
            C0722p.b(z4, "execute parameter required");
            return new S(this, this.f2930c, this.f2929b, this.f2931d);
        }

        public a b(C0692l lVar) {
            this.f2928a = lVar;
            return this;
        }

        public a c(boolean z4) {
            this.f2929b = z4;
            return this;
        }

        public a d(C0657d... dVarArr) {
            this.f2930c = dVarArr;
            return this;
        }
    }

    protected C0696p(C0657d[] dVarArr, boolean z4, int i5) {
        this.f2925a = dVarArr;
        boolean z5 = false;
        if (dVarArr != null && z4) {
            z5 = true;
        }
        this.f2926b = z5;
        this.f2927c = i5;
    }

    public static a a() {
        return new a((T) null);
    }

    /* access modifiers changed from: protected */
    public abstract void b(C0668a.b bVar, C1699m mVar);

    public boolean c() {
        return this.f2926b;
    }

    public final int d() {
        return this.f2927c;
    }

    public final C0657d[] e() {
        return this.f2925a;
    }
}
