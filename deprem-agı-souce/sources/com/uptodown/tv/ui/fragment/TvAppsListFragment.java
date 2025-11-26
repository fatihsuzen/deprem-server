package com.uptodown.tv.ui.fragment;

import W2.J;
import W2.u;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.fragment.app.FragmentActivity;
import androidx.leanback.app.VerticalGridSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.OnItemViewSelectedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import androidx.leanback.widget.VerticalGridPresenter;
import androidx.lifecycle.LifecycleOwnerKt;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.squareup.picasso.s;
import com.uptodown.R;
import java.util.ArrayList;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.L;
import kotlin.jvm.internal.t;
import l2.C2657f;
import l2.C2660i;
import org.json.JSONArray;
import org.json.JSONObject;
import v2.C2802b;
import w2.C2841n;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.I0;
import w3.M;
import w3.O;
import z2.F;
import z2.Z;

public final class TvAppsListFragment extends VerticalGridSupportFragment {

    /* renamed from: e  reason: collision with root package name */
    public static final a f21239e = new a((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ArrayObjectAdapter f21240a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public C2660i f21241b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f21242c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public boolean f21243d;

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
            if ((obj instanceof C2657f) && TvAppsListFragment.this.getActivity() != null && viewHolder != null) {
                C2802b bVar = (C2802b) TvAppsListFragment.this.getActivity();
                t.b(bVar);
                bVar.m((C2657f) obj, viewHolder);
            }
        }
    }

    private final class c implements OnItemViewSelectedListener {
        public c() {
        }

        /* renamed from: a */
        public void onItemSelected(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
            if (obj != null) {
                ArrayObjectAdapter h5 = TvAppsListFragment.this.f21240a;
                t.b(h5);
                int indexOf = h5.indexOf(obj);
                if (indexOf < TvAppsListFragment.this.f21242c && indexOf >= TvAppsListFragment.this.f21242c - 5 && !TvAppsListFragment.this.f21243d) {
                    TvAppsListFragment.this.s();
                }
            }
        }
    }

