package C2;

import S1.k;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.R;
import k2.C2592b;
import kotlin.jvm.internal.t;
import l2.C2655d;
import z2.P;

public final class Q extends C2038n {

    /* renamed from: b  reason: collision with root package name */
    private final C2592b f17571b;

    /* renamed from: c  reason: collision with root package name */
    private final Context f17572c;

    /* renamed from: d  reason: collision with root package name */
    private final ImageView f17573d;

    /* renamed from: e  reason: collision with root package name */
    private final TextView f17574e;

    /* renamed from: f  reason: collision with root package name */
    private final TextView f17575f;

    /* renamed from: g  reason: collision with root package name */
    private final TextView f17576g;

    /* renamed from: h  reason: collision with root package name */
    private final RelativeLayout f17577h;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Q(View view, C2592b bVar, Context context) {
        super(view);
        t.e(view, "itemView");
        t.e(context, "context");
        this.f17571b = bVar;
        this.f17572c = context;
        View findViewById = view.findViewById(R.id.iv_icon_free_up_item);
        t.d(findViewById, "findViewById(...)");
        this.f17573d = (ImageView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_name_free_up_item);
        t.d(findViewById2, "findViewById(...)");
        TextView textView = (TextView) findViewById2;
        this.f17574e = textView;
        View findViewById3 = view.findViewById(R.id.tv_size_free_up_item);
        t.d(findViewById3, "findViewById(...)");
        TextView textView2 = (TextView) findViewById3;
        this.f17575f = textView2;
        View findViewById4 = view.findViewById(R.id.tv_action_free_up_item);
        t.d(findViewById4, "findViewById(...)");
        TextView textView3 = (TextView) findViewById4;
        this.f17576g = textView3;
        View findViewById5 = view.findViewById(R.id.rl_container_free_up_item);
        t.d(findViewById5, "findViewById(...)");
        RelativeLayout relativeLayout = (RelativeLayout) findViewById5;
        this.f17577h = relativeLayout;
        relativeLayout.setOnClickListener(new O(this));
        textView3.setOnClickListener(new P(this));
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        textView3.setTypeface(aVar.w());
        textView2.setTypeface(aVar.x());
    }

    /* access modifiers changed from: private */
    public static final void i(Q q5, View view) {
        int bindingAdapterPosition;
        if (q5.f17571b != null && (bindingAdapterPosition = q5.getBindingAdapterPosition()) != -1) {
            q5.f17571b.a(bindingAdapterPosition);
        }
    }

    /* access modifiers changed from: private */
    public static final void j(Q q5, View view) {
        C2592b bVar = q5.f17571b;
        if (bVar != null) {
            bVar.a(q5.getBindingAdapterPosition());
        }
    }

    public final void k(C2655d dVar) {
        t.e(dVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        this.f17574e.setText(dVar.m());
        this.f17575f.setText(dVar.u(this.f17572c));
        this.f17573d.setImageDrawable(P.f26510a.j(this.f17572c, dVar.o()));
    }
}
