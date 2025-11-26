package androidx.sqlite.util;

import android.util.Log;
import androidx.annotation.RestrictTo;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.channels.FileChannel;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

@RestrictTo({RestrictTo.Scope.LIBRARY_GROUP})
public final class ProcessLock {
    private static final Companion Companion = new Companion((C2633k) null);
    private static final String TAG = "SupportSQLiteLock";
    /* access modifiers changed from: private */
    public static final Map<String, Lock> threadLocksMap = new HashMap();
    private FileChannel lockChannel;
    private final File lockFile;
    private final boolean processLock;
    private final Lock threadLock;

    private static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        /* access modifiers changed from: private */
        public final Lock getThreadLock(String str) {
            Lock lock;
            synchronized (ProcessLock.threadLocksMap) {
                try {
                    Map access$getThreadLocksMap$cp = ProcessLock.threadLocksMap;
                    Object obj = access$getThreadLocksMap$cp.get(str);
                    if (obj == null) {
                        obj = new ReentrantLock();
                        access$getThreadLocksMap$cp.put(str, obj);
                    }
                    lock = (Lock) obj;
                } catch (Throwable th) {
                    throw th;
                }
            }
            return lock;
        }

        private Companion() {
        }
    }

    public ProcessLock(String str, File file, boolean z4) {
        File file2;
        t.e(str, RewardPlus.NAME);
        this.processLock = z4;
        if (file != null) {
            file2 = new File(file, str + ".lck");
        } else {
            file2 = null;
        }
        this.lockFile = file2;
        this.threadLock = Companion.getThreadLock(str);
    }

    public static /* synthetic */ void lock$default(ProcessLock processLock2, boolean z4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z4 = processLock2.processLock;
        }
        processLock2.lock(z4);
    }

    public final void lock(boolean z4) {
        this.threadLock.lock();
        if (z4) {
            try {
                File file = this.lockFile;
                if (file != null) {
                    File parentFile = file.getParentFile();
                    if (parentFile != null) {
                        parentFile.mkdirs();
                    }
                    FileChannel channel = new FileOutputStream(this.lockFile).getChannel();
                    channel.lock();
                    this.lockChannel = channel;
                    return;
                }
                throw new IOException("No lock directory was provided.");
            } catch (IOException e5) {
                this.lockChannel = null;
                Log.w(TAG, "Unable to grab file lock.", e5);
            }
        }
    }

    public final void unlock() {
        try {
            FileChannel fileChannel = this.lockChannel;
            if (fileChannel != null) {
                fileChannel.close();
            }
        } catch (IOException unused) {
        }
        this.threadLock.unlock();
    }
}
