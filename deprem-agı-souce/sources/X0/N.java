package x0;

import java.util.concurrent.atomic.AtomicInteger;

public final class N {

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f16827a = new AtomicInteger();

    /* renamed from: b  reason: collision with root package name */
    private final AtomicInteger f16828b = new AtomicInteger();

    public void a() {
        this.f16828b.getAndIncrement();
    }

    public void b() {
        this.f16827a.getAndIncrement();
    }

    public void c() {
        this.f16828b.set(0);
    }
}
