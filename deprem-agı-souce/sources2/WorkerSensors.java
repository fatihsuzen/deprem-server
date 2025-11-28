package com.finazzi.distquake;

import Z0.C0702j;
import Z0.O;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.hardware.Sensor;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.display.DisplayManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.PowerManager;
import android.os.SystemClock;
import android.util.Log;
import android.view.Display;
import androidx.concurrent.futures.c;
import androidx.core.app.m;
import androidx.work.WorkerParameters;
import androidx.work.c;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;
import java.util.Random;
import u2.U1;
import u2.U4;
import u2.V4;
import u2.W4;

public class WorkerSensors extends androidx.work.c implements SensorEventListener {

    /* renamed from: A  reason: collision with root package name */
    private boolean f13590A = false;

    /* renamed from: A0  reason: collision with root package name */
    private int f13591A0 = 0;

    /* renamed from: B  reason: collision with root package name */
    private final float[] f13592B = new float[3];

    /* renamed from: B0  reason: collision with root package name */
    private double f13593B0 = 0.0d;

    /* renamed from: C  reason: collision with root package name */
    private final float[] f13594C = new float[20000];

    /* renamed from: C0  reason: collision with root package name */
    private final float[] f13595C0 = new float[3];

    /* renamed from: D  reason: collision with root package name */
    private double[] f13596D;

    /* renamed from: D0  reason: collision with root package name */
    private final float[] f13597D0 = new float[3];

    /* renamed from: E  reason: collision with root package name */
    private final double[] f13598E = new double[ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED];

    /* renamed from: E0  reason: collision with root package name */
    private final float[] f13599E0 = new float[16];

    /* renamed from: F  reason: collision with root package name */
    private final double[] f13600F = new double[ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED];

    /* renamed from: F0  reason: collision with root package name */
    private final float[] f13601F0 = new float[4];

    /* renamed from: G  reason: collision with root package name */
    private final long[] f13602G = new long[ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED];

    /* renamed from: G0  reason: collision with root package name */
    private float[] f13603G0;

    /* renamed from: H  reason: collision with root package name */
    private long f13604H;

    /* renamed from: H0  reason: collision with root package name */
    private boolean f13605H0 = false;

    /* renamed from: I  reason: collision with root package name */
    private long f13606I;
    /* access modifiers changed from: private */

    /* renamed from: I0  reason: collision with root package name */
    public Handler f13607I0;

    /* renamed from: J  reason: collision with root package name */
    private long f13608J;
    /* access modifiers changed from: private */

    /* renamed from: J0  reason: collision with root package name */
    public e f13609J0;

    /* renamed from: K  reason: collision with root package name */
    private long f13610K;

    /* renamed from: L  reason: collision with root package name */
    private long f13611L;
    /* access modifiers changed from: private */

    /* renamed from: M  reason: collision with root package name */
    public long f13612M;

    /* renamed from: N  reason: collision with root package name */
    private long f13613N;

    /* renamed from: O  reason: collision with root package name */
    private long f13614O;

    /* renamed from: P  reason: collision with root package name */
    private long f13615P = 0;
    /* access modifiers changed from: private */

    /* renamed from: Q  reason: collision with root package name */
    public boolean f13616Q;

    /* renamed from: R  reason: collision with root package name */
    private int f13617R = 0;

    /* renamed from: S  reason: collision with root package name */
    private int f13618S = 0;
    /* access modifiers changed from: private */

    /* renamed from: T  reason: collision with root package name */
    public int f13619T = 0;
    /* access modifiers changed from: private */

    /* renamed from: U  reason: collision with root package name */
    public long f13620U;
    /* access modifiers changed from: private */

    /* renamed from: V  reason: collision with root package name */
    public double f13621V;
    /* access modifiers changed from: private */

    /* renamed from: W  reason: collision with root package name */
    public double f13622W;
    /* access modifiers changed from: private */

    /* renamed from: X  reason: collision with root package name */
    public double f13623X;
    /* access modifiers changed from: private */

    /* renamed from: Y  reason: collision with root package name */
    public double f13624Y;
    /* access modifiers changed from: private */

    /* renamed from: Z  reason: collision with root package name */
    public double f13625Z;
    /* access modifiers changed from: private */

    /* renamed from: a0  reason: collision with root package name */
    public int f13626a0;
    /* access modifiers changed from: private */

    /* renamed from: b0  reason: collision with root package name */
    public int f13627b0;
    /* access modifiers changed from: private */

    /* renamed from: c0  reason: collision with root package name */
    public int f13628c0;
    /* access modifiers changed from: private */

    /* renamed from: d0  reason: collision with root package name */
    public long f13629d0;

    /* renamed from: e  reason: collision with root package name */
    private Context f13630e;
    /* access modifiers changed from: private */

    /* renamed from: e0  reason: collision with root package name */
    public long f13631e0;

    /* renamed from: f  reason: collision with root package name */
    private SensorManager f13632f;
    /* access modifiers changed from: private */

    /* renamed from: f0  reason: collision with root package name */
    public double f13633f0;
    /* access modifiers changed from: private */

    /* renamed from: g0  reason: collision with root package name */
    public boolean f13634g0;
    /* access modifiers changed from: private */

    /* renamed from: h0  reason: collision with root package name */
    public boolean f13635h0;
    /* access modifiers changed from: private */

    /* renamed from: i0  reason: collision with root package name */
    public boolean f13636i0 = false;

    /* renamed from: j0  reason: collision with root package name */
    private float f13637j0 = BitmapDescriptorFactory.HUE_RED;

    /* renamed from: k0  reason: collision with root package name */
    private float f13638k0 = 9999.0f;

    /* renamed from: l0  reason: collision with root package name */
    private float f13639l0 = -9999.0f;

    /* renamed from: m0  reason: collision with root package name */
    private float f13640m0 = 9999.0f;

    /* renamed from: n0  reason: collision with root package name */
    private int f13641n0 = 0;

    /* renamed from: o0  reason: collision with root package name */
    private boolean f13642o0;

    /* renamed from: p0  reason: collision with root package name */
    private final boolean f13643p0 = false;

    /* renamed from: q0  reason: collision with root package name */
    private final boolean f13644q0 = false;

    /* renamed from: r  reason: collision with root package name */
    private d f13645r;
    /* access modifiers changed from: private */

    /* renamed from: r0  reason: collision with root package name */
    public boolean f13646r0;

    /* renamed from: s  reason: collision with root package name */
    private f f13647s;
    /* access modifiers changed from: private */

    /* renamed from: s0  reason: collision with root package name */
    public int f13648s0 = 0;

    /* renamed from: t  reason: collision with root package name */
    private c f13649t;
    /* access modifiers changed from: private */

    /* renamed from: t0  reason: collision with root package name */
    public boolean f13650t0;

    /* renamed from: u  reason: collision with root package name */
    private Sensor f13651u;

    /* renamed from: u0  reason: collision with root package name */
    private G f13652u0;

    /* renamed from: v  reason: collision with root package name */
    private Sensor f13653v;

    /* renamed from: v0  reason: collision with root package name */
    private G f13654v0;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public boolean f13655w;

    /* renamed from: w0  reason: collision with root package name */
    private G f13656w0;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public boolean f13657x = false;

    /* renamed from: x0  reason: collision with root package name */
    private G f13658x0;

    /* renamed from: y  reason: collision with root package name */
    private boolean f13659y;

    /* renamed from: y0  reason: collision with root package name */
    private G f13660y0;

    /* renamed from: z  reason: collision with root package name */
    private boolean f13661z = false;

    /* renamed from: z0  reason: collision with root package name */
    private PowerManager.WakeLock f13662z0;

    private class b extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private final int f13663a;

        /* renamed from: b  reason: collision with root package name */
        private final long f13664b;

        /* renamed from: c  reason: collision with root package name */
        private final double f13665c;

        /* renamed from: d  reason: collision with root package name */
        private final double f13666d;

        /* renamed from: e  reason: collision with root package name */
        private final double f13667e;

        /* renamed from: f  reason: collision with root package name */
        private final double f13668f;

        /* renamed from: g  reason: collision with root package name */
        private final double f13669g;

        /* renamed from: h  reason: collision with root package name */
        private final int f13670h;

        /* renamed from: i  reason: collision with root package name */
        private final int f13671i;

        /* renamed from: j  reason: collision with root package name */
        private final int f13672j;

        /* renamed from: k  reason: collision with root package name */
        private final long f13673k;

        /* renamed from: l  reason: collision with root package name */
        private final long f13674l;

        /* renamed from: m  reason: collision with root package name */
        private final double f13675m;

        /* renamed from: n  reason: collision with root package name */
        private final boolean f13676n;

