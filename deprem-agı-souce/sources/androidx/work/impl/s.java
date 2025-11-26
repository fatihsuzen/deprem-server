package androidx.work.impl;

import androidx.work.impl.utils.PreferenceUtils;
import k3.C2616a;

public final /* synthetic */ class s implements C2616a {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ PreferenceUtils f736a;

    public /* synthetic */ s(PreferenceUtils preferenceUtils) {
        this.f736a = preferenceUtils;
    }

    public final Object invoke() {
        return Long.valueOf(this.f736a.getLastCancelAllTimeMillis());
    }
}
