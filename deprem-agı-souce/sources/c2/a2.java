package C2;

import S1.k;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import k2.K;
import kotlin.jvm.internal.t;
import z2.P;

public final class a2 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f17694a;

    /* renamed from: b  reason: collision with root package name */
    private final TextView f17695b;

    /* renamed from: c  reason: collision with root package name */
    private final TextView f17696c;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a2(View view, K k5) {
        super(view);
        t.e(view, "itemView");
        t.e(k5, "listener");
        View findViewById = view.findViewById(R.id.ll_no_tracking_container_updates);
        t.d(findViewById, "findViewById(...)");
        this.f17694a = (LinearLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_no_tracking_msg_updates);
        t.d(findViewById2, "findViewById(...)");
        TextView textView = (TextView) findViewById2;
        this.f17695b = textView;
        View findViewById3 = view.findViewById(R.id.tv_gdpr_set_up_updates);
        t.d(findViewById3, "findViewById(...)");
        TextView textView2 = (TextView) findViewById3;
        this.f17696c = textView2;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.x());
        textView.setText(P.f26510a.c(view.getContext().getString(R.string.gdpr_no_tracking_enabled)));
        textView2.setTypeface(aVar.w());
        textView2.setOnClickListener(new Z1(k5));
    }

    /* access modifiers changed from: private */
    public static final void b(K k5, View view) {
        k5.a();
    }

    public final void c(boolean z4) {
        if (z4) {
            this.f17694a.setVisibility(0);
        } else {
            this.f17694a.setVisibility(8);
        }
    }
}
