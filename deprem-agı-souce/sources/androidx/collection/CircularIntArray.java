package androidx.collection;

import X2.C2242i;
import kotlin.jvm.internal.C2633k;

public final class CircularIntArray {
    private int capacityBitmask;
    private int[] elements;
    private int head;
    private int tail;

    public CircularIntArray() {
        this(0, 1, (C2633k) null);
    }

    private final void doubleCapacity() {
        int[] iArr = this.elements;
        int length = iArr.length;
        int i5 = this.head;
        int i6 = length - i5;
        int i7 = length << 1;
        if (i7 >= 0) {
            int[] iArr2 = new int[i7];
            C2242i.j(iArr, iArr2, 0, i5, length);
            C2242i.j(this.elements, iArr2, i6, 0, this.head);
            this.elements = iArr2;
            this.head = 0;
            this.tail = length;
            this.capacityBitmask = i7 - 1;
            return;
        }
        throw new RuntimeException("Max array capacity exceeded");
    }

    public final void addFirst(int i5) {
        int i6 = (this.head - 1) & this.capacityBitmask;
        this.head = i6;
        this.elements[i6] = i5;
        if (i6 == this.tail) {
            doubleCapacity();
        }
    }

    public final void addLast(int i5) {
        int[] iArr = this.elements;
        int i6 = this.tail;
        iArr[i6] = i5;
        int i7 = this.capacityBitmask & (i6 + 1);
        this.tail = i7;
        if (i7 == this.head) {
            doubleCapacity();
        }
    }

    public final void clear() {
        this.tail = this.head;
    }

    public final int get(int i5) {
        if (i5 < 0 || i5 >= size()) {
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
        return this.elements[this.capacityBitmask & (this.head + i5)];
    }

    public final int getFirst() {
        int i5 = this.head;
        if (i5 != this.tail) {
            return this.elements[i5];
        }
        CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final int getLast() {
        int i5 = this.head;
        int i6 = this.tail;
        if (i5 != i6) {
            return this.elements[(i6 - 1) & this.capacityBitmask];
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

    public final int popFirst() {
        int i5 = this.head;
        if (i5 != this.tail) {
            int i6 = this.elements[i5];
            this.head = (i5 + 1) & this.capacityBitmask;
            return i6;
        }
        CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final int popLast() {
        int i5 = this.head;
        int i6 = this.tail;
        if (i5 != i6) {
            int i7 = this.capacityBitmask & (i6 - 1);
            int i8 = this.elements[i7];
            this.tail = i7;
            return i8;
        }
        CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
        throw new ArrayIndexOutOfBoundsException();
    }

    public final void removeFromEnd(int i5) {
        if (i5 > 0) {
            if (i5 <= size()) {
                this.tail = this.capacityBitmask & (this.tail - i5);
                return;
            }
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public final void removeFromStart(int i5) {
        if (i5 > 0) {
            if (i5 <= size()) {
                this.head = this.capacityBitmask & (this.head + i5);
                return;
            }
            CollectionPlatformUtils collectionPlatformUtils = CollectionPlatformUtils.INSTANCE;
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public final int size() {
        return (this.tail - this.head) & this.capacityBitmask;
    }

    public CircularIntArray(int i5) {
        if (i5 < 1) {
            throw new IllegalArgumentException("capacity must be >= 1");
        } else if (i5 <= 1073741824) {
            i5 = Integer.bitCount(i5) != 1 ? Integer.highestOneBit(i5 - 1) << 1 : i5;
            this.capacityBitmask = i5 - 1;
            this.elements = new int[i5];
        } else {
            throw new IllegalArgumentException("capacity must be <= 2^30");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CircularIntArray(int i5, int i6, C2633k kVar) {
        this((i6 & 1) != 0 ? 8 : i5);
    }
}
