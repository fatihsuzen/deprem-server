package O1;

import android.view.View;
import com.uptodown.activities.SecurityActivity;
import l2.C2655d;

public final /* synthetic */ class I5 implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SecurityActivity f3292a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ C2655d f3293b;

    public /* synthetic */ I5(SecurityActivity securityActivity, C2655d dVar) {
        this.f3292a = securityActivity;
        this.f3293b = dVar;
    }

    public final void onClick(View view) {
        SecurityActivity.k5(this.f3292a, this.f3293b, view);
    }
}
