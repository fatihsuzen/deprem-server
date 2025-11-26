package l2;

import android.content.Context;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

/* renamed from: l2.A  reason: case insensitive filesystem */
public final class C2641A {

    /* renamed from: f  reason: collision with root package name */
    public static final a f24721f = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private long f24722a = -1;

    /* renamed from: b  reason: collision with root package name */
    private String f24723b;

    /* renamed from: c  reason: collision with root package name */
    private int f24724c = -1;

    /* renamed from: d  reason: collision with root package name */
    private long f24725d;

    /* renamed from: e  reason: collision with root package name */
    private long f24726e;

    /* renamed from: l2.A$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final void a(Context context) {
            t.e(context, "context");
            com.uptodown.activities.preferences.a.f15150a.a(context);
        }

        public final C2641A b(Context context) {
            t.e(context, "context");
            C2641A C4 = com.uptodown.activities.preferences.a.f15150a.C(context);
            if (C4 == null) {
                return null;
            }
            if (C4.h()) {
                return C4;
            }
            a(context);
            return null;
        }

        private a() {
        }
    }

    /* access modifiers changed from: private */
    public final boolean h() {
        if (this.f24722a <= -1 || this.f24723b == null) {
            return false;
        }
        long j5 = this.f24725d;
        if (j5 <= 0 || j5 + ((long) 86400000) <= System.currentTimeMillis()) {
            return false;
        }
        return true;
    }

    public final long b() {
        return this.f24722a;
    }

    public final int c() {
        return this.f24724c;
    }

    public final String d() {
        return this.f24723b;
    }

    public final long e() {
        return this.f24725d;
    }

    public final long f() {
        return this.f24726e;
    }

    public final boolean g() {
        if (this.f24726e > 0) {
            return true;
        }
        return false;
    }

    public final void i(Context context) {
        t.e(context, "context");
        com.uptodown.activities.preferences.a.f15150a.p0(context, this);
    }

    public final void j(long j5) {
        this.f24722a = j5;
    }

    public final void k(int i5) {
        this.f24724c = i5;
    }

    public final void l(Context context, int i5) {
        t.e(context, "context");
        this.f24724c = i5;
        i(context);
    }

    public final void m(String str) {
        this.f24723b = str;
    }

    public final void n(Context context) {
        t.e(context, "context");
        this.f24725d = System.currentTimeMillis();
        i(context);
    }

    public final void o(long j5) {
        this.f24725d = j5;
    }

    public final void p(Context context) {
        t.e(context, "context");
        this.f24726e = System.currentTimeMillis();
        i(context);
    }

    public final void q(long j5) {
        this.f24726e = j5;
    }

    public String toString() {
        return "NotificationFCM(appId=" + this.f24722a + ", packageName=" + this.f24723b + ", downloadId=" + this.f24724c + ')';
    }
}
