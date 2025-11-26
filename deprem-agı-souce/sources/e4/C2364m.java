package e4;

import kotlin.jvm.internal.t;

/* renamed from: e4.m  reason: case insensitive filesystem */
public abstract class C2364m implements Z {

    /* renamed from: a  reason: collision with root package name */
    private final Z f21594a;

    public C2364m(Z z4) {
        t.e(z4, "delegate");
        this.f21594a = z4;
    }

    public final Z a() {
        return this.f21594a;
    }

    public void close() {
        this.f21594a.close();
    }

    public long e(C2356e eVar, long j5) {
        t.e(eVar, "sink");
        return this.f21594a.e(eVar, j5);
    }

    public a0 timeout() {
        return this.f21594a.timeout();
    }

    public String toString() {
        return getClass().getSimpleName() + '(' + this.f21594a + ')';
    }
}
