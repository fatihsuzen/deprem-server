package com.finazzi.distquake;

import android.app.KeyguardManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.location.Location;
import android.media.RingtoneManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager;
import android.provider.Settings;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.appcompat.app.C0767c;
import androidx.core.app.m;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.fido.fido2.api.common.UserVerificationMethods;
import com.google.android.gms.location.DeviceOrientationRequest;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapView;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.U;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import u2.C1755a3;
import u2.C1761b3;
import u2.C1767c3;
import u2.C1779e3;
import u2.C1785f3;
import u2.S2;
import u2.T2;
import u2.U2;
import u2.V2;
import u2.W2;
import u2.X2;
import u2.Y2;
import u2.Z2;

public class MyFirebaseMessagingService extends FirebaseMessagingService implements OnMapReadyCallback {
    /* access modifiers changed from: private */

    /* renamed from: i0  reason: collision with root package name */
    public static C0767c f13340i0;

    /* renamed from: j0  reason: collision with root package name */
    private static CountDownTimer f13341j0;

    /* renamed from: k0  reason: collision with root package name */
    private static CountDownTimer f13342k0;
    /* access modifiers changed from: private */

    /* renamed from: l0  reason: collision with root package name */
    public static GoogleMap f13343l0;
    /* access modifiers changed from: private */

    /* renamed from: m0  reason: collision with root package name */
    public static Circle f13344m0;
    /* access modifiers changed from: private */

    /* renamed from: n0  reason: collision with root package name */
    public static Marker f13345n0;
    /* access modifiers changed from: private */

    /* renamed from: A  reason: collision with root package name */
    public int f13346A;
    /* access modifiers changed from: private */

    /* renamed from: B  reason: collision with root package name */
    public int f13347B;

    /* renamed from: C  reason: collision with root package name */
    private double f13348C;

    /* renamed from: D  reason: collision with root package name */
    private double f13349D;

    /* renamed from: E  reason: collision with root package name */
    private double f13350E;

    /* renamed from: F  reason: collision with root package name */
    private double f13351F;
    /* access modifiers changed from: private */

    /* renamed from: G  reason: collision with root package name */
    public double f13352G;
    /* access modifiers changed from: private */

    /* renamed from: H  reason: collision with root package name */
    public double f13353H;

    /* renamed from: I  reason: collision with root package name */
    private double f13354I;

    /* renamed from: J  reason: collision with root package name */
    private int f13355J;

    /* renamed from: K  reason: collision with root package name */
    private int f13356K;

    /* renamed from: L  reason: collision with root package name */
    private int f13357L = 0;

    /* renamed from: M  reason: collision with root package name */
    private int f13358M = -1;

    /* renamed from: N  reason: collision with root package name */
    private int f13359N = -1;

    /* renamed from: O  reason: collision with root package name */
    private String f13360O;

    /* renamed from: P  reason: collision with root package name */
    private String f13361P;

    /* renamed from: Q  reason: collision with root package name */
    private String f13362Q;

    /* renamed from: R  reason: collision with root package name */
    private double f13363R;

    /* renamed from: S  reason: collision with root package name */
    private double f13364S;

    /* renamed from: T  reason: collision with root package name */
    private String f13365T;

    /* renamed from: U  reason: collision with root package name */
    private String f13366U;

    /* renamed from: V  reason: collision with root package name */
    private String f13367V;
    /* access modifiers changed from: private */

    /* renamed from: W  reason: collision with root package name */
    public float f13368W;

    /* renamed from: X  reason: collision with root package name */
    private float f13369X;

    /* renamed from: Y  reason: collision with root package name */
    private int f13370Y;

    /* renamed from: Z  reason: collision with root package name */
    private float f13371Z;

    /* renamed from: a0  reason: collision with root package name */
    private double f13372a0;

    /* renamed from: b0  reason: collision with root package name */
    private String f13373b0;

    /* renamed from: c0  reason: collision with root package name */
    private String f13374c0;
    /* access modifiers changed from: private */

    /* renamed from: d0  reason: collision with root package name */
    public int f13375d0;

    /* renamed from: e0  reason: collision with root package name */
    private final long[] f13376e0 = {0, 200, 200, 200};

    /* renamed from: f0  reason: collision with root package name */
    private m.b f13377f0;
    /* access modifiers changed from: private */

    /* renamed from: g0  reason: collision with root package name */
    public TextToSpeech f13378g0;

    /* renamed from: h0  reason: collision with root package name */
    PowerManager.WakeLock f13379h0;

    /* renamed from: s  reason: collision with root package name */
    private f f13380s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public g f13381t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public SQLiteDatabase f13382u;
    /* access modifiers changed from: private */

    /* renamed from: v  reason: collision with root package name */
    public C f13383v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public String f13384w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public String f13385x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public String f13386y;
    /* access modifiers changed from: private */

    /* renamed from: z  reason: collision with root package name */
    public String f13387z;

    class a extends UtteranceProgressListener {
        a() {
        }

        public void onDone(String str) {
            if (MyFirebaseMessagingService.this.f13378g0 != null) {
                MyFirebaseMessagingService.this.f13378g0.stop();
                MyFirebaseMessagingService.this.f13378g0.shutdown();
            }
        }

        public void onError(String str) {
            if (MyFirebaseMessagingService.this.f13378g0 != null) {
                MyFirebaseMessagingService.this.f13378g0.stop();
                MyFirebaseMessagingService.this.f13378g0.shutdown();
            }
        }

        public void onStart(String str) {
        }
    }

    class b extends UtteranceProgressListener {
        b() {
        }

        public void onDone(String str) {
            if (MyFirebaseMessagingService.this.f13378g0 != null) {
                MyFirebaseMessagingService.this.f13378g0.stop();
                MyFirebaseMessagingService.this.f13378g0.shutdown();
            }
        }

        public void onError(String str) {
            if (MyFirebaseMessagingService.this.f13378g0 != null) {
                MyFirebaseMessagingService.this.f13378g0.stop();
                MyFirebaseMessagingService.this.f13378g0.shutdown();
            }
        }

        public void onStart(String str) {
        }
    }

    class c extends UtteranceProgressListener {
        c() {
        }

        public void onDone(String str) {
            if (MyFirebaseMessagingService.this.f13378g0 != null) {
                MyFirebaseMessagingService.this.f13378g0.stop();
                MyFirebaseMessagingService.this.f13378g0.shutdown();
            }
        }

        public void onError(String str) {
            if (MyFirebaseMessagingService.this.f13378g0 != null) {
                MyFirebaseMessagingService.this.f13378g0.stop();
                MyFirebaseMessagingService.this.f13378g0.shutdown();
            }
        }

        public void onStart(String str) {
        }
    }

    class d extends CountDownTimer {
        d(long j8, long j9) {
            super(j8, j9);
        }

        public void onFinish() {
            if (MyFirebaseMessagingService.f13340i0 != null) {
                String quantityString = MyFirebaseMessagingService.this.getResources().getQuantityString(C2030R.plurals.alert_wave, 0, new Object[]{0});
                TextView textView = (TextView) MyFirebaseMessagingService.f13340i0.findViewById(C2030R.id.textView2);
                if (textView != null) {
                    textView.setVisibility(0);
                    textView.setText(quantityString);
                }
            }
        }

        public void onTick(long j8) {
            if (MyFirebaseMessagingService.f13340i0 != null) {
                int unused = MyFirebaseMessagingService.this.f13375d0 = (int) Math.round(((double) j8) / 1000.0d);
                String quantityString = MyFirebaseMessagingService.this.getResources().getQuantityString(C2030R.plurals.alert_wave, MyFirebaseMessagingService.this.f13375d0, new Object[]{Integer.valueOf(MyFirebaseMessagingService.this.f13375d0)});
                TextView textView = (TextView) MyFirebaseMessagingService.f13340i0.findViewById(C2030R.id.textView2);
                if (textView != null) {
                    textView.setVisibility(0);
                    textView.setText(quantityString);
                    if (MyFirebaseMessagingService.this.f13375d0 > 15) {
                        textView.setTextColor(Color.rgb(255, 140, 0));
                    } else if (MyFirebaseMessagingService.this.f13375d0 > 5) {
                        textView.setTextColor(Color.rgb(255, 100, 0));
                    } else {
                        textView.setTextColor(Color.rgb(255, 0, 0));
                    }
                }
            }
        }
    }

    class e extends CountDownTimer {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ double f13392a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        e(long j8, long j9, double d8) {
            super(j8, j9);
            this.f13392a = d8;
        }

        public void onFinish() {
            if (MyFirebaseMessagingService.f13344m0 != null) {
                MyFirebaseMessagingService.f13344m0.remove();
            }
            PowerManager.WakeLock wakeLock = MyFirebaseMessagingService.this.f13379h0;
            if (wakeLock != null && wakeLock.isHeld()) {
                MyFirebaseMessagingService.this.f13379h0.release();
            }
            if (MyFirebaseMessagingService.f13340i0 != null) {
                MyFirebaseMessagingService.f13340i0.getWindow().clearFlags(UserVerificationMethods.USER_VERIFY_PATTERN);
            }
        }

        public void onTick(long j8) {
            double U7 = (((120000.0d - ((double) j8)) / 1000.0d) + this.f13392a) * ((double) MyFirebaseMessagingService.this.f13368W) * 1000.0d;
            if (MyFirebaseMessagingService.f13343l0 != null) {
                if (MyFirebaseMessagingService.f13344m0 != null) {
                    MyFirebaseMessagingService.f13344m0.remove();
                }
                CircleOptions circleOptions = new CircleOptions();
                circleOptions.center(new LatLng(MyFirebaseMessagingService.this.f13352G, MyFirebaseMessagingService.this.f13353H));
                circleOptions.radius(U7);
                circleOptions.strokeColor(-65536);
                circleOptions.fillColor(Color.argb(50, UserVerificationMethods.USER_VERIFY_PATTERN, 0, 0));
                circleOptions.strokeWidth(7.0f);
                Circle unused = MyFirebaseMessagingService.f13344m0 = MyFirebaseMessagingService.f13343l0.addCircle(circleOptions);
            }
        }
    }

    private class f extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private final int f13394a;

        /* renamed from: b  reason: collision with root package name */
        private final String f13395b;

        /* renamed from: c  reason: collision with root package name */
        private final String f13396c;

        /* renamed from: d  reason: collision with root package name */
        private final String f13397d;

        /* renamed from: e  reason: collision with root package name */
        private final String f13398e;

        /* renamed from: f  reason: collision with root package name */
        private final int f13399f;

        /* renamed from: g  reason: collision with root package name */
        private final int f13400g;

        /* renamed from: h  reason: collision with root package name */
        private final int f13401h;

        /* renamed from: i  reason: collision with root package name */
        private final int f13402i;

        /* renamed from: j  reason: collision with root package name */
        private final int f13403j;

        /* renamed from: k  reason: collision with root package name */
        private final int f13404k;

        /* renamed from: l  reason: collision with root package name */
        private Cursor f13405l;

