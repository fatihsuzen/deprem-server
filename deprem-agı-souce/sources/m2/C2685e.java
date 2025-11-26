package m2;

import S1.k;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcelable;
import android.os.ResultReceiver;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.C1598a;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MoreInfo;
import com.uptodown.activities.MyApps;
import com.uptodown.activities.MyDownloads;
import com.uptodown.activities.OldVersionsActivity;
import com.uptodown.activities.OrganizationActivity;
import com.uptodown.activities.PublicListActivity;
import com.uptodown.activities.RecommendedActivity;
import com.uptodown.activities.Updates;
import com.uptodown.activities.WishlistActivity;
import com.uptodown.tv.ui.activity.TvAppDetailActivity;
import com.uptodown.tv.ui.activity.TvMyDownloadsActivity;
import com.uptodown.tv.ui.activity.TvOldVersionsActivity;
import java.io.File;
import l2.C2668q;
import v2.C2802b;

/* renamed from: m2.e  reason: case insensitive filesystem */
public final class C2685e extends ResultReceiver {
    public C2685e(Handler handler) {
        super(handler);
    }

    /* access modifiers changed from: protected */
    public void onReceiveResult(int i5, Bundle bundle) {
        C2668q qVar;
        String str;
        String str2;
        File n5;
        Long l5;
        Parcelable parcelable;
        String str3 = null;
        if (bundle != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) bundle.getParcelable("download", C2668q.class);
            } else {
                parcelable = bundle.getParcelable("download");
            }
            qVar = (C2668q) parcelable;
        } else {
            qVar = null;
        }
        k.a aVar = k.f32g;
        if (aVar.g() != null) {
            Activity g5 = aVar.g();
            if (i5 != 202) {
                if (i5 == 209 && (g5 instanceof C1598a)) {
                    C1598a aVar2 = (C1598a) g5;
                    aVar2.runOnUiThread(new C1598a.b());
                }
            } else if (qVar != null && (g5 instanceof C2802b) && !(g5 instanceof TvAppDetailActivity)) {
                C2802b bVar = (C2802b) g5;
                bVar.runOnUiThread(new C2802b.a(bVar, qVar));
            }
            if (g5 instanceof OldVersionsActivity) {
                if (qVar != null) {
                    l5 = Long.valueOf(qVar.E());
                } else {
                    l5 = null;
                }
                if (l5 != null) {
                    OldVersionsActivity oldVersionsActivity = (OldVersionsActivity) g5;
                    oldVersionsActivity.runOnUiThread(new OldVersionsActivity.c(i5, qVar));
                }
                if (!(i5 != 202 || qVar == null || qVar.n() == null)) {
                    OldVersionsActivity oldVersionsActivity2 = (OldVersionsActivity) g5;
                    oldVersionsActivity2.runOnUiThread(new OldVersionsActivity.b(oldVersionsActivity2, qVar));
                }
                if (i5 == 208) {
                    OldVersionsActivity oldVersionsActivity3 = (OldVersionsActivity) g5;
                    oldVersionsActivity3.runOnUiThread(new OldVersionsActivity.c(i5, (C2668q) null));
                    return;
                }
                return;
            }
            if ((g5 instanceof C1598a) && aVar.i() == null && i5 == 202 && qVar != null && qVar.f() && (n5 = qVar.n()) != null) {
                C1598a.D2((C1598a) g5, n5, (String) null, 2, (Object) null);
            }
            if (g5 instanceof MainActivity) {
                if (qVar != null) {
                    ((MainActivity) g5).o8(qVar, i5);
                }
            } else if (g5 instanceof MyDownloads) {
                ((MyDownloads) g5).J4(i5, qVar);
            } else if (g5 instanceof Updates) {
                Updates updates = (Updates) g5;
                if (qVar != null) {
                    str2 = qVar.w();
                } else {
                    str2 = null;
                }
                updates.e6(i5, str2, (Bundle) null);
            } else if (g5 instanceof MyApps) {
                MyApps myApps = (MyApps) g5;
                if (qVar != null) {
                    str = qVar.w();
                } else {
                    str = null;
                }
                myApps.E5(i5, str, (Bundle) null);
            } else if (g5 instanceof AppDetailActivity) {
                if (bundle != null) {
                    str3 = bundle.getString("packagename");
                }
                if (!(str3 == null || str3.length() == 0)) {
                    AppDetailActivity appDetailActivity = (AppDetailActivity) g5;
                    appDetailActivity.runOnUiThread(new AppDetailActivity.b(i5, str3));
                }
                AppDetailActivity appDetailActivity2 = (AppDetailActivity) g5;
                appDetailActivity2.runOnUiThread(new AppDetailActivity.d(i5, qVar));
            } else if (g5 instanceof TvAppDetailActivity) {
                TvAppDetailActivity tvAppDetailActivity = (TvAppDetailActivity) g5;
                tvAppDetailActivity.runOnUiThread(new TvAppDetailActivity.c(i5, qVar));
            } else if (g5 instanceof TvOldVersionsActivity) {
                TvOldVersionsActivity tvOldVersionsActivity = (TvOldVersionsActivity) g5;
                tvOldVersionsActivity.runOnUiThread(new TvOldVersionsActivity.a(i5, qVar));
            } else if (g5 instanceof TvMyDownloadsActivity) {
                TvMyDownloadsActivity tvMyDownloadsActivity = (TvMyDownloadsActivity) g5;
                tvMyDownloadsActivity.runOnUiThread(new TvMyDownloadsActivity.a(i5, qVar));
            } else if (g5 instanceof WishlistActivity) {
                WishlistActivity wishlistActivity = (WishlistActivity) g5;
                if (qVar != null) {
                    str3 = qVar.w();
                }
                wishlistActivity.D5(str3);
            } else if (g5 instanceof RecommendedActivity) {
                RecommendedActivity recommendedActivity = (RecommendedActivity) g5;
                if (qVar != null) {
                    str3 = qVar.w();
                }
                recommendedActivity.F5(str3);
            } else if (g5 instanceof PublicListActivity) {
                PublicListActivity publicListActivity = (PublicListActivity) g5;
                if (qVar != null) {
                    str3 = qVar.w();
                }
                publicListActivity.j5(str3);
            } else if (g5 instanceof MoreInfo) {
                MoreInfo moreInfo = (MoreInfo) g5;
                moreInfo.runOnUiThread(new MoreInfo.a(qVar));
            } else if (g5 instanceof OrganizationActivity) {
                ((OrganizationActivity) g5).H3(qVar);
            }
        }
    }
}
