package C2;

import S1.k;
import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import java.util.Arrays;
import k2.C2592b;
import kotlin.jvm.internal.Q;
import kotlin.jvm.internal.t;
import l2.C2646F;
import l2.C2655d;
import z2.P;

/* renamed from: C2.x0  reason: case insensitive filesystem */
public final class C2068x0 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final C2592b f17918a;

    /* renamed from: b  reason: collision with root package name */
    private final Context f17919b;

    /* renamed from: c  reason: collision with root package name */
    private final ImageView f17920c;

    /* renamed from: d  reason: collision with root package name */
    private final TextView f17921d;

    /* renamed from: e  reason: collision with root package name */
    private final TextView f17922e;

    /* renamed from: f  reason: collision with root package name */
    private final TextView f17923f;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2068x0(View view, C2592b bVar, Context context) {
        super(view);
        t.e(view, "itemView");
        t.e(context, "context");
        this.f17918a = bVar;
        this.f17919b = context;
        View findViewById = view.findViewById(R.id.iv_icon_positive);
        t.d(findViewById, "findViewById(...)");
        ImageView imageView = (ImageView) findViewById;
        this.f17920c = imageView;
        View findViewById2 = view.findViewById(R.id.tv_name_app_positive);
        t.d(findViewById2, "findViewById(...)");
        TextView textView = (TextView) findViewById2;
        this.f17921d = textView;
        View findViewById3 = view.findViewById(R.id.tv_version_app_positive);
        t.d(findViewById3, "findViewById(...)");
        TextView textView2 = (TextView) findViewById3;
        this.f17922e = textView2;
        View findViewById4 = view.findViewById(R.id.tv_count_positives);
        t.d(findViewById4, "findViewById(...)");
        TextView textView3 = (TextView) findViewById4;
        this.f17923f = textView3;
        view.setOnClickListener(new C2062v0(this));
        imageView.setOnClickListener(new C2065w0(this));
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        textView2.setTypeface(aVar.x());
        textView3.setTypeface(aVar.x());
    }

    /* access modifiers changed from: private */
    public static final void c(C2068x0 x0Var, View view) {
        int bindingAdapterPosition;
        if (x0Var.f17918a != null && (bindingAdapterPosition = x0Var.getBindingAdapterPosition()) != -1) {
            x0Var.f17918a.a(bindingAdapterPosition);
        }
    }

    /* access modifiers changed from: private */
    public static final void d(C2068x0 x0Var, View view) {
        int bindingAdapterPosition;
        if (x0Var.f17918a != null && (bindingAdapterPosition = x0Var.getBindingAdapterPosition()) != -1) {
            x0Var.f17918a.b(bindingAdapterPosition);
        }
    }

    public final void e(C2655d dVar) {
        if (dVar != null) {
            this.f17920c.setImageDrawable(P.f26510a.j(this.f17919b, dVar.o()));
            this.f17921d.setText(dVar.m());
            this.f17922e.setText(dVar.B());
            if (dVar.p() != null) {
                Q q5 = Q.f24695a;
                String string = this.f17919b.getString(R.string.x_positives);
                t.d(string, "getString(...)");
                C2646F p5 = dVar.p();
                t.b(p5);
                String format = String.format(string, Arrays.copyOf(new Object[]{String.valueOf(p5.b())}, 1));
                t.d(format, "format(...)");
                this.f17923f.setText(format);
            }
        }
    }
}
