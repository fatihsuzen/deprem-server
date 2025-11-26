package l2;

import com.mbridge.msdk.MBridgeConstans;
import kotlin.jvm.internal.t;
import t3.s;
import z2.E;

/* renamed from: l2.j  reason: case insensitive filesystem */
public final class C2661j {

    /* renamed from: a  reason: collision with root package name */
    public String f25103a;

    /* renamed from: b  reason: collision with root package name */
    public String f25104b;

    /* renamed from: c  reason: collision with root package name */
    private int f25105c = -1;

    public final String a() {
        String str = this.f25104b;
        if (str != null) {
            return str;
        }
        t.w("date");
        return null;
    }

    public final int b() {
        return this.f25105c;
    }

    public final String c() {
        String substring = e().substring(s.l0(e(), "/", 0, false, 6, (Object) null) + 1);
        t.d(substring, "substring(...)");
        return substring;
    }

    public final String d() {
        return new E().k(c());
    }

    public final String e() {
        String str = this.f25103a;
        if (str != null) {
            return str;
        }
        t.w(MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        return null;
    }

    public final void f(String str) {
        t.e(str, "<set-?>");
        this.f25104b = str;
    }

    public final void g(int i5) {
        this.f25105c = i5;
    }

    public final void h(String str) {
        t.e(str, "<set-?>");
        this.f25103a = str;
    }

    public String toString() {
        return "{path='" + e() + "', date='" + a() + "'}";
    }
}
