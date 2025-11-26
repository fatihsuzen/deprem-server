package com.uptodown.activities;

import H1.e;
import J1.a;
import O1.C7;
import W2.C2223l;
import W2.m;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import androidx.activity.OnBackPressedCallback;
import androidx.core.view.InputDeviceCompat;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import h2.t1;
import k3.C2616a;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class YouTubeActivity extends C1598a {

    /* renamed from: N  reason: collision with root package name */
    public static final a f14816N = new a((C2633k) null);

    /* renamed from: K  reason: collision with root package name */
    private final C2223l f14817K = m.b(new C7(this));
    /* access modifiers changed from: private */

    /* renamed from: L  reason: collision with root package name */
    public e f14818L;

    /* renamed from: M  reason: collision with root package name */
    private final d f14819M = new d(this);

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public static final class b implements I1.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YouTubeActivity f14820a;

        b(YouTubeActivity youTubeActivity) {
            this.f14820a = youTubeActivity;
        }

        public void a(View view, C2616a aVar) {
            t.e(view, "fullscreenView");
            t.e(aVar, "exitFullscreen");
            this.f14820a.j3().f23563c.setVisibility(8);
            this.f14820a.j3().f23562b.setVisibility(0);
            this.f14820a.j3().f23562b.addView(view);
        }

        public void onExitFullscreen() {
            this.f14820a.j3().f23563c.setVisibility(0);
            this.f14820a.j3().f23562b.setVisibility(8);
            this.f14820a.j3().f23562b.removeAllViews();
        }
    }

    public static final class c extends I1.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YouTubeActivity f14821a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f14822b;

        c(YouTubeActivity youTubeActivity, String str) {
            this.f14821a = youTubeActivity;
            this.f14822b = str;
        }

        public void d(e eVar) {
            t.e(eVar, "youTubePlayer");
            this.f14821a.f14818L = eVar;
            eVar.d(this.f14822b, 0.0f);
        }

        public void g(e eVar, H1.c cVar) {
            t.e(eVar, "youTubePlayer");
            t.e(cVar, CampaignEx.JSON_NATIVE_VIDEO_ERROR);
            super.g(eVar, cVar);
            this.f14821a.finish();
        }
    }

    public static final class d extends OnBackPressedCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ YouTubeActivity f14823a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(YouTubeActivity youTubeActivity) {
            super(true);
            this.f14823a = youTubeActivity;
        }

        public void handleOnBackPressed() {
            this.f14823a.finish();
        }
    }

    /* access modifiers changed from: private */
    public static final t1 i3(YouTubeActivity youTubeActivity) {
        return t1.c(youTubeActivity.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final t1 j3() {
        return (t1) this.f14817K.getValue();
    }

    private final void k3(String str) {
        J1.a c5 = new a.C0046a(this).e(1).f(1).c();
        j3().f23563c.e(new c(this, str), c5);
        j3().f23563c.c(new b(this));
    }

    public final void l3(Window window) {
        t.e(window, "window");
        if (Build.VERSION.SDK_INT >= 30) {
            WindowInsetsController a5 = window.getInsetsController();
            if (a5 != null) {
                a5.hide(WindowInsets.Type.statusBars() | WindowInsets.Type.navigationBars());
                a5.setSystemBarsBehavior(2);
                return;
            }
            return;
        }
        window.getDecorView().setSystemUiVisibility(4);
        window.getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
    }

    public void onCreate(Bundle bundle) {
        String str;
        Bundle extras;
        super.onCreate(bundle);
        setContentView((View) j3().getRoot());
        Window window = getWindow();
        t.d(window, "getWindow(...)");
        l3(window);
        getOnBackPressedDispatcher().addCallback(this, this.f14819M);
        Intent intent = getIntent();
        if (intent == null || (extras = intent.getExtras()) == null || !extras.containsKey("id_youtube")) {
            str = null;
        } else {
            str = extras.getString("id_youtube");
        }
        if (str == null || str.length() == 0) {
            finish();
        } else {
            k3(str);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        j3().f23563c.h();
    }
}
