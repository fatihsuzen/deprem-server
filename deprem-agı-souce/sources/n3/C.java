package N3;

import J3.f;
import J3.o;
import java.util.Arrays;
import kotlin.jvm.internal.t;

public final class C {

    /* renamed from: a  reason: collision with root package name */
    private Object[] f18710a = new Object[8];

    /* renamed from: b  reason: collision with root package name */
    private int[] f18711b;

    /* renamed from: c  reason: collision with root package name */
    private int f18712c;

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f18713a = new a();

        private a() {
        }
    }

    public C() {
        int[] iArr = new int[8];
        for (int i5 = 0; i5 < 8; i5++) {
            iArr[i5] = -1;
        }
        this.f18711b = iArr;
        this.f18712c = -1;
    }

    private final void e() {
        int i5 = this.f18712c * 2;
        Object[] copyOf = Arrays.copyOf(this.f18710a, i5);
        t.d(copyOf, "copyOf(...)");
        this.f18710a = copyOf;
        int[] copyOf2 = Arrays.copyOf(this.f18711b, i5);
        t.d(copyOf2, "copyOf(...)");
        this.f18711b = copyOf2;
    }

    public final String a() {
        StringBuilder sb = new StringBuilder();
        sb.append("$");
        int i5 = this.f18712c + 1;
        for (int i6 = 0; i6 < i5; i6++) {
            Object obj = this.f18710a[i6];
            if (obj instanceof f) {
                f fVar = (f) obj;
                if (!t.a(fVar.getKind(), o.b.f18391a)) {
                    int i7 = this.f18711b[i6];
                    if (i7 >= 0) {
                        sb.append(".");
                        sb.append(fVar.f(i7));
                    }
                } else if (this.f18711b[i6] != -1) {
                    sb.append("[");
                    sb.append(this.f18711b[i6]);
                    sb.append("]");
                }
            } else if (obj != a.f18713a) {
                sb.append("[");
                sb.append("'");
                sb.append(obj);
                sb.append("'");
                sb.append("]");
            }
        }
        String sb2 = sb.toString();
        t.d(sb2, "toString(...)");
        return sb2;
    }

    public final void b() {
        int i5 = this.f18712c;
        int[] iArr = this.f18711b;
        if (iArr[i5] == -2) {
            iArr[i5] = -1;
            this.f18712c = i5 - 1;
        }
        int i6 = this.f18712c;
        if (i6 != -1) {
            this.f18712c = i6 - 1;
        }
    }

    public final void c(f fVar) {
        t.e(fVar, "sd");
        int i5 = this.f18712c + 1;
        this.f18712c = i5;
        if (i5 == this.f18710a.length) {
            e();
        }
        this.f18710a[i5] = fVar;
    }

    public final void d() {
        int[] iArr = this.f18711b;
        int i5 = this.f18712c;
        if (iArr[i5] == -2) {
            this.f18710a[i5] = a.f18713a;
        }
    }

    public final void f(Object obj) {
        int[] iArr = this.f18711b;
        int i5 = this.f18712c;
        if (iArr[i5] != -2) {
            int i6 = i5 + 1;
            this.f18712c = i6;
            if (i6 == this.f18710a.length) {
                e();
            }
        }
        Object[] objArr = this.f18710a;
        int i7 = this.f18712c;
        objArr[i7] = obj;
        this.f18711b[i7] = -2;
    }

    public final void g(int i5) {
        this.f18711b[this.f18712c] = i5;
    }

    public String toString() {
        return a();
    }
}
