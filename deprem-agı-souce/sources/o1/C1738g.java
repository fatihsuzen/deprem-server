package o1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import p1.C1752a;
import p1.C1753b;

/* renamed from: o1.g  reason: case insensitive filesystem */
public abstract class C1738g {

    /* renamed from: a  reason: collision with root package name */
    private static Pattern f15666a = Pattern.compile("^[0-1]*$", 2);

    public static List a(String str, int i5, int i6) {
        if (f15666a.matcher(str).matches()) {
            int i7 = i5 * i6;
            if (str.length() > i7) {
                throw new C1752a("Undecodable FixedIntegerList '" + str + "'");
            } else if (str.length() % i5 == 0) {
                while (str.length() < i7) {
                    str = str + "0";
                }
                if (str.length() > i7) {
                    str = str.substring(0, i7);
                }
                ArrayList arrayList = new ArrayList();
                int i8 = 0;
                while (i8 < str.length()) {
                    int i9 = i8 + i5;
                    arrayList.add(Integer.valueOf(C1737f.a(str.substring(i8, i9))));
                    i8 = i9;
                }
                while (arrayList.size() < i6) {
                    arrayList.add(0);
                }
                return arrayList;
            } else {
                throw new C1752a("Undecodable FixedIntegerList '" + str + "'");
            }
        } else {
            throw new C1752a("Undecodable FixedIntegerList '" + str + "'");
        }
    }

    public static String b(List list, int i5, int i6) {
        if (list.size() <= i6) {
            String str = "";
            for (int i7 = 0; i7 < list.size(); i7++) {
                str = str + C1737f.b(((Integer) list.get(i7)).intValue(), i5);
            }
            while (str.length() < i5 * i6) {
                str = str + "0";
            }
            return str;
        }
        throw new C1753b("Too many values '" + list.size() + "'");
    }
}
