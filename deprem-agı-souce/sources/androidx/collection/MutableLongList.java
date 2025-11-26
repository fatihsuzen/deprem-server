package androidx.collection;

import X2.C2242i;
import androidx.annotation.IntRange;
import java.util.Arrays;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class MutableLongList extends LongList {
    public MutableLongList() {
        this(0, 1, (C2633k) null);
    }

    public static /* synthetic */ void trim$default(MutableLongList mutableLongList, int i5, int i6, Object obj) {
        if ((i6 & 1) != 0) {
            i5 = mutableLongList._size;
        }
        mutableLongList.trim(i5);
    }

    public final boolean add(long j5) {
        ensureCapacity(this._size + 1);
        long[] jArr = this.content;
        int i5 = this._size;
        jArr[i5] = j5;
        this._size = i5 + 1;
        return true;
    }

    public final boolean addAll(@IntRange(from = 0) int i5, long[] jArr) {
        int i6;
        t.e(jArr, "elements");
        if (i5 < 0 || i5 > (i6 = this._size)) {
            throw new IndexOutOfBoundsException("Index " + i5 + " must be in 0.." + this._size);
        } else if (jArr.length == 0) {
            return false;
        } else {
            ensureCapacity(i6 + jArr.length);
            long[] jArr2 = this.content;
            int i7 = this._size;
            if (i5 != i7) {
                C2242i.k(jArr2, jArr2, jArr.length + i5, i5, i7);
            }
            long[] jArr3 = jArr;
            C2242i.p(jArr3, jArr2, i5, 0, 0, 12, (Object) null);
            this._size += jArr3.length;
            return true;
        }
    }

    public final void clear() {
        this._size = 0;
    }

    public final void ensureCapacity(int i5) {
        long[] jArr = this.content;
        if (jArr.length < i5) {
            long[] copyOf = Arrays.copyOf(jArr, Math.max(i5, (jArr.length * 3) / 2));
            t.d(copyOf, "copyOf(this, newSize)");
            this.content = copyOf;
        }
    }

    public final int getCapacity() {
        return this.content.length;
    }

    public final void minusAssign(long j5) {
        remove(j5);
    }

    public final void plusAssign(LongList longList) {
        t.e(longList, "elements");
        addAll(this._size, longList);
    }

    public final boolean remove(long j5) {
        int indexOf = indexOf(j5);
        if (indexOf < 0) {
            return false;
        }
        removeAt(indexOf);
        return true;
    }

    public final boolean removeAll(long[] jArr) {
        t.e(jArr, "elements");
        int i5 = this._size;
        for (long remove : jArr) {
            remove(remove);
        }
        if (i5 != this._size) {
            return true;
        }
        return false;
    }

    public final long removeAt(@IntRange(from = 0) int i5) {
        int i6;
        if (i5 < 0 || i5 >= (i6 = this._size)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Index ");
            sb.append(i5);
            sb.append(" must be in 0..");
            sb.append(this._size - 1);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        long[] jArr = this.content;
        long j5 = jArr[i5];
        if (i5 != i6 - 1) {
            C2242i.k(jArr, jArr, i5, i5 + 1, i6);
        }
        this._size--;
        return j5;
    }

    public final void removeRange(@IntRange(from = 0) int i5, @IntRange(from = 0) int i6) {
        int i7;
        if (i5 < 0 || i5 > (i7 = this._size) || i6 < 0 || i6 > i7) {
            throw new IndexOutOfBoundsException("Start (" + i5 + ") and end (" + i6 + ") must be in 0.." + this._size);
        } else if (i6 < i5) {
            throw new IllegalArgumentException("Start (" + i5 + ") is more than end (" + i6 + ')');
        } else if (i6 != i5) {
            if (i6 < i7) {
                long[] jArr = this.content;
                C2242i.k(jArr, jArr, i5, i6, i7);
            }
            this._size -= i6 - i5;
        }
    }

    public final boolean retainAll(long[] jArr) {
        t.e(jArr, "elements");
        int i5 = this._size;
        long[] jArr2 = this.content;
        int i6 = i5 - 1;
        while (true) {
            int i7 = 0;
            int i8 = -1;
            if (-1 >= i6) {
                break;
            }
            long j5 = jArr2[i6];
            int length = jArr.length;
            while (true) {
                if (i7 >= length) {
                    break;
                } else if (jArr[i7] == j5) {
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

    public final long set(@IntRange(from = 0) int i5, long j5) {
        if (i5 < 0 || i5 >= this._size) {
            StringBuilder sb = new StringBuilder();
            sb.append("set index ");
            sb.append(i5);
            sb.append(" must be between 0 .. ");
            sb.append(this._size - 1);
            throw new IndexOutOfBoundsException(sb.toString());
        }
        long[] jArr = this.content;
        long j6 = jArr[i5];
        jArr[i5] = j5;
        return j6;
    }

    public final void sort() {
        C2242i.D(this.content, 0, this._size);
    }

    public final void sortDescending() {
        C2242i.m0(this.content, 0, this._size);
    }

    public final void trim(int i5) {
        int max = Math.max(i5, this._size);
        long[] jArr = this.content;
        if (jArr.length > max) {
            long[] copyOf = Arrays.copyOf(jArr, max);
            t.d(copyOf, "copyOf(this, newSize)");
            this.content = copyOf;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ MutableLongList(int i5, int i6, C2633k kVar) {
        this((i6 & 1) != 0 ? 16 : i5);
    }

    public final void minusAssign(long[] jArr) {
        t.e(jArr, "elements");
        for (long remove : jArr) {
            remove(remove);
        }
    }

    public final void plusAssign(long[] jArr) {
        t.e(jArr, "elements");
        addAll(this._size, jArr);
    }

    public MutableLongList(int i5) {
        super(i5, (C2633k) null);
    }

    public final void plusAssign(long j5) {
        add(j5);
    }

    public final void add(@IntRange(from = 0) int i5, long j5) {
        int i6;
        if (i5 < 0 || i5 > (i6 = this._size)) {
            throw new IndexOutOfBoundsException("Index " + i5 + " must be in 0.." + this._size);
        }
        ensureCapacity(i6 + 1);
        long[] jArr = this.content;
        int i7 = this._size;
        if (i5 != i7) {
            C2242i.k(jArr, jArr, i5 + 1, i5, i7);
        }
        jArr[i5] = j5;
        this._size++;
    }

    public final void minusAssign(LongList longList) {
        t.e(longList, "elements");
        long[] jArr = longList.content;
        int i5 = longList._size;
        for (int i6 = 0; i6 < i5; i6++) {
            remove(jArr[i6]);
        }
    }

    public final boolean removeAll(LongList longList) {
        t.e(longList, "elements");
        int i5 = this._size;
        int i6 = longList._size - 1;
        if (i6 >= 0) {
            int i7 = 0;
            while (true) {
                remove(longList.get(i7));
                if (i7 == i6) {
                    break;
                }
                i7++;
            }
        }
        return i5 != this._size;
    }

    public final boolean retainAll(LongList longList) {
        t.e(longList, "elements");
        int i5 = this._size;
        long[] jArr = this.content;
        for (int i6 = i5 - 1; -1 < i6; i6--) {
            if (!longList.contains(jArr[i6])) {
                removeAt(i6);
            }
        }
        return i5 != this._size;
    }

    public final boolean addAll(@IntRange(from = 0) int i5, LongList longList) {
        t.e(longList, "elements");
        if (i5 < 0 || i5 > this._size) {
            throw new IndexOutOfBoundsException("Index " + i5 + " must be in 0.." + this._size);
        } else if (longList.isEmpty()) {
            return false;
        } else {
            ensureCapacity(this._size + longList._size);
            long[] jArr = this.content;
            int i6 = this._size;
            if (i5 != i6) {
                C2242i.k(jArr, jArr, longList._size + i5, i5, i6);
            }
            C2242i.k(longList.content, jArr, i5, 0, longList._size);
            this._size += longList._size;
            return true;
        }
    }

    public final boolean addAll(LongList longList) {
        t.e(longList, "elements");
        return addAll(this._size, longList);
    }

    public final boolean addAll(long[] jArr) {
        t.e(jArr, "elements");
        return addAll(this._size, jArr);
    }
}
