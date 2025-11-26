package androidx.profileinstaller;

import android.content.res.AssetManager;
import android.os.Build;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RestrictTo;
import androidx.profileinstaller.ProfileInstaller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;
import java.util.concurrent.Executor;

@RestrictTo({RestrictTo.Scope.LIBRARY})
public class DeviceProfileWriter {
    @NonNull
    private final String mApkName;
    @NonNull
    private final AssetManager mAssetManager;
    @NonNull
    private final File mCurProfile;
    @Nullable
    private final byte[] mDesiredVersion;
    private boolean mDeviceSupportsAotProfile = false;
    @NonNull
    private final ProfileInstaller.DiagnosticsCallback mDiagnostics;
    @NonNull
    private final Executor mExecutor;
    @Nullable
    private DexProfileData[] mProfile;
    @NonNull
    private final String mProfileMetaSourceLocation;
    @NonNull
    private final String mProfileSourceLocation;
    @Nullable
    private byte[] mTranscodedProfile;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public DeviceProfileWriter(@NonNull AssetManager assetManager, @NonNull Executor executor, @NonNull ProfileInstaller.DiagnosticsCallback diagnosticsCallback, @NonNull String str, @NonNull String str2, @NonNull String str3, @NonNull File file) {
        this.mAssetManager = assetManager;
        this.mExecutor = executor;
        this.mDiagnostics = diagnosticsCallback;
        this.mApkName = str;
        this.mProfileSourceLocation = str2;
        this.mProfileMetaSourceLocation = str3;
        this.mCurProfile = file;
        this.mDesiredVersion = desiredVersion();
    }

