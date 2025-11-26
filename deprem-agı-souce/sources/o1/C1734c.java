package o1;

import java.util.ArrayList;
import java.util.regex.Pattern;
import p1.C1752a;

/* renamed from: o1.c  reason: case insensitive filesystem */
public abstract class C1734c {

    /* renamed from: a  reason: collision with root package name */
    private static Pattern f15661a = Pattern.compile("^[0-1]*$", 2);

    public static int a(String str) {
        if (str.length() > 24) {
            throw new C1752a("FibonacciInteger too long");
        } else if (!f15661a.matcher(str).matches() || str.length() < 2 || str.indexOf("11") != str.length() - 2) {
            throw new C1752a("Undecodable FibonacciInteger '" + str + "'");
        } else {
            ArrayList arrayList = new ArrayList();
            for (int i5 = 0; i5 < str.length() - 1; i5++) {
                if (i5 == 0) {
                    arrayList.add(1);
                } else if (i5 == 1) {
                    arrayList.add(2);
                } else {
                    arrayList.add(Integer.valueOf(((Integer) arrayList.get(i5 - 1)).intValue() + ((Integer) arrayList.get(i5 - 2)).intValue()));
                }
            }
            int i6 = 0;
            for (int i7 = 0; i7 < str.length() - 1; i7++) {
                if (str.charAt(i7) == '1') {
                    i6 += ((Integer) arrayList.get(i7)).intValue();
                }
            }
            return i6;
        }
    }

    public static String b(int i5) {
        ArrayList arrayList = new ArrayList();
        if (i5 >= 1) {
            arrayList.add(1);
            int i6 = 2;
            if (i5 >= 2) {
                arrayList.add(2);
                while (true) {
                    int i7 = i6 - 1;
                    int i8 = i6 - 2;
                    if (i5 < ((Integer) arrayList.get(i7)).intValue() + ((Integer) arrayList.get(i8)).intValue()) {
                        break;
                    }
                    arrayList.add(Integer.valueOf(((Integer) arrayList.get(i7)).intValue() + ((Integer) arrayList.get(i8)).intValue()));
                    i6++;
                }
            }
        }
        String str = "1";
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            int intValue = ((Integer) arrayList.get(size)).intValue();
            if (i5 >= intValue) {
                str = "1" + str;
                i5 -= intValue;
            } else {
                str = "0" + str;
            }
        }
        return str;
    }
}
