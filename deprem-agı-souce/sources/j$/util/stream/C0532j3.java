package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* renamed from: j$.util.stream.j3  reason: case insensitive filesystem */
public final /* synthetic */ class C0532j3 implements C0531j2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1722a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DoubleConsumer f1723b;

    public /* synthetic */ C0532j3(DoubleConsumer doubleConsumer, int i5) {
        this.f1722a = i5;
        this.f1723b = doubleConsumer;
    }

    private final /* synthetic */ void a(long j5) {
    }

    private final /* synthetic */ void b(long j5) {
    }

    private final /* synthetic */ void f() {
    }

    private final /* synthetic */ void g() {
    }

    public final void accept(double d5) {
        switch (this.f1722a) {
            case 0:
                this.f1723b.accept(d5);
                return;
            default:
                ((P2) this.f1723b).accept(d5);
                return;
        }
    }

    public final /* synthetic */ void accept(int i5) {
        switch (this.f1722a) {
            case 0:
                C0594w1.J();
                throw null;
            default:
                C0594w1.J();
                throw null;
        }
    }

    public final /* synthetic */ void accept(long j5) {
        switch (this.f1722a) {
            case 0:
                C0594w1.K();
                throw null;
            default:
                C0594w1.K();
                throw null;
        }
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        switch (this.f1722a) {
            case 0:
                n((Double) obj);
                return;
            default:
                n((Double) obj);
                return;
        }
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f1722a) {
            case 0:
                return Consumer$CC.$default$andThen(this, consumer);
            default:
                return Consumer$CC.$default$andThen(this, consumer);
        }
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        switch (this.f1722a) {
            case 0:
                return a.d(this, doubleConsumer);
            default:
                return a.d(this, doubleConsumer);
        }
    }

    public final /* synthetic */ void c(long j5) {
        int i5 = this.f1722a;
    }

    public final /* synthetic */ boolean e() {
        switch (this.f1722a) {
            case 0:
                return false;
            default:
                return false;
        }
    }

    public final /* synthetic */ void end() {
        int i5 = this.f1722a;
    }

    public final /* synthetic */ void n(Double d5) {
        switch (this.f1722a) {
            case 0:
                C0594w1.D(this, d5);
                return;
            default:
                C0594w1.D(this, d5);
                return;
        }
    }
}
