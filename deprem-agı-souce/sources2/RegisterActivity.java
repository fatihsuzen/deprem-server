package com.finazzi.distquake;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.appcompat.app.C0768d;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.C0832r0;
import androidx.fragment.app.C0891s;
import androidx.fragment.app.DialogFragment;
import com.google.android.gms.ads.RequestConfiguration;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import u2.C1858r4;
import u2.C1864s4;
import u2.C1870t4;

public class RegisterActivity extends C0768d {
    /* access modifiers changed from: private */

    /* renamed from: W  reason: collision with root package name */
    public static Date f13499W;

    /* renamed from: O  reason: collision with root package name */
    private b f13500O;
    /* access modifiers changed from: private */

    /* renamed from: P  reason: collision with root package name */
    public String f13501P;
    /* access modifiers changed from: private */

    /* renamed from: Q  reason: collision with root package name */
    public String f13502Q;
    /* access modifiers changed from: private */

    /* renamed from: R  reason: collision with root package name */
    public String f13503R;
    /* access modifiers changed from: private */

    /* renamed from: S  reason: collision with root package name */
    public int f13504S;
    /* access modifiers changed from: private */

    /* renamed from: T  reason: collision with root package name */
    public int f13505T;
    /* access modifiers changed from: private */

    /* renamed from: U  reason: collision with root package name */
    public int f13506U = 0;
    /* access modifiers changed from: private */

    /* renamed from: V  reason: collision with root package name */
    public boolean f13507V = false;

    public static class DatePickerFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener {
        private static boolean A0() {
            if (!Build.MANUFACTURER.equalsIgnoreCase("samsung") || !z0(21, 22)) {
                return false;
            }
            return true;
        }

        private static boolean z0(int i8, int i9) {
            int i10 = Build.VERSION.SDK_INT;
            if (i10 < i8 || i10 > i9) {
                return false;
            }
            return true;
        }

        public Dialog onCreateDialog(Bundle bundle) {
            Context context;
            Calendar instance = Calendar.getInstance();
            instance.setTime(RegisterActivity.f13499W);
            Context activity = getActivity();
            if (A0()) {
                context = new ContextThemeWrapper(activity, 16973939);
            } else {
                context = activity;
            }
            if (context == null) {
                return null;
            }
            return new DatePickerDialog(context, this, instance.get(1), instance.get(2), instance.get(5));
        }

        public void onDateSet(DatePicker datePicker, int i8, int i9, int i10) {
            Calendar instance = Calendar.getInstance();
            instance.set(5, i10);
            instance.set(2, i9);
            instance.set(1, i8);
            Date unused = RegisterActivity.f13499W = instance.getTime();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
            C0891s activity = getActivity();
            if (activity != null) {
                ((EditText) activity.findViewById(C2030R.id.editText3)).setText(simpleDateFormat.format(RegisterActivity.f13499W));
            }
        }
    }

    private class b extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private int f13508a;

