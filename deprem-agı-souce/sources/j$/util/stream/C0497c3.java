package j$.util.stream;

import j$.com.android.tools.r8.a;
import java.util.function.DoubleConsumer;

/* renamed from: j$.util.stream.c3  reason: case insensitive filesystem */
public final class C0497c3 extends C0512f3 implements DoubleConsumer {

    /* renamed from: c  reason: collision with root package name */
    public final double[] f1683c;

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return a.d(this, doubleConsumer);
    }

    public C0497c3(int i5) {
        this.f1683c = new double[i5];
    }

    public final void a(Object obj, long j5) {
        DoubleConsumer doubleConsumer = (DoubleConsumer) obj;
        for (int i5 = 0; ((long) i5) < j5; i5++) {
            doubleConsumer.accept(this.f1683c[i5]);
        }
    }

    public final void accept(double d5) {
        int i5 = this.f1707b;
        this.f1707b = i5 + 1;
        this.f1683c[i5] = d5;
    }
}
