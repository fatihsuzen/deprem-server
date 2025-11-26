package C2;

import S1.k;
import X2.C2250q;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import java.util.ArrayList;
import java.util.Iterator;
import k2.C2611v;
import kotlin.jvm.internal.t;
import l2.C2660i;

public final class J extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private C2611v f17518a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f17519b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f17520c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public J(View view, C2611v vVar) {
        super(view);
        t.e(view, "itemView");
        t.e(vVar, "listener");
        this.f17518a = vVar;
        View findViewById = view.findViewById(R.id.tv_floating_categories);
        t.d(findViewById, "findViewById(...)");
        this.f17519b = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.ll_floating_categories);
        t.d(findViewById2, "findViewById(...)");
        this.f17520c = (LinearLayout) findViewById2;
        this.f17519b.setTypeface(k.f32g.w());
    }

    private final void c(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        t.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            t.d(next, "next(...)");
            C2660i iVar = (C2660i) next;
            View inflate = LayoutInflater.from(this.itemView.getContext()).inflate(R.layout.chip_floating_category, this.f17520c, false);
            t.c(inflate, "null cannot be cast to non-null type android.widget.TextView");
            TextView textView = (TextView) inflate;
            textView.setTypeface(k.f32g.w());
            textView.setText(iVar.e());
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            int dimension = (int) this.itemView.getContext().getResources().getDimension(R.dimen.margin_m);
            if (t.a(iVar, C2250q.X(arrayList))) {
                layoutParams.setMargins(dimension, 0, dimension, 0);
            } else {
                layoutParams.setMargins(dimension, 0, 0, 0);
            }
            textView.setLayoutParams(layoutParams);
            textView.setOnClickListener(new I(this, iVar));
            this.f17520c.addView(textView);
        }
    }

    /* access modifiers changed from: private */
    public static final void d(J j5, C2660i iVar, View view) {
        j5.f17518a.a(iVar);
    }

    public final void b(ArrayList arrayList) {
        t.e(arrayList, "floatingCategories");
        this.f17519b.setText(this.itemView.getContext().getString(R.string.it_may_interest_you));
        if (this.f17520c.getChildCount() == 0) {
            c(arrayList);
        }
    }
}
