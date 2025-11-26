package androidx.privacysandbox.ads.adservices.common;

import android.adservices.common.AdFilters;
import android.adservices.common.FrequencyCapFilters;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import kotlin.jvm.internal.t;

@ExperimentalFeatures.Ext8OptIn
public final class AdFilters {
    private final FrequencyCapFilters frequencyCapFilters;

    public AdFilters(FrequencyCapFilters frequencyCapFilters2) {
        this.frequencyCapFilters = frequencyCapFilters2;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 8), @RequiresExtension(extension = 31, version = 9)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.common.AdFilters convertToAdServices$ads_adservices_release() {
        FrequencyCapFilters frequencyCapFilters2;
        AdFilters.Builder a5 = j.a();
        FrequencyCapFilters frequencyCapFilters3 = this.frequencyCapFilters;
        if (frequencyCapFilters3 != null) {
            frequencyCapFilters2 = frequencyCapFilters3.convertToAdServices$ads_adservices_release();
        } else {
            frequencyCapFilters2 = null;
        }
        android.adservices.common.AdFilters a6 = a5.setFrequencyCapFilters(frequencyCapFilters2).build();
        t.d(a6, "Builder()\n            .s…s())\n            .build()");
        return a6;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdFilters)) {
            return false;
        }
        return t.a(this.frequencyCapFilters, ((AdFilters) obj).frequencyCapFilters);
    }

    public final FrequencyCapFilters getFrequencyCapFilters() {
        return this.frequencyCapFilters;
    }

    public int hashCode() {
        FrequencyCapFilters frequencyCapFilters2 = this.frequencyCapFilters;
        if (frequencyCapFilters2 != null) {
            return frequencyCapFilters2.hashCode();
        }
        return 0;
    }

    public String toString() {
        return "AdFilters: frequencyCapFilters=" + this.frequencyCapFilters;
    }
}
