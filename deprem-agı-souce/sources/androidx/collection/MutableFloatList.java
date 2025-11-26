package androidx.collection;

import X2.C2242i;
import androidx.annotation.IntRange;
import java.util.Arrays;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class MutableFloatList extends FloatList {
    public MutableFloatList() {
        this(0, 1, (C2633k) null);
    }

    public static /* synthetic */ void trim$default(MutableFloatList mutableFloatList, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i5 = mutableFloatList._size;
        }
        mutableFloatList.trim(i5);
    }

    public final boolean add(float f5) {
        ensureCapacity(this._size + 1);
        float[] fArr = this.content;
        int i5 = this._size;
        fArr[i5] = f5;
        this._size = i5 + 1;
        return true;
    }

    public final boolean addAll(@IntRange(from = 0) int i5, float[] fArr) {
        int i6;
        t.e(fArr, "elements");
        if (i5 < 0 || i5 > (i6 = this._size)) {
            throw new IndexOutOfBoundsException("Index " + i5 + " must be in 0.." + this._size);
        } else if (fArr.length == 0) {
            return false;
        } else {
            ensureCapacity(i6 + fArr.length);
            float[] fArr2 = this.content;
            int i7 = this._size;
            if (i5 != i7) {
                C2242i.i(fArr2, fArr2, fArr.length + i5, i5, i7);
            }
            float[] fArr3 = fArr;
            C2242i.n(fArr3, fArr2, i5, 0, 0, 12, (Object) null);
            this._size += fArr3.length;
            return true;
        }
    }

    public final void clear() {
        this._size = 0;
    }

    public final void ensureCapacity(int i5) {
        float[] fArr = this.content;
        if (fArr.length < i5) {
            float[] copyOf = Arrays.copyOf(fArr, Math.max(i5, (fArr.length * 3) / 2));
            t.d(copyOf, "copyOf(this, newSize)");
            this.content = copyOf;
        }
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final void minusAssign(float f5) {
        remove(f5);
    }

    public final void plusAssign(FloatList floatList) {
        t.e(floatList, "elements");
        addAll(this._size, floatList);
    }

    public final boolean remove(float f5) {
        int indexOf = indexOf(f5);
        if (indexOf < 0) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    public final boolean removeAll(float[] fArr) {
        t.e(fArr, "elements");
        int i5 = this._size;
        for (float remove : fArr) {
            remove(remove);
        }
        if (i5 != this._size) {
            return true;
        }
        return false;
    }

    public final float removeAt(@IntRange(from = 0) int i5) {
        int i6;
        if (i5 < 0 || i5 >= (i6 = this._size)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Index ");
            sb.append(i5);
            sb.append(" must be in 0..");
            sb.append(this._size - 1);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        float[] fArr = this.content;
        float f5 = fArr[i5];
        if (i5 != i6 - 1) {
            C2242i.i(fArr, fArr, i5, i5 + 1, i6);
        }
        this._size--;
        return f5;
    }

    public final void removeRange(@IntRange(from = 0) int i5, @IntRange(from = 0) int i6) {
        int i7;
        if (i5 < 0 || i5 > (i7 = this._size) || i6 < 0 || i6 > i7) {
            throw new IndexOutOfBoundsException("Start (" + i5 + ") and end (" + i6 + ") must be in 0.." + this._size);
        } else if (i6 < i5) {
            throw new IllegalArgumentException("Start (" + i5 + ") is more than end (" + i6 + ')');
        } else if (i6 != i5) {
            if (i6 < i7) {
                float[] fArr = this.content;
                C2242i.i(fArr, fArr, i5, i6, i7);
            }
            this._size -= i6 - i5;
        }
    }

    public final boolean retainAll(float[] fArr) {
        t.e(fArr, "elements");
        int i5 = this._size;
        float[] fArr2 = this.content;
        int i6 = i5 - 1;
        while (true) {
            int i7 = 0;
            int i8 = -1;
            if (-1 >= i6) {
                break;
            }
            float f5 = fArr2[i6];
            int length = fArr.length;
            while (true) {
                if (i7 >= length) {
                    break;
                } else if (fArr[i7] == f5) {
                    i8 = i7;
                    break;
                } else {
                    i7++;
                }
            }
            if (i8 < 0) {
                removeAt(i6);
            }
            i6--;
        }
        if (i5 != this._size) {
            return true;
        }
        return false;
    }

    public final float set(@IntRange(from = 0) int i5, float f5) {
        if (i5 < 0 || i5 >= this._size) {
            StringBuilder sb = new StringBuilder();
            sb.append("set index ");
            sb.append(i5);
            sb.append(" must be between 0 .. ");
            sb.append(this._size - 1);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        float[] fArr = this.content;
        float f6 = fArr[i5];
        fArr[i5] = f5;
        return f6;
    }

    public final void sort() {
        C2242i.B(this.content, 0, this._size);
    }

    public final void sortDescending() {
        C2242i.k0(this.content, 0, this._size);
    }

    public final void trim(int i5) {
        int max = Math.max(i5, this._size);
        float[] fArr = this.content;
        if (fArr.length > max) {
            float[] copyOf = Arrays.copyOf(fArr, max);
            t.d(copyOf, "copyOf(this, newSize)");
            this.content = copyOf;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MutableFloatList(int i5, int i6, C2633k kVar) {
        this((i6 & 1) != 0 ? 16 : i5);
    }

    public final void minusAssign(float[] fArr) {
        t.e(fArr, "elements");
        for (float remove : fArr) {
            remove(remove);
        }
    }

    public final void plusAssign(float[] fArr) {
        t.e(fArr, "elements");
        addAll(this._size, fArr);
    }

    public MutableFloatList(int i5) {
        super(i5, (C2633k) null);
    }

    public final void plusAssign(float f5) {
        add(f5);
    }

    public final void add(@IntRange(from = 0) int i5, float f5) {
        int i6;
        if (i5 < 0 || i5 > (i6 = this._size)) {
            throw new IndexOutOfBoundsException("Index " + i5 + " must be in 0.." + this._size);
        }
        ensureCapacity(i6 + 1);
        float[] fArr = this.content;
        int i7 = this._size;
        if (i5 != i7) {
            C2242i.i(fArr, fArr, i5 + 1, i5, i7);
        }
        fArr[i5] = f5;
        this._size++;
    }

    public final void minusAssign(FloatList floatList) {
        t.e(floatList, "elements");
        float[] fArr = floatList.content;
        int i5 = floatList._size;
        for (int i6 = 0; i6 < i5; i6++) {
            remove(fArr[i6]);
        }
    }

    public final boolean removeAll(FloatList floatList) {
        t.e(floatList, "elements");
        int i5 = this._size;
        int i6 = floatList._size - 1;
        if (i6 >= 0) {
            int i7 = 0;
            while (true) {
                remove(floatList.get(i7));
                if (i7 == i6) {
                    break;
                }
                i7++;
            }
        }
        return i5 != this._size;
    }

    public final boolean retainAll(FloatList floatList) {
        t.e(floatList, "elements");
        int i5 = this._size;
        float[] fArr = this.content;
        for (int i6 = i5 - 1; -1 < i6; i6--) {
            if (!floatList.contains(fArr[i6])) {
                removeAt(i6);
            }
        }
        return i5 != this._size;
    }

    public final boolean addAll(@IntRange(from = 0) int i5, FloatList floatList) {
        t.e(floatList, "elements");
        if (i5 < 0 || i5 > this._size) {
            throw new IndexOutOfBoundsException("Index " + i5 + " must be in 0.." + this._size);
        } else if (floatList.isEmpty()) {
            return false;
        } else {
            ensureCapacity(this._size + floatList._size);
            float[] fArr = this.content;
            int i6 = this._size;
            if (i5 != i6) {
                C2242i.i(fArr, fArr, floatList._size + i5, i5, i6);
            }
            C2242i.i(floatList.content, fArr, i5, 0, floatList._size);
            this._size += floatList._size;
            return true;
        }
    }

    public final boolean addAll(FloatList floatList) {
        t.e(floatList, "elements");
        return addAll(this._size, floatList);
    }

    public final boolean addAll(float[] fArr) {
        t.e(fArr, "elements");
        return addAll(this._size, fArr);
    }
}
