package com.mbridge.msdk.video.signal.factory;

import com.mbridge.msdk.video.signal.a.e;
import com.mbridge.msdk.video.signal.a.h;
import com.mbridge.msdk.video.signal.b;
import com.mbridge.msdk.video.signal.c;
import com.mbridge.msdk.video.signal.d;
import com.mbridge.msdk.video.signal.f;
import com.mbridge.msdk.video.signal.g;
import com.mbridge.msdk.video.signal.i;
import com.mbridge.msdk.video.signal.j;

public class a implements IJSFactory {

    /* renamed from: a  reason: collision with root package name */
    protected b f12976a;

    /* renamed from: b  reason: collision with root package name */
    protected d f12977b;

    /* renamed from: c  reason: collision with root package name */
    protected j f12978c;

    /* renamed from: d  reason: collision with root package name */
    protected g f12979d;

    /* renamed from: e  reason: collision with root package name */
    protected f f12980e;

    /* renamed from: f  reason: collision with root package name */
    protected i f12981f;

    /* renamed from: g  reason: collision with root package name */
    protected c f12982g;

    public b getActivityProxy() {
        if (this.f12976a == null) {
            this.f12976a = new com.mbridge.msdk.video.signal.a.b();
        }
        return this.f12976a;
    }

    public i getIJSRewardVideoV1() {
        if (this.f12981f == null) {
            this.f12981f = new com.mbridge.msdk.video.signal.a.g();
        }
        return this.f12981f;
    }

    public c getJSBTModule() {
        if (this.f12982g == null) {
            this.f12982g = new com.mbridge.msdk.video.signal.a.c();
        }
        return this.f12982g;
    }

    public d getJSCommon() {
        if (this.f12977b == null) {
            this.f12977b = new com.mbridge.msdk.video.signal.a.d();
        }
        return this.f12977b;
    }

    public f getJSContainerModule() {
        if (this.f12980e == null) {
            this.f12980e = new e();
        }
        return this.f12980e;
    }

    public g getJSNotifyProxy() {
        if (this.f12979d == null) {
            this.f12979d = new com.mbridge.msdk.video.signal.a.f();
        }
        return this.f12979d;
    }

    public j getJSVideoModule() {
        if (this.f12978c == null) {
            this.f12978c = new h();
        }
        return this.f12978c;
    }
}
