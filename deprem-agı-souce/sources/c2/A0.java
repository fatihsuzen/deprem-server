package C2;

import B2.v;
import S1.k;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.s;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import h2.F0;
import k2.Y;
import kotlin.jvm.internal.t;
import l2.C2647G;

public final class A0 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final F0 f17432a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f17433b;

    /* renamed from: c  reason: collision with root package name */
    private final Y f17434c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f17435d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public A0(F0 f02, Context context, Y y4, boolean z4) {
        super(f02.getRoot());
        t.e(f02, "binding");
        t.e(context, "context");
        this.f17432a = f02;
        this.f17433b = context;
        this.f17434c = y4;
        this.f17435d = z4;
        f02.f22365d.setOnClickListener(new C2071y0(this));
        f02.f22366e.setOnClickListener(new C2074z0(this));
        TextView textView = f02.f22368g;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        f02.f22366e.setTypeface(aVar.w());
        f02.f22367f.setTypeface(aVar.x());
    }

    /* access modifiers changed from: private */
    public static final void c(A0 a02, View view) {
        int bindingAdapterPosition;
        if (a02.f17434c != null && (bindingAdapterPosition = a02.getBindingAdapterPosition()) != -1) {
            a02.f17434c.a(bindingAdapterPosition);
        }
    }

    /* access modifiers changed from: private */
    public static final void d(A0 a02, View view) {
        int bindingAdapterPosition;
        if (a02.f17434c != null && (bindingAdapterPosition = a02.getBindingAdapterPosition()) != -1) {
            a02.f17434c.f(bindingAdapterPosition);
        }
    }

    public final void e(C2647G g5) {
        t.e(g5, "item");
        s.h().l(g5.e()).l(R.drawable.shape_bg_placeholder).n(UptodownApp.f13477F.g0(this.f17433b)).i(this.f17432a.f22363b);
        this.f17432a.f22368g.setText(g5.f());
        this.f17432a.f22367f.setText(g5.c());
        if (this.f17435d) {
            this.f17432a.f22366e.setText(this.f17433b.getString(R.string.cancel_registration));
            TextView textView = this.f17432a.f22366e;
            t.d(textView, "tvActionUpcomingReleaseItem");
            v.d(textView);
            return;
        }
        this.f17432a.f22366e.setText(this.f17433b.getString(R.string.pre_registration_title));
        TextView textView2 = this.f17432a.f22366e;
        t.d(textView2, "tvActionUpcomingReleaseItem");
        v.a(textView2);
    }
}
