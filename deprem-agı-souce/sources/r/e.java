package r;

import B.C0630c;
import B.C0631d;
import android.content.Context;
import r.v;
import s.j;
import s.l;
import t.C1875a;
import t.C1876b;
import t.C1877c;
import t.C1878d;
import x.C1902d;
import x.g;
import x.i;
import y.s;
import y.w;
import z.C1952d;
import z.C1955g;
import z.C1956h;
import z.C1957i;
import z.C1958j;
import z.N;
import z.X;

abstract class e {

    private static final class b implements v.a {

        /* renamed from: a  reason: collision with root package name */
        private Context f16271a;

        private b() {
        }

        /* renamed from: b */
        public b a(Context context) {
            this.f16271a = (Context) C1878d.b(context);
            return this;
        }

        public v build() {
            C1878d.a(this.f16271a, Context.class);
            return new c(this.f16271a);
        }
    }

    private static final class c extends v {

        /* renamed from: a  reason: collision with root package name */
        private final c f16272a;

        /* renamed from: b  reason: collision with root package name */
        private T2.a f16273b;

        /* renamed from: c  reason: collision with root package name */
        private T2.a f16274c;

        /* renamed from: d  reason: collision with root package name */
        private T2.a f16275d;

        /* renamed from: e  reason: collision with root package name */
        private T2.a f16276e;

        /* renamed from: f  reason: collision with root package name */
        private T2.a f16277f;

        /* renamed from: g  reason: collision with root package name */
        private T2.a f16278g;

        /* renamed from: h  reason: collision with root package name */
        private T2.a f16279h;

        /* renamed from: i  reason: collision with root package name */
        private T2.a f16280i;

        /* renamed from: j  reason: collision with root package name */
        private T2.a f16281j;

        /* renamed from: k  reason: collision with root package name */
        private T2.a f16282k;

        /* renamed from: l  reason: collision with root package name */
        private T2.a f16283l;

        /* renamed from: m  reason: collision with root package name */
        private T2.a f16284m;

        /* renamed from: n  reason: collision with root package name */
        private T2.a f16285n;

        private void l(Context context) {
            this.f16273b = C1875a.a(k.a());
            C1876b a5 = C1877c.a(context);
            this.f16274c = a5;
            j a6 = j.a(a5, C0630c.a(), C0631d.a());
            this.f16275d = a6;
            this.f16276e = C1875a.a(l.a(this.f16274c, a6));
            this.f16277f = X.a(this.f16274c, C1955g.a(), C1957i.a());
            this.f16278g = C1875a.a(C1956h.a(this.f16274c));
            this.f16279h = C1875a.a(N.a(C0630c.a(), C0631d.a(), C1958j.a(), this.f16277f, this.f16278g));
            g b5 = g.b(C0630c.a());
            this.f16280i = b5;
            i a7 = i.a(this.f16274c, this.f16279h, b5, C0631d.a());
            this.f16281j = a7;
            T2.a aVar = this.f16273b;
            T2.a aVar2 = this.f16276e;
            T2.a aVar3 = this.f16279h;
            this.f16282k = C1902d.a(aVar, aVar2, a7, aVar3, aVar3);
            T2.a aVar4 = this.f16274c;
            T2.a aVar5 = this.f16276e;
            T2.a aVar6 = this.f16279h;
            this.f16283l = s.a(aVar4, aVar5, aVar6, this.f16281j, this.f16273b, aVar6, C0630c.a(), C0631d.a(), this.f16279h);
            T2.a aVar7 = this.f16273b;
            T2.a aVar8 = this.f16279h;
            this.f16284m = w.a(aVar7, aVar8, this.f16281j, aVar8);
            this.f16285n = C1875a.a(w.a(C0630c.a(), C0631d.a(), this.f16282k, this.f16283l, this.f16284m));
        }

        /* access modifiers changed from: package-private */
        public C1952d a() {
            return (C1952d) this.f16279h.get();
        }

        /* access modifiers changed from: package-private */
        public u d() {
            return (u) this.f16285n.get();
        }

        private c(Context context) {
            this.f16272a = this;
            l(context);
        }
    }

    public static v.a a() {
        return new b();
    }
}
