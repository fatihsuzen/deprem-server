package m0;

import l0.h;

final class x extends k {

    /* renamed from: c  reason: collision with root package name */
    final transient Object f15609c;

    x(Object obj) {
        this.f15609c = h.h(obj);
    }

    /* access modifiers changed from: package-private */
    public int c(Object[] objArr, int i5) {
        objArr[i5] = this.f15609c;
        return i5 + 1;
    }

    public boolean contains(Object obj) {
        return this.f15609c.equals(obj);
    }

    public final int hashCode() {
        return this.f15609c.hashCode();
    }

    /* renamed from: o */
    public z iterator() {
        return l.b(this.f15609c);
    }

    public int size() {
        return 1;
    }

    public String toString() {
        String obj = this.f15609c.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 2);
        sb.append('[');
        sb.append(obj);
        sb.append(']');
        return sb.toString();
    }
}
