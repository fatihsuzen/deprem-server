package com.uptodown.activities;

import O1.C0743a7;
import O1.T6;
import O1.U6;
import O1.V6;
import O1.W6;
import O1.X6;
import O1.Y6;
import O1.Z6;
import S1.k;
import W2.C2223l;
import W2.m;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import h2.m1;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.V;

public final class UserEditProfileActivity extends C1598a {

    /* renamed from: N  reason: collision with root package name */
    public static final a f14748N = new a((C2633k) null);

    /* renamed from: K  reason: collision with root package name */
    private final C2223l f14749K = m.b(new T6(this));

    /* renamed from: L  reason: collision with root package name */
    private final ActivityResultLauncher f14750L;

    /* renamed from: M  reason: collision with root package name */
    private final ActivityResultLauncher f14751M;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public UserEditProfileActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new U6(this));
        t.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f14750L = registerForActivityResult;
        ActivityResultLauncher registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new V6(this));
        t.d(registerForActivityResult2, "registerForActivityResult(...)");
        this.f14751M = registerForActivityResult2;
    }

    /* access modifiers changed from: private */
    public static final m1 n3(UserEditProfileActivity userEditProfileActivity) {
        return m1.c(userEditProfileActivity.getLayoutInflater());
    }

    private final m1 o3() {
        return (m1) this.f14749K.getValue();
    }

    private final void p3() {
        setContentView((View) o3().getRoot());
        Drawable drawable = ContextCompat.getDrawable(this, R.drawable.core_vector_back);
        if (drawable != null) {
            o3().f23372f.setNavigationIcon(drawable);
            o3().f23372f.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        o3().f23372f.setNavigationOnClickListener(new W6(this));
        TextView textView = o3().f23376j;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        o3().f23377k.setTypeface(aVar.w());
        o3().f23375i.setTypeface(aVar.w());
        o3().f23373g.setTypeface(aVar.w());
        o3().f23374h.setTypeface(aVar.w());
        o3().f23371e.setOnClickListener(new X6(this));
        o3().f23370d.setOnClickListener(new Y6(this));
        o3().f23368b.setOnClickListener(new Z6(this));
        o3().f23369c.setOnClickListener(new C0743a7(this));
    }

    /* access modifiers changed from: private */
    public static final void q3(UserEditProfileActivity userEditProfileActivity, View view) {
        userEditProfileActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void r3(UserEditProfileActivity userEditProfileActivity, View view) {
        V h5 = V.f24870q.h(userEditProfileActivity);
        if (h5 != null) {
            Intent intent = new Intent(userEditProfileActivity, UsernameEditActivity.class);
            intent.putExtra("user", h5);
            userEditProfileActivity.f14751M.launch(intent, UptodownApp.f13477F.b(userEditProfileActivity));
            return;
        }
        userEditProfileActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void s3(UserEditProfileActivity userEditProfileActivity, View view) {
        if (V.f24870q.h(userEditProfileActivity) != null) {
            userEditProfileActivity.f14750L.launch(new Intent(userEditProfileActivity, PasswordEditActivity.class), UptodownApp.f13477F.b(userEditProfileActivity));
            return;
        }
        userEditProfileActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void t3(UserEditProfileActivity userEditProfileActivity, View view) {
        V h5 = V.f24870q.h(userEditProfileActivity);
        if (h5 != null) {
            Intent intent = new Intent(userEditProfileActivity, UserAvatarActivity.class);
            intent.putExtra("user", h5);
            userEditProfileActivity.f14751M.launch(intent, UptodownApp.f13477F.b(userEditProfileActivity));
            return;
        }
        userEditProfileActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void u3(UserEditProfileActivity userEditProfileActivity, View view) {
        V.f24870q.b(userEditProfileActivity);
        userEditProfileActivity.finish();
    }

    /* access modifiers changed from: private */
    public static final void v3(UserEditProfileActivity userEditProfileActivity, ActivityResult activityResult) {
        if (activityResult.getResultCode() == 2) {
            V.f24870q.b(userEditProfileActivity);
            userEditProfileActivity.setResult(2);
            userEditProfileActivity.finish();
        }
    }

    /* access modifiers changed from: private */
    public static final void w3(UserEditProfileActivity userEditProfileActivity, ActivityResult activityResult) {
        if (activityResult.getResultCode() == 10) {
            userEditProfileActivity.setResult(10);
            userEditProfileActivity.finish();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        p3();
    }
}
