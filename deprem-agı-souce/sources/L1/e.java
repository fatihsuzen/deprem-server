package L1;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import kotlin.jvm.internal.t;

public abstract class e extends FrameLayout {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public e(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        t.e(context, "context");
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        if (getLayoutParams().height == -2) {
            super.onMeasure(i5, View.MeasureSpec.makeMeasureSpec((View.MeasureSpec.getSize(i5) * 9) / 16, 1073741824));
        } else {
            super.onMeasure(i5, i6);
        }
    }
}
