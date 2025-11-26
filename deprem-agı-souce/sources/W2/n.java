package W2;

import k3.C2616a;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

abstract class n {

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f19958a;

        /* JADX WARNING: Can't wrap try/catch for region: R(9:0|1|2|3|4|5|6|7|9) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        static {
            /*
                W2.p[] r0 = W2.p.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                W2.p r1 = W2.p.SYNCHRONIZED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                W2.p r1 = W2.p.PUBLICATION     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                W2.p r1 = W2.p.NONE     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f19958a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: W2.n.a.<clinit>():void");
        }
    }

    public static C2223l a(p pVar, C2616a aVar) {
        t.e(pVar, "mode");
        t.e(aVar, "initializer");
        int i5 = a.f19958a[pVar.ordinal()];
        if (i5 == 1) {
            return new w(aVar, (Object) null, 2, (C2633k) null);
        }
        if (i5 == 2) {
            return new v(aVar);
        }
        if (i5 == 3) {
            return new K(aVar);
        }
        throw new q();
    }

    public static C2223l b(C2616a aVar) {
        t.e(aVar, "initializer");
        return new w(aVar, (Object) null, 2, (C2633k) null);
    }
}
