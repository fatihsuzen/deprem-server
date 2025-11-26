package u2;

import S1.k;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.leanback.widget.Presenter;
import com.uptodown.R;
import kotlin.jvm.internal.t;
import l2.C2660i;

public final class f extends Presenter {
    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        t.e(viewHolder, "viewHolder");
        t.e(obj, "item");
        TextView textView = (TextView) viewHolder.view.findViewById(R.id.tv_name);
        textView.setTypeface(k.f32g.w());
        textView.setText(((C2660i) obj).e());
    }

    public Presenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        t.e(viewGroup, "parent");
        return new Presenter.ViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.tv_category_tag, viewGroup, false));
    }

    public void onUnbindViewHolder(Presenter.ViewHolder viewHolder) {
        t.e(viewHolder, "viewHolder");
    }
}
