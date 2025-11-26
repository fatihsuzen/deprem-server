package com.mbridge.msdk.thrid.okhttp.internal.cache;

import com.mbridge.msdk.thrid.okio.Buffer;
import com.mbridge.msdk.thrid.okio.ForwardingSink;
import com.mbridge.msdk.thrid.okio.Sink;
import java.io.IOException;

class FaultHidingSink extends ForwardingSink {
    private boolean hasErrors;

    FaultHidingSink(Sink sink) {
        super(sink);
    }

    public void close() throws IOException {
        if (!this.hasErrors) {
            try {
                super.close();
            } catch (IOException e5) {
                this.hasErrors = true;
                onException(e5);
            }
        }
    }

    public void flush() throws IOException {
        if (!this.hasErrors) {
            try {
                super.flush();
            } catch (IOException e5) {
                this.hasErrors = true;
                onException(e5);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onException(IOException iOException) {
    }

    public void write(Buffer buffer, long j5) throws IOException {
        if (this.hasErrors) {
            buffer.skip(j5);
            return;
        }
        try {
            super.write(buffer, j5);
        } catch (IOException e5) {
            this.hasErrors = true;
            onException(e5);
        }
    }
}
