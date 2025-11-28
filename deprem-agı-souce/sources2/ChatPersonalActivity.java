package com.finazzi.distquake;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.NotificationManager;
import android.content.BroadcastReceiver;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.Spannable;
import android.text.format.DateUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.C0768d;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.C0832r0;
import com.google.android.gms.ads.RequestConfiguration;
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
import u2.C1726A;
import u2.C1727B;
import u2.C1728C;
import u2.C1729D;
import u2.C1730E;
import u2.C1901z;

public class ChatPersonalActivity extends C0768d {
    /* access modifiers changed from: private */

    /* renamed from: k0  reason: collision with root package name */
    public static final Spannable.Factory f12712k0 = Spannable.Factory.getInstance();

    /* renamed from: O  reason: collision with root package name */
    private i f12713O;
    /* access modifiers changed from: private */

    /* renamed from: P  reason: collision with root package name */
    public SQLiteDatabase f12714P;
    /* access modifiers changed from: private */

    /* renamed from: Q  reason: collision with root package name */
    public C f12715Q;
    /* access modifiers changed from: private */

    /* renamed from: R  reason: collision with root package name */
    public String f12716R;
    /* access modifiers changed from: private */

    /* renamed from: S  reason: collision with root package name */
    public String f12717S;
    /* access modifiers changed from: private */

    /* renamed from: T  reason: collision with root package name */
    public String f12718T;
    /* access modifiers changed from: private */

    /* renamed from: U  reason: collision with root package name */
    public List f12719U;
    /* access modifiers changed from: private */

    /* renamed from: V  reason: collision with root package name */
    public b f12720V;
    /* access modifiers changed from: private */

    /* renamed from: W  reason: collision with root package name */
    public int f12721W = 0;
    /* access modifiers changed from: private */

    /* renamed from: X  reason: collision with root package name */
    public int f12722X = 0;
    /* access modifiers changed from: private */

    /* renamed from: Y  reason: collision with root package name */
    public String f12723Y;
    /* access modifiers changed from: private */

    /* renamed from: Z  reason: collision with root package name */
    public int f12724Z;
    /* access modifiers changed from: private */

    /* renamed from: a0  reason: collision with root package name */
    public int f12725a0;
    /* access modifiers changed from: private */

    /* renamed from: b0  reason: collision with root package name */
    public boolean f12726b0 = false;

    /* renamed from: c0  reason: collision with root package name */
    private SharedPreferences f12727c0;

    /* renamed from: d0  reason: collision with root package name */
    private j f12728d0;
    /* access modifiers changed from: private */

    /* renamed from: e0  reason: collision with root package name */
    public NotificationManager f12729e0;

    /* renamed from: f0  reason: collision with root package name */
    private SimpleDateFormat f12730f0;

    /* renamed from: g0  reason: collision with root package name */
    private SimpleDateFormat f12731g0;

    /* renamed from: h0  reason: collision with root package name */
    private SimpleDateFormat f12732h0;

    /* renamed from: i0  reason: collision with root package name */
    private Calendar f12733i0;

    /* renamed from: j0  reason: collision with root package name */
    private DialogInterface.OnClickListener f12734j0 = new C1901z(this);

    private class b extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        private LayoutInflater f12735a;

        /* renamed from: b  reason: collision with root package name */
        private List f12736b;

        /* access modifiers changed from: package-private */
        public void a(c cVar) {
            this.f12736b.add(cVar);
            notifyDataSetChanged();
        }

        public int getCount() {
            return this.f12736b.size();
        }

        public Object getItem(int i8) {
            return this.f12736b.get(i8);
        }

        public long getItemId(int i8) {
            return (long) i8;
        }

        public View getView(int i8, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = ChatPersonalActivity.this.getLayoutInflater();
            this.f12735a = layoutInflater;
            View inflate = layoutInflater.inflate(C2030R.layout.chat_personal_entry, viewGroup, false);
            TextView textView = (TextView) inflate.findViewById(C2030R.id.textView1);
            String f8 = ((c) this.f12736b.get(i8)).l();
            String str = "@" + ((c) this.f12736b.get(i8)).m();
            int lastIndexOf = f8.lastIndexOf(str);
            Spannable newSpannable = ChatPersonalActivity.f12712k0.newSpannable(f8);
            if (lastIndexOf >= 0) {
                newSpannable.setSpan(new StyleSpan(1), lastIndexOf, str.length() + lastIndexOf, 33);
                newSpannable.setSpan(new ForegroundColorSpan(-16776961), lastIndexOf, str.length() + lastIndexOf, 33);
            }
            textView.setText(newSpannable);
            TextView textView2 = (TextView) inflate.findViewById(C2030R.id.textView2);
            if (((c) this.f12736b.get(i8)).f12740c != null) {
                textView2.setText(ChatPersonalActivity.this.M0(((c) this.f12736b.get(i8)).j()) + " - " + ((c) this.f12736b.get(i8)).m());
            }
            return inflate;
        }

