package com.mbridge.msdk.foundation.same.report.b;

import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.text.format.Formatter;
import android.util.Log;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.c.g;
import com.mbridge.msdk.c.i;
import com.mbridge.msdk.foundation.a.a.a;
import com.mbridge.msdk.foundation.same.b.c;
import com.mbridge.msdk.foundation.same.b.e;
import com.mbridge.msdk.foundation.same.report.f;
import com.mbridge.msdk.foundation.same.report.h;
import com.mbridge.msdk.playercommon.exoplayer2.trackselection.AdaptiveTrackSelection;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.lang.Thread;
import java.lang.ref.WeakReference;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;

public class d implements Thread.UncaughtExceptionHandler {

    /* renamed from: b  reason: collision with root package name */
    private static volatile d f9435b;

    /* renamed from: a  reason: collision with root package name */
    Handler f9436a = new Handler() {
        public final void handleMessage(Message message) {
            Context context;
            HashMap hashMap;
            super.handleMessage(message);
            if (message.what == 101 && (context = (Context) d.this.f9437c.get()) != null) {
                Object obj = message.obj;
                if ((obj instanceof HashMap) && (hashMap = (HashMap) obj) != null) {
                    new h(context).a((String) hashMap.get("crashinfo"), (File) hashMap.get("file"));
                }
            }
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final WeakReference<Context> f9437c;

    /* renamed from: d  reason: collision with root package name */
    private Throwable f9438d;

    /* renamed from: e  reason: collision with root package name */
    private Thread.UncaughtExceptionHandler f9439e;

    private d(Context context) {
        this.f9437c = new WeakReference<>(context);
    }

    private static String b(Context context) {
        try {
            return context.getApplicationContext().getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e5) {
            Log.e("", e5.getMessage());
            return "";
        }
    }

    private HashMap<String, Object> c() {
        HashMap<String, Object> hashMap = new HashMap<>();
        if (this.f9438d == null) {
            return null;
        }
        String a5 = e.a(c.MBRIDGE_CRASH_INFO);
        File file = new File(a5 + "/");
        if (!file.exists()) {
            file.mkdirs();
        }
        String format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(System.currentTimeMillis()));
        File file2 = new File(a5 + "/" + "sdkcrash" + format + ".txt");
        try {
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(file2)));
            printWriter.println(a(this.f9438d, format));
            printWriter.println("====");
            this.f9438d.printStackTrace(printWriter);
            printWriter.close();
            hashMap.put("file", file2);
            hashMap.put("time", format);
            return hashMap;
        } catch (Exception e5) {
            e5.printStackTrace();
            return null;
        }
    }

    private int d(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e5) {
            e5.printStackTrace();
            return 0;
        }
    }

    public void uncaughtException(Thread thread, Throwable th) {
        f.a().b();
        try {
            this.f9438d = th;
            String a5 = a();
            List<String> a6 = a(a5);
            if (a6.size() > 0) {
                for (int i5 = 0; i5 < a6.size(); i5++) {
                    a(a(th), a6.get(i5), th, thread);
                }
                return;
            }
            a(a(th), a5, th, thread);
        } catch (Exception e5) {
            a(thread, th);
            e5.printStackTrace();
        }
    }

    public static d a(Context context) {
        if (f9435b == null) {
            synchronized (d.class) {
                try {
                    if (f9435b == null) {
                        f9435b = new d(context);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return f9435b;
    }

    public final JSONObject b(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        Context context = this.f9437c.get();
        if (context == null) {
            return null;
        }
        float f5 = (float) ((((double) Runtime.getRuntime().totalMemory()) * 1.0d) / 1048576.0d);
        float freeMemory = (float) ((((double) Runtime.getRuntime().freeMemory()) * 1.0d) / 1048576.0d);
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        long usableSpace = externalStorageDirectory.getUsableSpace();
        long totalSpace = externalStorageDirectory.getTotalSpace();
        String formatFileSize = Formatter.formatFileSize(context, usableSpace);
        String formatFileSize2 = Formatter.formatFileSize(context, totalSpace);
        jSONObject.put("max_memory", String.valueOf((float) ((((double) Runtime.getRuntime().maxMemory()) * 1.0d) / 1048576.0d)));
        jSONObject.put("memoryby_app", String.valueOf(f5));
        jSONObject.put("remaining_memory", (double) freeMemory);
        jSONObject.put("sdcard_remainder", formatFileSize);
        jSONObject.put("totalspacestr", formatFileSize2);
        jSONObject.put("crashtime", str);
        String a5 = a.a().a(MBridgeConstans.SDK_APP_ID);
        if (!TextUtils.isEmpty(a5)) {
            jSONObject.put("appid", a5);
        }
        try {
            jSONObject.put("osversion", Build.VERSION.SDK_INT);
            jSONObject.put("appversioncode", d(context));
            jSONObject.put("appversionname", b(context));
            jSONObject.put("appname", c(context));
            return jSONObject;
        } catch (Exception unused) {
            jSONObject.put("osversion", 0);
            jSONObject.put("appversioncode", "-1");
            jSONObject.put("appversionname", "-1");
            jSONObject.put("appname", "");
            return jSONObject;
        }
    }

    private static List<String> a(String str, String str2) {
        ArrayList arrayList = new ArrayList();
        try {
            Matcher matcher = Pattern.compile(str2).matcher(str);
            while (matcher.find()) {
                arrayList.add(matcher.group(1));
            }
            return arrayList;
        } catch (Exception e5) {
            e5.printStackTrace();
            return arrayList;
        }
    }

    public static String a() {
        try {
            g b5 = com.mbridge.msdk.c.h.a().b(com.mbridge.msdk.foundation.controller.c.m().k());
            if (b5 == null) {
                com.mbridge.msdk.c.h.a();
                b5 = i.a();
            }
            String V4 = b5.V();
            if (TextUtils.isEmpty(V4)) {
                return "<mvpackage>mbridge</mvpackage>";
            }
            return V4;
        } catch (Exception unused) {
            return "<mvpackage>mbridge</mvpackage>";
        }
    }

    private String c(Context context) {
        try {
            return context.getResources().getString(context.getPackageManager().getPackageInfo(context.getPackageName(), 0).applicationInfo.labelRes);
        } catch (PackageManager.NameNotFoundException e5) {
            e5.printStackTrace();
            return null;
        }
    }

    public static List<String> a(String str) {
        try {
            List<String> a5 = a(str, "<mvpackage>(.*?)</mvpackage>");
            return a5 == null ? new ArrayList() : a5;
        } catch (Exception unused) {
            return new ArrayList();
        }
    }

    private String a(Throwable th, String str) {
        try {
            JSONObject b5 = b(str);
            if (b5 == null) {
                return "";
            }
            StringWriter stringWriter = new StringWriter();
            th.printStackTrace(new PrintWriter(stringWriter));
            b5.put("crashinfo", stringWriter.toString());
            String jSONObject = b5.toString();
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=2000052");
            stringBuffer.append("&");
            stringBuffer.append("crash_first_index_from_mtg=");
            stringBuffer.append(c.b(th.getStackTrace()));
            stringBuffer.append("&exception=" + jSONObject);
            return stringBuffer.toString();
        } catch (Throwable th2) {
            th2.printStackTrace();
            return "";
        }
    }

    public final void b() {
        this.f9439e = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    private String a(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < stackTrace.length; i5++) {
            sb.append(stackTrace[i5].toString() + "\n");
        }
        return sb.toString();
    }

    private void a(String str, String str2, Throwable th, Thread thread) {
        if (str.contains(str2)) {
            HashMap<String, Object> c5 = c();
            if (c5 != null && c5.get("file") != null) {
                Message obtain = Message.obtain();
                HashMap hashMap = new HashMap();
                hashMap.put("crashinfo", a(th, (String) c5.get("time")));
                hashMap.put("file", c5.get("file"));
                obtain.obj = hashMap;
                obtain.what = 101;
                this.f9436a.sendMessage(obtain);
                a(thread, th);
                return;
            }
            return;
        }
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f9439e;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }

    private void a(Thread thread, Throwable th) {
        try {
            Thread.sleep(AdaptiveTrackSelection.DEFAULT_MIN_TIME_BETWEEN_BUFFER_REEVALUTATION_MS);
        } catch (InterruptedException e5) {
            e5.printStackTrace();
        }
        Process.killProcess(Process.myPid());
    }
}
