package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class LongArrayList extends AbstractProtobufList<Long> implements Internal.LongList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final LongArrayList EMPTY_LIST = new LongArrayList(new long[0], 0, false);
    private long[] array;
    private int size;

    LongArrayList() {
        this(new long[10], 0, true);
    }

    public static LongArrayList emptyList() {
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

    public boolean addAll(Collection<? extends Long> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof LongArrayList)) {
            return super.addAll(collection);
        }
        LongArrayList longArrayList = (LongArrayList) collection;
        int i5 = longArrayList.size;
        if (i5 == 0) {
            return false;
        }
        int i6 = this.size;
        if (Integer.MAX_VALUE - i6 >= i5) {
            int i7 = i6 + i5;
            long[] jArr = this.array;
            if (i7 > jArr.length) {
                this.array = Arrays.copyOf(jArr, i7);
            }
            System.arraycopy(longArrayList.array, 0, this.array, this.size, longArrayList.size);
            this.size = i7;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void addLong(long j5) {
        ensureIsMutable();
        int i5 = this.size;
        long[] jArr = this.array;
        if (i5 == jArr.length) {
            long[] jArr2 = new long[(((i5 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i5);
            this.array = jArr2;
        }
        long[] jArr3 = this.array;
        int i6 = this.size;
        this.size = i6 + 1;
        jArr3[i6] = j5;
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
        if (!(obj instanceof LongArrayList)) {
            return super.equals(obj);
        }
        LongArrayList longArrayList = (LongArrayList) obj;
        if (this.size != longArrayList.size) {
            return false;
        }
        long[] jArr = longArrayList.array;
        for (int i5 = 0; i5 < this.size; i5++) {
            if (this.array[i5] != jArr[i5]) {
                return false;
            }
        }
        return true;
    }

    public long getLong(int i5) {
        ensureIndexInRange(i5);
        return this.array[i5];
    }

    public int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.size; i6++) {
            i5 = (i5 * 31) + Internal.hashLong(this.array[i6]);
        }
        return i5;
    }

    public int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long longValue = ((Long) obj).longValue();
        int size2 = size();
        for (int i5 = 0; i5 < size2; i5++) {
            if (this.array[i5] == longValue) {
                return i5;
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public void removeRange(int i5, int i6) {
        ensureIsMutable();
        if (i6 >= i5) {
            long[] jArr = this.array;
            System.arraycopy(jArr, i6, jArr, i5, this.size - i6);
            this.size -= i6 - i5;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public long setLong(int i5, long j5) {
        ensureIsMutable();
        ensureIndexInRange(i5);
        long[] jArr = this.array;
        long j6 = jArr[i5];
        jArr[i5] = j5;
        return j6;
    }

    public int size() {
        return this.size;
    }

    private LongArrayList(long[] jArr, int i5, boolean z4) {
        super(z4);
        this.array = jArr;
        this.size = i5;
    }

    public Long get(int i5) {
        return Long.valueOf(getLong(i5));
    }

    public Internal.LongList mutableCopyWithCapacity(int i5) {
        if (i5 >= this.size) {
            return new LongArrayList(Arrays.copyOf(this.array, i5), this.size, true);
        }
        throw new IllegalArgumentException();
    }

    public Long remove(int i5) {
        ensureIsMutable();
        ensureIndexInRange(i5);
        long[] jArr = this.array;
        long j5 = jArr[i5];
        int i6 = this.size;
        if (i5 < i6 - 1) {
            System.arraycopy(jArr, i5 + 1, jArr, i5, (i6 - i5) - 1);
        }
        this.size--;
        this.modCount++;
        return Long.valueOf(j5);
    }

    public Long set(int i5, Long l5) {
        return Long.valueOf(setLong(i5, l5.longValue()));
    }

    public boolean add(Long l5) {
        addLong(l5.longValue());
        return true;
    }

    public void add(int i5, Long l5) {
        addLong(i5, l5.longValue());
    }

    private void addLong(int i5, long j5) {
        int i6;
        ensureIsMutable();
        if (i5 < 0 || i5 > (i6 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i5));
        }
        long[] jArr = this.array;
        if (i6 < jArr.length) {
            System.arraycopy(jArr, i5, jArr, i5 + 1, i6 - i5);
        } else {
            long[] jArr2 = new long[(((i6 * 3) / 2) + 1)];
            System.arraycopy(jArr, 0, jArr2, 0, i5);
            System.arraycopy(this.array, i5, jArr2, i5 + 1, this.size - i5);
            this.array = jArr2;
        }
        this.array[i5] = j5;
        this.size++;
        this.modCount++;
    }
}
