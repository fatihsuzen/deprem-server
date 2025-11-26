package c;

import E1.b;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.t;

public final class d extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public final Integer f865a;

    /* renamed from: b  reason: collision with root package name */
    public final Integer f866b;

    /* renamed from: c  reason: collision with root package name */
    public final Typeface f867c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f868d;

    /* renamed from: e  reason: collision with root package name */
    public final View f869e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public d(View view, Integer num, Integer num2, Typeface typeface) {
        super(view);
        t.e(view, "rootView");
        this.f865a = num;
        this.f866b = num2;
        this.f867c = typeface;
        View findViewById = view.findViewById(b.tv_switch_label);
        t.d(findViewById, "rootView.findViewById(R.id.tv_switch_label)");
        this.f868d = (TextView) findViewById;
        View findViewById2 = view.findViewById(b.item_divider);
        t.d(findViewById2, "rootView.findViewById(R.id.item_divider)");
        this.f869e = findViewById2;
    }
}
