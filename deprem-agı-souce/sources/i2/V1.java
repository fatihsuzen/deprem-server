package i2;

import B2.n;
import R1.C0975f;
import S1.k;
import W2.C2223l;
import W2.J;
import W2.m;
import W2.u;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.AppDetailActivity;
import com.uptodown.activities.C1598a;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.preferences.a;
import g2.C2385g;
import g2.C2388j;
import h2.X;
import java.util.ArrayList;
import java.util.Iterator;
import k2.C2587D;
import k2.C2591a;
import k2.C2608s;
import k2.C2610u;
import k2.C2611v;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2657f;
import l2.C2660i;
import l2.S;
import org.json.JSONArray;
import org.json.JSONObject;
import w3.C2865c0;
import w3.C2908y0;
import w3.M;
import w3.O;
import z2.F;
import z2.H;
import z2.Z;

public final class V1 extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private final C2223l f24071a = m.b(new T1(this));
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public C0975f f24072b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ArrayList f24073c = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f24074d = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public S f24075e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ArrayList f24076f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public S f24077g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f24078h = true;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f24079i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public boolean f24080j = true;

    /* renamed from: k  reason: collision with root package name */
    private C2611v f24081k = new c(this);

    /* renamed from: l  reason: collision with root package name */
    private final a f24082l = new a(this);

    /* renamed from: m  reason: collision with root package name */
    private final f f24083m = new f(this);

    /* renamed from: n  reason: collision with root package name */
    private final b f24084n = new b(this);

    public static final class a implements C2591a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ V1 f24085a;

        a(V1 v12) {
            this.f24085a = v12;
        }

        /* access modifiers changed from: private */
        public static final J c(V1 v12, C2657f fVar) {
            v12.H(fVar.S());
            return J.f19942a;
        }

        public void a(C2657f fVar, int i5) {
            t.e(fVar, "appInfo");
            if (this.f24085a.getActivity() instanceof MainActivity) {
                FragmentActivity activity = this.f24085a.getActivity();
                t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
                RelativeLayout Q5 = ((MainActivity) activity).Q5();
                if (Q5 == null || Q5.getVisibility() != 0) {
                    FragmentActivity activity2 = this.f24085a.getActivity();
                    t.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.BaseActivity");
                    ((C1598a) activity2).a3(fVar, new U1(this.f24085a, fVar));
                }
            }
        }
    }

    public static final class b implements C2608s {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ V1 f24086a;

        b(V1 v12) {
            this.f24086a = v12;
        }

        public void a(S s5) {
            t.e(s5, "topHorizontalTopReceived");
            C0975f i5 = this.f24086a.f24072b;
            if (i5 != null) {
                i5.s(s5);
            }
        }

        public void b(ArrayList arrayList) {
            C0975f i5;
            t.e(arrayList, "miniTopsReceived");
            this.f24086a.f24074d = arrayList;
            if (!this.f24086a.f24074d.isEmpty() && (i5 = this.f24086a.f24072b) != null) {
                i5.m(this.f24086a.f24074d);
            }
        }

        public void c(C2657f fVar) {
            t.e(fVar, "appReplacement");
            C0975f i5 = this.f24086a.f24072b;
            if (i5 != null) {
                i5.b(fVar);
            }
        }

        public void d(S s5) {
            t.e(s5, "topHorizontalLatestReceived");
            C0975f i5 = this.f24086a.f24072b;
            if (i5 != null) {
                i5.r(s5);
            }
        }

        public void e(ArrayList arrayList) {
            t.e(arrayList, "homeFeaturesReceived");
            this.f24086a.f24073c = arrayList;
        }

        public void f(ArrayList arrayList) {
            t.e(arrayList, "homeMiniTopsReceived");
            if (arrayList.size() > 3) {
                this.f24086a.f24076f = new ArrayList();
                ArrayList n5 = this.f24086a.f24076f;
                t.b(n5);
                n5.add(arrayList.get(0));
                ArrayList n6 = this.f24086a.f24076f;
                t.b(n6);
                n6.add(arrayList.get(1));
                ArrayList n7 = this.f24086a.f24076f;
                t.b(n7);
                n7.add(arrayList.get(2));
            } else {
                this.f24086a.f24076f = arrayList;
            }
            C0975f i5 = this.f24086a.f24072b;
            if (i5 != null) {
                i5.n(this.f24086a.f24076f);
            }
        }

        public void g(S s5) {
            t.e(s5, "topHorizontalNewReleasesReceived");
            this.f24086a.f24077g = s5;
        }

        public void h() {
            this.f24086a.z();
        }

        public void i(C2657f fVar) {
            t.e(fVar, "appInfoReceived");
            C0975f i5 = this.f24086a.f24072b;
            if (i5 != null) {
                i5.l(fVar);
            }
        }

        public void j(S s5) {
            t.e(s5, "topByCategory");
            this.f24086a.f24075e = s5;
        }

        public void k(ArrayList arrayList) {
            t.e(arrayList, "categoriesReceived");
        }
    }

    public static final class c implements C2611v {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ V1 f24087a;

        public static final class a implements C2610u {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ V1 f24088a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ C2657f f24089b;

            a(V1 v12, C2657f fVar) {
                this.f24088a = v12;
                this.f24089b = fVar;
            }

            public void c(C2657f fVar) {
                t.e(fVar, "appInfo");
                if (!this.f24088a.requireActivity().isFinishing()) {
                    fVar.V0(this.f24089b.X());
                    fVar.W0("homeFeature");
                    this.f24088a.C(fVar.e(), CampaignEx.JSON_NATIVE_VIDEO_CLICK);
                    Intent intent = new Intent(this.f24088a.requireContext(), AppDetailActivity.class);
                    intent.putExtra("appInfo", fVar);
                    V1 v12 = this.f24088a;
                    UptodownApp.a aVar = UptodownApp.f13477F;
                    FragmentActivity requireActivity = v12.requireActivity();
                    t.d(requireActivity, "requireActivity(...)");
                    v12.startActivity(intent, aVar.a(requireActivity));
                }
            }

            public void d(int i5) {
                if (this.f24088a.getActivity() != null && (this.f24088a.getActivity() instanceof MainActivity)) {
                    FragmentActivity activity = this.f24088a.getActivity();
                    t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
                    String string = this.f24088a.getString(R.string.app_detail_not_found);
                    t.d(string, "getString(...)");
                    ((MainActivity) activity).u0(string);
                }
            }
        }

        c(V1 v12) {
            this.f24087a = v12;
        }

        public void a(C2660i iVar) {
            t.e(iVar, "category");
            if (!UptodownApp.f13477F.Z()) {
                return;
            }
            if (iVar.c() == 523) {
                FragmentActivity activity = this.f24087a.getActivity();
                t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
                ((MainActivity) activity).z5(1);
                return;
            }
            FragmentActivity activity2 = this.f24087a.getActivity();
            t.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
            ((MainActivity) activity2).u8(iVar);
        }

        public void b(C2657f fVar) {
            t.e(fVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            if (UptodownApp.f13477F.Z() && this.f24087a.getActivity() != null && (this.f24087a.getActivity() instanceof MainActivity)) {
                if (fVar.N0()) {
                    Context requireContext = this.f24087a.requireContext();
                    t.d(requireContext, "requireContext(...)");
                    new C2388j(requireContext, fVar.e(), new a(this.f24087a, fVar), LifecycleOwnerKt.getLifecycleScope(this.f24087a));
                    return;
                }
                FragmentActivity activity = this.f24087a.getActivity();
                t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
                ((MainActivity) activity).H2(fVar.e());
                J j5 = J.f19942a;
            }
        }

        public void c(S s5) {
            t.e(s5, "topByCategory");
            if (UptodownApp.f13477F.Z()) {
                int c5 = s5.b().c();
                if (c5 == -3 || c5 == -2) {
                    FragmentActivity activity = this.f24087a.getActivity();
                    t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
                    ((MainActivity) activity).v8(s5.b());
                } else if (c5 == -1) {
                    FragmentActivity activity2 = this.f24087a.getActivity();
                    t.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
                    ((MainActivity) activity2).v8(s5.b());
                } else if (c5 == 523) {
                    FragmentActivity activity3 = this.f24087a.getActivity();
                    t.c(activity3, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
                    ((MainActivity) activity3).z5(1);
                } else if (s5.b().i() || s5.b().l()) {
                    FragmentActivity activity4 = this.f24087a.getActivity();
                    t.c(activity4, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
                    ((MainActivity) activity4).v8(s5.b());
                } else {
                    FragmentActivity activity5 = this.f24087a.getActivity();
                    t.c(activity5, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
                    ((MainActivity) activity5).z5(2);
                    FragmentActivity activity6 = this.f24087a.getActivity();
                    t.c(activity6, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
                    ((MainActivity) activity6).u8(s5.b());
                }
            }
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24090a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ V1 f24091b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ long f24092c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ String f24093d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(V1 v12, long j5, String str, C2308e eVar) {
            super(2, eVar);
            this.f24091b = v12;
            this.f24092c = j5;
            this.f24093d = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f24091b, this.f24092c, this.f24093d, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f24090a == 0) {
                u.b(obj);
                Context requireContext = this.f24091b.requireContext();
                t.d(requireContext, "requireContext(...)");
                new Z(requireContext).O0(this.f24092c, this.f24093d, "homeFeature");
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class e extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ V1 f24094a;

        e(V1 v12) {
            this.f24094a = v12;
        }

        public void onScrolled(RecyclerView recyclerView, int i5, int i6) {
            t.e(recyclerView, "recyclerView");
            if (i6 > 0 && !this.f24094a.f24079i && this.f24094a.f24080j && !recyclerView.canScrollVertically(1)) {
                this.f24094a.E();
            }
        }
    }

    public static final class f implements C2587D {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ V1 f24095a;

        f(V1 v12) {
            this.f24095a = v12;
        }

        public void a(C2657f fVar) {
            t.e(fVar, "appInfo");
            if (this.f24095a.getActivity() instanceof MainActivity) {
                this.f24095a.C(fVar.e(), "impress");
            }
        }
    }

    static final class g extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24096a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ V1 f24097b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(V1 v12, C2308e eVar) {
            super(2, eVar);
            this.f24097b = v12;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new g(this.f24097b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f24096a;
            if (i5 == 0) {
                u.b(obj);
                V1 v12 = this.f24097b;
                this.f24096a = 1;
                if (v12.F(this) == f5) {
                    return f5;
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((g) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class h extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f24098a;

        /* renamed from: b  reason: collision with root package name */
        Object f24099b;

        /* renamed from: c  reason: collision with root package name */
        /* synthetic */ Object f24100c;

        /* renamed from: d  reason: collision with root package name */
        final /* synthetic */ V1 f24101d;

        /* renamed from: e  reason: collision with root package name */
        int f24102e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        h(V1 v12, C2308e eVar) {
            super(eVar);
            this.f24101d = v12;
        }

        public final Object invokeSuspend(Object obj) {
            this.f24100c = obj;
            this.f24102e |= Integer.MIN_VALUE;
            return this.f24101d.F(this);
        }
    }

    static final class i extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24103a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ V1 f24104b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f24105c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        i(V1 v12, ArrayList arrayList, C2308e eVar) {
            super(2, eVar);
            this.f24104b = v12;
            this.f24105c = arrayList;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new i(this.f24104b, this.f24105c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f24103a == 0) {
                u.b(obj);
                Context requireContext = this.f24104b.requireContext();
                t.d(requireContext, "requireContext(...)");
                Z z4 = new Z(requireContext);
                ArrayList arrayList = new ArrayList();
                if (this.f24104b.f24076f != null) {
                    ArrayList n5 = this.f24104b.f24076f;
                    t.b(n5);
                    Iterator it = n5.iterator();
                    t.d(it, "iterator(...)");
                    while (it.hasNext()) {
                        Object next = it.next();
                        t.d(next, "next(...)");
                        S s5 = (S) next;
                        if (s5.b().i()) {
                            arrayList.add(kotlin.coroutines.jvm.internal.b.b(s5.b().c()));
                        }
                    }
                }
                if (!arrayList.isEmpty()) {
                    l2.M l5 = z4.l(arrayList, 20, 0);
                    if (l5.b() || l5.e() == null) {
                        this.f24104b.f24080j = false;
                    } else {
                        JSONObject e5 = l5.e();
                        t.b(e5);
                        JSONArray optJSONArray = e5.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                        if (e5.optInt("success") == 1 && optJSONArray != null) {
                            int length = optJSONArray.length();
                            for (int i5 = 0; i5 < length; i5++) {
                                JSONObject optJSONObject = optJSONArray.optJSONObject(i5);
                                JSONObject optJSONObject2 = optJSONObject.optJSONObject("floatingCategory");
                                if (optJSONObject2 != null) {
                                    C2660i iVar = new C2660i(0, (String) null, (String) null, 7, (C2633k) null);
                                    iVar.p(optJSONObject2);
                                    ArrayList arrayList2 = new ArrayList();
                                    JSONArray optJSONArray2 = optJSONObject.optJSONArray("apps");
                                    if (optJSONArray2 != null) {
                                        int length2 = optJSONArray2.length();
                                        for (int i6 = 0; i6 < length2; i6++) {
                                            C2657f fVar = new C2657f();
                                            JSONObject optJSONObject3 = optJSONArray2.optJSONObject(i6);
                                            t.b(optJSONObject3);
                                            C2657f.b(fVar, optJSONObject3, (Context) null, 2, (Object) null);
                                            arrayList2.add(fVar);
                                        }
                                    }
                                    S s6 = new S(iVar, arrayList2, 0, 4, (C2633k) null);
                                    s6.f(5);
                                    ArrayList n6 = this.f24104b.f24076f;
                                    if (n6 != null) {
                                        kotlin.coroutines.jvm.internal.b.a(n6.add(s6));
                                    }
                                    this.f24105c.add(s6);
                                }
                            }
                        }
                    }
                } else {
                    this.f24104b.f24080j = false;
                }
                this.f24104b.f24079i = false;
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((i) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class j extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24106a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ ArrayList f24107b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ V1 f24108c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        j(ArrayList arrayList, V1 v12, C2308e eVar) {
            super(2, eVar);
            this.f24107b = arrayList;
            this.f24108c = v12;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new j(this.f24107b, this.f24108c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f24106a == 0) {
                u.b(obj);
                if (this.f24107b.size() < 4) {
                    this.f24108c.f24080j = false;
                }
                Iterator it = this.f24107b.iterator();
                t.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    t.d(next, "next(...)");
                    S s5 = (S) next;
                    C0975f i5 = this.f24108c.f24072b;
                    if (i5 != null) {
                        i5.a(s5);
                    }
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((j) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class k extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24109a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ String f24110b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ V1 f24111c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        k(String str, V1 v12, C2308e eVar) {
            super(2, eVar);
            this.f24110b = str;
            this.f24111c = v12;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new k(this.f24110b, this.f24111c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C0975f i5;
            C2316b.f();
            if (this.f24109a == 0) {
                u.b(obj);
                String str = this.f24110b;
                if (!(str == null || str.length() == 0 || (i5 = this.f24111c.f24072b) == null)) {
                    String str2 = this.f24110b;
                    RecyclerView recyclerView = this.f24111c.A().f22699e;
                    t.d(recyclerView, "recyclerViewHome");
                    i5.u(str2, recyclerView);
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((k) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* access modifiers changed from: private */
    public final X A() {
        return (X) this.f24071a.getValue();
    }

    /* access modifiers changed from: private */
    public final void C(long j5, String str) {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.b(), (O) null, new d(this, j5, str, (C2308e) null), 2, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void D(V1 v12, View view) {
        if (UptodownApp.f13477F.Z()) {
            v12.A().f22698d.setVisibility(0);
            v12.A().f22697c.setVisibility(8);
            v12.B();
        }
    }

    /* access modifiers changed from: private */
    public final void E() {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), (C2312i) null, (O) null, new g(this, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x007b, code lost:
        if (w3.C2872g.g(r8, r6, r0) != r1) goto L_0x007e;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object F(b3.C2308e r8) {
        /*
            r7 = this;
            boolean r0 = r8 instanceof i2.V1.h
            if (r0 == 0) goto L_0x0013
            r0 = r8
            i2.V1$h r0 = (i2.V1.h) r0
            int r1 = r0.f24102e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f24102e = r1
            goto L_0x0018
        L_0x0013:
            i2.V1$h r0 = new i2.V1$h
            r0.<init>(r7, r8)
        L_0x0018:
            java.lang.Object r8 = r0.f24100c
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f24102e
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0041
            if (r2 == r4) goto L_0x0035
            if (r2 != r3) goto L_0x002d
            W2.u.b(r8)
            goto L_0x007e
        L_0x002d:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L_0x0035:
            java.lang.Object r2 = r0.f24099b
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            java.lang.Object r4 = r0.f24098a
            i2.V1 r4 = (i2.V1) r4
            W2.u.b(r8)
            goto L_0x0068
        L_0x0041:
            W2.u.b(r8)
            android.content.Context r8 = r7.getContext()
            if (r8 == 0) goto L_0x0081
            r7.f24079i = r4
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            w3.I r8 = w3.C2865c0.b()
            i2.V1$i r6 = new i2.V1$i
            r6.<init>(r7, r2, r5)
            r0.f24098a = r7
            r0.f24099b = r2
            r0.f24102e = r4
            java.lang.Object r8 = w3.C2872g.g(r8, r6, r0)
            if (r8 != r1) goto L_0x0067
            goto L_0x007d
        L_0x0067:
            r4 = r7
        L_0x0068:
            w3.I0 r8 = w3.C2865c0.c()
            i2.V1$j r6 = new i2.V1$j
            r6.<init>(r2, r4, r5)
            r0.f24098a = r5
            r0.f24099b = r5
            r0.f24102e = r3
            java.lang.Object r8 = w3.C2872g.g(r8, r6, r0)
            if (r8 != r1) goto L_0x007e
        L_0x007d:
            return r1
        L_0x007e:
            W2.J r8 = W2.J.f19942a
            return r8
        L_0x0081:
            W2.J r8 = W2.J.f19942a
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: i2.V1.F(b3.e):java.lang.Object");
    }

    /* access modifiers changed from: private */
    public static final X y(V1 v12) {
        return X.c(v12.getLayoutInflater());
    }

    /* access modifiers changed from: private */
    public final void z() {
        if (!this.f24073c.isEmpty()) {
            C0975f fVar = this.f24072b;
            if (fVar != null) {
                ArrayList arrayList = this.f24073c;
                S s5 = this.f24075e;
                S s6 = this.f24077g;
                String string = getString(R.string.trending_today);
                t.d(string, "getString(...)");
                fVar.p(arrayList, s5, s6, string);
            }
            A().f22699e.setAdapter(this.f24072b);
            A().f22699e.setVisibility(0);
            A().f22697c.setVisibility(8);
        } else {
            A().f22699e.setVisibility(8);
            A().f22697c.setVisibility(0);
        }
        A().f22698d.setVisibility(8);
        if (getActivity() != null && (getActivity() instanceof MainActivity)) {
            if (this.f24078h) {
                this.f24078h = false;
                FragmentActivity activity = getActivity();
                t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
                ((MainActivity) activity).I5();
            }
            if (H.f26488a.d()) {
                FragmentActivity activity2 = getActivity();
                t.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
                ((MainActivity) activity2).S5();
                return;
            }
            FragmentActivity activity3 = getActivity();
            t.c(activity3, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
            ((MainActivity) activity3).C7();
        }
    }

    public final void B() {
        if (getContext() != null) {
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            new C2385g(requireContext, this.f24084n, LifecycleOwnerKt.getLifecycleScope(this));
        }
    }

    public final void G() {
        A().f22699e.smoothScrollToPosition(0);
    }

    public final void H(String str) {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (O) null, new k(str, this, (C2308e) null), 2, (Object) null);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f24078h = true;
        C2611v vVar = this.f24081k;
        a aVar = this.f24082l;
        f fVar = this.f24083m;
        String simpleName = V1.class.getSimpleName();
        t.d(simpleName, "getSimpleName(...)");
        this.f24072b = new C0975f(vVar, aVar, fVar, simpleName);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        t.e(layoutInflater, "inflater");
        TextView textView = A().f22700f;
        k.a aVar = S1.k.f32g;
        textView.setTypeface(aVar.x());
        A().f22701g.setTypeface(aVar.w());
        A().f22701g.setOnClickListener(new S1(this));
        A().f22699e.setItemAnimator((RecyclerView.ItemAnimator) null);
        A().f22699e.setLayoutManager(new LinearLayoutManager(getContext(), 1, false));
        A().f22699e.addItemDecoration(new n((int) getResources().getDimension(R.dimen.margin_m)));
        A().f22699e.addOnScrollListener(new e(this));
        B();
        FrameLayout b5 = A().getRoot();
        t.d(b5, "getRoot(...)");
        return b5;
    }

    public void onPause() {
        super.onPause();
        H1.e k5 = UptodownApp.f13477F.k();
        if (k5 != null) {
            k5.pause();
        }
    }

    public void onResume() {
        H1.e k5;
        super.onResume();
        new F(getContext()).f("HomeFragment");
        UptodownApp.a aVar = UptodownApp.f13477F;
        H1.e l5 = aVar.l();
        if (l5 != null) {
            l5.pause();
        }
        if (getContext() != null) {
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            if (aVar.f(requireContext)) {
                a.C0147a aVar2 = com.uptodown.activities.preferences.a.f15150a;
                Context requireContext2 = requireContext();
                t.d(requireContext2, "requireContext(...)");
                if (aVar2.g(requireContext2) > 0 && (k5 = aVar.k()) != null) {
                    k5.play();
                }
            }
        }
    }
}
