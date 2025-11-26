package androidx.window.embedding;

import X2.C2250q;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.util.Pair;
import android.view.WindowMetrics;
import androidx.window.core.ExperimentalWindowApi;
import androidx.window.extensions.embedding.ActivityRule;
import androidx.window.extensions.embedding.ActivityStack;
import androidx.window.extensions.embedding.EmbeddingRule;
import androidx.window.extensions.embedding.SplitInfo;
import androidx.window.extensions.embedding.SplitPairRule;
import androidx.window.extensions.embedding.SplitPlaceholderRule;
import b.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Predicate;
import kotlin.jvm.internal.t;

@ExperimentalWindowApi
public final class EmbeddingAdapter {
    private final <F, S> F component1(Pair<F, S> pair) {
        t.e(pair, "<this>");
        return pair.first;
    }

    private final <F, S> S component2(Pair<F, S> pair) {
        t.e(pair, "<this>");
        return pair.second;
    }

    /* access modifiers changed from: private */
    /* renamed from: translateActivityIntentPredicates$lambda-3  reason: not valid java name */
    public static final boolean m198translateActivityIntentPredicates$lambda3(EmbeddingAdapter embeddingAdapter, Set set, Pair pair) {
        t.e(embeddingAdapter, "this$0");
        t.e(set, "$splitPairFilters");
        t.d(pair, "(first, second)");
        Activity activity = (Activity) embeddingAdapter.component1(pair);
        Intent intent = (Intent) embeddingAdapter.component2(pair);
        if (w.a(set) && set.isEmpty()) {
            return false;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (((SplitPairFilter) it.next()).matchesActivityIntentPair(activity, intent)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: translateActivityPairPredicates$lambda-1  reason: not valid java name */
    public static final boolean m199translateActivityPairPredicates$lambda1(EmbeddingAdapter embeddingAdapter, Set set, Pair pair) {
        t.e(embeddingAdapter, "this$0");
        t.e(set, "$splitPairFilters");
        t.d(pair, "(first, second)");
        Activity activity = (Activity) embeddingAdapter.component1(pair);
        Activity activity2 = (Activity) embeddingAdapter.component2(pair);
        if (w.a(set) && set.isEmpty()) {
            return false;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            if (((SplitPairFilter) it.next()).matchesActivityPair(activity, activity2)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: translateActivityPredicates$lambda-6  reason: not valid java name */
    public static final boolean m200translateActivityPredicates$lambda6(Set set, Activity activity) {
        t.e(set, "$activityFilters");
        if (w.a(set) && set.isEmpty()) {
            return false;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            t.d(activity, "activity");
            if (((ActivityFilter) it.next()).matchesActivity(activity)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: translateIntentPredicates$lambda-8  reason: not valid java name */
    public static final boolean m201translateIntentPredicates$lambda8(Set set, Intent intent) {
        t.e(set, "$activityFilters");
        if (w.a(set) && set.isEmpty()) {
            return false;
        }
        Iterator it = set.iterator();
        while (it.hasNext()) {
            t.d(intent, "intent");
            if (((ActivityFilter) it.next()).matchesIntent(intent)) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: translateParentMetricsPredicate$lambda-4  reason: not valid java name */
    public static final boolean m202translateParentMetricsPredicate$lambda4(SplitRule splitRule, WindowMetrics windowMetrics) {
        t.e(splitRule, "$splitRule");
        t.d(windowMetrics, "windowMetrics");
        return splitRule.checkParentMetrics(windowMetrics);
    }

    public final List<SplitInfo> translate(List<? extends SplitInfo> list) {
        t.e(list, "splitInfoList");
        Iterable<SplitInfo> iterable = list;
        ArrayList arrayList = new ArrayList(C2250q.p(iterable, 10));
        for (SplitInfo translate : iterable) {
            arrayList.add(translate(translate));
        }
        return arrayList;
    }

    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    public final Predicate<Pair<Activity, Intent>> translateActivityIntentPredicates(Set<SplitPairFilter> set) {
        t.e(set, "splitPairFilters");
        return new d(this, set);
    }

    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    public final Predicate<Pair<Activity, Activity>> translateActivityPairPredicates(Set<SplitPairFilter> set) {
        t.e(set, "splitPairFilters");
        return new c(this, set);
    }

    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    public final Predicate<Activity> translateActivityPredicates(Set<ActivityFilter> set) {
        t.e(set, "activityFilters");
        return new e(set);
    }

    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    public final Predicate<Intent> translateIntentPredicates(Set<ActivityFilter> set) {
        t.e(set, "activityFilters");
        return new a(set);
    }

    @SuppressLint({"ClassVerificationFailure", "NewApi"})
    public final Predicate<WindowMetrics> translateParentMetricsPredicate(SplitRule splitRule) {
        t.e(splitRule, "splitRule");
        return new b(splitRule);
    }

    private final SplitInfo translate(SplitInfo splitInfo) {
        boolean z4;
        ActivityStack primaryActivityStack = splitInfo.getPrimaryActivityStack();
        t.d(primaryActivityStack, "splitInfo.primaryActivityStack");
        boolean z5 = false;
        try {
            z4 = primaryActivityStack.isEmpty();
        } catch (NoSuchMethodError unused) {
            z4 = false;
        }
        List activities = primaryActivityStack.getActivities();
        t.d(activities, "primaryActivityStack.activities");
        ActivityStack activityStack = new ActivityStack(activities, z4);
        ActivityStack secondaryActivityStack = splitInfo.getSecondaryActivityStack();
        t.d(secondaryActivityStack, "splitInfo.secondaryActivityStack");
        try {
            z5 = secondaryActivityStack.isEmpty();
        } catch (NoSuchMethodError unused2) {
        }
        List activities2 = secondaryActivityStack.getActivities();
        t.d(activities2, "secondaryActivityStack.activities");
        return new SplitInfo(activityStack, new ActivityStack(activities2, z5), splitInfo.getSplitRatio());
    }

    public final Set<EmbeddingRule> translate(Set<? extends EmbeddingRule> set) {
        SplitPairRule splitPairRule;
        t.e(set, "rules");
        ArrayList arrayList = new ArrayList(C2250q.p(set, 10));
        for (EmbeddingRule embeddingRule : set) {
            if (embeddingRule instanceof SplitPairRule) {
                SplitPairRule splitPairRule2 = (SplitPairRule) embeddingRule;
                splitPairRule = new SplitPairRule.Builder(translateActivityPairPredicates(splitPairRule2.getFilters()), translateActivityIntentPredicates(splitPairRule2.getFilters()), translateParentMetricsPredicate((SplitRule) embeddingRule)).setSplitRatio(splitPairRule2.getSplitRatio()).setLayoutDirection(splitPairRule2.getLayoutDirection()).setShouldFinishPrimaryWithSecondary(splitPairRule2.getFinishPrimaryWithSecondary()).setShouldFinishSecondaryWithPrimary(splitPairRule2.getFinishSecondaryWithPrimary()).setShouldClearTop(splitPairRule2.getClearTop()).build();
                t.d(splitPairRule, "SplitPairRuleBuilder(\n  …                 .build()");
            } else if (embeddingRule instanceof SplitPlaceholderRule) {
                SplitPlaceholderRule splitPlaceholderRule = (SplitPlaceholderRule) embeddingRule;
                splitPairRule = new SplitPlaceholderRule.Builder(splitPlaceholderRule.getPlaceholderIntent(), translateActivityPredicates(splitPlaceholderRule.getFilters()), translateIntentPredicates(splitPlaceholderRule.getFilters()), translateParentMetricsPredicate((SplitRule) embeddingRule)).setSplitRatio(splitPlaceholderRule.getSplitRatio()).setLayoutDirection(splitPlaceholderRule.getLayoutDirection()).build();
                t.d(splitPairRule, "SplitPlaceholderRuleBuil…                 .build()");
            } else if (embeddingRule instanceof ActivityRule) {
                ActivityRule activityRule = (ActivityRule) embeddingRule;
                splitPairRule = new ActivityRule.Builder(translateActivityPredicates(activityRule.getFilters()), translateIntentPredicates(activityRule.getFilters())).setShouldAlwaysExpand(activityRule.getAlwaysExpand()).build();
                t.d(splitPairRule, "ActivityRuleBuilder(\n   …                 .build()");
            } else {
                throw new IllegalArgumentException("Unsupported rule type");
            }
            arrayList.add((EmbeddingRule) splitPairRule);
        }
        return C2250q.r0(arrayList);
    }
}
