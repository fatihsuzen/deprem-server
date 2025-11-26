package i2;

import B2.q;
import R1.G;
import S1.k;
import W2.C2223l;
import W2.J;
import W2.m;
import W2.u;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b3.C2308e;
import c3.C2316b;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.C1598a;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MoreInfo;
import com.uptodown.workers.DownloadWorker;
import g2.C2388j;
import g2.C2392n;
import h2.X0;
import java.io.File;
import java.util.ArrayList;
import k2.C2591a;
import k2.C2594d;
import k2.C2595e;
import k2.C2599i;
import k2.C2610u;
import k2.Z;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2654c;
import l2.C2657f;
import l2.C2660i;
import l2.C2668q;
import l2.L;
import l2.S;
import l2.V;
import w3.C2865c0;
import w3.C2908y0;
import w3.M;
import w3.O;
import z2.C2940B;
import z2.C2954m;
import z2.F;

/* renamed from: i2.h  reason: case insensitive filesystem */
public final class C2497h extends Fragment {

    /* renamed from: f  reason: collision with root package name */
    public static final a f24213f = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final C2223l f24214a = m.b(new C2476a(this));

    /* renamed from: b  reason: collision with root package name */
    public C2654c f24215b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public G f24216c;

    /* renamed from: d  reason: collision with root package name */
    private g f24217d = new g(this);

    /* renamed from: e  reason: collision with root package name */
    private f f24218e = new f(this);

    /* renamed from: i2.h$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final C2497h a(C2654c cVar) {
            t.e(cVar, "alternatives");
            C2497h hVar = new C2497h();
            hVar.J(cVar);
            return hVar;
        }

        private a() {
        }
    }

    /* renamed from: i2.h$b */
    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24219a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f24220b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2497h f24221c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(String str, C2497h hVar, C2308e eVar) {
            super(2, eVar);
            this.f24220b = str;
            this.f24221c = hVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f24220b, this.f24221c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f24219a == 0) {
                u.b(obj);
                String str = this.f24220b;
                if (!(str == null || str.length() == 0 || this.f24221c.f24216c == null)) {
                    G q5 = this.f24221c.f24216c;
                    t.b(q5);
                    int i5 = 0;
                    for (G.b bVar : q5.c()) {
                        int i6 = i5 + 1;
                        if (bVar.b() != null) {
                            C2657f b5 = bVar.b();
                            t.b(b5);
                            if (b5.S() != null) {
                                C2657f b6 = bVar.b();
                                t.b(b6);
                                if (t.a(b6.S(), this.f24220b)) {
                                    G q6 = this.f24221c.f24216c;
                                    t.b(q6);
                                    q6.notifyItemChanged(i5);
                                }
                            }
                        }
                        i5 = i6;
                    }
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* renamed from: i2.h$c */
    public static final class c implements Z {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2497h f24222a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2657f f24223b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f24224c;

        c(C2497h hVar, C2657f fVar, int i5) {
            this.f24222a = hVar;
            this.f24223b = fVar;
            this.f24224c = i5;
        }

        /* access modifiers changed from: private */
        public static final J e(C2497h hVar, C2657f fVar) {
            hVar.C(fVar);
            return J.f19942a;
        }

        /* access modifiers changed from: private */
        public static final J f(C2497h hVar, C2657f fVar, int i5) {
            hVar.v(fVar, i5);
            return J.f19942a;
        }

        public void a(L l5) {
            t.e(l5, "reportVT");
            if (this.f24222a.getActivity() != null && (this.f24222a.getActivity() instanceof C1598a) && !this.f24222a.requireActivity().isFinishing()) {
                this.f24223b.Y0(l5);
                if (l5.d() > 0) {
                    FragmentActivity activity = this.f24222a.getActivity();
                    t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                    C2657f fVar = this.f24223b;
                    ((C1598a) activity).j2(fVar, new C2500i(this.f24222a, fVar), new C2503j(this.f24222a, this.f24223b, this.f24224c));
                    return;
                }
                this.f24222a.C(this.f24223b);
            }
        }

        public void b() {
            this.f24222a.C(this.f24223b);
        }
    }

    /* renamed from: i2.h$d */
    public static final class d implements C2610u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2497h f24225a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ int f24226b;

        d(C2497h hVar, int i5) {
            this.f24225a = hVar;
            this.f24226b = i5;
        }

        public void c(C2657f fVar) {
            ArrayList arrayList;
            t.e(fVar, "appInfo");
            if (fVar.J0()) {
                this.f24225a.w(fVar, this.f24226b);
                G q5 = this.f24225a.f24216c;
                if (q5 != null) {
                    arrayList = q5.c();
                } else {
                    arrayList = null;
                }
                t.b(arrayList);
                ((G.b) arrayList.get(this.f24226b)).e(fVar);
                G q6 = this.f24225a.f24216c;
                if (q6 != null) {
                    q6.notifyItemChanged(this.f24226b);
                }
            } else if (fVar.L0()) {
                FragmentActivity activity = this.f24225a.getActivity();
                t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                String string = this.f24225a.getString(R.string.download_not_available_in_this_country);
                t.d(string, "getString(...)");
                ((C1598a) activity).u0(string);
            } else {
                FragmentActivity activity2 = this.f24225a.getActivity();
                t.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                String string2 = this.f24225a.getString(R.string.app_detail_not_available);
                t.d(string2, "getString(...)");
                ((C1598a) activity2).u0(string2);
            }
        }

        public void d(int i5) {
            if (this.f24225a.getActivity() instanceof C1598a) {
                FragmentActivity activity = this.f24225a.getActivity();
                t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                ((C1598a) activity).u0(this.f24225a.getString(R.string.error_cant_enqueue_download) + " (108)");
            }
        }
    }

    /* renamed from: i2.h$e */
    public static final class e implements C2591a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2497h f24227a;

        e(C2497h hVar) {
            this.f24227a = hVar;
        }

        public void a(C2657f fVar, int i5) {
            t.e(fVar, "appInfo");
            this.f24227a.K(fVar);
        }
    }

