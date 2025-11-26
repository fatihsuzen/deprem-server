package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.function.Consumer$CC;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* renamed from: j$.util.stream.m1  reason: case insensitive filesystem */
public final class C0545m1 extends C0540l1 implements C0603y0 {
    public final /* synthetic */ void accept(double d5) {
        C0594w1.C();
        throw null;
    }

    public final /* synthetic */ void accept(int i5) {
        C0594w1.J();
        throw null;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        l((Long) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return a.f(this, longConsumer);
    }

    public final /* synthetic */ boolean e() {
        return false;
    }

    public final /* synthetic */ void l(Long l5) {
        C0594w1.H(this, l5);
    }

    public final F0 build() {
        int i5 = this.f1739b;
        long[] jArr = this.f1738a;
        if (i5 >= jArr.length) {
            return this;
        }
        throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", new Object[]{Integer.valueOf(this.f1739b), Integer.valueOf(jArr.length)}));
    }

    public final void c(long j5) {
        long[] jArr = this.f1738a;
        if (j5 == ((long) jArr.length)) {
            this.f1739b = 0;
            return;
        }
        throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", new Object[]{Long.valueOf(j5), Integer.valueOf(jArr.length)}));
    }

    public final void accept(long j5) {
        int i5 = this.f1739b;
        long[] jArr = this.f1738a;
        if (i5 < jArr.length) {
            this.f1739b = i5 + 1;
            jArr[i5] = j5;
            return;
        }
        throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", new Object[]{Integer.valueOf(jArr.length)}));
    }

    public final void end() {
        int i5 = this.f1739b;
        long[] jArr = this.f1738a;
        if (i5 < jArr.length) {
            throw new IllegalStateException(String.format("End size %d is less than fixed size %d", new Object[]{Integer.valueOf(this.f1739b), Integer.valueOf(jArr.length)}));
        }
    }

    public final String toString() {
        long[] jArr = this.f1738a;
        return String.format("LongFixedNodeBuilder[%d][%s]", new Object[]{Integer.valueOf(jArr.length - this.f1739b), Arrays.toString(jArr)});
    }
}
