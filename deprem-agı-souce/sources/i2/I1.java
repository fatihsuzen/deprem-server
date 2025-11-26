package i2;

import B2.n;
import R1.C0975f;
import S1.k;
import W2.J;
import W2.u;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import b3.C2308e;
import c3.C2316b;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.C1598a;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.preferences.a;
import g2.C2384f;
import g2.C2388j;
import java.util.ArrayList;
import k2.C2587D;
import k2.C2591a;
import k2.C2610u;
import k2.C2611v;
import k2.r;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2657f;
import l2.C2660i;
import l2.S;
import w3.C2865c0;
import w3.C2908y0;
import w3.M;
import w3.O;
import z2.F;
import z2.Z;

public abstract class I1<VB extends ViewBinding> extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private C2660i f23987a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public C0975f f23988b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ArrayList f23989c = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f23990d = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public S f23991e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public S f23992f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f23993g;

    /* renamed from: h  reason: collision with root package name */
    private C2611v f23994h = new c(this);

    /* renamed from: i  reason: collision with root package name */
    private final a f23995i = new a(this);

    /* renamed from: j  reason: collision with root package name */
    private final e f23996j = new e(this);

    /* renamed from: k  reason: collision with root package name */
    private final b f23997k = new b(this);

    public static final class a implements C2591a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ I1 f23998a;

        a(I1 i12) {
            this.f23998a = i12;
        }

        /* access modifiers changed from: private */
        public static final J c(I1 i12, C2657f fVar) {
            i12.E(fVar.S());
            return J.f19942a;
        }

        public void a(C2657f fVar, int i5) {
            t.e(fVar, "appInfo");
            if (this.f23998a.getActivity() instanceof MainActivity) {
                FragmentActivity activity = this.f23998a.getActivity();
                t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
                RelativeLayout Q5 = ((MainActivity) activity).Q5();
                if (Q5 == null || Q5.getVisibility() != 0) {
                    FragmentActivity activity2 = this.f23998a.getActivity();
                    t.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                    ((C1598a) activity2).a3(fVar, new H1(this.f23998a, fVar));
                }
            }
        }
    }

    public static final class b implements r {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ I1 f23999a;

        b(I1 i12) {
            this.f23999a = i12;
        }

        public void a(S s5) {
            t.e(s5, "topByCategoryReceived");
            this.f23999a.f23992f = s5;
        }

        public void b(ArrayList arrayList) {
            C0975f h5;
            t.e(arrayList, "topsByCategoryReceived");
            if (!arrayList.isEmpty() && this.f23999a.p() != null && (h5 = this.f23999a.f23988b) != null) {
                C2660i p5 = this.f23999a.p();
                t.b(p5);
                h5.f(arrayList, p5);
            }
        }

        public void c(ArrayList arrayList) {
            t.e(arrayList, "featuresReceived");
            this.f23999a.f23990d = arrayList;
        }

        public void d(ArrayList arrayList) {
            t.e(arrayList, "floatingCategories");
            C0975f h5 = this.f23999a.f23988b;
            if (h5 != null) {
                h5.k(arrayList);
            }
        }

        public void e(C2657f fVar) {
            t.e(fVar, "appReplacement");
            C0975f h5 = this.f23999a.f23988b;
            if (h5 != null) {
                h5.b(fVar);
            }
        }

        public void f(S s5) {
            t.e(s5, "topByCategoryReceived");
            C0975f h5 = this.f23999a.f23988b;
            if (h5 != null) {
                h5.e(s5);
            }
        }

        public void g() {
            this.f23999a.n();
        }

        public void h(S s5) {
            t.e(s5, "recentsByCategoryReceived");
            this.f23999a.f23991e = s5;
        }

        public void i(ArrayList arrayList) {
            t.e(arrayList, "categoriesReceived");
            this.f23999a.f23989c = arrayList;
        }
    }

    public static final class c implements C2611v {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ I1 f24000a;

        public static final class a implements C2610u {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ I1 f24001a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2657f f24002b;

            a(I1 i12, C2657f fVar) {
                this.f24001a = i12;
                this.f24002b = fVar;
            }

            public void c(C2657f fVar) {
                t.e(fVar, "appInfo");
                if (!this.f24001a.requireActivity().isFinishing()) {
                    fVar.V0(this.f24002b.X());
                    fVar.W0("parentCategoryFeature");
                    this.f24001a.x(fVar.e(), CampaignEx.JSON_NATIVE_VIDEO_CLICK);
                    Intent intent = new Intent(this.f24001a.requireContext(), AppDetailActivity.class);
                    intent.putExtra("appInfo", fVar);
                    I1 i12 = this.f24001a;
                    UptodownApp.a aVar = UptodownApp.f13477F;
                    FragmentActivity requireActivity = i12.requireActivity();
                    t.d(requireActivity, "requireActivity(...)");
                    i12.startActivity(intent, aVar.a(requireActivity));
                }
            }

            public void d(int i5) {
                if (this.f24001a.getActivity() != null && (this.f24001a.getActivity() instanceof MainActivity)) {
                    FragmentActivity activity = this.f24001a.getActivity();
                    t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
                    String string = this.f24001a.getString(R.string.app_detail_not_found);
                    t.d(string, "getString(...)");
                    ((MainActivity) activity).u0(string);
                }
            }
        }

        c(I1 i12) {
            this.f24000a = i12;
        }

        public void a(C2660i iVar) {
            t.e(iVar, "category");
            if (UptodownApp.f13477F.Z()) {
                this.f24000a.y(iVar);
            }
        }

        public void b(C2657f fVar) {
            t.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            if (UptodownApp.f13477F.Z() && this.f24000a.getActivity() != null && (this.f24000a.getActivity() instanceof MainActivity)) {
                if (fVar.N0()) {
                    Context requireContext = this.f24000a.requireContext();
                    t.d(requireContext, "requireContext(...)");
                    new C2388j(requireContext, fVar.e(), new a(this.f24000a, fVar), LifecycleOwnerKt.getLifecycleScope(this.f24000a));
                    return;
                }
                FragmentActivity activity = this.f24000a.getActivity();
                t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
                ((MainActivity) activity).H2(fVar.e());
                J j5 = J.f19942a;
            }
        }

        public void c(S s5) {
            t.e(s5, "topByCategory");
            if (UptodownApp.f13477F.Z()) {
                if (t.a(s5.b().e(), this.f24000a.getString(R.string.top_downloads_title))) {
                    s5.b().x(this.f24000a.q());
                }
                this.f24000a.A(s5);
            }
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24003a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ I1 f24004b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f24005c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f24006d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(I1 i12, long j5, String str, C2308e eVar) {
            super(2, eVar);
            this.f24004b = i12;
            this.f24005c = j5;
            this.f24006d = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f24004b, this.f24005c, this.f24006d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f24003a == 0) {
                u.b(obj);
                Context requireContext = this.f24004b.requireContext();
                t.d(requireContext, "requireContext(...)");
                new Z(requireContext).O0(this.f24005c, this.f24006d, "parentCategoryFeature");
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class e implements C2587D {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ I1 f24007a;

        e(I1 i12) {
            this.f24007a = i12;
        }

        public void a(C2657f fVar) {
            t.e(fVar, "appInfo");
            if (this.f24007a.getActivity() instanceof MainActivity) {
                this.f24007a.x(fVar.e(), "impress");
            }
        }
    }

    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24008a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f24009b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ I1 f24010c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(String str, I1 i12, C2308e eVar) {
            super(2, eVar);
            this.f24009b = str;
            this.f24010c = i12;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new f(this.f24009b, this.f24010c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C0975f h5;
            C2316b.f();
            if (this.f24008a == 0) {
                u.b(obj);
                String str = this.f24009b;
                if (!(str == null || str.length() == 0 || (h5 = this.f24010c.f23988b) == null)) {
                    h5.u(this.f24009b, this.f24010c.u());
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((f) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0012, code lost:
        if (r0.isEmpty() == false) goto L_0x002e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void n() {
        /*
            r9 = this;
            R1.f r0 = r9.f23988b
            if (r0 == 0) goto L_0x0014
            if (r0 == 0) goto L_0x000b
            java.util.ArrayList r0 = r0.q()
            goto L_0x000c
        L_0x000b:
            r0 = 0
        L_0x000c:
            if (r0 == 0) goto L_0x0014
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x002e
        L_0x0014:
            R1.f r0 = new R1.f
            k2.v r1 = r9.f23994h
            i2.I1$a r2 = r9.f23995i
            i2.I1$e r3 = r9.f23996j
            java.lang.Class r4 = r9.getClass()
            java.lang.String r4 = r4.getSimpleName()
            java.lang.String r5 = "getSimpleName(...)"
            kotlin.jvm.internal.t.d(r4, r5)
            r0.<init>(r1, r2, r3, r4)
            r9.f23988b = r0
        L_0x002e:
            java.util.ArrayList r0 = r9.f23990d
            boolean r0 = r0.isEmpty()
            r1 = 8
            r2 = 0
            if (r0 != 0) goto L_0x0085
            java.util.ArrayList r0 = r9.f23989c
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0085
            java.lang.String r0 = r9.q()
            if (r0 == 0) goto L_0x004d
            int r0 = r0.length()
            if (r0 != 0) goto L_0x0057
        L_0x004d:
            r0 = 2131951721(0x7f130069, float:1.9539865E38)
            java.lang.String r0 = r9.getString(r0)
            r9.D(r0)
        L_0x0057:
            R1.f r3 = r9.f23988b
            if (r3 == 0) goto L_0x006d
            java.util.ArrayList r4 = r9.f23990d
            java.util.ArrayList r5 = r9.f23989c
            l2.S r6 = r9.f23991e
            l2.S r7 = r9.f23992f
            java.lang.String r8 = r9.q()
            kotlin.jvm.internal.t.b(r8)
            r3.o(r4, r5, r6, r7, r8)
        L_0x006d:
            androidx.recyclerview.widget.RecyclerView r0 = r9.u()
            R1.f r3 = r9.f23988b
            r0.setAdapter(r3)
            androidx.recyclerview.widget.RecyclerView r0 = r9.u()
            r0.setVisibility(r2)
            android.widget.TextView r0 = r9.v()
            r0.setVisibility(r1)
            goto L_0x009a
        L_0x0085:
            androidx.recyclerview.widget.RecyclerView r0 = r9.u()
            r0.setVisibility(r1)
            android.widget.TextView r0 = r9.v()
            r0.setVisibility(r2)
            android.widget.TextView r0 = r9.t()
            r0.setVisibility(r2)
        L_0x009a:
            android.view.View r0 = r9.s()
            r0.setVisibility(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.I1.n():void");
    }

    private final void r() {
        if (!this.f23993g) {
            this.f23993g = true;
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            b bVar = this.f23997k;
            C2660i iVar = this.f23987a;
            t.b(iVar);
            new C2384f(requireContext, bVar, iVar, LifecycleOwnerKt.getLifecycleScope(this));
            return;
        }
        s().setVisibility(8);
        J j5 = J.f19942a;
    }

    /* access modifiers changed from: private */
    public final void x(long j5, String str) {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.b(), (O) null, new d(this, j5, str, (C2308e) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void z(I1 i12, View view) {
        if (UptodownApp.f13477F.Z()) {
            i12.v().setVisibility(8);
            i12.s().setVisibility(0);
            i12.t().setVisibility(8);
            i12.B();
        }
    }

    /* access modifiers changed from: protected */
    public abstract void A(S s5);

    public final void B() {
        this.f23993g = false;
        r();
    }

    public final void C() {
        u().smoothScrollToPosition(0);
    }

    /* access modifiers changed from: protected */
    public abstract void D(String str);

    public final void E(String str) {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (O) null, new f(str, this, (C2308e) null), 2, (Object) null);
    }

    /* access modifiers changed from: protected */
    public abstract ViewBinding o();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (arguments != null) {
            C2660i iVar = new C2660i(0, (String) null, (String) null, 7, (C2633k) null);
            this.f23987a = iVar;
            t.b(iVar);
            iVar.q(arguments);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        t.e(layoutInflater, "inflater");
        TextView t5 = t();
        k.a aVar = k.f32g;
        t5.setTypeface(aVar.x());
        v().setTypeface(aVar.w());
        v().setOnClickListener(new G1(this));
        u().setItemAnimator((RecyclerView.ItemAnimator) null);
        u().setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        u().addItemDecoration(new n((int) getResources().getDimension(R.dimen.margin_m)));
        s().setVisibility(0);
        View root = o().getRoot();
        t.d(root, "getRoot(...)");
        return root;
    }

    public void onPause() {
        super.onPause();
        H1.e l5 = UptodownApp.f13477F.l();
        if (l5 != null) {
            l5.pause();
        }
    }

    public void onResume() {
        H1.e l5;
        super.onResume();
        new F(getContext()).f(w());
        UptodownApp.a aVar = UptodownApp.f13477F;
        H1.e k5 = aVar.k();
        if (k5 != null) {
            k5.pause();
        }
        if (getContext() != null) {
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            if (aVar.f(requireContext)) {
                a.C0147a aVar2 = com.uptodown.activities.preferences.a.f15150a;
                Context requireContext2 = requireContext();
                t.d(requireContext2, "requireContext(...)");
                if (aVar2.g(requireContext2) > 0 && (l5 = aVar.l()) != null) {
                    l5.play();
                }
            }
        }
        r();
    }

    public final C2660i p() {
        return this.f23987a;
    }

    /* access modifiers changed from: protected */
    public abstract String q();

    /* access modifiers changed from: protected */
    public abstract View s();

    /* access modifiers changed from: protected */
    public abstract TextView t();

    /* access modifiers changed from: protected */
    public abstract RecyclerView u();

    /* access modifiers changed from: protected */
    public abstract TextView v();

    /* access modifiers changed from: protected */
    public abstract String w();

    /* access modifiers changed from: protected */
    public abstract void y(C2660i iVar);
}
