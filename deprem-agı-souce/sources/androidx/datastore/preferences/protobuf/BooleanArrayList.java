package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class BooleanArrayList extends AbstractProtobufList<Boolean> implements Internal.BooleanList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final BooleanArrayList EMPTY_LIST = new BooleanArrayList(new boolean[0], 0, false);
    private boolean[] array;
    private int size;

    BooleanArrayList() {
        this(new boolean[10], 0, true);
    }

    public static BooleanArrayList emptyList() {
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

    public boolean addAll(Collection<? extends Boolean> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof BooleanArrayList)) {
            return super.addAll(collection);
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) collection;
        int i5 = booleanArrayList.size;
        if (i5 == 0) {
            return false;
        }
        int i6 = this.size;
        if (Integer.MAX_VALUE - i6 >= i5) {
            int i7 = i6 + i5;
            boolean[] zArr = this.array;
            if (i7 > zArr.length) {
                this.array = Arrays.copyOf(zArr, i7);
            }
            System.arraycopy(booleanArrayList.array, 0, this.array, this.size, booleanArrayList.size);
            this.size = i7;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void addBoolean(boolean z4) {
        ensureIsMutable();
        int i5 = this.size;
        boolean[] zArr = this.array;
        if (i5 == zArr.length) {
            boolean[] zArr2 = new boolean[(((i5 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i5);
            this.array = zArr2;
        }
        boolean[] zArr3 = this.array;
        int i6 = this.size;
        this.size = i6 + 1;
        zArr3[i6] = z4;
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
        if (!(obj instanceof BooleanArrayList)) {
            return super.equals(obj);
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) obj;
        if (this.size != booleanArrayList.size) {
            return false;
        }
        boolean[] zArr = booleanArrayList.array;
        for (int i5 = 0; i5 < this.size; i5++) {
            if (this.array[i5] != zArr[i5]) {
                return false;
            }
        }
        return true;
    }

    public boolean getBoolean(int i5) {
        ensureIndexInRange(i5);
        return this.array[i5];
    }

    public int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.size; i6++) {
            i5 = (i5 * 31) + Internal.hashBoolean(this.array[i6]);
        }
        return i5;
    }

    public int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean booleanValue = ((Boolean) obj).booleanValue();
        int size2 = size();
        for (int i5 = 0; i5 < size2; i5++) {
            if (this.array[i5] == booleanValue) {
                return i5;
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public void removeRange(int i5, int i6) {
        ensureIsMutable();
        if (i6 >= i5) {
            boolean[] zArr = this.array;
            System.arraycopy(zArr, i6, zArr, i5, this.size - i6);
            this.size -= i6 - i5;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public boolean setBoolean(int i5, boolean z4) {
        ensureIsMutable();
        ensureIndexInRange(i5);
        boolean[] zArr = this.array;
        boolean z5 = zArr[i5];
        zArr[i5] = z4;
        return z5;
    }

    public int size() {
        return this.size;
    }

    private BooleanArrayList(boolean[] zArr, int i5, boolean z4) {
        super(z4);
        this.array = zArr;
        this.size = i5;
    }

    public Boolean get(int i5) {
        return Boolean.valueOf(getBoolean(i5));
    }

    public Internal.BooleanList mutableCopyWithCapacity(int i5) {
        if (i5 >= this.size) {
            return new BooleanArrayList(Arrays.copyOf(this.array, i5), this.size, true);
        }
        throw new IllegalArgumentException();
    }

    public Boolean remove(int i5) {
        ensureIsMutable();
        ensureIndexInRange(i5);
        boolean[] zArr = this.array;
        boolean z4 = zArr[i5];
        int i6 = this.size;
        if (i5 < i6 - 1) {
            System.arraycopy(zArr, i5 + 1, zArr, i5, (i6 - i5) - 1);
        }
        this.size--;
        this.modCount++;
        return Boolean.valueOf(z4);
    }

    public Boolean set(int i5, Boolean bool) {
        return Boolean.valueOf(setBoolean(i5, bool.booleanValue()));
    }

    public boolean add(Boolean bool) {
        addBoolean(bool.booleanValue());
        return true;
    }

    public void add(int i5, Boolean bool) {
        addBoolean(i5, bool.booleanValue());
    }

    private void addBoolean(int i5, boolean z4) {
        int i6;
        ensureIsMutable();
        if (i5 < 0 || i5 > (i6 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i5));
        }
        boolean[] zArr = this.array;
        if (i6 < zArr.length) {
            System.arraycopy(zArr, i5, zArr, i5 + 1, i6 - i5);
        } else {
            boolean[] zArr2 = new boolean[(((i6 * 3) / 2) + 1)];
            System.arraycopy(zArr, 0, zArr2, 0, i5);
            System.arraycopy(this.array, i5, zArr2, i5 + 1, this.size - i5);
            this.array = zArr2;
        }
        this.array[i5] = z4;
        this.size++;
        this.modCount++;
    }
}
