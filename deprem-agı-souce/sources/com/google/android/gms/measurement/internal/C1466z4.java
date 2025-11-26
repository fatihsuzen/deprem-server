package com.google.android.gms.measurement.internal;

import java.util.Map;

/* renamed from: com.google.android.gms.measurement.internal.z4  reason: case insensitive filesystem */
final /* synthetic */ class C1466z4 implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final /* synthetic */ A4 f6930a;

    /* renamed from: b  reason: collision with root package name */
    private final /* synthetic */ int f6931b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ Exception f6932c;

    /* renamed from: d  reason: collision with root package name */
    private final /* synthetic */ byte[] f6933d;

    /* renamed from: e  reason: collision with root package name */
    private final /* synthetic */ Map f6934e;

    /* synthetic */ C1466z4(A4 a42, int i5, Exception exc, byte[] bArr, Map map) {
        this.f6930a = a42;
        this.f6931b = i5;
        this.f6932c = exc;
        this.f6933d = bArr;
        this.f6934e = map;
    }

    public final /* synthetic */ void run() {
        this.f6930a.a(this.f6931b, this.f6932c, this.f6933d, this.f6934e);
    }
}
