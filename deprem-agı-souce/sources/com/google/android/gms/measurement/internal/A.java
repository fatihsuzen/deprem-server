package com.google.android.gms.measurement.internal;

import java.util.Calendar;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public final class A extends B3 {

    /* renamed from: c  reason: collision with root package name */
    private long f5722c;

    /* renamed from: d  reason: collision with root package name */
    private String f5723d;

    A(X2 x22) {
        super(x22);
    }

    /* access modifiers changed from: protected */
    public final boolean i() {
        Calendar instance = Calendar.getInstance();
        this.f5722c = TimeUnit.MINUTES.convert((long) (instance.get(15) + instance.get(16)), TimeUnit.MILLISECONDS);
        Locale locale = Locale.getDefault();
        String language = locale.getLanguage();
        Locale locale2 = Locale.ENGLISH;
        String lowerCase = language.toLowerCase(locale2);
        String lowerCase2 = locale.getCountry().toLowerCase(locale2);
        StringBuilder sb = new StringBuilder(String.valueOf(lowerCase).length() + 1 + String.valueOf(lowerCase2).length());
        sb.append(lowerCase);
        sb.append("-");
        sb.append(lowerCase2);
        this.f5723d = sb.toString();
        return false;
    }

    public final long o() {
        l();
        return this.f5722c;
    }

    public final String p() {
        l();
        return this.f5723d;
    }
}
