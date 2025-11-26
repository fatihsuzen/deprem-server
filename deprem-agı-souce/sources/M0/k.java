package m0;

import j$.util.Objects;
import java.util.Arrays;
import java.util.Set;
import l0.h;

public abstract class k extends h implements Set {

    /* renamed from: b  reason: collision with root package name */
    private transient i f15574b;

    k() {
    }

    static int j(int i5) {
        int max = Math.max(i5, 2);
        boolean z4 = true;
        if (max < 751619276) {
            int highestOneBit = Integer.highestOneBit(max - 1) << 1;
            while (((double) highestOneBit) * 0.7d < ((double) max)) {
                highestOneBit <<= 1;
            }
            return highestOneBit;
        }
        if (max >= 1073741824) {
            z4 = false;
        }
        h.e(z4, "collection too large");
        return 1073741824;
    }

    private static k k(int i5, Object... objArr) {
        if (i5 == 0) {
            return p();
        }
        if (i5 != 1) {
            int j5 = j(i5);
            Object[] objArr2 = new Object[j5];
            int i6 = j5 - 1;
            int i7 = 0;
            int i8 = 0;
            for (int i9 = 0; i9 < i5; i9++) {
                Object a5 = q.a(objArr[i9], i9);
                int hashCode = a5.hashCode();
                int a6 = g.a(hashCode);
                while (true) {
                    int i10 = a6 & i6;
                    Object obj = objArr2[i10];
                    if (obj == null) {
                        objArr[i8] = a5;
                        objArr2[i10] = a5;
                        i7 += hashCode;
                        i8++;
                        break;
                    } else if (obj.equals(a5)) {
                        break;
                    } else {
                        a6++;
                    }
                }
            }
            Arrays.fill(objArr, i8, i5, (Object) null);
            if (i8 == 1) {
                Object obj2 = objArr[0];
                Objects.requireNonNull(obj2);
                return new x(obj2);
            } else if (j(i8) < j5 / 2) {
                return k(i8, objArr);
            } else {
                if (t(i8, objArr.length)) {
                    objArr = Arrays.copyOf(objArr, i8);
                }
                return new v(objArr, i7, objArr2, i6, i8);
            }
        } else {
            Object obj3 = objArr[0];
            Objects.requireNonNull(obj3);
            return q(obj3);
        }
    }

    public static k p() {
        return v.f15598i;
    }

    public static k q(Object obj) {
        return new x(obj);
    }

    public static k r(Object obj, Object obj2, Object obj3) {
        return k(3, obj, obj2, obj3);
    }

    public static k s(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object... objArr) {
        boolean z4;
        if (objArr.length <= 2147483641) {
            z4 = true;
        } else {
            z4 = false;
        }
        h.e(z4, "the total number of elements must fit in an int");
        int length = objArr.length + 6;
        Object[] objArr2 = new Object[length];
        objArr2[0] = obj;
        objArr2[1] = obj2;
        objArr2[2] = obj3;
        objArr2[3] = obj4;
        objArr2[4] = obj5;
        objArr2[5] = obj6;
        System.arraycopy(objArr, 0, objArr2, 6, objArr.length);
        return k(length, objArr2);
    }

    private static boolean t(int i5, int i6) {
        if (i5 < (i6 >> 1) + (i6 >> 2)) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof k) || !n() || !((k) obj).n() || hashCode() == obj.hashCode()) {
            return w.a(this, obj);
        }
        return false;
    }

    public int hashCode() {
        return w.b(this);
    }

    public i i() {
        i iVar = this.f15574b;
        if (iVar != null) {
            return iVar;
        }
        i l5 = l();
        this.f15574b = l5;
        return l5;
    }

    /* access modifiers changed from: package-private */
    public i l() {
        return i.i(toArray());
    }

    /* access modifiers changed from: package-private */
    public boolean n() {
        return false;
    }

    public abstract z o();
}
