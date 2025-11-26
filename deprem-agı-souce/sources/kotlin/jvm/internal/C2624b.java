package kotlin.jvm.internal;

import java.util.Iterator;
import java.util.NoSuchElementException;
import l3.C2677a;

/* renamed from: kotlin.jvm.internal.b  reason: case insensitive filesystem */
final class C2624b implements Iterator, C2677a {

    /* renamed from: a  reason: collision with root package name */
    private final Object[] f24703a;

    /* renamed from: b  reason: collision with root package name */
    private int f24704b;

    public C2624b(Object[] objArr) {
        t.e(objArr, "array");
        this.f24703a = objArr;
    }

    public boolean hasNext() {
        if (this.f24704b < this.f24703a.length) {
            return true;
        }
        return false;
    }

    public Object next() {
        try {
            Object[] objArr = this.f24703a;
            int i5 = this.f24704b;
            this.f24704b = i5 + 1;
            return objArr[i5];
        } catch (ArrayIndexOutOfBoundsException e5) {
            this.f24704b--;
            throw new NoSuchElementException(e5.getMessage());
        }
    }

    public void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
