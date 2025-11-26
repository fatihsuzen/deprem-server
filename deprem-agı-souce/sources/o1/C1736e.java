package o1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import p1.C1752a;
import p1.C1753b;

/* renamed from: o1.e  reason: case insensitive filesystem */
public abstract class C1736e {

    /* renamed from: a  reason: collision with root package name */
    private static Pattern f15664a = Pattern.compile("^[0-1]*$", 2);

    public static List a(String str) {
        if (f15664a.matcher(str).matches()) {
            ArrayList arrayList = new ArrayList();
            int i5 = 0;
            while (i5 < str.length()) {
                int i6 = i5 + 1;
                arrayList.add(Boolean.valueOf(C1732a.a(str.substring(i5, i6))));
                i5 = i6;
            }
            return arrayList;
        }
        throw new C1752a("Undecodable FixedBitfield '" + str + "'");
    }

    public static String b(List list, int i5) {
        if (list.size() <= i5) {
            String str = "";
            for (int i6 = 0; i6 < list.size(); i6++) {
                str = str + C1732a.b((Boolean) list.get(i6));
            }
            while (str.length() < i5) {
                str = str + "0";
            }
            return str;
        }
        throw new C1753b("Too many values '" + list.size() + "'");
    }
}
