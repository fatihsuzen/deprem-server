package b2;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import kotlin.jvm.internal.t;

/* renamed from: b2.w  reason: case insensitive filesystem */
public final class C2303w extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private final int f20787a;

    public C2303w(int i5) {
        this.f20787a = i5;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        t.e(rect, "outRect");
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        t.e(recyclerView, "parent");
        t.e(state, MRAIDCommunicatorUtil.KEY_STATE);
        int i5 = this.f20787a;
        rect.left = i5;
        rect.right = i5;
        rect.bottom = i5;
        rect.top = i5;
        if (recyclerView.getChildLayoutPosition(view) > 0) {
            rect.top = 0;
        }
    }
}
