package C2;

import R1.C0982m;
import S1.k;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import k2.C2591a;
import k2.C2611v;
import kotlin.jvm.internal.t;
import l2.S;

/* renamed from: C2.b0  reason: case insensitive filesystem */
public final class C2003b0 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private C2611v f17705a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f17706b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f17707c;

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView f17708d;

    /* renamed from: e  reason: collision with root package name */
    private GridLayoutManager f17709e;

    /* renamed from: f  reason: collision with root package name */
    private C0982m f17710f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2003b0(View view, C2611v vVar, C2591a aVar) {
        super(view);
        t.e(view, "itemView");
        t.e(vVar, "listener");
        t.e(aVar, "actionsClickListener");
        this.f17705a = vVar;
        View findViewById = view.findViewById(R.id.rl_title_home_recycler_view_top);
        t.d(findViewById, "findViewById(...)");
        this.f17706b = (RelativeLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_title_home_recycler_view_top);
        t.d(findViewById2, "findViewById(...)");
        this.f17707c = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.rv_home_recycler_view_top);
        t.d(findViewById3, "findViewById(...)");
        this.f17708d = (RecyclerView) findViewById3;
        this.f17709e = new GridLayoutManager(view.getContext(), 3, 0, false);
        this.f17710f = new C0982m(this.f17705a, aVar);
        this.f17707c.setTypeface(k.f32g.w());
        this.f17708d.setLayoutManager(this.f17709e);
        this.f17708d.setAdapter(this.f17710f);
        this.f17708d.setItemAnimator((RecyclerView.ItemAnimator) null);
    }

    /* access modifiers changed from: private */
    public static final void c(C2003b0 b0Var, S s5, View view) {
        b0Var.f17705a.c(s5);
    }

    public final void b(S s5) {
        t.e(s5, "topByCategory");
        this.f17706b.setOnClickListener(new C2000a0(this, s5));
        this.f17707c.setText(s5.b().e());
        this.f17710f.d(s5.a());
    }

    public final C0982m d() {
        return this.f17710f;
    }
}
