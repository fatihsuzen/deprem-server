package com.mbridge.msdk.dycreator.baseview.cusview;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.graphics.Xfermode;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.annotation.Nullable;
import com.mbridge.msdk.dycreator.a.b;
import com.mbridge.msdk.dycreator.a.c;
import com.mbridge.msdk.dycreator.baseview.GradientOrientationUtils;
import com.mbridge.msdk.foundation.tools.af;
import java.util.HashMap;

public class MBCusRoundImageView extends ImageView {

    /* renamed from: a  reason: collision with root package name */
    private int f8413a;

    /* renamed from: b  reason: collision with root package name */
    private int f8414b;

    /* renamed from: c  reason: collision with root package name */
    private int f8415c;

    /* renamed from: d  reason: collision with root package name */
    private int f8416d;

    /* renamed from: e  reason: collision with root package name */
    private Xfermode f8417e;

    /* renamed from: f  reason: collision with root package name */
    private int f8418f;

    /* renamed from: g  reason: collision with root package name */
    private int f8419g;

    /* renamed from: h  reason: collision with root package name */
    private int f8420h;

    /* renamed from: i  reason: collision with root package name */
    private int f8421i;

    /* renamed from: j  reason: collision with root package name */
    private int f8422j;

    /* renamed from: k  reason: collision with root package name */
    private int f8423k;

    /* renamed from: l  reason: collision with root package name */
    private int f8424l;

    /* renamed from: m  reason: collision with root package name */
    private int f8425m;

    /* renamed from: n  reason: collision with root package name */
    private int f8426n;

    /* renamed from: o  reason: collision with root package name */
    private float[] f8427o;

    /* renamed from: p  reason: collision with root package name */
    private float[] f8428p;

    /* renamed from: q  reason: collision with root package name */
    private RectF f8429q;

    /* renamed from: r  reason: collision with root package name */
    private RectF f8430r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f8431s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f8432t;

    /* renamed from: u  reason: collision with root package name */
    private Path f8433u;

    /* renamed from: v  reason: collision with root package name */
    private Paint f8434v;

