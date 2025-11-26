package androidx.collection;

import androidx.annotation.IntRange;
import java.util.NoSuchElementException;
import k3.l;
import k3.p;
import k3.q;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import q3.C2728d;
import q3.C2729e;

public abstract class LongList {
    public int _size;
    public long[] content;

    public /* synthetic */ LongList(int i5, C2633k kVar) {
        this(i5);
    }

    public static /* synthetic */ void getContent$annotations() {
    }

    public static /* synthetic */ void get_size$annotations() {
    }

    public static /* synthetic */ String joinToString$default(LongList longList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, int i6, Object obj) {
        if (obj == null) {
            if ((i6 & 1) != 0) {
                charSequence = ", ";
            }
            if ((i6 & 2) != 0) {
                charSequence2 = "";
            }
            if ((i6 & 4) != 0) {
                charSequence3 = "";
            }
            if ((i6 & 8) != 0) {
                i5 = -1;
            }
            if ((i6 & 16) != 0) {
                charSequence4 = "...";
            }
            int i7 = i5;
            CharSequence charSequence5 = charSequence4;
            return longList.joinToString(charSequence, charSequence2, charSequence3, i7, charSequence5);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public final boolean any() {
        return isNotEmpty();
    }

    public final boolean contains(long j5) {
        long[] jArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            if (jArr[i6] == j5) {
                return true;
            }
        }
        return false;
    }

    public final boolean containsAll(LongList longList) {
        t.e(longList, "elements");
        C2728d l5 = C2729e.l(0, longList._size);
        int c5 = l5.c();
        int f5 = l5.f();
        if (c5 > f5) {
            return true;
        }
        while (contains(longList.get(c5))) {
            if (c5 == f5) {
                return true;
            }
            c5++;
        }
        return false;
    }

    public final int count() {
        return this._size;
    }

    public final long elementAt(@IntRange(from = 0) int i5) {
        if (i5 >= 0 && i5 < this._size) {
            return this.content[i5];
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Index ");
        sb.append(i5);
        sb.append(" must be in 0..");
        sb.append(this._size - 1);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final long elementAtOrElse(@IntRange(from = 0) int i5, l lVar) {
        t.e(lVar, "defaultValue");
        if (i5 < 0 || i5 >= this._size) {
            return ((Number) lVar.invoke(Integer.valueOf(i5))).longValue();
        }
        return this.content[i5];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r9 = (androidx.collection.LongList) r9;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof androidx.collection.LongList
            r1 = 0
            if (r0 == 0) goto L_0x0030
            androidx.collection.LongList r9 = (androidx.collection.LongList) r9
            int r0 = r9._size
            int r2 = r8._size
            if (r0 == r2) goto L_0x000e
            goto L_0x0030
        L_0x000e:
            long[] r0 = r8.content
            long[] r9 = r9.content
            q3.d r2 = q3.C2729e.l(r1, r2)
            int r3 = r2.c()
            int r2 = r2.f()
            if (r3 > r2) goto L_0x002e
        L_0x0020:
            r4 = r0[r3]
            r6 = r9[r3]
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 == 0) goto L_0x0029
            return r1
        L_0x0029:
            if (r3 == r2) goto L_0x002e
            int r3 = r3 + 1
            goto L_0x0020
        L_0x002e:
            r9 = 1
            return r9
        L_0x0030:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.LongList.equals(java.lang.Object):boolean");
    }

    public final long first() {
        if (!isEmpty()) {
            return this.content[0];
        }
        throw new NoSuchElementException("LongList is empty.");
    }

    public final <R> R fold(R r5, p pVar) {
        t.e(pVar, "operation");
        long[] jArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            r5 = pVar.invoke(r5, Long.valueOf(jArr[i6]));
        }
        return r5;
    }

    public final <R> R foldIndexed(R r5, q qVar) {
        t.e(qVar, "operation");
        long[] jArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            r5 = qVar.invoke(Integer.valueOf(i6), r5, Long.valueOf(jArr[i6]));
        }
        return r5;
    }

    public final <R> R foldRight(R r5, p pVar) {
        t.e(pVar, "operation");
        long[] jArr = this.content;
        int i5 = this._size;
        while (true) {
            i5--;
            if (-1 >= i5) {
                return r5;
            }
            r5 = pVar.invoke(Long.valueOf(jArr[i5]), r5);
        }
    }

