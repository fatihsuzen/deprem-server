package androidx.collection;

public final class LongLongPair {
    private final long first;
    private final long second;

    public LongLongPair(long j5, long j6) {
        this.first = j5;
        this.second = j6;
    }

    public final long component1() {
        return getFirst();
    }

    public final long component2() {
        return getSecond();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof LongLongPair)) {
            return false;
        }
        LongLongPair longLongPair = (LongLongPair) obj;
        if (longLongPair.first == this.first && longLongPair.second == this.second) {
            return true;
        }
        return false;
    }

    public final long getFirst() {
        return this.first;
    }

    public final long getSecond() {
        return this.second;
    }

    public int hashCode() {
        return a.a(this.first) ^ a.a(this.second);
    }

    public String toString() {
        return '(' + this.first + ", " + this.second + ')';
    }
}
