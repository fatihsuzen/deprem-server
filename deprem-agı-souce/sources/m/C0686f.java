package M;

import N.C0722p;
import android.app.Activity;
import androidx.fragment.app.FragmentActivity;

/* renamed from: M.f  reason: case insensitive filesystem */
public class C0686f {

    /* renamed from: a  reason: collision with root package name */
    private final Object f2918a;

    public C0686f(Activity activity) {
        C0722p.l(activity, "Activity must not be null");
        this.f2918a = activity;
    }

    public final Activity a() {
        return (Activity) this.f2918a;
    }

    public final FragmentActivity b() {
        return (FragmentActivity) this.f2918a;
    }

    public final boolean c() {
        return this.f2918a instanceof Activity;
    }

    public final boolean d() {
        return this.f2918a instanceof FragmentActivity;
    }
}
