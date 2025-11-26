package B2;

import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;

public final class f extends PagerSnapHelper {
    private final boolean a(LinearLayoutManager linearLayoutManager) {
        if (linearLayoutManager.findFirstCompletelyVisibleItemPosition() == 0 || linearLayoutManager.findLastCompletelyVisibleItemPosition() == linearLayoutManager.getItemCount() - 1) {
            return false;
        }
        return true;
    }

    public View findSnapView(RecyclerView.LayoutManager layoutManager) {
        if (!(layoutManager instanceof LinearLayoutManager) || a((LinearLayoutManager) layoutManager)) {
            return super.findSnapView(layoutManager);
        }
        return null;
    }
}
