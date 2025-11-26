package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.C0469e;
import j$.util.Objects;
import j$.util.Z;
import j$.util.i0;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

public class R2 extends V2 implements IntConsumer {
    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return a.e(this, intConsumer);
    }

    public final void p(Object obj, int i5, int i6, Object obj2) {
        int[] iArr = (int[]) obj;
        IntConsumer intConsumer = (IntConsumer) obj2;
        while (i5 < i6) {
            intConsumer.accept(iArr[i5]);
            i5++;
        }
    }

    public final int q(Object obj) {
        return ((int[]) obj).length;
    }

    public final void forEach(Consumer consumer) {
        if (consumer instanceof IntConsumer) {
            g((IntConsumer) consumer);
        } else if (!H3.f1490a) {
            C0469e.b((Q2) spliterator(), consumer);
        } else {
            H3.a(getClass(), "{0} calling SpinedBuffer.OfInt.forEach(Consumer)");
            throw null;
        }
    }

    public final Object[] t() {
        return new int[8][];
    }

    public final Object newArray(int i5) {
        return new int[i5];
    }

    public void accept(int i5) {
        u();
        int i6 = this.f1677b;
        this.f1677b = i6 + 1;
        ((int[]) this.f1595e)[i6] = i5;
    }

    public final Iterator iterator() {
        Z v5 = spliterator();
        Objects.requireNonNull(v5);
        return new i0(v5);
    }

    /* renamed from: v */
    public Z spliterator() {
        return new Q2(this, 0, this.f1678c, 0, this.f1677b);
    }

    public final String toString() {
        int[] iArr = (int[]) b();
        if (iArr.length < 200) {
            return String.format("%s[length=%d, chunks=%d]%s", new Object[]{getClass().getSimpleName(), Integer.valueOf(iArr.length), Integer.valueOf(this.f1678c), Arrays.toString(iArr)});
        }
        int[] copyOf = Arrays.copyOf(iArr, 200);
        return String.format("%s[length=%d, chunks=%d]%s...", new Object[]{getClass().getSimpleName(), Integer.valueOf(iArr.length), Integer.valueOf(this.f1678c), Arrays.toString(copyOf)});
    }
}
