package com.mbridge.msdk.videocommon.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ak;
import com.mbridge.msdk.widget.MBImageView;

public class RoundImageView extends MBImageView {

    /* renamed from: a  reason: collision with root package name */
    private int f13194a;

    /* renamed from: b  reason: collision with root package name */
    private int f13195b;

    /* renamed from: c  reason: collision with root package name */
    private Paint f13196c;

    /* renamed from: d  reason: collision with root package name */
    private int f13197d;

    /* renamed from: e  reason: collision with root package name */
    private Matrix f13198e = new Matrix();

    /* renamed from: f  reason: collision with root package name */
    private BitmapShader f13199f;

    /* renamed from: g  reason: collision with root package name */
    private int f13200g;

    /* renamed from: h  reason: collision with root package name */
    private RectF f13201h;

    public RoundImageView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        Paint paint = new Paint();
        this.f13196c = paint;
        paint.setAntiAlias(true);
        this.f13195b = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.f13194a = 1;
    }

    private Bitmap a(Drawable drawable) {
        try {
            if (drawable instanceof BitmapDrawable) {
                return ((BitmapDrawable) drawable).getBitmap();
            }
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            Bitmap createBitmap = Bitmap.createBitmap(intrinsicWidth, intrinsicHeight, Bitmap.Config.ARGB_4444);
            Canvas canvas = new Canvas(createBitmap);
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            drawable.draw(canvas);
            return createBitmap;
        } catch (Throwable th) {
            af.b("View", th.getMessage());
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        try {
            if (getDrawable() != null) {
                Drawable drawable = getDrawable();
                if (drawable != null) {
                    Bitmap a5 = a(drawable);
                    if (a5 != null && !a5.isRecycled()) {
                        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                        this.f13199f = new BitmapShader(a5, tileMode, tileMode);
                        int i5 = this.f13194a;
                        float f5 = 1.0f;
                        if (i5 == 0) {
                            f5 = (((float) this.f13200g) * 1.0f) / ((float) Math.min(a5.getWidth(), a5.getHeight()));
                        } else if (i5 == 1) {
                            f5 = Math.max((((float) getWidth()) * 1.0f) / ((float) a5.getWidth()), (((float) getHeight()) * 1.0f) / ((float) a5.getHeight()));
                        }
                        this.f13198e.setScale(f5, f5);
                        this.f13199f.setLocalMatrix(this.f13198e);
                        this.f13196c.setShader(this.f13199f);
                    }
                }
                if (this.f13194a == 1) {
                    RectF rectF = this.f13201h;
                    int i6 = this.f13195b;
                    canvas.drawRoundRect(rectF, (float) i6, (float) i6, this.f13196c);
                    return;
                }
                int i7 = this.f13197d;
                canvas.drawCircle((float) i7, (float) i7, (float) i7, this.f13196c);
            }
        } catch (Throwable th) {
            af.b("RoundImageView", th.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
        if (this.f13194a == 0) {
            int min = Math.min(getMeasuredWidth(), getMeasuredHeight());
            this.f13200g = min;
            this.f13197d = min / 2;
            setMeasuredDimension(min, min);
        }
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            super.onRestoreInstanceState(bundle.getParcelable("state_instance"));
            this.f13194a = bundle.getInt("state_type");
            this.f13195b = bundle.getInt("state_border_radius");
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("state_instance", super.onSaveInstanceState());
        bundle.putInt("state_type", this.f13194a);
        bundle.putInt("state_border_radius", this.f13195b);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        if (this.f13194a == 1) {
            this.f13201h = new RectF(0.0f, 0.0f, (float) getWidth(), (float) getHeight());
        }
    }

    public void setBorderRadius(int i5) {
        int a5 = ak.a(getContext(), (float) i5);
        if (this.f13195b != a5) {
            this.f13195b = a5;
            invalidate();
        }
    }

    public void setType(int i5) {
        if (this.f13194a != i5) {
            this.f13194a = i5;
            if (!(i5 == 1 || i5 == 0)) {
                this.f13194a = 0;
            }
            requestLayout();
        }
    }

    public RoundImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Paint paint = new Paint();
        this.f13196c = paint;
        paint.setAntiAlias(true);
        this.f13195b = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.f13194a = 1;
    }

    public RoundImageView(Context context) {
        super(context);
        Paint paint = new Paint();
        this.f13196c = paint;
        paint.setAntiAlias(true);
        this.f13195b = (int) TypedValue.applyDimension(1, 5.0f, getResources().getDisplayMetrics());
        this.f13194a = 1;
    }
}
