package com.google.android.gms.internal.measurement;

final class P5 implements C5 {

    /* renamed from: a  reason: collision with root package name */
    private final F5 f5129a;

    /* renamed from: b  reason: collision with root package name */
    private final String f5130b;

    /* renamed from: c  reason: collision with root package name */
    private final Object[] f5131c;

    /* renamed from: d  reason: collision with root package name */
    private final int f5132d;

    P5(F5 f5, String str, Object[] objArr) {
        this.f5129a = f5;
        this.f5130b = str;
        this.f5131c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f5132d = charAt;
            return;
        }
        char c5 = charAt & 8191;
        int i5 = 1;
        int i6 = 13;
        while (true) {
            int i7 = i5 + 1;
            char charAt2 = str.charAt(i5);
            if (charAt2 >= 55296) {
                c5 |= (charAt2 & 8191) << i6;
                i6 += 13;
                i5 = i7;
            } else {
                this.f5132d = c5 | (charAt2 << i6);
                return;
            }
        }
    }

    public final boolean A() {
        return (this.f5132d & 2) == 2;
    }

    public final F5 B() {
        return this.f5129a;
    }

    /* access modifiers changed from: package-private */
    public final String a() {
        return this.f5130b;
    }

    public final int b() {
        int i5 = this.f5132d;
        if ((i5 & 1) != 0) {
            return 1;
        }
        return (i5 & 4) == 4 ? 3 : 2;
    }

    /* access modifiers changed from: package-private */
    public final Object[] c() {
        return this.f5131c;
    }
}
