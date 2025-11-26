package androidx.privacysandbox.ads.adservices.common;

import android.adservices.common.KeyedFrequencyCap;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import j$.time.Duration;
import j$.time.TimeConversions;
import kotlin.jvm.internal.t;

@ExperimentalFeatures.Ext8OptIn
public final class KeyedFrequencyCap {
    private final int adCounterKey;
    private final Duration interval;
    private final int maxCount;

    public KeyedFrequencyCap(int i5, int i6, Duration duration) {
        t.e(duration, "interval");
        this.adCounterKey = i5;
        this.maxCount = i6;
        this.interval = duration;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 8), @RequiresExtension(extension = 31, version = 9)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.common.KeyedFrequencyCap convertToAdServices$ads_adservices_release() {
        android.adservices.common.KeyedFrequencyCap a5 = new KeyedFrequencyCap.Builder(this.adCounterKey, this.maxCount, TimeConversions.convert(this.interval)).build();
        t.d(a5, "Builder(adCounterKey, ma…val)\n            .build()");
        return a5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeyedFrequencyCap)) {
            return false;
        }
        KeyedFrequencyCap keyedFrequencyCap = (KeyedFrequencyCap) obj;
        if (this.adCounterKey == keyedFrequencyCap.adCounterKey && this.maxCount == keyedFrequencyCap.maxCount && t.a(this.interval, keyedFrequencyCap.interval)) {
            return true;
        }
        return false;
    }

    public final int getAdCounterKey() {
        return this.adCounterKey;
    }

    public final Duration getInterval() {
        return this.interval;
    }

    public final int getMaxCount() {
        return this.maxCount;
    }

    public int hashCode() {
        return (((this.adCounterKey * 31) + this.maxCount) * 31) + this.interval.hashCode();
    }

    public String toString() {
        return "KeyedFrequencyCap: adCounterKey=" + this.adCounterKey + ", maxCount=" + this.maxCount + ", interval=" + this.interval;
    }
}
