package h3;

import java.io.File;
import kotlin.jvm.internal.t;
import t3.s;

/* renamed from: h3.g  reason: case insensitive filesystem */
abstract class C2458g extends C2457f {
    public static String a(File file) {
        t.e(file, "<this>");
        String name = file.getName();
        t.d(name, "getName(...)");
        return s.P0(name, '.', "");
    }

    public static String b(File file) {
        t.e(file, "<this>");
        String name = file.getName();
        t.d(name, "getName(...)");
        return s.U0(name, ".", (String) null, 2, (Object) null);
    }
}
