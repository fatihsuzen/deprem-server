package O1;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import com.uptodown.activities.UserActivity;

public final /* synthetic */ class V5 implements Toolbar.OnMenuItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ UserActivity f3521a;

    public /* synthetic */ V5(UserActivity userActivity) {
        this.f3521a = userActivity;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return UserActivity.n4(this.f3521a, menuItem);
    }
}
