package w3;

import C3.b;
import W2.q;
import b3.C2308e;
import b3.C2310g;
import d3.C2345b;
import k3.p;

public enum O {
    DEFAULT,
    LAZY,
    ATOMIC,
    UNDISPATCHED;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f26251a = null;

        /* JADX WARNING: Can't wrap try/catch for region: R(11:0|1|2|3|4|5|6|7|8|9|11) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        static {
            /*
                w3.O[] r0 = w3.O.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                w3.O r1 = w3.O.DEFAULT     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                w3.O r1 = w3.O.ATOMIC     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                w3.O r1 = w3.O.UNDISPATCHED     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                w3.O r1 = w3.O.LAZY     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                f26251a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: w3.O.a.<clinit>():void");
        }
    }

    static {
        O[] a5;
        f26250f = C2345b.a(a5);
    }

    public final void b(p pVar, Object obj, C2308e eVar) {
        int i5 = a.f26251a[ordinal()];
        if (i5 == 1) {
            C3.a.c(pVar, obj, eVar);
        } else if (i5 == 2) {
            C2310g.a(pVar, obj, eVar);
        } else if (i5 == 3) {
            b.a(pVar, obj, eVar);
        } else if (i5 != 4) {
            throw new q();
        }
    }

    public final boolean c() {
        if (this == LAZY) {
            return true;
        }
        return false;
    }
}
