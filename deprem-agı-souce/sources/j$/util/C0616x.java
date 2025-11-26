package j$.util;

import j$.com.android.tools.r8.a;
import java.util.function.DoubleConsumer;

/* renamed from: j$.util.x  reason: case insensitive filesystem */
public final class C0616x implements DoubleConsumer {

    /* renamed from: a  reason: collision with root package name */
    public double f1859a;

    /* renamed from: b  reason: collision with root package name */
    public double f1860b;
    private long count;
    private double max = Double.NEGATIVE_INFINITY;
    private double min = Double.POSITIVE_INFINITY;
    private double sum;

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return a.d(this, doubleConsumer);
    }

    public final void accept(double d5) {
        this.count++;
        this.f1860b += d5;
        b(d5);
        this.min = Math.min(this.min, d5);
        this.max = Math.max(this.max, d5);
    }

    public final void a(C0616x xVar) {
        this.count += xVar.count;
        this.f1860b += xVar.f1860b;
        b(xVar.sum);
        b(xVar.f1859a);
        this.min = Math.min(this.min, xVar.min);
        this.max = Math.max(this.max, xVar.max);
    }

    public final void b(double d5) {
        double d6 = d5 - this.f1859a;
        double d7 = this.sum;
        double d8 = d7 + d6;
        this.f1859a = (d8 - d7) - d6;
        this.sum = d8;
    }

    public final String toString() {
        double d5;
        String simpleName = C0616x.class.getSimpleName();
        Long valueOf = Long.valueOf(this.count);
        double d6 = this.sum + this.f1859a;
        if (Double.isNaN(d6) && Double.isInfinite(this.f1860b)) {
            d6 = this.f1860b;
        }
        Double valueOf2 = Double.valueOf(d6);
        Double valueOf3 = Double.valueOf(this.min);
        if (this.count > 0) {
            double d7 = this.sum + this.f1859a;
            if (Double.isNaN(d7) && Double.isInfinite(this.f1860b)) {
                d7 = this.f1860b;
            }
            d5 = d7 / ((double) this.count);
        } else {
            d5 = 0.0d;
        }
        return String.format("%s{count=%d, sum=%f, min=%f, average=%f, max=%f}", new Object[]{simpleName, valueOf, valueOf2, valueOf3, Double.valueOf(d5), Double.valueOf(this.max)});
    }
}
