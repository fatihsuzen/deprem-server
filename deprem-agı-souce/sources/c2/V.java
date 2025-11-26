package C2;

import B2.f;
import R1.C0975f;
import R1.C0978i;
import S1.k;
import X2.C2250q;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import java.util.ArrayList;
import java.util.Iterator;
import k2.C2587D;
import k2.C2591a;
import k2.C2611v;
import kotlin.jvm.internal.t;
import l2.C2657f;
import l2.C2660i;

public final class V extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private C2611v f17619a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f17620b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public RecyclerView f17621c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public C0978i f17622d;

    /* renamed from: e  reason: collision with root package name */
    private LinearLayoutManager f17623e;

    /* renamed from: f  reason: collision with root package name */
    private LinearLayout f17624f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public final f f17625g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public boolean f17626h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public int f17627i = 102;

    public static final class a extends RecyclerView.OnScrollListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ V f17628a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2587D f17629b;

        a(V v5, C2587D d5) {
            this.f17628a = v5;
            this.f17629b = d5;
        }

        public void onScrollStateChanged(RecyclerView recyclerView, int i5) {
            View findSnapView;
            int childAdapterPosition;
            t.e(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, i5);
            if (i5 == 0 && (findSnapView = this.f17628a.f17625g.findSnapView(recyclerView.getLayoutManager())) != null && (childAdapterPosition = this.f17628a.f17621c.getChildAdapterPosition(findSnapView) % this.f17628a.f17622d.a().size()) != -1 && childAdapterPosition != this.f17628a.f17627i) {
                this.f17628a.f17627i = childAdapterPosition;
                Object obj = this.f17628a.f17622d.a().get(childAdapterPosition);
                t.d(obj, "get(...)");
                C2657f fVar = (C2657f) obj;
                if (fVar.N0() && !this.f17628a.f17626h) {
                    this.f17629b.a(fVar);
                    this.f17628a.f17626h = true;
                }
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public V(View view, C2611v vVar, C2591a aVar, C2587D d5) {
        super(view);
        t.e(view, "itemView");
        t.e(aVar, "actionsClickListener");
        t.e(d5, "promotedistener");
        this.f17619a = vVar;
        View findViewById = view.findViewById(R.id.tv_title_header);
        t.d(findViewById, "findViewById(...)");
        this.f17620b = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.rv_home_features);
        t.d(findViewById2, "findViewById(...)");
        this.f17621c = (RecyclerView) findViewById2;
        this.f17622d = new C0978i(this.f17619a, aVar);
        this.f17623e = new LinearLayoutManager(view.getContext(), 0, false);
        View findViewById3 = view.findViewById(R.id.ll_categories);
        t.d(findViewById3, "findViewById(...)");
        this.f17624f = (LinearLayout) findViewById3;
        f fVar = new f();
        this.f17625g = fVar;
        this.f17620b.setTypeface(k.f32g.w());
        fVar.attachToRecyclerView(this.f17621c);
        this.f17621c.setLayoutManager(this.f17623e);
        this.f17621c.setAdapter(this.f17622d);
        this.f17621c.addOnScrollListener(new a(this, d5));
        this.f17621c.post(new U(this, d5));
    }

    /* access modifiers changed from: private */
    public static final void c(V v5, C2587D d5) {
        int childAdapterPosition;
        View findSnapView = v5.f17625g.findSnapView(v5.f17621c.getLayoutManager());
        if (findSnapView != null && (childAdapterPosition = v5.f17621c.getChildAdapterPosition(findSnapView) % v5.f17622d.a().size()) != -1) {
            Object obj = v5.f17622d.a().get(childAdapterPosition);
            t.d(obj, "get(...)");
            C2657f fVar = (C2657f) obj;
            if (fVar.N0() && !v5.f17626h) {
                d5.a(fVar);
                v5.f17626h = true;
            }
        }
    }

    private final void l(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        t.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            t.d(next, "next(...)");
            C2660i iVar = (C2660i) next;
            View inflate = LayoutInflater.from(this.itemView.getContext()).inflate(R.layout.chip_category, this.f17624f, false);
            t.c(inflate, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) inflate;
            textView.setTypeface(k.f32g.w());
            textView.setText(iVar.e());
            if (t.a(iVar, C2250q.X(arrayList))) {
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                layoutParams.setMargins((int) this.itemView.getContext().getResources().getDimension(R.dimen.margin_m), 0, (int) this.itemView.getContext().getResources().getDimension(R.dimen.margin_m), 0);
                textView.setLayoutParams(layoutParams);
            }
            textView.setOnClickListener(new T(this, iVar));
            this.f17624f.addView(textView);
        }
    }

    /* access modifiers changed from: private */
    public static final void m(V v5, C2660i iVar, View view) {
        C2611v vVar = v5.f17619a;
        if (vVar != null) {
            vVar.a(iVar);
        }
    }

    public final void k(C0975f.b bVar) {
        t.e(bVar, "homeHeader");
        this.f17620b.setText(bVar.c());
        if (!bVar.b().isEmpty()) {
            this.f17621c.scrollToPosition(this.f17627i);
            this.f17621c.smoothScrollBy(1, 0);
            this.f17622d.d(bVar.b());
        }
        if (this.f17624f.getChildCount() == 0) {
            l(bVar.a());
        }
    }
}
