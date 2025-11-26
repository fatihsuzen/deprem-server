package com.mbridge.msdk.video.bt.module.b;

import com.mbridge.msdk.foundation.same.report.d.c;
import com.mbridge.msdk.foundation.tools.af;

public class b implements h {

    /* renamed from: b  reason: collision with root package name */
    public boolean f12013b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f12014c = false;

    public void a(c cVar) {
        af.a("ShowRewardListener", "onAdShow");
        this.f12013b = true;
    }

    public void b(String str, String str2) {
        af.a("ShowRewardListener", "onEndcardShow: " + str2);
    }

    public void a(c cVar, boolean z4, com.mbridge.msdk.videocommon.b.c cVar2) {
        af.a("ShowRewardListener", "onAdClose:isCompleteView:" + z4 + ",reward:" + cVar2);
    }

    public void a(c cVar, String str) {
        af.a("ShowRewardListener", "onShowFail:" + str);
        this.f12014c = true;
    }

    public void a(boolean z4, String str, String str2) {
        af.a("ShowRewardListener", "onVideoAdClicked:" + str2);
    }

    public void a(String str, String str2) {
        af.a("ShowRewardListener", "onVideoComplete: " + str2);
    }

    public void a(boolean z4, int i5) {
        af.a("ShowRewardListener", "onAdCloseWithIVReward: " + z4 + "  " + i5);
    }

    public void a(int i5, String str, String str2) {
        af.a("ShowRewardListener", "onAutoLoad: " + str2);
    }
}
