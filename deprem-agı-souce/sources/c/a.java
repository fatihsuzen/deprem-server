package c;

import E1.b;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.t;

public final class a extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public final Integer f856a;

    /* renamed from: b  reason: collision with root package name */
    public final Integer f857b;

    /* renamed from: c  reason: collision with root package name */
    public final Typeface f858c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f859d;

    /* renamed from: e  reason: collision with root package name */
    public final View f860e;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public a(View view, Integer num, Integer num2, Typeface typeface) {
        super(view);
        t.e(view, "rootView");
        this.f856a = num;
        this.f857b = num2;
        this.f858c = typeface;
        View findViewById = view.findViewById(b.tv_non_switch_label);
        t.d(findViewById, "rootView.findViewById(R.id.tv_non_switch_label)");
        this.f859d = (TextView) findViewById;
        View findViewById2 = view.findViewById(b.item_divider);
        t.d(findViewById2, "rootView.findViewById(R.id.item_divider)");
        this.f860e = findViewById2;
    }
}
