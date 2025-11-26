package com.uptodown.core.activities;

import S1.k;
import T1.C2159b;
import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import b2.C2292l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import w3.C2901v;

public final class ConfirmationIntentWrapperActivity extends AppCompatActivity {

    /* renamed from: c  reason: collision with root package name */
    public static final a f20844c = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private boolean f20845a;

    /* renamed from: b  reason: collision with root package name */
    private final ActivityResultLauncher f20846b;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public ConfirmationIntentWrapperActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C2159b(this));
        t.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f20846b = registerForActivityResult;
    }

    /* access modifiers changed from: private */
    public static final void m(ConfirmationIntentWrapperActivity confirmationIntentWrapperActivity, ActivityResult activityResult) {
        boolean z4;
        PackageInstaller.SessionInfo sessionInfo = confirmationIntentWrapperActivity.getPackageManager().getPackageInstaller().getSessionInfo(k.f32g.n());
        if (sessionInfo == null || ((double) sessionInfo.getProgress()) < 0.81d) {
            z4 = false;
        } else {
            z4 = true;
        }
        C2901v b5 = C2292l.f20704d.b();
        if (b5 != null) {
            b5.v(Boolean.valueOf(z4));
        }
        confirmationIntentWrapperActivity.f20845a = true;
        confirmationIntentWrapperActivity.finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        Parcelable parcelable;
        super.onCreate(bundle);
        Intent intent = getIntent();
        t.d(intent, "getIntent(...)");
        if (Build.VERSION.SDK_INT >= 33) {
            parcelable = (Parcelable) intent.getParcelableExtra("com.uptodown.sapk.confirmation_intent", Intent.class);
        } else {
            parcelable = intent.getParcelableExtra("com.uptodown.sapk.confirmation_intent");
        }
        try {
            this.f20846b.launch((Intent) parcelable);
        } catch (Exception e5) {
            e5.printStackTrace();
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        if (!this.f20845a) {
            k.f32g.e();
        }
        super.onDestroy();
    }
}
