package com.mbridge.msdk.activity;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.DisplayCutout;
import android.view.OrientationEventListener;
import android.view.WindowInsets;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.mbridge.msdk.foundation.d.b;
import com.mbridge.msdk.foundation.tools.af;

public abstract class MBBaseActivity extends Activity {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Display f7858a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public OrientationEventListener f7859b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public int f7860c = -1;

    static /* synthetic */ void e(MBBaseActivity mBBaseActivity) {
        AnonymousClass2 r02 = new OrientationEventListener(mBBaseActivity, 1) {
            public final void onOrientationChanged(int i5) {
                int i6;
                if (MBBaseActivity.this.f7858a != null) {
                    i6 = MBBaseActivity.this.f7858a.getRotation();
                } else {
                    i6 = 0;
                }
                if (i6 == 1 && MBBaseActivity.this.f7860c != 1) {
                    int unused = MBBaseActivity.this.f7860c = 1;
                    MBBaseActivity.this.getNotchParams();
                    af.b("MBBaseActivity", "Orientation Left");
                } else if (i6 == 3 && MBBaseActivity.this.f7860c != 2) {
                    int unused2 = MBBaseActivity.this.f7860c = 2;
                    MBBaseActivity.this.getNotchParams();
                    af.b("MBBaseActivity", "Orientation Right");
                } else if (i6 == 0 && MBBaseActivity.this.f7860c != 3) {
                    int unused3 = MBBaseActivity.this.f7860c = 3;
                    MBBaseActivity.this.getNotchParams();
                    af.b("MBBaseActivity", "Orientation Top");
                } else if (i6 == 2 && MBBaseActivity.this.f7860c != 4) {
                    int unused4 = MBBaseActivity.this.f7860c = 4;
                    MBBaseActivity.this.getNotchParams();
                    af.b("MBBaseActivity", "Orientation Bottom");
                }
            }
        };
        mBBaseActivity.f7859b = r02;
        if (r02.canDetectOrientation()) {
            mBBaseActivity.f7859b.enable();
            return;
        }
        mBBaseActivity.f7859b.disable();
        mBBaseActivity.f7859b = null;
    }

    public void getNotchParams() {
        getWindow().getDecorView().postDelayed(new Runnable() {
            public final void run() {
                int i5;
                int i6;
                int i7;
                DisplayCutout a5;
                int i8;
                int i9;
                try {
                    int i10 = Build.VERSION.SDK_INT;
                    WindowInsets rootWindowInsets = MBBaseActivity.this.getWindow().getDecorView().getRootWindowInsets();
                    int i11 = -1;
                    int i12 = 0;
                    if (rootWindowInsets == null || i10 < 28 || (a5 = rootWindowInsets.getDisplayCutout()) == null) {
                        i7 = 0;
                        i6 = 0;
                        i5 = 0;
                    } else {
                        int a6 = a5.getSafeInsetLeft();
                        i7 = a5.getSafeInsetRight();
                        i6 = a5.getSafeInsetTop();
                        int a7 = a5.getSafeInsetBottom();
                        af.b("MBBaseActivity", "NOTCH Left:" + a6 + " Right:" + i7 + " Top:" + i6 + " Bottom:" + a7);
                        if (MBBaseActivity.this.f7858a != null) {
                            i8 = MBBaseActivity.this.f7858a.getRotation();
                        } else {
                            i8 = MBBaseActivity.this.b();
                        }
                        if (MBBaseActivity.this.f7860c == -1) {
                            MBBaseActivity mBBaseActivity = MBBaseActivity.this;
                            if (i8 == 0) {
                                i9 = 3;
                            } else if (i8 == 1) {
                                i9 = 1;
                            } else if (i8 == 2) {
                                i9 = 4;
                            } else if (i8 == 3) {
                                i9 = 2;
                            } else {
                                i9 = -1;
                            }
                            int unused = mBBaseActivity.f7860c = i9;
                            af.b("MBBaseActivity", MBBaseActivity.this.f7860c + "");
                        }
                        if (i8 != 0) {
                            if (i8 == 1) {
                                i11 = 90;
                            } else if (i8 == 2) {
                                i11 = SubsamplingScaleImageView.ORIENTATION_180;
                            } else if (i8 == 3) {
                                i11 = SubsamplingScaleImageView.ORIENTATION_270;
                            }
                            i5 = a7;
                        } else {
                            i5 = a7;
                            i11 = 0;
                        }
                        i12 = a6;
                    }
                    MBBaseActivity.this.setTopControllerPadding(i11, i12, i7, i6, i5);
                    if (MBBaseActivity.this.f7859b == null) {
                        MBBaseActivity.e(MBBaseActivity.this);
                    }
                } catch (Exception e5) {
                    af.b("MBBaseActivity", e5.getMessage());
                }
            }
        }, 500);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        try {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            getWindow().addFlags(512);
            a();
            b();
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            }
        } catch (Exception e5) {
            af.b("MBBaseActivity", e5.getMessage());
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        OrientationEventListener orientationEventListener = this.f7859b;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
            this.f7859b = null;
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!b.f8931c) {
            getNotchParams();
            a();
        }
    }

    public void onWindowFocusChanged(boolean z4) {
        super.onWindowFocusChanged(z4);
        a();
    }

    public abstract void setTopControllerPadding(int i5, int i6, int i7, int i8, int i9);

    /* access modifiers changed from: private */
    public int b() {
        if (this.f7858a == null) {
            if (Build.VERSION.SDK_INT >= 30) {
                this.f7858a = getDisplay();
            } else {
                this.f7858a = ((WindowManager) getSystemService("window")).getDefaultDisplay();
            }
        }
        Display display = this.f7858a;
        if (display != null) {
            return display.getRotation();
        }
        return -1;
    }

    private void a() {
        try {
            getWindow().addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
            getWindow().getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
        } catch (Throwable th) {
            af.b("MBBaseActivity", th.getMessage());
        }
    }
}
