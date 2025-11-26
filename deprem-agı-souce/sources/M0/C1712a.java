package m0;

import java.util.NoSuchElementException;
import l0.h;

/* renamed from: m0.a  reason: case insensitive filesystem */
abstract class C1712a extends C1711A {

    /* renamed from: a  reason: collision with root package name */
    private final int f15540a;

    /* renamed from: b  reason: collision with root package name */
    private int f15541b;

    protected C1712a(int i5, int i6) {
        h.j(i6, i5);
        this.f15540a = i5;
        this.f15541b = i6;
    }

    /* access modifiers changed from: protected */
    public abstract Object a(int i5);

    public final boolean hasNext() {
        if (this.f15541b < this.f15540a) {
            return true;
        }
        return false;
    }

    public final boolean hasPrevious() {
        if (this.f15541b > 0) {
            return true;
        }
        return false;
    }

    public final Object next() {
        if (hasNext()) {
            int i5 = this.f15541b;
            this.f15541b = i5 + 1;
            return a(i5);
        }
        throw new NoSuchElementException();
    }

    public final int nextIndex() {
        return this.f15541b;
    }

    public final Object previous() {
        if (hasPrevious()) {
            int i5 = this.f15541b - 1;
            this.f15541b = i5;
            return a(i5);
        }
        throw new NoSuchElementException();
    }

    public final int previousIndex() {
        return this.f15541b - 1;
    }
}
