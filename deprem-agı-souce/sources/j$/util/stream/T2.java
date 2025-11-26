package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.C0469e;
import j$.util.Objects;
import j$.util.c0;
import j$.util.j0;
import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

public class T2 extends V2 implements LongConsumer {
    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return a.f(this, longConsumer);
    }

    public final void p(Object obj, int i5, int i6, Object obj2) {
        long[] jArr = (long[]) obj;
        LongConsumer longConsumer = (LongConsumer) obj2;
        while (i5 < i6) {
            longConsumer.accept(jArr[i5]);
            i5++;
        }
    }

    public final int q(Object obj) {
        return ((long[]) obj).length;
    }

    public final void forEach(Consumer consumer) {
        if (consumer instanceof LongConsumer) {
            g((LongConsumer) consumer);
        } else if (!H3.f1490a) {
            C0469e.c((S2) spliterator(), consumer);
        } else {
            H3.a(getClass(), "{0} calling SpinedBuffer.OfLong.forEach(Consumer)");
            throw null;
        }
    }

    public final Object[] t() {
        return new long[8][];
    }

    public final Object newArray(int i5) {
        return new long[i5];
    }

    public void accept(long j5) {
        u();
        int i5 = this.f1677b;
        this.f1677b = i5 + 1;
        ((long[]) this.f1595e)[i5] = j5;
    }

    public final Iterator iterator() {
        c0 v5 = spliterator();
        Objects.requireNonNull(v5);
        return new j0(v5);
    }

    /* renamed from: v */
    public c0 spliterator() {
        return new S2(this, 0, this.f1678c, 0, this.f1677b);
    }

    public final String toString() {
        long[] jArr = (long[]) b();
        if (jArr.length < 200) {
            return String.format("%s[length=%d, chunks=%d]%s", new Object[]{getClass().getSimpleName(), Integer.valueOf(jArr.length), Integer.valueOf(this.f1678c), Arrays.toString(jArr)});
        }
        long[] copyOf = Arrays.copyOf(jArr, 200);
        return String.format("%s[length=%d, chunks=%d]%s...", new Object[]{getClass().getSimpleName(), Integer.valueOf(jArr.length), Integer.valueOf(this.f1678c), Arrays.toString(copyOf)});
    }
}
