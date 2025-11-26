package O1;

import android.view.KeyEvent;
import android.widget.TextView;
import com.uptodown.activities.LoginActivity;

public final /* synthetic */ class J0 implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ LoginActivity f3296a;

    public /* synthetic */ J0(LoginActivity loginActivity) {
        this.f3296a = loginActivity;
    }

    public final boolean onEditorAction(TextView textView, int i5, KeyEvent keyEvent) {
        return LoginActivity.i4(this.f3296a, textView, i5, keyEvent);
    }
}
