package androidx.profileinstaller;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetFileDescriptor;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.RestrictTo;
import androidx.annotation.WorkerThread;
import androidx.concurrent.futures.ResolvableFuture;
import j$.util.Objects;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import n0.C1722d;

public final class ProfileVerifier {
    private static final String CUR_PROFILES_BASE_DIR = "/data/misc/profiles/cur/0/";
    private static final String PROFILE_FILE_NAME = "primary.prof";
    private static final String PROFILE_INSTALLED_CACHE_FILE_NAME = "profileInstalled";
    private static final String REF_PROFILES_BASE_DIR = "/data/misc/profiles/ref/";
    private static final Object SYNC_OBJ = new Object();
    private static final String TAG = "ProfileVerifier";
    @Nullable
    private static CompilationStatus sCompilationStatus = null;
    private static final ResolvableFuture<CompilationStatus> sFuture = ResolvableFuture.create();

    @RequiresApi(33)
    private static class Api33Impl {
        private Api33Impl() {
        }

        static PackageInfo getPackageInfo(PackageManager packageManager, Context context) throws PackageManager.NameNotFoundException {
            return packageManager.getPackageInfo(context.getPackageName(), PackageManager.PackageInfoFlags.of(0));
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    static class Cache {
        private static final int SCHEMA = 1;
        final long mInstalledCurrentProfileSize;
        final long mPackageLastUpdateTime;
        final int mResultCode;
        final int mSchema;

        Cache(int i5, int i6, long j5, long j6) {
            this.mSchema = i5;
            this.mResultCode = i6;
            this.mPackageLastUpdateTime = j5;
            this.mInstalledCurrentProfileSize = j6;
        }

        static Cache readFromFile(@NonNull File file) throws IOException {
            Throwable th;
            DataInputStream dataInputStream = new DataInputStream(new FileInputStream(file));
            try {
                Cache cache = new Cache(dataInputStream.readInt(), dataInputStream.readInt(), dataInputStream.readLong(), dataInputStream.readLong());
                dataInputStream.close();
                return cache;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && (obj instanceof Cache)) {
                Cache cache = (Cache) obj;
                if (this.mResultCode == cache.mResultCode && this.mPackageLastUpdateTime == cache.mPackageLastUpdateTime && this.mSchema == cache.mSchema && this.mInstalledCurrentProfileSize == cache.mInstalledCurrentProfileSize) {
                    return true;
                }
                return false;
            }
            return false;
        }

        public int hashCode() {
            return Objects.hash(Integer.valueOf(this.mResultCode), Long.valueOf(this.mPackageLastUpdateTime), Integer.valueOf(this.mSchema), Long.valueOf(this.mInstalledCurrentProfileSize));
        }

        /* access modifiers changed from: package-private */
        public void writeOnFile(@NonNull File file) throws IOException {
            file.delete();
            DataOutputStream dataOutputStream = new DataOutputStream(new FileOutputStream(file));
            try {
                dataOutputStream.writeInt(this.mSchema);
                dataOutputStream.writeInt(this.mResultCode);
                dataOutputStream.writeLong(this.mPackageLastUpdateTime);
                dataOutputStream.writeLong(this.mInstalledCurrentProfileSize);
                dataOutputStream.close();
                return;
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
            throw th;
        }
    }

    public static class CompilationStatus {
        public static final int RESULT_CODE_COMPILED_WITH_PROFILE = 1;
        public static final int RESULT_CODE_COMPILED_WITH_PROFILE_NON_MATCHING = 3;
        public static final int RESULT_CODE_ERROR_CACHE_FILE_EXISTS_BUT_CANNOT_BE_READ = 131072;
        public static final int RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE = 196608;
        private static final int RESULT_CODE_ERROR_CODE_BIT_SHIFT = 16;
        public static final int RESULT_CODE_ERROR_NO_PROFILE_EMBEDDED = 327680;
        public static final int RESULT_CODE_ERROR_PACKAGE_NAME_DOES_NOT_EXIST = 65536;
        public static final int RESULT_CODE_ERROR_UNSUPPORTED_API_VERSION = 262144;
        @Deprecated
        public static final int RESULT_CODE_NO_PROFILE = 0;
        public static final int RESULT_CODE_NO_PROFILE_INSTALLED = 0;
        public static final int RESULT_CODE_PROFILE_ENQUEUED_FOR_COMPILATION = 2;
        private final boolean mHasCurrentProfile;
        private final boolean mHasEmbeddedProfile;
        private final boolean mHasReferenceProfile;
        final int mResultCode;

        @RestrictTo({RestrictTo.Scope.LIBRARY})
        @Retention(RetentionPolicy.SOURCE)
        public @interface ResultCode {
        }

        CompilationStatus(int i5, boolean z4, boolean z5, boolean z6) {
            this.mResultCode = i5;
            this.mHasCurrentProfile = z5;
            this.mHasReferenceProfile = z4;
            this.mHasEmbeddedProfile = z6;
        }

        public boolean appApkHasEmbeddedProfile() {
            return this.mHasEmbeddedProfile;
        }

        public int getProfileInstallResultCode() {
            return this.mResultCode;
        }

        public boolean hasProfileEnqueuedForCompilation() {
            return this.mHasCurrentProfile;
        }

        public boolean isCompiledWithProfile() {
            return this.mHasReferenceProfile;
        }
    }

    private ProfileVerifier() {
    }

    @NonNull
    public static C1722d getCompilationStatusAsync() {
        return sFuture;
    }

    private static long getPackageLastUpdateTime(Context context) throws PackageManager.NameNotFoundException {
        PackageManager packageManager = context.getApplicationContext().getPackageManager();
        if (Build.VERSION.SDK_INT >= 33) {
            return Api33Impl.getPackageInfo(packageManager, context).lastUpdateTime;
        }
        return packageManager.getPackageInfo(context.getPackageName(), 0).lastUpdateTime;
    }

    private static CompilationStatus setCompilationStatus(int i5, boolean z4, boolean z5, boolean z6) {
        CompilationStatus compilationStatus = new CompilationStatus(i5, z4, z5, z6);
        sCompilationStatus = compilationStatus;
        sFuture.set(compilationStatus);
        return sCompilationStatus;
    }

    @WorkerThread
    @NonNull
    public static CompilationStatus writeProfileVerification(@NonNull Context context) {
        return writeProfileVerification(context, false);
    }

    @WorkerThread
    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    static CompilationStatus writeProfileVerification(@NonNull Context context, boolean z4) {
        boolean z5;
        Cache cache;
        Cache cache2;
        AssetFileDescriptor openFd;
        Throwable th;
        CompilationStatus compilationStatus;
        if (!z4 && (compilationStatus = sCompilationStatus) != null) {
            return compilationStatus;
        }
        synchronized (SYNC_OBJ) {
            if (!z4) {
                CompilationStatus compilationStatus2 = sCompilationStatus;
                if (compilationStatus2 != null) {
                    return compilationStatus2;
                }
            }
            int i5 = 0;
            try {
                openFd = context.getAssets().openFd("dexopt/baseline.prof");
                z5 = openFd.getLength() > 0;
                openFd.close();
            } catch (IOException unused) {
                z5 = false;
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            int i6 = Build.VERSION.SDK_INT;
            if (i6 >= 28) {
                if (i6 != 30) {
                    File file = new File(new File(REF_PROFILES_BASE_DIR, context.getPackageName()), PROFILE_FILE_NAME);
                    long length = file.length();
                    boolean z6 = file.exists() && length > 0;
                    File file2 = new File(new File(CUR_PROFILES_BASE_DIR, context.getPackageName()), PROFILE_FILE_NAME);
                    long length2 = file2.length();
                    boolean z7 = file2.exists() && length2 > 0;
                    try {
                        long packageLastUpdateTime = getPackageLastUpdateTime(context);
                        File file3 = new File(context.getFilesDir(), PROFILE_INSTALLED_CACHE_FILE_NAME);
                        if (file3.exists()) {
                            try {
                                cache = Cache.readFromFile(file3);
                            } catch (IOException unused2) {
                                return setCompilationStatus(131072, z6, z7, z5);
                            }
                        } else {
                            cache = null;
                        }
                        if (cache != null && cache.mPackageLastUpdateTime == packageLastUpdateTime) {
                            int i7 = cache.mResultCode;
                            if (i7 != 2) {
                                i5 = i7;
                                if (z4 && z7 && i5 != 1) {
                                    i5 = 2;
                                }
                                if (cache != null && cache.mResultCode == 2 && i5 == 1 && length < cache.mInstalledCurrentProfileSize) {
                                    i5 = 3;
                                }
                                int i8 = i5;
                                cache2 = new Cache(1, i8, packageLastUpdateTime, length2);
                                if (cache == null || !cache.equals(cache2)) {
                                    cache2.writeOnFile(file3);
                                }
                                CompilationStatus compilationStatus3 = setCompilationStatus(i8, z6, z7, z5);
                                return compilationStatus3;
                            }
                        }
                        if (!z5) {
                            i5 = CompilationStatus.RESULT_CODE_ERROR_NO_PROFILE_EMBEDDED;
                        } else if (z6) {
                            i5 = 1;
                        } else if (z7) {
                            i5 = 2;
                        }
                        i5 = 2;
                        i5 = 3;
                        int i82 = i5;
                        cache2 = new Cache(1, i82, packageLastUpdateTime, length2);
                        try {
                            cache2.writeOnFile(file3);
                        } catch (IOException unused3) {
                            i82 = CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                        }
                        CompilationStatus compilationStatus32 = setCompilationStatus(i82, z6, z7, z5);
                        return compilationStatus32;
                    } catch (PackageManager.NameNotFoundException unused4) {
                        return setCompilationStatus(65536, z6, z7, z5);
                    }
                }
            }
            CompilationStatus compilationStatus4 = setCompilationStatus(262144, false, false, z5);
            return compilationStatus4;
        }
        throw th;
    }
}