    /* renamed from: i2.h$f */
    public static final class f implements C2595e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2497h f24228a;

        f(C2497h hVar) {
            this.f24228a = hVar;
        }

        public void a(C2657f fVar, int i5) {
            boolean z4;
            boolean z5;
            t.e(fVar, "appInfo");
            if (this.f24228a.getContext() != null) {
                C2940B.a aVar = C2940B.f26458v;
                Context context = this.f24228a.getContext();
                t.b(context);
                C2940B a5 = aVar.a(context);
                a5.a();
                String S4 = fVar.S();
                t.b(S4);
                C2668q k02 = a5.k0(S4, fVar.A0());
                boolean v5 = new C2954m().v(fVar.S(), this.f24228a.getContext());
                a5.m();
                UptodownApp.a aVar2 = UptodownApp.f13477F;
                Context context2 = this.f24228a.getContext();
                t.b(context2);
                boolean z6 = false;
                if (!aVar2.S("downloadApkWorker", context2) || !DownloadWorker.f21359d.j(fVar.e())) {
                    z4 = false;
                } else {
                    z4 = true;
                }
                if (k02 == null || !k02.M()) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                if (k02 != null && k02.f()) {
                    z6 = true;
                }
                if (k02 == null || (!z4 && !z5 && !z6)) {
                    if (v5) {
                        this.f24228a.H(fVar.S());
                    } else {
                        this.f24228a.B(fVar.e(), i5);
                    }
                } else if (DownloadWorker.f21359d.k(fVar.e(), fVar.J())) {
                } else {
                    if (k02.f()) {
                        File n5 = k02.n();
                        if (n5 != null) {
                            Context context3 = this.f24228a.getContext();
                            t.b(context3);
                            aVar2.U(n5, context3, fVar.O());
                            return;
                        }
                        return;
                    }
                    Context context4 = this.f24228a.getContext();
                    t.b(context4);
                    k02.T(context4);
                    G q5 = this.f24228a.f24216c;
                    if (q5 != null) {
                        q5.notifyItemChanged(i5);
                    }
                }
            }
        }

