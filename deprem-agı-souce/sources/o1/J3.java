package O1;

import android.view.ViewTreeObserver;
import com.uptodown.activities.OrganizationActivity;
import h2.C2432p0;

public final /* synthetic */ class J3 implements ViewTreeObserver.OnScrollChangedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ OrganizationActivity f3300a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2432p0 f3301b;

    public /* synthetic */ J3(OrganizationActivity organizationActivity, C2432p0 p0Var) {
        this.f3300a = organizationActivity;
        this.f3301b = p0Var;
    }

    public final void onScrollChanged() {
        OrganizationActivity.E3(this.f3300a, this.f3301b);
    }
}
