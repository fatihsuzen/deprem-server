package j$.util;

import j$.com.android.tools.r8.a;
import j$.util.stream.C0546m2;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public final /* synthetic */ class J implements IntConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1268a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Consumer f1269b;

    public /* synthetic */ J(Consumer consumer, int i5) {
        this.f1268a = i5;
        this.f1269b = consumer;
    }

    public final void accept(int i5) {
        switch (this.f1268a) {
            case 0:
                this.f1269b.accept(Integer.valueOf(i5));
                return;
            default:
                ((C0546m2) this.f1269b).accept(i5);
                return;
        }
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        switch (this.f1268a) {
            case 0:
                return a.e(this, intConsumer);
            default:
                return a.e(this, intConsumer);
        }
    }
}
