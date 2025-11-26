package androidx.window.layout;

import k3.l;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.u;

final class WindowMetricsCalculator$Companion$decorator$1 extends u implements l {
    public static final WindowMetricsCalculator$Companion$decorator$1 INSTANCE = new WindowMetricsCalculator$Companion$decorator$1();

    WindowMetricsCalculator$Companion$decorator$1() {
        super(1);
    }

    public final WindowMetricsCalculator invoke(WindowMetricsCalculator windowMetricsCalculator) {
        t.e(windowMetricsCalculator, "it");
        return windowMetricsCalculator;
    }
}
