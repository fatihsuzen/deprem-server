package m0;

import j$.util.Objects;
import l0.h;

class t extends i {

    /* renamed from: e  reason: collision with root package name */
    static final i f15580e = new t(new Object[0], 0);

    /* renamed from: c  reason: collision with root package name */
    final transient Object[] f15581c;

    /* renamed from: d  reason: collision with root package name */
    private final transient int f15582d;

    t(Object[] objArr, int i5) {
        this.f15581c = objArr;
        this.f15582d = i5;
    }

    /* access modifiers changed from: package-private */
    public int c(Object[] objArr, int i5) {
        System.arraycopy(this.f15581c, 0, objArr, i5, this.f15582d);
        return i5 + this.f15582d;
    }

    /* access modifiers changed from: package-private */
    public Object[] d() {
        return this.f15581c;
    }

    /* access modifiers changed from: package-private */
    public int f() {
        return this.f15582d;
    }

    /* access modifiers changed from: package-private */
    public int g() {
        return 0;
    }

    public Object get(int i5) {
        h.f(i5, this.f15582d);
        Object obj = this.f15581c[i5];
        Objects.requireNonNull(obj);
        return obj;
    }

    public int size() {
        return this.f15582d;
    }
}
