package m0;

import j$.util.Objects;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Map;
import l0.h;
import m0.j;

final class u extends j {

    /* renamed from: h  reason: collision with root package name */
    static final j f15583h = new u((Object) null, new Object[0], 0);

    /* renamed from: e  reason: collision with root package name */
    private final transient Object f15584e;

    /* renamed from: f  reason: collision with root package name */
    final transient Object[] f15585f;

    /* renamed from: g  reason: collision with root package name */
    private final transient int f15586g;

    static class a extends k {

        /* renamed from: c  reason: collision with root package name */
        private final transient j f15587c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final transient Object[] f15588d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public final transient int f15589e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public final transient int f15590f;

        /* renamed from: m0.u$a$a  reason: collision with other inner class name */
        class C0156a extends i {
            C0156a() {
            }

            public int size() {
                return a.this.f15590f;
            }

            /* renamed from: w */
            public Map.Entry get(int i5) {
                h.f(i5, a.this.f15590f);
                int i6 = i5 * 2;
                Object obj = a.this.f15588d[a.this.f15589e + i6];
                Objects.requireNonNull(obj);
                Object obj2 = a.this.f15588d[i6 + (a.this.f15589e ^ 1)];
                Objects.requireNonNull(obj2);
                return new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }
        }

        a(j jVar, Object[] objArr, int i5, int i6) {
            this.f15587c = jVar;
            this.f15588d = objArr;
            this.f15589e = i5;
            this.f15590f = i6;
        }

        /* access modifiers changed from: package-private */
        public int c(Object[] objArr, int i5) {
            return i().c(objArr, i5);
        }

        public boolean contains(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                Object key = entry.getKey();
                Object value = entry.getValue();
                if (value == null || !value.equals(this.f15587c.get(key))) {
                    return false;
                }
                return true;
            }
            return false;
        }

        /* access modifiers changed from: package-private */
        public i l() {
            return new C0156a();
        }

        /* renamed from: o */
        public z iterator() {
            return i().iterator();
        }

