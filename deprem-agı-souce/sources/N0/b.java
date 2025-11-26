package N0;

import java.io.OutputStream;

final class b extends OutputStream {

    /* renamed from: a  reason: collision with root package name */
    private long f3165a = 0;

    b() {
    }

    /* access modifiers changed from: package-private */
    public long a() {
        return this.f3165a;
    }

    public void write(int i5) {
        this.f3165a++;
    }

    public void write(byte[] bArr) {
        this.f3165a += (long) bArr.length;
    }

    public void write(byte[] bArr, int i5, int i6) {
        int i7;
        if (i5 < 0 || i5 > bArr.length || i6 < 0 || (i7 = i5 + i6) > bArr.length || i7 < 0) {
            throw new IndexOutOfBoundsException();
        }
        this.f3165a += (long) i6;
    }
}
