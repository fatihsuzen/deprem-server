package h;

import androidx.fragment.app.strictmode.FragmentStrictMode;
import androidx.fragment.app.strictmode.Violation;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f932a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Violation f933b;

    public /* synthetic */ b(String str, Violation violation) {
        this.f932a = str;
        this.f933b = violation;
    }

    public final void run() {
        FragmentStrictMode.m26handlePolicyViolation$lambda1(this.f932a, this.f933b);
    }
}
