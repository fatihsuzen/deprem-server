package j$.util;

import j$.com.android.tools.r8.a;
import j$.util.stream.C0546m2;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

public final /* synthetic */ class N implements LongConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1272a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Consumer f1273b;

    public /* synthetic */ N(Consumer consumer, int i5) {
        this.f1272a = i5;
        this.f1273b = consumer;
    }

    public final void accept(long j5) {
        switch (this.f1272a) {
            case 0:
                this.f1273b.accept(Long.valueOf(j5));
                return;
            default:
                ((C0546m2) this.f1273b).accept(j5);
                return;
        }
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        switch (this.f1272a) {
            case 0:
                return a.f(this, longConsumer);
            default:
                return a.f(this, longConsumer);
        }
    }
}
