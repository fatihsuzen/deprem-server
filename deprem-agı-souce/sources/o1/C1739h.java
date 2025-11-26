package o1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.logging.Logger;
import java.util.regex.Pattern;
import p1.C1752a;

/* renamed from: o1.h  reason: case insensitive filesystem */
public abstract class C1739h {

    /* renamed from: a  reason: collision with root package name */
    private static final Logger f15667a = Logger.getLogger(C1739h.class.getName());

    /* renamed from: b  reason: collision with root package name */
    private static Pattern f15668b = Pattern.compile("^[0-1]*$", 2);

    public static List a(String str) {
        if (f15668b.matcher(str).matches()) {
            int i5 = 12;
            if (str.length() >= 12) {
                ArrayList arrayList = new ArrayList();
                int a5 = C1737f.a(str.substring(0, 12));
                for (int i6 = 0; i6 < a5; i6++) {
                    int i7 = i5 + 1;
                    if (C1732a.a(str.substring(i5, i7))) {
                        int i8 = i5 + 17;
                        int a6 = C1737f.a(str.substring(i7, i8));
                        i5 += 33;
                        int a7 = C1737f.a(str.substring(i8, i5));
                        if (a7 < a6) {
                            throw new C1752a("FixedIntegerRange has invalid range");
                        } else if (arrayList.size() + (a7 - a6) > 8192) {
                            f15667a.warning("FixedIntegerRange has too many values");
                            return arrayList;
                        } else {
                            while (a6 <= a7) {
                                arrayList.add(Integer.valueOf(a6));
                                a6++;
                            }
                        }
                    } else {
                        i5 += 17;
                        int a8 = C1737f.a(str.substring(i7, i5));
                        if (arrayList.size() == 8192) {
                            f15667a.warning("FixedIntegerRange has too many values");
                            return arrayList;
                        }
                        arrayList.add(Integer.valueOf(a8));
                    }
                }
                return arrayList;
            }
        }
        throw new C1752a("Undecodable FixedIntegerRange '" + str + "'");
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
        for (int i9 = 0; i9 < arrayList.size(); i9++) {
            if (((List) arrayList.get(i9)).size() == 1) {
                b5 = b5 + "0" + C1737f.b(((Integer) ((List) arrayList.get(i9)).get(0)).intValue(), 16);
            } else {
                b5 = b5 + "1" + C1737f.b(((Integer) ((List) arrayList.get(i9)).get(0)).intValue(), 16) + C1737f.b(((Integer) ((List) arrayList.get(i9)).get(((List) arrayList.get(i9)).size() - 1)).intValue(), 16);
            }
        }
        return b5;
    }
}
