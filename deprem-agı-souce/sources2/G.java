package com.finazzi.distquake;

class G {

    /* renamed from: a  reason: collision with root package name */
    private int f13136a;

    /* renamed from: b  reason: collision with root package name */
    private int f13137b;

    /* renamed from: c  reason: collision with root package name */
    private double[] f13138c;

    /* renamed from: d  reason: collision with root package name */
    private double[] f13139d;

    public G(int i8) {
        this.f13136a = i8;
        double d8 = (double) i8;
        int log = (int) (Math.log(d8) / Math.log(2.0d));
        this.f13137b = log;
        if (i8 == (1 << log)) {
            int i9 = i8 / 2;
            this.f13138c = new double[i9];
            this.f13139d = new double[i9];
            for (int i10 = 0; i10 < i9; i10++) {
                double d9 = (((double) i10) * -6.283185307179586d) / d8;
                this.f13138c[i10] = Math.cos(d9);
                this.f13139d[i10] = Math.sin(d9);
            }
            return;
        }
        throw new RuntimeException("FFT length must be power of 2");
    }

    public void a(double[] dArr, double[] dArr2) {
        int i8 = this.f13136a / 2;
        int i9 = 0;
        for (int i10 = 1; i10 < this.f13136a - 1; i10++) {
            int i11 = i8;
            while (i9 >= i11) {
                i9 -= i11;
                i11 /= 2;
            }
            i9 += i11;
            if (i10 < i9) {
                double d8 = dArr[i10];
                dArr[i10] = dArr[i9];
                dArr[i9] = d8;
                double d9 = dArr2[i10];
                dArr2[i10] = dArr2[i9];
                dArr2[i9] = d9;
            }
        }
        int i12 = 0;
        int i13 = 1;
        while (i12 < this.f13137b) {
            int i14 = i13 + i13;
            int i15 = 0;
            for (int i16 = 0; i16 < i13; i16++) {
                double d10 = this.f13138c[i15];
                double d11 = this.f13139d[i15];
                i15 += 1 << ((this.f13137b - i12) - 1);
                for (int i17 = i16; i17 < this.f13136a; i17 += i14) {
                    int i18 = i17 + i13;
                    double d12 = dArr[i18];
                    double d13 = dArr2[i18];
                    double d14 = (d10 * d12) - (d11 * d13);
                    double d15 = (d12 * d11) + (d13 * d10);
                    dArr[i18] = dArr[i17] - d14;
                    dArr2[i18] = dArr2[i17] - d15;
                    dArr[i17] = dArr[i17] + d14;
                    dArr2[i17] = dArr2[i17] + d15;
                }
            }
            i12++;
            i13 = i14;
        }
    }
}
