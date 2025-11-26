package androidx.core.util;

import android.util.Range;
import q3.C2725a;

public final class RangeKt$toClosedRange$1 implements C2725a {
    final /* synthetic */ Range<T> $this_toClosedRange;

    RangeKt$toClosedRange$1(Range<T> range) {
        this.$this_toClosedRange = range;
    }

    public boolean contains(T t5) {
        return C2725a.C0259a.a(this, t5);
    }

    public T getEndInclusive() {
        return this.$this_toClosedRange.getUpper();
    }

    public T getStart() {
        return this.$this_toClosedRange.getLower();
    }

    public boolean isEmpty() {
        return C2725a.C0259a.b(this);
    }
}
