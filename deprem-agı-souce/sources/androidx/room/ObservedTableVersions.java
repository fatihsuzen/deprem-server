package androidx.room;

import java.util.Set;
import kotlin.jvm.internal.t;
import z3.F;
import z3.w;

public final class ObservedTableVersions {
    private final w versions;

    public ObservedTableVersions(int i5) {
        this.versions = F.a(new int[i5]);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object collect(z3.C2973f r5, b3.C2308e r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.room.ObservedTableVersions$collect$1
            if (r0 == 0) goto L_0x0013
            r0 = r6
            androidx.room.ObservedTableVersions$collect$1 r0 = (androidx.room.ObservedTableVersions$collect$1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.label = r1
            goto L_0x0018
        L_0x0013:
            androidx.room.ObservedTableVersions$collect$1 r0 = new androidx.room.ObservedTableVersions$collect$1
            r0.<init>(r4, r6)
        L_0x0018:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L_0x0031
            if (r2 == r3) goto L_0x002d
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L_0x002d:
            W2.u.b(r6)
            goto L_0x003f
        L_0x0031:
            W2.u.b(r6)
            z3.w r6 = r4.versions
            r0.label = r3
            java.lang.Object r5 = r6.collect(r5, r0)
            if (r5 != r1) goto L_0x003f
            return r1
        L_0x003f:
            W2.h r5 = new W2.h
            r5.<init>()
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.room.ObservedTableVersions.collect(z3.f, b3.e):java.lang.Object");
    }

    public final void increment(Set<Integer> set) {
        Object value;
        int[] iArr;
        int i5;
        t.e(set, "tableIds");
        if (!set.isEmpty()) {
            w wVar = this.versions;
            do {
                value = wVar.getValue();
                int[] iArr2 = (int[]) value;
                int length = iArr2.length;
                iArr = new int[length];
                for (int i6 = 0; i6 < length; i6++) {
                    if (set.contains(Integer.valueOf(i6))) {
                        i5 = iArr2[i6] + 1;
                    } else {
                        i5 = iArr2[i6];
                    }
                    iArr[i6] = i5;
                }
            } while (!wVar.a(value, iArr));
        }
    }
}
