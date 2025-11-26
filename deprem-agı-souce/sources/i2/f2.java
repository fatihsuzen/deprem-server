package i2;

import R1.G;
import S1.k;
import W2.C2219h;
import W2.C2223l;
import W2.J;
import W2.q;
import W2.u;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b3.C2308e;
import c3.C2316b;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.C1598a;
import com.uptodown.activities.ListsActivity;
import com.uptodown.activities.LoginActivity;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.MoreInfo;
import com.uptodown.activities.PreregistrationActivity;
import com.uptodown.workers.DownloadWorker;
import g2.C2388j;
import g2.C2392n;
import g2.C2394p;
import h2.X0;
import i2.j2;
import java.io.File;
import java.util.ArrayList;
import k2.C2585B;
import k2.C2591a;
import k2.C2594d;
import k2.C2595e;
import k2.C2599i;
import k2.C2610u;
import k2.Z;
import k3.C2616a;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import l2.C2647G;
import l2.C2657f;
import l2.C2660i;
import l2.C2668q;
import l2.C2669s;
import l2.L;
import l2.S;
import l2.T;
import l2.V;
import w3.C2865c0;
import w3.C2908y0;
import z2.C2940B;
import z2.C2954m;
import z2.C2962v;
import z2.F;
import z2.O;
import z3.C2973f;
import z3.D;

public final class f2 extends Fragment {

    /* renamed from: k  reason: collision with root package name */
    public static final a f24166k = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private final C2223l f24167a = W2.m.b(new X1(this));

    /* renamed from: b  reason: collision with root package name */
    private final C2223l f24168b = FragmentViewModelLazyKt.createViewModelLazy(this, M.b(j2.class), new l(new k(this)), (C2616a) null);

    /* renamed from: c  reason: collision with root package name */
    private C2660i f24169c = new C2660i(0, (String) null, (String) null, 7, (C2633k) null);

    /* renamed from: d  reason: collision with root package name */
    private String f24170d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public G f24171e;

    /* renamed from: f  reason: collision with root package name */
    private n f24172f = new n(this);

    /* renamed from: g  reason: collision with root package name */
    private final c f24173g = new c(this);

    /* renamed from: h  reason: collision with root package name */
    private m f24174h = new m(this);

    /* renamed from: i  reason: collision with root package name */
    private final b f24175i = new b(this);

    /* renamed from: j  reason: collision with root package name */
    private final ActivityResultLauncher f24176j;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final f2 a(C2660i iVar) {
            t.e(iVar, "category");
            f2 f2Var = new f2();
            f2Var.Y(iVar);
            return f2Var;
        }

