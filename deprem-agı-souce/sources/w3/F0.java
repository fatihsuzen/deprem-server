package w3;

import B3.D;

public abstract class F0 {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final D f26230a = new D("COMPLETING_ALREADY");

    /* renamed from: b  reason: collision with root package name */
    public static final D f26231b = new D("COMPLETING_WAITING_CHILDREN");
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final D f26232c = new D("COMPLETING_RETRY");
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final D f26233d = new D("TOO_LATE_TO_CANCEL");
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final D f26234e = new D("SEALED");
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final C2875h0 f26235f = new C2875h0(false);
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final C2875h0 f26236g = new C2875h0(true);

    public static final Object g(Object obj) {
        if (obj instanceof C2900u0) {
            return new C2902v0((C2900u0) obj);
        }
        return obj;
    }

    public static final Object h(Object obj) {
        C2902v0 v0Var;
        C2900u0 u0Var;
        if (obj instanceof C2902v0) {
            v0Var = (C2902v0) obj;
        } else {
            v0Var = null;
        }
        if (v0Var == null || (u0Var = v0Var.f26316a) == null) {
            return obj;
        }
        return u0Var;
    }
}
