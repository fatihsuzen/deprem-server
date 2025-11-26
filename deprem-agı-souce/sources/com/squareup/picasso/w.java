package com.squareup.picasso;

import M1.b;
import M1.e;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView;
import com.squareup.picasso.s;
import com.squareup.picasso.v;
import java.util.concurrent.atomic.AtomicInteger;

public class w {

    /* renamed from: m  reason: collision with root package name */
    private static final AtomicInteger f13442m = new AtomicInteger();

    /* renamed from: a  reason: collision with root package name */
    private final s f13443a;

    /* renamed from: b  reason: collision with root package name */
    private final v.b f13444b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f13445c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f13446d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f13447e = true;

    /* renamed from: f  reason: collision with root package name */
    private int f13448f;

    /* renamed from: g  reason: collision with root package name */
    private int f13449g;

    /* renamed from: h  reason: collision with root package name */
    private int f13450h;

    /* renamed from: i  reason: collision with root package name */
    private int f13451i;

    /* renamed from: j  reason: collision with root package name */
    private Drawable f13452j;

    /* renamed from: k  reason: collision with root package name */
    private Drawable f13453k;

    /* renamed from: l  reason: collision with root package name */
    private Object f13454l;

    w(s sVar, Uri uri, int i5) {
        if (!sVar.f13371n) {
            this.f13443a = sVar;
            this.f13444b = new v.b(uri, i5, sVar.f13368k);
            return;
        }
        throw new IllegalStateException("Picasso instance already shut down. Cannot submit new requests.");
    }

    private v c(long j5) {
        int andIncrement = f13442m.getAndIncrement();
        v a5 = this.f13444b.a();
        a5.f13405a = andIncrement;
        a5.f13406b = j5;
        boolean z4 = this.f13443a.f13370m;
        if (z4) {
            C.u("Main", "created", a5.g(), a5.toString());
        }
        v p5 = this.f13443a.p(a5);
        if (p5 != a5) {
            p5.f13405a = andIncrement;
            p5.f13406b = j5;
            if (z4) {
                String d5 = p5.d();
                C.u("Main", "changed", d5, "into " + p5);
            }
        }
        return p5;
    }

    private Drawable h() {
        int i5 = this.f13448f;
        if (i5 != 0) {
            return this.f13443a.f13361d.getDrawable(i5);
        }
        return this.f13452j;
    }

    public w a() {
        this.f13444b.b(17);
        return this;
    }

    /* access modifiers changed from: package-private */
    public w b() {
        this.f13454l = null;
        return this;
    }

    public void d() {
        e((b) null);
    }

    public void e(b bVar) {
        long nanoTime = System.nanoTime();
        if (this.f13446d) {
            throw new IllegalStateException("Fit cannot be used with fetch.");
        } else if (this.f13444b.c()) {
            if (!this.f13444b.d()) {
                this.f13444b.f(s.f.LOW);
            }
            v c5 = c(nanoTime);
            String h5 = C.h(c5, new StringBuilder());
            if (!o.a(this.f13450h) || this.f13443a.m(h5) == null) {
                this.f13443a.o(new h(this.f13443a, c5, this.f13450h, this.f13451i, this.f13454l, h5, bVar));
                return;
            }
            if (this.f13443a.f13370m) {
                String g5 = c5.g();
                C.u("Main", "completed", g5, "from " + s.e.MEMORY);
            }
            if (bVar != null) {
                bVar.onSuccess();
            }
        }
    }

    public w f() {
        this.f13446d = true;
        return this;
    }

    public Bitmap g() {
        long nanoTime = System.nanoTime();
        C.d();
        if (this.f13446d) {
            throw new IllegalStateException("Fit cannot be used with get.");
        } else if (!this.f13444b.c()) {
            return null;
        } else {
            v c5 = c(nanoTime);
            j jVar = new j(this.f13443a, c5, this.f13450h, this.f13451i, this.f13454l, C.h(c5, new StringBuilder()));
            s sVar = this.f13443a;
            return C1587c.g(sVar, sVar.f13362e, sVar.f13363f, sVar.f13364g, jVar).t();
        }
    }

