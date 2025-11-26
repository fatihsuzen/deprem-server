package com.mbridge.msdk.playercommon.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DefaultDrmSession;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DefaultDrmSessionEventListener;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSession;
import com.mbridge.msdk.playercommon.exoplayer2.drm.ExoMediaCrypto;
import com.mbridge.msdk.playercommon.exoplayer2.drm.ExoMediaDrm;
import com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.PsshAtomUtil;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;

@TargetApi(18)
public class DefaultDrmSessionManager<T extends ExoMediaCrypto> implements DefaultDrmSession.ProvisioningManager<T>, DrmSessionManager<T> {
    public static final int INITIAL_DRM_REQUEST_RETRY_COUNT = 3;
    public static final int MODE_DOWNLOAD = 2;
    public static final int MODE_PLAYBACK = 0;
    public static final int MODE_QUERY = 1;
    public static final int MODE_RELEASE = 3;
    public static final String PLAYREADY_CUSTOM_DATA_KEY = "PRCustomData";
    private static final String TAG = "DefaultDrmSessionMgr";
    private final MediaDrmCallback callback;
    private final DefaultDrmSessionEventListener.EventDispatcher eventDispatcher;
    private final int initialDrmRequestRetryCount;
    private final ExoMediaDrm<T> mediaDrm;
    volatile DefaultDrmSessionManager<T>.MediaDrmHandler mediaDrmHandler;
    /* access modifiers changed from: private */
    public int mode;
    private final boolean multiSession;
    private byte[] offlineLicenseKeySetId;
    private final HashMap<String, String> optionalKeyRequestParameters;
    private Looper playbackLooper;
    private final List<DefaultDrmSession<T>> provisioningSessions;
    /* access modifiers changed from: private */
    public final List<DefaultDrmSession<T>> sessions;
    private final UUID uuid;

    @Deprecated
    public interface EventListener extends DefaultDrmSessionEventListener {
    }

    private class MediaDrmEventListener implements ExoMediaDrm.OnEventListener<T> {
        private MediaDrmEventListener() {
        }

        public void onEvent(ExoMediaDrm<? extends T> exoMediaDrm, byte[] bArr, int i5, int i6, byte[] bArr2) {
            if (DefaultDrmSessionManager.this.mode == 0) {
                DefaultDrmSessionManager.this.mediaDrmHandler.obtainMessage(i5, bArr).sendToTarget();
            }
        }
    }

