package com.mbridge.msdk.newreward.player;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import androidx.core.view.accessibility.AccessibilityEventCompat;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.player.presenter.ActivityPresenter;

public class BaseActivity extends Activity {
    private final String TAG = "BaseActivity";
    ActivityPresenter activityPresenter;

    private void hideNavigationBar() {
        try {
            getWindow().addFlags(AccessibilityEventCompat.TYPE_VIEW_TARGETED_BY_SCROLL);
            getWindow().getDecorView().setSystemUiVisibility(InputDeviceCompat.SOURCE_TOUCHSCREEN);
        } catch (Throwable th) {
            af.b("BaseActivity", th.getMessage());
        }
    }

    private void setActivityFull() {
        try {
            requestWindowFeature(1);
            getWindow().setFlags(1024, 1024);
            getWindow().addFlags(512);
            hideNavigationBar();
            if (Build.VERSION.SDK_INT >= 28) {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();
                attributes.layoutInDisplayCutoutMode = 1;
                getWindow().setAttributes(attributes);
            }
        } catch (Exception e5) {
            af.b("BaseActivity", e5.getMessage());
        }
    }

    private void updateScreenSize(boolean z4) {
        if (z4) {
            int i5 = getResources().getDisplayMetrics().widthPixels;
        }
    }

    public void onBackPressed() {
        ActivityPresenter activityPresenter2 = this.activityPresenter;
        if (activityPresenter2 != null) {
            activityPresenter2.bindMethodName("onBackPressed");
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(@Nullable Bundle bundle) {
        super.onCreate(bundle);
        setActivityFull();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        ActivityPresenter activityPresenter2 = this.activityPresenter;
        if (activityPresenter2 != null) {
            activityPresenter2.bindMethodName("onDestroy");
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        ActivityPresenter activityPresenter2 = this.activityPresenter;
        if (activityPresenter2 != null) {
            activityPresenter2.bindMethodName("onPause");
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        ActivityPresenter activityPresenter2 = this.activityPresenter;
        if (activityPresenter2 != null) {
            activityPresenter2.bindMethodName("onResume");
            c.m().a((Context) this);
            hideNavigationBar();
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        ActivityPresenter activityPresenter2 = this.activityPresenter;
        if (activityPresenter2 != null) {
            activityPresenter2.bindMethodName("onStart");
        }
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        ActivityPresenter activityPresenter2 = this.activityPresenter;
        if (activityPresenter2 != null) {
            activityPresenter2.bindMethodName("onStop");
        }
    }

    public void onWindowFocusChanged(boolean z4) {
        super.onWindowFocusChanged(z4);
        hideNavigationBar();
        updateScreenSize(z4);
    }
}
