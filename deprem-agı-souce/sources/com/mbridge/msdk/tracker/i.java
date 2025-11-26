package com.mbridge.msdk.tracker;

import java.io.Serializable;

public final class i implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    static String f11514a = "CREATE TABLE IF NOT EXISTS %s (id INTEGER PRIMARY KEY,uuid TEXT,name TEXT,type INTEGER,time_stamp INTEGER,duration INTEGER,properties TEXT,priority INTEGER,state INTEGER,invalid_time INTEGER,ignore_max_timeout INTEGER,ignore_max_retry_times INTEGER,report_count INTEGER)";

    /* renamed from: b  reason: collision with root package name */
    static String f11515b = "DROP TABLE IF EXISTS %s";

    /* renamed from: c  reason: collision with root package name */
    private final e f11516c;

    /* renamed from: d  reason: collision with root package name */
    private int f11517d;

    /* renamed from: e  reason: collision with root package name */
    private int f11518e;

    /* renamed from: f  reason: collision with root package name */
    private final String f11519f;

    /* renamed from: g  reason: collision with root package name */
    private long f11520g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f11521h = false;

    /* renamed from: i  reason: collision with root package name */
    private boolean f11522i = false;

    public i(e eVar) {
        this.f11516c = eVar;
        this.f11519f = eVar.e();
    }

    public final void a(boolean z4) {
        this.f11521h = z4;
    }

    public final void b(boolean z4) {
        this.f11522i = z4;
    }

    public final e c() {
        return this.f11516c;
    }

    public final int d() {
        return this.f11517d;
    }

    public final int e() {
        return this.f11518e;
    }

    public final String f() {
        return this.f11519f;
    }

    public final long g() {
        return this.f11520g;
    }

    public final boolean a() {
        return this.f11521h;
    }

    public final boolean b() {
        return this.f11522i;
    }

    public final void a(int i5) {
        this.f11517d = i5;
    }

    public final void b(int i5) {
        this.f11518e = i5;
    }

    public final void a(long j5) {
        this.f11520g = j5;
    }
}
