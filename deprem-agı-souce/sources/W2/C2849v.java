package w2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.leanback.app.BackgroundManager;
import androidx.leanback.app.BrowseSupportFragment;
import androidx.leanback.widget.ArrayObjectAdapter;
import androidx.leanback.widget.ListRowPresenter;
import androidx.leanback.widget.PageRow;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.PresenterSelector;
import androidx.leanback.widget.Row;
import com.uptodown.R;
import com.uptodown.tv.ui.activity.TvSearchActivity;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2660i;
import s2.C2744a;
import u2.i;
import z2.F;

/* renamed from: w2.v  reason: case insensitive filesystem */
public final class C2849v extends BrowseSupportFragment {

    /* renamed from: c  reason: collision with root package name */
    public static final a f26199c = new a((C2633k) null);

    /* renamed from: d  reason: collision with root package name */
    private static final int f26200d = R.drawable.vector_tv_header_home;

    /* renamed from: e  reason: collision with root package name */
    private static final int f26201e = R.drawable.vector_tv_header_games;

    /* renamed from: f  reason: collision with root package name */
    private static final int f26202f = R.drawable.vector_tv_header_top;

    /* renamed from: g  reason: collision with root package name */
    private static final int f26203g = R.drawable.vector_tv_header_management;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public static C2847t f26204h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public static C2845r f26205i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public static C2827W f26206j;

    /* renamed from: a  reason: collision with root package name */
    private BackgroundManager f26207a;

    /* renamed from: b  reason: collision with root package name */
    private ArrayObjectAdapter f26208b;

    /* renamed from: w2.v$a */
    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    /* renamed from: w2.v$b */
    private static final class b extends BrowseSupportFragment.FragmentFactory {
        public Fragment createFragment(Object obj) {
            t.c(obj, "null cannot be cast to non-null type androidx.leanback.widget.Row");
            long id = ((Row) obj).getHeaderItem().getId();
            if (id == 1) {
                if (C2849v.f26204h == null) {
                    C2849v.f26204h = new C2847t();
                }
                return C2849v.f26204h;
            } else if (id == 2) {
                if (C2849v.f26205i == null) {
                    C2849v.f26205i = new C2845r();
                }
                return C2849v.f26205i;
            } else if (id == 3) {
                if (C2849v.f26206j == null) {
                    C2849v.f26206j = C2827W.f26152f.a(new C2660i(-1, "", (String) null, 4, (C2633k) null));
                }
                return C2849v.f26206j;
            } else if (id == 4) {
                return new C2853z();
            } else {
                return null;
            }
        }
    }

    /* renamed from: w2.v$c */
    public static final class c extends PresenterSelector {
        c() {
        }

        public Presenter getPresenter(Object obj) {
            t.e(obj, "o");
            return new i();
        }
    }

    private final void m() {
        PageRow pageRow = new PageRow(new C2744a(1, "", f26200d));
        ArrayObjectAdapter arrayObjectAdapter = this.f26208b;
        t.b(arrayObjectAdapter);
        arrayObjectAdapter.add(pageRow);
        PageRow pageRow2 = new PageRow(new C2744a(2, "", f26201e));
        ArrayObjectAdapter arrayObjectAdapter2 = this.f26208b;
        t.b(arrayObjectAdapter2);
        arrayObjectAdapter2.add(pageRow2);
        PageRow pageRow3 = new PageRow(new C2744a(3, "", f26202f));
        ArrayObjectAdapter arrayObjectAdapter3 = this.f26208b;
        t.b(arrayObjectAdapter3);
        arrayObjectAdapter3.add(pageRow3);
        PageRow pageRow4 = new PageRow(new C2744a(4, "", f26203g));
        ArrayObjectAdapter arrayObjectAdapter4 = this.f26208b;
        t.b(arrayObjectAdapter4);
        arrayObjectAdapter4.add(pageRow4);
    }

    private final void n() {
        ArrayObjectAdapter arrayObjectAdapter = new ArrayObjectAdapter((Presenter) new ListRowPresenter());
        this.f26208b = arrayObjectAdapter;
        setAdapter(arrayObjectAdapter);
        m();
        startEntranceTransition();
    }

    private final void o() {
        setHeadersState(1);
        setHeaderPresenterSelector(new c());
        setBadgeDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.vector_uptodown_app_store_white));
        setHeadersTransitionOnBackEnabled(true);
        setBrandColor(ContextCompat.getColor(requireContext(), R.color.tv_background_gradient_end));
        setSearchAffordanceColor(ContextCompat.getColor(requireContext(), R.color.transparent));
        setOnSearchClickedListener(new C2848u(this));
        prepareEntranceTransition();
    }

    /* access modifiers changed from: private */
    public static final void p(C2849v vVar, View view) {
        vVar.startActivity(new Intent(vVar.getActivity(), TvSearchActivity.class));
    }

    public void onCreate(Bundle bundle) {
        BackgroundManager backgroundManager;
        super.onCreate(bundle);
        F f5 = new F(getContext());
        String simpleName = C2849v.class.getSimpleName();
        t.d(simpleName, "getSimpleName(...)");
        f5.f(simpleName);
        o();
        n();
        BackgroundManager instance = BackgroundManager.getInstance(getActivity());
        this.f26207a = instance;
        if (!(instance == null || instance.isAttached() || (backgroundManager = this.f26207a) == null)) {
            backgroundManager.attach(requireActivity().getWindow());
        }
        getMainFragmentRegistry().registerFragment(PageRow.class, new b());
    }
}
