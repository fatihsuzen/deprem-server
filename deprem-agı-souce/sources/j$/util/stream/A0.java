package j$.util.stream;

import j$.com.android.tools.r8.a;
import java.util.function.DoubleConsumer;

public final /* synthetic */ class A0 implements DoubleConsumer {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f1431a;

    public /* synthetic */ A0(int i5) {
        this.f1431a = i5;
    }

    private final void accept$j$$util$stream$Node$OfDouble$$ExternalSyntheticLambda0(double d5) {
    }

    private final void accept$j$$util$stream$StreamSpliterators$SliceSpliterator$OfDouble$$ExternalSyntheticLambda0(double d5) {
    }

    public final void accept(double d5) {
        int i5 = this.f1431a;
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        switch (this.f1431a) {
            case 0:
                return a.d(this, doubleConsumer);
            default:
                return a.d(this, doubleConsumer);
        }
    }
}
