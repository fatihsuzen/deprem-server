package w2;

import androidx.leanback.widget.OnItemViewClickedListener;
import androidx.leanback.widget.Presenter;
import androidx.leanback.widget.Row;
import androidx.leanback.widget.RowPresenter;
import com.uptodown.tv.ui.fragment.TvSearchFragment;

/* renamed from: w2.T  reason: case insensitive filesystem */
public final /* synthetic */ class C2824T implements OnItemViewClickedListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ TvSearchFragment f26150a;

    public /* synthetic */ C2824T(TvSearchFragment tvSearchFragment) {
        this.f26150a = tvSearchFragment;
    }

    public final void onItemClicked(Presenter.ViewHolder viewHolder, Object obj, RowPresenter.ViewHolder viewHolder2, Object obj2) {
        TvSearchFragment.h(this.f26150a, viewHolder, obj, viewHolder2, (Row) obj2);
    }
}
