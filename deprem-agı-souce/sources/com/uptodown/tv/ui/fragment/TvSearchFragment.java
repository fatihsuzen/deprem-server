package com.uptodown.tv.ui.fragment;

import W2.J;
import W2.u;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import androidx.leanback.app.SearchSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.ObjectAdapter;
import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import androidx.leanback.widget.SearchBar;
import androidx.lifecycle.LifecycleOwnerKt;
import b3.C2308e;
import b3.C2312i;
import c3.C2316b;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.mbridge.msdk.playercommon.exoplayer2.upstream.DataSchemeDataSource;
import com.uptodown.R;
import com.uptodown.tv.ui.activity.TvAppDetailActivity;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import k3.p;
import kotlin.coroutines.jvm.internal.l;
import kotlin.jvm.internal.t;
import l2.C2657f;
import org.json.JSONArray;
import org.json.JSONObject;
import t3.s;
import w2.C2823S;
import w2.C2824T;
import w2.C2825U;
import w3.C2865c0;
import w3.C2872g;
import w3.C2908y0;
import w3.I0;
import w3.M;
import w3.O;
import z2.F;
import z2.Z;

public final class TvSearchFragment extends SearchSupportFragment implements SearchSupportFragment.SearchResultProvider {

    /* renamed from: a  reason: collision with root package name */
    private ArrayObjectAdapter f21301a = new ArrayObjectAdapter((Presenter) new ListRowPresenter());
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public String f21302b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ArrayList f21303c = new ArrayList();

    static final class a extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21304a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvSearchFragment f21305b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2657f f21306c;

