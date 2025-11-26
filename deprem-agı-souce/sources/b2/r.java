package B2;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import com.uptodown.R;
import kotlin.jvm.internal.t;

public final class r extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private final int f17359a;

    public r(Context context) {
        t.e(context, "context");
        this.f17359a = context.getResources().getDimensionPixelSize(R.dimen.margin_m);
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        t.e(rect, "outRect");
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        t.e(recyclerView, "parent");
        t.e(state, MRAIDCommunicatorUtil.KEY_STATE);
        if (recyclerView.getChildAdapterPosition(view) == 0) {
            int i5 = this.f17359a;
            rect.left = i5;
            rect.right = i5;
            return;
        }
        rect.right = this.f17359a;
    }
}
