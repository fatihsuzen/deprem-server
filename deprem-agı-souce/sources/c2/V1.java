package C2;

import S1.k;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import h2.p1;
import k2.O;
import kotlin.jvm.internal.t;
import l2.Z;

public final class V1 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final p1 f17633a;

    /* renamed from: b  reason: collision with root package name */
    private final O f17634b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public V1(p1 p1Var, O o5) {
        super(p1Var.getRoot());
        t.e(p1Var, "binding");
        this.f17633a = p1Var;
        this.f17634b = o5;
        TextView textView = p1Var.f23447e;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        p1Var.f23448f.setTypeface(aVar.x());
    }

    /* access modifiers changed from: private */
    public static final void d(V1 v12, View view) {
        v12.f17633a.f23444b.performClick();
    }

    /* access modifiers changed from: private */
    public static final void e(V1 v12, CompoundButton compoundButton, boolean z4) {
        O o5 = v12.f17634b;
        if (o5 != null) {
            o5.a(v12.getBindingAdapterPosition());
        }
    }

    public final void c(Z z4) {
        t.e(z4, "userRemoteDevice");
        if (z4.d() == 1) {
            p1 p1Var = this.f17633a;
            p1Var.f23447e.setText(p1Var.getRoot().getContext().getString(R.string.current_device_tag));
        } else {
            this.f17633a.f23447e.setText(z4.b());
        }
        if (z4.e() == 1) {
            this.f17633a.getRoot().setAlpha(1.0f);
            this.f17633a.f23444b.setVisibility(8);
            this.f17633a.f23448f.setVisibility(0);
            p1 p1Var2 = this.f17633a;
            p1Var2.f23448f.setText(p1Var2.getRoot().getContext().getString(R.string.app_installed));
            p1 p1Var3 = this.f17633a;
            p1Var3.f23448f.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(p1Var3.getRoot().getContext(), R.drawable.vector_installed_check), (Drawable) null, (Drawable) null, (Drawable) null);
            this.f17633a.getRoot().setOnClickListener((View.OnClickListener) null);
            this.f17633a.f23444b.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        } else if (z4.c() == 1) {
            this.f17633a.f23444b.setVisibility(0);
            if (z4.f() == 1) {
                this.f17633a.getRoot().setAlpha(0.3f);
                this.f17633a.f23444b.setClickable(false);
                this.f17633a.f23444b.setChecked(true);
                this.f17633a.f23448f.setVisibility(0);
                p1 p1Var4 = this.f17633a;
                p1Var4.f23448f.setText(p1Var4.getRoot().getContext().getString(R.string.install_pending));
                p1 p1Var5 = this.f17633a;
                p1Var5.f23448f.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(p1Var5.getRoot().getContext(), R.drawable.vector_pending), (Drawable) null, (Drawable) null, (Drawable) null);
                this.f17633a.getRoot().setOnClickListener((View.OnClickListener) null);
                this.f17633a.f23444b.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
                return;
            }
            this.f17633a.getRoot().setAlpha(1.0f);
            this.f17633a.f23444b.setClickable(true);
            this.f17633a.f23444b.setChecked(false);
            this.f17633a.f23448f.setVisibility(8);
            this.f17633a.f23448f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, (Drawable) null, (Drawable) null);
            this.f17633a.getRoot().setOnClickListener(new T1(this));
            this.f17633a.f23444b.setOnCheckedChangeListener(new U1(this));
        } else {
            this.f17633a.getRoot().setAlpha(0.3f);
            this.f17633a.f23444b.setVisibility(8);
            this.f17633a.f23448f.setVisibility(0);
            p1 p1Var6 = this.f17633a;
            p1Var6.f23448f.setText(p1Var6.getRoot().getContext().getString(R.string.device_not_compatible));
            p1 p1Var7 = this.f17633a;
            p1Var7.f23448f.setCompoundDrawablesWithIntrinsicBounds(ContextCompat.getDrawable(p1Var7.getRoot().getContext(), R.drawable.vector_incompatible), (Drawable) null, (Drawable) null, (Drawable) null);
            this.f17633a.getRoot().setOnClickListener((View.OnClickListener) null);
            this.f17633a.f23444b.setOnCheckedChangeListener((CompoundButton.OnCheckedChangeListener) null);
        }
    }
}
