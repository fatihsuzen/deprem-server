package C2;

import R1.C0980k;
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

/* renamed from: C2.l1  reason: case insensitive filesystem */
public final class C2034l1 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private C2611v f17830a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f17831b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f17832c;

    /* renamed from: d  reason: collision with root package name */
    private final C0980k f17833d;

    /* renamed from: e  reason: collision with root package name */
    private RecyclerView f17834e;

    /* renamed from: f  reason: collision with root package name */
    private LinearLayoutManager f17835f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2034l1(View view, C2611v vVar, C2591a aVar) {
        super(view);
        t.e(view, "itemView");
        t.e(vVar, "listener");
        t.e(aVar, "actionsClickListener");
        this.f17830a = vVar;
        View findViewById = view.findViewById(R.id.rl_title_home_recycler_view_top);
        t.d(findViewById, "findViewById(...)");
        this.f17831b = (RelativeLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_title_home_recycler_view_top);
        t.d(findViewById2, "findViewById(...)");
        this.f17832c = (TextView) findViewById2;
        C0980k kVar = new C0980k(this.f17830a, aVar);
        this.f17833d = kVar;
        View findViewById3 = view.findViewById(R.id.rv_home_recycler_view_top);
        t.d(findViewById3, "findViewById(...)");
        this.f17834e = (RecyclerView) findViewById3;
        this.f17835f = new LinearLayoutManager(view.getContext(), 0, false);
        this.f17832c.setTypeface(k.f32g.w());
        this.f17834e.setLayoutManager(this.f17835f);
        this.f17834e.setItemAnimator((RecyclerView.ItemAnimator) null);
        this.f17834e.setAdapter(kVar);
    }

    /* access modifiers changed from: private */
    public static final void c(C2034l1 l1Var, S s5, View view) {
        l1Var.f17830a.c(s5);
    }

    public final void b(S s5) {
        t.e(s5, "topByCategory");
        this.f17831b.setOnClickListener(new C2031k1(this, s5));
        this.f17832c.setText(s5.b().e());
        if (t.a(s5.b().e(), this.itemView.getContext().getResources().getString(R.string.top_downloads_title))) {
            this.f17833d.b(s5.a(), true);
        } else {
            this.f17833d.b(s5.a(), false);
        }
    }

    public final C0980k d() {
        return this.f17833d;
    }
}
