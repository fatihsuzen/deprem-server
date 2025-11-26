package com.mbridge.msdk.foundation.download.core;

import android.content.Context;
import android.database.Cursor;
import com.mbridge.msdk.foundation.download.MBDownloadConfig;
import com.mbridge.msdk.foundation.download.database.DatabaseHelper;
import com.mbridge.msdk.foundation.download.database.DownloadModel;
import com.mbridge.msdk.foundation.download.database.IDatabaseHelper;
import com.mbridge.msdk.foundation.download.utils.ILogger;
import com.mbridge.msdk.foundation.download.utils.Objects;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.thrid.okhttp.ConnectionPool;
import com.mbridge.msdk.thrid.okhttp.Dispatcher;
import com.mbridge.msdk.thrid.okhttp.OkHttpClient;
import com.mbridge.msdk.thrid.okhttp.Protocol;
import com.mbridge.msdk.thrid.okhttp.internal.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class GlobalComponent {
    private static volatile GlobalComponent INSTANCE;
    private int byteBufferSize = 4096;
    private MBDownloadConfig config;
    private Context context;
    private IDatabaseHelper databaseHelper;
    private String databaseTableName = DownloadModel.TABLE_NAME;
    private ILogger logger;
    private volatile OkHttpClient okHttpClient;

    private GlobalComponent() {
    }

    public static GlobalComponent getInstance() {
        if (Objects.isNull(INSTANCE)) {
            synchronized (GlobalComponent.class) {
                try {
                    if (Objects.isNull(INSTANCE)) {
                        INSTANCE = new GlobalComponent();
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return INSTANCE;
    }

    public final int getByteBufferSize() {
        return this.byteBufferSize;
    }

    public final Context getContext() {
        return this.context;
    }

    public final IDatabaseHelper getDatabaseHelper() {
        return this.databaseHelper;
    }

    public final String getDatabaseTableName() {
        return this.databaseTableName;
    }

    public final ILogger getLogger() {
        if (this.logger == null) {
            this.logger = new ILogger() {
                public void log(String str, String str2) {
                    af.a(str, str2);
                }

                public void log(String str, Exception exc) {
                    af.a(str, exc.getMessage());
                }
            };
        }
        return this.logger;
    }

    public final OkHttpClient getOkHttpClient() {
        if (this.okHttpClient == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(Protocol.HTTP_1_1);
            Dispatcher dispatcher = new Dispatcher(new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), Util.threadFactory("OkHttp Dispatcher", false)));
            dispatcher.setMaxRequests(this.config.getMaxRequests());
            dispatcher.setMaxRequestsPerHost(this.config.getMaxRequestsPerHost());
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            long defaultConnectTimeout = this.config.getDefaultConnectTimeout();
            TimeUnit timeUnit = TimeUnit.MILLISECONDS;
            this.okHttpClient = builder.connectTimeout(defaultConnectTimeout, timeUnit).readTimeout(this.config.getDefaultConnectTimeout(), timeUnit).writeTimeout(this.config.getDefaultWriteTimeout(), timeUnit).dispatcher(dispatcher).pingInterval(this.config.getDefaultPingInterval(), timeUnit).retryOnConnectionFailure(true).connectionPool(new ConnectionPool(32, 5, TimeUnit.MINUTES)).protocols(arrayList).build();
        }
        return this.okHttpClient;
    }

    public final void initialize(Context context2, MBDownloadConfig mBDownloadConfig) {
        this.context = context2.getApplicationContext();
        this.logger = mBDownloadConfig.getLogger();
        this.config = mBDownloadConfig;
        if (mBDownloadConfig.getDatabaseHandler() == null || mBDownloadConfig.getDatabaseHelper() == null) {
            this.databaseHelper = new IDatabaseHelper() {
                public void clear() {
                }

                public void find(String str, String str2, IDatabaseHelper.IDatabaseListener iDatabaseListener) {
                }

                public List<DownloadModel> findAll() {
                    return null;
                }

                public void findByDownloadUrl(String str, IDatabaseHelper.IDatabaseListener iDatabaseListener) {
                }

                public List<DownloadModel> getUnwantedModels(long j5) {
                    return null;
                }

                public void insert(DownloadModel downloadModel) {
                }

                public Cursor rawQuery(String str, String[] strArr) {
                    return null;
                }

                public void remove(String str) {
                }

                public void update(DownloadModel downloadModel, String str) {
                }

                public void updateProgress(String str, String str2, DownloadModel downloadModel) {
                }

                public void updateUnzipResource(String str, String str2, long j5) {
                }

                public void remove(String str, String str2) {
                }
            };
        } else {
            this.databaseHelper = new DatabaseHelper(context2, mBDownloadConfig.getDatabaseHandler(), mBDownloadConfig.getDatabaseHelper());
        }
    }
}
