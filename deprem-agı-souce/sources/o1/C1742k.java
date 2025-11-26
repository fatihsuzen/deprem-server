package o1;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import p1.C1752a;

/* renamed from: o1.k  reason: case insensitive filesystem */
public abstract class C1742k {

    /* renamed from: a  reason: collision with root package name */
    private static Pattern f15671a = Pattern.compile("^[0-1]*$", 2);

    public static List a(String str) {
        if (!f15671a.matcher(str).matches() || str.length() < 12) {
            throw new C1752a("Undecodable FixedIntegerRange '" + str + "'");
        } else if (str.charAt(16) == '1') {
            return C1739h.a(str.substring(17));
        } else {
            ArrayList arrayList = new ArrayList();
            List a5 = C1736e.a(str.substring(17));
            for (int i5 = 0; i5 < a5.size(); i5++) {
                if (((Boolean) a5.get(i5)).booleanValue()) {
                    arrayList.add(Integer.valueOf(i5 + 1));
                }
            }
            return arrayList;
        }
    }

    public static String b(List list) {
        int i5;
        if (list.size() > 0) {
            i5 = ((Integer) list.get(list.size() - 1)).intValue();
        } else {
            i5 = 0;
        }
        String b5 = C1739h.b(list);
        if (b5.length() <= i5) {
            return C1737f.b(i5, 16) + "1" + b5;
        }
        ArrayList arrayList = new ArrayList();
        int i6 = 0;
        for (int i7 = 0; i7 < i5; i7++) {
            if (i7 == ((Integer) list.get(i6)).intValue() - 1) {
                arrayList.add(Boolean.TRUE);
                i6++;
            } else {
                arrayList.add(Boolean.FALSE);
            }
        }
        return C1737f.b(i5, 16) + "0" + C1736e.b(arrayList, i5);
    }
}
