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

public abstract class FloatList {
    public int _size;
    public float[] content;

    public /* synthetic */ FloatList(int i5, C2633k kVar) {
        this(i5);
    }

    public static /* synthetic */ void getContent$annotations() {
    }

    public static /* synthetic */ void get_size$annotations() {
    }

    public static /* synthetic */ String joinToString$default(FloatList floatList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, int i6, Object obj) {
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
            return floatList.joinToString(charSequence, charSequence2, charSequence3, i7, charSequence5);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: joinToString");
    }

    public final boolean any() {
        return isNotEmpty();
    }

    public final boolean contains(float f5) {
        float[] fArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            if (fArr[i6] == f5) {
                return true;
            }
        }
        return false;
    }

    public final boolean containsAll(FloatList floatList) {
        t.e(floatList, "elements");
        C2728d l5 = C2729e.l(0, floatList._size);
        int c5 = l5.c();
        int f5 = l5.f();
        if (c5 > f5) {
            return true;
        }
        while (contains(floatList.get(c5))) {
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

    public final float elementAt(@IntRange(from = 0) int i5) {
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

    public final float elementAtOrElse(@IntRange(from = 0) int i5, l lVar) {
        t.e(lVar, "defaultValue");
        if (i5 < 0 || i5 >= this._size) {
            return ((Number) lVar.invoke(Integer.valueOf(i5))).floatValue();
        }
        return this.content[i5];
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0005, code lost:
        r7 = (androidx.collection.FloatList) r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof androidx.collection.FloatList
            r1 = 0
            if (r0 == 0) goto L_0x0030
            androidx.collection.FloatList r7 = (androidx.collection.FloatList) r7
            int r0 = r7._size
            int r2 = r6._size
            if (r0 == r2) goto L_0x000e
            goto L_0x0030
        L_0x000e:
            float[] r0 = r6.content
            float[] r7 = r7.content
            q3.d r2 = q3.C2729e.l(r1, r2)
            int r3 = r2.c()
            int r2 = r2.f()
            if (r3 > r2) goto L_0x002e
        L_0x0020:
            r4 = r0[r3]
            r5 = r7[r3]
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 != 0) goto L_0x002d
            if (r3 == r2) goto L_0x002e
            int r3 = r3 + 1
            goto L_0x0020
        L_0x002d:
            return r1
        L_0x002e:
            r7 = 1
            return r7
        L_0x0030:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.collection.FloatList.equals(java.lang.Object):boolean");
    }

    public final float first() {
        if (!isEmpty()) {
            return this.content[0];
        }
        throw new NoSuchElementException("FloatList is empty.");
    }

    public final <R> R fold(R r5, p pVar) {
        t.e(pVar, "operation");
        float[] fArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            r5 = pVar.invoke(r5, Float.valueOf(fArr[i6]));
        }
        return r5;
    }

    public final <R> R foldIndexed(R r5, q qVar) {
        t.e(qVar, "operation");
        float[] fArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            r5 = qVar.invoke(Integer.valueOf(i6), r5, Float.valueOf(fArr[i6]));
        }
        return r5;
    }

    public final <R> R foldRight(R r5, p pVar) {
        t.e(pVar, "operation");
        float[] fArr = this.content;
        int i5 = this._size;
        while (true) {
            i5--;
            if (-1 >= i5) {
                return r5;
            }
            r5 = pVar.invoke(Float.valueOf(fArr[i5]), r5);
        }
    }

    public final <R> R foldRightIndexed(R r5, q qVar) {
        t.e(qVar, "operation");
        float[] fArr = this.content;
        int i5 = this._size;
        while (true) {
            i5--;
            if (-1 >= i5) {
                return r5;
            }
            r5 = qVar.invoke(Integer.valueOf(i5), Float.valueOf(fArr[i5]), r5);
        }
    }

    public final void forEach(l lVar) {
        t.e(lVar, "block");
        float[] fArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            lVar.invoke(Float.valueOf(fArr[i6]));
        }
    }

    public final void forEachIndexed(p pVar) {
        t.e(pVar, "block");
        float[] fArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            pVar.invoke(Integer.valueOf(i6), Float.valueOf(fArr[i6]));
        }
    }

    public final void forEachReversed(l lVar) {
        t.e(lVar, "block");
        float[] fArr = this.content;
        int i5 = this._size;
        while (true) {
            i5--;
            if (-1 < i5) {
                lVar.invoke(Float.valueOf(fArr[i5]));
            } else {
                return;
            }
        }
    }

    public final void forEachReversedIndexed(p pVar) {
        t.e(pVar, "block");
        float[] fArr = this.content;
        int i5 = this._size;
        while (true) {
            i5--;
            if (-1 < i5) {
                pVar.invoke(Integer.valueOf(i5), Float.valueOf(fArr[i5]));
            } else {
                return;
            }
        }
    }

    public final float get(@IntRange(from = 0) int i5) {
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
        float[] fArr = this.content;
        int i5 = this._size;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            i6 += Float.floatToIntBits(fArr[i7]) * 31;
        }
        return i6;
    }

    public final int indexOf(float f5) {
        float[] fArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            if (f5 == fArr[i6]) {
                return i6;
            }
        }
        return -1;
    }

    public final int indexOfFirst(l lVar) {
        t.e(lVar, "predicate");
        float[] fArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            if (((Boolean) lVar.invoke(Float.valueOf(fArr[i6]))).booleanValue()) {
                return i6;
            }
        }
        return -1;
    }

    public final int indexOfLast(l lVar) {
        t.e(lVar, "predicate");
        float[] fArr = this.content;
        int i5 = this._size;
        while (true) {
            i5--;
            if (-1 >= i5) {
                return -1;
            }
            if (((Boolean) lVar.invoke(Float.valueOf(fArr[i5]))).booleanValue()) {
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

    public final float last() {
        if (!isEmpty()) {
            return this.content[this._size - 1];
        }
        throw new NoSuchElementException("FloatList is empty.");
    }

    public final int lastIndexOf(float f5) {
        float[] fArr = this.content;
        int i5 = this._size;
        while (true) {
            i5--;
            if (-1 >= i5) {
                return -1;
            }
            if (fArr[i5] == f5) {
                return i5;
            }
        }
    }

    public final boolean none() {
        return isEmpty();
    }

    public final boolean reversedAny(l lVar) {
        t.e(lVar, "predicate");
        float[] fArr = this.content;
        for (int i5 = this._size - 1; -1 < i5; i5--) {
            if (((Boolean) lVar.invoke(Float.valueOf(fArr[i5]))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return joinToString$default(this, (CharSequence) null, "[", "]", 0, (CharSequence) null, 25, (Object) null);
    }

    private FloatList(int i5) {
        float[] fArr;
        if (i5 == 0) {
            fArr = FloatSetKt.getEmptyFloatArray();
        } else {
            fArr = new float[i5];
        }
        this.content = fArr;
    }

    public final boolean any(l lVar) {
        t.e(lVar, "predicate");
        float[] fArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            if (((Boolean) lVar.invoke(Float.valueOf(fArr[i6]))).booleanValue()) {
                return true;
            }
        }
        return false;
    }

    public final int count(l lVar) {
        t.e(lVar, "predicate");
        float[] fArr = this.content;
        int i5 = this._size;
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            if (((Boolean) lVar.invoke(Float.valueOf(fArr[i7]))).booleanValue()) {
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

    public final float first(l lVar) {
        t.e(lVar, "predicate");
        float[] fArr = this.content;
        int i5 = this._size;
        for (int i6 = 0; i6 < i5; i6++) {
            float f5 = fArr[i6];
            if (((Boolean) lVar.invoke(Float.valueOf(f5))).booleanValue()) {
                return f5;
            }
        }
        throw new NoSuchElementException("FloatList contains no element matching the predicate.");
    }

    public final String joinToString(CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3) {
        t.e(charSequence, "separator");
        t.e(charSequence2, "prefix");
        t.e(charSequence3, "postfix");
        return joinToString$default(this, charSequence, charSequence2, charSequence3, 0, (CharSequence) null, 24, (Object) null);
    }

    public static /* synthetic */ String joinToString$default(FloatList floatList, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i5, CharSequence charSequence4, l lVar, int i6, Object obj) {
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
            float[] fArr = floatList.content;
            int i7 = floatList._size;
            int i8 = 0;
            while (true) {
                if (i8 >= i7) {
                    sb.append(charSequence3);
                    break;
                }
                float f5 = fArr[i8];
                if (i8 == i5) {
                    sb.append(charSequence4);
                    break;
                }
                if (i8 != 0) {
                    sb.append(charSequence);
                }
                sb.append((CharSequence) lVar.invoke(Float.valueOf(f5)));
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

    public final float last(l lVar) {
        t.e(lVar, "predicate");
        float[] fArr = this.content;
        int i5 = this._size;
        while (true) {
            i5--;
            if (-1 < i5) {
                float f5 = fArr[i5];
                if (((Boolean) lVar.invoke(Float.valueOf(f5))).booleanValue()) {
                    return f5;
                }
            } else {
                throw new NoSuchElementException("FloatList contains no element matching the predicate.");
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
        float[] fArr = this.content;
        int i6 = this._size;
        int i7 = 0;
        while (true) {
            if (i7 >= i6) {
                sb.append(charSequence3);
                break;
            }
            float f5 = fArr[i7];
            if (i7 == i5) {
                sb.append(charSequence4);
                break;
            }
            if (i7 != 0) {
                sb.append(charSequence);
            }
            sb.append(f5);
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
        float[] fArr = this.content;
        int i6 = this._size;
        int i7 = 0;
        while (true) {
            if (i7 >= i6) {
                sb.append(charSequence3);
                break;
            }
            float f5 = fArr[i7];
            if (i7 == i5) {
                sb.append(charSequence4);
                break;
            }
            if (i7 != 0) {
                sb.append(charSequence);
            }
            sb.append((CharSequence) lVar.invoke(Float.valueOf(f5)));
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
        float[] fArr = this.content;
        int i6 = this._size;
        int i7 = 0;
        while (true) {
            if (i7 >= i6) {
                sb.append(charSequence3);
                break;
            }
            float f5 = fArr[i7];
            if (i7 == i5) {
                sb.append("...");
                break;
            }
            if (i7 != 0) {
                sb.append(charSequence);
            }
            sb.append((CharSequence) lVar.invoke(Float.valueOf(f5)));
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
        float[] fArr = this.content;
        int i5 = this._size;
        int i6 = 0;
        while (true) {
            if (i6 >= i5) {
                sb.append(charSequence3);
                break;
            }
            float f5 = fArr[i6];
            if (i6 == -1) {
                sb.append("...");
                break;
            }
            if (i6 != 0) {
                sb.append(charSequence);
            }
            sb.append((CharSequence) lVar.invoke(Float.valueOf(f5)));
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
        float[] fArr = this.content;
        int i5 = this._size;
        int i6 = 0;
        while (true) {
            if (i6 >= i5) {
                sb.append("");
                break;
            }
            float f5 = fArr[i6];
            if (i6 == -1) {
                sb.append("...");
                break;
            }
            if (i6 != 0) {
                sb.append(charSequence);
            }
            sb.append((CharSequence) lVar.invoke(Float.valueOf(f5)));
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
        float[] fArr = this.content;
        int i5 = this._size;
        int i6 = 0;
        while (true) {
            if (i6 >= i5) {
                sb.append("");
                break;
            }
            float f5 = fArr[i6];
            if (i6 == -1) {
                sb.append("...");
                break;
            }
            if (i6 != 0) {
                sb.append(charSequence);
            }
            sb.append((CharSequence) lVar.invoke(Float.valueOf(f5)));
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
        float[] fArr = this.content;
        int i5 = this._size;
        int i6 = 0;
        while (true) {
            if (i6 >= i5) {
                sb.append("");
                break;
            }
            float f5 = fArr[i6];
            if (i6 == -1) {
                sb.append("...");
                break;
            }
            if (i6 != 0) {
                sb.append(", ");
            }
            sb.append((CharSequence) lVar.invoke(Float.valueOf(f5)));
            i6++;
        }
        String sb2 = sb.toString();
        t.d(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }
}
