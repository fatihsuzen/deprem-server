package t3;

import X2.C2250q;
import androidx.appcompat.R;
import java.util.ArrayList;
import java.util.List;
import k3.l;
import kotlin.jvm.internal.t;
import s3.C2754h;

abstract class x extends t {
    private static final l e(String str) {
        if (str.length() == 0) {
            return new v();
        }
        return new w(str);
    }

    /* access modifiers changed from: private */
    public static final String f(String str) {
        t.e(str, "line");
        return str;
    }

    /* access modifiers changed from: private */
    public static final String g(String str, String str2) {
        t.e(str2, "line");
        return str + str2;
    }

    private static final int h(String str) {
        int length = str.length();
        int i5 = 0;
        while (true) {
            if (i5 >= length) {
                i5 = -1;
                break;
            } else if (!C2778b.c(str.charAt(i5))) {
                break;
            } else {
                i5++;
            }
        }
        if (i5 == -1) {
            return str.length();
        }
        return i5;
    }

    public static final String i(String str, String str2) {
        t.e(str, "<this>");
        t.e(str2, "indent");
        return C2754h.t(C2754h.v(C2771H.n0(str), new u(str2)), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (l) null, 62, (Object) null);
    }

    public static /* synthetic */ String j(String str, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str2 = "    ";
        }
        return i(str, str2);
    }

    /* access modifiers changed from: private */
    public static final String k(String str, String str2) {
        t.e(str2, "it");
        if (!C2771H.h0(str2)) {
            return str + str2;
        } else if (str2.length() < str.length()) {
            return str;
        } else {
            return str2;
        }
    }

    public static final String l(String str, String str2) {
        int i5;
        String str3;
        String str4 = str;
        t.e(str4, "<this>");
        String str5 = str2;
        t.e(str5, "newIndent");
        List o02 = C2771H.o0(str4);
        ArrayList arrayList = new ArrayList();
        for (Object next : o02) {
            if (!C2771H.h0((String) next)) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = new ArrayList(C2250q.p(arrayList, 10));
        int size = arrayList.size();
        int i6 = 0;
        int i7 = 0;
        while (i7 < size) {
            Object obj = arrayList.get(i7);
            i7++;
            arrayList2.add(Integer.valueOf(h((String) obj)));
        }
        Integer num = (Integer) C2250q.a0(arrayList2);
        if (num != null) {
            i5 = num.intValue();
        } else {
            i5 = 0;
        }
        int length = str4.length() + (str5.length() * o02.size());
        l e5 = e(str5);
        int i8 = C2250q.i(o02);
        ArrayList arrayList3 = new ArrayList();
        for (Object next2 : o02) {
            int i9 = i6 + 1;
            if (i6 < 0) {
                C2250q.o();
            }
            String str6 = (String) next2;
            if ((i6 == 0 || i6 == i8) && C2771H.h0(str6)) {
                str6 = null;
            } else {
                String Z02 = C2774K.Z0(str6, i5);
                if (!(Z02 == null || (str3 = (String) e5.invoke(Z02)) == null)) {
                    str6 = str3;
                }
            }
            if (str6 != null) {
                arrayList3.add(str6);
            }
            i6 = i9;
        }
        return ((StringBuilder) C2250q.T(arrayList3, new StringBuilder(length), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (l) null, R.styleable.AppCompatTheme_windowMinWidthMajor, (Object) null)).toString();
    }

    public static final String m(String str, String str2, String str3) {
        String str4;
        String str5;
        t.e(str, "<this>");
        t.e(str2, "newIndent");
        t.e(str3, "marginPrefix");
        if (!C2771H.h0(str3)) {
            List o02 = C2771H.o0(str);
            int length = str.length() + (str2.length() * o02.size());
            l e5 = e(str2);
            int i5 = C2250q.i(o02);
            ArrayList arrayList = new ArrayList();
            int i6 = 0;
            for (Object next : o02) {
                int i7 = i6 + 1;
                if (i6 < 0) {
                    C2250q.o();
                }
                String str6 = (String) next;
                String str7 = null;
                if ((i6 == 0 || i6 == i5) && C2771H.h0(str6)) {
                    str4 = str3;
                    str6 = null;
                } else {
                    int length2 = str6.length();
                    int i8 = 0;
                    while (true) {
                        if (i8 >= length2) {
                            i8 = -1;
                            break;
                        } else if (!C2778b.c(str6.charAt(i8))) {
                            break;
                        } else {
                            i8++;
                        }
                    }
                    if (i8 == -1) {
                        str4 = str3;
                    } else {
                        int i9 = i8;
                        str4 = str3;
                        if (C2768E.O(str6, str4, i9, false, 4, (Object) null)) {
                            t.c(str6, "null cannot be cast to non-null type java.lang.String");
                            str7 = str6.substring(str4.length() + i9);
                            t.d(str7, "substring(...)");
                        }
                    }
                    if (!(str7 == null || (str5 = (String) e5.invoke(str7)) == null)) {
                        str6 = str5;
                    }
                }
                if (str6 != null) {
                    arrayList.add(str6);
                }
                i6 = i7;
                str3 = str4;
            }
            return ((StringBuilder) C2250q.T(arrayList, new StringBuilder(length), "\n", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (l) null, R.styleable.AppCompatTheme_windowMinWidthMajor, (Object) null)).toString();
        }
        throw new IllegalArgumentException("marginPrefix must be non-blank string.");
    }

    public static String n(String str) {
        t.e(str, "<this>");
        return l(str, "");
    }

    public static final String o(String str, String str2) {
        t.e(str, "<this>");
        t.e(str2, "marginPrefix");
        return m(str, "", str2);
    }

    public static /* synthetic */ String p(String str, String str2, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            str2 = "|";
        }
        return o(str, str2);
    }
}
