package com.mbridge.msdk.foundation.download.download;

import android.net.Uri;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.same.d;
import com.mbridge.msdk.foundation.same.e.a;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.ac;
import com.mbridge.msdk.foundation.tools.ad;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.aq;
import java.io.File;
import java.util.List;

public class ResourceManager {
    public static final int EXPIRE_TIME = 259200000;
    public static final String KEY_INDEX_HTML = "foldername";
    public static final String KEY_MD5CHECK = "nc";
    public static final String KEY_MD5FILENAME = "md5filename";
    private static String TAG = "ResourceManager";
    /* access modifiers changed from: private */
    public String mFileSaveSDDir;

    private static class ResourceManagerHolder {
        public static ResourceManager instance = new ResourceManager();

        private ResourceManagerHolder() {
        }
    }

    public static ResourceManager getinstance() {
        return ResourceManagerHolder.instance;
    }

    private String save(String str, String str2, File file) {
        String b5 = ad.b(str2, this.mFileSaveSDDir + "/" + SameMD5.getMD5(aq.b(str)));
        if (TextUtils.isEmpty(b5)) {
            return ad.a(file);
        }
        return b5;
    }

    public void cleanZipRes() {
        try {
            if (!TextUtils.isEmpty(this.mFileSaveSDDir)) {
                DownloadTask.getInstance().runTask(new a() {
                    public void cancelTask() {
                    }

                    public void pauseTask(boolean z4) {
                    }

                    public void runTask() {
                        ad.a(ResourceManager.this.mFileSaveSDDir);
                    }
                });
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }

    public String getResDirFromCampaign(String str) {
        String str2;
        String str3 = "";
        try {
            String str4 = this.mFileSaveSDDir + "/" + SameMD5.getMD5(aq.b(str));
            List<String> queryParameters = Uri.parse(str).getQueryParameters(KEY_INDEX_HTML);
            af.a(TAG, "check zip 下载情况：url:" + str);
            af.a(TAG, "check zip 下载情况：indexHtml:" + queryParameters);
            if (queryParameters == null || queryParameters.size() <= 0) {
                return null;
            }
            String str5 = queryParameters.get(0);
            if (TextUtils.isEmpty(str5)) {
                return null;
            }
            String str6 = str4 + "/" + str5 + "/" + str5 + ".html";
            if (!ad.d(str6)) {
                return null;
            }
            g b5 = h.a().b(c.m().k());
            if (b5 != null && !TextUtils.isEmpty(b5.W())) {
                d.a(str, new File(str6));
            }
            try {
                str2 = str.substring(str.indexOf("?") + 1);
            } catch (Exception unused) {
                str2 = str3;
            }
            if (!TextUtils.isEmpty(str2)) {
                str3 = "?" + str2;
            }
            return "file://" + str6 + str3;
        } catch (Exception e5) {
            if (!MBridgeConstans.DEBUG) {
                return null;
            }
            e5.printStackTrace();
            return null;
        }
    }

    public void init() {
        this.mFileSaveSDDir = e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_RES);
    }

    public synchronized String saveResFile(String str, byte[] bArr) {
        String str2;
        String str3 = "unknow exception ";
        if (bArr != null) {
            try {
                if (bArr.length > 0) {
                    String str4 = this.mFileSaveSDDir + "/" + SameMD5.getMD5(aq.b(str)) + ".zip";
                    File file = new File(str4);
                    if (ad.a(bArr, file)) {
                        Uri parse = Uri.parse(str);
                        List<String> queryParameters = parse.getQueryParameters(KEY_MD5CHECK);
                        if (queryParameters != null) {
                            if (queryParameters.size() != 0) {
                                str3 = save(str, str4, file);
                            }
                        }
                        List<String> queryParameters2 = parse.getQueryParameters(KEY_MD5FILENAME);
                        if (queryParameters2 != null && queryParameters2.size() > 0) {
                            String str5 = queryParameters2.get(0);
                            if (!TextUtils.isEmpty(str5) && str5.equals(ac.a(file))) {
                                str3 = save(str, str4, file);
                            }
                        }
                    }
                    if (!TextUtils.isEmpty(str3)) {
                        ad.a(file);
                    }
                }
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    e5.printStackTrace();
                }
                str2 = e5.getMessage();
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        str2 = str3;
        return str2;
    }

    private ResourceManager() {
        init();
    }
}