    @Nullable
    private DeviceProfileWriter addMetadata(DexProfileData[] dexProfileDataArr, byte[] bArr) {
        InputStream openStreamFromAssets;
        try {
            openStreamFromAssets = openStreamFromAssets(this.mAssetManager, this.mProfileMetaSourceLocation);
            if (openStreamFromAssets != null) {
                this.mProfile = ProfileTranscoder.readMeta(openStreamFromAssets, ProfileTranscoder.readHeader(openStreamFromAssets, ProfileTranscoder.MAGIC_PROFM), bArr, dexProfileDataArr);
                openStreamFromAssets.close();
                return this;
            }
            if (openStreamFromAssets != null) {
                openStreamFromAssets.close();
            }
            return null;
        } catch (FileNotFoundException e5) {
            this.mDiagnostics.onResultReceived(9, e5);
        } catch (IOException e6) {
            this.mDiagnostics.onResultReceived(7, e6);
        } catch (IllegalStateException e7) {
            this.mProfile = null;
            this.mDiagnostics.onResultReceived(8, e7);
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private void assertDeviceAllowsProfileInstallerAotWritesCalled() {
        if (!this.mDeviceSupportsAotProfile) {
            throw new IllegalStateException("This device doesn't support aot. Did you call deviceSupportsAotProfile()?");
        }
    }

    @Nullable
    private static byte[] desiredVersion() {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 < 24) {
            return null;
        }
        if (i5 >= 31) {
            return ProfileVersion.V015_S;
        }
        switch (i5) {
            case 24:
            case 25:
                return ProfileVersion.V001_N;
            case 26:
                return ProfileVersion.V005_O;
            case 27:
                return ProfileVersion.V009_O_MR1;
            case 28:
            case 29:
            case 30:
                return ProfileVersion.V010_P;
            default:
                return null;
        }
    }

    @Nullable
    private InputStream getProfileInputStream(AssetManager assetManager) {
        try {
            return openStreamFromAssets(assetManager, this.mProfileSourceLocation);
        } catch (FileNotFoundException e5) {
            this.mDiagnostics.onResultReceived(6, e5);
            return null;
        } catch (IOException e6) {
            this.mDiagnostics.onResultReceived(7, e6);
            return null;
        }
    }

    @Nullable
    private InputStream openStreamFromAssets(AssetManager assetManager, String str) throws IOException {
        try {
            return assetManager.openFd(str).createInputStream();
        } catch (FileNotFoundException e5) {
            String message = e5.getMessage();
            if (message != null && message.contains("compressed")) {
                this.mDiagnostics.onDiagnosticReceived(5, (Object) null);
            }
            return null;
        }
    }

    @Nullable
    private DexProfileData[] readProfileInternal(InputStream inputStream) {
        try {
            DexProfileData[] readProfile = ProfileTranscoder.readProfile(inputStream, ProfileTranscoder.readHeader(inputStream, ProfileTranscoder.MAGIC_PROF), this.mApkName);
            try {
                inputStream.close();
                return readProfile;
            } catch (IOException e5) {
                this.mDiagnostics.onResultReceived(7, e5);
                return readProfile;
            }
        } catch (IOException e6) {
            this.mDiagnostics.onResultReceived(7, e6);
            try {
                inputStream.close();
            } catch (IOException e7) {
                this.mDiagnostics.onResultReceived(7, e7);
            }
            return null;
        } catch (IllegalStateException e8) {
            this.mDiagnostics.onResultReceived(8, e8);
            inputStream.close();
            return null;
        } catch (Throwable th) {
            try {
                inputStream.close();
            } catch (IOException e9) {
                this.mDiagnostics.onResultReceived(7, e9);
            }
            throw th;
        }
    }

    private static boolean requiresMetadata() {
        int i5 = Build.VERSION.SDK_INT;
        if (i5 < 24) {
            return false;
        }
        if (i5 >= 31 || i5 == 24 || i5 == 25) {
            return true;
        }
        return false;
    }

    private void result(int i5, @Nullable Object obj) {
        this.mExecutor.execute(new b(this, i5, obj));
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean deviceAllowsProfileInstallerAotWrites() {
        if (this.mDesiredVersion == null) {
            result(3, Integer.valueOf(Build.VERSION.SDK_INT));
            return false;
        }
        if (!this.mCurProfile.exists()) {
            try {
                if (!this.mCurProfile.createNewFile()) {
                    result(4, (Object) null);
                    return false;
                }
            } catch (IOException unused) {
                result(4, (Object) null);
                return false;
            }
        } else if (!this.mCurProfile.canWrite()) {
            result(4, (Object) null);
            return false;
        }
        this.mDeviceSupportsAotProfile = true;
        return true;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public DeviceProfileWriter read() {
        DeviceProfileWriter addMetadata;
        assertDeviceAllowsProfileInstallerAotWritesCalled();
        if (this.mDesiredVersion != null) {
            InputStream profileInputStream = getProfileInputStream(this.mAssetManager);
            if (profileInputStream != null) {
                this.mProfile = readProfileInternal(profileInputStream);
            }
            DexProfileData[] dexProfileDataArr = this.mProfile;
            if (dexProfileDataArr == null || !requiresMetadata() || (addMetadata = addMetadata(dexProfileDataArr, this.mDesiredVersion)) == null) {
                return this;
            }
            return addMetadata;
        }
        return this;
    }

    @NonNull
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public DeviceProfileWriter transcodeIfNeeded() {
        ByteArrayOutputStream byteArrayOutputStream;
        DexProfileData[] dexProfileDataArr = this.mProfile;
        byte[] bArr = this.mDesiredVersion;
        if (!(dexProfileDataArr == null || bArr == null)) {
            assertDeviceAllowsProfileInstallerAotWritesCalled();
            try {
                byteArrayOutputStream = new ByteArrayOutputStream();
                ProfileTranscoder.writeHeader(byteArrayOutputStream, bArr);
                if (!ProfileTranscoder.transcodeAndWriteBody(byteArrayOutputStream, bArr, dexProfileDataArr)) {
                    this.mDiagnostics.onResultReceived(5, (Object) null);
                    this.mProfile = null;
                    byteArrayOutputStream.close();
                    return this;
                }
                this.mTranscodedProfile = byteArrayOutputStream.toByteArray();
                byteArrayOutputStream.close();
                this.mProfile = null;
            } catch (IOException e5) {
                this.mDiagnostics.onResultReceived(7, e5);
            } catch (IllegalStateException e6) {
                this.mDiagnostics.onResultReceived(8, e6);
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        return this;
        throw th;
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public boolean write() {
        ByteArrayInputStream byteArrayInputStream;
        FileChannel channel;
        FileLock tryLock;
        byte[] bArr = this.mTranscodedProfile;
        if (bArr == null) {
            return false;
        }
        assertDeviceAllowsProfileInstallerAotWritesCalled();
        try {
            byteArrayInputStream = new ByteArrayInputStream(bArr);
            FileOutputStream fileOutputStream = new FileOutputStream(this.mCurProfile);
            try {
                channel = fileOutputStream.getChannel();
                tryLock = channel.tryLock();
                Encoding.writeAll(byteArrayInputStream, fileOutputStream, tryLock);
                result(1, (Object) null);
                if (tryLock != null) {
                    tryLock.close();
                }
                channel.close();
                fileOutputStream.close();
                byteArrayInputStream.close();
                this.mTranscodedProfile = null;
                this.mProfile = null;
                return true;
            } catch (Throwable th) {
                fileOutputStream.close();
                throw th;
            }
        } catch (FileNotFoundException e5) {
            result(6, e5);
            this.mTranscodedProfile = null;
            this.mProfile = null;
            return false;
        } catch (IOException e6) {
            result(7, e6);
            this.mTranscodedProfile = null;
            this.mProfile = null;
            return false;
        } catch (Throwable th2) {
            this.mTranscodedProfile = null;
            this.mProfile = null;
            throw th2;
        }
        throw th;
        throw th;
        throw th;
    }
}
