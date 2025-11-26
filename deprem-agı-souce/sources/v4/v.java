package v4;

import E1.b;
import I2.i;
import S2.d;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.t;
import m4.r;

public final class v extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public final t f26114a;

    /* renamed from: b  reason: collision with root package name */
    public final Integer f26115b;

    /* renamed from: c  reason: collision with root package name */
    public final Integer f26116c;

    /* renamed from: d  reason: collision with root package name */
    public final Typeface f26117d;

    /* renamed from: e  reason: collision with root package name */
    public final ConstraintLayout f26118e;

    /* renamed from: f  reason: collision with root package name */
    public final ImageView f26119f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f26120g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f26121h;

    /* renamed from: i  reason: collision with root package name */
    public final View f26122i;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public v(View view, t tVar, Integer num, Integer num2, Typeface typeface) {
        super(view);
        t.e(view, "rootView");
        t.e(tVar, "listener");
        this.f26114a = tVar;
        this.f26115b = num;
        this.f26116c = num2;
        this.f26117d = typeface;
        View findViewById = view.findViewById(b.cl_item_container);
        t.d(findViewById, "rootView.findViewById(\n …_item_container\n        )");
        this.f26118e = (ConstraintLayout) findViewById;
        View findViewById2 = view.findViewById(b.iv_stack_more_info);
        t.d(findViewById2, "rootView.findViewById(R.id.iv_stack_more_info)");
        this.f26119f = (ImageView) findViewById2;
        View findViewById3 = view.findViewById(b.tv_stack_selected_state);
        t.d(findViewById3, "rootView.findViewById(\n …_selected_state\n        )");
        this.f26120g = (TextView) findViewById3;
        View findViewById4 = view.findViewById(b.tv_stack_name);
        t.d(findViewById4, "rootView.findViewById(R.id.tv_stack_name)");
        this.f26121h = (TextView) findViewById4;
        View findViewById5 = view.findViewById(b.line_item);
        t.d(findViewById5, "rootView.findViewById(R.id.line_item)");
        this.f26122i = findViewById5;
    }

    public static final void b(v vVar, r rVar, View view) {
        t.e(vVar, "this$0");
        t.e(rVar, "$item");
        i iVar = (i) vVar.f26114a;
        iVar.getClass();
        t.e(rVar, "item");
        FragmentActivity activity = iVar.getActivity();
        if (activity != null) {
            FragmentManager supportFragmentManager = activity.getSupportFragmentManager();
            String str = d.f19024v;
            if (supportFragmentManager.findFragmentByTag(str) == null) {
                int i5 = rVar.f25487a;
                d dVar = new d();
                Bundle bundle = new Bundle();
                bundle.putInt("stack_id", i5);
                dVar.setArguments(bundle);
                activity.getSupportFragmentManager().beginTransaction().add((Fragment) dVar, str).commit();
            }
        }
    }

    public final void a(r rVar) {
        t.e(rVar, "item");
        this.f26121h.setText(rVar.f25488b);
        this.f26120g.setText(rVar.f25489c);
        Integer num = this.f26115b;
        if (num != null) {
            int intValue = num.intValue();
            this.f26121h.setTextColor(intValue);
            this.f26120g.setTextColor(intValue);
            this.f26119f.setColorFilter(intValue);
        }
        Integer num2 = this.f26116c;
        if (num2 != null) {
            this.f26122i.setBackgroundColor(num2.intValue());
        }
        Typeface typeface = this.f26117d;
        if (typeface != null) {
            this.f26121h.setTypeface(typeface);
            this.f26120g.setTypeface(typeface);
        }
        this.f26118e.setOnClickListener(new u(this, rVar));
    }
}
