package C2;

import S1.k;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import h2.k1;
import k2.O;
import kotlin.jvm.internal.t;
import l2.X;
import z2.C2962v;

public final class N1 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final k1 f17563a;

    /* renamed from: b  reason: collision with root package name */
    private final O f17564b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public N1(k1 k1Var, O o5) {
        super(k1Var.getRoot());
        t.e(k1Var, "binding");
        this.f17563a = k1Var;
        this.f17564b = o5;
        k1Var.getRoot().setOnClickListener(new L1(this));
        k1Var.f23288c.setOnClickListener(new M1(this));
        TextView textView = k1Var.f23291f;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        k1Var.f23290e.setTypeface(aVar.x());
    }

    /* access modifiers changed from: private */
    public static final void c(N1 n12, View view) {
        n12.f();
    }

    /* access modifiers changed from: private */
    public static final void d(N1 n12, View view) {
        n12.f();
    }

    private final void f() {
        int bindingAdapterPosition;
        if (this.f17564b != null && (bindingAdapterPosition = getBindingAdapterPosition()) != -1) {
            this.f17564b.a(bindingAdapterPosition);
        }
    }

    public final void e(X x4) {
        t.e(x4, "userDevice");
        this.f17563a.f23291f.setText(x4.g());
        this.f17563a.f23290e.setText(new C2962v().p(x4.e()));
        int j5 = x4.j();
        if (j5 == 0) {
            this.f17563a.f23287b.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_user_device_mobile_item));
        } else if (j5 == 1) {
            this.f17563a.f23287b.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_user_device_tablet_item));
        } else if (j5 == 2) {
            this.f17563a.f23287b.setImageDrawable(ContextCompat.getDrawable(this.itemView.getContext(), R.drawable.vector_user_device_tv_item));
        }
    }
}
