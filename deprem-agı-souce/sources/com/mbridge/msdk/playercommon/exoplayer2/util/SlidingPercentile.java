package com.mbridge.msdk.playercommon.exoplayer2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class SlidingPercentile {
    private static final Comparator<Sample> INDEX_COMPARATOR = new Comparator<Sample>() {
        public final int compare(Sample sample, Sample sample2) {
            return sample.index - sample2.index;
        }
    };
    private static final int MAX_RECYCLED_SAMPLES = 5;
    private static final int SORT_ORDER_BY_INDEX = 1;
    private static final int SORT_ORDER_BY_VALUE = 0;
    private static final int SORT_ORDER_NONE = -1;
    private static final Comparator<Sample> VALUE_COMPARATOR = new Comparator<Sample>() {
        public final int compare(Sample sample, Sample sample2) {
            float f5 = sample.value;
            float f6 = sample2.value;
            if (f5 < f6) {
                return -1;
            }
            return f6 < f5 ? 1 : 0;
        }
    };
    private int currentSortOrder = -1;
    private final int maxWeight;
    private int nextSampleIndex;
    private int recycledSampleCount;
    private final Sample[] recycledSamples = new Sample[5];
    private final ArrayList<Sample> samples = new ArrayList<>();
    private int totalWeight;

    private static class Sample {
        public int index;
        public float value;
        public int weight;

        private Sample() {
        }
    }

    public SlidingPercentile(int i5) {
        this.maxWeight = i5;
    }

    private void ensureSortedByIndex() {
        if (this.currentSortOrder != 1) {
            Collections.sort(this.samples, INDEX_COMPARATOR);
            this.currentSortOrder = 1;
        }
    }

    private void ensureSortedByValue() {
        if (this.currentSortOrder != 0) {
            Collections.sort(this.samples, VALUE_COMPARATOR);
            this.currentSortOrder = 0;
        }
    }

    public void addSample(int i5, float f5) {
        Sample sample;
        ensureSortedByIndex();
        int i6 = this.recycledSampleCount;
        if (i6 > 0) {
            Sample[] sampleArr = this.recycledSamples;
            int i7 = i6 - 1;
            this.recycledSampleCount = i7;
            sample = sampleArr[i7];
        } else {
            sample = new Sample();
        }
        int i8 = this.nextSampleIndex;
        this.nextSampleIndex = i8 + 1;
        sample.index = i8;
        sample.weight = i5;
        sample.value = f5;
        this.samples.add(sample);
        this.totalWeight += i5;
        while (true) {
            int i9 = this.totalWeight;
            int i10 = this.maxWeight;
            if (i9 > i10) {
                int i11 = i9 - i10;
                Sample sample2 = this.samples.get(0);
                int i12 = sample2.weight;
                if (i12 <= i11) {
                    this.totalWeight -= i12;
                    this.samples.remove(0);
                    int i13 = this.recycledSampleCount;
                    if (i13 < 5) {
                        Sample[] sampleArr2 = this.recycledSamples;
                        this.recycledSampleCount = i13 + 1;
                        sampleArr2[i13] = sample2;
                    }
                } else {
                    sample2.weight = i12 - i11;
                    this.totalWeight -= i11;
                }
            } else {
                return;
            }
        }
    }

    public float getPercentile(float f5) {
        ensureSortedByValue();
        float f6 = f5 * ((float) this.totalWeight);
        int i5 = 0;
        for (int i6 = 0; i6 < this.samples.size(); i6++) {
            Sample sample = this.samples.get(i6);
            i5 += sample.weight;
            if (((float) i5) >= f6) {
                return sample.value;
            }
        }
        if (this.samples.isEmpty()) {
            return Float.NaN;
        }
        ArrayList<Sample> arrayList = this.samples;
        return arrayList.get(arrayList.size() - 1).value;
    }
}