    @SuppressLint({"HandlerLeak"})
    private class MediaDrmHandler extends Handler {
        public MediaDrmHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            for (DefaultDrmSession defaultDrmSession : DefaultDrmSessionManager.this.sessions) {
                if (defaultDrmSession.hasSessionId(bArr)) {
                    defaultDrmSession.onMediaDrmEvent(message.what);
                    return;
                }
            }
        }
    }

    public static final class MissingSchemeDataException extends Exception {
        private MissingSchemeDataException(UUID uuid) {
            super("Media does not support uuid: " + uuid);
        }
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface Mode {
    }

    @Deprecated
    public DefaultDrmSessionManager(UUID uuid2, ExoMediaDrm<T> exoMediaDrm, MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap, Handler handler, DefaultDrmSessionEventListener defaultDrmSessionEventListener) {
        this(uuid2, exoMediaDrm, mediaDrmCallback, hashMap);
        if (handler != null && defaultDrmSessionEventListener != null) {
            addListener(handler, defaultDrmSessionEventListener);
        }
    }

    private static DrmInitData.SchemeData getSchemeData(DrmInitData drmInitData, UUID uuid2, boolean z4) {
        int i5;
        ArrayList arrayList = new ArrayList(drmInitData.schemeDataCount);
        for (int i6 = 0; i6 < drmInitData.schemeDataCount; i6++) {
            DrmInitData.SchemeData schemeData = drmInitData.get(i6);
            if ((schemeData.matches(uuid2) || (C.CLEARKEY_UUID.equals(uuid2) && schemeData.matches(C.COMMON_PSSH_UUID))) && (schemeData.data != null || z4)) {
                arrayList.add(schemeData);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        if (C.WIDEVINE_UUID.equals(uuid2)) {
            for (int i7 = 0; i7 < arrayList.size(); i7++) {
                DrmInitData.SchemeData schemeData2 = (DrmInitData.SchemeData) arrayList.get(i7);
                if (schemeData2.hasData()) {
                    i5 = PsshAtomUtil.parseVersion(schemeData2.data);
                } else {
                    i5 = -1;
                }
                int i8 = Util.SDK_INT;
                if ((i8 < 23 && i5 == 0) || (i8 >= 23 && i5 == 1)) {
                    return schemeData2;
                }
            }
        }
        return (DrmInitData.SchemeData) arrayList.get(0);
    }

    @Deprecated
    public static DefaultDrmSessionManager<FrameworkMediaCrypto> newFrameworkInstance(UUID uuid2, MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap, Handler handler, DefaultDrmSessionEventListener defaultDrmSessionEventListener) throws UnsupportedDrmException {
        DefaultDrmSessionManager<FrameworkMediaCrypto> newFrameworkInstance = newFrameworkInstance(uuid2, mediaDrmCallback, hashMap);
        if (!(handler == null || defaultDrmSessionEventListener == null)) {
            newFrameworkInstance.addListener(handler, defaultDrmSessionEventListener);
        }
        return newFrameworkInstance;
    }

    @Deprecated
    public static DefaultDrmSessionManager<FrameworkMediaCrypto> newPlayReadyInstance(MediaDrmCallback mediaDrmCallback, String str, Handler handler, DefaultDrmSessionEventListener defaultDrmSessionEventListener) throws UnsupportedDrmException {
        DefaultDrmSessionManager<FrameworkMediaCrypto> newPlayReadyInstance = newPlayReadyInstance(mediaDrmCallback, str);
        if (!(handler == null || defaultDrmSessionEventListener == null)) {
            newPlayReadyInstance.addListener(handler, defaultDrmSessionEventListener);
        }
        return newPlayReadyInstance;
    }

    @Deprecated
    public static DefaultDrmSessionManager<FrameworkMediaCrypto> newWidevineInstance(MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap, Handler handler, DefaultDrmSessionEventListener defaultDrmSessionEventListener) throws UnsupportedDrmException {
        DefaultDrmSessionManager<FrameworkMediaCrypto> newWidevineInstance = newWidevineInstance(mediaDrmCallback, hashMap);
        if (!(handler == null || defaultDrmSessionEventListener == null)) {
            newWidevineInstance.addListener(handler, defaultDrmSessionEventListener);
        }
        return newWidevineInstance;
    }

    public DrmSession<T> acquireSession(Looper looper, DrmInitData drmInitData) {
        boolean z4;
        DrmInitData.SchemeData schemeData;
        byte[] bArr;
        Looper looper2 = this.playbackLooper;
        if (looper2 == null || looper2 == looper) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkState(z4);
        if (this.sessions.isEmpty()) {
            this.playbackLooper = looper;
            if (this.mediaDrmHandler == null) {
                this.mediaDrmHandler = new MediaDrmHandler(looper);
            }
        }
        DefaultDrmSession defaultDrmSession = null;
        if (this.offlineLicenseKeySetId == null) {
            DrmInitData.SchemeData schemeData2 = getSchemeData(drmInitData, this.uuid, false);
            if (schemeData2 == null) {
                MissingSchemeDataException missingSchemeDataException = new MissingSchemeDataException(this.uuid);
                this.eventDispatcher.drmSessionManagerError(missingSchemeDataException);
                return new ErrorStateDrmSession(new DrmSession.DrmSessionException(missingSchemeDataException));
            }
            schemeData = schemeData2;
        } else {
            schemeData = null;
        }
        if (this.multiSession) {
            if (schemeData != null) {
                bArr = schemeData.data;
            } else {
                bArr = null;
            }
            Iterator<DefaultDrmSession<T>> it = this.sessions.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                DefaultDrmSession next = it.next();
                if (next.hasInitData(bArr)) {
                    defaultDrmSession = next;
                    break;
                }
            }
        } else if (!this.sessions.isEmpty()) {
            defaultDrmSession = this.sessions.get(0);
        }
        if (defaultDrmSession == null) {
            DefaultDrmSession defaultDrmSession2 = new DefaultDrmSession(this.uuid, this.mediaDrm, this, schemeData, this.mode, this.offlineLicenseKeySetId, this.optionalKeyRequestParameters, this.callback, looper, this.eventDispatcher, this.initialDrmRequestRetryCount);
            this.sessions.add(defaultDrmSession2);
            defaultDrmSession = defaultDrmSession2;
        }
        defaultDrmSession.acquire();
        return defaultDrmSession;
    }

    public final void addListener(Handler handler, DefaultDrmSessionEventListener defaultDrmSessionEventListener) {
        this.eventDispatcher.addListener(handler, defaultDrmSessionEventListener);
    }

    public boolean canAcquireSession(@NonNull DrmInitData drmInitData) {
        if (this.offlineLicenseKeySetId != null) {
            return true;
        }
        if (getSchemeData(drmInitData, this.uuid, true) == null) {
            if (drmInitData.schemeDataCount != 1 || !drmInitData.get(0).matches(C.COMMON_PSSH_UUID)) {
                return false;
            }
            Log.w(TAG, "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.uuid);
        }
        String str = drmInitData.schemeType;
        if (str == null || C.CENC_TYPE_cenc.equals(str)) {
            return true;
        }
        if ((C.CENC_TYPE_cbc1.equals(str) || C.CENC_TYPE_cbcs.equals(str) || C.CENC_TYPE_cens.equals(str)) && Util.SDK_INT < 25) {
            return false;
        }
        return true;
    }

    public final byte[] getPropertyByteArray(String str) {
        return this.mediaDrm.getPropertyByteArray(str);
    }

    public final String getPropertyString(String str) {
        return this.mediaDrm.getPropertyString(str);
    }

    public void onProvisionCompleted() {
        for (DefaultDrmSession<T> onProvisionCompleted : this.provisioningSessions) {
            onProvisionCompleted.onProvisionCompleted();
        }
        this.provisioningSessions.clear();
    }

    public void onProvisionError(Exception exc) {
        for (DefaultDrmSession<T> onProvisionError : this.provisioningSessions) {
            onProvisionError.onProvisionError(exc);
        }
        this.provisioningSessions.clear();
    }

    public void provisionRequired(DefaultDrmSession<T> defaultDrmSession) {
        this.provisioningSessions.add(defaultDrmSession);
        if (this.provisioningSessions.size() == 1) {
            defaultDrmSession.provision();
        }
    }

    public void releaseSession(DrmSession<T> drmSession) {
        if (!(drmSession instanceof ErrorStateDrmSession)) {
            DefaultDrmSession<T> defaultDrmSession = (DefaultDrmSession) drmSession;
            if (defaultDrmSession.release()) {
                this.sessions.remove(defaultDrmSession);
                if (this.provisioningSessions.size() > 1 && this.provisioningSessions.get(0) == defaultDrmSession) {
                    this.provisioningSessions.get(1).provision();
                }
                this.provisioningSessions.remove(defaultDrmSession);
            }
        }
    }

    public final void removeListener(DefaultDrmSessionEventListener defaultDrmSessionEventListener) {
        this.eventDispatcher.removeListener(defaultDrmSessionEventListener);
    }

    public void setMode(int i5, byte[] bArr) {
        Assertions.checkState(this.sessions.isEmpty());
        if (i5 == 1 || i5 == 3) {
            Assertions.checkNotNull(bArr);
        }
        this.mode = i5;
        this.offlineLicenseKeySetId = bArr;
    }

    public final void setPropertyByteArray(String str, byte[] bArr) {
        this.mediaDrm.setPropertyByteArray(str, bArr);
    }

    public final void setPropertyString(String str, String str2) {
        this.mediaDrm.setPropertyString(str, str2);
    }

    public DefaultDrmSessionManager(UUID uuid2, ExoMediaDrm<T> exoMediaDrm, MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap) {
        this(uuid2, exoMediaDrm, mediaDrmCallback, hashMap, false, 3);
    }

    public static DefaultDrmSessionManager<FrameworkMediaCrypto> newFrameworkInstance(UUID uuid2, MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap) throws UnsupportedDrmException {
        return new DefaultDrmSessionManager<>(uuid2, FrameworkMediaDrm.newInstance(uuid2), mediaDrmCallback, hashMap, false, 3);
    }

    public static DefaultDrmSessionManager<FrameworkMediaCrypto> newPlayReadyInstance(MediaDrmCallback mediaDrmCallback, String str) throws UnsupportedDrmException {
        HashMap hashMap;
        if (!TextUtils.isEmpty(str)) {
            hashMap = new HashMap();
            hashMap.put(PLAYREADY_CUSTOM_DATA_KEY, str);
        } else {
            hashMap = null;
        }
        return newFrameworkInstance(C.PLAYREADY_UUID, mediaDrmCallback, hashMap);
    }

    public static DefaultDrmSessionManager<FrameworkMediaCrypto> newWidevineInstance(MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap) throws UnsupportedDrmException {
        return newFrameworkInstance(C.WIDEVINE_UUID, mediaDrmCallback, hashMap);
    }

    @Deprecated
    public DefaultDrmSessionManager(UUID uuid2, ExoMediaDrm<T> exoMediaDrm, MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap, Handler handler, DefaultDrmSessionEventListener defaultDrmSessionEventListener, boolean z4) {
        this(uuid2, exoMediaDrm, mediaDrmCallback, hashMap, z4);
        if (handler != null && defaultDrmSessionEventListener != null) {
            addListener(handler, defaultDrmSessionEventListener);
        }
    }

    public DefaultDrmSessionManager(UUID uuid2, ExoMediaDrm<T> exoMediaDrm, MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap, boolean z4) {
        this(uuid2, exoMediaDrm, mediaDrmCallback, hashMap, z4, 3);
    }

    @Deprecated
    public DefaultDrmSessionManager(UUID uuid2, ExoMediaDrm<T> exoMediaDrm, MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap, Handler handler, DefaultDrmSessionEventListener defaultDrmSessionEventListener, boolean z4, int i5) {
        this(uuid2, exoMediaDrm, mediaDrmCallback, hashMap, z4, i5);
        if (handler != null && defaultDrmSessionEventListener != null) {
            addListener(handler, defaultDrmSessionEventListener);
        }
    }

    public DefaultDrmSessionManager(UUID uuid2, ExoMediaDrm<T> exoMediaDrm, MediaDrmCallback mediaDrmCallback, HashMap<String, String> hashMap, boolean z4, int i5) {
        Assertions.checkNotNull(uuid2);
        Assertions.checkNotNull(exoMediaDrm);
        Assertions.checkArgument(!C.COMMON_PSSH_UUID.equals(uuid2), "Use C.CLEARKEY_UUID instead");
        this.uuid = uuid2;
        this.mediaDrm = exoMediaDrm;
        this.callback = mediaDrmCallback;
        this.optionalKeyRequestParameters = hashMap;
        this.eventDispatcher = new DefaultDrmSessionEventListener.EventDispatcher();
        this.multiSession = z4;
        this.initialDrmRequestRetryCount = i5;
        this.mode = 0;
        this.sessions = new ArrayList();
        this.provisioningSessions = new ArrayList();
        if (z4) {
            exoMediaDrm.setPropertyString("sessionSharing", "enable");
        }
        exoMediaDrm.setOnEventListener(new MediaDrmEventListener());
    }
}
