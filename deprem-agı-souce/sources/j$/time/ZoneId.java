package j$.time;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import j$.com.android.tools.r8.a;
import j$.time.zone.f;
import j$.util.Objects;
import java.io.DataOutput;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class ZoneId implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final Map f1016a;
    private static final long serialVersionUID = 8352817235686L;

    public abstract String d();

    public abstract f v();

    public abstract void z(DataOutput dataOutput);

    static {
        int i5 = 0;
        Map.Entry[] entryArr = {a.y("ACT", "Australia/Darwin"), a.y("AET", "Australia/Sydney"), a.y("AGT", "America/Argentina/Buenos_Aires"), a.y("ART", "Africa/Cairo"), a.y("AST", "America/Anchorage"), a.y("BET", "America/Sao_Paulo"), a.y("BST", "Asia/Dhaka"), a.y("CAT", "Africa/Harare"), a.y("CNT", "America/St_Johns"), a.y("CST", "America/Chicago"), a.y("CTT", "Asia/Shanghai"), a.y("EAT", "Africa/Addis_Ababa"), a.y("ECT", "Europe/Paris"), a.y("IET", "America/Indiana/Indianapolis"), a.y("IST", "Asia/Kolkata"), a.y("JST", "Asia/Tokyo"), a.y("MIT", "Pacific/Apia"), a.y("NET", "Asia/Yerevan"), a.y("NST", "Pacific/Auckland"), a.y("PLT", "Asia/Karachi"), a.y("PNT", "America/Phoenix"), a.y("PRT", "America/Puerto_Rico"), a.y("PST", "America/Los_Angeles"), a.y("SST", "Pacific/Guadalcanal"), a.y("VST", "Asia/Ho_Chi_Minh"), a.y("EST", "-05:00"), a.y("MST", "-07:00"), a.y("HST", "-10:00")};
        HashMap hashMap = new HashMap(28);
        while (i5 < 28) {
            Map.Entry entry = entryArr[i5];
            Object requireNonNull = Objects.requireNonNull(entry.getKey());
            if (hashMap.put(requireNonNull, Objects.requireNonNull(entry.getValue())) == null) {
                i5++;
            } else {
                throw new IllegalArgumentException("duplicate key: " + requireNonNull);
            }
        }
        f1016a = Collections.unmodifiableMap(hashMap);
    }

    public static ZoneId of(String str) {
        return w(str, true);
    }

    public static ZoneId x(String str, ZoneOffset zoneOffset) {
        Objects.requireNonNull(str, "prefix");
        Objects.requireNonNull(zoneOffset, TypedValues.CycleType.S_WAVE_OFFSET);
        if (str.isEmpty()) {
            return zoneOffset;
        }
        if (str.equals("GMT") || str.equals("UTC") || str.equals("UT")) {
            if (zoneOffset.f1021b != 0) {
                str = str.concat(zoneOffset.f1022c);
            }
            return new w(str, zoneOffset.v());
        }
        throw new IllegalArgumentException("prefix should be GMT, UTC or UT, is: ".concat(str));
    }

    public static ZoneId w(String str, boolean z4) {
        Objects.requireNonNull(str, "zoneId");
        if (str.length() <= 1 || str.startsWith("+") || str.startsWith("-")) {
            return ZoneOffset.A(str);
        }
        if (str.startsWith("UTC") || str.startsWith("GMT")) {
            return y(str, 3, z4);
        }
        if (str.startsWith("UT")) {
            return y(str, 2, z4);
        }
        return w.A(str, z4);
    }

    public static ZoneId y(String str, int i5, boolean z4) {
        String substring = str.substring(0, i5);
        if (str.length() == i5) {
            return x(substring, ZoneOffset.UTC);
        }
        if (str.charAt(i5) != '+' && str.charAt(i5) != '-') {
            return w.A(str, z4);
        }
        try {
            ZoneOffset A4 = ZoneOffset.A(str.substring(i5));
            if (A4 == ZoneOffset.UTC) {
                return x(substring, A4);
            }
            return x(substring, A4);
        } catch (b e5) {
            throw new RuntimeException("Invalid ID for offset-based ZoneId: ".concat(str), e5);
        }
    }

    public ZoneId() {
        if (getClass() != ZoneOffset.class && getClass() != w.class) {
            throw new AssertionError("Invalid subclass");
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof ZoneId) {
            return d().equals(((ZoneId) obj).d());
        }
        return false;
    }

    public int hashCode() {
        return d().hashCode();
    }

    private void readObject(ObjectInputStream objectInputStream) {
        throw new InvalidObjectException("Deserialization via serialization delegate");
    }

    public String toString() {
        return d();
    }

    private Object writeReplace() {
        return new r((byte) 7, this);
    }
}
