package k0;

import java.util.concurrent.ExecutionException;

final class t implements s {

    /* renamed from: a  reason: collision with root package name */
    private final Object f15493a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private final int f15494b;

    /* renamed from: c  reason: collision with root package name */
    private final O f15495c;

    /* renamed from: d  reason: collision with root package name */
    private int f15496d;

    /* renamed from: e  reason: collision with root package name */
    private int f15497e;

    /* renamed from: f  reason: collision with root package name */
    private int f15498f;

    /* renamed from: g  reason: collision with root package name */
    private Exception f15499g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f15500h;

    public t(int i5, O o5) {
        this.f15494b = i5;
        this.f15495c = o5;
    }

    private final void c() {
        if (this.f15496d + this.f15497e + this.f15498f != this.f15494b) {
            return;
        }
        if (this.f15499g != null) {
            O o5 = this.f15495c;
            int i5 = this.f15497e;
            int i6 = this.f15494b;
            o5.q(new ExecutionException(i5 + " out of " + i6 + " underlying tasks failed", this.f15499g));
        } else if (this.f15500h) {
            this.f15495c.s();
        } else {
            this.f15495c.r((Object) null);
        }
    }

    public final void a(Object obj) {
        synchronized (this.f15493a) {
            this.f15496d++;
            c();
        }
    }

    public final void b() {
        synchronized (this.f15493a) {
            this.f15498f++;
            this.f15500h = true;
            c();
        }
    }

    public final void d(Exception exc) {
        synchronized (this.f15493a) {
            this.f15497e++;
            this.f15499g = exc;
            c();
        }
    }
}
