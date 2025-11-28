package com.finazzi.distquake;

import H3.f;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.hardware.display.DisplayManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.C0768d;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.core.view.C0832r0;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.util.Locale;
import u2.A4;
import u2.B4;
import u2.C1882v4;
import u2.C1888w4;
import u2.C1894x4;
import u2.C1900y4;
import u2.C1906z4;
import u2.C4;
import u2.D4;
import u2.E4;

public class StatusActivity extends C0768d implements ViewTreeObserver.OnGlobalLayoutListener, SensorEventListener {

    /* renamed from: O  reason: collision with root package name */
    private SensorManager f13510O;

    /* renamed from: P  reason: collision with root package name */
    private FrameLayout f13511P;

    /* renamed from: Q  reason: collision with root package name */
    private AdView f13512Q;

    /* renamed from: R  reason: collision with root package name */
    private Intent f13513R;

    /* renamed from: S  reason: collision with root package name */
    private b f13514S;

    /* renamed from: T  reason: collision with root package name */
    private c f13515T;

    /* renamed from: U  reason: collision with root package name */
    private a f13516U;

    /* renamed from: V  reason: collision with root package name */
    private ImageView f13517V;

    /* renamed from: W  reason: collision with root package name */
    private Bitmap f13518W;

    /* renamed from: X  reason: collision with root package name */
    private Canvas f13519X;

    /* renamed from: Y  reason: collision with root package name */
    private Paint f13520Y;

    /* renamed from: Z  reason: collision with root package name */
    private Rect f13521Z;

    /* renamed from: a0  reason: collision with root package name */
    private float[] f13522a0;

    /* renamed from: b0  reason: collision with root package name */
    private float[] f13523b0;

    /* renamed from: c0  reason: collision with root package name */
    private int f13524c0;

    /* renamed from: d0  reason: collision with root package name */
    private int f13525d0;

    /* renamed from: e0  reason: collision with root package name */
    private int f13526e0 = 0;

    /* renamed from: f0  reason: collision with root package name */
    private boolean f13527f0 = false;

    /* renamed from: g0  reason: collision with root package name */
    private boolean f13528g0;

    /* renamed from: h0  reason: collision with root package name */
    private boolean f13529h0 = false;

    /* renamed from: i0  reason: collision with root package name */
    private boolean f13530i0 = false;

    /* renamed from: j0  reason: collision with root package name */
    private final float[] f13531j0 = new float[3];

    /* renamed from: k0  reason: collision with root package name */
    private long f13532k0 = 0;

    /* renamed from: l0  reason: collision with root package name */
    private long f13533l0 = 0;

    public class a extends BroadcastReceiver {
        public a() {
        }

        public void onReceive(Context context, Intent intent) {
            boolean booleanExtra = intent.getBooleanExtra("noConnectivity", false);
            ImageView imageView = (ImageView) StatusActivity.this.findViewById(C2030R.id.imageView4);
            if (!booleanExtra) {
                imageView.setImageResource(2131231207);
            } else {
                imageView.setImageResource(2131231345);
            }
        }
    }

