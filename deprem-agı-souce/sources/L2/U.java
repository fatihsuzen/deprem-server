package l2;

import android.content.Context;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class U {

    /* renamed from: c  reason: collision with root package name */
    public static final a f24867c = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private long f24868a;

    /* renamed from: b  reason: collision with root package name */
    private long f24869b;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final U a(Context context) {
            t.e(context, "context");
            return com.uptodown.activities.preferences.a.f15150a.I(context);
        }

        private a() {
        }
    }

    public U(long j5, long j6) {
        this.f24868a = j5;
        this.f24869b = j6;
    }

    public final long a(Context context) {
        t.e(context, "context");
        if (System.currentTimeMillis() - this.f24869b > 2592000000L) {
            this.f24868a = 0;
            this.f24869b = System.currentTimeMillis();
            com.uptodown.activities.preferences.a.f15150a.q0(context, this);
        }
        return 209715200 - this.f24868a;
    }

    public final long b() {
        return this.f24868a;
    }

    public final long c() {
        return this.f24869b;
    }

    public final void d(Context context) {
        t.e(context, "context");
        com.uptodown.activities.preferences.a.f15150a.q0(context, this);
    }

    public final void e(long j5) {
        this.f24868a = j5;
    }
}