        public int size() {
            return this.f15590f;
        }
    }

    static final class b extends k {

        /* renamed from: c  reason: collision with root package name */
        private final transient j f15592c;

        /* renamed from: d  reason: collision with root package name */
        private final transient i f15593d;

        b(j jVar, i iVar) {
            this.f15592c = jVar;
            this.f15593d = iVar;
        }

        /* access modifiers changed from: package-private */
        public int c(Object[] objArr, int i5) {
            return i().c(objArr, i5);
        }

        public boolean contains(Object obj) {
            if (this.f15592c.get(obj) != null) {
                return true;
            }
            return false;
        }

        public i i() {
            return this.f15593d;
        }

        /* renamed from: o */
        public z iterator() {
            return i().iterator();
        }

        public int size() {
            return this.f15592c.size();
        }
    }

    static final class c extends i {

        /* renamed from: c  reason: collision with root package name */
        private final transient Object[] f15594c;

        /* renamed from: d  reason: collision with root package name */
        private final transient int f15595d;

        /* renamed from: e  reason: collision with root package name */
        private final transient int f15596e;

        c(Object[] objArr, int i5, int i6) {
            this.f15594c = objArr;
            this.f15595d = i5;
            this.f15596e = i6;
        }

        public Object get(int i5) {
            h.f(i5, this.f15596e);
            Object obj = this.f15594c[(i5 * 2) + this.f15595d];
            Objects.requireNonNull(obj);
            return obj;
        }

        public int size() {
            return this.f15596e;
        }
    }

    private u(Object obj, Object[] objArr, int i5) {
        this.f15584e = obj;
        this.f15585f = objArr;
        this.f15586g = i5;
    }

    static u n(int i5, Object[] objArr) {
        return o(i5, objArr, (j.a) null);
    }

    static u o(int i5, Object[] objArr, j.a aVar) {
        if (i5 == 0) {
            return (u) f15583h;
        }
        if (i5 == 1) {
            Object obj = objArr[0];
            Objects.requireNonNull(obj);
            Object obj2 = objArr[1];
            Objects.requireNonNull(obj2);
            C1715d.a(obj, obj2);
            return new u((Object) null, objArr, 1);
        }
        h.j(i5, objArr.length >> 1);
        Object p5 = p(objArr, i5, k.j(i5), 0);
        if (p5 instanceof Object[]) {
            Object[] objArr2 = (Object[]) p5;
            j.a.C0154a aVar2 = (j.a.C0154a) objArr2[2];
            if (aVar != null) {
                aVar.f15570e = aVar2;
                Object obj3 = objArr2[0];
                int intValue = ((Integer) objArr2[1]).intValue();
                objArr = Arrays.copyOf(objArr, intValue * 2);
                p5 = obj3;
                i5 = intValue;
            } else {
                throw aVar2.a();
            }
        }
        return new u(p5, objArr, i5);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Object[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.Object p(java.lang.Object[] r17, int r18, int r19, int r20) {
        /*
            r0 = r18
            r1 = r19
            r2 = 0
            r3 = 1
            if (r0 != r3) goto L_0x0018
            r0 = r17[r20]
            j$.util.Objects.requireNonNull(r0)
            r1 = r20 ^ 1
            r1 = r17[r1]
            j$.util.Objects.requireNonNull(r1)
            m0.C1715d.a(r0, r1)
            return r2
        L_0x0018:
            int r4 = r1 + -1
            r5 = 128(0x80, float:1.794E-43)
            r6 = 3
            r7 = -1
            r8 = 2
            r9 = 0
            if (r1 > r5) goto L_0x008b
            byte[] r1 = new byte[r1]
            java.util.Arrays.fill(r1, r7)
            r5 = r9
            r7 = r5
        L_0x0029:
            if (r5 >= r0) goto L_0x007b
            int r10 = r5 * 2
            int r10 = r10 + r20
            int r11 = r7 * 2
            int r11 = r11 + r20
            r12 = r17[r10]
            j$.util.Objects.requireNonNull(r12)
            r10 = r10 ^ r3
            r10 = r17[r10]
            j$.util.Objects.requireNonNull(r10)
            m0.C1715d.a(r12, r10)
            int r13 = r12.hashCode()
            int r13 = m0.g.a(r13)
        L_0x0049:
            r13 = r13 & r4
            byte r14 = r1[r13]
            r15 = 255(0xff, float:3.57E-43)
            r14 = r14 & r15
            if (r14 != r15) goto L_0x005f
            byte r14 = (byte) r11
            r1[r13] = r14
            if (r7 >= r5) goto L_0x005c
            r17[r11] = r12
            r11 = r11 ^ 1
            r17[r11] = r10
        L_0x005c:
            int r7 = r7 + 1
            goto L_0x0075
        L_0x005f:
            r15 = r17[r14]
            boolean r15 = r12.equals(r15)
            if (r15 == 0) goto L_0x0078
            m0.j$a$a r2 = new m0.j$a$a
            r11 = r14 ^ 1
            r13 = r17[r11]
            j$.util.Objects.requireNonNull(r13)
            r2.<init>(r12, r10, r13)
            r17[r11] = r10
        L_0x0075:
            int r5 = r5 + 1
            goto L_0x0029
        L_0x0078:
            int r13 = r13 + 1
            goto L_0x0049
        L_0x007b:
            if (r7 != r0) goto L_0x007e
            return r1
        L_0x007e:
            java.lang.Object[] r0 = new java.lang.Object[r6]
            r0[r9] = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r7)
            r0[r3] = r1
            r0[r8] = r2
            return r0
        L_0x008b:
            r5 = 32768(0x8000, float:4.5918E-41)
            if (r1 > r5) goto L_0x00fa
            short[] r1 = new short[r1]
            java.util.Arrays.fill(r1, r7)
            r5 = r9
            r7 = r5
        L_0x0097:
            if (r5 >= r0) goto L_0x00ea
            int r10 = r5 * 2
            int r10 = r10 + r20
            int r11 = r7 * 2
            int r11 = r11 + r20
            r12 = r17[r10]
            j$.util.Objects.requireNonNull(r12)
            r10 = r10 ^ r3
            r10 = r17[r10]
            j$.util.Objects.requireNonNull(r10)
            m0.C1715d.a(r12, r10)
            int r13 = r12.hashCode()
            int r13 = m0.g.a(r13)
        L_0x00b7:
            r13 = r13 & r4
            short r14 = r1[r13]
            r15 = 65535(0xffff, float:9.1834E-41)
            r14 = r14 & r15
            if (r14 != r15) goto L_0x00ce
            short r14 = (short) r11
            r1[r13] = r14
            if (r7 >= r5) goto L_0x00cb
            r17[r11] = r12
            r11 = r11 ^ 1
            r17[r11] = r10
        L_0x00cb:
            int r7 = r7 + 1
            goto L_0x00e4
        L_0x00ce:
            r15 = r17[r14]
            boolean r15 = r12.equals(r15)
            if (r15 == 0) goto L_0x00e7
            m0.j$a$a r2 = new m0.j$a$a
            r11 = r14 ^ 1
            r13 = r17[r11]
            j$.util.Objects.requireNonNull(r13)
            r2.<init>(r12, r10, r13)
            r17[r11] = r10
        L_0x00e4:
            int r5 = r5 + 1
            goto L_0x0097
        L_0x00e7:
            int r13 = r13 + 1
            goto L_0x00b7
        L_0x00ea:
            if (r7 != r0) goto L_0x00ed
            return r1
        L_0x00ed:
            java.lang.Object[] r0 = new java.lang.Object[r6]
            r0[r9] = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r7)
            r0[r3] = r1
            r0[r8] = r2
            return r0
        L_0x00fa:
            int[] r1 = new int[r1]
            java.util.Arrays.fill(r1, r7)
            r5 = r9
            r10 = r5
        L_0x0101:
            if (r5 >= r0) goto L_0x0157
            int r11 = r5 * 2
            int r11 = r11 + r20
            int r12 = r10 * 2
            int r12 = r12 + r20
            r13 = r17[r11]
            j$.util.Objects.requireNonNull(r13)
            r11 = r11 ^ r3
            r11 = r17[r11]
            j$.util.Objects.requireNonNull(r11)
            m0.C1715d.a(r13, r11)
            int r14 = r13.hashCode()
            int r14 = m0.g.a(r14)
        L_0x0121:
            r14 = r14 & r4
            r15 = r1[r14]
            if (r15 != r7) goto L_0x0135
            r1[r14] = r12
            if (r10 >= r5) goto L_0x0130
            r17[r12] = r13
            r12 = r12 ^ 1
            r17[r12] = r11
        L_0x0130:
            int r10 = r10 + 1
            r16 = r3
            goto L_0x014d
        L_0x0135:
            r16 = r3
            r3 = r17[r15]
            boolean r3 = r13.equals(r3)
            if (r3 == 0) goto L_0x0152
            m0.j$a$a r2 = new m0.j$a$a
            r3 = r15 ^ 1
            r12 = r17[r3]
            j$.util.Objects.requireNonNull(r12)
            r2.<init>(r13, r11, r12)
            r17[r3] = r11
        L_0x014d:
            int r5 = r5 + 1
            r3 = r16
            goto L_0x0101
        L_0x0152:
            int r14 = r14 + 1
            r3 = r16
            goto L_0x0121
        L_0x0157:
            r16 = r3
            if (r10 != r0) goto L_0x015c
            return r1
        L_0x015c:
            java.lang.Object[] r0 = new java.lang.Object[r6]
            r0[r9] = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r10)
            r0[r16] = r1
            r0[r8] = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: m0.u.p(java.lang.Object[], int, int, int):java.lang.Object");
    }

    static Object q(Object obj, Object[] objArr, int i5, int i6, Object obj2) {
        if (obj2 == null) {
            return null;
        }
        if (i5 == 1) {
            Object obj3 = objArr[i6];
            Objects.requireNonNull(obj3);
            if (!obj3.equals(obj2)) {
                return null;
            }
            Object obj4 = objArr[i6 ^ 1];
            Objects.requireNonNull(obj4);
            return obj4;
        } else if (obj == null) {
            return null;
        } else {
            if (obj instanceof byte[]) {
                byte[] bArr = (byte[]) obj;
                int length = bArr.length - 1;
                int a5 = g.a(obj2.hashCode());
                while (true) {
                    int i7 = a5 & length;
                    byte b5 = bArr[i7] & 255;
                    if (b5 == 255) {
                        return null;
                    }
                    if (obj2.equals(objArr[b5])) {
                        return objArr[b5 ^ 1];
                    }
                    a5 = i7 + 1;
                }
            } else if (obj instanceof short[]) {
                short[] sArr = (short[]) obj;
                int length2 = sArr.length - 1;
                int a6 = g.a(obj2.hashCode());
                while (true) {
                    int i8 = a6 & length2;
                    short s5 = sArr[i8] & 65535;
                    if (s5 == 65535) {
                        return null;
                    }
                    if (obj2.equals(objArr[s5])) {
                        return objArr[s5 ^ 1];
                    }
                    a6 = i8 + 1;
                }
            } else {
                int[] iArr = (int[]) obj;
                int length3 = iArr.length - 1;
                int a7 = g.a(obj2.hashCode());
                while (true) {
                    int i9 = a7 & length3;
                    int i10 = iArr[i9];
                    if (i10 == -1) {
                        return null;
                    }
                    if (obj2.equals(objArr[i10])) {
                        return objArr[i10 ^ 1];
                    }
                    a7 = i9 + 1;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public k c() {
        return new a(this, this.f15585f, 0, this.f15586g);
    }

    /* access modifiers changed from: package-private */
    public k e() {
        return new b(this, new c(this.f15585f, 0, this.f15586g));
    }

    /* access modifiers changed from: package-private */
    public h f() {
        return new c(this.f15585f, 1, this.f15586g);
    }

    public Object get(Object obj) {
        Object q5 = q(this.f15584e, this.f15585f, this.f15586g, 0, obj);
        if (q5 == null) {
            return null;
        }
        return q5;
    }

    public int size() {
        return this.f15586g;
    }
}
