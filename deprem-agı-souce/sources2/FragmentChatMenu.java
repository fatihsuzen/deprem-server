package com.finazzi.distquake;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.cardview.widget.CardView;
import androidx.core.view.B;
import androidx.core.view.C;
import androidx.fragment.app.C0887n;
import androidx.fragment.app.C0891s;
import androidx.lifecycle.C0910l;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.common.Scopes;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.C1155z;
import com.google.firebase.auth.FirebaseAuth;
import h.C1313a;
import h.C1315c;
import i.C1398c;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import u2.C1739N;
import u2.C1740O;
import u2.C1741P;
import u2.C1742Q;
import u2.C1743S;
import u2.C1744T;
import u2.C1745U;
import u2.C1746V;
import u2.C1747W;
import u2.C1748X;
import u2.C1749Y;
import u2.C1750Z;
import u2.C1752a0;
import u2.C1758b0;
import u2.C1764c0;
import u2.C1770d0;
import u2.C1776e0;
import u2.C1782f0;
import u2.C1788g0;
import u2.C1794h0;
import u2.C1800i0;
import u2.C1806j0;
import u2.C1812k0;
import v2.d;
import v2.h;
import v2.j;

public class FragmentChatMenu extends C0887n {
    /* access modifiers changed from: private */

    /* renamed from: n0  reason: collision with root package name */
    public SharedPreferences f12807n0;
    /* access modifiers changed from: private */

    /* renamed from: o0  reason: collision with root package name */
    public C f12808o0;
    /* access modifiers changed from: private */

    /* renamed from: p0  reason: collision with root package name */
    public View f12809p0;

    /* renamed from: q0  reason: collision with root package name */
    private g f12810q0;

    /* renamed from: r0  reason: collision with root package name */
    private ScrollView f12811r0;
    /* access modifiers changed from: private */

    /* renamed from: s0  reason: collision with root package name */
    public boolean f12812s0 = false;
    /* access modifiers changed from: private */

    /* renamed from: t0  reason: collision with root package name */
    public boolean f12813t0;
    /* access modifiers changed from: private */

    /* renamed from: u0  reason: collision with root package name */
    public FirebaseAuth f12814u0;

    /* renamed from: v0  reason: collision with root package name */
    private C1315c f12815v0;

    class a implements C {
        a() {
        }

        public boolean a(MenuItem menuItem) {
            if (menuItem.getItemId() != C2030R.id.menu_profile) {
                return false;
            }
            if (!FragmentChatMenu.this.g1()) {
                Toast makeText = Toast.makeText(FragmentChatMenu.this.getActivity(), FragmentChatMenu.this.getString(C2030R.string.chat_register3), 1);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            } else if (FragmentChatMenu.this.f12814u0.f() != null) {
                FragmentChatMenu fragmentChatMenu = FragmentChatMenu.this;
                new c(fragmentChatMenu, fragmentChatMenu.f12814u0.f().f1(), (a) null).execute(new Context[]{FragmentChatMenu.this.getActivity()});
            }
            return true;
        }

        public /* synthetic */ void b(Menu menu) {
            B.a(this, menu);
        }

        public void c(Menu menu, MenuInflater menuInflater) {
            menuInflater.inflate(C2030R.menu.chat_menu, menu);
            menu.getItem(1).setVisible(false);
            menu.getItem(2).setVisible(false);
            menu.getItem(3).setVisible(false);
        }

        public void d(Menu menu) {
            if (!FragmentChatMenu.this.f12812s0 && FragmentChatMenu.this.g1()) {
                FragmentChatMenu.this.k1();
            }
        }
    }

    private class c extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private int f12820a;

        /* renamed from: b  reason: collision with root package name */
        private String f12821b;

        /* renamed from: c  reason: collision with root package name */
        private final String f12822c;

        /* synthetic */ c(FragmentChatMenu fragmentChatMenu, String str, a aVar) {
            this(str);
        }

