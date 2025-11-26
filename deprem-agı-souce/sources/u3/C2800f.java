package u3;

import kotlin.jvm.internal.t;

/* renamed from: u3.f  reason: case insensitive filesystem */
abstract class C2800f extends C2799e {
    public static final C2798d d(char c5, boolean z4) {
        if (!z4) {
            if (c5 == 'D') {
                return C2798d.DAYS;
            }
            throw new IllegalArgumentException("Invalid or unsupported duration ISO non-time unit: " + c5);
        } else if (c5 == 'H') {
            return C2798d.HOURS;
        } else {
            if (c5 == 'M') {
                return C2798d.MINUTES;
            }
            if (c5 == 'S') {
                return C2798d.SECONDS;
            }
            throw new IllegalArgumentException("Invalid duration ISO time unit: " + c5);
        }
    }

    public static final C2798d e(String str) {
        t.e(str, "shortName");
        int hashCode = str.hashCode();
        if (hashCode != 100) {
            if (hashCode != 104) {
                if (hashCode != 109) {
                    if (hashCode != 115) {
                        if (hashCode != 3494) {
                            if (hashCode != 3525) {
                                if (hashCode == 3742 && str.equals("us")) {
                                    return C2798d.MICROSECONDS;
                                }
                            } else if (str.equals("ns")) {
                                return C2798d.NANOSECONDS;
                            }
                        } else if (str.equals("ms")) {
                            return C2798d.MILLISECONDS;
                        }
                    } else if (str.equals("s")) {
                        return C2798d.SECONDS;
                    }
                } else if (str.equals("m")) {
                    return C2798d.MINUTES;
                }
            } else if (str.equals("h")) {
                return C2798d.HOURS;
            }
        } else if (str.equals("d")) {
            return C2798d.DAYS;
        }
        throw new IllegalArgumentException("Unknown duration unit short name: " + str);
    }
}
