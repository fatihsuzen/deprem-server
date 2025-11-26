package com.uptodown.tv.ui.activity;

import S1.j;
import W2.J;
import X2.C2250q;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.leanback.app.BackgroundManager;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import b2.C2279K;
import b2.C2290j;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.preferences.a;
import com.uptodown.core.activities.InstallerActivity;
import com.uptodown.tv.preferences.TvPrivacyPreferences;
import g2.C2389k;
import java.io.File;
import java.util.List;
import k2.C2610u;
import kotlin.jvm.internal.t;
import l2.C2657f;
import l2.C2668q;
import t3.s;
import v2.C2802b;
import v2.c;
import v2.d;
import v2.e;
import v2.f;
import v2.g;
import w2.C2843p;
import w2.C2849v;
import z2.C2940B;
import z2.C2954m;
import z2.C2962v;
import z2.F;
import z2.G;

public final class TvMainActivity extends C2802b implements C2610u {

    /* renamed from: b  reason: collision with root package name */
    private AlertDialog f21175b;

    /* renamed from: c  reason: collision with root package name */
    public Fragment f21176c;

    /* renamed from: d  reason: collision with root package name */
    private final ActivityResultLauncher f21177d;

    /* renamed from: e  reason: collision with root package name */
    private final ActivityResultLauncher f21178e;

    public TvMainActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new d(this));
        t.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f21177d = registerForActivityResult;
        ActivityResultLauncher registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new e(this));
        t.d(registerForActivityResult2, "registerForActivityResult(...)");
        this.f21178e = registerForActivityResult2;
    }

    private final boolean B(Intent intent) {
        if ((intent.getFlags() & 1048576) == 1048576) {
            return true;
        }
        return false;
    }

    private final void s(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(str);
        builder.setPositiveButton(17039370, new c());
        builder.setCancelable(true);
        AlertDialog create = builder.create();
        if (!isFinishing()) {
            create.show();
        }
    }

    /* access modifiers changed from: private */
    public static final void t(DialogInterface dialogInterface, int i5) {
        t.e(dialogInterface, "dialogInterface");
        dialogInterface.dismiss();
    }

    private final void u() {
        AlertDialog alertDialog;
        AlertDialog alertDialog2 = this.f21175b;
        if (alertDialog2 != null) {
            alertDialog2.dismiss();
        }
        a.C0147a aVar = a.f15150a;
        if (aVar.W(this) && !aVar.k0(this)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(getString(R.string.tracking_disabled_warning_gdpr));
            builder.setPositiveButton(R.string.gdpr_set_up, new f(this));
            builder.setNegativeButton(17039360, new g());
            builder.setCancelable(true);
            this.f21175b = builder.create();
            if (!isFinishing() && (alertDialog = this.f21175b) != null) {
                alertDialog.show();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void v(TvMainActivity tvMainActivity, DialogInterface dialogInterface, int i5) {
        dialogInterface.dismiss();
        tvMainActivity.f21178e.launch(new Intent(tvMainActivity, TvPrivacyPreferences.class));
    }

    /* access modifiers changed from: private */
    public static final void w(DialogInterface dialogInterface, int i5) {
        t.e(dialogInterface, "dialogInterface");
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    public static final void x(TvMainActivity tvMainActivity, ActivityResult activityResult) {
        if (a.f15150a.k0(tvMainActivity)) {
            UptodownApp.a.O0(UptodownApp.f13477F, tvMainActivity, false, 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void z(TvMainActivity tvMainActivity, ActivityResult activityResult) {
        String str;
        Bundle extras;
        if (activityResult.getResultCode() == 10) {
            Intent data = activityResult.getData();
            String str2 = null;
            if (data == null || (extras = data.getExtras()) == null) {
                str = null;
            } else {
                str = extras.getString("realPath");
            }
            if (str != null && str.length() != 0) {
                boolean A4 = new C2954m().A(tvMainActivity);
                File file = new File(str);
                new j(tvMainActivity).c(file, (String) null, A4);
                C2940B a5 = C2940B.f26458v.a(tvMainActivity);
                a5.a();
                String name = file.getName();
                t.d(name, "getName(...)");
                C2668q f02 = a5.f0(name);
                a5.m();
                Bundle bundle = new Bundle();
                if (f02 != null) {
                    str2 = f02.w();
                }
                if (str2 != null) {
                    G g5 = G.f26487a;
                    String w4 = f02.w();
                    t.b(w4);
                    bundle = g5.b(tvMainActivity, w4, bundle);
                    bundle.putString("packagename", f02.w());
                }
                bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "start");
                F l5 = tvMainActivity.l();
                if (l5 != null) {
                    l5.d("install", bundle);
                }
            }
        }
    }

    public final void A(Fragment fragment) {
        t.e(fragment, "<set-?>");
        this.f21176c = fragment;
    }

    public void c(C2657f fVar) {
        t.e(fVar, "appInfo");
        Intent intent = new Intent(this, TvAppDetailActivity.class);
        intent.putExtra("appInfo", fVar);
        startActivity(intent, UptodownApp.f13477F.a(this));
    }

    public void d(int i5) {
        s(getString(R.string.msg_app_not_found));
    }

    public void onBackPressed() {
        List<Fragment> fragments = getSupportFragmentManager().getFragments();
        t.d(fragments, "getFragments(...)");
        if (C2250q.X(fragments) instanceof C2843p) {
            finish();
        } else {
            super.onBackPressed();
        }
    }

    public void onCreate(Bundle bundle) {
        Uri data;
        super.onCreate(bundle);
        setContentView((int) R.layout.tv_activity_main);
        A(new C2849v());
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, y()).commit();
        if (a.f15150a.k0(this)) {
            UptodownApp.a.O0(UptodownApp.f13477F, this, false, 2, (Object) null);
        }
        BackgroundManager instance = BackgroundManager.getInstance(this);
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.tv_default_background);
        if (instance != null) {
            instance.setDrawable(drawable);
        }
        Intent intent = getIntent();
        if (intent != null && !B(intent) && (data = intent.getData()) != null) {
            String j5 = new C2290j().j(data, this);
            if (j5 == null || (!C2279K.f20490b.a(j5) && !s.D(j5, ".apk", false, 2, (Object) null))) {
                new C2389k(this, new C2962v().m(data), this, LifecycleOwnerKt.getLifecycleScope(this));
                return;
            }
            Intent intent2 = new Intent(getApplicationContext(), InstallerActivity.class);
            intent2.setData(data);
            this.f21177d.launch(intent2);
            J j6 = J.f19942a;
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        u();
    }

    public final Fragment y() {
        Fragment fragment = this.f21176c;
        if (fragment != null) {
            return fragment;
        }
        t.w("tvMainFragment");
        return null;
    }
}
