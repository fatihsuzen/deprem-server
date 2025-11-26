package androidx.core.util;

import android.annotation.SuppressLint;
import android.util.Range;
import androidx.annotation.RequiresApi;
import q3.C2725a;

@SuppressLint({"ClassVerificationFailure"})
public final class RangeKt {
    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> and(Range<T> range, Range<T> range2) {
        return range.intersect(range2);
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> range, T t5) {
        return range.extend(t5);
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> rangeTo(T t5, T t6) {
        return new Range<>(t5, t6);
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> C2725a toClosedRange(Range<T> range) {
        return new RangeKt$toClosedRange$1(range);
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> toRange(C2725a aVar) {
        return new Range<>(aVar.getStart(), aVar.getEndInclusive());
    }

    @RequiresApi(21)
    public static final <T extends Comparable<? super T>> Range<T> plus(Range<T> range, Range<T> range2) {
        return range.extend(range2);
    }
}
