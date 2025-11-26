package O1;

import android.view.MenuItem;
import androidx.appcompat.widget.Toolbar;
import com.uptodown.activities.MyDownloads;

/* renamed from: O1.k3  reason: case insensitive filesystem */
public final /* synthetic */ class C0822k3 implements Toolbar.OnMenuItemClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ MyDownloads f3669a;

    public /* synthetic */ C0822k3(MyDownloads myDownloads) {
        this.f3669a = myDownloads;
    }

    public final boolean onMenuItemClick(MenuItem menuItem) {
        return MyDownloads.t4(this.f3669a, menuItem);
    }
}