        public void b(C2657f fVar, int i5) {
            t.e(fVar, "appInfo");
            this.f24228a.v(fVar, i5);
        }
    }

    /* renamed from: i2.h$g */
    public static final class g implements C2594d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2497h f24229a;

        g(C2497h hVar) {
            this.f24229a = hVar;
        }

        public void b(C2657f fVar) {
            t.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            if (!UptodownApp.f13477F.Z()) {
                return;
            }
            if (this.f24229a.getActivity() != null && (this.f24229a.getActivity() instanceof MainActivity)) {
                FragmentActivity activity = this.f24229a.getActivity();
                t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
                ((MainActivity) activity).H2(fVar.e());
            } else if (this.f24229a.getActivity() != null && (this.f24229a.getActivity() instanceof C1598a)) {
                FragmentActivity activity2 = this.f24229a.getActivity();
                t.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                ((C1598a) activity2).H2(fVar.e());
            }
        }
    }

    /* access modifiers changed from: private */
    public static final J A(C2497h hVar, C2657f fVar, int i5) {
        hVar.v(fVar, i5);
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final void B(long j5, int i5) {
        Context requireContext = requireContext();
        t.d(requireContext, "requireContext(...)");
        new C2388j(requireContext, j5, new d(this, i5), LifecycleOwnerKt.getLifecycleScope(this));
    }

    /* access modifiers changed from: private */
    public final void C(C2657f fVar) {
        if (getActivity() != null && (getActivity() instanceof C1598a)) {
            UptodownApp.a aVar = UptodownApp.f13477F;
            FragmentActivity activity = getActivity();
            t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            aVar.a0(fVar, (C1598a) activity);
        }
    }

    private final X0 E() {
        return (X0) this.f24214a.getValue();
    }

    private final void F() {
        E().f22706e.setVisibility(0);
        Drawable drawable = ContextCompat.getDrawable(requireContext(), R.drawable.core_vector_back);
        if (drawable != null) {
            E().f22706e.setNavigationIcon(drawable);
            E().f22706e.setNavigationContentDescription((CharSequence) getString(R.string.back));
        }
        E().f22706e.setNavigationOnClickListener(new C2479b(this));
        E().f22707f.setTypeface(k.f32g.x());
        E().f22707f.setVisibility(8);
        E().f22705d.setItemAnimator((RecyclerView.ItemAnimator) null);
        E().f22705d.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        E().f22705d.addItemDecoration(new q(11));
        RecyclerView recyclerView = E().f22705d;
        t.d(recyclerView, "recyclerviewTopCat");
        recyclerView.setPadding(0, 0, 0, 0);
    }

    /* access modifiers changed from: private */
    public static final void G(C2497h hVar, View view) {
        FragmentActivity activity = hVar.getActivity();
        if (activity instanceof MainActivity) {
            FragmentActivity activity2 = hVar.getActivity();
            t.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
            ((MainActivity) activity2).b7();
        } else if (activity instanceof AppDetailActivity) {
            FragmentActivity activity3 = hVar.getActivity();
            t.c(activity3, "null cannot be cast to non-null type com.uptodown.activities.AppDetailActivity");
            ((AppDetailActivity) activity3).finish();
        } else if (activity instanceof MoreInfo) {
            FragmentActivity activity4 = hVar.getActivity();
            t.c(activity4, "null cannot be cast to non-null type com.uptodown.activities.MoreInfo");
            ((MoreInfo) activity4).finish();
        }
    }

    /* access modifiers changed from: private */
    public final void H(String str) {
        Intent launchIntentForPackage;
        if (getActivity() != null && str != null && str.length() != 0 && (launchIntentForPackage = requireActivity().getPackageManager().getLaunchIntentForPackage(str)) != null) {
            startActivity(launchIntentForPackage);
        }
    }

    private final void I() {
        G g5;
        if (k.f32g.i() == null && (g5 = this.f24216c) != null) {
            g5.notifyDataSetChanged();
        }
    }

    /* access modifiers changed from: private */
    public final void K(C2657f fVar) {
        if ((getActivity() instanceof MainActivity) || (getActivity() instanceof AppDetailActivity)) {
            FragmentActivity activity = getActivity();
            t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            ((C1598a) activity).a3(fVar, new C2482c(fVar, this));
        }
    }

    /* access modifiers changed from: private */
    public static final J L(C2657f fVar, C2497h hVar) {
        if (fVar.S() != null) {
            String S4 = fVar.S();
            t.b(S4);
            hVar.t(S4);
        }
        return J.f19942a;
    }

    private final void M(C2654c cVar) {
        if (getActivity() != null && !requireActivity().isFinishing()) {
            S s5 = new S((C2660i) null, (ArrayList) null, 0, 7, (C2633k) null);
            ArrayList a5 = cVar.a();
            t.b(a5);
            s5.d(a5);
            s5.e(new C2660i(-4, cVar.c(), cVar.b()));
            g gVar = this.f24217d;
            f fVar = this.f24218e;
            e eVar = new e(this);
            String b5 = cVar.b();
            String c5 = cVar.c();
            String string = getString(R.string.read_more_desc_app_detail);
            t.d(string, "getString(...)");
            String string2 = getString(R.string.read_less_desc_app_detail);
            t.d(string2, "getString(...)");
            G g5 = new G(gVar, fVar, eVar, (C2599i) null, b5, c5, string, string2, false);
            this.f24216c = g5;
            g5.b(s5);
            E().f22705d.setAdapter(this.f24216c);
        }
    }

    /* access modifiers changed from: private */
    public static final X0 u(C2497h hVar) {
        return X0.c(hVar.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final void v(C2657f fVar, int i5) {
        if (getContext() != null) {
            C2940B.a aVar = C2940B.f26458v;
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            C2940B a5 = aVar.a(requireContext);
            a5.a();
            String S4 = fVar.S();
            t.b(S4);
            C2668q k02 = a5.k0(S4, fVar.J());
            a5.m();
            if (k02 != null) {
                DownloadWorker.f21359d.d(fVar.e());
                k02.g();
                Context requireContext2 = requireContext();
                t.d(requireContext2, "requireContext(...)");
                k02.T(requireContext2);
                G g5 = this.f24216c;
                if (g5 != null) {
                    g5.notifyItemChanged(i5);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void w(C2657f fVar, int i5) {
        if (getActivity() != null && !requireActivity().isFinishing()) {
            V.b bVar = V.f24870q;
            FragmentActivity requireActivity = requireActivity();
            t.d(requireActivity, "requireActivity(...)");
            V h5 = bVar.h(requireActivity);
            if (h5 == null || !h5.q()) {
                C(fVar);
                J j5 = J.f19942a;
            } else if (fVar.K0()) {
                FragmentActivity activity = getActivity();
                t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                ((C1598a) activity).j2(fVar, new C2485d(this, fVar), new C2488e(this, fVar, i5));
                J j6 = J.f19942a;
            } else if (fVar.j0() == null) {
                FragmentActivity requireActivity2 = requireActivity();
                t.d(requireActivity2, "requireActivity(...)");
                new C2392n(requireActivity2, String.valueOf(fVar.A()), fVar.n0(), new c(this, fVar, i5), LifecycleOwnerKt.getLifecycleScope(this));
            } else {
                L j02 = fVar.j0();
                t.b(j02);
                if (j02.d() > 0) {
                    FragmentActivity activity2 = getActivity();
                    t.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                    ((C1598a) activity2).j2(fVar, new C2491f(this, fVar), new C2494g(this, fVar, i5));
                } else {
                    C(fVar);
                }
                J j7 = J.f19942a;
            }
        }
    }

    /* access modifiers changed from: private */
    public static final J x(C2497h hVar, C2657f fVar) {
        hVar.C(fVar);
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final J y(C2497h hVar, C2657f fVar, int i5) {
        hVar.v(fVar, i5);
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final J z(C2497h hVar, C2657f fVar) {
        hVar.C(fVar);
        return J.f19942a;
    }

    public final C2654c D() {
        C2654c cVar = this.f24215b;
        if (cVar != null) {
            return cVar;
        }
        t.w("alternatives");
        return null;
    }

    public final void J(C2654c cVar) {
        t.e(cVar, "<set-?>");
        this.f24215b = cVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        M(D());
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        t.e(layoutInflater, "inflater");
        F();
        RelativeLayout b5 = E().getRoot();
        t.d(b5, "getRoot(...)");
        return b5;
    }

    public void onResume() {
        super.onResume();
        new F(getContext()).f("AlternativesFragment");
        I();
    }

    public final void t(String str) {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (O) null, new b(str, this, (C2308e) null), 2, (Object) null);
    }
}
