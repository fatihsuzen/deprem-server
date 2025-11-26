package w2;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.leanback.app.RowsSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.ListRow;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import androidx.lifecycle.LifecycleOwnerKt;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import com.uptodown.tv.ui.activity.TvAppsListActivity;
import g2.C2386h;
import g2.C2388j;
import java.util.ArrayList;
import java.util.Iterator;
import k2.C2609t;
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

/* renamed from: w2.r  reason: case insensitive filesystem */
public final class C2845r extends RowsSupportFragment {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public boolean f26183a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayObjectAdapter f26184b;

    /* renamed from: w2.r$a */
    public static final class a implements C2609t {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2845r f26185a;

        a(C2845r rVar) {
            this.f26185a = rVar;
        }

        public void a(ArrayList arrayList) {
            t.e(arrayList, "featuredByCategory");
            if (!arrayList.isEmpty()) {
                C2845r rVar = this.f26185a;
                Object obj = arrayList.get(0);
                t.d(obj, "get(...)");
                rVar.n((C2657f) obj);
                this.f26185a.getMainFragmentAdapter().getFragmentHost().notifyDataReady(this.f26185a.getMainFragmentAdapter());
            }
        }

        public void b(ArrayList arrayList) {
            t.e(arrayList, "categoryChildren");
            this.f26185a.j(arrayList);
            this.f26185a.getMainFragmentAdapter().getFragmentHost().notifyDataReady(this.f26185a.getMainFragmentAdapter());
        }

        public void c(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, int i5) {
            FragmentManager supportFragmentManager;
            FragmentTransaction beginTransaction;
            FragmentTransaction replace;
            FragmentTransaction addToBackStack;
            t.e(arrayList, "featuredByCategory");
            t.e(arrayList2, "categoryChildren");
            t.e(arrayList3, "miniTops");
            if (i5 <= 1) {
                this.f26185a.q(arrayList, arrayList2, arrayList3);
                this.f26185a.getMainFragmentAdapter().getFragmentHost().notifyDataReady(this.f26185a.getMainFragmentAdapter());
                return;
            }
            this.f26185a.f26183a = false;
            C2843p pVar = new C2843p();
            FragmentActivity activity = this.f26185a.getActivity();
            if (activity != null && (supportFragmentManager = activity.getSupportFragmentManager()) != null && (beginTransaction = supportFragmentManager.beginTransaction()) != null && (replace = beginTransaction.replace(R.id.fragmentContainer, pVar)) != null && (addToBackStack = replace.addToBackStack((String) null)) != null) {
                addToBackStack.commit();
            }
        }
    }

    public C2845r() {
        ListRowPresenter listRowPresenter = new ListRowPresenter(0);
        listRowPresenter.setShadowEnabled(false);
        listRowPresenter.setSelectEffectEnabled(false);
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((Presenter) listRowPresenter);
        this.f26184b = arrayObjectAdapter;
        setAdapter(arrayObjectAdapter);
    }

    /* access modifiers changed from: private */
    public final void j(ArrayList arrayList) {
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((Presenter) new f());
        arrayObjectAdapter.addAll(0, arrayList);
        this.f26184b.add(new ListRow(arrayObjectAdapter));
    }

