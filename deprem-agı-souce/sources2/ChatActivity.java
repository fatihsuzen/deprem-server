package com.finazzi.distquake;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.BroadcastReceiver;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.text.Spannable;
import android.text.format.DateUtils;
import android.text.style.StyleSpan;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.C0765a;
import androidx.appcompat.app.C0766b;
import androidx.appcompat.app.C0768d;
import androidx.appcompat.widget.SearchView;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.W;
import androidx.core.content.a;
import androidx.drawerlayout.widget.DrawerLayout;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.C1155z;
import com.google.firebase.auth.FirebaseAuth;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import u2.C1817l;
import u2.C1823m;
import u2.C1829n;
import u2.C1835o;
import u2.C1841p;
import u2.C1847q;
import u2.C1853r;
import u2.C1859s;
import u2.C1865t;
import u2.C1871u;
import u2.C1877v;
import u2.C1883w;
import u2.C1889x;

public class ChatActivity extends C0768d {
    /* access modifiers changed from: private */

    /* renamed from: A0  reason: collision with root package name */
    public static final Spannable.Factory f12536A0 = Spannable.Factory.getInstance();
    /* access modifiers changed from: private */

    /* renamed from: O  reason: collision with root package name */
    public x f12537O;

    /* renamed from: P  reason: collision with root package name */
    private r f12538P;

    /* renamed from: Q  reason: collision with root package name */
    private w f12539Q;
    /* access modifiers changed from: private */

    /* renamed from: R  reason: collision with root package name */
    public l f12540R;
    /* access modifiers changed from: private */

    /* renamed from: S  reason: collision with root package name */
    public SQLiteDatabase f12541S;
    /* access modifiers changed from: private */

    /* renamed from: T  reason: collision with root package name */
    public C f12542T;
    /* access modifiers changed from: private */

    /* renamed from: U  reason: collision with root package name */
    public String f12543U;
    /* access modifiers changed from: private */

    /* renamed from: V  reason: collision with root package name */
    public String f12544V;
    /* access modifiers changed from: private */

    /* renamed from: W  reason: collision with root package name */
    public String f12545W;
    /* access modifiers changed from: private */

    /* renamed from: X  reason: collision with root package name */
    public int f12546X = 0;

    /* renamed from: Y  reason: collision with root package name */
    private int f12547Y;
    /* access modifiers changed from: private */

    /* renamed from: Z  reason: collision with root package name */
    public int f12548Z = 0;
    /* access modifiers changed from: private */

    /* renamed from: a0  reason: collision with root package name */
    public int f12549a0;
    /* access modifiers changed from: private */

    /* renamed from: b0  reason: collision with root package name */
    public String f12550b0;
    /* access modifiers changed from: private */

    /* renamed from: c0  reason: collision with root package name */
    public String f12551c0;
    /* access modifiers changed from: private */

    /* renamed from: d0  reason: collision with root package name */
    public String f12552d0;
    /* access modifiers changed from: private */

    /* renamed from: e0  reason: collision with root package name */
    public List f12553e0;
    /* access modifiers changed from: private */

    /* renamed from: f0  reason: collision with root package name */
    public c f12554f0;
    /* access modifiers changed from: private */

    /* renamed from: g0  reason: collision with root package name */
    public List f12555g0;
    /* access modifiers changed from: private */

    /* renamed from: h0  reason: collision with root package name */
    public y f12556h0;
    /* access modifiers changed from: private */

    /* renamed from: i0  reason: collision with root package name */
    public ListView f12557i0;
    /* access modifiers changed from: private */

    /* renamed from: j0  reason: collision with root package name */
    public int f12558j0 = 0;

    /* renamed from: k0  reason: collision with root package name */
    private ListView f12559k0;
    /* access modifiers changed from: private */

    /* renamed from: l0  reason: collision with root package name */
    public DrawerLayout f12560l0;

    /* renamed from: m0  reason: collision with root package name */
    private C0766b f12561m0;
    /* access modifiers changed from: private */

    /* renamed from: n0  reason: collision with root package name */
    public boolean f12562n0 = false;

    /* renamed from: o0  reason: collision with root package name */
    private B f12563o0;

    /* renamed from: p0  reason: collision with root package name */
    private A f12564p0;

    /* renamed from: q0  reason: collision with root package name */
    private SimpleDateFormat f12565q0;

    /* renamed from: r0  reason: collision with root package name */
    private SimpleDateFormat f12566r0;

    /* renamed from: s0  reason: collision with root package name */
    private SimpleDateFormat f12567s0;

    /* renamed from: t0  reason: collision with root package name */
    private Calendar f12568t0;
    /* access modifiers changed from: private */

    /* renamed from: u0  reason: collision with root package name */
    public boolean f12569u0 = false;
    /* access modifiers changed from: private */

    /* renamed from: v0  reason: collision with root package name */
    public String f12570v0 = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    /* access modifiers changed from: private */

    /* renamed from: w0  reason: collision with root package name */
    public boolean f12571w0 = false;
    /* access modifiers changed from: private */

    /* renamed from: x0  reason: collision with root package name */
    public int f12572x0 = 0;
    /* access modifiers changed from: private */

    /* renamed from: y0  reason: collision with root package name */
    public int f12573y0 = 0;
    /* access modifiers changed from: private */

    /* renamed from: z0  reason: collision with root package name */
    public int[] f12574z0;

    public class A extends BroadcastReceiver {
        public A() {
        }

        public static /* synthetic */ void a(A a8, LinearLayout linearLayout, View view) {
            a8.getClass();
            linearLayout.setVisibility(8);
            InputMethodManager inputMethodManager = (InputMethodManager) ChatActivity.this.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
            }
        }

        public static /* synthetic */ void b(A a8, int i8, String str, View view) {
            InputMethodManager inputMethodManager = (InputMethodManager) ChatActivity.this.getSystemService("input_method");
            if (inputMethodManager != null) {
                inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
            }
            Context context = view.getContext();
            String obj = ((EditText) ChatActivity.this.findViewById(C2030R.id.editText2)).getText().toString();
            ChatActivity chatActivity = ChatActivity.this;
            String unused = chatActivity.f12545W = chatActivity.w1();
            if (ChatActivity.this.f12545W.equals("0")) {
                Toast makeText = Toast.makeText(context, ChatActivity.this.getString(C2030R.string.chat_user0), 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            } else if (obj.length() <= 0) {
                Toast makeText2 = Toast.makeText(context, ChatActivity.this.getString(C2030R.string.chat_empty), 0);
                makeText2.setGravity(17, 0, 0);
                makeText2.show();
            } else if (ChatActivity.this.G1()) {
                ((ProgressBar) ChatActivity.this.findViewById(C2030R.id.progressBar6)).setVisibility(0);
                ((EditText) ChatActivity.this.findViewById(C2030R.id.editText1)).setEnabled(false);
                ((EditText) ChatActivity.this.findViewById(C2030R.id.editText2)).setEnabled(false);
                l unused2 = ChatActivity.this.f12540R = new l(ChatActivity.this, obj, i8, str, (C1066a) null);
                ChatActivity.this.f12540R.execute(new Context[]{context});
            } else {
                Toast makeText3 = Toast.makeText(context, ChatActivity.this.getString(C2030R.string.main_nointernet), 0);
                makeText3.setGravity(17, 0, 0);
                makeText3.show();
            }
        }

        public static /* synthetic */ void c(A a8, LinearLayout linearLayout, int i8, String str, View view) {
            a8.getClass();
            linearLayout.setVisibility(8);
            Intent intent = new Intent().setClass(ChatActivity.this, ChatPersonalActivity.class);
            intent.putExtra("com.finazzi.distquake.user_code_to", i8);
            intent.putExtra("com.finazzi.distquake.user_nick", str);
            ChatActivity.this.startActivity(intent);
        }

        public void onReceive(Context context, Intent intent) {
            Bundle extras;
            String action = intent.getAction();
            if (action != null && action.equals("com.finazzi.distquake.update_private_chat") && (extras = intent.getExtras()) != null) {
                String string = extras.getString("com.finazzi.distquake.private_chat_nick");
                String string2 = extras.getString("com.finazzi.distquake.private_chat_msg");
                int i8 = extras.getInt("com.finazzi.distquake.private_chat_user_code_from");
                ((TextView) ChatActivity.this.findViewById(C2030R.id.textView23)).setText(string + ": " + string2);
                LinearLayout linearLayout = (LinearLayout) ChatActivity.this.findViewById(C2030R.id.linearPrivate);
                linearLayout.setVisibility(0);
                linearLayout.setOnClickListener(new C1877v(this, linearLayout, i8, string));
                ((Button) ChatActivity.this.findViewById(C2030R.id.button5)).setOnClickListener(new C1883w(this, linearLayout));
                ((Button) ChatActivity.this.findViewById(C2030R.id.button6)).setOnClickListener(new C1889x(this, i8, string));
            }
        }
    }

    public class B extends BroadcastReceiver {
        public B() {
        }

        public void onReceive(Context context, Intent intent) {
            Bundle extras;
            String action = intent.getAction();
            if (action != null && action.equals("com.finazzi.distquake.update_public_chat") && (extras = intent.getExtras()) != null) {
                String string = extras.getString("com.finazzi.distquake.public_chat_table");
                int i8 = extras.getInt("com.finazzi.distquake.public_chat_self");
                int i9 = extras.getInt("com.finazzi.distquake.public_chat_msgcode");
                int i10 = extras.getInt("com.finazzi.distquake.public_chat_idnewmessage");
                int i11 = extras.getInt("com.finazzi.distquake.public_chat_country");
                int i12 = extras.getInt("com.finazzi.distquake.public_chat_moderator");
                if (!ChatActivity.this.f12543U.equalsIgnoreCase(string)) {
                    return;
                }
                if (i8 == 1) {
                    ChatActivity.this.O1(i9, 1, i12, i11);
                    return;
                }
                ChatActivity chatActivity = ChatActivity.this;
                new k(chatActivity, chatActivity.f12543U, i10, (C1066a) null).execute(new Context[]{ChatActivity.this.getApplicationContext()});
            }
        }
    }

    /* renamed from: com.finazzi.distquake.ChatActivity$a  reason: case insensitive filesystem */
    class C1066a implements SearchView.m {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ SearchView f12577a;

        C1066a(SearchView searchView) {
            this.f12577a = searchView;
        }

        public boolean a(String str) {
            if (this.f12577a.getQuery().length() == 0) {
                boolean unused = ChatActivity.this.f12569u0 = false;
                ChatActivity.this.f12553e0.clear();
                ChatActivity.this.f12554f0.notifyDataSetInvalidated();
                ChatActivity chatActivity = ChatActivity.this;
                new h(chatActivity, chatActivity.f12543U, false, (C1066a) null).execute(new Context[]{ChatActivity.this.getApplicationContext()});
            } else {
                boolean unused2 = ChatActivity.this.f12569u0 = true;
                String unused3 = ChatActivity.this.f12570v0 = str;
                ChatActivity.this.f12553e0.clear();
                ChatActivity.this.f12554f0.notifyDataSetInvalidated();
                ChatActivity chatActivity2 = ChatActivity.this;
                new h(chatActivity2, chatActivity2.f12543U, false, (C1066a) null).execute(new Context[]{ChatActivity.this.getApplicationContext()});
            }
            return false;
        }

        public boolean b(String str) {
            return false;
        }
    }

    /* renamed from: com.finazzi.distquake.ChatActivity$b  reason: case insensitive filesystem */
    class C1067b extends C0766b {
        C1067b(Activity activity, DrawerLayout drawerLayout, Toolbar toolbar, int i8, int i9) {
            super(activity, drawerLayout, toolbar, i8, i9);
        }

        public void a(View view) {
            super.a(view);
        }

        public void b(View view) {
            super.b(view);
        }
    }

    private class c extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        private LayoutInflater f12580a;

        /* renamed from: b  reason: collision with root package name */
        private List f12581b;

        /* synthetic */ c(ChatActivity chatActivity, Activity activity, List list, C1066a aVar) {
            this(activity, list);
        }

        public static /* synthetic */ void b(c cVar, int i8, View view) {
            EditText editText = (EditText) ChatActivity.this.findViewById(C2030R.id.editText1);
            editText.setText("@" + ((e) cVar.f12581b.get(i8)).F() + ": ");
            editText.requestFocus();
            editText.post(new C1069b(editText));
            ((InputMethodManager) ChatActivity.this.getSystemService("input_method")).showSoftInput(editText, 1);
            view.postDelayed(new C1070c(ChatActivity.this), 800);
        }

        /* access modifiers changed from: package-private */
        public void d(e eVar) {
            this.f12581b.add(eVar);
            notifyDataSetChanged();
        }

        public int getCount() {
            return this.f12581b.size();
        }

        public Object getItem(int i8) {
            return this.f12581b.get(i8);
        }

        public long getItemId(int i8) {
            return (long) i8;
        }

        public View getView(int i8, View view, ViewGroup viewGroup) {
            int i9;
            LayoutInflater layoutInflater = ChatActivity.this.getLayoutInflater();
            this.f12580a = layoutInflater;
            View inflate = layoutInflater.inflate(C2030R.layout.chat_entry, viewGroup, false);
            TextView textView = (TextView) inflate.findViewById(C2030R.id.textView1);
            String x7 = ((e) this.f12581b.get(i8)).C();
            if (((e) this.f12581b.get(i8)).D() == 1) {
                textView.setTypeface(Typeface.DEFAULT_BOLD);
            }
            if (((e) this.f12581b.get(i8)).D() > 1) {
                textView.setTypeface((Typeface) null, 2);
            }
            String str = "@" + ChatActivity.this.f12544V;
            if (!ChatActivity.this.f12544V.equals(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED)) {
                i9 = x7.lastIndexOf(str);
            } else {
                i9 = -1;
            }
            Spannable newSpannable = ChatActivity.f12536A0.newSpannable(x7);
            if (i9 >= 0) {
                newSpannable.setSpan(new StyleSpan(1), i9, str.length() + i9, 33);
            }
            textView.setText(newSpannable);
            TextView textView2 = (TextView) inflate.findViewById(C2030R.id.textView2);
            if (((e) this.f12581b.get(i8)).B() != null) {
                if (((e) this.f12581b.get(i8)).D() == 0) {
                    textView2.setText(ChatActivity.this.B1(((e) this.f12581b.get(i8)).B()) + " - " + ((e) this.f12581b.get(i8)).F());
                } else {
                    String str2 = ChatActivity.this.B1(((e) this.f12581b.get(i8)).B()) + " - " + ChatActivity.this.A1(11088) + " " + ((e) this.f12581b.get(i8)).F();
                    Spannable newSpannable2 = ChatActivity.f12536A0.newSpannable(str2);
                    newSpannable2.setSpan(new StyleSpan(1), str2.indexOf(" - ") + 3, newSpannable2.length(), 33);
                    textView2.setText(newSpannable2);
                }
            }
            ImageView imageView = (ImageView) inflate.findViewById(C2030R.id.imageView0);
            if (((e) this.f12581b.get(i8)).A() > 0) {
                String num = Integer.toString(((e) this.f12581b.get(i8)).A());
                if (num.length() == 1) {
                    num = "00" + num;
                } else if (num.length() == 2) {
                    num = "0" + num;
                }
                imageView.setImageResource(ChatActivity.this.getResources().getIdentifier("drawable/" + ("flag" + num), (String) null, ChatActivity.this.getPackageName()));
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = (ImageView) inflate.findViewById(C2030R.id.imageView2);
            if (((e) this.f12581b.get(i8)).I() == 1 && ((e) this.f12581b.get(i8)).J() == 0) {
                imageView2.setImageDrawable(androidx.core.content.res.h.e(ChatActivity.this.getResources(), C2030R.drawable.clock_outline, (Resources.Theme) null));
            }
            if (((e) this.f12581b.get(i8)).I() == 1 && ((e) this.f12581b.get(i8)).J() == 1 && ((e) this.f12581b.get(i8)).H() == 0) {
                imageView2.setImageDrawable(androidx.core.content.res.h.e(ChatActivity.this.getResources(), C2030R.drawable.check, (Resources.Theme) null));
            }
            if (((e) this.f12581b.get(i8)).I() == 1 && ((e) this.f12581b.get(i8)).J() == 1 && ((e) this.f12581b.get(i8)).H() == 1) {
                imageView2.setImageDrawable(androidx.core.content.res.h.e(ChatActivity.this.getResources(), C2030R.drawable.check_all, (Resources.Theme) null));
            }
            ImageView imageView3 = (ImageView) inflate.findViewById(C2030R.id.imageView3);
            if (((e) this.f12581b.get(i8)).G() == 1) {
                imageView3.setVisibility(0);
            } else {
                imageView3.setVisibility(8);
            }
            ((Button) inflate.findViewById(C2030R.id.button1)).setOnClickListener(new C1068a(this, i8));
            return inflate;
        }

        private c(Activity activity, List list) {
            this.f12580a = LayoutInflater.from(activity);
            this.f12581b = list;
        }
    }

    private class d implements AdapterView.OnItemClickListener {
        private d() {
        }

        public static /* synthetic */ void a(d dVar, int i8, DialogInterface dialogInterface, int i9) {
            if (ChatActivity.this.G1()) {
                String L02 = ChatActivity.this.w1();
                int i10 = i8 - 1;
                int k8 = ((e) ChatActivity.this.f12553e0.get(i10)).f12588e;
                String j8 = ((e) ChatActivity.this.f12553e0.get(i10)).f12586c;
                if (ChatActivity.this.f12546X == k8) {
                    Toast makeText = Toast.makeText(ChatActivity.this.getApplicationContext(), ChatActivity.this.getString(C2030R.string.friend_yourself), 0);
                    makeText.setGravity(17, 0, 0);
                    makeText.show();
                    return;
                }
                ChatActivity chatActivity = ChatActivity.this;
                new q(chatActivity, L02, chatActivity.f12546X, k8, ChatActivity.this.f12544V, j8, ChatActivity.this.f12551c0, (C1066a) null).execute(new Context[0]);
                return;
            }
            Toast makeText2 = Toast.makeText(ChatActivity.this.getApplicationContext(), ChatActivity.this.getString(C2030R.string.main_nointernet), 0);
            makeText2.setGravity(17, 0, 0);
            makeText2.show();
        }

        public static /* synthetic */ boolean b(d dVar, int i8, MenuItem menuItem) {
            dVar.getClass();
            switch (menuItem.getItemId()) {
                case C2030R.id.five /*2131296624*/:
                    ChatActivity chatActivity = ChatActivity.this;
                    chatActivity.q1(chatActivity.w1(), ((e) ChatActivity.this.f12553e0.get(i8 - 1)).f12588e, ChatActivity.this.f12544V, ChatActivity.this.F1(), ChatActivity.this.f12552d0);
                    return true;
                case C2030R.id.four /*2131296630*/:
                    ChatActivity chatActivity2 = ChatActivity.this;
                    int i9 = i8 - 1;
                    chatActivity2.J1(((e) chatActivity2.f12553e0.get(i9)).f12586c, ChatActivity.this.f12544V, ((e) ChatActivity.this.f12553e0.get(i9)).f12588e, ChatActivity.this.f12552d0);
                    return true;
                case C2030R.id.one /*2131296845*/:
                    ChatActivity.this.L1(i8);
                    return true;
                case C2030R.id.three /*2131297085*/:
                    String x7 = ((e) ChatActivity.this.f12553e0.get(i8 - 1)).C();
                    ClipboardManager clipboardManager = (ClipboardManager) ChatActivity.this.getSystemService("clipboard");
                    ClipData newPlainText = ClipData.newPlainText(ChatActivity.this.getString(C2030R.string.app_name), x7);
                    if (clipboardManager != null) {
                        clipboardManager.setPrimaryClip(newPlainText);
                        break;
                    }
                    break;
                case C2030R.id.two /*2131297111*/:
                    if (ChatActivity.this.f12562n0) {
                        e eVar = (e) ChatActivity.this.f12553e0.get(i8 - 1);
                        int i10 = eVar.z();
                        String c8 = eVar.F();
                        if (!ChatActivity.this.f12544V.equalsIgnoreCase(c8)) {
                            Intent intent = new Intent().setClass(ChatActivity.this, ChatPersonalActivity.class);
                            intent.putExtra("com.finazzi.distquake.user_code_to", i10);
                            intent.putExtra("com.finazzi.distquake.user_nick", c8);
                            ChatActivity.this.startActivity(intent);
                            return true;
                        }
                    } else {
                        ChatActivity chatActivity3 = ChatActivity.this;
                        Toast makeText = Toast.makeText(chatActivity3, chatActivity3.getString(C2030R.string.chat_register2), 1);
                        makeText.setGravity(17, 0, 0);
                        makeText.show();
                        return true;
                    }
                    break;
                case C2030R.id.zero /*2131297146*/:
                    if (ChatActivity.this.f12562n0) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(ChatActivity.this);
                        builder.setMessage(ChatActivity.this.getString(C2030R.string.friend_require_confirm));
                        builder.setCancelable(true);
                        builder.setNegativeButton(ChatActivity.this.getString(C2030R.string.manual_yes), new C1072e(dVar, i8));
                        builder.setPositiveButton(ChatActivity.this.getString(C2030R.string.status_cancel), new C1073f());
                        builder.create().show();
                        return true;
                    }
                    ChatActivity chatActivity4 = ChatActivity.this;
                    Toast makeText2 = Toast.makeText(chatActivity4, chatActivity4.getString(C2030R.string.chat_register2), 1);
                    makeText2.setGravity(17, 0, 0);
                    makeText2.show();
                    return true;
            }
            return true;
        }

        public static /* synthetic */ void c(DialogInterface dialogInterface, int i8) {
        }

        public void onItemClick(AdapterView adapterView, View view, int i8, long j8) {
            int i9 = i8 + 1;
            W w7 = new W(ChatActivity.this, view);
            w7.b().inflate(C2030R.menu.chat_popup, w7.a());
            if (ChatActivity.this.f12548Z == 0) {
                w7.a().getItem(5).setVisible(false);
            }
            w7.c(new C1071d(this, i9));
            w7.d();
        }

