package C2;

import android.view.View;
import android.widget.RelativeLayout;
import androidx.recyclerview.widget.RecyclerView;
import com.uptodown.R;
import kotlin.jvm.internal.t;

public final class Y1 extends RecyclerView.ViewHolder {

    /* renamed from: a  reason: collision with root package name */
    private final RelativeLayout f17677a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Y1(View view) {
        super(view);
        t.e(view, "itemView");
        View findViewById = view.findViewById(R.id.rl_container_warning_not_storage_available);
        t.d(findViewById, "findViewById(...)");
        this.f17677a = (RelativeLayout) findViewById;
    }

    public final void a(boolean z4) {
        if (z4) {
            this.f17677a.setVisibility(0);
        } else {
            this.f17677a.setVisibility(8);
        }
    }
}
