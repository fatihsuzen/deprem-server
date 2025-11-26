package com.google.android.gms.measurement.internal;

import K.C0661h;
import K.C0665l;
import N.C0722p;
import T.e;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ext.SdkExtensions;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import androidx.privacysandbox.ads.adservices.java.measurement.MeasurementManagerFutures;
import androidx.work.WorkRequest;
import com.google.android.gms.internal.measurement.C1270z0;
import com.mbridge.msdk.MBridgeConstans;
import com.mbridge.msdk.foundation.entity.CampaignEx;
import com.mbridge.msdk.foundation.entity.RewardPlus;
import com.mbridge.msdk.foundation.tools.SameMD5;
import com.mbridge.msdk.playercommon.exoplayer2.source.chunk.ChunkedTrackBlacklistUtil;
import f0.u;
import f0.x;
import f0.y;
import f0.z;
import j$.util.Objects;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;

public final class z6 extends B3 {

    /* renamed from: i  reason: collision with root package name */
    private static final String[] f6937i = {"firebase_", "google_", "ga_"};

    /* renamed from: j  reason: collision with root package name */
    private static final String[] f6938j = {"_err"};

    /* renamed from: k  reason: collision with root package name */
    public static final /* synthetic */ int f6939k = 0;

    /* renamed from: c  reason: collision with root package name */
    private SecureRandom f6940c;

    /* renamed from: d  reason: collision with root package name */
    private final AtomicLong f6941d = new AtomicLong(0);

    /* renamed from: e  reason: collision with root package name */
    private int f6942e;

    /* renamed from: f  reason: collision with root package name */
    private MeasurementManagerFutures f6943f;

    /* renamed from: g  reason: collision with root package name */
    private Boolean f6944g;

    /* renamed from: h  reason: collision with root package name */
    private Integer f6945h = null;

    z6(X2 x22) {
        super(x22);
    }

    static MessageDigest C() {
        int i5 = 0;
        while (i5 < 2) {
            try {
                MessageDigest instance = MessageDigest.getInstance(SameMD5.TAG);
                if (instance != null) {
                    return instance;
                }
                i5++;
            } catch (NoSuchAlgorithmException unused) {
            }
        }
        return null;
    }

    static long D(byte[] bArr) {
        boolean z4;
        C0722p.k(bArr);
        int length = bArr.length;
        int i5 = 0;
        if (length > 0) {
            z4 = true;
        } else {
            z4 = false;
        }
        C0722p.n(z4);
        int i6 = length - 1;
        long j5 = 0;
        while (i6 >= 0 && i6 >= bArr.length - 8) {
            j5 += (((long) bArr[i6]) & 255) << i5;
            i5 += 8;
            i6--;
        }
        return j5;
    }

    static boolean E(Context context, boolean z4) {
        C0722p.k(context);
        if (Build.VERSION.SDK_INT >= 24) {
            return F(context, "com.google.android.gms.measurement.AppMeasurementJobService");
        }
        return F(context, "com.google.android.gms.measurement.AppMeasurementService");
    }

