package com.mbridge.msdk.foundation.download.download;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.download.H5DownLoadManager;
import com.mbridge.msdk.foundation.tools.af;
import java.util.Iterator;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class DownLoadH5SourceListener implements H5DownLoadManager.IOnDownLoadH5Source {
    private static String TAG = "DownLoadH5SourceListener";
    private CopyOnWriteArrayList<H5DownLoadManager.ZipDownloadListener> listeners;
    private ConcurrentMap<String, DownLoadH5SourceListener> mResDownloadingMap;
    private String mUrl;
    private ResourceManager resourceManager;

    public DownLoadH5SourceListener(ConcurrentMap<String, DownLoadH5SourceListener> concurrentMap, ResourceManager resourceManager2, H5DownLoadManager.ZipDownloadListener zipDownloadListener, String str) {
        CopyOnWriteArrayList<H5DownLoadManager.ZipDownloadListener> copyOnWriteArrayList = new CopyOnWriteArrayList<>();
        this.listeners = copyOnWriteArrayList;
        this.mResDownloadingMap = concurrentMap;
        this.resourceManager = resourceManager2;
        copyOnWriteArrayList.add(zipDownloadListener);
        this.mUrl = str;
    }

    public void onFailed(String str) {
        try {
            ConcurrentMap<String, DownLoadH5SourceListener> concurrentMap = this.mResDownloadingMap;
            if (concurrentMap == null) {
                Iterator<H5DownLoadManager.ZipDownloadListener> it = this.listeners.iterator();
                while (it.hasNext()) {
                    H5DownLoadManager.ZipDownloadListener next = it.next();
                    if (next != null) {
                        next.onFailed(this.mUrl, "mResDownloadingMap  is null");
                        this.listeners.remove(next);
                    }
                }
                return;
            }
            if (concurrentMap.containsKey(this.mUrl)) {
                this.mResDownloadingMap.remove(this.mUrl);
            }
            Iterator<H5DownLoadManager.ZipDownloadListener> it2 = this.listeners.iterator();
            while (it2.hasNext()) {
                H5DownLoadManager.ZipDownloadListener next2 = it2.next();
                if (next2 != null) {
                    next2.onFailed(this.mUrl, str);
                    this.listeners.remove(next2);
                }
            }
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
            str = e5.getMessage();
        } catch (Throwable th) {
            af.b(TAG, th.getMessage(), th);
        }
    }

    public void onStart() {
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x0098  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSuccess(java.lang.String r3, byte[] r4, java.lang.String r5) {
        /*
            r2 = this;
            java.lang.String r3 = ""
            java.util.concurrent.ConcurrentMap<java.lang.String, com.mbridge.msdk.foundation.download.download.DownLoadH5SourceListener> r0 = r2.mResDownloadingMap     // Catch:{ Exception -> 0x0025 }
            if (r0 != 0) goto L_0x0027
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.download.download.H5DownLoadManager$ZipDownloadListener> r4 = r2.listeners     // Catch:{ Exception -> 0x0025 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x0025 }
        L_0x000c:
            boolean r0 = r4.hasNext()     // Catch:{ Exception -> 0x0025 }
            if (r0 == 0) goto L_0x00a4
            java.lang.Object r0 = r4.next()     // Catch:{ Exception -> 0x0025 }
            com.mbridge.msdk.foundation.download.download.H5DownLoadManager$ZipDownloadListener r0 = (com.mbridge.msdk.foundation.download.download.H5DownLoadManager.ZipDownloadListener) r0     // Catch:{ Exception -> 0x0025 }
            if (r0 == 0) goto L_0x000c
            java.lang.String r1 = "mResDownloadingMap  is null"
            r0.onFailed(r5, r1)     // Catch:{ Exception -> 0x0025 }
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.download.download.H5DownLoadManager$ZipDownloadListener> r1 = r2.listeners     // Catch:{ Exception -> 0x0025 }
            r1.remove(r0)     // Catch:{ Exception -> 0x0025 }
            goto L_0x000c
        L_0x0025:
            r4 = move-exception
            goto L_0x0076
        L_0x0027:
            boolean r0 = r0.containsKey(r5)     // Catch:{ Exception -> 0x0025 }
            if (r0 == 0) goto L_0x0032
            java.util.concurrent.ConcurrentMap<java.lang.String, com.mbridge.msdk.foundation.download.download.DownLoadH5SourceListener> r0 = r2.mResDownloadingMap     // Catch:{ Exception -> 0x0025 }
            r0.remove(r5)     // Catch:{ Exception -> 0x0025 }
        L_0x0032:
            if (r4 == 0) goto L_0x0073
            int r0 = r4.length     // Catch:{ Exception -> 0x0025 }
            if (r0 <= 0) goto L_0x0073
            com.mbridge.msdk.foundation.download.download.ResourceManager r0 = r2.resourceManager     // Catch:{ Exception -> 0x0025 }
            java.lang.String r4 = r0.saveResFile(r5, r4)     // Catch:{ Exception -> 0x0025 }
            boolean r0 = android.text.TextUtils.isEmpty(r4)     // Catch:{ Exception -> 0x0025 }
            if (r0 == 0) goto L_0x0061
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.download.download.H5DownLoadManager$ZipDownloadListener> r4 = r2.listeners     // Catch:{ Exception -> 0x0025 }
            java.util.Iterator r4 = r4.iterator()     // Catch:{ Exception -> 0x0025 }
        L_0x0049:
            boolean r0 = r4.hasNext()     // Catch:{ Exception -> 0x0025 }
            if (r0 == 0) goto L_0x00a4
            java.lang.Object r0 = r4.next()     // Catch:{ Exception -> 0x0025 }
            com.mbridge.msdk.foundation.download.download.H5DownLoadManager$ZipDownloadListener r0 = (com.mbridge.msdk.foundation.download.download.H5DownLoadManager.ZipDownloadListener) r0     // Catch:{ Exception -> 0x0025 }
            if (r0 == 0) goto L_0x0049
            r1 = 0
            r0.onSuccess(r5, r3, r1)     // Catch:{ Exception -> 0x0025 }
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.download.download.H5DownLoadManager$ZipDownloadListener> r1 = r2.listeners     // Catch:{ Exception -> 0x0025 }
            r1.remove(r0)     // Catch:{ Exception -> 0x0025 }
            goto L_0x0049
        L_0x0061:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0025 }
            r0.<init>()     // Catch:{ Exception -> 0x0025 }
            java.lang.String r1 = "data save failed:"
            r0.append(r1)     // Catch:{ Exception -> 0x0025 }
            r0.append(r4)     // Catch:{ Exception -> 0x0025 }
            java.lang.String r3 = r0.toString()     // Catch:{ Exception -> 0x0025 }
            goto L_0x008c
        L_0x0073:
            java.lang.String r3 = "response data is error"
            goto L_0x008c
        L_0x0076:
            boolean r0 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r0 == 0) goto L_0x007d
            r4.printStackTrace()
        L_0x007d:
            java.lang.String r3 = r4.getMessage()     // Catch:{ all -> 0x0082 }
            goto L_0x008c
        L_0x0082:
            r4 = move-exception
            java.lang.String r0 = TAG
            java.lang.String r1 = r4.getMessage()
            com.mbridge.msdk.foundation.tools.af.b(r0, r1, r4)
        L_0x008c:
            java.util.concurrent.CopyOnWriteArrayList<com.mbridge.msdk.foundation.download.download.H5DownLoadManager$ZipDownloadListener> r4 = r2.listeners
            java.util.Iterator r4 = r4.iterator()
        L_0x0092:
            boolean r0 = r4.hasNext()
            if (r0 == 0) goto L_0x00a4
            java.lang.Object r0 = r4.next()
            com.mbridge.msdk.foundation.download.download.H5DownLoadManager$ZipDownloadListener r0 = (com.mbridge.msdk.foundation.download.download.H5DownLoadManager.ZipDownloadListener) r0
            if (r0 == 0) goto L_0x0092
            r0.onFailed(r5, r3)
            goto L_0x0092
        L_0x00a4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.download.DownLoadH5SourceListener.onSuccess(java.lang.String, byte[], java.lang.String):void");
    }

    public void setZipDownloadListener(H5DownLoadManager.ZipDownloadListener zipDownloadListener) {
        this.listeners.add(zipDownloadListener);
    }
}
