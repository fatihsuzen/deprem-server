package com.finazzi.distquake;

import android.app.Activity;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.C0768d;
import androidx.core.content.FileProvider;
import androidx.core.view.C0832r0;
import androidx.preference.g;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import u2.C1775e;
import u2.C1781f;
import u2.C1787g;
import u2.C1793h;
import u2.C1799i;
import u2.C1805j;

public class AlertActivity extends C0768d implements OnMapReadyCallback, GoogleMap.SnapshotReadyCallback {
    /* access modifiers changed from: private */

    /* renamed from: O  reason: collision with root package name */
    public double f12489O;
    /* access modifiers changed from: private */

    /* renamed from: P  reason: collision with root package name */
    public double f12490P;
    /* access modifiers changed from: private */

    /* renamed from: Q  reason: collision with root package name */
    public double f12491Q;
    /* access modifiers changed from: private */

    /* renamed from: R  reason: collision with root package name */
    public double f12492R;
    /* access modifiers changed from: private */

    /* renamed from: S  reason: collision with root package name */
    public String f12493S;
    /* access modifiers changed from: private */

    /* renamed from: T  reason: collision with root package name */
    public String f12494T;
    /* access modifiers changed from: private */

    /* renamed from: U  reason: collision with root package name */
    public float f12495U;
    /* access modifiers changed from: private */

    /* renamed from: V  reason: collision with root package name */
    public double f12496V;
    /* access modifiers changed from: private */

    /* renamed from: W  reason: collision with root package name */
    public double f12497W;
    /* access modifiers changed from: private */

    /* renamed from: X  reason: collision with root package name */
    public int f12498X;

    /* renamed from: Y  reason: collision with root package name */
    private int f12499Y;
    /* access modifiers changed from: private */

    /* renamed from: Z  reason: collision with root package name */
    public String f12500Z = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    /* access modifiers changed from: private */

    /* renamed from: a0  reason: collision with root package name */
    public String f12501a0;

    /* renamed from: b0  reason: collision with root package name */
    private int f12502b0;
    /* access modifiers changed from: private */

    /* renamed from: c0  reason: collision with root package name */
    public int f12503c0;

    /* renamed from: d0  reason: collision with root package name */
    private e f12504d0;

    /* renamed from: e0  reason: collision with root package name */
    private f f12505e0;
    /* access modifiers changed from: private */

    /* renamed from: f0  reason: collision with root package name */
    public TextToSpeech f12506f0;
    /* access modifiers changed from: private */

    /* renamed from: g0  reason: collision with root package name */
    public Marker f12507g0;
    /* access modifiers changed from: private */

    /* renamed from: h0  reason: collision with root package name */
    public final String[] f12508h0 = {"#7F000D", "#840B19", "#891923", "#8D232B", "#912C33", "#96343A", "#9A3C41", "#9E4348", "#A24A4F", "#A65155", "#AA585C", "#AE5F62", "#B16569", "#B56C6F", "#B87275", "#BC797B", "#BF7F81", "#C28588", "#C58B8E", "#C89193", "#CB9799", "#CE9D9F", "#D1A3A5", "#D3A9AA", "#D6AFB0", "#D8B4B5", "#DBBABB", "#DDBFC0", "#DFC4C5", "#E2C9CA", "#E4CECF", "#E5D3D4", "#E7D8D8", "#E9DCDD", "#EBE1E1", "#ECE5E5", "#EEE8E8", "#EFECEC", "#F0EFEF", "#F1F1F1"};
    /* access modifiers changed from: private */

    /* renamed from: i0  reason: collision with root package name */
    public final String[] f12509i0 = {"#FFCA40", "#FFCB4C", "#FFCC56", "#FFCE5F", "#FFCF67", "#FFD06E", "#FFD175", "#FFD27C", "#FFD482", "#FFD588", "#FFD68D", "#FFD793", "#FFD898", "#FFD99D", "#FFDAA2", "#FFDCA6", "#FFDDAB", "#FFDEAF", "#FFDFB3", "#FFE0B7", "#FFE1BB", "#FFE2BF", "#FFE3C3", "#FFE4C7", "#FFE5CA", "#FEE6CE", "#FDE7D1", "#FCE8D4", "#FBE9D7", "#FAEADA", "#F9EBDD", "#F8EBE0", "#F6ECE3", "#F5EDE5", "#F4EEE8", "#F4EEEA", "#F3EFEC", "#F2F0EE", "#F1F0EF", "#F1F1F1"};
    /* access modifiers changed from: private */

