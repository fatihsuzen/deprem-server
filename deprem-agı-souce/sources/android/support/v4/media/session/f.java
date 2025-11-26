package android.support.v4.media.session;

import android.media.session.PlaybackState;
import android.os.Bundle;

abstract class f {
    public static Bundle a(Object obj) {
        return ((PlaybackState) obj).getExtras();
    }
}
