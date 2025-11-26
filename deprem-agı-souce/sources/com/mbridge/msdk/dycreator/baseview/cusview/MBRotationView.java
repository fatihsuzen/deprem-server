package com.mbridge.msdk.dycreator.baseview.cusview;

import android.content.Context;
import android.graphics.Camera;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;

public class MBRotationView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    Runnable f8436a = new Runnable() {
        public void run() {
            MBRotationView.a(MBRotationView.this);
        }
    };

    /* renamed from: b  reason: collision with root package name */
    private Camera f8437b;

    /* renamed from: c  reason: collision with root package name */
    private Matrix f8438c;

    /* renamed from: d  reason: collision with root package name */
    private int f8439d;

    /* renamed from: e  reason: collision with root package name */
    private int f8440e;

    /* renamed from: f  reason: collision with root package name */
    private int f8441f = 40;

    /* renamed from: g  reason: collision with root package name */
    private int f8442g = 20;

    /* renamed from: h  reason: collision with root package name */
    private int f8443h = 0;

    /* renamed from: i  reason: collision with root package name */
    private int f8444i = 0;

    /* renamed from: j  reason: collision with root package name */
    private int f8445j;

    /* renamed from: k  reason: collision with root package name */
    private int f8446k = 0;

    /* renamed from: l  reason: collision with root package name */
    private float f8447l = 0.5f;

    /* renamed from: m  reason: collision with root package name */
    private float f8448m = 0.9f;

    /* renamed from: n  reason: collision with root package name */
    private boolean f8449n = true;

    /* renamed from: o  reason: collision with root package name */
    private boolean f8450o = false;

    /* renamed from: p  reason: collision with root package name */
    private boolean f8451p = false;

    public MBRotationView(Context context) {
        super(context);
        a();
    }

    private void a() {
        this.f8437b = new Camera();
        this.f8438c = new Matrix();
        setWillNotDraw(false);
    }

    private void b(int i5, int i6, int i7) {
        if (i7 == 0) {
            float f5 = (float) ((-i5) / 2);
            this.f8437b.translate(f5, 0.0f, 0.0f);
            float f6 = (float) (-i6);
            this.f8437b.rotateY(f6);
            this.f8437b.translate(f5, 0.0f, 0.0f);
            this.f8437b.translate(f5, 0.0f, 0.0f);
            this.f8437b.rotateY(f6);
            this.f8437b.translate(f5, 0.0f, 0.0f);
        } else if (i7 == 1) {
            float f7 = (float) (i5 / 2);
            this.f8437b.translate(f7, 0.0f, 0.0f);
            this.f8437b.rotateY((float) i6);
            this.f8437b.translate(f7, 0.0f, 0.0f);
        } else if (i7 == 2) {
            float f8 = (float) ((-i5) / 2);
            this.f8437b.translate(f8, 0.0f, 0.0f);
            this.f8437b.rotateY((float) (-i6));
            this.f8437b.translate(f8, 0.0f, 0.0f);
        } else if (i7 == 3) {
            this.f8437b.rotateY(0.0f);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (getChildCount() != 0) {
            if (this.f8450o) {
                int height = getHeight() / 2;
                int i5 = ((this.f8443h * this.f8439d) / 2) / this.f8441f;
                a(canvas, i5, height, 0);
                a(canvas, i5, height, 1);
                if (Math.abs(this.f8443h) > this.f8441f / 2) {
                    a(canvas, i5, height, 3);
                    a(canvas, i5, height, 2);
                    return;
                }
                a(canvas, i5, height, 2);
                a(canvas, i5, height, 3);
                return;
            }
            int width = getWidth() / 2;
            int i6 = ((this.f8443h * this.f8440e) / 2) / this.f8441f;
            b(canvas, i6, width, 0);
            b(canvas, i6, width, 1);
            if (Math.abs(this.f8443h) > this.f8441f / 2) {
                b(canvas, i6, width, 3);
                b(canvas, i6, width, 2);
                return;
            }
            b(canvas, i6, width, 2);
            b(canvas, i6, width, 3);
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z4, int i5, int i6, int i7, int i8) {
        int i9 = i7 - i5;
        float f5 = (float) i9;
        float f6 = this.f8447l;
        int i10 = (int) (((1.0f - f6) * f5) / 2.0f);
        int i11 = i8 - i6;
        float f7 = (float) i11;
        float f8 = this.f8448m;
        int i12 = (int) (((1.0f - f8) * f7) / 2.0f);
        this.f8439d = (int) (f7 * f8);
        this.f8440e = (int) (f5 * f6);
        int childCount = getChildCount();
        for (int i13 = 0; i13 < childCount; i13++) {
            View childAt = getChildAt(i13);
            childAt.layout(i10, i12, i9 - i10, i11 - i12);
            childAt.setClickable(true);
            ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
            int i14 = layoutParams.width;
            int i15 = this.f8440e;
            if (i14 != i15) {
                layoutParams.width = i15;
                layoutParams.height = this.f8439d;
                childAt.setLayoutParams(layoutParams);
            }
        }
    }

    public void setAutoscroll(boolean z4) {
        if (z4) {
            postDelayed(this.f8436a, (long) (1000 / this.f8442g));
        }
        this.f8449n = z4;
    }

    public void setHeightRatio(float f5) {
        this.f8448m = f5;
    }

    public void setRotateV(boolean z4) {
        this.f8450o = z4;
        invalidate();
    }

    public void setWidthRatio(float f5) {
        this.f8447l = f5;
    }

    private void a(int i5, int i6, int i7) {
        float f5 = ((float) (-i5)) / 2.0f;
        if (i7 == 0) {
            this.f8437b.translate(0.0f, f5, 0.0f);
            float f6 = (float) (-i6);
            this.f8437b.rotateX(f6);
            this.f8437b.translate(0.0f, f5, 0.0f);
            this.f8437b.translate(0.0f, f5, 0.0f);
            this.f8437b.rotateX(f6);
            this.f8437b.translate(0.0f, f5, 0.0f);
        } else if (i7 == 1) {
            this.f8437b.translate(0.0f, f5, 0.0f);
            this.f8437b.rotateX((float) i6);
            this.f8437b.translate(0.0f, f5, 0.0f);
        } else if (i7 == 2) {
            this.f8437b.translate(0.0f, f5, 0.0f);
            this.f8437b.rotateX((float) (-i6));
            this.f8437b.translate(0.0f, f5, 0.0f);
        } else if (i7 == 3) {
            this.f8437b.rotateX(0.0f);
        }
    }

    public MBRotationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    private void b(Canvas canvas, int i5, int i6, int i7) {
        canvas.save();
        this.f8437b.save();
        this.f8438c.reset();
        float f5 = (float) i5;
        this.f8437b.translate(f5, 0.0f, 0.0f);
        this.f8437b.rotateY((float) this.f8443h);
        this.f8437b.translate(f5, 0.0f, 0.0f);
        if (i5 == 0) {
            if (this.f8451p) {
                b(this.f8440e, this.f8441f, i7);
            } else {
                b(-this.f8440e, -this.f8441f, i7);
            }
        } else if (i5 > 0) {
            b(this.f8440e, this.f8441f, i7);
        } else if (i5 < 0) {
            b(-this.f8440e, -this.f8441f, i7);
        }
        this.f8437b.getMatrix(this.f8438c);
        this.f8437b.restore();
        this.f8438c.preTranslate((float) (-i6), (float) ((-getHeight()) / 2));
        this.f8438c.postTranslate((float) i6, (float) (getHeight() / 2));
        canvas.concat(this.f8438c);
        View childAt = getChildAt(a(i7));
        if (childAt != null) {
            drawChild(canvas, childAt, 0);
        }
        canvas.restore();
    }

    private void a(Canvas canvas, int i5, int i6, int i7) {
        canvas.save();
        this.f8437b.save();
        this.f8438c.reset();
        float f5 = (float) i5;
        this.f8437b.translate(0.0f, f5, 0.0f);
        this.f8437b.rotateX((float) this.f8443h);
        this.f8437b.translate(0.0f, f5, 0.0f);
        if (i5 == 0) {
            if (this.f8451p) {
                a(this.f8439d, this.f8441f, i7);
            } else {
                a(-this.f8439d, -this.f8441f, i7);
            }
        } else if (i5 > 0) {
            a(this.f8439d, this.f8441f, i7);
        } else if (i5 < 0) {
            a(-this.f8439d, -this.f8441f, i7);
        }
        this.f8437b.getMatrix(this.f8438c);
        this.f8437b.restore();
        this.f8438c.preTranslate((float) ((-getWidth()) / 2), (float) (-i6));
        this.f8438c.postTranslate((float) (getWidth() / 2), (float) i6);
        canvas.concat(this.f8438c);
        View childAt = getChildAt(a(i7));
        if (childAt != null) {
            drawChild(canvas, childAt, 0);
        }
        canvas.restore();
    }

    public MBRotationView(Context context, AttributeSet attributeSet, int i5) {
        super(context, attributeSet, i5);
        a();
    }

    private int a(int i5) {
        int i6;
        int i7;
        int i8;
        if (i5 != 0) {
            if (i5 != 1) {
                if (i5 != 2) {
                    i6 = i5 != 3 ? 0 : this.f8444i;
                } else if (this.f8451p) {
                    i7 = this.f8444i;
                } else {
                    i8 = this.f8444i;
                    i6 = i8 + 1;
                }
            } else if (this.f8451p) {
                i8 = this.f8444i;
                i6 = i8 + 1;
            } else {
                i7 = this.f8444i;
            }
            i6 = i7 - 1;
        } else if (this.f8451p) {
            i6 = this.f8444i - 2;
        } else {
            i6 = this.f8444i + 2;
        }
        int childCount = i6 % getChildCount();
        if (childCount >= 0) {
            return childCount;
        }
        return childCount + getChildCount();
    }

    static /* synthetic */ void a(MBRotationView mBRotationView) {
        int i5;
        if (mBRotationView.getChildCount() != 0) {
            int i6 = mBRotationView.f8443h - 1;
            mBRotationView.f8443h = i6;
            int i7 = mBRotationView.f8444i;
            mBRotationView.f8445j = i7;
            int i8 = mBRotationView.f8441f;
            int i9 = i6 % i8;
            mBRotationView.f8443h = i9;
            mBRotationView.f8444i = i7 - (i6 / i8);
            if (Math.abs(i9) > mBRotationView.f8441f / 2) {
                i5 = mBRotationView.a(2);
            } else {
                i5 = mBRotationView.a(3);
            }
            if (mBRotationView.f8446k != i5) {
                mBRotationView.f8446k = i5;
            }
            mBRotationView.invalidate();
            if (mBRotationView.f8449n) {
                mBRotationView.postDelayed(mBRotationView.f8436a, (long) (1000 / mBRotationView.f8442g));
            }
        }
    }
}
