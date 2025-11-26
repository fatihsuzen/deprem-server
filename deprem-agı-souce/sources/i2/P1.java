package i2;

import O1.Q;
import R1.C0972c;
import S1.k;
import W2.C2219h;
import W2.C2223l;
import W2.J;
import W2.m;
import W2.q;
import W2.u;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import b3.C2308e;
import c3.C2316b;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.activities.MainActivity;
import com.uptodown.activities.PublicListActivity;
import com.uptodown.activities.PublicProfileActivity;
import com.uptodown.activities.RepliesActivity;
import g2.C2391m;
import java.util.ArrayList;
import java.util.Iterator;
import k2.C2603m;
import k2.N;
import k3.C2616a;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.M;
import kotlin.jvm.internal.t;
import l2.C2672v;
import l2.O;
import l2.V;
import w3.C2865c0;
import w3.C2908y0;
import z2.C2962v;
import z2.O;
import z3.C2973f;
import z3.D;

public final class P1 extends Fragment {

    /* renamed from: a  reason: collision with root package name */
    private final C2223l f24035a = m.b(new J1(this));

    /* renamed from: b  reason: collision with root package name */
    private final C2223l f24036b = FragmentViewModelLazyKt.createViewModelLazy(this, M.b(Q.class), new f(new e(this)), (C2616a) null);
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public C0972c f24037c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final a f24038d = new a(this);

    public static final class a implements C2603m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ P1 f24039a;

        /* renamed from: i2.P1$a$a  reason: collision with other inner class name */
        public static final class C0243a implements N {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ P1 f24040a;

            C0243a(P1 p12) {
                this.f24040a = p12;
            }

            public void a() {
                this.f24040a.s().f22425e.setVisibility(8);
            }

            public void b(V v5) {
                t.e(v5, "user");
                this.f24040a.s().f22425e.setVisibility(8);
                Intent intent = new Intent(this.f24040a.requireContext(), PublicProfileActivity.class);
                intent.putExtra("user", v5);
                P1 p12 = this.f24040a;
                UptodownApp.a aVar = UptodownApp.f13477F;
                FragmentActivity requireActivity = p12.requireActivity();
                t.d(requireActivity, "requireActivity(...)");
                p12.startActivity(intent, aVar.a(requireActivity));
            }
        }

        a(P1 p12) {
            this.f24039a = p12;
        }

        public void a() {
            if (UptodownApp.f13477F.Z()) {
                C2962v vVar = new C2962v();
                FragmentActivity requireActivity = this.f24039a.requireActivity();
                t.d(requireActivity, "requireActivity(...)");
                String string = this.f24039a.getString(R.string.url_turbo);
                t.d(string, "getString(...)");
                vVar.t(requireActivity, string, this.f24039a.getString(R.string.uptodown_turbo));
            }
        }

        public void b(C2672v vVar) {
            t.e(vVar, "feedItem");
            UptodownApp.a aVar = UptodownApp.f13477F;
            if (aVar.Z()) {
                O b5 = O.f24814p.b(vVar);
                Intent intent = new Intent(this.f24039a.requireContext(), RepliesActivity.class);
                intent.putExtra("review", b5);
                intent.putExtra("appName", vVar.c());
                intent.putExtra("appIconUrl", vVar.b());
                P1 p12 = this.f24039a;
                FragmentActivity requireActivity = p12.requireActivity();
                t.d(requireActivity, "requireActivity(...)");
                p12.startActivity(intent, aVar.a(requireActivity));
            }
        }

        public void c(long j5) {
            if (UptodownApp.f13477F.Z()) {
                this.f24039a.s().f22425e.setVisibility(0);
                Context requireContext = this.f24039a.requireContext();
                t.d(requireContext, "requireContext(...)");
                new C2391m(requireContext, LifecycleOwnerKt.getLifecycleScope(this.f24039a)).c(String.valueOf(j5), new C0243a(this.f24039a));
            }
        }

        public void d(long j5, String str) {
            UptodownApp.a aVar = UptodownApp.f13477F;
            if (aVar.Z()) {
                V v5 = new V();
                v5.y(String.valueOf(j5));
                v5.z(str);
                Intent intent = new Intent(this.f24039a.requireContext(), PublicListActivity.class);
                intent.putExtra("user", v5);
                P1 p12 = this.f24039a;
                FragmentActivity requireActivity = p12.requireActivity();
                t.d(requireActivity, "requireActivity(...)");
                p12.startActivity(intent, aVar.a(requireActivity));
            }
        }

        public void e(long j5, String str) {
            if (UptodownApp.f13477F.Z()) {
                Q o5 = this.f24039a.u();
                Context requireContext = this.f24039a.requireContext();
                t.d(requireContext, "requireContext(...)");
                o5.e(requireContext, String.valueOf(j5));
            }
        }

