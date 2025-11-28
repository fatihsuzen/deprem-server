package com.finazzi.distquake;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.C0768d;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.C0832r0;
import androidx.fragment.app.C0891s;
import androidx.fragment.app.DialogFragment;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.C1155z;
import com.google.firebase.auth.E;
import com.google.firebase.auth.FirebaseAuth;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import u2.C1792g4;
import u2.C1798h4;
import u2.C1804i4;
import u2.C1810j4;
import u2.C1816k4;
import u2.C1822l4;
import u2.C1828m4;
import u2.C1834n4;
import u2.C1840o4;
import u2.C1846p4;
import u2.C1852q4;

public class ProfilePersonalActivity extends C0768d {
    /* access modifiers changed from: private */

    /* renamed from: V  reason: collision with root package name */
    public static Date f13479V;

    /* renamed from: O  reason: collision with root package name */
    private g f13480O;
    /* access modifiers changed from: private */

    /* renamed from: P  reason: collision with root package name */
    public String f13481P;
    /* access modifiers changed from: private */

    /* renamed from: Q  reason: collision with root package name */
    public int f13482Q;
    /* access modifiers changed from: private */

    /* renamed from: R  reason: collision with root package name */
    public int f13483R;
    /* access modifiers changed from: private */

    /* renamed from: S  reason: collision with root package name */
    public int f13484S;
    /* access modifiers changed from: private */

    /* renamed from: T  reason: collision with root package name */
    public String f13485T;
    /* access modifiers changed from: private */

