package androidx.privacysandbox.ads.adservices.topics;

import androidx.privacysandbox.ads.adservices.adid.a;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class GetTopicsRequest {
    private final String adsSdkName;
    private final boolean shouldRecordObservation;

    public static final class Builder {
        private String adsSdkName = "";
        private boolean shouldRecordObservation = true;

        public final GetTopicsRequest build() {
            return new GetTopicsRequest(this.adsSdkName, this.shouldRecordObservation);
        }

        public final Builder setAdsSdkName(String str) {
            t.e(str, "adsSdkName");
            if (str.length() > 0) {
                this.adsSdkName = str;
                return this;
            }
            throw new IllegalStateException("adsSdkName must be set");
        }

        public final Builder setShouldRecordObservation(boolean z4) {
            this.shouldRecordObservation = z4;
            return this;
        }
    }

    public GetTopicsRequest() {
        this((String) null, false, 3, (C2633k) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetTopicsRequest)) {
            return false;
        }
        GetTopicsRequest getTopicsRequest = (GetTopicsRequest) obj;
        if (!t.a(this.adsSdkName, getTopicsRequest.adsSdkName) || this.shouldRecordObservation != getTopicsRequest.shouldRecordObservation) {
            return false;
        }
        return true;
    }

    public final String getAdsSdkName() {
        return this.adsSdkName;
    }

    public int hashCode() {
        return (this.adsSdkName.hashCode() * 31) + a.a(this.shouldRecordObservation);
    }

    public final boolean shouldRecordObservation() {
        return this.shouldRecordObservation;
    }

    public String toString() {
        return "GetTopicsRequest: adsSdkName=" + this.adsSdkName + ", shouldRecordObservation=" + this.shouldRecordObservation;
    }

    public GetTopicsRequest(String str, boolean z4) {
        t.e(str, "adsSdkName");
        this.adsSdkName = str;
        this.shouldRecordObservation = z4;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetTopicsRequest(String str, boolean z4, int i5, C2633k kVar) {
        this((i5 & 1) != 0 ? "" : str, (i5 & 2) != 0 ? false : z4);
    }
}
