package com.mbridge.msdk.foundation.download.core;

import android.os.SystemClock;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.download.DownloadError;
import com.mbridge.msdk.foundation.download.DownloadMessage;
import com.mbridge.msdk.foundation.download.DownloadPriority;
import com.mbridge.msdk.foundation.download.DownloadProgress;
import com.mbridge.msdk.foundation.download.DownloadStatus;
import com.mbridge.msdk.foundation.download.OnDownloadStateListener;
import com.mbridge.msdk.foundation.download.OnProgressStateListener;
import com.mbridge.msdk.foundation.download.resource.MBResourceManager;
import com.mbridge.msdk.foundation.download.utils.Objects;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.foundation.tools.ah;
import com.mbridge.msdk.tracker.network.q;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Future;

public class DownloadRequest<T> {
    private static final String TAG = "DownloadRequest";
    private int cacheDirectorPathType;
    private String cacheDirectoryPath;
    private long connectTimeout;
    private String directoryPathExternal;
    private String directoryPathInternal;
    private String downloadId;
    private DownloadMessage<T> downloadMessage;
    private DownloadPriority downloadPriority;
    private long downloadRequestCreateTime;
    private long downloadedBytes;
    /* access modifiers changed from: private */
    public Map<String, String> extraMap;
    private Future future;
    private HashMap<String, List<String>> headerMap;
    private q monitor;
    /* access modifiers changed from: private */
    public volatile OnDownloadStateListener onDownloadListener;
    /* access modifiers changed from: private */
    public volatile OnProgressStateListener onProgressListener;
    private long readTimeout;
    /* access modifiers changed from: private */
    public int retry;
    /* access modifiers changed from: private */
    public volatile int retryedCount = 0;
    private int sequence;
    private DownloadStatus status;
    private long timeout;
    private long totalBytes = 0;
    private String userAgent;
    private long writeTimeout;

    DownloadRequest(DownloadRequestBuilder<T> downloadRequestBuilder) {
        this.headerMap = downloadRequestBuilder.headerMap;
        this.downloadPriority = downloadRequestBuilder.downloadPriority;
        this.readTimeout = downloadRequestBuilder.readTimeout;
        this.connectTimeout = downloadRequestBuilder.connectTimeout;
        this.userAgent = downloadRequestBuilder.userAgent;
        this.downloadMessage = downloadRequestBuilder.downloadMessage;
        this.writeTimeout = downloadRequestBuilder.writeTimeout;
        this.onDownloadListener = downloadRequestBuilder.downloadStateListener;
        this.onProgressListener = downloadRequestBuilder.progressStateListener;
        this.directoryPathExternal = downloadRequestBuilder.directoryPathExternal;
        this.directoryPathInternal = downloadRequestBuilder.directoryPathInternal;
        this.retry = downloadRequestBuilder.retry;
        this.timeout = downloadRequestBuilder.timeout;
        this.extraMap = downloadRequestBuilder.extraMap;
        this.downloadRequestCreateTime = SystemClock.elapsedRealtime();
    }

    public static DownloadRequest create(DownloadRequestBuilder downloadRequestBuilder) {
        return new DownloadRequest(downloadRequestBuilder);
    }

    private void destroy() {
        this.onProgressListener = null;
        this.onDownloadListener = null;
    }

    /* access modifiers changed from: private */
    public void finish() {
        destroy();
        DownloadRequestQueue.getInstance().finish(this);
    }

    public boolean canTrack() {
        return ah.a().a("request_track", true);
    }

    public void cancel(DownloadMessage<T> downloadMessage2) {
        this.status = DownloadStatus.CANCELLED;
        Future future2 = this.future;
        if (future2 != null) {
            future2.cancel(false);
        }
    }

    public String get(String str, String str2) {
        if (!Objects.isNull(this.extraMap) && this.extraMap.containsKey(str) && !TextUtils.isEmpty(str)) {
            String str3 = this.extraMap.get(str);
            if (TextUtils.isEmpty(str3)) {
                return str2;
            }
            return str3;
        }
        return str2;
    }

    public int getCacheDirectorPathType() {
        return this.cacheDirectorPathType;
    }

    public String getCacheDirectoryPath() {
        return this.cacheDirectoryPath;
    }

    public long getConnectTimeout() {
        return this.connectTimeout;
    }

    public String getDirectoryPathExternal() {
        return this.directoryPathExternal;
    }

    public String getDirectoryPathInternal() {
        return this.directoryPathInternal;
    }

    public String getDownloadId() {
        return this.downloadId;
    }

    public DownloadMessage<T> getDownloadMessage() {
        return this.downloadMessage;
    }

    public DownloadPriority getDownloadPriority() {
        return this.downloadPriority;
    }

    public long getDownloadedBytes() {
        return this.downloadedBytes;
    }

    public HashMap<String, List<String>> getHeaders() {
        return this.headerMap;
    }

    public q getMonitor() {
        return this.monitor;
    }

    public long getReadTimeout() {
        return this.readTimeout;
    }

    public long getRequestQueueTime() {
        return SystemClock.elapsedRealtime() - this.downloadRequestCreateTime;
    }

    public int getRetry() {
        return this.retry;
    }

    public int getRetryedCount() {
        return this.retryedCount;
    }

    public int getSequence() {
        return this.sequence;
    }

    public DownloadStatus getStatus() {
        return this.status;
    }

    public long getTimeout() {
        return this.timeout;
    }

    public long getTotalBytes() {
        return this.totalBytes;
    }

