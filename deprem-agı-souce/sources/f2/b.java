package f2;

import S1.f;
import S1.k;
import X1.C2233j;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.t;

public final class b extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private TextView f21610a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(View view, C2233j jVar) {
        super(view);
        t.e(view, "itemView");
        View findViewById = view.findViewById(f.tv_device_name);
        t.d(findViewById, "findViewById(...)");
        this.f21610a = (TextView) findViewById;
        view.setOnClickListener(new C2377a(jVar, this));
        this.f21610a.setTypeface(k.f32g.x());
    }

    /* access modifiers changed from: private */
    public static final void b(C2233j jVar, b bVar, View view) {
        int absoluteAdapterPosition;
        if (jVar != null && (absoluteAdapterPosition = bVar.getAbsoluteAdapterPosition()) != -1) {
            jVar.a(view, absoluteAdapterPosition);
        }
    }

    public final TextView c() {
        return this.f21610a;
    }
}
