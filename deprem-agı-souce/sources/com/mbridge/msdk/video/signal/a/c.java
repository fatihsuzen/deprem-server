package com.mbridge.msdk.video.signal.a;

import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.tools.af;

public class c implements com.mbridge.msdk.video.signal.c {

    /* renamed from: a  reason: collision with root package name */
    private static final String f12650a = "c";

    public void click(int i5, String str) {
        af.a(f12650a, CampaignEx.JSON_NATIVE_VIDEO_CLICK);
    }

    public void handlerH5Exception(int i5, String str) {
        af.a(f12650a, "handlerH5Exception");
    }

    public void reactDeveloper(Object obj, String str) {
        af.a(f12650a, "reactDeveloper");
    }

    public void reportUrls(Object obj, String str) {
        af.a(f12650a, "reportUrls");
    }
}
