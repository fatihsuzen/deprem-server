package U3;

import U3.q;
import Y3.f;
import androidx.browser.trusted.sharing.ShareTarget;
import java.util.List;

public final class x {

    /* renamed from: a  reason: collision with root package name */
    final r f19649a;

    /* renamed from: b  reason: collision with root package name */
    final String f19650b;

    /* renamed from: c  reason: collision with root package name */
    final q f19651c;

    /* renamed from: d  reason: collision with root package name */
    final y f19652d;

    /* renamed from: e  reason: collision with root package name */
    final Object f19653e;

    /* renamed from: f  reason: collision with root package name */
    private volatile d f19654f;

    x(a aVar) {
        this.f19649a = aVar.f19655a;
        this.f19650b = aVar.f19656b;
        this.f19651c = aVar.f19657c.d();
        this.f19652d = aVar.f19658d;
        Object obj = aVar.f19659e;
        this.f19653e = obj == null ? this : obj;
    }

    public y a() {
        return this.f19652d;
    }

    public d b() {
        d dVar = this.f19654f;
        if (dVar != null) {
            return dVar;
        }
        d l5 = d.l(this.f19651c);
        this.f19654f = l5;
        return l5;
    }

    public String c(String str) {
        return this.f19651c.a(str);
    }

    public q d() {
        return this.f19651c;
    }

    public List e(String str) {
        return this.f19651c.g(str);
    }

    public boolean f() {
        return this.f19649a.l();
    }

    public String g() {
        return this.f19650b;
    }

    public a h() {
        return new a(this);
    }

    public r i() {
        return this.f19649a;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Request{method=");
        sb.append(this.f19650b);
        sb.append(", url=");
        sb.append(this.f19649a);
        sb.append(", tag=");
        Object obj = this.f19653e;
        if (obj == this) {
            obj = null;
        }
        sb.append(obj);
        sb.append('}');
        return sb.toString();
    }

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        r f19655a;

        /* renamed from: b  reason: collision with root package name */
        String f19656b;

        /* renamed from: c  reason: collision with root package name */
        q.a f19657c;

        /* renamed from: d  reason: collision with root package name */
        y f19658d;

        /* renamed from: e  reason: collision with root package name */
        Object f19659e;

        public a() {
            this.f19656b = ShareTarget.METHOD_GET;
            this.f19657c = new q.a();
        }

        public x a() {
            if (this.f19655a != null) {
                return new x(this);
            }
            throw new IllegalStateException("url == null");
        }

        public a b(d dVar) {
            String dVar2 = dVar.toString();
            if (dVar2.isEmpty()) {
                return f("Cache-Control");
            }
            return c("Cache-Control", dVar2);
        }

        public a c(String str, String str2) {
            this.f19657c.h(str, str2);
            return this;
        }

        public a d(q qVar) {
            this.f19657c = qVar.d();
            return this;
        }

        public a e(String str, y yVar) {
            if (str == null) {
                throw new NullPointerException("method == null");
            } else if (str.length() == 0) {
                throw new IllegalArgumentException("method.length() == 0");
            } else if (yVar != null && !f.b(str)) {
                throw new IllegalArgumentException("method " + str + " must not have a request body.");
            } else if (yVar != null || !f.e(str)) {
                this.f19656b = str;
                this.f19658d = yVar;
                return this;
            } else {
                throw new IllegalArgumentException("method " + str + " must have a request body.");
            }
        }

        public a f(String str) {
            this.f19657c.g(str);
            return this;
        }

        public a g(r rVar) {
            if (rVar != null) {
                this.f19655a = rVar;
                return this;
            }
            throw new NullPointerException("url == null");
        }

        public a h(String str) {
            String str2;
            if (str != null) {
                String str3 = str;
                if (str3.regionMatches(true, 0, "ws:", 0, 3)) {
                    str2 = "http:" + str3.substring(3);
                } else if (str3.regionMatches(true, 0, "wss:", 0, 4)) {
                    str2 = "https:" + str3.substring(4);
                } else {
                    str2 = str3;
                }
                r p5 = r.p(str2);
                if (p5 != null) {
                    return g(p5);
                }
                throw new IllegalArgumentException("unexpected url: " + str2);
            }
            throw new NullPointerException("url == null");
        }

        a(x xVar) {
            this.f19655a = xVar.f19649a;
            this.f19656b = xVar.f19650b;
            this.f19658d = xVar.f19652d;
            this.f19659e = xVar.f19653e;
            this.f19657c = xVar.f19651c.d();
        }
    }
}
