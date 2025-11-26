package C2;

import R1.K;
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

public final class Z extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private C2611v f17678a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f17679b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f17680c;

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView f17681d;

    /* renamed from: e  reason: collision with root package name */
    private LinearLayoutManager f17682e;

    /* renamed from: f  reason: collision with root package name */
    private final K f17683f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Z(View view, C2611v vVar, C2591a aVar) {
        super(view);
        t.e(view, "itemView");
        t.e(vVar, "listener");
        t.e(aVar, "actionsClickListener");
        this.f17678a = vVar;
        View findViewById = view.findViewById(R.id.rl_title_home_recycler_view_top);
        t.d(findViewById, "findViewById(...)");
        this.f17679b = (RelativeLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_title_home_recycler_view_top);
        t.d(findViewById2, "findViewById(...)");
        this.f17680c = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.rv_home_recycler_view_top);
        t.d(findViewById3, "findViewById(...)");
        this.f17681d = (RecyclerView) findViewById3;
        this.f17682e = new LinearLayoutManager(view.getContext(), 0, false);
        K k5 = new K(this.f17678a, aVar, 20);
        this.f17683f = k5;
        this.f17680c.setTypeface(k.f32g.w());
        this.f17681d.setItemAnimator((RecyclerView.ItemAnimator) null);
        this.f17681d.setLayoutManager(this.f17682e);
        this.f17681d.setAdapter(k5);
    }

    /* access modifiers changed from: private */
    public static final void c(Z z4, S s5, View view) {
        z4.f17678a.c(s5);
    }

    public final void b(S s5) {
        t.e(s5, "topByCategory");
        if (!s5.a().isEmpty()) {
            this.f17679b.setOnClickListener(new Y(this, s5));
            this.f17680c.setText(s5.b().e());
            this.f17683f.d(s5.a());
            return;
        }
        this.itemView.setVisibility(8);
    }

    public final K d() {
        return this.f17683f;
    }
}
