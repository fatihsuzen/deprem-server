package com.uptodown.tv.ui.fragment;

import S1.j;
import W2.J;
import W2.u;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Parcelable;
import android.widget.Toast;
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
import b2.C2301u;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import com.uptodown.workers.DownloadApkWorker;
import com.uptodown.workers.DownloadWorker;
import g2.C2387i;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import k2.C2584A;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.Q;
import kotlin.jvm.internal.t;
import l2.C2643C;
import l2.C2655d;
import l2.C2657f;
import l2.C2668q;
import u2.n;
import w2.C2820O;
import w2.C2821P;
import w2.C2822Q;
import w3.C2865c0;
import w3.C2908y0;
import w3.M;
import w3.N;
import w3.O;
import z2.C2940B;
import z2.C2954m;
import z2.E;
import z2.F;

public final class TvOldVersionsFragment extends VerticalGridSupportFragment {

    /* renamed from: e  reason: collision with root package name */
    public static final a f21284e = new a((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public C2657f f21285a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public C2655d f21286b;

    /* renamed from: c  reason: collision with root package name */
    private AlertDialog f21287c;

    /* renamed from: d  reason: collision with root package name */
    private b f21288d;

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    private static final class b extends ArrayObjectAdapter {
        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(n nVar) {
            super((Presenter) nVar);
            t.e(nVar, "presenter");
        }
    }

    private final class c implements OnItemViewClickedListener {
        public c() {
        }

        /* renamed from: a */
        public void onItemClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
            if (obj instanceof C2643C) {
                if (TvOldVersionsFragment.this.f21286b != null) {
                    long h5 = ((C2643C) obj).h();
                    C2655d j5 = TvOldVersionsFragment.this.f21286b;
                    t.b(j5);
                    if (h5 == j5.A()) {
                        return;
                    }
                }
                C2940B.a aVar = C2940B.f26458v;
                Context requireContext = TvOldVersionsFragment.this.requireContext();
                t.d(requireContext, "requireContext(...)");
                C2940B a5 = aVar.a(requireContext);
                a5.a();
                C2657f k5 = TvOldVersionsFragment.this.f21285a;
                t.b(k5);
                String S4 = k5.S();
                t.b(S4);
                C2643C c5 = (C2643C) obj;
                C2668q k02 = a5.k0(S4, c5.h());
                a5.m();
                if (k02 != null) {
                    DownloadWorker.a aVar2 = DownloadWorker.f21359d;
                    if (!aVar2.m(k02)) {
                        if (!k02.f() || k02.i() == null) {
                            C2657f k6 = TvOldVersionsFragment.this.f21285a;
                            t.b(k6);
                            k02.c(k6);
                            TvOldVersionsFragment.this.r(k02);
                            return;
                        }
                        TvOldVersionsFragment tvOldVersionsFragment = TvOldVersionsFragment.this;
                        C2657f k7 = tvOldVersionsFragment.f21285a;
                        t.b(k7);
                        String S5 = k7.S();
                        long E4 = k02.E();
                        String i5 = k02.i();
                        t.b(i5);
                        tvOldVersionsFragment.v(S5, E4, i5);
                    } else if (k02.w() != null) {
                        String w4 = k02.w();
                        t.b(w4);
                        aVar2.c(w4);
                    } else if (k02.h() > 0) {
                        aVar2.d(k02.h());
                    }
                } else {
                    C2668q qVar = new C2668q();
                    C2657f k8 = TvOldVersionsFragment.this.f21285a;
                    t.b(k8);
                    qVar.d(k8, c5);
                    TvOldVersionsFragment.this.r(qVar);
                }
            }
        }
    }

    static final class d extends kotlin.coroutines.jvm.internal.d {

        /* renamed from: a  reason: collision with root package name */
        Object f21290a;

        /* renamed from: b  reason: collision with root package name */
        /* synthetic */ Object f21291b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ TvOldVersionsFragment f21292c;

        /* renamed from: d  reason: collision with root package name */
        int f21293d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(TvOldVersionsFragment tvOldVersionsFragment, C2308e eVar) {
            super(eVar);
            this.f21292c = tvOldVersionsFragment;
        }

        public final Object invokeSuspend(Object obj) {
            this.f21291b = obj;
            this.f21293d |= Integer.MIN_VALUE;
            return this.f21292c.s(this);
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21294a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvOldVersionsFragment f21295b;

        public static final class a implements C2584A {

            /* renamed from: a  reason: collision with root package name */
            final /* synthetic */ TvOldVersionsFragment f21296a;

            a(TvOldVersionsFragment tvOldVersionsFragment) {
                this.f21296a = tvOldVersionsFragment;
            }

            public void a(ArrayList arrayList) {
                t.e(arrayList, "oldVersions");
                C2657f k5 = this.f21296a.f21285a;
                t.b(k5);
                k5.U0(arrayList);
                C2657f k6 = this.f21296a.f21285a;
                t.b(k6);
                if (k6.Q() != null) {
                    TvOldVersionsFragment tvOldVersionsFragment = this.f21296a;
                    C2657f k7 = tvOldVersionsFragment.f21285a;
                    t.b(k7);
                    ArrayList Q4 = k7.Q();
                    t.b(Q4);
                    tvOldVersionsFragment.u(Q4);
                }
            }

            public void b() {
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(TvOldVersionsFragment tvOldVersionsFragment, C2308e eVar) {
            super(2, eVar);
            this.f21295b = tvOldVersionsFragment;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f21295b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            int i5;
            C2316b.f();
            if (this.f21294a == 0) {
                u.b(obj);
                if (!(this.f21295b.f21285a == null || this.f21295b.getContext() == null)) {
                    C2657f k5 = this.f21295b.f21285a;
                    t.b(k5);
                    if (k5.Q() != null) {
                        C2657f k6 = this.f21295b.f21285a;
                        t.b(k6);
                        ArrayList Q4 = k6.Q();
                        t.b(Q4);
                        if (Q4.size() != 0) {
                            C2657f k7 = this.f21295b.f21285a;
                            t.b(k7);
                            ArrayList Q5 = k7.Q();
                            t.b(Q5);
                            i5 = Q5.size();
                            int i6 = i5;
                            LifecycleCoroutineScope lifecycleScope = LifecycleOwnerKt.getLifecycleScope(this.f21295b);
                            Context requireContext = this.f21295b.requireContext();
                            t.d(requireContext, "requireContext(...)");
                            C2657f k8 = this.f21295b.f21285a;
                            t.b(k8);
                            new C2387i(lifecycleScope, requireContext, k8, new a(this.f21295b), i6);
                        }
                    }
                    i5 = 0;
                    int i62 = i5;
                    LifecycleCoroutineScope lifecycleScope2 = LifecycleOwnerKt.getLifecycleScope(this.f21295b);
                    Context requireContext2 = this.f21295b.requireContext();
                    t.d(requireContext2, "requireContext(...)");
                    C2657f k82 = this.f21295b.f21285a;
                    t.b(k82);
                    new C2387i(lifecycleScope2, requireContext2, k82, new a(this.f21295b), i62);
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class f extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21297a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvOldVersionsFragment f21298b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        f(TvOldVersionsFragment tvOldVersionsFragment, C2308e eVar) {
            super(2, eVar);
            this.f21298b = tvOldVersionsFragment;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new f(this.f21298b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            C2316b.f();
            if (this.f21297a == 0) {
                u.b(obj);
                try {
                    if (this.f21298b.f21285a != null) {
                        C2657f k5 = this.f21298b.f21285a;
                        t.b(k5);
                        if (k5.Q() != null) {
                            TvOldVersionsFragment tvOldVersionsFragment = this.f21298b;
                            C2657f k6 = tvOldVersionsFragment.f21285a;
                            t.b(k6);
                            ArrayList Q4 = k6.Q();
                            t.b(Q4);
                            tvOldVersionsFragment.u(Q4);
                        }
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
                return J.f19942a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }

        public final Object invoke(M m5, C2308e eVar) {
            return ((f) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class g extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21299a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvOldVersionsFragment f21300b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        g(TvOldVersionsFragment tvOldVersionsFragment, C2308e eVar) {
            super(2, eVar);
            this.f21300b = tvOldVersionsFragment;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new g(this.f21300b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21299a;
            if (i5 == 0) {
                u.b(obj);
                TvOldVersionsFragment tvOldVersionsFragment = this.f21300b;
                this.f21299a = 1;
                if (tvOldVersionsFragment.s(this) == f5) {
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

    private final void o(String str) {
        AlertDialog alertDialog = this.f21287c;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle(getString(R.string.warning_title));
        builder.setMessage(R.string.msg_warning_old_versions);
        builder.setCancelable(false);
        builder.setPositiveButton(17039370, new C2821P(this, str));
        builder.setNegativeButton(17039360, new C2822Q());
        AlertDialog create = builder.create();
        this.f21287c = create;
        if (create != null) {
            create.show();
        }
    }

    /* access modifiers changed from: private */
    public static final void p(TvOldVersionsFragment tvOldVersionsFragment, String str, DialogInterface dialogInterface, int i5) {
        t.e(dialogInterface, "dialog");
        dialogInterface.dismiss();
        tvOldVersionsFragment.y(str);
    }

    /* access modifiers changed from: private */
    public static final void q(DialogInterface dialogInterface, int i5) {
        t.e(dialogInterface, "dialog");
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    public final void r(C2668q qVar) {
        Context requireContext = requireContext();
        t.d(requireContext, "requireContext(...)");
        int S4 = qVar.S(requireContext);
        if (S4 >= 0) {
            DownloadApkWorker.a aVar = DownloadApkWorker.f21342i;
            Context requireContext2 = requireContext();
            t.d(requireContext2, "requireContext(...)");
            if (!aVar.b(requireContext2, S4)) {
                Context context = getContext();
                Q q5 = Q.f24695a;
                String string = getString(R.string.msg_added_to_downlads_queue);
                t.d(string, "getString(...)");
                C2657f fVar = this.f21285a;
                t.b(fVar);
                String format = String.format(string, Arrays.copyOf(new Object[]{fVar.N()}, 1));
                t.d(format, "format(...)");
                Toast.makeText(context, format, 1).show();
                return;
            }
            return;
        }
        Context context2 = getContext();
        Toast.makeText(context2, getString(R.string.error_cant_enqueue_download) + " (108)", 1).show();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0066, code lost:
        if (w3.C2872g.g(r7, r4, r0) != r1) goto L_0x0069;
     */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0025  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Object s(b3.C2308e r7) {
        /*
            r6 = this;
            boolean r0 = r7 instanceof com.uptodown.tv.ui.fragment.TvOldVersionsFragment.d
            if (r0 == 0) goto L_0x0013
            r0 = r7
            com.uptodown.tv.ui.fragment.TvOldVersionsFragment$d r0 = (com.uptodown.tv.ui.fragment.TvOldVersionsFragment.d) r0
            int r1 = r0.f21293d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L_0x0013
            int r1 = r1 - r2
            r0.f21293d = r1
            goto L_0x0018
        L_0x0013:
            com.uptodown.tv.ui.fragment.TvOldVersionsFragment$d r0 = new com.uptodown.tv.ui.fragment.TvOldVersionsFragment$d
            r0.<init>(r6, r7)
        L_0x0018:
            java.lang.Object r7 = r0.f21291b
            java.lang.Object r1 = c3.C2316b.f()
            int r2 = r0.f21293d
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
            java.lang.Object r2 = r0.f21290a
            com.uptodown.tv.ui.fragment.TvOldVersionsFragment r2 = (com.uptodown.tv.ui.fragment.TvOldVersionsFragment) r2
            W2.u.b(r7)
            goto L_0x0055
        L_0x003d:
            W2.u.b(r7)
            w3.I r7 = w3.C2865c0.b()
            com.uptodown.tv.ui.fragment.TvOldVersionsFragment$e r2 = new com.uptodown.tv.ui.fragment.TvOldVersionsFragment$e
            r2.<init>(r6, r5)
            r0.f21290a = r6
            r0.f21293d = r4
            java.lang.Object r7 = w3.C2872g.g(r7, r2, r0)
            if (r7 != r1) goto L_0x0054
            goto L_0x0068
        L_0x0054:
            r2 = r6
        L_0x0055:
            w3.I0 r7 = w3.C2865c0.c()
            com.uptodown.tv.ui.fragment.TvOldVersionsFragment$f r4 = new com.uptodown.tv.ui.fragment.TvOldVersionsFragment$f
            r4.<init>(r2, r5)
            r0.f21290a = r5
            r0.f21293d = r3
            java.lang.Object r7 = w3.C2872g.g(r7, r4, r0)
            if (r7 != r1) goto L_0x0069
        L_0x0068:
            return r1
        L_0x0069:
            W2.J r7 = W2.J.f19942a
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.uptodown.tv.ui.fragment.TvOldVersionsFragment.s(b3.e):java.lang.Object");
    }

    private final boolean t(String str, long j5) {
        if (getActivity() != null) {
            PackageManager packageManager = requireActivity().getPackageManager();
            try {
                t.b(packageManager);
                t.b(str);
                if (j5 < new C2290j().m(C2301u.d(packageManager, str, 1))) {
                    return true;
                }
                return false;
            } catch (PackageManager.NameNotFoundException e5) {
                e5.printStackTrace();
            }
        }
        return false;
    }

    /* access modifiers changed from: private */
    public final void u(ArrayList arrayList) {
        b bVar = this.f21288d;
        t.b(bVar);
        bVar.clear();
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            b bVar2 = this.f21288d;
            t.b(bVar2);
            bVar2.add(arrayList.get(i5));
        }
    }

    /* access modifiers changed from: private */
    public final void v(String str, long j5, String str2) {
        if (t(str, j5)) {
            o(str);
            return;
        }
        E e5 = new E();
        Context requireContext = requireContext();
        t.d(requireContext, "requireContext(...)");
        File file = new File(e5.h(requireContext), str2);
        UptodownApp.a aVar = UptodownApp.f13477F;
        FragmentActivity requireActivity = requireActivity();
        t.d(requireActivity, "requireActivity(...)");
        UptodownApp.a.X(aVar, file, requireActivity, (String) null, 4, (Object) null);
    }

    private final void w() {
        VerticalGridPresenter verticalGridPresenter = new VerticalGridPresenter();
        verticalGridPresenter.setNumberOfColumns(2);
        setGridPresenter(verticalGridPresenter);
        new Handler(Looper.getMainLooper()).postDelayed(new C2820O(this), 500);
        setOnItemViewClickedListener(new c());
    }

    /* access modifiers changed from: private */
    public static final void x(TvOldVersionsFragment tvOldVersionsFragment) {
        tvOldVersionsFragment.startEntranceTransition();
    }

    private final void y(String str) {
        if (getActivity() != null) {
            FragmentActivity requireActivity = requireActivity();
            t.d(requireActivity, "requireActivity(...)");
            j jVar = new j(requireActivity);
            t.b(str);
            jVar.h(str);
        }
    }

    public void onCreate(Bundle bundle) {
        Bundle extras;
        Parcelable parcelable;
        Parcelable parcelable2;
        super.onCreate(bundle);
        F f5 = new F(getContext());
        String simpleName = TvOldVersionsFragment.class.getSimpleName();
        t.d(simpleName, "getSimpleName(...)");
        f5.f(simpleName);
        FragmentActivity activity = getActivity();
        if (!(activity == null || (extras = activity.getIntent().getExtras()) == null)) {
            if (extras.containsKey(MBridgeConstans.DYNAMIC_VIEW_WX_APP)) {
                if (Build.VERSION.SDK_INT >= 33) {
                    parcelable2 = (Parcelable) extras.getParcelable(MBridgeConstans.DYNAMIC_VIEW_WX_APP, C2655d.class);
                } else {
                    parcelable2 = extras.getParcelable(MBridgeConstans.DYNAMIC_VIEW_WX_APP);
                }
                this.f21286b = (C2655d) parcelable2;
            }
            if (extras.containsKey("appInfo")) {
                if (Build.VERSION.SDK_INT >= 33) {
                    parcelable = (Parcelable) extras.getParcelable("appInfo", C2657f.class);
                } else {
                    parcelable = extras.getParcelable("appInfo");
                }
                this.f21285a = (C2657f) parcelable;
                C2954m mVar = new C2954m();
                Context requireContext = requireContext();
                t.d(requireContext, "requireContext(...)");
                C2657f fVar = this.f21285a;
                t.b(fVar);
                this.f21286b = mVar.C(requireContext, fVar.S());
            }
        }
        if (this.f21286b != null) {
            C2655d dVar = this.f21286b;
            t.b(dVar);
            this.f21288d = new b(new n(dVar));
        } else if (this.f21285a != null) {
            C2657f fVar2 = this.f21285a;
            t.b(fVar2);
            this.f21288d = new b(new n(fVar2.S()));
        }
        setAdapter(this.f21288d);
        setTitle(getString(R.string.rollback_title));
        if (bundle == null) {
            prepareEntranceTransition();
        }
        w();
    }

    public void onResume() {
        super.onResume();
        C2908y0 unused = C2876i.d(N.a(C2865c0.b()), (C2312i) null, (O) null, new g(this, (C2308e) null), 3, (Object) null);
    }

    public final void z(int i5) {
        switch (i5) {
            case 201:
                b bVar = this.f21288d;
                t.b(bVar);
                b bVar2 = this.f21288d;
                t.b(bVar2);
                bVar.notifyArrayItemRangeChanged(0, bVar2.size());
                return;
            case 202:
            case 203:
                b bVar3 = this.f21288d;
                t.b(bVar3);
                b bVar4 = this.f21288d;
                t.b(bVar4);
                bVar3.notifyArrayItemRangeChanged(0, bVar4.size());
                return;
            default:
                return;
        }
    }
}
