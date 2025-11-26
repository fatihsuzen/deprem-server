package androidx.leanback.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.annotation.ColorInt;
import androidx.leanback.R;

final class RowContainerView extends LinearLayout {
    private Drawable mForeground;
    private boolean mForegroundBoundsChanged;
    private ViewGroup mHeaderDock;

    public RowContainerView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public void addHeaderView(View view) {
        if (this.mHeaderDock.indexOfChild(view) < 0) {
            this.mHeaderDock.addView(view, 0);
        }
    }

    public void addRowView(View view) {
        addView(view);
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        Drawable drawable = this.mForeground;
        if (drawable != null) {
            if (this.mForegroundBoundsChanged) {
                this.mForegroundBoundsChanged = false;
                drawable.setBounds(0, 0, getWidth(), getHeight());
            }
            this.mForeground.draw(canvas);
        }
    }

    public Drawable getForeground() {
        return this.mForeground;
    }

    public boolean hasOverlappingRendering() {
        return false;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        this.mForegroundBoundsChanged = true;
    }

    public void removeHeaderView(View view) {
        if (this.mHeaderDock.indexOfChild(view) >= 0) {
            this.mHeaderDock.removeView(view);
        }
    }

    public void setForeground(Drawable drawable) {
        boolean z4;
        this.mForeground = drawable;
        if (drawable == null) {
            z4 = true;
        } else {
            z4 = false;
        }
        setWillNotDraw(z4);
        invalidate();
    }

    public void setForegroundColor(@ColorInt int i5) {
        Drawable drawable = this.mForeground;
        if (drawable instanceof ColorDrawable) {
            ((ColorDrawable) drawable.mutate()).setColor(i5);
            invalidate();
            return;
        }
        setForeground(new ColorDrawable(i5));
    }

    public void showHeader(boolean z4) {
        int i5;
        ViewGroup viewGroup = this.mHeaderDock;
        if (z4) {
            i5 = 0;
        } else {
            i5 = 8;
        }
        viewGroup.setVisibility(i5);
    }

    public RowContainerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RowContainerView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.mForegroundBoundsChanged = true;
        setOrientation(1);
        LayoutInflater.from(context).inflate(R.layout.lb_row_container, this);
        this.mHeaderDock = (ViewGroup) findViewById(R.id.lb_row_container_header_dock);
        setLayoutParams(new LinearLayout.LayoutParams(-2, -2));
    }
}
