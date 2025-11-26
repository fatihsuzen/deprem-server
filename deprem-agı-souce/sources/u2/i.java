package u2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import androidx.leanback.widget.HeaderItem;
import androidx.leanback.widget.PageRow;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.RowHeaderPresenter;
import com.uptodown.R;
import kotlin.jvm.internal.t;
import s2.C2744a;

public final class i extends RowHeaderPresenter {
    /* renamed from: a */
    public RowHeaderPresenter.ViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        t.e(viewGroup, "viewGroup");
        Object systemService = viewGroup.getContext().getSystemService("layout_inflater");
        t.c(systemService, "null cannot be cast to non-null type android.view.LayoutInflater");
        return new RowHeaderPresenter.ViewHolder(((LayoutInflater) systemService).inflate(R.layout.tv_icon_header_item, viewGroup, false));
    }

    public void onBindViewHolder(Presenter.ViewHolder viewHolder, Object obj) {
        t.e(viewHolder, "viewHolder");
        t.e(obj, "item");
        HeaderItem headerItem = ((PageRow) obj).getHeaderItem();
        t.c(headerItem, "null cannot be cast to non-null type com.uptodown.tv.model.IconHeaderItem");
        View view = viewHolder.view;
        view.setFocusable(true);
        View findViewById = view.findViewById(R.id.iv_icon_header_item);
        t.d(findViewById, "findViewById(...)");
        ((ImageView) findViewById).setImageDrawable(ContextCompat.getDrawable(view.getContext(), ((C2744a) headerItem).a()));
    }
}
