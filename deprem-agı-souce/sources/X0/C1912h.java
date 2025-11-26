package x0;

import A0.F;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.GZIPOutputStream;

/* renamed from: x0.h  reason: case insensitive filesystem */
class C1912h implements L {

    /* renamed from: a  reason: collision with root package name */
    private final byte[] f16862a;

    /* renamed from: b  reason: collision with root package name */
    private final String f16863b;

    /* renamed from: c  reason: collision with root package name */
    private final String f16864c;

    C1912h(String str, String str2, byte[] bArr) {
        this.f16863b = str;
        this.f16864c = str2;
        this.f16862a = bArr;
    }

    private byte[] c() {
        ByteArrayOutputStream byteArrayOutputStream;
        GZIPOutputStream gZIPOutputStream;
        if (d()) {
            return null;
        }
        try {
            byteArrayOutputStream = new ByteArrayOutputStream();
            gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(this.f16862a);
            gZIPOutputStream.finish();
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (IOException unused) {
            return null;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
        throw th;
    }

    private boolean d() {
        byte[] bArr = this.f16862a;
        if (bArr == null || bArr.length == 0) {
            return true;
        }
        return false;
    }

    public String a() {
        return this.f16864c;
    }

    public F.d.b b() {
        byte[] c5 = c();
        if (c5 == null) {
            return null;
        }
        return F.d.b.a().b(c5).c(this.f16863b).a();
    }

    public InputStream getStream() {
        if (d()) {
            return null;
        }
        return new ByteArrayInputStream(this.f16862a);
    }
}