        public static /* synthetic */ void a(b bVar) {
            b bVar2 = bVar;
            if (!WorkerSensors.this.f13635h0) {
                WorkerSensors.this.e(bVar2.f13663a, bVar2.f13664b, bVar2.f13665c, bVar2.f13666d, bVar2.f13667e, bVar2.f13668f, bVar2.f13669g, bVar2.f13670h, bVar2.f13671i, bVar2.f13672j, bVar2.f13673k, bVar2.f13674l, bVar2.f13675m, bVar2.f13676n);
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public String doInBackground(Context... contextArr) {
            WorkerSensors workerSensors = WorkerSensors.this;
            int i8 = this.f13663a;
            WorkerSensors workerSensors2 = workerSensors;
            int i9 = i8;
            workerSensors2.f(i9, this.f13664b, this.f13665c, this.f13666d, this.f13667e, this.f13668f, this.f13669g, this.f13670h, this.f13671i, this.f13672j, this.f13673k, this.f13674l, this.f13675m, this.f13676n);
            return "COMPLETE!";
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            boolean unused = WorkerSensors.this.f13635h0 = false;
            if (WorkerSensors.this.f13650t0) {
                WorkerSensors.this.f13609J0.a(3);
            } else if (WorkerSensors.this.f13646r0 && WorkerSensors.this.f13648s0 <= 3) {
                new Handler().postDelayed(new g0(this), (long) (new Random().nextInt(WorkerSensors.this.f13648s0 * 30000) + 40000));
            } else if (WorkerSensors.this.f13646r0) {
                boolean unused2 = WorkerSensors.this.f13646r0 = false;
                int unused3 = WorkerSensors.this.f13648s0 = 0;
            }
        }

        private b(int i8, long j8, double d8, double d9, double d10, double d11, double d12, int i9, int i10, int i11, long j9, long j10, double d13, boolean z7) {
            this.f13663a = i8;
            this.f13664b = j8;
            this.f13665c = d8;
            this.f13666d = d9;
            this.f13667e = d10;
            this.f13668f = d11;
            this.f13669g = d12;
            this.f13670h = i9;
            this.f13671i = i10;
            this.f13672j = i11;
            this.f13673k = j9;
            this.f13674l = j10;
            this.f13675m = d13;
            this.f13676n = z7;
        }
    }

    public class c extends BroadcastReceiver {
        public c() {
        }

        public void onReceive(Context context, Intent intent) {
            boolean z7;
            boolean unused = WorkerSensors.this.f13655w = !intent.getBooleanExtra("noConnectivity", false);
            if (WorkerSensors.this.f13655w && WorkerSensors.this.f13616Q && !WorkerSensors.this.f13635h0 && WorkerSensors.this.c0()) {
                double elapsedRealtimeNanos = ((double) (SystemClock.elapsedRealtimeNanos() - WorkerSensors.this.f13620U)) / 1.0E9d;
                if (WorkerSensors.this.f13619T != 0 || elapsedRealtimeNanos <= 1800.0d) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if (WorkerSensors.this.f13619T == 1 && elapsedRealtimeNanos > 10.0d) {
                    z7 = false;
                }
                if (z7) {
                    WorkerSensors workerSensors = WorkerSensors.this;
                    workerSensors.e(workerSensors.f13619T, WorkerSensors.this.f13620U, WorkerSensors.this.f13621V, WorkerSensors.this.f13622W, WorkerSensors.this.f13623X, WorkerSensors.this.f13624Y, WorkerSensors.this.f13625Z, WorkerSensors.this.f13626a0, WorkerSensors.this.f13627b0, WorkerSensors.this.f13628c0, WorkerSensors.this.f13629d0, WorkerSensors.this.f13631e0, WorkerSensors.this.f13633f0, WorkerSensors.this.f13634g0);
                    return;
                }
                boolean unused2 = WorkerSensors.this.f13616Q = false;
                boolean unused3 = WorkerSensors.this.f13646r0 = false;
                int unused4 = WorkerSensors.this.f13648s0 = 0;
            }
        }
    }

    public class d extends BroadcastReceiver {
        public d() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null && action.equals("android.intent.action.ACTION_POWER_DISCONNECTED") && !WorkerSensors.this.f13650t0) {
                if (WorkerSensors.this.f13657x) {
                    boolean unused = WorkerSensors.this.f13650t0 = true;
                    boolean unused2 = WorkerSensors.this.f13657x = false;
                    long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
                    WorkerSensors workerSensors = WorkerSensors.this;
                    workerSensors.e(0, elapsedRealtimeNanos, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0, 0, 0, 0, 0, 0.0d, workerSensors.f13657x);
                    long round = Math.round(((double) (SystemClock.elapsedRealtimeNanos() - WorkerSensors.this.f13612M)) / 6.0E10d);
                    if (round > 0) {
                        int i8 = (int) round;
                        WorkerSensors.this.k0("2\f".concat(WorkerSensors.this.Y()).concat(context.getResources().getQuantityString(C2030R.plurals.status_monitoring, i8, new Object[]{Integer.valueOf(i8)})));
                        long unused3 = WorkerSensors.this.f13612M = SystemClock.elapsedRealtimeNanos();
                        return;
                    }
                    return;
                }
                WorkerSensors.this.f13609J0.a(3);
            }
        }
    }

    public interface e {
        void a(int i8);
    }

    public class f extends BroadcastReceiver {
        public f() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null && action.equals("android.intent.action.SCREEN_ON")) {
                if (WorkerSensors.this.j0(5000)) {
                    if (WorkerSensors.this.f13657x) {
                        boolean unused = WorkerSensors.this.f13636i0 = true;
                        Handler unused2 = WorkerSensors.this.f13607I0 = new Handler();
                        WorkerSensors.this.f13607I0.postDelayed(new W4(this), 90000);
                        return;
                    }
                    WorkerSensors.this.f13609J0.a(3);
                } else if (WorkerSensors.this.f13650t0) {
                } else {
                    if (WorkerSensors.this.f13657x) {
                        boolean unused3 = WorkerSensors.this.f13657x = false;
                        boolean unused4 = WorkerSensors.this.f13650t0 = true;
                        long elapsedRealtimeNanos = SystemClock.elapsedRealtimeNanos();
                        WorkerSensors workerSensors = WorkerSensors.this;
                        workerSensors.e(0, elapsedRealtimeNanos, 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0, 0, 0, 0, 0, 0.0d, workerSensors.f13657x);
                        long round = Math.round(((double) (SystemClock.elapsedRealtimeNanos() - WorkerSensors.this.f13612M)) / 6.0E10d);
                        if (round > 0) {
                            int i8 = (int) round;
                            WorkerSensors.this.k0("2\f".concat(WorkerSensors.this.Y()).concat(context.getResources().getQuantityString(C2030R.plurals.status_monitoring, i8, new Object[]{Integer.valueOf(i8)})));
                            long unused5 = WorkerSensors.this.f13612M = SystemClock.elapsedRealtimeNanos();
                            return;
                        }
                        return;
                    }
                    WorkerSensors.this.f13609J0.a(3);
                }
            }
        }
    }

    public WorkerSensors(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    private float[] U() {
        float[] fArr = new float[3];
        if (SensorManager.getRotationMatrix(this.f13599E0, (float[]) null, this.f13597D0, this.f13595C0)) {
            SensorManager.getOrientation(this.f13599E0, this.f13601F0);
            fArr[0] = (float) Math.toDegrees((double) this.f13601F0[0]);
            fArr[1] = (float) Math.toDegrees((double) this.f13601F0[1]);
            fArr[2] = (float) Math.toDegrees((double) this.f13601F0[2]);
            return fArr;
        }
        fArr[0] = 9999.0f;
        fArr[1] = 9999.0f;
        fArr[2] = 9999.0f;
        return fArr;
    }

    private void V() {
        String string = getApplicationContext().getString(C2030R.string.channel_permanent_name);
        String string2 = getApplicationContext().getString(C2030R.string.channel_permanent_description);
        NotificationChannel a8 = U1.a(getApplicationContext().getString(C2030R.string.channel_permanent), string, 2);
        a8.setDescription(string2);
        a8.enableLights(false);
        a8.enableVibration(false);
        a8.setBypassDnd(false);
        ((NotificationManager) getApplicationContext().getSystemService("notification")).createNotificationChannel(a8);
    }

    private C0702j W() {
        Context applicationContext = getApplicationContext();
        PendingIntent b8 = O.h(applicationContext).b(getId());
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 26) {
            V();
        }
        Notification b9 = new m.e(applicationContext, applicationContext.getString(C2030R.string.channel_permanent)).j(applicationContext.getString(C2030R.string.options_show_icon_text)).w(C2030R.drawable.bullseye).t(true).a(17301533, applicationContext.getString(C2030R.string.main_stop_monitoring), b8).b();
        if (i8 >= 34) {
            return new C0702j(91, b9, 1073741824);
        }
        return new C0702j(91, b9);
    }

    private float[] X() {
        SharedPreferences sharedPreferences = this.f13630e.getSharedPreferences(MainActivity.class.getSimpleName(), 0);
        return new float[]{sharedPreferences.getFloat("current_latitude", BitmapDescriptorFactory.HUE_RED), sharedPreferences.getFloat("current_longitude", BitmapDescriptorFactory.HUE_RED), sharedPreferences.getFloat("current_accuracy", -1.0f)};
    }

    /* access modifiers changed from: private */
    public String Y() {
        return new SimpleDateFormat("dd/MM/yy HH:mm:ss.SSS", Locale.getDefault()).format(new Date()).concat("\f");
    }

    private boolean Z(float[] fArr, float[] fArr2, double d8) {
        float f8 = fArr2[0];
        if (f8 != 9999.0f) {
            float f9 = fArr[0];
            if (f9 != 9999.0f) {
                float abs = Math.abs(f9 - f8);
                if (abs > 180.0f) {
                    abs = Math.abs(abs - 360.0f);
                }
                float abs2 = Math.abs(fArr[1] - fArr2[1]);
                if (abs2 > 180.0f) {
                    abs2 = Math.abs(abs2 - 360.0f);
                }
                float abs3 = Math.abs(fArr[2] - fArr2[2]);
                if (abs3 > 180.0f) {
                    abs3 = Math.abs(abs3 - 360.0f);
                }
                if (((double) abs) > d8 || ((double) abs2) > d8 || ((double) abs3) > d8) {
                    return true;
                }
                return false;
            }
        }
        return false;
    }

    private boolean a0() {
        Intent registerReceiver = this.f13630e.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return false;
        }
        int intExtra = registerReceiver.getIntExtra("plugged", -1);
        if (intExtra == 1 || intExtra == 2 || intExtra == 4) {
            return true;
        }
        return false;
    }

    public static /* synthetic */ Object b(WorkerSensors workerSensors, c.a aVar) {
        workerSensors.getClass();
        workerSensors.f13609J0 = new V4(workerSensors, aVar);
        workerSensors.f13630e = workerSensors.getApplicationContext();
        if (!workerSensors.a0() || workerSensors.d0()) {
            workerSensors.f13609J0.a(0);
            return "forDebug";
        }
        try {
            workerSensors.setForegroundAsync(workerSensors.W());
            workerSensors.k0("0\f".concat(workerSensors.Y()).concat(workerSensors.f13630e.getString(C2030R.string.update_service_start)));
            workerSensors.f13605H0 = true;
            workerSensors.f13635h0 = false;
            workerSensors.f13659y = false;
            workerSensors.f13650t0 = false;
            workerSensors.f13614O = SystemClock.elapsedRealtimeNanos();
            workerSensors.f13613N = SystemClock.elapsedRealtimeNanos();
            IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            f fVar = new f();
            workerSensors.f13647s = fVar;
            workerSensors.f13630e.registerReceiver(fVar, intentFilter);
            IntentFilter intentFilter2 = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");
            intentFilter2.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
            d dVar = new d();
            workerSensors.f13645r = dVar;
            workerSensors.f13630e.registerReceiver(dVar, intentFilter2);
            workerSensors.f13655w = workerSensors.b0();
            IntentFilter intentFilter3 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
            c cVar = new c();
            workerSensors.f13649t = cVar;
            workerSensors.f13630e.registerReceiver(cVar, intentFilter3);
            SensorManager sensorManager = (SensorManager) workerSensors.f13630e.getSystemService("sensor");
            workerSensors.f13632f = sensorManager;
            if (sensorManager != null) {
                PackageManager packageManager = workerSensors.f13630e.getPackageManager();
                if (packageManager.hasSystemFeature("android.hardware.sensor.accelerometer")) {
                    Sensor defaultSensor = workerSensors.f13632f.getDefaultSensor(1, true);
                    workerSensors.f13651u = defaultSensor;
                    if (defaultSensor == null) {
                        workerSensors.f13651u = workerSensors.f13632f.getDefaultSensor(1);
                        PowerManager powerManager = (PowerManager) workerSensors.f13630e.getSystemService("power");
                        if (powerManager != null) {
                            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(1, "eqn:EQNWakelock");
                            workerSensors.f13662z0 = newWakeLock;
                            if (newWakeLock != null) {
                                newWakeLock.acquire();
                            }
                        }
                    }
                } else {
                    workerSensors.f13651u = null;
                }
                if (packageManager.hasSystemFeature("android.hardware.sensor.compass")) {
                    Sensor defaultSensor2 = workerSensors.f13632f.getDefaultSensor(2, true);
                    workerSensors.f13653v = defaultSensor2;
                    if (defaultSensor2 == null) {
                        workerSensors.f13653v = workerSensors.f13632f.getDefaultSensor(2);
                    }
                } else {
                    workerSensors.f13653v = null;
                }
            } else {
                workerSensors.f13651u = null;
                workerSensors.f13653v = null;
            }
            workerSensors.f0(1);
            workerSensors.e0();
            workerSensors.f13652u0 = new G(64);
            workerSensors.f13654v0 = new G(UserVerificationMethods.USER_VERIFY_PATTERN);
            workerSensors.f13656w0 = new G(UserVerificationMethods.USER_VERIFY_HANDPRINT);
            workerSensors.f13658x0 = new G(512);
            workerSensors.f13660y0 = new G(UserVerificationMethods.USER_VERIFY_ALL);
            return "forDebug";
        } catch (IllegalStateException unused) {
            workerSensors.f13609J0.a(1);
            return "forDebug";
        }
    }

    private boolean b0() {
        boolean z7;
        ConnectivityManager connectivityManager = (ConnectivityManager) this.f13630e.getSystemService("connectivity");
        if (connectivityManager == null) {
            return false;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            z7 = activeNetworkInfo.isConnected();
            if (!activeNetworkInfo.isAvailable()) {
                z7 = false;
            }
        } else {
            z7 = true;
        }
        if (activeNetworkInfo == null) {
            return false;
        }
        return z7;
    }

    public static /* synthetic */ void c(WorkerSensors workerSensors, c.a aVar, int i8) {
        workerSensors.getClass();
        if (i8 == 0) {
            aVar.c(c.a.c());
        } else if (i8 == 1) {
            aVar.c(c.a.a());
        } else if (i8 == 2) {
            aVar.c(c.a.b());
        } else if (i8 == 3) {
            if (workerSensors.f13605H0) {
                workerSensors.k0("0\f".concat(workerSensors.Y()).concat(workerSensors.f13630e.getString(C2030R.string.update_service_stop)));
            }
            PowerManager.WakeLock wakeLock = workerSensors.f13662z0;
            if (wakeLock != null && wakeLock.isHeld()) {
                workerSensors.f13662z0.release();
            }
            d dVar = workerSensors.f13645r;
            if (dVar != null) {
                try {
                    workerSensors.f13630e.unregisterReceiver(dVar);
                } catch (Exception unused) {
                }
            }
            f fVar = workerSensors.f13647s;
            if (fVar != null) {
                try {
                    workerSensors.f13630e.unregisterReceiver(fVar);
                } catch (Exception unused2) {
                }
            }
            c cVar = workerSensors.f13649t;
            if (cVar != null) {
                try {
                    workerSensors.f13630e.unregisterReceiver(cVar);
                } catch (Exception unused3) {
                }
            }
            if (workerSensors.f13659y) {
                try {
                    workerSensors.h0();
                } catch (Exception unused4) {
                }
            }
            Handler handler = workerSensors.f13607I0;
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
            }
            aVar.c(c.a.c());
        }
    }

    /* access modifiers changed from: private */
    public boolean c0() {
        boolean z7;
        boolean z8;
        boolean z9 = false;
        SharedPreferences sharedPreferences = this.f13630e.getSharedPreferences(MainActivity.class.getSimpleName(), 0);
        float f8 = sharedPreferences.getFloat("current_latitude", BitmapDescriptorFactory.HUE_RED);
        float f9 = sharedPreferences.getFloat("current_longitude", BitmapDescriptorFactory.HUE_RED);
        double currentTimeMillis = ((double) (System.currentTimeMillis() - sharedPreferences.getLong("current_location_time", 0))) / 1000.0d;
        if (f8 != BitmapDescriptorFactory.HUE_RED) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (f9 != BitmapDescriptorFactory.HUE_RED) {
            z8 = true;
        } else {
            z8 = false;
        }
        boolean z10 = z7 & z8;
        if (currentTimeMillis < 43200.0d) {
            z9 = true;
        }
        return z10 & z9;
    }

    private String d(boolean z7) {
        if (z7) {
            return "1";
        }
        return "0";
    }

    private boolean d0() {
        DisplayManager displayManager = (DisplayManager) this.f13630e.getSystemService("display");
        if (displayManager == null) {
            return false;
        }
        boolean z7 = false;
        for (Display display : displayManager.getDisplays()) {
            if (!(display.getState() == 1 || display.getState() == 3 || display.getState() == 4)) {
                z7 = true;
            }
        }
        return z7;
    }

    /* access modifiers changed from: private */
    public void e(int i8, long j8, double d8, double d9, double d10, double d11, double d12, int i9, int i10, int i11, long j9, long j10, double d13, boolean z7) {
        if (b0()) {
            this.f13635h0 = true;
            new b(i8, j8, d8, d9, d10, d11, d12, i9, i10, i11, j9, j10, d13, z7).execute(new Context[]{this.f13630e});
        } else if (this.f13650t0) {
            this.f13609J0.a(3);
        } else {
            this.f13616Q = true;
            this.f13619T = i8;
            this.f13620U = j8;
            this.f13621V = d8;
            this.f13622W = d9;
            this.f13623X = d10;
            this.f13624Y = d11;
            this.f13625Z = d12;
            this.f13626a0 = i9;
            this.f13627b0 = i10;
            this.f13628c0 = i11;
            this.f13629d0 = j9;
            this.f13631e0 = j10;
            this.f13633f0 = d13;
            this.f13634g0 = z7;
        }
    }

    private void e0() {
        this.f13617R = 0;
        this.f13659y = true;
        Sensor sensor = this.f13651u;
        if (sensor != null) {
            this.f13632f.registerListener(this, sensor, 5200);
        }
        Sensor sensor2 = this.f13653v;
        if (sensor2 != null) {
            this.f13632f.registerListener(this, sensor2, 2);
        }
    }

    /* JADX WARNING: type inference failed for: r0v55, types: [java.net.URLConnection] */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x025e  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0337  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x03a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void f(int r29, long r30, double r32, double r34, double r36, double r38, double r40, int r42, int r43, int r44, long r45, long r47, double r49, boolean r51) {
        /*
            r28 = this;
            r1 = r28
            r4 = r32
            r6 = r34
            r8 = r36
            r10 = r38
            android.content.Context r15 = r1.f13630e
            java.lang.Class<com.finazzi.distquake.MainActivity> r16 = com.finazzi.distquake.MainActivity.class
            java.lang.String r0 = r16.getSimpleName()
            r2 = 0
            android.content.SharedPreferences r0 = r15.getSharedPreferences(r0, r2)
            android.content.SharedPreferences$Editor r3 = r0.edit()
            r15 = r2
            r16 = r3
            r17 = r15
            java.lang.String r15 = "eqn_monitoring"
            if (r51 == 0) goto L_0x0053
            long r18 = android.os.SystemClock.elapsedRealtimeNanos()
            long r2 = r1.f13611L
            long r2 = r18 - r2
            double r2 = (double) r2
            r18 = 4768169126130614272(0x422bf08eb0000000, double:6.0E10)
            double r2 = r2 / r18
            long r2 = java.lang.Math.round(r2)
            r18 = r2
            r2 = 0
            long r20 = r0.getLong(r15, r2)
            long r2 = r20 + r18
            r14 = r16
            r14.putLong(r15, r2)
            r14.apply()
            r18 = r2
            long r2 = android.os.SystemClock.elapsedRealtimeNanos()
            r1.f13611L = r2
            goto L_0x005b
        L_0x0053:
            r14 = r16
            r2 = 0
            long r18 = r0.getLong(r15, r2)
        L_0x005b:
            java.text.DecimalFormatSymbols r2 = java.text.DecimalFormatSymbols.getInstance()
            r3 = 46
            r2.setDecimalSeparator(r3)
            java.text.DecimalFormat r3 = new java.text.DecimalFormat
            r16 = r14
            java.lang.String r14 = "0.00"
            r3.<init>(r14, r2)
            java.text.DecimalFormat r14 = new java.text.DecimalFormat
            r22 = r15
            java.lang.String r15 = "0.00000"
            r14.<init>(r15, r2)
            java.lang.String r2 = "android_id_eqn"
            java.lang.String r15 = "0"
            java.lang.String r0 = r0.getString(r2, r15)
            float[] r2 = r1.X()
            r15 = r2[r17]
            r23 = r2
            r24 = 1
            r2 = r23[r24]
            r25 = 2
            r1 = r23[r25]
            long r26 = android.os.SystemClock.elapsedRealtimeNanos()
            r23 = r1
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            java.lang.String r12 = "e_t"
            java.lang.String r13 = java.lang.Integer.toString(r29)
            r1.put(r12, r13)
            java.lang.String r12 = "u_id"
            r1.put(r12, r0)
            double r12 = (double) r15
            java.lang.String r0 = r14.format(r12)
            java.lang.String r12 = "lat"
            r1.put(r12, r0)
            double r12 = (double) r2
            java.lang.String r0 = r14.format(r12)
            java.lang.String r2 = "lon"
            r1.put(r2, r0)
            java.lang.String r0 = "a_max"
            java.lang.String r2 = r14.format(r6)
            r1.put(r0, r2)
            java.lang.String r0 = "a_std"
            java.lang.String r2 = r14.format(r4)
            r1.put(r0, r2)
            java.lang.String r0 = "c_std"
            java.lang.String r2 = r14.format(r8)
            r1.put(r0, r2)
            java.lang.String r0 = "pf"
            java.lang.String r2 = r3.format(r10)
            r1.put(r0, r2)
            java.lang.String r0 = "pr"
            r12 = r40
            java.lang.String r2 = r3.format(r12)
            r1.put(r0, r2)
            r0 = r23
            double r12 = (double) r0
            java.lang.String r0 = r14.format(r12)
            java.lang.String r2 = "acc"
            r1.put(r2, r0)
            long r12 = r26 - r30
            float r0 = (float) r12
            double r12 = (double) r0
            r14 = 4741671816366391296(0x41cdcd6500000000, double:1.0E9)
            double r12 = r12 / r14
            java.lang.String r0 = r3.format(r12)
            java.lang.String r2 = "d_not"
            r1.put(r2, r0)
            java.lang.String r0 = "cal"
            r2 = r28
            r14 = r51
            java.lang.String r12 = r2.d(r14)
            r1.put(r0, r12)
            java.lang.String r0 = "sht"
            r12 = r49
            java.lang.String r3 = r3.format(r12)
            r1.put(r0, r3)
            boolean r0 = r2.f13650t0
            java.lang.String r3 = "ch"
            java.lang.String r15 = "s_on"
            if (r0 == 0) goto L_0x013c
            r0 = r17
            java.lang.String r14 = r2.d(r0)
            r1.put(r3, r14)
            r3 = r24
            java.lang.String r14 = r2.d(r3)
            r1.put(r15, r14)
            goto L_0x0160
        L_0x013c:
            r0 = r17
            boolean r14 = r2.a0()
            java.lang.String r14 = r2.d(r14)
            r1.put(r3, r14)
            boolean r3 = r2.f13636i0
            if (r3 == 0) goto L_0x0155
            java.lang.String r3 = r2.d(r0)
            r1.put(r15, r3)
            goto L_0x0160
        L_0x0155:
            boolean r3 = r2.d0()
            java.lang.String r3 = r2.d(r3)
            r1.put(r15, r3)
        L_0x0160:
            boolean r3 = r2.f13636i0
            java.lang.String r3 = r2.d(r3)
            java.lang.String r14 = "aso"
            r1.put(r14, r3)
            java.lang.String r3 = "mon"
            java.lang.String r14 = java.lang.Long.toString(r18)
            r1.put(r3, r14)
            r3 = 830(0x33e, float:1.163E-42)
            java.lang.String r3 = java.lang.Integer.toString(r3)
            java.lang.String r14 = "ver"
            r1.put(r14, r3)
            int r3 = android.os.Build.VERSION.SDK_INT
            java.lang.String r3 = java.lang.Integer.toString(r3)
            java.lang.String r14 = "and"
            r1.put(r14, r3)
            java.lang.String r1 = u2.C1737L.a(r1)
            r3 = 2131887097(0x7f1203f9, float:1.9408791E38)
            r15 = r29
            r0 = r25
            if (r15 >= r0) goto L_0x01bb
            java.net.URL r0 = new java.net.URL     // Catch:{ IOException -> 0x01b8, all -> 0x01b4 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01b8, all -> 0x01b4 }
            r14.<init>()     // Catch:{ IOException -> 0x01b8, all -> 0x01b4 }
            android.content.Context r12 = r2.f13630e     // Catch:{ IOException -> 0x01b8, all -> 0x01b4 }
            java.lang.String r3 = r12.getString(r3)     // Catch:{ IOException -> 0x01b8, all -> 0x01b4 }
            r14.append(r3)     // Catch:{ IOException -> 0x01b8, all -> 0x01b4 }
            java.lang.String r3 = "distquake_upload4.php"
            r14.append(r3)     // Catch:{ IOException -> 0x01b8, all -> 0x01b4 }
            java.lang.String r3 = r14.toString()     // Catch:{ IOException -> 0x01b8, all -> 0x01b4 }
            r0.<init>(r3)     // Catch:{ IOException -> 0x01b8, all -> 0x01b4 }
            goto L_0x01d7
        L_0x01b4:
            r0 = move-exception
            r14 = 0
            goto L_0x03a1
        L_0x01b8:
            r14 = 0
            goto L_0x024d
        L_0x01bb:
            java.net.URL r0 = new java.net.URL     // Catch:{ IOException -> 0x01b8, all -> 0x01b4 }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x01b8, all -> 0x01b4 }
            r12.<init>()     // Catch:{ IOException -> 0x01b8, all -> 0x01b4 }
            android.content.Context r13 = r2.f13630e     // Catch:{ IOException -> 0x01b8, all -> 0x01b4 }
            java.lang.String r3 = r13.getString(r3)     // Catch:{ IOException -> 0x01b8, all -> 0x01b4 }
            r12.append(r3)     // Catch:{ IOException -> 0x01b8, all -> 0x01b4 }
            java.lang.String r3 = "distquake_upload4bis.php"
            r12.append(r3)     // Catch:{ IOException -> 0x01b8, all -> 0x01b4 }
            java.lang.String r3 = r12.toString()     // Catch:{ IOException -> 0x01b8, all -> 0x01b4 }
            r0.<init>(r3)     // Catch:{ IOException -> 0x01b8, all -> 0x01b4 }
        L_0x01d7:
            java.net.URLConnection r0 = r0.openConnection()     // Catch:{ IOException -> 0x01b8, all -> 0x01b4 }
            java.lang.Object r0 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r0)     // Catch:{ IOException -> 0x01b8, all -> 0x01b4 }
            java.net.URLConnection r0 = (java.net.URLConnection) r0     // Catch:{ IOException -> 0x01b8, all -> 0x01b4 }
            r3 = r0
            java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ IOException -> 0x01b8, all -> 0x01b4 }
            r0 = 1
            r3.setDoOutput(r0)     // Catch:{ IOException -> 0x0240, all -> 0x023c }
            r0 = 10000(0x2710, float:1.4013E-41)
            r3.setConnectTimeout(r0)     // Catch:{ IOException -> 0x0240, all -> 0x023c }
            r3.setReadTimeout(r0)     // Catch:{ IOException -> 0x0240, all -> 0x023c }
            java.lang.String r0 = "Content-Type"
            java.lang.String r12 = "application/x-www-form-urlencoded;charset=utf-8"
            r3.setRequestProperty(r0, r12)     // Catch:{ IOException -> 0x0240, all -> 0x023c }
            java.lang.String r0 = "POST"
            r3.setRequestMethod(r0)     // Catch:{ IOException -> 0x0240, all -> 0x023c }
            byte[] r0 = r1.getBytes()     // Catch:{ IOException -> 0x0240, all -> 0x023c }
            int r0 = r0.length     // Catch:{ IOException -> 0x0240, all -> 0x023c }
            r3.setFixedLengthStreamingMode(r0)     // Catch:{ IOException -> 0x0240, all -> 0x023c }
            java.io.PrintWriter r0 = new java.io.PrintWriter     // Catch:{ IOException -> 0x0240, all -> 0x023c }
            java.io.OutputStream r12 = r3.getOutputStream()     // Catch:{ IOException -> 0x0240, all -> 0x023c }
            r0.<init>(r12)     // Catch:{ IOException -> 0x0240, all -> 0x023c }
            r0.print(r1)     // Catch:{ IOException -> 0x0240, all -> 0x023c }
            r0.close()     // Catch:{ IOException -> 0x0240, all -> 0x023c }
            java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0240, all -> 0x023c }
            java.io.InputStream r1 = r3.getInputStream()     // Catch:{ IOException -> 0x0240, all -> 0x023c }
            r0.<init>(r1)     // Catch:{ IOException -> 0x0240, all -> 0x023c }
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0240, all -> 0x023c }
            java.io.InputStreamReader r12 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0240, all -> 0x023c }
            java.nio.charset.Charset r13 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x0240, all -> 0x023c }
            r12.<init>(r0, r13)     // Catch:{ IOException -> 0x0240, all -> 0x023c }
            r1.<init>(r12)     // Catch:{ IOException -> 0x0240, all -> 0x023c }
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0240, all -> 0x023c }
            r12.<init>()     // Catch:{ IOException -> 0x0240, all -> 0x023c }
        L_0x022d:
            java.lang.String r13 = r1.readLine()     // Catch:{ IOException -> 0x0240, all -> 0x023c }
            if (r13 == 0) goto L_0x0242
            r12.append(r13)     // Catch:{ IOException -> 0x0240, all -> 0x023c }
            java.lang.String r13 = "\n"
            r12.append(r13)     // Catch:{ IOException -> 0x0240, all -> 0x023c }
            goto L_0x022d
        L_0x023c:
            r0 = move-exception
            r14 = r3
            goto L_0x03a1
        L_0x0240:
            r14 = r3
            goto L_0x024d
        L_0x0242:
            r0.close()     // Catch:{ IOException -> 0x0240, all -> 0x023c }
            java.lang.String r0 = r12.toString()     // Catch:{ IOException -> 0x0240, all -> 0x023c }
            r3.disconnect()
            goto L_0x0254
        L_0x024d:
            java.lang.String r0 = "nok"
            if (r14 == 0) goto L_0x0254
            r14.disconnect()
        L_0x0254:
            java.lang.String r1 = "ok\n"
            boolean r0 = r0.equals(r1)
            java.lang.String r1 = "0\f"
            if (r0 == 0) goto L_0x0337
            if (r15 != 0) goto L_0x0293
            java.lang.String r0 = r2.Y()
            java.lang.String r0 = r1.concat(r0)
            if (r51 == 0) goto L_0x027c
            android.content.Context r1 = r2.f13630e
            android.content.res.Resources r1 = r1.getResources()
            r3 = 2131887162(0x7f12043a, float:1.9408923E38)
            java.lang.String r1 = r1.getString(r3)
            java.lang.String r0 = r0.concat(r1)
            goto L_0x028d
        L_0x027c:
            android.content.Context r1 = r2.f13630e
            android.content.res.Resources r1 = r1.getResources()
            r3 = 2131887163(0x7f12043b, float:1.9408925E38)
            java.lang.String r1 = r1.getString(r3)
            java.lang.String r0 = r0.concat(r1)
        L_0x028d:
            r2.k0(r0)
        L_0x0290:
            r0 = 0
            goto L_0x031b
        L_0x0293:
            java.lang.String r0 = "1\f"
            java.lang.String r1 = r2.Y()
            java.lang.String r0 = r0.concat(r1)
            android.content.Context r1 = r2.f13630e
            android.content.res.Resources r1 = r1.getResources()
            r3 = 2131887160(0x7f120438, float:1.940892E38)
            java.lang.String r1 = r1.getString(r3)
            java.lang.String r0 = r0.concat(r1)
            java.util.Date r1 = new java.util.Date
            r12 = r45
            r1.<init>(r12)
            java.util.Date r3 = new java.util.Date
            r4 = r47
            r3.<init>(r4)
            java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat
            java.lang.String r5 = "ddMMyyHHmmssSSS"
            java.util.Locale r6 = java.util.Locale.getDefault()
            r4.<init>(r5, r6)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "wave"
            r5.append(r6)
            java.lang.String r4 = r4.format(r1)
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            java.lang.String r5 = ".txt"
            java.lang.String r4 = r4.concat(r5)
            java.text.SimpleDateFormat r5 = new java.text.SimpleDateFormat
            java.lang.String r6 = "HH:mm:ss.SSS"
            java.util.Locale r7 = java.util.Locale.getDefault()
            r5.<init>(r6, r7)
            java.lang.String r1 = r5.format(r1)
            java.lang.String r3 = r5.format(r3)
            java.lang.String r5 = "\f"
            java.lang.String r0 = r0.concat(r5)
            java.lang.String r0 = r0.concat(r1)
            java.lang.String r0 = r0.concat(r5)
            java.lang.String r0 = r0.concat(r3)
            java.lang.String r0 = r0.concat(r5)
            java.lang.String r0 = r0.concat(r4)
            r2.k0(r0)
            double[] r0 = r2.f13596D
            if (r0 == 0) goto L_0x0290
            r2.g0(r0, r4)
            goto L_0x0290
        L_0x031b:
            r2.f13616Q = r0
            r2.f13646r0 = r0
            r2.f13648s0 = r0
            long r0 = android.os.SystemClock.elapsedRealtimeNanos()
            r2.f13613N = r0
            r0 = 1
            r2.f13661z = r0
            r14 = r16
            r3 = r22
            r0 = 0
            r14.putLong(r3, r0)
            r14.apply()
            goto L_0x039f
        L_0x0337:
            r12 = r45
            java.lang.String r0 = r2.Y()
            java.lang.String r0 = r1.concat(r0)
            if (r15 != 0) goto L_0x0355
            android.content.Context r1 = r2.f13630e
            android.content.res.Resources r1 = r1.getResources()
            r3 = 2131887164(0x7f12043c, float:1.9408927E38)
            java.lang.String r1 = r1.getString(r3)
            java.lang.String r0 = r0.concat(r1)
            goto L_0x0366
        L_0x0355:
            android.content.Context r1 = r2.f13630e
            android.content.res.Resources r1 = r1.getResources()
            r3 = 2131887161(0x7f120439, float:1.9408921E38)
            java.lang.String r1 = r1.getString(r3)
            java.lang.String r0 = r0.concat(r1)
        L_0x0366:
            r2.k0(r0)
            r0 = 1
            r2.f13646r0 = r0
            r2.f13616Q = r0
            int r1 = r2.f13648s0
            int r1 = r1 + r0
            r2.f13648s0 = r1
            r2.f13619T = r15
            r0 = r30
            r2.f13620U = r0
            r2.f13621V = r4
            r2.f13622W = r6
            r2.f13623X = r8
            r2.f13624Y = r10
            r0 = r40
            r2.f13625Z = r0
            r0 = r42
            r2.f13626a0 = r0
            r0 = r43
            r2.f13627b0 = r0
            r0 = r44
            r2.f13628c0 = r0
            r2.f13629d0 = r12
            r4 = r47
            r2.f13631e0 = r4
            r12 = r49
            r2.f13633f0 = r12
            r14 = r51
            r2.f13634g0 = r14
        L_0x039f:
            return
        L_0x03a0:
            r0 = move-exception
        L_0x03a1:
            if (r14 == 0) goto L_0x03a6
            r14.disconnect()
        L_0x03a6:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.WorkerSensors.f(int, long, double, double, double, double, double, int, int, int, long, long, double, boolean):void");
    }

    private void f0(int i8) {
        this.f13604H = SystemClock.elapsedRealtimeNanos();
        boolean z7 = this.f13657x;
        this.f13657x = false;
        this.f13590A = false;
        this.f13616Q = false;
        this.f13646r0 = false;
        this.f13648s0 = 0;
        this.f13637j0 = BitmapDescriptorFactory.HUE_RED;
        this.f13640m0 = 9999.0f;
        this.f13639l0 = -9999.0f;
        this.f13638k0 = 9999.0f;
        this.f13617R = 0;
        this.f13641n0 = 0;
        this.f13591A0 = 0;
        this.f13618S = 0;
        this.f13593B0 = 0.0d;
        this.f13642o0 = false;
        this.f13636i0 = false;
        Arrays.fill(this.f13594C, BitmapDescriptorFactory.HUE_RED);
        this.f13614O = SystemClock.elapsedRealtimeNanos();
        this.f13613N = SystemClock.elapsedRealtimeNanos();
        this.f13661z = false;
        if (z7) {
            SharedPreferences sharedPreferences = this.f13630e.getSharedPreferences(MainActivity.class.getSimpleName(), 0);
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putLong("eqn_monitoring", sharedPreferences.getLong("eqn_monitoring", 0) + Math.round(((double) (SystemClock.elapsedRealtimeNanos() - this.f13611L)) / 6.0E10d));
            edit.apply();
            long round = Math.round(((double) (SystemClock.elapsedRealtimeNanos() - this.f13612M)) / 6.0E10d);
            if (round > 0) {
                int i9 = (int) round;
                k0("2\f".concat(Y()).concat(this.f13630e.getResources().getQuantityString(C2030R.plurals.status_monitoring, i9, new Object[]{Integer.valueOf(i9)})));
                this.f13612M = SystemClock.elapsedRealtimeNanos();
            }
        }
        if (i8 == 0 && z7) {
            e(0, SystemClock.elapsedRealtimeNanos(), 0.0d, 0.0d, 0.0d, 0.0d, 0.0d, 0, 0, 0, 0, 0, 0.0d, this.f13657x);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0059 A[SYNTHETIC, Splitter:B:25:0x0059] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void g0(double[] r6, java.lang.String r7) {
        /*
            r5 = this;
            java.lang.String r0 = "EQN"
            android.content.Context r1 = r5.f13630e
            android.content.pm.ApplicationInfo r1 = r1.getApplicationInfo()
            java.lang.String r1 = r1.dataDir
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r1)
            java.lang.String r1 = "/files/"
            r2.append(r1)
            r2.append(r7)
            java.lang.String r7 = r2.toString()
            r1 = 0
            java.io.DataOutputStream r2 = new java.io.DataOutputStream     // Catch:{ IOException -> 0x0050 }
            java.io.FileOutputStream r3 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0050 }
            r3.<init>(r7)     // Catch:{ IOException -> 0x0050 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0050 }
            int r7 = r6.length     // Catch:{ IOException -> 0x0038, all -> 0x0035 }
            r1 = 0
        L_0x002b:
            if (r1 >= r7) goto L_0x003b
            r3 = r6[r1]     // Catch:{ IOException -> 0x0038, all -> 0x0035 }
            r2.writeDouble(r3)     // Catch:{ IOException -> 0x0038, all -> 0x0035 }
            int r1 = r1 + 1
            goto L_0x002b
        L_0x0035:
            r6 = move-exception
            r1 = r2
            goto L_0x0057
        L_0x0038:
            r6 = move-exception
            r1 = r2
            goto L_0x0051
        L_0x003b:
            r2.close()     // Catch:{ IOException -> 0x003f }
            return
        L_0x003f:
            r6 = move-exception
            java.lang.String r7 = r6.getMessage()
            if (r7 == 0) goto L_0x004d
            java.lang.String r6 = r6.getMessage()
            android.util.Log.d(r0, r6)
        L_0x004d:
            return
        L_0x004e:
            r6 = move-exception
            goto L_0x0057
        L_0x0050:
            r6 = move-exception
        L_0x0051:
            java.lang.RuntimeException r7 = new java.lang.RuntimeException     // Catch:{ all -> 0x004e }
            r7.<init>(r6)     // Catch:{ all -> 0x004e }
            throw r7     // Catch:{ all -> 0x004e }
        L_0x0057:
            if (r1 == 0) goto L_0x006b
            r1.close()     // Catch:{ IOException -> 0x005d }
            goto L_0x006b
        L_0x005d:
            r7 = move-exception
            java.lang.String r1 = r7.getMessage()
            if (r1 == 0) goto L_0x006b
            java.lang.String r7 = r7.getMessage()
            android.util.Log.d(r0, r7)
        L_0x006b:
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.WorkerSensors.g0(double[], java.lang.String):void");
    }

    private void h0() {
        if (this.f13657x) {
            long round = Math.round(((double) (SystemClock.elapsedRealtimeNanos() - this.f13612M)) / 6.0E10d);
            if (round > 0) {
                int i8 = (int) round;
                k0("2\f".concat(Y()).concat(this.f13630e.getResources().getQuantityString(C2030R.plurals.status_monitoring, i8, new Object[]{Integer.valueOf(i8)})));
                this.f13612M = SystemClock.elapsedRealtimeNanos();
            }
        }
        this.f13659y = false;
        this.f13657x = false;
        SensorManager sensorManager = this.f13632f;
        if (sensorManager != null) {
            sensorManager.unregisterListener(this);
        }
        this.f13637j0 = BitmapDescriptorFactory.HUE_RED;
        this.f13640m0 = 9999.0f;
        this.f13639l0 = -9999.0f;
        this.f13638k0 = 9999.0f;
    }

    private boolean i0(long j8) {
        if (System.currentTimeMillis() - this.f13630e.getSharedPreferences(MainActivity.class.getSimpleName(), 0).getLong("recent_notification", 0) < j8) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public boolean j0(long j8) {
        if (System.currentTimeMillis() - this.f13630e.getSharedPreferences(MainActivity.class.getSimpleName(), 0).getLong("recent_turnonscreen", 0) < j8) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void k0(String str) {
        String str2 = this.f13630e.getApplicationInfo().dataDir;
        File file = new File(str2 + "/files/log3.txt");
        if (file.exists() && file.length() > DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT) {
            File[] listFiles = new File(str2 + "/files/").listFiles();
            if (listFiles != null) {
                for (File file2 : listFiles) {
                    if (file2.getAbsolutePath().contains("wave")) {
                        file2.delete();
                    }
                }
            }
            if (!file.delete()) {
                Log.d("EQN", "Cannot delete");
            }
        }
        String concat = str.concat("\r\n");
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(this.f13630e.openFileOutput("log3.txt", 32768), StandardCharsets.UTF_8);
            outputStreamWriter.write(concat);
            outputStreamWriter.flush();
            outputStreamWriter.close();
        } catch (IOException e8) {
            if (e8.getMessage() != null) {
                Log.d("EQN", e8.getMessage());
            }
        }
    }

    public void onAccuracyChanged(Sensor sensor, int i8) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:104:0x0236, code lost:
        if (r0 < r1.f13641n0) goto L_0x0248;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:110:0x0246, code lost:
        if (r0 < r1.f13641n0) goto L_0x0248;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:165:0x04c2, code lost:
        if (r1.f13591A0 == 1) goto L_0x04c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x0210, code lost:
        if (r0 < r1.f13641n0) goto L_0x0248;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x0226, code lost:
        if (r0 < r1.f13641n0) goto L_0x0248;
     */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x0251  */
    /* JADX WARNING: Removed duplicated region for block: B:119:0x02b2  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x0407  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0441 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x04bf  */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x04c5  */
    /* JADX WARNING: Removed duplicated region for block: B:265:0x0739  */
    /* JADX WARNING: Removed duplicated region for block: B:286:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSensorChanged(android.hardware.SensorEvent r45) {
        /*
            r44 = this;
            r1 = r44
            r0 = r45
            long r2 = android.os.SystemClock.elapsedRealtimeNanos()
            boolean r4 = r1.f13657x
            r5 = 4631530004285489152(0x4046800000000000, double:45.0)
            r7 = 1176255488(0x461c3c00, float:9999.0)
            r8 = 0
            if (r4 == 0) goto L_0x004e
            boolean r4 = r1.f13642o0
            if (r4 == 0) goto L_0x002a
            float[] r4 = r1.U()
            r1.f13603G0 = r4
            r4 = r4[r8]
            int r4 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x004e
            r1.f13642o0 = r8
            r1.f13606I = r2
            goto L_0x004e
        L_0x002a:
            long r9 = r1.f13606I
            long r9 = r2 - r9
            r11 = 500000000(0x1dcd6500, double:2.47032823E-315)
            int r4 = (r9 > r11 ? 1 : (r9 == r11 ? 0 : -1))
            if (r4 <= 0) goto L_0x004e
            float[] r4 = r1.U()
            float[] r9 = r1.f13603G0
            boolean r9 = r1.Z(r4, r9, r5)
            if (r9 == 0) goto L_0x0044
            r1.f0(r8)
        L_0x0044:
            r9 = r4[r8]
            int r9 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x004c
            r1.f13603G0 = r4
        L_0x004c:
            r1.f13606I = r2
        L_0x004e:
            android.hardware.Sensor r4 = r0.sensor
            int r4 = r4.getType()
            r9 = 3
            r10 = 2
            if (r4 != r10) goto L_0x005f
            float[] r4 = r0.values
            float[] r11 = r1.f13595C0
            java.lang.System.arraycopy(r4, r8, r11, r8, r9)
        L_0x005f:
            android.hardware.Sensor r4 = r0.sensor
            int r4 = r4.getType()
            r11 = 1
            if (r4 != r11) goto L_0x073c
            float[] r4 = r0.values
            float[] r12 = r1.f13597D0
            java.lang.System.arraycopy(r4, r8, r12, r8, r9)
            float[] r4 = r1.f13592B
            float[] r0 = r0.values
            r9 = r0[r8]
            r4[r8] = r9
            r12 = r0[r11]
            r4[r11] = r12
            r0 = r0[r10]
            r4[r10] = r0
            float r9 = r9 * r9
            float r12 = r12 * r12
            float r9 = r9 + r12
            float r0 = r0 * r0
            float r9 = r9 + r0
            double r9 = (double) r9
            double r9 = java.lang.Math.sqrt(r9)
            float r0 = (float) r9
            float r4 = r1.f13637j0
            float r4 = r0 - r4
            boolean r0 = r1.f13657x
            java.lang.String r9 = "EQN"
            if (r0 == 0) goto L_0x052e
            boolean r0 = r1.f13590A
            if (r0 == 0) goto L_0x050f
            int r0 = r1.f13641n0
            r16 = 4608983858650965606(0x3ff6666666666666, double:1.4)
            if (r0 != 0) goto L_0x00a9
            long r14 = java.lang.System.currentTimeMillis()
            r1.f13608J = r14
            r1.f13610K = r2
        L_0x00a9:
            double[] r0 = r1.f13598E
            int r7 = r1.f13641n0
            double r14 = (double) r4
            r0[r7] = r14
            long[] r4 = r1.f13602G
            r4[r7] = r2
            int r7 = r7 + r11
            r1.f13641n0 = r7
            long r14 = r1.f13610K
            long r14 = r2 - r14
            double r14 = (double) r14
            r18 = 4748581863621132288(0x41e65a0bc0000000, double:3.0E9)
            int r4 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
            r10 = 64
            if (r4 <= 0) goto L_0x00c9
            if (r7 >= r10) goto L_0x00cc
        L_0x00c9:
            int r0 = r0.length
            if (r7 != r0) goto L_0x050a
        L_0x00cc:
            long r20 = java.lang.System.currentTimeMillis()
            r0 = r8
            r14 = 0
            r18 = 0
        L_0x00d5:
            int r4 = r1.f13641n0
            if (r0 >= r4) goto L_0x00e6
            double[] r4 = r1.f13598E
            r22 = r4[r0]
            double r14 = r14 + r22
            double r22 = r22 * r22
            double r18 = r18 + r22
            int r0 = r0 + 1
            goto L_0x00d5
        L_0x00e6:
            double r12 = (double) r4
            double r14 = r14 / r12
            double r12 = (double) r4
            double r18 = r18 / r12
            double r12 = r14 * r14
            double r18 = r18 - r12
            double r12 = java.lang.Math.sqrt(r18)
            float r0 = (float) r12
            double r12 = (double) r0
            float r0 = r1.f13640m0
            r18 = r11
            r25 = r12
            double r11 = (double) r0
            r27 = 4610334938539176755(0x3ffb333333333333, double:1.7)
            double r11 = r11 * r27
            int r0 = (r25 > r11 ? 1 : (r25 == r11 ? 0 : -1))
            if (r0 <= 0) goto L_0x04e9
            r0 = -1
            r7 = r0
            r11 = r7
            r0 = r8
            r12 = 0
        L_0x010d:
            int r4 = r1.f13641n0
            if (r0 >= r4) goto L_0x016a
            double[] r4 = r1.f13598E
            r24 = r4[r0]
            double r24 = r24 - r14
            double r24 = java.lang.Math.abs(r24)
            int r4 = (r24 > r12 ? 1 : (r24 == r12 ? 0 : -1))
            if (r4 <= 0) goto L_0x0128
            double[] r4 = r1.f13598E
            r12 = r4[r0]
            double r12 = r12 - r14
            double r12 = java.lang.Math.abs(r12)
        L_0x0128:
            if (r7 >= 0) goto L_0x0141
            double[] r4 = r1.f13598E
            r24 = r4[r0]
            float r4 = r1.f13639l0
            double r5 = (double) r4
            double r5 = r5 * r16
            int r4 = (r24 > r5 ? 1 : (r24 == r5 ? 0 : -1))
            if (r4 > 0) goto L_0x0140
            float r4 = r1.f13638k0
            double r4 = (double) r4
            double r4 = r4 * r16
            int r4 = (r24 > r4 ? 1 : (r24 == r4 ? 0 : -1))
            if (r4 >= 0) goto L_0x0141
        L_0x0140:
            r7 = r0
        L_0x0141:
            double[] r4 = r1.f13598E
            r5 = r4[r0]
            float r4 = r1.f13639l0
            r19 = r10
            r24 = r11
            double r10 = (double) r4
            double r10 = r10 * r16
            int r4 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r4 > 0) goto L_0x015f
            float r4 = r1.f13638k0
            double r10 = (double) r4
            double r10 = r10 * r16
            int r4 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r4 >= 0) goto L_0x015c
            goto L_0x015f
        L_0x015c:
            r11 = r24
            goto L_0x0160
        L_0x015f:
            r11 = r0
        L_0x0160:
            int r0 = r0 + 1
            r10 = r19
            r5 = 4631530004285489152(0x4046800000000000, double:45.0)
            goto L_0x010d
        L_0x016a:
            r19 = r10
            r24 = r11
            r4 = 4741671816366391296(0x41cdcd6500000000, double:1.0E9)
            if (r7 < 0) goto L_0x0186
            if (r24 < 0) goto L_0x0186
            int r11 = r24 - r7
            int r11 = r11 + 1
            long[] r0 = r1.f13602G
            r14 = r0[r24]
            r16 = r0[r7]
            long r14 = r14 - r16
            double r14 = (double) r14
            double r14 = r14 / r4
            goto L_0x0189
        L_0x0186:
            r11 = r8
            r14 = 0
        L_0x0189:
            r0 = 24
            if (r11 < r0) goto L_0x04cf
            r16 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            int r0 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r0 <= 0) goto L_0x04cf
            int r0 = r1.f13591A0
            int r0 = r0 + 1
            r1.f13591A0 = r0
            r16 = r4
            double r4 = r1.f13593B0
            double r4 = r4 + r14
            r1.f13593B0 = r4
            r1.f13618S = r8
            r0 = r7
            r6 = r24
            r4 = 0
            r14 = 0
        L_0x01a9:
            if (r0 > r6) goto L_0x01b8
            double[] r10 = r1.f13598E
            r24 = r10[r0]
            double r4 = r4 + r24
            double r24 = r24 * r24
            double r14 = r14 + r24
            int r0 = r0 + 1
            goto L_0x01a9
        L_0x01b8:
            r24 = r9
            double r8 = (double) r11
            double r4 = r4 / r8
            double r14 = r14 / r8
            double r4 = r4 * r4
            double r14 = r14 - r4
            double r4 = java.lang.Math.sqrt(r14)
            float r0 = (float) r4
            double r4 = (double) r0
            int r0 = r1.f13641n0
            double[] r8 = new double[r0]
            r1.f13596D = r8
            double[] r9 = r1.f13598E     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01d2 }
            r10 = 0
            java.lang.System.arraycopy(r9, r10, r8, r10, r0)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x01d2 }
            goto L_0x01e2
        L_0x01d2:
            r0 = move-exception
            java.lang.String r8 = r0.getMessage()
            if (r8 == 0) goto L_0x01e2
            java.lang.String r0 = r0.getMessage()
            r8 = r24
            android.util.Log.d(r8, r0)
        L_0x01e2:
            int r0 = r11 + -64
            if (r0 >= 0) goto L_0x0203
            int r0 = 64 - r11
            int r11 = r6 + r0
            int r0 = r1.f13641n0
            if (r11 >= r0) goto L_0x01f5
            int r0 = r11 - r7
            int r0 = r0 + 1
            r6 = r11
        L_0x01f3:
            r11 = r0
            goto L_0x01fe
        L_0x01f5:
            int r6 = r0 + -1
            int r7 = r0 + -64
            int r0 = r6 - r7
            int r0 = r0 + 1
            goto L_0x01f3
        L_0x01fe:
            r8 = r16
            r17 = r6
            goto L_0x024d
        L_0x0203:
            int r0 = r11 + -128
            if (r0 >= 0) goto L_0x0219
            int r0 = 128 - r11
            r8 = 13
            if (r0 >= r8) goto L_0x0213
            int r0 = r0 + r6
            int r8 = r1.f13641n0
            if (r0 >= r8) goto L_0x0213
            goto L_0x0248
        L_0x0213:
            r0 = r6
        L_0x0214:
            r8 = r16
            r17 = r0
            goto L_0x024d
        L_0x0219:
            int r0 = r11 + -256
            if (r0 >= 0) goto L_0x0229
            int r0 = 256 - r11
            r8 = 26
            if (r0 >= r8) goto L_0x0213
            int r0 = r0 + r6
            int r8 = r1.f13641n0
            if (r0 >= r8) goto L_0x0213
            goto L_0x0248
        L_0x0229:
            int r0 = r11 + -512
            if (r0 >= 0) goto L_0x0239
            int r0 = 512 - r11
            r8 = 52
            if (r0 >= r8) goto L_0x0213
            int r0 = r0 + r6
            int r8 = r1.f13641n0
            if (r0 >= r8) goto L_0x0213
            goto L_0x0248
        L_0x0239:
            int r0 = r11 + -1024
            if (r0 >= 0) goto L_0x01fe
            int r0 = 1024 - r11
            r8 = 103(0x67, float:1.44E-43)
            if (r0 >= r8) goto L_0x01fe
            int r0 = r0 + r6
            int r8 = r1.f13641n0
            if (r0 >= r8) goto L_0x01fe
        L_0x0248:
            int r6 = r0 - r7
            int r11 = r6 + 1
            goto L_0x0214
        L_0x024d:
            r0 = 128(0x80, float:1.794E-43)
            if (r11 >= r0) goto L_0x02b2
            r6 = r19
            double[] r0 = new double[r6]
            double[] r11 = new double[r6]
            r24 = r8
            double[] r8 = new double[r6]
            double[] r9 = r1.f13598E
            r10 = 0
            java.lang.System.arraycopy(r9, r7, r0, r10, r6)
            double[] r9 = r1.f13600F
            java.lang.System.arraycopy(r9, r7, r11, r10, r6)
            com.finazzi.distquake.G r6 = r1.f13652u0
            r6.a(r0, r11)
            long[] r6 = r1.f13602G
            int r9 = r7 + 63
            r28 = r6[r9]
            r30 = r6[r7]
            r6 = r11
            long r10 = r28 - r30
            double r9 = (double) r10
            double r9 = r9 / r24
            r11 = 0
        L_0x027a:
            r14 = 64
            if (r11 >= r14) goto L_0x02a2
            r14 = r0[r11]
            r30 = r4
            r4 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r14 = java.lang.Math.pow(r14, r4)
            r16 = r8
            r24 = r9
            r8 = r6[r11]
            double r8 = java.lang.Math.pow(r8, r4)
            double r14 = r14 + r8
            double r4 = java.lang.Math.sqrt(r14)
            r16[r11] = r4
            int r11 = r11 + 1
            r8 = r16
            r9 = r24
            r4 = r30
            goto L_0x027a
        L_0x02a2:
            r30 = r4
            r16 = r8
            r24 = r9
            r10 = 32
            r5 = r1
            r0 = r10
            r9 = r24
            r24 = r2
            goto L_0x03f5
        L_0x02b2:
            r30 = r4
            r24 = r8
            r4 = 256(0x100, float:3.59E-43)
            if (r11 >= r4) goto L_0x0308
            double[] r4 = new double[r0]
            double[] r5 = new double[r0]
            double[] r8 = new double[r0]
            double[] r6 = r1.f13598E
            r10 = 0
            java.lang.System.arraycopy(r6, r7, r4, r10, r0)
            double[] r6 = r1.f13600F
            java.lang.System.arraycopy(r6, r7, r5, r10, r0)
            com.finazzi.distquake.G r6 = r1.f13654v0
            r6.a(r4, r5)
            long[] r6 = r1.f13602G
            int r9 = r7 + 127
            r14 = r6[r9]
            r32 = r6[r7]
            long r14 = r14 - r32
            double r14 = (double) r14
            double r14 = r14 / r24
            r6 = 0
        L_0x02de:
            if (r6 >= r0) goto L_0x02ff
            r10 = r4[r6]
            r0 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r10 = java.lang.Math.pow(r10, r0)
            r24 = r10
            r9 = r5[r6]
            double r9 = java.lang.Math.pow(r9, r0)
            double r10 = r24 + r9
            double r0 = java.lang.Math.sqrt(r10)
            r8[r6] = r0
            int r6 = r6 + 1
            r0 = 128(0x80, float:1.794E-43)
            r1 = r44
            goto L_0x02de
        L_0x02ff:
            r0 = 64
        L_0x0301:
            r5 = r44
            r24 = r2
            r9 = r14
            goto L_0x03f5
        L_0x0308:
            r0 = 512(0x200, float:7.175E-43)
            if (r11 >= r0) goto L_0x0356
            double[] r0 = new double[r4]
            double[] r1 = new double[r4]
            double[] r8 = new double[r4]
            r5 = r44
            double[] r6 = r5.f13598E
            r10 = 0
            java.lang.System.arraycopy(r6, r7, r0, r10, r4)
            double[] r6 = r5.f13600F
            java.lang.System.arraycopy(r6, r7, r1, r10, r4)
            com.finazzi.distquake.G r6 = r5.f13656w0
            r6.a(r0, r1)
            long[] r6 = r5.f13602G
            int r9 = r7 + 255
            r14 = r6[r9]
            r32 = r6[r7]
            long r14 = r14 - r32
            double r14 = (double) r14
            double r14 = r14 / r24
            r6 = 0
        L_0x0332:
            if (r6 >= r4) goto L_0x0353
            r10 = r0[r6]
            r4 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r10 = java.lang.Math.pow(r10, r4)
            r24 = r10
            r9 = r1[r6]
            double r9 = java.lang.Math.pow(r9, r4)
            double r10 = r24 + r9
            double r4 = java.lang.Math.sqrt(r10)
            r8[r6] = r4
            int r6 = r6 + 1
            r4 = 256(0x100, float:3.59E-43)
            r5 = r44
            goto L_0x0332
        L_0x0353:
            r0 = 128(0x80, float:1.794E-43)
            goto L_0x0301
        L_0x0356:
            r1 = 1024(0x400, float:1.435E-42)
            if (r11 >= r1) goto L_0x03a7
            double[] r1 = new double[r0]
            double[] r4 = new double[r0]
            double[] r8 = new double[r0]
            r5 = r44
            double[] r6 = r5.f13598E
            r10 = 0
            java.lang.System.arraycopy(r6, r7, r1, r10, r0)
            double[] r6 = r5.f13600F
            java.lang.System.arraycopy(r6, r7, r4, r10, r0)
            com.finazzi.distquake.G r6 = r5.f13658x0
            r6.a(r1, r4)
            long[] r6 = r5.f13602G
            int r9 = r7 + 511
            r14 = r6[r9]
            r32 = r6[r7]
            long r14 = r14 - r32
            double r14 = (double) r14
            double r14 = r14 / r24
            r6 = 0
        L_0x0380:
            if (r6 >= r0) goto L_0x03a1
            r9 = r1
            r0 = r9[r6]
            r10 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r0 = java.lang.Math.pow(r0, r10)
            r24 = r0
            r0 = r4[r6]
            double r0 = java.lang.Math.pow(r0, r10)
            double r0 = r24 + r0
            double r0 = java.lang.Math.sqrt(r0)
            r8[r6] = r0
            int r6 = r6 + 1
            r1 = r9
            r0 = 512(0x200, float:7.175E-43)
            goto L_0x0380
        L_0x03a1:
            r24 = r2
            r9 = r14
            r0 = 256(0x100, float:3.59E-43)
            goto L_0x03f5
        L_0x03a7:
            r5 = r44
            double[] r0 = new double[r1]
            double[] r4 = new double[r1]
            double[] r8 = new double[r1]
            double[] r6 = r5.f13598E
            r10 = 0
            java.lang.System.arraycopy(r6, r7, r0, r10, r1)
            double[] r6 = r5.f13600F
            java.lang.System.arraycopy(r6, r7, r4, r10, r1)
            com.finazzi.distquake.G r6 = r5.f13660y0
            r6.a(r0, r4)
            long[] r6 = r5.f13602G
            int r9 = r7 + 1023
            r14 = r6[r9]
            r32 = r6[r7]
            long r14 = r14 - r32
            double r14 = (double) r14
            double r14 = r14 / r24
            r6 = r10
        L_0x03cd:
            if (r6 >= r1) goto L_0x03f0
            r10 = r0[r6]
            r24 = r2
            r1 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r9 = java.lang.Math.pow(r10, r1)
            r11 = r4
            r3 = r11[r6]
            double r3 = java.lang.Math.pow(r3, r1)
            double r9 = r9 + r3
            double r3 = java.lang.Math.sqrt(r9)
            r8[r6] = r3
            int r6 = r6 + 1
            r4 = r11
            r2 = r24
            r1 = 1024(0x400, float:1.435E-42)
            r10 = 0
            goto L_0x03cd
        L_0x03f0:
            r24 = r2
            r9 = r14
            r0 = 512(0x200, float:7.175E-43)
        L_0x03f5:
            r1 = -4616189618054758400(0xbff0000000000000, double:-1.0)
            r16 = r7
            r14 = r18
            r3 = 0
            r6 = 0
            r42 = r12
            r13 = r8
            r7 = r42
            r11 = 0
        L_0x0405:
            if (r14 >= r0) goto L_0x0417
            r28 = r13[r14]
            double r3 = r3 + r28
            int r15 = (r28 > r1 ? 1 : (r28 == r1 ? 0 : -1))
            if (r15 <= 0) goto L_0x0414
            double r1 = (double) r14
            double r1 = r1 / r9
            r11 = r1
            r1 = r28
        L_0x0414:
            int r14 = r14 + 1
            goto L_0x0405
        L_0x0417:
            int r0 = r0 + -1
            double r9 = (double) r0
            double r3 = r3 / r9
            double r13 = r1 / r3
            r0 = 4500(0x1194, double:2.2233E-320)
            boolean r0 = r5.i0(r0)
            float[] r1 = r5.U()
            float[] r2 = r5.f13603G0
            r3 = 4631530004285489152(0x4046800000000000, double:45.0)
            boolean r1 = r5.Z(r1, r2, r3)
            boolean r2 = r5.d0()
            r2 = r2 ^ 1
            boolean r3 = r5.f13636i0
            r2 = r2 | r3
            boolean r3 = r5.c0()
            if (r3 == 0) goto L_0x04b9
            if (r2 == 0) goto L_0x04b9
            if (r0 != 0) goto L_0x04b9
            if (r1 != 0) goto L_0x04b9
            int r0 = r5.f13591A0
            r1 = r18
            if (r0 != r1) goto L_0x047c
            r2 = r24
            r5.f13615P = r2
            long[] r0 = r5.f13602G
            r9 = r0[r16]
            float r0 = r5.f13640m0
            double r1 = (double) r0
            int r15 = r5.f13641n0
            long r3 = r5.f13608J
            r26 = r7
            double r6 = r5.f13593B0
            boolean r0 = r5.f13657x
            r18 = r3
            r3 = r9
            r9 = r1
            r1 = 1
            r2 = 1
            r1 = r5
            r22 = r6
            r35 = r24
            r7 = r26
            r5 = r30
            r24 = r0
            r1.e(r2, r3, r5, r7, r9, r11, r13, r15, r16, r17, r18, r20, r22, r24)
            r38 = r35
        L_0x0478:
            r2 = 0
        L_0x0479:
            r3 = 1
            goto L_0x0502
        L_0x047c:
            r1 = r5
            r35 = r24
            r5 = r30
            long r2 = r1.f13615P
            long r2 = r24 - r2
            r9 = 120000000000(0x1bf08eb000, double:5.9287877501E-313)
            int r0 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r0 >= 0) goto L_0x04b2
            long[] r0 = r1.f13602G
            r3 = r0[r16]
            float r0 = r1.f13640m0
            double r9 = (double) r0
            int r15 = r1.f13641n0
            r18 = r3
            long r2 = r1.f13608J
            r22 = r2
            double r2 = r1.f13593B0
            boolean r0 = r1.f13657x
            r42 = r22
            r22 = r2
            r3 = r18
            r18 = r42
            r2 = 2
            r38 = r24
            r24 = r0
            r1.e(r2, r3, r5, r7, r9, r11, r13, r15, r16, r17, r18, r20, r22, r24)
            goto L_0x0478
        L_0x04b2:
            r38 = r24
            r2 = 0
            r1.f0(r2)
            goto L_0x0479
        L_0x04b9:
            r1 = r5
            r2 = r6
            r38 = r24
            if (r0 == 0) goto L_0x04c5
            int r0 = r1.f13591A0
            r3 = 1
            if (r0 != r3) goto L_0x0502
            goto L_0x04c6
        L_0x04c5:
            r3 = 1
        L_0x04c6:
            r1.f13591A0 = r2
            r4 = 0
            r1.f13593B0 = r4
            r1.f13590A = r2
            goto L_0x0502
        L_0x04cf:
            r38 = r2
            r2 = r8
            r3 = r18
            int r0 = r1.f13618S
            int r0 = r0 + r3
            r1.f13618S = r0
            int r4 = r1.f13591A0
            if (r4 > 0) goto L_0x04e5
            r4 = 500(0x1f4, float:7.0E-43)
            if (r0 <= r4) goto L_0x04e2
            goto L_0x04e5
        L_0x04e2:
            r1.f13590A = r2
            goto L_0x0502
        L_0x04e5:
            r1.f0(r2)
            goto L_0x0502
        L_0x04e9:
            r38 = r2
            r2 = r8
            r3 = r18
            int r0 = r1.f13618S
            int r0 = r0 + r3
            r1.f13618S = r0
            int r4 = r1.f13591A0
            if (r4 > 0) goto L_0x04ff
            r4 = 500(0x1f4, float:7.0E-43)
            if (r0 <= r4) goto L_0x04fc
            goto L_0x04ff
        L_0x04fc:
            r1.f13590A = r2
            goto L_0x0502
        L_0x04ff:
            r1.f0(r2)
        L_0x0502:
            r1.f13641n0 = r2
        L_0x0504:
            r10 = r2
            r2 = r3
        L_0x0506:
            r40 = r38
            goto L_0x0691
        L_0x050a:
            r38 = r2
            r10 = r8
            r2 = r11
            goto L_0x0506
        L_0x050f:
            r38 = r2
            r2 = r8
            r3 = r11
            r16 = 4608983858650965606(0x3ff6666666666666, double:1.4)
            double r4 = (double) r4
            float r0 = r1.f13639l0
            double r6 = (double) r0
            double r6 = r6 * r16
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 > 0) goto L_0x052b
            float r0 = r1.f13638k0
            double r6 = (double) r0
            double r6 = r6 * r16
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 >= 0) goto L_0x0504
        L_0x052b:
            r1.f13590A = r3
            goto L_0x0504
        L_0x052e:
            r38 = r2
            r2 = r8
            r8 = r9
            r3 = r11
            long r5 = r1.f13604H
            r24 = r38
            long r5 = r24 - r5
            r9 = 10000000000(0x2540be400, double:4.9406564584E-314)
            int r0 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r0 <= 0) goto L_0x05a4
            float[] r0 = r1.f13594C     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0549 }
            int r5 = r1.f13617R     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0549 }
            r0[r5] = r4     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0549 }
            goto L_0x0557
        L_0x0549:
            r0 = move-exception
            java.lang.String r5 = r0.getMessage()
            if (r5 == 0) goto L_0x0557
            java.lang.String r0 = r0.getMessage()
            android.util.Log.d(r8, r0)
        L_0x0557:
            int r0 = r1.f13617R
            float[] r5 = r1.f13594C
            int r6 = r5.length
            int r6 = r6 - r3
            if (r0 >= r6) goto L_0x0563
            int r0 = r0 + r3
            r1.f13617R = r0
            goto L_0x0577
        L_0x0563:
            int r0 = r5.length     // Catch:{ IndexOutOfBoundsException -> 0x0569 }
            int r0 = r0 - r3
            java.lang.System.arraycopy(r5, r3, r5, r2, r0)     // Catch:{ IndexOutOfBoundsException -> 0x0569 }
            goto L_0x0577
        L_0x0569:
            r0 = move-exception
            java.lang.String r5 = r0.getMessage()
            if (r5 == 0) goto L_0x0577
            java.lang.String r0 = r0.getMessage()
            android.util.Log.d(r8, r0)
        L_0x0577:
            double r4 = (double) r4
            r8 = 4621712157097821471(0x40239eb851eb851f, double:9.81)
            double r4 = r4 - r8
            double r4 = java.lang.Math.abs(r4)
            r8 = 4604480259023595110(0x3fe6666666666666, double:0.7)
            int r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r0 <= 0) goto L_0x058e
            r1.f0(r3)
        L_0x058e:
            int r0 = r1.f13617R
            float[] r4 = r1.f13594C
            int r4 = r4.length
            int r4 = r4 - r3
            if (r0 == r4) goto L_0x05aa
            long r4 = r1.f13604H
            long r4 = r24 - r4
            r8 = 45000000000(0xa7a358200, double:2.2232954063E-313)
            int r0 = (r4 > r8 ? 1 : (r4 == r8 ? 0 : -1))
            if (r0 <= 0) goto L_0x05a4
            goto L_0x05aa
        L_0x05a4:
            r10 = r2
            r2 = r3
            r40 = r24
            goto L_0x0691
        L_0x05aa:
            r0 = 0
            r1.f13637j0 = r0
            r4 = -971228160(0xffffffffc61c3c00, float:-9999.0)
            r1.f13639l0 = r4
            r1.f13638k0 = r7
            r8 = r2
        L_0x05b5:
            int r4 = r1.f13617R
            int r5 = r4 + -1
            if (r8 >= r5) goto L_0x05d7
            float r4 = r1.f13637j0
            float[] r5 = r1.f13594C
            r5 = r5[r8]
            float r4 = r4 + r5
            r1.f13637j0 = r4
            float r4 = r1.f13638k0
            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r4 >= 0) goto L_0x05cc
            r1.f13638k0 = r5
        L_0x05cc:
            float r4 = r1.f13639l0
            int r4 = (r5 > r4 ? 1 : (r5 == r4 ? 0 : -1))
            if (r4 <= 0) goto L_0x05d4
            r1.f13639l0 = r5
        L_0x05d4:
            int r8 = r8 + 1
            goto L_0x05b5
        L_0x05d7:
            float r5 = r1.f13637j0
            int r4 = r4 - r3
            float r4 = (float) r4
            float r5 = r5 / r4
            r1.f13637j0 = r5
            float r4 = r1.f13638k0
            float r4 = r4 - r5
            r1.f13638k0 = r4
            float r4 = r1.f13639l0
            float r4 = r4 - r5
            r1.f13639l0 = r4
            r1.f13640m0 = r0
            r8 = r2
        L_0x05eb:
            int r0 = r1.f13617R
            int r4 = r0 + -1
            if (r8 >= r4) goto L_0x0603
            float r0 = r1.f13640m0
            float[] r4 = r1.f13594C
            r4 = r4[r8]
            float r5 = r1.f13637j0
            float r6 = r4 - r5
            float r4 = r4 - r5
            float r6 = r6 * r4
            float r0 = r0 + r6
            r1.f13640m0 = r0
            int r8 = r8 + 1
            goto L_0x05eb
        L_0x0603:
            float r4 = r1.f13640m0
            float r0 = (float) r0
            float r4 = r4 / r0
            double r4 = (double) r4
            double r4 = java.lang.Math.sqrt(r4)
            float r0 = (float) r4
            r1.f13640m0 = r0
            float r0 = r1.f13638k0
            float r4 = r1.f13639l0
            int r5 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r5 == 0) goto L_0x0686
            double r5 = (double) r0
            r7 = -4626998257160447590(0xbfc999999999999a, double:-0.2)
            int r0 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r0 <= 0) goto L_0x0686
            double r4 = (double) r4
            r6 = 4596373779694328218(0x3fc999999999999a, double:0.2)
            int r0 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r0 >= 0) goto L_0x0686
            r1.f13657x = r3
            r1.f13590A = r2
            r1.f13642o0 = r3
            long r4 = android.os.SystemClock.elapsedRealtimeNanos()
            r1.f13611L = r4
            r1.f13612M = r4
            double[] r0 = r1.f13598E
            r4 = 0
            java.util.Arrays.fill(r0, r4)
            double[] r0 = r1.f13600F
            java.util.Arrays.fill(r0, r4)
            long[] r0 = r1.f13602G
            r4 = 0
            java.util.Arrays.fill(r0, r4)
            boolean r0 = r1.c0()
            if (r0 == 0) goto L_0x0681
            r18 = r3
            long r3 = android.os.SystemClock.elapsedRealtimeNanos()
            r22 = 0
            boolean r0 = r1.f13657x
            r10 = r2
            r2 = 0
            r5 = 0
            r7 = 0
            r16 = r10
            r9 = 0
            r11 = 0
            r13 = 0
            r15 = 0
            r34 = r16
            r16 = 0
            r17 = 0
            r37 = r18
            r18 = 0
            r20 = 0
            r40 = r24
            r24 = r0
            r1.e(r2, r3, r5, r7, r9, r11, r13, r15, r16, r17, r18, r20, r22, r24)
            r2 = 1
        L_0x067f:
            r10 = 0
            goto L_0x068d
        L_0x0681:
            r40 = r24
            r10 = r2
            r2 = r3
            goto L_0x068d
        L_0x0686:
            r40 = r24
            r2 = r3
            r1.f0(r2)
            goto L_0x067f
        L_0x068d:
            r1.f13617R = r10
            r1.f13641n0 = r10
        L_0x0691:
            long r3 = r1.f13613N
            r5 = r40
            long r3 = r5 - r3
            r7 = 1800000000000(0x1a3185c5000, double:8.89318162514E-312)
            int r0 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r0 <= 0) goto L_0x06ea
            boolean r0 = r1.f13661z
            if (r0 == 0) goto L_0x06ea
            r1.f13661z = r10
            r1.f13614O = r5
            boolean r0 = r1.a0()
            if (r0 == 0) goto L_0x06b4
            boolean r0 = r1.d0()
            if (r0 == 0) goto L_0x06b7
        L_0x06b4:
            r35 = r5
            goto L_0x06ed
        L_0x06b7:
            boolean r0 = r1.f13657x
            boolean r3 = r1.c0()
            r0 = r0 & r3
            if (r0 == 0) goto L_0x06ea
            long r3 = android.os.SystemClock.elapsedRealtimeNanos()
            r22 = 0
            boolean r0 = r1.f13657x
            r18 = r2
            r2 = 0
            r24 = r5
            r5 = 0
            r7 = 0
            r9 = 0
            r11 = 0
            r13 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r37 = r18
            r18 = 0
            r20 = 0
            r35 = r24
            r24 = r0
            r1.e(r2, r3, r5, r7, r9, r11, r13, r15, r16, r17, r18, r20, r22, r24)
            goto L_0x0728
        L_0x06ea:
            r35 = r5
            goto L_0x0728
        L_0x06ed:
            boolean r0 = r1.f13650t0
            if (r0 != 0) goto L_0x0728
            r2 = 1
            r1.f13650t0 = r2
            long r3 = android.os.SystemClock.elapsedRealtimeNanos()
            r22 = 0
            boolean r0 = r1.f13657x
            r18 = r2
            r2 = 0
            r5 = 0
            r7 = 0
            r9 = 0
            r11 = 0
            r13 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r37 = r18
            r18 = 0
            r20 = 0
            r24 = r0
            r1.e(r2, r3, r5, r7, r9, r11, r13, r15, r16, r17, r18, r20, r22, r24)
            android.os.PowerManager$WakeLock r0 = r1.f13662z0
            if (r0 == 0) goto L_0x0728
            boolean r0 = r0.isHeld()
            if (r0 == 0) goto L_0x0728
            android.os.PowerManager$WakeLock r0 = r1.f13662z0
            r0.release()
        L_0x0728:
            boolean r0 = r1.f13661z
            if (r0 != 0) goto L_0x073c
            long r2 = r1.f13614O
            long r2 = r35 - r2
            r4 = 1200000000000(0x1176592e000, double:5.928787750095E-312)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x073c
            r2 = 1
            r1.f13661z = r2
        L_0x073c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.WorkerSensors.onSensorChanged(android.hardware.SensorEvent):void");
    }

    public void onStopped() {
        super.onStopped();
        if (this.f13605H0) {
            k0("0\f".concat(Y()).concat(this.f13630e.getString(C2030R.string.update_service_stop)));
        }
        PowerManager.WakeLock wakeLock = this.f13662z0;
        if (wakeLock != null && wakeLock.isHeld()) {
            this.f13662z0.release();
        }
        d dVar = this.f13645r;
        if (dVar != null) {
            try {
                this.f13630e.unregisterReceiver(dVar);
            } catch (Exception unused) {
            }
        }
        f fVar = this.f13647s;
        if (fVar != null) {
            try {
                this.f13630e.unregisterReceiver(fVar);
            } catch (Exception unused2) {
            }
        }
        c cVar = this.f13649t;
        if (cVar != null) {
            try {
                this.f13630e.unregisterReceiver(cVar);
            } catch (Exception unused3) {
            }
        }
        if (this.f13659y) {
            try {
                h0();
            } catch (Exception unused4) {
            }
        }
        Handler handler = this.f13607I0;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
        }
    }

    public com.google.common.util.concurrent.f startWork() {
        return androidx.concurrent.futures.c.a(new U4(this));
    }
}
