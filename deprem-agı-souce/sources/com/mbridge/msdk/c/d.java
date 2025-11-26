package com.mbridge.msdk.c;

import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import org.json.JSONObject;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private int f7997a = 1;

    /* renamed from: b  reason: collision with root package name */
    private int f7998b = 1;

    /* renamed from: c  reason: collision with root package name */
    private int f7999c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f8000d = 30;

    /* renamed from: e  reason: collision with root package name */
    private int f8001e = 0;

    /* renamed from: f  reason: collision with root package name */
    private String f8002f;

    /* renamed from: g  reason: collision with root package name */
    private String f8003g;

    /* renamed from: h  reason: collision with root package name */
    private int f8004h;

    /* renamed from: i  reason: collision with root package name */
    private int f8005i = 0;

    public static d a(String str) {
        d dVar;
        Exception e5;
        try {
            JSONObject jSONObject = new JSONObject(str);
            dVar = new d();
            try {
                dVar.f8002f = jSONObject.optString("h_d", com.mbridge.msdk.foundation.same.net.e.d.f().f9370e);
                dVar.f8003g = jSONObject.optString("t_d", com.mbridge.msdk.foundation.same.net.e.d.f().f9375j);
                dVar.f8004h = jSONObject.optInt("t_p", com.mbridge.msdk.foundation.same.net.e.d.f().f9379n);
                dVar.f8005i = jSONObject.optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 1);
                dVar.f8000d = jSONObject.optInt("d_t", 30);
                dVar.f7999c = jSONObject.optInt("d_a", 0);
                return dVar;
            } catch (Exception e6) {
                e5 = e6;
                e5.printStackTrace();
                return dVar;
            }
        } catch (Exception e7) {
            e5 = e7;
            dVar = null;
            e5.printStackTrace();
            return dVar;
        }
    }

    public final int b() {
        return this.f8000d;
    }

    public final String c() {
        return this.f8002f;
    }

    public final String d() {
        return this.f8003g;
    }

    public final int e() {
        return this.f8004h;
    }

    public final int a() {
        return this.f7999c;
    }
}
