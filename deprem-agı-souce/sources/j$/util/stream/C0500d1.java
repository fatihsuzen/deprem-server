package j$.util.stream;

import j$.com.android.tools.r8.a;
import j$.util.function.Consumer$CC;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* renamed from: j$.util.stream.d1  reason: case insensitive filesystem */
public final class C0500d1 extends C0495c1 implements C0598x0 {
    public final /* synthetic */ void accept(double d5) {
        C0594w1.C();
        throw null;
    }

    public final /* synthetic */ void accept(long j5) {
        C0594w1.K();
        throw null;
    }

    public final /* bridge */ /* synthetic */ void accept(Object obj) {
        d((Integer) obj);
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return a.e(this, intConsumer);
    }

    public final /* synthetic */ void d(Integer num) {
        C0594w1.F(this, num);
    }

    public final /* synthetic */ boolean e() {
        return false;
    }

    public final D0 build() {
        int i5 = this.f1682b;
        int[] iArr = this.f1681a;
        if (i5 >= iArr.length) {
            return this;
        }
        throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", new Object[]{Integer.valueOf(this.f1682b), Integer.valueOf(iArr.length)}));
    }

    public final void c(long j5) {
        int[] iArr = this.f1681a;
        if (j5 == ((long) iArr.length)) {
            this.f1682b = 0;
            return;
        }
        throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", new Object[]{Long.valueOf(j5), Integer.valueOf(iArr.length)}));
    }

    public final void accept(int i5) {
        int i6 = this.f1682b;
        int[] iArr = this.f1681a;
        if (i6 < iArr.length) {
            this.f1682b = i6 + 1;
            iArr[i6] = i5;
            return;
        }
        throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", new Object[]{Integer.valueOf(iArr.length)}));
    }

    public final void end() {
        int i5 = this.f1682b;
        int[] iArr = this.f1681a;
        if (i5 < iArr.length) {
            throw new IllegalStateException(String.format("End size %d is less than fixed size %d", new Object[]{Integer.valueOf(this.f1682b), Integer.valueOf(iArr.length)}));
        }
    }

    public final String toString() {
        int[] iArr = this.f1681a;
        return String.format("IntFixedNodeBuilder[%d][%s]", new Object[]{Integer.valueOf(iArr.length - this.f1682b), Arrays.toString(iArr)});
    }
}
