package com.mbridge.msdk.foundation.controller.authoritycontroller;

import android.content.Context;
import android.text.TextUtils;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.a.a.a;
import com.mbridge.msdk.foundation.controller.e;
import com.mbridge.msdk.foundation.tools.af;
import com.mbridge.msdk.out.OnCompletionListener;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class b {

    /* renamed from: c  reason: collision with root package name */
    private static boolean f8843c = true;

    /* renamed from: d  reason: collision with root package name */
    private static boolean f8844d = true;

    /* renamed from: a  reason: collision with root package name */
    public ArrayList<String> f8845a = new ArrayList<>();

    /* renamed from: b  reason: collision with root package name */
    protected AuthorityInfoBean f8846b;

    /* renamed from: e  reason: collision with root package name */
    private int f8847e = 3;

    /* renamed from: f  reason: collision with root package name */
    private String f8848f = "";

    /* renamed from: g  reason: collision with root package name */
    private e f8849g;

    protected b() {
        c();
    }

    public static boolean b() {
        return f8844d;
    }

    /* access modifiers changed from: private */
    public void j() {
        int i5;
        boolean b5 = this.f8849g.b();
        c(this.f8849g.a());
        if (b5) {
            i5 = 1;
        } else {
            i5 = 2;
        }
        c(i5);
        this.f8846b.authDeviceIdStatus(b5 ? 1 : 0);
    }

    /* access modifiers changed from: protected */
    public abstract int b(String str);

    /* access modifiers changed from: protected */
    public final void c() {
        this.f8846b = new AuthorityInfoBean();
        try {
            if (a.a().a(MBridgeConstans.AUTHORITY_GENERAL_DATA).equals("")) {
                this.f8846b.authGenDataStatus(1);
            }
            if (a.a().a(MBridgeConstans.AUTHORITY_DEVICE_ID).equals("")) {
                this.f8846b.authDeviceIdStatus(1);
            }
            if (a.a().a(MBridgeConstans.AUTHORITY_SERIAL_ID).equals("")) {
                this.f8846b.authSerialIdStatus(1);
            }
            if (a.a().a(MBridgeConstans.AUTHORITY_OTHER).equals("")) {
                this.f8846b.authOther(1);
            }
            this.f8845a.add(MBridgeConstans.AUTHORITY_GENERAL_DATA);
            this.f8845a.add(MBridgeConstans.AUTHORITY_DEVICE_ID);
            this.f8845a.add(MBridgeConstans.AUTHORITY_SERIAL_ID);
            this.f8845a.add(MBridgeConstans.AUTHORITY_OTHER);
        } catch (Exception e5) {
            e5.printStackTrace();
        }
    }

    public final AuthorityInfoBean d() {
        AuthorityInfoBean authorityInfoBean = this.f8846b;
        if (authorityInfoBean != null) {
            return authorityInfoBean;
        }
        AuthorityInfoBean authorityInfoBean2 = new AuthorityInfoBean();
        authorityInfoBean2.a(1);
        return authorityInfoBean2;
    }

    public final boolean e() {
        int i5 = this.f8847e;
        if (i5 == 1 || i5 == 3) {
            return true;
        }
        return false;
    }

    public final int f() {
        return a.a().a(MBridgeConstans.AUTHORITY_COPPA, 0);
    }

    public final int g() {
        return this.f8847e;
    }

    public final String h() {
        JSONArray jSONArray = new JSONArray();
        for (int i5 = 0; i5 < this.f8845a.size(); i5++) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("keyname", String.valueOf(this.f8845a.get(i5)));
                jSONObject.put("client_status", a(this.f8845a.get(i5)));
                jSONObject.put("server_status", b(this.f8845a.get(i5)));
                jSONArray.put(jSONObject);
            } catch (JSONException e5) {
                e5.printStackTrace();
            }
        }
        return jSONArray.toString();
    }

    public final String i() {
        return this.f8848f;
    }

    public static void b(boolean z4) {
        f8844d = z4;
    }

    public static boolean a() {
        return f8843c;
    }

    public final void b(int i5) {
        a.a().b(MBridgeConstans.AUTHORITY_DNT, i5);
    }

    public static void a(boolean z4) {
        f8843c = z4;
    }

    public final void a(int i5) {
        if (this.f8846b != null) {
            c(i5);
        }
    }

    public final void a(final Context context, final OnCompletionListener onCompletionListener) {
        if (onCompletionListener != null) {
            com.mbridge.msdk.foundation.same.f.a.b().execute(new Runnable() {
                public final void run() {
                    b.this.a(context);
                    onCompletionListener.onCompletion();
                }
            });
        } else {
            a(context);
        }
    }

    /* access modifiers changed from: protected */
    public final int a(String str) {
        try {
            if (!TextUtils.isEmpty(str)) {
                String a5 = a.a().a(str);
                if (TextUtils.isEmpty(a5)) {
                    return 0;
                }
                return Integer.parseInt(a5);
            }
        } catch (Exception e5) {
            af.b("SDKAuthorityController", e5.getMessage());
        }
        return 0;
    }

    public final void a(String str, int i5) {
        if (this.f8846b == null) {
            return;
        }
        if (str.equals(MBridgeConstans.AUTHORITY_GENERAL_DATA)) {
            this.f8846b.authGenDataStatus(i5);
        } else if (str.equals(MBridgeConstans.AUTHORITY_DEVICE_ID)) {
            this.f8846b.authDeviceIdStatus(i5);
        } else if (str.equals(MBridgeConstans.AUTHORITY_ALL_INFO)) {
            this.f8846b.a(i5);
        } else if (str.equals(MBridgeConstans.AUTHORITY_SERIAL_ID)) {
            this.f8846b.authSerialIdStatus(i5);
        } else if (str.equals(MBridgeConstans.AUTHORITY_OTHER)) {
            this.f8846b.authOther(i5);
        }
    }

    private void c(int i5) {
        int i6 = 1;
        if (i5 != 1) {
            i6 = 2;
        }
        this.f8847e = i6;
    }

    private void c(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f8848f = str;
        }
    }

    /* access modifiers changed from: private */
    public void a(Context context) {
        try {
            if (this.f8849g == null) {
                e eVar = new e(context);
                this.f8849g = eVar;
                eVar.a((e.a) new e.a() {
                    public final void a() {
                        b.this.j();
                    }
                });
            }
            j();
        } catch (Throwable th) {
            af.b("SDKAuthorityController", th.getMessage());
        }
    }
}
