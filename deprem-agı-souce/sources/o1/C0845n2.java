package O1;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import com.uptodown.activities.MyApps;

/* renamed from: O1.n2  reason: case insensitive filesystem */
public final /* synthetic */ class C0845n2 implements Toolbar.OnMenuItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MyApps f3727a;

    public /* synthetic */ C0845n2(MyApps myApps) {
        this.f3727a = myApps;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return MyApps.q5(this.f3727a, menuItem);
    }
}
