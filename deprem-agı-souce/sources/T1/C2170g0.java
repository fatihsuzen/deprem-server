package T1;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import com.uptodown.core.activities.FileExplorerActivity;

/* renamed from: T1.g0  reason: case insensitive filesystem */
public final /* synthetic */ class C2170g0 implements Toolbar.OnMenuItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ FileExplorerActivity f19129a;

    public /* synthetic */ C2170g0(FileExplorerActivity fileExplorerActivity) {
        this.f19129a = fileExplorerActivity;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return FileExplorerActivity.B4(this.f19129a, menuItem);
    }
}
