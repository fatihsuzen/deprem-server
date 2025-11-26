package com.mbridge.msdk.shake;

import android.hardware.Sensor;
import android.hardware.SensorEventListener;

public abstract class b implements SensorEventListener {

    /* renamed from: a  reason: collision with root package name */
    private int f11483a;

    /* renamed from: b  reason: collision with root package name */
    private int f11484b;

    /* renamed from: d  reason: collision with root package name */
    public long f11485d = 0;

    /* renamed from: e  reason: collision with root package name */
    public float f11486e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    public float f11487f = 0.0f;

    /* renamed from: g  reason: collision with root package name */
    public float f11488g = 0.0f;

    public b(int i5, int i6) {
        this.f11483a = i5;
        this.f11484b = i6;
    }

    public abstract void a();

    public void onAccuracyChanged(Sensor sensor, int i5) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0046, code lost:
        if (java.lang.Math.abs(r9 - r2) > ((float) r8.f11483a)) goto L_0x0048;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSensorChanged(android.hardware.SensorEvent r9) {
        /*
            r8 = this;
            float[] r9 = r9.values
            r0 = 0
            r0 = r9[r0]
            float r0 = -r0
            r1 = 1
            r1 = r9[r1]
            float r1 = -r1
            r2 = 2
            r9 = r9[r2]
            float r9 = -r9
            float r2 = r8.f11486e
            r3 = 0
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 == 0) goto L_0x0022
            float r2 = r0 - r2
            float r2 = java.lang.Math.abs(r2)
            int r4 = r8.f11483a
            float r4 = (float) r4
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x0048
        L_0x0022:
            float r2 = r8.f11487f
            int r4 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r4 == 0) goto L_0x0035
            float r2 = r1 - r2
            float r2 = java.lang.Math.abs(r2)
            int r4 = r8.f11483a
            float r4 = (float) r4
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 > 0) goto L_0x0048
        L_0x0035:
            float r2 = r8.f11488g
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x005c
            float r2 = r9 - r2
            float r2 = java.lang.Math.abs(r2)
            int r3 = r8.f11483a
            float r3 = (float) r3
            int r2 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r2 <= 0) goto L_0x005c
        L_0x0048:
            long r2 = java.lang.System.currentTimeMillis()
            long r4 = r8.f11485d
            long r4 = r2 - r4
            int r6 = r8.f11484b
            long r6 = (long) r6
            int r4 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r4 <= 0) goto L_0x005c
            r8.f11485d = r2
            r8.a()
        L_0x005c:
            r8.f11486e = r0
            r8.f11487f = r1
            r8.f11488g = r9
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mbridge.msdk.shake.b.onSensorChanged(android.hardware.SensorEvent):void");
    }
}
