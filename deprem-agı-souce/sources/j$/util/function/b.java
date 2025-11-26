package j$.util.function;

import j$.com.android.tools.r8.a;
import java.util.function.DoubleConsumer;

public final /* synthetic */ class b implements DoubleConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ DoubleConsumer f1372a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ DoubleConsumer f1373b;

    public /* synthetic */ b(DoubleConsumer doubleConsumer, DoubleConsumer doubleConsumer2) {
        this.f1372a = doubleConsumer;
        this.f1373b = doubleConsumer2;
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return a.d(this, doubleConsumer);
    }

    public final void accept(double d5) {
        this.f1372a.accept(d5);
        this.f1373b.accept(d5);
    }
}
