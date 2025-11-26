package l2;

import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import t3.s;

/* renamed from: l2.w  reason: case insensitive filesystem */
public final class C2673w {

    /* renamed from: d  reason: collision with root package name */
    public static final a f25227d = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private String f25228a;

    /* renamed from: b  reason: collision with root package name */
    private long f25229b;

    /* renamed from: c  reason: collision with root package name */
    private String f25230c;

    /* renamed from: l2.w$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public final String a() {
        return this.f25230c;
    }

    public final String b() {
        String str = this.f25230c;
        if (str == null) {
            return null;
        }
        t.b(str);
        String str2 = this.f25230c;
        t.b(str2);
        String substring = str.substring(s.l0(str2, "/", 0, false, 6, (Object) null) + 1);
        t.d(substring, "substring(...)");
        return substring;
    }

    public final String c() {
        return this.f25228a;
    }

    public final long d() {
        return this.f25229b;
    }

    public final void e(String str) {
        this.f25230c = str;
    }

    public final void f(String str) {
        this.f25228a = str;
    }

    public final void g(long j5) {
        this.f25229b = j5;
    }

    public String toString() {
        return "{sha256='" + this.f25228a + "', size=" + this.f25229b + ", absolutePath='" + this.f25230c + "'}";
    }
}
