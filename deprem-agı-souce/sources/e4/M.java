package e4;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.logging.Logger;
import kotlin.jvm.internal.t;
import t3.s;

abstract /* synthetic */ class M {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final Logger f21498a = Logger.getLogger("okio.Okio");

    public static final X b(File file) {
        t.e(file, "<this>");
        return L.h(new FileOutputStream(file, true));
    }

    public static final boolean c(AssertionError assertionError) {
        boolean z4;
        t.e(assertionError, "<this>");
        if (assertionError.getCause() != null) {
            String message = assertionError.getMessage();
            if (message != null) {
                z4 = s.V(message, "getsockname failed", false, 2, (Object) null);
            } else {
                z4 = false;
            }
            if (z4) {
                return true;
            }
        }
        return false;
    }

    public static final X d(File file) {
        t.e(file, "<this>");
        return h(file, false, 1, (Object) null);
    }

    public static final X e(File file, boolean z4) {
        t.e(file, "<this>");
        return L.h(new FileOutputStream(file, z4));
    }

    public static final X f(OutputStream outputStream) {
        t.e(outputStream, "<this>");
        return new O(outputStream, new a0());
    }

    public static final X g(Socket socket) {
        t.e(socket, "<this>");
        Y y4 = new Y(socket);
        OutputStream outputStream = socket.getOutputStream();
        t.d(outputStream, "getOutputStream()");
        return y4.z(new O(outputStream, y4));
    }

    public static /* synthetic */ X h(File file, boolean z4, int i5, Object obj) {
        if ((i5 & 1) != 0) {
            z4 = false;
        }
        return L.g(file, z4);
    }

    public static final Z i(File file) {
        t.e(file, "<this>");
        return new C2368q(new FileInputStream(file), a0.f21531e);
    }

    public static final Z j(InputStream inputStream) {
        t.e(inputStream, "<this>");
        return new C2368q(inputStream, new a0());
    }

    public static final Z k(Socket socket) {
        t.e(socket, "<this>");
        Y y4 = new Y(socket);
        InputStream inputStream = socket.getInputStream();
        t.d(inputStream, "getInputStream()");
        return y4.A(new C2368q(inputStream, y4));
    }
}
