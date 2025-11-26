package i2;

import B2.c;
import B2.k;
import B2.s;
import B2.v;
import D2.n;
import M1.b;
import S1.j;
import S1.k;
import U1.C2201a;
import W1.C2209b;
import W1.C2210c;
import W2.C2219h;
import W2.C2223l;
import W2.q;
import W2.u;
import X1.C2227d;
import X1.C2231h;
import X1.m;
import X2.C2250q;
import Y1.C2257a;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.animation.Animation;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.SwitchCompat;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.widget.NestedScrollView;
import androidx.documentfile.provider.DocumentFile;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import b2.C2275G;
import b2.C2277I;
import b2.C2279K;
import b2.C2291k;
import b2.C2292l;
import b2.C2301u;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.newinterstitial.out.MBNewInterstitialHandler;
import com.mbridge.msdk.newinterstitial.out.NewInterstitialListener;
import com.mbridge.msdk.out.BannerAdListener;
import com.mbridge.msdk.out.BannerSize;
import com.mbridge.msdk.out.MBBannerView;
import com.mbridge.msdk.out.MBridgeIds;
import com.mbridge.msdk.out.RewardInfo;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.AppInstalledDetailsActivity;
import com.uptodown.activities.C1598a;
import com.uptodown.activities.FreeUpSpaceActivity;
import com.uptodown.activities.Gallery;
import com.uptodown.activities.InformationActivity;
import com.uptodown.activities.LoginActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MoreInfo;
import com.uptodown.activities.OldVersionsActivity;
import com.uptodown.activities.OrganizationActivity;
import com.uptodown.activities.PublicProfileActivity;
import com.uptodown.activities.RepliesActivity;
import com.uptodown.activities.ReviewsActivity;
import com.uptodown.activities.SearchActivity;
import com.uptodown.activities.VirusTotalReport;
import com.uptodown.activities.YouTubeActivity;
import com.uptodown.activities.preferences.a;
import com.uptodown.util.views.UsernameTextView;
import com.uptodown.workers.DownloadApkWorker;
import com.uptodown.workers.DownloadWorker;
import com.uptodown.workers.GenerateQueueWorker;
import com.uptodown.workers.GetUserDataWorker;
import g2.C2388j;
import g2.C2391m;
import g2.C2392n;
import h2.C2398B;
import h2.C2403b;
import h2.C2415h;
import h2.C2419j;
import h2.C2421k;
import h2.C2431p;
import h2.C2436s;
import h2.C2446x;
import h2.C2448y;
import h2.K0;
import h2.M0;
import h2.O0;
import h2.Y0;
import h2.w1;
import i2.B1;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import k2.C2591a;
import k2.C2594d;
import k2.C2601k;
import k2.C2610u;
import k3.C2616a;
import k3.p;
import kotlin.coroutines.jvm.internal.d;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2641A;
import l2.C2647G;
import l2.C2648H;
import l2.C2654c;
import l2.C2655d;
import l2.C2657f;
import l2.C2660i;
import l2.C2661j;
import l2.C2666o;
import l2.C2667p;
import l2.C2668q;
import l2.C2669s;
import l2.V;
import l2.r;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import z2.C2940B;
import z2.C2942a;
import z2.C2954m;
import z2.C2962v;
import z2.O;
import z2.Z;
import z3.C2973f;
import z3.w;

/* renamed from: i2.v1  reason: case insensitive filesystem */
public final class C2540v1 extends Fragment {

    /* renamed from: o  reason: collision with root package name */
    public static final C2541a f24347o = new C2541a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    public C2657f f24348a;

    /* renamed from: b  reason: collision with root package name */
    private C2403b f24349b;

    /* renamed from: c  reason: collision with root package name */
    private final C2223l f24350c = FragmentViewModelLazyKt.createViewModelLazy(this, kotlin.jvm.internal.M.b(B1.class), new W(new V(this)), (C2616a) null);

    /* renamed from: d  reason: collision with root package name */
    private z2.F f24351d;

    /* renamed from: e  reason: collision with root package name */
    private AlertDialog f24352e;

    /* renamed from: f  reason: collision with root package name */
    private ArrayList f24353f;

    /* renamed from: g  reason: collision with root package name */
    private Menu f24354g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public R1.K f24355h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public R1.K f24356i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public ArrayList f24357j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    private final double f24358k = 0.9d;

    /* renamed from: l  reason: collision with root package name */
    private final C2553m f24359l = new C2553m(this);

    /* renamed from: m  reason: collision with root package name */
    private final ActivityResultLauncher f24360m;

    /* renamed from: n  reason: collision with root package name */
    private final ActivityResultLauncher f24361n;

    /* renamed from: i2.v1$A */
    static final class A extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24362a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24363b;

        /* renamed from: i2.v1$A$a */
        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C2540v1 f24364a;

            a(C2540v1 v1Var) {
                this.f24364a = v1Var;
            }

