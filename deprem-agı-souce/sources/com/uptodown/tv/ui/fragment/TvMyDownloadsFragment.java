package com.uptodown.tv.ui.fragment;

import W2.J;
import W2.u;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.app.VerticalGridSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import androidx.leanback.widget.VerticalGridPresenter;
import androidx.lifecycle.LifecycleOwnerKt;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2668q;
import u2.m;
import w2.C2817L;
import w2.C2818M;
import w2.C2819N;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.I0;
import w3.M;
import w3.O;
import z2.C2940B;
import z2.F;

public final class TvMyDownloadsFragment extends VerticalGridSupportFragment implements BrowseSupportFragment.MainFragmentAdapterProvider {

    /* renamed from: d  reason: collision with root package name */
    public static final a f21271d = new a((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private ArrayObjectAdapter f21272a;

    /* renamed from: b  reason: collision with root package name */
    private AlertDialog f21273b;

    /* renamed from: c  reason: collision with root package name */
    private final BrowseSupportFragment.MainFragmentAdapter f21274c = new d(this);

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    private final class b implements OnItemViewClickedListener {
        public b() {
        }

        /* renamed from: a */
        public void onItemClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
            if (obj instanceof C2668q) {
                TvMyDownloadsFragment.this.n((C2668q) obj);
            }
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21276a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvMyDownloadsFragment f21277b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ ArrayList f21278c;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21279a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ TvMyDownloadsFragment f21280b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ ArrayList f21281c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(TvMyDownloadsFragment tvMyDownloadsFragment, ArrayList arrayList, C2308e eVar) {
                super(2, eVar);
                this.f21280b = tvMyDownloadsFragment;
                this.f21281c = arrayList;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21280b, this.f21281c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21279a == 0) {
                    u.b(obj);
                    this.f21280b.q(this.f21281c);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(TvMyDownloadsFragment tvMyDownloadsFragment, ArrayList arrayList, C2308e eVar) {
            super(2, eVar);
            this.f21277b = tvMyDownloadsFragment;
            this.f21278c = arrayList;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f21277b, this.f21278c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21276a;
            if (i5 == 0) {
                u.b(obj);
                C2940B.a aVar = C2940B.f26458v;
                Context requireContext = this.f21277b.requireContext();
                t.d(requireContext, "requireContext(...)");
                C2940B a5 = aVar.a(requireContext);
                a5.a();
                Iterator it = a5.p0().iterator();
                t.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    t.d(next, "next(...)");
                    C2668q qVar = (C2668q) next;
                    if (qVar.P()) {
                        this.f21278c.add(qVar);
                    }
                }
                I0 c5 = C2865c0.c();
                a aVar2 = new a(this.f21277b, this.f21278c, (C2308e) null);
                this.f21276a = 1;
                if (C2872g.g(c5, aVar2, this) == f5) {
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
            return ((c) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    public static final class d extends BrowseSupportFragment.MainFragmentAdapter {
        d(TvMyDownloadsFragment tvMyDownloadsFragment) {
            super(tvMyDownloadsFragment);
        }

        public void setEntranceTransitionState(boolean z4) {
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21282a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvMyDownloadsFragment f21283b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(TvMyDownloadsFragment tvMyDownloadsFragment, C2308e eVar) {
            super(2, eVar);
            this.f21283b = tvMyDownloadsFragment;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f21283b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21282a;
            if (i5 == 0) {
                u.b(obj);
                TvMyDownloadsFragment tvMyDownloadsFragment = this.f21283b;
                this.f21282a = 1;
                if (tvMyDownloadsFragment.r(this) == f5) {
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

    private final void l(String str) {
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setMessage(str);
            builder.setPositiveButton(17039370, new C2819N());
            builder.setCancelable(true);
            builder.create().show();
        }
    }

    /* access modifiers changed from: private */
    public static final void m(DialogInterface dialogInterface, int i5) {
        t.e(dialogInterface, "dialogInterface");
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    public final void n(C2668q qVar) {
        AlertDialog alertDialog = this.f21273b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        if (getActivity() != null && !requireActivity().isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
            LayoutInflater layoutInflater = getLayoutInflater();
            t.d(layoutInflater, "getLayoutInflater(...)");
            View inflate = layoutInflater.inflate(R.layout.tv_apk_clicked_dialog, (ViewGroup) null, false);
            ((TextView) inflate.findViewById(R.id.tv_install)).setOnClickListener(new C2817L(qVar, this));
            ((TextView) inflate.findViewById(R.id.tv_delete)).setOnClickListener(new C2818M(qVar, this));
            builder.setView(inflate);
            AlertDialog create = builder.create();
            this.f21273b = create;
            if (create != null) {
                create.show();
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void o(C2668q qVar, TvMyDownloadsFragment tvMyDownloadsFragment, View view) {
        File n5;
        if (qVar.f() && (n5 = qVar.n()) != null) {
            UptodownApp.a aVar = UptodownApp.f13477F;
            FragmentActivity requireActivity = tvMyDownloadsFragment.requireActivity();
            t.d(requireActivity, "requireActivity(...)");
            UptodownApp.a.X(aVar, n5, requireActivity, (String) null, 4, (Object) null);
        }
        AlertDialog alertDialog = tvMyDownloadsFragment.f21273b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final void p(C2668q qVar, TvMyDownloadsFragment tvMyDownloadsFragment, View view) {
        qVar.g();
        C2940B.a aVar = C2940B.f26458v;
        Context requireContext = tvMyDownloadsFragment.requireContext();
        t.d(requireContext, "requireContext(...)");
        C2940B a5 = aVar.a(requireContext);
        a5.a();
        a5.A(qVar);
        a5.m();
        ArrayObjectAdapter arrayObjectAdapter = tvMyDownloadsFragment.f21272a;
        t.b(arrayObjectAdapter);
        arrayObjectAdapter.remove(qVar);
        AlertDialog alertDialog = tvMyDownloadsFragment.f21273b;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public final void q(ArrayList arrayList) {
        ArrayObjectAdapter arrayObjectAdapter = this.f21272a;
        t.b(arrayObjectAdapter);
        arrayObjectAdapter.clear();
        Iterator it = arrayList.iterator();
        t.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            t.d(next, "next(...)");
            ArrayObjectAdapter arrayObjectAdapter2 = this.f21272a;
            t.b(arrayObjectAdapter2);
            arrayObjectAdapter2.add((C2668q) next);
        }
        ArrayObjectAdapter arrayObjectAdapter3 = this.f21272a;
        t.b(arrayObjectAdapter3);
        if (arrayObjectAdapter3.size() == 0 && getContext() != null) {
            l(getString(R.string.no_data_available));
        }
    }

    /* access modifiers changed from: private */
    public final Object r(C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new c(this, new ArrayList(), (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    private final void s() {
        VerticalGridPresenter verticalGridPresenter = new VerticalGridPresenter();
        verticalGridPresenter.setNumberOfColumns(2);
        setGridPresenter(verticalGridPresenter);
        startEntranceTransition();
        setOnItemViewClickedListener(new b());
    }

    public BrowseSupportFragment.MainFragmentAdapter getMainFragmentAdapter() {
        return this.f21274c;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        F f5 = new F(getContext());
        String simpleName = TvMyDownloadsFragment.class.getSimpleName();
        t.d(simpleName, "getSimpleName(...)");
        f5.f(simpleName);
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((Presenter) new m());
        this.f21272a = arrayObjectAdapter;
        setAdapter(arrayObjectAdapter);
        setTitle(getString(R.string.downloads_title));
        if (bundle == null) {
            prepareEntranceTransition();
        }
        s();
    }

    public void onPause() {
        C2940B.a aVar = C2940B.f26458v;
        Context requireContext = requireContext();
        t.d(requireContext, "requireContext(...)");
        C2940B a5 = aVar.a(requireContext);
        a5.a();
        a5.u1();
        a5.m();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        Context context = getContext();
        if (context != null) {
            z2.M.f26506a.h(context);
        }
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), (C2312i) null, (O) null, new e(this, (C2308e) null), 3, (Object) null);
    }

    public final void t(int i5) {
        switch (i5) {
            case 201:
                ArrayObjectAdapter arrayObjectAdapter = this.f21272a;
                t.b(arrayObjectAdapter);
                ArrayObjectAdapter arrayObjectAdapter2 = this.f21272a;
                t.b(arrayObjectAdapter2);
                arrayObjectAdapter.notifyArrayItemRangeChanged(0, arrayObjectAdapter2.size());
                return;
            case 202:
            case 203:
                ArrayObjectAdapter arrayObjectAdapter3 = this.f21272a;
                t.b(arrayObjectAdapter3);
                ArrayObjectAdapter arrayObjectAdapter4 = this.f21272a;
                t.b(arrayObjectAdapter4);
                arrayObjectAdapter3.notifyArrayItemRangeChanged(0, arrayObjectAdapter4.size());
                return;
            default:
                return;
        }
    }
}
