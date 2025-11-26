package f2;

import S1.f;
import S1.k;
import X1.l;
import android.view.View;
import android.widget.CheckBox;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.t;

public final class g extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public CheckBox f21623a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public g(View view, l lVar) {
        super(view);
        t.e(view, "itemView");
        t.e(lVar, "listener");
        View findViewById = view.findViewById(f.cb_split_item);
        t.d(findViewById, "findViewById(...)");
        this.f21623a = (CheckBox) findViewById;
        view.setOnClickListener(new f(this, lVar));
        this.f21623a.setTypeface(k.f32g.x());
    }

    /* access modifiers changed from: private */
    public static final void b(g gVar, l lVar, View view) {
        int absoluteAdapterPosition = gVar.getAbsoluteAdapterPosition();
        if (absoluteAdapterPosition != -1) {
            lVar.a(view, absoluteAdapterPosition);
        }
    }
}
