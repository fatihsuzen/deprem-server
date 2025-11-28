package com.finazzi.distquake;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.PowerManager;
import android.provider.Settings;
import android.text.Html;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.OvershootInterpolator;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.core.view.B;
import androidx.core.view.C;
import androidx.fragment.app.C0887n;
import androidx.fragment.app.C0891s;
import androidx.lifecycle.C0910l;
import androidx.preference.g;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.android.gms.tasks.Task;
import com.google.common.util.concurrent.f;
import com.robinhood.ticker.TickerView;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import u2.D0;
import u2.E0;
import u2.F0;
import u2.G0;
import u2.H0;
import u2.I0;
import u2.I1;
import u2.J0;
import u2.K0;
import u2.L0;
import u2.M0;
import u2.N0;
import u2.O0;
import u2.P0;
import u2.Q0;
import u2.R0;
import u2.S0;
import u2.T0;
import u2.U0;
import u2.V0;
import u2.W0;

public class FragmentNetwork extends C0887n implements OnMapReadyCallback {

    /* renamed from: n0  reason: collision with root package name */
    private View f12876n0;
    /* access modifiers changed from: private */

    /* renamed from: o0  reason: collision with root package name */
    public SharedPreferences f12877o0;
    /* access modifiers changed from: private */

    /* renamed from: p0  reason: collision with root package name */
    public Intent f12878p0;
    /* access modifiers changed from: private */

    /* renamed from: q0  reason: collision with root package name */
    public boolean f12879q0;

    /* renamed from: r0  reason: collision with root package name */
    private Bundle f12880r0;

    /* renamed from: s0  reason: collision with root package name */
    private final int f12881s0 = 2;

    /* renamed from: t0  reason: collision with root package name */
    private int f12882t0 = 0;

    /* renamed from: u0  reason: collision with root package name */
    private int f12883u0 = 0;

    class a implements C {
        a() {
        }

        public boolean a(MenuItem menuItem) {
            C0891s activity = FragmentNetwork.this.getActivity();
            int itemId = menuItem.getItemId();
            if (itemId == C2030R.id.menu_update) {
                if (FragmentNetwork.this.c1()) {
                    if (System.currentTimeMillis() - FragmentNetwork.this.f12877o0.getLong("network_count_last_updated", 0) > 3000) {
                        FragmentNetwork.this.Y0();
                    }
                } else if (activity != null) {
                    Toast makeText = Toast.makeText(activity, FragmentNetwork.this.getString(C2030R.string.main_nointernet), 1);
                    makeText.setGravity(17, 0, 0);
                    makeText.show();
                }
                return true;
            } else if (itemId == C2030R.id.menu_resize) {
                if (activity != null) {
                    boolean z7 = FragmentNetwork.this.f12877o0.getBoolean("compact_view", true);
                    boolean z8 = !z7;
                    if (!z7) {
                        menuItem.setIcon(androidx.core.content.a.getDrawable(activity.getApplicationContext(), C2030R.drawable.arrow_expand));
                        FragmentNetwork.this.V0();
                        Toast makeText2 = Toast.makeText(activity, FragmentNetwork.this.getString(C2030R.string.main_base_mode), 0);
                        makeText2.setGravity(17, 0, 0);
                        makeText2.show();
                    } else {
                        menuItem.setIcon(androidx.core.content.a.getDrawable(activity.getApplicationContext(), C2030R.drawable.arrow_collapse));
                        FragmentNetwork.this.f1();
                        Toast makeText3 = Toast.makeText(activity, FragmentNetwork.this.getString(C2030R.string.main_advance_mode), 0);
                        makeText3.setGravity(17, 0, 0);
                        makeText3.show();
                    }
                    SharedPreferences.Editor edit = FragmentNetwork.this.f12877o0.edit();
                    edit.putBoolean("compact_view", z8);
                    edit.apply();
                }
                return true;
            } else if (itemId != C2030R.id.menu_seismometer) {
                return false;
            } else {
                if (activity != null) {
                    Intent unused = FragmentNetwork.this.f12878p0 = new Intent().setClass(activity, StatusActivity.class);
                    FragmentNetwork fragmentNetwork = FragmentNetwork.this;
                    fragmentNetwork.startActivity(fragmentNetwork.f12878p0);
                }
                return true;
            }
        }

        public /* synthetic */ void b(Menu menu) {
            B.a(this, menu);
        }

        public void c(Menu menu, MenuInflater menuInflater) {
            menuInflater.inflate(C2030R.menu.network_menu, menu);
            C0891s activity = FragmentNetwork.this.getActivity();
            if (activity == null) {
                return;
            }
            if (FragmentNetwork.this.f12877o0.getBoolean("compact_view", true)) {
                menu.getItem(0).setIcon(androidx.core.content.a.getDrawable(activity.getApplicationContext(), C2030R.drawable.arrow_expand));
            } else {
                menu.getItem(0).setIcon(androidx.core.content.a.getDrawable(activity.getApplicationContext(), C2030R.drawable.arrow_collapse));
            }
        }

        public /* synthetic */ void d(Menu menu) {
            B.b(this, menu);
        }
    }

    private class c extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private String f12888a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f12889b;

        /* renamed from: c  reason: collision with root package name */
        private final double f12890c;

        /* renamed from: d  reason: collision with root package name */
        private final double f12891d;

        /* renamed from: e  reason: collision with root package name */
        private int f12892e;

        /* renamed from: f  reason: collision with root package name */
        private int f12893f;

        /* synthetic */ c(FragmentNetwork fragmentNetwork, double d8, double d9, a aVar) {
            this(d8, d9);
        }

        public static /* synthetic */ void a(c cVar, DialogInterface dialogInterface, int i8) {
            cVar.getClass();
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("text/plain");
            intent.putExtra("android.intent.extra.SUBJECT", FragmentNetwork.this.getString(C2030R.string.app_name));
            intent.putExtra("android.intent.extra.TEXT", FragmentNetwork.this.getString(C2030R.string.main_share_text));
            FragmentNetwork fragmentNetwork = FragmentNetwork.this;
            fragmentNetwork.startActivity(Intent.createChooser(intent, fragmentNetwork.getString(C2030R.string.share_share)));
        }

        public static /* synthetic */ void b(DialogInterface dialogInterface, int i8) {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00ce, code lost:
            r0.disconnect();
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
        /* renamed from: c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r7) {
            /*
                r6 = this;
                com.finazzi.distquake.FragmentNetwork r7 = com.finazzi.distquake.FragmentNetwork.this
                boolean r7 = r7.isAdded()
                com.finazzi.distquake.FragmentNetwork r0 = com.finazzi.distquake.FragmentNetwork.this
                androidx.fragment.app.s r0 = r0.getActivity()
                r1 = 1
                if (r0 == 0) goto L_0x00d8
                if (r7 == 0) goto L_0x00d8
                java.util.HashMap r7 = new java.util.HashMap
                r7.<init>()
                double r2 = r6.f12890c
                java.lang.String r0 = java.lang.Double.toString(r2)
                java.lang.String r2 = "lat"
                r7.put(r2, r0)
                double r2 = r6.f12891d
                java.lang.String r0 = java.lang.Double.toString(r2)
                java.lang.String r2 = "lon"
                r7.put(r2, r0)
                java.lang.String r7 = u2.C1737L.a(r7)
                r0 = 0
                java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x00ca }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00ca }
                r3.<init>()     // Catch:{ IOException -> 0x00ca }
                com.finazzi.distquake.FragmentNetwork r4 = com.finazzi.distquake.FragmentNetwork.this     // Catch:{ IOException -> 0x00ca }
                r5 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r4 = r4.getString(r5)     // Catch:{ IOException -> 0x00ca }
                r3.append(r4)     // Catch:{ IOException -> 0x00ca }
                java.lang.String r4 = "distquake_download_areacheck.php"
                r3.append(r4)     // Catch:{ IOException -> 0x00ca }
                java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x00ca }
                r2.<init>(r3)     // Catch:{ IOException -> 0x00ca }
                java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x00ca }
                java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch:{ IOException -> 0x00ca }
                java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch:{ IOException -> 0x00ca }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x00ca }
                r2.setDoOutput(r1)     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                r0 = 10000(0x2710, float:1.4013E-41)
                r2.setConnectTimeout(r0)     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                r2.setReadTimeout(r0)     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                java.lang.String r0 = "Content-Type"
                java.lang.String r3 = "application/x-www-form-urlencoded;charset=utf-8"
                r2.setRequestProperty(r0, r3)     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                java.lang.String r0 = "POST"
                r2.setRequestMethod(r0)     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                byte[] r0 = r7.getBytes()     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                int r0 = r0.length     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                r2.setFixedLengthStreamingMode(r0)     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                java.io.PrintWriter r0 = new java.io.PrintWriter     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                java.io.OutputStream r3 = r2.getOutputStream()     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                r0.<init>(r3)     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                r0.print(r7)     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                r0.close()     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                java.io.InputStream r0 = r2.getInputStream()     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                r7.<init>(r0)     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                r3.<init>(r7, r4)     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                r0.<init>(r3)     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                r3.<init>()     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
            L_0x00a4:
                java.lang.String r4 = r0.readLine()     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                if (r4 == 0) goto L_0x00b8
                r3.append(r4)     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                java.lang.String r4 = "\n"
                r3.append(r4)     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                goto L_0x00a4
            L_0x00b3:
                r7 = move-exception
                r0 = r2
                goto L_0x00d2
            L_0x00b6:
                r0 = r2
                goto L_0x00ca
            L_0x00b8:
                r7.close()     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                java.lang.String r7 = r3.toString()     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                r6.f12888a = r7     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                r7 = 0
                r6.f12889b = r7     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                r2.disconnect()
                goto L_0x00da
            L_0x00c8:
                r7 = move-exception
                goto L_0x00d2
            L_0x00ca:
                r6.f12889b = r1     // Catch:{ all -> 0x00c8 }
                if (r0 == 0) goto L_0x00da
                r0.disconnect()
                goto L_0x00da
            L_0x00d2:
                if (r0 == 0) goto L_0x00d7
                r0.disconnect()
            L_0x00d7:
                throw r7
            L_0x00d8:
                r6.f12889b = r1
            L_0x00da:
                java.lang.String r7 = "COMPLETE!"
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.FragmentNetwork.c.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: d */
        public void onPostExecute(String str) {
            String str2;
            String str3;
            super.onPostExecute(str);
            if (!this.f12889b) {
                try {
                    JSONArray jSONArray = new JSONArray(this.f12888a);
                    if (jSONArray.length() > 0) {
                        try {
                            this.f12892e = jSONArray.getJSONObject(0).getInt("total");
                            this.f12893f = jSONArray.getJSONObject(1).getInt(AppMeasurementSdk.ConditionalUserProperty.ACTIVE);
                        } catch (JSONException e8) {
                            if (e8.getMessage() != null) {
                                Log.d("EQN", e8.getMessage());
                            }
                        }
                        C0891s activity = FragmentNetwork.this.getActivity();
                        if (activity != null) {
                            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                            builder.setTitle(FragmentNetwork.this.getString(C2030R.string.main_areacheck));
                            int i8 = this.f12893f;
                            if (i8 <= 3) {
                                str2 = "<font color=#ff0000>" + FragmentNetwork.this.getString(C2030R.string.main_areacheck_zero) + "</font>";
                                str3 = "<font color=#ff0000>" + this.f12893f + "</font>";
                            } else if (i8 <= 5) {
                                str2 = "<font color=#ff0000>" + FragmentNetwork.this.getString(C2030R.string.main_areacheck_verylow) + "</font>";
                                str3 = "<font color=#ff0000>" + this.f12893f + "</font>";
                            } else if (i8 <= 10) {
                                str2 = "<font color=#fe7624>" + FragmentNetwork.this.getString(C2030R.string.main_areacheck_low) + "</font>";
                                str3 = "<font color=#fe7624>" + this.f12893f + "</font>";
                            } else if (i8 <= 30) {
                                str2 = "<font color=#fe7624>" + FragmentNetwork.this.getString(C2030R.string.main_areacheck_medium) + "</font>";
                                str3 = "<font color=#fe7624>" + this.f12893f + "</font>";
                            } else {
                                str2 = "<font color=#008000>" + FragmentNetwork.this.getString(C2030R.string.main_areacheck_high) + "</font>";
                                str3 = "<font color=#008000>" + this.f12893f + "</font>";
                            }
                            builder.setMessage(Html.fromHtml(String.format(FragmentNetwork.this.getString(C2030R.string.main_areacheck_message), new Object[]{str3, str2})));
                            builder.setCancelable(true);
                            builder.setNegativeButton(FragmentNetwork.this.getString(C2030R.string.official_close), new I());
                            builder.setPositiveButton(FragmentNetwork.this.getString(C2030R.string.main_share), new J(this));
                            AlertDialog create = builder.create();
                            create.show();
                            ((TextView) create.findViewById(16908299)).setTextSize(20.0f);
                        }
                    }
                } catch (JSONException e9) {
                    if (e9.getMessage() != null) {
                        Log.d("EQN", e9.getMessage());
                    }
                }
            }
        }

        private c(double d8, double d9) {
            this.f12888a = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
            this.f12890c = d8;
            this.f12891d = d9;
        }
    }

    private class e extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private boolean f12898a;

        /* renamed from: b  reason: collision with root package name */
        private String f12899b;

        /* renamed from: c  reason: collision with root package name */
        private final float f12900c;

        /* renamed from: d  reason: collision with root package name */
        private final float f12901d;

        /* renamed from: e  reason: collision with root package name */
        private final String f12902e;

        /* renamed from: f  reason: collision with root package name */
        private final String f12903f;

