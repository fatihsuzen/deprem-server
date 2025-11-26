package c;

import E1.b;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.t;

public final class c extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public final Integer f861a;

    /* renamed from: b  reason: collision with root package name */
    public final Integer f862b;

    /* renamed from: c  reason: collision with root package name */
    public final Typeface f863c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f864d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public c(View view, Integer num, Integer num2, Typeface typeface) {
        super(view);
        t.e(view, "rootView");
        this.f861a = num;
        this.f862b = num2;
        this.f863c = typeface;
        View findViewById = view.findViewById(b.tv_switch_description);
        t.d(findViewById, "rootView.findViewById(R.id.tv_switch_description)");
        this.f864d = (TextView) findViewById;
    }

    public final void a(String str) {
        t.e(str, "descriptionText");
        TextView textView = this.f864d;
        textView.setText(str);
        Integer num = this.f861a;
        if (num != null) {
            textView.setTextColor(num.intValue());
        }
        Typeface typeface = this.f863c;
        if (typeface != null) {
            textView.setTypeface(typeface);
        }
        Integer num2 = this.f862b;
        if (num2 != null) {
            int intValue = num2.intValue();
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setCornerRadius(2.0f);
            gradientDrawable.setStroke(4, intValue);
            textView.setBackground(gradientDrawable);
        }
    }
}