    public void i(ImageView imageView) {
        j(imageView, (b) null);
    }

    public void j(ImageView imageView, b bVar) {
        Bitmap m5;
        b bVar2 = bVar;
        long nanoTime = System.nanoTime();
        C.c();
        if (imageView == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else if (!this.f13444b.c()) {
            this.f13443a.b(imageView);
            if (this.f13447e) {
                t.d(imageView, h());
            }
        } else {
            if (this.f13446d) {
                if (!this.f13444b.e()) {
                    int width = imageView.getWidth();
                    int height = imageView.getHeight();
                    if (width == 0 || height == 0) {
                        if (this.f13447e) {
                            t.d(imageView, h());
                        }
                        this.f13443a.e(imageView, new f(this, imageView, bVar));
                        return;
                    }
                    this.f13444b.g(width, height);
                } else {
                    throw new IllegalStateException("Fit cannot be used with resize.");
                }
            }
            v c5 = c(nanoTime);
            String g5 = C.g(c5);
            if (!o.a(this.f13450h) || (m5 = this.f13443a.m(g5)) == null) {
                if (this.f13447e) {
                    t.d(imageView, h());
                }
                ImageView imageView2 = imageView;
                this.f13443a.g(new k(this.f13443a, imageView2, c5, this.f13450h, this.f13451i, this.f13449g, this.f13453k, g5, this.f13454l, bVar2, this.f13445c));
                return;
            }
            this.f13443a.b(imageView);
            s sVar = this.f13443a;
            Context context = sVar.f13361d;
            s.e eVar = s.e.MEMORY;
            Context context2 = context;
            boolean z4 = this.f13445c;
            Context context3 = context2;
            boolean z5 = sVar.f13369l;
            t.c(imageView, context3, m5, eVar, z4, z5);
            if (this.f13443a.f13370m) {
                String g6 = c5.g();
                C.u("Main", "completed", g6, "from " + eVar);
            }
            if (bVar2 != null) {
                bVar.onSuccess();
            }
        }
    }

    public void k(A a5) {
        Bitmap m5;
        long nanoTime = System.nanoTime();
        C.c();
        if (a5 == null) {
            throw new IllegalArgumentException("Target must not be null.");
        } else if (!this.f13446d) {
            Drawable drawable = null;
            if (!this.f13444b.c()) {
                this.f13443a.c(a5);
                if (this.f13447e) {
                    drawable = h();
                }
                a5.b(drawable);
                return;
            }
            v c5 = c(nanoTime);
            String g5 = C.g(c5);
            if (!o.a(this.f13450h) || (m5 = this.f13443a.m(g5)) == null) {
                if (this.f13447e) {
                    drawable = h();
                }
                a5.b(drawable);
                this.f13443a.g(new B(this.f13443a, a5, c5, this.f13450h, this.f13451i, this.f13453k, g5, this.f13454l, this.f13449g));
                return;
            }
            this.f13443a.c(a5);
            a5.c(m5, s.e.MEMORY);
        } else {
            throw new IllegalStateException("Fit cannot be used with a Target.");
        }
    }

    public w l(int i5) {
        if (!this.f13447e) {
            throw new IllegalStateException("Already explicitly declared as no placeholder.");
        } else if (i5 == 0) {
            throw new IllegalArgumentException("Placeholder image resource invalid.");
        } else if (this.f13452j == null) {
            this.f13448f = i5;
            return this;
        } else {
            throw new IllegalStateException("Placeholder image already set.");
        }
    }

    public w m(int i5, int i6) {
        this.f13444b.g(i5, i6);
        return this;
    }

    public w n(e eVar) {
        this.f13444b.h(eVar);
        return this;
    }

    /* access modifiers changed from: package-private */
    public w o() {
        this.f13446d = false;
        return this;
    }
}
