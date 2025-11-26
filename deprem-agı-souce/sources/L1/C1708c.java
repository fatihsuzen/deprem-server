package l1;

import j$.util.stream.Collectors;
import j$.util.stream.Stream;
import java.util.Map;
import java.util.regex.Pattern;
import o1.C1737f;
import p1.C1752a;
import p1.C1753b;

/* renamed from: l1.c  reason: case insensitive filesystem */
public abstract class C1708c {

    /* renamed from: a  reason: collision with root package name */
    private static String f15534a = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789-_";

    /* renamed from: b  reason: collision with root package name */
    private static Map f15535b;

    /* renamed from: c  reason: collision with root package name */
    private static Pattern f15536c = Pattern.compile("^[0-1]*$", 2);

    /* renamed from: d  reason: collision with root package name */
    private static Pattern f15537d = Pattern.compile("^[A-Za-z0-9\\-_]*$", 2);

    static {
        Object[] objArr = {'H', 7};
        f15535b = (Map) Stream.CC.of(new Object[]{'A', 0}, new Object[]{'B', 1}, new Object[]{'C', 2}, new Object[]{'D', 3}, new Object[]{'E', 4}, new Object[]{'F', 5}, new Object[]{'G', 6}, objArr, new Object[]{'I', 8}, new Object[]{'J', 9}, new Object[]{'K', 10}, new Object[]{'L', 11}, new Object[]{'M', 12}, new Object[]{'N', 13}, new Object[]{'O', 14}, new Object[]{'P', 15}, new Object[]{'Q', 16}, new Object[]{'R', 17}, new Object[]{'S', 18}, new Object[]{'T', 19}, new Object[]{'U', 20}, new Object[]{'V', 21}, new Object[]{'W', 22}, new Object[]{'X', 23}, new Object[]{'Y', 24}, new Object[]{'Z', 25}, new Object[]{'a', 26}, new Object[]{'b', 27}, new Object[]{'c', 28}, new Object[]{'d', 29}, new Object[]{'e', 30}, new Object[]{'f', 31}, new Object[]{'g', 32}, new Object[]{'h', 33}, new Object[]{'i', 34}, new Object[]{'j', 35}, new Object[]{'k', 36}, new Object[]{'l', 37}, new Object[]{'m', 38}, new Object[]{'n', 39}, new Object[]{'o', 40}, new Object[]{'p', 41}, new Object[]{'q', 42}, new Object[]{'r', 43}, new Object[]{'s', 44}, new Object[]{'t', 45}, new Object[]{'u', 46}, new Object[]{'v', 47}, new Object[]{'w', 48}, new Object[]{'x', 49}, new Object[]{'y', 50}, new Object[]{'z', 51}, new Object[]{'0', 52}, new Object[]{'1', 53}, new Object[]{'2', 54}, new Object[]{'3', 55}, new Object[]{'4', 56}, new Object[]{'5', 57}, new Object[]{'6', 58}, new Object[]{'7', 59}, new Object[]{'8', 60}, new Object[]{'9', 61}, new Object[]{'-', 62}, new Object[]{'_', 63}).collect(Collectors.toMap(new C1706a(), new C1707b()));
    }

    public static /* synthetic */ Character a(Object[] objArr) {
        return objArr[0];
    }

    public static /* synthetic */ Integer b(Object[] objArr) {
        return objArr[1];
    }

    public String c(String str) {
        if (f15537d.matcher(str).matches()) {
            String str2 = "";
            for (int i5 = 0; i5 < str.length(); i5++) {
                str2 = str2 + C1737f.b(((Integer) f15535b.get(Character.valueOf(str.charAt(i5)))).intValue(), 6);
            }
            return str2;
        }
        throw new C1752a("Undecodable Base64URL string");
    }

    public String d(String str) {
        if (f15536c.matcher(str).matches()) {
            String e5 = e(str);
            String str2 = "";
            int i5 = 0;
            while (i5 <= e5.length() - 6) {
                int i6 = i5 + 6;
                try {
                    str2 = str2 + Character.valueOf(f15534a.charAt(C1737f.a(e5.substring(i5, i6))));
                    i5 = i6;
                } catch (C1752a unused) {
                    throw new C1753b("Unencodable Base64Url '" + e5 + "'");
                }
            }
            return str2;
        }
        throw new C1753b("Unencodable Base64Url '" + str + "'");
    }

    /* access modifiers changed from: protected */
    public abstract String e(String str);
}
