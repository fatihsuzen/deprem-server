package com.google.android.gms.internal.measurement;

import java.io.IOException;
import java.util.Locale;

public final class L4 extends IOException {
    L4(long j5, long j6, int i5, Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.: ".concat(String.format(Locale.US, "Pos: %d, limit: %d, len: %d", new Object[]{Long.valueOf(j5), Long.valueOf(j6), Integer.valueOf(i5)})), th);
    }

    L4(Throwable th) {
        super("CodedOutputStream was writing to a flat byte array and ran out of space.", th);
    }
}