            /* renamed from: b */
            public final Object emit(z2.O o5, C2308e eVar) {
                if (!(o5 instanceof O.a)) {
                    if (o5 instanceof O.c) {
                        O.c cVar = (O.c) o5;
                        ArrayList b5 = ((B1.C2465b) cVar.a()).b();
                        if (b5 == null || b5.isEmpty()) {
                            ArrayList a5 = ((B1.C2465b) cVar.a()).a();
                            if (a5 != null && !a5.isEmpty()) {
                                this.f24364a.E5(((B1.C2465b) cVar.a()).a());
                            }
                        } else {
                            this.f24364a.d6(((B1.C2465b) cVar.a()).b());
                        }
                    } else if (!(o5 instanceof O.b)) {
                        throw new q();
                    }
                }
                return W2.J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        A(C2540v1 v1Var, C2308e eVar) {
            super(2, eVar);
            this.f24363b = v1Var;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new A(this.f24363b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f24362a;
            if (i5 == 0) {
                u.b(obj);
                z3.D H4 = this.f24363b.f4().H();
                a aVar = new a(this.f24363b);
                this.f24362a = 1;
                if (H4.collect(aVar, this) == f5) {
                    return f5;
                }
            } else if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                u.b(obj);
            }
            throw new C2219h();
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((A) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: i2.v1$B */
    static final class B extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24365a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24366b;

        /* renamed from: i2.v1$B$a */
        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C2540v1 f24367a;

            a(C2540v1 v1Var) {
                this.f24367a = v1Var;
            }

            /* renamed from: b */
            public final Object emit(z2.O o5, C2308e eVar) {
                if (!(o5 instanceof O.a)) {
                    if (o5 instanceof O.c) {
                        O.c cVar = (O.c) o5;
                        this.f24367a.a6(((B1.c) cVar.a()).b());
                        this.f24367a.I5(((B1.c) cVar.a()).a());
                    } else if (!(o5 instanceof O.b)) {
                        throw new q();
                    }
                }
                return W2.J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        B(C2540v1 v1Var, C2308e eVar) {
            super(2, eVar);
            this.f24366b = v1Var;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new B(this.f24366b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f24365a;
            if (i5 == 0) {
                u.b(obj);
                z3.D J4 = this.f24366b.f4().J();
                a aVar = new a(this.f24366b);
                this.f24365a = 1;
                if (J4.collect(aVar, this) == f5) {
                    return f5;
                }
            } else if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                u.b(obj);
            }
            throw new C2219h();
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((B) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: i2.v1$C */
    static final class C extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24368a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24369b;

        /* renamed from: i2.v1$C$a */
        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C2540v1 f24370a;

            a(C2540v1 v1Var) {
                this.f24370a = v1Var;
            }

            /* renamed from: b */
            public final Object emit(z2.O o5, C2308e eVar) {
                l2.O o6;
                if (!t.a(o5, O.a.f26507a)) {
                    if (o5 instanceof O.c) {
                        Iterator it = ((Iterable) this.f24370a.f4().b0().getValue()).iterator();
                        int i5 = 0;
                        while (true) {
                            if (!it.hasNext()) {
                                i5 = -1;
                                o6 = null;
                                break;
                            }
                            int i6 = i5 + 1;
                            o6 = (l2.O) it.next();
                            O.c cVar = (O.c) o5;
                            if (t.a(o6.m(), ((B1.d) cVar.a()).b())) {
                                o6.v(((B1.d) cVar.a()).a());
                                break;
                            }
                            i5 = i6;
                        }
                        if (i5 >= 0 && o6 != null && i5 < ((ArrayList) this.f24370a.f4().b0().getValue()).size()) {
                            this.f24370a.o7(o6, i5);
                        }
                    } else if (!t.a(o5, O.b.f26508a)) {
                        throw new q();
                    }
                }
                return W2.J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C(C2540v1 v1Var, C2308e eVar) {
            super(2, eVar);
            this.f24369b = v1Var;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C(this.f24369b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f24368a;
            if (i5 == 0) {
                u.b(obj);
                z3.D P4 = this.f24369b.f4().P();
                a aVar = new a(this.f24369b);
                this.f24368a = 1;
                if (P4.collect(aVar, this) == f5) {
                    return f5;
                }
            } else if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                u.b(obj);
            }
            throw new C2219h();
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((C) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: i2.v1$D */
    static final class D extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24371a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24372b;

        /* renamed from: i2.v1$D$a */
        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C2540v1 f24373a;

            a(C2540v1 v1Var) {
                this.f24373a = v1Var;
            }

            /* access modifiers changed from: private */
            public static final void d(C2540v1 v1Var, z2.O o5, View view) {
                if (UptodownApp.f13477F.Z()) {
                    v1Var.a7((ArrayList) ((O.c) o5).a());
                }
            }

            /* renamed from: c */
            public final Object emit(z2.O o5, C2308e eVar) {
                if (!(o5 instanceof O.a)) {
                    if (o5 instanceof O.c) {
                        O.c cVar = (O.c) o5;
                        if (!((Collection) cVar.a()).isEmpty()) {
                            Iterator it = ((ArrayList) cVar.a()).iterator();
                            t.d(it, "iterator(...)");
                            while (true) {
                                if (!it.hasNext()) {
                                    this.f24373a.b4().f22770L.f23092c.setVisibility(8);
                                    this.f24373a.h4(com.uptodown.R.id.action_remote_install);
                                    break;
                                }
                                Object next = it.next();
                                t.d(next, "next(...)");
                                if (((l2.Z) next).c() == 1) {
                                    if (((Number) this.f24373a.f4().Q().getValue()).intValue() == -1) {
                                        this.f24373a.b4().f22770L.f23092c.setVisibility(0);
                                    }
                                    this.f24373a.Z6(com.uptodown.R.id.action_remote_install);
                                    this.f24373a.b4().f22770L.f23092c.setOnClickListener(new A1(this.f24373a, o5));
                                }
                            }
                        } else {
                            this.f24373a.b4().f22770L.f23092c.setVisibility(8);
                            this.f24373a.h4(com.uptodown.R.id.action_remote_install);
                        }
                    } else if (!(o5 instanceof O.b)) {
                        throw new q();
                    }
                }
                return W2.J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        D(C2540v1 v1Var, C2308e eVar) {
            super(2, eVar);
            this.f24372b = v1Var;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new D(this.f24372b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f24371a;
            if (i5 == 0) {
                u.b(obj);
                z3.D l02 = this.f24372b.f4().l0();
                a aVar = new a(this.f24372b);
                this.f24371a = 1;
                if (l02.collect(aVar, this) == f5) {
                    return f5;
                }
            } else if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                u.b(obj);
            }
            throw new C2219h();
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((D) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: i2.v1$F */
    public static final class F implements k2.Z {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24375a;

        F(C2540v1 v1Var) {
            this.f24375a = v1Var;
        }

        public void a(l2.L l5) {
            t.e(l5, "reportVT");
            if (this.f24375a.getActivity() != null && !this.f24375a.requireActivity().isFinishing()) {
                Intent intent = new Intent(this.f24375a.requireActivity(), VirusTotalReport.class);
                intent.putExtra("appInfo", this.f24375a.a4());
                intent.putExtra("appReportVT", l5);
                C2540v1 v1Var = this.f24375a;
                UptodownApp.a aVar = UptodownApp.f13477F;
                FragmentActivity requireActivity = v1Var.requireActivity();
                t.d(requireActivity, "requireActivity(...)");
                v1Var.startActivity(intent, aVar.a(requireActivity));
                this.f24375a.f4().m0().setValue(Boolean.FALSE);
            }
        }

        public void b() {
            if (this.f24375a.getActivity() != null && !this.f24375a.requireActivity().isFinishing()) {
                String q02 = this.f24375a.a4().q0();
                if (!(q02 == null || q02.length() == 0)) {
                    String q03 = this.f24375a.a4().q0();
                    t.b(q03);
                    if (Long.parseLong(q03) > 650000000) {
                        Intent intent = new Intent(this.f24375a.requireActivity(), VirusTotalReport.class);
                        intent.putExtra("appInfo", this.f24375a.a4());
                        intent.putExtra("isVirusTotalReportAvaialable", false);
                        C2540v1 v1Var = this.f24375a;
                        UptodownApp.a aVar = UptodownApp.f13477F;
                        FragmentActivity requireActivity = v1Var.requireActivity();
                        t.d(requireActivity, "requireActivity(...)");
                        v1Var.startActivity(intent, aVar.a(requireActivity));
                        this.f24375a.f4().m0().setValue(Boolean.FALSE);
                        return;
                    }
                }
                FragmentActivity activity = this.f24375a.getActivity();
                t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                ((C1598a) activity).L2(this.f24375a.a4().n0());
            }
        }
    }

    /* renamed from: i2.v1$G */
    public static final class G implements b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24376a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Context f24377b;

        G(C2540v1 v1Var, Context context) {
            this.f24376a = v1Var;
            this.f24377b = context;
        }

        public void a(Exception exc) {
            t.e(exc, "e");
            exc.printStackTrace();
            C2540v1 v1Var = this.f24376a;
            v1Var.i6(v1Var.b4().f22773O.f22872b, this.f24377b);
        }

        public void onSuccess() {
            C2540v1 v1Var = this.f24376a;
            v1Var.i6(v1Var.b4().f22773O.f22872b, this.f24377b);
        }
    }

    /* renamed from: i2.v1$H */
    public static final class H implements C2594d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24378a;

        H(C2540v1 v1Var) {
            this.f24378a = v1Var;
        }

        public void b(C2657f fVar) {
            t.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            if (UptodownApp.f13477F.Z() && this.f24378a.getActivity() != null && !this.f24378a.requireActivity().isFinishing()) {
                this.f24378a.v5(fVar);
            }
        }
    }

    /* renamed from: i2.v1$I */
    public static final class I implements C2591a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24379a;

        I(C2540v1 v1Var) {
            this.f24379a = v1Var;
        }

        public void a(C2657f fVar, int i5) {
            t.e(fVar, "appInfo");
            this.f24379a.U6(fVar);
        }
    }

    /* renamed from: i2.v1$J */
    public static final class J implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ M0 f24380a;

        J(M0 m02) {
            this.f24380a = m02;
        }

        public boolean onPreDraw() {
            this.f24380a.f22512p.getViewTreeObserver().removeOnPreDrawListener(this);
            TextView textView = this.f24380a.f22512p;
            t.d(textView, "tvBodyReview");
            if (!s.a(textView)) {
                return true;
            }
            this.f24380a.f22517u.setVisibility(0);
            this.f24380a.f22517u.setTypeface(k.f32g.w());
            return true;
        }
    }

    /* renamed from: i2.v1$K */
    public static final class K implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ O0 f24381a;

        K(O0 o02) {
            this.f24381a = o02;
        }

        public boolean onPreDraw() {
            this.f24381a.f22568q.getViewTreeObserver().removeOnPreDrawListener(this);
            TextView textView = this.f24381a.f22568q;
            t.d(textView, "tvBodyReview");
            if (!s.a(textView)) {
                return true;
            }
            this.f24381a.f22573v.setVisibility(0);
            this.f24381a.f22573v.setTypeface(k.f32g.w());
            return true;
        }
    }

    /* renamed from: i2.v1$L */
    public static final class L implements k2.H {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24382a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f24383b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.L f24384c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ ArrayList f24385d;

        L(C2540v1 v1Var, ArrayList arrayList, kotlin.jvm.internal.L l5, ArrayList arrayList2) {
            this.f24382a = v1Var;
            this.f24383b = arrayList;
            this.f24384c = l5;
            this.f24385d = arrayList2;
        }

        public void a(l2.b0 b0Var) {
            t.e(b0Var, MimeTypes.BASE_TYPE_VIDEO);
            if (UptodownApp.f13477F.Z() && this.f24382a.getActivity() != null && !this.f24382a.requireActivity().isFinishing()) {
                Intent intent = new Intent(this.f24382a.getActivity(), YouTubeActivity.class);
                intent.putExtra("id_youtube", b0Var.a());
                this.f24382a.startActivity(intent);
            }
        }

        public void b(l2.P p5) {
            t.e(p5, "screenshot");
            this.f24383b.remove(p5);
            R1.D d5 = (R1.D) this.f24384c.f24690a;
            if (d5 != null) {
                d5.c(p5);
            }
        }

        public void c(l2.P p5) {
            t.e(p5, "screenshot");
            UptodownApp.a aVar = UptodownApp.f13477F;
            if (aVar.Z() && this.f24382a.getActivity() != null && !this.f24382a.requireActivity().isFinishing()) {
                Intent intent = new Intent(this.f24382a.requireActivity(), Gallery.class);
                Bundle bundle = new Bundle();
                bundle.putParcelableArrayList("images", this.f24383b);
                bundle.putInt("index", this.f24383b.indexOf(p5));
                intent.putExtra("bundle", bundle);
                C2540v1 v1Var = this.f24382a;
                FragmentActivity requireActivity = v1Var.requireActivity();
                t.d(requireActivity, "requireActivity(...)");
                v1Var.startActivity(intent, aVar.a(requireActivity));
            }
        }

        public void d(l2.b0 b0Var) {
            t.e(b0Var, MimeTypes.BASE_TYPE_VIDEO);
            this.f24385d.remove(b0Var);
            R1.D d5 = (R1.D) this.f24384c.f24690a;
            if (d5 != null) {
                d5.c(b0Var);
            }
        }
    }

    /* renamed from: i2.v1$M */
    public static final class M implements C2594d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24386a;

        M(C2540v1 v1Var) {
            this.f24386a = v1Var;
        }

        public void b(C2657f fVar) {
            t.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            if (UptodownApp.f13477F.Z() && this.f24386a.getActivity() != null && !this.f24386a.requireActivity().isFinishing()) {
                this.f24386a.v5(fVar);
            }
        }
    }

    /* renamed from: i2.v1$N */
    public static final class N implements C2591a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24387a;

        N(C2540v1 v1Var) {
            this.f24387a = v1Var;
        }

        public void a(C2657f fVar, int i5) {
            t.e(fVar, "appInfo");
            this.f24387a.U6(fVar);
        }
    }

    /* renamed from: i2.v1$O */
    public static final class O implements C2594d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24388a;

        O(C2540v1 v1Var) {
            this.f24388a = v1Var;
        }

        public void b(C2657f fVar) {
            t.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            if (UptodownApp.f13477F.Z() && this.f24388a.getActivity() != null && !this.f24388a.requireActivity().isFinishing()) {
                this.f24388a.v5(fVar);
            }
        }
    }

    /* renamed from: i2.v1$P */
    public static final class P implements C2591a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24389a;

        P(C2540v1 v1Var) {
            this.f24389a = v1Var;
        }

        public void a(C2657f fVar, int i5) {
            t.e(fVar, "appInfo");
            this.f24389a.U6(fVar);
        }
    }

    /* renamed from: i2.v1$Q */
    static final class Q extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24390a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24391b;

        /* renamed from: i2.v1$Q$a */
        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C2540v1 f24392a;

            /* renamed from: i2.v1$Q$a$a  reason: collision with other inner class name */
            static final class C0244a extends l implements p {

                /* renamed from: a  reason: collision with root package name */
                int f24393a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ C2540v1 f24394b;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C0244a(C2540v1 v1Var, C2308e eVar) {
                    super(2, eVar);
                    this.f24394b = v1Var;
                }

                public final C2308e create(Object obj, C2308e eVar) {
                    return new C0244a(this.f24394b, eVar);
                }

                public final Object invokeSuspend(Object obj) {
                    C2316b.f();
                    if (this.f24393a == 0) {
                        u.b(obj);
                        if (this.f24394b.a4().i0() == 1) {
                            C2540v1 v1Var = this.f24394b;
                            String string = v1Var.getString(com.uptodown.R.string.remove_recommended);
                            t.d(string, "getString(...)");
                            v1Var.p6(com.uptodown.R.id.action_recommended, string);
                            this.f24394b.b4().f22774P.setBackground(ContextCompat.getDrawable(this.f24394b.requireContext(), com.uptodown.R.drawable.ripple_blue_primary_button));
                            this.f24394b.b4().f22805k.setImageDrawable(ContextCompat.getDrawable(this.f24394b.requireContext(), com.uptodown.R.drawable.vector_bookmark_white));
                            this.f24394b.b4().f22824t0.setTextColor(ContextCompat.getColor(this.f24394b.requireContext(), com.uptodown.R.color.white));
                            this.f24394b.b4().f22824t0.setText(this.f24394b.getString(com.uptodown.R.string.remove_recommended));
                        } else {
                            C2540v1 v1Var2 = this.f24394b;
                            String string2 = v1Var2.getString(com.uptodown.R.string.add_recommended);
                            t.d(string2, "getString(...)");
                            v1Var2.p6(com.uptodown.R.id.action_recommended, string2);
                            this.f24394b.b4().f22774P.setBackground(ContextCompat.getDrawable(this.f24394b.requireContext(), com.uptodown.R.drawable.ripple_stroke_blue_primary));
                            this.f24394b.b4().f22805k.setImageDrawable(ContextCompat.getDrawable(this.f24394b.requireContext(), com.uptodown.R.drawable.vector_bookmark_stroke));
                            this.f24394b.b4().f22824t0.setTextColor(ContextCompat.getColor(this.f24394b.requireContext(), com.uptodown.R.color.text_terciary));
                            this.f24394b.b4().f22824t0.setText(this.f24394b.getString(com.uptodown.R.string.add_recommended));
                        }
                        return W2.J.f19942a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                public final Object invoke(w3.M m5, C2308e eVar) {
                    return ((C0244a) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
                }
            }

            a(C2540v1 v1Var) {
                this.f24392a = v1Var;
            }

            public final Object b(int i5, C2308e eVar) {
                this.f24392a.a4().X0(i5);
                Object g5 = C2872g.g(C2865c0.c(), new C0244a(this.f24392a, (C2308e) null), eVar);
                if (g5 == C2316b.f()) {
                    return g5;
                }
                return W2.J.f19942a;
            }

            public /* bridge */ /* synthetic */ Object emit(Object obj, C2308e eVar) {
                return b(((Number) obj).intValue(), eVar);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        Q(C2540v1 v1Var, C2308e eVar) {
            super(2, eVar);
            this.f24391b = v1Var;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new Q(this.f24391b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f24390a;
            if (i5 == 0) {
                u.b(obj);
                w Y4 = this.f24391b.f4().Y();
                a aVar = new a(this.f24391b);
                this.f24390a = 1;
                if (Y4.collect(aVar, this) == f5) {
                    return f5;
                }
            } else if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                u.b(obj);
            }
            throw new C2219h();
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((Q) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: i2.v1$R */
    public static final class R implements ViewTreeObserver.OnPreDrawListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f24395a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24396b;

        R(View view, C2540v1 v1Var) {
            this.f24395a = view;
            this.f24396b = v1Var;
        }

        public boolean onPreDraw() {
            this.f24395a.getViewTreeObserver().removeOnPreDrawListener(this);
            this.f24396b.startPostponedEnterTransition();
            return true;
        }
    }

    /* renamed from: i2.v1$S */
    static final class S extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24397a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24398b;

        /* renamed from: i2.v1$S$a */
        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C2540v1 f24399a;

            a(C2540v1 v1Var) {
                this.f24399a = v1Var;
            }

            /* renamed from: b */
            public final Object emit(z2.O o5, C2308e eVar) {
                if (!(o5 instanceof O.a)) {
                    if (o5 instanceof O.c) {
                        O.c cVar = (O.c) o5;
                        if (((B1.g) cVar.a()).b()) {
                            FragmentActivity activity = this.f24399a.getActivity();
                            t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                            String string = this.f24399a.requireContext().getString(com.uptodown.R.string.review_sended);
                            t.d(string, "getString(...)");
                            ((C1598a) activity).u0(string);
                        } else if (!((B1.g) cVar.a()).b() && ((B1.g) cVar.a()).a() == 0) {
                            FragmentActivity activity2 = this.f24399a.getActivity();
                            t.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                            String string2 = this.f24399a.getString(com.uptodown.R.string.error_review_already_submitted);
                            t.d(string2, "getString(...)");
                            ((C1598a) activity2).u0(string2);
                        } else if (((B1.g) cVar.a()).a() == 401) {
                            this.f24399a.c5();
                        } else if (((B1.g) cVar.a()).a() == 403) {
                            FragmentActivity activity3 = this.f24399a.getActivity();
                            t.c(activity3, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                            String string3 = this.f24399a.getString(com.uptodown.R.string.email_validation_msg);
                            t.d(string3, "getString(...)");
                            ((C1598a) activity3).u0(string3);
                        } else {
                            FragmentActivity activity4 = this.f24399a.getActivity();
                            t.c(activity4, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                            String string4 = this.f24399a.getString(com.uptodown.R.string.error_generico);
                            t.d(string4, "getString(...)");
                            ((C1598a) activity4).u0(string4);
                        }
                    } else if (!(o5 instanceof O.b)) {
                        throw new q();
                    }
                }
                return W2.J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        S(C2540v1 v1Var, C2308e eVar) {
            super(2, eVar);
            this.f24398b = v1Var;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new S(this.f24398b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f24397a;
            if (i5 == 0) {
                u.b(obj);
                z3.D e02 = this.f24398b.f4().e0();
                a aVar = new a(this.f24398b);
                this.f24397a = 1;
                if (e02.collect(aVar, this) == f5) {
                    return f5;
                }
            } else if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                u.b(obj);
            }
            throw new C2219h();
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((S) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: i2.v1$T */
    public static final class T implements NewInterstitialListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24400a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ MBNewInterstitialHandler f24401b;

        T(C2540v1 v1Var, MBNewInterstitialHandler mBNewInterstitialHandler) {
            this.f24400a = v1Var;
            this.f24401b = mBNewInterstitialHandler;
        }

        public void onAdClicked(MBridgeIds mBridgeIds) {
            t.e(mBridgeIds, "ids");
            Bundle bundle = new Bundle();
            bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "clicked");
            new z2.F(this.f24400a.getContext()).d("mintegral_interstitial", bundle);
        }

        public void onAdClose(MBridgeIds mBridgeIds, RewardInfo rewardInfo) {
            t.e(mBridgeIds, "ids");
            t.e(rewardInfo, "info");
            Bundle bundle = new Bundle();
            bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "closed");
            new z2.F(this.f24400a.getContext()).d("mintegral_interstitial", bundle);
        }

        public void onAdCloseWithNIReward(MBridgeIds mBridgeIds, RewardInfo rewardInfo) {
            t.e(mBridgeIds, "ids");
            t.e(rewardInfo, "info");
        }

        public void onAdShow(MBridgeIds mBridgeIds) {
            t.e(mBridgeIds, "ids");
            if (this.f24400a.getContext() != null) {
                Bundle bundle = new Bundle();
                bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "show");
                new z2.F(this.f24400a.getContext()).d("mintegral_interstitial", bundle);
                a.C0147a aVar = a.f15150a;
                Context requireContext = this.f24400a.requireContext();
                t.d(requireContext, "requireContext(...)");
                aVar.V0(requireContext, System.currentTimeMillis());
            }
        }

        public void onEndcardShow(MBridgeIds mBridgeIds) {
            t.e(mBridgeIds, "ids");
        }

        public void onLoadCampaignSuccess(MBridgeIds mBridgeIds) {
            t.e(mBridgeIds, "ids");
        }

        public void onResourceLoadFail(MBridgeIds mBridgeIds, String str) {
            String str2;
            t.e(mBridgeIds, "ids");
            t.e(str, "errorMsg");
            Bundle bundle = new Bundle();
            bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "load_failed");
            if (str.length() > 10) {
                str2 = str.substring(0, 10);
                t.d(str2, "substring(...)");
            } else if (str.length() > 0) {
                str2 = str;
            } else {
                str2 = null;
            }
            if (str2 != null) {
                bundle.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, str);
            }
            new z2.F(this.f24400a.getContext()).d("mintegral_interstitial", bundle);
        }

        public void onResourceLoadSuccess(MBridgeIds mBridgeIds) {
            t.e(mBridgeIds, "ids");
            Bundle bundle = new Bundle();
            bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "loaded");
            new z2.F(this.f24400a.getContext()).d("mintegral_interstitial", bundle);
            if (this.f24401b.isReady()) {
                this.f24401b.show();
            }
        }

        public void onShowFail(MBridgeIds mBridgeIds, String str) {
            String str2;
            t.e(mBridgeIds, "ids");
            t.e(str, "errorMsg");
            Bundle bundle = new Bundle();
            bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "show_failed");
            if (str.length() > 10) {
                str2 = str.substring(0, 10);
                t.d(str2, "substring(...)");
            } else if (str.length() > 0) {
                str2 = str;
            } else {
                str2 = null;
            }
            if (str2 != null) {
                bundle.putString(CampaignEx.JSON_NATIVE_VIDEO_ERROR, str);
            }
            new z2.F(this.f24400a.getContext()).d("mintegral_interstitial", bundle);
        }

        public void onVideoComplete(MBridgeIds mBridgeIds) {
            t.e(mBridgeIds, "ids");
            Bundle bundle = new Bundle();
            bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "video_completed");
            new z2.F(this.f24400a.getContext()).d("mintegral_interstitial", bundle);
        }
    }

    /* renamed from: i2.v1$U */
    public static final class U implements k2.O {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ArrayList f24402a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f24403b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.I f24404c;

        U(ArrayList arrayList, ArrayList arrayList2, kotlin.jvm.internal.I i5) {
            this.f24402a = arrayList;
            this.f24403b = arrayList2;
            this.f24404c = i5;
        }

        public void a(int i5) {
            if (((l2.Z) this.f24402a.get(i5)).d() != 0) {
                kotlin.jvm.internal.I i6 = this.f24404c;
                i6.f24687a = !i6.f24687a;
            } else if (this.f24403b.contains(this.f24402a.get(i5))) {
                this.f24403b.remove(this.f24402a.get(i5));
            } else {
                this.f24403b.add(this.f24402a.get(i5));
            }
        }
    }

    /* renamed from: i2.v1$V */
    public static final class V extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Fragment f24405a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public V(Fragment fragment) {
            super(0);
            this.f24405a = fragment;
        }

        public final Fragment invoke() {
            return this.f24405a;
        }
    }

    /* renamed from: i2.v1$W */
    public static final class W extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2616a f24406a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public W(C2616a aVar) {
            super(0);
            this.f24406a = aVar;
        }

        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = ((ViewModelStoreOwner) this.f24406a.invoke()).getViewModelStore();
            t.d(viewModelStore, "ownerProducer().viewModelStore");
            return viewModelStore;
        }
    }

    /* renamed from: i2.v1$X */
    static final class X extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24407a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24408b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f24409c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        X(C2540v1 v1Var, Context context, C2308e eVar) {
            super(2, eVar);
            this.f24408b = v1Var;
            this.f24409c = context;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new X(this.f24408b, this.f24409c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f24407a;
            if (i5 == 0) {
                u.b(obj);
                C2540v1 v1Var = this.f24408b;
                Context context = this.f24409c;
                this.f24407a = 1;
                if (v1Var.X2(context, this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return W2.J.f19942a;
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((X) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: i2.v1$Y */
    static final class Y extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24410a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f24411b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24412c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        Y(String str, C2540v1 v1Var, C2308e eVar) {
            super(2, eVar);
            this.f24411b = str;
            this.f24412c = v1Var;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new Y(this.f24411b, this.f24412c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object obj2;
            Object obj3;
            Object obj4;
            C2316b.f();
            if (this.f24410a == 0) {
                u.b(obj);
                String str = this.f24411b;
                if (!(str == null || str.length() == 0)) {
                    if (this.f24412c.f24355h != null) {
                        R1.K D12 = this.f24412c.f24355h;
                        t.b(D12);
                        ArrayList c5 = D12.c();
                        String str2 = this.f24411b;
                        int size = c5.size();
                        int i5 = 0;
                        while (true) {
                            if (i5 >= size) {
                                obj4 = null;
                                break;
                            }
                            obj4 = c5.get(i5);
                            i5++;
                            if (t.a(((C2657f) obj4).S(), str2)) {
                                break;
                            }
                        }
                        R1.K D13 = this.f24412c.f24355h;
                        t.b(D13);
                        int R4 = C2250q.R(D13.c(), (C2657f) obj4);
                        R1.K D14 = this.f24412c.f24355h;
                        t.b(D14);
                        D14.notifyItemChanged(R4);
                    }
                    if (this.f24412c.f24356i != null) {
                        R1.K C12 = this.f24412c.f24356i;
                        t.b(C12);
                        ArrayList c6 = C12.c();
                        String str3 = this.f24411b;
                        int size2 = c6.size();
                        int i6 = 0;
                        while (true) {
                            if (i6 >= size2) {
                                obj3 = null;
                                break;
                            }
                            obj3 = c6.get(i6);
                            i6++;
                            if (t.a(((C2657f) obj3).S(), str3)) {
                                break;
                            }
                        }
                        R1.K C13 = this.f24412c.f24356i;
                        t.b(C13);
                        int R5 = C2250q.R(C13.c(), (C2657f) obj3);
                        R1.K C14 = this.f24412c.f24356i;
                        t.b(C14);
                        C14.notifyItemChanged(R5);
                    }
                    if (!this.f24412c.f24357j.isEmpty()) {
                        Iterator it = this.f24412c.f24357j.iterator();
                        t.d(it, "iterator(...)");
                        while (it.hasNext()) {
                            Object next = it.next();
                            t.d(next, "next(...)");
                            R1.K k5 = (R1.K) next;
                            ArrayList c7 = k5.c();
                            String str4 = this.f24411b;
                            int size3 = c7.size();
                            int i7 = 0;
                            while (true) {
                                if (i7 >= size3) {
                                    obj2 = null;
                                    break;
                                }
                                obj2 = c7.get(i7);
                                i7++;
                                if (t.a(((C2657f) obj2).S(), str4)) {
                                    break;
                                }
                            }
                            k5.notifyItemChanged(C2250q.R(k5.c(), (C2657f) obj2));
                        }
                    }
                }
                return W2.J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((Y) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: i2.v1$Z */
    static final class Z extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24413a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f24414b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24415c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        Z(String str, C2540v1 v1Var, C2308e eVar) {
            super(2, eVar);
            this.f24414b = str;
            this.f24415c = v1Var;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new Z(this.f24414b, this.f24415c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            FragmentActivity activity;
            C2316b.f();
            if (this.f24413a == 0) {
                u.b(obj);
                if (t3.s.E(this.f24414b, this.f24415c.a4().S(), true) && (activity = this.f24415c.getActivity()) != null) {
                    this.f24415c.f7(activity);
                }
                return W2.J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((Z) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: i2.v1$a  reason: case insensitive filesystem */
    public static final class C2541a {
        public /* synthetic */ C2541a(C2633k kVar) {
            this();
        }

        public final C2540v1 a(C2657f fVar) {
            C2540v1 v1Var = new C2540v1();
            Bundle bundle = new Bundle();
            if (fVar != null) {
                bundle.putParcelable("appInfo", fVar);
            }
            v1Var.setArguments(bundle);
            return v1Var;
        }

        private C2541a() {
        }
    }

    /* renamed from: i2.v1$a0 */
    static final class a0 extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24416a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24417b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ b0 f24418c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a0(C2540v1 v1Var, b0 b0Var, C2308e eVar) {
            super(2, eVar);
            this.f24417b = v1Var;
            this.f24418c = b0Var;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a0(this.f24417b, this.f24418c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f24416a;
            if (i5 == 0) {
                u.b(obj);
                GetUserDataWorker.a aVar = GetUserDataWorker.f21373b;
                Context requireContext = this.f24417b.requireContext();
                t.d(requireContext, "requireContext(...)");
                b0 b0Var = this.f24418c;
                this.f24416a = 1;
                if (aVar.a(requireContext, b0Var, this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return W2.J.f19942a;
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((a0) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: i2.v1$b  reason: case insensitive filesystem */
    public final class C2542b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final int f24419a;

        /* renamed from: b  reason: collision with root package name */
        private final l2.T f24420b;

        public C2542b(int i5, l2.T t5) {
            this.f24419a = i5;
            this.f24420b = t5;
        }

        public void run() {
            l2.T t5 = this.f24420b;
            if (t5 != null && t3.s.E(t5.h(), C2540v1.this.a4().S(), true)) {
                int i5 = this.f24419a;
                if (i5 != 108) {
                    if (i5 == 109) {
                        C2540v1.this.d4();
                        C2540v1.this.M6(this.f24420b);
                    } else if (i5 == 201) {
                        C2540v1.this.M6(this.f24420b);
                    } else if (i5 != 207) {
                        FragmentActivity activity = C2540v1.this.getActivity();
                        if (activity != null) {
                            C2540v1.this.f7(activity);
                        }
                    } else {
                        C2540v1 v1Var = C2540v1.this;
                        Context requireContext = v1Var.requireContext();
                        t.d(requireContext, "requireContext(...)");
                        v1Var.v6(requireContext);
                    }
                } else if (C2540v1.this.getContext() != null) {
                    C2540v1 v1Var2 = C2540v1.this;
                    Context requireContext2 = v1Var2.requireContext();
                    t.d(requireContext2, "requireContext(...)");
                    v1Var2.f7(requireContext2);
                }
            }
        }
    }

    /* renamed from: i2.v1$b0 */
    public static final class b0 implements k2.P {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24422a;

        b0(C2540v1 v1Var) {
            this.f24422a = v1Var;
        }

        public void a() {
            V.b bVar = l2.V.f24870q;
            Context requireContext = this.f24422a.requireContext();
            t.d(requireContext, "requireContext(...)");
            l2.V h5 = bVar.h(requireContext);
            if (h5 != null && h5.q()) {
                this.f24422a.b4().f22758D.setVisibility(8);
            }
        }
    }

    /* renamed from: i2.v1$c  reason: case insensitive filesystem */
    public final class C2543c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final String f24423a;

        /* renamed from: b  reason: collision with root package name */
        private final int f24424b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24425c;

        public C2543c(C2540v1 v1Var, String str, int i5) {
            t.e(str, "packagename");
            this.f24425c = v1Var;
            this.f24423a = str;
            this.f24424b = i5;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:0x008c, code lost:
            r0 = r5.f24425c;
            r2 = r0.getString(com.uptodown.R.string.install_compatibility_error, r0.a4().N());
            kotlin.jvm.internal.t.d(r2, "getString(...)");
            i2.C2540v1.v1(r0, r2);
            i2.C2540v1.g2(r5.f24425c);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x00ad, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00ae, code lost:
            r0 = r5.f24425c.getActivity();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00b4, code lost:
            if (r0 == null) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:0x00b6, code lost:
            i2.C2540v1.i2(r5.f24425c, r0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00bb, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00bc, code lost:
            r0 = r5.f24425c;
            r2 = r0.getString(com.uptodown.R.string.installing);
            kotlin.jvm.internal.t.d(r2, "getString(...)");
            i2.C2540v1.f2(r0, r2);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r5 = this;
                i2.v1 r0 = r5.f24425c
                l2.f r0 = r0.a4()
                java.lang.String r0 = r0.S()
                if (r0 == 0) goto L_0x00cb
                int r0 = r0.length()
                if (r0 != 0) goto L_0x0014
                goto L_0x00cb
            L_0x0014:
                i2.v1 r0 = r5.f24425c
                l2.f r0 = r0.a4()
                java.lang.String r0 = r0.S()
                java.lang.String r1 = r5.f24423a
                r2 = 1
                boolean r0 = t3.s.E(r0, r1, r2)
                if (r0 == 0) goto L_0x00cb
                int r0 = r5.f24424b
                java.lang.String r1 = "getString(...)"
                switch(r0) {
                    case 301: goto L_0x00bc;
                    case 302: goto L_0x00ae;
                    case 303: goto L_0x008c;
                    case 304: goto L_0x0077;
                    case 305: goto L_0x0067;
                    case 306: goto L_0x0059;
                    case 307: goto L_0x0033;
                    default: goto L_0x002e;
                }
            L_0x002e:
                switch(r0) {
                    case 351: goto L_0x00bc;
                    case 352: goto L_0x00ae;
                    case 353: goto L_0x008c;
                    default: goto L_0x0031;
                }
            L_0x0031:
                goto L_0x00cb
            L_0x0033:
                i2.v1 r0 = r5.f24425c
                androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
                if (r0 == 0) goto L_0x00cb
                i2.v1 r2 = r5.f24425c
                androidx.fragment.app.FragmentActivity r3 = r2.getActivity()
                java.lang.String r4 = "null cannot be cast to non-null type com.uptodown.activities.BaseActivity"
                kotlin.jvm.internal.t.c(r3, r4)
                com.uptodown.activities.a r3 = (com.uptodown.activities.C1598a) r3
                r4 = 2131952026(0x7f13019a, float:1.9540483E38)
                java.lang.String r4 = r2.getString(r4)
                kotlin.jvm.internal.t.d(r4, r1)
                r3.u0(r4)
                r2.f7(r0)
                return
            L_0x0059:
                i2.v1 r0 = r5.f24425c
                androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
                if (r0 == 0) goto L_0x00cb
                i2.v1 r1 = r5.f24425c
                r1.v6(r0)
                return
            L_0x0067:
                i2.v1 r0 = r5.f24425c
                r2 = 2131952805(0x7f1304a5, float:1.9542063E38)
                java.lang.String r2 = r0.getString(r2)
                kotlin.jvm.internal.t.d(r2, r1)
                r0.A6(r2)
                return
            L_0x0077:
                i2.v1 r0 = r5.f24425c
                r2 = 2131952349(0x7f1302dd, float:1.9541138E38)
                java.lang.String r2 = r0.getString(r2)
                kotlin.jvm.internal.t.d(r2, r1)
                r0.o3(r2)
                i2.v1 r0 = r5.f24425c
                r0.B6()
                return
            L_0x008c:
                i2.v1 r0 = r5.f24425c
                l2.f r3 = r0.a4()
                java.lang.String r3 = r3.N()
                java.lang.Object[] r2 = new java.lang.Object[r2]
                r4 = 0
                r2[r4] = r3
                r3 = 2131952111(0x7f1301ef, float:1.9540656E38)
                java.lang.String r2 = r0.getString(r3, r2)
                kotlin.jvm.internal.t.d(r2, r1)
                r0.o3(r2)
                i2.v1 r0 = r5.f24425c
                r0.B6()
                return
            L_0x00ae:
                i2.v1 r0 = r5.f24425c
                androidx.fragment.app.FragmentActivity r0 = r0.getActivity()
                if (r0 == 0) goto L_0x00cb
                i2.v1 r1 = r5.f24425c
                r1.F6(r0)
                return
            L_0x00bc:
                i2.v1 r0 = r5.f24425c
                r2 = 2131952124(0x7f1301fc, float:1.9540682E38)
                java.lang.String r2 = r0.getString(r2)
                kotlin.jvm.internal.t.d(r2, r1)
                r0.A6(r2)
            L_0x00cb:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: i2.C2540v1.C2543c.run():void");
        }
    }

    /* renamed from: i2.v1$c0 */
    static final class c0 extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24426a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24427b;

        /* renamed from: i2.v1$c0$a */
        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C2540v1 f24428a;

            /* renamed from: i2.v1$c0$a$a  reason: collision with other inner class name */
            static final class C0245a extends l implements p {

                /* renamed from: a  reason: collision with root package name */
                int f24429a;

                /* renamed from: b  reason: collision with root package name */
                final /* synthetic */ C2540v1 f24430b;

                /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                C0245a(C2540v1 v1Var, C2308e eVar) {
                    super(2, eVar);
                    this.f24430b = v1Var;
                }

                public final C2308e create(Object obj, C2308e eVar) {
                    return new C0245a(this.f24430b, eVar);
                }

                public final Object invokeSuspend(Object obj) {
                    C2316b.f();
                    if (this.f24429a == 0) {
                        u.b(obj);
                        if (this.f24430b.a4().F0() == 1) {
                            C2540v1 v1Var = this.f24430b;
                            String string = v1Var.getString(com.uptodown.R.string.app_detail_remove_wishlist_title);
                            t.d(string, "getString(...)");
                            v1Var.p6(com.uptodown.R.id.action_wishlist, string);
                            this.f24430b.b4().f22779U.setBackground(ContextCompat.getDrawable(this.f24430b.requireContext(), com.uptodown.R.drawable.ripple_blue_primary_button));
                            this.f24430b.b4().f22809m.setImageDrawable(ContextCompat.getDrawable(this.f24430b.requireContext(), com.uptodown.R.drawable.vector_heart_white));
                            this.f24430b.b4().f22763F0.setTextColor(ContextCompat.getColor(this.f24430b.requireContext(), com.uptodown.R.color.white));
                            this.f24430b.b4().f22763F0.setText(this.f24430b.getString(com.uptodown.R.string.app_detail_remove_wishlist_title));
                        } else {
                            C2540v1 v1Var2 = this.f24430b;
                            String string2 = v1Var2.getString(com.uptodown.R.string.app_detail_add_wishlist_title);
                            t.d(string2, "getString(...)");
                            v1Var2.p6(com.uptodown.R.id.action_wishlist, string2);
                            this.f24430b.b4().f22779U.setBackground(ContextCompat.getDrawable(this.f24430b.requireContext(), com.uptodown.R.drawable.ripple_stroke_blue_primary));
                            this.f24430b.b4().f22809m.setImageDrawable(ContextCompat.getDrawable(this.f24430b.requireContext(), com.uptodown.R.drawable.vector_heart_stroke));
                            this.f24430b.b4().f22763F0.setTextColor(ContextCompat.getColor(this.f24430b.requireContext(), com.uptodown.R.color.text_terciary));
                            this.f24430b.b4().f22763F0.setText(this.f24430b.getString(com.uptodown.R.string.app_detail_add_wishlist_title));
                        }
                        return W2.J.f19942a;
                    }
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }

                public final Object invoke(w3.M m5, C2308e eVar) {
                    return ((C0245a) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
                }
            }

            a(C2540v1 v1Var) {
                this.f24428a = v1Var;
            }

            public final Object b(int i5, C2308e eVar) {
                this.f24428a.a4().c1(i5);
                Object g5 = C2872g.g(C2865c0.c(), new C0245a(this.f24428a, (C2308e) null), eVar);
                if (g5 == C2316b.f()) {
                    return g5;
                }
                return W2.J.f19942a;
            }

            public /* bridge */ /* synthetic */ Object emit(Object obj, C2308e eVar) {
                return b(((Number) obj).intValue(), eVar);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c0(C2540v1 v1Var, C2308e eVar) {
            super(2, eVar);
            this.f24427b = v1Var;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c0(this.f24427b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f24426a;
            if (i5 == 0) {
                u.b(obj);
                w p02 = this.f24427b.f4().p0();
                a aVar = new a(this.f24427b);
                this.f24426a = 1;
                if (p02.collect(aVar, this) == f5) {
                    return f5;
                }
            } else if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                u.b(obj);
            }
            throw new C2219h();
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((c0) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: i2.v1$d  reason: case insensitive filesystem */
    public final class C2544d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final int f24431a;

        /* renamed from: b  reason: collision with root package name */
        private final C2668q f24432b;

        public C2544d(int i5, C2668q qVar) {
            this.f24431a = i5;
            this.f24432b = qVar;
        }

        public void run() {
            String str;
            String str2;
            C2668q qVar = this.f24432b;
            String str3 = null;
            if (qVar != null) {
                str = qVar.w();
            } else {
                str = null;
            }
            if (!(str == null || str.length() == 0)) {
                C2668q qVar2 = this.f24432b;
                if (qVar2 != null) {
                    str2 = qVar2.w();
                } else {
                    str2 = null;
                }
                if (t3.s.E(str2, C2540v1.this.a4().S(), true)) {
                    switch (this.f24431a) {
                        case 199:
                            C2540v1.this.x6((C2668q) null);
                            return;
                        case 200:
                            C2540v1.this.d4();
                            if (C2540v1.S4(C2540v1.this, (l2.T) null, 1, (Object) null)) {
                                C2540v1.this.x6(this.f24432b);
                                if (this.f24432b != null && C2540v1.this.a4().J() != this.f24432b.E() && C2540v1.this.getActivity() != null && (C2540v1.this.getActivity() instanceof C1598a)) {
                                    C2540v1.this.x3();
                                    return;
                                }
                                return;
                            }
                            return;
                        case 201:
                            if (C2540v1.S4(C2540v1.this, (l2.T) null, 1, (Object) null)) {
                                C2540v1.this.x6(this.f24432b);
                                return;
                            }
                            return;
                        case 203:
                            FragmentActivity activity = C2540v1.this.getActivity();
                            if (activity != null) {
                                C2540v1 v1Var = C2540v1.this;
                                String string = v1Var.getString(com.uptodown.R.string.download_error_message);
                                t.d(string, "getString(...)");
                                v1Var.o3(string);
                                v1Var.v6(activity);
                                return;
                            }
                            return;
                        case 205:
                            C2540v1.this.x6(this.f24432b);
                            return;
                        case 207:
                            FragmentActivity activity2 = C2540v1.this.getActivity();
                            if (activity2 != null) {
                                C2540v1.this.v6(activity2);
                                return;
                            }
                            return;
                        case 208:
                            FragmentActivity activity3 = C2540v1.this.getActivity();
                            if (activity3 != null) {
                                C2540v1 v1Var2 = C2540v1.this;
                                String string2 = v1Var2.getString(com.uptodown.R.string.no_free_space);
                                t.d(string2, "getString(...)");
                                v1Var2.o3(string2);
                                v1Var2.f7(activity3);
                                return;
                            }
                            return;
                        case 209:
                            FragmentActivity activity4 = C2540v1.this.getActivity();
                            if (activity4 != null) {
                                C2540v1 v1Var3 = C2540v1.this;
                                String string3 = v1Var3.getString(com.uptodown.R.string.error_no_connection);
                                t.d(string3, "getString(...)");
                                v1Var3.o3(string3);
                                v1Var3.f7(activity4);
                                return;
                            }
                            return;
                        case 210:
                            FragmentActivity activity5 = C2540v1.this.getActivity();
                            if (activity5 != null) {
                                C2540v1.this.f7(activity5);
                                return;
                            }
                            return;
                        case 211:
                            C2540v1.this.G6(this.f24432b);
                            return;
                        default:
                            return;
                    }
                }
            }
            C2540v1 v1Var4 = C2540v1.this;
            C2668q qVar3 = this.f24432b;
            if (qVar3 != null) {
                str3 = qVar3.w();
            }
            v1Var4.n7(str3);
        }
    }

    /* renamed from: i2.v1$e  reason: case insensitive filesystem */
    static final class C2545e extends d {

        /* renamed from: a  reason: collision with root package name */
        Object f24434a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f24435b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24436c;

        /* renamed from: d  reason: collision with root package name */
        int f24437d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2545e(C2540v1 v1Var, C2308e eVar) {
            super(eVar);
            this.f24436c = v1Var;
        }

        public final Object invokeSuspend(Object obj) {
            this.f24435b = obj;
            this.f24437d |= Integer.MIN_VALUE;
            return this.f24436c.S2(this);
        }
    }

    /* renamed from: i2.v1$f  reason: case insensitive filesystem */
    static final class C2546f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24438a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24439b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2546f(C2540v1 v1Var, C2308e eVar) {
            super(2, eVar);
            this.f24439b = v1Var;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C2546f(this.f24439b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            String S4;
            C2316b.f();
            if (this.f24438a == 0) {
                u.b(obj);
                if (!(this.f24439b.getContext() == null || (S4 = this.f24439b.a4().S()) == null || S4.length() == 0)) {
                    C2940B.a aVar = C2940B.f26458v;
                    Context requireContext = this.f24439b.requireContext();
                    t.d(requireContext, "requireContext(...)");
                    C2940B a5 = aVar.a(requireContext);
                    a5.a();
                    String S5 = this.f24439b.a4().S();
                    t.b(S5);
                    C2655d Y4 = a5.Y(S5);
                    if (Y4 != null) {
                        this.f24439b.f4().R().setValue(Y4);
                    }
                }
                return W2.J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((C2546f) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: i2.v1$g  reason: case insensitive filesystem */
    static final class C2547g extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24440a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24441b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2547g(C2540v1 v1Var, C2308e eVar) {
            super(2, eVar);
            this.f24441b = v1Var;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C2547g(this.f24441b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f24440a == 0) {
                u.b(obj);
                if (this.f24441b.f4().R().getValue() != null) {
                    Object value = this.f24441b.f4().R().getValue();
                    t.b(value);
                    if (((C2655d) value).e() == 0) {
                        C2540v1 v1Var = this.f24441b;
                        String string = v1Var.getString(com.uptodown.R.string.not_offer_updates);
                        t.d(string, "getString(...)");
                        v1Var.p6(com.uptodown.R.id.action_exclude, string);
                        return W2.J.f19942a;
                    }
                }
                C2540v1 v1Var2 = this.f24441b;
                String string2 = v1Var2.getString(com.uptodown.R.string.offer_updates_again);
                t.d(string2, "getString(...)");
                v1Var2.p6(com.uptodown.R.id.action_exclude, string2);
                return W2.J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((C2547g) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: i2.v1$h  reason: case insensitive filesystem */
    static final class C2548h extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24442a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24443b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ Context f24444c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.L f24445d;

        /* renamed from: e  reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.I f24446e;

        /* renamed from: f  reason: collision with root package name */
        final /* synthetic */ kotlin.jvm.internal.I f24447f;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2548h(C2540v1 v1Var, Context context, kotlin.jvm.internal.L l5, kotlin.jvm.internal.I i5, kotlin.jvm.internal.I i6, C2308e eVar) {
            super(2, eVar);
            this.f24443b = v1Var;
            this.f24444c = context;
            this.f24445d = l5;
            this.f24446e = i5;
            this.f24447f = i6;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C2548h(this.f24443b, this.f24444c, this.f24445d, this.f24446e, this.f24447f, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            String u5;
            String str;
            C2316b.f();
            if (this.f24442a == 0) {
                u.b(obj);
                this.f24443b.b4().f22770L.f23098i.setVisibility(8);
                this.f24443b.b4().f22766H.f22352i.setVisibility(8);
                if (this.f24443b.a4().c()) {
                    this.f24443b.b4().f22829w.setVisibility(0);
                } else {
                    this.f24443b.b4().f22829w.setVisibility(8);
                }
                if (this.f24443b.f4().R().getValue() != null) {
                    this.f24443b.b4().f22770L.f23093d.setVisibility(0);
                } else {
                    this.f24443b.b4().f22770L.f23093d.setVisibility(8);
                }
                if (this.f24443b.a4().O0()) {
                    this.f24443b.I6(this.f24444c);
                } else if (this.f24443b.a4().L0()) {
                    this.f24443b.r6();
                } else if (this.f24443b.a4().K0()) {
                    this.f24443b.v6(this.f24444c);
                } else if (this.f24443b.a4().M0()) {
                    this.f24443b.H6();
                } else if (!a.f15150a.R(this.f24444c)) {
                    this.f24443b.o6();
                } else if (!this.f24443b.a4().G0()) {
                    if (this.f24443b.f4().R().getValue() != null) {
                        this.f24443b.F6(this.f24444c);
                        this.f24443b.Z4(1);
                    } else {
                        C2540v1 v1Var = this.f24443b;
                        String string = v1Var.getString(com.uptodown.R.string.app_detail_not_compatible);
                        t.d(string, "getString(...)");
                        v1Var.s6(string);
                        this.f24443b.Z4(0);
                    }
                } else if (!this.f24443b.g4()) {
                    this.f24443b.D6(this.f24444c, (C2668q) this.f24445d.f24690a);
                } else if (((Boolean) this.f24443b.f4().N().getValue()).booleanValue() || this.f24443b.a4().I0()) {
                    C2540v1 v1Var2 = this.f24443b;
                    String string2 = v1Var2.getString(com.uptodown.R.string.app_detail_not_available);
                    t.d(string2, "getString(...)");
                    v1Var2.s6(string2);
                } else {
                    C2257a i5 = k.f32g.i();
                    if (i5 != null) {
                        str = i5.b();
                    } else {
                        str = null;
                    }
                    if (t3.s.E(str, this.f24443b.a4().S(), true)) {
                        C2540v1 v1Var3 = this.f24443b;
                        String string3 = v1Var3.getString(com.uptodown.R.string.installing);
                        t.d(string3, "getString(...)");
                        v1Var3.A6(string3);
                    } else if (this.f24443b.f4().R().getValue() != null) {
                        if (this.f24443b.f4().j0().getValue() != null) {
                            Object value = this.f24443b.f4().j0().getValue();
                            t.b(value);
                            if (!((l2.T) value).m()) {
                                Object value2 = this.f24443b.f4().R().getValue();
                                t.b(value2);
                                if (((C2655d) value2).e() != 1) {
                                    Object obj2 = this.f24445d.f24690a;
                                    if (obj2 == null) {
                                        this.f24443b.v6(this.f24444c);
                                    } else if (((C2668q) obj2).f()) {
                                        this.f24443b.O6(this.f24444c);
                                    } else {
                                        if (!this.f24446e.f24687a) {
                                            C2540v1 v1Var4 = this.f24443b;
                                            if (!v1Var4.R4((l2.T) v1Var4.f4().j0().getValue()) || DownloadWorker.f21359d.h()) {
                                                if (((C2668q) this.f24445d.f24690a).y() <= 0 || !DownloadWorker.f21359d.h()) {
                                                    this.f24443b.v6(this.f24444c);
                                                } else {
                                                    this.f24443b.Q6();
                                                }
                                            }
                                        }
                                        this.f24443b.x6((C2668q) this.f24445d.f24690a);
                                    }
                                }
                            }
                        }
                        Object value3 = this.f24443b.f4().R().getValue();
                        t.b(value3);
                        if (!((C2655d) value3).H()) {
                            this.f24443b.F6(this.f24444c);
                        } else {
                            this.f24443b.b4().f22770L.getRoot().setVisibility(4);
                            this.f24443b.b4().f22766H.getRoot().setVisibility(8);
                        }
                    } else {
                        Object obj3 = this.f24445d.f24690a;
                        if (obj3 == null) {
                            this.f24443b.v6(this.f24444c);
                        } else if (((C2668q) obj3).f()) {
                            this.f24443b.B6();
                        } else if ((C2540v1.S4(this.f24443b, (l2.T) null, 1, (Object) null) || this.f24446e.f24687a) && this.f24447f.f24687a) {
                            this.f24443b.x6((C2668q) this.f24445d.f24690a);
                        } else {
                            this.f24443b.v6(this.f24444c);
                        }
                    }
                }
                this.f24443b.f4().M().setValue(kotlin.coroutines.jvm.internal.b.a(true));
                if (this.f24443b.f4().R().getValue() != null) {
                    this.f24443b.Z6(com.uptodown.R.id.action_app_details_settings);
                    this.f24443b.Z6(com.uptodown.R.id.action_exclude);
                } else {
                    this.f24443b.h4(com.uptodown.R.id.action_app_details_settings);
                    this.f24443b.h4(com.uptodown.R.id.action_exclude);
                }
                if (!this.f24443b.a4().K0() || (u5 = this.f24443b.a4().u()) == null || u5.length() == 0) {
                    this.f24443b.b4().f22813o.getRoot().setVisibility(8);
                    this.f24443b.b4().f22813o.f22720c.setVisibility(8);
                } else {
                    TextView textView = this.f24443b.b4().f22813o.f22720c;
                    C2540v1 v1Var5 = this.f24443b;
                    textView.setTypeface(k.f32g.x());
                    textView.setText(v1Var5.a4().u());
                    this.f24443b.b4().f22813o.getRoot().setVisibility(0);
                }
                return W2.J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((C2548h) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: i2.v1$i  reason: case insensitive filesystem */
    static final class C2549i extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24448a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24449b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2549i(C2540v1 v1Var, C2308e eVar) {
            super(2, eVar);
            this.f24449b = v1Var;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C2549i(this.f24449b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f24448a == 0) {
                u.b(obj);
                if (this.f24449b.a4().M0()) {
                    this.f24449b.H6();
                } else {
                    C2540v1 v1Var = this.f24449b;
                    String string = v1Var.getString(com.uptodown.R.string.app_detail_not_available);
                    t.d(string, "getString(...)");
                    v1Var.s6(string);
                }
                return W2.J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((C2549i) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: i2.v1$j  reason: case insensitive filesystem */
    static final class C2550j extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24450a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24451b;

        /* renamed from: i2.v1$j$a */
        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C2540v1 f24452a;

            a(C2540v1 v1Var) {
                this.f24452a = v1Var;
            }

            /* renamed from: b */
            public final Object emit(z2.O o5, C2308e eVar) {
                String a5;
                if (!(o5 instanceof O.a)) {
                    if (o5 instanceof O.c) {
                        O.c cVar = (O.c) o5;
                        boolean z4 = false;
                        if (((B1.f) cVar.a()).b()) {
                            C2540v1 v1Var = this.f24452a;
                            TextView textView = v1Var.b4().f22770L.f23100k;
                            t.d(textView, "tvDownloadCancel");
                            v1Var.N2(textView);
                            C2540v1 v1Var2 = this.f24452a;
                            RelativeLayout relativeLayout = v1Var2.b4().f22766H.f22353j;
                            t.d(relativeLayout, "rlStatusPreRegister");
                            v1Var2.N2(relativeLayout);
                            this.f24452a.b4().f22766H.f22348e.setVisibility(8);
                            if (!(this.f24452a.getContext() == null || (a5 = ((B1.f) cVar.a()).a()) == null || a5.length() == 0)) {
                                C2540v1 v1Var3 = this.f24452a;
                                TextView textView2 = v1Var3.b4().f22770L.f23100k;
                                t.d(textView2, "tvDownloadCancel");
                                v1Var3.n6(textView2, ((B1.f) cVar.a()).a());
                                this.f24452a.b4().f22766H.f22353j.setBackground(ContextCompat.getDrawable(this.f24452a.requireContext(), com.uptodown.R.drawable.ripple_open_button));
                                this.f24452a.b4().f22766H.f22361r.setTextColor(ContextCompat.getColorStateList(this.f24452a.requireContext(), com.uptodown.R.color.selector_wizard_accept_button_text));
                                this.f24452a.b4().f22766H.f22361r.setText(((B1.f) cVar.a()).a());
                            }
                            C2940B.a aVar = C2940B.f26458v;
                            Context requireContext = this.f24452a.requireContext();
                            t.d(requireContext, "requireContext(...)");
                            C2940B a6 = aVar.a(requireContext);
                            a6.a();
                            C2647G y02 = a6.y0(this.f24452a.a4().e());
                            a6.m();
                            if (y02 != null) {
                                this.f24452a.b4().f22760E.setVisibility(0);
                                SwitchCompat switchCompat = this.f24452a.b4().f22783Y;
                                if (y02.d() == 1) {
                                    z4 = true;
                                }
                                switchCompat.setChecked(z4);
                            } else {
                                this.f24452a.b4().f22783Y.setChecked(true);
                            }
                        } else {
                            C2540v1 v1Var4 = this.f24452a;
                            TextView textView3 = v1Var4.b4().f22770L.f23100k;
                            t.d(textView3, "tvDownloadCancel");
                            v1Var4.A2(textView3);
                            C2540v1 v1Var5 = this.f24452a;
                            RelativeLayout relativeLayout2 = v1Var5.b4().f22766H.f22353j;
                            t.d(relativeLayout2, "rlStatusPreRegister");
                            v1Var5.A2(relativeLayout2);
                            this.f24452a.b4().f22766H.f22348e.setVisibility(0);
                            if (this.f24452a.getContext() != null) {
                                C2540v1 v1Var6 = this.f24452a;
                                TextView textView4 = v1Var6.b4().f22770L.f23100k;
                                t.d(textView4, "tvDownloadCancel");
                                String string = this.f24452a.getString(com.uptodown.R.string.pre_registration_title);
                                t.d(string, "getString(...)");
                                v1Var6.m6(textView4, string);
                                this.f24452a.b4().f22766H.f22353j.setBackground(ContextCompat.getDrawable(this.f24452a.requireContext(), com.uptodown.R.drawable.ripple_blue_primary_button));
                                this.f24452a.b4().f22766H.f22361r.setText(this.f24452a.getString(com.uptodown.R.string.pre_registration_title));
                                this.f24452a.b4().f22766H.f22361r.setTextColor(ContextCompat.getColor(this.f24452a.requireContext(), com.uptodown.R.color.white));
                            }
                        }
                    } else if (!(o5 instanceof O.b)) {
                        throw new q();
                    }
                }
                return W2.J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2550j(C2540v1 v1Var, C2308e eVar) {
            super(2, eVar);
            this.f24451b = v1Var;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C2550j(this.f24451b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f24450a;
            if (i5 == 0) {
                u.b(obj);
                z3.D U4 = this.f24451b.f4().U();
                a aVar = new a(this.f24451b);
                this.f24450a = 1;
                if (U4.collect(aVar, this) == f5) {
                    return f5;
                }
            } else if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                u.b(obj);
            }
            throw new C2219h();
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((C2550j) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: i2.v1$k  reason: case insensitive filesystem */
    public static final class C2551k implements k2.Z {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24453a;

        C2551k(C2540v1 v1Var) {
            this.f24453a = v1Var;
        }

        /* access modifiers changed from: private */
        public static final W2.J e(C2540v1 v1Var) {
            v1Var.S3();
            return W2.J.f19942a;
        }

        /* access modifiers changed from: private */
        public static final W2.J f(C2540v1 v1Var) {
            FragmentActivity requireActivity = v1Var.requireActivity();
            t.d(requireActivity, "requireActivity(...)");
            v1Var.M2(requireActivity);
            return W2.J.f19942a;
        }

        public void a(l2.L l5) {
            t.e(l5, "reportVT");
            if (this.f24453a.getActivity() != null && (this.f24453a.getActivity() instanceof C1598a) && !this.f24453a.requireActivity().isFinishing()) {
                this.f24453a.a4().Y0(l5);
                if (l5.d() > 0) {
                    FragmentActivity activity = this.f24453a.getActivity();
                    t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                    ((C1598a) activity).j2(this.f24453a.a4(), new C2569w1(this.f24453a), new C2572x1(this.f24453a));
                    return;
                }
                this.f24453a.S3();
            }
        }

        public void b() {
            this.f24453a.S3();
        }
    }

    /* renamed from: i2.v1$m  reason: case insensitive filesystem */
    public static final class C2553m implements C2601k {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24455a;

        C2553m(C2540v1 v1Var) {
            this.f24455a = v1Var;
        }

        public void a(long j5) {
            this.f24455a.u5(j5);
        }

        public void b(C2660i iVar) {
            t.e(iVar, "category");
            this.f24455a.i5(iVar);
        }
    }

    /* renamed from: i2.v1$n  reason: case insensitive filesystem */
    static final class C2554n extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24456a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24457b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2554n(C2540v1 v1Var, C2308e eVar) {
            super(2, eVar);
            this.f24457b = v1Var;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C2554n(this.f24457b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f24456a;
            if (i5 == 0) {
                u.b(obj);
                C2540v1 v1Var = this.f24457b;
                this.f24456a = 1;
                if (v1Var.S2(this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return W2.J.f19942a;
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((C2554n) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: i2.v1$o  reason: case insensitive filesystem */
    public static final class C2555o implements C2610u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24458a;

        C2555o(C2540v1 v1Var) {
            this.f24458a = v1Var;
        }

        public void c(C2657f fVar) {
            t.e(fVar, "appInfo");
            this.f24458a.l6(fVar);
            this.f24458a.H5();
            this.f24458a.C2();
        }

        public void d(int i5) {
            if (i5 == 404) {
                this.f24458a.f4().N().setValue(Boolean.TRUE);
            }
        }
    }

    /* renamed from: i2.v1$p  reason: case insensitive filesystem */
    static final class C2556p extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24459a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24460b;

        /* renamed from: i2.v1$p$a */
        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C2540v1 f24461a;

            a(C2540v1 v1Var) {
                this.f24461a = v1Var;
            }

            /* renamed from: b */
            public final Object emit(ArrayList arrayList, C2308e eVar) {
                this.f24461a.J5(arrayList);
                return W2.J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2556p(C2540v1 v1Var, C2308e eVar) {
            super(2, eVar);
            this.f24460b = v1Var;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C2556p(this.f24460b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f24459a;
            if (i5 == 0) {
                u.b(obj);
                z3.D W4 = this.f24460b.f4().W();
                a aVar = new a(this.f24460b);
                this.f24459a = 1;
                if (W4.collect(aVar, this) == f5) {
                    return f5;
                }
            } else if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                u.b(obj);
            }
            throw new C2219h();
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((C2556p) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: i2.v1$q  reason: case insensitive filesystem */
    public static final class C2557q implements C2231h {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24462a;

        C2557q(C2540v1 v1Var) {
            this.f24462a = v1Var;
        }

        public void a() {
            C2540v1 v1Var = this.f24462a;
            String string = v1Var.getString(com.uptodown.R.string.installing);
            t.d(string, "getString(...)");
            v1Var.A6(string);
        }

        public void b(String str) {
            if (str != null) {
                this.f24462a.o3(str);
                return;
            }
            C2540v1 v1Var = this.f24462a;
            String string = v1Var.getString(com.uptodown.R.string.error_generico);
            t.d(string, "getString(...)");
            v1Var.o3(string);
        }
    }

    /* renamed from: i2.v1$t  reason: case insensitive filesystem */
    static final class C2560t extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24468a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24469b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ l2.O f24470c;

        /* renamed from: i2.v1$t$a */
        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C2540v1 f24471a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ l2.O f24472b;

            a(C2540v1 v1Var, l2.O o5) {
                this.f24471a = v1Var;
                this.f24472b = o5;
            }

            public final Object b(int i5, C2308e eVar) {
                if (i5 == 0) {
                    FragmentActivity activity = this.f24471a.getActivity();
                    t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                    String string = this.f24471a.getString(com.uptodown.R.string.error_generico);
                    t.d(string, "getString(...)");
                    ((C1598a) activity).u0(string);
                } else if (i5 == 1) {
                    Iterator it = ((Iterable) this.f24471a.f4().b0().getValue()).iterator();
                    int i6 = 0;
                    while (true) {
                        if (!it.hasNext()) {
                            i6 = -1;
                            break;
                        }
                        int i7 = i6 + 1;
                        if (((l2.O) it.next()).g() == this.f24472b.g()) {
                            break;
                        }
                        i6 = i7;
                    }
                    if (i6 > 0 && i6 < ((ArrayList) this.f24471a.f4().b0().getValue()).size()) {
                        this.f24471a.o7(this.f24472b, i6);
                    }
                }
                return W2.J.f19942a;
            }

            public /* bridge */ /* synthetic */ Object emit(Object obj, C2308e eVar) {
                return b(((Number) obj).intValue(), eVar);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2560t(C2540v1 v1Var, l2.O o5, C2308e eVar) {
            super(2, eVar);
            this.f24469b = v1Var;
            this.f24470c = o5;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C2560t(this.f24469b, this.f24470c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f24468a;
            if (i5 == 0) {
                u.b(obj);
                z3.D Z4 = this.f24469b.f4().Z();
                a aVar = new a(this.f24469b, this.f24470c);
                this.f24468a = 1;
                if (Z4.collect(aVar, this) == f5) {
                    return f5;
                }
            } else if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                u.b(obj);
            }
            throw new C2219h();
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((C2560t) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: i2.v1$u  reason: case insensitive filesystem */
    public static final class C2561u implements BannerAdListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24473a;

        C2561u(C2540v1 v1Var) {
            this.f24473a = v1Var;
        }

        /* access modifiers changed from: private */
        public static final void b(C2540v1 v1Var, View view) {
            v1Var.e7();
        }

        public void closeFullScreen(MBridgeIds mBridgeIds) {
            t.e(mBridgeIds, "ids");
        }

        public void onClick(MBridgeIds mBridgeIds) {
            t.e(mBridgeIds, "ids");
            Bundle bundle = new Bundle();
            bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "clicked");
            new z2.F(this.f24473a.getContext()).d("mintegral_banner", bundle);
        }

        public void onCloseBanner(MBridgeIds mBridgeIds) {
            t.e(mBridgeIds, "ids");
            Bundle bundle = new Bundle();
            bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "closed");
            new z2.F(this.f24473a.getContext()).d("mintegral_banner", bundle);
        }

        public void onLeaveApp(MBridgeIds mBridgeIds) {
            t.e(mBridgeIds, "ids");
        }

        public void onLoadFailed(MBridgeIds mBridgeIds, String str) {
            t.e(mBridgeIds, "ids");
            t.e(str, "errorMsg");
            this.f24473a.b4().f22758D.setVisibility(8);
            this.f24473a.b4().f22826u0.setVisibility(8);
            this.f24473a.b4().f22758D.release();
            Bundle bundle = new Bundle();
            bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "failed");
            new z2.F(this.f24473a.getContext()).d("mintegral_banner", bundle);
        }

        public void onLoadSuccessed(MBridgeIds mBridgeIds) {
            t.e(mBridgeIds, "ids");
            this.f24473a.b4().f22826u0.setTypeface(k.f32g.x());
            this.f24473a.b4().f22826u0.setVisibility(0);
            this.f24473a.b4().f22826u0.setOnClickListener(new C2575y1(this.f24473a));
            Bundle bundle = new Bundle();
            bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "loaded");
            new z2.F(this.f24473a.getContext()).d("mintegral_banner", bundle);
        }

        public void onLogImpression(MBridgeIds mBridgeIds) {
            t.e(mBridgeIds, "ids");
        }

        public void showFullScreen(MBridgeIds mBridgeIds) {
            t.e(mBridgeIds, "ids");
        }
    }

    /* renamed from: i2.v1$v  reason: case insensitive filesystem */
    public static final class C2562v implements b {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24474a;

        C2562v(C2540v1 v1Var) {
            this.f24474a = v1Var;
        }

        public void a(Exception exc) {
            t.e(exc, "e");
        }

        public void onSuccess() {
            this.f24474a.b4().f22772N.f22848b.setVisibility(0);
            if (!((Boolean) this.f24474a.f4().G().getValue()).booleanValue()) {
                this.f24474a.b4().f22791d.setTitle(this.f24474a.a4().N());
                this.f24474a.b4().f22787b.setExpanded(false, false);
            }
            String z4 = this.f24474a.a4().z();
            if (z4 != null && z4.length() != 0) {
                this.f24474a.Z3();
                FragmentActivity activity = this.f24474a.getActivity();
                if (activity != null) {
                    this.f24474a.m7(activity);
                }
            }
        }
    }

    /* renamed from: i2.v1$w  reason: case insensitive filesystem */
    static final class C2563w extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24475a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24476b;

        /* renamed from: i2.v1$w$a */
        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C2540v1 f24477a;

            a(C2540v1 v1Var) {
                this.f24477a = v1Var;
            }

            /* renamed from: b */
            public final Object emit(z2.O o5, C2308e eVar) {
                if (!(o5 instanceof O.a)) {
                    if (o5 instanceof O.c) {
                        O.c cVar = (O.c) o5;
                        if (((B1.e) cVar.a()).a()) {
                            if (((B1.e) cVar.a()).b()) {
                                this.f24477a.v3();
                            }
                            this.f24477a.H6();
                        }
                    } else if (!(o5 instanceof O.b)) {
                        throw new q();
                    }
                }
                return W2.J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2563w(C2540v1 v1Var, C2308e eVar) {
            super(2, eVar);
            this.f24476b = v1Var;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C2563w(this.f24476b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f24475a;
            if (i5 == 0) {
                u.b(obj);
                z3.D T4 = this.f24476b.f4().T();
                a aVar = new a(this.f24476b);
                this.f24475a = 1;
                if (T4.collect(aVar, this) == f5) {
                    return f5;
                }
            } else if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                u.b(obj);
            }
            throw new C2219h();
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((C2563w) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: i2.v1$x  reason: case insensitive filesystem */
    static final class C2564x extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24478a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24479b;

        /* renamed from: i2.v1$x$a */
        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C2540v1 f24480a;

            a(C2540v1 v1Var) {
                this.f24480a = v1Var;
            }

            /* renamed from: b */
            public final Object emit(z2.O o5, C2308e eVar) {
                if (!(o5 instanceof O.a)) {
                    if (o5 instanceof O.c) {
                        O.c cVar = (O.c) o5;
                        this.f24480a.b6(((B1.C2464a) cVar.a()).a(), ((B1.C2464a) cVar.a()).b());
                    } else if (!(o5 instanceof O.b)) {
                        throw new q();
                    }
                }
                return W2.J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2564x(C2540v1 v1Var, C2308e eVar) {
            super(2, eVar);
            this.f24479b = v1Var;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C2564x(this.f24479b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f24478a;
            if (i5 == 0) {
                u.b(obj);
                z3.D F4 = this.f24479b.f4().F();
                a aVar = new a(this.f24479b);
                this.f24478a = 1;
                if (F4.collect(aVar, this) == f5) {
                    return f5;
                }
            } else if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                u.b(obj);
            }
            throw new C2219h();
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((C2564x) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: i2.v1$y  reason: case insensitive filesystem */
    static final class C2565y extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24481a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24482b;

        /* renamed from: i2.v1$y$a */
        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C2540v1 f24483a;

            a(C2540v1 v1Var) {
                this.f24483a = v1Var;
            }

            /* renamed from: b */
            public final Object emit(ArrayList arrayList, C2308e eVar) {
                this.f24483a.c6(arrayList, false);
                return W2.J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2565y(C2540v1 v1Var, C2308e eVar) {
            super(2, eVar);
            this.f24482b = v1Var;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C2565y(this.f24482b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f24481a;
            if (i5 == 0) {
                u.b(obj);
                z3.D h02 = this.f24482b.f4().h0();
                a aVar = new a(this.f24482b);
                this.f24481a = 1;
                if (h02.collect(aVar, this) == f5) {
                    return f5;
                }
            } else if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                u.b(obj);
            }
            throw new C2219h();
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((C2565y) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    /* renamed from: i2.v1$z  reason: case insensitive filesystem */
    static final class C2566z extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24484a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24485b;

        /* renamed from: i2.v1$z$a */
        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C2540v1 f24486a;

            a(C2540v1 v1Var) {
                this.f24486a = v1Var;
            }

            /* access modifiers changed from: private */
            public static final void d(C2540v1 v1Var, C2654c cVar, View view) {
                v1Var.e5(cVar);
            }

            /* renamed from: c */
            public final Object emit(C2654c cVar, C2308e eVar) {
                ArrayList a5 = cVar.a();
                if (a5 != null && !a5.isEmpty()) {
                    this.f24486a.b4().f22803j.setVisibility(0);
                    this.f24486a.b4().f22836z0.setText(this.f24486a.getString(com.uptodown.R.string.best_alternatives));
                    this.f24486a.b4().f22835z.setOnClickListener(new C2578z1(this.f24486a, cVar));
                    ArrayList a6 = cVar.a();
                    t.b(a6);
                    if (a6.size() > 20) {
                        ArrayList a7 = cVar.a();
                        t.b(a7);
                        this.f24486a.c6(new ArrayList(a7.subList(0, 20)), true);
                    } else {
                        this.f24486a.c6(cVar.a(), true);
                    }
                }
                return W2.J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        C2566z(C2540v1 v1Var, C2308e eVar) {
            super(2, eVar);
            this.f24485b = v1Var;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new C2566z(this.f24485b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f24484a;
            if (i5 == 0) {
                u.b(obj);
                z3.D A4 = this.f24485b.f4().A();
                a aVar = new a(this.f24485b);
                this.f24484a = 1;
                if (A4.collect(aVar, this) == f5) {
                    return f5;
                }
            } else if (i5 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            } else {
                u.b(obj);
            }
            throw new C2219h();
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((C2566z) create(m5, eVar)).invokeSuspend(W2.J.f19942a);
        }
    }

    public C2540v1() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C2538v(this));
        t.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f24360m = registerForActivityResult;
        ActivityResultLauncher registerForActivityResult2 = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new C2462A(this));
        t.d(registerForActivityResult2, "registerForActivityResult(...)");
        this.f24361n = registerForActivityResult2;
    }

    /* access modifiers changed from: private */
    public final void A2(View view) {
        view.setOnClickListener(new C2463B(this));
    }

    private final void A3(C2616a aVar) {
        FragmentActivity activity = getActivity();
        t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        AlertDialog p22 = ((C1598a) activity).p2();
        if (p22 != null) {
            p22.dismiss();
        }
        if (getContext() != null) {
            C2436s c5 = C2436s.c(getLayoutInflater());
            t.d(c5, "inflate(...)");
            TextView textView = c5.f23528d;
            k.a aVar2 = k.f32g;
            textView.setTypeface(aVar2.x());
            c5.f23528d.setText(getString(com.uptodown.R.string.resume_downloads_queue_dialog, a4().N()));
            c5.f23529e.setTypeface(aVar2.w());
            c5.f23529e.setText(getString(com.uptodown.R.string.updates_button_resume));
            c5.f23529e.setOnClickListener(new C2573y(aVar, this));
            c5.f23527c.setTypeface(aVar2.w());
            TextView textView2 = c5.f23527c;
            t.d(textView2, "tvCancel");
            v.b(textView2);
            c5.f23527c.setOnClickListener(new C2576z(this));
            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            builder.setView(c5.getRoot());
            builder.setCancelable(false);
            X6(builder);
        }
    }

    /* access modifiers changed from: private */
    public static final void A4(C2540v1 v1Var, View view) {
        if (UptodownApp.f13477F.Z() && v1Var.f4().R().getValue() != null) {
            Context requireContext = v1Var.requireContext();
            t.d(requireContext, "requireContext(...)");
            j jVar = new j(requireContext);
            Object value = v1Var.f4().R().getValue();
            t.b(value);
            String o5 = ((C2655d) value).o();
            t.b(o5);
            jVar.h(o5);
        }
    }

    private final void A5(Context context) {
        String W4;
        String w4;
        if (new C2954m().v(a4().S(), context)) {
            Drawable j5 = z2.P.f26510a.j(context, a4().S());
            b4().f22773O.f22872b.setImageDrawable(j5);
            b4().f22756C.f23521g.setImageDrawable(j5);
        } else {
            String E4 = a4().E();
            if (E4 == null || E4.length() == 0) {
                b4().f22773O.f22872b.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_app_icon_placeholder));
                b4().f22756C.f23521g.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_app_icon_placeholder));
            } else {
                com.squareup.picasso.w l5 = com.squareup.picasso.s.h().l(a4().G()).l(com.uptodown.R.drawable.shape_bg_placeholder);
                UptodownApp.a aVar = UptodownApp.f13477F;
                l5.n(aVar.g0(context)).j(b4().f22773O.f22872b, new G(this, context));
                com.squareup.picasso.s.h().l(a4().H()).l(com.uptodown.R.drawable.shape_bg_placeholder).n(aVar.g0(context)).i(b4().f22756C.f23521g);
            }
        }
        String E5 = a4().E();
        if ((E5 == null || E5.length() == 0) && ((w4 = a4().w()) == null || w4.length() == 0)) {
            l7(context);
        }
        String N4 = a4().N();
        if (!(N4 == null || N4.length() == 0)) {
            b4().f22773O.f22890t.setText(a4().N());
            b4().f22836z0.setText(context.getString(com.uptodown.R.string.similar_to_x, new Object[]{a4().N()}));
        }
        String B02 = a4().B0();
        if (!(B02 == null || B02.length() == 0)) {
            b4().f22773O.f22896z.setText(a4().B0());
            b4().f22773O.f22896z.setVisibility(0);
        }
        String V4 = a4().V();
        if (!(V4 == null || V4.length() == 0)) {
            b4().f22773O.f22891u.setText(a4().V());
            b4().f22773O.f22891u.setVisibility(0);
        }
        String g5 = a4().g();
        if (!(g5 == null || g5.length() == 0)) {
            b4().f22773O.f22883m.setText(a4().g());
        }
        if (a4().l() == 1) {
            b4().f22773O.f22884n.setVisibility(0);
        }
        if (a4().Z() != null) {
            C2648H Z4 = a4().Z();
            t.b(Z4);
            if (Z4.d() != null) {
                b4().f22773O.f22885o.setVisibility(0);
                TextView textView = b4().f22773O.f22885o;
                C2648H Z5 = a4().Z();
                t.b(Z5);
                textView.setText(Z5.d());
                b4().f22773O.f22885o.setOnClickListener(new C2527r0(this));
            }
        }
        String o02 = a4().o0();
        if (o02 == null || o02.length() == 0) {
            b4().f22834y0.setVisibility(8);
        } else {
            b4().f22834y0.setVisibility(0);
            k.a aVar2 = B2.k.f17347a;
            TextView textView2 = b4().f22834y0;
            t.d(textView2, "tvShortDescAppDetail");
            aVar2.a(textView2);
            TextView textView3 = b4().f22834y0;
            C2666o.a aVar3 = C2666o.f25106g;
            String o03 = a4().o0();
            t.b(o03);
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            textView3.setText(aVar3.n(o03, requireContext, this.f24359l));
        }
        String k5 = a4().k();
        if (k5 == null || k5.length() == 0) {
            b4().f22768J.setVisibility(8);
        } else {
            k.a aVar4 = B2.k.f17347a;
            TextView textView4 = b4().f22794e0;
            t.d(textView4, "tvDescAppDetail");
            aVar4.a(textView4);
            if (getResources().getConfiguration().getLayoutDirection() == 1) {
                b4().f22794e0.setTextDirection(2);
            }
            TextView textView5 = b4().f22794e0;
            C2666o.a aVar5 = C2666o.f25106g;
            String k6 = a4().k();
            t.b(k6);
            Context requireContext2 = requireContext();
            t.d(requireContext2, "requireContext(...)");
            textView5.setText(aVar5.n(k6, requireContext2, this.f24359l));
            b4().f22768J.setVisibility(0);
            String n5 = a4().n();
            if (n5 == null || n5.length() == 0) {
                String t5 = a4().t();
                if (!(t5 == null || t5.length() == 0)) {
                    TextView textView6 = b4().f22800h0;
                    String t6 = a4().t();
                    t.b(t6);
                    Context requireContext3 = requireContext();
                    t.d(requireContext3, "requireContext(...)");
                    textView6.setText(aVar5.n(t6, requireContext3, this.f24359l));
                    String s5 = a4().s();
                    if (s5 == null || s5.length() == 0) {
                        b4().f22798g0.setVisibility(8);
                    } else {
                        b4().f22798g0.setText(a4().s());
                    }
                    String r5 = a4().r();
                    if (r5 == null || r5.length() == 0) {
                        b4().f22799h.setVisibility(8);
                    } else {
                        com.squareup.picasso.w l6 = com.squareup.picasso.s.h().l(a4().r()).l(com.uptodown.R.drawable.shape_bg_placeholder);
                        UptodownApp.a aVar6 = UptodownApp.f13477F;
                        Context requireContext4 = requireContext();
                        t.d(requireContext4, "requireContext(...)");
                        l6.n(aVar6.g0(requireContext4)).i(b4().f22799h);
                    }
                    if (a4().p0() == 1) {
                        b4().f22802i0.setVisibility(0);
                    } else {
                        b4().f22802i0.setVisibility(8);
                    }
                }
            } else {
                b4().f22800h0.setText(a4().n());
                b4().f22802i0.setVisibility(8);
                b4().f22799h.setVisibility(8);
            }
        }
        String y02 = a4().y0();
        if (y02 == null || y02.length() == 0) {
            h4(com.uptodown.R.id.action_share);
        } else {
            Z6(com.uptodown.R.id.action_share);
        }
        String q02 = a4().q0();
        if (q02 == null || q02.length() == 0) {
            h4(com.uptodown.R.id.action_antivirus_report);
            b4().f22770L.f23094e.setVisibility(8);
        } else {
            Z6(com.uptodown.R.id.action_antivirus_report);
            b4().f22770L.f23094e.setVisibility(0);
        }
        String l02 = a4().l0();
        if (l02 == null || l02.length() == 0) {
            b4().f22775Q.setVisibility(8);
        } else {
            b4().f22775Q.setVisibility(0);
            b4().f22828v0.setText(a4().l0());
        }
        if (a4().a0() == 0) {
            b4().f22773O.f22882l.setVisibility(8);
            b4().f22773O.f22869A.setVisibility(8);
            b4().f22773O.f22873c.setWeightSum(2.0f);
        } else {
            b4().f22773O.f22894x.setVisibility(0);
            b4().f22773O.f22894x.setText(String.valueOf(((double) a4().a0()) / 10.0d));
            if (a4().b0() == 1) {
                b4().f22773O.f22893w.setText(getString(com.uptodown.R.string.reviews_counter_single));
            } else {
                TextView textView7 = b4().f22773O.f22893w;
                kotlin.jvm.internal.Q q5 = kotlin.jvm.internal.Q.f24695a;
                String string = getString(com.uptodown.R.string.reviews_counter_multiple);
                t.d(string, "getString(...)");
                String format = String.format(string, Arrays.copyOf(new Object[]{new C2291k().b((long) a4().b0())}, 1));
                t.d(format, "format(...)");
                textView7.setText(format);
            }
        }
        if (!a4().M0() || (W4 = a4().W()) == null || W4.length() == 0) {
            b4().f22773O.f22886p.setText(new C2291k().b((long) a4().q()));
            b4().f22773O.f22887q.setText(getString(com.uptodown.R.string.more_info_downloads_label));
            String S4 = a4().S();
            if (S4 == null || S4.length() == 0) {
                b4().f22823t.setVisibility(8);
            } else {
                b4().f22806k0.setText(a4().S());
            }
            String q03 = a4().q0();
            if (q03 == null || q03.length() == 0) {
                b4().f22827v.setVisibility(8);
            } else {
                TextView textView8 = b4().f22814o0;
                C2291k kVar = new C2291k();
                long e42 = e4();
                Context requireContext5 = requireContext();
                t.d(requireContext5, "requireContext(...)");
                textView8.setText(kVar.d(e42, requireContext5));
            }
            String T4 = a4().T();
            if (T4 == null || T4.length() == 0) {
                b4().f22825u.setVisibility(8);
            } else {
                String T5 = a4().T();
                t.b(T5);
                if (t3.s.t(T5) != null) {
                    b4().f22810m0.setText(getString(com.uptodown.R.string.pegi_plus, a4().T()));
                } else {
                    b4().f22810m0.setText(a4().T());
                }
            }
        } else {
            b4().f22773O.f22886p.setText(a4().W());
            b4().f22767I.setVisibility(8);
        }
        String I4 = a4().I();
        if (I4 == null || I4.length() == 0 || a4().M0()) {
            b4().f22773O.f22877g.setVisibility(8);
            b4().f22773O.f22870B.setVisibility(8);
        } else {
            b4().f22773O.f22888r.setText(a4().I());
        }
        b4().f22833y.f23224o.setText(String.valueOf(((double) a4().a0()) / 10.0d));
        if (a4().b0() == 1) {
            b4().f22833y.f23225p.setText(getString(com.uptodown.R.string.comment_counter_single));
        } else {
            TextView textView9 = b4().f22833y.f23225p;
            kotlin.jvm.internal.Q q6 = kotlin.jvm.internal.Q.f24695a;
            String string2 = getString(com.uptodown.R.string.reviews_counter_multiple);
            t.d(string2, "getString(...)");
            String format2 = String.format(string2, Arrays.copyOf(new Object[]{new C2291k().b((long) a4().b0())}, 1));
            t.d(format2, "format(...)");
            textView9.setText(format2);
        }
        b4().f22833y.f23225p.setOnClickListener(new C0(this));
        String O4 = a4().O();
        if (O4 == null || O4.length() == 0) {
            b4().f22778T.getRoot().setVisibility(8);
        } else {
            b4().f22778T.f23673d.setText(a4().O());
            b4().f22778T.f23673d.getViewTreeObserver().addOnGlobalLayoutListener(new N0(this));
            b4().f22778T.getRoot().setVisibility(0);
        }
        String v02 = a4().v0();
        if (v02 == null || v02.length() == 0) {
            String C02 = a4().C0();
            if (!(C02 == null || C02.length() == 0)) {
                b4().f22757C0.setText(a4().C0());
            }
        } else {
            b4().f22757C0.setText(a4().v0());
        }
        C2641A b5 = C2641A.f24721f.b(context);
        if (b5 != null && b5.b() == a4().e() && !b5.g()) {
            b5.p(context);
        }
        if (t.a(a4().S(), requireContext().getPackageName()) || t.a(a4().S(), "com.uptodown.installer")) {
            b4().f22817q.setVisibility(8);
        }
        ArrayList z02 = a4().z0();
        if (z02 != null && !z02.isEmpty() && b4().f22752A.getVisibility() == 8) {
            b4().f22752A.setVisibility(0);
            TextView textView10 = b4().f22755B0;
            k.a aVar7 = S1.k.f32g;
            textView10.setTypeface(aVar7.w());
            b4().f22753A0.setTypeface(aVar7.x());
            ArrayList z03 = a4().z0();
            t.b(z03);
            Iterator it = z03.iterator();
            t.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                t.d(next, "next(...)");
                String str = (String) next;
                if (str.length() > 0) {
                    Y0 c5 = Y0.c(getLayoutInflater());
                    t.d(c5, "inflate(...)");
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams.setMargins(0, (int) getResources().getDimension(com.uptodown.R.dimen.margin_m), 0, 0);
                    c5.getRoot().setLayoutParams(layoutParams);
                    c5.f22717c.setTypeface(S1.k.f32g.x());
                    c5.f22717c.setText(str);
                    b4().f22754B.addView(c5.getRoot());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void A6(String str) {
        i4();
        b4().f22773O.f22892v.setText(str);
        b4().f22766H.f22358o.setText(str);
    }

    /* access modifiers changed from: private */
    public static final void B2(C2540v1 v1Var, View view) {
        if (UptodownApp.f13477F.Z()) {
            B1 f42 = v1Var.f4();
            Context requireContext = v1Var.requireContext();
            t.d(requireContext, "requireContext(...)");
            long e5 = v1Var.a4().e();
            String N4 = v1Var.a4().N();
            t.b(N4);
            f42.t(requireContext, e5, N4, v1Var.a4().H(), v1Var.b4().f22783Y.isChecked());
        }
    }

    /* access modifiers changed from: private */
    public static final void B3(C2616a aVar, C2540v1 v1Var, View view) {
        aVar.invoke();
        FragmentActivity activity = v1Var.getActivity();
        t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        AlertDialog p22 = ((C1598a) activity).p2();
        if (p22 != null) {
            p22.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final void B4(C2540v1 v1Var, View view) {
        if (UptodownApp.f13477F.Z()) {
            v1Var.M3();
        }
    }

    /* access modifiers changed from: private */
    public static final void B5(C2540v1 v1Var, View view) {
        C2660i iVar = new C2660i(0, (String) null, (String) null, 7, (C2633k) null);
        C2648H Z4 = v1Var.a4().Z();
        t.b(Z4);
        if (Z4.a() > -1) {
            C2648H Z5 = v1Var.a4().Z();
            t.b(Z5);
            iVar.w(Z5.a());
        } else {
            C2648H Z6 = v1Var.a4().Z();
            t.b(Z6);
            if (Z6.c() > -1) {
                C2648H Z7 = v1Var.a4().Z();
                t.b(Z7);
                iVar.w(Z7.c());
                iVar.v(true);
            }
        }
        C2648H Z8 = v1Var.a4().Z();
        t.b(Z8);
        String b5 = Z8.b();
        if (!(b5 == null || b5.length() == 0)) {
            C2648H Z9 = v1Var.a4().Z();
            t.b(Z9);
            iVar.x(Z9.b());
        }
        v1Var.i5(iVar);
    }

    /* access modifiers changed from: private */
    public final void B6() {
        h7();
        c cVar = c.f17333a;
        ProgressBar progressBar = b4().f22773O.f22879i;
        t.d(progressBar, "pbProgressAppDetail");
        ImageView imageView = b4().f22773O.f22872b;
        t.d(imageView, "ivLogoAppDetail");
        cVar.c(progressBar, imageView);
        b4().f22773O.f22876f.setVisibility(0);
        b4().f22773O.f22874d.setVisibility(8);
        b4().f22770L.f23092c.setVisibility(8);
        b4().f22770L.f23100k.setOnClickListener(new C2505j1(this));
        f4().Q().setValue(3);
        TextView textView = b4().f22770L.f23100k;
        t.d(textView, "tvDownloadCancel");
        String string = getString(com.uptodown.R.string.option_button_install);
        t.d(string, "getString(...)");
        m6(textView, string);
        TextView textView2 = b4().f22766H.f22360q;
        t.d(textView2, "tvStatusDownload");
        String string2 = getString(com.uptodown.R.string.option_button_install);
        t.d(string2, "getString(...)");
        m6(textView2, string2);
        h4(com.uptodown.R.id.action_app_installed_details);
        h4(com.uptodown.R.id.action_uninstall);
    }

    /* access modifiers changed from: private */
    public final void C2() {
        if (Q4()) {
            C2661j m5 = UptodownApp.f13477F.m();
            t.b(m5);
            if (m5.b() == -1 && getContext() != null) {
                a.C0147a aVar = a.f15150a;
                Context requireContext = requireContext();
                t.d(requireContext, "requireContext(...)");
                if (aVar.R(requireContext)) {
                    Context requireContext2 = requireContext();
                    t.d(requireContext2, "requireContext(...)");
                    if (!aVar.e0(requireContext2)) {
                        Context requireContext3 = requireContext();
                        t.d(requireContext3, "requireContext(...)");
                        aVar.g1(requireContext3, false);
                    }
                    Context requireContext4 = requireContext();
                    t.d(requireContext4, "requireContext(...)");
                    P3(requireContext4);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void C3(C2540v1 v1Var, View view) {
        FragmentActivity activity = v1Var.getActivity();
        t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        AlertDialog p22 = ((C1598a) activity).p2();
        if (p22 != null) {
            p22.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final void C4(C2540v1 v1Var, View view) {
        if (UptodownApp.f13477F.Z() && !((Boolean) v1Var.f4().m0().getValue()).booleanValue()) {
            v1Var.z5();
        }
    }

    /* access modifiers changed from: private */
    public static final void C5(C2540v1 v1Var, View view) {
        v1Var.w5();
    }

    /* access modifiers changed from: private */
    public static final void C6(C2540v1 v1Var, View view) {
        Context requireContext = v1Var.requireContext();
        t.d(requireContext, "requireContext(...)");
        v1Var.P3(requireContext);
    }

    private final void D2(C2415h hVar) {
        hVar.f23100k.setTypeface(S1.k.f32g.w());
        hVar.f23101l.setOnClickListener(new C2478a1(this));
        hVar.f23100k.setOnClickListener(new C2481b1(this));
        hVar.f23101l.setFocusable(true);
        hVar.f23102m.setOnClickListener(new C2484c1(this));
    }

    private final void D3(Context context) {
        FragmentActivity activity = getActivity();
        t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        AlertDialog p22 = ((C1598a) activity).p2();
        if (p22 != null) {
            p22.dismiss();
        }
        Drawable drawable = ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on);
        Drawable drawable2 = ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off);
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        C2398B c5 = C2398B.c(getLayoutInflater());
        t.d(c5, "inflate(...)");
        String H4 = a4().H();
        if (H4 == null || H4.length() == 0) {
            c5.f22265d.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_app_icon_placeholder));
        } else {
            com.squareup.picasso.s.h().l(a4().H()).n(UptodownApp.f13477F.g0(context)).i(c5.f22265d);
        }
        TextView textView = c5.f22271j;
        k.a aVar = S1.k.f32g;
        textView.setTypeface(aVar.w());
        c5.f22271j.setText(a4().N());
        c5.f22264c.setText((CharSequence) f4().c0().getValue());
        int intValue = ((Number) f4().a0().getValue()).intValue();
        if (intValue == 1) {
            c5.f22266e.setImageDrawable(drawable);
            c5.f22267f.setImageDrawable(drawable2);
            c5.f22268g.setImageDrawable(drawable2);
            c5.f22269h.setImageDrawable(drawable2);
            c5.f22270i.setImageDrawable(drawable2);
        } else if (intValue == 2) {
            c5.f22266e.setImageDrawable(drawable);
            c5.f22267f.setImageDrawable(drawable);
            c5.f22268g.setImageDrawable(drawable2);
            c5.f22269h.setImageDrawable(drawable2);
            c5.f22270i.setImageDrawable(drawable2);
        } else if (intValue == 3) {
            c5.f22266e.setImageDrawable(drawable);
            c5.f22267f.setImageDrawable(drawable);
            c5.f22268g.setImageDrawable(drawable);
            c5.f22269h.setImageDrawable(drawable2);
            c5.f22270i.setImageDrawable(drawable2);
        } else if (intValue == 4) {
            c5.f22266e.setImageDrawable(drawable);
            c5.f22267f.setImageDrawable(drawable);
            c5.f22268g.setImageDrawable(drawable);
            c5.f22269h.setImageDrawable(drawable);
            c5.f22270i.setImageDrawable(drawable2);
        } else if (intValue != 5) {
            c5.f22266e.setImageDrawable(drawable2);
            c5.f22267f.setImageDrawable(drawable2);
            c5.f22268g.setImageDrawable(drawable2);
            c5.f22269h.setImageDrawable(drawable2);
            c5.f22270i.setImageDrawable(drawable2);
        } else {
            c5.f22266e.setImageDrawable(drawable);
            c5.f22267f.setImageDrawable(drawable);
            c5.f22268g.setImageDrawable(drawable);
            c5.f22269h.setImageDrawable(drawable);
            c5.f22270i.setImageDrawable(drawable);
        }
        c5.f22266e.setOnClickListener(new C2502i1(this, c5, drawable, drawable2));
        c5.f22267f.setOnClickListener(new C2508k1(this, c5, drawable, drawable2));
        c5.f22268g.setOnClickListener(new C2511l1(this, c5, drawable, drawable2));
        c5.f22269h.setOnClickListener(new C2514m1(this, c5, drawable, drawable2));
        c5.f22270i.setOnClickListener(new C2517n1(this, c5, drawable));
        c5.f22264c.setTypeface(aVar.x());
        if (f4().S().getValue() != null) {
            Object value = f4().S().getValue();
            t.b(value);
            String j5 = ((l2.O) value).j();
            if (!(j5 == null || j5.length() == 0)) {
                EditText editText = c5.f22264c;
                Object value2 = f4().S().getValue();
                t.b(value2);
                editText.setText(String.valueOf(((l2.O) value2).j()));
            }
            Object value3 = f4().S().getValue();
            t.b(value3);
            if (((l2.O) value3).i() >= 1) {
                c5.f22266e.setImageDrawable(ContextCompat.getDrawable(requireContext(), com.uptodown.R.drawable.vector_star_on));
            }
            Object value4 = f4().S().getValue();
            t.b(value4);
            if (((l2.O) value4).i() >= 2) {
                c5.f22267f.setImageDrawable(ContextCompat.getDrawable(requireContext(), com.uptodown.R.drawable.vector_star_on));
            }
            Object value5 = f4().S().getValue();
            t.b(value5);
            if (((l2.O) value5).i() >= 3) {
                c5.f22268g.setImageDrawable(ContextCompat.getDrawable(requireContext(), com.uptodown.R.drawable.vector_star_on));
            }
            Object value6 = f4().S().getValue();
            t.b(value6);
            if (((l2.O) value6).i() >= 4) {
                c5.f22269h.setImageDrawable(ContextCompat.getDrawable(requireContext(), com.uptodown.R.drawable.vector_star_on));
            }
            Object value7 = f4().S().getValue();
            t.b(value7);
            if (((l2.O) value7).i() == 5) {
                c5.f22270i.setImageDrawable(ContextCompat.getDrawable(requireContext(), com.uptodown.R.drawable.vector_star_on));
            }
        }
        c5.f22273l.setTypeface(aVar.w());
        c5.f22273l.setOnClickListener(new C2520o1(context, this, c5));
        c5.f22272k.setTypeface(aVar.w());
        c5.f22272k.setOnClickListener(new C2523p1(this, c5));
        builder.setView(c5.getRoot());
        FragmentActivity activity2 = getActivity();
        t.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        AlertDialog p23 = ((C1598a) activity2).p2();
        if (p23 != null) {
            p23.setOnDismissListener(new C2526q1(this, context));
        }
        X6(builder);
    }

    /* access modifiers changed from: private */
    public static final void D4(C2540v1 v1Var, View view) {
        if (UptodownApp.f13477F.Z()) {
            v1Var.y2();
        }
    }

    /* access modifiers changed from: private */
    public static final void D5(C2540v1 v1Var) {
        TextView textView = v1Var.b4().f22778T.f23673d;
        t.d(textView, "tvWhatsNewContent");
        if (!s.a(textView) && v1Var.b4().f22778T.f23673d.getMaxLines() <= 6) {
            v1Var.b4().f22778T.f23671b.setVisibility(8);
            v1Var.b4().f22778T.f23674e.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public final void D6(Context context, C2668q qVar) {
        long j5;
        z2.E e5 = new z2.E();
        Context requireContext = requireContext();
        t.d(requireContext, "requireContext(...)");
        File h5 = e5.h(requireContext);
        z2.E e6 = new z2.E();
        Context requireContext2 = requireContext();
        t.d(requireContext2, "requireContext(...)");
        long m5 = e6.m(requireContext2, h5);
        try {
            j5 = h5.getTotalSpace();
        } catch (SecurityException unused) {
            j5 = 0;
        }
        if (j5 > 0) {
            Context requireContext3 = requireContext();
            t.d(requireContext3, "requireContext(...)");
            String d5 = new C2291k().d(((long) (((double) e4()) * 2.25d)) - m5, requireContext3);
            long j6 = ((j5 - m5) * ((long) 100)) / j5;
            TextView textView = b4().f22765G0.f23642g;
            k.a aVar = S1.k.f32g;
            textView.setTypeface(aVar.x());
            b4().f22765G0.f23639d.setProgress((int) j6);
            b4().f22765G0.f23643h.setTypeface(aVar.x());
            b4().f22765G0.f23643h.setText(context.getString(com.uptodown.R.string.no_storage_text, new Object[]{d5}));
            b4().f22765G0.f23641f.setTypeface(aVar.w());
            b4().f22765G0.f23641f.setOnClickListener(new C2537u1(this));
            b4().f22765G0.getRoot().setVisibility(0);
        }
        if (qVar == null || !qVar.f()) {
            v6(context);
        } else {
            B6();
        }
    }

    /* access modifiers changed from: private */
    public static final void E2(C2540v1 v1Var, View view) {
        v1Var.f5();
    }

    /* access modifiers changed from: private */
    public static final void E3(C2540v1 v1Var, C2398B b5, Drawable drawable, Drawable drawable2, View view) {
        if (UptodownApp.f13477F.Z()) {
            v1Var.f4().a0().setValue(1);
            b5.f22266e.setImageDrawable(drawable);
            b5.f22267f.setImageDrawable(drawable2);
            b5.f22268g.setImageDrawable(drawable2);
            b5.f22269h.setImageDrawable(drawable2);
            b5.f22270i.setImageDrawable(drawable2);
        }
    }

    /* access modifiers changed from: private */
    public static final void E4(C2540v1 v1Var, View view) {
        if (UptodownApp.f13477F.Z()) {
            v1Var.z2();
        }
    }

    /* access modifiers changed from: private */
    public final void E5(ArrayList arrayList) {
        LinearLayout linearLayout = b4().f22819r;
        t.d(linearLayout, "llFloatingCategoriesAppDetail");
        if (linearLayout.getChildCount() == 0) {
            b4().f22804j0.setTypeface(S1.k.f32g.w());
            if (getActivity() != null) {
                HorizontalScrollView horizontalScrollView = new HorizontalScrollView(requireContext());
                horizontalScrollView.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                horizontalScrollView.setHorizontalScrollBarEnabled(false);
                LinearLayout linearLayout2 = new LinearLayout(requireContext());
                linearLayout2.setOrientation(0);
                linearLayout2.setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
                horizontalScrollView.addView(linearLayout2);
                b4().f22819r.addView(horizontalScrollView);
                Iterator it = arrayList.iterator();
                t.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    t.d(next, "next(...)");
                    C2660i iVar = (C2660i) next;
                    int dimension = (int) getResources().getDimension(com.uptodown.R.dimen.margin_m);
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    if (t.a(iVar, C2250q.X(arrayList))) {
                        layoutParams.setMargins(dimension, 0, dimension, 0);
                    } else {
                        layoutParams.setMargins(dimension, 0, 0, 0);
                    }
                    linearLayout2.addView(F5(iVar, layoutParams));
                }
            }
            b4().f22821s.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public static final void E6(C2540v1 v1Var, View view) {
        Intent intent = new Intent(v1Var.requireActivity(), FreeUpSpaceActivity.class);
        intent.putExtra("appInfo", v1Var.a4());
        UptodownApp.a aVar = UptodownApp.f13477F;
        FragmentActivity requireActivity = v1Var.requireActivity();
        t.d(requireActivity, "requireActivity(...)");
        v1Var.startActivity(intent, aVar.a(requireActivity));
    }

    /* access modifiers changed from: private */
    public static final void F2(C2540v1 v1Var, View view) {
        Context requireContext = v1Var.requireContext();
        t.d(requireContext, "requireContext(...)");
        v1Var.P3(requireContext);
    }

    /* access modifiers changed from: private */
    public static final void F3(C2540v1 v1Var, C2398B b5, Drawable drawable, Drawable drawable2, View view) {
        if (UptodownApp.f13477F.Z()) {
            v1Var.f4().a0().setValue(2);
            b5.f22266e.setImageDrawable(drawable);
            b5.f22267f.setImageDrawable(drawable);
            b5.f22268g.setImageDrawable(drawable2);
            b5.f22269h.setImageDrawable(drawable2);
            b5.f22270i.setImageDrawable(drawable2);
        }
    }

    private final View F5(C2660i iVar, LinearLayout.LayoutParams layoutParams) {
        C2421k c5 = C2421k.c(getLayoutInflater());
        t.d(c5, "inflate(...)");
        c5.getRoot().setLayoutParams(layoutParams);
        c5.getRoot().setTypeface(S1.k.f32g.w());
        c5.getRoot().setText(String.valueOf(iVar.e()));
        c5.getRoot().setOnClickListener(new C2466C(this, iVar));
        TextView b5 = c5.getRoot();
        t.d(b5, "getRoot(...)");
        return b5;
    }

    /* access modifiers changed from: private */
    public final void F6(Context context) {
        String str;
        C2668q qVar;
        j7();
        c cVar = c.f17333a;
        ProgressBar progressBar = b4().f22773O.f22879i;
        t.d(progressBar, "pbProgressAppDetail");
        ImageView imageView = b4().f22773O.f22872b;
        t.d(imageView, "ivLogoAppDetail");
        cVar.c(progressBar, imageView);
        f4().Q().setValue(0);
        C2660i h5 = a4().h();
        if (h5 == null || h5.j() != 1) {
            str = context.getString(com.uptodown.R.string.open);
        } else {
            str = context.getString(com.uptodown.R.string.app_detail_play_button);
        }
        b4().f22766H.f22356m.setText(str);
        TextView textView = b4().f22770L.f23101l;
        t.d(textView, "tvOpen");
        m6(textView, str);
        Z6(com.uptodown.R.id.action_uninstall);
        Z6(com.uptodown.R.id.action_app_installed_details);
        String S4 = a4().S();
        if (S4 != null && S4.length() != 0 && t3.s.E(requireActivity().getPackageName(), a4().S(), true)) {
            b4().f22770L.f23093d.setVisibility(8);
            b4().f22770L.f23101l.setVisibility(8);
            b4().f22770L.f23094e.setVisibility(8);
            b4().f22770L.f23095f.setVisibility(8);
            b4().f22766H.f22356m.setVisibility(8);
            if (694 < a4().J()) {
                l2.T t5 = (l2.T) f4().j0().getValue();
                if (t5 != null) {
                    qVar = t5.b(context);
                } else {
                    qVar = null;
                }
                if (qVar == null && a4().A() > 0) {
                    C2940B a5 = C2940B.f26458v.a(context);
                    a5.a();
                    C2668q h02 = a5.h0(String.valueOf(a4().A()));
                    a5.m();
                    qVar = h02;
                }
                if (qVar == null || !qVar.f()) {
                    w j02 = f4().j0();
                    String packageName = requireActivity().getPackageName();
                    t.d(packageName, "getPackageName(...)");
                    j02.setValue(new l2.T(packageName));
                    v6(context);
                    return;
                }
                O6(context);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void G2(C2540v1 v1Var, View view) {
        DownloadWorker.a aVar = DownloadWorker.f21359d;
        if (!aVar.j(v1Var.a4().e())) {
            String S4 = v1Var.a4().S();
            t.b(S4);
            if (!aVar.l(S4)) {
                return;
            }
        }
        if (aVar.h()) {
            aVar.o();
            return;
        }
        C2940B.a aVar2 = C2940B.f26458v;
        Context requireContext = v1Var.requireContext();
        t.d(requireContext, "requireContext(...)");
        C2940B a5 = aVar2.a(requireContext);
        a5.a();
        String S5 = v1Var.a4().S();
        t.b(S5);
        C2668q k02 = a5.k0(S5, v1Var.a4().A0());
        if (k02 == null) {
            String S6 = v1Var.a4().S();
            t.b(S6);
            k02 = a5.k0(S6, v1Var.a4().J());
        }
        a5.m();
        if (k02 != null && aVar.m(k02)) {
            z2.F f5 = v1Var.f24351d;
            if (f5 != null) {
                Bundle bundle = new Bundle();
                bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "paused");
                W2.J j5 = W2.J.f19942a;
                f5.d("download", bundle);
            }
            aVar.n();
            v1Var.G6((C2668q) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void G3(C2540v1 v1Var, C2398B b5, Drawable drawable, Drawable drawable2, View view) {
        if (UptodownApp.f13477F.Z()) {
            v1Var.f4().a0().setValue(3);
            b5.f22266e.setImageDrawable(drawable);
            b5.f22267f.setImageDrawable(drawable);
            b5.f22268g.setImageDrawable(drawable);
            b5.f22269h.setImageDrawable(drawable2);
            b5.f22270i.setImageDrawable(drawable2);
        }
    }

    /* access modifiers changed from: private */
    public static final void G4(C2540v1 v1Var, Context context, AppBarLayout appBarLayout, int i5) {
        t.e(appBarLayout, "appBarLayout");
        if (Math.abs(i5) == appBarLayout.getTotalScrollRange()) {
            v1Var.f4().i0().setValue(Boolean.TRUE);
        } else if (((double) Math.abs(i5)) > ((double) appBarLayout.getTotalScrollRange()) * v1Var.f24358k) {
            v1Var.f4().i0().setValue(Boolean.FALSE);
            v1Var.l7(context);
        } else {
            v1Var.m7(context);
            v1Var.f4().i0().setValue(Boolean.FALSE);
        }
    }

    /* access modifiers changed from: private */
    public static final void G5(C2540v1 v1Var, C2660i iVar, View view) {
        if (UptodownApp.f13477F.Z()) {
            v1Var.i5(iVar);
        }
    }

    /* access modifiers changed from: private */
    public final void G6(C2668q qVar) {
        x6(qVar);
        TextView textView = b4().f22770L.f23100k;
        t.d(textView, "tvDownloadCancel");
        String string = getString(com.uptodown.R.string.option_button_cancel);
        t.d(string, "getString(...)");
        n6(textView, string);
        TextView textView2 = b4().f22770L.f23102m;
        t.d(textView2, "tvPause");
        String string2 = getString(com.uptodown.R.string.updates_button_resume);
        t.d(string2, "getString(...)");
        m6(textView2, string2);
        b4().f22766H.f22345b.setVisibility(8);
        b4().f22766H.f22347d.setVisibility(0);
    }

    private final void H2(h2.F f5) {
        TextView textView = f5.f22360q;
        k.a aVar = S1.k.f32g;
        textView.setTypeface(aVar.w());
        f5.f22354k.setTypeface(aVar.w());
        f5.f22358o.setTypeface(aVar.x());
        f5.f22359p.setTypeface(aVar.x());
        f5.f22357n.setTypeface(aVar.x());
        f5.f22355l.setTypeface(aVar.x());
        f5.f22356m.setTypeface(aVar.w());
        f5.f22361r.setTypeface(aVar.w());
        f5.f22360q.setOnClickListener(new M0(this));
        f5.f22360q.setFocusable(true);
        f5.f22345b.setOnClickListener(new O0(f5, this));
        f5.f22347d.setOnClickListener(new P0(f5));
        f5.f22356m.setOnClickListener(new Q0(this));
        f5.f22356m.setFocusable(true);
    }

    /* access modifiers changed from: private */
    public static final void H3(C2540v1 v1Var, C2398B b5, Drawable drawable, Drawable drawable2, View view) {
        if (UptodownApp.f13477F.Z()) {
            v1Var.f4().a0().setValue(4);
            b5.f22266e.setImageDrawable(drawable);
            b5.f22267f.setImageDrawable(drawable);
            b5.f22268g.setImageDrawable(drawable);
            b5.f22269h.setImageDrawable(drawable);
            b5.f22270i.setImageDrawable(drawable2);
        }
    }

    /* access modifiers changed from: private */
    public static final void H4(C2540v1 v1Var, CompoundButton compoundButton, boolean z4) {
        B1 f42 = v1Var.f4();
        Context requireContext = v1Var.requireContext();
        t.d(requireContext, "requireContext(...)");
        f42.z0(requireContext, v1Var.a4().e(), z4);
    }

    /* access modifiers changed from: private */
    public final void H5() {
        Context requireContext = requireContext();
        t.d(requireContext, "requireContext(...)");
        A5(requireContext);
        Context requireContext2 = requireContext();
        t.d(requireContext2, "requireContext(...)");
        f7(requireContext2);
        v7();
        g6();
        f4().z().setValue(Boolean.TRUE);
        if (((Number) f4().n0().getValue()).intValue() > 0) {
            t7();
        }
        W3();
    }

    /* access modifiers changed from: private */
    public final void H6() {
        k7();
        V.b bVar = l2.V.f24870q;
        Context requireContext = requireContext();
        t.d(requireContext, "requireContext(...)");
        if (bVar.h(requireContext) == null) {
            TextView textView = b4().f22770L.f23100k;
            t.d(textView, "tvDownloadCancel");
            String string = getString(com.uptodown.R.string.pre_registration_title);
            t.d(string, "getString(...)");
            m6(textView, string);
            b4().f22766H.f22361r.setText(getString(com.uptodown.R.string.pre_registration_title));
            b4().f22766H.f22348e.setVisibility(0);
            TextView textView2 = b4().f22770L.f23100k;
            t.d(textView2, "tvDownloadCancel");
            n5(textView2);
            RelativeLayout relativeLayout = b4().f22766H.f22353j;
            t.d(relativeLayout, "rlStatusPreRegister");
            n5(relativeLayout);
        } else {
            Z2();
        }
        b4().f22773O.f22876f.setVisibility(0);
        b4().f22773O.f22874d.setVisibility(8);
        b4().f22773O.f22887q.setVisibility(8);
        b4().f22770L.f23094e.setVisibility(8);
        b4().f22829w.setVisibility(8);
        h4(com.uptodown.R.id.action_antivirus_report);
        h4(com.uptodown.R.id.action_uninstall);
    }

    /* access modifiers changed from: private */
    public static final void I2(C2540v1 v1Var, View view) {
        Context requireContext = v1Var.requireContext();
        t.d(requireContext, "requireContext(...)");
        v1Var.P3(requireContext);
    }

    /* access modifiers changed from: private */
    public static final void I3(C2540v1 v1Var, C2398B b5, Drawable drawable, View view) {
        if (UptodownApp.f13477F.Z()) {
            v1Var.f4().a0().setValue(5);
            b5.f22266e.setImageDrawable(drawable);
            b5.f22267f.setImageDrawable(drawable);
            b5.f22268g.setImageDrawable(drawable);
            b5.f22269h.setImageDrawable(drawable);
            b5.f22270i.setImageDrawable(drawable);
        }
    }

    /* access modifiers changed from: private */
    public static final void I4(C2540v1 v1Var, NestedScrollView nestedScrollView, int i5, int i6, int i7, int i8) {
        boolean z4;
        Rect rect = new Rect();
        v1Var.b4().f22786a0.getHitRect(rect);
        v1Var.W6(rect);
        if (v1Var.b4().f22773O.f22890t.getLocalVisibleRect(rect)) {
            v1Var.b4().f22791d.setTitle("");
            v1Var.f4().G().setValue(Boolean.TRUE);
            return;
        }
        boolean booleanValue = ((Boolean) v1Var.f4().G().getValue()).booleanValue();
        v1Var.f4().G().setValue(Boolean.FALSE);
        String N4 = v1Var.a4().N();
        if (N4 != null && N4.length() != 0) {
            ArrayList D02 = v1Var.a4().D0();
            if (D02 == null || D02.isEmpty()) {
                String z5 = v1Var.a4().z();
                if (z5 == null || z5.length() == 0) {
                    v1Var.b4().f22791d.setTitleEnabled(false);
                    z4 = true;
                } else {
                    z4 = ((Boolean) v1Var.f4().i0().getValue()).booleanValue();
                }
            } else {
                z4 = ((Boolean) v1Var.f4().i0().getValue()).booleanValue();
            }
            if (booleanValue && z4) {
                if (v1Var.getResources().getConfiguration().getLayoutDirection() == 1) {
                    String N5 = v1Var.a4().N();
                    t.b(N5);
                    int length = N5.length() - 1;
                    int i9 = 0;
                    for (int i10 = 0; i10 < length; i10++) {
                        String N6 = v1Var.a4().N();
                        t.b(N6);
                        char charAt = N6.charAt(i10);
                        if (charAt != ' ' && !z2.P.f26510a.i(charAt)) {
                            i9++;
                        }
                    }
                    if (i9 > 0) {
                        v1Var.b4().f22791d.setRtlTextDirectionHeuristicsEnabled(false);
                        v1Var.b4().f22791d.setLayoutDirection(0);
                    }
                }
                CollapsingToolbarLayout collapsingToolbarLayout = v1Var.b4().f22791d;
                String N7 = v1Var.a4().N();
                t.b(N7);
                collapsingToolbarLayout.setTitle(N7);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void I5(l2.O o5) {
        if (getActivity() != null && !requireActivity().isFinishing() && o5 != null) {
            if (o5.i() >= 1) {
                b4().f22756C.f23516b.setImageDrawable(ContextCompat.getDrawable(requireContext(), com.uptodown.R.drawable.vector_star_on));
            }
            if (o5.i() >= 2) {
                b4().f22756C.f23517c.setImageDrawable(ContextCompat.getDrawable(requireContext(), com.uptodown.R.drawable.vector_star_on));
            }
            if (o5.i() >= 3) {
                b4().f22756C.f23518d.setImageDrawable(ContextCompat.getDrawable(requireContext(), com.uptodown.R.drawable.vector_star_on));
            }
            if (o5.i() >= 4) {
                b4().f22756C.f23519e.setImageDrawable(ContextCompat.getDrawable(requireContext(), com.uptodown.R.drawable.vector_star_on));
            }
            if (o5.i() == 5) {
                b4().f22756C.f23520f.setImageDrawable(ContextCompat.getDrawable(requireContext(), com.uptodown.R.drawable.vector_star_on));
            }
            b4().f22756C.f23523i.setText(getString(com.uptodown.R.string.edit_your_review));
        }
    }

    /* access modifiers changed from: private */
    public final void I6(Context context) {
        b4().f22773O.f22896z.setVisibility(8);
        b4().f22773O.f22875e.setVisibility(8);
        if (f4().R().getValue() != null) {
            F6(context);
        } else {
            String h02 = a4().h0();
            if (h02 == null || h02.length() == 0) {
                String string = getString(com.uptodown.R.string.app_detail_not_available);
                t.d(string, "getString(...)");
                s6(string);
            } else {
                String h03 = a4().h0();
                t.b(h03);
                s6(h03);
            }
        }
        b4().f22770L.f23094e.setVisibility(8);
        h4(com.uptodown.R.id.action_antivirus_report);
    }

    /* access modifiers changed from: private */
    public static final void J2(h2.F f5, C2540v1 v1Var, View view) {
        if (f5.f22345b.getVisibility() == 0) {
            v1Var.e3();
        }
    }

    /* access modifiers changed from: private */
    public static final void J3(Context context, C2540v1 v1Var, C2398B b5, View view) {
        String str;
        if (UptodownApp.f13477F.Z()) {
            l2.V h5 = l2.V.f24870q.h(context);
            w c02 = v1Var.f4().c0();
            Editable text = b5.f22264c.getText();
            t.d(text, "getText(...)");
            c02.setValue(t3.s.W0(text).toString());
            if (h5 != null) {
                str = h5.j();
            } else {
                str = null;
            }
            if (str != null) {
                String j5 = h5.j();
                t.b(j5);
                if (j5.length() > 0) {
                    v1Var.j6((String) v1Var.f4().c0().getValue());
                    FragmentActivity activity = v1Var.getActivity();
                    t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                    AlertDialog p22 = ((C1598a) activity).p2();
                    if (p22 != null) {
                        p22.dismiss();
                        return;
                    }
                    return;
                }
            }
            v1Var.m5();
        }
    }

    /* access modifiers changed from: private */
    public static final void J4(C2540v1 v1Var, View view) {
        v1Var.t5();
    }

    /* access modifiers changed from: private */
    public final void J5(ArrayList arrayList) {
        if (b4().f22815p.getVisibility() == 8 && !arrayList.isEmpty()) {
            R1.K k5 = new R1.K(new H(this), new I(this), 8);
            this.f24356i = k5;
            t.b(k5);
            k5.d(arrayList);
            b4().f22780V.setAdapter(this.f24356i);
            b4().f22780V.setNestedScrollingEnabled(false);
            b4().f22780V.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
            defaultItemAnimator.setSupportsChangeAnimations(false);
            b4().f22780V.setItemAnimator(defaultItemAnimator);
            b4().f22815p.setVisibility(0);
        }
    }

    private final void J6() {
        h7();
        f4().Q().setValue(4);
        b4().f22770L.f23100k.setOnClickListener(new C2487d1(this));
        TextView textView = b4().f22770L.f23100k;
        t.d(textView, "tvDownloadCancel");
        String string = getString(com.uptodown.R.string.option_button_cancel);
        t.d(string, "getString(...)");
        n6(textView, string);
        TextView textView2 = b4().f22770L.f23102m;
        t.d(textView2, "tvPause");
        String string2 = getString(com.uptodown.R.string.updates_button_resume);
        t.d(string2, "getString(...)");
        m6(textView2, string2);
        TextView textView3 = b4().f22766H.f22360q;
        t.d(textView3, "tvStatusDownload");
        String string3 = getString(com.uptodown.R.string.updates_button_resume);
        t.d(string3, "getString(...)");
        m6(textView3, string3);
    }

    /* access modifiers changed from: private */
    public static final void K2(h2.F f5, View view) {
        if (f5.f22347d.getVisibility() == 0) {
            DownloadWorker.f21359d.o();
        }
    }

    /* access modifiers changed from: private */
    public static final void K3(C2540v1 v1Var, C2398B b5, View view) {
        if (UptodownApp.f13477F.Z()) {
            w c02 = v1Var.f4().c0();
            Editable text = b5.f22264c.getText();
            t.d(text, "getText(...)");
            c02.setValue(t3.s.W0(text).toString());
            b5.f22264c.setText((CharSequence) v1Var.f4().c0().getValue());
            FragmentActivity activity = v1Var.getActivity();
            t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            AlertDialog p22 = ((C1598a) activity).p2();
            if (p22 != null) {
                p22.dismiss();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void K4(C2540v1 v1Var, View view) {
        v1Var.X3();
    }

    private final View K5(LinearLayout.LayoutParams layoutParams, l2.O o5, Context context) {
        String str;
        M0 c5 = M0.c(getLayoutInflater());
        t.d(c5, "inflate(...)");
        c5.getRoot().setLayoutParams(layoutParams);
        c5.f22502f.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
        c5.f22503g.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
        c5.f22504h.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
        c5.f22505i.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
        c5.f22506j.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
        if (o5.i() >= 2) {
            c5.f22503g.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
        }
        if (o5.i() >= 3) {
            c5.f22504h.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
        }
        if (o5.i() >= 4) {
            c5.f22505i.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
        }
        if (o5.i() == 5) {
            c5.f22506j.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
        }
        UsernameTextView usernameTextView = c5.f22518v;
        k.a aVar = S1.k.f32g;
        usernameTextView.setTypeface(aVar.w());
        c5.f22513q.setTypeface(aVar.x());
        c5.f22512p.setTypeface(aVar.x());
        c5.f22515s.setTypeface(aVar.x());
        c5.f22516t.setTypeface(aVar.x());
        V.b bVar = l2.V.f24870q;
        String d5 = bVar.d(o5.e());
        if (!(d5 == null || d5.length() == 0)) {
            com.squareup.picasso.s.h().l(bVar.d(o5.e())).n(UptodownApp.f13477F.g0(context)).i(c5.f22499c);
        }
        String m5 = o5.m();
        if (!(m5 == null || m5.length() == 0)) {
            c5.f22499c.setOnClickListener(new E0(this, o5));
            c5.f22518v.setOnClickListener(new F0(this, o5));
        }
        String n5 = o5.n();
        if (!(n5 == null || n5.length() == 0)) {
            c5.f22518v.setText(o5.n());
            UsernameTextView.a aVar2 = UsernameTextView.f21329k;
            UsernameTextView usernameTextView2 = c5.f22518v;
            t.d(usernameTextView2, "tvUsernameReview");
            aVar2.a(usernameTextView2, o5.p(), o5.o());
        }
        String l5 = o5.l();
        if (!(l5 == null || l5.length() == 0)) {
            c5.f22513q.setText(o5.l());
        }
        if (o5.a() > 0) {
            c5.f22516t.setText(String.valueOf(o5.a()));
        }
        Context requireContext = requireContext();
        t.d(requireContext, "requireContext(...)");
        l2.V h5 = bVar.h(requireContext);
        CharSequence charSequence = null;
        if (h5 != null) {
            str = h5.j();
        } else {
            str = null;
        }
        if (!t.a(str, o5.m())) {
            if (o5.f() == 1) {
                c5.f22500d.setImageDrawable(ContextCompat.getDrawable(requireContext(), com.uptodown.R.drawable.vector_following));
            } else {
                c5.f22500d.setImageDrawable(ContextCompat.getDrawable(requireContext(), com.uptodown.R.drawable.vector_follow));
            }
            c5.f22500d.setOnClickListener(new G0(this, o5));
        } else {
            c5.f22500d.setVisibility(8);
        }
        String j5 = o5.j();
        if (j5 == null || j5.length() == 0) {
            c5.f22512p.setVisibility(8);
            c5.f22509m.setVisibility(8);
            c5.f22508l.setVisibility(8);
        } else {
            c5.f22515s.setFocusable(true);
            TextView textView = c5.f22512p;
            Spanned k5 = o5.k();
            if (k5 != null) {
                charSequence = t3.s.W0(k5);
            }
            textView.setText(charSequence);
            c5.f22512p.getViewTreeObserver().addOnPreDrawListener(new J(c5));
            c5.f22517u.setOnClickListener(new H0(c5, this));
            c5.f22509m.setOnClickListener(new I0(this, o5));
            c5.f22509m.setFocusable(true);
            c5.f22514r.setTypeface(aVar.x());
            c5.f22514r.setText(String.valueOf(o5.h()));
            if (l2.O.f24814p.d(o5.g())) {
                c5.f22501e.setImageDrawable(ContextCompat.getDrawable(requireContext(), com.uptodown.R.drawable.vector_heart_red));
            }
            c5.f22508l.setOnClickListener(new J0(this, c5, o5));
        }
        c5.f22515s.setFocusable(true);
        RelativeLayout b5 = c5.getRoot();
        t.d(b5, "getRoot(...)");
        return b5;
    }

    /* access modifiers changed from: private */
    public static final void K6(C2540v1 v1Var, View view) {
        v1Var.e3();
    }

    /* access modifiers changed from: private */
    public static final void L2(C2540v1 v1Var, View view) {
        v1Var.f5();
    }

    /* access modifiers changed from: private */
    public static final void L3(C2540v1 v1Var, Context context, DialogInterface dialogInterface) {
        v1Var.r7(((Number) v1Var.f4().a0().getValue()).intValue(), context);
    }

    /* access modifiers changed from: private */
    public static final void L4(C2540v1 v1Var, View view) {
        v1Var.Y3();
    }

    /* access modifiers changed from: private */
    public static final void L5(C2540v1 v1Var, l2.O o5, View view) {
        v1Var.y5(o5);
    }

    /* access modifiers changed from: private */
    public final void L6(int i5) {
        i4();
        b4().f22773O.f22892v.setText(getString(com.uptodown.R.string.unzipping_status, Integer.valueOf(i5)));
        b4().f22766H.f22358o.setText(getString(com.uptodown.R.string.unzipping_status, Integer.valueOf(i5)));
    }

    /* access modifiers changed from: private */
    public final void M2(Context context) {
        DownloadWorker.a aVar = DownloadWorker.f21359d;
        if (aVar.j(a4().e())) {
            String S4 = a4().S();
            t.b(S4);
            aVar.c(S4);
            z2.M.f26506a.e(context);
        } else {
            String S5 = a4().S();
            t.b(S5);
            if (aVar.l(S5)) {
                String S6 = a4().S();
                t.b(S6);
                aVar.c(S6);
            } else {
                C2940B a5 = C2940B.f26458v.a(context);
                a5.a();
                C2668q h02 = a5.h0(String.valueOf(a4().A()));
                if (h02 != null) {
                    if (h02.P()) {
                        a5.A(h02);
                    } else {
                        Iterator it = h02.o().iterator();
                        t.d(it, "iterator(...)");
                        while (it.hasNext()) {
                            Object next = it.next();
                            t.d(next, "next(...)");
                            r rVar = (r) next;
                            rVar.p(0);
                            rVar.l(0);
                            a5.E1(rVar);
                        }
                    }
                }
                a5.m();
            }
        }
        f7(context);
    }

    private final void M3() {
        FragmentActivity activity = getActivity();
        t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        AlertDialog p22 = ((C1598a) activity).p2();
        if (p22 != null) {
            p22.dismiss();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        h2.E c5 = h2.E.c(getLayoutInflater());
        t.d(c5, "inflate(...)");
        if (getActivity() != null && !requireActivity().isFinishing()) {
            TextView textView = c5.f22333g;
            k.a aVar = S1.k.f32g;
            textView.setTypeface(aVar.w());
            c5.f22334h.setTypeface(aVar.w());
            c5.f22332f.setTypeface(aVar.w());
            if (((Number) f4().p0().getValue()).intValue() == 1) {
                c5.f22331e.setBackground(ContextCompat.getDrawable(requireContext(), com.uptodown.R.drawable.ripple_blue_primary_button));
                c5.f22334h.setTextColor(ContextCompat.getColor(requireContext(), com.uptodown.R.color.white));
                c5.f22329c.setVisibility(0);
            }
            if (((Number) f4().Y().getValue()).intValue() == 1) {
                c5.f22330d.setBackground(ContextCompat.getDrawable(requireContext(), com.uptodown.R.drawable.ripple_blue_primary_button));
                c5.f22332f.setTextColor(ContextCompat.getColor(requireContext(), com.uptodown.R.color.white));
                c5.f22328b.setVisibility(0);
            }
            c5.f22330d.setOnClickListener(new C2490e1(this));
            c5.f22331e.setOnClickListener(new C2493f1(this));
            builder.setView(c5.getRoot());
            builder.setCancelable(true);
            X6(builder);
        }
    }

    /* access modifiers changed from: private */
    public static final void M4(C2540v1 v1Var, View view) {
        v1Var.w5();
    }

    /* access modifiers changed from: private */
    public static final void M5(C2540v1 v1Var, l2.O o5, View view) {
        v1Var.y5(o5);
    }

    /* access modifiers changed from: private */
    public final void M6(l2.T t5) {
        C2668q qVar;
        i7();
        c cVar = c.f17333a;
        ProgressBar progressBar = b4().f22773O.f22879i;
        t.d(progressBar, "pbProgressAppDetail");
        ImageView imageView = b4().f22773O.f22872b;
        t.d(imageView, "ivLogoAppDetail");
        cVar.e(progressBar, imageView);
        f4().Q().setValue(5);
        if (t5 != null) {
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            qVar = t5.b(requireContext);
        } else {
            qVar = null;
        }
        if (qVar != null) {
            b4().f22773O.f22876f.setVisibility(8);
            b4().f22773O.f22874d.setVisibility(0);
            b4().f22770L.f23101l.setVisibility(8);
            TextView textView = b4().f22770L.f23100k;
            t.d(textView, "tvDownloadCancel");
            String string = getString(com.uptodown.R.string.option_button_cancel);
            t.d(string, "getString(...)");
            n6(textView, string);
            b4().f22770L.f23100k.setOnClickListener(new C2473J(this));
            if (DownloadWorker.f21359d.h()) {
                TextView textView2 = b4().f22770L.f23102m;
                t.d(textView2, "tvPause");
                String string2 = getString(com.uptodown.R.string.updates_button_resume);
                t.d(string2, "getString(...)");
                m6(textView2, string2);
            } else {
                TextView textView3 = b4().f22770L.f23102m;
                t.d(textView3, "tvPause");
                String string3 = getString(com.uptodown.R.string.action_pause);
                t.d(string3, "getString(...)");
                n6(textView3, string3);
            }
            if (qVar.x() > 0) {
                b4().f22773O.f22879i.setIndeterminate(false);
                b4().f22773O.f22879i.setProgress(qVar.x());
                b4().f22766H.f22349f.setIndeterminate(false);
            } else {
                b4().f22773O.f22879i.setIndeterminate(true);
                b4().f22766H.f22349f.setIndeterminate(true);
            }
            TextView textView4 = b4().f22773O.f22892v;
            Integer valueOf = Integer.valueOf(qVar.x());
            C2291k kVar = new C2291k();
            long z4 = qVar.z();
            Context requireContext2 = requireContext();
            t.d(requireContext2, "requireContext(...)");
            textView4.setText(getString(com.uptodown.R.string.percent_of_total_size, valueOf, kVar.d(z4, requireContext2)));
            b4().f22766H.f22345b.setVisibility(0);
            TextView textView5 = b4().f22766H.f22358o;
            C2291k kVar2 = new C2291k();
            long z5 = (qVar.z() * ((long) qVar.x())) / ((long) 100);
            Context requireContext3 = requireContext();
            t.d(requireContext3, "requireContext(...)");
            textView5.setText(kVar2.d(z5, requireContext3));
            b4().f22766H.f22349f.setProgress(qVar.x());
            b4().f22766H.f22355l.setVisibility(8);
            b4().f22766H.f22357n.setVisibility(0);
            TextView textView6 = b4().f22766H.f22357n;
            textView6.setText(qVar.x() + getString(com.uptodown.R.string.percent));
            TextView textView7 = b4().f22766H.f22359p;
            kotlin.jvm.internal.Q q5 = kotlin.jvm.internal.Q.f24695a;
            C2291k kVar3 = new C2291k();
            long z6 = qVar.z();
            Context requireContext4 = requireContext();
            t.d(requireContext4, "requireContext(...)");
            String format = String.format("/%s", Arrays.copyOf(new Object[]{kVar3.d(z6, requireContext4)}, 1));
            t.d(format, "format(...)");
            textView7.setText(format);
            return;
        }
        b4().f22773O.f22879i.setIndeterminate(true);
        b4().f22766H.f22349f.setIndeterminate(true);
    }

    /* access modifiers changed from: private */
    public final void N2(View view) {
        view.setOnClickListener(new C2475L(this, view));
    }

    /* access modifiers changed from: private */
    public static final void N3(C2540v1 v1Var, View view) {
        v1Var.y2();
        FragmentActivity activity = v1Var.getActivity();
        t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        ((C1598a) activity).o2();
    }

    /* access modifiers changed from: private */
    public static final void N4(C2540v1 v1Var, Context context, View view) {
        v1Var.D3(context);
    }

    /* access modifiers changed from: private */
    public static final void N5(C2540v1 v1Var, l2.O o5, View view) {
        V.b bVar = l2.V.f24870q;
        Context requireContext = v1Var.requireContext();
        t.d(requireContext, "requireContext(...)");
        if (bVar.h(requireContext) != null) {
            B1 f42 = v1Var.f4();
            Context requireContext2 = v1Var.requireContext();
            t.d(requireContext2, "requireContext(...)");
            int f5 = o5.f();
            String m5 = o5.m();
            t.b(m5);
            f42.y(requireContext2, f5, m5);
            return;
        }
        v1Var.m5();
    }

    /* access modifiers changed from: private */
    public static final void N6(C2540v1 v1Var, View view) {
        v1Var.e3();
    }

    /* access modifiers changed from: private */
    public static final void O2(C2540v1 v1Var, View view, View view2) {
        if (UptodownApp.f13477F.Z()) {
            FragmentActivity activity = v1Var.getActivity();
            t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            AlertDialog p22 = ((C1598a) activity).p2();
            if (p22 != null) {
                p22.dismiss();
            }
            if (view.getContext() != null) {
                C2446x c5 = C2446x.c(v1Var.getLayoutInflater());
                t.d(c5, "inflate(...)");
                TextView textView = c5.f23667f;
                k.a aVar = S1.k.f32g;
                textView.setTypeface(aVar.w());
                c5.f23667f.setText(v1Var.getString(com.uptodown.R.string.cancel_registration));
                c5.f23665d.setTypeface(aVar.x());
                TextView textView2 = c5.f23665d;
                C2962v vVar = new C2962v();
                String string = v1Var.getString(com.uptodown.R.string.confirm_cancel_preregister, v1Var.a4().N());
                t.d(string, "getString(...)");
                String N4 = v1Var.a4().N();
                t.b(N4);
                Context context = view.getContext();
                t.d(context, "getContext(...)");
                textView2.setText(vVar.d(string, N4, context));
                c5.f23664c.setTypeface(aVar.w());
                c5.f23666e.setTypeface(aVar.w());
                c5.f23666e.setText(v1Var.getString(com.uptodown.R.string.dialog_confirmation_verify_afirmative));
                c5.f23664c.setVisibility(0);
                c5.f23664c.setOnClickListener(new R0(v1Var));
                c5.f23666e.setOnClickListener(new S0(v1Var));
                c5.f23663b.setOnClickListener(new T0(v1Var));
                AlertDialog.Builder builder = new AlertDialog.Builder(v1Var.requireContext());
                builder.setView(c5.getRoot());
                builder.setCancelable(true);
                v1Var.X6(builder);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void O3(C2540v1 v1Var, View view) {
        v1Var.z2();
        FragmentActivity activity = v1Var.getActivity();
        t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        ((C1598a) activity).o2();
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0139  */
    /* JADX WARNING: Removed duplicated region for block: B:91:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void O4(l2.C2668q r11, android.content.Context r12) {
        /*
            r10 = this;
            java.io.File r0 = r11.n()
            if (r0 == 0) goto L_0x01fb
            boolean r1 = r0.exists()
            if (r1 == 0) goto L_0x01fb
            long r1 = r11.C()
            r3 = 0
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            r2 = 0
            r3 = 1
            r4 = 0
            if (r1 < 0) goto L_0x003c
            z2.B$a r1 = z2.C2940B.f26458v
            z2.B r1 = r1.a(r12)
            r1.a()
            java.lang.String r5 = r11.w()
            kotlin.jvm.internal.t.b(r5)
            l2.T r5 = r1.G0(r5)
            r1.m()
            if (r5 == 0) goto L_0x003a
            int r1 = r5.n()
            if (r1 != r3) goto L_0x003a
            r1 = r3
            goto L_0x003e
        L_0x003a:
            r1 = r4
            goto L_0x003e
        L_0x003c:
            r5 = r2
            goto L_0x003a
        L_0x003e:
            if (r1 == 0) goto L_0x0047
            kotlin.jvm.internal.t.b(r5)
            r10.P4(r5, r0)
            return
        L_0x0047:
            boolean r1 = r0.isDirectory()
            java.lang.String r5 = "null cannot be cast to non-null type com.uptodown.activities.BaseActivity"
            if (r1 == 0) goto L_0x00d7
            U1.a r12 = new U1.a
            android.content.Context r1 = r10.requireContext()
            java.lang.String r2 = "requireContext(...)"
            kotlin.jvm.internal.t.d(r1, r2)
            r12.<init>(r1)
            boolean r12 = r12.s()
            if (r12 == 0) goto L_0x0067
            r10.U4(r0)
            return
        L_0x0067:
            androidx.fragment.app.FragmentActivity r12 = r10.getActivity()
            if (r12 == 0) goto L_0x01fb
            androidx.fragment.app.FragmentActivity r12 = r10.getActivity()
            kotlin.jvm.internal.t.b(r12)
            boolean r12 = r12.isFinishing()
            if (r12 != 0) goto L_0x01fb
            i2.v1$q r12 = new i2.v1$q
            r12.<init>(r10)
            java.io.File[] r0 = r0.listFiles()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            if (r0 == 0) goto L_0x009e
            java.util.Iterator r0 = kotlin.jvm.internal.C2625c.a(r0)
        L_0x008e:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x009e
            java.lang.Object r2 = r0.next()
            java.io.File r2 = (java.io.File) r2
            r1.add(r2)
            goto L_0x008e
        L_0x009e:
            b2.G r0 = new b2.G
            androidx.fragment.app.FragmentActivity r2 = r10.getActivity()
            kotlin.jvm.internal.t.b(r2)
            r0.<init>(r2)
            r0.B(r1)
            java.util.ArrayList r0 = r0.C()
            b2.l r1 = new b2.l
            androidx.fragment.app.FragmentActivity r2 = r10.requireActivity()
            java.lang.String r3 = "requireActivity(...)"
            kotlin.jvm.internal.t.d(r2, r3)
            r1.<init>(r2, r12)
            r1.A(r0, r4)
            androidx.fragment.app.FragmentActivity r12 = r10.getActivity()
            boolean r12 = r12 instanceof com.uptodown.activities.C1598a
            if (r12 == 0) goto L_0x01fb
            androidx.fragment.app.FragmentActivity r12 = r10.getActivity()
            kotlin.jvm.internal.t.c(r12, r5)
            com.uptodown.activities.a r12 = (com.uptodown.activities.C1598a) r12
            r12.E2(r11)
            return
        L_0x00d7:
            java.lang.String r11 = r0.getName()
            java.lang.String r1 = "getName(...)"
            kotlin.jvm.internal.t.d(r11, r1)
            java.lang.String r6 = ".apk"
            r7 = 2
            boolean r11 = t3.s.D(r11, r6, r4, r7, r2)
            if (r11 == 0) goto L_0x018b
            r6 = -1
            android.content.pm.PackageManager r11 = r12.getPackageManager()     // Catch:{ Exception -> 0x012f }
            java.lang.String r1 = "getPackageManager(...)"
            kotlin.jvm.internal.t.d(r11, r1)     // Catch:{ Exception -> 0x012f }
            java.lang.String r1 = r0.getAbsolutePath()     // Catch:{ Exception -> 0x012f }
            java.lang.String r8 = "getAbsolutePath(...)"
            kotlin.jvm.internal.t.d(r1, r8)     // Catch:{ Exception -> 0x012f }
            android.content.pm.PackageInfo r11 = b2.C2301u.c(r11, r1, r3)     // Catch:{ Exception -> 0x012f }
            if (r11 == 0) goto L_0x0132
            java.lang.String r1 = r11.versionName     // Catch:{ Exception -> 0x012f }
            if (r1 == 0) goto L_0x0108
            r4 = r3
        L_0x0108:
            b2.j r1 = new b2.j     // Catch:{ Exception -> 0x012f }
            r1.<init>()     // Catch:{ Exception -> 0x012f }
            long r6 = r1.m(r11)     // Catch:{ Exception -> 0x012f }
            z2.B$a r11 = z2.C2940B.f26458v     // Catch:{ Exception -> 0x012f }
            z2.B r11 = r11.a(r12)     // Catch:{ Exception -> 0x012f }
            r11.a()     // Catch:{ Exception -> 0x012f }
            l2.f r1 = r10.a4()     // Catch:{ Exception -> 0x012f }
            java.lang.String r1 = r1.S()     // Catch:{ Exception -> 0x012f }
            kotlin.jvm.internal.t.b(r1)     // Catch:{ Exception -> 0x012f }
            l2.d r1 = r11.Y(r1)     // Catch:{ Exception -> 0x012f }
            r11.m()     // Catch:{ Exception -> 0x012d }
            goto L_0x0137
        L_0x012d:
            r11 = move-exception
            goto L_0x0134
        L_0x012f:
            r11 = move-exception
            r1 = r2
            goto L_0x0134
        L_0x0132:
            r1 = r2
            goto L_0x0137
        L_0x0134:
            r11.printStackTrace()
        L_0x0137:
            if (r4 == 0) goto L_0x01fb
            if (r1 == 0) goto L_0x0154
            long r8 = r1.A()
            int r11 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r11 <= 0) goto L_0x0154
            r11 = 2131952349(0x7f1302dd, float:1.9541138E38)
            java.lang.String r11 = r10.getString(r11)
            java.lang.String r12 = "getString(...)"
            kotlin.jvm.internal.t.d(r11, r12)
            r10.o3(r11)
            goto L_0x01fb
        L_0x0154:
            androidx.fragment.app.FragmentActivity r11 = r10.getActivity()
            if (r11 == 0) goto L_0x01fb
            i2.B1 r11 = r10.f4()
            z3.w r11 = r11.j0()
            java.lang.Object r11 = r11.getValue()
            l2.T r11 = (l2.T) r11
            if (r11 == 0) goto L_0x016e
            java.lang.String r2 = r11.h()
        L_0x016e:
            java.lang.String r11 = r12.getPackageName()
            boolean r11 = t3.s.E(r2, r11, r3)
            if (r11 == 0) goto L_0x0186
            androidx.fragment.app.FragmentActivity r11 = r10.getActivity()
            kotlin.jvm.internal.t.c(r11, r5)
            com.uptodown.activities.a r11 = (com.uptodown.activities.C1598a) r11
            r11.Y1(r0)
            goto L_0x01fb
        L_0x0186:
            r10.V4(r0)
            goto L_0x01fb
        L_0x018b:
            b2.K$a r11 = b2.C2279K.f20490b
            java.lang.String r12 = r0.getName()
            kotlin.jvm.internal.t.d(r12, r1)
            boolean r11 = r11.a(r12)
            if (r11 == 0) goto L_0x01fb
            b2.K r11 = new b2.K
            r11.<init>()
            boolean r12 = r11.f(r0)
            boolean r11 = r11.c(r0)
            if (r11 == 0) goto L_0x01ef
            b2.j r11 = new b2.j
            r11.<init>()
            java.io.File r11 = r11.e()
            boolean r11 = r11.canWrite()
            if (r11 != 0) goto L_0x01ef
            androidx.fragment.app.FragmentActivity r11 = r10.getActivity()
            if (r11 == 0) goto L_0x01f0
            androidx.fragment.app.FragmentActivity r11 = r10.getActivity()
            kotlin.jvm.internal.t.c(r11, r5)
            com.uptodown.activities.a r11 = (com.uptodown.activities.C1598a) r11
            boolean r11 = r11.X()
            if (r11 == 0) goto L_0x01e2
            androidx.fragment.app.FragmentActivity r11 = r10.getActivity()
            kotlin.jvm.internal.t.c(r11, r5)
            com.uptodown.activities.a r11 = (com.uptodown.activities.C1598a) r11
            l2.f r12 = r10.a4()
            long r1 = r12.e()
            r11.c3(r1)
            goto L_0x01f0
        L_0x01e2:
            androidx.fragment.app.FragmentActivity r11 = r10.getActivity()
            kotlin.jvm.internal.t.c(r11, r5)
            com.uptodown.activities.a r11 = (com.uptodown.activities.C1598a) r11
            r11.o0()
            goto L_0x01f0
        L_0x01ef:
            r4 = r12
        L_0x01f0:
            if (r4 == 0) goto L_0x01fb
            androidx.fragment.app.FragmentActivity r11 = r10.getActivity()
            if (r11 == 0) goto L_0x01fb
            r10.V4(r0)
        L_0x01fb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.C2540v1.O4(l2.q, android.content.Context):void");
    }

    /* access modifiers changed from: private */
    public static final void O5(M0 m02, C2540v1 v1Var, View view) {
        if (m02.f22512p.getMaxLines() == Integer.MAX_VALUE) {
            m02.f22512p.setMaxLines(4);
            m02.f22517u.setText(v1Var.getString(com.uptodown.R.string.read_more_desc_app_detail));
            return;
        }
        m02.f22512p.setMaxLines(Integer.MAX_VALUE);
        m02.f22517u.setText(v1Var.getString(com.uptodown.R.string.read_less_desc_app_detail));
    }

    /* access modifiers changed from: private */
    public final void O6(Context context) {
        h7();
        c cVar = c.f17333a;
        ProgressBar progressBar = b4().f22773O.f22879i;
        t.d(progressBar, "pbProgressAppDetail");
        ImageView imageView = b4().f22773O.f22872b;
        t.d(imageView, "ivLogoAppDetail");
        cVar.c(progressBar, imageView);
        f4().Q().setValue(2);
        TextView textView = b4().f22770L.f23100k;
        t.d(textView, "tvDownloadCancel");
        String string = getString(com.uptodown.R.string.updates_button_update_app);
        t.d(string, "getString(...)");
        m6(textView, string);
        b4().f22770L.f23100k.setOnClickListener(new C2506k(this, context));
        b4().f22766H.f22360q.setText(getString(com.uptodown.R.string.updates_button_update_app));
        TextView textView2 = b4().f22766H.f22360q;
        t.d(textView2, "tvStatusDownload");
        String string2 = getString(com.uptodown.R.string.updates_button_update_app);
        t.d(string2, "getString(...)");
        m6(textView2, string2);
        Z6(com.uptodown.R.id.action_app_installed_details);
    }

    /* access modifiers changed from: private */
    public static final void P2(C2540v1 v1Var, View view) {
        FragmentActivity activity = v1Var.getActivity();
        t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        AlertDialog p22 = ((C1598a) activity).p2();
        if (p22 != null) {
            p22.dismiss();
        }
    }

    private final void P3(Context context) {
        String v5;
        C2668q qVar;
        File file;
        C2668q qVar2;
        CharSequence charSequence;
        String S4 = a4().S();
        File file2 = null;
        if (S4 != null && S4.length() != 0 && !a.f15150a.R(context)) {
            C2940B a5 = C2940B.f26458v.a(context);
            a5.a();
            if (a4().A0() > 0) {
                String S5 = a4().S();
                t.b(S5);
                qVar2 = a5.k0(S5, a4().A0());
            } else {
                String S6 = a4().S();
                t.b(S6);
                qVar2 = a5.j0(S6);
            }
            a5.m();
            if (qVar2 != null && qVar2.f()) {
                file2 = qVar2.n();
            }
            if (file2 != null) {
                t.b(qVar2);
                O4(qVar2, context);
                return;
            }
            String p5 = a4().p();
            if (p5 == null || p5.length() == 0) {
                String string = getString(com.uptodown.R.string.download_error_message);
                t.d(string, "getString(...)");
                o3(string);
                return;
            }
            C2668q qVar3 = new C2668q();
            qVar3.c(a4());
            qVar3.a0(new ArrayList());
            int S7 = qVar3.S(context);
            if (!(!a4().N0() || (charSequence = (CharSequence) f4().L().getValue()) == null || charSequence.length() == 0)) {
                C2669s sVar = new C2669s();
                long e5 = a4().e();
                Object value = f4().L().getValue();
                t.b(value);
                sVar.a(e5, (String) value);
                Context requireContext = requireContext();
                t.d(requireContext, "requireContext(...)");
                sVar.f(requireContext);
            }
            x6(qVar3);
            DownloadApkWorker.a aVar = DownloadApkWorker.f21342i;
            String p6 = a4().p();
            t.b(p6);
            aVar.a(context, p6, S7);
        } else if (((Boolean) f4().M().getValue()).booleanValue() && a4().G0() && a4().J0()) {
            C2940B a6 = C2940B.f26458v.a(context);
            a6.a();
            if (a4().A0() > 0) {
                String S8 = a4().S();
                t.b(S8);
                qVar = a6.k0(S8, a4().A0());
            } else {
                String S9 = a4().S();
                t.b(S9);
                qVar = a6.j0(S9);
            }
            a6.m();
            if (qVar == null || !qVar.f()) {
                file = null;
            } else {
                file = qVar.n();
            }
            if (file == null || !file.exists()) {
                x6((C2668q) null);
                Y2();
                return;
            }
            t.b(qVar);
            O4(qVar, context);
        } else if (!a4().K0() || (v5 = a4().v()) == null || v5.length() == 0) {
            String string2 = getString(com.uptodown.R.string.download_error_message);
            t.d(string2, "getString(...)");
            o3(string2);
        } else {
            V.b bVar = l2.V.f24870q;
            FragmentActivity requireActivity = requireActivity();
            t.d(requireActivity, "requireActivity(...)");
            l2.V h5 = bVar.h(requireActivity);
            if (h5 == null || !h5.q()) {
                String v6 = a4().v();
                t.b(v6);
                k5(v6, context);
                return;
            }
            FragmentActivity activity = getActivity();
            t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            ((C1598a) activity).j2(a4(), new V(this, context), new C2495g0());
        }
    }

    private final void P4(l2.T t5, File file) {
        ApplicationInfo applicationInfo;
        if (!file.isDirectory()) {
            file = new File(file.getAbsolutePath()).getParentFile();
        }
        File file2 = file;
        C2558r rVar = new C2558r(this, file2, t5);
        try {
            PackageManager packageManager = requireContext().getPackageManager();
            t.d(packageManager, "getPackageManager(...)");
            applicationInfo = C2301u.a(packageManager, t5.h(), 128);
        } catch (PackageManager.NameNotFoundException e5) {
            e5.printStackTrace();
            applicationInfo = null;
        }
        if (applicationInfo != null) {
            File file3 = new File(applicationInfo.sourceDir);
            ArrayList arrayList = new ArrayList();
            arrayList.add(file3);
            t.b(file2);
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            new C2209b(arrayList, file2, rVar, false, requireContext);
            return;
        }
        String string = getString(com.uptodown.R.string.installable_files_not_found);
        t.d(string, "getString(...)");
        o3(string);
        W2.J j5 = W2.J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final void P5(C2540v1 v1Var, l2.O o5, View view) {
        UptodownApp.a aVar = UptodownApp.f13477F;
        if (aVar.Z()) {
            Intent intent = new Intent(v1Var.requireActivity(), RepliesActivity.class);
            intent.putExtra("review", o5);
            intent.putExtra("appName", v1Var.a4().N());
            intent.putExtra("appIconUrl", v1Var.a4().E());
            FragmentActivity requireActivity = v1Var.requireActivity();
            t.d(requireActivity, "requireActivity(...)");
            v1Var.startActivity(intent, aVar.a(requireActivity));
        }
    }

    /* access modifiers changed from: private */
    public static final void P6(C2540v1 v1Var, Context context, View view) {
        v1Var.P3(context);
    }

    /* access modifiers changed from: private */
    public static final void Q2(C2540v1 v1Var, View view) {
        B1 f42 = v1Var.f4();
        Context requireContext = v1Var.requireContext();
        t.d(requireContext, "requireContext(...)");
        f42.u(requireContext, v1Var.a4().e());
        FragmentActivity activity = v1Var.getActivity();
        t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        AlertDialog p22 = ((C1598a) activity).p2();
        if (p22 != null) {
            p22.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final W2.J Q3(C2540v1 v1Var, Context context) {
        String v5 = v1Var.a4().v();
        t.b(v5);
        v1Var.k5(v5, context);
        return W2.J.f19942a;
    }

    private final boolean Q4() {
        return UptodownApp.f13477F.L(a4().S());
    }

    /* access modifiers changed from: private */
    public static final void Q5(C2540v1 v1Var, M0 m02, l2.O o5, View view) {
        if (UptodownApp.f13477F.Z()) {
            Context requireContext = v1Var.requireContext();
            t.d(requireContext, "requireContext(...)");
            n nVar = new n(requireContext);
            ImageView imageView = m02.f22501e;
            t.d(imageView, "ivLikesCounterReview");
            nVar.n(imageView);
            if (!l2.O.f24814p.d(o5.g())) {
                v1Var.W4(o5);
                m02.f22514r.setText(String.valueOf(o5.h() + 1));
            }
        }
    }

    /* access modifiers changed from: private */
    public final void Q6() {
        h7();
        f4().Q().setValue(4);
        TextView textView = b4().f22770L.f23100k;
        t.d(textView, "tvDownloadCancel");
        String string = getString(com.uptodown.R.string.option_button_cancel);
        t.d(string, "getString(...)");
        n6(textView, string);
        b4().f22770L.f23100k.setOnClickListener(new C2539v0(this));
        TextView textView2 = b4().f22770L.f23102m;
        t.d(textView2, "tvPause");
        String string2 = getString(com.uptodown.R.string.updates_button_resume);
        t.d(string2, "getString(...)");
        m6(textView2, string2);
        b4().f22766H.f22360q.setOnClickListener(new C2568w0(this));
        TextView textView3 = b4().f22766H.f22360q;
        t.d(textView3, "tvStatusDownload");
        String string3 = getString(com.uptodown.R.string.updates_button_resume);
        t.d(string3, "getString(...)");
        m6(textView3, string3);
        Z6(com.uptodown.R.id.action_app_installed_details);
    }

    /* access modifiers changed from: private */
    public static final void R2(C2540v1 v1Var, View view) {
        FragmentActivity activity = v1Var.getActivity();
        t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        AlertDialog p22 = ((C1598a) activity).p2();
        if (p22 != null) {
            p22.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final W2.J R3() {
        return W2.J.f19942a;
    }

    /* access modifiers changed from: private */
    public final boolean R4(l2.T t5) {
        if (t5 != null) {
            return UptodownApp.f13477F.N(t5);
        }
        String S4 = a4().S();
        if (S4 == null || S4.length() == 0) {
            return false;
        }
        DownloadWorker.a aVar = DownloadWorker.f21359d;
        String S5 = a4().S();
        t.b(S5);
        return aVar.l(S5);
    }

    private final View R5(LinearLayout.LayoutParams layoutParams) {
        M0 c5 = M0.c(getLayoutInflater());
        t.d(c5, "inflate(...)");
        c5.getRoot().setLayoutParams(layoutParams);
        c5.getRoot().setVisibility(4);
        RelativeLayout b5 = c5.getRoot();
        t.d(b5, "getRoot(...)");
        return b5;
    }

    /* access modifiers changed from: private */
    public static final void R6(C2540v1 v1Var, View view) {
        v1Var.e3();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0066, code lost:
        if (w3.C2872g.g(r7, r4, r0) != r1) goto L_0x0069;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object S2(b3.C2308e r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof i2.C2540v1.C2545e
            if (r0 == 0) goto L_0x0013
            r0 = r7
            i2.v1$e r0 = (i2.C2540v1.C2545e) r0
            int r1 = r0.f24437d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f24437d = r1
            goto L_0x0018
        L_0x0013:
            i2.v1$e r0 = new i2.v1$e
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f24435b
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f24437d
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x003d
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            W2.u.b(r7)
            goto L_0x0069
        L_0x002d:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r0)
            throw r7
        L_0x0035:
            java.lang.Object r2 = r0.f24434a
            i2.v1 r2 = (i2.C2540v1) r2
            W2.u.b(r7)
            goto L_0x0055
        L_0x003d:
            W2.u.b(r7)
            w3.I r7 = w3.C2865c0.b()
            i2.v1$f r2 = new i2.v1$f
            r2.<init>(r6, r5)
            r0.f24434a = r6
            r0.f24437d = r4
            java.lang.Object r7 = w3.C2872g.g(r7, r2, r0)
            if (r7 != r1) goto L_0x0054
            goto L_0x0068
        L_0x0054:
            r2 = r6
        L_0x0055:
            w3.I0 r7 = w3.C2865c0.c()
            i2.v1$g r4 = new i2.v1$g
            r4.<init>(r2, r5)
            r0.f24434a = r5
            r0.f24437d = r3
            java.lang.Object r7 = w3.C2872g.g(r7, r4, r0)
            if (r7 != r1) goto L_0x0069
        L_0x0068:
            return r1
        L_0x0069:
            W2.J r7 = W2.J.f19942a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.C2540v1.S2(b3.e):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public final void S3() {
        CharSequence charSequence;
        if (getContext() == null) {
            return;
        }
        if (f4().R().getValue() != null && f4().j0().getValue() != null) {
            UptodownApp.a aVar = UptodownApp.f13477F;
            Object value = f4().R().getValue();
            t.b(value);
            ArrayList c5 = aVar.c((C2655d) value);
            if (c5 != null && c5.size() <= 1 && aVar.D().size() <= 1) {
                GenerateQueueWorker.a aVar2 = GenerateQueueWorker.f21366e;
                Context requireContext = requireContext();
                t.d(requireContext, "requireContext(...)");
                Object value2 = f4().j0().getValue();
                t.b(value2);
                aVar2.a(requireContext, false, ((l2.T) value2).h());
            }
            if (DownloadWorker.f21359d.h()) {
                A3(new C2535u());
            }
        } else if (getActivity() != null && (getActivity() instanceof C1598a)) {
            UptodownApp.a aVar3 = UptodownApp.f13477F;
            C2657f a42 = a4();
            FragmentActivity activity = getActivity();
            t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            int a02 = aVar3.a0(a42, (C1598a) activity);
            if (a02 >= 0) {
                if (!(!a4().N0() || (charSequence = (CharSequence) f4().L().getValue()) == null || charSequence.length() == 0)) {
                    C2669s sVar = new C2669s();
                    long e5 = a4().e();
                    Object value3 = f4().L().getValue();
                    t.b(value3);
                    sVar.a(e5, (String) value3);
                    Context requireContext2 = requireContext();
                    t.d(requireContext2, "requireContext(...)");
                    sVar.f(requireContext2);
                }
                Y6();
                if (Q4()) {
                    C2661j m5 = aVar3.m();
                    t.b(m5);
                    m5.g(a02);
                    C2940B.a aVar4 = C2940B.f26458v;
                    Context requireContext3 = requireContext();
                    t.d(requireContext3, "requireContext(...)");
                    C2940B a5 = aVar4.a(requireContext3);
                    C2668q i02 = a5.i0(a02);
                    if (i02 != null) {
                        i02.Y(1);
                        a5.D1(i02);
                    }
                    a5.m();
                }
                String S4 = a4().S();
                t.b(S4);
                W2(a02, S4, a4().e());
                DownloadApkWorker.a aVar5 = DownloadApkWorker.f21342i;
                Context requireContext4 = requireContext();
                t.d(requireContext4, "requireContext(...)");
                if (!aVar5.b(requireContext4, a02)) {
                    TextView textView = b4().f22770L.f23100k;
                    t.d(textView, "tvDownloadCancel");
                    String string = getString(com.uptodown.R.string.option_button_cancel);
                    t.d(string, "getString(...)");
                    n6(textView, string);
                    b4().f22770L.f23100k.setOnClickListener(new C2567w(this));
                    b4().f22766H.f22345b.setVisibility(0);
                    a.C0147a aVar6 = a.f15150a;
                    Context requireContext5 = requireContext();
                    t.d(requireContext5, "requireContext(...)");
                    if (!aVar6.U(requireContext5)) {
                        FragmentActivity activity2 = getActivity();
                        t.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                        kotlin.jvm.internal.Q q5 = kotlin.jvm.internal.Q.f24695a;
                        String string2 = getString(com.uptodown.R.string.msg_added_to_downlads_queue);
                        t.d(string2, "getString(...)");
                        String format = String.format(string2, Arrays.copyOf(new Object[]{a4().N()}, 1));
                        t.d(format, "format(...)");
                        ((C1598a) activity2).u0(format);
                    }
                }
                if (DownloadWorker.f21359d.h()) {
                    A3(new C2570x());
                    return;
                }
                return;
            }
            Context requireContext6 = requireContext();
            t.d(requireContext6, "requireContext(...)");
            v6(requireContext6);
        }
    }

    static /* synthetic */ boolean S4(C2540v1 v1Var, l2.T t5, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            t5 = null;
        }
        return v1Var.R4(t5);
    }

    private final View S5(LinearLayout.LayoutParams layoutParams, l2.O o5, Context context) {
        String str;
        O0 c5 = O0.c(getLayoutInflater());
        t.d(c5, "inflate(...)");
        c5.getRoot().setLayoutParams(layoutParams);
        c5.f22557f.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on_turbo));
        c5.f22558g.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off_turbo));
        c5.f22559h.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off_turbo));
        c5.f22560i.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off_turbo));
        c5.f22561j.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off_turbo));
        if (o5.i() >= 2) {
            c5.f22558g.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on_turbo));
        }
        if (o5.i() >= 3) {
            c5.f22559h.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on_turbo));
        }
        if (o5.i() >= 4) {
            c5.f22560i.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on_turbo));
        }
        if (o5.i() == 5) {
            c5.f22561j.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on_turbo));
        }
        UsernameTextView usernameTextView = c5.f22574w;
        k.a aVar = S1.k.f32g;
        usernameTextView.setTypeface(aVar.w());
        c5.f22569r.setTypeface(aVar.x());
        c5.f22568q.setTypeface(aVar.x());
        c5.f22571t.setTypeface(aVar.x());
        c5.f22572u.setTypeface(aVar.x());
        V.b bVar = l2.V.f24870q;
        if (bVar.d(o5.e()) != null) {
            com.squareup.picasso.s.h().l(bVar.d(o5.e())).n(UptodownApp.f13477F.g0(context)).i(c5.f22554c);
        }
        String m5 = o5.m();
        if (!(m5 == null || m5.length() == 0)) {
            c5.f22554c.setOnClickListener(new C2467D(this, o5));
            c5.f22574w.setOnClickListener(new C2468E(this, o5));
        }
        if (o5.n() != null) {
            c5.f22574w.setText(o5.n());
            UsernameTextView.a aVar2 = UsernameTextView.f21329k;
            UsernameTextView usernameTextView2 = c5.f22574w;
            t.d(usernameTextView2, "tvUsernameReview");
            aVar2.a(usernameTextView2, o5.p(), o5.o());
        }
        if (o5.l() != null) {
            c5.f22569r.setText(o5.l());
        }
        if (o5.a() > 0) {
            c5.f22572u.setText(String.valueOf(o5.a()));
        }
        Context requireContext = requireContext();
        t.d(requireContext, "requireContext(...)");
        l2.V h5 = bVar.h(requireContext);
        CharSequence charSequence = null;
        if (h5 != null) {
            str = h5.j();
        } else {
            str = null;
        }
        if (!t.a(str, o5.m())) {
            if (o5.f() == 1) {
                c5.f22555d.setImageDrawable(ContextCompat.getDrawable(requireContext(), com.uptodown.R.drawable.vector_following));
            } else {
                c5.f22555d.setImageDrawable(ContextCompat.getDrawable(requireContext(), com.uptodown.R.drawable.vector_follow));
            }
            c5.f22555d.setOnClickListener(new C2469F(this, o5));
        } else {
            c5.f22555d.setVisibility(8);
        }
        if (o5.j() != null) {
            c5.f22571t.setFocusable(true);
            TextView textView = c5.f22568q;
            Spanned k5 = o5.k();
            if (k5 != null) {
                charSequence = t3.s.W0(k5);
            }
            textView.setText(charSequence);
            c5.f22568q.getViewTreeObserver().addOnPreDrawListener(new K(c5));
            c5.f22573v.setOnClickListener(new C2470G(c5, this));
            c5.f22564m.setOnClickListener(new C2471H(this, o5));
            c5.f22564m.setFocusable(true);
            c5.f22570s.setTypeface(aVar.x());
            c5.f22570s.setText(String.valueOf(o5.h()));
            if (l2.O.f24814p.d(o5.g())) {
                c5.f22556e.setImageDrawable(ContextCompat.getDrawable(requireContext(), com.uptodown.R.drawable.vector_heart_red));
            }
            c5.f22563l.setOnClickListener(new C2472I(this, c5, o5));
        } else {
            c5.f22568q.setVisibility(8);
            c5.f22564m.setVisibility(8);
            c5.f22563l.setVisibility(8);
        }
        c5.f22562k.setOnClickListener(new C2474K(this));
        c5.f22562k.setVisibility(0);
        C2962v.a aVar3 = C2962v.f26557a;
        ImageView imageView = c5.f22554c;
        t.d(imageView, "ivAvatarReview");
        aVar3.b(imageView);
        c5.f22571t.setFocusable(true);
        RelativeLayout b5 = c5.getRoot();
        t.d(b5, "getRoot(...)");
        return b5;
    }

    /* access modifiers changed from: private */
    public static final void S6(C2540v1 v1Var, View view) {
        v1Var.e3();
    }

    /* access modifiers changed from: private */
    public static final W2.J T3() {
        DownloadWorker.a aVar = DownloadWorker.f21359d;
        if (aVar.h()) {
            aVar.o();
        }
        return W2.J.f19942a;
    }

    private final void T4(File file) {
        boolean z4;
        C2559s sVar = new C2559s(this);
        if (getActivity() instanceof MainActivity) {
            FragmentActivity activity = getActivity();
            t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
            z4 = ((MainActivity) activity).X();
        } else if (getActivity() instanceof AppDetailActivity) {
            FragmentActivity activity2 = getActivity();
            t.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.AppDetailActivity");
            z4 = ((AppDetailActivity) activity2).X();
        } else {
            z4 = true;
        }
        C2279K.a aVar = C2279K.f20490b;
        String name = file.getName();
        t.d(name, "getName(...)");
        if (aVar.a(name)) {
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            String absolutePath = file.getAbsolutePath();
            t.d(absolutePath, "getAbsolutePath(...)");
            new C2210c(requireContext, absolutePath, sVar, z4);
            return;
        }
        UptodownApp.a aVar2 = UptodownApp.f13477F;
        FragmentActivity requireActivity = requireActivity();
        t.d(requireActivity, "requireActivity(...)");
        aVar2.U(file, requireActivity, a4().O());
        W2.J j5 = W2.J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final void T5(C2540v1 v1Var, l2.O o5, View view) {
        v1Var.y5(o5);
    }

    private final void T6() {
        if (getContext() != null) {
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            new g2.v(requireContext, a4(), (C2655d) null, (k2.I) null, LifecycleOwnerKt.getLifecycleScope(this));
        }
    }

    private final void U2() {
        new Handler(Looper.getMainLooper()).postDelayed(new M(this), 5000);
    }

    /* access modifiers changed from: private */
    public static final void U3(C2540v1 v1Var, View view) {
        v1Var.e3();
    }

    private final void U4(File file) {
        if (getActivity() != null && !requireActivity().isFinishing()) {
            FragmentActivity activity = getActivity();
            t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            C1598a.B2((C1598a) activity, file, (String) null, 2, (Object) null);
        }
    }

    /* access modifiers changed from: private */
    public static final void U5(C2540v1 v1Var, l2.O o5, View view) {
        v1Var.y5(o5);
    }

    /* access modifiers changed from: private */
    public final void U6(C2657f fVar) {
        if ((getActivity() instanceof MainActivity) || (getActivity() instanceof AppDetailActivity)) {
            FragmentActivity activity = getActivity();
            t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            ((C1598a) activity).a3(fVar, new C2532t(fVar, this));
        }
    }

    /* access modifiers changed from: private */
    public static final void V2(C2540v1 v1Var) {
        if (v1Var.getContext() != null) {
            a.C0147a aVar = a.f15150a;
            Context requireContext = v1Var.requireContext();
            t.d(requireContext, "requireContext(...)");
            if (!aVar.R(requireContext)) {
                v1Var.o6();
            } else if (v1Var.b4().f22793e.getChildCount() > 0) {
                v1Var.b4().f22793e.removeAllViews();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final W2.J V3() {
        DownloadWorker.a aVar = DownloadWorker.f21359d;
        if (aVar.h()) {
            aVar.o();
        }
        return W2.J.f19942a;
    }

    private final void V4(File file) {
        Context requireContext = requireContext();
        t.d(requireContext, "requireContext(...)");
        if (new C2201a(requireContext).s()) {
            U4(file);
        } else {
            T4(file);
        }
    }

    /* access modifiers changed from: private */
    public static final void V5(C2540v1 v1Var, l2.O o5, View view) {
        V.b bVar = l2.V.f24870q;
        Context requireContext = v1Var.requireContext();
        t.d(requireContext, "requireContext(...)");
        if (bVar.h(requireContext) != null) {
            B1 f42 = v1Var.f4();
            Context requireContext2 = v1Var.requireContext();
            t.d(requireContext2, "requireContext(...)");
            int f5 = o5.f();
            String m5 = o5.m();
            t.b(m5);
            f42.y(requireContext2, f5, m5);
            return;
        }
        v1Var.m5();
    }

    /* access modifiers changed from: private */
    public static final W2.J V6(C2657f fVar, C2540v1 v1Var) {
        if (fVar.S() != null) {
            String S4 = fVar.S();
            t.b(S4);
            v1Var.n7(S4);
        }
        return W2.J.f19942a;
    }

    private final void W2(int i5, String str, long j5) {
        if (getContext() != null && i5 >= 0) {
            C2641A.a aVar = C2641A.f24721f;
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            C2641A b5 = aVar.b(requireContext);
            if (b5 != null && b5.c() == -1 && t.a(b5.d(), str) && b5.b() == j5) {
                Context requireContext2 = requireContext();
                t.d(requireContext2, "requireContext(...)");
                b5.l(requireContext2, i5);
            }
        }
    }

    private final void W3() {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), (C2312i) null, (w3.O) null, new C2554n(this, (C2308e) null), 3, (Object) null);
    }

    private final void W4(l2.O o5) {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new C2560t(this, o5, (C2308e) null), 2, (Object) null);
        B1 f42 = f4();
        Context requireContext = requireContext();
        t.d(requireContext, "requireContext(...)");
        f42.r0(requireContext, o5);
    }

    /* access modifiers changed from: private */
    public static final void W5(O0 o02, C2540v1 v1Var, View view) {
        if (o02.f22568q.getMaxLines() == Integer.MAX_VALUE) {
            o02.f22568q.setMaxLines(4);
            o02.f22573v.setText(v1Var.getString(com.uptodown.R.string.read_more_desc_app_detail));
            return;
        }
        o02.f22568q.setMaxLines(Integer.MAX_VALUE);
        o02.f22573v.setText(v1Var.getString(com.uptodown.R.string.read_less_desc_app_detail));
    }

    private final void W6(Rect rect) {
        if (getContext() != null && !t.a(a4().S(), requireContext().getPackageName())) {
            if (b4().f22770L.getRoot().getLocalVisibleRect(rect) && !((Boolean) f4().K().getValue()).booleanValue()) {
                Context requireContext = requireContext();
                t.d(requireContext, "requireContext(...)");
                n nVar = new n(requireContext);
                RelativeLayout relativeLayout = b4().f22764G;
                t.d(relativeLayout, "rlBottomBoxDownloadButtonAppDetail");
                nVar.i(relativeLayout, com.uptodown.R.anim.slide_out_bottom);
                f4().K().setValue(Boolean.valueOf(!((Boolean) f4().K().getValue()).booleanValue()));
            } else if (!b4().f22770L.getRoot().getLocalVisibleRect(rect) && ((Boolean) f4().K().getValue()).booleanValue()) {
                Context requireContext2 = requireContext();
                t.d(requireContext2, "requireContext(...)");
                n nVar2 = new n(requireContext2);
                RelativeLayout relativeLayout2 = b4().f22764G;
                t.d(relativeLayout2, "rlBottomBoxDownloadButtonAppDetail");
                nVar2.h(relativeLayout2, com.uptodown.R.anim.slide_in_bottom);
                f4().K().setValue(Boolean.valueOf(!((Boolean) f4().K().getValue()).booleanValue()));
            }
        }
    }

    /* access modifiers changed from: private */
    public final Object X2(Context context, C2308e eVar) {
        boolean z4;
        kotlin.jvm.internal.L l5 = new kotlin.jvm.internal.L();
        kotlin.jvm.internal.I i5 = new kotlin.jvm.internal.I();
        kotlin.jvm.internal.I i6 = new kotlin.jvm.internal.I();
        String S4 = a4().S();
        C2668q qVar = null;
        if (S4 == null || S4.length() == 0) {
            Object g5 = C2872g.g(C2865c0.c(), new C2549i(this, (C2308e) null), eVar);
            if (g5 == C2316b.f()) {
                return g5;
            }
            return W2.J.f19942a;
        }
        f4().R().setValue(new C2954m().C(context, a4().S()));
        C2940B a5 = C2940B.f26458v.a(context);
        a5.a();
        if (f4().R().getValue() != null) {
            w j02 = f4().j0();
            String S5 = a4().S();
            t.b(S5);
            j02.setValue(a5.G0(S5));
            l2.T t5 = (l2.T) f4().j0().getValue();
            if (t5 != null) {
                qVar = t5.b(context);
            }
            l5.f24690a = qVar;
        } else {
            l5.f24690a = a5.h0(String.valueOf(a4().A()));
        }
        C2668q qVar2 = (C2668q) l5.f24690a;
        boolean z5 = true;
        if (qVar2 == null || !qVar2.M()) {
            z4 = false;
        } else {
            z4 = true;
        }
        i5.f24687a = z4;
        a5.m();
        C2668q qVar3 = (C2668q) l5.f24690a;
        if (qVar3 == null || qVar3.E() != a4().J()) {
            z5 = false;
        }
        i6.f24687a = z5;
        Object g6 = C2872g.g(C2865c0.c(), new C2548h(this, context, l5, i5, i6, (C2308e) null), eVar);
        if (g6 == C2316b.f()) {
            return g6;
        }
        return W2.J.f19942a;
    }

    private final void X3() {
        String v02;
        String k5 = a4().k();
        if (k5 != null && k5.length() != 0) {
            if (b4().f22784Z.getVisibility() == 0) {
                b4().f22822s0.setText(com.uptodown.R.string.read_less_desc_app_detail);
                b4().f22784Z.setVisibility(8);
                String C02 = a4().C0();
                if (!((C02 == null || C02.length() == 0) && ((v02 = a4().v0()) == null || v02.length() == 0))) {
                    b4().f22777S.setVisibility(0);
                }
                b4().f22794e0.setMaxLines(Integer.MAX_VALUE);
                b4().f22794e0.setEllipsize((TextUtils.TruncateAt) null);
                String t5 = a4().t();
                if (t5 != null && t5.length() != 0) {
                    b4().f22771M.setVisibility(0);
                    return;
                }
                return;
            }
            b4().f22822s0.setText(com.uptodown.R.string.read_more_desc_app_detail);
            b4().f22784Z.setVisibility(0);
            b4().f22777S.setVisibility(8);
            b4().f22794e0.setMaxLines(6);
            b4().f22794e0.setEllipsize(TextUtils.TruncateAt.END);
            b4().f22771M.setVisibility(8);
            b4().f22786a0.smoothScrollTo(0, b4().f22773O.f22890t.getBottom(), 1000);
        }
    }

    private final void X4() {
        boolean z4;
        V.b bVar = l2.V.f24870q;
        Context requireContext = requireContext();
        t.d(requireContext, "requireContext(...)");
        l2.V h5 = bVar.h(requireContext);
        if (h5 == null || !h5.q()) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (a4().d() != 1 || z4) {
            b4().f22758D.setVisibility(8);
            b4().f22758D.release();
            return;
        }
        try {
            b4().f22758D.init(new BannerSize(5, getResources().getDisplayMetrics().widthPixels, (int) getResources().getDimension(com.uptodown.R.dimen.mintegral_banner_height)), "1517644", "3351941");
            b4().f22758D.setAllowShowCloseBtn(true);
            b4().f22758D.setRefreshTime(15);
            b4().f22758D.setBannerAdListener(new C2561u(this));
            b4().f22758D.load();
        } catch (Exception e5) {
            e5.printStackTrace();
            Bundle bundle = new Bundle();
            bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "exception");
            new z2.F(getContext()).d("mintegral_banner", bundle);
            b4().f22758D.setVisibility(8);
            b4().f22758D.release();
        }
    }

    /* access modifiers changed from: private */
    public static final void X5(C2540v1 v1Var, l2.O o5, View view) {
        UptodownApp.a aVar = UptodownApp.f13477F;
        if (aVar.Z()) {
            Intent intent = new Intent(v1Var.requireActivity(), RepliesActivity.class);
            intent.putExtra("review", o5);
            intent.putExtra("appName", v1Var.a4().N());
            intent.putExtra("appIconUrl", v1Var.a4().E());
            FragmentActivity requireActivity = v1Var.requireActivity();
            t.d(requireActivity, "requireActivity(...)");
            v1Var.startActivity(intent, aVar.a(requireActivity));
        }
    }

    private final void X6(AlertDialog.Builder builder) {
        FragmentActivity activity = getActivity();
        t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        if (((C1598a) activity).p2() != null) {
            FragmentActivity activity2 = getActivity();
            t.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            AlertDialog p22 = ((C1598a) activity2).p2();
            t.b(p22);
            if (p22.isShowing()) {
                return;
            }
        }
        FragmentActivity activity3 = getActivity();
        t.c(activity3, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        ((C1598a) activity3).P2(builder.create());
        if (getActivity() != null && !requireActivity().isFinishing()) {
            FragmentActivity activity4 = getActivity();
            t.c(activity4, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            if (((C1598a) activity4).p2() != null) {
                FragmentActivity activity5 = getActivity();
                t.c(activity5, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                AlertDialog p23 = ((C1598a) activity5).p2();
                t.b(p23);
                Window window = p23.getWindow();
                if (window != null) {
                    window.setBackgroundDrawable(new ColorDrawable(0));
                }
                FragmentActivity activity6 = getActivity();
                t.c(activity6, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                AlertDialog p24 = ((C1598a) activity6).p2();
                t.b(p24);
                p24.show();
            }
        }
    }

    private final void Y2() {
        FragmentActivity activity = getActivity();
        t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        if (((C1598a) activity).V()) {
            a.C0147a aVar = a.f15150a;
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            if (!aVar.e0(requireContext)) {
                u7();
            } else {
                z6();
            }
        } else {
            FragmentActivity activity2 = getActivity();
            t.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            ((C1598a) activity2).p0();
        }
    }

    private final void Y3() {
        String O4 = a4().O();
        if (O4 != null && O4.length() != 0) {
            if (b4().f22778T.f23674e.getVisibility() == 0) {
                b4().f22778T.f23671b.setText(com.uptodown.R.string.read_less_desc_app_detail);
                b4().f22778T.f23674e.setVisibility(8);
                b4().f22778T.f23673d.setMaxLines(Integer.MAX_VALUE);
                b4().f22778T.f23673d.setEllipsize((TextUtils.TruncateAt) null);
                return;
            }
            b4().f22778T.f23671b.setText(com.uptodown.R.string.read_more_desc_app_detail);
            b4().f22778T.f23674e.setVisibility(0);
            b4().f22778T.f23673d.setMaxLines(6);
            b4().f22778T.f23673d.setEllipsize(TextUtils.TruncateAt.END);
            b4().f22786a0.smoothScrollTo(0, b4().f22778T.f23672c.getTop(), 1000);
        }
    }

    private final void Y4() {
        if (a4().z() != null) {
            com.squareup.picasso.w l5 = com.squareup.picasso.s.h().l(a4().z());
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            l5.n(new B2.d(requireContext)).j(b4().f22772N.f22848b, new C2562v(this));
        }
    }

    /* access modifiers changed from: private */
    public static final void Y5(C2540v1 v1Var, O0 o02, l2.O o5, View view) {
        if (UptodownApp.f13477F.Z()) {
            Context requireContext = v1Var.requireContext();
            t.d(requireContext, "requireContext(...)");
            n nVar = new n(requireContext);
            ImageView imageView = o02.f22556e;
            t.d(imageView, "ivLikesCounterReview");
            nVar.n(imageView);
            if (!l2.O.f24814p.d(o5.g())) {
                v1Var.W4(o5);
                o02.f22570s.setText(String.valueOf(o5.h() + 1));
            }
        }
    }

    private final void Y6() {
        boolean z4;
        V.b bVar = l2.V.f24870q;
        Context requireContext = requireContext();
        t.d(requireContext, "requireContext(...)");
        l2.V h5 = bVar.h(requireContext);
        if (h5 == null || !h5.q()) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (getContext() != null && a4().d() == 1 && !z4) {
            a.C0147a aVar = a.f15150a;
            Context requireContext2 = requireContext();
            t.d(requireContext2, "requireContext(...)");
            long v5 = aVar.v(requireContext2);
            if (v5 == 0 || System.currentTimeMillis() - v5 >= ((long) 86400000)) {
                try {
                    MBNewInterstitialHandler mBNewInterstitialHandler = new MBNewInterstitialHandler(requireContext(), "1525209", "3361225");
                    mBNewInterstitialHandler.setInterstitialVideoListener(new T(this, mBNewInterstitialHandler));
                    mBNewInterstitialHandler.playVideoMute(1);
                    mBNewInterstitialHandler.load();
                } catch (Exception e5) {
                    e5.printStackTrace();
                    Bundle bundle = new Bundle();
                    bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "exception");
                    new z2.F(getContext()).d("mintegral_interstitial", bundle);
                }
            }
        }
    }

    private final void Z2() {
        if (a4().M0()) {
            C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new C2550j(this, (C2308e) null), 2, (Object) null);
            B1 f42 = f4();
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            f42.v(requireContext, a4().e());
        }
    }

    /* access modifiers changed from: private */
    public final void Z3() {
        if (getContext() != null) {
            UptodownApp.a aVar = UptodownApp.f13477F;
            if (aVar.v() > 0) {
                b4().f22772N.f22848b.setLayoutParams(new RelativeLayout.LayoutParams(-1, aVar.v()));
                b4().f22791d.setScrimVisibleHeightTrigger((int) (((double) aVar.v()) * 0.4d));
            }
        }
    }

    /* access modifiers changed from: private */
    public final void Z4(int i5) {
        if (!a4().P()) {
            a4().T0(true);
            Bundle bundle = new Bundle();
            bundle.putString("appId", String.valueOf(a4().e()));
            bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, "noCompatibleFile");
            bundle.putInt("installed", i5);
            z2.F f5 = this.f24351d;
            if (f5 != null) {
                f5.d("app_details", bundle);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void Z5(C2540v1 v1Var, View view) {
        v1Var.e7();
    }

    /* access modifiers changed from: private */
    public final void Z6(int i5) {
        Menu menu = this.f24354g;
        if (menu != null) {
            t.b(menu);
            menu.findItem(i5).setVisible(true);
        }
    }

    private final void a3() {
        if (getActivity() != null && !requireActivity().isFinishing()) {
            V.b bVar = l2.V.f24870q;
            FragmentActivity requireActivity = requireActivity();
            t.d(requireActivity, "requireActivity(...)");
            l2.V h5 = bVar.h(requireActivity);
            if (h5 == null || !h5.q()) {
                S3();
                W2.J j5 = W2.J.f19942a;
            } else if (a4().j0() == null) {
                FragmentActivity requireActivity2 = requireActivity();
                t.d(requireActivity2, "requireActivity(...)");
                new C2392n(requireActivity2, String.valueOf(a4().A()), a4().n0(), new C2551k(this), LifecycleOwnerKt.getLifecycleScope(this));
            } else {
                l2.L j02 = a4().j0();
                t.b(j02);
                if (j02.d() > 0) {
                    FragmentActivity activity = getActivity();
                    t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                    ((C1598a) activity).j2(a4(), new C2534t1(this), new C2509l(this));
                } else {
                    S3();
                }
                W2.J j6 = W2.J.f19942a;
            }
        }
    }

    private final void a5(String str) {
        Bundle bundle = new Bundle();
        bundle.putString(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, str);
        bundle.putString("packagename", a4().S());
        if (a4().e() >= 0) {
            bundle.putString("appId", String.valueOf(a4().e()));
        }
        if (a4().A() >= 0) {
            bundle.putString("fileId", String.valueOf(a4().A()));
        }
        if (Q4()) {
            bundle.putInt("deeplink", 1);
        } else {
            bundle.putInt("deeplink", 0);
        }
        z2.F f5 = this.f24351d;
        if (f5 != null) {
            f5.d("warning", bundle);
        }
    }

    /* access modifiers changed from: private */
    public final void a6(ArrayList arrayList) {
        LinearLayout linearLayout = b4().f22831x;
        t.d(linearLayout, "llReviewListContainer");
        if (linearLayout.getChildCount() == 0 && getContext() != null) {
            if (arrayList == null || arrayList.isEmpty()) {
                b4().f22831x.setVisibility(8);
                b4().f22769K.setVisibility(8);
                return;
            }
            int dimension = (int) getResources().getDimension(com.uptodown.R.dimen.margin_m);
            if (arrayList.size() >= 5) {
                b4().f22832x0.setVisibility(0);
            }
            if (t3.s.E(getString(com.uptodown.R.string.screen_type), "phone", true)) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.setMargins(0, dimension, 0, 0);
                Iterator it = arrayList.iterator();
                t.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    t.d(next, "next(...)");
                    l2.O o5 = (l2.O) next;
                    if (o5.p()) {
                        LinearLayout linearLayout2 = b4().f22831x;
                        Context requireContext = requireContext();
                        t.d(requireContext, "requireContext(...)");
                        linearLayout2.addView(S5(layoutParams, o5, requireContext));
                    } else {
                        LinearLayout linearLayout3 = b4().f22831x;
                        Context requireContext2 = requireContext();
                        t.d(requireContext2, "requireContext(...)");
                        linearLayout3.addView(K5(layoutParams, o5, requireContext2));
                    }
                }
                return;
            }
            LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-1, -2);
            layoutParams2.setMargins(0, dimension, 0, dimension);
            for (int i5 = 0; i5 < arrayList.size(); i5 += 2) {
                LinearLayout linearLayout4 = new LinearLayout(getContext());
                linearLayout4.setOrientation(0);
                linearLayout4.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
                LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(-1, -2);
                layoutParams2.setMargins(0, dimension, 0, dimension);
                layoutParams3.weight = 1.0f;
                if (((l2.O) arrayList.get(i5)).p()) {
                    Object obj = arrayList.get(i5);
                    t.d(obj, "get(...)");
                    Context requireContext3 = requireContext();
                    t.d(requireContext3, "requireContext(...)");
                    linearLayout4.addView(S5(layoutParams2, (l2.O) obj, requireContext3));
                } else {
                    Object obj2 = arrayList.get(i5);
                    t.d(obj2, "get(...)");
                    Context requireContext4 = requireContext();
                    t.d(requireContext4, "requireContext(...)");
                    linearLayout4.addView(K5(layoutParams3, (l2.O) obj2, requireContext4));
                }
                int i6 = i5 + 1;
                if (i6 < arrayList.size()) {
                    LinearLayout.LayoutParams layoutParams4 = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams4.setMargins(dimension, dimension, 0, dimension);
                    layoutParams4.weight = 1.0f;
                    if (!((l2.O) arrayList.get(i6)).p()) {
                        Object obj3 = arrayList.get(i6);
                        t.d(obj3, "get(...)");
                        Context requireContext5 = requireContext();
                        t.d(requireContext5, "requireContext(...)");
                        linearLayout4.addView(K5(layoutParams4, (l2.O) obj3, requireContext5));
                    }
                } else {
                    linearLayout4.addView(R5(layoutParams3));
                }
                b4().f22831x.addView(linearLayout4);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void a7(ArrayList arrayList) {
        K0 c5 = K0.c(getLayoutInflater());
        t.d(c5, "inflate(...)");
        b4().f22795f.addView(c5.getRoot());
        b4().f22795f.setVisibility(0);
        TextView textView = c5.f22453g;
        k.a aVar = S1.k.f32g;
        textView.setTypeface(aVar.w());
        c5.f22452f.setTypeface(aVar.w());
        kotlin.jvm.internal.I i5 = new kotlin.jvm.internal.I();
        ArrayList arrayList2 = new ArrayList();
        R1.U u5 = new R1.U(arrayList, new U(arrayList, arrayList2, i5));
        c5.f22451e.setLayoutManager(new LinearLayoutManager(requireContext(), 1, false));
        c5.f22451e.setItemAnimator((RecyclerView.ItemAnimator) null);
        c5.f22451e.setAdapter(u5);
        c5.f22452f.setOnClickListener(new C2524q(arrayList, this, arrayList2, i5, c5));
        c5.f22448b.setOnClickListener(new r(this, c5));
        c5.f22454h.setOnClickListener(new C2529s(this, c5));
        FragmentActivity requireActivity = requireActivity();
        t.d(requireActivity, "requireActivity(...)");
        n nVar = new n(requireActivity);
        View view = c5.f22454h;
        t.d(view, "vBackgroundRemoteInstallDevices");
        nVar.d(view, 1.0f);
        FragmentActivity requireActivity2 = requireActivity();
        t.d(requireActivity2, "requireActivity(...)");
        n nVar2 = new n(requireActivity2);
        RelativeLayout relativeLayout = c5.f22450d;
        t.d(relativeLayout, "rlpRemoteInstallDevices");
        nVar2.h(relativeLayout, com.uptodown.R.anim.slide_in_bottom);
    }

    /* access modifiers changed from: private */
    public static final W2.J b3(C2540v1 v1Var) {
        v1Var.S3();
        return W2.J.f19942a;
    }

    /* access modifiers changed from: private */
    public final C2403b b4() {
        C2403b bVar = this.f24349b;
        t.b(bVar);
        return bVar;
    }

    /* access modifiers changed from: private */
    public static final void b5(C2540v1 v1Var, ActivityResult activityResult) {
        String str;
        if (activityResult.getResultCode() == 1) {
            V.b bVar = l2.V.f24870q;
            Context requireContext = v1Var.requireContext();
            t.d(requireContext, "requireContext(...)");
            l2.V h5 = bVar.h(requireContext);
            if (h5 != null) {
                str = h5.j();
            } else {
                str = null;
            }
            if (str != null) {
                Context requireContext2 = v1Var.requireContext();
                t.d(requireContext2, "requireContext(...)");
                if (h5.p(requireContext2)) {
                    UptodownApp.a aVar = UptodownApp.f13477F;
                    Context requireContext3 = v1Var.requireContext();
                    t.d(requireContext3, "requireContext(...)");
                    aVar.l0(requireContext3);
                    Context requireContext4 = v1Var.requireContext();
                    t.d(requireContext4, "requireContext(...)");
                    aVar.k0(requireContext4);
                    v1Var.k6();
                    v1Var.Z2();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void b6(ArrayList arrayList, ArrayList arrayList2) {
        if (!arrayList.isEmpty()) {
            ArrayList arrayList3 = new ArrayList();
            if (!arrayList2.isEmpty()) {
                int size = arrayList2.size();
                int i5 = 0;
                while (i5 < size) {
                    Object obj = arrayList2.get(i5);
                    i5++;
                    l2.b0 b0Var = (l2.b0) obj;
                    String b5 = b0Var.b();
                    if (!(b5 == null || b5.length() == 0)) {
                        arrayList3.add(b0Var);
                    }
                }
            }
            ArrayList arrayList4 = new ArrayList();
            int size2 = arrayList.size();
            for (int i6 = 0; i6 < size2; i6++) {
                Object obj2 = arrayList.get(i6);
                t.d(obj2, "get(...)");
                l2.P p5 = (l2.P) obj2;
                if (p5.a() == 0) {
                    arrayList4.add(p5);
                }
            }
            kotlin.jvm.internal.L l5 = new kotlin.jvm.internal.L();
            L l6 = new L(this, arrayList4, l5, arrayList3);
            ArrayList arrayList5 = new ArrayList();
            arrayList5.addAll(arrayList3);
            arrayList5.addAll(arrayList4);
            l5.f24690a = new R1.D(arrayList5, l6);
            b4().f22781W.setAdapter((RecyclerView.Adapter) l5.f24690a);
            b4().f22781W.setVisibility(0);
            return;
        }
        b4().f22781W.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public static final void b7(ArrayList arrayList, C2540v1 v1Var, ArrayList arrayList2, kotlin.jvm.internal.I i5, K0 k02, View view) {
        Object obj;
        int size = arrayList.size();
        int i6 = 0;
        while (true) {
            if (i6 >= size) {
                obj = null;
                break;
            }
            obj = arrayList.get(i6);
            i6++;
            if (((l2.Z) obj).d() == 1) {
                break;
            }
        }
        l2.Z z4 = (l2.Z) obj;
        if (z4 != null) {
            B1 f42 = v1Var.f4();
            Context requireContext = v1Var.requireContext();
            t.d(requireContext, "requireContext(...)");
            f42.u0(requireContext, v1Var.a4().e(), z4, arrayList2);
        }
        if (i5.f24687a && v1Var.a4().J0() && v1Var.a4().G0()) {
            Context requireContext2 = v1Var.requireContext();
            t.d(requireContext2, "requireContext(...)");
            v1Var.P3(requireContext2);
        }
        v1Var.d3(k02);
    }

    /* access modifiers changed from: private */
    public static final W2.J c3(C2540v1 v1Var) {
        FragmentActivity requireActivity = v1Var.requireActivity();
        t.d(requireActivity, "requireActivity(...)");
        v1Var.M2(requireActivity);
        return W2.J.f19942a;
    }

    private final void c4() {
        if (a4().e() > 0) {
            H5();
            C2();
            W2.J j5 = W2.J.f19942a;
            return;
        }
        Context requireContext = requireContext();
        t.d(requireContext, "requireContext(...)");
        new C2388j(requireContext, ((Number) f4().D().getValue()).longValue(), new C2555o(this), LifecycleOwnerKt.getLifecycleScope(this));
    }

    /* access modifiers changed from: private */
    public final void c5() {
        V.b bVar = l2.V.f24870q;
        Context requireContext = requireContext();
        t.d(requireContext, "requireContext(...)");
        bVar.b(requireContext);
        m5();
    }

    /* access modifiers changed from: private */
    public final void c6(ArrayList arrayList, boolean z4) {
        int i5;
        if (getContext() == null || arrayList == null || arrayList.isEmpty()) {
            b4().f22776R.setVisibility(8);
            return;
        }
        M m5 = new M(this);
        N n5 = new N(this);
        if (z4) {
            i5 = 25;
        } else {
            i5 = 20;
        }
        R1.K k5 = new R1.K(m5, n5, i5);
        this.f24355h = k5;
        t.b(k5);
        k5.d(arrayList);
        b4().f22782X.setAdapter(this.f24355h);
        b4().f22782X.setNestedScrollingEnabled(false);
        b4().f22782X.setItemAnimator((RecyclerView.ItemAnimator) null);
        b4().f22782X.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        b4().f22776R.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public static final void c7(C2540v1 v1Var, K0 k02, View view) {
        v1Var.d3(k02);
    }

    private final void d3(K0 k02) {
        if (f4().B().compareAndSet(false, true)) {
            FragmentActivity requireActivity = requireActivity();
            t.d(requireActivity, "requireActivity(...)");
            n nVar = new n(requireActivity);
            View view = k02.f22454h;
            t.d(view, "vBackgroundRemoteInstallDevices");
            nVar.d(view, 0.0f);
            FragmentActivity requireActivity2 = requireActivity();
            t.d(requireActivity2, "requireActivity(...)");
            n nVar2 = new n(requireActivity2);
            RelativeLayout relativeLayout = k02.f22450d;
            t.d(relativeLayout, "rlpRemoteInstallDevices");
            nVar2.g(relativeLayout, com.uptodown.R.anim.slide_out_bottom, new C2552l(this));
        }
    }

    /* access modifiers changed from: private */
    public final void d4() {
        if (getContext() != null) {
            C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new C2556p(this, (C2308e) null), 2, (Object) null);
            B1 f42 = f4();
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            f42.V(requireContext, a4().e());
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0073 A[Catch:{ Exception -> 0x0026 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00ac A[Catch:{ Exception -> 0x0026 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00d5 A[Catch:{ Exception -> 0x0026 }] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00dc A[Catch:{ Exception -> 0x0026 }] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00e7 A[Catch:{ Exception -> 0x0026 }, LOOP:0: B:40:0x00e5->B:41:0x00e7, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void d5() {
        /*
            r4 = this;
            i2.B1 r0 = r4.f4()     // Catch:{ Exception -> 0x0026 }
            z3.w r0 = r0.O()     // Catch:{ Exception -> 0x0026 }
            java.lang.Object r0 = r0.getValue()     // Catch:{ Exception -> 0x0026 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ Exception -> 0x0026 }
            boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x0026 }
            if (r0 != 0) goto L_0x0029
            android.graphics.Rect r0 = new android.graphics.Rect     // Catch:{ Exception -> 0x0026 }
            r0.<init>()     // Catch:{ Exception -> 0x0026 }
            h2.b r1 = r4.b4()     // Catch:{ Exception -> 0x0026 }
            androidx.core.widget.NestedScrollView r1 = r1.f22786a0     // Catch:{ Exception -> 0x0026 }
            r1.getHitRect(r0)     // Catch:{ Exception -> 0x0026 }
            r4.W6(r0)     // Catch:{ Exception -> 0x0026 }
            goto L_0x0029
        L_0x0026:
            r0 = move-exception
            goto L_0x00f3
        L_0x0029:
            i2.B1 r0 = r4.f4()     // Catch:{ Exception -> 0x0026 }
            z3.w r0 = r0.O()     // Catch:{ Exception -> 0x0026 }
            java.lang.Object r0 = r0.getValue()     // Catch:{ Exception -> 0x0026 }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ Exception -> 0x0026 }
            boolean r0 = r0.booleanValue()     // Catch:{ Exception -> 0x0026 }
            java.lang.String r1 = "requireContext(...)"
            if (r0 != 0) goto L_0x005b
            l2.f r0 = r4.a4()     // Catch:{ Exception -> 0x0026 }
            java.lang.String r0 = r0.o()     // Catch:{ Exception -> 0x0026 }
            if (r0 == 0) goto L_0x005b
            int r0 = r0.length()     // Catch:{ Exception -> 0x0026 }
            if (r0 != 0) goto L_0x0050
            goto L_0x005b
        L_0x0050:
            android.content.Context r0 = r4.requireContext()     // Catch:{ Exception -> 0x0026 }
            kotlin.jvm.internal.t.d(r0, r1)     // Catch:{ Exception -> 0x0026 }
            r4.f7(r0)     // Catch:{ Exception -> 0x0026 }
            goto L_0x0068
        L_0x005b:
            i2.B1 r0 = r4.f4()     // Catch:{ Exception -> 0x0026 }
            z3.w r0 = r0.O()     // Catch:{ Exception -> 0x0026 }
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch:{ Exception -> 0x0026 }
            r0.setValue(r2)     // Catch:{ Exception -> 0x0026 }
        L_0x0068:
            l2.f r0 = r4.a4()     // Catch:{ Exception -> 0x0026 }
            java.lang.String r0 = r0.q0()     // Catch:{ Exception -> 0x0026 }
            r2 = 0
            if (r0 == 0) goto L_0x008e
            int r0 = r0.length()     // Catch:{ Exception -> 0x0026 }
            if (r0 != 0) goto L_0x007a
            goto L_0x008e
        L_0x007a:
            boolean r0 = r4.g4()     // Catch:{ Exception -> 0x0026 }
            if (r0 != 0) goto L_0x008e
            h2.b r0 = r4.b4()     // Catch:{ Exception -> 0x0026 }
            h2.v1 r0 = r0.f22765G0     // Catch:{ Exception -> 0x0026 }
            android.widget.RelativeLayout r0 = r0.getRoot()     // Catch:{ Exception -> 0x0026 }
            r0.setVisibility(r2)     // Catch:{ Exception -> 0x0026 }
            goto L_0x009d
        L_0x008e:
            h2.b r0 = r4.b4()     // Catch:{ Exception -> 0x0026 }
            h2.v1 r0 = r0.f22765G0     // Catch:{ Exception -> 0x0026 }
            android.widget.RelativeLayout r0 = r0.getRoot()     // Catch:{ Exception -> 0x0026 }
            r3 = 8
            r0.setVisibility(r3)     // Catch:{ Exception -> 0x0026 }
        L_0x009d:
            r4.W3()     // Catch:{ Exception -> 0x0026 }
            h2.b r0 = r4.b4()     // Catch:{ Exception -> 0x0026 }
            androidx.core.widget.NestedScrollView r0 = r0.f22786a0     // Catch:{ Exception -> 0x0026 }
            int r0 = r0.getScrollY()     // Catch:{ Exception -> 0x0026 }
            if (r0 <= 0) goto L_0x00d1
            android.content.Context r0 = r4.requireContext()     // Catch:{ Exception -> 0x0026 }
            kotlin.jvm.internal.t.d(r0, r1)     // Catch:{ Exception -> 0x0026 }
            r4.l7(r0)     // Catch:{ Exception -> 0x0026 }
            l2.f r0 = r4.a4()     // Catch:{ Exception -> 0x0026 }
            java.lang.String r0 = r0.z()     // Catch:{ Exception -> 0x0026 }
            if (r0 == 0) goto L_0x00c6
            int r0 = r0.length()     // Catch:{ Exception -> 0x0026 }
            if (r0 != 0) goto L_0x00d1
        L_0x00c6:
            h2.b r0 = r4.b4()     // Catch:{ Exception -> 0x0026 }
            com.google.android.material.appbar.CollapsingToolbarLayout r0 = r0.f22791d     // Catch:{ Exception -> 0x0026 }
            java.lang.String r1 = ""
            r0.setTitle(r1)     // Catch:{ Exception -> 0x0026 }
        L_0x00d1:
            R1.K r0 = r4.f24355h     // Catch:{ Exception -> 0x0026 }
            if (r0 == 0) goto L_0x00d8
            r0.notifyDataSetChanged()     // Catch:{ Exception -> 0x0026 }
        L_0x00d8:
            R1.K r0 = r4.f24356i     // Catch:{ Exception -> 0x0026 }
            if (r0 == 0) goto L_0x00df
            r0.notifyDataSetChanged()     // Catch:{ Exception -> 0x0026 }
        L_0x00df:
            java.util.ArrayList r0 = r4.f24357j     // Catch:{ Exception -> 0x0026 }
            int r1 = r0.size()     // Catch:{ Exception -> 0x0026 }
        L_0x00e5:
            if (r2 >= r1) goto L_0x00f6
            java.lang.Object r3 = r0.get(r2)     // Catch:{ Exception -> 0x0026 }
            int r2 = r2 + 1
            R1.K r3 = (R1.K) r3     // Catch:{ Exception -> 0x0026 }
            r3.notifyDataSetChanged()     // Catch:{ Exception -> 0x0026 }
            goto L_0x00e5
        L_0x00f3:
            r0.printStackTrace()
        L_0x00f6:
            h2.b r0 = r4.b4()
            com.mbridge.msdk.out.MBBannerView r0 = r0.f22758D
            java.lang.String r1 = "mbBannerView"
            kotlin.jvm.internal.t.d(r0, r1)
            r0.onResume()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.C2540v1.d5():void");
    }

    /* access modifiers changed from: private */
    public final void d6(ArrayList arrayList) {
        LinearLayout linearLayout = b4().f22819r;
        t.d(linearLayout, "llFloatingCategoriesAppDetail");
        if (linearLayout.getChildCount() == 0) {
            b4().f22804j0.setVisibility(8);
            if (getActivity() != null) {
                Iterator it = arrayList.iterator();
                int i5 = 0;
                while (it.hasNext()) {
                    int i6 = i5 + 1;
                    l2.S s5 = (l2.S) it.next();
                    h2.Y c5 = h2.Y.c(getLayoutInflater());
                    t.d(c5, "inflate(...)");
                    if (i5 > 0) {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                        layoutParams.setMargins(0, (int) getResources().getDimension(com.uptodown.R.dimen.margin_l), 0, 0);
                        c5.getRoot().setLayoutParams(layoutParams);
                    }
                    R1.K k5 = new R1.K(new O(this), new P(this), 20);
                    k5.d(s5.a());
                    c5.f22714e.setTypeface(S1.k.f32g.w());
                    c5.f22714e.setText(s5.b().e());
                    c5.f22712c.setOnClickListener(new C2571x0(this, s5));
                    c5.f22713d.setAdapter(k5);
                    c5.f22713d.setNestedScrollingEnabled(false);
                    c5.f22713d.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
                    DefaultItemAnimator defaultItemAnimator = new DefaultItemAnimator();
                    defaultItemAnimator.setSupportsChangeAnimations(false);
                    c5.f22713d.setItemAnimator(defaultItemAnimator);
                    b4().f22819r.addView(c5.getRoot());
                    this.f24357j.add(k5);
                    i5 = i6;
                }
            }
            b4().f22821s.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    public static final void d7(C2540v1 v1Var, K0 k02, View view) {
        v1Var.d3(k02);
    }

    private final void e3() {
        FragmentActivity activity = getActivity();
        t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        AlertDialog p22 = ((C1598a) activity).p2();
        if (p22 != null) {
            p22.dismiss();
        }
        kotlin.jvm.internal.I i5 = new kotlin.jvm.internal.I();
        if (S4(this, (l2.T) null, 1, (Object) null)) {
            DownloadWorker.a aVar = DownloadWorker.f21359d;
            i5.f24687a = aVar.h();
            aVar.n();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        C2436s c5 = C2436s.c(getLayoutInflater());
        t.d(c5, "inflate(...)");
        if (getActivity() != null && !requireActivity().isFinishing()) {
            TextView textView = c5.f23528d;
            k.a aVar2 = S1.k.f32g;
            textView.setTypeface(aVar2.x());
            c5.f23528d.setText(requireContext().getString(com.uptodown.R.string.download_cancel_confimation_title));
            c5.f23527c.setTypeface(aVar2.w());
            c5.f23527c.setText(requireContext().getString(com.uptodown.R.string.dialog_confirmation_verify_negative));
            c5.f23527c.setOnClickListener(new C2528r1(i5, this));
            c5.f23529e.setTypeface(aVar2.w());
            c5.f23529e.setText(requireContext().getString(com.uptodown.R.string.dialog_confirmation_verify_afirmative));
            c5.f23529e.setOnClickListener(new C2531s1(this));
        }
        builder.setView(c5.getRoot());
        builder.setCancelable(false);
        X6(builder);
    }

    private final long e4() {
        try {
            String q02 = a4().q0();
            if (q02 == null) {
                return 0;
            }
            if (q02.length() == 0) {
                return 0;
            }
            String q03 = a4().q0();
            t.b(q03);
            return Long.parseLong(q03);
        } catch (NumberFormatException e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    /* access modifiers changed from: private */
    public final void e5(C2654c cVar) {
        if (getActivity() != null && (getActivity() instanceof MainActivity)) {
            FragmentActivity activity = getActivity();
            t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
            ((MainActivity) activity).s8(cVar);
        } else if (getActivity() != null && (getActivity() instanceof AppDetailActivity)) {
            FragmentActivity activity2 = getActivity();
            t.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.AppDetailActivity");
            ((AppDetailActivity) activity2).x3(cVar);
        }
    }

    /* access modifiers changed from: private */
    public static final void e6(C2540v1 v1Var, l2.S s5, View view) {
        if (UptodownApp.f13477F.Z()) {
            v1Var.i5(s5.b());
        }
    }

    /* access modifiers changed from: private */
    public final void e7() {
        if (getContext() != null) {
            CustomTabsIntent build = new CustomTabsIntent.Builder().build();
            t.d(build, "build(...)");
            Z.a aVar = z2.Z.f26527b;
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            build.intent.setData(Uri.parse(new C2962v().c(aVar.c(requireContext))));
            ActivityResultLauncher activityResultLauncher = this.f24361n;
            Intent intent = build.intent;
            UptodownApp.a aVar2 = UptodownApp.f13477F;
            FragmentActivity requireActivity = requireActivity();
            t.d(requireActivity, "requireActivity(...)");
            activityResultLauncher.launch(intent, aVar2.b(requireActivity));
        }
    }

    /* access modifiers changed from: private */
    public static final void f3(kotlin.jvm.internal.I i5, C2540v1 v1Var, View view) {
        if (!i5.f24687a) {
            DownloadWorker.f21359d.o();
        }
        FragmentActivity activity = v1Var.getActivity();
        t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        AlertDialog p22 = ((C1598a) activity).p2();
        if (p22 != null) {
            p22.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public final B1 f4() {
        return (B1) this.f24350c.getValue();
    }

    private final void f5() {
        String S4;
        if (getActivity() != null && !requireActivity().isFinishing() && (S4 = a4().S()) != null && S4.length() != 0 && !t3.s.E(a4().S(), requireActivity().getPackageName(), true)) {
            PackageManager packageManager = requireActivity().getPackageManager();
            String S5 = a4().S();
            t.b(S5);
            Intent launchIntentForPackage = packageManager.getLaunchIntentForPackage(S5);
            if (launchIntentForPackage != null) {
                startActivity(launchIntentForPackage);
            }
        }
    }

    private final void f6() {
        boolean z4;
        boolean z5;
        boolean z6;
        String Y4;
        if (a4().G0()) {
            C2668q qVar = new C2668q();
            qVar.c(a4());
            if (!(!a4().N0() || (Y4 = a4().Y()) == null || Y4.length() == 0)) {
                C2669s sVar = new C2669s();
                long e5 = a4().e();
                String Y5 = a4().Y();
                t.b(Y5);
                sVar.a(e5, Y5);
                Context requireContext = requireContext();
                t.d(requireContext, "requireContext(...)");
                sVar.f(requireContext);
            }
            C2667p pVar = new C2667p();
            Context requireContext2 = requireContext();
            t.d(requireContext2, "requireContext(...)");
            pVar.k(requireContext2);
            a.C0147a aVar = a.f15150a;
            Context requireContext3 = requireContext();
            t.d(requireContext3, "requireContext(...)");
            boolean x12 = aVar.x1(requireContext3);
            boolean z7 = true;
            if (x12) {
                boolean i5 = pVar.i(qVar);
                z4 = pVar.g(qVar);
                z6 = pVar.h(qVar);
                if (a4().k0() != null) {
                    ArrayList k02 = a4().k0();
                    t.b(k02);
                    Context requireContext4 = requireContext();
                    t.d(requireContext4, "requireContext(...)");
                    z7 = pVar.f(k02, requireContext4);
                }
                z5 = z7;
                z7 = i5;
            } else {
                z6 = true;
                z5 = true;
                z4 = true;
            }
            if (z7 && z4 && z6 && z5) {
                a3();
            } else if (!z7) {
                a5("sdk");
                String string = getString(com.uptodown.R.string.msg_warning_incompatible_sdk);
                t.d(string, "getString(...)");
                h3(string);
            } else if (!z4) {
                a5("abi");
                String string2 = getString(com.uptodown.R.string.msg_warning_incompatible_abi);
                t.d(string2, "getString(...)");
                h3(string2);
            } else if (!z6) {
                a5("density");
                String string3 = getString(com.uptodown.R.string.msg_warning_incompatible_density);
                t.d(string3, "getString(...)");
                h3(string3);
            } else {
                a5("required_feature");
                String string4 = getString(com.uptodown.R.string.msg_warning_incompatible_required_features);
                t.d(string4, "getString(...)");
                h3(string4);
            }
        } else {
            a5("no_file_id");
            String string5 = getString(com.uptodown.R.string.msg_app_no_compatible_files);
            t.d(string5, "getString(...)");
            o3(string5);
        }
    }

    /* access modifiers changed from: private */
    public final void f7(Context context) {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), (C2312i) null, (w3.O) null, new X(this, context, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void g3(C2540v1 v1Var, View view) {
        Context requireContext = v1Var.requireContext();
        t.d(requireContext, "requireContext(...)");
        v1Var.M2(requireContext);
        FragmentActivity activity = v1Var.getActivity();
        t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        AlertDialog p22 = ((C1598a) activity).p2();
        if (p22 != null) {
            p22.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public final boolean g4() {
        FragmentActivity activity = getActivity();
        t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        if (!((C1598a) activity).V() || getContext() == null) {
            return true;
        }
        z2.E e5 = new z2.E();
        Context requireContext = requireContext();
        t.d(requireContext, "requireContext(...)");
        File h5 = e5.h(requireContext);
        C2942a aVar = new C2942a();
        z2.E e6 = new z2.E();
        Context requireContext2 = requireContext();
        t.d(requireContext2, "requireContext(...)");
        return aVar.a(e6.m(requireContext2, h5), e4());
    }

    private final void g5() {
        if (getActivity() != null && !requireActivity().isFinishing()) {
            Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
            intent.setData(Uri.fromParts("package", a4().S(), (String) null));
            intent.addFlags(268435456);
            intent.addFlags(8388608);
            try {
                startActivity(intent);
            } catch (ActivityNotFoundException e5) {
                e5.printStackTrace();
            }
        }
    }

    private final void g6() {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new Q(this, (C2308e) null), 2, (Object) null);
    }

    private final void g7() {
        b4().f22773O.f22876f.setVisibility(0);
        b4().f22773O.f22874d.setVisibility(8);
        b4().f22770L.f23096g.setVisibility(0);
        b4().f22770L.f23097h.setVisibility(8);
        b4().f22770L.f23101l.setVisibility(8);
        b4().f22770L.f23102m.setVisibility(8);
        b4().f22766H.f22350g.setVisibility(0);
        b4().f22766H.f22360q.setVisibility(8);
        b4().f22766H.f22351h.setVisibility(8);
        b4().f22766H.f22356m.setVisibility(8);
    }

    private final void h3(String str) {
        ArrayList k02;
        if (getActivity() != null) {
            FragmentActivity activity = getActivity();
            t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            AlertDialog p22 = ((C1598a) activity).p2();
            if (p22 != null) {
                p22.dismiss();
            }
        }
        if (getContext() != null) {
            ArrayList arrayList = new ArrayList();
            String S4 = a4().S();
            if (!(S4 == null || S4.length() == 0 || (k02 = a4().k0()) == null || k02.isEmpty())) {
                C2667p pVar = new C2667p();
                ArrayList k03 = a4().k0();
                t.b(k03);
                Context requireContext = requireContext();
                t.d(requireContext, "requireContext(...)");
                arrayList = pVar.e(k03, requireContext);
            }
            if (!arrayList.isEmpty()) {
                Iterator it = arrayList.iterator();
                t.d(it, "iterator(...)");
                String str2 = "";
                while (it.hasNext()) {
                    Object next = it.next();
                    t.d(next, "next(...)");
                    String str3 = (String) next;
                    if (t.a(str3, C2250q.X(arrayList))) {
                        str2 = str2 + "- " + str3;
                    } else {
                        str2 = str2 + "- " + str3 + 10;
                    }
                }
                str = str + "\n\n" + str2;
            }
            C2436s c5 = C2436s.c(getLayoutInflater());
            t.d(c5, "inflate(...)");
            TextView textView = c5.f23528d;
            k.a aVar = S1.k.f32g;
            textView.setTypeface(aVar.x());
            c5.f23528d.setText(str);
            c5.f23526b.setVisibility(0);
            c5.f23526b.setTypeface(aVar.x());
            c5.f23526b.setOnCheckedChangeListener(new C2515n(this));
            c5.f23529e.setTypeface(aVar.w());
            c5.f23529e.setOnClickListener(new C2518o(this));
            c5.f23527c.setTypeface(aVar.w());
            c5.f23527c.setOnClickListener(new C2521p(c5, this));
            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            builder.setView(c5.getRoot());
            builder.setCancelable(false);
            X6(builder);
        }
    }

    /* access modifiers changed from: private */
    public final void h4(int i5) {
        Menu menu = this.f24354g;
        if (menu != null) {
            t.b(menu);
            menu.findItem(i5).setVisible(false);
        }
    }

    private final void h5() {
        if (getContext() != null) {
            C2940B.a aVar = C2940B.f26458v;
            FragmentActivity requireActivity = requireActivity();
            t.d(requireActivity, "requireActivity(...)");
            C2940B a5 = aVar.a(requireActivity);
            a5.a();
            String S4 = a4().S();
            t.b(S4);
            C2655d Y4 = a5.Y(S4);
            a5.m();
            Intent intent = new Intent(requireActivity(), AppInstalledDetailsActivity.class);
            intent.putExtra("appInstalled", Y4);
            intent.putExtra("appInfo", a4());
            UptodownApp.a aVar2 = UptodownApp.f13477F;
            FragmentActivity requireActivity2 = requireActivity();
            t.d(requireActivity2, "requireActivity(...)");
            startActivity(intent, aVar2.a(requireActivity2));
        }
    }

    private final void h7() {
        b4().f22773O.f22876f.setVisibility(0);
        b4().f22773O.f22874d.setVisibility(8);
        b4().f22770L.f23097h.setVisibility(0);
        b4().f22770L.f23100k.setVisibility(0);
        b4().f22770L.f23101l.setVisibility(8);
        b4().f22770L.f23102m.setVisibility(8);
        b4().f22766H.f22360q.setVisibility(0);
        b4().f22766H.f22351h.setVisibility(8);
        b4().f22766H.f22356m.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public static final void i3(C2436s sVar, C2540v1 v1Var, View view) {
        if (sVar.f23526b.isChecked()) {
            a.C0147a aVar = a.f15150a;
            Context requireContext = v1Var.requireContext();
            t.d(requireContext, "requireContext(...)");
            aVar.k1(requireContext, true);
        }
        Context requireContext2 = v1Var.requireContext();
        t.d(requireContext2, "requireContext(...)");
        v1Var.v6(requireContext2);
        if (v1Var.getActivity() != null) {
            FragmentActivity activity = v1Var.getActivity();
            t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            AlertDialog p22 = ((C1598a) activity).p2();
            if (p22 != null) {
                p22.dismiss();
            }
        }
    }

    private final void i4() {
        i7();
        c cVar = c.f17333a;
        ProgressBar progressBar = b4().f22773O.f22879i;
        t.d(progressBar, "pbProgressAppDetail");
        ImageView imageView = b4().f22773O.f22872b;
        t.d(imageView, "ivLogoAppDetail");
        cVar.e(progressBar, imageView);
        f4().Q().setValue(-1);
        b4().f22770L.f23101l.setVisibility(8);
        b4().f22770L.f23102m.setVisibility(8);
        b4().f22770L.f23097h.setVisibility(8);
        b4().f22770L.f23098i.setVisibility(0);
        b4().f22773O.f22879i.setIndeterminate(true);
        b4().f22773O.f22892v.setText(getString(com.uptodown.R.string.status_download_update_pending));
        b4().f22766H.f22356m.setVisibility(8);
        b4().f22766H.f22345b.setVisibility(4);
        b4().f22766H.f22359p.setText("");
        b4().f22766H.f22349f.setIndeterminate(true);
        b4().f22766H.f22357n.setText("");
    }

    /* access modifiers changed from: private */
    public final void i5(C2660i iVar) {
        if (getActivity() != null && (getActivity() instanceof MainActivity)) {
            FragmentActivity activity = getActivity();
            t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
            ((MainActivity) activity).v8(iVar);
        } else if (getActivity() != null && (getActivity() instanceof AppDetailActivity)) {
            FragmentActivity activity2 = getActivity();
            t.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.AppDetailActivity");
            ((AppDetailActivity) activity2).y3(iVar);
        }
    }

    /* access modifiers changed from: private */
    public final void i6(View view, Context context) {
        ViewTreeObserver viewTreeObserver;
        if (a.f15150a.P(context) && view != null && (viewTreeObserver = view.getViewTreeObserver()) != null) {
            viewTreeObserver.addOnPreDrawListener(new R(view, this));
        }
    }

    private final void i7() {
        b4().f22773O.f22876f.setVisibility(8);
        b4().f22773O.f22874d.setVisibility(0);
        b4().f22770L.f23097h.setVisibility(0);
        b4().f22770L.f23100k.setVisibility(0);
        b4().f22770L.f23092c.setVisibility(8);
        b4().f22770L.f23101l.setVisibility(8);
        b4().f22766H.f22352i.setVisibility(8);
        b4().f22766H.f22360q.setVisibility(8);
        b4().f22766H.f22351h.setVisibility(0);
        b4().f22766H.f22356m.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public static final void j3(C2540v1 v1Var, CompoundButton compoundButton, boolean z4) {
        a.C0147a aVar = a.f15150a;
        Context requireContext = v1Var.requireContext();
        t.d(requireContext, "requireContext(...)");
        aVar.k1(requireContext, !z4);
    }

    private final void j4(Context context) {
        if (new C2962v().s(context)) {
            b4().f22788b0.setTitleTextColor(ContextCompat.getColor(requireActivity(), com.uptodown.R.color.main_blue));
        }
        b4().f22788b0.setNavigationIcon(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_arrow_left_white));
        b4().f22788b0.setNavigationContentDescription((CharSequence) getString(com.uptodown.R.string.back));
        b4().f22788b0.setNavigationOnClickListener(new N(this));
        b4().f22788b0.inflateMenu(com.uptodown.R.menu.toolbar_menu_app_detail);
        this.f24354g = b4().f22788b0.getMenu();
        b4().f22788b0.setOnMenuItemClickListener(new C2477a0(this));
        CollapsingToolbarLayout collapsingToolbarLayout = b4().f22791d;
        k.a aVar = S1.k.f32g;
        collapsingToolbarLayout.setCollapsedTitleTypeface(aVar.w());
        b4().f22787b.addOnOffsetChangedListener((AppBarLayout.OnOffsetChangedListener) new C2513m0(this, context));
        b4().f22786a0.setOnScrollChangeListener(new C2516n0(this));
        if (((Number) f4().D().getValue()).longValue() != -1) {
            Z3();
            a.C0147a aVar2 = a.f15150a;
            if (aVar2.P(context)) {
                ImageView imageView = b4().f22773O.f22872b;
                kotlin.jvm.internal.Q q5 = kotlin.jvm.internal.Q.f24695a;
                String format = String.format("%s%s", Arrays.copyOf(new Object[]{getString(com.uptodown.R.string.transition_name_logo_card), f4().D().getValue()}, 2));
                t.d(format, "format(...)");
                imageView.setTransitionName(format);
            }
            b4().f22773O.f22883m.setOnClickListener(new C2519o0(this));
            b4().f22822s0.setOnClickListener(new C2522p0(this));
            b4().f22773O.f22894x.setTypeface(aVar.w());
            b4().f22773O.f22893w.setTypeface(aVar.x());
            b4().f22773O.f22886p.setTypeface(aVar.x());
            b4().f22773O.f22892v.setTypeface(aVar.x());
            b4().f22773O.f22895y.setTypeface(aVar.x());
            b4().f22770L.f23099j.setTypeface(aVar.w());
            b4().f22770L.f23101l.setTypeface(aVar.w());
            b4().f22770L.f23102m.setTypeface(aVar.w());
            b4().f22773O.f22886p.setTypeface(aVar.w());
            b4().f22773O.f22887q.setTypeface(aVar.x());
            b4().f22773O.f22888r.setTypeface(aVar.w());
            b4().f22773O.f22889s.setTypeface(aVar.x());
            b4().f22792d0.setTypeface(aVar.x());
            b4().f22778T.f23672c.setTypeface(aVar.w());
            b4().f22778T.f23673d.setTypeface(aVar.x());
            b4().f22778T.f23671b.setTypeface(aVar.w());
            b4().f22778T.f23671b.setOnClickListener(new C2525q0(this));
            b4().f22828v0.setTypeface(aVar.x());
            b4().f22773O.f22882l.setOnClickListener(new C2530s0(this));
            b4().f22773O.f22882l.setFocusable(true);
            if (!aVar2.R(context)) {
                o6();
            }
            b4().f22773O.f22878h.setFocusable(true);
            b4().f22773O.f22878h.setOnClickListener(new C2533t0(this, context));
            b4().f22756C.f23523i.setTypeface(aVar.w());
            b4().f22756C.f23523i.setOnClickListener(new C2536u0(this, context));
            b4().f22756C.f23522h.setOnClickListener(new O(this, context));
            b4().f22756C.f23524j.setTypeface(aVar.w());
            b4().f22781W.setLayoutManager(new LinearLayoutManager(context, 0, false));
            b4().f22781W.addItemDecoration(new B2.p((int) getResources().getDimension(com.uptodown.R.dimen.margin_m)));
            b4().f22759D0.setTypeface(aVar.w());
            b4().f22761E0.setTypeface(aVar.x());
            b4().f22757C0.setTypeface(aVar.x());
            b4().f22820r0.setTypeface(aVar.w());
            b4().f22765G0.getRoot().setVisibility(8);
            b4().f22832x0.setTypeface(aVar.w());
            b4().f22832x0.setOnClickListener(new P(this));
            b4().f22790c0.setTypeface(aVar.w());
            b4().f22767I.setOnClickListener(new Q(this));
            b4().f22816p0.setTypeface(aVar.x());
            b4().f22814o0.setTypeface(aVar.w());
            b4().f22812n0.setTypeface(aVar.x());
            b4().f22810m0.setTypeface(aVar.w());
            b4().f22808l0.setTypeface(aVar.x());
            b4().f22806k0.setTypeface(aVar.w());
            b4().f22818q0.setTypeface(aVar.w());
            b4().f22829w.setOnClickListener(new S(this));
            b4().f22829w.setFocusable(true);
            b4().f22796f0.setTypeface(aVar.w());
            b4().f22817q.setOnClickListener(new T(this));
            b4().f22817q.setFocusable(true);
            b4().f22833y.f23217h.post(new U(this));
            b4().f22836z0.setTypeface(aVar.w());
            b4().f22756C.f23516b.setOnClickListener(new W(this, context));
            b4().f22756C.f23516b.setFocusable(true);
            b4().f22756C.f23517c.setOnClickListener(new X(this, context));
            b4().f22756C.f23517c.setFocusable(true);
            b4().f22756C.f23518d.setOnClickListener(new Y(this, context));
            b4().f22756C.f23518d.setFocusable(true);
            b4().f22756C.f23519e.setOnClickListener(new Z(this, context));
            b4().f22756C.f23519e.setFocusable(true);
            b4().f22756C.f23520f.setOnClickListener(new C2480b0(this, context));
            b4().f22756C.f23520f.setFocusable(true);
            b4().f22769K.setOnClickListener(new C2483c0(this));
            b4().f22830w0.setTypeface(aVar.w());
            b4().f22773O.f22890t.setTypeface(aVar.w());
            b4().f22773O.f22896z.setTypeface(aVar.x());
            b4().f22773O.f22891u.setTypeface(aVar.x());
            b4().f22773O.f22883m.setTypeface(aVar.x());
            b4().f22773O.f22884n.setTypeface(aVar.x());
            b4().f22773O.f22884n.setOnClickListener(new C2486d0(this));
            b4().f22773O.f22885o.setTypeface(aVar.x());
            b4().f22834y0.setTypeface(aVar.w());
            b4().f22822s0.setTypeface(aVar.w());
            b4().f22794e0.setTypeface(aVar.x());
            b4().f22802i0.setTypeface(aVar.x());
            b4().f22800h0.setTypeface(aVar.w());
            b4().f22798g0.setTypeface(aVar.x());
            b4().f22833y.f23224o.setTypeface(aVar.w());
            b4().f22833y.f23226q.setTypeface(aVar.w());
            b4().f22833y.f23225p.setTypeface(aVar.x());
            b4().f22824t0.setTypeface(aVar.w());
            b4().f22763F0.setTypeface(aVar.w());
            C2415h hVar = b4().f22770L;
            t.d(hVar, "rlDownloadButtonRootAppDetail");
            D2(hVar);
            h2.F f5 = b4().f22766H;
            t.d(f5, "rlBottomDownloadButtonAppDetail");
            H2(f5);
            String S4 = a4().S();
            if (S4 == null || S4.length() == 0 || !new C2954m().v(a4().S(), context)) {
                b4().f22770L.f23101l.setVisibility(8);
            } else {
                TextView textView = b4().f22770L.f23101l;
                t.d(textView, "tvOpen");
                String string = getString(com.uptodown.R.string.open);
                t.d(string, "getString(...)");
                n6(textView, string);
                b4().f22770L.f23101l.setVisibility(0);
            }
            if (((Number) f4().Q().getValue()).intValue() > -1) {
                int intValue = ((Number) f4().Q().getValue()).intValue();
                if (intValue == 0) {
                    F6(context);
                } else if (intValue == 1) {
                    v6(context);
                } else if (intValue == 2) {
                    O6(context);
                } else if (intValue == 3) {
                    B6();
                } else if (intValue == 4) {
                    J6();
                } else if (intValue == 5) {
                    x6((C2668q) null);
                }
            }
            b4().f22770L.f23093d.setOnClickListener(new C2489e0(this));
            b4().f22770L.f23095f.setOnClickListener(new C2492f0(this));
            b4().f22770L.f23094e.setOnClickListener(new C2498h0(this));
            b4().f22774P.setOnClickListener(new C2501i0(this));
            b4().f22779U.setOnClickListener(new C2504j0(this));
            b4().f22762F.setOnClickListener(new C2507k0());
            Y4();
            A5(context);
            f4().M().setValue(Boolean.FALSE);
            b4().f22783Y.setOnCheckedChangeListener(new C2510l0(this));
            c4();
            X4();
        } else if (getActivity() != null && (getActivity() instanceof MainActivity)) {
            FragmentActivity activity = getActivity();
            t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
            ((MainActivity) activity).getOnBackPressedDispatcher().onBackPressed();
        }
    }

    private final void j5() {
        if (getActivity() != null && !requireActivity().isFinishing()) {
            String string = getString(com.uptodown.R.string.dmca_title);
            t.d(string, "getString(...)");
            String string2 = getString(com.uptodown.R.string.url_dmca);
            t.d(string2, "getString(...)");
            C2962v vVar = new C2962v();
            FragmentActivity requireActivity = requireActivity();
            t.d(requireActivity, "requireActivity(...)");
            vVar.t(requireActivity, string2, string);
        }
    }

    private final void j6(String str) {
        int intValue = ((Number) f4().a0().getValue()).intValue();
        if (1 > intValue || intValue >= 6) {
            FragmentActivity activity = getActivity();
            t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            String string = getString(com.uptodown.R.string.error_review_no_valoration);
            t.d(string, "getString(...)");
            ((C1598a) activity).u0(string);
            return;
        }
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new S(this, (C2308e) null), 2, (Object) null);
        B1 f42 = f4();
        Context requireContext = requireContext();
        t.d(requireContext, "requireContext(...)");
        f42.v0(requireContext, str, ((Number) f4().a0().getValue()).intValue(), a4().e());
    }

    private final void j7() {
        b4().f22773O.f22876f.setVisibility(0);
        b4().f22773O.f22874d.setVisibility(8);
        b4().f22770L.f23097h.setVisibility(8);
        b4().f22770L.f23100k.setVisibility(8);
        b4().f22770L.f23092c.setVisibility(8);
        b4().f22770L.f23101l.setVisibility(0);
        b4().f22770L.f23102m.setVisibility(8);
        b4().f22766H.f22360q.setVisibility(8);
        b4().f22766H.f22351h.setVisibility(8);
        b4().f22766H.f22356m.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public static final void k3(C2540v1 v1Var, View view) {
        v1Var.S3();
        if (v1Var.getActivity() != null) {
            FragmentActivity activity = v1Var.getActivity();
            t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            AlertDialog p22 = ((C1598a) activity).p2();
            if (p22 != null) {
                p22.dismiss();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void k4(C2540v1 v1Var, View view) {
        if (v1Var.getActivity() == null) {
            return;
        }
        if (v1Var.getActivity() instanceof MainActivity) {
            FragmentActivity activity = v1Var.getActivity();
            t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
            ((MainActivity) activity).b7();
        } else if (v1Var.getActivity() instanceof AppDetailActivity) {
            FragmentActivity activity2 = v1Var.getActivity();
            t.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.AppDetailActivity");
            ((AppDetailActivity) activity2).finish();
        }
    }

    private final void k5(String str, Context context) {
        C2962v vVar = new C2962v();
        FragmentActivity activity = getActivity();
        t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        C2962v.u(vVar, (C1598a) activity, str, (String) null, 4, (Object) null);
        f4().q0(context, a4().e());
    }

    private final void k6() {
        if (((CharSequence) f4().c0().getValue()).length() > 0) {
            j6((String) f4().c0().getValue());
            FragmentActivity activity = getActivity();
            t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            AlertDialog p22 = ((C1598a) activity).p2();
            if (p22 != null) {
                p22.dismiss();
            }
        }
    }

    private final void k7() {
        b4().f22773O.f22876f.setVisibility(0);
        b4().f22773O.f22874d.setVisibility(8);
        b4().f22770L.f23097h.setVisibility(0);
        b4().f22770L.f23100k.setVisibility(0);
        b4().f22770L.f23092c.setVisibility(8);
        b4().f22770L.f23101l.setVisibility(8);
        b4().f22770L.f23102m.setVisibility(8);
        b4().f22766H.f22353j.setVisibility(0);
        b4().f22766H.f22360q.setVisibility(8);
        b4().f22766H.f22352i.setVisibility(8);
        b4().f22766H.f22351h.setVisibility(8);
        b4().f22766H.f22356m.setVisibility(8);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00fb  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void l3() {
        /*
            r11 = this;
            androidx.fragment.app.FragmentActivity r0 = r11.getActivity()
            java.lang.String r1 = "null cannot be cast to non-null type com.uptodown.activities.BaseActivity"
            kotlin.jvm.internal.t.c(r0, r1)
            com.uptodown.activities.a r0 = (com.uptodown.activities.C1598a) r0
            android.app.AlertDialog r0 = r0.p2()
            if (r0 == 0) goto L_0x0014
            r0.dismiss()
        L_0x0014:
            androidx.fragment.app.FragmentActivity r0 = r11.getActivity()
            if (r0 == 0) goto L_0x0185
            java.util.ArrayList r0 = r11.f24353f
            if (r0 == 0) goto L_0x0185
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0026
            goto L_0x0185
        L_0x0026:
            com.uptodown.activities.preferences.a$a r0 = com.uptodown.activities.preferences.a.f15150a
            androidx.fragment.app.FragmentActivity r1 = r11.requireActivity()
            java.lang.String r2 = "requireActivity(...)"
            kotlin.jvm.internal.t.d(r1, r2)
            boolean r1 = r0.e0(r1)
            r3 = 0
            r4 = 1
            if (r1 != 0) goto L_0x003b
        L_0x0039:
            r0 = r3
            goto L_0x0049
        L_0x003b:
            androidx.fragment.app.FragmentActivity r1 = r11.requireActivity()
            kotlin.jvm.internal.t.d(r1, r2)
            boolean r0 = r0.d0(r1)
            if (r0 == 0) goto L_0x0039
            r0 = r4
        L_0x0049:
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.lang.Integer r5 = java.lang.Integer.valueOf(r3)
            kotlin.jvm.internal.Q r6 = kotlin.jvm.internal.Q.f24695a
            r6 = 2131952127(0x7f1301ff, float:1.9540688E38)
            java.lang.String r6 = r11.getString(r6)
            java.lang.String r7 = "getString(...)"
            kotlin.jvm.internal.t.d(r6, r7)
            b2.k r8 = new b2.k
            r8.<init>()
            z2.E r9 = new z2.E
            r9.<init>()
            androidx.fragment.app.FragmentActivity r10 = r11.requireActivity()
            kotlin.jvm.internal.t.d(r10, r2)
            java.io.File r2 = r9.h(r10)
            long r9 = r2.getFreeSpace()
            java.lang.String r2 = r8.c(r9)
            java.lang.Object[] r8 = new java.lang.Object[r4]
            r8[r3] = r2
            java.lang.Object[] r2 = java.util.Arrays.copyOf(r8, r4)
            java.lang.String r2 = java.lang.String.format(r6, r2)
            java.lang.String r6 = "format(...)"
            kotlin.jvm.internal.t.d(r2, r6)
            r1.put(r5, r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r4)
            r5 = 2131952644(0x7f130404, float:1.9541737E38)
            java.lang.String r5 = r11.getString(r5)
            kotlin.jvm.internal.t.d(r5, r7)
            b2.k r7 = new b2.k
            r7.<init>()
            java.util.ArrayList r8 = r11.f24353f
            kotlin.jvm.internal.t.b(r8)
            java.lang.Object r8 = X2.C2250q.M(r8)
            Y1.g r8 = (Y1.g) r8
            long r8 = r8.a()
            java.lang.String r7 = r7.c(r8)
            java.lang.Object[] r8 = new java.lang.Object[r4]
            r8[r3] = r7
            java.lang.Object[] r3 = java.util.Arrays.copyOf(r8, r4)
            java.lang.String r3 = java.lang.String.format(r5, r3)
            kotlin.jvm.internal.t.d(r3, r6)
            r1.put(r2, r3)
            android.view.LayoutInflater r2 = r11.getLayoutInflater()
            h2.C r2 = h2.C2399C.c(r2)
            java.lang.String r3 = "inflate(...)"
            kotlin.jvm.internal.t.d(r2, r3)
            android.widget.TextView r5 = r2.f22282d
            S1.k$a r6 = S1.k.f32g
            android.graphics.Typeface r6 = r6.w()
            r5.setTypeface(r6)
            android.widget.TextView r5 = r2.f22282d
            r6 = 2131952657(0x7f130411, float:1.9541763E38)
            java.lang.String r6 = r11.getString(r6)
            r5.setText(r6)
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x00f5:
            boolean r5 = r1.hasNext()
            if (r5 == 0) goto L_0x015a
            java.lang.Object r5 = r1.next()
            java.util.Map$Entry r5 = (java.util.Map.Entry) r5
            android.view.LayoutInflater r6 = r11.getLayoutInflater()
            h2.U0 r6 = h2.U0.c(r6)
            kotlin.jvm.internal.t.d(r6, r3)
            android.widget.RadioButton r7 = r6.getRoot()
            java.lang.Object r8 = r5.getKey()
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            r7.setId(r8)
            android.widget.RadioButton r7 = r6.f22656b
            S1.k$a r8 = S1.k.f32g
            android.graphics.Typeface r8 = r8.x()
            r7.setTypeface(r8)
            android.widget.RadioButton r7 = r6.f22656b
            java.lang.Object r8 = r5.getValue()
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r7.setText(r8)
            android.widget.RadioButton r7 = r6.getRoot()
            i2.g1 r8 = new i2.g1
            r8.<init>(r11, r5)
            r7.setOnClickListener(r8)
            java.lang.Object r5 = r5.getKey()
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            if (r5 != r0) goto L_0x0150
            android.widget.RadioButton r5 = r6.f22656b
            r5.setChecked(r4)
        L_0x0150:
            android.widget.RadioGroup r5 = r2.f22280b
            android.widget.RadioButton r6 = r6.getRoot()
            r5.addView(r6)
            goto L_0x00f5
        L_0x015a:
            android.widget.TextView r0 = r2.f22281c
            S1.k$a r1 = S1.k.f32g
            android.graphics.Typeface r1 = r1.w()
            r0.setTypeface(r1)
            android.widget.TextView r0 = r2.f22281c
            i2.h1 r1 = new i2.h1
            r1.<init>(r11)
            r0.setOnClickListener(r1)
            android.app.AlertDialog$Builder r0 = new android.app.AlertDialog$Builder
            android.content.Context r1 = r11.getContext()
            r0.<init>(r1)
            android.widget.LinearLayout r1 = r2.getRoot()
            r0.setView(r1)
            r0.setCancelable(r4)
            r11.X6(r0)
        L_0x0185:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.C2540v1.l3():void");
    }

    /* access modifiers changed from: private */
    public static final void l4(C2540v1 v1Var, Context context, View view) {
        v1Var.D3(context);
    }

    private final void l5() {
        if (!requireActivity().isFinishing()) {
            Intent intent = new Intent(requireActivity(), InformationActivity.class);
            UptodownApp.a aVar = UptodownApp.f13477F;
            FragmentActivity requireActivity = requireActivity();
            t.d(requireActivity, "requireActivity(...)");
            startActivity(intent, aVar.a(requireActivity));
        }
    }

    private final void l7(Context context) {
        b4().f22788b0.setBackgroundColor(ContextCompat.getColor(context, com.uptodown.R.color.transparent));
        if (new C2962v().s(context)) {
            q6(ContextCompat.getColor(context, com.uptodown.R.color.main_blue));
            Drawable drawable = ContextCompat.getDrawable(context, com.uptodown.R.drawable.core_vector_back);
            if (drawable != null) {
                b4().f22788b0.setNavigationIcon(drawable);
            }
            Drawable drawable2 = ContextCompat.getDrawable(context, com.uptodown.R.drawable.core_vector_menu_dots_blue);
            if (drawable2 != null) {
                b4().f22788b0.setOverflowIcon(drawable2);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void m3(C2540v1 v1Var, Map.Entry entry, View view) {
        v1Var.f4().d0().setValue(entry.getKey());
    }

    /* access modifiers changed from: private */
    public static final void m4(C2540v1 v1Var, Context context, View view) {
        v1Var.D3(context);
    }

    private final void m5() {
        if (getActivity() != null && !requireActivity().isFinishing()) {
            Intent intent = new Intent(requireActivity(), LoginActivity.class);
            ActivityResultLauncher activityResultLauncher = this.f24360m;
            UptodownApp.a aVar = UptodownApp.f13477F;
            FragmentActivity requireActivity = requireActivity();
            t.d(requireActivity, "requireActivity(...)");
            activityResultLauncher.launch(intent, aVar.b(requireActivity));
        }
    }

    /* access modifiers changed from: private */
    public final void m6(TextView textView, String str) {
        textView.setText(str);
        v.a(textView);
    }

    /* access modifiers changed from: private */
    public final void m7(Context context) {
        b4().f22788b0.setBackgroundColor(ContextCompat.getColor(context, com.uptodown.R.color.transparent));
        q6(ContextCompat.getColor(context, com.uptodown.R.color.white));
        Drawable drawable = ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_arrow_left_white);
        if (drawable != null) {
            b4().f22788b0.setNavigationIcon(drawable);
        }
        Drawable drawable2 = ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_menu_dots);
        if (drawable2 != null) {
            b4().f22788b0.setOverflowIcon(drawable2);
        }
    }

    /* access modifiers changed from: private */
    public static final void n3(C2540v1 v1Var, View view) {
        boolean z4;
        if (((Number) v1Var.f4().d0().getValue()).intValue() >= 0) {
            a.C0147a aVar = a.f15150a;
            Context requireContext = v1Var.requireContext();
            t.d(requireContext, "requireContext(...)");
            if (((Number) v1Var.f4().d0().getValue()).intValue() > 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            aVar.g1(requireContext, z4);
            FragmentActivity activity = v1Var.getActivity();
            t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            AlertDialog p22 = ((C1598a) activity).p2();
            if (p22 != null) {
                p22.dismiss();
            }
            v1Var.z6();
        }
    }

    /* access modifiers changed from: private */
    public static final void n4(C2540v1 v1Var, View view) {
        v1Var.w5();
    }

    private final void n5(View view) {
        view.setOnClickListener(new Y0(this, view));
    }

    /* access modifiers changed from: private */
    public final void n6(TextView textView, String str) {
        textView.setText(str);
        v.b(textView);
    }

    /* access modifiers changed from: private */
    public final void o3(String str) {
        if (getActivity() != null && !requireActivity().isFinishing()) {
            FragmentActivity activity = getActivity();
            t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            AlertDialog p22 = ((C1598a) activity).p2();
            if (p22 != null) {
                p22.dismiss();
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            C2436s c5 = C2436s.c(getLayoutInflater());
            t.d(c5, "inflate(...)");
            TextView textView = c5.f23528d;
            k.a aVar = S1.k.f32g;
            textView.setTypeface(aVar.x());
            c5.f23528d.setText(str);
            c5.f23527c.setVisibility(8);
            c5.f23529e.setTypeface(aVar.w());
            c5.f23529e.setOnClickListener(new B0(this));
            builder.setView(c5.getRoot());
            builder.setCancelable(false);
            X6(builder);
        }
    }

    /* access modifiers changed from: private */
    public static final void o4(C2540v1 v1Var, View view) {
        v1Var.r5();
    }

    /* access modifiers changed from: private */
    public static final void o5(C2540v1 v1Var, View view, View view2) {
        if (UptodownApp.f13477F.Z()) {
            FragmentActivity activity = v1Var.getActivity();
            t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            AlertDialog p22 = ((C1598a) activity).p2();
            if (p22 != null) {
                p22.dismiss();
            }
            if (view.getContext() != null) {
                C2446x c5 = C2446x.c(v1Var.getLayoutInflater());
                t.d(c5, "inflate(...)");
                TextView textView = c5.f23667f;
                k.a aVar = S1.k.f32g;
                textView.setTypeface(aVar.w());
                c5.f23665d.setTypeface(aVar.x());
                c5.f23666e.setTypeface(aVar.w());
                c5.f23666e.setOnClickListener(new U0(v1Var));
                c5.f23663b.setOnClickListener(new V0(v1Var));
                AlertDialog.Builder builder = new AlertDialog.Builder(v1Var.requireContext());
                builder.setView(c5.getRoot());
                builder.setCancelable(true);
                v1Var.X6(builder);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void o6() {
        if (b4().f22793e.getChildCount() == 0) {
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            v6(requireContext);
            C2419j c5 = C2419j.c(getLayoutInflater());
            t.d(c5, "inflate(...)");
            c5.f23244b.setTypeface(S1.k.f32g.x());
            b4().f22793e.addView(c5.getRoot());
        }
        U2();
    }

    /* access modifiers changed from: private */
    public final void o7(l2.O o5, int i5) {
        int dimension = (int) getResources().getDimension(com.uptodown.R.dimen.margin_m);
        LinearLayout linearLayout = b4().f22831x;
        t.d(linearLayout, "llReviewListContainer");
        if (linearLayout.getChildCount() > i5) {
            b4().f22831x.removeViewAt(i5);
        }
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
        layoutParams.setMargins(0, dimension, 0, 0);
        if (o5.p()) {
            LinearLayout linearLayout2 = b4().f22831x;
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            linearLayout2.addView(S5(layoutParams, o5, requireContext), i5);
            return;
        }
        LinearLayout linearLayout3 = b4().f22831x;
        Context requireContext2 = requireContext();
        t.d(requireContext2, "requireContext(...)");
        linearLayout3.addView(K5(layoutParams, o5, requireContext2), i5);
    }

    /* access modifiers changed from: private */
    public static final void p3(C2540v1 v1Var, View view) {
        if (v1Var.getActivity() != null && !v1Var.requireActivity().isFinishing()) {
            FragmentActivity activity = v1Var.getActivity();
            t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            AlertDialog p22 = ((C1598a) activity).p2();
            if (p22 != null) {
                p22.dismiss();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void p4(C2540v1 v1Var, View view) {
        v1Var.s5();
    }

    /* access modifiers changed from: private */
    public static final void p5(C2540v1 v1Var, View view) {
        v1Var.m5();
        FragmentActivity activity = v1Var.getActivity();
        t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        AlertDialog p22 = ((C1598a) activity).p2();
        if (p22 != null) {
            p22.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public final void p6(int i5, String str) {
        Menu menu = this.f24354g;
        if (menu != null) {
            t.b(menu);
            menu.findItem(i5).setTitle(str);
        }
    }

    private final void q3() {
        z2.E e5 = new z2.E();
        Context requireContext = requireContext();
        t.d(requireContext, "requireContext(...)");
        File h5 = e5.h(requireContext);
        z2.E e6 = new z2.E();
        Context requireContext2 = requireContext();
        t.d(requireContext2, "requireContext(...)");
        long m5 = e6.m(requireContext2, h5);
        long totalSpace = h5.getTotalSpace();
        Context requireContext3 = requireContext();
        t.d(requireContext3, "requireContext(...)");
        String d5 = new C2291k().d((long) (((double) e4()) * 2.25d), requireContext3);
        long j5 = ((totalSpace - m5) * ((long) 100)) / totalSpace;
        AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
        w1 c5 = w1.c(getLayoutInflater());
        t.d(c5, "inflate(...)");
        TextView textView = c5.f23659e;
        k.a aVar = S1.k.f32g;
        textView.setTypeface(aVar.x());
        c5.f23656b.setProgress((int) j5);
        c5.f23660f.setTypeface(aVar.x());
        c5.f23660f.setText(getString(com.uptodown.R.string.no_storage_text, d5));
        c5.f23658d.setTypeface(aVar.w());
        c5.f23658d.setOnClickListener(new W0(this));
        builder.setView(c5.getRoot());
        X6(builder);
    }

    /* access modifiers changed from: private */
    public static final void q4(C2540v1 v1Var, View view) {
        v1Var.j5();
    }

    /* access modifiers changed from: private */
    public static final void q5(C2540v1 v1Var, View view) {
        FragmentActivity activity = v1Var.getActivity();
        t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        AlertDialog p22 = ((C1598a) activity).p2();
        if (p22 != null) {
            p22.dismiss();
        }
    }

    private final void q6(int i5) {
        Menu menu = this.f24354g;
        t.b(menu);
        Drawable icon = menu.findItem(com.uptodown.R.id.action_search).getIcon();
        if (icon != null) {
            DrawableCompat.setTint(icon, i5);
        }
    }

    /* access modifiers changed from: private */
    public static final void r3(C2540v1 v1Var, View view) {
        Intent intent = new Intent(v1Var.requireActivity(), FreeUpSpaceActivity.class);
        intent.putExtra("appInfo", v1Var.a4());
        UptodownApp.a aVar = UptodownApp.f13477F;
        FragmentActivity requireActivity = v1Var.requireActivity();
        t.d(requireActivity, "requireActivity(...)");
        v1Var.startActivity(intent, aVar.a(requireActivity));
    }

    /* access modifiers changed from: private */
    public static final void r4(C2540v1 v1Var) {
        v1Var.f4().n0().setValue(Integer.valueOf(v1Var.b4().f22833y.f23218i.getMeasuredWidth()));
        if (((Boolean) v1Var.f4().z().getValue()).booleanValue()) {
            v1Var.t7();
        }
    }

    private final void r5() {
        if (!requireActivity().isFinishing()) {
            Intent intent = new Intent(requireActivity(), MoreInfo.class);
            intent.putExtra("appInfo", a4());
            UptodownApp.a aVar = UptodownApp.f13477F;
            FragmentActivity requireActivity = requireActivity();
            t.d(requireActivity, "requireActivity(...)");
            startActivity(intent, aVar.a(requireActivity));
        }
    }

    /* access modifiers changed from: private */
    public final void r6() {
        b4().f22773O.f22896z.setVisibility(8);
        b4().f22773O.f22875e.setVisibility(8);
        String string = getString(com.uptodown.R.string.download_not_available_in_this_country);
        t.d(string, "getString(...)");
        s6(string);
        h4(com.uptodown.R.id.action_antivirus_report);
    }

    private final void r7(int i5, Context context) {
        String str;
        l2.V h5 = l2.V.f24870q.h(context);
        if (h5 != null) {
            str = h5.j();
        } else {
            str = null;
        }
        if (str != null) {
            String j5 = h5.j();
            t.b(j5);
            if (j5.length() > 0) {
                f4().a0().setValue(Integer.valueOf(i5));
                if (i5 == 1) {
                    b4().f22756C.f23516b.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
                    b4().f22756C.f23517c.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
                    b4().f22756C.f23518d.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
                    b4().f22756C.f23519e.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
                    b4().f22756C.f23520f.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
                } else if (i5 == 2) {
                    b4().f22756C.f23516b.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
                    b4().f22756C.f23517c.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
                    b4().f22756C.f23518d.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
                    b4().f22756C.f23519e.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
                    b4().f22756C.f23520f.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
                } else if (i5 == 3) {
                    b4().f22756C.f23516b.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
                    b4().f22756C.f23517c.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
                    b4().f22756C.f23518d.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
                    b4().f22756C.f23519e.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
                    b4().f22756C.f23520f.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
                } else if (i5 == 4) {
                    b4().f22756C.f23516b.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
                    b4().f22756C.f23517c.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
                    b4().f22756C.f23518d.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
                    b4().f22756C.f23519e.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
                    b4().f22756C.f23520f.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
                } else if (i5 != 5) {
                    b4().f22756C.f23516b.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
                    b4().f22756C.f23517c.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
                    b4().f22756C.f23518d.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
                    b4().f22756C.f23519e.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
                    b4().f22756C.f23520f.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_off));
                } else {
                    b4().f22756C.f23516b.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
                    b4().f22756C.f23517c.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
                    b4().f22756C.f23518d.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
                    b4().f22756C.f23519e.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
                    b4().f22756C.f23520f.setImageDrawable(ContextCompat.getDrawable(context, com.uptodown.R.drawable.vector_star_on));
                }
            }
        }
    }

    private final void s3() {
        String y02;
        if (getActivity() != null && !requireActivity().isFinishing() && (y02 = a4().y0()) != null && y02.length() != 0) {
            FragmentActivity activity = getActivity();
            t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            AlertDialog p22 = ((C1598a) activity).p2();
            if (p22 != null) {
                p22.dismiss();
            }
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            C2436s c5 = C2436s.c(getLayoutInflater());
            t.d(c5, "inflate(...)");
            TextView textView = c5.f23528d;
            k.a aVar = S1.k.f32g;
            textView.setTypeface(aVar.x());
            c5.f23528d.setText(getString(com.uptodown.R.string.go_to_web_dialog_message));
            c5.f23527c.setTypeface(aVar.w());
            c5.f23527c.setOnClickListener(new K0(this));
            c5.f23529e.setTypeface(aVar.w());
            c5.f23529e.setText(getString(com.uptodown.R.string.open_web));
            c5.f23529e.setOnClickListener(new L0(this));
            builder.setView(c5.getRoot());
            builder.setCancelable(true);
            X6(builder);
        }
    }

    /* access modifiers changed from: private */
    public static final void s4(C2540v1 v1Var, Context context, View view) {
        v1Var.f4().a0().setValue(1);
        v1Var.D3(context);
    }

    private final void s5() {
        if (!requireActivity().isFinishing() && a4().J0()) {
            Intent intent = new Intent(requireActivity(), OldVersionsActivity.class);
            intent.putExtra("appInfo", a4());
            UptodownApp.a aVar = UptodownApp.f13477F;
            FragmentActivity requireActivity = requireActivity();
            t.d(requireActivity, "requireActivity(...)");
            startActivity(intent, aVar.a(requireActivity));
        }
    }

    /* access modifiers changed from: private */
    public final void s6(String str) {
        g7();
        f4().Q().setValue(-1);
        b4().f22770L.f23094e.setVisibility(8);
        b4().f22773O.f22874d.setVisibility(8);
        b4().f22770L.f23099j.setText(str);
        b4().f22766H.f22354k.setText(str);
        b4().f22766H.f22360q.setOnClickListener((View.OnClickListener) null);
        b4().f22766H.f22350g.setOnClickListener(new C2574y0(this));
        b4().f22770L.f23096g.setOnClickListener(new C2577z0(this));
    }

    /* access modifiers changed from: private */
    public static final void s7(C2540v1 v1Var, ActivityResult activityResult) {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(v1Var), C2865c0.b(), (w3.O) null, new a0(v1Var, new b0(v1Var), (C2308e) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void t3(C2540v1 v1Var, View view) {
        if (v1Var.getActivity() != null && !v1Var.requireActivity().isFinishing()) {
            FragmentActivity activity = v1Var.getActivity();
            t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            AlertDialog p22 = ((C1598a) activity).p2();
            if (p22 != null) {
                p22.dismiss();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void t4(C2540v1 v1Var, Context context, View view) {
        v1Var.f4().a0().setValue(2);
        v1Var.D3(context);
    }

    private final void t5() {
        if (!requireActivity().isFinishing()) {
            Intent intent = new Intent(requireActivity(), OrganizationActivity.class);
            intent.putExtra("organizationID", a4().R());
            intent.putExtra("organizationName", a4().g());
            UptodownApp.a aVar = UptodownApp.f13477F;
            FragmentActivity requireActivity = requireActivity();
            t.d(requireActivity, "requireActivity(...)");
            startActivity(intent, aVar.a(requireActivity));
        }
    }

    /* access modifiers changed from: private */
    public static final void t6(C2540v1 v1Var, View view) {
        v1Var.s3();
    }

    private final void t7() {
        try {
            if (a4().b0() <= 0 || ((Number) f4().n0().getValue()).intValue() <= 0) {
                b4().f22833y.getRoot().setVisibility(8);
                b4().f22833y.f23226q.setVisibility(8);
                return;
            }
            int dimension = (int) getResources().getDimension(com.uptodown.R.dimen.margin_m);
            b4().f22833y.f23217h.setLayoutParams(new RelativeLayout.LayoutParams((((Number) f4().n0().getValue()).intValue() * a4().g0()) / a4().b0(), dimension));
            b4().f22833y.f23216g.setLayoutParams(new RelativeLayout.LayoutParams((((Number) f4().n0().getValue()).intValue() * a4().f0()) / a4().b0(), dimension));
            b4().f22833y.f23215f.setLayoutParams(new RelativeLayout.LayoutParams((((Number) f4().n0().getValue()).intValue() * a4().e0()) / a4().b0(), dimension));
            b4().f22833y.f23214e.setLayoutParams(new RelativeLayout.LayoutParams((((Number) f4().n0().getValue()).intValue() * a4().d0()) / a4().b0(), dimension));
            b4().f22833y.f23213d.setLayoutParams(new RelativeLayout.LayoutParams((((Number) f4().n0().getValue()).intValue() * a4().c0()) / a4().b0(), dimension));
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public static final void u3(C2540v1 v1Var, View view) {
        if (v1Var.getActivity() != null && !v1Var.requireActivity().isFinishing()) {
            FragmentActivity activity = v1Var.getActivity();
            t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            AlertDialog p22 = ((C1598a) activity).p2();
            if (p22 != null) {
                p22.dismiss();
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(v1Var.a4().y0()));
            v1Var.startActivity(intent);
        }
    }

    /* access modifiers changed from: private */
    public static final void u4(C2540v1 v1Var, Context context, View view) {
        v1Var.f4().a0().setValue(3);
        v1Var.D3(context);
    }

    /* access modifiers changed from: private */
    public final void u5(long j5) {
        if (getActivity() != null && (getActivity() instanceof MainActivity)) {
            FragmentActivity activity = getActivity();
            t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
            ((MainActivity) activity).H2(j5);
        } else if (getActivity() != null && (getActivity() instanceof AppDetailActivity)) {
            FragmentActivity activity2 = getActivity();
            t.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.AppDetailActivity");
            ((AppDetailActivity) activity2).H2(j5);
        }
    }

    /* access modifiers changed from: private */
    public static final void u6(C2540v1 v1Var, View view) {
        v1Var.s3();
    }

    private final void u7() {
        C2277I i5 = new C2277I();
        Context requireContext = requireContext();
        t.d(requireContext, "requireContext(...)");
        ArrayList c5 = i5.c(requireContext);
        this.f24353f = c5;
        t.b(c5);
        if (c5.size() > 0) {
            f4().d0().setValue(0);
            l3();
            return;
        }
        a.C0147a aVar = a.f15150a;
        Context requireContext2 = requireContext();
        t.d(requireContext2, "requireContext(...)");
        aVar.g1(requireContext2, false);
        z6();
    }

    /* access modifiers changed from: private */
    public final void v3() {
        FragmentActivity activity = getActivity();
        t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        AlertDialog p22 = ((C1598a) activity).p2();
        if (p22 != null) {
            p22.dismiss();
        }
        if (getContext() != null) {
            C2431p c5 = C2431p.c(getLayoutInflater());
            t.d(c5, "inflate(...)");
            TextView textView = c5.f23424d;
            k.a aVar = S1.k.f32g;
            textView.setTypeface(aVar.w());
            c5.f23423c.setTypeface(aVar.x());
            TextView textView2 = c5.f23423c;
            C2962v vVar = new C2962v();
            String string = getString(com.uptodown.R.string.pre_register_success, a4().N());
            t.d(string, "getString(...)");
            String N4 = a4().N();
            t.b(N4);
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            textView2.setText(vVar.d(string, N4, requireContext));
            c5.f23422b.setTypeface(aVar.w());
            c5.f23422b.setOnClickListener(new C2512m(this));
            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            builder.setView(c5.getRoot());
            builder.setCancelable(true);
            X6(builder);
        }
    }

    /* access modifiers changed from: private */
    public static final boolean v4(C2540v1 v1Var, MenuItem menuItem) {
        FragmentActivity activity;
        t.e(menuItem, "item");
        if (!UptodownApp.f13477F.Z()) {
            return true;
        }
        if (menuItem.getItemId() == com.uptodown.R.id.action_search) {
            v1Var.x5();
            return true;
        } else if (menuItem.getItemId() == com.uptodown.R.id.action_share) {
            v1Var.T6();
            return true;
        } else if (menuItem.getItemId() == com.uptodown.R.id.action_antivirus_report) {
            v1Var.z5();
            return true;
        } else if (menuItem.getItemId() == com.uptodown.R.id.action_uninstall) {
            String S4 = v1Var.a4().S();
            if (S4 == null || S4.length() == 0 || (activity = v1Var.getActivity()) == null) {
                return true;
            }
            j jVar = new j(activity);
            String S5 = v1Var.a4().S();
            t.b(S5);
            jVar.h(S5);
            return true;
        } else if (menuItem.getItemId() == com.uptodown.R.id.action_wishlist) {
            v1Var.z2();
            return true;
        } else if (menuItem.getItemId() == com.uptodown.R.id.action_recommended) {
            v1Var.y2();
            return true;
        } else if (menuItem.getItemId() == com.uptodown.R.id.action_exclude) {
            v1Var.x2();
            return true;
        } else if (menuItem.getItemId() == com.uptodown.R.id.action_app_details_settings) {
            v1Var.g5();
            return true;
        } else if (menuItem.getItemId() == com.uptodown.R.id.action_app_installed_details) {
            v1Var.h5();
            return true;
        } else if (menuItem.getItemId() != com.uptodown.R.id.action_remote_install) {
            return false;
        } else {
            if (!(v1Var.f4().l0().getValue() instanceof O.c)) {
                return true;
            }
            Object value = v1Var.f4().l0().getValue();
            t.c(value, "null cannot be cast to non-null type com.uptodown.util.Result.Success<java.util.ArrayList<com.uptodown.models.UserRemoteDevice>>");
            v1Var.a7((ArrayList) ((O.c) value).a());
            return true;
        }
    }

    /* access modifiers changed from: private */
    public final void v5(C2657f fVar) {
        if (getActivity() != null && (getActivity() instanceof MainActivity)) {
            FragmentActivity activity = getActivity();
            t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
            ((MainActivity) activity).H2(fVar.e());
        } else if (getActivity() != null && (getActivity() instanceof AppDetailActivity)) {
            FragmentActivity activity2 = getActivity();
            t.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.AppDetailActivity");
            ((AppDetailActivity) activity2).H2(fVar.e());
        }
    }

    /* access modifiers changed from: private */
    public final void v6(Context context) {
        String str;
        h7();
        c cVar = c.f17333a;
        ProgressBar progressBar = b4().f22773O.f22879i;
        t.d(progressBar, "pbProgressAppDetail");
        ImageView imageView = b4().f22773O.f22872b;
        t.d(imageView, "ivLogoAppDetail");
        cVar.c(progressBar, imageView);
        f4().Q().setValue(-1);
        if (new C2201a(context).n()) {
            str = context.getString(com.uptodown.R.string.option_button_install);
        } else {
            String V4 = a4().V();
            if (V4 == null || V4.length() == 0) {
                str = context.getString(com.uptodown.R.string.option_button_install);
            } else {
                String x02 = a4().x0("try");
                if (x02 == null || x02.length() == 0) {
                    str = context.getString(com.uptodown.R.string.option_button_install);
                } else {
                    str = x02;
                }
            }
        }
        if (!((Boolean) f4().f0().getValue()).booleanValue() || !a4().J0()) {
            b4().f22770L.f23092c.setVisibility(8);
        } else {
            b4().f22770L.f23092c.setVisibility(0);
        }
        b4().f22770L.f23101l.setVisibility(8);
        b4().f22773O.f22876f.setVisibility(0);
        b4().f22773O.f22874d.setVisibility(8);
        TextView textView = b4().f22770L.f23100k;
        t.d(textView, "tvDownloadCancel");
        m6(textView, str);
        b4().f22770L.f23100k.setOnClickListener(new A0(this));
        b4().f22766H.f22345b.setVisibility(4);
        TextView textView2 = b4().f22766H.f22360q;
        t.d(textView2, "tvStatusDownload");
        m6(textView2, str);
        if (f4().R().getValue() == null) {
            h4(com.uptodown.R.id.action_uninstall);
            h4(com.uptodown.R.id.action_app_installed_details);
        }
    }

    private final void v7() {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new c0(this, (C2308e) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void w3(C2540v1 v1Var, View view) {
        FragmentActivity activity = v1Var.getActivity();
        t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        AlertDialog p22 = ((C1598a) activity).p2();
        if (p22 != null) {
            p22.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final void w4(C2540v1 v1Var, Context context, View view) {
        v1Var.f4().a0().setValue(4);
        v1Var.D3(context);
    }

    private final void w5() {
        if (!requireActivity().isFinishing()) {
            Intent intent = new Intent(requireActivity(), ReviewsActivity.class);
            intent.putExtra("appInfo", a4());
            intent.putExtra("myReview", (Parcelable) f4().S().getValue());
            UptodownApp.a aVar = UptodownApp.f13477F;
            FragmentActivity requireActivity = requireActivity();
            t.d(requireActivity, "requireActivity(...)");
            startActivity(intent, aVar.a(requireActivity));
        }
    }

    /* access modifiers changed from: private */
    public static final void w6(C2540v1 v1Var, View view) {
        Context requireContext = v1Var.requireContext();
        t.d(requireContext, "requireContext(...)");
        v1Var.P3(requireContext);
    }

    private final void x2() {
        String S4 = a4().S();
        if (S4 != null && S4.length() != 0 && getContext() != null) {
            C2940B.a aVar = C2940B.f26458v;
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            C2940B a5 = aVar.a(requireContext);
            a5.a();
            String S5 = a4().S();
            t.b(S5);
            C2655d Y4 = a5.Y(S5);
            if (Y4 != null) {
                if (Y4.e() == 0) {
                    Y4.N(1);
                    C2655d.c w4 = Y4.w();
                    C2655d.c cVar = C2655d.c.UPDATED;
                    if (w4 != cVar) {
                        Y4.c0(cVar);
                        String o5 = Y4.o();
                        t.b(o5);
                        a5.R(o5);
                        z2.E e5 = new z2.E();
                        Context requireContext2 = requireContext();
                        t.d(requireContext2, "requireContext(...)");
                        e5.c(requireContext2);
                    }
                } else {
                    Y4.N(0);
                }
                a5.y1(Y4);
                f4().R().setValue(Y4);
                C2954m mVar = new C2954m();
                Context requireContext3 = requireContext();
                t.d(requireContext3, "requireContext(...)");
                mVar.D(requireContext3);
            }
            a5.m();
            W3();
        }
    }

    /* access modifiers changed from: private */
    public static final void x4(C2540v1 v1Var, Context context, View view) {
        v1Var.f4().a0().setValue(5);
        v1Var.D3(context);
    }

    private final void x5() {
        Intent intent = new Intent(getContext(), SearchActivity.class);
        intent.setFlags(603979776);
        UptodownApp.a aVar = UptodownApp.f13477F;
        FragmentActivity requireActivity = requireActivity();
        t.d(requireActivity, "requireActivity(...)");
        startActivity(intent, aVar.a(requireActivity));
    }

    /* access modifiers changed from: private */
    public final void x6(C2668q qVar) {
        i7();
        c cVar = c.f17333a;
        ProgressBar progressBar = b4().f22773O.f22879i;
        t.d(progressBar, "pbProgressAppDetail");
        ImageView imageView = b4().f22773O.f22872b;
        t.d(imageView, "ivLogoAppDetail");
        cVar.e(progressBar, imageView);
        TextView textView = b4().f22770L.f23100k;
        t.d(textView, "tvDownloadCancel");
        String string = getString(com.uptodown.R.string.option_button_cancel);
        t.d(string, "getString(...)");
        n6(textView, string);
        b4().f22770L.f23101l.setVisibility(8);
        b4().f22766H.f22347d.setVisibility(8);
        f4().Q().setValue(5);
        if (qVar == null && getContext() != null) {
            C2940B.a aVar = C2940B.f26458v;
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            C2940B a5 = aVar.a(requireContext);
            a5.a();
            String S4 = a4().S();
            t.b(S4);
            C2668q k02 = a5.k0(S4, a4().A0());
            a5.m();
            qVar = k02;
        }
        if (qVar != null) {
            b4().f22770L.f23100k.setOnClickListener(new D0(this));
            b4().f22766H.f22345b.setVisibility(0);
            if (!S4(this, (l2.T) null, 1, (Object) null)) {
                b4().f22773O.f22892v.setText(getString(com.uptodown.R.string.status_download_update_pending));
                b4().f22773O.f22879i.setIndeterminate(true);
                b4().f22766H.f22349f.setIndeterminate(true);
                b4().f22766H.f22355l.setVisibility(0);
                b4().f22766H.f22357n.setVisibility(8);
            } else {
                TextView textView2 = b4().f22770L.f23102m;
                t.d(textView2, "tvPause");
                String string2 = getString(com.uptodown.R.string.action_pause);
                t.d(string2, "getString(...)");
                n6(textView2, string2);
                String valueOf = String.valueOf(qVar.x());
                if (isAdded() && getContext() != null) {
                    valueOf = valueOf + requireContext().getString(com.uptodown.R.string.percent);
                }
                b4().f22773O.f22879i.setIndeterminate(false);
                b4().f22773O.f22879i.setProgress(qVar.x());
                if (qVar.z() > 0) {
                    TextView textView3 = b4().f22773O.f22892v;
                    Integer valueOf2 = Integer.valueOf(qVar.x());
                    C2291k kVar = new C2291k();
                    long z4 = qVar.z();
                    Context requireContext2 = requireContext();
                    t.d(requireContext2, "requireContext(...)");
                    textView3.setText(getString(com.uptodown.R.string.percent_of_total_size, valueOf2, kVar.d(z4, requireContext2)));
                }
                b4().f22766H.f22349f.setIndeterminate(false);
                b4().f22766H.f22357n.setVisibility(0);
                b4().f22766H.f22355l.setVisibility(8);
                b4().f22766H.f22357n.setText(valueOf);
                TextView textView4 = b4().f22766H.f22358o;
                C2291k kVar2 = new C2291k();
                long y4 = qVar.y();
                Context requireContext3 = requireContext();
                t.d(requireContext3, "requireContext(...)");
                textView4.setText(kVar2.d(y4, requireContext3));
                b4().f22766H.f22349f.setProgress(qVar.x());
            }
            TextView textView5 = b4().f22766H.f22359p;
            kotlin.jvm.internal.Q q5 = kotlin.jvm.internal.Q.f24695a;
            C2291k kVar3 = new C2291k();
            long z5 = qVar.z();
            Context requireContext4 = requireContext();
            t.d(requireContext4, "requireContext(...)");
            String format = String.format("/%s", Arrays.copyOf(new Object[]{kVar3.d(z5, requireContext4)}, 1));
            t.d(format, "format(...)");
            textView5.setText(format);
            return;
        }
        b4().f22773O.f22879i.setIndeterminate(true);
        b4().f22766H.f22349f.setIndeterminate(true);
    }

    private final void y2() {
        if (getContext() != null) {
            V.b bVar = l2.V.f24870q;
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            if (bVar.h(requireContext) == null) {
                m5();
            } else if (a4().i0() == 1) {
                B1 f42 = f4();
                Context requireContext2 = requireContext();
                t.d(requireContext2, "requireContext(...)");
                f42.t0(requireContext2, a4().e());
            } else {
                B1 f43 = f4();
                Context requireContext3 = requireContext();
                t.d(requireContext3, "requireContext(...)");
                f43.s0(requireContext3, a4().e());
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void y3(C2540v1 v1Var, View view) {
        FragmentActivity activity = v1Var.getActivity();
        t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        ((C1598a) activity).o2();
    }

    /* access modifiers changed from: private */
    public static final void y4(C2540v1 v1Var, View view) {
        v1Var.w5();
    }

    private final void y5(l2.O o5) {
        if (UptodownApp.f13477F.Z()) {
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            C2391m mVar = new C2391m(requireContext, LifecycleOwnerKt.getLifecycleScope(this));
            String m5 = o5.m();
            t.b(m5);
            mVar.c(m5, new E(this));
        }
    }

    /* access modifiers changed from: private */
    public static final void y6(C2540v1 v1Var, View view) {
        v1Var.e3();
    }

    private final void z2() {
        if (getContext() != null) {
            V.b bVar = l2.V.f24870q;
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            if (bVar.h(requireContext) == null) {
                m5();
            } else if (a4().F0() == 1) {
                B1 f42 = f4();
                Context requireContext2 = requireContext();
                t.d(requireContext2, "requireContext(...)");
                f42.B0(requireContext2, a4().e());
            } else {
                B1 f43 = f4();
                Context requireContext3 = requireContext();
                t.d(requireContext3, "requireContext(...)");
                f43.A0(requireContext3, a4().e());
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void z3(C2540v1 v1Var, View view) {
        Context requireContext = v1Var.requireContext();
        t.d(requireContext, "requireContext(...)");
        v1Var.M2(requireContext);
        Context requireContext2 = v1Var.requireContext();
        t.d(requireContext2, "requireContext(...)");
        v1Var.P3(requireContext2);
        FragmentActivity activity = v1Var.getActivity();
        t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
        ((C1598a) activity).o2();
    }

    /* access modifiers changed from: private */
    public static final void z4(C2540v1 v1Var, View view) {
        v1Var.l5();
    }

    private final void z5() {
        if (getActivity() != null && !requireActivity().isFinishing()) {
            f4().m0().setValue(Boolean.TRUE);
            FragmentActivity requireActivity = requireActivity();
            t.d(requireActivity, "requireActivity(...)");
            new C2392n(requireActivity, String.valueOf(a4().A()), a4().n0(), new F(this), LifecycleOwnerKt.getLifecycleScope(this));
        }
    }

    private final void z6() {
        x6((C2668q) null);
        f4().Q().setValue(5);
        long e42 = e4();
        z2.E e5 = new z2.E();
        Context requireContext = requireContext();
        t.d(requireContext, "requireContext(...)");
        File h5 = e5.h(requireContext);
        if (!h5.exists() && !h5.mkdirs()) {
            String string = getString(com.uptodown.R.string.error_cant_create_dir);
            t.d(string, "getString(...)");
            o3(string);
        } else if (!g4()) {
            Context requireContext2 = requireContext();
            t.d(requireContext2, "requireContext(...)");
            D6(requireContext2, (C2668q) null);
            q3();
        } else {
            C2962v vVar = new C2962v();
            b4().f22773O.f22892v.setVisibility(0);
            b4().f22773O.f22892v.setText(getString(com.uptodown.R.string.status_download_update_pending));
            b4().f22773O.f22879i.setProgress(0);
            b4().f22766H.f22355l.setVisibility(0);
            b4().f22766H.f22357n.setVisibility(8);
            b4().f22766H.f22358o.setText(com.uptodown.R.string.zero_mb);
            TextView textView = b4().f22766H.f22359p;
            kotlin.jvm.internal.Q q5 = kotlin.jvm.internal.Q.f24695a;
            C2291k kVar = new C2291k();
            Context requireContext3 = requireContext();
            t.d(requireContext3, "requireContext(...)");
            String format = String.format("/%s", Arrays.copyOf(new Object[]{kVar.d(e42, requireContext3), requireContext()}, 2));
            t.d(format, "format(...)");
            textView.setText(format);
            b4().f22766H.f22349f.setProgress(0);
            AlertDialog alertDialog = this.f24352e;
            FragmentActivity requireActivity = requireActivity();
            t.d(requireActivity, "requireActivity(...)");
            AlertDialog e6 = vVar.e(alertDialog, requireActivity);
            this.f24352e = e6;
            if (e6 == null) {
                f6();
                x6((C2668q) null);
            }
        }
    }

    public final void T2(Context context) {
        t.e(context, "context");
        f7(context);
    }

    public final C2657f a4() {
        C2657f fVar = this.f24348a;
        if (fVar != null) {
            return fVar;
        }
        t.w("appInfo");
        return null;
    }

    public final void h6() {
        c4();
    }

    public final void l6(C2657f fVar) {
        t.e(fVar, "<set-?>");
        this.f24348a = fVar;
    }

    public final void n7(String str) {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new Y(str, this, (C2308e) null), 2, (Object) null);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00c1  */
    /* JADX WARNING: Removed duplicated region for block: B:30:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onCreate(android.os.Bundle r8) {
        /*
            r7 = this;
            super.onCreate(r8)
            i2.B1 r8 = r7.f4()
            z3.w r8 = r8.z()
            java.lang.Boolean r0 = java.lang.Boolean.FALSE
            r8.setValue(r0)
            z2.F r8 = new z2.F
            androidx.fragment.app.FragmentActivity r0 = r7.requireActivity()
            r8.<init>(r0)
            r7.f24351d = r8
            com.uptodown.UptodownApp$a r8 = com.uptodown.UptodownApp.f13477F
            H1.e r0 = r8.k()
            if (r0 == 0) goto L_0x0026
            r0.pause()
        L_0x0026:
            H1.e r8 = r8.l()
            if (r8 == 0) goto L_0x002f
            r8.pause()
        L_0x002f:
            android.os.Bundle r8 = r7.getArguments()
            r0 = 0
            if (r8 == 0) goto L_0x0069
            i2.B1 r1 = r7.f4()
            z3.w r1 = r1.D()
            java.lang.String r2 = "appId"
            long r2 = r8.getLong(r2)
            java.lang.Long r2 = java.lang.Long.valueOf(r2)
            r1.setValue(r2)
            java.lang.String r1 = "appInfo"
            boolean r2 = r8.containsKey(r1)
            if (r2 == 0) goto L_0x0069
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 33
            if (r2 < r3) goto L_0x0062
            java.lang.Class<l2.f> r2 = l2.C2657f.class
            java.lang.Object r8 = r8.getParcelable(r1, r2)
            android.os.Parcelable r8 = (android.os.Parcelable) r8
            goto L_0x0066
        L_0x0062:
            android.os.Parcelable r8 = r8.getParcelable(r1)
        L_0x0066:
            l2.f r8 = (l2.C2657f) r8
            goto L_0x006a
        L_0x0069:
            r8 = r0
        L_0x006a:
            if (r8 == 0) goto L_0x0084
            r7.l6(r8)
            i2.B1 r8 = r7.f4()
            android.content.Context r1 = r7.requireContext()
            java.lang.String r2 = "requireContext(...)"
            kotlin.jvm.internal.t.d(r1, r2)
            l2.f r2 = r7.a4()
            r8.w(r1, r2)
            goto L_0x00b7
        L_0x0084:
            androidx.fragment.app.FragmentActivity r8 = r7.getActivity()
            if (r8 == 0) goto L_0x00b7
            androidx.fragment.app.FragmentActivity r8 = r7.getActivity()
            boolean r8 = r8 instanceof com.uptodown.activities.MainActivity
            if (r8 == 0) goto L_0x00a1
            androidx.fragment.app.FragmentActivity r8 = r7.getActivity()
            java.lang.String r1 = "null cannot be cast to non-null type com.uptodown.activities.MainActivity"
            kotlin.jvm.internal.t.c(r8, r1)
            com.uptodown.activities.MainActivity r8 = (com.uptodown.activities.MainActivity) r8
            r8.b7()
            goto L_0x00b7
        L_0x00a1:
            androidx.fragment.app.FragmentActivity r8 = r7.getActivity()
            boolean r8 = r8 instanceof com.uptodown.activities.AppDetailActivity
            if (r8 == 0) goto L_0x00b7
            androidx.fragment.app.FragmentActivity r8 = r7.getActivity()
            java.lang.String r1 = "null cannot be cast to non-null type com.uptodown.activities.AppDetailActivity"
            kotlin.jvm.internal.t.c(r8, r1)
            com.uptodown.activities.AppDetailActivity r8 = (com.uptodown.activities.AppDetailActivity) r8
            r8.finish()
        L_0x00b7:
            l2.f r8 = r7.a4()
            boolean r8 = r8.M0()
            if (r8 == 0) goto L_0x00d4
            androidx.lifecycle.LifecycleCoroutineScope r1 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r7)
            w3.I0 r2 = w3.C2865c0.c()
            i2.v1$w r4 = new i2.v1$w
            r4.<init>(r7, r0)
            r5 = 2
            r6 = 0
            r3 = 0
            w3.C2908y0 unused = w3.C2876i.d(r1, r2, r3, r4, r5, r6)
        L_0x00d4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.C2540v1.onCreate(android.os.Bundle):void");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        t.e(layoutInflater, "inflater");
        if (getActivity() == null) {
            return super.onCreateView(layoutInflater, viewGroup, bundle);
        }
        this.f24349b = C2403b.c(layoutInflater, viewGroup, false);
        FragmentActivity requireActivity = requireActivity();
        t.d(requireActivity, "requireActivity(...)");
        j4(requireActivity);
        return b4().getRoot();
    }

    public void onDestroy() {
        try {
            MBBannerView mBBannerView = b4().f22758D;
            t.d(mBBannerView, "mbBannerView");
            mBBannerView.release();
        } catch (Exception unused) {
        }
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        f4().K().setValue(Boolean.valueOf(!((Boolean) f4().K().getValue()).booleanValue()));
        MBBannerView mBBannerView = b4().f22758D;
        t.d(mBBannerView, "mbBannerView");
        mBBannerView.onPause();
    }

    public void onResume() {
        String o5;
        super.onResume();
        z2.F f5 = this.f24351d;
        if (f5 != null) {
            f5.f("AppDetailsFragment");
        }
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new C2564x(this, (C2308e) null), 2, (Object) null);
        C2908y0 unused2 = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new C2565y(this, (C2308e) null), 2, (Object) null);
        C2908y0 unused3 = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new C2566z(this, (C2308e) null), 2, (Object) null);
        C2908y0 unused4 = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new A(this, (C2308e) null), 2, (Object) null);
        C2908y0 unused5 = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new B(this, (C2308e) null), 2, (Object) null);
        C2908y0 unused6 = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new C(this, (C2308e) null), 2, (Object) null);
        if (!((Boolean) f4().O().getValue()).booleanValue()) {
            Rect rect = new Rect();
            b4().f22786a0.getHitRect(rect);
            W6(rect);
        }
        if (((Boolean) f4().O().getValue()).booleanValue() || (o5 = a4().o()) == null || o5.length() == 0) {
            f4().O().setValue(Boolean.FALSE);
        } else {
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            f7(requireContext);
        }
        String q02 = a4().q0();
        int i5 = 0;
        if (q02 == null || q02.length() == 0 || g4()) {
            b4().f22765G0.getRoot().setVisibility(8);
        } else {
            b4().f22765G0.getRoot().setVisibility(0);
        }
        W3();
        if (b4().f22786a0.getScrollY() > 0) {
            Context requireContext2 = requireContext();
            t.d(requireContext2, "requireContext(...)");
            l7(requireContext2);
            String z4 = a4().z();
            if (z4 == null || z4.length() == 0) {
                b4().f22791d.setTitle("");
            }
        }
        R1.K k5 = this.f24355h;
        if (k5 != null) {
            k5.notifyDataSetChanged();
        }
        R1.K k6 = this.f24356i;
        if (k6 != null) {
            k6.notifyDataSetChanged();
        }
        ArrayList arrayList = this.f24357j;
        int size = arrayList.size();
        while (i5 < size) {
            Object obj = arrayList.get(i5);
            i5++;
            ((R1.K) obj).notifyDataSetChanged();
        }
        C2908y0 unused7 = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new D(this, (C2308e) null), 2, (Object) null);
        d5();
        MBBannerView mBBannerView = b4().f22758D;
        t.d(mBBannerView, "mbBannerView");
        mBBannerView.onResume();
    }

    public final void p7(String str) {
        t.e(str, "packagename");
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new Z(str, this, (C2308e) null), 2, (Object) null);
    }

    public final void q7(String str) {
        t.e(str, "packagename");
        if (getContext() != null && a4().S() != null && t3.s.E(a4().S(), str, true)) {
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            f7(requireContext);
            if (getActivity() != null && !requireActivity().isFinishing() && (getActivity() instanceof C1598a)) {
                FragmentActivity activity = getActivity();
                t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                String string = getString(com.uptodown.R.string.install_compatibility_error, a4().N());
                t.d(string, "getString(...)");
                ((C1598a) activity).u0(string);
            }
        }
    }

    public final void x3() {
        if (getActivity() != null && !requireActivity().isFinishing()) {
            FragmentActivity activity = getActivity();
            t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            ((C1598a) activity).o2();
            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            C2448y c5 = C2448y.c(getLayoutInflater());
            t.d(c5, "inflate(...)");
            TextView textView = c5.f23678d;
            k.a aVar = S1.k.f32g;
            textView.setTypeface(aVar.x());
            c5.f23678d.setText(getString(com.uptodown.R.string.recent_version_available, a4().N()));
            c5.f23677c.setTypeface(aVar.w());
            c5.f23677c.setOnClickListener(new X0(this));
            c5.f23676b.setTypeface(aVar.w());
            c5.f23676b.setOnClickListener(new Z0(this));
            builder.setView(c5.getRoot());
            builder.setCancelable(false);
            FragmentActivity activity2 = getActivity();
            t.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            ((C1598a) activity2).P2(builder.create());
            FragmentActivity activity3 = getActivity();
            t.c(activity3, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            ((C1598a) activity3).b3();
        }
    }

    /* renamed from: i2.v1$E */
    public static final class E implements k2.N {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24374a;

        E(C2540v1 v1Var) {
            this.f24374a = v1Var;
        }

        public void b(l2.V v5) {
            t.e(v5, "user");
            Intent intent = new Intent(this.f24374a.requireContext(), PublicProfileActivity.class);
            intent.putExtra("user", v5);
            C2540v1 v1Var = this.f24374a;
            UptodownApp.a aVar = UptodownApp.f13477F;
            FragmentActivity requireActivity = v1Var.requireActivity();
            t.d(requireActivity, "requireActivity(...)");
            v1Var.startActivity(intent, aVar.a(requireActivity));
        }

        public void a() {
        }
    }

    /* renamed from: i2.v1$r  reason: case insensitive filesystem */
    public static final class C2558r implements C2227d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24463a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ File f24464b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ l2.T f24465c;

        C2558r(C2540v1 v1Var, File file, l2.T t5) {
            this.f24463a = v1Var;
            this.f24464b = file;
            this.f24465c = t5;
        }

        public void a(DocumentFile documentFile) {
            t.e(documentFile, "docFile");
        }

        public void b(Object obj, int i5, int i6, long j5) {
            t.e(obj, "file");
        }

        public void c(File file) {
            t.e(file, "file");
        }

        public void d(DocumentFile documentFile) {
            t.e(documentFile, "docFile");
        }

        public void e(int i5, String str, long j5, long j6) {
            t.e(str, "currentFilename");
        }

        public void f(File file) {
            t.e(file, "file");
        }

        public void h(Object obj) {
            t.e(obj, "file");
        }

        public void i() {
            if (this.f24463a.getActivity() != null && (this.f24463a.getActivity() instanceof C1598a)) {
                FragmentActivity activity = this.f24463a.getActivity();
                t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                File file = this.f24464b;
                t.b(file);
                ((C1598a) activity).C2(file, this.f24465c.f());
            }
        }

        public void g() {
        }
    }

    /* renamed from: i2.v1$l  reason: case insensitive filesystem */
    public static final class C2552l implements Animation.AnimationListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24454a;

        C2552l(C2540v1 v1Var) {
            this.f24454a = v1Var;
        }

        public void onAnimationEnd(Animation animation) {
            this.f24454a.b4().f22795f.removeAllViews();
            this.f24454a.f4().B().set(false);
        }

        public void onAnimationRepeat(Animation animation) {
        }

        public void onAnimationStart(Animation animation) {
        }
    }

    /* renamed from: i2.v1$s  reason: case insensitive filesystem */
    public static final class C2559s implements m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2540v1 f24466a;

        /* renamed from: i2.v1$s$a */
        public static final class a implements C2231h {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ C2540v1 f24467a;

            a(C2540v1 v1Var) {
                this.f24467a = v1Var;
            }

            public void a() {
                C2540v1 v1Var = this.f24467a;
                String string = v1Var.getString(com.uptodown.R.string.installing);
                t.d(string, "getString(...)");
                v1Var.A6(string);
            }

            public void b(String str) {
                if (str != null) {
                    this.f24467a.o3(str);
                    return;
                }
                C2540v1 v1Var = this.f24467a;
                String string = v1Var.getString(com.uptodown.R.string.error_generico);
                t.d(string, "getString(...)");
                v1Var.o3(string);
            }
        }

        C2559s(C2540v1 v1Var) {
            this.f24466a = v1Var;
        }

        public void a(File file, ArrayList arrayList) {
            t.e(file, "fileZipped");
            t.e(arrayList, "files");
            a aVar = new a(this.f24466a);
            if (this.f24466a.getActivity() != null) {
                FragmentActivity activity = this.f24466a.getActivity();
                t.b(activity);
                if (!activity.isFinishing()) {
                    FragmentActivity activity2 = this.f24466a.getActivity();
                    t.b(activity2);
                    C2275G g5 = new C2275G(activity2);
                    g5.B(arrayList);
                    ArrayList C4 = g5.C();
                    FragmentActivity requireActivity = this.f24466a.requireActivity();
                    t.d(requireActivity, "requireActivity(...)");
                    new C2292l(requireActivity, aVar).A(C4, false);
                    if (this.f24466a.getActivity() instanceof C1598a) {
                        C2940B.a aVar2 = C2940B.f26458v;
                        FragmentActivity activity3 = this.f24466a.getActivity();
                        t.b(activity3);
                        C2940B a5 = aVar2.a(activity3);
                        a5.a();
                        String name = file.getName();
                        t.d(name, "getName(...)");
                        C2668q f02 = a5.f0(name);
                        a5.m();
                        if (f02 != null) {
                            FragmentActivity activity4 = this.f24466a.getActivity();
                            t.c(activity4, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                            ((C1598a) activity4).E2(f02);
                        }
                    }
                }
            }
        }

        public void b(int i5) {
            this.f24466a.L6(i5);
        }

        public void e() {
            if (this.f24466a.getContext() != null) {
                C2540v1 v1Var = this.f24466a;
                String string = v1Var.getString(com.uptodown.R.string.msg_install_from_unknown_source, v1Var.getString(com.uptodown.R.string.app_name));
                t.d(string, "getString(...)");
                this.f24466a.o3(string);
            }
        }

        public void f() {
            if (this.f24466a.getContext() != null) {
                C2540v1 v1Var = this.f24466a;
                String string = v1Var.getString(com.uptodown.R.string.core_kill_this_app, v1Var.getString(com.uptodown.R.string.app_name));
                t.d(string, "getString(...)");
                this.f24466a.o3(string);
            }
        }

        public void g() {
            this.f24466a.L6(0);
        }

        public void h() {
            if (this.f24466a.getContext() != null) {
                String string = this.f24466a.getString(com.uptodown.R.string.error_unzipping);
                t.d(string, "getString(...)");
                this.f24466a.o3(string);
            }
        }

        public void i() {
            if (this.f24466a.getActivity() != null && (this.f24466a.getActivity() instanceof C1598a)) {
                FragmentActivity activity = this.f24466a.getActivity();
                t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                ((C1598a) activity).M();
            }
        }

        public void c(File file) {
        }

        public void d(File file) {
        }
    }

    /* access modifiers changed from: private */
    public static final void F4(View view) {
    }
}
