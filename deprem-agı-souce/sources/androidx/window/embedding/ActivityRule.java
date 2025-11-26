package androidx.window.embedding;

import X2.C2250q;
import androidx.privacysandbox.ads.adservices.adid.a;
import androidx.window.core.ExperimentalWindowApi;
import java.util.LinkedHashSet;
import java.util.Set;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

@ExperimentalWindowApi
public final class ActivityRule extends EmbeddingRule {
    private final boolean alwaysExpand;
    private final Set<ActivityFilter> filters;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ActivityRule(Set set, boolean z4, int i5, C2633k kVar) {
        this(set, (i5 & 2) != 0 ? false : z4);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityRule)) {
            return false;
        }
        ActivityRule activityRule = (ActivityRule) obj;
        if (t.a(this.filters, activityRule.filters) && this.alwaysExpand == activityRule.alwaysExpand) {
            return true;
        }
        return false;
    }

    public final boolean getAlwaysExpand() {
        return this.alwaysExpand;
    }

    public final Set<ActivityFilter> getFilters() {
        return this.filters;
    }

    public int hashCode() {
        return (this.filters.hashCode() * 31) + a.a(this.alwaysExpand);
    }

    public final ActivityRule plus$window_release(ActivityFilter activityFilter) {
        t.e(activityFilter, "filter");
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        linkedHashSet.addAll(this.filters);
        linkedHashSet.add(activityFilter);
        return new ActivityRule(C2250q.r0(linkedHashSet), this.alwaysExpand);
    }

    public ActivityRule(Set<ActivityFilter> set, boolean z4) {
        t.e(set, "filters");
        this.alwaysExpand = z4;
        this.filters = C2250q.r0(set);
    }
}
