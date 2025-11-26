package z2;

import X2.C2250q;
import a3.C2265a;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Environment;
import b2.C2289i;
import b2.C2290j;
import b2.C2301u;
import java.io.File;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.jvm.internal.C2633k;
import kotlin.jvm.internal.t;
import l2.C2661j;
import l2.C2668q;
import l2.T;
import l2.r;
import t3.s;

public final class E {

    /* renamed from: a  reason: collision with root package name */
    public static final a f26482a = new a((C2633k) null);

    public static final class a {
        public /* synthetic */ a(C2633k kVar) {
            this();
        }

        private a() {
        }
    }

    public static final class b implements Comparator {
        public final int compare(Object obj, Object obj2) {
            return C2265a.a(Long.valueOf(((File) obj2).lastModified()), Long.valueOf(((File) obj).lastModified()));
        }
    }

    public final ArrayList a() {
        File[] listFiles;
        ArrayList arrayList = new ArrayList();
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        if (externalStoragePublicDirectory.exists() && externalStoragePublicDirectory.canRead() && externalStoragePublicDirectory.isDirectory() && (listFiles = externalStoragePublicDirectory.listFiles()) != null) {
            for (File file : listFiles) {
                C2289i iVar = new C2289i();
                String name = file.getName();
                t.d(name, "getName(...)");
                if (iVar.p(name)) {
                    arrayList.add(file);
                }
            }
        }
        return arrayList;
    }