        private b(Activity activity, List list) {
            this.f12735a = LayoutInflater.from(activity);
            this.f12736b = list;
        }
    }

    private static class c {

        /* renamed from: a  reason: collision with root package name */
        private String f12738a;

        /* renamed from: b  reason: collision with root package name */
        private String f12739b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f12740c;

        /* renamed from: d  reason: collision with root package name */
        private int f12741d;

        private c() {
        }

        /* access modifiers changed from: private */
        public String j() {
            return this.f12740c;
        }

        /* access modifiers changed from: private */
        public int k() {
            return this.f12741d;
        }

        /* access modifiers changed from: private */
        public String l() {
            return this.f12738a;
        }

        /* access modifiers changed from: private */
        public String m() {
            return this.f12739b;
        }

        /* access modifiers changed from: private */
        public void n(String str) {
            this.f12740c = str;
        }

        /* access modifiers changed from: private */
        public void o(int i8) {
            this.f12741d = i8;
        }

        /* access modifiers changed from: private */
        public void p(String str) {
            this.f12738a = str;
        }

        /* access modifiers changed from: private */
        public void q(String str) {
            this.f12739b = str;
        }
    }

    private class d extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private Cursor f12742a;

        private d() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Context... contextArr) {
            boolean unused = ChatPersonalActivity.this.f12726b0 = true;
            ChatPersonalActivity chatPersonalActivity = ChatPersonalActivity.this;
            SQLiteDatabase unused2 = chatPersonalActivity.f12714P = chatPersonalActivity.f12715Q.getReadableDatabase();
            if (ChatPersonalActivity.this.f12714P == null) {
                return "COMPLETE!";
            }
            this.f12742a = ChatPersonalActivity.this.f12714P.query("chat_allusers", new String[]{"_id", "user_id_from", "user_id_to", "nick_from", "date", "message"}, "(user_id_from=" + ChatPersonalActivity.this.f12721W + " OR " + "user_id_to" + "=" + ChatPersonalActivity.this.f12721W + ") AND " + "_id" + ">" + ChatPersonalActivity.this.f12724Z, (String[]) null, (String) null, (String) null, "_id ASC");
            ContentValues contentValues = new ContentValues();
            contentValues.put("read", 1);
            ChatPersonalActivity.this.f12714P.update("chat_preview", contentValues, "user_id_from=" + ChatPersonalActivity.this.f12721W, (String[]) null);
            return "COMPLETE!";
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            ((ProgressBar) ChatPersonalActivity.this.findViewById(C2030R.id.progressBar5)).setVisibility(8);
            ((Button) ChatPersonalActivity.this.findViewById(C2030R.id.button1)).setEnabled(true);
            Cursor cursor = this.f12742a;
            if (cursor != null) {
                cursor.moveToPosition(-1);
                while (this.f12742a.moveToNext()) {
                    Cursor cursor2 = this.f12742a;
                    String string = cursor2.getString(cursor2.getColumnIndexOrThrow("nick_from"));
                    Cursor cursor3 = this.f12742a;
                    String string2 = cursor3.getString(cursor3.getColumnIndexOrThrow("date"));
                    Cursor cursor4 = this.f12742a;
                    String string3 = cursor4.getString(cursor4.getColumnIndexOrThrow("message"));
                    Cursor cursor5 = this.f12742a;
                    int i8 = cursor5.getInt(cursor5.getColumnIndexOrThrow("_id"));
                    ChatPersonalActivity chatPersonalActivity = ChatPersonalActivity.this;
                    Cursor cursor6 = this.f12742a;
                    int unused = chatPersonalActivity.f12724Z = cursor6.getInt(cursor6.getColumnIndexOrThrow("_id"));
                    c cVar = new c();
                    cVar.p(string3);
                    cVar.q(string);
                    cVar.n(string2);
                    cVar.o(i8);
                    ChatPersonalActivity.this.f12720V.a(cVar);
                }
                this.f12742a.close();
                ChatPersonalActivity.this.R0();
                if (this.f12742a.getCount() > 1000) {
                    ChatPersonalActivity chatPersonalActivity2 = ChatPersonalActivity.this;
                    int unused2 = chatPersonalActivity2.f12725a0 = ((c) chatPersonalActivity2.f12719U.get(200)).k();
                    ChatPersonalActivity.this.J0();
                }
            }
            boolean unused3 = ChatPersonalActivity.this.f12726b0 = false;
        }
    }

    private class e extends AsyncTask {
        private e() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Context... contextArr) {
            ChatPersonalActivity chatPersonalActivity = ChatPersonalActivity.this;
            SQLiteDatabase unused = chatPersonalActivity.f12714P = chatPersonalActivity.f12715Q.getWritableDatabase();
            if (ChatPersonalActivity.this.f12714P == null) {
                return "COMPLETE!";
            }
            String format = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(new Date());
            ContentValues contentValues = new ContentValues();
            contentValues.put("user_id_from", 0);
            contentValues.put("user_id_to", Integer.valueOf(ChatPersonalActivity.this.f12721W));
            contentValues.put("nick_from", ChatPersonalActivity.this.f12718T);
            contentValues.put("nick_to", ChatPersonalActivity.this.f12723Y);
            contentValues.put("date", format);
            contentValues.put("message", ChatPersonalActivity.this.f12716R);
            ChatPersonalActivity.this.f12714P.insert("chat_allusers", (String) null, contentValues);
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("user_id_from", Integer.valueOf(ChatPersonalActivity.this.f12721W));
            contentValues2.put("nick_from", ChatPersonalActivity.this.f12723Y);
            contentValues2.put("read", 1);
            contentValues2.put("date", format);
            contentValues2.put("message", ChatPersonalActivity.this.f12716R);
            if (((int) ChatPersonalActivity.this.f12714P.insertWithOnConflict("chat_preview", (String) null, contentValues2, 4)) != -1) {
                return "COMPLETE!";
            }
            SQLiteDatabase t02 = ChatPersonalActivity.this.f12714P;
            t02.update("chat_preview", contentValues2, "user_id_from=" + ChatPersonalActivity.this.f12721W, (String[]) null);
            return "COMPLETE!";
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            if (!ChatPersonalActivity.this.f12726b0) {
                ChatPersonalActivity.this.Q0();
            }
        }
    }

    private class f extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private boolean f12745a;

        /* renamed from: b  reason: collision with root package name */
        private String f12746b;

        private f() {
            this.f12746b = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(5:11|10|15|16|(0)(0)) */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x00b1, code lost:
            r7 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x00b7, code lost:
            r1.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x00bf, code lost:
            r1.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x00b3 */
        /* JADX WARNING: Removed duplicated region for block: B:18:0x00b7  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00bf  */
        /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r7) {
            /*
                r6 = this;
                java.util.HashMap r7 = new java.util.HashMap
                r7.<init>()
                com.finazzi.distquake.ChatPersonalActivity r0 = com.finazzi.distquake.ChatPersonalActivity.this
                int r0 = r0.f12721W
                java.lang.String r0 = java.lang.Integer.toString(r0)
                java.lang.String r1 = "user_code"
                r7.put(r1, r0)
                java.lang.String r7 = u2.C1737L.a(r7)
                r0 = 1
                r1 = 0
                java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x00b3 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00b3 }
                r3.<init>()     // Catch:{ IOException -> 0x00b3 }
                com.finazzi.distquake.ChatPersonalActivity r4 = com.finazzi.distquake.ChatPersonalActivity.this     // Catch:{ IOException -> 0x00b3 }
                r5 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r4 = r4.getString(r5)     // Catch:{ IOException -> 0x00b3 }
                r3.append(r4)     // Catch:{ IOException -> 0x00b3 }
                java.lang.String r4 = "distquake_dowload_otheruserprofile.php"
                r3.append(r4)     // Catch:{ IOException -> 0x00b3 }
                java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x00b3 }
                r2.<init>(r3)     // Catch:{ IOException -> 0x00b3 }
                java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x00b3 }
                java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch:{ IOException -> 0x00b3 }
                java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch:{ IOException -> 0x00b3 }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x00b3 }
                r2.setDoOutput(r0)     // Catch:{ IOException -> 0x009f, all -> 0x009c }
                r1 = 10000(0x2710, float:1.4013E-41)
                r2.setConnectTimeout(r1)     // Catch:{ IOException -> 0x009f, all -> 0x009c }
                r2.setReadTimeout(r1)     // Catch:{ IOException -> 0x009f, all -> 0x009c }
                java.lang.String r1 = "Content-Type"
                java.lang.String r3 = "application/x-www-form-urlencoded;charset=utf-8"
                r2.setRequestProperty(r1, r3)     // Catch:{ IOException -> 0x009f, all -> 0x009c }
                java.lang.String r1 = "POST"
                r2.setRequestMethod(r1)     // Catch:{ IOException -> 0x009f, all -> 0x009c }
                byte[] r1 = r7.getBytes()     // Catch:{ IOException -> 0x009f, all -> 0x009c }
                int r1 = r1.length     // Catch:{ IOException -> 0x009f, all -> 0x009c }
                r2.setFixedLengthStreamingMode(r1)     // Catch:{ IOException -> 0x009f, all -> 0x009c }
                java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch:{ IOException -> 0x009f, all -> 0x009c }
                java.io.OutputStream r3 = r2.getOutputStream()     // Catch:{ IOException -> 0x009f, all -> 0x009c }
                r1.<init>(r3)     // Catch:{ IOException -> 0x009f, all -> 0x009c }
                r1.print(r7)     // Catch:{ IOException -> 0x009f, all -> 0x009c }
                r1.close()     // Catch:{ IOException -> 0x009f, all -> 0x009c }
                java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x009f, all -> 0x009c }
                java.io.InputStream r1 = r2.getInputStream()     // Catch:{ IOException -> 0x009f, all -> 0x009c }
                r7.<init>(r1)     // Catch:{ IOException -> 0x009f, all -> 0x009c }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x009f, all -> 0x009c }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x009f, all -> 0x009c }
                java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x009f, all -> 0x009c }
                r3.<init>(r7, r4)     // Catch:{ IOException -> 0x009f, all -> 0x009c }
                r1.<init>(r3)     // Catch:{ IOException -> 0x009f, all -> 0x009c }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x009f, all -> 0x009c }
                r3.<init>()     // Catch:{ IOException -> 0x009f, all -> 0x009c }
            L_0x008d:
                java.lang.String r4 = r1.readLine()     // Catch:{ IOException -> 0x009f, all -> 0x009c }
                if (r4 == 0) goto L_0x00a1
                r3.append(r4)     // Catch:{ IOException -> 0x009f, all -> 0x009c }
                java.lang.String r4 = "\n"
                r3.append(r4)     // Catch:{ IOException -> 0x009f, all -> 0x009c }
                goto L_0x008d
            L_0x009c:
                r7 = move-exception
                r1 = r2
                goto L_0x00bd
            L_0x009f:
                r1 = r2
                goto L_0x00b3
            L_0x00a1:
                r7.close()     // Catch:{ IOException -> 0x009f, all -> 0x009c }
                java.lang.String r7 = r3.toString()     // Catch:{ IOException -> 0x009f, all -> 0x009c }
                r6.f12746b = r7     // Catch:{ IOException -> 0x009f, all -> 0x009c }
                r7 = 0
                r6.f12745a = r7     // Catch:{ IOException -> 0x009f, all -> 0x009c }
                r2.disconnect()
                goto L_0x00ba
            L_0x00b1:
                r7 = move-exception
                goto L_0x00bd
            L_0x00b3:
                r6.f12745a = r0     // Catch:{ all -> 0x00b1 }
                if (r1 == 0) goto L_0x00ba
                r1.disconnect()
            L_0x00ba:
                java.lang.String r7 = "COMPLETE!"
                return r7
            L_0x00bd:
                if (r1 == 0) goto L_0x00c2
                r1.disconnect()
            L_0x00c2:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.ChatPersonalActivity.f.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            if (!this.f12745a) {
                try {
                    JSONObject jSONObject = new JSONArray(this.f12746b).getJSONObject(0);
                    String string = jSONObject.getString("nick");
                    int i8 = jSONObject.getInt("sex");
                    int i9 = jSONObject.getInt("country");
                    String string2 = jSONObject.getString("town");
                    int i10 = jSONObject.getInt("age");
                    int i11 = jSONObject.getInt("updated");
                    int i12 = jSONObject.getInt("firstlog");
                    int i13 = jSONObject.getInt("fr");
                    Intent intent = new Intent().setClass(ChatPersonalActivity.this, ProfileOtherActivity.class);
                    intent.putExtra("com.finazzi.distquake.nick", string);
                    intent.putExtra("com.finazzi.distquake.sex", i8);
                    intent.putExtra("com.finazzi.distquake.country", i9);
                    intent.putExtra("com.finazzi.distquake.town", string2);
                    intent.putExtra("com.finazzi.distquake.age", i10);
                    intent.putExtra("com.finazzi.distquake.user_code", ChatPersonalActivity.this.f12721W);
                    intent.putExtra("com.finazzi.distquake.updated", i11);
                    intent.putExtra("com.finazzi.distquake.firstlog", i12);
                    intent.putExtra("com.finazzi.distquake.accept_friendship", i13);
                    ChatPersonalActivity.this.startActivity(intent);
                } catch (JSONException unused) {
                    Toast makeText = Toast.makeText(ChatPersonalActivity.this.getApplicationContext(), ChatPersonalActivity.this.getString(C2030R.string.manual_error), 0);
                    makeText.setGravity(17, 0, 0);
                    makeText.show();
                }
            } else {
                Toast makeText2 = Toast.makeText(ChatPersonalActivity.this.getApplicationContext(), ChatPersonalActivity.this.getString(C2030R.string.manual_error), 0);
                makeText2.setGravity(17, 0, 0);
                makeText2.show();
            }
        }
    }

    private class g extends AsyncTask {
        private g() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Context... contextArr) {
            ChatPersonalActivity chatPersonalActivity = ChatPersonalActivity.this;
            SQLiteDatabase unused = chatPersonalActivity.f12714P = chatPersonalActivity.f12715Q.getWritableDatabase();
            if (ChatPersonalActivity.this.f12714P == null) {
                return "COMPLETE!";
            }
            ChatPersonalActivity.this.f12714P.delete("chat_allusers", "user_id_from=? OR user_id_to=?", new String[]{Integer.toString(ChatPersonalActivity.this.f12721W), Integer.toString(ChatPersonalActivity.this.f12721W)});
            ChatPersonalActivity.this.f12714P.delete("chat_preview", "user_id_from=?", new String[]{Integer.toString(ChatPersonalActivity.this.f12721W)});
            return "COMPLETE!";
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            ChatPersonalActivity.this.f12719U.clear();
            ChatPersonalActivity.this.f12720V.notifyDataSetChanged();
        }
    }

    private class h extends AsyncTask {
        private h() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Context... contextArr) {
            ChatPersonalActivity chatPersonalActivity = ChatPersonalActivity.this;
            SQLiteDatabase unused = chatPersonalActivity.f12714P = chatPersonalActivity.f12715Q.getWritableDatabase();
            if (ChatPersonalActivity.this.f12714P == null) {
                return "COMPLETE!";
            }
            ChatPersonalActivity.this.f12714P.delete("chat_allusers", "(user_id_from=? OR user_id_to=?) AND _id<?", new String[]{Integer.toString(ChatPersonalActivity.this.f12721W), Integer.toString(ChatPersonalActivity.this.f12721W), Integer.toString(ChatPersonalActivity.this.f12725a0)});
            return "COMPLETE!";
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
        }
    }

    private class i extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private int f12750a;

        private i() {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x00dc  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00e2  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x00ee  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x00f9  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0102  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x010c  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x0116  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0121  */
        /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r8) {
            /*
                r7 = this;
                java.lang.String r8 = "nok"
                java.util.HashMap r0 = new java.util.HashMap
                r0.<init>()
                com.finazzi.distquake.ChatPersonalActivity r1 = com.finazzi.distquake.ChatPersonalActivity.this
                java.lang.String r1 = r1.f12717S
                java.lang.String r2 = "u_id"
                r0.put(r2, r1)
                com.finazzi.distquake.ChatPersonalActivity r1 = com.finazzi.distquake.ChatPersonalActivity.this
                int r1 = r1.f12722X
                java.lang.String r1 = java.lang.Integer.toString(r1)
                java.lang.String r2 = "user_code_from"
                r0.put(r2, r1)
                com.finazzi.distquake.ChatPersonalActivity r1 = com.finazzi.distquake.ChatPersonalActivity.this
                int r1 = r1.f12721W
                java.lang.String r1 = java.lang.Integer.toString(r1)
                java.lang.String r2 = "user_code_to"
                r0.put(r2, r1)
                com.finazzi.distquake.ChatPersonalActivity r1 = com.finazzi.distquake.ChatPersonalActivity.this
                java.lang.String r1 = r1.f12716R
                java.lang.String r2 = "message"
                r0.put(r2, r1)
                com.finazzi.distquake.ChatPersonalActivity r1 = com.finazzi.distquake.ChatPersonalActivity.this
                java.lang.String r1 = r1.f12718T
                java.lang.String r2 = "nick"
                r0.put(r2, r1)
                java.lang.String r0 = u2.C1737L.a(r0)
                r1 = 1
                r2 = 0
                java.net.URL r3 = new java.net.URL     // Catch:{ IOException -> 0x00e0, all -> 0x00d9 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00e0, all -> 0x00d9 }
                r4.<init>()     // Catch:{ IOException -> 0x00e0, all -> 0x00d9 }
                com.finazzi.distquake.ChatPersonalActivity r5 = com.finazzi.distquake.ChatPersonalActivity.this     // Catch:{ IOException -> 0x00e0, all -> 0x00d9 }
                r6 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r5 = r5.getString(r6)     // Catch:{ IOException -> 0x00e0, all -> 0x00d9 }
                r4.append(r5)     // Catch:{ IOException -> 0x00e0, all -> 0x00d9 }
                java.lang.String r5 = "distquake_upload_personal_chat2.php"
                r4.append(r5)     // Catch:{ IOException -> 0x00e0, all -> 0x00d9 }
                java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x00e0, all -> 0x00d9 }
                r3.<init>(r4)     // Catch:{ IOException -> 0x00e0, all -> 0x00d9 }
                java.net.URLConnection r3 = r3.openConnection()     // Catch:{ IOException -> 0x00e0, all -> 0x00d9 }
                java.lang.Object r3 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r3)     // Catch:{ IOException -> 0x00e0, all -> 0x00d9 }
                java.net.URLConnection r3 = (java.net.URLConnection) r3     // Catch:{ IOException -> 0x00e0, all -> 0x00d9 }
                java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ IOException -> 0x00e0, all -> 0x00d9 }
                r3.setDoOutput(r1)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                r2 = 10000(0x2710, float:1.4013E-41)
                r3.setConnectTimeout(r2)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                r3.setReadTimeout(r2)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                java.lang.String r2 = "Content-Type"
                java.lang.String r4 = "application/x-www-form-urlencoded;charset=utf-8"
                r3.setRequestProperty(r2, r4)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                java.lang.String r2 = "POST"
                r3.setRequestMethod(r2)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                byte[] r2 = r0.getBytes()     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                int r2 = r2.length     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                r3.setFixedLengthStreamingMode(r2)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                java.io.PrintWriter r2 = new java.io.PrintWriter     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                java.io.OutputStream r4 = r3.getOutputStream()     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                r2.<init>(r4)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                r2.print(r0)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                r2.close()     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                java.io.InputStream r2 = r3.getInputStream()     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                r0.<init>(r2)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                r4.<init>(r0, r5)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                r2.<init>(r4)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                r4.<init>()     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
            L_0x00bf:
                java.lang.String r5 = r2.readLine()     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                if (r5 == 0) goto L_0x00ce
                r4.append(r5)     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                goto L_0x00bf
            L_0x00c9:
                r8 = move-exception
                r2 = r3
                goto L_0x00da
            L_0x00cc:
                r2 = r3
                goto L_0x00e0
            L_0x00ce:
                r0.close()     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                java.lang.String r0 = r4.toString()     // Catch:{ IOException -> 0x00cc, all -> 0x00c9 }
                r3.disconnect()
                goto L_0x00e6
            L_0x00d9:
                r8 = move-exception
            L_0x00da:
                if (r2 == 0) goto L_0x00df
                r2.disconnect()
            L_0x00df:
                throw r8
            L_0x00e0:
                if (r2 == 0) goto L_0x00e5
                r2.disconnect()
            L_0x00e5:
                r0 = r8
            L_0x00e6:
                java.lang.String r2 = "ok"
                boolean r2 = r0.equals(r2)
                if (r2 == 0) goto L_0x00f1
                r2 = 0
                r7.f12750a = r2
            L_0x00f1:
                java.lang.String r2 = "banned"
                boolean r2 = r0.equals(r2)
                if (r2 == 0) goto L_0x00fb
                r7.f12750a = r1
            L_0x00fb:
                boolean r8 = r0.equals(r8)
                r1 = 2
                if (r8 == 0) goto L_0x0104
                r7.f12750a = r1
            L_0x0104:
                java.lang.String r8 = "wrong"
                boolean r8 = r0.equals(r8)
                if (r8 == 0) goto L_0x010e
                r7.f12750a = r1
            L_0x010e:
                java.lang.String r8 = "usergone"
                boolean r8 = r0.equals(r8)
                if (r8 == 0) goto L_0x0119
                r8 = 3
                r7.f12750a = r8
            L_0x0119:
                java.lang.String r8 = "nofriend"
                boolean r8 = r0.equals(r8)
                if (r8 == 0) goto L_0x0124
                r8 = 4
                r7.f12750a = r8
            L_0x0124:
                java.lang.String r8 = "COMPLETE!"
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.ChatPersonalActivity.i.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            ((ProgressBar) ChatPersonalActivity.this.findViewById(C2030R.id.progressBar5)).setVisibility(8);
            ((Button) ChatPersonalActivity.this.findViewById(C2030R.id.button1)).setEnabled(true);
            EditText editText = (EditText) ChatPersonalActivity.this.findViewById(C2030R.id.editText1);
            Context context = editText.getContext();
            if (this.f12750a == 0) {
                editText.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                ChatPersonalActivity.this.S0();
            }
            if (this.f12750a == 1) {
                Toast makeText = Toast.makeText(context, ChatPersonalActivity.this.getString(C2030R.string.chat_pop_blocked_msg), 1);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
            if (this.f12750a == 2) {
                Toast makeText2 = Toast.makeText(context, ChatPersonalActivity.this.getString(C2030R.string.manual_error), 1);
                makeText2.setGravity(17, 0, 0);
                makeText2.show();
            }
            if (this.f12750a == 3) {
                Toast makeText3 = Toast.makeText(context, ChatPersonalActivity.this.getString(C2030R.string.chat_pop_nouser), 1);
                makeText3.setGravity(17, 0, 0);
                makeText3.show();
            }
            if (this.f12750a == 4) {
                Toast makeText4 = Toast.makeText(context, ChatPersonalActivity.this.getString(C2030R.string.friend_nofriend), 1);
                makeText4.setGravity(17, 0, 0);
                makeText4.show();
            }
        }
    }

    public class j extends BroadcastReceiver {
        public j() {
        }

        public void onReceive(Context context, Intent intent) {
            Bundle extras;
            if (intent.getAction() != null && intent.getAction().equals("com.finazzi.distquake.update_private_chat") && (extras = intent.getExtras()) != null && extras.getInt("com.finazzi.distquake.private_chat_user_code_from") == ChatPersonalActivity.this.f12721W) {
                if (!ChatPersonalActivity.this.f12726b0) {
                    ChatPersonalActivity.this.Q0();
                }
                ChatPersonalActivity.this.f12729e0.cancel("chat_personal_notification", ChatPersonalActivity.this.f12721W);
            }
        }
    }

    private void I0() {
        new g().execute(new Context[]{this});
    }

    /* access modifiers changed from: private */
    public void J0() {
        new h().execute(new Context[]{this});
    }

    private String K0() {
        return this.f12727c0.getString("android_id_eqn", "0");
    }

    private int L0(String str) {
        boolean z7;
        Date date = new Date();
        try {
            date = this.f12730f0.parse(str);
            z7 = true;
        } catch (ParseException unused) {
            z7 = false;
        }
        if (z7) {
            return (int) Math.round((((double) (new Date().getTime() - date.getTime())) / 1000.0d) / 60.0d);
        }
        return 9999;
    }

    /* access modifiers changed from: private */
    public String M0(String str) {
        boolean z7;
        if (str == null) {
            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
        }
        boolean P02 = P0(str);
        int L02 = L0(str);
        Date date = new Date();
        try {
            date = this.f12730f0.parse(str);
            z7 = true;
        } catch (ParseException unused) {
            z7 = false;
        }
        this.f12733i0.setTime(date);
        if (!z7) {
            return str;
        }
        if (L02 < 60) {
            return L02 + "m";
        } else if (!P02) {
            return this.f12732h0.format(date);
        } else {
            return this.f12731g0.format(date);
        }
    }

    private String N0() {
        if (FirebaseAuth.getInstance().f() != null) {
            SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.class.getSimpleName(), 0);
            if (sharedPreferences.getBoolean("nicklinked", false)) {
                return sharedPreferences.getString("nick", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
            }
        }
        return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    }

    private boolean O0() {
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

    private boolean P0(String str) {
        try {
            return !DateUtils.isToday(this.f12730f0.parse(str).getTime());
        } catch (ParseException unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void Q0() {
        ((ProgressBar) findViewById(C2030R.id.progressBar5)).setVisibility(0);
        ((Button) findViewById(C2030R.id.button1)).setEnabled(false);
        new d().execute(new Context[]{this});
    }

    /* access modifiers changed from: private */
    public void R0() {
        ListView listView = (ListView) findViewById(C2030R.id.listPersonal);
        listView.post(new C1730E(listView));
    }

    /* access modifiers changed from: private */
    public void S0() {
        new e().execute(new Context[]{this});
    }

    public static /* synthetic */ void g0(ChatPersonalActivity chatPersonalActivity, DialogInterface dialogInterface, int i8) {
        if (i8 != -1) {
            chatPersonalActivity.getClass();
        } else {
            chatPersonalActivity.I0();
        }
    }

    public static /* synthetic */ boolean h0(ChatPersonalActivity chatPersonalActivity, TextView textView, int i8, KeyEvent keyEvent) {
        chatPersonalActivity.getClass();
        if (keyEvent == null || keyEvent.getKeyCode() != 66) {
            return false;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) chatPersonalActivity.getSystemService("input_method");
        if (inputMethodManager == null) {
            return true;
        }
        inputMethodManager.hideSoftInputFromWindow(textView.getWindowToken(), 2);
        return true;
    }

    public static /* synthetic */ void i0(ChatPersonalActivity chatPersonalActivity, View view) {
        chatPersonalActivity.getClass();
        Context context = view.getContext();
        chatPersonalActivity.f12716R = ((EditText) chatPersonalActivity.findViewById(C2030R.id.editText1)).getText().toString();
        if (chatPersonalActivity.f12717S.equals("0")) {
            Toast makeText = Toast.makeText(context, chatPersonalActivity.getString(C2030R.string.chat_user0), 0);
            makeText.setGravity(17, 0, 0);
            makeText.show();
        } else if (chatPersonalActivity.f12716R.isEmpty()) {
            Toast makeText2 = Toast.makeText(context, chatPersonalActivity.getString(C2030R.string.chat_empty), 0);
            makeText2.setGravity(17, 0, 0);
            makeText2.show();
        } else if (chatPersonalActivity.O0()) {
            ((ProgressBar) chatPersonalActivity.findViewById(C2030R.id.progressBar5)).setVisibility(0);
            ((Button) chatPersonalActivity.findViewById(C2030R.id.button1)).setEnabled(false);
            i iVar = new i();
            chatPersonalActivity.f12713O = iVar;
            iVar.execute(new Context[]{context});
        } else {
            Toast makeText3 = Toast.makeText(context, chatPersonalActivity.getString(C2030R.string.main_nointernet), 0);
            makeText3.setGravity(17, 0, 0);
            makeText3.show();
        }
    }

    public static /* synthetic */ void j0(ChatPersonalActivity chatPersonalActivity, View view) {
        chatPersonalActivity.getClass();
        view.postDelayed(new C1729D(chatPersonalActivity), 800);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(8192, 8192);
        setContentView((int) C2030R.layout.chat_personal);
        int i8 = getResources().getConfiguration().uiMode & 48;
        if (Build.VERSION.SDK_INT >= 35 && i8 == 16) {
            Window window = getWindow();
            C0832r0.a(window, window.getDecorView()).d(true);
        }
        this.f12718T = N0();
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.f12721W = extras.getInt("com.finazzi.distquake.user_code_to");
            this.f12723Y = extras.getString("com.finazzi.distquake.user_nick");
        }
        this.f12730f0 = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
        this.f12731g0 = new SimpleDateFormat("dd-MMM HH:mm", Locale.getDefault());
        this.f12732h0 = new SimpleDateFormat("HH:mm", Locale.getDefault());
        this.f12733i0 = Calendar.getInstance();
        Toolbar toolbar = (Toolbar) findViewById(C2030R.id.toolbar);
        b0(toolbar);
        toolbar.setLogo((int) C2030R.drawable.account);
        b0(toolbar);
        if (R() != null) {
            R().u(this.f12723Y);
        }
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.class.getSimpleName(), 0);
        this.f12727c0 = sharedPreferences;
        this.f12722X = sharedPreferences.getInt("chat_user_code", 0);
        this.f12715Q = new C(getApplicationContext());
        this.f12717S = K0();
        getWindow().setSoftInputMode(2);
        this.f12719U = new ArrayList();
        this.f12720V = new b(this, this.f12719U);
        this.f12724Z = 0;
        ((ListView) findViewById(C2030R.id.listPersonal)).setAdapter(this.f12720V);
        ((Button) findViewById(C2030R.id.button1)).setOnClickListener(new C1726A(this));
        EditText editText = (EditText) findViewById(C2030R.id.editText1);
        editText.setOnClickListener(new C1727B(this));
        editText.setOnEditorActionListener(new C1728C(this));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(C2030R.menu.chat_personal_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == C2030R.id.menu_profile) {
            new f().execute(new Context[]{this});
            return true;
        } else if (itemId != C2030R.id.menu_delete) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            new AlertDialog.Builder(this).setMessage(getString(C2030R.string.chat_pop_delete_sure)).setPositiveButton(getString(C2030R.string.manual_yes), this.f12734j0).setNegativeButton(getString(C2030R.string.manual_no), this.f12734j0).show();
            return true;
        }
    }

    public void onPause() {
        unregisterReceiver(this.f12728d0);
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        if (!this.f12726b0) {
            Q0();
        }
        invalidateOptionsMenu();
        this.f12728d0 = new j();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.finazzi.distquake.update_private_chat");
        if (Build.VERSION.SDK_INT >= 33) {
            Intent unused = registerReceiver(this.f12728d0, intentFilter, 4);
        } else {
            registerReceiver(this.f12728d0, intentFilter);
        }
        NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
        this.f12729e0 = notificationManager;
        if (notificationManager != null) {
            notificationManager.cancel("chat_personal_notification", this.f12721W);
        }
    }
}
