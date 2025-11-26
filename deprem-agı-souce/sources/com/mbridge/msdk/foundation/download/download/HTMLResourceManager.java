package com.mbridge.msdk.foundation.download.download;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.same.d;
import com.mbridge.msdk.foundation.same.e.a;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aq;
import java.io.File;

public class HTMLResourceManager {
    public static final int EXPIRE_TIME = 259200000;
    private static final String TAG = "HTMLResourceManager";
    /* access modifiers changed from: private */
    public String mFileSaveSDDir;

    private static class ResourceManagerHolder {
        public static HTMLResourceManager instance = new HTMLResourceManager();

        private ResourceManagerHolder() {
        }
    }

    public static HTMLResourceManager getInstance() {
        return ResourceManagerHolder.instance;
    }

    public void cleanHtmlRes() {
        try {
            if (!TextUtils.isEmpty(this.mFileSaveSDDir)) {
                DownloadTask.getInstance().runTask(new a() {
                    public void cancelTask() {
                    }

                    public void pauseTask(boolean z4) {
                    }

                    public void runTask() {
                        ad.a(HTMLResourceManager.this.mFileSaveSDDir);
                    }
                });
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }

    public String getHtmlContentFromUrl(String str) {
        try {
            String md5 = SameMD5.getMD5(aq.b(str));
            File file = new File(this.mFileSaveSDDir + "/" + md5 + ".html");
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

    public String getHtmlPathFromUrl(String str) {
        try {
            String str2 = this.mFileSaveSDDir + "/" + SameMD5.getMD5(aq.b(str)) + ".html";
            File file = new File(str2);
            if (!file.exists()) {
                return null;
            }
            g b5 = h.a().b(c.m().k());
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

    public void init() {
        this.mFileSaveSDDir = e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_HTML);
    }

    public boolean saveResHtmlFile(String str, byte[] bArr) {
        try {
            af.c(TAG, "saveResHtmlFile url:" + str);
            if (bArr == null || bArr.length <= 0) {
                return false;
            }
            String str2 = this.mFileSaveSDDir + "/" + SameMD5.getMD5(aq.b(str)) + ".html";
            af.c(TAG, "saveResHtmlFile folderName:" + str2);
            if (ad.a(bArr, new File(str2))) {
                return true;
            }
            return false;
        } catch (Exception e5) {
            if (!MBridgeConstans.DEBUG) {
                return false;
            }
            e5.printStackTrace();
            return false;
        }
    }

    private HTMLResourceManager() {
        init();
    }
}
