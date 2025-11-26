package androidx.leanback.preference.internal;

import android.content.Context;
import android.graphics.Outline;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP_PREFIX})
public class OutlineOnlyWithChildrenFrameLayout extends FrameLayout {
    ViewOutlineProvider mInnerOutlineProvider;
    private ViewOutlineProvider mMagicalOutlineProvider;

    public OutlineOnlyWithChildrenFrameLayout(Context context) {
        super(context);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        super.onLayout(z4, i5, i6, i7, i8);
        invalidateOutline();
    }

    public void setOutlineProvider(ViewOutlineProvider viewOutlineProvider) {
        this.mInnerOutlineProvider = viewOutlineProvider;
        if (this.mMagicalOutlineProvider == null) {
            this.mMagicalOutlineProvider = new ViewOutlineProvider() {
                public void getOutline(View view, Outline outline) {
                    if (OutlineOnlyWithChildrenFrameLayout.this.getChildCount() > 0) {
                        OutlineOnlyWithChildrenFrameLayout.this.mInnerOutlineProvider.getOutline(view, outline);
                    } else {
                        ViewOutlineProvider.BACKGROUND.getOutline(view, outline);
                    }
                }
            };
        }
        super.setOutlineProvider(this.mMagicalOutlineProvider);
    }

    public OutlineOnlyWithChildrenFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public OutlineOnlyWithChildrenFrameLayout(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
    }

    public OutlineOnlyWithChildrenFrameLayout(Context context, AttributeSet attributeSet, int i5, int i6) {
        super(context, attributeSet, i5, i6);
    }
}
