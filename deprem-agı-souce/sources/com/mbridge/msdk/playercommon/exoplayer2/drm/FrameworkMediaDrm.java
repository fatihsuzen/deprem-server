package com.mbridge.msdk.playercommon.exoplayer2.drm;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.DeniedByServerException;
import android.media.MediaCrypto;
import android.media.MediaCryptoException;
import android.media.MediaDrm;
import android.media.MediaDrmException;
import android.media.NotProvisionedException;
import android.media.UnsupportedSchemeException;
import android.os.Handler;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import com.mbridge.msdk.playercommon.exoplayer2.drm.ExoMediaDrm;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import com.mbridge.msdk.playercommon.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@TargetApi(23)
public final class FrameworkMediaDrm implements ExoMediaDrm<FrameworkMediaCrypto> {
    private static final String CENC_SCHEME_MIME_TYPE = "cenc";
    private final MediaDrm mediaDrm;
    private final UUID uuid;

    @SuppressLint({"WrongConstant"})
    private FrameworkMediaDrm(UUID uuid2) throws UnsupportedSchemeException {
        Assertions.checkNotNull(uuid2);
        UUID uuid3 = C.COMMON_PSSH_UUID;
        Assertions.checkArgument(!uuid3.equals(uuid2), "Use C.CLEARKEY_UUID instead");
        if (Util.SDK_INT < 27 && C.CLEARKEY_UUID.equals(uuid2)) {
            uuid2 = uuid3;
        }
        this.uuid = uuid2;
        MediaDrm mediaDrm2 = new MediaDrm(uuid2);
        this.mediaDrm = mediaDrm2;
        if (C.WIDEVINE_UUID.equals(uuid2) && needsForceL3Workaround()) {
            mediaDrm2.setPropertyString("securityLevel", "L3");
        }
    }

    private static boolean needsForceL3Workaround() {
        return "ASUS_Z00AD".equals(Util.MODEL);
    }

    public static FrameworkMediaDrm newInstance(UUID uuid2) throws UnsupportedDrmException {
        try {
            return new FrameworkMediaDrm(uuid2);
        } catch (UnsupportedSchemeException e5) {
            throw new UnsupportedDrmException(1, e5);
        } catch (Exception e6) {
            throw new UnsupportedDrmException(2, e6);
        }
    }