        private a() {
        }
    }

    public static final class b implements C2591a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f2 f24177a;

        b(f2 f2Var) {
            this.f24177a = f2Var;
        }

        /* access modifiers changed from: private */
        public static final J c(f2 f2Var, C2657f fVar) {
            f2Var.a0(fVar);
            return J.f19942a;
        }

        public void a(C2657f fVar, int i5) {
            t.e(fVar, "appInfo");
            if ((this.f24177a.getActivity() instanceof MainActivity) || (this.f24177a.getActivity() instanceof AppDetailActivity)) {
                FragmentActivity activity = this.f24177a.getActivity();
                t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                ((C1598a) activity).a3(fVar, new g2(this.f24177a, fVar));
            }
        }
    }

    public static final class c implements C2599i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f2 f24178a;

        c(f2 f2Var) {
            this.f24178a = f2Var;
        }

        public void a(long j5) {
            if (this.f24178a.getActivity() instanceof C1598a) {
                FragmentActivity activity = this.f24178a.getActivity();
                t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                ((C1598a) activity).H2(j5);
            }
        }

        public void b(C2660i iVar) {
            t.e(iVar, "category");
            if (this.f24178a.getActivity() != null) {
                FragmentActivity activity = this.f24178a.getActivity();
                if (activity instanceof AppDetailActivity) {
                    FragmentActivity activity2 = this.f24178a.getActivity();
                    t.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.AppDetailActivity");
                    ((AppDetailActivity) activity2).y3(iVar);
                } else if (activity instanceof ListsActivity) {
                    FragmentActivity activity3 = this.f24178a.getActivity();
                    t.c(activity3, "null cannot be cast to non-null type com.uptodown.activities.ListsActivity");
                    ((ListsActivity) activity3).A3(iVar);
                } else if (activity instanceof MainActivity) {
                    FragmentActivity activity4 = this.f24178a.getActivity();
                    t.c(activity4, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
                    ((MainActivity) activity4).v8(iVar);
                } else if (activity instanceof MoreInfo) {
                    FragmentActivity activity5 = this.f24178a.getActivity();
                    t.c(activity5, "null cannot be cast to non-null type com.uptodown.activities.MoreInfo");
                    ((MoreInfo) activity5).f4(iVar);
                } else if (activity instanceof PreregistrationActivity) {
                    FragmentActivity activity6 = this.f24178a.getActivity();
                    t.c(activity6, "null cannot be cast to non-null type com.uptodown.activities.PreregistrationActivity");
                    ((PreregistrationActivity) activity6).Q3(iVar);
                }
            }
        }

        public void c(String str) {
            t.e(str, "url");
            if (this.f24178a.getActivity() instanceof C1598a) {
                C2962v vVar = new C2962v();
                FragmentActivity requireActivity = this.f24178a.requireActivity();
                t.d(requireActivity, "requireActivity(...)");
                C2962v.u(vVar, requireActivity, str, (String) null, 4, (Object) null);
            }
        }
    }

    public static final class d implements Z {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f2 f24179a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2657f f24180b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f24181c;

        d(f2 f2Var, C2657f fVar, int i5) {
            this.f24179a = f2Var;
            this.f24180b = fVar;
            this.f24181c = i5;
        }

        /* access modifiers changed from: private */
        public static final J e(f2 f2Var, C2657f fVar, int i5) {
            f2Var.J(fVar, i5);
            return J.f19942a;
        }

        /* access modifiers changed from: private */
        public static final J f(f2 f2Var, C2657f fVar, int i5) {
            f2Var.C(fVar, i5);
            return J.f19942a;
        }

        public void a(L l5) {
            t.e(l5, "reportVT");
            if (this.f24179a.getActivity() != null && (this.f24179a.getActivity() instanceof C1598a) && !this.f24179a.requireActivity().isFinishing()) {
                this.f24180b.Y0(l5);
                if (l5.d() > 0) {
                    FragmentActivity activity = this.f24179a.getActivity();
                    t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                    C2657f fVar = this.f24180b;
                    ((C1598a) activity).j2(fVar, new h2(this.f24179a, fVar, this.f24181c), new i2(this.f24179a, this.f24180b, this.f24181c));
                    return;
                }
                this.f24179a.J(this.f24180b, this.f24181c);
            }
        }

        public void b() {
            this.f24179a.J(this.f24180b, this.f24181c);
        }
    }

    public static final class e implements C2610u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ int f24182a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f2 f24183b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ int f24184c;

        e(int i5, f2 f2Var, int i6) {
            this.f24182a = i5;
            this.f24183b = f2Var;
            this.f24184c = i6;
        }

        public void c(C2657f fVar) {
            ArrayList arrayList;
            t.e(fVar, "appInfo");
            if (fVar.J0()) {
                fVar.V0(this.f24182a);
                if (t.a(this.f24183b.O().i(), "floatingCategory")) {
                    fVar.W0("floatingCategory");
                } else {
                    fVar.W0("leafCategory");
                }
                this.f24183b.D(fVar, this.f24184c);
                G s5 = this.f24183b.f24171e;
                if (s5 != null) {
                    arrayList = s5.c();
                } else {
                    arrayList = null;
                }
                t.b(arrayList);
                ((G.b) arrayList.get(this.f24184c)).e(fVar);
                G s6 = this.f24183b.f24171e;
                if (s6 != null) {
                    s6.notifyItemChanged(this.f24184c);
                }
            } else if (fVar.L0()) {
                FragmentActivity activity = this.f24183b.getActivity();
                t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                String string = this.f24183b.getString(R.string.download_not_available_in_this_country);
                t.d(string, "getString(...)");
                ((C1598a) activity).u0(string);
            } else {
                FragmentActivity activity2 = this.f24183b.getActivity();
                t.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                String string2 = this.f24183b.getString(R.string.app_detail_not_available);
                t.d(string2, "getString(...)");
                ((C1598a) activity2).u0(string2);
            }
        }

        public void d(int i5) {
            FragmentActivity activity = this.f24183b.getActivity();
            t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            ((C1598a) activity).u0(this.f24183b.getString(R.string.error_cant_enqueue_download) + " (108)");
        }
    }

    public static final class f extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f2 f24185a;

        f(f2 f2Var) {
            this.f24185a = f2Var;
        }

        public void onScrolled(RecyclerView recyclerView, int i5, int i6) {
            t.e(recyclerView, "recyclerView");
            if (i6 > 0 && !this.f24185a.O().l() && recyclerView.getLayoutManager() != null) {
                RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
                t.b(layoutManager);
                int childCount = layoutManager.getChildCount();
                RecyclerView.LayoutManager layoutManager2 = recyclerView.getLayoutManager();
                t.b(layoutManager2);
                int itemCount = layoutManager2.getItemCount();
                RecyclerView.LayoutManager layoutManager3 = recyclerView.getLayoutManager();
                t.b(layoutManager3);
                int findFirstVisibleItemPosition = ((LinearLayoutManager) layoutManager3).findFirstVisibleItemPosition();
                if (!this.f24185a.O().h() && childCount + findFirstVisibleItemPosition >= itemCount - 10) {
                    this.f24185a.S();
                }
            }
        }
    }

    static final class g extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f24186a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f2 f24187b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ f2 f24188a;

            a(f2 f2Var) {
                this.f24188a = f2Var;
            }

            /* renamed from: b */
            public final Object emit(O o5, C2308e eVar) {
                if (!(o5 instanceof O.a)) {
                    if (o5 instanceof O.c) {
                        if (((Boolean) ((O.c) o5).a()).booleanValue()) {
                            this.f24188a.K().f22703b.setImageDrawable(ContextCompat.getDrawable(this.f24188a.requireContext(), R.drawable.vector_favorite_remove));
                            if ((this.f24188a.getActivity() instanceof C1598a) && this.f24188a.O().m()) {
                                FragmentActivity activity = this.f24188a.getActivity();
                                t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                                f2 f2Var = this.f24188a;
                                String string = f2Var.getString(R.string.category_added_to_favorites, f2Var.L().e());
                                t.d(string, "getString(...)");
                                ((C1598a) activity).u0(string);
                            }
                        } else {
                            this.f24188a.K().f22703b.setImageDrawable(ContextCompat.getDrawable(this.f24188a.requireContext(), R.drawable.vector_favorite_add));
                            if ((this.f24188a.getActivity() instanceof C1598a) && this.f24188a.O().m()) {
                                FragmentActivity activity2 = this.f24188a.getActivity();
                                t.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                                f2 f2Var2 = this.f24188a;
                                String string2 = f2Var2.getString(R.string.category_removed_from_favorites, f2Var2.L().e());
                                t.d(string2, "getString(...)");
                                ((C1598a) activity2).u0(string2);
                            }
                        }
                        if (!this.f24188a.O().m()) {
                            this.f24188a.O().v(true);
                        }
                    } else if (!(o5 instanceof O.b)) {
                        throw new q();
                    }
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(f2 f2Var, C2308e eVar) {
            super(2, eVar);
            this.f24187b = f2Var;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new g(this.f24187b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f24186a;
            if (i5 == 0) {
                u.b(obj);
                D o5 = this.f24187b.O().o();
                a aVar = new a(this.f24187b);
                this.f24186a = 1;
                if (o5.collect(aVar, this) == f5) {
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
            return ((g) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class h extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f24189a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f2 f24190b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ f2 f24191a;

            a(f2 f2Var) {
                this.f24191a = f2Var;
            }

            /* renamed from: b */
            public final Object emit(O o5, C2308e eVar) {
                if (o5 instanceof O.a) {
                    this.f24191a.K().f22704c.setVisibility(0);
                } else if (o5 instanceof O.c) {
                    O.c cVar = (O.c) o5;
                    if (!((j2.a) cVar.a()).a()) {
                        G s5 = this.f24191a.f24171e;
                        if (s5 != null) {
                            s5.a(((j2.a) cVar.a()).b().a(), this.f24191a.L().m());
                        }
                    } else if (!((j2.a) cVar.a()).b().a().isEmpty()) {
                        this.f24191a.Z(((j2.a) cVar.a()).b());
                        this.f24191a.K().f22705d.setVisibility(0);
                        this.f24191a.K().f22707f.setVisibility(8);
                        this.f24191a.K().f22708g.setVisibility(8);
                    } else {
                        this.f24191a.K().f22705d.setVisibility(8);
                        this.f24191a.K().f22707f.setVisibility(0);
                        this.f24191a.K().f22708g.setVisibility(0);
                    }
                    this.f24191a.O().u(false);
                    this.f24191a.K().f22704c.setVisibility(8);
                } else if (!(o5 instanceof O.b)) {
                    throw new q();
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(f2 f2Var, C2308e eVar) {
            super(2, eVar);
            this.f24190b = f2Var;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new h(this.f24190b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f24189a;
            if (i5 == 0) {
                u.b(obj);
                D j5 = this.f24190b.O().j();
                a aVar = new a(this.f24190b);
                this.f24189a = 1;
                if (j5.collect(aVar, this) == f5) {
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
            return ((h) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class i implements C2610u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f2 f24192a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2657f f24193b;

        i(f2 f2Var, C2657f fVar) {
            this.f24192a = f2Var;
            this.f24193b = fVar;
        }

        public void c(C2657f fVar) {
            t.e(fVar, "appInfo");
            if (!this.f24192a.requireActivity().isFinishing()) {
                fVar.V0(this.f24193b.X());
                if (t.a(this.f24192a.O().i(), "floatingCategory")) {
                    fVar.W0("floatingCategory");
                } else {
                    fVar.W0("leafCategory");
                }
                j2 v5 = this.f24192a.O();
                Context requireContext = this.f24192a.requireContext();
                t.d(requireContext, "requireContext(...)");
                v5.q(requireContext, fVar, CampaignEx.JSON_NATIVE_VIDEO_CLICK);
                Intent intent = new Intent(this.f24192a.requireContext(), AppDetailActivity.class);
                intent.putExtra("appInfo", fVar);
                f2 f2Var = this.f24192a;
                UptodownApp.a aVar = UptodownApp.f13477F;
                FragmentActivity requireActivity = f2Var.requireActivity();
                t.d(requireActivity, "requireActivity(...)");
                f2Var.startActivity(intent, aVar.a(requireActivity));
            }
        }

        public void d(int i5) {
            if (this.f24192a.getActivity() instanceof C1598a) {
                FragmentActivity activity = this.f24192a.getActivity();
                t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                String string = this.f24192a.getString(R.string.app_detail_not_found);
                t.d(string, "getString(...)");
                ((C1598a) activity).u0(string);
            }
        }
    }

    public static final class j implements C2585B {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f2 f24194a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2657f f24195b;

        j(f2 f2Var, C2657f fVar) {
            this.f24194a = f2Var;
            this.f24195b = fVar;
        }

        public void a() {
            if (this.f24194a.getActivity() != null && !this.f24194a.requireActivity().isFinishing()) {
                FragmentActivity activity = this.f24194a.getActivity();
                t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                String string = this.f24194a.getString(R.string.error_generico);
                t.d(string, "getString(...)");
                ((C1598a) activity).u0(string);
            }
        }

        public void b() {
            G s5 = this.f24194a.f24171e;
            if (s5 != null) {
                s5.d(this.f24195b);
            }
        }

        public void c() {
            G s5 = this.f24194a.f24171e;
            if (s5 != null) {
                s5.d(this.f24195b);
            }
        }
    }

    public static final class k extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Fragment f24196a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(Fragment fragment) {
            super(0);
            this.f24196a = fragment;
        }

        public final Fragment invoke() {
            return this.f24196a;
        }
    }

    public static final class l extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2616a f24197a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(C2616a aVar) {
            super(0);
            this.f24197a = aVar;
        }

        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = ((ViewModelStoreOwner) this.f24197a.invoke()).getViewModelStore();
            t.d(viewModelStore, "ownerProducer().viewModelStore");
            return viewModelStore;
        }
    }

    public static final class m implements C2595e {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f2 f24198a;

        m(f2 f2Var) {
            this.f24198a = f2Var;
        }

        public void a(C2657f fVar, int i5) {
            boolean z4;
            boolean z5;
            boolean z6;
            t.e(fVar, "appInfo");
            if (this.f24198a.getContext() == null) {
                return;
            }
            if (this.f24198a.L().c() == 1090) {
                this.f24198a.X(fVar);
            } else if (fVar.A() == 0 || fVar.S() == null) {
                this.f24198a.W(fVar);
            } else {
                C2940B.a aVar = C2940B.f26458v;
                Context requireContext = this.f24198a.requireContext();
                t.d(requireContext, "requireContext(...)");
                C2940B a5 = aVar.a(requireContext);
                a5.a();
                C2668q qVar = null;
                boolean z7 = false;
                if (fVar.S() != null) {
                    z4 = new C2954m().v(fVar.S(), this.f24198a.getContext());
                    String S4 = fVar.S();
                    t.b(S4);
                    T G02 = a5.G0(S4);
                    if (G02 != null) {
                        Context requireContext2 = this.f24198a.requireContext();
                        t.d(requireContext2, "requireContext(...)");
                        qVar = G02.b(requireContext2);
                    }
                    if (qVar == null) {
                        String S5 = fVar.S();
                        t.b(S5);
                        qVar = a5.k0(S5, fVar.A0());
                    }
                } else {
                    z4 = false;
                }
                a5.m();
                UptodownApp.a aVar2 = UptodownApp.f13477F;
                Context requireContext3 = this.f24198a.requireContext();
                t.d(requireContext3, "requireContext(...)");
                if (!aVar2.S("downloadApkWorker", requireContext3) || !DownloadWorker.f21359d.j(fVar.e())) {
                    z5 = false;
                } else {
                    z5 = true;
                }
                if (qVar == null || !qVar.M()) {
                    z6 = false;
                } else {
                    z6 = true;
                }
                if (qVar != null && qVar.f()) {
                    z7 = true;
                }
                if (qVar != null && (z5 || z6 || z7)) {
                    int x4 = qVar.x();
                    if (1 <= x4 && x4 < 100 && DownloadWorker.f21359d.k(fVar.e(), fVar.J())) {
                        return;
                    }
                    if (z7) {
                        File n5 = qVar.n();
                        if (n5 != null) {
                            Context requireContext4 = this.f24198a.requireContext();
                            t.d(requireContext4, "requireContext(...)");
                            aVar2.U(n5, requireContext4, fVar.O());
                            return;
                        }
                        return;
                    }
                    Context requireContext5 = this.f24198a.requireContext();
                    t.d(requireContext5, "requireContext(...)");
                    qVar.T(requireContext5);
                    G s5 = this.f24198a.f24171e;
                    if (s5 != null) {
                        s5.notifyItemChanged(i5);
                    }
                } else if (z4) {
                    this.f24198a.V(fVar.S());
                } else {
                    this.f24198a.I(fVar.e(), fVar.X(), i5);
                }
            }
        }

        public void b(C2657f fVar, int i5) {
            t.e(fVar, "appInfo");
            this.f24198a.C(fVar, i5);
        }
    }

    public static final class n implements C2594d {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ f2 f24199a;

        n(f2 f2Var) {
            this.f24199a = f2Var;
        }

        public void b(C2657f fVar) {
            t.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            this.f24199a.W(fVar);
        }
    }

    static final class o extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f24200a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f2 f24201b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2657f f24202c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        o(f2 f2Var, C2657f fVar, C2308e eVar) {
            super(2, eVar);
            this.f24201b = f2Var;
            this.f24202c = fVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new o(this.f24201b, this.f24202c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f24200a == 0) {
                u.b(obj);
                G s5 = this.f24201b.f24171e;
                t.b(s5);
                s5.notifyItemChanged(this.f24201b.N(this.f24202c.S()));
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((o) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class p extends kotlin.coroutines.jvm.internal.l implements k3.p {

        /* renamed from: a  reason: collision with root package name */
        int f24203a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ f2 f24204b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f24205c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        p(f2 f2Var, String str, C2308e eVar) {
            super(2, eVar);
            this.f24204b = f2Var;
            this.f24205c = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new p(this.f24204b, this.f24205c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f24203a == 0) {
                u.b(obj);
                G s5 = this.f24204b.f24171e;
                if (s5 != null) {
                    s5.notifyItemChanged(this.f24204b.N(this.f24205c));
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(w3.M m5, C2308e eVar) {
            return ((p) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public f2() {
        ActivityResultLauncher registerForActivityResult = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new Y1(this));
        t.d(registerForActivityResult, "registerForActivityResult(...)");
        this.f24176j = registerForActivityResult;
    }

    /* access modifiers changed from: private */
    public static final X0 B(f2 f2Var) {
        return X0.c(f2Var.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final void C(C2657f fVar, int i5) {
        C2668q qVar;
        if (getContext() != null) {
            C2940B.a aVar = C2940B.f26458v;
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            C2940B a5 = aVar.a(requireContext);
            a5.a();
            String S4 = fVar.S();
            t.b(S4);
            T G02 = a5.G0(S4);
            if (G02 != null) {
                Context requireContext2 = requireContext();
                t.d(requireContext2, "requireContext(...)");
                qVar = G02.b(requireContext2);
            } else {
                qVar = null;
            }
            if (qVar == null) {
                String S5 = fVar.S();
                t.b(S5);
                qVar = a5.k0(S5, fVar.J());
            }
            if (qVar == null) {
                String S6 = fVar.S();
                t.b(S6);
                qVar = a5.j0(S6);
            }
            a5.m();
            if (qVar != null) {
                DownloadWorker.f21359d.d(fVar.e());
                Context requireContext3 = requireContext();
                t.d(requireContext3, "requireContext(...)");
                qVar.T(requireContext3);
                G g5 = this.f24171e;
                if (g5 != null) {
                    g5.notifyItemChanged(i5);
                }
                if (G02 != null) {
                    UptodownApp.f13477F.d0(G02.h());
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final void D(C2657f fVar, int i5) {
        if (getActivity() != null && !requireActivity().isFinishing()) {
            V.b bVar = V.f24870q;
            FragmentActivity requireActivity = requireActivity();
            t.d(requireActivity, "requireActivity(...)");
            V h5 = bVar.h(requireActivity);
            if (h5 == null || !h5.q()) {
                J(fVar, i5);
                J j5 = J.f19942a;
            } else if (fVar.K0()) {
                FragmentActivity activity = getActivity();
                t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                ((C1598a) activity).j2(fVar, new b2(this, fVar, i5), new c2(this, fVar, i5));
                J j6 = J.f19942a;
            } else if (fVar.j0() == null) {
                FragmentActivity requireActivity2 = requireActivity();
                t.d(requireActivity2, "requireActivity(...)");
                new C2392n(requireActivity2, String.valueOf(fVar.A()), fVar.n0(), new d(this, fVar, i5), LifecycleOwnerKt.getLifecycleScope(this));
            } else {
                L j02 = fVar.j0();
                t.b(j02);
                if (j02.d() > 0) {
                    FragmentActivity activity2 = getActivity();
                    t.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                    ((C1598a) activity2).j2(fVar, new d2(this, fVar, i5), new e2(this, fVar, i5));
                } else {
                    J(fVar, i5);
                }
                J j7 = J.f19942a;
            }
        }
    }

    /* access modifiers changed from: private */
    public static final J E(f2 f2Var, C2657f fVar, int i5) {
        f2Var.J(fVar, i5);
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final J F(f2 f2Var, C2657f fVar, int i5) {
        f2Var.C(fVar, i5);
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final J G(f2 f2Var, C2657f fVar, int i5) {
        f2Var.J(fVar, i5);
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public static final J H(f2 f2Var, C2657f fVar, int i5) {
        f2Var.C(fVar, i5);
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final void I(long j5, int i5, int i6) {
        Context requireContext = requireContext();
        t.d(requireContext, "requireContext(...)");
        new C2388j(requireContext, j5, new e(i5, this, i6), LifecycleOwnerKt.getLifecycleScope(this));
    }

    /* access modifiers changed from: private */
    public final void J(C2657f fVar, int i5) {
        String Y4;
        if (getActivity() != null && (getActivity() instanceof C1598a)) {
            UptodownApp.a aVar = UptodownApp.f13477F;
            FragmentActivity activity = getActivity();
            t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            if (aVar.a0(fVar, (C1598a) activity) >= 0) {
                if (!(!fVar.N0() || (Y4 = fVar.Y()) == null || Y4.length() == 0)) {
                    C2669s sVar = new C2669s();
                    long e5 = fVar.e();
                    String Y5 = fVar.Y();
                    t.b(Y5);
                    sVar.a(e5, Y5);
                    Context requireContext = requireContext();
                    t.d(requireContext, "requireContext(...)");
                    sVar.f(requireContext);
                }
                G g5 = this.f24171e;
                if (g5 != null) {
                    g5.notifyItemChanged(i5);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    public final X0 K() {
        return (X0) this.f24167a.getValue();
    }

    /* access modifiers changed from: private */
    public final int N(String str) {
        G g5;
        int i5 = -1;
        if (!(str == null || str.length() == 0 || (g5 = this.f24171e) == null)) {
            t.b(g5);
            int i6 = 0;
            for (G.b bVar : g5.c()) {
                int i7 = i6 + 1;
                if (bVar.b() != null) {
                    C2657f b5 = bVar.b();
                    t.b(b5);
                    if (b5.S() != null) {
                        C2657f b6 = bVar.b();
                        t.b(b6);
                        if (t.a(b6.S(), str)) {
                            i5 = i6;
                        }
                    }
                }
                i6 = i7;
            }
        }
        return i5;
    }

    /* access modifiers changed from: private */
    public final j2 O() {
        return (j2) this.f24168b.getValue();
    }

    private final void P() {
        K().f22706e.setNavigationIcon(ContextCompat.getDrawable(requireContext(), R.drawable.core_vector_back));
        K().f22706e.setNavigationContentDescription((CharSequence) getString(R.string.back));
        K().f22706e.setNavigationOnClickListener(new Z1(this));
        TextView textView = K().f22709h;
        k.a aVar = S1.k.f32g;
        textView.setTypeface(aVar.w());
        K().f22708g.setTypeface(aVar.w());
        K().f22708g.setOnClickListener(new a2(this));
        K().f22707f.setTypeface(aVar.x());
        K().f22707f.setVisibility(8);
        K().f22705d.setItemAnimator((RecyclerView.ItemAnimator) null);
        K().f22705d.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        if (this.f24169c.m()) {
            K().f22705d.addItemDecoration(new B2.q(11));
        }
        if (this.f24169c.c() != -1) {
            RecyclerView recyclerView = K().f22705d;
            t.d(recyclerView, "recyclerviewTopCat");
            recyclerView.setPadding(0, 0, 0, 0);
        }
        K().f22705d.addOnScrollListener(new f(this));
    }

    /* access modifiers changed from: private */
    public static final void Q(f2 f2Var, View view) {
        FragmentManager supportFragmentManager;
        if (!(f2Var.getActivity() instanceof MainActivity)) {
            FragmentActivity activity = f2Var.getActivity();
            if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null) {
                supportFragmentManager.popBackStack();
            }
        } else if (f2Var.f24169c.c() == -1) {
            FragmentActivity activity2 = f2Var.getActivity();
            t.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
            ((MainActivity) activity2).z5(0);
        } else {
            FragmentActivity activity3 = f2Var.getActivity();
            t.c(activity3, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
            ((MainActivity) activity3).b7();
        }
    }

    /* access modifiers changed from: private */
    public static final void R(f2 f2Var, View view) {
        if (UptodownApp.f13477F.Z()) {
            f2Var.K().f22708g.setVisibility(8);
            f2Var.K().f22704c.setVisibility(0);
            f2Var.K().f22707f.setVisibility(8);
            f2Var.M();
        }
    }

    /* access modifiers changed from: private */
    public final void S() {
        if (getContext() != null) {
            j2 O4 = O();
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            O4.g(requireContext, this.f24169c);
        }
    }

    /* access modifiers changed from: private */
    public static final void T(f2 f2Var, ActivityResult activityResult) {
        if (activityResult.getResultCode() == 1 && f2Var.f24169c.i() && f2Var.getContext() != null) {
            j2 O4 = f2Var.O();
            Context requireContext = f2Var.requireContext();
            t.d(requireContext, "requireContext(...)");
            O4.p(requireContext, f2Var.f24169c.c());
        }
    }

    /* access modifiers changed from: private */
    public static final void U(f2 f2Var, View view) {
        UptodownApp.a aVar = UptodownApp.f13477F;
        if (aVar.Z()) {
            V.b bVar = V.f24870q;
            Context requireContext = f2Var.requireContext();
            t.d(requireContext, "requireContext(...)");
            if (bVar.h(requireContext) == null) {
                Intent intent = new Intent(f2Var.requireContext(), LoginActivity.class);
                ActivityResultLauncher activityResultLauncher = f2Var.f24176j;
                FragmentActivity requireActivity = f2Var.requireActivity();
                t.d(requireActivity, "requireActivity(...)");
                activityResultLauncher.launch(intent, aVar.b(requireActivity));
            } else if (f2Var.O().o().getValue() instanceof O.c) {
                Object value = f2Var.O().o().getValue();
                t.c(value, "null cannot be cast to non-null type com.uptodown.util.Result.Success<kotlin.Boolean>");
                if (((Boolean) ((O.c) value).a()).booleanValue()) {
                    j2 O4 = f2Var.O();
                    Context requireContext2 = f2Var.requireContext();
                    t.d(requireContext2, "requireContext(...)");
                    O4.r(requireContext2, f2Var.f24169c.c());
                    return;
                }
                j2 O5 = f2Var.O();
                Context requireContext3 = f2Var.requireContext();
                t.d(requireContext3, "requireContext(...)");
                O5.e(requireContext3, f2Var.f24169c.c());
            }
        }
    }

    /* access modifiers changed from: private */
    public final void V(String str) {
        Intent launchIntentForPackage;
        if (getActivity() != null && str != null && str.length() != 0 && (launchIntentForPackage = requireActivity().getPackageManager().getLaunchIntentForPackage(str)) != null) {
            startActivity(launchIntentForPackage);
        }
    }

    /* access modifiers changed from: private */
    public final void W(C2657f fVar) {
        if (!UptodownApp.f13477F.Z()) {
            return;
        }
        if (fVar.N0()) {
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            new C2388j(requireContext, fVar.e(), new i(this, fVar), LifecycleOwnerKt.getLifecycleScope(this));
            return;
        }
        if (getActivity() != null && (getActivity() instanceof MainActivity)) {
            FragmentActivity activity = getActivity();
            t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
            ((MainActivity) activity).H2(fVar.e());
        } else if (getActivity() != null && (getActivity() instanceof C1598a)) {
            FragmentActivity activity2 = getActivity();
            t.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
            ((C1598a) activity2).H2(fVar.e());
        }
        J j5 = J.f19942a;
    }

    /* access modifiers changed from: private */
    public final void X(C2657f fVar) {
        if (getContext() != null) {
            UptodownApp.a aVar = UptodownApp.f13477F;
            if (aVar.Z()) {
                V.b bVar = V.f24870q;
                Context requireContext = requireContext();
                t.d(requireContext, "requireContext(...)");
                if (bVar.h(requireContext) == null) {
                    Intent intent = new Intent(requireContext(), LoginActivity.class);
                    FragmentActivity requireActivity = requireActivity();
                    t.d(requireActivity, "requireActivity(...)");
                    startActivity(intent, aVar.a(requireActivity));
                    return;
                }
                j jVar = new j(this, fVar);
                C2940B.a aVar2 = C2940B.f26458v;
                Context requireContext2 = requireContext();
                t.d(requireContext2, "requireContext(...)");
                C2940B a5 = aVar2.a(requireContext2);
                a5.a();
                C2647G y02 = a5.y0(fVar.e());
                if (y02 == null) {
                    Context requireContext3 = requireContext();
                    t.d(requireContext3, "requireContext(...)");
                    new C2394p(requireContext3, LifecycleOwnerKt.getLifecycleScope(this), jVar).g(fVar);
                    return;
                }
                Context requireContext4 = requireContext();
                t.d(requireContext4, "requireContext(...)");
                new C2394p(requireContext4, LifecycleOwnerKt.getLifecycleScope(this), jVar).e(y02);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void Z(S s5) {
        if (getActivity() != null && !requireActivity().isFinishing()) {
            String e5 = s5.b().e();
            if (e5 == null || e5.length() == 0) {
                this.f24170d = getResources().getString(R.string.top_downloads_title);
            } else {
                this.f24170d = s5.b().e();
            }
            K().f22709h.setText(this.f24170d);
            n nVar = this.f24172f;
            m mVar = this.f24174h;
            b bVar = this.f24175i;
            c cVar = this.f24173g;
            String b5 = s5.b().b();
            String string = getString(R.string.read_more_desc_app_detail);
            t.d(string, "getString(...)");
            String string2 = getString(R.string.read_less_desc_app_detail);
            t.d(string2, "getString(...)");
            G g5 = new G(nVar, mVar, bVar, cVar, b5, (String) null, string, string2, O().k());
            this.f24171e = g5;
            g5.b(s5);
            K().f22705d.setAdapter(this.f24171e);
        }
    }

    public final C2660i L() {
        return this.f24169c;
    }

    public final void M() {
        if (getContext() != null) {
            j2 O4 = O();
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            O4.f(requireContext, this.f24169c);
        }
    }

    public final void Y(C2660i iVar) {
        t.e(iVar, "<set-?>");
        this.f24169c = iVar;
    }

    public final void a0(C2657f fVar) {
        t.e(fVar, "appInfo");
        G g5 = this.f24171e;
        t.b(g5);
        ((G.b) g5.c().get(N(fVar.S()))).e(fVar);
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new o(this, fVar, (C2308e) null), 2, (Object) null);
    }

    public final void b0(String str) {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new p(this, str, (C2308e) null), 2, (Object) null);
    }

    public void onCreate(Bundle bundle) {
        C2660i iVar;
        super.onCreate(bundle);
        if (bundle != null) {
            if (Build.VERSION.SDK_INT >= 33) {
                iVar = (C2660i) bundle.getParcelable("category", C2660i.class);
            } else {
                iVar = (C2660i) bundle.getParcelable("category");
            }
            if (iVar != null) {
                this.f24169c = iVar;
            }
        }
        if (this.f24169c.c() == 0) {
            this.f24169c.w(-1);
        }
        if (this.f24169c.i()) {
            K().f22703b.setVisibility(0);
            K().f22703b.setOnClickListener(new W1(this));
        }
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new g(this, (C2308e) null), 2, (Object) null);
        C2908y0 unused2 = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new h(this, (C2308e) null), 2, (Object) null);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        t.e(layoutInflater, "inflater");
        P();
        RelativeLayout b5 = K().getRoot();
        t.d(b5, "getRoot(...)");
        return b5;
    }

    public void onResume() {
        super.onResume();
        new F(getContext()).f("TopByCategoryFragment");
        if (this.f24171e == null) {
            M();
        } else if (K().f22705d.getAdapter() == null) {
            K().f22705d.setAdapter(this.f24171e);
        }
    }

    public void onSaveInstanceState(Bundle bundle) {
        t.e(bundle, "outState");
        bundle.putParcelable("category", this.f24169c);
        super.onSaveInstanceState(bundle);
    }
}
