package androidx.privacysandbox.ads.adservices.topics;

import androidx.collection.a;

public final class Topic {
    private final long modelVersion;
    private final long taxonomyVersion;
    private final int topicId;

    public Topic(long j5, long j6, int i5) {
        this.taxonomyVersion = j5;
        this.modelVersion = j6;
        this.topicId = i5;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Topic)) {
            return false;
        }
        Topic topic = (Topic) obj;
        if (this.taxonomyVersion == topic.taxonomyVersion && this.modelVersion == topic.modelVersion && this.topicId == topic.topicId) {
            return true;
        }
        return false;
    }

    public final long getModelVersion() {
        return this.modelVersion;
    }

    public final long getTaxonomyVersion() {
        return this.taxonomyVersion;
    }

    public final int getTopicId() {
        return this.topicId;
    }

    public int hashCode() {
        return (((a.a(this.taxonomyVersion) * 31) + a.a(this.modelVersion)) * 31) + this.topicId;
    }

    public String toString() {
        return "Topic { " + ("TaxonomyVersion=" + this.taxonomyVersion + ", ModelVersion=" + this.modelVersion + ", TopicCode=" + this.topicId + " }");
    }
}
