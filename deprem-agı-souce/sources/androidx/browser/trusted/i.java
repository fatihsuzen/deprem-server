package androidx.browser.trusted;

import android.os.Bundle;
import androidx.browser.trusted.TrustedWebActivityDisplayMode;

public abstract /* synthetic */ class i {
    public static TrustedWebActivityDisplayMode a(Bundle bundle) {
        if (bundle.getInt(TrustedWebActivityDisplayMode.KEY_ID) != 1) {
            return new TrustedWebActivityDisplayMode.DefaultMode();
        }
        return TrustedWebActivityDisplayMode.ImmersiveMode.fromBundle(bundle);
    }
}
