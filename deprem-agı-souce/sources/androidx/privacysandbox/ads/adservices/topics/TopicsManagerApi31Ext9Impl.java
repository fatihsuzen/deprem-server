package androidx.privacysandbox.ads.adservices.topics;

import android.adservices.topics.GetTopicsRequest;
import android.annotation.SuppressLint;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import kotlin.jvm.internal.t;

@RequiresExtension(extension = 31, version = 9)
@SuppressLint({"NewApi", "ClassVerificationFailure"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class TopicsManagerApi31Ext9Impl extends TopicsManagerImplCommon {
    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TopicsManagerApi31Ext9Impl(android.content.Context r2) {
        /*
            r1 = this;
            java.lang.String r0 = "context"
            kotlin.jvm.internal.t.e(r2, r0)
            android.adservices.topics.TopicsManager r2 = android.adservices.topics.TopicsManager.get(r2)
            java.lang.String r0 = "get(context)"
            kotlin.jvm.internal.t.d(r2, r0)
            r1.<init>(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.privacysandbox.ads.adservices.topics.TopicsManagerApi31Ext9Impl.<init>(android.content.Context):void");
    }

    public GetTopicsRequest convertRequest$ads_adservices_release(GetTopicsRequest getTopicsRequest) {
        t.e(getTopicsRequest, "request");
        return GetTopicsRequestHelper.INSTANCE.convertRequestWithRecordObservation$ads_adservices_release(getTopicsRequest);
    }
}
