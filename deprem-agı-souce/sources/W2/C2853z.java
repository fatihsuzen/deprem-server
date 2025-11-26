package w2;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.app.RowsSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.preferences.PreferencesActivity;
import com.uptodown.tv.ui.activity.TvMyAppsActivity;
import com.uptodown.tv.ui.activity.TvMyDownloadsActivity;
import kotlin.jvm.internal.t;
import l2.T;
import s2.C2745b;
import u2.k;
import z2.C2940B;
import z2.F;

/* renamed from: w2.z  reason: case insensitive filesystem */
public final class C2853z extends RowsSupportFragment {

    /* renamed from: a  reason: collision with root package name */
    private ArrayObjectAdapter f26211a;

    /* renamed from: b  reason: collision with root package name */
    private final ActivityResultLauncher f26212b;

    public C2853z() {
        ListRowPresenter listRowPresenter = new ListRowPresenter(4);
        listRowPresenter.setShadowEnabled(false);
        this.f26211a = new ArrayObjectAdapter((Presenter) listRowPresenter);
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C2850w(this));
        t.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f26212b = registerForActivityResult;
    }

    private final void i(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setMessage(str);
        builder.setPositiveButton(17039370, new C2852y());
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        if (create != null) {
            create.show();
        }
    }

    /* access modifiers changed from: private */
    public static final void j(DialogInterface dialogInterface, int i5) {
        t.e(dialogInterface, "dialog");
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void k(C2853z zVar, Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        if (obj instanceof C2745b) {
            int b5 = ((C2745b) obj).b();
            Class<TvMyAppsActivity> cls = TvMyAppsActivity.class;
            if (b5 == 0) {
                Intent intent = new Intent(zVar.getContext(), cls);
                intent.putExtra("updates", true);
                zVar.startActivity(intent);
            } else if (b5 == 1) {
                zVar.startActivity(new Intent(zVar.getContext(), cls));
            } else if (b5 == 2) {
                Intent intent2 = new Intent(zVar.getContext(), cls);
                intent2.putExtra("rollback", true);
                zVar.startActivity(intent2);
            } else if (b5 == 3) {
                zVar.startActivity(new Intent(zVar.getContext(), TvMyDownloadsActivity.class));
            } else if (b5 == 4) {
                zVar.f26212b.launch(new Intent(zVar.getContext(), PreferencesActivity.class));
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void l(C2853z zVar, ActivityResult activityResult) {
        int resultCode = activityResult.getResultCode();
        if (resultCode == 1003) {
            C2940B.a aVar = C2940B.f26458v;
            Context requireContext = zVar.requireContext();
            t.d(requireContext, "requireContext(...)");
            C2940B a5 = aVar.a(requireContext);
            a5.a();
            a5.s();
            a5.m();
            String string = zVar.getString(R.string.restart_for_changes_take_effect);
            t.d(string, "getString(...)");
            zVar.i(string);
        } else if (resultCode == 1004) {
            UptodownApp.a aVar2 = UptodownApp.f13477F;
            Context requireContext2 = zVar.requireContext();
            t.d(requireContext2, "requireContext(...)");
            aVar2.e(requireContext2);
            String string2 = zVar.getString(R.string.restart_for_changes_take_effect);
            t.d(string2, "getString(...)");
            zVar.i(string2);
        }
    }

    public void onCreate(Bundle bundle) {
        String str;
        BrowseSupportFragment.FragmentHost fragmentHost;
        super.onCreate(bundle);
        if (getContext() != null) {
            F f5 = new F(getContext());
            String simpleName = C2853z.class.getSimpleName();
            t.d(simpleName, "getSimpleName(...)");
            f5.f(simpleName);
            HeaderItem headerItem = new HeaderItem(getString(R.string.manage_apps));
            T.b bVar = T.f24856k;
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            int a5 = bVar.a(requireContext);
            if (a5 > 0) {
                str = " (" + a5 + ')';
            } else {
                str = "";
            }
            ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((Presenter) new k());
            C2745b bVar2 = new C2745b();
            bVar2.e(0);
            bVar2.f(getString(R.string.updates) + str);
            bVar2.d(R.drawable.vector_tv_updates);
            arrayObjectAdapter.add(bVar2);
            C2745b bVar3 = new C2745b();
            bVar3.e(1);
            bVar3.f(getString(R.string.installed));
            bVar3.d(R.drawable.vector_tv_installed);
            arrayObjectAdapter.add(bVar3);
            C2745b bVar4 = new C2745b();
            bVar4.e(2);
            bVar4.f(getString(R.string.rollback_title));
            bVar4.d(R.drawable.vector_tv_rollback);
            arrayObjectAdapter.add(bVar4);
            C2745b bVar5 = new C2745b();
            bVar5.e(3);
            bVar5.f(getString(R.string.downloads_title));
            bVar5.d(R.drawable.vector_tv_downloads);
            arrayObjectAdapter.add(bVar5);
            C2745b bVar6 = new C2745b();
            bVar6.e(4);
            bVar6.f(getString(R.string.settings));
            bVar6.d(R.drawable.vector_tv_settings);
            arrayObjectAdapter.add(bVar6);
            this.f26211a.add(new ListRow(headerItem, arrayObjectAdapter));
            setAdapter(this.f26211a);
            BrowseSupportFragment.MainFragmentAdapter mainFragmentAdapter = getMainFragmentAdapter();
            if (mainFragmentAdapter != null && (fragmentHost = mainFragmentAdapter.getFragmentHost()) != null) {
                fragmentHost.notifyDataReady(getMainFragmentAdapter());
            }
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        super.onViewCreated(view, bundle);
        setOnItemViewClickedListener(new C2851x(this));
    }
}
