package com.finazzi.distquake;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
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
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.C0765a;
import androidx.appcompat.app.C0768d;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.C0832r0;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.material.button.MaterialButton;
import com.google.firebase.auth.C1155z;
import com.google.firebase.auth.FirebaseAuth;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import u2.C1732G;
import u2.C1733H;
import u2.C1734I;
import u2.C1735J;
import u2.C1736K;

public class ChatPreviewActivity extends C0768d {
    /* access modifiers changed from: private */

    /* renamed from: O  reason: collision with root package name */
    public SQLiteDatabase f12753O;
    /* access modifiers changed from: private */

    /* renamed from: P  reason: collision with root package name */
    public C f12754P;
    /* access modifiers changed from: private */

    /* renamed from: Q  reason: collision with root package name */
    public h f12755Q;
    /* access modifiers changed from: private */

    /* renamed from: R  reason: collision with root package name */
    public e f12756R;
    /* access modifiers changed from: private */

    /* renamed from: S  reason: collision with root package name */
    public int f12757S;
    /* access modifiers changed from: private */

    /* renamed from: T  reason: collision with root package name */
    public List f12758T;
    /* access modifiers changed from: private */

    /* renamed from: U  reason: collision with root package name */
    public b f12759U;

    /* renamed from: V  reason: collision with root package name */
    private i f12760V;

    /* renamed from: W  reason: collision with root package name */
    private SimpleDateFormat f12761W;

    /* renamed from: X  reason: collision with root package name */
    private SimpleDateFormat f12762X;

    /* renamed from: Y  reason: collision with root package name */
    private SimpleDateFormat f12763Y;

    /* renamed from: Z  reason: collision with root package name */
    private Calendar f12764Z;
    /* access modifiers changed from: private */

    /* renamed from: a0  reason: collision with root package name */
    public boolean f12765a0 = false;

    /* renamed from: b0  reason: collision with root package name */
    private FirebaseAuth f12766b0;
    /* access modifiers changed from: private */

    /* renamed from: c0  reason: collision with root package name */
    public boolean f12767c0 = false;
    /* access modifiers changed from: private */

    /* renamed from: d0  reason: collision with root package name */
    public boolean f12768d0 = false;
    /* access modifiers changed from: private */

    /* renamed from: e0  reason: collision with root package name */
    public boolean f12769e0;
    /* access modifiers changed from: private */

    /* renamed from: f0  reason: collision with root package name */
    public int f12770f0;
    /* access modifiers changed from: private */

    /* renamed from: g0  reason: collision with root package name */
    public int f12771g0;

    private class b extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        private LayoutInflater f12772a;

        /* renamed from: b  reason: collision with root package name */
        private List f12773b;

        public static /* synthetic */ void a(DialogInterface dialogInterface, int i8) {
        }

        public static /* synthetic */ void b(b bVar, int i8, View view) {
            bVar.getClass();
            AlertDialog.Builder builder = new AlertDialog.Builder(ChatPreviewActivity.this);
            builder.setMessage(ChatPreviewActivity.this.getString(C2030R.string.chat_delete_msg));
            builder.setCancelable(true);
            builder.setNegativeButton(ChatPreviewActivity.this.getString(C2030R.string.manual_yes), new E(bVar, i8));
            builder.setPositiveButton(ChatPreviewActivity.this.getString(C2030R.string.status_cancel), new F());
            builder.create().show();
        }

        public static /* synthetic */ void c(b bVar, int i8, DialogInterface dialogInterface, int i9) {
            int unused = ChatPreviewActivity.this.f12757S = ((d) bVar.f12773b.get(i8)).o();
            e unused2 = ChatPreviewActivity.this.f12756R = new e();
            ChatPreviewActivity.this.f12756R.execute(new Context[]{ChatPreviewActivity.this.getApplicationContext()});
        }

        /* access modifiers changed from: package-private */
        public void d(d dVar) {
            this.f12773b.add(dVar);
            notifyDataSetChanged();
        }

        public int getCount() {
            return this.f12773b.size();
        }

        public Object getItem(int i8) {
            return this.f12773b.get(i8);
        }

        public long getItemId(int i8) {
            return (long) i8;
        }

