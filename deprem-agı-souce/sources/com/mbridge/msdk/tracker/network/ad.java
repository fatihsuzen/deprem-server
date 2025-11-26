package com.mbridge.msdk.tracker.network;

public abstract class ad extends Exception {

    /* renamed from: a  reason: collision with root package name */
    public final r f11562a;

    /* renamed from: b  reason: collision with root package name */
    private long f11563b;

    /* renamed from: c  reason: collision with root package name */
    private int f11564c;

    /* renamed from: d  reason: collision with root package name */
    private String f11565d;

    public ad() {
        this.f11564c = 0;
        this.f11565d = "";
        this.f11562a = null;
    }

    public abstract int a();

    /* access modifiers changed from: package-private */
    public final void a(long j5) {
        this.f11563b = j5;
    }

    public final int b() {
        return this.f11564c;
    }

    public final String c() {
        return this.f11565d;
    }

    public final void a(int i5) {
        this.f11564c = i5;
    }

    public final void a(String str) {
        this.f11565d = str;
    }

    public ad(r rVar) {
        this.f11564c = 0;
        this.f11565d = "";
        this.f11562a = rVar;
    }

    public ad(String str) {
        super(str);
        this.f11564c = 0;
        this.f11565d = "";
        this.f11562a = null;
    }

    public ad(Throwable th) {
        super(th);
        this.f11564c = 0;
        this.f11565d = "";
        this.f11562a = null;
    }
}
