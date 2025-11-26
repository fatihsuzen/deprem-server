package l2;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Parcel;
import android.os.Parcelable;
import b2.C2277I;
import b2.C2291k;
import com.mbridge.msdk.MBridgeConstans;
import d3.C2345b;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.C2625c;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import t3.s;
import z2.C2940B;

/* renamed from: l2.d  reason: case insensitive filesystem */
public final class C2655d implements Parcelable {

    /* renamed from: C  reason: collision with root package name */
    public static final b f24967C = new b((C2633k) null);
    public static Parcelable.Creator<C2655d> CREATOR = new a();

    /* renamed from: A  reason: collision with root package name */
    private ArrayList f24968A;

    /* renamed from: B  reason: collision with root package name */
    private boolean f24969B;

    /* renamed from: a  reason: collision with root package name */
    private long f24970a;

    /* renamed from: b  reason: collision with root package name */
    private String f24971b;

    /* renamed from: c  reason: collision with root package name */
    private String f24972c;

    /* renamed from: d  reason: collision with root package name */
    private long f24973d;

    /* renamed from: e  reason: collision with root package name */
    private String f24974e;

    /* renamed from: f  reason: collision with root package name */
    private String f24975f;

    /* renamed from: g  reason: collision with root package name */
    private c f24976g;

    /* renamed from: h  reason: collision with root package name */
    private int f24977h;

    /* renamed from: i  reason: collision with root package name */
    private int f24978i;

    /* renamed from: j  reason: collision with root package name */
    private int f24979j;

    /* renamed from: k  reason: collision with root package name */
    private int f24980k;

    /* renamed from: l  reason: collision with root package name */
    private String f24981l;

    /* renamed from: m  reason: collision with root package name */
    private int f24982m;

    /* renamed from: n  reason: collision with root package name */
    private long f24983n;

    /* renamed from: o  reason: collision with root package name */
    private long f24984o;

    /* renamed from: p  reason: collision with root package name */
    private int f24985p;

    /* renamed from: q  reason: collision with root package name */
    private String f24986q;

    /* renamed from: r  reason: collision with root package name */
    private long f24987r;

    /* renamed from: s  reason: collision with root package name */
    private String f24988s;

    /* renamed from: t  reason: collision with root package name */
    private int f24989t;

    /* renamed from: u  reason: collision with root package name */
    private C2646F f24990u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f24991v;

    /* renamed from: w  reason: collision with root package name */
    private long f24992w;

    /* renamed from: x  reason: collision with root package name */
    private int f24993x;

    /* renamed from: y  reason: collision with root package name */
    private int f24994y;

    /* renamed from: z  reason: collision with root package name */
    private ArrayList f24995z;

    /* renamed from: l2.d$a */
    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public C2655d createFromParcel(Parcel parcel) {
            t.e(parcel, "source");
            return new C2655d(parcel);
        }

