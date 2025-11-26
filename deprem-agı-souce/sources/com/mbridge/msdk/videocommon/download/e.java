package com.mbridge.msdk.videocommon.download;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.d;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.aq;
import java.io.File;

public final class e {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f13153a;

    /* renamed from: com.mbridge.msdk.videocommon.download.e$1  reason: invalid class name */
    class AnonymousClass1 extends com.mbridge.msdk.foundation.same.e.a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ e f13154a;

        public final void cancelTask() {
        }

        public final void pauseTask(boolean z4) {
        }

        public final void runTask() {
            ad.a(this.f13154a.f13153a);
        }
    }

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        public static e f13155a = new e((AnonymousClass1) null);
    }

    /* synthetic */ e(AnonymousClass1 r12) {
        this();
    }

    public final String b(String str) {
        try {
            String md5 = SameMD5.getMD5(aq.b(str));
            File file = new File(this.f13153a + "/" + md5 + ".html");
            if (file.exists()) {
                return ad.b(file);
            }
            return null;
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }

    private e() {
        this.f13153a = com.mbridge.msdk.foundation.same.b.e.a(c.MBRIDGE_700_HTML);
    }

    public static e a() {
        return a.f13155a;
    }

    public final String a(String str) {
        try {
            String str2 = this.f13153a + "/" + SameMD5.getMD5(aq.b(str)) + ".html";
            File file = new File(str2);
            if (!file.exists()) {
                return null;
            }
            g b5 = h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
            if (b5 != null && !TextUtils.isEmpty(b5.W())) {
                d.a(str, file);
            }
            return "file:////" + str2;
        } catch (Throwable th) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            th.printStackTrace();
            return null;
        }
    }
}
