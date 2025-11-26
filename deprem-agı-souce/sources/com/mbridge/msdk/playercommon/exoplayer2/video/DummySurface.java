package com.mbridge.msdk.playercommon.exoplayer2.video;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.EGL14;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.Log;
import android.view.Surface;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.EGLSurfaceTexture;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;

@TargetApi(17)
public final class DummySurface extends Surface {
    private static final String EXTENSION_PROTECTED_CONTENT = "EGL_EXT_protected_content";
    private static final String EXTENSION_SURFACELESS_CONTEXT = "EGL_KHR_surfaceless_context";
    private static final String TAG = "DummySurface";
    private static int secureMode;
    private static boolean secureModeInitialized;
    public final boolean secure;
    private final DummySurfaceThread thread;
    private boolean threadReleased;

    private static class DummySurfaceThread extends HandlerThread implements Handler.Callback {
        private static final int MSG_INIT = 1;
        private static final int MSG_RELEASE = 2;
        @Nullable
        private EGLSurfaceTexture eglSurfaceTexture;
        @Nullable
        private Handler handler;
        @Nullable
        private Error initError;
        @Nullable
        private RuntimeException initException;
        @Nullable
        private DummySurface surface;

        public DummySurfaceThread() {
            super("dummySurface");
        }

        private void initInternal(int i5) {
            boolean z4;
            Assertions.checkNotNull(this.eglSurfaceTexture);
            this.eglSurfaceTexture.init(i5);
            SurfaceTexture surfaceTexture = this.eglSurfaceTexture.getSurfaceTexture();
            if (i5 != 0) {
                z4 = true;
            } else {
                z4 = false;
            }
            this.surface = new DummySurface(this, surfaceTexture, z4);
        }

        private void releaseInternal() {
            Assertions.checkNotNull(this.eglSurfaceTexture);
            this.eglSurfaceTexture.release();
        }

        public boolean handleMessage(Message message) {
            int i5 = message.what;
            if (i5 == 1) {
                try {
                    initInternal(message.arg1);
                    synchronized (this) {
                        notify();
                    }
                } catch (RuntimeException e5) {
                    Log.e(DummySurface.TAG, "Failed to initialize dummy surface", e5);
                    this.initException = e5;
                    synchronized (this) {
                        notify();
                    }
                } catch (Error e6) {
                    try {
                        Log.e(DummySurface.TAG, "Failed to initialize dummy surface", e6);
                        this.initError = e6;
                        synchronized (this) {
                            notify();
                        }
                    } catch (Throwable th) {
                        synchronized (this) {
                            notify();
                            throw th;
                        }
                    }
                }
                return true;
            } else if (i5 != 2) {
                return true;
            } else {
                try {
                    releaseInternal();
                } catch (Throwable th2) {
                    quit();
                    throw th2;
                }
                quit();
                return true;
            }
        }

        public DummySurface init(int i5) {
            boolean z4;
            start();
            this.handler = new Handler(getLooper(), this);
            this.eglSurfaceTexture = new EGLSurfaceTexture(this.handler);
            synchronized (this) {
                z4 = false;
                this.handler.obtainMessage(1, i5, 0).sendToTarget();
                while (this.surface == null && this.initException == null && this.initError == null) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                        z4 = true;
                    }
                }
            }
            if (z4) {
                Thread.currentThread().interrupt();
            }
            RuntimeException runtimeException = this.initException;
            if (runtimeException == null) {
                Error error = this.initError;
                if (error == null) {
                    return (DummySurface) Assertions.checkNotNull(this.surface);
                }
                throw error;
            }
            throw runtimeException;
        }

        public void release() {
            Assertions.checkNotNull(this.handler);
            this.handler.sendEmptyMessage(2);
        }
    }

    private static void assertApiLevel17OrHigher() {
        if (Util.SDK_INT < 17) {
            throw new UnsupportedOperationException("Unsupported prior to API level 17");
        }
    }

    @TargetApi(24)
    private static int getSecureModeV24(Context context) {
        String eglQueryString;
        int i5 = Util.SDK_INT;
        if (i5 < 26 && ("samsung".equals(Util.MANUFACTURER) || "XT1650".equals(Util.MODEL))) {
            return 0;
        }
        if ((i5 < 26 && !context.getPackageManager().hasSystemFeature("android.hardware.vr.high_performance")) || (eglQueryString = EGL14.eglQueryString(EGL14.eglGetDisplay(0), 12373)) == null || !eglQueryString.contains(EXTENSION_PROTECTED_CONTENT)) {
            return 0;
        }
        if (eglQueryString.contains(EXTENSION_SURFACELESS_CONTEXT)) {
            return 1;
        }
        return 2;
    }

    public static synchronized boolean isSecureSupported(Context context) {
        boolean z4;
        int i5;
        synchronized (DummySurface.class) {
            try {
                z4 = true;
                if (!secureModeInitialized) {
                    if (Util.SDK_INT < 24) {
                        i5 = 0;
                    } else {
                        i5 = getSecureModeV24(context);
                    }
                    secureMode = i5;
                    secureModeInitialized = true;
                }
                if (secureMode == 0) {
                    z4 = false;
                }
            } catch (Throwable th) {
                while (true) {
                    throw th;
                }
            }
        }
        return z4;
    }

    public static DummySurface newInstanceV17(Context context, boolean z4) {
        boolean z5;
        assertApiLevel17OrHigher();
        int i5 = 0;
        if (!z4 || isSecureSupported(context)) {
            z5 = true;
        } else {
            z5 = false;
        }
        Assertions.checkState(z5);
        DummySurfaceThread dummySurfaceThread = new DummySurfaceThread();
        if (z4) {
            i5 = secureMode;
        }
        return dummySurfaceThread.init(i5);
    }

    public final void release() {
        super.release();
        synchronized (this.thread) {
            try {
                if (!this.threadReleased) {
                    this.thread.release();
                    this.threadReleased = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    private DummySurface(DummySurfaceThread dummySurfaceThread, SurfaceTexture surfaceTexture, boolean z4) {
        super(surfaceTexture);
        this.thread = dummySurfaceThread;
        this.secure = z4;
    }
}
