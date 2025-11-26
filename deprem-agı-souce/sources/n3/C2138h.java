package N3;

import kotlin.jvm.internal.t;

/* renamed from: N3.h  reason: case insensitive filesystem */
public class C2138h {

    /* renamed from: a  reason: collision with root package name */
    public final C2149t f18790a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f18791b = true;

    public C2138h(C2149t tVar) {
        t.e(tVar, "writer");
        this.f18790a = tVar;
    }

    public final boolean a() {
        return this.f18791b;
    }

    public void b() {
        this.f18791b = true;
    }

    public void c() {
        this.f18791b = false;
    }

    public void d() {
        this.f18791b = false;
    }

    public void e(byte b5) {
        this.f18790a.writeLong((long) b5);
    }

    public final void f(char c5) {
        this.f18790a.a(c5);
    }

    public void g(double d5) {
        this.f18790a.c(String.valueOf(d5));
    }

    public void h(float f5) {
        this.f18790a.c(String.valueOf(f5));
    }

    public void i(int i5) {
        this.f18790a.writeLong((long) i5);
    }

    public void j(long j5) {
        this.f18790a.writeLong(j5);
    }

    public final void k(String str) {
        t.e(str, "v");
        this.f18790a.c(str);
    }

    public void l(short s5) {
        this.f18790a.writeLong((long) s5);
    }

    public void m(boolean z4) {
        this.f18790a.c(String.valueOf(z4));
    }

    public void n(String str) {
        t.e(str, "value");
        this.f18790a.b(str);
    }

    /* access modifiers changed from: protected */
    public final void o(boolean z4) {
        this.f18791b = z4;
    }

    public void p() {
    }

    public void q() {
    }
}
