package Y1;

import com.mbridge.msdk.MBridgeConstans;
import kotlin.jvm.internal.t;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private String f20145a;

    /* renamed from: b  reason: collision with root package name */
    private String f20146b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f20147c;

    /* renamed from: d  reason: collision with root package name */
    private long f20148d;

    public g(String str) {
        t.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        this.f20145a = str;
    }

    public final long a() {
        return this.f20148d;
    }

    public final String b() {
        return this.f20145a;
    }

    public final boolean c() {
        return t.a("mounted", this.f20146b);
    }

    public final boolean d() {
        return this.f20147c;
    }

    public final void e(long j5) {
        this.f20148d = j5;
    }

    public final void f(boolean z4) {
        this.f20147c = z4;
    }

    public final void g(String str) {
        this.f20146b = str;
    }
}
