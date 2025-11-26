package K;

import java.lang.ref.WeakReference;

abstract class B extends z {

    /* renamed from: k  reason: collision with root package name */
    private static final WeakReference f2669k = new WeakReference((Object) null);

    /* renamed from: b  reason: collision with root package name */
    private WeakReference f2670b = f2669k;

    B(byte[] bArr) {
        super(bArr);
    }

    /* access modifiers changed from: package-private */
    public final byte[] q0() {
        byte[] bArr;
        synchronized (this) {
            try {
                bArr = (byte[]) this.f2670b.get();
                if (bArr == null) {
                    bArr = r0();
                    this.f2670b = new WeakReference(bArr);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return bArr;
    }

    /* access modifiers changed from: protected */
    public abstract byte[] r0();
}
