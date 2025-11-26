package C2;

import B2.f;
import R1.e0;
import S1.k;
import android.content.Context;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import com.uptodown.activities.preferences.a;
import java.util.ArrayList;
import k2.C2591a;
import k2.C2611v;
import kotlin.jvm.internal.t;
import l2.C2657f;
import l2.S;

public final class X1 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private C2611v f17651a;

    /* renamed from: b  reason: collision with root package name */
    private RelativeLayout f17652b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f17653c;

    /* renamed from: d  reason: collision with root package name */
    private RecyclerView f17654d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public LinearLayoutManager f17655e;

    /* renamed from: f  reason: collision with root package name */
    private final e0 f17656f;

    public static final class a extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ X1 f17657a;

        a(X1 x12) {
            this.f17657a = x12;
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i5) {
            t.e(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i5);
            if (!this.f17657a.e().o()) {
                this.f17657a.e().x(true);
            }
            if (i5 == 0) {
                int findFirstCompletelyVisibleItemPosition = this.f17657a.f17655e.findFirstCompletelyVisibleItemPosition();
                int findLastCompletelyVisibleItemPosition = this.f17657a.f17655e.findLastCompletelyVisibleItemPosition();
                int n5 = this.f17657a.e().n();
                if (findLastCompletelyVisibleItemPosition == this.f17657a.f17655e.getItemCount() - 1 && findLastCompletelyVisibleItemPosition != this.f17657a.e().n()) {
                    this.f17657a.e().u(findLastCompletelyVisibleItemPosition);
                    ArrayList D02 = ((C2657f) this.f17657a.e().m().get(n5)).D0();
                    if (D02 != null && !D02.isEmpty()) {
                        this.f17657a.e().notifyItemChanged(n5);
                    }
                    ArrayList D03 = ((C2657f) this.f17657a.e().m().get(findLastCompletelyVisibleItemPosition)).D0();
                    if (D03 != null && !D03.isEmpty()) {
                        this.f17657a.e().notifyItemChanged(findLastCompletelyVisibleItemPosition);
                    }
                } else if (findFirstCompletelyVisibleItemPosition != -1 && findFirstCompletelyVisibleItemPosition != this.f17657a.e().n()) {
                    this.f17657a.e().u(findFirstCompletelyVisibleItemPosition);
                    ArrayList D04 = ((C2657f) this.f17657a.e().m().get(n5)).D0();
                    if (D04 != null && !D04.isEmpty()) {
                        this.f17657a.e().notifyItemChanged(n5);
                    }
                    ArrayList D05 = ((C2657f) this.f17657a.e().m().get(findFirstCompletelyVisibleItemPosition)).D0();
                    if (D05 != null && !D05.isEmpty()) {
                        this.f17657a.e().notifyItemChanged(findFirstCompletelyVisibleItemPosition);
                    }
                }
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public X1(View view, C2611v vVar, C2591a aVar, String str) {
        super(view);
        t.e(view, "itemView");
        t.e(vVar, "listener");
        t.e(aVar, "actionsClickListener");
        t.e(str, "fragmentName");
        this.f17651a = vVar;
        View findViewById = view.findViewById(R.id.rl_title_home_recycler_view_top);
        t.d(findViewById, "findViewById(...)");
        this.f17652b = (RelativeLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_title_home_recycler_view_top);
        t.d(findViewById2, "findViewById(...)");
        this.f17653c = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.rv_home_recycler_view_top);
        t.d(findViewById3, "findViewById(...)");
        this.f17654d = (RecyclerView) findViewById3;
        this.f17655e = new LinearLayoutManager(view.getContext(), 0, false);
        C2611v vVar2 = this.f17651a;
        Context context = view.getContext();
        t.d(context, "getContext(...)");
        e0 e0Var = new e0(vVar2, aVar, context, str);
        this.f17656f = e0Var;
        new f().attachToRecyclerView(this.f17654d);
        this.f17653c.setTypeface(k.f32g.w());
        this.f17654d.setLayoutManager(this.f17655e);
        this.f17654d.setItemAnimator((RecyclerView.ItemAnimator) null);
        this.f17654d.setAdapter(e0Var);
        a.C0147a aVar2 = com.uptodown.activities.preferences.a.f15150a;
        Context context2 = view.getContext();
        t.d(context2, "getContext(...)");
        if (!aVar2.N(context2)) {
            this.f17654d.addOnScrollListener(new a(this));
        }
    }

    /* access modifiers changed from: private */
    public static final void d(X1 x12, S s5, View view) {
        x12.f17651a.c(s5);
    }

    public final void c(S s5) {
        t.e(s5, "topByCategory");
        this.f17652b.setOnClickListener(new W1(this, s5));
        this.f17653c.setText(s5.b().e());
        this.f17656f.v(s5.a());
    }

    public final e0 e() {
        return this.f17656f;
    }
}
