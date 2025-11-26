package v4;

import E1.b;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.t;
import m4.q;

public final class r extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public final Typeface f26106a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f26107b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public r(View view, Typeface typeface) {
        super(view);
        t.e(view, "rootView");
        this.f26106a = typeface;
        View findViewById = view.findViewById(b.tv_publisher_link_name);
        t.d(findViewById, "rootView.findViewById(R.id.tv_publisher_link_name)");
        this.f26107b = (TextView) findViewById;
    }

    public static final void a(Context context, q qVar, View view) {
        t.e(context, "$context");
        t.e(qVar, "$item");
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(qVar.f25486b));
        context.startActivity(intent);
    }

    public final void b(Context context, q qVar, Integer num) {
        t.e(context, "context");
        t.e(qVar, "item");
        SpannableString spannableString = new SpannableString(qVar.f25485a);
        spannableString.setSpan(new UnderlineSpan(), 0, spannableString.length(), 0);
        TextView textView = this.f26107b;
        textView.setText(spannableString);
        if (num != null) {
            textView.setTextColor(num.intValue());
        }
        Typeface typeface = this.f26106a;
        if (typeface != null) {
            textView.setTypeface(typeface);
        }
        if (qVar.f25486b.length() > 0) {
            this.itemView.setOnClickListener(new q(context, qVar));
        }
    }
}