    public final <R> R foldRightIndexed(R r5, q qVar) {
        t.e(qVar, "operation");
        long[] jArr = this.content;
        int i5 = this._size;
        while (true) {
            i5--;
            if (-1 >= i5) {
                return r5;
            }
            r5 = qVar.invoke(Integer.valueOf(i5), Long.valueOf(jArr[i5]), r5);
        }
    }

    public final void forEach(l lVar) {
        t.e(lVar, "block");
        long[] jArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            lVar.invoke(Long.valueOf(jArr[i6]));
        }
    }

    public final void forEachIndexed(p pVar) {
        t.e(pVar, "block");
        long[] jArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            pVar.invoke(Integer.valueOf(i6), Long.valueOf(jArr[i6]));
        }
    }

    public final void forEachReversed(l lVar) {
        t.e(lVar, "block");
        long[] jArr = this.content;
        int i5 = this._size;
        while (true) {
            i5--;
            if (-1 < i5) {
                lVar.invoke(Long.valueOf(jArr[i5]));
            } else {
                return;
            }
        }
    }

    public final void forEachReversedIndexed(p pVar) {
        t.e(pVar, "block");
        long[] jArr = this.content;
        int i5 = this._size;
        while (true) {
            i5--;
            if (-1 < i5) {
                pVar.invoke(Integer.valueOf(i5), Long.valueOf(jArr[i5]));
            } else {
                return;
            }
        }
    }

    public final long get(@IntRange(from = 0) int i5) {
        if (i5 >= 0 && i5 < this._size) {
            return this.content[i5];
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Index ");
        sb.append(i5);
        sb.append(" must be in 0..");
        sb.append(this._size - 1);
        throw new IndexOutOfBoundsException(sb.toString());
    }

    public final C2728d getIndices() {
        return C2729e.l(0, this._size);
    }

    @IntRange(from = -1)
    public final int getLastIndex() {
        return this._size - 1;
    }

    @IntRange(from = 0)
    public final int getSize() {
        return this._size;
    }

    public int hashCode() {
        long[] jArr = this.content;
        int i5 = this._size;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            i6 += a.a(jArr[i7]) * 31;
        }
        return i6;
    }

    public final int indexOf(long j5) {
        long[] jArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            if (j5 == jArr[i6]) {
                return i6;
            }
        }
        return -1;
    }

    public final int indexOfFirst(l lVar) {
        t.e(lVar, "predicate");
        long[] jArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            if (((Boolean) lVar.invoke(Long.valueOf(jArr[i6]))).booleanValue()) {
                return i6;
            }
        }
        return -1;
    }

    public final int indexOfLast(l lVar) {
        t.e(lVar, "predicate");
        long[] jArr = this.content;
        int i5 = this._size;
        while (true) {
            i5--;
            if (-1 >= i5) {
                return -1;
            }
            if (((Boolean) lVar.invoke(Long.valueOf(jArr[i5]))).booleanValue()) {
                return i5;
            }
        }
    }

    public final boolean isEmpty() {
        if (this._size == 0) {
            return true;
        }
        return false;
    }

    public final boolean isNotEmpty() {
        if (this._size != 0) {
            return true;
        }
        return false;
    }

    public final String joinToString() {
        return joinToString$default(this, (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, 31, (Object) null);
    }

    public final long last() {
        if (!isEmpty()) {
            return this.content[this._size - 1];
        }
        throw new NoSuchElementException("LongList is empty.");
    }

    public final int lastIndexOf(long j5) {
        long[] jArr = this.content;
        int i5 = this._size;
        while (true) {
            i5--;
            if (-1 >= i5) {
                return -1;
            }
            if (jArr[i5] == j5) {
                return i5;
            }
        }
    }

    public final boolean none() {
        return isEmpty();
    }

    public final boolean reversedAny(l lVar) {
        t.e(lVar, "predicate");
        long[] jArr = this.content;
        for (int i5 = this._size - 1; -1 < i5; i5--) {
            if (((Boolean) lVar.invoke(Long.valueOf(jArr[i5]))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return joinToString$default(this, (CharSequence) null, "[", "]", 0, (CharSequence) null, 25, (Object) null);
    }

    private LongList(int i5) {
        long[] jArr;
        if (i5 == 0) {
            jArr = LongSetKt.getEmptyLongArray();
        } else {
            jArr = new long[i5];
        }
        this.content = jArr;
    }

    public final boolean any(l lVar) {
        t.e(lVar, "predicate");
        long[] jArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            if (((Boolean) lVar.invoke(Long.valueOf(jArr[i6]))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final int count(l lVar) {
        t.e(lVar, "predicate");
        long[] jArr = this.content;
        int i5 = this._size;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            if (((Boolean) lVar.invoke(Long.valueOf(jArr[i7]))).booleanValue()) {
                i6++;
            }
        }
        return i6;
    }

    public final String joinToString(CharSequence charSequence) {
        t.e(charSequence, "separator");
        return joinToString$default(this, charSequence, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, 30, (Object) null);
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2) {
        t.e(charSequence, "separator");
        t.e(charSequence2, "prefix");
        return joinToString$default(this, charSequence, charSequence2, (CharSequence) null, 0, (CharSequence) null, 28, (Object) null);
    }

    public final long first(l lVar) {
        t.e(lVar, "predicate");
        long[] jArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            long j5 = jArr[i6];
            if (((Boolean) lVar.invoke(Long.valueOf(j5))).booleanValue()) {
                return j5;
            }
        }
        throw new NoSuchElementException("LongList contains no element matching the predicate.");
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        t.e(charSequence, "separator");
        t.e(charSequence2, "prefix");
        t.e(charSequence3, "postfix");
        return joinToString$default(this, charSequence, charSequence2, charSequence3, 0, (CharSequence) null, 24, (Object) null);
    }

    public static /* synthetic */ String joinToString$default(LongList longList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, l lVar, int i6, Object obj) {
        if (obj == null) {
            if ((i6 & 1) != 0) {
                charSequence = ", ";
            }
            if ((i6 & 2) != 0) {
                charSequence2 = "";
            }
            if ((i6 & 4) != 0) {
                charSequence3 = "";
            }
            if ((i6 & 8) != 0) {
                i5 = -1;
            }
            if ((i6 & 16) != 0) {
                charSequence4 = "...";
            }
            t.e(charSequence, "separator");
            t.e(charSequence2, "prefix");
            t.e(charSequence3, "postfix");
            t.e(charSequence4, "truncated");
            t.e(lVar, "transform");
            StringBuilder sb = new StringBuilder();
            sb.append(charSequence2);
            long[] jArr = longList.content;
            int i7 = longList._size;
            int i8 = 0;
            while (true) {
                if (i8 >= i7) {
                    sb.append(charSequence3);
                    break;
                }
                long j5 = jArr[i8];
                if (i8 == i5) {
                    sb.append(charSequence4);
                    break;
                }
                if (i8 != 0) {
                    sb.append(charSequence);
                }
                sb.append((CharSequence) lVar.invoke(Long.valueOf(j5)));
                i8++;
            }
            String sb2 = sb.toString();
            t.d(sb2, "StringBuilder().apply(builderAction).toString()");
            return sb2;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5) {
        t.e(charSequence, "separator");
        t.e(charSequence2, "prefix");
        t.e(charSequence3, "postfix");
        return joinToString$default(this, charSequence, charSequence2, charSequence3, i5, (CharSequence) null, 16, (Object) null);
    }

    public final long last(l lVar) {
        t.e(lVar, "predicate");
        long[] jArr = this.content;
        int i5 = this._size;
        while (true) {
            i5--;
            if (-1 < i5) {
                long j5 = jArr[i5];
                if (((Boolean) lVar.invoke(Long.valueOf(j5))).booleanValue()) {
                    return j5;
                }
            } else {
                throw new NoSuchElementException("LongList contains no element matching the predicate.");
            }
        }
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4) {
        t.e(charSequence, "separator");
        t.e(charSequence2, "prefix");
        t.e(charSequence3, "postfix");
        t.e(charSequence4, "truncated");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        long[] jArr = this.content;
        int i6 = this._size;
        int i7 = 0;
        while (true) {
            if (i7 >= i6) {
                sb.append(charSequence3);
                break;
            }
            long j5 = jArr[i7];
            if (i7 == i5) {
                sb.append(charSequence4);
                break;
            }
            if (i7 != 0) {
                sb.append(charSequence);
            }
            sb.append(j5);
            i7++;
        }
        String sb2 = sb.toString();
        t.d(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, l lVar) {
        t.e(charSequence, "separator");
        t.e(charSequence2, "prefix");
        t.e(charSequence3, "postfix");
        t.e(charSequence4, "truncated");
        t.e(lVar, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        long[] jArr = this.content;
        int i6 = this._size;
        int i7 = 0;
        while (true) {
            if (i7 >= i6) {
                sb.append(charSequence3);
                break;
            }
            long j5 = jArr[i7];
            if (i7 == i5) {
                sb.append(charSequence4);
                break;
            }
            if (i7 != 0) {
                sb.append(charSequence);
            }
            sb.append((CharSequence) lVar.invoke(Long.valueOf(j5)));
            i7++;
        }
        String sb2 = sb.toString();
        t.d(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, l lVar) {
        t.e(charSequence, "separator");
        t.e(charSequence2, "prefix");
        t.e(charSequence3, "postfix");
        t.e(lVar, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        long[] jArr = this.content;
        int i6 = this._size;
        int i7 = 0;
        while (true) {
            if (i7 >= i6) {
                sb.append(charSequence3);
                break;
            }
            long j5 = jArr[i7];
            if (i7 == i5) {
                sb.append("...");
                break;
            }
            if (i7 != 0) {
                sb.append(charSequence);
            }
            sb.append((CharSequence) lVar.invoke(Long.valueOf(j5)));
            i7++;
        }
        String sb2 = sb.toString();
        t.d(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, l lVar) {
        t.e(charSequence, "separator");
        t.e(charSequence2, "prefix");
        t.e(charSequence3, "postfix");
        t.e(lVar, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        long[] jArr = this.content;
        int i5 = this._size;
        int i6 = 0;
        while (true) {
            if (i6 >= i5) {
                sb.append(charSequence3);
                break;
            }
            long j5 = jArr[i6];
            if (i6 == -1) {
                sb.append("...");
                break;
            }
            if (i6 != 0) {
                sb.append(charSequence);
            }
            sb.append((CharSequence) lVar.invoke(Long.valueOf(j5)));
            i6++;
        }
        String sb2 = sb.toString();
        t.d(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, l lVar) {
        t.e(charSequence, "separator");
        t.e(charSequence2, "prefix");
        t.e(lVar, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append(charSequence2);
        long[] jArr = this.content;
        int i5 = this._size;
        int i6 = 0;
        while (true) {
            if (i6 >= i5) {
                sb.append("");
                break;
            }
            long j5 = jArr[i6];
            if (i6 == -1) {
                sb.append("...");
                break;
            }
            if (i6 != 0) {
                sb.append(charSequence);
            }
            sb.append((CharSequence) lVar.invoke(Long.valueOf(j5)));
            i6++;
        }
        String sb2 = sb.toString();
        t.d(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String joinToString(CharSequence charSequence, l lVar) {
        t.e(charSequence, "separator");
        t.e(lVar, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append("");
        long[] jArr = this.content;
        int i5 = this._size;
        int i6 = 0;
        while (true) {
            if (i6 >= i5) {
                sb.append("");
                break;
            }
            long j5 = jArr[i6];
            if (i6 == -1) {
                sb.append("...");
                break;
            }
            if (i6 != 0) {
                sb.append(charSequence);
            }
            sb.append((CharSequence) lVar.invoke(Long.valueOf(j5)));
            i6++;
        }
        String sb2 = sb.toString();
        t.d(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public final String joinToString(l lVar) {
        t.e(lVar, "transform");
        StringBuilder sb = new StringBuilder();
        sb.append("");
        long[] jArr = this.content;
        int i5 = this._size;
        int i6 = 0;
        while (true) {
            if (i6 >= i5) {
                sb.append("");
                break;
            }
            long j5 = jArr[i6];
            if (i6 == -1) {
                sb.append("...");
                break;
            }
            if (i6 != 0) {
                sb.append(", ");
            }
            sb.append((CharSequence) lVar.invoke(Long.valueOf(j5)));
            i6++;
        }
        String sb2 = sb.toString();
        t.d(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
