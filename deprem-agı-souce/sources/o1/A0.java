package O1;

import android.view.View;
import com.uptodown.activities.LoginActivity;

public final /* synthetic */ class A0 implements View.OnFocusChangeListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LoginActivity f3196a;

    public /* synthetic */ A0(LoginActivity loginActivity) {
        this.f3196a = loginActivity;
    }

    public final void onFocusChange(View view, boolean z4) {
        LoginActivity.a4(this.f3196a, view, z4);
    }
}
