package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.function.Consumer;

public abstract class J implements G3 {

    /* renamed from: a  reason: collision with root package name */
    public boolean f1502a;

    /* renamed from: b  reason: collision with root package name */
    public Object f1503b;

    public /* synthetic */ void accept(double d5) {
        C0594w1.C();
        throw null;
    }

    public /* synthetic */ void accept(int i5) {
        C0594w1.J();
        throw null;
    }

    public /* synthetic */ void accept(long j5) {
        C0594w1.K();
        throw null;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ void c(long j5) {
    }

    public final /* synthetic */ void end() {
    }

    /* renamed from: accept */
    public final void n(Object obj) {
        if (!this.f1502a) {
            this.f1502a = true;
            this.f1503b = obj;
        }
    }

    public final boolean e() {
        return this.f1502a;
    }
}
