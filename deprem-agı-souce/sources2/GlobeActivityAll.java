package com.finazzi.distquake;

import android.app.ActivityManager;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.location.Location;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.text.Html;
import android.text.Spanned;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.C0768d;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.FileProvider;
import androidx.core.view.C0832r0;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.maps.model.TileOverlay;
import com.google.android.gms.maps.model.TileOverlayOptions;
import com.google.android.gms.maps.model.UrlTileProvider;
import com.google.android.material.button.MaterialButton;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import u2.C1825m1;
import u2.C1843p1;
import u2.C1867t1;
import u2.C1873u1;
import u2.C1879v1;
import u2.C1885w1;
import u2.C1891x1;
import u2.C1897y1;

public class GlobeActivityAll extends C0768d implements GoogleMap.OnMarkerClickListener, GoogleMap.OnCameraIdleListener, GoogleMap.OnCameraMoveListener, GoogleMap.SnapshotReadyCallback, OnMapReadyCallback, GoogleMap.OnInfoWindowClickListener {

    /* renamed from: A0  reason: collision with root package name */
    private int f13140A0;

    /* renamed from: B0  reason: collision with root package name */
    private int f13141B0 = 0;

    /* renamed from: C0  reason: collision with root package name */
    private int f13142C0 = 0;

    /* renamed from: D0  reason: collision with root package name */
    private int f13143D0 = 0;

    /* renamed from: E0  reason: collision with root package name */
    private int f13144E0 = 0;

    /* renamed from: F0  reason: collision with root package name */
    private int f13145F0 = 2;

    /* renamed from: G0  reason: collision with root package name */
    private float f13146G0 = 250.0f;
    /* access modifiers changed from: private */

    /* renamed from: H0  reason: collision with root package name */
    public String f13147H0;
    /* access modifiers changed from: private */

    /* renamed from: I0  reason: collision with root package name */
    public int f13148I0 = 0;
    /* access modifiers changed from: private */

    /* renamed from: J0  reason: collision with root package name */
    public int f13149J0 = 0;

    /* renamed from: K0  reason: collision with root package name */
    private TimeZone f13150K0;

    /* renamed from: L0  reason: collision with root package name */
    private TimeZone f13151L0;

    /* renamed from: M0  reason: collision with root package name */
    private SimpleDateFormat f13152M0;

    /* renamed from: N0  reason: collision with root package name */
    private SimpleDateFormat f13153N0;

    /* renamed from: O  reason: collision with root package name */
    private Bundle f13154O;
    /* access modifiers changed from: private */

    /* renamed from: O0  reason: collision with root package name */
    public boolean f13155O0;

    /* renamed from: P  reason: collision with root package name */
    private AdView f13156P;

    /* renamed from: P0  reason: collision with root package name */
    private boolean f13157P0 = false;
    /* access modifiers changed from: private */

    /* renamed from: Q  reason: collision with root package name */
    public GoogleMap f13158Q;

    /* renamed from: Q0  reason: collision with root package name */
    private boolean f13159Q0 = false;
    /* access modifiers changed from: private */

    /* renamed from: R  reason: collision with root package name */
    public int f13160R;

    /* renamed from: R0  reason: collision with root package name */
    private double f13161R0;
    /* access modifiers changed from: private */

    /* renamed from: S  reason: collision with root package name */
    public int f13162S;

    /* renamed from: S0  reason: collision with root package name */
    private double f13163S0;
    /* access modifiers changed from: private */

    /* renamed from: T  reason: collision with root package name */
    public double[] f13164T;

    /* renamed from: T0  reason: collision with root package name */
    private double f13165T0;
    /* access modifiers changed from: private */

    /* renamed from: U  reason: collision with root package name */
    public double[] f13166U;

    /* renamed from: U0  reason: collision with root package name */
    private Menu f13167U0;
    /* access modifiers changed from: private */

    /* renamed from: V  reason: collision with root package name */
    public double[] f13168V;

    /* renamed from: V0  reason: collision with root package name */
    private TileOverlay f13169V0;
    /* access modifiers changed from: private */

    /* renamed from: W  reason: collision with root package name */
    public String[] f13170W;
    /* access modifiers changed from: private */

    /* renamed from: W0  reason: collision with root package name */
    public Marker f13171W0;
    /* access modifiers changed from: private */

    /* renamed from: X  reason: collision with root package name */
    public double[] f13172X;

    /* renamed from: X0  reason: collision with root package name */
    private Polyline f13173X0;
    /* access modifiers changed from: private */

    /* renamed from: Y  reason: collision with root package name */
    public int[] f13174Y;

    /* renamed from: Y0  reason: collision with root package name */
    private Polyline f13175Y0;

    /* renamed from: Z  reason: collision with root package name */
    private double[] f13176Z;
    /* access modifiers changed from: private */

    /* renamed from: Z0  reason: collision with root package name */
    public int f13177Z0;

    /* renamed from: a0  reason: collision with root package name */
    private int[] f13178a0;

    /* renamed from: a1  reason: collision with root package name */
    private boolean f13179a1 = true;
    /* access modifiers changed from: private */

    /* renamed from: b0  reason: collision with root package name */
    public double[] f13180b0;

    /* renamed from: b1  reason: collision with root package name */
    private boolean f13181b1 = true;

    /* renamed from: c0  reason: collision with root package name */
    private int[] f13182c0;

    /* renamed from: c1  reason: collision with root package name */
    private long f13183c1 = 0;
    /* access modifiers changed from: private */

    /* renamed from: d0  reason: collision with root package name */
    public String[] f13184d0;

    /* renamed from: d1  reason: collision with root package name */
    private boolean f13185d1 = false;

    /* renamed from: e0  reason: collision with root package name */
    private int[] f13186e0;

    /* renamed from: e1  reason: collision with root package name */
    private final String[] f13187e1;

    /* renamed from: f0  reason: collision with root package name */
    private int[] f13188f0;

    /* renamed from: g0  reason: collision with root package name */
    private int[] f13189g0;
    /* access modifiers changed from: private */

    /* renamed from: h0  reason: collision with root package name */
    public int[] f13190h0;
    /* access modifiers changed from: private */

    /* renamed from: i0  reason: collision with root package name */
    public String[] f13191i0;
    /* access modifiers changed from: private */

    /* renamed from: j0  reason: collision with root package name */
    public String[] f13192j0;

    /* renamed from: k0  reason: collision with root package name */
    private Polyline[] f13193k0;

    /* renamed from: l0  reason: collision with root package name */
    private Polyline[] f13194l0;

    /* renamed from: m0  reason: collision with root package name */
    private Marker[] f13195m0;

    /* renamed from: n0  reason: collision with root package name */
    private Circle[] f13196n0;
    /* access modifiers changed from: private */

    /* renamed from: o0  reason: collision with root package name */
    public Circle f13197o0;
    /* access modifiers changed from: private */

    /* renamed from: p0  reason: collision with root package name */
    public Circle f13198p0;
    /* access modifiers changed from: private */

    /* renamed from: q0  reason: collision with root package name */
    public Polyline f13199q0;
    /* access modifiers changed from: private */

    /* renamed from: r0  reason: collision with root package name */
    public Marker[] f13200r0;
    /* access modifiers changed from: private */

    /* renamed from: s0  reason: collision with root package name */
    public Polyline[] f13201s0;
    /* access modifiers changed from: private */

    /* renamed from: t0  reason: collision with root package name */
    public int f13202t0;

    /* renamed from: u0  reason: collision with root package name */
    private float f13203u0;

    /* renamed from: v0  reason: collision with root package name */
    private float f13204v0;
    /* access modifiers changed from: private */

    /* renamed from: w0  reason: collision with root package name */
    public Context f13205w0;
    /* access modifiers changed from: private */

    /* renamed from: x0  reason: collision with root package name */
    public SharedPreferences f13206x0;

    /* renamed from: y0  reason: collision with root package name */
    private SharedPreferences f13207y0;

    /* renamed from: z0  reason: collision with root package name */
    private int f13208z0;

    class a implements AdapterView.OnItemSelectedListener {
        a() {
        }

