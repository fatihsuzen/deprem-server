package androidx.collection;

import X2.C2242i;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class CircularArray<E> {
    private int capacityBitmask;
    private E[] elements;
    private int head;
    private int tail;

    public CircularArray() {
        this(0, 1, (C2633k) null);
    }

    private final void doubleCapacity() {
        E[] eArr = this.elements;
        int length = eArr.length;
        int i5 = this.head;
        int i6 = length - i5;
        int i7 = length << 1;
        if (i7 >= 0) {
            E[] eArr2 = new Object[i7];
            C2242i.l(eArr, eArr2, 0, i5, length);
            C2242i.l(this.elements, eArr2, i6, 0, this.head);
            this.elements = eArr2;
            this.head = 0;
            this.tail = length;
            this.capacityBitmask = i7 - 1;
            return;
        }
        throw new RuntimeException("Max array capacity exceeded");
    }

    public final void addFirst(E e5) {
        int i5 = (this.head - 1) & this.capacityBitmask;
        this.head = i5;
        this.elements[i5] = e5;
        if (i5 == this.tail) {
            doubleCapacity();
        }
    }

    public final void addLast(E e5) {
        E[] eArr = this.elements;
        int i5 = this.tail;
        eArr[i5] = e5;
        int i6 = this.capacityBitmask & (i5 + 1);
        this.tail = i6;
        if (i6 == this.head) {
            doubleCapacity();
        }
    }

    public final void clear() {
        removeFromStart(size());
    }

    public final E get(int i5) {
        if (i5 < 0 || i5 >= size()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        E e5 = this.elements[this.capacityBitmask & (this.head + i5)];
        t.b(e5);
        return e5;
    }

    public final E getFirst() {
        int i5 = this.head;
        if (i5 != this.tail) {
            E e5 = this.elements[i5];
            t.b(e5);
            return e5;
        }
        CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final E getLast() {
        int i5 = this.head;
        int i6 = this.tail;
        if (i5 != i6) {
            E e5 = this.elements[(i6 - 1) & this.capacityBitmask];
            t.b(e5);
            return e5;
        }
        CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final boolean isEmpty() {
        if (this.head == this.tail) {
            return true;
        }
        return false;
    }

    public final E popFirst() {
        int i5 = this.head;
        if (i5 != this.tail) {
            E[] eArr = this.elements;
            E e5 = eArr[i5];
            eArr[i5] = null;
            this.head = (i5 + 1) & this.capacityBitmask;
            return e5;
        }
        CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final E popLast() {
        int i5 = this.head;
        int i6 = this.tail;
        if (i5 != i6) {
            int i7 = this.capacityBitmask & (i6 - 1);
            E[] eArr = this.elements;
            E e5 = eArr[i7];
            eArr[i7] = null;
            this.tail = i7;
            return e5;
        }
        CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final void removeFromEnd(int i5) {
        int i6;
        if (i5 > 0) {
            if (i5 <= size()) {
                int i7 = this.tail;
                if (i5 < i7) {
                    i6 = i7 - i5;
                } else {
                    i6 = 0;
                }
                for (int i8 = i6; i8 < i7; i8++) {
                    this.elements[i8] = null;
                }
                int i9 = this.tail;
                int i10 = i9 - i6;
                int i11 = i5 - i10;
                this.tail = i9 - i10;
                if (i11 > 0) {
                    int length = this.elements.length;
                    this.tail = length;
                    int i12 = length - i11;
                    for (int i13 = i12; i13 < length; i13++) {
                        this.elements[i13] = null;
                    }
                    this.tail = i12;
                    return;
                }
                return;
            }
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public final void removeFromStart(int i5) {
        if (i5 > 0) {
            if (i5 <= size()) {
                int length = this.elements.length;
                int i6 = this.head;
                if (i5 < length - i6) {
                    length = i6 + i5;
                }
                while (i6 < length) {
                    this.elements[i6] = null;
                    i6++;
                }
                int i7 = this.head;
                int i8 = length - i7;
                int i9 = i5 - i8;
                this.head = this.capacityBitmask & (i7 + i8);
                if (i9 > 0) {
                    for (int i10 = 0; i10 < i9; i10++) {
                        this.elements[i10] = null;
                    }
                    this.head = i9;
                    return;
                }
                return;
            }
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public final int size() {
        return (this.tail - this.head) & this.capacityBitmask;
    }

    public CircularArray(int i5) {
        if (i5 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        } else if (i5 <= 1073741824) {
            i5 = Integer.bitCount(i5) != 1 ? Integer.highestOneBit(i5 - 1) << 1 : i5;
            this.capacityBitmask = i5 - 1;
            this.elements = new Object[i5];
        } else {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CircularArray(int i5, int i6, C2633k kVar) {
        this((i6 & 1) != 0 ? 8 : i5);
    }
}
