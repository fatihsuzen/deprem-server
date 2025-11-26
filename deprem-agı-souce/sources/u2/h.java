package u2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;
import kotlin.jvm.internal.t;
import y2.C2924e;

public final class h extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    private Context f25977a;

    public h(Context context) {
        t.e(context, "context");
        this.f25977a = context;
    }

    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        t.e(viewHolder, "viewHolder");
        t.e(obj, "item");
        if (viewHolder instanceof C2924e) {
            ((C2924e) viewHolder).b(obj);
        }
    }

    public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        t.e(viewGroup, "parent");
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tv_home_card_item, viewGroup, false);
        t.b(inflate);
        return new C2924e(inflate, this.f25977a);
    }

    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        t.e(viewHolder, "viewHolder");
        if (viewHolder instanceof C2924e) {
            ((C2924e) viewHolder).h();
        }
    }
}
