package androidx.work;

import android.util.Log;
import androidx.annotation.RestrictTo;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public abstract class Logger {
    private static final int MAX_PREFIXED_TAG_LENGTH = 20;
    private static final int MAX_TAG_LENGTH = 23;
    private static final String TAG_PREFIX = "WM-";
    private static final Object sLock = new Object();
    private static volatile Logger sLogger;

    public Logger(int i5) {
    }

    public static Logger get() {
        Logger logger;
        synchronized (sLock) {
            try {
                if (sLogger == null) {
                    sLogger = new LogcatLogger(3);
                }
                logger = sLogger;
            } catch (Throwable th) {
                throw th;
            }
        }
        return logger;
    }

    public static void setLogger(Logger logger) {
        synchronized (sLock) {
            try {
                if (sLogger == null) {
                    sLogger = logger;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public static String tagWithPrefix(String str) {
        int length = str.length();
        StringBuilder sb = new StringBuilder(23);
        sb.append(TAG_PREFIX);
        int i5 = MAX_PREFIXED_TAG_LENGTH;
        if (length >= i5) {
            sb.append(str.substring(0, i5));
        } else {
            sb.append(str);
        }
        return sb.toString();
    }

    public abstract void debug(String str, String str2);

    public abstract void debug(String str, String str2, Throwable th);

    public abstract void error(String str, String str2);

    public abstract void error(String str, String str2, Throwable th);

    public abstract void info(String str, String str2);

    public abstract void info(String str, String str2, Throwable th);

    public abstract void verbose(String str, String str2);

    public abstract void verbose(String str, String str2, Throwable th);

    public abstract void warning(String str, String str2);

    public abstract void warning(String str, String str2, Throwable th);

    public static class LogcatLogger extends Logger {
        private final int mLoggingLevel;

        public LogcatLogger(int i5) {
            super(i5);
            this.mLoggingLevel = i5;
        }

        public void debug(String str, String str2) {
            if (this.mLoggingLevel <= 3) {
                Log.d(str, str2);
            }
        }

        public void error(String str, String str2) {
            if (this.mLoggingLevel <= 6) {
                Log.e(str, str2);
            }
        }

        public void info(String str, String str2) {
            if (this.mLoggingLevel <= 4) {
                Log.i(str, str2);
            }
        }

        public void verbose(String str, String str2) {
            if (this.mLoggingLevel <= 2) {
                Log.v(str, str2);
            }
        }

        public void warning(String str, String str2) {
            if (this.mLoggingLevel <= 5) {
                Log.w(str, str2);
            }
        }

        public void debug(String str, String str2, Throwable th) {
            if (this.mLoggingLevel <= 3) {
                Log.d(str, str2, th);
            }
        }

        public void error(String str, String str2, Throwable th) {
            if (this.mLoggingLevel <= 6) {
                Log.e(str, str2, th);
            }
        }

        public void info(String str, String str2, Throwable th) {
            if (this.mLoggingLevel <= 4) {
                Log.i(str, str2, th);
            }
        }

        public void verbose(String str, String str2, Throwable th) {
            if (this.mLoggingLevel <= 2) {
                Log.v(str, str2, th);
            }
        }

        public void warning(String str, String str2, Throwable th) {
            if (this.mLoggingLevel <= 5) {
                Log.w(str, str2, th);
            }
        }
    }
}
