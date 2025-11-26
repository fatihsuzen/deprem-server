package com.mbridge.msdk.foundation.webview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.View;
import com.mbridge.msdk.foundation.webview.c;

public class ProgressBar extends View implements c {

    /* renamed from: a  reason: collision with root package name */
    Runnable f9770a = new Runnable() {
        public final void run() {
            ProgressBar.this.invalidate();
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private float f9771b;

    /* renamed from: c  reason: collision with root package name */
    private float f9772c;

    /* renamed from: d  reason: collision with root package name */
    private float f9773d;

    /* renamed from: e  reason: collision with root package name */
    private Drawable f9774e;

    /* renamed from: f  reason: collision with root package name */
    private float f9775f;

    /* renamed from: g  reason: collision with root package name */
    private long f9776g = 25;

    /* renamed from: h  reason: collision with root package name */
    private Handler f9777h = new Handler(Looper.getMainLooper());

    /* renamed from: i  reason: collision with root package name */
    private Drawable f9778i;

    /* renamed from: j  reason: collision with root package name */
    private int f9779j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f9780k = false;

    /* renamed from: l  reason: collision with root package name */
    private boolean f9781l;

    /* renamed from: m  reason: collision with root package name */
    private long f9782m;

    /* renamed from: n  reason: collision with root package name */
    private float f9783n = 0.95f;

    /* renamed from: o  reason: collision with root package name */
    private boolean f9784o = false;

    /* renamed from: p  reason: collision with root package name */
    private c.a f9785p;

    /* renamed from: q  reason: collision with root package name */
    private Drawable f9786q;

    /* renamed from: r  reason: collision with root package name */
    private Rect f9787r = new Rect();

    /* renamed from: s  reason: collision with root package name */
    private Drawable f9788s;

    /* renamed from: t  reason: collision with root package name */
    private float f9789t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f9790u;

    /* renamed from: v  reason: collision with root package name */
    private int f9791v;

    /* renamed from: w  reason: collision with root package name */
    private int f9792w;

    /* renamed from: x  reason: collision with root package name */
    private int f9793x;

    /* renamed from: y  reason: collision with root package name */
    private long f9794y;

    public ProgressBar(Context context) {
        super(context);
        setWillNotDraw(false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0042, code lost:
        if (r11.f9781l != false) goto L_0x005b;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004b, code lost:
        if (r11.f9781l != false) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
        if (r11.f9781l != false) goto L_0x004e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0059, code lost:
        if (r11.f9781l != false) goto L_0x005b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0066  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0092  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x011d  */
    /* JADX WARNING: Removed duplicated region for block: B:72:0x0167  */
    /* JADX WARNING: Removed duplicated region for block: B:76:0x0185  */
    /* JADX WARNING: Removed duplicated region for block: B:78:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void draw(android.graphics.Canvas r12) {
        /*
            r11 = this;
            boolean r0 = r11.f9780k
            r1 = 1
            if (r0 != 0) goto L_0x0007
            r11.f9780k = r1
        L_0x0007:
            long r2 = java.lang.System.currentTimeMillis()
            boolean r0 = r11.f9784o
            if (r0 == 0) goto L_0x0012
            r4 = 0
            goto L_0x0016
        L_0x0012:
            long r4 = r11.f9782m
            long r4 = r2 - r4
        L_0x0016:
            float r0 = (float) r4
            r6 = 1148846080(0x447a0000, float:1000.0)
            float r0 = r0 / r6
            float r0 = java.lang.Math.abs(r0)
            r11.f9773d = r0
            r11.f9782m = r2
            long r2 = r11.f9794y
            long r2 = r2 + r4
            r11.f9794y = r2
            boolean r4 = r11.f9790u
            r5 = 1028443341(0x3d4ccccd, float:0.05)
            r6 = 1045220557(0x3e4ccccd, float:0.2)
            r7 = 1053609165(0x3ecccccd, float:0.4)
            r8 = 1065353216(0x3f800000, float:1.0)
            if (r4 != 0) goto L_0x0057
            r9 = 2000(0x7d0, double:9.88E-321)
            int r2 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r2 >= 0) goto L_0x0055
            int r2 = r11.f9792w
            if (r2 != r1) goto L_0x0045
            boolean r1 = r11.f9781l
            if (r1 == 0) goto L_0x005c
            goto L_0x005b
        L_0x0045:
            int r2 = r11.f9791v
            if (r2 != r1) goto L_0x0050
            boolean r1 = r11.f9781l
            if (r1 == 0) goto L_0x004e
            goto L_0x005c
        L_0x004e:
            r7 = r6
            goto L_0x005c
        L_0x0050:
            boolean r1 = r11.f9781l
            if (r1 == 0) goto L_0x0055
            goto L_0x004e
        L_0x0055:
            r7 = r5
            goto L_0x005c
        L_0x0057:
            boolean r1 = r11.f9781l
            if (r1 == 0) goto L_0x005c
        L_0x005b:
            r7 = r8
        L_0x005c:
            r11.f9772c = r7
            float r1 = r11.f9771b
            float r7 = r7 * r0
            float r1 = r1 + r7
            r11.f9771b = r1
            if (r4 != 0) goto L_0x006e
            float r0 = r11.f9783n
            int r1 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r1 <= 0) goto L_0x006e
            r11.f9771b = r0
        L_0x006e:
            android.graphics.Rect r0 = r11.f9787r
            float r1 = r11.f9771b
            float r2 = r11.f9789t
            float r1 = r1 * r2
            int r1 = (int) r1
            r0.right = r1
            android.os.Handler r0 = r11.f9777h
            r1 = 0
            r0.removeCallbacksAndMessages(r1)
            android.os.Handler r0 = r11.f9777h
            java.lang.Runnable r1 = r11.f9770a
            long r2 = r11.f9776g
            r0.postDelayed(r1, r2)
            super.draw(r12)
            float r0 = r11.f9773d
            boolean r1 = r11.f9790u
            r2 = 0
            r3 = 0
            if (r1 == 0) goto L_0x00c9
            float r1 = r11.f9775f
            float r4 = r11.f9789t
            r7 = 1056964608(0x3f000000, float:0.5)
            float r9 = r4 * r7
            float r9 = r1 / r9
            float r8 = r8 - r9
            r9 = 1132396544(0x437f0000, float:255.0)
            float r8 = r8 * r9
            int r8 = (int) r8
            if (r8 >= 0) goto L_0x00a4
            r8 = r3
        L_0x00a4:
            float r4 = r4 * r7
            int r1 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r1 <= 0) goto L_0x00ac
            r11.setVisible(r3)
        L_0x00ac:
            android.graphics.drawable.Drawable r1 = r11.f9788s
            if (r1 == 0) goto L_0x00b3
            r1.setAlpha(r8)
        L_0x00b3:
            android.graphics.drawable.Drawable r1 = r11.f9774e
            if (r1 == 0) goto L_0x00ba
            r1.setAlpha(r8)
        L_0x00ba:
            android.graphics.drawable.Drawable r1 = r11.f9786q
            if (r1 == 0) goto L_0x00c1
            r1.setAlpha(r8)
        L_0x00c1:
            r12.save()
            float r1 = r11.f9775f
            r12.translate(r1, r2)
        L_0x00c9:
            android.graphics.drawable.Drawable r1 = r11.f9788s
            if (r1 == 0) goto L_0x00f0
            android.graphics.drawable.Drawable r1 = r11.f9786q
            if (r1 == 0) goto L_0x00f0
            android.graphics.Rect r1 = r11.f9787r
            int r1 = r1.width()
            float r1 = (float) r1
            android.graphics.drawable.Drawable r4 = r11.f9786q
            int r4 = r4.getIntrinsicWidth()
            float r4 = (float) r4
            float r4 = r4 * r5
            float r1 = r1 - r4
            int r1 = (int) r1
            android.graphics.drawable.Drawable r4 = r11.f9788s
            int r5 = r4.getIntrinsicHeight()
            r4.setBounds(r3, r3, r1, r5)
            android.graphics.drawable.Drawable r1 = r11.f9788s
            r1.draw(r12)
        L_0x00f0:
            boolean r1 = r11.f9790u
            if (r1 == 0) goto L_0x0119
            android.graphics.drawable.Drawable r1 = r11.f9774e
            if (r1 == 0) goto L_0x0119
            android.graphics.drawable.Drawable r4 = r11.f9786q
            if (r4 == 0) goto L_0x0119
            int r1 = r1.getIntrinsicWidth()
            android.graphics.drawable.Drawable r4 = r11.f9774e
            int r5 = r4.getIntrinsicHeight()
            r4.setBounds(r3, r3, r1, r5)
            r12.save()
            int r1 = -r1
            float r1 = (float) r1
            r12.translate(r1, r2)
            android.graphics.drawable.Drawable r1 = r11.f9774e
            r1.draw(r12)
            r12.restore()
        L_0x0119:
            android.graphics.drawable.Drawable r1 = r11.f9786q
            if (r1 == 0) goto L_0x0137
            r12.save()
            android.graphics.Rect r1 = r11.f9787r
            int r1 = r1.width()
            int r3 = r11.getWidth()
            int r1 = r1 - r3
            float r1 = (float) r1
            r12.translate(r1, r2)
            android.graphics.drawable.Drawable r1 = r11.f9786q
            r1.draw(r12)
            r12.restore()
        L_0x0137:
            boolean r1 = r11.f9790u
            if (r1 != 0) goto L_0x0181
            float r1 = r11.f9771b
            float r3 = r11.f9783n
            float r1 = r1 - r3
            float r1 = java.lang.Math.abs(r1)
            r3 = 925353388(0x3727c5ac, float:1.0E-5)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x0181
            android.graphics.drawable.Drawable r1 = r11.f9778i
            if (r1 == 0) goto L_0x0181
            int r3 = r11.f9779j
            float r3 = (float) r3
            float r0 = r0 * r6
            float r4 = r11.f9789t
            float r0 = r0 * r4
            float r3 = r3 + r0
            int r0 = (int) r3
            r11.f9779j = r0
            int r1 = r1.getIntrinsicWidth()
            int r0 = r0 + r1
            android.graphics.Rect r1 = r11.f9787r
            int r1 = r1.width()
            if (r0 < r1) goto L_0x0170
            android.graphics.drawable.Drawable r0 = r11.f9778i
            int r0 = r0.getIntrinsicWidth()
            int r0 = -r0
            r11.f9779j = r0
        L_0x0170:
            r12.save()
            int r0 = r11.f9779j
            float r0 = (float) r0
            r12.translate(r0, r2)
            android.graphics.drawable.Drawable r0 = r11.f9778i
            r0.draw(r12)
            r12.restore()
        L_0x0181:
            boolean r0 = r11.f9790u
            if (r0 == 0) goto L_0x0188
            r12.restore()
        L_0x0188:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.webview.ProgressBar.draw(android.graphics.Canvas):void");
    }

    public Bitmap getDrawingCache(boolean z4) {
        return null;
    }

    public float getProgress() {
        return this.f9771b;
    }

    public void initResource(boolean z4) {
        if (z4 || (this.f9778i == null && this.f9786q == null && this.f9788s == null && this.f9774e == null)) {
            Drawable drawable = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_highlight", "drawable", com.mbridge.msdk.foundation.controller.c.m().g()));
            this.f9778i = drawable;
            if (drawable != null) {
                drawable.setBounds(0, 0, drawable.getIntrinsicWidth(), this.f9778i.getIntrinsicHeight());
            }
            Drawable drawable2 = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_head", "drawable", com.mbridge.msdk.foundation.controller.c.m().g()));
            this.f9786q = drawable2;
            if (drawable2 != null) {
                drawable2.setBounds(0, 0, drawable2.getIntrinsicWidth(), this.f9786q.getIntrinsicHeight());
            }
            this.f9788s = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_tail", "drawable", com.mbridge.msdk.foundation.controller.c.m().g()));
            this.f9774e = getResources().getDrawable(getResources().getIdentifier("mbridge_cm_end_animation", "drawable", com.mbridge.msdk.foundation.controller.c.m().g()));
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        super.onLayout(z4, i5, i6, i7, i8);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i5, int i6) {
        super.onMeasure(i5, i6);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i5, int i6, int i7, int i8) {
        super.onSizeChanged(i5, i6, i7, i8);
        this.f9789t = (float) getMeasuredWidth();
    }

    public void onThemeChange() {
        if (this.f9780k) {
            initResource(true);
        }
    }

    public void onWindowFocusChanged(boolean z4) {
        super.onWindowFocusChanged(z4);
        Drawable drawable = this.f9778i;
        if (drawable != null) {
            drawable.setBounds(0, 0, (int) (((double) drawable.getIntrinsicWidth()) * 1.5d), getHeight());
        }
        Drawable drawable2 = this.f9786q;
        if (drawable2 != null) {
            drawable2.setBounds(0, 0, getWidth(), getHeight());
        }
    }

    public void setPaused(boolean z4) {
        this.f9784o = z4;
        if (!z4) {
            this.f9782m = System.currentTimeMillis();
        }
    }

    public void setProgress(float f5, boolean z4) {
        if (z4 && f5 >= 1.0f) {
            startEndAnimation();
        }
    }

    public void setProgressBarListener(c.a aVar) {
        this.f9785p = aVar;
    }

    public void setProgressState(int i5) {
        if (i5 == 5) {
            this.f9791v = 1;
            this.f9792w = 0;
            this.f9793x = 0;
            this.f9794y = 0;
        } else if (i5 == 6) {
            this.f9792w = 1;
            if (this.f9793x == 1) {
                startEndAnimation();
            }
            this.f9794y = 0;
        } else if (i5 == 7) {
            startEndAnimation();
        } else if (i5 == 8) {
            this.f9793x = 1;
            if (this.f9792w == 1) {
                startEndAnimation();
            }
        }
    }

    public void setVisibility(int i5) {
        super.setVisibility(i5);
        if (i5 == 0) {
            c.a aVar = this.f9785p;
            if (aVar != null) {
                aVar.a(true);
                return;
            }
            return;
        }
        c.a aVar2 = this.f9785p;
        if (aVar2 != null) {
            aVar2.a(false);
        }
    }

    public void setVisible(boolean z4) {
        if (z4) {
            this.f9781l = true;
            this.f9782m = System.currentTimeMillis();
            this.f9773d = 0.0f;
            this.f9794y = 0;
            this.f9790u = false;
            this.f9775f = 0.0f;
            this.f9771b = 0.0f;
            this.f9789t = (float) getMeasuredWidth();
            this.f9784o = false;
            this.f9791v = 0;
            this.f9792w = 0;
            this.f9793x = 0;
            Drawable drawable = this.f9778i;
            if (drawable != null) {
                this.f9779j = -drawable.getIntrinsicWidth();
            } else {
                this.f9779j = 0;
            }
            Drawable drawable2 = this.f9788s;
            if (drawable2 != null) {
                drawable2.setAlpha(255);
            }
            Drawable drawable3 = this.f9774e;
            if (drawable3 != null) {
                drawable3.setAlpha(255);
            }
            Drawable drawable4 = this.f9786q;
            if (drawable4 != null) {
                drawable4.setAlpha(255);
            }
            setVisibility(0);
            invalidate();
            return;
        }
        setVisibility(4);
    }

    public void startEndAnimation() {
        if (!this.f9790u) {
            this.f9790u = true;
            this.f9775f = 0.0f;
        }
    }

    public ProgressBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setWillNotDraw(false);
    }
}
