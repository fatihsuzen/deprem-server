package h;

import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.Violation;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FragmentStrictMode.Policy f930a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Violation f931b;

    public /* synthetic */ a(FragmentStrictMode.Policy policy, Violation violation) {
        this.f930a = policy;
        this.f931b = violation;
    }

    public final void run() {
        FragmentStrictMode.m25handlePolicyViolation$lambda0(this.f930a, this.f931b);
    }
}