        f(int i8, String str, int i9, int i10, String str2, String str3, String str4, int i11, int i12, int i13, int i14) {
            this.f13394a = i8;
            this.f13395b = str;
            this.f13399f = i9;
            this.f13400g = i10;
            this.f13396c = str2;
            this.f13397d = str3;
            this.f13398e = str4;
            this.f13401h = i11;
            this.f13402i = i14;
            this.f13403j = i12;
            this.f13404k = i13;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Context... contextArr) {
            MyFirebaseMessagingService myFirebaseMessagingService = MyFirebaseMessagingService.this;
            SQLiteDatabase unused = myFirebaseMessagingService.f13382u = myFirebaseMessagingService.f13383v.getWritableDatabase();
            if (MyFirebaseMessagingService.this.f13382u == null) {
                return "COMPLETE!";
            }
            this.f13405l = MyFirebaseMessagingService.this.f13382u.query("blocked_users", new String[]{"_id", "user_code"}, "user_code=" + this.f13400g, (String[]) null, (String) null, (String) null, (String) null);
            return "COMPLETE!";
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            Cursor cursor = this.f13405l;
            if (cursor != null) {
                cursor.moveToPosition(-1);
                int i8 = 0;
                while (this.f13405l.moveToNext()) {
                    Cursor cursor2 = this.f13405l;
                    i8 = cursor2.getInt(cursor2.getColumnIndexOrThrow("user_code"));
                }
                this.f13405l.close();
                int i9 = this.f13400g;
                if (i8 != i9) {
                    MyFirebaseMessagingService myFirebaseMessagingService = MyFirebaseMessagingService.this;
                    g unused = myFirebaseMessagingService.f13381t = new g(this.f13394a, this.f13395b, this.f13399f, i9, this.f13396c, this.f13397d, this.f13398e, this.f13401h, this.f13403j, this.f13404k, this.f13402i);
                    MyFirebaseMessagingService.this.x0();
                }
            }
        }
    }

    private class g extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private final int f13407a;

        /* renamed from: b  reason: collision with root package name */
        private final String f13408b;

        /* renamed from: c  reason: collision with root package name */
        private final String f13409c;

        /* renamed from: d  reason: collision with root package name */
        private final String f13410d;

        /* renamed from: e  reason: collision with root package name */
        private final String f13411e;

        /* renamed from: f  reason: collision with root package name */
        private final int f13412f;

        /* renamed from: g  reason: collision with root package name */
        private final int f13413g;

        /* renamed from: h  reason: collision with root package name */
        private final int f13414h;

        /* renamed from: i  reason: collision with root package name */
        private final int f13415i;

        /* renamed from: j  reason: collision with root package name */
        private final int f13416j;

        /* renamed from: k  reason: collision with root package name */
        private final int f13417k;

        /* renamed from: l  reason: collision with root package name */
        private int f13418l;

        /* renamed from: m  reason: collision with root package name */
        private int f13419m;

        g(int i8, String str, int i9, int i10, String str2, String str3, String str4, int i11, int i12, int i13, int i14) {
            this.f13407a = i8;
            this.f13408b = str;
            this.f13412f = i9;
            this.f13413g = i10;
            this.f13409c = str2;
            this.f13410d = str3;
            this.f13411e = str4;
            this.f13414h = i11;
            this.f13415i = i14;
            this.f13416j = i12;
            this.f13417k = i13;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Context... contextArr) {
            MyFirebaseMessagingService myFirebaseMessagingService = MyFirebaseMessagingService.this;
            SQLiteDatabase unused = myFirebaseMessagingService.f13382u = myFirebaseMessagingService.f13383v.getWritableDatabase();
            if (MyFirebaseMessagingService.this.f13382u == null) {
                return "COMPLETE!";
            }
            ContentValues contentValues = new ContentValues();
            if (this.f13407a == this.f13413g) {
                this.f13418l = 1;
                contentValues.put("received", 1);
                contentValues.put("moderator", Integer.valueOf(this.f13414h));
                contentValues.put("country", Integer.valueOf(this.f13416j));
                contentValues.put("id_db", Integer.valueOf(this.f13412f));
                SQLiteDatabase Z7 = MyFirebaseMessagingService.this.f13382u;
                String str = this.f13408b;
                Z7.update(str, contentValues, "message_code=" + this.f13415i + " AND " + "user_code" + "=" + this.f13413g, (String[]) null);
                return "COMPLETE!";
            }
            this.f13418l = 0;
            contentValues.put("id_db", Integer.valueOf(this.f13412f));
            contentValues.put("user_code", Integer.valueOf(this.f13413g));
            contentValues.put("nick", this.f13409c);
            contentValues.put("date", this.f13410d);
            contentValues.put("message", this.f13411e);
            contentValues.put("moderator", Integer.valueOf(this.f13414h));
            contentValues.put("country", Integer.valueOf(this.f13416j));
            contentValues.put("pro", Integer.valueOf(this.f13417k));
            contentValues.put("message_code", Integer.valueOf(this.f13415i));
            contentValues.put("self", 0);
            contentValues.put("sent", 1);
            contentValues.put("received", 1);
            contentValues.put("error", 0);
            this.f13419m = (int) MyFirebaseMessagingService.this.f13382u.insert(this.f13408b, (String) null, contentValues);
            return "COMPLETE!";
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            Intent intent = new Intent();
            intent.setPackage("com.finazzi.distquake");
            intent.setAction("com.finazzi.distquake.update_public_chat");
            intent.putExtra("com.finazzi.distquake.public_chat_table", this.f13408b);
            intent.putExtra("com.finazzi.distquake.public_chat_self", this.f13418l);
            intent.putExtra("com.finazzi.distquake.public_chat_msgcode", this.f13415i);
            intent.putExtra("com.finazzi.distquake.public_chat_idnewmessage", this.f13419m);
            intent.putExtra("com.finazzi.distquake.public_chat_moderator", this.f13414h);
            intent.putExtra("com.finazzi.distquake.public_chat_country", this.f13416j);
            intent.putExtra("com.finazzi.distquake.public_chat_pro", this.f13417k);
            MyFirebaseMessagingService.this.sendBroadcast(intent);
        }
    }

    private class h extends AsyncTask {
        private h() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public String doInBackground(Context... contextArr) {
            MyFirebaseMessagingService myFirebaseMessagingService = MyFirebaseMessagingService.this;
            SQLiteDatabase unused = myFirebaseMessagingService.f13382u = myFirebaseMessagingService.f13383v.getWritableDatabase();
            if (MyFirebaseMessagingService.this.f13382u == null) {
                return "COMPLETE!";
            }
            ContentValues contentValues = new ContentValues();
            contentValues.put("user_id_from", Integer.valueOf(MyFirebaseMessagingService.this.f13346A));
            contentValues.put("user_id_to", Integer.valueOf(MyFirebaseMessagingService.this.f13347B));
            contentValues.put("nick_from", MyFirebaseMessagingService.this.f13384w);
            contentValues.put("nick_to", MyFirebaseMessagingService.this.f13385x);
            contentValues.put("date", MyFirebaseMessagingService.this.f13386y);
            contentValues.put("message", MyFirebaseMessagingService.this.f13387z);
            MyFirebaseMessagingService.this.f13382u.insert("chat_allusers", (String) null, contentValues);
            ContentValues contentValues2 = new ContentValues();
            contentValues2.put("user_id_from", Integer.valueOf(MyFirebaseMessagingService.this.f13346A));
            contentValues2.put("nick_from", MyFirebaseMessagingService.this.f13384w);
            contentValues2.put("read", 0);
            contentValues2.put("date", MyFirebaseMessagingService.this.f13386y);
            contentValues2.put("message", MyFirebaseMessagingService.this.f13387z);
            if (((int) MyFirebaseMessagingService.this.f13382u.insertWithOnConflict("chat_preview", (String) null, contentValues2, 4)) != -1) {
                return "COMPLETE!";
            }
            SQLiteDatabase Z7 = MyFirebaseMessagingService.this.f13382u;
            Z7.update("chat_preview", contentValues2, "user_id_from=" + MyFirebaseMessagingService.this.f13346A, (String[]) null);
            return "COMPLETE!";
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            Intent intent = new Intent();
            intent.setPackage("com.finazzi.distquake");
            intent.setAction("com.finazzi.distquake.update_private_chat");
            intent.putExtra("com.finazzi.distquake.private_chat_user_code_from", MyFirebaseMessagingService.this.f13346A);
            intent.putExtra("com.finazzi.distquake.private_chat_nick", MyFirebaseMessagingService.this.f13384w);
            intent.putExtra("com.finazzi.distquake.private_chat_msg", MyFirebaseMessagingService.this.f13387z);
            MyFirebaseMessagingService.this.sendBroadcast(intent);
            MyFirebaseMessagingService.this.K();
        }

        /* synthetic */ h(MyFirebaseMessagingService myFirebaseMessagingService, a aVar) {
            this();
        }
    }

    private class i extends AsyncTask {

        /* renamed from: a  reason: collision with root package name */
        private boolean f13422a;

        /* renamed from: b  reason: collision with root package name */
        private String f13423b;

        /* renamed from: c  reason: collision with root package name */
        private final String f13424c;

        /* renamed from: d  reason: collision with root package name */
        private final String f13425d;

        /* renamed from: e  reason: collision with root package name */
        private final float f13426e;

        /* renamed from: f  reason: collision with root package name */
        private final float f13427f;

        /* synthetic */ i(MyFirebaseMessagingService myFirebaseMessagingService, String str, String str2, float f8, float f9, a aVar) {
            this(str, str2, f8, f9);
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Can't wrap try/catch for region: R(5:11|10|15|16|(0)(0)) */
        /* JADX WARNING: Code restructure failed: missing block: B:14:0x00c1, code lost:
            r7 = th;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x00c7, code lost:
            r1.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x00cf, code lost:
            r1.disconnect();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
            return "COMPLETE!";
         */
        /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
            return "COMPLETE!";
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
                java.lang.String r1 = r6.f13425d
                r7.put(r0, r1)
                java.lang.String r0 = "r_id"
                java.lang.String r1 = r6.f13424c
                r7.put(r0, r1)
                float r0 = r6.f13426e
                java.lang.String r0 = java.lang.Float.toString(r0)
                java.lang.String r1 = "lat"
                r7.put(r1, r0)
                float r0 = r6.f13427f
                java.lang.String r0 = java.lang.Float.toString(r0)
                java.lang.String r1 = "lon"
                r7.put(r1, r0)
                java.lang.String r7 = u2.C1737L.a(r7)
                r0 = 1
                r1 = 0
                java.net.URL r2 = new java.net.URL     // Catch:{ IOException -> 0x00c3 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00c3 }
                r3.<init>()     // Catch:{ IOException -> 0x00c3 }
                com.finazzi.distquake.MyFirebaseMessagingService r4 = com.finazzi.distquake.MyFirebaseMessagingService.this     // Catch:{ IOException -> 0x00c3 }
                r5 = 2131887097(0x7f1203f9, float:1.9408791E38)
                java.lang.String r4 = r4.getString(r5)     // Catch:{ IOException -> 0x00c3 }
                r3.append(r4)     // Catch:{ IOException -> 0x00c3 }
                java.lang.String r4 = "distquake_upload_gcm_regid2.php"
                r3.append(r4)     // Catch:{ IOException -> 0x00c3 }
                java.lang.String r3 = r3.toString()     // Catch:{ IOException -> 0x00c3 }
                r2.<init>(r3)     // Catch:{ IOException -> 0x00c3 }
                java.net.URLConnection r2 = r2.openConnection()     // Catch:{ IOException -> 0x00c3 }
                java.lang.Object r2 = com.google.firebase.perf.network.FirebasePerfUrlConnection.instrument(r2)     // Catch:{ IOException -> 0x00c3 }
                java.net.URLConnection r2 = (java.net.URLConnection) r2     // Catch:{ IOException -> 0x00c3 }
                java.net.HttpURLConnection r2 = (java.net.HttpURLConnection) r2     // Catch:{ IOException -> 0x00c3 }
                r2.setDoOutput(r0)     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                r1 = 10000(0x2710, float:1.4013E-41)
                r2.setConnectTimeout(r1)     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                r2.setReadTimeout(r1)     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                java.lang.String r1 = "Content-Type"
                java.lang.String r3 = "application/x-www-form-urlencoded;charset=utf-8"
                r2.setRequestProperty(r1, r3)     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                java.lang.String r1 = "POST"
                r2.setRequestMethod(r1)     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                byte[] r1 = r7.getBytes()     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                int r1 = r1.length     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                r2.setFixedLengthStreamingMode(r1)     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                java.io.PrintWriter r1 = new java.io.PrintWriter     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                java.io.OutputStream r3 = r2.getOutputStream()     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                r1.print(r7)     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                r1.close()     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                java.io.BufferedInputStream r7 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                java.io.InputStream r1 = r2.getInputStream()     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                r7.<init>(r1)     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                java.io.InputStreamReader r3 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                java.nio.charset.Charset r4 = java.nio.charset.StandardCharsets.UTF_8     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                r3.<init>(r7, r4)     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                r1.<init>(r3)     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                r3.<init>()     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
            L_0x00a2:
                java.lang.String r4 = r1.readLine()     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                if (r4 == 0) goto L_0x00b1
                r3.append(r4)     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                goto L_0x00a2
            L_0x00ac:
                r7 = move-exception
                r1 = r2
                goto L_0x00cd
            L_0x00af:
                r1 = r2
                goto L_0x00c3
            L_0x00b1:
                r7.close()     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                java.lang.String r7 = r3.toString()     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                r6.f13423b = r7     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                r7 = 0
                r6.f13422a = r7     // Catch:{ IOException -> 0x00af, all -> 0x00ac }
                r2.disconnect()
                goto L_0x00ca
            L_0x00c1:
                r7 = move-exception
                goto L_0x00cd
            L_0x00c3:
                r6.f13422a = r0     // Catch:{ all -> 0x00c1 }
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
            throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.MyFirebaseMessagingService.i.doInBackground(android.content.Context[]):java.lang.String");
        }

        /* access modifiers changed from: protected */
        /* renamed from: b */
        public void onPostExecute(String str) {
            super.onPostExecute(str);
            SharedPreferences.Editor edit = MyFirebaseMessagingService.this.getSharedPreferences(MainActivity.class.getSimpleName(), 0).edit();
            if (this.f13422a) {
                edit.putBoolean("FCM_refresh", true);
            } else if (this.f13423b.equalsIgnoreCase("nok")) {
                edit.putBoolean("FCM_refresh", true);
            } else {
                try {
                    if (Integer.parseInt(this.f13423b) != 0) {
                        edit.putString("android_id_eqn", this.f13423b);
                        edit.putBoolean("FCM_refresh", false);
                        edit.putString("last_FCM_registered_token", this.f13424c);
                        edit.putLong("last_FCM_registered_token_time", System.currentTimeMillis());
                    } else {
                        edit.putBoolean("FCM_refresh", true);
                    }
                } catch (NumberFormatException unused) {
                    edit.putBoolean("FCM_refresh", true);
                }
            }
            edit.apply();
        }

        private i(String str, String str2, float f8, float f9) {
            this.f13423b = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
            this.f13425d = str;
            this.f13424c = str2;
            this.f13426e = f8;
            this.f13427f = f9;
        }
    }

    public static /* synthetic */ void A(MyFirebaseMessagingService myFirebaseMessagingService, String str, int i8) {
        if (i8 != -1) {
            String string = myFirebaseMessagingService.getString(C2030R.string.current_language);
            if (string.equals("eng")) {
                myFirebaseMessagingService.f13378g0.setLanguage(Locale.ENGLISH);
            }
            if (string.equals("ita")) {
                myFirebaseMessagingService.f13378g0.setLanguage(Locale.ITALIAN);
            }
            if (string.equals("es")) {
                myFirebaseMessagingService.f13378g0.setLanguage(new Locale("es"));
            }
            if (string.equals("tr")) {
                myFirebaseMessagingService.f13378g0.setLanguage(new Locale("tr"));
            }
            if (string.equals("el")) {
                myFirebaseMessagingService.f13378g0.setLanguage(new Locale("el"));
            }
            if (string.equals("fr")) {
                myFirebaseMessagingService.f13378g0.setLanguage(new Locale("fr"));
            }
            if (string.equals("in")) {
                myFirebaseMessagingService.f13378g0.setLanguage(new Locale("in"));
            }
            if (string.equals("hr")) {
                myFirebaseMessagingService.f13378g0.setLanguage(new Locale("hr"));
            }
            if (string.equals("ar")) {
                myFirebaseMessagingService.f13378g0.setLanguage(new Locale("ar"));
            }
            myFirebaseMessagingService.f13378g0.setSpeechRate(1.0f);
            myFirebaseMessagingService.f13378g0.speak(str, 0, (Bundle) null, "tts");
            return;
        }
        myFirebaseMessagingService.getClass();
    }

    public static /* synthetic */ void B() {
        Marker marker = f13345n0;
        if (marker != null) {
            marker.remove();
        }
    }

    public static /* synthetic */ void C(MyFirebaseMessagingService myFirebaseMessagingService, View view) {
        myFirebaseMessagingService.getClass();
        Intent intent = new Intent();
        intent.setAction("com.finazzi.distquake.stopalarm");
        intent.setPackage("com.finazzi.distquake");
        myFirebaseMessagingService.sendBroadcast(intent);
        f13340i0.dismiss();
        CountDownTimer countDownTimer = f13341j0;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        CountDownTimer countDownTimer2 = f13342k0;
        if (countDownTimer2 != null) {
            countDownTimer2.cancel();
        }
        Intent intent2 = new Intent().setClass(myFirebaseMessagingService, MainActivity.class);
        intent2.setFlags(268435456);
        myFirebaseMessagingService.startActivity(intent2);
    }

    public static /* synthetic */ void D(MyFirebaseMessagingService myFirebaseMessagingService, DialogInterface dialogInterface) {
        myFirebaseMessagingService.getClass();
        Intent intent = new Intent();
        intent.setAction("com.finazzi.distquake.stopalarm");
        intent.setPackage("com.finazzi.distquake");
        myFirebaseMessagingService.sendBroadcast(intent);
    }

    public static /* synthetic */ void E(LatLng latLng, Location location) {
        if (location != null && f13343l0 != null) {
            LatLng latLng2 = new LatLng(location.getLatitude(), location.getLongitude());
            PolylineOptions polylineOptions = new PolylineOptions();
            polylineOptions.color(-65536);
            polylineOptions.geodesic(false);
            polylineOptions.width(4.0f);
            polylineOptions.add(latLng);
            polylineOptions.add(latLng2);
            f13343l0.addPolyline(polylineOptions);
        }
    }

    public static /* synthetic */ void F(MyFirebaseMessagingService myFirebaseMessagingService, double d8, String str, long j8) {
        MyFirebaseMessagingService myFirebaseMessagingService2 = myFirebaseMessagingService;
        myFirebaseMessagingService2.v0(myFirebaseMessagingService2.f13362Q, d8, str, j8, (double) myFirebaseMessagingService2.f13369X, myFirebaseMessagingService2.f13372a0, myFirebaseMessagingService2.f13354I, myFirebaseMessagingService2.f13358M, myFirebaseMessagingService2.f13359N, myFirebaseMessagingService2.f13360O);
    }

    public static /* synthetic */ void G(MyFirebaseMessagingService myFirebaseMessagingService) {
        myFirebaseMessagingService.getClass();
        TextView textView = (TextView) f13340i0.findViewById(C2030R.id.textView3);
        double d8 = myFirebaseMessagingService.f13372a0;
        if (d8 < 1.5d) {
            textView.setText(myFirebaseMessagingService.getString(C2030R.string.alert_intensity_no_shaking));
            textView.setTextColor(-7829368);
        } else if (d8 < 3.0d) {
            textView.setText(myFirebaseMessagingService.getString(C2030R.string.alert_intensity_mild));
            textView.setTextColor(Color.rgb(38, 100, 38));
        } else if (d8 < 4.5d) {
            textView.setText(myFirebaseMessagingService.getString(C2030R.string.alert_intensity_moderate));
            textView.setTextColor(Color.rgb(255, 140, 0));
        } else {
            textView.setText(myFirebaseMessagingService.getString(C2030R.string.alert_intensity_strong));
            textView.setTextColor(-65536);
        }
    }

    public static /* synthetic */ void H(MyFirebaseMessagingService myFirebaseMessagingService, SharedPreferences sharedPreferences, int i8, int i9, String str, SharedPreferences sharedPreferences2, double d8, long j8, String str2, double d9, DialogInterface dialogInterface) {
        String str3;
        String str4;
        double d10;
        myFirebaseMessagingService.getClass();
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putInt("alert_code", i8);
        edit.putInt("alert_update", i9);
        edit.putString("alert_shaking", str);
        edit.putBoolean("alert_dialog_showing", true);
        edit.apply();
        f13340i0.m(-1).setOnClickListener(new U2(myFirebaseMessagingService));
        f13340i0.m(-2).setOnClickListener(new V2(myFirebaseMessagingService));
        String string = sharedPreferences2.getString("eqn_notify_alarm_sound", "1");
        boolean z7 = d8 < 3.0d && sharedPreferences2.getBoolean("eqn_notify_alarm_nosound_if_mild", true);
        int parseInt = Integer.parseInt(string);
        if (parseInt < 4 && !z7) {
            Intent intent = new Intent().setClass(myFirebaseMessagingService, PlayerService.class);
            if (parseInt == 1) {
                intent.setAction("com.finazzi.distquake.action.PLAY2");
            } else if (parseInt == 2) {
                intent.setAction("com.finazzi.distquake.action.PLAY3");
            } else if (parseInt == 3) {
                intent.setAction("com.finazzi.distquake.action.PLAY4");
            }
            if (Build.VERSION.SDK_INT >= 26) {
                ComponentName unused = myFirebaseMessagingService.startForegroundService(intent);
            } else {
                myFirebaseMessagingService.startService(intent);
            }
        }
        if (sharedPreferences2.getBoolean("eqn_tts_eqn", false)) {
            if (j8 <= 0 || j8 > 120) {
                if (str2.equals("1")) {
                    d10 = 0.621371192d * d9;
                    str4 = myFirebaseMessagingService.getString(C2030R.string.options_tts_mi);
                } else {
                    str4 = myFirebaseMessagingService.getString(C2030R.string.options_tts_km);
                    d10 = d9;
                }
                str3 = String.format(myFirebaseMessagingService.getString(C2030R.string.options_tts_network_noseconds), new Object[]{Long.toString(Math.round(d10)), str4});
            } else {
                str3 = String.format(myFirebaseMessagingService.getString(C2030R.string.options_tts_network), new Object[]{Long.toString(j8)});
            }
            TextToSpeech textToSpeech = new TextToSpeech(myFirebaseMessagingService.getApplicationContext(), new W2(myFirebaseMessagingService, str3));
            myFirebaseMessagingService.f13378g0 = textToSpeech;
            textToSpeech.setOnUtteranceProgressListener(new c());
        }
    }

    private void I() {
        int i8;
        String str;
        String str2;
        String str3;
        double d8;
        SharedPreferences sharedPreferences;
        Class<MainActivity> cls;
        String str4;
        int i9;
        PendingIntent pendingIntent;
        double d9;
        boolean z7;
        int i10;
        String str5;
        PendingIntent pendingIntent2;
        int i11;
        Bitmap bitmap;
        int i12;
        String str6;
        String str7;
        m.e eVar;
        String str8;
        String str9;
        NotificationManager notificationManager;
        long j8;
        String str10;
        double d10;
        boolean z8;
        boolean z9;
        int i13;
        int i14;
        int i15;
        String str11;
        boolean z10;
        String str12;
        boolean z11;
        SharedPreferences sharedPreferences2;
        int i16;
        PendingIntent pendingIntent3;
        String str13;
        SharedPreferences b8 = androidx.preference.g.b(this);
        Class<MainActivity> cls2 = MainActivity.class;
        SharedPreferences sharedPreferences3 = getSharedPreferences(cls2.getSimpleName(), 0);
        boolean z12 = b8.getBoolean("eqn_notify_alarm", false);
        String string = b8.getString("eqn_system_of_units", "0");
        boolean canDrawOverlays = Settings.canDrawOverlays(getApplicationContext());
        if (!string.equals("1") || (str13 = this.f13362Q) == null) {
            i8 = 0;
        } else {
            i8 = 0;
            String[] split = str13.split("km");
            if (split.length > 1) {
                try {
                    DecimalFormat decimalFormat = new DecimalFormat("0");
                    this.f13362Q = decimalFormat.format((double) Math.round(Double.parseDouble(split[0].trim()) * 0.621371192d)) + " mi " + split[1].trim();
                } catch (NumberFormatException e8) {
                    if (e8.getMessage() != null) {
                        Log.d("EQN", e8.getMessage());
                    }
                }
            }
        }
        if (z12) {
            if (s0()) {
                float[] m02 = m0();
                sharedPreferences = sharedPreferences3;
                str3 = "alert_code";
                str2 = "alert_shaking";
                str = "com.finazzi.distquake.code_eqn";
                str4 = string;
                cls = cls2;
                d8 = p0((double) m02[i8], (double) m02[1], this.f13352G, this.f13353H);
            } else {
                str = "com.finazzi.distquake.code_eqn";
                str2 = "alert_shaking";
                str3 = "alert_code";
                str4 = string;
                cls = cls2;
                sharedPreferences = sharedPreferences3;
                d8 = -1.0d;
            }
            this.f13372a0 = -1.0d;
            if (d8 > 0.0d) {
                this.f13372a0 = (Math.log10(Math.sqrt(Math.pow(10.0d, 2.0d) + (1.62103724E8d * Math.pow(Math.sin(d8 / 12742.0d), 2.0d)))) * -2.15d) + (this.f13354I * 1.03d) + 2.31d;
            }
            double d11 = this.f13372a0;
            if (d11 < 1.5d) {
                this.f13360O = "not_perceived";
            } else if (d11 < 3.0d) {
                this.f13360O = "mild";
            } else if (d11 < 4.5d) {
                this.f13360O = "moderate";
            } else {
                this.f13360O = "strong";
            }
            if (d11 < 1.5d) {
                i9 = i8;
            } else {
                if (this.f13356K == 0) {
                    SharedPreferences.Editor edit = sharedPreferences.edit();
                    edit.putFloat("latitude_eqn", (float) this.f13352G);
                    edit.putFloat("longitude_eqn", (float) this.f13353H);
                    edit.putInt("counter_eqn", this.f13355J);
                    edit.putString("datetime_eqn", this.f13361P);
                    edit.putInt("intensity_eqn", this.f13370Y);
                    edit.putFloat("peak_acc_eqn", this.f13371Z);
                    edit.putString("location_eqn", this.f13362Q);
                    edit.putFloat("intensity_at_location_eqn", (float) this.f13372a0);
                    edit.putFloat("magnitude_eqn", (float) this.f13354I);
                    edit.putInt("pos_eqn", this.f13357L);
                    edit.putBoolean("alert_shown_eqn", true);
                    edit.apply();
                }
                i9 = 1;
            }
            if (i9 == 0 || !j0()) {
                String str14 = "notification";
                if (i9 != 0 && !j0()) {
                    Intent intent = new Intent(getApplicationContext(), cls);
                    if (Build.VERSION.SDK_INT >= 31) {
                        pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, 201326592);
                    } else {
                        pendingIntent = PendingIntent.getActivity(getApplicationContext(), 0, intent, 134217728);
                    }
                    Notification b9 = new m.e(getApplicationContext(), getApplicationContext().getString(C2030R.string.channel_permission)).i(String.format(getApplicationContext().getString(C2030R.string.location_fix), new Object[]{getApplicationContext().getString(C2030R.string.app_name)})).p(BitmapFactory.decodeResource(getApplicationContext().getResources(), 2131230872)).w(2131230872).z(new m.c().h(String.format(getApplicationContext().getString(C2030R.string.location_fix), new Object[]{getApplicationContext().getString(C2030R.string.app_name)}))).h(pendingIntent).b();
                    NotificationManager notificationManager2 = (NotificationManager) getApplicationContext().getSystemService(str14);
                    if (notificationManager2 != null) {
                        notificationManager2.notify(999000, b9);
                        return;
                    }
                    return;
                }
                return;
            }
            y0();
            NotificationManager notificationManager3 = (NotificationManager) getSystemService("notification");
            String string2 = getString(C2030R.string.notification_alert_nodistance);
            Object[] objArr = new Object[1];
            objArr[i8] = this.f13362Q;
            String format = String.format(string2, objArr);
            if (str4.equals("1")) {
                String string3 = getString(C2030R.string.notification_alert_imperial);
                String str15 = this.f13362Q;
                Integer valueOf = Integer.valueOf((int) Math.round(d8 * 0.621371192d));
                d9 = -1.0d;
                i10 = 2;
                Object[] objArr2 = new Object[2];
                objArr2[i8] = str15;
                z7 = true;
                objArr2[1] = valueOf;
                str5 = String.format(string3, objArr2);
            } else {
                d9 = -1.0d;
                i10 = 2;
                z7 = true;
                String string4 = getString(C2030R.string.notification_alert);
                String str16 = this.f13362Q;
                Integer valueOf2 = Integer.valueOf((int) Math.round(d8));
                Object[] objArr3 = new Object[2];
                objArr3[i8] = str16;
                objArr3[1] = valueOf2;
                str5 = String.format(string4, objArr3);
            }
            Intent intent2 = new Intent(this, cls);
            intent2.setFlags(805306368);
            intent2.putExtra("com.finazzi.distquake.realtime", z7);
            intent2.setAction("action_eqn");
            int i17 = Build.VERSION.SDK_INT;
            if (i17 >= 31) {
                pendingIntent2 = PendingIntent.getActivity(this, i8, intent2, 201326592);
            } else {
                pendingIntent2 = PendingIntent.getActivity(this, i8, intent2, 134217728);
            }
            m.e eVar2 = new m.e(this, getString(C2030R.string.channel_realtime));
            m.b bVar = new m.b();
            this.f13377f0 = bVar;
            bVar.j(str5);
            double d12 = this.f13354I;
            if (d12 < 3.0d) {
                bitmap = BitmapFactory.decodeResource(getResources(), 2131231367);
                i11 = 2131231363;
            } else if (d12 < 5.0d) {
                i11 = 2131231363;
                bitmap = BitmapFactory.decodeResource(getResources(), 2131231363);
            } else {
                i11 = 2131231363;
                bitmap = BitmapFactory.decodeResource(getResources(), 2131231361);
            }
            eVar2.w(C2030R.drawable.star_outline);
            eVar2.p(bitmap);
            eVar2.j(format);
            eVar2.i(str5);
            eVar2.A(str5);
            eVar2.e(true);
            eVar2.h(pendingIntent2);
            double d13 = this.f13354I;
            if (d13 >= 3.0d) {
                i12 = i11;
            } else {
                i12 = 2131231367;
            }
            if (d13 >= 5.0d) {
                i12 = 2131231361;
            }
            int i18 = i10;
            int i19 = i12;
            String str17 = "notification";
            Bitmap t02 = t0(i19, this.f13352G, this.f13353H);
            if (t02 != null) {
                this.f13377f0.i(t02);
                eVar2.z(this.f13377f0);
            }
            if (i17 < 26) {
                eVar2.B(this.f13376e0);
                eVar2.y(RingtoneManager.getDefaultUri(i18), 5);
            }
            if (canDrawOverlays || r0()) {
                if (s0()) {
                    float[] m03 = m0();
                    double d14 = (double) m03[0];
                    float f8 = m03[1];
                    str6 = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                    eVar = eVar2;
                    str8 = "0";
                    notificationManager = notificationManager3;
                    String str18 = str4;
                    str9 = "recent_notification";
                    str7 = str18;
                    String o02 = o0(n0(d14, (double) f8, this.f13352G, this.f13353H));
                    j8 = Math.round((d8 / ((double) this.f13368W)) - ((double) this.f13369X));
                    str10 = o02;
                    d10 = d8;
                } else {
                    str6 = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
                    str7 = str4;
                    eVar = eVar2;
                    str8 = "0";
                    str9 = "recent_notification";
                    notificationManager = notificationManager3;
                    j8 = 0;
                    str10 = str6;
                    d10 = d9;
                }
                long j9 = j8;
                if (i17 < 34 || ((NotificationManager) getSystemService(str17)).canUseFullScreenIntent()) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                if (!r0() || !z8) {
                    String str19 = str2;
                    SharedPreferences sharedPreferences4 = sharedPreferences;
                    boolean z13 = false;
                    if (sharedPreferences4.getInt(str3, 0) == this.f13358M) {
                        if (sharedPreferences4.getString(str19, str6).equalsIgnoreCase(this.f13360O)) {
                            z10 = false;
                        } else if (!sharedPreferences4.getBoolean("alert_dialog_showing", false) || f13340i0 == null) {
                            z10 = false;
                            z13 = true;
                        } else {
                            z10 = true;
                            z13 = false;
                        }
                        z9 = z10;
                    } else {
                        z13 = true;
                        z9 = false;
                    }
                    if (z13) {
                        if (notificationManager != null) {
                            SharedPreferences.Editor edit2 = sharedPreferences4.edit();
                            edit2.putLong(str9, System.currentTimeMillis());
                            edit2.apply();
                            notificationManager.notify("eqn_notification", 50, eVar.b());
                        }
                        C0767c cVar = f13340i0;
                        if (cVar != null) {
                            cVar.dismiss();
                        }
                        i15 = 2131231363;
                        i14 = 2131231367;
                        i13 = 2131231361;
                        new Handler(Looper.getMainLooper()).post(new Y2(this, d8, str10, j9));
                    } else {
                        i15 = 2131231363;
                        i14 = 2131231367;
                        i13 = 2131231361;
                    }
                    if (z9) {
                        if (f13343l0 != null) {
                            new Handler(Looper.getMainLooper()).post(new Z2());
                            LatLng latLng = new LatLng(this.f13352G, this.f13353H);
                            MarkerOptions markerOptions = new MarkerOptions();
                            markerOptions.position(latLng);
                            markerOptions.anchor(0.5f, 0.5f);
                            double d15 = this.f13354I;
                            if (d15 < 3.0d) {
                                markerOptions.icon(BitmapDescriptorFactory.fromResource(i14));
                            } else if (d15 < 5.0d) {
                                markerOptions.icon(BitmapDescriptorFactory.fromResource(i15));
                            } else {
                                markerOptions.icon(BitmapDescriptorFactory.fromResource(i13));
                            }
                            new Handler(Looper.getMainLooper()).post(new C1755a3(markerOptions));
                        }
                        if (d10 != d9) {
                            DecimalFormatSymbols instance = DecimalFormatSymbols.getInstance();
                            instance.setDecimalSeparator('.');
                            DecimalFormat decimalFormat2 = new DecimalFormat("0.0", instance);
                            if (str7.equalsIgnoreCase(str8)) {
                                String string5 = getString(C2030R.string.main_detected);
                                String format2 = decimalFormat2.format(this.f13354I);
                                String str20 = this.f13362Q;
                                Integer valueOf3 = Integer.valueOf((int) Math.round(d10));
                                Object[] objArr4 = new Object[4];
                                objArr4[0] = format2;
                                objArr4[1] = str20;
                                objArr4[i18] = valueOf3;
                                objArr4[3] = str10;
                                str11 = String.format(string5, objArr4);
                            } else {
                                String string6 = getString(C2030R.string.main_detected_imperial);
                                String format3 = decimalFormat2.format(this.f13354I);
                                String str21 = this.f13362Q;
                                Integer valueOf4 = Integer.valueOf((int) Math.round(d10 * 0.621371192d));
                                Object[] objArr5 = new Object[4];
                                objArr5[0] = format3;
                                objArr5[1] = str21;
                                objArr5[i18] = valueOf4;
                                objArr5[3] = str10;
                                str11 = String.format(string6, objArr5);
                            }
                            new Handler(Looper.getMainLooper()).post(new C1761b3(str11));
                            new Handler(Looper.getMainLooper()).post(new C1767c3(this));
                            return;
                        }
                        return;
                    }
                    return;
                }
                if (f13340i0 != null) {
                    Intent intent3 = new Intent();
                    intent3.setAction("com.finazzi.distquake.stopalarm");
                    intent3.setPackage("com.finazzi.distquake");
                    sendBroadcast(intent3);
                    f13340i0.dismiss();
                }
                SharedPreferences sharedPreferences5 = sharedPreferences;
                boolean z14 = false;
                if (sharedPreferences5.getInt(str3, 0) == this.f13358M) {
                    if (sharedPreferences5.getString(str2, str6).equalsIgnoreCase(this.f13360O)) {
                        z11 = false;
                    } else if (sharedPreferences5.getBoolean("alert_activity_showing", false)) {
                        z11 = true;
                        z14 = false;
                    } else {
                        z11 = false;
                        z14 = true;
                    }
                    str12 = str;
                } else {
                    Intent intent4 = new Intent();
                    intent4.setAction("com.finazzi.distquake.close_alert");
                    str12 = str;
                    intent4.putExtra(str12, this.f13358M);
                    intent4.setPackage("com.finazzi.distquake");
                    sendBroadcast(intent4);
                    z11 = false;
                    z14 = true;
                }
                if (z14) {
                    if (notificationManager != null) {
                        SharedPreferences.Editor edit3 = sharedPreferences5.edit();
                        sharedPreferences2 = sharedPreferences5;
                        i16 = i17;
                        edit3.putLong(str9, System.currentTimeMillis());
                        edit3.apply();
                        notificationManager.notify("eqn_notification", 50, eVar.b());
                    } else {
                        sharedPreferences2 = sharedPreferences5;
                        i16 = i17;
                    }
                    Intent intent5 = new Intent(this, AlertActivity.class);
                    intent5.putExtra("com.finazzi.distquake.intensity", this.f13370Y);
                    intent5.putExtra("com.finazzi.distquake.latitude", this.f13352G);
                    intent5.putExtra("com.finazzi.distquake.longitude", this.f13353H);
                    intent5.putExtra("com.finazzi.distquake.location", this.f13362Q);
                    intent5.putExtra("com.finazzi.distquake.wave_speed", this.f13368W);
                    intent5.putExtra("com.finazzi.distquake.distance", d10);
                    intent5.putExtra("com.finazzi.distquake.direction", str10);
                    intent5.putExtra("com.finazzi.distquake.warning_time", j9);
                    intent5.putExtra("com.finazzi.distquake.alert_delay", this.f13369X);
                    intent5.putExtra("com.finazzi.distquake.magnitude", this.f13354I);
                    intent5.putExtra("com.finazzi.distquake.alert_code", this.f13358M);
                    intent5.putExtra("com.finazzi.distquake.alert_update", this.f13359N);
                    intent5.putExtra("com.finazzi.distquake.notification_id", 99900);
                    intent5.putExtra("com.finazzi.distquake.intensity_at_location", this.f13372a0);
                    if (i16 >= 31) {
                        pendingIntent3 = PendingIntent.getActivity(this, 0, intent5, 201326592);
                    } else {
                        pendingIntent3 = PendingIntent.getActivity(this, 0, intent5, 134217728);
                    }
                    Notification b10 = new m.e(this, getString(C2030R.string.channel_countdown)).i(getString(C2030R.string.channel_countdown_name)).w(C2030R.drawable.bullseye).n(pendingIntent3, true).e(true).b();
                    if (notificationManager != null) {
                        SharedPreferences.Editor edit4 = sharedPreferences2.edit();
                        edit4.putLong(str9, System.currentTimeMillis());
                        edit4.apply();
                        notificationManager.cancel(99900);
                        notificationManager.notify(99900, b10);
                    }
                }
                if (z11) {
                    Intent intent6 = new Intent();
                    intent6.setAction("com.finazzi.distquake.update_alert");
                    intent6.setPackage("com.finazzi.distquake");
                    intent6.putExtra(str12, this.f13358M);
                    intent6.putExtra("com.finazzi.distquake.new_magnitude", this.f13354I);
                    intent6.putExtra("com.finazzi.distquake.new_intensity_at_location", this.f13372a0);
                    sendBroadcast(intent6);
                }
            } else if (notificationManager3 != null) {
                SharedPreferences.Editor edit5 = sharedPreferences.edit();
                edit5.putLong("recent_notification", System.currentTimeMillis());
                edit5.apply();
                notificationManager3.notify("eqn_notification", 50, eVar2.b());
            }
        }
    }

    private void J() {
        String str;
        PendingIntent pendingIntent;
        Bitmap bitmap;
        if (androidx.preference.g.b(this).getBoolean("chat_notify_friendship", false)) {
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            String string = getString(C2030R.string.app_name);
            if (this.f13374c0.equals("requested")) {
                str = String.format(getString(C2030R.string.friend_notification_requested), new Object[]{this.f13373b0});
            } else {
                str = RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED;
            }
            if (this.f13374c0.equals("accepted")) {
                str = String.format(getString(C2030R.string.friend_notification_accepted), new Object[]{this.f13373b0});
            }
            int random = (int) (Math.random() * 1000.0d);
            Intent intent = new Intent(this, MainActivity.class);
            intent.setAction("friendship");
            intent.putExtra("com.finazzi.distquake.friendship_type", this.f13374c0);
            intent.setFlags(805306368);
            int i8 = Build.VERSION.SDK_INT;
            if (i8 >= 31) {
                pendingIntent = PendingIntent.getActivity(this, 0, intent, 201326592);
            } else {
                pendingIntent = PendingIntent.getActivity(this, 0, intent, 134217728);
            }
            m.e eVar = new m.e(this, getString(C2030R.string.channel_friendship));
            if (this.f13374c0.equals("accepted")) {
                bitmap = BitmapFactory.decodeResource(getResources(), C2030R.drawable.account_heart);
                eVar.w(C2030R.drawable.account_heart);
            } else {
                bitmap = BitmapFactory.decodeResource(getResources(), C2030R.drawable.account_plus);
                eVar.w(C2030R.drawable.account_plus);
            }
            eVar.p(bitmap);
            eVar.j(string);
            eVar.i(str);
            eVar.A(str);
            eVar.e(true);
            eVar.B((long[]) null);
            eVar.x((Uri) null);
            eVar.h(pendingIntent);
            if (i8 <= 26) {
                Uri defaultUri = RingtoneManager.getDefaultUri(2);
                eVar.B(this.f13376e0);
                eVar.y(defaultUri, 5);
                eVar.h(pendingIntent);
            }
            if (notificationManager != null) {
                notificationManager.notify("friendship_notification", random, eVar.b());
            }
        }
    }

    /* access modifiers changed from: private */
    public void K() {
        PendingIntent pendingIntent;
        if (androidx.preference.g.b(this).getBoolean("chat_notify_new_messages_personal", false)) {
            NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
            String string = getString(C2030R.string.app_name);
            String str = this.f13384w + ": " + this.f13387z;
            int i8 = this.f13346A;
            Class<MainActivity> cls = MainActivity.class;
            Intent intent = new Intent(this, cls);
            intent.setAction("personal_chat");
            intent.putExtra("com.finazzi.distquake.personal_chat", true);
            intent.putExtra("com.finazzi.distquake.personal_chat_user_code", this.f13346A);
            intent.putExtra("com.finazzi.distquake.personal_chat_user_nick", this.f13384w);
            intent.setFlags(805306368);
            int i9 = Build.VERSION.SDK_INT;
            if (i9 >= 31) {
                pendingIntent = PendingIntent.getActivity(this, 0, intent, 201326592);
            } else {
                pendingIntent = PendingIntent.getActivity(this, 0, intent, 134217728);
            }
            m.e eVar = new m.e(this, getString(C2030R.string.channel_chat_private));
            eVar.w(C2030R.drawable.message_text_outline);
            eVar.p(BitmapFactory.decodeResource(getResources(), 2131231275));
            eVar.j(string);
            eVar.i(str);
            eVar.q(-65536, 300, 800);
            eVar.A(str);
            eVar.e(true);
            eVar.h(pendingIntent);
            if (i9 <= 26) {
                Uri defaultUri = RingtoneManager.getDefaultUri(2);
                eVar.B(this.f13376e0);
                eVar.y(defaultUri, 5);
                eVar.h(pendingIntent);
            }
            if (notificationManager != null) {
                SharedPreferences.Editor edit = getSharedPreferences(cls.getSimpleName(), 0).edit();
                edit.putLong("recent_notification", System.currentTimeMillis());
                edit.apply();
                notificationManager.notify("chat_personal_notification", i8, eVar.b());
            }
        }
    }

    private void L() {
        double d8;
        double d9;
        double d10;
        String str;
        PendingIntent pendingIntent;
        String str2;
        String str3;
        SharedPreferences b8 = androidx.preference.g.b(this);
        boolean z7 = b8.getBoolean("eqn_notify_manual", true);
        try {
            d8 = Double.parseDouble(b8.getString("eqn_notify_radius_report", "1000"));
        } catch (NumberFormatException unused) {
            d8 = 1000.0d;
        }
        double d11 = d8;
        if (z7) {
            String string = b8.getString("eqn_system_of_units", "0");
            boolean z8 = b8.getBoolean("eqn_tts_manual", false);
            if (s0()) {
                float[] m02 = m0();
                d9 = p0((double) m02[0], (double) m02[1], this.f13348C, this.f13349D);
            } else {
                d9 = 20000.0d;
            }
            if (d9 <= d11) {
                NotificationManager notificationManager = (NotificationManager) getSystemService("notification");
                String string2 = getString(C2030R.string.notification_report_nodistance);
                if (d9 == -1.0d) {
                    d10 = 0.621371192d;
                    str = getString(C2030R.string.notification_report_nodistance);
                } else if (string.equals("1")) {
                    d9 *= 0.621371192d;
                    d10 = 0.621371192d;
                    str = String.format(getString(C2030R.string.official_distance_imperial_nodirection), new Object[]{Integer.valueOf((int) Math.round(d9))});
                } else {
                    d10 = 0.621371192d;
                    str = String.format(getString(C2030R.string.official_distance_nodirection), new Object[]{Integer.valueOf((int) Math.round(d9))});
                }
                Class<MainActivity> cls = MainActivity.class;
                Intent intent = new Intent(this, cls);
                intent.setFlags(805306368);
                intent.putExtra("com.finazzi.distquake.report", true);
                Object obj = "1";
                intent.putExtra("com.finazzi.distquake.report_lat", this.f13348C);
                intent.putExtra("com.finazzi.distquake.report_lon", this.f13349D);
                intent.setAction("action_1");
                int i8 = Build.VERSION.SDK_INT;
                if (i8 >= 31) {
                    pendingIntent = PendingIntent.getActivity(this, 0, intent, 201326592);
                } else {
                    pendingIntent = PendingIntent.getActivity(this, 0, intent, 134217728);
                }
                m.e eVar = new m.e(this, getString(C2030R.string.channel_reports));
                m.c cVar = new m.c();
                cVar.i(string2);
                cVar.h(str);
                eVar.z(cVar);
                eVar.j(string2);
                eVar.i(str);
                eVar.q(-65536, 300, 800);
                eVar.A(str);
                eVar.e(true);
                eVar.h(pendingIntent);
                eVar.w(C2030R.drawable.alert_outline);
                if (i8 < 26) {
                    Uri defaultUri = RingtoneManager.getDefaultUri(2);
                    eVar.B(this.f13376e0);
                    eVar.y(defaultUri, 5);
                }
                if (notificationManager != null) {
                    SharedPreferences.Editor edit = getSharedPreferences(cls.getSimpleName(), 0).edit();
                    edit.putLong("recent_notification", System.currentTimeMillis());
                    edit.apply();
                    notificationManager.notify("manual_notification", 10, eVar.b());
                }
                if (z8 && d9 >= 0.0d) {
                    if (string.equals(obj)) {
                        d9 *= d10;
                        str2 = getString(C2030R.string.options_tts_mi);
                    } else {
                        str2 = getString(C2030R.string.options_tts_km);
                    }
                    String l7 = Long.toString(Math.round(d9));
                    if (getString(C2030R.string.current_language).equals("tr")) {
                        str3 = String.format(getString(C2030R.string.options_tts_manual), new Object[]{l7, str2});
                    } else {
                        str3 = String.format(getString(C2030R.string.options_tts_manual), new Object[]{l7, str2});
                    }
                    TextToSpeech textToSpeech = new TextToSpeech(getApplicationContext(), new C1779e3(this, str3));
                    this.f13378g0 = textToSpeech;
                    textToSpeech.setOnUtteranceProgressListener(new a());
                }
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v2, resolved type: boolean} */
    /* JADX WARNING: type inference failed for: r23v4 */
    /* JADX WARNING: type inference failed for: r23v6 */
    /* JADX WARNING: type inference failed for: r23v7 */
    /* JADX WARNING: type inference failed for: r9v24 */
    /* JADX WARNING: type inference failed for: r9v25 */
    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x00b9, code lost:
        if (r1 > 2000.0d) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00c9, code lost:
        if (r1 > 1600.0d) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00d9, code lost:
        if (r1 > 1300.0d) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00e2, code lost:
        if (r1 > 1000.0d) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00f2, code lost:
        if (r1 > 700.0d) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0100, code lost:
        if (r1 > 500.0d) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x0110, code lost:
        if (r1 > 350.0d) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x011b, code lost:
        if (r1 > 200.0d) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x012b, code lost:
        if (r1 > 125.0d) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x013b, code lost:
        if (r1 > 70.0d) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:62:0x014a, code lost:
        if (r1 > 35.0d) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:66:0x0158, code lost:
        if (r1 > 20.0d) goto L_0x00bb;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:70:0x0166, code lost:
        if (r1 <= r25) goto L_0x016a;
     */
    /* JADX WARNING: Incorrect type for immutable var: ssa=int, code=?, for r9v0, types: [boolean, int] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:102:0x01f5  */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x0203  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0211  */
    /* JADX WARNING: Removed duplicated region for block: B:111:0x021f  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x022d  */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x023b  */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0247  */
    /* JADX WARNING: Removed duplicated region for block: B:123:0x0253  */
    /* JADX WARNING: Removed duplicated region for block: B:126:0x025f  */
    /* JADX WARNING: Removed duplicated region for block: B:129:0x026b  */
    /* JADX WARNING: Removed duplicated region for block: B:132:0x0277  */
    /* JADX WARNING: Removed duplicated region for block: B:135:0x0283  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x028f  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x029e  */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x02a4  */
    /* JADX WARNING: Removed duplicated region for block: B:145:0x02ae  */
    /* JADX WARNING: Removed duplicated region for block: B:146:0x02b7  */
    /* JADX WARNING: Removed duplicated region for block: B:147:0x02c0  */
    /* JADX WARNING: Removed duplicated region for block: B:148:0x02cc  */
    /* JADX WARNING: Removed duplicated region for block: B:149:0x02d5  */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x02de  */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x02e7  */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x02f3  */
    /* JADX WARNING: Removed duplicated region for block: B:153:0x02fc  */
    /* JADX WARNING: Removed duplicated region for block: B:154:0x0305  */
    /* JADX WARNING: Removed duplicated region for block: B:155:0x030e  */
    /* JADX WARNING: Removed duplicated region for block: B:156:0x0317  */
    /* JADX WARNING: Removed duplicated region for block: B:157:0x0322  */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x032c  */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x0336  */
    /* JADX WARNING: Removed duplicated region for block: B:160:0x0340  */
    /* JADX WARNING: Removed duplicated region for block: B:161:0x034a  */
    /* JADX WARNING: Removed duplicated region for block: B:162:0x0354  */
    /* JADX WARNING: Removed duplicated region for block: B:163:0x035e  */
    /* JADX WARNING: Removed duplicated region for block: B:164:0x0367  */
    /* JADX WARNING: Removed duplicated region for block: B:165:0x0370  */
    /* JADX WARNING: Removed duplicated region for block: B:167:0x037a  */
    /* JADX WARNING: Removed duplicated region for block: B:194:0x071a  */
    /* JADX WARNING: Removed duplicated region for block: B:195:0x0723  */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x0794  */
    /* JADX WARNING: Removed duplicated region for block: B:210:0x07ad  */
    /* JADX WARNING: Removed duplicated region for block: B:212:0x07b9  */
    /* JADX WARNING: Removed duplicated region for block: B:218:0x07ee  */
    /* JADX WARNING: Removed duplicated region for block: B:232:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:235:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x017d A[FALL_THROUGH] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0180  */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x019a  */
    /* JADX WARNING: Removed duplicated region for block: B:84:0x01a7  */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x01b4  */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01c1  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01ce  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x01db  */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01e8  */
    /* JADX WARNING: Unknown variable types count: 3 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void M() {
        /*
            r53 = this;
            r0 = r53
            r11 = 2131886828(0x7f1202ec, float:1.9408246E38)
            r4 = 0
            android.content.SharedPreferences r5 = androidx.preference.g.b(r0)
            java.lang.String r6 = "eqn_notify_official"
            r7 = 1
            boolean r6 = r5.getBoolean(r6, r7)
            if (r6 == 0) goto L_0x08c7
            java.lang.String r6 = "eqn_notify_minmag"
            java.lang.String r8 = "0.0"
            java.lang.String r6 = r5.getString(r6, r8)
            java.lang.String r1 = "eqn_notify_radius_official_new"
            java.lang.String r2 = "1000"
            java.lang.String r1 = r5.getString(r1, r2)
            java.lang.String r2 = "eqn_official_type"
            java.lang.String r12 = "0"
            java.lang.String r2 = r5.getString(r2, r12)
            r19 = 0
            double r21 = java.lang.Double.parseDouble(r6)     // Catch:{ NumberFormatException -> 0x0032 }
            goto L_0x0034
        L_0x0032:
            r21 = r19
        L_0x0034:
            r23 = 4652007308841189376(0x408f400000000000, double:1000.0)
            double r25 = java.lang.Double.parseDouble(r1)     // Catch:{ NumberFormatException -> 0x003e }
            goto L_0x0040
        L_0x003e:
            r25 = r23
        L_0x0040:
            java.lang.String r1 = "eqn_system_of_units"
            java.lang.String r1 = r5.getString(r1, r12)
            java.lang.String r6 = "eqn_tts_official"
            boolean r27 = r5.getBoolean(r6, r4)
            java.lang.String r6 = "eqn_tts_magnitude"
            java.lang.String r3 = "2.0"
            java.lang.String r3 = r5.getString(r6, r3)
            float r3 = java.lang.Float.parseFloat(r3)
            java.lang.String r5 = r0.f13367V
            boolean r6 = r0.s0()
            if (r6 == 0) goto L_0x008c
            float[] r6 = r0.m0()
            r29 = r4
            r4 = r6[r29]
            r30 = r7
            r31 = r8
            double r7 = (double) r4
            r4 = r6[r30]
            double r13 = (double) r4
            r4 = r5
            double r5 = r0.f13350E
            r34 = r1
            r33 = r2
            r1 = r7
            double r7 = r0.f13351F
            r36 = r3
            r15 = r4
            r3 = r13
            r9 = r30
            r13 = r31
            r14 = r33
            r35 = r34
            r10 = 2
            double r1 = r0.p0(r1, r3, r5, r7)
            goto L_0x009c
        L_0x008c:
            r35 = r1
            r14 = r2
            r36 = r3
            r29 = r4
            r15 = r5
            r9 = r7
            r13 = r8
            r10 = 2
            r1 = 4671226772094713856(0x40d3880000000000, double:20000.0)
        L_0x009c:
            boolean r3 = r14.equals(r12)
            r6 = 4616752568008179712(0x4012000000000000, double:4.5)
            r33 = 4617878467915022336(0x4016000000000000, double:5.5)
            r38 = 4611686018427387904(0x4000000000000000, double:2.0)
            if (r3 == 0) goto L_0x015c
            r40 = 4615063718147915776(0x400c000000000000, double:3.5)
            double r4 = r0.f13363R
            r21 = 4619567317775286272(0x401c000000000000, double:7.0)
            int r3 = (r4 > r21 ? 1 : (r4 == r21 ? 0 : -1))
            if (r3 >= 0) goto L_0x00bf
            r21 = 4656510908468559872(0x409f400000000000, double:2000.0)
            int r3 = (r1 > r21 ? 1 : (r1 == r21 ? 0 : -1))
            if (r3 <= 0) goto L_0x00bf
        L_0x00bb:
            r4 = r29
            goto L_0x016b
        L_0x00bf:
            r21 = 4619004367821864960(0x401a000000000000, double:6.5)
            int r3 = (r4 > r21 ? 1 : (r4 == r21 ? 0 : -1))
            if (r3 >= 0) goto L_0x00cc
            r21 = 4654751689864118272(0x4099000000000000, double:1600.0)
            int r3 = (r1 > r21 ? 1 : (r1 == r21 ? 0 : -1))
            if (r3 <= 0) goto L_0x00cc
            goto L_0x00bb
        L_0x00cc:
            r21 = 4618441417868443648(0x4018000000000000, double:6.0)
            int r3 = (r4 > r21 ? 1 : (r4 == r21 ? 0 : -1))
            if (r3 >= 0) goto L_0x00dc
            r21 = 4653432275910787072(0x4094500000000000, double:1300.0)
            int r3 = (r1 > r21 ? 1 : (r1 == r21 ? 0 : -1))
            if (r3 <= 0) goto L_0x00dc
            goto L_0x00bb
        L_0x00dc:
            int r3 = (r4 > r33 ? 1 : (r4 == r33 ? 0 : -1))
            if (r3 >= 0) goto L_0x00e5
            int r3 = (r1 > r23 ? 1 : (r1 == r23 ? 0 : -1))
            if (r3 <= 0) goto L_0x00e5
            goto L_0x00bb
        L_0x00e5:
            r21 = 4617315517961601024(0x4014000000000000, double:5.0)
            int r3 = (r4 > r21 ? 1 : (r4 == r21 ? 0 : -1))
            if (r3 >= 0) goto L_0x00f5
            r21 = 4649368480934526976(0x4085e00000000000, double:700.0)
            int r3 = (r1 > r21 ? 1 : (r1 == r21 ? 0 : -1))
            if (r3 <= 0) goto L_0x00f5
            goto L_0x00bb
        L_0x00f5:
            int r3 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r3 >= 0) goto L_0x0103
            r21 = 4647503709213818880(0x407f400000000000, double:500.0)
            int r3 = (r1 > r21 ? 1 : (r1 == r21 ? 0 : -1))
            if (r3 <= 0) goto L_0x0103
            goto L_0x00bb
        L_0x0103:
            r21 = 4616189618054758400(0x4010000000000000, double:4.0)
            int r3 = (r4 > r21 ? 1 : (r4 == r21 ? 0 : -1))
            if (r3 >= 0) goto L_0x0113
            r21 = 4644864881307156480(0x4075e00000000000, double:350.0)
            int r3 = (r1 > r21 ? 1 : (r1 == r21 ? 0 : -1))
            if (r3 <= 0) goto L_0x0113
            goto L_0x00bb
        L_0x0113:
            int r3 = (r4 > r40 ? 1 : (r4 == r40 ? 0 : -1))
            if (r3 >= 0) goto L_0x011e
            r21 = 4641240890982006784(0x4069000000000000, double:200.0)
            int r3 = (r1 > r21 ? 1 : (r1 == r21 ? 0 : -1))
            if (r3 <= 0) goto L_0x011e
            goto L_0x00bb
        L_0x011e:
            r21 = 4613937818241073152(0x4008000000000000, double:3.0)
            int r3 = (r4 > r21 ? 1 : (r4 == r21 ? 0 : -1))
            if (r3 >= 0) goto L_0x012e
            r21 = 4638496509959077888(0x405f400000000000, double:125.0)
            int r3 = (r1 > r21 ? 1 : (r1 == r21 ? 0 : -1))
            if (r3 <= 0) goto L_0x012e
            goto L_0x00bb
        L_0x012e:
            r21 = 4612811918334230528(0x4004000000000000, double:2.5)
            int r3 = (r4 > r21 ? 1 : (r4 == r21 ? 0 : -1))
            if (r3 >= 0) goto L_0x013f
            r21 = 4634626229029306368(0x4051800000000000, double:70.0)
            int r3 = (r1 > r21 ? 1 : (r1 == r21 ? 0 : -1))
            if (r3 <= 0) goto L_0x013f
            goto L_0x00bb
        L_0x013f:
            int r3 = (r4 > r38 ? 1 : (r4 == r38 ? 0 : -1))
            if (r3 >= 0) goto L_0x014e
            r21 = 4630122629401935872(0x4041800000000000, double:35.0)
            int r3 = (r1 > r21 ? 1 : (r1 == r21 ? 0 : -1))
            if (r3 <= 0) goto L_0x014e
            goto L_0x00bb
        L_0x014e:
            r21 = 4609434218613702656(0x3ff8000000000000, double:1.5)
            int r3 = (r4 > r21 ? 1 : (r4 == r21 ? 0 : -1))
            if (r3 >= 0) goto L_0x016a
            r3 = 4626322717216342016(0x4034000000000000, double:20.0)
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 <= 0) goto L_0x016a
            goto L_0x00bb
        L_0x015c:
            r40 = 4615063718147915776(0x400c000000000000, double:3.5)
            double r3 = r0.f13363R
            int r3 = (r3 > r21 ? 1 : (r3 == r21 ? 0 : -1))
            if (r3 < 0) goto L_0x00bb
            int r3 = (r1 > r25 ? 1 : (r1 == r25 ? 0 : -1))
            if (r3 <= 0) goto L_0x016a
            goto L_0x00bb
        L_0x016a:
            r4 = r9
        L_0x016b:
            java.lang.String r3 = r0.f13367V
            r3.getClass()
            java.lang.String r14 = "."
            r21 = r6
            java.lang.String r6 = "\\B"
            int r7 = r3.hashCode()
            switch(r7) {
                case -2130540331: goto L_0x028f;
                case -2114173141: goto L_0x0283;
                case -2100328351: goto L_0x0277;
                case -661558862: goto L_0x026b;
                case 67033: goto L_0x025f;
                case 67038: goto L_0x0253;
                case 72432: goto L_0x0247;
                case 72434: goto L_0x023b;
                case 73566: goto L_0x022d;
                case 77118: goto L_0x021f;
                case 81453: goto L_0x0211;
                case 82031: goto L_0x0203;
                case 82414: goto L_0x01f5;
                case 84199: goto L_0x01e8;
                case 2132216: goto L_0x01db;
                case 2251988: goto L_0x01ce;
                case 2525187: goto L_0x01c1;
                case 2597341: goto L_0x01b4;
                case 2614282: goto L_0x01a7;
                case 63061238: goto L_0x019a;
                case 69601061: goto L_0x018d;
                case 2098823340: goto L_0x0180;
                default: goto L_0x017d;
            }
        L_0x017d:
            r3 = -1
            goto L_0x029b
        L_0x0180:
            java.lang.String r7 = "GEONET"
            boolean r3 = r3.equals(r7)
            if (r3 != 0) goto L_0x0189
            goto L_0x017d
        L_0x0189:
            r3 = 21
            goto L_0x029b
        L_0x018d:
            java.lang.String r7 = "IGEPN"
            boolean r3 = r3.equals(r7)
            if (r3 != 0) goto L_0x0196
            goto L_0x017d
        L_0x0196:
            r3 = 20
            goto L_0x029b
        L_0x019a:
            java.lang.String r7 = "BDTIM"
            boolean r3 = r3.equals(r7)
            if (r3 != 0) goto L_0x01a3
            goto L_0x017d
        L_0x01a3:
            r3 = 19
            goto L_0x029b
        L_0x01a7:
            java.lang.String r7 = "USGS"
            boolean r3 = r3.equals(r7)
            if (r3 != 0) goto L_0x01b0
            goto L_0x017d
        L_0x01b0:
            r3 = 18
            goto L_0x029b
        L_0x01b4:
            java.lang.String r7 = "UASD"
            boolean r3 = r3.equals(r7)
            if (r3 != 0) goto L_0x01bd
            goto L_0x017d
        L_0x01bd:
            r3 = 17
            goto L_0x029b
        L_0x01c1:
            java.lang.String r7 = "RSPR"
            boolean r3 = r3.equals(r7)
            if (r3 != 0) goto L_0x01ca
            goto L_0x017d
        L_0x01ca:
            r3 = 16
            goto L_0x029b
        L_0x01ce:
            java.lang.String r7 = "INGV"
            boolean r3 = r3.equals(r7)
            if (r3 != 0) goto L_0x01d7
            goto L_0x017d
        L_0x01d7:
            r3 = 15
            goto L_0x029b
        L_0x01db:
            java.lang.String r7 = "EMSC"
            boolean r3 = r3.equals(r7)
            if (r3 != 0) goto L_0x01e4
            goto L_0x017d
        L_0x01e4:
            r3 = 14
            goto L_0x029b
        L_0x01e8:
            java.lang.String r7 = "UOA"
            boolean r3 = r3.equals(r7)
            if (r3 != 0) goto L_0x01f1
            goto L_0x017d
        L_0x01f1:
            r3 = 13
            goto L_0x029b
        L_0x01f5:
            java.lang.String r7 = "SSN"
            boolean r3 = r3.equals(r7)
            if (r3 != 0) goto L_0x01ff
            goto L_0x017d
        L_0x01ff:
            r3 = 12
            goto L_0x029b
        L_0x0203:
            java.lang.String r7 = "SGC"
            boolean r3 = r3.equals(r7)
            if (r3 != 0) goto L_0x020d
            goto L_0x017d
        L_0x020d:
            r3 = 11
            goto L_0x029b
        L_0x0211:
            java.lang.String r7 = "RSN"
            boolean r3 = r3.equals(r7)
            if (r3 != 0) goto L_0x021b
            goto L_0x017d
        L_0x021b:
            r3 = 10
            goto L_0x029b
        L_0x021f:
            java.lang.String r7 = "NCS"
            boolean r3 = r3.equals(r7)
            if (r3 != 0) goto L_0x0229
            goto L_0x017d
        L_0x0229:
            r3 = 9
            goto L_0x029b
        L_0x022d:
            java.lang.String r7 = "JMA"
            boolean r3 = r3.equals(r7)
            if (r3 != 0) goto L_0x0237
            goto L_0x017d
        L_0x0237:
            r3 = 8
            goto L_0x029b
        L_0x023b:
            java.lang.String r7 = "IGP"
            boolean r3 = r3.equals(r7)
            if (r3 != 0) goto L_0x0245
            goto L_0x017d
        L_0x0245:
            r3 = 7
            goto L_0x029b
        L_0x0247:
            java.lang.String r7 = "IGN"
            boolean r3 = r3.equals(r7)
            if (r3 != 0) goto L_0x0251
            goto L_0x017d
        L_0x0251:
            r3 = 6
            goto L_0x029b
        L_0x0253:
            java.lang.String r7 = "CSN"
            boolean r3 = r3.equals(r7)
            if (r3 != 0) goto L_0x025d
            goto L_0x017d
        L_0x025d:
            r3 = 5
            goto L_0x029b
        L_0x025f:
            java.lang.String r7 = "CSI"
            boolean r3 = r3.equals(r7)
            if (r3 != 0) goto L_0x0269
            goto L_0x017d
        L_0x0269:
            r3 = 4
            goto L_0x029b
        L_0x026b:
            java.lang.String r7 = "PHIVOLCS"
            boolean r3 = r3.equals(r7)
            if (r3 != 0) goto L_0x0275
            goto L_0x017d
        L_0x0275:
            r3 = 3
            goto L_0x029b
        L_0x0277:
            java.lang.String r7 = "Ineter"
            boolean r3 = r3.equals(r7)
            if (r3 != 0) goto L_0x0281
            goto L_0x017d
        L_0x0281:
            r3 = r10
            goto L_0x029b
        L_0x0283:
            java.lang.String r7 = "FUNVISIS"
            boolean r3 = r3.equals(r7)
            if (r3 != 0) goto L_0x028d
            goto L_0x017d
        L_0x028d:
            r3 = r9
            goto L_0x029b
        L_0x028f:
            java.lang.String r7 = "INPRES"
            boolean r3 = r3.equals(r7)
            if (r3 != 0) goto L_0x0299
            goto L_0x017d
        L_0x0299:
            r3 = r29
        L_0x029b:
            switch(r3) {
                case 0: goto L_0x0370;
                case 1: goto L_0x0367;
                case 2: goto L_0x035e;
                case 3: goto L_0x0354;
                case 4: goto L_0x034a;
                case 5: goto L_0x0340;
                case 6: goto L_0x0336;
                case 7: goto L_0x032c;
                case 8: goto L_0x0322;
                case 9: goto L_0x0317;
                case 10: goto L_0x030e;
                case 11: goto L_0x0305;
                case 12: goto L_0x02fc;
                case 13: goto L_0x02f3;
                case 14: goto L_0x02e7;
                case 15: goto L_0x02de;
                case 16: goto L_0x02d5;
                case 17: goto L_0x02cc;
                case 18: goto L_0x02c0;
                case 19: goto L_0x02b7;
                case 20: goto L_0x02ae;
                case 21: goto L_0x02a4;
                default: goto L_0x029e;
            }
        L_0x029e:
            java.lang.String r3 = ""
            r6 = r29
            goto L_0x0378
        L_0x02a4:
            java.lang.String r3 = r0.f13367V
            r6 = 32
            java.lang.String r7 = "action_geonet"
        L_0x02aa:
            r15 = r3
            r3 = r7
            goto L_0x0378
        L_0x02ae:
            java.lang.String r3 = r15.replaceAll(r6, r14)
            r6 = 34
            java.lang.String r7 = "action_igepn"
            goto L_0x02aa
        L_0x02b7:
            java.lang.String r3 = r15.replaceAll(r6, r14)
            r6 = 39
            java.lang.String r7 = "action_bdtim"
            goto L_0x02aa
        L_0x02c0:
            java.lang.String r3 = r15.replaceAll(r6, r14)
            java.lang.String r6 = "action_usgs"
            r15 = r3
            r3 = r6
            r6 = 20
            goto L_0x0378
        L_0x02cc:
            java.lang.String r3 = r15.replaceAll(r6, r14)
            r6 = 37
            java.lang.String r7 = "action_uasd"
            goto L_0x02aa
        L_0x02d5:
            java.lang.String r3 = r15.replaceAll(r6, r14)
            r6 = 38
            java.lang.String r7 = "action_rspr"
            goto L_0x02aa
        L_0x02de:
            java.lang.String r3 = r15.replaceAll(r6, r14)
            r6 = 22
            java.lang.String r7 = "action_ingv"
            goto L_0x02aa
        L_0x02e7:
            java.lang.String r3 = r15.replaceAll(r6, r14)
            java.lang.String r6 = "action_emsc"
            r15 = r3
            r3 = r6
            r6 = 21
            goto L_0x0378
        L_0x02f3:
            java.lang.String r3 = r15.replaceAll(r6, r14)
            r6 = 41
            java.lang.String r7 = "action_uoa"
            goto L_0x02aa
        L_0x02fc:
            java.lang.String r3 = r15.replaceAll(r6, r14)
            r6 = 27
            java.lang.String r7 = "action_ssn"
            goto L_0x02aa
        L_0x0305:
            java.lang.String r3 = r15.replaceAll(r6, r14)
            r6 = 28
            java.lang.String r7 = "action_sgc"
            goto L_0x02aa
        L_0x030e:
            java.lang.String r3 = r15.replaceAll(r6, r14)
            r6 = 29
            java.lang.String r7 = "action_rsn"
            goto L_0x02aa
        L_0x0317:
            java.lang.String r3 = r15.replaceAll(r6, r14)
            java.lang.String r6 = "action_ncs"
            r15 = r3
            r3 = r6
            r6 = 40
            goto L_0x0378
        L_0x0322:
            java.lang.String r3 = r15.replaceAll(r6, r14)
            r6 = 25
            java.lang.String r7 = "action_jma"
            goto L_0x02aa
        L_0x032c:
            java.lang.String r3 = r15.replaceAll(r6, r14)
            r6 = 36
            java.lang.String r7 = "action_igp"
            goto L_0x02aa
        L_0x0336:
            java.lang.String r3 = r15.replaceAll(r6, r14)
            r6 = 23
            java.lang.String r7 = "action_ign"
            goto L_0x02aa
        L_0x0340:
            java.lang.String r3 = r15.replaceAll(r6, r14)
            r6 = 30
            java.lang.String r7 = "action_csn"
            goto L_0x02aa
        L_0x034a:
            java.lang.String r3 = r15.replaceAll(r6, r14)
            r6 = 24
            java.lang.String r7 = "action_csi"
            goto L_0x02aa
        L_0x0354:
            java.lang.String r3 = r15.replaceAll(r6, r14)
            r6 = 35
            java.lang.String r7 = "action_phivolcs"
            goto L_0x02aa
        L_0x035e:
            java.lang.String r3 = r0.f13367V
            java.lang.String r6 = "action_ineter"
            r15 = r3
            r3 = r6
            r6 = 26
            goto L_0x0378
        L_0x0367:
            java.lang.String r3 = r0.f13367V
            java.lang.String r6 = "action_funvisis"
            r15 = r3
            r3 = r6
            r6 = 31
            goto L_0x0378
        L_0x0370:
            java.lang.String r3 = r0.f13367V
            r6 = 33
            java.lang.String r7 = "action_inpres"
            goto L_0x02aa
        L_0x0378:
            if (r4 == 0) goto L_0x08c7
            java.lang.String r4 = "notification"
            java.lang.Object r4 = r0.getSystemService(r4)
            android.app.NotificationManager r4 = (android.app.NotificationManager) r4
            r7 = 2131886825(0x7f1202e9, float:1.940824E38)
            java.lang.String r7 = r0.getString(r7)
            java.lang.String r14 = r0.f13367V
            r18 = 40
            java.lang.Object[] r12 = new java.lang.Object[r9]
            r12[r29] = r14
            java.lang.String r7 = java.lang.String.format(r7, r12)
            java.text.DecimalFormatSymbols r12 = new java.text.DecimalFormatSymbols
            java.util.Locale r14 = java.util.Locale.getDefault()
            r12.<init>(r14)
            r14 = 46
            r12.setDecimalSeparator(r14)
            r14 = 44
            r12.setGroupingSeparator(r14)
            java.text.DecimalFormat r14 = new java.text.DecimalFormat
            r14.<init>(r13, r12)
            double r12 = r0.f13364S
            int r23 = (r12 > r19 ? 1 : (r12 == r19 ? 0 : -1))
            if (r23 != 0) goto L_0x03cf
            java.lang.String r12 = r0.getString(r11)
            r24 = r6
            double r5 = r0.f13363R
            java.lang.String r5 = r14.format(r5)
            java.lang.String r6 = r0.f13366U
            java.lang.Object[] r13 = new java.lang.Object[r10]
            r13[r29] = r5
            r13[r9] = r6
            java.lang.String r5 = java.lang.String.format(r12, r13)
            r32 = r10
            r11 = 3
            goto L_0x03fa
        L_0x03cf:
            r24 = r6
            double r5 = r0.f13363R
            double r25 = r12 / r38
            r32 = r10
            double r10 = r5 - r25
            double r12 = r12 / r38
            double r5 = r5 + r12
            r12 = 2131886824(0x7f1202e8, float:1.9408238E38)
            java.lang.String r13 = r0.getString(r12)
            java.lang.String r10 = r14.format(r10)
            java.lang.String r5 = r14.format(r5)
            java.lang.String r6 = r0.f13366U
            r11 = 3
            java.lang.Object[] r12 = new java.lang.Object[r11]
            r12[r29] = r10
            r12[r9] = r5
            r12[r32] = r6
            java.lang.String r5 = java.lang.String.format(r13, r12)
        L_0x03fa:
            android.content.Intent r6 = new android.content.Intent
            java.lang.Class<com.finazzi.distquake.MainActivity> r10 = com.finazzi.distquake.MainActivity.class
            r6.<init>(r0, r10)
            r12 = 805306368(0x30000000, float:4.656613E-10)
            r6.setFlags(r12)
            java.lang.String r12 = "com.finazzi.distquake.official"
            r6.putExtra(r12, r9)
            java.lang.String r12 = "com.finazzi.distquake.official_provider"
            java.lang.String r13 = r0.f13367V
            r6.putExtra(r12, r13)
            java.lang.String r12 = "com.finazzi.distquake.official_lat"
            r13 = r9
            double r8 = r0.f13350E
            r6.putExtra(r12, r8)
            java.lang.String r8 = "com.finazzi.distquake.official_lon"
            double r11 = r0.f13351F
            r6.putExtra(r8, r11)
            java.lang.String r8 = "com.finazzi.distquake.official_date"
            java.lang.String r9 = r0.f13365T
            r6.putExtra(r8, r9)
            java.lang.String r8 = "com.finazzi.distquake.official_mag"
            double r11 = r0.f13363R
            r6.putExtra(r8, r11)
            r6.setAction(r3)
            androidx.core.app.w r3 = androidx.core.app.w.h(r0)
            r3.g(r10)
            r3.b(r6)
            int r6 = android.os.Build.VERSION.SDK_INT
            r8 = 31
            if (r6 < r8) goto L_0x044b
            r8 = 201326592(0xc000000, float:9.8607613E-32)
            r9 = r29
            android.app.PendingIntent r3 = r3.i(r9, r8)
            goto L_0x0453
        L_0x044b:
            r9 = r29
            r8 = 134217728(0x8000000, float:3.85186E-34)
            android.app.PendingIntent r3 = r3.i(r9, r8)
        L_0x0453:
            androidx.core.app.m$e r8 = new androidx.core.app.m$e
            r9 = 2131886148(0x7f120044, float:1.9406867E38)
            java.lang.String r9 = r0.getString(r9)
            r8.<init>(r0, r9)
            androidx.core.app.m$b r9 = new androidx.core.app.m$b
            r9.<init>()
            r0.f13377f0 = r9
            int r9 = (r1 > r19 ? 1 : (r1 == r19 ? 0 : -1))
            r42 = 4603772033682776338(0x3fe3e245d68a2112, double:0.621371192)
            java.lang.String r11 = "1"
            if (r9 <= 0) goto L_0x0562
            r12 = r13
            r9 = r14
            double r13 = r0.f13364S
            int r23 = (r13 > r19 ? 1 : (r13 == r19 ? 0 : -1))
            if (r23 != 0) goto L_0x04e8
            r23 = r12
            r12 = r35
            boolean r13 = r12.equals(r11)
            if (r13 == 0) goto L_0x04b6
            double r1 = r1 * r42
            r13 = 2131886826(0x7f1202ea, float:1.9408242E38)
            java.lang.String r13 = r0.getString(r13)
            r35 = r9
            r26 = r10
            double r9 = r0.f13363R
            r14 = r35
            java.lang.String r9 = r14.format(r9)
            java.lang.String r10 = r0.f13366U
            int r14 = (int) r1
            java.lang.Integer r14 = java.lang.Integer.valueOf(r14)
            r30 = r1
            r1 = 3
            java.lang.Object[] r2 = new java.lang.Object[r1]
            r29 = 0
            r2[r29] = r9
            r2[r23] = r10
            r2[r32] = r14
            java.lang.String r1 = java.lang.String.format(r13, r2)
            r35 = r3
            r44 = r4
            goto L_0x05c1
        L_0x04b6:
            r14 = r9
            r26 = r10
            r9 = 2131886827(0x7f1202eb, float:1.9408244E38)
            java.lang.String r9 = r0.getString(r9)
            r35 = r3
            r10 = r4
            double r3 = r0.f13363R
            java.lang.String r3 = r14.format(r3)
            java.lang.String r4 = r0.f13366U
            int r13 = (int) r1
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r30 = r3
            r14 = 3
            java.lang.Object[] r3 = new java.lang.Object[r14]
            r29 = 0
            r3[r29] = r30
            r3[r23] = r4
            r3[r32] = r13
            java.lang.String r3 = java.lang.String.format(r9, r3)
            r30 = r1
            r1 = r3
            r44 = r10
            goto L_0x05c1
        L_0x04e8:
            r26 = r10
            r23 = r12
            r12 = r35
            r35 = r3
            r10 = r4
            double r3 = r0.f13363R
            double r30 = r13 / r38
            r44 = r3
            double r3 = r44 - r30
            double r13 = r13 / r38
            double r13 = r44 + r13
            boolean r30 = r12.equals(r11)
            if (r30 == 0) goto L_0x0534
            double r1 = r1 * r42
            r44 = r10
            r10 = 2131886822(0x7f1202e6, float:1.9408234E38)
            java.lang.String r10 = r0.getString(r10)
            java.lang.String r3 = r9.format(r3)
            java.lang.String r4 = r9.format(r13)
            java.lang.String r9 = r0.f13366U
            int r13 = (int) r1
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r30 = r1
            r14 = 4
            java.lang.Object[] r1 = new java.lang.Object[r14]
            r29 = 0
            r1[r29] = r3
            r1[r23] = r4
            r1[r32] = r9
            r37 = 3
            r1[r37] = r13
            java.lang.String r1 = java.lang.String.format(r10, r1)
            goto L_0x05c1
        L_0x0534:
            r44 = r10
            r10 = 2131886823(0x7f1202e7, float:1.9408236E38)
            java.lang.String r10 = r0.getString(r10)
            java.lang.String r3 = r9.format(r3)
            java.lang.String r4 = r9.format(r13)
            java.lang.String r9 = r0.f13366U
            int r13 = (int) r1
            java.lang.Integer r13 = java.lang.Integer.valueOf(r13)
            r45 = r1
            r14 = 4
            java.lang.Object[] r1 = new java.lang.Object[r14]
            r29 = 0
            r1[r29] = r3
            r1[r23] = r4
            r1[r32] = r9
            r37 = 3
            r1[r37] = r13
            java.lang.String r1 = java.lang.String.format(r10, r1)
            goto L_0x0592
        L_0x0562:
            r45 = r1
            r44 = r4
            r26 = r10
            r23 = r13
            r9 = r14
            r12 = r35
            r35 = r3
            double r1 = r0.f13364S
            int r3 = (r1 > r19 ? 1 : (r1 == r19 ? 0 : -1))
            if (r3 != 0) goto L_0x0595
            r3 = 2131886828(0x7f1202ec, float:1.9408246E38)
            java.lang.String r1 = r0.getString(r3)
            double r2 = r0.f13363R
            java.lang.String r2 = r9.format(r2)
            java.lang.String r3 = r0.f13366U
            r10 = r32
            java.lang.Object[] r4 = new java.lang.Object[r10]
            r29 = 0
            r4[r29] = r2
            r4[r23] = r3
            java.lang.String r1 = java.lang.String.format(r1, r4)
        L_0x0592:
            r30 = r45
            goto L_0x05c1
        L_0x0595:
            double r3 = r0.f13363R
            double r13 = r1 / r38
            double r13 = r3 - r13
            double r1 = r1 / r38
            double r3 = r3 + r1
            r1 = 2131886824(0x7f1202e8, float:1.9408238E38)
            java.lang.String r1 = r0.getString(r1)
            java.lang.String r2 = r9.format(r13)
            java.lang.String r3 = r9.format(r3)
            java.lang.String r4 = r0.f13366U
            r14 = 3
            java.lang.Object[] r9 = new java.lang.Object[r14]
            r29 = 0
            r9[r29] = r2
            r9[r23] = r3
            r32 = 2
            r9[r32] = r4
            java.lang.String r1 = java.lang.String.format(r1, r9)
            goto L_0x0592
        L_0x05c1:
            androidx.core.app.m$b r2 = r0.f13377f0
            r2.j(r1)
            android.content.Context r1 = r0.getApplicationContext()
            android.content.res.Resources r1 = r1.getResources()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            int r2 = r1.heightPixels
            int r1 = r1.widthPixels
            int r1 = java.lang.Math.max(r2, r1)
            int r1 = r1 / 40
            android.graphics.Paint r2 = new android.graphics.Paint
            r2.<init>()
            android.graphics.Paint$Align r3 = android.graphics.Paint.Align.CENTER
            r2.setTextAlign(r3)
            float r4 = (float) r1
            r2.setTextSize(r4)
            r2.setTextAlign(r3)
            android.graphics.Typeface r3 = android.graphics.Typeface.DEFAULT_BOLD
            r2.setTypeface(r3)
            r13 = r23
            r2.setAntiAlias(r13)
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "M"
            r3.append(r4)
            double r9 = r0.f13363R
            r3.append(r9)
            java.lang.String r3 = r3.toString()
            android.graphics.Rect r4 = new android.graphics.Rect
            r4.<init>()
            int r9 = r3.length()
            r10 = 0
            r2.getTextBounds(r3, r10, r9, r4)
            int r9 = r4.width()
            r32 = 2
            int r9 = r9 * 2
            float r9 = (float) r9
            int r9 = java.lang.Math.round(r9)
            int r10 = r4.height()
            r28 = 4
            int r10 = r10 * 4
            float r10 = (float) r10
            int r10 = java.lang.Math.round(r10)
            android.graphics.Bitmap$Config r14 = android.graphics.Bitmap.Config.ARGB_8888
            android.graphics.Bitmap r9 = android.graphics.Bitmap.createBitmap(r9, r10, r14)
            android.graphics.Canvas r10 = new android.graphics.Canvas
            r10.<init>(r9)
            android.graphics.Paint r14 = new android.graphics.Paint
            r14.<init>()
            r13 = 255(0xff, float:3.57E-43)
            r14.setAlpha(r13)
            r13 = 0
            r10.drawBitmap(r9, r13, r13, r14)
            android.graphics.Paint r14 = new android.graphics.Paint
            r14.<init>()
            r13 = 1
            r14.setAntiAlias(r13)
            android.graphics.Paint$Style r13 = android.graphics.Paint.Style.FILL
            r14.setStyle(r13)
            r13 = -1
            r14.setColor(r13)
            r52 = r14
            double r13 = (double) r1
            r16 = 4599075939470750515(0x3fd3333333333333, double:0.3)
            double r13 = r13 * r16
            float r1 = (float) r13
            int r13 = r9.getWidth()
            r32 = 2
            int r13 = r13 / 2
            int r14 = r4.width()
            int r14 = r14 / 2
            int r13 = r13 - r14
            float r13 = (float) r13
            float r46 = r13 - r1
            int r13 = r9.getHeight()
            int r13 = r13 / 2
            int r14 = r4.height()
            int r14 = r14 / 2
            int r13 = r13 - r14
            float r13 = (float) r13
            float r47 = r13 - r1
            int r13 = r9.getWidth()
            int r13 = r13 / 2
            int r14 = r4.width()
            int r14 = r14 / 2
            int r13 = r13 + r14
            float r13 = (float) r13
            float r48 = r13 + r1
            int r13 = r9.getHeight()
            int r13 = r13 / 2
            int r14 = r4.height()
            int r14 = r14 / 2
            int r13 = r13 + r14
            float r13 = (float) r13
            float r49 = r13 + r1
            r51 = r1
            r50 = r1
            r45 = r10
            r45.drawRoundRect(r46, r47, r48, r49, r50, r51, r52)
            r1 = r52
            android.graphics.Paint$Style r10 = android.graphics.Paint.Style.STROKE
            r1.setStyle(r10)
            r10 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            r1.setColor(r10)
            r10 = 1077936128(0x40400000, float:3.0)
            r1.setStrokeWidth(r10)
            r13 = 1
            r1.setAntiAlias(r13)
            int r10 = r9.getWidth()
            r32 = 2
            int r10 = r10 / 2
            int r14 = r4.width()
            int r14 = r14 / 2
            int r10 = r10 - r14
            float r10 = (float) r10
            float r46 = r10 - r50
            int r10 = r9.getHeight()
            int r10 = r10 / 2
            int r14 = r4.height()
            int r14 = r14 / 2
            int r10 = r10 - r14
            float r10 = (float) r10
            float r47 = r10 - r50
            int r10 = r9.getWidth()
            int r10 = r10 / 2
            int r14 = r4.width()
            int r14 = r14 / 2
            int r10 = r10 + r14
            float r10 = (float) r10
            float r48 = r10 + r50
            int r10 = r9.getHeight()
            int r10 = r10 / 2
            int r14 = r4.height()
            int r14 = r14 / 2
            int r10 = r10 + r14
            float r10 = (float) r10
            float r49 = r10 + r50
            r51 = r50
            r45.drawRoundRect(r46, r47, r48, r49, r50, r51, r52)
            r1 = r45
            double r13 = r0.f13363R
            int r10 = (r13 > r38 ? 1 : (r13 == r38 ? 0 : -1))
            r16 = r4
            r4 = 200(0xc8, float:2.8E-43)
            if (r10 >= 0) goto L_0x0723
            r10 = 0
            int r4 = android.graphics.Color.rgb(r10, r4, r4)
            r2.setColor(r4)
            goto L_0x0753
        L_0x0723:
            r10 = 0
            int r17 = (r13 > r40 ? 1 : (r13 == r40 ? 0 : -1))
            if (r17 >= 0) goto L_0x0730
            int r4 = android.graphics.Color.rgb(r10, r4, r10)
            r2.setColor(r4)
            goto L_0x0753
        L_0x0730:
            int r17 = (r13 > r21 ? 1 : (r13 == r21 ? 0 : -1))
            if (r17 >= 0) goto L_0x0740
            r4 = 240(0xf0, float:3.36E-43)
            r13 = 190(0xbe, float:2.66E-43)
            int r4 = android.graphics.Color.rgb(r4, r13, r10)
            r2.setColor(r4)
            goto L_0x0753
        L_0x0740:
            int r13 = (r13 > r33 ? 1 : (r13 == r33 ? 0 : -1))
            if (r13 >= 0) goto L_0x074c
            int r4 = android.graphics.Color.rgb(r4, r10, r10)
            r2.setColor(r4)
            goto L_0x0753
        L_0x074c:
            int r4 = android.graphics.Color.rgb(r4, r10, r4)
            r2.setColor(r4)
        L_0x0753:
            int r4 = r9.getWidth()
            double r13 = (double) r4
            double r13 = r13 / r38
            float r4 = (float) r13
            int r10 = r9.getHeight()
            double r13 = (double) r10
            double r13 = r13 / r38
            int r10 = r16.height()
            r16 = r13
            double r13 = (double) r10
            double r13 = r13 / r38
            double r13 = r16 + r13
            float r10 = (float) r13
            r1.drawText(r3, r4, r10, r2)
            r1 = 2131231382(0x7f080296, float:1.8078843E38)
            r8.w(r1)
            r8.p(r9)
            r1 = 0
            r8.z(r1)
            r8.j(r7)
            r8.i(r5)
            r8.A(r5)
            r13 = 1
            r8.e(r13)
            r3 = r35
            r8.h(r3)
            r1 = 26
            if (r6 >= r1) goto L_0x07a3
            r32 = 2
            android.net.Uri r1 = android.media.RingtoneManager.getDefaultUri(r32)
            long[] r2 = r0.f13376e0
            r8.B(r2)
            r2 = 5
            r8.y(r1, r2)
        L_0x07a3:
            double r1 = r0.f13350E
            double r3 = r0.f13351F
            android.graphics.Bitmap r1 = r0.l0(r1, r3)
            if (r1 == 0) goto L_0x07b7
            androidx.core.app.m$b r2 = r0.f13377f0
            r2.i(r1)
            androidx.core.app.m$b r1 = r0.f13377f0
            r8.z(r1)
        L_0x07b7:
            if (r44 == 0) goto L_0x07df
            java.lang.String r1 = r26.getSimpleName()
            r10 = 0
            android.content.SharedPreferences r1 = r0.getSharedPreferences(r1, r10)
            android.content.SharedPreferences$Editor r1 = r1.edit()
            java.lang.String r2 = "recent_notification"
            long r3 = java.lang.System.currentTimeMillis()
            r1.putLong(r2, r3)
            r1.apply()
            java.lang.String r1 = "official_notification"
            android.app.Notification r2 = r8.b()
            r6 = r24
            r10 = r44
            r10.notify(r1, r6, r2)
        L_0x07df:
            if (r27 == 0) goto L_0x08c7
            int r1 = (r30 > r19 ? 1 : (r30 == r19 ? 0 : -1))
            if (r1 < 0) goto L_0x08c7
            double r1 = r0.f13363R
            r3 = r36
            double r3 = (double) r3
            int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r1 < 0) goto L_0x08c7
            boolean r1 = r12.equals(r11)
            if (r1 == 0) goto L_0x07fe
            double r30 = r30 * r42
            r1 = 2131886936(0x7f120358, float:1.9408465E38)
            java.lang.String r1 = r0.getString(r1)
            goto L_0x0805
        L_0x07fe:
            r1 = 2131886934(0x7f120356, float:1.940846E38)
            java.lang.String r1 = r0.getString(r1)
        L_0x0805:
            long r2 = java.lang.Math.round(r30)
            java.lang.String r2 = java.lang.Long.toString(r2)
            r3 = 2131886302(0x7f1200de, float:1.940718E38)
            java.lang.String r3 = r0.getString(r3)
            java.lang.String r4 = "hr"
            boolean r4 = r3.equals(r4)
            java.lang.String r5 = "%.1f"
            r6 = 2131886939(0x7f12035b, float:1.940847E38)
            if (r4 == 0) goto L_0x084e
            java.lang.String r3 = r0.getString(r6)
            java.util.Locale r4 = java.util.Locale.getDefault()
            double r6 = r0.f13363R
            java.lang.Double r6 = java.lang.Double.valueOf(r6)
            r13 = 1
            java.lang.Object[] r7 = new java.lang.Object[r13]
            r29 = 0
            r7[r29] = r6
            java.lang.String r4 = java.lang.String.format(r4, r5, r7)
            r14 = 4
            java.lang.Object[] r5 = new java.lang.Object[r14]
            r5[r29] = r15
            r5[r13] = r4
            r32 = 2
            r5[r32] = r2
            r37 = 3
            r5[r37] = r1
            java.lang.String r1 = java.lang.String.format(r3, r5)
            goto L_0x08af
        L_0x084e:
            java.lang.String r4 = "tr"
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0883
            java.lang.String r3 = r0.getString(r6)
            java.util.Locale r4 = java.util.Locale.getDefault()
            double r6 = r0.f13363R
            java.lang.Double r6 = java.lang.Double.valueOf(r6)
            r13 = 1
            java.lang.Object[] r7 = new java.lang.Object[r13]
            r29 = 0
            r7[r29] = r6
            java.lang.String r4 = java.lang.String.format(r4, r5, r7)
            r14 = 4
            java.lang.Object[] r5 = new java.lang.Object[r14]
            r5[r29] = r2
            r5[r13] = r1
            r32 = 2
            r5[r32] = r15
            r37 = 3
            r5[r37] = r4
            java.lang.String r1 = java.lang.String.format(r3, r5)
            goto L_0x08af
        L_0x0883:
            r13 = 1
            r29 = 0
            java.lang.String r3 = r0.getString(r6)
            java.util.Locale r4 = java.util.Locale.getDefault()
            double r6 = r0.f13363R
            java.lang.Double r6 = java.lang.Double.valueOf(r6)
            java.lang.Object[] r7 = new java.lang.Object[r13]
            r7[r29] = r6
            java.lang.String r4 = java.lang.String.format(r4, r5, r7)
            r14 = 4
            java.lang.Object[] r5 = new java.lang.Object[r14]
            r5[r29] = r4
            r5[r13] = r15
            r32 = 2
            r5[r32] = r2
            r37 = 3
            r5[r37] = r1
            java.lang.String r1 = java.lang.String.format(r3, r5)
        L_0x08af:
            android.speech.tts.TextToSpeech r2 = new android.speech.tts.TextToSpeech
            android.content.Context r3 = r0.getApplicationContext()
            u2.d3 r4 = new u2.d3
            r4.<init>(r0, r1)
            r2.<init>(r3, r4)
            r0.f13378g0 = r2
            com.finazzi.distquake.MyFirebaseMessagingService$b r1 = new com.finazzi.distquake.MyFirebaseMessagingService$b
            r1.<init>()
            r2.setOnUtteranceProgressListener(r1)
        L_0x08c7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.finazzi.distquake.MyFirebaseMessagingService.M():void");
    }

    private boolean j0() {
        boolean z7;
        int i8 = Build.VERSION.SDK_INT;
        if (i8 < 31 ? i8 < 29 ? androidx.core.content.a.checkSelfPermission(getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") == 0 : androidx.core.content.a.checkSelfPermission(getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") == 0 && androidx.core.content.a.checkSelfPermission(getApplicationContext(), "android.permission.ACCESS_BACKGROUND_LOCATION") == 0 : androidx.core.content.a.checkSelfPermission(getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") == 0 && androidx.core.content.a.checkSelfPermission(getApplicationContext(), "android.permission.ACCESS_COARSE_LOCATION") == 0 && androidx.core.content.a.checkSelfPermission(getApplicationContext(), "android.permission.ACCESS_BACKGROUND_LOCATION") == 0) {
            z7 = true;
        } else {
            z7 = false;
        }
        if (!((PowerManager) getSystemService("power")).isIgnoringBatteryOptimizations(getApplicationContext().getPackageName())) {
            return false;
        }
        return z7;
    }

    private void k0() {
        this.f13380s.execute(new Context[]{this});
    }

    private Bitmap l0(double d8, double d9) {
        int i8;
        double d10;
        if (d8 >= -85.0d && d8 <= 85.0d) {
            int i9 = (d8 > 60.0d ? 1 : (d8 == 60.0d ? 0 : -1));
            if (i9 > 0) {
                i8 = 2131231264;
            } else if (d8 < -60.0d) {
                i8 = 2131231258;
            } else {
                i8 = 2131231259;
            }
            try {
                Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), i8);
                if (decodeResource != null) {
                    Bitmap copy = decodeResource.copy(Bitmap.Config.ARGB_8888, true);
                    double width = (double) copy.getWidth();
                    double height = (double) copy.getHeight();
                    double d11 = (((d9 / 180.0d) + 1.0d) / 2.0d) * width;
                    if (i9 > 0) {
                        d10 = height - ((Math.log(Math.tan(((d8 + 90.0d) * 3.141592653589793d) / 360.0d)) / 3.141592653589793d) * height);
                    } else if (d8 < -60.0d) {
                        d10 = -((Math.log(Math.tan(((d8 + 90.0d) * 3.141592653589793d) / 360.0d)) / 3.141592653589793d) * height);
                    } else {
                        d10 = ((width / 2.0d) - (((Math.log(Math.tan(((d8 + 90.0d) * 3.141592653589793d) / 360.0d)) / 3.141592653589793d) * width) / 2.0d)) - (width / 4.0d);
                    }
                    Paint paint = new Paint();
                    paint.setColor(-65536);
                    paint.setStrokeWidth(3.0f);
                    Bitmap createBitmap = Bitmap.createBitmap((int) width, (int) height, decodeResource.getConfig());
                    Canvas canvas = new Canvas(createBitmap);
                    canvas.drawBitmap(copy, new Matrix(), (Paint) null);
                    float f8 = (float) d11;
                    Paint paint2 = paint;
                    canvas.drawLine(f8, BitmapDescriptorFactory.HUE_RED, f8, (float) canvas.getHeight(), paint2);
                    float f9 = (float) d10;
                    canvas.drawLine(BitmapDescriptorFactory.HUE_RED, f9, (float) canvas.getWidth(), f9, paint2);
                    return createBitmap;
                }
            } catch (OutOfMemoryError unused) {
            }
        }
        return null;
    }

    private float[] m0() {
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.class.getSimpleName(), 0);
        return new float[]{sharedPreferences.getFloat("current_latitude", BitmapDescriptorFactory.HUE_RED), sharedPreferences.getFloat("current_longitude", BitmapDescriptorFactory.HUE_RED), sharedPreferences.getFloat("current_accuracy", -1.0f)};
    }

    private double n0(double d8, double d9, double d10, double d11) {
        double d12 = (d8 / 360.0d) * 2.0d * 3.141592653589793d;
        double d13 = (d10 / 360.0d) * 2.0d * 3.141592653589793d;
        double d14 = (((d11 / 360.0d) * 2.0d) * 3.141592653589793d) - (((d9 / 360.0d) * 2.0d) * 3.141592653589793d);
        double d15 = (((-Math.atan2((Math.cos(d12) * Math.sin(d13)) - ((Math.sin(d12) * Math.cos(d13)) * Math.cos(d14)), Math.sin(d14) * Math.cos(d13))) / 6.283185307179586d) * 360.0d) + 90.0d;
        if (d15 < 0.0d) {
            return d15 + 360.0d;
        }
        return d15;
    }

    private String o0(double d8) {
        if (d8 <= 22.5d || d8 > 337.5d) {
            return "N";
        }
        if (d8 <= 67.5d) {
            return "NE";
        }
        if (d8 <= 112.5d) {
            return "E";
        }
        if (d8 <= 157.5d) {
            return "SE";
        }
        if (d8 <= 202.5d) {
            return "S";
        }
        if (d8 <= 247.5d) {
            return "SW";
        }
        if (d8 <= 292.5d) {
            return "W";
        }
        return "NW";
    }

    private double p0(double d8, double d9, double d10, double d11) {
        double pow = Math.pow(Math.sin(((((d8 - d10) / 360.0d) * 2.0d) * 3.141592653589793d) / 2.0d), 2.0d) + (Math.cos((d8 / 360.0d) * 2.0d * 3.141592653589793d) * Math.cos((d10 / 360.0d) * 2.0d * 3.141592653589793d) * Math.pow(Math.sin(((((d9 - d11) / 360.0d) * 2.0d) * 3.141592653589793d) / 2.0d), 2.0d));
        return Math.atan2(Math.sqrt(pow), Math.sqrt(1.0d - pow)) * 2.0d * 6371.0d;
    }

    private boolean q0() {
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

    private boolean s0() {
        boolean z7;
        boolean z8;
        boolean z9 = false;
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.class.getSimpleName(), 0);
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
        if (currentTimeMillis < 345600.0d) {
            z9 = true;
        }
        return z10 & z9;
    }

    private Bitmap t0(int i8, double d8, double d9) {
        int i9;
        double d10;
        if (d8 >= -85.0d && d8 <= 85.0d) {
            int i10 = (d8 > 60.0d ? 1 : (d8 == 60.0d ? 0 : -1));
            if (i10 > 0) {
                i9 = 2131231264;
            } else if (d8 < -60.0d) {
                i9 = 2131231258;
            } else {
                i9 = 2131231259;
            }
            try {
                Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), i9);
                if (decodeResource != null) {
                    Bitmap.Config config = Bitmap.Config.ARGB_8888;
                    Bitmap copy = decodeResource.copy(config, true);
                    double width = (double) copy.getWidth();
                    double height = (double) copy.getHeight();
                    double d11 = (((d9 / 180.0d) + 1.0d) / 2.0d) * width;
                    if (i10 > 0) {
                        d10 = height - ((Math.log(Math.tan(((d8 + 90.0d) * 3.141592653589793d) / 360.0d)) / 3.141592653589793d) * height);
                    } else if (d8 < -60.0d) {
                        d10 = -((Math.log(Math.tan(((d8 + 90.0d) * 3.141592653589793d) / 360.0d)) / 3.141592653589793d) * height);
                    } else {
                        d10 = ((width / 2.0d) - (((Math.log(Math.tan(((d8 + 90.0d) * 3.141592653589793d) / 360.0d)) / 3.141592653589793d) * width) / 2.0d)) - (width / 4.0d);
                    }
                    Bitmap decodeResource2 = BitmapFactory.decodeResource(getResources(), i8);
                    Bitmap copy2 = decodeResource2.copy(config, true);
                    float width2 = (float) (d11 - (((double) decodeResource2.getWidth()) * 0.5d));
                    float height2 = (float) (d10 - (((double) decodeResource2.getHeight()) * 0.5d));
                    Bitmap createBitmap = Bitmap.createBitmap((int) width, (int) height, decodeResource.getConfig());
                    Canvas canvas = new Canvas(createBitmap);
                    canvas.drawBitmap(copy, new Matrix(), (Paint) null);
                    canvas.drawBitmap(copy2, width2, height2, (Paint) null);
                    return createBitmap;
                }
            } catch (OutOfMemoryError unused) {
            }
        }
        return null;
    }

    private void u0(String str) {
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.class.getSimpleName(), 0);
        new i(this, sharedPreferences.getString("android_id_eqn", "0"), str, sharedPreferences.getFloat("current_latitude", BitmapDescriptorFactory.HUE_RED), sharedPreferences.getFloat("current_longitude", BitmapDescriptorFactory.HUE_RED), (a) null).execute(new Context[]{this});
    }

    private void v0(String str, double d8, String str2, long j8, double d9, double d10, double d11, int i8, int i9, String str3) {
        SharedPreferences sharedPreferences;
        double d12;
        SharedPreferences sharedPreferences2;
        int i10;
        String str4;
        long j9 = j8;
        LayoutInflater layoutInflater = (LayoutInflater) getSystemService("layout_inflater");
        SharedPreferences sharedPreferences3 = getSharedPreferences(MainActivity.class.getSimpleName(), 0);
        SharedPreferences b8 = androidx.preference.g.b(this);
        String string = b8.getString("eqn_system_of_units", "0");
        if (layoutInflater != null) {
            View inflate = layoutInflater.inflate(C2030R.layout.alertdialog_layout, (ViewGroup) null);
            f13340i0 = new C0767c.a(this, 2131952296).n(C2030R.string.main_stopalarm, (DialogInterface.OnClickListener) null).i(C2030R.string.main_exit, (DialogInterface.OnClickListener) null).t(inflate).e(layoutInflater.inflate(C2030R.layout.alertdialog_title, (ViewGroup) null)).k(new C1785f3(this)).a();
            int i11 = (int) (((double) getResources().getDisplayMetrics().widthPixels) * 0.9d);
            int i12 = (int) (((double) getResources().getDisplayMetrics().heightPixels) * 0.9d);
            Window window = f13340i0.getWindow();
            if (window != null) {
                window.setLayout(i11, i12);
            }
            if (d8 != -1.0d) {
                DecimalFormatSymbols instance = DecimalFormatSymbols.getInstance();
                instance.setDecimalSeparator('.');
                DecimalFormat decimalFormat = new DecimalFormat("0.0", instance);
                if (string.equalsIgnoreCase("0")) {
                    sharedPreferences2 = sharedPreferences3;
                    i10 = 0;
                    sharedPreferences = b8;
                    str4 = String.format(getString(C2030R.string.main_detected), new Object[]{decimalFormat.format(this.f13354I), this.f13362Q, Integer.valueOf((int) Math.round(d8)), str2});
                    d12 = d8;
                } else {
                    sharedPreferences2 = sharedPreferences3;
                    i10 = 0;
                    sharedPreferences = b8;
                    d12 = 0.621371192d * d8;
                    str4 = String.format(getString(C2030R.string.main_detected_imperial), new Object[]{decimalFormat.format(this.f13354I), this.f13362Q, Integer.valueOf((int) Math.round(d12)), str2});
                }
                ((TextView) inflate.findViewById(C2030R.id.textView1)).setText(str4);
                TextView textView = (TextView) inflate.findViewById(C2030R.id.textView3);
                textView.setTypeface(Typeface.DEFAULT_BOLD);
                if (d10 < 1.5d) {
                    textView.setText(getString(C2030R.string.alert_intensity_no_shaking));
                    textView.setTextColor(-7829368);
                } else if (d10 < 3.0d) {
                    textView.setText(getString(C2030R.string.alert_intensity_mild));
                    textView.setTextColor(Color.rgb(38, 100, 38));
                } else if (d10 < 4.5d) {
                    textView.setText(getString(C2030R.string.alert_intensity_moderate));
                    textView.setTextColor(Color.rgb(255, 140, i10));
                } else {
                    textView.setText(getString(C2030R.string.alert_intensity_strong));
                    textView.setTextColor(-65536);
                }
            } else {
                sharedPreferences2 = sharedPreferences3;
                sharedPreferences = b8;
                d12 = d8;
            }
            int i13 = (j9 > 0 ? 1 : (j9 == 0 ? 0 : -1));
            if (i13 > 0 && j9 < 120) {
                int i14 = (int) j9;
                String quantityString = getResources().getQuantityString(C2030R.plurals.alert_wave, i14, new Object[]{Integer.valueOf(i14)});
                TextView textView2 = (TextView) inflate.findViewById(C2030R.id.textView2);
                textView2.setVisibility(0);
                textView2.setText(quantityString);
                textView2.setTypeface(Typeface.DEFAULT_BOLD);
                if (j9 > 15) {
                    textView2.setTextColor(Color.rgb(255, 140, 0));
                } else if (j9 > 5) {
                    textView2.setTextColor(Color.rgb(255, 100, 0));
                } else {
                    textView2.setTextColor(Color.rgb(255, 0, 0));
                }
            }
            MapView mapView = (MapView) inflate.findViewById(C2030R.id.map);
            Bundle bundle = new Bundle();
            bundle.putInt("test", 1);
            mapView.onCreate(bundle);
            mapView.onStart();
            mapView.onResume();
            mapView.getMapAsync(this);
            double d13 = d12;
            f13340i0.setOnShowListener(new S2(this, sharedPreferences2, i8, i9, str3, sharedPreferences, d10, j9, string, d13));
            f13340i0.setOnDismissListener(new T2(sharedPreferences2));
            if (f13340i0.getWindow() != null) {
                if (Build.VERSION.SDK_INT >= 26) {
                    f13340i0.getWindow().setType(2038);
                } else {
                    f13340i0.getWindow().setType(2003);
                }
                f13340i0.setCanceledOnTouchOutside(true);
                f13340i0.getWindow().addFlags(6815872);
                f13340i0.show();
                if (i13 > 0 && j8 < 120) {
                    CountDownTimer countDownTimer = f13342k0;
                    if (countDownTimer != null) {
                        countDownTimer.cancel();
                    }
                    f13342k0 = new d(1000 * j8, 1000).start();
                }
                CountDownTimer countDownTimer2 = f13341j0;
                if (countDownTimer2 != null) {
                    countDownTimer2.cancel();
                }
                f13341j0 = new e(120000, 100, d9).start();
            }
        }
    }

    public static /* synthetic */ void w(MyFirebaseMessagingService myFirebaseMessagingService, String str, int i8) {
        if (i8 != -1) {
            String string = myFirebaseMessagingService.getString(C2030R.string.current_language);
            if (string.equals("eng")) {
                myFirebaseMessagingService.f13378g0.setLanguage(Locale.ENGLISH);
            }
            if (string.equals("ita")) {
                myFirebaseMessagingService.f13378g0.setLanguage(Locale.ITALIAN);
            }
            if (string.equals("es")) {
                myFirebaseMessagingService.f13378g0.setLanguage(new Locale("es"));
            }
            if (string.equals("tr")) {
                myFirebaseMessagingService.f13378g0.setLanguage(new Locale("tr"));
            }
            if (string.equals("el")) {
                myFirebaseMessagingService.f13378g0.setLanguage(new Locale("el"));
            }
            if (string.equals("fr")) {
                myFirebaseMessagingService.f13378g0.setLanguage(new Locale("fr"));
            }
            if (string.equals("in")) {
                myFirebaseMessagingService.f13378g0.setLanguage(new Locale("in"));
            }
            if (string.equals("hr")) {
                myFirebaseMessagingService.f13378g0.setLanguage(new Locale("hr"));
            }
            if (string.equals("ar")) {
                myFirebaseMessagingService.f13378g0.setLanguage(new Locale("ar"));
            }
            myFirebaseMessagingService.f13378g0.setSpeechRate(1.0f);
            myFirebaseMessagingService.f13378g0.speak(str, 0, (Bundle) null, "tts");
            return;
        }
        myFirebaseMessagingService.getClass();
    }

    private void w0() {
        new h(this, (a) null).execute(new Context[]{this});
    }

    public static /* synthetic */ void x(SharedPreferences sharedPreferences, DialogInterface dialogInterface) {
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putBoolean("alert_dialog_showing", false);
        edit.apply();
    }

    /* access modifiers changed from: private */
    public void x0() {
        this.f13381t.execute(new Context[]{this});
    }

    public static /* synthetic */ void y(MyFirebaseMessagingService myFirebaseMessagingService, String str, int i8) {
        if (i8 != -1) {
            String string = myFirebaseMessagingService.getString(C2030R.string.current_language);
            if (string.equals("eng")) {
                myFirebaseMessagingService.f13378g0.setLanguage(Locale.ENGLISH);
            }
            if (string.equals("ita")) {
                myFirebaseMessagingService.f13378g0.setLanguage(Locale.ITALIAN);
            }
            if (string.equals("es")) {
                myFirebaseMessagingService.f13378g0.setLanguage(new Locale("es"));
            }
            if (string.equals("tr")) {
                myFirebaseMessagingService.f13378g0.setLanguage(new Locale("tr"));
            }
            if (string.equals("el")) {
                myFirebaseMessagingService.f13378g0.setLanguage(new Locale("el"));
            }
            if (string.equals("fr")) {
                myFirebaseMessagingService.f13378g0.setLanguage(new Locale("fr"));
            }
            if (string.equals("in")) {
                myFirebaseMessagingService.f13378g0.setLanguage(new Locale("in"));
            }
            if (string.equals("hr")) {
                myFirebaseMessagingService.f13378g0.setLanguage(new Locale("hr"));
            }
            if (string.equals("ar")) {
                myFirebaseMessagingService.f13378g0.setLanguage(new Locale("ar"));
            }
            myFirebaseMessagingService.f13378g0.setSpeechRate(1.0f);
            myFirebaseMessagingService.f13378g0.speak(str, 0, (Bundle) null, "tts");
            return;
        }
        myFirebaseMessagingService.getClass();
    }

    private void y0() {
        SharedPreferences.Editor edit = getSharedPreferences(MainActivity.class.getSimpleName(), 0).edit();
        edit.putLong("recent_turnonscreen", System.currentTimeMillis());
        edit.apply();
        PowerManager powerManager = (PowerManager) getSystemService("power");
        if (powerManager != null) {
            PowerManager.WakeLock newWakeLock = powerManager.newWakeLock(268435466, "eqn:tag");
            this.f13379h0 = newWakeLock;
            newWakeLock.acquire(DeviceOrientationRequest.OUTPUT_PERIOD_DEFAULT);
        }
    }

    public static /* synthetic */ void z(MyFirebaseMessagingService myFirebaseMessagingService, View view) {
        myFirebaseMessagingService.getClass();
        Intent intent = new Intent();
        intent.setAction("com.finazzi.distquake.stopalarm");
        intent.setPackage("com.finazzi.distquake");
        myFirebaseMessagingService.sendBroadcast(intent);
    }

    public void onMapReady(GoogleMap googleMap) {
        f13343l0 = googleMap;
        LatLng latLng = new LatLng(this.f13352G, this.f13353H);
        f13343l0.getUiSettings().setMapToolbarEnabled(false);
        f13343l0.setMapType(1);
        f13343l0.setMapColorScheme(2);
        f13343l0.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 6.0f));
        if (androidx.core.content.a.checkSelfPermission(getApplicationContext(), "android.permission.ACCESS_FINE_LOCATION") == 0) {
            f13343l0.setMyLocationEnabled(true);
            LocationServices.getFusedLocationProviderClient((Context) this).getLastLocation().addOnSuccessListener(new X2(latLng));
        }
        MarkerOptions markerOptions = new MarkerOptions();
        markerOptions.position(latLng);
        markerOptions.anchor(0.5f, 0.5f);
        double d8 = this.f13354I;
        if (d8 < 3.0d) {
            markerOptions.icon(BitmapDescriptorFactory.fromResource(2131231367));
        } else if (d8 < 5.0d) {
            markerOptions.icon(BitmapDescriptorFactory.fromResource(2131231363));
        } else {
            markerOptions.icon(BitmapDescriptorFactory.fromResource(2131231361));
        }
        f13345n0 = f13343l0.addMarker(markerOptions);
        UiSettings uiSettings = f13343l0.getUiSettings();
        uiSettings.setMyLocationButtonEnabled(false);
        uiSettings.setZoomControlsEnabled(false);
        uiSettings.setZoomGesturesEnabled(true);
        uiSettings.setAllGesturesEnabled(true);
        uiSettings.setScrollGesturesEnabled(true);
    }

    public void p(U u7) {
        String str;
        String str2;
        super.p(u7);
        this.f13383v = new C(getApplicationContext());
        Map data = u7.getData();
        if (!data.isEmpty() && (str = (String) data.get("type")) != null) {
            if (str.equalsIgnoreCase("eqn")) {
                try {
                    this.f13352G = Double.parseDouble((String) data.get("latitude"));
                    this.f13353H = Double.parseDouble((String) data.get("longitude"));
                    this.f13355J = Integer.parseInt((String) data.get("counter"));
                    this.f13361P = (String) data.get("datetime");
                    this.f13368W = Float.parseFloat((String) data.get("wave_speed"));
                    this.f13369X = Float.parseFloat((String) data.get("delay"));
                    this.f13370Y = Integer.parseInt((String) data.get("intensity"));
                    this.f13356K = Integer.parseInt((String) data.get("test"));
                    this.f13371Z = Float.parseFloat((String) data.get("peak"));
                    this.f13362Q = (String) data.get("location");
                    this.f13357L = Integer.parseInt((String) data.get("pos"));
                    this.f13358M = Integer.parseInt((String) data.get("code"));
                    this.f13359N = Integer.parseInt((String) data.get("upd"));
                    this.f13354I = Double.parseDouble((String) data.get("mag"));
                    I();
                } catch (NumberFormatException e8) {
                    if (e8.getMessage() != null) {
                        Log.d("EQN", e8.getMessage());
                    }
                }
            }
            if (str.equalsIgnoreCase("manual")) {
                try {
                    this.f13348C = Double.parseDouble((String) data.get("latitude"));
                    this.f13349D = Double.parseDouble((String) data.get("longitude"));
                    this.f13366U = (String) data.get("place");
                    L();
                } catch (NumberFormatException e9) {
                    if (e9.getMessage() != null) {
                        Log.d("EQN", e9.getMessage());
                    }
                }
            }
            if (str.equalsIgnoreCase("official")) {
                try {
                    String string = androidx.preference.g.b(this).getString("eqn_system_of_units", "0");
                    this.f13350E = Double.parseDouble((String) data.get("latitude"));
                    this.f13351F = Double.parseDouble((String) data.get("longitude"));
                    this.f13363R = Double.parseDouble((String) data.get("magnitude"));
                    this.f13364S = Double.parseDouble((String) data.get("magnitude_range"));
                    this.f13365T = (String) data.get("data");
                    this.f13366U = (String) data.get("place");
                    this.f13367V = (String) data.get("provider");
                    if (string.equals("1")) {
                        Pattern compile = Pattern.compile("([0-9]*\\.?[0-9]+)\\s*((KM)|(km)|(Km))");
                        String str3 = this.f13366U;
                        boolean z7 = true;
                        while (z7) {
                            Matcher matcher = compile.matcher(str3);
                            if (matcher.find()) {
                                if (matcher.groupCount() >= 2) {
                                    String group = matcher.group(1);
                                    try {
                                        str3 = str3.replaceFirst(group + "\\s*" + matcher.group(2), ((int) (((double) Integer.parseInt(group)) * 0.621371192d)) + " mi");
                                    } catch (NumberFormatException unused) {
                                    }
                                }
                            }
                            z7 = false;
                        }
                        this.f13366U = str3;
                    }
                    M();
                } catch (NumberFormatException e10) {
                    if (e10.getMessage() != null) {
                        Log.d("EQN", e10.getMessage());
                    }
                }
            }
            if (str.equalsIgnoreCase("chat_public")) {
                String str4 = (String) data.get("postfix");
                if (str4.equalsIgnoreCase("_ita_gen")) {
                    str2 = "chat_public_ita";
                } else {
                    str2 = null;
                }
                if (str4.equalsIgnoreCase("_es_gen")) {
                    str2 = "chat_public_es";
                }
                if (str4.equalsIgnoreCase("_eng_gen")) {
                    str2 = "chat_public_eng";
                }
                if (str4.equalsIgnoreCase("_fr_gen")) {
                    str2 = "chat_public_fr";
                }
                if (str4.equalsIgnoreCase("_el_gen")) {
                    str2 = "chat_public_el";
                }
                if (str4.equalsIgnoreCase("_tr_gen")) {
                    str2 = "chat_public_tr";
                }
                if (str4.equalsIgnoreCase("_in_gen")) {
                    str2 = "chat_public_in";
                }
                if (str4.equalsIgnoreCase("_tag_gen")) {
                    str2 = "chat_public_tag";
                }
                if (str4.equalsIgnoreCase("_jp_gen")) {
                    str2 = "chat_public_jp";
                }
                if (str4.equalsIgnoreCase("_pt_gen")) {
                    str2 = "chat_public_pt";
                }
                if (str4.equalsIgnoreCase("_blk_gen")) {
                    str2 = "chat_public_blk";
                }
                if (str4.equalsIgnoreCase("_hu_gen")) {
                    str2 = "chat_public_hu";
                }
                if (str4.equalsIgnoreCase("_ar_gen")) {
                    str2 = "chat_public_ar";
                }
                if (str4.equalsIgnoreCase("_ro_gen")) {
                    str2 = "chat_public_ro";
                }
                if (str4.equalsIgnoreCase("_th_gen")) {
                    str2 = "chat_public_th";
                }
                if (str4.equalsIgnoreCase("_my_gen")) {
                    str2 = "chat_public_my";
                }
                if (str4.equalsIgnoreCase("_mod_gen")) {
                    str2 = "chat_public_mod";
                }
                String str5 = (String) data.get("nick");
                int parseInt = Integer.parseInt((String) data.get("user_code"));
                int parseInt2 = Integer.parseInt((String) data.get("new_id"));
                int parseInt3 = Integer.parseInt((String) data.get("msg_code"));
                this.f13380s = new f(getSharedPreferences(MainActivity.class.getSimpleName(), 0).getInt("chat_user_code", 0), str2, parseInt2, parseInt, str5, new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(new Date()), (String) data.get("msg"), Integer.parseInt((String) data.get("moderator")), Integer.parseInt((String) data.get("country")), Integer.parseInt((String) data.get("pro")), parseInt3);
                k0();
            }
            if (str.equalsIgnoreCase("chat_personal")) {
                this.f13346A = Integer.parseInt((String) data.get("user_code_from"));
                this.f13347B = Integer.parseInt((String) data.get("user_code_to"));
                this.f13384w = (String) data.get("user_nick_from");
                this.f13385x = (String) data.get("user_nick_to");
                this.f13387z = (String) data.get("message");
                this.f13386y = new SimpleDateFormat("yyyy-MM-dd HH:mm", Locale.getDefault()).format(new Date());
                this.f13383v = new C(getApplicationContext());
                w0();
            }
            if (str.equalsIgnoreCase("friendship")) {
                this.f13373b0 = (String) data.get("nick_from");
                this.f13374c0 = (String) data.get("friendship_type");
                J();
            }
        }
    }

    public void r(String str) {
        super.r(str);
        SharedPreferences.Editor edit = getSharedPreferences(MainActivity.class.getSimpleName(), 0).edit();
        if (str.equalsIgnoreCase(RequestConfiguration.MAX_AD_CONTENT_RATING_UNSPECIFIED)) {
            edit.putBoolean("FCM_refresh", true);
            edit.apply();
        } else if (q0()) {
            edit.putBoolean("FCM_refresh", false);
            edit.apply();
            u0(str);
        } else {
            edit.putBoolean("FCM_refresh", true);
            edit.apply();
        }
    }

    public boolean r0() {
        if (((KeyguardManager) getSystemService("keyguard")).isKeyguardLocked()) {
            return true;
        }
        return !((PowerManager) getSystemService("power")).isInteractive();
    }
}