    public final void b(Context context) {
        t.e(context, "context");
        C2940B a5 = C2940B.f26458v.a(context);
        a5.a();
        ArrayList p02 = a5.p0();
        a5.m();
        Iterator it = new E().f(context).iterator();
        t.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            t.d(next, "next(...)");
            File file = (File) next;
            Iterator it2 = p02.iterator();
            t.d(it2, "iterator(...)");
            boolean z4 = false;
            while (it2.hasNext()) {
                Object next2 = it2.next();
                t.d(next2, "next(...)");
                C2668q qVar = (C2668q) next2;
                if (qVar.P() && !qVar.o().isEmpty()) {
                    Iterator it3 = qVar.o().iterator();
                    t.d(it3, "iterator(...)");
                    while (true) {
                        if (!it3.hasNext()) {
                            break;
                        }
                        Object next3 = it3.next();
                        t.d(next3, "next(...)");
                        if (s.F(((r) next3).a(), file.getAbsolutePath(), false, 2, (Object) null)) {
                            z4 = true;
                            break;
                        }
                    }
                }
            }
            if (!z4) {
                file.delete();
            }
        }
    }

    public final void c(Context context) {
        t.e(context, "context");
        C2940B a5 = C2940B.f26458v.a(context);
        a5.a();
        ArrayList I02 = a5.I0();
        a5.m();
        Iterator it = new E().g(context).iterator();
        t.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            t.d(next, "next(...)");
            File file = (File) next;
            Iterator it2 = I02.iterator();
            t.d(it2, "iterator(...)");
            boolean z4 = false;
            while (it2.hasNext()) {
                Object next2 = it2.next();
                t.d(next2, "next(...)");
                T t5 = (T) next2;
                if (!t5.m() && t5.a() != null) {
                    C2668q a6 = t5.a();
                    t.b(a6);
                    if (!a6.o().isEmpty()) {
                        C2668q a7 = t5.a();
                        t.b(a7);
                        Iterator it3 = a7.o().iterator();
                        t.d(it3, "iterator(...)");
                        while (true) {
                            if (!it3.hasNext()) {
                                break;
                            }
                            Object next3 = it3.next();
                            t.d(next3, "next(...)");
                            if (s.F(((r) next3).a(), file.getAbsolutePath(), false, 2, (Object) null)) {
                                z4 = true;
                                break;
                            }
                        }
                    }
                }
            }
            if (!z4) {
                file.delete();
            }
        }
    }

    public final ArrayList d(Context context) {
        t.e(context, "context");
        ArrayList arrayList = new ArrayList();
        ArrayList l5 = l(context);
        C2940B a5 = C2940B.f26458v.a(context);
        a5.a();
        ArrayList e02 = a5.e0();
        Iterator it = l5.iterator();
        t.d(it, "iterator(...)");
        while (it.hasNext()) {
            Object next = it.next();
            t.d(next, "next(...)");
            File file = (File) next;
            Iterator it2 = e02.iterator();
            t.d(it2, "iterator(...)");
            boolean z4 = false;
            while (it2.hasNext()) {
                Object next2 = it2.next();
                t.d(next2, "next(...)");
                if (s.E(((C2661j) next2).e(), file.getAbsolutePath(), true)) {
                    z4 = true;
                }
            }
            if (!z4) {
                String name = file.getName();
                t.d(name, "getName(...)");
                String k5 = k(name);
                if (!(k5 == null || k5.length() == 0)) {
                    arrayList.add(file);
                    C2661j jVar = new C2661j();
                    jVar.h(file.getAbsolutePath());
                    jVar.f(String.valueOf(file.lastModified()));
                    a5.P0(jVar);
                    file.delete();
                }
            }
        }
        a5.m();
        return arrayList;
    }

    public final void e(String str) {
        if (str != null) {
            try {
                File file = new File(str);
                if (file.exists()) {
                    file.delete();
                }
            } catch (Exception e5) {
                e5.printStackTrace();
            }
        }
    }

    public final ArrayList f(Context context) {
        t.e(context, "context");
        return new C2289i().m(h(context), context);
    }

    public final ArrayList g(Context context) {
        t.e(context, "context");
        return new C2289i().m(i(context), context);
    }

    public final File h(Context context) {
        t.e(context, "context");
        return new C2290j().a(context, "Apps");
    }

    public final File i(Context context) {
        t.e(context, "context");
        return new C2290j().a(context, "Updates");
    }

    public final File j(Context context) {
        t.e(context, "context");
        ArrayList l5 = l(context);
        int size = l5.size();
        if (size == 0) {
            return null;
        }
        if (size == 1) {
            return (File) l5.get(0);
        }
        if (l5.size() > 1) {
            C2250q.t(l5, new b());
        }
        return (File) l5.get(0);
    }

    public final String k(String str) {
        int l02;
        t.e(str, "fileNameParam");
        String str2 = "uptodown" + "-";
        if (s.P(str, str2, false, 2, (Object) null)) {
            String str3 = str;
            String str4 = str3;
            if (s.G0(str3, new String[]{"-"}, false, 0, 6, (Object) null).size() == 2) {
                int f02 = s.f0(str4, " ", 0, false, 6, (Object) null);
                if (f02 > 0) {
                    String substring = str4.substring(0, f02);
                    t.d(substring, "substring(...)");
                    str4 = substring + ".apk";
                }
                if (s.V(str4, "(", false, 2, (Object) null) && s.C(str4, ").apk", true)) {
                    String substring2 = str4.substring(0, s.f0(str4, "(", 0, false, 6, (Object) null));
                    t.d(substring2, "substring(...)");
                    String substring3 = substring2.substring(str2.length());
                    t.d(substring3, "substring(...)");
                    return substring3;
                } else if (s.C(str4, ".apk", true) && (l02 = s.l0(str4, ".apk", 0, false, 6, (Object) null)) > 0 && str4.length() == l02 + 4) {
                    String substring4 = str4.substring(0, l02);
                    t.d(substring4, "substring(...)");
                    String substring5 = substring4.substring(str2.length());
                    t.d(substring5, "substring(...)");
                    return substring5;
                }
            }
        }
        return null;
    }

    public final ArrayList l(Context context) {
        t.e(context, "context");
        ArrayList arrayList = new ArrayList();
        PackageManager packageManager = context.getPackageManager();
        File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        if (externalStoragePublicDirectory.exists() && externalStoragePublicDirectory.canRead() && externalStoragePublicDirectory.isDirectory()) {
            C2289i iVar = new C2289i();
            t.b(externalStoragePublicDirectory);
            Iterator it = iVar.m(externalStoragePublicDirectory, context).iterator();
            t.d(it, "iterator(...)");
            while (it.hasNext()) {
                Object next = it.next();
                t.d(next, "next(...)");
                File file = (File) next;
                String name = file.getName();
                t.d(name, "getName(...)");
                if (s.C(name, ".apk", true)) {
                    t.b(packageManager);
                    String absolutePath = file.getAbsolutePath();
                    t.d(absolutePath, "getAbsolutePath(...)");
                    PackageInfo c5 = C2301u.c(packageManager, absolutePath, 128);
                    if (c5 != null && c5.packageName.equals("com.uptodown")) {
                        arrayList.add(file);
                    }
                }
            }
        }
        return arrayList;
    }

    public final long m(Context context, File file) {
        t.e(context, "context");
        t.e(file, "storageDir");
        ArrayList l5 = new C2962v().l(context);
        int size = l5.size();
        long j5 = 0;
        int i5 = 0;
        while (i5 < size) {
            Object obj = l5.get(i5);
            i5++;
            j5 += ((C2668q) obj).z();
        }
        return file.getUsableSpace() - j5;
    }
}
