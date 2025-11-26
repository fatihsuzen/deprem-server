package z2;

import android.content.Intent;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MainActivity;
import com.uptodown.tv.ui.activity.TvMainActivity;
import kotlin.jvm.internal.t;

public final class U {
    public final boolean a(MainActivity mainActivity) {
        t.e(mainActivity, "activity");
        if (!UptodownApp.f13477F.R(mainActivity)) {
            return false;
        }
        mainActivity.startActivity(new Intent(mainActivity, TvMainActivity.class));
        return true;
    }
}
