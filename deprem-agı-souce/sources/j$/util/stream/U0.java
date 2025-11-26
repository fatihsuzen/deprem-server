package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.function.Consumer$CC;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

public final class U0 extends T0 implements C0593w0 {
    public final /* synthetic */ void accept(int i5) {
        C0594w1.J();
        throw null;
    }

    public final /* synthetic */ void accept(long j5) {
        C0594w1.K();
        throw null;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        n((Double) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return a.d(this, doubleConsumer);
    }

    public final /* synthetic */ boolean e() {
        return false;
    }

    public final /* synthetic */ void n(Double d5) {
        C0594w1.D(this, d5);
    }

    public final B0 build() {
        int i5 = this.f1584b;
        double[] dArr = this.f1583a;
        if (i5 >= dArr.length) {
            return this;
        }
        throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", new Object[]{Integer.valueOf(this.f1584b), Integer.valueOf(dArr.length)}));
    }

    public final void c(long j5) {
        double[] dArr = this.f1583a;
        if (j5 == ((long) dArr.length)) {
            this.f1584b = 0;
            return;
        }
        throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", new Object[]{Long.valueOf(j5), Integer.valueOf(dArr.length)}));
    }

    public final void accept(double d5) {
        int i5 = this.f1584b;
        double[] dArr = this.f1583a;
        if (i5 < dArr.length) {
            this.f1584b = i5 + 1;
            dArr[i5] = d5;
            return;
        }
        throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", new Object[]{Integer.valueOf(dArr.length)}));
    }

    public final void end() {
        int i5 = this.f1584b;
        double[] dArr = this.f1583a;
        if (i5 < dArr.length) {
            throw new IllegalStateException(String.format("End size %d is less than fixed size %d", new Object[]{Integer.valueOf(this.f1584b), Integer.valueOf(dArr.length)}));
        }
    }

    public final String toString() {
        double[] dArr = this.f1583a;
        return String.format("DoubleFixedNodeBuilder[%d][%s]", new Object[]{Integer.valueOf(dArr.length - this.f1584b), Arrays.toString(dArr)});
    }
}
