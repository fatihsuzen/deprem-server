package L3;

import java.util.Arrays;
import kotlin.jvm.internal.t;
import q3.C2729e;

/* renamed from: L3.p  reason: case insensitive filesystem */
public final class C2106p extends K0 {

    /* renamed from: a  reason: collision with root package name */
    private char[] f18567a;

    /* renamed from: b  reason: collision with root package name */
    private int f18568b;

    public C2106p(char[] cArr) {
        t.e(cArr, "bufferWithData");
        this.f18567a = cArr;
        this.f18568b = cArr.length;
        b(10);
    }

    public void b(int i5) {
        char[] cArr = this.f18567a;
        if (cArr.length < i5) {
            char[] copyOf = Arrays.copyOf(cArr, C2729e.c(i5, cArr.length * 2));
            t.d(copyOf, "copyOf(...)");
            this.f18567a = copyOf;
        }
    }

    public int d() {
        return this.f18568b;
    }

    public final void e(char c5) {
        K0.c(this, 0, 1, (Object) null);
        char[] cArr = this.f18567a;
        int d5 = d();
        this.f18568b = d5 + 1;
        cArr[d5] = c5;
    }

    /* renamed from: f */
    public char[] a() {
        char[] copyOf = Arrays.copyOf(this.f18567a, d());
        t.d(copyOf, "copyOf(...)");
        return copyOf;
    }
}
