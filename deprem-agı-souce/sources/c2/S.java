package C2;

import S1.k;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.squareup.picasso.s;
import com.uptodown.R;
import com.uptodown.UptodownApp;
import kotlin.jvm.internal.t;
import l2.C2655d;
import l2.C2657f;
import z2.P;

public final class S extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final Context f17589a;

    /* renamed from: b  reason: collision with root package name */
    private final ImageView f17590b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f17591c;

    /* renamed from: d  reason: collision with root package name */
    private final TextView f17592d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public S(View view, Context context) {
        super(view);
        t.e(view, "itemView");
        t.e(context, "context");
        this.f17589a = context;
        View findViewById = view.findViewById(R.id.iv_logo_app);
        t.d(findViewById, "findViewById(...)");
        this.f17590b = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_app_name);
        t.d(findViewById2, "findViewById(...)");
        TextView textView = (TextView) findViewById2;
        this.f17591c = textView;
        View findViewById3 = view.findViewById(R.id.tv_app_version);
        t.d(findViewById3, "findViewById(...)");
        TextView textView2 = (TextView) findViewById3;
        this.f17592d = textView2;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        textView2.setTypeface(aVar.x());
    }

    public final void a(C2655d dVar) {
        if (dVar != null) {
            this.f17590b.setImageDrawable(P.f26510a.j(this.f17589a, dVar.o()));
            this.f17591c.setText(dVar.m());
            this.f17592d.setText(dVar.B());
        }
    }

    public final void b(C2657f fVar) {
        if (fVar != null) {
            String H4 = fVar.H();
            if (H4 == null || H4.length() == 0) {
                this.f17590b.setImageDrawable(ContextCompat.getDrawable(this.f17589a, R.drawable.vector_app_icon_placeholder));
            } else {
                s.h().l(fVar.H()).n(UptodownApp.f13477F.g0(this.f17589a)).i(this.f17590b);
            }
            this.f17591c.setText(fVar.N());
            this.f17592d.setText(fVar.B0());
        }
    }
}
