package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.window.core.ExperimentalWindowApi;
import kotlin.jvm.internal.t;
import t3.s;

@ExperimentalWindowApi
public final class SplitPairFilter {
    private final ComponentName primaryActivityName;
    private final String secondaryActivityIntentAction;
    private final ComponentName secondaryActivityName;

    public SplitPairFilter(ComponentName componentName, ComponentName componentName2, String str) {
        String str2;
        boolean z4;
        Object obj;
        int i5;
        ComponentName componentName3 = componentName;
        ComponentName componentName4 = componentName2;
        t.e(componentName3, "primaryActivityName");
        t.e(componentName4, "secondaryActivityName");
        this.primaryActivityName = componentName3;
        this.secondaryActivityName = componentName4;
        this.secondaryActivityIntentAction = str;
        String packageName = componentName.getPackageName();
        t.d(packageName, "primaryActivityName.packageName");
        String className = componentName.getClassName();
        t.d(className, "primaryActivityName.className");
        String packageName2 = componentName4.getPackageName();
        t.d(packageName2, "secondaryActivityName.packageName");
        String className2 = componentName4.getClassName();
        t.d(className2, "secondaryActivityName.className");
        if (packageName.length() == 0 || packageName2.length() == 0) {
            throw new IllegalArgumentException("Package name must not be empty");
        } else if (className.length() == 0 || className2.length() == 0) {
            throw new IllegalArgumentException("Activity class name must not be empty.");
        } else if (!s.V(packageName, "*", false, 2, (Object) null) || s.f0(packageName, "*", 0, false, 6, (Object) null) == packageName.length() - 1) {
            if (s.V(className, "*", false, 2, (Object) null)) {
                str2 = "Wildcard in package name is only allowed at the end.";
                String str3 = className;
                if (s.f0(str3, "*", 0, false, 6, (Object) null) != str3.length() - 1) {
                    throw new IllegalArgumentException("Wildcard in class name is only allowed at the end.");
                }
            } else {
                str2 = "Wildcard in package name is only allowed at the end.";
            }
            if (s.V(packageName2, "*", false, 2, (Object) null)) {
                i5 = 2;
                obj = null;
                String str4 = packageName2;
                z4 = false;
                if (s.f0(str4, "*", 0, false, 6, (Object) null) != str4.length() - 1) {
                    throw new IllegalArgumentException(str2);
                }
            } else {
                z4 = false;
                i5 = 2;
                obj = null;
            }
            if (s.V(className2, "*", z4, i5, obj)) {
                String str5 = className2;
                if (s.f0(str5, "*", 0, false, 6, (Object) null) != str5.length() - 1) {
                    throw new IllegalArgumentException("Wildcard in class name is only allowed at the end.");
                }
            }
        } else {
            throw new IllegalArgumentException("Wildcard in package name is only allowed at the end.");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SplitPairFilter)) {
            return false;
        }
        SplitPairFilter splitPairFilter = (SplitPairFilter) obj;
        if (t.a(this.primaryActivityName, splitPairFilter.primaryActivityName) && t.a(this.secondaryActivityName, splitPairFilter.secondaryActivityName) && t.a(this.secondaryActivityIntentAction, splitPairFilter.secondaryActivityIntentAction)) {
            return true;
        }
        return false;
    }

    public final ComponentName getPrimaryActivityName() {
        return this.primaryActivityName;
    }

    public final String getSecondaryActivityIntentAction() {
        return this.secondaryActivityIntentAction;
    }

    public final ComponentName getSecondaryActivityName() {
        return this.secondaryActivityName;
    }

    public int hashCode() {
        int i5;
        int hashCode = ((this.primaryActivityName.hashCode() * 31) + this.secondaryActivityName.hashCode()) * 31;
        String str = this.secondaryActivityIntentAction;
        if (str == null) {
            i5 = 0;
        } else {
            i5 = str.hashCode();
        }
        return hashCode + i5;
    }

    public final boolean matchesActivityIntentPair(Activity activity, Intent intent) {
        t.e(activity, "primaryActivity");
        t.e(intent, "secondaryActivityIntent");
        ComponentName componentName = activity.getComponentName();
        MatcherUtils matcherUtils = MatcherUtils.INSTANCE;
        if (!matcherUtils.areComponentsMatching$window_release(componentName, this.primaryActivityName) || !matcherUtils.areComponentsMatching$window_release(intent.getComponent(), this.secondaryActivityName)) {
            return false;
        }
        String str = this.secondaryActivityIntentAction;
        if (str == null || t.a(str, intent.getAction())) {
            return true;
        }
        return false;
    }

    public final boolean matchesActivityPair(Activity activity, Activity activity2) {
        boolean z4;
        t.e(activity, "primaryActivity");
        t.e(activity2, "secondaryActivity");
        MatcherUtils matcherUtils = MatcherUtils.INSTANCE;
        if (!matcherUtils.areComponentsMatching$window_release(activity.getComponentName(), this.primaryActivityName) || !matcherUtils.areComponentsMatching$window_release(activity2.getComponentName(), this.secondaryActivityName)) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (activity2.getIntent() == null) {
            return z4;
        }
        if (z4) {
            Intent intent = activity2.getIntent();
            t.d(intent, "secondaryActivity.intent");
            if (matchesActivityIntentPair(activity, intent)) {
                return true;
            }
        }
        return false;
    }

    public String toString() {
        return "SplitPairFilter{primaryActivityName=" + this.primaryActivityName + ", secondaryActivityName=" + this.secondaryActivityName + ", secondaryActivityAction=" + this.secondaryActivityIntentAction + '}';
    }
}
