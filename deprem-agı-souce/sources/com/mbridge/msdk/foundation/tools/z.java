package com.mbridge.msdk.foundation.tools;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class z {

    /* renamed from: a  reason: collision with root package name */
    private static final String f9753a = "z";

    /* renamed from: b  reason: collision with root package name */
    private static Map<Character, Character> f9754b;

    /* renamed from: c  reason: collision with root package name */
    private static Map<Character, Character> f9755c;

    /* renamed from: d  reason: collision with root package name */
    private static byte[] f9756d = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, 63, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    /* renamed from: e  reason: collision with root package name */
    private static char[] f9757e = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    static {
        HashMap hashMap = new HashMap();
        f9754b = hashMap;
        hashMap.put('v', 'A');
        f9754b.put('S', 'B');
        f9754b.put('o', 'C');
        f9754b.put('a', 'D');
        f9754b.put('j', 'E');
        f9754b.put('c', 'F');
        f9754b.put('7', 'G');
        f9754b.put('d', 'H');
        f9754b.put('R', 'I');
        f9754b.put('z', 'J');
        f9754b.put('p', 'K');
        f9754b.put('W', 'L');
        f9754b.put('i', 'M');
        f9754b.put('f', 'N');
        f9754b.put('G', 'O');
        f9754b.put('y', 'P');
        f9754b.put('N', 'Q');
        f9754b.put('x', 'R');
        f9754b.put('Z', 'S');
        f9754b.put('n', 'T');
        f9754b.put('V', 'U');
        f9754b.put('5', 'V');
        f9754b.put('k', 'W');
        f9754b.put('+', 'X');
        f9754b.put('D', 'Y');
        f9754b.put('H', 'Z');
        f9754b.put('L', 'a');
        f9754b.put('Y', 'b');
        f9754b.put('h', 'c');
        f9754b.put('J', 'd');
        f9754b.put('4', 'e');
        f9754b.put('6', 'f');
        f9754b.put('l', 'g');
        f9754b.put('t', 'h');
        f9754b.put('0', 'i');
        f9754b.put('U', 'j');
        f9754b.put('3', 'k');
        f9754b.put('Q', 'l');
        f9754b.put('r', 'm');
        f9754b.put('g', 'n');
        f9754b.put('E', 'o');
        f9754b.put('u', 'p');
        f9754b.put('q', 'q');
        f9754b.put('8', 'r');
        f9754b.put('s', 's');
        f9754b.put('w', 't');
        f9754b.put('/', 'u');
        f9754b.put('X', 'v');
        f9754b.put('M', 'w');
        f9754b.put('e', 'x');
        f9754b.put('B', 'y');
        f9754b.put('A', 'z');
        f9754b.put('T', '0');
        f9754b.put('2', '1');
        f9754b.put('F', '2');
        f9754b.put('b', '3');
        f9754b.put('9', '4');
        f9754b.put('P', '5');
        f9754b.put('1', '6');
        f9754b.put('O', 55);
        f9754b.put('I', '8');
        f9754b.put('K', '9');
        f9754b.put('m', '+');
        f9754b.put(67, '/');
        HashMap hashMap2 = new HashMap();
        f9755c = hashMap2;
        hashMap2.put('A', 'v');
        f9755c.put('B', 'S');
        f9755c.put(67, 'o');
        f9755c.put('D', 'a');
        f9755c.put('E', 'j');
        f9755c.put('F', 'c');
        f9755c.put('G', 55);
        f9755c.put('H', 100);
        f9755c.put('I', 'R');
        f9755c.put('J', 'z');
        f9755c.put('K', 'p');
        f9755c.put('L', 'W');
        f9755c.put('M', 'i');
        f9755c.put('N', 'f');
        f9755c.put('O', 'G');
        f9755c.put('P', 'y');
        f9755c.put('Q', 'N');
        f9755c.put('R', 'x');
        f9755c.put('S', 'Z');
        f9755c.put('T', 'n');
        f9755c.put('U', 'V');
        f9755c.put('V', '5');
        f9755c.put('W', 'k');
        f9755c.put('X', '+');
        f9755c.put('Y', 'D');
        f9755c.put('Z', 'H');
        f9755c.put('a', 'L');
        f9755c.put('b', 'Y');
        f9755c.put('c', 'h');
        f9755c.put(100, 'J');
        f9755c.put('e', '4');
        f9755c.put('f', '6');
        f9755c.put('g', 'l');
        f9755c.put('h', 't');
        f9755c.put('i', '0');
        f9755c.put('j', 'U');
        f9755c.put('k', '3');
        f9755c.put('l', 'Q');
        f9755c.put('m', 'r');
        f9755c.put('n', 'g');
        f9755c.put('o', 'E');
        f9755c.put('p', 'u');
        f9755c.put('q', 'q');
        f9755c.put('r', '8');
        f9755c.put('s', 's');
        f9755c.put('t', 'w');
        f9755c.put('u', '/');
        f9755c.put('v', 'X');
        f9755c.put('w', 'M');
        f9755c.put('x', 'e');
        f9755c.put('y', 'B');
        f9755c.put('z', 'A');
        f9755c.put('0', 'T');
        f9755c.put('1', '2');
        f9755c.put('2', 'F');
        f9755c.put('3', 'b');
        f9755c.put('4', '9');
        f9755c.put('5', 'P');
        f9755c.put('6', '1');
        f9755c.put(55, 'O');
        f9755c.put('8', 'I');
        f9755c.put('9', 'K');
        f9755c.put('+', 'm');
        f9755c.put('/', 67);
    }

    private z() {
    }

    public static String a(String str) {
        return ag.a(str);
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return ag.b(str);
    }
}
