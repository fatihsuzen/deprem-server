package com.squareup.picasso;

import M1.e;
import android.graphics.Bitmap;
import android.net.Uri;
import com.squareup.picasso.s;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public final class v {

    /* renamed from: u  reason: collision with root package name */
    private static final long f13404u = TimeUnit.SECONDS.toNanos(5);

    /* renamed from: a  reason: collision with root package name */
    int f13405a;

    /* renamed from: b  reason: collision with root package name */
    long f13406b;

    /* renamed from: c  reason: collision with root package name */
    int f13407c;

    /* renamed from: d  reason: collision with root package name */
    public final Uri f13408d;

    /* renamed from: e  reason: collision with root package name */
    public final int f13409e;

    /* renamed from: f  reason: collision with root package name */
    public final String f13410f;

    /* renamed from: g  reason: collision with root package name */
    public final List f13411g;

    /* renamed from: h  reason: collision with root package name */
    public final int f13412h;

    /* renamed from: i  reason: collision with root package name */
    public final int f13413i;

    /* renamed from: j  reason: collision with root package name */
    public final boolean f13414j;

    /* renamed from: k  reason: collision with root package name */
    public final int f13415k;

    /* renamed from: l  reason: collision with root package name */
    public final boolean f13416l;

    /* renamed from: m  reason: collision with root package name */
    public final boolean f13417m;

    /* renamed from: n  reason: collision with root package name */
    public final float f13418n;

    /* renamed from: o  reason: collision with root package name */
    public final float f13419o;

    /* renamed from: p  reason: collision with root package name */
    public final float f13420p;

    /* renamed from: q  reason: collision with root package name */
    public final boolean f13421q;

    /* renamed from: r  reason: collision with root package name */
    public final boolean f13422r;

    /* renamed from: s  reason: collision with root package name */
    public final Bitmap.Config f13423s;

    /* renamed from: t  reason: collision with root package name */
    public final s.f f13424t;

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        private Uri f13425a;

        /* renamed from: b  reason: collision with root package name */
        private int f13426b;

        /* renamed from: c  reason: collision with root package name */
        private String f13427c;

        /* renamed from: d  reason: collision with root package name */
        private int f13428d;

        /* renamed from: e  reason: collision with root package name */
        private int f13429e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f13430f;

        /* renamed from: g  reason: collision with root package name */
        private int f13431g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f13432h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f13433i;

        /* renamed from: j  reason: collision with root package name */
        private float f13434j;

        /* renamed from: k  reason: collision with root package name */
        private float f13435k;

        /* renamed from: l  reason: collision with root package name */
        private float f13436l;

        /* renamed from: m  reason: collision with root package name */
        private boolean f13437m;

        /* renamed from: n  reason: collision with root package name */
        private boolean f13438n;

        /* renamed from: o  reason: collision with root package name */
        private List f13439o;

        /* renamed from: p  reason: collision with root package name */
        private Bitmap.Config f13440p;

        /* renamed from: q  reason: collision with root package name */
        private s.f f13441q;

        b(Uri uri, int i5, Bitmap.Config config) {
            this.f13425a = uri;
            this.f13426b = i5;
            this.f13440p = config;
        }

        public v a() {
            boolean z4 = this.f13432h;
            if (z4 && this.f13430f) {
                throw new IllegalStateException("Center crop and center inside can not be used together.");
            } else if (this.f13430f && this.f13428d == 0 && this.f13429e == 0) {
                throw new IllegalStateException("Center crop requires calling resize with positive width and height.");
            } else if (z4 && this.f13428d == 0 && this.f13429e == 0) {
                throw new IllegalStateException("Center inside requires calling resize with positive width and height.");
            } else {
                if (this.f13441q == null) {
                    this.f13441q = s.f.NORMAL;
                }
                return new v(this.f13425a, this.f13426b, this.f13427c, this.f13439o, this.f13428d, this.f13429e, this.f13430f, this.f13432h, this.f13431g, this.f13433i, this.f13434j, this.f13435k, this.f13436l, this.f13437m, this.f13438n, this.f13440p, this.f13441q);
            }
        }

        public b b(int i5) {
            if (!this.f13432h) {
                this.f13430f = true;
                this.f13431g = i5;
                return this;
            }
            throw new IllegalStateException("Center crop can not be used after calling centerInside");
        }

        /* access modifiers changed from: package-private */
        public boolean c() {
            if (this.f13425a == null && this.f13426b == 0) {
                return false;
            }
            return true;
        }

        /* access modifiers changed from: package-private */
        public boolean d() {
            if (this.f13441q != null) {
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public boolean e() {
            if (this.f13428d == 0 && this.f13429e == 0) {
                return false;
            }
            return true;
        }

        public b f(s.f fVar) {
            if (fVar == null) {
                throw new IllegalArgumentException("Priority invalid.");
            } else if (this.f13441q == null) {
                this.f13441q = fVar;
                return this;
            } else {
                throw new IllegalStateException("Priority already set.");
            }
        }

        public b g(int i5, int i6) {
            if (i5 < 0) {
                throw new IllegalArgumentException("Width must be positive number or 0.");
            } else if (i6 < 0) {
                throw new IllegalArgumentException("Height must be positive number or 0.");
            } else if (i6 == 0 && i5 == 0) {
                throw new IllegalArgumentException("At least one dimension has to be positive number.");
            } else {
                this.f13428d = i5;
                this.f13429e = i6;
                return this;
            }
        }

        public b h(e eVar) {
            if (eVar == null) {
                throw new IllegalArgumentException("Transformation must not be null.");
            } else if (eVar.key() != null) {
                if (this.f13439o == null) {
                    this.f13439o = new ArrayList(2);
                }
                this.f13439o.add(eVar);
                return this;
            } else {
                throw new IllegalArgumentException("Transformation key must not be null.");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public String a() {
        Uri uri = this.f13408d;
        if (uri != null) {
            return String.valueOf(uri.getPath());
        }
        return Integer.toHexString(this.f13409e);
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        if (this.f13411g != null) {
            return true;
        }
        return false;
    }

    public boolean c() {
        if (this.f13412h == 0 && this.f13413i == 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public String d() {
        long nanoTime = System.nanoTime() - this.f13406b;
        if (nanoTime > f13404u) {
            return g() + '+' + TimeUnit.NANOSECONDS.toSeconds(nanoTime) + 's';
        }
        return g() + '+' + TimeUnit.NANOSECONDS.toMillis(nanoTime) + "ms";
    }

    /* access modifiers changed from: package-private */
    public boolean e() {
        if (c() || this.f13418n != 0.0f) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean f() {
        if (e() || b()) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public String g() {
        return "[R" + this.f13405a + ']';
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Request{");
        int i5 = this.f13409e;
        if (i5 > 0) {
            sb.append(i5);
        } else {
            sb.append(this.f13408d);
        }
        List list = this.f13411g;
        if (list != null && !list.isEmpty()) {
            for (e key : this.f13411g) {
                sb.append(' ');
                sb.append(key.key());
            }
        }
        if (this.f13410f != null) {
            sb.append(" stableKey(");
            sb.append(this.f13410f);
            sb.append(')');
        }
        if (this.f13412h > 0) {
            sb.append(" resize(");
            sb.append(this.f13412h);
            sb.append(',');
            sb.append(this.f13413i);
            sb.append(')');
        }
        if (this.f13414j) {
            sb.append(" centerCrop");
        }
        if (this.f13416l) {
            sb.append(" centerInside");
        }
        if (this.f13418n != 0.0f) {
            sb.append(" rotation(");
            sb.append(this.f13418n);
            if (this.f13421q) {
                sb.append(" @ ");
                sb.append(this.f13419o);
                sb.append(',');
                sb.append(this.f13420p);
            }
            sb.append(')');
        }
        if (this.f13422r) {
            sb.append(" purgeable");
        }
        if (this.f13423s != null) {
            sb.append(' ');
            sb.append(this.f13423s);
        }
        sb.append('}');
        return sb.toString();
    }

    private v(Uri uri, int i5, String str, List list, int i6, int i7, boolean z4, boolean z5, int i8, boolean z6, float f5, float f6, float f7, boolean z7, boolean z8, Bitmap.Config config, s.f fVar) {
        this.f13408d = uri;
        this.f13409e = i5;
        this.f13410f = str;
        if (list == null) {
            this.f13411g = null;
        } else {
            this.f13411g = DesugarCollections.unmodifiableList(list);
        }
        this.f13412h = i6;
        this.f13413i = i7;
        this.f13414j = z4;
        this.f13416l = z5;
        this.f13415k = i8;
        this.f13417m = z6;
        this.f13418n = f5;
        this.f13419o = f6;
        this.f13420p = f7;
        this.f13421q = z7;
        this.f13422r = z8;
        this.f13423s = config;
        this.f13424t = fVar;
    }
}
