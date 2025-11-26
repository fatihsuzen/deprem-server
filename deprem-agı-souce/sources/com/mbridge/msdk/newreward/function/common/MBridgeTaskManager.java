package com.mbridge.msdk.newreward.function.common;

import android.os.Handler;
import android.os.HandlerThread;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.af;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MBridgeTaskManager {
    private static final int CAMPAIGN_TABLE_THREAD_POOL_CORE_SIZE = 1;
    private static final int CAMPAIGN_TABLE_THREAD_POOL_MAX_SIZE = 1;
    private static final String TAG = "MBridgeTaskManager";
    private static volatile ThreadPoolExecutor campaignTableExecutor;
    private static volatile ThreadPoolExecutor commonExecutor;
    private static volatile Handler directorHandler;

    private static final class TaskWrapper implements Runnable {
        private final Runnable runnable;

        public TaskWrapper(Runnable runnable2) {
            this.runnable = runnable2;
        }

        public final void run() {
            Runnable runnable2 = this.runnable;
            if (runnable2 != null) {
                try {
                    runnable2.run();
                } catch (Throwable th) {
                    if (MBridgeConstans.DEBUG) {
                        af.b(MBridgeTaskManager.TAG, "TaskWrapper", th);
                    }
                }
            }
        }
    }

    private MBridgeTaskManager() {
    }

    public static void campaignTableExecute(Runnable runnable) {
        getCampaignTableExecutor().execute(new TaskWrapper(runnable));
    }

    public static void commonExecute(Runnable runnable) {
        getCommonExecutor().execute(new TaskWrapper(runnable));
    }

    public static void directorExecute(Runnable runnable, long j5) {
        getDirectorHandler().postDelayed(new TaskWrapper(runnable), j5);
    }

    private static Executor getCampaignTableExecutor() {
        if (campaignTableExecutor != null) {
            return campaignTableExecutor;
        }
        synchronized (MBridgeTaskManager.class) {
            try {
                if (campaignTableExecutor == null) {
                    campaignTableExecutor = new ThreadPoolExecutor(1, 1, 10, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() {
                        public final Thread newThread(Runnable runnable) {
                            Thread thread = new Thread(runnable);
                            thread.setName("MBridgeCampaignTableTask");
                            return thread;
                        }
                    }, new ThreadPoolExecutor.DiscardPolicy());
                    campaignTableExecutor.allowCoreThreadTimeOut(true);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return campaignTableExecutor;
    }

    private static Executor getCommonExecutor() {
        if (commonExecutor != null) {
            return commonExecutor;
        }
        synchronized (MBridgeTaskManager.class) {
            try {
                if (commonExecutor == null) {
                    commonExecutor = new ThreadPoolExecutor(10, 10, 100, TimeUnit.MILLISECONDS, new LinkedBlockingQueue(), new ThreadFactory() {
                        public final Thread newThread(Runnable runnable) {
                            Thread thread = new Thread(runnable);
                            thread.setName("MBridgeCommonTask");
                            return thread;
                        }
                    });
                    commonExecutor.allowCoreThreadTimeOut(true);
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return commonExecutor;
    }

    private static Handler getDirectorHandler() {
        if (directorHandler != null) {
            return directorHandler;
        }
        synchronized (MBridgeTaskManager.class) {
            try {
                if (directorHandler == null) {
                    HandlerThread handlerThread = new HandlerThread("mb_director_thread");
                    handlerThread.start();
                    directorHandler = new Handler(handlerThread.getLooper());
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return directorHandler;
    }
}
