package l2;

import android.content.Context;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import b2.C2290j;
import com.mbridge.msdk.MBridgeConstans;
import com.uptodown.UptodownApp;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.r;
import org.json.JSONArray;
import org.json.JSONObject;
import t3.s;
import z2.C2940B;

public final class T implements Parcelable {
    public static Parcelable.Creator<T> CREATOR = new a();

    /* renamed from: k  reason: collision with root package name */
    public static final b f24856k = new b((C2633k) null);

    /* renamed from: a  reason: collision with root package name */
    private long f24857a = -1;

    /* renamed from: b  reason: collision with root package name */
    private String f24858b;

    /* renamed from: c  reason: collision with root package name */
    private long f24859c = -1;

    /* renamed from: d  reason: collision with root package name */
    private String f24860d;

    /* renamed from: e  reason: collision with root package name */
    private int f24861e;

    /* renamed from: f  reason: collision with root package name */
    private int f24862f;

    /* renamed from: g  reason: collision with root package name */
    private int f24863g;

    /* renamed from: h  reason: collision with root package name */
    private String f24864h;

    /* renamed from: i  reason: collision with root package name */
    private C2668q f24865i;

    /* renamed from: j  reason: collision with root package name */
    private ArrayList f24866j;

    public static final class a implements Parcelable.Creator {
        a() {
        }

        /* renamed from: a */
        public T createFromParcel(Parcel parcel) {
            t.e(parcel, "source");
            return new T(parcel);
        }

        /* renamed from: b */
        public T[] newArray(int i5) {
            return new T[i5];
        }
    }

    public static final class b {
        public /* synthetic */ b(C2633k kVar) {
            this();
        }

        public final int a(Context context) {
            t.e(context, "context");
            return b(context).size();
        }

        public final ArrayList b(Context context) {
            C2655d Y4;
            t.e(context, "context");
            C2940B a5 = C2940B.f26458v.a(context);
            a5.a();
            ArrayList arrayList = new ArrayList();
            Iterator it = a5.I0().iterator();
            t.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                t.d(next, "next(...)");
                T t5 = (T) next;
                if (!new C2290j().p(context, t5.h())) {
                    if (!s.E(t5.h(), context.getPackageName(), true) || t5.j() <= 0) {
                        if (!t5.m() && (Y4 = a5.Y(t5.h())) != null && Y4.e() == 0 && Y4.C(context)) {
                            arrayList.add(t5);
                        }
                    } else if (t5.j() > 694) {
                        arrayList.add(t5);
                    }
                }
            }
            a5.m();
            return arrayList;
        }

        public final T c(C2655d dVar, JSONObject jSONObject) {
            t.e(dVar, MBridgeConstans.DYNAMIC_VIEW_WX_APP);
            t.e(jSONObject, "jsonObject");
            if (jSONObject.isNull("packagename")) {
                return null;
            }
            String optString = jSONObject.optString("packagename");
            t.b(optString);
            T t5 = new T(optString);
            if (!jSONObject.isNull("versionName")) {
                t5.w(jSONObject.optString("versionName"));
            }
            if (!jSONObject.isNull("versionCode")) {
                t5.v(jSONObject.optLong("versionCode"));
            }
            JSONArray optJSONArray = jSONObject.optJSONArray("requiredFeatures");
            if (optJSONArray != null) {
                ArrayList arrayList = new ArrayList();
                int length = optJSONArray.length();
                for (int i5 = 0; i5 < length; i5++) {
                    arrayList.add(optJSONArray.getString(i5));
                }
                t5.u(arrayList);
            }
            C2668q qVar = new C2668q();
            qVar.e(dVar, t5);
            JSONArray optJSONArray2 = jSONObject.optJSONArray("containedFiles");
            if (optJSONArray2 == null) {
                optJSONArray2 = jSONObject.optJSONArray("files");
            }
            if (optJSONArray2 != null) {
                int length2 = optJSONArray2.length();
                for (int i6 = 0; i6 < length2; i6++) {
                    JSONObject jSONObject2 = optJSONArray2.getJSONObject(i6);
                    r.b bVar = r.f25178k;
                    t.b(jSONObject2);
                    qVar.o().add(bVar.a(jSONObject2));
                    t5.o(qVar);
                }
            } else {
                r rVar = new r();
                if (!jSONObject.isNull("size")) {
                    rVar.q(jSONObject.optLong("size"));
                }
                if (!jSONObject.isNull("fileID")) {
                    String optString2 = jSONObject.optString("fileID");
                    try {
                        t.b(optString2);
                        rVar.m(Long.parseLong(optString2));
                    } catch (NumberFormatException e5) {
                        e5.printStackTrace();
                    }
                    qVar.o().add(rVar);
                    t5.o(qVar);
                }
            }
            return t5;
        }

