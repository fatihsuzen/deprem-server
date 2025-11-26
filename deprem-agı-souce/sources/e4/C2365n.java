package e4;

import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.t;

/* renamed from: e4.n  reason: case insensitive filesystem */
public class C2365n extends a0 {

    /* renamed from: f  reason: collision with root package name */
    private a0 f21595f;

    public C2365n(a0 a0Var) {
        t.e(a0Var, "delegate");
        this.f21595f = a0Var;
    }

    public a0 a() {
        return this.f21595f.a();
    }

    public a0 b() {
        return this.f21595f.b();
    }

    public long c() {
        return this.f21595f.c();
    }

    public a0 d(long j5) {
        return this.f21595f.d(j5);
    }

    public boolean e() {
        return this.f21595f.e();
    }

    public void f() {
        this.f21595f.f();
    }

    public a0 g(long j5, TimeUnit timeUnit) {
        t.e(timeUnit, "unit");
        return this.f21595f.g(j5, timeUnit);
    }

    public final a0 i() {
        return this.f21595f;
    }

    public final C2365n j(a0 a0Var) {
        t.e(a0Var, "delegate");
        this.f21595f = a0Var;
        return this;
    }
}
