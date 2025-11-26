package androidx.privacysandbox.ads.adservices.adselection;

import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.collection.a;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.util.Arrays;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

@ExperimentalFeatures.Ext10OptIn
public final class GetAdSelectionDataOutcome {
    private final byte[] adSelectionData;
    private final long adSelectionId;

    public GetAdSelectionDataOutcome(long j5) {
        this(j5, (byte[]) null, 2, (C2633k) null);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetAdSelectionDataOutcome)) {
            return false;
        }
        GetAdSelectionDataOutcome getAdSelectionDataOutcome = (GetAdSelectionDataOutcome) obj;
        if (this.adSelectionId != getAdSelectionDataOutcome.adSelectionId || !Arrays.equals(this.adSelectionData, getAdSelectionDataOutcome.adSelectionData)) {
            return false;
        }
        return true;
    }

    public final byte[] getAdSelectionData() {
        return this.adSelectionData;
    }

    public final long getAdSelectionId() {
        return this.adSelectionId;
    }

    public int hashCode() {
        int i5;
        int a5 = a.a(this.adSelectionId) * 31;
        byte[] bArr = this.adSelectionData;
        if (bArr != null) {
            i5 = bArr.hashCode();
        } else {
            i5 = 0;
        }
        return a5 + i5;
    }

    public String toString() {
        return "GetAdSelectionDataOutcome: adSelectionId=" + this.adSelectionId + ", adSelectionData=" + this.adSelectionData;
    }

    public GetAdSelectionDataOutcome(long j5, byte[] bArr) {
        this.adSelectionId = j5;
        this.adSelectionData = bArr;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ GetAdSelectionDataOutcome(long j5, byte[] bArr, int i5, C2633k kVar) {
        this(j5, (i5 & 2) != 0 ? null : bArr);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 10), @RequiresExtension(extension = 31, version = 10)})
    @RestrictTo({RestrictTo.Scope.LIBRARY})
    public GetAdSelectionDataOutcome(android.adservices.adselection.GetAdSelectionDataOutcome getAdSelectionDataOutcome) {
        this(getAdSelectionDataOutcome.getAdSelectionId(), getAdSelectionDataOutcome.getAdSelectionData());
        t.e(getAdSelectionDataOutcome, "response");
    }
}
