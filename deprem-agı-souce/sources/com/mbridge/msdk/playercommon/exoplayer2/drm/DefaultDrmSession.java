package com.mbridge.msdk.playercommon.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.DefaultLoadControl;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DefaultDrmSessionEventListener;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmInitData;
import com.mbridge.msdk.playercommon.exoplayer2.drm.DrmSession;
import com.mbridge.msdk.playercommon.exoplayer2.drm.ExoMediaCrypto;
import com.mbridge.msdk.playercommon.exoplayer2.drm.ExoMediaDrm;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@TargetApi(18)
class DefaultDrmSession<T extends ExoMediaCrypto> implements DrmSession<T> {
    private static final int MAX_LICENSE_DURATION_TO_RENEW = 60;
    private static final int MSG_KEYS = 1;
    private static final int MSG_PROVISION = 0;
    private static final String TAG = "DefaultDrmSession";
    final MediaDrmCallback callback;
    private Object currentKeyRequest;
    private Object currentProvisionRequest;
    private final DefaultDrmSessionEventListener.EventDispatcher eventDispatcher;
    /* access modifiers changed from: private */
    public final int initialDrmRequestRetryCount;
    private DrmSession.DrmSessionException lastException;
    private T mediaCrypto;
    private final ExoMediaDrm<T> mediaDrm;
    private final int mode;
    private byte[] offlineLicenseKeySetId;
    private int openCount;
    private final HashMap<String, String> optionalKeyRequestParameters;
    private DefaultDrmSession<T>.PostRequestHandler postRequestHandler;
    final DefaultDrmSession<T>.PostResponseHandler postResponseHandler;
    private final ProvisioningManager<T> provisioningManager;
    private HandlerThread requestHandlerThread;
    private final DrmInitData.SchemeData schemeData;
    private byte[] sessionId;
    private int state;
    final UUID uuid;

    @SuppressLint({"HandlerLeak"})
    private class PostRequestHandler extends Handler {
        public PostRequestHandler(Looper looper) {
            super(looper);
        }

        private long getRetryDelayMillis(int i5) {
            return (long) Math.min((i5 - 1) * 1000, DefaultLoadControl.DEFAULT_BUFFER_FOR_PLAYBACK_AFTER_REBUFFER_MS);
        }

        private boolean maybeRetryRequest(Message message) {
            int i5;
            if (message.arg1 != 1 || (i5 = message.arg2 + 1) > DefaultDrmSession.this.initialDrmRequestRetryCount) {
                return false;
            }
            Message obtain = Message.obtain(message);
            obtain.arg2 = i5;
            sendMessageDelayed(obtain, getRetryDelayMillis(i5));
            return true;
        }

        public void handleMessage(Message message) {
            Object obj = message.obj;
            try {
                int i5 = message.what;
                if (i5 == 0) {
                    DefaultDrmSession defaultDrmSession = DefaultDrmSession.this;
                    e = defaultDrmSession.callback.executeProvisionRequest(defaultDrmSession.uuid, (ExoMediaDrm.ProvisionRequest) obj);
                } else if (i5 == 1) {
                    Pair pair = (Pair) obj;
                    DefaultDrmSession defaultDrmSession2 = DefaultDrmSession.this;
                    e = defaultDrmSession2.callback.executeKeyRequest(defaultDrmSession2.uuid, (ExoMediaDrm.KeyRequest) pair.first, (String) pair.second);
                } else {
                    throw new RuntimeException();
                }
            } catch (Exception e5) {
                e = e5;
                if (maybeRetryRequest(message)) {
                    return;
                }
            }
            DefaultDrmSession.this.postResponseHandler.obtainMessage(message.what, Pair.create(obj, e)).sendToTarget();
        }

        /* access modifiers changed from: package-private */
        public void post(int i5, Object obj, boolean z4) {
            obtainMessage(i5, z4 ? 1 : 0, 0, obj).sendToTarget();
        }
    }

