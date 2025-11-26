package O1;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import com.uptodown.activities.NotificationsRegistryActivity;

/* renamed from: O1.x3  reason: case insensitive filesystem */
public final /* synthetic */ class C0925x3 implements Toolbar.OnMenuItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ NotificationsRegistryActivity f3839a;

    public /* synthetic */ C0925x3(NotificationsRegistryActivity notificationsRegistryActivity) {
        this.f3839a = notificationsRegistryActivity;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return NotificationsRegistryActivity.D3(this.f3839a, menuItem);
    }
}
