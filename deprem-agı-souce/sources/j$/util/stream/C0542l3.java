package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.function.Consumer$CC;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* renamed from: j$.util.stream.l3  reason: case insensitive filesystem */
public final /* synthetic */ class C0542l3 implements C0536k2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1740a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IntConsumer f1741b;

    public /* synthetic */ C0542l3(IntConsumer intConsumer, int i5) {
        this.f1740a = i5;
        this.f1741b = intConsumer;
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
        switch (this.f1740a) {
            case 0:
                C0594w1.C();
                throw null;
            default:
                C0594w1.C();
                throw null;
        }
    }

    public final void accept(int i5) {
        switch (this.f1740a) {
            case 0:
                this.f1741b.accept(i5);
                return;
            default:
                ((R2) this.f1741b).accept(i5);
                return;
        }
    }

    public final /* synthetic */ void accept(long j5) {
        switch (this.f1740a) {
            case 0:
                C0594w1.K();
                throw null;
            default:
                C0594w1.K();
                throw null;
        }
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        switch (this.f1740a) {
            case 0:
                d((Integer) obj);
                return;
            default:
                d((Integer) obj);
                return;
        }
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f1740a) {
            case 0:
                return Consumer$CC.$default$andThen(this, consumer);
            default:
                return Consumer$CC.$default$andThen(this, consumer);
        }
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        switch (this.f1740a) {
            case 0:
                return a.e(this, intConsumer);
            default:
                return a.e(this, intConsumer);
        }
    }

    public final /* synthetic */ void c(long j5) {
        int i5 = this.f1740a;
    }

    public final /* synthetic */ void d(Integer num) {
        switch (this.f1740a) {
            case 0:
                C0594w1.F(this, num);
                return;
            default:
                C0594w1.F(this, num);
                return;
        }
    }

    public final /* synthetic */ boolean e() {
        switch (this.f1740a) {
            case 0:
                return false;
            default:
                return false;
        }
    }

    public final /* synthetic */ void end() {
        int i5 = this.f1740a;
    }
}
