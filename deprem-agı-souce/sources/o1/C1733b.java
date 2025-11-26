package o1;

import j$.time.Instant;
import j$.time.ZoneId;
import j$.time.ZonedDateTime;
import java.util.regex.Pattern;
import p1.C1752a;

/* renamed from: o1.b  reason: case insensitive filesystem */
public abstract class C1733b {

    /* renamed from: a  reason: collision with root package name */
    private static Pattern f15660a = Pattern.compile("^[0-1]*$", 2);

    public static ZonedDateTime a(String str) {
        if (f15660a.matcher(str).matches() && str.length() == 36) {
            return ZonedDateTime.ofInstant(Instant.ofEpochMilli(C1740i.a(str) * 100), ZoneId.of("UTC"));
        }
        throw new C1752a("Undecodable Datetime '" + str + "'");
    }

    public static String b(ZonedDateTime zonedDateTime) {
        if (zonedDateTime != null) {
            return C1740i.b(zonedDateTime.toInstant().toEpochMilli() / 100, 36);
        }
        return C1740i.b(0, 36);
    }
}
