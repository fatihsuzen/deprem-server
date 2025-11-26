package j$.util;

import j$.com.android.tools.r8.a;
import j$.util.stream.C0546m2;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

public final /* synthetic */ class F implements DoubleConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1264a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Consumer f1265b;

    public /* synthetic */ F(Consumer consumer, int i5) {
        this.f1264a = i5;
        this.f1265b = consumer;
    }

    public final void accept(double d5) {
        switch (this.f1264a) {
            case 0:
                this.f1265b.accept(Double.valueOf(d5));
                return;
            default:
                ((C0546m2) this.f1265b).accept(d5);
                return;
        }
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        switch (this.f1264a) {
            case 0:
                return a.d(this, doubleConsumer);
            default:
                return a.d(this, doubleConsumer);
        }
    }
}
