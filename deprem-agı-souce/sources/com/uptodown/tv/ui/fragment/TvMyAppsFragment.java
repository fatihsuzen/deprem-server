package com.uptodown.tv.ui.fragment;

import S1.j;
import S1.k;
import W2.J;
import W2.u;
import X2.C2250q;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.app.VerticalGridSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import androidx.leanback.widget.VerticalGridPresenter;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import b2.C2290j;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.tv.ui.activity.TvOldVersionsActivity;
import g2.C2388j;
import java.util.ArrayList;
import java.util.Iterator;
import k2.C2610u;
import k3.p;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.t;
import l2.C2646F;
import l2.C2655d;
import l2.C2657f;
import l2.T;
import t3.s;
import u2.l;
import v2.C2802b;
import w2.C2806A;
import w2.C2807B;
import w2.C2808C;
import w2.C2809D;
import w2.C2810E;
import w2.C2811F;
import w2.C2812G;
import w2.C2813H;
import w2.C2814I;
import w2.C2815J;
import w2.C2816K;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.I0;
import w3.M;
import w3.O;
import z2.C2940B;
import z2.C2954m;
import z2.E;
import z2.F;

public final class TvMyAppsFragment extends VerticalGridSupportFragment {

    /* renamed from: a  reason: collision with root package name */
    private final LifecycleCoroutineScope f21253a = LifecycleOwnerKt.getLifecycleScope(this);

    /* renamed from: b  reason: collision with root package name */
    private ArrayObjectAdapter f21254b;

    /* renamed from: c  reason: collision with root package name */
    private AlertDialog f21255c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f21256d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public boolean f21257e;

    /* renamed from: f  reason: collision with root package name */
    private final int f21258f = 5;

    private static final class a extends ArrayObjectAdapter {
        public a(l lVar) {
            super((Presenter) lVar);
        }
    }

    private final class b implements OnItemViewClickedListener {
        public b() {
        }

