package androidx.privacysandbox.ads.adservices.topics;

import android.adservices.topics.GetTopicsRequest;
import android.annotation.SuppressLint;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import kotlin.jvm.internal.t;

@SuppressLint({"ClassVerificationFailure"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class GetTopicsRequestHelper {
    public static final GetTopicsRequestHelper INSTANCE = new GetTopicsRequestHelper();

    private GetTopicsRequestHelper() {
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 5), @RequiresExtension(extension = 31, version = 9)})
    public final GetTopicsRequest convertRequestWithRecordObservation$ads_adservices_release(GetTopicsRequest getTopicsRequest) {
        t.e(getTopicsRequest, "request");
        GetTopicsRequest a5 = d.a().setAdsSdkName(getTopicsRequest.getAdsSdkName()).setShouldRecordObservation(getTopicsRequest.shouldRecordObservation()).build();
        t.d(a5, "Builder()\n            .s…ion)\n            .build()");
        return a5;
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    public final GetTopicsRequest convertRequestWithoutRecordObservation$ads_adservices_release(GetTopicsRequest getTopicsRequest) {
        t.e(getTopicsRequest, "request");
        GetTopicsRequest a5 = d.a().setAdsSdkName(getTopicsRequest.getAdsSdkName()).build();
        t.d(a5, "Builder()\n            .s…ame)\n            .build()");
        return a5;
    }
}
