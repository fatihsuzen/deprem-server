package F3;

import B3.D;

public abstract class g {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final D f18119a = new D("NO_OWNER");
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final D f18120b = new D("ALREADY_LOCKED_BY_OWNER");

    public static final a a(boolean z4) {
        return new f(z4);
    }

    public static /* synthetic */ a b(boolean z4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z4 = false;
        }
        return a(z4);
    }
}
