package com.mbridge.msdk.video.bt.module.b;

import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.video.bt.module.a.b;

public final class c extends b {

    /* renamed from: a  reason: collision with root package name */
    private b f12015a;

    /* renamed from: d  reason: collision with root package name */
    private String f12016d;

    public c(b bVar, String str) {
        this.f12015a = bVar;
        this.f12016d = str;
    }

    public final void a(com.mbridge.msdk.foundation.same.report.d.c cVar) {
        if (this.f12015a != null) {
            af.a("H5ShowRewardListener", "onAdShow");
            this.f12015a.a(this.f12016d);
        }
    }

    public final void b(String str, String str2) {
        if (this.f12015a != null) {
            af.a("H5ShowRewardListener", "onEndcardShow");
            this.f12015a.c(this.f12016d, str, str2);
        }
    }

    public final void a(com.mbridge.msdk.foundation.same.report.d.c cVar, boolean z4, com.mbridge.msdk.videocommon.b.c cVar2) {
        if (this.f12015a != null) {
            af.a("H5ShowRewardListener", "onAdClose");
            this.f12015a.a(this.f12016d, z4, cVar2);
        }
    }

    public final void a(com.mbridge.msdk.foundation.same.report.d.c cVar, String str) {
        if (this.f12015a != null) {
            af.a("H5ShowRewardListener", "onShowFail");
            this.f12015a.a(this.f12016d, str);
        }
    }

    public final void a(boolean z4, String str, String str2) {
        if (this.f12015a != null) {
            af.a("H5ShowRewardListener", "onVideoAdClicked");
            this.f12015a.a(this.f12016d, str, str2);
        }
    }

    public final void a(String str, String str2) {
        if (this.f12015a != null) {
            af.a("H5ShowRewardListener", "onVideoComplete");
            this.f12015a.b(this.f12016d, str, str2);
        }
    }

    public final void a(int i5, String str, String str2) {
        if (this.f12015a != null) {
            af.a("H5ShowRewardListener", "onAutoLoad");
            this.f12015a.a(this.f12016d, i5, str, str2);
        }
    }
}
