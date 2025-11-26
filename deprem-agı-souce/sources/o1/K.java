package O1;

import android.view.View;
import com.uptodown.activities.ContactUsActivity;

public final /* synthetic */ class K implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ ContactUsActivity f3318a;

    public /* synthetic */ K(ContactUsActivity contactUsActivity) {
        this.f3318a = contactUsActivity;
    }

    public final void onFocusChange(View view, boolean z4) {
        ContactUsActivity.s3(this.f3318a, view, z4);
    }
}
