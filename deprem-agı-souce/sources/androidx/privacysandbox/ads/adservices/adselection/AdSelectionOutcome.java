package androidx.privacysandbox.ads.adservices.adselection;

import android.annotation.SuppressLint;
import android.net.Uri;
import androidx.collection.a;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

@SuppressLint({"ClassVerificationFailure"})
public final class AdSelectionOutcome {
    public static final Companion Companion = new Companion((C2633k) null);
    public static final AdSelectionOutcome NO_OUTCOME;
    private final long adSelectionId;
    private final Uri renderUri;

    @ExperimentalFeatures.Ext10OptIn
    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        @ExperimentalFeatures.Ext10OptIn
        public static /* synthetic */ void getNO_OUTCOME$annotations() {
        }

        private Companion() {
        }
    }

    static {
        Uri uri = Uri.EMPTY;
        t.d(uri, "EMPTY");
        NO_OUTCOME = new AdSelectionOutcome(0, uri);
    }

    public AdSelectionOutcome(long j5, Uri uri) {
        t.e(uri, "renderUri");
        this.adSelectionId = j5;
        this.renderUri = uri;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AdSelectionOutcome)) {
            return false;
        }
        AdSelectionOutcome adSelectionOutcome = (AdSelectionOutcome) obj;
        if (this.adSelectionId != adSelectionOutcome.adSelectionId || !t.a(this.renderUri, adSelectionOutcome.renderUri)) {
            return false;
        }
        return true;
    }

    public final long getAdSelectionId() {
        return this.adSelectionId;
    }

    public final Uri getRenderUri() {
        return this.renderUri;
    }

    @ExperimentalFeatures.Ext10OptIn
    public final boolean hasOutcome() {
        return !t.a(this, NO_OUTCOME);
    }

    public int hashCode() {
        return (a.a(this.adSelectionId) * 31) + this.renderUri.hashCode();
    }

    public String toString() {
        return "AdSelectionOutcome: adSelectionId=" + this.adSelectionId + ", renderUri=" + this.renderUri;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    @androidx.annotation.RequiresExtension.Container({@androidx.annotation.RequiresExtension(extension = 1000000, version = 4), @androidx.annotation.RequiresExtension(extension = 31, version = 9)})
    @androidx.annotation.RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public AdSelectionOutcome(android.adservices.adselection.AdSelectionOutcome r4) {
        /*
            r3 = this;
            java.lang.String r0 = "response"
            kotlin.jvm.internal.t.e(r4, r0)
            long r0 = r4.getAdSelectionId()
            android.net.Uri r4 = r4.getRenderUri()
            java.lang.String r2 = "response.renderUri"
            kotlin.jvm.internal.t.d(r4, r2)
            r3.<init>(r0, r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.adselection.AdSelectionOutcome.<init>(android.adservices.adselection.AdSelectionOutcome):void");
    }
}
