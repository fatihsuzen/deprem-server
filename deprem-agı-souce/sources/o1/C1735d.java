package o1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import p1.C1752a;

/* renamed from: o1.d  reason: case insensitive filesystem */
public abstract class C1735d {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f15662a = Logger.getLogger(C1735d.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private static Pattern f15663b = Pattern.compile("^[0-1]*$", 2);

    public static List a(String str) {
        if (f15663b.matcher(str).matches()) {
            int i5 = 12;
            if (str.length() >= 12) {
                ArrayList arrayList = new ArrayList();
                int a5 = C1737f.a(str.substring(0, 12));
                int i6 = 0;
                for (int i7 = 0; i7 < a5; i7++) {
                    int i8 = i5 + 1;
                    if (C1732a.a(str.substring(i5, i8))) {
                        int indexOf = str.indexOf("11", i8) + 2;
                        int a6 = C1734c.a(str.substring(i8, indexOf)) + i6;
                        int indexOf2 = str.indexOf("11", indexOf) + 2;
                        int a7 = C1734c.a(str.substring(indexOf, indexOf2)) + a6;
                        if (arrayList.size() + (a7 - a6) > 8192) {
                            f15662a.warning("FibonacciIntegerRange has too many values");
                            return arrayList;
                        }
                        while (a6 <= a7) {
                            arrayList.add(Integer.valueOf(a6));
                            a6++;
                        }
                        int i9 = indexOf2;
                        i6 = a7;
                        i5 = i9;
                    } else {
                        i5 = str.indexOf("11", i8) + 2;
                        int a8 = C1734c.a(str.substring(i8, i5)) + i6;
                        if (arrayList.size() == 8192) {
                            f15662a.warning("FibonacciIntegerRange has too many values");
                            return arrayList;
                        }
                        arrayList.add(Integer.valueOf(a8));
                        i6 = a8;
                    }
                }
                return arrayList;
            }
        }
        throw new C1752a("Undecodable FibonacciIntegerRange '" + str + "'");
    }

    public static String b(List list) {
        Collections.sort(list);
        ArrayList arrayList = new ArrayList();
        int i5 = 0;
        while (i5 < list.size()) {
            int i6 = i5;
            while (i6 < list.size() - 1) {
                int i7 = i6 + 1;
                if (((Integer) list.get(i6)).intValue() + 1 != ((Integer) list.get(i7)).intValue()) {
                    break;
                }
                i6 = i7;
            }
            int i8 = i6 + 1;
            arrayList.add(list.subList(i5, i8));
            i5 = i8;
        }
        String b5 = C1737f.b(arrayList.size(), 12);
        int i9 = 0;
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            if (((List) arrayList.get(i10)).size() == 1) {
                int intValue = ((Integer) ((List) arrayList.get(i10)).get(0)).intValue() - i9;
                i9 = ((Integer) ((List) arrayList.get(i10)).get(0)).intValue();
                b5 = b5 + "0" + C1734c.b(intValue);
            } else {
                int intValue2 = ((Integer) ((List) arrayList.get(i10)).get(0)).intValue() - i9;
                int intValue3 = ((Integer) ((List) arrayList.get(i10)).get(((List) arrayList.get(i10)).size() - 1)).intValue() - ((Integer) ((List) arrayList.get(i10)).get(0)).intValue();
                i9 = ((Integer) ((List) arrayList.get(i10)).get(((List) arrayList.get(i10)).size() - 1)).intValue();
                b5 = b5 + "1" + C1734c.b(intValue2) + C1734c.b(intValue3);
            }
        }
        return b5;
    }
}
