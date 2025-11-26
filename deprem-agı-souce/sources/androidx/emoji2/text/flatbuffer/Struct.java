package androidx.emoji2.text.flatbuffer;

import java.nio.ByteBuffer;

public class Struct {
    protected ByteBuffer bb;
    protected int bb_pos;

    /* access modifiers changed from: protected */
    public void __reset(int i5, ByteBuffer byteBuffer) {
        this.bb = byteBuffer;
        if (byteBuffer != null) {
            this.bb_pos = i5;
        } else {
            this.bb_pos = 0;
        }
    }

    public void __reset() {
        __reset(0, (ByteBuffer) null);
    }
}
