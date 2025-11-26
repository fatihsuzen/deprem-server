package com.mbridge.msdk.playercommon.exoplayer2.drm;

import android.annotation.TargetApi;
import android.media.MediaCrypto;
import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;

@TargetApi(16)
public final class FrameworkMediaCrypto implements ExoMediaCrypto {
    private final boolean forceAllowInsecureDecoderComponents;
    private final MediaCrypto mediaCrypto;

    public FrameworkMediaCrypto(MediaCrypto mediaCrypto2) {
        this(mediaCrypto2, false);
    }

    public final MediaCrypto getWrappedMediaCrypto() {
        return this.mediaCrypto;
    }

    public final boolean requiresSecureDecoderComponent(String str) {
        if (this.forceAllowInsecureDecoderComponents || !this.mediaCrypto.requiresSecureDecoderComponent(str)) {
            return false;
        }
        return true;
    }

    public FrameworkMediaCrypto(MediaCrypto mediaCrypto2, boolean z4) {
        this.mediaCrypto = (MediaCrypto) Assertions.checkNotNull(mediaCrypto2);
        this.forceAllowInsecureDecoderComponents = z4;
    }
}
