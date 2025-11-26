package x0;

import android.os.Process;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

/* renamed from: x0.i  reason: case insensitive filesystem */
class C1913i {

    /* renamed from: b  reason: collision with root package name */
    private static final String f16865b = C1914j.A(UUID.randomUUID().toString() + System.currentTimeMillis());

    /* renamed from: c  reason: collision with root package name */
    private static final AtomicLong f16866c = new AtomicLong(0);

    /* renamed from: a  reason: collision with root package name */
    private final String f16867a;

    C1913i() {
        byte[] bArr = new byte[10];
        f(bArr);
        e(bArr);
        d(bArr);
        String u5 = C1914j.u(bArr);
        Locale locale = Locale.US;
        this.f16867a = String.format(locale, "%s%s%s%s", new Object[]{u5.substring(0, 12), u5.substring(12, 16), u5.subSequence(16, 20), f16865b.substring(0, 12)}).toUpperCase(locale);
    }

    private static byte[] a(long j5) {
        ByteBuffer allocate = ByteBuffer.allocate(4);
        allocate.putInt((int) j5);
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    private static byte[] b(long j5) {
        ByteBuffer allocate = ByteBuffer.allocate(2);
        allocate.putShort((short) ((int) j5));
        allocate.order(ByteOrder.BIG_ENDIAN);
        allocate.position(0);
        return allocate.array();
    }

    private void d(byte[] bArr) {
        byte[] b5 = b((long) Integer.valueOf(Process.myPid()).shortValue());
        bArr[8] = b5[0];
        bArr[9] = b5[1];
    }

    private void e(byte[] bArr) {
        byte[] b5 = b(f16866c.incrementAndGet());
        bArr[6] = b5[0];
        bArr[7] = b5[1];
    }

    private void f(byte[] bArr) {
        long time = new Date().getTime();
        byte[] a5 = a(time / 1000);
        bArr[0] = a5[0];
        bArr[1] = a5[1];
        bArr[2] = a5[2];
        bArr[3] = a5[3];
        byte[] b5 = b(time % 1000);
        bArr[4] = b5[0];
        bArr[5] = b5[1];
    }

    public String c() {
        return this.f16867a;
    }

    public String toString() {
        return this.f16867a;
    }
}
