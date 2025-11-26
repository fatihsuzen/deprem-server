package com.mbridge.msdk.dycreator.baseview.cusview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.widget.ImageView;
import androidx.annotation.Nullable;
import com.mbridge.msdk.foundation.tools.af;

public class MBridgeImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private Xfermode f8477a;

    /* renamed from: b  reason: collision with root package name */
    private int f8478b;

    /* renamed from: c  reason: collision with root package name */
    private int f8479c;

    /* renamed from: d  reason: collision with root package name */
    private int f8480d;

    /* renamed from: e  reason: collision with root package name */
    private int f8481e;

    /* renamed from: f  reason: collision with root package name */
    private int f8482f;

    /* renamed from: g  reason: collision with root package name */
    private int f8483g;

    /* renamed from: h  reason: collision with root package name */
    private int f8484h;

    /* renamed from: i  reason: collision with root package name */
    private int f8485i;

    /* renamed from: j  reason: collision with root package name */
    private int f8486j;

    /* renamed from: k  reason: collision with root package name */
    private float[] f8487k;

    /* renamed from: l  reason: collision with root package name */
    private float[] f8488l;

    /* renamed from: m  reason: collision with root package name */
    private RectF f8489m;

    /* renamed from: n  reason: collision with root package name */
    private RectF f8490n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f8491o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f8492p;

    /* renamed from: q  reason: collision with root package name */
    private Path f8493q;

    /* renamed from: r  reason: collision with root package name */
    private Paint f8494r;

    public MBridgeImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (canvas != null) {
            try {
                canvas.saveLayer(this.f8489m, (Paint) null, 31);
                int i5 = this.f8478b;
                int i6 = this.f8485i;
                int i7 = this.f8479c;
                canvas.scale((((float) (i5 - (i6 * 2))) * 1.0f) / ((float) i5), (((float) (i7 - (i6 * 2))) * 1.0f) / ((float) i7), ((float) i5) / 2.0f, ((float) i7) / 2.0f);
                super.onDraw(canvas);
                Paint paint = this.f8494r;
                if (paint != null) {
                    paint.reset();
                    this.f8494r.setAntiAlias(true);
                    this.f8494r.setStyle(Paint.Style.FILL);
                    this.f8494r.setXfermode(this.f8477a);
                }
                Path path = this.f8493q;
                if (path != null) {
                    path.reset();
                    this.f8493q.addRoundRect(this.f8489m, this.f8488l, Path.Direction.CCW);
                }
                canvas.drawPath(this.f8493q, this.f8494r);
                Paint paint2 = this.f8494r;
                if (paint2 != null) {
                    paint2.setXfermode((Xfermode) null);
                }
                canvas.restore();
                if (this.f8491o) {
                    int i8 = this.f8485i;
                    int i9 = this.f8486j;
                    RectF rectF = this.f8490n;
                    float[] fArr = this.f8487k;
                    try {
                        Path path2 = this.f8493q;
                        if (path2 != null) {
                            path2.reset();
                        }
                        Paint paint3 = this.f8494r;
                        if (paint3 != null) {
                            paint3.setStrokeWidth((float) i8);
                            this.f8494r.setColor(i9);
                            this.f8494r.setStyle(Paint.Style.STROKE);
                        }
                        Path path3 = this.f8493q;
                        if (path3 != null) {
                            path3.addRoundRect(rectF, fArr, Path.Direction.CCW);
                        }
                        canvas.drawPath(this.f8493q, this.f8494r);
                    } catch (Exception e5) {
                        e5.printStackTrace();
                    }
                }
            } catch (Exception e6) {
                af.a("MBridgeImageView", e6.getMessage());
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i5, int i6, int i7, int i8) {
        int i9;
        int i10;
        int i11;
        super.onSizeChanged(i5, i6, i7, i8);
        this.f8478b = i5;
        this.f8479c = i6;
        int i12 = 0;
        if (this.f8492p) {
            try {
                if (!(this.f8487k == null || this.f8488l == null)) {
                    while (true) {
                        i9 = 2;
                        if (i12 >= 2) {
                            break;
                        }
                        float[] fArr = this.f8487k;
                        int i13 = this.f8481e;
                        fArr[i12] = (float) i13;
                        this.f8488l[i12] = ((float) i13) - (((float) this.f8485i) / 2.0f);
                        i12++;
                    }
                    while (true) {
                        i10 = 4;
                        if (i9 >= 4) {
                            break;
                        }
                        float[] fArr2 = this.f8487k;
                        int i14 = this.f8482f;
                        fArr2[i9] = (float) i14;
                        this.f8488l[i9] = ((float) i14) - (((float) this.f8485i) / 2.0f);
                        i9++;
                    }
                    while (true) {
                        if (i10 >= 6) {
                            break;
                        }
                        float[] fArr3 = this.f8487k;
                        int i15 = this.f8483g;
                        fArr3[i10] = (float) i15;
                        this.f8488l[i10] = ((float) i15) - (((float) this.f8485i) / 2.0f);
                        i10++;
                    }
                    for (i11 = 6; i11 < 8; i11++) {
                        float[] fArr4 = this.f8487k;
                        int i16 = this.f8484h;
                        fArr4[i11] = (float) i16;
                        this.f8488l[i11] = ((float) i16) - (((float) this.f8485i) / 2.0f);
                    }
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        } else if (this.f8487k != null && this.f8488l != null) {
            while (true) {
                try {
                    float[] fArr5 = this.f8487k;
                    if (i12 >= fArr5.length) {
                        break;
                    }
                    int i17 = this.f8480d;
                    fArr5[i12] = (float) i17;
                    this.f8488l[i12] = ((float) i17) - (((float) this.f8485i) / 2.0f);
                    i12++;
                } catch (Exception e6) {
                    e6.printStackTrace();
                }
            }
        }
        RectF rectF = this.f8490n;
        if (rectF != null) {
            int i18 = this.f8485i;
            rectF.set(((float) i18) / 2.0f, ((float) i18) / 2.0f, ((float) this.f8478b) - (((float) i18) / 2.0f), ((float) this.f8479c) - (((float) i18) / 2.0f));
        }
        RectF rectF2 = this.f8489m;
        if (rectF2 != null) {
            rectF2.set(0.0f, 0.0f, (float) this.f8478b, (float) this.f8479c);
        }
    }

    public void setBorder(int i5, int i6, int i7) {
        this.f8491o = true;
        this.f8485i = i6;
        this.f8486j = i7;
        this.f8480d = i5;
    }

    public void setCornerRadius(int i5) {
        this.f8480d = i5;
    }

    public void setCustomBorder(int i5, int i6, int i7, int i8, int i9, int i10) {
        this.f8491o = true;
        this.f8492p = true;
        this.f8485i = i9;
        this.f8486j = i10;
        this.f8481e = i5;
        this.f8483g = i7;
        this.f8482f = i6;
        this.f8484h = i8;
    }

    public MBridgeImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MBridgeImageView(Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f8493q = new Path();
        this.f8494r = new Paint();
        this.f8487k = new float[8];
        this.f8488l = new float[8];
        this.f8490n = new RectF();
        this.f8489m = new RectF();
        this.f8477a = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }
}
