package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.Spliterator;
import java.util.function.DoubleConsumer;

/* renamed from: j$.util.stream.o1  reason: case insensitive filesystem */
public final class C0555o1 extends C0574s1 implements C0531j2 {

    /* renamed from: h  reason: collision with root package name */
    public final double[] f1753h;

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        n((Double) obj);
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return a.d(this, doubleConsumer);
    }

    public final /* synthetic */ void n(Double d5) {
        C0594w1.D(this, d5);
    }

    public C0555o1(Spliterator spliterator, C0594w1 w1Var, double[] dArr) {
        super(spliterator, w1Var, dArr.length);
        this.f1753h = dArr;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C0555o1(j$.util.stream.C0555o1 r10, j$.util.Spliterator r11, long r12, long r14) {
        /*
            r9 = this;
            double[] r0 = r10.f1753h
            int r8 = r0.length
            r1 = r9
            r2 = r10
            r3 = r11
            r4 = r12
            r6 = r14
            r1.<init>(r2, r3, r4, r6, r8)
            double[] r10 = r2.f1753h
            r1.f1753h = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: j$.util.stream.C0555o1.<init>(j$.util.stream.o1, j$.util.Spliterator, long, long):void");
    }

    public final C0574s1 a(Spliterator spliterator, long j5, long j6) {
        return new C0555o1(this, spliterator, j5, j6);
    }

    public final void accept(double d5) {
        int i5 = this.f1781f;
        if (i5 < this.f1782g) {
            double[] dArr = this.f1753h;
            this.f1781f = i5 + 1;
            dArr[i5] = d5;
            return;
        }
        throw new IndexOutOfBoundsException(Integer.toString(this.f1781f));
    }
}
