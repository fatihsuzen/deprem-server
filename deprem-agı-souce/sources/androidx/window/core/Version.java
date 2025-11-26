package androidx.window.core;

import W2.C2223l;
import W2.m;
import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import t3.s;

public final class Version implements Comparable<Version> {
    /* access modifiers changed from: private */
    public static final Version CURRENT;
    public static final Companion Companion = new Companion((C2633k) null);
    /* access modifiers changed from: private */
    public static final Version UNKNOWN = new Version(0, 0, 0, "");
    /* access modifiers changed from: private */
    public static final Version VERSION_0_1 = new Version(0, 1, 0, "");
    /* access modifiers changed from: private */
    public static final Version VERSION_1_0;
    private static final String VERSION_PATTERN_STRING = "(\\d+)(?:\\.(\\d+))(?:\\.(\\d+))(?:-(.+))?";
    private final C2223l bigInteger$delegate;
    private final String description;
    private final int major;
    private final int minor;
    private final int patch;

    public static final class Companion {
        public /* synthetic */ Companion(C2633k kVar) {
            this();
        }

        public final Version getCURRENT() {
            return Version.CURRENT;
        }

        public final Version getUNKNOWN() {
            return Version.UNKNOWN;
        }

        public final Version getVERSION_0_1() {
            return Version.VERSION_0_1;
        }

        public final Version getVERSION_1_0() {
            return Version.VERSION_1_0;
        }

        public final Version parse(String str) {
            Integer num;
            Integer num2;
            Integer num3;
            String str2;
            if (str == null || s.h0(str)) {
                return null;
            }
            Matcher matcher = Pattern.compile(Version.VERSION_PATTERN_STRING).matcher(str);
            if (!matcher.matches()) {
                return null;
            }
            String group = matcher.group(1);
            if (group == null) {
                num = null;
            } else {
                num = Integer.valueOf(Integer.parseInt(group));
            }
            if (num == null) {
                return null;
            }
            int intValue = num.intValue();
            String group2 = matcher.group(2);
            if (group2 == null) {
                num2 = null;
            } else {
                num2 = Integer.valueOf(Integer.parseInt(group2));
            }
            if (num2 == null) {
                return null;
            }
            int intValue2 = num2.intValue();
            String group3 = matcher.group(3);
            if (group3 == null) {
                num3 = null;
            } else {
                num3 = Integer.valueOf(Integer.parseInt(group3));
            }
            if (num3 == null) {
                return null;
            }
            int intValue3 = num3.intValue();
            if (matcher.group(4) != null) {
                str2 = matcher.group(4);
            } else {
                str2 = "";
            }
            String str3 = str2;
            t.d(str3, "description");
            return new Version(intValue, intValue2, intValue3, str3, (C2633k) null);
        }

        private Companion() {
        }
    }

    static {
        Version version = new Version(1, 0, 0, "");
        VERSION_1_0 = version;
        CURRENT = version;
    }

    public /* synthetic */ Version(int i5, int i6, int i7, String str, C2633k kVar) {
        this(i5, i6, i7, str);
    }

    private final BigInteger getBigInteger() {
        Object value = this.bigInteger$delegate.getValue();
        t.d(value, "<get-bigInteger>(...)");
        return (BigInteger) value;
    }

    public static final Version parse(String str) {
        return Companion.parse(str);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Version)) {
            return false;
        }
        Version version = (Version) obj;
        if (this.major == version.major && this.minor == version.minor && this.patch == version.patch) {
            return true;
        }
        return false;
    }

    public final String getDescription() {
        return this.description;
    }

    public final int getMajor() {
        return this.major;
    }

    public final int getMinor() {
        return this.minor;
    }

    public final int getPatch() {
        return this.patch;
    }

    public int hashCode() {
        return ((((527 + this.major) * 31) + this.minor) * 31) + this.patch;
    }

    public String toString() {
        String str;
        if (!s.h0(this.description)) {
            str = t.n("-", this.description);
        } else {
            str = "";
        }
        return this.major + '.' + this.minor + '.' + this.patch + str;
    }

    private Version(int i5, int i6, int i7, String str) {
        this.major = i5;
        this.minor = i6;
        this.patch = i7;
        this.description = str;
        this.bigInteger$delegate = m.b(new Version$bigInteger$2(this));
    }

    public int compareTo(Version version) {
        t.e(version, "other");
        return getBigInteger().compareTo(version.getBigInteger());
    }
}
