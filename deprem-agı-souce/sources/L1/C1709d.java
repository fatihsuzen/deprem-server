package l1;

import java.util.Arrays;

/* renamed from: l1.d  reason: case insensitive filesystem */
public class C1709d extends C1708c {

    /* renamed from: e  reason: collision with root package name */
    private static C1709d f15538e = new C1709d();

    private C1709d() {
    }

    public static C1709d f() {
        return f15538e;
    }

    /* access modifiers changed from: protected */
    public String e(String str) {
        char[] cArr;
        char[] cArr2;
        if (str.length() % 8 > 0) {
            cArr = new char[(8 - (str.length() % 8))];
        } else {
            cArr = new char[0];
        }
        Arrays.fill(cArr, '0');
        if ((str.length() + cArr.length) % 6 > 0) {
            cArr2 = new char[(6 - ((str.length() + cArr.length) % 6))];
        } else {
            cArr2 = new char[0];
        }
        Arrays.fill(cArr2, '0');
        return str + new String(cArr) + new String(cArr2);
    }
}
