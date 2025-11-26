package j$.util.function;

import j$.com.android.tools.r8.a;
import java.util.function.IntConsumer;

public final /* synthetic */ class d implements IntConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IntConsumer f1377a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IntConsumer f1378b;

    public /* synthetic */ d(IntConsumer intConsumer, IntConsumer intConsumer2) {
        this.f1377a = intConsumer;
        this.f1378b = intConsumer2;
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return a.e(this, intConsumer);
    }

    public final void accept(int i5) {
        this.f1377a.accept(i5);
        this.f1378b.accept(i5);
    }
}
