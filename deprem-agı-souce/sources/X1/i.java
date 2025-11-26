package x1;

import B1.a;
import android.content.Context;
import android.os.Handler;
import u1.n;
import w1.b;
import w1.c;
import w1.e;
import x1.d;

public class i implements d.a, c {

    /* renamed from: f  reason: collision with root package name */
    private static i f16990f;

    /* renamed from: a  reason: collision with root package name */
    private float f16991a = 0.0f;

    /* renamed from: b  reason: collision with root package name */
    private final e f16992b;

    /* renamed from: c  reason: collision with root package name */
    private final b f16993c;

    /* renamed from: d  reason: collision with root package name */
    private w1.d f16994d;

    /* renamed from: e  reason: collision with root package name */
    private c f16995e;

    public i(e eVar, b bVar) {
        this.f16992b = eVar;
        this.f16993c = bVar;
    }

    private c a() {
        if (this.f16995e == null) {
            this.f16995e = c.e();
        }
        return this.f16995e;
    }

    public static i d() {
        if (f16990f == null) {
            f16990f = new i(new e(), new b());
        }
        return f16990f;
    }

    public void b(Context context) {
        this.f16994d = this.f16992b.a(new Handler(), context, this.f16993c.a(), this);
    }

    public float c() {
        return this.f16991a;
    }

    public void e() {
        b.k().b(this);
        b.k().i();
        a.p().q();
        this.f16994d.d();
    }

    public void f() {
        a.p().s();
        b.k().j();
        this.f16994d.e();
    }

    public void a(float f5) {
        this.f16991a = f5;
        for (n t5 : a().a()) {
            t5.t().b(f5);
        }
    }

    public void a(boolean z4) {
        if (z4) {
            a.p().q();
        } else {
            a.p().o();
        }
    }
}
