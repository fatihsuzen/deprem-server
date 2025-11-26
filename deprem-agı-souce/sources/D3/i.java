package D3;

import w3.Q;

final class i extends h {

    /* renamed from: c  reason: collision with root package name */
    public final Runnable f18084c;

    public i(Runnable runnable, long j5, boolean z4) {
        super(j5, z4);
        this.f18084c = runnable;
    }

    public void run() {
        this.f18084c.run();
    }

    public String toString() {
        return "Task[" + Q.a(this.f18084c) + '@' + Q.b(this.f18084c) + ", " + this.f18082a + ", " + j.c(this.f18083b) + ']';
    }
}
