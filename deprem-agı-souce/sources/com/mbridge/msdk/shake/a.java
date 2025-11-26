package com.mbridge.msdk.shake;

import android.content.Context;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.text.TextUtils;
import com.mbridge.msdk.foundation.controller.c;
import com.mbridge.msdk.foundation.download.core.DownloadCommon;
import com.mbridge.msdk.foundation.same.report.d.d;
import com.mbridge.msdk.foundation.tools.af;
import org.json.JSONObject;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    private SensorManager f11481a;

    /* renamed from: com.mbridge.msdk.shake.a$a  reason: collision with other inner class name */
    private static class C0107a {

        /* renamed from: a  reason: collision with root package name */
        static a f11482a = new a();
    }

    public static a a() {
        return C0107a.f11482a;
    }

    public final void b(SensorEventListener sensorEventListener) {
        SensorManager sensorManager = this.f11481a;
        if (sensorManager != null) {
            try {
                sensorManager.unregisterListener(sensorEventListener);
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    private a() {
    }

    public final void a(SensorEventListener sensorEventListener) {
        Context c5 = c.m().c();
        if (c5 != null) {
            try {
                if (this.f11481a == null) {
                    this.f11481a = (SensorManager) c5.getSystemService("sensor");
                }
                this.f11481a.registerListener(sensorEventListener, this.f11481a.getDefaultSensor(1), 2);
            } catch (Exception e5) {
                e5.printStackTrace();
                String message = e5.getMessage();
                if (!TextUtils.isEmpty(message)) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("key", "2000106");
                    if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f9179V)) {
                        jSONObject.put(DownloadCommon.DOWNLOAD_REPORT_FIND_FILE_RESULT_VALUE_B, com.mbridge.msdk.foundation.same.a.f9179V);
                    }
                    if (!TextUtils.isEmpty(com.mbridge.msdk.foundation.same.a.f9188g)) {
                        jSONObject.put("c", com.mbridge.msdk.foundation.same.a.f9188g);
                    }
                    jSONObject.put("reason", message);
                    d.a().a(jSONObject);
                }
            } catch (Throwable th) {
                af.b("NativeShakeManager", th.getMessage());
            }
        }
    }
}
