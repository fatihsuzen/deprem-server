package com.mbridge.msdk.dycreator.baseview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.mbridge.msdk.foundation.tools.af;

public class MBRoundRectImageViewC extends MBImageView {

    /* renamed from: a  reason: collision with root package name */
    private Paint f8364a = new Paint();

    public MBRoundRectImageViewC(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private Bitmap a(Bitmap bitmap) {
        Bitmap bitmap2;
        if (bitmap == null || bitmap.isRecycled()) {
            return bitmap;
        }
        try {
            int width = getWidth();
            int height = getHeight();
            Matrix matrix = new Matrix();
            matrix.postScale(((float) width) / ((float) bitmap.getWidth()), ((float) height) / ((float) bitmap.getHeight()));
            bitmap2 = bitmap;
            try {
                return Bitmap.createBitmap(bitmap2, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            } catch (Exception e5) {
                e = e5;
                af.b("MBRoundRectImageViewC", e.getMessage());
                return bitmap2;
            }
        } catch (Exception e6) {
            e = e6;
            bitmap2 = bitmap;
            af.b("MBRoundRectImageViewC", e.getMessage());
            return bitmap2;
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        try {
            Drawable drawable = getDrawable();
            if (drawable == null) {
                super.onDraw(canvas);
                return;
            }
            Bitmap a5 = a(((BitmapDrawable) drawable).getBitmap());
            if (a5 != null) {
                if (!a5.isRecycled()) {
                    Bitmap a6 = a(a5, 30);
                    if (a6 != null) {
                        if (!a6.isRecycled()) {
                            Rect rect = new Rect(0, 0, a6.getWidth(), a6.getHeight());
                            this.f8364a.reset();
                            canvas.drawBitmap(a6, rect, rect, this.f8364a);
                            return;
                        }
                    }
                    super.onDraw(canvas);
                    return;
                }
            }
            super.onDraw(canvas);
        } catch (Exception e5) {
            af.b("MBRoundRectImageViewC", e5.getMessage());
        }
    }

    private Bitmap a(Bitmap bitmap, int i5) {
        if (bitmap != null && !bitmap.isRecycled()) {
            try {
                Shader.TileMode tileMode = Shader.TileMode.CLAMP;
                BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
                Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_4444);
                Canvas canvas = new Canvas(createBitmap);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setShader(bitmapShader);
                float f5 = (float) i5;
                canvas.drawRoundRect(new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight()), f5, f5, paint);
                return createBitmap;
            } catch (Exception e5) {
                af.b("MBRoundRectImageViewC", e5.getMessage());
            }
        }
        return bitmap;
    }
}
