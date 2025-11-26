package androidx.privacysandbox.ads.adservices.common;

import X2.C2250q;
import android.adservices.common.KeyedFrequencyCap;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

@ExperimentalFeatures.Ext8OptIn
public final class FrequencyCapFilters {
    public static final int AD_EVENT_TYPE_CLICK = 3;
    public static final int AD_EVENT_TYPE_IMPRESSION = 1;
    public static final int AD_EVENT_TYPE_VIEW = 2;
    public static final int AD_EVENT_TYPE_WIN = 0;
    public static final Companion Companion = new Companion((C2633k) null);
    private final List<KeyedFrequencyCap> keyedFrequencyCapsForClickEvents;
    private final List<KeyedFrequencyCap> keyedFrequencyCapsForImpressionEvents;
    private final List<KeyedFrequencyCap> keyedFrequencyCapsForViewEvents;
    private final List<KeyedFrequencyCap> keyedFrequencyCapsForWinEvents;

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface AdEventType {
    }

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        private Companion() {
        }
    }

    public FrequencyCapFilters() {
        this((List) null, (List) null, (List) null, (List) null, 15, (C2633k) null);
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 8), @RequiresExtension(extension = 31, version = 9)})
    private final List<KeyedFrequencyCap> convertToAdServices(List<KeyedFrequencyCap> list) {
        ArrayList arrayList = new ArrayList();
        for (KeyedFrequencyCap convertToAdServices$ads_adservices_release : list) {
            arrayList.add(convertToAdServices$ads_adservices_release.convertToAdServices$ads_adservices_release());
        }
        return arrayList;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 8), @RequiresExtension(extension = 31, version = 9)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.common.FrequencyCapFilters convertToAdServices$ads_adservices_release() {
        android.adservices.common.FrequencyCapFilters a5 = r.a().setKeyedFrequencyCapsForWinEvents(convertToAdServices(this.keyedFrequencyCapsForWinEvents)).setKeyedFrequencyCapsForImpressionEvents(convertToAdServices(this.keyedFrequencyCapsForImpressionEvents)).setKeyedFrequencyCapsForViewEvents(convertToAdServices(this.keyedFrequencyCapsForViewEvents)).setKeyedFrequencyCapsForClickEvents(convertToAdServices(this.keyedFrequencyCapsForClickEvents)).build();
        t.d(a5, "Builder()\n            .s…   )\n            .build()");
        return a5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FrequencyCapFilters)) {
            return false;
        }
        FrequencyCapFilters frequencyCapFilters = (FrequencyCapFilters) obj;
        if (!t.a(this.keyedFrequencyCapsForWinEvents, frequencyCapFilters.keyedFrequencyCapsForWinEvents) || !t.a(this.keyedFrequencyCapsForImpressionEvents, frequencyCapFilters.keyedFrequencyCapsForImpressionEvents) || !t.a(this.keyedFrequencyCapsForViewEvents, frequencyCapFilters.keyedFrequencyCapsForViewEvents) || !t.a(this.keyedFrequencyCapsForClickEvents, frequencyCapFilters.keyedFrequencyCapsForClickEvents)) {
            return false;
        }
        return true;
    }

    public final List<KeyedFrequencyCap> getKeyedFrequencyCapsForClickEvents() {
        return this.keyedFrequencyCapsForClickEvents;
    }

    public final List<KeyedFrequencyCap> getKeyedFrequencyCapsForImpressionEvents() {
        return this.keyedFrequencyCapsForImpressionEvents;
    }

    public final List<KeyedFrequencyCap> getKeyedFrequencyCapsForViewEvents() {
        return this.keyedFrequencyCapsForViewEvents;
    }

    public final List<KeyedFrequencyCap> getKeyedFrequencyCapsForWinEvents() {
        return this.keyedFrequencyCapsForWinEvents;
    }

    public int hashCode() {
        return (((((this.keyedFrequencyCapsForWinEvents.hashCode() * 31) + this.keyedFrequencyCapsForImpressionEvents.hashCode()) * 31) + this.keyedFrequencyCapsForViewEvents.hashCode()) * 31) + this.keyedFrequencyCapsForClickEvents.hashCode();
    }

    public String toString() {
        return "FrequencyCapFilters: keyedFrequencyCapsForWinEvents=" + this.keyedFrequencyCapsForWinEvents + ", keyedFrequencyCapsForImpressionEvents=" + this.keyedFrequencyCapsForImpressionEvents + ", keyedFrequencyCapsForViewEvents=" + this.keyedFrequencyCapsForViewEvents + ", keyedFrequencyCapsForClickEvents=" + this.keyedFrequencyCapsForClickEvents;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FrequencyCapFilters(List<KeyedFrequencyCap> list) {
        this(list, (List) null, (List) null, (List) null, 14, (C2633k) null);
        t.e(list, "keyedFrequencyCapsForWinEvents");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FrequencyCapFilters(List<KeyedFrequencyCap> list, List<KeyedFrequencyCap> list2) {
        this(list, list2, (List) null, (List) null, 12, (C2633k) null);
        t.e(list, "keyedFrequencyCapsForWinEvents");
        t.e(list2, "keyedFrequencyCapsForImpressionEvents");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FrequencyCapFilters(List<KeyedFrequencyCap> list, List<KeyedFrequencyCap> list2, List<KeyedFrequencyCap> list3) {
        this(list, list2, list3, (List) null, 8, (C2633k) null);
        t.e(list, "keyedFrequencyCapsForWinEvents");
        t.e(list2, "keyedFrequencyCapsForImpressionEvents");
        t.e(list3, "keyedFrequencyCapsForViewEvents");
    }

    public FrequencyCapFilters(List<KeyedFrequencyCap> list, List<KeyedFrequencyCap> list2, List<KeyedFrequencyCap> list3, List<KeyedFrequencyCap> list4) {
        t.e(list, "keyedFrequencyCapsForWinEvents");
        t.e(list2, "keyedFrequencyCapsForImpressionEvents");
        t.e(list3, "keyedFrequencyCapsForViewEvents");
        t.e(list4, "keyedFrequencyCapsForClickEvents");
        this.keyedFrequencyCapsForWinEvents = list;
        this.keyedFrequencyCapsForImpressionEvents = list2;
        this.keyedFrequencyCapsForViewEvents = list3;
        this.keyedFrequencyCapsForClickEvents = list4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FrequencyCapFilters(List list, List list2, List list3, List list4, int i5, C2633k kVar) {
        this((i5 & 1) != 0 ? C2250q.g() : list, (i5 & 2) != 0 ? C2250q.g() : list2, (i5 & 4) != 0 ? C2250q.g() : list3, (i5 & 8) != 0 ? C2250q.g() : list4);
    }
}
