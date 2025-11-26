package B2;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import com.uptodown.activities.preferences.a;
import kotlin.jvm.internal.t;

public final class p extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private final int f17356a;

    public p(int i5) {
        this.f17356a = i5;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        t.e(rect, "outRect");
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        t.e(recyclerView, "parent");
        t.e(state, MRAIDCommunicatorUtil.KEY_STATE);
        a.C0147a aVar = a.f15150a;
        Context context = view.getContext();
        t.d(context, "getContext(...)");
        if (t.a(aVar.n(context), "ar")) {
            rect.right = this.f17356a;
            rect.left = 0;
            if (recyclerView.getChildLayoutPosition(view) == state.getItemCount() - 1) {
                rect.left = this.f17356a;
                return;
            }
            return;
        }
        rect.left = this.f17356a;
        rect.right = 0;
        if (recyclerView.getChildLayoutPosition(view) == state.getItemCount() - 1) {
            rect.right = this.f17356a;
        }
    }
}
