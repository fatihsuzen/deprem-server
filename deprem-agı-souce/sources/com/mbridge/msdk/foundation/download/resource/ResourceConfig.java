package com.mbridge.msdk.foundation.download.resource;

import com.mbridge.msdk.foundation.download.DownloadResourceType;
import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class ResourceConfig {
    private long maxStorageSpace;
    private Map<String, Long> maxStorageSpacePerResourceType;
    private long maxStorageTime;
    private Map<String, Long> maxStorageTimePerResourceType;
    private Queue<ResourceStrategy> resourceStrategyQueue;

    public static class Builder {
        /* access modifiers changed from: private */
        public long maxStorageSpace;
        /* access modifiers changed from: private */
        public Map<String, Long> maxStorageSpacePerResourceType;
        /* access modifiers changed from: private */
        public long maxStorageTime;
        /* access modifiers changed from: private */
        public Map<String, Long> maxStorageTimePerResourceType;
        /* access modifiers changed from: private */
        public Queue<ResourceStrategy> resourceStrategyQueue;

        public Builder addMaxStorageSpace(DownloadResourceType downloadResourceType, long j5) {
            if (this.maxStorageSpacePerResourceType == null) {
                this.maxStorageSpacePerResourceType = new HashMap();
            }
            this.maxStorageSpacePerResourceType.put(downloadResourceType.name(), Long.valueOf(j5));
            return this;
        }

        public Builder addMaxStorageTime(DownloadResourceType downloadResourceType, long j5) {
            if (this.maxStorageTimePerResourceType == null) {
                this.maxStorageTimePerResourceType = new HashMap();
            }
            this.maxStorageTimePerResourceType.put(downloadResourceType.name(), Long.valueOf(j5));
            return this;
        }

        public Builder addResourceStrategy(ResourceStrategy resourceStrategy) {
            if (this.resourceStrategyQueue == null) {
                this.resourceStrategyQueue = new ArrayDeque();
            }
            this.resourceStrategyQueue.add(resourceStrategy);
            return this;
        }

        public ResourceConfig build() {
            return new ResourceConfig(this);
        }

        public Builder setMaxStorageSpace(long j5) {
            this.maxStorageSpace = j5;
            return this;
        }

        public Builder setMaxStorageTime(long j5) {
            this.maxStorageTime = j5;
            return this;
        }
    }

    public long getMaxStorageSpace() {
        return this.maxStorageSpace;
    }

    public Map<String, Long> getMaxStorageSpacePerResourceType() {
        return this.maxStorageSpacePerResourceType;
    }

    public long getMaxStorageTime() {
        return this.maxStorageTime;
    }

    public Map<String, Long> getMaxStorageTimePerResourceType() {
        return this.maxStorageTimePerResourceType;
    }

    public Queue<ResourceStrategy> getResourceStrategyQueue() {
        return this.resourceStrategyQueue;
    }

    private ResourceConfig(Builder builder) {
        this.maxStorageSpace = builder.maxStorageSpace;
        this.maxStorageTime = builder.maxStorageTime;
        this.maxStorageSpacePerResourceType = builder.maxStorageSpacePerResourceType;
        this.maxStorageTimePerResourceType = builder.maxStorageTimePerResourceType;
        this.resourceStrategyQueue = builder.resourceStrategyQueue;
    }

    public long getMaxStorageSpace(DownloadResourceType downloadResourceType) {
        Map<String, Long> map = this.maxStorageSpacePerResourceType;
        if (map == null || !map.containsKey(downloadResourceType.name())) {
            return 0;
        }
        return this.maxStorageSpacePerResourceType.get(downloadResourceType.name()).longValue();
    }

    public long getMaxStorageTime(DownloadResourceType downloadResourceType) {
        Map<String, Long> map = this.maxStorageTimePerResourceType;
        if (map == null || !map.containsKey(downloadResourceType.name())) {
            return 0;
        }
        return this.maxStorageTimePerResourceType.get(downloadResourceType.name()).longValue();
    }
}