        public static /* synthetic */ void a(c cVar, Activity activity, Task task) {
            cVar.getClass();
            SharedPreferences.Editor edit = activity.getSharedPreferences(MainActivity.class.getSimpleName(), 0).edit();
            edit.remove("token");
            edit.remove("nick");
            edit.remove("uID");
            edit.remove("nicklinked");
            edit.remove("chat_user_code");
            edit.apply();
            Button button = (Button) FragmentChatMenu.this.f12809p0.findViewById(C2030R.id.button1);
            button.setText(FragmentChatMenu.this.getString(C2030R.string.connect_to_chat));
            button.setVisibility(0);
            ((TextView) FragmentChatMenu.this.f12809p0.findViewById(C2030R.id.textView1)).setText(FragmentChatMenu.this.getString(C2030R.string.chat_menu_personal));
            ((ImageView) FragmentChatMenu.this.f12809p0.findViewById(C2030R.id.imageView1)).setImageResource(C2030R.drawable.account);
            FirebaseAuth unused = FragmentChatMenu.this.f12814u0 = null;
            Toast makeText = Toast.makeText(activity, FragmentChatMenu.this.getString(C2030R.string.profile_signedout), 1);
            makeText.setGravity(17, 0, 0);
            makeText.show();
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(5:15|14|24|25|(0)(0)) */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00cc, code lost:
            r7 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x00d2, code lost:
            r0.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:29:0x00d8, code lost:
            r0.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:24:0x00ce */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x00d2  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00d8  */
        /* JADX WARNING: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r7) {
            /*
                r6 = this;
                com.finazzi.distquake.FragmentChatMenu r7 = com.finazzi.distquake.FragmentChatMenu.this
                boolean r7 = r7.isAdded()
                com.finazzi.distquake.FragmentChatMenu r0 = com.finazzi.distquake.FragmentChatMenu.this
                androidx.fragment.app.s r0 = r0.getActivity()
                r1 = 2
                if (r0 == 0) goto L_0x00dc
                if (r7 == 0) goto L_0x00dc
                java.util.HashMap r7 = new java.util.HashMap
                r7.<init>()
                java.lang.String r0 = "uID"
                java.lang.String r2 = r6.f12822c
                r7.put(r0, r2)
                java.lang.String r7 = u2.C1737L.a(r7)
                r0 = 0
                java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x00ce }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00ce }
                r3.<init>()     // Catch:{ IOException -> 0x00ce }
                com.finazzi.distquake.FragmentChatMenu r4 = com.finazzi.distquake.FragmentChatMenu.this     // Catch:{ IOException -> 0x00ce }
                r5 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r4 = r4.getString(r5)     // Catch:{ IOException -> 0x00ce }
                r3.append(r4)     // Catch:{ IOException -> 0x00ce }
                java.lang.String r4 = "distquake_download_userprofile2.php"
                r3.append(r4)     // Catch:{ IOException -> 0x00ce }
                java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x00ce }
                r2.<init>(r3)     // Catch:{ IOException -> 0x00ce }
                java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x00ce }
                java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch:{ IOException -> 0x00ce }
                java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch:{ IOException -> 0x00ce }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x00ce }
                r0 = 1
                r2.setDoOutput(r0)     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
                r3 = 10000(0x2710, float:1.4013E-41)
                r2.setConnectTimeout(r3)     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
                r2.setReadTimeout(r3)     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
                java.lang.String r3 = "Content-Type"
                java.lang.String r4 = "application/x-www-form-urlencoded;charset=utf-8"
                r2.setRequestProperty(r3, r4)     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
                java.lang.String r3 = "POST"
                r2.setRequestMethod(r3)     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
                byte[] r3 = r7.getBytes()     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
                int r3 = r3.length     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
                r2.setFixedLengthStreamingMode(r3)     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
                java.io.PrintWriter r3 = new java.io.PrintWriter     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
                java.io.OutputStream r4 = r2.getOutputStream()     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
                r3.<init>(r4)     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
                r3.print(r7)     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
                r3.close()     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
                java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
                java.io.InputStream r3 = r2.getInputStream()     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
                r7.<init>(r3)     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
                java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
                java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
                java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
                r4.<init>(r7, r5)     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
                r3.<init>(r4)     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
                r4.<init>()     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
            L_0x0096:
                java.lang.String r5 = r3.readLine()     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
                if (r5 == 0) goto L_0x00a5
                r4.append(r5)     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
                goto L_0x0096
            L_0x00a0:
                r7 = move-exception
                r0 = r2
                goto L_0x00d6
            L_0x00a3:
                r0 = r2
                goto L_0x00ce
            L_0x00a5:
                r7.close()     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
                java.lang.String r7 = r4.toString()     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
                r6.f12821b = r7     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
                r3 = 0
                r6.f12820a = r3     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
                java.lang.String r3 = "not_found"
                boolean r7 = r7.equals(r3)     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
                if (r7 == 0) goto L_0x00bc
                r6.f12820a = r0     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
                goto L_0x00c8
            L_0x00bc:
                java.lang.String r7 = r6.f12821b     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
                java.lang.String r0 = "nok"
                boolean r7 = r7.equals(r0)     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
                if (r7 == 0) goto L_0x00c8
                r6.f12820a = r1     // Catch:{ IOException -> 0x00a3, all -> 0x00a0 }
            L_0x00c8:
                r2.disconnect()
                goto L_0x00de
            L_0x00cc:
                r7 = move-exception
                goto L_0x00d6
            L_0x00ce:
                r6.f12820a = r1     // Catch:{ all -> 0x00cc }
                if (r0 == 0) goto L_0x00de
                r0.disconnect()
                goto L_0x00de
            L_0x00d6:
                if (r0 == 0) goto L_0x00db
                r0.disconnect()
            L_0x00db:
                throw r7
            L_0x00dc:
                r6.f12820a = r1
            L_0x00de:
                java.lang.String r7 = "COMPLETE!"
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.FragmentChatMenu.c.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            int i8 = this.f12820a;
            if (i8 == 0) {
                try {
                    JSONObject jSONObject = new JSONArray(this.f12821b).getJSONObject(0);
                    String string = jSONObject.getString("nick");
                    int i9 = jSONObject.getInt("sex");
                    int i10 = jSONObject.getInt("country");
                    String string2 = jSONObject.getString("town");
                    String string3 = jSONObject.getString("birth");
                    int i11 = jSONObject.getInt("fr");
                    C0891s activity = FragmentChatMenu.this.getActivity();
                    if (activity != null) {
                        Intent intent = new Intent().setClass(activity, ProfilePersonalActivity.class);
                        intent.putExtra("com.finazzi.distquake.nick", string);
                        intent.putExtra("com.finazzi.distquake.sex", i9);
                        intent.putExtra("com.finazzi.distquake.country", i10);
                        intent.putExtra("com.finazzi.distquake.town", string2);
                        intent.putExtra("com.finazzi.distquake.birth", string3);
                        intent.putExtra("com.finazzi.distquake.accept_friendship", i11);
                        intent.putExtra("com.finazzi.distquake.uID", this.f12822c);
                        FragmentChatMenu.this.startActivityForResult(intent, 2);
                    }
                } catch (JSONException unused) {
                    C0891s activity2 = FragmentChatMenu.this.getActivity();
                    if (activity2 != null) {
                        Toast makeText = Toast.makeText(activity2, FragmentChatMenu.this.getString(C2030R.string.manual_error), 0);
                        makeText.setGravity(17, 0, 0);
                        makeText.show();
                    }
                }
            } else if (i8 == 1) {
                C0891s activity3 = FragmentChatMenu.this.getActivity();
                if (activity3 != null) {
                    v2.d.k().q(activity3).addOnCompleteListener(new H(this, activity3));
                }
            } else {
                C0891s activity4 = FragmentChatMenu.this.getActivity();
                if (activity4 != null) {
                    Toast makeText2 = Toast.makeText(activity4, FragmentChatMenu.this.getString(C2030R.string.manual_error), 0);
                    makeText2.setGravity(17, 0, 0);
                    makeText2.show();
                }
            }
        }

        private c(String str) {
            this.f12821b = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
            this.f12822c = str;
        }
    }

    private class d extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private boolean f12824a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f12825b;

        /* renamed from: c  reason: collision with root package name */
        private String f12826c;

        /* renamed from: d  reason: collision with root package name */
        private final String f12827d;

        /* renamed from: e  reason: collision with root package name */
        private final String f12828e;

        /* synthetic */ d(FragmentChatMenu fragmentChatMenu, String str, String str2, a aVar) {
            this(str, str2);
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
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r7) {
            /*
                r6 = this;
                com.finazzi.distquake.FragmentChatMenu r7 = com.finazzi.distquake.FragmentChatMenu.this
                boolean r7 = r7.isAdded()
                com.finazzi.distquake.FragmentChatMenu r0 = com.finazzi.distquake.FragmentChatMenu.this
                androidx.fragment.app.s r0 = r0.getActivity()
                r1 = 1
                if (r0 == 0) goto L_0x00d8
                if (r7 == 0) goto L_0x00d8
                java.util.HashMap r7 = new java.util.HashMap
                r7.<init>()
                java.lang.String r0 = "u_id"
                java.lang.String r2 = r6.f12827d
                r7.put(r0, r2)
                java.lang.String r0 = "uID"
                java.lang.String r2 = r6.f12828e
                r7.put(r0, r2)
                java.lang.String r7 = u2.C1737L.a(r7)
                r0 = 0
                java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x00ca }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00ca }
                r3.<init>()     // Catch:{ IOException -> 0x00ca }
                com.finazzi.distquake.FragmentChatMenu r4 = com.finazzi.distquake.FragmentChatMenu.this     // Catch:{ IOException -> 0x00ca }
                r5 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r4 = r4.getString(r5)     // Catch:{ IOException -> 0x00ca }
                r3.append(r4)     // Catch:{ IOException -> 0x00ca }
                java.lang.String r4 = "distquake_download_linknick.php"
                r3.append(r4)     // Catch:{ IOException -> 0x00ca }
                java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x00ca }
                r2.<init>(r3)     // Catch:{ IOException -> 0x00ca }
                java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x00ca }
                java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch:{ IOException -> 0x00ca }
                java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch:{ IOException -> 0x00ca }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x00ca }
                r2.setDoOutput(r1)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r0 = 10000(0x2710, float:1.4013E-41)
                r2.setConnectTimeout(r0)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r2.setReadTimeout(r0)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.lang.String r0 = "Content-Type"
                java.lang.String r3 = "application/x-www-form-urlencoded;charset=utf-8"
                r2.setRequestProperty(r0, r3)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.lang.String r0 = "POST"
                r2.setRequestMethod(r0)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                byte[] r0 = r7.getBytes()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                int r0 = r0.length     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r2.setFixedLengthStreamingMode(r0)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.io.PrintWriter r0 = new java.io.PrintWriter     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.io.OutputStream r3 = r2.getOutputStream()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r0.<init>(r3)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r0.print(r7)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r0.close()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.io.InputStream r0 = r2.getInputStream()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r7.<init>(r0)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r3.<init>(r7, r4)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r0.<init>(r3)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r3.<init>()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
            L_0x009c:
                java.lang.String r4 = r0.readLine()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                if (r4 == 0) goto L_0x00b0
                r3.append(r4)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.lang.String r4 = "\n"
                r3.append(r4)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                goto L_0x009c
            L_0x00ab:
                r7 = move-exception
                r0 = r2
                goto L_0x00d2
            L_0x00ae:
                r0 = r2
                goto L_0x00ca
            L_0x00b0:
                r7.close()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.lang.String r7 = r3.toString()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r6.f12826c = r7     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r0 = 0
                r6.f12824a = r0     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.lang.String r0 = "not_found\n"
                boolean r7 = r7.equalsIgnoreCase(r0)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r6.f12825b = r7     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r2.disconnect()
                goto L_0x00da
            L_0x00c8:
                r7 = move-exception
                goto L_0x00d2
            L_0x00ca:
                r6.f12824a = r1     // Catch:{ all -> 0x00c8 }
                if (r0 == 0) goto L_0x00da
                r0.disconnect()
                goto L_0x00da
            L_0x00d2:
                if (r0 == 0) goto L_0x00d7
                r0.disconnect()
            L_0x00d7:
                throw r7
            L_0x00d8:
                r6.f12824a = r1
            L_0x00da:
                java.lang.String r7 = "COMPLETE!"
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.FragmentChatMenu.d.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            int i8;
            super.onPostExecute(str);
            if (this.f12824a) {
                C0891s activity = FragmentChatMenu.this.getActivity();
                if (activity != null) {
                    Toast makeText = Toast.makeText(activity, FragmentChatMenu.this.getString(C2030R.string.manual_error), 0);
                    makeText.setGravity(17, 0, 0);
                    makeText.show();
                }
            } else if (!this.f12825b) {
                try {
                    JSONObject jSONObject = new JSONArray(this.f12826c).getJSONObject(0);
                    String string = jSONObject.getString("nick");
                    try {
                        i8 = Integer.parseInt(jSONObject.getString("user_code"));
                    } catch (NumberFormatException unused) {
                        i8 = 0;
                    }
                    if (FragmentChatMenu.this.getActivity() != null) {
                        SharedPreferences.Editor edit = FragmentChatMenu.this.f12807n0.edit();
                        edit.putString("nick", string);
                        edit.putBoolean("nicklinked", true);
                        edit.putInt("chat_user_code", i8);
                        edit.apply();
                        if (FragmentChatMenu.this.f12814u0.f() != null) {
                            ((TextView) FragmentChatMenu.this.f12809p0.findViewById(C2030R.id.textView1)).setText(String.format(FragmentChatMenu.this.getString(C2030R.string.chat_menu_personal_linked), new Object[]{string}));
                            Button button = (Button) FragmentChatMenu.this.f12809p0.findViewById(C2030R.id.button1);
                            button.setText(FragmentChatMenu.this.getString(C2030R.string.profile_disconnect));
                            button.setVisibility(8);
                        }
                    }
                } catch (JSONException unused2) {
                    Toast makeText2 = Toast.makeText(FragmentChatMenu.this.getActivity(), FragmentChatMenu.this.getString(C2030R.string.manual_error), 0);
                    makeText2.setGravity(17, 0, 0);
                    makeText2.show();
                }
            } else {
                C0891s activity2 = FragmentChatMenu.this.getActivity();
                if (activity2 != null) {
                    Intent intent = new Intent().setClass(activity2, RegisterActivity.class);
                    intent.putExtra("com.finazzi.distquake.uID", this.f12828e);
                    FragmentChatMenu.this.startActivityForResult(intent, 1);
                }
            }
        }

        private d(String str, String str2) {
            this.f12826c = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
            this.f12827d = str;
            this.f12828e = str2;
        }
    }

    private class e extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private Cursor f12830a;

        private e() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Context... contextArr) {
            boolean unused = FragmentChatMenu.this.f12812s0 = true;
            SQLiteDatabase readableDatabase = FragmentChatMenu.this.f12808o0.getReadableDatabase();
            if (readableDatabase == null) {
                return "COMPLETE!";
            }
            this.f12830a = readableDatabase.query("chat_preview", new String[]{"read"}, "read=?", new String[]{Integer.toString(0)}, (String) null, (String) null, (String) null);
            return "COMPLETE!";
        }

        /* JADX INFO: finally extract failed */
        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            Cursor cursor = this.f12830a;
            if (cursor != null) {
                try {
                    int count = cursor.getCount();
                    this.f12830a.close();
                    if (FragmentChatMenu.this.getActivity() != null) {
                        TextView textView = (TextView) FragmentChatMenu.this.f12809p0.findViewById(C2030R.id.textView1);
                        if (count == 0) {
                            textView.setText(String.format(FragmentChatMenu.this.getString(C2030R.string.chat_menu_personal_linked), new Object[]{FragmentChatMenu.this.e1()}));
                            textView.setTypeface((Typeface) null, 0);
                        } else {
                            textView.setText(String.format(FragmentChatMenu.this.getString(C2030R.string.chat_menu_personal_linked), new Object[]{FragmentChatMenu.this.e1()}) + " (" + count + ")");
                            textView.setTypeface((Typeface) null, 1);
                        }
                    }
                } catch (Throwable th) {
                    this.f12830a.close();
                    throw th;
                }
            }
            boolean unused = FragmentChatMenu.this.f12812s0 = false;
        }

        /* synthetic */ e(FragmentChatMenu fragmentChatMenu, a aVar) {
            this();
        }
    }

