package C2;

import S1.k;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import kotlin.jvm.internal.t;

public final class K extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private TextView f17524a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f17525b;

    /* renamed from: c  reason: collision with root package name */
    private ImageView f17526c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f17527d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public K(View view) {
        super(view);
        t.e(view, "itemView");
        View findViewById = view.findViewById(R.id.tv_name_app_fn);
        t.d(findViewById, "findViewById(...)");
        this.f17524a = (TextView) findViewById;
        View findViewById2 = view.findViewById(R.id.tv_desc_app_fn);
        t.d(findViewById2, "findViewById(...)");
        this.f17525b = (TextView) findViewById2;
        View findViewById3 = view.findViewById(R.id.iv_logo_app_fn);
        t.d(findViewById3, "findViewById(...)");
        this.f17526c = (ImageView) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_install_fn);
        t.d(findViewById4, "findViewById(...)");
        this.f17527d = (TextView) findViewById4;
        TextView textView = this.f17524a;
        k.a aVar = k.f32g;
        textView.setTypeface(aVar.w());
        this.f17525b.setTypeface(aVar.x());
        this.f17527d.setTypeface(aVar.w());
    }

    public final ImageView a() {
        return this.f17526c;
    }

    public final TextView b() {
        return this.f17525b;
    }

    public final TextView c() {
        return this.f17527d;
    }

    public final TextView d() {
        return this.f17524a;
    }
}
