package j$.util.stream;

import j$.util.function.Consumer$CC;
import java.util.Arrays;
import java.util.function.Consumer;

/* renamed from: j$.util.stream.b1  reason: case insensitive filesystem */
public final class C0490b1 extends K0 implements C0608z0 {
    public final /* synthetic */ void accept(double d5) {
        C0594w1.C();
        throw null;
    }

    public final /* synthetic */ void accept(int i5) {
        C0594w1.J();
        throw null;
    }

    public final /* synthetic */ void accept(long j5) {
        C0594w1.K();
        throw null;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return Consumer$CC.$default$andThen(this, consumer);
    }

    public final /* synthetic */ boolean e() {
        return false;
    }

    public final H0 build() {
        int i5 = this.f1519b;
        Object[] objArr = this.f1518a;
        if (i5 >= objArr.length) {
            return this;
        }
        throw new IllegalStateException(String.format("Current size %d is less than fixed size %d", new Object[]{Integer.valueOf(this.f1519b), Integer.valueOf(objArr.length)}));
    }

    public final void c(long j5) {
        Object[] objArr = this.f1518a;
        if (j5 == ((long) objArr.length)) {
            this.f1519b = 0;
            return;
        }
        throw new IllegalStateException(String.format("Begin size %d is not equal to fixed size %d", new Object[]{Long.valueOf(j5), Integer.valueOf(objArr.length)}));
    }

    public final void accept(Object obj) {
        int i5 = this.f1519b;
        Object[] objArr = this.f1518a;
        if (i5 < objArr.length) {
            this.f1519b = i5 + 1;
            objArr[i5] = obj;
            return;
        }
        throw new IllegalStateException(String.format("Accept exceeded fixed size of %d", new Object[]{Integer.valueOf(objArr.length)}));
    }

    public final void end() {
        int i5 = this.f1519b;
        Object[] objArr = this.f1518a;
        if (i5 < objArr.length) {
            throw new IllegalStateException(String.format("End size %d is less than fixed size %d", new Object[]{Integer.valueOf(this.f1519b), Integer.valueOf(objArr.length)}));
        }
    }

    public final String toString() {
        Object[] objArr = this.f1518a;
        return String.format("FixedNodeBuilder[%d][%s]", new Object[]{Integer.valueOf(objArr.length - this.f1519b), Arrays.toString(objArr)});
    }
}
