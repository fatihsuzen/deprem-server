package j$.util;

import j$.com.android.tools.r8.a;
import java.util.function.IntConsumer;

/* renamed from: j$.util.y  reason: case insensitive filesystem */
public final class C0617y implements IntConsumer {
    private long count;
    private int max = Integer.MIN_VALUE;
    private int min = Integer.MAX_VALUE;
    private long sum;

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return a.e(this, intConsumer);
    }

    public final void accept(int i5) {
        this.count++;
        this.sum += (long) i5;
        this.min = Math.min(this.min, i5);
        this.max = Math.max(this.max, i5);
    }

    public final void a(C0617y yVar) {
        this.count += yVar.count;
        this.sum += yVar.sum;
        this.min = Math.min(this.min, yVar.min);
        this.max = Math.max(this.max, yVar.max);
    }

    public final String toString() {
        String simpleName = C0617y.class.getSimpleName();
        Long valueOf = Long.valueOf(this.count);
        Long valueOf2 = Long.valueOf(this.sum);
        Integer valueOf3 = Integer.valueOf(this.min);
        long j5 = this.count;
        return String.format("%s{count=%d, sum=%d, min=%d, average=%f, max=%d}", new Object[]{simpleName, valueOf, valueOf2, valueOf3, Double.valueOf(j5 > 0 ? ((double) this.sum) / ((double) j5) : 0.0d), Integer.valueOf(this.max)});
    }
}
