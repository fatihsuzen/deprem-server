package com.google.firebase.installations;

import T0.d;
import V0.a;
import V0.b;
import android.text.TextUtils;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class i {

    /* renamed from: b  reason: collision with root package name */
    public static final long f7260b = TimeUnit.HOURS.toSeconds(1);

    /* renamed from: c  reason: collision with root package name */
    private static final Pattern f7261c = Pattern.compile("\\AA[\\w-]{38}\\z");

    /* renamed from: d  reason: collision with root package name */
    private static i f7262d;

    /* renamed from: a  reason: collision with root package name */
    private final a f7263a;

    private i(a aVar) {
        this.f7263a = aVar;
    }

    public static i c() {
        return d(b.a());
    }

    public static i d(a aVar) {
        if (f7262d == null) {
            f7262d = new i(aVar);
        }
        return f7262d;
    }

    static boolean g(String str) {
        return f7261c.matcher(str).matches();
    }

    static boolean h(String str) {
        return str.contains(":");
    }

    public long a() {
        return this.f7263a.currentTimeMillis();
    }

    public long b() {
        return TimeUnit.MILLISECONDS.toSeconds(a());
    }

    public long e() {
        return (long) (Math.random() * 1000.0d);
    }

    public boolean f(d dVar) {
        if (!TextUtils.isEmpty(dVar.b()) && dVar.h() + dVar.c() >= b() + f7260b) {
            return false;
        }
        return true;
    }
}
