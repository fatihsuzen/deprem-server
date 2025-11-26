package Y3;

import androidx.browser.trusted.sharing.ShareTarget;

public abstract class f {
    public static boolean a(String str) {
        if (str.equals(ShareTarget.METHOD_POST) || str.equals("PATCH") || str.equals("PUT") || str.equals("DELETE") || str.equals("MOVE")) {
            return true;
        }
        return false;
    }

    public static boolean b(String str) {
        if (str.equals(ShareTarget.METHOD_GET) || str.equals("HEAD")) {
            return false;
        }
        return true;
    }

    public static boolean c(String str) {
        return !str.equals("PROPFIND");
    }

    public static boolean d(String str) {
        return str.equals("PROPFIND");
    }

    public static boolean e(String str) {
        if (str.equals(ShareTarget.METHOD_POST) || str.equals("PUT") || str.equals("PATCH") || str.equals("PROPPATCH") || str.equals("REPORT")) {
            return true;
        }
        return false;
    }
}
