package com.finazzi.distquake;

import H3.f;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.C0768d;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.C0832r0;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.firebase.auth.C1155z;
import com.google.firebase.auth.FirebaseAuth;
import u2.C1756a4;
import u2.C1762b4;
import u2.C1768c4;
import u2.C1774d4;
import u2.C1780e4;
import u2.C1786f4;
import u2.W3;
import u2.X3;
import u2.Y3;
import u2.Z3;

public class ProfileOtherActivity extends C0768d {
    /* access modifiers changed from: private */

    /* renamed from: O  reason: collision with root package name */
    public int f13454O;
    /* access modifiers changed from: private */

    /* renamed from: P  reason: collision with root package name */
    public String f13455P = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    /* access modifiers changed from: private */

    /* renamed from: Q  reason: collision with root package name */
    public String f13456Q;
    /* access modifiers changed from: private */

    /* renamed from: R  reason: collision with root package name */
    public String f13457R;
    /* access modifiers changed from: private */

    /* renamed from: S  reason: collision with root package name */
    public String f13458S;
    /* access modifiers changed from: private */

    /* renamed from: T  reason: collision with root package name */
    public String f13459T;
    /* access modifiers changed from: private */

    /* renamed from: U  reason: collision with root package name */
    public SharedPreferences f13460U;

    /* renamed from: V  reason: collision with root package name */
    private FrameLayout f13461V;

    /* renamed from: W  reason: collision with root package name */
    private AdView f13462W;

    /* renamed from: X  reason: collision with root package name */
    private boolean f13463X;
    /* access modifiers changed from: private */

    /* renamed from: Y  reason: collision with root package name */
    public SQLiteDatabase f13464Y;
    /* access modifiers changed from: private */

    /* renamed from: Z  reason: collision with root package name */
    public C f13465Z;

    private class b extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private int f13466a;

