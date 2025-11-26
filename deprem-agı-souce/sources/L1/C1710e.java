package l1;

import java.util.Arrays;

/* renamed from: l1.e  reason: case insensitive filesystem */
public class C1710e extends C1708c {

    /* renamed from: e  reason: collision with root package name */
    private static C1710e f15539e = new C1710e();

    private C1710e() {
    }

    public static C1710e f() {
        return f15539e;
    }

    /* access modifiers changed from: protected */
    public String e(String str) {
        if (str.length() % 24 <= 0) {
            return str;
        }
        char[] cArr = new char[(24 - (str.length() % 24))];
        Arrays.fill(cArr, '0');
        return str + new String(cArr);
    }
}
