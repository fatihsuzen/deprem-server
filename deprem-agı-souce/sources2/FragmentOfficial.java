package com.finazzi.distquake;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.GradientDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.CalendarContract;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.core.content.FileProvider;
import androidx.core.view.B;
import androidx.core.view.C;
import androidx.fragment.app.C0887n;
import androidx.fragment.app.C0891s;
import androidx.lifecycle.C0910l;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.android.gms.tasks.Task;
import com.google.android.material.button.MaterialButton;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import u2.C1753a1;
import u2.C1759b1;
import u2.C1765c1;
import u2.C1771d1;
import u2.C1777e1;
import u2.C1783f1;
import u2.C1789g1;
import u2.C1795h1;
import u2.C1801i1;
import u2.C1807j1;
import u2.C1813k1;
import u2.X0;
import u2.Y0;
import u2.Z0;

public class FragmentOfficial extends C0887n implements OnMapReadyCallback, GoogleMap.SnapshotReadyCallback {
    /* access modifiers changed from: private */

    /* renamed from: A0  reason: collision with root package name */
    public int[] f12905A0;
    /* access modifiers changed from: private */

    /* renamed from: B0  reason: collision with root package name */
    public int[] f12906B0;
    /* access modifiers changed from: private */

    /* renamed from: C0  reason: collision with root package name */
    public int[] f12907C0;
    /* access modifiers changed from: private */

    /* renamed from: D0  reason: collision with root package name */
    public boolean[] f12908D0;

    /* renamed from: E0  reason: collision with root package name */
    private int f12909E0 = 0;
    /* access modifiers changed from: private */

    /* renamed from: F0  reason: collision with root package name */
    public double f12910F0 = 0.0d;
    /* access modifiers changed from: private */

    /* renamed from: G0  reason: collision with root package name */
    public double f12911G0 = 0.0d;
    /* access modifiers changed from: private */

    /* renamed from: H0  reason: collision with root package name */
    public double f12912H0 = 0.0d;
    /* access modifiers changed from: private */

    /* renamed from: I0  reason: collision with root package name */
    public double f12913I0 = 0.0d;
    /* access modifiers changed from: private */

    /* renamed from: J0  reason: collision with root package name */
    public float f12914J0 = 250.0f;
    /* access modifiers changed from: private */

    /* renamed from: K0  reason: collision with root package name */
    public float f12915K0 = BitmapDescriptorFactory.HUE_RED;

    /* renamed from: L0  reason: collision with root package name */
    private String f12916L0 = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;

    /* renamed from: M0  reason: collision with root package name */
    private float f12917M0 = 1.0f;

    /* renamed from: N0  reason: collision with root package name */
    private float f12918N0 = BitmapDescriptorFactory.HUE_RED;

    /* renamed from: O0  reason: collision with root package name */
    private float f12919O0 = BitmapDescriptorFactory.HUE_RED;
    /* access modifiers changed from: private */

    /* renamed from: P0  reason: collision with root package name */
    public int f12920P0 = 0;

    /* renamed from: Q0  reason: collision with root package name */
    private int f12921Q0 = 0;
    /* access modifiers changed from: private */

    /* renamed from: R0  reason: collision with root package name */
    public int f12922R0 = 0;
    /* access modifiers changed from: private */

    /* renamed from: S0  reason: collision with root package name */
    public int f12923S0 = 0;
    /* access modifiers changed from: private */

    /* renamed from: T0  reason: collision with root package name */
    public SharedPreferences f12924T0;
    /* access modifiers changed from: private */

    /* renamed from: U0  reason: collision with root package name */
    public SharedPreferences.Editor f12925U0;
    /* access modifiers changed from: private */

    /* renamed from: V0  reason: collision with root package name */
    public List f12926V0;
    /* access modifiers changed from: private */

    /* renamed from: W0  reason: collision with root package name */
    public h f12927W0;
    /* access modifiers changed from: private */

    /* renamed from: X0  reason: collision with root package name */
    public RecyclerView f12928X0;
    /* access modifiers changed from: private */

    /* renamed from: Y0  reason: collision with root package name */
    public String f12929Y0;

    /* renamed from: Z0  reason: collision with root package name */
    private TimeZone f12930Z0;

    /* renamed from: a1  reason: collision with root package name */
    private TimeZone f12931a1;

    /* renamed from: b1  reason: collision with root package name */
    private SimpleDateFormat f12932b1;

    /* renamed from: c1  reason: collision with root package name */
    private SimpleDateFormat f12933c1;

    /* renamed from: d1  reason: collision with root package name */
    private Calendar f12934d1;
    /* access modifiers changed from: private */

    /* renamed from: e1  reason: collision with root package name */
    public int f12935e1 = 0;

    /* renamed from: f1  reason: collision with root package name */
    private final int f12936f1 = 2;
    /* access modifiers changed from: private */

    /* renamed from: g1  reason: collision with root package name */
    public String f12937g1 = "0";
    /* access modifiers changed from: private */

    /* renamed from: h1  reason: collision with root package name */
    public boolean f12938h1;
    /* access modifiers changed from: private */

    /* renamed from: i1  reason: collision with root package name */
    public boolean f12939i1;
    /* access modifiers changed from: private */

    /* renamed from: j1  reason: collision with root package name */
    public boolean f12940j1;
    /* access modifiers changed from: private */

    /* renamed from: k1  reason: collision with root package name */
    public boolean f12941k1;

    /* renamed from: l1  reason: collision with root package name */
    private int f12942l1;
    /* access modifiers changed from: private */

    /* renamed from: m1  reason: collision with root package name */
    public int f12943m1;
    /* access modifiers changed from: private */

    /* renamed from: n0  reason: collision with root package name */
    public View f12944n0;

    /* renamed from: n1  reason: collision with root package name */
    private Bundle f12945n1;
    /* access modifiers changed from: private */

    /* renamed from: o0  reason: collision with root package name */
    public double[] f12946o0;
    /* access modifiers changed from: private */

    /* renamed from: o1  reason: collision with root package name */
    public GoogleMap f12947o1;
    /* access modifiers changed from: private */

    /* renamed from: p0  reason: collision with root package name */
    public double[] f12948p0;
    /* access modifiers changed from: private */

    /* renamed from: p1  reason: collision with root package name */
    public Bitmap f12949p1;
    /* access modifiers changed from: private */

    /* renamed from: q0  reason: collision with root package name */
    public double[] f12950q0;
    /* access modifiers changed from: private */

    /* renamed from: q1  reason: collision with root package name */
    public Bitmap f12951q1;
    /* access modifiers changed from: private */

    /* renamed from: r0  reason: collision with root package name */
    public String[] f12952r0;
    /* access modifiers changed from: private */

    /* renamed from: r1  reason: collision with root package name */
    public double f12953r1;
    /* access modifiers changed from: private */

    /* renamed from: s0  reason: collision with root package name */
    public double[] f12954s0;
    /* access modifiers changed from: private */

    /* renamed from: s1  reason: collision with root package name */
    public int f12955s1 = -1;
    /* access modifiers changed from: private */

    /* renamed from: t0  reason: collision with root package name */
    public double[] f12956t0;

    /* renamed from: t1  reason: collision with root package name */
    private boolean f12957t1;
    /* access modifiers changed from: private */

    /* renamed from: u0  reason: collision with root package name */
    public String[] f12958u0;
    /* access modifiers changed from: private */

    /* renamed from: u1  reason: collision with root package name */
    public Pattern f12959u1;
    /* access modifiers changed from: private */

    /* renamed from: v0  reason: collision with root package name */
    public int[] f12960v0;
    /* access modifiers changed from: private */

    /* renamed from: v1  reason: collision with root package name */
    public boolean f12961v1 = false;
    /* access modifiers changed from: private */

    /* renamed from: w0  reason: collision with root package name */
    public String[] f12962w0;
    /* access modifiers changed from: private */

    /* renamed from: w1  reason: collision with root package name */
    public String f12963w1 = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    /* access modifiers changed from: private */

    /* renamed from: x0  reason: collision with root package name */
    public String[] f12964x0;
    /* access modifiers changed from: private */

    /* renamed from: y0  reason: collision with root package name */
    public double[] f12965y0;
    /* access modifiers changed from: private */

    /* renamed from: z0  reason: collision with root package name */
    public int[] f12966z0;

    class a extends RecyclerView.u {
        a() {
        }

        public void a(RecyclerView recyclerView, int i8) {
            super.a(recyclerView, i8);
        }

        public void b(RecyclerView recyclerView, int i8, int i9) {
            super.b(recyclerView, i8, i9);
            if (FragmentOfficial.this.f12951q1 != null) {
                int Z12 = ((LinearLayoutManager) FragmentOfficial.this.f12928X0.getLayoutManager()).Z1();
                int e22 = ((LinearLayoutManager) FragmentOfficial.this.f12928X0.getLayoutManager()).e2();
                ImageView imageView = (ImageView) FragmentOfficial.this.f12944n0.findViewById(C2030R.id.imageView1);
                if (Z12 == 0 && e22 == FragmentOfficial.this.f12927W0.j()) {
                    imageView.setVisibility(8);
                } else if (Z12 != FragmentOfficial.this.f12955s1) {
                    Paint paint = new Paint();
                    paint.setColor(-65536);
                    paint.setStyle(Paint.Style.STROKE);
                    paint.setStrokeWidth(3.0f);
                    Bitmap createBitmap = Bitmap.createBitmap(FragmentOfficial.this.f12951q1);
                    Canvas canvas = new Canvas(createBitmap);
                    canvas.drawRect(1.5f, (float) (((double) Z12) * FragmentOfficial.this.f12953r1), (float) (((double) canvas.getWidth()) - 1.5d), (float) (((double) (Z12 + 1)) * FragmentOfficial.this.f12953r1), paint);
                    imageView.setImageBitmap(createBitmap);
                    int unused = FragmentOfficial.this.f12955s1 = Z12;
                }
            }
        }
    }

    class b implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f12968a;

        b(View view) {
            this.f12968a = view;
        }

        public void onProgressChanged(SeekBar seekBar, int i8, boolean z7) {
            TextView textView = (TextView) this.f12968a.findViewById(C2030R.id.textView3);
            if (i8 == 0) {
                float unused = FragmentOfficial.this.f12914J0 = 100.0f;
                if (FragmentOfficial.this.f12929Y0.equals("0")) {
                    textView.setText("100 km");
                } else {
                    textView.setText("60 mi");
                }
            } else if (i8 == 1) {
                float unused2 = FragmentOfficial.this.f12914J0 = 250.0f;
                if (FragmentOfficial.this.f12929Y0.equals("0")) {
                    textView.setText("250 km");
                } else {
                    textView.setText("150 mi");
                }
            } else if (i8 == 2) {
                float unused3 = FragmentOfficial.this.f12914J0 = 500.0f;
                if (FragmentOfficial.this.f12929Y0.equals("0")) {
                    textView.setText("500 km");
                } else {
                    textView.setText("300 mi");
                }
            } else if (i8 == 3) {
                float unused4 = FragmentOfficial.this.f12914J0 = 750.0f;
                if (FragmentOfficial.this.f12929Y0.equals("0")) {
                    textView.setText("750 km");
                } else {
                    textView.setText("450 mi");
                }
            } else if (i8 == 4) {
                float unused5 = FragmentOfficial.this.f12914J0 = 1000.0f;
                if (FragmentOfficial.this.f12929Y0.equals("0")) {
                    textView.setText("1000 km");
                } else {
                    textView.setText("600 mi");
                }
            } else if (i8 == 5) {
                float unused6 = FragmentOfficial.this.f12914J0 = 1500.0f;
                if (FragmentOfficial.this.f12929Y0.equals("0")) {
                    textView.setText("1500 km");
                } else {
                    textView.setText("950 mi");
                }
            } else {
                float unused7 = FragmentOfficial.this.f12914J0 = 2000.0f;
                if (FragmentOfficial.this.f12929Y0.equals("0")) {
                    textView.setText("2000 km");
                } else {
                    textView.setText("1200 mi");
                }
            }
            FragmentOfficial.this.f12925U0.putFloat("filter_list_radius", FragmentOfficial.this.f12914J0);
            FragmentOfficial.this.f12925U0.apply();
            FragmentOfficial fragmentOfficial = FragmentOfficial.this;
            fragmentOfficial.r2(fragmentOfficial.f12923S0);
            FragmentOfficial fragmentOfficial2 = FragmentOfficial.this;
            fragmentOfficial2.K2(fragmentOfficial2.f12922R0);
            FragmentOfficial.this.p2();
            FragmentOfficial.this.f12927W0.o();
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    class c implements SeekBar.OnSeekBarChangeListener {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ View f12970a;

        c(View view) {
            this.f12970a = view;
        }

        public void onProgressChanged(SeekBar seekBar, int i8, boolean z7) {
            TextView textView = (TextView) this.f12970a.findViewById(C2030R.id.textView5);
            if (i8 == 0) {
                float unused = FragmentOfficial.this.f12915K0 = BitmapDescriptorFactory.HUE_RED;
                textView.setText("M0.0");
            } else if (i8 == 1) {
                float unused2 = FragmentOfficial.this.f12915K0 = 1.0f;
                textView.setText("M1.0");
            } else if (i8 == 2) {
                float unused3 = FragmentOfficial.this.f12915K0 = 2.0f;
                textView.setText("M2.0");
            } else if (i8 == 3) {
                float unused4 = FragmentOfficial.this.f12915K0 = 3.0f;
                textView.setText("M3.0");
            } else if (i8 == 4) {
                float unused5 = FragmentOfficial.this.f12915K0 = 4.0f;
                textView.setText("M4.0");
            } else if (i8 == 5) {
                float unused6 = FragmentOfficial.this.f12915K0 = 5.0f;
                textView.setText("M5.0");
            } else if (i8 == 6) {
                float unused7 = FragmentOfficial.this.f12915K0 = 6.0f;
                textView.setText("M6.0");
            }
            FragmentOfficial.this.f12925U0.putFloat("filter_list_min_magnitude", FragmentOfficial.this.f12915K0);
            FragmentOfficial.this.f12925U0.apply();
            FragmentOfficial fragmentOfficial = FragmentOfficial.this;
            fragmentOfficial.r2(fragmentOfficial.f12923S0);
            FragmentOfficial fragmentOfficial2 = FragmentOfficial.this;
            fragmentOfficial2.K2(fragmentOfficial2.f12922R0);
            FragmentOfficial.this.p2();
            FragmentOfficial.this.f12927W0.o();
        }

        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }

    class d implements C {
        d() {
        }

        public boolean a(MenuItem menuItem) {
            C0891s activity = FragmentOfficial.this.getActivity();
            int itemId = menuItem.getItemId();
            if (itemId == C2030R.id.menu_update) {
                if (System.currentTimeMillis() - FragmentOfficial.this.f12924T0.getLong("official_last_updated", 0) > 3000) {
                    double unused = FragmentOfficial.this.f12912H0 = 0.0d;
                    double unused2 = FragmentOfficial.this.f12913I0 = 0.0d;
                    FragmentOfficial.this.q2();
                }
                ((TextView) FragmentOfficial.this.f12944n0.findViewById(C2030R.id.textView14)).setVisibility(8);
                return true;
            } else if (itemId == C2030R.id.menu_background) {
                if (activity != null) {
                    FragmentOfficial fragmentOfficial = FragmentOfficial.this;
                    boolean unused3 = fragmentOfficial.f12941k1 = !fragmentOfficial.f12941k1;
                    if (FragmentOfficial.this.f12941k1) {
                        menuItem.setIcon(androidx.core.content.a.getDrawable(activity.getApplicationContext(), C2030R.drawable.water));
                    } else {
                        menuItem.setIcon(androidx.core.content.a.getDrawable(activity.getApplicationContext(), C2030R.drawable.water_outline));
                    }
                    FragmentOfficial.this.f12925U0.putBoolean("card_colored", FragmentOfficial.this.f12941k1);
                    FragmentOfficial.this.f12925U0.apply();
                    FragmentOfficial.this.p2();
                    if (FragmentOfficial.this.f12927W0 != null) {
                        FragmentOfficial.this.f12927W0.o();
                    }
                }
                return true;
            } else if (itemId != C2030R.id.menu_resize) {
                return false;
            } else {
                int L12 = FragmentOfficial.this.f12935e1;
                FragmentOfficial fragmentOfficial2 = FragmentOfficial.this;
                int unused4 = fragmentOfficial2.f12935e1 = fragmentOfficial2.f12935e1 + 1;
                if (FragmentOfficial.this.f12935e1 > 2) {
                    int unused5 = FragmentOfficial.this.f12935e1 = 0;
                }
                if (activity != null) {
                    if (FragmentOfficial.this.f12935e1 == 0) {
                        menuItem.setIcon(androidx.core.content.a.getDrawable(activity.getApplicationContext(), C2030R.drawable.numeric_1_box_multiple_outline));
                    } else if (FragmentOfficial.this.f12935e1 == 1) {
                        menuItem.setIcon(androidx.core.content.a.getDrawable(activity.getApplicationContext(), C2030R.drawable.numeric_2_box_multiple_outline));
                    } else {
                        menuItem.setIcon(androidx.core.content.a.getDrawable(activity.getApplicationContext(), C2030R.drawable.numeric_3_box_multiple_outline));
                    }
                    FragmentOfficial.this.f12925U0.putInt("card_type", FragmentOfficial.this.f12935e1);
                    FragmentOfficial.this.f12925U0.apply();
                    if (L12 != 0) {
                        List unused6 = FragmentOfficial.this.f12926V0 = new ArrayList();
                        FragmentOfficial fragmentOfficial3 = FragmentOfficial.this;
                        h unused7 = fragmentOfficial3.f12927W0 = new h(fragmentOfficial3, fragmentOfficial3.f12926V0, (a) null);
                        FragmentOfficial.this.f12928X0.setAdapter(FragmentOfficial.this.f12927W0);
                        FragmentOfficial.this.E2();
                    } else if (FragmentOfficial.this.f12927W0 != null) {
                        FragmentOfficial.this.f12927W0.o();
                    }
                }
                return true;
            }
        }

        public /* synthetic */ void b(Menu menu) {
            B.a(this, menu);
        }

        public void c(Menu menu, MenuInflater menuInflater) {
            menuInflater.inflate(C2030R.menu.official_menu, menu);
            C0891s activity = FragmentOfficial.this.getActivity();
            if (activity != null) {
                if (FragmentOfficial.this.f12941k1) {
                    menu.getItem(1).setIcon(androidx.core.content.a.getDrawable(activity.getApplicationContext(), C2030R.drawable.water));
                } else {
                    menu.getItem(1).setIcon(androidx.core.content.a.getDrawable(activity.getApplicationContext(), C2030R.drawable.water_outline));
                }
                if (FragmentOfficial.this.f12935e1 == 0) {
                    menu.getItem(2).setIcon(androidx.core.content.a.getDrawable(activity.getApplicationContext(), C2030R.drawable.numeric_1_box_multiple_outline));
                } else if (FragmentOfficial.this.f12935e1 == 1) {
                    menu.getItem(2).setIcon(androidx.core.content.a.getDrawable(activity.getApplicationContext(), C2030R.drawable.numeric_2_box_multiple_outline));
                } else {
                    menu.getItem(2).setIcon(androidx.core.content.a.getDrawable(activity.getApplicationContext(), C2030R.drawable.numeric_3_box_multiple_outline));
                }
            }
        }

        public /* synthetic */ void d(Menu menu) {
            B.b(this, menu);
        }
    }

    private class e extends AsyncTask {
        private e() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Context... contextArr) {
            C0891s activity = FragmentOfficial.this.getActivity();
            if (activity != null) {
                try {
                    InputStreamReader inputStreamReader = new InputStreamReader(activity.openFileInput("cache_automatic14.txt"));
                    BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                    bufferedReader.readLine();
                    int parseInt = Integer.parseInt(bufferedReader.readLine());
                    double[] unused = FragmentOfficial.this.f12946o0 = new double[parseInt];
                    double[] unused2 = FragmentOfficial.this.f12948p0 = new double[parseInt];
                    double[] unused3 = FragmentOfficial.this.f12950q0 = new double[parseInt];
                    String[] unused4 = FragmentOfficial.this.f12952r0 = new String[parseInt];
                    double[] unused5 = FragmentOfficial.this.f12954s0 = new double[parseInt];
                    double[] unused6 = FragmentOfficial.this.f12956t0 = new double[parseInt];
                    String[] unused7 = FragmentOfficial.this.f12958u0 = new String[parseInt];
                    int[] unused8 = FragmentOfficial.this.f12960v0 = new int[parseInt];
                    String[] unused9 = FragmentOfficial.this.f12962w0 = new String[parseInt];
                    String[] unused10 = FragmentOfficial.this.f12964x0 = new String[parseInt];
                    double[] unused11 = FragmentOfficial.this.f12965y0 = new double[parseInt];
                    int[] unused12 = FragmentOfficial.this.f12966z0 = new int[parseInt];
                    int[] unused13 = FragmentOfficial.this.f12905A0 = new int[parseInt];
                    int[] unused14 = FragmentOfficial.this.f12906B0 = new int[parseInt];
                    int[] unused15 = FragmentOfficial.this.f12907C0 = new int[parseInt];
                    boolean[] unused16 = FragmentOfficial.this.f12908D0 = new boolean[parseInt];
                    int i8 = 0;
                    while (true) {
                        String readLine = bufferedReader.readLine();
                        if (readLine == null) {
                            inputStreamReader.close();
                            return "ok";
                        } else if (i8 < parseInt) {
                            String[] split = readLine.split("#");
                            if (split.length == 15) {
                                try {
                                    FragmentOfficial.this.f12946o0[i8] = Double.parseDouble(split[0]);
                                    FragmentOfficial.this.f12948p0[i8] = Double.parseDouble(split[1]);
                                    FragmentOfficial.this.f12950q0[i8] = Double.parseDouble(split[2]);
                                    FragmentOfficial.this.f12952r0[i8] = split[3];
                                    FragmentOfficial.this.f12954s0[i8] = Double.parseDouble(split[4]);
                                    FragmentOfficial.this.f12956t0[i8] = Double.parseDouble(split[5]);
                                    FragmentOfficial.this.f12964x0[i8] = split[6];
                                    FragmentOfficial.this.f12958u0[i8] = split[7];
                                    FragmentOfficial.this.f12960v0[i8] = Integer.parseInt(split[8]);
                                    FragmentOfficial.this.f12962w0[i8] = split[9];
                                    FragmentOfficial.this.f12965y0[i8] = Double.parseDouble(split[10]);
                                    FragmentOfficial.this.f12966z0[i8] = Integer.parseInt(split[11]);
                                    FragmentOfficial.this.f12905A0[i8] = Integer.parseInt(split[12]);
                                    FragmentOfficial.this.f12906B0[i8] = Integer.parseInt(split[13]);
                                    FragmentOfficial.this.f12907C0[i8] = Integer.parseInt(split[14]);
                                    i8++;
                                } catch (NumberFormatException e8) {
                                    if (e8.getMessage() != null) {
                                        Log.d("EQN", e8.getMessage());
                                    }
                                }
                            }
                        }
                    }
                } catch (IOException | NumberFormatException unused17) {
                }
            }
            return "nok";
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            ProgressBar progressBar;
            super.onPostExecute(str);
            if (str.equalsIgnoreCase("ok")) {
                for (int i8 = 0; i8 < FragmentOfficial.this.f12946o0.length; i8++) {
                    i iVar = new i((a) null);
                    iVar.o0(FragmentOfficial.this.f12946o0[i8]);
                    iVar.q0(FragmentOfficial.this.f12948p0[i8]);
                    iVar.r0(FragmentOfficial.this.f12950q0[i8]);
                    iVar.t0(FragmentOfficial.this.f12952r0[i8]);
                    iVar.l0(FragmentOfficial.this.f12956t0[i8]);
                    iVar.p0(FragmentOfficial.this.f12958u0[i8]);
                    iVar.v0(FragmentOfficial.this.f12960v0[i8]);
                    iVar.x0(FragmentOfficial.this.f12962w0[i8]);
                    iVar.k0(FragmentOfficial.this.f12964x0[i8]);
                    iVar.s0(FragmentOfficial.this.f12965y0[i8]);
                    iVar.w0(FragmentOfficial.this.f12966z0[i8]);
                    iVar.A0(FragmentOfficial.this.f12905A0[i8]);
                    iVar.y0(FragmentOfficial.this.f12906B0[i8]);
                    iVar.n0(FragmentOfficial.this.f12907C0[i8]);
                    iVar.z0(false);
                    iVar.u0(i8);
                    if (FragmentOfficial.this.f12927W0 != null) {
                        FragmentOfficial.this.f12927W0.D(iVar);
                    }
                }
                if (FragmentOfficial.this.f12927W0 != null) {
                    FragmentOfficial fragmentOfficial = FragmentOfficial.this;
                    fragmentOfficial.r2(fragmentOfficial.f12923S0);
                    FragmentOfficial fragmentOfficial2 = FragmentOfficial.this;
                    fragmentOfficial2.K2(fragmentOfficial2.f12922R0);
                    FragmentOfficial.this.p2();
                    if (FragmentOfficial.this.f12920P0 == 1) {
                        FragmentOfficial.this.F2();
                    }
                    FragmentOfficial.this.f12927W0.o();
                }
            }
            if (FragmentOfficial.this.f12944n0 != null && (progressBar = (ProgressBar) FragmentOfficial.this.f12944n0.findViewById(C2030R.id.progressBar1)) != null) {
                progressBar.setVisibility(8);
            }
        }

        /* synthetic */ e(FragmentOfficial fragmentOfficial, a aVar) {
            this();
        }
    }

    private class f extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private String f12974a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f12975b;

        /* renamed from: c  reason: collision with root package name */
        private int f12976c;

        /* renamed from: d  reason: collision with root package name */
        private int f12977d;

