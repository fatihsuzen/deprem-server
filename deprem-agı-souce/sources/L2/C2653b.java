package l2;

import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import z2.C2940B;

/* renamed from: l2.b  reason: case insensitive filesystem */
public final class C2653b {

    /* renamed from: j  reason: collision with root package name */
    public static final a f24948j = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private long f24949a = -1;

    /* renamed from: b  reason: collision with root package name */
    private int f24950b = -1;

    /* renamed from: c  reason: collision with root package name */
    private String f24951c;

    /* renamed from: d  reason: collision with root package name */
    private String f24952d;

    /* renamed from: e  reason: collision with root package name */
    private String f24953e;

    /* renamed from: f  reason: collision with root package name */
    private String f24954f;

    /* renamed from: g  reason: collision with root package name */
    private String f24955g;

    /* renamed from: h  reason: collision with root package name */
    private String f24956h;

    /* renamed from: i  reason: collision with root package name */
    private String f24957i;

    /* renamed from: l2.b$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    private final String e() {
        int i5 = this.f24950b;
        if (i5 == 1) {
            return "NEW_UPDATE";
        }
        if (i5 == 3) {
            return "DOWNLOADED_UPDATE";
        }
        if (i5 != 4) {
            return "Unknown";
        }
        return "INSTALLED_UPDATE";
    }

    public final String a() {
        return this.f24951c;
    }

    public final String b() {
        return this.f24956h;
    }

    public final String c() {
        return this.f24957i;
    }

    public final int d() {
        return this.f24950b;
    }

    public final String f() {
        return this.f24955g;
    }

    public final String g() {
        return this.f24954f;
    }

    public final String h() {
        return this.f24953e;
    }

    public final String i() {
        return this.f24952d;
    }

    public final void j(C2655d dVar, T t5, C2940B b5) {
        long j5;
        t.e(dVar, "appStored");
        t.e(t5, "update");
        t.e(b5, "dbManager");
        C2653b bVar = new C2653b();
        bVar.f24951c = dVar.o();
        bVar.f24950b = 3;
        bVar.f24954f = String.valueOf(dVar.A());
        bVar.f24955g = String.valueOf(t5.j());
        bVar.f24952d = dVar.B();
        bVar.f24953e = t5.k();
        if (t5.a() != null) {
            C2668q a5 = t5.a();
            t.b(a5);
            j5 = a5.z();
        } else {
            j5 = 0;
        }
        bVar.f24956h = String.valueOf(j5);
        bVar.f24957i = String.valueOf(System.currentTimeMillis() / ((long) 1000));
        b5.L0(bVar);
    }

    public final void k(C2655d dVar, C2940B b5) {
        t.e(dVar, "appUpdated");
        t.e(b5, "dbManager");
        C2653b bVar = new C2653b();
        bVar.f24951c = dVar.o();
        bVar.f24950b = 4;
        bVar.f24955g = String.valueOf(dVar.A());
        bVar.f24953e = dVar.B();
        bVar.f24957i = String.valueOf(System.currentTimeMillis() / ((long) 1000));
        b5.L0(bVar);
    }

    public final void l(C2655d dVar, T t5, C2940B b5) {
        long j5;
        t.e(dVar, "appStored");
        t.e(t5, "update");
        t.e(b5, "dbManager");
        C2653b bVar = new C2653b();
        bVar.f24951c = dVar.o();
        bVar.f24950b = 1;
        bVar.f24954f = String.valueOf(dVar.A());
        bVar.f24955g = String.valueOf(t5.j());
        bVar.f24952d = dVar.B();
        bVar.f24953e = t5.k();
        if (t5.a() != null) {
            C2668q a5 = t5.a();
            t.b(a5);
            j5 = a5.z();
        } else {
            j5 = 0;
        }
        bVar.f24956h = String.valueOf(j5);
        bVar.f24957i = String.valueOf(System.currentTimeMillis() / ((long) 1000));
        b5.L0(bVar);
    }

    public String toString() {
        return "{id=" + this.f24949a + ", type=" + this.f24950b + ", typeReadable=" + e() + ", packageName=" + this.f24951c + ", versionNameOld=" + this.f24952d + ", versionNameNew=" + this.f24953e + ", versionCodeOld=" + this.f24954f + ", versionCodeNew=" + this.f24955g + ", size=" + this.f24956h + ", timestamp=" + this.f24957i + '}';
    }
}
