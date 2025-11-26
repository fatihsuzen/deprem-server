package androidx.datastore.preferences.protobuf;

import java.util.Arrays;
import java.util.RandomAccess;

final class ProtobufArrayList<E> extends AbstractProtobufList<E> implements RandomAccess {
    private static final ProtobufArrayList<Object> EMPTY_LIST = new ProtobufArrayList<>(new Object[0], 0, false);
    private E[] array;
    private int size;

    ProtobufArrayList() {
        this(new Object[10], 0, true);
    }

    private static <E> E[] createArray(int i5) {
        return new Object[i5];
    }

    public static <E> ProtobufArrayList<E> emptyList() {
        return EMPTY_LIST;
    }

    private void ensureIndexInRange(int i5) {
        if (i5 < 0 || i5 >= this.size) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i5));
        }
    }

    private String makeOutOfBoundsExceptionMessage(int i5) {
        return "Index:" + i5 + ", Size:" + this.size;
    }

    public boolean add(E e5) {
        ensureIsMutable();
        int i5 = this.size;
        E[] eArr = this.array;
        if (i5 == eArr.length) {
            this.array = Arrays.copyOf(eArr, ((i5 * 3) / 2) + 1);
        }
        E[] eArr2 = this.array;
        int i6 = this.size;
        this.size = i6 + 1;
        eArr2[i6] = e5;
        this.modCount++;
        return true;
    }

    public E get(int i5) {
        ensureIndexInRange(i5);
        return this.array[i5];
    }

    public E remove(int i5) {
        ensureIsMutable();
        ensureIndexInRange(i5);
        E[] eArr = this.array;
        E e5 = eArr[i5];
        int i6 = this.size;
        if (i5 < i6 - 1) {
            System.arraycopy(eArr, i5 + 1, eArr, i5, (i6 - i5) - 1);
        }
        this.size--;
        this.modCount++;
        return e5;
    }

    public E set(int i5, E e5) {
        ensureIsMutable();
        ensureIndexInRange(i5);
        E[] eArr = this.array;
        E e6 = eArr[i5];
        eArr[i5] = e5;
        this.modCount++;
        return e6;
    }

    public int size() {
        return this.size;
    }

    private ProtobufArrayList(E[] eArr, int i5, boolean z4) {
        super(z4);
        this.array = eArr;
        this.size = i5;
    }

    public ProtobufArrayList<E> mutableCopyWithCapacity(int i5) {
        if (i5 >= this.size) {
            return new ProtobufArrayList<>(Arrays.copyOf(this.array, i5), this.size, true);
        }
        throw new IllegalArgumentException();
    }

    public void add(int i5, E e5) {
        int i6;
        ensureIsMutable();
        if (i5 < 0 || i5 > (i6 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i5));
        }
        E[] eArr = this.array;
        if (i6 < eArr.length) {
            System.arraycopy(eArr, i5, eArr, i5 + 1, i6 - i5);
        } else {
            E[] createArray = createArray(((i6 * 3) / 2) + 1);
            System.arraycopy(this.array, 0, createArray, 0, i5);
            System.arraycopy(this.array, i5, createArray, i5 + 1, this.size - i5);
            this.array = createArray;
        }
        this.array[i5] = e5;
        this.size++;
        this.modCount++;
    }
}
