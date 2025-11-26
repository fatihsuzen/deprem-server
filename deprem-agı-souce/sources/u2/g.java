package u2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;
import kotlin.jvm.internal.t;
import y2.C2923d;

public final class g extends Presenter {

    /* renamed from: a  reason: collision with root package name */
    private Context f25976a;

    public g(Context context) {
        t.e(context, "context");
        this.f25976a = context;
    }

    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        t.e(viewHolder, "viewHolder");
        t.e(obj, "item");
        if (viewHolder instanceof C2923d) {
            ((C2923d) viewHolder).b(obj);
        }
    }

    public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        t.e(viewGroup, "parent");
        if (viewGroup.getContext() == null) {
            return null;
        }
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tv_home_card_featured_item, viewGroup, false);
        t.b(inflate);
        return new C2923d(inflate, this.f25976a);
    }

    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        t.e(viewHolder, "viewHolder");
        if (viewHolder instanceof C2923d) {
            ((C2923d) viewHolder).h();
        }
    }
}