        private b() {
        }
    }

    public T(String str) {
        t.e(str, "packagename");
        this.f24858b = str;
    }

    public final C2668q a() {
        return this.f24865i;
    }

    public final C2668q b(Context context) {
        t.e(context, "context");
        C2940B a5 = C2940B.f26458v.a(context);
        a5.a();
        C2668q qVar = this.f24865i;
        if (qVar != null) {
            t.b(qVar);
            if (qVar.q() >= 0) {
                C2668q qVar2 = this.f24865i;
                t.b(qVar2);
                this.f24865i = a5.i0(qVar2.q());
                a5.m();
                return this.f24865i;
            }
        }
        this.f24865i = a5.k0(this.f24858b, this.f24859c);
        a5.m();
        return this.f24865i;
    }

    public final boolean c() {
        return UptodownApp.f13477F.N(this);
    }

    public final long d() {
        return this.f24857a;
    }

    public int describeContents() {
        return hashCode();
    }

    public final int e() {
        return this.f24862f;
    }

    public final String f() {
        return this.f24864h;
    }

    public final int g() {
        return this.f24861e;
    }

    public final String h() {
        return this.f24858b;
    }

    public final ArrayList i() {
        return this.f24866j;
    }

    public final long j() {
        return this.f24859c;
    }

    public final String k() {
        return this.f24860d;
    }

    public final boolean l(T t5) {
        boolean z4;
        Integer num;
        ArrayList o5;
        ArrayList o6;
        t.e(t5, "anotherUpdate");
        if (this.f24859c == t5.f24859c) {
            z4 = true;
        } else {
            z4 = false;
        }
        C2668q qVar = this.f24865i;
        Integer num2 = null;
        if (qVar == null || (o6 = qVar.o()) == null) {
            num = null;
        } else {
            num = Integer.valueOf(o6.size());
        }
        C2668q qVar2 = t5.f24865i;
        if (!(qVar2 == null || (o5 = qVar2.o()) == null)) {
            num2 = Integer.valueOf(o5.size());
        }
        boolean a5 = t.a(num, num2);
        boolean E4 = s.E(this.f24860d, t5.f24860d, true);
        if (!z4 || !a5 || !E4) {
            return true;
        }
        if (this.f24865i == null || t5.f24865i == null) {
            return false;
        }
        ArrayList arrayList = new ArrayList();
        C2668q qVar3 = this.f24865i;
        t.b(qVar3);
        arrayList.addAll(qVar3.o());
        ArrayList arrayList2 = new ArrayList();
        C2668q qVar4 = t5.f24865i;
        t.b(qVar4);
        arrayList2.addAll(qVar4.o());
        C2668q qVar5 = this.f24865i;
        t.b(qVar5);
        Iterator it = qVar5.o().iterator();
        t.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            t.d(next, "next(...)");
            r rVar = (r) next;
            C2668q qVar6 = t5.f24865i;
            t.b(qVar6);
            Iterator it2 = qVar6.o().iterator();
            t.d(it2, "iterator(...)");
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                Object next2 = it2.next();
                t.d(next2, "next(...)");
                r rVar2 = (r) next2;
                if (rVar2.d() == rVar.d()) {
                    arrayList.remove(rVar);
                    arrayList2.remove(rVar2);
                    break;
                }
            }
        }
        if (!arrayList.isEmpty() || !arrayList2.isEmpty()) {
            return true;
        }
        return false;
    }

    public final boolean m() {
        int i5 = this.f24862f;
        if (i5 == 1 || i5 == 2) {
            return true;
        }
        return false;
    }

    public final int n() {
        return this.f24863g;
    }

    public final void o(C2668q qVar) {
        this.f24865i = qVar;
    }

    public final void p(long j5) {
        this.f24857a = j5;
    }

    public final void q(int i5) {
        this.f24862f = i5;
    }

    public final void r(String str) {
        this.f24864h = str;
    }

    public final void s(int i5) {
        this.f24861e = i5;
    }

    public final void t(int i5) {
        this.f24863g = i5;
    }

    public String toString() {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("{id=");
        sb.append(this.f24857a);
        sb.append(", packagename='");
        sb.append(this.f24858b);
        sb.append("', versionCode=");
        sb.append(this.f24859c);
        sb.append(", versionName='");
        sb.append(this.f24860d);
        sb.append("', notified=");
        sb.append(this.f24861e);
        sb.append(", ignoreVersion=");
        sb.append(this.f24862f);
        sb.append(", isPartialUpdate=");
        sb.append(this.f24863g);
        sb.append(", newFeatures='");
        sb.append(this.f24864h);
        sb.append("', download=");
        C2668q qVar = this.f24865i;
        if (qVar != null) {
            str = qVar.toString();
        } else {
            str = null;
        }
        sb.append(str);
        sb.append('}');
        return sb.toString();
    }

    public final void u(ArrayList arrayList) {
        this.f24866j = arrayList;
    }

    public final void v(long j5) {
        this.f24859c = j5;
    }

    public final void w(String str) {
        this.f24860d = str;
    }

    public void writeToParcel(Parcel parcel, int i5) {
        t.e(parcel, "parcel");
        parcel.writeLong(this.f24857a);
        parcel.writeString(this.f24858b);
        parcel.writeLong(this.f24859c);
        parcel.writeString(this.f24860d);
        parcel.writeInt(this.f24861e);
        parcel.writeInt(this.f24862f);
        parcel.writeInt(this.f24863g);
        parcel.writeString(this.f24864h);
        parcel.writeParcelable(this.f24865i, i5);
    }

    public T(Parcel parcel) {
        t.e(parcel, "source");
        this.f24857a = parcel.readLong();
        String readString = parcel.readString();
        t.b(readString);
        this.f24858b = readString;
        this.f24859c = parcel.readLong();
        this.f24860d = parcel.readString();
        this.f24861e = parcel.readInt();
        this.f24862f = parcel.readInt();
        this.f24863g = parcel.readInt();
        this.f24864h = parcel.readString();
        Class<C2668q> cls = C2668q.class;
        if (Build.VERSION.SDK_INT >= 33) {
            this.f24865i = (C2668q) parcel.readParcelable(cls.getClassLoader(), cls);
        } else {
            this.f24865i = (C2668q) parcel.readParcelable(cls.getClassLoader());
        }
    }
}
