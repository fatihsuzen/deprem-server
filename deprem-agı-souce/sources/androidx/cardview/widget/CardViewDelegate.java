package androidx.cardview.widget;

import android.graphics.drawable.Drawable;
import android.view.View;

interface CardViewDelegate {
    Drawable getCardBackground();

    View getCardView();

    boolean getPreventCornerOverlap();

    boolean getUseCompatPadding();

    void setCardBackground(Drawable drawable);

    void setMinWidthHeightInternal(int i5, int i6);

    void setShadowPadding(int i5, int i6, int i7, int i8);
}
