package Y3;

import U3.e;
import U3.h;
import U3.o;
import U3.s;
import U3.x;
import U3.z;
import X3.c;
import java.util.List;

public final class g implements s.a {

    /* renamed from: a  reason: collision with root package name */
    private final List f20204a;

    /* renamed from: b  reason: collision with root package name */
    private final X3.g f20205b;

    /* renamed from: c  reason: collision with root package name */
    private final c f20206c;

    /* renamed from: d  reason: collision with root package name */
    private final c f20207d;

    /* renamed from: e  reason: collision with root package name */
    private final int f20208e;

    /* renamed from: f  reason: collision with root package name */
    private final x f20209f;

    /* renamed from: g  reason: collision with root package name */
    private final e f20210g;

    /* renamed from: h  reason: collision with root package name */
    private final o f20211h;

    /* renamed from: i  reason: collision with root package name */
    private final int f20212i;

    /* renamed from: j  reason: collision with root package name */
    private final int f20213j;

    /* renamed from: k  reason: collision with root package name */
    private final int f20214k;

    /* renamed from: l  reason: collision with root package name */
    private int f20215l;

    public g(List list, X3.g gVar, c cVar, c cVar2, int i5, x xVar, e eVar, o oVar, int i6, int i7, int i8) {
        this.f20204a = list;
        this.f20207d = cVar2;
        this.f20205b = gVar;
        this.f20206c = cVar;
        this.f20208e = i5;
        this.f20209f = xVar;
        this.f20210g = eVar;
        this.f20211h = oVar;
        this.f20212i = i6;
        this.f20213j = i7;
        this.f20214k = i8;
    }

    public z a(x xVar) {
        return f(xVar, this.f20205b, this.f20206c, this.f20207d);
    }

    public e b() {
        return this.f20210g;
    }

    public h c() {
        return this.f20207d;
    }

    public int connectTimeoutMillis() {
        return this.f20212i;
    }

    public o d() {
        return this.f20211h;
    }

    public c e() {
        return this.f20206c;
    }

    public z f(x xVar, X3.g gVar, c cVar, c cVar2) {
        if (this.f20208e < this.f20204a.size()) {
            this.f20215l++;
            if (this.f20206c != null && !this.f20207d.r(xVar.i())) {
                throw new IllegalStateException("network interceptor " + this.f20204a.get(this.f20208e - 1) + " must retain the same host and port");
            } else if (this.f20206c == null || this.f20215l <= 1) {
                g gVar2 = new g(this.f20204a, gVar, cVar, cVar2, this.f20208e + 1, xVar, this.f20210g, this.f20211h, this.f20212i, this.f20213j, this.f20214k);
                s sVar = (s) this.f20204a.get(this.f20208e);
                z a5 = sVar.a(gVar2);
                if (cVar != null && this.f20208e + 1 < this.f20204a.size() && gVar2.f20215l != 1) {
                    throw new IllegalStateException("network interceptor " + sVar + " must call proceed() exactly once");
                } else if (a5 == null) {
                    throw new NullPointerException("interceptor " + sVar + " returned null");
                } else if (a5.a() != null) {
                    return a5;
                } else {
                    throw new IllegalStateException("interceptor " + sVar + " returned a response with no body");
                }
            } else {
                throw new IllegalStateException("network interceptor " + this.f20204a.get(this.f20208e - 1) + " must call proceed() exactly once");
            }
        } else {
            throw new AssertionError();
        }
    }

    public X3.g g() {
        return this.f20205b;
    }

    public int readTimeoutMillis() {
        return this.f20213j;
    }

    public x request() {
        return this.f20209f;
    }

    public int writeTimeoutMillis() {
        return this.f20214k;
    }
}