        /* renamed from: b */
        public C2655d[] newArray(int i5) {
            return new C2655d[i5];
        }
    }

    /* renamed from: l2.d$b */
    public static final class b {
        public /* synthetic */ b(C2633k kVar) {
            this();
        }

        private b() {
        }
    }

    /* renamed from: l2.d$c */
    public enum c {
        OUTDATED,
        UPDATED,
        UNAVAILABLE;

        static {
            c[] a5;
            f25000e = C2345b.a(a5);
        }
    }

    /* renamed from: l2.d$d  reason: collision with other inner class name */
    public /* synthetic */ class C0251d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f25001a;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        static {
            /*
                l2.d$c[] r0 = l2.C2655d.c.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                l2.d$c r1 = l2.C2655d.c.OUTDATED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                l2.d$c r1 = l2.C2655d.c.UPDATED     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f25001a = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: l2.C2655d.C0251d.<clinit>():void");
        }
    }

    public C2655d() {
        this.f24970a = -1;
        this.f24973d = -1;
        this.f24976g = c.UPDATED;
        this.f24994y = -1;
    }

    public final long A() {
        return this.f24973d;
    }

    public final String B() {
        return this.f24974e;
    }

    public final boolean C(Context context) {
        t.e(context, "context");
        if (this.f24972c == null) {
            return false;
        }
        if (H()) {
            return com.uptodown.activities.preferences.a.f15150a.i0(context);
        }
        if (F()) {
            return com.uptodown.activities.preferences.a.f15150a.h0(context);
        }
        return true;
    }

    public final boolean D() {
        long j5 = this.f24984o;
        long j6 = this.f24987r;
        long currentTimeMillis = System.currentTimeMillis();
        if (j6 == j5 || currentTimeMillis - j5 >= 604800000) {
            return false;
        }
        return true;
    }

    public final int E() {
        return this.f24977h;
    }

    public final boolean F() {
        if (this.f24977h == 1) {
            return true;
        }
        return false;
    }

    public final int G() {
        return this.f24978i;
    }

    public final boolean H() {
        if (this.f24978i == 1) {
            return true;
        }
        return false;
    }

    public final void I(C2940B b5) {
        t.e(b5, "dbManager");
        this.f24968A = new ArrayList();
        C2277I i5 = new C2277I();
        String str = this.f24972c;
        t.b(str);
        ArrayList a5 = i5.a(str);
        if (!a5.isEmpty()) {
            String str2 = this.f24972c;
            t.b(str2);
            C2655d Y4 = b5.Y(str2);
            if (Y4 != null) {
                ArrayList Z4 = b5.Z(Y4.f24970a);
                Iterator it = a5.iterator();
                t.d(it, "iterator(...)");
                while (it.hasNext()) {
                    Object next = it.next();
                    t.d(next, "next(...)");
                    File file = (File) next;
                    if (file.isFile()) {
                        String name = file.getName();
                        t.d(name, "getName(...)");
                        if (s.D(name, ".obb", false, 2, (Object) null)) {
                            String absolutePath = file.getAbsolutePath();
                            t.d(absolutePath, "getAbsolutePath(...)");
                            ArrayList arrayList = this.f24968A;
                            t.b(arrayList);
                            a(absolutePath, Z4, b5, Y4, arrayList);
                        }
                    }
                }
            }
        }
    }

    public final void J(ApplicationInfo applicationInfo, C2940B b5) {
        t.e(applicationInfo, "applicationInfo");
        t.e(b5, "dbManager");
        this.f24995z = new ArrayList();
        String[] strArr = applicationInfo.splitSourceDirs;
        if (strArr != null) {
            String str = this.f24972c;
            t.b(str);
            C2655d Y4 = b5.Y(str);
            if (Y4 != null) {
                ArrayList Z4 = b5.Z(Y4.f24970a);
                Iterator a5 = C2625c.a(strArr);
                while (a5.hasNext()) {
                    String str2 = (String) a5.next();
                    t.b(str2);
                    if (s.D(str2, ".apk", false, 2, (Object) null)) {
                        ArrayList arrayList = this.f24995z;
                        t.b(arrayList);
                        a(str2, Z4, b5, Y4, arrayList);
                    }
                }
                C2940B b6 = b5;
                if (!Z4.isEmpty()) {
                    Iterator it = Z4.iterator();
                    t.d(it, "iterator(...)");
                    while (it.hasNext()) {
                        Object next = it.next();
                        t.d(next, "next(...)");
                        b6.v((C2673w) next);
                    }
                }
            }
        }
    }

    public final void K(long j5) {
        this.f24992w = j5;
    }

    public final void L(String str) {
        this.f24986q = str;
    }

    public final void M(boolean z4) {
        this.f24969B = z4;
    }

    public final void N(int i5) {
        this.f24982m = i5;
    }

    public final void O(int i5) {
        this.f24985p = i5;
    }

    public final void P(boolean z4, boolean z5) {
        if (F()) {
            if (!z4) {
                this.f24985p = 1;
            } else {
                this.f24985p = 0;
            }
        }
        if (!H()) {
            return;
        }
        if (!z5) {
            this.f24985p = 1;
        } else {
            this.f24985p = 0;
        }
    }

    public final void Q(long j5) {
        this.f24987r = j5;
    }

    public final void R(int i5) {
        this.f24993x = i5;
    }

    public final void S(long j5) {
        this.f24970a = j5;
    }

    public final void T(long j5) {
        this.f24984o = j5;
    }

    public final void U(String str) {
        this.f24981l = str;
    }

    public final void V(String str) {
        this.f24971b = str;
    }

    public final void W(String str) {
        this.f24972c = str;
    }

    public final void X(C2646F f5) {
        this.f24990u = f5;
    }

    public final void Y(int i5) {
        this.f24989t = i5;
    }

    public final void Z(String str) {
        this.f24988s = str;
    }

    public final void a(String str, ArrayList arrayList, C2940B b5, C2655d dVar, ArrayList arrayList2) {
        String str2 = str;
        ArrayList<C2673w> arrayList3 = arrayList;
        C2940B b6 = b5;
        C2655d dVar2 = dVar;
        ArrayList arrayList4 = arrayList2;
        t.e(str2, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        t.e(arrayList3, "appFilesStored");
        t.e(b6, "dbManager");
        t.e(dVar2, "appStored");
        t.e(arrayList4, "out");
        C2673w wVar = new C2673w();
        wVar.g(new File(str2).length());
        wVar.e(str2);
        int i5 = -1;
        int i6 = 0;
        for (C2673w wVar2 : arrayList3) {
            int i7 = i6 + 1;
            if (s.F(wVar2.a(), wVar.a(), false, 2, (Object) null) && wVar2.d() == wVar.d()) {
                if (wVar2.c() != null) {
                    wVar.f(wVar2.c());
                }
                i5 = i6;
            }
            i6 = i7;
        }
        if (i5 != -1) {
            arrayList3.remove(i5);
            arrayList4.add(wVar);
        } else if (b6.N0(dVar2.f24970a, wVar) >= 0) {
            arrayList4.add(wVar);
        }
    }

    public final void a0(boolean z4) {
        this.f24991v = z4;
    }

    public final long b() {
        return this.f24992w;
    }

    public final void b0(long j5) {
        this.f24983n = j5;
    }

    public final String c() {
        return this.f24986q;
    }

    public final void c0(c cVar) {
        t.e(cVar, "<set-?>");
        this.f24976g = cVar;
    }

    public final boolean d() {
        return this.f24969B;
    }

    public final void d0(int i5) {
        this.f24977h = i5;
    }

    public int describeContents() {
        return hashCode();
    }

    public final int e() {
        return this.f24982m;
    }

    public final void e0(int i5) {
        this.f24978i = i5;
    }

    public final int f() {
        return this.f24985p;
    }

    public final void f0(int i5) {
        this.f24994y = i5;
    }

    public final long g() {
        return this.f24987r;
    }

    public final void g0(String str) {
        this.f24975f = str;
    }

    public final int h() {
        return this.f24993x;
    }

    public final void h0(long j5) {
        this.f24973d = j5;
    }

    public final long i() {
        return this.f24970a;
    }

    public final void i0(String str) {
        this.f24974e = str;
    }

    public final long j() {
        return this.f24984o;
    }

    public final String k() {
        return this.f24981l;
    }

    public final int l() {
        return this.f24979j;
    }

    public final String m() {
        return this.f24971b;
    }

    public final ArrayList n() {
        return this.f24968A;
    }

    public final String o() {
        return this.f24972c;
    }

    public final C2646F p() {
        return this.f24990u;
    }

    public final int q() {
        return this.f24989t;
    }

    public final String r() {
        return this.f24988s;
    }

    public final boolean s() {
        return this.f24991v;
    }

    public final long t() {
        return this.f24983n;
    }

    public String toString() {
        return "{id='" + this.f24970a + "', name='" + this.f24971b + "', packagename='" + this.f24972c + "', versionCode=" + this.f24973d + ", versionName='" + this.f24974e + "', urlFicha='" + this.f24975f + "', status=" + this.f24976g + ", isSystemApp=" + this.f24977h + ", isSystemService=" + this.f24978i + ", minSdkVersion=" + this.f24979j + ", targetSdkVersion=" + this.f24980k + ", md5signature='" + this.f24981l + "', exclude=" + this.f24982m + ", size=" + this.f24983n + ", lastUpdateTime=" + this.f24984o + ", excludeFromTracking=" + this.f24985p + ", defaultName='" + this.f24986q + "', firstInstallTime=" + this.f24987r + ", sha256='" + this.f24988s + "', appID=" + this.f24992w + ", hasOldVersions=" + this.f24993x + ", trackInfoRegistered=" + this.f24994y + '}';
    }

    public final String u(Context context) {
        t.e(context, "context");
        return new C2291k().d(this.f24983n, context);
    }

    public final ArrayList v() {
        return this.f24995z;
    }

    public final c w() {
        return this.f24976g;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        t.e(parcel, "parcel");
        parcel.writeLong(this.f24970a);
        parcel.writeString(this.f24971b);
        parcel.writeString(this.f24972c);
        parcel.writeLong(this.f24973d);
        parcel.writeString(this.f24974e);
        parcel.writeString(this.f24975f);
        int i6 = C0251d.f25001a[this.f24976g.ordinal()];
        if (i6 == 1) {
            parcel.writeInt(0);
        } else if (i6 != 2) {
            parcel.writeInt(2);
        } else {
            parcel.writeInt(1);
        }
        parcel.writeInt(this.f24977h);
        parcel.writeInt(this.f24978i);
        parcel.writeInt(this.f24979j);
        parcel.writeInt(this.f24980k);
        parcel.writeString(this.f24981l);
        parcel.writeInt(this.f24982m);
        parcel.writeLong(this.f24983n);
        parcel.writeLong(this.f24984o);
        parcel.writeInt(this.f24985p);
        parcel.writeString(this.f24986q);
        parcel.writeLong(this.f24987r);
        parcel.writeString(this.f24988s);
        parcel.writeInt(this.f24989t);
        parcel.writeLong(this.f24992w);
        parcel.writeInt(this.f24993x);
        parcel.writeInt(this.f24969B ? 1 : 0);
    }

    public final int x() {
        return this.f24980k;
    }

    public final int y() {
        return this.f24994y;
    }

    public final String z() {
        return this.f24975f;
    }

    public C2655d(Parcel parcel) {
        t.e(parcel, "source");
        this.f24970a = -1;
        this.f24973d = -1;
        c cVar = c.UPDATED;
        this.f24976g = cVar;
        this.f24994y = -1;
        this.f24970a = parcel.readLong();
        this.f24971b = parcel.readString();
        this.f24972c = parcel.readString();
        this.f24973d = parcel.readLong();
        this.f24974e = parcel.readString();
        this.f24975f = parcel.readString();
        int readInt = parcel.readInt();
        boolean z4 = true;
        if (readInt == 0) {
            this.f24976g = c.OUTDATED;
        } else if (readInt != 1) {
            this.f24976g = c.UNAVAILABLE;
        } else {
            this.f24976g = cVar;
        }
        this.f24977h = parcel.readInt();
        this.f24978i = parcel.readInt();
        this.f24979j = parcel.readInt();
        this.f24980k = parcel.readInt();
        this.f24981l = parcel.readString();
        this.f24982m = parcel.readInt();
        this.f24983n = parcel.readLong();
        this.f24984o = parcel.readLong();
        this.f24985p = parcel.readInt();
        this.f24986q = parcel.readString();
        this.f24987r = parcel.readLong();
        this.f24988s = parcel.readString();
        this.f24989t = parcel.readInt();
        this.f24992w = parcel.readLong();
        this.f24993x = parcel.readInt();
        this.f24969B = parcel.readInt() != 1 ? false : z4;
    }
}
