package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class DoubleArrayList extends AbstractProtobufList<Double> implements Internal.DoubleList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final DoubleArrayList EMPTY_LIST = new DoubleArrayList(new double[0], 0, false);
    private double[] array;
    private int size;

    DoubleArrayList() {
        this(new double[10], 0, true);
    }

    public static DoubleArrayList emptyList() {
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

    public boolean addAll(Collection<? extends Double> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof DoubleArrayList)) {
            return super.addAll(collection);
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList) collection;
        int i5 = doubleArrayList.size;
        if (i5 == 0) {
            return false;
        }
        int i6 = this.size;
        if (Integer.MAX_VALUE - i6 >= i5) {
            int i7 = i6 + i5;
            double[] dArr = this.array;
            if (i7 > dArr.length) {
                this.array = Arrays.copyOf(dArr, i7);
            }
            System.arraycopy(doubleArrayList.array, 0, this.array, this.size, doubleArrayList.size);
            this.size = i7;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void addDouble(double d5) {
        ensureIsMutable();
        int i5 = this.size;
        double[] dArr = this.array;
        if (i5 == dArr.length) {
            double[] dArr2 = new double[(((i5 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i5);
            this.array = dArr2;
        }
        double[] dArr3 = this.array;
        int i6 = this.size;
        this.size = i6 + 1;
        dArr3[i6] = d5;
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
        if (!(obj instanceof DoubleArrayList)) {
            return super.equals(obj);
        }
        DoubleArrayList doubleArrayList = (DoubleArrayList) obj;
        if (this.size != doubleArrayList.size) {
            return false;
        }
        double[] dArr = doubleArrayList.array;
        for (int i5 = 0; i5 < this.size; i5++) {
            if (Double.doubleToLongBits(this.array[i5]) != Double.doubleToLongBits(dArr[i5])) {
                return false;
            }
        }
        return true;
    }

    public double getDouble(int i5) {
        ensureIndexInRange(i5);
        return this.array[i5];
    }

    public int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.size; i6++) {
            i5 = (i5 * 31) + Internal.hashLong(Double.doubleToLongBits(this.array[i6]));
        }
        return i5;
    }

    public int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double doubleValue = ((Double) obj).doubleValue();
        int size2 = size();
        for (int i5 = 0; i5 < size2; i5++) {
            if (this.array[i5] == doubleValue) {
                return i5;
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public void removeRange(int i5, int i6) {
        ensureIsMutable();
        if (i6 >= i5) {
            double[] dArr = this.array;
            System.arraycopy(dArr, i6, dArr, i5, this.size - i6);
            this.size -= i6 - i5;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public double setDouble(int i5, double d5) {
        ensureIsMutable();
        ensureIndexInRange(i5);
        double[] dArr = this.array;
        double d6 = dArr[i5];
        dArr[i5] = d5;
        return d6;
    }

    public int size() {
        return this.size;
    }

    private DoubleArrayList(double[] dArr, int i5, boolean z4) {
        super(z4);
        this.array = dArr;
        this.size = i5;
    }

    public Double get(int i5) {
        return Double.valueOf(getDouble(i5));
    }

    public Internal.DoubleList mutableCopyWithCapacity(int i5) {
        if (i5 >= this.size) {
            return new DoubleArrayList(Arrays.copyOf(this.array, i5), this.size, true);
        }
        throw new IllegalArgumentException();
    }

    public Double remove(int i5) {
        ensureIsMutable();
        ensureIndexInRange(i5);
        double[] dArr = this.array;
        double d5 = dArr[i5];
        int i6 = this.size;
        if (i5 < i6 - 1) {
            System.arraycopy(dArr, i5 + 1, dArr, i5, (i6 - i5) - 1);
        }
        this.size--;
        this.modCount++;
        return Double.valueOf(d5);
    }

    public Double set(int i5, Double d5) {
        return Double.valueOf(setDouble(i5, d5.doubleValue()));
    }

    public boolean add(Double d5) {
        addDouble(d5.doubleValue());
        return true;
    }

    public void add(int i5, Double d5) {
        addDouble(i5, d5.doubleValue());
    }

    private void addDouble(int i5, double d5) {
        int i6;
        ensureIsMutable();
        if (i5 < 0 || i5 > (i6 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i5));
        }
        double[] dArr = this.array;
        if (i6 < dArr.length) {
            System.arraycopy(dArr, i5, dArr, i5 + 1, i6 - i5);
        } else {
            double[] dArr2 = new double[(((i6 * 3) / 2) + 1)];
            System.arraycopy(dArr, 0, dArr2, 0, i5);
            System.arraycopy(this.array, i5, dArr2, i5 + 1, this.size - i5);
            this.array = dArr2;
        }
        this.array[i5] = d5;
        this.size++;
        this.modCount++;
    }
}
