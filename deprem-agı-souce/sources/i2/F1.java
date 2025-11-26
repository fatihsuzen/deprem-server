package i2;

import W2.C2223l;
import W2.m;
import android.view.View;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.activities.MainActivity;
import h2.C2413g;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2660i;
import l2.S;

public final class F1 extends I1 {

    /* renamed from: n  reason: collision with root package name */
    public static final a f23968n = new a((C2633k) null);

    /* renamed from: l  reason: collision with root package name */
    private String f23969l;

    /* renamed from: m  reason: collision with root package name */
    private final C2223l f23970m = m.b(new E1(this));

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        public final F1 a(C2660i iVar) {
            t.e(iVar, "category");
            String e5 = iVar.e();
            t.b(e5);
            F1 f12 = new F1(e5);
            f12.setArguments(iVar.s());
            return f12;
        }

        private a() {
        }
    }

    public F1(String str) {
        this.f23969l = str;
    }

    /* access modifiers changed from: private */
    public static final C2413g G(F1 f12) {
        return C2413g.c(f12.getLayoutInflater());
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
        this.f23969l = str;
    }

    /* access modifiers changed from: protected */
    /* renamed from: H */
    public C2413g o() {
        return (C2413g) this.f23970m.getValue();
    }

    /* access modifiers changed from: protected */
    public String q() {
        return this.f23969l;
    }

    /* access modifiers changed from: protected */
    public View s() {
        View view = o().f23070c;
        t.d(view, "loadingViewAppsCategoryFragment");
        return view;
    }

    /* access modifiers changed from: protected */
    public TextView t() {
        TextView textView = o().f23072e;
        t.d(textView, "tvNoDataAppsCategoryFragment");
        return textView;
    }

    /* access modifiers changed from: protected */
    public RecyclerView u() {
        RecyclerView recyclerView = o().f23071d;
        t.d(recyclerView, "recyclerView");
        return recyclerView;
    }

    /* access modifiers changed from: protected */
    public TextView v() {
        TextView textView = o().f23073f;
        t.d(textView, "tvReloadAppsCategoryFragment");
        return textView;
    }

    /* access modifiers changed from: protected */
    public String w() {
        String simpleName = F1.class.getSimpleName();
        t.d(simpleName, "getSimpleName(...)");
        return simpleName;
    }

    /* access modifiers changed from: protected */
    public void y(C2660i iVar) {
        t.e(iVar, "category");
        if (iVar.k()) {
            FragmentActivity activity = getActivity();
            t.c(activity, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
            ((MainActivity) activity).v8(iVar);
        } else if (iVar.h()) {
            FragmentActivity activity2 = getActivity();
            t.c(activity2, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
            ((MainActivity) activity2).u8(iVar);
        } else {
            FragmentActivity activity3 = getActivity();
            t.c(activity3, "null cannot be cast to non-null type com.uptodown.activities.MainActivity");
            ((MainActivity) activity3).v8(iVar);
        }
    }
}