        private b() {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x00ce  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00d9  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x00dd  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r7) {
            /*
                r6 = this;
                java.util.HashMap r7 = new java.util.HashMap
                r7.<init>()
                com.finazzi.distquake.ProfileOtherActivity r0 = com.finazzi.distquake.ProfileOtherActivity.this
                java.lang.String r0 = r0.f13456Q
                java.lang.String r1 = "nick"
                r7.put(r1, r0)
                com.finazzi.distquake.ProfileOtherActivity r0 = com.finazzi.distquake.ProfileOtherActivity.this
                java.lang.String r0 = r0.f13455P
                java.lang.String r1 = "nick_self"
                r7.put(r1, r0)
                com.finazzi.distquake.ProfileOtherActivity r0 = com.finazzi.distquake.ProfileOtherActivity.this
                int r0 = r0.f13454O
                java.lang.String r0 = java.lang.Integer.toString(r0)
                java.lang.String r1 = "user_code"
                r7.put(r1, r0)
                com.finazzi.distquake.ProfileOtherActivity r0 = com.finazzi.distquake.ProfileOtherActivity.this
                java.lang.String r0 = r0.f13459T
                java.lang.String r1 = "postfix"
                r7.put(r1, r0)
                java.lang.String r7 = u2.C1737L.a(r7)
                r0 = 1
                r1 = 0
                java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x00ca }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00ca }
                r3.<init>()     // Catch:{ IOException -> 0x00ca }
                com.finazzi.distquake.ProfileOtherActivity r4 = com.finazzi.distquake.ProfileOtherActivity.this     // Catch:{ IOException -> 0x00ca }
                r5 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r4 = r4.getString(r5)     // Catch:{ IOException -> 0x00ca }
                r3.append(r4)     // Catch:{ IOException -> 0x00ca }
                java.lang.String r4 = "distquake_upload_report_user.php"
                r3.append(r4)     // Catch:{ IOException -> 0x00ca }
                java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x00ca }
                r2.<init>(r3)     // Catch:{ IOException -> 0x00ca }
                java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x00ca }
                java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch:{ IOException -> 0x00ca }
                java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch:{ IOException -> 0x00ca }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x00ca }
                r2.setDoOutput(r0)     // Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
                r1 = 10000(0x2710, float:1.4013E-41)
                r2.setConnectTimeout(r1)     // Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
                r2.setReadTimeout(r1)     // Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
                java.lang.String r1 = "Content-Type"
                java.lang.String r3 = "application/x-www-form-urlencoded;charset=utf-8"
                r2.setRequestProperty(r1, r3)     // Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
                java.lang.String r1 = "POST"
                r2.setRequestMethod(r1)     // Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
                byte[] r1 = r7.getBytes()     // Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
                int r1 = r1.length     // Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
                r2.setFixedLengthStreamingMode(r1)     // Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
                java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
                java.io.OutputStream r3 = r2.getOutputStream()     // Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
                r1.print(r7)     // Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
                r1.close()     // Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
                java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
                java.io.InputStream r1 = r2.getInputStream()     // Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
                r7.<init>(r1)     // Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
                java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
                r3.<init>(r7, r4)     // Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
                r3.<init>()     // Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
            L_0x00ae:
                java.lang.String r4 = r1.readLine()     // Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
                if (r4 == 0) goto L_0x00bd
                r3.append(r4)     // Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
                goto L_0x00ae
            L_0x00b8:
                r7 = move-exception
                r1 = r2
                goto L_0x00e2
            L_0x00bb:
                r1 = r2
                goto L_0x00ca
            L_0x00bd:
                r7.close()     // Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
                java.lang.String r7 = r3.toString()     // Catch:{ IOException -> 0x00bb, all -> 0x00b8 }
                r2.disconnect()
                goto L_0x00d1
            L_0x00c8:
                r7 = move-exception
                goto L_0x00e2
            L_0x00ca:
                java.lang.String r7 = "nok"
                if (r1 == 0) goto L_0x00d1
                r1.disconnect()
            L_0x00d1:
                java.lang.String r1 = "ok"
                boolean r7 = r7.equals(r1)
                if (r7 == 0) goto L_0x00dd
                r7 = 0
                r6.f13466a = r7
                goto L_0x00df
            L_0x00dd:
                r6.f13466a = r0
            L_0x00df:
                java.lang.String r7 = "COMPLETE!"
                return r7
            L_0x00e2:
                if (r1 == 0) goto L_0x00e7
                r1.disconnect()
            L_0x00e7:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.ProfileOtherActivity.b.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            Toast toast;
            super.onPostExecute(str);
            if (this.f13466a == 0) {
                toast = Toast.makeText(ProfileOtherActivity.this.getApplicationContext(), ProfileOtherActivity.this.getString(C2030R.string.profile_report_received), 1);
                SharedPreferences.Editor edit = ProfileOtherActivity.this.f13460U.edit();
                edit.putLong("last_chat_user_report", System.currentTimeMillis());
                edit.apply();
            } else {
                toast = Toast.makeText(ProfileOtherActivity.this.getApplicationContext(), ProfileOtherActivity.this.getString(C2030R.string.manual_error), 1);
            }
            toast.setGravity(17, 0, 0);
            toast.show();
        }
    }

    private class c extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private Cursor f13468a;

        /* renamed from: b  reason: collision with root package name */
        private final String f13469b;

        /* renamed from: c  reason: collision with root package name */
        private final int f13470c;

        /* renamed from: d  reason: collision with root package name */
        private final String f13471d;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Context... contextArr) {
            ProfileOtherActivity profileOtherActivity = ProfileOtherActivity.this;
            SQLiteDatabase unused = profileOtherActivity.f13464Y = profileOtherActivity.f13465Z.getReadableDatabase();
            if (ProfileOtherActivity.this.f13464Y == null) {
                return "COMPLETE!";
            }
            this.f13468a = ProfileOtherActivity.this.f13464Y.query(this.f13469b, new String[]{"_id", "user_code"}, "user_code=" + this.f13470c, (String[]) null, (String) null, (String) null, (String) null);
            return "COMPLETE!";
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            Cursor cursor = this.f13468a;
            if (cursor != null) {
                cursor.moveToPosition(-1);
                int i8 = 0;
                while (this.f13468a.moveToNext()) {
                    Cursor cursor2 = this.f13468a;
                    i8 = cursor2.getInt(cursor2.getColumnIndexOrThrow("user_code"));
                }
                this.f13468a.close();
                int i9 = this.f13470c;
                if (i8 == i9) {
                    Toast makeText = Toast.makeText(ProfileOtherActivity.this.getApplicationContext(), ProfileOtherActivity.this.getString(C2030R.string.profile_blocked_already), 1);
                    makeText.setGravity(17, 0, 0);
                    makeText.show();
                    return;
                }
                new d(this.f13469b, i9, this.f13471d).execute(new Context[]{ProfileOtherActivity.this.getApplicationContext()});
            }
        }

