package androidx.privacysandbox.ads.adservices.adselection;

import android.annotation.SuppressLint;
import android.util.Log;
import android.view.InputEvent;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.collection.a;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import androidx.privacysandbox.ads.adservices.internal.AdServicesInfo;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

@ExperimentalFeatures.Ext8OptIn
public final class ReportEventRequest {
    public static final Companion Companion = new Companion((C2633k) null);
    public static final int FLAG_REPORTING_DESTINATION_BUYER = 2;
    public static final int FLAG_REPORTING_DESTINATION_SELLER = 1;
    private final long adSelectionId;
    private final String eventData;
    private final String eventKey;
    private final InputEvent inputEvent;
    private final int reportingDestinations;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        private Companion() {
        }
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    private static final class Ext10Impl {
        public static final Companion Companion = new Companion((C2633k) null);

        public static final class Companion {
            public /* synthetic */ Companion(C2633k kVar) {
                this();
            }

            public final android.adservices.adselection.ReportEventRequest convertReportEventRequest(ReportEventRequest reportEventRequest) {
                t.e(reportEventRequest, "request");
                S.a();
                android.adservices.adselection.ReportEventRequest a5 = Q.a(reportEventRequest.getAdSelectionId(), reportEventRequest.getEventKey(), reportEventRequest.getEventData(), reportEventRequest.getReportingDestinations()).setInputEvent(reportEventRequest.getInputEvent()).build();
                t.d(a5, "Builder(\n               …                 .build()");
                return a5;
            }

            private Companion() {
            }
        }

        private Ext10Impl() {
        }
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 8), @RequiresExtension(extension = 31, version = 9)})
    private static final class Ext8Impl {
        public static final Companion Companion = new Companion((C2633k) null);

        public static final class Companion {
            public /* synthetic */ Companion(C2633k kVar) {
                this();
            }

            public final android.adservices.adselection.ReportEventRequest convertReportEventRequest(ReportEventRequest reportEventRequest) {
                t.e(reportEventRequest, "request");
                if (reportEventRequest.getInputEvent() != null) {
                    Log.w("ReportEventRequest", "inputEvent is ignored. Min version to use inputEvent is API 31 ext 10");
                }
                S.a();
                android.adservices.adselection.ReportEventRequest a5 = Q.a(reportEventRequest.getAdSelectionId(), reportEventRequest.getEventKey(), reportEventRequest.getEventData(), reportEventRequest.getReportingDestinations()).build();
                t.d(a5, "Builder(\n               …                 .build()");
                return a5;
            }

            private Companion() {
            }
        }

        private Ext8Impl() {
        }
    }

    @RestrictTo({RestrictTo.Scope.LIBRARY})
    @Retention(RetentionPolicy.SOURCE)
    public @interface ReportingDestination {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ReportEventRequest(long j5, String str, String str2, int i5) {
        this(j5, str, str2, i5, (InputEvent) null, 16, (C2633k) null);
        t.e(str, "eventKey");
        t.e(str2, "eventData");
    }

    @ExperimentalFeatures.Ext10OptIn
    public static /* synthetic */ void getInputEvent$annotations() {
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 8), @RequiresExtension(extension = 31, version = 9)})
    @SuppressLint({"NewApi"})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.adselection.ReportEventRequest convertToAdServices$ads_adservices_release() {
        AdServicesInfo adServicesInfo = AdServicesInfo.INSTANCE;
        if (adServicesInfo.adServicesVersion() >= 10 || adServicesInfo.extServicesVersionS() >= 10) {
            return Ext10Impl.Companion.convertReportEventRequest(this);
        }
        return Ext8Impl.Companion.convertReportEventRequest(this);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ReportEventRequest)) {
            return false;
        }
        ReportEventRequest reportEventRequest = (ReportEventRequest) obj;
        if (this.adSelectionId != reportEventRequest.adSelectionId || !t.a(this.eventKey, reportEventRequest.eventKey) || !t.a(this.eventData, reportEventRequest.eventData) || this.reportingDestinations != reportEventRequest.reportingDestinations || !t.a(this.inputEvent, reportEventRequest.inputEvent)) {
            return false;
        }
        return true;
    }

    public final long getAdSelectionId() {
        return this.adSelectionId;
    }

    public final String getEventData() {
        return this.eventData;
    }

    public final String getEventKey() {
        return this.eventKey;
    }

    public final InputEvent getInputEvent() {
        return this.inputEvent;
    }

    public final int getReportingDestinations() {
        return this.reportingDestinations;
    }

    public int hashCode() {
        int i5;
        int a5 = ((((((a.a(this.adSelectionId) * 31) + this.eventKey.hashCode()) * 31) + this.eventData.hashCode()) * 31) + this.reportingDestinations) * 31;
        InputEvent inputEvent2 = this.inputEvent;
        if (inputEvent2 != null) {
            i5 = inputEvent2.hashCode();
        } else {
            i5 = 0;
        }
        return a5 + i5;
    }

    public String toString() {
        return "ReportEventRequest: adSelectionId=" + this.adSelectionId + ", eventKey=" + this.eventKey + ", eventData=" + this.eventData + ", reportingDestinations=" + this.reportingDestinations + "inputEvent=" + this.inputEvent;
    }

    public ReportEventRequest(long j5, String str, String str2, int i5, InputEvent inputEvent2) {
        t.e(str, "eventKey");
        t.e(str2, "eventData");
        this.adSelectionId = j5;
        this.eventKey = str;
        this.eventData = str2;
        this.reportingDestinations = i5;
        this.inputEvent = inputEvent2;
        if (i5 <= 0 || i5 > 3) {
            throw new IllegalArgumentException("Invalid reporting destinations bitfield.");
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ReportEventRequest(long j5, String str, String str2, int i5, InputEvent inputEvent2, int i6, C2633k kVar) {
        this(j5, str, str2, i5, (i6 & 16) != 0 ? null : inputEvent2);
    }
}
