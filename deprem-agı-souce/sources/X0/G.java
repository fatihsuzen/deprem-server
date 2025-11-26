package x0;

import A0.F;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

class G implements L {

    /* renamed from: a  reason: collision with root package name */
    private final File f16813a;

    /* renamed from: b  reason: collision with root package name */
    private final String f16814b;

    /* renamed from: c  reason: collision with root package name */
    private final String f16815c;

    G(String str, String str2, File file) {
        this.f16814b = str;
        this.f16815c = str2;
        this.f16813a = file;
    }

    private byte[] c() {
        InputStream stream;
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream;
        byte[] bArr = new byte[8192];
        try {
            stream = getStream();
            byteArrayOutputStream = new ByteArrayOutputStream();
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            if (stream == null) {
                gZIPOutputStream.close();
                byteArrayOutputStream.close();
                if (stream != null) {
                    stream.close();
                }
                return null;
            }
            while (true) {
                int read = stream.read(bArr);
                if (read > 0) {
                    gZIPOutputStream.write(bArr, 0, read);
                } else {
                    gZIPOutputStream.finish();
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    gZIPOutputStream.close();
                    byteArrayOutputStream.close();
                    stream.close();
                    return byteArray;
                }
            }
            throw th;
            throw th;
            throw th;
        } catch (IOException unused) {
            return null;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
    }

    public String a() {
        return this.f16815c;
    }

    public F.d.b b() {
        byte[] c5 = c();
        if (c5 != null) {
            return F.d.b.a().b(c5).c(this.f16814b).a();
        }
        return null;
    }

    public InputStream getStream() {
        if (this.f16813a.exists() && this.f16813a.isFile()) {
            try {
                return new FileInputStream(this.f16813a);
            } catch (FileNotFoundException unused) {
            }
        }
        return null;
    }
}