    private class f extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private boolean f12832a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f12833b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f12834c;

        /* renamed from: d  reason: collision with root package name */
        private final String f12835d;

        /* renamed from: e  reason: collision with root package name */
        private final String f12836e;

        /* synthetic */ f(FragmentChatMenu fragmentChatMenu, String str, String str2, a aVar) {
            this(str, str2);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(5:14|13|21|22|(0)(0)) */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x00d3, code lost:
            r7 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:24:0x00d9, code lost:
            r0.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x00df, code lost:
            r0.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:33:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x00d5 */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x00d9  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x00df  */
        /* JADX WARNING: Removed duplicated region for block: B:32:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r7) {
            /*
                r6 = this;
                com.finazzi.distquake.FragmentChatMenu r7 = com.finazzi.distquake.FragmentChatMenu.this
                boolean r7 = r7.isAdded()
                com.finazzi.distquake.FragmentChatMenu r0 = com.finazzi.distquake.FragmentChatMenu.this
                androidx.fragment.app.s r0 = r0.getActivity()
                r1 = 1
                if (r0 == 0) goto L_0x00e3
                if (r7 == 0) goto L_0x00e3
                java.util.HashMap r7 = new java.util.HashMap
                r7.<init>()
                java.lang.String r0 = "u_id"
                java.lang.String r2 = r6.f12835d
                r7.put(r0, r2)
                java.lang.String r0 = "uID"
                java.lang.String r2 = r6.f12836e
                r7.put(r0, r2)
                java.lang.String r7 = u2.C1737L.a(r7)
                r0 = 0
                java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x00d5 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00d5 }
                r3.<init>()     // Catch:{ IOException -> 0x00d5 }
                com.finazzi.distquake.FragmentChatMenu r4 = com.finazzi.distquake.FragmentChatMenu.this     // Catch:{ IOException -> 0x00d5 }
                r5 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r4 = r4.getString(r5)     // Catch:{ IOException -> 0x00d5 }
                r3.append(r4)     // Catch:{ IOException -> 0x00d5 }
                java.lang.String r4 = "distquake_download_moderator.php"
                r3.append(r4)     // Catch:{ IOException -> 0x00d5 }
                java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x00d5 }
                r2.<init>(r3)     // Catch:{ IOException -> 0x00d5 }
                java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x00d5 }
                java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch:{ IOException -> 0x00d5 }
                java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch:{ IOException -> 0x00d5 }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x00d5 }
                r2.setDoOutput(r1)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r0 = 10000(0x2710, float:1.4013E-41)
                r2.setConnectTimeout(r0)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r2.setReadTimeout(r0)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.lang.String r0 = "Content-Type"
                java.lang.String r3 = "application/x-www-form-urlencoded;charset=utf-8"
                r2.setRequestProperty(r0, r3)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.lang.String r0 = "POST"
                r2.setRequestMethod(r0)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                byte[] r0 = r7.getBytes()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                int r0 = r0.length     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r2.setFixedLengthStreamingMode(r0)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.io.PrintWriter r0 = new java.io.PrintWriter     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.io.OutputStream r3 = r2.getOutputStream()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r0.<init>(r3)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r0.print(r7)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r0.close()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.io.InputStream r0 = r2.getInputStream()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r7.<init>(r0)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r3.<init>(r7, r4)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r0.<init>(r3)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r3.<init>()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
            L_0x009c:
                java.lang.String r4 = r0.readLine()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                if (r4 == 0) goto L_0x00b0
                r3.append(r4)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.lang.String r4 = "\n"
                r3.append(r4)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                goto L_0x009c
            L_0x00ab:
                r7 = move-exception
                r0 = r2
                goto L_0x00dd
            L_0x00ae:
                r0 = r2
                goto L_0x00d5
            L_0x00b0:
                r7.close()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.lang.String r7 = r3.toString()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r0 = 0
                r6.f12832a = r0     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.lang.String r3 = "not_found\n"
                boolean r3 = r7.equalsIgnoreCase(r3)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                if (r3 == 0) goto L_0x00c5
                r6.f12833b = r1     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                goto L_0x00cf
            L_0x00c5:
                r6.f12833b = r0     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.lang.String r0 = "moderator\n"
                boolean r7 = r7.equalsIgnoreCase(r0)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r6.f12834c = r7     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
            L_0x00cf:
                r2.disconnect()
                goto L_0x00e5
            L_0x00d3:
                r7 = move-exception
                goto L_0x00dd
            L_0x00d5:
                r6.f12832a = r1     // Catch:{ all -> 0x00d3 }
                if (r0 == 0) goto L_0x00e5
                r0.disconnect()
                goto L_0x00e5
            L_0x00dd:
                if (r0 == 0) goto L_0x00e2
                r0.disconnect()
            L_0x00e2:
                throw r7
            L_0x00e3:
                r6.f12832a = r1
            L_0x00e5:
                java.lang.String r7 = "COMPLETE!"
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.FragmentChatMenu.f.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            if (this.f12832a) {
                C0891s activity = FragmentChatMenu.this.getActivity();
                if (activity != null) {
                    Toast makeText = Toast.makeText(activity, FragmentChatMenu.this.getString(C2030R.string.manual_error), 0);
                    makeText.setGravity(17, 0, 0);
                    makeText.show();
                }
            } else if (this.f12833b) {
                C0891s activity2 = FragmentChatMenu.this.getActivity();
                if (activity2 != null) {
                    Toast makeText2 = Toast.makeText(activity2, FragmentChatMenu.this.getString(C2030R.string.manual_error), 0);
                    makeText2.setGravity(17, 0, 0);
                    makeText2.show();
                }
            } else if (this.f12834c) {
                Intent intent = new Intent(FragmentChatMenu.this.getActivity(), ChatActivity.class);
                intent.putExtra("com.finazzi.distquake.chat_room", "_mod_gen");
                FragmentChatMenu.this.startActivity(intent);
            } else {
                C0891s activity3 = FragmentChatMenu.this.getActivity();
                if (activity3 != null) {
                    Toast makeText3 = Toast.makeText(activity3, FragmentChatMenu.this.getString(C2030R.string.chat_menu_moderators_only), 0);
                    makeText3.setGravity(17, 0, 0);
                    makeText3.show();
                }
            }
        }

        private f(String str, String str2) {
            this.f12835d = str;
            this.f12836e = str2;
        }
    }

    public class g extends BroadcastReceiver {
        public g() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null && action.equals("com.finazzi.distquake.update_private_chat") && !FragmentChatMenu.this.f12812s0 && FragmentChatMenu.this.g1()) {
                FragmentChatMenu.this.k1();
            }
        }
    }

    public static /* synthetic */ void A0(FragmentChatMenu fragmentChatMenu, Activity activity, View view) {
        FirebaseAuth firebaseAuth = fragmentChatMenu.f12814u0;
        if (firebaseAuth != null) {
            Class<ChatActivity> cls = ChatActivity.class;
            if (firebaseAuth.f() == null) {
                Intent intent = new Intent(fragmentChatMenu.getActivity(), cls);
                intent.putExtra("com.finazzi.distquake.chat_room", "_in_gen");
                fragmentChatMenu.startActivity(intent);
            } else if (fragmentChatMenu.g1()) {
                Intent intent2 = new Intent(fragmentChatMenu.getActivity(), cls);
                intent2.putExtra("com.finazzi.distquake.chat_room", "_in_gen");
                fragmentChatMenu.startActivity(intent2);
            } else if (fragmentChatMenu.f1()) {
                fragmentChatMenu.i1();
            } else {
                Toast makeText = Toast.makeText(activity.getApplicationContext(), fragmentChatMenu.getString(C2030R.string.main_nointernet), 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
        }
    }

    public static /* synthetic */ void B0(FragmentChatMenu fragmentChatMenu, Activity activity, View view) {
        if (fragmentChatMenu.f1()) {
            FirebaseAuth firebaseAuth = fragmentChatMenu.f12814u0;
            if (firebaseAuth == null) {
                fragmentChatMenu.i1();
            } else if (firebaseAuth.f() == null || !fragmentChatMenu.g1()) {
                fragmentChatMenu.i1();
            } else {
                v2.d.k().q(fragmentChatMenu.getActivity()).addOnCompleteListener(new C1764c0(fragmentChatMenu, activity));
            }
        } else {
            Toast makeText = Toast.makeText(activity.getApplicationContext(), fragmentChatMenu.getString(C2030R.string.main_nointernet), 0);
            makeText.setGravity(17, 0, 0);
            makeText.show();
        }
    }

    public static /* synthetic */ void C0(FragmentChatMenu fragmentChatMenu, View view) {
        C1155z f8;
        FirebaseAuth firebaseAuth = fragmentChatMenu.f12814u0;
        if (firebaseAuth != null && (f8 = firebaseAuth.f()) != null) {
            new f(fragmentChatMenu, fragmentChatMenu.f12807n0.getString("android_id_eqn", "0"), f8.f1(), (a) null).execute(new Context[0]);
        }
    }

    public static /* synthetic */ void D0(FragmentChatMenu fragmentChatMenu, Activity activity, View view) {
        FirebaseAuth firebaseAuth = fragmentChatMenu.f12814u0;
        if (firebaseAuth != null) {
            Class<ChatActivity> cls = ChatActivity.class;
            if (firebaseAuth.f() == null) {
                Intent intent = new Intent(fragmentChatMenu.getActivity(), cls);
                intent.putExtra("com.finazzi.distquake.chat_room", "_my_gen");
                fragmentChatMenu.startActivity(intent);
            } else if (fragmentChatMenu.g1()) {
                Intent intent2 = new Intent(fragmentChatMenu.getActivity(), cls);
                intent2.putExtra("com.finazzi.distquake.chat_room", "_my_gen");
                fragmentChatMenu.startActivity(intent2);
            } else if (fragmentChatMenu.f1()) {
                fragmentChatMenu.i1();
            } else {
                Toast makeText = Toast.makeText(activity.getApplicationContext(), fragmentChatMenu.getString(C2030R.string.main_nointernet), 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
        }
    }

    public static /* synthetic */ void E0(FragmentChatMenu fragmentChatMenu, Activity activity, View view) {
        if (fragmentChatMenu.g1()) {
            fragmentChatMenu.startActivity(new Intent(fragmentChatMenu.getActivity(), ChatPreviewActivity.class));
        } else if (fragmentChatMenu.f1()) {
            fragmentChatMenu.i1();
        } else {
            Toast makeText = Toast.makeText(activity.getApplicationContext(), fragmentChatMenu.getString(C2030R.string.main_nointernet), 0);
            makeText.setGravity(17, 0, 0);
            makeText.show();
        }
    }

    public static /* synthetic */ void F0(FragmentChatMenu fragmentChatMenu, Activity activity, View view) {
        FirebaseAuth firebaseAuth = fragmentChatMenu.f12814u0;
        if (firebaseAuth != null) {
            Class<ChatActivity> cls = ChatActivity.class;
            if (firebaseAuth.f() == null) {
                Intent intent = new Intent(fragmentChatMenu.getActivity(), cls);
                intent.putExtra("com.finazzi.distquake.chat_room", "_tr_gen");
                fragmentChatMenu.startActivity(intent);
            } else if (fragmentChatMenu.g1()) {
                Intent intent2 = new Intent(fragmentChatMenu.getActivity(), cls);
                intent2.putExtra("com.finazzi.distquake.chat_room", "_tr_gen");
                fragmentChatMenu.startActivity(intent2);
            } else if (fragmentChatMenu.f1()) {
                fragmentChatMenu.i1();
            } else {
                Toast makeText = Toast.makeText(activity.getApplicationContext(), fragmentChatMenu.getString(C2030R.string.main_nointernet), 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
        }
    }

    public static /* synthetic */ void G0(FragmentChatMenu fragmentChatMenu, Activity activity, View view) {
        FirebaseAuth firebaseAuth = fragmentChatMenu.f12814u0;
        if (firebaseAuth != null) {
            Class<ChatActivity> cls = ChatActivity.class;
            if (firebaseAuth.f() == null) {
                Intent intent = new Intent(fragmentChatMenu.getActivity(), cls);
                intent.putExtra("com.finazzi.distquake.chat_room", "_tag_gen");
                fragmentChatMenu.startActivity(intent);
            } else if (fragmentChatMenu.g1()) {
                Intent intent2 = new Intent(fragmentChatMenu.getActivity(), cls);
                intent2.putExtra("com.finazzi.distquake.chat_room", "_tag_gen");
                fragmentChatMenu.startActivity(intent2);
            } else if (fragmentChatMenu.f1()) {
                fragmentChatMenu.i1();
            } else {
                Toast makeText = Toast.makeText(activity.getApplicationContext(), fragmentChatMenu.getString(C2030R.string.main_nointernet), 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
        }
    }

    public static /* synthetic */ void H0(FragmentChatMenu fragmentChatMenu, Activity activity, Task task) {
        SharedPreferences.Editor edit = fragmentChatMenu.f12807n0.edit();
        edit.remove("token");
        edit.remove("nick");
        edit.remove("uID");
        edit.remove("nicklinked");
        edit.remove("chat_user_code");
        edit.apply();
        Button button = (Button) fragmentChatMenu.f12809p0.findViewById(C2030R.id.button1);
        button.setText(fragmentChatMenu.getString(C2030R.string.connect_to_chat));
        button.setVisibility(0);
        ((TextView) fragmentChatMenu.f12809p0.findViewById(C2030R.id.textView1)).setText(fragmentChatMenu.getString(C2030R.string.chat_menu_personal));
        Toast makeText = Toast.makeText(activity, fragmentChatMenu.getString(C2030R.string.profile_signedout), 1);
        makeText.setGravity(17, 0, 0);
        makeText.show();
        ((ImageView) fragmentChatMenu.f12809p0.findViewById(C2030R.id.imageView1)).setImageResource(C2030R.drawable.account);
    }

    public static /* synthetic */ void I0(FragmentChatMenu fragmentChatMenu, Activity activity, View view) {
        FirebaseAuth firebaseAuth = fragmentChatMenu.f12814u0;
        if (firebaseAuth != null) {
            Class<ChatActivity> cls = ChatActivity.class;
            if (firebaseAuth.f() == null) {
                Intent intent = new Intent(fragmentChatMenu.getActivity(), cls);
                intent.putExtra("com.finazzi.distquake.chat_room", "_ro_gen");
                fragmentChatMenu.startActivity(intent);
            } else if (fragmentChatMenu.g1()) {
                Intent intent2 = new Intent(fragmentChatMenu.getActivity(), cls);
                intent2.putExtra("com.finazzi.distquake.chat_room", "_ro_gen");
                fragmentChatMenu.startActivity(intent2);
            } else if (fragmentChatMenu.f1()) {
                fragmentChatMenu.i1();
            } else {
                Toast makeText = Toast.makeText(activity.getApplicationContext(), fragmentChatMenu.getString(C2030R.string.main_nointernet), 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
        }
    }

    public static /* synthetic */ void J0(FragmentChatMenu fragmentChatMenu, Activity activity, View view) {
        FirebaseAuth firebaseAuth = fragmentChatMenu.f12814u0;
        if (firebaseAuth != null) {
            Class<ChatActivity> cls = ChatActivity.class;
            if (firebaseAuth.f() == null) {
                Intent intent = new Intent(fragmentChatMenu.getActivity(), cls);
                intent.putExtra("com.finazzi.distquake.chat_room", "_ar_gen");
                fragmentChatMenu.startActivity(intent);
            } else if (fragmentChatMenu.g1()) {
                Intent intent2 = new Intent(fragmentChatMenu.getActivity(), cls);
                intent2.putExtra("com.finazzi.distquake.chat_room", "_ar_gen");
                fragmentChatMenu.startActivity(intent2);
            } else if (fragmentChatMenu.f1()) {
                fragmentChatMenu.i1();
            } else {
                Toast makeText = Toast.makeText(activity.getApplicationContext(), fragmentChatMenu.getString(C2030R.string.main_nointernet), 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
        }
    }

    public static /* synthetic */ void K0(FragmentChatMenu fragmentChatMenu, Activity activity, View view) {
        FirebaseAuth firebaseAuth = fragmentChatMenu.f12814u0;
        if (firebaseAuth != null) {
            Class<ChatActivity> cls = ChatActivity.class;
            if (firebaseAuth.f() == null) {
                Intent intent = new Intent(fragmentChatMenu.getActivity(), cls);
                intent.putExtra("com.finazzi.distquake.chat_room", "_fr_gen");
                fragmentChatMenu.startActivity(intent);
            } else if (fragmentChatMenu.g1()) {
                Intent intent2 = new Intent(fragmentChatMenu.getActivity(), cls);
                intent2.putExtra("com.finazzi.distquake.chat_room", "_fr_gen");
                fragmentChatMenu.startActivity(intent2);
            } else if (fragmentChatMenu.f1()) {
                fragmentChatMenu.i1();
            } else {
                Toast makeText = Toast.makeText(activity.getApplicationContext(), fragmentChatMenu.getString(C2030R.string.main_nointernet), 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
        }
    }

    public static /* synthetic */ void L0(FragmentChatMenu fragmentChatMenu, Activity activity, View view) {
        FirebaseAuth firebaseAuth = fragmentChatMenu.f12814u0;
        if (firebaseAuth != null) {
            Class<ChatActivity> cls = ChatActivity.class;
            if (firebaseAuth.f() == null) {
                Intent intent = new Intent(fragmentChatMenu.getActivity(), cls);
                intent.putExtra("com.finazzi.distquake.chat_room", "_pt_gen");
                fragmentChatMenu.startActivity(intent);
            } else if (fragmentChatMenu.g1()) {
                Intent intent2 = new Intent(fragmentChatMenu.getActivity(), cls);
                intent2.putExtra("com.finazzi.distquake.chat_room", "_pt_gen");
                fragmentChatMenu.startActivity(intent2);
            } else if (fragmentChatMenu.f1()) {
                fragmentChatMenu.i1();
            } else {
                Toast makeText = Toast.makeText(activity.getApplicationContext(), fragmentChatMenu.getString(C2030R.string.main_nointernet), 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
        }
    }

    public static /* synthetic */ void M0(FragmentChatMenu fragmentChatMenu, Activity activity, View view) {
        FirebaseAuth firebaseAuth = fragmentChatMenu.f12814u0;
        if (firebaseAuth != null) {
            Class<ChatActivity> cls = ChatActivity.class;
            if (firebaseAuth.f() == null) {
                Intent intent = new Intent(fragmentChatMenu.getActivity(), cls);
                intent.putExtra("com.finazzi.distquake.chat_room", "_es_gen");
                fragmentChatMenu.startActivity(intent);
            } else if (fragmentChatMenu.g1()) {
                Intent intent2 = new Intent(fragmentChatMenu.getActivity(), cls);
                intent2.putExtra("com.finazzi.distquake.chat_room", "_es_gen");
                fragmentChatMenu.startActivity(intent2);
            } else if (fragmentChatMenu.f1()) {
                fragmentChatMenu.i1();
            } else {
                Toast makeText = Toast.makeText(activity.getApplicationContext(), fragmentChatMenu.getString(C2030R.string.main_nointernet), 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
        }
    }

    public static /* synthetic */ void N0(FragmentChatMenu fragmentChatMenu, Activity activity, View view) {
        FirebaseAuth firebaseAuth = fragmentChatMenu.f12814u0;
        if (firebaseAuth != null) {
            Class<ChatActivity> cls = ChatActivity.class;
            if (firebaseAuth.f() == null) {
                Intent intent = new Intent(fragmentChatMenu.getActivity(), cls);
                intent.putExtra("com.finazzi.distquake.chat_room", "_eng_gen");
                fragmentChatMenu.startActivity(intent);
            } else if (fragmentChatMenu.g1()) {
                Intent intent2 = new Intent(fragmentChatMenu.getActivity(), cls);
                intent2.putExtra("com.finazzi.distquake.chat_room", "_eng_gen");
                fragmentChatMenu.startActivity(intent2);
            } else if (fragmentChatMenu.f1()) {
                fragmentChatMenu.i1();
            } else {
                Toast makeText = Toast.makeText(activity.getApplicationContext(), fragmentChatMenu.getString(C2030R.string.main_nointernet), 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
        }
    }

    public static /* synthetic */ void O0(FragmentChatMenu fragmentChatMenu, Activity activity, View view) {
        FirebaseAuth firebaseAuth = fragmentChatMenu.f12814u0;
        if (firebaseAuth != null) {
            Class<ChatActivity> cls = ChatActivity.class;
            if (firebaseAuth.f() == null) {
                Intent intent = new Intent(fragmentChatMenu.getActivity(), cls);
                intent.putExtra("com.finazzi.distquake.chat_room", "_hu_gen");
                fragmentChatMenu.startActivity(intent);
            } else if (fragmentChatMenu.g1()) {
                Intent intent2 = new Intent(fragmentChatMenu.getActivity(), cls);
                intent2.putExtra("com.finazzi.distquake.chat_room", "_hu_gen");
                fragmentChatMenu.startActivity(intent2);
            } else if (fragmentChatMenu.f1()) {
                fragmentChatMenu.i1();
            } else {
                Toast makeText = Toast.makeText(activity.getApplicationContext(), fragmentChatMenu.getString(C2030R.string.main_nointernet), 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
        }
    }

    /* access modifiers changed from: private */
    public void b1() {
        int i8;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        String str10;
        String str11;
        String str12;
        String str13;
        String str14;
        String str15;
        String str16;
        String str17;
        if (getActivity() != null) {
            int i9 = this.f12807n0.getInt("online_chat_ita", 0);
            int i10 = this.f12807n0.getInt("online_chat_es", 0);
            int i11 = this.f12807n0.getInt("online_chat_eng", 0);
            int i12 = this.f12807n0.getInt("online_chat_fr", 0);
            int i13 = this.f12807n0.getInt("online_chat_el", 0);
            int i14 = this.f12807n0.getInt("online_chat_tr", 0);
            int i15 = this.f12807n0.getInt("online_chat_in", 0);
            int i16 = this.f12807n0.getInt("online_chat_tag", 0);
            int i17 = this.f12807n0.getInt("online_chat_jp", 0);
            int i18 = this.f12807n0.getInt("online_chat_pt", 0);
            int i19 = this.f12807n0.getInt("online_chat_blk", 0);
            int i20 = this.f12807n0.getInt("online_chat_hu", 0);
            int i21 = this.f12807n0.getInt("online_chat_ar", 0);
            int i22 = this.f12807n0.getInt("online_chat_ro", 0);
            int i23 = this.f12807n0.getInt("online_chat_th", 0);
            int i24 = this.f12807n0.getInt("online_chat_my", 0);
            int i25 = this.f12807n0.getInt("online_chat_mod", 0);
            if (i9 < 1000) {
                i8 = i20;
                str2 = String.format(getString(C2030R.string.chat_menu_ita_gen_code_num), new Object[]{Integer.toString(i9)});
                str = "K";
            } else {
                i8 = i20;
                long round = Math.round(Math.floor(((double) i9) / 1000.0d));
                String string = getString(C2030R.string.chat_menu_ita_gen_code_num);
                StringBuilder sb = new StringBuilder();
                sb.append(">");
                sb.append(Long.toString(round));
                str = "K";
                sb.append(str);
                str2 = String.format(string, new Object[]{sb.toString()});
            }
            TextView textView = (TextView) this.f12809p0.findViewById(C2030R.id.textView3);
            textView.setText(str2);
            if (getString(C2030R.string.current_language).equals("ar")) {
                textView.setTextDirection(4);
            }
            if (i10 < 1000) {
                str3 = String.format(getString(C2030R.string.chat_menu_es_gen_code_num), new Object[]{Integer.toString(i10)});
            } else {
                long round2 = Math.round(Math.floor(((double) i10) / 1000.0d));
                long j8 = round2;
                str3 = String.format(getString(C2030R.string.chat_menu_es_gen_code_num), new Object[]{">" + Long.toString(j8) + str});
            }
            TextView textView2 = (TextView) this.f12809p0.findViewById(C2030R.id.textView4);
            textView2.setText(str3);
            if (getString(C2030R.string.current_language).equals("ar")) {
                textView2.setTextDirection(4);
            }
            if (i11 < 1000) {
                str4 = String.format(getString(C2030R.string.chat_menu_eng_gen_code_num), new Object[]{Integer.toString(i11)});
            } else {
                long round3 = Math.round(Math.floor(((double) i11) / 1000.0d));
                str4 = String.format(getString(C2030R.string.chat_menu_eng_gen_code_num), new Object[]{">" + Long.toString(round3) + str});
            }
            TextView textView3 = (TextView) this.f12809p0.findViewById(C2030R.id.textView5);
            textView3.setText(str4);
            if (getString(C2030R.string.current_language).equals("ar")) {
                textView3.setTextDirection(4);
            }
            if (i12 < 1000) {
                str5 = String.format(getString(C2030R.string.chat_menu_fr_gen_code_num), new Object[]{Integer.toString(i12)});
            } else {
                long round4 = Math.round(Math.floor(((double) i12) / 1000.0d));
                str5 = String.format(getString(C2030R.string.chat_menu_fr_gen_code_num), new Object[]{">" + Long.toString(round4) + str});
            }
            TextView textView4 = (TextView) this.f12809p0.findViewById(C2030R.id.textView6);
            textView4.setText(str5);
            if (getString(C2030R.string.current_language).equals("ar")) {
                textView4.setTextDirection(4);
            }
            if (i13 < 1000) {
                str6 = String.format(getString(C2030R.string.chat_menu_el_gen_code_num), new Object[]{Integer.toString(i13)});
            } else {
                long round5 = Math.round(Math.floor(((double) i13) / 1000.0d));
                str6 = String.format(getString(C2030R.string.chat_menu_el_gen_code_num), new Object[]{">" + Long.toString(round5) + str});
            }
            TextView textView5 = (TextView) this.f12809p0.findViewById(C2030R.id.textView7);
            textView5.setText(str6);
            if (getString(C2030R.string.current_language).equals("ar")) {
                textView5.setTextDirection(4);
            }
            if (i14 < 1000) {
                str7 = String.format(getString(C2030R.string.chat_menu_tr_gen_code_num), new Object[]{Integer.toString(i14)});
            } else {
                long round6 = Math.round(Math.floor(((double) i14) / 1000.0d));
                str7 = String.format(getString(C2030R.string.chat_menu_tr_gen_code_num), new Object[]{">" + Long.toString(round6) + str});
            }
            TextView textView6 = (TextView) this.f12809p0.findViewById(C2030R.id.textView8);
            textView6.setText(str7);
            if (getString(C2030R.string.current_language).equals("ar")) {
                textView6.setTextDirection(4);
            }
            if (i15 < 1000) {
                str8 = String.format(getString(C2030R.string.chat_menu_in_gen_code_num), new Object[]{Integer.toString(i15)});
            } else {
                long round7 = Math.round(Math.floor(((double) i15) / 1000.0d));
                str8 = String.format(getString(C2030R.string.chat_menu_in_gen_code_num), new Object[]{">" + Long.toString(round7) + str});
            }
            TextView textView7 = (TextView) this.f12809p0.findViewById(C2030R.id.textView9);
            textView7.setText(str8);
            if (getString(C2030R.string.current_language).equals("ar")) {
                textView7.setTextDirection(4);
            }
            if (i16 < 1000) {
                str9 = String.format(getString(C2030R.string.chat_menu_tag_gen_code_num), new Object[]{Integer.toString(i16)});
            } else {
                long round8 = Math.round(Math.floor(((double) i16) / 1000.0d));
                str9 = String.format(getString(C2030R.string.chat_menu_tag_gen_code_num), new Object[]{">" + Long.toString(round8) + str});
            }
            TextView textView8 = (TextView) this.f12809p0.findViewById(C2030R.id.textView10);
            textView8.setText(str9);
            if (getString(C2030R.string.current_language).equals("ar")) {
                textView8.setTextDirection(4);
            }
            if (i17 < 1000) {
                str10 = String.format(getString(C2030R.string.chat_menu_jp_gen_code_num), new Object[]{Integer.toString(i17)});
            } else {
                long round9 = Math.round(Math.floor(((double) i17) / 1000.0d));
                str10 = String.format(getString(C2030R.string.chat_menu_jp_gen_code_num), new Object[]{">" + Long.toString(round9) + str});
            }
            TextView textView9 = (TextView) this.f12809p0.findViewById(C2030R.id.textView11);
            textView9.setText(str10);
            if (getString(C2030R.string.current_language).equals("ar")) {
                textView9.setTextDirection(4);
            }
            if (i18 < 1000) {
                str11 = String.format(getString(C2030R.string.chat_menu_pt_gen_code_num), new Object[]{Integer.toString(i18)});
            } else {
                long round10 = Math.round(Math.floor(((double) i18) / 1000.0d));
                str11 = String.format(getString(C2030R.string.chat_menu_pt_gen_code_num), new Object[]{">" + Long.toString(round10) + str});
            }
            TextView textView10 = (TextView) this.f12809p0.findViewById(C2030R.id.textView12);
            textView10.setText(str11);
            if (getString(C2030R.string.current_language).equals("ar")) {
                textView10.setTextDirection(4);
            }
            if (i19 < 1000) {
                str12 = String.format(getString(C2030R.string.chat_menu_blk_gen_code_num), new Object[]{Integer.toString(i19)});
            } else {
                long round11 = Math.round(Math.floor(((double) i19) / 1000.0d));
                str12 = String.format(getString(C2030R.string.chat_menu_blk_gen_code_num), new Object[]{">" + Long.toString(round11) + str});
            }
            TextView textView11 = (TextView) this.f12809p0.findViewById(C2030R.id.textView14);
            textView11.setText(str12);
            if (getString(C2030R.string.current_language).equals("ar")) {
                textView11.setTextDirection(4);
            }
            int i26 = i8;
            if (i26 < 1000) {
                str13 = String.format(getString(C2030R.string.chat_menu_hu_gen_code_num), new Object[]{Integer.toString(i26)});
            } else {
                long round12 = Math.round(Math.floor(((double) i26) / 1000.0d));
                str13 = String.format(getString(C2030R.string.chat_menu_hu_gen_code_num), new Object[]{">" + Long.toString(round12) + str});
            }
            TextView textView12 = (TextView) this.f12809p0.findViewById(C2030R.id.textView15);
            textView12.setText(str13);
            if (getString(C2030R.string.current_language).equals("ar")) {
                textView12.setTextDirection(4);
            }
            int i27 = i22;
            if (i27 < 1000) {
                str14 = String.format(getString(C2030R.string.chat_menu_ro_gen_code_num), new Object[]{Integer.toString(i27)});
            } else {
                long round13 = Math.round(Math.floor(((double) i27) / 1000.0d));
                str14 = String.format(getString(C2030R.string.chat_menu_ro_gen_code_num), new Object[]{">" + Long.toString(round13) + str});
            }
            TextView textView13 = (TextView) this.f12809p0.findViewById(C2030R.id.textView17);
            textView13.setText(str14);
            if (getString(C2030R.string.current_language).equals("ar")) {
                textView13.setTextDirection(4);
            }
            int i28 = i21;
            if (i28 < 1000) {
                str15 = String.format(getString(C2030R.string.chat_menu_ar_gen_code_num), new Object[]{Integer.toString(i28)});
            } else {
                long round14 = Math.round(Math.floor(((double) i28) / 1000.0d));
                str15 = String.format(getString(C2030R.string.chat_menu_ar_gen_code_num), new Object[]{">" + Long.toString(round14) + str});
            }
            TextView textView14 = (TextView) this.f12809p0.findViewById(C2030R.id.textView18);
            textView14.setText(str15);
            if (getString(C2030R.string.current_language).equals("ar")) {
                textView14.setTextDirection(4);
            }
            int i29 = i23;
            if (i29 < 1000) {
                str16 = String.format(getString(C2030R.string.chat_menu_th_gen_code_num), new Object[]{Integer.toString(i29)});
            } else {
                long round15 = Math.round(Math.floor(((double) i29) / 1000.0d));
                str16 = String.format(getString(C2030R.string.chat_menu_th_gen_code_num), new Object[]{">" + Long.toString(round15) + str});
            }
            TextView textView15 = (TextView) this.f12809p0.findViewById(C2030R.id.textView19);
            textView15.setText(str16);
            if (getString(C2030R.string.current_language).equals("ar")) {
                textView15.setTextDirection(4);
            }
            int i30 = i24;
            if (i30 < 1000) {
                str17 = String.format(getString(C2030R.string.chat_menu_my_gen_code_num), new Object[]{Integer.toString(i30)});
            } else {
                long round16 = Math.round(Math.floor(((double) i30) / 1000.0d));
                str17 = String.format(getString(C2030R.string.chat_menu_my_gen_code_num), new Object[]{">" + Long.toString(round16) + str});
            }
            TextView textView16 = (TextView) this.f12809p0.findViewById(C2030R.id.textView20);
            textView16.setText(str17);
            if (getString(C2030R.string.current_language).equals("ar")) {
                textView16.setTextDirection(4);
            }
            TextView textView17 = (TextView) this.f12809p0.findViewById(C2030R.id.textView13);
            textView17.setText(getString(C2030R.string.chat_menu_mod_gen) + " (" + i25 + ")");
            if (getString(C2030R.string.current_language).equals("ar")) {
                textView17.setTextDirection(4);
            }
        }
    }

    private void c1() {
        new b(this, (a) null).execute(new Context[]{getActivity()});
    }

    private List d1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(Scopes.EMAIL);
        arrayList.add("public_profile");
        return arrayList;
    }

    /* access modifiers changed from: private */
    public String e1() {
        if (this.f12814u0.f() == null || getActivity() == null || !this.f12807n0.getBoolean("nicklinked", false)) {
            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
        }
        return this.f12807n0.getString("nick", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
    }

    private boolean f1() {
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

    /* access modifiers changed from: private */
    public boolean g1() {
        FirebaseAuth firebaseAuth = this.f12814u0;
        if (firebaseAuth == null || firebaseAuth.f() == null || getActivity() == null || !this.f12807n0.getBoolean("nicklinked", false) || this.f12807n0.getString("nick", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equalsIgnoreCase(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED)) {
            return false;
        }
        return true;
    }

    private void h1() {
        C1155z f8 = this.f12814u0.f();
        if (f8 != null && getActivity() != null) {
            new d(this, this.f12807n0.getString("android_id_eqn", "0"), f8.f1(), (a) null).execute(new Context[0]);
        }
    }

    private void i1() {
        FirebaseAuth firebaseAuth = this.f12814u0;
        if (firebaseAuth == null) {
            return;
        }
        if (firebaseAuth.f() == null) {
            this.f12815v0.a(((d.C0365d) ((d.C0365d) v2.d.k().d().d(2131230872)).c(Arrays.asList(new d.c[]{new d.c.f().b(), new d.c.C0364d().d(d1()).b()}))).a());
        } else if (getActivity() != null && !this.f12807n0.getBoolean("nicklinked", false)) {
            h1();
        }
    }

    private void j1() {
        this.f12811r0.post(new C1758b0(this));
    }

    /* access modifiers changed from: private */
    public void k1() {
        C0891s activity = getActivity();
        if (activity != null) {
            new e(this, (a) null).execute(new Context[]{activity});
        }
    }

    public static /* synthetic */ void s0(FragmentChatMenu fragmentChatMenu, Activity activity, View view) {
        FirebaseAuth firebaseAuth = fragmentChatMenu.f12814u0;
        if (firebaseAuth != null) {
            Class<ChatActivity> cls = ChatActivity.class;
            if (firebaseAuth.f() == null) {
                Intent intent = new Intent(fragmentChatMenu.getActivity(), cls);
                intent.putExtra("com.finazzi.distquake.chat_room", "_ita_gen");
                fragmentChatMenu.startActivity(intent);
            } else if (fragmentChatMenu.g1()) {
                Intent intent2 = new Intent(fragmentChatMenu.getActivity(), cls);
                intent2.putExtra("com.finazzi.distquake.chat_room", "_ita_gen");
                fragmentChatMenu.startActivity(intent2);
            } else if (fragmentChatMenu.f1()) {
                fragmentChatMenu.i1();
            } else {
                Toast makeText = Toast.makeText(activity.getApplicationContext(), fragmentChatMenu.getString(C2030R.string.main_nointernet), 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
        }
    }

    public static /* synthetic */ void t0(FragmentChatMenu fragmentChatMenu, Activity activity, View view) {
        FirebaseAuth firebaseAuth = fragmentChatMenu.f12814u0;
        if (firebaseAuth != null) {
            Class<ChatActivity> cls = ChatActivity.class;
            if (firebaseAuth.f() == null) {
                Intent intent = new Intent(fragmentChatMenu.getActivity(), cls);
                intent.putExtra("com.finazzi.distquake.chat_room", "_jp_gen");
                fragmentChatMenu.startActivity(intent);
            } else if (fragmentChatMenu.g1()) {
                Intent intent2 = new Intent(fragmentChatMenu.getActivity(), cls);
                intent2.putExtra("com.finazzi.distquake.chat_room", "_jp_gen");
                fragmentChatMenu.startActivity(intent2);
            } else if (fragmentChatMenu.f1()) {
                fragmentChatMenu.i1();
            } else {
                Toast makeText = Toast.makeText(activity.getApplicationContext(), fragmentChatMenu.getString(C2030R.string.main_nointernet), 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
        }
    }

    public static /* synthetic */ void v0(Activity activity, Task task) {
        SharedPreferences.Editor edit = activity.getSharedPreferences(MainActivity.class.getSimpleName(), 0).edit();
        edit.remove("token");
        edit.remove("nick");
        edit.remove("uID");
        edit.remove("nicklinked");
        edit.remove("chat_user_code");
        edit.apply();
    }

    public static /* synthetic */ void w0(FragmentChatMenu fragmentChatMenu, Activity activity, C1313a aVar) {
        h j8;
        fragmentChatMenu.getClass();
        j g8 = j.g(aVar.a());
        if (aVar.b() == -1) {
            if (g8 != null && activity != null) {
                C1155z f8 = fragmentChatMenu.f12814u0.f();
                SharedPreferences.Editor edit = fragmentChatMenu.f12807n0.edit();
                edit.putString("token", g8.m());
                edit.apply();
                Button button = (Button) fragmentChatMenu.f12809p0.findViewById(C2030R.id.button1);
                button.setText(fragmentChatMenu.getString(C2030R.string.profile_disconnect));
                button.setVisibility(8);
                fragmentChatMenu.i1();
                if (f8 != null) {
                    Uri photoUrl = f8.getPhotoUrl();
                    if (photoUrl == null) {
                        ((ImageView) fragmentChatMenu.f12809p0.findViewById(C2030R.id.imageView1)).setImageResource(C2030R.drawable.account);
                    } else if (!photoUrl.toString().equalsIgnoreCase(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED)) {
                        com.bumptech.glide.b.v(fragmentChatMenu.getActivity()).r(photoUrl.toString()).v0((ImageView) fragmentChatMenu.f12809p0.findViewById(C2030R.id.imageView1));
                    } else {
                        ((ImageView) fragmentChatMenu.f12809p0.findViewById(C2030R.id.imageView1)).setImageResource(C2030R.drawable.account);
                    }
                } else {
                    ((ImageView) fragmentChatMenu.f12809p0.findViewById(C2030R.id.imageView1)).setImageResource(C2030R.drawable.account);
                }
            }
        } else if (g8 != null && (j8 = g8.j()) != null) {
            if (j8.a() == 1) {
                Toast makeText = Toast.makeText(fragmentChatMenu.getActivity(), fragmentChatMenu.getString(C2030R.string.main_nointernet), 1);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
            if (j8.a() == 0) {
                Toast makeText2 = Toast.makeText(fragmentChatMenu.getActivity(), fragmentChatMenu.getString(C2030R.string.manual_error), 1);
                makeText2.setGravity(17, 0, 0);
                makeText2.show();
            }
        }
    }

    public static /* synthetic */ void x0(FragmentChatMenu fragmentChatMenu, Activity activity, View view) {
        FirebaseAuth firebaseAuth = fragmentChatMenu.f12814u0;
        if (firebaseAuth != null) {
            Class<ChatActivity> cls = ChatActivity.class;
            if (firebaseAuth.f() == null) {
                Intent intent = new Intent(fragmentChatMenu.getActivity(), cls);
                intent.putExtra("com.finazzi.distquake.chat_room", "_el_gen");
                fragmentChatMenu.startActivity(intent);
            } else if (fragmentChatMenu.g1()) {
                Intent intent2 = new Intent(fragmentChatMenu.getActivity(), cls);
                intent2.putExtra("com.finazzi.distquake.chat_room", "_el_gen");
                fragmentChatMenu.startActivity(intent2);
            } else if (fragmentChatMenu.f1()) {
                fragmentChatMenu.i1();
            } else {
                Toast makeText = Toast.makeText(activity.getApplicationContext(), fragmentChatMenu.getString(C2030R.string.main_nointernet), 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
        }
    }

    public static /* synthetic */ void y0(FragmentChatMenu fragmentChatMenu, Activity activity, View view) {
        FirebaseAuth firebaseAuth = fragmentChatMenu.f12814u0;
        if (firebaseAuth != null) {
            Class<ChatActivity> cls = ChatActivity.class;
            if (firebaseAuth.f() == null) {
                Intent intent = new Intent(fragmentChatMenu.getActivity(), cls);
                intent.putExtra("com.finazzi.distquake.chat_room", "_blk_gen");
                fragmentChatMenu.startActivity(intent);
            } else if (fragmentChatMenu.g1()) {
                Intent intent2 = new Intent(fragmentChatMenu.getActivity(), cls);
                intent2.putExtra("com.finazzi.distquake.chat_room", "_blk_gen");
                fragmentChatMenu.startActivity(intent2);
            } else if (fragmentChatMenu.f1()) {
                fragmentChatMenu.i1();
            } else {
                Toast makeText = Toast.makeText(activity.getApplicationContext(), fragmentChatMenu.getString(C2030R.string.main_nointernet), 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
        }
    }

    public static /* synthetic */ void z0(FragmentChatMenu fragmentChatMenu, Activity activity, View view) {
        FirebaseAuth firebaseAuth = fragmentChatMenu.f12814u0;
        if (firebaseAuth != null) {
            Class<ChatActivity> cls = ChatActivity.class;
            if (firebaseAuth.f() == null) {
                Intent intent = new Intent(fragmentChatMenu.getActivity(), cls);
                intent.putExtra("com.finazzi.distquake.chat_room", "_th_gen");
                fragmentChatMenu.startActivity(intent);
            } else if (fragmentChatMenu.g1()) {
                Intent intent2 = new Intent(fragmentChatMenu.getActivity(), cls);
                intent2.putExtra("com.finazzi.distquake.chat_room", "_th_gen");
                fragmentChatMenu.startActivity(intent2);
            } else if (fragmentChatMenu.f1()) {
                fragmentChatMenu.i1();
            } else {
                Toast makeText = Toast.makeText(activity.getApplicationContext(), fragmentChatMenu.getString(C2030R.string.main_nointernet), 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
        }
    }

    public void onActivityResult(int i8, int i9, Intent intent) {
        if (i8 == 1) {
            if (g1()) {
                String e12 = e1();
                ((TextView) this.f12809p0.findViewById(C2030R.id.textView1)).setText(String.format(getString(C2030R.string.chat_menu_personal_linked), new Object[]{e12}));
                Button button = (Button) this.f12809p0.findViewById(C2030R.id.button1);
                button.setText(getString(C2030R.string.profile_disconnect));
                button.setVisibility(8);
                C1155z f8 = this.f12814u0.f();
                if (f8 != null) {
                    Uri photoUrl = f8.getPhotoUrl();
                    if (photoUrl == null) {
                        ((ImageView) this.f12809p0.findViewById(C2030R.id.imageView1)).setImageResource(C2030R.drawable.account);
                    } else if (!photoUrl.toString().equalsIgnoreCase(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED)) {
                        ImageView imageView = (ImageView) this.f12809p0.findViewById(C2030R.id.imageView1);
                        C0891s activity = getActivity();
                        if (activity != null) {
                            com.bumptech.glide.b.t(activity).r(photoUrl.toString()).v0(imageView);
                        }
                    } else {
                        ((ImageView) this.f12809p0.findViewById(C2030R.id.imageView1)).setImageResource(C2030R.drawable.account);
                    }
                } else {
                    ((ImageView) this.f12809p0.findViewById(C2030R.id.imageView1)).setImageResource(C2030R.drawable.account);
                }
            } else {
                C0891s activity2 = getActivity();
                if (activity2 != null) {
                    v2.d.k().q(activity2).addOnCompleteListener(new C1749Y(activity2));
                }
            }
        }
        if (i8 == 2 && i9 == 1) {
            Button button2 = (Button) this.f12809p0.findViewById(C2030R.id.button1);
            button2.setText(getString(C2030R.string.connect_to_chat));
            button2.setVisibility(0);
            ((TextView) this.f12809p0.findViewById(C2030R.id.textView1)).setText(getString(C2030R.string.chat_menu_personal));
            ((ImageView) this.f12809p0.findViewById(C2030R.id.imageView1)).setImageResource(C2030R.drawable.account);
            this.f12814u0 = null;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        this.f12809p0 = layoutInflater.inflate(C2030R.layout.chat_menu_card, viewGroup, false);
        C0891s activity = getActivity();
        if (activity != null) {
            this.f12807n0 = activity.getSharedPreferences(MainActivity.class.getSimpleName(), 0);
            this.f12808o0 = new C(activity.getApplicationContext());
            ((CardView) this.f12809p0.findViewById(C2030R.id.cardItalian)).setOnClickListener(new C1770d0(this, activity));
            ((CardView) this.f12809p0.findViewById(C2030R.id.cardSpanish)).setOnClickListener(new C1742Q(this, activity));
            ((CardView) this.f12809p0.findViewById(C2030R.id.cardEnglish)).setOnClickListener(new C1743S(this, activity));
            ((CardView) this.f12809p0.findViewById(C2030R.id.cardFrench)).setOnClickListener(new C1744T(this, activity));
            ((CardView) this.f12809p0.findViewById(C2030R.id.cardGreek)).setOnClickListener(new C1745U(this, activity));
            ((CardView) this.f12809p0.findViewById(C2030R.id.cardTurkish)).setOnClickListener(new C1746V(this, activity));
            ((CardView) this.f12809p0.findViewById(C2030R.id.cardIndonesian)).setOnClickListener(new C1747W(this, activity));
            ((CardView) this.f12809p0.findViewById(C2030R.id.cardTagalog)).setOnClickListener(new C1748X(this, activity));
            ((CardView) this.f12809p0.findViewById(C2030R.id.cardJapanese)).setOnClickListener(new C1750Z(this, activity));
            ((CardView) this.f12809p0.findViewById(C2030R.id.cardPortuguese)).setOnClickListener(new C1752a0(this, activity));
            ((CardView) this.f12809p0.findViewById(C2030R.id.cardBalkan)).setOnClickListener(new C1776e0(this, activity));
            ((CardView) this.f12809p0.findViewById(C2030R.id.cardHungarian)).setOnClickListener(new C1782f0(this, activity));
            ((CardView) this.f12809p0.findViewById(C2030R.id.cardRomanian)).setOnClickListener(new C1788g0(this, activity));
            ((CardView) this.f12809p0.findViewById(C2030R.id.cardArabic)).setOnClickListener(new C1794h0(this, activity));
            ((CardView) this.f12809p0.findViewById(C2030R.id.cardThai)).setOnClickListener(new C1800i0(this, activity));
            ((CardView) this.f12809p0.findViewById(C2030R.id.cardBurmese)).setOnClickListener(new C1806j0(this, activity));
            ((TextView) this.f12809p0.findViewById(C2030R.id.textView13)).setOnClickListener(new C1812k0(this));
            ((TextView) this.f12809p0.findViewById(C2030R.id.textView1)).setOnClickListener(new C1739N(this, activity));
            ((Button) this.f12809p0.findViewById(C2030R.id.button1)).setOnClickListener(new C1740O(this, activity));
        }
        this.f12811r0 = (ScrollView) this.f12809p0.findViewById(C2030R.id.scrollView);
        requireActivity().addMenuProvider(new a(), getViewLifecycleOwner(), C0910l.b.RESUMED);
        this.f12815v0 = registerForActivityResult(new C1398c(), new C1741P(this, activity));
        return this.f12809p0;
    }

    public void onPause() {
        g gVar;
        super.onPause();
        this.f12813t0 = false;
        C0891s activity = getActivity();
        if (activity != null && (gVar = this.f12810q0) != null) {
            activity.unregisterReceiver(gVar);
        }
    }

    public void onResume() {
        super.onResume();
        boolean z7 = true;
        this.f12813t0 = true;
        C0891s activity = getActivity();
        if (activity != null) {
            FirebaseAuth instance = FirebaseAuth.getInstance();
            this.f12814u0 = instance;
            if (instance.f() == null) {
                Button button = (Button) this.f12809p0.findViewById(C2030R.id.button1);
                button.setText(getString(C2030R.string.connect_to_chat));
                button.setVisibility(0);
                ((TextView) this.f12809p0.findViewById(C2030R.id.textView1)).setText(getString(C2030R.string.chat_menu_personal));
            } else if (g1()) {
                Button button2 = (Button) this.f12809p0.findViewById(C2030R.id.button1);
                button2.setText(getString(C2030R.string.profile_disconnect));
                button2.setVisibility(8);
                ((TextView) this.f12809p0.findViewById(C2030R.id.textView1)).setText(String.format(getString(C2030R.string.chat_menu_personal_linked), new Object[]{e1()}));
                Uri photoUrl = this.f12814u0.f().getPhotoUrl();
                if (photoUrl == null) {
                    ((ImageView) this.f12809p0.findViewById(C2030R.id.imageView1)).setImageResource(C2030R.drawable.account);
                } else if (!photoUrl.toString().equalsIgnoreCase(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED)) {
                    com.bumptech.glide.b.t(activity).r(photoUrl.toString()).v0((ImageView) this.f12809p0.findViewById(C2030R.id.imageView1));
                } else {
                    ((ImageView) this.f12809p0.findViewById(C2030R.id.imageView1)).setImageResource(C2030R.drawable.account);
                }
            } else {
                ((TextView) this.f12809p0.findViewById(C2030R.id.textView1)).setText(getString(C2030R.string.chat_menu_personal));
                Button button3 = (Button) this.f12809p0.findViewById(C2030R.id.button1);
                button3.setText(getString(C2030R.string.connect_to_chat));
                button3.setVisibility(0);
            }
            j1();
            if (!this.f12812s0 && g1()) {
                k1();
            }
            SharedPreferences.Editor edit = this.f12807n0.edit();
            if (System.currentTimeMillis() - this.f12807n0.getLong("network_count_last_updated", 0) <= DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT) {
                z7 = false;
            }
            if (!f1() || !z7) {
                b1();
            } else {
                c1();
            }
            Class<ChatPreviewActivity> cls = ChatPreviewActivity.class;
            if (this.f12807n0.getBoolean("open_personal_chat", false)) {
                edit.putBoolean("open_personal_chat", false);
                edit.apply();
                if (this.f12814u0.f() != null) {
                    int i8 = this.f12807n0.getInt("personal_chat_user_code", 0);
                    String string = this.f12807n0.getString("personal_chat_nick", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                    if (i8 != 0) {
                        Intent intent = new Intent(getActivity(), cls);
                        intent.putExtra("com.finazzi.distquake.user_code_to_open", i8);
                        intent.putExtra("com.finazzi.distquake.user_nick_to_open", string);
                        startActivity(intent);
                    }
                }
            }
            if (this.f12807n0.getBoolean("open_friendship", false)) {
                edit.putBoolean("open_friendship", false);
                edit.apply();
                startActivity(new Intent(getActivity(), cls));
            }
            this.f12810q0 = new g();
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("com.finazzi.distquake.update_private_chat");
            if (Build.VERSION.SDK_INT >= 33) {
                Intent unused = activity.registerReceiver(this.f12810q0, intentFilter, 4);
            } else {
                activity.registerReceiver(this.f12810q0, intentFilter);
            }
        }
    }

    private class b extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private String f12817a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f12818b;

        private b() {
            this.f12817a = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
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
                com.finazzi.distquake.FragmentChatMenu r0 = com.finazzi.distquake.FragmentChatMenu.this
                boolean r0 = r0.isAdded()
                com.finazzi.distquake.FragmentChatMenu r1 = com.finazzi.distquake.FragmentChatMenu.this
                androidx.fragment.app.s r1 = r1.getActivity()
                r2 = 1
                if (r1 == 0) goto L_0x00bf
                if (r0 == 0) goto L_0x00bf
                r0 = 0
                com.finazzi.distquake.FragmentChatMenu r1 = com.finazzi.distquake.FragmentChatMenu.this     // Catch:{ IOException -> 0x00b1 }
                android.content.SharedPreferences r1 = r1.f12807n0     // Catch:{ IOException -> 0x00b1 }
                java.lang.String r3 = "sub_domain"
                com.finazzi.distquake.FragmentChatMenu r4 = com.finazzi.distquake.FragmentChatMenu.this     // Catch:{ IOException -> 0x00b1 }
                r5 = 2131887099(0x7f1203fb, float:1.9408796E38)
                java.lang.String r4 = r4.getString(r5)     // Catch:{ IOException -> 0x00b1 }
                java.lang.String r1 = r1.getString(r3, r4)     // Catch:{ IOException -> 0x00b1 }
                com.finazzi.distquake.FragmentChatMenu r3 = com.finazzi.distquake.FragmentChatMenu.this     // Catch:{ IOException -> 0x00b1 }
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
                r6.f12817a = r0     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r6.f12818b = r7     // Catch:{ IOException -> 0x009e, all -> 0x009b }
                r1.disconnect()
                goto L_0x00c1
            L_0x00af:
                r7 = move-exception
                goto L_0x00b9
            L_0x00b1:
                r6.f12818b = r2     // Catch:{ all -> 0x00af }
                if (r0 == 0) goto L_0x00c1
                r0.disconnect()
                goto L_0x00c1
            L_0x00b9:
                if (r0 == 0) goto L_0x00be
                r0.disconnect()
            L_0x00be:
                throw r7
            L_0x00bf:
                r6.f12818b = r2
            L_0x00c1:
                java.lang.String r7 = "COMPLETE!"
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.FragmentChatMenu.b.doInBackground(android.content.Context[]):java.lang.String");
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
                boolean r0 = r1.f12818b
                if (r0 != 0) goto L_0x031c
                com.finazzi.distquake.FragmentChatMenu r0 = com.finazzi.distquake.FragmentChatMenu.this
                boolean r0 = r0.f12813t0
                if (r0 == 0) goto L_0x031c
                org.json.JSONArray r0 = new org.json.JSONArray     // Catch:{ JSONException -> 0x030a }
                java.lang.String r3 = r1.f12817a     // Catch:{ JSONException -> 0x030a }
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
                com.finazzi.distquake.FragmentChatMenu r15 = com.finazzi.distquake.FragmentChatMenu.this     // Catch:{ JSONException -> 0x02f9 }
                android.content.SharedPreferences r15 = r15.f12807n0     // Catch:{ JSONException -> 0x02f9 }
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
                com.finazzi.distquake.FragmentChatMenu r0 = com.finazzi.distquake.FragmentChatMenu.this     // Catch:{ JSONException -> 0x02f9 }
                r0.b1()     // Catch:{ JSONException -> 0x02f9 }
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
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.FragmentChatMenu.b.onPostExecute(java.lang.String):void");
        }

        /* synthetic */ b(FragmentChatMenu fragmentChatMenu, a aVar) {
            this();
        }
    }
}
