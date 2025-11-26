package U3;

import U3.q;
import java.io.Closeable;

public final class z implements Closeable {

    /* renamed from: a  reason: collision with root package name */
    final x f19663a;

    /* renamed from: b  reason: collision with root package name */
    final v f19664b;

    /* renamed from: c  reason: collision with root package name */
    final int f19665c;

    /* renamed from: d  reason: collision with root package name */
    final String f19666d;

    /* renamed from: e  reason: collision with root package name */
    final p f19667e;

    /* renamed from: f  reason: collision with root package name */
    final q f19668f;

    /* renamed from: g  reason: collision with root package name */
    final A f19669g;

    /* renamed from: h  reason: collision with root package name */
    final z f19670h;

    /* renamed from: i  reason: collision with root package name */
    final z f19671i;

    /* renamed from: j  reason: collision with root package name */
    final z f19672j;

    /* renamed from: k  reason: collision with root package name */
    final long f19673k;

    /* renamed from: l  reason: collision with root package name */
    final long f19674l;

    /* renamed from: m  reason: collision with root package name */
    private volatile d f19675m;

    z(a aVar) {
        this.f19663a = aVar.f19676a;
        this.f19664b = aVar.f19677b;
        this.f19665c = aVar.f19678c;
        this.f19666d = aVar.f19679d;
        this.f19667e = aVar.f19680e;
        this.f19668f = aVar.f19681f.d();
        this.f19669g = aVar.f19682g;
        this.f19670h = aVar.f19683h;
        this.f19671i = aVar.f19684i;
        this.f19672j = aVar.f19685j;
        this.f19673k = aVar.f19686k;
        this.f19674l = aVar.f19687l;
    }

    public x A() {
        return this.f19663a;
    }

    public long B() {
        return this.f19673k;
    }

    public A a() {
        return this.f19669g;
    }

    public void close() {
        A a5 = this.f19669g;
        if (a5 != null) {
            a5.close();
            return;
        }
        throw new IllegalStateException("response is not eligible for a body and must not be closed");
    }

    public d d() {
        d dVar = this.f19675m;
        if (dVar != null) {
            return dVar;
        }
        d l5 = d.l(this.f19668f);
        this.f19675m = l5;
        return l5;
    }

    public z l() {
        return this.f19671i;
    }

    public int m() {
        return this.f19665c;
    }

    public p n() {
        return this.f19667e;
    }

    public String o(String str) {
        return p(str, (String) null);
    }

    public String p(String str, String str2) {
        String a5 = this.f19668f.a(str);
        if (a5 != null) {
            return a5;
        }
        return str2;
    }

    public q q() {
        return this.f19668f;
    }

    public boolean s() {
        int i5 = this.f19665c;
        if (i5 < 200 || i5 >= 300) {
            return false;
        }
        return true;
    }

    public String t() {
        return this.f19666d;
    }

    public String toString() {
        return "Response{protocol=" + this.f19664b + ", code=" + this.f19665c + ", message=" + this.f19666d + ", url=" + this.f19663a.i() + '}';
    }

    public z u() {
        return this.f19670h;
    }

    public a v() {
        return new a(this);
    }

    public z x() {
        return this.f19672j;
    }

    public v y() {
        return this.f19664b;
    }

    public long z() {
        return this.f19674l;
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        x f19676a;

        /* renamed from: b  reason: collision with root package name */
        v f19677b;

        /* renamed from: c  reason: collision with root package name */
        int f19678c;

        /* renamed from: d  reason: collision with root package name */
        String f19679d;

        /* renamed from: e  reason: collision with root package name */
        p f19680e;

        /* renamed from: f  reason: collision with root package name */
        q.a f19681f;

        /* renamed from: g  reason: collision with root package name */
        A f19682g;

        /* renamed from: h  reason: collision with root package name */
        z f19683h;

        /* renamed from: i  reason: collision with root package name */
        z f19684i;

        /* renamed from: j  reason: collision with root package name */
        z f19685j;

        /* renamed from: k  reason: collision with root package name */
        long f19686k;

        /* renamed from: l  reason: collision with root package name */
        long f19687l;

        public a() {
            this.f19678c = -1;
            this.f19681f = new q.a();
        }

        private void e(z zVar) {
            if (zVar.f19669g != null) {
                throw new IllegalArgumentException("priorResponse.body != null");
            }
        }

        private void f(String str, z zVar) {
            if (zVar.f19669g != null) {
                throw new IllegalArgumentException(str + ".body != null");
            } else if (zVar.f19670h != null) {
                throw new IllegalArgumentException(str + ".networkResponse != null");
            } else if (zVar.f19671i != null) {
                throw new IllegalArgumentException(str + ".cacheResponse != null");
            } else if (zVar.f19672j != null) {
                throw new IllegalArgumentException(str + ".priorResponse != null");
            }
        }

        public a a(String str, String str2) {
            this.f19681f.a(str, str2);
            return this;
        }

        public a b(A a5) {
            this.f19682g = a5;
            return this;
        }

        public z c() {
            if (this.f19676a == null) {
                throw new IllegalStateException("request == null");
            } else if (this.f19677b == null) {
                throw new IllegalStateException("protocol == null");
            } else if (this.f19678c < 0) {
                throw new IllegalStateException("code < 0: " + this.f19678c);
            } else if (this.f19679d != null) {
                return new z(this);
            } else {
                throw new IllegalStateException("message == null");
            }
        }

        public a d(z zVar) {
            if (zVar != null) {
                f("cacheResponse", zVar);
            }
            this.f19684i = zVar;
            return this;
        }

        public a g(int i5) {
            this.f19678c = i5;
            return this;
        }

        public a h(p pVar) {
            this.f19680e = pVar;
            return this;
        }

        public a i(q qVar) {
            this.f19681f = qVar.d();
            return this;
        }

        public a j(String str) {
            this.f19679d = str;
            return this;
        }

        public a k(z zVar) {
            if (zVar != null) {
                f("networkResponse", zVar);
            }
            this.f19683h = zVar;
            return this;
        }

        public a l(z zVar) {
            if (zVar != null) {
                e(zVar);
            }
            this.f19685j = zVar;
            return this;
        }

        public a m(v vVar) {
            this.f19677b = vVar;
            return this;
        }

        public a n(long j5) {
            this.f19687l = j5;
            return this;
        }

        public a o(x xVar) {
            this.f19676a = xVar;
            return this;
        }

        public a p(long j5) {
            this.f19686k = j5;
            return this;
        }

        a(z zVar) {
            this.f19678c = -1;
            this.f19676a = zVar.f19663a;
            this.f19677b = zVar.f19664b;
            this.f19678c = zVar.f19665c;
            this.f19679d = zVar.f19666d;
            this.f19680e = zVar.f19667e;
            this.f19681f = zVar.f19668f.d();
            this.f19682g = zVar.f19669g;
            this.f19683h = zVar.f19670h;
            this.f19684i = zVar.f19671i;
            this.f19685j = zVar.f19672j;
            this.f19686k = zVar.f19673k;
            this.f19687l = zVar.f19674l;
        }
    }
}
