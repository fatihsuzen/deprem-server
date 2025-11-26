package l2;

import S1.k;
import Y1.C2257a;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import b2.C2290j;
import b2.C2301u;
import com.mbridge.msdk.MBridgeConstans;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.Q;
import kotlin.jvm.internal.t;
import t3.s;
import z2.C2940B;
import z2.E;
import z2.H;

/* renamed from: l2.q  reason: case insensitive filesystem */
public final class C2668q implements Parcelable {
    public static Parcelable.Creator<C2668q> CREATOR = new a();

    /* renamed from: w  reason: collision with root package name */
    public static final b f25155w = new b((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private int f25156a = -1;

    /* renamed from: b  reason: collision with root package name */
    private String f25157b;

    /* renamed from: c  reason: collision with root package name */
    private int f25158c;

    /* renamed from: d  reason: collision with root package name */
    private int f25159d = 1;

    /* renamed from: e  reason: collision with root package name */
    private long f25160e = -1;

    /* renamed from: f  reason: collision with root package name */
    private String f25161f;

    /* renamed from: g  reason: collision with root package name */
    private int f25162g;

    /* renamed from: h  reason: collision with root package name */
    private long f25163h = -1;

    /* renamed from: i  reason: collision with root package name */
    private int f25164i;

    /* renamed from: j  reason: collision with root package name */
    private String f25165j;

    /* renamed from: k  reason: collision with root package name */
    private String f25166k;

    /* renamed from: l  reason: collision with root package name */
    private int f25167l;

    /* renamed from: m  reason: collision with root package name */
    private String f25168m;

    /* renamed from: n  reason: collision with root package name */
    private String f25169n;

    /* renamed from: o  reason: collision with root package name */
    private long f25170o;

    /* renamed from: p  reason: collision with root package name */
    private ArrayList f25171p;

    /* renamed from: q  reason: collision with root package name */
    private long f25172q = -1;

    /* renamed from: r  reason: collision with root package name */
    private int f25173r;

    /* renamed from: s  reason: collision with root package name */
    private long f25174s = -1;

    /* renamed from: t  reason: collision with root package name */
    private long f25175t = -1;

    /* renamed from: u  reason: collision with root package name */
    private Drawable f25176u;

    /* renamed from: v  reason: collision with root package name */
    private ArrayList f25177v = new ArrayList();

    /* renamed from: l2.q$a */
    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public C2668q createFromParcel(Parcel parcel) {
            t.e(parcel, "source");
            return new C2668q(parcel);
        }

        /* renamed from: b */
        public C2668q[] newArray(int i5) {
            return new C2668q[i5];
        }
    }

    /* renamed from: l2.q$b */
    public static final class b {
        public /* synthetic */ b(C2633k kVar) {
            this();
        }

        public final int a(Context context) {
            t.e(context, "context");
            C2940B a5 = C2940B.f26458v.a(context);
            a5.a();
            ArrayList p02 = a5.p0();
            a5.m();
            Iterator it = p02.iterator();
            t.d(it, "iterator(...)");
            int i5 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                t.d(next, "next(...)");
                C2668q qVar = (C2668q) next;
                if (qVar.P() && qVar.k() == 0 && qVar.f()) {
                    i5++;
                }
            }
            return i5;
        }

        private b() {
        }
    }

    public C2668q() {
    }

    private final boolean K() {
        if (this.f25162g >= 4) {
            return true;
        }
        return false;
    }

