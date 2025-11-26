package com.mbridge.msdk.video.dynview.g;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.RectShape;

public final class a extends ShapeDrawable {

    /* renamed from: a  reason: collision with root package name */
    private int f12089a;

    /* renamed from: b  reason: collision with root package name */
    private float f12090b;

    /* renamed from: c  reason: collision with root package name */
    private float f12091c;

    /* renamed from: d  reason: collision with root package name */
    private int f12092d;

    /* renamed from: e  reason: collision with root package name */
    private int f12093e;

    /* renamed from: f  reason: collision with root package name */
    private Bitmap f12094f;

    /* renamed from: g  reason: collision with root package name */
    private Bitmap f12095g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f12096h;

    /* renamed from: i  reason: collision with root package name */
    private Paint f12097i;

    /* renamed from: j  reason: collision with root package name */
    private Matrix f12098j;

    /* renamed from: com.mbridge.msdk.video.dynview.g.a$a  reason: collision with other inner class name */
    public static class C0110a implements b {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public RectShape f12099a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public Bitmap f12100b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public Bitmap f12101c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public boolean f12102d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f12103e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f12104f;
        /* access modifiers changed from: private */

        /* renamed from: g  reason: collision with root package name */
        public int f12105g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public float f12106h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public float f12107i;

        private C0110a() {
            this.f12104f = 100;
            this.f12105g = 10;
            this.f12099a = new RectShape();
        }

        public final b a(Bitmap bitmap) {
            this.f12100b = bitmap;
            return this;
        }

        public final b b(Bitmap bitmap) {
            this.f12101c = bitmap;
            return this;
        }

        public final b a(boolean z4) {
            this.f12102d = z4;
            return this;
        }

        public final b b(float f5) {
            this.f12107i = f5;
            return this;
        }

        public final b a(int i5) {
            this.f12103e = i5;
            return this;
        }

        public final b a(float f5) {
            this.f12106h = f5;
            return this;
        }

        public final a a() {
            return new a(this);
        }
    }

    public interface b {
        b a(Bitmap bitmap);

        b a(boolean z4);

        b b(float f5);

        b b(Bitmap bitmap);
    }

    private void a(Canvas canvas, Path path, Bitmap bitmap) {
        if (canvas != null && path != null && bitmap != null && !bitmap.isRecycled()) {
            if (!(bitmap.getWidth() == 0 || bitmap.getHeight() == 0)) {
                float max = Math.max(this.f12090b / ((float) bitmap.getWidth()), this.f12091c / ((float) bitmap.getHeight()));
                if (this.f12098j == null) {
                    this.f12098j = new Matrix();
                }
                this.f12098j.reset();
                this.f12098j.preScale(max, max);
            }
            Shader.TileMode tileMode = Shader.TileMode.CLAMP;
            BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
            bitmapShader.setLocalMatrix(this.f12098j);
            this.f12097i.setShader(bitmapShader);
            canvas.drawPath(path, this.f12097i);
        }
    }

    public final void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.f12089a == 1) {
            float f5 = this.f12091c / 2.0f;
            Path path = new Path();
            path.moveTo(0.0f, 0.0f);
            path.lineTo(0.0f, (((float) this.f12092d) + f5) - ((float) this.f12093e));
            path.lineTo(this.f12090b, (f5 - ((float) this.f12092d)) - ((float) this.f12093e));
            path.lineTo(this.f12090b, 0.0f);
            if (this.f12096h) {
                try {
                    a(canvas, path);
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            } else {
                Bitmap bitmap = this.f12094f;
                if (bitmap != null && !bitmap.isRecycled()) {
                    try {
                        a(canvas, path, this.f12094f);
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            }
            Path path2 = new Path();
            path2.moveTo(0.0f, ((float) this.f12092d) + f5 + ((float) this.f12093e));
            path2.lineTo(0.0f, this.f12091c);
            path2.lineTo(this.f12090b, this.f12091c);
            path2.lineTo(this.f12090b, (f5 - ((float) this.f12092d)) + ((float) this.f12093e));
            if (this.f12096h) {
                try {
                    a(canvas, path2);
                } catch (Exception e7) {
                    e7.printStackTrace();
                }
            } else {
                Bitmap bitmap2 = this.f12095g;
                if (bitmap2 != null && !bitmap2.isRecycled()) {
                    try {
                        a(canvas, path2, this.f12095g);
                    } catch (Exception e8) {
                        e8.printStackTrace();
                    }
                }
            }
        } else {
            float f6 = this.f12090b / 2.0f;
            Path path3 = new Path();
            path3.moveTo(0.0f, 0.0f);
            path3.lineTo(0.0f, this.f12091c);
            path3.lineTo((f6 - ((float) this.f12092d)) - ((float) this.f12093e), this.f12091c);
            path3.lineTo((((float) this.f12092d) + f6) - ((float) this.f12093e), 0.0f);
            if (this.f12096h) {
                try {
                    a(canvas, path3);
                } catch (Exception e9) {
                    e9.printStackTrace();
                }
            } else {
                Bitmap bitmap3 = this.f12094f;
                if (bitmap3 != null && !bitmap3.isRecycled()) {
                    try {
                        a(canvas, path3, this.f12094f);
                    } catch (Exception e10) {
                        e10.printStackTrace();
                    }
                }
            }
            Path path4 = new Path();
            path4.moveTo(((float) this.f12092d) + f6 + ((float) this.f12093e), 0.0f);
            path4.lineTo(this.f12090b, 0.0f);
            path4.lineTo(this.f12090b, this.f12091c);
            path4.lineTo((f6 - ((float) this.f12092d)) + ((float) this.f12093e), this.f12091c);
            if (this.f12096h) {
                try {
                    a(canvas, path4);
                } catch (Exception e11) {
                    e11.printStackTrace();
                }
            } else {
                Bitmap bitmap4 = this.f12095g;
                if (bitmap4 != null && !bitmap4.isRecycled()) {
                    try {
                        a(canvas, path4, this.f12095g);
                    } catch (Exception e12) {
                        e12.printStackTrace();
                    }
                }
            }
        }
    }

    public final int getOpacity() {
        return -3;
    }

    private a(C0110a aVar) {
        super(aVar.f12099a);
        this.f12096h = false;
        this.f12094f = aVar.f12100b;
        this.f12095g = aVar.f12101c;
        this.f12096h = aVar.f12102d;
        this.f12089a = aVar.f12103e;
        this.f12092d = aVar.f12104f;
        this.f12093e = aVar.f12105g;
        this.f12090b = aVar.f12106h;
        this.f12091c = aVar.f12107i;
        Paint paint = new Paint();
        this.f12097i = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f12097i.setAntiAlias(true);
        this.f12098j = new Matrix();
    }

    private void a(Canvas canvas, Path path) {
        this.f12097i.setColor(Color.parseColor("#40EAEAEA"));
        canvas.drawPath(path, this.f12097i);
    }

    public static C0110a a() {
        return new C0110a();
    }
}
