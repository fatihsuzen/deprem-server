package L3;

import java.util.Arrays;
import kotlin.jvm.internal.t;
import q3.C2729e;

public final class J extends K0 {

    /* renamed from: a  reason: collision with root package name */
    private float[] f18464a;

    /* renamed from: b  reason: collision with root package name */
    private int f18465b;

    public J(float[] fArr) {
        t.e(fArr, "bufferWithData");
        this.f18464a = fArr;
        this.f18465b = fArr.length;
        b(10);
    }

    public void b(int i5) {
        float[] fArr = this.f18464a;
        if (fArr.length < i5) {
            float[] copyOf = Arrays.copyOf(fArr, C2729e.c(i5, fArr.length * 2));
            t.d(copyOf, "copyOf(...)");
            this.f18464a = copyOf;
        }
    }

    public int d() {
        return this.f18465b;
    }

    public final void e(float f5) {
        K0.c(this, 0, 1, (Object) null);
        float[] fArr = this.f18464a;
        int d5 = d();
        this.f18465b = d5 + 1;
        fArr[d5] = f5;
    }

    /* renamed from: f */
    public float[] a() {
        float[] copyOf = Arrays.copyOf(this.f18464a, d());
        t.d(copyOf, "copyOf(...)");
        return copyOf;
    }
}