        /* synthetic */ f(FragmentOfficial fragmentOfficial, int i8, int i9, a aVar) {
            this(i8, i9);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(5:14|13|18|19|(0)(0)) */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x00c1, code lost:
            r8 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00c7, code lost:
            r1.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00cd, code lost:
            r1.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x00c3 */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x00c7  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x00cd  */
        /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r8) {
            /*
                r7 = this;
                r8 = 0
                com.finazzi.distquake.FragmentOfficial r0 = com.finazzi.distquake.FragmentOfficial.this
                boolean r0 = r0.isAdded()
                com.finazzi.distquake.FragmentOfficial r1 = com.finazzi.distquake.FragmentOfficial.this
                androidx.fragment.app.s r1 = r1.getActivity()
                r2 = 1
                if (r1 == 0) goto L_0x00d1
                if (r0 == 0) goto L_0x00d1
                java.util.HashMap r0 = new java.util.HashMap
                r0.<init>()
                int r1 = r7.f12976c
                java.lang.String r1 = java.lang.Integer.toString(r1)
                java.lang.String r3 = "iso_id"
                r0.put(r3, r1)
                java.lang.String r0 = u2.C1737L.a(r0)
                r1 = 0
                com.finazzi.distquake.FragmentOfficial r3 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ IOException -> 0x00c3 }
                android.content.SharedPreferences r3 = r3.f12924T0     // Catch:{ IOException -> 0x00c3 }
                java.lang.String r4 = "sub_domain"
                com.finazzi.distquake.FragmentOfficial r5 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ IOException -> 0x00c3 }
                r6 = 2131887099(0x7f1203fb, float:1.9408796E38)
                java.lang.String r5 = r5.getString(r6)     // Catch:{ IOException -> 0x00c3 }
                java.lang.String r3 = r3.getString(r4, r5)     // Catch:{ IOException -> 0x00c3 }
                com.finazzi.distquake.FragmentOfficial r4 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ IOException -> 0x00c3 }
                r5 = 2131887098(0x7f1203fa, float:1.9408793E38)
                java.lang.String r4 = r4.getString(r5)     // Catch:{ IOException -> 0x00c3 }
                java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ IOException -> 0x00c3 }
                r5[r8] = r3     // Catch:{ IOException -> 0x00c3 }
                java.lang.String r3 = java.lang.String.format(r4, r5)     // Catch:{ IOException -> 0x00c3 }
                java.net.URL r4 = new java.net.URL     // Catch:{ IOException -> 0x00c3 }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c3 }
                r5.<init>()     // Catch:{ IOException -> 0x00c3 }
                r5.append(r3)     // Catch:{ IOException -> 0x00c3 }
                java.lang.String r3 = "distquake_download_shakemap.php?"
                r5.append(r3)     // Catch:{ IOException -> 0x00c3 }
                r5.append(r0)     // Catch:{ IOException -> 0x00c3 }
                java.lang.String r0 = r5.toString()     // Catch:{ IOException -> 0x00c3 }
                r4.<init>(r0)     // Catch:{ IOException -> 0x00c3 }
                java.net.URLConnection r0 = r4.openConnection()     // Catch:{ IOException -> 0x00c3 }
                java.lang.Object r0 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r0)     // Catch:{ IOException -> 0x00c3 }
                java.net.URLConnection r0 = (java.net.URLConnection) r0     // Catch:{ IOException -> 0x00c3 }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ IOException -> 0x00c3 }
                r0.setDoOutput(r8)     // Catch:{ IOException -> 0x00b0, all -> 0x00ad }
                r1 = 10000(0x2710, float:1.4013E-41)
                r0.setConnectTimeout(r1)     // Catch:{ IOException -> 0x00b0, all -> 0x00ad }
                r0.setReadTimeout(r1)     // Catch:{ IOException -> 0x00b0, all -> 0x00ad }
                java.lang.String r1 = "Content-Type"
                java.lang.String r3 = "application/x-www-form-urlencoded;charset=utf-8"
                r0.setRequestProperty(r1, r3)     // Catch:{ IOException -> 0x00b0, all -> 0x00ad }
                java.lang.String r1 = "GET"
                r0.setRequestMethod(r1)     // Catch:{ IOException -> 0x00b0, all -> 0x00ad }
                java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00b0, all -> 0x00ad }
                java.io.InputStream r3 = r0.getInputStream()     // Catch:{ IOException -> 0x00b0, all -> 0x00ad }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00b0, all -> 0x00ad }
                java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00b0, all -> 0x00ad }
                java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00b0, all -> 0x00ad }
                java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00b0, all -> 0x00ad }
                r4.<init>(r1, r5)     // Catch:{ IOException -> 0x00b0, all -> 0x00ad }
                r3.<init>(r4)     // Catch:{ IOException -> 0x00b0, all -> 0x00ad }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00b0, all -> 0x00ad }
                r4.<init>()     // Catch:{ IOException -> 0x00b0, all -> 0x00ad }
            L_0x00a3:
                java.lang.String r5 = r3.readLine()     // Catch:{ IOException -> 0x00b0, all -> 0x00ad }
                if (r5 == 0) goto L_0x00b2
                r4.append(r5)     // Catch:{ IOException -> 0x00b0, all -> 0x00ad }
                goto L_0x00a3
            L_0x00ad:
                r8 = move-exception
                r1 = r0
                goto L_0x00cb
            L_0x00b0:
                r1 = r0
                goto L_0x00c3
            L_0x00b2:
                r1.close()     // Catch:{ IOException -> 0x00b0, all -> 0x00ad }
                java.lang.String r1 = r4.toString()     // Catch:{ IOException -> 0x00b0, all -> 0x00ad }
                r7.f12974a = r1     // Catch:{ IOException -> 0x00b0, all -> 0x00ad }
                r7.f12975b = r8     // Catch:{ IOException -> 0x00b0, all -> 0x00ad }
                r0.disconnect()
                goto L_0x00d3
            L_0x00c1:
                r8 = move-exception
                goto L_0x00cb
            L_0x00c3:
                r7.f12975b = r2     // Catch:{ all -> 0x00c1 }
                if (r1 == 0) goto L_0x00d3
                r1.disconnect()
                goto L_0x00d3
            L_0x00cb:
                if (r1 == 0) goto L_0x00d0
                r1.disconnect()
            L_0x00d0:
                throw r8
            L_0x00d1:
                r7.f12975b = r2
            L_0x00d3:
                java.lang.String r8 = "COMPLETE!"
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.FragmentOfficial.f.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            ProgressBar progressBar = (ProgressBar) FragmentOfficial.this.f12944n0.findViewById(C2030R.id.progressBar1);
            if (progressBar != null) {
                progressBar.setVisibility(8);
            }
            if (!this.f12975b && !this.f12974a.equalsIgnoreCase("empty")) {
                try {
                    if (new JSONArray(this.f12974a).length() > 0) {
                        String unused = FragmentOfficial.this.f12963w1 = this.f12974a;
                        FragmentOfficial.this.G2(this.f12977d, 0.0d, 0.0d, false);
                    }
                } catch (ArrayIndexOutOfBoundsException | JSONException e8) {
                    Throwable th = e8;
                    if (th.getMessage() != null) {
                        Log.d("EQN", th.getMessage());
                    }
                }
            }
        }

        private f(int i8, int i9) {
            this.f12974a = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
            this.f12975b = true;
            this.f12976c = i8;
            this.f12977d = i9;
        }
    }

    private class g extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private String f12979a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f12980b;

        /* renamed from: c  reason: collision with root package name */
        private final float f12981c;

        /* renamed from: d  reason: collision with root package name */
        private final String f12982d;

        /* synthetic */ g(FragmentOfficial fragmentOfficial, float f8, String str, a aVar) {
            this(f8, str);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00ce, code lost:
            r1.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x00ca */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x00ce  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x00d4  */
        /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r8) {
            /*
                r7 = this;
                r8 = 0
                com.finazzi.distquake.FragmentOfficial r0 = com.finazzi.distquake.FragmentOfficial.this
                boolean r0 = r0.isAdded()
                com.finazzi.distquake.FragmentOfficial r1 = com.finazzi.distquake.FragmentOfficial.this
                androidx.fragment.app.s r1 = r1.getActivity()
                r2 = 1
                if (r1 == 0) goto L_0x00d8
                if (r0 == 0) goto L_0x00d8
                java.util.HashMap r0 = new java.util.HashMap
                r0.<init>()
                float r1 = r7.f12981c
                java.lang.String r1 = java.lang.Float.toString(r1)
                java.lang.String r3 = "mag"
                r0.put(r3, r1)
                java.lang.String r1 = "pro"
                java.lang.String r3 = r7.f12982d
                r0.put(r1, r3)
                java.lang.String r0 = u2.C1737L.a(r0)
                r1 = 0
                com.finazzi.distquake.FragmentOfficial r3 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ IOException -> 0x00ca }
                android.content.SharedPreferences r3 = r3.f12924T0     // Catch:{ IOException -> 0x00ca }
                java.lang.String r4 = "sub_domain"
                com.finazzi.distquake.FragmentOfficial r5 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ IOException -> 0x00ca }
                r6 = 2131887099(0x7f1203fb, float:1.9408796E38)
                java.lang.String r5 = r5.getString(r6)     // Catch:{ IOException -> 0x00ca }
                java.lang.String r3 = r3.getString(r4, r5)     // Catch:{ IOException -> 0x00ca }
                com.finazzi.distquake.FragmentOfficial r4 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ IOException -> 0x00ca }
                r5 = 2131887098(0x7f1203fa, float:1.9408793E38)
                java.lang.String r4 = r4.getString(r5)     // Catch:{ IOException -> 0x00ca }
                java.lang.Object[] r5 = new java.lang.Object[r2]     // Catch:{ IOException -> 0x00ca }
                r5[r8] = r3     // Catch:{ IOException -> 0x00ca }
                java.lang.String r3 = java.lang.String.format(r4, r5)     // Catch:{ IOException -> 0x00ca }
                java.net.URL r4 = new java.net.URL     // Catch:{ IOException -> 0x00ca }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00ca }
                r5.<init>()     // Catch:{ IOException -> 0x00ca }
                r5.append(r3)     // Catch:{ IOException -> 0x00ca }
                java.lang.String r3 = "distquake_download_automatic21.php?"
                r5.append(r3)     // Catch:{ IOException -> 0x00ca }
                r5.append(r0)     // Catch:{ IOException -> 0x00ca }
                java.lang.String r0 = r5.toString()     // Catch:{ IOException -> 0x00ca }
                r4.<init>(r0)     // Catch:{ IOException -> 0x00ca }
                java.net.URLConnection r0 = r4.openConnection()     // Catch:{ IOException -> 0x00ca }
                java.lang.Object r0 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r0)     // Catch:{ IOException -> 0x00ca }
                java.net.URLConnection r0 = (java.net.URLConnection) r0     // Catch:{ IOException -> 0x00ca }
                java.net.HttpURLConnection r0 = (java.net.HttpURLConnection) r0     // Catch:{ IOException -> 0x00ca }
                r0.setDoOutput(r8)     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
                r1 = 10000(0x2710, float:1.4013E-41)
                r0.setConnectTimeout(r1)     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
                r0.setReadTimeout(r1)     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
                java.lang.String r1 = "Content-Type"
                java.lang.String r3 = "application/x-www-form-urlencoded;charset=utf-8"
                r0.setRequestProperty(r1, r3)     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
                java.lang.String r1 = "GET"
                r0.setRequestMethod(r1)     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
                java.io.BufferedInputStream r1 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
                java.io.InputStream r3 = r0.getInputStream()     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
                java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
                java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
                java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
                r4.<init>(r1, r5)     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
                r3.<init>(r4)     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
                r4.<init>()     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
            L_0x00aa:
                java.lang.String r5 = r3.readLine()     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
                if (r5 == 0) goto L_0x00b9
                r4.append(r5)     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
                goto L_0x00aa
            L_0x00b4:
                r8 = move-exception
                r1 = r0
                goto L_0x00d2
            L_0x00b7:
                r1 = r0
                goto L_0x00ca
            L_0x00b9:
                r1.close()     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
                java.lang.String r1 = r4.toString()     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
                r7.f12979a = r1     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
                r7.f12980b = r8     // Catch:{ IOException -> 0x00b7, all -> 0x00b4 }
                r0.disconnect()
                goto L_0x00da
            L_0x00c8:
                r8 = move-exception
                goto L_0x00d2
            L_0x00ca:
                r7.f12980b = r2     // Catch:{ all -> 0x00c8 }
                if (r1 == 0) goto L_0x00da
                r1.disconnect()
                goto L_0x00da
            L_0x00d2:
                if (r1 == 0) goto L_0x00d7
                r1.disconnect()
            L_0x00d7:
                throw r8
            L_0x00d8:
                r7.f12980b = r2
            L_0x00da:
                java.lang.String r8 = "COMPLETE!"
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.FragmentOfficial.g.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:47:0x0368, code lost:
            r0 = move-exception;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:52:0x039a, code lost:
            if (r0.getMessage() != null) goto L_0x039c;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:53:0x039c, code lost:
            android.util.Log.d("EQN", r0.getMessage());
         */
        /* JADX WARNING: Code restructure failed: missing block: B:71:0x04ed, code lost:
            ((android.widget.TextView) com.finazzi.distquake.FragmentOfficial.U0(r1.f12983e).findViewById(com.finazzi.distquake.C2030R.id.textView15)).setVisibility(0);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:84:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Removed duplicated region for block: B:72:? A[ExcHandler: ArrayIndexOutOfBoundsException | JSONException (unused java.lang.Throwable), SYNTHETIC, Splitter:B:7:0x002f] */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onPostExecute(java.lang.String r20) {
            /*
                r19 = this;
                r1 = r19
                java.lang.String r0 = "1"
                java.lang.String r2 = "\r\n"
                java.lang.String r3 = "#"
                super.onPostExecute(r20)
                com.finazzi.distquake.FragmentOfficial r4 = com.finazzi.distquake.FragmentOfficial.this
                android.view.View r4 = r4.f12944n0
                r5 = 2131296894(0x7f09027e, float:1.8211718E38)
                android.view.View r4 = r4.findViewById(r5)
                android.widget.ProgressBar r4 = (android.widget.ProgressBar) r4
                if (r4 == 0) goto L_0x0021
                r5 = 8
                r4.setVisibility(r5)
            L_0x0021:
                boolean r4 = r1.f12980b
                if (r4 != 0) goto L_0x0514
                java.lang.String r4 = r1.f12979a
                java.lang.String r7 = "empty"
                boolean r4 = r4.equalsIgnoreCase(r7)
                if (r4 != 0) goto L_0x0501
                org.json.JSONArray r4 = new org.json.JSONArray     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String r7 = r1.f12979a     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r4.<init>(r7)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                int r7 = r4.length()     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r8 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                double[] r9 = new double[r7]     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                double[] unused = r8.f12946o0 = r9     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r8 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                double[] r9 = new double[r7]     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                double[] unused = r8.f12948p0 = r9     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r8 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                double[] r9 = new double[r7]     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                double[] unused = r8.f12950q0 = r9     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r8 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String[] r9 = new java.lang.String[r7]     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String[] unused = r8.f12952r0 = r9     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r8 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                double[] r9 = new double[r7]     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                double[] unused = r8.f12954s0 = r9     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r8 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                double[] r9 = new double[r7]     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                double[] unused = r8.f12956t0 = r9     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r8 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String[] r9 = new java.lang.String[r7]     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String[] unused = r8.f12958u0 = r9     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r8 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                int[] r9 = new int[r7]     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                int[] unused = r8.f12960v0 = r9     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r8 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String[] r9 = new java.lang.String[r7]     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String[] unused = r8.f12962w0 = r9     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r8 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String[] r9 = new java.lang.String[r7]     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String[] unused = r8.f12964x0 = r9     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r8 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                double[] r9 = new double[r7]     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                double[] unused = r8.f12965y0 = r9     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r8 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                int[] r9 = new int[r7]     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                int[] unused = r8.f12966z0 = r9     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r8 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                int[] r9 = new int[r7]     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                int[] unused = r8.f12905A0 = r9     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r8 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                int[] r9 = new int[r7]     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                int[] unused = r8.f12906B0 = r9     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r8 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                int[] r9 = new int[r7]     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                int[] unused = r8.f12907C0 = r9     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r8 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                boolean[] r9 = new boolean[r7]     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                boolean[] unused = r8.f12908D0 = r9     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r8 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                androidx.fragment.app.s r8 = r8.getActivity()     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                if (r8 == 0) goto L_0x0500
                r9 = 0
            L_0x00b3:
                r10 = 1
                if (r9 >= r7) goto L_0x0239
                org.json.JSONObject r11 = r4.getJSONObject(r9)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r12 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                double[] r12 = r12.f12946o0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String r13 = "la"
                double r13 = r11.getDouble(r13)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r12[r9] = r13     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r12 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                double[] r12 = r12.f12948p0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String r13 = "lo"
                double r13 = r11.getDouble(r13)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r12[r9] = r13     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r12 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                double[] r12 = r12.f12950q0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String r13 = "ma"
                double r13 = r11.getDouble(r13)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r12[r9] = r13     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r12 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String[] r12 = r12.f12952r0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String r13 = "mt"
                java.lang.String r13 = r11.getString(r13)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r12[r9] = r13     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r12 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                double[] r12 = r12.f12954s0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String r13 = "it"
                double r13 = r11.getDouble(r13)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r12[r9] = r13     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r12 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                double[] r12 = r12.f12956t0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String r13 = "de"
                double r13 = r11.getDouble(r13)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r12[r9] = r13     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r12 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String r12 = r12.f12929Y0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                boolean r12 = r12.equals(r0)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r13 = 4603772033682776338(0x3fe3e245d68a2112, double:0.621371192)
                if (r12 == 0) goto L_0x0131
                com.finazzi.distquake.FragmentOfficial r12 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                double[] r12 = r12.f12956t0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r15 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                double[] r15 = r15.f12956t0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r16 = r15[r9]     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                double r16 = r16 * r13
                r12[r9] = r16     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
            L_0x0131:
                com.finazzi.distquake.FragmentOfficial r12 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String[] r12 = r12.f12958u0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String r15 = "pl"
                java.lang.String r15 = r11.getString(r15)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r12[r9] = r15     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r12 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String r12 = r12.f12929Y0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                boolean r12 = r12.equals(r0)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                if (r12 == 0) goto L_0x01c1
                com.finazzi.distquake.FragmentOfficial r12 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String[] r12 = r12.f12958u0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r12 = r12[r9]     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r15 = r10
            L_0x0154:
                if (r15 == 0) goto L_0x01b6
                r16 = r13
                com.finazzi.distquake.FragmentOfficial r13 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.util.regex.Pattern r13 = r13.f12959u1     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.util.regex.Matcher r13 = r13.matcher(r12)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                boolean r14 = r13.find()     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                if (r14 == 0) goto L_0x01ae
                int r14 = r13.groupCount()     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r5 = 2
                if (r14 < r5) goto L_0x01ab
                java.lang.String r14 = r13.group(r10)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String r5 = r13.group(r5)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                int r13 = java.lang.Integer.parseInt(r14)     // Catch:{ NumberFormatException -> 0x01ae, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r18 = r7
                double r6 = (double) r13
                double r6 = r6 * r16
                int r6 = (int) r6
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x01b0, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r7.<init>()     // Catch:{ NumberFormatException -> 0x01b0, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r7.append(r14)     // Catch:{ NumberFormatException -> 0x01b0, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String r13 = "\\s*"
                r7.append(r13)     // Catch:{ NumberFormatException -> 0x01b0, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r7.append(r5)     // Catch:{ NumberFormatException -> 0x01b0, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String r5 = r7.toString()     // Catch:{ NumberFormatException -> 0x01b0, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ NumberFormatException -> 0x01b0, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r7.<init>()     // Catch:{ NumberFormatException -> 0x01b0, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r7.append(r6)     // Catch:{ NumberFormatException -> 0x01b0, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String r6 = " mi"
                r7.append(r6)     // Catch:{ NumberFormatException -> 0x01b0, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String r6 = r7.toString()     // Catch:{ NumberFormatException -> 0x01b0, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String r12 = r12.replaceFirst(r5, r6)     // Catch:{ NumberFormatException -> 0x01b0, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                goto L_0x01b1
            L_0x01ab:
                r18 = r7
                goto L_0x01b1
            L_0x01ae:
                r18 = r7
            L_0x01b0:
                r15 = 0
            L_0x01b1:
                r13 = r16
                r7 = r18
                goto L_0x0154
            L_0x01b6:
                r18 = r7
                com.finazzi.distquake.FragmentOfficial r5 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String[] r5 = r5.f12958u0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r5[r9] = r12     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                goto L_0x01c3
            L_0x01c1:
                r18 = r7
            L_0x01c3:
                com.finazzi.distquake.FragmentOfficial r5 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                int[] r5 = r5.f12960v0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String r6 = "p1"
                int r6 = r11.getInt(r6)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r5[r9] = r6     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r5 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String[] r5 = r5.f12962w0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String r6 = "pr"
                java.lang.String r6 = r11.getString(r6)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r5[r9] = r6     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r5 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String[] r5 = r5.f12964x0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String r6 = "dt"
                java.lang.String r6 = r11.getString(r6)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r5[r9] = r6     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r5 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                double[] r5 = r5.f12965y0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String r6 = "mr"
                double r6 = r11.getDouble(r6)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r5[r9] = r6     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r5 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                int[] r5 = r5.f12966z0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String r6 = "py"
                int r6 = r11.getInt(r6)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r5[r9] = r6     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r5 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                int[] r5 = r5.f12905A0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String r6 = "sm"
                int r6 = r11.getInt(r6)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r5[r9] = r6     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r5 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                int[] r5 = r5.f12906B0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String r6 = "rp"
                int r6 = r11.getInt(r6)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r5[r9] = r6     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r5 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                int[] r5 = r5.f12907C0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String r6 = "iso"
                int r6 = r11.getInt(r6)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r5[r9] = r6     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                int r9 = r9 + 1
                r7 = r18
                goto L_0x00b3
            L_0x0239:
                r18 = r7
                java.lang.String r0 = "cache_automatic14.txt"
                r4 = 0
                java.io.FileOutputStream r0 = r8.openFileOutput(r0, r4)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.io.OutputStreamWriter r4 = new java.io.OutputStreamWriter     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r4.<init>(r0, r5)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                long r5 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String r0 = java.lang.Long.toString(r5)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r5.<init>()     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r5.append(r0)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r5.append(r2)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String r0 = r5.toString()     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r4.write(r0)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r0.<init>()     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r5 = r18
                r0.append(r5)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r0.append(r2)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r4.write(r0)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r0 = 0
            L_0x0278:
                if (r0 >= r5) goto L_0x036a
                java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r6.<init>()     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r7 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                double[] r7 = r7.f12946o0     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r8 = r7[r0]     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r6.append(r8)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r6.append(r3)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r7 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                double[] r7 = r7.f12948p0     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r8 = r7[r0]     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r6.append(r8)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r6.append(r3)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r7 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                double[] r7 = r7.f12950q0     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r8 = r7[r0]     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r6.append(r8)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r6.append(r3)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r7 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String[] r7 = r7.f12952r0     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r7 = r7[r0]     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r6.append(r7)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r6.append(r3)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r7 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                double[] r7 = r7.f12954s0     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r8 = r7[r0]     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r6.append(r8)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r6.append(r3)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r7 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                double[] r7 = r7.f12956t0     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r8 = r7[r0]     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r6.append(r8)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r6.append(r3)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r7 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String[] r7 = r7.f12964x0     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r7 = r7[r0]     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r6.append(r7)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r6.append(r3)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r7 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String[] r7 = r7.f12958u0     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r7 = r7[r0]     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r6.append(r7)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r6.append(r3)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r7 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                int[] r7 = r7.f12960v0     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r7 = r7[r0]     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r6.append(r7)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r6.append(r3)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r7 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String[] r7 = r7.f12962w0     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r7 = r7[r0]     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r6.append(r7)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r6.append(r3)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r7 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                double[] r7 = r7.f12965y0     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r8 = r7[r0]     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r6.append(r8)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r6.append(r3)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r7 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                int[] r7 = r7.f12966z0     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r7 = r7[r0]     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r6.append(r7)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r6.append(r3)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r7 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                int[] r7 = r7.f12905A0     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r7 = r7[r0]     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r6.append(r7)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r6.append(r3)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r7 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                int[] r7 = r7.f12906B0     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r7 = r7[r0]     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r6.append(r7)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r6.append(r3)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r7 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                int[] r7 = r7.f12907C0     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r7 = r7[r0]     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r6.append(r7)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String r6 = r6.toString()     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r7.<init>()     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r7.append(r6)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r7.append(r2)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String r6 = r7.toString()     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r4.write(r6)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                int r0 = r0 + 1
                goto L_0x0278
            L_0x0368:
                r0 = move-exception
                goto L_0x0396
            L_0x036a:
                r4.flush()     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r4.close()     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r0 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                android.content.SharedPreferences$Editor r0 = r0.f12925U0     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String r2 = "last_downloaded_min_magnitude"
                float r3 = r1.f12981c     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r0.putFloat(r2, r3)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r0 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                android.content.SharedPreferences$Editor r0 = r0.f12925U0     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String r2 = "official_last_updated"
                long r3 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r0.putLong(r2, r3)     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r0 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                android.content.SharedPreferences$Editor r0 = r0.f12925U0     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r0.apply()     // Catch:{ IOException -> 0x0368, ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                goto L_0x03a5
            L_0x0396:
                java.lang.String r2 = r0.getMessage()     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                if (r2 == 0) goto L_0x03a5
                java.lang.String r2 = "EQN"
                java.lang.String r0 = r0.getMessage()     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                android.util.Log.d(r2, r0)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
            L_0x03a5:
                r0 = 0
            L_0x03a6:
                com.finazzi.distquake.FragmentOfficial r2 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                double[] r2 = r2.f12946o0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                int r2 = r2.length     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                if (r0 >= r2) goto L_0x0463
                com.finazzi.distquake.FragmentOfficial$i r2 = new com.finazzi.distquake.FragmentOfficial$i     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r3 = 0
                r2.<init>(r3)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r3 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                double[] r3 = r3.f12946o0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r4 = r3[r0]     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r2.o0(r4)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r3 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                double[] r3 = r3.f12948p0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r4 = r3[r0]     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r2.q0(r4)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r3 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                double[] r3 = r3.f12950q0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r4 = r3[r0]     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r2.r0(r4)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r3 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String[] r3 = r3.f12952r0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r3 = r3[r0]     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r2.t0(r3)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r3 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                double[] r3 = r3.f12956t0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r4 = r3[r0]     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r2.l0(r4)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r3 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String[] r3 = r3.f12958u0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r3 = r3[r0]     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r2.p0(r3)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r3 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                int[] r3 = r3.f12960v0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r3 = r3[r0]     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r2.v0(r3)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r3 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String[] r3 = r3.f12962w0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r3 = r3[r0]     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r2.x0(r3)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r3 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String[] r3 = r3.f12964x0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r3 = r3[r0]     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r2.k0(r3)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r3 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                double[] r3 = r3.f12965y0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r4 = r3[r0]     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r2.s0(r4)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r3 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                int[] r3 = r3.f12966z0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r3 = r3[r0]     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r2.w0(r3)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r3 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                int[] r3 = r3.f12905A0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r3 = r3[r0]     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r2.A0(r3)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r3 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                int[] r3 = r3.f12906B0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r3 = r3[r0]     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r2.y0(r3)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r3 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                int[] r3 = r3.f12907C0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r3 = r3[r0]     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r2.n0(r3)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r4 = 0
                r2.z0(r4)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r2.u0(r0)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r3 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial$h r3 = r3.f12927W0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r3.D(r2)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                int r0 = r0 + 1
                goto L_0x03a6
            L_0x0463:
                com.finazzi.distquake.FragmentOfficial r0 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                int r2 = r0.f12923S0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r0.r2(r2)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r0 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                int r2 = r0.f12922R0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r0.K2(r2)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r0 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r0.p2()     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r0 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                int r0 = r0.f12920P0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                if (r0 != r10) goto L_0x0488
                com.finazzi.distquake.FragmentOfficial r0 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r0.F2()     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                goto L_0x04ad
            L_0x0488:
                com.finazzi.distquake.FragmentOfficial r0 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                androidx.recyclerview.widget.RecyclerView r0 = r0.f12928X0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                androidx.recyclerview.widget.RecyclerView$p r0 = r0.getLayoutManager()     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                if (r0 == 0) goto L_0x04ad
                com.finazzi.distquake.FragmentOfficial r0 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                androidx.recyclerview.widget.RecyclerView r0 = r0.f12928X0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                androidx.recyclerview.widget.RecyclerView$p r0 = r0.getLayoutManager()     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r2 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                androidx.recyclerview.widget.RecyclerView r2 = r2.f12928X0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                androidx.recyclerview.widget.RecyclerView$B r3 = new androidx.recyclerview.widget.RecyclerView$B     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r3.<init>()     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r4 = 0
                r0.M1(r2, r3, r4)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
            L_0x04ad:
                com.finazzi.distquake.FragmentOfficial r0 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial$h r0 = r0.f12927W0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r0.o()     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r0 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                android.content.SharedPreferences r0 = r0.f12924T0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                java.lang.String r2 = "eqn_notification_tap"
                r4 = 0
                int r0 = r0.getInt(r2, r4)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                if (r0 != r10) goto L_0x0500
                com.finazzi.distquake.FragmentOfficial r0 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                double r2 = r0.f12912H0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r4 = 0
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 == 0) goto L_0x0500
                com.finazzi.distquake.FragmentOfficial r0 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                double r2 = r0.f12913I0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r0 == 0) goto L_0x0500
                com.finazzi.distquake.FragmentOfficial r2 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                double r4 = r2.f12912H0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                com.finazzi.distquake.FragmentOfficial r0 = com.finazzi.distquake.FragmentOfficial.this     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                double r6 = r0.f12913I0     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                r8 = 0
                r3 = -1
                r2.G2(r3, r4, r6, r8)     // Catch:{ ArrayIndexOutOfBoundsException | JSONException -> 0x04ed }
                goto L_0x0500
            L_0x04ed:
                com.finazzi.distquake.FragmentOfficial r0 = com.finazzi.distquake.FragmentOfficial.this
                android.view.View r0 = r0.f12944n0
                r2 = 2131297058(0x7f090322, float:1.821205E38)
                android.view.View r0 = r0.findViewById(r2)
                android.widget.TextView r0 = (android.widget.TextView) r0
                r4 = 0
                r0.setVisibility(r4)
            L_0x0500:
                return
            L_0x0501:
                com.finazzi.distquake.FragmentOfficial r0 = com.finazzi.distquake.FragmentOfficial.this
                int r2 = r0.f12923S0
                r0.r2(r2)
                com.finazzi.distquake.FragmentOfficial r0 = com.finazzi.distquake.FragmentOfficial.this
                com.finazzi.distquake.FragmentOfficial$h r0 = r0.f12927W0
                r0.o()
                return
            L_0x0514:
                com.finazzi.distquake.FragmentOfficial r0 = com.finazzi.distquake.FragmentOfficial.this
                android.view.View r0 = r0.f12944n0
                r2 = 2131297058(0x7f090322, float:1.821205E38)
                android.view.View r0 = r0.findViewById(r2)
                android.widget.TextView r0 = (android.widget.TextView) r0
                r4 = 0
                r0.setVisibility(r4)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.FragmentOfficial.g.onPostExecute(java.lang.String):void");
        }

        private g(float f8, String str) {
            this.f12979a = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
            this.f12980b = true;
            this.f12981c = f8;
            this.f12982d = str;
        }
    }

    public class h extends RecyclerView.h {
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public final List f12984d;

        protected class a extends RecyclerView.F implements View.OnClickListener {

            /* renamed from: F  reason: collision with root package name */
            TextView f12986F;

            /* renamed from: G  reason: collision with root package name */
            TextView f12987G;

            /* renamed from: H  reason: collision with root package name */
            TextView f12988H;

            /* renamed from: I  reason: collision with root package name */
            TextView f12989I;

            /* renamed from: J  reason: collision with root package name */
            TextView f12990J;

            /* renamed from: K  reason: collision with root package name */
            TextView f12991K;

            /* renamed from: L  reason: collision with root package name */
            Button f12992L;

            /* renamed from: M  reason: collision with root package name */
            View f12993M;

            /* renamed from: N  reason: collision with root package name */
            CardView f12994N;

            /* renamed from: O  reason: collision with root package name */
            LinearLayout f12995O;

            /* synthetic */ a(h hVar, View view, a aVar) {
                this(view);
            }

            public static /* synthetic */ void O(a aVar, Activity activity, DialogInterface dialogInterface, int i8) {
                aVar.getClass();
                FragmentOfficial.this.startActivity(new Intent().setClass(activity, ToProActivity.class));
            }

            public static /* synthetic */ void P(DialogInterface dialogInterface, int i8) {
            }

            public void onClick(View view) {
                int k8 = k();
                if (k8 < 0) {
                    return;
                }
                if (view.getId() != this.f12992L.getId()) {
                    FragmentOfficial.this.J2(k8, false);
                } else if (FragmentOfficial.this.f12961v1) {
                    new f(FragmentOfficial.this, ((i) h.this.f12984d.get(k8)).V(), k8, (a) null).execute(new Context[]{FragmentOfficial.this.getActivity()});
                } else {
                    C0891s activity = FragmentOfficial.this.getActivity();
                    if (activity != null) {
                        ImageView imageView = new ImageView(activity);
                        imageView.setImageDrawable(FragmentOfficial.this.getResources().getDrawable(C2030R.drawable.shakemap));
                        imageView.setAdjustViewBounds(true);
                        new AlertDialog.Builder(activity).setMessage(FragmentOfficial.this.getString(C2030R.string.official_shakemap_proonly)).setView(imageView).setTitle(C2030R.string.app_name).setIcon(2131230872).setCancelable(false).setNegativeButton(FragmentOfficial.this.getString(C2030R.string.ads_buy_pro), new C1789g1(this, activity)).setPositiveButton(FragmentOfficial.this.getString(C2030R.string.official_close), new C1795h1()).show();
                    }
                }
            }

            private a(View view) {
                super(view);
                this.f12986F = (TextView) view.findViewById(C2030R.id.location);
                this.f12987G = (TextView) view.findViewById(C2030R.id.magnitude);
                this.f12988H = (TextView) view.findViewById(C2030R.id.date);
                this.f12989I = (TextView) view.findViewById(C2030R.id.distance);
                this.f12990J = (TextView) view.findViewById(C2030R.id.smartphones);
                this.f12991K = (TextView) view.findViewById(C2030R.id.reports);
                this.f12992L = (Button) view.findViewById(C2030R.id.button_shakemap);
                this.f12993M = view.findViewById(C2030R.id.divider);
                this.f12992L.setOnClickListener(this);
                CardView cardView = (CardView) view.findViewById(C2030R.id.cardEarthquake);
                this.f12994N = cardView;
                cardView.setOnClickListener(this);
                this.f12995O = (LinearLayout) view.findViewById(C2030R.id.linearSmartphones);
            }
        }

        protected class b extends RecyclerView.F implements View.OnClickListener {

            /* renamed from: F  reason: collision with root package name */
            TextView f12997F;

            /* renamed from: G  reason: collision with root package name */
            TextView f12998G;

            /* renamed from: H  reason: collision with root package name */
            TextView f12999H;

            /* renamed from: I  reason: collision with root package name */
            TextView f13000I;

            /* renamed from: J  reason: collision with root package name */
            TextView f13001J;

            /* renamed from: K  reason: collision with root package name */
            TextView f13002K;

            /* renamed from: L  reason: collision with root package name */
            TextView f13003L;

            /* renamed from: M  reason: collision with root package name */
            TextView f13004M;

            /* renamed from: N  reason: collision with root package name */
            TextView f13005N;

            /* renamed from: O  reason: collision with root package name */
            TextView f13006O;

            /* renamed from: P  reason: collision with root package name */
            TextView f13007P;

            /* renamed from: Q  reason: collision with root package name */
            TextView f13008Q;

            /* renamed from: R  reason: collision with root package name */
            MapView f13009R;

            /* renamed from: S  reason: collision with root package name */
            ImageView f13010S;

            /* renamed from: T  reason: collision with root package name */
            ImageView f13011T;

            /* renamed from: U  reason: collision with root package name */
            Button f13012U;

            /* renamed from: V  reason: collision with root package name */
            Button f13013V;

            /* renamed from: W  reason: collision with root package name */
            Button f13014W;

            /* renamed from: X  reason: collision with root package name */
            Button f13015X;

            /* renamed from: Y  reason: collision with root package name */
            Button f13016Y;

            /* renamed from: Z  reason: collision with root package name */
            Button f13017Z;

            /* renamed from: a0  reason: collision with root package name */
            Button f13018a0;

            /* renamed from: b0  reason: collision with root package name */
            View f13019b0;

            /* renamed from: c0  reason: collision with root package name */
            CardView f13020c0;

            /* renamed from: d0  reason: collision with root package name */
            LinearLayout f13021d0;

            /* renamed from: e0  reason: collision with root package name */
            LinearLayout f13022e0;

            /* renamed from: f0  reason: collision with root package name */
            LinearLayout f13023f0;

            /* renamed from: g0  reason: collision with root package name */
            LinearLayout f13024g0;

            /* synthetic */ b(h hVar, View view, a aVar) {
                this(view);
            }

            public static /* synthetic */ void O(b bVar, Activity activity, DialogInterface dialogInterface, int i8) {
                bVar.getClass();
                FragmentOfficial.this.startActivity(new Intent().setClass(activity, ToProActivity.class));
            }

            public static /* synthetic */ void P(DialogInterface dialogInterface, int i8) {
            }

            public static /* synthetic */ void Q(b bVar, Spinner spinner, CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3, DialogInterface dialogInterface, int i8) {
                String unused = FragmentOfficial.this.f12937g1 = FragmentOfficial.this.getResources().getStringArray(C2030R.array.official_card_textsize_values)[spinner.getSelectedItemPosition()];
                boolean unused2 = FragmentOfficial.this.f12938h1 = checkBox.isChecked();
                boolean unused3 = FragmentOfficial.this.f12939i1 = checkBox2.isChecked();
                boolean unused4 = FragmentOfficial.this.f12940j1 = checkBox3.isChecked();
                FragmentOfficial.this.f12925U0.putString("card_textsize", FragmentOfficial.this.f12937g1);
                FragmentOfficial.this.f12925U0.putBoolean("card_showdistance", FragmentOfficial.this.f12938h1);
                FragmentOfficial.this.f12925U0.putBoolean("card_showcoordinates", FragmentOfficial.this.f12939i1);
                FragmentOfficial.this.f12925U0.putBoolean("card_showpopulation", FragmentOfficial.this.f12940j1);
                FragmentOfficial.this.f12925U0.apply();
                FragmentOfficial.this.f12927W0.o();
            }

            public void onClick(View view) {
                String str;
                boolean z7 = false;
                int k8 = k();
                if (k8 < 0) {
                    return;
                }
                if (view.getId() == this.f13012U.getId()) {
                    if (FragmentOfficial.this.A2()) {
                        ((i) h.this.f12984d.get(k())).j0((org.achartengine.b) null);
                        ((i) h.this.f12984d.get(k())).z0(true);
                        for (int i8 = 0; i8 < h.this.f12984d.size(); i8++) {
                            if (i8 != k()) {
                                ((i) h.this.f12984d.get(i8)).z0(false);
                            }
                        }
                        FragmentOfficial.this.f12927W0.o();
                        return;
                    }
                    C0891s activity = FragmentOfficial.this.getActivity();
                    if (activity != null) {
                        Toast makeText = Toast.makeText(activity, FragmentOfficial.this.getString(C2030R.string.main_nointernet), 1);
                        makeText.setGravity(17, 0, 0);
                        makeText.show();
                    }
                } else if (view.getId() == this.f13013V.getId()) {
                    h hVar = h.this;
                    ((i) h.this.f12984d.get(k8)).j0(FragmentOfficial.this.s2(((i) hVar.f12984d.get(k8)).W(), ((i) h.this.f12984d.get(k8)).Y(), ((i) h.this.f12984d.get(k8)).f0(), ((i) h.this.f12984d.get(k8)).Z()));
                    ((i) h.this.f12984d.get(k8)).z0(false);
                    FragmentOfficial.this.f12927W0.o();
                    RecyclerView.p layoutManager = FragmentOfficial.this.f12928X0.getLayoutManager();
                    if (layoutManager != null) {
                        layoutManager.B1(k8);
                    }
                } else if (view.getId() == this.f13017Z.getId()) {
                    FragmentOfficial.this.J2(k8, true);
                } else if (view.getId() == this.f13014W.getId()) {
                    View inflate = LayoutInflater.from(FragmentOfficial.this.getActivity()).inflate(C2030R.layout.dialog_official_card, (ViewGroup) null);
                    Spinner spinner = (Spinner) inflate.findViewById(C2030R.id.spinner1);
                    String a12 = FragmentOfficial.this.f12937g1;
                    a12.getClass();
                    char c8 = 65535;
                    switch (a12.hashCode()) {
                        case 48:
                            if (a12.equals("0")) {
                                c8 = 0;
                                break;
                            }
                            break;
                        case 49:
                            if (a12.equals("1")) {
                                c8 = 1;
                                break;
                            }
                            break;
                        case 50:
                            if (a12.equals("2")) {
                                c8 = 2;
                                break;
                            }
                            break;
                        case 1444:
                            if (a12.equals("-1")) {
                                c8 = 3;
                                break;
                            }
                            break;
                        case 1445:
                            if (a12.equals("-2")) {
                                c8 = 4;
                                break;
                            }
                            break;
                    }
                    switch (c8) {
                        case 0:
                            spinner.setSelection(2);
                            break;
                        case 1:
                            spinner.setSelection(1);
                            break;
                        case 2:
                            spinner.setSelection(0);
                            break;
                        case 3:
                            spinner.setSelection(3);
                            break;
                        case 4:
                            spinner.setSelection(4);
                            break;
                    }
                    CheckBox checkBox = (CheckBox) inflate.findViewById(C2030R.id.checkBox1);
                    checkBox.setChecked(FragmentOfficial.this.f12938h1);
                    CheckBox checkBox2 = (CheckBox) inflate.findViewById(C2030R.id.checkBox2);
                    checkBox2.setChecked(FragmentOfficial.this.f12939i1);
                    CheckBox checkBox3 = (CheckBox) inflate.findViewById(C2030R.id.checkBox3);
                    checkBox3.setChecked(FragmentOfficial.this.f12940j1);
                    AlertDialog.Builder builder = new AlertDialog.Builder(FragmentOfficial.this.getActivity());
                    builder.setPositiveButton(FragmentOfficial.this.getString(C2030R.string.official_close), new C1801i1(this, spinner, checkBox, checkBox2, checkBox3));
                    builder.setTitle(FragmentOfficial.this.getString(C2030R.string.official_card_settings));
                    AlertDialog create = builder.create();
                    create.setView(inflate, 10, 10, 10, 10);
                    create.setInverseBackgroundForced(true);
                    if (create.getWindow() != null) {
                        create.getWindow().setGravity(16);
                    }
                    create.show();
                } else if (view.getId() == this.f13011T.getId()) {
                    int unused = FragmentOfficial.this.f12943m1 = k8;
                    C0891s activity2 = FragmentOfficial.this.getActivity();
                    if (activity2 == null) {
                        return;
                    }
                    if (!((i) h.this.f12984d.get(k8)).h0()) {
                        String str2 = activity2.getFilesDir().toString() + "/earthquake_share.png";
                        View view2 = this.f10283a;
                        view2.setDrawingCacheEnabled(true);
                        Bitmap createBitmap = Bitmap.createBitmap(view2.getDrawingCache());
                        view2.setDrawingCacheEnabled(false);
                        try {
                            FileOutputStream fileOutputStream = new FileOutputStream(new File(str2));
                            createBitmap.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream);
                            fileOutputStream.flush();
                            fileOutputStream.close();
                            z7 = true;
                        } catch (IOException unused2) {
                        }
                        Intent intent = new Intent("android.intent.action.SEND");
                        if (z7) {
                            Uri h8 = FileProvider.h(FragmentOfficial.this.getActivity().getApplicationContext(), FragmentOfficial.this.getActivity().getPackageName() + ".fileprovider", new File(str2));
                            intent.setType("image/png");
                            intent.putExtra("android.intent.extra.STREAM", h8);
                            intent.putExtra("android.intent.extra.SUBJECT", FragmentOfficial.this.getString(C2030R.string.app_name));
                            intent.putExtra("android.intent.extra.TEXT", FragmentOfficial.this.getString(C2030R.string.share_hashtag) + " M" + ((i) h.this.f12984d.get(k8)).Z() + ",  " + ((i) h.this.f12984d.get(k8)).X() + ". " + FragmentOfficial.this.getString(C2030R.string.share_notified));
                        } else {
                            intent.setType("text/plain");
                            intent.putExtra("android.intent.extra.SUBJECT", FragmentOfficial.this.getString(C2030R.string.app_name));
                            intent.putExtra("android.intent.extra.TEXT", FragmentOfficial.this.getString(C2030R.string.share_hashtag) + " M" + ((i) h.this.f12984d.get(k8)).Z() + ",  " + ((i) h.this.f12984d.get(k8)).X() + ". " + FragmentOfficial.this.getString(C2030R.string.share_notified));
                        }
                        FragmentOfficial fragmentOfficial = FragmentOfficial.this;
                        fragmentOfficial.startActivity(Intent.createChooser(intent, fragmentOfficial.getString(C2030R.string.share_share)));
                    } else if (FragmentOfficial.this.f12947o1 != null) {
                        LinearLayout linearLayout = this.f13024g0;
                        linearLayout.setDrawingCacheEnabled(true);
                        Bitmap unused3 = FragmentOfficial.this.f12949p1 = Bitmap.createBitmap(linearLayout.getDrawingCache());
                        linearLayout.setDrawingCacheEnabled(false);
                        linearLayout.setBackgroundColor(0);
                        FragmentOfficial.this.f12947o1.snapshot(FragmentOfficial.this);
                    }
                } else if (view.getId() == this.f13015X.getId()) {
                    try {
                        Date parse = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault()).parse(((i) h.this.f12984d.get(k8)).S());
                        GregorianCalendar gregorianCalendar = new GregorianCalendar();
                        gregorianCalendar.setTime(parse);
                        double z8 = ((i) h.this.f12984d.get(k8)).Z();
                        String format = String.format(FragmentOfficial.this.getString(C2030R.string.calendar_title), new Object[]{Double.toString(z8), ((i) h.this.f12984d.get(k8)).X()});
                        long M7 = (long) ((i) h.this.f12984d.get(k8)).T();
                        if (FragmentOfficial.this.f12910F0 != 0.0d && FragmentOfficial.this.f12911G0 != 0.0d) {
                            FragmentOfficial fragmentOfficial2 = FragmentOfficial.this;
                            long round = Math.round(fragmentOfficial2.z2(fragmentOfficial2.f12910F0, FragmentOfficial.this.f12911G0, ((i) h.this.f12984d.get(k8)).W(), ((i) h.this.f12984d.get(k8)).Y()));
                            if (FragmentOfficial.this.f12929Y0.equals("1")) {
                                str = String.format(FragmentOfficial.this.getString(C2030R.string.calendar_description_mi), new Object[]{Double.toString(z8), Long.toString((long) (((double) M7) * 0.621371192d)), Long.toString((long) (((double) round) * 0.621371192d))});
                            } else {
                                str = String.format(FragmentOfficial.this.getString(C2030R.string.calendar_description_km), new Object[]{Double.toString(z8), Long.toString(M7), Long.toString(round)});
                            }
                        } else if (FragmentOfficial.this.f12929Y0.equals("1")) {
                            str = String.format(FragmentOfficial.this.getString(C2030R.string.calendar_description_nogeo_mi), new Object[]{Double.toString(z8), Long.toString(M7)});
                        } else {
                            str = String.format(FragmentOfficial.this.getString(C2030R.string.calendar_description_nogeo_km), new Object[]{Double.toString(z8), Long.toString(M7)});
                        }
                        Calendar instance = Calendar.getInstance();
                        instance.set(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5), gregorianCalendar.get(11), gregorianCalendar.get(12));
                        FragmentOfficial.this.startActivity(new Intent("android.intent.action.INSERT").setData(CalendarContract.Events.CONTENT_URI).putExtra("beginTime", instance.getTimeInMillis()).putExtra("endTime", instance.getTimeInMillis()).putExtra("title", format).putExtra("description", str));
                    } catch (ParseException e8) {
                        if (e8.getMessage() != null) {
                            Log.d("EQN", e8.getMessage());
                        }
                    }
                } else if (view.getId() == this.f13016Y.getId()) {
                    ((i) h.this.f12984d.get(k8)).m0((GoogleMap) null);
                    ((i) h.this.f12984d.get(k8)).j0((org.achartengine.b) null);
                    ((i) h.this.f12984d.get(k8)).z0(false);
                    FragmentOfficial.this.f12927W0.o();
                    int unused4 = FragmentOfficial.this.f12920P0 = 0;
                    RecyclerView.p layoutManager2 = FragmentOfficial.this.f12928X0.getLayoutManager();
                    if (layoutManager2 != null) {
                        layoutManager2.B1(k8);
                    }
                } else if (view.getId() != this.f13018a0.getId()) {
                    FragmentOfficial.this.J2(k8, false);
                } else if (FragmentOfficial.this.f12961v1) {
                    new f(FragmentOfficial.this, ((i) h.this.f12984d.get(k8)).V(), k8, (a) null).execute(new Context[]{FragmentOfficial.this.getActivity()});
                } else {
                    C0891s activity3 = FragmentOfficial.this.getActivity();
                    if (activity3 != null) {
                        ImageView imageView = new ImageView(activity3);
                        imageView.setImageDrawable(FragmentOfficial.this.getResources().getDrawable(C2030R.drawable.shakemap));
                        imageView.setAdjustViewBounds(true);
                        new AlertDialog.Builder(activity3).setMessage(FragmentOfficial.this.getString(C2030R.string.official_shakemap_proonly)).setView(imageView).setTitle(C2030R.string.app_name).setIcon(2131230872).setCancelable(false).setNegativeButton(FragmentOfficial.this.getString(C2030R.string.ads_buy_pro), new C1807j1(this, activity3)).setPositiveButton(FragmentOfficial.this.getString(C2030R.string.official_close), new C1813k1()).show();
                    }
                }
            }

