package e4;

import java.io.InterruptedIOException;
import java.util.concurrent.TimeUnit;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public class a0 {

    /* renamed from: d  reason: collision with root package name */
    public static final b f21530d = new b((C2633k) null);

    /* renamed from: e  reason: collision with root package name */
    public static final a0 f21531e = new a();

    /* renamed from: a  reason: collision with root package name */
    private boolean f21532a;

    /* renamed from: b  reason: collision with root package name */
    private long f21533b;

    /* renamed from: c  reason: collision with root package name */
    private long f21534c;

    public static final class b {
        public /* synthetic */ b(C2633k kVar) {
            this();
        }

        private b() {
        }
    }

    public a0 a() {
        this.f21532a = false;
        return this;
    }

    public a0 b() {
        this.f21534c = 0;
        return this;
    }

    public long c() {
        if (this.f21532a) {
            return this.f21533b;
        }
        throw new IllegalStateException("No deadline");
    }

    public a0 d(long j5) {
        this.f21532a = true;
        this.f21533b = j5;
        return this;
    }

    public boolean e() {
        return this.f21532a;
    }

    public void f() {
        if (Thread.currentThread().isInterrupted()) {
            throw new InterruptedIOException("interrupted");
        } else if (this.f21532a && this.f21533b - System.nanoTime() <= 0) {
            throw new InterruptedIOException("deadline reached");
        }
    }

    public a0 g(long j5, TimeUnit timeUnit) {
        t.e(timeUnit, "unit");
        if (j5 >= 0) {
            this.f21534c = timeUnit.toNanos(j5);
            return this;
        }
        throw new IllegalArgumentException(("timeout < 0: " + j5).toString());
    }

    public long h() {
        return this.f21534c;
    }

    public static final class a extends a0 {
        a() {
        }

        public a0 g(long j5, TimeUnit timeUnit) {
            t.e(timeUnit, "unit");
            return this;
        }

        public void f() {
        }

        public a0 d(long j5) {
            return this;
        }
    }
}