        /* renamed from: com.uptodown.tv.ui.fragment.TvSearchFragment$a$a  reason: collision with other inner class name */
        static final class C0216a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21307a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ TvSearchFragment f21308b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ C2657f f21309c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            C0216a(TvSearchFragment tvSearchFragment, C2657f fVar, C2308e eVar) {
                super(2, eVar);
                this.f21308b = tvSearchFragment;
                this.f21309c = fVar;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new C0216a(this.f21308b, this.f21309c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21307a == 0) {
                    u.b(obj);
                    Intent intent = new Intent(this.f21308b.getActivity(), TvAppDetailActivity.class);
                    intent.putExtra("appInfo", this.f21309c);
                    this.f21308b.startActivity(intent);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((C0216a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        a(TvSearchFragment tvSearchFragment, C2657f fVar, C2308e eVar) {
            super(2, eVar);
            this.f21305b = tvSearchFragment;
            this.f21306c = fVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new a(this.f21305b, this.f21306c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            String d5;
            Object f5 = C2316b.f();
            int i5 = this.f21304a;
            if (i5 == 0) {
                u.b(obj);
                Context requireContext = this.f21305b.requireContext();
                t.d(requireContext, "requireContext(...)");
                l2.M X4 = new Z(requireContext).X(this.f21306c.e());
                if (!(X4.b() || (d5 = X4.d()) == null || d5.length() == 0)) {
                    String d6 = X4.d();
                    t.b(d6);
                    JSONObject jSONObject = new JSONObject(d6);
                    JSONObject optJSONObject = jSONObject.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                    if (jSONObject.optInt("success") == 1 && optJSONObject != null) {
                        C2657f.b(this.f21306c, optJSONObject, (Context) null, 2, (Object) null);
                    }
                }
                I0 c5 = C2865c0.c();
                C0216a aVar = new C0216a(this.f21305b, this.f21306c, (C2308e) null);
                this.f21304a = 1;
                if (C2872g.g(c5, aVar, this) == f5) {
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
            return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class b extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21310a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvSearchFragment f21311b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f21312c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(TvSearchFragment tvSearchFragment, String str, C2308e eVar) {
            super(2, eVar);
            this.f21311b = tvSearchFragment;
            this.f21312c = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new b(this.f21311b, this.f21312c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21310a;
            if (i5 == 0) {
                u.b(obj);
                TvSearchFragment tvSearchFragment = this.f21311b;
                String str = this.f21312c;
                this.f21310a = 1;
                if (tvSearchFragment.w(str, this) == f5) {
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
            return ((b) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    static final class c extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21313a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvSearchFragment f21314b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ C2657f f21315c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        c(TvSearchFragment tvSearchFragment, C2657f fVar, C2308e eVar) {
            super(2, eVar);
            this.f21314b = tvSearchFragment;
            this.f21315c = fVar;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new c(this.f21314b, this.f21315c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object f5 = C2316b.f();
            int i5 = this.f21313a;
            if (i5 == 0) {
                u.b(obj);
                TvSearchFragment tvSearchFragment = this.f21314b;
                C2657f fVar = this.f21315c;
                this.f21313a = 1;
                if (tvSearchFragment.r(fVar, this) == f5) {
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

    public static final class d implements SearchBar.SearchBarListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ TvSearchFragment f21316a;

        d(TvSearchFragment tvSearchFragment) {
            this.f21316a = tvSearchFragment;
        }

        /* access modifiers changed from: private */
        public static final void b(TvSearchFragment tvSearchFragment) {
            tvSearchFragment.focusOnResults();
        }

        public void onKeyboardDismiss(String str) {
            t.e(str, MBridgeConstans.DYNAMIC_VIEW_WX_QUERY);
            new Handler(Looper.getMainLooper()).postDelayed(new C2825U(this.f21316a), AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
        }

        public void onSearchQueryChange(String str) {
            if (str != null && str.length() > 2 && !s.E(str, this.f21316a.f21302b, true)) {
                this.f21316a.f21302b = str;
                this.f21316a.v(str);
            }
        }

        public void onSearchQuerySubmit(String str) {
            if (str != null && str.length() > 2 && !s.E(str, this.f21316a.f21302b, true)) {
                this.f21316a.f21302b = str;
                this.f21316a.v(str);
            }
        }
    }

    static final class e extends l implements p {

        /* renamed from: a  reason: collision with root package name */
        int f21317a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ TvSearchFragment f21318b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ String f21319c;

        static final class a extends l implements p {

            /* renamed from: a  reason: collision with root package name */
            int f21320a;

            /* renamed from: b  reason: collision with root package name */
            final /* synthetic */ TvSearchFragment f21321b;

            /* renamed from: c  reason: collision with root package name */
            final /* synthetic */ String f21322c;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            a(TvSearchFragment tvSearchFragment, String str, C2308e eVar) {
                super(2, eVar);
                this.f21321b = tvSearchFragment;
                this.f21322c = str;
            }

            public final C2308e create(Object obj, C2308e eVar) {
                return new a(this.f21321b, this.f21322c, eVar);
            }

            public final Object invokeSuspend(Object obj) {
                C2316b.f();
                if (this.f21320a == 0) {
                    u.b(obj);
                    TvSearchFragment tvSearchFragment = this.f21321b;
                    tvSearchFragment.x(this.f21322c, tvSearchFragment.f21303c);
                    return J.f19942a;
                }
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }

            public final Object invoke(M m5, C2308e eVar) {
                return ((a) create(m5, eVar)).invokeSuspend(J.f19942a);
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(TvSearchFragment tvSearchFragment, String str, C2308e eVar) {
            super(2, eVar);
            this.f21318b = tvSearchFragment;
            this.f21319c = str;
        }

        public final C2308e create(Object obj, C2308e eVar) {
            return new e(this.f21318b, this.f21319c, eVar);
        }

        public final Object invokeSuspend(Object obj) {
            Integer num;
            Resources resources;
            Object f5 = C2316b.f();
            int i5 = this.f21317a;
            if (i5 == 0) {
                u.b(obj);
                ArrayList j5 = this.f21318b.f21303c;
                t.b(j5);
                j5.clear();
                Context requireContext = this.f21318b.requireContext();
                t.d(requireContext, "requireContext(...)");
                Z z4 = new Z(requireContext);
                String str = this.f21319c;
                ArrayList j6 = this.f21318b.f21303c;
                t.b(j6);
                l2.M f12 = z4.f1(str, 10, j6.size());
                if (!f12.b() && f12.e() != null) {
                    JSONObject e5 = f12.e();
                    t.b(e5);
                    JSONObject optJSONObject = e5.optJSONObject(DataSchemeDataSource.SCHEME_DATA);
                    if (optJSONObject != null) {
                        JSONArray optJSONArray = optJSONObject.optJSONArray("results");
                        if (e5.optInt("success") == 1 && optJSONArray != null) {
                            Context context = this.f21318b.getContext();
                            if (context == null || (resources = context.getResources()) == null) {
                                num = null;
                            } else {
                                num = kotlin.coroutines.jvm.internal.b.b(resources.getDimensionPixelSize(R.dimen.tv_card_height));
                            }
                            int length = optJSONArray.length();
                            for (int i6 = 0; i6 < length; i6++) {
                                JSONObject optJSONObject2 = optJSONArray.optJSONObject(i6);
                                C2657f.b bVar = C2657f.f25002J0;
                                t.b(optJSONObject2);
                                C2657f b5 = C2657f.b.b(bVar, optJSONObject2, (Context) null, 2, (Object) null);
                                ArrayList j7 = this.f21318b.f21303c;
                                t.b(j7);
                                j7.add(b5);
                                if (num != null) {
                                    com.squareup.picasso.s.h().l(b5.F(num.intValue())).d();
                                }
                            }
                            I0 c5 = C2865c0.c();
                            a aVar = new a(this.f21318b, this.f21319c, (C2308e) null);
                            this.f21317a = 1;
                            if (C2872g.g(c5, aVar, this) == f5) {
                                return f5;
                            }
                        }
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
            return ((e) create(m5, eVar)).invokeSuspend(J.f19942a);
        }
    }

    /* access modifiers changed from: private */
    public final void focusOnResults() {
    }

    /* access modifiers changed from: private */
    public static final void h(TvSearchFragment tvSearchFragment, Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        t.c(obj, "null cannot be cast to non-null type com.uptodown.models.AppInfo");
        tvSearchFragment.t((C2657f) obj);
    }

    private final OnItemViewClickedListener q() {
        return new C2824T(this);
    }

    /* access modifiers changed from: private */
    public final Object r(C2657f fVar, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new a(this, fVar, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    private final void s(String str) {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), (C2312i) null, (O) null, new b(this, str, (C2308e) null), 3, (Object) null);
    }

    private final void t(C2657f fVar) {
        C2908y0 unused = C2876i.d(LifecycleOwnerKt.getLifecycleScope(this), (C2312i) null, (O) null, new c(this, fVar, (C2308e) null), 3, (Object) null);
    }

    /* access modifiers changed from: private */
    public static final void u() {
    }

    /* access modifiers changed from: private */
    public final void v(String str) {
        this.f21301a.clear();
        if (!TextUtils.isEmpty(str)) {
            s(str);
        }
    }

    /* access modifiers changed from: private */
    public final Object w(String str, C2308e eVar) {
        Object g5 = C2872g.g(C2865c0.b(), new e(this, str, (C2308e) null), eVar);
        if (g5 == C2316b.f()) {
            return g5;
        }
        return J.f19942a;
    }

    /* access modifiers changed from: private */
    public final void x(String str, List list) {
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((Presenter) new u2.d());
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                arrayObjectAdapter.add((C2657f) it.next());
            }
        }
        this.f21301a.add(new ListRow(new HeaderItem(str), arrayObjectAdapter));
        ArrayObjectAdapter arrayObjectAdapter2 = this.f21301a;
        arrayObjectAdapter2.notifyItemRangeChanged(0, arrayObjectAdapter2.size());
    }

    public ObjectAdapter getResultsAdapter() {
        return this.f21301a;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        F f5 = new F(getContext());
        String simpleName = TvSearchFragment.class.getSimpleName();
        t.d(simpleName, "getSimpleName(...)");
        f5.f(simpleName);
        setSearchResultProvider(this);
        setOnItemViewClickedListener(q());
        setSpeechRecognitionCallback(new C2823S());
    }

    public boolean onQueryTextChange(String str) {
        if (str != null && str.length() > 2 && !s.E(str, this.f21302b, true)) {
            this.f21302b = str;
            v(str);
        }
        return true;
    }

    public boolean onQueryTextSubmit(String str) {
        if (str != null && str.length() > 2 && !s.E(str, this.f21302b, true)) {
            this.f21302b = str;
            v(str);
        }
        return true;
    }

    public void onViewCreated(View view, Bundle bundle) {
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        super.onViewCreated(view, bundle);
        SearchBar searchBar = (SearchBar) view.findViewById(R.id.lb_search_bar);
        if (searchBar != null) {
            searchBar.setSearchBarListener(new d(this));
        }
    }
}
