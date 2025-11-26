package com.google.android.gms.internal.measurement;

import android.net.Uri;
import l0.c;

/* renamed from: com.google.android.gms.internal.measurement.g4  reason: case insensitive filesystem */
public final class C1106g4 {

    /* renamed from: a  reason: collision with root package name */
    final Uri f5357a;

    /* renamed from: b  reason: collision with root package name */
    final String f5358b;

    /* renamed from: c  reason: collision with root package name */
    final String f5359c;

    /* renamed from: d  reason: collision with root package name */
    final boolean f5360d;

    /* renamed from: e  reason: collision with root package name */
    final boolean f5361e;

    private C1106g4(String str, Uri uri, String str2, String str3, boolean z4, boolean z5, boolean z6, boolean z7, c cVar) {
        this.f5357a = uri;
        this.f5358b = "";
        this.f5359c = "";
        this.f5360d = z4;
        this.f5361e = z6;
    }

    public final C1106g4 a() {
        String str = this.f5358b;
        if (str.isEmpty()) {
            return new C1106g4((String) null, this.f5357a, str, this.f5359c, true, false, this.f5361e, false, (c) null);
        }
        throw new IllegalStateException("Cannot set GServices prefix and skip GServices");
    }

    public final C1106g4 b() {
        return new C1106g4((String) null, this.f5357a, this.f5358b, this.f5359c, this.f5360d, false, true, false, (c) null);
    }

    public final C1160m4 c(String str, long j5) {
        Long valueOf = Long.valueOf(j5);
        int i5 = C1160m4.f5443j;
        return new C1070c4(this, str, valueOf, true);
    }

    public final C1160m4 d(String str, boolean z4) {
        Boolean valueOf = Boolean.valueOf(z4);
        int i5 = C1160m4.f5443j;
        return new C1079d4(this, str, valueOf, true);
    }

    public final C1160m4 e(String str, double d5) {
        Double valueOf = Double.valueOf(-3.0d);
        int i5 = C1160m4.f5443j;
        return new C1088e4(this, "measurement.test.double_flag", valueOf, true);
    }

    public final C1160m4 f(String str, String str2) {
        int i5 = C1160m4.f5443j;
        return new C1097f4(this, str, str2, true);
    }

    public C1106g4(Uri uri) {
        this((String) null, uri, "", "", false, false, false, false, (c) null);
    }
}
