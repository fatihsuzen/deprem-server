package U3;

import U3.q;
import U3.x;
import U3.z;
import W3.c;
import W3.d;
import W3.f;
import Y3.e;
import Y3.k;
import androidx.browser.trusted.sharing.ShareTarget;
import e4.C2356e;
import e4.C2357f;
import e4.C2358g;
import e4.C2359h;
import e4.C2363l;
import e4.C2364m;
import e4.L;
import e4.X;
import e4.Z;
import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: U3.c  reason: case insensitive filesystem */
public final class C2204c implements Closeable, Flushable {

    /* renamed from: a  reason: collision with root package name */
    final f f19330a;

    /* renamed from: b  reason: collision with root package name */
    final W3.d f19331b;

    /* renamed from: c  reason: collision with root package name */
    int f19332c;

    /* renamed from: d  reason: collision with root package name */
    int f19333d;

    /* renamed from: e  reason: collision with root package name */
    private int f19334e;

    /* renamed from: f  reason: collision with root package name */
    private int f19335f;

    /* renamed from: g  reason: collision with root package name */
    private int f19336g;

    /* renamed from: U3.c$a */
    class a implements f {
        a() {
        }

        public void a(c cVar) {
            C2204c.this.q(cVar);
        }

        public z b(x xVar) {
            return C2204c.this.d(xVar);
        }

        public void c(z zVar, z zVar2) {
            C2204c.this.s(zVar, zVar2);
        }

        public W3.b d(z zVar) {
            return C2204c.this.m(zVar);
        }

        public void e(x xVar) {
            C2204c.this.o(xVar);
        }

        public void trackConditionalCacheHit() {
            C2204c.this.p();
        }
    }

    /* renamed from: U3.c$b */
    private final class b implements W3.b {

        /* renamed from: a  reason: collision with root package name */
        private final d.c f19338a;

        /* renamed from: b  reason: collision with root package name */
        private X f19339b;

        /* renamed from: c  reason: collision with root package name */
        private X f19340c;

        /* renamed from: d  reason: collision with root package name */
        boolean f19341d;

        /* renamed from: U3.c$b$a */
        class a extends C2363l {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2204c f19343b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ d.c f19344c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(X x4, C2204c cVar, d.c cVar2) {
                super(x4);
                this.f19343b = cVar;
                this.f19344c = cVar2;
            }

            public void close() {
                synchronized (C2204c.this) {
                    try {
                        b bVar = b.this;
                        if (!bVar.f19341d) {
                            bVar.f19341d = true;
                            C2204c.this.f19332c++;
                            super.close();
                            this.f19344c.b();
                        }
                    } catch (Throwable th) {
                        while (true) {
                            throw th;
                        }
                    }
                }
            }
        }

        b(d.c cVar) {
            this.f19338a = cVar;
            X d5 = cVar.d(1);
            this.f19339b = d5;
            this.f19340c = new a(d5, C2204c.this, cVar);
        }

        public void abort() {
            synchronized (C2204c.this) {
                try {
                    if (!this.f19341d) {
                        this.f19341d = true;
                        C2204c.this.f19333d++;
                        V3.c.d(this.f19339b);
                        try {
                            this.f19338a.a();
                        } catch (IOException unused) {
                        }
                    }
                } catch (Throwable th) {
                    while (true) {
                        throw th;
                    }
                }
            }
        }

        public X body() {
            return this.f19340c;
        }
    }

    /* renamed from: U3.c$c  reason: collision with other inner class name */
    private static class C0181c extends A {

        /* renamed from: a  reason: collision with root package name */
        final d.e f19346a;

        /* renamed from: b  reason: collision with root package name */
        private final C2358g f19347b;

        /* renamed from: c  reason: collision with root package name */
        private final String f19348c;

        /* renamed from: d  reason: collision with root package name */
        private final String f19349d;

        /* renamed from: U3.c$c$a */
        class a extends C2364m {

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ d.e f19350b;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(Z z4, d.e eVar) {
                super(z4);
                this.f19350b = eVar;
            }

            public void close() {
                this.f19350b.close();
                super.close();
            }
        }

        C0181c(d.e eVar, String str, String str2) {
            this.f19346a = eVar;
            this.f19348c = str;
            this.f19349d = str2;
            this.f19347b = L.d(new a(eVar.d(1), eVar));
        }

        public long a() {
            try {
                String str = this.f19349d;
                if (str != null) {
                    return Long.parseLong(str);
                }
                return -1;
            } catch (NumberFormatException unused) {
                return -1;
            }
        }

        public C2358g m() {
            return this.f19347b;
        }
    }

    public C2204c(File file, long j5) {
        this(file, j5, b4.a.f20795a);
    }

    private void a(d.c cVar) {
        if (cVar != null) {
            try {
                cVar.a();
            } catch (IOException unused) {
            }
        }
    }

    public static String l(r rVar) {
        return C2359h.f(rVar.toString()).v().m();
    }

