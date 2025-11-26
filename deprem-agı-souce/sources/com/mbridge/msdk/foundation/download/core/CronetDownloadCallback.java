package com.mbridge.msdk.foundation.download.core;

import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.download.Command;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadProgress;
import com.mbridge.msdk.foundation.download.DownloadResponse;
import com.mbridge.msdk.foundation.download.DownloadStatus;
import com.mbridge.msdk.foundation.download.core.DownloaderReporter;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.download.database.IDatabaseHelper;
import com.mbridge.msdk.foundation.download.resource.MBResourceManager;
import com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream;
import com.mbridge.msdk.foundation.download.utils.Objects;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.tracker.network.h;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Channels;
import java.nio.channels.WritableByteChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.atomic.AtomicBoolean;
import org.chromium.net.CronetException;
import org.chromium.net.UrlRequest;
import org.chromium.net.UrlResponseInfo;
import org.json.JSONObject;

public class CronetDownloadCallback extends UrlRequest.Callback {
    private static final String TAG = "CronetDownloadCallback";
    private ByteArrayOutputStream bytesReceived = null;
    private long contentLength;
    private IDatabaseHelper databaseHelper;
    private DownloadMessage<?> downloadMessage;
    private DownloadModel downloadModel;
    private DownloaderReporter.Builder downloadReporter;
    private DownloadRequest<?> downloadRequest;
    private DownloadResponse downloadResponse;
    private String etag;
    private DownloadFileOutputStream outputStream;
    private WritableByteChannel receiveChannel = null;
    private int responseCode;
    private BlockingQueue<DownloadResponse> responseQueue;
    AtomicBoolean startResponse = new AtomicBoolean(false);

    public CronetDownloadCallback(DownloadResponse downloadResponse2, DownloadRequest<?> downloadRequest2, DownloadMessage<?> downloadMessage2, IDatabaseHelper iDatabaseHelper, DownloadModel downloadModel2, DownloaderReporter.Builder builder) {
        this.downloadResponse = downloadResponse2;
        this.downloadRequest = downloadRequest2;
        this.downloadMessage = downloadMessage2;
        this.databaseHelper = iDatabaseHelper;
        this.downloadModel = downloadModel2;
        this.downloadReporter = builder;
    }