    public final void closeSession(byte[] bArr) {
        this.mediaDrm.closeSession(bArr);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003c, code lost:
        if ("AFTM".equals(r1) == false) goto L_0x0049;
     */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0082  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.mbridge.msdk.playercommon.exoplayer2.drm.ExoMediaDrm.KeyRequest getKeyRequest(byte[] r9, byte[] r10, java.lang.String r11, int r12, java.util.HashMap<java.lang.String, java.lang.String> r13) throws android.media.NotProvisionedException {
        /*
            r8 = this;
            int r0 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.SDK_INT
            r1 = 21
            if (r0 >= r1) goto L_0x0010
            java.util.UUID r1 = com.mbridge.msdk.playercommon.exoplayer2.C.WIDEVINE_UUID
            java.util.UUID r2 = r8.uuid
            boolean r1 = r1.equals(r2)
            if (r1 != 0) goto L_0x003e
        L_0x0010:
            java.util.UUID r1 = com.mbridge.msdk.playercommon.exoplayer2.C.PLAYREADY_UUID
            java.util.UUID r2 = r8.uuid
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0049
            java.lang.String r1 = "Amazon"
            java.lang.String r2 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.MANUFACTURER
            boolean r1 = r1.equals(r2)
            if (r1 == 0) goto L_0x0049
            java.lang.String r1 = com.mbridge.msdk.playercommon.exoplayer2.util.Util.MODEL
            java.lang.String r2 = "AFTB"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x003e
            java.lang.String r2 = "AFTS"
            boolean r2 = r2.equals(r1)
            if (r2 != 0) goto L_0x003e
            java.lang.String r2 = "AFTM"
            boolean r1 = r2.equals(r1)
            if (r1 == 0) goto L_0x0049
        L_0x003e:
            java.util.UUID r1 = r8.uuid
            byte[] r1 = com.mbridge.msdk.playercommon.exoplayer2.extractor.mp4.PsshAtomUtil.parseSchemeSpecificData(r10, r1)
            if (r1 != 0) goto L_0x0047
            goto L_0x0049
        L_0x0047:
            r4 = r1
            goto L_0x004a
        L_0x0049:
            r4 = r10
        L_0x004a:
            r10 = 26
            if (r0 >= r10) goto L_0x006a
            java.util.UUID r10 = com.mbridge.msdk.playercommon.exoplayer2.C.CLEARKEY_UUID
            java.util.UUID r0 = r8.uuid
            boolean r10 = r10.equals(r0)
            if (r10 == 0) goto L_0x006a
            java.lang.String r10 = "video/mp4"
            boolean r10 = r10.equals(r11)
            if (r10 != 0) goto L_0x0068
            java.lang.String r10 = "audio/mp4"
            boolean r10 = r10.equals(r11)
            if (r10 == 0) goto L_0x006a
        L_0x0068:
            java.lang.String r11 = "cenc"
        L_0x006a:
            r5 = r11
            android.media.MediaDrm r2 = r8.mediaDrm
            r3 = r9
            r6 = r12
            r7 = r13
            android.media.MediaDrm$KeyRequest r9 = r2.getKeyRequest(r3, r4, r5, r6, r7)
            byte[] r10 = r9.getData()
            java.util.UUID r11 = com.mbridge.msdk.playercommon.exoplayer2.C.CLEARKEY_UUID
            java.util.UUID r12 = r8.uuid
            boolean r11 = r11.equals(r12)
            if (r11 == 0) goto L_0x0086
            byte[] r10 = com.mbridge.msdk.playercommon.exoplayer2.drm.ClearKeyUtil.adjustRequestData(r10)
        L_0x0086:
            com.mbridge.msdk.playercommon.exoplayer2.drm.ExoMediaDrm$DefaultKeyRequest r11 = new com.mbridge.msdk.playercommon.exoplayer2.drm.ExoMediaDrm$DefaultKeyRequest
            java.lang.String r9 = r9.getDefaultUrl()
            r11.<init>(r10, r9)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.playercommon.exoplayer2.drm.FrameworkMediaDrm.getKeyRequest(byte[], byte[], java.lang.String, int, java.util.HashMap):com.mbridge.msdk.playercommon.exoplayer2.drm.ExoMediaDrm$KeyRequest");
    }

    public final byte[] getPropertyByteArray(String str) {
        return this.mediaDrm.getPropertyByteArray(str);
    }

    public final String getPropertyString(String str) {
        return this.mediaDrm.getPropertyString(str);
    }

    public final ExoMediaDrm.ProvisionRequest getProvisionRequest() {
        MediaDrm.ProvisionRequest provisionRequest = this.mediaDrm.getProvisionRequest();
        return new ExoMediaDrm.DefaultProvisionRequest(provisionRequest.getData(), provisionRequest.getDefaultUrl());
    }

    public final byte[] openSession() throws MediaDrmException {
        return this.mediaDrm.openSession();
    }

    public final byte[] provideKeyResponse(byte[] bArr, byte[] bArr2) throws NotProvisionedException, DeniedByServerException {
        if (C.CLEARKEY_UUID.equals(this.uuid)) {
            bArr2 = ClearKeyUtil.adjustResponseData(bArr2);
        }
        return this.mediaDrm.provideKeyResponse(bArr, bArr2);
    }

    public final void provideProvisionResponse(byte[] bArr) throws DeniedByServerException {
        this.mediaDrm.provideProvisionResponse(bArr);
    }

    public final Map<String, String> queryKeyStatus(byte[] bArr) {
        return this.mediaDrm.queryKeyStatus(bArr);
    }

    public final void release() {
        this.mediaDrm.release();
    }

    public final void restoreKeys(byte[] bArr, byte[] bArr2) {
        this.mediaDrm.restoreKeys(bArr, bArr2);
    }

    public final void setOnEventListener(final ExoMediaDrm.OnEventListener<? super FrameworkMediaCrypto> onEventListener) {
        AnonymousClass1 r32;
        MediaDrm mediaDrm2 = this.mediaDrm;
        if (onEventListener == null) {
            r32 = null;
        } else {
            r32 = new MediaDrm.OnEventListener() {
                public void onEvent(@NonNull MediaDrm mediaDrm, @Nullable byte[] bArr, int i5, int i6, byte[] bArr2) {
                    onEventListener.onEvent(FrameworkMediaDrm.this, bArr, i5, i6, bArr2);
                }
            };
        }
        mediaDrm2.setOnEventListener(r32);
    }

    public final void setOnKeyStatusChangeListener(final ExoMediaDrm.OnKeyStatusChangeListener<? super FrameworkMediaCrypto> onKeyStatusChangeListener) {
        AnonymousClass2 r22;
        if (Util.SDK_INT >= 23) {
            MediaDrm mediaDrm2 = this.mediaDrm;
            if (onKeyStatusChangeListener == null) {
                r22 = null;
            } else {
                r22 = new MediaDrm.OnKeyStatusChangeListener() {
                    public void onKeyStatusChange(@NonNull MediaDrm mediaDrm, @NonNull byte[] bArr, @NonNull List<MediaDrm.KeyStatus> list, boolean z4) {
                        ArrayList arrayList = new ArrayList();
                        for (MediaDrm.KeyStatus next : list) {
                            arrayList.add(new ExoMediaDrm.DefaultKeyStatus(next.getStatusCode(), next.getKeyId()));
                        }
                        onKeyStatusChangeListener.onKeyStatusChange(FrameworkMediaDrm.this, bArr, arrayList, z4);
                    }
                };
            }
            mediaDrm2.setOnKeyStatusChangeListener(r22, (Handler) null);
            return;
        }
        throw new UnsupportedOperationException();
    }

    public final void setPropertyByteArray(String str, byte[] bArr) {
        this.mediaDrm.setPropertyByteArray(str, bArr);
    }

    public final void setPropertyString(String str, String str2) {
        this.mediaDrm.setPropertyString(str, str2);
    }

    public final FrameworkMediaCrypto createMediaCrypto(byte[] bArr) throws MediaCryptoException {
        return new FrameworkMediaCrypto(new MediaCrypto(this.uuid, bArr), Util.SDK_INT < 21 && C.WIDEVINE_UUID.equals(this.uuid) && "L3".equals(getPropertyString("securityLevel")));
    }
}
