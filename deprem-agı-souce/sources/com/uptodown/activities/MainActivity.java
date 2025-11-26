package com.uptodown.activities;

import D2.g;
import M1.b;
import O1.A1;
import O1.B1;
import O1.C0737a1;
import O1.C0746b1;
import O1.C0755c1;
import O1.C0764d1;
import O1.C0772e1;
import O1.C0780f1;
import O1.C0788g1;
import O1.C0796h1;
import O1.C0804i1;
import O1.C0812j1;
import O1.C0820k1;
import O1.C0828l1;
import O1.C0836m1;
import O1.C0844n1;
import O1.C0852o1;
import O1.C0860p1;
import O1.C0868q1;
import O1.C0875r1;
import O1.C0883s1;
import O1.C0891t1;
import O1.C0899u1;
import O1.C0907v1;
import O1.C0915w1;
import O1.C0923x1;
import O1.C0931y1;
import O1.C0939z1;
import O1.C1;
import O1.D1;
import O1.E1;
import O1.G1;
import O1.H1;
import O1.I1;
import O1.J1;
import O1.K1;
import O1.L1;
import O1.M1;
import O1.N1;
import O1.O0;
import O1.O1;
import O1.P0;
import O1.Q0;
import O1.Q1;
import O1.R0;
import O1.S0;
import O1.S1;
import O1.T0;
import O1.T1;
import O1.U0;
import O1.U1;
import O1.W0;
import O1.W1;
import O1.X0;
import O1.Y0;
import O1.Z0;
import S1.k;
import X2.C2250q;
import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.SwitchCompat;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;
import b2.C2279K;
import b2.C2290j;
import b2.C2291k;
import b2.C2301u;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.preferences.PreferencesActivity;
import com.uptodown.activities.preferences.a;
import com.uptodown.core.activities.InstallerActivity;
import com.uptodown.gcm.MyFirebaseMessagingService;
import com.uptodown.views.ScrollableTextView;
import com.uptodown.workers.DownloadApkWorker;
import com.uptodown.workers.GetUserDataWorker;
import g2.C2382d;
import g2.C2383e;
import g2.C2388j;
import g2.C2389k;
import g2.C2393o;
import h2.C2404b0;
import h2.C2425m;
import h2.C2427n;
import h2.C2436s;
import h2.C2440u;
import h2.V0;
import h2.b1;
import h2.c1;
import i2.C2497h;
import i2.C2540v1;
import i2.F1;
import i2.P1;
import i2.R1;
import i2.V1;
import i2.f2;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;
import k2.C2606p;
import k2.C2607q;
import k2.C2610u;
import k2.P;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.L;
import l2.C2641A;
import l2.C2647G;
import l2.C2654c;
import l2.C2655d;
import l2.C2657f;
import l2.C2660i;
import l2.C2661j;
import l2.C2666o;
import l2.C2668q;
import l2.N;
import l2.T;
import l2.V;
import l2.c0;
import org.json.JSONObject;
import t3.C2788l;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.I0;
import w3.M;
import w3.O;
import z2.C2939A;
import z2.C2940B;
import z2.C2957p;
import z2.C2962v;
import z2.U;
import z2.Z;

public final class MainActivity extends O0 {

    /* renamed from: I0  reason: collision with root package name */
    public static final C1589b f13976I0 = new C1589b((C2633k) null);

    /* renamed from: A0  reason: collision with root package name */
    private ImageView f13977A0;

    /* renamed from: B0  reason: collision with root package name */
    private final k f13978B0 = new k(this);

    /* renamed from: C0  reason: collision with root package name */
    private final ActivityResultLauncher f13979C0;

    /* renamed from: D0  reason: collision with root package name */
    private final ActivityResultLauncher f13980D0;

    /* renamed from: E0  reason: collision with root package name */
    private final ActivityResultLauncher f13981E0;

    /* renamed from: F0  reason: collision with root package name */
    private final ActivityResultLauncher f13982F0;

    /* renamed from: G0  reason: collision with root package name */
    private final n f13983G0;

    /* renamed from: H0  reason: collision with root package name */
    private final ActivityResultLauncher f13984H0;

    /* renamed from: O  reason: collision with root package name */
    private RelativeLayout f13985O;
    /* access modifiers changed from: private */

    /* renamed from: P  reason: collision with root package name */
    public int f13986P;
    /* access modifiers changed from: private */

    /* renamed from: Q  reason: collision with root package name */
    public ArrayList f13987Q = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: R  reason: collision with root package name */
    public boolean f13988R;
    /* access modifiers changed from: private */

    /* renamed from: S  reason: collision with root package name */
    public RelativeLayout f13989S;

    /* renamed from: T  reason: collision with root package name */
    private Toolbar f13990T;

    /* renamed from: U  reason: collision with root package name */
    private AppBarLayout f13991U;

    /* renamed from: V  reason: collision with root package name */
    private SwitchCompat f13992V;

    /* renamed from: W  reason: collision with root package name */
    private SwitchCompat f13993W;

    /* renamed from: X  reason: collision with root package name */
    private C2657f f13994X;
    /* access modifiers changed from: private */

    /* renamed from: Y  reason: collision with root package name */
    public ViewPager2 f13995Y;

    /* renamed from: Z  reason: collision with root package name */
    private RelativeLayout f13996Z;

    /* renamed from: m0  reason: collision with root package name */
    private RelativeLayout f13997m0;

    /* renamed from: n0  reason: collision with root package name */
    private ProgressBar f13998n0;

    /* renamed from: o0  reason: collision with root package name */
    private TabLayout f13999o0;
    /* access modifiers changed from: private */

    /* renamed from: p0  reason: collision with root package name */
    public R1 f14000p0;
    /* access modifiers changed from: private */

    /* renamed from: q0  reason: collision with root package name */
    public F1 f14001q0;
    /* access modifiers changed from: private */

    /* renamed from: r0  reason: collision with root package name */
    public V1 f14002r0;
    /* access modifiers changed from: private */

    /* renamed from: s0  reason: collision with root package name */
    public P1 f14003s0;
    /* access modifiers changed from: private */

    /* renamed from: t0  reason: collision with root package name */
    public ArrayList f14004t0 = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: u0  reason: collision with root package name */
    public ArrayList f14005u0 = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: v0  reason: collision with root package name */
    public long f14006v0 = -1;
    /* access modifiers changed from: private */

    /* renamed from: w0  reason: collision with root package name */
    public FrameLayout f14007w0;

    /* renamed from: x0  reason: collision with root package name */
    private V0 f14008x0;
    /* access modifiers changed from: private */

    /* renamed from: y0  reason: collision with root package name */
    public FrameLayout f14009y0;

    /* renamed from: z0  reason: collision with root package name */
    private ImageView f14010z0;

    static final class A extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f14011a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MainActivity f14012b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ L f14013c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        A(MainActivity mainActivity, L l5, C2308e eVar) {
            super(2, eVar);
            this.f14012b = mainActivity;
            this.f14013c = l5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new A(this.f14012b, this.f14013c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f14011a == 0) {
                W2.u.b(obj);
                C2940B a5 = C2940B.f26458v.a(this.f14012b);
                a5.a();
                Iterator it = ((ArrayList) this.f14013c.f24690a).iterator();
                kotlin.jvm.internal.t.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    kotlin.jvm.internal.t.d(next, "next(...)");
                    C2668q i02 = a5.i0(UptodownApp.f13477F.a0((C2657f) next, this.f14012b));
                    if (i02 != null) {
                        i02.Y(1);
                        a5.D1(i02);
                    }
                }
                a5.m();
                return W2.J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((A) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    public static final class B implements C2607q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ L f14014a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2427n f14015b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ MainActivity f14016c;

        B(L l5, C2427n nVar, MainActivity mainActivity) {
            this.f14014a = l5;
            this.f14015b = nVar;
            this.f14016c = mainActivity;
        }

        public void a(ArrayList arrayList) {
            kotlin.jvm.internal.t.e(arrayList, "appInfos");
            this.f14014a.f24690a = arrayList;
            Iterator it = arrayList.iterator();
            kotlin.jvm.internal.t.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                kotlin.jvm.internal.t.d(next, "next(...)");
                C2657f fVar = (C2657f) next;
                this.f14015b.f23382d.setVisibility(8);
                C2425m c5 = C2425m.c(this.f14016c.getLayoutInflater());
                kotlin.jvm.internal.t.d(c5, "inflate(...)");
                com.squareup.picasso.s.h().l(fVar.H()).l(R.drawable.shape_bg_placeholder).n(UptodownApp.f13477F.g0(this.f14016c)).i(c5.f23339b);
                c5.f23340c.setTypeface(S1.k.f32g.x());
                c5.f23340c.setText(fVar.N());
                this.f14015b.f23381c.addView(c5.getRoot());
            }
        }
    }

    public static final class C implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ImageView f14017a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Animation f14018b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ImageView f14019c;

        C(ImageView imageView, Animation animation, ImageView imageView2) {
            this.f14017a = imageView;
            this.f14018b = animation;
            this.f14019c = imageView2;
        }

        /* access modifiers changed from: private */
        public static final void b(ImageView imageView, Animation animation, ImageView imageView2, Animation animation2) {
            imageView.startAnimation(animation);
            imageView2.startAnimation(animation2);
        }

        public void onAnimationEnd(Animation animation) {
            new Handler(Looper.getMainLooper()).postDelayed(new W1(this.f14017a, this.f14018b, this.f14019c, animation), 1500);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public static final class D extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MainActivity f14020a;

        D(MainActivity mainActivity) {
            this.f14020a = mainActivity;
        }

        public void onClick(View view) {
            kotlin.jvm.internal.t.e(view, "widget");
        }

        public void updateDrawState(TextPaint textPaint) {
            kotlin.jvm.internal.t.e(textPaint, "ds");
            super.updateDrawState(textPaint);
            textPaint.setColor(ContextCompat.getColor(this.f14020a, R.color.main_blue));
            textPaint.setTypeface(S1.k.f32g.w());
            textPaint.setUnderlineText(false);
        }
    }

    public static final class E extends ClickableSpan {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MainActivity f14021a;

        E(MainActivity mainActivity) {
            this.f14021a = mainActivity;
        }

        public void onClick(View view) {
            kotlin.jvm.internal.t.e(view, "widget");
        }

        public void updateDrawState(TextPaint textPaint) {
            kotlin.jvm.internal.t.e(textPaint, "ds");
            super.updateDrawState(textPaint);
            textPaint.setColor(ContextCompat.getColor(this.f14021a, R.color.turbo_text_featured));
            textPaint.setTypeface(S1.k.f32g.w());
            textPaint.setUnderlineText(false);
        }
    }