            private b(View view) {
                super(view);
                this.f12997F = (TextView) view.findViewById(C2030R.id.location);
                this.f12998G = (TextView) view.findViewById(C2030R.id.provider);
                this.f12999H = (TextView) view.findViewById(C2030R.id.magnitude);
                this.f13000I = (TextView) view.findViewById(C2030R.id.magnitude_type);
                this.f13001J = (TextView) view.findViewById(C2030R.id.date);
                this.f13002K = (TextView) view.findViewById(C2030R.id.distance);
                this.f13003L = (TextView) view.findViewById(C2030R.id.coordinates);
                this.f13004M = (TextView) view.findViewById(C2030R.id.depth);
                this.f13005N = (TextView) view.findViewById(C2030R.id.population);
                this.f13006O = (TextView) view.findViewById(C2030R.id.preliminary);
                this.f13007P = (TextView) view.findViewById(C2030R.id.smartphones);
                this.f13008Q = (TextView) view.findViewById(C2030R.id.reports);
                this.f13012U = (Button) view.findViewById(C2030R.id.button_map);
                this.f13013V = (Button) view.findViewById(C2030R.id.button_trend);
                this.f13014W = (Button) view.findViewById(C2030R.id.button_settings);
                this.f13015X = (Button) view.findViewById(C2030R.id.button_calendar);
                this.f13016Y = (Button) view.findViewById(C2030R.id.button_close);
                this.f13017Z = (Button) view.findViewById(C2030R.id.button_wave);
                this.f13018a0 = (Button) view.findViewById(C2030R.id.button_shakemap);
                this.f13009R = (MapView) view.findViewById(C2030R.id.static_map);
                this.f13010S = (ImageView) view.findViewById(C2030R.id.chartImage);
                this.f13011T = (ImageView) view.findViewById(C2030R.id.share);
                this.f13019b0 = view.findViewById(C2030R.id.divider);
                this.f13012U.setOnClickListener(this);
                this.f13013V.setOnClickListener(this);
                this.f13014W.setOnClickListener(this);
                this.f13015X.setOnClickListener(this);
                this.f13016Y.setOnClickListener(this);
                this.f13017Z.setOnClickListener(this);
                this.f13018a0.setOnClickListener(this);
                this.f13011T.setOnClickListener(this);
                CardView cardView = (CardView) view.findViewById(C2030R.id.cardEarthquake);
                this.f13020c0 = cardView;
                cardView.setOnClickListener(this);
                this.f13021d0 = (LinearLayout) view.findViewById(C2030R.id.linearButtons);
                this.f13022e0 = (LinearLayout) view.findViewById(C2030R.id.linearStatic);
                this.f13024g0 = (LinearLayout) view.findViewById(C2030R.id.infoLayout);
                this.f13023f0 = (LinearLayout) view.findViewById(C2030R.id.linearSmartphones);
            }
        }

        /* synthetic */ h(FragmentOfficial fragmentOfficial, List list, a aVar) {
            this(list);
        }

        /* access modifiers changed from: package-private */
        public void D(i iVar) {
            this.f12984d.add(iVar);
        }

        /* access modifiers changed from: package-private */
        public Object E(int i8) {
            return this.f12984d.get(i8);
        }

        public int j() {
            return this.f12984d.size();
        }

        public long k(int i8) {
            return (long) i8;
        }

        public int l(int i8) {
            return 0;
        }

        public void r(RecyclerView.F f8, int i8) {
            if (FragmentOfficial.this.f12935e1 == 2) {
                FragmentOfficial.this.H2(i8, (a) f8);
            } else {
                FragmentOfficial.this.I2(i8, (b) f8);
            }
        }

        public RecyclerView.F t(ViewGroup viewGroup, int i8) {
            if (FragmentOfficial.this.f12935e1 == 2) {
                return new a(this, LayoutInflater.from(viewGroup.getContext()).inflate(C2030R.layout.qlist_compact, viewGroup, false), (a) null);
            }
            return new b(this, LayoutInflater.from(viewGroup.getContext()).inflate(C2030R.layout.qlist, viewGroup, false), (a) null);
        }

        private h(List list) {
            this.f12984d = list;
        }
    }

    public static /* synthetic */ void A0(FragmentOfficial fragmentOfficial, View view, Button button, RadioGroup radioGroup, int i8) {
        fragmentOfficial.getClass();
        if (i8 == C2030R.id.radioButton1) {
            ((SeekBar) view.findViewById(C2030R.id.seekBar)).setEnabled(true);
            ((SeekBar) view.findViewById(C2030R.id.seekBar2)).setEnabled(true);
            fragmentOfficial.f12923S0 = 0;
            fragmentOfficial.f12925U0.putInt("filter_type", 0);
            fragmentOfficial.f12925U0.apply();
            button.setText(fragmentOfficial.getString(C2030R.string.filter_area));
            if (fragmentOfficial.f12924T0.getFloat("last_downloaded_min_magnitude", 2.0f) > BitmapDescriptorFactory.HUE_RED) {
                fragmentOfficial.q2();
                return;
            }
            fragmentOfficial.r2(fragmentOfficial.f12923S0);
            fragmentOfficial.K2(fragmentOfficial.f12922R0);
            fragmentOfficial.p2();
            fragmentOfficial.f12927W0.o();
        } else if (i8 == C2030R.id.radioButton2) {
            ((SeekBar) view.findViewById(C2030R.id.seekBar)).setEnabled(false);
            ((SeekBar) view.findViewById(C2030R.id.seekBar2)).setEnabled(false);
            fragmentOfficial.f12923S0 = 1;
            fragmentOfficial.f12925U0.putInt("filter_type", 1);
            fragmentOfficial.f12925U0.apply();
            button.setText(fragmentOfficial.getString(C2030R.string.filter_relevant));
            if (fragmentOfficial.f12924T0.getFloat("last_downloaded_min_magnitude", 2.0f) > BitmapDescriptorFactory.HUE_RED) {
                fragmentOfficial.q2();
            } else {
                fragmentOfficial.r2(fragmentOfficial.f12923S0);
                fragmentOfficial.K2(fragmentOfficial.f12922R0);
                fragmentOfficial.p2();
                fragmentOfficial.f12927W0.o();
            }
            fragmentOfficial.f12927W0.o();
        } else if (i8 == C2030R.id.radioButton3) {
            ((SeekBar) view.findViewById(C2030R.id.seekBar)).setEnabled(false);
            ((SeekBar) view.findViewById(C2030R.id.seekBar2)).setEnabled(false);
            fragmentOfficial.f12923S0 = 2;
            fragmentOfficial.f12925U0.putInt("filter_type", 2);
            fragmentOfficial.f12925U0.apply();
            button.setText(fragmentOfficial.getString(C2030R.string.filter_all));
            fragmentOfficial.r2(fragmentOfficial.f12923S0);
            fragmentOfficial.K2(fragmentOfficial.f12922R0);
            fragmentOfficial.p2();
            fragmentOfficial.f12927W0.o();
        } else if (i8 == C2030R.id.radioButton4) {
            ((SeekBar) view.findViewById(C2030R.id.seekBar)).setEnabled(false);
            ((SeekBar) view.findViewById(C2030R.id.seekBar2)).setEnabled(false);
            fragmentOfficial.f12923S0 = 3;
            fragmentOfficial.f12925U0.putInt("filter_type", 3);
            fragmentOfficial.f12925U0.apply();
            button.setText(fragmentOfficial.getString(C2030R.string.filter_felt));
            fragmentOfficial.r2(fragmentOfficial.f12923S0);
            fragmentOfficial.K2(fragmentOfficial.f12922R0);
            fragmentOfficial.p2();
            fragmentOfficial.f12927W0.o();
        }
    }

    /* access modifiers changed from: private */
    public boolean A2() {
        ConnectivityManager connectivityManager;
        boolean z7;
        C0891s activity = getActivity();
        if (activity == null || (connectivityManager = (ConnectivityManager) activity.getSystemService("connectivity")) == null) {
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

    private boolean B2() {
        boolean z7;
        boolean z8;
        C0891s activity = getActivity();
        boolean z9 = false;
        if (activity == null) {
            return false;
        }
        SharedPreferences sharedPreferences = activity.getSharedPreferences(MainActivity.class.getSimpleName(), 0);
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

    public static /* synthetic */ void C0(FragmentOfficial fragmentOfficial, View view) {
        ((TextView) fragmentOfficial.f12944n0.findViewById(C2030R.id.textView14)).setVisibility(8);
        int i8 = fragmentOfficial.f12922R0 + 1;
        fragmentOfficial.f12922R0 = i8;
        if (i8 == 3) {
            fragmentOfficial.f12922R0 = 0;
        }
        int i9 = fragmentOfficial.f12922R0;
        if (i9 == 0) {
            ((MaterialButton) view).setIcon(fragmentOfficial.getResources().getDrawable(C2030R.drawable.clock_outline));
        } else if (i9 == 1) {
            ((MaterialButton) view).setIcon(fragmentOfficial.getResources().getDrawable(C2030R.drawable.compass));
        } else if (i9 == 2) {
            ((MaterialButton) view).setIcon(fragmentOfficial.getResources().getDrawable(C2030R.drawable.thermometer));
        }
        fragmentOfficial.f12925U0.putInt("order_type", fragmentOfficial.f12922R0);
        fragmentOfficial.f12925U0.apply();
        fragmentOfficial.r2(fragmentOfficial.f12923S0);
        fragmentOfficial.K2(fragmentOfficial.f12922R0);
        fragmentOfficial.p2();
        if (fragmentOfficial.f12920P0 == 1) {
            fragmentOfficial.F2();
        }
        fragmentOfficial.f12927W0.o();
    }

    private void C2() {
        ((ProgressBar) this.f12944n0.findViewById(C2030R.id.progressBar1)).setVisibility(0);
        ((TextView) this.f12944n0.findViewById(C2030R.id.textView15)).setVisibility(8);
        C0891s activity = getActivity();
        if (activity != null) {
            new e(this, (a) null).execute(new Context[]{activity});
        }
    }

    public static /* synthetic */ int D0(FragmentOfficial fragmentOfficial, i iVar, i iVar2) {
        double d8 = fragmentOfficial.f12910F0;
        if (d8 == 0.0d) {
            return 0;
        }
        double d9 = fragmentOfficial.f12911G0;
        if (d9 == 0.0d) {
            return 0;
        }
        FragmentOfficial fragmentOfficial2 = fragmentOfficial;
        return Long.compare(Math.round(fragmentOfficial2.z2(d8, d9, iVar.f13027b, iVar.f13028c)), Math.round(fragmentOfficial2.z2(fragmentOfficial2.f12910F0, fragmentOfficial2.f12911G0, iVar2.f13027b, iVar2.f13028c)));
    }

    private void D2() {
        double d8;
        boolean z7;
        boolean z8;
        if (A2()) {
            if (B2()) {
                this.f12916L0 = this.f12924T0.getString("official_date_notification", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                this.f12917M0 = this.f12924T0.getFloat("official_mag_notification", BitmapDescriptorFactory.HUE_RED);
                this.f12918N0 = this.f12924T0.getFloat("official_lat_notification", BitmapDescriptorFactory.HUE_RED);
                float f8 = this.f12924T0.getFloat("official_lon_notification", BitmapDescriptorFactory.HUE_RED);
                this.f12919O0 = f8;
                double z22 = z2(this.f12910F0, this.f12911G0, (double) this.f12918N0, (double) f8);
                float f9 = this.f12917M0;
                if (((double) f9) >= 7.0d || z22 <= 2000.0d) {
                    d8 = 3.0d;
                    if ((((double) f9) >= 6.5d || z22 <= 1600.0d) && ((((double) f9) >= 6.0d || z22 <= 1300.0d) && ((((double) f9) >= 5.5d || z22 <= 1000.0d) && ((((double) f9) >= 5.0d || z22 <= 700.0d) && ((((double) f9) >= 4.5d || z22 <= 500.0d) && ((((double) f9) >= 4.0d || z22 <= 350.0d) && ((((double) f9) >= 3.5d || z22 <= 200.0d) && ((((double) f9) >= 3.0d || z22 <= 125.0d) && ((((double) f9) >= 2.5d || z22 <= 70.0d) && ((((double) f9) >= 2.0d || z22 <= 35.0d) && (((double) f9) >= 1.5d || z22 <= 20.0d))))))))))) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                } else {
                    z7 = false;
                    d8 = 3.0d;
                }
                if (this.f12923S0 == 0) {
                    int i8 = (z22 > 2000.0d ? 1 : (z22 == 2000.0d ? 0 : -1));
                    if (i8 > 0 && z7) {
                        this.f12923S0 = 1;
                        this.f12925U0.putInt("filter_type", 1);
                        this.f12925U0.apply();
                        ((Button) this.f12944n0.findViewById(C2030R.id.button2)).setText(getString(C2030R.string.filter_relevant));
                    } else if (i8 <= 0 || ((double) f9) < 2.0d) {
                        if (z22 > ((double) this.f12914J0)) {
                            if (z22 > 1500.0d) {
                                this.f12914J0 = 2000.0f;
                            } else if (z22 > 1000.0d) {
                                this.f12914J0 = 1500.0f;
                            } else if (z22 > 750.0d) {
                                this.f12914J0 = 1000.0f;
                            } else if (z22 > 500.0d) {
                                this.f12914J0 = 750.0f;
                            } else if (z22 > 250.0d) {
                                this.f12914J0 = 500.0f;
                            } else if (z22 > 100.0d) {
                                this.f12914J0 = 250.0f;
                            }
                            this.f12925U0.putFloat("filter_list_radius", this.f12914J0);
                            this.f12925U0.apply();
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        float f10 = this.f12917M0;
                        if (f10 < this.f12915K0) {
                            if (((double) f10) < 1.0d) {
                                this.f12915K0 = BitmapDescriptorFactory.HUE_RED;
                            } else if (((double) f10) < 2.0d) {
                                this.f12915K0 = 1.0f;
                            } else if (((double) f10) < d8) {
                                this.f12915K0 = 2.0f;
                            } else if (((double) f10) < 4.0d) {
                                this.f12915K0 = 3.0f;
                            } else if (((double) f10) < 5.0d) {
                                this.f12915K0 = 4.0f;
                            } else if (((double) f10) < 6.0d) {
                                this.f12915K0 = 5.0f;
                            }
                            this.f12925U0.putFloat("filter_list_min_magnitude", this.f12915K0);
                            this.f12925U0.apply();
                        }
                    } else {
                        this.f12923S0 = 2;
                        this.f12925U0.putInt("filter_type", 2);
                        this.f12925U0.apply();
                        ((Button) this.f12944n0.findViewById(C2030R.id.button2)).setText(getString(C2030R.string.filter_all));
                    }
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (this.f12923S0 == 1 && !z7 && z22 <= 2000.0d) {
                    this.f12923S0 = 0;
                    this.f12925U0.putInt("filter_type", 0);
                    this.f12925U0.apply();
                    if (z22 > ((double) this.f12914J0)) {
                        if (z22 > 1500.0d) {
                            this.f12914J0 = 2000.0f;
                        } else if (z22 > 1000.0d) {
                            this.f12914J0 = 1500.0f;
                        } else if (z22 > 750.0d) {
                            this.f12914J0 = 1000.0f;
                        } else if (z22 > 500.0d) {
                            this.f12914J0 = 750.0f;
                        } else if (z22 > 250.0d) {
                            this.f12914J0 = 500.0f;
                        } else if (z22 > 100.0d) {
                            this.f12914J0 = 250.0f;
                        }
                        this.f12925U0.putFloat("filter_list_radius", this.f12914J0);
                        this.f12925U0.apply();
                    }
                    float f11 = this.f12917M0;
                    if (f11 < this.f12915K0) {
                        if (((double) f11) < 1.0d) {
                            this.f12915K0 = BitmapDescriptorFactory.HUE_RED;
                        } else if (((double) f11) < 2.0d) {
                            this.f12915K0 = 1.0f;
                        } else if (((double) f11) < d8) {
                            this.f12915K0 = 2.0f;
                        } else if (((double) f11) < 4.0d) {
                            this.f12915K0 = 3.0f;
                        } else if (((double) f11) < 5.0d) {
                            this.f12915K0 = 4.0f;
                        } else if (((double) f11) < 6.0d) {
                            this.f12915K0 = 5.0f;
                        }
                        this.f12925U0.putFloat("filter_list_min_magnitude", this.f12915K0);
                        this.f12925U0.apply();
                    }
                    ((Button) this.f12944n0.findViewById(C2030R.id.button2)).setText(getString(C2030R.string.filter_area));
                    z8 = true;
                }
                if (this.f12923S0 == 1 && !z7 && z22 > 2000.0d && ((double) this.f12917M0) >= 2.0d) {
                    this.f12923S0 = 2;
                    this.f12925U0.putInt("filter_type", 2);
                    this.f12925U0.apply();
                    ((Button) this.f12944n0.findViewById(C2030R.id.button2)).setText(getString(C2030R.string.filter_all));
                    z8 = true;
                }
                if (this.f12923S0 == 2 && ((double) this.f12917M0) < 2.0d && z7) {
                    this.f12923S0 = 1;
                    this.f12925U0.putInt("filter_type", 1);
                    this.f12925U0.apply();
                    ((Button) this.f12944n0.findViewById(C2030R.id.button2)).setText(getString(C2030R.string.filter_relevant));
                    z8 = true;
                }
                if (this.f12923S0 >= 2 && ((double) this.f12917M0) < 2.0d && z22 <= 2000.0d && !z7) {
                    this.f12923S0 = 0;
                    this.f12925U0.putInt("filter_type", 0);
                    this.f12925U0.apply();
                    if (z22 > ((double) this.f12914J0)) {
                        if (z22 > 1500.0d) {
                            this.f12914J0 = 2000.0f;
                        } else if (z22 > 1000.0d) {
                            this.f12914J0 = 1500.0f;
                        } else if (z22 > 750.0d) {
                            this.f12914J0 = 1000.0f;
                        } else if (z22 > 500.0d) {
                            this.f12914J0 = 750.0f;
                        } else if (z22 > 250.0d) {
                            this.f12914J0 = 500.0f;
                        } else if (z22 > 100.0d) {
                            this.f12914J0 = 250.0f;
                        }
                        this.f12925U0.putFloat("filter_list_radius", this.f12914J0);
                        this.f12925U0.apply();
                    }
                    float f12 = this.f12917M0;
                    if (f12 < this.f12915K0) {
                        if (((double) f12) < 1.0d) {
                            this.f12915K0 = BitmapDescriptorFactory.HUE_RED;
                        } else if (((double) f12) < 2.0d) {
                            this.f12915K0 = 1.0f;
                        } else if (((double) f12) < d8) {
                            this.f12915K0 = 2.0f;
                        } else if (((double) f12) < 4.0d) {
                            this.f12915K0 = 3.0f;
                        } else if (((double) f12) < 5.0d) {
                            this.f12915K0 = 4.0f;
                        } else if (((double) f12) < 6.0d) {
                            this.f12915K0 = 5.0f;
                        }
                        this.f12925U0.putFloat("filter_list_min_magnitude", this.f12915K0);
                        this.f12925U0.apply();
                    }
                    ((Button) this.f12944n0.findViewById(C2030R.id.button2)).setText(getString(C2030R.string.filter_area));
                    z8 = true;
                }
                if (this.f12923S0 == 3 && ((double) this.f12917M0) >= 2.0d) {
                    this.f12923S0 = 2;
                    this.f12925U0.putInt("filter_type", 2);
                    this.f12925U0.apply();
                    ((Button) this.f12944n0.findViewById(C2030R.id.button2)).setText(getString(C2030R.string.filter_all));
                    z8 = true;
                }
                if (z8) {
                    ((TextView) this.f12944n0.findViewById(C2030R.id.textView14)).setVisibility(0);
                }
            } else if (this.f12923S0 == 3) {
                this.f12923S0 = 2;
                this.f12925U0.putInt("filter_type", 2);
                this.f12925U0.apply();
                ((Button) this.f12944n0.findViewById(C2030R.id.button2)).setText(getString(C2030R.string.filter_relevant));
                ((TextView) this.f12944n0.findViewById(C2030R.id.textView14)).setVisibility(0);
            }
            this.f12920P0 = 1;
            q2();
            return;
        }
        E2();
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x007e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void E2() {
        /*
            r10 = this;
            java.lang.String r0 = "EQN"
            r1 = 1
            r2 = 0
            androidx.fragment.app.s r3 = r10.getActivity()     // Catch:{ IOException -> 0x0046 }
            if (r3 == 0) goto L_0x0055
            java.lang.String r4 = "cache_automatic14.txt"
            java.io.FileInputStream r3 = r3.openFileInput(r4)     // Catch:{ IOException -> 0x0046 }
            java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0046 }
            r4.<init>(r3)     // Catch:{ IOException -> 0x0046 }
            java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0046 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0046 }
            java.lang.String r3 = r3.readLine()     // Catch:{ IOException -> 0x0037, NumberFormatException -> 0x0035 }
            if (r3 == 0) goto L_0x004a
            long r5 = java.lang.Long.parseLong(r3)     // Catch:{ IOException -> 0x0037, NumberFormatException -> 0x0035 }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0037, NumberFormatException -> 0x0035 }
            long r7 = r7 - r5
            r5 = 120000(0x1d4c0, double:5.9288E-319)
            int r3 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r3 >= 0) goto L_0x0032
            r3 = r2
            goto L_0x0033
        L_0x0032:
            r3 = r1
        L_0x0033:
            r5 = r1
            goto L_0x004c
        L_0x0035:
            r3 = move-exception
            goto L_0x0038
        L_0x0037:
            r3 = move-exception
        L_0x0038:
            java.lang.String r5 = r3.getMessage()     // Catch:{ IOException -> 0x0046 }
            if (r5 == 0) goto L_0x004a
            java.lang.String r3 = r3.getMessage()     // Catch:{ IOException -> 0x0046 }
            android.util.Log.d(r0, r3)     // Catch:{ IOException -> 0x0046 }
            goto L_0x004a
        L_0x0046:
            r3 = move-exception
            r4 = r1
            r5 = r2
            goto L_0x0058
        L_0x004a:
            r3 = r1
            r5 = r2
        L_0x004c:
            r4.close()     // Catch:{ IOException -> 0x0050 }
            goto L_0x0066
        L_0x0050:
            r4 = move-exception
            r9 = r4
            r4 = r3
            r3 = r9
            goto L_0x0058
        L_0x0055:
            r3 = r1
            r5 = r2
            goto L_0x0066
        L_0x0058:
            java.lang.String r6 = r3.getMessage()
            if (r6 == 0) goto L_0x0065
            java.lang.String r3 = r3.getMessage()
            android.util.Log.d(r0, r3)
        L_0x0065:
            r3 = r4
        L_0x0066:
            boolean r0 = r10.A2()
            if (r0 == 0) goto L_0x0078
            if (r3 == 0) goto L_0x0078
            r0 = 0
            r10.f12912H0 = r0
            r10.f12913I0 = r0
            r10.q2()
            goto L_0x0097
        L_0x0078:
            if (r5 == 0) goto L_0x007e
            r10.C2()
            goto L_0x0097
        L_0x007e:
            androidx.fragment.app.s r0 = r10.getActivity()
            if (r0 == 0) goto L_0x0097
            r3 = 2131886648(0x7f120238, float:1.940788E38)
            java.lang.String r3 = r10.getString(r3)
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r3, r1)
            r1 = 17
            r0.setGravity(r1, r2, r2)
            r0.show()
        L_0x0097:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.FragmentOfficial.E2():void");
    }

    /* access modifiers changed from: private */
    public void F2() {
        Date date;
        try {
            date = this.f12932b1.parse(this.f12916L0);
        } catch (ParseException e8) {
            if (e8.getMessage() != null) {
                Log.d("EQN", e8.getMessage());
            }
            date = null;
        }
        boolean z7 = false;
        int i8 = 0;
        for (int i9 = 0; i9 < this.f12927W0.j(); i9++) {
            i iVar = (i) this.f12927W0.E(i9);
            try {
                Date parse = this.f12932b1.parse(iVar.f13035j);
                if (parse != null && date != null && Math.abs(parse.getTime() - date.getTime()) <= 120000 && iVar.f13029d / ((double) this.f12917M0) > 0.8d && iVar.f13029d / ((double) this.f12917M0) < 1.2d && Math.abs(iVar.f13027b - ((double) this.f12918N0)) < 1.0d && Math.abs(iVar.f13028c - ((double) this.f12919O0)) < 1.0d) {
                    z7 = true;
                    i8 = i9;
                }
            } catch (ParseException e9) {
                if (e9.getMessage() != null) {
                    Log.d("EQN", e9.getMessage());
                }
            }
        }
        if (z7) {
            this.f12921Q0 = i8;
        } else {
            this.f12920P0 = 0;
        }
        if (this.f12928X0.getLayoutManager() != null) {
            this.f12928X0.getLayoutManager().B1(this.f12921Q0);
        }
        this.f12927W0.o();
    }

    /* access modifiers changed from: private */
    public void G2(int i8, double d8, double d9, boolean z7) {
        int[] iArr;
        C0891s activity = getActivity();
        if (activity != null && this.f12946o0 != null) {
            int i9 = this.f12909E0;
            double[] dArr = new double[i9];
            double[] dArr2 = new double[i9];
            double[] dArr3 = new double[i9];
            String[] strArr = new String[i9];
            double[] dArr4 = new double[i9];
            String[] strArr2 = new String[i9];
            String[] strArr3 = new String[i9];
            int[] iArr2 = new int[i9];
            String[] strArr4 = new String[i9];
            double[] dArr5 = new double[i9];
            int[] iArr3 = new int[i9];
            int i10 = 0;
            int i11 = 0;
            while (true) {
                double[] dArr6 = this.f12946o0;
                iArr = iArr3;
                if (i11 >= dArr6.length) {
                    break;
                }
                boolean[] zArr = this.f12908D0;
                if (zArr[i11] && i10 < zArr.length) {
                    dArr[i10] = dArr6[i11];
                    dArr2[i10] = this.f12948p0[i11];
                    dArr3[i10] = this.f12950q0[i11];
                    strArr[i10] = this.f12952r0[i11];
                    dArr4[i10] = this.f12956t0[i11];
                    strArr2[i10] = this.f12964x0[i11];
                    strArr3[i10] = this.f12958u0[i11];
                    iArr2[i10] = this.f12960v0[i11];
                    strArr4[i10] = this.f12962w0[i11];
                    dArr5[i10] = this.f12965y0[i11];
                    iArr[i10] = this.f12966z0[i11];
                    i10++;
                }
                i11++;
                iArr3 = iArr;
            }
            Intent intent = new Intent().setClass(activity, GlobeActivityAll.class);
            intent.putExtra("com.finazzi.distquake.map_type", 2);
            intent.putExtra("com.finazzi.distquake.map_lat", d8);
            intent.putExtra("com.finazzi.distquake.map_lon", d9);
            intent.putExtra("com.finazzi.distquake.simulate_wave", z7);
            intent.putExtra("com.finazzi.distquake.shakemap", this.f12963w1);
            intent.putExtra("com.finazzi.distquake.latitude_vector", dArr);
            intent.putExtra("com.finazzi.distquake.longitude_vector", dArr2);
            intent.putExtra("com.finazzi.distquake.magnitude_vector", dArr3);
            intent.putExtra("com.finazzi.distquake.magnitude_type_vector", strArr);
            intent.putExtra("com.finazzi.distquake.depth_vector", dArr4);
            intent.putExtra("com.finazzi.distquake.date_vector", strArr2);
            intent.putExtra("com.finazzi.distquake.location_vector", strArr3);
            intent.putExtra("com.finazzi.distquake.pop100_vector", iArr2);
            intent.putExtra("com.finazzi.distquake.provider_vector", strArr4);
            intent.putExtra("com.finazzi.distquake.magnitude_range_vector", dArr5);
            intent.putExtra("com.finazzi.distquake.preliminary_vector", iArr);
            if (i8 >= 0) {
                List list = this.f12926V0;
                if (list != null) {
                    i iVar = (i) list.get(i8);
                    if (iVar != null) {
                        intent.putExtra("com.finazzi.distquake.list_position", iVar.c0());
                    } else {
                        intent.putExtra("com.finazzi.distquake.list_position", -1);
                    }
                } else {
                    intent.putExtra("com.finazzi.distquake.list_position", -1);
                }
            } else {
                intent.putExtra("com.finazzi.distquake.list_position", i8);
            }
            ((ProgressBar) this.f12944n0.findViewById(C2030R.id.progressBar1)).setVisibility(0);
            startActivityForResult(intent, 2);
        }
    }

    /* access modifiers changed from: private */
    public void H2(int i8, h.a aVar) {
        double d8;
        double d9;
        int i9;
        int i10;
        int i11;
        int round;
        int round2;
        long round3;
        long round4;
        int i12 = i8;
        h.a aVar2 = aVar;
        String str = this.f12937g1;
        str.getClass();
        char c8 = 65535;
        switch (str.hashCode()) {
            case 48:
                if (str.equals("0")) {
                    c8 = 0;
                    break;
                }
                break;
            case 49:
                if (str.equals("1")) {
                    c8 = 1;
                    break;
                }
                break;
            case 50:
                if (str.equals("2")) {
                    c8 = 2;
                    break;
                }
                break;
            case 1444:
                if (str.equals("-1")) {
                    c8 = 3;
                    break;
                }
                break;
            case 1445:
                if (str.equals("-2")) {
                    c8 = 4;
                    break;
                }
                break;
        }
        switch (c8) {
            case 0:
                aVar2.f12986F.setTextSize(2, 22.0f);
                aVar2.f12987G.setTextSize(2, 36.0f);
                aVar2.f12988H.setTextSize(2, 16.0f);
                aVar2.f12989I.setTextSize(2, 16.0f);
                aVar2.f12990J.setTextSize(2, 16.0f);
                aVar2.f12991K.setTextSize(2, 16.0f);
                break;
            case 1:
                aVar2.f12986F.setTextSize(2, 24.0f);
                aVar2.f12987G.setTextSize(2, 38.0f);
                aVar2.f12988H.setTextSize(2, 18.0f);
                aVar2.f12989I.setTextSize(2, 18.0f);
                aVar2.f12990J.setTextSize(2, 18.0f);
                aVar2.f12991K.setTextSize(2, 18.0f);
                break;
            case 2:
                aVar2.f12986F.setTextSize(2, 26.0f);
                aVar2.f12987G.setTextSize(2, 40.0f);
                aVar2.f12988H.setTextSize(2, 20.0f);
                aVar2.f12989I.setTextSize(2, 20.0f);
                aVar2.f12990J.setTextSize(2, 20.0f);
                aVar2.f12991K.setTextSize(2, 20.0f);
                break;
            case 3:
                aVar2.f12986F.setTextSize(2, 20.0f);
                aVar2.f12987G.setTextSize(2, 34.0f);
                aVar2.f12988H.setTextSize(2, 14.0f);
                aVar2.f12989I.setTextSize(2, 14.0f);
                aVar2.f12990J.setTextSize(2, 14.0f);
                aVar2.f12991K.setTextSize(2, 14.0f);
                break;
            case 4:
                aVar2.f12986F.setTextSize(2, 18.0f);
                aVar2.f12987G.setTextSize(2, 34.0f);
                aVar2.f12988H.setTextSize(2, 12.0f);
                aVar2.f12989I.setTextSize(2, 12.0f);
                aVar2.f12990J.setTextSize(2, 12.0f);
                break;
        }
        aVar2.f12986F.setText(((i) this.f12926V0.get(i12)).X().trim());
        aVar2.f12987G.setText(Double.toString(((i) this.f12926V0.get(i12)).Z()));
        if (((i) this.f12926V0.get(i12)).i0() > 0 || ((i) this.f12926V0.get(i12)).g0() > 1 || ((i) this.f12926V0.get(i12)).f13044s > 0) {
            aVar2.f12995O.setVisibility(0);
            if (((i) this.f12926V0.get(i12)).i0() > 0) {
                aVar2.f12990J.setText(String.format(getString(C2030R.string.official_smartphones), new Object[]{Integer.toString(((i) this.f12926V0.get(i12)).i0())}));
                aVar2.f12990J.setVisibility(0);
            } else {
                aVar2.f12990J.setVisibility(8);
            }
            if (((i) this.f12926V0.get(i12)).g0() > 1) {
                aVar2.f12991K.setText(String.format(getString(C2030R.string.official_reports), new Object[]{Integer.toString(((i) this.f12926V0.get(i12)).g0())}));
                aVar2.f12991K.setVisibility(0);
            } else {
                aVar2.f12991K.setVisibility(8);
            }
            if (((i) this.f12926V0.get(i12)).V() > 0) {
                aVar2.f12992L.setVisibility(0);
            } else {
                aVar2.f12992L.setVisibility(8);
            }
        } else {
            aVar2.f12995O.setVisibility(8);
        }
        int i13 = 255;
        if (this.f12941k1) {
            int i14 = getResources().getConfiguration().uiMode & 48;
            C0891s activity = getActivity();
            if (activity != null) {
                aVar2.f12987G.setTextColor(getResources().getColor(C2030R.color.md_theme_primary, activity.getTheme()));
                aVar2.f12993M.setBackgroundColor(getResources().getColor(C2030R.color.md_theme_primary, activity.getTheme()));
                if (this.f12920P0 == 1 && i12 == this.f12921Q0) {
                    aVar2.f12986F.setTextColor(-65536);
                } else {
                    aVar2.f12986F.setTextColor(getResources().getColor(C2030R.color.md_theme_primary, activity.getTheme()));
                }
            }
            if (((i) this.f12926V0.get(i12)).Z() < 2.0d) {
                double z7 = 1.0d - ((((i) this.f12926V0.get(i12)).Z() - 0.0d) / 2.0d);
                if (i14 == 16) {
                    d8 = 21.0d;
                    i11 = (int) Math.round((33.0d * z7) + 179.0d);
                    i10 = (int) Math.round((19.0d * z7) + 210.0d);
                    d9 = 1.0d;
                    round4 = Math.round((z7 * 13.0d) + 223.0d);
                } else {
                    d9 = 1.0d;
                    d8 = 21.0d;
                    i11 = (int) Math.round((z7 * 21.0d) + 49.0d);
                    i10 = (int) Math.round((32.0d * z7) + 73.0d);
                    round4 = Math.round((z7 * 43.0d) + 97.0d);
                }
                i9 = (int) round4;
            } else {
                d9 = 1.0d;
                d8 = 21.0d;
                i11 = 0;
                i10 = 0;
                i9 = 0;
            }
            if (((i) this.f12926V0.get(i12)).Z() >= 2.0d && ((i) this.f12926V0.get(i12)).Z() < 3.5d) {
                double z8 = d9 - ((((i) this.f12926V0.get(i12)).Z() - 2.0d) / 1.5d);
                if (i14 == 16) {
                    round = (int) Math.round((z8 * 64.0d) + 136.0d);
                    round2 = (int) Math.round((51.0d * z8) + 175.0d);
                    round3 = Math.round((z8 * 65.0d) + 131.0d);
                } else {
                    round = (int) Math.round((z8 * d8) + 28.0d);
                    round2 = (int) Math.round((46.0d * z8) + 65.0d);
                    round3 = Math.round((z8 * 16.0d) + d8);
                }
                i9 = (int) round3;
            }
            if (((i) this.f12926V0.get(i12)).Z() >= 3.5d && ((i) this.f12926V0.get(i12)).Z() < 4.5d) {
                double z9 = d9 - ((((i) this.f12926V0.get(i12)).Z() - 3.5d) / d9);
                if (i14 == 16) {
                    i10 = (int) Math.round((20.0d * z9) + 233.0d);
                    i9 = (int) Math.round((z9 * 30.0d) + 179.0d);
                    i11 = 252;
                } else {
                    i11 = (int) Math.round((57.0d * z9) + 132.0d);
                    i10 = (int) Math.round((43.0d * z9) + 101.0d);
                    i9 = (int) Math.round((z9 * 3.0d) + 6.0d);
                }
            }
            if (((i) this.f12926V0.get(i12)).Z() >= 4.5d && ((i) this.f12926V0.get(i12)).Z() < 5.5d) {
                double z10 = d9 - ((((i) this.f12926V0.get(i12)).Z() - 4.5d) / d9);
                if (i14 == 16) {
                    i10 = (int) Math.round((38.0d * z10) + 159.0d);
                    i9 = (int) Math.round((z10 * 36.0d) + 161.0d);
                    i11 = 252;
                } else {
                    i11 = (int) Math.round((61.0d * z10) + 111.0d);
                    i10 = (int) Math.round((z10 * d9) + d9);
                    i9 = (int) Math.round((z10 * 12.0d) + d8);
                }
            }
            if (((i) this.f12926V0.get(i12)).Z() >= 5.5d) {
                double z11 = d9 - ((((i) this.f12926V0.get(i12)).Z() - 5.5d) / 4.5d);
                if (i14 == 16) {
                    i11 = (int) Math.round((z11 * 64.0d) + 190.0d);
                    i10 = (int) Math.round((z11 * 95.0d) + 124.0d);
                    i9 = 255;
                } else {
                    double d10 = (81.0d * z11) + 115.0d;
                    i11 = (int) Math.round(d10);
                    i10 = (int) Math.round((z11 * 2.0d) + 3.0d);
                    i9 = (int) Math.round(d10);
                }
            }
            int i15 = i11 + 20;
            int i16 = i10 + 20;
            int i17 = i9 + 20;
            if (i15 > 255) {
                i15 = 255;
            }
            if (i16 > 255) {
                i16 = 255;
            }
            if (i17 <= 255) {
                i13 = i17;
            }
            int[] iArr = {Color.rgb(i11, i10, i9), Color.rgb(i15, i16, i13)};
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setGradientType(0);
            gradientDrawable.setOrientation(GradientDrawable.Orientation.TL_BR);
            gradientDrawable.setColors(iArr);
            gradientDrawable.setCornerRadius(10.0f);
            aVar2.f12994N.setBackground(gradientDrawable);
            aVar2.f12994N.setElevation(3.0f);
            float applyDimension = TypedValue.applyDimension(1, 1.0f, getResources().getDisplayMetrics());
            ViewGroup.LayoutParams layoutParams = aVar2.f12993M.getLayoutParams();
            layoutParams.height = Math.round(applyDimension);
            aVar2.f12993M.setLayoutParams(layoutParams);
        } else {
            if (((i) this.f12926V0.get(i12)).Z() < 2.0d) {
                aVar2.f12987G.setTextColor(Color.rgb(12, 115, 160));
                aVar2.f12993M.setBackgroundColor(Color.rgb(12, 115, 160));
            }
            if (((i) this.f12926V0.get(i12)).Z() >= 2.0d && ((i) this.f12926V0.get(i12)).Z() < 3.5d) {
                aVar2.f12987G.setTextColor(Color.rgb(12, 160, 35));
                aVar2.f12993M.setBackgroundColor(Color.rgb(12, 160, 35));
            }
            if (((i) this.f12926V0.get(i12)).Z() >= 3.5d && ((i) this.f12926V0.get(i12)).Z() < 4.5d) {
                aVar2.f12987G.setTextColor(Color.rgb(244, 195, 0));
                aVar2.f12993M.setBackgroundColor(Color.rgb(244, 195, 0));
            }
            if (((i) this.f12926V0.get(i12)).Z() >= 4.5d && ((i) this.f12926V0.get(i12)).Z() < 5.5d) {
                aVar2.f12987G.setTextColor(Color.rgb(255, 0, 0));
                aVar2.f12993M.setBackgroundColor(Color.rgb(255, 0, 0));
            }
            if (((i) this.f12926V0.get(i12)).Z() >= 5.5d) {
                aVar2.f12987G.setTextColor(Color.rgb(183, 60, 252));
                aVar2.f12993M.setBackgroundColor(Color.rgb(183, 60, 252));
            }
            float applyDimension2 = TypedValue.applyDimension(1, 4.0f, getResources().getDisplayMetrics());
            ViewGroup.LayoutParams layoutParams2 = aVar2.f12993M.getLayoutParams();
            layoutParams2.height = Math.round(applyDimension2);
            aVar2.f12993M.setLayoutParams(layoutParams2);
            C0891s activity2 = getActivity();
            if (activity2 != null) {
                if (this.f12920P0 == 1 && i12 == this.f12921Q0) {
                    aVar2.f12986F.setTextColor(-65536);
                } else {
                    aVar2.f12986F.setTextColor(getResources().getColor(C2030R.color.md_theme_secondary, activity2.getTheme()));
                }
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setColor(getResources().getColor(C2030R.color.md_theme_surfaceContainerLow, activity2.getTheme()));
                gradientDrawable2.setCornerRadius(10.0f);
                aVar2.f12994N.setBackground(gradientDrawable2);
                aVar2.f12994N.setElevation(3.0f);
            }
        }
        aVar2.f12988H.setText(u2(((i) this.f12926V0.get(i12)).S()));
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols(Locale.getDefault());
        decimalFormatSymbols.setDecimalSeparator('.');
        decimalFormatSymbols.setGroupingSeparator(',');
        long round5 = Math.round(z2(this.f12910F0, this.f12911G0, ((i) this.f12926V0.get(i12)).W(), ((i) this.f12926V0.get(i12)).Y()));
        if (B2()) {
            if (this.f12929Y0.equals("1")) {
                round5 = (long) (((double) round5) * 0.621371192d);
                aVar2.f12989I.setText(((int) round5) + " mi");
            } else {
                aVar2.f12989I.setText(((int) round5) + " km");
            }
            if (round5 < 100) {
                aVar2.f12989I.setTypeface(Typeface.DEFAULT_BOLD);
            } else {
                aVar2.f12989I.setTypeface(Typeface.DEFAULT);
            }
            aVar2.f12989I.setVisibility(0);
            return;
        }
        aVar2.f12989I.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x004d, code lost:
        r30 = r2;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void I2(int r40, com.finazzi.distquake.FragmentOfficial.h.b r41) {
        /*
            r39 = this;
            r0 = r39
            r9 = r40
            r10 = r41
            r6 = 1102053376(0x41b00000, float:22.0)
            r7 = 1105199104(0x41e00000, float:28.0)
            r8 = 1104150528(0x41d00000, float:26.0)
            java.lang.String r11 = "0"
            r16 = 0
            r20 = 4633641066610819072(0x404e000000000000, double:60.0)
            r22 = 4626604192193052672(0x4035000000000000, double:21.0)
            java.lang.String r14 = "1"
            android.widget.Button r4 = r10.f13016Y
            r12 = 2131886873(0x7f120319, float:1.9408337E38)
            r4.setText(r12)
            java.lang.String r4 = r0.f12937g1
            r4.getClass()
            r12 = 1099956224(0x41900000, float:18.0)
            r13 = 1092616192(0x41200000, float:10.0)
            r1 = 1101004800(0x41a00000, float:20.0)
            r15 = 1094713344(0x41400000, float:12.0)
            r3 = 1098907648(0x41800000, float:16.0)
            r5 = 2
            r30 = -1
            int r31 = r4.hashCode()
            switch(r31) {
                case 48: goto L_0x0066;
                case 49: goto L_0x005c;
                case 50: goto L_0x0050;
                case 1444: goto L_0x0043;
                case 1445: goto L_0x0038;
                default: goto L_0x0037;
            }
        L_0x0037:
            goto L_0x006f
        L_0x0038:
            java.lang.String r2 = "-2"
            boolean r2 = r4.equals(r2)
            if (r2 != 0) goto L_0x0041
            goto L_0x006f
        L_0x0041:
            r2 = 4
            goto L_0x004d
        L_0x0043:
            java.lang.String r2 = "-1"
            boolean r2 = r4.equals(r2)
            if (r2 != 0) goto L_0x004c
            goto L_0x006f
        L_0x004c:
            r2 = 3
        L_0x004d:
            r30 = r2
            goto L_0x006f
        L_0x0050:
            java.lang.String r2 = "2"
            boolean r2 = r4.equals(r2)
            if (r2 != 0) goto L_0x0059
            goto L_0x006f
        L_0x0059:
            r30 = r5
            goto L_0x006f
        L_0x005c:
            boolean r2 = r4.equals(r14)
            if (r2 != 0) goto L_0x0063
            goto L_0x006f
        L_0x0063:
            r30 = 1
            goto L_0x006f
        L_0x0066:
            boolean r2 = r4.equals(r11)
            if (r2 != 0) goto L_0x006d
            goto L_0x006f
        L_0x006d:
            r30 = 0
        L_0x006f:
            switch(r30) {
                case 0: goto L_0x01db;
                case 1: goto L_0x0181;
                case 2: goto L_0x0126;
                case 3: goto L_0x00cd;
                case 4: goto L_0x0074;
                default: goto L_0x0072;
            }
        L_0x0072:
            goto L_0x0236
        L_0x0074:
            android.widget.TextView r2 = r10.f12997F
            r2.setTextSize(r5, r3)
            android.widget.TextView r2 = r10.f12998G
            r3 = 1090519040(0x41000000, float:8.0)
            r2.setTextSize(r5, r3)
            android.widget.TextView r2 = r10.f12999H
            r2.setTextSize(r5, r8)
            android.widget.TextView r2 = r10.f13000I
            r2.setTextSize(r5, r1)
            android.widget.TextView r1 = r10.f13004M
            r1.setTextSize(r5, r15)
            android.widget.TextView r1 = r10.f13001J
            r1.setTextSize(r5, r15)
            android.widget.TextView r1 = r10.f13002K
            r1.setTextSize(r5, r15)
            android.widget.TextView r1 = r10.f13003L
            r1.setTextSize(r5, r15)
            android.widget.TextView r1 = r10.f13005N
            r1.setTextSize(r5, r15)
            android.widget.TextView r1 = r10.f13007P
            r1.setTextSize(r5, r15)
            android.widget.TextView r1 = r10.f13008Q
            r1.setTextSize(r5, r15)
            android.widget.Button r1 = r10.f13012U
            r1.setTextSize(r5, r13)
            android.widget.Button r1 = r10.f13013V
            r1.setTextSize(r5, r13)
            android.widget.Button r1 = r10.f13017Z
            r1.setTextSize(r5, r13)
            android.widget.Button r1 = r10.f13014W
            r1.setTextSize(r5, r13)
            android.widget.Button r1 = r10.f13015X
            r1.setTextSize(r5, r13)
            android.widget.Button r1 = r10.f13016Y
            r1.setTextSize(r5, r13)
            goto L_0x0236
        L_0x00cd:
            android.widget.TextView r1 = r10.f12997F
            r1.setTextSize(r5, r12)
            android.widget.TextView r1 = r10.f12998G
            r1.setTextSize(r5, r13)
            android.widget.TextView r1 = r10.f12999H
            r1.setTextSize(r5, r7)
            android.widget.TextView r1 = r10.f13000I
            r1.setTextSize(r5, r6)
            android.widget.TextView r1 = r10.f13004M
            r2 = 1096810496(0x41600000, float:14.0)
            r1.setTextSize(r5, r2)
            android.widget.TextView r1 = r10.f13001J
            r1.setTextSize(r5, r2)
            android.widget.TextView r1 = r10.f13002K
            r1.setTextSize(r5, r2)
            android.widget.TextView r1 = r10.f13003L
            r1.setTextSize(r5, r2)
            android.widget.TextView r1 = r10.f13005N
            r1.setTextSize(r5, r2)
            android.widget.TextView r1 = r10.f13007P
            r1.setTextSize(r5, r2)
            android.widget.TextView r1 = r10.f13008Q
            r1.setTextSize(r5, r2)
            android.widget.Button r1 = r10.f13012U
            r1.setTextSize(r5, r15)
            android.widget.Button r1 = r10.f13017Z
            r1.setTextSize(r5, r15)
            android.widget.Button r1 = r10.f13013V
            r1.setTextSize(r5, r15)
            android.widget.Button r1 = r10.f13014W
            r1.setTextSize(r5, r15)
            android.widget.Button r1 = r10.f13015X
            r1.setTextSize(r5, r15)
            android.widget.Button r1 = r10.f13016Y
            r1.setTextSize(r5, r15)
            goto L_0x0236
        L_0x0126:
            android.widget.TextView r2 = r10.f12997F
            r4 = 1103101952(0x41c00000, float:24.0)
            r2.setTextSize(r5, r4)
            android.widget.TextView r2 = r10.f12998G
            r2.setTextSize(r5, r3)
            android.widget.TextView r2 = r10.f12999H
            r4 = 1107820544(0x42080000, float:34.0)
            r2.setTextSize(r5, r4)
            android.widget.TextView r2 = r10.f13000I
            r2.setTextSize(r5, r7)
            android.widget.TextView r2 = r10.f13004M
            r2.setTextSize(r5, r1)
            android.widget.TextView r2 = r10.f13001J
            r2.setTextSize(r5, r1)
            android.widget.TextView r2 = r10.f13002K
            r2.setTextSize(r5, r1)
            android.widget.TextView r2 = r10.f13003L
            r2.setTextSize(r5, r1)
            android.widget.TextView r2 = r10.f13005N
            r2.setTextSize(r5, r1)
            android.widget.TextView r2 = r10.f13007P
            r2.setTextSize(r5, r1)
            android.widget.TextView r2 = r10.f13008Q
            r2.setTextSize(r5, r1)
            android.widget.Button r1 = r10.f13012U
            r1.setTextSize(r5, r3)
            android.widget.Button r1 = r10.f13013V
            r1.setTextSize(r5, r3)
            android.widget.Button r1 = r10.f13017Z
            r1.setTextSize(r5, r3)
            android.widget.Button r1 = r10.f13014W
            r1.setTextSize(r5, r3)
            android.widget.Button r1 = r10.f13015X
            r1.setTextSize(r5, r3)
            android.widget.Button r1 = r10.f13016Y
            r1.setTextSize(r5, r12)
            goto L_0x0236
        L_0x0181:
            android.widget.TextView r1 = r10.f12997F
            r1.setTextSize(r5, r6)
            android.widget.TextView r1 = r10.f12998G
            r2 = 1096810496(0x41600000, float:14.0)
            r1.setTextSize(r5, r2)
            android.widget.TextView r1 = r10.f12999H
            r2 = 1107296256(0x42000000, float:32.0)
            r1.setTextSize(r5, r2)
            android.widget.TextView r1 = r10.f13000I
            r1.setTextSize(r5, r8)
            android.widget.TextView r1 = r10.f13004M
            r1.setTextSize(r5, r12)
            android.widget.TextView r1 = r10.f13001J
            r1.setTextSize(r5, r12)
            android.widget.TextView r1 = r10.f13002K
            r1.setTextSize(r5, r12)
            android.widget.TextView r1 = r10.f13003L
            r1.setTextSize(r5, r12)
            android.widget.TextView r1 = r10.f13005N
            r1.setTextSize(r5, r12)
            android.widget.TextView r1 = r10.f13007P
            r1.setTextSize(r5, r12)
            android.widget.TextView r1 = r10.f13008Q
            r1.setTextSize(r5, r12)
            android.widget.Button r1 = r10.f13012U
            r1.setTextSize(r5, r3)
            android.widget.Button r1 = r10.f13013V
            r1.setTextSize(r5, r3)
            android.widget.Button r1 = r10.f13017Z
            r1.setTextSize(r5, r3)
            android.widget.Button r1 = r10.f13014W
            r1.setTextSize(r5, r3)
            android.widget.Button r1 = r10.f13015X
            r1.setTextSize(r5, r3)
            android.widget.Button r1 = r10.f13016Y
            r1.setTextSize(r5, r3)
            goto L_0x0236
        L_0x01db:
            android.widget.TextView r2 = r10.f12997F
            r2.setTextSize(r5, r1)
            android.widget.TextView r1 = r10.f12998G
            r1.setTextSize(r5, r15)
            android.widget.TextView r1 = r10.f12999H
            r2 = 1106247680(0x41f00000, float:30.0)
            r1.setTextSize(r5, r2)
            android.widget.TextView r1 = r10.f13000I
            r4 = 1103101952(0x41c00000, float:24.0)
            r1.setTextSize(r5, r4)
            android.widget.TextView r1 = r10.f13004M
            r1.setTextSize(r5, r3)
            android.widget.TextView r1 = r10.f13001J
            r1.setTextSize(r5, r3)
            android.widget.TextView r1 = r10.f13002K
            r1.setTextSize(r5, r3)
            android.widget.TextView r1 = r10.f13003L
            r1.setTextSize(r5, r3)
            android.widget.TextView r1 = r10.f13005N
            r1.setTextSize(r5, r3)
            android.widget.TextView r1 = r10.f13007P
            r1.setTextSize(r5, r3)
            android.widget.TextView r1 = r10.f13008Q
            r1.setTextSize(r5, r3)
            android.widget.Button r1 = r10.f13012U
            r2 = 1096810496(0x41600000, float:14.0)
            r1.setTextSize(r5, r2)
            android.widget.Button r1 = r10.f13017Z
            r1.setTextSize(r5, r2)
            android.widget.Button r1 = r10.f13013V
            r1.setTextSize(r5, r2)
            android.widget.Button r1 = r10.f13014W
            r1.setTextSize(r5, r2)
            android.widget.Button r1 = r10.f13015X
            r1.setTextSize(r5, r2)
            android.widget.Button r1 = r10.f13016Y
            r1.setTextSize(r5, r2)
        L_0x0236:
            int r1 = r0.f12935e1
            r12 = 8
            if (r1 != 0) goto L_0x0243
            android.widget.LinearLayout r1 = r10.f13021d0
            r1.setVisibility(r12)
            r2 = 0
            goto L_0x0249
        L_0x0243:
            android.widget.LinearLayout r1 = r10.f13021d0
            r2 = 0
            r1.setVisibility(r2)
        L_0x0249:
            boolean r1 = r0.f12938h1
            if (r1 == 0) goto L_0x0253
            android.widget.TextView r1 = r10.f13002K
            r1.setVisibility(r2)
            goto L_0x0258
        L_0x0253:
            android.widget.TextView r1 = r10.f13002K
            r1.setVisibility(r12)
        L_0x0258:
            boolean r1 = r0.f12939i1
            if (r1 == 0) goto L_0x0262
            android.widget.TextView r1 = r10.f13003L
            r1.setVisibility(r2)
            goto L_0x0267
        L_0x0262:
            android.widget.TextView r1 = r10.f13003L
            r1.setVisibility(r12)
        L_0x0267:
            boolean r1 = r0.f12940j1
            if (r1 == 0) goto L_0x0271
            android.widget.TextView r1 = r10.f13005N
            r1.setVisibility(r2)
            goto L_0x0276
        L_0x0271:
            android.widget.TextView r1 = r10.f13005N
            r1.setVisibility(r12)
        L_0x0276:
            android.widget.TextView r1 = r10.f12997F
            java.util.List r2 = r0.f12926V0
            java.lang.Object r2 = r2.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r2 = (com.finazzi.distquake.FragmentOfficial.i) r2
            java.lang.String r2 = r2.X()
            java.lang.String r2 = r2.trim()
            r1.setText(r2)
            int r1 = r0.f12920P0
            r2 = 1
            if (r1 != r2) goto L_0x029f
            int r1 = r0.f12921Q0
            if (r9 != r1) goto L_0x029f
            java.util.List r1 = r0.f12926V0
            java.lang.Object r1 = r1.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r1 = (com.finazzi.distquake.FragmentOfficial.i) r1
            r1.z0(r2)
        L_0x029f:
            java.util.List r1 = r0.f12926V0
            java.lang.Object r1 = r1.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r1 = (com.finazzi.distquake.FragmentOfficial.i) r1
            int r1 = r1.e0()
            r3 = 4611686018427387904(0x4000000000000000, double:2.0)
            if (r1 != r2) goto L_0x0356
            android.widget.TextView r1 = r10.f13006O
            r2 = 0
            r1.setVisibility(r2)
            java.util.List r1 = r0.f12926V0
            java.lang.Object r1 = r1.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r1 = (com.finazzi.distquake.FragmentOfficial.i) r1
            double r1 = r1.a0()
            int r1 = (r1 > r16 ? 1 : (r1 == r16 ? 0 : -1))
            if (r1 <= 0) goto L_0x0339
            java.util.List r1 = r0.f12926V0
            java.lang.Object r1 = r1.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r1 = (com.finazzi.distquake.FragmentOfficial.i) r1
            double r1 = r1.Z()
            java.util.List r6 = r0.f12926V0
            java.lang.Object r6 = r6.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r6 = (com.finazzi.distquake.FragmentOfficial.i) r6
            double r6 = r6.a0()
            double r6 = r6 / r3
            double r1 = r1 - r6
            java.util.List r6 = r0.f12926V0
            java.lang.Object r6 = r6.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r6 = (com.finazzi.distquake.FragmentOfficial.i) r6
            double r6 = r6.Z()
            java.util.List r8 = r0.f12926V0
            java.lang.Object r8 = r8.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r8 = (com.finazzi.distquake.FragmentOfficial.i) r8
            double r29 = r8.a0()
            double r29 = r29 / r3
            double r6 = r6 + r29
            java.text.DecimalFormatSymbols r8 = new java.text.DecimalFormatSymbols
            java.util.Locale r15 = java.util.Locale.getDefault()
            r8.<init>(r15)
            r15 = 46
            r8.setDecimalSeparator(r15)
            r15 = 44
            r8.setGroupingSeparator(r15)
            java.text.DecimalFormat r15 = new java.text.DecimalFormat
            r29 = r3
            java.lang.String r3 = "0.0"
            r15.<init>(r3, r8)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r1 = r15.format(r1)
            r3.append(r1)
            java.lang.String r1 = "-"
            r3.append(r1)
            java.lang.String r1 = r15.format(r6)
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            android.widget.TextView r2 = r10.f12999H
            r2.setText(r1)
            goto L_0x0350
        L_0x0339:
            r29 = r3
            java.util.List r1 = r0.f12926V0
            java.lang.Object r1 = r1.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r1 = (com.finazzi.distquake.FragmentOfficial.i) r1
            double r1 = r1.Z()
            java.lang.String r1 = java.lang.Double.toString(r1)
            android.widget.TextView r2 = r10.f12999H
            r2.setText(r1)
        L_0x0350:
            android.widget.TextView r1 = r10.f13004M
            r1.setVisibility(r12)
            goto L_0x0378
        L_0x0356:
            r29 = r3
            android.widget.TextView r1 = r10.f13006O
            r1.setVisibility(r12)
            java.util.List r1 = r0.f12926V0
            java.lang.Object r1 = r1.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r1 = (com.finazzi.distquake.FragmentOfficial.i) r1
            double r1 = r1.Z()
            java.lang.String r1 = java.lang.Double.toString(r1)
            android.widget.TextView r2 = r10.f12999H
            r2.setText(r1)
            android.widget.TextView r1 = r10.f13004M
            r2 = 0
            r1.setVisibility(r2)
        L_0x0378:
            java.util.List r1 = r0.f12926V0
            java.lang.Object r1 = r1.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r1 = (com.finazzi.distquake.FragmentOfficial.i) r1
            int r1 = r1.i0()
            if (r1 > 0) goto L_0x03ab
            java.util.List r1 = r0.f12926V0
            java.lang.Object r1 = r1.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r1 = (com.finazzi.distquake.FragmentOfficial.i) r1
            int r1 = r1.g0()
            r2 = 1
            if (r1 > r2) goto L_0x03ab
            java.util.List r1 = r0.f12926V0
            java.lang.Object r1 = r1.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r1 = (com.finazzi.distquake.FragmentOfficial.i) r1
            int r1 = r1.f13044s
            if (r1 <= 0) goto L_0x03a4
            goto L_0x03ab
        L_0x03a4:
            android.widget.LinearLayout r1 = r10.f13023f0
            r1.setVisibility(r12)
            goto L_0x0449
        L_0x03ab:
            android.widget.LinearLayout r1 = r10.f13023f0
            r2 = 0
            r1.setVisibility(r2)
            java.util.List r1 = r0.f12926V0
            java.lang.Object r1 = r1.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r1 = (com.finazzi.distquake.FragmentOfficial.i) r1
            int r1 = r1.i0()
            if (r1 <= 0) goto L_0x03eb
            android.widget.TextView r1 = r10.f13007P
            r2 = 2131886894(0x7f12032e, float:1.940838E38)
            java.lang.String r2 = r0.getString(r2)
            java.util.List r3 = r0.f12926V0
            java.lang.Object r3 = r3.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r3 = (com.finazzi.distquake.FragmentOfficial.i) r3
            int r3 = r3.i0()
            java.lang.String r3 = java.lang.Integer.toString(r3)
            r4 = 1
            java.lang.Object[] r6 = new java.lang.Object[r4]
            r4 = 0
            r6[r4] = r3
            java.lang.String r2 = java.lang.String.format(r2, r6)
            r1.setText(r2)
            android.widget.TextView r1 = r10.f13007P
            r1.setVisibility(r4)
            goto L_0x03f0
        L_0x03eb:
            android.widget.TextView r1 = r10.f13007P
            r1.setVisibility(r12)
        L_0x03f0:
            java.util.List r1 = r0.f12926V0
            java.lang.Object r1 = r1.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r1 = (com.finazzi.distquake.FragmentOfficial.i) r1
            int r1 = r1.g0()
            r2 = 1
            if (r1 <= r2) goto L_0x042a
            android.widget.TextView r1 = r10.f13008Q
            r3 = 2131886886(0x7f120326, float:1.9408364E38)
            java.lang.String r3 = r0.getString(r3)
            java.util.List r4 = r0.f12926V0
            java.lang.Object r4 = r4.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r4 = (com.finazzi.distquake.FragmentOfficial.i) r4
            int r4 = r4.g0()
            java.lang.String r4 = java.lang.Integer.toString(r4)
            java.lang.Object[] r6 = new java.lang.Object[r2]
            r2 = 0
            r6[r2] = r4
            java.lang.String r3 = java.lang.String.format(r3, r6)
            r1.setText(r3)
            android.widget.TextView r1 = r10.f13008Q
            r1.setVisibility(r2)
            goto L_0x0430
        L_0x042a:
            r2 = 0
            android.widget.TextView r1 = r10.f13008Q
            r1.setVisibility(r12)
        L_0x0430:
            java.util.List r1 = r0.f12926V0
            java.lang.Object r1 = r1.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r1 = (com.finazzi.distquake.FragmentOfficial.i) r1
            int r1 = r1.V()
            if (r1 <= 0) goto L_0x0444
            android.widget.Button r1 = r10.f13018a0
            r1.setVisibility(r2)
            goto L_0x0449
        L_0x0444:
            android.widget.Button r1 = r10.f13018a0
            r1.setVisibility(r12)
        L_0x0449:
            android.widget.TextView r1 = r10.f13000I
            java.util.List r2 = r0.f12926V0
            java.lang.Object r2 = r2.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r2 = (com.finazzi.distquake.FragmentOfficial.i) r2
            java.lang.String r2 = r2.b0()
            java.lang.String r2 = r2.trim()
            r1.setText(r2)
            java.util.List r1 = r0.f12926V0
            java.lang.Object r1 = r1.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r1 = (com.finazzi.distquake.FragmentOfficial.i) r1
            boolean r1 = r1.h0()
            if (r1 != 0) goto L_0x0482
            java.util.List r1 = r0.f12926V0
            java.lang.Object r1 = r1.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r1 = (com.finazzi.distquake.FragmentOfficial.i) r1
            org.achartengine.b r1 = r1.R()
            if (r1 == 0) goto L_0x047b
            goto L_0x0482
        L_0x047b:
            android.widget.LinearLayout r1 = r10.f13022e0
            r1.setVisibility(r12)
            goto L_0x0500
        L_0x0482:
            android.widget.LinearLayout r1 = r10.f13022e0
            r2 = 0
            r1.setVisibility(r2)
            java.util.List r1 = r0.f12926V0
            java.lang.Object r1 = r1.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r1 = (com.finazzi.distquake.FragmentOfficial.i) r1
            boolean r1 = r1.h0()
            if (r1 == 0) goto L_0x04b8
            android.widget.ImageView r1 = r10.f13010S
            r1.setVisibility(r12)
            com.google.android.gms.maps.MapView r1 = r10.f13009R
            r1.setVisibility(r2)
            r0.f12942l1 = r9
            com.google.android.gms.maps.MapView r1 = r10.f13009R
            android.os.Bundle r2 = r0.f12945n1
            r1.onCreate(r2)
            com.google.android.gms.maps.MapView r1 = r10.f13009R
            r1.onStart()
            com.google.android.gms.maps.MapView r1 = r10.f13009R
            r1.onResume()
            com.google.android.gms.maps.MapView r1 = r10.f13009R
            r1.getMapAsync(r0)
        L_0x04b8:
            java.util.List r1 = r0.f12926V0
            java.lang.Object r1 = r1.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r1 = (com.finazzi.distquake.FragmentOfficial.i) r1
            org.achartengine.b r1 = r1.R()
            if (r1 == 0) goto L_0x0500
            java.util.List r1 = r0.f12926V0
            java.lang.Object r1 = r1.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r1 = (com.finazzi.distquake.FragmentOfficial.i) r1
            org.achartengine.b r1 = r1.R()
            r2 = 1
            r1.setDrawingCacheEnabled(r2)
            r3 = 800(0x320, float:1.121E-42)
            r4 = 300(0x12c, float:4.2E-43)
            r6 = 0
            r1.layout(r6, r6, r3, r4)
            r3 = 1048576(0x100000, float:1.469368E-39)
            r1.setDrawingCacheQuality(r3)
            r1.buildDrawingCache(r2)
            android.graphics.Bitmap r2 = r1.getDrawingCache()
            android.graphics.Bitmap r2 = android.graphics.Bitmap.createBitmap(r2)
            r1.setDrawingCacheEnabled(r6)
            android.widget.ImageView r1 = r10.f13010S
            r1.setImageBitmap(r2)
            android.widget.ImageView r1 = r10.f13010S
            r1.setVisibility(r6)
            com.google.android.gms.maps.MapView r1 = r10.f13009R
            r1.setVisibility(r12)
        L_0x0500:
            boolean r1 = r0.f12941k1
            r31 = 4616752568008179712(0x4012000000000000, double:4.5)
            r8 = 255(0xff, float:3.57E-43)
            if (r1 == 0) goto L_0x0856
            android.content.res.Resources r1 = r0.getResources()
            android.content.res.Configuration r1 = r1.getConfiguration()
            int r1 = r1.uiMode
            r1 = r1 & 48
            androidx.fragment.app.s r15 = r0.getActivity()
            r33 = 4617878467915022336(0x4016000000000000, double:5.5)
            if (r15 == 0) goto L_0x0577
            android.widget.TextView r2 = r10.f12999H
            android.content.res.Resources r3 = r0.getResources()
            android.content.res.Resources$Theme r5 = r15.getTheme()
            r35 = 4615063718147915776(0x400c000000000000, double:3.5)
            r6 = 2131100464(0x7f060330, float:1.781331E38)
            int r3 = r3.getColor(r6, r5)
            r2.setTextColor(r3)
            android.view.View r2 = r10.f13019b0
            android.content.res.Resources r3 = r0.getResources()
            android.content.res.Resources$Theme r5 = r15.getTheme()
            int r3 = r3.getColor(r6, r5)
            r2.setBackgroundColor(r3)
            android.widget.TextView r2 = r10.f13000I
            android.content.res.Resources r3 = r0.getResources()
            android.content.res.Resources$Theme r5 = r15.getTheme()
            int r3 = r3.getColor(r6, r5)
            r2.setTextColor(r3)
            int r2 = r0.f12920P0
            r3 = 1
            if (r2 != r3) goto L_0x0565
            int r2 = r0.f12921Q0
            if (r9 != r2) goto L_0x0565
            android.widget.TextView r2 = r10.f12997F
            r3 = -65536(0xffffffffffff0000, float:NaN)
            r2.setTextColor(r3)
            goto L_0x0579
        L_0x0565:
            android.widget.TextView r2 = r10.f12997F
            android.content.res.Resources r3 = r0.getResources()
            android.content.res.Resources$Theme r5 = r15.getTheme()
            int r3 = r3.getColor(r6, r5)
            r2.setTextColor(r3)
            goto L_0x0579
        L_0x0577:
            r35 = 4615063718147915776(0x400c000000000000, double:3.5)
        L_0x0579:
            java.util.List r2 = r0.f12926V0
            java.lang.Object r2 = r2.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r2 = (com.finazzi.distquake.FragmentOfficial.i) r2
            double r2 = r2.Z()
            int r2 = (r2 > r29 ? 1 : (r2 == r29 ? 0 : -1))
            r3 = 16
            r5 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            if (r2 >= 0) goto L_0x0604
            java.util.List r2 = r0.f12926V0
            java.lang.Object r2 = r2.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r2 = (com.finazzi.distquake.FragmentOfficial.i) r2
            double r24 = r2.Z()
            double r24 = r24 - r16
            double r24 = r24 / r29
            double r15 = r5 - r24
            if (r1 != r3) goto L_0x05d4
            r24 = 4629841154425225216(0x4040800000000000, double:33.0)
            double r24 = r24 * r15
            r26 = 4640502019168141312(0x4066600000000000, double:179.0)
            double r24 = r24 + r26
            r26 = r5
            long r5 = java.lang.Math.round(r24)
            int r2 = (int) r5
            r5 = 4626041242239631360(0x4033000000000000, double:19.0)
            double r5 = r5 * r15
            r24 = 4641592734702895104(0x406a400000000000, double:210.0)
            double r5 = r5 + r24
            long r5 = java.lang.Math.round(r5)
            int r5 = (int) r5
            r6 = 4623507967449235456(0x402a000000000000, double:13.0)
            double r15 = r15 * r6
            r6 = 4642050131540049920(0x406be00000000000, double:223.0)
            double r15 = r15 + r6
            long r6 = java.lang.Math.round(r15)
        L_0x05d2:
            int r6 = (int) r6
            goto L_0x0609
        L_0x05d4:
            r26 = r5
            double r5 = r15 * r22
            r24 = 4632092954238910464(0x4048800000000000, double:49.0)
            double r5 = r5 + r24
            long r5 = java.lang.Math.round(r5)
            int r2 = (int) r5
            r5 = 4629700416936869888(0x4040000000000000, double:32.0)
            double r5 = r5 * r15
            r24 = 4634837335261839360(0x4052400000000000, double:73.0)
            double r5 = r5 + r24
            long r5 = java.lang.Math.round(r5)
            int r5 = (int) r5
            r6 = 4631248529308778496(0x4045800000000000, double:43.0)
            double r15 = r15 * r6
            r6 = 4636526185122103296(0x4058400000000000, double:97.0)
            double r15 = r15 + r6
            long r6 = java.lang.Math.round(r15)
            goto L_0x05d2
        L_0x0604:
            r26 = r5
            r2 = 0
            r5 = 0
            r6 = 0
        L_0x0609:
            java.util.List r7 = r0.f12926V0
            java.lang.Object r7 = r7.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r7 = (com.finazzi.distquake.FragmentOfficial.i) r7
            double r15 = r7.Z()
            int r7 = (r15 > r29 ? 1 : (r15 == r29 ? 0 : -1))
            if (r7 < 0) goto L_0x0698
            java.util.List r7 = r0.f12926V0
            java.lang.Object r7 = r7.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r7 = (com.finazzi.distquake.FragmentOfficial.i) r7
            double r15 = r7.Z()
            int r7 = (r15 > r35 ? 1 : (r15 == r35 ? 0 : -1))
            if (r7 >= 0) goto L_0x0698
            java.util.List r2 = r0.f12926V0
            java.lang.Object r2 = r2.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r2 = (com.finazzi.distquake.FragmentOfficial.i) r2
            double r5 = r2.Z()
            double r5 = r5 - r29
            r15 = 4609434218613702656(0x3ff8000000000000, double:1.5)
            double r5 = r5 / r15
            double r5 = r26 - r5
            if (r1 != r3) goto L_0x0672
            r15 = 4634204016564240384(0x4050000000000000, double:64.0)
            double r15 = r15 * r5
            r24 = 4638989091168321536(0x4061000000000000, double:136.0)
            double r15 = r15 + r24
            r24 = r5
            long r4 = java.lang.Math.round(r15)
            int r2 = (int) r4
            r4 = 4632374429215621120(0x4049800000000000, double:51.0)
            double r5 = r24 * r4
            r15 = 4640361281679785984(0x4065e00000000000, double:175.0)
            double r5 = r5 + r15
            long r4 = java.lang.Math.round(r5)
            int r5 = (int) r4
            r15 = 4634274385308418048(0x4050400000000000, double:65.0)
            double r15 = r15 * r24
            r24 = 4638813169307877376(0x4060600000000000, double:131.0)
            double r15 = r15 + r24
            long r12 = java.lang.Math.round(r15)
        L_0x0670:
            int r6 = (int) r12
            goto L_0x0698
        L_0x0672:
            r24 = r5
            double r5 = r24 * r22
            r12 = 4628574517030027264(0x403c000000000000, double:28.0)
            double r5 = r5 + r12
            long r5 = java.lang.Math.round(r5)
            int r2 = (int) r5
            r5 = 4631670741773844480(0x4047000000000000, double:46.0)
            double r5 = r5 * r24
            r12 = 4634274385308418048(0x4050400000000000, double:65.0)
            double r5 = r5 + r12
            long r5 = java.lang.Math.round(r5)
            int r5 = (int) r5
            r12 = 4625196817309499392(0x4030000000000000, double:16.0)
            double r12 = r12 * r24
            double r12 = r12 + r22
            long r12 = java.lang.Math.round(r12)
            goto L_0x0670
        L_0x0698:
            java.util.List r12 = r0.f12926V0
            java.lang.Object r12 = r12.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r12 = (com.finazzi.distquake.FragmentOfficial.i) r12
            double r12 = r12.Z()
            int r12 = (r12 > r35 ? 1 : (r12 == r35 ? 0 : -1))
            if (r12 < 0) goto L_0x071a
            java.util.List r12 = r0.f12926V0
            java.lang.Object r12 = r12.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r12 = (com.finazzi.distquake.FragmentOfficial.i) r12
            double r12 = r12.Z()
            int r12 = (r12 > r31 ? 1 : (r12 == r31 ? 0 : -1))
            if (r12 >= 0) goto L_0x071a
            java.util.List r2 = r0.f12926V0
            java.lang.Object r2 = r2.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r2 = (com.finazzi.distquake.FragmentOfficial.i) r2
            double r5 = r2.Z()
            double r5 = r5 - r35
            double r5 = r5 / r26
            double r5 = r26 - r5
            if (r1 != r3) goto L_0x06ec
            r12 = 4626322717216342016(0x4034000000000000, double:20.0)
            double r12 = r12 * r5
            r15 = 4642401975260938240(0x406d200000000000, double:233.0)
            double r12 = r12 + r15
            long r12 = java.lang.Math.round(r12)
            int r2 = (int) r12
            r12 = 4629137466983448576(0x403e000000000000, double:30.0)
            double r5 = r5 * r12
            r12 = 4640502019168141312(0x4066600000000000, double:179.0)
            double r5 = r5 + r12
            long r5 = java.lang.Math.round(r5)
            int r6 = (int) r5
            r5 = r2
            r2 = 252(0xfc, float:3.53E-43)
            goto L_0x071a
        L_0x06ec:
            r12 = 4633218854145753088(0x404c800000000000, double:57.0)
            double r12 = r12 * r5
            r15 = 4638848353679966208(0x4060800000000000, double:132.0)
            double r12 = r12 + r15
            long r12 = java.lang.Math.round(r12)
            int r2 = (int) r12
            r12 = 4631248529308778496(0x4045800000000000, double:43.0)
            double r12 = r12 * r5
            r15 = 4636807660098813952(0x4059400000000000, double:101.0)
            double r12 = r12 + r15
            long r12 = java.lang.Math.round(r12)
            int r12 = (int) r12
            r15 = 4613937818241073152(0x4008000000000000, double:3.0)
            double r5 = r5 * r15
            r15 = 4618441417868443648(0x4018000000000000, double:6.0)
            double r5 = r5 + r15
            long r5 = java.lang.Math.round(r5)
            int r6 = (int) r5
            r5 = r12
        L_0x071a:
            java.util.List r12 = r0.f12926V0
            java.lang.Object r12 = r12.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r12 = (com.finazzi.distquake.FragmentOfficial.i) r12
            double r12 = r12.Z()
            int r12 = (r12 > r31 ? 1 : (r12 == r31 ? 0 : -1))
            if (r12 < 0) goto L_0x0793
            java.util.List r12 = r0.f12926V0
            java.lang.Object r12 = r12.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r12 = (com.finazzi.distquake.FragmentOfficial.i) r12
            double r12 = r12.Z()
            int r12 = (r12 > r33 ? 1 : (r12 == r33 ? 0 : -1))
            if (r12 >= 0) goto L_0x0793
            java.util.List r2 = r0.f12926V0
            java.lang.Object r2 = r2.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r2 = (com.finazzi.distquake.FragmentOfficial.i) r2
            double r5 = r2.Z()
            double r5 = r5 - r31
            double r5 = r5 / r26
            double r5 = r26 - r5
            if (r1 != r3) goto L_0x076e
            r12 = 4630544841867001856(0x4043000000000000, double:38.0)
            double r12 = r12 * r5
            r15 = 4639798331726364672(0x4063e00000000000, double:159.0)
            double r12 = r12 + r15
            long r12 = java.lang.Math.round(r12)
            int r2 = (int) r12
            r12 = 4630263366890291200(0x4042000000000000, double:36.0)
            double r5 = r5 * r12
            r12 = 4639868700470542336(0x4064200000000000, double:161.0)
            double r5 = r5 + r12
            long r5 = java.lang.Math.round(r5)
            int r6 = (int) r5
            r5 = r2
            r2 = 252(0xfc, float:3.53E-43)
            goto L_0x0793
        L_0x076e:
            r12 = 4633781804099174400(0x404e800000000000, double:61.0)
            double r12 = r12 * r5
            r15 = 4637511347540590592(0x405bc00000000000, double:111.0)
            double r12 = r12 + r15
            long r12 = java.lang.Math.round(r12)
            int r2 = (int) r12
            double r12 = r5 * r26
            double r12 = r12 + r26
            long r12 = java.lang.Math.round(r12)
            int r7 = (int) r12
            r12 = 4622945017495814144(0x4028000000000000, double:12.0)
            double r5 = r5 * r12
            double r5 = r5 + r22
            long r5 = java.lang.Math.round(r5)
            int r6 = (int) r5
            r5 = r7
        L_0x0793:
            java.util.List r7 = r0.f12926V0
            java.lang.Object r7 = r7.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r7 = (com.finazzi.distquake.FragmentOfficial.i) r7
            double r12 = r7.Z()
            int r7 = (r12 > r33 ? 1 : (r12 == r33 ? 0 : -1))
            if (r7 < 0) goto L_0x07f6
            java.util.List r2 = r0.f12926V0
            java.lang.Object r2 = r2.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r2 = (com.finazzi.distquake.FragmentOfficial.i) r2
            double r5 = r2.Z()
            double r5 = r5 - r33
            double r5 = r5 / r31
            double r5 = r26 - r5
            if (r1 != r3) goto L_0x07d5
            r1 = 4634204016564240384(0x4050000000000000, double:64.0)
            double r1 = r1 * r5
            r12 = 4640889047261118464(0x4067c00000000000, double:190.0)
            double r1 = r1 + r12
            long r1 = java.lang.Math.round(r1)
            int r2 = (int) r1
            r12 = 4636385447633747968(0x4057c00000000000, double:95.0)
            double r5 = r5 * r12
            r12 = 4638426141214900224(0x405f000000000000, double:124.0)
            double r5 = r5 + r12
            long r5 = java.lang.Math.round(r5)
            int r5 = (int) r5
            r6 = r8
            goto L_0x07f6
        L_0x07d5:
            r1 = 4635400285215260672(0x4054400000000000, double:81.0)
            double r1 = r1 * r5
            r12 = 4637792822517301248(0x405cc00000000000, double:115.0)
            double r1 = r1 + r12
            long r12 = java.lang.Math.round(r1)
            int r3 = (int) r12
            r12 = 4613937818241073152(0x4008000000000000, double:3.0)
            double r5 = r5 * r29
            double r5 = r5 + r12
            long r5 = java.lang.Math.round(r5)
            int r5 = (int) r5
            long r1 = java.lang.Math.round(r1)
            int r6 = (int) r1
            r2 = r3
        L_0x07f6:
            int r1 = r2 + 20
            int r3 = r5 + 20
            int r7 = r6 + 20
            if (r1 <= r8) goto L_0x07ff
            r1 = r8
        L_0x07ff:
            if (r3 <= r8) goto L_0x0802
            r3 = r8
        L_0x0802:
            if (r7 <= r8) goto L_0x0805
            goto L_0x0806
        L_0x0805:
            r8 = r7
        L_0x0806:
            int r2 = android.graphics.Color.rgb(r2, r5, r6)
            int r1 = android.graphics.Color.rgb(r1, r3, r8)
            int[] r1 = new int[]{r2, r1}
            android.graphics.drawable.GradientDrawable r2 = new android.graphics.drawable.GradientDrawable
            r2.<init>()
            r6 = 0
            r2.setGradientType(r6)
            android.graphics.drawable.GradientDrawable$Orientation r3 = android.graphics.drawable.GradientDrawable.Orientation.TL_BR
            r2.setOrientation(r3)
            r2.setColors(r1)
            r4 = 1092616192(0x41200000, float:10.0)
            r2.setCornerRadius(r4)
            androidx.cardview.widget.CardView r1 = r10.f13020c0
            r1.setBackground(r2)
            androidx.cardview.widget.CardView r1 = r10.f13020c0
            r2 = 1077936128(0x40400000, float:3.0)
            r1.setElevation(r2)
            android.content.res.Resources r1 = r0.getResources()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 1
            float r1 = android.util.TypedValue.applyDimension(r3, r2, r1)
            android.view.View r2 = r10.f13019b0
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            int r1 = java.lang.Math.round(r1)
            r2.height = r1
            android.view.View r1 = r10.f13019b0
            r1.setLayoutParams(r2)
            goto L_0x09e7
        L_0x0856:
            r33 = 4617878467915022336(0x4016000000000000, double:5.5)
            r35 = 4615063718147915776(0x400c000000000000, double:3.5)
            java.util.List r1 = r0.f12926V0
            java.lang.Object r1 = r1.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r1 = (com.finazzi.distquake.FragmentOfficial.i) r1
            double r1 = r1.Z()
            int r1 = (r1 > r29 ? 1 : (r1 == r29 ? 0 : -1))
            r2 = 160(0xa0, float:2.24E-43)
            r3 = 12
            if (r1 >= 0) goto L_0x088b
            android.widget.TextView r1 = r10.f12999H
            r5 = 115(0x73, float:1.61E-43)
            int r6 = android.graphics.Color.rgb(r3, r5, r2)
            r1.setTextColor(r6)
            android.view.View r1 = r10.f13019b0
            int r6 = android.graphics.Color.rgb(r3, r5, r2)
            r1.setBackgroundColor(r6)
            android.widget.TextView r1 = r10.f13000I
            int r5 = android.graphics.Color.rgb(r3, r5, r2)
            r1.setTextColor(r5)
        L_0x088b:
            java.util.List r1 = r0.f12926V0
            java.lang.Object r1 = r1.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r1 = (com.finazzi.distquake.FragmentOfficial.i) r1
            double r5 = r1.Z()
            int r1 = (r5 > r29 ? 1 : (r5 == r29 ? 0 : -1))
            if (r1 < 0) goto L_0x08c8
            java.util.List r1 = r0.f12926V0
            java.lang.Object r1 = r1.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r1 = (com.finazzi.distquake.FragmentOfficial.i) r1
            double r5 = r1.Z()
            int r1 = (r5 > r35 ? 1 : (r5 == r35 ? 0 : -1))
            if (r1 >= 0) goto L_0x08c8
            android.widget.TextView r1 = r10.f12999H
            r5 = 35
            int r6 = android.graphics.Color.rgb(r3, r2, r5)
            r1.setTextColor(r6)
            android.view.View r1 = r10.f13019b0
            int r6 = android.graphics.Color.rgb(r3, r2, r5)
            r1.setBackgroundColor(r6)
            android.widget.TextView r1 = r10.f13000I
            int r2 = android.graphics.Color.rgb(r3, r2, r5)
            r1.setTextColor(r2)
        L_0x08c8:
            java.util.List r1 = r0.f12926V0
            java.lang.Object r1 = r1.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r1 = (com.finazzi.distquake.FragmentOfficial.i) r1
            double r1 = r1.Z()
            int r1 = (r1 > r35 ? 1 : (r1 == r35 ? 0 : -1))
            if (r1 < 0) goto L_0x0908
            java.util.List r1 = r0.f12926V0
            java.lang.Object r1 = r1.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r1 = (com.finazzi.distquake.FragmentOfficial.i) r1
            double r1 = r1.Z()
            int r1 = (r1 > r31 ? 1 : (r1 == r31 ? 0 : -1))
            if (r1 >= 0) goto L_0x0908
            android.widget.TextView r1 = r10.f12999H
            r2 = 0
            r3 = 244(0xf4, float:3.42E-43)
            r5 = 195(0xc3, float:2.73E-43)
            int r6 = android.graphics.Color.rgb(r3, r5, r2)
            r1.setTextColor(r6)
            android.view.View r1 = r10.f13019b0
            int r6 = android.graphics.Color.rgb(r3, r5, r2)
            r1.setBackgroundColor(r6)
            android.widget.TextView r1 = r10.f13000I
            int r3 = android.graphics.Color.rgb(r3, r5, r2)
            r1.setTextColor(r3)
        L_0x0908:
            java.util.List r1 = r0.f12926V0
            java.lang.Object r1 = r1.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r1 = (com.finazzi.distquake.FragmentOfficial.i) r1
            double r1 = r1.Z()
            int r1 = (r1 > r31 ? 1 : (r1 == r31 ? 0 : -1))
            if (r1 < 0) goto L_0x0944
            java.util.List r1 = r0.f12926V0
            java.lang.Object r1 = r1.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r1 = (com.finazzi.distquake.FragmentOfficial.i) r1
            double r1 = r1.Z()
            int r1 = (r1 > r33 ? 1 : (r1 == r33 ? 0 : -1))
            if (r1 >= 0) goto L_0x0944
            android.widget.TextView r1 = r10.f12999H
            r2 = 0
            int r3 = android.graphics.Color.rgb(r8, r2, r2)
            r1.setTextColor(r3)
            android.view.View r1 = r10.f13019b0
            int r3 = android.graphics.Color.rgb(r8, r2, r2)
            r1.setBackgroundColor(r3)
            android.widget.TextView r1 = r10.f13000I
            int r3 = android.graphics.Color.rgb(r8, r2, r2)
            r1.setTextColor(r3)
        L_0x0944:
            java.util.List r1 = r0.f12926V0
            java.lang.Object r1 = r1.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r1 = (com.finazzi.distquake.FragmentOfficial.i) r1
            double r1 = r1.Z()
            int r1 = (r1 > r33 ? 1 : (r1 == r33 ? 0 : -1))
            if (r1 < 0) goto L_0x0975
            android.widget.TextView r1 = r10.f12999H
            r2 = 183(0xb7, float:2.56E-43)
            r3 = 60
            r7 = 252(0xfc, float:3.53E-43)
            int r5 = android.graphics.Color.rgb(r2, r3, r7)
            r1.setTextColor(r5)
            android.view.View r1 = r10.f13019b0
            int r5 = android.graphics.Color.rgb(r2, r3, r7)
            r1.setBackgroundColor(r5)
            android.widget.TextView r1 = r10.f13000I
            int r2 = android.graphics.Color.rgb(r2, r3, r7)
            r1.setTextColor(r2)
        L_0x0975:
            android.content.res.Resources r1 = r0.getResources()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            r2 = 1082130432(0x40800000, float:4.0)
            r3 = 1
            float r1 = android.util.TypedValue.applyDimension(r3, r2, r1)
            android.view.View r2 = r10.f13019b0
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            int r1 = java.lang.Math.round(r1)
            r2.height = r1
            android.view.View r1 = r10.f13019b0
            r1.setLayoutParams(r2)
            androidx.fragment.app.s r1 = r0.getActivity()
            if (r1 == 0) goto L_0x09e7
            int r2 = r0.f12920P0
            if (r2 != r3) goto L_0x09ab
            int r2 = r0.f12921Q0
            if (r9 != r2) goto L_0x09ab
            android.widget.TextView r2 = r10.f12997F
            r3 = -65536(0xffffffffffff0000, float:NaN)
            r2.setTextColor(r3)
            goto L_0x09bf
        L_0x09ab:
            android.widget.TextView r2 = r10.f12997F
            android.content.res.Resources r3 = r0.getResources()
            r5 = 2131100479(0x7f06033f, float:1.781334E38)
            android.content.res.Resources$Theme r6 = r1.getTheme()
            int r3 = r3.getColor(r5, r6)
            r2.setTextColor(r3)
        L_0x09bf:
            android.graphics.drawable.GradientDrawable r2 = new android.graphics.drawable.GradientDrawable
            r2.<init>()
            android.content.res.Resources r3 = r0.getResources()
            r5 = 2131100502(0x7f060356, float:1.7813387E38)
            android.content.res.Resources$Theme r1 = r1.getTheme()
            int r1 = r3.getColor(r5, r1)
            r2.setColor(r1)
            r4 = 1092616192(0x41200000, float:10.0)
            r2.setCornerRadius(r4)
            androidx.cardview.widget.CardView r1 = r10.f13020c0
            r1.setBackground(r2)
            androidx.cardview.widget.CardView r1 = r10.f13020c0
            r2 = 1077936128(0x40400000, float:3.0)
            r1.setElevation(r2)
        L_0x09e7:
            android.widget.TextView r1 = r10.f12998G
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r3 = 2131886885(0x7f120325, float:1.9408361E38)
            java.lang.String r3 = r0.getString(r3)
            java.util.List r4 = r0.f12926V0
            java.lang.Object r4 = r4.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r4 = (com.finazzi.distquake.FragmentOfficial.i) r4
            java.lang.String r4 = r4.f0()
            r5 = 1
            java.lang.Object[] r6 = new java.lang.Object[r5]
            r28 = 0
            r6[r28] = r4
            java.lang.String r3 = java.lang.String.format(r3, r6)
            r2.append(r3)
            java.lang.String r3 = " "
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.setText(r2)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.util.List r2 = r0.f12926V0
            java.lang.Object r2 = r2.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r2 = (com.finazzi.distquake.FragmentOfficial.i) r2
            java.lang.String r2 = r2.S()
            java.lang.String r2 = r0.w2(r2)
            r1.append(r2)
            java.lang.String r2 = " - "
            r1.append(r2)
            java.util.List r2 = r0.f12926V0
            java.lang.Object r2 = r2.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r2 = (com.finazzi.distquake.FragmentOfficial.i) r2
            java.lang.String r2 = r2.S()
            java.lang.String r2 = r0.u2(r2)
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.widget.TextView r2 = r10.f13001J
            r2.setText(r1)
            java.text.DecimalFormatSymbols r1 = new java.text.DecimalFormatSymbols
            java.util.Locale r2 = java.util.Locale.getDefault()
            r1.<init>(r2)
            r15 = 46
            r1.setDecimalSeparator(r15)
            r15 = 44
            r1.setGroupingSeparator(r15)
            java.text.DecimalFormat r2 = new java.text.DecimalFormat
            java.lang.String r3 = "0.0"
            r2.<init>(r3, r1)
            java.lang.String r1 = r0.f12929Y0
            boolean r1 = r1.equals(r14)
            if (r1 == 0) goto L_0x0aa0
            android.widget.TextView r1 = r10.f13004M
            r3 = 2131887102(0x7f1203fe, float:1.9408802E38)
            java.lang.String r3 = r0.getString(r3)
            java.util.List r4 = r0.f12926V0
            java.lang.Object r4 = r4.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r4 = (com.finazzi.distquake.FragmentOfficial.i) r4
            double r4 = r4.T()
            java.lang.String r2 = r2.format(r4)
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]
            r28 = 0
            r5[r28] = r2
            java.lang.String r2 = java.lang.String.format(r3, r5)
            r1.setText(r2)
            r28 = 0
            goto L_0x0ac7
        L_0x0aa0:
            android.widget.TextView r1 = r10.f13004M
            r3 = 2131887101(0x7f1203fd, float:1.94088E38)
            java.lang.String r3 = r0.getString(r3)
            java.util.List r4 = r0.f12926V0
            java.lang.Object r4 = r4.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r4 = (com.finazzi.distquake.FragmentOfficial.i) r4
            double r4 = r4.T()
            java.lang.String r2 = r2.format(r4)
            r4 = 1
            java.lang.Object[] r5 = new java.lang.Object[r4]
            r28 = 0
            r5[r28] = r2
            java.lang.String r2 = java.lang.String.format(r3, r5)
            r1.setText(r2)
        L_0x0ac7:
            java.util.List r1 = r0.f12926V0
            java.lang.Object r1 = r1.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r1 = (com.finazzi.distquake.FragmentOfficial.i) r1
            double r1 = r1.W()
            double r3 = java.lang.Math.floor(r1)
            int r3 = (int) r3
            double r3 = (double) r3
            double r1 = r1 - r3
            double r1 = r1 * r20
            double r5 = java.lang.Math.floor(r1)
            double r5 = r1 - r5
            double r5 = r5 * r20
            int r3 = (int) r3
            java.lang.String r3 = java.lang.Integer.toString(r3)
            double r1 = java.lang.Math.floor(r1)
            int r1 = (int) r1
            java.lang.String r1 = java.lang.Integer.toString(r1)
            long r4 = java.lang.Math.round(r5)
            int r2 = (int) r4
            java.lang.String r2 = java.lang.Integer.toString(r2)
            int r4 = r1.length()
            r5 = 1
            if (r4 != r5) goto L_0x0b11
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r11)
            r4.append(r1)
            java.lang.String r1 = r4.toString()
        L_0x0b11:
            int r4 = r2.length()
            if (r4 != r5) goto L_0x0b26
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r4.append(r11)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
        L_0x0b26:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = ""
            r4.append(r5)
            r4.append(r3)
            java.lang.String r3 = "°"
            r4.append(r3)
            r4.append(r1)
            java.lang.String r1 = "'"
            r4.append(r1)
            r4.append(r2)
            java.lang.String r1 = "'' lat "
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            java.util.List r2 = r0.f12926V0
            java.lang.Object r2 = r2.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r2 = (com.finazzi.distquake.FragmentOfficial.i) r2
            double r2 = r2.Y()
            double r4 = java.lang.Math.floor(r2)
            int r4 = (int) r4
            double r4 = (double) r4
            double r2 = r2 - r4
            double r2 = r2 * r20
            double r6 = java.lang.Math.floor(r2)
            double r6 = r2 - r6
            double r6 = r6 * r20
            int r4 = (int) r4
            java.lang.String r4 = java.lang.Integer.toString(r4)
            double r2 = java.lang.Math.floor(r2)
            int r2 = (int) r2
            java.lang.String r2 = java.lang.Integer.toString(r2)
            long r5 = java.lang.Math.round(r6)
            int r3 = (int) r5
            java.lang.String r3 = java.lang.Integer.toString(r3)
            int r5 = r2.length()
            r6 = 1
            if (r5 != r6) goto L_0x0b96
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r11)
            r5.append(r2)
            java.lang.String r2 = r5.toString()
        L_0x0b96:
            int r5 = r3.length()
            if (r5 != r6) goto L_0x0bab
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r11)
            r5.append(r3)
            java.lang.String r3 = r5.toString()
        L_0x0bab:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r5.append(r1)
            r5.append(r4)
            java.lang.String r1 = "°"
            r5.append(r1)
            r5.append(r2)
            java.lang.String r1 = "'"
            r5.append(r1)
            r5.append(r3)
            java.lang.String r1 = "'' lon"
            r5.append(r1)
            java.lang.String r1 = r5.toString()
            android.widget.TextView r2 = r10.f13003L
            r2.setText(r1)
            double r1 = r0.f12910F0
            double r3 = r0.f12911G0
            java.util.List r5 = r0.f12926V0
            java.lang.Object r5 = r5.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r5 = (com.finazzi.distquake.FragmentOfficial.i) r5
            double r5 = r5.W()
            java.util.List r7 = r0.f12926V0
            java.lang.Object r7 = r7.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r7 = (com.finazzi.distquake.FragmentOfficial.i) r7
            double r7 = r7.Y()
            r13 = r28
            r12 = 2
            double r1 = r0.z2(r1, r3, r5, r7)
            long r1 = java.lang.Math.round(r1)
            boolean r3 = r0.f12938h1
            if (r3 == 0) goto L_0x0d3d
            boolean r3 = r0.B2()
            if (r3 == 0) goto L_0x0d33
            java.lang.String r3 = r0.f12929Y0
            boolean r3 = r3.equals(r14)
            if (r3 == 0) goto L_0x0c99
            double r1 = (double) r1
            r3 = 4603772033682776338(0x3fe3e245d68a2112, double:0.621371192)
            double r1 = r1 * r3
            long r1 = (long) r1
            java.util.List r3 = r0.f12926V0
            java.lang.Object r3 = r3.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r3 = (com.finazzi.distquake.FragmentOfficial.i) r3
            java.lang.String r3 = r3.S()
            if (r3 == 0) goto L_0x0c91
            r3 = 5000(0x1388, double:2.4703E-320)
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0c70
            r3 = 2131886877(0x7f12031d, float:1.9408345E38)
            java.lang.String r15 = r0.getString(r3)
            int r3 = (int) r1
            java.lang.Integer r16 = java.lang.Integer.valueOf(r3)
            r3 = r1
            double r1 = r0.f12910F0
            r5 = r3
            double r3 = r0.f12911G0
            java.util.List r7 = r0.f12926V0
            java.lang.Object r7 = r7.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r7 = (com.finazzi.distquake.FragmentOfficial.i) r7
            double r7 = r7.W()
            r28 = r13
            java.util.List r13 = r0.f12926V0
            java.lang.Object r13 = r13.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r13 = (com.finazzi.distquake.FragmentOfficial.i) r13
            double r20 = r13.Y()
            r37 = r5
            r5 = r7
            r7 = r20
            double r1 = r0.x2(r1, r3, r5, r7)
            java.lang.String r1 = r0.y2(r1)
            java.lang.Object[] r2 = new java.lang.Object[r12]
            r2[r28] = r16
            r3 = 1
            r2[r3] = r1
            java.lang.String r1 = java.lang.String.format(r15, r2)
            r5 = r37
            goto L_0x0c8b
        L_0x0c70:
            r37 = r1
            r28 = r13
            r3 = 1
            r1 = 2131886878(0x7f12031e, float:1.9408347E38)
            java.lang.String r1 = r0.getString(r1)
            r5 = r37
            int r2 = (int) r5
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object[] r4 = new java.lang.Object[r3]
            r4[r28] = r2
            java.lang.String r1 = java.lang.String.format(r1, r4)
        L_0x0c8b:
            android.widget.TextView r2 = r10.f13002K
            r2.setText(r1)
            goto L_0x0c94
        L_0x0c91:
            r5 = r1
            r28 = r13
        L_0x0c94:
            r1 = r5
            r20 = r11
            goto L_0x0d16
        L_0x0c99:
            r28 = r13
            java.util.List r3 = r0.f12926V0
            java.lang.Object r3 = r3.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r3 = (com.finazzi.distquake.FragmentOfficial.i) r3
            java.lang.String r3 = r3.S()
            if (r3 == 0) goto L_0x0d12
            r3 = 8000(0x1f40, double:3.9525E-320)
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 >= 0) goto L_0x0cf4
            r3 = 2131886876(0x7f12031c, float:1.9408343E38)
            java.lang.String r13 = r0.getString(r3)
            int r3 = (int) r1
            java.lang.Integer r15 = java.lang.Integer.valueOf(r3)
            r3 = r1
            double r1 = r0.f12910F0
            r5 = r3
            double r3 = r0.f12911G0
            java.util.List r7 = r0.f12926V0
            java.lang.Object r7 = r7.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r7 = (com.finazzi.distquake.FragmentOfficial.i) r7
            double r7 = r7.W()
            java.util.List r12 = r0.f12926V0
            java.lang.Object r12 = r12.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r12 = (com.finazzi.distquake.FragmentOfficial.i) r12
            double r16 = r12.Y()
            r20 = r11
            r11 = r5
            r5 = r7
            r7 = r16
            double r1 = r0.x2(r1, r3, r5, r7)
            java.lang.String r1 = r0.y2(r1)
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r2[r28] = r15
            r3 = 1
            r2[r3] = r1
            java.lang.String r1 = java.lang.String.format(r13, r2)
            goto L_0x0d0c
        L_0x0cf4:
            r20 = r11
            r3 = 1
            r11 = r1
            r1 = 2131886879(0x7f12031f, float:1.940835E38)
            java.lang.String r1 = r0.getString(r1)
            int r2 = (int) r11
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object[] r4 = new java.lang.Object[r3]
            r4[r28] = r2
            java.lang.String r1 = java.lang.String.format(r1, r4)
        L_0x0d0c:
            android.widget.TextView r2 = r10.f13002K
            r2.setText(r1)
            goto L_0x0d15
        L_0x0d12:
            r20 = r11
            r11 = r1
        L_0x0d15:
            r1 = r11
        L_0x0d16:
            r3 = 100
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 >= 0) goto L_0x0d24
            android.widget.TextView r1 = r10.f13002K
            android.graphics.Typeface r2 = android.graphics.Typeface.DEFAULT_BOLD
            r1.setTypeface(r2)
            goto L_0x0d2b
        L_0x0d24:
            android.widget.TextView r1 = r10.f13002K
            android.graphics.Typeface r2 = android.graphics.Typeface.DEFAULT
            r1.setTypeface(r2)
        L_0x0d2b:
            android.widget.TextView r1 = r10.f13002K
            r2 = r28
            r1.setVisibility(r2)
            goto L_0x0d46
        L_0x0d33:
            r20 = r11
            android.widget.TextView r1 = r10.f13002K
            r2 = 8
            r1.setVisibility(r2)
            goto L_0x0d46
        L_0x0d3d:
            r20 = r11
            r2 = 8
            android.widget.TextView r1 = r10.f13002K
            r1.setVisibility(r2)
        L_0x0d46:
            java.util.List r1 = r0.f12926V0
            java.lang.Object r1 = r1.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r1 = (com.finazzi.distquake.FragmentOfficial.i) r1
            int r1 = r1.d0()
            double r1 = (double) r1
            r3 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r1 = r1 / r3
            r3 = 4621819117588971520(0x4024000000000000, double:10.0)
            double r1 = java.lang.Math.pow(r3, r1)
            r5 = 4696837138094751744(0x412e847e00000000, double:999999.0)
            int r5 = (r1 > r5 ? 1 : (r1 == r5 ? 0 : -1))
            if (r5 <= 0) goto L_0x0d8c
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            r6 = 4681608360884174848(0x40f86a0000000000, double:100000.0)
            double r6 = r1 / r6
            long r6 = java.lang.Math.round(r6)
            double r6 = (double) r6
            double r6 = r6 / r3
            r5.append(r6)
            r3 = 2131887113(0x7f120409, float:1.9408824E38)
            java.lang.String r3 = r0.getString(r3)
            r5.append(r3)
            java.lang.String r3 = r5.toString()
            goto L_0x0dc2
        L_0x0d8c:
            r3 = 4651998512748167168(0x408f380000000000, double:999.0)
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x0db9
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            r4 = 4636737291354636288(0x4059000000000000, double:100.0)
            double r4 = r1 / r4
            long r4 = java.lang.Math.round(r4)
            double r4 = (double) r4
            r18 = 4621819117588971520(0x4024000000000000, double:10.0)
            double r4 = r4 / r18
            r3.append(r4)
            r4 = 2131887112(0x7f120408, float:1.9408822E38)
            java.lang.String r4 = r0.getString(r4)
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            goto L_0x0dc2
        L_0x0db9:
            long r3 = java.lang.Math.round(r1)
            int r3 = (int) r3
            java.lang.String r3 = java.lang.Integer.toString(r3)
        L_0x0dc2:
            java.util.List r4 = r0.f12926V0
            java.lang.Object r4 = r4.get(r9)
            com.finazzi.distquake.FragmentOfficial$i r4 = (com.finazzi.distquake.FragmentOfficial.i) r4
            int r4 = r4.d0()
            if (r4 <= 0) goto L_0x0e08
            java.lang.String r4 = r0.f12929Y0
            boolean r4 = r4.equals(r14)
            if (r4 == 0) goto L_0x0df0
            r4 = 2131887107(0x7f120403, float:1.9408812E38)
            java.lang.String r4 = r0.getString(r4)
            r5 = 1
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r28 = 0
            r5[r28] = r3
            java.lang.String r3 = java.lang.String.format(r4, r5)
            android.widget.TextView r4 = r10.f13005N
            r4.setText(r3)
            goto L_0x0e3c
        L_0x0df0:
            r5 = 1
            r28 = 0
            r4 = 2131887106(0x7f120402, float:1.940881E38)
            java.lang.String r4 = r0.getString(r4)
            java.lang.Object[] r5 = new java.lang.Object[r5]
            r5[r28] = r3
            java.lang.String r3 = java.lang.String.format(r4, r5)
            android.widget.TextView r4 = r10.f13005N
            r4.setText(r3)
            goto L_0x0e3c
        L_0x0e08:
            r5 = 1
            r28 = 0
            java.lang.String r3 = r0.f12929Y0
            boolean r3 = r3.equals(r14)
            if (r3 == 0) goto L_0x0e28
            r3 = 2131887107(0x7f120403, float:1.9408812E38)
            java.lang.String r3 = r0.getString(r3)
            java.lang.Object[] r4 = new java.lang.Object[r5]
            r4[r28] = r20
            java.lang.String r3 = java.lang.String.format(r3, r4)
            android.widget.TextView r4 = r10.f13005N
            r4.setText(r3)
            goto L_0x0e3c
        L_0x0e28:
            r3 = 2131887106(0x7f120402, float:1.940881E38)
            java.lang.String r3 = r0.getString(r3)
            java.lang.Object[] r4 = new java.lang.Object[r5]
            r4[r28] = r20
            java.lang.String r3 = java.lang.String.format(r3, r4)
            android.widget.TextView r4 = r10.f13005N
            r4.setText(r3)
        L_0x0e3c:
            r3 = 4692333547057315840(0x411e848000000000, double:500000.0)
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 <= 0) goto L_0x0e4d
            android.widget.TextView r1 = r10.f13005N
            android.graphics.Typeface r2 = android.graphics.Typeface.DEFAULT_BOLD
            r1.setTypeface(r2)
            return
        L_0x0e4d:
            android.widget.TextView r1 = r10.f13005N
            android.graphics.Typeface r2 = android.graphics.Typeface.DEFAULT
            r1.setTypeface(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.FragmentOfficial.I2(int, com.finazzi.distquake.FragmentOfficial$h$b):void");
    }

    /* access modifiers changed from: private */
    public void J2(int i8, boolean z7) {
        G2(i8, 0.0d, 0.0d, z7);
    }

    /* access modifiers changed from: private */
    public void K2(int i8) {
        if (i8 == 0) {
            Collections.sort(this.f12926V0, new K(this));
        }
        if (i8 == 1) {
            Collections.sort(this.f12926V0, new L(this));
        }
        if (i8 == 2) {
            Collections.sort(this.f12926V0, new M());
        }
    }

    /* access modifiers changed from: private */
    public void p2() {
        int i8;
        int i9;
        double d8;
        Paint paint;
        int i10;
        int i11;
        double d9;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int round;
        int round2;
        long round3;
        int round4;
        int round5;
        long round6;
        long round7;
        if (this.f12957t1) {
            ImageView imageView = (ImageView) this.f12944n0.findViewById(C2030R.id.imageView1);
            int j8 = this.f12927W0.j();
            int height = ((ProgressBar) this.f12944n0.findViewById(C2030R.id.progressBar1)).getHeight();
            if (j8 > 0) {
                int width = imageView.getWidth();
                int height2 = imageView.getHeight() + height;
                if (width > 0 && height2 > 0) {
                    this.f12951q1 = Bitmap.createBitmap(width, height2, Bitmap.Config.ARGB_8888);
                    Canvas canvas = new Canvas(this.f12951q1);
                    Paint paint2 = new Paint();
                    this.f12953r1 = ((double) height2) / ((double) j8);
                    int i17 = 0;
                    while (i17 < j8) {
                        double z7 = ((i) this.f12927W0.E(i17)).Z();
                        if (z7 > -999.0d) {
                            if (this.f12941k1) {
                                int i18 = getResources().getConfiguration().uiMode & 48;
                                d8 = 20.0d;
                                if (z7 < 2.0d) {
                                    double d10 = 1.0d - ((z7 - 0.0d) / 2.0d);
                                    if (i18 == 16) {
                                        d9 = 5.5d;
                                        i13 = (int) Math.round((d10 * 33.0d) + 179.0d);
                                        i12 = (int) Math.round((19.0d * d10) + 210.0d);
                                        paint = paint2;
                                        round7 = Math.round((d10 * 13.0d) + 223.0d);
                                    } else {
                                        paint = paint2;
                                        d9 = 5.5d;
                                        i13 = (int) Math.round((d10 * 21.0d) + 49.0d);
                                        i12 = (int) Math.round((32.0d * d10) + 73.0d);
                                        round7 = Math.round((d10 * 43.0d) + 97.0d);
                                    }
                                    i14 = (int) round7;
                                } else {
                                    paint = paint2;
                                    d9 = 5.5d;
                                    i14 = 0;
                                    i13 = 0;
                                    i12 = 0;
                                }
                                if (z7 < 2.0d || z7 >= 3.5d) {
                                    i9 = width;
                                } else {
                                    double d11 = 1.0d - ((z7 - 2.0d) / 1.5d);
                                    if (i18 == 16) {
                                        round4 = (int) Math.round((64.0d * d11) + 136.0d);
                                        i9 = width;
                                        round5 = (int) Math.round((51.0d * d11) + 175.0d);
                                        round6 = Math.round((d11 * 65.0d) + 131.0d);
                                    } else {
                                        i9 = width;
                                        round4 = (int) Math.round((d11 * 21.0d) + 28.0d);
                                        round5 = (int) Math.round((46.0d * d11) + 65.0d);
                                        round6 = Math.round((d11 * 16.0d) + 21.0d);
                                    }
                                    i14 = (int) round6;
                                }
                                if (z7 >= 3.5d && z7 < 4.5d) {
                                    double d12 = 1.0d - ((z7 - 3.5d) / 1.0d);
                                    if (i18 == 16) {
                                        i12 = (int) Math.round((d12 * 20.0d) + 233.0d);
                                        i14 = (int) Math.round((d12 * 30.0d) + 179.0d);
                                        i13 = 252;
                                    } else {
                                        i13 = (int) Math.round((57.0d * d12) + 132.0d);
                                        i12 = (int) Math.round((43.0d * d12) + 101.0d);
                                        i14 = (int) Math.round((d12 * 3.0d) + 6.0d);
                                    }
                                }
                                if (z7 < 4.5d || z7 >= d9) {
                                    i16 = i14;
                                    i15 = i13;
                                } else {
                                    double d13 = 1.0d - ((z7 - 4.5d) / 1.0d);
                                    if (i18 == 16) {
                                        i12 = (int) Math.round((38.0d * d13) + 159.0d);
                                        i16 = (int) Math.round((d13 * 36.0d) + 161.0d);
                                        i15 = 252;
                                    } else {
                                        i15 = (int) Math.round((61.0d * d13) + 111.0d);
                                        i12 = (int) Math.round((d13 * 1.0d) + 1.0d);
                                        i16 = (int) Math.round((d13 * 12.0d) + 21.0d);
                                    }
                                }
                                if (z7 >= d9) {
                                    double d14 = 1.0d - ((z7 - d9) / 4.5d);
                                    if (i18 == 16) {
                                        round = (int) Math.round((88.0d * d14) + 123.0d);
                                        round2 = (int) Math.round((54.0d * d14) + 33.0d);
                                        round3 = Math.round((d14 * 96.0d) + 159.0d);
                                    } else {
                                        double d15 = (81.0d * d14) + 115.0d;
                                        round = (int) Math.round(d15);
                                        round2 = (int) Math.round((d14 * 2.0d) + 3.0d);
                                        round3 = Math.round(d15);
                                    }
                                    i16 = (int) round3;
                                }
                                i10 = Color.rgb(i15, i12, i16);
                            } else {
                                i9 = width;
                                paint = paint2;
                                d8 = 20.0d;
                                if (z7 < 2.0d) {
                                    i10 = Color.argb(100, 12, 115, 160);
                                } else {
                                    i10 = 0;
                                }
                                if (z7 >= 2.0d && z7 < 3.5d) {
                                    i10 = Color.argb(100, 12, 160, 35);
                                }
                                if (z7 < 3.5d || z7 >= 4.5d) {
                                    i11 = 0;
                                } else {
                                    i11 = 0;
                                    i10 = Color.argb(100, 244, 195, 0);
                                }
                                if (z7 >= 4.5d && z7 < 5.5d) {
                                    i10 = Color.argb(100, 255, i11, i11);
                                }
                                if (z7 >= 5.5d) {
                                    i10 = Color.argb(100, 183, 60, 252);
                                }
                            }
                            if (this.f12953r1 > d8) {
                                paint2 = paint;
                                paint2.setStyle(Paint.Style.FILL);
                                paint2.setColor(i10);
                                double d16 = (double) i17;
                                double d17 = this.f12953r1;
                                double d18 = d17;
                                float f8 = (float) (d16 * d17);
                                i8 = i9;
                                float f9 = (float) i8;
                                double d19 = (double) (i17 + 1);
                                double d20 = d19;
                                canvas.drawRect(BitmapDescriptorFactory.HUE_RED, f8, f9, (float) (d18 * d19), paint2);
                                paint2.setStyle(Paint.Style.STROKE);
                                paint2.setStrokeWidth(2.0f);
                                paint2.setColor(Color.rgb(175, 175, 175));
                                double d21 = this.f12953r1;
                                canvas.drawRect(BitmapDescriptorFactory.HUE_RED, (float) (d16 * d21), f9, (float) (d21 * d20), paint2);
                            } else {
                                paint2 = paint;
                                i8 = i9;
                                paint2.setStyle(Paint.Style.FILL);
                                paint2.setColor(i10);
                                double d22 = this.f12953r1;
                                canvas.drawRect(BitmapDescriptorFactory.HUE_RED, (float) (((double) i17) * d22), (float) i8, (float) (((double) (i17 + 1)) * d22), paint2);
                            }
                        } else {
                            i8 = width;
                        }
                        i17++;
                        width = i8;
                    }
                    imageView.setImageBitmap(this.f12951q1);
                    imageView.setVisibility(0);
                    return;
                }
                return;
            }
            imageView.setVisibility(8);
        }
    }

    /* access modifiers changed from: private */
    public void q2() {
        float f8;
        ((ProgressBar) this.f12944n0.findViewById(C2030R.id.progressBar1)).setVisibility(0);
        ((TextView) this.f12944n0.findViewById(C2030R.id.textView15)).setVisibility(8);
        if (A2()) {
            C0891s activity = getActivity();
            if (activity != null) {
                int i8 = this.f12923S0;
                if (i8 == 2 || i8 == 3) {
                    f8 = 2.0f;
                } else {
                    f8 = BitmapDescriptorFactory.HUE_RED;
                }
                new g(this, f8, "ALL", (a) null).execute(new Context[]{activity});
                return;
            }
            this.f12912H0 = 0.0d;
            this.f12913I0 = 0.0d;
            return;
        }
        this.f12912H0 = 0.0d;
        this.f12913I0 = 0.0d;
        C0891s activity2 = getActivity();
        if (activity2 != null) {
            Toast makeText = Toast.makeText(activity2, getString(C2030R.string.main_nointernet), 1);
            makeText.setGravity(17, 0, 0);
            makeText.show();
        }
        ((ProgressBar) this.f12944n0.findViewById(C2030R.id.progressBar1)).setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:112:0x01cb, code lost:
        if (r0.f12950q0[r11] < 2.0d) goto L_0x01cd;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void r2(int r26) {
        /*
            r25 = this;
            r0 = r25
            r9 = r26
            java.lang.String r10 = "EMSC"
            double[] r1 = r0.f12946o0
            r12 = 2131886336(0x7f120100, float:1.9407248E38)
            r13 = 2131297063(0x7f090327, float:1.821206E38)
            r14 = 1
            if (r1 == 0) goto L_0x02ad
            java.util.List r1 = r0.f12926V0
            r1.clear()
            r1 = 0
            r2 = 0
        L_0x0018:
            double[] r3 = r0.f12946o0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            int r3 = r3.length     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r4 = 3
            if (r1 >= r3) goto L_0x025d
            r3 = -2
            r16 = r14
        L_0x0021:
            r5 = 2
            if (r3 > r5) goto L_0x00d3
            if (r3 == 0) goto L_0x00cd
            int r6 = r1 + r3
            if (r6 < 0) goto L_0x00cd
            double[] r7 = r0.f12946o0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            int r8 = r7.length     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            if (r6 >= r8) goto L_0x00cd
            r17 = r7[r1]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r19 = r7[r6]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            double r17 = r17 - r19
            double r7 = java.lang.Math.abs(r17)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r17 = 0
            double[] r15 = r0.f12948p0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r18 = r15[r1]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r20 = r15[r6]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            double r18 = r18 - r20
            double r18 = java.lang.Math.abs(r18)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            java.lang.String[] r15 = r0.f12964x0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r15 = r15[r1]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            int r15 = r0.t2(r15)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            java.lang.String[] r11 = r0.f12964x0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r11 = r11[r6]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            int r11 = r0.t2(r11)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            int r15 = r15 - r11
            int r11 = java.lang.Math.abs(r15)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            double[] r15 = r0.f12950q0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r21 = r15[r1]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r23 = r15[r6]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            double r21 = r21 / r23
            r23 = 4605380978949069210(0x3fe999999999999a, double:0.8)
            int r15 = (r21 > r23 ? 1 : (r21 == r23 ? 0 : -1))
            if (r15 <= 0) goto L_0x00cf
            r23 = 4608083138725491507(0x3ff3333333333333, double:1.2)
            int r15 = (r21 > r23 ? 1 : (r21 == r23 ? 0 : -1))
            if (r15 >= 0) goto L_0x00cf
            r21 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            int r7 = (r7 > r21 ? 1 : (r7 == r21 ? 0 : -1))
            if (r7 >= 0) goto L_0x00cf
            int r7 = (r18 > r21 ? 1 : (r18 == r21 ? 0 : -1))
            if (r7 >= 0) goto L_0x00cf
            if (r11 > r5) goto L_0x00cf
            java.lang.String[] r5 = r0.f12962w0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r7 = r5[r1]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r5 = r5[r6]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            boolean r5 = r7.equals(r5)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            if (r5 != 0) goto L_0x00cf
            java.lang.String[] r5 = r0.f12962w0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r5 = r5[r1]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            boolean r5 = r5.equals(r10)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            if (r5 == 0) goto L_0x009a
            r16 = r17
        L_0x009a:
            java.lang.String[] r5 = r0.f12962w0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r5 = r5[r1]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            java.lang.String r7 = "INPRES"
            boolean r5 = r5.equals(r7)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            if (r5 == 0) goto L_0x00b4
            java.lang.String[] r5 = r0.f12962w0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r5 = r5[r6]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            java.lang.String r7 = "CSN"
            boolean r5 = r5.equals(r7)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            if (r5 == 0) goto L_0x00b4
            r16 = r17
        L_0x00b4:
            java.lang.String[] r5 = r0.f12962w0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r5 = r5[r1]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            java.lang.String r7 = "USGS"
            boolean r5 = r5.equals(r7)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            if (r5 == 0) goto L_0x00cf
            java.lang.String[] r5 = r0.f12962w0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r5 = r5[r6]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            boolean r5 = r5.equals(r10)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            if (r5 != 0) goto L_0x00cf
            r16 = r17
            goto L_0x00cf
        L_0x00cd:
            r17 = 0
        L_0x00cf:
            int r3 = r3 + 1
            goto L_0x0021
        L_0x00d3:
            r17 = 0
            if (r16 == 0) goto L_0x01d9
            if (r9 != 0) goto L_0x0105
            r15 = r1
            r3 = r2
            double r1 = r0.f12910F0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r5 = r3
            double r3 = r0.f12911G0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            double[] r6 = r0.f12946o0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r7 = r6[r15]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            double[] r6 = r0.f12948p0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r18 = r6[r15]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r11 = r15
            r15 = r5
            r5 = r7
            r7 = r18
            double r1 = r0.z2(r1, r3, r5, r7)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            float r1 = (float) r1     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            float r2 = r0.f12914J0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 > 0) goto L_0x01cd
            double[] r1 = r0.f12950q0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r2 = r1[r11]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            float r1 = r0.f12915K0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            double r4 = (double) r1     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            int r1 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r1 >= 0) goto L_0x01db
            goto L_0x01cd
        L_0x0105:
            r11 = r1
            r15 = r2
            r18 = 4611686018427387904(0x4000000000000000, double:2.0)
            if (r9 != r14) goto L_0x01c3
            double r1 = r0.f12910F0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            double r3 = r0.f12911G0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            double[] r5 = r0.f12946o0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r6 = r5[r11]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            double[] r5 = r0.f12948p0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r21 = r5[r11]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r5 = r6
            r7 = r21
            double r1 = r0.z2(r1, r3, r5, r7)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            float r1 = (float) r1     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            double[] r2 = r0.f12950q0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r3 = r2[r11]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r5 = 4619567317775286272(0x401c000000000000, double:7.0)
            int r2 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x0131
            r2 = 1157234688(0x44fa0000, float:2000.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x0131
            goto L_0x01cd
        L_0x0131:
            r5 = 4619004367821864960(0x401a000000000000, double:6.5)
            int r2 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x013f
            r2 = 1153957888(0x44c80000, float:1600.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x013f
            goto L_0x01cd
        L_0x013f:
            r5 = 4618441417868443648(0x4018000000000000, double:6.0)
            int r2 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x014e
            r2 = 1151500288(0x44a28000, float:1300.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x014e
            goto L_0x01cd
        L_0x014e:
            r5 = 4617878467915022336(0x4016000000000000, double:5.5)
            int r2 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x015c
            r2 = 1148846080(0x447a0000, float:1000.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x015c
            goto L_0x01cd
        L_0x015c:
            r5 = 4617315517961601024(0x4014000000000000, double:5.0)
            int r2 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x016a
            r2 = 1143930880(0x442f0000, float:700.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x016a
            goto L_0x01cd
        L_0x016a:
            r5 = 4616752568008179712(0x4012000000000000, double:4.5)
            int r2 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x0177
            r2 = 1140457472(0x43fa0000, float:500.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x0177
            goto L_0x01cd
        L_0x0177:
            r5 = 4616189618054758400(0x4010000000000000, double:4.0)
            int r2 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x0184
            r2 = 1135542272(0x43af0000, float:350.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x0184
            goto L_0x01cd
        L_0x0184:
            r5 = 4615063718147915776(0x400c000000000000, double:3.5)
            int r2 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x0191
            r2 = 1128792064(0x43480000, float:200.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x0191
            goto L_0x01cd
        L_0x0191:
            r5 = 4613937818241073152(0x4008000000000000, double:3.0)
            int r2 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x019e
            r2 = 1123680256(0x42fa0000, float:125.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x019e
            goto L_0x01cd
        L_0x019e:
            r5 = 4612811918334230528(0x4004000000000000, double:2.5)
            int r2 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x01ab
            r2 = 1116471296(0x428c0000, float:70.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x01ab
            goto L_0x01cd
        L_0x01ab:
            int r2 = (r3 > r18 ? 1 : (r3 == r18 ? 0 : -1))
            if (r2 >= 0) goto L_0x01b6
            r2 = 1108082688(0x420c0000, float:35.0)
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x01b6
            goto L_0x01cd
        L_0x01b6:
            r5 = 4609434218613702656(0x3ff8000000000000, double:1.5)
            int r2 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r2 >= 0) goto L_0x01db
            r2 = 1101004800(0x41a00000, float:20.0)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 <= 0) goto L_0x01db
            goto L_0x01cd
        L_0x01c3:
            if (r9 != r5) goto L_0x01d0
            double[] r1 = r0.f12950q0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r2 = r1[r11]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            int r1 = (r2 > r18 ? 1 : (r2 == r18 ? 0 : -1))
            if (r1 >= 0) goto L_0x01db
        L_0x01cd:
            r16 = r17
            goto L_0x01db
        L_0x01d0:
            if (r9 != r4) goto L_0x01db
            int[] r1 = r0.f12906B0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r1 = r1[r11]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            if (r1 >= r5) goto L_0x01db
            goto L_0x01cd
        L_0x01d9:
            r11 = r1
            r15 = r2
        L_0x01db:
            if (r16 == 0) goto L_0x0254
            boolean[] r1 = r0.f12908D0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r1[r11] = r14     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            com.finazzi.distquake.FragmentOfficial$i r1 = new com.finazzi.distquake.FragmentOfficial$i     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r2 = 0
            r1.<init>(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            double[] r2 = r0.f12946o0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r3 = r2[r11]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r1.o0(r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            double[] r2 = r0.f12948p0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r3 = r2[r11]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r1.q0(r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            double[] r2 = r0.f12950q0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r3 = r2[r11]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r1.r0(r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            java.lang.String[] r2 = r0.f12952r0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r2 = r2[r11]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r1.t0(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            double[] r2 = r0.f12956t0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r3 = r2[r11]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r1.l0(r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            java.lang.String[] r2 = r0.f12958u0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r2 = r2[r11]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r1.p0(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            int[] r2 = r0.f12960v0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r2 = r2[r11]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r1.v0(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            java.lang.String[] r2 = r0.f12962w0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r2 = r2[r11]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r1.x0(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            java.lang.String[] r2 = r0.f12964x0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r2 = r2[r11]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r1.k0(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            int[] r2 = r0.f12966z0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r2 = r2[r11]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r1.w0(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            double[] r2 = r0.f12965y0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r3 = r2[r11]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r1.s0(r3)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            int[] r2 = r0.f12905A0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r2 = r2[r11]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r1.A0(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            int[] r2 = r0.f12906B0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r2 = r2[r11]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r1.y0(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            int[] r2 = r0.f12907C0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r2 = r2[r11]     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r1.n0(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r1.u0(r15)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            com.finazzi.distquake.FragmentOfficial$h r2 = r0.f12927W0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r2.D(r1)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            int r2 = r15 + 1
            goto L_0x0259
        L_0x0254:
            boolean[] r1 = r0.f12908D0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r1[r11] = r17     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r2 = r15
        L_0x0259:
            int r1 = r11 + 1
            goto L_0x0018
        L_0x025d:
            r15 = r2
            r17 = 0
            r0.f12909E0 = r15     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            android.view.View r1 = r0.f12944n0     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            android.view.View r1 = r1.findViewById(r13)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            android.widget.TextView r1 = (android.widget.TextView) r1     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            if (r15 != 0) goto L_0x028c
            if (r9 == 0) goto L_0x0270
            if (r9 != r4) goto L_0x0274
        L_0x0270:
            r2 = 2131886335(0x7f1200ff, float:1.9407246E38)
            goto L_0x0280
        L_0x0274:
            if (r9 != r14) goto L_0x027d
            java.lang.String r2 = r0.getString(r12)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r1.setText(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
        L_0x027d:
            r2 = r17
            goto L_0x0288
        L_0x0280:
            java.lang.String r2 = r0.getString(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            r1.setText(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            goto L_0x027d
        L_0x0288:
            r1.setVisibility(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            return
        L_0x028c:
            r2 = 8
            r1.setVisibility(r2)     // Catch:{ ArrayIndexOutOfBoundsException -> 0x0292 }
            return
        L_0x0292:
            androidx.fragment.app.s r1 = r0.getActivity()
            if (r1 == 0) goto L_0x02ac
            r2 = 2131886679(0x7f120257, float:1.9407944E38)
            java.lang.String r2 = r0.getString(r2)
            r3 = 0
            android.widget.Toast r1 = android.widget.Toast.makeText(r1, r2, r3)
            r2 = 17
            r1.setGravity(r2, r3, r3)
            r1.show()
        L_0x02ac:
            return
        L_0x02ad:
            android.view.View r1 = r0.f12944n0
            android.view.View r1 = r1.findViewById(r13)
            android.widget.TextView r1 = (android.widget.TextView) r1
            if (r9 != 0) goto L_0x02c3
            r2 = 2131886335(0x7f1200ff, float:1.9407246E38)
            java.lang.String r2 = r0.getString(r2)
            r1.setText(r2)
        L_0x02c1:
            r2 = 0
            goto L_0x02cd
        L_0x02c3:
            if (r9 != r14) goto L_0x02c1
            java.lang.String r2 = r0.getString(r12)
            r1.setText(r2)
            goto L_0x02c1
        L_0x02cd:
            r1.setVisibility(r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.FragmentOfficial.r2(int):void");
    }

    public static /* synthetic */ void s0(FragmentOfficial fragmentOfficial, Button button, View view) {
        FragmentOfficial fragmentOfficial2 = fragmentOfficial;
        Button button2 = button;
        ((TextView) fragmentOfficial2.f12944n0.findViewById(C2030R.id.textView14)).setVisibility(8);
        C0891s activity = fragmentOfficial2.getActivity();
        if (activity != null) {
            View inflate = ((LayoutInflater) activity.getSystemService("layout_inflater")).inflate(C2030R.layout.filter_layout, (ViewGroup) null);
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            ((TextView) inflate.findViewById(C2030R.id.textView4)).setTextColor(((RadioButton) inflate.findViewById(C2030R.id.radioButton1)).getCurrentTextColor());
            if (!fragmentOfficial2.B2()) {
                ((RadioButton) inflate.findViewById(C2030R.id.radioButton1)).setEnabled(false);
                ((RadioButton) inflate.findViewById(C2030R.id.radioButton2)).setEnabled(false);
                ((TextView) inflate.findViewById(C2030R.id.textView1)).setVisibility(0);
                ((TextView) inflate.findViewById(C2030R.id.textView2)).setVisibility(0);
                ((SeekBar) inflate.findViewById(C2030R.id.seekBar)).setEnabled(false);
                ((SeekBar) inflate.findViewById(C2030R.id.seekBar2)).setEnabled(false);
                int i8 = fragmentOfficial2.f12923S0;
                if (i8 < 2) {
                    fragmentOfficial2.f12923S0 = 2;
                    fragmentOfficial2.f12925U0.putInt("filter_type", 2);
                    fragmentOfficial2.f12925U0.apply();
                    button2.setText(fragmentOfficial2.getString(C2030R.string.filter_all));
                    ((RadioButton) inflate.findViewById(C2030R.id.radioButton3)).setChecked(true);
                } else if (i8 == 2) {
                    ((RadioButton) inflate.findViewById(C2030R.id.radioButton3)).setChecked(true);
                } else if (i8 == 3) {
                    ((RadioButton) inflate.findViewById(C2030R.id.radioButton4)).setChecked(true);
                }
            } else {
                ((TextView) inflate.findViewById(C2030R.id.textView1)).setVisibility(8);
                ((TextView) inflate.findViewById(C2030R.id.textView1)).setVisibility(8);
            }
            RadioButton radioButton = (RadioButton) inflate.findViewById(C2030R.id.radioButton1);
            if (fragmentOfficial2.f12923S0 == 0) {
                radioButton.setChecked(true);
                ((SeekBar) inflate.findViewById(C2030R.id.seekBar)).setEnabled(true);
                ((SeekBar) inflate.findViewById(C2030R.id.seekBar2)).setEnabled(true);
            }
            RadioButton radioButton2 = (RadioButton) inflate.findViewById(C2030R.id.radioButton2);
            if (fragmentOfficial2.f12923S0 == 1) {
                radioButton2.setChecked(true);
                ((SeekBar) inflate.findViewById(C2030R.id.seekBar)).setEnabled(false);
                ((SeekBar) inflate.findViewById(C2030R.id.seekBar2)).setEnabled(false);
            }
            RadioButton radioButton3 = (RadioButton) inflate.findViewById(C2030R.id.radioButton3);
            if (fragmentOfficial2.f12923S0 == 2) {
                radioButton3.setChecked(true);
                ((SeekBar) inflate.findViewById(C2030R.id.seekBar)).setEnabled(false);
                ((SeekBar) inflate.findViewById(C2030R.id.seekBar2)).setEnabled(false);
            }
            RadioButton radioButton4 = (RadioButton) inflate.findViewById(C2030R.id.radioButton4);
            if (fragmentOfficial2.f12923S0 == 3) {
                radioButton4.setChecked(true);
                ((SeekBar) inflate.findViewById(C2030R.id.seekBar)).setEnabled(false);
                ((SeekBar) inflate.findViewById(C2030R.id.seekBar2)).setEnabled(false);
            }
            ((RadioGroup) inflate.findViewById(C2030R.id.radioGroup)).setOnCheckedChangeListener(new C1783f1(fragmentOfficial2, inflate, button2));
            SeekBar seekBar = (SeekBar) inflate.findViewById(C2030R.id.seekBar);
            TextView textView = (TextView) inflate.findViewById(C2030R.id.textView3);
            float f8 = fragmentOfficial2.f12914J0;
            if (f8 == 100.0f) {
                if (fragmentOfficial2.f12929Y0.equals("0")) {
                    textView.setText("100 km");
                } else {
                    textView.setText("60 mi");
                }
                seekBar.setProgress(0);
            } else if (f8 == 250.0f) {
                if (fragmentOfficial2.f12929Y0.equals("0")) {
                    textView.setText("250 km");
                } else {
                    textView.setText("150 mi");
                }
                seekBar.setProgress(1);
            } else if (f8 == 500.0f) {
                if (fragmentOfficial2.f12929Y0.equals("0")) {
                    textView.setText("500 km");
                } else {
                    textView.setText("300 mi");
                }
                seekBar.setProgress(2);
            } else if (f8 == 750.0f) {
                if (fragmentOfficial2.f12929Y0.equals("0")) {
                    textView.setText("750 km");
                } else {
                    textView.setText("450 mi");
                }
                seekBar.setProgress(3);
            } else if (f8 == 1000.0f) {
                if (fragmentOfficial2.f12929Y0.equals("0")) {
                    textView.setText("1000 km");
                } else {
                    textView.setText("600 mi");
                }
                seekBar.setProgress(4);
            } else if (f8 == 1500.0f) {
                if (fragmentOfficial2.f12929Y0.equals("0")) {
                    textView.setText("1500 km");
                } else {
                    textView.setText("950 mi");
                }
                seekBar.setProgress(5);
            } else {
                if (fragmentOfficial2.f12929Y0.equals("0")) {
                    textView.setText("2000 km");
                } else {
                    textView.setText("1200 mi");
                }
                seekBar.setProgress(6);
            }
            seekBar.setOnSeekBarChangeListener(new b(inflate));
            SeekBar seekBar2 = (SeekBar) inflate.findViewById(C2030R.id.seekBar2);
            TextView textView2 = (TextView) inflate.findViewById(C2030R.id.textView5);
            double d8 = (double) fragmentOfficial2.f12915K0;
            if (d8 == 0.0d) {
                textView2.setText("M0.0");
                seekBar2.setProgress(0);
            } else if (d8 == 1.0d) {
                textView2.setText("M1.0");
                seekBar2.setProgress(1);
            } else if (d8 == 2.0d) {
                textView2.setText("M2.0");
                seekBar2.setProgress(2);
            } else if (d8 == 3.0d) {
                textView2.setText("M3.0");
                seekBar2.setProgress(3);
            } else if (d8 == 4.0d) {
                textView2.setText("M4.0");
                seekBar2.setProgress(4);
            } else if (d8 == 5.0d) {
                textView2.setText("M5.0");
                seekBar2.setProgress(5);
            } else if (d8 == 6.0d) {
                textView2.setText("M6.0");
                seekBar2.setProgress(6);
            }
            seekBar2.setOnSeekBarChangeListener(new c(inflate));
            builder.setCancelable(true);
            builder.setView(inflate);
            builder.setTitle(fragmentOfficial2.getString(C2030R.string.filter_filter));
            builder.setNegativeButton(fragmentOfficial2.getString(C2030R.string.main_exit), new X0());
            builder.create();
            builder.show();
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x01a6  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x01b7  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x01bd  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x01c1 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.achartengine.b s2(double r34, double r36, java.lang.String r38, double r39) {
        /*
            r33 = this;
            r1 = r33
            r10 = r38
            r11 = 0
            r12 = 1
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r2 = 2131886872(0x7f120318, float:1.9408335E38)
            java.lang.String r2 = r1.getString(r2)
            r0.append(r2)
            java.lang.String r2 = " "
            r0.append(r2)
            r0.append(r10)
            java.lang.String r0 = r0.toString()
            d7.c r13 = new d7.c
            r13.<init>(r0)
            d7.c r14 = new d7.c
            r0 = 2131886892(0x7f12032c, float:1.9408376E38)
            java.lang.String r0 = r1.getString(r0)
            r14.<init>(r0)
            d7.d r15 = new d7.d
            r15.<init>()
            e7.d r2 = new e7.d
            r2.<init>()
            e7.e r0 = new e7.e
            r0.<init>()
            e7.e r3 = new e7.e
            r3.<init>()
            double[] r4 = r1.f12946o0
            r16 = 0
            if (r4 == 0) goto L_0x02ac
            r15.a(r13)
            r15.a(r14)
            r4 = 255(0xff, float:3.57E-43)
            int r5 = android.graphics.Color.rgb(r4, r11, r11)
            r0.f(r5)
            r0.t(r12)
            c7.d r5 = c7.d.CIRCLE
            r0.v(r5)
            int r6 = android.graphics.Color.rgb(r11, r11, r4)
            r3.f(r6)
            r3.t(r12)
            r3.v(r5)
            r2.a(r0)
            r2.a(r3)
            r2.D1(r11, r11)
            r2.g1(r11)
            r0 = 1103101952(0x41c00000, float:24.0)
            r2.U(r0)
            r2.T(r0)
            r0 = 1104150528(0x41d00000, float:26.0)
            r2.Q(r0)
            r0 = 1096810496(0x41600000, float:14.0)
            r2.c1(r0)
            int r0 = android.graphics.Color.rgb(r4, r4, r4)
            r2.O(r0)
            int r0 = android.graphics.Color.rgb(r4, r4, r4)
            r2.f1(r0)
            r0 = 150(0x96, float:2.1E-43)
            int r0 = android.graphics.Color.rgb(r0, r0, r0)
            r2.d1(r0)
            r0 = 10
            r2.o1(r0)
            r0 = 5
            r2.v1(r0)
            r0 = 1102053376(0x41b00000, float:22.0)
            r2.z1(r0)
            android.graphics.Paint$Align r3 = android.graphics.Paint.Align.CENTER
            r2.w1(r3)
            r3 = -1055916032(0xffffffffc1100000, float:-9.0)
            r2.A1(r3)
            int r3 = android.graphics.Color.rgb(r11, r11, r11)
            r2.y1(r11, r3)
            int r3 = android.graphics.Color.rgb(r11, r11, r11)
            r2.p1(r3)
            int r3 = android.graphics.Color.rgb(r11, r11, r11)
            r2.b0(r3)
            int r3 = android.graphics.Color.rgb(r11, r11, r11)
            r2.c0(r3)
            r2.c1(r0)
            java.text.DecimalFormat r0 = new java.text.DecimalFormat
            java.lang.String r3 = "0.0"
            r0.<init>(r3)
            r2.u1(r0, r11)
            r0 = 70
            r5 = 40
            int[] r0 = new int[]{r5, r0, r5, r5}
            r2.V(r0)
            r2.W(r12)
            r0 = 2131887104(0x7f120400, float:1.9408806E38)
            java.lang.String r0 = r1.getString(r0)
            r2.B1(r0)
            r0 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r2.N(r0)
            r2.S(r0)
            r0 = 1084227584(0x40a00000, float:5.0)
            r2.i1(r0)
            r2.R(r12)
            r17 = 0
            r5 = 4621819117588971520(0x4024000000000000, double:10.0)
            r7 = 0
            r19 = r5
            r21 = r7
            r5 = r11
            r6 = r5
            r23 = r17
            r25 = r23
            r27 = r25
        L_0x0120:
            double[] r0 = r1.f12946o0
            int r7 = r0.length
            if (r5 >= r7) goto L_0x01cf
            r7 = r0[r5]
            double[] r0 = r1.f12948p0
            r29 = r0[r5]
            r32 = r5
            r31 = r11
            r4 = r36
            r11 = r6
            r6 = r7
            r8 = r29
            r29 = r12
            r30 = r15
            r12 = r2
            r15 = r3
            r2 = r34
            double r6 = r1.z2(r2, r4, r6, r8)
            java.lang.String[] r0 = r1.f12962w0
            r0 = r0[r32]
            boolean r0 = r0.equals(r10)
            if (r0 == 0) goto L_0x01c0
            float r0 = r1.f12914J0
            double r2 = (double) r0
            int r0 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            if (r0 > 0) goto L_0x01c0
            java.text.SimpleDateFormat r0 = new java.text.SimpleDateFormat
            java.lang.String r2 = "yyyy-MM-dd HH:mm:ss"
            java.util.Locale r3 = java.util.Locale.getDefault()
            r0.<init>(r2, r3)
            java.lang.String[] r2 = r1.f12964x0     // Catch:{ ParseException -> 0x0182 }
            r2 = r2[r32]     // Catch:{ ParseException -> 0x0182 }
            java.util.Date r0 = r0.parse(r2)     // Catch:{ ParseException -> 0x0182 }
            double[] r2 = r1.f12950q0     // Catch:{ ParseException -> 0x0182 }
            r3 = r2[r32]     // Catch:{ ParseException -> 0x0182 }
            r13.t(r0, r3)     // Catch:{ ParseException -> 0x0182 }
            double[] r2 = r1.f12950q0     // Catch:{ ParseException -> 0x0182 }
            r3 = r2[r32]     // Catch:{ ParseException -> 0x0182 }
            double r23 = r23 + r3
            if (r11 <= 0) goto L_0x0185
            long r2 = r0.getTime()     // Catch:{ ParseException -> 0x0182 }
            long r2 = r2 - r21
            long r2 = java.lang.Math.abs(r2)     // Catch:{ ParseException -> 0x0182 }
            double r2 = (double) r2     // Catch:{ ParseException -> 0x0182 }
            double r25 = r25 + r2
            goto L_0x0185
        L_0x0182:
            r0 = move-exception
            r6 = r11
            goto L_0x01a0
        L_0x0185:
            long r21 = r0.getTime()     // Catch:{ ParseException -> 0x0182 }
            int r2 = r11 + 1
            int r3 = (r6 > r17 ? 1 : (r6 == r17 ? 0 : -1))
            if (r3 != 0) goto L_0x019e
            double[] r3 = r1.f12950q0     // Catch:{ ParseException -> 0x019b }
            r4 = r3[r32]     // Catch:{ ParseException -> 0x019b }
            int r3 = (r4 > r39 ? 1 : (r4 == r39 ? 0 : -1))
            if (r3 != 0) goto L_0x019e
            r14.t(r0, r4)     // Catch:{ ParseException -> 0x019b }
            goto L_0x019e
        L_0x019b:
            r0 = move-exception
            r6 = r2
            goto L_0x01a0
        L_0x019e:
            r6 = r2
            goto L_0x01af
        L_0x01a0:
            java.lang.String r2 = r0.getMessage()
            if (r2 == 0) goto L_0x01af
            java.lang.String r2 = "EQN"
            java.lang.String r0 = r0.getMessage()
            android.util.Log.d(r2, r0)
        L_0x01af:
            double[] r0 = r1.f12950q0
            r2 = r0[r32]
            int r0 = (r2 > r27 ? 1 : (r2 == r27 ? 0 : -1))
            if (r0 <= 0) goto L_0x01b9
            r27 = r2
        L_0x01b9:
            int r0 = (r2 > r19 ? 1 : (r2 == r19 ? 0 : -1))
            if (r0 >= 0) goto L_0x01c1
            r19 = r2
            goto L_0x01c1
        L_0x01c0:
            r6 = r11
        L_0x01c1:
            int r5 = r32 + 1
            r2 = r12
            r3 = r15
            r12 = r29
            r15 = r30
            r11 = r31
            r4 = 255(0xff, float:3.57E-43)
            goto L_0x0120
        L_0x01cf:
            r31 = r11
            r29 = r12
            r30 = r15
            r12 = r2
            r15 = r3
            r11 = r6
            if (r11 <= 0) goto L_0x0249
            java.text.DecimalFormat r0 = new java.text.DecimalFormat
            java.lang.String r2 = "0.00"
            r0.<init>(r2)
            double r2 = (double) r11
            double r2 = r23 / r2
            int r6 = r11 + -1
            double r4 = (double) r6
            double r25 = r25 / r4
            r4 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r25 = r25 / r4
            r4 = 4633641066610819072(0x404e000000000000, double:60.0)
            double r6 = r25 / r4
            int r8 = (r6 > r4 ? 1 : (r6 == r4 ? 0 : -1))
            if (r8 >= 0) goto L_0x0215
            java.text.DecimalFormat r4 = new java.text.DecimalFormat
            java.lang.String r5 = "0"
            r4.<init>(r5)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r4 = r4.format(r6)
            r5.append(r4)
            java.lang.String r4 = "m"
            r5.append(r4)
            java.lang.String r4 = r5.toString()
            goto L_0x0230
        L_0x0215:
            java.text.DecimalFormat r8 = new java.text.DecimalFormat
            r8.<init>(r15)
            double r6 = r6 / r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = r8.format(r6)
            r4.append(r5)
            java.lang.String r5 = "h"
            r4.append(r5)
            java.lang.String r4 = r4.toString()
        L_0x0230:
            java.lang.String r0 = r0.format(r2)
            r2 = 2131886871(0x7f120317, float:1.9408333E38)
            java.lang.String r2 = r1.getString(r2)
            r3 = 2
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r31] = r0
            r3[r29] = r4
            java.lang.String r0 = java.lang.String.format(r2, r3)
            r12.P(r0)
        L_0x0249:
            r2 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            double r4 = r19 - r2
            r12.s1(r4)
            double r2 = r27 + r2
            r12.q1(r2)
            double r2 = r13.h()
            double r4 = r13.j()
            double r2 = r2 - r4
            double r4 = r13.j()
            r6 = 4624633867356078080(0x402e000000000000, double:15.0)
            double r2 = r2 / r6
            double r4 = r4 - r2
            r12.m1(r4)
            double r4 = r13.h()
            double r4 = r4 + r2
            r12.k1(r4)
            r2 = r29
            if (r11 <= r2) goto L_0x0292
            androidx.fragment.app.s r0 = r1.getActivity()
            if (r0 == 0) goto L_0x0291
            android.content.Context r0 = r0.getApplicationContext()
            java.lang.String r2 = "HH:mm"
            r3 = r30
            org.achartengine.b r0 = org.achartengine.a.c(r0, r3, r12, r2)
            r2 = 255(0xff, float:3.57E-43)
            int r2 = android.graphics.Color.rgb(r2, r2, r2)
            r0.setBackgroundColor(r2)
            return r0
        L_0x0291:
            return r16
        L_0x0292:
            androidx.fragment.app.s r0 = r1.getActivity()
            r2 = 2131886860(0x7f12030c, float:1.940831E38)
            java.lang.String r2 = r1.getString(r2)
            r3 = 1
            android.widget.Toast r0 = android.widget.Toast.makeText(r0, r2, r3)
            r2 = 17
            r3 = r31
            r0.setGravity(r2, r3, r3)
            r0.show()
        L_0x02ac:
            return r16
        */
        throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.FragmentOfficial.s2(double, double, java.lang.String, double):org.achartengine.b");
    }

    private int t2(String str) {
        if (str == null) {
            return 0;
        }
        Date date = new Date();
        try {
            date = this.f12932b1.parse(str);
        } catch (ParseException e8) {
            if (e8.getMessage() != null) {
                Log.d("EQN", e8.getMessage());
            }
        }
        return (int) Math.round((((double) (new Date().getTime() - new Date(date.getTime() - ((long) (this.f12930Z0.getOffset(date.getTime()) - this.f12931a1.getOffset(date.getTime())))).getTime())) / 1000.0d) / 60.0d);
    }

    public static /* synthetic */ int u0(FragmentOfficial fragmentOfficial, i iVar, i iVar2) {
        fragmentOfficial.getClass();
        Date date = new Date();
        Date date2 = new Date();
        if (iVar.f13035j == null || iVar2.f13035j == null) {
            return 0;
        }
        try {
            date = fragmentOfficial.f12932b1.parse(iVar.f13035j);
            date2 = fragmentOfficial.f12932b1.parse(iVar2.f13035j);
        } catch (ParseException e8) {
            if (e8.getMessage() != null) {
                Log.d("EQN", e8.getMessage());
            }
        }
        return Long.compare(date2.getTime(), date.getTime());
    }

    private String u2(String str) {
        int t22 = t2(str);
        if (t22 < 60) {
            float f8 = (float) t22;
            return getResources().getQuantityString(C2030R.plurals.manual_minutes_ago, Math.round(f8), new Object[]{Integer.valueOf(Math.round(f8))});
        } else if (t22 < 1440) {
            double d8 = ((double) t22) / 60.0d;
            return getResources().getQuantityString(C2030R.plurals.manual_hours_ago, (int) Math.round(d8), new Object[]{Integer.valueOf((int) Math.round(d8))});
        } else {
            double d9 = (((double) t22) / 60.0d) / 24.0d;
            return getResources().getQuantityString(C2030R.plurals.manual_days_ago, (int) Math.round(d9), new Object[]{Integer.valueOf((int) Math.round(d9))});
        }
    }

    public static /* synthetic */ void v0(FragmentOfficial fragmentOfficial, View view) {
        float[] v22 = fragmentOfficial.v2();
        if (v22 != null) {
            fragmentOfficial.G2(-1, (double) v22[0], (double) v22[1], false);
        }
    }

    private float[] v2() {
        C0891s activity = getActivity();
        if (activity == null) {
            return null;
        }
        SharedPreferences sharedPreferences = activity.getSharedPreferences(MainActivity.class.getSimpleName(), 0);
        return new float[]{sharedPreferences.getFloat("current_latitude", BitmapDescriptorFactory.HUE_RED), sharedPreferences.getFloat("current_longitude", BitmapDescriptorFactory.HUE_RED), sharedPreferences.getFloat("current_accuracy", -1.0f)};
    }

    public static /* synthetic */ void w0(Task task) {
    }

    private String w2(String str) {
        if (str == null) {
            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
        }
        Date date = new Date();
        try {
            date = this.f12932b1.parse(str);
        } catch (ParseException e8) {
            if (e8.getMessage() != null) {
                Log.d("EQN", e8.getMessage());
            }
        }
        Date date2 = new Date(date.getTime() - ((long) (this.f12930Z0.getOffset(date.getTime()) - this.f12931a1.getOffset(date.getTime()))));
        this.f12934d1.setTime(date2);
        return this.f12933c1.format(date2);
    }

    private double x2(double d8, double d9, double d10, double d11) {
        double d12 = (d8 / 360.0d) * 2.0d * 3.141592653589793d;
        double d13 = (d10 / 360.0d) * 2.0d * 3.141592653589793d;
        double d14 = (((d11 / 360.0d) * 2.0d) * 3.141592653589793d) - (((d9 / 360.0d) * 2.0d) * 3.141592653589793d);
        double d15 = (((-Math.atan2((Math.cos(d12) * Math.sin(d13)) - ((Math.sin(d12) * Math.cos(d13)) * Math.cos(d14)), Math.sin(d14) * Math.cos(d13))) / 6.283185307179586d) * 360.0d) + 90.0d;
        if (d15 < 0.0d) {
            return d15 + 360.0d;
        }
        return d15;
    }

    public static /* synthetic */ void y0(DialogInterface dialogInterface, int i8) {
    }

    private String y2(double d8) {
        if (d8 <= 22.5d || d8 > 337.5d) {
            return "(N↑)";
        }
        if (d8 <= 67.5d) {
            return "(NE↗)";
        }
        if (d8 <= 112.5d) {
            return "(E→)";
        }
        if (d8 <= 157.5d) {
            return "(SE↘)";
        }
        if (d8 <= 202.5d) {
            return "(S↓)";
        }
        if (d8 <= 247.5d) {
            return "(SW↙)";
        }
        if (d8 <= 292.5d) {
            return "(W←)";
        }
        return "(NW↖)";
    }

    public static /* synthetic */ void z0(E3.c cVar, Activity activity, Task task) {
        if (task.isSuccessful()) {
            cVar.b(activity, (E3.b) task.getResult()).addOnCompleteListener(new Y0());
        }
    }

    /* access modifiers changed from: private */
    public double z2(double d8, double d9, double d10, double d11) {
        double pow = Math.pow(Math.sin(((((d8 - d10) / 360.0d) * 2.0d) * 3.141592653589793d) / 2.0d), 2.0d) + (Math.cos((d8 / 360.0d) * 2.0d * 3.141592653589793d) * Math.cos((d10 / 360.0d) * 2.0d * 3.141592653589793d) * Math.pow(Math.sin(((((d9 - d11) / 360.0d) * 2.0d) * 3.141592653589793d) / 2.0d), 2.0d));
        return Math.atan2(Math.sqrt(pow), Math.sqrt(1.0d - pow)) * 2.0d * 6371.0d;
    }

    public void onActivityResult(int i8, int i9, Intent intent) {
        String stringExtra;
        C0891s activity;
        C0891s activity2;
        super.onActivityResult(i8, i9, intent);
        if (i8 == 2) {
            SharedPreferences.Editor edit = this.f12924T0.edit();
            int i10 = this.f12924T0.getInt("access_counter_rating", 0) + 1;
            edit.putInt("access_counter_rating", i10);
            edit.apply();
            if (i10 % 400 == 0 && (activity2 = getActivity()) != null) {
                E3.c a8 = E3.d.a(activity2.getApplicationContext());
                a8.a().addOnCompleteListener(new Z0(a8, activity2));
            }
            if (i9 == 0 && intent != null && (stringExtra = intent.getStringExtra("memory")) != null && stringExtra.equalsIgnoreCase("low") && (activity = getActivity()) != null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setMessage(getString(C2030R.string.low_memory_mag));
                builder.setCancelable(true);
                builder.setNegativeButton(getString(C2030R.string.official_close), new C1753a1());
                builder.create().show();
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f12944n0 = layoutInflater.inflate(C2030R.layout.quakelist, viewGroup, false);
        this.f12945n1 = bundle;
        this.f12930Z0 = TimeZone.getTimeZone("Europe/Paris");
        this.f12931a1 = TimeZone.getDefault();
        this.f12932b1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        this.f12933c1 = new SimpleDateFormat("HH:mm:ss dd-MMM", Locale.getDefault());
        this.f12934d1 = Calendar.getInstance();
        this.f12959u1 = Pattern.compile("([0-9]*\\.?[0-9]+)\\s*((KM)|(km)|(Km))");
        C0891s activity = getActivity();
        if (activity != null) {
            SharedPreferences sharedPreferences = activity.getSharedPreferences(MainActivity.class.getSimpleName(), 0);
            this.f12924T0 = sharedPreferences;
            this.f12925U0 = sharedPreferences.edit();
            this.f12922R0 = this.f12924T0.getInt("order_type", 0);
            this.f12923S0 = this.f12924T0.getInt("filter_type", 0);
            this.f12914J0 = this.f12924T0.getFloat("filter_list_radius", 500.0f);
            this.f12915K0 = this.f12924T0.getFloat("filter_list_min_magnitude", 2.0f);
            this.f12961v1 = this.f12924T0.getBoolean("pro_features", false);
            if (!B2() && this.f12923S0 < 2) {
                this.f12923S0 = 2;
                this.f12925U0.putInt("filter_type", 2);
                this.f12925U0.apply();
            }
            Button button = (Button) this.f12944n0.findViewById(C2030R.id.button2);
            int i8 = this.f12923S0;
            if (i8 == 0) {
                button.setText(getString(C2030R.string.filter_area));
            } else if (i8 == 1) {
                button.setText(getString(C2030R.string.filter_relevant));
            } else if (i8 == 2) {
                button.setText(getString(C2030R.string.filter_all));
            } else if (i8 == 3) {
                button.setText(getString(C2030R.string.filter_felt));
            }
            this.f12929Y0 = androidx.preference.g.b(activity.getApplicationContext()).getString("eqn_system_of_units", "0");
        }
        ArrayList arrayList = new ArrayList();
        this.f12926V0 = arrayList;
        this.f12927W0 = new h(this, arrayList, (a) null);
        this.f12928X0 = (RecyclerView) this.f12944n0.findViewById(C2030R.id.recycler_view);
        this.f12928X0.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        this.f12928X0.setItemAnimator(new androidx.recyclerview.widget.c());
        this.f12928X0.setAdapter(this.f12927W0);
        this.f12928X0.n(new a());
        MaterialButton materialButton = (MaterialButton) this.f12944n0.findViewById(C2030R.id.button1);
        int i9 = this.f12922R0;
        if (i9 == 0) {
            materialButton.setIcon(getResources().getDrawable(C2030R.drawable.clock_outline));
        } else if (i9 == 1) {
            materialButton.setIcon(getResources().getDrawable(C2030R.drawable.compass));
        } else if (i9 == 2) {
            materialButton.setIcon(getResources().getDrawable(C2030R.drawable.thermometer));
        }
        materialButton.setOnClickListener(new C1765c1(this));
        Button button2 = (Button) this.f12944n0.findViewById(C2030R.id.button2);
        button2.setOnClickListener(new C1771d1(this, button2));
        ((Button) this.f12944n0.findViewById(C2030R.id.button3)).setOnClickListener(new C1777e1(this));
        requireActivity().addMenuProvider(new d(), getViewLifecycleOwner(), C0910l.b.RESUMED);
        return this.f12944n0;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onMapReady(GoogleMap googleMap) {
        int i8;
        this.f12947o1 = googleMap;
        double pow = Math.pow(10.0d, ((double) ((i) this.f12926V0.get(this.f12942l1)).f13031f) / 1000.0d);
        if (pow > 1000000.0d) {
            i8 = 7;
        } else if (pow < 500.0d) {
            i8 = 3;
        } else {
            i8 = 5;
        }
        LatLng latLng = new LatLng(((i) this.f12926V0.get(this.f12942l1)).f13027b, ((i) this.f12926V0.get(this.f12942l1)).f13028c);
        ((i) this.f12926V0.get(this.f12942l1)).m0(this.f12947o1);
        ((i) this.f12926V0.get(this.f12942l1)).U().getUiSettings().setMapToolbarEnabled(false);
        ((i) this.f12926V0.get(this.f12942l1)).U().setMapType(1);
        ((i) this.f12926V0.get(this.f12942l1)).U().setMapColorScheme(2);
        ((i) this.f12926V0.get(this.f12942l1)).U().moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, (float) i8));
        LatLngBounds latLngBounds = ((i) this.f12926V0.get(this.f12942l1)).U().getProjection().getVisibleRegion().latLngBounds;
        double d8 = (latLngBounds.northeast.latitude - latLngBounds.southwest.latitude) / 9.0d;
        ((i) this.f12926V0.get(this.f12942l1)).U().addPolyline(new PolylineOptions().add(new LatLng(latLngBounds.southwest.latitude, ((i) this.f12926V0.get(this.f12942l1)).f13028c), new LatLng(((i) this.f12926V0.get(this.f12942l1)).f13027b - d8, ((i) this.f12926V0.get(this.f12942l1)).f13028c)).width(4.0f).color(-65536));
        ((i) this.f12926V0.get(this.f12942l1)).U().addPolyline(new PolylineOptions().add(new LatLng(((i) this.f12926V0.get(this.f12942l1)).f13027b + d8, ((i) this.f12926V0.get(this.f12942l1)).f13028c), new LatLng(latLngBounds.northeast.latitude, ((i) this.f12926V0.get(this.f12942l1)).f13028c)).width(4.0f).color(-65536));
        LatLngBounds latLngBounds2 = latLngBounds;
        ((i) this.f12926V0.get(this.f12942l1)).U().addPolyline(new PolylineOptions().add(new LatLng(((i) this.f12926V0.get(this.f12942l1)).f13027b, latLngBounds2.southwest.longitude), new LatLng(((i) this.f12926V0.get(this.f12942l1)).f13027b, ((i) this.f12926V0.get(this.f12942l1)).f13028c - d8)).width(4.0f).color(-65536));
        ((i) this.f12926V0.get(this.f12942l1)).U().addPolyline(new PolylineOptions().add(new LatLng(((i) this.f12926V0.get(this.f12942l1)).f13027b, ((i) this.f12926V0.get(this.f12942l1)).f13028c + d8), new LatLng(((i) this.f12926V0.get(this.f12942l1)).f13027b, latLngBounds2.northeast.longitude)).width(4.0f).color(-65536));
        ((i) this.f12926V0.get(this.f12942l1)).U().setOnMapClickListener(new C1759b1(this));
        UiSettings uiSettings = ((i) this.f12926V0.get(this.f12942l1)).U().getUiSettings();
        uiSettings.setMyLocationButtonEnabled(false);
        uiSettings.setZoomControlsEnabled(false);
        uiSettings.setZoomGesturesEnabled(false);
        uiSettings.setAllGesturesEnabled(false);
        uiSettings.setScrollGesturesEnabled(false);
    }

    public void onPause() {
        super.onPause();
        this.f12957t1 = false;
        this.f12920P0 = 0;
        ((TextView) this.f12944n0.findViewById(C2030R.id.textView14)).setVisibility(8);
    }

    public void onResume() {
        super.onResume();
        this.f12957t1 = true;
        this.f12963w1 = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
        if (B2()) {
            float[] v22 = v2();
            if (v22 != null) {
                this.f12910F0 = (double) v22[0];
                this.f12911G0 = (double) v22[1];
            }
        } else {
            this.f12910F0 = 0.0d;
            this.f12911G0 = 0.0d;
        }
        this.f12937g1 = this.f12924T0.getString("card_textsize", "0");
        this.f12938h1 = this.f12924T0.getBoolean("card_showdistance", true);
        this.f12939i1 = this.f12924T0.getBoolean("card_showcoordinates", false);
        this.f12940j1 = this.f12924T0.getBoolean("card_showpopulation", false);
        this.f12941k1 = this.f12924T0.getBoolean("card_colored", false);
        this.f12935e1 = this.f12924T0.getInt("card_type", 0);
        if (this.f12924T0.getBoolean("official_notification", false)) {
            this.f12925U0.putBoolean("official_notification", false);
            this.f12925U0.apply();
            D2();
            return;
        }
        E2();
    }

    public void onSnapshotReady(Bitmap bitmap) {
        C0891s activity = getActivity();
        if (activity != null) {
            String str = activity.getFilesDir().toString() + "/earthquake_share.png";
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
            if (this.f12947o1.getMapType() == 1) {
                paint.setColor(Color.rgb(255, 0, 0));
            } else {
                paint.setColor(Color.rgb(255, 255, 255));
            }
            paint.setTextSize((float) ((int) (12.0f * f8)));
            paint.setTypeface(Typeface.DEFAULT_BOLD);
            paint.getTextBounds(str2, 0, str2.length(), new Rect());
            canvas.drawText(str2, ((float) copy.getWidth()) + (f8 * 5.0f), (((float) copy.getHeight()) / 2.0f) + 5.0f + (f8 * 6.0f), paint);
            canvas.drawBitmap(copy, 5.0f, 5.0f, paint);
            bitmap2.recycle();
            decodeResource.recycle();
            copy.recycle();
            int width = copy2.getWidth();
            int width2 = this.f12949p1.getWidth();
            int height = this.f12949p1.getHeight();
            float f9 = ((float) width) / ((float) width2);
            Matrix matrix = new Matrix();
            matrix.postScale(f9, f9);
            Bitmap createBitmap = Bitmap.createBitmap(this.f12949p1, 0, 0, width2, height, matrix, false);
            Bitmap createBitmap2 = Bitmap.createBitmap(createBitmap.getWidth(), createBitmap.getHeight() + copy2.getHeight(), copy2.getConfig());
            Canvas canvas2 = new Canvas(createBitmap2);
            canvas2.drawBitmap(createBitmap, BitmapDescriptorFactory.HUE_RED, BitmapDescriptorFactory.HUE_RED, (Paint) null);
            canvas2.drawBitmap(copy2, BitmapDescriptorFactory.HUE_RED, (float) createBitmap.getHeight(), (Paint) null);
            createBitmap.recycle();
            copy2.recycle();
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(new File(str));
                createBitmap2.compress(Bitmap.CompressFormat.PNG, 90, fileOutputStream);
                fileOutputStream.flush();
                fileOutputStream.close();
            } catch (IOException unused) {
                z7 = false;
            }
            Intent intent = new Intent("android.intent.action.SEND");
            if (z7) {
                Uri h8 = FileProvider.h(getActivity().getApplicationContext(), getActivity().getPackageName() + ".fileprovider", new File(str));
                intent.setType("image/png");
                intent.putExtra("android.intent.extra.STREAM", h8);
                intent.putExtra("android.intent.extra.SUBJECT", getString(C2030R.string.app_name));
                intent.putExtra("android.intent.extra.TEXT", getString(C2030R.string.share_hashtag) + " M" + ((i) this.f12926V0.get(this.f12943m1)).f13029d + ",  " + ((i) this.f12926V0.get(this.f12943m1)).f13033h + ". " + getString(C2030R.string.share_notified));
            } else {
                intent.setType("text/plain");
                intent.putExtra("android.intent.extra.SUBJECT", getString(C2030R.string.app_name));
                intent.putExtra("android.intent.extra.TEXT", getString(C2030R.string.share_hashtag) + " M" + ((i) this.f12926V0.get(this.f12943m1)).f13029d + ",  " + ((i) this.f12926V0.get(this.f12943m1)).f13033h + ". " + getString(C2030R.string.share_notified));
            }
            startActivity(Intent.createChooser(intent, getString(C2030R.string.share_share)));
        }
    }

    public void onStop() {
        super.onStop();
        ((ProgressBar) this.f12944n0.findViewById(C2030R.id.progressBar1)).setVisibility(8);
        this.f12920P0 = 0;
        ((TextView) this.f12944n0.findViewById(C2030R.id.textView14)).setVisibility(8);
    }

    public void setMenuVisibility(boolean z7) {
        super.setMenuVisibility(z7);
    }

    private static class i {

        /* renamed from: a  reason: collision with root package name */
        private int f13026a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public double f13027b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public double f13028c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public double f13029d;

        /* renamed from: e  reason: collision with root package name */
        private double f13030e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f13031f;

        /* renamed from: g  reason: collision with root package name */
        private int f13032g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public String f13033h;

        /* renamed from: i  reason: collision with root package name */
        private String f13034i;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public String f13035j;

        /* renamed from: k  reason: collision with root package name */
        private String f13036k;

        /* renamed from: l  reason: collision with root package name */
        private org.achartengine.b f13037l;

        /* renamed from: m  reason: collision with root package name */
        private GoogleMap f13038m;

        /* renamed from: n  reason: collision with root package name */
        private boolean f13039n;

        /* renamed from: o  reason: collision with root package name */
        private int f13040o;

        /* renamed from: p  reason: collision with root package name */
        private int f13041p;

        /* renamed from: q  reason: collision with root package name */
        private int f13042q;

        /* renamed from: r  reason: collision with root package name */
        private double f13043r;
        /* access modifiers changed from: private */

        /* renamed from: s  reason: collision with root package name */
        public int f13044s;

        private i() {
            this.f13026a = 0;
        }

        /* access modifiers changed from: private */
        public void A0(int i8) {
            this.f13041p = i8;
        }

        /* access modifiers changed from: private */
        public org.achartengine.b R() {
            return this.f13037l;
        }

        /* access modifiers changed from: private */
        public String S() {
            return this.f13035j;
        }

        /* access modifiers changed from: private */
        public double T() {
            return this.f13030e;
        }

        /* access modifiers changed from: private */
        public GoogleMap U() {
            return this.f13038m;
        }

        /* access modifiers changed from: private */
        public int V() {
            return this.f13044s;
        }

        /* access modifiers changed from: private */
        public double W() {
            return this.f13027b;
        }

        /* access modifiers changed from: private */
        public String X() {
            return this.f13033h;
        }

        /* access modifiers changed from: private */
        public double Y() {
            return this.f13028c;
        }

        /* access modifiers changed from: private */
        public double Z() {
            return this.f13029d;
        }

        /* access modifiers changed from: private */
        public double a0() {
            return this.f13043r;
        }

        /* access modifiers changed from: private */
        public String b0() {
            return this.f13036k;
        }

        /* access modifiers changed from: private */
        public int c0() {
            return this.f13032g;
        }

        /* access modifiers changed from: private */
        public int d0() {
            return this.f13031f;
        }

        /* access modifiers changed from: private */
        public int e0() {
            return this.f13040o;
        }

        /* access modifiers changed from: private */
        public String f0() {
            return this.f13034i;
        }

        /* access modifiers changed from: private */
        public int g0() {
            return this.f13042q;
        }

        /* access modifiers changed from: private */
        public boolean h0() {
            return this.f13039n;
        }

        /* access modifiers changed from: private */
        public int i0() {
            return this.f13041p;
        }

        /* access modifiers changed from: private */
        public void j0(org.achartengine.b bVar) {
            this.f13037l = bVar;
        }

        /* access modifiers changed from: private */
        public void k0(String str) {
            this.f13035j = str;
        }

        /* access modifiers changed from: private */
        public void l0(double d8) {
            this.f13030e = d8;
        }

        /* access modifiers changed from: private */
        public void m0(GoogleMap googleMap) {
            this.f13038m = googleMap;
        }

        /* access modifiers changed from: private */
        public void n0(int i8) {
            this.f13044s = i8;
        }

        /* access modifiers changed from: private */
        public void o0(double d8) {
            this.f13027b = d8;
        }

        /* access modifiers changed from: private */
        public void p0(String str) {
            this.f13033h = str;
        }

        /* access modifiers changed from: private */
        public void q0(double d8) {
            this.f13028c = d8;
        }

        /* access modifiers changed from: private */
        public void r0(double d8) {
            this.f13029d = d8;
        }

        /* access modifiers changed from: private */
        public void s0(double d8) {
            this.f13043r = d8;
        }

        /* access modifiers changed from: private */
        public void t0(String str) {
            this.f13036k = str;
        }

        /* access modifiers changed from: private */
        public void u0(int i8) {
            this.f13032g = i8;
        }

        /* access modifiers changed from: private */
        public void v0(int i8) {
            this.f13031f = i8;
        }

        /* access modifiers changed from: private */
        public void w0(int i8) {
            this.f13040o = i8;
        }

        /* access modifiers changed from: private */
        public void x0(String str) {
            this.f13034i = str;
        }

        /* access modifiers changed from: private */
        public void y0(int i8) {
            this.f13042q = i8;
        }

        /* access modifiers changed from: private */
        public void z0(boolean z7) {
            this.f13039n = z7;
        }

        /* synthetic */ i(a aVar) {
            this();
        }
    }
}
