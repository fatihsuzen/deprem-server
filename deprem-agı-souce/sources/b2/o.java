package B2;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.newreward.player.view.hybrid.util.MRAIDCommunicatorUtil;
import kotlin.jvm.internal.t;

public final class o extends RecyclerView.ItemDecoration {

    /* renamed from: a  reason: collision with root package name */
    private final int f17352a;

    /* renamed from: b  reason: collision with root package name */
    private final int f17353b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17354c;

    /* renamed from: d  reason: collision with root package name */
    private final int f17355d;

    public o(int i5, int i6, int i7, int i8) {
        this.f17352a = i5;
        this.f17353b = i6;
        this.f17354c = i7;
        this.f17355d = i8;
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        t.e(rect, "outRect");
        t.e(view, MBridgeConstans.DYNAMIC_VIEW_KEY_VIEW);
        t.e(recyclerView, "parent");
        t.e(state, MRAIDCommunicatorUtil.KEY_STATE);
        rect.left = this.f17352a;
        rect.right = this.f17353b;
        rect.bottom = this.f17354c;
        rect.top = this.f17355d;
        if (recyclerView.getChildLayoutPosition(view) > 0) {
            rect.top = 0;
        }
    }
}