        /* renamed from: a */
        public void onItemClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
            t.e(viewHolder, "itemViewHolder");
            t.e(obj, "item");
            if (!(obj instanceof C2655d)) {
                return;
            }
            if (TvMyAppsFragment.this.f21257e) {
                TvMyAppsFragment.this.K((C2655d) obj);
            } else if (TvMyAppsFragment.this.f21256d) {
                TvMyAppsFragment.this.J(((C2655d) obj).b(), viewHolder);
            } else {
                TvMyAppsFragment.this.B((C2655d) obj, viewHolder);
            }
        }
    }

    public static final class c implements C2610u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TvMyAppsFragment f21260a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Presenter.ViewHolder f21261b;

        c(TvMyAppsFragment tvMyAppsFragment, Presenter.ViewHolder viewHolder) {
            this.f21260a = tvMyAppsFragment;
            this.f21261b = viewHolder;
        }

        public void c(C2657f fVar) {
            t.e(fVar, "appInfo");
            if (this.f21260a.getActivity() != null) {
                C2802b bVar = (C2802b) this.f21260a.getActivity();
                t.b(bVar);
                bVar.m(fVar, this.f21261b);
            }
        }

        public void d(int i5) {
        }
    }

    public static final class d implements C2610u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TvMyAppsFragment f21262a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2655d f21263b;

        d(TvMyAppsFragment tvMyAppsFragment, C2655d dVar) {
            this.f21262a = tvMyAppsFragment;
            this.f21263b = dVar;
        }

        public void c(C2657f fVar) {
            Bundle bundle;
            t.e(fVar, "appInfo");
            if (this.f21262a.getActivity() != null) {
                Intent intent = new Intent(this.f21262a.getContext(), TvOldVersionsActivity.class);
                intent.putExtra("appInfo", fVar);
                intent.putExtra(MBridgeConstans.DYNAMIC_VIEW_WX_APP, this.f21263b);
                TvMyAppsFragment tvMyAppsFragment = this.f21262a;
                FragmentActivity activity = tvMyAppsFragment.getActivity();
                if (activity != null) {
                    bundle = UptodownApp.f13477F.a(activity);
                } else {
                    bundle = null;
                }
                tvMyAppsFragment.startActivity(intent, bundle);
            }
        }

        public void d(int i5) {
        }
    }

    static final class e extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21264a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvMyAppsFragment f21265b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(TvMyAppsFragment tvMyAppsFragment, C2308e eVar) {
            super(2, eVar);
            this.f21265b = tvMyAppsFragment;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f21265b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21264a;
            if (i5 == 0) {
                u.b(obj);
                TvMyAppsFragment tvMyAppsFragment = this.f21265b;
                this.f21264a = 1;
                if (tvMyAppsFragment.M(this) == f5) {
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
            return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class f extends kotlin.coroutines.jvm.internal.l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21266a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvMyAppsFragment f21267b;

        static final class a extends kotlin.coroutines.jvm.internal.l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21268a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ TvMyAppsFragment f21269b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ L f21270c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(TvMyAppsFragment tvMyAppsFragment, L l5, C2308e eVar) {
                super(2, eVar);
                this.f21269b = tvMyAppsFragment;
                this.f21270c = l5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21269b, this.f21270c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21268a == 0) {
                    u.b(obj);
                    this.f21269b.N((ArrayList) this.f21270c.f24690a);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(TvMyAppsFragment tvMyAppsFragment, C2308e eVar) {
            super(2, eVar);
            this.f21267b = tvMyAppsFragment;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new f(this.f21267b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21266a;
            if (i5 == 0) {
                u.b(obj);
                if (this.f21267b.getContext() != null) {
                    L l5 = new L();
                    if (this.f21267b.f21256d) {
                        TvMyAppsFragment tvMyAppsFragment = this.f21267b;
                        Context requireContext = tvMyAppsFragment.requireContext();
                        t.d(requireContext, "requireContext(...)");
                        l5.f24690a = tvMyAppsFragment.O(requireContext);
                    } else {
                        C2954m mVar = new C2954m();
                        Context requireContext2 = this.f21267b.requireContext();
                        t.d(requireContext2, "requireContext(...)");
                        l5.f24690a = mVar.D(requireContext2);
                        ArrayList arrayList = new ArrayList();
                        Iterator it = ((ArrayList) l5.f24690a).iterator();
                        t.d(it, "iterator(...)");
                        while (it.hasNext()) {
                            Object next = it.next();
                            t.d(next, "next(...)");
                            C2655d dVar = (C2655d) next;
                            if (this.f21267b.getContext() != null) {
                                if (s.E(this.f21267b.requireContext().getPackageName(), dVar.o(), true)) {
                                    arrayList.add(dVar);
                                } else {
                                    Context requireContext3 = this.f21267b.requireContext();
                                    t.d(requireContext3, "requireContext(...)");
                                    if (dVar.C(requireContext3)) {
                                        C2290j jVar = new C2290j();
                                        Context requireContext4 = this.f21267b.requireContext();
                                        t.d(requireContext4, "requireContext(...)");
                                        String o5 = dVar.o();
                                        t.b(o5);
                                        if (!jVar.p(requireContext4, o5)) {
                                            arrayList.add(dVar);
                                        }
                                    }
                                }
                            }
                        }
                        l5.f24690a = arrayList;
                    }
                    ArrayList unused = this.f21267b.P((ArrayList) l5.f24690a);
                    I0 c5 = C2865c0.c();
                    a aVar = new a(this.f21267b, l5, (C2308e) null);
                    this.f21266a = 1;
                    if (C2872g.g(c5, aVar, this) == f5) {
                        return f5;
                    }
                }
            } else if (i5 == 1) {
                u.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return J.f19942a;
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((f) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* access modifiers changed from: private */
    public static final void A(DialogInterface dialogInterface, int i5) {
        t.e(dialogInterface, "dialogInterface");
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    public final void B(C2655d dVar, Presenter.ViewHolder viewHolder) {
        boolean z4;
        if (!getParentFragmentManager().isDestroyed() && dVar != null) {
            AlertDialog.Builder builder = new AlertDialog.Builder(requireContext());
            LayoutInflater layoutInflater = getLayoutInflater();
            t.d(layoutInflater, "getLayoutInflater(...)");
            View inflate = layoutInflater.inflate(R.layout.tv_dialog_app_selected, (ViewGroup) null, false);
            TextView textView = (TextView) inflate.findViewById(R.id.tv_title_das);
            k.a aVar = k.f32g;
            textView.setTypeface(aVar.w());
            textView.setText(dVar.m());
            TextView textView2 = (TextView) inflate.findViewById(R.id.tv_see_on_uptodown);
            if (dVar.b() > 0) {
                textView2.setTypeface(aVar.x());
                textView2.setOnClickListener(new C2812G(this, dVar, viewHolder));
                z4 = true;
            } else {
                textView2.setVisibility(8);
                z4 = false;
            }
            TextView textView3 = (TextView) inflate.findViewById(R.id.tv_open);
            TextView textView4 = (TextView) inflate.findViewById(R.id.tv_uninstall);
            if (getContext() == null || s.E(requireContext().getPackageName(), dVar.o(), true)) {
                textView3.setVisibility(8);
                textView4.setVisibility(8);
            } else {
                textView3.setTypeface(aVar.x());
                textView3.setOnClickListener(new C2813H(dVar, this));
                if (!dVar.F()) {
                    textView4.setTypeface(aVar.x());
                    textView4.setOnClickListener(new C2814I(dVar, this));
                } else {
                    textView4.setVisibility(8);
                }
                z4 = true;
            }
            if (UptodownApp.f13477F.K()) {
                textView3.setText("Debug Info App");
                textView3.setOnClickListener(new C2815J(dVar, this));
                textView3.setVisibility(0);
                z4 = true;
            }
            TextView textView5 = (TextView) inflate.findViewById(R.id.tv_old_versions);
            if (getContext() == null || s.E(requireContext().getPackageName(), dVar.o(), true)) {
                textView5.setVisibility(8);
            } else {
                textView5.setTypeface(aVar.x());
                textView5.setOnClickListener(new C2816K(this, dVar));
            }
            TextView textView6 = (TextView) inflate.findViewById(R.id.tv_exclude);
            if (dVar.e() == 0) {
                textView6.setText(getString(R.string.not_offer_updates));
            } else {
                textView6.setText(getString(R.string.offer_updates_again));
            }
            textView6.setTypeface(aVar.x());
            textView6.setOnClickListener(new C2807B(this, dVar));
            if (z4) {
                builder.setView(inflate);
                AlertDialog create = builder.create();
                this.f21255c = create;
                t.b(create);
                create.show();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void C(TvMyAppsFragment tvMyAppsFragment, C2655d dVar, View view) {
        AlertDialog alertDialog = tvMyAppsFragment.f21255c;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        C2940B.a aVar = C2940B.f26458v;
        Context requireContext = tvMyAppsFragment.requireContext();
        t.d(requireContext, "requireContext(...)");
        C2940B a5 = aVar.a(requireContext);
        a5.a();
        if (dVar.e() == 0) {
            dVar.N(1);
            dVar.c0(C2655d.c.UPDATED);
            String o5 = dVar.o();
            t.b(o5);
            a5.R(o5);
            E e5 = new E();
            Context requireContext2 = tvMyAppsFragment.requireContext();
            t.d(requireContext2, "requireContext(...)");
            e5.c(requireContext2);
        } else {
            dVar.N(0);
        }
        a5.v1(dVar);
        a5.m();
    }

    /* access modifiers changed from: private */
    public static final void D(TvMyAppsFragment tvMyAppsFragment, C2655d dVar, Presenter.ViewHolder viewHolder, View view) {
        tvMyAppsFragment.J(dVar.b(), viewHolder);
        AlertDialog alertDialog = tvMyAppsFragment.f21255c;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final void E(C2655d dVar, TvMyAppsFragment tvMyAppsFragment, View view) {
        try {
            if (dVar.o() != null) {
                PackageManager packageManager = tvMyAppsFragment.requireContext().getPackageManager();
                String o5 = dVar.o();
                t.b(o5);
                Intent leanbackLaunchIntentForPackage = packageManager.getLeanbackLaunchIntentForPackage(o5);
                if (leanbackLaunchIntentForPackage == null) {
                    PackageManager packageManager2 = tvMyAppsFragment.requireContext().getPackageManager();
                    String o6 = dVar.o();
                    t.b(o6);
                    leanbackLaunchIntentForPackage = packageManager2.getLaunchIntentForPackage(o6);
                }
                if (leanbackLaunchIntentForPackage != null) {
                    tvMyAppsFragment.startActivity(leanbackLaunchIntentForPackage);
                }
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        AlertDialog alertDialog = tvMyAppsFragment.f21255c;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final void F(C2655d dVar, TvMyAppsFragment tvMyAppsFragment, View view) {
        if (dVar.o() != null) {
            Context requireContext = tvMyAppsFragment.requireContext();
            t.d(requireContext, "requireContext(...)");
            j jVar = new j(requireContext);
            String o5 = dVar.o();
            t.b(o5);
            jVar.h(o5);
        }
        AlertDialog alertDialog = tvMyAppsFragment.f21255c;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final void G(C2655d dVar, TvMyAppsFragment tvMyAppsFragment, View view) {
        Bundle bundle;
        if (dVar.o() != null) {
            Intent intent = new Intent(tvMyAppsFragment.getContext(), P1.b.class);
            intent.putExtra("AppIndex", dVar.o());
            FragmentActivity activity = tvMyAppsFragment.getActivity();
            if (activity != null) {
                bundle = UptodownApp.f13477F.a(activity);
            } else {
                bundle = null;
            }
            tvMyAppsFragment.startActivity(intent, bundle);
        }
        AlertDialog alertDialog = tvMyAppsFragment.f21255c;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final void H(TvMyAppsFragment tvMyAppsFragment, C2655d dVar, View view) {
        tvMyAppsFragment.K(dVar);
        AlertDialog alertDialog = tvMyAppsFragment.f21255c;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public final void J(long j5, Presenter.ViewHolder viewHolder) {
        Context requireContext = requireContext();
        t.d(requireContext, "requireContext(...)");
        new C2388j(requireContext, j5, new c(this, viewHolder), LifecycleOwnerKt.getLifecycleScope(this));
    }

    /* access modifiers changed from: private */
    public final void K(C2655d dVar) {
        Context requireContext = requireContext();
        t.d(requireContext, "requireContext(...)");
        new C2388j(requireContext, dVar.b(), new d(this, dVar), LifecycleOwnerKt.getLifecycleScope(this));
    }

    private final void L() {
        C2908y0 unused = C2876i.d(this.f21253a, (C2312i) null, (O) null, new e(this, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final Object M(C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new f(this, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final void N(ArrayList arrayList) {
        ArrayObjectAdapter arrayObjectAdapter = this.f21254b;
        t.b(arrayObjectAdapter);
        arrayObjectAdapter.clear();
        if (arrayList != null && !arrayList.isEmpty()) {
            int size = arrayList.size();
            for (int i5 = 0; i5 < size; i5++) {
                ArrayObjectAdapter arrayObjectAdapter2 = this.f21254b;
                t.b(arrayObjectAdapter2);
                arrayObjectAdapter2.add(arrayList.get(i5));
            }
        }
        ArrayObjectAdapter arrayObjectAdapter3 = this.f21254b;
        t.b(arrayObjectAdapter3);
        if (arrayObjectAdapter3.size() == 0 && getContext() != null) {
            z(getString(R.string.no_data_available));
        }
    }

    /* access modifiers changed from: private */
    public final ArrayList O(Context context) {
        ArrayList D4 = new C2954m().D(context);
        C2940B a5 = C2940B.f26458v.a(context);
        a5.a();
        ArrayList arrayList = new ArrayList();
        Iterator it = D4.iterator();
        t.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            t.d(next, "next(...)");
            C2655d dVar = (C2655d) next;
            if (dVar.C(context)) {
                if (dVar.e() == 1) {
                    dVar.c0(C2655d.c.OUTDATED);
                } else {
                    String o5 = dVar.o();
                    t.b(o5);
                    T G02 = a5.G0(o5);
                    if (G02 == null) {
                        if (dVar.D()) {
                            dVar.c0(C2655d.c.UPDATED);
                        }
                    } else if (G02.e() != 1) {
                        dVar.c0(C2655d.c.OUTDATED);
                        C2290j jVar = new C2290j();
                        String o6 = dVar.o();
                        t.b(o6);
                        if (!jVar.p(context, o6) && G02.e() == 0) {
                            arrayList.add(dVar);
                        }
                    }
                    if (G02 != null && G02.g() == 0) {
                        G02.s(1);
                        a5.C1(G02);
                    }
                }
            }
            UptodownApp.a aVar = UptodownApp.f13477F;
            if (aVar.t() != null) {
                ArrayList t5 = aVar.t();
                t.b(t5);
                Iterator it2 = t5.iterator();
                t.d(it2, "iterator(...)");
                while (it2.hasNext()) {
                    Object next2 = it2.next();
                    t.d(next2, "next(...)");
                    C2646F f5 = (C2646F) next2;
                    if (t.a(f5.c(), dVar.r())) {
                        dVar.X(f5);
                    }
                }
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public final ArrayList P(ArrayList arrayList) {
        C2250q.t(arrayList, new C2806A());
        if (getContext() != null) {
            C2940B.a aVar = C2940B.f26458v;
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            C2940B a5 = aVar.a(requireContext);
            a5.a();
            ArrayList I02 = a5.I0();
            a5.m();
            Iterator it = I02.iterator();
            t.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                t.d(next, "next(...)");
                T t5 = (T) next;
                int size = arrayList.size();
                for (int i5 = 0; i5 < size; i5++) {
                    if (s.E(t5.h(), ((C2655d) arrayList.get(i5)).o(), true) && t5.j() > ((C2655d) arrayList.get(i5)).A()) {
                        ((C2655d) arrayList.get(i5)).c0(C2655d.c.OUTDATED);
                    }
                }
            }
        }
        C2250q.t(arrayList, new C2809D(new C2808C()));
        if (getContext() != null) {
            String packageName = requireContext().getPackageName();
            int i6 = 0;
            while (i6 < arrayList.size() && (!s.E(packageName, ((C2655d) arrayList.get(i6)).o(), true) || ((C2655d) arrayList.get(i6)).w() != C2655d.c.OUTDATED)) {
                i6++;
            }
            if (i6 < arrayList.size()) {
                Object remove = arrayList.remove(i6);
                t.d(remove, "removeAt(...)");
                arrayList.add(0, (C2655d) remove);
            }
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public static final int Q(C2655d dVar, C2655d dVar2) {
        t.e(dVar, "app1");
        t.e(dVar2, "app2");
        if (dVar.m() == null) {
            return 1;
        }
        if (dVar2.m() == null) {
            return -1;
        }
        String m5 = dVar.m();
        t.b(m5);
        String m6 = dVar2.m();
        t.b(m6);
        return s.x(m5, m6, true);
    }

    /* access modifiers changed from: private */
    public static final int R(C2655d dVar, C2655d dVar2) {
        t.e(dVar, "app1");
        t.e(dVar2, "app2");
        return dVar.w().compareTo(dVar2.w());
    }

    /* access modifiers changed from: private */
    public static final int S(p pVar, Object obj, Object obj2) {
        return ((Number) pVar.invoke(obj, obj2)).intValue();
    }

    private final void T() {
        VerticalGridPresenter verticalGridPresenter = new VerticalGridPresenter();
        verticalGridPresenter.setNumberOfColumns(this.f21258f);
        setGridPresenter(verticalGridPresenter);
        new Handler(Looper.getMainLooper()).postDelayed(new C2811F(this), 500);
        setOnItemViewClickedListener(new b());
    }

    /* access modifiers changed from: private */
    public static final void U(TvMyAppsFragment tvMyAppsFragment) {
        tvMyAppsFragment.startEntranceTransition();
    }

    private final void z(String str) {
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setMessage(str);
            builder.setPositiveButton(17039370, new C2810E());
            builder.setCancelable(true);
            builder.create().show();
        }
    }

    public final void I() {
        L();
    }

    public void onCreate(Bundle bundle) {
        Bundle extras;
        super.onCreate(bundle);
        F f5 = new F(getContext());
        String simpleName = TvMyAppsFragment.class.getSimpleName();
        t.d(simpleName, "getSimpleName(...)");
        f5.f(simpleName);
        a aVar = new a(new l());
        this.f21254b = aVar;
        setAdapter(aVar);
        FragmentActivity activity = getActivity();
        if (!(activity == null || (extras = activity.getIntent().getExtras()) == null)) {
            if (extras.containsKey("updates")) {
                this.f21256d = extras.getBoolean("updates");
            }
            if (extras.containsKey("rollback")) {
                this.f21257e = extras.getBoolean("rollback");
            }
        }
        if (this.f21256d) {
            setTitle(getString(R.string.updates));
        } else if (this.f21257e) {
            setTitle(getString(R.string.rollback_title));
        } else {
            setTitle(getString(R.string.installed));
        }
        if (bundle == null) {
            prepareEntranceTransition();
        }
        T();
    }

    public void onResume() {
        super.onResume();
        L();
    }
}
