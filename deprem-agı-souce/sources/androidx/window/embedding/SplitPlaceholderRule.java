package androidx.window.embedding;

import X2.C2250q;
import android.content.Intent;
import androidx.window.core.ExperimentalWindowApi;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.t;

@ExperimentalWindowApi
public final class SplitPlaceholderRule extends SplitRule {
    private final Set<ActivityFilter> filters;
    private final Intent placeholderIntent;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SplitPlaceholderRule(java.util.Set r2, android.content.Intent r3, int r4, int r5, float r6, int r7, int r8, kotlin.jvm.internal.C2633k r9) {
        /*
            r1 = this;
            r9 = r8 & 4
            r0 = 0
            if (r9 == 0) goto L_0x0006
            r4 = r0
        L_0x0006:
            r9 = r8 & 8
            if (r9 == 0) goto L_0x000b
            r5 = r0
        L_0x000b:
            r9 = r8 & 16
            if (r9 == 0) goto L_0x0011
            r6 = 1056964608(0x3f000000, float:0.5)
        L_0x0011:
            r8 = r8 & 32
            if (r8 == 0) goto L_0x0016
            r7 = 3
        L_0x0016:
            r8 = r7
            r7 = r6
            r6 = r5
            r5 = r4
            r4 = r3
            r3 = r2
            r2 = r1
            r2.<init>(r3, r4, r5, r6, r7, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.embedding.SplitPlaceholderRule.<init>(java.util.Set, android.content.Intent, int, int, float, int, int, kotlin.jvm.internal.k):void");
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitPlaceholderRule) || !super.equals(obj) || !super.equals(obj)) {
            return false;
        }
        SplitPlaceholderRule splitPlaceholderRule = (SplitPlaceholderRule) obj;
        if (t.a(this.filters, splitPlaceholderRule.filters) && t.a(this.placeholderIntent, splitPlaceholderRule.placeholderIntent)) {
            return true;
        }
        return false;
    }

    public final Set<ActivityFilter> getFilters() {
        return this.filters;
    }

    public final Intent getPlaceholderIntent() {
        return this.placeholderIntent;
    }

    public int hashCode() {
        return (((super.hashCode() * 31) + this.filters.hashCode()) * 31) + this.placeholderIntent.hashCode();
    }

    public final SplitPlaceholderRule plus$window_release(ActivityFilter activityFilter) {
        t.e(activityFilter, "filter");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(this.filters);
        linkedHashSet.add(activityFilter);
        return new SplitPlaceholderRule(C2250q.r0(linkedHashSet), this.placeholderIntent, getMinWidth(), getMinSmallestWidth(), getSplitRatio(), getLayoutDirection());
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SplitPlaceholderRule(Set<ActivityFilter> set, Intent intent, int i5, int i6, float f5, int i7) {
        super(i5, i6, f5, i7);
        t.e(set, "filters");
        t.e(intent, "placeholderIntent");
        this.placeholderIntent = intent;
        this.filters = C2250q.r0(set);
    }
}
