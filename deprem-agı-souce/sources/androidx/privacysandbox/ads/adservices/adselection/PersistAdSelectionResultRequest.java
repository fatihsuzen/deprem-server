package androidx.privacysandbox.ads.adservices.adselection;

import android.adservices.adselection.PersistAdSelectionResultRequest;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.collection.a;
import androidx.privacysandbox.ads.adservices.common.AdTechIdentifier;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.util.Arrays;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

@ExperimentalFeatures.Ext10OptIn
public final class PersistAdSelectionResultRequest {
    private final long adSelectionId;
    private final byte[] adSelectionResult;
    private final AdTechIdentifier seller;

    public PersistAdSelectionResultRequest(long j5) {
        this(j5, (AdTechIdentifier) null, (byte[]) null, 6, (C2633k) null);
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public final android.adservices.adselection.PersistAdSelectionResultRequest convertToAdServices$ads_adservices_release() {
        android.adservices.common.AdTechIdentifier adTechIdentifier;
        PersistAdSelectionResultRequest.Builder a5 = N.a().setAdSelectionId(this.adSelectionId);
        AdTechIdentifier adTechIdentifier2 = this.seller;
        if (adTechIdentifier2 != null) {
            adTechIdentifier = adTechIdentifier2.convertToAdServices$ads_adservices_release();
        } else {
            adTechIdentifier = null;
        }
        android.adservices.adselection.PersistAdSelectionResultRequest a6 = a5.setSeller(adTechIdentifier).setAdSelectionResult(this.adSelectionResult).build();
        t.d(a6, "Builder()\n            .s…ult)\n            .build()");
        return a6;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PersistAdSelectionResultRequest)) {
            return false;
        }
        PersistAdSelectionResultRequest persistAdSelectionResultRequest = (PersistAdSelectionResultRequest) obj;
        if (this.adSelectionId != persistAdSelectionResultRequest.adSelectionId || !t.a(this.seller, persistAdSelectionResultRequest.seller) || !Arrays.equals(this.adSelectionResult, persistAdSelectionResultRequest.adSelectionResult)) {
            return false;
        }
        return true;
    }

    public final long getAdSelectionId() {
        return this.adSelectionId;
    }

    public final byte[] getAdSelectionResult() {
        return this.adSelectionResult;
    }

    public final AdTechIdentifier getSeller() {
        return this.seller;
    }

    public int hashCode() {
        int i5;
        int a5 = a.a(this.adSelectionId) * 31;
        AdTechIdentifier adTechIdentifier = this.seller;
        int i6 = 0;
        if (adTechIdentifier != null) {
            i5 = adTechIdentifier.hashCode();
        } else {
            i5 = 0;
        }
        int i7 = (a5 + i5) * 31;
        byte[] bArr = this.adSelectionResult;
        if (bArr != null) {
            i6 = bArr.hashCode();
        }
        return i7 + i6;
    }

    public String toString() {
        return "PersistAdSelectionResultRequest: adSelectionId=" + this.adSelectionId + ", seller=" + this.seller + ", adSelectionResult=" + this.adSelectionResult;
    }

    public PersistAdSelectionResultRequest(long j5, AdTechIdentifier adTechIdentifier) {
        this(j5, adTechIdentifier, (byte[]) null, 4, (C2633k) null);
    }

    public PersistAdSelectionResultRequest(long j5, AdTechIdentifier adTechIdentifier, byte[] bArr) {
        this.adSelectionId = j5;
        this.seller = adTechIdentifier;
        this.adSelectionResult = bArr;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ PersistAdSelectionResultRequest(long j5, AdTechIdentifier adTechIdentifier, byte[] bArr, int i5, C2633k kVar) {
        this(j5, (i5 & 2) != 0 ? null : adTechIdentifier, (i5 & 4) != 0 ? null : bArr);
    }
}
