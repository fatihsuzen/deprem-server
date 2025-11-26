package com.mbridge.msdk.foundation.download.download;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Patterns;
import android.webkit.URLUtil;
import androidx.work.WorkRequest;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.h;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadResourceType;
import com.mbridge.msdk.foundation.download.MBDownloadManager;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.resource.MBResourceManager;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.same.e.a;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.same.report.d.e;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.an;
import com.mbridge.msdk.foundation.tools.ap;
import com.mbridge.msdk.foundation.tools.aq;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import j$.util.concurrent.ConcurrentHashMap;
import java.io.IOException;
import java.net.URL;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class H5DownLoadManager {
    public static final String SP_ENDING_PAGE_SAVE_TIME = "ending_page_save_time";
    public static final String SP_ENDING_PAGE_SOURCE = "ending_page_source";
    private static final String TAG = "H5DownLoadManager";
    private static volatile H5DownLoadManager sH5Manager;
    private final String DOWN_TYPE = "down_type";
    private final String LOCAL_RID = CampaignEx.JSON_KEY_LOCAL_REQUEST_ID;
    /* access modifiers changed from: private */
    public HTMLResourceManager htmlResourceManager;
    private boolean isUseDownloadModule = false;
    /* access modifiers changed from: private */
    public CopyOnWriteArrayList<String> mResDownloadingList;
    private ConcurrentMap<String, DownLoadH5SourceListener> mResDownloadingMap;
    private ResourceManager resourceManager;

    public interface H5ResDownloadListerInter {
        void onFailed(String str, String str2);

        void onSuccess(String str, String str2, boolean z4);
    }

    public interface IH5SourceDownloadListener extends H5ResDownloadListerInter {
    }

    public interface IOnDownLoadH5Source {
        void onFailed(String str);

        void onStart();

        void onSuccess(String str, byte[] bArr, String str2);
    }

    public interface ZipDownloadListener extends H5ResDownloadListerInter {
    }

    private H5DownLoadManager() {
        try {
            this.resourceManager = ResourceManager.getinstance();
            this.htmlResourceManager = HTMLResourceManager.getInstance();
            this.mResDownloadingList = new CopyOnWriteArrayList<>();
            this.mResDownloadingMap = new ConcurrentHashMap();
            g b5 = h.a().b(c.m().k());
            if (b5 != null) {
                this.isUseDownloadModule = b5.z(1);
            }
        } catch (Throwable th) {
            af.b(TAG, th.getMessage(), th);
        }
    }

    private void downloadHTML(com.mbridge.msdk.foundation.same.report.d.c cVar, String str, H5ResDownloadListerInter h5ResDownloadListerInter) {
        try {
            af.b(TAG, "download url:" + str);
            final e eVar = new e();
            eVar.a("scenes", "1");
            eVar.a("url", str);
            if (cVar != null) {
                eVar.a("resource_type", Integer.valueOf(cVar.b()));
            }
            if (!this.mResDownloadingList.contains(str)) {
                this.mResDownloadingList.add(str);
                final com.mbridge.msdk.foundation.same.report.d.c cVar2 = cVar;
                final String str2 = str;
                final H5ResDownloadListerInter h5ResDownloadListerInter2 = h5ResDownloadListerInter;
                DownloadTask.getInstance().runTask(new a() {
                    public void cancelTask() {
                    }

                    public void pauseTask(boolean z4) {
                    }

                    public void runTask() {
                        if (!TextUtils.isEmpty(H5DownLoadManager.this.htmlResourceManager.getHtmlContentFromUrl(str2))) {
                            eVar.a("cache", 2);
                            H5DownLoadManager.this.mResDownloadingList.remove(str2);
                            H5ResDownloadListerInter h5ResDownloadListerInter = h5ResDownloadListerInter2;
                            if (h5ResDownloadListerInter != null) {
                                h5ResDownloadListerInter.onSuccess(str2, "", true);
                            }
                            cVar2.a("m_download_start", eVar);
                            d.a().a("m_download_start", cVar2, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
                            return;
                        }
                        DownLoadUtils.getSourceCodeFromNetUrl(str2, new IOnDownLoadH5Source() {
                            public void onFailed(String str) {
                                try {
                                    H5DownLoadManager.this.mResDownloadingList.remove(str2);
                                    AnonymousClass2 r02 = AnonymousClass2.this;
                                    H5ResDownloadListerInter h5ResDownloadListerInter = h5ResDownloadListerInter2;
                                    if (h5ResDownloadListerInter != null) {
                                        h5ResDownloadListerInter.onFailed(str2, str);
                                    }
                                } catch (Exception e5) {
                                    if (MBridgeConstans.DEBUG) {
                                        e5.printStackTrace();
                                    }
                                    AnonymousClass2 r03 = AnonymousClass2.this;
                                    H5ResDownloadListerInter h5ResDownloadListerInter2 = h5ResDownloadListerInter2;
                                    if (h5ResDownloadListerInter2 != null) {
                                        h5ResDownloadListerInter2.onFailed(str2, str);
                                    }
                                }
                                AnonymousClass2 r42 = AnonymousClass2.this;
                                if (h5ResDownloadListerInter2 == null) {
                                    eVar.a("result", 3);
                                    AnonymousClass2 r43 = AnonymousClass2.this;
                                    cVar2.a("m_download_end", eVar);
                                    d.a().a("m_download_end", cVar2, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
                                }
                            }

                            public void onStart() {
                            }

                            public void onSuccess(String str, byte[] bArr, String str2) {
                                try {
                                    H5DownLoadManager.this.mResDownloadingList.remove(str2);
                                    if (bArr != null && bArr.length > 0) {
                                        if (H5DownLoadManager.this.htmlResourceManager.saveResHtmlFile(str2, bArr)) {
                                            AnonymousClass2 r7 = AnonymousClass2.this;
                                            H5ResDownloadListerInter h5ResDownloadListerInter = h5ResDownloadListerInter2;
                                            if (h5ResDownloadListerInter != null) {
                                                h5ResDownloadListerInter.onSuccess(str2, "", false);
                                                return;
                                            }
                                            eVar.a("result", 3);
                                            AnonymousClass2 r72 = AnonymousClass2.this;
                                            cVar2.a("m_download_end", eVar);
                                            d.a().a("m_download_end", cVar2, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
                                            return;
                                        }
                                        AnonymousClass2 r73 = AnonymousClass2.this;
                                        H5ResDownloadListerInter h5ResDownloadListerInter2 = h5ResDownloadListerInter2;
                                        if (h5ResDownloadListerInter2 != null) {
                                            h5ResDownloadListerInter2.onFailed(str2, "save file failed");
                                            return;
                                        }
                                        eVar.a("result", 3);
                                        AnonymousClass2 r74 = AnonymousClass2.this;
                                        cVar2.a("m_download_end", eVar);
                                        d.a().a("m_download_end", cVar2, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
                                    }
                                } catch (Exception e5) {
                                    if (MBridgeConstans.DEBUG) {
                                        e5.printStackTrace();
                                    }
                                    AnonymousClass2 r32 = AnonymousClass2.this;
                                    H5ResDownloadListerInter h5ResDownloadListerInter3 = h5ResDownloadListerInter2;
                                    if (h5ResDownloadListerInter3 != null) {
                                        h5ResDownloadListerInter3.onFailed(str2, e5.getMessage());
                                        return;
                                    }
                                    eVar.a("result", 3);
                                    AnonymousClass2 r6 = AnonymousClass2.this;
                                    cVar2.a("m_download_end", eVar);
                                    d.a().a("m_download_end", cVar2, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
                                }
                            }
                        }, true);
                        eVar.a("cache", 1);
                        cVar2.a("m_download_start", eVar);
                        d.a().a("m_download_start", cVar2, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
                    }
                });
            }
        } catch (Throwable th) {
            Throwable th2 = th;
            if (MBridgeConstans.DEBUG) {
                th2.printStackTrace();
            }
        }
    }

    private void downloadHTMLByDownloadModule(String str, final H5ResDownloadListerInter h5ResDownloadListerInter) {
        if (!TextUtils.isEmpty(str)) {
            try {
                new URL(str);
                String md5 = SameMD5.getMD5(aq.b(str));
                final String str2 = str;
                MBDownloadManager.getInstance().download(new DownloadMessage(new Object(), str2, md5 + ".html", 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_HTML)).withTimeout(ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS).withReadTimeout(WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS).withConnectTimeout(20000).withDownloadPriority(DownloadPriority.HIGH).withHttpRetryCounter(1).withDirectoryPathInternal(com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_HTML) + "/").withDownloadStateListener(new OnDownloadStateListener() {
                    public void onCancelDownload(DownloadMessage downloadMessage) {
                        af.a(H5DownLoadManager.TAG, "下载取消： ");
                        H5ResDownloadListerInter h5ResDownloadListerInter = h5ResDownloadListerInter;
                        if (h5ResDownloadListerInter != null) {
                            h5ResDownloadListerInter.onFailed(str2, "task cancel");
                        }
                    }

                    public void onDownloadComplete(DownloadMessage downloadMessage) {
                        af.a(H5DownLoadManager.TAG, "下载结束： " + downloadMessage.getDownloadUrl() + " " + downloadMessage.getDownloadResourceType() + " " + downloadMessage.getSaveFilePath());
                        H5ResDownloadListerInter h5ResDownloadListerInter = h5ResDownloadListerInter;
                        if (h5ResDownloadListerInter != null) {
                            h5ResDownloadListerInter.onSuccess(str2, "", false);
                        }
                    }

                    public void onDownloadError(DownloadMessage downloadMessage, DownloadError downloadError) {
                        af.a(H5DownLoadManager.TAG, "下载结束失败： " + downloadError.getException().getMessage());
                        H5ResDownloadListerInter h5ResDownloadListerInter = h5ResDownloadListerInter;
                        if (h5ResDownloadListerInter != null) {
                            h5ResDownloadListerInter.onFailed(str2, downloadError.getException().getMessage());
                        }
                    }

                    public void onDownloadStart(DownloadMessage downloadMessage) {
                        af.a(H5DownLoadManager.TAG, "开始下载 html： " + downloadMessage.getDownloadUrl() + " " + downloadMessage.getDownloadResourceType());
                    }
                }).build().start();
            } catch (Exception unused) {
                String str3 = str;
                if (h5ResDownloadListerInter != null) {
                    h5ResDownloadListerInter.onFailed("zip url is unlawful", str3);
                }
            }
        } else if (h5ResDownloadListerInter != null) {
            h5ResDownloadListerInter.onFailed("zip url is null", str);
        }
    }

    private void downloadZipByDownloadModule(com.mbridge.msdk.foundation.same.report.d.c cVar, String str, ZipDownloadListener zipDownloadListener) {
        if (!TextUtils.isEmpty(str)) {
            try {
                new URL(str);
                final e eVar = new e();
                eVar.a("scenes", "1");
                eVar.a("url", str);
                if (cVar != null) {
                    eVar.a("resource_type", Integer.valueOf(cVar.b()));
                }
                String a5 = com.mbridge.msdk.foundation.same.b.e.a(com.mbridge.msdk.foundation.same.b.c.MBRIDGE_700_RES);
                String md5 = SameMD5.getMD5(aq.b(str));
                String str2 = a5 + "/";
                final String str3 = a5 + "/" + md5;
                com.mbridge.msdk.foundation.same.report.d.c cVar2 = cVar;
                DownloadMessage downloadMessage = new DownloadMessage(cVar2, str, md5 + ".zip", 100, DownloadResourceType.DOWNLOAD_RESOURCE_TYPE_ZIP);
                final com.mbridge.msdk.foundation.same.report.d.c cVar3 = cVar2;
                if (cVar3 != null) {
                    downloadMessage.setUseCronetDownload(cVar3.n());
                }
                final ZipDownloadListener zipDownloadListener2 = zipDownloadListener;
                MBDownloadManager.getInstance().download(downloadMessage).withReadTimeout((long) WorkRequest.DEFAULT_BACKOFF_DELAY_MILLIS).withConnectTimeout(20000).withDownloadPriority(DownloadPriority.HIGH).withHttpRetryCounter(1).withDirectoryPathInternal(str2).withTimeout(ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS).withDownloadStateListener(new OnDownloadStateListener() {
                    public void onCancelDownload(DownloadMessage downloadMessage) {
                        int i5;
                        af.a(H5DownLoadManager.TAG, "下载取消： " + downloadMessage.getDownloadUrl() + " " + downloadMessage.getDownloadResourceType());
                        e eVar = eVar;
                        if (eVar != null) {
                            if (downloadMessage.isCache()) {
                                i5 = 1;
                            } else {
                                i5 = 2;
                            }
                            eVar.a("cache", Integer.valueOf(i5));
                        }
                        com.mbridge.msdk.foundation.same.report.d.c cVar = cVar3;
                        if (cVar != null) {
                            cVar.a("m_download_start", eVar);
                        }
                        d.a().a("m_download_start", cVar3, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
                        if (!TextUtils.isEmpty(ResourceManager.getinstance().getResDirFromCampaign(downloadMessage.getDownloadUrl()))) {
                            ZipDownloadListener zipDownloadListener = zipDownloadListener2;
                            if (zipDownloadListener != null) {
                                zipDownloadListener.onSuccess(downloadMessage.getDownloadUrl(), "", downloadMessage.isCache());
                                return;
                            }
                            return;
                        }
                        ZipDownloadListener zipDownloadListener2 = zipDownloadListener2;
                        if (zipDownloadListener2 != null) {
                            zipDownloadListener2.onFailed(downloadMessage.getDownloadUrl(), "task cancel");
                        }
                    }

                    public void onDownloadComplete(DownloadMessage downloadMessage) {
                        int i5;
                        af.a(H5DownLoadManager.TAG, "下载结束，开始解压缩文件： " + downloadMessage.getDownloadUrl() + " " + downloadMessage.getDownloadResourceType() + " " + downloadMessage.getSaveFilePath());
                        try {
                            e eVar = eVar;
                            if (eVar != null) {
                                if (downloadMessage.isCache()) {
                                    i5 = 1;
                                } else {
                                    i5 = 2;
                                }
                                eVar.a("cache", Integer.valueOf(i5));
                            }
                            com.mbridge.msdk.foundation.same.report.d.c cVar = cVar3;
                            if (cVar != null) {
                                cVar.a("m_download_start", eVar);
                            }
                            d.a().a("m_download_start", cVar3, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
                            if (TextUtils.isEmpty(ResourceManager.getinstance().getResDirFromCampaign(downloadMessage.getDownloadUrl()))) {
                                MBResourceManager.getInstance().unZip(downloadMessage.getSaveFilePath(), str3);
                            }
                            String str = "";
                            try {
                                str = (String) downloadMessage.getExtra("responseHeaders");
                            } catch (Throwable th) {
                                af.b(H5DownLoadManager.TAG, th.getMessage());
                            }
                            af.a(H5DownLoadManager.TAG, "下载结束，开始解压缩文件，文件解压成功： " + str3);
                            ZipDownloadListener zipDownloadListener = zipDownloadListener2;
                            if (zipDownloadListener != null) {
                                zipDownloadListener.onSuccess(downloadMessage.getDownloadUrl(), str, downloadMessage.isCache());
                            }
                        } catch (IOException e5) {
                            af.a(H5DownLoadManager.TAG, "下载结束，开始解压缩文件，文件解压失败： " + e5.getMessage());
                            ZipDownloadListener zipDownloadListener2 = zipDownloadListener2;
                            if (zipDownloadListener2 != null) {
                                zipDownloadListener2.onFailed(downloadMessage.getDownloadUrl(), e5.getMessage());
                            }
                        }
                    }

                    public void onDownloadError(DownloadMessage downloadMessage, DownloadError downloadError) {
                        int i5;
                        af.a(H5DownLoadManager.TAG, "下载错误： " + downloadMessage.getDownloadUrl() + " " + downloadMessage.getDownloadResourceType() + "  " + downloadError.getException().getMessage());
                        e eVar = eVar;
                        if (eVar != null) {
                            if (downloadMessage.isCache()) {
                                i5 = 1;
                            } else {
                                i5 = 2;
                            }
                            eVar.a("cache", Integer.valueOf(i5));
                        }
                        com.mbridge.msdk.foundation.same.report.d.c cVar = cVar3;
                        if (cVar != null) {
                            cVar.a("m_download_start", eVar);
                        }
                        d.a().a("m_download_start", cVar3, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
                        if (!TextUtils.isEmpty(ResourceManager.getinstance().getResDirFromCampaign(downloadMessage.getDownloadUrl()))) {
                            ZipDownloadListener zipDownloadListener = zipDownloadListener2;
                            if (zipDownloadListener != null) {
                                zipDownloadListener.onSuccess(downloadMessage.getDownloadUrl(), "", downloadMessage.isCache());
                                return;
                            }
                            return;
                        }
                        ZipDownloadListener zipDownloadListener2 = zipDownloadListener2;
                        if (zipDownloadListener2 != null) {
                            zipDownloadListener2.onFailed(downloadMessage.getDownloadUrl(), downloadError.getException().getMessage());
                        }
                    }

                    public void onDownloadStart(DownloadMessage downloadMessage) {
                        af.a(H5DownLoadManager.TAG, "开始下载 zip： " + downloadMessage.getDownloadUrl() + " " + downloadMessage.getDownloadResourceType());
                    }
                }).build().start();
            } catch (Exception unused) {
                String str4 = str;
                ZipDownloadListener zipDownloadListener3 = zipDownloadListener;
                if (zipDownloadListener3 != null) {
                    zipDownloadListener3.onFailed(str4, "zip url is unlawful");
                }
            }
        } else if (zipDownloadListener != null) {
            zipDownloadListener.onFailed(str, "zip url is null");
        }
    }

    private void downloadZipByOldDownloadModule(com.mbridge.msdk.foundation.same.report.d.c cVar, String str, ZipDownloadListener zipDownloadListener) {
        e eVar = new e();
        eVar.a("scenes", "1");
        eVar.a("url", str);
        if (cVar != null) {
            eVar.a("resource_type", Integer.valueOf(cVar.b()));
        }
        try {
            if (TextUtils.isEmpty(this.resourceManager.getResDirFromCampaign(str))) {
                eVar.a("cache", 2);
                if (this.mResDownloadingMap.containsKey(str)) {
                    DownLoadH5SourceListener downLoadH5SourceListener = this.mResDownloadingMap.get(str);
                    if (downLoadH5SourceListener != null) {
                        downLoadH5SourceListener.setZipDownloadListener(zipDownloadListener);
                    }
                    if (cVar != null && !cVar.a()) {
                        cVar.a("m_download_start", eVar);
                        d.a().a("m_download_start", cVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
                        return;
                    }
                    return;
                }
                DownLoadH5SourceListener downLoadH5SourceListener2 = new DownLoadH5SourceListener(this.mResDownloadingMap, this.resourceManager, zipDownloadListener, str);
                this.mResDownloadingMap.put(str, downLoadH5SourceListener2);
                DownLoadUtils.getSourceCodeFromNetUrl(str, downLoadH5SourceListener2, true);
            } else {
                eVar.a("cache", 1);
                if (zipDownloadListener != null) {
                    zipDownloadListener.onSuccess(str, "", true);
                }
            }
            if (cVar != null && !cVar.a()) {
                cVar.a("m_download_start", eVar);
                d.a().a("m_download_start", cVar, (com.mbridge.msdk.foundation.same.report.d.a.a) null);
            }
        } catch (Exception e5) {
            if (zipDownloadListener != null) {
                zipDownloadListener.onFailed(str, "downloadzip failed");
            }
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
        }
    }

    private String getHtmlAddress(String str) {
        HTMLResourceManager hTMLResourceManager = this.htmlResourceManager;
        if (hTMLResourceManager != null) {
            return hTMLResourceManager.getHtmlPathFromUrl(str);
        }
        return str;
    }

    public static H5DownLoadManager getInstance() {
        if (sH5Manager == null) {
            synchronized (H5DownLoadManager.class) {
                try {
                    if (sH5Manager == null) {
                        sH5Manager = new H5DownLoadManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return sH5Manager;
    }

    private long getPreSaveTimeFromSp(String str) {
        try {
            Context c5 = c.m().c();
            Object a5 = an.a(c5, SP_ENDING_PAGE_SAVE_TIME + str, 0L);
            if (a5 != null && (a5 instanceof Long)) {
                return ((Long) a5).longValue();
            }
        } catch (Exception e5) {
            e5.printStackTrace();
        }
        return 0;
    }

    private void saveSourceContent(String str, String str2) {
        try {
            af.c(TAG, "sourceContent:" + str);
            Context c5 = c.m().c();
            an.b(c5, SP_ENDING_PAGE_SOURCE + str2, str);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    private void updateEndingPageSaveTime(String str) {
        try {
            Context c5 = c.m().c();
            an.b(c5, SP_ENDING_PAGE_SAVE_TIME + str, Long.valueOf(System.currentTimeMillis()));
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public void download(com.mbridge.msdk.foundation.same.report.d.c cVar, String str) {
        download(cVar, str, (H5ResDownloadListerInter) null);
    }

    public void downloadH5Res(com.mbridge.msdk.foundation.same.report.d.c cVar, String str) {
        downloadH5Res(cVar, str, (H5ResDownloadListerInter) null);
    }

    public void downloadZip(com.mbridge.msdk.foundation.same.report.d.c cVar, String str, ZipDownloadListener zipDownloadListener) {
        if (this.isUseDownloadModule) {
            downloadZipByDownloadModule(cVar, str, zipDownloadListener);
        } else {
            downloadZipByOldDownloadModule(cVar, str, zipDownloadListener);
        }
    }

    public String getH5ResAddress(String str) {
        try {
            if (!Patterns.WEB_URL.matcher(str).matches()) {
                if (!URLUtil.isValidUrl(str)) {
                    return str;
                }
            }
            Uri parse = Uri.parse(str);
            String path = parse.getPath();
            if (TextUtils.isEmpty(path)) {
                return str;
            }
            if (!TextUtils.isEmpty(parse.getQueryParameter("urlDebug"))) {
                return str;
            }
            if (path.toLowerCase().endsWith(".zip")) {
                return getResAddress(str);
            }
            return getHtmlAddress(str);
        } catch (Exception e5) {
            e5.printStackTrace();
            return str;
        }
    }

    public String getResAddress(String str) {
        ResourceManager resourceManager2 = this.resourceManager;
        if (resourceManager2 != null) {
            return resourceManager2.getResDirFromCampaign(str);
        }
        return null;
    }

    public String getSourceContentFromSp(String str) {
        try {
            Context c5 = c.m().c();
            Object a5 = an.a(c5, SP_ENDING_PAGE_SOURCE + str, "");
            if (a5 == null || !(a5 instanceof String)) {
                return null;
            }
            String str2 = (String) a5;
            if (ap.b(str2)) {
                return str2;
            }
            return null;
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public void download(com.mbridge.msdk.foundation.same.report.d.c cVar, String str, H5ResDownloadListerInter h5ResDownloadListerInter) {
        if (this.isUseDownloadModule) {
            downloadHTMLByDownloadModule(str, h5ResDownloadListerInter);
        } else {
            downloadHTML(cVar, str, h5ResDownloadListerInter);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:21:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void downloadH5Res(com.mbridge.msdk.foundation.same.report.d.c r3, java.lang.String r4, com.mbridge.msdk.foundation.download.download.H5DownLoadManager.H5ResDownloadListerInter r5) {
        /*
            r2 = this;
            com.mbridge.msdk.foundation.same.report.d.d r0 = com.mbridge.msdk.foundation.same.report.d.d.a()
            com.mbridge.msdk.foundation.same.report.d.c r3 = r0.b((com.mbridge.msdk.foundation.same.report.d.c) r3)
            java.util.regex.Pattern r0 = android.util.Patterns.WEB_URL     // Catch:{ Exception -> 0x001b }
            java.util.regex.Matcher r0 = r0.matcher(r4)     // Catch:{ Exception -> 0x001b }
            boolean r0 = r0.matches()     // Catch:{ Exception -> 0x001b }
            if (r0 != 0) goto L_0x001d
            boolean r0 = android.webkit.URLUtil.isValidUrl(r4)     // Catch:{ Exception -> 0x001b }
            if (r0 == 0) goto L_0x0045
            goto L_0x001d
        L_0x001b:
            r3 = move-exception
            goto L_0x0042
        L_0x001d:
            android.net.Uri r0 = android.net.Uri.parse(r4)     // Catch:{ Exception -> 0x001b }
            java.lang.String r0 = r0.getPath()     // Catch:{ Exception -> 0x001b }
            boolean r1 = android.text.TextUtils.isEmpty(r0)     // Catch:{ Exception -> 0x001b }
            if (r1 != 0) goto L_0x0045
            java.lang.String r0 = r0.toLowerCase()     // Catch:{ Exception -> 0x001b }
            java.lang.String r1 = ".zip"
            boolean r0 = r0.endsWith(r1)     // Catch:{ Exception -> 0x001b }
            if (r0 == 0) goto L_0x003e
            r0 = r5
            com.mbridge.msdk.foundation.download.download.H5DownLoadManager$ZipDownloadListener r0 = (com.mbridge.msdk.foundation.download.download.H5DownLoadManager.ZipDownloadListener) r0     // Catch:{ Exception -> 0x001b }
            r2.downloadZip(r3, r4, r0)     // Catch:{ Exception -> 0x001b }
            return
        L_0x003e:
            r2.download(r3, r4, r5)     // Catch:{ Exception -> 0x001b }
            return
        L_0x0042:
            r3.printStackTrace()
        L_0x0045:
            if (r5 == 0) goto L_0x004c
            java.lang.String r3 = "The URL does not contain a path "
            r5.onFailed(r4, r3)
        L_0x004c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.download.H5DownLoadManager.downloadH5Res(com.mbridge.msdk.foundation.same.report.d.c, java.lang.String, com.mbridge.msdk.foundation.download.download.H5DownLoadManager$H5ResDownloadListerInter):void");
    }

    public void downloadH5Res(String str, H5ResDownloadListerInter h5ResDownloadListerInter) {
        downloadH5Res(new com.mbridge.msdk.foundation.same.report.d.c(), str, h5ResDownloadListerInter);
    }
}
