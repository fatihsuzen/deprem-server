package androidx.core.util;

import W2.s;
import android.annotation.SuppressLint;
import android.util.Pair;

public final class PairKt {
    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(Pair<F, S> pair) {
        return pair.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(Pair<F, S> pair) {
        return pair.second;
    }

    public static final <F, S> Pair<F, S> toAndroidPair(s sVar) {
        return new Pair<>(sVar.c(), sVar.d());
    }

    public static final <F, S> Pair<F, S> toAndroidXPair(s sVar) {
        return new Pair<>(sVar.c(), sVar.d());
    }

    public static final <F, S> s toKotlinPair(Pair<F, S> pair) {
        return new s(pair.first, pair.second);
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> F component1(Pair<F, S> pair) {
        return pair.first;
    }

    @SuppressLint({"UnknownNullness"})
    public static final <F, S> S component2(Pair<F, S> pair) {
        return pair.second;
    }

    public static final <F, S> s toKotlinPair(Pair<F, S> pair) {
        return new s(pair.first, pair.second);
    }
}