    @SuppressLint({"HandlerLeak"})
    private class PostResponseHandler extends Handler {
        public PostResponseHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            Pair pair = (Pair) message.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i5 = message.what;
            if (i5 == 0) {
                DefaultDrmSession.this.onProvisionResponse(obj, obj2);
            } else if (i5 == 1) {
                DefaultDrmSession.this.onKeyResponse(obj, obj2);
            }
        }
    }

    public interface ProvisioningManager<T extends ExoMediaCrypto> {
        void onProvisionCompleted();

        void onProvisionError(Exception exc);

        void provisionRequired(DefaultDrmSession<T> defaultDrmSession);
    }

    public DefaultDrmSession(UUID uuid2, ExoMediaDrm<T> exoMediaDrm, ProvisioningManager<T> provisioningManager2, @Nullable DrmInitData.SchemeData schemeData2, int i5, @Nullable byte[] bArr, HashMap<String, String> hashMap, MediaDrmCallback mediaDrmCallback, Looper looper, DefaultDrmSessionEventListener.EventDispatcher eventDispatcher2, int i6) {
        this.uuid = uuid2;
        this.provisioningManager = provisioningManager2;
        this.mediaDrm = exoMediaDrm;
        this.mode = i5;
        this.offlineLicenseKeySetId = bArr;
        this.schemeData = bArr != null ? null : schemeData2;
        this.optionalKeyRequestParameters = hashMap;
        this.callback = mediaDrmCallback;
        this.initialDrmRequestRetryCount = i6;
        this.eventDispatcher = eventDispatcher2;
        this.state = 2;
        this.postResponseHandler = new PostResponseHandler(looper);
        HandlerThread handlerThread = new HandlerThread("DrmRequestHandler");
        this.requestHandlerThread = handlerThread;
        handlerThread.start();
        this.postRequestHandler = new PostRequestHandler(this.requestHandlerThread.getLooper());
    }

    private void doLicense(boolean z4) {
        int i5 = this.mode;
        if (i5 == 0 || i5 == 1) {
            if (this.offlineLicenseKeySetId == null) {
                postKeyRequest(1, z4);
            } else if (this.state == 4 || restoreKeys()) {
                long licenseDurationRemainingSec = getLicenseDurationRemainingSec();
                if (this.mode == 0 && licenseDurationRemainingSec <= 60) {
                    Log.d(TAG, "Offline license has expired or will expire soon. Remaining seconds: " + licenseDurationRemainingSec);
                    postKeyRequest(2, z4);
                } else if (licenseDurationRemainingSec <= 0) {
                    onError(new KeysExpiredException());
                } else {
                    this.state = 4;
                    this.eventDispatcher.drmKeysRestored();
                }
            }
        } else if (i5 != 2) {
            if (i5 == 3 && restoreKeys()) {
                postKeyRequest(3, z4);
            }
        } else if (this.offlineLicenseKeySetId == null) {
            postKeyRequest(2, z4);
        } else if (restoreKeys()) {
            postKeyRequest(2, z4);
        }
    }

    private long getLicenseDurationRemainingSec() {
        if (!C.WIDEVINE_UUID.equals(this.uuid)) {
            return Long.MAX_VALUE;
        }
        Pair<Long, Long> licenseDurationRemainingSec = WidevineUtil.getLicenseDurationRemainingSec(this);
        return Math.min(((Long) licenseDurationRemainingSec.first).longValue(), ((Long) licenseDurationRemainingSec.second).longValue());
    }

    private boolean isOpen() {
        int i5 = this.state;
        if (i5 == 3 || i5 == 4) {
            return true;
        }
        return false;
    }

    private void onError(Exception exc) {
        this.lastException = new DrmSession.DrmSessionException(exc);
        this.eventDispatcher.drmSessionManagerError(exc);
        if (this.state != 4) {
            this.state = 1;
        }
    }

    /* access modifiers changed from: private */
    public void onKeyResponse(Object obj, Object obj2) {
        if (obj == this.currentKeyRequest && isOpen()) {
            this.currentKeyRequest = null;
            if (obj2 instanceof Exception) {
                onKeysError((Exception) obj2);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (this.mode == 3) {
                    this.mediaDrm.provideKeyResponse(this.offlineLicenseKeySetId, bArr);
                    this.eventDispatcher.drmKeysRemoved();
                    return;
                }
                byte[] provideKeyResponse = this.mediaDrm.provideKeyResponse(this.sessionId, bArr);
                int i5 = this.mode;
                if (!((i5 != 2 && (i5 != 0 || this.offlineLicenseKeySetId == null)) || provideKeyResponse == null || provideKeyResponse.length == 0)) {
                    this.offlineLicenseKeySetId = provideKeyResponse;
                }
                this.state = 4;
                this.eventDispatcher.drmKeysLoaded();
            } catch (Exception e5) {
                onKeysError(e5);
            }
        }
    }

    private void onKeysError(Exception exc) {
        if (exc instanceof NotProvisionedException) {
            this.provisioningManager.provisionRequired(this);
        } else {
            onError(exc);
        }
    }

    private void onKeysExpired() {
        if (this.state == 4) {
            this.state = 3;
            onError(new KeysExpiredException());
        }
    }

    /* access modifiers changed from: private */
    public void onProvisionResponse(Object obj, Object obj2) {
        if (obj != this.currentProvisionRequest) {
            return;
        }
        if (this.state == 2 || isOpen()) {
            this.currentProvisionRequest = null;
            if (obj2 instanceof Exception) {
                this.provisioningManager.onProvisionError((Exception) obj2);
                return;
            }
            try {
                this.mediaDrm.provideProvisionResponse((byte[]) obj2);
                this.provisioningManager.onProvisionCompleted();
            } catch (Exception e5) {
                this.provisioningManager.onProvisionError(e5);
            }
        }
    }

    private boolean openInternal(boolean z4) {
        if (isOpen()) {
            return true;
        }
        try {
            byte[] openSession = this.mediaDrm.openSession();
            this.sessionId = openSession;
            this.mediaCrypto = this.mediaDrm.createMediaCrypto(openSession);
            this.state = 3;
            return true;
        } catch (NotProvisionedException e5) {
            if (z4) {
                this.provisioningManager.provisionRequired(this);
                return false;
            }
            onError(e5);
            return false;
        } catch (Exception e6) {
            onError(e6);
            return false;
        }
    }

    private void postKeyRequest(int i5, boolean z4) {
        byte[] bArr;
        String str;
        byte[] bArr2;
        String str2;
        if (i5 == 3) {
            bArr = this.offlineLicenseKeySetId;
        } else {
            bArr = this.sessionId;
        }
        byte[] bArr3 = bArr;
        DrmInitData.SchemeData schemeData2 = this.schemeData;
        if (schemeData2 != null) {
            byte[] bArr4 = schemeData2.data;
            String str3 = schemeData2.mimeType;
            str2 = schemeData2.licenseServerUrl;
            str = str3;
            bArr2 = bArr4;
        } else {
            str2 = null;
            bArr2 = null;
            str = null;
        }
        try {
            Pair create = Pair.create(this.mediaDrm.getKeyRequest(bArr3, bArr2, str, i5, this.optionalKeyRequestParameters), str2);
            this.currentKeyRequest = create;
            this.postRequestHandler.post(1, create, z4);
        } catch (Exception e5) {
            onKeysError(e5);
        }
    }

    private boolean restoreKeys() {
        try {
            this.mediaDrm.restoreKeys(this.sessionId, this.offlineLicenseKeySetId);
            return true;
        } catch (Exception e5) {
            Log.e(TAG, "Error trying to restore Widevine keys.", e5);
            onError(e5);
            return false;
        }
    }

    public void acquire() {
        int i5 = this.openCount + 1;
        this.openCount = i5;
        if (i5 == 1 && this.state != 1 && openInternal(true)) {
            doLicense(true);
        }
    }

    public final DrmSession.DrmSessionException getError() {
        if (this.state == 1) {
            return this.lastException;
        }
        return null;
    }

    public final T getMediaCrypto() {
        return this.mediaCrypto;
    }

    public byte[] getOfflineLicenseKeySetId() {
        return this.offlineLicenseKeySetId;
    }

    public final int getState() {
        return this.state;
    }

    public boolean hasInitData(byte[] bArr) {
        byte[] bArr2;
        DrmInitData.SchemeData schemeData2 = this.schemeData;
        if (schemeData2 != null) {
            bArr2 = schemeData2.data;
        } else {
            bArr2 = null;
        }
        return Arrays.equals(bArr2, bArr);
    }

    public boolean hasSessionId(byte[] bArr) {
        return Arrays.equals(this.sessionId, bArr);
    }

    public void onMediaDrmEvent(int i5) {
        if (isOpen()) {
            if (i5 == 1) {
                this.state = 3;
                this.provisioningManager.provisionRequired(this);
            } else if (i5 == 2) {
                doLicense(false);
            } else if (i5 == 3) {
                onKeysExpired();
            }
        }
    }

    public void onProvisionCompleted() {
        if (openInternal(false)) {
            doLicense(true);
        }
    }

    public void onProvisionError(Exception exc) {
        onError(exc);
    }

    public void provision() {
        ExoMediaDrm.ProvisionRequest provisionRequest = this.mediaDrm.getProvisionRequest();
        this.currentProvisionRequest = provisionRequest;
        this.postRequestHandler.post(0, provisionRequest, true);
    }

    public Map<String, String> queryKeyStatus() {
        byte[] bArr = this.sessionId;
        if (bArr == null) {
            return null;
        }
        return this.mediaDrm.queryKeyStatus(bArr);
    }

    public boolean release() {
        int i5 = this.openCount - 1;
        this.openCount = i5;
        if (i5 != 0) {
            return false;
        }
        this.state = 0;
        this.postResponseHandler.removeCallbacksAndMessages((Object) null);
        this.postRequestHandler.removeCallbacksAndMessages((Object) null);
        this.postRequestHandler = null;
        this.requestHandlerThread.quit();
        this.requestHandlerThread = null;
        this.mediaCrypto = null;
        this.lastException = null;
        this.currentKeyRequest = null;
        this.currentProvisionRequest = null;
        byte[] bArr = this.sessionId;
        if (bArr != null) {
            this.mediaDrm.closeSession(bArr);
            this.sessionId = null;
        }
        return true;
    }
}
