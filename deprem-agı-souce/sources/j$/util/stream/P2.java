package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.C0469e;
import j$.util.Objects;
import j$.util.W;
import j$.util.k0;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

public class P2 extends V2 implements DoubleConsumer {
    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return a.d(this, doubleConsumer);
    }

    public final void p(Object obj, int i5, int i6, Object obj2) {
        double[] dArr = (double[]) obj;
        DoubleConsumer doubleConsumer = (DoubleConsumer) obj2;
        while (i5 < i6) {
            doubleConsumer.accept(dArr[i5]);
            i5++;
        }
    }

    public final int q(Object obj) {
        return ((double[]) obj).length;
    }

    public final void forEach(Consumer consumer) {
        if (consumer instanceof DoubleConsumer) {
            g((DoubleConsumer) consumer);
        } else if (!H3.f1490a) {
            C0469e.a((O2) spliterator(), consumer);
        } else {
            H3.a(getClass(), "{0} calling SpinedBuffer.OfDouble.forEach(Consumer)");
            throw null;
        }
    }

    public final Object[] t() {
        return new double[8][];
    }

    public final Object newArray(int i5) {
        return new double[i5];
    }

    public void accept(double d5) {
        u();
        int i5 = this.f1677b;
        this.f1677b = i5 + 1;
        ((double[]) this.f1595e)[i5] = d5;
    }

    public final Iterator iterator() {
        W v5 = spliterator();
        Objects.requireNonNull(v5);
        return new k0(v5);
    }

    /* renamed from: v */
    public W spliterator() {
        return new O2(this, 0, this.f1678c, 0, this.f1677b);
    }

    public final String toString() {
        double[] dArr = (double[]) b();
        if (dArr.length < 200) {
            return String.format("%s[length=%d, chunks=%d]%s", new Object[]{getClass().getSimpleName(), Integer.valueOf(dArr.length), Integer.valueOf(this.f1678c), Arrays.toString(dArr)});
        }
        double[] copyOf = Arrays.copyOf(dArr, 200);
        return String.format("%s[length=%d, chunks=%d]%s...", new Object[]{getClass().getSimpleName(), Integer.valueOf(dArr.length), Integer.valueOf(this.f1678c), Arrays.toString(copyOf)});
    }
}