    static final class F extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f14022a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MainActivity f14023b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f14024c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        F(MainActivity mainActivity, String str, C2308e eVar) {
            super(2, eVar);
            this.f14023b = mainActivity;
            this.f14024c = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new F(this.f14023b, this.f14024c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f14022a == 0) {
                W2.u.b(obj);
                Fragment O5 = this.f14023b.O5();
                if (O5 instanceof C2540v1) {
                    ((C2540v1) O5).p7(this.f14024c);
                }
                return W2.J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((F) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    static final class G extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f14025a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MainActivity f14026b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f14027c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        G(MainActivity mainActivity, String str, C2308e eVar) {
            super(2, eVar);
            this.f14026b = mainActivity;
            this.f14027c = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new G(this.f14026b, this.f14027c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f14025a == 0) {
                W2.u.b(obj);
                Fragment O5 = this.f14026b.O5();
                if (O5 instanceof C2540v1) {
                    ((C2540v1) O5).q7(this.f14027c);
                }
                return W2.J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((G) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    static final class H extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f14028a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MainActivity f14029b;

        static final class a extends kotlin.coroutines.jvm.internal.l implements k3.p {

            /* renamed from: a  reason: collision with root package name */
            int f14030a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ MainActivity f14031b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ L f14032c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ int f14033d;

            /* renamed from: e  reason: collision with root package name */
            final /* synthetic */ int f14034e;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(MainActivity mainActivity, L l5, int i5, int i6, C2308e eVar) {
                super(2, eVar);
                this.f14031b = mainActivity;
                this.f14032c = l5;
                this.f14033d = i5;
                this.f14034e = i6;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f14031b, this.f14032c, this.f14033d, this.f14034e, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                boolean z4;
                C2316b.f();
                if (this.f14030a == 0) {
                    W2.u.b(obj);
                    MainActivity mainActivity = this.f14031b;
                    Drawable drawable = (Drawable) this.f14032c.f24690a;
                    boolean z5 = false;
                    if (this.f14033d + this.f14034e > 0) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    mainActivity.r7(drawable, z4);
                    P1 N4 = this.f14031b.f14003s0;
                    if (N4 == null) {
                        return null;
                    }
                    Drawable drawable2 = (Drawable) this.f14032c.f24690a;
                    if (this.f14033d + this.f14034e > 0) {
                        z5 = true;
                    }
                    N4.C(drawable2, z5);
                    return W2.J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        H(MainActivity mainActivity, C2308e eVar) {
            super(2, eVar);
            this.f14029b = mainActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new H(this.f14029b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            String c5;
            Object f5 = C2316b.f();
            int i5 = this.f14028a;
            if (i5 == 0) {
                W2.u.b(obj);
                if (this.f14029b.getApplicationContext() != null) {
                    T.b bVar = T.f24856k;
                    Context applicationContext = this.f14029b.getApplicationContext();
                    kotlin.jvm.internal.t.d(applicationContext, "getApplicationContext(...)");
                    int a5 = bVar.a(applicationContext);
                    C2668q.b bVar2 = C2668q.f25155w;
                    Context applicationContext2 = this.f14029b.getApplicationContext();
                    kotlin.jvm.internal.t.d(applicationContext2, "getApplicationContext(...)");
                    int a6 = bVar2.a(applicationContext2);
                    L l5 = new L();
                    l5.f24690a = ContextCompat.getDrawable(this.f14029b, R.drawable.vector_user_profile);
                    V.b bVar3 = V.f24870q;
                    V h5 = bVar3.h(this.f14029b);
                    if (!(h5 == null || (c5 = h5.c()) == null || c5.length() == 0)) {
                        try {
                            Bitmap g5 = com.squareup.picasso.s.h().l(bVar3.d(h5.a())).n(UptodownApp.f13477F.g0(this.f14029b)).g();
                            kotlin.jvm.internal.t.b(g5);
                            Resources resources = this.f14029b.getResources();
                            kotlin.jvm.internal.t.d(resources, "getResources(...)");
                            l5.f24690a = new BitmapDrawable(resources, g5);
                        } catch (IOException unused) {
                        }
                    }
                    I0 c6 = C2865c0.c();
                    a aVar = new a(this.f14029b, l5, a6, a5, (C2308e) null);
                    this.f14028a = 1;
                    if (C2872g.g(c6, aVar, this) == f5) {
                        return f5;
                    }
                }
            } else if (i5 == 1) {
                W2.u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return W2.J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((H) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    static final class I extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f14035a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MainActivity f14036b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        I(MainActivity mainActivity, C2308e eVar) {
            super(2, eVar);
            this.f14036b = mainActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new I(this.f14036b, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0034, code lost:
            if (com.uptodown.activities.MainActivity.t5(r6, r5) == r0) goto L_0x0036;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x0036, code lost:
            return r0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0029, code lost:
            if (w3.X.b(1000, r5) == r0) goto L_0x0036;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = c3.C2316b.f()
                int r1 = r5.f14035a
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L_0x001e
                if (r1 == r3) goto L_0x001a
                if (r1 != r2) goto L_0x0012
                W2.u.b(r6)
                goto L_0x0037
            L_0x0012:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L_0x001a:
                W2.u.b(r6)
                goto L_0x002c
            L_0x001e:
                W2.u.b(r6)
                r5.f14035a = r3
                r3 = 1000(0x3e8, double:4.94E-321)
                java.lang.Object r6 = w3.X.b(r3, r5)
                if (r6 != r0) goto L_0x002c
                goto L_0x0036
            L_0x002c:
                com.uptodown.activities.MainActivity r6 = r5.f14036b
                r5.f14035a = r2
                java.lang.Object r6 = r6.k8(r5)
                if (r6 != r0) goto L_0x0037
            L_0x0036:
                return r0
            L_0x0037:
                W2.J r6 = W2.J.f19942a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MainActivity.I.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((I) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    static final class J extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f14037a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f14038b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ MainActivity f14039c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ C2668q f14040d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        J(int i5, MainActivity mainActivity, C2668q qVar, C2308e eVar) {
            super(2, eVar);
            this.f14038b = i5;
            this.f14039c = mainActivity;
            this.f14040d = qVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new J(this.f14038b, this.f14039c, this.f14040d, eVar);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x009e, code lost:
            if (((i2.C2540v1) r5).a4().e() != r4.f14040d.h()) goto L_0x00a0;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r5) {
            /*
                r4 = this;
                c3.C2316b.f()
                int r0 = r4.f14037a
                if (r0 != 0) goto L_0x00b4
                W2.u.b(r5)
                int r5 = r4.f14038b
                r0 = 202(0xca, float:2.83E-43)
                if (r5 == r0) goto L_0x0014
                r1 = 203(0xcb, float:2.84E-43)
                if (r5 != r1) goto L_0x0019
            L_0x0014:
                com.uptodown.activities.MainActivity r5 = r4.f14039c
                r5.l8()
            L_0x0019:
                com.uptodown.activities.MainActivity r5 = r4.f14039c
                int r1 = r4.f14038b
                l2.q r2 = r4.f14040d
                r5.h8(r1, r2)
                com.uptodown.activities.MainActivity r5 = r4.f14039c
                l2.q r1 = r4.f14040d
                java.lang.String r1 = r1.w()
                r5.n8(r1)
                com.uptodown.activities.MainActivity r5 = r4.f14039c
                l2.q r1 = r4.f14040d
                java.lang.String r1 = r1.w()
                r5.j8(r1)
                com.uptodown.activities.MainActivity r5 = r4.f14039c
                l2.q r1 = r4.f14040d
                java.lang.String r1 = r1.w()
                r5.g8(r1)
                com.uptodown.activities.MainActivity r5 = r4.f14039c
                l2.q r1 = r4.f14040d
                java.lang.String r1 = r1.w()
                r5.d8(r1)
                com.uptodown.activities.MainActivity r5 = r4.f14039c
                D2.g r5 = r5.q2()
                if (r5 == 0) goto L_0x005f
                l2.q r1 = r4.f14040d
                int r2 = r4.f14038b
                com.uptodown.activities.MainActivity r3 = r4.f14039c
                r5.N(r1, r2, r3)
            L_0x005f:
                int r5 = r4.f14038b
                if (r5 != r0) goto L_0x00b1
                com.uptodown.activities.MainActivity r5 = r4.f14039c
                androidx.fragment.app.Fragment r5 = r5.O5()
                boolean r5 = r5 instanceof i2.C2540v1
                if (r5 != 0) goto L_0x0077
                S1.k$a r5 = S1.k.f32g
                android.app.Activity r5 = r5.g()
                boolean r5 = r5 instanceof com.uptodown.activities.MainActivity
                if (r5 != 0) goto L_0x00a0
            L_0x0077:
                com.uptodown.activities.MainActivity r5 = r4.f14039c
                androidx.fragment.app.Fragment r5 = r5.O5()
                boolean r5 = r5 instanceof i2.C2540v1
                if (r5 == 0) goto L_0x00b1
                com.uptodown.activities.MainActivity r5 = r4.f14039c
                androidx.fragment.app.Fragment r5 = r5.O5()
                java.lang.String r0 = "null cannot be cast to non-null type com.uptodown.fragments.AppDetailsFragment"
                kotlin.jvm.internal.t.c(r5, r0)
                i2.v1 r5 = (i2.C2540v1) r5
                l2.f r5 = r5.a4()
                long r0 = r5.e()
                l2.q r5 = r4.f14040d
                long r2 = r5.h()
                int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
                if (r5 == 0) goto L_0x00b1
            L_0x00a0:
                l2.q r5 = r4.f14040d
                boolean r5 = r5.f()
                if (r5 == 0) goto L_0x00b1
                z2.M r5 = z2.M.f26506a
                com.uptodown.activities.MainActivity r0 = r4.f14039c
                l2.q r1 = r4.f14040d
                r5.l(r0, r1)
            L_0x00b1:
                W2.J r5 = W2.J.f19942a
                return r5
            L_0x00b4:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r5.<init>(r0)
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.uptodown.activities.MainActivity.J.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((J) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: com.uptodown.activities.MainActivity$a  reason: case insensitive filesystem */
    public final class C1588a implements Runnable {
        public C1588a() {
        }

        public void run() {
            LinearLayout linearLayout = (LinearLayout) MainActivity.this.findViewById(R.id.ll_auto_update);
            if (linearLayout != null && linearLayout.getVisibility() == 0) {
                MainActivity.this.h7();
            }
        }
    }

    /* renamed from: com.uptodown.activities.MainActivity$b  reason: case insensitive filesystem */
    public static final class C1589b {
        public /* synthetic */ C1589b(C2633k kVar) {
            this();
        }

        private C1589b() {
        }
    }

    /* renamed from: com.uptodown.activities.MainActivity$c  reason: case insensitive filesystem */
    public final class C1590c implements Runnable {
        public C1590c() {
        }

        public void run() {
            MainActivity.this.l7();
        }
    }

    /* renamed from: com.uptodown.activities.MainActivity$d  reason: case insensitive filesystem */
    public final class C1591d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final int f14043a;

        /* renamed from: b  reason: collision with root package name */
        private final String f14044b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ MainActivity f14045c;

        public C1591d(MainActivity mainActivity, int i5, String str) {
            kotlin.jvm.internal.t.e(str, "packagename");
            this.f14045c = mainActivity;
            this.f14043a = i5;
            this.f14044b = str;
        }

        public void run() {
            Fragment O5 = this.f14045c.O5();
            if (O5 instanceof C2540v1) {
                this.f14045c.runOnUiThread(new C2540v1.C2543c((C2540v1) O5, this.f14044b, this.f14043a));
            }
        }
    }

    /* renamed from: com.uptodown.activities.MainActivity$e  reason: case insensitive filesystem */
    public final class C1592e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final int f14046a;

        /* renamed from: b  reason: collision with root package name */
        private final String f14047b;

        public C1592e(int i5, String str) {
            this.f14046a = i5;
            this.f14047b = str;
        }

        public void run() {
            T t5;
            if (this.f14047b != null) {
                C2940B.a aVar = C2940B.f26458v;
                Context baseContext = MainActivity.this.getBaseContext();
                kotlin.jvm.internal.t.d(baseContext, "getBaseContext(...)");
                C2940B a5 = aVar.a(baseContext);
                a5.a();
                t5 = a5.G0(this.f14047b);
                a5.m();
            } else {
                t5 = null;
            }
            MainActivity.this.i8(this.f14046a, t5);
        }
    }

    /* renamed from: com.uptodown.activities.MainActivity$f  reason: case insensitive filesystem */
    public static final class C1593f implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MainActivity f14049a;

        C1593f(MainActivity mainActivity) {
            this.f14049a = mainActivity;
        }

        public void onAnimationEnd(Animation animation) {
            kotlin.jvm.internal.t.e(animation, "animation");
            int J4 = this.f14049a.K5();
            if (J4 < 0 || J4 >= this.f14049a.f13987Q.size()) {
                ((c0) this.f14049a.f13987Q.get(this.f14049a.f13986P)).c().setVisibility(8);
                this.f14049a.finish();
            } else {
                RelativeLayout U4 = this.f14049a.f13989S;
                if (U4 != null) {
                    U4.removeAllViews();
                }
                RelativeLayout c5 = ((c0) this.f14049a.f13987Q.get(J4)).c();
                RelativeLayout U42 = this.f14049a.f13989S;
                if (U42 != null) {
                    U42.addView(c5);
                }
                new D2.n(this.f14049a).h(c5, R.anim.slide_back_in);
            }
            this.f14049a.f13988R = false;
        }

        public void onAnimationRepeat(Animation animation) {
            kotlin.jvm.internal.t.e(animation, "animation");
        }

        public void onAnimationStart(Animation animation) {
            kotlin.jvm.internal.t.e(animation, "animation");
            this.f14049a.f13988R = true;
        }
    }

    /* renamed from: com.uptodown.activities.MainActivity$g  reason: case insensitive filesystem */
    public static final class C1594g implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MainActivity f14050a;

        C1594g(MainActivity mainActivity) {
            this.f14050a = mainActivity;
        }

        public void onAnimationEnd(Animation animation) {
            kotlin.jvm.internal.t.e(animation, "animation");
            int T4 = this.f14050a.P5();
            if (T4 < 0 || T4 >= this.f14050a.f13987Q.size()) {
                this.f14050a.f7();
                return;
            }
            MainActivity mainActivity = this.f14050a;
            Object obj = mainActivity.f13987Q.get(T4);
            kotlin.jvm.internal.t.d(obj, "get(...)");
            mainActivity.s7((c0) obj);
            if (((c0) this.f14050a.f13987Q.get(this.f14050a.f13986P)).a() == 2 && ((c0) this.f14050a.f13987Q.get(0)).a() == 1) {
                ((c0) this.f14050a.f13987Q.get(0)).c().removeAllViews();
                this.f14050a.f13987Q.remove(0);
                this.f14050a.f13986P = 0;
            }
            this.f14050a.p8();
        }

        public void onAnimationRepeat(Animation animation) {
            kotlin.jvm.internal.t.e(animation, "animation");
        }

        public void onAnimationStart(Animation animation) {
            kotlin.jvm.internal.t.e(animation, "animation");
        }
    }

    /* renamed from: com.uptodown.activities.MainActivity$h  reason: case insensitive filesystem */
    static final class C1595h extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f14051a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MainActivity f14052b;

        /* renamed from: com.uptodown.activities.MainActivity$h$a */
        static final class a extends kotlin.coroutines.jvm.internal.l implements k3.p {

            /* renamed from: a  reason: collision with root package name */
            int f14053a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ MainActivity f14054b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ArrayList f14055c;

            /* renamed from: d  reason: collision with root package name */
            final /* synthetic */ ArrayList f14056d;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(MainActivity mainActivity, ArrayList arrayList, ArrayList arrayList2, C2308e eVar) {
                super(2, eVar);
                this.f14054b = mainActivity;
                this.f14055c = arrayList;
                this.f14056d = arrayList2;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f14054b, this.f14055c, this.f14056d, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f14053a == 0) {
                    W2.u.b(obj);
                    this.f14054b.L7(this.f14055c, this.f14056d);
                    return W2.J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1595h(MainActivity mainActivity, C2308e eVar) {
            super(2, eVar);
            this.f14052b = mainActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C1595h(this.f14052b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14051a;
            if (i5 == 0) {
                W2.u.b(obj);
                long w4 = com.uptodown.activities.preferences.a.f15150a.w(this.f14052b);
                long currentTimeMillis = System.currentTimeMillis();
                ArrayList M4 = this.f14052b.M5();
                if (!M4.isEmpty()) {
                    w4 = 0;
                }
                if (w4 + ((long) 86400000) < currentTimeMillis) {
                    ArrayList b5 = T.f24856k.b(this.f14052b);
                    if (!b5.isEmpty() || !M4.isEmpty()) {
                        I0 c5 = C2865c0.c();
                        a aVar = new a(this.f14052b, b5, M4, (C2308e) null);
                        this.f14051a = 1;
                        if (C2872g.g(c5, aVar, this) == f5) {
                            return f5;
                        }
                    }
                }
            } else if (i5 == 1) {
                W2.u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return W2.J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((C1595h) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: com.uptodown.activities.MainActivity$i  reason: case insensitive filesystem */
    public static final class C1596i implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MainActivity f14057a;

        C1596i(MainActivity mainActivity) {
            this.f14057a = mainActivity;
        }

        public void onAnimationEnd(Animation animation) {
            kotlin.jvm.internal.t.e(animation, "animation");
            FrameLayout O4 = this.f14057a.f14007w0;
            kotlin.jvm.internal.t.b(O4);
            O4.removeAllViews();
        }

        public void onAnimationRepeat(Animation animation) {
            kotlin.jvm.internal.t.e(animation, "animation");
        }

        public void onAnimationStart(Animation animation) {
            kotlin.jvm.internal.t.e(animation, "animation");
        }
    }

    /* renamed from: com.uptodown.activities.MainActivity$j  reason: case insensitive filesystem */
    static final class C1597j extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f14058a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MainActivity f14059b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C1597j(MainActivity mainActivity, C2308e eVar) {
            super(2, eVar);
            this.f14059b = mainActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C1597j(this.f14059b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f14058a == 0) {
                W2.u.b(obj);
                ArrayList arrayList = new ArrayList();
                C2940B a5 = C2940B.f26458v.a(this.f14059b);
                a5.a();
                N F02 = a5.F0("categories");
                if (F02 == null || !F02.a()) {
                    l2.M q5 = new Z(this.f14059b).q();
                    if (!q5.b() && q5.d() != null) {
                        C2660i.b bVar = C2660i.f25094i;
                        JSONObject e5 = q5.e();
                        kotlin.jvm.internal.t.b(e5);
                        arrayList = bVar.b(e5);
                        String d5 = q5.d();
                        kotlin.jvm.internal.t.b(d5);
                        N n5 = new N("categories", d5);
                        a5.Q("categories");
                        a5.b1(n5);
                    }
                } else {
                    arrayList = C2660i.f25094i.b(new JSONObject(F02.b()));
                }
                a5.m();
                if (!arrayList.isEmpty()) {
                    this.f14059b.f14005u0.addAll(arrayList);
                }
                return W2.J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((C1597j) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    public static final class k implements C2610u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MainActivity f14060a;

        k(MainActivity mainActivity) {
            this.f14060a = mainActivity;
        }

        public void c(C2657f fVar) {
            kotlin.jvm.internal.t.e(fVar, "appInfo");
            if (this.f14060a.c6()) {
                this.f14060a.e3(fVar);
            }
        }

        public void d(int i5) {
        }
    }

    public static final class l implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MainActivity f14061a;

        l(MainActivity mainActivity) {
            this.f14061a = mainActivity;
        }

        public void onAnimationEnd(Animation animation) {
            kotlin.jvm.internal.t.e(animation, "animation");
            FrameLayout P4 = this.f14061a.f14009y0;
            kotlin.jvm.internal.t.b(P4);
            P4.removeAllViews();
            this.f14061a.f14009y0 = null;
        }

        public void onAnimationRepeat(Animation animation) {
            kotlin.jvm.internal.t.e(animation, "animation");
        }

        public void onAnimationStart(Animation animation) {
            kotlin.jvm.internal.t.e(animation, "animation");
        }
    }

    public static final class m implements b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ RelativeLayout f14062a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ LinearLayout f14063b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ MainActivity f14064c;

        m(RelativeLayout relativeLayout, LinearLayout linearLayout, MainActivity mainActivity) {
            this.f14062a = relativeLayout;
            this.f14063b = linearLayout;
            this.f14064c = mainActivity;
        }

        public void a(Exception exc) {
            int dimension = (int) this.f14064c.getResources().getDimension(R.dimen.margin_l);
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.setMargins(dimension, (int) this.f14064c.getResources().getDimension(R.dimen.margin_xl), dimension, 0);
            this.f14062a.setLayoutParams(layoutParams);
            this.f14062a.setVisibility(0);
            this.f14063b.setVisibility(0);
        }

        public void onSuccess() {
            this.f14062a.setVisibility(0);
            this.f14063b.setVisibility(0);
        }
    }

    public static final class n extends OnBackPressedCallback {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MainActivity f14065a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        n(MainActivity mainActivity) {
            super(true);
            this.f14065a = mainActivity;
        }

        public void handleOnBackPressed() {
            g q22 = this.f14065a.q2();
            if (q22 == null || !q22.l(this.f14065a)) {
                boolean popBackStackImmediate = this.f14065a.getSupportFragmentManager().popBackStackImmediate();
                int backStackEntryCount = this.f14065a.getSupportFragmentManager().getBackStackEntryCount();
                if (!popBackStackImmediate || backStackEntryCount < 0) {
                    RelativeLayout Q5 = this.f14065a.Q5();
                    if (Q5 != null) {
                        Q5.setVisibility(8);
                    }
                    int size = this.f14065a.f14004t0.size();
                    if (size > 0) {
                        Fragment fragment = (Fragment) C2250q.X(this.f14065a.f14004t0);
                        this.f14065a.f14004t0.remove(size - 1);
                        if (fragment instanceof R1) {
                            R1 r12 = (R1) fragment;
                            if (r12.p() != null) {
                                C2660i p5 = r12.p();
                                kotlin.jvm.internal.t.b(p5);
                                if (p5.c() == 523) {
                                    this.f14065a.z5(1);
                                    return;
                                }
                            }
                            this.f14065a.z5(0);
                        } else if (!this.f14065a.c6()) {
                            this.f14065a.finish();
                        } else {
                            if (this.f14065a.f13989S != null) {
                                RelativeLayout U4 = this.f14065a.f13989S;
                                kotlin.jvm.internal.t.b(U4);
                                if (U4.getVisibility() == 0) {
                                    this.f14065a.w5();
                                    return;
                                }
                            }
                            ViewPager2 V4 = this.f14065a.f13995Y;
                            if (V4 == null || V4.getCurrentItem() != 0) {
                                this.f14065a.z5(0);
                            } else {
                                this.f14065a.finish();
                            }
                        }
                    } else if (!this.f14065a.c6()) {
                        this.f14065a.finish();
                    } else {
                        if (this.f14065a.f13989S != null) {
                            RelativeLayout U42 = this.f14065a.f13989S;
                            kotlin.jvm.internal.t.b(U42);
                            if (U42.getVisibility() == 0) {
                                this.f14065a.w5();
                                return;
                            }
                        }
                        ViewPager2 V42 = this.f14065a.f13995Y;
                        if (V42 == null || V42.getCurrentItem() != 0) {
                            this.f14065a.z5(0);
                        } else {
                            this.f14065a.finish();
                        }
                    }
                } else if (this.f14065a.O5() instanceof C2540v1) {
                    RelativeLayout Q52 = this.f14065a.Q5();
                    if (Q52 != null) {
                        Q52.setVisibility(0);
                    }
                    Fragment O5 = this.f14065a.O5();
                    kotlin.jvm.internal.t.c(O5, "null cannot be cast to non-null type com.uptodown.fragments.AppDetailsFragment");
                    ((C2540v1) O5).T2(this.f14065a);
                } else {
                    RelativeLayout Q53 = this.f14065a.Q5();
                    if (Q53 != null) {
                        Q53.setVisibility(8);
                    }
                    if (this.f14065a.O5() == null || (this.f14065a.O5() instanceof V1) || (this.f14065a.O5() instanceof R1) || (this.f14065a.O5() instanceof F1)) {
                        this.f14065a.T7();
                    }
                }
            }
        }
    }

    static final class o extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f14066a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MainActivity f14067b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(MainActivity mainActivity, C2308e eVar) {
            super(2, eVar);
            this.f14067b = mainActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new o(this.f14067b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14066a;
            if (i5 == 0) {
                W2.u.b(obj);
                MainActivity mainActivity = this.f14067b;
                this.f14066a = 1;
                if (mainActivity.L5(this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                W2.u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return W2.J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((o) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    public static final class p implements C2606p {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MainActivity f14068a;

        p(MainActivity mainActivity) {
            this.f14068a = mainActivity;
        }

        public void a(long j5, long j6, String str, long j7, boolean z4) {
            long j8 = j6;
            long j9 = j5;
            MainActivity mainActivity = this.f14068a;
            mainActivity.S6(j9, j8, str, j7);
        }

        public void b() {
            MainActivity mainActivity = this.f14068a;
            String string = mainActivity.getString(R.string.app_detail_not_available);
            kotlin.jvm.internal.t.d(string, "getString(...)");
            mainActivity.u0(string);
        }
    }

    static final class q extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f14069a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MainActivity f14070b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ r f14071c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        q(MainActivity mainActivity, r rVar, C2308e eVar) {
            super(2, eVar);
            this.f14070b = mainActivity;
            this.f14071c = rVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new q(this.f14070b, this.f14071c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14069a;
            if (i5 == 0) {
                W2.u.b(obj);
                GetUserDataWorker.a aVar = GetUserDataWorker.f21373b;
                MainActivity mainActivity = this.f14070b;
                r rVar = this.f14071c;
                this.f14069a = 1;
                if (aVar.a(mainActivity, rVar, this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                W2.u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return W2.J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((q) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    public static final class r implements P {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MainActivity f14072a;

        r(MainActivity mainActivity) {
            this.f14072a = mainActivity;
        }

        public void a() {
            this.f14072a.l8();
            this.f14072a.Z7();
        }
    }

    public static final class s implements C2610u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MainActivity f14073a;

        s(MainActivity mainActivity) {
            this.f14073a = mainActivity;
        }

        public void c(C2657f fVar) {
            kotlin.jvm.internal.t.e(fVar, "appInfo");
            this.f14073a.e3(fVar);
            this.f14073a.f14006v0 = -1;
        }

        public void d(int i5) {
            this.f14073a.f14006v0 = -1;
            MainActivity mainActivity = this.f14073a;
            String string = mainActivity.getString(R.string.app_detail_not_found);
            kotlin.jvm.internal.t.d(string, "getString(...)");
            mainActivity.u0(string);
        }
    }

    public static final class t implements C2610u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f14074a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ long f14075b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f14076c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ MainActivity f14077d;

        t(long j5, long j6, String str, MainActivity mainActivity) {
            this.f14074a = j5;
            this.f14075b = j6;
            this.f14076c = str;
            this.f14077d = mainActivity;
        }

        public void c(C2657f fVar) {
            kotlin.jvm.internal.t.e(fVar, "appInfo");
            if (fVar.J0() && fVar.G0()) {
                C2668q qVar = new C2668q();
                qVar.V(fVar.e());
                qVar.W(fVar.N());
                fVar.S0(this.f14074a);
                qVar.h0(this.f14075b);
                fVar.a1(this.f14076c);
                qVar.e0(fVar.S());
                qVar.g0(fVar.E());
                l2.r rVar = new l2.r();
                rVar.m(this.f14074a);
                rVar.n(this.f14076c);
                rVar.q(0);
                qVar.o().add(rVar);
                DownloadApkWorker.f21342i.b(this.f14077d, qVar.S(this.f14077d));
                this.f14077d.e3(fVar);
            }
            this.f14077d.f14006v0 = -1;
        }

        public void d(int i5) {
            this.f14077d.f14006v0 = -1;
            MainActivity mainActivity = this.f14077d;
            String string = mainActivity.getString(R.string.app_detail_not_available);
            kotlin.jvm.internal.t.d(string, "getString(...)");
            mainActivity.u0(string);
        }
    }

    static final class u extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f14078a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MainActivity f14079b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        u(MainActivity mainActivity, C2308e eVar) {
            super(2, eVar);
            this.f14079b = mainActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new u(this.f14079b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f14078a == 0) {
                W2.u.b(obj);
                Fragment O5 = this.f14079b.O5();
                if (O5 instanceof C2540v1) {
                    ((C2540v1) O5).h6();
                }
                return W2.J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((u) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    public static final class v implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MainActivity f14080a;

        v(MainActivity mainActivity) {
            this.f14080a = mainActivity;
        }

        public void onAnimationEnd(Animation animation) {
            kotlin.jvm.internal.t.e(animation, "animation");
            this.f14080a.T5();
            this.f14080a.c7();
        }

        public void onAnimationRepeat(Animation animation) {
            kotlin.jvm.internal.t.e(animation, "animation");
        }

        public void onAnimationStart(Animation animation) {
            kotlin.jvm.internal.t.e(animation, "animation");
        }
    }

    static final class w extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f14081a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MainActivity f14082b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        w(MainActivity mainActivity, C2308e eVar) {
            super(2, eVar);
            this.f14082b = mainActivity;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new w(this.f14082b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f14081a;
            if (i5 == 0) {
                W2.u.b(obj);
                MainActivity mainActivity = this.f14082b;
                this.f14081a = 1;
                if (mainActivity.L5(this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                W2.u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return W2.J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((w) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    public static final class x implements TabLayout.OnTabSelectedListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MainActivity f14083a;

        x(MainActivity mainActivity) {
            this.f14083a = mainActivity;
        }

        public void onTabReselected(TabLayout.Tab tab) {
            P1 N4;
            kotlin.jvm.internal.t.e(tab, "tab");
            int position = tab.getPosition();
            if (position == 0) {
                this.f14083a.T7();
                V1 S4 = this.f14083a.f14002r0;
                if (S4 != null) {
                    S4.G();
                }
            } else if (position == 1) {
                this.f14083a.T7();
                R1 R4 = this.f14083a.f14000p0;
                if (R4 != null) {
                    R4.C();
                }
            } else if (position == 2) {
                this.f14083a.T7();
                if (this.f14083a.getSupportFragmentManager().getBackStackEntryCount() > 0) {
                    this.f14083a.getSupportFragmentManager().popBackStackImmediate("appsCategory", 1);
                    return;
                }
                F1 I4 = this.f14083a.f14001q0;
                if (I4 != null) {
                    I4.C();
                }
            } else if (position == 3 && (N4 = this.f14083a.f14003s0) != null) {
                N4.B();
            }
        }

        public void onTabSelected(TabLayout.Tab tab) {
            kotlin.jvm.internal.t.e(tab, "tab");
            ViewPager2 V4 = this.f14083a.f13995Y;
            kotlin.jvm.internal.t.b(V4);
            V4.setCurrentItem(tab.getPosition(), false);
            this.f14083a.b7();
            this.f14083a.T7();
            int position = tab.getPosition();
            if (position == 0) {
                this.f14083a.I6("home");
            } else if (position == 1) {
                this.f14083a.I6("games");
            } else if (position == 2) {
                this.f14083a.I6("apps");
            } else if (position == 3) {
                this.f14083a.U5();
                this.f14083a.I6("feed");
            }
        }

        public void onTabUnselected(TabLayout.Tab tab) {
            kotlin.jvm.internal.t.e(tab, "tab");
        }
    }

    public static final class y extends FragmentStateAdapter {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ MainActivity f14084a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        y(MainActivity mainActivity, FragmentManager fragmentManager, Lifecycle lifecycle) {
            super(fragmentManager, lifecycle);
            this.f14084a = mainActivity;
        }

        public Fragment createFragment(int i5) {
            if (i5 == 0) {
                this.f14084a.f14002r0 = new V1();
                V1 S4 = this.f14084a.f14002r0;
                kotlin.jvm.internal.t.b(S4);
                return S4;
            } else if (i5 == 1) {
                C2660i iVar = new C2660i(0, (String) null, (String) null, 7, (C2633k) null);
                iVar.w(523);
                iVar.x(this.f14084a.getString(R.string.top_games_title));
                this.f14084a.f14000p0 = R1.f24055n.a(iVar);
                R1 R4 = this.f14084a.f14000p0;
                kotlin.jvm.internal.t.b(R4);
                return R4;
            } else if (i5 != 2) {
                this.f14084a.f14003s0 = new P1();
                P1 N4 = this.f14084a.f14003s0;
                kotlin.jvm.internal.t.b(N4);
                return N4;
            } else {
                C2660i iVar2 = new C2660i(0, (String) null, (String) null, 7, (C2633k) null);
                iVar2.w(831);
                iVar2.x(this.f14084a.getString(R.string.apps));
                this.f14084a.f14001q0 = F1.f23968n.a(iVar2);
                F1 I4 = this.f14084a.f14001q0;
                kotlin.jvm.internal.t.b(I4);
                return I4;
            }
        }

        public int getItemCount() {
            return 4;
        }
    }

    public static final class z implements C2610u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TextView f14085a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MainActivity f14086b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ T f14087c;

        z(TextView textView, MainActivity mainActivity, T t5) {
            this.f14085a = textView;
            this.f14086b = mainActivity;
            this.f14087c = t5;
        }

        public void c(C2657f fVar) {
            kotlin.jvm.internal.t.e(fVar, "appInfo");
            String O4 = fVar.O();
            if (O4 == null || O4.length() == 0) {
                this.f14085a.setText(this.f14086b.getResources().getString(R.string.msg_no_version_details, new Object[]{this.f14086b.getResources().getString(R.string.app_name) + " v." + this.f14087c.k()}));
                return;
            }
            this.f14085a.setText(fVar.O());
        }

        public void d(int i5) {
            this.f14085a.setText(this.f14086b.getResources().getString(R.string.msg_no_version_details, new Object[]{this.f14086b.getResources().getString(R.string.app_name) + " v." + this.f14087c.k()}));
        }
    }

    public MainActivity() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C0788g1(this));
        kotlin.jvm.internal.t.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f13979C0 = registerForActivityResult;
        ActivityResultLauncher registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C0796h1(this));
        kotlin.jvm.internal.t.d(registerForActivityResult2, "registerForActivityResult(...)");
        this.f13980D0 = registerForActivityResult2;
        ActivityResultLauncher registerForActivityResult3 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C0804i1(this));
        kotlin.jvm.internal.t.d(registerForActivityResult3, "registerForActivityResult(...)");
        this.f13981E0 = registerForActivityResult3;
        ActivityResultLauncher registerForActivityResult4 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C0812j1(this));
        kotlin.jvm.internal.t.d(registerForActivityResult4, "registerForActivityResult(...)");
        this.f13982F0 = registerForActivityResult4;
        this.f13983G0 = new n(this);
        ActivityResultLauncher registerForActivityResult5 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C0820k1(this));
        kotlin.jvm.internal.t.d(registerForActivityResult5, "registerForActivityResult(...)");
        this.f13984H0 = registerForActivityResult5;
    }

    private final void A5() {
        long currentTimeMillis = System.currentTimeMillis();
        a.C0147a aVar = a.f15150a;
        if (currentTimeMillis - aVar.E(this) >= TimeUnit.DAYS.toMillis(7)) {
            aVar.d1(this, System.currentTimeMillis());
            if (Build.VERSION.SDK_INT >= 33) {
                if (!e6()) {
                    F5();
                    return;
                }
            } else if (!aVar.a0(this)) {
                F5();
                return;
            }
        }
        P7();
    }

    /* access modifiers changed from: private */
    public static final void A6(MainActivity mainActivity, View view) {
        mainActivity.w5();
    }

    /* access modifiers changed from: private */
    public static final void A7(MainActivity mainActivity, L l5, View view) {
        C2876i.d(LifecycleOwnerKt.getLifecycleScope(mainActivity), C2865c0.b(), (O) null, new A(mainActivity, l5, (C2308e) null), 2, (Object) null).s(new I1(mainActivity));
        AlertDialog p22 = mainActivity.p2();
        if (p22 != null) {
            p22.dismiss();
        }
    }

    private final void B5() {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.b(), (O) null, new C1595h(this, (C2308e) null), 2, (Object) null);
    }

    private final void B6() {
        v6();
        q6();
    }

    /* access modifiers changed from: private */
    public static final W2.J B7(MainActivity mainActivity, Throwable th) {
        mainActivity.W6();
        return W2.J.f19942a;
    }

    private final void C5() {
        if (!z2.M.f26506a.a(this)) {
            C2940B a5 = C2940B.f26458v.a(this);
            a5.a();
            U2(a5.B0());
            a5.m();
            int i5 = 0;
            while (t2().size() > 0 && i5 < 2) {
                Object remove = t2().remove(0);
                kotlin.jvm.internal.t.d(remove, "removeAt(...)");
                M2((C2647G) remove);
                i5++;
            }
        }
    }

    private final void C6() {
        v5(D6(), 1);
    }

    private final void D5() {
        V h5 = V.f24870q.h(this);
        if ((h5 == null || !h5.q()) && a.f15150a.J(this) == 0) {
            U7();
            return;
        }
        A5();
        C5();
    }

    private final RelativeLayout D6() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.wizard_welcome, this.f13989S, false);
        kotlin.jvm.internal.t.c(inflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout = (RelativeLayout) inflate;
        k.a aVar = S1.k.f32g;
        ((TextView) relativeLayout.findViewById(R.id.tv_welcome_to_wizard_welcome)).setTypeface(aVar.x());
        ((TextView) relativeLayout.findViewById(R.id.tv_app_name_wizard_welcome)).setTypeface(aVar.w());
        ((TextView) relativeLayout.findViewById(R.id.tv_slogan_to_wizard_welcome)).setTypeface(aVar.x());
        ((TextView) relativeLayout.findViewById(R.id.tv_terms_wizard_welcome)).setTypeface(aVar.w());
        ((RelativeLayout) relativeLayout.findViewById(R.id.rl_terms_wizard_welcome)).setOnClickListener(new B1(this));
        ((TextView) relativeLayout.findViewById(R.id.tv_privacy_settings_wizard_welcome)).setTypeface(aVar.w());
        ((RelativeLayout) relativeLayout.findViewById(R.id.rl_privacy_settings_wizard_welcome)).setOnClickListener(new C1(this));
        TextView textView = (TextView) relativeLayout.findViewById(R.id.tv_accept_wizard_welcome);
        textView.setTypeface(aVar.w());
        textView.setEnabled(false);
        textView.setOnClickListener(new D1(this));
        ProgressBar progressBar = (ProgressBar) relativeLayout.findViewById(R.id.pb_wizard_deep_link);
        if (r2()) {
            textView.setBackground(ContextCompat.getDrawable(this, R.drawable.selector_wizard_accept_button));
            textView.setEnabled(true);
            progressBar.setVisibility(8);
            return relativeLayout;
        }
        progressBar.setVisibility(0);
        return relativeLayout;
    }

    /* access modifiers changed from: private */
    public static final void D7(MainActivity mainActivity, View view) {
        mainActivity.W6();
    }

    private final void E5() {
        FrameLayout frameLayout = this.f14007w0;
        if (frameLayout != null) {
            kotlin.jvm.internal.t.b(frameLayout);
            if (frameLayout.getChildCount() != 0 && this.f14008x0 != null) {
                D2.n nVar = new D2.n(this);
                V0 v02 = this.f14008x0;
                kotlin.jvm.internal.t.b(v02);
                RelativeLayout b5 = v02.getRoot();
                kotlin.jvm.internal.t.d(b5, "getRoot(...)");
                nVar.g(b5, R.anim.slide_out_bottom, new C1596i(this));
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void E6(MainActivity mainActivity, View view) {
        mainActivity.X6();
    }

    /* access modifiers changed from: private */
    public static final void E7(MainActivity mainActivity, View view) {
        mainActivity.Y6();
    }

    private final void F5() {
        if (!isFinishing()) {
            AlertDialog p22 = p2();
            if (p22 != null) {
                p22.dismiss();
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            C2436s c5 = C2436s.c(getLayoutInflater());
            kotlin.jvm.internal.t.d(c5, "inflate(...)");
            TextView textView = c5.f23528d;
            k.a aVar = S1.k.f32g;
            textView.setTypeface(aVar.x());
            c5.f23528d.setText(getString(R.string.notification_permission_request));
            c5.f23529e.setTypeface(aVar.w());
            c5.f23529e.setOnClickListener(new C0737a1(this));
            c5.f23527c.setTypeface(aVar.w());
            c5.f23527c.setOnClickListener(new C0828l1(this));
            builder.setView(c5.getRoot());
            builder.setCancelable(true);
            P2(builder.create());
            if (!isFinishing() && p2() != null) {
                AlertDialog p23 = p2();
                kotlin.jvm.internal.t.b(p23);
                Window window = p23.getWindow();
                if (window != null) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                }
                AlertDialog p24 = p2();
                kotlin.jvm.internal.t.b(p24);
                p24.show();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void F6(MainActivity mainActivity, View view) {
        mainActivity.T6();
    }

    /* access modifiers changed from: private */
    public static final void F7(MainActivity mainActivity, View view) {
        mainActivity.l7();
    }

    private final void G4() {
        a.C0147a aVar = a.f15150a;
        if (!aVar.V(this)) {
            aVar.H0(this, true);
            aVar.r0(this, true);
            aVar.w0(this, true);
            aVar.o1(this, true);
            UptodownApp.a aVar2 = UptodownApp.f13477F;
            UptodownApp.a.O0(aVar2, this, false, 2, (Object) null);
            aVar2.I(this);
            T2(new z2.F(this));
            z2.F s22 = s2();
            if (s22 != null) {
                s22.b();
            }
        }
        Q2();
        if (!aVar.k0(this)) {
            new C2962v().e(p2(), this);
        } else {
            x5();
        }
    }

    /* access modifiers changed from: private */
    public static final void G5(MainActivity mainActivity, View view) {
        AlertDialog p22 = mainActivity.p2();
        kotlin.jvm.internal.t.b(p22);
        p22.dismiss();
        if (Build.VERSION.SDK_INT >= 33) {
            mainActivity.m0();
        }
        a.f15150a.c1(mainActivity, true);
    }

    /* access modifiers changed from: private */
    public static final void G6(MainActivity mainActivity, View view) {
        mainActivity.G4();
    }

    /* access modifiers changed from: private */
    public static final void G7(View view) {
    }

    /* access modifiers changed from: private */
    public static final void H5(MainActivity mainActivity, View view) {
        AlertDialog p22 = mainActivity.p2();
        kotlin.jvm.internal.t.b(p22);
        p22.dismiss();
    }

    private final void H6(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, str);
        z2.F s22 = s2();
        if (s22 != null) {
            s22.d("wizard", bundle);
        }
    }

    /* access modifiers changed from: private */
    public static final void H7(MainActivity mainActivity, View view) {
        mainActivity.Z6();
    }

    /* access modifiers changed from: private */
    public final void I6(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, str);
        z2.F s22 = s2();
        if (s22 != null) {
            s22.d("tab_clicked", bundle);
        }
    }

    /* access modifiers changed from: private */
    public static final void I7(MainActivity mainActivity, View view) {
        mainActivity.V6();
    }

    /* access modifiers changed from: private */
    public static final void J5(MainActivity mainActivity, ActivityResult activityResult) {
        if (activityResult.getResultCode() == -1) {
            mainActivity.Q2();
        }
    }

    /* access modifiers changed from: private */
    public static final void J6(MainActivity mainActivity, ActivityResult activityResult) {
        int i5;
        int resultCode = activityResult.getResultCode();
        if (resultCode == -1) {
            mainActivity.m8();
            P1 p12 = mainActivity.f14003s0;
            if (p12 != null) {
                p12.r();
            }
        } else if (resultCode == 1) {
            if (mainActivity.o3() != null && mainActivity.f13989S != null && mainActivity.f13987Q.size() > (i5 = mainActivity.f13986P) && ((c0) mainActivity.f13987Q.get(i5)).a() == 5) {
                mainActivity.x5();
            }
            mainActivity.m8();
        }
    }

    /* access modifiers changed from: private */
    public static final void J7(View view) {
    }

    /* access modifiers changed from: private */
    public final int K5() {
        int i5 = this.f13986P;
        if (i5 <= 0 || i5 >= this.f13987Q.size()) {
            return -1;
        }
        int i6 = this.f13986P - 1;
        this.f13986P = i6;
        return i6;
    }

    /* access modifiers changed from: private */
    public static final void K6(View view) {
    }

    /* access modifiers changed from: private */
    public static final void K7(MainActivity mainActivity, View view) {
        mainActivity.f7();
    }

    /* access modifiers changed from: private */
    public final Object L5(C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new C1597j(this, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return W2.J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final void L6(MainActivity mainActivity, View view) {
        if (UptodownApp.f13477F.Z()) {
            mainActivity.z5(0);
            V1 v12 = mainActivity.f14002r0;
            if (v12 != null) {
                v12.G();
            }
            R1 r12 = mainActivity.f14000p0;
            if (r12 != null) {
                r12.C();
            }
            F1 f12 = mainActivity.f14001q0;
            if (f12 != null) {
                f12.C();
            }
            P1 p12 = mainActivity.f14003s0;
            if (p12 != null) {
                p12.B();
            }
        }
    }

    /* access modifiers changed from: private */
    public final void L7(ArrayList arrayList, ArrayList arrayList2) {
        int i5;
        if (!isFinishing() && !w2()) {
            AlertDialog p22 = p2();
            if (p22 != null) {
                p22.dismiss();
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            C2440u c5 = C2440u.c(getLayoutInflater());
            kotlin.jvm.internal.t.d(c5, "inflate(...)");
            TextView textView = c5.f23573j;
            k.a aVar = S1.k.f32g;
            textView.setTypeface(aVar.w());
            if (!arrayList.isEmpty()) {
                c5.f23569f.setVisibility(0);
                c5.f23574k.setTypeface(aVar.x());
                c5.f23572i.setTypeface(aVar.w());
                i5 = 0;
                for (T e7 : C2250q.i0(arrayList, 4)) {
                    C2404b0 c6 = C2404b0.c(getLayoutInflater());
                    kotlin.jvm.internal.t.d(c6, "inflate(...)");
                    e7(c6, e7);
                    c5.f23568e.addView(c6.getRoot());
                    i5++;
                }
                c5.f23572i.setOnClickListener(new C0746b1(this));
            } else {
                i5 = 0;
            }
            if (!arrayList2.isEmpty()) {
                c5.f23567d.setVisibility(0);
                TextView textView2 = c5.f23570g;
                k.a aVar2 = S1.k.f32g;
                textView2.setTypeface(aVar2.x());
                c5.f23571h.setTypeface(aVar2.w());
                for (C2668q d7 : C2250q.i0(arrayList2, 6 - i5)) {
                    C2404b0 c7 = C2404b0.c(getLayoutInflater());
                    kotlin.jvm.internal.t.d(c7, "inflate(...)");
                    d7(c7, d7);
                    c5.f23566c.addView(c7.getRoot());
                }
                c5.f23571h.setOnClickListener(new C0755c1(this));
            }
            c5.f23565b.setOnClickListener(new C0764d1(this));
            builder.setView(c5.getRoot());
            builder.setCancelable(true);
            P2(builder.create());
            if (!isFinishing() && p2() != null) {
                AlertDialog p23 = p2();
                kotlin.jvm.internal.t.b(p23);
                Window window = p23.getWindow();
                if (window != null) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                }
                AlertDialog p24 = p2();
                kotlin.jvm.internal.t.b(p24);
                p24.show();
                a.f15150a.W0(this, System.currentTimeMillis());
            }
        }
    }

    /* access modifiers changed from: private */
    public final ArrayList M5() {
        C2940B a5 = C2940B.f26458v.a(this);
        a5.a();
        ArrayList p02 = a5.p0();
        a5.m();
        ArrayList arrayList = new ArrayList();
        Iterator it = p02.iterator();
        kotlin.jvm.internal.t.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            kotlin.jvm.internal.t.d(next, "next(...)");
            C2668q qVar = (C2668q) next;
            if (qVar.P() && qVar.k() == 0 && qVar.f()) {
                arrayList.add(qVar);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static final void M6(MainActivity mainActivity, View view) {
        mainActivity.startActivity(new Intent(mainActivity, SearchActivity.class), UptodownApp.f13477F.a(mainActivity));
        mainActivity.X5();
    }

    /* access modifiers changed from: private */
    public static final void M7(MainActivity mainActivity, View view) {
        AlertDialog p22 = mainActivity.p2();
        if (p22 != null) {
            p22.dismiss();
        }
        mainActivity.q7();
        mainActivity.startActivity(new Intent(mainActivity, Updates.class), UptodownApp.f13477F.a(mainActivity));
    }

    /* access modifiers changed from: private */
    public static final void N6(MainActivity mainActivity, View view) {
        if (UptodownApp.f13477F.Z()) {
            mainActivity.d3();
        }
    }

    /* access modifiers changed from: private */
    public static final void N7(MainActivity mainActivity, View view) {
        AlertDialog p22 = mainActivity.p2();
        if (p22 != null) {
            p22.dismiss();
        }
        mainActivity.q7();
        mainActivity.startActivity(new Intent(mainActivity, MyDownloads.class), UptodownApp.f13477F.a(mainActivity));
    }

    /* access modifiers changed from: private */
    public static final void O6(MainActivity mainActivity) {
        new Handler(Looper.getMainLooper()).postDelayed(new E1(mainActivity), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
    }

    /* access modifiers changed from: private */
    public static final void O7(MainActivity mainActivity, View view) {
        AlertDialog p22 = mainActivity.p2();
        if (p22 != null) {
            p22.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public final int P5() {
        int i5 = this.f13986P;
        if (i5 < 0 || i5 >= this.f13987Q.size() - 1) {
            return -1;
        }
        int i6 = this.f13986P + 1;
        this.f13986P = i6;
        return i6;
    }

    /* access modifiers changed from: private */
    public static final void P6(MainActivity mainActivity) {
        ProgressBar progressBar = (ProgressBar) mainActivity.findViewById(R.id.pb_splash);
        if (progressBar != null) {
            progressBar.setVisibility(0);
        }
    }

    private final boolean P7() {
        boolean z4;
        FrameLayout frameLayout;
        V h5 = V.f24870q.h(this);
        if (System.currentTimeMillis() - a.f15150a.F(this) >= TimeUnit.DAYS.toMillis(14)) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (h5 != null || !z4 || (frameLayout = this.f14007w0) == null) {
            return false;
        }
        kotlin.jvm.internal.t.b(frameLayout);
        frameLayout.removeAllViews();
        V0 c5 = V0.c(getLayoutInflater());
        this.f14008x0 = c5;
        kotlin.jvm.internal.t.b(c5);
        TextView textView = c5.f22668h;
        k.a aVar = S1.k.f32g;
        textView.setTypeface(aVar.x());
        c5.f22666f.setTypeface(aVar.x());
        c5.f22667g.setTypeface(aVar.w());
        c5.f22665e.setTypeface(aVar.w());
        String string = getString(R.string.reminder_login_msg_1);
        kotlin.jvm.internal.t.d(string, "getString(...)");
        List<C2666o> e5 = C2666o.f25106g.e(string, "\\[xx](.*?)\\[/xx]");
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(new t3.p("\\[xx](.*?)\\[/xx]").i(string, new C0923x1()));
        for (C2666o oVar : e5) {
            int f02 = t3.s.f0(spannableStringBuilder, oVar.d(), 0, false, 6, (Object) null);
            int length = oVar.d().length() + f02;
            if (f02 >= 0) {
                spannableStringBuilder.setSpan(new D(this), f02, length, 33);
            }
        }
        c5.f22666f.setText(spannableStringBuilder);
        c5.f22665e.setOnClickListener(new C0931y1(this));
        c5.f22663c.setOnClickListener(new C0939z1(this));
        FrameLayout frameLayout2 = this.f14007w0;
        kotlin.jvm.internal.t.b(frameLayout2);
        V0 v02 = this.f14008x0;
        kotlin.jvm.internal.t.b(v02);
        frameLayout2.addView(v02.getRoot());
        D2.n nVar = new D2.n(this);
        V0 v03 = this.f14008x0;
        kotlin.jvm.internal.t.b(v03);
        RelativeLayout b5 = v03.getRoot();
        kotlin.jvm.internal.t.d(b5, "getRoot(...)");
        nVar.h(b5, R.anim.slide_in_bottom);
        a.f15150a.l1(this, System.currentTimeMillis());
        return true;
    }

    /* access modifiers changed from: private */
    public static final void Q6(MainActivity mainActivity, ActivityResult activityResult) {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(mainActivity), C2865c0.b(), (O) null, new q(mainActivity, new r(mainActivity), (C2308e) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final CharSequence Q7(C2788l lVar) {
        kotlin.jvm.internal.t.e(lVar, "it");
        return (CharSequence) lVar.a().get(1);
    }

    private final Bitmap R5(Bitmap bitmap, int i5) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, bitmap.getWidth(), bitmap.getHeight());
        RectF rectF = new RectF(rect);
        float f5 = (float) i5;
        paint.setAntiAlias(true);
        canvas.drawRoundRect(rectF, f5, f5, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, rect, rect, paint);
        return createBitmap;
    }

    /* access modifiers changed from: private */
    public static final void R6(MainActivity mainActivity, View view) {
        mainActivity.a7();
    }

    /* access modifiers changed from: private */
    public static final void R7(MainActivity mainActivity, View view) {
        mainActivity.startActivity(new Intent(mainActivity, LoginActivity.class), UptodownApp.f13477F.a(mainActivity));
        mainActivity.E5();
    }

    /* access modifiers changed from: private */
    public final void S6(long j5, long j6, String str, long j7) {
        X5();
        if (j5 <= 0) {
            K2();
        } else if (this.f14006v0 == -1) {
            this.f14006v0 = j5;
            long j8 = j7;
            new C2388j(this, j5, new t(j6, j8, str, this), LifecycleOwnerKt.getLifecycleScope(this));
        }
    }

    /* access modifiers changed from: private */
    public static final void S7(MainActivity mainActivity, View view) {
        mainActivity.E5();
    }

    /* access modifiers changed from: private */
    public final void T5() {
        RelativeLayout relativeLayout = this.f13985O;
        if (relativeLayout != null) {
            if (relativeLayout != null) {
                relativeLayout.removeAllViews();
            }
            RelativeLayout relativeLayout2 = this.f13985O;
            if (relativeLayout2 != null) {
                relativeLayout2.setVisibility(8);
            }
            this.f13985O = null;
        }
    }

    private final void T6() {
        this.f13979C0.launch(new Intent(this, GdprPrivacySettings.class), UptodownApp.f13477F.b(this));
    }

    /* access modifiers changed from: private */
    public final void T7() {
        AppBarLayout appBarLayout = this.f13991U;
        kotlin.jvm.internal.t.b(appBarLayout);
        appBarLayout.setVisibility(0);
        AppBarLayout appBarLayout2 = this.f13991U;
        kotlin.jvm.internal.t.b(appBarLayout2);
        appBarLayout2.setExpanded(true, false);
    }

    /* access modifiers changed from: private */
    public final void U5() {
        AppBarLayout appBarLayout = this.f13991U;
        kotlin.jvm.internal.t.b(appBarLayout);
        appBarLayout.setVisibility(0);
        AppBarLayout appBarLayout2 = this.f13991U;
        kotlin.jvm.internal.t.b(appBarLayout2);
        appBarLayout2.setExpanded(false, false);
    }

    private final void U7() {
        Float f5;
        if (!isFinishing()) {
            b1 c5 = b1.c(getLayoutInflater());
            kotlin.jvm.internal.t.d(c5, "inflate(...)");
            TextView textView = c5.f22846f;
            k.a aVar = S1.k.f32g;
            textView.setTypeface(aVar.w());
            float height = (float) c5.f22846f.getHeight();
            int color = ContextCompat.getColor(this, R.color.turbo_text_gradient_start);
            int color2 = ContextCompat.getColor(this, R.color.turbo_text_gradient_end);
            TextPaint paint = c5.f22846f.getPaint();
            if (paint != null) {
                f5 = Float.valueOf(paint.measureText(c5.f22846f.getText().toString()));
            } else {
                f5 = null;
            }
            int i5 = color2;
            kotlin.jvm.internal.t.b(f5);
            LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, f5.floatValue(), height, new int[]{color, i5}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
            TextPaint paint2 = c5.f22846f.getPaint();
            if (paint2 != null) {
                paint2.setShader(linearGradient);
            }
            float dimension = getResources().getDimension(R.dimen.turbo_popup_lines_max_width);
            int i6 = getResources().getDisplayMetrics().widthPixels;
            float dimension2 = getResources().getDimension(R.dimen.margin_l);
            float f6 = (((float) i6) - dimension2) - dimension2;
            if (dimension > f6) {
                int i7 = (int) f6;
                c5.f22844d.setMaxWidth(i7);
                c5.f22845e.setMaxWidth(i7);
            }
            c5.f22844d.setTypeface(aVar.x());
            String obj = c5.f22844d.getText().toString();
            List<C2666o> e5 = C2666o.f25106g.e(obj, "\\[xx](.*?)\\[/xx]");
            SpannableString spannableString = new SpannableString(new t3.p("\\[xx](.*?)\\[/xx]").i(obj, new C0836m1()));
            for (C2666o oVar : e5) {
                int f02 = t3.s.f0(spannableString, oVar.d(), 0, false, 6, (Object) null);
                int length = oVar.d().length() + f02;
                if (f02 >= 0) {
                    spannableString.setSpan(new E(this), f02, length, 33);
                }
            }
            c5.f22844d.setText(spannableString);
            c5.f22845e.setTypeface(S1.k.f32g.w());
            c5.f22842b.setOnClickListener(new C0844n1(this));
            c5.f22845e.setOnClickListener(new C0852o1(this));
            Locale locale = Locale.getDefault();
            kotlin.jvm.internal.t.d(locale, "getDefault(...)");
            if (TextUtils.getLayoutDirectionFromLocale(locale) == 1) {
                c5.f22843c.setCropType(0);
            }
            c5.f22843c.setOnClickListener(new C0860p1());
            FrameLayout frameLayout = this.f14009y0;
            kotlin.jvm.internal.t.b(frameLayout);
            frameLayout.addView(c5.getRoot());
            D2.n nVar = new D2.n(this);
            RelativeLayout b5 = c5.getRoot();
            kotlin.jvm.internal.t.d(b5, "getRoot(...)");
            nVar.i(b5, R.anim.popup_turbo_in);
            a.f15150a.q1(this, System.currentTimeMillis());
        }
    }

    private final void V5() {
        AppBarLayout appBarLayout = this.f13991U;
        kotlin.jvm.internal.t.b(appBarLayout);
        appBarLayout.setVisibility(8);
    }

    private final void V6() {
        startActivity(new Intent(this, MyApps.class), UptodownApp.f13477F.a(this));
    }

    /* access modifiers changed from: private */
    public static final CharSequence V7(C2788l lVar) {
        kotlin.jvm.internal.t.e(lVar, "it");
        return (CharSequence) lVar.a().get(1);
    }

    private final void W5() {
        FrameLayout frameLayout = this.f14009y0;
        if (frameLayout != null) {
            kotlin.jvm.internal.t.b(frameLayout);
            if (frameLayout.getChildCount() != 0) {
                D2.n nVar = new D2.n(this);
                FrameLayout frameLayout2 = this.f14009y0;
                kotlin.jvm.internal.t.b(frameLayout2);
                nVar.g(frameLayout2, R.anim.popup_turbo_out, new l(this));
            }
        }
    }

    private final void W6() {
        startActivity(new Intent(this, MyDownloads.class), UptodownApp.f13477F.a(this));
    }

    /* access modifiers changed from: private */
    public static final void W7(MainActivity mainActivity, View view) {
        mainActivity.W5();
    }

    private final void X5() {
        E5();
        W5();
    }

    private final void X6() {
        String string = getString(R.string.tos_title);
        kotlin.jvm.internal.t.d(string, "getString(...)");
        String string2 = getString(R.string.url_privacy);
        kotlin.jvm.internal.t.d(string2, "getString(...)");
        new C2962v().t(this, string2, string);
    }

    /* access modifiers changed from: private */
    public static final void X7(MainActivity mainActivity, View view) {
        mainActivity.W5();
        mainActivity.d3();
    }

    private final void Y5() {
        a.C0147a aVar = a.f15150a;
        String b5 = aVar.b(this);
        if (b5 != null) {
            C2657f fVar = new C2657f();
            fVar.Q0(Long.parseLong(b5));
            e3(fVar);
            aVar.t0(this, (String) null);
        } else if (!aVar.n0(this)) {
            aVar.l1(this, System.currentTimeMillis());
            RelativeLayout relativeLayout = this.f13989S;
            kotlin.jvm.internal.t.b(relativeLayout);
            relativeLayout.setVisibility(0);
            RelativeLayout relativeLayout2 = this.f13989S;
            kotlin.jvm.internal.t.b(relativeLayout2);
            relativeLayout2.setOnClickListener(new O1.F1());
            if (V()) {
                T1();
            } else {
                p0();
            }
            if (!aVar.o0(1, this) || !aVar.V(this)) {
                C6();
            } else {
                i6();
                if (!aVar.o0(4, this)) {
                    v6();
                }
                if (!aVar.o0(5, this)) {
                    if (V.f24870q.h(this) != null) {
                        aVar.w1(this, 5);
                    } else {
                        q6();
                    }
                }
            }
            this.f13986P = 0;
            Object obj = this.f13987Q.get(0);
            kotlin.jvm.internal.t.d(obj, "get(...)");
            s7((c0) obj);
        }
    }

    private final void Y6() {
        this.f13980D0.launch(new Intent(this, PreferencesActivity.class), UptodownApp.f13477F.b(this));
    }

    /* access modifiers changed from: private */
    public static final void Y7(View view) {
    }

    /* access modifiers changed from: private */
    public static final void Z5(View view) {
    }

    private final void Z6() {
        startActivity(new Intent(this, Updates.class), UptodownApp.f13477F.a(this));
    }

    /* access modifiers changed from: private */
    public static final void a6(MainActivity mainActivity, ActivityResult activityResult) {
        String str;
        Bundle extras;
        if (activityResult.getResultCode() == 10) {
            Intent data = activityResult.getData();
            if (data == null || (extras = data.getExtras()) == null) {
                str = null;
            } else {
                str = extras.getString("realPath");
            }
            if (str != null && str.length() != 0) {
                C1598a.D2(mainActivity, new File(str), (String) null, 2, (Object) null);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void a8(MainActivity mainActivity, View view) {
        AlertDialog p22 = mainActivity.p2();
        if (p22 != null) {
            p22.dismiss();
        }
    }

    private final boolean b6() {
        TextView textView = (TextView) findViewById(R.id.tv_title_auto_update);
        if (textView == null || textView.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    private final void b8() {
        String K4 = a.f15150a.K(this);
        if (K4 == null) {
            K4 = "https://uptodown-android.uptodown.com/android";
        }
        startActivity(new Intent("android.intent.action.VIEW", Uri.parse(K4)));
    }

    /* access modifiers changed from: private */
    public final boolean c6() {
        if (b6() || f6()) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final void c7() {
        if (!h6()) {
            FrameLayout frameLayout = (FrameLayout) findViewById(R.id.fl_banner_floating);
            if (frameLayout != null && !C2957p.f26550a.b(this, frameLayout)) {
                B5();
                D5();
                Z7();
                y7();
            } else if (frameLayout == null) {
                B5();
                D5();
                Z7();
                y7();
            }
        }
    }

    private final Bitmap c8() {
        View rootView = getWindow().getDecorView().getRootView();
        Bitmap createBitmap = Bitmap.createBitmap(rootView.getWidth(), rootView.getHeight(), Bitmap.Config.ARGB_8888);
        rootView.draw(new Canvas(createBitmap));
        return R5(Bitmap.createScaledBitmap(createBitmap, rootView.getWidth() / 2, rootView.getHeight() / 2, true), (int) TypedValue.applyDimension(1, 10.0f, getResources().getDisplayMetrics()));
    }

    private final void d7(C2404b0 b0Var, C2668q qVar) {
        TextView textView = b0Var.f22839c;
        k.a aVar = S1.k.f32g;
        textView.setTypeface(aVar.w());
        b0Var.f22840d.setTypeface(aVar.x());
        TextView textView2 = b0Var.f22839c;
        String i5 = qVar.i();
        if (i5 == null) {
            i5 = qVar.w();
        }
        textView2.setText(i5);
        b0Var.f22840d.setText(getString(R.string.version_format, new Object[]{qVar.H(), String.valueOf(qVar.E())}));
        String D4 = qVar.D();
        if (D4 == null || D4.length() == 0) {
            b0Var.f22838b.setImageResource(R.drawable.ic_launcher_foreground);
        } else {
            com.squareup.picasso.s.h().l(qVar.D()).n(UptodownApp.f13477F.g0(this)).i(b0Var.f22838b);
        }
    }

    private final boolean e6() {
        if (ContextCompat.checkSelfPermission(this, "android.permission.POST_NOTIFICATIONS") == 0) {
            return true;
        }
        return false;
    }

    private final void e7(C2404b0 b0Var, T t5) {
        String str;
        TextView textView = b0Var.f22839c;
        k.a aVar = S1.k.f32g;
        textView.setTypeface(aVar.w());
        b0Var.f22840d.setTypeface(aVar.x());
        C2940B a5 = C2940B.f26458v.a(this);
        a5.a();
        C2655d Y4 = a5.Y(t5.h());
        a5.m();
        TextView textView2 = b0Var.f22839c;
        if (Y4 == null || (str = Y4.m()) == null) {
            str = t5.h();
        }
        textView2.setText(str);
        b0Var.f22840d.setText(getString(R.string.version_format, new Object[]{t5.k(), String.valueOf(t5.j())}));
        b0Var.f22838b.setImageDrawable(z2.P.f26510a.j(this, t5.h()));
    }

    private final boolean f6() {
        TextView textView = (TextView) findViewById(R.id.tv_msg_status_526);
        if (textView == null || textView.getVisibility() != 0) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public final void f7() {
        if (h6()) {
            Iterator it = this.f13987Q.iterator();
            kotlin.jvm.internal.t.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                kotlin.jvm.internal.t.d(next, "next(...)");
                ((c0) next).c().removeAllViews();
            }
            RelativeLayout relativeLayout = this.f13989S;
            if (relativeLayout != null) {
                relativeLayout.setVisibility(8);
            }
            RelativeLayout relativeLayout2 = this.f13989S;
            if (relativeLayout2 != null) {
                relativeLayout2.removeAllViews();
            }
            this.f13989S = null;
            a.C0147a aVar = a.f15150a;
            boolean o02 = aVar.o0(4, this);
            boolean o03 = aVar.o0(5, this);
            if (o02 && o03) {
                aVar.v1(this, true);
            }
            c7();
        }
    }

    private final boolean g6() {
        File r5 = new C2962v().r(this);
        if (a.f15150a.j0(this)) {
            o7();
            return true;
        } else if (r5 == null) {
            return false;
        } else {
            u7();
            return true;
        }
    }

    private final boolean h6() {
        RelativeLayout relativeLayout = this.f13989S;
        if (relativeLayout == null) {
            return false;
        }
        kotlin.jvm.internal.t.b(relativeLayout);
        if (relativeLayout.getVisibility() != 0) {
            return false;
        }
        RelativeLayout relativeLayout2 = this.f13989S;
        kotlin.jvm.internal.t.b(relativeLayout2);
        if (relativeLayout2.getChildCount() != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void h8(int i5, C2668q qVar) {
        Fragment O5 = O5();
        if (O5 instanceof C2540v1) {
            runOnUiThread(new C2540v1.C2544d(i5, qVar));
        }
    }

    private final void i6() {
        v5(j6(), 3);
    }

    private final void i7() {
        if (this.f13985O != null) {
            D2.n nVar = new D2.n(this);
            RelativeLayout relativeLayout = this.f13985O;
            kotlin.jvm.internal.t.b(relativeLayout);
            nVar.g(relativeLayout, R.anim.fade_out, new v(this));
        }
    }

    private final RelativeLayout j6() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.wizard_continue, this.f13989S, false);
        kotlin.jvm.internal.t.c(inflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout = (RelativeLayout) inflate;
        k.a aVar = S1.k.f32g;
        ((TextView) relativeLayout.findViewById(R.id.tv_welcome_to_wizard_continue)).setTypeface(aVar.x());
        ((TextView) relativeLayout.findViewById(R.id.tv_app_name_wizard_continue)).setTypeface(aVar.w());
        ((TextView) relativeLayout.findViewById(R.id.tv_continue_to_wizard_continue)).setTypeface(aVar.x());
        TextView textView = (TextView) relativeLayout.findViewById(R.id.tv_next_wizard_continue);
        textView.setTypeface(aVar.w());
        textView.setOnClickListener(new G1(this));
        return relativeLayout;
    }

    private final void j7() {
        int i5;
        if (isFinishing() || this.f13989S == null || a.f15150a.n0(this)) {
            f7();
            return;
        }
        RelativeLayout relativeLayout = this.f13989S;
        kotlin.jvm.internal.t.b(relativeLayout);
        relativeLayout.setVisibility(0);
        RelativeLayout relativeLayout2 = this.f13989S;
        kotlin.jvm.internal.t.b(relativeLayout2);
        relativeLayout2.setOnClickListener(new C0772e1());
        Iterator it = this.f13987Q.iterator();
        kotlin.jvm.internal.t.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            kotlin.jvm.internal.t.d(next, "next(...)");
            c0 c0Var = (c0) next;
            int a5 = c0Var.a();
            if (a5 == 1) {
                c0Var.e(D6());
            } else if (a5 == 2) {
                C2657f fVar = this.f13994X;
                if (fVar != null) {
                    kotlin.jvm.internal.t.b(fVar);
                    c0Var.e(m6(fVar));
                }
            } else if (a5 == 3) {
                c0Var.e(j6());
            } else if (a5 == 4) {
                c0Var.e(w6());
            } else if (a5 == 5) {
                c0Var.e(r6());
            }
        }
        if (this.f13987Q.isEmpty() || (i5 = this.f13986P) < 0 || i5 >= this.f13987Q.size()) {
            f7();
            return;
        }
        Object obj = this.f13987Q.get(this.f13986P);
        kotlin.jvm.internal.t.d(obj, "get(...)");
        s7((c0) obj);
    }

    /* access modifiers changed from: private */
    public static final void k6(MainActivity mainActivity, View view) {
        mainActivity.x5();
    }

    /* access modifiers changed from: private */
    public static final void k7(View view) {
    }

    /* access modifiers changed from: private */
    public final Object k8(C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new H(this, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return W2.J.f19942a;
    }

    private final void l6(C2657f fVar) {
        this.f13994X = fVar;
        v5(m6(fVar), 2);
    }

    /* access modifiers changed from: private */
    public final void l7() {
        ProgressBar progressBar = this.f13998n0;
        if (progressBar != null) {
            kotlin.jvm.internal.t.b(progressBar);
            if (progressBar.getVisibility() != 0) {
                ProgressBar progressBar2 = this.f13998n0;
                kotlin.jvm.internal.t.b(progressBar2);
                progressBar2.setVisibility(0);
                C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.b(), (O) null, new w(this, (C2308e) null), 2, (Object) null);
                V1 v12 = this.f14002r0;
                if (v12 != null) {
                    v12.B();
                }
                R1 r12 = this.f14000p0;
                if (r12 != null) {
                    r12.B();
                }
                F1 f12 = this.f14001q0;
                if (f12 != null) {
                    f12.B();
                }
            }
        }
    }

    private final RelativeLayout m6(C2657f fVar) {
        View inflate = LayoutInflater.from(this).inflate(R.layout.wizard_deep_link, this.f13989S, false);
        kotlin.jvm.internal.t.c(inflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout = (RelativeLayout) inflate;
        com.squareup.picasso.s.h().l(fVar.G()).n(UptodownApp.f13477F.g0(this)).i((ImageView) relativeLayout.findViewById(R.id.iv_logo_wizard_deep_link));
        com.squareup.picasso.s.h().l(fVar.z()).j((ImageView) relativeLayout.findViewById(R.id.iv_header_feature_wizard_deep_link), new m((RelativeLayout) relativeLayout.findViewById(R.id.rl_header_info_wizard_deep_link), (LinearLayout) relativeLayout.findViewById(R.id.ll_options_wizard_welcome), this));
        TextView textView = (TextView) relativeLayout.findViewById(R.id.tv_name_app_wizard_deep_link);
        k.a aVar = S1.k.f32g;
        textView.setTypeface(aVar.x());
        C2939A.a aVar2 = C2939A.f26456b;
        String string = getString(R.string.wizard_deep_link_download, new Object[]{fVar.N()});
        kotlin.jvm.internal.t.d(string, "getString(...)");
        Typeface w4 = aVar.w();
        kotlin.jvm.internal.t.b(w4);
        textView.setText(aVar2.a(string, w4));
        ((TextView) relativeLayout.findViewById(R.id.tv_app_name_wizard_deep_link)).setTypeface(aVar.w());
        ((TextView) relativeLayout.findViewById(R.id.tv_welcome_to_wizard_deep_link)).setTypeface(aVar.x());
        ((TextView) relativeLayout.findViewById(R.id.tv_terms_wizard_deep_link)).setTypeface(aVar.w());
        ((TextView) relativeLayout.findViewById(R.id.tv_terms_wizard_deep_link)).setOnClickListener(new T0(this));
        ((TextView) relativeLayout.findViewById(R.id.tv_privacy_settings_wizard_deep_link)).setTypeface(aVar.w());
        ((TextView) relativeLayout.findViewById(R.id.tv_privacy_settings_wizard_deep_link)).setOnClickListener(new U0(this));
        TextView textView2 = (TextView) relativeLayout.findViewById(R.id.tv_accept_wizard_deep_link);
        textView2.setTypeface(aVar.w());
        textView2.setOnClickListener(new O1.V0(this));
        return relativeLayout;
    }

    private final void m7() {
        y yVar = new y(this, getSupportFragmentManager(), getLifecycle());
        ViewPager2 viewPager2 = this.f13995Y;
        if (viewPager2 != null) {
            viewPager2.setAdapter(yVar);
        }
        UptodownApp.a aVar = UptodownApp.f13477F;
        if (aVar.J()) {
            U5();
            ViewPager2 viewPager22 = this.f13995Y;
            if (viewPager22 != null) {
                viewPager22.setCurrentItem(3, false);
            }
            aVar.t0(false);
        }
        TabLayout tabLayout = this.f13999o0;
        if (tabLayout != null && this.f13995Y != null) {
            kotlin.jvm.internal.t.b(tabLayout);
            ViewPager2 viewPager23 = this.f13995Y;
            kotlin.jvm.internal.t.b(viewPager23);
            new TabLayoutMediator(tabLayout, viewPager23, new A1(this)).attach();
            TabLayout tabLayout2 = this.f13999o0;
            kotlin.jvm.internal.t.b(tabLayout2);
            tabLayout2.addOnTabSelectedListener((TabLayout.OnTabSelectedListener) new x(this));
        }
    }

    /* access modifiers changed from: private */
    public static final void n6(MainActivity mainActivity, View view) {
        mainActivity.X6();
    }

    /* access modifiers changed from: private */
    public static final void n7(MainActivity mainActivity, TabLayout.Tab tab, int i5) {
        kotlin.jvm.internal.t.e(tab, "tab");
        if (i5 == 0) {
            tab.setContentDescription((CharSequence) mainActivity.getString(R.string.cd_home_tab));
            tab.setIcon(ContextCompat.getDrawable(mainActivity, R.drawable.selector_icon_tab_home));
        } else if (i5 == 1) {
            tab.setContentDescription((CharSequence) mainActivity.getString(R.string.top_games_title));
            tab.setIcon(ContextCompat.getDrawable(mainActivity, R.drawable.selector_icon_tab_games));
        } else if (i5 == 2) {
            tab.setContentDescription((CharSequence) mainActivity.getString(R.string.apps));
            tab.setIcon(ContextCompat.getDrawable(mainActivity, R.drawable.selector_icon_tab_apps));
        } else if (i5 == 3) {
            tab.setContentDescription((CharSequence) mainActivity.getString(R.string.my_feed));
            tab.setIcon(ContextCompat.getDrawable(mainActivity, R.drawable.selector_icon_tab_feed));
        }
    }

    /* access modifiers changed from: private */
    public static final void o6(MainActivity mainActivity, View view) {
        mainActivity.T6();
    }

    private final void o7() {
        setContentView((int) R.layout.status_526);
        TextView textView = (TextView) findViewById(R.id.tv_msg_status_526);
        k.a aVar = S1.k.f32g;
        textView.setTypeface(aVar.x());
        textView.setText(z2.P.f26510a.c(getString(R.string.msg_update_app_status_526)));
        TextView textView2 = (TextView) findViewById(R.id.tv_update_status_526);
        textView2.setTypeface(aVar.x());
        textView2.setOnClickListener(new W0(this));
    }

    /* access modifiers changed from: private */
    public static final void p6(MainActivity mainActivity, View view) {
        mainActivity.G4();
    }

    /* access modifiers changed from: private */
    public static final void p7(MainActivity mainActivity, View view) {
        File r5 = new C2962v().r(mainActivity);
        if (r5 != null) {
            UptodownApp.a.X(UptodownApp.f13477F, r5, mainActivity, (String) null, 4, (Object) null);
        } else {
            mainActivity.b8();
        }
    }

    /* access modifiers changed from: private */
    public final void p8() {
        int i5;
        if (this.f13989S != null && this.f13986P >= 0 && this.f13987Q.size() > (i5 = this.f13986P) && ((c0) this.f13987Q.get(i5)).a() == 4 && X() && W()) {
            TextView textView = (TextView) findViewById(R.id.tv_next_wp);
            if (textView != null) {
                textView.setBackground(ContextCompat.getDrawable(this, R.drawable.selector_wizard_accept_button));
            }
            if (textView != null) {
                textView.setTextColor(ContextCompat.getColor(this, R.color.text_color_wizard_button));
            }
        }
    }

    private final void q6() {
        v5(r6(), 5);
    }

    private final void q7() {
        a.f15150a.W0(this, (System.currentTimeMillis() - ((long) 86400000)) + ((long) 3600000));
    }

    private final void q8() {
        TextView textView = (TextView) findViewById(R.id.tv_accept_wizard_welcome);
        if (textView != null) {
            textView.setBackground(ContextCompat.getDrawable(this, R.drawable.selector_wizard_accept_button));
        }
        if (textView != null) {
            textView.setEnabled(true);
        }
        ProgressBar progressBar = (ProgressBar) findViewById(R.id.pb_wizard_deep_link);
        if (progressBar != null) {
            progressBar.setVisibility(8);
        }
    }

    private final RelativeLayout r6() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.wizard_login, this.f13989S, false);
        kotlin.jvm.internal.t.c(inflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout = (RelativeLayout) inflate;
        RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.findViewById(R.id.rl_header_wl);
        if (relativeLayout2 != null) {
            ((TextView) relativeLayout2.findViewById(R.id.tv_title_header_wizard)).setTypeface(S1.k.f32g.w());
        }
        k.a aVar = S1.k.f32g;
        ((TextView) relativeLayout.findViewById(R.id.tv_title_wl)).setTypeface(aVar.w());
        RelativeLayout relativeLayout3 = (RelativeLayout) relativeLayout.findViewById(R.id.rl_login_google_wl);
        if (UptodownApp.f13477F.P()) {
            relativeLayout3.setVisibility(8);
        } else {
            ((TextView) relativeLayout.findViewById(R.id.tv_login_google_wl)).setTypeface(aVar.w());
            relativeLayout3.setOnClickListener(new X0(this));
        }
        TextView textView = (TextView) relativeLayout.findViewById(R.id.tv_login_email_wl);
        textView.setTypeface(aVar.w());
        textView.setOnClickListener(new Y0(this));
        ((TextView) relativeLayout.findViewById(R.id.tv_login_anonymous_wl)).setTypeface(aVar.x());
        ((TextView) relativeLayout.findViewById(R.id.tv_login_anonymous_wl)).setOnClickListener(new Z0(this));
        return relativeLayout;
    }

    /* access modifiers changed from: private */
    public final void r7(Drawable drawable, boolean z4) {
        ImageView imageView;
        if (!isFinishing() && (imageView = this.f14010z0) != null) {
            if (drawable != null) {
                kotlin.jvm.internal.t.b(imageView);
                imageView.setImageDrawable(drawable);
            }
            if (z4) {
                ImageView imageView2 = this.f13977A0;
                if (imageView2 != null) {
                    imageView2.setVisibility(0);
                    return;
                }
                return;
            }
            ImageView imageView3 = this.f13977A0;
            if (imageView3 != null) {
                imageView3.setVisibility(8);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void r8(MainActivity mainActivity, ActivityResult activityResult) {
        int resultCode = activityResult.getResultCode();
        if (resultCode == -1) {
            mainActivity.m8();
            P1 p12 = mainActivity.f14003s0;
            if (p12 != null) {
                p12.r();
            }
        } else if (resultCode == 1) {
            if (mainActivity.o3() != null) {
                mainActivity.l8();
            }
            mainActivity.m8();
        } else if (resultCode == 1003) {
            mainActivity.finish();
            mainActivity.startActivity(mainActivity.getIntent());
        } else if (resultCode == 1004) {
            mainActivity.finish();
            mainActivity.startActivity(mainActivity.getIntent());
        }
    }

    /* access modifiers changed from: private */
    public static final void s6(MainActivity mainActivity, View view) {
        mainActivity.s3();
    }

    /* access modifiers changed from: private */
    public final void s7(c0 c0Var) {
        RelativeLayout relativeLayout = this.f13989S;
        kotlin.jvm.internal.t.b(relativeLayout);
        relativeLayout.removeAllViews();
        RelativeLayout relativeLayout2 = this.f13989S;
        kotlin.jvm.internal.t.b(relativeLayout2);
        relativeLayout2.addView(c0Var.c());
        H6(c0Var.b());
    }

    /* access modifiers changed from: private */
    public static final void t6(MainActivity mainActivity, View view) {
        mainActivity.f13981E0.launch(new Intent(mainActivity, LoginActivity.class), UptodownApp.f13477F.b(mainActivity));
    }

    /* access modifiers changed from: private */
    public static final void t7(MainActivity mainActivity, ActivityResult activityResult) {
        int resultCode = activityResult.getResultCode();
        if (resultCode == 1003) {
            C2940B a5 = C2940B.f26458v.a(mainActivity);
            a5.a();
            a5.s();
            a5.m();
            mainActivity.finish();
            mainActivity.startActivity(mainActivity.getIntent());
        } else if (resultCode != 1004) {
            mainActivity.v2();
        } else {
            UptodownApp.f13477F.e(mainActivity);
            mainActivity.finish();
            mainActivity.startActivity(mainActivity.getIntent());
        }
    }

    /* access modifiers changed from: private */
    public static final void t8(View view) {
    }

    /* access modifiers changed from: private */
    public static final void u6(MainActivity mainActivity, View view) {
        mainActivity.x5();
    }

    private final void u7() {
        C2668q a5;
        C2940B a6 = C2940B.f26458v.a(this);
        a6.a();
        String packageName = getPackageName();
        kotlin.jvm.internal.t.d(packageName, "getPackageName(...)");
        T G02 = a6.G0(packageName);
        a6.m();
        if (G02 != null && 694 < G02.j() && (a5 = G02.a()) != null && a5.f()) {
            setContentView((int) R.layout.dialog_auto_update);
            k.a aVar = S1.k.f32g;
            ((TextView) findViewById(R.id.tv_title_auto_update)).setTypeface(aVar.w());
            ((TextView) findViewById(R.id.tv_desc_auto_update)).setTypeface(aVar.x());
            ((TextView) findViewById(R.id.tv_info_auto_update)).setTypeface(aVar.x());
            TextView textView = (TextView) findViewById(R.id.tv_installed_version_auto_update);
            textView.setTypeface(aVar.x());
            PackageManager packageManager = getPackageManager();
            kotlin.jvm.internal.t.d(packageManager, "getPackageManager(...)");
            String packageName2 = getPackageName();
            kotlin.jvm.internal.t.d(packageName2, "getPackageName(...)");
            textView.setText(getString(R.string.autoupdate_installed_version, new Object[]{C2301u.d(packageManager, packageName2, 0).versionName}));
            TextView textView2 = (TextView) findViewById(R.id.tv_update_version_auto_update);
            textView2.setTypeface(aVar.w());
            textView2.setText(getString(R.string.autoupdate_update_version, new Object[]{G02.k()}));
            TextView textView3 = (TextView) findViewById(R.id.tv_update_size_auto_update);
            textView3.setTypeface(aVar.x());
            if (G02.a() != null) {
                C2291k kVar = new C2291k();
                C2668q a7 = G02.a();
                kotlin.jvm.internal.t.b(a7);
                textView3.setText(getString(R.string.autoupdate_update_size, new Object[]{kVar.d(a7.z(), this)}));
            }
            ((TextView) findViewById(R.id.tv_uptodown_version_details_label)).setTypeface(aVar.x());
            TextView textView4 = (TextView) findViewById(R.id.tv_uptodown_version_details);
            textView4.setTypeface(aVar.x());
            new C2389k(this, G02.h(), new z(textView4, this, G02), LifecycleOwnerKt.getLifecycleScope(this));
            ((RelativeLayout) findViewById(R.id.rl_uptodown_version_details)).setOnClickListener(new Q0(textView4, (ImageView) findViewById(R.id.iv_uptodown_version_details_label)));
            ((TextView) findViewById(R.id.tv_update)).setTypeface(aVar.w());
            ((RelativeLayout) findViewById(R.id.rl_update)).setOnClickListener(new R0(this));
            ((TextView) findViewById(R.id.tv_cancel)).setTypeface(aVar.w());
            ((RelativeLayout) findViewById(R.id.rl_cancel)).setOnClickListener(new S0(this));
        }
    }

    private final void v5(RelativeLayout relativeLayout, int i5) {
        c0 c0Var = new c0();
        c0Var.d(i5);
        c0Var.e(relativeLayout);
        this.f13987Q.add(c0Var);
    }

    private final void v6() {
        v5(w6(), 4);
    }

    /* access modifiers changed from: private */
    public static final void v7(TextView textView, ImageView imageView, View view) {
        kotlin.jvm.internal.t.b(textView);
        if (textView.getVisibility() == 0) {
            textView.setVisibility(8);
            imageView.setScaleY(1.0f);
            return;
        }
        textView.setVisibility(0);
        imageView.setScaleY(-1.0f);
    }

    /* access modifiers changed from: private */
    public final void w5() {
        int i5;
        if (!this.f13988R && this.f13987Q.size() > 0 && (i5 = this.f13986P) >= 0) {
            new D2.n(this).g(((c0) this.f13987Q.get(i5)).c(), R.anim.slide_back_out, new C1593f(this));
        }
    }

    private final RelativeLayout w6() {
        View inflate = LayoutInflater.from(this).inflate(R.layout.wizard_permissions, this.f13989S, false);
        kotlin.jvm.internal.t.c(inflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout = (RelativeLayout) inflate;
        RelativeLayout relativeLayout2 = (RelativeLayout) relativeLayout.findViewById(R.id.rl_header_wp);
        if (relativeLayout2 != null) {
            ((TextView) relativeLayout2.findViewById(R.id.tv_title_header_wizard)).setTypeface(S1.k.f32g.w());
        }
        k.a aVar = S1.k.f32g;
        ((TextView) relativeLayout.findViewById(R.id.tv_title_wp)).setTypeface(aVar.w());
        RelativeLayout relativeLayout3 = (RelativeLayout) relativeLayout.findViewById(R.id.rl_notifications_wp);
        if (Build.VERSION.SDK_INT >= 33) {
            ((TextView) relativeLayout.findViewById(R.id.tv_notifications_title_wp)).setTypeface(aVar.w());
            ((TextView) relativeLayout.findViewById(R.id.tv_notifications_msg_wp)).setTypeface(aVar.x());
            SwitchCompat switchCompat = (SwitchCompat) relativeLayout.findViewById(R.id.sc_notifications_wp);
            this.f13993W = switchCompat;
            kotlin.jvm.internal.t.b(switchCompat);
            switchCompat.setChecked(e6());
            SwitchCompat switchCompat2 = this.f13993W;
            kotlin.jvm.internal.t.b(switchCompat2);
            switchCompat2.setClickable(false);
            relativeLayout3.setOnClickListener(new C0868q1(this));
        } else if (relativeLayout3 != null) {
            relativeLayout3.setVisibility(8);
        }
        ((ScrollableTextView) relativeLayout.findViewById(R.id.tv_unknown_sources_title_wp)).setTypeface(aVar.w());
        ((TextView) relativeLayout.findViewById(R.id.tv_unknown_sources_badge_wp)).setTypeface(aVar.w());
        TextView textView = (TextView) relativeLayout.findViewById(R.id.tv_unknown_sources_msg_wp);
        textView.setText(getString(R.string.msg_install_from_unknown_source, new Object[]{getString(R.string.app_name)}));
        textView.setTypeface(aVar.x());
        SwitchCompat switchCompat3 = (SwitchCompat) relativeLayout.findViewById(R.id.sc_unknown_sources_wp);
        this.f13992V = switchCompat3;
        kotlin.jvm.internal.t.b(switchCompat3);
        switchCompat3.setChecked(X());
        SwitchCompat switchCompat4 = this.f13992V;
        kotlin.jvm.internal.t.b(switchCompat4);
        switchCompat4.setClickable(false);
        ((RelativeLayout) relativeLayout.findViewById(R.id.rl_unknown_sources_wp)).setOnClickListener(new C0875r1(this));
        kotlin.jvm.internal.t.b(relativeLayout3);
        if (relativeLayout3.getVisibility() == 8) {
            relativeLayout.findViewById(R.id.v_unknown_sources_separator).setVisibility(4);
        }
        TextView textView2 = (TextView) relativeLayout.findViewById(R.id.tv_next_wp);
        textView2.setTypeface(aVar.w());
        textView2.setOnClickListener(new C0883s1(this));
        TextView textView3 = (TextView) relativeLayout.findViewById(R.id.tv_back_wp);
        textView3.setTypeface(aVar.w());
        textView3.setOnClickListener(new C0891t1(this));
        return relativeLayout;
    }

    /* access modifiers changed from: private */
    public static final void w7(MainActivity mainActivity, View view) {
        try {
            File r5 = new C2962v().r(mainActivity);
            if (r5 == null || !r5.exists()) {
                mainActivity.h7();
            } else {
                mainActivity.Y1(r5);
            }
        } catch (Exception unused) {
            mainActivity.b8();
        }
    }

    private final boolean w8(Intent intent) {
        if ((intent.getFlags() & 1048576) == 1048576) {
            return true;
        }
        return false;
    }

    private final void x5() {
        a.f15150a.w1(this, ((c0) this.f13987Q.get(this.f13986P)).a());
        new D2.n(this).g(((c0) this.f13987Q.get(this.f13986P)).c(), R.anim.slide_next_out, new C1594g(this));
    }

    /* access modifiers changed from: private */
    public static final void x6(MainActivity mainActivity, View view) {
        SwitchCompat switchCompat = mainActivity.f13993W;
        if (switchCompat != null && !switchCompat.isChecked()) {
            mainActivity.m0();
        }
    }

    /* access modifiers changed from: private */
    public static final void x7(MainActivity mainActivity, View view) {
        mainActivity.finish();
    }

    private final void y5(C2657f fVar, boolean z4) {
        C2540v1 a5 = C2540v1.f24347o.a(fVar);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        kotlin.jvm.internal.t.d(beginTransaction, "beginTransaction(...)");
        if (((CoordinatorLayout) findViewById(R.id.rl_main_scrollable)) != null) {
            try {
                beginTransaction.replace(R.id.rl_main_scrollable, a5);
                beginTransaction.addToBackStack((String) null);
                if (z4) {
                    beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                }
                if (!isFinishing() && !getSupportFragmentManager().isDestroyed()) {
                    beginTransaction.commitAllowingStateLoss();
                }
            } catch (Exception e5) {
                e5.printStackTrace();
                String string = getString(R.string.error_generico);
                kotlin.jvm.internal.t.d(string, "getString(...)");
                u0(string);
            }
        } else {
            String string2 = getString(R.string.error_generico);
            kotlin.jvm.internal.t.d(string2, "getString(...)");
            u0(string2);
        }
    }

    /* access modifiers changed from: private */
    public static final void y6(MainActivity mainActivity, View view) {
        SwitchCompat switchCompat = mainActivity.f13992V;
        if (switchCompat != null && !switchCompat.isChecked() && !mainActivity.X()) {
            mainActivity.o0();
        }
    }

    private final void y7() {
        ArrayList d5 = new z2.E().d(this);
        if (!d5.isEmpty() && !isFinishing()) {
            AlertDialog p22 = p2();
            if (p22 != null) {
                p22.dismiss();
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            C2427n c5 = C2427n.c(getLayoutInflater());
            kotlin.jvm.internal.t.d(c5, "inflate(...)");
            L l5 = new L();
            l5.f24690a = new ArrayList();
            B b5 = new B(l5, c5, this);
            ArrayList arrayList = new ArrayList();
            Iterator it = d5.iterator();
            kotlin.jvm.internal.t.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                kotlin.jvm.internal.t.d(next, "next(...)");
                z2.E e5 = new z2.E();
                String name = ((File) next).getName();
                kotlin.jvm.internal.t.d(name, "getName(...)");
                String k5 = e5.k(name);
                if (k5 != null) {
                    arrayList.add(k5);
                }
            }
            new C2383e(this, arrayList, b5, LifecycleOwnerKt.getLifecycleScope(this));
            TextView textView = c5.f23385g;
            k.a aVar = S1.k.f32g;
            textView.setTypeface(aVar.w());
            c5.f23383e.setTypeface(aVar.w());
            c5.f23383e.setOnClickListener(new C0899u1(this));
            c5.f23384f.setTypeface(aVar.w());
            c5.f23384f.setOnClickListener(new C0907v1(this, l5));
            builder.setView(c5.getRoot());
            builder.setCancelable(true);
            P2(builder.create());
            if (!isFinishing() && p2() != null) {
                AlertDialog p23 = p2();
                kotlin.jvm.internal.t.b(p23);
                Window window = p23.getWindow();
                if (window != null) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                }
                AlertDialog p24 = p2();
                kotlin.jvm.internal.t.b(p24);
                p24.show();
                a.f15150a.u1(this, true);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void z6(MainActivity mainActivity, View view) {
        mainActivity.x5();
    }

    /* access modifiers changed from: private */
    public static final void z7(MainActivity mainActivity, View view) {
        AlertDialog p22 = mainActivity.p2();
        if (p22 != null) {
            p22.dismiss();
        }
    }

    public final void C7() {
        if (this.f13996Z == null) {
            this.f13996Z = (RelativeLayout) findViewById(R.id.rl_container_error_no_connection);
            View inflate = LayoutInflater.from(this).inflate(R.layout.error_no_connection, this.f13996Z, false);
            RelativeLayout relativeLayout = this.f13996Z;
            kotlin.jvm.internal.t.b(relativeLayout);
            relativeLayout.addView(inflate);
            RelativeLayout relativeLayout2 = this.f13996Z;
            kotlin.jvm.internal.t.b(relativeLayout2);
            k.a aVar = S1.k.f32g;
            ((TextView) relativeLayout2.findViewById(R.id.tv_msg_enc)).setTypeface(aVar.w());
            RelativeLayout relativeLayout3 = this.f13996Z;
            kotlin.jvm.internal.t.b(relativeLayout3);
            ((TextView) relativeLayout3.findViewById(R.id.tv_my_apps_label_enc)).setTypeface(aVar.w());
            RelativeLayout relativeLayout4 = this.f13996Z;
            kotlin.jvm.internal.t.b(relativeLayout4);
            TextView textView = (TextView) relativeLayout4.findViewById(R.id.tv_updates_available_enc);
            textView.setTypeface(aVar.x());
            textView.setOnClickListener(new J1(this));
            RelativeLayout relativeLayout5 = this.f13996Z;
            kotlin.jvm.internal.t.b(relativeLayout5);
            TextView textView2 = (TextView) relativeLayout5.findViewById(R.id.tv_installed_enc);
            textView2.setTypeface(aVar.x());
            textView2.setOnClickListener(new K1(this));
            RelativeLayout relativeLayout6 = this.f13996Z;
            kotlin.jvm.internal.t.b(relativeLayout6);
            TextView textView3 = (TextView) relativeLayout6.findViewById(R.id.tv_downloads_enc);
            textView3.setTypeface(aVar.x());
            textView3.setOnClickListener(new L1(this));
            RelativeLayout relativeLayout7 = this.f13996Z;
            kotlin.jvm.internal.t.b(relativeLayout7);
            ((TextView) relativeLayout7.findViewById(R.id.tv_settings_enc)).setTypeface(aVar.w());
            RelativeLayout relativeLayout8 = this.f13996Z;
            kotlin.jvm.internal.t.b(relativeLayout8);
            ((LinearLayout) relativeLayout8.findViewById(R.id.ll_container_settings_enc)).setOnClickListener(new M1(this));
            RelativeLayout relativeLayout9 = this.f13996Z;
            kotlin.jvm.internal.t.b(relativeLayout9);
            TextView textView4 = (TextView) relativeLayout9.findViewById(R.id.tv_refresh_enc);
            textView4.setTypeface(aVar.w());
            textView4.setOnClickListener(new N1(this));
            RelativeLayout relativeLayout10 = this.f13996Z;
            kotlin.jvm.internal.t.b(relativeLayout10);
            this.f13998n0 = (ProgressBar) relativeLayout10.findViewById(R.id.pb_loading_refresh_enc);
            RelativeLayout relativeLayout11 = this.f13996Z;
            kotlin.jvm.internal.t.b(relativeLayout11);
            ((RelativeLayout) relativeLayout11.findViewById(R.id.rl_container_progressbar_enc)).setOnClickListener(new O1());
        }
        RelativeLayout relativeLayout12 = this.f13996Z;
        kotlin.jvm.internal.t.b(relativeLayout12);
        relativeLayout12.setVisibility(0);
        ProgressBar progressBar = this.f13998n0;
        kotlin.jvm.internal.t.b(progressBar);
        progressBar.setVisibility(4);
    }

    public void F2(C2657f fVar) {
        kotlin.jvm.internal.t.e(fVar, "appInfo");
        super.F2(fVar);
        if (this.f13989S != null && this.f13986P == 0 && this.f13987Q.size() == 1 && ((c0) this.f13987Q.get(this.f13986P)).a() == 1 && !f6()) {
            l6(fVar);
            x5();
        }
    }

    public void G2() {
        if (this.f13989S != null && this.f13986P == 0 && this.f13987Q.size() == 1 && ((c0) this.f13987Q.get(this.f13986P)).a() == 1 && !f6()) {
            q8();
            B6();
        }
    }

    public void H2(long j5) {
        X5();
        if (j5 <= 0) {
            K2();
        } else if (this.f14006v0 == -1) {
            this.f14006v0 = j5;
            new C2388j(this, j5, new s(this), LifecycleOwnerKt.getLifecycleScope(this));
        }
    }

    public final void I5() {
        i7();
    }

    public final ActivityResultLauncher N5() {
        return this.f13979C0;
    }

    public final Fragment O5() {
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            List<Fragment> fragments = getSupportFragmentManager().getFragments();
            kotlin.jvm.internal.t.d(fragments, "getFragments(...)");
            return (Fragment) C2250q.X(fragments);
        } else if (!this.f14004t0.isEmpty()) {
            return (Fragment) C2250q.X(this.f14004t0);
        } else {
            return null;
        }
    }

    public final RelativeLayout Q5() {
        return this.f13997m0;
    }

    public final void S5() {
        RelativeLayout relativeLayout = this.f13996Z;
        if (relativeLayout != null) {
            kotlin.jvm.internal.t.b(relativeLayout);
            if (relativeLayout.getVisibility() == 0) {
                RelativeLayout relativeLayout2 = this.f13996Z;
                kotlin.jvm.internal.t.b(relativeLayout2);
                relativeLayout2.setVisibility(8);
            }
        }
    }

    public final void U6() {
        this.f13981E0.launch(new Intent(this, LoginActivity.class), UptodownApp.f13477F.b(this));
    }

    public final void Z7() {
        V h5 = V.f24870q.h(this);
        if (!isFinishing() && h5 != null && h5.q()) {
            a.C0147a aVar = a.f15150a;
            if (!aVar.m0(this)) {
                AlertDialog p22 = p2();
                if (p22 != null) {
                    p22.dismiss();
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                c1 c5 = c1.c(getLayoutInflater());
                kotlin.jvm.internal.t.d(c5, "inflate(...)");
                TextView textView = c5.f22868o;
                k.a aVar2 = S1.k.f32g;
                textView.setTypeface(aVar2.w());
                String string = getString(R.string.uptodown_turbo);
                kotlin.jvm.internal.t.d(string, "getString(...)");
                int color = ContextCompat.getColor(this, R.color.turbo_text_gradient_start);
                int color2 = ContextCompat.getColor(this, R.color.turbo_text_gradient_end);
                TextView textView2 = c5.f22868o;
                kotlin.jvm.internal.t.d(textView2, "tvTitleTurboWelcomePopup");
                String obj = textView2.getText().toString();
                float height = (float) textView2.getHeight();
                LinearGradient linearGradient = new LinearGradient(0.0f, 0.0f, textView2.getPaint().measureText(string), height, new int[]{color, color2}, new float[]{0.0f, 1.0f}, Shader.TileMode.CLAMP);
                SpannableString spannableString = new SpannableString(obj);
                int f02 = t3.s.f0(obj, string, 0, false, 6, (Object) null);
                if (f02 >= 0) {
                    spannableString.setSpan(new C2962v.a.C0266a(linearGradient, getResources().getDimension(R.dimen.font_size_26)), f02, string.length() + f02, 33);
                }
                textView2.setText(spannableString);
                Spanned c6 = z2.P.f26510a.c(getString(R.string.turbo_welcome_popup_description, new Object[]{getString(R.string.turbo_welcome_popup_manage_subscription)}));
                String string2 = getString(R.string.turbo_welcome_popup_manage_subscription);
                kotlin.jvm.internal.t.d(string2, "getString(...)");
                SpannableString spannableString2 = new SpannableString(c6);
                int f03 = t3.s.f0(c6, string2, 0, false, 6, (Object) null);
                if (f03 >= 0) {
                    spannableString2.setSpan(new StyleSpan(1), f03, string2.length() + f03, 33);
                }
                c5.f22862i.setText(spannableString2);
                c5.f22862i.setTypeface(aVar2.x());
                c5.f22866m.setTypeface(aVar2.w());
                c5.f22865l.setTypeface(aVar2.x());
                c5.f22861h.setTypeface(aVar2.w());
                c5.f22860g.setTypeface(aVar2.x());
                c5.f22864k.setTypeface(aVar2.w());
                c5.f22863j.setTypeface(aVar2.x());
                c5.f22867n.setTypeface(aVar2.w());
                c5.f22867n.setOnClickListener(new C0780f1(this));
                builder.setView(c5.getRoot());
                builder.setCancelable(true);
                P2(builder.create());
                if (!isFinishing() && p2() != null) {
                    AlertDialog p23 = p2();
                    kotlin.jvm.internal.t.b(p23);
                    Window window = p23.getWindow();
                    if (window != null) {
                        window.setBackgroundDrawable(new ColorDrawable(0));
                    }
                    AlertDialog p24 = p2();
                    kotlin.jvm.internal.t.b(p24);
                    p24.show();
                    aVar.u1(this, true);
                }
            }
        }
    }

    public void a0() {
        super.a0();
        SwitchCompat switchCompat = this.f13993W;
        if (switchCompat != null) {
            switchCompat.setChecked(false);
        }
        p8();
    }

    public final void a7() {
        this.f13982F0.launch(new Intent(this, UserActivity.class), UptodownApp.f13477F.b(this));
    }

    public void b0() {
        super.b0();
        SwitchCompat switchCompat = this.f13993W;
        if (switchCompat != null) {
            switchCompat.setChecked(true);
        }
        p8();
    }

    public final void b7() {
        RelativeLayout relativeLayout;
        if (getSupportFragmentManager().getBackStackEntryCount() > 0) {
            getSupportFragmentManager().popBackStackImmediate((String) null, 1);
        }
        RelativeLayout relativeLayout2 = this.f13997m0;
        if (!(relativeLayout2 == null || relativeLayout2.getVisibility() != 0 || (relativeLayout = this.f13997m0) == null)) {
            relativeLayout.setVisibility(8);
        }
        TabLayout tabLayout = this.f13999o0;
        if (tabLayout == null || tabLayout.getSelectedTabPosition() != 3) {
            T7();
        }
    }

    public void c3(long j5) {
        a.f15150a.t0(this, String.valueOf(j5));
        Bitmap c8 = c8();
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl_wizard);
        this.f13989S = relativeLayout;
        kotlin.jvm.internal.t.b(relativeLayout);
        relativeLayout.setVisibility(0);
        RelativeLayout relativeLayout2 = this.f13989S;
        kotlin.jvm.internal.t.b(relativeLayout2);
        relativeLayout2.setOnClickListener(new O1.P1());
        RelativeLayout relativeLayout3 = this.f13989S;
        kotlin.jvm.internal.t.b(relativeLayout3);
        relativeLayout3.removeAllViews();
        View inflate = LayoutInflater.from(this).inflate(R.layout.wizard_kill, this.f13989S, false);
        kotlin.jvm.internal.t.c(inflate, "null cannot be cast to non-null type android.widget.RelativeLayout");
        RelativeLayout relativeLayout4 = (RelativeLayout) inflate;
        k.a aVar = S1.k.f32g;
        ((TextView) relativeLayout4.findViewById(R.id.tv_title_wizard_kill)).setTypeface(aVar.w());
        TextView textView = (TextView) relativeLayout4.findViewById(R.id.tv_slogan_to_wizard_kill);
        textView.setTypeface(aVar.x());
        textView.setText(getString(R.string.core_kill_this_app, new Object[]{getString(R.string.app_name)}));
        ((TextView) relativeLayout4.findViewById(R.id.tv_slide_wizard_kill)).setTypeface(aVar.w());
        TextView textView2 = (TextView) relativeLayout4.findViewById(R.id.tv_accept_wizard_kill);
        textView2.setTypeface(aVar.x());
        textView2.setEnabled(true);
        textView2.setOnClickListener(new Q1(this));
        c0 c0Var = new c0();
        c0Var.d(6);
        c0Var.e(relativeLayout4);
        s7(c0Var);
        ImageView imageView = (ImageView) relativeLayout4.findViewById(R.id.iv_tap_screen_kill);
        Animation loadAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_up_tap);
        loadAnimation.setStartOffset(500);
        loadAnimation.setFillAfter(true);
        ImageView imageView2 = (ImageView) relativeLayout4.findViewById(R.id.iv_screenshot_kill);
        imageView2.setImageBitmap(c8);
        Animation loadAnimation2 = AnimationUtils.loadAnimation(this, R.anim.slide_up_out);
        loadAnimation2.setFillAfter(true);
        loadAnimation2.setStartOffset(500);
        loadAnimation2.setAnimationListener(new C(imageView, loadAnimation, imageView2));
        imageView.startAnimation(loadAnimation);
        imageView2.startAnimation(loadAnimation2);
    }

    public final boolean d6() {
        RelativeLayout relativeLayout = this.f13996Z;
        if (relativeLayout == null) {
            return false;
        }
        kotlin.jvm.internal.t.b(relativeLayout);
        if (relativeLayout.getVisibility() == 0) {
            return true;
        }
        return false;
    }

    public final void d8(String str) {
        if (O5() instanceof C2497h) {
            Fragment O5 = O5();
            kotlin.jvm.internal.t.c(O5, "null cannot be cast to non-null type com.uptodown.fragments.AlternativesFragment");
            ((C2497h) O5).t(str);
        }
    }

    public void e3(C2657f fVar) {
        kotlin.jvm.internal.t.e(fVar, "appInfo");
        Fragment O5 = O5();
        RelativeLayout relativeLayout = this.f13997m0;
        if (relativeLayout != null) {
            relativeLayout.setOnClickListener(new P0());
        }
        RelativeLayout relativeLayout2 = this.f13997m0;
        if (relativeLayout2 != null) {
            relativeLayout2.setVisibility(0);
        }
        if (!(O5 instanceof C2540v1)) {
            y5(fVar, false);
        } else if (((C2540v1) O5).a4().e() != fVar.e()) {
            y5(fVar, true);
        }
        V5();
    }

    public final Object e8(String str, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.c(), new F(this, str, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return W2.J.f19942a;
    }

    public void f0() {
        super.f0();
        g2();
    }

    public final Object f8(String str, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.c(), new G(this, str, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return W2.J.f19942a;
    }

    public void g0() {
        super.g0();
        g2();
    }

    public final void g7() {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (O) null, new u(this, (C2308e) null), 2, (Object) null);
    }

    public final void g8(String str) {
        if (O5() instanceof R1) {
            Fragment O5 = O5();
            kotlin.jvm.internal.t.c(O5, "null cannot be cast to non-null type com.uptodown.fragments.GamesCategoryFragment");
            ((R1) O5).E(str);
        } else if (O5() instanceof F1) {
            Fragment O52 = O5();
            kotlin.jvm.internal.t.c(O52, "null cannot be cast to non-null type com.uptodown.fragments.AppsCategoryFragment");
            ((F1) O52).E(str);
        } else {
            R1 r12 = this.f14000p0;
            if (r12 != null) {
                kotlin.jvm.internal.t.b(r12);
                r12.E(str);
            }
        }
    }

    public void h0() {
        super.h0();
        T1();
    }

    public final void h7() {
        f7();
        if (!g6()) {
            j7();
            i7();
            l8();
        }
    }

    public void i0() {
        super.i0();
        T1();
    }

    public final void i8(int i5, T t5) {
        Fragment O5 = O5();
        if (t5 != null && (O5 instanceof C2540v1)) {
            runOnUiThread(new C2540v1.C2542b(i5, t5));
        }
    }

    public final void j8(String str) {
        if (O5() instanceof V1) {
            Fragment O5 = O5();
            kotlin.jvm.internal.t.c(O5, "null cannot be cast to non-null type com.uptodown.fragments.HomeFragment");
            ((V1) O5).H(str);
            return;
        }
        V1 v12 = this.f14002r0;
        if (v12 != null) {
            kotlin.jvm.internal.t.b(v12);
            v12.H(str);
        }
    }

    public void l0() {
        SwitchCompat switchCompat = this.f13992V;
        if (switchCompat != null) {
            switchCompat.setChecked(X());
        }
        p8();
    }

    public final void l8() {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), (C2312i) null, (O) null, new I(this, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void m3() {
    }

    public final void m8() {
        ImageView imageView = (ImageView) findViewById(R.id.home_uptodown_turbo);
        V h5 = V.f24870q.h(this);
        if (isFinishing() || h5 == null || !h5.q()) {
            if (imageView != null) {
                imageView.setVisibility(0);
            }
        } else if (imageView != null) {
            imageView.setVisibility(8);
        }
        l8();
    }

    public final void n8(String str) {
        if (O5() instanceof f2) {
            Fragment O5 = O5();
            kotlin.jvm.internal.t.c(O5, "null cannot be cast to non-null type com.uptodown.fragments.TopByCategoryFragment");
            ((f2) O5).b0(str);
        }
    }

    public V o3() {
        String str;
        V h5 = V.f24870q.h(this);
        if (h5 != null) {
            str = h5.j();
        } else {
            str = null;
        }
        if (str == null || !h5.p(this)) {
            return null;
        }
        return h5;
    }

    public final void o8(C2668q qVar, int i5) {
        kotlin.jvm.internal.t.e(qVar, "download");
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (O) null, new J(i5, this, qVar, (C2308e) null), 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        String str;
        Bundle extras;
        String str2;
        long j5;
        Bundle extras2;
        Bundle extras3;
        super.onCreate(bundle);
        setContentView((int) R.layout.main);
        if (new U().a(this)) {
            finish();
            return;
        }
        this.f14007w0 = (FrameLayout) findViewById(R.id.fl_sign_in_popup);
        this.f14009y0 = (FrameLayout) findViewById(R.id.fl_uptodown_turbo_popup);
        RelativeLayout relativeLayout = (RelativeLayout) findViewById(R.id.rl_splash);
        this.f13985O = relativeLayout;
        kotlin.jvm.internal.t.b(relativeLayout);
        relativeLayout.setOnClickListener(new C0915w1());
        R2((RelativeLayout) findViewById(R.id.app_info_selected_popup));
        UptodownApp.a aVar = UptodownApp.f13477F;
        if (aVar.J()) {
            RelativeLayout relativeLayout2 = this.f13985O;
            kotlin.jvm.internal.t.b(relativeLayout2);
            relativeLayout2.setVisibility(8);
        }
        this.f13989S = (RelativeLayout) findViewById(R.id.rl_wizard);
        v2();
        this.f13990T = (Toolbar) findViewById(R.id.toolbar_main);
        this.f13991U = (AppBarLayout) findViewById(R.id.abl_toolbar);
        ((ImageView) findViewById(R.id.home_uptodown_logo)).setOnClickListener(new H1(this));
        ((TextView) findViewById(R.id.tv_main_search_view)).setTypeface(S1.k.f32g.x());
        ((RelativeLayout) findViewById(R.id.rl_main_search_view)).setOnClickListener(new O1.R1(this));
        ((ImageView) findViewById(R.id.home_uptodown_turbo)).setOnClickListener(new S1(this));
        m8();
        String str3 = null;
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), (C2312i) null, (O) null, new o(this, (C2308e) null), 3, (Object) null);
        Y5();
        runOnUiThread(new T1(this));
        UptodownApp.a.O0(aVar, this, false, 2, (Object) null);
        if (!a.f15150a.X(this)) {
            Context applicationContext = getApplicationContext();
            kotlin.jvm.internal.t.d(applicationContext, "getApplicationContext(...)");
            new C2393o(applicationContext);
        }
        if (getIntent() != null) {
            Intent intent = getIntent();
            kotlin.jvm.internal.t.d(intent, "getIntent(...)");
            if (!w8(intent)) {
                Uri data = getIntent().getData();
                if (data != null) {
                    String uri = data.toString();
                    kotlin.jvm.internal.t.d(uri, "toString(...)");
                    String j6 = new C2290j().j(data, this);
                    Class<InstallerActivity> cls = InstallerActivity.class;
                    if (j6 != null && t3.s.D(j6, ".apk", false, 2, (Object) null)) {
                        String k5 = new z2.E().k(j6);
                        if (k5 != null) {
                            J2(k5, (C2661j) null);
                        } else {
                            Intent intent2 = new Intent(getApplicationContext(), cls);
                            intent2.setData(data);
                            this.f13984H0.launch(intent2);
                        }
                    } else if (j6 != null && C2279K.f20490b.a(j6)) {
                        Intent intent3 = new Intent(getApplicationContext(), cls);
                        intent3.setData(data);
                        this.f13984H0.launch(intent3);
                    } else if (t3.s.P(uri, "https://dw.uptodown.com/dwn/", false, 2, (Object) null)) {
                        new C2382d(this, uri, new p(this), LifecycleOwnerKt.getLifecycleScope(this));
                    } else if (t3.s.V(uri, "preregister-available", false, 2, (Object) null)) {
                        String queryParameter = data.getQueryParameter("appID");
                        if (!(queryParameter == null || queryParameter.length() == 0)) {
                            try {
                                String queryParameter2 = data.getQueryParameter("appID");
                                kotlin.jvm.internal.t.b(queryParameter2);
                                H2(Long.parseLong(queryParameter2));
                            } catch (NumberFormatException e5) {
                                e5.printStackTrace();
                            }
                        }
                    } else if (!aVar.R(this)) {
                        new C2389k(this, new C2962v().m(data), this.f13978B0, LifecycleOwnerKt.getLifecycleScope(this));
                    }
                }
                Intent intent4 = getIntent();
                if (intent4 == null || (extras3 = intent4.getExtras()) == null) {
                    str = null;
                } else {
                    str = extras3.getString("action");
                }
                if (str != null) {
                    MyFirebaseMessagingService.a aVar2 = MyFirebaseMessagingService.f21134h;
                    if (aVar2.b(str)) {
                        Intent intent5 = getIntent();
                        if (intent5 == null || (extras2 = intent5.getExtras()) == null) {
                            str2 = null;
                        } else {
                            str2 = extras2.getString("appId");
                        }
                        if (str2 != null) {
                            try {
                                j5 = Long.parseLong(str2);
                            } catch (NumberFormatException e6) {
                                e6.printStackTrace();
                                j5 = -1;
                            }
                            if (j5 > 0) {
                                Bundle extras4 = getIntent().getExtras();
                                if (extras4 != null) {
                                    str3 = extras4.getString("packageName");
                                }
                                C2641A a5 = new C2641A();
                                a5.j(j5);
                                a5.m(str3);
                                a5.n(this);
                                new C2388j(this, j5, this.f13978B0, LifecycleOwnerKt.getLifecycleScope(this));
                            }
                        }
                    } else if (aVar2.a(str)) {
                        Intent intent6 = getIntent();
                        if (!(intent6 == null || (extras = intent6.getExtras()) == null)) {
                            str3 = extras.getString("campaign");
                        }
                        if (str3 != null && t3.s.E(str3, "BlackFriday", true)) {
                            d3();
                        }
                    }
                } else {
                    C2641A b5 = C2641A.f24721f.b(this);
                    if (b5 != null && !b5.g()) {
                        new C2388j(this, b5.b(), this.f13978B0, LifecycleOwnerKt.getLifecycleScope(this));
                    }
                }
            }
        }
        getOnBackPressedDispatcher().addCallback(this, this.f13983G0);
        Y2(registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new U1(this)));
        ViewPager2 viewPager2 = (ViewPager2) findViewById(R.id.view_pager);
        this.f13995Y = viewPager2;
        if (viewPager2 != null) {
            viewPager2.setOffscreenPageLimit(4);
        }
        ViewPager2 viewPager22 = this.f13995Y;
        if (viewPager22 != null) {
            viewPager22.setUserInputEnabled(false);
        }
        this.f13999o0 = (TabLayout) findViewById(R.id.tabs);
        this.f13997m0 = (RelativeLayout) findViewById(R.id.rl_app_detail_open);
        ImageView imageView = (ImageView) findViewById(R.id.iv_avatar_user);
        this.f14010z0 = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new O1.V1(this));
        }
        this.f13977A0 = (ImageView) findViewById(R.id.iv_badge_user);
        m7();
    }

    public boolean onKeyDown(int i5, KeyEvent keyEvent) {
        kotlin.jvm.internal.t.e(keyEvent, NotificationCompat.CATEGORY_EVENT);
        return super.onKeyDown(i5, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!g6()) {
            l8();
            z2.M.f26506a.h(this);
            if (d6()) {
                l7();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSaveInstanceState(Bundle bundle) {
        kotlin.jvm.internal.t.e(bundle, "outState");
        super.onSaveInstanceState(new Bundle());
    }

    public final void s8(C2654c cVar) {
        kotlin.jvm.internal.t.e(cVar, "alternatives");
        X5();
        C2497h a5 = C2497h.f24213f.a(cVar);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        kotlin.jvm.internal.t.d(beginTransaction, "beginTransaction(...)");
        if (((CoordinatorLayout) findViewById(R.id.rl_main_scrollable)) != null) {
            try {
                UptodownApp.f13477F.o0(beginTransaction, this);
                beginTransaction.add((int) R.id.rl_main_scrollable, (Fragment) a5);
                beginTransaction.addToBackStack(cVar.c());
                if (O5() instanceof f2) {
                    beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                }
                if (!isFinishing() && !getSupportFragmentManager().isDestroyed()) {
                    try {
                        beginTransaction.commitAllowingStateLoss();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                        String string = getString(R.string.error_generico);
                        kotlin.jvm.internal.t.d(string, "getString(...)");
                        u0(string);
                    }
                }
            } catch (Exception e6) {
                e6.printStackTrace();
                String string2 = getString(R.string.error_generico);
                kotlin.jvm.internal.t.d(string2, "getString(...)");
                u0(string2);
            }
        } else {
            String string3 = getString(R.string.error_generico);
            kotlin.jvm.internal.t.d(string3, "getString(...)");
            u0(string3);
        }
    }

    public void t3() {
        int i5;
        if (this.f13989S != null && this.f13987Q.size() > (i5 = this.f13986P) && ((c0) this.f13987Q.get(i5)).a() == 5) {
            x5();
            m8();
        }
    }

    public final void u8(C2660i iVar) {
        kotlin.jvm.internal.t.e(iVar, "category");
        if (iVar.c() == 523) {
            z5(1);
        } else if (iVar.c() == 831) {
            z5(2);
        }
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        kotlin.jvm.internal.t.d(beginTransaction, "beginTransaction(...)");
        beginTransaction.add((int) R.id.fl_apps_category_fragment, (Fragment) F1.f23968n.a(iVar));
        beginTransaction.addToBackStack("appsCategory");
        if (!isFinishing() && !getSupportFragmentManager().isDestroyed()) {
            try {
                beginTransaction.commitAllowingStateLoss();
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public final void v8(C2660i iVar) {
        kotlin.jvm.internal.t.e(iVar, "category");
        X5();
        f2 a5 = f2.f24166k.a(iVar);
        FragmentTransaction beginTransaction = getSupportFragmentManager().beginTransaction();
        kotlin.jvm.internal.t.d(beginTransaction, "beginTransaction(...)");
        if (((CoordinatorLayout) findViewById(R.id.rl_main_scrollable)) != null) {
            try {
                UptodownApp.f13477F.o0(beginTransaction, this);
                beginTransaction.add((int) R.id.rl_main_scrollable, (Fragment) a5);
                beginTransaction.addToBackStack(a5.L().e());
                if (O5() instanceof f2) {
                    beginTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                }
                if (!isFinishing() && !getSupportFragmentManager().isDestroyed()) {
                    try {
                        beginTransaction.commitAllowingStateLoss();
                    } catch (Exception e5) {
                        e5.printStackTrace();
                        String string = getString(R.string.error_generico);
                        kotlin.jvm.internal.t.d(string, "getString(...)");
                        u0(string);
                    }
                }
            } catch (Exception e6) {
                e6.printStackTrace();
                String string2 = getString(R.string.error_generico);
                kotlin.jvm.internal.t.d(string2, "getString(...)");
                u0(string2);
            }
        } else {
            String string3 = getString(R.string.error_generico);
            kotlin.jvm.internal.t.d(string3, "getString(...)");
            u0(string3);
        }
    }

    /* access modifiers changed from: protected */
    public void x3() {
    }

    /* access modifiers changed from: protected */
    public void y3() {
    }

    public final void z5(int i5) {
        TabLayout tabLayout = this.f13999o0;
        kotlin.jvm.internal.t.b(tabLayout);
        if (i5 < tabLayout.getTabCount()) {
            TabLayout tabLayout2 = this.f13999o0;
            kotlin.jvm.internal.t.b(tabLayout2);
            if (tabLayout2.getSelectedTabPosition() != i5) {
                TabLayout tabLayout3 = this.f13999o0;
                kotlin.jvm.internal.t.b(tabLayout3);
                TabLayout.Tab tabAt = tabLayout3.getTabAt(i5);
                if (tabAt != null) {
                    tabAt.select();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void u3(V v5) {
    }

    /* access modifiers changed from: protected */
    public void w3(V v5, String str) {
    }
}
