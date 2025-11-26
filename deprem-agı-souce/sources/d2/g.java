package D2;

import B2.v;
import S1.k;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleCoroutineScope;
import b2.C2291k;
import com.squareup.picasso.s;
import com.squareup.picasso.w;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.C1598a;
import com.uptodown.activities.LoginActivity;
import com.uptodown.workers.DownloadWorker;
import g2.C2388j;
import java.io.File;
import java.util.concurrent.atomic.AtomicBoolean;
import k2.C2610u;
import k2.Q;
import k2.S;
import kotlin.jvm.internal.t;
import l2.C2655d;
import l2.C2657f;
import l2.C2668q;
import l2.T;
import l2.V;
import z2.C2940B;
import z2.C2954m;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    private C2657f f17967a;

    /* renamed from: b  reason: collision with root package name */
    private final RelativeLayout f17968b;

    /* renamed from: c  reason: collision with root package name */
    private final a f17969c;

    /* renamed from: d  reason: collision with root package name */
    public View f17970d;

    /* renamed from: e  reason: collision with root package name */
    public RelativeLayout f17971e;

    /* renamed from: f  reason: collision with root package name */
    private ImageView f17972f;

    /* renamed from: g  reason: collision with root package name */
    private TextView f17973g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f17974h;

    /* renamed from: i  reason: collision with root package name */
    private TextView f17975i;

    /* renamed from: j  reason: collision with root package name */
    private TextView f17976j;

    /* renamed from: k  reason: collision with root package name */
    private TextView f17977k;

    /* renamed from: l  reason: collision with root package name */
    private ImageView f17978l;

    /* renamed from: m  reason: collision with root package name */
    private LinearLayout f17979m;

    /* renamed from: n  reason: collision with root package name */
    private ProgressBar f17980n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f17981o;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public AtomicBoolean f17982p = new AtomicBoolean(false);
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public boolean f17983q;

    public interface a {
        void a(C2657f fVar);

        void b(C2657f fVar);
    }

    public static final class e implements M1.b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f17990a;

        e(g gVar) {
            this.f17990a = gVar;
        }

        public void a(Exception exc) {
            t.e(exc, "e");
        }

        public void onSuccess() {
            this.f17990a.f17983q = true;
        }
    }

    public g(C2657f fVar, RelativeLayout relativeLayout, a aVar) {
        t.e(fVar, "appInfoSelected");
        t.e(relativeLayout, "rlContainer");
        this.f17967a = fVar;
        this.f17968b = relativeLayout;
        this.f17969c = aVar;
    }

    /* access modifiers changed from: private */
    public final void A(C1598a aVar, C2657f fVar) {
        C2668q qVar;
        T t5;
        boolean z4;
        boolean z5;
        C2668q qVar2;
        TextView textView = null;
        if (!this.f17983q) {
            w n5 = s.h().l(fVar.G()).l(R.drawable.shape_bg_placeholder).n(UptodownApp.f13477F.g0(aVar));
            ImageView imageView = this.f17972f;
            if (imageView == null) {
                t.w("ivLogoAppInfoSelected");
                imageView = null;
            }
            n5.j(imageView, new e(this));
        }
        TextView textView2 = this.f17973g;
        if (textView2 == null) {
            t.w("tvNameAppInfoSelected");
            textView2 = null;
        }
        textView2.setText(fVar.N());
        TextView textView3 = this.f17975i;
        if (textView3 == null) {
            t.w("tvAuthorAppInfoSelected");
            textView3 = null;
        }
        textView3.setText(fVar.g());
        TextView textView4 = this.f17977k;
        if (textView4 == null) {
            t.w("tvValorationAppInfoSelected");
            textView4 = null;
        }
        textView4.setText(String.valueOf(((double) fVar.a0()) / 10.0d));
        C2940B a5 = C2940B.f26458v.a(aVar);
        a5.a();
        if (fVar.A() >= 0) {
            qVar = a5.h0(String.valueOf(fVar.A()));
        } else {
            qVar = null;
        }
        String S4 = fVar.S();
        if (S4 == null || S4.length() == 0) {
            t5 = null;
        } else {
            String S5 = fVar.S();
            t.b(S5);
            T G02 = a5.G0(S5);
            if (G02 != null) {
                qVar2 = G02.b(aVar);
            } else {
                qVar2 = null;
            }
            if (qVar2 == null) {
                String S6 = fVar.S();
                t.b(S6);
                qVar2 = a5.k0(S6, fVar.J());
            }
            C2668q qVar3 = qVar2;
            t5 = G02;
            qVar = qVar3;
        }
        a5.m();
        TextView textView5 = this.f17974h;
        if (textView5 == null) {
            t.w("tvActionAppInfoSelected");
            textView5 = null;
        }
        textView5.setVisibility(8);
        if (fVar.A() >= 0 && C2657f.f25002J0.d(fVar.o())) {
            TextView textView6 = this.f17974h;
            if (textView6 == null) {
                t.w("tvActionAppInfoSelected");
            } else {
                textView = textView6;
            }
            boolean z6 = false;
            textView.setVisibility(0);
            if (!UptodownApp.f13477F.S("downloadApkWorker", aVar) || !DownloadWorker.f21359d.j(fVar.e())) {
                z4 = false;
            } else {
                z4 = true;
            }
            if (qVar == null || !qVar.f()) {
                z5 = false;
            } else {
                z5 = true;
            }
            if (qVar != null && qVar.M()) {
                z6 = true;
            }
            boolean v5 = new C2954m().v(fVar.S(), aVar);
            if (z5) {
                if (t5 != null) {
                    String string = aVar.getString(R.string.updates_button_update_app);
                    t.d(string, "getString(...)");
                    z(string);
                } else if (!v5) {
                    String string2 = aVar.getString(R.string.option_button_install);
                    t.d(string2, "getString(...)");
                    z(string2);
                } else {
                    String string3 = aVar.getString(R.string.open);
                    t.d(string3, "getString(...)");
                    x(string3);
                }
            } else if (qVar != null && (z4 || z6)) {
                y(qVar, aVar);
            } else if (v5) {
                String string4 = aVar.getString(R.string.open);
                t.d(string4, "getString(...)");
                x(string4);
            } else {
                String string5 = aVar.getString(R.string.option_button_install);
                t.d(string5, "getString(...)");
                x(string5);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void C(g gVar, C1598a aVar, View view) {
        gVar.m(aVar);
        gVar.l(aVar);
        a aVar2 = gVar.f17969c;
        if (aVar2 != null) {
            aVar2.b(gVar.f17967a);
        }
    }

    /* access modifiers changed from: private */
    public static final void D(g gVar, View view) {
        gVar.f17968b.setVisibility(8);
        a aVar = gVar.f17969c;
        if (aVar != null) {
            aVar.a(gVar.f17967a);
        }
    }

    /* access modifiers changed from: private */
    public static final void E(g gVar, View view) {
        gVar.f17968b.setVisibility(8);
        a aVar = gVar.f17969c;
        if (aVar != null) {
            aVar.a(gVar.f17967a);
        }
    }

    /* access modifiers changed from: private */
    public static final void F(C1598a aVar, g gVar, LifecycleCoroutineScope lifecycleCoroutineScope, S s5, Q q5, View view) {
        UptodownApp.a aVar2 = UptodownApp.f13477F;
        if (!aVar2.Z()) {
            return;
        }
        if (V.f24870q.h(aVar) == null) {
            aVar.startActivity(new Intent(aVar, LoginActivity.class), aVar2.a(aVar));
            return;
        }
        if (gVar.f17967a.F0() == 1) {
            new g2.w(aVar, lifecycleCoroutineScope).g(gVar.f17967a.e(), s5);
        } else {
            new g2.w(aVar, lifecycleCoroutineScope).e(gVar.f17967a.e(), q5);
        }
        new Handler(Looper.getMainLooper()).postDelayed(new f(gVar, aVar), 1000);
    }

    /* access modifiers changed from: private */
    public static final void G(g gVar, C1598a aVar) {
        gVar.l(aVar);
    }

    /* access modifiers changed from: private */
    public static final void H(g gVar, C1598a aVar, View view) {
        gVar.l(aVar);
    }

    /* access modifiers changed from: private */
    public final void K(C1598a aVar) {
        ImageView imageView = this.f17978l;
        ImageView imageView2 = null;
        if (imageView == null) {
            t.w("ivLikeAppInfoSelected");
            imageView = null;
        }
        imageView.setBackground(ContextCompat.getDrawable(aVar, R.drawable.ripple_wishlist));
        ImageView imageView3 = this.f17978l;
        if (imageView3 == null) {
            t.w("ivLikeAppInfoSelected");
            imageView3 = null;
        }
        imageView3.setImageResource(R.drawable.vector_heart_blue);
        ImageView imageView4 = this.f17978l;
        if (imageView4 == null) {
            t.w("ivLikeAppInfoSelected");
        } else {
            imageView2 = imageView4;
        }
        imageView2.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public final void L(C1598a aVar) {
        ImageView imageView = this.f17978l;
        ImageView imageView2 = null;
        if (imageView == null) {
            t.w("ivLikeAppInfoSelected");
            imageView = null;
        }
        imageView.setBackground(ContextCompat.getDrawable(aVar, R.drawable.ripple_wishlist_added));
        ImageView imageView3 = this.f17978l;
        if (imageView3 == null) {
            t.w("ivLikeAppInfoSelected");
            imageView3 = null;
        }
        imageView3.setImageResource(R.drawable.vector_heart_white);
        ImageView imageView4 = this.f17978l;
        if (imageView4 == null) {
            t.w("ivLikeAppInfoSelected");
        } else {
            imageView2 = imageView4;
        }
        imageView2.setVisibility(0);
    }

    private final void M(C2668q qVar, C1598a aVar) {
        y(qVar, aVar);
        B2.c cVar = B2.c.f17333a;
        ProgressBar progressBar = this.f17980n;
        TextView textView = null;
        if (progressBar == null) {
            t.w("pbAppInfoSelected");
            progressBar = null;
        }
        ImageView imageView = this.f17972f;
        if (imageView == null) {
            t.w("ivLogoAppInfoSelected");
            imageView = null;
        }
        cVar.e(progressBar, imageView);
        LinearLayout linearLayout = this.f17979m;
        if (linearLayout == null) {
            t.w("llAppInfoSelected");
            linearLayout = null;
        }
        linearLayout.setVisibility(8);
        TextView textView2 = this.f17975i;
        if (textView2 == null) {
            t.w("tvAuthorAppInfoSelected");
        } else {
            textView = textView2;
        }
        textView.setVisibility(0);
    }

    private final void O(C2668q qVar, C1598a aVar) {
        y(qVar, aVar);
        B2.c cVar = B2.c.f17333a;
        ProgressBar progressBar = this.f17980n;
        TextView textView = null;
        if (progressBar == null) {
            t.w("pbAppInfoSelected");
            progressBar = null;
        }
        ImageView imageView = this.f17972f;
        if (imageView == null) {
            t.w("ivLogoAppInfoSelected");
            imageView = null;
        }
        cVar.e(progressBar, imageView);
        ProgressBar progressBar2 = this.f17980n;
        if (progressBar2 == null) {
            t.w("pbAppInfoSelected");
            progressBar2 = null;
        }
        progressBar2.setProgress(qVar.x());
        TextView textView2 = this.f17981o;
        if (textView2 == null) {
            t.w("tvProgressAppInfoSelected");
            textView2 = null;
        }
        textView2.setText(aVar.getString(R.string.percent_of_total_size, new Object[]{Integer.valueOf(qVar.x()), new C2291k().d(qVar.z(), aVar)}));
        LinearLayout linearLayout = this.f17979m;
        if (linearLayout == null) {
            t.w("llAppInfoSelected");
            linearLayout = null;
        }
        linearLayout.setVisibility(0);
        TextView textView3 = this.f17975i;
        if (textView3 == null) {
            t.w("tvAuthorAppInfoSelected");
        } else {
            textView = textView3;
        }
        textView.setVisibility(8);
    }

    private final void m(C1598a aVar) {
        T t5;
        C2940B a5 = C2940B.f26458v.a(aVar);
        a5.a();
        String S4 = this.f17967a.S();
        t.b(S4);
        C2655d Y4 = a5.Y(S4);
        C2668q qVar = null;
        if (Y4 != null) {
            String S5 = this.f17967a.S();
            t.b(S5);
            t5 = a5.G0(S5);
            if (t5 != null) {
                qVar = t5.b(aVar);
            }
        } else {
            String S6 = this.f17967a.S();
            t.b(S6);
            C2668q k02 = a5.k0(S6, this.f17967a.J());
            t5 = null;
            qVar = k02;
        }
        a5.m();
        if (qVar != null) {
            DownloadWorker.a aVar2 = DownloadWorker.f21359d;
            if (aVar2.k(this.f17967a.e(), this.f17967a.J())) {
                aVar2.d(this.f17967a.e());
                qVar.T(aVar);
            } else if (qVar.f()) {
                File n5 = qVar.n();
                if (n5 != null) {
                    UptodownApp.f13477F.U(n5, aVar, this.f17967a.O());
                }
            } else {
                qVar.T(aVar);
            }
        } else if ((Y4 == null || t5 != null) && ((Y4 == null || Y4.e() != 1) && (t5 == null || !t5.m()))) {
            o(this.f17967a, aVar);
        } else {
            v(this.f17967a.S(), aVar);
        }
    }

    private final void n(C1598a aVar) {
        B2.c cVar = B2.c.f17333a;
        ProgressBar progressBar = this.f17980n;
        TextView textView = null;
        if (progressBar == null) {
            t.w("pbAppInfoSelected");
            progressBar = null;
        }
        ImageView imageView = this.f17972f;
        if (imageView == null) {
            t.w("ivLogoAppInfoSelected");
            imageView = null;
        }
        cVar.c(progressBar, imageView);
        LinearLayout linearLayout = this.f17979m;
        if (linearLayout == null) {
            t.w("llAppInfoSelected");
            linearLayout = null;
        }
        linearLayout.setVisibility(8);
        TextView textView2 = this.f17975i;
        if (textView2 == null) {
            t.w("tvAuthorAppInfoSelected");
        } else {
            textView = textView2;
        }
        textView.setVisibility(0);
        String string = aVar.getString(R.string.option_button_install);
        t.d(string, "getString(...)");
        x(string);
    }

    private final void o(C2657f fVar, C1598a aVar) {
        UptodownApp.f13477F.a0(fVar, aVar);
    }

    private final void p(boolean z4, C1598a aVar) {
        String str;
        if (z4) {
            str = aVar.getString(R.string.updates_button_update_app);
        } else {
            str = aVar.getString(R.string.option_button_install);
        }
        z(str);
        B2.c cVar = B2.c.f17333a;
        ProgressBar progressBar = this.f17980n;
        TextView textView = null;
        if (progressBar == null) {
            t.w("pbAppInfoSelected");
            progressBar = null;
        }
        ImageView imageView = this.f17972f;
        if (imageView == null) {
            t.w("ivLogoAppInfoSelected");
            imageView = null;
        }
        cVar.c(progressBar, imageView);
        LinearLayout linearLayout = this.f17979m;
        if (linearLayout == null) {
            t.w("llAppInfoSelected");
            linearLayout = null;
        }
        linearLayout.setVisibility(8);
        TextView textView2 = this.f17975i;
        if (textView2 == null) {
            t.w("tvAuthorAppInfoSelected");
        } else {
            textView = textView2;
        }
        textView.setVisibility(0);
    }

    private final void u(C1598a aVar, long j5, LifecycleCoroutineScope lifecycleCoroutineScope) {
        new C2388j(aVar, j5, new d(this, aVar), lifecycleCoroutineScope);
    }

    private final void v(String str, C1598a aVar) {
        Intent launchIntentForPackage;
        if (str != null && str.length() != 0 && (launchIntentForPackage = aVar.getPackageManager().getLaunchIntentForPackage(str)) != null) {
            aVar.startActivity(launchIntentForPackage);
        }
    }

    private final void x(String str) {
        B2.c cVar = B2.c.f17333a;
        ProgressBar progressBar = this.f17980n;
        TextView textView = null;
        if (progressBar == null) {
            t.w("pbAppInfoSelected");
            progressBar = null;
        }
        ImageView imageView = this.f17972f;
        if (imageView == null) {
            t.w("ivLogoAppInfoSelected");
            imageView = null;
        }
        cVar.c(progressBar, imageView);
        TextView textView2 = this.f17974h;
        if (textView2 == null) {
            t.w("tvActionAppInfoSelected");
            textView2 = null;
        }
        textView2.setText(str);
        TextView textView3 = this.f17974h;
        if (textView3 == null) {
            t.w("tvActionAppInfoSelected");
            textView3 = null;
        }
        v.a(textView3);
        LinearLayout linearLayout = this.f17979m;
        if (linearLayout == null) {
            t.w("llAppInfoSelected");
            linearLayout = null;
        }
        linearLayout.setVisibility(8);
        TextView textView4 = this.f17975i;
        if (textView4 == null) {
            t.w("tvAuthorAppInfoSelected");
        } else {
            textView = textView4;
        }
        textView.setVisibility(0);
    }

    private final void y(C2668q qVar, C1598a aVar) {
        B2.c cVar = B2.c.f17333a;
        ProgressBar progressBar = this.f17980n;
        ProgressBar progressBar2 = null;
        if (progressBar == null) {
            t.w("pbAppInfoSelected");
            progressBar = null;
        }
        ImageView imageView = this.f17972f;
        if (imageView == null) {
            t.w("ivLogoAppInfoSelected");
            imageView = null;
        }
        cVar.e(progressBar, imageView);
        TextView textView = this.f17975i;
        if (textView == null) {
            t.w("tvAuthorAppInfoSelected");
            textView = null;
        }
        textView.setVisibility(8);
        LinearLayout linearLayout = this.f17979m;
        if (linearLayout == null) {
            t.w("llAppInfoSelected");
            linearLayout = null;
        }
        linearLayout.setVisibility(0);
        TextView textView2 = this.f17974h;
        if (textView2 == null) {
            t.w("tvActionAppInfoSelected");
            textView2 = null;
        }
        textView2.setText(R.string.option_button_cancel);
        TextView textView3 = this.f17974h;
        if (textView3 == null) {
            t.w("tvActionAppInfoSelected");
            textView3 = null;
        }
        v.b(textView3);
        if (qVar.x() == 0) {
            TextView textView4 = this.f17981o;
            if (textView4 == null) {
                t.w("tvProgressAppInfoSelected");
                textView4 = null;
            }
            textView4.setText(aVar.getString(R.string.status_download_update_pending));
            ProgressBar progressBar3 = this.f17980n;
            if (progressBar3 == null) {
                t.w("pbAppInfoSelected");
            } else {
                progressBar2 = progressBar3;
            }
            progressBar2.setIndeterminate(true);
            return;
        }
        ProgressBar progressBar4 = this.f17980n;
        if (progressBar4 == null) {
            t.w("pbAppInfoSelected");
            progressBar4 = null;
        }
        progressBar4.setIndeterminate(false);
        TextView textView5 = this.f17981o;
        if (textView5 == null) {
            t.w("tvProgressAppInfoSelected");
            textView5 = null;
        }
        textView5.setText(aVar.getString(R.string.percent_of_total_size, new Object[]{Integer.valueOf(qVar.x()), new C2291k().d(qVar.z(), aVar)}));
        ProgressBar progressBar5 = this.f17980n;
        if (progressBar5 == null) {
            t.w("pbAppInfoSelected");
        } else {
            progressBar2 = progressBar5;
        }
        progressBar2.setProgress(qVar.x());
    }

    private final void z(String str) {
        B2.c cVar = B2.c.f17333a;
        ProgressBar progressBar = this.f17980n;
        TextView textView = null;
        if (progressBar == null) {
            t.w("pbAppInfoSelected");
            progressBar = null;
        }
        ImageView imageView = this.f17972f;
        if (imageView == null) {
            t.w("ivLogoAppInfoSelected");
            imageView = null;
        }
        cVar.c(progressBar, imageView);
        TextView textView2 = this.f17974h;
        if (textView2 == null) {
            t.w("tvActionAppInfoSelected");
            textView2 = null;
        }
        textView2.setText(str);
        TextView textView3 = this.f17974h;
        if (textView3 == null) {
            t.w("tvActionAppInfoSelected");
            textView3 = null;
        }
        v.c(textView3);
        LinearLayout linearLayout = this.f17979m;
        if (linearLayout == null) {
            t.w("llAppInfoSelected");
            linearLayout = null;
        }
        linearLayout.setVisibility(8);
        TextView textView4 = this.f17975i;
        if (textView4 == null) {
            t.w("tvAuthorAppInfoSelected");
        } else {
            textView = textView4;
        }
        textView.setVisibility(0);
    }

    public final void B(C1598a aVar, LifecycleCoroutineScope lifecycleCoroutineScope) {
        t.e(aVar, "activity");
        t.e(lifecycleCoroutineScope, "scope");
        f fVar = new f(aVar, this);
        C0174g gVar = new C0174g(aVar, this);
        J(this.f17968b.findViewById(R.id.v_background_app_info_selected));
        t().setVisibility(0);
        I((RelativeLayout) this.f17968b.findViewById(R.id.rl_app_info_selected));
        this.f17972f = (ImageView) this.f17968b.findViewById(R.id.iv_logo_app_info_selected);
        this.f17973g = (TextView) this.f17968b.findViewById(R.id.tv_name_app_info_selected);
        this.f17975i = (TextView) this.f17968b.findViewById(R.id.tv_author_app_info_selected);
        this.f17979m = (LinearLayout) this.f17968b.findViewById(R.id.ll_download_app_info_selected);
        this.f17980n = (ProgressBar) this.f17968b.findViewById(R.id.pb_progress_app_info_selected);
        this.f17981o = (TextView) this.f17968b.findViewById(R.id.tv_progress_app_info_selected);
        this.f17976j = (TextView) this.f17968b.findViewById(R.id.tv_verified_app_info_selected);
        this.f17977k = (TextView) this.f17968b.findViewById(R.id.tv_valoration_app_info_selected);
        this.f17974h = (TextView) this.f17968b.findViewById(R.id.tv_action_app_info_selected);
        this.f17978l = (ImageView) this.f17968b.findViewById(R.id.iv_wishlist_action_app_info_selected);
        TextView textView = this.f17973g;
        if (textView == null) {
            t.w("tvNameAppInfoSelected");
            textView = null;
        }
        k.a aVar2 = k.f32g;
        textView.setTypeface(aVar2.w());
        TextView textView2 = this.f17975i;
        if (textView2 == null) {
            t.w("tvAuthorAppInfoSelected");
            textView2 = null;
        }
        textView2.setTypeface(aVar2.x());
        TextView textView3 = this.f17981o;
        if (textView3 == null) {
            t.w("tvProgressAppInfoSelected");
            textView3 = null;
        }
        textView3.setTypeface(aVar2.x());
        TextView textView4 = this.f17976j;
        if (textView4 == null) {
            t.w("tvVerifiedAppInfoSelected");
            textView4 = null;
        }
        textView4.setTypeface(aVar2.x());
        TextView textView5 = this.f17977k;
        if (textView5 == null) {
            t.w("tvValorationAppInfoSelected");
            textView5 = null;
        }
        textView5.setTypeface(aVar2.x());
        TextView textView6 = this.f17974h;
        if (textView6 == null) {
            t.w("tvActionAppInfoSelected");
            textView6 = null;
        }
        textView6.setTypeface(aVar2.w());
        ImageView imageView = this.f17972f;
        if (imageView == null) {
            t.w("ivLogoAppInfoSelected");
            imageView = null;
        }
        imageView.setScaleX(1.0f);
        ImageView imageView2 = this.f17972f;
        if (imageView2 == null) {
            t.w("ivLogoAppInfoSelected");
            imageView2 = null;
        }
        imageView2.setScaleY(1.0f);
        ProgressBar progressBar = this.f17980n;
        if (progressBar == null) {
            t.w("pbAppInfoSelected");
            progressBar = null;
        }
        progressBar.setVisibility(8);
        A(aVar, this.f17967a);
        if (this.f17967a.F0() == 1) {
            L(aVar);
        } else {
            ImageView imageView3 = this.f17978l;
            if (imageView3 == null) {
                t.w("ivLikeAppInfoSelected");
                imageView3 = null;
            }
            imageView3.setVisibility(8);
            u(aVar, this.f17967a.e(), lifecycleCoroutineScope);
        }
        TextView textView7 = this.f17974h;
        if (textView7 == null) {
            t.w("tvActionAppInfoSelected");
            textView7 = null;
        }
        textView7.setOnClickListener(new a(this, aVar));
        ImageView imageView4 = this.f17972f;
        if (imageView4 == null) {
            t.w("ivLogoAppInfoSelected");
            imageView4 = null;
        }
        imageView4.setOnClickListener(new b(this));
        TextView textView8 = this.f17973g;
        if (textView8 == null) {
            t.w("tvNameAppInfoSelected");
            textView8 = null;
        }
        textView8.setOnClickListener(new c(this));
        ImageView imageView5 = this.f17978l;
        if (imageView5 == null) {
            t.w("ivLikeAppInfoSelected");
            imageView5 = null;
        }
        C1598a aVar3 = aVar;
        imageView5.setOnClickListener(new d(aVar3, this, lifecycleCoroutineScope, gVar, fVar));
        t().setOnClickListener(new e(this, aVar3));
        if (this.f17968b.getVisibility() != 0) {
            this.f17968b.setVisibility(0);
            new n(aVar3).h(r(), R.anim.slide_in_bottom);
        }
        r().setVisibility(0);
    }

    public final void I(RelativeLayout relativeLayout) {
        t.e(relativeLayout, "<set-?>");
        this.f17971e = relativeLayout;
    }

    public final void J(View view) {
        t.e(view, "<set-?>");
        this.f17970d = view;
    }

    public final void N(C2668q qVar, int i5, C1598a aVar) {
        t.e(qVar, "download");
        t.e(aVar, "activity");
        if (qVar.h() == this.f17967a.e()) {
            if (i5 != 205) {
                if (i5 != 207) {
                    switch (i5) {
                        case 200:
                            break;
                        case 201:
                            O(qVar, aVar);
                            return;
                        case 202:
                            p(new C2954m().v(qVar.w(), aVar), aVar);
                            return;
                        default:
                            return;
                    }
                } else {
                    n(aVar);
                    return;
                }
            }
            M(qVar, aVar);
        }
    }

    public final boolean l(C1598a aVar) {
        t.e(aVar, "activity");
        if (this.f17968b.getVisibility() != 0) {
            return false;
        }
        if (!com.uptodown.activities.preferences.a.f15150a.P(aVar) || UptodownApp.f13477F.P() || !this.f17982p.compareAndSet(false, true)) {
            this.f17968b.setVisibility(8);
        } else {
            new n(aVar).g(r(), R.anim.slide_out_bottom, new b(aVar, this, new c(this)));
        }
        return true;
    }

    public final C2657f q() {
        return this.f17967a;
    }

    public final RelativeLayout r() {
        RelativeLayout relativeLayout = this.f17971e;
        if (relativeLayout != null) {
            return relativeLayout;
        }
        t.w("rlAppInfoSelected");
        return null;
    }

    public final RelativeLayout s() {
        return this.f17968b;
    }

    public final View t() {
        View view = this.f17970d;
        if (view != null) {
            return view;
        }
        t.w("vBackground");
        return null;
    }

    public final void w(C2657f fVar) {
        t.e(fVar, "<set-?>");
        this.f17967a = fVar;
    }

    public static final class f implements Q {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1598a f17991a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g f17992b;

        f(C1598a aVar, g gVar) {
            this.f17991a = aVar;
            this.f17992b = gVar;
        }

        public void d() {
            if (!this.f17991a.isFinishing() && this.f17992b.s().getVisibility() == 0) {
                this.f17992b.L(this.f17991a);
                C1598a aVar = this.f17991a;
                String string = aVar.getString(R.string.action_added_to_wishlist, new Object[]{this.f17992b.q().N()});
                t.d(string, "getString(...)");
                aVar.u0(string);
            }
        }

        public void a() {
        }
    }

    /* renamed from: D2.g$g  reason: collision with other inner class name */
    public static final class C0174g implements S {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1598a f17993a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g f17994b;

        C0174g(C1598a aVar, g gVar) {
            this.f17993a = aVar;
            this.f17994b = gVar;
        }

        public void f() {
            if (!this.f17993a.isFinishing()) {
                if (this.f17994b.s().getVisibility() == 0) {
                    this.f17994b.K(this.f17993a);
                }
                C1598a aVar = this.f17993a;
                String string = aVar.getString(R.string.action_removed_from_wishlist, new Object[]{this.f17994b.q().N()});
                t.d(string, "getString(...)");
                aVar.u0(string);
            }
        }

        public void a() {
        }
    }

    public static final class b implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C1598a f17984a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ g f17985b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ c f17986c;

        b(C1598a aVar, g gVar, c cVar) {
            this.f17984a = aVar;
            this.f17985b = gVar;
            this.f17986c = cVar;
        }

        public void onAnimationEnd(Animation animation) {
            this.f17985b.r().setVisibility(8);
            this.f17985b.s().setVisibility(8);
            this.f17985b.f17982p.set(false);
        }

        public void onAnimationStart(Animation animation) {
            new n(this.f17984a).g(this.f17985b.t(), R.anim.fade_out, this.f17986c);
        }

        public void onAnimationRepeat(Animation animation) {
        }
    }

    public static final class c implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f17987a;

        c(g gVar) {
            this.f17987a = gVar;
        }

        public void onAnimationEnd(Animation animation) {
            this.f17987a.t().setVisibility(8);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    public static final class d implements C2610u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ g f17988a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C1598a f17989b;

        d(g gVar, C1598a aVar) {
            this.f17988a = gVar;
            this.f17989b = aVar;
        }

        public void c(C2657f fVar) {
            t.e(fVar, "appInfo");
            this.f17988a.w(fVar);
            if (this.f17988a.s().getVisibility() == 0) {
                g gVar = this.f17988a;
                gVar.A(this.f17989b, gVar.q());
                if (this.f17988a.q().F0() == 1) {
                    this.f17988a.L(this.f17989b);
                } else {
                    this.f17988a.K(this.f17989b);
                }
            }
        }

        public void d(int i5) {
        }
    }
}
