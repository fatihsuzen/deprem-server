package com.mbridge.msdk.c;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.savedstate.serialization.ClassDiscriminatorModeKt;
import com.mbridge.msdk.foundation.same.net.e.d;
import org.json.JSONObject;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private int f7869a = 1;

    /* renamed from: b  reason: collision with root package name */
    private int f7870b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f7871c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f7872d = 0;

    /* renamed from: e  reason: collision with root package name */
    private String f7873e;

    /* renamed from: f  reason: collision with root package name */
    private String f7874f;

    /* renamed from: g  reason: collision with root package name */
    private int f7875g;

    /* renamed from: h  reason: collision with root package name */
    private int f7876h = 0;

    public static a a(String str) {
        a aVar;
        Exception e5;
        try {
            JSONObject jSONObject = new JSONObject(str);
            aVar = new a();
            try {
                aVar.f7873e = jSONObject.optString("http_domain", d.f().f9372g);
                aVar.f7874f = jSONObject.optString("tcp_domain", d.f().f9376k);
                aVar.f7875g = jSONObject.optInt("tcp_port", d.f().f9380o);
                aVar.f7876h = jSONObject.optInt(ClassDiscriminatorModeKt.CLASS_DISCRIMINATOR_KEY, 0);
                int i5 = 1;
                int optInt = jSONObject.optInt("batch_size", 1);
                if (optInt >= 1) {
                    i5 = optInt;
                }
                aVar.f7869a = i5;
                aVar.f7871c = jSONObject.optInt(TypedValues.TransitionType.S_DURATION, 0);
                aVar.f7870b = jSONObject.optInt("disable", 0);
                aVar.f7872d = jSONObject.optInt("e_t_l", 0);
                return aVar;
            } catch (Exception e6) {
                e5 = e6;
                e5.printStackTrace();
                return aVar;
            }
        } catch (Exception e7) {
            e5 = e7;
            aVar = null;
            e5.printStackTrace();
            return aVar;
        }
    }

    public final int b() {
        return this.f7870b;
    }

    public final int c() {
        return this.f7871c;
    }

    public final int d() {
        return this.f7872d;
    }

    public final String e() {
        return this.f7873e;
    }

    public final String f() {
        return this.f7874f;
    }

    public final int g() {
        return this.f7875g;
    }

    public final int h() {
        return this.f7876h;
    }

    public final int a() {
        return this.f7869a;
    }
}