    static final class d extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21246a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvAppsListFragment f21247b;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21248a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ TvAppsListFragment f21249b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ L f21250c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(TvAppsListFragment tvAppsListFragment, L l5, C2308e eVar) {
                super(2, eVar);
                this.f21249b = tvAppsListFragment;
                this.f21250c = l5;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21249b, this.f21250c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21248a == 0) {
                    u.b(obj);
                    try {
                        this.f21249b.t((ArrayList) this.f21250c.f24690a);
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                    this.f21249b.f21243d = false;
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(TvAppsListFragment tvAppsListFragment, C2308e eVar) {
            super(2, eVar);
            this.f21247b = tvAppsListFragment;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new d(this.f21247b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            l2.M m5;
            Integer num;
            Resources resources;
            Object f5 = C2316b.f();
            int i5 = this.f21246a;
            if (i5 == 0) {
                u.b(obj);
                L l5 = new L();
                this.f21247b.f21243d = true;
                FragmentActivity requireActivity = this.f21247b.requireActivity();
                t.d(requireActivity, "requireActivity(...)");
                Z z4 = new Z(requireActivity);
                if (this.f21247b.f21241b != null) {
                    C2660i i6 = this.f21247b.f21241b;
                    t.b(i6);
                    int c5 = i6.c();
                    if (c5 == -2) {
                        m5 = z4.N(75, this.f21247b.f21242c);
                    } else if (c5 != -1) {
                        C2660i i7 = this.f21247b.f21241b;
                        t.b(i7);
                        if (i7.i()) {
                            C2660i i8 = this.f21247b.f21241b;
                            t.b(i8);
                            m5 = z4.o0(i8.c(), 75, this.f21247b.f21242c);
                        } else {
                            C2660i i9 = this.f21247b.f21241b;
                            t.b(i9);
                            m5 = z4.l0(i9.c(), 75, this.f21247b.f21242c);
                        }
                    } else {
                        m5 = z4.k0(75, this.f21247b.f21242c);
                    }
                } else {
                    m5 = null;
                }
                if (!(m5 == null || m5.b() || m5.e() == null)) {
                    JSONObject e5 = m5.e();
                    t.b(e5);
                    JSONArray optJSONArray = e5.optJSONArray(DataSchemeDataSource.SCHEME_DATA);
                    if (e5.optInt("success") == 1 && optJSONArray != null) {
                        l5.f24690a = new ArrayList();
                        Context context = this.f21247b.getContext();
                        if (context == null || (resources = context.getResources()) == null) {
                            num = null;
                        } else {
                            num = kotlin.coroutines.jvm.internal.b.b(resources.getDimensionPixelSize(R.dimen.tv_card_height));
                        }
                        int length = optJSONArray.length();
                        for (int i10 = 0; i10 < length; i10++) {
                            JSONObject optJSONObject = optJSONArray.optJSONObject(i10);
                            C2657f.b bVar = C2657f.f25002J0;
                            t.b(optJSONObject);
                            C2657f b5 = C2657f.b.b(bVar, optJSONObject, (Context) null, 2, (Object) null);
                            ((ArrayList) l5.f24690a).add(b5);
                            if (num != null) {
                                s.h().l(b5.F(num.intValue())).d();
                            }
                            this.f21247b.f21242c = this.f21247b.f21242c + 1;
                        }
                    }
                }
                I0 c6 = C2865c0.c();
                a aVar = new a(this.f21247b, l5, (C2308e) null);
                this.f21246a = 1;
                if (C2872g.g(c6, aVar, this) == f5) {
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
            return ((d) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21251a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvAppsListFragment f21252b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(TvAppsListFragment tvAppsListFragment, C2308e eVar) {
            super(2, eVar);
            this.f21252b = tvAppsListFragment;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f21252b, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21251a;
            if (i5 == 0) {
                u.b(obj);
                TvAppsListFragment tvAppsListFragment = this.f21252b;
                this.f21251a = 1;
                if (tvAppsListFragment.r(this) == f5) {
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

    private final void p(String str) {
        FragmentActivity activity = getActivity();
        if (activity != null && !activity.isFinishing()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setMessage(str);
            builder.setPositiveButton(17039370, new C2841n());
            builder.setCancelable(true);
            builder.create().show();
        }
    }

    /* access modifiers changed from: private */
    public static final void q(DialogInterface dialogInterface, int i5) {
        t.e(dialogInterface, "dialogInterface");
        dialogInterface.dismiss();
    }

    /* access modifiers changed from: private */
    public final Object r(C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new d(this, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final void s() {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), (C2312i) null, (O) null, new e(this, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public final void t(ArrayList arrayList) {
        if (arrayList == null || arrayList.isEmpty()) {
            String string = getString(R.string.no_data_available);
            t.d(string, "getString(...)");
            p(string);
            return;
        }
        int size = arrayList.size();
        for (int i5 = 0; i5 < size; i5++) {
            ArrayObjectAdapter arrayObjectAdapter = this.f21240a;
            t.b(arrayObjectAdapter);
            arrayObjectAdapter.add(arrayList.get(i5));
        }
    }

    private final void u() {
        VerticalGridPresenter verticalGridPresenter = new VerticalGridPresenter();
        verticalGridPresenter.setNumberOfColumns(5);
        setGridPresenter(verticalGridPresenter);
        startEntranceTransition();
        setOnItemViewClickedListener(new b());
        setOnItemViewSelectedListener(new c());
    }

    public void onCreate(Bundle bundle) {
        String str;
        Bundle extras;
        Parcelable parcelable;
        super.onCreate(bundle);
        F f5 = new F(getContext());
        String simpleName = TvAppsListFragment.class.getSimpleName();
        t.d(simpleName, "getSimpleName(...)");
        f5.f(simpleName);
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((Presenter) new u2.d());
        this.f21240a = arrayObjectAdapter;
        setAdapter(arrayObjectAdapter);
        FragmentActivity activity = getActivity();
        if (!(activity == null || (extras = activity.getIntent().getExtras()) == null || !extras.containsKey("category"))) {
            if (Build.VERSION.SDK_INT >= 33) {
                parcelable = (Parcelable) extras.getParcelable("category", C2660i.class);
            } else {
                parcelable = extras.getParcelable("category");
            }
            this.f21241b = (C2660i) parcelable;
        }
        C2660i iVar = this.f21241b;
        if (iVar != null) {
            str = iVar.e();
        } else {
            str = null;
        }
        setTitle(str);
        if (bundle == null) {
            prepareEntranceTransition();
        }
        u();
    }

    public void onResume() {
        super.onResume();
        s();
    }
}
