package l2;

import android.content.Context;
import com.uptodown.activities.preferences.a;
import kotlin.jvm.internal.t;
import t3.s;
import z2.M;

public final class Q {

    /* renamed from: a  reason: collision with root package name */
    private final String f24845a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f24846b;

    /* renamed from: c  reason: collision with root package name */
    private final String f24847c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f24848d;

    /* renamed from: e  reason: collision with root package name */
    private final String f24849e;

    /* renamed from: f  reason: collision with root package name */
    private final boolean f24850f;

    /* renamed from: g  reason: collision with root package name */
    private int f24851g = 694;

    public Q(Context context) {
        t.e(context, "context");
        a.C0147a aVar = a.f15150a;
        this.f24845a = aVar.n(context);
        this.f24846b = M.f26506a.a(context);
        this.f24847c = aVar.B(context);
        this.f24848d = aVar.b0(context);
        this.f24849e = aVar.j(context);
        this.f24850f = aVar.Y(context);
    }

    public final boolean a(String str, String str2) {
        if ((str != null || str2 != null) && (str == null || !s.E(str, str2, true))) {
            return false;
        }
        return true;
    }

    public final boolean b(Q q5) {
        if (q5 == null || !a(q5.f24845a, this.f24845a) || q5.f24846b != this.f24846b || q5.f24848d != this.f24848d || !s.E(q5.f24847c, this.f24847c, true) || !t.a(q5.f24849e, this.f24849e) || q5.f24850f != this.f24850f) {
            return false;
        }
        return true;
    }

    public final String c() {
        return this.f24847c;
    }

    public final String d() {
        return this.f24845a;
    }

    public final int e() {
        return this.f24851g;
    }

    public final String f() {
        return this.f24849e;
    }

    public final boolean g() {
        return this.f24850f;
    }

    public final boolean h() {
        return this.f24846b;
    }

    public final boolean i() {
        return this.f24848d;
    }

    public final void j(Context context, C2667p pVar) {
        t.e(context, "context");
        t.e(pVar, "device");
        new g2.t(context, pVar, this);
    }
}