        public View getView(int i8, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = ChatPreviewActivity.this.getLayoutInflater();
            this.f12772a = layoutInflater;
            View inflate = layoutInflater.inflate(C2030R.layout.chat_preview_entry, viewGroup, false);
            TextView textView = (TextView) inflate.findViewById(C2030R.id.textView1);
            String h8 = ((d) this.f12773b.get(i8)).l();
            if (((d) this.f12773b.get(i8)).k() != null) {
                textView.setText(ChatPreviewActivity.this.N0(((d) this.f12773b.get(i8)).k()) + " - " + h8);
            }
            TextView textView2 = (TextView) inflate.findViewById(C2030R.id.textView2);
            textView2.setText(((d) this.f12773b.get(i8)).m());
            if (((d) this.f12773b.get(i8)).n() == 0) {
                textView2.setTypeface((Typeface) null, 1);
            } else {
                textView2.setTypeface((Typeface) null, 0);
            }
            ((Button) inflate.findViewById(C2030R.id.button1)).setOnClickListener(new D(this, i8));
            return inflate;
        }

        private b(Activity activity, List list) {
            this.f12772a = LayoutInflater.from(activity);
            this.f12773b = list;
        }
    }

    private class c implements AdapterView.OnItemClickListener {
        private c() {
        }

        public void onItemClick(AdapterView adapterView, View view, int i8, long j8) {
            ChatPreviewActivity.this.T0(i8);
        }
    }

    private static class d {

        /* renamed from: a  reason: collision with root package name */
        private String f12776a;

        /* renamed from: b  reason: collision with root package name */
        private String f12777b;

        /* renamed from: c  reason: collision with root package name */
        private String f12778c;

        /* renamed from: d  reason: collision with root package name */
        private int f12779d;

        /* renamed from: e  reason: collision with root package name */
        private int f12780e;

        private d() {
        }

        /* access modifiers changed from: private */
        public String k() {
            return this.f12778c;
        }

        /* access modifiers changed from: private */
        public String l() {
            return this.f12776a;
        }

        /* access modifiers changed from: private */
        public String m() {
            return this.f12777b;
        }

        /* access modifiers changed from: private */
        public int n() {
            return this.f12779d;
        }

        /* access modifiers changed from: private */
        public int o() {
            return this.f12780e;
        }

        /* access modifiers changed from: private */
        public void p(String str) {
            this.f12778c = str;
        }

        /* access modifiers changed from: private */
        public void q(String str) {
            this.f12776a = str;
        }

        /* access modifiers changed from: private */
        public void r(String str) {
            this.f12777b = str;
        }

        /* access modifiers changed from: private */
        public void s(int i8) {
            this.f12779d = i8;
        }

        /* access modifiers changed from: private */
        public void t(int i8) {
            this.f12780e = i8;
        }
    }

    private class e extends AsyncTask {
        private e() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Context... contextArr) {
            ChatPreviewActivity chatPreviewActivity = ChatPreviewActivity.this;
            SQLiteDatabase unused = chatPreviewActivity.f12753O = chatPreviewActivity.f12754P.getWritableDatabase();
            if (ChatPreviewActivity.this.f12753O == null) {
                return "COMPLETE!";
            }
            ChatPreviewActivity.this.f12753O.delete("chat_preview", "user_id_from=?", new String[]{Integer.toString(ChatPreviewActivity.this.f12757S)});
            return "COMPLETE!";
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            ChatPreviewActivity.this.f12758T.clear();
            ChatPreviewActivity.this.S0();
        }
    }

    private class f extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private String f12782a;

        /* renamed from: b  reason: collision with root package name */
        private boolean f12783b;

        /* renamed from: c  reason: collision with root package name */
        private int f12784c;

        /* renamed from: d  reason: collision with root package name */
        private final String f12785d;

        /* renamed from: e  reason: collision with root package name */
        private final String f12786e;

        /* renamed from: f  reason: collision with root package name */
        private final int f12787f;

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(5:11|10|17|18|(0)(0)) */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x00cc, code lost:
            r7 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x00d2, code lost:
            r1.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x00da, code lost:
            r1.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x00ce */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00d2  */
        /* JADX WARNING: Removed duplicated region for block: B:22:0x00da  */
        /* JADX WARNING: Removed duplicated region for block: B:27:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r7) {
            /*
                r6 = this;
                com.finazzi.distquake.ChatPreviewActivity r7 = com.finazzi.distquake.ChatPreviewActivity.this
                r0 = 1
                boolean unused = r7.f12767c0 = r0
                java.util.HashMap r7 = new java.util.HashMap
                r7.<init>()
                java.lang.String r1 = "u_id"
                java.lang.String r2 = r6.f12785d
                r7.put(r1, r2)
                java.lang.String r1 = "uID"
                java.lang.String r2 = r6.f12786e
                r7.put(r1, r2)
                int r1 = r6.f12787f
                java.lang.String r1 = java.lang.Integer.toString(r1)
                java.lang.String r2 = "user_code_from"
                r7.put(r2, r1)
                java.lang.String r7 = u2.C1737L.a(r7)
                r1 = 0
                java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x00ce }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00ce }
                r3.<init>()     // Catch:{ IOException -> 0x00ce }
                com.finazzi.distquake.ChatPreviewActivity r4 = com.finazzi.distquake.ChatPreviewActivity.this     // Catch:{ IOException -> 0x00ce }
                r5 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r4 = r4.getString(r5)     // Catch:{ IOException -> 0x00ce }
                r3.append(r4)     // Catch:{ IOException -> 0x00ce }
                java.lang.String r4 = "distquake_download_friendship.php"
                r3.append(r4)     // Catch:{ IOException -> 0x00ce }
                java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x00ce }
                r2.<init>(r3)     // Catch:{ IOException -> 0x00ce }
                java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x00ce }
                java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch:{ IOException -> 0x00ce }
                java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch:{ IOException -> 0x00ce }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x00ce }
                r2.setDoOutput(r0)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r1 = 10000(0x2710, float:1.4013E-41)
                r2.setConnectTimeout(r1)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r2.setReadTimeout(r1)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.lang.String r1 = "Content-Type"
                java.lang.String r3 = "application/x-www-form-urlencoded;charset=utf-8"
                r2.setRequestProperty(r1, r3)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.lang.String r1 = "POST"
                r2.setRequestMethod(r1)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                byte[] r1 = r7.getBytes()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                int r1 = r1.length     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r2.setFixedLengthStreamingMode(r1)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.io.OutputStream r3 = r2.getOutputStream()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r1.print(r7)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r1.close()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.io.InputStream r1 = r2.getInputStream()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r7.<init>(r1)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r3.<init>(r7, r4)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r3.<init>()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
            L_0x009c:
                java.lang.String r4 = r1.readLine()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                if (r4 == 0) goto L_0x00b0
                r3.append(r4)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.lang.String r4 = "\n"
                r3.append(r4)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                goto L_0x009c
            L_0x00ab:
                r7 = move-exception
                r1 = r2
                goto L_0x00d8
            L_0x00ae:
                r1 = r2
                goto L_0x00ce
            L_0x00b0:
                r7.close()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.lang.String r7 = r3.toString()     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r6.f12782a = r7     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r1 = 0
                r6.f12783b = r1     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                java.lang.String r1 = "empty\n"
                boolean r7 = r7.equals(r1)     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                if (r7 == 0) goto L_0x00c8
                r6.f12784c = r0     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
                r6.f12783b = r0     // Catch:{ IOException -> 0x00ae, all -> 0x00ab }
            L_0x00c8:
                r2.disconnect()
                goto L_0x00d5
            L_0x00cc:
                r7 = move-exception
                goto L_0x00d8
            L_0x00ce:
                r6.f12783b = r0     // Catch:{ all -> 0x00cc }
                if (r1 == 0) goto L_0x00d5
                r1.disconnect()
            L_0x00d5:
                java.lang.String r7 = "COMPLETE!"
                return r7
            L_0x00d8:
                if (r1 == 0) goto L_0x00dd
                r1.disconnect()
            L_0x00dd:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.ChatPreviewActivity.f.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x00fb  */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onPostExecute(java.lang.String r26) {
            /*
                r25 = this;
                r1 = r25
                super.onPostExecute(r26)
                boolean r2 = r1.f12783b
                if (r2 != 0) goto L_0x0105
                org.json.JSONArray r2 = new org.json.JSONArray     // Catch:{ JSONException -> 0x00f3, ArrayIndexOutOfBoundsException -> 0x00ef }
                java.lang.String r4 = r1.f12782a     // Catch:{ JSONException -> 0x00f3, ArrayIndexOutOfBoundsException -> 0x00ef }
                r2.<init>(r4)     // Catch:{ JSONException -> 0x00f3, ArrayIndexOutOfBoundsException -> 0x00ef }
                int r4 = r2.length()     // Catch:{ JSONException -> 0x00f3, ArrayIndexOutOfBoundsException -> 0x00ef }
                int[] r8 = new int[r4]     // Catch:{ JSONException -> 0x00f3, ArrayIndexOutOfBoundsException -> 0x00ef }
                int[] r9 = new int[r4]     // Catch:{ JSONException -> 0x00f3, ArrayIndexOutOfBoundsException -> 0x00ef }
                java.lang.String[] r10 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x00f3, ArrayIndexOutOfBoundsException -> 0x00ef }
                java.lang.String[] r11 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x00f3, ArrayIndexOutOfBoundsException -> 0x00ef }
                int[] r12 = new int[r4]     // Catch:{ JSONException -> 0x00f3, ArrayIndexOutOfBoundsException -> 0x00ef }
                int[] r13 = new int[r4]     // Catch:{ JSONException -> 0x00f3, ArrayIndexOutOfBoundsException -> 0x00ef }
                int[] r14 = new int[r4]     // Catch:{ JSONException -> 0x00f3, ArrayIndexOutOfBoundsException -> 0x00ef }
                int[] r15 = new int[r4]     // Catch:{ JSONException -> 0x00f3, ArrayIndexOutOfBoundsException -> 0x00ef }
                long[] r5 = new long[r4]     // Catch:{ JSONException -> 0x00f3, ArrayIndexOutOfBoundsException -> 0x00ef }
                java.lang.String[] r6 = new java.lang.String[r4]     // Catch:{ JSONException -> 0x00f3, ArrayIndexOutOfBoundsException -> 0x00ef }
                java.text.SimpleDateFormat r7 = new java.text.SimpleDateFormat     // Catch:{ JSONException -> 0x00f3, ArrayIndexOutOfBoundsException -> 0x00ef }
                r26 = 0
                java.lang.String r3 = "yyyy-MM-dd HH:mm"
                r18 = 1
                java.util.Locale r0 = java.util.Locale.getDefault()     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r7.<init>(r3, r0)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                java.util.Date r0 = new java.util.Date     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r0.<init>()     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r3 = r26
            L_0x003e:
                if (r3 >= r4) goto L_0x00d2
                r16 = r0
                org.json.JSONObject r0 = r2.getJSONObject(r3)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r17 = r2
                java.lang.String r2 = "uf"
                java.lang.String r2 = r0.getString(r2)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r8[r3] = r2     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                java.lang.String r2 = "ut"
                java.lang.String r2 = r0.getString(r2)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r9[r3] = r2     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                java.lang.String r2 = "nf"
                java.lang.String r2 = r0.getString(r2)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r10[r3] = r2     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                java.lang.String r2 = "nt"
                java.lang.String r2 = r0.getString(r2)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r11[r3] = r2     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                java.lang.String r2 = "re"
                java.lang.String r2 = r0.getString(r2)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r12[r3] = r2     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                java.lang.String r2 = "de"
                java.lang.String r2 = r0.getString(r2)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r13[r3] = r2     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                java.lang.String r2 = "fr"
                java.lang.String r2 = r0.getString(r2)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r14[r3] = r2     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                java.lang.String r2 = "ra"
                java.lang.String r2 = r0.getString(r2)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r15[r3] = r2     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                java.lang.String r2 = "di"
                java.lang.String r0 = r0.getString(r2)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                long r19 = java.lang.Long.parseLong(r0)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r5[r3] = r19     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                java.util.Date r0 = new java.util.Date     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                long r19 = r16.getTime()     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r21 = r5[r3]     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r23 = 60000(0xea60, double:2.9644E-319)
                long r21 = r21 * r23
                r23 = r3
                long r2 = r19 - r21
                r0.<init>(r2)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                java.lang.String r0 = r7.format(r0)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r6[r23] = r0     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                int r3 = r23 + 1
                r0 = r16
                r2 = r17
                goto L_0x003e
            L_0x00ce:
                r0 = move-exception
                goto L_0x00f5
            L_0x00d0:
                r0 = move-exception
                goto L_0x00f5
            L_0x00d2:
                com.finazzi.distquake.ChatPreviewActivity$g r5 = new com.finazzi.distquake.ChatPreviewActivity$g     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r16 = r6
                com.finazzi.distquake.ChatPreviewActivity r6 = com.finazzi.distquake.ChatPreviewActivity.this     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                java.lang.String r7 = "friendship"
                r17 = 0
                r5.<init>(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                com.finazzi.distquake.ChatPreviewActivity r0 = com.finazzi.distquake.ChatPreviewActivity.this     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                android.content.Context r0 = r0.getApplicationContext()     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r2 = r18
                android.content.Context[] r2 = new android.content.Context[r2]     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r2[r26] = r0     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                r5.execute(r2)     // Catch:{ JSONException -> 0x00d0, ArrayIndexOutOfBoundsException -> 0x00ce }
                goto L_0x0111
            L_0x00ef:
                r0 = move-exception
            L_0x00f0:
                r26 = 0
                goto L_0x00f5
            L_0x00f3:
                r0 = move-exception
                goto L_0x00f0
            L_0x00f5:
                java.lang.String r2 = r0.getMessage()
                if (r2 == 0) goto L_0x0111
                java.lang.String r2 = "EQN"
                java.lang.String r0 = r0.getMessage()
                android.util.Log.d(r2, r0)
                goto L_0x0111
            L_0x0105:
                r26 = 0
                int r0 = r1.f12784c
                r2 = 1
                if (r0 != r2) goto L_0x0111
                com.finazzi.distquake.ChatPreviewActivity r0 = com.finazzi.distquake.ChatPreviewActivity.this
                r0.J0()
            L_0x0111:
                com.finazzi.distquake.ChatPreviewActivity r0 = com.finazzi.distquake.ChatPreviewActivity.this
                r2 = r26
                boolean unused = r0.f12767c0 = r2
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.ChatPreviewActivity.f.onPostExecute(java.lang.String):void");
        }

        private f(String str, String str2, int i8) {
            this.f12782a = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
            this.f12783b = true;
            this.f12784c = 0;
            this.f12785d = str;
            this.f12786e = str2;
            this.f12787f = i8;
        }
    }

    private class g extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private final String f12789a;

        /* renamed from: b  reason: collision with root package name */
        private final String[] f12790b;

        /* renamed from: c  reason: collision with root package name */
        private final String[] f12791c;

        /* renamed from: d  reason: collision with root package name */
        private final String[] f12792d;

        /* renamed from: e  reason: collision with root package name */
        private final int[] f12793e;

        /* renamed from: f  reason: collision with root package name */
        private final int[] f12794f;

        /* renamed from: g  reason: collision with root package name */
        private final int[] f12795g;

        /* renamed from: h  reason: collision with root package name */
        private final int[] f12796h;

        /* renamed from: i  reason: collision with root package name */
        private final int[] f12797i;

        /* renamed from: j  reason: collision with root package name */
        private final int[] f12798j;

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Context... contextArr) {
            boolean unused = ChatPreviewActivity.this.f12768d0 = true;
            int i8 = 0;
            int unused2 = ChatPreviewActivity.this.f12770f0 = 0;
            int unused3 = ChatPreviewActivity.this.f12771g0 = 0;
            ChatPreviewActivity chatPreviewActivity = ChatPreviewActivity.this;
            SQLiteDatabase unused4 = chatPreviewActivity.f12753O = chatPreviewActivity.f12754P.getWritableDatabase();
            if (ChatPreviewActivity.this.f12753O == null) {
                return "COMPLETE!";
            }
            ChatPreviewActivity.this.f12753O.delete(this.f12789a, (String) null, (String[]) null);
            ContentValues contentValues = new ContentValues();
            while (true) {
                int[] iArr = this.f12793e;
                if (i8 >= iArr.length) {
                    return "COMPLETE!";
                }
                contentValues.put("user_id_from", Integer.valueOf(iArr[i8]));
                contentValues.put("user_id_to", Integer.valueOf(this.f12794f[i8]));
                contentValues.put("nick_from", this.f12790b[i8]);
                contentValues.put("nick_to", this.f12791c[i8]);
                contentValues.put("requested", Integer.valueOf(this.f12795g[i8]));
                contentValues.put("declined", Integer.valueOf(this.f12796h[i8]));
                contentValues.put("friend", Integer.valueOf(this.f12797i[i8]));
                contentValues.put("randcode", Integer.valueOf(this.f12798j[i8]));
                contentValues.put("date", this.f12792d[i8]);
                ChatPreviewActivity.this.f12753O.insert(this.f12789a, (String) null, contentValues);
                if (this.f12793e[i8] == ChatPreviewActivity.this.O0() && this.f12795g[i8] == 1) {
                    ChatPreviewActivity.C0(ChatPreviewActivity.this);
                }
                if (this.f12793e[i8] != ChatPreviewActivity.this.O0() && this.f12795g[i8] == 1) {
                    ChatPreviewActivity.z0(ChatPreviewActivity.this);
                }
                i8++;
            }
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            String str2;
            super.onPostExecute(str);
            boolean unused = ChatPreviewActivity.this.f12768d0 = false;
            if (ChatPreviewActivity.this.f12769e0) {
                String str3 = "99+";
                if (ChatPreviewActivity.this.f12770f0 > 0) {
                    if (ChatPreviewActivity.this.f12770f0 < 100) {
                        str2 = Integer.toString(ChatPreviewActivity.this.f12770f0);
                    } else {
                        str2 = str3;
                    }
                    MaterialButton materialButton = (MaterialButton) ChatPreviewActivity.this.findViewById(C2030R.id.button2);
                    materialButton.setText(str2);
                    materialButton.setIconGravity(2);
                } else {
                    MaterialButton materialButton2 = (MaterialButton) ChatPreviewActivity.this.findViewById(C2030R.id.button2);
                    materialButton2.setText(" ");
                    materialButton2.setIconGravity(4);
                }
                if (ChatPreviewActivity.this.f12771g0 > 0) {
                    if (ChatPreviewActivity.this.f12771g0 < 100) {
                        str3 = Integer.toString(ChatPreviewActivity.this.f12771g0);
                    }
                    MaterialButton materialButton3 = (MaterialButton) ChatPreviewActivity.this.findViewById(C2030R.id.button3);
                    materialButton3.setText(str3);
                    materialButton3.setIconGravity(2);
                    return;
                }
                MaterialButton materialButton4 = (MaterialButton) ChatPreviewActivity.this.findViewById(C2030R.id.button3);
                materialButton4.setText(" ");
                materialButton4.setIconGravity(4);
            }
        }

        private g(String str, int[] iArr, int[] iArr2, String[] strArr, String[] strArr2, int[] iArr3, int[] iArr4, int[] iArr5, int[] iArr6, String[] strArr3) {
            this.f12789a = str;
            this.f12793e = iArr;
            this.f12794f = iArr2;
            this.f12790b = strArr;
            this.f12791c = strArr2;
            this.f12795g = iArr3;
            this.f12796h = iArr4;
            this.f12797i = iArr5;
            this.f12798j = iArr6;
            this.f12792d = strArr3;
        }
    }

    private class h extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private Cursor f12800a;

        private h() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Context... contextArr) {
            boolean unused = ChatPreviewActivity.this.f12765a0 = true;
            ChatPreviewActivity chatPreviewActivity = ChatPreviewActivity.this;
            SQLiteDatabase unused2 = chatPreviewActivity.f12753O = chatPreviewActivity.f12754P.getReadableDatabase();
            if (ChatPreviewActivity.this.f12753O == null) {
                return "COMPLETE!";
            }
            this.f12800a = ChatPreviewActivity.this.f12753O.query("chat_preview", new String[]{"user_id_from", "nick_from", "read", "date", "message"}, (String) null, (String[]) null, (String) null, (String) null, "date DESC");
            return "COMPLETE!";
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            ((ProgressBar) ChatPreviewActivity.this.findViewById(C2030R.id.progressBar4)).setVisibility(8);
            Cursor cursor = this.f12800a;
            if (cursor != null) {
                cursor.moveToPosition(-1);
                int i8 = 0;
                while (this.f12800a.moveToNext()) {
                    Cursor cursor2 = this.f12800a;
                    int i9 = cursor2.getInt(cursor2.getColumnIndexOrThrow("user_id_from"));
                    Cursor cursor3 = this.f12800a;
                    String string = cursor3.getString(cursor3.getColumnIndexOrThrow("read"));
                    Cursor cursor4 = this.f12800a;
                    String string2 = cursor4.getString(cursor4.getColumnIndexOrThrow("nick_from"));
                    Cursor cursor5 = this.f12800a;
                    String string3 = cursor5.getString(cursor5.getColumnIndexOrThrow("date"));
                    Cursor cursor6 = this.f12800a;
                    String string4 = cursor6.getString(cursor6.getColumnIndexOrThrow("message"));
                    d dVar = new d();
                    dVar.t(i9);
                    dVar.q(string4);
                    dVar.r(string2);
                    dVar.p(string3);
                    dVar.s(Integer.parseInt(string));
                    ChatPreviewActivity.this.f12759U.d(dVar);
                    i8++;
                }
                this.f12800a.close();
                LinearLayout linearLayout = (LinearLayout) ChatPreviewActivity.this.findViewById(C2030R.id.linearStart);
                if (i8 == 0) {
                    linearLayout.setVisibility(0);
                } else {
                    linearLayout.setVisibility(8);
                }
            }
            boolean unused = ChatPreviewActivity.this.f12765a0 = false;
        }
    }

    public class i extends BroadcastReceiver {
        public i() {
        }

        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action != null && action.equals("com.finazzi.distquake.update_private_chat")) {
                ChatPreviewActivity.this.f12758T.clear();
                h unused = ChatPreviewActivity.this.f12755Q = new h();
                ChatPreviewActivity.this.f12755Q.execute(new Context[]{context});
            }
        }
    }

    static /* synthetic */ int C0(ChatPreviewActivity chatPreviewActivity) {
        int i8 = chatPreviewActivity.f12771g0;
        chatPreviewActivity.f12771g0 = i8 + 1;
        return i8;
    }

    /* access modifiers changed from: private */
    public void J0() {
        SQLiteDatabase writableDatabase = this.f12754P.getWritableDatabase();
        this.f12753O = writableDatabase;
        if (writableDatabase != null) {
            writableDatabase.delete("friendship", (String) null, (String[]) null);
        }
    }

    private void K0(String str, String str2, int i8) {
        if (P0()) {
            new f(str, str2, i8).execute(new Context[]{this});
            return;
        }
    }

    private String L0() {
        return getSharedPreferences(MainActivity.class.getSimpleName(), 0).getString("android_id_eqn", "0");
    }

    private int M0(String str) {
        boolean z7;
        if (str != null) {
            Date date = new Date();
            try {
                date = this.f12761W.parse(str);
                z7 = true;
            } catch (ParseException unused) {
                z7 = false;
            }
            if (z7) {
                return (int) Math.round((((double) (new Date().getTime() - date.getTime())) / 1000.0d) / 60.0d);
            }
        }
        return 9999;
    }

    /* access modifiers changed from: private */
    public String N0(String str) {
        boolean z7;
        if (str == null) {
            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
        }
        boolean R02 = R0(str);
        int M02 = M0(str);
        Date date = new Date();
        try {
            date = this.f12761W.parse(str);
            z7 = true;
        } catch (ParseException unused) {
            z7 = false;
        }
        this.f12764Z.setTime(date);
        if (!z7) {
            return str;
        }
        if (M02 < 60) {
            return M02 + "m";
        } else if (!R02) {
            return this.f12763Y.format(date);
        } else {
            return this.f12762X.format(date);
        }
    }

    /* access modifiers changed from: private */
    public int O0() {
        return getSharedPreferences(MainActivity.class.getSimpleName(), 0).getInt("chat_user_code", 0);
    }

    private boolean P0() {
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

    private boolean Q0() {
        FirebaseAuth firebaseAuth = this.f12766b0;
        if (!(firebaseAuth == null || firebaseAuth.f() == null)) {
            SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.class.getSimpleName(), 0);
            if (!sharedPreferences.getBoolean("nicklinked", false) || sharedPreferences.getString("nick", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equalsIgnoreCase(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED)) {
                return false;
            }
            return true;
        }
        return false;
    }

    private boolean R0(String str) {
        try {
            return !DateUtils.isToday(this.f12761W.parse(str).getTime());
        } catch (ParseException unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void S0() {
        ((ProgressBar) findViewById(C2030R.id.progressBar4)).setVisibility(0);
        this.f12758T.clear();
        h hVar = new h();
        this.f12755Q = hVar;
        hVar.execute(new Context[]{this});
    }

    /* access modifiers changed from: private */
    public void T0(int i8) {
        d dVar = (d) this.f12758T.get(i8);
        int a8 = dVar.o();
        String g8 = dVar.m();
        if (a8 != 0) {
            Intent intent = new Intent().setClass(this, ChatPersonalActivity.class);
            intent.putExtra("com.finazzi.distquake.user_code_to", a8);
            intent.putExtra("com.finazzi.distquake.user_nick", g8);
            startActivity(intent);
        }
    }

    public static /* synthetic */ void e0(ChatPreviewActivity chatPreviewActivity, View view) {
        if (!chatPreviewActivity.f12767c0 && !chatPreviewActivity.f12768d0) {
            Intent intent = new Intent().setClass(chatPreviewActivity.getApplicationContext(), FriendshipActivity.class);
            intent.putExtra("com.finazzi.distquake.friendship_code", 5);
            chatPreviewActivity.startActivity(intent);
        }
    }

    public static /* synthetic */ void f0(ChatPreviewActivity chatPreviewActivity, View view) {
        if (!chatPreviewActivity.f12767c0 && !chatPreviewActivity.f12768d0) {
            Intent intent = new Intent().setClass(chatPreviewActivity.getApplicationContext(), FriendshipActivity.class);
            intent.putExtra("com.finazzi.distquake.friendship_code", 1);
            chatPreviewActivity.startActivity(intent);
        }
    }

    public static /* synthetic */ void g0(ChatPreviewActivity chatPreviewActivity, View view) {
        if (!chatPreviewActivity.f12767c0 && !chatPreviewActivity.f12768d0) {
            Intent intent = new Intent().setClass(chatPreviewActivity.getApplicationContext(), FriendshipActivity.class);
            intent.putExtra("com.finazzi.distquake.friendship_code", 2);
            chatPreviewActivity.startActivity(intent);
        }
    }

    public static /* synthetic */ void h0(ChatPreviewActivity chatPreviewActivity, View view) {
        if (!chatPreviewActivity.f12767c0 && !chatPreviewActivity.f12768d0) {
            Intent intent = new Intent().setClass(chatPreviewActivity.getApplicationContext(), FriendshipActivity.class);
            intent.putExtra("com.finazzi.distquake.friendship_code", 4);
            chatPreviewActivity.startActivity(intent);
        }
    }

    public static /* synthetic */ void i0(ChatPreviewActivity chatPreviewActivity, View view) {
        if (!chatPreviewActivity.f12767c0 && !chatPreviewActivity.f12768d0) {
            Intent intent = new Intent().setClass(chatPreviewActivity.getApplicationContext(), FriendshipActivity.class);
            intent.putExtra("com.finazzi.distquake.friendship_code", 3);
            chatPreviewActivity.startActivity(intent);
        }
    }

    static /* synthetic */ int z0(ChatPreviewActivity chatPreviewActivity) {
        int i8 = chatPreviewActivity.f12770f0;
        chatPreviewActivity.f12770f0 = i8 + 1;
        return i8;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) C2030R.layout.chat_preview);
        int i8 = getResources().getConfiguration().uiMode & 48;
        if (Build.VERSION.SDK_INT >= 35 && i8 == 16) {
            Window window = getWindow();
            C0832r0.a(window, window.getDecorView()).d(true);
        }
        this.f12766b0 = FirebaseAuth.getInstance();
        Toolbar toolbar = (Toolbar) findViewById(C2030R.id.toolbar);
        b0(toolbar);
        toolbar.setLogo((int) C2030R.drawable.message_text_outline);
        b0(toolbar);
        if (R() != null) {
            C0765a R7 = R();
            R7.u("    " + getString(C2030R.string.chat_menu_personal));
        }
        this.f12761W = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
        this.f12762X = new SimpleDateFormat("dd-MMM", Locale.getDefault());
        this.f12763Y = new SimpleDateFormat("HH:mm", Locale.getDefault());
        this.f12764Z = Calendar.getInstance();
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if (intent.hasExtra("com.finazzi.distquake.user_code_to_open") && extras != null) {
            int i9 = extras.getInt("com.finazzi.distquake.user_code_to_open");
            String string = extras.getString("com.finazzi.distquake.user_nick_to_open");
            if (i9 != 0) {
                Intent intent2 = new Intent().setClass(this, ChatPersonalActivity.class);
                intent2.putExtra("com.finazzi.distquake.user_code_to", i9);
                intent2.putExtra("com.finazzi.distquake.user_nick", string);
                startActivity(intent2);
            }
        }
        this.f12754P = new C(getApplicationContext());
        this.f12758T = new ArrayList();
        this.f12759U = new b(this, this.f12758T);
        ListView listView = (ListView) findViewById(C2030R.id.listview);
        listView.setAdapter(this.f12759U);
        listView.setOnItemClickListener(new c());
        ((Button) findViewById(C2030R.id.button1)).setOnClickListener(new C1732G(this));
        ((Button) findViewById(C2030R.id.button2)).setOnClickListener(new C1733H(this));
        ((Button) findViewById(C2030R.id.button3)).setOnClickListener(new C1734I(this));
        ((Button) findViewById(C2030R.id.button4)).setOnClickListener(new C1735J(this));
        ((Button) findViewById(C2030R.id.button5)).setOnClickListener(new C1736K(this));
    }

    public void onPause() {
        unregisterReceiver(this.f12760V);
        this.f12769e0 = false;
        super.onPause();
    }

    public void onResume() {
        FirebaseAuth firebaseAuth;
        C1155z f8;
        super.onResume();
        this.f12769e0 = true;
        this.f12760V = new i();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.finazzi.distquake.update_private_chat");
        if (Build.VERSION.SDK_INT >= 33) {
            Intent unused = registerReceiver(this.f12760V, intentFilter, 4);
        } else {
            registerReceiver(this.f12760V, intentFilter);
        }
        invalidateOptionsMenu();
        if (!this.f12765a0) {
            S0();
        }
        if (Q0() && (firebaseAuth = this.f12766b0) != null && (f8 = firebaseAuth.f()) != null) {
            String f12 = f8.f1();
            String L02 = L0();
            int O02 = O0();
            if (!L02.isEmpty() && O02 != 0 && !f12.isEmpty()) {
                K0(L02, f12, O02);
            }
        }
    }
}
