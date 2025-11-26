package com.mbridge.msdk.playercommon.exoplayer2.upstream;

public interface TransferListener<S> {
    void onBytesTransferred(S s5, int i5);

    void onTransferEnd(S s5);

    void onTransferStart(S s5, DataSpec dataSpec);
}
