package com.mbridge.msdk.thrid.okhttp.internal.http2;

import com.mbridge.msdk.thrid.okio.BufferedSource;
import java.io.IOException;
import java.util.List;

public interface PushObserver {
    public static final PushObserver CANCEL = new PushObserver() {
        public boolean onData(int i5, BufferedSource bufferedSource, int i6, boolean z4) throws IOException {
            bufferedSource.skip((long) i6);
            return true;
        }

        public boolean onHeaders(int i5, List<Header> list, boolean z4) {
            return true;
        }

        public boolean onRequest(int i5, List<Header> list) {
            return true;
        }

        public void onReset(int i5, ErrorCode errorCode) {
        }
    };

    boolean onData(int i5, BufferedSource bufferedSource, int i6, boolean z4) throws IOException;

    boolean onHeaders(int i5, List<Header> list, boolean z4);

    boolean onRequest(int i5, List<Header> list);

    void onReset(int i5, ErrorCode errorCode);
}
