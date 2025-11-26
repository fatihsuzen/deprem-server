package C2;

import R1.I;
import S1.k;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import k2.C2591a;
import k2.C2611v;
import kotlin.jvm.internal.t;
import l2.S;

public final class X extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private C2611v f17642a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f17643b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f17644c;

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView f17645d;

    /* renamed from: e  reason: collision with root package name */
    private LinearLayoutManager f17646e;

    /* renamed from: f  reason: collision with root package name */
    private final I f17647f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public X(View view, C2611v vVar, C2591a aVar) {
        super(view);
        t.e(view, "itemView");
        t.e(vVar, "listener");
        t.e(aVar, "actionsClickListener");
        this.f17642a = vVar;
        View findViewById = view.findViewById(R.id.rl_title_home_recycler_view_top);
        t.d(findViewById, "findViewById(...)");
        this.f17643b = (RelativeLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_title_home_recycler_view_top);
        t.d(findViewById2, "findViewById(...)");
        this.f17644c = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.rv_home_recycler_view_top);
        t.d(findViewById3, "findViewById(...)");
        this.f17645d = (RecyclerView) findViewById3;
        this.f17646e = new LinearLayoutManager(view.getContext(), 0, false);
        I i5 = new I(this.f17642a, aVar);
        this.f17647f = i5;
        this.f17644c.setTypeface(k.f32g.w());
        this.f17645d.setLayoutManager(this.f17646e);
        this.f17645d.setItemAnimator((RecyclerView.ItemAnimator) null);
        this.f17645d.setAdapter(i5);
    }

    /* access modifiers changed from: private */
    public static final void c(X x4, S s5, View view) {
        x4.f17642a.c(s5);
    }

    public final void b(S s5) {
        t.e(s5, "topByCategory");
        this.f17643b.setOnClickListener(new W(this, s5));
        this.f17644c.setText(s5.b().e());
        this.f17647f.c(s5.a());
    }

    public final I d() {
        return this.f17647f;
    }
}
