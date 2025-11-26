package O1;

import android.view.KeyEvent;
import android.widget.TextView;
import com.uptodown.activities.RepliesActivity;

public final /* synthetic */ class Q4 implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ RepliesActivity f3419a;

    public /* synthetic */ Q4(RepliesActivity repliesActivity) {
        this.f3419a = repliesActivity;
    }

    public final boolean onEditorAction(TextView textView, int i5, KeyEvent keyEvent) {
        return RepliesActivity.O3(this.f3419a, textView, i5, keyEvent);
    }
}
