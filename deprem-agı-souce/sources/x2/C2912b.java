package x2;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import kotlin.jvm.internal.t;

/* renamed from: x2.b  reason: case insensitive filesystem */
public final class C2912b extends ImageView {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C2912b(Context context) {
        super(context);
        t.e(context, "context");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        if (getDrawable() != null) {
            int size = View.MeasureSpec.getSize(i6);
            setMeasuredDimension((int) Math.ceil((double) ((((float) size) * ((float) getDrawable().getIntrinsicWidth())) / ((float) getDrawable().getIntrinsicHeight()))), size);
            return;
        }
        super.onMeasure(i5, i6);
    }
}
