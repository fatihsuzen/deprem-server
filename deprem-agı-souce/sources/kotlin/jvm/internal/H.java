package kotlin.jvm.internal;

import r3.C2732b;
import r3.C2739i;

public abstract class H extends C2628f implements C2739i {
    private final boolean syntheticJavaProperty;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public H(java.lang.Object r10, java.lang.Class r11, java.lang.String r12, java.lang.String r13, int r14) {
        /*
            r9 = this;
            r0 = r14 & 1
            r1 = 0
            r2 = 1
            if (r0 != r2) goto L_0x000d
            r8 = r2
        L_0x0007:
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r13
            goto L_0x000f
        L_0x000d:
            r8 = r1
            goto L_0x0007
        L_0x000f:
            r3.<init>(r4, r5, r6, r7, r8)
            r10 = 2
            r11 = r14 & 2
            if (r11 != r10) goto L_0x0018
            r1 = r2
        L_0x0018:
            r3.syntheticJavaProperty = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.jvm.internal.H.<init>(java.lang.Object, java.lang.Class, java.lang.String, java.lang.String, int):void");
    }

    public C2732b compute() {
        if (this.syntheticJavaProperty) {
            return this;
        }
        return super.compute();
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof H) {
            H h5 = (H) obj;
            if (!getOwner().equals(h5.getOwner()) || !getName().equals(h5.getName()) || !getSignature().equals(h5.getSignature()) || !t.a(getBoundReceiver(), h5.getBoundReceiver())) {
                return false;
            }
            return true;
        } else if (obj instanceof C2739i) {
            return obj.equals(compute());
        } else {
            return false;
        }
    }

    public int hashCode() {
        return (((getOwner().hashCode() * 31) + getName().hashCode()) * 31) + getSignature().hashCode();
    }

    public boolean isConst() {
        return getReflected().isConst();
    }

    public boolean isLateinit() {
        return getReflected().isLateinit();
    }

    public String toString() {
        C2732b compute = compute();
        if (compute != this) {
            return compute.toString();
        }
        return "property " + getName() + " (Kotlin reflection is not available)";
    }

    /* access modifiers changed from: protected */
    public C2739i getReflected() {
        if (!this.syntheticJavaProperty) {
            return (C2739i) super.getReflected();
        }
        throw new UnsupportedOperationException("Kotlin reflection is not yet supported for synthetic Java properties. Please follow/upvote https://youtrack.jetbrains.com/issue/KT-55980");
    }
}
