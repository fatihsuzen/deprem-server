package i2;

import W2.C2223l;
import W2.m;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.activities.MainActivity;
import h2.U;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2660i;
import l2.S;

public final class R1 extends I1 {

    /* renamed from: n  reason: collision with root package name */
    public static final a f24055n = new a((C2633k) null);

    /* renamed from: l  reason: collision with root package name */
    private String f24056l;

    /* renamed from: m  reason: collision with root package name */
    private final C2223l f24057m = m.b(new Q1(this));

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final R1 a(C2660i iVar) {
            t.e(iVar, "category");
            R1 r12 = new R1(iVar.e());
            r12.setArguments(iVar.s());
            return r12;
        }

        private a() {
        }
    }

    public R1(String str) {
        this.f24056l = str;
    }

    /* access modifiers changed from: private */
    public static final U G(R1 r12) {
        return U.c(r12.getLayoutInflater());
    }

    /* access modifiers changed from: protected */
    public void A(S s5) {
        t.e(s5, "topByCategory");
        FragmentActivity activity = getActivity();
        t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
        ((MainActivity) activity).v8(s5.b());
    }

    /* access modifiers changed from: protected */
    public void D(String str) {
        this.f24056l = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: H */
    public U o() {
        return (U) this.f24057m.getValue();
    }

    /* access modifiers changed from: protected */
    public String q() {
        return this.f24056l;
    }

    /* access modifiers changed from: protected */
    public View s() {
        View view = o().f22651c;
        t.d(view, "loadingViewGamesCategoryFragment");
        return view;
    }

    /* access modifiers changed from: protected */
    public TextView t() {
        TextView textView = o().f22653e;
        t.d(textView, "tvNoDataGamesCategoryFragment");
        return textView;
    }

    /* access modifiers changed from: protected */
    public RecyclerView u() {
        RecyclerView recyclerView = o().f22652d;
        t.d(recyclerView, "recyclerView");
        return recyclerView;
    }

    /* access modifiers changed from: protected */
    public TextView v() {
        TextView textView = o().f22654f;
        t.d(textView, "tvReloadGamesCategoryFragment");
        return textView;
    }

    /* access modifiers changed from: protected */
    public String w() {
        String simpleName = R1.class.getSimpleName();
        t.d(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    /* access modifiers changed from: protected */
    public void y(C2660i iVar) {
        t.e(iVar, "category");
        FragmentActivity activity = getActivity();
        t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
        ((MainActivity) activity).v8(iVar);
    }
}
