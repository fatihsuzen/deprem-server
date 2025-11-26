package com.mbridge.msdk.tracker.network;

import com.mbridge.msdk.tracker.network.b;

public final class w<T> {

    /* renamed from: a  reason: collision with root package name */
    public final T f11720a;

    /* renamed from: b  reason: collision with root package name */
    public final b.a f11721b;

    /* renamed from: c  reason: collision with root package name */
    public final ad f11722c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f11723d;

    public interface a {
        void a(ad adVar);
    }

    public interface b<T> {
        void a(T t5);
    }

    private w(T t5, b.a aVar) {
        this.f11723d = false;
        this.f11720a = t5;
        this.f11721b = aVar;
        this.f11722c = null;
    }

    public static <T> w<T> a(T t5, b.a aVar) {
        return new w<>(t5, aVar);
    }

    public static <T> w<T> a(ad adVar) {
        return new w<>(adVar);
    }

    private w(ad adVar) {
        this.f11723d = false;
        this.f11720a = null;
        this.f11721b = null;
        this.f11722c = adVar;
    }
}
