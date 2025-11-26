package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.widget.ImageView;
import com.squareup.picasso.s;

final class t extends BitmapDrawable {

    /* renamed from: h  reason: collision with root package name */
    private static final Paint f13395h = new Paint();

    /* renamed from: a  reason: collision with root package name */
    private final boolean f13396a;

    /* renamed from: b  reason: collision with root package name */
    private final float f13397b;

    /* renamed from: c  reason: collision with root package name */
    private final s.e f13398c;

    /* renamed from: d  reason: collision with root package name */
    Drawable f13399d;

    /* renamed from: e  reason: collision with root package name */
    long f13400e;

    /* renamed from: f  reason: collision with root package name */
    boolean f13401f;

    /* renamed from: g  reason: collision with root package name */
    int f13402g = 255;

    t(Context context, Bitmap bitmap, Drawable drawable, s.e eVar, boolean z4, boolean z5) {
        super(context.getResources(), bitmap);
        this.f13396a = z5;
        this.f13397b = context.getResources().getDisplayMetrics().density;
        this.f13398c = eVar;
        if (eVar != s.e.MEMORY && !z4) {
            this.f13399d = drawable;
            this.f13401f = true;
            this.f13400e = SystemClock.uptimeMillis();
        }
    }

    private void a(Canvas canvas) {
        Paint paint = f13395h;
        paint.setColor(-1);
        canvas.drawPath(b(0, 0, (int) (this.f13397b * 16.0f)), paint);
        paint.setColor(this.f13398c.f13389a);
        canvas.drawPath(b(0, 0, (int) (this.f13397b * 15.0f)), paint);
    }

    private static Path b(int i5, int i6, int i7) {
        Path path = new Path();
        float f5 = (float) i5;
        float f6 = (float) i6;
        path.moveTo(f5, f6);
        path.lineTo((float) (i5 + i7), f6);
        path.lineTo(f5, (float) (i6 + i7));
        return path;
    }

    static void c(ImageView imageView, Context context, Bitmap bitmap, s.e eVar, boolean z4, boolean z5) {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).stop();
        }
        imageView.setImageDrawable(new t(context, bitmap, drawable, eVar, z4, z5));
    }

    static void d(ImageView imageView, Drawable drawable) {
        imageView.setImageDrawable(drawable);
        if (imageView.getDrawable() instanceof Animatable) {
            ((Animatable) imageView.getDrawable()).start();
        }
    }

    public void draw(Canvas canvas) {
        if (!this.f13401f) {
            super.draw(canvas);
        } else {
            float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.f13400e)) / 200.0f;
            if (uptimeMillis >= 1.0f) {
                this.f13401f = false;
                this.f13399d = null;
                super.draw(canvas);
            } else {
                Drawable drawable = this.f13399d;
                if (drawable != null) {
                    drawable.draw(canvas);
                }
                super.setAlpha((int) (((float) this.f13402g) * uptimeMillis));
                super.draw(canvas);
                super.setAlpha(this.f13402g);
            }
        }
        if (this.f13396a) {
            a(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        Drawable drawable = this.f13399d;
        if (drawable != null) {
            drawable.setBounds(rect);
        }
        super.onBoundsChange(rect);
    }

    public void setAlpha(int i5) {
        this.f13402g = i5;
        Drawable drawable = this.f13399d;
        if (drawable != null) {
            drawable.setAlpha(i5);
        }
        super.setAlpha(i5);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        Drawable drawable = this.f13399d;
        if (drawable != null) {
            drawable.setColorFilter(colorFilter);
        }
        super.setColorFilter(colorFilter);
    }
}
