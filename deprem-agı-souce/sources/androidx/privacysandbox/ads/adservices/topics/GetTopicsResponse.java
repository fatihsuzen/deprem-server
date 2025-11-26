package androidx.privacysandbox.ads.adservices.topics;

import X2.C2250q;
import androidx.privacysandbox.ads.adservices.common.ExperimentalFeatures;
import j$.util.Objects;
import java.util.HashSet;
import java.util.List;
import kotlin.jvm.internal.t;

public final class GetTopicsResponse {
    private final List<EncryptedTopic> encryptedTopics;
    private final List<Topic> topics;

    @ExperimentalFeatures.Ext11OptIn
    public GetTopicsResponse(List<Topic> list, List<EncryptedTopic> list2) {
        t.e(list, "topics");
        t.e(list2, "encryptedTopics");
        this.topics = list;
        this.encryptedTopics = list2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof GetTopicsResponse)) {
            return false;
        }
        GetTopicsResponse getTopicsResponse = (GetTopicsResponse) obj;
        if (this.topics.size() != getTopicsResponse.topics.size() || this.encryptedTopics.size() != getTopicsResponse.encryptedTopics.size() || !t.a(new HashSet(this.topics), new HashSet(getTopicsResponse.topics)) || !t.a(new HashSet(this.encryptedTopics), new HashSet(getTopicsResponse.encryptedTopics))) {
            return false;
        }
        return true;
    }

    public final List<EncryptedTopic> getEncryptedTopics() {
        return this.encryptedTopics;
    }

    public final List<Topic> getTopics() {
        return this.topics;
    }

    public int hashCode() {
        return Objects.hash(this.topics, this.encryptedTopics);
    }

    public String toString() {
        return "GetTopicsResponse: Topics=" + this.topics + ", EncryptedTopics=" + this.encryptedTopics;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public GetTopicsResponse(List<Topic> list) {
        this(list, C2250q.g());
        t.e(list, "topics");
    }
}
