package androidx.privacysandbox.ads.adservices.common;

import android.annotation.SuppressLint;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import kotlin.jvm.internal.t;

@SuppressLint({"ClassVerificationFailure"})
public final class AdSelectionSignals {
    private final String signals;

    public AdSelectionSignals(String str) {
        t.e(str, "signals");
        this.signals = str;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.common.AdSelectionSignals convertToAdServices$ads_adservices_release() {
        android.adservices.common.AdSelectionSignals a5 = android.adservices.common.AdSelectionSignals.fromString(this.signals);
        t.d(a5, "fromString(signals)");
        return a5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdSelectionSignals)) {
            return false;
        }
        return t.a(this.signals, ((AdSelectionSignals) obj).signals);
    }

    public final String getSignals() {
        return this.signals;
    }

    public int hashCode() {
        return this.signals.hashCode();
    }

    public String toString() {
        return "AdSelectionSignals: " + this.signals;
    }
}
