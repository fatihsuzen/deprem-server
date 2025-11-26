package com.mbridge.msdk.mbsignalcommon.communication;

import android.content.Context;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.mbsignalcommon.windvane.WindVaneWebView;

public abstract class BaseBannerSignalPlugin extends BannerSignalPluginDiff {

    /* renamed from: a  reason: collision with root package name */
    public e f10160a;

    /* renamed from: e  reason: collision with root package name */
    private final String f10161e = "BannerSignalPlugin";

    public void click(Object obj, String str) {
        try {
            af.b("BannerSignalPlugin", CampaignEx.JSON_NATIVE_VIDEO_CLICK);
            e eVar = this.f10160a;
            if (eVar != null) {
                eVar.b(obj, str);
            }
        } catch (Throwable th) {
            af.b("BannerSignalPlugin", CampaignEx.JSON_NATIVE_VIDEO_CLICK, th);
        }
    }

    public void getFileInfo(Object obj, String str) {
        try {
            af.b("BannerSignalPlugin", "getFileInfo");
            e eVar = this.f10160a;
            if (eVar != null) {
                eVar.j(obj, str);
            }
        } catch (Throwable th) {
            af.b("BannerSignalPlugin", "getFileInfo", th);
        }
    }

    public void getNetstat(Object obj, String str) {
        try {
            af.b("BannerSignalPlugin", "getNetstat");
            e eVar = this.f10160a;
            if (eVar != null) {
                eVar.o(obj, str);
            }
        } catch (Throwable th) {
            af.b("BannerSignalPlugin", "getNetstat", th);
        }
    }

    public void handlerH5Exception(Object obj, String str) {
        try {
            af.b("BannerSignalPlugin", "handlerH5Exception");
            e eVar = this.f10160a;
            if (eVar != null) {
                eVar.m(obj, str);
            }
        } catch (Throwable th) {
            af.b("BannerSignalPlugin", "handlerH5Exception", th);
        }
    }

    public void increaseOfferFrequence(Object obj, String str) {
        try {
            af.b("BannerSignalPlugin", "increaseOfferFrequence");
            e eVar = this.f10160a;
            if (eVar != null) {
                eVar.l(obj, str);
            }
        } catch (Throwable th) {
            af.b("BannerSignalPlugin", "increaseOfferFrequence", th);
        }
    }

    public void init(Object obj, String str) {
        try {
            af.b("BannerSignalPlugin", "init");
            e eVar = this.f10160a;
            if (eVar != null) {
                eVar.a(obj, str);
            }
        } catch (Throwable th) {
            af.b("BannerSignalPlugin", "init", th);
        }
    }

    public void initialize(Context context, WindVaneWebView windVaneWebView) {
        super.initialize(context, windVaneWebView);
        try {
            if (context instanceof e) {
                this.f10160a = (e) context;
            } else if (windVaneWebView.getObject() != null && (windVaneWebView.getObject() instanceof e)) {
                this.f10160a = (e) windVaneWebView.getObject();
            }
        } catch (Throwable th) {
            af.b("BannerSignalPlugin", "initialize", th);
        }
    }

    public void install(Object obj, String str) {
        try {
            af.b("BannerSignalPlugin", "install");
            e eVar = this.f10160a;
            if (eVar != null) {
                eVar.g(obj, str);
            }
        } catch (Throwable th) {
            af.b("BannerSignalPlugin", "install", th);
        }
    }

    public void onSignalCommunication(Object obj, String str) {
        try {
            af.b("BannerSignalPlugin", "onSignalCommunication");
            e eVar = this.f10160a;
            if (eVar != null) {
                eVar.f(obj, str);
            }
        } catch (Throwable th) {
            af.b("BannerSignalPlugin", "onSignalCommunication", th);
        }
    }

    public void openURL(Object obj, String str) {
        try {
            af.b("BannerSignalPlugin", "openURL");
            e eVar = this.f10160a;
            if (eVar != null) {
                eVar.n(obj, str);
            }
        } catch (Throwable th) {
            af.b("BannerSignalPlugin", "openURL", th);
        }
    }

    public void readyStatus(Object obj, String str) {
        try {
            af.b("BannerSignalPlugin", "readyStatus");
            e eVar = this.f10160a;
            if (eVar != null) {
                eVar.c(obj, str);
            }
        } catch (Throwable th) {
            af.b("BannerSignalPlugin", "readyStatus", th);
        }
    }

    public void reportUrls(Object obj, String str) {
        try {
            af.b("BannerSignalPlugin", "reportUrls");
            e eVar = this.f10160a;
            if (eVar != null) {
                eVar.k(obj, str);
            }
        } catch (Throwable th) {
            af.b("BannerSignalPlugin", "reportUrls", th);
        }
    }

    public void resetCountdown(Object obj, String str) {
        try {
            af.b("BannerSignalPlugin", "resetCountdown");
            e eVar = this.f10160a;
            if (eVar != null) {
                eVar.h(obj, str);
            }
        } catch (Throwable th) {
            af.b("BannerSignalPlugin", "resetCountdown", th);
        }
    }

    public void sendImpressions(Object obj, String str) {
        try {
            af.b("BannerSignalPlugin", "sendImpressions");
            e eVar = this.f10160a;
            if (eVar != null) {
                eVar.i(obj, str);
            }
        } catch (Throwable th) {
            af.b("BannerSignalPlugin", "sendImpressions", th);
        }
    }

    public void toggleCloseBtn(Object obj, String str) {
        try {
            af.b("BannerSignalPlugin", "toggleCloseBtn");
            e eVar = this.f10160a;
            if (eVar != null) {
                eVar.d(obj, str);
            }
        } catch (Throwable th) {
            af.b("BannerSignalPlugin", "toggleCloseBtn", th);
        }
    }

    public void triggerCloseBtn(Object obj, String str) {
        try {
            af.b("BannerSignalPlugin", "triggerCloseBtn");
            e eVar = this.f10160a;
            if (eVar != null) {
                eVar.e(obj, str);
            }
        } catch (Throwable th) {
            af.b("BannerSignalPlugin", "triggerCloseBtn", th);
        }
    }
}