    /* renamed from: com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f8435a;

        /* JADX WARNING: Can't wrap try/catch for region: R(32:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|(3:31|32|34)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(34:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|34) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.mbridge.msdk.dycreator.a.c[] r0 = com.mbridge.msdk.dycreator.a.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f8435a = r0
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.id     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f8435a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.src     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f8435a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.background     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f8435a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.contentDescription     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f8435a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.tag     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f8435a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.visibility     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f8435a     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.scaleType     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f8435a     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.padding     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f8435a     // Catch:{ NoSuchFieldError -> 0x006c }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.paddingTop     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = f8435a     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.paddingBottom     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f8435a     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.paddingLeft     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = f8435a     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.paddingRight     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = f8435a     // Catch:{ NoSuchFieldError -> 0x009c }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_width     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = f8435a     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_height     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = f8435a     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.gravity     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = f8435a     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.mbridge.msdk.dycreator.a.c r1 = com.mbridge.msdk.dycreator.a.c.layout_gravity     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.dycreator.baseview.cusview.MBCusRoundImageView.AnonymousClass1.<clinit>():void");
        }
    }

    public MBCusRoundImageView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ViewGroup.LayoutParams generateLayoutParams(Context context, AttributeSet attributeSet) {
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -1);
        HashMap<String, c> c5 = b.a().c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i5 = 0; i5 < attributeCount; i5++) {
            c cVar = c5.get(attributeSet.getAttributeName(i5));
            if (cVar != null) {
                int i6 = AnonymousClass1.f8435a[cVar.ordinal()];
                if (i6 == 6) {
                    String attributeValue = attributeSet.getAttributeValue(i5);
                    if (!TextUtils.isEmpty(attributeValue)) {
                        if (attributeValue.equals("invisible")) {
                            setVisibility(4);
                        } else if (attributeValue.equalsIgnoreCase("gone")) {
                            setVisibility(8);
                        }
                    }
                } else if (i6 == 13) {
                    String attributeValue2 = attributeSet.getAttributeValue(i5);
                    if (attributeValue2.startsWith("f") || attributeValue2.startsWith("m")) {
                        layoutParams.width = -1;
                    } else if (attributeValue2.startsWith("wrap")) {
                        layoutParams.width = -2;
                    } else {
                        layoutParams.width = b.a().b(attributeValue2);
                    }
                } else if (i6 == 14) {
                    String attributeValue3 = attributeSet.getAttributeValue(i5);
                    if (attributeValue3.startsWith("f") || attributeValue3.startsWith("m")) {
                        layoutParams.height = -1;
                    } else if (attributeValue3.startsWith("wrap")) {
                        layoutParams.height = -2;
                    } else {
                        layoutParams.height = b.a().b(attributeValue3);
                    }
                }
            }
        }
        return layoutParams;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        if (canvas != null) {
            try {
                canvas.saveLayer(this.f8429q, (Paint) null, 31);
                int i5 = this.f8418f;
                int i6 = this.f8425m;
                int i7 = this.f8419g;
                canvas.scale((((float) (i5 - (i6 * 2))) * 1.0f) / ((float) i5), (((float) (i7 - (i6 * 2))) * 1.0f) / ((float) i7), ((float) i5) / 2.0f, ((float) i7) / 2.0f);
                super.onDraw(canvas);
                Paint paint = this.f8434v;
                if (paint != null) {
                    paint.reset();
                    this.f8434v.setAntiAlias(true);
                    this.f8434v.setStyle(Paint.Style.FILL);
                    this.f8434v.setXfermode(this.f8417e);
                }
                Path path = this.f8433u;
                if (path != null) {
                    path.reset();
                    this.f8433u.addRoundRect(this.f8429q, this.f8428p, Path.Direction.CCW);
                }
                canvas.drawPath(this.f8433u, this.f8434v);
                Paint paint2 = this.f8434v;
                if (paint2 != null) {
                    paint2.setXfermode((Xfermode) null);
                }
                canvas.restore();
                if (this.f8431s) {
                    int i8 = this.f8425m;
                    int i9 = this.f8426n;
                    RectF rectF = this.f8430r;
                    float[] fArr = this.f8427o;
                    try {
                        Path path2 = this.f8433u;
                        if (path2 != null) {
                            path2.reset();
                        }
                        Paint paint3 = this.f8434v;
                        if (paint3 != null) {
                            paint3.setStrokeWidth((float) i8);
                            this.f8434v.setColor(i9);
                            this.f8434v.setStyle(Paint.Style.STROKE);
                        }
                        Path path3 = this.f8433u;
                        if (path3 != null) {
                            path3.addRoundRect(rectF, fArr, Path.Direction.CCW);
                        }
                        canvas.drawPath(this.f8433u, this.f8434v);
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
        try {
            this.f8418f = i5;
            this.f8419g = i6;
            int i12 = 0;
            if (this.f8432t) {
                try {
                    if (!(this.f8427o == null || this.f8428p == null)) {
                        while (true) {
                            i9 = 2;
                            if (i12 >= 2) {
                                break;
                            }
                            float[] fArr = this.f8427o;
                            int i13 = this.f8421i;
                            fArr[i12] = (float) i13;
                            this.f8428p[i12] = ((float) i13) - (((float) this.f8425m) / 2.0f);
                            i12++;
                        }
                        while (true) {
                            i10 = 4;
                            if (i9 >= 4) {
                                break;
                            }
                            float[] fArr2 = this.f8427o;
                            int i14 = this.f8422j;
                            fArr2[i9] = (float) i14;
                            this.f8428p[i9] = ((float) i14) - (((float) this.f8425m) / 2.0f);
                            i9++;
                        }
                        while (true) {
                            if (i10 >= 6) {
                                break;
                            }
                            float[] fArr3 = this.f8427o;
                            int i15 = this.f8423k;
                            fArr3[i10] = (float) i15;
                            this.f8428p[i10] = ((float) i15) - (((float) this.f8425m) / 2.0f);
                            i10++;
                        }
                        for (i11 = 6; i11 < 8; i11++) {
                            float[] fArr4 = this.f8427o;
                            int i16 = this.f8424l;
                            fArr4[i11] = (float) i16;
                            this.f8428p[i11] = ((float) i16) - (((float) this.f8425m) / 2.0f);
                        }
                    }
                } catch (Exception e5) {
                    e5.printStackTrace();
                }
            } else if (this.f8427o != null && this.f8428p != null) {
                while (true) {
                    try {
                        float[] fArr5 = this.f8427o;
                        if (i12 >= fArr5.length) {
                            break;
                        }
                        int i17 = this.f8420h;
                        fArr5[i12] = (float) i17;
                        this.f8428p[i12] = ((float) i17) - (((float) this.f8425m) / 2.0f);
                        i12++;
                    } catch (Exception e6) {
                        e6.printStackTrace();
                    }
                }
            }
            RectF rectF = this.f8430r;
            if (rectF != null) {
                int i18 = this.f8425m;
                rectF.set(((float) i18) / 2.0f, ((float) i18) / 2.0f, ((float) this.f8418f) - (((float) i18) / 2.0f), ((float) this.f8419g) - (((float) i18) / 2.0f));
            }
            RectF rectF2 = this.f8429q;
            if (rectF2 != null) {
                rectF2.set(0.0f, 0.0f, (float) this.f8418f, (float) this.f8419g);
            }
        } catch (Exception e7) {
            af.b("MBridgeImageView", e7.getMessage());
        }
    }

    public void setAttributeSet(AttributeSet attributeSet) {
        String[] strArr;
        HashMap<String, c> c5 = b.a().c();
        int attributeCount = attributeSet.getAttributeCount();
        for (int i5 = 0; i5 < attributeCount; i5++) {
            c cVar = c5.get(attributeSet.getAttributeName(i5));
            if (cVar != null) {
                switch (AnonymousClass1.f8435a[cVar.ordinal()]) {
                    case 1:
                        String attributeValue = attributeSet.getAttributeValue(i5);
                        if (!attributeValue.startsWith("@+id/")) {
                            break;
                        } else {
                            setId(attributeValue.substring(5).hashCode());
                            break;
                        }
                    case 2:
                        b.a().a(attributeSet.getAttributeValue(i5), (ImageView) this);
                        break;
                    case 3:
                        String attributeValue2 = attributeSet.getAttributeValue(i5);
                        if (!attributeValue2.startsWith("#")) {
                            if (attributeValue2.startsWith("@drawable/")) {
                                attributeValue2 = attributeValue2.substring(10);
                            }
                            setBackgroundResource(getResources().getIdentifier(attributeValue2, "drawable", getContext().getPackageName()));
                            break;
                        } else {
                            try {
                                strArr = attributeValue2.split("-");
                            } catch (Exception unused) {
                                strArr = null;
                            }
                            if (strArr != null && strArr.length <= 2) {
                                setBackgroundColor(b.a().a(attributeSet.getAttributeValue(i5)));
                                break;
                            } else {
                                if (strArr != null && strArr.length == 3) {
                                    try {
                                        GradientDrawable gradientDrawable = new GradientDrawable(GradientOrientationUtils.getOrientation(strArr[2]), new int[]{Color.parseColor(strArr[0]), Color.parseColor(strArr[1])});
                                        gradientDrawable.setGradientType(0);
                                        setBackground(gradientDrawable);
                                        break;
                                    } catch (Exception unused2) {
                                    }
                                }
                                setBackgroundColor(b.a().a(attributeSet.getAttributeValue(i5)));
                                break;
                            }
                        }
                        break;
                    case 4:
                        String attributeValue3 = attributeSet.getAttributeValue(i5);
                        if (TextUtils.isEmpty(attributeValue3)) {
                            break;
                        } else {
                            String str = com.mbridge.msdk.dycreator.e.b.f8692a.get(attributeValue3.substring(8));
                            if (TextUtils.isEmpty(str)) {
                                break;
                            } else {
                                setContentDescription(str);
                                break;
                            }
                        }
                    case 5:
                        String attributeValue4 = attributeSet.getAttributeValue(i5);
                        if (!TextUtils.isEmpty(attributeValue4)) {
                            String str2 = com.mbridge.msdk.dycreator.e.b.f8692a.get(attributeValue4.substring(8));
                            if (!TextUtils.isEmpty(str2)) {
                                setTag(str2);
                                break;
                            } else {
                                break;
                            }
                        } else {
                            break;
                        }
                    case 6:
                        String attributeValue5 = attributeSet.getAttributeValue(i5);
                        if (!TextUtils.isEmpty(attributeValue5)) {
                            if (!attributeValue5.equals("invisible")) {
                                if (!attributeValue5.equalsIgnoreCase("gone")) {
                                    break;
                                } else {
                                    setVisibility(8);
                                    break;
                                }
                            } else {
                                setVisibility(4);
                                break;
                            }
                        } else {
                            break;
                        }
                    case 7:
                        String attributeValue6 = attributeSet.getAttributeValue(i5);
                        if (!TextUtils.isEmpty(attributeValue6)) {
                            if (!attributeValue6.equals("fitXY")) {
                                if (!attributeValue6.equals("centerInside")) {
                                    if (!attributeValue6.equals("centerCrop")) {
                                        break;
                                    } else {
                                        setScaleType(ImageView.ScaleType.CENTER_CROP);
                                        break;
                                    }
                                } else {
                                    setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                                    break;
                                }
                            } else {
                                setScaleType(ImageView.ScaleType.FIT_XY);
                                break;
                            }
                        } else {
                            break;
                        }
                    case 8:
                        int b5 = b.a().b(attributeSet.getAttributeValue(i5));
                        this.f8416d = b5;
                        this.f8415c = b5;
                        this.f8414b = b5;
                        this.f8413a = b5;
                        setPadding(b5, b5, b5, b5);
                        break;
                    case 9:
                        int b6 = b.a().b(attributeSet.getAttributeValue(i5));
                        this.f8414b = b6;
                        setPadding(this.f8413a, b6, this.f8415c, this.f8416d);
                        break;
                    case 10:
                        int b7 = b.a().b(attributeSet.getAttributeValue(i5));
                        this.f8416d = b7;
                        setPadding(this.f8413a, this.f8414b, this.f8415c, b7);
                        break;
                    case 11:
                        int b8 = b.a().b(attributeSet.getAttributeValue(i5));
                        this.f8413a = b8;
                        setPadding(b8, this.f8414b, this.f8415c, this.f8416d);
                        break;
                    case 12:
                        int b9 = b.a().b(attributeSet.getAttributeValue(i5));
                        this.f8415c = b9;
                        setPadding(this.f8413a, this.f8414b, b9, this.f8416d);
                        break;
                }
            }
        }
    }

    public void setBorder(int i5, int i6, int i7) {
        this.f8431s = true;
        this.f8425m = i6;
        this.f8426n = i7;
        this.f8420h = i5;
    }

    public void setCornerRadius(int i5) {
        this.f8420h = i5;
    }

    public void setCustomBorder(int i5, int i6, int i7, int i8, int i9, int i10) {
        this.f8431s = true;
        this.f8432t = true;
        this.f8425m = i9;
        this.f8426n = i10;
        this.f8421i = i5;
        this.f8423k = i7;
        this.f8422j = i6;
        this.f8424l = i8;
    }

    public MBCusRoundImageView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, (AttributeSet) null, 0);
        try {
            setAttributeSet(attributeSet);
            setLayoutParams(generateLayoutParams(context, attributeSet));
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public MBCusRoundImageView(Context context, @Nullable AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        this.f8433u = new Path();
        this.f8434v = new Paint();
        this.f8427o = new float[8];
        this.f8428p = new float[8];
        this.f8430r = new RectF();
        this.f8429q = new RectF();
        this.f8417e = new PorterDuffXfermode(PorterDuff.Mode.DST_IN);
    }
}
