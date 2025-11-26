package androidx.core.util;

import androidx.annotation.NonNull;

public class Pair<F, S> {
    public final F first;
    public final S second;

    public Pair(F f5, S s5) {
        this.first = f5;
        this.second = s5;
    }

    @NonNull
    public static <A, B> Pair<A, B> create(A a5, B b5) {
        return new Pair<>(a5, b5);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Pair)) {
            return false;
        }
        Pair pair = (Pair) obj;
        if (!ObjectsCompat.equals(pair.first, this.first) || !ObjectsCompat.equals(pair.second, this.second)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int i5;
        F f5 = this.first;
        int i6 = 0;
        if (f5 == null) {
            i5 = 0;
        } else {
            i5 = f5.hashCode();
        }
        S s5 = this.second;
        if (s5 != null) {
            i6 = s5.hashCode();
        }
        return i5 ^ i6;
    }

    @NonNull
    public String toString() {
        return "Pair{" + this.first + " " + this.second + "}";
    }
}
