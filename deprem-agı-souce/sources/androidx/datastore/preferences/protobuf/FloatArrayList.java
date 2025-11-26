package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

final class FloatArrayList extends AbstractProtobufList<Float> implements Internal.FloatList, RandomAccess, PrimitiveNonBoxingCollection {
    private static final FloatArrayList EMPTY_LIST = new FloatArrayList(new float[0], 0, false);
    private float[] array;
    private int size;

    FloatArrayList() {
        this(new float[10], 0, true);
    }

    public static FloatArrayList emptyList() {
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

    public boolean addAll(Collection<? extends Float> collection) {
        ensureIsMutable();
        Internal.checkNotNull(collection);
        if (!(collection instanceof FloatArrayList)) {
            return super.addAll(collection);
        }
        FloatArrayList floatArrayList = (FloatArrayList) collection;
        int i5 = floatArrayList.size;
        if (i5 == 0) {
            return false;
        }
        int i6 = this.size;
        if (Integer.MAX_VALUE - i6 >= i5) {
            int i7 = i6 + i5;
            float[] fArr = this.array;
            if (i7 > fArr.length) {
                this.array = Arrays.copyOf(fArr, i7);
            }
            System.arraycopy(floatArrayList.array, 0, this.array, this.size, floatArrayList.size);
            this.size = i7;
            this.modCount++;
            return true;
        }
        throw new OutOfMemoryError();
    }

    public void addFloat(float f5) {
        ensureIsMutable();
        int i5 = this.size;
        float[] fArr = this.array;
        if (i5 == fArr.length) {
            float[] fArr2 = new float[(((i5 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i5);
            this.array = fArr2;
        }
        float[] fArr3 = this.array;
        int i6 = this.size;
        this.size = i6 + 1;
        fArr3[i6] = f5;
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
        if (!(obj instanceof FloatArrayList)) {
            return super.equals(obj);
        }
        FloatArrayList floatArrayList = (FloatArrayList) obj;
        if (this.size != floatArrayList.size) {
            return false;
        }
        float[] fArr = floatArrayList.array;
        for (int i5 = 0; i5 < this.size; i5++) {
            if (Float.floatToIntBits(this.array[i5]) != Float.floatToIntBits(fArr[i5])) {
                return false;
            }
        }
        return true;
    }

    public float getFloat(int i5) {
        ensureIndexInRange(i5);
        return this.array[i5];
    }

    public int hashCode() {
        int i5 = 1;
        for (int i6 = 0; i6 < this.size; i6++) {
            i5 = (i5 * 31) + Float.floatToIntBits(this.array[i6]);
        }
        return i5;
    }

    public int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float floatValue = ((Float) obj).floatValue();
        int size2 = size();
        for (int i5 = 0; i5 < size2; i5++) {
            if (this.array[i5] == floatValue) {
                return i5;
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    public void removeRange(int i5, int i6) {
        ensureIsMutable();
        if (i6 >= i5) {
            float[] fArr = this.array;
            System.arraycopy(fArr, i6, fArr, i5, this.size - i6);
            this.size -= i6 - i5;
            this.modCount++;
            return;
        }
        throw new IndexOutOfBoundsException("toIndex < fromIndex");
    }

    public float setFloat(int i5, float f5) {
        ensureIsMutable();
        ensureIndexInRange(i5);
        float[] fArr = this.array;
        float f6 = fArr[i5];
        fArr[i5] = f5;
        return f6;
    }

    public int size() {
        return this.size;
    }

    private FloatArrayList(float[] fArr, int i5, boolean z4) {
        super(z4);
        this.array = fArr;
        this.size = i5;
    }

    public Float get(int i5) {
        return Float.valueOf(getFloat(i5));
    }

    public Internal.FloatList mutableCopyWithCapacity(int i5) {
        if (i5 >= this.size) {
            return new FloatArrayList(Arrays.copyOf(this.array, i5), this.size, true);
        }
        throw new IllegalArgumentException();
    }

    public Float remove(int i5) {
        ensureIsMutable();
        ensureIndexInRange(i5);
        float[] fArr = this.array;
        float f5 = fArr[i5];
        int i6 = this.size;
        if (i5 < i6 - 1) {
            System.arraycopy(fArr, i5 + 1, fArr, i5, (i6 - i5) - 1);
        }
        this.size--;
        this.modCount++;
        return Float.valueOf(f5);
    }

    public Float set(int i5, Float f5) {
        return Float.valueOf(setFloat(i5, f5.floatValue()));
    }

    public boolean add(Float f5) {
        addFloat(f5.floatValue());
        return true;
    }

    public void add(int i5, Float f5) {
        addFloat(i5, f5.floatValue());
    }

    private void addFloat(int i5, float f5) {
        int i6;
        ensureIsMutable();
        if (i5 < 0 || i5 > (i6 = this.size)) {
            throw new IndexOutOfBoundsException(makeOutOfBoundsExceptionMessage(i5));
        }
        float[] fArr = this.array;
        if (i6 < fArr.length) {
            System.arraycopy(fArr, i5, fArr, i5 + 1, i6 - i5);
        } else {
            float[] fArr2 = new float[(((i6 * 3) / 2) + 1)];
            System.arraycopy(fArr, 0, fArr2, 0, i5);
            System.arraycopy(this.array, i5, fArr2, i5 + 1, this.size - i5);
            this.array = fArr2;
        }
        this.array[i5] = f5;
        this.size++;
        this.modCount++;
    }
}
