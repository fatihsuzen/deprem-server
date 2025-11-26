package j$.util.stream;

import j$.com.android.tools.r8.a;
import java.util.function.LongConsumer;

/* renamed from: j$.util.stream.e3  reason: case insensitive filesystem */
public final class C0507e3 extends C0512f3 implements LongConsumer {

    /* renamed from: c  reason: collision with root package name */
    public final long[] f1701c;

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return a.f(this, longConsumer);
    }

    public C0507e3(int i5) {
        this.f1701c = new long[i5];
    }

    public final void a(Object obj, long j5) {
        LongConsumer longConsumer = (LongConsumer) obj;
        for (int i5 = 0; ((long) i5) < j5; i5++) {
            longConsumer.accept(this.f1701c[i5]);
        }
    }

    public final void accept(long j5) {
        int i5 = this.f1707b;
        this.f1707b = i5 + 1;
        this.f1701c[i5] = j5;
    }
}
