package O1;

import android.view.View;
import com.uptodown.activities.ContactUsActivity;

public final /* synthetic */ class J implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ContactUsActivity f3295a;

    public /* synthetic */ J(ContactUsActivity contactUsActivity) {
        this.f3295a = contactUsActivity;
    }

    public final void onFocusChange(View view, boolean z4) {
        ContactUsActivity.r3(this.f3295a, view, z4);
    }
}
