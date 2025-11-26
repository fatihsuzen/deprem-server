package o1;

import p1.C1752a;
import p1.C1753b;

/* renamed from: o1.a  reason: case insensitive filesystem */
public abstract class C1732a {
    public static boolean a(String str) {
        if (str.equals("1")) {
            return true;
        }
        if (str.equals("0")) {
            return false;
        }
        throw new C1752a("Undecodable Boolean '" + str + "'");
    }

    public static String b(Boolean bool) {
        if (bool.booleanValue()) {
            return "1";
        }
        if (!bool.booleanValue()) {
            return "0";
        }
        throw new C1753b("Unencodable Boolean '" + bool + "'");
    }
}
