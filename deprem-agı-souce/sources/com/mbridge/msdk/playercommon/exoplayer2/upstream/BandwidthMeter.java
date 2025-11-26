package com.mbridge.msdk.playercommon.exoplayer2.upstream;

public interface BandwidthMeter {

    public interface EventListener {
        void onBandwidthSample(int i5, long j5, long j6);
    }

    long getBitrateEstimate();
}