    static boolean F(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) == null || !serviceInfo.enabled) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    static boolean N(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("_")) {
            return false;
        }
        return true;
    }

    private static boolean O(String str, String[] strArr) {
        C0722p.k(strArr);
        for (String equals : strArr) {
            if (Objects.equals(str, equals)) {
                return true;
            }
        }
        return false;
    }

    public static boolean U(String str) {
        if (f6938j[0].equals(str)) {
            return false;
        }
        return true;
    }

    public static ArrayList h0(List list) {
        if (list == null) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C1341i iVar = (C1341i) it.next();
            Bundle bundle = new Bundle();
            bundle.putString(MBridgeConstans.APP_ID, iVar.f6470a);
            bundle.putString(TtmlNode.ATTR_TTS_ORIGIN, iVar.f6471b);
            bundle.putLong("creation_timestamp", iVar.f6473d);
            bundle.putString(RewardPlus.NAME, iVar.f6472c.f6788b);
            u.a(bundle, C0722p.k(iVar.f6472c.c()));
            bundle.putBoolean("active", iVar.f6474e);
            String str = iVar.f6475f;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            G g5 = iVar.f6476g;
            if (g5 != null) {
                bundle.putString("timed_out_event_name", g5.f5883a);
                E e5 = g5.f5884b;
                if (e5 != null) {
                    bundle.putBundle("timed_out_event_params", e5.j());
                }
            }
            bundle.putLong("trigger_timeout", iVar.f6477h);
            G g6 = iVar.f6478i;
            if (g6 != null) {
                bundle.putString("triggered_event_name", g6.f5883a);
                E e6 = g6.f5884b;
                if (e6 != null) {
                    bundle.putBundle("triggered_event_params", e6.j());
                }
            }
            bundle.putLong("triggered_timestamp", iVar.f6472c.f6789c);
            bundle.putLong("time_to_live", iVar.f6479j);
            G g7 = iVar.f6480k;
            if (g7 != null) {
                bundle.putString("expired_event_name", g7.f5883a);
                E e7 = g7.f5884b;
                if (e7 != null) {
                    bundle.putBundle("expired_event_params", e7.j());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    static boolean j0(Context context) {
        ActivityInfo receiverInfo;
        C0722p.k(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager == null || (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) == null || !receiverInfo.enabled) {
                return false;
            }
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }

    public static void k0(E4 e42, Bundle bundle, boolean z4) {
        if (!(bundle == null || e42 == null)) {
            if (!bundle.containsKey("_sc") || z4) {
                String str = e42.f5860a;
                if (str != null) {
                    bundle.putString("_sn", str);
                } else {
                    bundle.remove("_sn");
                }
                String str2 = e42.f5861b;
                if (str2 != null) {
                    bundle.putString("_sc", str2);
                } else {
                    bundle.remove("_sc");
                }
                bundle.putLong("_si", e42.f5862c);
                return;
            }
            z4 = false;
        }
        if (bundle != null && e42 == null && z4) {
            bundle.remove("_sn");
            bundle.remove("_sc");
            bundle.remove("_si");
        }
    }

    static final boolean m0(Bundle bundle, int i5) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", (long) i5);
        return true;
    }

    private final Object n0(int i5, Object obj, boolean z4, boolean z5, String str) {
        long j5;
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf((long) ((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf((long) ((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf((long) ((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            if (true != ((Boolean) obj).booleanValue()) {
                j5 = 0;
            } else {
                j5 = 1;
            }
            return Long.valueOf(j5);
        } else if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        } else {
            if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
                return q(obj.toString(), i5, z4);
            }
            if (!z5 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            for (Parcelable parcelable : (Parcelable[]) obj) {
                if (parcelable instanceof Bundle) {
                    Bundle Q4 = Q((Bundle) parcelable, (String) null);
                    if (!Q4.isEmpty()) {
                        arrayList.add(Q4);
                    }
                }
            }
            return arrayList.toArray(new Bundle[arrayList.size()]);
        }
    }

    private final int o0(String str) {
        if ("_ldl".equals(str)) {
            this.f5730a.w();
            return 2048;
        } else if ("_id".equals(str)) {
            this.f5730a.w();
            return 256;
        } else if ("_lgclid".equals(str)) {
            this.f5730a.w();
            return 100;
        } else {
            this.f5730a.w();
            return 36;
        }
    }

    static boolean r0(String str) {
        C0722p.e(str);
        if (str.charAt(0) != '_' || str.equals("_ep")) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void A(Bundle bundle, String str, Object obj) {
        String str2;
        if (bundle != null) {
            if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof String) {
                bundle.putString(str, String.valueOf(obj));
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (obj instanceof Bundle[]) {
                bundle.putParcelableArray(str, (Bundle[]) obj);
            } else if (str != null) {
                if (obj != null) {
                    str2 = obj.getClass().getSimpleName();
                } else {
                    str2 = null;
                }
                X2 x22 = this.f5730a;
                x22.a().t().c("Not putting event parameter. Invalid value type. name, type", x22.D().b(str), str2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final int A0(String str) {
        if (!u0("event param", str)) {
            return 3;
        }
        if (!v0("event param", (String[]) null, (String[]) null, str)) {
            return 14;
        }
        this.f5730a.w();
        if (!w0("event param", 40, str)) {
            return 3;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final void B(y6 y6Var, String str, int i5, String str2, String str3, int i6) {
        Bundle bundle = new Bundle();
        m0(bundle, i5);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i5 == 6 || i5 == 7 || i5 == 2) {
            bundle.putLong("_el", (long) i6);
        }
        y6Var.b(str, "_err", bundle);
    }

    /* access modifiers changed from: package-private */
    public final boolean B0(Object obj) {
        if ((obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean C0(String str, String str2, int i5, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String obj2 = obj.toString();
            if (obj2.codePointCount(0, obj2.length()) > i5) {
                this.f5730a.a().t().d("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(obj2.length()));
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void D0(String str, String str2, String str3, Bundle bundle, List list, boolean z4) {
        int i5;
        int i6;
        String str4;
        int i7;
        String str5 = str2;
        Bundle bundle2 = bundle;
        List list2 = list;
        if (bundle2 != null) {
            X2 x22 = this.f5730a;
            if (true != x22.w().f5730a.C().V(231100000, true)) {
                i5 = 0;
            } else {
                i5 = 35;
            }
            int i8 = 0;
            boolean z5 = false;
            for (String str6 : new TreeSet(bundle2.keySet())) {
                if (list2 == null || !list2.contains(str6)) {
                    if (!z4) {
                        i6 = z0(str6);
                    } else {
                        i6 = 0;
                    }
                    if (i6 == 0) {
                        i6 = A0(str6);
                    }
                } else {
                    i6 = 0;
                }
                String str7 = null;
                if (i6 != 0) {
                    if (i6 == 3) {
                        str7 = str6;
                    }
                    x(bundle2, i6, str6, str7);
                    bundle2.remove(str6);
                } else {
                    if (B0(bundle2.get(str6))) {
                        x22.a().t().d("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str5, str3, str6);
                        i7 = 22;
                        str4 = null;
                    } else {
                        String str8 = str3;
                        str4 = null;
                        i7 = r(str, str5, str6, bundle2.get(str6), bundle2, list2, z4, false);
                    }
                    if (i7 != 0 && !"_ev".equals(str6)) {
                        x(bundle2, i7, str6, bundle2.get(str6));
                        bundle2.remove(str6);
                    } else if (r0(str6) && !O(str6, y.f15339d)) {
                        i8++;
                        if (!V(231100000, true)) {
                            x22.a().q().c("Item array not supported on client's version of Google Play Services (Android Only)", x22.D().a(str5), x22.D().e(bundle2));
                            m0(bundle2, 23);
                            bundle2.remove(str6);
                        } else if (i8 > i5) {
                            if (!x22.w().H(str4, C1304d2.f6329f1) || !z5) {
                                C1388o2 q5 = x22.a().q();
                                StringBuilder sb = new StringBuilder(String.valueOf(i5).length() + 55);
                                sb.append("Item can't contain more than ");
                                sb.append(i5);
                                sb.append(" item-scoped custom params");
                                q5.c(sb.toString(), x22.D().a(str5), x22.D().e(bundle2));
                            }
                            m0(bundle2, 28);
                            bundle2.remove(str6);
                            list2 = list;
                            z5 = true;
                        }
                    }
                }
                list2 = list;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean G() {
        h();
        if (J() == 1) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final MeasurementManagerFutures H() {
        if (this.f6943f == null) {
            this.f6943f = MeasurementManagerFutures.from(this.f5730a.e());
        }
        return this.f6943f;
    }

    /* access modifiers changed from: package-private */
    public final int I() {
        if (Build.VERSION.SDK_INT < 30 || SdkExtensions.getExtensionVersion(30) <= 3) {
            return 0;
        }
        return SdkExtensions.getExtensionVersion(1000000);
    }

    /* access modifiers changed from: package-private */
    public final long J() {
        long j5;
        h();
        if (!L(this.f5730a.L().q())) {
            return 0;
        }
        if (Build.VERSION.SDK_INT < 30) {
            j5 = 4;
        } else if (SdkExtensions.getExtensionVersion(30) < 4) {
            j5 = 8;
        } else {
            X2 x22 = this.f5730a;
            int I4 = I();
            x22.w();
            if (I4 < ((Integer) C1304d2.f6349m0.b((Object) null)).intValue()) {
                j5 = 16;
            } else {
                j5 = 0;
            }
        }
        if (!M("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")) {
            j5 |= 2;
        }
        if (j5 == 0 && !K()) {
            j5 = 64;
        }
        if (j5 == 0) {
            return 1;
        }
        return j5;
    }

    /* access modifiers changed from: package-private */
    public final boolean K() {
        Integer num;
        Object e5;
        if (this.f6944g == null) {
            MeasurementManagerFutures H4 = H();
            boolean z4 = false;
            if (H4 == null) {
                return false;
            }
            try {
                num = (Integer) H4.getMeasurementApiStatusAsync().get(WorkRequest.MIN_BACKOFF_MILLIS, TimeUnit.MILLISECONDS);
                if (num != null) {
                    try {
                        if (num.intValue() == 1) {
                            z4 = true;
                        }
                    } catch (CancellationException e6) {
                        e5 = e6;
                        this.f5730a.a().r().b("Measurement manager api exception", e5);
                        this.f6944g = Boolean.FALSE;
                        this.f5730a.a().w().b("Measurement manager api status result", num);
                        return this.f6944g.booleanValue();
                    } catch (ExecutionException e7) {
                        e5 = e7;
                        this.f5730a.a().r().b("Measurement manager api exception", e5);
                        this.f6944g = Boolean.FALSE;
                        this.f5730a.a().w().b("Measurement manager api status result", num);
                        return this.f6944g.booleanValue();
                    } catch (InterruptedException e8) {
                        e5 = e8;
                        this.f5730a.a().r().b("Measurement manager api exception", e5);
                        this.f6944g = Boolean.FALSE;
                        this.f5730a.a().w().b("Measurement manager api status result", num);
                        return this.f6944g.booleanValue();
                    } catch (TimeoutException e9) {
                        e5 = e9;
                        this.f5730a.a().r().b("Measurement manager api exception", e5);
                        this.f6944g = Boolean.FALSE;
                        this.f5730a.a().w().b("Measurement manager api status result", num);
                        return this.f6944g.booleanValue();
                    }
                }
                this.f6944g = Boolean.valueOf(z4);
            } catch (InterruptedException | CancellationException | ExecutionException | TimeoutException e10) {
                e5 = e10;
                num = null;
                this.f5730a.a().r().b("Measurement manager api exception", e5);
                this.f6944g = Boolean.FALSE;
                this.f5730a.a().w().b("Measurement manager api status result", num);
                return this.f6944g.booleanValue();
            }
            this.f5730a.a().w().b("Measurement manager api status result", num);
        }
        return this.f6944g.booleanValue();
    }

    /* access modifiers changed from: package-private */
    public final boolean L(String str) {
        String str2 = (String) C1304d2.f6361s0.b((Object) null);
        if (str2.equals("*") || Arrays.asList(str2.split(",")).contains(str)) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean M(String str) {
        h();
        X2 x22 = this.f5730a;
        if (e.a(x22.e()).a(str) == 0) {
            return true;
        }
        x22.a().v().b("Permission not granted", str);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean P(String str, String str2) {
        if (!TextUtils.isEmpty(str2)) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        X2 x22 = this.f5730a;
        String i5 = x22.w().i();
        x22.c();
        return i5.equals(str);
    }

    /* access modifiers changed from: package-private */
    public final Bundle Q(Bundle bundle, String str) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String next : bundle.keySet()) {
                Object s5 = s(next, bundle.get(next));
                if (s5 == null) {
                    X2 x22 = this.f5730a;
                    x22.a().t().b("Param value can't be null", x22.D().b(next));
                } else {
                    A(bundle2, next, s5);
                }
            }
        }
        return bundle2;
    }

    /* access modifiers changed from: package-private */
    public final G R(String str, String str2, Bundle bundle, String str3, long j5, boolean z4, boolean z5) {
        Bundle bundle2;
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (x0(str2) == 0) {
            if (bundle != null) {
                bundle2 = new Bundle(bundle);
            } else {
                bundle2 = new Bundle();
            }
            Bundle bundle3 = bundle2;
            bundle3.putString("_o", str3);
            String str4 = str;
            String str5 = str2;
            Bundle t5 = t(str4, str5, bundle3, com.google.android.gms.common.util.e.a("_o"), true);
            String str6 = str5;
            if (z4) {
                t5 = Q(t5, str4);
            }
            C0722p.k(t5);
            long j6 = j5;
            return new G(str6, new E(t5), str3, j6);
        }
        X2 x22 = this.f5730a;
        x22.a().o().b("Invalid conditional property event name", x22.D().c(str2));
        throw new IllegalArgumentException();
    }

    /* access modifiers changed from: package-private */
    public final boolean S(Context context, String str) {
        Signature[] signatureArr;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo e5 = e.a(context).e(str, 64);
            if (e5 == null || (signatureArr = e5.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (CertificateException e6) {
            this.f5730a.a().o().b("Error obtaining certificate", e6);
            return true;
        } catch (PackageManager.NameNotFoundException e7) {
            this.f5730a.a().o().b("Package name not found", e7);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final byte[] T(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel obtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(obtain, 0);
            return obtain.marshall();
        } finally {
            obtain.recycle();
        }
    }

    public final boolean V(int i5, boolean z4) {
        Boolean x4 = this.f5730a.J().x();
        if (W() >= i5 / 1000) {
            return true;
        }
        if (x4 == null || x4.booleanValue()) {
            return false;
        }
        return true;
    }

    public final int W() {
        if (this.f6945h == null) {
            this.f6945h = Integer.valueOf(C0661h.f().a(this.f5730a.e()) / 1000);
        }
        return this.f6945h.intValue();
    }

    public final int X(int i5) {
        return C0661h.f().h(this.f5730a.e(), C0665l.f2721a);
    }

    public final long Y(long j5, long j6) {
        return (j5 + (j6 * ChunkedTrackBlacklistUtil.DEFAULT_TRACK_BLACKLIST_MS)) / 86400000;
    }

    /* access modifiers changed from: package-private */
    public final void Z(Bundle bundle, long j5) {
        long j6 = bundle.getLong("_et");
        if (j6 != 0) {
            this.f5730a.a().r().b("Params already contained engagement", Long.valueOf(j6));
        } else {
            j6 = 0;
        }
        bundle.putLong("_et", j5 + j6);
    }

    public final void a0(C1270z0 z0Var, String str) {
        Bundle bundle = new Bundle();
        bundle.putString(CampaignEx.JSON_KEY_AD_R, str);
        try {
            z0Var.W(bundle);
        } catch (RemoteException e5) {
            this.f5730a.a().r().b("Error returning string value to wrapper", e5);
        }
    }

    public final void b0(C1270z0 z0Var, long j5) {
        Bundle bundle = new Bundle();
        bundle.putLong(CampaignEx.JSON_KEY_AD_R, j5);
        try {
            z0Var.W(bundle);
        } catch (RemoteException e5) {
            this.f5730a.a().r().b("Error returning long value to wrapper", e5);
        }
    }

    public final void c0(C1270z0 z0Var, int i5) {
        Bundle bundle = new Bundle();
        bundle.putInt(CampaignEx.JSON_KEY_AD_R, i5);
        try {
            z0Var.W(bundle);
        } catch (RemoteException e5) {
            this.f5730a.a().r().b("Error returning int value to wrapper", e5);
        }
    }

    public final void d0(C1270z0 z0Var, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray(CampaignEx.JSON_KEY_AD_R, bArr);
        try {
            z0Var.W(bundle);
        } catch (RemoteException e5) {
            this.f5730a.a().r().b("Error returning byte array to wrapper", e5);
        }
    }

    public final void e0(C1270z0 z0Var, boolean z4) {
        Bundle bundle = new Bundle();
        bundle.putBoolean(CampaignEx.JSON_KEY_AD_R, z4);
        try {
            z0Var.W(bundle);
        } catch (RemoteException e5) {
            this.f5730a.a().r().b("Error returning boolean value to wrapper", e5);
        }
    }

    public final void f0(C1270z0 z0Var, Bundle bundle) {
        try {
            z0Var.W(bundle);
        } catch (RemoteException e5) {
            this.f5730a.a().r().b("Error returning bundle value to wrapper", e5);
        }
    }

    public final void g0(C1270z0 z0Var, ArrayList arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(CampaignEx.JSON_KEY_AD_R, arrayList);
        try {
            z0Var.W(bundle);
        } catch (RemoteException e5) {
            this.f5730a.a().r().b("Error returning bundle list to wrapper", e5);
        }
    }

    /* access modifiers changed from: protected */
    public final boolean i() {
        return true;
    }

    public final URL i0(long j5, String str, String str2, long j6, String str3) {
        try {
            C0722p.e(str2);
            C0722p.e(str);
            String format = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", new Object[]{String.format("v%s.%s", new Object[]{133005L, Integer.valueOf(W())}), str2, str, Long.valueOf(j6)});
            if (str.equals(this.f5730a.w().j())) {
                format = format.concat("&ddl_test=1");
            }
            if (!str3.isEmpty()) {
                if (str3.charAt(0) != '&') {
                    format = format.concat("&");
                }
                format = format.concat(str3);
            }
            return new URL(format);
        } catch (MalformedURLException e5) {
            e = e5;
            this.f5730a.a().o().b("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        } catch (IllegalArgumentException e6) {
            e = e6;
            this.f5730a.a().o().b("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        }
    }

    /* access modifiers changed from: protected */
    public final void j() {
        h();
        SecureRandom secureRandom = new SecureRandom();
        long nextLong = secureRandom.nextLong();
        if (nextLong == 0) {
            nextLong = secureRandom.nextLong();
            if (nextLong == 0) {
                this.f5730a.a().r().a("Utils falling back to Random for random id");
            }
        }
        this.f6941d.set(nextLong);
    }

    /* access modifiers changed from: package-private */
    public final String l0() {
        byte[] bArr = new byte[16];
        q0().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new Object[]{new BigInteger(1, bArr)});
    }

    /* access modifiers changed from: package-private */
    public final boolean o(String str) {
        if (!TextUtils.isEmpty(str)) {
            C0722p.k(str);
            if (str.matches("^1:\\d+:android:[a-f0-9]+$")) {
                return true;
            }
            this.f5730a.a().q().b("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", C1402q2.x(str));
            return false;
        }
        this.f5730a.a().q().a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
        return false;
    }

    /* access modifiers changed from: package-private */
    public final boolean p(String str, String str2) {
        boolean isEmpty = TextUtils.isEmpty(str);
        boolean isEmpty2 = TextUtils.isEmpty(str2);
        if (!isEmpty && !isEmpty2) {
            C0722p.k(str);
            if (!str.equals(str2)) {
                return true;
            }
        }
        return false;
    }

    public final long p0() {
        long andIncrement;
        long j5;
        AtomicLong atomicLong = this.f6941d;
        if (atomicLong.get() == 0) {
            synchronized (atomicLong) {
                long nextLong = new Random(System.nanoTime() ^ this.f5730a.f().currentTimeMillis()).nextLong();
                int i5 = this.f6942e + 1;
                this.f6942e = i5;
                j5 = nextLong + ((long) i5);
            }
            return j5;
        }
        AtomicLong atomicLong2 = this.f6941d;
        synchronized (atomicLong2) {
            atomicLong2.compareAndSet(-1, 1);
            andIncrement = atomicLong2.getAndIncrement();
        }
        return andIncrement;
    }

    public final String q(String str, int i5, boolean z4) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i5) {
            return str;
        }
        if (z4) {
            return String.valueOf(str.substring(0, str.offsetByCodePoints(0, i5))).concat("...");
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final SecureRandom q0() {
        h();
        if (this.f6940c == null) {
            this.f6940c = new SecureRandom();
        }
        return this.f6940c;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00b5  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00c0  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00d2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int r(java.lang.String r13, java.lang.String r14, java.lang.String r15, java.lang.Object r16, android.os.Bundle r17, java.util.List r18, boolean r19, boolean r20) {
        /*
            r12 = this;
            r1 = r16
            r2 = r17
            r12.h()
            boolean r4 = r12.B0(r1)
            java.lang.String r5 = "param"
            r6 = 0
            if (r4 == 0) goto L_0x00a2
            if (r20 == 0) goto L_0x00a4
            java.lang.String[] r4 = f0.y.f15338c
            boolean r4 = O(r15, r4)
            if (r4 != 0) goto L_0x001d
            r1 = 20
            return r1
        L_0x001d:
            com.google.android.gms.measurement.internal.X2 r4 = r12.f5730a
            com.google.android.gms.measurement.internal.w5 r4 = r4.J()
            r4.h()
            r4.j()
            boolean r7 = r4.y()
            if (r7 != 0) goto L_0x0030
            goto L_0x0042
        L_0x0030:
            com.google.android.gms.measurement.internal.X2 r4 = r4.f5730a
            com.google.android.gms.measurement.internal.z6 r4 = r4.C()
            int r4 = r4.W()
            r7 = 200900(0x310c4, float:2.81521E-40)
            if (r4 >= r7) goto L_0x0042
            r1 = 25
            return r1
        L_0x0042:
            com.google.android.gms.measurement.internal.X2 r4 = r12.f5730a
            r4.w()
            boolean r7 = r1 instanceof android.os.Parcelable[]
            if (r7 == 0) goto L_0x0050
            r8 = r1
            android.os.Parcelable[] r8 = (android.os.Parcelable[]) r8
            int r8 = r8.length
            goto L_0x005b
        L_0x0050:
            boolean r8 = r1 instanceof java.util.ArrayList
            if (r8 == 0) goto L_0x00a2
            r8 = r1
            java.util.ArrayList r8 = (java.util.ArrayList) r8
            int r8 = r8.size()
        L_0x005b:
            r9 = 200(0xc8, float:2.8E-43)
            if (r8 <= r9) goto L_0x00a2
            com.google.android.gms.measurement.internal.q2 r10 = r4.a()
            com.google.android.gms.measurement.internal.o2 r10 = r10.t()
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            java.lang.String r11 = "Parameter array is too long; discarded. Value kind, name, array length"
            r10.d(r11, r5, r15, r8)
            r4.w()
            r4 = 17
            if (r7 == 0) goto L_0x0088
            r7 = r1
            android.os.Parcelable[] r7 = (android.os.Parcelable[]) r7
            int r8 = r7.length
            if (r8 <= r9) goto L_0x0086
            java.lang.Object[] r7 = java.util.Arrays.copyOf(r7, r9)
            android.os.Parcelable[] r7 = (android.os.Parcelable[]) r7
            r2.putParcelableArray(r15, r7)
        L_0x0086:
            r7 = r4
            goto L_0x00a7
        L_0x0088:
            boolean r7 = r1 instanceof java.util.ArrayList
            if (r7 == 0) goto L_0x0086
            r7 = r1
            java.util.ArrayList r7 = (java.util.ArrayList) r7
            int r8 = r7.size()
            if (r8 <= r9) goto L_0x0086
            java.util.ArrayList r8 = new java.util.ArrayList
            java.util.List r7 = r7.subList(r6, r9)
            r8.<init>(r7)
            r2.putParcelableArrayList(r15, r8)
            goto L_0x0086
        L_0x00a2:
            r7 = r6
            goto L_0x00a7
        L_0x00a4:
            r1 = 21
            return r1
        L_0x00a7:
            boolean r2 = N(r14)
            r4 = 0
            if (r2 != 0) goto L_0x00c0
            boolean r2 = N(r15)
            if (r2 == 0) goto L_0x00b5
            goto L_0x00c0
        L_0x00b5:
            com.google.android.gms.measurement.internal.X2 r2 = r12.f5730a
            com.google.android.gms.measurement.internal.m r2 = r2.w()
            int r2 = r2.x(r4, r6)
            goto L_0x00ca
        L_0x00c0:
            com.google.android.gms.measurement.internal.X2 r2 = r12.f5730a
            com.google.android.gms.measurement.internal.m r2 = r2.w()
            int r2 = r2.y(r4, r6)
        L_0x00ca:
            boolean r2 = r12.C0(r5, r15, r2, r1)
            if (r2 == 0) goto L_0x00d2
            goto L_0x015d
        L_0x00d2:
            if (r20 == 0) goto L_0x015e
            boolean r2 = r1 instanceof android.os.Bundle
            if (r2 == 0) goto L_0x00e7
            r4 = r1
            android.os.Bundle r4 = (android.os.Bundle) r4
            r0 = r12
            r1 = r13
            r2 = r14
            r3 = r15
            r5 = r18
            r6 = r19
            r0.D0(r1, r2, r3, r4, r5, r6)
            return r7
        L_0x00e7:
            boolean r2 = r1 instanceof android.os.Parcelable[]
            if (r2 == 0) goto L_0x011d
            r8 = r1
            android.os.Parcelable[] r8 = (android.os.Parcelable[]) r8
            int r9 = r8.length
            r10 = r6
        L_0x00f0:
            if (r10 >= r9) goto L_0x015d
            r1 = r8[r10]
            boolean r2 = r1 instanceof android.os.Bundle
            if (r2 != 0) goto L_0x010c
            com.google.android.gms.measurement.internal.X2 r2 = r12.f5730a
            com.google.android.gms.measurement.internal.q2 r2 = r2.a()
            com.google.android.gms.measurement.internal.o2 r2 = r2.t()
            java.lang.Class r1 = r1.getClass()
            java.lang.String r4 = "All Parcelable[] elements must be of type Bundle. Value type, name"
            r2.c(r4, r1, r15)
            goto L_0x015e
        L_0x010c:
            r4 = r1
            android.os.Bundle r4 = (android.os.Bundle) r4
            r0 = r12
            r1 = r13
            r2 = r14
            r3 = r15
            r5 = r18
            r6 = r19
            r0.D0(r1, r2, r3, r4, r5, r6)
            int r10 = r10 + 1
            goto L_0x00f0
        L_0x011d:
            boolean r2 = r1 instanceof java.util.ArrayList
            if (r2 == 0) goto L_0x015e
            r8 = r1
            java.util.ArrayList r8 = (java.util.ArrayList) r8
            int r9 = r8.size()
            r10 = r6
        L_0x0129:
            if (r10 >= r9) goto L_0x015d
            java.lang.Object r1 = r8.get(r10)
            boolean r2 = r1 instanceof android.os.Bundle
            if (r2 != 0) goto L_0x014c
            com.google.android.gms.measurement.internal.X2 r2 = r12.f5730a
            com.google.android.gms.measurement.internal.q2 r2 = r2.a()
            com.google.android.gms.measurement.internal.o2 r2 = r2.t()
            if (r1 == 0) goto L_0x0144
            java.lang.Class r1 = r1.getClass()
            goto L_0x0146
        L_0x0144:
            java.lang.String r1 = "null"
        L_0x0146:
            java.lang.String r4 = "All ArrayList elements must be of type Bundle. Value type, name"
            r2.c(r4, r1, r15)
            goto L_0x015e
        L_0x014c:
            r4 = r1
            android.os.Bundle r4 = (android.os.Bundle) r4
            r0 = r12
            r1 = r13
            r2 = r14
            r3 = r15
            r5 = r18
            r6 = r19
            r0.D0(r1, r2, r3, r4, r5, r6)
            int r10 = r10 + 1
            goto L_0x0129
        L_0x015d:
            return r7
        L_0x015e:
            r0 = 4
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.z6.r(java.lang.String, java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    /* access modifiers changed from: package-private */
    public final Object s(String str, Object obj) {
        int x4;
        if ("_ev".equals(str)) {
            return n0(this.f5730a.w().y((String) null, false), obj, true, true, (String) null);
        }
        Object obj2 = obj;
        if (N(str)) {
            x4 = this.f5730a.w().y((String) null, false);
        } else {
            x4 = this.f5730a.w().x((String) null, false);
        }
        return n0(x4, obj2, false, true, (String) null);
    }

    /* access modifiers changed from: package-private */
    public final Bundle s0(Uri uri) {
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
        Uri uri2 = uri;
        if (uri2 != null) {
            try {
                if (uri2.isHierarchical()) {
                    str9 = uri2.getQueryParameter("utm_campaign");
                    str8 = uri2.getQueryParameter("utm_source");
                    str7 = uri2.getQueryParameter("utm_medium");
                    str6 = uri2.getQueryParameter("gclid");
                    str5 = uri2.getQueryParameter("gbraid");
                    str4 = uri2.getQueryParameter("utm_id");
                    str3 = uri2.getQueryParameter("dclid");
                    str2 = uri2.getQueryParameter("srsltid");
                    str = uri2.getQueryParameter("sfmc_id");
                } else {
                    str9 = null;
                    str8 = null;
                    str7 = null;
                    str6 = null;
                    str5 = null;
                    str4 = null;
                    str3 = null;
                    str2 = null;
                    str = null;
                }
                if (TextUtils.isEmpty(str9) && TextUtils.isEmpty(str8) && TextUtils.isEmpty(str7) && TextUtils.isEmpty(str6) && TextUtils.isEmpty(str5) && TextUtils.isEmpty(str4) && TextUtils.isEmpty(str3) && TextUtils.isEmpty(str2) && TextUtils.isEmpty(str)) {
                    return null;
                }
                Bundle bundle = new Bundle();
                if (!TextUtils.isEmpty(str9)) {
                    str10 = "sfmc_id";
                    bundle.putString("campaign", str9);
                } else {
                    str10 = "sfmc_id";
                }
                if (!TextUtils.isEmpty(str8)) {
                    bundle.putString("source", str8);
                }
                if (!TextUtils.isEmpty(str7)) {
                    bundle.putString("medium", str7);
                }
                if (!TextUtils.isEmpty(str6)) {
                    bundle.putString("gclid", str6);
                }
                if (!TextUtils.isEmpty(str5)) {
                    bundle.putString("gbraid", str5);
                }
                String queryParameter = uri2.getQueryParameter("gad_source");
                if (!TextUtils.isEmpty(queryParameter)) {
                    bundle.putString("gad_source", queryParameter);
                }
                String queryParameter2 = uri2.getQueryParameter("utm_term");
                if (!TextUtils.isEmpty(queryParameter2)) {
                    bundle.putString("term", queryParameter2);
                }
                String queryParameter3 = uri2.getQueryParameter("utm_content");
                if (!TextUtils.isEmpty(queryParameter3)) {
                    bundle.putString("content", queryParameter3);
                }
                String queryParameter4 = uri2.getQueryParameter("aclid");
                if (!TextUtils.isEmpty(queryParameter4)) {
                    bundle.putString("aclid", queryParameter4);
                }
                String queryParameter5 = uri2.getQueryParameter("cp1");
                if (!TextUtils.isEmpty(queryParameter5)) {
                    bundle.putString("cp1", queryParameter5);
                }
                String queryParameter6 = uri2.getQueryParameter("anid");
                if (!TextUtils.isEmpty(queryParameter6)) {
                    bundle.putString("anid", queryParameter6);
                }
                if (!TextUtils.isEmpty(str4)) {
                    bundle.putString("campaign_id", str4);
                }
                if (!TextUtils.isEmpty(str3)) {
                    bundle.putString("dclid", str3);
                }
                String queryParameter7 = uri2.getQueryParameter("utm_source_platform");
                if (!TextUtils.isEmpty(queryParameter7)) {
                    bundle.putString("source_platform", queryParameter7);
                }
                String queryParameter8 = uri2.getQueryParameter("utm_creative_format");
                if (!TextUtils.isEmpty(queryParameter8)) {
                    bundle.putString("creative_format", queryParameter8);
                }
                String queryParameter9 = uri2.getQueryParameter("utm_marketing_tactic");
                if (!TextUtils.isEmpty(queryParameter9)) {
                    bundle.putString("marketing_tactic", queryParameter9);
                }
                if (!TextUtils.isEmpty(str2)) {
                    bundle.putString("srsltid", str2);
                }
                if (!TextUtils.isEmpty(str)) {
                    bundle.putString(str10, str);
                }
                for (String next : uri2.getQueryParameterNames()) {
                    if (next.startsWith("gad_")) {
                        String queryParameter10 = uri2.getQueryParameter(next);
                        if (!TextUtils.isEmpty(queryParameter10)) {
                            bundle.putString(next, queryParameter10);
                        }
                    }
                }
                return bundle;
            } catch (UnsupportedOperationException e5) {
                this.f5730a.a().r().b("Install referrer url isn't a hierarchical URI", e5);
                return null;
            }
        } else {
            return null;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v1, resolved type: java.lang.String} */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.os.Bundle t(java.lang.String r18, java.lang.String r19, android.os.Bundle r20, java.util.List r21, boolean r22) {
        /*
            r17 = this;
            r0 = r17
            r2 = r19
            r9 = r20
            r6 = r21
            java.lang.String[] r1 = f0.x.f15335d
            boolean r8 = O(r2, r1)
            r10 = 0
            if (r9 == 0) goto L_0x00fa
            android.os.Bundle r5 = new android.os.Bundle
            r5.<init>(r9)
            com.google.android.gms.measurement.internal.X2 r11 = r0.f5730a
            com.google.android.gms.measurement.internal.m r1 = r11.w()
            int r12 = r1.v()
            java.util.TreeSet r1 = new java.util.TreeSet
            java.util.Set r3 = r9.keySet()
            r1.<init>(r3)
            java.util.Iterator r13 = r1.iterator()
            r14 = 0
            r15 = r14
            r16 = r15
        L_0x0031:
            boolean r1 = r13.hasNext()
            if (r1 == 0) goto L_0x00f9
            java.lang.Object r1 = r13.next()
            r3 = r1
            java.lang.String r3 = (java.lang.String) r3
            if (r6 == 0) goto L_0x0049
            boolean r1 = r6.contains(r3)
            if (r1 != 0) goto L_0x0047
            goto L_0x0049
        L_0x0047:
            r1 = r14
            goto L_0x0057
        L_0x0049:
            if (r22 != 0) goto L_0x0050
            int r1 = r0.z0(r3)
            goto L_0x0051
        L_0x0050:
            r1 = r14
        L_0x0051:
            if (r1 != 0) goto L_0x0057
            int r1 = r0.A0(r3)
        L_0x0057:
            if (r1 == 0) goto L_0x0067
            r4 = 3
            if (r1 != r4) goto L_0x005e
            r4 = r3
            goto L_0x005f
        L_0x005e:
            r4 = r10
        L_0x005f:
            r0.x(r5, r1, r3, r4)
            r5.remove(r3)
            goto L_0x00f5
        L_0x0067:
            java.lang.Object r4 = r9.get(r3)
            r1 = r18
            r7 = r22
            int r4 = r0.r(r1, r2, r3, r4, r5, r6, r7, r8)
            r1 = 17
            if (r4 != r1) goto L_0x007d
            java.lang.Boolean r4 = java.lang.Boolean.FALSE
            r0.x(r5, r1, r3, r4)
            goto L_0x0099
        L_0x007d:
            if (r4 == 0) goto L_0x0099
            java.lang.String r1 = "_ev"
            boolean r1 = r1.equals(r3)
            if (r1 != 0) goto L_0x0099
            r1 = 21
            if (r4 != r1) goto L_0x008d
            r1 = r2
            goto L_0x008e
        L_0x008d:
            r1 = r3
        L_0x008e:
            java.lang.Object r6 = r9.get(r3)
            r0.x(r5, r4, r1, r6)
            r5.remove(r3)
            goto L_0x00f5
        L_0x0099:
            boolean r1 = r0(r3)
            if (r1 == 0) goto L_0x00f5
            int r15 = r15 + 1
            if (r15 <= r12) goto L_0x00f5
            com.google.android.gms.measurement.internal.m r1 = r11.w()
            com.google.android.gms.measurement.internal.c2 r4 = com.google.android.gms.measurement.internal.C1304d2.f6329f1
            boolean r1 = r1.H(r10, r4)
            if (r1 == 0) goto L_0x00b1
            if (r16 != 0) goto L_0x00ec
        L_0x00b1:
            java.lang.String r1 = java.lang.String.valueOf(r12)
            int r1 = r1.length()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            int r1 = r1 + 37
            r4.<init>(r1)
            java.lang.String r1 = "Event can't contain more than "
            r4.append(r1)
            r4.append(r12)
            java.lang.String r1 = " params"
            r4.append(r1)
            java.lang.String r1 = r4.toString()
            com.google.android.gms.measurement.internal.q2 r4 = r11.a()
            com.google.android.gms.measurement.internal.o2 r4 = r4.q()
            com.google.android.gms.measurement.internal.j2 r6 = r11.D()
            java.lang.String r6 = r6.a(r2)
            com.google.android.gms.measurement.internal.j2 r7 = r11.D()
            java.lang.String r7 = r7.e(r9)
            r4.c(r1, r6, r7)
        L_0x00ec:
            r1 = 5
            m0(r5, r1)
            r5.remove(r3)
            r16 = 1
        L_0x00f5:
            r6 = r21
            goto L_0x0031
        L_0x00f9:
            return r5
        L_0x00fa:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.z6.t(java.lang.String, java.lang.String, android.os.Bundle, java.util.List, boolean):android.os.Bundle");
    }

    /* access modifiers changed from: package-private */
    public final boolean t0(String str, String str2) {
        if (str2 == null) {
            this.f5730a.a().q().b("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            this.f5730a.a().q().b("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                this.f5730a.a().q().c("Name must start with a letter. Type, name", str, str2);
                return false;
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                    charCount += Character.charCount(codePointAt2);
                } else {
                    this.f5730a.a().q().c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final void u(C1408r2 r2Var, int i5) {
        Bundle bundle = r2Var.f6692d;
        int i6 = 0;
        boolean z4 = false;
        for (String str : new TreeSet(bundle.keySet())) {
            if (r0(str) && (i6 = i6 + 1) > i5) {
                X2 x22 = this.f5730a;
                if (!x22.w().H((String) null, C1304d2.f6329f1) || !z4) {
                    StringBuilder sb = new StringBuilder(String.valueOf(i5).length() + 37);
                    sb.append("Event can't contain more than ");
                    sb.append(i5);
                    sb.append(" params");
                    x22.a().q().c(sb.toString(), x22.D().a(r2Var.f6689a), x22.D().e(bundle));
                    m0(bundle, 5);
                }
                bundle.remove(str);
                z4 = true;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean u0(String str, String str2) {
        if (str2 == null) {
            this.f5730a.a().q().b("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.length() == 0) {
            this.f5730a.a().q().b("Name is required and can't be empty. Type", str);
            return false;
        } else {
            int codePointAt = str2.codePointAt(0);
            if (!Character.isLetter(codePointAt)) {
                if (codePointAt == 95) {
                    codePointAt = 95;
                } else {
                    this.f5730a.a().q().c("Name must start with a letter or _ (underscore). Type, name", str, str2);
                    return false;
                }
            }
            int length = str2.length();
            int charCount = Character.charCount(codePointAt);
            while (charCount < length) {
                int codePointAt2 = str2.codePointAt(charCount);
                if (codePointAt2 == 95 || Character.isLetterOrDigit(codePointAt2)) {
                    charCount += Character.charCount(codePointAt2);
                } else {
                    this.f5730a.a().q().c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                    return false;
                }
            }
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final void v(Parcelable[] parcelableArr, int i5) {
        C0722p.k(parcelableArr);
        for (Bundle bundle : parcelableArr) {
            int i6 = 0;
            boolean z4 = false;
            for (String str : new TreeSet(bundle.keySet())) {
                if (r0(str) && !O(str, y.f15339d) && (i6 = i6 + 1) > i5) {
                    X2 x22 = this.f5730a;
                    if (!x22.w().H((String) null, C1304d2.f6329f1) || !z4) {
                        C1388o2 q5 = x22.a().q();
                        StringBuilder sb = new StringBuilder(String.valueOf(i5).length() + 60);
                        sb.append("Param can't contain more than ");
                        sb.append(i5);
                        sb.append(" item-scoped custom parameters");
                        q5.c(sb.toString(), x22.D().b(str), x22.D().e(bundle));
                    }
                    m0(bundle, 28);
                    bundle.remove(str);
                    z4 = true;
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean v0(String str, String[] strArr, String[] strArr2, String str2) {
        if (str2 == null) {
            this.f5730a.a().q().b("Name is required and can't be null. Type", str);
            return false;
        }
        C0722p.k(str2);
        String[] strArr3 = f6937i;
        for (int i5 = 0; i5 < 3; i5++) {
            if (str2.startsWith(strArr3[i5])) {
                this.f5730a.a().q().c("Name starts with reserved prefix. Type, name", str, str2);
                return false;
            }
        }
        if (strArr == null || !O(str2, strArr)) {
            return true;
        }
        if (strArr2 != null && O(str2, strArr2)) {
            return true;
        }
        this.f5730a.a().q().c("Name is reserved. Type, name", str, str2);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final void w(Bundle bundle, Bundle bundle2) {
        if (bundle2 != null) {
            for (String next : bundle2.keySet()) {
                if (!bundle.containsKey(next)) {
                    this.f5730a.C().A(bundle, next, bundle2.get(next));
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final boolean w0(String str, int i5, String str2) {
        if (str2 == null) {
            this.f5730a.a().q().b("Name is required and can't be null. Type", str);
            return false;
        } else if (str2.codePointCount(0, str2.length()) <= i5) {
            return true;
        } else {
            this.f5730a.a().q().d("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i5), str2);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public final void x(Bundle bundle, int i5, String str, Object obj) {
        if (m0(bundle, i5)) {
            this.f5730a.w();
            bundle.putString("_ev", q(str, 40, true));
            if (obj != null) {
                C0722p.k(bundle);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", (long) obj.toString().length());
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final int x0(String str) {
        if (!u0(NotificationCompat.CATEGORY_EVENT, str)) {
            return 2;
        }
        if (!v0(NotificationCompat.CATEGORY_EVENT, x.f15332a, x.f15333b, str)) {
            return 13;
        }
        this.f5730a.w();
        if (!w0(NotificationCompat.CATEGORY_EVENT, 40, str)) {
            return 2;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final int y(String str, Object obj) {
        boolean z4;
        if ("_ldl".equals(str)) {
            z4 = C0("user property referrer", str, o0(str), obj);
        } else {
            z4 = C0("user property", str, o0(str), obj);
        }
        if (z4) {
            return 0;
        }
        return 7;
    }

    /* access modifiers changed from: package-private */
    public final int y0(String str) {
        if (!u0("user property", str)) {
            return 6;
        }
        if (!v0("user property", z.f15340a, (String[]) null, str)) {
            return 15;
        }
        this.f5730a.w();
        if (!w0("user property", 24, str)) {
            return 6;
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final Object z(String str, Object obj) {
        if ("_ldl".equals(str)) {
            return n0(o0(str), obj, true, false, (String) null);
        }
        return n0(o0(str), obj, false, false, (String) null);
    }

    /* access modifiers changed from: package-private */
    public final int z0(String str) {
        if (!t0("event param", str)) {
            return 3;
        }
        if (!v0("event param", (String[]) null, (String[]) null, str)) {
            return 14;
        }
        this.f5730a.w();
        if (!w0("event param", 40, str)) {
            return 3;
        }
        return 0;
    }
}
