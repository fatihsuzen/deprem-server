package W2;

import e3.C2350b;
import java.io.PrintWriter;
import java.io.StringWriter;
import kotlin.jvm.internal.t;

/* renamed from: W2.f  reason: case insensitive filesystem */
abstract class C2217f {
    public static void a(Throwable th, Throwable th2) {
        t.e(th, "<this>");
        t.e(th2, "exception");
        if (th != th2) {
            C2350b.f21497a.a(th, th2);
        }
    }

    public static String b(Throwable th) {
        t.e(th, "<this>");
        StringWriter stringWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(stringWriter);
        th.printStackTrace(printWriter);
        printWriter.flush();
        String stringWriter2 = stringWriter.toString();
        t.d(stringWriter2, "toString(...)");
        return stringWriter2;
    }
}
