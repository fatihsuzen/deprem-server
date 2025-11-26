package com.mbridge.msdk.foundation.download.resource;

import com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream;
import com.mbridge.msdk.foundation.download.resource.stream.FileDownloadRandomAccessDownloadFile;
import com.mbridge.msdk.foundation.download.utils.Objects;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.File;
import java.io.IOException;
import java.math.BigInteger;
import java.net.URL;
import java.security.MessageDigest;

public class MBResourceManager {
    /* access modifiers changed from: private */
    public static volatile MBResourceManager MBResourceManager;

    private MBResourceManager() {
    }

    public static MBResourceManager getInstance() {
        if (MBResourceManager == null) {
            synchronized (MBResourceManager.class) {
                try {
                    if (MBResourceManager == null) {
                        MBResourceManager = new MBResourceManager();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return MBResourceManager;
    }

    public void deleteFile(File file) {
        if (file != null && file.exists()) {
            if (file.isFile()) {
                file.delete();
                return;
            }
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                for (File absolutePath : listFiles) {
                    deleteFile(new File(absolutePath.getAbsolutePath()));
                }
            }
            file.delete();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0012, code lost:
        r0 = r5.getResourceStrategyQueue();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void executeResourceStrategy(final com.mbridge.msdk.foundation.download.resource.ResourceConfig r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x0055
            java.util.Queue r0 = r5.getResourceStrategyQueue()
            if (r0 == 0) goto L_0x0055
            java.util.Queue r0 = r5.getResourceStrategyQueue()
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0055
            java.util.Queue r0 = r5.getResourceStrategyQueue()
            if (r0 == 0) goto L_0x0055
            boolean r1 = r0.isEmpty()
            if (r1 == 0) goto L_0x001f
            goto L_0x0055
        L_0x001f:
            com.mbridge.msdk.foundation.download.core.GlobalComponent r1 = com.mbridge.msdk.foundation.download.core.GlobalComponent.getInstance()
            com.mbridge.msdk.foundation.download.utils.ILogger r1 = r1.getLogger()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "配置的资源管理策略数量： "
            r2.append(r3)
            int r3 = r0.size()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            java.lang.String r3 = "ResourceStrategy"
            r1.log((java.lang.String) r3, (java.lang.String) r2)
            com.mbridge.msdk.foundation.download.resource.MBResourceManager$1 r1 = new com.mbridge.msdk.foundation.download.resource.MBResourceManager$1
            r1.<init>(r0, r5)
            com.mbridge.msdk.foundation.download.core.ExecutorManager r5 = com.mbridge.msdk.foundation.download.core.ExecutorManager.getInstance()
            com.mbridge.msdk.foundation.download.core.ExecutorSupplier r5 = r5.getExecutorSupplier()
            java.util.concurrent.ExecutorService r5 = r5.getLruCacheThreadTasks()
            r5.execute(r1)
        L_0x0055:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.resource.MBResourceManager.executeResourceStrategy(com.mbridge.msdk.foundation.download.resource.ResourceConfig):void");
    }

    public DownloadFileOutputStream getDownloadFileOutputStream(File file) throws IOException {
        if (file != null) {
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            file.createNewFile();
            return new FileDownloadRandomAccessDownloadFile(file);
        }
        throw new IOException("file is null");
    }

    public String getDownloadId(String str) {
        try {
            URL url = new URL(str);
            MessageDigest instance = MessageDigest.getInstance(SameMD5.TAG);
            instance.update((url.getProtocol() + "://" + url.getHost() + url.getPath()).getBytes(C.UTF8_NAME));
            return new BigInteger(1, instance.digest()).toString(16);
        } catch (Exception unused) {
            return str;
        }
    }

    public long getFileSize(File file, String str, String str2) {
        if (Objects.exists(file, str, str2)) {
            try {
                return file.length();
            } catch (Exception unused) {
            }
        }
        return 0;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:9|10|14) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:?, code lost:
        com.mbridge.msdk.foundation.tools.ad.b(r2, r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x001b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void unZip(java.lang.String r2, java.lang.String r3) throws java.io.IOException {
        /*
            r1 = this;
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto L_0x001f
            boolean r0 = android.text.TextUtils.isEmpty(r3)
            if (r0 != 0) goto L_0x001f
            com.mbridge.msdk.foundation.download.utils.UnzipUtility r0 = new com.mbridge.msdk.foundation.download.utils.UnzipUtility     // Catch:{ Exception -> 0x001b }
            r0.<init>()     // Catch:{ Exception -> 0x001b }
            int r0 = r0.unzip(r2, r3)     // Catch:{ Exception -> 0x001b }
            if (r0 == 0) goto L_0x001e
            com.mbridge.msdk.foundation.tools.ad.b(r2, r3)     // Catch:{ Exception -> 0x001b }
            return
        L_0x001b:
            com.mbridge.msdk.foundation.tools.ad.b(r2, r3)     // Catch:{ Exception -> 0x001e }
        L_0x001e:
            return
        L_0x001f:
            java.io.IOException r2 = new java.io.IOException
            java.lang.String r3 = "zipFilePath or destDirectory is null"
            r2.<init>(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.resource.MBResourceManager.unZip(java.lang.String, java.lang.String):void");
    }

    public void deleteFile(String str) {
        deleteFile(new File(str));
    }
}
