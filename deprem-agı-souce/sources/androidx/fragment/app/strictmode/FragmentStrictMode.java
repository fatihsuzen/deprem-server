package androidx.fragment.app.strictmode;

import X2.C2250q;
import X2.M;
import X2.T;
import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.ViewGroup;
import androidx.annotation.RestrictTo;
import androidx.annotation.VisibleForTesting;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import h.a;
import h.b;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class FragmentStrictMode {
    public static final FragmentStrictMode INSTANCE = new FragmentStrictMode();
    private static final String TAG = "FragmentStrictMode";
    private static Policy defaultPolicy = Policy.LAX;

    public enum Flag {
        PENALTY_LOG,
        PENALTY_DEATH,
        DETECT_FRAGMENT_REUSE,
        DETECT_FRAGMENT_TAG_USAGE,
        DETECT_RETAIN_INSTANCE_USAGE,
        DETECT_SET_USER_VISIBLE_HINT,
        DETECT_TARGET_FRAGMENT_USAGE,
        DETECT_WRONG_FRAGMENT_CONTAINER
    }

    public interface OnViolationListener {
        void onViolation(Violation violation);
    }

    public static final class Policy {
        public static final Companion Companion = new Companion((C2633k) null);
        public static final Policy LAX = new Policy(T.d(), (OnViolationListener) null, M.h());
        private final Set<Flag> flags;
        private final OnViolationListener listener;
        private final Map<String, Set<Class<? extends Violation>>> mAllowedViolations;

        public static final class Companion {
            public /* synthetic */ Companion(C2633k kVar) {
                this();
            }

            private Companion() {
            }
        }

        public Policy(Set<? extends Flag> set, OnViolationListener onViolationListener, Map<String, ? extends Set<Class<? extends Violation>>> map) {
            t.e(set, "flags");
            t.e(map, "allowedViolations");
            this.flags = set;
            this.listener = onViolationListener;
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (Map.Entry next : map.entrySet()) {
                linkedHashMap.put((String) next.getKey(), (Set) next.getValue());
            }
            this.mAllowedViolations = linkedHashMap;
        }

        public final Set<Flag> getFlags$fragment_release() {
            return this.flags;
        }

        public final OnViolationListener getListener$fragment_release() {
            return this.listener;
        }

        public final Map<String, Set<Class<? extends Violation>>> getMAllowedViolations$fragment_release() {
            return this.mAllowedViolations;
        }

        public static final class Builder {
            private final Set<Flag> flags = new LinkedHashSet();
            private OnViolationListener listener;
            private final Map<String, Set<Class<? extends Violation>>> mAllowedViolations = new LinkedHashMap();

            @SuppressLint({"BuilderSetStyle"})
            public final Builder allowViolation(Class<? extends Fragment> cls, Class<? extends Violation> cls2) {
                t.e(cls, "fragmentClass");
                t.e(cls2, "violationClass");
                String name = cls.getName();
                t.d(name, "fragmentClassString");
                return allowViolation(name, cls2);
            }

            public final Policy build() {
                if (this.listener == null && !this.flags.contains(Flag.PENALTY_DEATH)) {
                    penaltyLog();
                }
                return new Policy(this.flags, this.listener, this.mAllowedViolations);
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder detectFragmentReuse() {
                this.flags.add(Flag.DETECT_FRAGMENT_REUSE);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder detectFragmentTagUsage() {
                this.flags.add(Flag.DETECT_FRAGMENT_TAG_USAGE);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder detectRetainInstanceUsage() {
                this.flags.add(Flag.DETECT_RETAIN_INSTANCE_USAGE);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder detectSetUserVisibleHint() {
                this.flags.add(Flag.DETECT_SET_USER_VISIBLE_HINT);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder detectTargetFragmentUsage() {
                this.flags.add(Flag.DETECT_TARGET_FRAGMENT_USAGE);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder detectWrongFragmentContainer() {
                this.flags.add(Flag.DETECT_WRONG_FRAGMENT_CONTAINER);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder penaltyDeath() {
                this.flags.add(Flag.PENALTY_DEATH);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder penaltyListener(OnViolationListener onViolationListener) {
                t.e(onViolationListener, "listener");
                this.listener = onViolationListener;
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder penaltyLog() {
                this.flags.add(Flag.PENALTY_LOG);
                return this;
            }

            @SuppressLint({"BuilderSetStyle"})
            public final Builder allowViolation(String str, Class<? extends Violation> cls) {
                t.e(str, "fragmentClass");
                t.e(cls, "violationClass");
                Set set = this.mAllowedViolations.get(str);
                if (set == null) {
                    set = new LinkedHashSet();
                }
                set.add(cls);
                this.mAllowedViolations.put(str, set);
                return this;
            }
        }
    }

    private FragmentStrictMode() {
    }

    private final Policy getNearestPolicy(Fragment fragment) {
        while (fragment != null) {
            if (fragment.isAdded()) {
                FragmentManager parentFragmentManager = fragment.getParentFragmentManager();
                t.d(parentFragmentManager, "declaringFragment.parentFragmentManager");
                if (parentFragmentManager.getStrictModePolicy() != null) {
                    Policy strictModePolicy = parentFragmentManager.getStrictModePolicy();
                    t.b(strictModePolicy);
                    return strictModePolicy;
                }
            }
            fragment = fragment.getParentFragment();
        }
        return defaultPolicy;
    }

    private final void handlePolicyViolation(Policy policy, Violation violation) {
        Fragment fragment = violation.getFragment();
        String name = fragment.getClass().getName();
        if (policy.getFlags$fragment_release().contains(Flag.PENALTY_LOG)) {
            Log.d(TAG, "Policy violation in " + name, violation);
        }
        if (policy.getListener$fragment_release() != null) {
            runOnHostThread(fragment, new a(policy, violation));
        }
        if (policy.getFlags$fragment_release().contains(Flag.PENALTY_DEATH)) {
            runOnHostThread(fragment, new b(name, violation));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: handlePolicyViolation$lambda-0  reason: not valid java name */
    public static final void m25handlePolicyViolation$lambda0(Policy policy, Violation violation) {
        t.e(policy, "$policy");
        t.e(violation, "$violation");
        policy.getListener$fragment_release().onViolation(violation);
    }

    /* access modifiers changed from: private */
    /* renamed from: handlePolicyViolation$lambda-1  reason: not valid java name */
    public static final void m26handlePolicyViolation$lambda1(String str, Violation violation) {
        t.e(violation, "$violation");
        Log.e(TAG, "Policy violation with PENALTY_DEATH in " + str, violation);
        throw violation;
    }

    private final void logIfDebuggingEnabled(Violation violation) {
        if (FragmentManager.isLoggingEnabled(3)) {
            Log.d(FragmentManager.TAG, "StrictMode violation in " + violation.getFragment().getClass().getName(), violation);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onFragmentReuse(Fragment fragment, String str) {
        t.e(fragment, "fragment");
        t.e(str, "previousFragmentId");
        FragmentReuseViolation fragmentReuseViolation = new FragmentReuseViolation(fragment, str);
        FragmentStrictMode fragmentStrictMode = INSTANCE;
        fragmentStrictMode.logIfDebuggingEnabled(fragmentReuseViolation);
        Policy nearestPolicy = fragmentStrictMode.getNearestPolicy(fragment);
        if (nearestPolicy.getFlags$fragment_release().contains(Flag.DETECT_FRAGMENT_REUSE) && fragmentStrictMode.shouldHandlePolicyViolation(nearestPolicy, fragment.getClass(), fragmentReuseViolation.getClass())) {
            fragmentStrictMode.handlePolicyViolation(nearestPolicy, fragmentReuseViolation);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onFragmentTagUsage(Fragment fragment, ViewGroup viewGroup) {
        t.e(fragment, "fragment");
        FragmentTagUsageViolation fragmentTagUsageViolation = new FragmentTagUsageViolation(fragment, viewGroup);
        FragmentStrictMode fragmentStrictMode = INSTANCE;
        fragmentStrictMode.logIfDebuggingEnabled(fragmentTagUsageViolation);
        Policy nearestPolicy = fragmentStrictMode.getNearestPolicy(fragment);
        if (nearestPolicy.getFlags$fragment_release().contains(Flag.DETECT_FRAGMENT_TAG_USAGE) && fragmentStrictMode.shouldHandlePolicyViolation(nearestPolicy, fragment.getClass(), fragmentTagUsageViolation.getClass())) {
            fragmentStrictMode.handlePolicyViolation(nearestPolicy, fragmentTagUsageViolation);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onGetRetainInstanceUsage(Fragment fragment) {
        t.e(fragment, "fragment");
        GetRetainInstanceUsageViolation getRetainInstanceUsageViolation = new GetRetainInstanceUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = INSTANCE;
        fragmentStrictMode.logIfDebuggingEnabled(getRetainInstanceUsageViolation);
        Policy nearestPolicy = fragmentStrictMode.getNearestPolicy(fragment);
        if (nearestPolicy.getFlags$fragment_release().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) && fragmentStrictMode.shouldHandlePolicyViolation(nearestPolicy, fragment.getClass(), getRetainInstanceUsageViolation.getClass())) {
            fragmentStrictMode.handlePolicyViolation(nearestPolicy, getRetainInstanceUsageViolation);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onGetTargetFragmentRequestCodeUsage(Fragment fragment) {
        t.e(fragment, "fragment");
        GetTargetFragmentRequestCodeUsageViolation getTargetFragmentRequestCodeUsageViolation = new GetTargetFragmentRequestCodeUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = INSTANCE;
        fragmentStrictMode.logIfDebuggingEnabled(getTargetFragmentRequestCodeUsageViolation);
        Policy nearestPolicy = fragmentStrictMode.getNearestPolicy(fragment);
        if (nearestPolicy.getFlags$fragment_release().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.shouldHandlePolicyViolation(nearestPolicy, fragment.getClass(), getTargetFragmentRequestCodeUsageViolation.getClass())) {
            fragmentStrictMode.handlePolicyViolation(nearestPolicy, getTargetFragmentRequestCodeUsageViolation);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onGetTargetFragmentUsage(Fragment fragment) {
        t.e(fragment, "fragment");
        GetTargetFragmentUsageViolation getTargetFragmentUsageViolation = new GetTargetFragmentUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = INSTANCE;
        fragmentStrictMode.logIfDebuggingEnabled(getTargetFragmentUsageViolation);
        Policy nearestPolicy = fragmentStrictMode.getNearestPolicy(fragment);
        if (nearestPolicy.getFlags$fragment_release().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.shouldHandlePolicyViolation(nearestPolicy, fragment.getClass(), getTargetFragmentUsageViolation.getClass())) {
            fragmentStrictMode.handlePolicyViolation(nearestPolicy, getTargetFragmentUsageViolation);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onSetRetainInstanceUsage(Fragment fragment) {
        t.e(fragment, "fragment");
        SetRetainInstanceUsageViolation setRetainInstanceUsageViolation = new SetRetainInstanceUsageViolation(fragment);
        FragmentStrictMode fragmentStrictMode = INSTANCE;
        fragmentStrictMode.logIfDebuggingEnabled(setRetainInstanceUsageViolation);
        Policy nearestPolicy = fragmentStrictMode.getNearestPolicy(fragment);
        if (nearestPolicy.getFlags$fragment_release().contains(Flag.DETECT_RETAIN_INSTANCE_USAGE) && fragmentStrictMode.shouldHandlePolicyViolation(nearestPolicy, fragment.getClass(), setRetainInstanceUsageViolation.getClass())) {
            fragmentStrictMode.handlePolicyViolation(nearestPolicy, setRetainInstanceUsageViolation);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onSetTargetFragmentUsage(Fragment fragment, Fragment fragment2, int i5) {
        t.e(fragment, "violatingFragment");
        t.e(fragment2, "targetFragment");
        SetTargetFragmentUsageViolation setTargetFragmentUsageViolation = new SetTargetFragmentUsageViolation(fragment, fragment2, i5);
        FragmentStrictMode fragmentStrictMode = INSTANCE;
        fragmentStrictMode.logIfDebuggingEnabled(setTargetFragmentUsageViolation);
        Policy nearestPolicy = fragmentStrictMode.getNearestPolicy(fragment);
        if (nearestPolicy.getFlags$fragment_release().contains(Flag.DETECT_TARGET_FRAGMENT_USAGE) && fragmentStrictMode.shouldHandlePolicyViolation(nearestPolicy, fragment.getClass(), setTargetFragmentUsageViolation.getClass())) {
            fragmentStrictMode.handlePolicyViolation(nearestPolicy, setTargetFragmentUsageViolation);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onSetUserVisibleHint(Fragment fragment, boolean z4) {
        t.e(fragment, "fragment");
        SetUserVisibleHintViolation setUserVisibleHintViolation = new SetUserVisibleHintViolation(fragment, z4);
        FragmentStrictMode fragmentStrictMode = INSTANCE;
        fragmentStrictMode.logIfDebuggingEnabled(setUserVisibleHintViolation);
        Policy nearestPolicy = fragmentStrictMode.getNearestPolicy(fragment);
        if (nearestPolicy.getFlags$fragment_release().contains(Flag.DETECT_SET_USER_VISIBLE_HINT) && fragmentStrictMode.shouldHandlePolicyViolation(nearestPolicy, fragment.getClass(), setUserVisibleHintViolation.getClass())) {
            fragmentStrictMode.handlePolicyViolation(nearestPolicy, setUserVisibleHintViolation);
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public static final void onWrongFragmentContainer(Fragment fragment, ViewGroup viewGroup) {
        t.e(fragment, "fragment");
        t.e(viewGroup, "container");
        WrongFragmentContainerViolation wrongFragmentContainerViolation = new WrongFragmentContainerViolation(fragment, viewGroup);
        FragmentStrictMode fragmentStrictMode = INSTANCE;
        fragmentStrictMode.logIfDebuggingEnabled(wrongFragmentContainerViolation);
        Policy nearestPolicy = fragmentStrictMode.getNearestPolicy(fragment);
        if (nearestPolicy.getFlags$fragment_release().contains(Flag.DETECT_WRONG_FRAGMENT_CONTAINER) && fragmentStrictMode.shouldHandlePolicyViolation(nearestPolicy, fragment.getClass(), wrongFragmentContainerViolation.getClass())) {
            fragmentStrictMode.handlePolicyViolation(nearestPolicy, wrongFragmentContainerViolation);
        }
    }

    private final void runOnHostThread(Fragment fragment, Runnable runnable) {
        if (fragment.isAdded()) {
            Handler handler = fragment.getParentFragmentManager().getHost().getHandler();
            t.d(handler, "fragment.parentFragmentManager.host.handler");
            if (t.a(handler.getLooper(), Looper.myLooper())) {
                runnable.run();
            } else {
                handler.post(runnable);
            }
        } else {
            runnable.run();
        }
    }

    private final boolean shouldHandlePolicyViolation(Policy policy, Class<? extends Fragment> cls, Class<? extends Violation> cls2) {
        Set set = policy.getMAllowedViolations$fragment_release().get(cls.getName());
        if (set == null) {
            return true;
        }
        if (t.a(cls2.getSuperclass(), Violation.class) || !C2250q.E(set, cls2.getSuperclass())) {
            return !set.contains(cls2);
        }
        return false;
    }

    public final Policy getDefaultPolicy() {
        return defaultPolicy;
    }

    @VisibleForTesting
    public final void onPolicyViolation(Violation violation) {
        t.e(violation, "violation");
        logIfDebuggingEnabled(violation);
        Fragment fragment = violation.getFragment();
        Policy nearestPolicy = getNearestPolicy(fragment);
        if (shouldHandlePolicyViolation(nearestPolicy, fragment.getClass(), violation.getClass())) {
            handlePolicyViolation(nearestPolicy, violation);
        }
    }

    public final void setDefaultPolicy(Policy policy) {
        t.e(policy, "<set-?>");
        defaultPolicy = policy;
    }
}