        private b() {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0130  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x0136  */
        /* JADX WARNING: Removed duplicated region for block: B:28:0x0147  */
        /* JADX WARNING: Removed duplicated region for block: B:31:0x0150  */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x015b  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x0168  */
        /* JADX WARNING: Removed duplicated region for block: B:43:0x01a1  */
        /* JADX WARNING: Removed duplicated region for block: B:44:0x01a4  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x01a7  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r12) {
            /*
                r11 = this;
                r12 = 2
                r0 = 0
                java.lang.String r1 = "wrong"
                r2 = 1
                com.finazzi.distquake.RegisterActivity r3 = com.finazzi.distquake.RegisterActivity.this
                java.lang.String r3 = r3.s0()
                java.util.HashMap r4 = new java.util.HashMap
                r4.<init>()
                java.lang.String r5 = "u_id"
                r4.put(r5, r3)
                com.finazzi.distquake.RegisterActivity r3 = com.finazzi.distquake.RegisterActivity.this
                java.lang.String r3 = r3.f13501P
                java.lang.String r5 = "nick"
                r4.put(r5, r3)
                com.finazzi.distquake.RegisterActivity r3 = com.finazzi.distquake.RegisterActivity.this
                java.lang.String r3 = r3.f13502Q
                java.lang.String r6 = "uID"
                r4.put(r6, r3)
                com.finazzi.distquake.RegisterActivity r3 = com.finazzi.distquake.RegisterActivity.this
                java.lang.String r3 = r3.v0()
                java.lang.String r6 = "wal"
                r4.put(r6, r3)
                com.finazzi.distquake.RegisterActivity r3 = com.finazzi.distquake.RegisterActivity.this
                int r3 = r3.f13505T
                java.lang.String r3 = java.lang.Integer.toString(r3)
                java.lang.String r6 = "country"
                r4.put(r6, r3)
                java.text.SimpleDateFormat r3 = new java.text.SimpleDateFormat
                java.lang.String r7 = "yyyy-MM-dd"
                java.util.Locale r8 = java.util.Locale.getDefault()
                r3.<init>(r7, r8)
                java.util.Date r7 = com.finazzi.distquake.RegisterActivity.f13499W
                java.lang.String r3 = r3.format(r7)
                java.lang.String r7 = "birth"
                r4.put(r7, r3)
                com.finazzi.distquake.RegisterActivity r3 = com.finazzi.distquake.RegisterActivity.this
                java.lang.String r3 = r3.f13503R
                java.lang.String r7 = "town"
                r4.put(r7, r3)
                com.finazzi.distquake.RegisterActivity r3 = com.finazzi.distquake.RegisterActivity.this
                int r3 = r3.f13504S
                java.lang.String r3 = java.lang.Integer.toString(r3)
                java.lang.String r7 = "sex"
                r4.put(r7, r3)
                com.finazzi.distquake.RegisterActivity r3 = com.finazzi.distquake.RegisterActivity.this
                int r3 = r3.f13506U
                java.lang.String r3 = java.lang.Integer.toString(r3)
                java.lang.String r7 = "fr"
                r4.put(r7, r3)
                com.finazzi.distquake.RegisterActivity r3 = com.finazzi.distquake.RegisterActivity.this
                boolean r3 = r3.f13507V
                java.lang.String r7 = "pro"
                if (r3 == 0) goto L_0x0096
                java.lang.String r3 = "1"
                r4.put(r7, r3)
                goto L_0x009b
            L_0x0096:
                java.lang.String r3 = "0"
                r4.put(r7, r3)
            L_0x009b:
                java.lang.String r3 = u2.C1737L.a(r4)
                r4 = 0
                java.net.URL r7 = new java.net.URL     // Catch:{ IOException -> 0x0134, all -> 0x012d }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0134, all -> 0x012d }
                r8.<init>()     // Catch:{ IOException -> 0x0134, all -> 0x012d }
                com.finazzi.distquake.RegisterActivity r9 = com.finazzi.distquake.RegisterActivity.this     // Catch:{ IOException -> 0x0134, all -> 0x012d }
                r10 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r9 = r9.getString(r10)     // Catch:{ IOException -> 0x0134, all -> 0x012d }
                r8.append(r9)     // Catch:{ IOException -> 0x0134, all -> 0x012d }
                java.lang.String r9 = "distquake_register5.php"
                r8.append(r9)     // Catch:{ IOException -> 0x0134, all -> 0x012d }
                java.lang.String r8 = r8.toString()     // Catch:{ IOException -> 0x0134, all -> 0x012d }
                r7.<init>(r8)     // Catch:{ IOException -> 0x0134, all -> 0x012d }
                java.net.URLConnection r7 = r7.openConnection()     // Catch:{ IOException -> 0x0134, all -> 0x012d }
                java.lang.Object r7 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r7)     // Catch:{ IOException -> 0x0134, all -> 0x012d }
                java.net.URLConnection r7 = (java.net.URLConnection) r7     // Catch:{ IOException -> 0x0134, all -> 0x012d }
                java.net.HttpURLConnection r7 = (java.net.HttpURLConnection) r7     // Catch:{ IOException -> 0x0134, all -> 0x012d }
                r7.setDoOutput(r2)     // Catch:{ IOException -> 0x0120, all -> 0x011d }
                r4 = 10000(0x2710, float:1.4013E-41)
                r7.setConnectTimeout(r4)     // Catch:{ IOException -> 0x0120, all -> 0x011d }
                r7.setReadTimeout(r4)     // Catch:{ IOException -> 0x0120, all -> 0x011d }
                java.lang.String r4 = "Content-Type"
                java.lang.String r8 = "application/x-www-form-urlencoded;charset=utf-8"
                r7.setRequestProperty(r4, r8)     // Catch:{ IOException -> 0x0120, all -> 0x011d }
                java.lang.String r4 = "POST"
                r7.setRequestMethod(r4)     // Catch:{ IOException -> 0x0120, all -> 0x011d }
                byte[] r4 = r3.getBytes()     // Catch:{ IOException -> 0x0120, all -> 0x011d }
                int r4 = r4.length     // Catch:{ IOException -> 0x0120, all -> 0x011d }
                r7.setFixedLengthStreamingMode(r4)     // Catch:{ IOException -> 0x0120, all -> 0x011d }
                java.io.PrintWriter r4 = new java.io.PrintWriter     // Catch:{ IOException -> 0x0120, all -> 0x011d }
                java.io.OutputStream r8 = r7.getOutputStream()     // Catch:{ IOException -> 0x0120, all -> 0x011d }
                r4.<init>(r8)     // Catch:{ IOException -> 0x0120, all -> 0x011d }
                r4.print(r3)     // Catch:{ IOException -> 0x0120, all -> 0x011d }
                r4.close()     // Catch:{ IOException -> 0x0120, all -> 0x011d }
                java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0120, all -> 0x011d }
                java.io.InputStream r4 = r7.getInputStream()     // Catch:{ IOException -> 0x0120, all -> 0x011d }
                r3.<init>(r4)     // Catch:{ IOException -> 0x0120, all -> 0x011d }
                java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0120, all -> 0x011d }
                java.io.InputStreamReader r8 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0120, all -> 0x011d }
                java.nio.charset.Charset r9 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x0120, all -> 0x011d }
                r8.<init>(r3, r9)     // Catch:{ IOException -> 0x0120, all -> 0x011d }
                r4.<init>(r8)     // Catch:{ IOException -> 0x0120, all -> 0x011d }
                java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0120, all -> 0x011d }
                r8.<init>()     // Catch:{ IOException -> 0x0120, all -> 0x011d }
            L_0x0113:
                java.lang.String r9 = r4.readLine()     // Catch:{ IOException -> 0x0120, all -> 0x011d }
                if (r9 == 0) goto L_0x0122
                r8.append(r9)     // Catch:{ IOException -> 0x0120, all -> 0x011d }
                goto L_0x0113
            L_0x011d:
                r12 = move-exception
                r4 = r7
                goto L_0x012e
            L_0x0120:
                r4 = r7
                goto L_0x0134
            L_0x0122:
                r3.close()     // Catch:{ IOException -> 0x0120, all -> 0x011d }
                java.lang.String r3 = r8.toString()     // Catch:{ IOException -> 0x0120, all -> 0x011d }
                r7.disconnect()
                goto L_0x013a
            L_0x012d:
                r12 = move-exception
            L_0x012e:
                if (r4 == 0) goto L_0x0133
                r4.disconnect()
            L_0x0133:
                throw r12
            L_0x0134:
                if (r4 == 0) goto L_0x0139
                r4.disconnect()
            L_0x0139:
                r3 = r1
            L_0x013a:
                r3.getClass()
                r4 = 3
                r7 = -1
                int r8 = r3.hashCode()
                switch(r8) {
                    case 99839: goto L_0x015b;
                    case 100551: goto L_0x0150;
                    case 113405357: goto L_0x0147;
                    default: goto L_0x0146;
                }
            L_0x0146:
                goto L_0x0165
            L_0x0147:
                boolean r1 = r3.equals(r1)
                if (r1 != 0) goto L_0x014e
                goto L_0x0165
            L_0x014e:
                r7 = r12
                goto L_0x0165
            L_0x0150:
                java.lang.String r1 = "emo"
                boolean r1 = r3.equals(r1)
                if (r1 != 0) goto L_0x0159
                goto L_0x0165
            L_0x0159:
                r7 = r2
                goto L_0x0165
            L_0x015b:
                java.lang.String r1 = "dup"
                boolean r1 = r3.equals(r1)
                if (r1 != 0) goto L_0x0164
                goto L_0x0165
            L_0x0164:
                r7 = r0
            L_0x0165:
                switch(r7) {
                    case 0: goto L_0x01a7;
                    case 1: goto L_0x01a4;
                    case 2: goto L_0x01a1;
                    default: goto L_0x0168;
                }
            L_0x0168:
                r11.f13508a = r0
                com.finazzi.distquake.RegisterActivity r12 = com.finazzi.distquake.RegisterActivity.this
                java.lang.Class<com.finazzi.distquake.MainActivity> r1 = com.finazzi.distquake.MainActivity.class
                java.lang.String r1 = r1.getSimpleName()
                android.content.SharedPreferences r12 = r12.getSharedPreferences(r1, r0)
                android.content.SharedPreferences$Editor r12 = r12.edit()
                int r0 = java.lang.Integer.parseInt(r3)     // Catch:{ NumberFormatException -> 0x019e }
                java.lang.String r1 = "chat_user_code"
                r12.putInt(r1, r0)     // Catch:{ NumberFormatException -> 0x019e }
                java.lang.String r0 = "nicklinked"
                r12.putBoolean(r0, r2)     // Catch:{ NumberFormatException -> 0x019e }
                com.finazzi.distquake.RegisterActivity r0 = com.finazzi.distquake.RegisterActivity.this     // Catch:{ NumberFormatException -> 0x019e }
                java.lang.String r0 = r0.f13501P     // Catch:{ NumberFormatException -> 0x019e }
                r12.putString(r5, r0)     // Catch:{ NumberFormatException -> 0x019e }
                com.finazzi.distquake.RegisterActivity r0 = com.finazzi.distquake.RegisterActivity.this     // Catch:{ NumberFormatException -> 0x019e }
                int r0 = r0.f13505T     // Catch:{ NumberFormatException -> 0x019e }
                r12.putInt(r6, r0)     // Catch:{ NumberFormatException -> 0x019e }
                r12.apply()     // Catch:{ NumberFormatException -> 0x019e }
                goto L_0x01a9
            L_0x019e:
                r11.f13508a = r4
                goto L_0x01a9
            L_0x01a1:
                r11.f13508a = r4
                goto L_0x01a9
            L_0x01a4:
                r11.f13508a = r12
                goto L_0x01a9
            L_0x01a7:
                r11.f13508a = r2
            L_0x01a9:
                java.lang.String r12 = "COMPLETE!"
                return r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.RegisterActivity.b.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            if (this.f13508a == 0) {
                RegisterActivity.this.setResult(-1, new Intent());
                RegisterActivity.this.finish();
            }
            if (this.f13508a == 1) {
                Toast makeText = Toast.makeText(RegisterActivity.this.getApplicationContext(), RegisterActivity.this.getString(C2030R.string.register_used), 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
            if (this.f13508a == 2) {
                Toast makeText2 = Toast.makeText(RegisterActivity.this.getApplicationContext(), RegisterActivity.this.getString(C2030R.string.register_emoji), 0);
                makeText2.setGravity(17, 0, 0);
                makeText2.show();
            }
            if (this.f13508a == 3) {
                Toast makeText3 = Toast.makeText(RegisterActivity.this.getApplicationContext(), RegisterActivity.this.getString(C2030R.string.manual_error), 0);
                makeText3.setGravity(17, 0, 0);
                makeText3.show();
            }
        }
    }

    public static /* synthetic */ void e0(RegisterActivity registerActivity, Context context, View view) {
        boolean z7;
        if (registerActivity.w0()) {
            String obj = ((EditText) registerActivity.findViewById(C2030R.id.editText1)).getText().toString();
            registerActivity.f13501P = obj;
            boolean z8 = !obj.equalsIgnoreCase(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
            int selectedItemPosition = ((Spinner) registerActivity.findViewById(C2030R.id.spinner1)).getSelectedItemPosition();
            registerActivity.f13505T = selectedItemPosition;
            if (selectedItemPosition == 0) {
                z8 = false;
            }
            String obj2 = ((EditText) registerActivity.findViewById(C2030R.id.editText2)).getText().toString();
            registerActivity.f13503R = obj2;
            if (obj2.equalsIgnoreCase(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED)) {
                z8 = false;
            }
            int selectedItemPosition2 = ((Spinner) registerActivity.findViewById(C2030R.id.spinner2)).getSelectedItemPosition();
            registerActivity.f13504S = selectedItemPosition2;
            if (selectedItemPosition2 == 0) {
                z8 = false;
            }
            try {
                f13499W = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).parse(((EditText) registerActivity.findViewById(C2030R.id.editText3)).getText().toString());
                if (u0(f13499W, new Date()) < 18) {
                    z7 = false;
                } else {
                    z7 = true;
                }
            } catch (ParseException unused) {
                z7 = true;
                z8 = false;
            }
            if (!z8) {
                Toast makeText = Toast.makeText(registerActivity.getApplicationContext(), registerActivity.getString(C2030R.string.register_fill), 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            } else if (z7) {
                b bVar = new b();
                registerActivity.f13500O = bVar;
                bVar.execute(new Context[]{context});
            } else {
                Toast makeText2 = Toast.makeText(registerActivity.getApplicationContext(), registerActivity.getString(C2030R.string.register_noage), 1);
                makeText2.setGravity(17, 0, 0);
                makeText2.show();
            }
        } else {
            Toast makeText3 = Toast.makeText(registerActivity.getApplicationContext(), registerActivity.getString(C2030R.string.main_nointernet), 0);
            makeText3.setGravity(17, 0, 0);
            makeText3.show();
        }
    }

    public static /* synthetic */ void f0(RegisterActivity registerActivity, View view) {
        registerActivity.getClass();
        if (((CheckBox) view).isChecked()) {
            registerActivity.f13506U = 1;
        } else {
            registerActivity.f13506U = 0;
        }
    }

    public static /* synthetic */ void g0(RegisterActivity registerActivity, View view) {
        registerActivity.getClass();
        new DatePickerFragment().show(registerActivity.getSupportFragmentManager(), "datePicker");
    }

    /* access modifiers changed from: private */
    public String s0() {
        return getSharedPreferences(MainActivity.class.getSimpleName(), 0).getString("android_id_eqn", "0");
    }

    private static Calendar t0(Date date) {
        Calendar instance = Calendar.getInstance(Locale.getDefault());
        instance.setTime(date);
        return instance;
    }

    private static int u0(Date date, Date date2) {
        Calendar t02 = t0(date);
        Calendar t03 = t0(date2);
        int i8 = t03.get(1) - t02.get(1);
        if (t02.get(2) > t03.get(2) || (t02.get(2) == t03.get(2) && t02.get(5) > t03.get(5))) {
            return i8 - 1;
        }
        return i8;
    }

    /* access modifiers changed from: private */
    public String v0() {
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.class.getSimpleName(), 0);
        String string = sharedPreferences.getString("order_id_pro", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        if (string.equals(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED)) {
            return sharedPreferences.getString("order_id_sub", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        }
        return string;
    }

    private boolean w0() {
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

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2030R.layout.profile_personal_card);
        int i8 = getResources().getConfiguration().uiMode & 48;
        if (Build.VERSION.SDK_INT >= 35 && i8 == 16) {
            Window window = getWindow();
            C0832r0.a(window, window.getDecorView()).d(true);
        }
        this.f13502Q = getIntent().getExtras().getString("com.finazzi.distquake.uID");
        this.f13507V = getSharedPreferences(MainActivity.class.getSimpleName(), 0).getBoolean("pro_features", false);
        Toolbar toolbar = (Toolbar) findViewById(C2030R.id.toolbar);
        b0(toolbar);
        if (!this.f13507V) {
            toolbar.setLogo(2131230872);
        } else {
            toolbar.setLogo(2131230875);
        }
        EditText editText = (EditText) findViewById(C2030R.id.editText1);
        editText.setClickable(true);
        editText.setFocusable(true);
        editText.setFocusableInTouchMode(true);
        editText.requestFocus();
        ((CheckBox) findViewById(C2030R.id.checkBox)).setOnClickListener(new C1858r4(this));
        try {
            f13499W = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse("2000-01-01");
        } catch (ParseException e8) {
            if (e8.getMessage() != null) {
                Log.d("EQN", e8.getMessage());
            }
        }
        Button button = (Button) findViewById(C2030R.id.button1);
        button.setText(getString(C2030R.string.register_register));
        button.setOnClickListener(new C1864s4(this, this));
        ((Button) findViewById(C2030R.id.button2)).setVisibility(8);
        ((Button) findViewById(C2030R.id.button3)).setVisibility(8);
        ((EditText) findViewById(C2030R.id.editText3)).setOnClickListener(new C1870t4(this));
    }
}
