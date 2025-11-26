package com.mbridge.msdk.video.signal.a;

import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.video.module.MBridgeVideoView;
import com.mbridge.msdk.video.signal.g;

public class f implements g {
    public void a(int i5) {
        af.a("DefaultJSNotifyProxy", "onVideoStatusNotify:" + i5);
    }

    public void a(int i5, String str) {
        af.a("DefaultJSNotifyProxy", "onClick:" + i5 + ",pt:" + str);
    }

    public void a(MBridgeVideoView.b bVar) {
        af.a("DefaultJSNotifyProxy", "onProgressNotify:" + bVar.toString());
    }

    public void a(Object obj) {
        af.a("DefaultJSNotifyProxy", "onWebviewShow:" + obj);
    }

    public void a(int i5, int i6, int i7, int i8) {
        af.a("DefaultJSNotifyProxy", "showDataInfo");
    }
}
