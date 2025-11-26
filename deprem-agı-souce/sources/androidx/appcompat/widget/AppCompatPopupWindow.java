package androidx.appcompat.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.PopupWindow;
import androidx.annotation.AttrRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StyleRes;
import androidx.appcompat.R;
import androidx.core.widget.PopupWindowCompat;

class AppCompatPopupWindow extends PopupWindow {
    private static final boolean COMPAT_OVERLAP_ANCHOR = false;
    private boolean mOverlapAnchor;

    public AppCompatPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i5) {
        super(context, attributeSet, i5);
        init(context, attributeSet, i5, 0);
    }

    private void init(Context context, AttributeSet attributeSet, int i5, int i6) {
        TintTypedArray obtainStyledAttributes = TintTypedArray.obtainStyledAttributes(context, attributeSet, R.styleable.PopupWindow, i5, i6);
        int i7 = R.styleable.PopupWindow_overlapAnchor;
        if (obtainStyledAttributes.hasValue(i7)) {
            setSupportOverlapAnchor(obtainStyledAttributes.getBoolean(i7, false));
        }
        setBackgroundDrawable(obtainStyledAttributes.getDrawable(R.styleable.PopupWindow_android_popupBackground));
        obtainStyledAttributes.recycle();
    }

    private void setSupportOverlapAnchor(boolean z4) {
        if (COMPAT_OVERLAP_ANCHOR) {
            this.mOverlapAnchor = z4;
        } else {
            PopupWindowCompat.setOverlapAnchor(this, z4);
        }
    }

    public void showAsDropDown(View view, int i5, int i6) {
        if (COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            i6 -= view.getHeight();
        }
        super.showAsDropDown(view, i5, i6);
    }

    public void update(View view, int i5, int i6, int i7, int i8) {
        if (COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            i6 -= view.getHeight();
        }
        super.update(view, i5, i6, i7, i8);
    }

    public AppCompatPopupWindow(@NonNull Context context, @Nullable AttributeSet attributeSet, @AttrRes int i5, @StyleRes int i6) {
        super(context, attributeSet, i5, i6);
        init(context, attributeSet, i5, i6);
    }

    public void showAsDropDown(View view, int i5, int i6, int i7) {
        if (COMPAT_OVERLAP_ANCHOR && this.mOverlapAnchor) {
            i6 -= view.getHeight();
        }
        super.showAsDropDown(view, i5, i6, i7);
    }
}
