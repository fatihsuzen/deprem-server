package androidx.datastore.preferences.protobuf;

import java.nio.Buffer;

final class Java8Compatibility {
    private Java8Compatibility() {
    }

    static void clear(Buffer buffer) {
        buffer.clear();
    }

    static void flip(Buffer buffer) {
        buffer.flip();
    }

    static void limit(Buffer buffer, int i5) {
        buffer.limit(i5);
    }

    static void mark(Buffer buffer) {
        buffer.mark();
    }

    static void position(Buffer buffer, int i5) {
        buffer.position(i5);
    }

    static void reset(Buffer buffer) {
        buffer.reset();
    }
}
