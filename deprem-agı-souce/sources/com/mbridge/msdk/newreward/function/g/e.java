package com.mbridge.msdk.newreward.function.g;

import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.newreward.function.command.c;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public final class e implements InvocationHandler {

    /* renamed from: a  reason: collision with root package name */
    b f11010a;

    /* renamed from: b  reason: collision with root package name */
    private Object f11011b;

    public e(Object obj, com.mbridge.msdk.newreward.a.e eVar, c cVar) {
        this.f11011b = obj;
        try {
            this.f11010a = new b(obj, eVar, cVar);
        } catch (Exception unused) {
            if (eVar.a() != null) {
                eVar.a().quitSafely();
            }
        }
    }

    public final Object invoke(Object obj, Method method, Object[] objArr) throws Throwable {
        Object obj2;
        try {
            obj2 = method.invoke(this.f11011b, objArr);
        } catch (Exception e5) {
            if (MBridgeConstans.DEBUG) {
                e5.printStackTrace();
            }
            obj2 = null;
        }
        long currentTimeMillis = System.currentTimeMillis();
        b bVar = this.f11010a;
        if (bVar == null) {
            return obj2;
        }
        bVar.a(obj2, method, objArr);
        long currentTimeMillis2 = System.currentTimeMillis();
        af.b("ReportHandler", "方法名：" + method.getName() + " 耗时为：" + String.valueOf(currentTimeMillis2 - currentTimeMillis));
        return obj2;
    }
}