    /* renamed from: j0  reason: collision with root package name */
    public final String[] f12510j0 = {"#00763B", "#007A41", "#007E47", "#00824D", "#008653", "#008A59", "#008D5E", "#009164", "#00956A", "#00996F", "#009C74", "#01A07A", "#27A47F", "#39A784", "#47AB8A", "#53AF8F", "#5EB294", "#68B699", "#72B99E", "#7BBCA3", "#83C0A8", "#8BC3AD", "#93C6B1", "#9AC9B6", "#A2CCBB", "#A9D0BF", "#AFD3C4", "#B6D6C8", "#BCD8CC", "#C3DBD1", "#C9DED5", "#CEE1D9", "#D4E3DC", "#D9E6E0", "#DEE8E4", "#E3EAE7", "#E7ECEA", "#EBEEED", "#EEF0EF", "#F1F1F1"};
    /* access modifiers changed from: private */

    /* renamed from: k0  reason: collision with root package name */
    public final String[] f12511k0 = {"#474747", "#4C4C4C", "#515151", "#575757", "#5C5C5C", "#616161", "#666666", "#6B6B6B", "#717171", "#767676", "#7B7B7B", "#808080", "#858585", "#8A8A8A", "#8E8E8E", "#939393", "#989898", "#9D9D9D", "#A1A1A1", "#A6A6A6", "#AAAAAA", "#AEAEAE", "#B2B2B2", "#B7B7B7", "#BABABA", "#BEBEBE", "#C2C2C2", "#C6C6C6", "#C9C9C9", "#CCCCCC", "#D0D0D0", "#D3D3D3", "#D5D5D5", "#D8D8D8", "#DBDBDB", "#DDDDDD", "#DFDFDF", "#E0E0E0", "#E2E2E2", "#E2E2E2"};

    /* renamed from: l0  reason: collision with root package name */
    private CountDownTimer f12512l0;

    /* renamed from: m0  reason: collision with root package name */
    private CountDownTimer f12513m0;

    /* renamed from: n0  reason: collision with root package name */
    private CountDownTimer f12514n0;
    /* access modifiers changed from: private */

    /* renamed from: o0  reason: collision with root package name */
    public GoogleMap f12515o0;
    /* access modifiers changed from: private */

    /* renamed from: p0  reason: collision with root package name */
    public Circle f12516p0;

    /* renamed from: q0  reason: collision with root package name */
    private FrameLayout f12517q0;

    /* renamed from: r0  reason: collision with root package name */
    private AdView f12518r0;

    /* renamed from: s0  reason: collision with root package name */
    private boolean f12519s0 = false;

    /* renamed from: t0  reason: collision with root package name */
    private boolean f12520t0;

    class a extends CountDownTimer {
        a(long j8, long j9) {
            super(j8, j9);
        }

        public void onFinish() {
            String quantityString = AlertActivity.this.getResources().getQuantityString(C2030R.plurals.alert_wave, 0, new Object[]{0});
            TextView textView = (TextView) AlertActivity.this.findViewById(C2030R.id.textView2);
            if (textView != null) {
                textView.setVisibility(0);
                textView.setText(quantityString);
            }
        }

        public void onTick(long j8) {
            int unused = AlertActivity.this.f12503c0 = (int) Math.round(((double) j8) / 1000.0d);
            String quantityString = AlertActivity.this.getResources().getQuantityString(C2030R.plurals.alert_wave, AlertActivity.this.f12503c0, new Object[]{Integer.valueOf(AlertActivity.this.f12503c0)});
            TextView textView = (TextView) AlertActivity.this.findViewById(C2030R.id.textView2);
            if (textView != null) {
                textView.setVisibility(0);
                textView.setText(quantityString);
                if (AlertActivity.this.f12503c0 > 15) {
                    textView.setTextColor(Color.rgb(255, 140, 0));
                } else if (AlertActivity.this.f12503c0 > 5) {
                    textView.setTextColor(Color.rgb(255, 100, 0));
                } else {
                    textView.setTextColor(Color.rgb(255, 0, 0));
                }
            }
        }
    }

    class b extends CountDownTimer {
        b(long j8, long j9) {
            super(j8, j9);
        }

        public void onFinish() {
            if (AlertActivity.this.f12516p0 != null) {
                AlertActivity.this.f12516p0.remove();
            }
        }

