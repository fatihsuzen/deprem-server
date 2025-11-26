package com.mbridge.msdk.video.signal.activity;

import android.content.res.Configuration;
import com.mbridge.msdk.activity.MBBaseActivity;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.video.signal.b;
import com.mbridge.msdk.video.signal.c;
import com.mbridge.msdk.video.signal.d;
import com.mbridge.msdk.video.signal.f;
import com.mbridge.msdk.video.signal.factory.IJSFactory;
import com.mbridge.msdk.video.signal.factory.a;
import com.mbridge.msdk.video.signal.g;
import com.mbridge.msdk.video.signal.i;
import com.mbridge.msdk.video.signal.j;

public abstract class AbstractJSActivity extends MBBaseActivity implements IJSFactory {
    protected static final String TAG = "AbstractJSActivity";
    protected IJSFactory jsFactory = new a();

    public boolean canBackPress() {
        return false;
    }

    public b getActivityProxy() {
        return this.jsFactory.getActivityProxy();
    }

    public i getIJSRewardVideoV1() {
        return this.jsFactory.getIJSRewardVideoV1();
    }

    public c getJSBTModule() {
        return this.jsFactory.getJSBTModule();
    }

    public d getJSCommon() {
        return this.jsFactory.getJSCommon();
    }

    public f getJSContainerModule() {
        return this.jsFactory.getJSContainerModule();
    }

    public g getJSNotifyProxy() {
        return this.jsFactory.getJSNotifyProxy();
    }

    public j getJSVideoModule() {
        return this.jsFactory.getJSVideoModule();
    }

    public void onBackPressed() {
        if (getJSCommon().b()) {
            if (getJSContainerModule() == null || !getJSContainerModule().miniCardShowing()) {
                getActivityProxy().g();
            }
        } else if (canBackPress()) {
            super.onBackPressed();
        } else {
            af.a(TAG, "onBackPressed can't excute");
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getJSCommon().b()) {
            getActivityProxy().a(configuration);
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        if (getJSCommon().b()) {
            getActivityProxy().a();
        }
        getActivityProxy().a(1);
    }

    public void onResume() {
        super.onResume();
        if (!com.mbridge.msdk.foundation.d.b.f8931c) {
            if (getJSCommon().b()) {
                getActivityProxy().b();
            }
            getActivityProxy().a(0);
        }
    }

    public void registerJsFactory(IJSFactory iJSFactory) {
        this.jsFactory = iJSFactory;
    }
}