        public void onItemSelected(AdapterView adapterView, View view, int i8, long j8) {
            if (GlobeActivityAll.this.f13148I0 > 0) {
                GlobeActivityAll.this.k1();
            }
            GlobeActivityAll.t0(GlobeActivityAll.this, 1);
        }

        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    class b implements AdapterView.OnItemSelectedListener {
        b() {
        }

        public void onItemSelected(AdapterView adapterView, View view, int i8, long j8) {
            if (GlobeActivityAll.this.f13149J0 > 0) {
                GlobeActivityAll.this.j1();
            }
            GlobeActivityAll.L0(GlobeActivityAll.this, 1);
        }

        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    class c extends UrlTileProvider {
        c(int i8, int i9) {
            super(i8, i9);
        }

        private boolean a(int i8) {
            boolean z7 = false;
            boolean z8 = i8 >= 0;
            if (i8 <= 9) {
                z7 = true;
            }
            return z8 & z7;
        }

        public synchronized URL getTileUrl(int i8, int i9, int i10) {
            String format = String.format(Locale.getDefault(), "https://htil.earthquakenetwork.it/tile_z%d_c%d_r%d.png", new Object[]{Integer.valueOf(i10), Integer.valueOf(i8), Integer.valueOf(i9)});
            if (!a(i10)) {
                return null;
            }
            try {
                return new URL(format);
            } catch (MalformedURLException e8) {
                throw new AssertionError(e8);
            }
        }
    }

    class d extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ long f13212a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ double f13213b;

        /* renamed from: c  reason: collision with root package name */
        final /* synthetic */ double f13214c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(long j8, long j9, long j10, double d8, double d9) {
            super(j8, j9);
            this.f13212a = j10;
            this.f13213b = d8;
            this.f13214c = d9;
        }

        public void onFinish() {
            if (GlobeActivityAll.this.f13197o0 != null) {
                GlobeActivityAll.this.f13197o0.remove();
                Circle unused = GlobeActivityAll.this.f13197o0 = null;
            }
            if (GlobeActivityAll.this.f13198p0 != null) {
                GlobeActivityAll.this.f13198p0.remove();
                Circle unused2 = GlobeActivityAll.this.f13198p0 = null;
            }
            if (GlobeActivityAll.this.f13199q0 != null) {
                GlobeActivityAll.this.f13199q0.remove();
            }
        }

        public void onTick(long j8) {
            double d8;
            double d9 = (double) j8;
            double d10 = (((double) this.f13212a) - d9) / 1000.0d;
            double d11 = 5.5d * d10 * 1000.0d;
            double d12 = 3.5d * d10 * 1000.0d;
            ((TextView) GlobeActivityAll.this.findViewById(C2030R.id.textView4)).setText(((int) d10) + "s");
            if (GlobeActivityAll.this.f13147H0.equals("1")) {
                String string = GlobeActivityAll.this.getString(C2030R.string.official_S);
                StringBuilder sb = new StringBuilder();
                d8 = d9;
                sb.append(String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf((int) ((d12 / 1000.0d) * 0.621371192d))}));
                sb.append("mi");
                ((TextView) GlobeActivityAll.this.findViewById(C2030R.id.textView5)).setText(String.format(string, new Object[]{sb.toString()}));
                String string2 = GlobeActivityAll.this.getString(C2030R.string.official_P);
                ((TextView) GlobeActivityAll.this.findViewById(C2030R.id.textView6)).setText(String.format(string2, new Object[]{String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf((int) ((d11 / 1000.0d) * 0.621371192d))}) + "mi"}));
            } else {
                d8 = d9;
                String string3 = GlobeActivityAll.this.getString(C2030R.string.official_S);
                ((TextView) GlobeActivityAll.this.findViewById(C2030R.id.textView5)).setText(String.format(string3, new Object[]{String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf((int) (d12 / 1000.0d))}) + "km"}));
                String string4 = GlobeActivityAll.this.getString(C2030R.string.official_P);
                ((TextView) GlobeActivityAll.this.findViewById(C2030R.id.textView6)).setText(String.format(string4, new Object[]{String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf((int) (d11 / 1000.0d))}) + "km"}));
            }
            int i8 = GlobeActivityAll.this.getResources().getConfiguration().uiMode & 48;
            int i9 = (int) ((d8 / ((double) this.f13212a)) * 255.0d);
            if (GlobeActivityAll.this.f13158Q != null) {
                if (GlobeActivityAll.this.f13197o0 == null) {
                    CircleOptions circleOptions = new CircleOptions();
                    circleOptions.center(new LatLng(this.f13213b, this.f13214c));
                    circleOptions.radius(d12);
                    if (GlobeActivityAll.this.f13158Q.getMapType() == 1 && i8 == 16) {
                        circleOptions.strokeColor(-65536);
                        circleOptions.fillColor(Color.argb(20, 255, 0, 0));
                    } else {
                        circleOptions.strokeColor(-1);
                        circleOptions.fillColor(Color.argb(20, 255, 255, 255));
                    }
                    circleOptions.strokeWidth(8.0f);
                    GlobeActivityAll globeActivityAll = GlobeActivityAll.this;
                    Circle unused = globeActivityAll.f13197o0 = globeActivityAll.f13158Q.addCircle(circleOptions);
                } else {
                    GlobeActivityAll.this.f13197o0.setRadius(d12);
                    if (GlobeActivityAll.this.f13158Q.getMapType() == 1 && i8 == 16) {
                        GlobeActivityAll.this.f13197o0.setStrokeColor(Color.argb(i9, 255, 0, 0));
                        if (i9 < 20) {
                            GlobeActivityAll.this.f13197o0.setFillColor(Color.argb(i9, 255, 0, 0));
                        }
                    } else {
                        GlobeActivityAll.this.f13197o0.setStrokeColor(Color.argb(i9, 255, 255, 255));
                        if (i9 < 20) {
                            GlobeActivityAll.this.f13197o0.setFillColor(Color.argb(i9, 255, 255, 255));
                        }
                    }
                }
                if (GlobeActivityAll.this.f13198p0 == null) {
                    CircleOptions circleOptions2 = new CircleOptions();
                    circleOptions2.center(new LatLng(this.f13213b, this.f13214c));
                    circleOptions2.radius(d11);
                    if (GlobeActivityAll.this.f13158Q.getMapType() == 1 && i8 == 16) {
                        circleOptions2.strokeColor(-16776961);
                        circleOptions2.fillColor(Color.argb(20, 0, 0, 255));
                    } else {
                        circleOptions2.strokeColor(Color.rgb(80, 80, 80));
                        circleOptions2.fillColor(Color.argb(20, 80, 80, 80));
                    }
                    circleOptions2.strokeWidth(4.0f);
                    GlobeActivityAll globeActivityAll2 = GlobeActivityAll.this;
                    Circle unused2 = globeActivityAll2.f13198p0 = globeActivityAll2.f13158Q.addCircle(circleOptions2);
                    return;
                }
                GlobeActivityAll.this.f13198p0.setRadius(d11);
                if (GlobeActivityAll.this.f13158Q.getMapType() == 1 && i8 == 16) {
                    GlobeActivityAll.this.f13198p0.setStrokeColor(Color.argb(i9, 0, 0, 255));
                    if (i9 < 20) {
                        GlobeActivityAll.this.f13198p0.setFillColor(Color.argb(i9, 0, 0, 255));
                        return;
                    }
                    return;
                }
                GlobeActivityAll.this.f13198p0.setStrokeColor(Color.argb(i9, 255, 255, 255));
                if (i9 < 20) {
                    GlobeActivityAll.this.f13198p0.setFillColor(Color.argb(i9, 255, 255, 255));
                }
            }
        }
    }

    class e implements GoogleMap.InfoWindowAdapter {

        /* renamed from: a  reason: collision with root package name */
        private final View f13216a;

        e() {
            this.f13216a = GlobeActivityAll.this.getLayoutInflater().inflate(C2030R.layout.marker_dialog, (ViewGroup) null);
        }

        private void a(View view) {
            String str;
            String str2;
            View view2 = view;
            if (GlobeActivityAll.this.f13160R == 2) {
                TextView textView = (TextView) view2.findViewById(C2030R.id.location);
                textView.setTypeface(Typeface.DEFAULT_BOLD);
                if (GlobeActivityAll.this.f13174Y[GlobeActivityAll.this.f13177Z0] == 0) {
                    str = GlobeActivityAll.this.f13168V[GlobeActivityAll.this.f13177Z0] + GlobeActivityAll.this.f13170W[GlobeActivityAll.this.f13177Z0].trim() + " - " + GlobeActivityAll.this.f13184d0[GlobeActivityAll.this.f13177Z0].trim() + " - " + GlobeActivityAll.this.f13191i0[GlobeActivityAll.this.f13177Z0];
                } else {
                    double d8 = GlobeActivityAll.this.f13168V[GlobeActivityAll.this.f13177Z0] - (GlobeActivityAll.this.f13172X[GlobeActivityAll.this.f13177Z0] / 2.0d);
                    DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.getDefault());
                    decimalFormatSymbols.setDecimalSeparator('.');
                    decimalFormatSymbols.setGroupingSeparator(',');
                    DecimalFormat decimalFormat = new DecimalFormat("0.0", decimalFormatSymbols);
                    str = decimalFormat.format(d8) + "-" + decimalFormat.format(GlobeActivityAll.this.f13168V[GlobeActivityAll.this.f13177Z0] + (GlobeActivityAll.this.f13172X[GlobeActivityAll.this.f13177Z0] / 2.0d)) + GlobeActivityAll.this.f13170W[GlobeActivityAll.this.f13177Z0].trim() + " - " + GlobeActivityAll.this.f13184d0[GlobeActivityAll.this.f13177Z0].trim() + " - " + GlobeActivityAll.this.f13191i0[GlobeActivityAll.this.f13177Z0];
                }
                textView.setText(str);
                TextView textView2 = (TextView) view2.findViewById(C2030R.id.depth);
                if (GlobeActivityAll.this.f13174Y[GlobeActivityAll.this.f13177Z0] == 0) {
                    DecimalFormatSymbols decimalFormatSymbols2 = new DecimalFormatSymbols(Locale.getDefault());
                    decimalFormatSymbols2.setDecimalSeparator('.');
                    decimalFormatSymbols2.setGroupingSeparator(',');
                    DecimalFormat decimalFormat2 = new DecimalFormat("0.0", decimalFormatSymbols2);
                    if (GlobeActivityAll.this.f13147H0.equals("1")) {
                        textView2.setText(GlobeActivityAll.this.r1(128207) + " " + String.format(GlobeActivityAll.this.getString(C2030R.string.share_deep_unitonly_imperial), new Object[]{decimalFormat2.format(GlobeActivityAll.this.f13180b0[GlobeActivityAll.this.f13177Z0])}));
                    } else {
                        textView2.setText(GlobeActivityAll.this.r1(128207) + " " + String.format(GlobeActivityAll.this.getString(C2030R.string.share_deep_unitonly), new Object[]{decimalFormat2.format(GlobeActivityAll.this.f13180b0[GlobeActivityAll.this.f13177Z0])}));
                    }
                    textView2.setVisibility(0);
                } else {
                    textView2.setVisibility(8);
                }
                StringBuilder sb = new StringBuilder();
                GlobeActivityAll globeActivityAll = GlobeActivityAll.this;
                sb.append(globeActivityAll.u1(globeActivityAll.f13192j0[GlobeActivityAll.this.f13177Z0]));
                sb.append(" - ");
                GlobeActivityAll globeActivityAll2 = GlobeActivityAll.this;
                sb.append(globeActivityAll2.p1(globeActivityAll2.f13192j0[GlobeActivityAll.this.f13177Z0]));
                ((TextView) view2.findViewById(C2030R.id.date)).setText(sb.toString());
                TextView textView3 = (TextView) view2.findViewById(C2030R.id.distance);
                float[] V02 = GlobeActivityAll.this.s1();
                float f8 = V02[0];
                float f9 = V02[1];
                if (f8 == BitmapDescriptorFactory.HUE_RED || f9 == BitmapDescriptorFactory.HUE_RED) {
                    textView3.setVisibility(8);
                } else {
                    GlobeActivityAll globeActivityAll3 = GlobeActivityAll.this;
                    long round = Math.round(globeActivityAll3.v1((double) f8, (double) f9, globeActivityAll3.f13164T[GlobeActivityAll.this.f13177Z0], GlobeActivityAll.this.f13166U[GlobeActivityAll.this.f13177Z0]));
                    if (GlobeActivityAll.this.f13147H0.equals("1")) {
                        textView3.setText(GlobeActivityAll.this.r1(128208) + " " + String.format(GlobeActivityAll.this.getString(C2030R.string.official_distance_imperial_nodirection), new Object[]{Integer.valueOf((int) ((long) (((double) round) * 0.621371192d)))}));
                    } else {
                        textView3.setText(GlobeActivityAll.this.r1(128208) + " " + String.format(GlobeActivityAll.this.getString(C2030R.string.official_distance_nodirection), new Object[]{Integer.valueOf((int) round)}));
                    }
                    textView3.setVisibility(0);
                }
                TextView textView4 = (TextView) view2.findViewById(C2030R.id.coordinates);
                String str3 = GlobeActivityAll.this.r1(127757) + " ";
                double d9 = GlobeActivityAll.this.f13164T[GlobeActivityAll.this.f13177Z0];
                double floor = (double) ((int) Math.floor(d9));
                double d10 = (d9 - floor) * 60.0d;
                String num = Integer.toString((int) floor);
                String num2 = Integer.toString((int) Math.floor(d10));
                String num3 = Integer.toString((int) Math.round((d10 - Math.floor(d10)) * 60.0d));
                if (num2.length() == 1) {
                    num2 = "0" + num2;
                }
                if (num3.length() == 1) {
                    num3 = "0" + num3;
                }
                String str4 = str3 + num + "°" + num2 + "'" + num3 + "'' lat ";
                double d11 = GlobeActivityAll.this.f13166U[GlobeActivityAll.this.f13177Z0];
                double floor2 = (double) ((int) Math.floor(d11));
                double d12 = (d11 - floor2) * 60.0d;
                String num4 = Integer.toString((int) floor2);
                String num5 = Integer.toString((int) Math.floor(d12));
                String num6 = Integer.toString((int) Math.round((d12 - Math.floor(d12)) * 60.0d));
                if (num5.length() == 1) {
                    num5 = "0" + num5;
                }
                if (num6.length() == 1) {
                    num6 = "0" + num6;
                }
                textView4.setText(str4 + num4 + "°" + num5 + "'" + num6 + "'' lon");
                if (GlobeActivityAll.this.getString(C2030R.string.current_language).equals("ar")) {
                    textView4.setTextDirection(4);
                }
                TextView textView5 = (TextView) view2.findViewById(C2030R.id.population);
                if (GlobeActivityAll.this.getString(C2030R.string.current_language).equals("ar")) {
                    textView5.setTextDirection(4);
                }
                double pow = Math.pow(10.0d, ((double) GlobeActivityAll.this.f13190h0[GlobeActivityAll.this.f13177Z0]) / 1000.0d);
                if (pow > 999999.0d) {
                    str2 = (((double) Math.round(pow / 100000.0d)) / 10.0d) + GlobeActivityAll.this.getString(C2030R.string.short_mega);
                } else if (pow > 999.0d) {
                    str2 = (((double) Math.round(pow / 100.0d)) / 10.0d) + GlobeActivityAll.this.getString(C2030R.string.short_kilo);
                } else {
                    str2 = Integer.toString((int) Math.round(pow));
                }
                if (GlobeActivityAll.this.f13190h0[GlobeActivityAll.this.f13177Z0] > 0) {
                    if (GlobeActivityAll.this.f13147H0.equals("1")) {
                        textView5.setText(GlobeActivityAll.this.r1(128101) + " " + String.format(GlobeActivityAll.this.getString(C2030R.string.share_radius100_imperial), new Object[]{str2}));
                        return;
                    }
                    textView5.setText(GlobeActivityAll.this.r1(128101) + " " + String.format(GlobeActivityAll.this.getString(C2030R.string.share_radius100), new Object[]{str2}));
                } else if (GlobeActivityAll.this.f13147H0.equals("1")) {
                    textView5.setText(GlobeActivityAll.this.r1(128101) + " " + String.format(GlobeActivityAll.this.getString(C2030R.string.share_radius100_imperial), new Object[]{"0"}));
                } else {
                    textView5.setText(GlobeActivityAll.this.r1(128101) + " " + String.format(GlobeActivityAll.this.getString(C2030R.string.share_radius100), new Object[]{"0"}));
                }
            }
        }

        public View getInfoContents(Marker marker) {
            return null;
        }

        public View getInfoWindow(Marker marker) {
            if (marker.equals(GlobeActivityAll.this.f13171W0)) {
                return null;
            }
            a(this.f13216a);
            return this.f13216a;
        }
    }

    private class f extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private String f13218a;

        /* renamed from: b  reason: collision with root package name */
        private final int f13219b;

        /* renamed from: c  reason: collision with root package name */
        private final LatLng f13220c;

        /* synthetic */ f(GlobeActivityAll globeActivityAll, int i8, double d8, double d9, a aVar) {
            this(i8, d8, d9);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(5:11|10|15|16|(0)(0)) */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x00bb, code lost:
            r8 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x00c4, code lost:
            r2.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x00cc, code lost:
            r2.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x00bd */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x00c4  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00cc  */
        /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r8) {
            /*
                r7 = this;
                r8 = 0
                r0 = 1
                java.util.HashMap r1 = new java.util.HashMap
                r1.<init>()
                int r2 = r7.f13219b
                java.lang.String r2 = java.lang.Integer.toString(r2)
                java.lang.String r3 = "code"
                r1.put(r3, r2)
                java.lang.String r1 = u2.C1737L.a(r1)
                r2 = 0
                com.finazzi.distquake.GlobeActivityAll r3 = com.finazzi.distquake.GlobeActivityAll.this     // Catch:{ IOException -> 0x00bd }
                android.content.SharedPreferences r3 = r3.f13206x0     // Catch:{ IOException -> 0x00bd }
                java.lang.String r4 = "sub_domain"
                com.finazzi.distquake.GlobeActivityAll r5 = com.finazzi.distquake.GlobeActivityAll.this     // Catch:{ IOException -> 0x00bd }
                r6 = 2131887099(0x7f1203fb, float:1.9408796E38)
                java.lang.String r5 = r5.getString(r6)     // Catch:{ IOException -> 0x00bd }
                java.lang.String r3 = r3.getString(r4, r5)     // Catch:{ IOException -> 0x00bd }
                com.finazzi.distquake.GlobeActivityAll r4 = com.finazzi.distquake.GlobeActivityAll.this     // Catch:{ IOException -> 0x00bd }
                r5 = 2131887098(0x7f1203fa, float:1.9408793E38)
                java.lang.String r4 = r4.getString(r5)     // Catch:{ IOException -> 0x00bd }
                java.lang.Object[] r5 = new java.lang.Object[r0]     // Catch:{ IOException -> 0x00bd }
                r5[r8] = r3     // Catch:{ IOException -> 0x00bd }
                java.lang.String r3 = java.lang.String.format(r4, r5)     // Catch:{ IOException -> 0x00bd }
                java.net.URL r4 = new java.net.URL     // Catch:{ IOException -> 0x00bd }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00bd }
                r5.<init>()     // Catch:{ IOException -> 0x00bd }
                r5.append(r3)     // Catch:{ IOException -> 0x00bd }
                java.lang.String r3 = "distquake_download_pastquake_detail2.php?"
                r5.append(r3)     // Catch:{ IOException -> 0x00bd }
                r5.append(r1)     // Catch:{ IOException -> 0x00bd }
                java.lang.String r1 = r5.toString()     // Catch:{ IOException -> 0x00bd }
                r4.<init>(r1)     // Catch:{ IOException -> 0x00bd }
                java.net.URLConnection r1 = r4.openConnection()     // Catch:{ IOException -> 0x00bd }
                java.lang.Object r1 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r1)     // Catch:{ IOException -> 0x00bd }
                java.net.URLConnection r1 = (java.net.URLConnection) r1     // Catch:{ IOException -> 0x00bd }
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ IOException -> 0x00bd }
                r1.setDoOutput(r8)     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                r2 = 10000(0x2710, float:1.4013E-41)
                r1.setConnectTimeout(r2)     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                r1.setReadTimeout(r2)     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                java.lang.String r2 = "Content-Type"
                java.lang.String r3 = "application/x-www-form-urlencoded;charset=utf-8"
                r1.setRequestProperty(r2, r3)     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                java.lang.String r2 = "GET"
                r1.setRequestMethod(r2)     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                java.io.InputStream r3 = r1.getInputStream()     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                r2.<init>(r3)     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                r4.<init>(r2, r5)     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                r3.<init>(r4)     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                r4.<init>()     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
            L_0x0093:
                java.lang.String r5 = r3.readLine()     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                r7.f13218a = r5     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                if (r5 == 0) goto L_0x00a9
                r4.append(r5)     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                java.lang.String r5 = "\n"
                r4.append(r5)     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                goto L_0x0093
            L_0x00a4:
                r8 = move-exception
                r2 = r1
                goto L_0x00ca
            L_0x00a7:
                r2 = r1
                goto L_0x00bd
            L_0x00a9:
                java.lang.String r3 = r4.toString()     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                r7.f13218a = r3     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                r2.close()     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                com.finazzi.distquake.GlobeActivityAll r2 = com.finazzi.distquake.GlobeActivityAll.this     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                int unused = r2.f13162S = r8     // Catch:{ IOException -> 0x00a7, all -> 0x00a4 }
                r1.disconnect()
                goto L_0x00c7
            L_0x00bb:
                r8 = move-exception
                goto L_0x00ca
            L_0x00bd:
                com.finazzi.distquake.GlobeActivityAll r8 = com.finazzi.distquake.GlobeActivityAll.this     // Catch:{ all -> 0x00bb }
                int unused = r8.f13162S = r0     // Catch:{ all -> 0x00bb }
                if (r2 == 0) goto L_0x00c7
                r2.disconnect()
            L_0x00c7:
                java.lang.String r8 = "COMPLETE!"
                return r8
            L_0x00ca:
                if (r2 == 0) goto L_0x00cf
                r2.disconnect()
            L_0x00cf:
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.GlobeActivityAll.f.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            if (GlobeActivityAll.this.f13162S == 0) {
                if (GlobeActivityAll.this.f13200r0 != null) {
                    for (Marker marker : GlobeActivityAll.this.f13200r0) {
                        if (marker != null) {
                            marker.remove();
                        }
                    }
                }
                if (GlobeActivityAll.this.f13201s0 != null) {
                    for (Polyline polyline : GlobeActivityAll.this.f13201s0) {
                        if (polyline != null) {
                            polyline.remove();
                        }
                    }
                }
                try {
                    JSONArray jSONArray = new JSONArray(this.f13218a);
                    int length = jSONArray.length();
                    double[] dArr = new double[length];
                    double[] dArr2 = new double[length];
                    Marker[] unused = GlobeActivityAll.this.f13200r0 = new Marker[length];
                    Polyline[] unused2 = GlobeActivityAll.this.f13201s0 = new Polyline[length];
                    double d8 = 0.0d;
                    double d9 = 0.0d;
                    for (int i8 = 0; i8 < length; i8++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i8);
                        dArr[i8] = Double.parseDouble(jSONObject.getString("la"));
                        double parseDouble = Double.parseDouble(jSONObject.getString("lo"));
                        dArr2[i8] = parseDouble;
                        d8 += dArr[i8];
                        d9 += parseDouble;
                        LatLng latLng = new LatLng(dArr[i8], dArr2[i8]);
                        MarkerOptions markerOptions = new MarkerOptions();
                        markerOptions.position(latLng);
                        markerOptions.anchor(0.5f, 0.5f);
                        markerOptions.icon(BitmapDescriptorFactory.fromResource(2131231360));
                        GlobeActivityAll.this.f13200r0[i8] = GlobeActivityAll.this.f13158Q.addMarker(markerOptions);
                        PolylineOptions polylineOptions = new PolylineOptions();
                        polylineOptions.color(-65281);
                        polylineOptions.geodesic(false);
                        polylineOptions.width(1.0f);
                        polylineOptions.add(this.f13220c);
                        polylineOptions.add(latLng);
                        GlobeActivityAll.this.f13201s0[i8] = GlobeActivityAll.this.f13158Q.addPolyline(polylineOptions);
                    }
                    if (length > 0) {
                        double d10 = (double) length;
                        GlobeActivityAll.this.f13158Q.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(d8 / d10, d9 / d10), 10.0f));
                        GlobeActivityAll.this.f13158Q.setMaxZoomPreference(11.0f);
                        ((TextView) GlobeActivityAll.this.findViewById(C2030R.id.textView13)).setVisibility(0);
                    }
                } catch (JSONException unused3) {
                    Toast makeText = Toast.makeText(GlobeActivityAll.this.f13205w0.getApplicationContext(), GlobeActivityAll.this.f13205w0.getString(C2030R.string.quakedetail_nodata), 0);
                    makeText.setGravity(17, 0, 0);
                    makeText.show();
                }
            } else {
                Toast makeText2 = Toast.makeText(GlobeActivityAll.this.f13205w0.getApplicationContext(), GlobeActivityAll.this.f13205w0.getString(C2030R.string.manual_error), 0);
                makeText2.setGravity(17, 0, 0);
                makeText2.show();
            }
        }

        private f(int i8, double d8, double d9) {
            this.f13219b = i8;
            this.f13220c = new LatLng(d8, d9);
        }
    }

    private class g extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private final double f13222a;

        /* renamed from: b  reason: collision with root package name */
        private final double f13223b;

        /* renamed from: c  reason: collision with root package name */
        private final double f13224c;

        /* renamed from: d  reason: collision with root package name */
        private final boolean f13225d;

        /* renamed from: e  reason: collision with root package name */
        private final boolean f13226e;

        /* renamed from: f  reason: collision with root package name */
        private String f13227f;

        /* synthetic */ g(GlobeActivityAll globeActivityAll, double d8, double d9, double d10, boolean z7, boolean z8, a aVar) {
            this(d8, d9, d10, z7, z8);
        }

        public static /* synthetic */ void a(DialogInterface dialogInterface, int i8) {
        }

        public static /* synthetic */ void b(g gVar, DialogInterface dialogInterface, int i8) {
            gVar.getClass();
            Intent intent = new Intent().setClass(GlobeActivityAll.this, InAppActivity.class);
            intent.putExtra("show_map_button", false);
            GlobeActivityAll.this.startActivity(intent);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x00fd  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0105  */
        /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
        /* renamed from: c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r7) {
            /*
                r6 = this;
                java.util.HashMap r7 = new java.util.HashMap
                r7.<init>()
                double r0 = r6.f13222a
                java.lang.String r0 = java.lang.Double.toString(r0)
                java.lang.String r1 = "lat"
                r7.put(r1, r0)
                double r0 = r6.f13223b
                java.lang.String r0 = java.lang.Double.toString(r0)
                java.lang.String r1 = "lon"
                r7.put(r1, r0)
                double r0 = r6.f13224c
                java.lang.String r0 = java.lang.Double.toString(r0)
                java.lang.String r1 = "dis"
                r7.put(r1, r0)
                boolean r0 = r6.f13225d
                java.lang.String r1 = "0"
                java.lang.String r2 = "1"
                java.lang.String r3 = "top10k"
                if (r0 == 0) goto L_0x0034
                r7.put(r3, r2)
                goto L_0x0037
            L_0x0034:
                r7.put(r3, r1)
            L_0x0037:
                boolean r0 = r6.f13226e
                java.lang.String r3 = "top100k"
                if (r0 == 0) goto L_0x0041
                r7.put(r3, r2)
                goto L_0x0044
            L_0x0041:
                r7.put(r3, r1)
            L_0x0044:
                java.lang.String r7 = u2.C1737L.a(r7)
                r0 = 1
                r1 = 0
                java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x00f2 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00f2 }
                r3.<init>()     // Catch:{ IOException -> 0x00f2 }
                com.finazzi.distquake.GlobeActivityAll r4 = com.finazzi.distquake.GlobeActivityAll.this     // Catch:{ IOException -> 0x00f2 }
                r5 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r4 = r4.getString(r5)     // Catch:{ IOException -> 0x00f2 }
                r3.append(r4)     // Catch:{ IOException -> 0x00f2 }
                java.lang.String r4 = "distquake_download_alertposition.php"
                r3.append(r4)     // Catch:{ IOException -> 0x00f2 }
                java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x00f2 }
                r2.<init>(r3)     // Catch:{ IOException -> 0x00f2 }
                java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x00f2 }
                java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch:{ IOException -> 0x00f2 }
                java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch:{ IOException -> 0x00f2 }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x00f2 }
                r2.setDoOutput(r0)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                r1 = 10000(0x2710, float:1.4013E-41)
                r2.setConnectTimeout(r1)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                r2.setReadTimeout(r1)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                java.lang.String r1 = "Content-Type"
                java.lang.String r3 = "application/x-www-form-urlencoded;charset=utf-8"
                r2.setRequestProperty(r1, r3)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                java.lang.String r1 = "POST"
                r2.setRequestMethod(r1)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                byte[] r1 = r7.getBytes()     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                int r1 = r1.length     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                r2.setFixedLengthStreamingMode(r1)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                java.io.OutputStream r3 = r2.getOutputStream()     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                r1.print(r7)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                r1.close()     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                java.io.InputStream r1 = r2.getInputStream()     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                r7.<init>(r1)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                r3.<init>(r7, r4)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                r3.<init>()     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            L_0x00bd:
                java.lang.String r4 = r1.readLine()     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                r6.f13227f = r4     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                if (r4 == 0) goto L_0x00ce
                r3.append(r4)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                goto L_0x00bd
            L_0x00c9:
                r7 = move-exception
                r1 = r2
                goto L_0x0103
            L_0x00cc:
                r1 = r2
                goto L_0x00f2
            L_0x00ce:
                r7.close()     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                java.lang.String r7 = r3.toString()     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                r6.f13227f = r7     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                java.lang.String r1 = "wait"
                boolean r7 = r7.equalsIgnoreCase(r1)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                if (r7 == 0) goto L_0x00e6
                com.finazzi.distquake.GlobeActivityAll r7 = com.finazzi.distquake.GlobeActivityAll.this     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                r1 = 2
                int unused = r7.f13202t0 = r1     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                goto L_0x00ec
            L_0x00e6:
                com.finazzi.distquake.GlobeActivityAll r7 = com.finazzi.distquake.GlobeActivityAll.this     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                r1 = 0
                int unused = r7.f13202t0 = r1     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            L_0x00ec:
                r2.disconnect()
                goto L_0x0100
            L_0x00f0:
                r7 = move-exception
                goto L_0x0103
            L_0x00f2:
                java.lang.String r7 = "nok"
                r6.f13227f = r7     // Catch:{ all -> 0x00f0 }
                com.finazzi.distquake.GlobeActivityAll r7 = com.finazzi.distquake.GlobeActivityAll.this     // Catch:{ all -> 0x00f0 }
                int unused = r7.f13202t0 = r0     // Catch:{ all -> 0x00f0 }
                if (r1 == 0) goto L_0x0100
                r1.disconnect()
            L_0x0100:
                java.lang.String r7 = "COMPLETE!"
                return r7
            L_0x0103:
                if (r1 == 0) goto L_0x0108
                r1.disconnect()
            L_0x0108:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.GlobeActivityAll.g.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void onPostExecute(String str) {
            Toast toast;
            int i8;
            int i9;
            Spanned spanned;
            super.onPostExecute(str);
            if (!GlobeActivityAll.this.f13155O0) {
                return;
            }
            if (GlobeActivityAll.this.f13202t0 == 0) {
                String[] split = this.f13227f.split("#");
                if (split.length > 1) {
                    i8 = Integer.parseInt(split[0]);
                    i9 = Integer.parseInt(split[1]);
                } else {
                    i8 = Integer.parseInt(split[0]);
                    i9 = 0;
                }
                long round = Math.round((((double) i8) / 1000.0d) * 0.15d);
                long round2 = Math.round((this.f13224c / 4.5d) - 3.0d);
                long j8 = round2 - round;
                if (this.f13225d) {
                    if (i8 == 0) {
                        spanned = Html.fromHtml(String.format(GlobeActivityAll.this.getString(C2030R.string.globe_simulation_message6), new Object[]{"<font color=#ff0000>TOP 10K</font>", Long.toString(round2)}));
                    } else {
                        spanned = Html.fromHtml(String.format(GlobeActivityAll.this.getString(C2030R.string.globe_simulation_message4), new Object[]{"<font color=#ff0000>TOP 10K</font>", Long.toString(round2), "<font color=#ff0000>" + i8 + "</font>"}));
                    }
                } else if (this.f13226e) {
                    spanned = Html.fromHtml(String.format(GlobeActivityAll.this.getString(C2030R.string.globe_simulation_message5), new Object[]{"TOP 100K", Long.toString(round2), "<font color=#ff0000>" + i8 + "</font>", "<font color=#ff0000>TOP 10K</font>"}));
                } else if (((double) (((float) round2) / ((float) j8))) < 1.4d) {
                    spanned = Html.fromHtml(String.format(GlobeActivityAll.this.getString(C2030R.string.globe_simulation_message3), new Object[]{"<font color=#008000>" + round2 + "</font>", "<font color=#ff0000>" + i8 + "</font>", "<font color=#008000>" + i9 + "</font>"}));
                } else if (j8 > 0) {
                    spanned = Html.fromHtml(String.format(GlobeActivityAll.this.getString(C2030R.string.globe_simulation_message1), new Object[]{"<font color=#008000>" + round2 + "</font>", "<font color=#ff0000>" + i8 + "</font>", "<font color=#ff0000>" + j8 + "</font>", "<font color=#008000>" + i9 + "</font>"}));
                } else {
                    spanned = Html.fromHtml(String.format(GlobeActivityAll.this.getString(C2030R.string.globe_simulation_message2), new Object[]{"<font color=#008000>" + round2 + "</font>", "<font color=#ff0000>" + i8 + "</font>", "<font color=#ff0000>" + (j8 * -1) + "</font>", "<font color=#008000>" + i9 + "</font>"}));
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(GlobeActivityAll.this);
                builder.setMessage(spanned);
                builder.setCancelable(false);
                builder.setNegativeButton(GlobeActivityAll.this.getString(C2030R.string.manual_understood), new Y());
                builder.setPositiveButton(GlobeActivityAll.this.getString(C2030R.string.globe_simulation_priority), new Z(this));
                AlertDialog create = builder.create();
                create.show();
                ((TextView) create.findViewById(16908299)).setTextSize(18.0f);
                SharedPreferences.Editor edit = GlobeActivityAll.this.f13206x0.edit();
                edit.putLong("last_alerttime_check", System.currentTimeMillis());
                edit.apply();
                return;
            }
            if (GlobeActivityAll.this.f13202t0 == 2) {
                toast = Toast.makeText(GlobeActivityAll.this.f13205w0.getApplicationContext(), GlobeActivityAll.this.f13205w0.getString(C2030R.string.globe_simulation_noservice), 1);
            } else {
                toast = Toast.makeText(GlobeActivityAll.this.f13205w0.getApplicationContext(), GlobeActivityAll.this.f13205w0.getString(C2030R.string.manual_error), 0);
            }
            toast.setGravity(17, 0, 0);
            toast.show();
        }

        private g(double d8, double d9, double d10, boolean z7, boolean z8) {
            this.f13222a = d8;
            this.f13223b = d9;
            this.f13224c = d10;
            this.f13225d = z7;
            this.f13226e = z8;
        }
    }

    public GlobeActivityAll() {
        String[] strArr = new String[UserVerificationMethods.USER_VERIFY_HANDPRINT];
        strArr[0] = "#3E26A8";
        strArr[1] = "#3E27AC";
        strArr[2] = "#3F28AF";
        strArr[3] = "#3F29B2";
        strArr[4] = "#402AB4";
        strArr[5] = "#402BB7";
        strArr[6] = "#412CBA";
        strArr[7] = "#412DBD";
        strArr[8] = "#422EBF";
        strArr[9] = "#422FC2";
        strArr[10] = "#4330C5";
        strArr[11] = "#4331C8";
        strArr[12] = "#4332CA";
        strArr[13] = "#4433CD";
        strArr[14] = "#4434D0";
        strArr[15] = "#4535D2";
        strArr[16] = "#4537D5";
        strArr[17] = "#4538D7";
        strArr[18] = "#4639D9";
        strArr[19] = "#463ADC";
        strArr[20] = "#463BDE";
        strArr[21] = "#463DE0";
        strArr[22] = "#473EE1";
        strArr[23] = "#473FE3";
        strArr[24] = "#4741E5";
        strArr[25] = "#4742E6";
        strArr[26] = "#4744E8";
        strArr[27] = "#4745E9";
        strArr[28] = "#4746EB";
        strArr[29] = "#4848EC";
        strArr[30] = "#4849ED";
        strArr[31] = "#484BEE";
        strArr[32] = "#484CF0";
        strArr[33] = "#484EF1";
        strArr[34] = "#484FF2";
        strArr[35] = "#4850F3";
        strArr[36] = "#4852F4";
        strArr[37] = "#4853F5";
        strArr[38] = "#4854F6";
        strArr[39] = "#4756F7";
        strArr[40] = "#4757F7";
        strArr[41] = "#4759F8";
        strArr[42] = "#475AF9";
        strArr[43] = "#475BFA";
        strArr[44] = "#475DFA";
        strArr[45] = "#465EFB";
        strArr[46] = "#4660FB";
        strArr[47] = "#4661FC";
        strArr[48] = "#4562FC";
        strArr[49] = "#4564FD";
        strArr[50] = "#4465FD";
        strArr[51] = "#4367FD";
        strArr[52] = "#4368FE";
        strArr[53] = "#426AFE";
        strArr[54] = "#416BFE";
        strArr[55] = "#406DFE";
        strArr[56] = "#3F6EFF";
        strArr[57] = "#3E70FF";
        strArr[58] = "#3C71FF";
        strArr[59] = "#3B73FF";
        strArr[60] = "#3974FF";
        strArr[61] = "#3876FE";
        strArr[62] = "#3677FE";
        strArr[63] = "#3579FD";
        strArr[64] = "#337AFD";
        strArr[65] = "#327CFC";
        strArr[66] = "#317DFC";
        strArr[67] = "#307FFB";
        strArr[68] = "#2F80FA";
        strArr[69] = "#2F82FA";
        strArr[70] = "#2E83F9";
        strArr[71] = "#2E84F8";
        strArr[72] = "#2E86F8";
        strArr[73] = "#2E87F7";
        strArr[74] = "#2D88F6";
        strArr[75] = "#2D8AF5";
        strArr[76] = "#2D8BF4";
        strArr[77] = "#2D8CF3";
        strArr[78] = "#2D8EF2";
        strArr[79] = "#2C8FF1";
        strArr[80] = "#2C90F0";
        strArr[81] = "#2B91EF";
        strArr[82] = "#2A93EE";
        strArr[83] = "#2994ED";
        strArr[84] = "#2895EC";
        strArr[85] = "#2797EB";
        strArr[86] = "#2798EA";
        strArr[87] = "#2699E9";
        strArr[88] = "#269AE8";
        strArr[89] = "#259BE8";
        strArr[90] = "#259CE7";
        strArr[91] = "#249EE6";
        strArr[92] = "#249FE5";
        strArr[93] = "#23A0E5";
        strArr[94] = "#23A1E4";
        strArr[95] = "#22A2E4";
        strArr[96] = "#21A3E3";
        strArr[97] = "#20A5E3";
        strArr[98] = "#1FA6E2";
        strArr[99] = "#1EA7E1";
        strArr[100] = "#1DA8E1";
        strArr[101] = "#1DA9E0";
        strArr[102] = "#1CAADF";
        strArr[103] = "#1BABDE";
        strArr[104] = "#1AACDD";
        strArr[105] = "#19ADDC";
        strArr[106] = "#17AEDA";
        strArr[107] = "#16AFD9";
        strArr[108] = "#14B0D8";
        strArr[109] = "#12B1D6";
        strArr[110] = "#10B2D5";
        strArr[111] = "#0EB3D4";
        strArr[112] = "#0BB3D2";
        strArr[113] = "#08B4D1";
        strArr[114] = "#06B5CF";
        strArr[115] = "#04B6CE";
        strArr[116] = "#02B7CC";
        strArr[117] = "#01B7CA";
        strArr[118] = "#00B8C9";
        strArr[119] = "#00B9C7";
        strArr[120] = "#00BAC6";
        strArr[121] = "#01BAC4";
        strArr[122] = "#02BBC2";
        strArr[123] = "#04BBC1";
        strArr[124] = "#06BCBF";
        strArr[125] = "#09BDBD";
        strArr[126] = "#0DBDBC";
        strArr[127] = "#10BEBA";
        strArr[128] = "#14BEB8";
        strArr[129] = "#17BFB6";
        strArr[130] = "#1AC0B5";
        strArr[131] = "#1DC0B3";
        strArr[132] = "#20C1B1";
        strArr[133] = "#23C1AF";
        strArr[134] = "#25C2AE";
        strArr[135] = "#27C2AC";
        strArr[136] = "#29C3AA";
        strArr[137] = "#2BC3A8";
        strArr[138] = "#2CC4A6";
        strArr[139] = "#2EC4A5";
        strArr[140] = "#2FC5A3";
        strArr[141] = "#31C5A1";
        strArr[142] = "#32C69F";
        strArr[143] = "#33C79D";
        strArr[144] = "#35C79B";
        strArr[145] = "#36C899";
        strArr[146] = "#38C896";
        strArr[147] = "#39C994";
        strArr[148] = "#3BC992";
        strArr[149] = "#3DCA90";
        strArr[150] = "#40CA8D";
        strArr[151] = "#42CA8B";
        strArr[152] = "#45CB89";
        strArr[153] = "#48CB86";
        strArr[154] = "#4BCB84";
        strArr[155] = "#4ECC81";
        strArr[156] = "#51CC7F";
        strArr[157] = "#54CC7C";
        strArr[158] = "#57CC7A";
        strArr[159] = "#5ACC77";
        strArr[160] = "#5ECD74";
        strArr[161] = "#61CD72";
        strArr[162] = "#64CD6F";
        strArr[163] = "#67CD6C";
        strArr[164] = "#6BCD69";
        strArr[165] = "#6ECD66";
        strArr[166] = "#72CD64";
        strArr[167] = "#76CC61";
        strArr[168] = "#79CC5E";
        strArr[169] = "#7DCC5B";
        strArr[170] = "#81CC59";
        strArr[171] = "#84CC56";
        strArr[172] = "#88CB53";
        strArr[173] = "#8BCB51";
        strArr[174] = "#8FCB4E";
        strArr[175] = "#93CA4B";
        strArr[176] = "#96CA48";
        strArr[177] = "#9AC946";
        strArr[178] = "#9DC943";
        strArr[179] = "#A1C840";
        strArr[180] = "#A4C83E";
        strArr[181] = "#A7C73B";
        strArr[182] = "#ABC739";
        strArr[183] = "#AEC637";
        strArr[184] = "#B2C635";
        strArr[185] = "#B5C533";
        strArr[186] = "#B8C431";
        strArr[187] = "#BBC42F";
        strArr[188] = "#BEC32D";
        strArr[189] = "#C2C32C";
        strArr[190] = "#C5C22A";
        strArr[191] = "#C8C129";
        strArr[192] = "#CBC128";
        strArr[193] = "#CEC027";
        strArr[194] = "#D0BF27";
        strArr[195] = "#D3BF27";
        strArr[196] = "#D6BE27";
        strArr[197] = "#D9BE28";
        strArr[198] = "#DBBD28";
        strArr[199] = "#DEBC29";
        strArr[200] = "#E1BC2A";
        strArr[201] = "#E3BC2B";
        strArr[202] = "#E6BB2D";
        strArr[203] = "#E8BB2E";
        strArr[204] = "#EABA30";
        strArr[205] = "#ECBA32";
        strArr[206] = "#EFBA35";
        strArr[207] = "#F1BA37";
        strArr[208] = "#F3BA39";
        strArr[209] = "#F5BA3B";
        strArr[210] = "#F7BA3D";
        strArr[211] = "#F9BA3E";
        strArr[212] = "#FBBB3E";
        strArr[213] = "#FCBC3E";
        strArr[214] = "#FEBD3D";
        strArr[215] = "#FEBE3C";
        strArr[216] = "#FEC03B";
        strArr[217] = "#FEC13A";
        strArr[218] = "#FEC239";
        strArr[219] = "#FEC438";
        strArr[220] = "#FEC537";
        strArr[221] = "#FEC735";
        strArr[222] = "#FEC834";
        strArr[223] = "#FECA33";
        strArr[224] = "#FDCB32";
        strArr[225] = "#FDCD31";
        strArr[226] = "#FDCE31";
        strArr[227] = "#FCD030";
        strArr[228] = "#FBD22F";
        strArr[229] = "#FBD32E";
        strArr[230] = "#FAD52E";
        strArr[231] = "#F9D62D";
        strArr[232] = "#F9D82C";
        strArr[233] = "#F8D92B";
        strArr[234] = "#F7DB2A";
        strArr[235] = "#F7DD2A";
        strArr[236] = "#F6DE29";
        strArr[237] = "#F6E028";
        strArr[238] = "#F5E128";
        strArr[239] = "#F5E327";
        strArr[240] = "#F5E526";
        strArr[241] = "#F5E626";
        strArr[242] = "#F5E825";
        strArr[243] = "#F5E924";
        strArr[244] = "#F5EB23";
        strArr[245] = "#F5EC22";
        strArr[246] = "#F5EE21";
        strArr[247] = "#F6EF20";
        strArr[248] = "#F6F11F";
        strArr[249] = "#F6F21E";
        strArr[250] = "#F7F41C";
        strArr[251] = "#F7F51B";
        strArr[252] = "#F8F71A";
        strArr[253] = "#F8F818";
        strArr[254] = "#F9F916";
        strArr[255] = "#F9FB15";
        this.f13187e1 = strArr;
    }

    private void A1() {
        Polyline[] polylineArr;
        if (this.f13158Q != null && (polylineArr = this.f13193k0) != null) {
            for (Polyline polyline : polylineArr) {
                if (polyline != null) {
                    polyline.remove();
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:406:0x1350, code lost:
        r4 = (float) (((double) r4) / 2.0d);
        r9.drawCircle((float) (((double) r8.getWidth()) / 2.0d), (float) (((double) r8.getHeight()) / 2.0d), r4, r10);
        r10.setStyle(android.graphics.Paint.Style.STROKE);
        r10.setColor(-16777216);
        r10.setStrokeWidth(3.0f);
        r9.drawCircle((float) (((double) r8.getWidth()) / 2.0d), (float) (((double) r8.getHeight()) / 2.0d), r4, r10);
        r4 = new com.google.android.gms.maps.model.LatLng(r1.f13164T[r2], r1.f13166U[r2]);
        r9 = new com.google.android.gms.maps.model.MarkerOptions();
        r9.title(r6);
        r9.snippet(r7);
        r9.anchor(0.5f, 0.5f);
        r9.position(r4);
        r9.zIndex((float) r1.f13178a0[r2]);
        r9.icon(com.google.android.gms.maps.model.BitmapDescriptorFactory.fromBitmap(r8));
        r8.recycle();
        r1.f13195m0[r2] = r1.f13158Q.addMarker(r9);
     */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x05db  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void B1() {
        /*
            r69 = this;
            r1 = r69
            java.lang.String r12 = "intensity"
            java.lang.String r15 = "100000"
            r6 = 5
            r16 = 4617878467915022336(0x4016000000000000, double:5.5)
            r18 = 4616752568008179712(0x4012000000000000, double:4.5)
            r20 = 4615063718147915776(0x400c000000000000, double:3.5)
            r0 = 4
            r22 = -4587690276662804480(0xc055400000000000, double:-85.0)
            r2 = 12
            com.google.android.gms.maps.GoogleMap r3 = r1.f13158Q
            r3.setOnMarkerClickListener(r1)
            com.google.android.gms.maps.GoogleMap r3 = r1.f13158Q
            r3.setOnCameraIdleListener(r1)
            com.google.android.gms.maps.GoogleMap r3 = r1.f13158Q
            r3.setOnCameraMoveListener(r1)
            com.google.android.gms.maps.GoogleMap r3 = r1.f13158Q
            r3.setOnInfoWindowClickListener(r1)
            com.google.android.gms.maps.GoogleMap r3 = r1.f13158Q
            com.google.android.gms.maps.UiSettings r3 = r3.getUiSettings()
            r10 = 1
            r3.setMyLocationButtonEnabled(r10)
            r3.setZoomControlsEnabled(r10)
            com.google.android.gms.maps.GoogleMap r3 = r1.f13158Q
            com.google.android.gms.maps.UiSettings r3 = r3.getUiSettings()
            r11 = 0
            r3.setMapToolbarEnabled(r11)
            int r3 = r1.f13160R
            if (r3 != r10) goto L_0x005d
            com.google.android.gms.maps.GoogleMap r3 = r1.f13158Q
            r24 = 4635681760191971328(0x4055400000000000, double:85.0)
            r4 = 1093664768(0x41300000, float:11.0)
            r3.setMaxZoomPreference(r4)
            r3 = 2131297056(0x7f090320, float:1.8212046E38)
            android.view.View r3 = r1.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            r3.setVisibility(r11)
            goto L_0x0062
        L_0x005d:
            r24 = 4635681760191971328(0x4055400000000000, double:85.0)
        L_0x0062:
            android.content.Context r3 = r1.getApplicationContext()
            java.lang.String r4 = "android.permission.ACCESS_COARSE_LOCATION"
            int r3 = androidx.core.content.a.checkSelfPermission(r3, r4)
            if (r3 == 0) goto L_0x007a
            android.content.Context r3 = r1.getApplicationContext()
            java.lang.String r4 = "android.permission.ACCESS_FINE_LOCATION"
            int r3 = androidx.core.content.a.checkSelfPermission(r3, r4)
            if (r3 != 0) goto L_0x008e
        L_0x007a:
            android.content.Context r3 = r1.getApplicationContext()
            com.google.android.gms.location.FusedLocationProviderClient r3 = com.google.android.gms.location.LocationServices.getFusedLocationProviderClient((android.content.Context) r3)
            com.google.android.gms.tasks.Task r3 = r3.getLastLocation()
            u2.l1 r4 = new u2.l1
            r4.<init>(r1)
            r3.addOnSuccessListener(r4)
        L_0x008e:
            int r3 = r1.f13208z0
            if (r3 != r10) goto L_0x0098
            com.google.android.gms.maps.GoogleMap r3 = r1.f13158Q
            r3.setMapType(r0)
            goto L_0x009d
        L_0x0098:
            com.google.android.gms.maps.GoogleMap r3 = r1.f13158Q
            r3.setMapType(r10)
        L_0x009d:
            int r3 = r1.f13140A0
            if (r3 != r10) goto L_0x00a4
            r1.F1()
        L_0x00a4:
            com.google.android.gms.maps.GoogleMap r3 = r1.f13158Q
            r4 = 2
            r3.setMapColorScheme(r4)
            android.content.res.Resources r3 = r1.getResources()
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.uiMode
            r3 = r3 & 48
            r28 = r0
            r29 = -1
            r30 = 3
            r5 = 16
            r31 = 4611686018427387904(0x4000000000000000, double:2.0)
            if (r3 != r5) goto L_0x0295
            java.lang.String r33 = "UTC"
            java.util.TimeZone r33 = java.util.TimeZone.getTimeZone(r33)
            java.util.Calendar r5 = java.util.Calendar.getInstance(r33)
            java.util.Date r7 = new java.util.Date
            r7.<init>()
            r5.setTime(r7)
            r7 = 11
            int r7 = r5.get(r7)
            r34 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            double r8 = (double) r7
            int r7 = r5.get(r2)
            double r0 = (double) r7
            r7 = 13
            int r7 = r5.get(r7)
            r36 = 0
            double r13 = (double) r7
            r38 = 4633641066610819072(0x404e000000000000, double:60.0)
            double r13 = r13 / r38
            double r0 = r0 + r13
            r13 = 4633641066610819072(0x404e000000000000, double:60.0)
            double r0 = r0 / r13
            double r8 = r8 + r0
            int r0 = r5.get(r4)
            int r0 = r0 + -13
            int r0 = r0 / r2
            int r1 = r5.get(r10)
            int r1 = r1 + 4800
            int r1 = r1 + r0
            int r1 = r1 * 1461
            int r1 = r1 / 4
            int r7 = r5.get(r4)
            int r7 = r7 + -1
            int r13 = r0 * 12
            int r7 = r7 - r13
            int r7 = r7 * 367
            int r7 = r7 / r2
            int r1 = r1 + r7
            int r7 = r5.get(r10)
            int r7 = r7 + 4900
            int r7 = r7 + r0
            int r7 = r7 / 100
            int r7 = r7 * 3
            int r7 = r7 / 4
            int r1 = r1 - r7
            int r0 = r5.get(r6)
            int r1 = r1 + r0
            int r1 = r1 + -32075
            double r0 = (double) r1
            r13 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r0 = r0 - r13
            r13 = 4627448617123184640(0x4038000000000000, double:24.0)
            double r8 = r8 / r13
            double r0 = r0 + r8
            r7 = 4702519064147263488(0x4142b42c80000000, double:2451545.0)
            double r0 = r0 - r7
            r7 = 4562436483280644874(0x3f5107cf0839ab0a, double:0.0010394594)
            double r7 = r7 * r0
            r13 = 4612007800620763526(0x400124a8c154c986, double:2.1429)
            double r13 = r13 - r7
            r7 = 4580615588530398020(0x3f919d9bcef8a344, double:0.017202791698)
            double r7 = r7 * r0
            r38 = 4617197369403076680(0x4013948b65237048, double:4.895063)
            double r7 = r7 + r38
            r38 = 4580615351663251359(0x3f919d64a896cf9f, double:0.0172019699)
            double r38 = r38 * r0
            r40 = 4618711701400080288(0x4018f5d249e44fa0, double:6.24006)
            double r38 = r38 + r40
            r40 = 4584976584248600397(0x3fa11be93f9f274d, double:0.03341607)
            double r42 = java.lang.Math.sin(r38)
            double r42 = r42 * r40
            double r7 = r7 + r42
            double r38 = r38 * r31
            double r38 = java.lang.Math.sin(r38)
            r40 = 4555072430521281171(0x3f36de3de3656a93, double:3.4894E-4)
            double r38 = r38 * r40
            double r7 = r7 + r38
            r38 = 4547995867501294621(0x3f1dba252a5bf41d, double:1.134E-4)
            double r7 = r7 - r38
            r38 = 4536612727609859838(0x3ef5493d60b39efe, double:2.03E-5)
            double r40 = java.lang.Math.sin(r13)
            double r40 = r40 * r38
            double r7 = r7 - r40
            r38 = 4484090294649358330(0x3e3ab05d815a07fa, double:6.214E-9)
            double r0 = r0 * r38
            r38 = 4601041180644465731(0x3fda2e939141dc43, double:0.4090928)
            double r38 = r38 - r0
            r0 = 4540968753284640658(0x3f04c305a3adef92, double:3.96E-5)
            double r13 = java.lang.Math.cos(r13)
            double r13 = r13 * r0
            double r38 = r38 + r13
            double r0 = java.lang.Math.sin(r7)
            double r7 = java.lang.Math.sin(r38)
            double r7 = r7 * r0
            double r0 = java.lang.Math.asin(r7)
            long r7 = r5.getTimeInMillis()
            r9 = 11
            r5.set(r9, r11)
            r5.set(r2, r11)
            r2 = 13
            r5.set(r2, r11)
            r2 = 14
            r5.set(r2, r11)
            long r13 = r5.getTimeInMillis()
            long r7 = r7 - r13
            double r7 = (double) r7
            r13 = 4725570615333879808(0x4194997000000000, double:8.64E7)
            double r7 = r7 / r13
            double r7 = r7 * r31
            double r7 = r7 * r34
            double r7 = r7 - r34
            int r2 = (r0 > r36 ? 1 : (r0 == r36 ? 0 : -1))
            if (r2 >= 0) goto L_0x01e5
            double r7 = r7 + r34
        L_0x01e5:
            com.google.android.gms.maps.model.PolygonOptions r5 = new com.google.android.gms.maps.model.PolygonOptions
            r5.<init>()
            r9 = 404(0x194, float:5.66E-43)
            com.google.android.gms.maps.model.LatLng[] r9 = new com.google.android.gms.maps.model.LatLng[r9]
            r13 = -4609115380302729960(0xc00921fb54442d18, double:-3.141592653589793)
            r38 = r11
        L_0x01f5:
            int r39 = (r13 > r34 ? 1 : (r13 == r34 ? 0 : -1))
            if (r39 > 0) goto L_0x023b
            double r39 = r13 + r7
            r42 = r7
            double r6 = java.lang.Math.cos(r39)
            double r6 = -r6
            double r39 = java.lang.Math.tan(r0)
            double r6 = r6 / r39
            double r6 = java.lang.Math.atan(r6)
            double r6 = java.lang.Math.toDegrees(r6)
            if (r2 >= 0) goto L_0x0213
            double r6 = -r6
        L_0x0213:
            int r8 = (r6 > r24 ? 1 : (r6 == r24 ? 0 : -1))
            if (r8 <= 0) goto L_0x0219
            r6 = r24
        L_0x0219:
            int r8 = (r6 > r22 ? 1 : (r6 == r22 ? 0 : -1))
            if (r8 >= 0) goto L_0x021f
            r6 = r22
        L_0x021f:
            com.google.android.gms.maps.model.LatLng r8 = new com.google.android.gms.maps.model.LatLng
            r39 = r12
            double r11 = java.lang.Math.toDegrees(r13)
            r8.<init>(r6, r11)
            r9[r38] = r8
            int r38 = r38 + 1
            r6 = 4580184733569722138(0x3f9015bf9217271a, double:0.015707963267948967)
            double r13 = r13 + r6
            r12 = r39
            r7 = r42
            r6 = 5
            r11 = 0
            goto L_0x01f5
        L_0x023b:
            r39 = r12
            int r0 = (r0 > r36 ? 1 : (r0 == r36 ? 0 : -1))
            if (r0 < 0) goto L_0x0244
            r0 = r22
            goto L_0x0246
        L_0x0244:
            r0 = r24
        L_0x0246:
            com.google.android.gms.maps.model.LatLng r2 = new com.google.android.gms.maps.model.LatLng
            r6 = 4614245397552977422(0x400917bde3a0560e, double:3.1365926535897932)
            double r6 = java.lang.Math.toDegrees(r6)
            r2.<init>(r0, r6)
            r9[r38] = r2
            int r2 = r38 + 1
            com.google.android.gms.maps.model.LatLng r6 = new com.google.android.gms.maps.model.LatLng
            r7 = r36
            r6.<init>(r0, r7)
            r9[r2] = r6
            int r38 = r38 + 2
            com.google.android.gms.maps.model.LatLng r2 = new com.google.android.gms.maps.model.LatLng
            r6 = -4609126639301798386(0xc00917bde3a0560e, double:-3.1365926535897932)
            double r6 = java.lang.Math.toDegrees(r6)
            r2.<init>(r0, r6)
            r9[r38] = r2
            r5.add((com.google.android.gms.maps.model.LatLng[]) r9)
            r5.geodesic(r10)
            r1 = r69
            com.google.android.gms.maps.GoogleMap r0 = r1.f13158Q
            com.google.android.gms.maps.model.Polygon r0 = r0.addPolygon(r5)
            r2 = 55
            r5 = 0
            int r2 = android.graphics.Color.argb(r2, r5, r5, r5)
            r0.setFillColor(r2)
            r2 = 0
            r0.setStrokeWidth(r2)
            r0.setClickable(r5)
        L_0x0292:
            r0 = r30
            goto L_0x0298
        L_0x0295:
            r39 = r12
            goto L_0x0292
        L_0x0298:
            com.google.android.gms.maps.model.Circle[] r2 = new com.google.android.gms.maps.model.Circle[r0]
            r1.f13196n0 = r2
            int r2 = r1.f13160R
            if (r2 != 0) goto L_0x045a
            android.os.Bundle r2 = r1.f13154O
            java.lang.String r5 = "com.finazzi.distquake.latitude_notification"
            double r6 = r2.getDouble(r5)
            android.os.Bundle r2 = r1.f13154O
            java.lang.String r5 = "com.finazzi.distquake.longitude_notification"
            double r8 = r2.getDouble(r5)
            android.content.SharedPreferences r2 = r1.f13207y0
            java.lang.String r5 = "eqn_notify_radius"
            java.lang.String r2 = r2.getString(r5, r15)
            int r2 = java.lang.Integer.parseInt(r2)
            android.content.SharedPreferences r5 = r1.f13207y0
            java.lang.String r13 = "eqn_notify_radius_strong"
            java.lang.String r5 = r5.getString(r13, r15)
            int r5 = java.lang.Integer.parseInt(r5)
            int r13 = java.lang.Math.max(r2, r5)
            boolean r14 = r1.w1()
            r36 = 0
            int r2 = (r6 > r36 ? 1 : (r6 == r36 ? 0 : -1))
            if (r2 == 0) goto L_0x02d8
            r2 = r10
            goto L_0x02d9
        L_0x02d8:
            r2 = 0
        L_0x02d9:
            int r5 = (r8 > r36 ? 1 : (r8 == r36 ? 0 : -1))
            if (r5 == 0) goto L_0x02df
            r5 = r10
            goto L_0x02e0
        L_0x02df:
            r5 = 0
        L_0x02e0:
            r22 = r2 & r5
            boolean r2 = r1.f13179a1
            if (r2 == 0) goto L_0x041e
            r24 = 4726483295884279808(0x4197d78400000000, double:1.0E8)
            r23 = r29
            r0 = 10000000(0x989680, float:1.4012985E-38)
            r2 = 0
            r5 = 10000000(0x989680, float:1.4012985E-38)
            r30 = 0
            r34 = 10000000(0x989680, float:1.4012985E-38)
        L_0x02f9:
            double[] r4 = r1.f13164T
            int r4 = r4.length
            if (r2 >= r4) goto L_0x0395
            java.lang.String[] r4 = r1.f13192j0
            r4 = r4[r2]
            int r4 = r1.o1(r4)
            if (r22 == 0) goto L_0x0334
            double[] r12 = r1.f13164T
            r43 = r12[r2]
            double[] r12 = r1.f13166U
            r45 = r12[r2]
            r35 = r2
            r48 = r3
            r11 = r4
            r33 = r10
            r2 = r43
            r12 = 1090519040(0x41000000, float:8.0)
            r10 = r5
            r4 = r45
            double r2 = r1.v1(r2, r4, r6, r8)
            int r4 = (r2 > r24 ? 1 : (r2 == r24 ? 0 : -1))
            if (r4 >= 0) goto L_0x032a
            r24 = r2
            r34 = r11
        L_0x032a:
            r5 = r10
            r4 = r13
            r44 = r14
            r43 = r15
            r12 = r6
            r14 = r8
            goto L_0x0386
        L_0x0334:
            r35 = r2
            r48 = r3
            r11 = r4
            r33 = r10
            r12 = 1090519040(0x41000000, float:8.0)
            r10 = r5
            if (r11 >= r10) goto L_0x0343
            r10 = r11
            r30 = r35
        L_0x0343:
            if (r14 == 0) goto L_0x037e
            double[] r2 = r1.f13164T
            r3 = r2[r35]
            double[] r2 = r1.f13166U
            r43 = r2[r35]
            float r2 = r1.f13203u0
            r38 = r13
            double r12 = (double) r2
            float r2 = r1.f13204v0
            double r1 = (double) r2
            r67 = r12
            r12 = r6
            r6 = r67
            r67 = r1
            r1 = r69
            r2 = r3
            r4 = r43
            r44 = r14
            r43 = r15
            r14 = r8
            r8 = r67
            double r2 = r1.v1(r2, r4, r6, r8)
            r4 = r38
            double r5 = (double) r4
            int r2 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x0385
            r2 = 2880(0xb40, float:4.036E-42)
            if (r11 >= r2) goto L_0x0385
            if (r11 >= r0) goto L_0x0385
            r5 = r10
            r0 = r11
            r23 = r35
            goto L_0x0386
        L_0x037e:
            r4 = r13
            r44 = r14
            r43 = r15
            r12 = r6
            r14 = r8
        L_0x0385:
            r5 = r10
        L_0x0386:
            int r2 = r35 + 1
            r6 = r12
            r8 = r14
            r10 = r33
            r15 = r43
            r14 = r44
            r3 = r48
            r13 = r4
            goto L_0x02f9
        L_0x0395:
            r48 = r3
            r12 = r6
            r33 = r10
            r44 = r14
            r43 = r15
            r10 = r5
            r14 = r8
            if (r22 == 0) goto L_0x03b5
            com.google.android.gms.maps.model.LatLng r0 = new com.google.android.gms.maps.model.LatLng
            r0.<init>(r12, r14)
            com.google.android.gms.maps.GoogleMap r2 = r1.f13158Q
            r3 = 1082130432(0x40800000, float:4.0)
            com.google.android.gms.maps.CameraUpdate r0 = com.google.android.gms.maps.CameraUpdateFactory.newLatLngZoom(r0, r3)
            r2.animateCamera(r0)
            r0 = r34
            goto L_0x03eb
        L_0x03b5:
            if (r23 < 0) goto L_0x03d2
            if (r44 == 0) goto L_0x03d2
            com.google.android.gms.maps.model.LatLng r2 = new com.google.android.gms.maps.model.LatLng
            double[] r3 = r1.f13164T
            r4 = r3[r23]
            double[] r3 = r1.f13166U
            r6 = r3[r23]
            r2.<init>(r4, r6)
            com.google.android.gms.maps.GoogleMap r3 = r1.f13158Q
            r4 = 1082130432(0x40800000, float:4.0)
            com.google.android.gms.maps.CameraUpdate r2 = com.google.android.gms.maps.CameraUpdateFactory.newLatLngZoom(r2, r4)
            r3.animateCamera(r2)
            goto L_0x03eb
        L_0x03d2:
            com.google.android.gms.maps.model.LatLng r0 = new com.google.android.gms.maps.model.LatLng
            double[] r2 = r1.f13164T
            r3 = r2[r30]
            double[] r2 = r1.f13166U
            r5 = r2[r30]
            r0.<init>(r3, r5)
            com.google.android.gms.maps.GoogleMap r2 = r1.f13158Q
            r3 = 1082130432(0x40800000, float:4.0)
            com.google.android.gms.maps.CameraUpdate r0 = com.google.android.gms.maps.CameraUpdateFactory.newLatLngZoom(r0, r3)
            r2.animateCamera(r0)
            r0 = r10
        L_0x03eb:
            r2 = 2131296992(0x7f0902e0, float:1.8211916E38)
            android.view.View r2 = r1.findViewById(r2)
            android.widget.Spinner r2 = (android.widget.Spinner) r2
            r3 = 60
            if (r0 > r3) goto L_0x0400
            r10 = 3
            r2.setSelection(r10)
            r0 = r33
            r11 = 2
            goto L_0x0426
        L_0x0400:
            r10 = 3
            r3 = 1440(0x5a0, float:2.018E-42)
            if (r0 > r3) goto L_0x040c
            r11 = 2
            r2.setSelection(r11)
            r0 = r33
            goto L_0x0426
        L_0x040c:
            r11 = 2
            r3 = 10080(0x2760, float:1.4125E-41)
            if (r0 > r3) goto L_0x0417
            r0 = r33
            r2.setSelection(r0)
            goto L_0x0426
        L_0x0417:
            r0 = r33
            r5 = 0
            r2.setSelection(r5)
            goto L_0x0426
        L_0x041e:
            r11 = r10
            r10 = r0
            r0 = r11
            r48 = r3
            r11 = r4
            r43 = r15
        L_0x0426:
            android.content.SharedPreferences r2 = r1.f13206x0
            java.lang.String r3 = "show_message_realtime"
            boolean r2 = r2.getBoolean(r3, r0)
            if (r2 == 0) goto L_0x0460
            android.app.AlertDialog$Builder r0 = new android.app.AlertDialog$Builder
            r0.<init>(r1)
            r2 = 2131886475(0x7f12018b, float:1.940753E38)
            java.lang.String r2 = r1.getString(r2)
            r0.setMessage(r2)
            r5 = 0
            r0.setCancelable(r5)
            r2 = 2131886689(0x7f120261, float:1.9407964E38)
            java.lang.String r3 = r1.getString(r2)
            u2.q1 r2 = new u2.q1
            r2.<init>(r1)
            r0.setNegativeButton(r3, r2)
            android.app.AlertDialog r0 = r0.create()
            r0.show()
            goto L_0x0460
        L_0x045a:
            r10 = r0
            r48 = r3
            r11 = r4
            r43 = r15
        L_0x0460:
            int r0 = r1.f13160R
            r2 = 1
            if (r0 != r2) goto L_0x0605
            android.os.Bundle r0 = r1.f13154O
            java.lang.String r2 = "com.finazzi.distquake.latitude_notification"
            double r6 = r0.getDouble(r2)
            android.os.Bundle r0 = r1.f13154O
            java.lang.String r2 = "com.finazzi.distquake.longitude_notification"
            double r8 = r0.getDouble(r2)
            android.content.SharedPreferences r0 = r1.f13207y0
            java.lang.String r2 = "eqn_notify_radius_manual"
            r3 = r43
            java.lang.String r0 = r0.getString(r2, r3)
            int r0 = java.lang.Integer.parseInt(r0)
            boolean r12 = r1.w1()
            r36 = 0
            int r2 = (r6 > r36 ? 1 : (r6 == r36 ? 0 : -1))
            if (r2 == 0) goto L_0x048f
            r2 = 1
            goto L_0x0490
        L_0x048f:
            r2 = 0
        L_0x0490:
            int r3 = (r8 > r36 ? 1 : (r8 == r36 ? 0 : -1))
            if (r3 == 0) goto L_0x0496
            r3 = 1
            goto L_0x0497
        L_0x0496:
            r3 = 0
        L_0x0497:
            r13 = r2 & r3
            boolean r2 = r1.f13179a1
            if (r2 == 0) goto L_0x05cf
            r2 = 4726483295884279808(0x4197d78400000000, double:1.0E8)
            r14 = r2
            r22 = r29
            r2 = 10000000(0x989680, float:1.4012985E-38)
            r3 = 10000000(0x989680, float:1.4012985E-38)
            r4 = 0
            r23 = 0
            r42 = 10000000(0x989680, float:1.4012985E-38)
        L_0x04b1:
            double[] r5 = r1.f13164T
            int r5 = r5.length
            if (r4 >= r5) goto L_0x0540
            java.lang.String[] r5 = r1.f13192j0
            r5 = r5[r4]
            int r5 = r1.o1(r5)
            if (r13 == 0) goto L_0x04ea
            double[] r11 = r1.f13164T
            r24 = r11[r4]
            double[] r11 = r1.f13166U
            r34 = r11[r4]
            r11 = r2
            r10 = r3
            r2 = r24
            r24 = r4
            r25 = r12
            r12 = r5
            r4 = r34
            double r2 = r1.v1(r2, r4, r6, r8)
            int r4 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r4 >= 0) goto L_0x04de
            r14 = r2
            r42 = r12
        L_0x04de:
            r51 = r8
            r3 = r10
            r2 = r11
            r43 = r13
            r44 = r14
            r33 = 1
            r13 = r6
            goto L_0x0531
        L_0x04ea:
            r11 = r2
            r10 = r3
            r24 = r4
            r25 = r12
            r12 = r5
            if (r12 >= r11) goto L_0x04f6
            r11 = r12
            r23 = r24
        L_0x04f6:
            if (r25 == 0) goto L_0x0527
            double[] r2 = r1.f13164T
            r3 = r2[r24]
            double[] r2 = r1.f13166U
            r34 = r2[r24]
            float r2 = r1.f13203u0
            r36 = r3
            double r2 = (double) r2
            float r4 = r1.f13204v0
            double r4 = (double) r4
            r51 = r8
            r43 = r13
            r44 = r14
            r8 = r4
            r13 = r6
            r4 = r34
            r6 = r2
            r2 = r36
            double r2 = r1.v1(r2, r4, r6, r8)
            double r4 = (double) r0
            int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r2 >= 0) goto L_0x052e
            if (r12 >= r10) goto L_0x052e
            r2 = r11
            r3 = r12
            r22 = r24
        L_0x0524:
            r33 = 1
            goto L_0x0531
        L_0x0527:
            r51 = r8
            r43 = r13
            r44 = r14
            r13 = r6
        L_0x052e:
            r3 = r10
            r2 = r11
            goto L_0x0524
        L_0x0531:
            int r4 = r24 + 1
            r6 = r13
            r12 = r25
            r13 = r43
            r14 = r44
            r8 = r51
            r10 = 3
            r11 = 2
            goto L_0x04b1
        L_0x0540:
            r11 = r2
            r10 = r3
            r51 = r8
            r43 = r13
            r13 = r6
            if (r43 == 0) goto L_0x055e
            com.google.android.gms.maps.model.LatLng r0 = new com.google.android.gms.maps.model.LatLng
            r8 = r51
            r0.<init>(r13, r8)
            com.google.android.gms.maps.GoogleMap r2 = r1.f13158Q
            r12 = 1090519040(0x41000000, float:8.0)
            com.google.android.gms.maps.CameraUpdate r0 = com.google.android.gms.maps.CameraUpdateFactory.newLatLngZoom(r0, r12)
            r2.animateCamera(r0)
            r10 = r42
            goto L_0x0590
        L_0x055e:
            r12 = 1090519040(0x41000000, float:8.0)
            if (r22 < 0) goto L_0x0579
            com.google.android.gms.maps.model.LatLng r0 = new com.google.android.gms.maps.model.LatLng
            double[] r2 = r1.f13164T
            r3 = r2[r22]
            double[] r2 = r1.f13166U
            r5 = r2[r22]
            r0.<init>(r3, r5)
            com.google.android.gms.maps.GoogleMap r2 = r1.f13158Q
            com.google.android.gms.maps.CameraUpdate r0 = com.google.android.gms.maps.CameraUpdateFactory.newLatLngZoom(r0, r12)
            r2.animateCamera(r0)
            goto L_0x0590
        L_0x0579:
            com.google.android.gms.maps.model.LatLng r0 = new com.google.android.gms.maps.model.LatLng
            double[] r2 = r1.f13164T
            r3 = r2[r23]
            double[] r2 = r1.f13166U
            r5 = r2[r23]
            r0.<init>(r3, r5)
            com.google.android.gms.maps.GoogleMap r2 = r1.f13158Q
            com.google.android.gms.maps.CameraUpdate r0 = com.google.android.gms.maps.CameraUpdateFactory.newLatLngZoom(r0, r12)
            r2.animateCamera(r0)
            r10 = r11
        L_0x0590:
            r0 = 2131296991(0x7f0902df, float:1.8211914E38)
            android.view.View r0 = r1.findViewById(r0)
            android.widget.Spinner r0 = (android.widget.Spinner) r0
            r2 = 10
            if (r10 > r2) goto L_0x05a3
            r2 = 5
            r0.setSelection(r2)
        L_0x05a1:
            r3 = 1
            goto L_0x05d1
        L_0x05a3:
            r2 = 5
            r3 = 60
            if (r10 > r3) goto L_0x05ae
            r3 = r28
            r0.setSelection(r3)
            goto L_0x05a1
        L_0x05ae:
            r3 = 120(0x78, float:1.68E-43)
            if (r10 > r3) goto L_0x05b7
            r3 = 3
            r0.setSelection(r3)
            goto L_0x05a1
        L_0x05b7:
            r3 = 360(0x168, float:5.04E-43)
            if (r10 > r3) goto L_0x05c0
            r11 = 2
            r0.setSelection(r11)
            goto L_0x05a1
        L_0x05c0:
            r3 = 720(0x2d0, float:1.009E-42)
            if (r10 > r3) goto L_0x05c9
            r3 = 1
            r0.setSelection(r3)
            goto L_0x05d1
        L_0x05c9:
            r3 = 1
            r5 = 0
            r0.setSelection(r5)
            goto L_0x05d1
        L_0x05cf:
            r2 = 5
            goto L_0x05a1
        L_0x05d1:
            android.content.SharedPreferences r0 = r1.f13206x0
            java.lang.String r4 = "show_message_reports"
            boolean r0 = r0.getBoolean(r4, r3)
            if (r0 == 0) goto L_0x0606
            android.app.AlertDialog$Builder r0 = new android.app.AlertDialog$Builder
            r0.<init>(r1)
            r3 = 2131886476(0x7f12018c, float:1.9407532E38)
            java.lang.String r3 = r1.getString(r3)
            r0.setMessage(r3)
            r5 = 0
            r0.setCancelable(r5)
            r3 = 2131886689(0x7f120261, float:1.9407964E38)
            java.lang.String r4 = r1.getString(r3)
            u2.r1 r3 = new u2.r1
            r3.<init>(r1)
            r0.setNegativeButton(r4, r3)
            android.app.AlertDialog r0 = r0.create()
            r0.show()
            goto L_0x0606
        L_0x0605:
            r2 = 5
        L_0x0606:
            int r0 = r1.f13160R
            java.lang.String r4 = ""
            r8 = 255(0xff, float:3.57E-43)
            r11 = 2
            if (r0 != r11) goto L_0x0b7c
            android.os.Bundle r0 = r1.f13154O
            java.lang.String r9 = "com.finazzi.distquake.list_position"
            int r0 = r0.getInt(r9)
            android.os.Bundle r9 = r1.f13154O
            java.lang.String r10 = "com.finazzi.distquake.simulate_wave"
            boolean r9 = r9.getBoolean(r10)
            android.os.Bundle r10 = r1.f13154O
            java.lang.String r11 = "com.finazzi.distquake.shakemap"
            java.lang.String r10 = r10.getString(r11, r4)
            android.os.Bundle r11 = r1.f13154O
            java.lang.String r12 = "com.finazzi.distquake.map_lat"
            double r11 = r11.getDouble(r12)
            android.os.Bundle r13 = r1.f13154O
            java.lang.String r14 = "com.finazzi.distquake.map_lon"
            double r13 = r13.getDouble(r14)
            if (r9 != 0) goto L_0x0669
            boolean r9 = r1.f13179a1
            if (r9 == 0) goto L_0x06a3
            if (r0 < 0) goto L_0x0658
            com.google.android.gms.maps.model.LatLng r9 = new com.google.android.gms.maps.model.LatLng
            double[] r11 = r1.f13164T
            r12 = r11[r0]
            double[] r11 = r1.f13166U
            r14 = r11[r0]
            r9.<init>(r12, r14)
            com.google.android.gms.maps.GoogleMap r11 = r1.f13158Q
            r12 = 1090519040(0x41000000, float:8.0)
            com.google.android.gms.maps.CameraUpdate r9 = com.google.android.gms.maps.CameraUpdateFactory.newLatLngZoom(r9, r12)
            r11.animateCamera(r9)
            goto L_0x06a3
        L_0x0658:
            com.google.android.gms.maps.model.LatLng r9 = new com.google.android.gms.maps.model.LatLng
            r9.<init>(r11, r13)
            com.google.android.gms.maps.GoogleMap r11 = r1.f13158Q
            r12 = 1084227584(0x40a00000, float:5.0)
            com.google.android.gms.maps.CameraUpdate r9 = com.google.android.gms.maps.CameraUpdateFactory.newLatLngZoom(r9, r12)
            r11.animateCamera(r9)
            goto L_0x06a3
        L_0x0669:
            if (r0 < 0) goto L_0x06a3
            boolean r9 = r1.f13179a1
            if (r9 == 0) goto L_0x06a3
            r9 = 1
            r1.f13159Q0 = r9
            double[] r9 = r1.f13164T
            r11 = r9[r0]
            r1.f13161R0 = r11
            double[] r9 = r1.f13166U
            r11 = r9[r0]
            r1.f13163S0 = r11
            double[] r9 = r1.f13168V
            r11 = r9[r0]
            r1.f13165T0 = r11
            com.google.android.gms.maps.model.LatLng r9 = new com.google.android.gms.maps.model.LatLng
            double r11 = r1.f13161R0
            double r13 = r1.f13163S0
            r9.<init>(r11, r13)
            com.google.android.gms.maps.model.CameraPosition r11 = new com.google.android.gms.maps.model.CameraPosition
            r12 = 1091567616(0x41100000, float:9.0)
            r13 = 1109393408(0x42200000, float:40.0)
            r14 = 0
            r11.<init>(r9, r12, r13, r14)
            com.google.android.gms.maps.GoogleMap r9 = r1.f13158Q
            com.google.android.gms.maps.CameraUpdate r11 = com.google.android.gms.maps.CameraUpdateFactory.newCameraPosition(r11)
            r12 = 3000(0xbb8, float:4.204E-42)
            r13 = 0
            r9.animateCamera(r11, r12, r13)
        L_0x06a3:
            android.content.SharedPreferences r9 = r1.f13206x0
            java.lang.String r11 = "show_message_official"
            r12 = 1
            boolean r9 = r9.getBoolean(r11, r12)
            if (r9 == 0) goto L_0x06d7
            android.app.AlertDialog$Builder r9 = new android.app.AlertDialog$Builder
            r9.<init>(r1)
            r11 = 2131886474(0x7f12018a, float:1.9407528E38)
            java.lang.String r11 = r1.getString(r11)
            r9.setMessage(r11)
            r11 = 0
            r9.setCancelable(r11)
            r11 = 2131886689(0x7f120261, float:1.9407964E38)
            java.lang.String r11 = r1.getString(r11)
            u2.s1 r12 = new u2.s1
            r12.<init>(r1)
            r9.setNegativeButton(r11, r12)
            android.app.AlertDialog r9 = r9.create()
            r9.show()
        L_0x06d7:
            boolean r9 = r10.isEmpty()
            if (r9 != 0) goto L_0x0b67
            r9 = 2131297056(0x7f090320, float:1.8212046E38)
            android.view.View r9 = r1.findViewById(r9)
            android.widget.TextView r9 = (android.widget.TextView) r9
            r11 = 0
            r9.setVisibility(r11)
            r12 = 2131886477(0x7f12018d, float:1.9407534E38)
            java.lang.String r12 = r1.getString(r12)
            r9.setText(r12)
            org.json.JSONArray r9 = new org.json.JSONArray     // Catch:{ JSONException -> 0x080d }
            r9.<init>(r10)     // Catch:{ JSONException -> 0x080d }
            int r10 = r9.length()     // Catch:{ JSONException -> 0x080d }
            org.json.JSONObject r12 = r9.getJSONObject(r11)     // Catch:{ JSONException -> 0x080d }
            r11 = r39
            double r12 = r12.getDouble(r11)     // Catch:{ JSONException -> 0x080d }
            r14 = 4621819117588971520(0x4024000000000000, double:10.0)
            double r12 = r12 * r14
            long r12 = java.lang.Math.round(r12)     // Catch:{ JSONException -> 0x080d }
            double r12 = (double) r12     // Catch:{ JSONException -> 0x080d }
            double r12 = r12 / r14
            r41 = r2
            r33 = 1
            int r2 = r10 + -1
            org.json.JSONObject r2 = r9.getJSONObject(r2)     // Catch:{ JSONException -> 0x080d }
            double r22 = r2.getDouble(r11)     // Catch:{ JSONException -> 0x080d }
            double r22 = r22 * r14
            r24 = r14
            long r14 = java.lang.Math.round(r22)     // Catch:{ JSONException -> 0x080d }
            double r14 = (double) r14     // Catch:{ JSONException -> 0x080d }
            double r14 = r14 / r24
            r2 = 0
        L_0x072a:
            if (r2 >= r10) goto L_0x0b57
            org.json.JSONObject r7 = r9.getJSONObject(r2)     // Catch:{ JSONException -> 0x080d }
            double r34 = r7.getDouble(r11)     // Catch:{ JSONException -> 0x080d }
            java.lang.String r3 = "lat"
            org.json.JSONArray r3 = r7.getJSONArray(r3)     // Catch:{ JSONException -> 0x080d }
            java.lang.String r5 = "lon"
            org.json.JSONArray r5 = r7.getJSONArray(r5)     // Catch:{ JSONException -> 0x080d }
            double r36 = r34 - r12
            double r42 = r14 - r12
            double r36 = r36 / r42
            r42 = 4643211215818981376(0x4070000000000000, double:256.0)
            double r36 = r36 * r42
            long r6 = java.lang.Math.round(r36)     // Catch:{ JSONException -> 0x080d }
            int r6 = (int) r6     // Catch:{ JSONException -> 0x080d }
            if (r6 <= r8) goto L_0x0752
            r6 = r8
        L_0x0752:
            if (r6 >= 0) goto L_0x0755
            r6 = 0
        L_0x0755:
            int r7 = r3.length()     // Catch:{ JSONException -> 0x080d }
            int r8 = r5.length()     // Catch:{ JSONException -> 0x080d }
            if (r7 != r8) goto L_0x0b32
            android.util.DisplayMetrics r7 = new android.util.DisplayMetrics     // Catch:{ JSONException -> 0x080d }
            r7.<init>()     // Catch:{ JSONException -> 0x080d }
            android.view.WindowManager r8 = r1.getWindowManager()     // Catch:{ JSONException -> 0x080d }
            android.view.Display r8 = r8.getDefaultDisplay()     // Catch:{ JSONException -> 0x080d }
            r8.getMetrics(r7)     // Catch:{ JSONException -> 0x080d }
            int r8 = r7.heightPixels     // Catch:{ JSONException -> 0x080d }
            int r7 = r7.widthPixels     // Catch:{ JSONException -> 0x080d }
            r37 = r0
            com.google.android.gms.maps.model.PolylineOptions r0 = new com.google.android.gms.maps.model.PolylineOptions     // Catch:{ JSONException -> 0x080d }
            r0.<init>()     // Catch:{ JSONException -> 0x080d }
            r39 = r2
            java.lang.String[] r2 = r1.f13187e1     // Catch:{ JSONException -> 0x080d }
            r2 = r2[r6]     // Catch:{ JSONException -> 0x080d }
            int r2 = android.graphics.Color.parseColor(r2)     // Catch:{ JSONException -> 0x080d }
            r0.color(r2)     // Catch:{ JSONException -> 0x080d }
            int r2 = java.lang.Math.max(r8, r7)     // Catch:{ JSONException -> 0x080d }
            r42 = r9
            r43 = r10
            double r9 = (double) r2     // Catch:{ JSONException -> 0x080d }
            r44 = 4639481672377565184(0x4062c00000000000, double:150.0)
            double r9 = r9 / r44
            float r2 = (float) r9     // Catch:{ JSONException -> 0x080d }
            r0.width(r2)     // Catch:{ JSONException -> 0x080d }
            r2 = 0
        L_0x079c:
            int r9 = r3.length()     // Catch:{ JSONException -> 0x080d }
            if (r2 >= r9) goto L_0x0b22
            com.google.android.gms.maps.model.LatLng r9 = new com.google.android.gms.maps.model.LatLng     // Catch:{ JSONException -> 0x080d }
            int r10 = r3.getInt(r2)     // Catch:{ JSONException -> 0x080d }
            r45 = r3
            r44 = r4
            double r3 = (double) r10     // Catch:{ JSONException -> 0x080d }
            r46 = 4666723172467343360(0x40c3880000000000, double:10000.0)
            double r3 = r3 / r46
            int r10 = r5.getInt(r2)     // Catch:{ JSONException -> 0x080d }
            r46 = r11
            double r10 = (double) r10     // Catch:{ JSONException -> 0x080d }
            r50 = 4666723172467343360(0x40c3880000000000, double:10000.0)
            double r10 = r10 / r50
            r9.<init>(r3, r10)     // Catch:{ JSONException -> 0x080d }
            r0.add((com.google.android.gms.maps.model.LatLng) r9)     // Catch:{ JSONException -> 0x080d }
            int r3 = r45.length()     // Catch:{ JSONException -> 0x080d }
            r38 = 2
            int r3 = r3 / 2
            if (r2 != r3) goto L_0x0afd
            int r3 = java.lang.Math.max(r8, r7)     // Catch:{ JSONException -> 0x080d }
            r27 = 60
            int r3 = r3 / 60
            android.graphics.Paint r4 = new android.graphics.Paint     // Catch:{ JSONException -> 0x080d }
            r4.<init>()     // Catch:{ JSONException -> 0x080d }
            android.graphics.Paint$Align r10 = android.graphics.Paint.Align.CENTER     // Catch:{ JSONException -> 0x080d }
            r4.setTextAlign(r10)     // Catch:{ JSONException -> 0x080d }
            r4.setTextAlign(r10)     // Catch:{ JSONException -> 0x080d }
            android.graphics.Typeface r10 = android.graphics.Typeface.DEFAULT_BOLD     // Catch:{ JSONException -> 0x080d }
            r4.setTypeface(r10)     // Catch:{ JSONException -> 0x080d }
            r10 = 1
            r4.setAntiAlias(r10)     // Catch:{ JSONException -> 0x080d }
            double r10 = r34 * r24
            long r10 = java.lang.Math.round(r10)     // Catch:{ JSONException -> 0x080d }
            double r10 = (double) r10     // Catch:{ JSONException -> 0x080d }
            double r10 = r10 / r24
            r49 = r7
            r47 = r8
            double r7 = java.lang.Math.floor(r10)     // Catch:{ JSONException -> 0x080d }
            r50 = r2
            int r2 = (int) r7     // Catch:{ JSONException -> 0x080d }
            switch(r2) {
                case 1: goto L_0x082e;
                case 2: goto L_0x082b;
                case 3: goto L_0x0828;
                case 4: goto L_0x0825;
                case 5: goto L_0x0822;
                case 6: goto L_0x081f;
                case 7: goto L_0x081c;
                case 8: goto L_0x0819;
                case 9: goto L_0x0816;
                case 10: goto L_0x0813;
                case 11: goto L_0x0810;
                case 12: goto L_0x080a;
                default: goto L_0x0807;
            }     // Catch:{ JSONException -> 0x080d }
        L_0x0807:
            r2 = r44
            goto L_0x0830
        L_0x080a:
            java.lang.String r2 = "XXI"
            goto L_0x0830
        L_0x080d:
            r0 = move-exception
            goto L_0x0b61
        L_0x0810:
            java.lang.String r2 = "XI"
            goto L_0x0830
        L_0x0813:
            java.lang.String r2 = "X"
            goto L_0x0830
        L_0x0816:
            java.lang.String r2 = "IX"
            goto L_0x0830
        L_0x0819:
            java.lang.String r2 = "VIII"
            goto L_0x0830
        L_0x081c:
            java.lang.String r2 = "VII"
            goto L_0x0830
        L_0x081f:
            java.lang.String r2 = "VI"
            goto L_0x0830
        L_0x0822:
            java.lang.String r2 = "V"
            goto L_0x0830
        L_0x0825:
            java.lang.String r2 = "IV"
            goto L_0x0830
        L_0x0828:
            java.lang.String r2 = "III"
            goto L_0x0830
        L_0x082b:
            java.lang.String r2 = "II"
            goto L_0x0830
        L_0x082e:
            java.lang.String r2 = "I"
        L_0x0830:
            int r51 = (r7 > r10 ? 1 : (r7 == r10 ? 0 : -1))
            if (r51 == 0) goto L_0x0855
            double r7 = r10 - r7
            double r7 = r7 * r24
            long r7 = java.lang.Math.round(r7)     // Catch:{ JSONException -> 0x080d }
            int r7 = (int) r7     // Catch:{ JSONException -> 0x080d }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x080d }
            r8.<init>()     // Catch:{ JSONException -> 0x080d }
            r8.append(r2)     // Catch:{ JSONException -> 0x080d }
            java.lang.String r2 = "."
            r8.append(r2)     // Catch:{ JSONException -> 0x080d }
            java.lang.String r2 = java.lang.Integer.toString(r7)     // Catch:{ JSONException -> 0x080d }
            r8.append(r2)     // Catch:{ JSONException -> 0x080d }
            java.lang.String r2 = r8.toString()     // Catch:{ JSONException -> 0x080d }
        L_0x0855:
            if (r51 != 0) goto L_0x0869
            double r7 = (double) r3     // Catch:{ JSONException -> 0x080d }
            r52 = 4608758678669597082(0x3ff599999999999a, double:1.35)
            double r7 = r7 * r52
            float r7 = (float) r7     // Catch:{ JSONException -> 0x080d }
            r4.setTextSize(r7)     // Catch:{ JSONException -> 0x080d }
            r7 = -65536(0xffffffffffff0000, float:NaN)
            r4.setColor(r7)     // Catch:{ JSONException -> 0x080d }
            goto L_0x087c
        L_0x0869:
            float r7 = (float) r3     // Catch:{ JSONException -> 0x080d }
            r4.setTextSize(r7)     // Catch:{ JSONException -> 0x080d }
            r7 = 65
            if (r6 >= r7) goto L_0x0877
            r7 = r29
            r4.setColor(r7)     // Catch:{ JSONException -> 0x080d }
            goto L_0x087c
        L_0x0877:
            r7 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r4.setColor(r7)     // Catch:{ JSONException -> 0x080d }
        L_0x087c:
            android.graphics.Rect r7 = new android.graphics.Rect     // Catch:{ JSONException -> 0x080d }
            r7.<init>()     // Catch:{ JSONException -> 0x080d }
            int r8 = r2.length()     // Catch:{ JSONException -> 0x080d }
            r52 = r5
            r5 = 0
            r4.getTextBounds(r2, r5, r8, r7)     // Catch:{ JSONException -> 0x080d }
            int r5 = r7.width()     // Catch:{ JSONException -> 0x080d }
            r30 = 3
            int r5 = r5 * 3
            int r8 = r7.height()     // Catch:{ JSONException -> 0x080d }
            int r8 = r8 * 5
            r53 = r6
            android.graphics.Bitmap$Config r6 = android.graphics.Bitmap.Config.ARGB_8888     // Catch:{ JSONException -> 0x080d }
            android.graphics.Bitmap r5 = android.graphics.Bitmap.createBitmap(r5, r8, r6)     // Catch:{ JSONException -> 0x080d }
            android.graphics.Canvas r6 = new android.graphics.Canvas     // Catch:{ JSONException -> 0x080d }
            r6.<init>(r5)     // Catch:{ JSONException -> 0x080d }
            android.graphics.Paint r8 = new android.graphics.Paint     // Catch:{ JSONException -> 0x080d }
            r8.<init>()     // Catch:{ JSONException -> 0x080d }
            r62 = r7
            r7 = 255(0xff, float:3.57E-43)
            r8.setAlpha(r7)     // Catch:{ JSONException -> 0x080d }
            r7 = 0
            r6.drawBitmap(r5, r7, r7, r8)     // Catch:{ JSONException -> 0x080d }
            android.graphics.Paint r7 = new android.graphics.Paint     // Catch:{ JSONException -> 0x080d }
            r7.<init>()     // Catch:{ JSONException -> 0x080d }
            r8 = 1
            r7.setAntiAlias(r8)     // Catch:{ JSONException -> 0x080d }
            android.graphics.Paint$Style r8 = android.graphics.Paint.Style.FILL     // Catch:{ JSONException -> 0x080d }
            r7.setStyle(r8)     // Catch:{ JSONException -> 0x080d }
            java.lang.String[] r8 = r1.f13187e1     // Catch:{ JSONException -> 0x080d }
            r8 = r8[r53]     // Catch:{ JSONException -> 0x080d }
            int r8 = android.graphics.Color.parseColor(r8)     // Catch:{ JSONException -> 0x080d }
            r7.setColor(r8)     // Catch:{ JSONException -> 0x080d }
            r8 = r5
            r54 = r6
            double r5 = (double) r3     // Catch:{ JSONException -> 0x080d }
            double r5 = r5 / r31
            float r3 = (float) r5     // Catch:{ JSONException -> 0x080d }
            int r5 = r8.getWidth()     // Catch:{ JSONException -> 0x080d }
            double r5 = (double) r5     // Catch:{ JSONException -> 0x080d }
            double r5 = r5 / r31
            r55 = r5
            int r5 = r62.width()     // Catch:{ JSONException -> 0x080d }
            double r5 = (double) r5     // Catch:{ JSONException -> 0x080d }
            double r5 = r5 / r31
            double r5 = r55 - r5
            r55 = r5
            double r5 = (double) r3     // Catch:{ JSONException -> 0x080d }
            r63 = r5
            double r5 = r55 - r63
            float r5 = (float) r5     // Catch:{ JSONException -> 0x080d }
            int r6 = r8.getHeight()     // Catch:{ JSONException -> 0x080d }
            r55 = r5
            double r5 = (double) r6     // Catch:{ JSONException -> 0x080d }
            double r5 = r5 / r31
            r59 = r3
            int r3 = r62.height()     // Catch:{ JSONException -> 0x080d }
            r56 = r5
            double r5 = (double) r3     // Catch:{ JSONException -> 0x080d }
            double r5 = r5 / r31
            double r5 = r56 - r5
            double r5 = r5 - r63
            float r3 = (float) r5     // Catch:{ JSONException -> 0x080d }
            int r5 = r8.getWidth()     // Catch:{ JSONException -> 0x080d }
            double r5 = (double) r5     // Catch:{ JSONException -> 0x080d }
            double r5 = r5 / r31
            r56 = r3
            int r3 = r62.width()     // Catch:{ JSONException -> 0x080d }
            r57 = r5
            double r5 = (double) r3     // Catch:{ JSONException -> 0x080d }
            double r5 = r5 / r31
            double r5 = r57 + r5
            double r5 = r5 + r63
            float r3 = (float) r5     // Catch:{ JSONException -> 0x080d }
            int r5 = r8.getHeight()     // Catch:{ JSONException -> 0x080d }
            double r5 = (double) r5     // Catch:{ JSONException -> 0x080d }
            double r5 = r5 / r31
            r57 = r3
            int r3 = r62.height()     // Catch:{ JSONException -> 0x080d }
            r60 = r5
            double r5 = (double) r3     // Catch:{ JSONException -> 0x080d }
            double r5 = r5 / r31
            double r5 = r60 + r5
            double r5 = r5 + r63
            float r3 = (float) r5     // Catch:{ JSONException -> 0x080d }
            r60 = r59
            r58 = r3
            r61 = r7
            r54.drawRoundRect(r55, r56, r57, r58, r59, r60, r61)     // Catch:{ JSONException -> 0x080d }
            r3 = r61
            android.graphics.Paint$Style r5 = android.graphics.Paint.Style.STROKE     // Catch:{ JSONException -> 0x080d }
            r3.setStyle(r5)     // Catch:{ JSONException -> 0x080d }
            com.google.android.gms.maps.GoogleMap r5 = r1.f13158Q     // Catch:{ JSONException -> 0x080d }
            int r5 = r5.getMapType()     // Catch:{ JSONException -> 0x080d }
            r6 = 1
            if (r5 != r6) goto L_0x0962
            r5 = r48
            r6 = 16
            if (r5 != r6) goto L_0x095e
            r7 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r3.setColor(r7)     // Catch:{ JSONException -> 0x080d }
        L_0x095b:
            r7 = 1077936128(0x40400000, float:3.0)
            goto L_0x096b
        L_0x095e:
            r7 = -3355444(0xffffffffffcccccc, float:NaN)
            goto L_0x0967
        L_0x0962:
            r5 = r48
            r6 = 16
            goto L_0x095e
        L_0x0967:
            r3.setColor(r7)     // Catch:{ JSONException -> 0x080d }
            goto L_0x095b
        L_0x096b:
            r3.setStrokeWidth(r7)     // Catch:{ JSONException -> 0x080d }
            int r7 = r8.getWidth()     // Catch:{ JSONException -> 0x080d }
            double r6 = (double) r7     // Catch:{ JSONException -> 0x080d }
            double r6 = r6 / r31
            r61 = r3
            int r3 = r62.width()     // Catch:{ JSONException -> 0x080d }
            r55 = r6
            double r6 = (double) r3     // Catch:{ JSONException -> 0x080d }
            double r6 = r6 / r31
            double r6 = r55 - r6
            double r6 = r6 - r63
            float r3 = (float) r6     // Catch:{ JSONException -> 0x080d }
            int r6 = r8.getHeight()     // Catch:{ JSONException -> 0x080d }
            double r6 = (double) r6     // Catch:{ JSONException -> 0x080d }
            double r6 = r6 / r31
            r55 = r3
            int r3 = r62.height()     // Catch:{ JSONException -> 0x080d }
            r56 = r6
            double r6 = (double) r3     // Catch:{ JSONException -> 0x080d }
            double r6 = r6 / r31
            double r6 = r56 - r6
            double r6 = r6 - r63
            float r3 = (float) r6     // Catch:{ JSONException -> 0x080d }
            int r6 = r8.getWidth()     // Catch:{ JSONException -> 0x080d }
            double r6 = (double) r6     // Catch:{ JSONException -> 0x080d }
            double r6 = r6 / r31
            r56 = r3
            int r3 = r62.width()     // Catch:{ JSONException -> 0x080d }
            r57 = r6
            double r6 = (double) r3     // Catch:{ JSONException -> 0x080d }
            double r6 = r6 / r31
            double r6 = r57 + r6
            double r6 = r6 + r63
            float r3 = (float) r6     // Catch:{ JSONException -> 0x080d }
            int r6 = r8.getHeight()     // Catch:{ JSONException -> 0x080d }
            double r6 = (double) r6     // Catch:{ JSONException -> 0x080d }
            double r6 = r6 / r31
            r57 = r3
            int r3 = r62.height()     // Catch:{ JSONException -> 0x080d }
            r65 = r6
            double r6 = (double) r3     // Catch:{ JSONException -> 0x080d }
            double r6 = r6 / r31
            double r6 = r65 + r6
            double r6 = r6 + r63
            float r3 = (float) r6     // Catch:{ JSONException -> 0x080d }
            r60 = r59
            r58 = r3
            r54.drawRoundRect(r55, r56, r57, r58, r59, r60, r61)     // Catch:{ JSONException -> 0x080d }
            r3 = r54
            int r6 = r8.getWidth()     // Catch:{ JSONException -> 0x080d }
            double r6 = (double) r6     // Catch:{ JSONException -> 0x080d }
            double r6 = r6 / r31
            float r6 = (float) r6     // Catch:{ JSONException -> 0x080d }
            int r7 = r8.getHeight()     // Catch:{ JSONException -> 0x080d }
            r48 = r8
            double r7 = (double) r7     // Catch:{ JSONException -> 0x080d }
            double r7 = r7 / r31
            r54 = r7
            int r7 = r62.height()     // Catch:{ JSONException -> 0x080d }
            double r7 = (double) r7     // Catch:{ JSONException -> 0x080d }
            double r7 = r7 / r31
            double r7 = r54 + r7
            float r7 = (float) r7     // Catch:{ JSONException -> 0x080d }
            r3.drawText(r2, r6, r7, r4)     // Catch:{ JSONException -> 0x080d }
            com.google.android.gms.maps.GoogleMap r2 = r1.f13158Q     // Catch:{ JSONException -> 0x080d }
            int r2 = r2.getMapType()     // Catch:{ JSONException -> 0x080d }
            r3 = 1
            if (r2 != r3) goto L_0x0a0a
            r6 = 16
            if (r5 != r6) goto L_0x0a0a
            r2 = 30
            int r3 = android.graphics.Color.rgb(r2, r2, r2)     // Catch:{ JSONException -> 0x080d }
            r4.setColor(r3)     // Catch:{ JSONException -> 0x080d }
            goto L_0x0a13
        L_0x0a0a:
            r7 = 255(0xff, float:3.57E-43)
            int r2 = android.graphics.Color.rgb(r7, r7, r7)     // Catch:{ JSONException -> 0x080d }
            r4.setColor(r2)     // Catch:{ JSONException -> 0x080d }
        L_0x0a13:
            com.google.android.gms.maps.model.MarkerOptions r2 = new com.google.android.gms.maps.model.MarkerOptions     // Catch:{ JSONException -> 0x080d }
            r2.<init>()     // Catch:{ JSONException -> 0x080d }
            r3 = 1056964608(0x3f000000, float:0.5)
            r2.anchor(r3, r3)     // Catch:{ JSONException -> 0x080d }
            r2.position(r9)     // Catch:{ JSONException -> 0x080d }
            r3 = 1065353216(0x3f800000, float:1.0)
            r2.zIndex(r3)     // Catch:{ JSONException -> 0x080d }
            r3 = 4612811918334230528(0x4004000000000000, double:2.5)
            int r3 = (r34 > r3 ? 1 : (r34 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0a37
            r3 = 2131886729(0x7f120289, float:1.9408045E38)
            java.lang.String r4 = r1.getString(r3)     // Catch:{ JSONException -> 0x080d }
            r2.title(r4)     // Catch:{ JSONException -> 0x080d }
            goto L_0x0add
        L_0x0a37:
            int r3 = (r34 > r20 ? 1 : (r34 == r20 ? 0 : -1))
            if (r3 >= 0) goto L_0x0a47
            r3 = 2131886730(0x7f12028a, float:1.9408047E38)
            java.lang.String r4 = r1.getString(r3)     // Catch:{ JSONException -> 0x080d }
            r2.title(r4)     // Catch:{ JSONException -> 0x080d }
            goto L_0x0add
        L_0x0a47:
            int r3 = (r34 > r18 ? 1 : (r34 == r18 ? 0 : -1))
            if (r3 >= 0) goto L_0x0a57
            r3 = 2131886731(0x7f12028b, float:1.940805E38)
            java.lang.String r3 = r1.getString(r3)     // Catch:{ JSONException -> 0x080d }
            r2.title(r3)     // Catch:{ JSONException -> 0x080d }
            goto L_0x0add
        L_0x0a57:
            int r3 = (r34 > r16 ? 1 : (r34 == r16 ? 0 : -1))
            if (r3 >= 0) goto L_0x0a67
            r3 = 2131886733(0x7f12028d, float:1.9408053E38)
            java.lang.String r3 = r1.getString(r3)     // Catch:{ JSONException -> 0x080d }
            r2.title(r3)     // Catch:{ JSONException -> 0x080d }
            goto L_0x0add
        L_0x0a67:
            r3 = 4619004367821864960(0x401a000000000000, double:6.5)
            int r3 = (r34 > r3 ? 1 : (r34 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0a78
            r3 = 2131886734(0x7f12028e, float:1.9408055E38)
            java.lang.String r3 = r1.getString(r3)     // Catch:{ JSONException -> 0x080d }
            r2.title(r3)     // Catch:{ JSONException -> 0x080d }
            goto L_0x0add
        L_0x0a78:
            r3 = 4620130267728707584(0x401e000000000000, double:7.5)
            int r3 = (r34 > r3 ? 1 : (r34 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0a89
            r3 = 2131886735(0x7f12028f, float:1.9408057E38)
            java.lang.String r3 = r1.getString(r3)     // Catch:{ JSONException -> 0x080d }
            r2.title(r3)     // Catch:{ JSONException -> 0x080d }
            goto L_0x0add
        L_0x0a89:
            r3 = 4620974692658839552(0x4021000000000000, double:8.5)
            int r3 = (r34 > r3 ? 1 : (r34 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0a9a
            r3 = 2131886736(0x7f120290, float:1.940806E38)
            java.lang.String r3 = r1.getString(r3)     // Catch:{ JSONException -> 0x080d }
            r2.title(r3)     // Catch:{ JSONException -> 0x080d }
            goto L_0x0add
        L_0x0a9a:
            r3 = 4621537642612260864(0x4023000000000000, double:9.5)
            int r3 = (r34 > r3 ? 1 : (r34 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0aab
            r3 = 2131886732(0x7f12028c, float:1.9408051E38)
            java.lang.String r3 = r1.getString(r3)     // Catch:{ JSONException -> 0x080d }
            r2.title(r3)     // Catch:{ JSONException -> 0x080d }
            goto L_0x0add
        L_0x0aab:
            r3 = 4622100592565682176(0x4025000000000000, double:10.5)
            int r3 = (r34 > r3 ? 1 : (r34 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0abc
            r3 = 2131886737(0x7f120291, float:1.9408061E38)
            java.lang.String r3 = r1.getString(r3)     // Catch:{ JSONException -> 0x080d }
            r2.title(r3)     // Catch:{ JSONException -> 0x080d }
            goto L_0x0add
        L_0x0abc:
            r3 = 4622663542519103488(0x4027000000000000, double:11.5)
            int r3 = (r34 > r3 ? 1 : (r34 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0acd
            r3 = 2131886738(0x7f120292, float:1.9408063E38)
            java.lang.String r3 = r1.getString(r3)     // Catch:{ JSONException -> 0x080d }
            r2.title(r3)     // Catch:{ JSONException -> 0x080d }
            goto L_0x0add
        L_0x0acd:
            r3 = 4623226492472524800(0x4029000000000000, double:12.5)
            int r3 = (r34 > r3 ? 1 : (r34 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0add
            r3 = 2131886739(0x7f120293, float:1.9408065E38)
            java.lang.String r4 = r1.getString(r3)     // Catch:{ JSONException -> 0x080d }
            r2.title(r4)     // Catch:{ JSONException -> 0x080d }
        L_0x0add:
            com.google.android.gms.maps.model.BitmapDescriptor r3 = com.google.android.gms.maps.model.BitmapDescriptorFactory.fromBitmap(r48)     // Catch:{ JSONException -> 0x080d }
            r2.icon(r3)     // Catch:{ JSONException -> 0x080d }
            if (r51 == 0) goto L_0x0aeb
            float r3 = (float) r10     // Catch:{ JSONException -> 0x080d }
            r2.zIndex(r3)     // Catch:{ JSONException -> 0x080d }
            goto L_0x0af2
        L_0x0aeb:
            r3 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r10 = r10 + r3
            float r3 = (float) r10     // Catch:{ JSONException -> 0x080d }
            r2.zIndex(r3)     // Catch:{ JSONException -> 0x080d }
        L_0x0af2:
            r48.recycle()     // Catch:{ JSONException -> 0x080d }
            com.google.android.gms.maps.GoogleMap r3 = r1.f13158Q     // Catch:{ JSONException -> 0x080d }
            r3.addMarker(r2)     // Catch:{ JSONException -> 0x080d }
        L_0x0afa:
            r33 = 1
            goto L_0x0b0c
        L_0x0afd:
            r50 = r2
            r52 = r5
            r53 = r6
            r49 = r7
            r47 = r8
            r5 = r48
            r27 = 60
            goto L_0x0afa
        L_0x0b0c:
            int r2 = r50 + 1
            r48 = r5
            r4 = r44
            r3 = r45
            r11 = r46
            r8 = r47
            r7 = r49
            r5 = r52
            r6 = r53
            r29 = -1
            goto L_0x079c
        L_0x0b22:
            r44 = r4
            r46 = r11
            r5 = r48
            r27 = 60
            com.google.android.gms.maps.GoogleMap r2 = r1.f13158Q     // Catch:{ JSONException -> 0x080d }
            r2.addPolyline(r0)     // Catch:{ JSONException -> 0x080d }
        L_0x0b2f:
            r33 = 1
            goto L_0x0b43
        L_0x0b32:
            r37 = r0
            r39 = r2
            r44 = r4
            r42 = r9
            r43 = r10
            r46 = r11
            r5 = r48
            r27 = 60
            goto L_0x0b2f
        L_0x0b43:
            int r2 = r39 + 1
            r48 = r5
            r0 = r37
            r9 = r42
            r10 = r43
            r4 = r44
            r11 = r46
            r8 = 255(0xff, float:3.57E-43)
            r29 = -1
            goto L_0x072a
        L_0x0b57:
            r37 = r0
            r44 = r4
            r5 = r48
            r3 = 1
            r1.f13185d1 = r3     // Catch:{ JSONException -> 0x080d }
            goto L_0x0b79
        L_0x0b61:
            java.lang.RuntimeException r2 = new java.lang.RuntimeException
            r2.<init>(r0)
            throw r2
        L_0x0b67:
            r37 = r0
            r41 = r2
            r44 = r4
            r5 = r48
            com.google.android.gms.maps.GoogleMap r0 = r1.f13158Q
            com.finazzi.distquake.GlobeActivityAll$e r2 = new com.finazzi.distquake.GlobeActivityAll$e
            r2.<init>()
            r0.setInfoWindowAdapter(r2)
        L_0x0b79:
            r0 = r37
            goto L_0x0b83
        L_0x0b7c:
            r41 = r2
            r44 = r4
            r5 = r48
            r0 = -1
        L_0x0b83:
            int r2 = r1.f13160R
            r3 = 3
            if (r2 != r3) goto L_0x0bbb
            r2 = 2131296335(0x7f09004f, float:1.8210584E38)
            android.view.View r2 = r1.findViewById(r2)
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            r11 = 0
            r2.setVisibility(r11)
            r2 = 2131296618(0x7f09016a, float:1.8211158E38)
            android.view.View r2 = r1.findViewById(r2)
            android.widget.LinearLayout r2 = (android.widget.LinearLayout) r2
            r3 = 8
            r2.setVisibility(r3)
            r2 = 2131296991(0x7f0902df, float:1.8211914E38)
            android.view.View r2 = r1.findViewById(r2)
            android.widget.Spinner r2 = (android.widget.Spinner) r2
            r2.setVisibility(r3)
            r2 = 2131296992(0x7f0902e0, float:1.8211916E38)
            android.view.View r2 = r1.findViewById(r2)
            android.widget.Spinner r2 = (android.widget.Spinner) r2
            r2.setVisibility(r3)
        L_0x0bbb:
            double[] r2 = r1.f13164T
            if (r2 == 0) goto L_0x19db
            int r2 = r2.length
            com.google.android.gms.maps.model.Marker[] r2 = new com.google.android.gms.maps.model.Marker[r2]
            r1.f13195m0 = r2
            r2 = 0
            r3 = 0
        L_0x0bc6:
            double[] r4 = r1.f13164T
            int r4 = r4.length
            if (r2 >= r4) goto L_0x19b7
            android.app.ActivityManager$MemoryInfo r4 = r1.m1()
            if (r4 == 0) goto L_0x0be9
            boolean r4 = r4.lowMemory
            if (r4 == 0) goto L_0x0be9
            android.content.Intent r3 = new android.content.Intent
            r3.<init>()
            java.lang.String r4 = "memory"
            java.lang.String r6 = "low"
            r3.putExtra(r4, r6)
            r11 = 0
            r1.setResult(r11, r3)
            r1.finish()
            r3 = 1
        L_0x0be9:
            int r4 = r1.f13160R
            if (r4 != 0) goto L_0x0cd6
            com.google.android.gms.maps.model.LatLng r4 = new com.google.android.gms.maps.model.LatLng
            double[] r6 = r1.f13164T
            r7 = r6[r2]
            double[] r6 = r1.f13166U
            r9 = r6[r2]
            r4.<init>(r7, r9)
            com.google.android.gms.maps.model.MarkerOptions r6 = new com.google.android.gms.maps.model.MarkerOptions
            r6.<init>()
            r6.position(r4)
            r4 = 1056964608(0x3f000000, float:0.5)
            r6.anchor(r4, r4)
            android.graphics.BitmapFactory$Options r4 = new android.graphics.BitmapFactory$Options
            r4.<init>()
            r8 = 1
            r4.inMutable = r8
            double[] r7 = r1.f13168V
            r8 = r7[r2]
            r10 = 4613937818241073152(0x4008000000000000, double:3.0)
            int r7 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r7 >= 0) goto L_0x0c25
            android.content.res.Resources r7 = r1.getResources()
            r8 = 2131231367(0x7f080287, float:1.8078813E38)
            android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeResource(r7, r8, r4)
            goto L_0x0c42
        L_0x0c25:
            r10 = 4617315517961601024(0x4014000000000000, double:5.0)
            int r7 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r7 >= 0) goto L_0x0c37
            android.content.res.Resources r7 = r1.getResources()
            r8 = 2131231363(0x7f080283, float:1.8078805E38)
            android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeResource(r7, r8, r4)
            goto L_0x0c42
        L_0x0c37:
            android.content.res.Resources r7 = r1.getResources()
            r8 = 2131231361(0x7f080281, float:1.80788E38)
            android.graphics.Bitmap r4 = android.graphics.BitmapFactory.decodeResource(r7, r8, r4)
        L_0x0c42:
            android.graphics.Canvas r7 = new android.graphics.Canvas
            r7.<init>(r4)
            android.graphics.Paint r8 = new android.graphics.Paint
            r8.<init>()
            android.graphics.Paint$Align r9 = android.graphics.Paint.Align.CENTER
            r8.setTextAlign(r9)
            int r9 = r7.getHeight()
            double r9 = (double) r9
            r11 = 4616189618054758400(0x4010000000000000, double:4.0)
            double r9 = r9 / r11
            float r9 = (float) r9
            r8.setTextSize(r9)
            android.graphics.Typeface r9 = android.graphics.Typeface.DEFAULT_BOLD
            r8.setTypeface(r9)
            double[] r9 = r1.f13164T
            int r9 = r9.length
            r10 = 1
            int r9 = r9 - r10
            if (r2 != r9) goto L_0x0c6f
            r9 = -65536(0xffffffffffff0000, float:NaN)
            r8.setColor(r9)
            goto L_0x0c85
        L_0x0c6f:
            com.google.android.gms.maps.GoogleMap r9 = r1.f13158Q
            int r9 = r9.getMapType()
            if (r9 != r10) goto L_0x0c81
            r9 = 16
            if (r5 != r9) goto L_0x0c81
            r9 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r8.setColor(r9)
            goto L_0x0c85
        L_0x0c81:
            r9 = -1
            r8.setColor(r9)
        L_0x0c85:
            java.lang.String[] r9 = r1.f13192j0
            r9 = r9[r2]
            java.lang.String r9 = r1.q1(r9)
            int r10 = r7.getWidth()
            double r10 = (double) r10
            double r10 = r10 / r31
            float r10 = (float) r10
            int r11 = r7.getHeight()
            double r11 = (double) r11
            double r11 = r11 / r31
            float r13 = r8.getTextSize()
            double r13 = (double) r13
            r24 = 4608083138725491507(0x3ff3333333333333, double:1.2)
            double r13 = r13 * r24
            long r13 = java.lang.Math.round(r13)
            double r13 = (double) r13
            double r11 = r11 - r13
            float r11 = (float) r11
            r7.drawText(r9, r10, r11, r8)
            com.google.android.gms.maps.model.BitmapDescriptor r7 = com.google.android.gms.maps.model.BitmapDescriptorFactory.fromBitmap(r4)
            r6.icon(r7)
            r4.recycle()
            java.lang.String[] r4 = r1.f13192j0
            r4 = r4[r2]
            int r4 = r1.o1(r4)
            r7 = 50000(0xc350, float:7.0065E-41)
            int r7 = r7 - r4
            float r4 = (float) r7
            r6.zIndex(r4)
            com.google.android.gms.maps.model.Marker[] r4 = r1.f13195m0
            com.google.android.gms.maps.GoogleMap r7 = r1.f13158Q
            com.google.android.gms.maps.model.Marker r6 = r7.addMarker(r6)
            r4[r2] = r6
        L_0x0cd6:
            int r4 = r1.f13160R
            r8 = 1
            if (r4 != r8) goto L_0x13c5
            int r4 = r1.f13144E0
            r6 = 2131886740(0x7f120294, float:1.9408067E38)
            java.lang.String r7 = "-"
            if (r4 != 0) goto L_0x10c5
            android.util.DisplayMetrics r4 = new android.util.DisplayMetrics
            r4.<init>()
            android.view.WindowManager r8 = r1.getWindowManager()
            android.view.Display r8 = r8.getDefaultDisplay()
            r8.getMetrics(r4)
            int r8 = r4.heightPixels
            int r4 = r4.widthPixels
            int r4 = java.lang.Math.max(r8, r4)
            int r4 = r4 / 40
            int r8 = r4 / 3
            int r8 = r8 + r4
            double r9 = (double) r4
            r11 = 4612811918334230528(0x4004000000000000, double:2.5)
            double r11 = r11 * r9
            int r4 = (int) r11
            android.graphics.Bitmap$Config r11 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r4 = android.graphics.Bitmap.createBitmap(r8, r4, r11)
            android.graphics.Canvas r8 = new android.graphics.Canvas
            r8.<init>(r4)
            android.graphics.Paint r11 = new android.graphics.Paint
            r11.<init>()
            r12 = 255(0xff, float:3.57E-43)
            r11.setAlpha(r12)
            r14 = 0
            r8.drawBitmap(r4, r14, r14, r11)
            android.graphics.Paint r11 = new android.graphics.Paint
            r11.<init>()
            android.graphics.Paint$Style r12 = android.graphics.Paint.Style.FILL
            r11.setStyle(r12)
            r12 = 1
            r11.setAntiAlias(r12)
            int[] r12 = r1.f13178a0
            r12 = r12[r2]
            switch(r12) {
                case 20: goto L_0x0fb1;
                case 30: goto L_0x0f72;
                case 40: goto L_0x0f33;
                case 50: goto L_0x0ef4;
                case 60: goto L_0x0eb5;
                case 70: goto L_0x0e76;
                case 80: goto L_0x0e37;
                case 90: goto L_0x0df8;
                case 100: goto L_0x0db9;
                case 110: goto L_0x0d79;
                case 120: goto L_0x0d39;
                default: goto L_0x0d34;
            }
        L_0x0d34:
            r6 = r44
            r7 = r6
            goto L_0x0fef
        L_0x0d39:
            r12 = 16
            if (r5 != r12) goto L_0x0d4a
            java.lang.String r12 = "#ca0687"
            int r12 = android.graphics.Color.parseColor(r12)
            r11.setColor(r12)
        L_0x0d46:
            r12 = 2131886739(0x7f120293, float:1.9408065E38)
            goto L_0x0d54
        L_0x0d4a:
            java.lang.String r12 = "#380843"
            int r12 = android.graphics.Color.parseColor(r12)
            r11.setColor(r12)
            goto L_0x0d46
        L_0x0d54:
            java.lang.String r13 = r1.getString(r12)
            java.lang.String[] r7 = r13.split(r7)
            java.lang.String r6 = r1.getString(r6)
            r40 = 0
            r12 = r7[r40]
            java.lang.String r12 = r12.trim()
            r13 = 1
            java.lang.Object[] r14 = new java.lang.Object[r13]
            r14[r40] = r12
            java.lang.String r6 = java.lang.String.format(r6, r14)
            r7 = r7[r13]
            java.lang.String r7 = r7.trim()
            goto L_0x0fef
        L_0x0d79:
            r12 = 16
            if (r5 != r12) goto L_0x0d8a
            java.lang.String r12 = "#dd1154"
            int r12 = android.graphics.Color.parseColor(r12)
            r11.setColor(r12)
        L_0x0d86:
            r12 = 2131886739(0x7f120293, float:1.9408065E38)
            goto L_0x0d94
        L_0x0d8a:
            java.lang.String r12 = "#471550"
            int r12 = android.graphics.Color.parseColor(r12)
            r11.setColor(r12)
            goto L_0x0d86
        L_0x0d94:
            java.lang.String r13 = r1.getString(r12)
            java.lang.String[] r7 = r13.split(r7)
            java.lang.String r6 = r1.getString(r6)
            r40 = 0
            r12 = r7[r40]
            java.lang.String r12 = r12.trim()
            r13 = 1
            java.lang.Object[] r14 = new java.lang.Object[r13]
            r14[r40] = r12
            java.lang.String r6 = java.lang.String.format(r6, r14)
            r7 = r7[r13]
            java.lang.String r7 = r7.trim()
            goto L_0x0fef
        L_0x0db9:
            r12 = 16
            if (r5 != r12) goto L_0x0dc7
            java.lang.String r12 = "#ca2726"
            int r12 = android.graphics.Color.parseColor(r12)
            r11.setColor(r12)
            goto L_0x0dd0
        L_0x0dc7:
            java.lang.String r12 = "#560101"
            int r12 = android.graphics.Color.parseColor(r12)
            r11.setColor(r12)
        L_0x0dd0:
            r12 = 2131886737(0x7f120291, float:1.9408061E38)
            java.lang.String r12 = r1.getString(r12)
            java.lang.String[] r7 = r12.split(r7)
            java.lang.String r6 = r1.getString(r6)
            r40 = 0
            r12 = r7[r40]
            java.lang.String r12 = r12.trim()
            r13 = 1
            java.lang.Object[] r14 = new java.lang.Object[r13]
            r14[r40] = r12
            java.lang.String r6 = java.lang.String.format(r6, r14)
            r7 = r7[r13]
            java.lang.String r7 = r7.trim()
            goto L_0x0fef
        L_0x0df8:
            r12 = 16
            if (r5 != r12) goto L_0x0e06
            java.lang.String r12 = "#d15424"
            int r12 = android.graphics.Color.parseColor(r12)
            r11.setColor(r12)
            goto L_0x0e0f
        L_0x0e06:
            java.lang.String r12 = "#700000"
            int r12 = android.graphics.Color.parseColor(r12)
            r11.setColor(r12)
        L_0x0e0f:
            r12 = 2131886732(0x7f12028c, float:1.9408051E38)
            java.lang.String r12 = r1.getString(r12)
            java.lang.String[] r7 = r12.split(r7)
            java.lang.String r6 = r1.getString(r6)
            r40 = 0
            r12 = r7[r40]
            java.lang.String r12 = r12.trim()
            r13 = 1
            java.lang.Object[] r14 = new java.lang.Object[r13]
            r14[r40] = r12
            java.lang.String r6 = java.lang.String.format(r6, r14)
            r7 = r7[r13]
            java.lang.String r7 = r7.trim()
            goto L_0x0fef
        L_0x0e37:
            r12 = 16
            if (r5 != r12) goto L_0x0e45
            java.lang.String r12 = "#dd8725"
            int r12 = android.graphics.Color.parseColor(r12)
            r11.setColor(r12)
            goto L_0x0e4e
        L_0x0e45:
            java.lang.String r12 = "#7c2600"
            int r12 = android.graphics.Color.parseColor(r12)
            r11.setColor(r12)
        L_0x0e4e:
            r12 = 2131886736(0x7f120290, float:1.940806E38)
            java.lang.String r12 = r1.getString(r12)
            java.lang.String[] r7 = r12.split(r7)
            java.lang.String r6 = r1.getString(r6)
            r40 = 0
            r12 = r7[r40]
            java.lang.String r12 = r12.trim()
            r13 = 1
            java.lang.Object[] r14 = new java.lang.Object[r13]
            r14[r40] = r12
            java.lang.String r6 = java.lang.String.format(r6, r14)
            r7 = r7[r13]
            java.lang.String r7 = r7.trim()
            goto L_0x0fef
        L_0x0e76:
            r12 = 16
            if (r5 != r12) goto L_0x0e84
            java.lang.String r12 = "#efc30f"
            int r12 = android.graphics.Color.parseColor(r12)
            r11.setColor(r12)
            goto L_0x0e8d
        L_0x0e84:
            java.lang.String r12 = "#8e6200"
            int r12 = android.graphics.Color.parseColor(r12)
            r11.setColor(r12)
        L_0x0e8d:
            r12 = 2131886735(0x7f12028f, float:1.9408057E38)
            java.lang.String r12 = r1.getString(r12)
            java.lang.String[] r7 = r12.split(r7)
            java.lang.String r6 = r1.getString(r6)
            r40 = 0
            r12 = r7[r40]
            java.lang.String r12 = r12.trim()
            r13 = 1
            java.lang.Object[] r14 = new java.lang.Object[r13]
            r14[r40] = r12
            java.lang.String r6 = java.lang.String.format(r6, r14)
            r7 = r7[r13]
            java.lang.String r7 = r7.trim()
            goto L_0x0fef
        L_0x0eb5:
            r12 = 16
            if (r5 != r12) goto L_0x0ec3
            java.lang.String r12 = "#f5ec23"
            int r12 = android.graphics.Color.parseColor(r12)
            r11.setColor(r12)
            goto L_0x0ecc
        L_0x0ec3:
            java.lang.String r12 = "#948b00"
            int r12 = android.graphics.Color.parseColor(r12)
            r11.setColor(r12)
        L_0x0ecc:
            r12 = 2131886734(0x7f12028e, float:1.9408055E38)
            java.lang.String r12 = r1.getString(r12)
            java.lang.String[] r7 = r12.split(r7)
            java.lang.String r6 = r1.getString(r6)
            r40 = 0
            r12 = r7[r40]
            java.lang.String r12 = r12.trim()
            r13 = 1
            java.lang.Object[] r14 = new java.lang.Object[r13]
            r14[r40] = r12
            java.lang.String r6 = java.lang.String.format(r6, r14)
            r7 = r7[r13]
            java.lang.String r7 = r7.trim()
            goto L_0x0fef
        L_0x0ef4:
            r12 = 16
            if (r5 != r12) goto L_0x0f02
            java.lang.String r12 = "#98c890"
            int r12 = android.graphics.Color.parseColor(r12)
            r11.setColor(r12)
            goto L_0x0f0b
        L_0x0f02:
            java.lang.String r12 = "#37672f"
            int r12 = android.graphics.Color.parseColor(r12)
            r11.setColor(r12)
        L_0x0f0b:
            r12 = 2131886733(0x7f12028d, float:1.9408053E38)
            java.lang.String r12 = r1.getString(r12)
            java.lang.String[] r7 = r12.split(r7)
            java.lang.String r6 = r1.getString(r6)
            r40 = 0
            r12 = r7[r40]
            java.lang.String r12 = r12.trim()
            r13 = 1
            java.lang.Object[] r14 = new java.lang.Object[r13]
            r14[r40] = r12
            java.lang.String r6 = java.lang.String.format(r6, r14)
            r7 = r7[r13]
            java.lang.String r7 = r7.trim()
            goto L_0x0fef
        L_0x0f33:
            r12 = 16
            if (r5 != r12) goto L_0x0f41
            java.lang.String r12 = "#abd7e3"
            int r12 = android.graphics.Color.parseColor(r12)
            r11.setColor(r12)
            goto L_0x0f4a
        L_0x0f41:
            java.lang.String r12 = "#4a7682"
            int r12 = android.graphics.Color.parseColor(r12)
            r11.setColor(r12)
        L_0x0f4a:
            r12 = 2131886731(0x7f12028b, float:1.940805E38)
            java.lang.String r12 = r1.getString(r12)
            java.lang.String[] r7 = r12.split(r7)
            java.lang.String r6 = r1.getString(r6)
            r40 = 0
            r12 = r7[r40]
            java.lang.String r12 = r12.trim()
            r13 = 1
            java.lang.Object[] r14 = new java.lang.Object[r13]
            r14[r40] = r12
            java.lang.String r6 = java.lang.String.format(r6, r14)
            r7 = r7[r13]
            java.lang.String r7 = r7.trim()
            goto L_0x0fef
        L_0x0f72:
            r12 = 16
            if (r5 != r12) goto L_0x0f83
            java.lang.String r12 = "#bfc4d9"
            int r12 = android.graphics.Color.parseColor(r12)
            r11.setColor(r12)
        L_0x0f7f:
            r12 = 2131886730(0x7f12028a, float:1.9408047E38)
            goto L_0x0f8d
        L_0x0f83:
            java.lang.String r12 = "#5e6378"
            int r12 = android.graphics.Color.parseColor(r12)
            r11.setColor(r12)
            goto L_0x0f7f
        L_0x0f8d:
            java.lang.String r13 = r1.getString(r12)
            java.lang.String[] r7 = r13.split(r7)
            java.lang.String r6 = r1.getString(r6)
            r40 = 0
            r12 = r7[r40]
            java.lang.String r12 = r12.trim()
            r13 = 1
            java.lang.Object[] r14 = new java.lang.Object[r13]
            r14[r40] = r12
            java.lang.String r6 = java.lang.String.format(r6, r14)
            r7 = r7[r13]
            java.lang.String r7 = r7.trim()
            goto L_0x0fef
        L_0x0fb1:
            r12 = 16
            if (r5 != r12) goto L_0x0fc2
            java.lang.String r12 = "#edeff3"
            int r12 = android.graphics.Color.parseColor(r12)
            r11.setColor(r12)
        L_0x0fbe:
            r12 = 2131886729(0x7f120289, float:1.9408045E38)
            goto L_0x0fcc
        L_0x0fc2:
            java.lang.String r12 = "#8c8e92"
            int r12 = android.graphics.Color.parseColor(r12)
            r11.setColor(r12)
            goto L_0x0fbe
        L_0x0fcc:
            java.lang.String r13 = r1.getString(r12)
            java.lang.String[] r7 = r13.split(r7)
            java.lang.String r6 = r1.getString(r6)
            r40 = 0
            r12 = r7[r40]
            java.lang.String r12 = r12.trim()
            r13 = 1
            java.lang.Object[] r14 = new java.lang.Object[r13]
            r14[r40] = r12
            java.lang.String r6 = java.lang.String.format(r6, r14)
            r7 = r7[r13]
            java.lang.String r7 = r7.trim()
        L_0x0fef:
            int r12 = r4.getWidth()
            double r12 = (double) r12
            double r12 = r12 / r31
            float r12 = (float) r12
            int r13 = r4.getHeight()
            double r13 = (double) r13
            double r13 = r13 / r31
            float r13 = (float) r13
            double r9 = r9 / r31
            float r9 = (float) r9
            r8.drawCircle(r12, r13, r9, r11)
            android.graphics.Paint$Style r10 = android.graphics.Paint.Style.STROKE
            r11.setStyle(r10)
            r10 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r11.setColor(r10)
            r10 = 1077936128(0x40400000, float:3.0)
            r11.setStrokeWidth(r10)
            int r10 = r4.getWidth()
            double r12 = (double) r10
            double r12 = r12 / r31
            float r10 = (float) r12
            int r12 = r4.getHeight()
            double r12 = (double) r12
            double r12 = r12 / r31
            float r12 = (float) r12
            r8.drawCircle(r10, r12, r9, r11)
            android.graphics.Paint r9 = new android.graphics.Paint
            r9.<init>()
            android.graphics.Paint$Align r10 = android.graphics.Paint.Align.CENTER
            r9.setTextAlign(r10)
            int r10 = r8.getWidth()
            double r10 = (double) r10
            double r10 = r10 / r31
            float r10 = (float) r10
            r9.setTextSize(r10)
            android.graphics.Typeface r10 = android.graphics.Typeface.DEFAULT_BOLD
            r9.setTypeface(r10)
            com.google.android.gms.maps.GoogleMap r10 = r1.f13158Q
            int r10 = r10.getMapType()
            r13 = 1
            if (r10 != r13) goto L_0x1054
            r12 = 16
            if (r5 != r12) goto L_0x1054
            r10 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r9.setColor(r10)
            goto L_0x105a
        L_0x1054:
            r10 = -3355444(0xffffffffffcccccc, float:NaN)
            r9.setColor(r10)
        L_0x105a:
            java.lang.String[] r10 = r1.f13192j0
            r10 = r10[r2]
            java.lang.String r10 = r1.q1(r10)
            int r11 = r8.getWidth()
            double r11 = (double) r11
            double r11 = r11 / r31
            float r11 = (float) r11
            int r12 = r8.getHeight()
            double r12 = (double) r12
            double r12 = r12 / r31
            float r12 = (float) r12
            float r13 = r9.getTextSize()
            double r13 = (double) r13
            r24 = 4607857958744122982(0x3ff2666666666666, double:1.15)
            double r13 = r13 * r24
            long r13 = java.lang.Math.round(r13)
            float r13 = (float) r13
            float r12 = r12 - r13
            r8.drawText(r10, r11, r12, r9)
            com.google.android.gms.maps.model.LatLng r8 = new com.google.android.gms.maps.model.LatLng
            double[] r9 = r1.f13164T
            r10 = r9[r2]
            double[] r9 = r1.f13166U
            r12 = r9[r2]
            r8.<init>(r10, r12)
            com.google.android.gms.maps.model.MarkerOptions r9 = new com.google.android.gms.maps.model.MarkerOptions
            r9.<init>()
            r9.title(r6)
            r9.snippet(r7)
            r6 = 1056964608(0x3f000000, float:0.5)
            r9.anchor(r6, r6)
            r9.position(r8)
            int[] r6 = r1.f13178a0
            r6 = r6[r2]
            float r6 = (float) r6
            r9.zIndex(r6)
            com.google.android.gms.maps.model.BitmapDescriptor r6 = com.google.android.gms.maps.model.BitmapDescriptorFactory.fromBitmap(r4)
            r9.icon(r6)
            r4.recycle()
            com.google.android.gms.maps.model.Marker[] r4 = r1.f13195m0
            com.google.android.gms.maps.GoogleMap r6 = r1.f13158Q
            com.google.android.gms.maps.model.Marker r6 = r6.addMarker(r9)
            r4[r2] = r6
            goto L_0x13c5
        L_0x10c5:
            android.util.DisplayMetrics r4 = new android.util.DisplayMetrics
            r4.<init>()
            android.view.WindowManager r8 = r1.getWindowManager()
            android.view.Display r8 = r8.getDefaultDisplay()
            r8.getMetrics(r4)
            int r8 = r4.heightPixels
            int r4 = r4.widthPixels
            int r4 = java.lang.Math.max(r8, r4)
            int r4 = r4 / 70
            int r8 = r4 / 5
            int r8 = r8 + r4
            android.graphics.Bitmap$Config r9 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r8 = android.graphics.Bitmap.createBitmap(r8, r8, r9)
            android.graphics.Canvas r9 = new android.graphics.Canvas
            r9.<init>(r8)
            android.graphics.Paint r10 = new android.graphics.Paint
            r10.<init>()
            r12 = 255(0xff, float:3.57E-43)
            r10.setAlpha(r12)
            r14 = 0
            r9.drawBitmap(r8, r14, r14, r10)
            android.graphics.Paint r10 = new android.graphics.Paint
            r10.<init>()
            android.graphics.Paint$Style r11 = android.graphics.Paint.Style.FILL
            r10.setStyle(r11)
            r13 = 1
            r10.setAntiAlias(r13)
            int[] r11 = r1.f13178a0
            r11 = r11[r2]
            switch(r11) {
                case 20: goto L_0x131b;
                case 30: goto L_0x12e7;
                case 40: goto L_0x12b3;
                case 50: goto L_0x127f;
                case 60: goto L_0x124b;
                case 70: goto L_0x1217;
                case 80: goto L_0x11e3;
                case 90: goto L_0x11af;
                case 100: goto L_0x117b;
                case 110: goto L_0x114b;
                case 120: goto L_0x111b;
                default: goto L_0x1110;
            }
        L_0x1110:
            r6 = r44
            r7 = r6
        L_0x1113:
            r12 = 2131886739(0x7f120293, float:1.9408065E38)
        L_0x1116:
            r14 = 2131886729(0x7f120289, float:1.9408045E38)
            goto L_0x1350
        L_0x111b:
            java.lang.String r11 = "#ca0687"
            int r11 = android.graphics.Color.parseColor(r11)
            r10.setColor(r11)
            r12 = 2131886739(0x7f120293, float:1.9408065E38)
            java.lang.String r11 = r1.getString(r12)
            java.lang.String[] r7 = r11.split(r7)
            java.lang.String r6 = r1.getString(r6)
            r40 = 0
            r11 = r7[r40]
            java.lang.String r11 = r11.trim()
            r13 = 1
            java.lang.Object[] r12 = new java.lang.Object[r13]
            r12[r40] = r11
            java.lang.String r6 = java.lang.String.format(r6, r12)
            r7 = r7[r13]
            java.lang.String r7 = r7.trim()
            goto L_0x1113
        L_0x114b:
            r13 = 1
            r40 = 0
            java.lang.String r11 = "#dd1154"
            int r11 = android.graphics.Color.parseColor(r11)
            r10.setColor(r11)
            r12 = 2131886739(0x7f120293, float:1.9408065E38)
            java.lang.String r11 = r1.getString(r12)
            java.lang.String[] r7 = r11.split(r7)
            java.lang.String r6 = r1.getString(r6)
            r11 = r7[r40]
            java.lang.String r11 = r11.trim()
            java.lang.Object[] r14 = new java.lang.Object[r13]
            r14[r40] = r11
            java.lang.String r6 = java.lang.String.format(r6, r14)
            r7 = r7[r13]
            java.lang.String r7 = r7.trim()
            goto L_0x1116
        L_0x117b:
            r12 = 2131886739(0x7f120293, float:1.9408065E38)
            java.lang.String r11 = "#ca2726"
            int r11 = android.graphics.Color.parseColor(r11)
            r10.setColor(r11)
            r11 = 2131886737(0x7f120291, float:1.9408061E38)
            java.lang.String r11 = r1.getString(r11)
            java.lang.String[] r7 = r11.split(r7)
            java.lang.String r6 = r1.getString(r6)
            r40 = 0
            r11 = r7[r40]
            java.lang.String r11 = r11.trim()
            r13 = 1
            java.lang.Object[] r14 = new java.lang.Object[r13]
            r14[r40] = r11
            java.lang.String r6 = java.lang.String.format(r6, r14)
            r7 = r7[r13]
            java.lang.String r7 = r7.trim()
            goto L_0x1116
        L_0x11af:
            r12 = 2131886739(0x7f120293, float:1.9408065E38)
            java.lang.String r11 = "#d15424"
            int r11 = android.graphics.Color.parseColor(r11)
            r10.setColor(r11)
            r11 = 2131886732(0x7f12028c, float:1.9408051E38)
            java.lang.String r11 = r1.getString(r11)
            java.lang.String[] r7 = r11.split(r7)
            java.lang.String r6 = r1.getString(r6)
            r40 = 0
            r11 = r7[r40]
            java.lang.String r11 = r11.trim()
            r13 = 1
            java.lang.Object[] r14 = new java.lang.Object[r13]
            r14[r40] = r11
            java.lang.String r6 = java.lang.String.format(r6, r14)
            r7 = r7[r13]
            java.lang.String r7 = r7.trim()
            goto L_0x1116
        L_0x11e3:
            r12 = 2131886739(0x7f120293, float:1.9408065E38)
            java.lang.String r11 = "#dd8725"
            int r11 = android.graphics.Color.parseColor(r11)
            r10.setColor(r11)
            r11 = 2131886736(0x7f120290, float:1.940806E38)
            java.lang.String r11 = r1.getString(r11)
            java.lang.String[] r7 = r11.split(r7)
            java.lang.String r6 = r1.getString(r6)
            r40 = 0
            r11 = r7[r40]
            java.lang.String r11 = r11.trim()
            r13 = 1
            java.lang.Object[] r14 = new java.lang.Object[r13]
            r14[r40] = r11
            java.lang.String r6 = java.lang.String.format(r6, r14)
            r7 = r7[r13]
            java.lang.String r7 = r7.trim()
            goto L_0x1116
        L_0x1217:
            r12 = 2131886739(0x7f120293, float:1.9408065E38)
            java.lang.String r11 = "#efc30f"
            int r11 = android.graphics.Color.parseColor(r11)
            r10.setColor(r11)
            r11 = 2131886735(0x7f12028f, float:1.9408057E38)
            java.lang.String r11 = r1.getString(r11)
            java.lang.String[] r7 = r11.split(r7)
            java.lang.String r6 = r1.getString(r6)
            r40 = 0
            r11 = r7[r40]
            java.lang.String r11 = r11.trim()
            r13 = 1
            java.lang.Object[] r14 = new java.lang.Object[r13]
            r14[r40] = r11
            java.lang.String r6 = java.lang.String.format(r6, r14)
            r7 = r7[r13]
            java.lang.String r7 = r7.trim()
            goto L_0x1116
        L_0x124b:
            r12 = 2131886739(0x7f120293, float:1.9408065E38)
            java.lang.String r11 = "#f5ec23"
            int r11 = android.graphics.Color.parseColor(r11)
            r10.setColor(r11)
            r11 = 2131886734(0x7f12028e, float:1.9408055E38)
            java.lang.String r11 = r1.getString(r11)
            java.lang.String[] r7 = r11.split(r7)
            java.lang.String r6 = r1.getString(r6)
            r40 = 0
            r11 = r7[r40]
            java.lang.String r11 = r11.trim()
            r13 = 1
            java.lang.Object[] r14 = new java.lang.Object[r13]
            r14[r40] = r11
            java.lang.String r6 = java.lang.String.format(r6, r14)
            r7 = r7[r13]
            java.lang.String r7 = r7.trim()
            goto L_0x1116
        L_0x127f:
            r12 = 2131886739(0x7f120293, float:1.9408065E38)
            java.lang.String r11 = "#98c890"
            int r11 = android.graphics.Color.parseColor(r11)
            r10.setColor(r11)
            r11 = 2131886733(0x7f12028d, float:1.9408053E38)
            java.lang.String r11 = r1.getString(r11)
            java.lang.String[] r7 = r11.split(r7)
            java.lang.String r6 = r1.getString(r6)
            r40 = 0
            r11 = r7[r40]
            java.lang.String r11 = r11.trim()
            r13 = 1
            java.lang.Object[] r14 = new java.lang.Object[r13]
            r14[r40] = r11
            java.lang.String r6 = java.lang.String.format(r6, r14)
            r7 = r7[r13]
            java.lang.String r7 = r7.trim()
            goto L_0x1116
        L_0x12b3:
            r12 = 2131886739(0x7f120293, float:1.9408065E38)
            java.lang.String r11 = "#abd7e3"
            int r11 = android.graphics.Color.parseColor(r11)
            r10.setColor(r11)
            r11 = 2131886731(0x7f12028b, float:1.940805E38)
            java.lang.String r11 = r1.getString(r11)
            java.lang.String[] r7 = r11.split(r7)
            java.lang.String r6 = r1.getString(r6)
            r40 = 0
            r11 = r7[r40]
            java.lang.String r11 = r11.trim()
            r13 = 1
            java.lang.Object[] r14 = new java.lang.Object[r13]
            r14[r40] = r11
            java.lang.String r6 = java.lang.String.format(r6, r14)
            r7 = r7[r13]
            java.lang.String r7 = r7.trim()
            goto L_0x1116
        L_0x12e7:
            r12 = 2131886739(0x7f120293, float:1.9408065E38)
            r13 = 1
            r40 = 0
            java.lang.String r11 = "#bfc4d9"
            int r11 = android.graphics.Color.parseColor(r11)
            r10.setColor(r11)
            r11 = 2131886730(0x7f12028a, float:1.9408047E38)
            java.lang.String r14 = r1.getString(r11)
            java.lang.String[] r7 = r14.split(r7)
            java.lang.String r6 = r1.getString(r6)
            r14 = r7[r40]
            java.lang.String r14 = r14.trim()
            java.lang.Object[] r15 = new java.lang.Object[r13]
            r15[r40] = r14
            java.lang.String r6 = java.lang.String.format(r6, r15)
            r7 = r7[r13]
            java.lang.String r7 = r7.trim()
            goto L_0x1116
        L_0x131b:
            r11 = 2131886730(0x7f12028a, float:1.9408047E38)
            r12 = 2131886739(0x7f120293, float:1.9408065E38)
            r13 = 1
            r40 = 0
            java.lang.String r14 = "#edeff3"
            int r14 = android.graphics.Color.parseColor(r14)
            r10.setColor(r14)
            r14 = 2131886729(0x7f120289, float:1.9408045E38)
            java.lang.String r15 = r1.getString(r14)
            java.lang.String[] r7 = r15.split(r7)
            java.lang.String r6 = r1.getString(r6)
            r15 = r7[r40]
            java.lang.String r15 = r15.trim()
            java.lang.Object[] r11 = new java.lang.Object[r13]
            r11[r40] = r15
            java.lang.String r6 = java.lang.String.format(r6, r11)
            r7 = r7[r13]
            java.lang.String r7 = r7.trim()
        L_0x1350:
            int r11 = r8.getWidth()
            double r12 = (double) r11
            double r12 = r12 / r31
            float r11 = (float) r12
            int r12 = r8.getHeight()
            double r12 = (double) r12
            double r12 = r12 / r31
            float r12 = (float) r12
            double r14 = (double) r4
            double r14 = r14 / r31
            float r4 = (float) r14
            r9.drawCircle(r11, r12, r4, r10)
            android.graphics.Paint$Style r11 = android.graphics.Paint.Style.STROKE
            r10.setStyle(r11)
            r11 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r10.setColor(r11)
            r11 = 1077936128(0x40400000, float:3.0)
            r10.setStrokeWidth(r11)
            int r11 = r8.getWidth()
            double r11 = (double) r11
            double r11 = r11 / r31
            float r11 = (float) r11
            int r12 = r8.getHeight()
            double r12 = (double) r12
            double r12 = r12 / r31
            float r12 = (float) r12
            r9.drawCircle(r11, r12, r4, r10)
            com.google.android.gms.maps.model.LatLng r4 = new com.google.android.gms.maps.model.LatLng
            double[] r9 = r1.f13164T
            r10 = r9[r2]
            double[] r9 = r1.f13166U
            r12 = r9[r2]
            r4.<init>(r10, r12)
            com.google.android.gms.maps.model.MarkerOptions r9 = new com.google.android.gms.maps.model.MarkerOptions
            r9.<init>()
            r9.title(r6)
            r9.snippet(r7)
            r6 = 1056964608(0x3f000000, float:0.5)
            r9.anchor(r6, r6)
            r9.position(r4)
            int[] r4 = r1.f13178a0
            r4 = r4[r2]
            float r4 = (float) r4
            r9.zIndex(r4)
            com.google.android.gms.maps.model.BitmapDescriptor r4 = com.google.android.gms.maps.model.BitmapDescriptorFactory.fromBitmap(r8)
            r9.icon(r4)
            r8.recycle()
            com.google.android.gms.maps.model.Marker[] r4 = r1.f13195m0
            com.google.android.gms.maps.GoogleMap r6 = r1.f13158Q
            com.google.android.gms.maps.model.Marker r6 = r6.addMarker(r9)
            r4[r2] = r6
        L_0x13c5:
            int r4 = r1.f13160R
            r11 = 2
            if (r4 != r11) goto L_0x13d1
            boolean r4 = r1.f13185d1
            if (r4 == 0) goto L_0x13e1
            if (r2 != r0) goto L_0x13d1
            goto L_0x13e1
        L_0x13d1:
            r8 = 1056964608(0x3f000000, float:0.5)
            r12 = 255(0xff, float:3.57E-43)
            r13 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r14 = 0
            r15 = -3355444(0xffffffffffcccccc, float:NaN)
            r30 = 3
        L_0x13dd:
            r33 = 1
            goto L_0x19b3
        L_0x13e1:
            int r4 = r1.f13143D0
            r6 = 200(0xc8, float:2.8E-43)
            if (r4 != 0) goto L_0x1668
            android.util.DisplayMetrics r4 = new android.util.DisplayMetrics
            r4.<init>()
            android.view.WindowManager r7 = r1.getWindowManager()
            android.view.Display r7 = r7.getDefaultDisplay()
            r7.getMetrics(r4)
            int r7 = r4.heightPixels
            int r4 = r4.widthPixels
            int r4 = java.lang.Math.max(r7, r4)
            int r4 = r4 / 70
            android.graphics.Paint r7 = new android.graphics.Paint
            r7.<init>()
            android.graphics.Paint$Align r8 = android.graphics.Paint.Align.CENTER
            r7.setTextAlign(r8)
            float r9 = (float) r4
            r7.setTextSize(r9)
            r7.setTextAlign(r8)
            android.graphics.Typeface r8 = android.graphics.Typeface.DEFAULT_BOLD
            r7.setTypeface(r8)
            r13 = 1
            r7.setAntiAlias(r13)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "M"
            r8.append(r9)
            double[] r9 = r1.f13168V
            r10 = r9[r2]
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            android.graphics.Rect r9 = new android.graphics.Rect
            r9.<init>()
            int r10 = r8.length()
            r11 = 0
            r7.getTextBounds(r8, r11, r10, r9)
            android.graphics.Rect r10 = new android.graphics.Rect
            r10.<init>()
            java.lang.String[] r12 = r1.f13191i0
            r12 = r12[r2]
            int r13 = r12.length()
            r7.getTextBounds(r12, r11, r13, r10)
            int r11 = r9.width()
            r30 = 3
            int r11 = r11 * 3
            int r12 = r9.height()
            int r12 = r12 * 5
            android.graphics.Bitmap$Config r13 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r11 = android.graphics.Bitmap.createBitmap(r11, r12, r13)
            android.graphics.Canvas r12 = new android.graphics.Canvas
            r12.<init>(r11)
            android.graphics.Paint r13 = new android.graphics.Paint
            r13.<init>()
            r14 = 255(0xff, float:3.57E-43)
            r13.setAlpha(r14)
            r14 = 0
            r12.drawBitmap(r11, r14, r14, r13)
            android.graphics.Paint r13 = new android.graphics.Paint
            r13.<init>()
            r14 = 1
            r13.setAntiAlias(r14)
            android.graphics.Paint$Style r14 = android.graphics.Paint.Style.FILL
            r13.setStyle(r14)
            r14 = -1
            r13.setColor(r14)
            double r14 = (double) r4
            double r14 = r14 / r31
            float r4 = (float) r14
            int r14 = r11.getWidth()
            r38 = 2
            int r14 = r14 / 2
            int r15 = r9.width()
            int r15 = r15 / 2
            int r14 = r14 - r15
            float r14 = (float) r14
            float r51 = r14 - r4
            int r14 = r11.getHeight()
            int r14 = r14 / 2
            int r15 = r9.height()
            int r15 = r15 / 2
            int r14 = r14 - r15
            float r14 = (float) r14
            float r52 = r14 - r4
            int r14 = r11.getWidth()
            int r14 = r14 / 2
            int r15 = r9.width()
            int r15 = r15 / 2
            int r14 = r14 + r15
            float r14 = (float) r14
            float r53 = r14 + r4
            int r14 = r11.getHeight()
            int r14 = r14 / 2
            int r15 = r9.height()
            int r15 = r15 / 2
            int r14 = r14 + r15
            float r14 = (float) r14
            float r54 = r14 + r4
            r56 = r4
            r55 = r4
            r50 = r12
            r57 = r13
            r50.drawRoundRect(r51, r52, r53, r54, r55, r56, r57)
            r4 = r57
            android.graphics.Paint$Style r12 = android.graphics.Paint.Style.STROKE
            r4.setStyle(r12)
            if (r2 != r0) goto L_0x14f2
            r12 = 180(0xb4, float:2.52E-43)
            r13 = 0
            r14 = 255(0xff, float:3.57E-43)
            int r12 = android.graphics.Color.argb(r14, r12, r13, r13)
            r4.setColor(r12)
            r12 = 1082130432(0x40800000, float:4.0)
            r4.setStrokeWidth(r12)
            goto L_0x1511
        L_0x14f2:
            com.google.android.gms.maps.GoogleMap r12 = r1.f13158Q
            int r12 = r12.getMapType()
            r13 = 1
            if (r12 != r13) goto L_0x1507
            r12 = 16
            if (r5 != r12) goto L_0x1507
            r12 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r4.setColor(r12)
        L_0x1504:
            r12 = 1077936128(0x40400000, float:3.0)
            goto L_0x150e
        L_0x1507:
            r12 = -3355444(0xffffffffffcccccc, float:NaN)
            r4.setColor(r12)
            goto L_0x1504
        L_0x150e:
            r4.setStrokeWidth(r12)
        L_0x1511:
            int r12 = r11.getWidth()
            r38 = 2
            int r12 = r12 / 2
            int r13 = r9.width()
            int r13 = r13 / 2
            int r12 = r12 - r13
            float r12 = (float) r12
            float r51 = r12 - r55
            int r12 = r11.getHeight()
            int r12 = r12 / 2
            int r13 = r9.height()
            int r13 = r13 / 2
            int r12 = r12 - r13
            float r12 = (float) r12
            float r52 = r12 - r55
            int r12 = r11.getWidth()
            int r12 = r12 / 2
            int r13 = r9.width()
            int r13 = r13 / 2
            int r12 = r12 + r13
            float r12 = (float) r12
            float r53 = r12 + r55
            int r12 = r11.getHeight()
            int r12 = r12 / 2
            int r13 = r9.height()
            int r13 = r13 / 2
            int r12 = r12 + r13
            float r12 = (float) r12
            float r54 = r12 + r55
            r56 = r55
            r57 = r4
            r50.drawRoundRect(r51, r52, r53, r54, r55, r56, r57)
            r4 = r50
            double[] r12 = r1.f13168V
            r13 = r12[r2]
            int r12 = (r13 > r31 ? 1 : (r13 == r31 ? 0 : -1))
            if (r12 >= 0) goto L_0x156d
            r12 = 0
            int r6 = android.graphics.Color.rgb(r12, r6, r6)
            r7.setColor(r6)
            goto L_0x159d
        L_0x156d:
            r12 = 0
            int r15 = (r13 > r20 ? 1 : (r13 == r20 ? 0 : -1))
            if (r15 >= 0) goto L_0x157a
            int r6 = android.graphics.Color.rgb(r12, r6, r12)
            r7.setColor(r6)
            goto L_0x159d
        L_0x157a:
            int r15 = (r13 > r18 ? 1 : (r13 == r18 ? 0 : -1))
            if (r15 >= 0) goto L_0x158a
            r6 = 240(0xf0, float:3.36E-43)
            r13 = 190(0xbe, float:2.66E-43)
            int r6 = android.graphics.Color.rgb(r6, r13, r12)
            r7.setColor(r6)
            goto L_0x159d
        L_0x158a:
            int r13 = (r13 > r16 ? 1 : (r13 == r16 ? 0 : -1))
            if (r13 >= 0) goto L_0x1596
            int r6 = android.graphics.Color.rgb(r6, r12, r12)
            r7.setColor(r6)
            goto L_0x159d
        L_0x1596:
            int r6 = android.graphics.Color.rgb(r6, r12, r6)
            r7.setColor(r6)
        L_0x159d:
            int r6 = r11.getWidth()
            double r12 = (double) r6
            double r12 = r12 / r31
            float r6 = (float) r12
            int r12 = r11.getHeight()
            double r12 = (double) r12
            double r12 = r12 / r31
            int r9 = r9.height()
            double r14 = (double) r9
            double r14 = r14 / r31
            double r12 = r12 + r14
            float r9 = (float) r12
            r4.drawText(r8, r6, r9, r7)
            com.google.android.gms.maps.GoogleMap r6 = r1.f13158Q
            int r6 = r6.getMapType()
            r13 = 1
            if (r6 != r13) goto L_0x15cf
            r12 = 16
            if (r5 != r12) goto L_0x15cf
            r8 = 30
            int r6 = android.graphics.Color.rgb(r8, r8, r8)
            r7.setColor(r6)
            goto L_0x15da
        L_0x15cf:
            r8 = 30
            r12 = 255(0xff, float:3.57E-43)
            int r6 = android.graphics.Color.rgb(r12, r12, r12)
            r7.setColor(r6)
        L_0x15da:
            java.lang.String[] r6 = r1.f13191i0
            r6 = r6[r2]
            int r9 = r11.getWidth()
            double r12 = (double) r9
            double r12 = r12 / r31
            float r9 = (float) r12
            int r12 = r11.getHeight()
            double r12 = (double) r12
            double r12 = r12 / r31
            int r14 = r10.height()
            double r14 = (double) r14
            double r14 = r14 / r31
            double r12 = r12 + r14
            r26 = 1077936128(0x40400000, float:3.0)
            float r14 = r55 * r26
            double r14 = (double) r14
            double r12 = r12 - r14
            float r12 = (float) r12
            r4.drawText(r6, r9, r12, r7)
            java.lang.String[] r6 = r1.f13192j0
            r6 = r6[r2]
            java.lang.String r6 = r1.q1(r6)
            int r9 = r11.getWidth()
            double r12 = (double) r9
            double r12 = r12 / r31
            float r9 = (float) r12
            int r12 = r11.getHeight()
            double r12 = (double) r12
            double r12 = r12 / r31
            int r10 = r10.height()
            r24 = r9
            double r8 = (double) r10
            double r8 = r8 / r31
            double r12 = r12 + r8
            double r12 = r12 + r14
            float r8 = (float) r12
            r9 = r24
            r4.drawText(r6, r9, r8, r7)
            com.google.android.gms.maps.model.LatLng r4 = new com.google.android.gms.maps.model.LatLng
            double[] r6 = r1.f13164T
            r7 = r6[r2]
            double[] r6 = r1.f13166U
            r9 = r6[r2]
            r4.<init>(r7, r9)
            com.google.android.gms.maps.model.MarkerOptions r6 = new com.google.android.gms.maps.model.MarkerOptions
            r6.<init>()
            r7 = 1056964608(0x3f000000, float:0.5)
            r6.anchor(r7, r7)
            r6.position(r4)
            if (r2 == r0) goto L_0x164c
            double[] r4 = r1.f13168V
            r7 = r4[r2]
            float r4 = (float) r7
            r6.zIndex(r4)
            goto L_0x1652
        L_0x164c:
            r4 = 1176256512(0x461c4000, float:10000.0)
            r6.zIndex(r4)
        L_0x1652:
            com.google.android.gms.maps.model.BitmapDescriptor r4 = com.google.android.gms.maps.model.BitmapDescriptorFactory.fromBitmap(r11)
            r6.icon(r4)
            r11.recycle()
            com.google.android.gms.maps.model.Marker[] r4 = r1.f13195m0
            com.google.android.gms.maps.GoogleMap r7 = r1.f13158Q
            com.google.android.gms.maps.model.Marker r6 = r7.addMarker(r6)
            r4[r2] = r6
            goto L_0x13d1
        L_0x1668:
            r13 = 1
            if (r4 != r13) goto L_0x1879
            android.util.DisplayMetrics r4 = new android.util.DisplayMetrics
            r4.<init>()
            android.view.WindowManager r7 = r1.getWindowManager()
            android.view.Display r7 = r7.getDefaultDisplay()
            r7.getMetrics(r4)
            int r7 = r4.heightPixels
            int r4 = r4.widthPixels
            int r4 = java.lang.Math.max(r7, r4)
            int r4 = r4 / 70
            android.graphics.Paint r7 = new android.graphics.Paint
            r7.<init>()
            android.graphics.Paint$Align r8 = android.graphics.Paint.Align.CENTER
            r7.setTextAlign(r8)
            float r9 = (float) r4
            r7.setTextSize(r9)
            r7.setTextAlign(r8)
            android.graphics.Typeface r8 = android.graphics.Typeface.DEFAULT_BOLD
            r7.setTypeface(r8)
            r13 = 1
            r7.setAntiAlias(r13)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r9 = "M"
            r8.append(r9)
            double[] r9 = r1.f13168V
            r10 = r9[r2]
            r8.append(r10)
            java.lang.String r8 = r8.toString()
            android.graphics.Rect r9 = new android.graphics.Rect
            r9.<init>()
            int r10 = r8.length()
            r11 = 0
            r7.getTextBounds(r8, r11, r10, r9)
            int r10 = r9.width()
            r38 = 2
            int r10 = r10 * 2
            int r11 = r9.height()
            r30 = 3
            int r11 = r11 * 3
            android.graphics.Bitmap$Config r12 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r10 = android.graphics.Bitmap.createBitmap(r10, r11, r12)
            android.graphics.Canvas r11 = new android.graphics.Canvas
            r11.<init>(r10)
            android.graphics.Paint r12 = new android.graphics.Paint
            r12.<init>()
            r14 = 255(0xff, float:3.57E-43)
            r12.setAlpha(r14)
            r14 = 0
            r11.drawBitmap(r10, r14, r14, r12)
            android.graphics.Paint r12 = new android.graphics.Paint
            r12.<init>()
            r13 = 1
            r12.setAntiAlias(r13)
            android.graphics.Paint$Style r13 = android.graphics.Paint.Style.FILL
            r12.setStyle(r13)
            r14 = -1
            r12.setColor(r14)
            double r13 = (double) r4
            double r13 = r13 / r31
            float r4 = (float) r13
            int r13 = r10.getWidth()
            r38 = 2
            int r13 = r13 / 2
            int r14 = r9.width()
            int r14 = r14 / 2
            int r13 = r13 - r14
            float r13 = (float) r13
            float r51 = r13 - r4
            int r13 = r10.getHeight()
            int r13 = r13 / 2
            int r14 = r9.height()
            int r14 = r14 / 2
            int r13 = r13 - r14
            float r13 = (float) r13
            float r52 = r13 - r4
            int r13 = r10.getWidth()
            int r13 = r13 / 2
            int r14 = r9.width()
            int r14 = r14 / 2
            int r13 = r13 + r14
            float r13 = (float) r13
            float r53 = r13 + r4
            int r13 = r10.getHeight()
            int r13 = r13 / 2
            int r14 = r9.height()
            int r14 = r14 / 2
            int r13 = r13 + r14
            float r13 = (float) r13
            float r54 = r13 + r4
            r56 = r4
            r55 = r4
            r50 = r11
            r57 = r12
            r50.drawRoundRect(r51, r52, r53, r54, r55, r56, r57)
            r4 = r57
            android.graphics.Paint$Style r11 = android.graphics.Paint.Style.STROKE
            r4.setStyle(r11)
            if (r2 != r0) goto L_0x1768
            r11 = 180(0xb4, float:2.52E-43)
            r12 = 0
            r14 = 255(0xff, float:3.57E-43)
            int r11 = android.graphics.Color.argb(r14, r11, r12, r12)
            r4.setColor(r11)
            r12 = 1082130432(0x40800000, float:4.0)
            r4.setStrokeWidth(r12)
            goto L_0x1787
        L_0x1768:
            com.google.android.gms.maps.GoogleMap r11 = r1.f13158Q
            int r11 = r11.getMapType()
            r13 = 1
            if (r11 != r13) goto L_0x177d
            r12 = 16
            if (r5 != r12) goto L_0x177d
            r11 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r4.setColor(r11)
        L_0x177a:
            r11 = 1077936128(0x40400000, float:3.0)
            goto L_0x1784
        L_0x177d:
            r12 = -3355444(0xffffffffffcccccc, float:NaN)
            r4.setColor(r12)
            goto L_0x177a
        L_0x1784:
            r4.setStrokeWidth(r11)
        L_0x1787:
            int r11 = r10.getWidth()
            r38 = 2
            int r11 = r11 / 2
            int r12 = r9.width()
            int r12 = r12 / 2
            int r11 = r11 - r12
            float r11 = (float) r11
            float r51 = r11 - r55
            int r11 = r10.getHeight()
            int r11 = r11 / 2
            int r12 = r9.height()
            int r12 = r12 / 2
            int r11 = r11 - r12
            float r11 = (float) r11
            float r52 = r11 - r55
            int r11 = r10.getWidth()
            int r11 = r11 / 2
            int r12 = r9.width()
            int r12 = r12 / 2
            int r11 = r11 + r12
            float r11 = (float) r11
            float r53 = r11 + r55
            int r11 = r10.getHeight()
            int r11 = r11 / 2
            int r12 = r9.height()
            int r12 = r12 / 2
            int r11 = r11 + r12
            float r11 = (float) r11
            float r54 = r11 + r55
            r56 = r55
            r57 = r4
            r50.drawRoundRect(r51, r52, r53, r54, r55, r56, r57)
            r4 = r50
            double[] r11 = r1.f13168V
            r12 = r11[r2]
            int r11 = (r12 > r31 ? 1 : (r12 == r31 ? 0 : -1))
            if (r11 >= 0) goto L_0x17e3
            r11 = 0
            int r6 = android.graphics.Color.rgb(r11, r6, r6)
            r7.setColor(r6)
            goto L_0x1813
        L_0x17e3:
            r11 = 0
            int r14 = (r12 > r20 ? 1 : (r12 == r20 ? 0 : -1))
            if (r14 >= 0) goto L_0x17f0
            int r6 = android.graphics.Color.rgb(r11, r6, r11)
            r7.setColor(r6)
            goto L_0x1813
        L_0x17f0:
            int r14 = (r12 > r18 ? 1 : (r12 == r18 ? 0 : -1))
            if (r14 >= 0) goto L_0x1800
            r6 = 240(0xf0, float:3.36E-43)
            r12 = 190(0xbe, float:2.66E-43)
            int r6 = android.graphics.Color.rgb(r6, r12, r11)
            r7.setColor(r6)
            goto L_0x1813
        L_0x1800:
            int r12 = (r12 > r16 ? 1 : (r12 == r16 ? 0 : -1))
            if (r12 >= 0) goto L_0x180c
            int r6 = android.graphics.Color.rgb(r6, r11, r11)
            r7.setColor(r6)
            goto L_0x1813
        L_0x180c:
            int r6 = android.graphics.Color.rgb(r6, r11, r6)
            r7.setColor(r6)
        L_0x1813:
            int r6 = r10.getWidth()
            double r11 = (double) r6
            double r11 = r11 / r31
            float r6 = (float) r11
            int r11 = r10.getHeight()
            double r11 = (double) r11
            double r11 = r11 / r31
            int r9 = r9.height()
            double r13 = (double) r9
            double r13 = r13 / r31
            double r11 = r11 + r13
            float r9 = (float) r11
            r4.drawText(r8, r6, r9, r7)
            com.google.android.gms.maps.model.LatLng r4 = new com.google.android.gms.maps.model.LatLng
            double[] r6 = r1.f13164T
            r7 = r6[r2]
            double[] r6 = r1.f13166U
            r11 = r6[r2]
            r4.<init>(r7, r11)
            com.google.android.gms.maps.model.MarkerOptions r6 = new com.google.android.gms.maps.model.MarkerOptions
            r6.<init>()
            r7 = 1056964608(0x3f000000, float:0.5)
            r6.anchor(r7, r7)
            r6.position(r4)
            if (r2 == r0) goto L_0x1853
            double[] r4 = r1.f13168V
            r7 = r4[r2]
            float r4 = (float) r7
            r6.zIndex(r4)
            goto L_0x1859
        L_0x1853:
            r4 = 1176256512(0x461c4000, float:10000.0)
            r6.zIndex(r4)
        L_0x1859:
            com.google.android.gms.maps.model.BitmapDescriptor r4 = com.google.android.gms.maps.model.BitmapDescriptorFactory.fromBitmap(r10)
            r6.icon(r4)
            r10.recycle()
            com.google.android.gms.maps.model.Marker[] r4 = r1.f13195m0
            com.google.android.gms.maps.GoogleMap r7 = r1.f13158Q
            com.google.android.gms.maps.model.Marker r6 = r7.addMarker(r6)
            r4[r2] = r6
            r8 = 1056964608(0x3f000000, float:0.5)
            r12 = 255(0xff, float:3.57E-43)
            r13 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r14 = 0
            r15 = -3355444(0xffffffffffcccccc, float:NaN)
            goto L_0x13dd
        L_0x1879:
            r30 = 3
            android.util.DisplayMetrics r4 = new android.util.DisplayMetrics
            r4.<init>()
            android.view.WindowManager r6 = r1.getWindowManager()
            android.view.Display r6 = r6.getDefaultDisplay()
            r6.getMetrics(r4)
            int r6 = r4.heightPixels
            int r4 = r4.widthPixels
            int r4 = java.lang.Math.max(r6, r4)
            int r4 = r4 / 70
            int r6 = r4 / 5
            int r6 = r6 + r4
            android.graphics.Bitmap$Config r7 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r6 = android.graphics.Bitmap.createBitmap(r6, r6, r7)
            android.graphics.Canvas r7 = new android.graphics.Canvas
            r7.<init>(r6)
            android.graphics.Paint r8 = new android.graphics.Paint
            r8.<init>()
            r14 = 255(0xff, float:3.57E-43)
            r8.setAlpha(r14)
            r14 = 0
            r7.drawBitmap(r6, r14, r14, r8)
            android.graphics.Paint r8 = new android.graphics.Paint
            r8.<init>()
            android.graphics.Paint$Style r9 = android.graphics.Paint.Style.FILL
            r8.setStyle(r9)
            r13 = 1
            r8.setAntiAlias(r13)
            r9 = -1
            r8.setColor(r9)
            double[] r9 = r1.f13168V
            r10 = r9[r2]
            int r9 = (r10 > r31 ? 1 : (r10 == r31 ? 0 : -1))
            if (r9 < 0) goto L_0x18d1
            r9 = -16711936(0xffffffffff00ff00, float:-1.7146522E38)
            r8.setColor(r9)
        L_0x18d1:
            double[] r9 = r1.f13168V
            r10 = r9[r2]
            int r9 = (r10 > r20 ? 1 : (r10 == r20 ? 0 : -1))
            if (r9 < 0) goto L_0x18de
            r9 = -256(0xffffffffffffff00, float:NaN)
            r8.setColor(r9)
        L_0x18de:
            double[] r9 = r1.f13168V
            r10 = r9[r2]
            int r9 = (r10 > r18 ? 1 : (r10 == r18 ? 0 : -1))
            if (r9 < 0) goto L_0x18ec
            r9 = -65536(0xffffffffffff0000, float:NaN)
            r8.setColor(r9)
            goto L_0x18ee
        L_0x18ec:
            r9 = -65536(0xffffffffffff0000, float:NaN)
        L_0x18ee:
            double[] r10 = r1.f13168V
            r11 = r10[r2]
            int r10 = (r11 > r16 ? 1 : (r11 == r16 ? 0 : -1))
            if (r10 < 0) goto L_0x18fc
            r10 = -65281(0xffffffffffff00ff, float:NaN)
            r8.setColor(r10)
        L_0x18fc:
            int r10 = r6.getWidth()
            double r10 = (double) r10
            double r10 = r10 / r31
            float r10 = (float) r10
            int r11 = r6.getHeight()
            double r11 = (double) r11
            double r11 = r11 / r31
            float r11 = (float) r11
            double r12 = (double) r4
            double r12 = r12 / r31
            float r4 = (float) r12
            r7.drawCircle(r10, r11, r4, r8)
            android.graphics.Paint$Style r10 = android.graphics.Paint.Style.STROKE
            r8.setStyle(r10)
            if (r2 != r0) goto L_0x1933
            r10 = 180(0xb4, float:2.52E-43)
            r11 = 0
            r12 = 255(0xff, float:3.57E-43)
            int r10 = android.graphics.Color.argb(r12, r10, r11, r11)
            r8.setColor(r10)
            r10 = 1082130432(0x40800000, float:4.0)
            r8.setStrokeWidth(r10)
            r11 = 16
            r13 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r15 = -3355444(0xffffffffffcccccc, float:NaN)
            goto L_0x195f
        L_0x1933:
            r10 = 1082130432(0x40800000, float:4.0)
            r12 = 255(0xff, float:3.57E-43)
            com.google.android.gms.maps.GoogleMap r11 = r1.f13158Q
            int r11 = r11.getMapType()
            r13 = 1
            if (r11 != r13) goto L_0x1953
            r11 = 16
            r13 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            if (r5 != r11) goto L_0x194f
            r8.setColor(r13)
            r15 = -3355444(0xffffffffffcccccc, float:NaN)
        L_0x194c:
            r9 = 1077936128(0x40400000, float:3.0)
            goto L_0x195c
        L_0x194f:
            r15 = -3355444(0xffffffffffcccccc, float:NaN)
            goto L_0x1958
        L_0x1953:
            r11 = 16
            r13 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            goto L_0x194f
        L_0x1958:
            r8.setColor(r15)
            goto L_0x194c
        L_0x195c:
            r8.setStrokeWidth(r9)
        L_0x195f:
            int r9 = r6.getWidth()
            double r10 = (double) r9
            double r10 = r10 / r31
            float r9 = (float) r10
            int r10 = r6.getHeight()
            double r10 = (double) r10
            double r10 = r10 / r31
            float r10 = (float) r10
            r7.drawCircle(r9, r10, r4, r8)
            com.google.android.gms.maps.model.LatLng r4 = new com.google.android.gms.maps.model.LatLng
            double[] r7 = r1.f13164T
            r8 = r7[r2]
            double[] r7 = r1.f13166U
            r10 = r7[r2]
            r4.<init>(r8, r10)
            com.google.android.gms.maps.model.MarkerOptions r7 = new com.google.android.gms.maps.model.MarkerOptions
            r7.<init>()
            r8 = 1056964608(0x3f000000, float:0.5)
            r7.anchor(r8, r8)
            r7.position(r4)
            if (r2 == r0) goto L_0x1997
            double[] r4 = r1.f13168V
            r9 = r4[r2]
            float r4 = (float) r9
            r7.zIndex(r4)
            goto L_0x199d
        L_0x1997:
            r4 = 1176256512(0x461c4000, float:10000.0)
            r7.zIndex(r4)
        L_0x199d:
            com.google.android.gms.maps.model.BitmapDescriptor r4 = com.google.android.gms.maps.model.BitmapDescriptorFactory.fromBitmap(r6)
            r7.icon(r4)
            r6.recycle()
            com.google.android.gms.maps.model.Marker[] r4 = r1.f13195m0
            com.google.android.gms.maps.GoogleMap r6 = r1.f13158Q
            com.google.android.gms.maps.model.Marker r6 = r6.addMarker(r7)
            r4[r2] = r6
            goto L_0x13dd
        L_0x19b3:
            int r2 = r2 + 1
            goto L_0x0bc6
        L_0x19b7:
            if (r3 != 0) goto L_0x19db
            android.content.Intent r0 = new android.content.Intent
            r0.<init>()
            java.lang.String r2 = "memory"
            java.lang.String r3 = "ok"
            r0.putExtra(r2, r3)
            r9 = -1
            r1.setResult(r9, r0)
            int r0 = r1.f13160R
            if (r0 != 0) goto L_0x19d0
            r1.j1()
        L_0x19d0:
            int r0 = r1.f13160R
            r13 = 1
            if (r0 == r13) goto L_0x19d8
            r11 = 2
            if (r0 != r11) goto L_0x19db
        L_0x19d8:
            r1.k1()
        L_0x19db:
            long r2 = java.lang.System.currentTimeMillis()
            r1.f13183c1 = r2
            r11 = 0
            r1.f13179a1 = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.GlobeActivityAll.B1():void");
    }

    private void C1() {
        if (this.f13158Q == null) {
            ((SupportMapFragment) getSupportFragmentManager().g0(C2030R.id.map)).getMapAsync(this);
        }
    }

    /* JADX WARNING: type inference failed for: r3v4 */
    /* JADX WARNING: type inference failed for: r3v5, types: [boolean] */
    /* JADX WARNING: type inference failed for: r3v11 */
    private void D1() {
        boolean z7;
        if (this.f13158Q != null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getResources().openRawResource(C2030R.raw.fault), StandardCharsets.UTF_8));
                this.f13194l0 = new Polyline[ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED];
                PolylineOptions polylineOptions = new PolylineOptions();
                int i8 = getResources().getConfiguration().uiMode & 48;
                int i9 = -1;
                if (this.f13158Q.getMapType() == 1 && i8 == 16) {
                    polylineOptions.color(-65536);
                } else {
                    polylineOptions.color(-1);
                }
                ? r32 = 0;
                polylineOptions.geodesic(false);
                polylineOptions.width(3.0f);
                int i10 = 0;
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine != null) {
                        if (readLine.equalsIgnoreCase("#")) {
                            this.f13194l0[i10] = this.f13158Q.addPolyline(polylineOptions);
                            i10++;
                            polylineOptions = new PolylineOptions();
                            if (this.f13158Q.getMapType() == 1 && i8 == 16) {
                                polylineOptions.color(-65536);
                            } else {
                                polylineOptions.color(i9);
                            }
                            polylineOptions.geodesic(r32);
                            polylineOptions.width(3.0f);
                            z7 = r32;
                        } else {
                            String[] split = readLine.split("@");
                            polylineOptions.add(new LatLng(Double.parseDouble(split[1]), Double.parseDouble(split[r32])));
                            z7 = false;
                            i9 = -1;
                        }
                        r32 = z7;
                    } else {
                        bufferedReader.close();
                        this.f13158Q.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(44.0d, 10.0d), 3.0f));
                        return;
                    }
                }
            } catch (IOException e8) {
                if (e8.getMessage() != null) {
                    Log.d("EQN", e8.getMessage());
                }
            }
        }
    }

    private void E1() {
        if (this.f13158Q != null) {
            this.f13167U0.getItem(2).setVisible(true);
            ((LinearLayout) findViewById(C2030R.id.LinearHazard)).setVisibility(0);
            this.f13169V0 = this.f13158Q.addTileOverlay(new TileOverlayOptions().tileProvider(new c(UserVerificationMethods.USER_VERIFY_HANDPRINT, UserVerificationMethods.USER_VERIFY_HANDPRINT)).transparency(0.5f));
        }
    }

    private void F1() {
        if (this.f13158Q != null) {
            try {
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(getResources().openRawResource(C2030R.raw.plate), StandardCharsets.UTF_8));
                this.f13193k0 = new Polyline[ConnectionResult.DRIVE_EXTERNAL_STORAGE_REQUIRED];
                PolylineOptions polylineOptions = new PolylineOptions();
                int i8 = getResources().getConfiguration().uiMode & 48;
                int i9 = -1;
                if (this.f13158Q.getMapType() == 1 && i8 == 16) {
                    polylineOptions.color(-16776961);
                } else {
                    polylineOptions.color(-1);
                }
                float f8 = 3.0f;
                polylineOptions.width(3.0f);
                int i10 = 0;
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        bufferedReader.close();
                        return;
                    } else if (readLine.equalsIgnoreCase("#")) {
                        this.f13193k0[i10] = this.f13158Q.addPolyline(polylineOptions);
                        i10++;
                        polylineOptions = new PolylineOptions();
                        if (this.f13158Q.getMapType() == 1 && i8 == 16) {
                            polylineOptions.color(-16776961);
                        } else {
                            polylineOptions.color(i9);
                        }
                        polylineOptions.width(f8);
                    } else {
                        String[] split = readLine.split("@");
                        polylineOptions.add(new LatLng(Double.parseDouble(split[1]), Double.parseDouble(split[0])));
                        f8 = 3.0f;
                        i9 = -1;
                    }
                }
            } catch (IOException e8) {
                if (e8.getMessage() != null) {
                    Log.d("EQN", e8.getMessage());
                }
            }
        }
    }

    private void G1(double d8, double d9, double d10) {
        this.f13159Q0 = false;
        Circle[] circleArr = this.f13196n0;
        if (circleArr != null) {
            for (Circle circle : circleArr) {
                if (circle != null) {
                    circle.remove();
                }
            }
        }
        ((LinearLayout) findViewById(C2030R.id.simulationLayout)).setVisibility(0);
        if (androidx.core.content.a.checkSelfPermission(getApplicationContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0 || androidx.core.content.a.checkSelfPermission(getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
            LocationServices.getFusedLocationProviderClient(getApplicationContext()).getLastLocation().addOnSuccessListener(new C1867t1(this, d8, d9));
        }
        long round = Math.round(Math.pow(d10, 2.0d) * 2.0d * 1000.0d);
        new d(round, 100, round, d8, d9).start();
    }

    static /* synthetic */ int L0(GlobeActivityAll globeActivityAll, int i8) {
        int i9 = globeActivityAll.f13149J0 + i8;
        globeActivityAll.f13149J0 = i9;
        return i9;
    }

    public static /* synthetic */ void e0(GlobeActivityAll globeActivityAll, Location location) {
        globeActivityAll.getClass();
        if (location != null) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(new LatLng(location.getLatitude(), location.getLongitude()));
            markerOptions.anchor(0.5f, 0.5f);
            markerOptions.icon(BitmapDescriptorFactory.fromResource(2131231213));
            GoogleMap googleMap = globeActivityAll.f13158Q;
            if (googleMap != null) {
                globeActivityAll.f13171W0 = googleMap.addMarker(markerOptions);
            }
            if (globeActivityAll.f13160R == 2 && globeActivityAll.f13145F0 == 0) {
                CircleOptions circleOptions = new CircleOptions();
                circleOptions.center(new LatLng(location.getLatitude(), location.getLongitude()));
                circleOptions.radius((double) (globeActivityAll.f13146G0 * 1000.0f));
                circleOptions.strokeColor(-65536);
                circleOptions.strokeWidth(6.0f);
                globeActivityAll.f13158Q.addCircle(circleOptions);
            }
            if (globeActivityAll.f13160R == 3 && globeActivityAll.f13155O0) {
                CircleOptions circleOptions2 = new CircleOptions();
                circleOptions2.center(new LatLng(location.getLatitude(), location.getLongitude()));
                circleOptions2.radius(40000.0d);
                circleOptions2.strokeColor(-65536);
                circleOptions2.fillColor(Color.argb(20, 255, 0, 0));
                circleOptions2.strokeWidth(8.0f);
                globeActivityAll.f13158Q.addCircle(circleOptions2);
                CircleOptions circleOptions3 = new CircleOptions();
                circleOptions3.center(new LatLng(location.getLatitude(), location.getLongitude()));
                circleOptions3.radius(750000.0d);
                circleOptions3.strokeColor(Color.rgb(0, UserVerificationMethods.USER_VERIFY_PATTERN, 0));
                circleOptions3.fillColor(Color.argb(40, 0, UserVerificationMethods.USER_VERIFY_PATTERN, 0));
                circleOptions3.strokeWidth(8.0f);
                globeActivityAll.f13158Q.addCircle(circleOptions3);
                AlertDialog.Builder builder = new AlertDialog.Builder(globeActivityAll);
                builder.setMessage(globeActivityAll.getString(C2030R.string.globe_simulation));
                builder.setCancelable(false);
                builder.setNegativeButton(globeActivityAll.getString(C2030R.string.manual_understood), new C1843p1());
                AlertDialog create = builder.create();
                create.show();
                ((TextView) create.findViewById(16908299)).setTextSize(20.0f);
                globeActivityAll.f13158Q.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(location.getLatitude(), location.getLongitude()), 8.0f));
            }
        }
    }

    public static /* synthetic */ void f0(GlobeActivityAll globeActivityAll, AlertDialog alertDialog, View view) {
        globeActivityAll.getClass();
        alertDialog.dismiss();
        if (globeActivityAll.f13177Z0 >= 0) {
            int[] iArr = globeActivityAll.f13186e0;
            int i8 = globeActivityAll.f13177Z0;
            GlobeActivityAll globeActivityAll2 = globeActivityAll;
            new f(globeActivityAll2, iArr[i8], globeActivityAll.f13164T[i8], globeActivityAll.f13166U[i8], (a) null).execute(new Context[]{globeActivityAll2.getApplicationContext()});
        }
    }

    public static /* synthetic */ void g0(GlobeActivityAll globeActivityAll, MaterialButton materialButton, View view) {
        if (globeActivityAll.f13141B0 == 0) {
            globeActivityAll.f13141B0 = 1;
            materialButton.setIconTintMode(PorterDuff.Mode.SCREEN);
            globeActivityAll.E1();
            return;
        }
        globeActivityAll.f13141B0 = 0;
        materialButton.setIconTintMode(PorterDuff.Mode.SRC_IN);
        globeActivityAll.z1();
    }

    public static /* synthetic */ void h0(GlobeActivityAll globeActivityAll, DialogInterface dialogInterface, int i8) {
        SharedPreferences.Editor edit = globeActivityAll.f13206x0.edit();
        edit.putBoolean("show_message_realtime", false);
        edit.apply();
        dialogInterface.dismiss();
    }

    public static /* synthetic */ void i0(GlobeActivityAll globeActivityAll, MaterialButton materialButton, View view) {
        if (globeActivityAll.f13142C0 == 0) {
            globeActivityAll.f13142C0 = 1;
            materialButton.setIconTintMode(PorterDuff.Mode.SCREEN);
            globeActivityAll.D1();
            return;
        }
        globeActivityAll.f13142C0 = 0;
        materialButton.setIconTintMode(PorterDuff.Mode.SRC_IN);
        globeActivityAll.y1();
    }

    public static /* synthetic */ void j0(DialogInterface dialogInterface, int i8) {
    }

    /* access modifiers changed from: private */
    public void j1() {
        int i8;
        Marker[] markerArr;
        int selectedItemPosition = ((Spinner) findViewById(C2030R.id.spinner2)).getSelectedItemPosition();
        if (selectedItemPosition == 0) {
            i8 = 44640;
        } else {
            i8 = 0;
        }
        if (selectedItemPosition == 1) {
            i8 = 10080;
        }
        if (selectedItemPosition == 2) {
            i8 = 1440;
        }
        if (selectedItemPosition == 3) {
            i8 = 60;
        }
        if (this.f13195m0 != null) {
            int i9 = 0;
            while (true) {
                markerArr = this.f13195m0;
                if (i9 >= markerArr.length) {
                    break;
                }
                if (o1(this.f13192j0[i9]) <= i8 || selectedItemPosition <= 0) {
                    this.f13195m0[i9].setVisible(true);
                } else {
                    this.f13195m0[i9].setVisible(false);
                }
                i9++;
            }
            if (this.f13181b1) {
                double d8 = this.f13168V[markerArr.length - 1];
                if (d8 > 0.0d) {
                    double d9 = d8 * 1.03d;
                    double pow = Math.pow(10.0d, (-2.69d + d9) / 2.15d);
                    double pow2 = Math.pow(10.0d, (-0.69d + d9) / 2.15d);
                    double pow3 = Math.pow(10.0d, (d9 + 0.31000000000000005d) / 2.15d);
                    this.f13196n0 = new Circle[3];
                    CircleOptions circleOptions = new CircleOptions();
                    double[] dArr = this.f13164T;
                    Marker[] markerArr2 = this.f13195m0;
                    double d10 = pow2;
                    circleOptions.center(new LatLng(dArr[markerArr2.length - 1], this.f13166U[markerArr2.length - 1]));
                    Display defaultDisplay = getWindowManager().getDefaultDisplay();
                    DisplayMetrics displayMetrics = new DisplayMetrics();
                    defaultDisplay.getMetrics(displayMetrics);
                    float ceil = (float) Math.ceil((double) (((float) displayMetrics.widthPixels) / 100.0f));
                    if (pow > 5.0d) {
                        circleOptions.radius(pow * 1000.0d);
                        circleOptions.strokeWidth(ceil);
                        circleOptions.strokeColor(Color.argb(255, 200, 0, 0));
                        this.f13196n0[0] = this.f13158Q.addCircle(circleOptions);
                    }
                    if (d10 > 5.0d) {
                        circleOptions.radius(d10 * 1000.0d);
                        circleOptions.strokeWidth(ceil);
                        circleOptions.strokeColor(Color.argb(255, 255, 200, 0));
                        this.f13196n0[1] = this.f13158Q.addCircle(circleOptions);
                    }
                    if (pow3 > 5.0d) {
                        circleOptions.radius(pow3 * 1000.0d);
                        circleOptions.strokeWidth(ceil);
                        circleOptions.strokeColor(Color.argb(255, 50, 255, 50));
                        this.f13196n0[2] = this.f13158Q.addCircle(circleOptions);
                    }
                }
                this.f13181b1 = false;
            }
        }
    }

    public static /* synthetic */ void k0(GlobeActivityAll globeActivityAll, MaterialButton materialButton, View view) {
        if (globeActivityAll.f13208z0 == 0) {
            globeActivityAll.f13208z0 = 1;
            materialButton.setIconTintMode(PorterDuff.Mode.SCREEN);
            GoogleMap googleMap = globeActivityAll.f13158Q;
            if (googleMap != null) {
                googleMap.setMapType(4);
            }
        } else {
            globeActivityAll.f13208z0 = 0;
            materialButton.setIconTintMode(PorterDuff.Mode.SRC_IN);
            GoogleMap googleMap2 = globeActivityAll.f13158Q;
            if (googleMap2 != null) {
                googleMap2.setMapType(1);
            }
        }
        SharedPreferences.Editor edit = globeActivityAll.f13206x0.edit();
        edit.putInt("map_satellite", globeActivityAll.f13208z0);
        edit.apply();
        GoogleMap googleMap3 = globeActivityAll.f13158Q;
        if (googleMap3 != null) {
            googleMap3.clear();
            globeActivityAll.f13158Q = null;
        }
        globeActivityAll.C1();
    }

    /* access modifiers changed from: private */
    public void k1() {
        int i8;
        if (this.f13160R == 1) {
            int selectedItemPosition = ((Spinner) findViewById(C2030R.id.spinner1)).getSelectedItemPosition();
            int i9 = 1440;
            if (selectedItemPosition != 0) {
                if (selectedItemPosition == 1) {
                    i9 = 720;
                } else if (selectedItemPosition == 2) {
                    i9 = 360;
                } else if (selectedItemPosition == 3) {
                    i9 = 120;
                } else if (selectedItemPosition == 4) {
                    i9 = 60;
                } else if (selectedItemPosition == 5) {
                    i9 = 10;
                }
            }
            if (this.f13195m0 != null) {
                for (int i10 = 0; i10 < this.f13195m0.length; i10++) {
                    if (o1(this.f13192j0[i10]) <= i9) {
                        this.f13195m0[i10].setVisible(true);
                    } else {
                        this.f13195m0[i10].setVisible(false);
                    }
                }
            }
            double[] dArr = this.f13164T;
            if (dArr != null) {
                this.f13189g0 = new int[dArr.length];
                int i11 = 0;
                for (int i12 = 0; i12 < this.f13164T.length; i12++) {
                    if (this.f13189g0[i12] == 0 && o1(this.f13192j0[i12]) <= i9) {
                        for (int i13 = 0; i13 < this.f13164T.length; i13++) {
                            if (i12 != i13 && o1(this.f13192j0[i13]) <= i9) {
                                double[] dArr2 = this.f13164T;
                                if (Math.abs(dArr2[i12] - dArr2[i13]) < 4.0d) {
                                    double[] dArr3 = this.f13166U;
                                    if (Math.abs(dArr3[i12] - dArr3[i13]) < 4.0d && Math.abs(o1(this.f13192j0[i12]) - o1(this.f13192j0[i13])) <= 20) {
                                        int[] iArr = this.f13189g0;
                                        int i14 = iArr[i13];
                                        if (i14 > 0) {
                                            iArr[i12] = i14;
                                        } else {
                                            int i15 = iArr[i12];
                                            if (i15 > 0) {
                                                iArr[i13] = i15;
                                            } else {
                                                i11++;
                                                iArr[i12] = i11;
                                                iArr[i13] = i11;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                i8 = i11;
            } else {
                i8 = 0;
            }
            double[] dArr4 = new double[i8];
            double[] dArr5 = new double[i8];
            int[] iArr2 = new int[i8];
            double[] dArr6 = new double[i8];
            for (int i16 = 0; i16 < i8; i16++) {
                dArr4[i16] = 0.0d;
                dArr5[i16] = 0.0d;
                iArr2[i16] = 0;
                dArr6[i16] = 0.0d;
                int i17 = 0;
                while (true) {
                    double[] dArr7 = this.f13164T;
                    if (i17 >= dArr7.length) {
                        break;
                    }
                    if (this.f13189g0[i17] == i16 + 1) {
                        dArr4[i16] = dArr4[i16] + dArr7[i17];
                        dArr5[i16] = dArr5[i16] + this.f13166U[i17];
                        iArr2[i16] = iArr2[i16] + 1;
                        dArr6[i16] = dArr6[i16] + ((double) this.f13178a0[i17]);
                    }
                    i17++;
                }
                int i18 = iArr2[i16];
                if (i18 > 0) {
                    dArr4[i16] = dArr4[i16] / ((double) i18);
                    dArr5[i16] = dArr5[i16] / ((double) i18);
                    dArr6[i16] = dArr6[i16] / ((double) i18);
                }
            }
            double[] dArr8 = new double[i8];
            double[] dArr9 = new double[i8];
            double[] dArr10 = new double[i8];
            for (int i19 = 0; i19 < i8; i19++) {
                dArr10[i19] = 0.0d;
                int i20 = 0;
                while (true) {
                    double[] dArr11 = this.f13164T;
                    if (i20 >= dArr11.length) {
                        break;
                    }
                    if (this.f13189g0[i20] == i19 + 1) {
                        double abs = Math.abs(dArr4[i19] - dArr11[i20]) + Math.abs(dArr5[i19] - this.f13166U[i20]);
                        if (abs >= dArr10[i19]) {
                            dArr8[i19] = this.f13164T[i20];
                            dArr9[i19] = this.f13166U[i20];
                            dArr10[i19] = abs;
                        }
                    }
                    i20++;
                }
            }
            Circle[] circleArr = this.f13196n0;
            if (circleArr != null) {
                for (Circle circle : circleArr) {
                    if (circle != null) {
                        circle.remove();
                    }
                }
            }
            CircleOptions circleOptions = new CircleOptions();
            if ((getResources().getConfiguration().uiMode & 48) == 16) {
                circleOptions.fillColor(Color.argb(40, 40, 40, 40));
                circleOptions.strokeColor(Color.rgb(40, 40, 40));
            } else {
                circleOptions.fillColor(Color.argb(40, 40, 40, 40));
                circleOptions.strokeColor(Color.rgb(255, 255, 255));
            }
            circleOptions.strokeWidth(5.0f);
            this.f13196n0 = new Circle[i8];
            for (int i21 = 0; i21 < i8; i21++) {
                circleOptions.center(new LatLng(dArr4[i21], dArr5[i21]));
                circleOptions.radius((v1(dArr4[i21], dArr5[i21], dArr8[i21], dArr9[i21]) * 1000.0d) + 1000.0d);
                this.f13196n0[i21] = this.f13158Q.addCircle(circleOptions);
            }
        }
    }

    public static /* synthetic */ void l0(GlobeActivityAll globeActivityAll, DialogInterface dialogInterface, int i8) {
        SharedPreferences.Editor edit = globeActivityAll.f13206x0.edit();
        edit.putBoolean("show_message_reports", false);
        edit.apply();
        dialogInterface.dismiss();
    }

    private AdSize l1() {
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, (int) (((float) displayMetrics.widthPixels) / displayMetrics.density));
    }

    private ActivityManager.MemoryInfo m1() {
        ActivityManager activityManager = (ActivityManager) getSystemService("activity");
        if (activityManager == null) {
            return null;
        }
        ActivityManager.MemoryInfo memoryInfo = new ActivityManager.MemoryInfo();
        activityManager.getMemoryInfo(memoryInfo);
        return memoryInfo;
    }

    public static /* synthetic */ void n0(GlobeActivityAll globeActivityAll, double d8, double d9, Location location) {
        if (location != null) {
            GoogleMap googleMap = globeActivityAll.f13158Q;
            if (googleMap != null) {
                globeActivityAll.f13199q0 = googleMap.addPolyline(new PolylineOptions().add(new LatLng(location.getLatitude(), location.getLongitude()), new LatLng(d8, d9)).width(2.0f).geodesic(true).color(-65281));
                return;
            }
            return;
        }
        globeActivityAll.getClass();
    }

    private int n1(int i8, int i9) {
        int i10 = i9 + (i8 * 60);
        if (i10 <= 15) {
            return 128347;
        }
        if (i10 <= 45) {
            return 128359;
        }
        if (i10 <= 75) {
            return 128336;
        }
        if (i10 <= 105) {
            return 128348;
        }
        if (i10 <= 135) {
            return 128337;
        }
        if (i10 <= 165) {
            return 128349;
        }
        if (i10 <= 195) {
            return 128338;
        }
        if (i10 <= 225) {
            return 128350;
        }
        if (i10 <= 255) {
            return 128339;
        }
        if (i10 <= 285) {
            return 128351;
        }
        if (i10 <= 315) {
            return 128340;
        }
        if (i10 <= 345) {
            return 128352;
        }
        if (i10 <= 375) {
            return 128341;
        }
        if (i10 <= 405) {
            return 128353;
        }
        if (i10 <= 435) {
            return 128342;
        }
        if (i10 <= 465) {
            return 128354;
        }
        if (i10 <= 495) {
            return 128343;
        }
        if (i10 <= 525) {
            return 128355;
        }
        if (i10 <= 555) {
            return 128344;
        }
        if (i10 <= 585) {
            return 128356;
        }
        if (i10 <= 615) {
            return 128345;
        }
        if (i10 <= 645) {
            return 128357;
        }
        if (i10 <= 675) {
            return 128346;
        }
        if (i10 <= 705) {
            return 128358;
        }
        if (i10 <= 735) {
            return 128347;
        }
        return i10 <= 765 ? 128359 : 128336;
    }

    public static /* synthetic */ void o0(GlobeActivityAll globeActivityAll, DialogInterface dialogInterface, int i8) {
        SharedPreferences.Editor edit = globeActivityAll.f13206x0.edit();
        edit.putBoolean("show_message_official", false);
        edit.apply();
        dialogInterface.dismiss();
    }

    private int o1(String str) {
        if (str == null) {
            return 0;
        }
        Date date = new Date();
        try {
            date = this.f13152M0.parse(str);
        } catch (ParseException e8) {
            if (e8.getMessage() != null) {
                Log.d("EQN", e8.getMessage());
            }
        }
        return (int) Math.round((((double) (new Date().getTime() - new Date(date.getTime() - ((long) (this.f13150K0.getOffset(date.getTime()) - this.f13151L0.getOffset(date.getTime())))).getTime())) / 1000.0d) / 60.0d);
    }

    public static /* synthetic */ void p0(GlobeActivityAll globeActivityAll, View view) {
        globeActivityAll.getClass();
        if (System.currentTimeMillis() - globeActivityAll.f13206x0.getLong("last_alerttime_check", 0) > 5000) {
            float[] s12 = globeActivityAll.s1();
            double v12 = globeActivityAll.v1((double) s12[0], (double) s12[1], globeActivityAll.f13158Q.getCameraPosition().target.latitude, globeActivityAll.f13158Q.getCameraPosition().target.longitude);
            if (v12 < 40.0d) {
                Toast makeText = Toast.makeText(globeActivityAll.f13205w0.getApplicationContext(), globeActivityAll.f13205w0.getString(C2030R.string.globe_simulation_outside), 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            } else if (v12 > 750.0d) {
                Toast makeText2 = Toast.makeText(globeActivityAll.f13205w0.getApplicationContext(), globeActivityAll.f13205w0.getString(C2030R.string.globe_simulation_inside), 0);
                makeText2.setGravity(17, 0, 0);
                makeText2.show();
            } else {
                GlobeActivityAll globeActivityAll2 = globeActivityAll;
                new g(globeActivityAll2, globeActivityAll.f13158Q.getCameraPosition().target.latitude, globeActivityAll.f13158Q.getCameraPosition().target.longitude, v12, globeActivityAll.f13206x0.getBoolean("top10k_owned", false), globeActivityAll.f13206x0.getBoolean("top100k_owned", false), (a) null).execute(new Context[0]);
            }
        } else {
            Toast makeText3 = Toast.makeText(globeActivityAll.f13205w0.getApplicationContext(), globeActivityAll.f13205w0.getString(C2030R.string.globe_simulation_wait), 0);
            makeText3.setGravity(17, 0, 0);
            makeText3.show();
        }
    }

    /* access modifiers changed from: private */
    public String p1(String str) {
        int o12 = o1(str);
        if (o12 < 60) {
            float f8 = (float) o12;
            return getResources().getQuantityString(C2030R.plurals.manual_minutes_ago, Math.round(f8), new Object[]{Integer.valueOf(Math.round(f8))});
        } else if (o12 < 1440) {
            double d8 = ((double) o12) / 60.0d;
            return getResources().getQuantityString(C2030R.plurals.manual_hours_ago, (int) Math.round(d8), new Object[]{Integer.valueOf((int) Math.round(d8))});
        } else {
            double d9 = (((double) o12) / 60.0d) / 24.0d;
            return getResources().getQuantityString(C2030R.plurals.manual_days_ago, (int) Math.round(d9), new Object[]{Integer.valueOf((int) Math.round(d9))});
        }
    }

    public static /* synthetic */ void q0(GlobeActivityAll globeActivityAll, MaterialButton materialButton, View view) {
        if (globeActivityAll.f13140A0 == 0) {
            globeActivityAll.f13140A0 = 1;
            materialButton.setIconTintMode(PorterDuff.Mode.SCREEN);
            globeActivityAll.F1();
        } else {
            globeActivityAll.f13140A0 = 0;
            materialButton.setIconTintMode(PorterDuff.Mode.SRC_IN);
            globeActivityAll.A1();
        }
        SharedPreferences.Editor edit = globeActivityAll.f13206x0.edit();
        edit.putInt("map_showplates", globeActivityAll.f13140A0);
        edit.apply();
    }

    private String q1(String str) {
        int o12 = o1(str);
        if (o12 < 60) {
            return Math.round((float) o12) + getString(C2030R.string.short_minute);
        } else if (o12 < 1440) {
            return Math.round(((double) o12) / 60.0d) + getString(C2030R.string.short_hour);
        } else {
            return Math.round((((double) o12) / 60.0d) / 24.0d) + getString(C2030R.string.short_day);
        }
    }

    /* access modifiers changed from: private */
    public String r1(int i8) {
        return new String(Character.toChars(i8));
    }

    /* access modifiers changed from: private */
    public float[] s1() {
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.class.getSimpleName(), 0);
        return new float[]{sharedPreferences.getFloat("current_latitude", BitmapDescriptorFactory.HUE_RED), sharedPreferences.getFloat("current_longitude", BitmapDescriptorFactory.HUE_RED), sharedPreferences.getFloat("current_accuracy", -1.0f)};
    }

    static /* synthetic */ int t0(GlobeActivityAll globeActivityAll, int i8) {
        int i9 = globeActivityAll.f13148I0 + i8;
        globeActivityAll.f13148I0 = i9;
        return i9;
    }

    private String t1(String str) {
        if (str == null) {
            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
        }
        Date date = new Date();
        try {
            date = this.f13152M0.parse(str);
        } catch (ParseException e8) {
            if (e8.getMessage() != null) {
                Log.d("EQN", e8.getMessage());
            }
        }
        return this.f13153N0.format(new Date(date.getTime() - ((long) (this.f13150K0.getOffset(date.getTime()) - this.f13151L0.getOffset(date.getTime())))));
    }

    /* access modifiers changed from: private */
    public String u1(String str) {
        if (str == null) {
            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
        }
        Date date = new Date();
        try {
            date = this.f13152M0.parse(str);
        } catch (ParseException e8) {
            if (e8.getMessage() != null) {
                Log.d("EQN", e8.getMessage());
            }
        }
        Date date2 = new Date(date.getTime() - ((long) (this.f13150K0.getOffset(date.getTime()) - this.f13151L0.getOffset(date.getTime()))));
        Calendar instance = Calendar.getInstance();
        instance.setTime(date2);
        int n12 = n1(instance.get(10), instance.get(12));
        return r1(n12) + " " + this.f13153N0.format(date2);
    }

    /* access modifiers changed from: private */
    public double v1(double d8, double d9, double d10, double d11) {
        double pow = Math.pow(Math.sin(((((d8 - d10) / 360.0d) * 2.0d) * 3.141592653589793d) / 2.0d), 2.0d) + (Math.cos((d8 / 360.0d) * 2.0d * 3.141592653589793d) * Math.cos((d10 / 360.0d) * 2.0d * 3.141592653589793d) * Math.pow(Math.sin(((((d9 - d11) / 360.0d) * 2.0d) * 3.141592653589793d) / 2.0d), 2.0d));
        return Math.atan2(Math.sqrt(pow), Math.sqrt(1.0d - pow)) * 2.0d * 6371.0d;
    }

    private boolean w1() {
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

    /* access modifiers changed from: private */
    public void x1() {
        FrameLayout frameLayout = (FrameLayout) findViewById(C2030R.id.ad_view_container);
        AdView adView = new AdView(this);
        this.f13156P = adView;
        adView.setAdUnitId("ca-app-pub-4050044861382446/6189681827");
        frameLayout.removeAllViews();
        frameLayout.addView(this.f13156P);
        this.f13156P.setAdSize(l1());
        this.f13156P.loadAd(new AdRequest.Builder().build());
    }

    private void y1() {
        Polyline[] polylineArr;
        if (this.f13158Q != null && (polylineArr = this.f13194l0) != null) {
            for (Polyline polyline : polylineArr) {
                if (polyline != null) {
                    polyline.remove();
                }
            }
        }
    }

    private void z1() {
        if (this.f13158Q != null) {
            this.f13167U0.getItem(2).setVisible(false);
            ((LinearLayout) findViewById(C2030R.id.LinearHazard)).setVisibility(8);
            this.f13169V0.remove();
        }
    }

    public void onActivityResult(int i8, int i9, Intent intent) {
        super.onActivityResult(i8, i9, intent);
    }

    public void onCameraIdle() {
        GoogleMap googleMap = this.f13158Q;
        if (googleMap == null) {
            return;
        }
        if (this.f13160R == 3) {
            LatLngBounds latLngBounds = googleMap.getProjection().getVisibleRegion().latLngBounds;
            LatLng latLng = this.f13158Q.getCameraPosition().target;
            PolylineOptions polylineOptions = new PolylineOptions();
            PolylineOptions polylineOptions2 = new PolylineOptions();
            polylineOptions.add(new LatLng(latLng.latitude, latLngBounds.southwest.longitude), new LatLng(latLng.latitude, latLngBounds.northeast.longitude));
            polylineOptions2.add(new LatLng(latLngBounds.southwest.latitude, latLng.longitude), new LatLng(latLngBounds.northeast.latitude, latLng.longitude));
            Polyline polyline = this.f13173X0;
            if (polyline != null) {
                polyline.remove();
            }
            Polyline polyline2 = this.f13175Y0;
            if (polyline2 != null) {
                polyline2.remove();
            }
            this.f13173X0 = this.f13158Q.addPolyline(polylineOptions);
            this.f13175Y0 = this.f13158Q.addPolyline(polylineOptions2);
            if ((getResources().getConfiguration().uiMode & 48) == 16) {
                this.f13173X0.setColor(-16776961);
                this.f13175Y0.setColor(-16776961);
            } else {
                this.f13173X0.setColor(-1);
                this.f13175Y0.setColor(-1);
            }
            this.f13173X0.setWidth(5.0f);
            this.f13175Y0.setWidth(5.0f);
        } else if (this.f13159Q0) {
            G1(this.f13161R0, this.f13163S0, this.f13165T0);
        }
    }

    public void onCameraMove() {
        if (this.f13160R == 3) {
            LatLngBounds latLngBounds = this.f13158Q.getProjection().getVisibleRegion().latLngBounds;
            LatLng latLng = this.f13158Q.getCameraPosition().target;
            PolylineOptions polylineOptions = new PolylineOptions();
            PolylineOptions polylineOptions2 = new PolylineOptions();
            polylineOptions.add(new LatLng(latLng.latitude, latLngBounds.southwest.longitude), new LatLng(latLng.latitude, latLngBounds.northeast.longitude));
            polylineOptions2.add(new LatLng(latLngBounds.southwest.latitude, latLng.longitude), new LatLng(latLngBounds.northeast.latitude, latLng.longitude));
            Polyline polyline = this.f13173X0;
            if (polyline != null) {
                polyline.remove();
            }
            Polyline polyline2 = this.f13175Y0;
            if (polyline2 != null) {
                polyline2.remove();
            }
            this.f13173X0 = this.f13158Q.addPolyline(polylineOptions);
            this.f13175Y0 = this.f13158Q.addPolyline(polylineOptions2);
            if ((getResources().getConfiguration().uiMode & 48) == 16) {
                this.f13173X0.setColor(-16776961);
                this.f13175Y0.setColor(-16776961);
            } else {
                this.f13173X0.setColor(-1);
                this.f13175Y0.setColor(-1);
            }
            this.f13173X0.setWidth(5.0f);
            this.f13175Y0.setWidth(5.0f);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2030R.layout.globe);
        int i8 = getResources().getConfiguration().uiMode & 48;
        if (Build.VERSION.SDK_INT >= 35 && i8 == 16) {
            Window window = getWindow();
            C0832r0.a(window, window.getDecorView()).d(true);
        }
        Bundle extras = getIntent().getExtras();
        this.f13154O = extras;
        this.f13160R = extras.getInt("com.finazzi.distquake.map_type");
        this.f13206x0 = getSharedPreferences(MainActivity.class.getSimpleName(), 0);
        this.f13207y0 = androidx.preference.g.b(this);
        this.f13208z0 = this.f13206x0.getInt("map_satellite", 0);
        this.f13140A0 = this.f13206x0.getInt("map_showplates", 0);
        this.f13143D0 = this.f13206x0.getInt("eqn_marker_size", 0);
        this.f13144E0 = this.f13206x0.getInt("eqn_marker_size_reports", 0);
        this.f13145F0 = this.f13206x0.getInt("filter_type", 2);
        this.f13146G0 = this.f13206x0.getFloat("filter_list_radius", 250.0f);
        this.f13157P0 = this.f13206x0.getBoolean("pro_features", false);
        this.f13206x0.getInt("ads_type", 0);
        this.f13147H0 = this.f13207y0.getString("eqn_system_of_units", "0");
        this.f13150K0 = TimeZone.getTimeZone("Europe/Paris");
        this.f13151L0 = TimeZone.getDefault();
        this.f13152M0 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        this.f13153N0 = new SimpleDateFormat("HH:mm:ss dd-MMM", Locale.getDefault());
        Toolbar toolbar = (Toolbar) findViewById(C2030R.id.toolbar);
        b0(toolbar);
        if (!this.f13157P0) {
            toolbar.setLogo(2131230872);
        } else {
            toolbar.setLogo(2131230875);
        }
        this.f13205w0 = this;
        if (this.f13160R == 0) {
            ((LinearLayout) findViewById(C2030R.id.filterLayout)).setVisibility(0);
            ((Spinner) findViewById(C2030R.id.spinner1)).setVisibility(8);
            ((Spinner) findViewById(C2030R.id.spinner2)).setVisibility(0);
            this.f13164T = this.f13154O.getDoubleArray("com.finazzi.distquake.latitude_vector");
            this.f13166U = this.f13154O.getDoubleArray("com.finazzi.distquake.longitude_vector");
            this.f13182c0 = this.f13154O.getIntArray("com.finazzi.distquake.state_vector");
            this.f13188f0 = this.f13154O.getIntArray("com.finazzi.distquake.ns_vector");
            this.f13186e0 = this.f13154O.getIntArray("com.finazzi.distquake.code_vector");
            this.f13192j0 = this.f13154O.getStringArray("com.finazzi.distquake.date_vector");
            this.f13176Z = this.f13154O.getDoubleArray("com.finazzi.distquake.median_acceleration_vector");
            this.f13168V = this.f13154O.getDoubleArray("com.finazzi.distquake.magnitude_vector");
        }
        if (this.f13160R == 1) {
            ((LinearLayout) findViewById(C2030R.id.filterLayout)).setVisibility(0);
            if (i8 == 16) {
                ((LinearLayout) findViewById(C2030R.id.linearMercalli)).setVisibility(0);
            } else {
                ((LinearLayout) findViewById(C2030R.id.linearMercalliNight)).setVisibility(0);
            }
            ((Spinner) findViewById(C2030R.id.spinner1)).setVisibility(0);
            ((Spinner) findViewById(C2030R.id.spinner2)).setVisibility(8);
            this.f13164T = this.f13154O.getDoubleArray("com.finazzi.distquake.latitude_vector");
            this.f13166U = this.f13154O.getDoubleArray("com.finazzi.distquake.longitude_vector");
            this.f13178a0 = this.f13154O.getIntArray("com.finazzi.distquake.intensity_vector");
            this.f13192j0 = this.f13154O.getStringArray("com.finazzi.distquake.date_vector");
        }
        if (this.f13160R == 2) {
            ((LinearLayout) findViewById(C2030R.id.filterLayout)).setVisibility(0);
            ((Spinner) findViewById(C2030R.id.spinner1)).setVisibility(8);
            ((Spinner) findViewById(C2030R.id.spinner2)).setVisibility(8);
            this.f13164T = this.f13154O.getDoubleArray("com.finazzi.distquake.latitude_vector");
            this.f13166U = this.f13154O.getDoubleArray("com.finazzi.distquake.longitude_vector");
            this.f13168V = this.f13154O.getDoubleArray("com.finazzi.distquake.magnitude_vector");
            this.f13170W = this.f13154O.getStringArray("com.finazzi.distquake.magnitude_type_vector");
            this.f13172X = this.f13154O.getDoubleArray("com.finazzi.distquake.magnitude_range_vector");
            this.f13174Y = this.f13154O.getIntArray("com.finazzi.distquake.preliminary_vector");
            this.f13180b0 = this.f13154O.getDoubleArray("com.finazzi.distquake.depth_vector");
            this.f13184d0 = this.f13154O.getStringArray("com.finazzi.distquake.location_vector");
            this.f13190h0 = this.f13154O.getIntArray("com.finazzi.distquake.pop100_vector");
            this.f13191i0 = this.f13154O.getStringArray("com.finazzi.distquake.provider_vector");
            this.f13192j0 = this.f13154O.getStringArray("com.finazzi.distquake.date_vector");
        }
        if (this.f13160R == 3) {
            Button button = (Button) findViewById(C2030R.id.button2);
            button.setVisibility(0);
            button.setOnClickListener(new C1873u1(this));
        } else {
            ((Button) findViewById(C2030R.id.button2)).setVisibility(8);
        }
        if (this.f13160R <= 3) {
            MaterialButton materialButton = (MaterialButton) findViewById(C2030R.id.button_hazard);
            if (this.f13141B0 == 1) {
                materialButton.setIconTintMode(PorterDuff.Mode.SCREEN);
            } else {
                materialButton.setIconTintMode(PorterDuff.Mode.SRC_IN);
            }
            materialButton.setOnClickListener(new C1879v1(this, materialButton));
            MaterialButton materialButton2 = (MaterialButton) findViewById(C2030R.id.button_faults);
            if (this.f13140A0 == 1) {
                materialButton2.setIconTintMode(PorterDuff.Mode.SCREEN);
            } else {
                materialButton2.setIconTintMode(PorterDuff.Mode.SRC_IN);
            }
            materialButton2.setOnClickListener(new C1885w1(this, materialButton2));
            MaterialButton materialButton3 = (MaterialButton) findViewById(C2030R.id.button_eu);
            if (this.f13142C0 == 1) {
                materialButton3.setIconTintMode(PorterDuff.Mode.SCREEN);
            } else {
                materialButton3.setIconTintMode(PorterDuff.Mode.SRC_IN);
            }
            materialButton3.setOnClickListener(new C1891x1(this, materialButton3));
            MaterialButton materialButton4 = (MaterialButton) findViewById(C2030R.id.button_satellite);
            if (this.f13208z0 == 1) {
                materialButton4.setIconTintMode(PorterDuff.Mode.SCREEN);
            } else {
                materialButton4.setIconTintMode(PorterDuff.Mode.SRC_IN);
            }
            materialButton4.setOnClickListener(new C1897y1(this, materialButton4));
        }
        if (this.f13160R == 9) {
            ((LinearLayout) findViewById(C2030R.id.filterLayout)).setVisibility(8);
            ((Spinner) findViewById(C2030R.id.spinner1)).setVisibility(8);
            ((Spinner) findViewById(C2030R.id.spinner2)).setVisibility(8);
        }
        if (!this.f13157P0 && H3.f.a(this).canRequestAds()) {
            MobileAds.initialize(this, new C1825m1(this));
        }
        Spinner spinner = (Spinner) findViewById(C2030R.id.spinner1);
        spinner.setSelection(0);
        spinner.setOnItemSelectedListener(new a());
        Spinner spinner2 = (Spinner) findViewById(C2030R.id.spinner2);
        spinner2.setSelection(1);
        spinner2.setOnItemSelectedListener(new b());
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C2030R.menu.provider_menu2, menu);
        if (this.f13160R != 2) {
            menu.getItem(0).setVisible(false);
        }
        if (this.f13160R == 9) {
            menu.getItem(0).setVisible(false);
            menu.getItem(1).setVisible(false);
        }
        if (this.f13160R == 1) {
            menu.getItem(0).setVisible(true);
        }
        this.f13167U0 = menu;
        return super.onCreateOptionsMenu(menu);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        AdView adView = this.f13156P;
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }

    public void onInfoWindowClick(Marker marker) {
        marker.hideInfoWindow();
    }

    public void onMapReady(GoogleMap googleMap) {
        this.f13158Q = googleMap;
        B1();
    }

    /* JADX WARNING: Removed duplicated region for block: B:37:0x01dc  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onMarkerClick(com.google.android.gms.maps.model.Marker r22) {
        /*
            r21 = this;
            r0 = r21
            r1 = 1
            com.google.android.gms.maps.model.Marker[] r2 = r0.f13195m0
            r3 = 0
            if (r2 == 0) goto L_0x01df
            r2 = -1
            r4 = r3
        L_0x000a:
            com.google.android.gms.maps.model.Marker[] r5 = r0.f13195m0
            int r6 = r5.length
            if (r4 >= r6) goto L_0x001e
            r5 = r5[r4]
            r6 = r22
            if (r5 == 0) goto L_0x001c
            boolean r5 = r6.equals(r5)
            if (r5 == 0) goto L_0x001c
            r2 = r4
        L_0x001c:
            int r4 = r4 + r1
            goto L_0x000a
        L_0x001e:
            r6 = r22
            r0.f13177Z0 = r2
            if (r2 < 0) goto L_0x01df
            int r4 = r0.f13160R
            r5 = 2
            if (r4 != 0) goto L_0x01d7
            int[] r4 = r0.f13182c0
            r2 = r4[r2]
            if (r2 != r5) goto L_0x01d7
            android.view.LayoutInflater r2 = android.view.LayoutInflater.from(r0)
            r4 = 2131493077(0x7f0c00d5, float:1.8609624E38)
            r7 = 0
            android.view.View r9 = r2.inflate(r4, r7)
            r4 = 2131493085(0x7f0c00dd, float:1.860964E38)
            android.view.View r2 = r2.inflate(r4, r7)
            r4 = 2131297051(0x7f09031b, float:1.8212036E38)
            android.view.View r4 = r2.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            java.lang.String[] r7 = r0.f13192j0
            int r8 = r0.f13177Z0
            r7 = r7[r8]
            java.lang.String r7 = r0.p1(r7)
            r4.setText(r7)
            r4 = 2131297063(0x7f090327, float:1.821206E38)
            android.view.View r4 = r9.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r7 = 2131886702(0x7f12026e, float:1.940799E38)
            java.lang.String r7 = r0.getString(r7)
            int[] r8 = r0.f13188f0
            int r10 = r0.f13177Z0
            r8 = r8[r10]
            java.lang.String r8 = java.lang.Integer.toString(r8)
            java.lang.Object[] r10 = new java.lang.Object[r1]
            r10[r3] = r8
            java.lang.String r7 = java.lang.String.format(r7, r10)
            r4.setText(r7)
            r4 = 2131297068(0x7f09032c, float:1.821207E38)
            android.view.View r4 = r9.findViewById(r4)
            android.widget.TextView r4 = (android.widget.TextView) r4
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String[] r8 = r0.f13192j0
            int r10 = r0.f13177Z0
            r8 = r8[r10]
            java.lang.String r8 = r0.t1(r8)
            r7.append(r8)
            java.lang.String r8 = " "
            r7.append(r8)
            r8 = 2131887109(0x7f120405, float:1.9408816E38)
            java.lang.String r8 = r0.getString(r8)
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r4.setText(r7)
            android.app.AlertDialog$Builder r4 = new android.app.AlertDialog$Builder
            r4.<init>(r0)
            r4.setCancelable(r1)
            r7 = 2131886695(0x7f120267, float:1.9407976E38)
            java.lang.String r7 = r0.getString(r7)
            u2.n1 r8 = new u2.n1
            r8.<init>()
            r4.setPositiveButton(r7, r8)
            r4.setCustomTitle(r2)
            android.app.AlertDialog r8 = r4.create()
            r12 = 0
            r13 = 0
            r10 = 0
            r11 = 0
            r8.setView(r9, r10, r11, r12, r13)
            r8.setInverseBackgroundForced(r1)
            r8.show()
            r2 = 2131296392(0x7f090088, float:1.82107E38)
            android.view.View r2 = r9.findViewById(r2)
            android.widget.Button r2 = (android.widget.Button) r2
            u2.o1 r4 = new u2.o1
            r4.<init>(r0, r8)
            r2.setOnClickListener(r4)
            com.google.android.gms.maps.model.Circle[] r2 = r0.f13196n0
            int r4 = r2.length
            r7 = r3
        L_0x00ee:
            if (r7 >= r4) goto L_0x00f9
            r8 = r2[r7]
            if (r8 == 0) goto L_0x00f7
            r8.remove()
        L_0x00f7:
            int r7 = r7 + r1
            goto L_0x00ee
        L_0x00f9:
            double[] r2 = r0.f13168V
            int r4 = r0.f13177Z0
            r7 = r2[r4]
            r9 = 0
            int r2 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r2 <= 0) goto L_0x01d7
            r9 = 4607317526788838523(0x3ff07ae147ae147b, double:1.03)
            double r7 = r7 * r9
            r9 = -4610132276555945083(0xc005851eb851eb85, double:-2.69)
            double r9 = r9 + r7
            r11 = 4612023788399440691(0x4001333333333333, double:2.15)
            double r9 = r9 / r11
            r13 = 4621819117588971520(0x4024000000000000, double:10.0)
            double r9 = java.lang.Math.pow(r13, r9)
            r15 = -4618981849823728108(0xbfe6147ae147ae14, double:-0.69)
            double r15 = r15 + r7
            r4 = r1
            double r1 = r15 / r11
            double r1 = java.lang.Math.pow(r13, r1)
            r15 = 4599256083455845336(0x3fd3d70a3d70a3d8, double:0.31000000000000005)
            double r7 = r7 + r15
            double r7 = r7 / r11
            double r7 = java.lang.Math.pow(r13, r7)
            r11 = 3
            com.google.android.gms.maps.model.Circle[] r11 = new com.google.android.gms.maps.model.Circle[r11]
            r0.f13196n0 = r11
            com.google.android.gms.maps.model.CircleOptions r11 = new com.google.android.gms.maps.model.CircleOptions
            r11.<init>()
            com.google.android.gms.maps.model.LatLng r12 = new com.google.android.gms.maps.model.LatLng
            double[] r13 = r0.f13164T
            int r14 = r0.f13177Z0
            r16 = r4
            r15 = r5
            r4 = r13[r14]
            double[] r13 = r0.f13166U
            r17 = r1
            r1 = r13[r14]
            r12.<init>(r4, r1)
            r11.center(r12)
            android.view.WindowManager r1 = r0.getWindowManager()
            android.view.Display r1 = r1.getDefaultDisplay()
            android.util.DisplayMetrics r2 = new android.util.DisplayMetrics
            r2.<init>()
            r1.getMetrics(r2)
            int r1 = r2.widthPixels
            float r1 = (float) r1
            r2 = 1120403456(0x42c80000, float:100.0)
            float r1 = r1 / r2
            double r1 = (double) r1
            double r1 = java.lang.Math.ceil(r1)
            float r1 = (float) r1
            r4 = 4617315517961601024(0x4014000000000000, double:5.0)
            int r2 = (r9 > r4 ? 1 : (r9 == r4 ? 0 : -1))
            r12 = 200(0xc8, float:2.8E-43)
            r13 = 4652007308841189376(0x408f400000000000, double:1000.0)
            r19 = r4
            r4 = 255(0xff, float:3.57E-43)
            if (r2 <= 0) goto L_0x019b
            double r9 = r9 * r13
            r11.radius(r9)
            r11.strokeWidth(r1)
            int r2 = android.graphics.Color.argb(r4, r12, r3, r3)
            r11.strokeColor(r2)
            com.google.android.gms.maps.model.Circle[] r2 = r0.f13196n0
            com.google.android.gms.maps.GoogleMap r5 = r0.f13158Q
            com.google.android.gms.maps.model.Circle r5 = r5.addCircle(r11)
            r2[r3] = r5
        L_0x019b:
            int r2 = (r17 > r19 ? 1 : (r17 == r19 ? 0 : -1))
            if (r2 <= 0) goto L_0x01b8
            double r9 = r17 * r13
            r11.radius(r9)
            r11.strokeWidth(r1)
            int r2 = android.graphics.Color.argb(r4, r4, r12, r3)
            r11.strokeColor(r2)
            com.google.android.gms.maps.model.Circle[] r2 = r0.f13196n0
            com.google.android.gms.maps.GoogleMap r5 = r0.f13158Q
            com.google.android.gms.maps.model.Circle r5 = r5.addCircle(r11)
            r2[r16] = r5
        L_0x01b8:
            int r2 = (r7 > r19 ? 1 : (r7 == r19 ? 0 : -1))
            if (r2 <= 0) goto L_0x01d8
            double r7 = r7 * r13
            r11.radius(r7)
            r11.strokeWidth(r1)
            r1 = 50
            int r1 = android.graphics.Color.argb(r4, r1, r4, r1)
            r11.strokeColor(r1)
            com.google.android.gms.maps.model.Circle[] r1 = r0.f13196n0
            com.google.android.gms.maps.GoogleMap r2 = r0.f13158Q
            com.google.android.gms.maps.model.Circle r2 = r2.addCircle(r11)
            r1[r15] = r2
            goto L_0x01d8
        L_0x01d7:
            r15 = r5
        L_0x01d8:
            int r1 = r0.f13160R
            if (r1 != r15) goto L_0x01df
            r6.showInfoWindow()
        L_0x01df:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.GlobeActivityAll.onMarkerClick(com.google.android.gms.maps.model.Marker):boolean");
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == 16908332) {
            finish();
            return true;
        } else if (itemId == C2030R.id.menu_update) {
            if (this.f13160R == 1) {
                int i8 = this.f13144E0 + 1;
                this.f13144E0 = i8;
                if (i8 > 1) {
                    this.f13144E0 = 0;
                }
                SharedPreferences.Editor edit = this.f13206x0.edit();
                edit.putInt("eqn_marker_size_reports", this.f13144E0);
                edit.apply();
                GoogleMap googleMap = this.f13158Q;
                if (googleMap != null) {
                    googleMap.clear();
                    this.f13158Q = null;
                }
                C1();
            }
            if (this.f13160R == 2) {
                int i9 = this.f13143D0 + 1;
                this.f13143D0 = i9;
                if (i9 > 2) {
                    this.f13143D0 = 0;
                }
                SharedPreferences.Editor edit2 = this.f13206x0.edit();
                edit2.putInt("eqn_marker_size", this.f13143D0);
                edit2.apply();
                GoogleMap googleMap2 = this.f13158Q;
                if (googleMap2 != null) {
                    googleMap2.clear();
                    this.f13158Q = null;
                }
                C1();
            }
            return true;
        } else if (itemId == C2030R.id.menu_share) {
            GoogleMap googleMap3 = this.f13158Q;
            if (googleMap3 != null) {
                googleMap3.snapshot(this);
            }
            return true;
        } else if (itemId != C2030R.id.menu_help) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            Intent intent = new Intent().setClass(this, Help.class);
            intent.putExtra("com.finazzi.distquake.help_type", 3);
            startActivity(intent);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        this.f13155O0 = false;
        AdView adView = this.f13156P;
        if (adView != null) {
            adView.pause();
        }
        SharedPreferences.Editor edit = this.f13206x0.edit();
        long currentTimeMillis = System.currentTimeMillis();
        edit.putLong("last_map_time", currentTimeMillis);
        edit.putLong("map_spent_time", currentTimeMillis - this.f13183c1);
        edit.apply();
        int i8 = this.f13160R;
        if ((i8 == 0 || i8 == 7) && this.f13158Q != null) {
            try {
                OutputStreamWriter outputStreamWriter = new OutputStreamWriter(openFileOutput("mapcenter.txt", 0), StandardCharsets.UTF_8);
                float f8 = this.f13158Q.getCameraPosition().zoom;
                outputStreamWriter.write(f8 + "\r\n");
                outputStreamWriter.flush();
                LatLng latLng = this.f13158Q.getCameraPosition().target;
                outputStreamWriter.write(((int) (latLng.latitude * 1000000.0d)) + "\r\n");
                outputStreamWriter.flush();
                int i9 = (int) (latLng.longitude * 1000000.0d);
                outputStreamWriter.write(i9 + "\r\n");
                outputStreamWriter.flush();
                outputStreamWriter.close();
            } catch (IOException e8) {
                if (e8.getMessage() != null) {
                    Log.d("EQN", e8.getMessage());
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        AdView adView;
        super.onResume();
        this.f13155O0 = true;
        if (!this.f13157P0 && (adView = this.f13156P) != null) {
            adView.resume();
        }
        if (w1()) {
            float[] s12 = s1();
            this.f13203u0 = s12[0];
            this.f13204v0 = s12[1];
        } else {
            this.f13203u0 = BitmapDescriptorFactory.HUE_RED;
            this.f13204v0 = BitmapDescriptorFactory.HUE_RED;
        }
        C1();
    }

    public void onSnapshotReady(Bitmap bitmap) {
        String str = getFilesDir().toString() + "/earthquake_share.png";
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), 2131230872);
        Bitmap.Config config = Bitmap.Config.ARGB_8888;
        boolean z7 = true;
        Bitmap copy = decodeResource.copy(config, true);
        float f8 = getResources().getDisplayMetrics().density;
        String str2 = getString(C2030R.string.app_name) + " App";
        Bitmap bitmap2 = bitmap;
        Bitmap copy2 = bitmap2.copy(config, true);
        Canvas canvas = new Canvas(copy2);
        Paint paint = new Paint(1);
        int i8 = getResources().getConfiguration().uiMode & 48;
        if (this.f13158Q.getMapType() == 1 && i8 == 16) {
            paint.setColor(Color.rgb(255, 0, 0));
        } else {
            paint.setColor(Color.rgb(255, 255, 255));
        }
        paint.setTextSize((float) ((int) (16.0f * f8)));
        paint.setTypeface(Typeface.DEFAULT_BOLD);
        paint.getTextBounds(str2, 0, str2.length(), new Rect());
        canvas.drawText(str2, ((float) copy.getWidth()) + (f8 * 5.0f), (((float) copy.getHeight()) / 2.0f) + 5.0f + (f8 * 6.0f), paint);
        canvas.drawBitmap(copy, 5.0f, 5.0f, paint);
        paint.setColor(Color.argb(60, 0, 0, 0));
        bitmap2.recycle();
        decodeResource.recycle();
        copy.recycle();
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
            copy2.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (IOException unused) {
            z7 = false;
        }
        Intent intent = new Intent("android.intent.action.SEND");
        if (z7) {
            Uri h8 = FileProvider.h(getApplicationContext(), getPackageName() + ".fileprovider", new File(str));
            intent.setType("image/png");
            intent.putExtra("android.intent.extra.STREAM", h8);
            intent.putExtra("android.intent.extra.SUBJECT", getString(C2030R.string.app_name));
            intent.putExtra("android.intent.extra.TEXT", getString(C2030R.string.main_share_text));
        } else {
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", getString(C2030R.string.app_name));
            intent.putExtra("android.intent.extra.TEXT", getString(C2030R.string.main_share_text));
        }
        startActivity(Intent.createChooser(intent, getString(C2030R.string.share_share)));
    }
}