        public void onTick(long j8) {
            double m02 = (((120000.0d - ((double) j8)) / 1000.0d) + AlertActivity.this.f12491Q) * ((double) AlertActivity.this.f12495U) * 1000.0d;
            if (AlertActivity.this.f12515o0 != null) {
                if (AlertActivity.this.f12516p0 != null) {
                    AlertActivity.this.f12516p0.remove();
                }
                CircleOptions circleOptions = new CircleOptions();
                circleOptions.center(new LatLng(AlertActivity.this.f12489O, AlertActivity.this.f12490P));
                circleOptions.radius(m02);
                circleOptions.strokeColor(-65536);
                circleOptions.fillColor(Color.argb(50, UserVerificationMethods.USER_VERIFY_PATTERN, 0, 0));
                circleOptions.strokeWidth(7.0f);
                if (AlertActivity.this.f12515o0 != null) {
                    AlertActivity alertActivity = AlertActivity.this;
                    Circle unused = alertActivity.f12516p0 = alertActivity.f12515o0.addCircle(circleOptions);
                }
            }
        }
    }

    class c extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        private int f12523a = -1;

        /* renamed from: b  reason: collision with root package name */
        private int f12524b = 1;

        c(long j8, long j9) {
            super(j8, j9);
        }

        public void onFinish() {
            LinearLayout linearLayout = (LinearLayout) AlertActivity.this.findViewById(C2030R.id.layoutExternal);
            if (AlertActivity.this.f12496V < 1.5d) {
                linearLayout.setBackgroundColor(Color.parseColor(AlertActivity.this.f12511k0[0]));
            } else if (AlertActivity.this.f12496V < 3.0d) {
                linearLayout.setBackgroundColor(Color.parseColor(AlertActivity.this.f12510j0[0]));
            } else if (AlertActivity.this.f12496V < 4.5d) {
                linearLayout.setBackgroundColor(Color.parseColor(AlertActivity.this.f12509i0[0]));
            } else {
                linearLayout.setBackgroundColor(Color.parseColor(AlertActivity.this.f12508h0[0]));
            }
        }

