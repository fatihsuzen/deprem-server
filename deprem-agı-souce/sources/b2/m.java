package B2;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import kotlin.jvm.internal.t;

public final class m extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private final int f17350a;

    public m(int i5) {
        this.f17350a = i5;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        t.e(rect, "outRect");
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        t.e(recyclerView, "parent");
        t.e(state, MRAIDCommunicatorUtil.KEY_STATE);
        int childLayoutPosition = recyclerView.getChildLayoutPosition(view);
        int i5 = this.f17350a;
        rect.left = i5;
        rect.right = i5;
        rect.bottom = i5;
        if (childLayoutPosition > 0) {
            rect.top = 0;
        } else {
            rect.top = i5;
        }
    }
}
