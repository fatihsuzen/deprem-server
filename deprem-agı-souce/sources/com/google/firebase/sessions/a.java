package com.google.firebase.sessions;

import S0.e;
import android.content.Context;
import b1.C1025j;
import b1.C1028m;
import b1.C1036v;
import b1.E;
import b1.J;
import b1.P;
import b1.S;
import b1.V;
import b1.W;
import b1.Y;
import b3.C2312i;
import com.google.firebase.sessions.b;
import d1.C1624a;
import d1.C1625b;
import d1.d;
import e1.C1629c;
import e1.C1632f;
import e1.g;
import e1.k;
import e1.n;
import o0.f;

public abstract class a {

    private static final class b implements b.a {

        /* renamed from: a  reason: collision with root package name */
        private Context f7486a;

        /* renamed from: b  reason: collision with root package name */
        private C2312i f7487b;

        /* renamed from: c  reason: collision with root package name */
        private C2312i f7488c;

        /* renamed from: d  reason: collision with root package name */
        private f f7489d;

        /* renamed from: e  reason: collision with root package name */
        private e f7490e;

        /* renamed from: f  reason: collision with root package name */
        private R0.b f7491f;

        private b() {
        }

        public b build() {
            d.a(this.f7486a, Context.class);
            Class<C2312i> cls = C2312i.class;
            d.a(this.f7487b, cls);
            d.a(this.f7488c, cls);
            d.a(this.f7489d, f.class);
            d.a(this.f7490e, e.class);
            d.a(this.f7491f, R0.b.class);
            return new c(this.f7486a, this.f7487b, this.f7488c, this.f7489d, this.f7490e, this.f7491f);
        }

        /* renamed from: g */
        public b e(Context context) {
            this.f7486a = (Context) d.b(context);
            return this;
        }

        /* renamed from: h */
        public b c(C2312i iVar) {
            this.f7487b = (C2312i) d.b(iVar);
            return this;
        }

        /* renamed from: i */
        public b a(C2312i iVar) {
            this.f7488c = (C2312i) d.b(iVar);
            return this;
        }

        /* renamed from: j */
        public b d(f fVar) {
            this.f7489d = (f) d.b(fVar);
            return this;
        }

        /* renamed from: k */
        public b b(e eVar) {
            this.f7490e = (e) d.b(eVar);
            return this;
        }

        /* renamed from: l */
        public b f(R0.b bVar) {
            this.f7491f = (R0.b) d.b(bVar);
            return this;
        }
    }

    private static final class c implements b {

        /* renamed from: a  reason: collision with root package name */
        private final c f7492a;

        /* renamed from: b  reason: collision with root package name */
        private d1.e f7493b;

        /* renamed from: c  reason: collision with root package name */
        private d1.e f7494c;

        /* renamed from: d  reason: collision with root package name */
        private d1.e f7495d;

        /* renamed from: e  reason: collision with root package name */
        private d1.e f7496e;

        /* renamed from: f  reason: collision with root package name */
        private d1.e f7497f;

        /* renamed from: g  reason: collision with root package name */
        private d1.e f7498g;

        /* renamed from: h  reason: collision with root package name */
        private d1.e f7499h;

        /* renamed from: i  reason: collision with root package name */
        private d1.e f7500i;

        /* renamed from: j  reason: collision with root package name */
        private d1.e f7501j;

        /* renamed from: k  reason: collision with root package name */
        private d1.e f7502k;

        /* renamed from: l  reason: collision with root package name */
        private d1.e f7503l;

        /* renamed from: m  reason: collision with root package name */
        private d1.e f7504m;

        /* renamed from: n  reason: collision with root package name */
        private d1.e f7505n;

        /* renamed from: o  reason: collision with root package name */
        private d1.e f7506o;

        /* renamed from: p  reason: collision with root package name */
        private d1.e f7507p;

        /* renamed from: q  reason: collision with root package name */
        private d1.e f7508q;

        /* renamed from: r  reason: collision with root package name */
        private d1.e f7509r;

        /* renamed from: s  reason: collision with root package name */
        private d1.e f7510s;

        /* renamed from: t  reason: collision with root package name */
        private d1.e f7511t;

        /* renamed from: u  reason: collision with root package name */
        private d1.e f7512u;

        /* renamed from: v  reason: collision with root package name */
        private d1.e f7513v;

        /* renamed from: w  reason: collision with root package name */
        private d1.e f7514w;

        /* renamed from: x  reason: collision with root package name */
        private d1.e f7515x;

        /* renamed from: y  reason: collision with root package name */
        private d1.e f7516y;

        private void c(Context context, C2312i iVar, C2312i iVar2, f fVar, e eVar, R0.b bVar) {
            this.f7493b = d1.c.a(fVar);
            C1625b a5 = d1.c.a(context);
            this.f7494c = a5;
            this.f7495d = C1624a.a(C1629c.a(a5));
            this.f7496e = C1624a.a(f.a());
            this.f7497f = d1.c.a(eVar);
            this.f7498g = C1624a.a(c.b(this.f7493b));
            C1625b a6 = d1.c.a(iVar2);
            this.f7499h = a6;
            this.f7500i = C1624a.a(C1632f.a(this.f7498g, a6));
            this.f7501j = d1.c.a(iVar);
            d1.e a7 = C1624a.a(d.a(this.f7494c, this.f7499h));
            this.f7502k = a7;
            d1.e a8 = C1624a.a(n.a(this.f7501j, this.f7496e, a7));
            this.f7503l = a8;
            d1.e a9 = C1624a.a(g.a(this.f7496e, this.f7497f, this.f7498g, this.f7500i, a8));
            this.f7504m = a9;
            this.f7505n = C1624a.a(k.a(this.f7495d, a9));
            d1.e a10 = C1624a.a(g.a());
            this.f7506o = a10;
            this.f7507p = C1624a.a(S.a(this.f7496e, a10));
            C1625b a11 = d1.c.a(bVar);
            this.f7508q = a11;
            d1.e a12 = C1624a.a(C1025j.a(a11));
            this.f7509r = a12;
            this.f7510s = C1624a.a(P.a(this.f7493b, this.f7497f, this.f7505n, a12, this.f7501j));
            d1.e a13 = C1624a.a(J.a(this.f7507p));
            this.f7511t = a13;
            this.f7512u = C1624a.a(e.a(this.f7494c, this.f7499h, a13));
            d1.e a14 = C1624a.a(E.a(this.f7494c, this.f7506o));
            this.f7513v = a14;
            d1.e a15 = C1624a.a(Y.a(this.f7505n, this.f7507p, this.f7510s, this.f7496e, this.f7512u, a14, this.f7501j));
            this.f7514w = a15;
            d1.e a16 = C1624a.a(V.a(a15));
            this.f7515x = a16;
            this.f7516y = C1624a.a(C1036v.a(this.f7493b, this.f7505n, this.f7501j, a16));
        }

        public C1028m a() {
            return (C1028m) this.f7516y.get();
        }

        public W b() {
            return (W) this.f7514w.get();
        }

        private c(Context context, C2312i iVar, C2312i iVar2, f fVar, e eVar, R0.b bVar) {
            this.f7492a = this;
            c(context, iVar, iVar2, fVar, eVar, bVar);
        }
    }

    public static b.a a() {
        return new b();
    }
}
