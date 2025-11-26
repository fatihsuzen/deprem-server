package C2;

import S1.k;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import kotlin.jvm.internal.t;

/* renamed from: C2.e0  reason: case insensitive filesystem */
public final class C2012e0 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f17735a;

    /* renamed from: b  reason: collision with root package name */
    private final RelativeLayout f17736b;

    /* renamed from: c  reason: collision with root package name */
    private final RelativeLayout f17737c;

    /* renamed from: d  reason: collision with root package name */
    private final TextView f17738d;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2012e0(View view) {
        super(view);
        t.e(view, "itemView");
        View findViewById = view.findViewById(R.id.rl_old_versions_footer);
        t.d(findViewById, "findViewById(...)");
        this.f17735a = (RelativeLayout) findViewById;
        View findViewById2 = view.findViewById(R.id.rl_back_versions);
        t.d(findViewById2, "findViewById(...)");
        this.f17736b = (RelativeLayout) findViewById2;
        View findViewById3 = view.findViewById(R.id.rl_forward_versions);
        t.d(findViewById3, "findViewById(...)");
        this.f17737c = (RelativeLayout) findViewById3;
        View findViewById4 = view.findViewById(R.id.tv_current_page_versions);
        t.d(findViewById4, "findViewById(...)");
        TextView textView = (TextView) findViewById4;
        this.f17738d = textView;
        textView.setTypeface(k.f32g.w());
    }

    public final RelativeLayout a() {
        return this.f17736b;
    }

    public final RelativeLayout b() {
        return this.f17737c;
    }

    public final RelativeLayout c() {
        return this.f17735a;
    }

    public final TextView d() {
        return this.f17738d;
    }
}
