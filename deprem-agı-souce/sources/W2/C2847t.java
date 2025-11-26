package w2;

import X2.C2250q;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import androidx.leanback.app.RowsSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.tv.ui.activity.TvAppsListActivity;
import g2.C2385g;
import g2.C2388j;
import java.util.ArrayList;
import java.util.Iterator;
import k2.C2608s;
import k2.C2610u;
import kotlin.jvm.internal.t;
import l2.C2657f;
import l2.C2660i;
import l2.S;
import s2.C2746c;
import u2.e;
import u2.f;
import u2.g;
import u2.h;
import u2.p;
import v2.C2802b;
import z2.F;

/* renamed from: w2.t  reason: case insensitive filesystem */
public final class C2847t extends RowsSupportFragment {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public C2657f f26189a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ArrayList f26190b = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public ArrayList f26191c = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public ArrayList f26192d = new ArrayList();

    /* renamed from: e  reason: collision with root package name */
    private ArrayObjectAdapter f26193e;

    /* renamed from: f  reason: collision with root package name */
    private int f26194f;

    public C2847t() {
        ListRowPresenter listRowPresenter = new ListRowPresenter(0);
        listRowPresenter.setShadowEnabled(false);
        listRowPresenter.setSelectEffectEnabled(false);
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((Presenter) listRowPresenter);
        this.f26193e = arrayObjectAdapter;
        setAdapter(arrayObjectAdapter);
    }

    /* access modifiers changed from: private */
    public final void p(ArrayList arrayList) {
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((Presenter) new f());
        arrayObjectAdapter.addAll(0, arrayList);
        this.f26193e.add(new ListRow(arrayObjectAdapter));
    }

    private final void q(ArrayList arrayList, int i5) {
        Iterator it = arrayList.iterator();
        int i6 = 0;
        while (true) {
            if (!it.hasNext()) {
                i6 = -1;
                break;
            }
            int i7 = i6 + 1;
            S s5 = (S) it.next();
            if (s5.b().c() == i5) {
                t(s5);
                break;
            }
            i6 = i7;
        }
        if (i6 >= 0) {
            arrayList.remove(i6);
        }
    }

    private final void r(S s5) {
        if (getContext() != null) {
            HeaderItem headerItem = new HeaderItem(s5.b().e());
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((Presenter) new g(requireContext));
            arrayObjectAdapter.addAll(0, s5.a());
            C2746c cVar = new C2746c();
            cVar.b(s5.b());
            arrayObjectAdapter.add(cVar);
            this.f26193e.add(new ListRow(headerItem, arrayObjectAdapter));
        }
    }

    /* access modifiers changed from: private */
    public final void s(C2657f fVar) {
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((Presenter) new p());
        arrayObjectAdapter.add(fVar);
        this.f26193e.add(new ListRow(arrayObjectAdapter));
    }

    private final void t(S s5) {
        if (getContext() != null) {
            HeaderItem headerItem = new HeaderItem(s5.b().e());
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((Presenter) new h(requireContext));
            arrayObjectAdapter.addAll(0, s5.a());
            C2746c cVar = new C2746c();
            cVar.b(s5.b());
            arrayObjectAdapter.add(cVar);
            this.f26193e.add(new ListRow(headerItem, arrayObjectAdapter));
        }
    }

    private final void u(S s5) {
        if (getContext() != null) {
            HeaderItem headerItem = new HeaderItem(s5.b().e());
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((Presenter) new e(requireContext));
            arrayObjectAdapter.addAll(0, s5.a());
            C2746c cVar = new C2746c();
            cVar.b(s5.b());
            arrayObjectAdapter.add(cVar);
            this.f26193e.add(new ListRow(headerItem, arrayObjectAdapter));
        }
    }

