package com.google.android.gms.internal.measurement;

import java.util.List;

public final class M extends C1261y {
    public final r a(String str, U1 u12, List list) {
        if (str == null || str.isEmpty() || !u12.d(str)) {
            throw new IllegalArgumentException(String.format("Command not found: %s", new Object[]{str}));
        }
        r h5 = u12.h(str);
        if (h5 instanceof C1137k) {
            return ((C1137k) h5).a(u12, list);
        }
        throw new IllegalArgumentException(String.format("Function %s is not defined", new Object[]{str}));
    }
}
