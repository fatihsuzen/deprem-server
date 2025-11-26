package androidx.window.embedding;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Intent;
import androidx.window.core.ExperimentalWindowApi;
import kotlin.jvm.internal.t;
import t3.s;

@ExperimentalWindowApi
public final class MatcherUtils {
    public static final MatcherUtils INSTANCE = new MatcherUtils();
    public static final boolean sDebugMatchers = false;
    public static final String sMatchersTag = "SplitRuleResolution";

    private MatcherUtils() {
    }

    private final boolean wildcardMatch(String str, String str2) {
        if (!s.V(str2, "*", false, 2, (Object) null)) {
            return false;
        }
        if (t.a(str2, "*")) {
            return true;
        }
        String str3 = str2;
        if (s.f0(str3, "*", 0, false, 6, (Object) null) != s.l0(str3, "*", 0, false, 6, (Object) null) || !s.D(str3, "*", false, 2, (Object) null)) {
            throw new IllegalArgumentException("Name pattern with a wildcard must only contain a single wildcard in the end");
        }
        String substring = str3.substring(0, str3.length() - 1);
        t.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
        return s.P(str, substring, false, 2, (Object) null);
    }

    public final boolean areActivityOrIntentComponentsMatching$window_release(Activity activity, ComponentName componentName) {
        ComponentName component;
        t.e(activity, "activity");
        t.e(componentName, "ruleComponent");
        if (areComponentsMatching$window_release(activity.getComponentName(), componentName)) {
            return true;
        }
        Intent intent = activity.getIntent();
        if (intent == null || (component = intent.getComponent()) == null) {
            return false;
        }
        return INSTANCE.areComponentsMatching$window_release(component, componentName);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0088 A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean areComponentsMatching$window_release(android.content.ComponentName r7, android.content.ComponentName r8) {
        /*
            r6 = this;
            java.lang.String r0 = "ruleComponent"
            kotlin.jvm.internal.t.e(r8, r0)
            java.lang.String r0 = "*"
            r1 = 1
            r2 = 0
            if (r7 != 0) goto L_0x0021
            java.lang.String r7 = r8.getPackageName()
            boolean r7 = kotlin.jvm.internal.t.a(r7, r0)
            if (r7 == 0) goto L_0x0020
            java.lang.String r7 = r8.getClassName()
            boolean r7 = kotlin.jvm.internal.t.a(r7, r0)
            if (r7 == 0) goto L_0x0020
            return r1
        L_0x0020:
            return r2
        L_0x0021:
            java.lang.String r3 = r7.toString()
            java.lang.String r4 = "activityComponent.toString()"
            kotlin.jvm.internal.t.d(r3, r4)
            r4 = 2
            r5 = 0
            boolean r0 = t3.s.V(r3, r0, r2, r4, r5)
            if (r0 != 0) goto L_0x008c
            java.lang.String r0 = r7.getPackageName()
            java.lang.String r3 = r8.getPackageName()
            boolean r0 = kotlin.jvm.internal.t.a(r0, r3)
            if (r0 != 0) goto L_0x005b
            java.lang.String r0 = r7.getPackageName()
            java.lang.String r3 = "activityComponent.packageName"
            kotlin.jvm.internal.t.d(r0, r3)
            java.lang.String r3 = r8.getPackageName()
            java.lang.String r4 = "ruleComponent.packageName"
            kotlin.jvm.internal.t.d(r3, r4)
            boolean r0 = r6.wildcardMatch(r0, r3)
            if (r0 == 0) goto L_0x0059
            goto L_0x005b
        L_0x0059:
            r0 = r2
            goto L_0x005c
        L_0x005b:
            r0 = r1
        L_0x005c:
            java.lang.String r3 = r7.getClassName()
            java.lang.String r4 = r8.getClassName()
            boolean r3 = kotlin.jvm.internal.t.a(r3, r4)
            if (r3 != 0) goto L_0x0085
            java.lang.String r7 = r7.getClassName()
            java.lang.String r3 = "activityComponent.className"
            kotlin.jvm.internal.t.d(r7, r3)
            java.lang.String r8 = r8.getClassName()
            java.lang.String r3 = "ruleComponent.className"
            kotlin.jvm.internal.t.d(r8, r3)
            boolean r7 = r6.wildcardMatch(r7, r8)
            if (r7 == 0) goto L_0x0083
            goto L_0x0085
        L_0x0083:
            r7 = r2
            goto L_0x0086
        L_0x0085:
            r7 = r1
        L_0x0086:
            if (r0 == 0) goto L_0x008b
            if (r7 == 0) goto L_0x008b
            return r1
        L_0x008b:
            return r2
        L_0x008c:
            java.lang.IllegalArgumentException r7 = new java.lang.IllegalArgumentException
            java.lang.String r8 = "Wildcard can only be part of the rule."
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.window.embedding.MatcherUtils.areComponentsMatching$window_release(android.content.ComponentName, android.content.ComponentName):boolean");
    }
}
