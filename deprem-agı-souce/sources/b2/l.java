package B2;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import kotlin.jvm.internal.t;

public final class l extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private final int f17348a;

    /* renamed from: b  reason: collision with root package name */
    private final int f17349b;

    public l(int i5, int i6) {
        this.f17348a = i5;
        this.f17349b = i6;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        t.e(rect, "outRect");
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        t.e(recyclerView, "parent");
        t.e(state, MRAIDCommunicatorUtil.KEY_STATE);
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
        int i5 = this.f17348a;
        rect.left = i5;
        rect.right = i5;
        if (childLayoutPosition == 0) {
            int i6 = this.f17349b;
            rect.top = i6 / 2;
            rect.bottom = i6;
        } else if (childLayoutPosition > 0) {
            rect.top = 0;
            rect.bottom = i5;
        }
    }
}