    static int n(C2358g gVar) {
        try {
            long readDecimalLong = gVar.readDecimalLong();
            String readUtf8LineStrict = gVar.readUtf8LineStrict();
            if (readDecimalLong >= 0 && readDecimalLong <= 2147483647L && readUtf8LineStrict.isEmpty()) {
                return (int) readDecimalLong;
            }
            throw new IOException("expected an int but was \"" + readDecimalLong + readUtf8LineStrict + "\"");
        } catch (NumberFormatException e5) {
            throw new IOException(e5.getMessage());
        }
    }

    public void close() {
        this.f19331b.close();
    }

    /* access modifiers changed from: package-private */
    public z d(x xVar) {
        try {
            d.e p5 = this.f19331b.p(l(xVar.i()));
            if (p5 == null) {
                return null;
            }
            try {
                d dVar = new d(p5.d(0));
                z d5 = dVar.d(p5);
                if (dVar.b(xVar, d5)) {
                    return d5;
                }
                V3.c.d(d5.a());
                return null;
            } catch (IOException unused) {
                V3.c.d(p5);
                return null;
            }
        } catch (IOException unused2) {
            return null;
        }
    }

    public void flush() {
        this.f19331b.flush();
    }

    /* access modifiers changed from: package-private */
    public W3.b m(z zVar) {
        d.c cVar;
        String g5 = zVar.A().g();
        if (Y3.f.a(zVar.A().g())) {
            try {
                o(zVar.A());
            } catch (IOException unused) {
            }
            return null;
        } else if (!g5.equals(ShareTarget.METHOD_GET) || e.e(zVar)) {
            return null;
        } else {
            d dVar = new d(zVar);
            try {
                cVar = this.f19331b.n(l(zVar.A().i()));
                if (cVar == null) {
                    return null;
                }
                try {
                    dVar.f(cVar);
                    return new b(cVar);
                } catch (IOException unused2) {
                    a(cVar);
                    return null;
                }
            } catch (IOException unused3) {
                cVar = null;
                a(cVar);
                return null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void o(x xVar) {
        this.f19331b.z(l(xVar.i()));
    }

    /* access modifiers changed from: package-private */
    public synchronized void p() {
        this.f19335f++;
    }

    /* access modifiers changed from: package-private */
    public synchronized void q(c cVar) {
        try {
            this.f19336g++;
            if (cVar.f19988a != null) {
                this.f19334e++;
            } else if (cVar.f19989b != null) {
                this.f19335f++;
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void s(z zVar, z zVar2) {
        d.c cVar;
        d dVar = new d(zVar2);
        try {
            cVar = ((C0181c) zVar.a()).f19346a.a();
            if (cVar != null) {
                try {
                    dVar.f(cVar);
                    cVar.b();
                } catch (IOException unused) {
                }
            }
        } catch (IOException unused2) {
            cVar = null;
            a(cVar);
        }
    }

    C2204c(File file, long j5, b4.a aVar) {
        this.f19330a = new a();
        this.f19331b = W3.d.l(aVar, file, 201105, 2, j5);
    }

    /* renamed from: U3.c$d */
    private static final class d {

        /* renamed from: k  reason: collision with root package name */
        private static final String f19352k = (c4.f.i().j() + "-Sent-Millis");

        /* renamed from: l  reason: collision with root package name */
        private static final String f19353l = (c4.f.i().j() + "-Received-Millis");

        /* renamed from: a  reason: collision with root package name */
        private final String f19354a;

        /* renamed from: b  reason: collision with root package name */
        private final q f19355b;

        /* renamed from: c  reason: collision with root package name */
        private final String f19356c;

        /* renamed from: d  reason: collision with root package name */
        private final v f19357d;

        /* renamed from: e  reason: collision with root package name */
        private final int f19358e;

        /* renamed from: f  reason: collision with root package name */
        private final String f19359f;

        /* renamed from: g  reason: collision with root package name */
        private final q f19360g;

        /* renamed from: h  reason: collision with root package name */
        private final p f19361h;

        /* renamed from: i  reason: collision with root package name */
        private final long f19362i;

        /* renamed from: j  reason: collision with root package name */
        private final long f19363j;

        d(Z z4) {
            C c5;
            try {
                C2358g d5 = L.d(z4);
                this.f19354a = d5.readUtf8LineStrict();
                this.f19356c = d5.readUtf8LineStrict();
                q.a aVar = new q.a();
                int n5 = C2204c.n(d5);
                for (int i5 = 0; i5 < n5; i5++) {
                    aVar.b(d5.readUtf8LineStrict());
                }
                this.f19355b = aVar.d();
                k a5 = k.a(d5.readUtf8LineStrict());
                this.f19357d = a5.f20224a;
                this.f19358e = a5.f20225b;
                this.f19359f = a5.f20226c;
                q.a aVar2 = new q.a();
                int n6 = C2204c.n(d5);
                for (int i6 = 0; i6 < n6; i6++) {
                    aVar2.b(d5.readUtf8LineStrict());
                }
                String str = f19352k;
                String f5 = aVar2.f(str);
                String str2 = f19353l;
                String f6 = aVar2.f(str2);
                aVar2.g(str);
                aVar2.g(str2);
                long j5 = 0;
                this.f19362i = f5 != null ? Long.parseLong(f5) : 0;
                this.f19363j = f6 != null ? Long.parseLong(f6) : j5;
                this.f19360g = aVar2.d();
                if (a()) {
                    String readUtf8LineStrict = d5.readUtf8LineStrict();
                    if (readUtf8LineStrict.length() <= 0) {
                        g a6 = g.a(d5.readUtf8LineStrict());
                        List c6 = c(d5);
                        List c7 = c(d5);
                        if (!d5.exhausted()) {
                            c5 = C.a(d5.readUtf8LineStrict());
                        } else {
                            c5 = C.SSL_3_0;
                        }
                        this.f19361h = p.b(c5, a6, c6, c7);
                    } else {
                        throw new IOException("expected \"\" but was \"" + readUtf8LineStrict + "\"");
                    }
                } else {
                    this.f19361h = null;
                }
            } finally {
                z4.close();
            }
        }

        private boolean a() {
            return this.f19354a.startsWith("https://");
        }

        private List c(C2358g gVar) {
            int n5 = C2204c.n(gVar);
            if (n5 == -1) {
                return Collections.EMPTY_LIST;
            }
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                ArrayList arrayList = new ArrayList(n5);
                for (int i5 = 0; i5 < n5; i5++) {
                    String readUtf8LineStrict = gVar.readUtf8LineStrict();
                    C2356e eVar = new C2356e();
                    eVar.F(C2359h.c(readUtf8LineStrict));
                    arrayList.add(instance.generateCertificate(eVar.inputStream()));
                }
                return arrayList;
            } catch (CertificateException e5) {
                throw new IOException(e5.getMessage());
            }
        }

        private void e(C2357f fVar, List list) {
            try {
                fVar.writeDecimalLong((long) list.size()).writeByte(10);
                int size = list.size();
                for (int i5 = 0; i5 < size; i5++) {
                    fVar.writeUtf8(C2359h.w(((Certificate) list.get(i5)).getEncoded()).a()).writeByte(10);
                }
            } catch (CertificateEncodingException e5) {
                throw new IOException(e5.getMessage());
            }
        }

        public boolean b(x xVar, z zVar) {
            if (!this.f19354a.equals(xVar.i().toString()) || !this.f19356c.equals(xVar.g()) || !e.o(zVar, this.f19355b, xVar)) {
                return false;
            }
            return true;
        }

        public z d(d.e eVar) {
            String a5 = this.f19360g.a("Content-Type");
            String a6 = this.f19360g.a("Content-Length");
            return new z.a().o(new x.a().h(this.f19354a).e(this.f19356c, (y) null).d(this.f19355b).a()).m(this.f19357d).g(this.f19358e).j(this.f19359f).i(this.f19360g).b(new C0181c(eVar, a5, a6)).h(this.f19361h).p(this.f19362i).n(this.f19363j).c();
        }

        public void f(d.c cVar) {
            C2357f c5 = L.c(cVar.d(0));
            c5.writeUtf8(this.f19354a).writeByte(10);
            c5.writeUtf8(this.f19356c).writeByte(10);
            c5.writeDecimalLong((long) this.f19355b.e()).writeByte(10);
            int e5 = this.f19355b.e();
            for (int i5 = 0; i5 < e5; i5++) {
                c5.writeUtf8(this.f19355b.c(i5)).writeUtf8(": ").writeUtf8(this.f19355b.f(i5)).writeByte(10);
            }
            c5.writeUtf8(new k(this.f19357d, this.f19358e, this.f19359f).toString()).writeByte(10);
            c5.writeDecimalLong((long) (this.f19360g.e() + 2)).writeByte(10);
            int e6 = this.f19360g.e();
            for (int i6 = 0; i6 < e6; i6++) {
                c5.writeUtf8(this.f19360g.c(i6)).writeUtf8(": ").writeUtf8(this.f19360g.f(i6)).writeByte(10);
            }
            c5.writeUtf8(f19352k).writeUtf8(": ").writeDecimalLong(this.f19362i).writeByte(10);
            c5.writeUtf8(f19353l).writeUtf8(": ").writeDecimalLong(this.f19363j).writeByte(10);
            if (a()) {
                c5.writeByte(10);
                c5.writeUtf8(this.f19361h.a().c()).writeByte(10);
                e(c5, this.f19361h.e());
                e(c5, this.f19361h.d());
                c5.writeUtf8(this.f19361h.f().c()).writeByte(10);
            }
            c5.close();
        }

        d(z zVar) {
            this.f19354a = zVar.A().i().toString();
            this.f19355b = e.n(zVar);
            this.f19356c = zVar.A().g();
            this.f19357d = zVar.y();
            this.f19358e = zVar.m();
            this.f19359f = zVar.t();
            this.f19360g = zVar.q();
            this.f19361h = zVar.n();
            this.f19362i = zVar.B();
            this.f19363j = zVar.z();
        }
    }
}