    public long getWriteTimeout() {
        return this.writeTimeout;
    }

    public void handlerCancelEvent(final DownloadMessage<T> downloadMessage2) {
        ExecutorManager.getInstance().getExecutorSupplier().getDownloadResultTasks().execute(new Runnable() {
            public void run() {
                try {
                    if (DownloadRequest.this.onDownloadListener != null) {
                        DownloadRequest.this.onDownloadListener.onCancelDownload(downloadMessage2);
                    }
                    DownloadRequest.this.finish();
                } catch (Exception e5) {
                    af.b(DownloadRequest.TAG, e5.getMessage());
                }
            }
        });
    }

    public void handlerErrorEvent(final DownloadMessage<T> downloadMessage2, final DownloadError downloadError) {
        if (this.status != DownloadStatus.CANCELLED) {
            setStatus(DownloadStatus.FAILED);
            ExecutorManager.getInstance().getExecutorSupplier().getDownloadResultTasks().execute(new Runnable() {
                public void run() {
                    try {
                        if (DownloadRequest.this.retryedCount < DownloadRequest.this.retry) {
                            DownloadRequest.this.setStatus(DownloadStatus.RETRY);
                            DownloadRequest downloadRequest = DownloadRequest.this;
                            int unused = downloadRequest.retryedCount = downloadRequest.retryedCount + 1;
                            DownloadRequest.this.setDownloadedBytes(0);
                            DownloadRequest.this.setTotalBytes(0);
                            DownloadRequestQueue.getInstance().finish(DownloadRequest.this);
                            DownloadRequestQueue.getInstance().addRequest(DownloadRequest.this);
                            return;
                        }
                        DownloadRequest.this.setStatus(DownloadStatus.FAILED);
                        if (DownloadRequest.this.onDownloadListener != null) {
                            DownloadRequest.this.onDownloadListener.onDownloadError(downloadMessage2, downloadError);
                        }
                        DownloadRequest.this.finish();
                    } catch (Exception e5) {
                        af.b(DownloadRequest.TAG, e5.getMessage());
                    }
                }
            });
        }
    }

    public void handlerProcessEvent(final DownloadMessage<T> downloadMessage2, final DownloadProgress downloadProgress) {
        if (this.status != DownloadStatus.CANCELLED) {
            ExecutorManager.getInstance().getExecutorSupplier().getDownloadResultTasks().execute(new Runnable() {
                public void run() {
                    try {
                        if (DownloadRequest.this.onProgressListener != null) {
                            DownloadRequest.this.onProgressListener.onProgress(downloadMessage2, downloadProgress);
                        }
                    } catch (Exception e5) {
                        af.b(DownloadRequest.TAG, e5.getMessage());
                    }
                }
            });
        }
    }

    public void handlerStartEvent(final DownloadMessage<T> downloadMessage2) {
        if (this.status != DownloadStatus.CANCELLED) {
            ExecutorManager.getInstance().getExecutorSupplier().getDownloadResultTasks().execute(new Runnable() {
                public void run() {
                    try {
                        if (DownloadRequest.this.onDownloadListener != null) {
                            DownloadRequest.this.onDownloadListener.onDownloadStart(downloadMessage2);
                        }
                    } catch (Exception e5) {
                        af.b(DownloadRequest.TAG, e5.getMessage());
                    }
                }
            });
        }
    }

    public void handlerSuccessEvent(final DownloadMessage<T> downloadMessage2) {
        if (this.status != DownloadStatus.CANCELLED) {
            setStatus(DownloadStatus.COMPLETED);
            ExecutorManager.getInstance().getExecutorSupplier().getDownloadResultTasks().execute(new Runnable() {
                public void run() {
                    try {
                        if (DownloadRequest.this.extraMap != null && !DownloadRequest.this.extraMap.isEmpty()) {
                            String str = (String) DownloadRequest.this.extraMap.get("responseHeaders");
                            if (!TextUtils.isEmpty(str)) {
                                downloadMessage2.addExtra("responseHeaders", str);
                            }
                        }
                        if (DownloadRequest.this.onDownloadListener != null) {
                            DownloadRequest.this.onDownloadListener.onDownloadComplete(downloadMessage2);
                        }
                        DownloadRequest.this.finish();
                    } catch (Exception e5) {
                        af.b(DownloadRequest.TAG, e5.getMessage());
                    }
                }
            });
        }
    }

    public void putExtraData(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (Objects.isNull(this.extraMap)) {
                this.extraMap = new HashMap();
            }
            this.extraMap.put(str, str2);
        }
    }

    public void setCacheDirectorPathType(int i5) {
        this.cacheDirectorPathType = i5;
    }

    public void setCacheDirectoryPath(String str) {
        this.cacheDirectoryPath = str;
    }

    public void setDownloadedBytes(long j5) {
        this.downloadedBytes = j5;
    }

    public void setFuture(Future future2) {
        this.future = future2;
    }

    public void setMonitor(q qVar) {
        this.monitor = qVar;
    }

    public void setSequence(int i5) {
        this.sequence = i5;
    }

    public void setStatus(DownloadStatus downloadStatus) {
        this.status = downloadStatus;
    }

    public void setTotalBytes(long j5) {
        this.totalBytes = j5;
    }

    public String start() {
        this.downloadId = MBResourceManager.getInstance().getDownloadId(this.downloadMessage.getResourceUrl());
        DownloadRequestQueue.getInstance().addRequest(this);
        return this.downloadId;
    }
}