        private c(String str, int i8, String str2) {
            this.f13469b = str;
            this.f13470c = i8;
            this.f13471d = str2;
        }
    }

    private class d extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private final String f13473a;

        /* renamed from: b  reason: collision with root package name */
        private final String f13474b;

        /* renamed from: c  reason: collision with root package name */
        private final int f13475c;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Context... contextArr) {
            ProfileOtherActivity profileOtherActivity = ProfileOtherActivity.this;
            SQLiteDatabase unused = profileOtherActivity.f13464Y = profileOtherActivity.f13465Z.getWritableDatabase();
            if (ProfileOtherActivity.this.f13464Y == null) {
                return "COMPLETE!";
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("user_code", Integer.valueOf(this.f13475c));
            contentValues.put("nick", this.f13474b);
            ProfileOtherActivity.this.f13464Y.insert(this.f13473a, (String) null, contentValues);
            String str = "user_code=" + this.f13475c;
            ProfileOtherActivity.this.f13464Y.delete("chat_public_ar", str, (String[]) null);
            ProfileOtherActivity.this.f13464Y.delete("chat_public_blk", str, (String[]) null);
            ProfileOtherActivity.this.f13464Y.delete("chat_public_el", str, (String[]) null);
            ProfileOtherActivity.this.f13464Y.delete("chat_public_eng", str, (String[]) null);
            ProfileOtherActivity.this.f13464Y.delete("chat_public_es", str, (String[]) null);
            ProfileOtherActivity.this.f13464Y.delete("chat_public_fr", str, (String[]) null);
            ProfileOtherActivity.this.f13464Y.delete("chat_public_hu", str, (String[]) null);
            ProfileOtherActivity.this.f13464Y.delete("chat_public_in", str, (String[]) null);
            ProfileOtherActivity.this.f13464Y.delete("chat_public_ita", str, (String[]) null);
            ProfileOtherActivity.this.f13464Y.delete("chat_public_jp", str, (String[]) null);
            ProfileOtherActivity.this.f13464Y.delete("chat_public_pt", str, (String[]) null);
            ProfileOtherActivity.this.f13464Y.delete("chat_public_ro", str, (String[]) null);
            ProfileOtherActivity.this.f13464Y.delete("chat_public_tag", str, (String[]) null);
            ProfileOtherActivity.this.f13464Y.delete("chat_public_tr", str, (String[]) null);
            return "COMPLETE!";
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            Toast makeText = Toast.makeText(ProfileOtherActivity.this.getApplicationContext(), ProfileOtherActivity.this.getString(C2030R.string.profile_blocked), 1);
            makeText.setGravity(17, 0, 0);
            makeText.show();
        }

        private d(String str, int i8, String str2) {
            this.f13473a = str;
            this.f13475c = i8;
            this.f13474b = str2;
        }
    }

    private class e extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private int f13477a;

        private e() {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x00e9  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00f4  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x00ff  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0109  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x0114  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x011f  */
        /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r7) {
            /*
                r6 = this;
                java.util.HashMap r7 = new java.util.HashMap
                r7.<init>()
                com.finazzi.distquake.ProfileOtherActivity r0 = com.finazzi.distquake.ProfileOtherActivity.this
                java.lang.String r0 = r0.f13458S
                java.lang.String r1 = "u_id"
                r7.put(r1, r0)
                com.finazzi.distquake.ProfileOtherActivity r0 = com.finazzi.distquake.ProfileOtherActivity.this
                java.lang.String r0 = r0.f13457R
                java.lang.String r1 = "password_ban"
                r7.put(r1, r0)
                com.finazzi.distquake.ProfileOtherActivity r0 = com.finazzi.distquake.ProfileOtherActivity.this
                int r0 = r0.f13454O
                java.lang.String r0 = java.lang.Integer.toString(r0)
                java.lang.String r1 = "user_code"
                r7.put(r1, r0)
                com.finazzi.distquake.ProfileOtherActivity r0 = com.finazzi.distquake.ProfileOtherActivity.this
                java.lang.String r0 = r0.f13455P
                java.lang.String r1 = "nick"
                r7.put(r1, r0)
                com.finazzi.distquake.ProfileOtherActivity r0 = com.finazzi.distquake.ProfileOtherActivity.this
                java.lang.String r0 = r0.E0()
                java.lang.String r1 = "uID"
                r7.put(r1, r0)
                com.finazzi.distquake.ProfileOtherActivity r0 = com.finazzi.distquake.ProfileOtherActivity.this
                java.lang.String r0 = r0.f13459T
                java.lang.String r1 = "postfix"
                r7.put(r1, r0)
                java.lang.String r7 = u2.C1737L.a(r7)
                r0 = 1
                r1 = 0
                java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x00e5 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00e5 }
                r3.<init>()     // Catch:{ IOException -> 0x00e5 }
                com.finazzi.distquake.ProfileOtherActivity r4 = com.finazzi.distquake.ProfileOtherActivity.this     // Catch:{ IOException -> 0x00e5 }
                r5 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r4 = r4.getString(r5)     // Catch:{ IOException -> 0x00e5 }
                r3.append(r4)     // Catch:{ IOException -> 0x00e5 }
                java.lang.String r4 = "distquake_ban_user2.php"
                r3.append(r4)     // Catch:{ IOException -> 0x00e5 }
                java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x00e5 }
                r2.<init>(r3)     // Catch:{ IOException -> 0x00e5 }
                java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x00e5 }
                java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch:{ IOException -> 0x00e5 }
                java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch:{ IOException -> 0x00e5 }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x00e5 }
                r2.setDoOutput(r0)     // Catch:{ IOException -> 0x00d6, all -> 0x00d3 }
                r1 = 10000(0x2710, float:1.4013E-41)
                r2.setConnectTimeout(r1)     // Catch:{ IOException -> 0x00d6, all -> 0x00d3 }
                r2.setReadTimeout(r1)     // Catch:{ IOException -> 0x00d6, all -> 0x00d3 }
                java.lang.String r1 = "Content-Type"
                java.lang.String r3 = "application/x-www-form-urlencoded;charset=utf-8"
                r2.setRequestProperty(r1, r3)     // Catch:{ IOException -> 0x00d6, all -> 0x00d3 }
                java.lang.String r1 = "POST"
                r2.setRequestMethod(r1)     // Catch:{ IOException -> 0x00d6, all -> 0x00d3 }
                byte[] r1 = r7.getBytes()     // Catch:{ IOException -> 0x00d6, all -> 0x00d3 }
                int r1 = r1.length     // Catch:{ IOException -> 0x00d6, all -> 0x00d3 }
                r2.setFixedLengthStreamingMode(r1)     // Catch:{ IOException -> 0x00d6, all -> 0x00d3 }
                java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch:{ IOException -> 0x00d6, all -> 0x00d3 }
                java.io.OutputStream r3 = r2.getOutputStream()     // Catch:{ IOException -> 0x00d6, all -> 0x00d3 }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00d6, all -> 0x00d3 }
                r1.print(r7)     // Catch:{ IOException -> 0x00d6, all -> 0x00d3 }
                r1.close()     // Catch:{ IOException -> 0x00d6, all -> 0x00d3 }
                java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00d6, all -> 0x00d3 }
                java.io.InputStream r1 = r2.getInputStream()     // Catch:{ IOException -> 0x00d6, all -> 0x00d3 }
                r7.<init>(r1)     // Catch:{ IOException -> 0x00d6, all -> 0x00d3 }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00d6, all -> 0x00d3 }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00d6, all -> 0x00d3 }
                java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00d6, all -> 0x00d3 }
                r3.<init>(r7, r4)     // Catch:{ IOException -> 0x00d6, all -> 0x00d3 }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00d6, all -> 0x00d3 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00d6, all -> 0x00d3 }
                r3.<init>()     // Catch:{ IOException -> 0x00d6, all -> 0x00d3 }
            L_0x00c4:
                java.lang.String r4 = r1.readLine()     // Catch:{ IOException -> 0x00d6, all -> 0x00d3 }
                if (r4 == 0) goto L_0x00d8
                r3.append(r4)     // Catch:{ IOException -> 0x00d6, all -> 0x00d3 }
                java.lang.String r4 = "\n"
                r3.append(r4)     // Catch:{ IOException -> 0x00d6, all -> 0x00d3 }
                goto L_0x00c4
            L_0x00d3:
                r7 = move-exception
                r1 = r2
                goto L_0x0125
            L_0x00d6:
                r1 = r2
                goto L_0x00e5
            L_0x00d8:
                r7.close()     // Catch:{ IOException -> 0x00d6, all -> 0x00d3 }
                java.lang.String r7 = r3.toString()     // Catch:{ IOException -> 0x00d6, all -> 0x00d3 }
                r2.disconnect()
                goto L_0x00ec
            L_0x00e3:
                r7 = move-exception
                goto L_0x0125
            L_0x00e5:
                java.lang.String r7 = "nok"
                if (r1 == 0) goto L_0x00ec
                r1.disconnect()
            L_0x00ec:
                java.lang.String r1 = "ok\n"
                boolean r1 = r7.equals(r1)
                if (r1 == 0) goto L_0x00f7
                r1 = 0
                r6.f13477a = r1
            L_0x00f7:
                java.lang.String r1 = "wrongpwd\n"
                boolean r1 = r7.equals(r1)
                if (r1 == 0) goto L_0x0101
                r6.f13477a = r0
            L_0x0101:
                java.lang.String r0 = "nomod\n"
                boolean r0 = r7.equals(r0)
                if (r0 == 0) goto L_0x010c
                r0 = 2
                r6.f13477a = r0
            L_0x010c:
                java.lang.String r0 = "wrong\n"
                boolean r0 = r7.equals(r0)
                if (r0 == 0) goto L_0x0117
                r0 = 3
                r6.f13477a = r0
            L_0x0117:
                java.lang.String r0 = "already\n"
                boolean r7 = r7.equals(r0)
                if (r7 == 0) goto L_0x0122
                r7 = 4
                r6.f13477a = r7
            L_0x0122:
                java.lang.String r7 = "COMPLETE!"
                return r7
            L_0x0125:
                if (r1 == 0) goto L_0x012a
                r1.disconnect()
            L_0x012a:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.ProfileOtherActivity.e.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            if (this.f13477a == 0) {
                Toast makeText = Toast.makeText(ProfileOtherActivity.this.getApplicationContext(), ProfileOtherActivity.this.getString(C2030R.string.profile_moderator_banned), 1);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
            if (this.f13477a == 1) {
                Toast makeText2 = Toast.makeText(ProfileOtherActivity.this.getApplicationContext(), ProfileOtherActivity.this.getString(C2030R.string.profile_moderator_wrong_password), 1);
                makeText2.setGravity(17, 0, 0);
                makeText2.show();
            }
            if (this.f13477a == 2) {
                Toast makeText3 = Toast.makeText(ProfileOtherActivity.this.getApplicationContext(), ProfileOtherActivity.this.getString(C2030R.string.profile_moderator_wrong_id), 1);
                makeText3.setGravity(17, 0, 0);
                makeText3.show();
            }
            if (this.f13477a == 3) {
                Toast makeText4 = Toast.makeText(ProfileOtherActivity.this.getApplicationContext(), ProfileOtherActivity.this.getString(C2030R.string.manual_error), 1);
                makeText4.setGravity(17, 0, 0);
                makeText4.show();
            }
            if (this.f13477a == 4) {
                Toast makeText5 = Toast.makeText(ProfileOtherActivity.this.getApplicationContext(), ProfileOtherActivity.this.getString(C2030R.string.profile_moderator_already_banned), 1);
                makeText5.setGravity(17, 0, 0);
                makeText5.show();
            }
        }
    }

    /* access modifiers changed from: private */
    public void A0() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(getString(C2030R.string.profile_block_sure));
        builder.setCancelable(true);
        builder.setNegativeButton(getString(C2030R.string.manual_yes), new C1780e4(this));
        builder.setPositiveButton(getString(C2030R.string.manual_no), new C1786f4());
        builder.create().show();
    }

    private AdSize B0() {
        Display defaultDisplay = getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return AdSize.getCurrentOrientationAnchoredAdaptiveBannerAdSize(this, (int) (((float) displayMetrics.widthPixels) / displayMetrics.density));
    }

    private String C0() {
        return this.f13460U.getString("android_id_eqn", "0");
    }

    private String D0() {
        if (FirebaseAuth.getInstance().f() != null) {
            SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.class.getSimpleName(), 0);
            if (sharedPreferences.getBoolean("nicklinked", false)) {
                return sharedPreferences.getString("nick", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
            }
        }
        return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    }

    /* access modifiers changed from: private */
    public String E0() {
        C1155z f8 = FirebaseAuth.getInstance().f();
        if (f8 != null) {
            return f8.f1();
        }
        return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    }

    /* access modifiers changed from: private */
    public void F0() {
        View inflate = LayoutInflater.from(this).inflate(C2030R.layout.pwd_dialog, (ViewGroup) null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setNegativeButton(getString(C2030R.string.profile_ban), new C1768c4(this, inflate));
        builder.setPositiveButton(getString(C2030R.string.map_clear), new C1774d4());
        AlertDialog create = builder.create();
        create.setView(inflate, 0, 0, 0, 0);
        create.setInverseBackgroundForced(true);
        create.show();
    }

    private void G0() {
        AdView adView = new AdView(this);
        this.f13462W = adView;
        adView.setAdUnitId("ca-app-pub-4050044861382446/6189681827");
        this.f13461V.removeAllViews();
        this.f13461V.addView(this.f13462W);
        this.f13462W.setAdSize(B0());
        this.f13462W.loadAd(new AdRequest.Builder().build());
    }

    /* access modifiers changed from: private */
    public void H0() {
        if (System.currentTimeMillis() - this.f13460U.getLong("last_chat_user_report", 0) > 60000) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(getString(C2030R.string.profile_report_sure));
            builder.setCancelable(true);
            builder.setNegativeButton(getString(C2030R.string.manual_yes), new C1756a4(this));
            builder.setPositiveButton(getString(C2030R.string.manual_no), new C1762b4());
            builder.create().show();
        }
    }

    public static /* synthetic */ void e0(ProfileOtherActivity profileOtherActivity, DialogInterface dialogInterface, int i8) {
        profileOtherActivity.getClass();
        ProfileOtherActivity profileOtherActivity2 = profileOtherActivity;
        new c("blocked_users", profileOtherActivity.f13454O, profileOtherActivity.f13456Q).execute(new Context[]{profileOtherActivity2.getApplicationContext()});
    }

    public static /* synthetic */ void f0(ProfileOtherActivity profileOtherActivity, InitializationStatus initializationStatus) {
        profileOtherActivity.f13461V = (FrameLayout) profileOtherActivity.findViewById(C2030R.id.ad_view_container);
        profileOtherActivity.G0();
    }

    public static /* synthetic */ void g0(DialogInterface dialogInterface, int i8) {
    }

    public static /* synthetic */ void i0(ProfileOtherActivity profileOtherActivity, View view, DialogInterface dialogInterface, int i8) {
        profileOtherActivity.getClass();
        profileOtherActivity.f13457R = ((EditText) view.findViewById(C2030R.id.editText1)).getText().toString();
        profileOtherActivity.f13458S = profileOtherActivity.C0();
        InputMethodManager inputMethodManager = (InputMethodManager) profileOtherActivity.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
        }
        profileOtherActivity.z0();
    }

    public static /* synthetic */ void j0(ProfileOtherActivity profileOtherActivity, DialogInterface dialogInterface, int i8) {
        profileOtherActivity.getClass();
        new b().execute(new Context[]{profileOtherActivity});
    }

    public static /* synthetic */ void l0(DialogInterface dialogInterface, int i8) {
    }

    public static /* synthetic */ void n0(DialogInterface dialogInterface, int i8) {
    }

    private void z0() {
        new e().execute(new Context[]{this});
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2030R.layout.profile_other_card);
        int i8 = getResources().getConfiguration().uiMode & 48;
        if (Build.VERSION.SDK_INT >= 35 && i8 == 16) {
            Window window = getWindow();
            C0832r0.a(window, window.getDecorView()).d(true);
        }
        this.f13465Z = new C(getApplicationContext());
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.class.getSimpleName(), 0);
        this.f13460U = sharedPreferences;
        this.f13463X = sharedPreferences.getBoolean("pro_features", false);
        int i9 = this.f13460U.getInt("chat_mod", 0);
        this.f13455P = D0();
        Toolbar toolbar = (Toolbar) findViewById(C2030R.id.toolbar);
        b0(toolbar);
        if (!this.f13463X) {
            toolbar.setLogo(2131230872);
        } else {
            toolbar.setLogo(2131230875);
        }
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f13456Q = extras.getString("com.finazzi.distquake.nick");
            ((EditText) findViewById(C2030R.id.editText1)).setText(this.f13456Q);
            ((Spinner) findViewById(C2030R.id.spinner2)).setSelection(extras.getInt("com.finazzi.distquake.sex"));
            ((Spinner) findViewById(C2030R.id.spinner1)).setSelection(extras.getInt("com.finazzi.distquake.country"));
            ((EditText) findViewById(C2030R.id.editText2)).setText(extras.getString("com.finazzi.distquake.town"));
            int i10 = extras.getInt("com.finazzi.distquake.age");
            this.f13454O = extras.getInt("com.finazzi.distquake.user_code");
            if (extras.getInt("com.finazzi.distquake.updated") == 1) {
                ((EditText) findViewById(C2030R.id.editText3)).setText(getResources().getQuantityString(C2030R.plurals.profile_years_ago, i10, new Object[]{Integer.valueOf(i10)}));
            }
            int i11 = extras.getInt("com.finazzi.distquake.firstlog");
            ((EditText) findViewById(C2030R.id.editText4)).setText(getResources().getQuantityString(C2030R.plurals.profile_firstlog_days, i11, new Object[]{Integer.valueOf(i11)}));
            int i12 = extras.getInt("com.finazzi.distquake.accept_friendship");
            TextView textView = (TextView) findViewById(C2030R.id.textView5);
            if (i12 == 1) {
                textView.setText(getString(C2030R.string.profile_friendship_allowed));
                textView.setTextColor(Color.argb(255, 0, 190, 0));
            } else {
                textView.setText(getString(C2030R.string.profile_friendship_disallowed));
                textView.setTextColor(-65536);
            }
            this.f13459T = extras.getString("com.finazzi.distquake.postfix");
            Button button = (Button) findViewById(C2030R.id.button1);
            button.setOnClickListener(new W3(this));
            if (i9 == 0) {
                button.setVisibility(8);
            }
            Button button2 = (Button) findViewById(C2030R.id.button2);
            button2.setOnClickListener(new X3(this));
            if (this.f13456Q.equalsIgnoreCase(this.f13455P)) {
                button2.setEnabled(false);
            }
            Button button3 = (Button) findViewById(C2030R.id.button3);
            button3.setOnClickListener(new Y3(this));
            if (this.f13456Q.equalsIgnoreCase(this.f13455P)) {
                button3.setEnabled(false);
            }
        }
        if (!this.f13463X && f.a(this).canRequestAds()) {
            MobileAds.initialize(this, new Z3(this));
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        AdView adView = this.f13462W;
        if (adView != null) {
            adView.destroy();
        }
        super.onDestroy();
    }

    public void onPause() {
        super.onPause();
        AdView adView = this.f13462W;
        if (adView != null) {
            adView.pause();
        }
    }

    public void onResume() {
        AdView adView;
        super.onResume();
        if (!this.f13463X && (adView = this.f13462W) != null) {
            adView.resume();
        }
    }
}
