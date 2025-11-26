package X2;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import q3.C2729e;

/* renamed from: X2.h  reason: case insensitive filesystem */
public final class C2241h extends C2238e {

    /* renamed from: d  reason: collision with root package name */
    public static final a f20064d = new a((C2633k) null);

    /* renamed from: e  reason: collision with root package name */
    private static final Object[] f20065e = new Object[0];

    /* renamed from: a  reason: collision with root package name */
    private int f20066a;

    /* renamed from: b  reason: collision with root package name */
    private Object[] f20067b = f20065e;

    /* renamed from: c  reason: collision with root package name */
    private int f20068c;

    /* renamed from: X2.h$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    private final void g(int i5, Collection collection) {
        Iterator it = collection.iterator();
        int length = this.f20067b.length;
        while (i5 < length && it.hasNext()) {
            this.f20067b[i5] = it.next();
            i5++;
        }
        int i6 = this.f20066a;
        for (int i7 = 0; i7 < i6 && it.hasNext(); i7++) {
            this.f20067b[i7] = it.next();
        }
        this.f20068c = size() + collection.size();
    }

    private final void i(int i5) {
        Object[] objArr = new Object[i5];
        Object[] objArr2 = this.f20067b;
        C2245l.l(objArr2, objArr, 0, this.f20066a, objArr2.length);
        Object[] objArr3 = this.f20067b;
        int length = objArr3.length;
        int i6 = this.f20066a;
        C2245l.l(objArr3, objArr, length - i6, 0, i6);
        this.f20066a = 0;
        this.f20067b = objArr;
    }

    private final int j(int i5) {
        if (i5 == 0) {
            return C2247n.S(this.f20067b);
        }
        return i5 - 1;
    }

    private final void k(int i5) {
        if (i5 >= 0) {
            Object[] objArr = this.f20067b;
            if (i5 > objArr.length) {
                if (objArr == f20065e) {
                    this.f20067b = new Object[C2729e.c(i5, 10)];
                } else {
                    i(C2236c.Companion.e(objArr.length, i5));
                }
            }
        } else {
            throw new IllegalStateException("Deque is too big.");
        }
    }

    private final int n(int i5) {
        if (i5 == C2247n.S(this.f20067b)) {
            return 0;
        }
        return i5 + 1;
    }

    private final int o(int i5) {
        if (i5 < 0) {
            return i5 + this.f20067b.length;
        }
        return i5;
    }

    private final void p(int i5, int i6) {
        if (i5 < i6) {
            C2245l.v(this.f20067b, (Object) null, i5, i6);
            return;
        }
        Object[] objArr = this.f20067b;
        C2245l.v(objArr, (Object) null, i5, objArr.length);
        C2245l.v(this.f20067b, (Object) null, 0, i6);
    }

    private final int q(int i5) {
        Object[] objArr = this.f20067b;
        if (i5 >= objArr.length) {
            return i5 - objArr.length;
        }
        return i5;
    }

    private final void r() {
        this.modCount++;
    }

    private final void u(int i5, int i6) {
        int q5 = q(this.f20066a + (i5 - 1));
        int q6 = q(this.f20066a + (i6 - 1));
        while (i5 > 0) {
            int i7 = q5 + 1;
            int min = Math.min(i5, Math.min(i7, q6 + 1));
            Object[] objArr = this.f20067b;
            int i8 = q6 - min;
            int i9 = q5 - min;
            C2245l.l(objArr, objArr, i8 + 1, i9 + 1, i7);
            q5 = o(i9);
            q6 = o(i8);
            i5 -= min;
        }
    }

    private final void v(int i5, int i6) {
        int q5 = q(this.f20066a + i6);
        int q6 = q(this.f20066a + i5);
        int size = size();
        while (true) {
            size -= i6;
            if (size > 0) {
                Object[] objArr = this.f20067b;
                i6 = Math.min(size, Math.min(objArr.length - q5, objArr.length - q6));
                Object[] objArr2 = this.f20067b;
                int i7 = q5 + i6;
                C2245l.l(objArr2, objArr2, q6, q5, i7);
                q5 = q(i7);
                q6 = q(q6 + i6);
            } else {
                return;
            }
        }
    }

    public boolean add(Object obj) {
        addLast(obj);
        return true;
    }

    public boolean addAll(Collection collection) {
        t.e(collection, "elements");
        if (collection.isEmpty()) {
            return false;
        }
        r();
        k(size() + collection.size());
        g(q(this.f20066a + size()), collection);
        return true;
    }

    public final void addFirst(Object obj) {
        r();
        k(size() + 1);
        int j5 = j(this.f20066a);
        this.f20066a = j5;
        this.f20067b[j5] = obj;
        this.f20068c = size() + 1;
    }

    public final void addLast(Object obj) {
        r();
        k(size() + 1);
        this.f20067b[q(this.f20066a + size())] = obj;
        this.f20068c = size() + 1;
    }

    public int c() {
        return this.f20068c;
    }

    public void clear() {
        if (!isEmpty()) {
            r();
            p(this.f20066a, q(this.f20066a + size()));
        }
        this.f20066a = 0;
        this.f20068c = 0;
    }

    public boolean contains(Object obj) {
        if (indexOf(obj) != -1) {
            return true;
        }
        return false;
    }

    public Object f(int i5) {
        C2236c.Companion.b(i5, size());
        if (i5 == C2251s.i(this)) {
            return removeLast();
        }
        if (i5 == 0) {
            return removeFirst();
        }
        r();
        int q5 = q(this.f20066a + i5);
        Object obj = this.f20067b[q5];
        if (i5 < (size() >> 1)) {
            int i6 = this.f20066a;
            if (q5 >= i6) {
                Object[] objArr = this.f20067b;
                C2245l.l(objArr, objArr, i6 + 1, i6, q5);
            } else {
                Object[] objArr2 = this.f20067b;
                C2245l.l(objArr2, objArr2, 1, 0, q5);
                Object[] objArr3 = this.f20067b;
                objArr3[0] = objArr3[objArr3.length - 1];
                int i7 = this.f20066a;
                C2245l.l(objArr3, objArr3, i7 + 1, i7, objArr3.length - 1);
            }
            Object[] objArr4 = this.f20067b;
            int i8 = this.f20066a;
            objArr4[i8] = null;
            this.f20066a = n(i8);
        } else {
            int q6 = q(this.f20066a + C2251s.i(this));
            if (q5 <= q6) {
                Object[] objArr5 = this.f20067b;
                C2245l.l(objArr5, objArr5, q5, q5 + 1, q6 + 1);
            } else {
                Object[] objArr6 = this.f20067b;
                C2245l.l(objArr6, objArr6, q5, q5 + 1, objArr6.length);
                Object[] objArr7 = this.f20067b;
                objArr7[objArr7.length - 1] = objArr7[0];
                C2245l.l(objArr7, objArr7, 0, 1, q6 + 1);
            }
            this.f20067b[q6] = null;
        }
        this.f20068c = size() - 1;
        return obj;
    }

    public Object get(int i5) {
        C2236c.Companion.b(i5, size());
        return this.f20067b[q(this.f20066a + i5)];
    }

    public int indexOf(Object obj) {
        int i5;
        int q5 = q(this.f20066a + size());
        int i6 = this.f20066a;
        if (i6 < q5) {
            while (i6 < q5) {
                if (t.a(obj, this.f20067b[i6])) {
                    i5 = this.f20066a;
                } else {
                    i6++;
                }
            }
            return -1;
        } else if (i6 < q5) {
            return -1;
        } else {
            int length = this.f20067b.length;
            while (true) {
                if (i6 >= length) {
                    int i7 = 0;
                    while (i7 < q5) {
                        if (t.a(obj, this.f20067b[i7])) {
                            i6 = i7 + this.f20067b.length;
                            i5 = this.f20066a;
                        } else {
                            i7++;
                        }
                    }
                    return -1;
                } else if (t.a(obj, this.f20067b[i6])) {
                    i5 = this.f20066a;
                    break;
                } else {
                    i6++;
                }
            }
        }
        return i6 - i5;
    }

    public boolean isEmpty() {
        if (size() == 0) {
            return true;
        }
        return false;
    }

    public final Object l() {
        if (isEmpty()) {
            return null;
        }
        return this.f20067b[this.f20066a];
    }

    public final Object last() {
        if (!isEmpty()) {
            return this.f20067b[q(this.f20066a + C2251s.i(this))];
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public int lastIndexOf(Object obj) {
        int i5;
        int i6;
        int q5 = q(this.f20066a + size());
        int i7 = this.f20066a;
        if (i7 < q5) {
            i5 = q5 - 1;
            if (i7 <= i5) {
                while (!t.a(obj, this.f20067b[i5])) {
                    if (i5 != i7) {
                        i5--;
                    }
                }
                i6 = this.f20066a;
            }
            return -1;
        }
        if (i7 > q5) {
            int i8 = q5 - 1;
            while (true) {
                if (-1 >= i8) {
                    int S4 = C2247n.S(this.f20067b);
                    int i9 = this.f20066a;
                    if (i9 <= S4) {
                        while (!t.a(obj, this.f20067b[i5])) {
                            if (i5 != i9) {
                                S4 = i5 - 1;
                            }
                        }
                        i6 = this.f20066a;
                    }
                } else if (t.a(obj, this.f20067b[i8])) {
                    i5 = i8 + this.f20067b.length;
                    i6 = this.f20066a;
                    break;
                } else {
                    i8--;
                }
            }
        }
        return -1;
        return i5 - i6;
    }

    public boolean remove(Object obj) {
        int indexOf = indexOf(obj);
        if (indexOf == -1) {
            return false;
        }
        remove(indexOf);
        return true;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [int] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean removeAll(java.util.Collection r12) {
        /*
            r11 = this;
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.t.e(r12, r0)
            boolean r0 = r11.isEmpty()
            r1 = 0
            if (r0 != 0) goto L_0x0091
            java.lang.Object[] r0 = r11.f20067b
            int r0 = r0.length
            if (r0 != 0) goto L_0x0013
            goto L_0x0091
        L_0x0013:
            int r0 = r11.f20066a
            int r2 = r11.size()
            int r0 = r0 + r2
            int r0 = r11.q(r0)
            int r2 = r11.f20066a
            r3 = 0
            r4 = 1
            if (r2 >= r0) goto L_0x0043
            r5 = r2
        L_0x0025:
            if (r2 >= r0) goto L_0x003d
            java.lang.Object[] r6 = r11.f20067b
            r6 = r6[r2]
            boolean r7 = r12.contains(r6)
            if (r7 != 0) goto L_0x0039
            java.lang.Object[] r7 = r11.f20067b
            int r8 = r5 + 1
            r7[r5] = r6
            r5 = r8
            goto L_0x003a
        L_0x0039:
            r1 = r4
        L_0x003a:
            int r2 = r2 + 1
            goto L_0x0025
        L_0x003d:
            java.lang.Object[] r12 = r11.f20067b
            X2.C2245l.v(r12, r3, r5, r0)
            goto L_0x0083
        L_0x0043:
            java.lang.Object[] r5 = r11.f20067b
            int r5 = r5.length
            r7 = r1
            r6 = r2
        L_0x0048:
            if (r2 >= r5) goto L_0x0062
            java.lang.Object[] r8 = r11.f20067b
            r9 = r8[r2]
            r8[r2] = r3
            boolean r8 = r12.contains(r9)
            if (r8 != 0) goto L_0x005e
            java.lang.Object[] r8 = r11.f20067b
            int r10 = r6 + 1
            r8[r6] = r9
            r6 = r10
            goto L_0x005f
        L_0x005e:
            r7 = r4
        L_0x005f:
            int r2 = r2 + 1
            goto L_0x0048
        L_0x0062:
            int r2 = r11.q(r6)
            r5 = r2
        L_0x0067:
            if (r1 >= r0) goto L_0x0082
            java.lang.Object[] r2 = r11.f20067b
            r6 = r2[r1]
            r2[r1] = r3
            boolean r2 = r12.contains(r6)
            if (r2 != 0) goto L_0x007e
            java.lang.Object[] r2 = r11.f20067b
            r2[r5] = r6
            int r5 = r11.n(r5)
            goto L_0x007f
        L_0x007e:
            r7 = r4
        L_0x007f:
            int r1 = r1 + 1
            goto L_0x0067
        L_0x0082:
            r1 = r7
        L_0x0083:
            if (r1 == 0) goto L_0x0091
            r11.r()
            int r12 = r11.f20066a
            int r5 = r5 - r12
            int r12 = r11.o(r5)
            r11.f20068c = r12
        L_0x0091:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: X2.C2241h.removeAll(java.util.Collection):boolean");
    }

    public final Object removeFirst() {
        if (!isEmpty()) {
            r();
            Object[] objArr = this.f20067b;
            int i5 = this.f20066a;
            Object obj = objArr[i5];
            objArr[i5] = null;
            this.f20066a = n(i5);
            this.f20068c = size() - 1;
            return obj;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    public final Object removeLast() {
        if (!isEmpty()) {
            r();
            int q5 = q(this.f20066a + C2251s.i(this));
            Object[] objArr = this.f20067b;
            Object obj = objArr[q5];
            objArr[q5] = null;
            this.f20068c = size() - 1;
            return obj;
        }
        throw new NoSuchElementException("ArrayDeque is empty.");
    }

    /* access modifiers changed from: protected */
    public void removeRange(int i5, int i6) {
        C2236c.Companion.d(i5, i6, size());
        int i7 = i6 - i5;
        if (i7 != 0) {
            if (i7 == size()) {
                clear();
            } else if (i7 == 1) {
                remove(i5);
            } else {
                r();
                if (i5 < size() - i6) {
                    u(i5, i6);
                    int q5 = q(this.f20066a + i7);
                    p(this.f20066a, q5);
                    this.f20066a = q5;
                } else {
                    v(i5, i6);
                    int q6 = q(this.f20066a + size());
                    p(o(q6 - i7), q6);
                }
                this.f20068c = size() - i7;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v3, types: [int] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v9 */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean retainAll(java.util.Collection r12) {
        /*
            r11 = this;
            java.lang.String r0 = "elements"
            kotlin.jvm.internal.t.e(r12, r0)
            boolean r0 = r11.isEmpty()
            r1 = 0
            if (r0 != 0) goto L_0x0091
            java.lang.Object[] r0 = r11.f20067b
            int r0 = r0.length
            if (r0 != 0) goto L_0x0013
            goto L_0x0091
        L_0x0013:
            int r0 = r11.f20066a
            int r2 = r11.size()
            int r0 = r0 + r2
            int r0 = r11.q(r0)
            int r2 = r11.f20066a
            r3 = 0
            r4 = 1
            if (r2 >= r0) goto L_0x0043
            r5 = r2
        L_0x0025:
            if (r2 >= r0) goto L_0x003d
            java.lang.Object[] r6 = r11.f20067b
            r6 = r6[r2]
            boolean r7 = r12.contains(r6)
            if (r7 == 0) goto L_0x0039
            java.lang.Object[] r7 = r11.f20067b
            int r8 = r5 + 1
            r7[r5] = r6
            r5 = r8
            goto L_0x003a
        L_0x0039:
            r1 = r4
        L_0x003a:
            int r2 = r2 + 1
            goto L_0x0025
        L_0x003d:
            java.lang.Object[] r12 = r11.f20067b
            X2.C2245l.v(r12, r3, r5, r0)
            goto L_0x0083
        L_0x0043:
            java.lang.Object[] r5 = r11.f20067b
            int r5 = r5.length
            r7 = r1
            r6 = r2
        L_0x0048:
            if (r2 >= r5) goto L_0x0062
            java.lang.Object[] r8 = r11.f20067b
            r9 = r8[r2]
            r8[r2] = r3
            boolean r8 = r12.contains(r9)
            if (r8 == 0) goto L_0x005e
            java.lang.Object[] r8 = r11.f20067b
            int r10 = r6 + 1
            r8[r6] = r9
            r6 = r10
            goto L_0x005f
        L_0x005e:
            r7 = r4
        L_0x005f:
            int r2 = r2 + 1
            goto L_0x0048
        L_0x0062:
            int r2 = r11.q(r6)
            r5 = r2
        L_0x0067:
            if (r1 >= r0) goto L_0x0082
            java.lang.Object[] r2 = r11.f20067b
            r6 = r2[r1]
            r2[r1] = r3
            boolean r2 = r12.contains(r6)
            if (r2 == 0) goto L_0x007e
            java.lang.Object[] r2 = r11.f20067b
            r2[r5] = r6
            int r5 = r11.n(r5)
            goto L_0x007f
        L_0x007e:
            r7 = r4
        L_0x007f:
            int r1 = r1 + 1
            goto L_0x0067
        L_0x0082:
            r1 = r7
        L_0x0083:
            if (r1 == 0) goto L_0x0091
            r11.r()
            int r12 = r11.f20066a
            int r5 = r5 - r12
            int r12 = r11.o(r5)
            r11.f20068c = r12
        L_0x0091:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: X2.C2241h.retainAll(java.util.Collection):boolean");
    }

    public final Object s() {
        if (isEmpty()) {
            return null;
        }
        return removeFirst();
    }

    public Object set(int i5, Object obj) {
        C2236c.Companion.b(i5, size());
        int q5 = q(this.f20066a + i5);
        Object[] objArr = this.f20067b;
        Object obj2 = objArr[q5];
        objArr[q5] = obj;
        return obj2;
    }

    public final Object t() {
        if (isEmpty()) {
            return null;
        }
        return removeLast();
    }

    public Object[] toArray(Object[] objArr) {
        t.e(objArr, "array");
        if (objArr.length < size()) {
            objArr = C2243j.a(objArr, size());
        }
        Object[] objArr2 = objArr;
        int q5 = q(this.f20066a + size());
        int i5 = this.f20066a;
        if (i5 < q5) {
            C2245l.q(this.f20067b, objArr2, 0, i5, q5, 2, (Object) null);
        } else if (!isEmpty()) {
            Object[] objArr3 = this.f20067b;
            C2245l.l(objArr3, objArr2, 0, this.f20066a, objArr3.length);
            Object[] objArr4 = this.f20067b;
            C2245l.l(objArr4, objArr2, objArr4.length - this.f20066a, 0, q5);
        }
        return r.e(size(), objArr2);
    }

    public void add(int i5, Object obj) {
        C2236c.Companion.c(i5, size());
        if (i5 == size()) {
            addLast(obj);
        } else if (i5 == 0) {
            addFirst(obj);
        } else {
            r();
            k(size() + 1);
            int q5 = q(this.f20066a + i5);
            if (i5 < ((size() + 1) >> 1)) {
                int j5 = j(q5);
                int j6 = j(this.f20066a);
                int i6 = this.f20066a;
                if (j5 >= i6) {
                    Object[] objArr = this.f20067b;
                    objArr[j6] = objArr[i6];
                    C2245l.l(objArr, objArr, i6, i6 + 1, j5 + 1);
                } else {
                    Object[] objArr2 = this.f20067b;
                    C2245l.l(objArr2, objArr2, i6 - 1, i6, objArr2.length);
                    Object[] objArr3 = this.f20067b;
                    objArr3[objArr3.length - 1] = objArr3[0];
                    C2245l.l(objArr3, objArr3, 0, 1, j5 + 1);
                }
                this.f20067b[j5] = obj;
                this.f20066a = j6;
            } else {
                int q6 = q(this.f20066a + size());
                if (q5 < q6) {
                    Object[] objArr4 = this.f20067b;
                    C2245l.l(objArr4, objArr4, q5 + 1, q5, q6);
                } else {
                    Object[] objArr5 = this.f20067b;
                    C2245l.l(objArr5, objArr5, 1, 0, q6);
                    Object[] objArr6 = this.f20067b;
                    objArr6[0] = objArr6[objArr6.length - 1];
                    C2245l.l(objArr6, objArr6, q5 + 1, q5, objArr6.length - 1);
                }
                this.f20067b[q5] = obj;
            }
            this.f20068c = size() + 1;
        }
    }

    public boolean addAll(int i5, Collection collection) {
        t.e(collection, "elements");
        C2236c.Companion.c(i5, size());
        if (collection.isEmpty()) {
            return false;
        }
        if (i5 == size()) {
            return addAll(collection);
        }
        r();
        k(size() + collection.size());
        int q5 = q(this.f20066a + size());
        int q6 = q(this.f20066a + i5);
        int size = collection.size();
        if (i5 < ((size() + 1) >> 1)) {
            int i6 = this.f20066a;
            int i7 = i6 - size;
            if (q6 < i6) {
                Object[] objArr = this.f20067b;
                C2245l.l(objArr, objArr, i7, i6, objArr.length);
                if (size >= q6) {
                    Object[] objArr2 = this.f20067b;
                    C2245l.l(objArr2, objArr2, objArr2.length - size, 0, q6);
                } else {
                    Object[] objArr3 = this.f20067b;
                    C2245l.l(objArr3, objArr3, objArr3.length - size, 0, size);
                    Object[] objArr4 = this.f20067b;
                    C2245l.l(objArr4, objArr4, 0, size, q6);
                }
            } else if (i7 >= 0) {
                Object[] objArr5 = this.f20067b;
                C2245l.l(objArr5, objArr5, i7, i6, q6);
            } else {
                Object[] objArr6 = this.f20067b;
                i7 += objArr6.length;
                int i8 = q6 - i6;
                int length = objArr6.length - i7;
                if (length >= i8) {
                    C2245l.l(objArr6, objArr6, i7, i6, q6);
                } else {
                    C2245l.l(objArr6, objArr6, i7, i6, i6 + length);
                    Object[] objArr7 = this.f20067b;
                    C2245l.l(objArr7, objArr7, 0, this.f20066a + length, q6);
                }
            }
            this.f20066a = i7;
            g(o(q6 - size), collection);
        } else {
            int i9 = q6 + size;
            if (q6 < q5) {
                int i10 = size + q5;
                Object[] objArr8 = this.f20067b;
                if (i10 <= objArr8.length) {
                    C2245l.l(objArr8, objArr8, i9, q6, q5);
                } else if (i9 >= objArr8.length) {
                    C2245l.l(objArr8, objArr8, i9 - objArr8.length, q6, q5);
                } else {
                    int length2 = q5 - (i10 - objArr8.length);
                    C2245l.l(objArr8, objArr8, 0, length2, q5);
                    Object[] objArr9 = this.f20067b;
                    C2245l.l(objArr9, objArr9, i9, q6, length2);
                }
            } else {
                Object[] objArr10 = this.f20067b;
                C2245l.l(objArr10, objArr10, size, 0, q5);
                Object[] objArr11 = this.f20067b;
                if (i9 >= objArr11.length) {
                    C2245l.l(objArr11, objArr11, i9 - objArr11.length, q6, objArr11.length);
                } else {
                    C2245l.l(objArr11, objArr11, 0, objArr11.length - size, objArr11.length);
                    Object[] objArr12 = this.f20067b;
                    C2245l.l(objArr12, objArr12, i9, q6, objArr12.length - size);
                }
            }
            g(q6, collection);
        }
        return true;
    }

    public Object[] toArray() {
        return toArray(new Object[size()]);
    }
}