        public void f(long j5, String str) {
            if (UptodownApp.f13477F.Z() && (this.f24039a.getActivity() instanceof MainActivity)) {
                FragmentActivity activity = this.f24039a.getActivity();
                t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
                ((MainActivity) activity).I2(j5, str);
            }
        }
    }

    public static final class b extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LinearLayoutManager f24041a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ P1 f24042b;

        b(LinearLayoutManager linearLayoutManager, P1 p12) {
            this.f24041a = linearLayoutManager;
            this.f24042b = p12;
        }

        public void onScrolled(RecyclerView recyclerView, int i5, int i6) {
            t.e(recyclerView, "recyclerView");
            if (i6 > 0) {
                int findFirstVisibleItemPosition = this.f24041a.findFirstVisibleItemPosition();
                int childCount = this.f24041a.getChildCount();
                int itemCount = this.f24041a.getItemCount();
                if (!this.f24042b.u().i() && this.f24042b.u().h() && childCount + findFirstVisibleItemPosition >= itemCount) {
                    C0972c l5 = this.f24042b.f24037c;
                    if (l5 != null) {
                        l5.c(true);
                    }
                    Q o5 = this.f24042b.u();
                    Context requireContext = this.f24042b.requireContext();
                    t.d(requireContext, "requireContext(...)");
                    o5.c(requireContext);
                }
            }
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24043a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ P1 f24044b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ P1 f24045a;

            a(P1 p12) {
                this.f24045a = p12;
            }

            /* renamed from: b */
            public final Object emit(z2.O o5, C2308e eVar) {
                ArrayList arrayList = null;
                if (o5 instanceof O.a) {
                    if (this.f24045a.f24037c == null) {
                        this.f24045a.s().f22425e.setVisibility(0);
                    }
                    if (this.f24045a.s().f22428h.isRefreshing()) {
                        this.f24045a.f24037c = null;
                        this.f24045a.s().f22428h.setRefreshing(false);
                    }
                } else if (o5 instanceof O.c) {
                    this.f24045a.u().l(false);
                    if (this.f24045a.f24037c == null) {
                        this.f24045a.f24037c = new C0972c((ArrayList) ((O.c) o5).a(), this.f24045a.f24038d);
                        this.f24045a.s().f22427g.setAdapter(this.f24045a.f24037c);
                    } else {
                        Iterator it = ((ArrayList) ((O.c) o5).a()).iterator();
                        t.d(it, "iterator(...)");
                        while (it.hasNext()) {
                            Object next = it.next();
                            t.d(next, "next(...)");
                            C0972c l5 = this.f24045a.f24037c;
                            t.b(l5);
                            l5.a((C2672v) next);
                        }
                    }
                    C0972c l6 = this.f24045a.f24037c;
                    if (l6 != null) {
                        l6.c(false);
                    }
                    C0972c l7 = this.f24045a.f24037c;
                    if (l7 != null) {
                        arrayList = l7.b();
                    }
                    if (arrayList == null || arrayList.isEmpty()) {
                        this.f24045a.s().f22431k.setVisibility(0);
                    } else {
                        this.f24045a.s().f22427g.setVisibility(0);
                        this.f24045a.s().f22431k.setVisibility(8);
                    }
                    this.f24045a.s().f22424d.setVisibility(8);
                    this.f24045a.s().f22425e.setVisibility(8);
                } else if (!(o5 instanceof O.b)) {
                    throw new q();
                }
                return J.f19942a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(P1 p12, C2308e eVar) {
            super(2, eVar);
            this.f24044b = p12;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f24044b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f24043a;
            if (i5 == 0) {
                u.b(obj);
                D f6 = this.f24044b.u().f();
                a aVar = new a(this.f24044b);
                this.f24043a = 1;
                if (f6.collect(aVar, this) == f5) {
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
            return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f24046a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ P1 f24047b;

        static final class a implements C2973f {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ P1 f24048a;

            a(P1 p12) {
                this.f24048a = p12;
            }

            public final Object b(int i5, C2308e eVar) {
                if (this.f24048a.getActivity() instanceof MainActivity) {
                    if (i5 == 1) {
                        FragmentActivity activity = this.f24048a.getActivity();
                        t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
                        String string = this.f24048a.getString(R.string.follow_succesfully);
                        t.d(string, "getString(...)");
                        ((MainActivity) activity).u0(string);
                    } else if (i5 == 2) {
                        FragmentActivity activity2 = this.f24048a.getActivity();
                        t.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
                        String string2 = this.f24048a.getString(R.string.already_following);
                        t.d(string2, "getString(...)");
                        ((MainActivity) activity2).u0(string2);
                    }
                }
                return J.f19942a;
            }

            public /* bridge */ /* synthetic */ Object emit(Object obj, C2308e eVar) {
                return b(((Number) obj).intValue(), eVar);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(P1 p12, C2308e eVar) {
            super(2, eVar);
            this.f24047b = p12;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f24047b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f24046a;
            if (i5 == 0) {
                u.b(obj);
                D g5 = this.f24047b.u().g();
                a aVar = new a(this.f24047b);
                this.f24046a = 1;
                if (g5.collect(aVar, this) == f5) {
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
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class e extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ Fragment f24049a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(Fragment fragment) {
            super(0);
            this.f24049a = fragment;
        }

        public final Fragment invoke() {
            return this.f24049a;
        }
    }

    public static final class f extends kotlin.jvm.internal.u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2616a f24050a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(C2616a aVar) {
            super(0);
            this.f24050a = aVar;
        }

        public final ViewModelStore invoke() {
            ViewModelStore viewModelStore = ((ViewModelStoreOwner) this.f24050a.invoke()).getViewModelStore();
            t.d(viewModelStore, "ownerProducer().viewModelStore");
            return viewModelStore;
        }
    }

    /* access modifiers changed from: private */
    public static final void A(P1 p12) {
        Q u5 = p12.u();
        Context requireContext = p12.requireContext();
        t.d(requireContext, "requireContext(...)");
        u5.d(requireContext);
        p12.s().f22428h.setRefreshing(true);
    }

    /* access modifiers changed from: private */
    public static final h2.J q(P1 p12) {
        h2.J c5 = h2.J.c(p12.getLayoutInflater());
        t.d(c5, "inflate(...)");
        return c5;
    }

    /* access modifiers changed from: private */
    public final h2.J s() {
        return (h2.J) this.f24035a.getValue();
    }

    /* access modifiers changed from: private */
    public final Q u() {
        return (Q) this.f24036b.getValue();
    }

    private final void v() {
        TextView textView = s().f22432l;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        s().f22431k.setTypeface(aVar.x());
        s().f22429i.setTypeface(aVar.w());
        s().f22430j.setTypeface(aVar.w());
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext(), 1, false);
        s().f22427g.setLayoutManager(linearLayoutManager);
        s().f22427g.addOnScrollListener(new b(linearLayoutManager, this));
        s().f22425e.setOnClickListener(new K1());
        s().f22430j.setOnClickListener(new L1(this));
        s().f22429i.setOnClickListener(new M1(this));
        s().f22426f.setOnClickListener(new N1(this));
        s().f22428h.setColorSchemeColors(ContextCompat.getColor(requireContext(), R.color.main_blue), ContextCompat.getColor(requireContext(), R.color.main_blue_pressed));
        s().f22428h.setOnRefreshListener(new O1(this));
    }

    /* access modifiers changed from: private */
    public static final void x(P1 p12, View view) {
        if (p12.getActivity() instanceof MainActivity) {
            FragmentActivity activity = p12.getActivity();
            t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
            ((MainActivity) activity).s3();
        }
    }

    /* access modifiers changed from: private */
    public static final void y(P1 p12, View view) {
        if (p12.getActivity() instanceof MainActivity) {
            FragmentActivity activity = p12.getActivity();
            t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
            ((MainActivity) activity).U6();
        }
    }

    /* access modifiers changed from: private */
    public static final void z(P1 p12, View view) {
        if (p12.getActivity() instanceof MainActivity) {
            FragmentActivity activity = p12.getActivity();
            t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
            ((MainActivity) activity).a7();
        }
    }

    public final void B() {
        s().f22427g.smoothScrollToPosition(0);
    }

    public final void C(Drawable drawable, boolean z4) {
        if (drawable != null) {
            s().f22422b.setImageDrawable(drawable);
        }
        if (z4) {
            s().f22423c.setVisibility(0);
        } else {
            s().f22423c.setVisibility(8);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        t.e(layoutInflater, "inflater");
        RelativeLayout b5 = s().getRoot();
        t.d(b5, "getRoot(...)");
        return b5;
    }

    public void onResume() {
        super.onResume();
        t();
    }

    public void onViewCreated(View view, Bundle bundle) {
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        super.onViewCreated(view, bundle);
        v();
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new c(this, (C2308e) null), 2, (Object) null);
        C2908y0 unused2 = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), C2865c0.c(), (w3.O) null, new d(this, (C2308e) null), 2, (Object) null);
    }

    public final void r() {
        s().f22427g.setVisibility(8);
        s().f22424d.setVisibility(0);
    }

    public final void t() {
        V.b bVar = V.f24870q;
        Context requireContext = requireContext();
        t.d(requireContext, "requireContext(...)");
        if (bVar.h(requireContext) != null) {
            Q u5 = u();
            Context requireContext2 = requireContext();
            t.d(requireContext2, "requireContext(...)");
            u5.c(requireContext2);
            s().f22424d.setVisibility(8);
            return;
        }
        s().f22431k.setVisibility(8);
        s().f22425e.setVisibility(8);
        s().f22424d.setVisibility(0);
    }

    /* access modifiers changed from: private */
    public static final void w(View view) {
    }
}
