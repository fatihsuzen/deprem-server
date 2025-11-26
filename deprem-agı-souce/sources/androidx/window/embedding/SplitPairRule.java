package androidx.window.embedding;

import X2.C2250q;
import androidx.privacysandbox.ads.adservices.adid.a;
import androidx.window.core.ExperimentalWindowApi;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.t;

@ExperimentalWindowApi
public final class SplitPairRule extends SplitRule {
    private final boolean clearTop;
    private final Set<SplitPairFilter> filters;
    private final boolean finishPrimaryWithSecondary;
    private final boolean finishSecondaryWithPrimary;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SplitPairRule(java.util.Set r2, boolean r3, boolean r4, boolean r5, int r6, int r7, float r8, int r9, int r10, kotlin.jvm.internal.C2633k r11) {
        /*
            r1 = this;
            r11 = r10 & 2
            r0 = 0
            if (r11 == 0) goto L_0x0006
            r3 = r0
        L_0x0006:
            r11 = r10 & 4
            if (r11 == 0) goto L_0x000b
            r4 = 1
        L_0x000b:
            r11 = r10 & 8
            if (r11 == 0) goto L_0x0010
            r5 = r0
        L_0x0010:
            r11 = r10 & 16
            if (r11 == 0) goto L_0x0015
            r6 = r0
        L_0x0015:
            r11 = r10 & 32
            if (r11 == 0) goto L_0x001a
            r7 = r0
        L_0x001a:
            r11 = r10 & 64
            if (r11 == 0) goto L_0x0020
            r8 = 1056964608(0x3f000000, float:0.5)
        L_0x0020:
            r10 = r10 & 128(0x80, float:1.794E-43)
            if (r10 == 0) goto L_0x0025
            r9 = 3
        L_0x0025:
            r10 = r9
            r9 = r8
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.embedding.SplitPairRule.<init>(java.util.Set, boolean, boolean, boolean, int, int, float, int, int, kotlin.jvm.internal.k):void");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitPairRule) || !super.equals(obj)) {
            return false;
        }
        SplitPairRule splitPairRule = (SplitPairRule) obj;
        if (t.a(this.filters, splitPairRule.filters) && this.finishPrimaryWithSecondary == splitPairRule.finishPrimaryWithSecondary && this.finishSecondaryWithPrimary == splitPairRule.finishSecondaryWithPrimary && this.clearTop == splitPairRule.clearTop) {
            return true;
        }
        return false;
    }

    public final boolean getClearTop() {
        return this.clearTop;
    }

    public final Set<SplitPairFilter> getFilters() {
        return this.filters;
    }

    public final boolean getFinishPrimaryWithSecondary() {
        return this.finishPrimaryWithSecondary;
    }

    public final boolean getFinishSecondaryWithPrimary() {
        return this.finishSecondaryWithPrimary;
    }

    public int hashCode() {
        return (((((((super.hashCode() * 31) + this.filters.hashCode()) * 31) + a.a(this.finishPrimaryWithSecondary)) * 31) + a.a(this.finishSecondaryWithPrimary)) * 31) + a.a(this.clearTop);
    }

    public final SplitPairRule plus$window_release(SplitPairFilter splitPairFilter) {
        t.e(splitPairFilter, "filter");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(this.filters);
        linkedHashSet.add(splitPairFilter);
        return new SplitPairRule(C2250q.r0(linkedHashSet), this.finishPrimaryWithSecondary, this.finishSecondaryWithPrimary, this.clearTop, getMinWidth(), getMinSmallestWidth(), getSplitRatio(), getLayoutDirection());
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SplitPairRule(Set<SplitPairFilter> set, boolean z4, boolean z5, boolean z6, int i5, int i6, float f5, int i7) {
        super(i5, i6, f5, i7);
        t.e(set, "filters");
        this.finishPrimaryWithSecondary = z4;
        this.finishSecondaryWithPrimary = z5;
        this.clearTop = z6;
        this.filters = C2250q.r0(set);
    }
}
