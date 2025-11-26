package O1;

import android.view.View;
import com.uptodown.activities.LoginActivity;

public final /* synthetic */ class D0 implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LoginActivity f3235a;

    public /* synthetic */ D0(LoginActivity loginActivity) {
        this.f3235a = loginActivity;
    }

    public final void onFocusChange(View view, boolean z4) {
        LoginActivity.c4(this.f3235a, view, z4);
    }
}
