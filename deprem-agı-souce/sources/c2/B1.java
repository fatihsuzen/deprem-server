package C2;

import D2.n;
import S1.k;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import java.util.ArrayList;
import k2.L;
import kotlin.jvm.internal.t;

public final class B1 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final L f17440a;

    /* renamed from: b  reason: collision with root package name */
    private final LinearLayout f17441b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f17442c;

    /* renamed from: d  reason: collision with root package name */
    private final ImageView f17443d;

    /* renamed from: e  reason: collision with root package name */
    private final TextView f17444e;

    /* renamed from: f  reason: collision with root package name */
    private final TextView f17445f;

    /* renamed from: g  reason: collision with root package name */
    private final RelativeLayout f17446g;

    /* renamed from: h  reason: collision with root package name */
    private final ImageView f17447h;

    /* renamed from: i  reason: collision with root package name */
    private final int f17448i = 600;

    /* renamed from: j  reason: collision with root package name */
    private long f17449j;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public B1(View view, L l5) {
        super(view);
        t.e(view, "itemView");
        t.e(l5, "listener");
        this.f17440a = l5;
        View findViewById = view.findViewById(R.id.ll_uptodown_protect);
        t.d(findViewById, "findViewById(...)");
        this.f17441b = (LinearLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_uptodown_protect);
        t.d(findViewById2, "findViewById(...)");
        TextView textView = (TextView) findViewById2;
        this.f17442c = textView;
        View findViewById3 = view.findViewById(R.id.iv_shield);
        t.d(findViewById3, "findViewById(...)");
        this.f17443d = (ImageView) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_title);
        t.d(findViewById4, "findViewById(...)");
        TextView textView2 = (TextView) findViewById4;
        this.f17444e = textView2;
        View findViewById5 = view.findViewById(R.id.tv_msg);
        t.d(findViewById5, "findViewById(...)");
        TextView textView3 = (TextView) findViewById5;
        this.f17445f = textView3;
        View findViewById6 = view.findViewById(R.id.rl_reload);
        t.d(findViewById6, "findViewById(...)");
        this.f17446g = (RelativeLayout) findViewById6;
        View findViewById7 = view.findViewById(R.id.iv_reload);
        t.d(findViewById7, "findViewById(...)");
        this.f17447h = (ImageView) findViewById7;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        textView2.setTypeface(aVar.x());
        textView3.setTypeface(aVar.x());
    }

    /* access modifiers changed from: private */
    public static final void e(B1 b12, Context context, View view) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - b12.f17449j > ((long) b12.f17448i)) {
            b12.f17449j = currentTimeMillis;
            new n(context).f(-1, b12.f17447h, R.anim.rotate);
            b12.f17440a.b();
        }
    }

    /* access modifiers changed from: private */
    public static final void f(B1 b12, View view) {
        b12.f17440a.a();
    }

    public final void d(ArrayList arrayList, Context context) {
        t.e(context, "context");
        this.f17441b.setVisibility(0);
        this.f17446g.setOnClickListener(new C2072y1(this, context));
        if (arrayList == null || arrayList.size() <= 0) {
            this.f17443d.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_shield_protect_ok));
            this.f17444e.setText(R.string.no_positives_title_security_badge);
            this.f17445f.setText(R.string.no_positives_msg_security_badge);
            this.f17446g.setBackground(ContextCompat.getDrawable(context, R.drawable.ripple_blue_primary_button));
            this.itemView.setOnClickListener(new A1());
        } else {
            this.f17443d.setImageDrawable(ContextCompat.getDrawable(context, R.drawable.vector_shield_protect_bad));
            this.f17444e.setText(R.string.positives_title_security_badge);
            this.f17445f.setText(R.string.positives_msg_security_badge);
            this.f17446g.setBackground(ContextCompat.getDrawable(context, R.drawable.ripple_cancel_button));
            this.itemView.setOnClickListener(new C2075z1(this));
        }
        if (this.f17447h.getAnimation() != null && this.f17447h.getAnimation().getRepeatCount() != 0) {
            this.f17447h.getAnimation().setRepeatCount(0);
        }
    }

    /* access modifiers changed from: private */
    public static final void g(View view) {
    }
}