        public void onTick(long j8) {
            LinearLayout linearLayout = (LinearLayout) AlertActivity.this.findViewById(C2030R.id.layoutExternal);
            int i8 = this.f12523a;
            int i9 = this.f12524b;
            int i10 = i8 + i9;
            this.f12523a = i10;
            if (i10 > 39) {
                this.f12524b = i9 * -1;
                this.f12523a = 39;
            }
            if (this.f12523a < 0) {
                this.f12524b *= -1;
                this.f12523a = 0;
            }
            if (AlertActivity.this.f12496V < 1.5d) {
                linearLayout.setBackgroundColor(Color.parseColor(AlertActivity.this.f12511k0[this.f12523a]));
            } else if (AlertActivity.this.f12496V < 3.0d) {
                linearLayout.setBackgroundColor(Color.parseColor(AlertActivity.this.f12510j0[this.f12523a]));
            } else if (AlertActivity.this.f12496V < 4.5d) {
                linearLayout.setBackgroundColor(Color.parseColor(AlertActivity.this.f12509i0[this.f12523a]));
            } else {
                linearLayout.setBackgroundColor(Color.parseColor(AlertActivity.this.f12508h0[this.f12523a]));
            }
        }
    }

    class d extends UtteranceProgressListener {
        d() {
        }

        public void onDone(String str) {
            if (AlertActivity.this.f12506f0 != null) {
                AlertActivity.this.f12506f0.stop();
                AlertActivity.this.f12506f0.shutdown();
            }
        }

        public void onError(String str) {
            if (AlertActivity.this.f12506f0 != null) {
                AlertActivity.this.f12506f0.stop();
                AlertActivity.this.f12506f0.shutdown();
            }
        }

        public void onStart(String str) {
        }
    }

    public class e extends BroadcastReceiver {
        public e() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null && action.equals("com.finazzi.distquake.close_alert") && intent.getExtras().getInt("com.finazzi.distquake.code_eqn", 0) != AlertActivity.this.f12498X) {
                AlertActivity.this.finish();
            }
        }
    }

    public class f extends BroadcastReceiver {
        public f() {
        }

        public void onReceive(Context context, Intent intent) {
            String str;
            String action = intent.getAction();
            if (action != null && action.equals("com.finazzi.distquake.update_alert") && intent.getExtras().getInt("com.finazzi.distquake.code_eqn", 0) == AlertActivity.this.f12498X) {
                double unused = AlertActivity.this.f12497W = (double) intent.getExtras().getFloat("com.finazzi.distquake.new_magnitude", BitmapDescriptorFactory.HUE_RED);
                double unused2 = AlertActivity.this.f12496V = intent.getExtras().getDouble("com.finazzi.distquake.new_intensity_at_location", 0.0d);
                if (AlertActivity.this.f12492R != -1.0d) {
                    DecimalFormatSymbols instance = DecimalFormatSymbols.getInstance();
                    instance.setDecimalSeparator('.');
                    DecimalFormat decimalFormat = new DecimalFormat("0.0", instance);
                    if (AlertActivity.this.f12501a0.equalsIgnoreCase("0")) {
                        str = String.format(AlertActivity.this.getString(C2030R.string.main_detected), new Object[]{decimalFormat.format(AlertActivity.this.f12497W), AlertActivity.this.f12493S, Integer.valueOf((int) Math.round(AlertActivity.this.f12492R)), AlertActivity.this.f12494T});
                    } else {
                        AlertActivity alertActivity = AlertActivity.this;
                        double unused3 = alertActivity.f12492R = alertActivity.f12492R * 0.621371192d;
                        str = String.format(AlertActivity.this.getString(C2030R.string.main_detected_imperial), new Object[]{decimalFormat.format(AlertActivity.this.f12497W), AlertActivity.this.f12493S, Integer.valueOf((int) Math.round(AlertActivity.this.f12492R)), AlertActivity.this.f12494T});
                    }
                    ((TextView) AlertActivity.this.findViewById(C2030R.id.textView1)).setText(str);
                    TextView textView = (TextView) AlertActivity.this.findViewById(C2030R.id.textView3);
                    if (AlertActivity.this.f12496V < 1.5d) {
                        textView.setText(AlertActivity.this.getString(C2030R.string.alert_intensity_no_shaking));
                        textView.setTextColor(Color.rgb(90, 90, 90));
                        String unused4 = AlertActivity.this.f12500Z = "not_perceived";
                    } else if (AlertActivity.this.f12496V < 3.0d) {
                        textView.setText(AlertActivity.this.getString(C2030R.string.alert_intensity_mild));
                        textView.setTextColor(Color.rgb(38, 100, 38));
                        String unused5 = AlertActivity.this.f12500Z = "mild";
                    } else if (AlertActivity.this.f12496V < 4.5d) {
                        textView.setText(AlertActivity.this.getString(C2030R.string.alert_intensity_moderate));
                        textView.setTextColor(Color.rgb(255, 140, 0));
                        String unused6 = AlertActivity.this.f12500Z = "moderate";
                    } else {
                        textView.setText(AlertActivity.this.getString(C2030R.string.alert_intensity_strong));
                        textView.setTextColor(Color.rgb(215, 0, 0));
                        String unused7 = AlertActivity.this.f12500Z = "strong";
                    }
                }
                if (AlertActivity.this.f12515o0 != null) {
                    if (AlertActivity.this.f12507g0 != null) {
                        AlertActivity.this.f12507g0.remove();
                    }
                    LatLng latLng = new LatLng(AlertActivity.this.f12489O, AlertActivity.this.f12490P);
                    MarkerOptions markerOptions = new MarkerOptions();
                    markerOptions.position(latLng);
                    markerOptions.anchor(0.5f, 0.5f);
                    if (AlertActivity.this.f12497W < 3.0d) {
                        markerOptions.icon(BitmapDescriptorFactory.fromResource(2131231367));
                    } else if (AlertActivity.this.f12497W < 5.0d) {
                        markerOptions.icon(BitmapDescriptorFactory.fromResource(2131231363));
                    } else {
                        markerOptions.icon(BitmapDescriptorFactory.fromResource(2131231361));
                    }
                    AlertActivity alertActivity2 = AlertActivity.this;
                    Marker unused8 = alertActivity2.f12507g0 = alertActivity2.f12515o0.addMarker(markerOptions);
                }
            }
        }
    }

    public AlertActivity() {
    }

    private AdSize L0() {
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, (int) (((float) displayMetrics.widthPixels) / displayMetrics.density));
    }

    private void M0() {
        AdView adView = new AdView(this);
        this.f12518r0 = adView;
        adView.setAdUnitId("ca-app-pub-4050044861382446/6189681827");
        this.f12517q0.removeAllViews();
        this.f12517q0.addView(this.f12518r0);
        this.f12518r0.setAdSize(L0());
        this.f12518r0.loadAd(new AdRequest.Builder().build());
    }

    public static /* synthetic */ void e0(AlertActivity alertActivity, Button button, View view) {
        GoogleMap googleMap = alertActivity.f12515o0;
        if (googleMap != null) {
            googleMap.snapshot(alertActivity);
        }
        button.setEnabled(false);
    }

    public static /* synthetic */ void f0(AlertActivity alertActivity, View view) {
        alertActivity.getClass();
        Intent intent = new Intent();
        intent.setAction("com.finazzi.distquake.stopalarm");
        intent.setPackage("com.finazzi.distquake");
        alertActivity.sendBroadcast(intent);
        CountDownTimer countDownTimer = alertActivity.f12514n0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    public static /* synthetic */ void g0(AlertActivity alertActivity, String str, int i8) {
        if (i8 != -1) {
            String string = alertActivity.getString(C2030R.string.current_language);
            if (string.equals("eng")) {
                alertActivity.f12506f0.setLanguage(Locale.ENGLISH);
            }
            if (string.equals("ita")) {
                alertActivity.f12506f0.setLanguage(Locale.ITALIAN);
            }
            if (string.equals("es")) {
                alertActivity.f12506f0.setLanguage(new Locale("es"));
            }
            if (string.equals("tr")) {
                alertActivity.f12506f0.setLanguage(new Locale("tr"));
            }
            if (string.equals("el")) {
                alertActivity.f12506f0.setLanguage(new Locale("el"));
            }
            if (string.equals("fr")) {
                alertActivity.f12506f0.setLanguage(new Locale("fr"));
            }
            if (string.equals("in")) {
                alertActivity.f12506f0.setLanguage(new Locale("in"));
            }
            if (string.equals("hr")) {
                alertActivity.f12506f0.setLanguage(new Locale("hr"));
            }
            alertActivity.f12506f0.setSpeechRate(1.0f);
            alertActivity.f12506f0.speak(str, 0, (Bundle) null, "tts");
            return;
        }
        alertActivity.getClass();
    }

    public static /* synthetic */ void h0(AlertActivity alertActivity, LatLng latLng, Location location) {
        if (location == null) {
            alertActivity.getClass();
        } else if (alertActivity.f12515o0 != null && alertActivity.f12520t0) {
            LatLng latLng2 = new LatLng(location.getLatitude(), location.getLongitude());
            PolylineOptions polylineOptions = new PolylineOptions();
            polylineOptions.color(-65536);
            polylineOptions.geodesic(false);
            polylineOptions.width(4.0f);
            polylineOptions.add(latLng);
            polylineOptions.add(latLng2);
            alertActivity.f12515o0.addPolyline(polylineOptions);
        }
    }

    public static /* synthetic */ void i0(AlertActivity alertActivity, View view) {
        alertActivity.getClass();
        Intent intent = new Intent();
        intent.setAction("com.finazzi.distquake.stopalarm");
        intent.setPackage("com.finazzi.distquake");
        alertActivity.sendBroadcast(intent);
        CountDownTimer countDownTimer = alertActivity.f12512l0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = alertActivity.f12513m0;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
        }
        CountDownTimer countDownTimer3 = alertActivity.f12514n0;
        if (countDownTimer3 != null) {
            countDownTimer3.cancel();
        }
        Intent intent2 = new Intent().setClass(alertActivity, MainActivity.class);
        intent2.putExtra("from_alert_window", true);
        alertActivity.startActivity(intent2);
        alertActivity.finish();
    }

    public static /* synthetic */ void j0(AlertActivity alertActivity, InitializationStatus initializationStatus) {
        alertActivity.f12517q0 = (FrameLayout) alertActivity.findViewById(C2030R.id.ad_view_container);
        alertActivity.M0();
    }

    public void onCreate(Bundle bundle) {
        int i8;
        int i9;
        int i10;
        int i11;
        long j8;
        boolean z7;
        String str;
        String str2;
        String str3;
        super.onCreate(bundle);
        setRequestedOrientation(1);
        setContentView((int) C2030R.layout.alertdialog_fullscreen_layout);
        int i12 = getResources().getConfiguration().uiMode & 48;
        int i13 = Build.VERSION.SDK_INT;
        if (i13 >= 35 && i12 == 16) {
            Window window = getWindow();
            C0832r0.a(window, window.getDecorView()).d(true);
        }
        if (i13 >= 27) {
            setShowWhenLocked(true);
            setTurnScreenOn(true);
        }
        this.f12504d0 = new e();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.finazzi.distquake.close_alert");
        if (i13 >= 33) {
            Intent unused = registerReceiver(this.f12504d0, intentFilter, 4);
        } else {
            registerReceiver(this.f12504d0, intentFilter);
        }
        this.f12505e0 = new f();
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("com.finazzi.distquake.update_alert");
        if (i13 >= 33) {
            Intent unused2 = registerReceiver(this.f12505e0, intentFilter2, 4);
        } else {
            registerReceiver(this.f12505e0, intentFilter2);
        }
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.class.getSimpleName(), 0);
        this.f12519s0 = sharedPreferences.getBoolean("pro_features", false);
        SharedPreferences b8 = g.b(this);
        this.f12501a0 = b8.getString("eqn_system_of_units", "0");
        ((Button) findViewById(C2030R.id.button1)).setOnClickListener(new C1775e(this));
        ((Button) findViewById(C2030R.id.button2)).setOnClickListener(new C1781f(this));
        Button button = (Button) findViewById(C2030R.id.button3);
        button.setOnClickListener(new C1787g(this, button));
        ((LinearLayout) findViewById(C2030R.id.layoutInternal)).setBackgroundColor(getColor(C2030R.color.md_theme_background));
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f12489O = extras.getDouble("com.finazzi.distquake.latitude");
            this.f12490P = extras.getDouble("com.finazzi.distquake.longitude");
            long j9 = extras.getLong("com.finazzi.distquake.warning_time");
            this.f12492R = extras.getDouble("com.finazzi.distquake.distance");
            this.f12494T = extras.getString("com.finazzi.distquake.direction");
            this.f12491Q = (double) extras.getFloat("com.finazzi.distquake.alert_delay");
            this.f12493S = extras.getString("com.finazzi.distquake.location");
            this.f12495U = extras.getFloat("com.finazzi.distquake.wave_speed");
            this.f12497W = extras.getDouble("com.finazzi.distquake.magnitude");
            this.f12502b0 = extras.getInt("com.finazzi.distquake.notification_id");
            this.f12496V = extras.getDouble("com.finazzi.distquake.intensity_at_location");
            this.f12498X = extras.getInt("com.finazzi.distquake.alert_code");
            this.f12499Y = extras.getInt("com.finazzi.distquake.alert_update");
            if (this.f12492R != -1.0d) {
                DecimalFormatSymbols instance = DecimalFormatSymbols.getInstance();
                i10 = 3;
                instance.setDecimalSeparator('.');
                i9 = 2;
                DecimalFormat decimalFormat = new DecimalFormat("0.0", instance);
                if (this.f12501a0.equalsIgnoreCase("0")) {
                    i8 = 1;
                    i11 = i13;
                    str3 = String.format(getString(C2030R.string.main_detected), new Object[]{decimalFormat.format(this.f12497W), this.f12493S, Integer.valueOf((int) Math.round(this.f12492R)), this.f12494T});
                } else {
                    i8 = 1;
                    i11 = i13;
                    this.f12492R *= 0.621371192d;
                    str3 = String.format(getString(C2030R.string.main_detected_imperial), new Object[]{decimalFormat.format(this.f12497W), this.f12493S, Integer.valueOf((int) Math.round(this.f12492R)), this.f12494T});
                }
                ((TextView) findViewById(C2030R.id.textView1)).setText(str3);
                TextView textView = (TextView) findViewById(C2030R.id.textView3);
                textView.setTypeface(Typeface.DEFAULT_BOLD);
                double d8 = this.f12496V;
                if (d8 < 1.5d) {
                    textView.setText(getString(C2030R.string.alert_intensity_no_shaking));
                    textView.setTextColor(Color.rgb(90, 90, 90));
                    this.f12500Z = "not_perceived";
                } else if (d8 < 3.0d) {
                    textView.setText(getString(C2030R.string.alert_intensity_mild));
                    textView.setTextColor(Color.rgb(38, 100, 38));
                    this.f12500Z = "mild";
                } else if (d8 < 4.5d) {
                    textView.setText(getString(C2030R.string.alert_intensity_moderate));
                    textView.setTextColor(Color.rgb(255, 140, 0));
                    this.f12500Z = "moderate";
                } else {
                    textView.setText(getString(C2030R.string.alert_intensity_strong));
                    textView.setTextColor(Color.rgb(215, 0, 0));
                    this.f12500Z = "strong";
                }
            } else {
                i8 = 1;
                i11 = i13;
                i10 = 3;
                i9 = 2;
            }
            SharedPreferences.Editor edit = sharedPreferences.edit();
            edit.putInt("alert_code", this.f12498X);
            edit.putInt("alert_update", this.f12499Y);
            edit.putString("alert_shaking", this.f12500Z);
            edit.apply();
            int i14 = (j9 > 0 ? 1 : (j9 == 0 ? 0 : -1));
            if (i14 <= 0 || j9 >= 120) {
                j8 = 120;
            } else {
                Resources resources = getResources();
                int i15 = (int) j9;
                j8 = 120;
                Object[] objArr = new Object[i8];
                objArr[0] = Integer.valueOf(i15);
                String quantityString = resources.getQuantityString(C2030R.plurals.alert_wave, i15, objArr);
                TextView textView2 = (TextView) findViewById(C2030R.id.textView2);
                textView2.setVisibility(0);
                textView2.setText(quantityString);
                textView2.setTypeface(Typeface.DEFAULT_BOLD);
                if (j9 > 15) {
                    textView2.setTextColor(Color.rgb(255, 140, 0));
                } else if (j9 > 5) {
                    textView2.setTextColor(Color.rgb(255, 100, 0));
                } else {
                    textView2.setTextColor(Color.rgb(255, 0, 0));
                }
            }
            MapView mapView = (MapView) findViewById(C2030R.id.map);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("test", 1);
            mapView.onCreate(bundle2);
            mapView.onStart();
            mapView.onResume();
            mapView.getMapAsync(this);
            if (i14 > 0 && j9 < j8) {
                this.f12513m0 = new a(1000 * j9, 1000).start();
            }
            this.f12512l0 = new b(120000, 100).start();
            this.f12514n0 = new c(120000, 50).start();
            String string = b8.getString("eqn_notify_alarm_sound", "1");
            boolean z8 = b8.getBoolean("eqn_notify_alarm_nosound_if_mild", true);
            if (this.f12496V >= 3.0d || !z8) {
                z7 = false;
            } else {
                z7 = true;
            }
            int parseInt = Integer.parseInt(string);
            if (parseInt < 4 && !z7) {
                Intent intent = new Intent().setClass(this, PlayerService.class);
                if (parseInt == 1) {
                    intent.setAction("com.finazzi.distquake.action.PLAY2");
                } else if (parseInt == i9) {
                    intent.setAction("com.finazzi.distquake.action.PLAY3");
                } else if (parseInt == i10) {
                    intent.setAction("com.finazzi.distquake.action.PLAY4");
                }
                if (i11 >= 26) {
                    ComponentName unused3 = startForegroundService(intent);
                } else {
                    startService(intent);
                }
            }
            if (b8.getBoolean("eqn_tts_eqn", false)) {
                if (i14 <= 0 || j9 > j8) {
                    if (this.f12501a0.equals("1")) {
                        this.f12492R *= 0.621371192d;
                        str2 = getString(C2030R.string.options_tts_mi);
                    } else {
                        str2 = getString(C2030R.string.options_tts_km);
                    }
                    str = String.format(getString(C2030R.string.options_tts_network_noseconds), new Object[]{Long.toString(Math.round(this.f12492R)), str2});
                } else {
                    str = String.format(getString(C2030R.string.options_tts_network), new Object[]{Long.toString(j9)});
                }
                TextToSpeech textToSpeech = new TextToSpeech(getApplicationContext(), new C1793h(this, str));
                this.f12506f0 = textToSpeech;
                textToSpeech.setOnUtteranceProgressListener(new d());
            }
        }
        if (!this.f12519s0 && H3.f.a(this).canRequestAds()) {
            MobileAds.initialize(this, new C1799i(this));
        }
    }

    public void onDestroy() {
        ((NotificationManager) getSystemService("notification")).cancel(this.f12502b0);
        CountDownTimer countDownTimer = this.f12512l0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = this.f12513m0;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
        }
        CountDownTimer countDownTimer3 = this.f12514n0;
        if (countDownTimer3 != null) {
            countDownTimer3.cancel();
        }
        AdView adView = this.f12518r0;
        if (adView != null) {
            adView.destroy();
        }
        e eVar = this.f12504d0;
        if (eVar != null) {
            unregisterReceiver(eVar);
        }
        f fVar = this.f12505e0;
        if (fVar != null) {
            unregisterReceiver(fVar);
        }
        super.onDestroy();
    }

    public void onMapReady(GoogleMap googleMap) {
        this.f12515o0 = googleMap;
        LatLng latLng = new LatLng(this.f12489O, this.f12490P);
        this.f12515o0.getUiSettings().setMapToolbarEnabled(false);
        this.f12515o0.setMapType(1);
        this.f12515o0.setMapColorScheme(2);
        this.f12515o0.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 6.0f));
        if (androidx.core.content.a.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0) {
            this.f12515o0.setMyLocationEnabled(true);
            LocationServices.getFusedLocationProviderClient((Activity) this).getLastLocation().addOnSuccessListener(new C1805j(this, latLng));
        }
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.anchor(0.5f, 0.5f);
        double d8 = this.f12497W;
        if (d8 < 3.0d) {
            markerOptions.icon(BitmapDescriptorFactory.fromResource(2131231367));
        } else if (d8 < 5.0d) {
            markerOptions.icon(BitmapDescriptorFactory.fromResource(2131231363));
        } else {
            markerOptions.icon(BitmapDescriptorFactory.fromResource(2131231361));
        }
        this.f12507g0 = this.f12515o0.addMarker(markerOptions);
        UiSettings uiSettings = this.f12515o0.getUiSettings();
        uiSettings.setMyLocationButtonEnabled(false);
        uiSettings.setZoomControlsEnabled(false);
        uiSettings.setZoomGesturesEnabled(true);
        uiSettings.setAllGesturesEnabled(true);
        uiSettings.setScrollGesturesEnabled(true);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f12520t0 = false;
        AdView adView = this.f12518r0;
        if (adView != null) {
            adView.pause();
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.f12520t0 = true;
        if (!this.f12519s0) {
            AdView adView = this.f12518r0;
            if (adView != null) {
                adView.resume();
                return;
            }
            return;
        }
        FrameLayout frameLayout = this.f12517q0;
        if (frameLayout != null) {
            frameLayout.removeAllViews();
        }
    }

    public void onSnapshotReady(Bitmap bitmap) {
        boolean z7;
        String str;
        Bitmap bitmap2 = bitmap;
        if (bitmap2 != null) {
            String str2 = getFilesDir().toString() + "/earthquake_share.png";
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), 2131230872);
            Bitmap.Config config = Bitmap.Config.ARGB_8888;
            Bitmap copy = decodeResource.copy(config, true);
            float f8 = getResources().getDisplayMetrics().density;
            String str3 = getString(C2030R.string.app_name) + " App";
            Bitmap copy2 = bitmap2.copy(config, true);
            Canvas canvas = new Canvas(copy2);
            Paint paint = new Paint(1);
            paint.setColor(Color.rgb(255, 0, 0));
            paint.setTextSize((float) ((int) (16.0f * f8)));
            paint.setTypeface(Typeface.DEFAULT_BOLD);
            paint.getTextBounds(str3, 0, str3.length(), new Rect());
            canvas.drawText(str3, ((float) copy.getWidth()) + (f8 * 5.0f), (((float) copy.getHeight()) / 2.0f) + 5.0f + (f8 * 6.0f), paint);
            canvas.drawBitmap(copy, 5.0f, 5.0f, paint);
            paint.setColor(Color.argb(60, 0, 0, 0));
            bitmap2.recycle();
            decodeResource.recycle();
            copy.recycle();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(str2));
                copy2.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
                z7 = true;
            } catch (IOException unused) {
                z7 = false;
            }
            Intent intent = new Intent("android.intent.action.SEND");
            if (z7) {
                Uri h8 = FileProvider.h(getApplicationContext(), getPackageName() + ".fileprovider", new File(str2));
                intent.setType("image/png");
                intent.putExtra("android.intent.extra.STREAM", h8);
                intent.putExtra("android.intent.extra.SUBJECT", getString(C2030R.string.app_name));
                if (this.f12503c0 > 0) {
                    StringBuilder sb = new StringBuilder();
                    Resources resources = getResources();
                    int i8 = this.f12503c0;
                    sb.append(resources.getQuantityString(C2030R.plurals.share_alert1, i8, new Object[]{Integer.valueOf(i8)}));
                    sb.append(". ");
                    sb.append(getString(C2030R.string.share_alert2));
                    str = sb.toString();
                } else {
                    str = getString(C2030R.string.share_alert2);
                }
                intent.putExtra("android.intent.extra.TEXT", str);
                startActivity(Intent.createChooser(intent, getString(C2030R.string.share_share)));
            }
        }
        ((Button) findViewById(C2030R.id.button3)).setEnabled(true);
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        SharedPreferences.Editor edit = getSharedPreferences(MainActivity.class.getSimpleName(), 0).edit();
        edit.putBoolean("alert_activity_showing", true);
        edit.apply();
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        SharedPreferences.Editor edit = getSharedPreferences(MainActivity.class.getSimpleName(), 0).edit();
        edit.putBoolean("alert_activity_showing", false);
        edit.apply();
        super.onStop();
    }
}
