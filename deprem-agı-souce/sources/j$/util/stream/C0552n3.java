package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* renamed from: j$.util.stream.n3  reason: case insensitive filesystem */
public final /* synthetic */ class C0552n3 implements C0541l2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1748a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ LongConsumer f1749b;

    public /* synthetic */ C0552n3(LongConsumer longConsumer, int i5) {
        this.f1748a = i5;
        this.f1749b = longConsumer;
    }

    private final /* synthetic */ void a(long j5) {
    }

    private final /* synthetic */ void b(long j5) {
    }

    private final /* synthetic */ void f() {
    }

    private final /* synthetic */ void g() {
    }

    public final /* synthetic */ void accept(double d5) {
        switch (this.f1748a) {
            case 0:
                C0594w1.C();
                throw null;
            default:
                C0594w1.C();
                throw null;
        }
    }

    public final /* synthetic */ void accept(int i5) {
        switch (this.f1748a) {
            case 0:
                C0594w1.J();
                throw null;
            default:
                C0594w1.J();
                throw null;
        }
    }

    public final void accept(long j5) {
        switch (this.f1748a) {
            case 0:
                this.f1749b.accept(j5);
                return;
            default:
                ((T2) this.f1749b).accept(j5);
                return;
        }
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        switch (this.f1748a) {
            case 0:
                l((Long) obj);
                return;
            default:
                l((Long) obj);
                return;
        }
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f1748a) {
            case 0:
                return Consumer$CC.$default$andThen(this, consumer);
            default:
                return Consumer$CC.$default$andThen(this, consumer);
        }
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        switch (this.f1748a) {
            case 0:
                return a.f(this, longConsumer);
            default:
                return a.f(this, longConsumer);
        }
    }

    public final /* synthetic */ void c(long j5) {
        int i5 = this.f1748a;
    }

    public final /* synthetic */ boolean e() {
        switch (this.f1748a) {
            case 0:
                return false;
            default:
                return false;
        }
    }

    public final /* synthetic */ void end() {
        int i5 = this.f1748a;
    }

    public final /* synthetic */ void l(Long l5) {
        switch (this.f1748a) {
            case 0:
                C0594w1.H(this, l5);
                return;
            default:
                C0594w1.H(this, l5);
                return;
        }
    }
}
