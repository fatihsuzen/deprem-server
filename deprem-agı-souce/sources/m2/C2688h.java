package m2;

import S1.k;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.MyDownloads;
import com.uptodown.activities.OldVersionsActivity;
import com.uptodown.activities.Updates;
import com.uptodown.core.activities.InstallerActivity;
import com.uptodown.tv.ui.activity.TvAppDetailActivity;
import kotlin.jvm.internal.t;

/* renamed from: m2.h  reason: case insensitive filesystem */
public final class C2688h extends ResultReceiver {
    public C2688h(Handler handler) {
        super(handler);
    }

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i5, Bundle bundle) {
        t.e(bundle, "resultData");
        String string = bundle.getString("packageName");
        Activity g5 = k.f32g.g();
        if (g5 == null) {
            return;
        }
        if (g5 instanceof Updates) {
            if (string != null) {
                ((Updates) g5).i6(i5, string);
            }
        } else if (g5 instanceof MyApps) {
            if (string != null) {
                ((MyApps) g5).D5(i5, string);
            }
        } else if (g5 instanceof AppDetailActivity) {
            if (string != null) {
                AppDetailActivity appDetailActivity = (AppDetailActivity) g5;
                appDetailActivity.runOnUiThread(new AppDetailActivity.c(appDetailActivity, string, i5));
            }
        } else if (g5 instanceof MyDownloads) {
            MyDownloads myDownloads = (MyDownloads) g5;
            myDownloads.runOnUiThread(new MyDownloads.b(i5));
        } else if (g5 instanceof OldVersionsActivity) {
            OldVersionsActivity oldVersionsActivity = (OldVersionsActivity) g5;
            oldVersionsActivity.runOnUiThread(new OldVersionsActivity.d(string, i5));
        } else if (g5 instanceof InstallerActivity) {
            if (i5 == 351) {
                ((InstallerActivity) g5).g2();
            } else {
                ((InstallerActivity) g5).finish();
            }
        } else if (g5 instanceof TvAppDetailActivity) {
            if (string != null) {
                TvAppDetailActivity tvAppDetailActivity = (TvAppDetailActivity) g5;
                tvAppDetailActivity.runOnUiThread(new TvAppDetailActivity.b(tvAppDetailActivity, string, i5));
            }
        } else if ((g5 instanceof MainActivity) && string != null) {
            MainActivity mainActivity = (MainActivity) g5;
            mainActivity.runOnUiThread(new MainActivity.C1591d(mainActivity, i5, string));
        }
    }
}
