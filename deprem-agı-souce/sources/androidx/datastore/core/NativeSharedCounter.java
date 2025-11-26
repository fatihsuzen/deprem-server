package androidx.datastore.core;

public final class NativeSharedCounter {
    public final native long nativeCreateSharedCounter(int i5);

    public final native int nativeGetCounterValue(long j5);

    public final native int nativeIncrementAndGetCounterValue(long j5);

    public final native int nativeTruncateFile(int i5);
}
