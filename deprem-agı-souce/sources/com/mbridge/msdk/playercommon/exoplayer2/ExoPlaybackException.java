package com.mbridge.msdk.playercommon.exoplayer2;

import com.mbridge.msdk.playercommon.exoplayer2.util.Assertions;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public final class ExoPlaybackException extends Exception {
    public static final int TYPE_RENDERER = 1;
    public static final int TYPE_SOURCE = 0;
    public static final int TYPE_UNEXPECTED = 2;
    public final int rendererIndex;
    public final int type;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Type {
    }

    private ExoPlaybackException(int i5, String str, Throwable th, int i6) {
        super(str, th);
        this.type = i5;
        this.rendererIndex = i6;
    }

    public static ExoPlaybackException createForRenderer(Exception exc, int i5) {
        return new ExoPlaybackException(1, (String) null, exc, i5);
    }

    public static ExoPlaybackException createForSource(IOException iOException) {
        return new ExoPlaybackException(0, (String) null, iOException, -1);
    }

    static ExoPlaybackException createForUnexpected(RuntimeException runtimeException) {
        return new ExoPlaybackException(2, (String) null, runtimeException, -1);
    }

    public final Exception getRendererException() {
        boolean z4 = true;
        if (this.type != 1) {
            z4 = false;
        }
        Assertions.checkState(z4);
        return (Exception) getCause();
    }

    public final IOException getSourceException() {
        boolean z4;
        if (this.type == 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkState(z4);
        return (IOException) getCause();
    }

    public final RuntimeException getUnexpectedException() {
        boolean z4;
        if (this.type == 2) {
            z4 = true;
        } else {
            z4 = false;
        }
        Assertions.checkState(z4);
        return (RuntimeException) getCause();
    }
}
