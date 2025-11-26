package O1;

import android.view.KeyEvent;
import android.widget.TextView;
import com.uptodown.activities.SearchActivity;

/* renamed from: O1.z5  reason: case insensitive filesystem */
public final /* synthetic */ class C0943z5 implements TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SearchActivity f3861a;

    public /* synthetic */ C0943z5(SearchActivity searchActivity) {
        this.f3861a = searchActivity;
    }

    public final boolean onEditorAction(TextView textView, int i5, KeyEvent keyEvent) {
        return SearchActivity.G3(this.f3861a, textView, i5, keyEvent);
    }
}
