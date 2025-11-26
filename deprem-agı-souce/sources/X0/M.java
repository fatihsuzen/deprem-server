package x0;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;
import java.util.zip.GZIPOutputStream;

abstract class M {
    private static void a(InputStream inputStream, File file) {
        if (inputStream != null) {
            byte[] bArr = new byte[8192];
            GZIPOutputStream gZIPOutputStream = null;
            try {
                GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(new FileOutputStream(file));
                while (true) {
                    try {
                        int read = inputStream.read(bArr);
                        if (read > 0) {
                            gZIPOutputStream2.write(bArr, 0, read);
                        } else {
                            gZIPOutputStream2.finish();
                            C1914j.g(gZIPOutputStream2);
                            return;
                        }
                    } catch (Throwable th) {
                        th = th;
                        gZIPOutputStream = gZIPOutputStream2;
                        C1914j.g(gZIPOutputStream);
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                C1914j.g(gZIPOutputStream);
                throw th;
            }
        }
    }

    static void b(File file, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            L l5 = (L) it.next();
            InputStream inputStream = null;
            try {
                inputStream = l5.getStream();
                if (inputStream != null) {
                    a(inputStream, new File(file, l5.a()));
                }
            } catch (IOException unused) {
            } catch (Throwable th) {
                C1914j.g(inputStream);
                throw th;
            }
            C1914j.g(inputStream);
        }
    }
}
