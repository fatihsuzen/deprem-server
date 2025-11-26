package L3;

import java.util.Arrays;
import kotlin.jvm.internal.t;
import q3.C2729e;

public final class U extends K0 {

    /* renamed from: a  reason: collision with root package name */
    private int[] f18486a;

    /* renamed from: b  reason: collision with root package name */
    private int f18487b;

    public U(int[] iArr) {
        t.e(iArr, "bufferWithData");
        this.f18486a = iArr;
        this.f18487b = iArr.length;
        b(10);
    }

    public void b(int i5) {
        int[] iArr = this.f18486a;
        if (iArr.length < i5) {
            int[] copyOf = Arrays.copyOf(iArr, C2729e.c(i5, iArr.length * 2));
            t.d(copyOf, "copyOf(...)");
            this.f18486a = copyOf;
        }
    }

    public int d() {
        return this.f18487b;
    }

    public final void e(int i5) {
        K0.c(this, 0, 1, (Object) null);
        int[] iArr = this.f18486a;
        int d5 = d();
        this.f18487b = d5 + 1;
        iArr[d5] = i5;
    }

    /* renamed from: f */
    public int[] a() {
        int[] copyOf = Arrays.copyOf(this.f18486a, d());
        t.d(copyOf, "copyOf(...)");
        return copyOf;
    }
}