        /* synthetic */ d(ChatActivity chatActivity, C1066a aVar) {
            this();
        }
    }

    private class e {

        /* renamed from: a  reason: collision with root package name */
        private String f12584a;

        /* renamed from: b  reason: collision with root package name */
        private int f12585b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f12586c;

        /* renamed from: d  reason: collision with root package name */
        private String f12587d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public int f12588e;

        /* renamed from: f  reason: collision with root package name */
        private int f12589f;

        /* renamed from: g  reason: collision with root package name */
        private int f12590g;

        /* renamed from: h  reason: collision with root package name */
        private int f12591h;

        /* renamed from: i  reason: collision with root package name */
        private int f12592i;

        /* renamed from: j  reason: collision with root package name */
        private int f12593j;

        /* renamed from: k  reason: collision with root package name */
        private int f12594k;

        /* renamed from: l  reason: collision with root package name */
        private int f12595l;

        private e() {
        }

        /* access modifiers changed from: private */
        public int A() {
            return this.f12593j;
        }

        /* access modifiers changed from: private */
        public String B() {
            return this.f12587d;
        }

        /* access modifiers changed from: private */
        public String C() {
            return this.f12584a;
        }

        /* access modifiers changed from: private */
        public int D() {
            return this.f12589f;
        }

        /* access modifiers changed from: private */
        public int E() {
            return this.f12585b;
        }

        /* access modifiers changed from: private */
        public String F() {
            return this.f12586c;
        }

        /* access modifiers changed from: private */
        public int G() {
            return this.f12594k;
        }

        /* access modifiers changed from: private */
        public int H() {
            return this.f12592i;
        }

        /* access modifiers changed from: private */
        public int I() {
            return this.f12590g;
        }

        /* access modifiers changed from: private */
        public int J() {
            return this.f12591h;
        }

        /* access modifiers changed from: private */
        public void K(int i8) {
            this.f12588e = i8;
        }

        /* access modifiers changed from: private */
        public void L(int i8) {
            this.f12593j = i8;
        }

        /* access modifiers changed from: private */
        public void M(String str) {
            this.f12587d = str;
        }

        /* access modifiers changed from: private */
        public void N(int i8) {
            this.f12595l = i8;
        }

        /* access modifiers changed from: private */
        public void O(String str) {
            this.f12584a = str;
        }

        /* access modifiers changed from: private */
        public void P(int i8) {
            this.f12589f = i8;
        }

        /* access modifiers changed from: private */
        public void Q(int i8) {
            this.f12585b = i8;
        }

        /* access modifiers changed from: private */
        public void R(String str) {
            this.f12586c = str;
        }

        /* access modifiers changed from: private */
        public void S(int i8) {
            this.f12594k = i8;
        }

        /* access modifiers changed from: private */
        public void T(int i8) {
            this.f12592i = i8;
        }

        /* access modifiers changed from: private */
        public void U(int i8) {
            this.f12590g = i8;
        }

        /* access modifiers changed from: private */
        public void V(int i8) {
            this.f12591h = i8;
        }

        /* access modifiers changed from: private */
        public int z() {
            return this.f12588e;
        }

        /* synthetic */ e(ChatActivity chatActivity, C1066a aVar) {
            this();
        }
    }

    private class f implements AdapterView.OnItemClickListener {
        private f() {
        }

        public static /* synthetic */ void a(DialogInterface dialogInterface, int i8) {
        }

        public static /* synthetic */ void b(f fVar, int i8, DialogInterface dialogInterface, int i9) {
            if (ChatActivity.this.G1()) {
                String L02 = ChatActivity.this.w1();
                int h8 = ((z) ChatActivity.this.f12555g0.get(i8)).f12705b;
                String i10 = ((z) ChatActivity.this.f12555g0.get(i8)).f12704a;
                if (ChatActivity.this.f12546X == h8) {
                    Toast makeText = Toast.makeText(ChatActivity.this.getApplicationContext(), ChatActivity.this.getString(C2030R.string.friend_yourself), 0);
                    makeText.setGravity(17, 0, 0);
                    makeText.show();
                    return;
                }
                ChatActivity chatActivity = ChatActivity.this;
                new q(chatActivity, L02, chatActivity.f12546X, h8, ChatActivity.this.f12544V, i10, ChatActivity.this.f12551c0, (C1066a) null).execute(new Context[0]);
                return;
            }
            Toast makeText2 = Toast.makeText(ChatActivity.this.getApplicationContext(), ChatActivity.this.getString(C2030R.string.main_nointernet), 0);
            makeText2.setGravity(17, 0, 0);
            makeText2.show();
        }

        public static /* synthetic */ boolean c(f fVar, int i8, MenuItem menuItem) {
            fVar.getClass();
            switch (menuItem.getItemId()) {
                case C2030R.id.five /*2131296624*/:
                    ChatActivity chatActivity = ChatActivity.this;
                    chatActivity.q1(chatActivity.w1(), ((z) ChatActivity.this.f12555g0.get(i8)).f12705b, ChatActivity.this.f12544V, ChatActivity.this.F1(), ChatActivity.this.f12552d0);
                    return true;
                case C2030R.id.one /*2131296845*/:
                    ChatActivity.this.M1(i8);
                    return true;
                case C2030R.id.three /*2131297085*/:
                    if (ChatActivity.this.f12562n0) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(ChatActivity.this);
                        builder.setMessage(ChatActivity.this.getString(C2030R.string.friend_require_confirm));
                        builder.setCancelable(true);
                        builder.setNegativeButton(ChatActivity.this.getString(C2030R.string.manual_yes), new C1075h(fVar, i8));
                        builder.setPositiveButton(ChatActivity.this.getString(C2030R.string.status_cancel), new C1076i());
                        builder.create().show();
                        return true;
                    }
                    ChatActivity chatActivity2 = ChatActivity.this;
                    Toast makeText = Toast.makeText(chatActivity2, chatActivity2.getString(C2030R.string.chat_register2), 1);
                    makeText.setGravity(17, 0, 0);
                    makeText.show();
                    return true;
                case C2030R.id.two /*2131297111*/:
                    if (ChatActivity.this.f12562n0) {
                        z zVar = (z) ChatActivity.this.f12555g0.get(i8);
                        int g8 = zVar.q();
                        String a8 = zVar.u();
                        if (!ChatActivity.this.f12544V.equalsIgnoreCase(a8)) {
                            Intent intent = new Intent().setClass(ChatActivity.this, ChatPersonalActivity.class);
                            intent.putExtra("com.finazzi.distquake.user_code_to", g8);
                            intent.putExtra("com.finazzi.distquake.user_nick", a8);
                            ChatActivity.this.startActivity(intent);
                            break;
                        }
                    } else {
                        ChatActivity chatActivity3 = ChatActivity.this;
                        Toast makeText2 = Toast.makeText(chatActivity3, chatActivity3.getString(C2030R.string.chat_register2), 1);
                        makeText2.setGravity(17, 0, 0);
                        makeText2.show();
                        return true;
                    }
                    break;
            }
            return true;
        }

        public void onItemClick(AdapterView adapterView, View view, int i8, long j8) {
            W w7 = new W(ChatActivity.this, view);
            w7.b().inflate(C2030R.menu.chat_popup_online, w7.a());
            if (ChatActivity.this.f12548Z == 0) {
                w7.a().getItem(3).setVisible(false);
            }
            w7.c(new C1074g(this, i8));
            w7.d();
        }

        /* synthetic */ f(ChatActivity chatActivity, C1066a aVar) {
            this();
        }
    }

    private class g extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private final String f12598a;

        /* renamed from: b  reason: collision with root package name */
        private final String[] f12599b;

        /* renamed from: c  reason: collision with root package name */
        private final String[] f12600c;

        /* renamed from: d  reason: collision with root package name */
        private final String[] f12601d;

        /* renamed from: e  reason: collision with root package name */
        private final int[] f12602e;

        /* renamed from: f  reason: collision with root package name */
        private final int[] f12603f;

        /* renamed from: g  reason: collision with root package name */
        private final int[] f12604g;

        /* renamed from: h  reason: collision with root package name */
        private final int[] f12605h;

        /* renamed from: i  reason: collision with root package name */
        private final int[] f12606i;

        /* renamed from: j  reason: collision with root package name */
        private final int f12607j;

        /* synthetic */ g(ChatActivity chatActivity, String str, int[] iArr, int[] iArr2, String[] strArr, String[] strArr2, String[] strArr3, int[] iArr3, int[] iArr4, int[] iArr5, int i8, C1066a aVar) {
            this(str, iArr, iArr2, strArr, strArr2, strArr3, iArr3, iArr4, iArr5, i8);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Context... contextArr) {
            ChatActivity chatActivity = ChatActivity.this;
            SQLiteDatabase unused = chatActivity.f12541S = chatActivity.f12542T.getWritableDatabase();
            if (ChatActivity.this.f12541S == null) {
                return "COMPLETE!";
            }
            ContentValues contentValues = new ContentValues();
            for (int i8 = 0; i8 < this.f12602e.length; i8++) {
                if (this.f12603f[i8] != ChatActivity.this.f12546X) {
                    if (ChatActivity.this.f12574z0 != null) {
                        int[] h12 = ChatActivity.this.f12574z0;
                        int length = h12.length;
                        int i9 = 0;
                        while (true) {
                            if (i9 >= length) {
                                break;
                            } else if (h12[i9] == this.f12603f[i8]) {
                                break;
                            } else {
                                i9++;
                            }
                        }
                    }
                    int i10 = this.f12602e[i8];
                    if (i10 > this.f12607j) {
                        contentValues.put("id_db", Integer.valueOf(i10));
                        contentValues.put("user_code", Integer.valueOf(this.f12603f[i8]));
                        contentValues.put("nick", this.f12599b[i8]);
                        contentValues.put("date", this.f12600c[i8]);
                        contentValues.put("message", this.f12601d[i8]);
                        contentValues.put("moderator", Integer.valueOf(this.f12604g[i8]));
                        contentValues.put("country", Integer.valueOf(this.f12605h[i8]));
                        contentValues.put("pro", Integer.valueOf(this.f12606i[i8]));
                        contentValues.put("message_code", 0);
                        contentValues.put("sent", 1);
                        contentValues.put("self", 0);
                        contentValues.put("error", 0);
                        contentValues.put("received", 1);
                        ChatActivity.this.f12541S.insert(this.f12598a, (String) null, contentValues);
                    }
                }
            }
            return "COMPLETE!";
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            for (int i8 = 0; i8 < this.f12602e.length; i8++) {
                if (this.f12603f[i8] != ChatActivity.this.f12546X && this.f12602e[i8] > this.f12607j) {
                    e eVar = new e(ChatActivity.this, (C1066a) null);
                    eVar.O(this.f12601d[i8]);
                    eVar.R(this.f12599b[i8]);
                    eVar.M(this.f12600c[i8]);
                    eVar.K(this.f12603f[i8]);
                    eVar.P(this.f12604g[i8]);
                    eVar.L(this.f12605h[i8]);
                    eVar.S(this.f12606i[i8]);
                    eVar.V(1);
                    eVar.T(1);
                    eVar.U(0);
                    eVar.Q(0);
                    eVar.N(0);
                    ChatActivity.this.f12554f0.d(eVar);
                }
            }
            ChatActivity.this.K1();
            ((ProgressBar) ChatActivity.this.findViewById(C2030R.id.progressBar6)).setVisibility(8);
            ((EditText) ChatActivity.this.findViewById(C2030R.id.editText1)).setEnabled(true);
        }

        private g(String str, int[] iArr, int[] iArr2, String[] strArr, String[] strArr2, String[] strArr3, int[] iArr3, int[] iArr4, int[] iArr5, int i8) {
            this.f12598a = str;
            this.f12602e = iArr;
            this.f12603f = iArr2;
            this.f12599b = strArr;
            this.f12600c = strArr2;
            this.f12601d = strArr3;
            this.f12604g = iArr3;
            this.f12605h = iArr4;
            this.f12606i = iArr5;
            this.f12607j = i8;
        }
    }

    private class h extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private Cursor f12609a;

        /* renamed from: b  reason: collision with root package name */
        private final String f12610b;

        /* renamed from: c  reason: collision with root package name */
        private final boolean f12611c;

        /* synthetic */ h(ChatActivity chatActivity, String str, boolean z7, C1066a aVar) {
            this(str, z7);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Context... contextArr) {
            ChatActivity chatActivity = ChatActivity.this;
            SQLiteDatabase unused = chatActivity.f12541S = chatActivity.f12542T.getReadableDatabase();
            if (ChatActivity.this.f12541S == null) {
                return "COMPLETE!";
            }
            Cursor rawQuery = ChatActivity.this.f12541S.rawQuery("SELECT _id from " + this.f12610b + " order by " + "_id" + " DESC limit 1", (String[]) null);
            if (rawQuery != null && rawQuery.moveToFirst()) {
                long j8 = rawQuery.getLong(0);
                ChatActivity.this.f12541S.delete(this.f12610b, "_id<=" + (j8 - 1000), (String[]) null);
                rawQuery.close();
            }
            String[] strArr = {"_id", "id_db", "user_code", "nick", "date", "message", "moderator", "country", "pro", "message_code", "sent", "received", "error", "self"};
            if (!ChatActivity.this.f12569u0) {
                this.f12609a = ChatActivity.this.f12541S.query(this.f12610b, strArr, (String) null, (String[]) null, (String) null, (String) null, "_id ASC");
                return "COMPLETE!";
            }
            SQLiteDatabase b12 = ChatActivity.this.f12541S;
            String str = this.f12610b;
            this.f12609a = b12.query(str, strArr, "nick LIKE?", new String[]{ChatActivity.this.f12570v0 + "%"}, (String) null, (String) null, "_id ASC");
            return "COMPLETE!";
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            ((ProgressBar) ChatActivity.this.findViewById(C2030R.id.progressBar6)).setVisibility(8);
            ((EditText) ChatActivity.this.findViewById(C2030R.id.editText1)).setEnabled(true);
            Cursor cursor = this.f12609a;
            if (cursor != null) {
                cursor.moveToPosition(-1);
                int unused = ChatActivity.this.f12549a0 = 0;
                while (this.f12609a.moveToNext()) {
                    Cursor cursor2 = this.f12609a;
                    int i8 = cursor2.getInt(cursor2.getColumnIndexOrThrow("id_db"));
                    Cursor cursor3 = this.f12609a;
                    int i9 = cursor3.getInt(cursor3.getColumnIndexOrThrow("user_code"));
                    Cursor cursor4 = this.f12609a;
                    String string = cursor4.getString(cursor4.getColumnIndexOrThrow("nick"));
                    Cursor cursor5 = this.f12609a;
                    String string2 = cursor5.getString(cursor5.getColumnIndexOrThrow("date"));
                    Cursor cursor6 = this.f12609a;
                    String string3 = cursor6.getString(cursor6.getColumnIndexOrThrow("message"));
                    Cursor cursor7 = this.f12609a;
                    int i10 = cursor7.getInt(cursor7.getColumnIndexOrThrow("message_code"));
                    Cursor cursor8 = this.f12609a;
                    int i11 = cursor8.getInt(cursor8.getColumnIndexOrThrow("moderator"));
                    Cursor cursor9 = this.f12609a;
                    int i12 = cursor9.getInt(cursor9.getColumnIndexOrThrow("country"));
                    Cursor cursor10 = this.f12609a;
                    int i13 = cursor10.getInt(cursor10.getColumnIndexOrThrow("pro"));
                    Cursor cursor11 = this.f12609a;
                    int i14 = cursor11.getInt(cursor11.getColumnIndexOrThrow("self"));
                    Cursor cursor12 = this.f12609a;
                    int i15 = cursor12.getInt(cursor12.getColumnIndexOrThrow("sent"));
                    Cursor cursor13 = this.f12609a;
                    int i16 = cursor13.getInt(cursor13.getColumnIndexOrThrow("received"));
                    Cursor cursor14 = this.f12609a;
                    int i17 = cursor14.getInt(cursor14.getColumnIndexOrThrow("error"));
                    e eVar = new e(ChatActivity.this, (C1066a) null);
                    eVar.O(string3);
                    eVar.Q(i10);
                    eVar.R(string);
                    eVar.M(string2);
                    eVar.K(i9);
                    eVar.P(i11);
                    eVar.L(i12);
                    eVar.S(i13);
                    eVar.U(i14);
                    eVar.V(i15);
                    eVar.T(i16);
                    eVar.N(i17);
                    ChatActivity.this.f12554f0.d(eVar);
                    int i18 = i8;
                    if (i18 > ChatActivity.this.f12549a0) {
                        int unused2 = ChatActivity.this.f12549a0 = i18;
                    }
                }
                this.f12609a.close();
                ChatActivity.this.K1();
            }
            if (!this.f12611c) {
                ChatActivity.this.f12554f0.notifyDataSetInvalidated();
            } else if (ChatActivity.this.f12573y0 < 400) {
                ChatActivity.this.s1();
            } else {
                ChatActivity.this.t1();
            }
        }

        private h(String str, boolean z7) {
            this.f12610b = str;
            this.f12611c = z7;
        }
    }

    private class i extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private final String f12613a;

        /* renamed from: b  reason: collision with root package name */
        private final int f12614b;

        /* renamed from: c  reason: collision with root package name */
        private int f12615c;

        /* synthetic */ i(ChatActivity chatActivity, String str, int i8, C1066a aVar) {
            this(str, i8);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Context... contextArr) {
            ChatActivity chatActivity = ChatActivity.this;
            SQLiteDatabase unused = chatActivity.f12541S = chatActivity.f12542T.getWritableDatabase();
            if (ChatActivity.this.f12541S == null) {
                return "COMPLETE!";
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("sent", 1);
            contentValues.put("error", 0);
            SQLiteDatabase b12 = ChatActivity.this.f12541S;
            String str = this.f12613a;
            this.f12615c = b12.update(str, contentValues, "message_code=" + this.f12614b + " AND " + "self" + "=1", (String[]) null);
            return "COMPLETE!";
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            if (this.f12615c > 0) {
                ChatActivity.this.N1(this.f12614b, 0, 1);
            }
        }

        private i(String str, int i8) {
            this.f12613a = str;
            this.f12614b = i8;
        }
    }

    private class j extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private final String f12617a;

        /* renamed from: b  reason: collision with root package name */
        private final int f12618b;

        /* renamed from: c  reason: collision with root package name */
        private int f12619c;

        /* synthetic */ j(ChatActivity chatActivity, String str, int i8, C1066a aVar) {
            this(str, i8);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Context... contextArr) {
            ChatActivity chatActivity = ChatActivity.this;
            SQLiteDatabase unused = chatActivity.f12541S = chatActivity.f12542T.getWritableDatabase();
            if (ChatActivity.this.f12541S == null) {
                return "COMPLETE!";
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("sent", 0);
            contentValues.put("error", 1);
            SQLiteDatabase b12 = ChatActivity.this.f12541S;
            String str = this.f12617a;
            this.f12619c = b12.update(str, contentValues, "message_code=" + this.f12618b + " AND " + "self" + "=1", (String[]) null);
            return "COMPLETE!";
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            if (this.f12619c > 0) {
                ChatActivity.this.N1(this.f12618b, 2, 1);
            }
        }

        private j(String str, int i8) {
            this.f12617a = str;
            this.f12618b = i8;
        }
    }

    private class k extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private Cursor f12621a;

        /* renamed from: b  reason: collision with root package name */
        private final String f12622b;

        /* renamed from: c  reason: collision with root package name */
        private final int f12623c;

        /* synthetic */ k(ChatActivity chatActivity, String str, int i8, C1066a aVar) {
            this(str, i8);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Context... contextArr) {
            String str;
            ChatActivity chatActivity = ChatActivity.this;
            SQLiteDatabase unused = chatActivity.f12541S = chatActivity.f12542T.getReadableDatabase();
            if (ChatActivity.this.f12541S == null) {
                return "COMPLETE!";
            }
            String[] strArr = {"_id", "id_db", "user_code", "nick", "date", "message", "moderator", "country", "pro", "message_code", "sent", "received", "error", "self"};
            if (!ChatActivity.this.f12569u0) {
                str = "_id=" + this.f12623c;
            } else {
                str = "_id=" + this.f12623c + " AND " + "nick" + " LIKE '" + ChatActivity.this.f12570v0 + "%'";
            }
            this.f12621a = ChatActivity.this.f12541S.query(this.f12622b, strArr, str, (String[]) null, (String) null, (String) null, (String) null);
            return "COMPLETE!";
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            Cursor cursor = this.f12621a;
            if (cursor != null) {
                cursor.moveToPosition(-1);
                while (this.f12621a.moveToNext()) {
                    Cursor cursor2 = this.f12621a;
                    int i8 = cursor2.getInt(cursor2.getColumnIndexOrThrow("id_db"));
                    Cursor cursor3 = this.f12621a;
                    int i9 = cursor3.getInt(cursor3.getColumnIndexOrThrow("user_code"));
                    Cursor cursor4 = this.f12621a;
                    String string = cursor4.getString(cursor4.getColumnIndexOrThrow("nick"));
                    Cursor cursor5 = this.f12621a;
                    String string2 = cursor5.getString(cursor5.getColumnIndexOrThrow("date"));
                    Cursor cursor6 = this.f12621a;
                    String string3 = cursor6.getString(cursor6.getColumnIndexOrThrow("message"));
                    Cursor cursor7 = this.f12621a;
                    int i10 = cursor7.getInt(cursor7.getColumnIndexOrThrow("message_code"));
                    Cursor cursor8 = this.f12621a;
                    int i11 = cursor8.getInt(cursor8.getColumnIndexOrThrow("moderator"));
                    Cursor cursor9 = this.f12621a;
                    int i12 = cursor9.getInt(cursor9.getColumnIndexOrThrow("country"));
                    Cursor cursor10 = this.f12621a;
                    int i13 = cursor10.getInt(cursor10.getColumnIndexOrThrow("pro"));
                    Cursor cursor11 = this.f12621a;
                    int i14 = cursor11.getInt(cursor11.getColumnIndexOrThrow("self"));
                    Cursor cursor12 = this.f12621a;
                    int i15 = cursor12.getInt(cursor12.getColumnIndexOrThrow("sent"));
                    Cursor cursor13 = this.f12621a;
                    int i16 = cursor13.getInt(cursor13.getColumnIndexOrThrow("received"));
                    Cursor cursor14 = this.f12621a;
                    int i17 = cursor14.getInt(cursor14.getColumnIndexOrThrow("error"));
                    e eVar = new e(ChatActivity.this, (C1066a) null);
                    eVar.O(string3);
                    eVar.Q(i10);
                    eVar.R(string);
                    eVar.M(string2);
                    eVar.K(i9);
                    eVar.P(i11);
                    eVar.L(i12);
                    eVar.S(i13);
                    eVar.U(i14);
                    eVar.V(i15);
                    eVar.T(i16);
                    eVar.N(i17);
                    ChatActivity.this.f12554f0.d(eVar);
                    int unused = ChatActivity.this.f12549a0 = i8;
                }
                this.f12621a.close();
                if (ChatActivity.this.f12557i0.getLastVisiblePosition() == ChatActivity.this.f12557i0.getAdapter().getCount() - 2 && ChatActivity.this.f12557i0.getChildAt(ChatActivity.this.f12557i0.getChildCount() - 1).getBottom() <= ChatActivity.this.f12557i0.getHeight()) {
                    ChatActivity.this.K1();
                }
            }
        }

        private k(String str, int i8) {
            this.f12622b = str;
            this.f12623c = i8;
        }
    }

    private class l extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private int f12625a;

        /* renamed from: b  reason: collision with root package name */
        private final String f12626b;

        /* renamed from: c  reason: collision with root package name */
        private final String f12627c;

        /* renamed from: d  reason: collision with root package name */
        private final int f12628d;

        /* synthetic */ l(ChatActivity chatActivity, String str, int i8, String str2, C1066a aVar) {
            this(str, i8, str2);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x00d4  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00da  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x00e6  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x00f1  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x00fa  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x0104  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x010e  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0119  */
        /* JADX WARNING: Removed duplicated region for block: B:42:? A[RETURN, SYNTHETIC] */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r8) {
            /*
                r7 = this;
                java.lang.String r8 = "nok"
                java.util.HashMap r0 = new java.util.HashMap
                r0.<init>()
                com.finazzi.distquake.ChatActivity r1 = com.finazzi.distquake.ChatActivity.this
                java.lang.String r1 = r1.f12545W
                java.lang.String r2 = "u_id"
                r0.put(r2, r1)
                com.finazzi.distquake.ChatActivity r1 = com.finazzi.distquake.ChatActivity.this
                int r1 = r1.f12546X
                java.lang.String r1 = java.lang.Integer.toString(r1)
                java.lang.String r2 = "user_code_from"
                r0.put(r2, r1)
                int r1 = r7.f12628d
                java.lang.String r1 = java.lang.Integer.toString(r1)
                java.lang.String r2 = "user_code_to"
                r0.put(r2, r1)
                java.lang.String r1 = "message"
                java.lang.String r2 = r7.f12626b
                r0.put(r1, r2)
                com.finazzi.distquake.ChatActivity r1 = com.finazzi.distquake.ChatActivity.this
                java.lang.String r1 = r1.f12544V
                java.lang.String r2 = "nick"
                r0.put(r2, r1)
                java.lang.String r0 = u2.C1737L.a(r0)
                r1 = 1
                r2 = 0
                java.net.URL r3 = new java.net.URL     // Catch:{ IOException -> 0x00d8, all -> 0x00d1 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00d8, all -> 0x00d1 }
                r4.<init>()     // Catch:{ IOException -> 0x00d8, all -> 0x00d1 }
                com.finazzi.distquake.ChatActivity r5 = com.finazzi.distquake.ChatActivity.this     // Catch:{ IOException -> 0x00d8, all -> 0x00d1 }
                r6 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r5 = r5.getString(r6)     // Catch:{ IOException -> 0x00d8, all -> 0x00d1 }
                r4.append(r5)     // Catch:{ IOException -> 0x00d8, all -> 0x00d1 }
                java.lang.String r5 = "distquake_upload_personal_chat2.php"
                r4.append(r5)     // Catch:{ IOException -> 0x00d8, all -> 0x00d1 }
                java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x00d8, all -> 0x00d1 }
                r3.<init>(r4)     // Catch:{ IOException -> 0x00d8, all -> 0x00d1 }
                java.net.URLConnection r3 = r3.openConnection()     // Catch:{ IOException -> 0x00d8, all -> 0x00d1 }
                java.lang.Object r3 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r3)     // Catch:{ IOException -> 0x00d8, all -> 0x00d1 }
                java.net.URLConnection r3 = (java.net.URLConnection) r3     // Catch:{ IOException -> 0x00d8, all -> 0x00d1 }
                java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ IOException -> 0x00d8, all -> 0x00d1 }
                r3.setDoOutput(r1)     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
                r2 = 10000(0x2710, float:1.4013E-41)
                r3.setConnectTimeout(r2)     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
                r3.setReadTimeout(r2)     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
                java.lang.String r2 = "Content-Type"
                java.lang.String r4 = "application/x-www-form-urlencoded;charset=utf-8"
                r3.setRequestProperty(r2, r4)     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
                java.lang.String r2 = "POST"
                r3.setRequestMethod(r2)     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
                byte[] r2 = r0.getBytes()     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
                int r2 = r2.length     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
                r3.setFixedLengthStreamingMode(r2)     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
                java.io.PrintWriter r2 = new java.io.PrintWriter     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
                java.io.OutputStream r4 = r3.getOutputStream()     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
                r2.<init>(r4)     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
                r2.print(r0)     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
                r2.close()     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
                java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
                java.io.InputStream r2 = r3.getInputStream()     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
                r0.<init>(r2)     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
                java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
                java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
                java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
                r4.<init>(r0, r5)     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
                r2.<init>(r4)     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
                r4.<init>()     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
            L_0x00b7:
                java.lang.String r5 = r2.readLine()     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
                if (r5 == 0) goto L_0x00c6
                r4.append(r5)     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
                goto L_0x00b7
            L_0x00c1:
                r8 = move-exception
                r2 = r3
                goto L_0x00d2
            L_0x00c4:
                r2 = r3
                goto L_0x00d8
            L_0x00c6:
                r0.close()     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
                java.lang.String r0 = r4.toString()     // Catch:{ IOException -> 0x00c4, all -> 0x00c1 }
                r3.disconnect()
                goto L_0x00de
            L_0x00d1:
                r8 = move-exception
            L_0x00d2:
                if (r2 == 0) goto L_0x00d7
                r2.disconnect()
            L_0x00d7:
                throw r8
            L_0x00d8:
                if (r2 == 0) goto L_0x00dd
                r2.disconnect()
            L_0x00dd:
                r0 = r8
            L_0x00de:
                java.lang.String r2 = "ok"
                boolean r2 = r0.equals(r2)
                if (r2 == 0) goto L_0x00e9
                r2 = 0
                r7.f12625a = r2
            L_0x00e9:
                java.lang.String r2 = "banned"
                boolean r2 = r0.equals(r2)
                if (r2 == 0) goto L_0x00f3
                r7.f12625a = r1
            L_0x00f3:
                boolean r8 = r0.equals(r8)
                r1 = 2
                if (r8 == 0) goto L_0x00fc
                r7.f12625a = r1
            L_0x00fc:
                java.lang.String r8 = "wrong"
                boolean r8 = r0.equals(r8)
                if (r8 == 0) goto L_0x0106
                r7.f12625a = r1
            L_0x0106:
                java.lang.String r8 = "usergone"
                boolean r8 = r0.equals(r8)
                if (r8 == 0) goto L_0x0111
                r8 = 3
                r7.f12625a = r8
            L_0x0111:
                java.lang.String r8 = "nofriend"
                boolean r8 = r0.equals(r8)
                if (r8 == 0) goto L_0x011c
                r8 = 4
                r7.f12625a = r8
            L_0x011c:
                java.lang.String r8 = "COMPLETE!"
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.ChatActivity.l.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: c */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            ((ProgressBar) ChatActivity.this.findViewById(C2030R.id.progressBar6)).setVisibility(8);
            ((EditText) ChatActivity.this.findViewById(C2030R.id.editText1)).setEnabled(true);
            EditText editText = (EditText) ChatActivity.this.findViewById(C2030R.id.editText2);
            editText.setEnabled(true);
            Context context = editText.getContext();
            if (this.f12625a == 0) {
                editText.setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                ChatActivity.this.Q1(this.f12626b, this.f12628d, this.f12627c);
                ((LinearLayout) ChatActivity.this.findViewById(C2030R.id.linearPrivate)).setVisibility(8);
                editText.postDelayed(new C1082o(ChatActivity.this), 800);
            }
            if (this.f12625a == 1) {
                Toast makeText = Toast.makeText(context, ChatActivity.this.getString(C2030R.string.chat_pop_blocked_msg), 1);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
            if (this.f12625a == 2) {
                Toast makeText2 = Toast.makeText(context, ChatActivity.this.getString(C2030R.string.manual_error), 1);
                makeText2.setGravity(17, 0, 0);
                makeText2.show();
            }
            if (this.f12625a == 3) {
                Toast makeText3 = Toast.makeText(context, ChatActivity.this.getString(C2030R.string.chat_pop_nouser), 1);
                makeText3.setGravity(17, 0, 0);
                makeText3.show();
            }
            if (this.f12625a == 4) {
                Toast makeText4 = Toast.makeText(context, ChatActivity.this.getString(C2030R.string.friend_nofriend), 1);
                makeText4.setGravity(17, 0, 0);
                makeText4.show();
            }
        }

        private l(String str, int i8, String str2) {
            this.f12626b = str;
            this.f12628d = i8;
            this.f12627c = str2;
        }
    }

    private class m extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private final String f12630a;

        /* renamed from: b  reason: collision with root package name */
        private final String f12631b;

        /* renamed from: c  reason: collision with root package name */
        private final int f12632c;

        /* synthetic */ m(ChatActivity chatActivity, String str, int i8, String str2, C1066a aVar) {
            this(str, i8, str2);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Context... contextArr) {
            ChatActivity chatActivity = ChatActivity.this;
            SQLiteDatabase unused = chatActivity.f12541S = chatActivity.f12542T.getWritableDatabase();
            if (ChatActivity.this.f12541S == null) {
                return "COMPLETE!";
            }
            String format = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(new Date());
            ContentValues contentValues = new ContentValues();
            contentValues.put("user_id_from", 0);
            contentValues.put("user_id_to", Integer.valueOf(this.f12632c));
            contentValues.put("nick_from", ChatActivity.this.f12544V);
            contentValues.put("nick_to", this.f12631b);
            contentValues.put("date", format);
            contentValues.put("message", this.f12630a);
            ChatActivity.this.f12541S.insert("chat_allusers", (String) null, contentValues);
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("user_id_from", Integer.valueOf(this.f12632c));
            contentValues2.put("nick_from", this.f12631b);
            contentValues2.put("read", 1);
            contentValues2.put("date", format);
            contentValues2.put("message", this.f12630a);
            if (((int) ChatActivity.this.f12541S.insertWithOnConflict("chat_preview", (String) null, contentValues2, 4)) != -1) {
                return "COMPLETE!";
            }
            SQLiteDatabase b12 = ChatActivity.this.f12541S;
            b12.update("chat_preview", contentValues2, "user_id_from=" + this.f12632c, (String[]) null);
            return "COMPLETE!";
        }

        private m(String str, int i8, String str2) {
            this.f12630a = str;
            this.f12632c = i8;
            this.f12631b = str2;
        }
    }

    private class n extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private Cursor f12634a;

        private n() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Context... contextArr) {
            ChatActivity chatActivity = ChatActivity.this;
            SQLiteDatabase unused = chatActivity.f12541S = chatActivity.f12542T.getReadableDatabase();
            if (ChatActivity.this.f12541S == null) {
                return "COMPLETE!";
            }
            this.f12634a = ChatActivity.this.f12541S.query("blocked_users", new String[]{"_id", "user_code"}, (String) null, (String[]) null, (String) null, (String) null, (String) null);
            return "COMPLETE!";
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            Cursor cursor = this.f12634a;
            if (cursor != null) {
                cursor.moveToPosition(-1);
                if (this.f12634a.getCount() > 0) {
                    int[] unused = ChatActivity.this.f12574z0 = new int[this.f12634a.getCount()];
                    int i8 = 0;
                    while (this.f12634a.moveToNext()) {
                        Cursor cursor2 = this.f12634a;
                        ChatActivity.this.f12574z0[i8] = cursor2.getInt(cursor2.getColumnIndexOrThrow("user_code"));
                        i8++;
                    }
                }
                this.f12634a.close();
            }
        }

        /* synthetic */ n(ChatActivity chatActivity, C1066a aVar) {
            this();
        }
    }

    private class o extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private String f12636a = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;

        /* renamed from: b  reason: collision with root package name */
        private int f12637b;

        /* renamed from: c  reason: collision with root package name */
        private final int f12638c;

        o(int i8) {
            this.f12638c = i8;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(5:11|10|18|19|(0)(0)) */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x00c4, code lost:
            r7 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00ca, code lost:
            r1.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00d2, code lost:
            r1.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x00c6 */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x00ca  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x00d2  */
        /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r7) {
            /*
                r6 = this;
                java.util.HashMap r7 = new java.util.HashMap
                r7.<init>()
                int r0 = r6.f12638c
                java.lang.String r0 = java.lang.Integer.toString(r0)
                java.lang.String r1 = "idmin"
                r7.put(r1, r0)
                com.finazzi.distquake.ChatActivity r0 = com.finazzi.distquake.ChatActivity.this
                java.lang.String r0 = r0.f12552d0
                java.lang.String r1 = "postfix"
                r7.put(r1, r0)
                java.lang.String r7 = u2.C1737L.a(r7)
                r0 = 1
                r1 = 0
                java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x00c6 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c6 }
                r3.<init>()     // Catch:{ IOException -> 0x00c6 }
                com.finazzi.distquake.ChatActivity r4 = com.finazzi.distquake.ChatActivity.this     // Catch:{ IOException -> 0x00c6 }
                r5 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r4 = r4.getString(r5)     // Catch:{ IOException -> 0x00c6 }
                r3.append(r4)     // Catch:{ IOException -> 0x00c6 }
                java.lang.String r4 = "distquake_download_chat6.php"
                r3.append(r4)     // Catch:{ IOException -> 0x00c6 }
                java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x00c6 }
                r2.<init>(r3)     // Catch:{ IOException -> 0x00c6 }
                java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x00c6 }
                java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch:{ IOException -> 0x00c6 }
                java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch:{ IOException -> 0x00c6 }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x00c6 }
                r2.setDoOutput(r0)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r1 = 10000(0x2710, float:1.4013E-41)
                r2.setConnectTimeout(r1)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r2.setReadTimeout(r1)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.lang.String r1 = "Content-Type"
                java.lang.String r3 = "application/x-www-form-urlencoded;charset=utf-8"
                r2.setRequestProperty(r1, r3)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.lang.String r1 = "POST"
                r2.setRequestMethod(r1)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                byte[] r1 = r7.getBytes()     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                int r1 = r1.length     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r2.setFixedLengthStreamingMode(r1)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.io.OutputStream r3 = r2.getOutputStream()     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r1.print(r7)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r1.close()     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.io.InputStream r1 = r2.getInputStream()     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r7.<init>(r1)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r3.<init>(r7, r4)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r3.<init>()     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
            L_0x0094:
                java.lang.String r4 = r1.readLine()     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                if (r4 == 0) goto L_0x00a8
                r3.append(r4)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.lang.String r4 = "\n"
                r3.append(r4)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                goto L_0x0094
            L_0x00a3:
                r7 = move-exception
                r1 = r2
                goto L_0x00d0
            L_0x00a6:
                r1 = r2
                goto L_0x00c6
            L_0x00a8:
                r7.close()     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.lang.String r7 = r3.toString()     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r6.f12636a = r7     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.lang.String r1 = "no_new\n"
                boolean r7 = r7.equalsIgnoreCase(r1)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                if (r7 == 0) goto L_0x00bd
                r7 = 2
                r6.f12637b = r7     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                goto L_0x00c0
            L_0x00bd:
                r7 = 0
                r6.f12637b = r7     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
            L_0x00c0:
                r2.disconnect()
                goto L_0x00cd
            L_0x00c4:
                r7 = move-exception
                goto L_0x00d0
            L_0x00c6:
                r6.f12637b = r0     // Catch:{ all -> 0x00c4 }
                if (r1 == 0) goto L_0x00cd
                r1.disconnect()
            L_0x00cd:
                java.lang.String r7 = "COMPLETE!"
                return r7
            L_0x00d0:
                if (r1 == 0) goto L_0x00d5
                r1.disconnect()
            L_0x00d5:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.ChatActivity.o.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            ProgressBar progressBar = (ProgressBar) ChatActivity.this.findViewById(C2030R.id.progressBar6);
            progressBar.setVisibility(8);
            EditText editText = (EditText) ChatActivity.this.findViewById(C2030R.id.editText1);
            editText.setEnabled(true);
            if (ChatActivity.this.f12562n0) {
                ChatActivity.this.P1();
            }
            if (this.f12637b == 0) {
                try {
                    JSONArray jSONArray = new JSONArray(this.f12636a);
                    int length = jSONArray.length();
                    int[] iArr = new int[length];
                    int[] iArr2 = new int[length];
                    String[] strArr = new String[length];
                    String[] strArr2 = new String[length];
                    String[] strArr3 = new String[length];
                    int[] iArr3 = new int[length];
                    int[] iArr4 = new int[length];
                    int[] iArr5 = new int[length];
                    int[] iArr6 = new int[length];
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
                    Date date = new Date();
                    int i8 = 0;
                    while (i8 < length) {
                        Date date2 = date;
                        JSONObject jSONObject = jSONArray.getJSONObject(i8);
                        iArr[i8] = Integer.parseInt(jSONObject.getString("ID"));
                        iArr2[i8] = Integer.parseInt(jSONObject.getString("ud"));
                        strArr[i8] = jSONObject.getString("mg");
                        iArr6[i8] = Integer.parseInt(jSONObject.getString("df"));
                        int i9 = length;
                        int i10 = i8;
                        strArr2[i10] = simpleDateFormat.format(new Date(date2.getTime() - ((long) (iArr6[i8] * 60000))));
                        strArr3[i10] = jSONObject.getString("nk");
                        iArr3[i10] = Integer.parseInt(jSONObject.getString("mo"));
                        iArr4[i10] = Integer.parseInt(jSONObject.getString("ct"));
                        iArr5[i10] = Integer.parseInt(jSONObject.getString("pr"));
                        i8 = i10 + 1;
                        date = date2;
                        jSONArray = jSONArray;
                        length = i9;
                    }
                    progressBar.setVisibility(0);
                    editText.setEnabled(false);
                    int[] iArr7 = iArr4;
                    ChatActivity chatActivity = ChatActivity.this;
                    new g(chatActivity, chatActivity.f12543U, iArr, iArr2, strArr3, strArr2, strArr, iArr3, iArr7, iArr5, this.f12638c, (C1066a) null).execute(new Context[]{ChatActivity.this.getApplicationContext()});
                } catch (JSONException unused) {
                }
            }
        }
    }

    private class p extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private String f12640a = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;

        /* renamed from: b  reason: collision with root package name */
        private int f12641b;

        /* renamed from: c  reason: collision with root package name */
        private final int f12642c;

        p(int i8) {
            this.f12642c = i8;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00ce, code lost:
            r2.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x00ca */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x00ce  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x00d6  */
        /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r8) {
            /*
                r7 = this;
                r8 = 1
                r0 = 0
                java.util.HashMap r1 = new java.util.HashMap
                r1.<init>()
                com.finazzi.distquake.ChatActivity r2 = com.finazzi.distquake.ChatActivity.this
                java.lang.String r2 = r2.f12552d0
                java.lang.String r3 = "postfix"
                r1.put(r3, r2)
                java.lang.String r1 = u2.C1737L.a(r1)
                r2 = 0
                com.finazzi.distquake.ChatActivity r3 = com.finazzi.distquake.ChatActivity.this     // Catch:{ IOException -> 0x00ca }
                java.lang.Class<com.finazzi.distquake.MainActivity> r4 = com.finazzi.distquake.MainActivity.class
                java.lang.String r4 = r4.getSimpleName()     // Catch:{ IOException -> 0x00ca }
                android.content.SharedPreferences r3 = r3.getSharedPreferences(r4, r0)     // Catch:{ IOException -> 0x00ca }
                java.lang.String r4 = "sub_domain"
                com.finazzi.distquake.ChatActivity r5 = com.finazzi.distquake.ChatActivity.this     // Catch:{ IOException -> 0x00ca }
                r6 = 2131887099(0x7f1203fb, float:1.9408796E38)
                java.lang.String r5 = r5.getString(r6)     // Catch:{ IOException -> 0x00ca }
                java.lang.String r3 = r3.getString(r4, r5)     // Catch:{ IOException -> 0x00ca }
                com.finazzi.distquake.ChatActivity r4 = com.finazzi.distquake.ChatActivity.this     // Catch:{ IOException -> 0x00ca }
                r5 = 2131887098(0x7f1203fa, float:1.9408793E38)
                java.lang.String r4 = r4.getString(r5)     // Catch:{ IOException -> 0x00ca }
                java.lang.Object[] r5 = new java.lang.Object[r8]     // Catch:{ IOException -> 0x00ca }
                r5[r0] = r3     // Catch:{ IOException -> 0x00ca }
                java.lang.String r3 = java.lang.String.format(r4, r5)     // Catch:{ IOException -> 0x00ca }
                java.net.URL r4 = new java.net.URL     // Catch:{ IOException -> 0x00ca }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00ca }
                r5.<init>()     // Catch:{ IOException -> 0x00ca }
                r5.append(r3)     // Catch:{ IOException -> 0x00ca }
                java.lang.String r3 = "distquake_download_chat6_cache.php?"
                r5.append(r3)     // Catch:{ IOException -> 0x00ca }
                r5.append(r1)     // Catch:{ IOException -> 0x00ca }
                java.lang.String r1 = r5.toString()     // Catch:{ IOException -> 0x00ca }
                r4.<init>(r1)     // Catch:{ IOException -> 0x00ca }
                java.net.URLConnection r1 = r4.openConnection()     // Catch:{ IOException -> 0x00ca }
                java.lang.Object r1 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r1)     // Catch:{ IOException -> 0x00ca }
                java.net.URLConnection r1 = (java.net.URLConnection) r1     // Catch:{ IOException -> 0x00ca }
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ IOException -> 0x00ca }
                r1.setDoOutput(r0)     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                r2 = 10000(0x2710, float:1.4013E-41)
                r1.setConnectTimeout(r2)     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                r1.setReadTimeout(r2)     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                java.lang.String r2 = "Content-Type"
                java.lang.String r3 = "application/x-www-form-urlencoded;charset=utf-8"
                r1.setRequestProperty(r2, r3)     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                java.lang.String r2 = "GET"
                r1.setRequestMethod(r2)     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                java.io.InputStream r3 = r1.getInputStream()     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                r2.<init>(r3)     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                r4.<init>(r2, r5)     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                r3.<init>(r4)     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                r4.<init>()     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
            L_0x0099:
                java.lang.String r5 = r3.readLine()     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                if (r5 == 0) goto L_0x00ad
                r4.append(r5)     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                java.lang.String r5 = "\n"
                r4.append(r5)     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                goto L_0x0099
            L_0x00a8:
                r8 = move-exception
                r2 = r1
                goto L_0x00d4
            L_0x00ab:
                r2 = r1
                goto L_0x00ca
            L_0x00ad:
                r2.close()     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                java.lang.String r2 = r4.toString()     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                r7.f12640a = r2     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                java.lang.String r3 = "no_new\n"
                boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                if (r2 == 0) goto L_0x00c2
                r0 = 2
                r7.f12641b = r0     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
                goto L_0x00c4
            L_0x00c2:
                r7.f12641b = r0     // Catch:{ IOException -> 0x00ab, all -> 0x00a8 }
            L_0x00c4:
                r1.disconnect()
                goto L_0x00d1
            L_0x00c8:
                r8 = move-exception
                goto L_0x00d4
            L_0x00ca:
                r7.f12641b = r8     // Catch:{ all -> 0x00c8 }
                if (r2 == 0) goto L_0x00d1
                r2.disconnect()
            L_0x00d1:
                java.lang.String r8 = "COMPLETE!"
                return r8
            L_0x00d4:
                if (r2 == 0) goto L_0x00d9
                r2.disconnect()
            L_0x00d9:
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.ChatActivity.p.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            ProgressBar progressBar = (ProgressBar) ChatActivity.this.findViewById(C2030R.id.progressBar6);
            progressBar.setVisibility(8);
            EditText editText = (EditText) ChatActivity.this.findViewById(C2030R.id.editText1);
            editText.setEnabled(true);
            if (ChatActivity.this.f12562n0) {
                ChatActivity.this.P1();
            }
            if (this.f12641b == 0) {
                try {
                    JSONArray jSONArray = new JSONArray(this.f12640a);
                    int length = jSONArray.length();
                    int[] iArr = new int[length];
                    int[] iArr2 = new int[length];
                    String[] strArr = new String[length];
                    String[] strArr2 = new String[length];
                    String[] strArr3 = new String[length];
                    int[] iArr3 = new int[length];
                    int[] iArr4 = new int[length];
                    int[] iArr5 = new int[length];
                    int[] iArr6 = new int[length];
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
                    Date date = new Date();
                    int i8 = 0;
                    while (i8 < length) {
                        Date date2 = date;
                        JSONObject jSONObject = jSONArray.getJSONObject(i8);
                        iArr[i8] = Integer.parseInt(jSONObject.getString("ID"));
                        iArr2[i8] = Integer.parseInt(jSONObject.getString("ud"));
                        strArr[i8] = jSONObject.getString("mg");
                        iArr6[i8] = Integer.parseInt(jSONObject.getString("df"));
                        int i9 = length;
                        int i10 = i8;
                        strArr2[i10] = simpleDateFormat.format(new Date(date2.getTime() - ((long) (iArr6[i8] * 60000))));
                        strArr3[i10] = jSONObject.getString("nk");
                        iArr3[i10] = Integer.parseInt(jSONObject.getString("mo"));
                        iArr4[i10] = Integer.parseInt(jSONObject.getString("ct"));
                        iArr5[i10] = Integer.parseInt(jSONObject.getString("pr"));
                        i8 = i10 + 1;
                        date = date2;
                        jSONArray = jSONArray;
                        length = i9;
                    }
                    progressBar.setVisibility(0);
                    editText.setEnabled(false);
                    int[] iArr7 = iArr4;
                    ChatActivity chatActivity = ChatActivity.this;
                    new g(chatActivity, chatActivity.f12543U, iArr, iArr2, strArr3, strArr2, strArr, iArr3, iArr7, iArr5, this.f12642c, (C1066a) null).execute(new Context[]{ChatActivity.this.getApplicationContext()});
                } catch (JSONException unused) {
                }
            }
        }
    }

    private class q extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private int f12644a;

        /* renamed from: b  reason: collision with root package name */
        private int f12645b;

        /* renamed from: c  reason: collision with root package name */
        private int f12646c;

        /* renamed from: d  reason: collision with root package name */
        private final int f12647d;

        /* renamed from: e  reason: collision with root package name */
        private final int f12648e;

        /* renamed from: f  reason: collision with root package name */
        private final String f12649f;

        /* renamed from: g  reason: collision with root package name */
        private final String f12650g;

        /* renamed from: h  reason: collision with root package name */
        private final String f12651h;

        /* renamed from: i  reason: collision with root package name */
        private final String f12652i;

        /* synthetic */ q(ChatActivity chatActivity, String str, int i8, int i9, String str2, String str3, String str4, C1066a aVar) {
            this(str, i8, i9, str2, str3, str4);
        }

        public static /* synthetic */ void a(DialogInterface dialogInterface, int i8) {
        }

        public static /* synthetic */ void b(DialogInterface dialogInterface, int i8) {
        }

        public static /* synthetic */ void c(DialogInterface dialogInterface, int i8) {
        }

        public static /* synthetic */ void d(DialogInterface dialogInterface, int i8) {
        }

        public static /* synthetic */ void e(DialogInterface dialogInterface, int i8) {
        }

        public static /* synthetic */ void f(DialogInterface dialogInterface, int i8) {
        }

        public static /* synthetic */ void g(DialogInterface dialogInterface, int i8) {
        }

        public static /* synthetic */ void h(DialogInterface dialogInterface, int i8) {
        }

        public static /* synthetic */ void i(DialogInterface dialogInterface, int i8) {
        }

        public static /* synthetic */ void j(DialogInterface dialogInterface, int i8) {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't fix incorrect switch cases order */
        /* JADX WARNING: Can't wrap try/catch for region: R(5:12|11|67|68|(0)(0)) */
        /* JADX WARNING: Code restructure failed: missing block: B:66:0x018b, code lost:
            r15 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:70:0x0191, code lost:
            r2.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:72:0x0199, code lost:
            r2.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:75:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:77:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x018d */
        /* JADX WARNING: Removed duplicated region for block: B:70:0x0191  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x0199  */
        /* JADX WARNING: Removed duplicated region for block: B:77:? A[RETURN, SYNTHETIC] */
        /* renamed from: k */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r15) {
            /*
                r14 = this;
                java.lang.String r15 = "ban"
                java.util.HashMap r0 = new java.util.HashMap
                r0.<init>()
                java.lang.String r1 = "u_id"
                java.lang.String r2 = r14.f12649f
                r0.put(r1, r2)
                int r1 = r14.f12647d
                java.lang.String r1 = java.lang.Integer.toString(r1)
                java.lang.String r2 = "user_code_from"
                r0.put(r2, r1)
                int r1 = r14.f12648e
                java.lang.String r1 = java.lang.Integer.toString(r1)
                java.lang.String r2 = "user_code_to"
                r0.put(r2, r1)
                java.lang.String r1 = "nick_from"
                java.lang.String r2 = r14.f12650g
                r0.put(r1, r2)
                java.lang.String r1 = "nick_to"
                java.lang.String r2 = r14.f12651h
                r0.put(r1, r2)
                java.lang.String r1 = "wal"
                java.lang.String r2 = r14.f12652i
                r0.put(r1, r2)
                java.lang.String r0 = u2.C1737L.a(r0)
                r1 = 10
                r2 = 0
                java.net.URL r3 = new java.net.URL     // Catch:{ IOException -> 0x018d }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x018d }
                r4.<init>()     // Catch:{ IOException -> 0x018d }
                com.finazzi.distquake.ChatActivity r5 = com.finazzi.distquake.ChatActivity.this     // Catch:{ IOException -> 0x018d }
                r6 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r5 = r5.getString(r6)     // Catch:{ IOException -> 0x018d }
                r4.append(r5)     // Catch:{ IOException -> 0x018d }
                java.lang.String r5 = "distquake_upload_friend_request.php"
                r4.append(r5)     // Catch:{ IOException -> 0x018d }
                java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x018d }
                r3.<init>(r4)     // Catch:{ IOException -> 0x018d }
                java.net.URLConnection r3 = r3.openConnection()     // Catch:{ IOException -> 0x018d }
                java.lang.Object r3 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r3)     // Catch:{ IOException -> 0x018d }
                java.net.URLConnection r3 = (java.net.URLConnection) r3     // Catch:{ IOException -> 0x018d }
                java.net.HttpURLConnection r3 = (java.net.HttpURLConnection) r3     // Catch:{ IOException -> 0x018d }
                r2 = 1
                r3.setDoOutput(r2)     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                r4 = 10000(0x2710, float:1.4013E-41)
                r3.setConnectTimeout(r4)     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                r3.setReadTimeout(r4)     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                java.lang.String r4 = "Content-Type"
                java.lang.String r5 = "application/x-www-form-urlencoded;charset=utf-8"
                r3.setRequestProperty(r4, r5)     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                java.lang.String r4 = "POST"
                r3.setRequestMethod(r4)     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                byte[] r4 = r0.getBytes()     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                int r4 = r4.length     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                r3.setFixedLengthStreamingMode(r4)     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                java.io.PrintWriter r4 = new java.io.PrintWriter     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                java.io.OutputStream r5 = r3.getOutputStream()     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                r4.<init>(r5)     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                r4.print(r0)     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                r4.close()     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                java.io.BufferedInputStream r0 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                java.io.InputStream r4 = r3.getInputStream()     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                r0.<init>(r4)     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                java.io.InputStreamReader r5 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                java.nio.charset.Charset r6 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                r5.<init>(r0, r6)     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                r4.<init>(r5)     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                r5.<init>()     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
            L_0x00b4:
                java.lang.String r6 = r4.readLine()     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                if (r6 == 0) goto L_0x00c5
                r5.append(r6)     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                goto L_0x00b4
            L_0x00be:
                r15 = move-exception
                r2 = r3
                goto L_0x0197
            L_0x00c2:
                r2 = r3
                goto L_0x018d
            L_0x00c5:
                r0.close()     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                java.lang.String r0 = r5.toString()     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                boolean r4 = r0.contains(r15)     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                r5 = 2
                r6 = 3
                if (r4 == 0) goto L_0x00ee
                java.lang.String r4 = "-"
                java.lang.String[] r0 = r0.split(r4)     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                int r4 = r0.length     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                if (r4 != r6) goto L_0x00ed
                r4 = r0[r2]     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                int r4 = java.lang.Integer.parseInt(r4)     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                r14.f12646c = r4     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                r0 = r0[r5]     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                int r0 = java.lang.Integer.parseInt(r0)     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                r14.f12645b = r0     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
            L_0x00ed:
                r0 = r15
            L_0x00ee:
                int r4 = r0.hashCode()     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                r7 = 7
                r8 = 0
                r9 = 4
                r10 = 5
                r11 = 6
                r12 = 9
                r13 = 8
                switch(r4) {
                    case -1266275175: goto L_0x0159;
                    case -1140064845: goto L_0x014f;
                    case 3548: goto L_0x0145;
                    case 97295: goto L_0x013d;
                    case 99330: goto L_0x0133;
                    case 101661: goto L_0x0129;
                    case 112798: goto L_0x011f;
                    case 104995772: goto L_0x0115;
                    case 1615526678: goto L_0x010b;
                    case 2129047846: goto L_0x0100;
                    default: goto L_0x00fe;
                }     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
            L_0x00fe:
                goto L_0x0163
            L_0x0100:
                java.lang.String r15 = "not_act"
                boolean r15 = r0.equals(r15)     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                if (r15 == 0) goto L_0x0163
                r15 = r13
                goto L_0x0164
            L_0x010b:
                java.lang.String r15 = "not_found"
                boolean r15 = r0.equals(r15)     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                if (r15 == 0) goto L_0x0163
                r15 = r12
                goto L_0x0164
            L_0x0115:
                java.lang.String r15 = "nofri"
                boolean r15 = r0.equals(r15)     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                if (r15 == 0) goto L_0x0163
                r15 = r11
                goto L_0x0164
            L_0x011f:
                java.lang.String r15 = "req"
                boolean r15 = r0.equals(r15)     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                if (r15 == 0) goto L_0x0163
                r15 = r6
                goto L_0x0164
            L_0x0129:
                java.lang.String r15 = "fri"
                boolean r15 = r0.equals(r15)     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                if (r15 == 0) goto L_0x0163
                r15 = r2
                goto L_0x0164
            L_0x0133:
                java.lang.String r15 = "dec"
                boolean r15 = r0.equals(r15)     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                if (r15 == 0) goto L_0x0163
                r15 = r10
                goto L_0x0164
            L_0x013d:
                boolean r15 = r0.equals(r15)     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                if (r15 == 0) goto L_0x0163
                r15 = r9
                goto L_0x0164
            L_0x0145:
                java.lang.String r15 = "ok"
                boolean r15 = r0.equals(r15)     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                if (r15 == 0) goto L_0x0163
                r15 = r8
                goto L_0x0164
            L_0x014f:
                java.lang.String r15 = "toomany"
                boolean r15 = r0.equals(r15)     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                if (r15 == 0) goto L_0x0163
                r15 = r7
                goto L_0x0164
            L_0x0159:
                java.lang.String r15 = "frinow"
                boolean r15 = r0.equals(r15)     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                if (r15 == 0) goto L_0x0163
                r15 = r5
                goto L_0x0164
            L_0x0163:
                r15 = -1
            L_0x0164:
                switch(r15) {
                    case 0: goto L_0x0185;
                    case 1: goto L_0x0182;
                    case 2: goto L_0x017f;
                    case 3: goto L_0x017c;
                    case 4: goto L_0x0179;
                    case 5: goto L_0x0176;
                    case 6: goto L_0x0173;
                    case 7: goto L_0x0170;
                    case 8: goto L_0x016d;
                    case 9: goto L_0x016a;
                    default: goto L_0x0167;
                }     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
            L_0x0167:
                r14.f12644a = r1     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                goto L_0x0187
            L_0x016a:
                r14.f12644a = r12     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                goto L_0x0187
            L_0x016d:
                r14.f12644a = r13     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                goto L_0x0187
            L_0x0170:
                r14.f12644a = r7     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                goto L_0x0187
            L_0x0173:
                r14.f12644a = r11     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                goto L_0x0187
            L_0x0176:
                r14.f12644a = r10     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                goto L_0x0187
            L_0x0179:
                r14.f12644a = r9     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                goto L_0x0187
            L_0x017c:
                r14.f12644a = r6     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                goto L_0x0187
            L_0x017f:
                r14.f12644a = r5     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                goto L_0x0187
            L_0x0182:
                r14.f12644a = r2     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
                goto L_0x0187
            L_0x0185:
                r14.f12644a = r8     // Catch:{ IOException -> 0x00c2, all -> 0x00be }
            L_0x0187:
                r3.disconnect()
                goto L_0x0194
            L_0x018b:
                r15 = move-exception
                goto L_0x0197
            L_0x018d:
                r14.f12644a = r1     // Catch:{ all -> 0x018b }
                if (r2 == 0) goto L_0x0194
                r2.disconnect()
            L_0x0194:
                java.lang.String r15 = "COMPLETE!"
                return r15
            L_0x0197:
                if (r2 == 0) goto L_0x019c
                r2.disconnect()
            L_0x019c:
                throw r15
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.ChatActivity.q.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: l */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            int i8 = this.f12644a;
            if (i8 == 0) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ChatActivity.this);
                builder.setMessage(ChatActivity.this.getString(C2030R.string.friend_requested));
                builder.setCancelable(false);
                builder.setNegativeButton(ChatActivity.this.getString(C2030R.string.official_close), new C1083p());
                builder.create().show();
            } else if (i8 == 1) {
                AlertDialog.Builder builder2 = new AlertDialog.Builder(ChatActivity.this);
                builder2.setMessage(ChatActivity.this.getString(C2030R.string.friend_already_friend));
                builder2.setCancelable(false);
                builder2.setNegativeButton(ChatActivity.this.getString(C2030R.string.official_close), new C1084q());
                builder2.create().show();
            } else if (i8 == 2) {
                AlertDialog.Builder builder3 = new AlertDialog.Builder(ChatActivity.this);
                builder3.setMessage(ChatActivity.this.getString(C2030R.string.friend_confirmed));
                builder3.setCancelable(false);
                builder3.setNegativeButton(ChatActivity.this.getString(C2030R.string.official_close), new r());
                builder3.create().show();
            } else if (i8 == 3) {
                AlertDialog.Builder builder4 = new AlertDialog.Builder(ChatActivity.this);
                builder4.setMessage(ChatActivity.this.getString(C2030R.string.friend_already_requested));
                builder4.setCancelable(false);
                builder4.setNegativeButton(ChatActivity.this.getString(C2030R.string.official_close), new C1085s());
                builder4.create().show();
            } else if (i8 == 4) {
                AlertDialog.Builder builder5 = new AlertDialog.Builder(ChatActivity.this);
                builder5.setMessage(String.format(ChatActivity.this.getString(C2030R.string.chat_banned), new Object[]{Integer.valueOf(this.f12646c), Integer.valueOf(this.f12645b)}));
                builder5.setCancelable(false);
                builder5.setNegativeButton(ChatActivity.this.getString(C2030R.string.official_close), new C1086t());
                builder5.create().show();
            } else if (i8 == 5) {
                AlertDialog.Builder builder6 = new AlertDialog.Builder(ChatActivity.this);
                builder6.setMessage(ChatActivity.this.getString(C2030R.string.friend_already_denied));
                builder6.setCancelable(false);
                builder6.setNegativeButton(ChatActivity.this.getString(C2030R.string.official_close), new C1087u());
                builder6.create().show();
            } else if (i8 == 6) {
                AlertDialog.Builder builder7 = new AlertDialog.Builder(ChatActivity.this);
                builder7.setMessage(ChatActivity.this.getString(C2030R.string.profile_friendship_disallowed));
                builder7.setCancelable(false);
                builder7.setNegativeButton(ChatActivity.this.getString(C2030R.string.official_close), new C1088v());
                builder7.create().show();
            } else if (i8 == 7) {
                AlertDialog.Builder builder8 = new AlertDialog.Builder(ChatActivity.this);
                builder8.setMessage(ChatActivity.this.getString(C2030R.string.friend_toomany));
                builder8.setCancelable(false);
                builder8.setNegativeButton(ChatActivity.this.getString(C2030R.string.official_close), new C1089w());
                builder8.create().show();
            } else if (i8 == 8) {
                AlertDialog.Builder builder9 = new AlertDialog.Builder(ChatActivity.this);
                builder9.setMessage(ChatActivity.this.getString(C2030R.string.chat_not_active));
                builder9.setCancelable(false);
                builder9.setNegativeButton(ChatActivity.this.getString(C2030R.string.official_close), new C1090x());
                builder9.create().show();
            } else if (i8 == 9) {
                AlertDialog.Builder builder10 = new AlertDialog.Builder(ChatActivity.this);
                builder10.setMessage(ChatActivity.this.getString(C2030R.string.friend_not_found));
                builder10.setCancelable(false);
                builder10.setNegativeButton(ChatActivity.this.getString(C2030R.string.official_close), new C1091y());
                builder10.create().show();
            } else {
                Toast makeText = Toast.makeText(ChatActivity.this.getApplicationContext(), ChatActivity.this.getString(C2030R.string.manual_error), 0);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
        }

        private q(String str, int i8, int i9, String str2, String str3, String str4) {
            this.f12649f = str;
            this.f12647d = i8;
            this.f12648e = i9;
            this.f12650g = str2;
            this.f12651h = str3;
            this.f12652i = str4;
        }
    }

    private class u extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private int f12662a;

        /* renamed from: b  reason: collision with root package name */
        private final String f12663b;

        /* renamed from: c  reason: collision with root package name */
        private final String f12664c;

        /* renamed from: d  reason: collision with root package name */
        private final String f12665d;

        /* renamed from: e  reason: collision with root package name */
        private final int f12666e;

        /* synthetic */ u(ChatActivity chatActivity, String str, String str2, int i8, String str3, C1066a aVar) {
            this(str, str2, i8, str3);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x00c9  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00d4  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x00d8  */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r7) {
            /*
                r6 = this;
                java.util.HashMap r7 = new java.util.HashMap
                r7.<init>()
                java.lang.String r0 = "nick"
                java.lang.String r1 = r6.f12663b
                r7.put(r0, r1)
                java.lang.String r0 = "nick_self"
                java.lang.String r1 = r6.f12664c
                r7.put(r0, r1)
                com.finazzi.distquake.ChatActivity r0 = com.finazzi.distquake.ChatActivity.this
                java.lang.String r0 = r0.w1()
                java.lang.String r1 = "u_id"
                r7.put(r1, r0)
                int r0 = r6.f12666e
                java.lang.String r0 = java.lang.Integer.toString(r0)
                java.lang.String r1 = "user_code"
                r7.put(r1, r0)
                java.lang.String r0 = "postfix"
                java.lang.String r1 = r6.f12665d
                r7.put(r0, r1)
                java.lang.String r7 = u2.C1737L.a(r7)
                r0 = 1
                r1 = 0
                java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x00c5 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c5 }
                r3.<init>()     // Catch:{ IOException -> 0x00c5 }
                com.finazzi.distquake.ChatActivity r4 = com.finazzi.distquake.ChatActivity.this     // Catch:{ IOException -> 0x00c5 }
                r5 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r4 = r4.getString(r5)     // Catch:{ IOException -> 0x00c5 }
                r3.append(r4)     // Catch:{ IOException -> 0x00c5 }
                java.lang.String r4 = "distquake_upload_report_user.php"
                r3.append(r4)     // Catch:{ IOException -> 0x00c5 }
                java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x00c5 }
                r2.<init>(r3)     // Catch:{ IOException -> 0x00c5 }
                java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x00c5 }
                java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch:{ IOException -> 0x00c5 }
                java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch:{ IOException -> 0x00c5 }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x00c5 }
                r2.setDoOutput(r0)     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                r1 = 10000(0x2710, float:1.4013E-41)
                r2.setConnectTimeout(r1)     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                r2.setReadTimeout(r1)     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                java.lang.String r1 = "Content-Type"
                java.lang.String r3 = "application/x-www-form-urlencoded;charset=utf-8"
                r2.setRequestProperty(r1, r3)     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                java.lang.String r1 = "POST"
                r2.setRequestMethod(r1)     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                byte[] r1 = r7.getBytes()     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                int r1 = r1.length     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                r2.setFixedLengthStreamingMode(r1)     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                java.io.OutputStream r3 = r2.getOutputStream()     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                r1.print(r7)     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                r1.close()     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                java.io.InputStream r1 = r2.getInputStream()     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                r7.<init>(r1)     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                r3.<init>(r7, r4)     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                r3.<init>()     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
            L_0x00a9:
                java.lang.String r4 = r1.readLine()     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                if (r4 == 0) goto L_0x00b8
                r3.append(r4)     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                goto L_0x00a9
            L_0x00b3:
                r7 = move-exception
                r1 = r2
                goto L_0x00dd
            L_0x00b6:
                r1 = r2
                goto L_0x00c5
            L_0x00b8:
                r7.close()     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                java.lang.String r7 = r3.toString()     // Catch:{ IOException -> 0x00b6, all -> 0x00b3 }
                r2.disconnect()
                goto L_0x00cc
            L_0x00c3:
                r7 = move-exception
                goto L_0x00dd
            L_0x00c5:
                java.lang.String r7 = "nok"
                if (r1 == 0) goto L_0x00cc
                r1.disconnect()
            L_0x00cc:
                java.lang.String r1 = "ok"
                boolean r7 = r7.equals(r1)
                if (r7 == 0) goto L_0x00d8
                r7 = 0
                r6.f12662a = r7
                goto L_0x00da
            L_0x00d8:
                r6.f12662a = r0
            L_0x00da:
                java.lang.String r7 = "COMPLETE!"
                return r7
            L_0x00dd:
                if (r1 == 0) goto L_0x00e2
                r1.disconnect()
            L_0x00e2:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.ChatActivity.u.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            Toast toast;
            super.onPostExecute(str);
            if (this.f12662a == 0) {
                toast = Toast.makeText(ChatActivity.this.getApplicationContext(), ChatActivity.this.getString(C2030R.string.profile_report_received), 1);
                SharedPreferences.Editor edit = ChatActivity.this.getSharedPreferences(MainActivity.class.getSimpleName(), 0).edit();
                edit.putLong("last_chat_user_report", System.currentTimeMillis());
                edit.apply();
            } else {
                toast = Toast.makeText(ChatActivity.this.getApplicationContext(), ChatActivity.this.getString(C2030R.string.manual_error), 1);
            }
            toast.setGravity(17, 0, 0);
            toast.show();
        }

        private u(String str, String str2, int i8, String str3) {
            this.f12663b = str;
            this.f12664c = str2;
            this.f12666e = i8;
            this.f12665d = str3;
        }
    }

    private class v extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private int f12668a;

        /* renamed from: b  reason: collision with root package name */
        private final String f12669b;

        /* renamed from: c  reason: collision with root package name */
        private final String f12670c;

        /* renamed from: d  reason: collision with root package name */
        private final String f12671d;

        /* renamed from: e  reason: collision with root package name */
        private final String f12672e;

        /* renamed from: f  reason: collision with root package name */
        private final String f12673f;

        /* renamed from: g  reason: collision with root package name */
        private final int f12674g;

        /* synthetic */ v(ChatActivity chatActivity, String str, String str2, int i8, String str3, String str4, String str5, C1066a aVar) {
            this(str, str2, i8, str3, str4, str5);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x00d1  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x00dc  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x00e7  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x00f1  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x00fc  */
        /* JADX WARNING: Removed duplicated region for block: B:32:0x0107  */
        /* JADX WARNING: Removed duplicated region for block: B:38:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r7) {
            /*
                r6 = this;
                java.util.HashMap r7 = new java.util.HashMap
                r7.<init>()
                java.lang.String r0 = "u_id"
                java.lang.String r1 = r6.f12669b
                r7.put(r0, r1)
                java.lang.String r0 = "password_ban"
                java.lang.String r1 = r6.f12670c
                r7.put(r0, r1)
                int r0 = r6.f12674g
                java.lang.String r0 = java.lang.Integer.toString(r0)
                java.lang.String r1 = "user_code"
                r7.put(r1, r0)
                java.lang.String r0 = "nick"
                java.lang.String r1 = r6.f12671d
                r7.put(r0, r1)
                java.lang.String r0 = "uID"
                java.lang.String r1 = r6.f12672e
                r7.put(r0, r1)
                java.lang.String r0 = "postfix"
                java.lang.String r1 = r6.f12673f
                r7.put(r0, r1)
                java.lang.String r7 = u2.C1737L.a(r7)
                r0 = 1
                r1 = 0
                java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x00cd }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00cd }
                r3.<init>()     // Catch:{ IOException -> 0x00cd }
                com.finazzi.distquake.ChatActivity r4 = com.finazzi.distquake.ChatActivity.this     // Catch:{ IOException -> 0x00cd }
                r5 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r4 = r4.getString(r5)     // Catch:{ IOException -> 0x00cd }
                r3.append(r4)     // Catch:{ IOException -> 0x00cd }
                java.lang.String r4 = "distquake_ban_user2.php"
                r3.append(r4)     // Catch:{ IOException -> 0x00cd }
                java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x00cd }
                r2.<init>(r3)     // Catch:{ IOException -> 0x00cd }
                java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x00cd }
                java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch:{ IOException -> 0x00cd }
                java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch:{ IOException -> 0x00cd }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x00cd }
                r2.setDoOutput(r0)     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
                r1 = 10000(0x2710, float:1.4013E-41)
                r2.setConnectTimeout(r1)     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
                r2.setReadTimeout(r1)     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
                java.lang.String r1 = "Content-Type"
                java.lang.String r3 = "application/x-www-form-urlencoded;charset=utf-8"
                r2.setRequestProperty(r1, r3)     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
                java.lang.String r1 = "POST"
                r2.setRequestMethod(r1)     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
                byte[] r1 = r7.getBytes()     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
                int r1 = r1.length     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
                r2.setFixedLengthStreamingMode(r1)     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
                java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
                java.io.OutputStream r3 = r2.getOutputStream()     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
                r1.print(r7)     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
                r1.close()     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
                java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
                java.io.InputStream r1 = r2.getInputStream()     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
                r7.<init>(r1)     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
                java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
                r3.<init>(r7, r4)     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
                r3.<init>()     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
            L_0x00ac:
                java.lang.String r4 = r1.readLine()     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
                if (r4 == 0) goto L_0x00c0
                r3.append(r4)     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
                java.lang.String r4 = "\n"
                r3.append(r4)     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
                goto L_0x00ac
            L_0x00bb:
                r7 = move-exception
                r1 = r2
                goto L_0x010d
            L_0x00be:
                r1 = r2
                goto L_0x00cd
            L_0x00c0:
                r7.close()     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
                java.lang.String r7 = r3.toString()     // Catch:{ IOException -> 0x00be, all -> 0x00bb }
                r2.disconnect()
                goto L_0x00d4
            L_0x00cb:
                r7 = move-exception
                goto L_0x010d
            L_0x00cd:
                java.lang.String r7 = "nok"
                if (r1 == 0) goto L_0x00d4
                r1.disconnect()
            L_0x00d4:
                java.lang.String r1 = "ok\n"
                boolean r1 = r7.equals(r1)
                if (r1 == 0) goto L_0x00df
                r1 = 0
                r6.f12668a = r1
            L_0x00df:
                java.lang.String r1 = "wrongpwd\n"
                boolean r1 = r7.equals(r1)
                if (r1 == 0) goto L_0x00e9
                r6.f12668a = r0
            L_0x00e9:
                java.lang.String r0 = "nomod\n"
                boolean r0 = r7.equals(r0)
                if (r0 == 0) goto L_0x00f4
                r0 = 2
                r6.f12668a = r0
            L_0x00f4:
                java.lang.String r0 = "wrong\n"
                boolean r0 = r7.equals(r0)
                if (r0 == 0) goto L_0x00ff
                r0 = 3
                r6.f12668a = r0
            L_0x00ff:
                java.lang.String r0 = "already\n"
                boolean r7 = r7.equals(r0)
                if (r7 == 0) goto L_0x010a
                r7 = 4
                r6.f12668a = r7
            L_0x010a:
                java.lang.String r7 = "COMPLETE!"
                return r7
            L_0x010d:
                if (r1 == 0) goto L_0x0112
                r1.disconnect()
            L_0x0112:
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.ChatActivity.v.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            if (this.f12668a == 0) {
                Toast makeText = Toast.makeText(ChatActivity.this.getApplicationContext(), ChatActivity.this.getString(C2030R.string.profile_moderator_banned), 1);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
            if (this.f12668a == 1) {
                Toast makeText2 = Toast.makeText(ChatActivity.this.getApplicationContext(), ChatActivity.this.getString(C2030R.string.profile_moderator_wrong_password), 1);
                makeText2.setGravity(17, 0, 0);
                makeText2.show();
            }
            if (this.f12668a == 2) {
                Toast makeText3 = Toast.makeText(ChatActivity.this.getApplicationContext(), ChatActivity.this.getString(C2030R.string.profile_moderator_wrong_id), 1);
                makeText3.setGravity(17, 0, 0);
                makeText3.show();
            }
            if (this.f12668a == 3) {
                Toast makeText4 = Toast.makeText(ChatActivity.this.getApplicationContext(), ChatActivity.this.getString(C2030R.string.manual_error), 1);
                makeText4.setGravity(17, 0, 0);
                makeText4.show();
            }
            if (this.f12668a == 4) {
                Toast makeText5 = Toast.makeText(ChatActivity.this.getApplicationContext(), ChatActivity.this.getString(C2030R.string.profile_moderator_already_banned), 1);
                makeText5.setGravity(17, 0, 0);
                makeText5.show();
            }
        }

        private v(String str, String str2, int i8, String str3, String str4, String str5) {
            this.f12669b = str;
            this.f12670c = str2;
            this.f12674g = i8;
            this.f12671d = str3;
            this.f12672e = str4;
            this.f12673f = str5;
        }
    }

    private class w extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private final String f12676a;

        /* renamed from: b  reason: collision with root package name */
        private final String f12677b;

        /* renamed from: c  reason: collision with root package name */
        private final String f12678c;

        /* renamed from: d  reason: collision with root package name */
        private final String f12679d;

        /* renamed from: e  reason: collision with root package name */
        private final int f12680e;

        /* renamed from: f  reason: collision with root package name */
        private final int f12681f;

        /* renamed from: g  reason: collision with root package name */
        private final int f12682g;

        /* renamed from: h  reason: collision with root package name */
        private final int f12683h;

        /* renamed from: i  reason: collision with root package name */
        private final int f12684i;

        /* synthetic */ w(ChatActivity chatActivity, String str, int i8, String str2, String str3, String str4, int i9, int i10, int i11, int i12, C1066a aVar) {
            this(str, i8, str2, str3, str4, i9, i10, i11, i12);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Context... contextArr) {
            ChatActivity chatActivity = ChatActivity.this;
            SQLiteDatabase unused = chatActivity.f12541S = chatActivity.f12542T.getWritableDatabase();
            if (ChatActivity.this.f12541S == null) {
                return "COMPLETE!";
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("id_db", 0);
            contentValues.put("user_code", Integer.valueOf(this.f12680e));
            contentValues.put("nick", this.f12677b);
            contentValues.put("date", this.f12678c);
            contentValues.put("message", this.f12679d);
            contentValues.put("moderator", 0);
            contentValues.put("country", Integer.valueOf(this.f12683h));
            contentValues.put("pro", Integer.valueOf(this.f12682g));
            contentValues.put("message_code", Integer.valueOf(this.f12681f));
            contentValues.put("sent", 0);
            contentValues.put("received", 0);
            contentValues.put("error", 0);
            contentValues.put("self", 1);
            ChatActivity.this.f12541S.insert(this.f12676a, (String) null, contentValues);
            return "COMPLETE!";
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            e eVar = new e(ChatActivity.this, (C1066a) null);
            eVar.O(this.f12679d);
            eVar.R(this.f12677b);
            eVar.M(this.f12678c);
            eVar.K(this.f12680e);
            eVar.P(0);
            eVar.L(this.f12683h);
            eVar.S(this.f12682g);
            eVar.V(0);
            eVar.T(0);
            eVar.U(1);
            eVar.N(0);
            eVar.Q(this.f12681f);
            ChatActivity.this.f12554f0.d(eVar);
            ((EditText) ChatActivity.this.findViewById(C2030R.id.editText1)).setText(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
            ChatActivity.this.K1();
            ChatActivity chatActivity = ChatActivity.this;
            x unused = chatActivity.f12537O = new x(chatActivity.f12552d0, ChatActivity.this.f12545W, this.f12680e, this.f12677b, this.f12679d, this.f12681f, 830, this.f12683h, this.f12682g, ChatActivity.this.f12550b0, ChatActivity.this.f12551c0, this.f12684i);
            ChatActivity.this.f12537O.execute(new Context[]{ChatActivity.this.getApplicationContext()});
        }

        private w(String str, int i8, String str2, String str3, String str4, int i9, int i10, int i11, int i12) {
            this.f12676a = str;
            this.f12680e = i8;
            this.f12677b = str2;
            this.f12678c = str3;
            this.f12679d = str4;
            this.f12683h = i9;
            this.f12682g = i10;
            this.f12681f = i11;
            this.f12684i = i12;
        }
    }

    private class x extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private int f12686a;

        /* renamed from: b  reason: collision with root package name */
        private int f12687b;

        /* renamed from: c  reason: collision with root package name */
        private int f12688c;

        /* renamed from: d  reason: collision with root package name */
        private final String f12689d;

        /* renamed from: e  reason: collision with root package name */
        private final String f12690e;

        /* renamed from: f  reason: collision with root package name */
        private final String f12691f;

        /* renamed from: g  reason: collision with root package name */
        private final int f12692g;

        /* renamed from: h  reason: collision with root package name */
        private final int f12693h;

        /* renamed from: i  reason: collision with root package name */
        private final int f12694i;

        /* renamed from: j  reason: collision with root package name */
        private final String f12695j;

        /* renamed from: k  reason: collision with root package name */
        private final int f12696k;

        /* renamed from: l  reason: collision with root package name */
        private final String f12697l;

        /* renamed from: m  reason: collision with root package name */
        private final String f12698m;

        /* renamed from: n  reason: collision with root package name */
        private final int f12699n;

        x(String str, String str2, int i8, String str3, String str4, int i9, int i10, int i11, int i12, String str5, String str6, int i13) {
            this.f12691f = str;
            this.f12695j = str2;
            this.f12692g = i8;
            this.f12689d = str3;
            this.f12690e = str4;
            this.f12693h = i9;
            this.f12694i = i10;
            this.f12696k = i12;
            this.f12697l = str5;
            this.f12698m = str6;
            this.f12699n = i13;
        }

        public static /* synthetic */ void a(DialogInterface dialogInterface, int i8) {
        }

        public static /* synthetic */ void b(DialogInterface dialogInterface, int i8) {
        }

        public static /* synthetic */ void c(DialogInterface dialogInterface, int i8) {
        }

        public static /* synthetic */ void d(DialogInterface dialogInterface, int i8) {
        }

        public static /* synthetic */ void e(DialogInterface dialogInterface, int i8) {
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x010c  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x0112  */
        /* JADX WARNING: Removed duplicated region for block: B:24:0x011c  */
        /* JADX WARNING: Removed duplicated region for block: B:30:0x0141  */
        /* JADX WARNING: Removed duplicated region for block: B:33:0x014c  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x0157  */
        /* JADX WARNING: Removed duplicated region for block: B:39:0x0162  */
        /* JADX WARNING: Removed duplicated region for block: B:42:0x016d  */
        /* JADX WARNING: Removed duplicated region for block: B:45:0x0176  */
        /* JADX WARNING: Removed duplicated region for block: B:48:0x017f  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x018c  */
        /* JADX WARNING: Removed duplicated region for block: B:53:0x018f  */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x0192  */
        /* JADX WARNING: Removed duplicated region for block: B:55:0x0195  */
        /* JADX WARNING: Removed duplicated region for block: B:56:0x0198  */
        /* JADX WARNING: Removed duplicated region for block: B:57:0x019b  */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x019e  */
        /* JADX WARNING: Removed duplicated region for block: B:59:0x01a1  */
        /* renamed from: f */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r14) {
            /*
                r13 = this;
                r14 = 5
                r0 = 4
                r1 = 0
                r2 = 3
                r3 = 2
                java.lang.String r4 = "ban"
                java.lang.String r5 = "nok"
                r6 = 1
                java.util.HashMap r7 = new java.util.HashMap
                r7.<init>()
                java.lang.String r8 = "u_id"
                java.lang.String r9 = r13.f12695j
                r7.put(r8, r9)
                java.lang.String r8 = "message"
                java.lang.String r9 = r13.f12690e
                r7.put(r8, r9)
                java.lang.String r8 = "nick"
                java.lang.String r9 = r13.f12689d
                r7.put(r8, r9)
                java.lang.String r8 = "postfix"
                java.lang.String r9 = r13.f12691f
                r7.put(r8, r9)
                int r8 = r13.f12692g
                java.lang.String r8 = java.lang.Integer.toString(r8)
                java.lang.String r9 = "u_code"
                r7.put(r9, r8)
                int r8 = r13.f12693h
                java.lang.String r8 = java.lang.Integer.toString(r8)
                java.lang.String r9 = "msg_code"
                r7.put(r9, r8)
                int r8 = r13.f12694i
                java.lang.String r8 = java.lang.Integer.toString(r8)
                java.lang.String r9 = "ver"
                r7.put(r9, r8)
                int r8 = r13.f12696k
                java.lang.String r8 = java.lang.Integer.toString(r8)
                java.lang.String r9 = "pro"
                r7.put(r9, r8)
                java.lang.String r8 = "uID"
                java.lang.String r9 = r13.f12697l
                r7.put(r8, r9)
                java.lang.String r8 = "wal"
                java.lang.String r9 = r13.f12698m
                r7.put(r8, r9)
                int r8 = r13.f12699n
                java.lang.String r8 = java.lang.Integer.toString(r8)
                java.lang.String r9 = "ch"
                r7.put(r9, r8)
                java.lang.String r8 = "ac"
                java.lang.String r9 = "0"
                r7.put(r8, r9)
                java.lang.String r7 = u2.C1737L.a(r7)
                r8 = 0
                java.net.URL r9 = new java.net.URL     // Catch:{ IOException -> 0x0110, all -> 0x0109 }
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0110, all -> 0x0109 }
                r10.<init>()     // Catch:{ IOException -> 0x0110, all -> 0x0109 }
                com.finazzi.distquake.ChatActivity r11 = com.finazzi.distquake.ChatActivity.this     // Catch:{ IOException -> 0x0110, all -> 0x0109 }
                r12 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r11 = r11.getString(r12)     // Catch:{ IOException -> 0x0110, all -> 0x0109 }
                r10.append(r11)     // Catch:{ IOException -> 0x0110, all -> 0x0109 }
                java.lang.String r11 = "distquake_upload_chat3.php"
                r10.append(r11)     // Catch:{ IOException -> 0x0110, all -> 0x0109 }
                java.lang.String r10 = r10.toString()     // Catch:{ IOException -> 0x0110, all -> 0x0109 }
                r9.<init>(r10)     // Catch:{ IOException -> 0x0110, all -> 0x0109 }
                java.net.URLConnection r9 = r9.openConnection()     // Catch:{ IOException -> 0x0110, all -> 0x0109 }
                java.lang.Object r9 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r9)     // Catch:{ IOException -> 0x0110, all -> 0x0109 }
                java.net.URLConnection r9 = (java.net.URLConnection) r9     // Catch:{ IOException -> 0x0110, all -> 0x0109 }
                java.net.HttpURLConnection r9 = (java.net.HttpURLConnection) r9     // Catch:{ IOException -> 0x0110, all -> 0x0109 }
                r9.setDoOutput(r6)     // Catch:{ IOException -> 0x00fc, all -> 0x00f9 }
                r8 = 10000(0x2710, float:1.4013E-41)
                r9.setConnectTimeout(r8)     // Catch:{ IOException -> 0x00fc, all -> 0x00f9 }
                r9.setReadTimeout(r8)     // Catch:{ IOException -> 0x00fc, all -> 0x00f9 }
                java.lang.String r8 = "Content-Type"
                java.lang.String r10 = "application/x-www-form-urlencoded;charset=utf-8"
                r9.setRequestProperty(r8, r10)     // Catch:{ IOException -> 0x00fc, all -> 0x00f9 }
                java.lang.String r8 = "POST"
                r9.setRequestMethod(r8)     // Catch:{ IOException -> 0x00fc, all -> 0x00f9 }
                byte[] r8 = r7.getBytes()     // Catch:{ IOException -> 0x00fc, all -> 0x00f9 }
                int r8 = r8.length     // Catch:{ IOException -> 0x00fc, all -> 0x00f9 }
                r9.setFixedLengthStreamingMode(r8)     // Catch:{ IOException -> 0x00fc, all -> 0x00f9 }
                java.io.PrintWriter r8 = new java.io.PrintWriter     // Catch:{ IOException -> 0x00fc, all -> 0x00f9 }
                java.io.OutputStream r10 = r9.getOutputStream()     // Catch:{ IOException -> 0x00fc, all -> 0x00f9 }
                r8.<init>(r10)     // Catch:{ IOException -> 0x00fc, all -> 0x00f9 }
                r8.print(r7)     // Catch:{ IOException -> 0x00fc, all -> 0x00f9 }
                r8.close()     // Catch:{ IOException -> 0x00fc, all -> 0x00f9 }
                java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00fc, all -> 0x00f9 }
                java.io.InputStream r8 = r9.getInputStream()     // Catch:{ IOException -> 0x00fc, all -> 0x00f9 }
                r7.<init>(r8)     // Catch:{ IOException -> 0x00fc, all -> 0x00f9 }
                java.io.BufferedReader r8 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00fc, all -> 0x00f9 }
                java.io.InputStreamReader r10 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00fc, all -> 0x00f9 }
                java.nio.charset.Charset r11 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00fc, all -> 0x00f9 }
                r10.<init>(r7, r11)     // Catch:{ IOException -> 0x00fc, all -> 0x00f9 }
                r8.<init>(r10)     // Catch:{ IOException -> 0x00fc, all -> 0x00f9 }
                java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00fc, all -> 0x00f9 }
                r10.<init>()     // Catch:{ IOException -> 0x00fc, all -> 0x00f9 }
            L_0x00ef:
                java.lang.String r11 = r8.readLine()     // Catch:{ IOException -> 0x00fc, all -> 0x00f9 }
                if (r11 == 0) goto L_0x00fe
                r10.append(r11)     // Catch:{ IOException -> 0x00fc, all -> 0x00f9 }
                goto L_0x00ef
            L_0x00f9:
                r14 = move-exception
                r8 = r9
                goto L_0x010a
            L_0x00fc:
                r8 = r9
                goto L_0x0110
            L_0x00fe:
                r7.close()     // Catch:{ IOException -> 0x00fc, all -> 0x00f9 }
                java.lang.String r7 = r10.toString()     // Catch:{ IOException -> 0x00fc, all -> 0x00f9 }
                r9.disconnect()
                goto L_0x0116
            L_0x0109:
                r14 = move-exception
            L_0x010a:
                if (r8 == 0) goto L_0x010f
                r8.disconnect()
            L_0x010f:
                throw r14
            L_0x0110:
                if (r8 == 0) goto L_0x0115
                r8.disconnect()
            L_0x0115:
                r7 = r5
            L_0x0116:
                boolean r8 = r7.contains(r4)
                if (r8 == 0) goto L_0x0136
                java.lang.String r8 = "-"
                java.lang.String[] r7 = r7.split(r8)
                int r8 = r7.length
                if (r8 != r2) goto L_0x0135
                r8 = r7[r6]
                int r8 = java.lang.Integer.parseInt(r8)
                r13.f12688c = r8
                r7 = r7[r3]
                int r7 = java.lang.Integer.parseInt(r7)
                r13.f12687b = r7
            L_0x0135:
                r7 = r4
            L_0x0136:
                r8 = 10
                r9 = -1
                int r10 = r7.hashCode()
                switch(r10) {
                    case 3548: goto L_0x017f;
                    case 97295: goto L_0x0176;
                    case 109258: goto L_0x016d;
                    case 116009: goto L_0x0162;
                    case 3154575: goto L_0x0157;
                    case 1344065746: goto L_0x014c;
                    case 2129047846: goto L_0x0141;
                    default: goto L_0x0140;
                }
            L_0x0140:
                goto L_0x0189
            L_0x0141:
                java.lang.String r4 = "not_act"
                boolean r4 = r7.equals(r4)
                if (r4 != 0) goto L_0x014a
                goto L_0x0189
            L_0x014a:
                r9 = 6
                goto L_0x0189
            L_0x014c:
                java.lang.String r4 = "msg_lim"
                boolean r4 = r7.equals(r4)
                if (r4 != 0) goto L_0x0155
                goto L_0x0189
            L_0x0155:
                r9 = r14
                goto L_0x0189
            L_0x0157:
                java.lang.String r4 = "full"
                boolean r4 = r7.equals(r4)
                if (r4 != 0) goto L_0x0160
                goto L_0x0189
            L_0x0160:
                r9 = r0
                goto L_0x0189
            L_0x0162:
                java.lang.String r4 = "upd"
                boolean r4 = r7.equals(r4)
                if (r4 != 0) goto L_0x016b
                goto L_0x0189
            L_0x016b:
                r9 = r2
                goto L_0x0189
            L_0x016d:
                boolean r4 = r7.equals(r5)
                if (r4 != 0) goto L_0x0174
                goto L_0x0189
            L_0x0174:
                r9 = r3
                goto L_0x0189
            L_0x0176:
                boolean r4 = r7.equals(r4)
                if (r4 != 0) goto L_0x017d
                goto L_0x0189
            L_0x017d:
                r9 = r6
                goto L_0x0189
            L_0x017f:
                java.lang.String r4 = "ok"
                boolean r4 = r7.equals(r4)
                if (r4 != 0) goto L_0x0188
                goto L_0x0189
            L_0x0188:
                r9 = r1
            L_0x0189:
                switch(r9) {
                    case 0: goto L_0x01a1;
                    case 1: goto L_0x019e;
                    case 2: goto L_0x019b;
                    case 3: goto L_0x0198;
                    case 4: goto L_0x0195;
                    case 5: goto L_0x0192;
                    case 6: goto L_0x018f;
                    default: goto L_0x018c;
                }
            L_0x018c:
                r13.f12686a = r8
                goto L_0x01a3
            L_0x018f:
                r13.f12686a = r3
                goto L_0x01a3
            L_0x0192:
                r13.f12686a = r0
                goto L_0x01a3
            L_0x0195:
                r13.f12686a = r6
                goto L_0x01a3
            L_0x0198:
                r13.f12686a = r2
                goto L_0x01a3
            L_0x019b:
                r13.f12686a = r8
                goto L_0x01a3
            L_0x019e:
                r13.f12686a = r14
                goto L_0x01a3
            L_0x01a1:
                r13.f12686a = r1
            L_0x01a3:
                java.lang.String r14 = "COMPLETE!"
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.ChatActivity.x.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: g */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            boolean unused = ChatActivity.this.f12571w0 = false;
            Context context = ((EditText) ChatActivity.this.findViewById(C2030R.id.editText1)).getContext();
            int i8 = this.f12686a;
            if (i8 == 0) {
                ChatActivity chatActivity = ChatActivity.this;
                new i(chatActivity, chatActivity.f12543U, this.f12693h, (C1066a) null).execute(new Context[]{ChatActivity.this.getApplicationContext()});
            } else if (i8 == 1) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ChatActivity.this);
                builder.setMessage(ChatActivity.this.getString(C2030R.string.chat_full));
                builder.setCancelable(false);
                builder.setNegativeButton(ChatActivity.this.getString(C2030R.string.official_close), new C1077j());
                builder.create().show();
            } else if (i8 == 2) {
                AlertDialog.Builder builder2 = new AlertDialog.Builder(ChatActivity.this);
                builder2.setMessage(ChatActivity.this.getString(C2030R.string.chat_not_active));
                builder2.setCancelable(false);
                builder2.setNegativeButton(ChatActivity.this.getString(C2030R.string.official_close), new C1078k());
                builder2.create().show();
            } else if (i8 == 3) {
                AlertDialog.Builder builder3 = new AlertDialog.Builder(ChatActivity.this);
                builder3.setMessage(ChatActivity.this.getString(C2030R.string.chat_upd));
                builder3.setCancelable(false);
                builder3.setNegativeButton(ChatActivity.this.getString(C2030R.string.official_close), new C1079l());
                builder3.create().show();
            } else if (i8 == 4) {
                AlertDialog.Builder builder4 = new AlertDialog.Builder(ChatActivity.this);
                builder4.setMessage(ChatActivity.this.getString(C2030R.string.chat_msg_limit));
                builder4.setCancelable(false);
                builder4.setNegativeButton(ChatActivity.this.getString(C2030R.string.official_close), new C1080m());
                builder4.create().show();
            } else if (i8 == 5) {
                AlertDialog.Builder builder5 = new AlertDialog.Builder(ChatActivity.this);
                builder5.setMessage(String.format(ChatActivity.this.getString(C2030R.string.chat_banned), new Object[]{Integer.valueOf(this.f12688c), Integer.valueOf(this.f12687b)}));
                builder5.setCancelable(false);
                builder5.setNegativeButton(ChatActivity.this.getString(C2030R.string.official_close), new C1081n());
                builder5.create().show();
            } else if (i8 == 10) {
                ChatActivity chatActivity2 = ChatActivity.this;
                new j(chatActivity2, chatActivity2.f12543U, this.f12693h, (C1066a) null).execute(new Context[]{ChatActivity.this.getApplicationContext()});
                Toast makeText = Toast.makeText(context, ChatActivity.this.getString(C2030R.string.manual_error), 1);
                makeText.setGravity(17, 0, 0);
                makeText.show();
            }
        }
    }

    private class y extends BaseAdapter {

        /* renamed from: a  reason: collision with root package name */
        private LayoutInflater f12701a;

        /* renamed from: b  reason: collision with root package name */
        private List f12702b;

        /* synthetic */ y(ChatActivity chatActivity, Activity activity, List list, C1066a aVar) {
            this(activity, list);
        }

        public static /* synthetic */ void c(y yVar, int i8, View view) {
            ChatActivity.this.f12560l0.f((NavigationView) ChatActivity.this.findViewById(C2030R.id.nav_view));
            EditText editText = (EditText) ChatActivity.this.findViewById(C2030R.id.editText1);
            editText.setText("@" + ((z) yVar.f12702b.get(i8)).u() + ": ");
            editText.post(new A(editText));
            editText.requestFocus();
            ((InputMethodManager) ChatActivity.this.getSystemService("input_method")).showSoftInput(editText, 1);
            view.postDelayed(new B(ChatActivity.this), 800);
        }

        /* access modifiers changed from: package-private */
        public void d(z zVar) {
            this.f12702b.add(zVar);
            notifyDataSetChanged();
        }

        public int getCount() {
            return this.f12702b.size();
        }

        public Object getItem(int i8) {
            return this.f12702b.get(i8);
        }

        public long getItemId(int i8) {
            return (long) i8;
        }

        public View getView(int i8, View view, ViewGroup viewGroup) {
            LayoutInflater layoutInflater = ChatActivity.this.getLayoutInflater();
            this.f12701a = layoutInflater;
            View inflate = layoutInflater.inflate(C2030R.layout.online_entry, viewGroup, false);
            TextView textView = (TextView) inflate.findViewById(C2030R.id.textView2);
            String a8 = ((z) this.f12702b.get(i8)).u();
            if (((z) this.f12702b.get(i8)).t() > 0) {
                textView.setText(ChatActivity.f12536A0.newSpannable(ChatActivity.this.A1(11088) + " " + a8));
            } else {
                textView.setText(a8);
            }
            Button button = (Button) inflate.findViewById(C2030R.id.button1);
            TextView textView2 = (TextView) inflate.findViewById(C2030R.id.textView1);
            if (((z) this.f12702b.get(i8)).w() == 0) {
                button.setVisibility(0);
                textView2.setVisibility(8);
            } else {
                button.setVisibility(8);
                textView2.setVisibility(0);
            }
            button.setOnClickListener(new C1092z(this, i8));
            ImageView imageView = (ImageView) inflate.findViewById(C2030R.id.imageView3);
            if (((z) this.f12702b.get(i8)).v() == 1) {
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
            ImageView imageView2 = (ImageView) inflate.findViewById(C2030R.id.imageView0);
            if (((z) this.f12702b.get(i8)).r() > 0) {
                String num = Integer.toString(((z) this.f12702b.get(i8)).r());
                if (num.length() == 1) {
                    num = "00" + num;
                } else if (num.length() == 2) {
                    num = "0" + num;
                }
                imageView2.setImageResource(ChatActivity.this.getResources().getIdentifier("drawable/" + ("flag" + num), (String) null, ChatActivity.this.getPackageName()));
                imageView2.setVisibility(0);
            } else {
                imageView2.setVisibility(8);
            }
            ImageView imageView3 = (ImageView) inflate.findViewById(C2030R.id.imageView1);
            TextView textView3 = (TextView) inflate.findViewById(C2030R.id.textView1);
            if (((z) this.f12702b.get(i8)).w() == 0) {
                imageView3.setImageDrawable(a.getDrawable(ChatActivity.this.getApplicationContext(), 2131230904));
                return inflate;
            }
            imageView3.setImageDrawable(a.getDrawable(ChatActivity.this.getApplicationContext(), 2131230903));
            textView3.setText(((z) this.f12702b.get(i8)).s() + ChatActivity.this.getString(C2030R.string.short_minute));
            return inflate;
        }

        private y(Activity activity, List list) {
            this.f12701a = LayoutInflater.from(activity);
            this.f12702b = list;
        }
    }

    private class z {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f12704a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public int f12705b;

        /* renamed from: c  reason: collision with root package name */
        private int f12706c;

        /* renamed from: d  reason: collision with root package name */
        private int f12707d;

        /* renamed from: e  reason: collision with root package name */
        private int f12708e;

        /* renamed from: f  reason: collision with root package name */
        private int f12709f;

        /* renamed from: g  reason: collision with root package name */
        private int f12710g;

        private z() {
        }

        /* access modifiers changed from: private */
        public void A(int i8) {
            this.f12706c = i8;
        }

        /* access modifiers changed from: private */
        public void B(String str) {
            this.f12704a = str;
        }

        /* access modifiers changed from: private */
        public void C(int i8) {
            this.f12710g = i8;
        }

        /* access modifiers changed from: private */
        public void D(int i8) {
            this.f12707d = i8;
        }

        /* access modifiers changed from: private */
        public int q() {
            return this.f12705b;
        }

        /* access modifiers changed from: private */
        public int r() {
            return this.f12709f;
        }

        /* access modifiers changed from: private */
        public int s() {
            return this.f12708e;
        }

        /* access modifiers changed from: private */
        public int t() {
            return this.f12706c;
        }

        /* access modifiers changed from: private */
        public String u() {
            return this.f12704a;
        }

        /* access modifiers changed from: private */
        public int v() {
            return this.f12710g;
        }

        /* access modifiers changed from: private */
        public int w() {
            return this.f12707d;
        }

        /* access modifiers changed from: private */
        public void x(int i8) {
            this.f12705b = i8;
        }

        /* access modifiers changed from: private */
        public void y(int i8) {
            this.f12709f = i8;
        }

        /* access modifiers changed from: private */
        public void z(int i8) {
            this.f12708e = i8;
        }

        /* synthetic */ z(ChatActivity chatActivity, C1066a aVar) {
            this();
        }
    }

    /* access modifiers changed from: private */
    public String A1(int i8) {
        return new String(Character.toChars(i8));
    }

    /* access modifiers changed from: private */
    public String B1(String str) {
        boolean z7;
        if (str == null) {
            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
        }
        boolean I12 = I1(str);
        int z12 = z1(str);
        Date date = new Date();
        try {
            date = this.f12565q0.parse(str);
            z7 = true;
        } catch (ParseException unused) {
            z7 = false;
        }
        this.f12568t0.setTime(date);
        int y12 = y1(this.f12568t0.get(10), this.f12568t0.get(12));
        if (!z7) {
            return A1(y12) + " " + str;
        } else if (z12 < 60) {
            return A1(y12) + " " + z12 + "m";
        } else if (!I12) {
            return A1(y12) + " " + this.f12567s0.format(date);
        } else {
            return A1(y12) + " " + this.f12566r0.format(date);
        }
    }

    private String C1() {
        if (FirebaseAuth.getInstance().f() != null) {
            SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.class.getSimpleName(), 0);
            if (sharedPreferences.getBoolean("nicklinked", false)) {
                return sharedPreferences.getString("nick", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
            }
        }
        return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    }

    private String D1(String str) {
        int indexOf;
        String trim = str.trim();
        if (!trim.substring(0, 1).equals("@") || (indexOf = trim.indexOf(":")) <= 1) {
            return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
        }
        return trim.substring(1, indexOf - 1);
    }

    private String E1() {
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.class.getSimpleName(), 0);
        String string = sharedPreferences.getString("order_id_pro", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        if (string.equals(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED)) {
            return sharedPreferences.getString("order_id_sub", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
        }
        return string;
    }

    /* access modifiers changed from: private */
    public String F1() {
        C1155z f8 = FirebaseAuth.getInstance().f();
        if (f8 != null) {
            return f8.f1();
        }
        return RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
    }

    /* access modifiers changed from: private */
    public boolean G1() {
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

    private boolean H1() {
        if (FirebaseAuth.getInstance().f() != null) {
            SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.class.getSimpleName(), 0);
            if (!sharedPreferences.getBoolean("nicklinked", false) || sharedPreferences.getString("nick", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED).equalsIgnoreCase(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED)) {
                return false;
            }
            return true;
        }
        return false;
    }

    private boolean I1(String str) {
        try {
            return !DateUtils.isToday(this.f12565q0.parse(str).getTime());
        } catch (ParseException unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void J1(String str, String str2, int i8, String str3) {
        if (System.currentTimeMillis() - getSharedPreferences(MainActivity.class.getSimpleName(), 0).getLong("last_chat_user_report", 0) > 60000) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage(getString(C2030R.string.profile_report_sure));
            builder.setCancelable(true);
            builder.setNegativeButton(getString(C2030R.string.manual_yes), new C1859s(this, str, str2, i8, str3));
            builder.setPositiveButton(getString(C2030R.string.manual_no), new C1865t());
            builder.create().show();
            return;
        }
    }

    /* access modifiers changed from: private */
    public void K1() {
        this.f12557i0.post(new C1847q(this));
    }

    /* access modifiers changed from: private */
    public void L1(int i8) {
        int i9 = ((e) this.f12553e0.get(i8 - 1)).z();
        this.f12558j0 = i9;
        if (i9 != 0) {
            r rVar = new r(this, (C1066a) null);
            this.f12538P = rVar;
            rVar.execute(new Context[]{this});
        }
    }

    /* access modifiers changed from: private */
    public void M1(int i8) {
        int h8 = ((z) this.f12555g0.get(i8)).f12705b;
        this.f12558j0 = h8;
        if (h8 != 0) {
            r rVar = new r(this, (C1066a) null);
            this.f12538P = rVar;
            rVar.execute(new Context[]{this});
        }
    }

    /* access modifiers changed from: private */
    public void N1(int i8, int i9, int i10) {
        for (int i11 = 0; i11 < this.f12554f0.getCount(); i11++) {
            e eVar = (e) this.f12554f0.getItem(i11);
            if (eVar.E() == i8) {
                if (i9 == 0) {
                    eVar.V(i10);
                }
                if (i9 == 1) {
                    eVar.T(i10);
                }
                if (i9 == 2) {
                    eVar.N(i10);
                }
                if (i9 == 3) {
                    eVar.P(i10);
                }
                if (i9 == 4) {
                    eVar.L(i10);
                }
            }
        }
        this.f12554f0.notifyDataSetInvalidated();
    }

    /* access modifiers changed from: private */
    public void O1(int i8, int i9, int i10, int i11) {
        for (int i12 = 0; i12 < this.f12554f0.getCount(); i12++) {
            e eVar = (e) this.f12554f0.getItem(i12);
            if (eVar.E() == i8) {
                eVar.T(i9);
                eVar.P(i10);
                eVar.L(i11);
            }
        }
        this.f12554f0.notifyDataSetInvalidated();
    }

    /* access modifiers changed from: private */
    public void P1() {
        new t(this, (C1066a) null).execute(new Context[]{this});
    }

    /* access modifiers changed from: private */
    public void Q1(String str, int i8, String str2) {
        new m(this, str, i8, str2, (C1066a) null).execute(new Context[]{this});
    }

    public static /* synthetic */ void e0(SearchView searchView, MenuItem menuItem, View view) {
        searchView.d0(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED, false);
        searchView.f();
        menuItem.collapseActionView();
    }

    public static /* synthetic */ void f0(ChatActivity chatActivity, View view) {
        chatActivity.getClass();
        view.postDelayed(new C1853r(chatActivity), 800);
    }

    public static /* synthetic */ void g0(ChatActivity chatActivity, String str, String str2, int i8, String str3, DialogInterface dialogInterface, int i9) {
        chatActivity.getClass();
        String str4 = str3;
        int i10 = i8;
        String str5 = str2;
        String str6 = str;
        ChatActivity chatActivity2 = chatActivity;
        new u(chatActivity2, str6, str5, i10, str4, (C1066a) null).execute(new Context[]{chatActivity2});
    }

    public static /* synthetic */ void h0(ChatActivity chatActivity, View view, String str, int i8, String str2, String str3, String str4, DialogInterface dialogInterface, int i9) {
        chatActivity.getClass();
        String obj = ((EditText) view.findViewById(C2030R.id.editText1)).getText().toString();
        InputMethodManager inputMethodManager = (InputMethodManager) chatActivity.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
        }
        new v(chatActivity, str, obj, i8, str2, str3, str4, (C1066a) null).execute(new Context[]{chatActivity});
    }

    public static /* synthetic */ void i0(DialogInterface dialogInterface, int i8) {
    }

    public static /* synthetic */ void j0(ChatActivity chatActivity, View view) {
        boolean z7;
        long j8;
        ChatActivity chatActivity2 = chatActivity;
        InputMethodManager inputMethodManager = (InputMethodManager) chatActivity2.getSystemService("input_method");
        if (inputMethodManager != null) {
            inputMethodManager.hideSoftInputFromWindow(view.getWindowToken(), 2);
        }
        Context context = view.getContext();
        String obj = ((EditText) chatActivity2.findViewById(C2030R.id.editText1)).getText().toString();
        String w12 = chatActivity2.w1();
        chatActivity2.f12545W = w12;
        if (!chatActivity2.f12562n0) {
            Toast makeText = Toast.makeText(chatActivity2, chatActivity2.getString(C2030R.string.chat_register2), 1);
            makeText.setGravity(17, 0, 0);
            makeText.show();
        } else if (w12.equals("0")) {
            Toast makeText2 = Toast.makeText(context, chatActivity2.getString(C2030R.string.chat_user0), 0);
            makeText2.setGravity(17, 0, 0);
            makeText2.show();
        } else if (obj.isEmpty()) {
            Toast makeText3 = Toast.makeText(context, chatActivity2.getString(C2030R.string.chat_empty), 0);
            makeText3.setGravity(17, 0, 0);
            makeText3.show();
        } else if (!chatActivity2.G1()) {
            Toast makeText4 = Toast.makeText(context, chatActivity2.getString(C2030R.string.main_nointernet), 0);
            makeText4.setGravity(17, 0, 0);
            makeText4.show();
        } else if (chatActivity2.r1(obj) == 0) {
            String D12 = chatActivity2.D1(obj);
            Class<MainActivity> cls = MainActivity.class;
            if (!D12.equals(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED)) {
                SharedPreferences sharedPreferences = chatActivity2.getSharedPreferences(cls.getSimpleName(), 0);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                String string = sharedPreferences.getString("chat_last_receiver", RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED);
                long j9 = sharedPreferences.getLong("chat_last_receiver_time", 0);
                long j10 = sharedPreferences.getLong("chat_last_receiver_count", 0);
                long currentTimeMillis = System.currentTimeMillis();
                long j11 = 1;
                if (D12.equals(string) && currentTimeMillis - j9 < 60000) {
                    j11 = j10 + 1;
                    if (j11 > 3) {
                        j8 = j11;
                        z7 = false;
                        edit.putString("chat_last_receiver", D12);
                        edit.putLong("chat_last_receiver_time", currentTimeMillis);
                        edit.putLong("chat_last_receiver_count", j8);
                        edit.apply();
                    }
                }
                j8 = j11;
                z7 = true;
                edit.putString("chat_last_receiver", D12);
                edit.putLong("chat_last_receiver_time", currentTimeMillis);
                edit.putLong("chat_last_receiver_count", j8);
                edit.apply();
            } else {
                z7 = true;
            }
            if (!z7) {
                Toast makeText5 = Toast.makeText(context, chatActivity2.getString(C2030R.string.chat_msg_sameuser), 1);
                makeText5.setGravity(17, 0, 0);
                makeText5.show();
            } else if (!chatActivity2.f12571w0) {
                chatActivity2.f12571w0 = true;
                SharedPreferences sharedPreferences2 = chatActivity2.getSharedPreferences(cls.getSimpleName(), 0);
                chatActivity2.f12546X = sharedPreferences2.getInt("chat_user_code", 0);
                chatActivity2.f12547Y = sharedPreferences2.getInt("country", 0);
                chatActivity2.f12548Z = sharedPreferences2.getInt("chat_mod", 0);
                w wVar = new w(chatActivity2, chatActivity2.f12543U, chatActivity2.f12546X, chatActivity2.f12544V, new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(new Date()), obj, chatActivity2.f12547Y, chatActivity2.f12572x0, new Random().nextInt(900000) + 100000, chatActivity2.f12548Z, (C1066a) null);
                chatActivity2.f12539Q = wVar;
                wVar.execute(new Context[]{context});
            }
        }
    }

    public static /* synthetic */ void k0(ChatActivity chatActivity) {
        ListView listView = chatActivity.f12557i0;
        listView.setSelection(listView.getCount() - 1);
    }

    public static /* synthetic */ void l0(DialogInterface dialogInterface, int i8) {
    }

    public static /* synthetic */ boolean n0(ChatActivity chatActivity, TextView textView, int i8, KeyEvent keyEvent) {
        chatActivity.getClass();
        if (keyEvent == null || keyEvent.getKeyCode() != 66) {
            return false;
        }
        InputMethodManager inputMethodManager = (InputMethodManager) chatActivity.getSystemService("input_method");
        if (inputMethodManager == null) {
            return true;
        }
        inputMethodManager.hideSoftInputFromWindow(textView.getWindowToken(), 2);
        return true;
    }

    /* access modifiers changed from: private */
    public void q1(String str, int i8, String str2, String str3, String str4) {
        View inflate = LayoutInflater.from(this).inflate(C2030R.layout.pwd_dialog, (ViewGroup) null);
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        View view = inflate;
        builder.setNegativeButton(getString(C2030R.string.profile_ban), new C1871u(this, view, str, i8, str2, str3, str4));
        builder.setPositiveButton(getString(C2030R.string.map_clear), new C1817l());
        AlertDialog create = builder.create();
        create.setView(view, 0, 0, 0, 0);
        create.setInverseBackgroundForced(true);
        create.show();
    }

    private int r1(String str) {
        String str2;
        char c8;
        char c9;
        int i8;
        int i9 = 3;
        String trim = str.trim();
        if (trim.substring(0, 1).equals("@")) {
            int indexOf = trim.indexOf(":");
            if (indexOf != -1) {
                trim = trim.substring(indexOf + 1);
            }
            trim = trim.trim();
        }
        if (this.f12552d0.equalsIgnoreCase("_ar_gen") || trim.length() >= 13) {
            int i10 = 0;
            for (int i11 = 0; i11 < trim.length(); i11++) {
                if (trim.charAt(i11) == ':') {
                    i10++;
                }
            }
            if (i10 > 2) {
                Toast makeText = Toast.makeText(this, getString(C2030R.string.chat_msg_emo), 1);
                makeText.setGravity(17, 0, 0);
                makeText.show();
                return 2;
            }
            Matcher matcher = Pattern.compile("[🌀-🗿]|[😀-🙏]|[🚀-🛿]|[☀-⛿]|[✀-➿]").matcher(trim);
            StringBuffer stringBuffer = new StringBuffer();
            while (true) {
                boolean find = matcher.find();
                str2 = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                if (!find) {
                    break;
                }
                matcher.appendReplacement(stringBuffer, str2);
            }
            matcher.appendTail(stringBuffer);
            if (trim.length() - stringBuffer.toString().length() > 6) {
                Toast makeText2 = Toast.makeText(this, getString(C2030R.string.chat_msg_emo), 1);
                makeText2.setGravity(17, 0, 0);
                makeText2.show();
                return 6;
            }
            if (!this.f12552d0.equalsIgnoreCase("_jp_gen") && !this.f12552d0.equalsIgnoreCase("_ar_gen")) {
                String upperCase = trim.toUpperCase();
                int i12 = 0;
                int i13 = 0;
                while (i12 < trim.length()) {
                    int i14 = i12 + 1;
                    if (trim.substring(i12, i14).equals(upperCase.substring(i12, i14))) {
                        i13++;
                    }
                    i12 = i14;
                }
                if (((double) i13) / ((double) trim.length()) > 0.6d) {
                    Toast makeText3 = Toast.makeText(this, getString(C2030R.string.chat_msg_capital), 1);
                    makeText3.setGravity(17, 0, 0);
                    makeText3.show();
                    return 3;
                }
            }
            String[] split = trim.split(" ");
            if (split.length > 1) {
                int i15 = 0;
                int i16 = 0;
                int i17 = 0;
                while (i15 < split.length - 1) {
                    String str3 = split[i15];
                    i15++;
                    if (str3.equals(split[i15])) {
                        i17++;
                    } else {
                        i17 = 0;
                    }
                    if (i17 > i16) {
                        i16 = 1;
                    }
                }
                c8 = 7;
                if (i16 > 0) {
                    Toast makeText4 = Toast.makeText(this, getString(C2030R.string.chat_msg_rpt_word), 1);
                    makeText4.setGravity(17, 0, 0);
                    makeText4.show();
                    return 7;
                }
            } else {
                c8 = 7;
            }
            if (this.f12552d0.equalsIgnoreCase("_tag_gen") || !Pattern.compile("(\\w)\\1{6,}").matcher(trim).find()) {
                String replace = trim.replace(" ", str2);
                if (replace.length() >= 6) {
                    int i18 = 0;
                    int i19 = 0;
                    int i20 = 0;
                    while (true) {
                        c9 = 8;
                        if (i18 > replace.length() - 4) {
                            break;
                        }
                        int i21 = i9;
                        int i22 = i18 + 2;
                        if (replace.substring(i18, i18 + 1).equals(replace.substring(i22, i18 + 3))) {
                            i20++;
                        } else {
                            i20 = 0;
                        }
                        if (i20 > i19) {
                            i19 = i20;
                        }
                        i18 = i22;
                        i9 = i21;
                    }
                    i8 = i9;
                    if (i19 > 4) {
                        Toast makeText5 = Toast.makeText(this, getString(C2030R.string.chat_msg_rpt), 1);
                        makeText5.setGravity(17, 0, 0);
                        makeText5.show();
                        return 8;
                    }
                } else {
                    i8 = 3;
                    c9 = 8;
                }
                String[] strArr = new String[0];
                if (this.f12552d0.equalsIgnoreCase("_es_gen")) {
                    strArr = new String[13];
                    strArr[0] = "ql";
                    strArr[1] = "wn";
                    strArr[2] = "wnes";
                    strArr[i8] = "giles";
                    strArr[4] = "pico";
                    strArr[5] = "chupalo";
                    strArr[6] = "qla";
                    strArr[c8] = "qls";
                    strArr[c9] = "ctm";
                    strArr[9] = "csm";
                    strArr[10] = "wea";
                    strArr[11] = "Aroldo";
                    strArr[12] = "Maciel";
                }
                if (this.f12552d0.equalsIgnoreCase("_ita_gen")) {
                    strArr = new String[6];
                    strArr[0] = "cazzo";
                    strArr[1] = "figa";
                    strArr[2] = "troia";
                    strArr[i8] = "puttana";
                    strArr[4] = "vaffanculo";
                    strArr[5] = "frocio";
                }
                if (this.f12552d0.equalsIgnoreCase("_eng_gen")) {
                    strArr = new String[i8];
                    strArr[0] = "fuck";
                    strArr[1] = "slut";
                    strArr[2] = "bitch";
                }
                if (strArr.length > 0) {
                    String[] split2 = trim.split("[ .,]");
                    boolean z7 = false;
                    for (String str4 : strArr) {
                        int length = split2.length;
                        int i23 = 0;
                        while (true) {
                            if (i23 >= length) {
                                break;
                            } else if (split2[i23].equalsIgnoreCase(str4)) {
                                z7 = true;
                                str2 = str4;
                                break;
                            } else {
                                i23++;
                            }
                        }
                        if (z7) {
                            break;
                        }
                    }
                    if (z7) {
                        Toast makeText6 = Toast.makeText(this, String.format(getString(C2030R.string.chat_msg_forbidden), new Object[]{str2}), 1);
                        makeText6.setGravity(17, 0, 0);
                        makeText6.show();
                        return 9;
                    }
                }
                return 0;
            }
            Toast makeText7 = Toast.makeText(this, getString(C2030R.string.chat_msg_rpt), 1);
            makeText7.setGravity(17, 0, 0);
            makeText7.show();
            return 4;
        }
        Toast makeText8 = Toast.makeText(this, getString(C2030R.string.chat_msg_tooshort), 1);
        makeText8.setGravity(17, 0, 0);
        makeText8.show();
        return 1;
    }

    /* access modifiers changed from: private */
    public void s1() {
        if (G1()) {
            ((ProgressBar) findViewById(C2030R.id.progressBar6)).setVisibility(0);
            ((EditText) findViewById(C2030R.id.editText1)).setEnabled(false);
            new o(this.f12549a0).execute(new Context[]{this});
            return;
        }
        Toast makeText = Toast.makeText(this, getString(C2030R.string.main_nointernet), 0);
        makeText.setGravity(17, 0, 0);
        makeText.show();
    }

    /* access modifiers changed from: private */
    public void t1() {
        if (G1()) {
            ((ProgressBar) findViewById(C2030R.id.progressBar6)).setVisibility(0);
            ((EditText) findViewById(C2030R.id.editText1)).setEnabled(false);
            new p(this.f12549a0).execute(new Context[]{this});
            return;
        }
        Toast makeText = Toast.makeText(this, getString(C2030R.string.main_nointernet), 0);
        makeText.setGravity(17, 0, 0);
        makeText.show();
    }

    /* access modifiers changed from: private */
    public void u1() {
        new s(this, (C1066a) null).execute(new Context[]{this});
    }

    private void v1() {
        this.f12553e0 = new ArrayList();
        this.f12554f0 = new c(this, this, this.f12553e0, (C1066a) null);
    }

    /* access modifiers changed from: private */
    public String w1() {
        return getSharedPreferences(MainActivity.class.getSimpleName(), 0).getString("android_id_eqn", "0");
    }

    private void x1() {
        new n(this, (C1066a) null).execute(new Context[]{this});
    }

    private int y1(int i8, int i9) {
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

    private int z1(String str) {
        boolean z7;
        if (str != null) {
            Date date = new Date();
            try {
                date = this.f12565q0.parse(str);
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

    public void onActivityResult(int i8, int i9, Intent intent) {
        super.onActivityResult(i8, i9, intent);
        if (i8 == 1 && !getSharedPreferences(MainActivity.class.getSimpleName(), 0).getBoolean("chat_rules_accepted", false)) {
            finish();
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0766b bVar = this.f12561m0;
        if (bVar != null) {
            bVar.g(configuration);
        }
    }

    public void onCreate(Bundle bundle) {
        ChatActivity chatActivity;
        C0765a R7;
        super.onCreate(bundle);
        setContentView((int) C2030R.layout.chat);
        Toolbar toolbar = (Toolbar) findViewById(C2030R.id.toolbar);
        b0(toolbar);
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.class.getSimpleName(), 0);
        boolean z7 = sharedPreferences.getBoolean("pro_features", false);
        boolean z8 = sharedPreferences.getBoolean("chat_rules_accepted", false);
        this.f12546X = sharedPreferences.getInt("chat_user_code", 0);
        this.f12565q0 = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault());
        this.f12566r0 = new SimpleDateFormat("dd-MMM HH:mm", Locale.getDefault());
        this.f12567s0 = new SimpleDateFormat("HH:mm", Locale.getDefault());
        this.f12568t0 = Calendar.getInstance();
        this.f12542T = new C(getApplicationContext());
        if (z7) {
            this.f12572x0 = 1;
        } else {
            this.f12572x0 = 0;
        }
        this.f12562n0 = H1();
        this.f12544V = C1();
        this.f12550b0 = F1();
        this.f12551c0 = E1();
        if (!this.f12562n0 && z8) {
            Toast makeText = Toast.makeText(this, getString(C2030R.string.chat_register), 1);
            makeText.setGravity(17, 0, 0);
            makeText.show();
        }
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(C2030R.id.drawerLayout);
        this.f12560l0 = drawerLayout;
        if (this.f12562n0) {
            chatActivity = this;
            C1067b bVar = new C1067b(this, drawerLayout, toolbar, C2030R.string.drawer_open, C2030R.string.drawer_close);
            chatActivity.f12561m0 = bVar;
            chatActivity.f12560l0.a(bVar);
            chatActivity.f12561m0.e().c(getResources().getColor(C2030R.color.md_theme_primary));
        } else {
            chatActivity = this;
        }
        chatActivity.f12559k0 = (ListView) findViewById(C2030R.id.list_online);
        chatActivity.f12555g0 = new ArrayList();
        y yVar = new y(this, this, chatActivity.f12555g0, (C1066a) null);
        chatActivity.f12556h0 = yVar;
        chatActivity.f12559k0.setAdapter(yVar);
        chatActivity.f12559k0.setOnItemClickListener(new f(this, (C1066a) null));
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            String string = extras.getString("com.finazzi.distquake.chat_room");
            chatActivity.f12552d0 = string;
            if (!(string == null || (R7 = R()) == null)) {
                if (chatActivity.f12552d0.equalsIgnoreCase("_ita_gen")) {
                    chatActivity.f12543U = "chat_public_ita";
                    R7.u(String.format(getString(C2030R.string.chat_menu_ita_gen), new Object[]{"  ", "  "}));
                    toolbar.setLogo(2131231064);
                    toolbar.setTitleMarginStart(5);
                    chatActivity.f12573y0 = sharedPreferences.getInt("online_chat_ita", 0);
                }
                if (chatActivity.f12552d0.equalsIgnoreCase("_es_gen")) {
                    chatActivity.f12543U = "chat_public_es";
                    R7.u(String.format(getString(C2030R.string.chat_menu_es_gen), new Object[]{"  ", "  "}));
                    toolbar.setLogo(2131231154);
                    toolbar.setTitleMarginStart(5);
                    chatActivity.f12573y0 = sharedPreferences.getInt("online_chat_es", 0);
                }
                if (chatActivity.f12552d0.equalsIgnoreCase("_eng_gen")) {
                    chatActivity.f12543U = "chat_public_eng";
                    R7.u(String.format(getString(C2030R.string.chat_menu_eng_gen), new Object[]{"  ", "  "}));
                    toolbar.setLogo(2131231181);
                    toolbar.setTitleMarginStart(5);
                    chatActivity.f12573y0 = sharedPreferences.getInt("online_chat_eng", 0);
                }
                if (chatActivity.f12552d0.equalsIgnoreCase("_fr_gen")) {
                    chatActivity.f12543U = "chat_public_fr";
                    R7.u(String.format(getString(C2030R.string.chat_menu_fr_gen), new Object[]{"  ", "  "}));
                    toolbar.setLogo(2131231037);
                    toolbar.setTitleMarginStart(5);
                    chatActivity.f12573y0 = sharedPreferences.getInt("online_chat_fr", 0);
                }
                if (chatActivity.f12552d0.equalsIgnoreCase("_el_gen")) {
                    chatActivity.f12543U = "chat_public_el";
                    R7.u(String.format(getString(C2030R.string.chat_menu_el_gen), new Object[]{"  ", "  "}));
                    toolbar.setLogo(2131231045);
                    toolbar.setTitleMarginStart(5);
                    chatActivity.f12573y0 = sharedPreferences.getInt("online_chat_el", 0);
                }
                if (chatActivity.f12552d0.equalsIgnoreCase("_tr_gen")) {
                    chatActivity.f12543U = "chat_public_tr";
                    R7.u(String.format(getString(C2030R.string.chat_menu_tr_gen), new Object[]{"  ", "  "}));
                    toolbar.setLogo(2131231172);
                    toolbar.setTitleMarginStart(5);
                    chatActivity.f12573y0 = sharedPreferences.getInt("online_chat_tr", 0);
                }
                if (chatActivity.f12552d0.equalsIgnoreCase("_in_gen")) {
                    chatActivity.f12543U = "chat_public_in";
                    R7.u(String.format(getString(C2030R.string.chat_menu_in_gen), new Object[]{"  ", "  "}));
                    toolbar.setLogo(2131231059);
                    toolbar.setTitleMarginStart(5);
                    chatActivity.f12573y0 = sharedPreferences.getInt("online_chat_in", 0);
                }
                if (chatActivity.f12552d0.equalsIgnoreCase("_tag_gen")) {
                    chatActivity.f12543U = "chat_public_tag";
                    R7.u(String.format(getString(C2030R.string.chat_menu_tag_gen), new Object[]{"  ", "  "}));
                    toolbar.setLogo(2131231123);
                    toolbar.setTitleMarginStart(5);
                    chatActivity.f12573y0 = sharedPreferences.getInt("online_chat_tag", 0);
                }
                if (chatActivity.f12552d0.equalsIgnoreCase("_jp_gen")) {
                    chatActivity.f12543U = "chat_public_jp";
                    R7.u(String.format(getString(C2030R.string.chat_menu_jp_gen), new Object[]{"  ", "  "}));
                    toolbar.setLogo(2131231066);
                    toolbar.setTitleMarginStart(5);
                    chatActivity.f12573y0 = sharedPreferences.getInt("online_chat_jp", 0);
                }
                if (chatActivity.f12552d0.equalsIgnoreCase("_pt_gen")) {
                    chatActivity.f12543U = "chat_public_pt";
                    R7.u(String.format(getString(C2030R.string.chat_menu_pt_gen), new Object[]{"  ", "  "}));
                    toolbar.setLogo(2131231126);
                    toolbar.setTitleMarginStart(5);
                    chatActivity.f12573y0 = sharedPreferences.getInt("online_chat_pt", 0);
                }
                if (chatActivity.f12552d0.equalsIgnoreCase("_blk_gen")) {
                    chatActivity.f12543U = "chat_public_blk";
                    R7.u(String.format(getString(C2030R.string.chat_menu_blk_gen), new Object[]{"  ", "  "}));
                    toolbar.setTitleMarginStart(5);
                    chatActivity.f12573y0 = sharedPreferences.getInt("online_chat_blk", 0);
                }
                if (chatActivity.f12552d0.equalsIgnoreCase("_hu_gen")) {
                    chatActivity.f12543U = "chat_public_hu";
                    R7.u(String.format(getString(C2030R.string.chat_menu_hu_gen), new Object[]{"  ", "  "}));
                    toolbar.setLogo(2131231056);
                    toolbar.setTitleMarginStart(5);
                    chatActivity.f12573y0 = sharedPreferences.getInt("online_chat_hu", 0);
                }
                if (chatActivity.f12552d0.equalsIgnoreCase("_ro_gen")) {
                    chatActivity.f12543U = "chat_public_ro";
                    R7.u(String.format(getString(C2030R.string.chat_menu_ro_gen), new Object[]{"  ", "  "}));
                    toolbar.setLogo(2131231130);
                    toolbar.setTitleMarginStart(5);
                    chatActivity.f12573y0 = sharedPreferences.getInt("online_chat_ro", 0);
                }
                if (chatActivity.f12552d0.equalsIgnoreCase("_ar_gen")) {
                    chatActivity.f12543U = "chat_public_ar";
                    R7.u(String.format(getString(C2030R.string.chat_menu_ar_gen), new Object[]{"  ", "  "}));
                    toolbar.setLogo(2131231140);
                    toolbar.setTitleMarginStart(5);
                    chatActivity.f12573y0 = sharedPreferences.getInt("online_chat_ar", 0);
                }
                if (chatActivity.f12552d0.equalsIgnoreCase("_th_gen")) {
                    chatActivity.f12543U = "chat_public_th";
                    R7.u(String.format(getString(C2030R.string.chat_menu_th_gen), new Object[]{"  ", "  "}));
                    toolbar.setLogo(2131231165);
                    toolbar.setTitleMarginStart(5);
                    chatActivity.f12573y0 = sharedPreferences.getInt("online_chat_th", 0);
                }
                if (chatActivity.f12552d0.equalsIgnoreCase("_my_gen")) {
                    chatActivity.f12543U = "chat_public_my";
                    R7.u(String.format(getString(C2030R.string.chat_menu_my_gen), new Object[]{"  ", "  "}));
                    toolbar.setLogo(2131231102);
                    toolbar.setTitleMarginStart(5);
                    chatActivity.f12573y0 = sharedPreferences.getInt("online_chat_my", 0);
                }
                if (chatActivity.f12552d0.equalsIgnoreCase("_mod_gen")) {
                    chatActivity.f12543U = "chat_public_mod";
                    R7.u(getString(C2030R.string.chat_menu_mod_gen));
                    toolbar.setTitleMarginStart(5);
                    chatActivity.f12573y0 = 0;
                }
            }
        }
        getWindow().setSoftInputMode(2);
        v1();
        ListView listView = (ListView) findViewById(C2030R.id.listview);
        listView.setAdapter(chatActivity.f12554f0);
        listView.setOnItemClickListener(new d(this, (C1066a) null));
        ((Button) findViewById(C2030R.id.button1)).setOnClickListener(new C1829n(this));
        EditText editText = (EditText) findViewById(C2030R.id.editText1);
        editText.setOnClickListener(new C1835o(this));
        editText.setOnEditorActionListener(new C1841p(this));
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        SearchView searchView;
        getMenuInflater().inflate(C2030R.menu.chat_menu, menu);
        menu.getItem(0).setVisible(false);
        if (!H1()) {
            menu.getItem(1).setVisible(false);
        }
        MenuItem findItem = menu.findItem(C2030R.id.action_search);
        if (!(findItem == null || (searchView = (SearchView) findItem.getActionView()) == null)) {
            searchView.setQueryHint(getString(C2030R.string.menu_search));
            ((ImageView) searchView.findViewById(C2030R.id.search_close_btn)).setOnClickListener(new C1823m(searchView, findItem));
            searchView.setOnQueryTextListener(new C1066a(searchView));
        }
        return super.onCreateOptionsMenu(menu);
    }

    public boolean onKeyDown(int i8, KeyEvent keyEvent) {
        if (i8 == 4) {
            NavigationView navigationView = (NavigationView) findViewById(C2030R.id.nav_view);
            if (this.f12560l0.D(navigationView)) {
                this.f12560l0.f(navigationView);
                return true;
            }
        }
        return super.onKeyDown(i8, keyEvent);
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        C0766b bVar = this.f12561m0;
        if (bVar != null && bVar.h(menuItem)) {
            return true;
        }
        int itemId = menuItem.getItemId();
        if (itemId == C2030R.id.menu_personal) {
            startActivity(new Intent(this, ChatPreviewActivity.class));
            return true;
        } else if (itemId != C2030R.id.menu_chatrules) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            Intent intent = new Intent(this, WebViewActivity.class);
            intent.putExtra("com.finazzi.distquake.map_type", 6);
            intent.putExtra("com.finazzi.distquake.url", getString(C2030R.string.website) + "chatroom-rules/");
            startActivity(intent);
            return true;
        }
    }

    public void onPause() {
        unregisterReceiver(this.f12563o0);
        unregisterReceiver(this.f12564p0);
        super.onPause();
    }

    /* access modifiers changed from: protected */
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        C0766b bVar = this.f12561m0;
        if (bVar != null) {
            bVar.l();
        }
    }

    public void onResume() {
        super.onResume();
        x1();
        boolean z7 = getSharedPreferences(MainActivity.class.getSimpleName(), 0).getBoolean("chat_rules_accepted", false);
        boolean H12 = H1();
        this.f12562n0 = H12;
        if (!z7 && H12) {
            Intent intent = new Intent(this, WebViewActivity.class);
            intent.putExtra("com.finazzi.distquake.map_type", 6);
            intent.putExtra("com.finazzi.distquake.url", getString(C2030R.string.website) + "chatroom-rules/");
            startActivityForResult(intent, 1);
        }
        invalidateOptionsMenu();
        this.f12557i0 = (ListView) findViewById(C2030R.id.listview);
        this.f12553e0.clear();
        this.f12554f0.notifyDataSetInvalidated();
        ((ProgressBar) findViewById(C2030R.id.progressBar6)).setVisibility(0);
        ((EditText) findViewById(C2030R.id.editText1)).setEnabled(false);
        new h(this, this.f12543U, true, (C1066a) null).execute(new Context[]{this});
        this.f12563o0 = new B();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.finazzi.distquake.update_public_chat");
        int i8 = Build.VERSION.SDK_INT;
        if (i8 >= 33) {
            Intent unused = registerReceiver(this.f12563o0, intentFilter, 4);
        } else {
            registerReceiver(this.f12563o0, intentFilter);
        }
        this.f12564p0 = new A();
        IntentFilter intentFilter2 = new IntentFilter();
        intentFilter2.addAction("com.finazzi.distquake.update_private_chat");
        if (i8 >= 33) {
            Intent unused2 = registerReceiver(this.f12564p0, intentFilter2, 4);
        } else {
            registerReceiver(this.f12564p0, intentFilter2);
        }
    }

    private class r extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private boolean f12654a;

        /* renamed from: b  reason: collision with root package name */
        private String f12655b;

        private r() {
            this.f12655b = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
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
                com.finazzi.distquake.ChatActivity r0 = com.finazzi.distquake.ChatActivity.this
                int r0 = r0.f12558j0
                java.lang.String r0 = java.lang.Integer.toString(r0)
                java.lang.String r1 = "user_code"
                r7.put(r1, r0)
                java.lang.String r7 = u2.C1737L.a(r7)
                r0 = 1
                r1 = 0
                java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x00b3 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00b3 }
                r3.<init>()     // Catch:{ IOException -> 0x00b3 }
                com.finazzi.distquake.ChatActivity r4 = com.finazzi.distquake.ChatActivity.this     // Catch:{ IOException -> 0x00b3 }
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
                r6.f12655b = r7     // Catch:{ IOException -> 0x009f, all -> 0x009c }
                r7 = 0
                r6.f12654a = r7     // Catch:{ IOException -> 0x009f, all -> 0x009c }
                r2.disconnect()
                goto L_0x00ba
            L_0x00b1:
                r7 = move-exception
                goto L_0x00bd
            L_0x00b3:
                r6.f12654a = r0     // Catch:{ all -> 0x00b1 }
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
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.ChatActivity.r.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            if (!this.f12654a) {
                try {
                    JSONObject jSONObject = new JSONArray(this.f12655b).getJSONObject(0);
                    String string = jSONObject.getString("nick");
                    int i8 = jSONObject.getInt("sex");
                    int i9 = jSONObject.getInt("country");
                    String string2 = jSONObject.getString("town");
                    int i10 = jSONObject.getInt("age");
                    int i11 = jSONObject.getInt("updated");
                    int i12 = jSONObject.getInt("firstlog");
                    int i13 = jSONObject.getInt("fr");
                    Intent intent = new Intent().setClass(ChatActivity.this, ProfileOtherActivity.class);
                    intent.putExtra("com.finazzi.distquake.nick", string);
                    intent.putExtra("com.finazzi.distquake.sex", i8);
                    intent.putExtra("com.finazzi.distquake.country", i9);
                    intent.putExtra("com.finazzi.distquake.town", string2);
                    intent.putExtra("com.finazzi.distquake.age", i10);
                    intent.putExtra("com.finazzi.distquake.user_code", ChatActivity.this.f12558j0);
                    intent.putExtra("com.finazzi.distquake.updated", i11);
                    intent.putExtra("com.finazzi.distquake.firstlog", i12);
                    intent.putExtra("com.finazzi.distquake.accept_friendship", i13);
                    intent.putExtra("com.finazzi.distquake.postfix", ChatActivity.this.f12552d0);
                    ChatActivity.this.startActivity(intent);
                } catch (JSONException unused) {
                    Toast makeText = Toast.makeText(ChatActivity.this.getApplicationContext(), ChatActivity.this.getString(C2030R.string.manual_error), 0);
                    makeText.setGravity(17, 0, 0);
                    makeText.show();
                }
            } else {
                Toast makeText2 = Toast.makeText(ChatActivity.this.getApplicationContext(), ChatActivity.this.getString(C2030R.string.manual_error), 0);
                makeText2.setGravity(17, 0, 0);
                makeText2.show();
            }
        }

        /* synthetic */ r(ChatActivity chatActivity, C1066a aVar) {
            this();
        }
    }

    private class s extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private String f12657a;

        /* renamed from: b  reason: collision with root package name */
        private int f12658b;

        private s() {
            this.f12657a = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(5:11|10|18|19|(0)(0)) */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x00c3, code lost:
            r8 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:21:0x00c9, code lost:
            r2.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00d1, code lost:
            r2.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:18:0x00c5 */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x00c9  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x00d1  */
        /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r8) {
            /*
                r7 = this;
                r8 = 1
                r0 = 0
                java.util.HashMap r1 = new java.util.HashMap
                r1.<init>()
                com.finazzi.distquake.ChatActivity r2 = com.finazzi.distquake.ChatActivity.this
                java.lang.String r2 = r2.f12552d0
                java.lang.String r3 = "postfix"
                r1.put(r3, r2)
                java.lang.String r1 = u2.C1737L.a(r1)
                r2 = 0
                com.finazzi.distquake.ChatActivity r3 = com.finazzi.distquake.ChatActivity.this     // Catch:{ IOException -> 0x00c5 }
                java.lang.Class<com.finazzi.distquake.MainActivity> r4 = com.finazzi.distquake.MainActivity.class
                java.lang.String r4 = r4.getSimpleName()     // Catch:{ IOException -> 0x00c5 }
                android.content.SharedPreferences r3 = r3.getSharedPreferences(r4, r0)     // Catch:{ IOException -> 0x00c5 }
                java.lang.String r4 = "sub_domain"
                com.finazzi.distquake.ChatActivity r5 = com.finazzi.distquake.ChatActivity.this     // Catch:{ IOException -> 0x00c5 }
                r6 = 2131887099(0x7f1203fb, float:1.9408796E38)
                java.lang.String r5 = r5.getString(r6)     // Catch:{ IOException -> 0x00c5 }
                java.lang.String r3 = r3.getString(r4, r5)     // Catch:{ IOException -> 0x00c5 }
                com.finazzi.distquake.ChatActivity r4 = com.finazzi.distquake.ChatActivity.this     // Catch:{ IOException -> 0x00c5 }
                r5 = 2131887098(0x7f1203fa, float:1.9408793E38)
                java.lang.String r4 = r4.getString(r5)     // Catch:{ IOException -> 0x00c5 }
                java.lang.Object[] r5 = new java.lang.Object[r8]     // Catch:{ IOException -> 0x00c5 }
                r5[r0] = r3     // Catch:{ IOException -> 0x00c5 }
                java.lang.String r3 = java.lang.String.format(r4, r5)     // Catch:{ IOException -> 0x00c5 }
                java.net.URL r4 = new java.net.URL     // Catch:{ IOException -> 0x00c5 }
                java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c5 }
                r5.<init>()     // Catch:{ IOException -> 0x00c5 }
                r5.append(r3)     // Catch:{ IOException -> 0x00c5 }
                java.lang.String r3 = "distquake_download_online3.php?"
                r5.append(r3)     // Catch:{ IOException -> 0x00c5 }
                r5.append(r1)     // Catch:{ IOException -> 0x00c5 }
                java.lang.String r1 = r5.toString()     // Catch:{ IOException -> 0x00c5 }
                r4.<init>(r1)     // Catch:{ IOException -> 0x00c5 }
                java.net.URLConnection r1 = r4.openConnection()     // Catch:{ IOException -> 0x00c5 }
                java.lang.Object r1 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r1)     // Catch:{ IOException -> 0x00c5 }
                java.net.URLConnection r1 = (java.net.URLConnection) r1     // Catch:{ IOException -> 0x00c5 }
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ IOException -> 0x00c5 }
                r1.setDoOutput(r0)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r2 = 10000(0x2710, float:1.4013E-41)
                r1.setConnectTimeout(r2)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r1.setReadTimeout(r2)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.lang.String r2 = "Content-Type"
                java.lang.String r3 = "application/x-www-form-urlencoded;charset=utf-8"
                r1.setRequestProperty(r2, r3)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.lang.String r2 = "GET"
                r1.setRequestMethod(r2)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.io.InputStream r3 = r1.getInputStream()     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r2.<init>(r3)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.io.BufferedReader r3 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.io.InputStreamReader r4 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.nio.charset.Charset r5 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r4.<init>(r2, r5)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r3.<init>(r4)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r4.<init>()     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
            L_0x0099:
                java.lang.String r5 = r3.readLine()     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                if (r5 == 0) goto L_0x00a8
                r4.append(r5)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                goto L_0x0099
            L_0x00a3:
                r8 = move-exception
                r2 = r1
                goto L_0x00cf
            L_0x00a6:
                r2 = r1
                goto L_0x00c5
            L_0x00a8:
                r2.close()     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.lang.String r2 = r4.toString()     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                r7.f12657a = r2     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                java.lang.String r3 = "empty"
                boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                if (r2 == 0) goto L_0x00bd
                r0 = 2
                r7.f12658b = r0     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
                goto L_0x00bf
            L_0x00bd:
                r7.f12658b = r0     // Catch:{ IOException -> 0x00a6, all -> 0x00a3 }
            L_0x00bf:
                r1.disconnect()
                goto L_0x00cc
            L_0x00c3:
                r8 = move-exception
                goto L_0x00cf
            L_0x00c5:
                r7.f12658b = r8     // Catch:{ all -> 0x00c3 }
                if (r2 == 0) goto L_0x00cc
                r2.disconnect()
            L_0x00cc:
                java.lang.String r8 = "COMPLETE!"
                return r8
            L_0x00cf:
                if (r2 == 0) goto L_0x00d4
                r2.disconnect()
            L_0x00d4:
                throw r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.ChatActivity.s.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            if (this.f12658b == 0) {
                try {
                    JSONArray jSONArray = new JSONArray(this.f12657a);
                    int length = jSONArray.length();
                    String[] strArr = new String[length];
                    int[] iArr = new int[length];
                    int[] iArr2 = new int[length];
                    int[] iArr3 = new int[length];
                    int[] iArr4 = new int[length];
                    int[] iArr5 = new int[length];
                    int[] iArr6 = new int[length];
                    for (int i8 = 0; i8 < length; i8++) {
                        JSONObject jSONObject = jSONArray.getJSONObject(i8);
                        strArr[i8] = jSONObject.getString("nk");
                        iArr3[i8] = Integer.parseInt(jSONObject.getString("uc"));
                        iArr[i8] = Integer.parseInt(jSONObject.getString("md"));
                        iArr2[i8] = Integer.parseInt(jSONObject.getString("st"));
                        iArr4[i8] = Integer.parseInt(jSONObject.getString("df"));
                        iArr5[i8] = Integer.parseInt(jSONObject.getString("ct"));
                        iArr6[i8] = Integer.parseInt(jSONObject.getString("pr"));
                    }
                    ChatActivity.this.f12555g0.clear();
                    for (int i9 = 0; i9 < length; i9++) {
                        z zVar = new z(ChatActivity.this, (C1066a) null);
                        zVar.x(iArr3[i9]);
                        zVar.B(strArr[i9]);
                        zVar.A(iArr[i9]);
                        zVar.D(iArr2[i9]);
                        zVar.z(iArr4[i9]);
                        zVar.y(iArr5[i9]);
                        zVar.C(iArr6[i9]);
                        ChatActivity.this.f12556h0.d(zVar);
                    }
                } catch (JSONException e8) {
                    if (e8.getMessage() != null) {
                        Log.d("EQN", e8.getMessage());
                    }
                }
            }
        }

        /* synthetic */ s(ChatActivity chatActivity, C1066a aVar) {
            this();
        }
    }

    private class t extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private String f12660a;

        private t() {
            this.f12660a = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Removed duplicated region for block: B:17:0x00d1  */
        /* JADX WARNING: Removed duplicated region for block: B:21:0x00d7  */
        /* JADX WARNING: Removed duplicated region for block: B:25:? A[RETURN, SYNTHETIC] */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String doInBackground(android.content.Context... r6) {
            /*
                r5 = this;
                java.util.HashMap r6 = new java.util.HashMap
                r6.<init>()
                com.finazzi.distquake.ChatActivity r0 = com.finazzi.distquake.ChatActivity.this
                java.lang.String r0 = r0.f12552d0
                java.lang.String r1 = "postfix"
                r6.put(r1, r0)
                com.finazzi.distquake.ChatActivity r0 = com.finazzi.distquake.ChatActivity.this
                java.lang.String r0 = r0.f12544V
                java.lang.String r1 = "nick"
                r6.put(r1, r0)
                com.finazzi.distquake.ChatActivity r0 = com.finazzi.distquake.ChatActivity.this
                int r0 = r0.f12546X
                java.lang.String r0 = java.lang.Integer.toString(r0)
                java.lang.String r1 = "u_code"
                r6.put(r1, r0)
                com.finazzi.distquake.ChatActivity r0 = com.finazzi.distquake.ChatActivity.this
                int r0 = r0.f12572x0
                java.lang.String r0 = java.lang.Integer.toString(r0)
                java.lang.String r1 = "pro"
                r6.put(r1, r0)
                java.lang.String r6 = u2.C1737L.a(r6)
                r0 = 0
                java.net.URL r1 = new java.net.URL     // Catch:{ IOException -> 0x00d5, all -> 0x00ce }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00d5, all -> 0x00ce }
                r2.<init>()     // Catch:{ IOException -> 0x00d5, all -> 0x00ce }
                com.finazzi.distquake.ChatActivity r3 = com.finazzi.distquake.ChatActivity.this     // Catch:{ IOException -> 0x00d5, all -> 0x00ce }
                r4 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r3 = r3.getString(r4)     // Catch:{ IOException -> 0x00d5, all -> 0x00ce }
                r2.append(r3)     // Catch:{ IOException -> 0x00d5, all -> 0x00ce }
                java.lang.String r3 = "distquake_upload_online3.php"
                r2.append(r3)     // Catch:{ IOException -> 0x00d5, all -> 0x00ce }
                java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x00d5, all -> 0x00ce }
                r1.<init>(r2)     // Catch:{ IOException -> 0x00d5, all -> 0x00ce }
                java.net.URLConnection r1 = r1.openConnection()     // Catch:{ IOException -> 0x00d5, all -> 0x00ce }
                java.lang.Object r1 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r1)     // Catch:{ IOException -> 0x00d5, all -> 0x00ce }
                java.net.URLConnection r1 = (java.net.URLConnection) r1     // Catch:{ IOException -> 0x00d5, all -> 0x00ce }
                java.net.HttpURLConnection r1 = (java.net.HttpURLConnection) r1     // Catch:{ IOException -> 0x00d5, all -> 0x00ce }
                r0 = 1
                r1.setDoOutput(r0)     // Catch:{ IOException -> 0x00bf, all -> 0x00bc }
                r0 = 10000(0x2710, float:1.4013E-41)
                r1.setConnectTimeout(r0)     // Catch:{ IOException -> 0x00bf, all -> 0x00bc }
                r1.setReadTimeout(r0)     // Catch:{ IOException -> 0x00bf, all -> 0x00bc }
                java.lang.String r0 = "Content-Type"
                java.lang.String r2 = "application/x-www-form-urlencoded;charset=utf-8"
                r1.setRequestProperty(r0, r2)     // Catch:{ IOException -> 0x00bf, all -> 0x00bc }
                java.lang.String r0 = "POST"
                r1.setRequestMethod(r0)     // Catch:{ IOException -> 0x00bf, all -> 0x00bc }
                byte[] r0 = r6.getBytes()     // Catch:{ IOException -> 0x00bf, all -> 0x00bc }
                int r0 = r0.length     // Catch:{ IOException -> 0x00bf, all -> 0x00bc }
                r1.setFixedLengthStreamingMode(r0)     // Catch:{ IOException -> 0x00bf, all -> 0x00bc }
                java.io.PrintWriter r0 = new java.io.PrintWriter     // Catch:{ IOException -> 0x00bf, all -> 0x00bc }
                java.io.OutputStream r2 = r1.getOutputStream()     // Catch:{ IOException -> 0x00bf, all -> 0x00bc }
                r0.<init>(r2)     // Catch:{ IOException -> 0x00bf, all -> 0x00bc }
                r0.print(r6)     // Catch:{ IOException -> 0x00bf, all -> 0x00bc }
                r0.close()     // Catch:{ IOException -> 0x00bf, all -> 0x00bc }
                java.io.BufferedInputStream r6 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00bf, all -> 0x00bc }
                java.io.InputStream r0 = r1.getInputStream()     // Catch:{ IOException -> 0x00bf, all -> 0x00bc }
                r6.<init>(r0)     // Catch:{ IOException -> 0x00bf, all -> 0x00bc }
                java.io.BufferedReader r0 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00bf, all -> 0x00bc }
                java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00bf, all -> 0x00bc }
                java.nio.charset.Charset r3 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00bf, all -> 0x00bc }
                r2.<init>(r6, r3)     // Catch:{ IOException -> 0x00bf, all -> 0x00bc }
                r0.<init>(r2)     // Catch:{ IOException -> 0x00bf, all -> 0x00bc }
                java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00bf, all -> 0x00bc }
                r2.<init>()     // Catch:{ IOException -> 0x00bf, all -> 0x00bc }
            L_0x00b2:
                java.lang.String r3 = r0.readLine()     // Catch:{ IOException -> 0x00bf, all -> 0x00bc }
                if (r3 == 0) goto L_0x00c1
                r2.append(r3)     // Catch:{ IOException -> 0x00bf, all -> 0x00bc }
                goto L_0x00b2
            L_0x00bc:
                r6 = move-exception
                r0 = r1
                goto L_0x00cf
            L_0x00bf:
                r0 = r1
                goto L_0x00d5
            L_0x00c1:
                java.lang.String r0 = r2.toString()     // Catch:{ IOException -> 0x00bf, all -> 0x00bc }
                r5.f12660a = r0     // Catch:{ IOException -> 0x00bf, all -> 0x00bc }
                r6.close()     // Catch:{ IOException -> 0x00bf, all -> 0x00bc }
                r1.disconnect()
                goto L_0x00da
            L_0x00ce:
                r6 = move-exception
            L_0x00cf:
                if (r0 == 0) goto L_0x00d4
                r0.disconnect()
            L_0x00d4:
                throw r6
            L_0x00d5:
                if (r0 == 0) goto L_0x00da
                r0.disconnect()
            L_0x00da:
                java.lang.String r6 = "COMPLETE!"
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.ChatActivity.t.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            SharedPreferences.Editor edit = ChatActivity.this.getSharedPreferences(MainActivity.class.getSimpleName(), 0).edit();
            String str2 = this.f12660a;
            if (str2 != null) {
                if (str2.equalsIgnoreCase("ok2")) {
                    edit.putInt("chat_mod", 1);
                    edit.apply();
                    int unused = ChatActivity.this.f12548Z = 1;
                } else if (this.f12660a.equalsIgnoreCase("ok")) {
                    edit.putInt("chat_mod", 0);
                    edit.apply();
                }
            }
            if (!ChatActivity.this.f12562n0) {
                return;
            }
            if (ChatActivity.this.f12573y0 < 400 || ChatActivity.this.f12548Z == 1) {
                ChatActivity.this.u1();
            }
        }

        /* synthetic */ t(ChatActivity chatActivity, C1066a aVar) {
            this();
        }
    }
}
