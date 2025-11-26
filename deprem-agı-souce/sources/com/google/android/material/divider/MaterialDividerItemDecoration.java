package com.google.android.material.divider;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.ShapeDrawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.Px;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.R;
import com.google.android.material.internal.ThemeEnforcement;
import com.google.android.material.internal.ViewUtils;
import com.google.android.material.resources.MaterialResources;

public class MaterialDividerItemDecoration extends RecyclerView.ItemDecoration {
    private static final int DEF_STYLE_RES = R.style.Widget_MaterialComponents_MaterialDivider;
    public static final int HORIZONTAL = 0;
    public static final int VERTICAL = 1;
    @ColorInt
    private int color;
    @NonNull
    private Drawable dividerDrawable;
    private int insetEnd;
    private int insetStart;
    private boolean lastItemDecorated;
    private int orientation;
    private final Rect tempRect;
    private int thickness;

    public MaterialDividerItemDecoration(@NonNull Context context, int i5) {
        this(context, (AttributeSet) null, i5);
    }

    private void drawForHorizontalOrientation(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        int i5;
        int i6;
        int i7;
        int i8;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i6 = recyclerView.getPaddingTop();
            i5 = recyclerView.getHeight() - recyclerView.getPaddingBottom();
            canvas.clipRect(recyclerView.getPaddingLeft(), i6, recyclerView.getWidth() - recyclerView.getPaddingRight(), i5);
        } else {
            i5 = recyclerView.getHeight();
            i6 = 0;
        }
        int i9 = i6 + this.insetStart;
        int i10 = i5 - this.insetEnd;
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(recyclerView);
        int childCount = recyclerView.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = recyclerView.getChildAt(i11);
            if (shouldDrawDivider(recyclerView, childAt)) {
                recyclerView.getLayoutManager().getDecoratedBoundsWithMargins(childAt, this.tempRect);
                int round = Math.round(childAt.getTranslationX());
                if (isLayoutRtl) {
                    i7 = this.tempRect.left + round;
                    i8 = this.thickness + i7;
                } else {
                    i8 = round + this.tempRect.right;
                    i7 = i8 - this.thickness;
                }
                this.dividerDrawable.setBounds(i7, i9, i8, i10);
                this.dividerDrawable.setAlpha(Math.round(childAt.getAlpha() * 255.0f));
                this.dividerDrawable.draw(canvas);
            }
        }
        canvas.restore();
    }

    private void drawForVerticalOrientation(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView) {
        int i5;
        int i6;
        int i7;
        int i8;
        canvas.save();
        if (recyclerView.getClipToPadding()) {
            i6 = recyclerView.getPaddingLeft();
            i5 = recyclerView.getWidth() - recyclerView.getPaddingRight();
            canvas.clipRect(i6, recyclerView.getPaddingTop(), i5, recyclerView.getHeight() - recyclerView.getPaddingBottom());
        } else {
            i5 = recyclerView.getWidth();
            i6 = 0;
        }
        boolean isLayoutRtl = ViewUtils.isLayoutRtl(recyclerView);
        if (isLayoutRtl) {
            i7 = this.insetEnd;
        } else {
            i7 = this.insetStart;
        }
        int i9 = i6 + i7;
        if (isLayoutRtl) {
            i8 = this.insetStart;
        } else {
            i8 = this.insetEnd;
        }
        int i10 = i5 - i8;
        int childCount = recyclerView.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = recyclerView.getChildAt(i11);
            if (shouldDrawDivider(recyclerView, childAt)) {
                recyclerView.getLayoutManager().getDecoratedBoundsWithMargins(childAt, this.tempRect);
                int round = this.tempRect.bottom + Math.round(childAt.getTranslationY());
                this.dividerDrawable.setBounds(i9, round - this.thickness, i10, round);
                this.dividerDrawable.setAlpha(Math.round(childAt.getAlpha() * 255.0f));
                this.dividerDrawable.draw(canvas);
            }
        }
        canvas.restore();
    }

    @ColorInt
    public int getDividerColor() {
        return this.color;
    }

    @Px
    public int getDividerInsetEnd() {
        return this.insetEnd;
    }

    @Px
    public int getDividerInsetStart() {
        return this.insetStart;
    }

    @Px
    public int getDividerThickness() {
        return this.thickness;
    }

    public void getItemOffsets(@NonNull Rect rect, @NonNull View view, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        rect.set(0, 0, 0, 0);
        if (!shouldDrawDivider(recyclerView, view)) {
            return;
        }
        if (this.orientation == 1) {
            rect.bottom = this.thickness;
        } else if (ViewUtils.isLayoutRtl(recyclerView)) {
            rect.left = this.thickness;
        } else {
            rect.right = this.thickness;
        }
    }

    public int getOrientation() {
        return this.orientation;
    }

    public boolean isLastItemDecorated() {
        return this.lastItemDecorated;
    }

    public void onDraw(@NonNull Canvas canvas, @NonNull RecyclerView recyclerView, @NonNull RecyclerView.State state) {
        if (recyclerView.getLayoutManager() != null) {
            if (this.orientation == 1) {
                drawForVerticalOrientation(canvas, recyclerView);
            } else {
                drawForHorizontalOrientation(canvas, recyclerView);
            }
        }
    }

    public void setDividerColor(@ColorInt int i5) {
        this.color = i5;
        Drawable wrap = DrawableCompat.wrap(this.dividerDrawable);
        this.dividerDrawable = wrap;
        wrap.setTint(i5);
    }

    public void setDividerColorResource(@NonNull Context context, @ColorRes int i5) {
        setDividerColor(ContextCompat.getColor(context, i5));
    }

    public void setDividerInsetEnd(@Px int i5) {
        this.insetEnd = i5;
    }

    public void setDividerInsetEndResource(@NonNull Context context, @DimenRes int i5) {
        setDividerInsetEnd(context.getResources().getDimensionPixelOffset(i5));
    }

    public void setDividerInsetStart(@Px int i5) {
        this.insetStart = i5;
    }

    public void setDividerInsetStartResource(@NonNull Context context, @DimenRes int i5) {
        setDividerInsetStart(context.getResources().getDimensionPixelOffset(i5));
    }

    public void setDividerThickness(@Px int i5) {
        this.thickness = i5;
    }

    public void setDividerThicknessResource(@NonNull Context context, @DimenRes int i5) {
        setDividerThickness(context.getResources().getDimensionPixelSize(i5));
    }

    public void setLastItemDecorated(boolean z4) {
        this.lastItemDecorated = z4;
    }

    public void setOrientation(int i5) {
        if (i5 == 0 || i5 == 1) {
            this.orientation = i5;
            return;
        }
        throw new IllegalArgumentException("Invalid orientation: " + i5 + ". It should be either HORIZONTAL or VERTICAL");
    }

    /* access modifiers changed from: protected */
    public boolean shouldDrawDivider(int i5, @Nullable RecyclerView.Adapter<?> adapter) {
        return true;
    }

    public MaterialDividerItemDecoration(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5) {
        this(context, attributeSet, R.attr.materialDividerStyle, i5);
    }

    private boolean shouldDrawDivider(@NonNull RecyclerView recyclerView, @NonNull View view) {
        int childAdapterPosition = recyclerView.getChildAdapterPosition(view);
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        return childAdapterPosition != -1 && (!(adapter != null && childAdapterPosition == adapter.getItemCount() - 1) || this.lastItemDecorated) && shouldDrawDivider(childAdapterPosition, (RecyclerView.Adapter<?>) adapter);
    }

    public MaterialDividerItemDecoration(@NonNull Context context, @Nullable AttributeSet attributeSet, int i5, int i6) {
        this.tempRect = new Rect();
        Context context2 = context;
        TypedArray obtainStyledAttributes = ThemeEnforcement.obtainStyledAttributes(context2, attributeSet, R.styleable.MaterialDivider, i5, DEF_STYLE_RES, new int[0]);
        this.color = MaterialResources.getColorStateList(context2, obtainStyledAttributes, R.styleable.MaterialDivider_dividerColor).getDefaultColor();
        this.thickness = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MaterialDivider_dividerThickness, context2.getResources().getDimensionPixelSize(R.dimen.material_divider_thickness));
        this.insetStart = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialDivider_dividerInsetStart, 0);
        this.insetEnd = obtainStyledAttributes.getDimensionPixelOffset(R.styleable.MaterialDivider_dividerInsetEnd, 0);
        this.lastItemDecorated = obtainStyledAttributes.getBoolean(R.styleable.MaterialDivider_lastItemDecorated, true);
        obtainStyledAttributes.recycle();
        this.dividerDrawable = new ShapeDrawable();
        setDividerColor(this.color);
        setOrientation(i6);
    }
}
