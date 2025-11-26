package Y1;

import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

/* renamed from: Y1.a  reason: case insensitive filesystem */
public final class C2257a {

    /* renamed from: f  reason: collision with root package name */
    public static final C0194a f20118f = new C0194a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private String f20119a;

    /* renamed from: b  reason: collision with root package name */
    private long f20120b = -1;

    /* renamed from: c  reason: collision with root package name */
    private String f20121c;

    /* renamed from: d  reason: collision with root package name */
    private long f20122d;

    /* renamed from: e  reason: collision with root package name */
    private long f20123e = -1;

    /* renamed from: Y1.a$a  reason: collision with other inner class name */
    public static final class C0194a {
        public /* synthetic */ C0194a(C2633k kVar) {
            this();
        }

        private C0194a() {
        }
    }

    public final String a() {
        return this.f20121c;
    }

    public final String b() {
        return this.f20119a;
    }

    public final long c() {
        return this.f20123e;
    }

    public final long d() {
        return this.f20122d;
    }

    public final long e() {
        return this.f20120b;
    }

    public final void f(String str, long j5, String str2, long j6) {
        t.e(str, "packageName");
        t.e(str2, "appName");
        this.f20119a = str;
        this.f20120b = j5;
        this.f20121c = str2;
        this.f20122d = System.currentTimeMillis();
        this.f20123e = j6;
    }
}
