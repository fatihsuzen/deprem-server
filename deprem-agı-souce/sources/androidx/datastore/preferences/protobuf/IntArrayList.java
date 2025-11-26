package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class IntArrayList extends AbstractProtobufList<Integer> implements Internal.IntList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final IntArrayList EMPTY_LIST = new IntArrayList(new int[0], 0, false);
    private int[] array;
    private int size;

    IntArrayList() {
        this(new int[10], 0, true);
    }

    public static IntArrayList emptyList() {
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

    public boolean addAll(Collection<? extends Integer> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof IntArrayList)) {
            return super.addAll(collection);
        }
        IntArrayList intArrayList = (IntArrayList) collection;
        int i5 = intArrayList.size;
        if (i5 == 0) {
            return false;
        }
        int i6 = this.size;
        if (Integer.MAX_VALUE - i6 >= i5) {
            int i7 = i6 + i5;
            int[] iArr = this.array;
            if (i7 > iArr.length) {
                this.array = Arrays.copyOf(iArr, i7);
            }
            System.arraycopy(intArrayList.array, 0, this.array, this.size, intArrayList.size);
            this.size = i7;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void addInt(int i5) {
        ensureIsMutable();
        int i6 = this.size;
        int[] iArr = this.array;
        if (i6 == iArr.length) {
            int[] iArr2 = new int[(((i6 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i6);
            this.array = iArr2;
        }
        int[] iArr3 = this.array;
        int i7 = this.size;
        this.size = i7 + 1;
        iArr3[i7] = i5;
    }

    public boolean contains(Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntArrayList)) {
            return super.equals(obj);
        }
        IntArrayList intArrayList = (IntArrayList) obj;
        if (this.size != intArrayList.size) {
            return false;
        }
        int[] iArr = intArrayList.array;
        for (int i5 = 0; i5 < this.size; i5++) {
            if (this.array[i5] != iArr[i5]) {
                return false;
            }
        }
        return true;
    }

    public int getInt(int i5) {
        ensureIndexInRange(i5);
        return this.array[i5];
    }

    public int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.size; i6++) {
            i5 = (i5 * 31) + this.array[i6];
        }
        return i5;
    }

    public int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int intValue = ((Integer) obj).intValue();
        int size2 = size();
        for (int i5 = 0; i5 < size2; i5++) {
            if (this.array[i5] == intValue) {
                return i5;
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public void removeRange(int i5, int i6) {
        ensureIsMutable();
        if (i6 >= i5) {
            int[] iArr = this.array;
            System.arraycopy(iArr, i6, iArr, i5, this.size - i6);
            this.size -= i6 - i5;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public int setInt(int i5, int i6) {
        ensureIsMutable();
        ensureIndexInRange(i5);
        int[] iArr = this.array;
        int i7 = iArr[i5];
        iArr[i5] = i6;
        return i7;
    }

    public int size() {
        return this.size;
    }

    private IntArrayList(int[] iArr, int i5, boolean z4) {
        super(z4);
        this.array = iArr;
        this.size = i5;
    }

    public Integer get(int i5) {
        return Integer.valueOf(getInt(i5));
    }

    public Internal.IntList mutableCopyWithCapacity(int i5) {
        if (i5 >= this.size) {
            return new IntArrayList(Arrays.copyOf(this.array, i5), this.size, true);
        }
        throw new IllegalArgumentException();
    }

    public Integer remove(int i5) {
        ensureIsMutable();
        ensureIndexInRange(i5);
        int[] iArr = this.array;
        int i6 = iArr[i5];
        int i7 = this.size;
        if (i5 < i7 - 1) {
            System.arraycopy(iArr, i5 + 1, iArr, i5, (i7 - i5) - 1);
        }
        this.size--;
        this.modCount++;
        return Integer.valueOf(i6);
    }

    public Integer set(int i5, Integer num) {
        return Integer.valueOf(setInt(i5, num.intValue()));
    }

    public boolean add(Integer num) {
        addInt(num.intValue());
        return true;
    }

    public void add(int i5, Integer num) {
        addInt(i5, num.intValue());
    }

    private void addInt(int i5, int i6) {
        int i7;
        ensureIsMutable();
        if (i5 < 0 || i5 > (i7 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i5));
        }
        int[] iArr = this.array;
        if (i7 < iArr.length) {
            System.arraycopy(iArr, i5, iArr, i5 + 1, i7 - i5);
        } else {
            int[] iArr2 = new int[(((i7 * 3) / 2) + 1)];
            System.arraycopy(iArr, 0, iArr2, 0, i5);
            System.arraycopy(this.array, i5, iArr2, i5 + 1, this.size - i5);
            this.array = iArr2;
        }
        this.array[i5] = i6;
        this.size++;
        this.modCount++;
    }
}