    private final void k(ArrayList arrayList, int i5) {
        Iterator it = arrayList.iterator();
        t.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            t.d(next, "next(...)");
            S s5 = (S) next;
            if (s5.b().c() == i5) {
                o(s5);
                arrayList.remove(s5);
                return;
            }
        }
    }

    private final void l(ArrayList arrayList, int i5) {
        Iterator it = arrayList.iterator();
        t.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            t.d(next, "next(...)");
            S s5 = (S) next;
            if (s5.b().c() == i5) {
                m(s5);
                arrayList.remove(s5);
                return;
            }
        }
    }

    private final void m(S s5) {
        if (getContext() != null) {
            HeaderItem headerItem = new HeaderItem(s5.b().e());
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((Presenter) new g(requireContext));
            arrayObjectAdapter.addAll(0, s5.a());
            C2746c cVar = new C2746c();
            cVar.b(s5.b());
            arrayObjectAdapter.add(cVar);
            this.f26184b.add(new ListRow(headerItem, arrayObjectAdapter));
            return;
        }
        this.f26183a = false;
    }

    /* access modifiers changed from: private */
    public final void n(C2657f fVar) {
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((Presenter) new p());
        arrayObjectAdapter.add(fVar);
        this.f26184b.add(new ListRow(arrayObjectAdapter));
    }

    private final void o(S s5) {
        if (getContext() != null) {
            HeaderItem headerItem = new HeaderItem(s5.b().e());
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((Presenter) new h(requireContext));
            arrayObjectAdapter.addAll(0, s5.a());
            C2746c cVar = new C2746c();
            cVar.b(s5.b());
            arrayObjectAdapter.add(cVar);
            this.f26184b.add(new ListRow(headerItem, arrayObjectAdapter));
            return;
        }
        this.f26183a = false;
    }

    private final void p(S s5) {
        if (getContext() != null) {
            HeaderItem headerItem = new HeaderItem(s5.b().e());
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((Presenter) new e(requireContext));
            arrayObjectAdapter.addAll(0, s5.a());
            C2746c cVar = new C2746c();
            cVar.b(s5.b());
            arrayObjectAdapter.add(cVar);
            this.f26184b.add(new ListRow(headerItem, arrayObjectAdapter));
            return;
        }
        this.f26183a = false;
    }

    /* access modifiers changed from: private */
    public static final void s(C2845r rVar, Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Row row) {
        if (!(obj instanceof C2657f)) {
            Class<TvAppsListActivity> cls = TvAppsListActivity.class;
            if (obj instanceof C2746c) {
                Intent intent = new Intent(rVar.getContext(), cls);
                intent.putExtra("category", ((C2746c) obj).a());
                rVar.startActivity(intent);
            } else if (obj instanceof C2660i) {
                Intent intent2 = new Intent(rVar.getContext(), cls);
                intent2.putExtra("category", (Parcelable) obj);
                rVar.startActivity(intent2);
            }
        } else if (viewHolder != null && rVar.getContext() != null) {
            Context requireContext = rVar.requireContext();
            t.d(requireContext, "requireContext(...)");
            new C2388j(requireContext, ((C2657f) obj).e(), new b(rVar, viewHolder), LifecycleOwnerKt.getLifecycleScope(rVar));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        F f5 = new F(getContext());
        String simpleName = C2845r.class.getSimpleName();
        t.d(simpleName, "getSimpleName(...)");
        f5.f(simpleName);
    }

    public void onResume() {
        super.onResume();
        if (!this.f26183a) {
            this.f26184b.clear();
            r();
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        super.onViewCreated(view, bundle);
        setOnItemViewClickedListener(new C2844q(this));
    }

    public final void q(ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3) {
        t.e(arrayList, "featuredByCategory");
        t.e(arrayList2, "categories");
        t.e(arrayList3, "miniTops");
        this.f26183a = true;
        if (!arrayList3.isEmpty()) {
            k(arrayList3, -2);
        }
        if (!arrayList3.isEmpty()) {
            l(arrayList3, -1);
        }
        if (!arrayList2.isEmpty() && ((C2660i) arrayList2.get(0)).f() == 523) {
            if (!arrayList3.isEmpty()) {
                l(arrayList3, 558);
            }
            if (!arrayList3.isEmpty()) {
                l(arrayList3, 566);
            }
            if (!arrayList3.isEmpty()) {
                l(arrayList3, 562);
            }
            if (!arrayList3.isEmpty()) {
                l(arrayList3, 564);
            }
            if (!arrayList3.isEmpty()) {
                l(arrayList3, 559);
            }
            if (!arrayList3.isEmpty()) {
                k(arrayList3, 645);
            }
            if (!arrayList3.isEmpty()) {
                l(arrayList3, 560);
            }
            if (!arrayList3.isEmpty()) {
                k(arrayList3, 561);
            }
            if (!arrayList3.isEmpty()) {
                l(arrayList3, 565);
            }
            if (!arrayList3.isEmpty()) {
                k(arrayList3, 593);
            }
            if (!arrayList3.isEmpty()) {
                k(arrayList3, 568);
            }
        }
        if (!arrayList3.isEmpty()) {
            Iterator it = arrayList3.iterator();
            t.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                t.d(next, "next(...)");
                p((S) next);
            }
        }
    }

    public final void r() {
        a aVar = new a(this);
        if (getContext() != null) {
            Context requireContext = requireContext();
            t.d(requireContext, "requireContext(...)");
            new C2386h(requireContext, aVar, LifecycleOwnerKt.getLifecycleScope(this));
        }
    }

    /* renamed from: w2.r$b */
    public static final class b implements C2610u {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ C2845r f26186a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ Presenter.ViewHolder f26187b;

        b(C2845r rVar, Presenter.ViewHolder viewHolder) {
            this.f26186a = rVar;
            this.f26187b = viewHolder;
        }

        public void c(C2657f fVar) {
            t.e(fVar, "appInfo");
            if (this.f26186a.getActivity() != null && (this.f26186a.getActivity() instanceof C2802b)) {
                try {
                    C2802b bVar = (C2802b) this.f26186a.getActivity();
                    t.b(bVar);
                    bVar.m(fVar, this.f26187b);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            }
        }

        public void d(int i5) {
        }
    }
}