    private final void v() {
        if (!this.f26192d.isEmpty()) {
            Object obj = this.f26192d.get(0);
            t.d(obj, "get(...)");
            r((S) obj);
        }
        if (!this.f26191c.isEmpty()) {
            q(this.f26191c, -2);
        }
        if (!this.f26192d.isEmpty() && this.f26192d.size() > 1) {
            Object obj2 = this.f26192d.get(1);
            t.d(obj2, "get(...)");
            r((S) obj2);
        }
        if (!this.f26191c.isEmpty()) {
            q(this.f26191c, -1);
        }
        if (!this.f26192d.isEmpty() && this.f26192d.size() > 2) {
            Object obj3 = this.f26192d.get(2);
            t.d(obj3, "get(...)");
            r((S) obj3);
        }
        if (!this.f26191c.isEmpty()) {
            q(this.f26191c, 521);
        }
        if (!this.f26191c.isEmpty()) {
            q(this.f26191c, 523);
        }
        if (!this.f26191c.isEmpty()) {
            q(this.f26191c, 524);
        }
        if (!this.f26191c.isEmpty()) {
            Iterator it = this.f26191c.iterator();
            t.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                t.d(next, "next(...)");
                u((S) next);
            }
        }
    }

    /* access modifiers changed from: private */
    public final void w() {
        int i5 = this.f26194f;
        if (i5 < 3) {
            this.f26194f = i5 + 1;
        } else {
            v();
        }
    }

    private final void x() {
        a aVar = new a(this);
        if (getContext() != null) {
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            t.d(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            new C2385g(requireContext, aVar, LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner));
        }
    }

    /* access modifiers changed from: private */
    public static final void y(C2847t tVar, Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        if (!(obj instanceof C2657f)) {
            Class<TvAppsListActivity> cls = TvAppsListActivity.class;
            if (obj instanceof C2746c) {
                Intent intent = new Intent(tVar.getContext(), cls);
                intent.putExtra("category", ((C2746c) obj).a());
                tVar.startActivity(intent);
            } else if (obj instanceof C2660i) {
                Intent intent2 = new Intent(tVar.getContext(), cls);
                intent2.putExtra("category", (Parcelable) obj);
                tVar.startActivity(intent2);
            }
        } else if (viewHolder != null) {
            Context requireContext = tVar.requireContext();
            t.d(requireContext, "requireContext(...)");
            new C2388j(requireContext, ((C2657f) obj).e(), new b(tVar, viewHolder), LifecycleOwnerKt.getLifecycleScope(tVar));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        F f5 = new F(getContext());
        String simpleName = C2847t.class.getSimpleName();
        t.d(simpleName, "getSimpleName(...)");
        f5.f(simpleName);
    }

    public void onResume() {
        super.onResume();
        if (this.f26189a == null || this.f26190b.isEmpty()) {
            x();
        } else {
            getMainFragmentAdapter().getFragmentHost().notifyDataReady(getMainFragmentAdapter());
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        super.onViewCreated(view, bundle);
        setOnItemViewClickedListener(new C2846s(this));
    }

    /* renamed from: w2.t$a */
    public static final class a implements C2608s {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2847t f26195a;

        a(C2847t tVar) {
            this.f26195a = tVar;
        }

        public void a(S s5) {
            t.e(s5, "topHorizontalTopReceived");
            this.f26195a.f26191c.add(s5);
            this.f26195a.w();
        }

        public void b(ArrayList arrayList) {
            t.e(arrayList, "miniTopsReceived");
            this.f26195a.f26191c.addAll(arrayList);
            this.f26195a.w();
        }

        public void c(C2657f fVar) {
            t.e(fVar, "appReplacement");
        }

        public void d(S s5) {
            t.e(s5, "topHorizontalLatestReceived");
            this.f26195a.f26191c.add(s5);
            this.f26195a.w();
        }

        public void e(ArrayList arrayList) {
            t.e(arrayList, "homeFeaturesReceived");
            if (arrayList.size() > 0) {
                this.f26195a.f26189a = (C2657f) C2250q.M(arrayList);
                C2847t tVar = this.f26195a;
                C2657f m5 = tVar.f26189a;
                t.b(m5);
                tVar.s(m5);
            }
            this.f26195a.getMainFragmentAdapter().getFragmentHost().notifyDataReady(this.f26195a.getMainFragmentAdapter());
        }

        public void f(ArrayList arrayList) {
            t.e(arrayList, "homeMiniTopsReceived");
            this.f26195a.f26192d.addAll(arrayList);
            this.f26195a.w();
        }

        public void g(S s5) {
            t.e(s5, "topHorizontalNewReleasesReceived");
            this.f26195a.f26191c.add(s5);
        }

        public void i(C2657f fVar) {
            t.e(fVar, "appInfoReceived");
        }

        public void j(S s5) {
            t.e(s5, "topByCategory");
            this.f26195a.f26192d.add(s5);
        }

        public void k(ArrayList arrayList) {
            t.e(arrayList, "categoriesReceived");
            this.f26195a.f26190b = arrayList;
            C2847t tVar = this.f26195a;
            tVar.p(tVar.f26190b);
        }

        public void h() {
        }
    }

    /* renamed from: w2.t$b */
    public static final class b implements C2610u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2847t f26196a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Presenter.ViewHolder f26197b;

        b(C2847t tVar, Presenter.ViewHolder viewHolder) {
            this.f26196a = tVar;
            this.f26197b = viewHolder;
        }

        public void c(C2657f fVar) {
            t.e(fVar, "appInfo");
            if (this.f26196a.getActivity() != null && (this.f26196a.getActivity() instanceof C2802b)) {
                try {
                    C2802b bVar = (C2802b) this.f26196a.getActivity();
                    t.b(bVar);
                    bVar.m(fVar, this.f26197b);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }

        public void d(int i5) {
        }
    }
}
