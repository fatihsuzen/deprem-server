package v4;

import E1.b;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.t;

public final class j extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    public final View f26075a;

    /* renamed from: b  reason: collision with root package name */
    public final TextView f26076b;

    /* renamed from: c  reason: collision with root package name */
    public final TextView f26077c;

    /* renamed from: d  reason: collision with root package name */
    public final TextView f26078d;

    /* renamed from: e  reason: collision with root package name */
    public final TextView f26079e;

    /* renamed from: f  reason: collision with root package name */
    public final TextView f26080f;

    /* renamed from: g  reason: collision with root package name */
    public final TextView f26081g;

    /* renamed from: h  reason: collision with root package name */
    public final TextView f26082h;

    /* renamed from: i  reason: collision with root package name */
    public final TextView f26083i;

    /* renamed from: j  reason: collision with root package name */
    public final TextView f26084j;

    /* renamed from: k  reason: collision with root package name */
    public final TextView f26085k;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public j(View view) {
        super(view);
        t.e(view, "rootView");
        View findViewById = view.findViewById(b.disclosure_divider);
        t.d(findViewById, "rootView.findViewById(R.id.disclosure_divider)");
        this.f26075a = findViewById;
        View findViewById2 = view.findViewById(b.tv_disclosure_purposes_label);
        t.d(findViewById2, "rootView.findViewById(R.…isclosure_purposes_label)");
        this.f26076b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(b.tv_disclosure_domain_label);
        t.d(findViewById3, "rootView.findViewById(R.…_disclosure_domain_label)");
        this.f26077c = (TextView) findViewById3;
        View findViewById4 = view.findViewById(b.tv_disclosure_max_age_label);
        t.d(findViewById4, "rootView.findViewById(R.…disclosure_max_age_label)");
        this.f26078d = (TextView) findViewById4;
        View findViewById5 = view.findViewById(b.tv_disclosure_type_label);
        t.d(findViewById5, "rootView.findViewById(R.…tv_disclosure_type_label)");
        this.f26079e = (TextView) findViewById5;
        View findViewById6 = view.findViewById(b.tv_disclosure_name_label);
        t.d(findViewById6, "rootView.findViewById(R.…tv_disclosure_name_label)");
        this.f26080f = (TextView) findViewById6;
        View findViewById7 = view.findViewById(b.tv_disclosure_purposes);
        t.d(findViewById7, "rootView.findViewById(R.id.tv_disclosure_purposes)");
        this.f26081g = (TextView) findViewById7;
        View findViewById8 = view.findViewById(b.tv_disclosure_domain);
        t.d(findViewById8, "rootView.findViewById(R.id.tv_disclosure_domain)");
        this.f26082h = (TextView) findViewById8;
        View findViewById9 = view.findViewById(b.tv_disclosure_max_age);
        t.d(findViewById9, "rootView.findViewById(R.id.tv_disclosure_max_age)");
        this.f26083i = (TextView) findViewById9;
        View findViewById10 = view.findViewById(b.tv_disclosure_type);
        t.d(findViewById10, "rootView.findViewById(R.id.tv_disclosure_type)");
        this.f26084j = (TextView) findViewById10;
        View findViewById11 = view.findViewById(b.tv_disclosure_name);
        t.d(findViewById11, "rootView.findViewById(R.id.tv_disclosure_name)");
        this.f26085k = (TextView) findViewById11;
    }
}
