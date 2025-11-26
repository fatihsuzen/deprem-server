package j$.util.stream;

import j$.com.android.tools.r8.a;
import java.util.function.IntConsumer;

/* renamed from: j$.util.stream.d3  reason: case insensitive filesystem */
public final class C0502d3 extends C0512f3 implements IntConsumer {

    /* renamed from: c  reason: collision with root package name */
    public final int[] f1697c;

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return a.e(this, intConsumer);
    }

    public C0502d3(int i5) {
        this.f1697c = new int[i5];
    }

    public final void a(Object obj, long j5) {
        IntConsumer intConsumer = (IntConsumer) obj;
        for (int i5 = 0; ((long) i5) < j5; i5++) {
            intConsumer.accept(this.f1697c[i5]);
        }
    }

    public final void accept(int i5) {
        int i6 = this.f1707b;
        this.f1707b = i6 + 1;
        this.f1697c[i6] = i5;
    }
}
