package u2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;
import kotlin.jvm.internal.t;
import l2.C2668q;
import y2.C2926g;

public final class m extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    private int f25987a = -1;

    /* renamed from: b  reason: collision with root package name */
    private int f25988b = -1;

    private final void a(View view, boolean z4) {
        int i5;
        if (z4) {
            i5 = this.f25987a;
        } else {
            i5 = this.f25988b;
        }
        view.setBackgroundColor(i5);
    }

    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        t.e(viewHolder, "viewHolder");
        t.e(obj, "item");
        if (obj instanceof C2668q) {
            ((C2926g) viewHolder).a((C2668q) obj, viewHolder.view.getContext());
        }
    }

    public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        t.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tv_download_item, viewGroup, false);
        this.f25988b = ContextCompat.getColor(viewGroup.getContext(), R.color.background_color);
        this.f25987a = ContextCompat.getColor(viewGroup.getContext(), R.color.blue_primary_pressed);
        inflate.setFocusable(true);
        inflate.setFocusableInTouchMode(true);
        t.b(inflate);
        a(inflate, false);
        return new C2926g(inflate);
    }

    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        t.e(viewHolder, "viewHolder");
    }
}
