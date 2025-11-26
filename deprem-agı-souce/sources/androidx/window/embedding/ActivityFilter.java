package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.window.core.ExperimentalWindowApi;
import kotlin.jvm.internal.t;
import t3.s;

@ExperimentalWindowApi
public final class ActivityFilter {
    private final ComponentName componentName;
    private final String intentAction;

    public ActivityFilter(ComponentName componentName2, String str) {
        t.e(componentName2, "componentName");
        this.componentName = componentName2;
        this.intentAction = str;
        String packageName = componentName2.getPackageName();
        t.d(packageName, "componentName.packageName");
        String className = componentName2.getClassName();
        t.d(className, "componentName.className");
        if (packageName.length() <= 0) {
            throw new IllegalArgumentException("Package name must not be empty");
        } else if (className.length() <= 0) {
            throw new IllegalArgumentException("Activity class name must not be empty.");
        } else if (s.V(packageName, "*", false, 2, (Object) null) && s.f0(packageName, "*", 0, false, 6, (Object) null) != packageName.length() - 1) {
            throw new IllegalArgumentException("Wildcard in package name is only allowed at the end.");
        } else if (s.V(className, "*", false, 2, (Object) null)) {
            String str2 = className;
            if (s.f0(str2, "*", 0, false, 6, (Object) null) != str2.length() - 1) {
                throw new IllegalArgumentException("Wildcard in class name is only allowed at the end.");
            }
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ActivityFilter)) {
            return false;
        }
        ActivityFilter activityFilter = (ActivityFilter) obj;
        if (t.a(this.componentName, activityFilter.componentName) && t.a(this.intentAction, activityFilter.intentAction)) {
            return true;
        }
        return false;
    }

    public final ComponentName getComponentName() {
        return this.componentName;
    }

    public final String getIntentAction() {
        return this.intentAction;
    }

    public int hashCode() {
        int i5;
        int hashCode = this.componentName.hashCode() * 31;
        String str = this.intentAction;
        if (str == null) {
            i5 = 0;
        } else {
            i5 = str.hashCode();
        }
        return hashCode + i5;
    }

    public final boolean matchesActivity(Activity activity) {
        String str;
        t.e(activity, "activity");
        if (!MatcherUtils.INSTANCE.areActivityOrIntentComponentsMatching$window_release(activity, this.componentName)) {
            return false;
        }
        String str2 = this.intentAction;
        if (str2 == null) {
            return true;
        }
        Intent intent = activity.getIntent();
        if (intent == null) {
            str = null;
        } else {
            str = intent.getAction();
        }
        if (t.a(str2, str)) {
            return true;
        }
        return false;
    }

    public final boolean matchesIntent(Intent intent) {
        t.e(intent, "intent");
        if (!MatcherUtils.INSTANCE.areComponentsMatching$window_release(intent.getComponent(), this.componentName)) {
            return false;
        }
        String str = this.intentAction;
        if (str == null || t.a(str, intent.getAction())) {
            return true;
        }
        return false;
    }

    public String toString() {
        return "ActivityFilter(componentName=" + this.componentName + ", intentAction=" + this.intentAction + ')';
    }
}
