package androidx.collection;

import X2.C2242i;
import androidx.annotation.IntRange;
import java.util.Arrays;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class MutableIntList extends IntList {
    public MutableIntList() {
        this(0, 1, (C2633k) null);
    }

    public static /* synthetic */ void trim$default(MutableIntList mutableIntList, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i5 = mutableIntList._size;
        }
        mutableIntList.trim(i5);
    }

    public final boolean add(int i5) {
        ensureCapacity(this._size + 1);
        int[] iArr = this.content;
        int i6 = this._size;
        iArr[i6] = i5;
        this._size = i6 + 1;
        return true;
    }

    public final boolean addAll(@IntRange(from = 0) int i5, int[] iArr) {
        int i6;
        t.e(iArr, "elements");
        if (i5 < 0 || i5 > (i6 = this._size)) {
            throw new IndexOutOfBoundsException("Index " + i5 + " must be in 0.." + this._size);
        } else if (iArr.length == 0) {
            return false;
        } else {
            ensureCapacity(i6 + iArr.length);
            int[] iArr2 = this.content;
            int i7 = this._size;
            if (i5 != i7) {
                C2242i.j(iArr2, iArr2, iArr.length + i5, i5, i7);
            }
            int[] iArr3 = iArr;
            C2242i.o(iArr3, iArr2, i5, 0, 0, 12, (Object) null);
            this._size += iArr3.length;
            return true;
        }
    }

    public final void clear() {
        this._size = 0;
    }

    public final void ensureCapacity(int i5) {
        int[] iArr = this.content;
        if (iArr.length < i5) {
            int[] copyOf = Arrays.copyOf(iArr, Math.max(i5, (iArr.length * 3) / 2));
            t.d(copyOf, "copyOf(this, newSize)");
            this.content = copyOf;
        }
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final void minusAssign(int i5) {
        remove(i5);
    }

    public final void plusAssign(IntList intList) {
        t.e(intList, "elements");
        addAll(this._size, intList);
    }

    public final boolean remove(int i5) {
        int indexOf = indexOf(i5);
        if (indexOf < 0) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    public final boolean removeAll(int[] iArr) {
        t.e(iArr, "elements");
        int i5 = this._size;
        for (int remove : iArr) {
            remove(remove);
        }
        if (i5 != this._size) {
            return true;
        }
        return false;
    }

    public final int removeAt(@IntRange(from = 0) int i5) {
        int i6;
        if (i5 < 0 || i5 >= (i6 = this._size)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Index ");
            sb.append(i5);
            sb.append(" must be in 0..");
            sb.append(this._size - 1);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        int[] iArr = this.content;
        int i7 = iArr[i5];
        if (i5 != i6 - 1) {
            C2242i.j(iArr, iArr, i5, i5 + 1, i6);
        }
        this._size--;
        return i7;
    }

    public final void removeRange(@IntRange(from = 0) int i5, @IntRange(from = 0) int i6) {
        int i7;
        if (i5 < 0 || i5 > (i7 = this._size) || i6 < 0 || i6 > i7) {
            throw new IndexOutOfBoundsException("Start (" + i5 + ") and end (" + i6 + ") must be in 0.." + this._size);
        } else if (i6 < i5) {
            throw new IllegalArgumentException("Start (" + i5 + ") is more than end (" + i6 + ')');
        } else if (i6 != i5) {
            if (i6 < i7) {
                int[] iArr = this.content;
                C2242i.j(iArr, iArr, i5, i6, i7);
            }
            this._size -= i6 - i5;
        }
    }

    public final boolean retainAll(int[] iArr) {
        t.e(iArr, "elements");
        int i5 = this._size;
        int[] iArr2 = this.content;
        int i6 = i5 - 1;
        while (true) {
            int i7 = 0;
            int i8 = -1;
            if (-1 >= i6) {
                break;
            }
            int i9 = iArr2[i6];
            int length = iArr.length;
            while (true) {
                if (i7 >= length) {
                    break;
                } else if (iArr[i7] == i9) {
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

    public final int set(@IntRange(from = 0) int i5, int i6) {
        if (i5 < 0 || i5 >= this._size) {
            StringBuilder sb = new StringBuilder();
            sb.append("set index ");
            sb.append(i5);
            sb.append(" must be between 0 .. ");
            sb.append(this._size - 1);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        int[] iArr = this.content;
        int i7 = iArr[i5];
        iArr[i5] = i6;
        return i7;
    }

    public final void sort() {
        C2242i.C(this.content, 0, this._size);
    }

    public final void sortDescending() {
        C2242i.l0(this.content, 0, this._size);
    }

    public final void trim(int i5) {
        int max = Math.max(i5, this._size);
        int[] iArr = this.content;
        if (iArr.length > max) {
            int[] copyOf = Arrays.copyOf(iArr, max);
            t.d(copyOf, "copyOf(this, newSize)");
            this.content = copyOf;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MutableIntList(int i5, int i6, C2633k kVar) {
        this((i6 & 1) != 0 ? 16 : i5);
    }

    public final void minusAssign(int[] iArr) {
        t.e(iArr, "elements");
        for (int remove : iArr) {
            remove(remove);
        }
    }

    public final void plusAssign(int[] iArr) {
        t.e(iArr, "elements");
        addAll(this._size, iArr);
    }

    public MutableIntList(int i5) {
        super(i5, (C2633k) null);
    }

    public final void plusAssign(int i5) {
        add(i5);
    }

    public final void add(@IntRange(from = 0) int i5, int i6) {
        int i7;
        if (i5 < 0 || i5 > (i7 = this._size)) {
            throw new IndexOutOfBoundsException("Index " + i5 + " must be in 0.." + this._size);
        }
        ensureCapacity(i7 + 1);
        int[] iArr = this.content;
        int i8 = this._size;
        if (i5 != i8) {
            C2242i.j(iArr, iArr, i5 + 1, i5, i8);
        }
        iArr[i5] = i6;
        this._size++;
    }

    public final void minusAssign(IntList intList) {
        t.e(intList, "elements");
        int[] iArr = intList.content;
        int i5 = intList._size;
        for (int i6 = 0; i6 < i5; i6++) {
            remove(iArr[i6]);
        }
    }

    public final boolean removeAll(IntList intList) {
        t.e(intList, "elements");
        int i5 = this._size;
        int i6 = intList._size - 1;
        if (i6 >= 0) {
            int i7 = 0;
            while (true) {
                remove(intList.get(i7));
                if (i7 == i6) {
                    break;
                }
                i7++;
            }
        }
        return i5 != this._size;
    }

    public final boolean retainAll(IntList intList) {
        t.e(intList, "elements");
        int i5 = this._size;
        int[] iArr = this.content;
        for (int i6 = i5 - 1; -1 < i6; i6--) {
            if (!intList.contains(iArr[i6])) {
                removeAt(i6);
            }
        }
        return i5 != this._size;
    }

    public final boolean addAll(@IntRange(from = 0) int i5, IntList intList) {
        t.e(intList, "elements");
        if (i5 < 0 || i5 > this._size) {
            throw new IndexOutOfBoundsException("Index " + i5 + " must be in 0.." + this._size);
        } else if (intList.isEmpty()) {
            return false;
        } else {
            ensureCapacity(this._size + intList._size);
            int[] iArr = this.content;
            int i6 = this._size;
            if (i5 != i6) {
                C2242i.j(iArr, iArr, intList._size + i5, i5, i6);
            }
            C2242i.j(intList.content, iArr, i5, 0, intList._size);
            this._size += intList._size;
            return true;
        }
    }

    public final boolean addAll(IntList intList) {
        t.e(intList, "elements");
        return addAll(this._size, intList);
    }

    public final boolean addAll(int[] iArr) {
        t.e(iArr, "elements");
        return addAll(this._size, iArr);
    }
}
