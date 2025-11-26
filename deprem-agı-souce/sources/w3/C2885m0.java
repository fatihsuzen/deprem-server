package w3;

import B3.D;

/* renamed from: w3.m0  reason: case insensitive filesystem */
public abstract class C2885m0 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final D f26301a = new D("REMOVED_TASK");
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final D f26302b = new D("CLOSED_EMPTY");

    public static final long c(long j5) {
        if (j5 <= 0) {
            return 0;
        }
        if (j5 >= 9223372036854L) {
            return Long.MAX_VALUE;
        }
        return j5 * 1000000;
    }
}
