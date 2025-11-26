package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;

public final /* synthetic */ class C3 implements C0546m2 {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1455a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Consumer f1456b;

    public /* synthetic */ C3(Consumer consumer, int i5) {
        this.f1455a = i5;
        this.f1456b = consumer;
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
        switch (this.f1455a) {
            case 0:
                C0594w1.C();
                throw null;
            default:
                C0594w1.C();
                throw null;
        }
    }

    public final /* synthetic */ void accept(int i5) {
        switch (this.f1455a) {
            case 0:
                C0594w1.J();
                throw null;
            default:
                C0594w1.J();
                throw null;
        }
    }

    public final /* synthetic */ void accept(long j5) {
        switch (this.f1455a) {
            case 0:
                C0594w1.K();
                throw null;
            default:
                C0594w1.K();
                throw null;
        }
    }

    public final void accept(Object obj) {
        switch (this.f1455a) {
            case 0:
                ((W2) this.f1456b).accept(obj);
                return;
            default:
                this.f1456b.accept(obj);
                return;
        }
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        switch (this.f1455a) {
            case 0:
                return Consumer$CC.$default$andThen(this, consumer);
            default:
                return Consumer$CC.$default$andThen(this, consumer);
        }
    }

    public final /* synthetic */ void c(long j5) {
        int i5 = this.f1455a;
    }

    public final /* synthetic */ boolean e() {
        switch (this.f1455a) {
            case 0:
                return false;
            default:
                return false;
        }
    }

    public final /* synthetic */ void end() {
        int i5 = this.f1455a;
    }
}
