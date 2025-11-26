package m0;

import java.util.NoSuchElementException;

public abstract class l {

    class a extends z {

        /* renamed from: a  reason: collision with root package name */
        boolean f15575a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Object f15576b;

        a(Object obj) {
            this.f15576b = obj;
        }

        public boolean hasNext() {
            return !this.f15575a;
        }

        public Object next() {
            if (!this.f15575a) {
                this.f15575a = true;
                return this.f15576b;
            }
            throw new NoSuchElementException();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:2:0x0006  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean a(java.util.Iterator r3, java.util.Iterator r4) {
        /*
        L_0x0000:
            boolean r0 = r3.hasNext()
            if (r0 == 0) goto L_0x001d
            boolean r0 = r4.hasNext()
            r1 = 0
            if (r0 != 0) goto L_0x000e
            return r1
        L_0x000e:
            java.lang.Object r0 = r3.next()
            java.lang.Object r2 = r4.next()
            boolean r0 = l0.f.a(r0, r2)
            if (r0 != 0) goto L_0x0000
            return r1
        L_0x001d:
            boolean r3 = r4.hasNext()
            r3 = r3 ^ 1
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: m0.l.a(java.util.Iterator, java.util.Iterator):boolean");
    }

    public static z b(Object obj) {
        return new a(obj);
    }
}
