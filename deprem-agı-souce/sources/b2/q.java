package B2;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import com.uptodown.R;
import kotlin.jvm.internal.t;

public final class q extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private final int f17357a;

    /* renamed from: b  reason: collision with root package name */
    private boolean f17358b;

    public q(int i5) {
        this.f17357a = i5;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        t.e(rect, "outRect");
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        t.e(recyclerView, "parent");
        t.e(state, MRAIDCommunicatorUtil.KEY_STATE);
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        if (!this.f17358b && childAdapterPosition == this.f17357a) {
            rect.top = recyclerView.getContext().getResources().getDimensionPixelSize(R.dimen.margin_m);
            this.f17358b = true;
        }
    }
}