    private static void cancelRequestSafety(UrlRequest urlRequest) {
        try {
            urlRequest.cancel();
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                af.b(TAG, "cancelRequest error: ", e5);
            }
        }
    }

    private boolean checkDownloadRequestInfo(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        String downloadId = this.downloadRequest.getDownloadId();
        String cacheDirectoryPath = this.downloadRequest.getCacheDirectoryPath();
        int httpStatusCode = urlResponseInfo.getHttpStatusCode();
        this.responseCode = httpStatusCode;
        this.downloadReporter.add(DownloadCommon.DOWNLOAD_REPORT_DOWNLOAD_RESPONSE_CODE, String.valueOf(httpStatusCode));
        if (isSuccessful(this.responseCode)) {
            this.contentLength = (long) getContentLength(urlResponseInfo);
            this.etag = getETagFromHeader(urlResponseInfo.getAllHeadersAsList());
            handlerDownloadResume(downloadId, cacheDirectoryPath);
            if (this.contentLength <= 0) {
                this.downloadResponse.setError((Exception) new IOException("response content length is null"));
                return false;
            }
            if (this.downloadRequest.getTotalBytes() == 0) {
                this.downloadRequest.setTotalBytes(this.contentLength);
            }
            handlerDownloadModel(cacheDirectoryPath);
            return true;
        }
        DownloadResponse downloadResponse2 = this.downloadResponse;
        downloadResponse2.setError((Exception) new IOException("responseCode " + this.responseCode));
        return false;
    }

    private int getContentLength(UrlResponseInfo urlResponseInfo) {
        List list = (List) urlResponseInfo.getAllHeaders().get("Content-Length");
        if (list == null) {
            return 0;
        }
        return Integer.parseInt((String) list.get(0));
    }

    private String getETagFromHeader(List<Map.Entry<String, String>> list) {
        List<h> responseHeaders = getResponseHeaders(list);
        if (responseHeaders.isEmpty()) {
            return "";
        }
        for (h next : responseHeaders) {
            if (next != null) {
                String a5 = next.a();
                if (!TextUtils.isEmpty(a5) && a5.equalsIgnoreCase(Command.HTTP_HEADER_ETAG)) {
                    return next.b();
                }
            }
        }
        return "";
    }

    private List<h> getResponseHeaders(List<Map.Entry<String, String>> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && !list.isEmpty()) {
            for (Map.Entry next : list) {
                arrayList.add(new h((String) next.getKey(), (String) next.getValue()));
            }
        }
        return arrayList;
    }

    private String getResponseHeadersWithJSON(UrlResponseInfo urlResponseInfo) {
        if (urlResponseInfo == null) {
            return "";
        }
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("url", urlResponseInfo.getUrl());
            jSONObject.put("statusCode", urlResponseInfo.getHttpStatusCode());
            jSONObject.put("protocol", urlResponseInfo.getNegotiatedProtocol());
            List<Map.Entry> allHeadersAsList = urlResponseInfo.getAllHeadersAsList();
            if (allHeadersAsList == null) {
                jSONObject.put("headers", "");
                String jSONObject2 = jSONObject.toString();
            } else {
                for (Map.Entry entry : allHeadersAsList) {
                    jSONObject.put((String) entry.getKey(), entry.getValue());
                }
            }
            return jSONObject.toString();
        } catch (Throwable th) {
            af.b(TAG, th.getMessage());
            return "";
        }
    }

    private void handlerDownloadModel(String str) {
        if (Objects.isNull(this.downloadModel)) {
            DownloadModel create = DownloadModel.create(this.downloadRequest.getDownloadId(), this.downloadMessage.getDownloadUrl(), this.downloadMessage.getResourceUrl(), this.etag, str, this.downloadMessage.getSaveFileName(), this.downloadRequest.getTotalBytes(), 0, this.downloadMessage.getDownloadRate(), 1, this.downloadMessage.getDownloadResourceType());
            this.downloadModel = create;
            this.databaseHelper.insert(create);
            return;
        }
        DownloadModel create2 = DownloadModel.create(this.downloadModel.getDownloadId(), this.downloadModel.getDownloadUrl(), this.downloadMessage.getResourceUrl(), this.downloadModel.getEtag(), this.downloadModel.getSaveDirectorPath(), this.downloadModel.getSaveFileName(), this.downloadRequest.getTotalBytes(), this.downloadModel.getDownloadedBytes(), this.downloadMessage.getDownloadRate(), this.downloadModel.getUsageCounter() + 1, this.downloadMessage.getDownloadResourceType());
        this.downloadModel = create2;
        String str2 = str;
        this.databaseHelper.update(create2, str);
    }

    private void handlerDownloadResume(String str, String str2) {
        boolean z4;
        boolean isSupportResume = isSupportResume(this.responseCode, this.downloadModel);
        DownloadRequest<?> downloadRequest2 = this.downloadRequest;
        if (downloadRequest2 == null || this.responseCode != 206 || downloadRequest2.getTotalBytes() <= 0 || this.contentLength == this.downloadRequest.getTotalBytes() - this.downloadRequest.getDownloadedBytes()) {
            z4 = false;
        } else {
            z4 = true;
        }
        if (!isSupportResume && z4) {
            this.downloadRequest.setDownloadedBytes(0);
            this.downloadRequest.setTotalBytes(0);
            if (Objects.isNotNull(this.databaseHelper)) {
                this.databaseHelper.remove(str, str2);
            }
            this.downloadModel = null;
            MBResourceManager instance = MBResourceManager.getInstance();
            instance.deleteFile(new File(this.downloadRequest.getCacheDirectoryPath() + this.downloadMessage.getSaveFileName()));
        }
    }

    private void insertDownloadInfo(String str, String str2) {
        int usageCounter;
        IDatabaseHelper databaseHelper2 = GlobalComponent.getInstance().getDatabaseHelper();
        String downloadUrl = this.downloadMessage.getDownloadUrl();
        String resourceUrl = this.downloadMessage.getResourceUrl();
        String str3 = this.etag;
        String saveFileName = this.downloadMessage.getSaveFileName();
        long totalBytes = this.downloadRequest.getTotalBytes();
        long downloadedBytes = this.downloadRequest.getDownloadedBytes();
        int downloadRate = this.downloadMessage.getDownloadRate();
        DownloadModel downloadModel2 = this.downloadModel;
        if (downloadModel2 == null) {
            usageCounter = 0;
        } else {
            usageCounter = downloadModel2.getUsageCounter();
        }
        String str4 = str;
        String str5 = str2;
        databaseHelper2.updateProgress(str4, str5, DownloadModel.create(str4, downloadUrl, resourceUrl, str3, str5, saveFileName, totalBytes, downloadedBytes, downloadRate, usageCounter, this.downloadMessage.getDownloadResourceType()));
        if (!this.downloadResponse.isCancelled()) {
            this.downloadResponse.setSuccessful(true);
        }
    }

    private boolean isSuccessful(int i5) {
        return i5 >= 200 && i5 < 300;
    }

    private boolean isSupportResume(int i5, DownloadModel downloadModel2) {
        if (i5 != 206 || TextUtils.isEmpty(this.etag)) {
            return false;
        }
        if (downloadModel2 != null && !TextUtils.equals(this.etag, downloadModel2.getEtag())) {
            return false;
        }
        return true;
    }

    private void sendProgress(DownloadRequest downloadRequest2, DownloadMessage downloadMessage2, long j5, long j6, int i5) {
        if (downloadRequest2.getStatus() != DownloadStatus.CANCELLED) {
            downloadRequest2.handlerProcessEvent(downloadMessage2, new DownloadProgress(j5, j6, i5));
        }
    }

    public void onCanceled(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        GlobalComponent.getInstance().getLogger().log(TAG, "onCanceled");
        CronetDownloadCallback.super.onCanceled(urlRequest, urlResponseInfo);
        insertDownloadInfo(this.downloadRequest.getDownloadId(), this.downloadRequest.getCacheDirectoryPath());
    }

    public void onFailed(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, CronetException cronetException) {
        GlobalComponent.getInstance().getLogger().log(TAG, "onFailed");
        try {
            if (Objects.isNotNull(this.databaseHelper) && Objects.isNotNull(this.downloadRequest)) {
                if (!ah.a().a("r_f_s_d_e", true)) {
                    this.databaseHelper.remove(this.downloadRequest.getDownloadId(), this.downloadRequest.getCacheDirectoryPath());
                    MBResourceManager instance = MBResourceManager.getInstance();
                    instance.deleteFile(new File(this.downloadRequest.getCacheDirectoryPath() + this.downloadMessage.getSaveFileName()));
                }
                this.downloadRequest.setDownloadedBytes(0);
                this.downloadRequest.setTotalBytes(0);
            }
        } catch (Exception e5) {
            GlobalComponent.getInstance().getLogger().log(TAG, e5.getMessage());
        }
        this.downloadResponse.setError((Exception) cronetException);
        if (this.responseQueue != null) {
            this.downloadResponse.setFailed(true);
            this.responseQueue.add(this.downloadResponse);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:26:0x0095  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onReadCompleted(org.chromium.net.UrlRequest r13, org.chromium.net.UrlResponseInfo r14, java.nio.ByteBuffer r15) throws java.lang.Exception {
        /*
            r12 = this;
            if (r13 == 0) goto L_0x0006
            if (r14 == 0) goto L_0x0006
            if (r15 != 0) goto L_0x0009
        L_0x0006:
            r4 = r12
            goto L_0x009f
        L_0x0009:
            r15.flip()     // Catch:{ Exception -> 0x008e }
            java.nio.channels.WritableByteChannel r14 = r12.receiveChannel     // Catch:{ Exception -> 0x008e }
            r14.write(r15)     // Catch:{ Exception -> 0x008e }
            java.io.ByteArrayOutputStream r14 = r12.bytesReceived     // Catch:{ Exception -> 0x008e }
            byte[] r14 = r14.toByteArray()     // Catch:{ Exception -> 0x008e }
            int r0 = r14.length     // Catch:{ Exception -> 0x008e }
            com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream r1 = r12.outputStream     // Catch:{ Exception -> 0x008e }
            r2 = 0
            r1.write(r14, r2, r0)     // Catch:{ Exception -> 0x008e }
            com.mbridge.msdk.foundation.download.resource.stream.DownloadFileOutputStream r14 = r12.outputStream     // Catch:{ Exception -> 0x008e }
            r14.flushAndSync()     // Catch:{ Exception -> 0x008e }
            com.mbridge.msdk.foundation.download.core.DownloadRequest<?> r14 = r12.downloadRequest     // Catch:{ Exception -> 0x008e }
            long r1 = r14.getDownloadedBytes()     // Catch:{ Exception -> 0x008e }
            long r3 = (long) r0     // Catch:{ Exception -> 0x008e }
            long r1 = r1 + r3
            r14.setDownloadedBytes(r1)     // Catch:{ Exception -> 0x008e }
            com.mbridge.msdk.foundation.download.core.DownloadRequest<?> r14 = r12.downloadRequest     // Catch:{ Exception -> 0x008e }
            long r0 = r14.getTotalBytes()     // Catch:{ Exception -> 0x008e }
            com.mbridge.msdk.foundation.download.core.DownloadRequest<?> r14 = r12.downloadRequest     // Catch:{ Exception -> 0x008e }
            long r2 = r14.getDownloadedBytes()     // Catch:{ Exception -> 0x008e }
            int r11 = com.mbridge.msdk.foundation.download.utils.Utils.getDownloadRate(r0, r2)     // Catch:{ Exception -> 0x008e }
            com.mbridge.msdk.foundation.download.core.DownloadRequest<?> r5 = r12.downloadRequest     // Catch:{ Exception -> 0x008e }
            com.mbridge.msdk.foundation.download.DownloadMessage<?> r6 = r12.downloadMessage     // Catch:{ Exception -> 0x008e }
            long r7 = r5.getDownloadedBytes()     // Catch:{ Exception -> 0x008e }
            com.mbridge.msdk.foundation.download.core.DownloadRequest<?> r14 = r12.downloadRequest     // Catch:{ Exception -> 0x008e }
            long r9 = r14.getTotalBytes()     // Catch:{ Exception -> 0x008e }
            r4 = r12
            r4.sendProgress(r5, r6, r7, r9, r11)     // Catch:{ Exception -> 0x0066 }
            com.mbridge.msdk.foundation.download.DownloadMessage<?> r14 = r4.downloadMessage     // Catch:{ Exception -> 0x0066 }
            int r14 = r14.getDownloadRate()     // Catch:{ Exception -> 0x0066 }
            r0 = 100
            if (r14 == r0) goto L_0x0069
            com.mbridge.msdk.foundation.download.DownloadMessage<?> r14 = r4.downloadMessage     // Catch:{ Exception -> 0x0066 }
            int r14 = r14.getDownloadRate()     // Catch:{ Exception -> 0x0066 }
            if (r11 < r14) goto L_0x0069
            cancelRequestSafety(r13)     // Catch:{ Exception -> 0x0066 }
            return
        L_0x0066:
            r0 = move-exception
        L_0x0067:
            r14 = r0
            goto L_0x0091
        L_0x0069:
            com.mbridge.msdk.foundation.download.core.DownloadRequest<?> r14 = r4.downloadRequest     // Catch:{ Exception -> 0x0066 }
            com.mbridge.msdk.foundation.download.DownloadStatus r14 = r14.getStatus()     // Catch:{ Exception -> 0x0066 }
            com.mbridge.msdk.foundation.download.DownloadStatus r0 = com.mbridge.msdk.foundation.download.DownloadStatus.CANCELLED     // Catch:{ Exception -> 0x0066 }
            if (r14 != r0) goto L_0x007d
            com.mbridge.msdk.foundation.download.DownloadResponse r14 = r4.downloadResponse     // Catch:{ Exception -> 0x0066 }
            r15 = 1
            r14.setCancelled(r15)     // Catch:{ Exception -> 0x0066 }
            cancelRequestSafety(r13)     // Catch:{ Exception -> 0x0066 }
            return
        L_0x007d:
            java.io.ByteArrayOutputStream r14 = r4.bytesReceived     // Catch:{ Exception -> 0x0066 }
            r14.flush()     // Catch:{ Exception -> 0x0066 }
            java.io.ByteArrayOutputStream r14 = r4.bytesReceived     // Catch:{ Exception -> 0x0066 }
            r14.reset()     // Catch:{ Exception -> 0x0066 }
            r15.clear()     // Catch:{ Exception -> 0x0066 }
            r13.read(r15)     // Catch:{ Exception -> 0x0066 }
            return
        L_0x008e:
            r0 = move-exception
            r4 = r12
            goto L_0x0067
        L_0x0091:
            boolean r15 = com.mbridge.msdk.MBridgeConstans.DEBUG
            if (r15 == 0) goto L_0x009c
            java.lang.String r15 = "CronetDownloadCallback"
            java.lang.String r0 = "onReadCompleted error: "
            com.mbridge.msdk.foundation.tools.af.b(r15, r0, r14)
        L_0x009c:
            cancelRequestSafety(r13)
        L_0x009f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.foundation.download.core.CronetDownloadCallback.onReadCompleted(org.chromium.net.UrlRequest, org.chromium.net.UrlResponseInfo, java.nio.ByteBuffer):void");
    }

    public void onRedirectReceived(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo, String str) throws Exception {
        if (urlRequest != null) {
            try {
                urlRequest.followRedirect();
            } catch (Exception e5) {
                if (MBridgeConstans.DEBUG) {
                    af.b(TAG, "onRedirectReceived error: ", e5);
                }
            }
        }
    }

    public void onResponseStarted(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) throws Exception {
        if (urlRequest != null) {
            AtomicBoolean atomicBoolean = this.startResponse;
            if (!(atomicBoolean == null || atomicBoolean.get() || this.responseQueue == null)) {
                DownloadResponse downloadResponse2 = new DownloadResponse();
                downloadResponse2.setResponseStart(true);
                this.responseQueue.add(downloadResponse2);
                DownloadRequest<?> downloadRequest2 = this.downloadRequest;
                if (downloadRequest2 != null) {
                    downloadRequest2.putExtraData("responseHeaders", getResponseHeadersWithJSON(urlResponseInfo));
                }
            }
            if (checkDownloadRequestInfo(urlRequest, urlResponseInfo)) {
                try {
                    GlobalComponent.getInstance().getLogger().log(TAG, "onResponseStarted");
                    String saveFileName = this.downloadMessage.getSaveFileName();
                    DownloadFileOutputStream downloadFileOutputStream = MBResourceManager.getInstance().getDownloadFileOutputStream(new File(this.downloadRequest.getCacheDirectoryPath(), saveFileName));
                    this.outputStream = downloadFileOutputStream;
                    downloadFileOutputStream.seek(this.downloadRequest.getDownloadedBytes());
                    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                    this.bytesReceived = byteArrayOutputStream;
                    this.receiveChannel = Channels.newChannel(byteArrayOutputStream);
                    urlRequest.read(ByteBuffer.allocateDirect(GlobalComponent.getInstance().getByteBufferSize()));
                } catch (Exception e5) {
                    if (MBridgeConstans.DEBUG) {
                        af.b(TAG, "onResponseStarted error: ", e5);
                    }
                    cancelRequestSafety(urlRequest);
                }
            } else {
                GlobalComponent.getInstance().getLogger().log(TAG, "onResponseStarted failed");
                cancelRequestSafety(urlRequest);
            }
        }
    }

    public void onSucceeded(UrlRequest urlRequest, UrlResponseInfo urlResponseInfo) {
        GlobalComponent.getInstance().getLogger().log(TAG, "onSucceeded");
        insertDownloadInfo(this.downloadRequest.getDownloadId(), this.downloadRequest.getCacheDirectoryPath());
        if (this.responseQueue != null) {
            DownloadResponse downloadResponse2 = new DownloadResponse();
            downloadResponse2.setSuccessful(true);
            this.responseQueue.add(downloadResponse2);
        }
    }

    public void setBlockingQueue(BlockingQueue<DownloadResponse> blockingQueue) {
        this.responseQueue = blockingQueue;
    }
}
