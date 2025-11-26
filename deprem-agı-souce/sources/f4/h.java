package f4;

import W2.C2223l;
import W2.m;
import W2.y;
import X2.C2250q;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.mbridge.msdk.MBridgeConstans;
import e4.C2360i;
import e4.C2361j;
import e4.C2362k;
import e4.Q;
import e4.Z;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.List;
import k3.C2616a;
import k3.l;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import kotlin.jvm.internal.u;
import t3.s;

public final class h extends C2362k {
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final a f21639f = new a((C2633k) null);
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final Q f21640g = Q.a.e(Q.f21501b, "/", false, 1, (Object) null);

    /* renamed from: e  reason: collision with root package name */
    private final C2223l f21641e;

    private static final class a {

        /* renamed from: f4.h$a$a  reason: collision with other inner class name */
        static final class C0223a extends u implements l {

            /* renamed from: a  reason: collision with root package name */
            public static final C0223a f21642a = new C0223a();

            C0223a() {
                super(1);
            }

            /* renamed from: a */
            public final Boolean invoke(i iVar) {
                t.e(iVar, "entry");
                return Boolean.valueOf(h.f21639f.c(iVar.a()));
            }
        }

        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        /* access modifiers changed from: private */
        public final boolean c(Q q5) {
            return !s.C(q5.e(), ".class", true);
        }

        public final Q b() {
            return h.f21640g;
        }

        public final List d(ClassLoader classLoader) {
            t.e(classLoader, "<this>");
            Enumeration<URL> resources = classLoader.getResources("");
            t.d(resources, "getResources(\"\")");
            ArrayList<T> list = Collections.list(resources);
            t.d(list, "list(this)");
            ArrayList arrayList = new ArrayList();
            int size = list.size();
            int i5 = 0;
            int i6 = 0;
            while (i6 < size) {
                T t5 = list.get(i6);
                i6++;
                URL url = (URL) t5;
                a m5 = h.f21639f;
                t.d(url, "it");
                W2.s e5 = m5.e(url);
                if (e5 != null) {
                    arrayList.add(e5);
                }
            }
            Enumeration<URL> resources2 = classLoader.getResources("META-INF/MANIFEST.MF");
            t.d(resources2, "getResources(\"META-INF/MANIFEST.MF\")");
            ArrayList<T> list2 = Collections.list(resources2);
            t.d(list2, "list(this)");
            ArrayList arrayList2 = new ArrayList();
            int size2 = list2.size();
            while (i5 < size2) {
                T t6 = list2.get(i5);
                i5++;
                URL url2 = (URL) t6;
                a m6 = h.f21639f;
                t.d(url2, "it");
                W2.s f5 = m6.f(url2);
                if (f5 != null) {
                    arrayList2.add(f5);
                }
            }
            return C2250q.b0(arrayList, arrayList2);
        }

        public final W2.s e(URL url) {
            t.e(url, "<this>");
            if (!t.a(url.getProtocol(), "file")) {
                return null;
            }
            return y.a(C2362k.f21590b, Q.a.d(Q.f21501b, new File(url.toURI()), false, 1, (Object) null));
        }

        public final W2.s f(URL url) {
            int l02;
            t.e(url, "<this>");
            String url2 = url.toString();
            t.d(url2, "toString()");
            if (!s.P(url2, "jar:file:", false, 2, (Object) null) || (l02 = s.l0(url2, "!", 0, false, 6, (Object) null)) == -1) {
                return null;
            }
            Q.a aVar = Q.f21501b;
            String substring = url2.substring(4, l02);
            t.d(substring, "this as java.lang.String…ing(startIndex, endIndex)");
            return y.a(j.d(Q.a.d(aVar, new File(URI.create(substring)), false, 1, (Object) null), C2362k.f21590b, C0223a.f21642a), b());
        }

        private a() {
        }
    }

    static final class b extends u implements C2616a {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ClassLoader f21643a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        b(ClassLoader classLoader) {
            super(0);
            this.f21643a = classLoader;
        }

        /* renamed from: a */
        public final List invoke() {
            return h.f21639f.d(this.f21643a);
        }
    }

    public h(ClassLoader classLoader, boolean z4) {
        t.e(classLoader, "classLoader");
        this.f21641e = m.b(new b(classLoader));
        if (z4) {
            p().size();
        }
    }

    private final Q o(Q q5) {
        return f21640g.j(q5, true);
    }

    private final List p() {
        return (List) this.f21641e.getValue();
    }

    private final String q(Q q5) {
        return o(q5).i(f21640g).toString();
    }

    public void a(Q q5, Q q6) {
        t.e(q5, "source");
        t.e(q6, TypedValues.AttributesType.S_TARGET);
        throw new IOException(this + " is read-only");
    }

    public void d(Q q5, boolean z4) {
        t.e(q5, "dir");
        throw new IOException(this + " is read-only");
    }

    public void f(Q q5, boolean z4) {
        t.e(q5, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        throw new IOException(this + " is read-only");
    }

    public C2361j h(Q q5) {
        t.e(q5, MBridgeConstans.DYNAMIC_VIEW_WX_PATH);
        if (!f21639f.c(q5)) {
            return null;
        }
        String q6 = q(q5);
        for (W2.s sVar : p()) {
            C2361j h5 = ((C2362k) sVar.a()).h(((Q) sVar.b()).k(q6));
            if (h5 != null) {
                return h5;
            }
        }
        return null;
    }

    public C2360i i(Q q5) {
        t.e(q5, "file");
        if (f21639f.c(q5)) {
            String q6 = q(q5);
            for (W2.s sVar : p()) {
                try {
                    return ((C2362k) sVar.a()).i(((Q) sVar.b()).k(q6));
                } catch (FileNotFoundException unused) {
                }
            }
            throw new FileNotFoundException("file not found: " + q5);
        }
        throw new FileNotFoundException("file not found: " + q5);
    }

    public C2360i k(Q q5, boolean z4, boolean z5) {
        t.e(q5, "file");
        throw new IOException("resources are not writable");
    }

    public Z l(Q q5) {
        t.e(q5, "file");
        if (f21639f.c(q5)) {
            String q6 = q(q5);
            for (W2.s sVar : p()) {
                try {
                    return ((C2362k) sVar.a()).l(((Q) sVar.b()).k(q6));
                } catch (FileNotFoundException unused) {
                }
            }
            throw new FileNotFoundException("file not found: " + q5);
        }
        throw new FileNotFoundException("file not found: " + q5);
    }
}
