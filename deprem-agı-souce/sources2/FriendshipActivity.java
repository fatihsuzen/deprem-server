package com.finazzi.distquake;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.format.DateUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.C0765a;
import androidx.appcompat.app.C0768d;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.C0832r0;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.firebase.auth.C1155z;
import com.google.firebase.auth.FirebaseAuth;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class FriendshipActivity extends C0768d {
    /* access modifiers changed from: private */

    /* renamed from: O  reason: collision with root package name */
    public C f13045O;

    /* renamed from: P  reason: collision with root package name */
    private List f13046P;
    /* access modifiers changed from: private */

    /* renamed from: Q  reason: collision with root package name */
    public b f13047Q;

    /* renamed from: R  reason: collision with root package name */
    private SimpleDateFormat f13048R;

    /* renamed from: S  reason: collision with root package name */
    private SimpleDateFormat f13049S;

    /* renamed from: T  reason: collision with root package name */
    private SimpleDateFormat f13050T;

    /* renamed from: U  reason: collision with root package name */
    private Calendar f13051U;
    /* access modifiers changed from: private */

    /* renamed from: V  reason: collision with root package name */
    public boolean f13052V = false;
    /* access modifiers changed from: private */

    /* renamed from: W  reason: collision with root package name */
    public int f13053W = 0;
    /* access modifiers changed from: private */

    /* renamed from: X  reason: collision with root package name */
    public int f13054X = 0;
    /* access modifiers changed from: private */

    /* renamed from: Y  reason: collision with root package name */
    public boolean f13055Y;

    private class b extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        private LayoutInflater f13056a;

        /* renamed from: b  reason: collision with root package name */
        private List f13057b;

        public static /* synthetic */ void a(b bVar, int i8, DialogInterface dialogInterface, int i9) {
            int i10;
            if (FriendshipActivity.this.f13053W == 2 || FriendshipActivity.this.f13053W == 4) {
                i10 = ((d) bVar.f13057b.get(i8)).q();
            } else {
                i10 = ((d) bVar.f13057b.get(i8)).r();
            }
            int p7 = ((d) bVar.f13057b.get(i8)).p();
            FriendshipActivity friendshipActivity = FriendshipActivity.this;
            friendshipActivity.y0(friendshipActivity.f13054X, i10, p7);
        }

        public static /* synthetic */ void b(b bVar, String str, String str2, DialogInterface dialogInterface, int i8) {
            bVar.getClass();
            new e(str, str2).execute(new Context[0]);
        }

        public static /* synthetic */ void c(b bVar, int i8, DialogInterface dialogInterface, int i9) {
            int q7 = ((d) bVar.f13057b.get(i8)).q();
            String o7 = ((d) bVar.f13057b.get(i8)).o();
            String n7 = ((d) bVar.f13057b.get(i8)).n();
            int p7 = ((d) bVar.f13057b.get(i8)).p();
            FriendshipActivity friendshipActivity = FriendshipActivity.this;
            friendshipActivity.e0(friendshipActivity.f13054X, q7, o7, n7, p7);
        }

        public static /* synthetic */ void d(DialogInterface dialogInterface, int i8) {
        }

        public static /* synthetic */ void e(b bVar, int i8, View view) {
            if (FriendshipActivity.this.H0()) {
                String n7 = ((d) bVar.f13057b.get(i8)).n();
                String o7 = ((d) bVar.f13057b.get(i8)).o();
                AlertDialog.Builder builder = new AlertDialog.Builder(FriendshipActivity.this);
                builder.setMessage(String.format(FriendshipActivity.this.getString(C2030R.string.friend_misconduct), new Object[]{o7}));
                builder.setCancelable(true);
                builder.setNegativeButton(FriendshipActivity.this.getString(C2030R.string.manual_yes), new T(bVar, o7, n7));
                builder.setPositiveButton(FriendshipActivity.this.getString(C2030R.string.status_cancel), new U());
                builder.create().show();
                return;
            }
            Toast makeText = Toast.makeText(FriendshipActivity.this.getApplicationContext(), FriendshipActivity.this.getString(C2030R.string.main_nointernet), 0);
            makeText.setGravity(17, 0, 0);
            makeText.show();
        }

        public static /* synthetic */ void f(b bVar, int i8, View view) {
            if (FriendshipActivity.this.H0()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(FriendshipActivity.this);
                int g02 = FriendshipActivity.this.f13053W;
                if (g02 == 1) {
                    builder.setMessage(FriendshipActivity.this.getString(C2030R.string.friend_delete));
                } else if (g02 == 2) {
                    builder.setMessage(FriendshipActivity.this.getString(C2030R.string.friend_deny));
                } else if (g02 == 3) {
                    builder.setMessage(FriendshipActivity.this.getString(C2030R.string.friend_waiting_outbound_remove));
                } else if (g02 == 4) {
                    builder.setMessage(FriendshipActivity.this.getString(C2030R.string.friend_denied_outbound_remove));
                }
                builder.setCancelable(true);
                builder.setNegativeButton(FriendshipActivity.this.getString(C2030R.string.manual_yes), new V(bVar, i8));
                builder.setPositiveButton(FriendshipActivity.this.getString(C2030R.string.status_cancel), new W());
                builder.create().show();
                return;
            }
            Toast makeText = Toast.makeText(FriendshipActivity.this.getApplicationContext(), FriendshipActivity.this.getString(C2030R.string.main_nointernet), 0);
            makeText.setGravity(17, 0, 0);
            makeText.show();
        }

        public static /* synthetic */ void g(DialogInterface dialogInterface, int i8) {
        }

        public static /* synthetic */ void h(b bVar, int i8, View view) {
            if (FriendshipActivity.this.H0()) {
                AlertDialog.Builder builder = new AlertDialog.Builder(FriendshipActivity.this);
                builder.setMessage(FriendshipActivity.this.getString(C2030R.string.friend_accept));
                builder.setCancelable(true);
                builder.setNegativeButton(FriendshipActivity.this.getString(C2030R.string.manual_yes), new Q(bVar, i8));
                builder.setPositiveButton(FriendshipActivity.this.getString(C2030R.string.status_cancel), new S());
                builder.create().show();
                return;
            }
            Toast makeText = Toast.makeText(FriendshipActivity.this.getApplicationContext(), FriendshipActivity.this.getString(C2030R.string.main_nointernet), 0);
            makeText.setGravity(17, 0, 0);
            makeText.show();
        }

        public static /* synthetic */ void i(DialogInterface dialogInterface, int i8) {
        }

        public int getCount() {
            return this.f13057b.size();
        }

        public Object getItem(int i8) {
            return this.f13057b.get(i8);
        }

        public long getItemId(int i8) {
            return (long) i8;
        }

        public View getView(int i8, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = FriendshipActivity.this.getLayoutInflater();
            this.f13056a = layoutInflater;
            View inflate = layoutInflater.inflate(C2030R.layout.friendship_entry, viewGroup, false);
            TextView textView = (TextView) inflate.findViewById(C2030R.id.textView2);
            if (((d) this.f13057b.get(i8)).f13069j != null) {
                textView.setText(FriendshipActivity.this.E0(((d) this.f13057b.get(i8)).f13069j));
            }
            TextView textView2 = (TextView) inflate.findViewById(C2030R.id.textView1);
            if (FriendshipActivity.this.f13053W == 2 || FriendshipActivity.this.f13053W == 4) {
                textView2.setText(((d) this.f13057b.get(i8)).f13067h);
            } else {
                textView2.setText(((d) this.f13057b.get(i8)).f13068i);
            }
            Button button = (Button) inflate.findViewById(C2030R.id.button1);
            Button button2 = (Button) inflate.findViewById(C2030R.id.button2);
            Button button3 = (Button) inflate.findViewById(C2030R.id.button3);
            int g02 = FriendshipActivity.this.f13053W;
            if (g02 == 1) {
                button.setVisibility(8);
                button2.setVisibility(0);
                button3.setVisibility(0);
            } else if (g02 == 2) {
                button.setVisibility(0);
                button2.setVisibility(0);
                button3.setVisibility(8);
            } else if (g02 == 3) {
                button.setVisibility(8);
                button2.setVisibility(0);
                button3.setVisibility(8);
            } else if (g02 == 4) {
                button.setVisibility(8);
                button2.setVisibility(0);
                button3.setVisibility(8);
            } else if (g02 == 5) {
                button.setVisibility(8);
                button2.setVisibility(8);
                button3.setVisibility(8);
            }
            button.setOnClickListener(new N(this, i8));
            button2.setOnClickListener(new O(this, i8));
            button3.setOnClickListener(new P(this, i8));
            return inflate;
        }

        /* access modifiers changed from: package-private */
        public void j(d dVar) {
            this.f13057b.add(dVar);
            notifyDataSetChanged();
        }

        private b(Activity activity, List list) {
            this.f13056a = LayoutInflater.from(activity);
            this.f13057b = list;
        }
    }

    private class c implements AdapterView.OnItemClickListener {
        private c() {
        }

        public void onItemClick(AdapterView adapterView, View view, int i8, long j8) {
            FriendshipActivity.this.K0(i8);
        }
    }

    private static class d {

        /* renamed from: a  reason: collision with root package name */
        private int f13060a;

        /* renamed from: b  reason: collision with root package name */
        private int f13061b;

        /* renamed from: c  reason: collision with root package name */
        private int f13062c;

        /* renamed from: d  reason: collision with root package name */
        private int f13063d;

        /* renamed from: e  reason: collision with root package name */
        private int f13064e;

        /* renamed from: f  reason: collision with root package name */
        private int f13065f;

        /* renamed from: g  reason: collision with root package name */
        private int f13066g;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public String f13067h;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public String f13068i;
        /* access modifiers changed from: private */

        /* renamed from: j  reason: collision with root package name */
        public String f13069j;

        private d() {
        }

        /* access modifiers changed from: private */
        public void A(int i8) {
            this.f13062c = i8;
        }

        /* access modifiers changed from: private */
        public void B(int i8) {
            this.f13060a = i8;
        }

        /* access modifiers changed from: private */
        public void s(String str) {
            this.f13069j = str;
        }

        /* access modifiers changed from: private */
        public void t(int i8) {
            this.f13064e = i8;
        }

        /* access modifiers changed from: private */
        public void u(int i8) {
            this.f13065f = i8;
        }

        /* access modifiers changed from: private */
        public void v(String str) {
            this.f13067h = str;
        }

        /* access modifiers changed from: private */
        public void w(String str) {
            this.f13068i = str;
        }

        /* access modifiers changed from: private */
        public void x(int i8) {
            this.f13066g = i8;
        }

        /* access modifiers changed from: private */
        public void y(int i8) {
            this.f13063d = i8;
        }

        /* access modifiers changed from: private */
        public void z(int i8) {
            this.f13061b = i8;
        }

        /* access modifiers changed from: package-private */
        public String n() {
            return this.f13067h;
        }

        /* access modifiers changed from: package-private */
        public String o() {
            return this.f13068i;
        }

        /* access modifiers changed from: package-private */
        public int p() {
            return this.f13066g;
        }

        /* access modifiers changed from: package-private */
        public int q() {
            return this.f13061b;
        }

        /* access modifiers changed from: package-private */
        public int r() {
            return this.f13062c;
        }
    }

    private class e extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private boolean f13070a;

        /* renamed from: b  reason: collision with root package name */
        private final String f13071b;

        /* renamed from: c  reason: collision with root package name */
        private final String f13072c;

        public static /* synthetic */ void a(DialogInterface dialogInterface, int i8) {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x00b5, code lost:
            r1.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x00b1 */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x00b5  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00bd  */
        /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r7) {
            /*
                r6 = this;
                java.util.HashMap r7 = new java.util.HashMap
                r7.<init>()
                java.lang.String r0 = "nick_from"
                java.lang.String r1 = r6.f13071b
                r7.put(r0, r1)
                java.lang.String r0 = "nick_to"
                java.lang.String r1 = r6.f13072c
                r7.put(r0, r1)
                java.lang.String r7 = u2.C1737L.a(r7)
                r0 = 1
                r1 = 0
                java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x00b1 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00b1 }
                r3.<init>()     // Catch:{ IOException -> 0x00b1 }
                com.finazzi.distquake.FriendshipActivity r4 = com.finazzi.distquake.FriendshipActivity.this     // Catch:{ IOException -> 0x00b1 }
                r5 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r4 = r4.getString(r5)     // Catch:{ IOException -> 0x00b1 }
                r3.append(r4)     // Catch:{ IOException -> 0x00b1 }
                java.lang.String r4 = "distquake_upload_friend_misconduct.php"
                r3.append(r4)     // Catch:{ IOException -> 0x00b1 }
                java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x00b1 }
                r2.<init>(r3)     // Catch:{ IOException -> 0x00b1 }
                java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x00b1 }
                java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch:{ IOException -> 0x00b1 }
                java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch:{ IOException -> 0x00b1 }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x00b1 }
                r2.setDoOutput(r0)     // Catch:{ IOException -> 0x0099, all -> 0x0096 }
                r1 = 10000(0x2710, float:1.4013E-41)
                r2.setConnectTimeout(r1)     // Catch:{ IOException -> 0x0099, all -> 0x0096 }
                r2.setReadTimeout(r1)     // Catch:{ IOException -> 0x0099, all -> 0x0096 }
                java.lang.String r1 = "Content-Type"
                java.lang.String r3 = "application/x-www-form-urlencoded;charset=utf-8"
                r2.setRequestProperty(r1, r3)     // Catch:{ IOException -> 0x0099, all -> 0x0096 }
                java.lang.String r1 = "POST"
                r2.setRequestMethod(r1)     // Catch:{ IOException -> 0x0099, all -> 0x0096 }
                byte[] r1 = r7.getBytes()     // Catch:{ IOException -> 0x0099, all -> 0x0096 }
                int r1 = r1.length     // Catch:{ IOException -> 0x0099, all -> 0x0096 }
                r2.setFixedLengthStreamingMode(r1)     // Catch:{ IOException -> 0x0099, all -> 0x0096 }
                java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch:{ IOException -> 0x0099, all -> 0x0096 }
                java.io.OutputStream r3 = r2.getOutputStream()     // Catch:{ IOException -> 0x0099, all -> 0x0096 }
                r1.<init>(r3)     // Catch:{ IOException -> 0x0099, all -> 0x0096 }
                r1.print(r7)     // Catch:{ IOException -> 0x0099, all -> 0x0096 }
                r1.close()     // Catch:{ IOException -> 0x0099, all -> 0x0096 }
                java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0099, all -> 0x0096 }
                java.io.InputStream r1 = r2.getInputStream()     // Catch:{ IOException -> 0x0099, all -> 0x0096 }
                r7.<init>(r1)     // Catch:{ IOException -> 0x0099, all -> 0x0096 }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0099, all -> 0x0096 }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0099, all -> 0x0096 }
                java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x0099, all -> 0x0096 }
                r3.<init>(r7, r4)     // Catch:{ IOException -> 0x0099, all -> 0x0096 }
                r1.<init>(r3)     // Catch:{ IOException -> 0x0099, all -> 0x0096 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0099, all -> 0x0096 }
                r3.<init>()     // Catch:{ IOException -> 0x0099, all -> 0x0096 }
            L_0x008c:
                java.lang.String r4 = r1.readLine()     // Catch:{ IOException -> 0x0099, all -> 0x0096 }
                if (r4 == 0) goto L_0x009b
                r3.append(r4)     // Catch:{ IOException -> 0x0099, all -> 0x0096 }
                goto L_0x008c
            L_0x0096:
                r7 = move-exception
                r1 = r2
                goto L_0x00bb
            L_0x0099:
                r1 = r2
                goto L_0x00b1
            L_0x009b:
                r7.close()     // Catch:{ IOException -> 0x0099, all -> 0x0096 }
                java.lang.String r7 = r3.toString()     // Catch:{ IOException -> 0x0099, all -> 0x0096 }
                java.lang.String r1 = "ok"
                boolean r7 = r7.equals(r1)     // Catch:{ IOException -> 0x0099, all -> 0x0096 }
                r7 = r7 ^ r0
                r6.f13070a = r7     // Catch:{ IOException -> 0x0099, all -> 0x0096 }
                r2.disconnect()
                goto L_0x00b8
            L_0x00af:
                r7 = move-exception
                goto L_0x00bb
            L_0x00b1:
                r6.f13070a = r0     // Catch:{ all -> 0x00af }
                if (r1 == 0) goto L_0x00b8
                r1.disconnect()
            L_0x00b8:
                java.lang.String r7 = "COMPLETE!"
                return r7
            L_0x00bb:
                if (r1 == 0) goto L_0x00c0
                r1.disconnect()
            L_0x00c0:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.FriendshipActivity.e.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            if (FriendshipActivity.this.f13055Y) {
                AlertDialog.Builder builder = new AlertDialog.Builder(FriendshipActivity.this);
                builder.setMessage(FriendshipActivity.this.getString(C2030R.string.friend_accept));
                if (!this.f13070a) {
                    builder.setMessage(FriendshipActivity.this.getString(C2030R.string.friend_reported));
                } else {
                    builder.setMessage(FriendshipActivity.this.getString(C2030R.string.manual_error));
                }
                builder.setCancelable(true);
                builder.setPositiveButton(FriendshipActivity.this.getString(C2030R.string.status_cancel), new X());
                builder.create().show();
            }
        }

        private e(String str, String str2) {
            this.f13070a = true;
            this.f13071b = str;
            this.f13072c = str2;
        }
    }

    private class f extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private boolean f13074a;

        /* renamed from: b  reason: collision with root package name */
        private String f13075b;

        /* renamed from: c  reason: collision with root package name */
        private final int f13076c;

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x00b3, code lost:
            r1.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x00af */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x00b3  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00bb  */
        /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r7) {
            /*
                r6 = this;
                java.util.HashMap r7 = new java.util.HashMap
                r7.<init>()
                int r0 = r6.f13076c
                java.lang.String r0 = java.lang.Integer.toString(r0)
                java.lang.String r1 = "user_code"
                r7.put(r1, r0)
                java.lang.String r7 = u2.C1737L.a(r7)
                r0 = 1
                r1 = 0
                java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x00af }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00af }
                r3.<init>()     // Catch:{ IOException -> 0x00af }
                com.finazzi.distquake.FriendshipActivity r4 = com.finazzi.distquake.FriendshipActivity.this     // Catch:{ IOException -> 0x00af }
                r5 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r4 = r4.getString(r5)     // Catch:{ IOException -> 0x00af }
                r3.append(r4)     // Catch:{ IOException -> 0x00af }
                java.lang.String r4 = "distquake_dowload_otheruserprofile.php"
                r3.append(r4)     // Catch:{ IOException -> 0x00af }
                java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x00af }
                r2.<init>(r3)     // Catch:{ IOException -> 0x00af }
                java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x00af }
                java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch:{ IOException -> 0x00af }
                java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch:{ IOException -> 0x00af }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x00af }
                r2.setDoOutput(r0)     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
                r1 = 10000(0x2710, float:1.4013E-41)
                r2.setConnectTimeout(r1)     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
                r2.setReadTimeout(r1)     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
                java.lang.String r1 = "Content-Type"
                java.lang.String r3 = "application/x-www-form-urlencoded;charset=utf-8"
                r2.setRequestProperty(r1, r3)     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
                java.lang.String r1 = "POST"
                r2.setRequestMethod(r1)     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
                byte[] r1 = r7.getBytes()     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
                int r1 = r1.length     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
                r2.setFixedLengthStreamingMode(r1)     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
                java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
                java.io.OutputStream r3 = r2.getOutputStream()     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
                r1.<init>(r3)     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
                r1.print(r7)     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
                r1.close()     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
                java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
                java.io.InputStream r1 = r2.getInputStream()     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
                r7.<init>(r1)     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
                java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
                r3.<init>(r7, r4)     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
                r1.<init>(r3)     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
                r3.<init>()     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
            L_0x0089:
                java.lang.String r4 = r1.readLine()     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
                if (r4 == 0) goto L_0x009d
                r3.append(r4)     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
                java.lang.String r4 = "\n"
                r3.append(r4)     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
                goto L_0x0089
            L_0x0098:
                r7 = move-exception
                r1 = r2
                goto L_0x00b9
            L_0x009b:
                r1 = r2
                goto L_0x00af
            L_0x009d:
                r7.close()     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
                java.lang.String r7 = r3.toString()     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
                r6.f13075b = r7     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
                r7 = 0
                r6.f13074a = r7     // Catch:{ IOException -> 0x009b, all -> 0x0098 }
                r2.disconnect()
                goto L_0x00b6
            L_0x00ad:
                r7 = move-exception
                goto L_0x00b9
            L_0x00af:
                r6.f13074a = r0     // Catch:{ all -> 0x00ad }
                if (r1 == 0) goto L_0x00b6
                r1.disconnect()
            L_0x00b6:
                java.lang.String r7 = "COMPLETE!"
                return r7
            L_0x00b9:
                if (r1 == 0) goto L_0x00be
                r1.disconnect()
            L_0x00be:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.FriendshipActivity.f.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            if (!this.f13074a) {
                try {
                    JSONObject jSONObject = new JSONArray(this.f13075b).getJSONObject(0);
                    String string = jSONObject.getString("nick");
                    int i8 = jSONObject.getInt("sex");
                    int i9 = jSONObject.getInt("country");
                    String string2 = jSONObject.getString("town");
                    int i10 = jSONObject.getInt("age");
                    int i11 = jSONObject.getInt("updated");
                    int i12 = jSONObject.getInt("firstlog");
                    int i13 = jSONObject.getInt("fr");
                    Intent intent = new Intent().setClass(FriendshipActivity.this, ProfileOtherActivity.class);
                    intent.putExtra("com.finazzi.distquake.nick", string);
                    intent.putExtra("com.finazzi.distquake.sex", i8);
                    intent.putExtra("com.finazzi.distquake.country", i9);
                    intent.putExtra("com.finazzi.distquake.town", string2);
                    intent.putExtra("com.finazzi.distquake.age", i10);
                    intent.putExtra("com.finazzi.distquake.user_code", this.f13076c);
                    intent.putExtra("com.finazzi.distquake.updated", i11);
                    intent.putExtra("com.finazzi.distquake.firstlog", i12);
                    intent.putExtra("com.finazzi.distquake.accept_friendship", i13);
                    intent.putExtra("com.finazzi.distquake.postfix", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                    FriendshipActivity.this.startActivity(intent);
                } catch (JSONException unused) {
                    Toast makeText = Toast.makeText(FriendshipActivity.this.getApplicationContext(), FriendshipActivity.this.getString(C2030R.string.manual_error), 0);
                    makeText.setGravity(17, 0, 0);
                    makeText.show();
                }
            } else {
                Toast makeText2 = Toast.makeText(FriendshipActivity.this.getApplicationContext(), FriendshipActivity.this.getString(C2030R.string.manual_error), 0);
                makeText2.setGravity(17, 0, 0);
                makeText2.show();
            }
        }

        private f(int i8) {
            this.f13075b = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
            this.f13076c = i8;
        }
    }

    private class g extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private int f13078a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f13079b;

        /* renamed from: c  reason: collision with root package name */
        private final int f13080c;

        /* renamed from: d  reason: collision with root package name */
        private final int f13081d;

        /* renamed from: e  reason: collision with root package name */
        private final int f13082e;

        /* renamed from: f  reason: collision with root package name */
        private final String f13083f;

        /* renamed from: g  reason: collision with root package name */
        private final String f13084g;

        /* renamed from: h  reason: collision with root package name */
        private final String f13085h;

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00e4, code lost:
            r1.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x00e0 */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x00e4  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x00ec  */
        /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r7) {
            /*
                r6 = this;
                java.util.HashMap r7 = new java.util.HashMap
                r7.<init>()
                java.lang.String r0 = "u_id"
                java.lang.String r1 = r6.f13083f
                r7.put(r0, r1)
                int r0 = r6.f13080c
                java.lang.String r0 = java.lang.Integer.toString(r0)
                java.lang.String r1 = "user_code_from"
                r7.put(r1, r0)
                int r0 = r6.f13081d
                java.lang.String r0 = java.lang.Integer.toString(r0)
                java.lang.String r1 = "user_code_to"
                r7.put(r1, r0)
                java.lang.String r0 = "nick_from"
                java.lang.String r1 = r6.f13084g
                r7.put(r0, r1)
                java.lang.String r0 = "nick_to"
                java.lang.String r1 = r6.f13085h
                r7.put(r0, r1)
                int r0 = r6.f13082e
                java.lang.String r0 = java.lang.Integer.toString(r0)
                java.lang.String r1 = "randcode"
                r7.put(r1, r0)
                java.lang.String r7 = u2.C1737L.a(r7)
                r0 = 1
                r1 = 0
                java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x00e0 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00e0 }
                r3.<init>()     // Catch:{ IOException -> 0x00e0 }
                com.finazzi.distquake.FriendshipActivity r4 = com.finazzi.distquake.FriendshipActivity.this     // Catch:{ IOException -> 0x00e0 }
                r5 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r4 = r4.getString(r5)     // Catch:{ IOException -> 0x00e0 }
                r3.append(r4)     // Catch:{ IOException -> 0x00e0 }
                java.lang.String r4 = "distquake_upload_friend_accept.php"
                r3.append(r4)     // Catch:{ IOException -> 0x00e0 }
                java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x00e0 }
                r2.<init>(r3)     // Catch:{ IOException -> 0x00e0 }
                java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x00e0 }
                java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch:{ IOException -> 0x00e0 }
                java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch:{ IOException -> 0x00e0 }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x00e0 }
                r2.setDoOutput(r0)     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
                r1 = 10000(0x2710, float:1.4013E-41)
                r2.setConnectTimeout(r1)     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
                r2.setReadTimeout(r1)     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
                java.lang.String r1 = "Content-Type"
                java.lang.String r3 = "application/x-www-form-urlencoded;charset=utf-8"
                r2.setRequestProperty(r1, r3)     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
                java.lang.String r1 = "POST"
                r2.setRequestMethod(r1)     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
                byte[] r1 = r7.getBytes()     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
                int r1 = r1.length     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
                r2.setFixedLengthStreamingMode(r1)     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
                java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
                java.io.OutputStream r3 = r2.getOutputStream()     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
                r1.print(r7)     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
                r1.close()     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
                java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
                java.io.InputStream r1 = r2.getInputStream()     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
                r7.<init>(r1)     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
                java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
                r3.<init>(r7, r4)     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
                r3.<init>()     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
            L_0x00b4:
                java.lang.String r4 = r1.readLine()     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
                if (r4 == 0) goto L_0x00c3
                r3.append(r4)     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
                goto L_0x00b4
            L_0x00be:
                r7 = move-exception
                r1 = r2
                goto L_0x00ea
            L_0x00c1:
                r1 = r2
                goto L_0x00e0
            L_0x00c3:
                r7.close()     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
                java.lang.String r7 = r3.toString()     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
                r1 = 0
                r6.f13079b = r1     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
                java.lang.String r3 = "ok"
                boolean r7 = r7.equals(r3)     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
                if (r7 == 0) goto L_0x00d8
                r6.f13078a = r1     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
                goto L_0x00da
            L_0x00d8:
                r6.f13078a = r0     // Catch:{ IOException -> 0x00c1, all -> 0x00be }
            L_0x00da:
                r2.disconnect()
                goto L_0x00e7
            L_0x00de:
                r7 = move-exception
                goto L_0x00ea
            L_0x00e0:
                r6.f13079b = r0     // Catch:{ all -> 0x00de }
                if (r1 == 0) goto L_0x00e7
                r1.disconnect()
            L_0x00e7:
                java.lang.String r7 = "COMPLETE!"
                return r7
            L_0x00ea:
                if (r1 == 0) goto L_0x00ef
                r1.disconnect()
            L_0x00ef:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.FriendshipActivity.g.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            if (this.f13079b) {
                Toast makeText = Toast.makeText(FriendshipActivity.this.getApplicationContext(), FriendshipActivity.this.getString(C2030R.string.manual_error), 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            } else if (this.f13078a == 0) {
                Toast makeText2 = Toast.makeText(FriendshipActivity.this.getApplicationContext(), FriendshipActivity.this.getString(C2030R.string.friend_confirmed), 0);
                makeText2.setGravity(17, 0, 0);
                makeText2.show();
                FriendshipActivity friendshipActivity = FriendshipActivity.this;
                friendshipActivity.z0(friendshipActivity.A0(), FriendshipActivity.this.G0(), FriendshipActivity.this.F0());
            } else {
                Toast makeText3 = Toast.makeText(FriendshipActivity.this.getApplicationContext(), FriendshipActivity.this.getString(C2030R.string.manual_error), 0);
                makeText3.setGravity(17, 0, 0);
                makeText3.show();
            }
        }

        private g(String str, int i8, int i9, String str2, String str3, int i10) {
            this.f13083f = str;
            this.f13080c = i8;
            this.f13081d = i9;
            this.f13084g = str2;
            this.f13085h = str3;
            this.f13082e = i10;
        }
    }

    private class h extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private int f13087a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f13088b;

        /* renamed from: c  reason: collision with root package name */
        private final int f13089c;

        /* renamed from: d  reason: collision with root package name */
        private final int f13090d;

        /* renamed from: e  reason: collision with root package name */
        private final int f13091e;

        /* renamed from: f  reason: collision with root package name */
        private final String f13092f;

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(5:11|10|18|19|(0)(0)) */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x00d0, code lost:
            r7 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00d6, code lost:
            r1.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00de, code lost:
            r1.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x00d2 */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x00d6  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x00de  */
        /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r7) {
            /*
                r6 = this;
                java.util.HashMap r7 = new java.util.HashMap
                r7.<init>()
                java.lang.String r0 = "u_id"
                java.lang.String r1 = r6.f13092f
                r7.put(r0, r1)
                int r0 = r6.f13089c
                java.lang.String r0 = java.lang.Integer.toString(r0)
                java.lang.String r1 = "user_code_from"
                r7.put(r1, r0)
                int r0 = r6.f13090d
                java.lang.String r0 = java.lang.Integer.toString(r0)
                java.lang.String r1 = "user_code_to"
                r7.put(r1, r0)
                int r0 = r6.f13091e
                java.lang.String r0 = java.lang.Integer.toString(r0)
                java.lang.String r1 = "randcode"
                r7.put(r1, r0)
                java.lang.String r7 = u2.C1737L.a(r7)
                r0 = 1
                r1 = 0
                java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x00d2 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00d2 }
                r3.<init>()     // Catch:{ IOException -> 0x00d2 }
                com.finazzi.distquake.FriendshipActivity r4 = com.finazzi.distquake.FriendshipActivity.this     // Catch:{ IOException -> 0x00d2 }
                r5 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r4 = r4.getString(r5)     // Catch:{ IOException -> 0x00d2 }
                r3.append(r4)     // Catch:{ IOException -> 0x00d2 }
                java.lang.String r4 = "distquake_upload_friend_remove_friend.php"
                r3.append(r4)     // Catch:{ IOException -> 0x00d2 }
                java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x00d2 }
                r2.<init>(r3)     // Catch:{ IOException -> 0x00d2 }
                java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x00d2 }
                java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch:{ IOException -> 0x00d2 }
                java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch:{ IOException -> 0x00d2 }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x00d2 }
                r2.setDoOutput(r0)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r1 = 10000(0x2710, float:1.4013E-41)
                r2.setConnectTimeout(r1)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r2.setReadTimeout(r1)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.lang.String r1 = "Content-Type"
                java.lang.String r3 = "application/x-www-form-urlencoded;charset=utf-8"
                r2.setRequestProperty(r1, r3)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.lang.String r1 = "POST"
                r2.setRequestMethod(r1)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                byte[] r1 = r7.getBytes()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                int r1 = r1.length     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r2.setFixedLengthStreamingMode(r1)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.io.OutputStream r3 = r2.getOutputStream()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r1.print(r7)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r1.close()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.io.InputStream r1 = r2.getInputStream()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r7.<init>(r1)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r3.<init>(r7, r4)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r3.<init>()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
            L_0x00a6:
                java.lang.String r4 = r1.readLine()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                if (r4 == 0) goto L_0x00b5
                r3.append(r4)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                goto L_0x00a6
            L_0x00b0:
                r7 = move-exception
                r1 = r2
                goto L_0x00dc
            L_0x00b3:
                r1 = r2
                goto L_0x00d2
            L_0x00b5:
                r7.close()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.lang.String r7 = r3.toString()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r1 = 0
                r6.f13088b = r1     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.lang.String r3 = "ok"
                boolean r7 = r7.equals(r3)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                if (r7 == 0) goto L_0x00ca
                r6.f13087a = r1     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                goto L_0x00cc
            L_0x00ca:
                r6.f13087a = r0     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
            L_0x00cc:
                r2.disconnect()
                goto L_0x00d9
            L_0x00d0:
                r7 = move-exception
                goto L_0x00dc
            L_0x00d2:
                r6.f13088b = r0     // Catch:{ all -> 0x00d0 }
                if (r1 == 0) goto L_0x00d9
                r1.disconnect()
            L_0x00d9:
                java.lang.String r7 = "COMPLETE!"
                return r7
            L_0x00dc:
                if (r1 == 0) goto L_0x00e1
                r1.disconnect()
            L_0x00e1:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.FriendshipActivity.h.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            if (this.f13088b) {
                Toast makeText = Toast.makeText(FriendshipActivity.this.getApplicationContext(), FriendshipActivity.this.getString(C2030R.string.manual_error), 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            } else if (this.f13087a == 0) {
                Toast makeText2 = Toast.makeText(FriendshipActivity.this.getApplicationContext(), FriendshipActivity.this.getString(C2030R.string.friend_removed), 0);
                makeText2.setGravity(17, 0, 0);
                makeText2.show();
                FriendshipActivity friendshipActivity = FriendshipActivity.this;
                friendshipActivity.z0(friendshipActivity.A0(), FriendshipActivity.this.G0(), FriendshipActivity.this.F0());
            } else {
                Toast makeText3 = Toast.makeText(FriendshipActivity.this.getApplicationContext(), FriendshipActivity.this.getString(C2030R.string.manual_error), 0);
                makeText3.setGravity(17, 0, 0);
                makeText3.show();
            }
        }

        private h(String str, int i8, int i9, int i10) {
            this.f13092f = str;
            this.f13089c = i8;
            this.f13090d = i9;
            this.f13091e = i10;
        }
    }

    private class i extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private int f13094a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f13095b;

        /* renamed from: c  reason: collision with root package name */
        private final int f13096c;

        /* renamed from: d  reason: collision with root package name */
        private final int f13097d;

        /* renamed from: e  reason: collision with root package name */
        private final int f13098e;

        /* renamed from: f  reason: collision with root package name */
        private final String f13099f;

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(5:11|10|18|19|(0)(0)) */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x00d0, code lost:
            r7 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00d6, code lost:
            r1.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00de, code lost:
            r1.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x00d2 */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x00d6  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x00de  */
        /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r7) {
            /*
                r6 = this;
                java.util.HashMap r7 = new java.util.HashMap
                r7.<init>()
                java.lang.String r0 = "u_id"
                java.lang.String r1 = r6.f13099f
                r7.put(r0, r1)
                int r0 = r6.f13096c
                java.lang.String r0 = java.lang.Integer.toString(r0)
                java.lang.String r1 = "user_code_from"
                r7.put(r1, r0)
                int r0 = r6.f13097d
                java.lang.String r0 = java.lang.Integer.toString(r0)
                java.lang.String r1 = "user_code_to"
                r7.put(r1, r0)
                int r0 = r6.f13098e
                java.lang.String r0 = java.lang.Integer.toString(r0)
                java.lang.String r1 = "randcode"
                r7.put(r1, r0)
                java.lang.String r7 = u2.C1737L.a(r7)
                r0 = 1
                r1 = 0
                java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x00d2 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00d2 }
                r3.<init>()     // Catch:{ IOException -> 0x00d2 }
                com.finazzi.distquake.FriendshipActivity r4 = com.finazzi.distquake.FriendshipActivity.this     // Catch:{ IOException -> 0x00d2 }
                r5 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r4 = r4.getString(r5)     // Catch:{ IOException -> 0x00d2 }
                r3.append(r4)     // Catch:{ IOException -> 0x00d2 }
                java.lang.String r4 = "distquake_upload_friend_decline.php"
                r3.append(r4)     // Catch:{ IOException -> 0x00d2 }
                java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x00d2 }
                r2.<init>(r3)     // Catch:{ IOException -> 0x00d2 }
                java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x00d2 }
                java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch:{ IOException -> 0x00d2 }
                java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch:{ IOException -> 0x00d2 }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x00d2 }
                r2.setDoOutput(r0)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r1 = 10000(0x2710, float:1.4013E-41)
                r2.setConnectTimeout(r1)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r2.setReadTimeout(r1)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.lang.String r1 = "Content-Type"
                java.lang.String r3 = "application/x-www-form-urlencoded;charset=utf-8"
                r2.setRequestProperty(r1, r3)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.lang.String r1 = "POST"
                r2.setRequestMethod(r1)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                byte[] r1 = r7.getBytes()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                int r1 = r1.length     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r2.setFixedLengthStreamingMode(r1)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.io.OutputStream r3 = r2.getOutputStream()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r1.print(r7)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r1.close()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.io.InputStream r1 = r2.getInputStream()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r7.<init>(r1)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r3.<init>(r7, r4)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r3.<init>()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
            L_0x00a6:
                java.lang.String r4 = r1.readLine()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                if (r4 == 0) goto L_0x00b5
                r3.append(r4)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                goto L_0x00a6
            L_0x00b0:
                r7 = move-exception
                r1 = r2
                goto L_0x00dc
            L_0x00b3:
                r1 = r2
                goto L_0x00d2
            L_0x00b5:
                r7.close()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.lang.String r7 = r3.toString()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r1 = 0
                r6.f13095b = r1     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.lang.String r3 = "ok"
                boolean r7 = r7.equals(r3)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                if (r7 == 0) goto L_0x00ca
                r6.f13094a = r1     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                goto L_0x00cc
            L_0x00ca:
                r6.f13094a = r0     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
            L_0x00cc:
                r2.disconnect()
                goto L_0x00d9
            L_0x00d0:
                r7 = move-exception
                goto L_0x00dc
            L_0x00d2:
                r6.f13095b = r0     // Catch:{ all -> 0x00d0 }
                if (r1 == 0) goto L_0x00d9
                r1.disconnect()
            L_0x00d9:
                java.lang.String r7 = "COMPLETE!"
                return r7
            L_0x00dc:
                if (r1 == 0) goto L_0x00e1
                r1.disconnect()
            L_0x00e1:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.FriendshipActivity.i.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            if (this.f13095b) {
                Toast makeText = Toast.makeText(FriendshipActivity.this.getApplicationContext(), FriendshipActivity.this.getString(C2030R.string.manual_error), 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            } else if (this.f13094a == 0) {
                Toast makeText2 = Toast.makeText(FriendshipActivity.this.getApplicationContext(), FriendshipActivity.this.getString(C2030R.string.friend_denied), 0);
                makeText2.setGravity(17, 0, 0);
                makeText2.show();
                FriendshipActivity friendshipActivity = FriendshipActivity.this;
                friendshipActivity.z0(friendshipActivity.A0(), FriendshipActivity.this.G0(), FriendshipActivity.this.F0());
            } else {
                Toast makeText3 = Toast.makeText(FriendshipActivity.this.getApplicationContext(), FriendshipActivity.this.getString(C2030R.string.manual_error), 0);
                makeText3.setGravity(17, 0, 0);
                makeText3.show();
            }
        }

        private i(String str, int i8, int i9, int i10) {
            this.f13099f = str;
            this.f13096c = i8;
            this.f13097d = i9;
            this.f13098e = i10;
        }
    }

    private class j extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private int f13101a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f13102b;

        /* renamed from: c  reason: collision with root package name */
        private final int f13103c;

        /* renamed from: d  reason: collision with root package name */
        private final int f13104d;

        /* renamed from: e  reason: collision with root package name */
        private final int f13105e;

        /* renamed from: f  reason: collision with root package name */
        private final String f13106f;

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(5:11|10|18|19|(0)(0)) */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x00d0, code lost:
            r7 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00d6, code lost:
            r1.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00de, code lost:
            r1.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x00d2 */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x00d6  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x00de  */
        /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r7) {
            /*
                r6 = this;
                java.util.HashMap r7 = new java.util.HashMap
                r7.<init>()
                java.lang.String r0 = "u_id"
                java.lang.String r1 = r6.f13106f
                r7.put(r0, r1)
                int r0 = r6.f13103c
                java.lang.String r0 = java.lang.Integer.toString(r0)
                java.lang.String r1 = "user_code_from"
                r7.put(r1, r0)
                int r0 = r6.f13104d
                java.lang.String r0 = java.lang.Integer.toString(r0)
                java.lang.String r1 = "user_code_to"
                r7.put(r1, r0)
                int r0 = r6.f13105e
                java.lang.String r0 = java.lang.Integer.toString(r0)
                java.lang.String r1 = "randcode"
                r7.put(r1, r0)
                java.lang.String r7 = u2.C1737L.a(r7)
                r0 = 1
                r1 = 0
                java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x00d2 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00d2 }
                r3.<init>()     // Catch:{ IOException -> 0x00d2 }
                com.finazzi.distquake.FriendshipActivity r4 = com.finazzi.distquake.FriendshipActivity.this     // Catch:{ IOException -> 0x00d2 }
                r5 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r4 = r4.getString(r5)     // Catch:{ IOException -> 0x00d2 }
                r3.append(r4)     // Catch:{ IOException -> 0x00d2 }
                java.lang.String r4 = "distquake_upload_friend_remove_requested.php"
                r3.append(r4)     // Catch:{ IOException -> 0x00d2 }
                java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x00d2 }
                r2.<init>(r3)     // Catch:{ IOException -> 0x00d2 }
                java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x00d2 }
                java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch:{ IOException -> 0x00d2 }
                java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch:{ IOException -> 0x00d2 }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x00d2 }
                r2.setDoOutput(r0)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r1 = 10000(0x2710, float:1.4013E-41)
                r2.setConnectTimeout(r1)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r2.setReadTimeout(r1)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.lang.String r1 = "Content-Type"
                java.lang.String r3 = "application/x-www-form-urlencoded;charset=utf-8"
                r2.setRequestProperty(r1, r3)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.lang.String r1 = "POST"
                r2.setRequestMethod(r1)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                byte[] r1 = r7.getBytes()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                int r1 = r1.length     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r2.setFixedLengthStreamingMode(r1)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.io.OutputStream r3 = r2.getOutputStream()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r1.print(r7)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r1.close()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.io.InputStream r1 = r2.getInputStream()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r7.<init>(r1)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r3.<init>(r7, r4)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r3.<init>()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
            L_0x00a6:
                java.lang.String r4 = r1.readLine()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                if (r4 == 0) goto L_0x00b5
                r3.append(r4)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                goto L_0x00a6
            L_0x00b0:
                r7 = move-exception
                r1 = r2
                goto L_0x00dc
            L_0x00b3:
                r1 = r2
                goto L_0x00d2
            L_0x00b5:
                r7.close()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.lang.String r7 = r3.toString()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r1 = 0
                r6.f13102b = r1     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.lang.String r3 = "ok"
                boolean r7 = r7.equals(r3)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                if (r7 == 0) goto L_0x00ca
                r6.f13101a = r1     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                goto L_0x00cc
            L_0x00ca:
                r6.f13101a = r0     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
            L_0x00cc:
                r2.disconnect()
                goto L_0x00d9
            L_0x00d0:
                r7 = move-exception
                goto L_0x00dc
            L_0x00d2:
                r6.f13102b = r0     // Catch:{ all -> 0x00d0 }
                if (r1 == 0) goto L_0x00d9
                r1.disconnect()
            L_0x00d9:
                java.lang.String r7 = "COMPLETE!"
                return r7
            L_0x00dc:
                if (r1 == 0) goto L_0x00e1
                r1.disconnect()
            L_0x00e1:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.FriendshipActivity.j.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            if (this.f13102b) {
                Toast makeText = Toast.makeText(FriendshipActivity.this.getApplicationContext(), FriendshipActivity.this.getString(C2030R.string.manual_error), 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            } else if (this.f13101a == 0) {
                Toast makeText2 = Toast.makeText(FriendshipActivity.this.getApplicationContext(), FriendshipActivity.this.getString(C2030R.string.friend_cancelled), 0);
                makeText2.setGravity(17, 0, 0);
                makeText2.show();
                FriendshipActivity friendshipActivity = FriendshipActivity.this;
                friendshipActivity.z0(friendshipActivity.A0(), FriendshipActivity.this.G0(), FriendshipActivity.this.F0());
            } else {
                Toast makeText3 = Toast.makeText(FriendshipActivity.this.getApplicationContext(), FriendshipActivity.this.getString(C2030R.string.manual_error), 0);
                makeText3.setGravity(17, 0, 0);
                makeText3.show();
            }
        }

        private j(String str, int i8, int i9, int i10) {
            this.f13106f = str;
            this.f13103c = i8;
            this.f13104d = i9;
            this.f13105e = i10;
        }
    }

    private class k extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private int f13108a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f13109b;

        /* renamed from: c  reason: collision with root package name */
        private final int f13110c;

        /* renamed from: d  reason: collision with root package name */
        private final int f13111d;

        /* renamed from: e  reason: collision with root package name */
        private final int f13112e;

        /* renamed from: f  reason: collision with root package name */
        private final String f13113f;

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(5:11|10|18|19|(0)(0)) */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x00d0, code lost:
            r7 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00d6, code lost:
            r1.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00de, code lost:
            r1.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x00d2 */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x00d6  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x00de  */
        /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r7) {
            /*
                r6 = this;
                java.util.HashMap r7 = new java.util.HashMap
                r7.<init>()
                java.lang.String r0 = "u_id"
                java.lang.String r1 = r6.f13113f
                r7.put(r0, r1)
                int r0 = r6.f13110c
                java.lang.String r0 = java.lang.Integer.toString(r0)
                java.lang.String r1 = "user_code_from"
                r7.put(r1, r0)
                int r0 = r6.f13111d
                java.lang.String r0 = java.lang.Integer.toString(r0)
                java.lang.String r1 = "user_code_to"
                r7.put(r1, r0)
                int r0 = r6.f13112e
                java.lang.String r0 = java.lang.Integer.toString(r0)
                java.lang.String r1 = "randcode"
                r7.put(r1, r0)
                java.lang.String r7 = u2.C1737L.a(r7)
                r0 = 1
                r1 = 0
                java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x00d2 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00d2 }
                r3.<init>()     // Catch:{ IOException -> 0x00d2 }
                com.finazzi.distquake.FriendshipActivity r4 = com.finazzi.distquake.FriendshipActivity.this     // Catch:{ IOException -> 0x00d2 }
                r5 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r4 = r4.getString(r5)     // Catch:{ IOException -> 0x00d2 }
                r3.append(r4)     // Catch:{ IOException -> 0x00d2 }
                java.lang.String r4 = "distquake_upload_friend_remove_declined.php"
                r3.append(r4)     // Catch:{ IOException -> 0x00d2 }
                java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x00d2 }
                r2.<init>(r3)     // Catch:{ IOException -> 0x00d2 }
                java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x00d2 }
                java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch:{ IOException -> 0x00d2 }
                java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch:{ IOException -> 0x00d2 }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x00d2 }
                r2.setDoOutput(r0)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r1 = 10000(0x2710, float:1.4013E-41)
                r2.setConnectTimeout(r1)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r2.setReadTimeout(r1)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.lang.String r1 = "Content-Type"
                java.lang.String r3 = "application/x-www-form-urlencoded;charset=utf-8"
                r2.setRequestProperty(r1, r3)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.lang.String r1 = "POST"
                r2.setRequestMethod(r1)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                byte[] r1 = r7.getBytes()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                int r1 = r1.length     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r2.setFixedLengthStreamingMode(r1)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.io.OutputStream r3 = r2.getOutputStream()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r1.print(r7)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r1.close()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.io.InputStream r1 = r2.getInputStream()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r7.<init>(r1)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r3.<init>(r7, r4)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r3.<init>()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
            L_0x00a6:
                java.lang.String r4 = r1.readLine()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                if (r4 == 0) goto L_0x00b5
                r3.append(r4)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                goto L_0x00a6
            L_0x00b0:
                r7 = move-exception
                r1 = r2
                goto L_0x00dc
            L_0x00b3:
                r1 = r2
                goto L_0x00d2
            L_0x00b5:
                r7.close()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.lang.String r7 = r3.toString()     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                r1 = 0
                r6.f13109b = r1     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                java.lang.String r3 = "ok"
                boolean r7 = r7.equals(r3)     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                if (r7 == 0) goto L_0x00ca
                r6.f13108a = r1     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
                goto L_0x00cc
            L_0x00ca:
                r6.f13108a = r0     // Catch:{ IOException -> 0x00b3, all -> 0x00b0 }
            L_0x00cc:
                r2.disconnect()
                goto L_0x00d9
            L_0x00d0:
                r7 = move-exception
                goto L_0x00dc
            L_0x00d2:
                r6.f13109b = r0     // Catch:{ all -> 0x00d0 }
                if (r1 == 0) goto L_0x00d9
                r1.disconnect()
            L_0x00d9:
                java.lang.String r7 = "COMPLETE!"
                return r7
            L_0x00dc:
                if (r1 == 0) goto L_0x00e1
                r1.disconnect()
            L_0x00e1:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.FriendshipActivity.k.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            if (this.f13109b) {
                Toast makeText = Toast.makeText(FriendshipActivity.this.getApplicationContext(), FriendshipActivity.this.getString(C2030R.string.manual_error), 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            } else if (this.f13108a == 0) {
                Toast makeText2 = Toast.makeText(FriendshipActivity.this.getApplicationContext(), FriendshipActivity.this.getString(C2030R.string.friend_deny_cancelled), 0);
                makeText2.setGravity(17, 0, 0);
                makeText2.show();
                FriendshipActivity friendshipActivity = FriendshipActivity.this;
                friendshipActivity.z0(friendshipActivity.A0(), FriendshipActivity.this.G0(), FriendshipActivity.this.F0());
            } else {
                Toast makeText3 = Toast.makeText(FriendshipActivity.this.getApplicationContext(), FriendshipActivity.this.getString(C2030R.string.manual_error), 0);
                makeText3.setGravity(17, 0, 0);
                makeText3.show();
            }
        }

        private k(String str, int i8, int i9, int i10) {
            this.f13113f = str;
            this.f13110c = i8;
            this.f13111d = i9;
            this.f13112e = i10;
        }
    }

    private class l extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private String f13115a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f13116b;

        /* renamed from: c  reason: collision with root package name */
        private int f13117c;

        /* renamed from: d  reason: collision with root package name */
        private final String f13118d;

        /* renamed from: e  reason: collision with root package name */
        private final String f13119e;

        /* renamed from: f  reason: collision with root package name */
        private final int f13120f;

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x00cd, code lost:
            r1.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x00c9 */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00cd  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x00d5  */
        /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r7) {
            /*
                r6 = this;
                java.util.HashMap r7 = new java.util.HashMap
                r7.<init>()
                java.lang.String r0 = "u_id"
                java.lang.String r1 = r6.f13118d
                r7.put(r0, r1)
                java.lang.String r0 = "uID"
                java.lang.String r1 = r6.f13119e
                r7.put(r0, r1)
                int r0 = r6.f13120f
                java.lang.String r0 = java.lang.Integer.toString(r0)
                java.lang.String r1 = "user_code_from"
                r7.put(r1, r0)
                java.lang.String r7 = u2.C1737L.a(r7)
                r0 = 1
                r1 = 0
                java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x00c9 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c9 }
                r3.<init>()     // Catch:{ IOException -> 0x00c9 }
                com.finazzi.distquake.FriendshipActivity r4 = com.finazzi.distquake.FriendshipActivity.this     // Catch:{ IOException -> 0x00c9 }
                r5 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r4 = r4.getString(r5)     // Catch:{ IOException -> 0x00c9 }
                r3.append(r4)     // Catch:{ IOException -> 0x00c9 }
                java.lang.String r4 = "distquake_download_friendship.php"
                r3.append(r4)     // Catch:{ IOException -> 0x00c9 }
                java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x00c9 }
                r2.<init>(r3)     // Catch:{ IOException -> 0x00c9 }
                java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x00c9 }
                java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch:{ IOException -> 0x00c9 }
                java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch:{ IOException -> 0x00c9 }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x00c9 }
                r2.setDoOutput(r0)     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                r1 = 10000(0x2710, float:1.4013E-41)
                r2.setConnectTimeout(r1)     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                r2.setReadTimeout(r1)     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                java.lang.String r1 = "Content-Type"
                java.lang.String r3 = "application/x-www-form-urlencoded;charset=utf-8"
                r2.setRequestProperty(r1, r3)     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                java.lang.String r1 = "POST"
                r2.setRequestMethod(r1)     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                byte[] r1 = r7.getBytes()     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                int r1 = r1.length     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                r2.setFixedLengthStreamingMode(r1)     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                java.io.OutputStream r3 = r2.getOutputStream()     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                r1.print(r7)     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                r1.close()     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                java.io.InputStream r1 = r2.getInputStream()     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                r7.<init>(r1)     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                r3.<init>(r7, r4)     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                r3.<init>()     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
            L_0x0097:
                java.lang.String r4 = r1.readLine()     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                if (r4 == 0) goto L_0x00ab
                r3.append(r4)     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                java.lang.String r4 = "\n"
                r3.append(r4)     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                goto L_0x0097
            L_0x00a6:
                r7 = move-exception
                r1 = r2
                goto L_0x00d3
            L_0x00a9:
                r1 = r2
                goto L_0x00c9
            L_0x00ab:
                r7.close()     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                java.lang.String r7 = r3.toString()     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                r6.f13115a = r7     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                r1 = 0
                r6.f13116b = r1     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                java.lang.String r1 = "empty\n"
                boolean r7 = r7.equals(r1)     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                if (r7 == 0) goto L_0x00c3
                r6.f13117c = r0     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
                r6.f13116b = r0     // Catch:{ IOException -> 0x00a9, all -> 0x00a6 }
            L_0x00c3:
                r2.disconnect()
                goto L_0x00d0
            L_0x00c7:
                r7 = move-exception
                goto L_0x00d3
            L_0x00c9:
                r6.f13116b = r0     // Catch:{ all -> 0x00c7 }
                if (r1 == 0) goto L_0x00d0
                r1.disconnect()
            L_0x00d0:
                java.lang.String r7 = "COMPLETE!"
                return r7
            L_0x00d3:
                if (r1 == 0) goto L_0x00d8
                r1.disconnect()
            L_0x00d8:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.FriendshipActivity.l.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:14:0x00f5  */
        /* JADX WARNING: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onPostExecute(java.lang.String r25) {
            /*
                r24 = this;
                r1 = r24
                super.onPostExecute(r25)
                boolean r3 = r1.f13116b
                if (r3 != 0) goto L_0x00ff
                org.json.JSONArray r3 = new org.json.JSONArray     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                java.lang.String r4 = r1.f13115a     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r3.<init>(r4)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                int r4 = r3.length()     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                int[] r8 = new int[r4]     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                int[] r9 = new int[r4]     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                java.lang.String[] r10 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                java.lang.String[] r11 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                int[] r12 = new int[r4]     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                int[] r13 = new int[r4]     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                int[] r14 = new int[r4]     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                int[] r15 = new int[r4]     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                long[] r5 = new long[r4]     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                java.lang.String[] r6 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                java.text.SimpleDateFormat r7 = new java.text.SimpleDateFormat     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r18 = 0
                java.lang.String r0 = "yyyy-MM-dd HH:mm"
                r19 = 1
                java.util.Locale r2 = java.util.Locale.getDefault()     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r7.<init>(r0, r2)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                java.util.Date r0 = new java.util.Date     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r0.<init>()     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r2 = r18
            L_0x003e:
                if (r2 >= r4) goto L_0x00d2
                r25 = r0
                org.json.JSONObject r0 = r3.getJSONObject(r2)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r16 = r2
                java.lang.String r2 = "uf"
                java.lang.String r2 = r0.getString(r2)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r8[r16] = r2     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                java.lang.String r2 = "ut"
                java.lang.String r2 = r0.getString(r2)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r9[r16] = r2     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                java.lang.String r2 = "nf"
                java.lang.String r2 = r0.getString(r2)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r10[r16] = r2     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                java.lang.String r2 = "nt"
                java.lang.String r2 = r0.getString(r2)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r11[r16] = r2     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                java.lang.String r2 = "re"
                java.lang.String r2 = r0.getString(r2)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r12[r16] = r2     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                java.lang.String r2 = "de"
                java.lang.String r2 = r0.getString(r2)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r13[r16] = r2     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                java.lang.String r2 = "fr"
                java.lang.String r2 = r0.getString(r2)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r14[r16] = r2     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                java.lang.String r2 = "ra"
                java.lang.String r2 = r0.getString(r2)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r15[r16] = r2     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                java.lang.String r2 = "di"
                java.lang.String r0 = r0.getString(r2)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                long r20 = java.lang.Long.parseLong(r0)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r22 = 60000(0xea60, double:2.9644E-319)
                long r20 = r20 * r22
                r5[r16] = r20     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                java.util.Date r0 = new java.util.Date     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                long r20 = r25.getTime()     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r22 = r5[r16]     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r17 = r3
                long r2 = r20 - r22
                r0.<init>(r2)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                java.lang.String r0 = r7.format(r0)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r6[r16] = r0     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                int r2 = r16 + 1
                r0 = r25
                r3 = r17
                goto L_0x003e
            L_0x00ce:
                r0 = move-exception
                goto L_0x00ef
            L_0x00d0:
                r0 = move-exception
                goto L_0x00ef
            L_0x00d2:
                com.finazzi.distquake.FriendshipActivity$m r5 = new com.finazzi.distquake.FriendshipActivity$m     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r16 = r6
                com.finazzi.distquake.FriendshipActivity r6 = com.finazzi.distquake.FriendshipActivity.this     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                java.lang.String r7 = "friendship"
                r17 = 0
                r5.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                com.finazzi.distquake.FriendshipActivity r0 = com.finazzi.distquake.FriendshipActivity.this     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                android.content.Context r0 = r0.getApplicationContext()     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r2 = r19
                android.content.Context[] r2 = new android.content.Context[r2]     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r2[r18] = r0     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r5.execute(r2)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                return
            L_0x00ef:
                java.lang.String r2 = r0.getMessage()
                if (r2 == 0) goto L_0x0109
                java.lang.String r2 = "EQN"
                java.lang.String r0 = r0.getMessage()
                android.util.Log.d(r2, r0)
                goto L_0x0109
            L_0x00ff:
                int r0 = r1.f13117c
                r2 = 1
                if (r0 != r2) goto L_0x0109
                com.finazzi.distquake.FriendshipActivity r0 = com.finazzi.distquake.FriendshipActivity.this
                r0.x0()
            L_0x0109:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.FriendshipActivity.l.onPostExecute(java.lang.String):void");
        }

        private l(String str, String str2, int i8) {
            this.f13115a = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
            this.f13116b = true;
            this.f13117c = 0;
            this.f13118d = str;
            this.f13119e = str2;
            this.f13120f = i8;
        }
    }

    private class m extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private final String f13122a;

        /* renamed from: b  reason: collision with root package name */
        private final String[] f13123b;

        /* renamed from: c  reason: collision with root package name */
        private final String[] f13124c;

        /* renamed from: d  reason: collision with root package name */
        private final String[] f13125d;

        /* renamed from: e  reason: collision with root package name */
        private final int[] f13126e;

        /* renamed from: f  reason: collision with root package name */
        private final int[] f13127f;

        /* renamed from: g  reason: collision with root package name */
        private final int[] f13128g;

        /* renamed from: h  reason: collision with root package name */
        private final int[] f13129h;

        /* renamed from: i  reason: collision with root package name */
        private final int[] f13130i;

        /* renamed from: j  reason: collision with root package name */
        private final int[] f13131j;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Context... contextArr) {
            SQLiteDatabase writableDatabase = FriendshipActivity.this.f13045O.getWritableDatabase();
            if (writableDatabase == null) {
                return "COMPLETE!";
            }
            writableDatabase.delete(this.f13122a, (String) null, (String[]) null);
            ContentValues contentValues = new ContentValues();
            int i8 = 0;
            while (true) {
                int[] iArr = this.f13126e;
                if (i8 >= iArr.length) {
                    return "COMPLETE!";
                }
                contentValues.put("user_id_from", Integer.valueOf(iArr[i8]));
                contentValues.put("user_id_to", Integer.valueOf(this.f13127f[i8]));
                contentValues.put("nick_from", this.f13123b[i8]);
                contentValues.put("nick_to", this.f13124c[i8]);
                contentValues.put("requested", Integer.valueOf(this.f13128g[i8]));
                contentValues.put("declined", Integer.valueOf(this.f13129h[i8]));
                contentValues.put("friend", Integer.valueOf(this.f13130i[i8]));
                contentValues.put("randcode", Integer.valueOf(this.f13131j[i8]));
                contentValues.put("date", this.f13125d[i8]);
                writableDatabase.insert(this.f13122a, (String) null, contentValues);
                i8++;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            SharedPreferences.Editor edit = FriendshipActivity.this.getSharedPreferences(MainActivity.class.getSimpleName(), 0).edit();
            edit.putLong("friendship_last_download", System.currentTimeMillis());
            edit.apply();
            if (!FriendshipActivity.this.f13052V) {
                FriendshipActivity friendshipActivity = FriendshipActivity.this;
                friendshipActivity.J0(friendshipActivity.f13053W);
            }
        }

        private m(String str, int[] iArr, int[] iArr2, String[] strArr, String[] strArr2, int[] iArr3, int[] iArr4, int[] iArr5, int[] iArr6, String[] strArr3) {
            this.f13122a = str;
            this.f13126e = iArr;
            this.f13127f = iArr2;
            this.f13123b = strArr;
            this.f13124c = strArr2;
            this.f13128g = iArr3;
            this.f13129h = iArr4;
            this.f13130i = iArr5;
            this.f13131j = iArr6;
            this.f13125d = strArr3;
        }
    }

    private class n extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private Cursor f13133a;

        /* renamed from: b  reason: collision with root package name */
        private final int f13134b;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Context... contextArr) {
            String str;
            boolean unused = FriendshipActivity.this.f13052V = true;
            SQLiteDatabase readableDatabase = FriendshipActivity.this.f13045O.getReadableDatabase();
            if (readableDatabase == null) {
                return "COMPLETE!";
            }
            String[] strArr = {"_id", "user_id_from", "user_id_to", "nick_from", "nick_to", "requested", "declined", "friend", "randcode", "date"};
            int i8 = this.f13134b;
            if (i8 == 1) {
                str = "friend=1 AND user_id_from=" + FriendshipActivity.this.f13054X;
            } else if (i8 == 2) {
                str = "requested=1 AND user_id_to=" + FriendshipActivity.this.f13054X;
            } else if (i8 == 3) {
                str = "requested=1 AND user_id_from=" + FriendshipActivity.this.f13054X;
            } else if (i8 == 4) {
                str = "declined=1 AND user_id_to=" + FriendshipActivity.this.f13054X;
            } else if (i8 != 5) {
                str = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
            } else {
                str = "declined=1 AND user_id_from=" + FriendshipActivity.this.f13054X;
            }
            this.f13133a = readableDatabase.query("friendship", strArr, str, (String[]) null, (String) null, (String) null, "date DESC");
            return "COMPLETE!";
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            if (FriendshipActivity.this.f13055Y) {
                ((ProgressBar) FriendshipActivity.this.findViewById(C2030R.id.progressBar1)).setVisibility(8);
                Cursor cursor = this.f13133a;
                if (cursor != null) {
                    cursor.moveToPosition(-1);
                    while (this.f13133a.moveToNext()) {
                        Cursor cursor2 = this.f13133a;
                        int i8 = cursor2.getInt(cursor2.getColumnIndexOrThrow("_id"));
                        Cursor cursor3 = this.f13133a;
                        int i9 = cursor3.getInt(cursor3.getColumnIndexOrThrow("user_id_from"));
                        Cursor cursor4 = this.f13133a;
                        int i10 = cursor4.getInt(cursor4.getColumnIndexOrThrow("user_id_to"));
                        Cursor cursor5 = this.f13133a;
                        String string = cursor5.getString(cursor5.getColumnIndexOrThrow("nick_from"));
                        Cursor cursor6 = this.f13133a;
                        String string2 = cursor6.getString(cursor6.getColumnIndexOrThrow("nick_to"));
                        Cursor cursor7 = this.f13133a;
                        int i11 = cursor7.getInt(cursor7.getColumnIndexOrThrow("requested"));
                        Cursor cursor8 = this.f13133a;
                        int i12 = cursor8.getInt(cursor8.getColumnIndexOrThrow("declined"));
                        Cursor cursor9 = this.f13133a;
                        int i13 = cursor9.getInt(cursor9.getColumnIndexOrThrow("friend"));
                        Cursor cursor10 = this.f13133a;
                        int i14 = cursor10.getInt(cursor10.getColumnIndexOrThrow("randcode"));
                        Cursor cursor11 = this.f13133a;
                        String string3 = cursor11.getString(cursor11.getColumnIndexOrThrow("date"));
                        d dVar = new d();
                        dVar.B(i8);
                        dVar.z(i9);
                        dVar.A(i10);
                        dVar.v(string);
                        dVar.w(string2);
                        dVar.y(i11);
                        dVar.t(i12);
                        dVar.u(i13);
                        dVar.x(i14);
                        dVar.s(string3);
                        FriendshipActivity.this.f13047Q.j(dVar);
                    }
                    this.f13133a.close();
                }
                boolean unused = FriendshipActivity.this.f13052V = false;
            }
        }

        private n(int i8) {
            this.f13134b = i8;
        }
    }

    /* access modifiers changed from: private */
    public String A0() {
        return getSharedPreferences(MainActivity.class.getSimpleName(), 0).getString("android_id_eqn", "0");
    }

    private int B0(int i8, int i9) {
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
        if (i10 <= 765) {
            return 128359;
        }
        return i10 <= 779 ? 128336 : 128339;
    }

    private int C0(String str) {
        boolean z7;
        if (str != null) {
            Date date = new Date();
            try {
                date = this.f13048R.parse(str);
                z7 = true;
            } catch (ParseException unused) {
                z7 = false;
            }
            if (z7) {
                return (int) Math.round(((double) (new Date().getTime() - date.getTime())) / 60000.0d);
            }
        }
        return 9999;
    }

    private String D0(int i8) {
        return new String(Character.toChars(i8));
    }

    /* access modifiers changed from: private */
    public String E0(String str) {
        boolean z7;
        if (str == null) {
            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
        }
        boolean I02 = I0(str);
        int C02 = C0(str);
        Date date = new Date();
        try {
            date = this.f13048R.parse(str);
            z7 = true;
        } catch (ParseException unused) {
            z7 = false;
        }
        this.f13051U.setTime(date);
        int B02 = B0(this.f13051U.get(10), this.f13051U.get(12));
        if (!z7) {
            return D0(B02) + " " + str;
        } else if (C02 < 60) {
            return D0(B02) + " " + C02 + "m";
        } else if (!I02) {
            return D0(B02) + " " + this.f13050T.format(date);
        } else {
            return D0(B02) + " " + this.f13049S.format(date);
        }
    }

    /* access modifiers changed from: private */
    public int F0() {
        return getSharedPreferences(MainActivity.class.getSimpleName(), 0).getInt("chat_user_code", 0);
    }

    /* access modifiers changed from: private */
    public String G0() {
        C1155z f8 = FirebaseAuth.getInstance().f();
        if (f8 != null) {
            return f8.f1();
        }
        return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    }

    /* access modifiers changed from: private */
    public boolean H0() {
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

    private boolean I0(String str) {
        try {
            return !DateUtils.isToday(this.f13048R.parse(str).getTime());
        } catch (ParseException unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void J0(int i8) {
        ((ProgressBar) findViewById(C2030R.id.progressBar1)).setVisibility(0);
        this.f13046P.clear();
        this.f13047Q.notifyDataSetInvalidated();
        new n(i8).execute(new Context[]{this});
    }

    /* access modifiers changed from: private */
    public void K0(int i8) {
        d dVar = (d) this.f13046P.get(i8);
        int i9 = this.f13053W;
        if (i9 == 1) {
            int r7 = dVar.r();
            String o7 = dVar.o();
            if (r7 != 0) {
                Intent intent = new Intent().setClass(this, ChatPersonalActivity.class);
                intent.putExtra("com.finazzi.distquake.user_code_to", r7);
                intent.putExtra("com.finazzi.distquake.user_nick", o7);
                startActivity(intent);
            }
        } else if (i9 == 3 || i9 == 5) {
            new f(dVar.r()).execute(new Context[]{this});
        } else {
            new f(dVar.q()).execute(new Context[]{this});
        }
    }

    /* access modifiers changed from: private */
    public void e0(int i8, int i9, String str, String str2, int i10) {
        String A02 = A0();
        if (this.f13053W == 2) {
            new g(A02, i8, i9, str, str2, i10).execute(new Context[]{this});
            return;
        }
    }

    /* access modifiers changed from: private */
    public void x0() {
        SQLiteDatabase writableDatabase = this.f13045O.getWritableDatabase();
        if (writableDatabase != null) {
            writableDatabase.delete("friendship", (String) null, (String[]) null);
        }
        this.f13046P.clear();
        this.f13047Q.notifyDataSetInvalidated();
    }

    /* access modifiers changed from: private */
    public void y0(int i8, int i9, int i10) {
        String A02 = A0();
        int i11 = this.f13053W;
        if (i11 == 1) {
            new h(A02, i8, i9, i10).execute(new Context[]{this});
        } else if (i11 == 2) {
            new i(A02, i8, i9, i10).execute(new Context[]{this});
        } else if (i11 == 3) {
            new j(A02, i8, i9, i10).execute(new Context[]{this});
        } else if (i11 == 4) {
            new k(A02, i8, i9, i10).execute(new Context[]{this});
        }
    }

    /* access modifiers changed from: private */
    public void z0(String str, String str2, int i8) {
        if (this.f13055Y) {
            new l(str, str2, i8).execute(new Context[]{this});
            return;
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2030R.layout.friendship);
        int i8 = getResources().getConfiguration().uiMode & 48;
        if (Build.VERSION.SDK_INT >= 35 && i8 == 16) {
            Window window = getWindow();
            C0832r0.a(window, window.getDecorView()).d(true);
        }
        Toolbar toolbar = (Toolbar) findViewById(C2030R.id.toolbar);
        b0(toolbar);
        toolbar.setLogo((int) C2030R.drawable.account);
        b0(toolbar);
        if (R() != null) {
            R().u(getString(C2030R.string.chat_menu_personal));
        }
        this.f13048R = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
        this.f13049S = new SimpleDateFormat("dd-MMM", Locale.getDefault());
        this.f13050T = new SimpleDateFormat("HH:mm", Locale.getDefault());
        this.f13051U = Calendar.getInstance();
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (intent.hasExtra("com.finazzi.distquake.friendship_code") && extras != null) {
            this.f13053W = extras.getInt("com.finazzi.distquake.friendship_code");
        }
        this.f13054X = F0();
        this.f13045O = new C(getApplicationContext());
        this.f13046P = new ArrayList();
        this.f13047Q = new b(this, this.f13046P);
        ListView listView = (ListView) findViewById(C2030R.id.listview);
        listView.setAdapter(this.f13047Q);
        listView.setOnItemClickListener(new c());
        int i9 = this.f13053W;
        if (i9 == 1) {
            if (R() != null) {
                C0765a R7 = R();
                R7.u("    " + getString(C2030R.string.friend_friend_list));
            }
            toolbar.setLogo((int) C2030R.drawable.account_heart);
        } else if (i9 == 2) {
            if (R() != null) {
                C0765a R8 = R();
                R8.u("    " + getString(C2030R.string.friend_waiting_inbound));
            }
            toolbar.setLogo((int) C2030R.drawable.account_arrow_left_outline);
        } else if (i9 == 3) {
            if (R() != null) {
                C0765a R9 = R();
                R9.u("    " + getString(C2030R.string.friend_waiting_outbound));
            }
            toolbar.setLogo((int) C2030R.drawable.account_arrow_right_outline);
        } else if (i9 == 4) {
            if (R() != null) {
                C0765a R10 = R();
                R10.u("    " + getString(C2030R.string.friend_denied_outbound));
            }
            toolbar.setLogo((int) C2030R.drawable.account_remove_outline);
        } else if (i9 == 5) {
            if (R() != null) {
                C0765a R11 = R();
                R11.u("    " + getString(C2030R.string.friend_denied_inbound));
            }
            toolbar.setLogo((int) C2030R.drawable.account_cancel_outline);
        }
    }

    public void onPause() {
        this.f13055Y = false;
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f13055Y = true;
        invalidateOptionsMenu();
        if (!this.f13052V) {
            J0(this.f13053W);
        }
    }
}
