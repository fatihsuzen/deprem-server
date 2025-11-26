package a4;

import java.util.Arrays;

public final class m {

    /* renamed from: a  reason: collision with root package name */
    private int f20468a;

    /* renamed from: b  reason: collision with root package name */
    private final int[] f20469b = new int[10];

    /* access modifiers changed from: package-private */
    public void a() {
        this.f20468a = 0;
        Arrays.fill(this.f20469b, 0);
    }

    /* access modifiers changed from: package-private */
    public int b(int i5) {
        return this.f20469b[i5];
    }

    /* access modifiers changed from: package-private */
    public int c() {
        if ((this.f20468a & 2) != 0) {
            return this.f20469b[1];
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public int d() {
        if ((this.f20468a & 128) != 0) {
            return this.f20469b[7];
        }
        return 65535;
    }

    /* access modifiers changed from: package-private */
    public int e(int i5) {
        if ((this.f20468a & 16) != 0) {
            return this.f20469b[4];
        }
        return i5;
    }

    /* access modifiers changed from: package-private */
    public int f(int i5) {
        if ((this.f20468a & 32) != 0) {
            return this.f20469b[5];
        }
        return i5;
    }

    /* access modifiers changed from: package-private */
    public boolean g(int i5) {
        if (((1 << i5) & this.f20468a) != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void h(m mVar) {
        for (int i5 = 0; i5 < 10; i5++) {
            if (mVar.g(i5)) {
                i(i5, mVar.b(i5));
            }
        }
    }

    /* access modifiers changed from: package-private */
    public m i(int i5, int i6) {
        if (i5 >= 0) {
            int[] iArr = this.f20469b;
            if (i5 < iArr.length) {
                this.f20468a = (1 << i5) | this.f20468a;
                iArr[i5] = i6;
            }
        }
        return this;
    }

    /* access modifiers changed from: package-private */
    public int j() {
        return Integer.bitCount(this.f20468a);
    }
}
