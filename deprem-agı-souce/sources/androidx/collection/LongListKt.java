package androidx.collection;

import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;

public final class LongListKt {
    private static final LongList EmptyLongList = new MutableLongList(0);

    public static final LongList emptyLongList() {
        return EmptyLongList;
    }

    public static final LongList longListOf() {
        return EmptyLongList;
    }

    public static final MutableLongList mutableLongListOf() {
        return new MutableLongList(0, 1, (C2633k) null);
    }

    public static final LongList longListOf(long j5) {
        return mutableLongListOf(j5);
    }

    public static final MutableLongList mutableLongListOf(long j5) {
        MutableLongList mutableLongList = new MutableLongList(1);
        mutableLongList.add(j5);
        return mutableLongList;
    }

    public static final LongList longListOf(long j5, long j6) {
        return mutableLongListOf(j5, j6);
    }

    public static final LongList longListOf(long j5, long j6, long j7) {
        return mutableLongListOf(j5, j6, j7);
    }

    public static final MutableLongList mutableLongListOf(long j5, long j6) {
        MutableLongList mutableLongList = new MutableLongList(2);
        mutableLongList.add(j5);
        mutableLongList.add(j6);
        return mutableLongList;
    }

    public static final LongList longListOf(long... jArr) {
        t.e(jArr, "elements");
        MutableLongList mutableLongList = new MutableLongList(jArr.length);
        mutableLongList.plusAssign(jArr);
        return mutableLongList;
    }

    public static final MutableLongList mutableLongListOf(long j5, long j6, long j7) {
        MutableLongList mutableLongList = new MutableLongList(3);
        mutableLongList.add(j5);
        mutableLongList.add(j6);
        mutableLongList.add(j7);
        return mutableLongList;
    }

    public static final MutableLongList mutableLongListOf(long... jArr) {
        t.e(jArr, "elements");
        MutableLongList mutableLongList = new MutableLongList(jArr.length);
        mutableLongList.plusAssign(jArr);
        return mutableLongList;
    }
}