    public class b extends BroadcastReceiver {
        public b() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null) {
                if (action.equals("android.intent.action.ACTION_POWER_DISCONNECTED")) {
                    ((ImageView) StatusActivity.this.findViewById(C2030R.id.imageView1)).setImageResource(2131231345);
                }
                if (action.equals("android.intent.action.ACTION_POWER_CONNECTED")) {
                    ((ImageView) StatusActivity.this.findViewById(C2030R.id.imageView1)).setImageResource(2131231207);
                }
            }
        }
    }

    public class c extends BroadcastReceiver {
        public c() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null) {
                if (action.equals("android.intent.action.SCREEN_ON")) {
                    ((ImageView) StatusActivity.this.findViewById(C2030R.id.imageView2)).setImageResource(2131231345);
                }
                if (action.equals("android.intent.action.SCREEN_OFF")) {
                    ((ImageView) StatusActivity.this.findViewById(C2030R.id.imageView2)).setImageResource(2131231207);
                }
            }
        }
    }

    public static /* synthetic */ void f0(StatusActivity statusActivity, View view) {
        statusActivity.getClass();
        Intent intent = new Intent().setClass(statusActivity, LogActivity.class);
        statusActivity.f13513R = intent;
        statusActivity.startActivity(intent);
    }

    public static /* synthetic */ void l0(DialogInterface dialogInterface, int i8) {
    }

    public static /* synthetic */ void m0(StatusActivity statusActivity, InitializationStatus initializationStatus) {
        statusActivity.f13511P = (FrameLayout) statusActivity.findViewById(C2030R.id.ad_view_container);
        statusActivity.v0();
    }

    /* access modifiers changed from: private */
    public void o0(String str) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(str).setCancelable(false).setNegativeButton(getString(C2030R.string.status_cancel), new C1882v4());
        builder.create().show();
    }

    private AdSize p0() {
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, (int) (((float) displayMetrics.widthPixels) / displayMetrics.density));
    }

    private float[] q0() {
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.class.getSimpleName(), 0);
        return new float[]{sharedPreferences.getFloat("current_latitude", BitmapDescriptorFactory.HUE_RED), sharedPreferences.getFloat("current_longitude", BitmapDescriptorFactory.HUE_RED), sharedPreferences.getFloat("current_accuracy", -1.0f)};
    }

    private boolean r0() {
        Intent registerReceiver = registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        if (registerReceiver == null) {
            return false;
        }
        int intExtra = registerReceiver.getIntExtra("plugged", -1);
        if (intExtra == 1 || intExtra == 2 || intExtra == 4) {
            return true;
        }
        return false;
    }

    private boolean s0() {
        boolean z7;
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService("connectivity");
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

    private boolean t0() {
        boolean z7;
        boolean z8;
        boolean z9 = false;
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.class.getSimpleName(), 0);
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

    private boolean u0() {
        DisplayManager displayManager = (DisplayManager) getSystemService("display");
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

    private void v0() {
        AdView adView = new AdView(this);
        this.f13512Q = adView;
        adView.setAdUnitId("ca-app-pub-4050044861382446/6189681827");
        this.f13511P.removeAllViews();
        this.f13511P.addView(this.f13512Q);
        this.f13512Q.setAdSize(p0());
        this.f13512Q.loadAd(new AdRequest.Builder().build());
    }

    public void onAccuracyChanged(Sensor sensor, int i8) {
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2030R.layout.status_card);
        int i8 = getResources().getConfiguration().uiMode & 48;
        if (Build.VERSION.SDK_INT >= 35 && i8 == 16) {
            Window window = getWindow();
            C0832r0.a(window, window.getDecorView()).d(true);
        }
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.class.getSimpleName(), 0);
        this.f13528g0 = sharedPreferences.getBoolean("pro_features", false);
        sharedPreferences.getInt("ads_type", 0);
        this.f13527f0 = false;
        Toolbar toolbar = (Toolbar) findViewById(C2030R.id.toolbar);
        b0(toolbar);
        if (!this.f13528g0) {
            toolbar.setLogo(2131230872);
        } else {
            toolbar.setLogo(2131230875);
        }
        if (!this.f13528g0 && f.a(this).canRequestAds()) {
            MobileAds.initialize(this, new C1894x4(this));
        }
        ((CardView) findViewById(C2030R.id.cardEvent)).setOnClickListener(new C1900y4(this));
        ((ImageView) findViewById(C2030R.id.imageView1)).setOnClickListener(new C1906z4(this));
        ((ImageView) findViewById(C2030R.id.imageView2)).setOnClickListener(new A4(this));
        ((ImageView) findViewById(C2030R.id.imageView4)).setOnClickListener(new B4(this));
        ((ImageView) findViewById(C2030R.id.imageView5)).setOnClickListener(new C4(this));
        ((ImageView) findViewById(C2030R.id.imageView6)).setOnClickListener(new D4(this));
        ((TextView) findViewById(C2030R.id.textView8)).setText(getString(C2030R.string.main_nodata));
        TextView textView = (TextView) findViewById(C2030R.id.textView9);
        textView.setVisibility(8);
        textView.setText(getString(C2030R.string.main_nodata));
        TextView textView2 = (TextView) findViewById(C2030R.id.textView11);
        textView2.setText(getString(C2030R.string.main_nodata));
        textView2.setVisibility(8);
        try {
            InputStreamReader inputStreamReader = new InputStreamReader(openFileInput("log3.txt"));
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
            int i9 = 0;
            String str2 = str;
            String str3 = str2;
            String str4 = str3;
            String str5 = str4;
            String str6 = str5;
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    String[] split = readLine.split("\f");
                    String str7 = split[1];
                    String str8 = split[2];
                    i9++;
                    if (i9 > 2) {
                        str5 = str2;
                        str6 = str3;
                    }
                    if (i9 > 1) {
                        str3 = str;
                        str2 = str4;
                    }
                    if (i9 > 0) {
                        str4 = str8;
                        str = str7;
                    }
                } catch (IOException e8) {
                    if (e8.getMessage() != null) {
                        Log.d("EQN", e8.getMessage());
                    }
                }
            }
            if (i9 > 0) {
                ((TextView) findViewById(C2030R.id.textView8)).setText(str + " - " + str4);
            }
            if (i9 > 1) {
                TextView textView3 = (TextView) findViewById(C2030R.id.textView9);
                textView3.setVisibility(0);
                textView3.setText(str3 + " - " + str2);
            }
            if (i9 > 2) {
                TextView textView4 = (TextView) findViewById(C2030R.id.textView11);
                textView4.setVisibility(0);
                textView4.setText(str6 + " - " + str5);
            }
            inputStreamReader.close();
        } catch (IOException e9) {
            if (e9.getMessage() != null) {
                Log.d("EQN", e9.getMessage());
            }
        }
        ImageView imageView = (ImageView) findViewById(C2030R.id.imageView3);
        this.f13517V = imageView;
        imageView.getViewTreeObserver().addOnGlobalLayoutListener(this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        AdView adView = this.f13512Q;
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }

    public void onGlobalLayout() {
        Sensor defaultSensor;
        if (!this.f13529h0) {
            this.f13518W = Bitmap.createBitmap(this.f13517V.getWidth(), this.f13517V.getHeight(), Bitmap.Config.RGB_565).copy(Bitmap.Config.ARGB_8888, true);
            this.f13519X = new Canvas(this.f13518W);
            this.f13520Y = new Paint();
            Rect rect = new Rect();
            this.f13521Z = rect;
            rect.left = 0;
            rect.top = 0;
            rect.right = this.f13519X.getWidth();
            this.f13521Z.bottom = this.f13519X.getHeight();
            this.f13522a0 = new float[(this.f13519X.getWidth() / 4)];
            this.f13523b0 = new float[(this.f13519X.getWidth() / 4)];
            this.f13525d0 = this.f13519X.getWidth();
            this.f13524c0 = this.f13519X.getHeight();
            this.f13527f0 = true;
            this.f13529h0 = true;
            if (this.f13510O.getDefaultSensor(1) != null && (defaultSensor = this.f13510O.getDefaultSensor(1)) != null) {
                this.f13510O.registerListener(this, defaultSensor, 1);
                new Handler().postDelayed(new C1888w4(this), 120000);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        AdView adView = this.f13512Q;
        if (adView != null) {
            adView.pause();
        }
        unregisterReceiver(this.f13514S);
        unregisterReceiver(this.f13515T);
        unregisterReceiver(this.f13516U);
        this.f13510O.unregisterListener(this);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        Sensor defaultSensor;
        AdView adView;
        super.onResume();
        if (!this.f13528g0 && (adView = this.f13512Q) != null) {
            adView.resume();
        }
        SensorManager sensorManager = (SensorManager) getSystemService("sensor");
        this.f13510O = sensorManager;
        if (sensorManager == null || sensorManager.getDefaultSensor(1) == null) {
            Toast makeText = Toast.makeText(this, getString(C2030R.string.main_no_acc), 1);
            makeText.setGravity(17, 0, 0);
            makeText.show();
        } else if (this.f13527f0 && (defaultSensor = this.f13510O.getDefaultSensor(1)) != null) {
            this.f13510O.registerListener(this, defaultSensor, 1);
            new Handler().postDelayed(new E4(this), 120000);
        }
        if (u0()) {
            ((ImageView) findViewById(C2030R.id.imageView2)).setImageResource(2131231345);
        } else {
            ((ImageView) findViewById(C2030R.id.imageView2)).setImageResource(2131231207);
        }
        if (s0()) {
            ((ImageView) findViewById(C2030R.id.imageView4)).setImageResource(2131231207);
        } else {
            ((ImageView) findViewById(C2030R.id.imageView4)).setImageResource(2131231345);
        }
        if (r0()) {
            ((ImageView) findViewById(C2030R.id.imageView1)).setImageResource(2131231207);
        } else {
            ((ImageView) findViewById(C2030R.id.imageView1)).setImageResource(2131231345);
        }
        if (t0()) {
            float[] q02 = q0();
            ((ImageView) findViewById(C2030R.id.imageView5)).setImageResource(2131231207);
            ((TextView) findViewById(C2030R.id.textView10)).setText(getString(C2030R.string.status_position) + " " + String.format(Locale.getDefault(), "%.3f", new Object[]{Float.valueOf(q02[0])}) + getString(C2030R.string.status_latitude_short) + " " + String.format(Locale.getDefault(), "%.3f", new Object[]{Float.valueOf(q02[1])}) + getString(C2030R.string.status_longitude_short));
        } else {
            ((ImageView) findViewById(C2030R.id.imageView5)).setImageResource(2131231345);
            ((TextView) findViewById(C2030R.id.textView10)).setText(getString(C2030R.string.status_position_unknown));
        }
        if (this.f13510O.getDefaultSensor(1) != null) {
            ((ImageView) findViewById(C2030R.id.imageView6)).setImageResource(2131231207);
        } else {
            ((ImageView) findViewById(C2030R.id.imageView6)).setImageResource(2131231345);
        }
        IntentFilter intentFilter = new IntentFilter("android.intent.action.SCREEN_ON");
        intentFilter.addAction("android.intent.action.SCREEN_OFF");
        c cVar = new c();
        this.f13515T = cVar;
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 33) {
            Intent unused = registerReceiver(cVar, intentFilter, 4);
        } else {
            registerReceiver(cVar, intentFilter);
        }
        IntentFilter intentFilter2 = new IntentFilter("android.intent.action.ACTION_POWER_CONNECTED");
        intentFilter2.addAction("android.intent.action.ACTION_POWER_DISCONNECTED");
        b bVar = new b();
        this.f13514S = bVar;
        if (i8 >= 33) {
            Intent unused2 = registerReceiver(bVar, intentFilter2, 4);
        } else {
            registerReceiver(bVar, intentFilter2);
        }
        IntentFilter intentFilter3 = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
        a aVar = new a();
        this.f13516U = aVar;
        if (i8 >= 33) {
            Intent unused3 = registerReceiver(aVar, intentFilter3, 4);
        } else {
            registerReceiver(aVar, intentFilter3);
        }
        this.f13526e0 = 0;
    }

    public void onSensorChanged(SensorEvent sensorEvent) {
        if (sensorEvent.sensor.getType() == 1) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.f13533l0 > 10) {
                this.f13533l0 = currentTimeMillis;
                float[] fArr = this.f13531j0;
                float[] fArr2 = sensorEvent.values;
                float f8 = fArr2[0];
                fArr[0] = f8;
                float f9 = fArr2[1];
                fArr[1] = f9;
                float f10 = fArr2[2];
                fArr[2] = f10;
                float sqrt = (float) Math.sqrt((double) ((f8 * f8) + (f9 * f9) + (f10 * f10)));
                if (this.f13519X != null && this.f13527f0) {
                    float f11 = sqrt - 9.80665f;
                    if (!this.f13530i0) {
                        this.f13530i0 = true;
                        float[] fArr3 = this.f13522a0;
                        int i8 = this.f13526e0;
                        fArr3[i8] = (((float) this.f13524c0) / 2.0f) + (8.0f * f11);
                        this.f13523b0[i8] = f11;
                        if (i8 < fArr3.length - 1) {
                            this.f13526e0 = i8 + 1;
                        } else {
                            System.arraycopy(fArr3, 1, fArr3, 0, fArr3.length - 1);
                            float[] fArr4 = this.f13523b0;
                            System.arraycopy(fArr4, 1, fArr4, 0, fArr4.length - 1);
                        }
                        this.f13520Y.setStyle(Paint.Style.FILL);
                        this.f13520Y.setColor(-1);
                        this.f13519X.drawRect(this.f13521Z, this.f13520Y);
                        this.f13520Y.setStyle(Paint.Style.STROKE);
                        this.f13520Y.setStrokeWidth(3.0f);
                        this.f13520Y.setColor(-16777216);
                        this.f13519X.drawRect(this.f13521Z, this.f13520Y);
                        Canvas canvas = this.f13519X;
                        int i9 = this.f13524c0;
                        canvas.drawLine(BitmapDescriptorFactory.HUE_RED, (float) (((double) i9) / 2.0d), (float) this.f13525d0, (float) (((double) i9) / 2.0d), this.f13520Y);
                        this.f13520Y.setColor(-65536);
                        Path path = new Path();
                        path.moveTo(BitmapDescriptorFactory.HUE_RED, this.f13522a0[0]);
                        int i10 = 0;
                        float f12 = 0.0f;
                        float f13 = 0.0f;
                        for (int i11 = 1; i11 <= this.f13526e0 - 1; i11++) {
                            float f14 = (float) (i11 * 4);
                            path.lineTo(f14, this.f13522a0[i11]);
                            if (Math.abs(this.f13523b0[i11]) > Math.abs(f12)) {
                                f12 = this.f13523b0[i11];
                                i10 = i11;
                                f13 = f14;
                            }
                        }
                        this.f13519X.drawPath(path, this.f13520Y);
                        if (((double) Math.abs(f12)) > 0.8d) {
                            DecimalFormat decimalFormat = new DecimalFormat("0.0");
                            String str = decimalFormat.format((double) (-f12)) + " m/s²";
                            this.f13520Y.setTextSize(30.0f);
                            this.f13520Y.setColor(-16776961);
                            this.f13520Y.setStyle(Paint.Style.FILL_AND_STROKE);
                            this.f13520Y.setStrokeWidth(1.0f);
                            this.f13520Y.setTextAlign(Paint.Align.CENTER);
                            this.f13520Y.setTypeface(Typeface.DEFAULT);
                            Rect rect = new Rect();
                            this.f13520Y.getTextBounds(str, 0, str.length(), rect);
                            if (f12 > BitmapDescriptorFactory.HUE_RED) {
                                this.f13519X.drawText(str, f13, this.f13522a0[i10] + 20.0f + ((float) rect.height()), this.f13520Y);
                            } else {
                                this.f13519X.drawText(str, f13, this.f13522a0[i10] - 20.0f, this.f13520Y);
                            }
                        }
                        this.f13517V.setImageBitmap(this.f13518W);
                        this.f13530i0 = false;
                        if (SystemClock.elapsedRealtimeNanos() - this.f13532k0 > 400000000) {
                            ((TextView) findViewById(C2030R.id.textView4)).setText(getString(C2030R.string.status_acceleration) + ": " + new DecimalFormat("0.00").format((double) f11) + " m/s²");
                            this.f13532k0 = SystemClock.elapsedRealtimeNanos();
                        }
                    }
                }
            }
        }
    }
}