    /* renamed from: U  reason: collision with root package name */
    public String f13486U;

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
            instance.setTime(ProfilePersonalActivity.f13479V);
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
            Date unused = ProfilePersonalActivity.f13479V = instance.getTime();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
            C0891s activity = getActivity();
            if (activity != null) {
                ((EditText) activity.findViewById(C2030R.id.editText3)).setText(simpleDateFormat.format(ProfilePersonalActivity.f13479V));
            }
        }
    }

    class a implements TextWatcher {
        a() {
        }

        public void afterTextChanged(Editable editable) {
            String unused = ProfilePersonalActivity.this.f13485T = editable.toString();
        }

        public void beforeTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
        }

        public void onTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
        }
    }

    class b implements TextWatcher {
        b() {
        }

        public void afterTextChanged(Editable editable) {
            String unused = ProfilePersonalActivity.this.f13481P = editable.toString();
        }

        public void beforeTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
        }

        public void onTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
        }
    }

    class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SimpleDateFormat f13489a;

        c(SimpleDateFormat simpleDateFormat) {
            this.f13489a = simpleDateFormat;
        }

        public void afterTextChanged(Editable editable) {
            try {
                Date unused = ProfilePersonalActivity.f13479V = this.f13489a.parse(editable.toString());
            } catch (ParseException unused2) {
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
        }

        public void onTextChanged(CharSequence charSequence, int i8, int i9, int i10) {
        }
    }

    class d implements AdapterView.OnItemSelectedListener {
        d() {
        }

        public void onItemSelected(AdapterView adapterView, View view, int i8, long j8) {
            int unused = ProfilePersonalActivity.this.f13482Q = i8;
        }

        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    class e implements AdapterView.OnItemSelectedListener {
        e() {
        }

        public void onItemSelected(AdapterView adapterView, View view, int i8, long j8) {
            int unused = ProfilePersonalActivity.this.f13483R = i8;
        }

        public void onNothingSelected(AdapterView adapterView) {
        }
    }

    private class f extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private final String f13493a;

        /* synthetic */ f(ProfilePersonalActivity profilePersonalActivity, String str, a aVar) {
            this(str);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0096  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x009c  */
        /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r6) {
            /*
                r5 = this;
                java.util.HashMap r6 = new java.util.HashMap
                r6.<init>()
                java.lang.String r0 = "uID"
                java.lang.String r1 = r5.f13493a
                r6.put(r0, r1)
                java.lang.String r6 = u2.C1737L.a(r6)
                r0 = 0
                java.net.URL r1 = new java.net.URL     // Catch:{ IOException -> 0x009a, all -> 0x0093 }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x009a, all -> 0x0093 }
                r2.<init>()     // Catch:{ IOException -> 0x009a, all -> 0x0093 }
                com.finazzi.distquake.ProfilePersonalActivity r3 = com.finazzi.distquake.ProfilePersonalActivity.this     // Catch:{ IOException -> 0x009a, all -> 0x0093 }
                r4 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r3 = r3.getString(r4)     // Catch:{ IOException -> 0x009a, all -> 0x0093 }
                r2.append(r3)     // Catch:{ IOException -> 0x009a, all -> 0x0093 }
                java.lang.String r3 = "distquake_upload_deleteprofile.php"
                r2.append(r3)     // Catch:{ IOException -> 0x009a, all -> 0x0093 }
                java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x009a, all -> 0x0093 }
                r1.<init>(r2)     // Catch:{ IOException -> 0x009a, all -> 0x0093 }
                java.net.URLConnection r1 = r1.openConnection()     // Catch:{ IOException -> 0x009a, all -> 0x0093 }
                java.lang.Object r1 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r1)     // Catch:{ IOException -> 0x009a, all -> 0x0093 }
                java.net.URLConnection r1 = (java.net.URLConnection) r1     // Catch:{ IOException -> 0x009a, all -> 0x0093 }
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ IOException -> 0x009a, all -> 0x0093 }
                r0 = 1
                r1.setDoOutput(r0)     // Catch:{ IOException -> 0x0091, all -> 0x008e }
                r0 = 10000(0x2710, float:1.4013E-41)
                r1.setConnectTimeout(r0)     // Catch:{ IOException -> 0x0091, all -> 0x008e }
                r1.setReadTimeout(r0)     // Catch:{ IOException -> 0x0091, all -> 0x008e }
                java.lang.String r0 = "Content-Type"
                java.lang.String r2 = "application/x-www-form-urlencoded;charset=utf-8"
                r1.setRequestProperty(r0, r2)     // Catch:{ IOException -> 0x0091, all -> 0x008e }
                java.lang.String r0 = "POST"
                r1.setRequestMethod(r0)     // Catch:{ IOException -> 0x0091, all -> 0x008e }
                byte[] r0 = r6.getBytes()     // Catch:{ IOException -> 0x0091, all -> 0x008e }
                int r0 = r0.length     // Catch:{ IOException -> 0x0091, all -> 0x008e }
                r1.setFixedLengthStreamingMode(r0)     // Catch:{ IOException -> 0x0091, all -> 0x008e }
                java.io.PrintWriter r0 = new java.io.PrintWriter     // Catch:{ IOException -> 0x0091, all -> 0x008e }
                java.io.OutputStream r2 = r1.getOutputStream()     // Catch:{ IOException -> 0x0091, all -> 0x008e }
                r0.<init>(r2)     // Catch:{ IOException -> 0x0091, all -> 0x008e }
                r0.print(r6)     // Catch:{ IOException -> 0x0091, all -> 0x008e }
                r0.close()     // Catch:{ IOException -> 0x0091, all -> 0x008e }
                java.io.BufferedInputStream r6 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0091, all -> 0x008e }
                java.io.InputStream r0 = r1.getInputStream()     // Catch:{ IOException -> 0x0091, all -> 0x008e }
                r6.<init>(r0)     // Catch:{ IOException -> 0x0091, all -> 0x008e }
                java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0091, all -> 0x008e }
                java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0091, all -> 0x008e }
                java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x0091, all -> 0x008e }
                r2.<init>(r6, r3)     // Catch:{ IOException -> 0x0091, all -> 0x008e }
                r0.<init>(r2)     // Catch:{ IOException -> 0x0091, all -> 0x008e }
            L_0x0080:
                java.lang.String r2 = r0.readLine()     // Catch:{ IOException -> 0x0091, all -> 0x008e }
                if (r2 == 0) goto L_0x0087
                goto L_0x0080
            L_0x0087:
                r6.close()     // Catch:{ IOException -> 0x0091, all -> 0x008e }
                r1.disconnect()
                goto L_0x009f
            L_0x008e:
                r6 = move-exception
                r0 = r1
                goto L_0x0094
            L_0x0091:
                r0 = r1
                goto L_0x009a
            L_0x0093:
                r6 = move-exception
            L_0x0094:
                if (r0 == 0) goto L_0x0099
                r0.disconnect()
            L_0x0099:
                throw r6
            L_0x009a:
                if (r0 == 0) goto L_0x009f
                r0.disconnect()
            L_0x009f:
                java.lang.String r6 = "COMPLETE!"
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.ProfilePersonalActivity.f.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            SharedPreferences.Editor edit = ProfilePersonalActivity.this.getSharedPreferences(MainActivity.class.getSimpleName(), 0).edit();
            edit.remove("token");
            edit.remove("nick");
            edit.remove("uID");
            edit.remove("nicklinked");
            edit.remove("chat_user_code");
            edit.apply();
            ProfilePersonalActivity profilePersonalActivity = ProfilePersonalActivity.this;
            Toast makeText = Toast.makeText(profilePersonalActivity, profilePersonalActivity.getString(C2030R.string.profile_deleted), 1);
            makeText.setGravity(17, 0, 0);
            makeText.show();
            ProfilePersonalActivity.this.setResult(1, new Intent());
            ProfilePersonalActivity.this.finish();
        }

        private f(String str) {
            this.f13493a = str;
        }
    }

    private class g extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private int f13495a;

        private g() {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x0109  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0114  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x0118  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r7) {
            /*
                r6 = this;
                java.text.SimpleDateFormat r7 = new java.text.SimpleDateFormat
                java.lang.String r0 = "yyyy-MM-dd"
                java.util.Locale r1 = java.util.Locale.getDefault()
                r7.<init>(r0, r1)
                java.util.HashMap r0 = new java.util.HashMap
                r0.<init>()
                com.finazzi.distquake.ProfilePersonalActivity r1 = com.finazzi.distquake.ProfilePersonalActivity.this
                java.lang.String r1 = r1.f13485T
                java.lang.String r2 = "nick"
                r0.put(r2, r1)
                com.finazzi.distquake.ProfilePersonalActivity r1 = com.finazzi.distquake.ProfilePersonalActivity.this
                java.lang.String r1 = r1.f13486U
                java.lang.String r2 = "uID"
                r0.put(r2, r1)
                com.finazzi.distquake.ProfilePersonalActivity r1 = com.finazzi.distquake.ProfilePersonalActivity.this
                int r1 = r1.f13482Q
                java.lang.String r1 = java.lang.Integer.toString(r1)
                java.lang.String r2 = "country"
                r0.put(r2, r1)
                java.util.Date r1 = com.finazzi.distquake.ProfilePersonalActivity.f13479V
                java.lang.String r7 = r7.format(r1)
                java.lang.String r1 = "birth"
                r0.put(r1, r7)
                com.finazzi.distquake.ProfilePersonalActivity r7 = com.finazzi.distquake.ProfilePersonalActivity.this
                java.lang.String r7 = r7.f13481P
                java.lang.String r1 = "town"
                r0.put(r1, r7)
                com.finazzi.distquake.ProfilePersonalActivity r7 = com.finazzi.distquake.ProfilePersonalActivity.this
                int r7 = r7.f13483R
                java.lang.String r7 = java.lang.Integer.toString(r7)
                java.lang.String r1 = "sex"
                r0.put(r1, r7)
                com.finazzi.distquake.ProfilePersonalActivity r7 = com.finazzi.distquake.ProfilePersonalActivity.this
                int r7 = r7.f13484S
                java.lang.String r7 = java.lang.Integer.toString(r7)
                java.lang.String r1 = "fr"
                r0.put(r1, r7)
                java.lang.String r7 = u2.C1737L.a(r0)
                r0 = 1
                r1 = 0
                java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x0105 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0105 }
                r3.<init>()     // Catch:{ IOException -> 0x0105 }
                com.finazzi.distquake.ProfilePersonalActivity r4 = com.finazzi.distquake.ProfilePersonalActivity.this     // Catch:{ IOException -> 0x0105 }
                r5 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r4 = r4.getString(r5)     // Catch:{ IOException -> 0x0105 }
                r3.append(r4)     // Catch:{ IOException -> 0x0105 }
                java.lang.String r4 = "distquake_upload_profile2.php"
                r3.append(r4)     // Catch:{ IOException -> 0x0105 }
                java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x0105 }
                r2.<init>(r3)     // Catch:{ IOException -> 0x0105 }
                java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x0105 }
                java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch:{ IOException -> 0x0105 }
                java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch:{ IOException -> 0x0105 }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x0105 }
                r2.setDoOutput(r0)     // Catch:{ IOException -> 0x00f6, all -> 0x00f3 }
                r1 = 10000(0x2710, float:1.4013E-41)
                r2.setConnectTimeout(r1)     // Catch:{ IOException -> 0x00f6, all -> 0x00f3 }
                r2.setReadTimeout(r1)     // Catch:{ IOException -> 0x00f6, all -> 0x00f3 }
                java.lang.String r1 = "Content-Type"
                java.lang.String r3 = "application/x-www-form-urlencoded;charset=utf-8"
                r2.setRequestProperty(r1, r3)     // Catch:{ IOException -> 0x00f6, all -> 0x00f3 }
                java.lang.String r1 = "POST"
                r2.setRequestMethod(r1)     // Catch:{ IOException -> 0x00f6, all -> 0x00f3 }
                byte[] r1 = r7.getBytes()     // Catch:{ IOException -> 0x00f6, all -> 0x00f3 }
                int r1 = r1.length     // Catch:{ IOException -> 0x00f6, all -> 0x00f3 }
                r2.setFixedLengthStreamingMode(r1)     // Catch:{ IOException -> 0x00f6, all -> 0x00f3 }
                java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch:{ IOException -> 0x00f6, all -> 0x00f3 }
                java.io.OutputStream r3 = r2.getOutputStream()     // Catch:{ IOException -> 0x00f6, all -> 0x00f3 }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00f6, all -> 0x00f3 }
                r1.print(r7)     // Catch:{ IOException -> 0x00f6, all -> 0x00f3 }
                r1.close()     // Catch:{ IOException -> 0x00f6, all -> 0x00f3 }
                java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00f6, all -> 0x00f3 }
                java.io.InputStream r1 = r2.getInputStream()     // Catch:{ IOException -> 0x00f6, all -> 0x00f3 }
                r7.<init>(r1)     // Catch:{ IOException -> 0x00f6, all -> 0x00f3 }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00f6, all -> 0x00f3 }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00f6, all -> 0x00f3 }
                java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00f6, all -> 0x00f3 }
                r3.<init>(r7, r4)     // Catch:{ IOException -> 0x00f6, all -> 0x00f3 }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00f6, all -> 0x00f3 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00f6, all -> 0x00f3 }
                r3.<init>()     // Catch:{ IOException -> 0x00f6, all -> 0x00f3 }
            L_0x00e4:
                java.lang.String r4 = r1.readLine()     // Catch:{ IOException -> 0x00f6, all -> 0x00f3 }
                if (r4 == 0) goto L_0x00f8
                r3.append(r4)     // Catch:{ IOException -> 0x00f6, all -> 0x00f3 }
                java.lang.String r4 = "\n"
                r3.append(r4)     // Catch:{ IOException -> 0x00f6, all -> 0x00f3 }
                goto L_0x00e4
            L_0x00f3:
                r7 = move-exception
                r1 = r2
                goto L_0x011d
            L_0x00f6:
                r1 = r2
                goto L_0x0105
            L_0x00f8:
                r7.close()     // Catch:{ IOException -> 0x00f6, all -> 0x00f3 }
                java.lang.String r7 = r3.toString()     // Catch:{ IOException -> 0x00f6, all -> 0x00f3 }
                r2.disconnect()
                goto L_0x010c
            L_0x0103:
                r7 = move-exception
                goto L_0x011d
            L_0x0105:
                java.lang.String r7 = "ko"
                if (r1 == 0) goto L_0x010c
                r1.disconnect()
            L_0x010c:
                java.lang.String r1 = "ok\n"
                boolean r7 = r7.equals(r1)
                if (r7 == 0) goto L_0x0118
                r7 = 0
                r6.f13495a = r7
                goto L_0x011a
            L_0x0118:
                r6.f13495a = r0
            L_0x011a:
                java.lang.String r7 = "COMPLETE!"
                return r7
            L_0x011d:
                if (r1 == 0) goto L_0x0122
                r1.disconnect()
            L_0x0122:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.ProfilePersonalActivity.g.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            if (this.f13495a == 0) {
                Toast makeText = Toast.makeText(ProfilePersonalActivity.this.getApplicationContext(), ProfilePersonalActivity.this.getString(C2030R.string.profiler_received), 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
            if (this.f13495a == 1) {
                Toast makeText2 = Toast.makeText(ProfilePersonalActivity.this.getApplicationContext(), ProfilePersonalActivity.this.getString(C2030R.string.manual_error), 0);
                makeText2.setGravity(17, 0, 0);
                makeText2.show();
            }
        }

        /* synthetic */ g(ProfilePersonalActivity profilePersonalActivity, a aVar) {
            this();
        }
    }

    private boolean B0() {
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

    public static /* synthetic */ void e0(ProfilePersonalActivity profilePersonalActivity, View view) {
        profilePersonalActivity.getClass();
        new DatePickerFragment().show(profilePersonalActivity.getSupportFragmentManager(), "datePicker");
    }

    public static /* synthetic */ void f0(ProfilePersonalActivity profilePersonalActivity, View view) {
        profilePersonalActivity.getClass();
        if (((CheckBox) view).isChecked()) {
            profilePersonalActivity.f13484S = 1;
        } else {
            profilePersonalActivity.f13484S = 0;
        }
    }

    public static /* synthetic */ void g0(ProfilePersonalActivity profilePersonalActivity, View view) {
        if (profilePersonalActivity.B0()) {
            v2.d.k().q(profilePersonalActivity).addOnCompleteListener(new C1834n4(profilePersonalActivity));
            return;
        }
        Toast makeText = Toast.makeText(profilePersonalActivity.getApplicationContext(), profilePersonalActivity.getString(C2030R.string.main_nointernet), 0);
        makeText.setGravity(17, 0, 0);
        makeText.show();
    }

    public static /* synthetic */ void h0(ProfilePersonalActivity profilePersonalActivity, C1155z zVar, Task task) {
        profilePersonalActivity.getClass();
        zVar.a1().addOnCompleteListener(new C1798h4(profilePersonalActivity));
    }

    public static /* synthetic */ void i0(ProfilePersonalActivity profilePersonalActivity, Task task) {
        SharedPreferences.Editor edit = profilePersonalActivity.getSharedPreferences(MainActivity.class.getSimpleName(), 0).edit();
        edit.remove("token");
        edit.remove("nick");
        edit.remove("uID");
        edit.remove("nicklinked");
        edit.remove("chat_user_code");
        edit.apply();
        Toast makeText = Toast.makeText(profilePersonalActivity, profilePersonalActivity.getString(C2030R.string.profile_signedout), 1);
        makeText.setGravity(17, 0, 0);
        makeText.show();
        profilePersonalActivity.setResult(1, new Intent());
        profilePersonalActivity.finish();
    }

    public static /* synthetic */ void j0(ProfilePersonalActivity profilePersonalActivity, View view) {
        if (profilePersonalActivity.B0()) {
            AlertDialog.Builder builder = new AlertDialog.Builder(profilePersonalActivity);
            builder.setMessage(profilePersonalActivity.getString(C2030R.string.profile_delete_sure));
            builder.setCancelable(true);
            builder.setNegativeButton(profilePersonalActivity.getString(C2030R.string.manual_yes), new C1840o4(profilePersonalActivity));
            builder.setPositiveButton(profilePersonalActivity.getString(C2030R.string.status_cancel), new C1846p4());
            builder.create().show();
            return;
        }
        Toast makeText = Toast.makeText(profilePersonalActivity.getApplicationContext(), profilePersonalActivity.getString(C2030R.string.main_nointernet), 0);
        makeText.setGravity(17, 0, 0);
        makeText.show();
    }

    public static /* synthetic */ void k0(ProfilePersonalActivity profilePersonalActivity, DialogInterface dialogInterface, int i8) {
        profilePersonalActivity.getClass();
        C1155z f8 = FirebaseAuth.getInstance().f();
        if (f8 != null) {
            f8.i1(E.a(profilePersonalActivity.getSharedPreferences(MainActivity.class.getSimpleName(), 0).getString("token", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED), (String) null)).addOnCompleteListener(new C1852q4(profilePersonalActivity, f8));
        }
    }

    public static /* synthetic */ void l0(ProfilePersonalActivity profilePersonalActivity, Task task) {
        profilePersonalActivity.getClass();
        if (task.isSuccessful()) {
            new f(profilePersonalActivity, profilePersonalActivity.f13486U, (a) null).execute(new Context[0]);
        }
    }

    public static /* synthetic */ void m0(DialogInterface dialogInterface, int i8) {
    }

    public static /* synthetic */ boolean n0(ProfilePersonalActivity profilePersonalActivity, TextView textView, int i8, KeyEvent keyEvent) {
        profilePersonalActivity.getClass();
        if (keyEvent == null || keyEvent.getKeyCode() != 66) {
            return false;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) profilePersonalActivity.getSystemService("input_method");
        if (inputMethodManager == null) {
            return true;
        }
        inputMethodManager.hideSoftInputFromWindow(textView.getWindowToken(), 2);
        return true;
    }

    public static /* synthetic */ void o0(ProfilePersonalActivity profilePersonalActivity, Context context, View view) {
        if (!profilePersonalActivity.B0()) {
            Toast makeText = Toast.makeText(profilePersonalActivity.getApplicationContext(), profilePersonalActivity.getString(C2030R.string.main_nointernet), 0);
            makeText.setGravity(17, 0, 0);
            makeText.show();
        } else if (profilePersonalActivity.f13483R == 0 || profilePersonalActivity.f13482Q == 0 || profilePersonalActivity.f13481P.equalsIgnoreCase(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED)) {
            Toast makeText2 = Toast.makeText(profilePersonalActivity.getApplicationContext(), profilePersonalActivity.getString(C2030R.string.register_fill), 0);
            makeText2.setGravity(17, 0, 0);
            makeText2.show();
        } else {
            g gVar = new g(profilePersonalActivity, (a) null);
            profilePersonalActivity.f13480O = gVar;
            gVar.execute(new Context[]{context});
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2030R.layout.profile_personal_card);
        int i8 = getResources().getConfiguration().uiMode & 48;
        boolean z7 = true;
        if (Build.VERSION.SDK_INT >= 35 && i8 == 16) {
            Window window = getWindow();
            C0832r0.a(window, window.getDecorView()).d(true);
        }
        boolean z8 = getSharedPreferences(MainActivity.class.getSimpleName(), 0).getBoolean("pro_features", false);
        Toolbar toolbar = (Toolbar) findViewById(C2030R.id.toolbar);
        b0(toolbar);
        if (!z8) {
            toolbar.setLogo(2131230872);
        } else {
            toolbar.setLogo(2131230875);
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f13486U = extras.getString("com.finazzi.distquake.uID");
            this.f13485T = extras.getString("com.finazzi.distquake.nick");
            this.f13484S = extras.getInt("com.finazzi.distquake.accept_friendship");
            String string = extras.getString("com.finazzi.distquake.birth");
            if (string != null) {
                try {
                    f13479V = new SimpleDateFormat("yyyy-MM-dd", Locale.getDefault()).parse(string);
                } catch (ParseException e8) {
                    if (e8.getMessage() != null) {
                        Log.d("EQN", e8.getMessage());
                    }
                }
            }
            EditText editText = (EditText) findViewById(C2030R.id.editText1);
            editText.setText(this.f13485T);
            editText.addTextChangedListener(new a());
            this.f13481P = extras.getString("com.finazzi.distquake.town");
            EditText editText2 = (EditText) findViewById(C2030R.id.editText2);
            editText2.setText(this.f13481P);
            editText2.setOnEditorActionListener(new C1792g4(this));
            editText2.addTextChangedListener(new b());
            EditText editText3 = (EditText) findViewById(C2030R.id.editText3);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault());
            EditText editText4 = (EditText) findViewById(C2030R.id.editText3);
            editText4.setText(simpleDateFormat.format(f13479V));
            editText4.setOnClickListener(new C1804i4(this));
            editText4.addTextChangedListener(new c(simpleDateFormat));
            this.f13482Q = extras.getInt("com.finazzi.distquake.country");
            Spinner spinner = (Spinner) findViewById(C2030R.id.spinner1);
            spinner.setSelection(this.f13482Q);
            spinner.setOnItemSelectedListener(new d());
            this.f13483R = extras.getInt("com.finazzi.distquake.sex");
            Spinner spinner2 = (Spinner) findViewById(C2030R.id.spinner2);
            spinner2.setSelection(this.f13483R);
            spinner2.setOnItemSelectedListener(new e());
            CheckBox checkBox = (CheckBox) findViewById(C2030R.id.checkBox);
            if (this.f13484S != 1) {
                z7 = false;
            }
            checkBox.setChecked(z7);
            checkBox.setOnClickListener(new C1810j4(this));
            ((Button) findViewById(C2030R.id.button1)).setOnClickListener(new C1816k4(this, this));
            ((Button) findViewById(C2030R.id.button2)).setOnClickListener(new C1822l4(this));
            ((Button) findViewById(C2030R.id.button3)).setOnClickListener(new C1828m4(this));
        }
    }
}
