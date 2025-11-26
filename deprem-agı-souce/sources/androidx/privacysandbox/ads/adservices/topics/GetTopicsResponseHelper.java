package androidx.privacysandbox.ads.adservices.topics;

import android.adservices.topics.EncryptedTopic;
import android.adservices.topics.GetTopicsResponse;
import android.adservices.topics.Topic;
import android.annotation.SuppressLint;
import androidx.annotation.RequiresExtension;
import androidx.annotation.RestrictTo;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import java.util.ArrayList;
import kotlin.jvm.internal.t;

@SuppressLint({"ClassVerificationFailure"})
@RestrictTo({RestrictTo.Scope.LIBRARY})
public final class GetTopicsResponseHelper {
    public static final GetTopicsResponseHelper INSTANCE = new GetTopicsResponseHelper();

    private GetTopicsResponseHelper() {
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 4), @RequiresExtension(extension = 31, version = 9)})
    public final GetTopicsResponse convertResponse$ads_adservices_release(GetTopicsResponse getTopicsResponse) {
        t.e(getTopicsResponse, "response");
        ArrayList arrayList = new ArrayList();
        for (Object a5 : getTopicsResponse.getTopics()) {
            Topic a6 = f.a(a5);
            arrayList.add(new Topic(a6.getTaxonomyVersion(), a6.getModelVersion(), a6.getTopicId()));
        }
        return new GetTopicsResponse(arrayList);
    }

    @RequiresExtension.Container({@RequiresExtension(extension = 1000000, version = 11), @RequiresExtension(extension = 31, version = 11)})
    @ExperimentalFeatures.Ext11OptIn
    public final GetTopicsResponse convertResponseWithEncryptedTopics$ads_adservices_release(GetTopicsResponse getTopicsResponse) {
        t.e(getTopicsResponse, "response");
        ArrayList arrayList = new ArrayList();
        for (Object a5 : getTopicsResponse.getTopics()) {
            Topic a6 = f.a(a5);
            arrayList.add(new Topic(a6.getTaxonomyVersion(), a6.getModelVersion(), a6.getTopicId()));
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object a7 : getTopicsResponse.getEncryptedTopics()) {
            EncryptedTopic a8 = k.a(a7);
            byte[] a9 = a8.getEncryptedTopic();
            t.d(a9, "encryptedTopic.encryptedTopic");
            String a10 = a8.getKeyIdentifier();
            t.d(a10, "encryptedTopic.keyIdentifier");
            byte[] a11 = a8.getEncapsulatedKey();
            t.d(a11, "encryptedTopic.encapsulatedKey");
            arrayList2.add(new EncryptedTopic(a9, a10, a11));
        }
        return new GetTopicsResponse(arrayList, arrayList2);
    }
}
