package com.google.android.material.circularreveal;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.internal.view.SupportMenu;
import androidx.core.view.ViewCompat;
import com.google.android.material.circularreveal.CircularRevealWidget;
import com.google.android.material.math.MathUtils;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class CircularRevealHelper {
    public static final int BITMAP_SHADER = 0;
    public static final int CLIP_PATH = 1;
    private static final boolean DEBUG = false;
    public static final int REVEAL_ANIMATOR = 2;
    public static final int STRATEGY = 2;
    private boolean buildingCircularRevealCache;
    private Paint debugPaint;
    private final Delegate delegate;
    private boolean hasCircularRevealCache;
    @Nullable
    private Drawable overlayDrawable;
    @Nullable
    private CircularRevealWidget.RevealInfo revealInfo;
    @NonNull
    private final Paint revealPaint = new Paint(7);
    @NonNull
    private final Path revealPath = new Path();
    @NonNull
    private final Paint scrimPaint;
    @NonNull
    private final View view;

    public interface Delegate {
        void actualDraw(Canvas canvas);

        boolean actualIsOpaque();
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Strategy {
    }

    public CircularRevealHelper(Delegate delegate2) {
        this.delegate = delegate2;
        View view2 = (View) delegate2;
        this.view = view2;
        view2.setWillNotDraw(false);
        Paint paint = new Paint(1);
        this.scrimPaint = paint;
        paint.setColor(0);
    }

    private void drawDebugCircle(@NonNull Canvas canvas, int i5, float f5) {
        this.debugPaint.setColor(i5);
        this.debugPaint.setStrokeWidth(f5);
        CircularRevealWidget.RevealInfo revealInfo2 = this.revealInfo;
        canvas.drawCircle(revealInfo2.centerX, revealInfo2.centerY, revealInfo2.radius - (f5 / 2.0f), this.debugPaint);
    }

    private void drawDebugMode(@NonNull Canvas canvas) {
        this.delegate.actualDraw(canvas);
        if (shouldDrawScrim()) {
            CircularRevealWidget.RevealInfo revealInfo2 = this.revealInfo;
            canvas.drawCircle(revealInfo2.centerX, revealInfo2.centerY, revealInfo2.radius, this.scrimPaint);
        }
        if (shouldDrawCircularReveal()) {
            drawDebugCircle(canvas, ViewCompat.MEASURED_STATE_MASK, 10.0f);
            drawDebugCircle(canvas, SupportMenu.CATEGORY_MASK, 5.0f);
        }
        drawOverlayDrawable(canvas);
    }

    private void drawOverlayDrawable(@NonNull Canvas canvas) {
        if (shouldDrawOverlayDrawable()) {
            Rect bounds = this.overlayDrawable.getBounds();
            float width = this.revealInfo.centerX - (((float) bounds.width()) / 2.0f);
            float height = this.revealInfo.centerY - (((float) bounds.height()) / 2.0f);
            canvas.translate(width, height);
            this.overlayDrawable.draw(canvas);
            canvas.translate(-width, -height);
        }
    }

    private float getDistanceToFurthestCorner(@NonNull CircularRevealWidget.RevealInfo revealInfo2) {
        return MathUtils.distanceToFurthestCorner(revealInfo2.centerX, revealInfo2.centerY, 0.0f, 0.0f, (float) this.view.getWidth(), (float) this.view.getHeight());
    }

    private void invalidateRevealInfo() {
        this.view.invalidate();
    }

    private boolean shouldDrawCircularReveal() {
        boolean z4;
        CircularRevealWidget.RevealInfo revealInfo2 = this.revealInfo;
        if (revealInfo2 == null || revealInfo2.isInvalid()) {
            z4 = true;
        } else {
            z4 = false;
        }
        return !z4;
    }

    private boolean shouldDrawOverlayDrawable() {
        if (this.buildingCircularRevealCache || this.overlayDrawable == null || this.revealInfo == null) {
            return false;
        }
        return true;
    }

    private boolean shouldDrawScrim() {
        if (this.buildingCircularRevealCache || Color.alpha(this.scrimPaint.getColor()) == 0) {
            return false;
        }
        return true;
    }

    public void buildCircularRevealCache() {
    }

    public void destroyCircularRevealCache() {
    }

    public void draw(@NonNull Canvas canvas) {
        Canvas canvas2;
        if (shouldDrawCircularReveal()) {
            this.delegate.actualDraw(canvas);
            if (shouldDrawScrim()) {
                canvas2 = canvas;
                canvas2.drawRect(0.0f, 0.0f, (float) this.view.getWidth(), (float) this.view.getHeight(), this.scrimPaint);
            } else {
                canvas2 = canvas;
            }
        } else {
            canvas2 = canvas;
            this.delegate.actualDraw(canvas2);
            if (shouldDrawScrim()) {
                canvas2.drawRect(0.0f, 0.0f, (float) this.view.getWidth(), (float) this.view.getHeight(), this.scrimPaint);
            }
        }
        drawOverlayDrawable(canvas2);
    }

    @Nullable
    public Drawable getCircularRevealOverlayDrawable() {
        return this.overlayDrawable;
    }

    @ColorInt
    public int getCircularRevealScrimColor() {
        return this.scrimPaint.getColor();
    }

    @Nullable
    public CircularRevealWidget.RevealInfo getRevealInfo() {
        CircularRevealWidget.RevealInfo revealInfo2 = this.revealInfo;
        if (revealInfo2 == null) {
            return null;
        }
        CircularRevealWidget.RevealInfo revealInfo3 = new CircularRevealWidget.RevealInfo(revealInfo2);
        if (revealInfo3.isInvalid()) {
            revealInfo3.radius = getDistanceToFurthestCorner(revealInfo3);
        }
        return revealInfo3;
    }

    public boolean isOpaque() {
        if (!this.delegate.actualIsOpaque() || shouldDrawCircularReveal()) {
            return false;
        }
        return true;
    }

    public void setCircularRevealOverlayDrawable(@Nullable Drawable drawable) {
        this.overlayDrawable = drawable;
        this.view.invalidate();
    }

    public void setCircularRevealScrimColor(@ColorInt int i5) {
        this.scrimPaint.setColor(i5);
        this.view.invalidate();
    }

    public void setRevealInfo(@Nullable CircularRevealWidget.RevealInfo revealInfo2) {
        if (revealInfo2 == null) {
            this.revealInfo = null;
        } else {
            CircularRevealWidget.RevealInfo revealInfo3 = this.revealInfo;
            if (revealInfo3 == null) {
                this.revealInfo = new CircularRevealWidget.RevealInfo(revealInfo2);
            } else {
                revealInfo3.set(revealInfo2);
            }
            if (MathUtils.geq(revealInfo2.radius, getDistanceToFurthestCorner(revealInfo2), 1.0E-4f)) {
                this.revealInfo.radius = Float.MAX_VALUE;
            }
        }
        invalidateRevealInfo();
    }
}