        /* synthetic */ e(FragmentNetwork fragmentNetwork, String str, String str2, float f8, float f9, a aVar) {
            this(str, str2, f8, f9);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(5:11|10|15|16|(2:18|23)(1:25)) */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x00c1, code lost:
            r7 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x00cf, code lost:
            r1.disconnect();
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x00c3 */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x00c7  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00cf  */
        /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r7) {
            /*
                r6 = this;
                java.util.HashMap r7 = new java.util.HashMap
                r7.<init>()
                java.lang.String r0 = "u_id"
                java.lang.String r1 = r6.f12902e
                r7.put(r0, r1)
                java.lang.String r0 = "radius"
                java.lang.String r1 = r6.f12903f
                r7.put(r0, r1)
                float r0 = r6.f12900c
                java.lang.String r0 = java.lang.Float.toString(r0)
                java.lang.String r1 = "lat"
                r7.put(r1, r0)
                float r0 = r6.f12901d
                java.lang.String r0 = java.lang.Float.toString(r0)
                java.lang.String r1 = "lon"
                r7.put(r1, r0)
                java.lang.String r7 = u2.C1737L.a(r7)
                r0 = 1
                r1 = 0
                java.net.URL r2 = new java.net.URL     // Catch:{ IOException | IllegalStateException -> 0x00c3 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException | IllegalStateException -> 0x00c3 }
                r3.<init>()     // Catch:{ IOException | IllegalStateException -> 0x00c3 }
                com.finazzi.distquake.FragmentNetwork r4 = com.finazzi.distquake.FragmentNetwork.this     // Catch:{ IOException | IllegalStateException -> 0x00c3 }
                r5 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r4 = r4.getString(r5)     // Catch:{ IOException | IllegalStateException -> 0x00c3 }
                r3.append(r4)     // Catch:{ IOException | IllegalStateException -> 0x00c3 }
                java.lang.String r4 = "distquake_upload_testalarm.php"
                r3.append(r4)     // Catch:{ IOException | IllegalStateException -> 0x00c3 }
                java.lang.String r3 = r3.toString()     // Catch:{ IOException | IllegalStateException -> 0x00c3 }
                r2.<init>(r3)     // Catch:{ IOException | IllegalStateException -> 0x00c3 }
                java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException | IllegalStateException -> 0x00c3 }
                java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch:{ IOException | IllegalStateException -> 0x00c3 }
                java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch:{ IOException | IllegalStateException -> 0x00c3 }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException | IllegalStateException -> 0x00c3 }
                r2.setDoOutput(r0)     // Catch:{ IOException | IllegalStateException -> 0x00af, all -> 0x00ac }
                r1 = 10000(0x2710, float:1.4013E-41)
                r2.setConnectTimeout(r1)     // Catch:{ IOException | IllegalStateException -> 0x00af, all -> 0x00ac }
                r2.setReadTimeout(r1)     // Catch:{ IOException | IllegalStateException -> 0x00af, all -> 0x00ac }
                java.lang.String r1 = "Content-Type"
                java.lang.String r3 = "application/x-www-form-urlencoded;charset=utf-8"
                r2.setRequestProperty(r1, r3)     // Catch:{ IOException | IllegalStateException -> 0x00af, all -> 0x00ac }
                java.lang.String r1 = "POST"
                r2.setRequestMethod(r1)     // Catch:{ IOException | IllegalStateException -> 0x00af, all -> 0x00ac }
                byte[] r1 = r7.getBytes()     // Catch:{ IOException | IllegalStateException -> 0x00af, all -> 0x00ac }
                int r1 = r1.length     // Catch:{ IOException | IllegalStateException -> 0x00af, all -> 0x00ac }
                r2.setFixedLengthStreamingMode(r1)     // Catch:{ IOException | IllegalStateException -> 0x00af, all -> 0x00ac }
                java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch:{ IOException | IllegalStateException -> 0x00af, all -> 0x00ac }
                java.io.OutputStream r3 = r2.getOutputStream()     // Catch:{ IOException | IllegalStateException -> 0x00af, all -> 0x00ac }
                r1.<init>(r3)     // Catch:{ IOException | IllegalStateException -> 0x00af, all -> 0x00ac }
                r1.print(r7)     // Catch:{ IOException | IllegalStateException -> 0x00af, all -> 0x00ac }
                r1.close()     // Catch:{ IOException | IllegalStateException -> 0x00af, all -> 0x00ac }
                java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException | IllegalStateException -> 0x00af, all -> 0x00ac }
                java.io.InputStream r1 = r2.getInputStream()     // Catch:{ IOException | IllegalStateException -> 0x00af, all -> 0x00ac }
                r7.<init>(r1)     // Catch:{ IOException | IllegalStateException -> 0x00af, all -> 0x00ac }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException | IllegalStateException -> 0x00af, all -> 0x00ac }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException | IllegalStateException -> 0x00af, all -> 0x00ac }
                java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException | IllegalStateException -> 0x00af, all -> 0x00ac }
                r3.<init>(r7, r4)     // Catch:{ IOException | IllegalStateException -> 0x00af, all -> 0x00ac }
                r1.<init>(r3)     // Catch:{ IOException | IllegalStateException -> 0x00af, all -> 0x00ac }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException | IllegalStateException -> 0x00af, all -> 0x00ac }
                r3.<init>()     // Catch:{ IOException | IllegalStateException -> 0x00af, all -> 0x00ac }
            L_0x00a2:
                java.lang.String r4 = r1.readLine()     // Catch:{ IOException | IllegalStateException -> 0x00af, all -> 0x00ac }
                if (r4 == 0) goto L_0x00b1
                r3.append(r4)     // Catch:{ IOException | IllegalStateException -> 0x00af, all -> 0x00ac }
                goto L_0x00a2
            L_0x00ac:
                r7 = move-exception
                r1 = r2
                goto L_0x00cd
            L_0x00af:
                r1 = r2
                goto L_0x00c3
            L_0x00b1:
                r7.close()     // Catch:{ IOException | IllegalStateException -> 0x00af, all -> 0x00ac }
                java.lang.String r7 = r3.toString()     // Catch:{ IOException | IllegalStateException -> 0x00af, all -> 0x00ac }
                r6.f12899b = r7     // Catch:{ IOException | IllegalStateException -> 0x00af, all -> 0x00ac }
                r7 = 0
                r6.f12898a = r7     // Catch:{ IOException | IllegalStateException -> 0x00af, all -> 0x00ac }
                r2.disconnect()
                goto L_0x00ca
            L_0x00c1:
                r7 = move-exception
                goto L_0x00cd
            L_0x00c3:
                r6.f12898a = r0     // Catch:{ all -> 0x00c1 }
                if (r1 == 0) goto L_0x00ca
                r1.disconnect()
            L_0x00ca:
                java.lang.String r7 = "COMPLETE!"
                return r7
            L_0x00cd:
                if (r1 == 0) goto L_0x00d2
                r1.disconnect()
            L_0x00d2:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.FragmentNetwork.e.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            C0891s activity;
            super.onPostExecute(str);
            if (this.f12898a) {
                C0891s activity2 = FragmentNetwork.this.getActivity();
                if (activity2 != null) {
                    Toast makeText = Toast.makeText(activity2, FragmentNetwork.this.getString(C2030R.string.manual_error), 0);
                    makeText.setGravity(17, 0, 0);
                    makeText.show();
                }
            } else if (this.f12899b.equalsIgnoreCase("notregistered") && (activity = FragmentNetwork.this.getActivity()) != null) {
                Toast makeText2 = Toast.makeText(activity, FragmentNetwork.this.getString(C2030R.string.options_alarm_noid), 0);
                makeText2.setGravity(17, 0, 0);
                makeText2.show();
            }
        }

        private e(String str, String str2, float f8, float f9) {
            this.f12899b = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
            this.f12902e = str;
            this.f12903f = str2;
            this.f12900c = f8;
            this.f12901d = f9;
        }
    }

    public static /* synthetic */ void A0(Task task) {
    }

    public static /* synthetic */ void B0(E3.c cVar, Activity activity, Task task) {
        if (task.isSuccessful()) {
            cVar.b(activity, (E3.b) task.getResult()).addOnCompleteListener(new O0());
        }
    }

    public static /* synthetic */ void C0(FragmentNetwork fragmentNetwork, View view) {
        if (fragmentNetwork.c1()) {
            fragmentNetwork.Z0();
            return;
        }
        C0891s activity = fragmentNetwork.getActivity();
        if (activity != null) {
            Toast makeText = Toast.makeText(activity, fragmentNetwork.getString(C2030R.string.main_nointernet), 0);
            makeText.setGravity(17, 0, 0);
            makeText.show();
        }
    }

    public static /* synthetic */ void D0(FragmentNetwork fragmentNetwork, View view) {
        C0891s activity = fragmentNetwork.getActivity();
        if (activity != null) {
            Intent intent = new Intent().setClass(activity, InAppActivity.class);
            fragmentNetwork.f12878p0 = intent;
            intent.putExtra("show_map_button", true);
            fragmentNetwork.startActivity(fragmentNetwork.f12878p0);
        }
    }

    public static /* synthetic */ void E0(FragmentNetwork fragmentNetwork, View view) {
        if (!fragmentNetwork.d1()) {
            Toast makeText = Toast.makeText(fragmentNetwork.getActivity(), fragmentNetwork.getString(C2030R.string.main_areacheck_geo), 1);
            makeText.setGravity(17, 0, 0);
            makeText.show();
            return;
        }
        C0891s activity = fragmentNetwork.getActivity();
        if (activity != null) {
            Intent intent = new Intent().setClass(activity, GlobeActivityAll.class);
            intent.putExtra("com.finazzi.distquake.map_type", 3);
            fragmentNetwork.startActivity(intent);
        }
    }

    public static /* synthetic */ void G0(FragmentNetwork fragmentNetwork, Activity activity, View view) {
        fragmentNetwork.getClass();
        if (activity != null) {
            fragmentNetwork.startActivity(new Intent().setClass(activity, ProblemsActivity.class));
        }
    }

    public static /* synthetic */ void H0(FragmentNetwork fragmentNetwork, View view) {
        fragmentNetwork.getClass();
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", fragmentNetwork.getString(C2030R.string.app_name));
        intent.putExtra("android.intent.extra.TEXT", fragmentNetwork.getString(C2030R.string.main_share_text));
        fragmentNetwork.startActivity(Intent.createChooser(intent, fragmentNetwork.getString(C2030R.string.share_share)));
    }

    public static /* synthetic */ void I0(FragmentNetwork fragmentNetwork, View view) {
        if (!fragmentNetwork.c1()) {
            Toast makeText = Toast.makeText(fragmentNetwork.getActivity(), fragmentNetwork.getString(C2030R.string.main_nointernet), 1);
            makeText.setGravity(17, 0, 0);
            makeText.show();
        } else if (fragmentNetwork.f12883u0 > 0) {
            Toast makeText2 = Toast.makeText(fragmentNetwork.getActivity(), fragmentNetwork.getString(C2030R.string.main_solve_problems), 1);
            makeText2.setGravity(17, 0, 0);
            makeText2.show();
        } else if (!fragmentNetwork.d1()) {
            Toast makeText3 = Toast.makeText(fragmentNetwork.getActivity(), fragmentNetwork.getString(C2030R.string.main_areacheck_geo), 1);
            makeText3.setGravity(17, 0, 0);
            makeText3.show();
        } else {
            C0891s activity = fragmentNetwork.getActivity();
            if (activity != null) {
                String string = fragmentNetwork.f12877o0.getString("android_id_eqn", "0");
                if (!string.equalsIgnoreCase("0")) {
                    float f8 = fragmentNetwork.f12877o0.getFloat("current_latitude", BitmapDescriptorFactory.HUE_RED);
                    float f9 = fragmentNetwork.f12877o0.getFloat("current_longitude", BitmapDescriptorFactory.HUE_RED);
                    SharedPreferences b8 = g.b(activity.getApplicationContext());
                    String string2 = b8.getString("eqn_notify_radius_alarm", "500");
                    if (b8.getBoolean("eqn_notify_alarm", false)) {
                        new e(fragmentNetwork, string, string2, f8, f9, (a) null).execute(new Context[]{activity});
                        return;
                    }
                    FragmentNetwork fragmentNetwork2 = fragmentNetwork;
                    Toast makeText4 = Toast.makeText(fragmentNetwork2.getActivity(), fragmentNetwork2.getString(C2030R.string.main_alerttest_noalert), 1);
                    makeText4.setGravity(17, 0, 0);
                    makeText4.show();
                }
            }
        }
    }

    public static /* synthetic */ void J0(FragmentNetwork fragmentNetwork, Activity activity, View view) {
        fragmentNetwork.getClass();
        if (activity != null) {
            fragmentNetwork.startActivity(new Intent().setClass(activity, ToProActivity.class));
        }
    }

    public static /* synthetic */ void K0(FragmentNetwork fragmentNetwork, View view) {
        C0891s activity = fragmentNetwork.getActivity();
        if (activity != null) {
            ((CardView) activity.findViewById(C2030R.id.cardAlarm)).setVisibility(8);
            ((CardView) activity.findViewById(C2030R.id.cardNothing)).setVisibility(0);
            SharedPreferences.Editor edit = fragmentNetwork.getActivity().getSharedPreferences(MainActivity.class.getSimpleName(), 0).edit();
            edit.remove("latitude_eqn");
            edit.remove("longitude_eqn");
            edit.remove("counter_eqn");
            edit.remove("datetime_eqn");
            edit.remove("intensity_eqn");
            edit.remove("peak_acc_eqn");
            edit.remove("magnitude_eqn");
            edit.remove("location_eqn");
            edit.remove("pos_eqn");
            edit.remove("intensity_at_location_eqn");
            edit.apply();
        }
    }

    public static /* synthetic */ void L0(FragmentNetwork fragmentNetwork, View view) {
        C0891s activity = fragmentNetwork.getActivity();
        if (activity != null) {
            Intent intent = new Intent().setClass(activity, InAppActivity.class);
            fragmentNetwork.f12878p0 = intent;
            intent.putExtra("show_map_button", true);
            fragmentNetwork.startActivity(fragmentNetwork.f12878p0);
        }
    }

    /* access modifiers changed from: private */
    public void V0() {
        ((CardView) this.f12876n0.findViewById(C2030R.id.cardNetwork)).setVisibility(8);
        ((CardView) this.f12876n0.findViewById(C2030R.id.cardLocation)).setVisibility(8);
    }

    private void W0() {
        this.f12882t0 = 0;
        this.f12883u0 = 0;
        C0891s activity = getActivity();
        if (activity != null) {
            int i8 = Build.VERSION.SDK_INT;
            if (i8 >= 34 && !((NotificationManager) activity.getSystemService("notification")).canUseFullScreenIntent()) {
                this.f12882t0++;
            }
            if (!((PowerManager) activity.getSystemService("power")).isIgnoringBatteryOptimizations(activity.getApplicationContext().getPackageName())) {
                this.f12882t0++;
                this.f12883u0++;
            }
            if (!Settings.canDrawOverlays(activity.getApplicationContext())) {
                this.f12882t0++;
            }
            if (i8 >= 26 && !((NotificationManager) activity.getSystemService("notification")).areNotificationsEnabled()) {
                this.f12882t0++;
                this.f12883u0++;
            }
            if (!e1(activity)) {
                this.f12882t0++;
                this.f12883u0++;
            } else if (i8 >= 31) {
                if (androidx.core.content.a.checkSelfPermission(activity, "android.permission.ACCESS_FINE_LOCATION") != 0 && androidx.core.content.a.checkSelfPermission(activity, "android.permission.ACCESS_COARSE_LOCATION") != 0) {
                    this.f12882t0++;
                    this.f12883u0++;
                } else if (androidx.core.content.a.checkSelfPermission(activity, "android.permission.ACCESS_BACKGROUND_LOCATION") != 0) {
                    this.f12882t0++;
                    this.f12883u0++;
                } else {
                    if (androidx.core.content.a.checkSelfPermission(activity, "android.permission.ACCESS_FINE_LOCATION") != 0 && androidx.core.content.a.checkSelfPermission(activity, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
                        this.f12882t0++;
                        this.f12883u0++;
                    }
                    f c8 = androidx.core.content.f.c(activity);
                    c8.addListener(new M0(this, c8), androidx.core.content.a.getMainExecutor(activity));
                }
            } else if (i8 == 30) {
                if (androidx.core.content.a.checkSelfPermission(activity, "android.permission.ACCESS_FINE_LOCATION") != 0) {
                    this.f12882t0++;
                    this.f12883u0++;
                } else {
                    if (androidx.core.content.a.checkSelfPermission(activity, "android.permission.ACCESS_BACKGROUND_LOCATION") != 0) {
                        this.f12882t0++;
                        this.f12883u0++;
                    }
                    f c82 = androidx.core.content.f.c(activity);
                    c82.addListener(new M0(this, c82), androidx.core.content.a.getMainExecutor(activity));
                }
            } else if (i8 != 29) {
                if (androidx.core.content.a.checkSelfPermission(activity, "android.permission.ACCESS_FINE_LOCATION") != 0) {
                    this.f12882t0++;
                    this.f12883u0++;
                }
                f c822 = androidx.core.content.f.c(activity);
                c822.addListener(new M0(this, c822), androidx.core.content.a.getMainExecutor(activity));
            } else if (androidx.core.content.a.checkSelfPermission(activity, "android.permission.ACCESS_FINE_LOCATION") != 0) {
                this.f12882t0++;
                this.f12883u0++;
            } else {
                if (androidx.core.content.a.checkSelfPermission(activity, "android.permission.ACCESS_BACKGROUND_LOCATION") != 0) {
                    this.f12882t0++;
                    this.f12883u0++;
                }
                f c8222 = androidx.core.content.f.c(activity);
                c8222.addListener(new M0(this, c8222), androidx.core.content.a.getMainExecutor(activity));
            }
            if (this.f12879q0) {
                ((CardView) this.f12876n0.findViewById(C2030R.id.cardUpgrade)).setVisibility(8);
            }
            f c82222 = androidx.core.content.f.c(activity);
            c82222.addListener(new M0(this, c82222), androidx.core.content.a.getMainExecutor(activity));
        }
        CardView cardView = (CardView) this.f12876n0.findViewById(C2030R.id.cardProblems);
        if (this.f12882t0 > 0) {
            cardView.setVisibility(0);
            Resources resources = getResources();
            int i9 = this.f12882t0;
            ((TextView) this.f12876n0.findViewById(C2030R.id.textView01)).setText(resources.getQuantityString(C2030R.plurals.main_problems_to_solve, i9, new Object[]{Integer.valueOf(i9)}));
            return;
        }
        cardView.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void X0() {
        String str;
        int i8 = this.f12877o0.getInt("network_count_quakes", 0);
        TextView textView = (TextView) this.f12876n0.findViewById(C2030R.id.textView11);
        if (i8 > 0) {
            textView.setText(Html.fromHtml(String.format(getString(C2030R.string.main_recent_quakes), new Object[]{"<font color=#" + Integer.toHexString(getResources().getColor(C2030R.color.md_theme_primary)).substring(2) + ">" + String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf(i8)}) + "</font>"})));
        } else {
            textView.setText(String.format(getString(C2030R.string.main_recent_quakes), new Object[]{String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf(i8)})}));
        }
        ((TextView) this.f12876n0.findViewById(C2030R.id.textView12)).setText(String.format(getString(C2030R.string.main_total_quakes), new Object[]{String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf(this.f12877o0.getInt("network_count_quakes_past", 0))})}));
        int i9 = this.f12877o0.getInt("network_count_green", 0);
        int i10 = this.f12877o0.getInt("network_count_green_last_displayed", i9);
        TickerView tickerView = (TickerView) this.f12876n0.findViewById(C2030R.id.tickerView1);
        tickerView.setCharacterLists(D5.c.b());
        tickerView.setAnimationDuration(0);
        tickerView.setText(String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf(i10)}));
        tickerView.setAnimationDuration(2000);
        tickerView.setAnimationInterpolator(new OvershootInterpolator());
        tickerView.setText(String.format(Locale.getDefault(), "%d", new Object[]{Integer.valueOf(i9)}));
        SharedPreferences.Editor edit = this.f12877o0.edit();
        edit.putInt("network_count_green_last_displayed", i9);
        edit.apply();
        TextView textView2 = (TextView) this.f12876n0.findViewById(C2030R.id.textView16);
        int i11 = this.f12877o0.getInt("network_last_sub_minutes", -1);
        if (i11 > -1) {
            String substring = Integer.toHexString(getResources().getColor(C2030R.color.md_theme_primary)).substring(2);
            if (i11 < 60) {
                str = getResources().getQuantityString(C2030R.plurals.inapp_adv_minutes, i11, new Object[]{Integer.valueOf(i11)});
            } else if (i11 < 1410) {
                double d8 = ((double) i11) / 60.0d;
                str = getResources().getQuantityString(C2030R.plurals.inapp_adv_hours, (int) Math.round(d8), new Object[]{Integer.valueOf((int) Math.round(d8))});
            } else {
                double d9 = ((double) i11) / 1440.0d;
                str = getResources().getQuantityString(C2030R.plurals.inapp_adv_days, (int) Math.round(d9), new Object[]{Integer.valueOf((int) Math.round(d9))});
            }
            textView2.setText(Html.fromHtml(getString(C2030R.string.inapp_adv) + " " + ("<font color=#" + substring + ">" + str + "</font>")));
            return;
        }
        textView2.setText(getString(C2030R.string.inapp_adv));
    }

    /* access modifiers changed from: private */
    public void Y0() {
        new b(this, (a) null).execute(new Context[]{getActivity()});
    }

    /* access modifiers changed from: private */
    public void Z0() {
        ((ProgressBar) this.f12876n0.findViewById(C2030R.id.progressBar2)).setVisibility(0);
        new d(this, (a) null).execute(new Context[]{getActivity()});
    }

    private float[] a1() {
        C0891s activity = getActivity();
        if (activity == null) {
            return null;
        }
        SharedPreferences sharedPreferences = activity.getSharedPreferences(MainActivity.class.getSimpleName(), 0);
        return new float[]{sharedPreferences.getFloat("current_latitude", BitmapDescriptorFactory.HUE_RED), sharedPreferences.getFloat("current_longitude", BitmapDescriptorFactory.HUE_RED), sharedPreferences.getFloat("current_accuracy", -1.0f)};
    }

    private double b1(double d8, double d9, double d10, double d11) {
        double pow = Math.pow(Math.sin(((((d8 - d10) / 360.0d) * 2.0d) * 3.141592653589793d) / 2.0d), 2.0d) + (Math.cos((d8 / 360.0d) * 2.0d * 3.141592653589793d) * Math.cos((d10 / 360.0d) * 2.0d * 3.141592653589793d) * Math.pow(Math.sin(((((d9 - d11) / 360.0d) * 2.0d) * 3.141592653589793d) / 2.0d), 2.0d));
        return Math.atan2(Math.sqrt(pow), Math.sqrt(1.0d - pow)) * 2.0d * 6371.0d;
    }

    /* access modifiers changed from: private */
    public boolean c1() {
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

    private boolean d1() {
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

    private static boolean e1(Context context) {
        int i8;
        try {
            i8 = Settings.Secure.getInt(context.getContentResolver(), "location_mode");
        } catch (Settings.SettingNotFoundException e8) {
            if (e8.getMessage() != null) {
                Log.d("EQN", e8.getMessage());
            }
            i8 = 0;
        }
        if (i8 != 0) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    public void f1() {
        ((CardView) this.f12876n0.findViewById(C2030R.id.cardNetwork)).setVisibility(0);
        if (d1()) {
            CardView cardView = (CardView) this.f12876n0.findViewById(C2030R.id.cardLocation);
            cardView.setVisibility(0);
            float[] a12 = a1();
            if (a12 != null) {
                float f8 = a12[0];
                float f9 = a12[1];
                C0891s activity = getActivity();
                if (activity != null) {
                    long j8 = activity.getSharedPreferences(MainActivity.class.getSimpleName(), 0).getLong("current_location_time", 0);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm", Locale.getDefault());
                    Date date = new Date(j8);
                    TextView textView = (TextView) this.f12876n0.findViewById(C2030R.id.textView21);
                    textView.setText(String.format(getString(C2030R.string.weather_location_update), new Object[]{simpleDateFormat.format(date)}));
                    textView.setVisibility(0);
                } else {
                    ((TextView) this.f12876n0.findViewById(C2030R.id.textView21)).setVisibility(8);
                }
                Calendar instance = Calendar.getInstance();
                I1 i12 = new I1((double) f8, (double) f9);
                TimeZone timeZone = TimeZone.getDefault();
                if (timeZone != null) {
                    b0 b0Var = new b0(i12, timeZone);
                    Calendar a8 = b0Var.a(instance);
                    Calendar b8 = b0Var.b(instance);
                    if (a8 != null && b8 != null) {
                        ((TextView) this.f12876n0.findViewById(C2030R.id.textView18)).setText(String.format(Locale.getDefault(), "%.3f", new Object[]{Float.valueOf(f8)}) + getString(C2030R.string.status_latitude_short) + " " + String.format(Locale.getDefault(), "%.3f", new Object[]{Float.valueOf(f9)}) + getString(C2030R.string.status_longitude_short));
                        StringBuilder sb = new StringBuilder();
                        sb.append(String.format(Locale.getDefault(), "%02d:%02d", new Object[]{Integer.valueOf(a8.get(11)), Integer.valueOf(a8.get(12))}));
                        sb.append(" ");
                        sb.append(a8.getTimeZone().getDisplayName());
                        ((TextView) this.f12876n0.findViewById(C2030R.id.textView19)).setText(sb.toString());
                        ((TextView) this.f12876n0.findViewById(C2030R.id.textView20)).setText(String.format(Locale.getDefault(), "%02d:%02d", new Object[]{Integer.valueOf(b8.get(11)), Integer.valueOf(b8.get(12))}) + " " + a8.getTimeZone().getDisplayName());
                        return;
                    }
                    return;
                }
                cardView.setVisibility(8);
                return;
            }
            cardView.setVisibility(8);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static /* synthetic */ void s0(com.finazzi.distquake.FragmentNetwork r4, com.google.common.util.concurrent.f r5) {
        /*
            r0 = 0
            r1 = 1
            r4.getClass()
            java.lang.Object r5 = r5.get()     // Catch:{ ExecutionException -> 0x0021, InterruptedException -> 0x001f }
            java.lang.Integer r5 = (java.lang.Integer) r5     // Catch:{ ExecutionException -> 0x0021, InterruptedException -> 0x001f }
            int r5 = r5.intValue()     // Catch:{ ExecutionException -> 0x0021, InterruptedException -> 0x001f }
            r2 = 3
            if (r5 == r2) goto L_0x0029
            r2 = 4
            if (r5 == r2) goto L_0x0023
            r2 = 5
            if (r5 == r2) goto L_0x0019
            goto L_0x0032
        L_0x0019:
            int r5 = r4.f12882t0     // Catch:{ ExecutionException -> 0x0021, InterruptedException -> 0x001f }
            int r5 = r5 + r1
            r4.f12882t0 = r5     // Catch:{ ExecutionException -> 0x0021, InterruptedException -> 0x001f }
            goto L_0x0032
        L_0x001f:
            r5 = move-exception
            goto L_0x002f
        L_0x0021:
            r5 = move-exception
            goto L_0x002f
        L_0x0023:
            int r5 = r4.f12882t0     // Catch:{ ExecutionException -> 0x0021, InterruptedException -> 0x001f }
            int r5 = r5 + r1
            r4.f12882t0 = r5     // Catch:{ ExecutionException -> 0x0021, InterruptedException -> 0x001f }
            goto L_0x0032
        L_0x0029:
            int r5 = r4.f12882t0     // Catch:{ ExecutionException -> 0x0021, InterruptedException -> 0x001f }
            int r5 = r5 + r1
            r4.f12882t0 = r5     // Catch:{ ExecutionException -> 0x0021, InterruptedException -> 0x001f }
            goto L_0x0032
        L_0x002f:
            r5.printStackTrace()
        L_0x0032:
            boolean r5 = r4.f12879q0
            if (r5 == 0) goto L_0x0071
            android.view.View r5 = r4.f12876n0
            r2 = 2131296457(0x7f0900c9, float:1.8210831E38)
            android.view.View r5 = r5.findViewById(r2)
            androidx.cardview.widget.CardView r5 = (androidx.cardview.widget.CardView) r5
            int r2 = r4.f12882t0
            if (r2 <= 0) goto L_0x006c
            r5.setVisibility(r0)
            android.view.View r5 = r4.f12876n0
            r2 = 2131297042(0x7f090312, float:1.8212018E38)
            android.view.View r5 = r5.findViewById(r2)
            android.widget.TextView r5 = (android.widget.TextView) r5
            android.content.res.Resources r2 = r4.getResources()
            int r4 = r4.f12882t0
            java.lang.Integer r3 = java.lang.Integer.valueOf(r4)
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r0] = r3
            r0 = 2131755013(0x7f100005, float:1.9140893E38)
            java.lang.String r4 = r2.getQuantityString(r0, r4, r1)
            r5.setText(r4)
            goto L_0x0071
        L_0x006c:
            r4 = 8
            r5.setVisibility(r4)
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.FragmentNetwork.s0(com.finazzi.distquake.FragmentNetwork, com.google.common.util.concurrent.f):void");
    }

    public static /* synthetic */ void t0(FragmentNetwork fragmentNetwork, View view) {
        fragmentNetwork.getClass();
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("text/plain");
        intent.putExtra("android.intent.extra.SUBJECT", fragmentNetwork.getString(C2030R.string.app_name));
        intent.putExtra("android.intent.extra.TEXT", fragmentNetwork.getString(C2030R.string.main_share_text));
        fragmentNetwork.startActivity(Intent.createChooser(intent, fragmentNetwork.getString(C2030R.string.share_share)));
    }

    public static /* synthetic */ void u0(FragmentNetwork fragmentNetwork, LatLng latLng) {
        if (fragmentNetwork.c1()) {
            fragmentNetwork.Z0();
            return;
        }
        C0891s activity = fragmentNetwork.getActivity();
        if (activity != null) {
            Toast makeText = Toast.makeText(activity, fragmentNetwork.getString(C2030R.string.main_nointernet), 0);
            makeText.setGravity(17, 0, 0);
            makeText.show();
        }
    }

    public static /* synthetic */ void v0(DialogInterface dialogInterface, int i8) {
    }

    public static /* synthetic */ void w0(FragmentNetwork fragmentNetwork, View view) {
        C0891s activity = fragmentNetwork.getActivity();
        if (activity != null) {
            Intent intent = new Intent().setClass(activity, InAppActivity.class);
            fragmentNetwork.f12878p0 = intent;
            intent.putExtra("show_map_button", true);
            fragmentNetwork.startActivity(fragmentNetwork.f12878p0);
        }
    }

    public static /* synthetic */ void x0(FragmentNetwork fragmentNetwork, View view) {
        fragmentNetwork.getClass();
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("vnd.youtube:" + fragmentNetwork.getString(C2030R.string.options_video_functioning)));
        Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse("https://www.youtube.com/watch?v=" + fragmentNetwork.getString(C2030R.string.options_video_functioning)));
        try {
            fragmentNetwork.startActivity(intent);
        } catch (ActivityNotFoundException unused) {
            fragmentNetwork.startActivity(intent2);
        }
    }

    public static /* synthetic */ void y0(FragmentNetwork fragmentNetwork, View view) {
        if (!fragmentNetwork.c1()) {
            Toast makeText = Toast.makeText(fragmentNetwork.getActivity(), fragmentNetwork.getString(C2030R.string.main_nointernet), 1);
            makeText.setGravity(17, 0, 0);
            makeText.show();
            return;
        }
        float f8 = fragmentNetwork.f12877o0.getFloat("current_latitude", BitmapDescriptorFactory.HUE_RED);
        float f9 = fragmentNetwork.f12877o0.getFloat("current_longitude", BitmapDescriptorFactory.HUE_RED);
        if (f8 == BitmapDescriptorFactory.HUE_RED || f9 == BitmapDescriptorFactory.HUE_RED) {
            FragmentNetwork fragmentNetwork2 = fragmentNetwork;
            Toast makeText2 = Toast.makeText(fragmentNetwork2.getActivity(), fragmentNetwork2.getString(C2030R.string.main_areacheck_geo), 1);
            makeText2.setGravity(17, 0, 0);
            makeText2.show();
            return;
        }
        FragmentNetwork fragmentNetwork3 = fragmentNetwork;
        new c(fragmentNetwork3, (double) f8, (double) f9, (a) null).execute(new Context[]{fragmentNetwork3.getActivity()});
    }

    public static /* synthetic */ void z0(FragmentNetwork fragmentNetwork, View view) {
        fragmentNetwork.getClass();
        try {
            C0891s activity = fragmentNetwork.getActivity();
            if (activity != null) {
                activity.getPackageManager().getPackageInfo("com.twitter.android", 0);
                fragmentNetwork.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("twitter://user?user_id=1707171247")));
            }
        } catch (Exception unused) {
            fragmentNetwork.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("https://twitter.com/SismoDetector")));
        }
    }

    public void onActivityResult(int i8, int i9, Intent intent) {
        String stringExtra;
        C0891s activity;
        C0891s activity2;
        super.onActivityResult(i8, i9, intent);
        if (i8 == 2) {
            SharedPreferences.Editor edit = this.f12877o0.edit();
            int i10 = this.f12877o0.getInt("access_counter_rating", 0);
            if (i10 >= 0) {
                i10++;
                edit.putInt("access_counter_rating", i10);
                edit.apply();
            }
            if (i10 % 400 == 0 && (activity2 = getActivity()) != null) {
                E3.c a8 = E3.d.a(activity2.getApplicationContext());
                a8.a().addOnCompleteListener(new K0(a8, activity2));
            }
            if (i9 == 0 && intent != null && (stringExtra = intent.getStringExtra("memory")) != null && stringExtra.equalsIgnoreCase("low") && (activity = getActivity()) != null) {
                AlertDialog.Builder builder = new AlertDialog.Builder(activity);
                builder.setMessage(getString(C2030R.string.low_memory));
                builder.setCancelable(true);
                builder.setNegativeButton(getString(C2030R.string.official_close), new L0());
                builder.create().show();
            }
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f12880r0 = bundle;
        C0891s activity = getActivity();
        if (activity != null) {
            this.f12877o0 = activity.getSharedPreferences(MainActivity.class.getSimpleName(), 0);
        }
        View inflate = layoutInflater.inflate(C2030R.layout.network_card, viewGroup, false);
        this.f12876n0 = inflate;
        TextView textView = (TextView) inflate.findViewById(C2030R.id.textView08);
        textView.setPaintFlags(textView.getPaintFlags() | 8);
        textView.setOnClickListener(new P0(this));
        ((CardView) this.f12876n0.findViewById(C2030R.id.cardAlarm)).setOnClickListener(new V0(this));
        ((Button) this.f12876n0.findViewById(C2030R.id.button01)).setOnClickListener(new W0(this, activity));
        ((Button) this.f12876n0.findViewById(C2030R.id.button05)).setOnClickListener(new D0(this));
        ((Button) this.f12876n0.findViewById(C2030R.id.button13)).setOnClickListener(new E0(this));
        ((Button) this.f12876n0.findViewById(C2030R.id.button02)).setOnClickListener(new F0(this));
        ((Button) this.f12876n0.findViewById(C2030R.id.button11)).setOnClickListener(new G0(this));
        ((Button) this.f12876n0.findViewById(C2030R.id.button10)).setOnClickListener(new H0(this));
        ((Button) this.f12876n0.findViewById(C2030R.id.button03)).setOnClickListener(new I0(this));
        ((Button) this.f12876n0.findViewById(C2030R.id.button12)).setOnClickListener(new J0(this));
        ((Button) this.f12876n0.findViewById(C2030R.id.button04)).setOnClickListener(new Q0(this));
        ((Button) this.f12876n0.findViewById(C2030R.id.button05)).setOnClickListener(new R0(this));
        Button button = (Button) this.f12876n0.findViewById(C2030R.id.button06);
        String string = this.f12877o0.getString("pro_conversion_price", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        if (!string.equals(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED)) {
            button.setText(getString(C2030R.string.network_pro) + " - " + string + " " + getString(C2030R.string.inapp_onetime));
        }
        button.setOnClickListener(new S0(this, activity));
        ((Button) this.f12876n0.findViewById(C2030R.id.button07)).setOnClickListener(new T0(this));
        ((Button) this.f12876n0.findViewById(C2030R.id.button14)).setOnClickListener(new U0(this));
        if (this.f12877o0.getBoolean("compact_view", true)) {
            V0();
        } else {
            f1();
        }
        requireActivity().addMenuProvider(new a(), getViewLifecycleOwner(), C0910l.b.RESUMED);
        return this.f12876n0;
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public void onMapReady(GoogleMap googleMap) {
        float f8 = this.f12877o0.getFloat("latitude_eqn", BitmapDescriptorFactory.HUE_RED);
        float f9 = this.f12877o0.getFloat("longitude_eqn", BitmapDescriptorFactory.HUE_RED);
        float f10 = this.f12877o0.getFloat("magnitude_eqn", BitmapDescriptorFactory.HUE_RED);
        LatLng latLng = new LatLng((double) f8, (double) f9);
        googleMap.getUiSettings().setMapToolbarEnabled(false);
        googleMap.setMapType(1);
        googleMap.setMapColorScheme(2);
        googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 6.0f));
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.anchor(0.5f, 0.5f);
        if (f10 < 3.0f) {
            markerOptions.icon(BitmapDescriptorFactory.fromResource(2131231367));
        } else if (f10 < 5.0f) {
            markerOptions.icon(BitmapDescriptorFactory.fromResource(2131231363));
        } else {
            markerOptions.icon(BitmapDescriptorFactory.fromResource(2131231361));
        }
        googleMap.addMarker(markerOptions);
        googleMap.setOnMapClickListener(new N0(this));
        UiSettings uiSettings = googleMap.getUiSettings();
        uiSettings.setMyLocationButtonEnabled(false);
        uiSettings.setZoomControlsEnabled(false);
        uiSettings.setZoomGesturesEnabled(false);
        uiSettings.setAllGesturesEnabled(false);
        uiSettings.setScrollGesturesEnabled(false);
    }

    public void onPause() {
        super.onPause();
        this.f12879q0 = false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:112:0x03ac  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x0532  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResume() {
        /*
            r25 = this;
            r0 = r25
            super.onResume()
            androidx.fragment.app.s r10 = r0.getActivity()
            r11 = 1
            r0.f12879q0 = r11
            android.content.SharedPreferences r1 = r0.f12877o0
            java.lang.String r2 = "pro_features"
            r12 = 0
            boolean r1 = r1.getBoolean(r2, r12)
            android.content.SharedPreferences r2 = r0.f12877o0
            java.lang.String r3 = "network_count_last_updated"
            r13 = 0
            long r2 = r2.getLong(r3, r13)
            long r4 = java.lang.System.currentTimeMillis()
            long r4 = r4 - r2
            r2 = 20000(0x4e20, double:9.8813E-320)
            int r2 = (r4 > r2 ? 1 : (r4 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x002c
            r2 = r11
            goto L_0x002d
        L_0x002c:
            r2 = r12
        L_0x002d:
            boolean r3 = r0.c1()
            if (r3 == 0) goto L_0x0039
            if (r2 == 0) goto L_0x0039
            r0.Y0()
            goto L_0x003c
        L_0x0039:
            r0.X0()
        L_0x003c:
            android.view.View r2 = r0.f12876n0
            r3 = 2131296439(0x7f0900b7, float:1.8210795E38)
            android.view.View r2 = r2.findViewById(r3)
            androidx.cardview.widget.CardView r2 = (androidx.cardview.widget.CardView) r2
            r15 = 8
            if (r1 == 0) goto L_0x004f
            r2.setVisibility(r12)
            goto L_0x0052
        L_0x004f:
            r2.setVisibility(r15)
        L_0x0052:
            android.view.View r2 = r0.f12876n0
            r3 = 2131296467(0x7f0900d3, float:1.8210852E38)
            android.view.View r2 = r2.findViewById(r3)
            androidx.cardview.widget.CardView r2 = (androidx.cardview.widget.CardView) r2
            if (r1 == 0) goto L_0x0063
            r2.setVisibility(r15)
            goto L_0x007b
        L_0x0063:
            r2.setVisibility(r12)
            android.view.View r1 = r0.f12876n0
            r2 = 2131297044(0x7f090314, float:1.8212022E38)
            android.view.View r1 = r1.findViewById(r2)
            android.widget.TextView r1 = (android.widget.TextView) r1
            r2 = 2131886675(0x7f120253, float:1.9407936E38)
            java.lang.String r2 = r0.getString(r2)
            r1.setText(r2)
        L_0x007b:
            android.content.SharedPreferences r1 = r0.f12877o0
            java.lang.String r2 = "access_counter"
            int r1 = r1.getInt(r2, r12)
            android.view.View r3 = r0.f12876n0
            r4 = 2131296426(0x7f0900aa, float:1.8210768E38)
            android.view.View r3 = r3.findViewById(r4)
            androidx.cardview.widget.CardView r3 = (androidx.cardview.widget.CardView) r3
            android.view.View r4 = r0.f12876n0
            r5 = 2131296451(0x7f0900c3, float:1.821082E38)
            android.view.View r4 = r4.findViewById(r5)
            androidx.cardview.widget.CardView r4 = (androidx.cardview.widget.CardView) r4
            android.view.View r5 = r0.f12876n0
            r6 = 2131297043(0x7f090313, float:1.821202E38)
            android.view.View r5 = r5.findViewById(r6)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r6 = 30
            if (r1 > r6) goto L_0x00ab
            r6 = -1
            if (r1 != r6) goto L_0x00b5
        L_0x00ab:
            r6 = 2131886645(0x7f120235, float:1.9407875E38)
            java.lang.String r6 = r0.getString(r6)
            r5.setText(r6)
        L_0x00b5:
            if (r1 < 0) goto L_0x00c4
            int r1 = r1 + r11
            android.content.SharedPreferences r5 = r0.f12877o0
            android.content.SharedPreferences$Editor r5 = r5.edit()
            r5.putInt(r2, r1)
            r5.apply()
        L_0x00c4:
            android.content.SharedPreferences r1 = r0.f12877o0
            java.lang.String r2 = "datetime_eqn"
            java.lang.String r5 = "no_data"
            java.lang.String r1 = r1.getString(r2, r5)
            boolean r2 = r1.equalsIgnoreCase(r5)
            java.lang.String r6 = " "
            if (r2 != 0) goto L_0x0390
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
            java.lang.String r7 = "yyyy-MM-dd HH:mm:ss"
            java.util.Locale r8 = java.util.Locale.getDefault()
            r2.<init>(r7, r8)
            java.lang.String r7 = "Europe/Rome"
            java.util.TimeZone r7 = java.util.TimeZone.getTimeZone(r7)
            r2.setTimeZone(r7)
            java.util.Date r1 = r2.parse(r1)     // Catch:{ ParseException -> 0x0381 }
            java.util.Date r2 = new java.util.Date     // Catch:{ ParseException -> 0x0381 }
            r2.<init>()     // Catch:{ ParseException -> 0x0381 }
            long r7 = r2.getTime()     // Catch:{ ParseException -> 0x0381 }
            long r1 = r1.getTime()     // Catch:{ ParseException -> 0x0381 }
            long r7 = r7 - r1
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ ParseException -> 0x0381 }
            long r1 = r1.toMinutes(r7)     // Catch:{ ParseException -> 0x0381 }
            r7 = 600(0x258, double:2.964E-321)
            int r7 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r7 >= 0) goto L_0x0383
            r3.setVisibility(r12)     // Catch:{ ParseException -> 0x0381 }
            r4.setVisibility(r15)     // Catch:{ ParseException -> 0x0381 }
            android.content.SharedPreferences r7 = r0.f12877o0     // Catch:{ ParseException -> 0x0381 }
            java.lang.String r8 = "latitude_eqn"
            r13 = 0
            float r7 = r7.getFloat(r8, r13)     // Catch:{ ParseException -> 0x0381 }
            android.content.SharedPreferences r8 = r0.f12877o0     // Catch:{ ParseException -> 0x0381 }
            java.lang.String r14 = "longitude_eqn"
            float r8 = r8.getFloat(r14, r13)     // Catch:{ ParseException -> 0x0381 }
            android.content.SharedPreferences r14 = r0.f12877o0     // Catch:{ ParseException -> 0x0381 }
            java.lang.String r5 = "magnitude_eqn"
            float r5 = r14.getFloat(r5, r13)     // Catch:{ ParseException -> 0x0381 }
            android.content.SharedPreferences r14 = r0.f12877o0     // Catch:{ ParseException -> 0x0381 }
            java.lang.String r9 = "current_latitude"
            float r9 = r14.getFloat(r9, r13)     // Catch:{ ParseException -> 0x0381 }
            android.content.SharedPreferences r14 = r0.f12877o0     // Catch:{ ParseException -> 0x0381 }
            java.lang.String r11 = "current_longitude"
            float r11 = r14.getFloat(r11, r13)     // Catch:{ ParseException -> 0x0381 }
            android.content.SharedPreferences r14 = r0.f12877o0     // Catch:{ ParseException -> 0x0381 }
            java.lang.String r15 = "location_eqn"
            java.lang.String r13 = ""
            java.lang.String r13 = r14.getString(r15, r13)     // Catch:{ ParseException -> 0x0381 }
            android.content.SharedPreferences r14 = r0.f12877o0     // Catch:{ ParseException -> 0x0381 }
            java.lang.String r15 = "pos_eqn"
            int r14 = r14.getInt(r15, r12)     // Catch:{ ParseException -> 0x0381 }
            android.content.SharedPreferences r15 = r0.f12877o0     // Catch:{ ParseException -> 0x0381 }
            java.lang.String r12 = "intensity_at_location_eqn"
            r19 = r6
            r6 = 0
            float r12 = r15.getFloat(r12, r6)     // Catch:{ ParseException -> 0x037c }
            android.content.SharedPreferences r6 = r0.f12877o0     // Catch:{ ParseException -> 0x037c }
            java.lang.String r15 = "alert_shown_eqn"
            r20 = r13
            r13 = 0
            boolean r6 = r6.getBoolean(r15, r13)     // Catch:{ ParseException -> 0x037c }
            android.view.View r13 = r0.f12876n0     // Catch:{ ParseException -> 0x037c }
            r15 = 2131297049(0x7f090319, float:1.8212032E38)
            android.view.View r13 = r13.findViewById(r15)     // Catch:{ ParseException -> 0x037c }
            android.widget.TextView r13 = (android.widget.TextView) r13     // Catch:{ ParseException -> 0x037c }
            r15 = 1000(0x3e8, float:1.401E-42)
            if (r14 > r15) goto L_0x0178
            r15 = 8
            r13.setVisibility(r15)     // Catch:{ ParseException -> 0x037c }
            r21 = r3
            r22 = r4
            goto L_0x01b1
        L_0x0178:
            java.text.NumberFormat r15 = java.text.NumberFormat.getIntegerInstance()     // Catch:{ ParseException -> 0x037c }
            r21 = r3
            r22 = r4
            double r3 = (double) r14     // Catch:{ ParseException -> 0x037c }
            r23 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r3 = r3 / r23
            double r3 = java.lang.Math.ceil(r3)     // Catch:{ ParseException -> 0x037c }
            double r3 = r3 * r23
            long r3 = java.lang.Math.round(r3)     // Catch:{ ParseException -> 0x037c }
            int r3 = (int) r3     // Catch:{ ParseException -> 0x037c }
            long r3 = (long) r3     // Catch:{ ParseException -> 0x037c }
            java.lang.String r3 = r15.format(r3)     // Catch:{ ParseException -> 0x037c }
            r4 = 0
            r13.setVisibility(r4)     // Catch:{ ParseException -> 0x037c }
            r14 = 2131886694(0x7f120266, float:1.9407974E38)
            java.lang.String r14 = r0.getString(r14)     // Catch:{ ParseException -> 0x037c }
            r18 = r4
            r15 = 1
            java.lang.Object[] r4 = new java.lang.Object[r15]     // Catch:{ ParseException -> 0x037c }
            r4[r18] = r3     // Catch:{ ParseException -> 0x037c }
            java.lang.String r3 = java.lang.String.format(r14, r4)     // Catch:{ ParseException -> 0x037c }
            r13.setText(r3)     // Catch:{ ParseException -> 0x037c }
        L_0x01b1:
            android.view.View r3 = r0.f12876n0     // Catch:{ ParseException -> 0x037c }
            r4 = 2131297045(0x7f090315, float:1.8212024E38)
            android.view.View r3 = r3.findViewById(r4)     // Catch:{ ParseException -> 0x037c }
            android.widget.TextView r3 = (android.widget.TextView) r3     // Catch:{ ParseException -> 0x037c }
            java.text.DecimalFormatSymbols r4 = java.text.DecimalFormatSymbols.getInstance()     // Catch:{ ParseException -> 0x037c }
            r13 = 46
            r4.setDecimalSeparator(r13)     // Catch:{ ParseException -> 0x037c }
            java.text.DecimalFormat r13 = new java.text.DecimalFormat     // Catch:{ ParseException -> 0x037c }
            java.lang.String r14 = "0.0"
            r13.<init>(r14, r4)     // Catch:{ ParseException -> 0x037c }
            r4 = 2131886623(0x7f12021f, float:1.940783E38)
            java.lang.String r4 = r0.getString(r4)     // Catch:{ ParseException -> 0x037c }
            double r14 = (double) r5     // Catch:{ ParseException -> 0x037c }
            java.lang.String r5 = r13.format(r14)     // Catch:{ ParseException -> 0x037c }
            r23 = r5
            r13 = 2
            java.lang.Object[] r5 = new java.lang.Object[r13]     // Catch:{ ParseException -> 0x037c }
            r18 = 0
            r5[r18] = r23     // Catch:{ ParseException -> 0x037c }
            r16 = 1
            r5[r16] = r20     // Catch:{ ParseException -> 0x037c }
            java.lang.String r4 = java.lang.String.format(r4, r5)     // Catch:{ ParseException -> 0x037c }
            r3.setText(r4)     // Catch:{ ParseException -> 0x037c }
            android.view.View r3 = r0.f12876n0     // Catch:{ ParseException -> 0x037c }
            r4 = 2131297046(0x7f090316, float:1.8212026E38)
            android.view.View r3 = r3.findViewById(r4)     // Catch:{ ParseException -> 0x037c }
            android.widget.TextView r3 = (android.widget.TextView) r3     // Catch:{ ParseException -> 0x037c }
            double r4 = (double) r12     // Catch:{ ParseException -> 0x037c }
            r12 = 4609434218613702656(0x3ff8000000000000, double:1.5)
            int r12 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            r23 = 4616752568008179712(0x4012000000000000, double:4.5)
            if (r12 >= 0) goto L_0x0218
            if (r6 == 0) goto L_0x020d
            r4 = 2131886698(0x7f12026a, float:1.9407982E38)
            java.lang.String r4 = r0.getString(r4)     // Catch:{ ParseException -> 0x037c }
            r3.setText(r4)     // Catch:{ ParseException -> 0x037c }
            goto L_0x0236
        L_0x020d:
            r4 = 2131886699(0x7f12026b, float:1.9407984E38)
            java.lang.String r4 = r0.getString(r4)     // Catch:{ ParseException -> 0x037c }
            r3.setText(r4)     // Catch:{ ParseException -> 0x037c }
            goto L_0x0236
        L_0x0218:
            r12 = 4613937818241073152(0x4008000000000000, double:3.0)
            int r6 = (r4 > r12 ? 1 : (r4 == r12 ? 0 : -1))
            if (r6 >= 0) goto L_0x0225
            r4 = 2131886696(0x7f120268, float:1.9407978E38)
            r3.setText(r4)     // Catch:{ ParseException -> 0x037c }
            goto L_0x0236
        L_0x0225:
            int r4 = (r4 > r23 ? 1 : (r4 == r23 ? 0 : -1))
            if (r4 >= 0) goto L_0x0230
            r4 = 2131886697(0x7f120269, float:1.940798E38)
            r3.setText(r4)     // Catch:{ ParseException -> 0x037c }
            goto L_0x0236
        L_0x0230:
            r4 = 2131886700(0x7f12026c, float:1.9407986E38)
            r3.setText(r4)     // Catch:{ ParseException -> 0x037c }
        L_0x0236:
            android.view.View r3 = r0.f12876n0     // Catch:{ ParseException -> 0x037c }
            r4 = 2131296560(0x7f090130, float:1.821104E38)
            android.view.View r3 = r3.findViewById(r4)     // Catch:{ ParseException -> 0x037c }
            r4 = 4611686018427387904(0x4000000000000000, double:2.0)
            int r6 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            r12 = 160(0xa0, float:2.24E-43)
            if (r6 >= 0) goto L_0x0252
            r6 = 115(0x73, float:1.61E-43)
            r13 = 12
            int r6 = android.graphics.Color.rgb(r13, r6, r12)     // Catch:{ ParseException -> 0x0369 }
            r3.setBackgroundColor(r6)     // Catch:{ ParseException -> 0x037c }
        L_0x0252:
            int r4 = (r14 > r4 ? 1 : (r14 == r4 ? 0 : -1))
            r5 = 4615063718147915776(0x400c000000000000, double:3.5)
            if (r4 < 0) goto L_0x0268
            int r4 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r4 >= 0) goto L_0x0268
            r4 = 35
            r13 = 12
            int r4 = android.graphics.Color.rgb(r13, r12, r4)     // Catch:{ ParseException -> 0x0369 }
            r3.setBackgroundColor(r4)     // Catch:{ ParseException -> 0x0369 }
            goto L_0x026a
        L_0x0268:
            r13 = 12
        L_0x026a:
            int r4 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r4 < 0) goto L_0x027e
            int r4 = (r14 > r23 ? 1 : (r14 == r23 ? 0 : -1))
            if (r4 >= 0) goto L_0x027e
            r4 = 244(0xf4, float:3.42E-43)
            r5 = 195(0xc3, float:2.73E-43)
            r6 = 0
            int r4 = android.graphics.Color.rgb(r4, r5, r6)     // Catch:{ ParseException -> 0x0369 }
            r3.setBackgroundColor(r4)     // Catch:{ ParseException -> 0x0369 }
        L_0x027e:
            int r4 = (r14 > r23 ? 1 : (r14 == r23 ? 0 : -1))
            r5 = 4617878467915022336(0x4016000000000000, double:5.5)
            if (r4 < 0) goto L_0x0292
            int r4 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r4 >= 0) goto L_0x0292
            r4 = 255(0xff, float:3.57E-43)
            r12 = 0
            int r4 = android.graphics.Color.rgb(r4, r12, r12)     // Catch:{ ParseException -> 0x0369 }
            r3.setBackgroundColor(r4)     // Catch:{ ParseException -> 0x0369 }
        L_0x0292:
            int r4 = (r14 > r5 ? 1 : (r14 == r5 ? 0 : -1))
            if (r4 < 0) goto L_0x02a3
            r4 = 60
            r5 = 252(0xfc, float:3.53E-43)
            r6 = 183(0xb7, float:2.56E-43)
            int r4 = android.graphics.Color.rgb(r6, r4, r5)     // Catch:{ ParseException -> 0x0369 }
            r3.setBackgroundColor(r4)     // Catch:{ ParseException -> 0x0369 }
        L_0x02a3:
            r17 = 0
            int r3 = (r7 > r17 ? 1 : (r7 == r17 ? 0 : -1))
            if (r3 == 0) goto L_0x036c
            int r3 = (r8 > r17 ? 1 : (r8 == r17 ? 0 : -1))
            if (r3 == 0) goto L_0x036c
            int r3 = (r9 > r17 ? 1 : (r9 == r17 ? 0 : -1))
            if (r3 == 0) goto L_0x036c
            int r3 = (r11 > r17 ? 1 : (r11 == r17 ? 0 : -1))
            if (r3 == 0) goto L_0x036c
            if (r10 == 0) goto L_0x0369
            android.content.SharedPreferences r3 = androidx.preference.g.b(r10)     // Catch:{ ParseException -> 0x0369 }
            java.lang.String r4 = "eqn_system_of_units"
            java.lang.String r5 = "0"
            java.lang.String r12 = r3.getString(r4, r5)     // Catch:{ ParseException -> 0x0369 }
            android.view.View r3 = r0.f12876n0     // Catch:{ ParseException -> 0x0369 }
            r4 = 2131297048(0x7f090318, float:1.821203E38)
            android.view.View r3 = r3.findViewById(r4)     // Catch:{ ParseException -> 0x0369 }
            r14 = r3
            android.widget.TextView r14 = (android.widget.TextView) r14     // Catch:{ ParseException -> 0x0369 }
            android.content.res.Resources r3 = r0.getResources()     // Catch:{ ParseException -> 0x0369 }
            int r1 = (int) r1     // Catch:{ ParseException -> 0x0369 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r1)     // Catch:{ ParseException -> 0x0369 }
            r15 = 1
            java.lang.Object[] r4 = new java.lang.Object[r15]     // Catch:{ ParseException -> 0x0369 }
            r18 = 0
            r4[r18] = r2     // Catch:{ ParseException -> 0x0369 }
            r2 = 2131755016(0x7f100008, float:1.91409E38)
            java.lang.String r15 = r3.getQuantityString(r2, r1, r4)     // Catch:{ ParseException -> 0x0369 }
            double r1 = (double) r7
            double r3 = (double) r8
            double r5 = (double) r9
            double r7 = (double) r11
            r9 = r19
            double r1 = r0.b1(r1, r3, r5, r7)     // Catch:{ ParseException -> 0x038e }
            java.lang.String r3 = "1"
            boolean r3 = r12.equalsIgnoreCase(r3)     // Catch:{ ParseException -> 0x038e }
            r4 = 2131886472(0x7f120188, float:1.9407524E38)
            if (r3 == 0) goto L_0x0321
            r5 = 4603772033682776338(0x3fe3e245d68a2112, double:0.621371192)
            double r1 = r1 * r5
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ ParseException -> 0x038e }
            r3.<init>()     // Catch:{ ParseException -> 0x038e }
            java.lang.String r4 = r0.getString(r4)     // Catch:{ ParseException -> 0x038e }
            r3.append(r4)     // Catch:{ ParseException -> 0x038e }
            r3.append(r9)     // Catch:{ ParseException -> 0x038e }
            int r1 = (int) r1     // Catch:{ ParseException -> 0x038e }
            r3.append(r1)     // Catch:{ ParseException -> 0x038e }
            java.lang.String r1 = " mi - "
            r3.append(r1)     // Catch:{ ParseException -> 0x038e }
            r3.append(r15)     // Catch:{ ParseException -> 0x038e }
            java.lang.String r1 = r3.toString()     // Catch:{ ParseException -> 0x038e }
            goto L_0x0340
        L_0x0321:
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ ParseException -> 0x038e }
            r3.<init>()     // Catch:{ ParseException -> 0x038e }
            java.lang.String r4 = r0.getString(r4)     // Catch:{ ParseException -> 0x038e }
            r3.append(r4)     // Catch:{ ParseException -> 0x038e }
            r3.append(r9)     // Catch:{ ParseException -> 0x038e }
            int r1 = (int) r1     // Catch:{ ParseException -> 0x038e }
            r3.append(r1)     // Catch:{ ParseException -> 0x038e }
            java.lang.String r1 = " km - "
            r3.append(r1)     // Catch:{ ParseException -> 0x038e }
            r3.append(r15)     // Catch:{ ParseException -> 0x038e }
            java.lang.String r1 = r3.toString()     // Catch:{ ParseException -> 0x038e }
        L_0x0340:
            r14.setText(r1)     // Catch:{ ParseException -> 0x038e }
            android.view.View r1 = r0.f12876n0     // Catch:{ ParseException -> 0x038e }
            r2 = 2131296736(0x7f0901e0, float:1.8211397E38)
            android.view.View r1 = r1.findViewById(r2)     // Catch:{ ParseException -> 0x038e }
            com.google.android.gms.maps.MapView r1 = (com.google.android.gms.maps.MapView) r1     // Catch:{ ParseException -> 0x038e }
            boolean r2 = r0.c1()     // Catch:{ ParseException -> 0x038e }
            if (r2 == 0) goto L_0x0363
            android.os.Bundle r2 = r0.f12880r0     // Catch:{ ParseException -> 0x038e }
            r1.onCreate(r2)     // Catch:{ ParseException -> 0x038e }
            r1.onStart()     // Catch:{ ParseException -> 0x038e }
            r1.onResume()     // Catch:{ ParseException -> 0x038e }
            r1.getMapAsync(r0)     // Catch:{ ParseException -> 0x038e }
            goto L_0x038e
        L_0x0363:
            r15 = 8
            r1.setVisibility(r15)     // Catch:{ ParseException -> 0x038e }
            goto L_0x038e
        L_0x0369:
            r9 = r19
            goto L_0x038e
        L_0x036c:
            r9 = r19
            r3 = r21
            r15 = 8
            r3.setVisibility(r15)     // Catch:{ ParseException -> 0x038e }
            r1 = r22
            r4 = 0
            r1.setVisibility(r4)     // Catch:{ ParseException -> 0x038e }
            goto L_0x038e
        L_0x037c:
            r9 = r19
        L_0x037e:
            r13 = 12
            goto L_0x038e
        L_0x0381:
            r9 = r6
            goto L_0x037e
        L_0x0383:
            r1 = r4
            r9 = r6
            r13 = 12
            r3.setVisibility(r15)     // Catch:{ ParseException -> 0x038e }
            r4 = 0
            r1.setVisibility(r4)     // Catch:{ ParseException -> 0x038e }
        L_0x038e:
            r4 = 0
            goto L_0x039b
        L_0x0390:
            r1 = r4
            r9 = r6
            r13 = 12
            r3.setVisibility(r15)
            r4 = 0
            r1.setVisibility(r4)
        L_0x039b:
            android.view.View r1 = r0.f12876n0
            r2 = 2131296443(0x7f0900bb, float:1.8210803E38)
            android.view.View r1 = r1.findViewById(r2)
            androidx.cardview.widget.CardView r1 = (androidx.cardview.widget.CardView) r1
            boolean r2 = r0.d1()
            if (r2 == 0) goto L_0x0532
            float[] r2 = r0.a1()
            if (r2 == 0) goto L_0x052c
            r3 = r2[r4]
            r16 = 1
            r2 = r2[r16]
            r5 = 2131297065(0x7f090329, float:1.8212064E38)
            if (r10 == 0) goto L_0x0403
            java.lang.Class<com.finazzi.distquake.MainActivity> r6 = com.finazzi.distquake.MainActivity.class
            java.lang.String r6 = r6.getSimpleName()
            android.content.SharedPreferences r6 = r10.getSharedPreferences(r6, r4)
            java.lang.String r4 = "current_location_time"
            r7 = 0
            long r6 = r6.getLong(r4, r7)
            java.text.SimpleDateFormat r4 = new java.text.SimpleDateFormat
            java.lang.String r8 = "dd-MM-yyyy HH:mm"
            java.util.Locale r10 = java.util.Locale.getDefault()
            r4.<init>(r8, r10)
            java.util.Date r8 = new java.util.Date
            r8.<init>(r6)
            android.view.View r6 = r0.f12876n0
            android.view.View r5 = r6.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            r6 = 2131887169(0x7f120441, float:1.9408937E38)
            java.lang.String r6 = r0.getString(r6)
            java.lang.String r4 = r4.format(r8)
            r15 = 1
            java.lang.Object[] r7 = new java.lang.Object[r15]
            r12 = 0
            r7[r12] = r4
            java.lang.String r4 = java.lang.String.format(r6, r7)
            r5.setText(r4)
            r5.setVisibility(r12)
            goto L_0x0410
        L_0x0403:
            android.view.View r4 = r0.f12876n0
            android.view.View r4 = r4.findViewById(r5)
            android.widget.TextView r4 = (android.widget.TextView) r4
            r15 = 8
            r4.setVisibility(r15)
        L_0x0410:
            java.util.Calendar r4 = java.util.Calendar.getInstance()
            u2.I1 r5 = new u2.I1
            double r6 = (double) r3
            double r10 = (double) r2
            r5.<init>(r6, r10)
            java.util.TimeZone r6 = java.util.TimeZone.getDefault()
            if (r6 == 0) goto L_0x0526
            com.finazzi.distquake.b0 r1 = new com.finazzi.distquake.b0
            r1.<init>(r5, r6)
            java.util.Calendar r5 = r1.a(r4)
            java.util.Calendar r1 = r1.b(r4)
            if (r5 == 0) goto L_0x0537
            if (r1 == 0) goto L_0x0537
            android.view.View r4 = r0.f12876n0
            r6 = 2131297061(0x7f090325, float:1.8212056E38)
            android.view.View r4 = r4.findViewById(r6)
            android.widget.TextView r4 = (android.widget.TextView) r4
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.util.Locale r7 = java.util.Locale.getDefault()
            java.lang.Float r3 = java.lang.Float.valueOf(r3)
            r15 = 1
            java.lang.Object[] r8 = new java.lang.Object[r15]
            r18 = 0
            r8[r18] = r3
            java.lang.String r3 = "%.3f"
            java.lang.String r7 = java.lang.String.format(r7, r3, r8)
            r6.append(r7)
            r7 = 2131887130(0x7f12041a, float:1.9408858E38)
            java.lang.String r7 = r0.getString(r7)
            r6.append(r7)
            r6.append(r9)
            java.util.Locale r7 = java.util.Locale.getDefault()
            java.lang.Float r2 = java.lang.Float.valueOf(r2)
            java.lang.Object[] r8 = new java.lang.Object[r15]
            r8[r18] = r2
            java.lang.String r2 = java.lang.String.format(r7, r3, r8)
            r6.append(r2)
            r2 = 2131887131(0x7f12041b, float:1.940886E38)
            java.lang.String r2 = r0.getString(r2)
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            r4.setText(r2)
            android.view.View r2 = r0.f12876n0
            r3 = 2131297062(0x7f090326, float:1.8212058E38)
            android.view.View r2 = r2.findViewById(r3)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.util.Locale r4 = java.util.Locale.getDefault()
            r6 = 11
            int r7 = r5.get(r6)
            java.lang.Integer r7 = java.lang.Integer.valueOf(r7)
            int r8 = r5.get(r13)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r10 = 2
            java.lang.Object[] r11 = new java.lang.Object[r10]
            r18 = 0
            r11[r18] = r7
            r16 = 1
            r11[r16] = r8
            java.lang.String r7 = "%02d:%02d"
            java.lang.String r4 = java.lang.String.format(r4, r7, r11)
            r3.append(r4)
            r3.append(r9)
            java.util.TimeZone r4 = r5.getTimeZone()
            java.lang.String r4 = r4.getDisplayName()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r2.setText(r3)
            android.view.View r2 = r0.f12876n0
            r3 = 2131297064(0x7f090328, float:1.8212062E38)
            android.view.View r2 = r2.findViewById(r3)
            android.widget.TextView r2 = (android.widget.TextView) r2
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.util.Locale r4 = java.util.Locale.getDefault()
            int r6 = r1.get(r6)
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            int r1 = r1.get(r13)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r10 = 2
            java.lang.Object[] r8 = new java.lang.Object[r10]
            r18 = 0
            r8[r18] = r6
            r16 = 1
            r8[r16] = r1
            java.lang.String r1 = java.lang.String.format(r4, r7, r8)
            r3.append(r1)
            r3.append(r9)
            java.util.TimeZone r1 = r5.getTimeZone()
            java.lang.String r1 = r1.getDisplayName()
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.setText(r1)
            goto L_0x0537
        L_0x0526:
            r15 = 8
            r1.setVisibility(r15)
            goto L_0x0537
        L_0x052c:
            r15 = 8
            r1.setVisibility(r15)
            goto L_0x0537
        L_0x0532:
            r15 = 8
            r1.setVisibility(r15)
        L_0x0537:
            r0.W0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.FragmentNetwork.onResume():void");
    }

    public void onStop() {
        super.onStop();
        ((ProgressBar) this.f12876n0.findViewById(C2030R.id.progressBar2)).setVisibility(8);
    }

    private class b extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private String f12885a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f12886b;

        private b() {
            this.f12885a = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00b5, code lost:
            r0.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x00b1 */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x00b5  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x00bb  */
        /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r7) {
            /*
                r6 = this;
                r7 = 0
                com.finazzi.distquake.FragmentNetwork r0 = com.finazzi.distquake.FragmentNetwork.this
                boolean r0 = r0.isAdded()
                com.finazzi.distquake.FragmentNetwork r1 = com.finazzi.distquake.FragmentNetwork.this
                androidx.fragment.app.s r1 = r1.getActivity()
                r2 = 1
                if (r1 == 0) goto L_0x00bf
                if (r0 == 0) goto L_0x00bf
                r0 = 0
                com.finazzi.distquake.FragmentNetwork r1 = com.finazzi.distquake.FragmentNetwork.this     // Catch:{ IOException -> 0x00b1 }
                android.content.SharedPreferences r1 = r1.f12877o0     // Catch:{ IOException -> 0x00b1 }
                java.lang.String r3 = "sub_domain"
                com.finazzi.distquake.FragmentNetwork r4 = com.finazzi.distquake.FragmentNetwork.this     // Catch:{ IOException -> 0x00b1 }
                r5 = 2131887099(0x7f1203fb, float:1.9408796E38)
                java.lang.String r4 = r4.getString(r5)     // Catch:{ IOException -> 0x00b1 }
                java.lang.String r1 = r1.getString(r3, r4)     // Catch:{ IOException -> 0x00b1 }
                com.finazzi.distquake.FragmentNetwork r3 = com.finazzi.distquake.FragmentNetwork.this     // Catch:{ IOException -> 0x00b1 }
                r4 = 2131887098(0x7f1203fa, float:1.9408793E38)
                java.lang.String r3 = r3.getString(r4)     // Catch:{ IOException -> 0x00b1 }
                java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ IOException -> 0x00b1 }
                r4[r7] = r1     // Catch:{ IOException -> 0x00b1 }
                java.lang.String r1 = java.lang.String.format(r3, r4)     // Catch:{ IOException -> 0x00b1 }
                java.net.URL r3 = new java.net.URL     // Catch:{ IOException -> 0x00b1 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00b1 }
                r4.<init>()     // Catch:{ IOException -> 0x00b1 }
                r4.append(r1)     // Catch:{ IOException -> 0x00b1 }
                java.lang.String r1 = "distquake_count_redis3.php"
                r4.append(r1)     // Catch:{ IOException -> 0x00b1 }
                java.lang.String r1 = r4.toString()     // Catch:{ IOException -> 0x00b1 }
                r3.<init>(r1)     // Catch:{ IOException -> 0x00b1 }
                java.net.URLConnection r1 = r3.openConnection()     // Catch:{ IOException -> 0x00b1 }
                java.lang.Object r1 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r1)     // Catch:{ IOException -> 0x00b1 }
                java.net.URLConnection r1 = (java.net.URLConnection) r1     // Catch:{ IOException -> 0x00b1 }
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ IOException -> 0x00b1 }
                r1.setDoOutput(r7)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r0 = 10000(0x2710, float:1.4013E-41)
                r1.setConnectTimeout(r0)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r1.setReadTimeout(r0)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.lang.String r0 = "Content-Type"
                java.lang.String r3 = "application/x-www-form-urlencoded;charset=utf-8"
                r1.setRequestProperty(r0, r3)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.lang.String r0 = "GET"
                r1.setRequestMethod(r0)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.io.InputStream r3 = r1.getInputStream()     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r0.<init>(r3)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r4.<init>(r0, r5)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r3.<init>(r4)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r4.<init>()     // Catch:{ IOException -> 0x009e, all -> 0x009b }
            L_0x008c:
                java.lang.String r5 = r3.readLine()     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                if (r5 == 0) goto L_0x00a0
                r4.append(r5)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.lang.String r5 = "\n"
                r4.append(r5)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                goto L_0x008c
            L_0x009b:
                r7 = move-exception
                r0 = r1
                goto L_0x00b9
            L_0x009e:
                r0 = r1
                goto L_0x00b1
            L_0x00a0:
                r0.close()     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.lang.String r0 = r4.toString()     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r6.f12885a = r0     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r6.f12886b = r7     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r1.disconnect()
                goto L_0x00c1
            L_0x00af:
                r7 = move-exception
                goto L_0x00b9
            L_0x00b1:
                r6.f12886b = r2     // Catch:{ all -> 0x00af }
                if (r0 == 0) goto L_0x00c1
                r0.disconnect()
                goto L_0x00c1
            L_0x00b9:
                if (r0 == 0) goto L_0x00be
                r0.disconnect()
            L_0x00be:
                throw r7
            L_0x00bf:
                r6.f12886b = r2
            L_0x00c1:
                java.lang.String r7 = "COMPLETE!"
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.FragmentNetwork.b.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x0300 A[Catch:{ JSONException -> 0x030c }] */
        /* JADX WARNING: Removed duplicated region for block: B:52:? A[RETURN, SYNTHETIC] */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onPostExecute(java.lang.String r40) {
            /*
                r39 = this;
                r1 = r39
                java.lang.String r2 = "EQN"
                super.onPostExecute(r40)
                boolean r0 = r1.f12886b
                if (r0 != 0) goto L_0x031c
                com.finazzi.distquake.FragmentNetwork r0 = com.finazzi.distquake.FragmentNetwork.this
                boolean r0 = r0.f12879q0
                if (r0 == 0) goto L_0x031c
                org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ JSONException -> 0x030a }
                java.lang.String r3 = r1.f12885a     // Catch:{ JSONException -> 0x030a }
                r0.<init>(r3)     // Catch:{ JSONException -> 0x030a }
                int r3 = r0.length()     // Catch:{ JSONException -> 0x030a }
                if (r3 <= 0) goto L_0x031c
                r3 = 0
                org.json.JSONObject r4 = r0.getJSONObject(r3)     // Catch:{ JSONException -> 0x00a3 }
                java.lang.String r5 = "eq"
                int r4 = r4.getInt(r5)     // Catch:{ JSONException -> 0x00a3 }
                r5 = 1
                org.json.JSONObject r6 = r0.getJSONObject(r5)     // Catch:{ JSONException -> 0x00a3 }
                java.lang.String r7 = "eq_p"
                int r6 = r6.getInt(r7)     // Catch:{ JSONException -> 0x00a3 }
                r7 = 2
                org.json.JSONObject r7 = r0.getJSONObject(r7)     // Catch:{ JSONException -> 0x00a3 }
                java.lang.String r8 = "green"
                int r7 = r7.getInt(r8)     // Catch:{ JSONException -> 0x00a3 }
                r8 = 3
                org.json.JSONObject r8 = r0.getJSONObject(r8)     // Catch:{ JSONException -> 0x00a3 }
                java.lang.String r9 = "man"
                int r8 = r8.getInt(r9)     // Catch:{ JSONException -> 0x00a3 }
                r9 = 4
                org.json.JSONObject r9 = r0.getJSONObject(r9)     // Catch:{ JSONException -> 0x00a3 }
                java.lang.String r10 = "diff"
                int r9 = r9.getInt(r10)     // Catch:{ JSONException -> 0x00a3 }
                r10 = 5
                org.json.JSONObject r10 = r0.getJSONObject(r10)     // Catch:{ JSONException -> 0x00a3 }
                java.lang.String r11 = "st"
                int r10 = r10.getInt(r11)     // Catch:{ JSONException -> 0x00a3 }
                r11 = 6
                org.json.JSONObject r11 = r0.getJSONObject(r11)     // Catch:{ JSONException -> 0x00a3 }
                java.lang.String r12 = "lc"
                java.lang.String r12 = r11.getString(r12)     // Catch:{ JSONException -> 0x00a3 }
                java.lang.String r13 = ""
                java.lang.String r14 = "_"
                boolean r14 = r12.equals(r14)     // Catch:{ JSONException -> 0x00a3 }
                if (r14 != 0) goto L_0x00a8
                java.lang.String r13 = "ma"
                double r13 = r11.getDouble(r13)     // Catch:{ JSONException -> 0x00a3 }
                float r13 = (float) r13     // Catch:{ JSONException -> 0x00a3 }
                java.lang.String r14 = "la"
                double r14 = r11.getDouble(r14)     // Catch:{ JSONException -> 0x00a3 }
                float r14 = (float) r14     // Catch:{ JSONException -> 0x00a3 }
                java.lang.String r15 = "lo"
                r16 = r6
                double r5 = r11.getDouble(r15)     // Catch:{ JSONException -> 0x00a3 }
                float r5 = (float) r5     // Catch:{ JSONException -> 0x00a3 }
                java.lang.String r6 = "re"
                int r6 = r11.getInt(r6)     // Catch:{ JSONException -> 0x00a3 }
                java.lang.String r15 = "dt"
                java.lang.String r15 = r11.getString(r15)     // Catch:{ JSONException -> 0x00a3 }
                java.lang.String r3 = "up"
                int r3 = r11.getInt(r3)     // Catch:{ JSONException -> 0x00a3 }
                r11 = r13
                r13 = r15
                goto L_0x00b0
            L_0x00a3:
                r0 = move-exception
                r17 = r2
                goto L_0x02fa
            L_0x00a8:
                r16 = r6
                r3 = 0
                r5 = r3
                r11 = r5
                r14 = r11
                r3 = 0
                r6 = 0
            L_0x00b0:
                r15 = 7
                org.json.JSONObject r15 = r0.getJSONObject(r15)     // Catch:{ JSONException -> 0x00a3 }
                r17 = r2
                java.lang.String r2 = "at"
                double r18 = r15.getDouble(r2)     // Catch:{ JSONException -> 0x02f9 }
                r2 = 8
                org.json.JSONObject r2 = r0.getJSONObject(r2)     // Catch:{ JSONException -> 0x02f9 }
                java.lang.String r15 = "t10k"
                int r2 = r2.getInt(r15)     // Catch:{ JSONException -> 0x02f9 }
                r15 = 9
                org.json.JSONObject r15 = r0.getJSONObject(r15)     // Catch:{ JSONException -> 0x02f9 }
                r20 = r2
                java.lang.String r2 = "t100k"
                int r2 = r15.getInt(r2)     // Catch:{ JSONException -> 0x02f9 }
                r15 = 10
                org.json.JSONObject r15 = r0.getJSONObject(r15)     // Catch:{ JSONException -> 0x02f9 }
                r21 = r2
                java.lang.String r2 = "c_it"
                int r2 = r15.getInt(r2)     // Catch:{ JSONException -> 0x02f9 }
                r15 = 11
                org.json.JSONObject r15 = r0.getJSONObject(r15)     // Catch:{ JSONException -> 0x02f9 }
                r22 = r2
                java.lang.String r2 = "c_es"
                int r2 = r15.getInt(r2)     // Catch:{ JSONException -> 0x02f9 }
                r15 = 12
                org.json.JSONObject r15 = r0.getJSONObject(r15)     // Catch:{ JSONException -> 0x02f9 }
                r23 = r2
                java.lang.String r2 = "c_en"
                int r2 = r15.getInt(r2)     // Catch:{ JSONException -> 0x02f9 }
                r15 = 13
                org.json.JSONObject r15 = r0.getJSONObject(r15)     // Catch:{ JSONException -> 0x02f9 }
                r24 = r2
                java.lang.String r2 = "c_fr"
                int r2 = r15.getInt(r2)     // Catch:{ JSONException -> 0x02f9 }
                r15 = 14
                org.json.JSONObject r15 = r0.getJSONObject(r15)     // Catch:{ JSONException -> 0x02f9 }
                r25 = r2
                java.lang.String r2 = "c_el"
                int r2 = r15.getInt(r2)     // Catch:{ JSONException -> 0x02f9 }
                r15 = 15
                org.json.JSONObject r15 = r0.getJSONObject(r15)     // Catch:{ JSONException -> 0x02f9 }
                r26 = r2
                java.lang.String r2 = "c_tr"
                int r2 = r15.getInt(r2)     // Catch:{ JSONException -> 0x02f9 }
                r15 = 16
                org.json.JSONObject r15 = r0.getJSONObject(r15)     // Catch:{ JSONException -> 0x02f9 }
                r27 = r2
                java.lang.String r2 = "c_in"
                int r2 = r15.getInt(r2)     // Catch:{ JSONException -> 0x02f9 }
                r15 = 17
                org.json.JSONObject r15 = r0.getJSONObject(r15)     // Catch:{ JSONException -> 0x02f9 }
                r28 = r2
                java.lang.String r2 = "c_ta"
                int r2 = r15.getInt(r2)     // Catch:{ JSONException -> 0x02f9 }
                r15 = 18
                org.json.JSONObject r15 = r0.getJSONObject(r15)     // Catch:{ JSONException -> 0x02f9 }
                r29 = r2
                java.lang.String r2 = "c_jp"
                int r2 = r15.getInt(r2)     // Catch:{ JSONException -> 0x02f9 }
                r15 = 19
                org.json.JSONObject r15 = r0.getJSONObject(r15)     // Catch:{ JSONException -> 0x02f9 }
                r30 = r2
                java.lang.String r2 = "c_pt"
                int r2 = r15.getInt(r2)     // Catch:{ JSONException -> 0x02f9 }
                r15 = 20
                org.json.JSONObject r15 = r0.getJSONObject(r15)     // Catch:{ JSONException -> 0x02f9 }
                r31 = r2
                java.lang.String r2 = "c_blk"
                int r2 = r15.getInt(r2)     // Catch:{ JSONException -> 0x02f9 }
                r15 = 21
                org.json.JSONObject r15 = r0.getJSONObject(r15)     // Catch:{ JSONException -> 0x02f9 }
                r32 = r2
                java.lang.String r2 = "c_hu"
                int r2 = r15.getInt(r2)     // Catch:{ JSONException -> 0x02f9 }
                r15 = 22
                org.json.JSONObject r15 = r0.getJSONObject(r15)     // Catch:{ JSONException -> 0x02f9 }
                r33 = r2
                java.lang.String r2 = "c_mo"
                int r2 = r15.getInt(r2)     // Catch:{ JSONException -> 0x02f9 }
                r15 = 23
                org.json.JSONObject r15 = r0.getJSONObject(r15)     // Catch:{ JSONException -> 0x02f9 }
                r34 = r2
                java.lang.String r2 = "c_ar"
                int r2 = r15.getInt(r2)     // Catch:{ JSONException -> 0x02f9 }
                r15 = 24
                org.json.JSONObject r15 = r0.getJSONObject(r15)     // Catch:{ JSONException -> 0x02f9 }
                r35 = r2
                java.lang.String r2 = "c_ro"
                int r2 = r15.getInt(r2)     // Catch:{ JSONException -> 0x02f9 }
                r15 = 25
                org.json.JSONObject r15 = r0.getJSONObject(r15)     // Catch:{ JSONException -> 0x02f9 }
                r36 = r2
                java.lang.String r2 = "lk"
                java.lang.String r2 = r15.getString(r2)     // Catch:{ JSONException -> 0x02f9 }
                r15 = 26
                org.json.JSONObject r15 = r0.getJSONObject(r15)     // Catch:{ JSONException -> 0x02f9 }
                r37 = r2
                java.lang.String r2 = "c_th"
                int r2 = r15.getInt(r2)     // Catch:{ JSONException -> 0x02f9 }
                r15 = 27
                org.json.JSONObject r0 = r0.getJSONObject(r15)     // Catch:{ JSONException -> 0x02f9 }
                java.lang.String r15 = "c_my"
                int r0 = r0.getInt(r15)     // Catch:{ JSONException -> 0x02f9 }
                int r15 = r22 + r23
                int r15 = r15 + r24
                int r15 = r15 + r25
                int r15 = r15 + r26
                int r15 = r15 + r27
                int r15 = r15 + r28
                int r15 = r15 + r29
                int r15 = r15 + r30
                int r15 = r15 + r31
                int r15 = r15 + r32
                int r15 = r15 + r33
                int r15 = r15 + r34
                int r15 = r15 + r35
                int r15 = r15 + r36
                int r15 = r15 + r2
                int r15 = r15 + r0
                r38 = r15
                com.finazzi.distquake.FragmentNetwork r15 = com.finazzi.distquake.FragmentNetwork.this     // Catch:{ JSONException -> 0x02f9 }
                android.content.SharedPreferences r15 = r15.f12877o0     // Catch:{ JSONException -> 0x02f9 }
                android.content.SharedPreferences$Editor r15 = r15.edit()     // Catch:{ JSONException -> 0x02f9 }
                java.lang.String r1 = "network_count_quakes"
                r15.putInt(r1, r4)     // Catch:{ JSONException -> 0x0256 }
                java.lang.String r1 = "network_count_quakes_past"
                r4 = r16
                r15.putInt(r1, r4)     // Catch:{ JSONException -> 0x0256 }
                java.lang.String r1 = "network_count_green"
                r15.putInt(r1, r7)     // Catch:{ JSONException -> 0x0256 }
                java.lang.String r1 = "network_count_manual"
                r15.putInt(r1, r8)     // Catch:{ JSONException -> 0x0256 }
                java.lang.String r1 = "network_last_sub_minutes"
                r15.putInt(r1, r9)     // Catch:{ JSONException -> 0x0256 }
                java.lang.String r1 = "subscription_discount_type"
                r15.putInt(r1, r10)     // Catch:{ JSONException -> 0x0256 }
                java.lang.String r1 = "network_count_last_updated"
                long r7 = java.lang.System.currentTimeMillis()     // Catch:{ JSONException -> 0x0256 }
                r15.putLong(r1, r7)     // Catch:{ JSONException -> 0x0256 }
                java.lang.String r1 = "preliminary_location"
                r15.putString(r1, r12)     // Catch:{ JSONException -> 0x0256 }
                java.lang.String r1 = "preliminary_date"
                r15.putString(r1, r13)     // Catch:{ JSONException -> 0x0256 }
                java.lang.String r1 = "preliminary_reports"
                r15.putInt(r1, r6)     // Catch:{ JSONException -> 0x0256 }
                java.lang.String r1 = "preliminary_magnitude"
                r15.putFloat(r1, r11)     // Catch:{ JSONException -> 0x0256 }
                java.lang.String r1 = "preliminary_latitude"
                r15.putFloat(r1, r14)     // Catch:{ JSONException -> 0x0256 }
                java.lang.String r1 = "preliminary_longitude"
                r15.putFloat(r1, r5)     // Catch:{ JSONException -> 0x0256 }
                java.lang.String r1 = "preliminary_updates"
                r15.putInt(r1, r3)     // Catch:{ JSONException -> 0x0256 }
                double r3 = java.lang.Math.random()     // Catch:{ JSONException -> 0x0256 }
                int r1 = (r3 > r18 ? 1 : (r3 == r18 ? 0 : -1))
                java.lang.String r3 = "ads_type"
                if (r1 <= 0) goto L_0x025b
                r1 = 0
                r15.putInt(r3, r1)     // Catch:{ JSONException -> 0x0256 }
                goto L_0x025f
            L_0x0256:
                r0 = move-exception
                r1 = r39
                goto L_0x02fa
            L_0x025b:
                r1 = 1
                r15.putInt(r3, r1)     // Catch:{ JSONException -> 0x0256 }
            L_0x025f:
                java.lang.String r1 = "top_10k_available"
                r3 = r20
                r15.putInt(r1, r3)     // Catch:{ JSONException -> 0x0256 }
                java.lang.String r1 = "top_100k_available"
                r3 = r21
                r15.putInt(r1, r3)     // Catch:{ JSONException -> 0x0256 }
                java.lang.String r1 = "online_chat_ita"
                r3 = r22
                r15.putInt(r1, r3)     // Catch:{ JSONException -> 0x0256 }
                java.lang.String r1 = "online_chat_es"
                r3 = r23
                r15.putInt(r1, r3)     // Catch:{ JSONException -> 0x0256 }
                java.lang.String r1 = "online_chat_eng"
                r3 = r24
                r15.putInt(r1, r3)     // Catch:{ JSONException -> 0x0256 }
                java.lang.String r1 = "online_chat_fr"
                r3 = r25
                r15.putInt(r1, r3)     // Catch:{ JSONException -> 0x0256 }
                java.lang.String r1 = "online_chat_el"
                r3 = r26
                r15.putInt(r1, r3)     // Catch:{ JSONException -> 0x0256 }
                java.lang.String r1 = "online_chat_tr"
                r3 = r27
                r15.putInt(r1, r3)     // Catch:{ JSONException -> 0x0256 }
                java.lang.String r1 = "online_chat_in"
                r3 = r28
                r15.putInt(r1, r3)     // Catch:{ JSONException -> 0x0256 }
                java.lang.String r1 = "online_chat_tag"
                r3 = r29
                r15.putInt(r1, r3)     // Catch:{ JSONException -> 0x0256 }
                java.lang.String r1 = "online_chat_jp"
                r3 = r30
                r15.putInt(r1, r3)     // Catch:{ JSONException -> 0x0256 }
                java.lang.String r1 = "online_chat_pt"
                r3 = r31
                r15.putInt(r1, r3)     // Catch:{ JSONException -> 0x0256 }
                java.lang.String r1 = "online_chat_blk"
                r3 = r32
                r15.putInt(r1, r3)     // Catch:{ JSONException -> 0x0256 }
                java.lang.String r1 = "online_chat_hu"
                r3 = r33
                r15.putInt(r1, r3)     // Catch:{ JSONException -> 0x0256 }
                java.lang.String r1 = "online_chat_mo"
                r3 = r34
                r15.putInt(r1, r3)     // Catch:{ JSONException -> 0x0256 }
                java.lang.String r1 = "online_chat_ar"
                r3 = r35
                r15.putInt(r1, r3)     // Catch:{ JSONException -> 0x0256 }
                java.lang.String r1 = "online_chat_ro"
                r3 = r36
                r15.putInt(r1, r3)     // Catch:{ JSONException -> 0x0256 }
                java.lang.String r1 = "online_chat_th"
                r15.putInt(r1, r2)     // Catch:{ JSONException -> 0x0256 }
                java.lang.String r1 = "online_chat_my"
                r15.putInt(r1, r0)     // Catch:{ JSONException -> 0x0256 }
                java.lang.String r0 = "online_chat_total"
                r1 = r38
                r15.putInt(r0, r1)     // Catch:{ JSONException -> 0x0256 }
                java.lang.String r0 = "sub_domain"
                r1 = r37
                r15.putString(r0, r1)     // Catch:{ JSONException -> 0x0256 }
                r15.apply()     // Catch:{ JSONException -> 0x0256 }
                r1 = r39
                com.finazzi.distquake.FragmentNetwork r0 = com.finazzi.distquake.FragmentNetwork.this     // Catch:{ JSONException -> 0x02f9 }
                r0.X0()     // Catch:{ JSONException -> 0x02f9 }
                goto L_0x031c
            L_0x02f9:
                r0 = move-exception
            L_0x02fa:
                java.lang.String r2 = r0.getMessage()     // Catch:{ JSONException -> 0x030c }
                if (r2 == 0) goto L_0x031c
                java.lang.String r0 = r0.getMessage()     // Catch:{ JSONException -> 0x030c }
                r2 = r17
                android.util.Log.d(r2, r0)     // Catch:{ JSONException -> 0x030a }
                goto L_0x031c
            L_0x030a:
                r0 = move-exception
                goto L_0x030f
            L_0x030c:
                r0 = move-exception
                r2 = r17
            L_0x030f:
                java.lang.String r3 = r0.getMessage()
                if (r3 == 0) goto L_0x031c
                java.lang.String r0 = r0.getMessage()
                android.util.Log.d(r2, r0)
            L_0x031c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.FragmentNetwork.b.onPostExecute(java.lang.String):void");
        }

        /* synthetic */ b(FragmentNetwork fragmentNetwork, a aVar) {
            this();
        }
    }

    private class d extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private String f12895a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f12896b;

        private d() {
            this.f12895a = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00b5, code lost:
            r0.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x00b1 */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x00b5  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x00bb  */
        /* JADX WARNING: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r7) {
            /*
                r6 = this;
                r7 = 0
                com.finazzi.distquake.FragmentNetwork r0 = com.finazzi.distquake.FragmentNetwork.this
                boolean r0 = r0.isAdded()
                com.finazzi.distquake.FragmentNetwork r1 = com.finazzi.distquake.FragmentNetwork.this
                androidx.fragment.app.s r1 = r1.getActivity()
                r2 = 1
                if (r1 == 0) goto L_0x00bf
                if (r0 == 0) goto L_0x00bf
                r0 = 0
                com.finazzi.distquake.FragmentNetwork r1 = com.finazzi.distquake.FragmentNetwork.this     // Catch:{ IOException -> 0x00b1 }
                android.content.SharedPreferences r1 = r1.f12877o0     // Catch:{ IOException -> 0x00b1 }
                java.lang.String r3 = "sub_domain"
                com.finazzi.distquake.FragmentNetwork r4 = com.finazzi.distquake.FragmentNetwork.this     // Catch:{ IOException -> 0x00b1 }
                r5 = 2131887099(0x7f1203fb, float:1.9408796E38)
                java.lang.String r4 = r4.getString(r5)     // Catch:{ IOException -> 0x00b1 }
                java.lang.String r1 = r1.getString(r3, r4)     // Catch:{ IOException -> 0x00b1 }
                com.finazzi.distquake.FragmentNetwork r3 = com.finazzi.distquake.FragmentNetwork.this     // Catch:{ IOException -> 0x00b1 }
                r4 = 2131887098(0x7f1203fa, float:1.9408793E38)
                java.lang.String r3 = r3.getString(r4)     // Catch:{ IOException -> 0x00b1 }
                java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ IOException -> 0x00b1 }
                r4[r7] = r1     // Catch:{ IOException -> 0x00b1 }
                java.lang.String r1 = java.lang.String.format(r3, r4)     // Catch:{ IOException -> 0x00b1 }
                java.net.URL r3 = new java.net.URL     // Catch:{ IOException -> 0x00b1 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00b1 }
                r4.<init>()     // Catch:{ IOException -> 0x00b1 }
                r4.append(r1)     // Catch:{ IOException -> 0x00b1 }
                java.lang.String r1 = "distquake_download_pastquakes_1m.php"
                r4.append(r1)     // Catch:{ IOException -> 0x00b1 }
                java.lang.String r1 = r4.toString()     // Catch:{ IOException -> 0x00b1 }
                r3.<init>(r1)     // Catch:{ IOException -> 0x00b1 }
                java.net.URLConnection r1 = r3.openConnection()     // Catch:{ IOException -> 0x00b1 }
                java.lang.Object r1 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r1)     // Catch:{ IOException -> 0x00b1 }
                java.net.URLConnection r1 = (java.net.URLConnection) r1     // Catch:{ IOException -> 0x00b1 }
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ IOException -> 0x00b1 }
                r1.setDoOutput(r7)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r0 = 10000(0x2710, float:1.4013E-41)
                r1.setConnectTimeout(r0)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r1.setReadTimeout(r0)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.lang.String r0 = "Content-Type"
                java.lang.String r3 = "application/x-www-form-urlencoded;charset=utf-8"
                r1.setRequestProperty(r0, r3)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.lang.String r0 = "GET"
                r1.setRequestMethod(r0)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.io.InputStream r3 = r1.getInputStream()     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r0.<init>(r3)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r4.<init>(r0, r5)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r3.<init>(r4)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r4.<init>()     // Catch:{ IOException -> 0x009e, all -> 0x009b }
            L_0x008c:
                java.lang.String r5 = r3.readLine()     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                if (r5 == 0) goto L_0x00a0
                r4.append(r5)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.lang.String r5 = "\n"
                r4.append(r5)     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                goto L_0x008c
            L_0x009b:
                r7 = move-exception
                r0 = r1
                goto L_0x00b9
            L_0x009e:
                r0 = r1
                goto L_0x00b1
            L_0x00a0:
                r0.close()     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                java.lang.String r0 = r4.toString()     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r6.f12895a = r0     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r6.f12896b = r7     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r1.disconnect()
                goto L_0x00c1
            L_0x00af:
                r7 = move-exception
                goto L_0x00b9
            L_0x00b1:
                r6.f12896b = r2     // Catch:{ all -> 0x00af }
                if (r0 == 0) goto L_0x00c1
                r0.disconnect()
                goto L_0x00c1
            L_0x00b9:
                if (r0 == 0) goto L_0x00be
                r0.disconnect()
            L_0x00be:
                throw r7
            L_0x00bf:
                r6.f12896b = r2
            L_0x00c1:
                java.lang.String r7 = "COMPLETE!"
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.FragmentNetwork.d.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            if (!this.f12896b) {
                try {
                    JSONArray jSONArray = new JSONArray(this.f12895a);
                    int length = jSONArray.length();
                    double[] dArr = new double[length];
                    double[] dArr2 = new double[length];
                    int[] iArr = new int[length];
                    String[] strArr = new String[length];
                    int[] iArr2 = new int[length];
                    int[] iArr3 = new int[length];
                    double[] dArr3 = new double[length];
                    double[] dArr4 = new double[length];
                    double[] dArr5 = new double[length];
                    C0891s activity = FragmentNetwork.this.getActivity();
                    if (activity != null) {
                        for (int i8 = 0; i8 < length; i8++) {
                            JSONObject jSONObject = jSONArray.getJSONObject(i8);
                            dArr[i8] = Double.parseDouble(jSONObject.getString("la"));
                            dArr2[i8] = Double.parseDouble(jSONObject.getString("lo"));
                            iArr[i8] = Integer.parseInt(jSONObject.getString("st"));
                            strArr[i8] = jSONObject.getString("da");
                            iArr2[i8] = jSONObject.getInt("us");
                            iArr3[i8] = jSONObject.getInt("co");
                            dArr3[i8] = jSONObject.getDouble("it");
                            dArr4[i8] = jSONObject.getDouble("ma");
                            dArr5[i8] = jSONObject.getDouble("mg");
                        }
                        Intent unused = FragmentNetwork.this.f12878p0 = new Intent().setClass(activity, GlobeActivityAll.class);
                        FragmentNetwork.this.f12878p0.putExtra("com.finazzi.distquake.latitude_vector", dArr);
                        FragmentNetwork.this.f12878p0.putExtra("com.finazzi.distquake.longitude_vector", dArr2);
                        FragmentNetwork.this.f12878p0.putExtra("com.finazzi.distquake.state_vector", iArr);
                        FragmentNetwork.this.f12878p0.putExtra("com.finazzi.distquake.date_vector", strArr);
                        FragmentNetwork.this.f12878p0.putExtra("com.finazzi.distquake.ns_vector", iArr2);
                        FragmentNetwork.this.f12878p0.putExtra("com.finazzi.distquake.code_vector", iArr3);
                        FragmentNetwork.this.f12878p0.putExtra("com.finazzi.distquake.intensity_vector", dArr3);
                        FragmentNetwork.this.f12878p0.putExtra("com.finazzi.distquake.median_acceleration_vector", dArr4);
                        FragmentNetwork.this.f12878p0.putExtra("com.finazzi.distquake.magnitude_vector", dArr5);
                        FragmentNetwork.this.f12878p0.putExtra("com.finazzi.distquake.latitude_notification", 0);
                        FragmentNetwork.this.f12878p0.putExtra("com.finazzi.distquake.longitude_notification", 0);
                        FragmentNetwork.this.f12878p0.putExtra("com.finazzi.distquake.map_type", 0);
                        FragmentNetwork fragmentNetwork = FragmentNetwork.this;
                        fragmentNetwork.startActivityForResult(fragmentNetwork.f12878p0, 2);
                    }
                } catch (JSONException unused2) {
                    C0891s activity2 = FragmentNetwork.this.getActivity();
                    if (activity2 != null) {
                        Toast makeText = Toast.makeText(activity2, FragmentNetwork.this.getString(C2030R.string.manual_error), 0);
                        makeText.setGravity(17, 0, 0);
                        makeText.show();
                    }
                }
            } else {
                C0891s activity3 = FragmentNetwork.this.getActivity();
                if (activity3 != null) {
                    Toast makeText2 = Toast.makeText(activity3, FragmentNetwork.this.getString(C2030R.string.manual_error), 0);
                    makeText2.setGravity(17, 0, 0);
                    makeText2.show();
                }
            }
        }

        /* synthetic */ d(FragmentNetwork fragmentNetwork, a aVar) {
            this();
        }
    }
}