    private final void Q(Context context) {
        PackageInfo packageInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null) {
                String str = this.f25157b;
                t.b(str);
                packageInfo = C2301u.d(packageManager, str, 0);
            } else {
                packageInfo = null;
            }
            if (packageInfo != null) {
                this.f25175t = new C2290j().m(packageInfo);
            }
        } catch (Exception unused) {
        }
    }

    private final boolean a() {
        if (System.currentTimeMillis() > this.f25170o) {
            return true;
        }
        return false;
    }

    public final String A() {
        return this.f25166k;
    }

    public final ArrayList B() {
        return this.f25171p;
    }

    public final long C() {
        return this.f25172q;
    }

    public final String D() {
        return this.f25168m;
    }

    public final long E() {
        return this.f25160e;
    }

    public final long F() {
        return this.f25174s;
    }

    public final long G() {
        return this.f25175t;
    }

    public final String H() {
        return this.f25161f;
    }

    public final boolean I() {
        if (K() || !a()) {
            return false;
        }
        return true;
    }

    public final void J(Context context) {
        t.e(context, "context");
        C2940B a5 = C2940B.f26458v.a(context);
        a5.a();
        this.f25162g++;
        this.f25170o = System.currentTimeMillis() + 1800000;
        a5.A(this);
        if (this.f25162g >= 4) {
            U(context);
        } else {
            a5.Q0(this);
        }
        a5.m();
    }

    public final int L() {
        return this.f25173r;
    }

    public final boolean M() {
        if (this.f25157b == null || !P() || f() || this.f25165j == null || this.f25160e <= 0 || !I()) {
            return false;
        }
        return true;
    }

    public final boolean N() {
        C2257a i5 = k.f32g.i();
        if (this.f25160e <= 0 || this.f25157b == null || i5 == null || !s.E(i5.b(), this.f25157b, true) || i5.e() != this.f25160e) {
            return false;
        }
        return true;
    }

    public final boolean O() {
        if (this.f25172q > 0) {
            return true;
        }
        return false;
    }

    public final boolean P() {
        if (this.f25172q == -1) {
            return true;
        }
        return false;
    }

    public final void R(Cursor cursor) {
        t.e(cursor, "c");
        this.f25156a = cursor.getInt(0);
        this.f25157b = cursor.getString(1);
        this.f25158c = cursor.getInt(2);
        this.f25159d = cursor.getInt(3);
        this.f25160e = cursor.getLong(4);
        this.f25161f = cursor.getString(5);
        this.f25162g = cursor.getInt(6);
        this.f25163h = cursor.getLong(7);
        this.f25164i = cursor.getInt(8);
        this.f25165j = cursor.getString(9);
        this.f25166k = cursor.getString(10);
        this.f25167l = cursor.getInt(11);
        this.f25168m = cursor.getString(12);
        this.f25169n = cursor.getString(13);
        this.f25170o = cursor.getLong(14);
        this.f25172q = cursor.getLong(15);
        this.f25173r = cursor.getInt(16);
    }

    public final int S(Context context) {
        t.e(context, "context");
        C2940B a5 = C2940B.f26458v.a(context);
        a5.a();
        String str = this.f25157b;
        t.b(str);
        C2668q k02 = a5.k0(str, this.f25160e);
        if (k02 == null) {
            k02 = a5.Q0(this);
        }
        a5.m();
        return k02.f25156a;
    }

    public final int T(Context context) {
        t.e(context, "context");
        C2940B a5 = C2940B.f26458v.a(context);
        a5.a();
        int A4 = a5.A(this);
        a5.m();
        return A4;
    }

    public final void U(Context context) {
        r rVar;
        t.e(context, "context");
        C2940B a5 = C2940B.f26458v.a(context);
        a5.a();
        this.f25159d = 1;
        a5.D1(this);
        String str = null;
        if (!this.f25177v.isEmpty()) {
            Iterator it = this.f25177v.iterator();
            t.d(it, "iterator(...)");
            rVar = null;
            while (it.hasNext()) {
                Object next = it.next();
                t.d(next, "next(...)");
                rVar = (r) next;
                new E().e(rVar.a());
                if (O()) {
                    rVar.k((String) null);
                    rVar.p(0);
                    rVar.l(0);
                    rVar.o(0);
                    a5.E1(rVar);
                }
            }
        } else {
            rVar = null;
        }
        a5.m();
        if (rVar != null) {
            str = rVar.a();
        }
        if (str != null) {
            String a6 = rVar.a();
            t.b(a6);
            File parentFile = new File(a6).getParentFile();
            if (parentFile != null && parentFile.exists() && parentFile.isDirectory()) {
                String[] list = parentFile.list();
                if (list == null || list.length == 0) {
                    parentFile.delete();
                }
            }
        }
    }

    public final void V(long j5) {
        this.f25163h = j5;
    }

    public final void W(String str) {
        this.f25169n = str;
    }

    public final void X() {
        this.f25159d = 0;
    }

    public final void Y(int i5) {
        this.f25173r = i5;
    }

    public final void Z(int i5) {
        this.f25164i = i5;
    }

    public final void a0(ArrayList arrayList) {
        t.e(arrayList, "<set-?>");
        this.f25177v = arrayList;
    }

    public final boolean b() {
        if (this.f25177v.isEmpty()) {
            return false;
        }
        Iterator it = this.f25177v.iterator();
        t.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            t.d(next, "next(...)");
            r rVar = (r) next;
            if (rVar.a() != null) {
                String a5 = rVar.a();
                t.b(a5);
                File file = new File(a5);
                if (file.exists()) {
                    if (rVar.h() != file.length()) {
                    }
                }
            }
            return false;
        }
        return true;
    }

    public final void b0(Drawable drawable) {
        this.f25176u = drawable;
    }

    public final void c(C2657f fVar) {
        String q02;
        t.e(fVar, "appInfo");
        this.f25157b = fVar.S();
        this.f25163h = fVar.e();
        this.f25169n = fVar.N();
        if (this.f25165j == null) {
            this.f25165j = fVar.L();
        }
        if (!fVar.j().isEmpty()) {
            this.f25177v = fVar.j();
        } else {
            r rVar = new r();
            if (rVar.e() == null) {
                rVar.n(fVar.n0());
            }
            if (rVar.d() < 0) {
                rVar.m(fVar.A());
            }
            if (!(rVar.i() > 0 || (q02 = fVar.q0()) == null || q02.length() == 0)) {
                try {
                    String q03 = fVar.q0();
                    t.b(q03);
                    rVar.q(Long.parseLong(q03));
                } catch (NumberFormatException e5) {
                    e5.printStackTrace();
                }
            }
            ArrayList arrayList = new ArrayList();
            this.f25177v = arrayList;
            arrayList.add(rVar);
        }
        this.f25168m = fVar.G();
        this.f25171p = fVar.s0();
        if (!H.f26488a.f()) {
            this.f25164i = 1;
        }
        if (this.f25160e <= 0) {
            if (fVar.A0() > 0) {
                this.f25160e = fVar.A0();
            } else if (fVar.J() > 0) {
                this.f25160e = fVar.J();
            }
        }
        this.f25161f = fVar.B0();
        this.f25166k = null;
        if (fVar.r0() != null) {
            ArrayList r02 = fVar.r0();
            t.b(r02);
            if (r02.size() > 0) {
                ArrayList r03 = fVar.r0();
                t.b(r03);
                int size = r03.size();
                for (int i5 = 0; i5 < size; i5++) {
                    String str = this.f25166k;
                    if (str == null) {
                        ArrayList r04 = fVar.r0();
                        t.b(r04);
                        this.f25166k = (String) r04.get(i5);
                    } else {
                        Q q5 = Q.f24695a;
                        ArrayList r05 = fVar.r0();
                        t.b(r05);
                        String format = String.format("%s,%s", Arrays.copyOf(new Object[]{str, r05.get(i5)}, 2));
                        t.d(format, "format(...)");
                        this.f25166k = format;
                    }
                }
            }
        }
        if (fVar.M() != null) {
            try {
                String M4 = fVar.M();
                t.b(M4);
                this.f25167l = Integer.parseInt(M4);
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    public final void c0(int i5) {
        this.f25156a = i5;
    }

    public final void d(C2657f fVar, C2643C c5) {
        t.e(fVar, "appInfo");
        t.e(c5, "oldVersion");
        this.f25157b = fVar.S();
        this.f25163h = fVar.e();
        this.f25169n = fVar.N();
        this.f25168m = fVar.E();
        this.f25165j = fVar.L();
        this.f25160e = c5.h();
        this.f25161f = c5.i();
        if (s.E(c5.c(), "apk", true)) {
            this.f25177v = new ArrayList();
            r rVar = new r();
            String b5 = c5.b();
            t.b(b5);
            rVar.m(Long.parseLong(b5));
            rVar.q(c5.g());
            this.f25177v.add(rVar);
            return;
        }
        this.f25177v = c5.a();
    }

    public final void d0(int i5) {
        this.f25159d = i5;
    }

    public int describeContents() {
        return hashCode();
    }

    public final void e(C2655d dVar, T t5) {
        t.e(dVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
        t.e(t5, "update");
        this.f25157b = t5.h();
        this.f25163h = dVar.b();
        this.f25169n = dVar.m();
        this.f25165j = dVar.k();
        this.f25160e = t5.j();
        this.f25161f = t5.k();
        if (t5.d() == -1) {
            this.f25172q = 0;
        } else {
            this.f25172q = t5.d();
        }
    }

    public final void e0(String str) {
        this.f25157b = str;
    }

    public final boolean f() {
        if (this.f25159d == 0) {
            return true;
        }
        return false;
    }

    public final void f0(long j5) {
        this.f25172q = j5;
    }

    public final void g() {
        if (!this.f25177v.isEmpty()) {
            Iterator it = this.f25177v.iterator();
            t.d(it, "iterator(...)");
            String str = null;
            r rVar = null;
            while (it.hasNext()) {
                Object next = it.next();
                t.d(next, "next(...)");
                rVar = (r) next;
                new E().e(rVar.a());
            }
            if (rVar != null) {
                str = rVar.a();
            }
            if (str != null) {
                String a5 = rVar.a();
                t.b(a5);
                File parentFile = new File(a5).getParentFile();
                if (parentFile != null && parentFile.exists() && parentFile.isDirectory()) {
                    String[] list = parentFile.list();
                    if (list == null || list.length == 0) {
                        parentFile.delete();
                    }
                }
            }
        }
    }

    public final void g0(String str) {
        this.f25168m = str;
    }

    public final long h() {
        return this.f25163h;
    }

    public final void h0(long j5) {
        this.f25160e = j5;
    }

    public final String i() {
        return this.f25169n;
    }

    public final int j() {
        return this.f25162g;
    }

    public final int k() {
        return this.f25158c;
    }

    public final int l() {
        return this.f25164i;
    }

    public final File m(Context context) {
        String str;
        t.e(context, "context");
        if (!this.f25177v.isEmpty()) {
            str = ((r) this.f25177v.get(0)).a();
        } else {
            str = null;
        }
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                return file;
            }
        }
        return null;
    }

    public final File n() {
        if (this.f25177v.size() == 1 && ((r) this.f25177v.get(0)).a() != null) {
            String a5 = ((r) this.f25177v.get(0)).a();
            t.b(a5);
            return new File(a5);
        } else if (this.f25177v.size() <= 1 || ((r) this.f25177v.get(0)).a() == null) {
            return null;
        } else {
            String a6 = ((r) this.f25177v.get(0)).a();
            t.b(a6);
            return new File(a6).getParentFile();
        }
    }

    public final ArrayList o() {
        return this.f25177v;
    }

    public final Drawable p() {
        return this.f25176u;
    }

    public final int q() {
        return this.f25156a;
    }

    public final int r() {
        return this.f25159d;
    }

    public final void s(Context context, File file) {
        t.e(context, "context");
        t.e(file, "file");
        if (this.f25157b != null) {
            long j5 = this.f25160e;
            if (j5 > 0) {
                this.f25174s = j5;
                Q(context);
                return;
            }
            String name = file.getName();
            t.d(name, "getName(...)");
            if (s.D(name, ".apk", false, 2, (Object) null)) {
                try {
                    PackageManager packageManager = context.getPackageManager();
                    t.d(packageManager, "getPackageManager(...)");
                    String absolutePath = file.getAbsolutePath();
                    t.d(absolutePath, "getAbsolutePath(...)");
                    PackageInfo c5 = C2301u.c(packageManager, absolutePath, 128);
                    if (c5 != null) {
                        this.f25174s = new C2290j().m(c5);
                    }
                    if (c5 != null && s.F(this.f25157b, c5.packageName, false, 2, (Object) null)) {
                        Q(context);
                    }
                } catch (Exception unused) {
                }
            }
        }
    }

    public final String t() {
        return this.f25165j;
    }

    public String toString() {
        return "{id='" + this.f25156a + "', packagename='" + this.f25157b + "', checkedByUser=" + this.f25158c + ", incomplete=" + this.f25159d + ", versioncode='" + this.f25160e + "', versionname='" + this.f25161f + "', attempts=" + this.f25162g + ", appId=" + this.f25163h + ", downloadAnyway=" + this.f25164i + ", md5signature='" + this.f25165j + "', supportedAbis='" + this.f25166k + "', minsdk=" + this.f25167l + ", urlIcon='" + this.f25168m + "', appName='" + this.f25169n + "', versioncodeFile=" + this.f25174s + ", versioncodeInstalled=" + this.f25175t + ", nextAttemptTimeStamp=" + this.f25170o + ", updateId=" + this.f25172q + ", isDeepLink=" + this.f25173r + ", files=" + this.f25177v + '}';
    }

    public final int u() {
        return this.f25167l;
    }

    public final long v() {
        return this.f25170o;
    }

    public final String w() {
        return this.f25157b;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        t.e(parcel, "parcel");
        parcel.writeInt(this.f25156a);
        parcel.writeString(this.f25157b);
        parcel.writeInt(this.f25158c);
        parcel.writeInt(this.f25159d);
        parcel.writeLong(this.f25160e);
        parcel.writeString(this.f25161f);
        parcel.writeInt(this.f25162g);
        parcel.writeLong(this.f25163h);
        parcel.writeInt(this.f25164i);
        parcel.writeString(this.f25165j);
        parcel.writeString(this.f25166k);
        parcel.writeInt(this.f25167l);
        parcel.writeString(this.f25168m);
        parcel.writeString(this.f25169n);
        parcel.writeLong(this.f25170o);
        parcel.writeStringList(this.f25171p);
        parcel.writeTypedList(this.f25177v);
        parcel.writeLong(this.f25172q);
        parcel.writeInt(this.f25173r);
    }

    public final int x() {
        long j5;
        long j6;
        if (!this.f25177v.isEmpty()) {
            Iterator it = this.f25177v.iterator();
            t.d(it, "iterator(...)");
            j6 = 0;
            j5 = 0;
            while (it.hasNext()) {
                Object next = it.next();
                t.d(next, "next(...)");
                r rVar = (r) next;
                j6 += rVar.i();
                j5 += rVar.h();
            }
        } else {
            j6 = 0;
            j5 = 0;
        }
        if (j5 <= 0 || j6 <= 0) {
            return 0;
        }
        return (int) ((((double) j5) * 100.0d) / ((double) j6));
    }

    public final long y() {
        long j5 = 0;
        if (!this.f25177v.isEmpty()) {
            Iterator it = this.f25177v.iterator();
            t.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                t.d(next, "next(...)");
                j5 += ((r) next).h();
            }
        }
        return j5;
    }

    public final long z() {
        long j5 = 0;
        if (!this.f25177v.isEmpty()) {
            Iterator it = this.f25177v.iterator();
            t.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                t.d(next, "next(...)");
                j5 += ((r) next).i();
            }
        }
        return j5;
    }

    public C2668q(Parcel parcel) {
        t.e(parcel, "source");
        this.f25156a = parcel.readInt();
        this.f25157b = parcel.readString();
        this.f25158c = parcel.readInt();
        this.f25159d = parcel.readInt();
        this.f25160e = parcel.readLong();
        this.f25161f = parcel.readString();
        this.f25162g = parcel.readInt();
        this.f25163h = parcel.readLong();
        this.f25164i = parcel.readInt();
        this.f25165j = parcel.readString();
        this.f25166k = parcel.readString();
        this.f25167l = parcel.readInt();
        this.f25168m = parcel.readString();
        this.f25169n = parcel.readString();
        this.f25170o = parcel.readLong();
        this.f25171p = parcel.createStringArrayList();
        parcel.readTypedList(this.f25177v, r.CREATOR);
        this.f25172q = parcel.readLong();
        this.f25173r = parcel.readInt();
    }
}
