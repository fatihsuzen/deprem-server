package D0;

import A0.F;
import B0.j;
import androidx.core.app.NotificationCompat;
import com.mbridge.msdk.playercommon.exoplayer2.C;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.atomic.AtomicInteger;
import u0.g;
import x0.C1903A;
import x0.C1918n;
import z0.n;

public class e {

    /* renamed from: e  reason: collision with root package name */
    private static final Charset f2355e = Charset.forName(C.UTF8_NAME);

    /* renamed from: f  reason: collision with root package name */
    private static final int f2356f = 15;

    /* renamed from: g  reason: collision with root package name */
    private static final j f2357g = new j();

    /* renamed from: h  reason: collision with root package name */
    private static final Comparator f2358h = new a();

    /* renamed from: i  reason: collision with root package name */
    private static final FilenameFilter f2359i = new b();

    /* renamed from: a  reason: collision with root package name */
    private final AtomicInteger f2360a = new AtomicInteger(0);

    /* renamed from: b  reason: collision with root package name */
    private final g f2361b;

    /* renamed from: c  reason: collision with root package name */
    private final F0.j f2362c;

    /* renamed from: d  reason: collision with root package name */
    private final C1918n f2363d;

    public e(g gVar, F0.j jVar, C1918n nVar) {
        this.f2361b = gVar;
        this.f2362c = jVar;
        this.f2363d = nVar;
    }

    private void A(String str, long j5) {
        boolean z4;
        List r5 = this.f2361b.r(str, f2359i);
        if (r5.isEmpty()) {
            g.f().i("Session " + str + " has no events.");
            return;
        }
        Collections.sort(r5);
        ArrayList arrayList = new ArrayList();
        Iterator it = r5.iterator();
        loop0:
        while (true) {
            z4 = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                File file = (File) it.next();
                try {
                    arrayList.add(f2357g.j(y(file)));
                    if (z4 || s(file.getName())) {
                        z4 = true;
                    }
                } catch (IOException e5) {
                    g.f().l("Could not add event to report for " + file, e5);
                }
            }
        }
        if (arrayList.isEmpty()) {
            g.f().k("Could not parse event files for session " + str);
            return;
        }
        B(this.f2361b.q(str, "report"), arrayList, j5, z4, n.j(str, this.f2361b), this.f2363d.d(str));
    }

    private void B(File file, List list, long j5, boolean z4, String str, String str2) {
        File file2;
        try {
            j jVar = f2357g;
            F r5 = jVar.L(y(file)).v(j5, z4, str).p(str2).r(list);
            F.e n5 = r5.n();
            if (n5 != null) {
                g f5 = g.f();
                f5.b("appQualitySessionId: " + str2);
                if (z4) {
                    file2 = this.f2361b.l(n5.i());
                } else {
                    file2 = this.f2361b.n(n5.i());
                }
                D(file2, jVar.M(r5));
            }
        } catch (IOException e5) {
            g f6 = g.f();
            f6.l("Could not synthesize final report file for " + file, e5);
        }
    }

    private int C(String str, int i5) {
        List r5 = this.f2361b.r(str, new c());
        Collections.sort(r5, new d());
        return f(r5, i5);
    }

    private static void D(File file, String str) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), f2355e);
        try {
            outputStreamWriter.write(str);
            outputStreamWriter.close();
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private static void E(File file, String str, long j5) {
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream(file), f2355e);
        try {
            outputStreamWriter.write(str);
            file.setLastModified(h(j5));
            outputStreamWriter.close();
            return;
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    private SortedSet e(String str) {
        this.f2361b.d();
        SortedSet p5 = p();
        if (str != null) {
            p5.remove(str);
        }
        if (p5.size() > 8) {
            while (p5.size() > 8) {
                String str2 = (String) p5.last();
                g f5 = g.f();
                f5.b("Removing session over cap: " + str2);
                this.f2361b.e(str2);
                p5.remove(str2);
            }
        }
        return p5;
    }

    private static int f(List list, int i5) {
        int size = list.size();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            File file = (File) it.next();
            if (size <= i5) {
                break;
            }
            g.u(file);
            size--;
        }
        return size;
    }

    private void g() {
        int i5 = this.f2362c.b().f2421a.f2433b;
        List n5 = n();
        int size = n5.size();
        if (size > i5) {
            for (File delete : n5.subList(i5, size)) {
                delete.delete();
            }
        }
    }

    private static long h(long j5) {
        return j5 * 1000;
    }

    private void j(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            ((File) it.next()).delete();
        }
    }

    private static String m(int i5, boolean z4) {
        String str;
        String format = String.format(Locale.US, "%010d", new Object[]{Integer.valueOf(i5)});
        if (z4) {
            str = "_";
        } else {
            str = "";
        }
        return NotificationCompat.CATEGORY_EVENT + format + str;
    }

    private List n() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f2361b.m());
        arrayList.addAll(this.f2361b.j());
        Comparator comparator = f2358h;
        Collections.sort(arrayList, comparator);
        List o5 = this.f2361b.o();
        Collections.sort(o5, comparator);
        arrayList.addAll(o5);
        return arrayList;
    }

    private static String o(String str) {
        return str.substring(0, f2356f);
    }

    private static boolean s(String str) {
        if (!str.startsWith(NotificationCompat.CATEGORY_EVENT) || !str.endsWith("_")) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static boolean t(File file, String str) {
        if (!str.startsWith(NotificationCompat.CATEGORY_EVENT) || str.endsWith("_")) {
            return false;
        }
        return true;
    }

    /* access modifiers changed from: private */
    public static int v(File file, File file2) {
        return o(file.getName()).compareTo(o(file2.getName()));
    }

    private static String y(File file) {
        byte[] bArr = new byte[8192];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        FileInputStream fileInputStream = new FileInputStream(file);
        while (true) {
            try {
                int read = fileInputStream.read(bArr);
                if (read > 0) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    String str = new String(byteArrayOutputStream.toByteArray(), f2355e);
                    fileInputStream.close();
                    return str;
                }
            } catch (Throwable th) {
                th.addSuppressed(th);
            }
        }
        throw th;
    }

    private void z(File file, F.d dVar, String str, F.a aVar) {
        String d5 = this.f2363d.d(str);
        try {
            j jVar = f2357g;
            D(this.f2361b.i(str), jVar.M(jVar.L(y(file)).u(dVar).q(aVar).p(d5)));
        } catch (IOException e5) {
            g f5 = g.f();
            f5.l("Could not synthesize final native report file for " + file, e5);
        }
    }

    public void i() {
        j(this.f2361b.o());
        j(this.f2361b.m());
        j(this.f2361b.j());
    }

    public void k(String str, long j5) {
        for (String str2 : e(str)) {
            g f5 = g.f();
            f5.i("Finalizing report for session " + str2);
            A(str2, j5);
            this.f2361b.e(str2);
        }
        g();
    }

    public void l(String str, F.d dVar, F.a aVar) {
        File q5 = this.f2361b.q(str, "report");
        g f5 = g.f();
        f5.b("Writing native session report for " + str + " to file: " + q5);
        z(q5, dVar, str, aVar);
    }

    public SortedSet p() {
        return new TreeSet(this.f2361b.f()).descendingSet();
    }

    public long q(String str) {
        return this.f2361b.q(str, "start-time").lastModified();
    }

    public boolean r() {
        if (!this.f2361b.o().isEmpty() || !this.f2361b.m().isEmpty() || !this.f2361b.j().isEmpty()) {
            return true;
        }
        return false;
    }

    public List u() {
        List<File> n5 = n();
        ArrayList arrayList = new ArrayList();
        for (File file : n5) {
            try {
                arrayList.add(C1903A.a(f2357g.L(y(file)), file.getName(), file));
            } catch (IOException e5) {
                g f5 = g.f();
                f5.l("Could not load report file " + file + "; deleting", e5);
                file.delete();
            }
        }
        return arrayList;
    }

    public void w(F.e.d dVar, String str, boolean z4) {
        int i5 = this.f2362c.b().f2421a.f2432a;
        try {
            D(this.f2361b.q(str, m(this.f2360a.getAndIncrement(), z4)), f2357g.k(dVar));
        } catch (IOException e5) {
            g f5 = g.f();
            f5.l("Could not persist event for session " + str, e5);
        }
        C(str, i5);
    }

    public void x(F f5) {
        F.e n5 = f5.n();
        if (n5 == null) {
            g.f().b("Could not get session for report");
            return;
        }
        String i5 = n5.i();
        try {
            D(this.f2361b.q(i5, "report"), f2357g.M(f5));
            E(this.f2361b.q(i5, "start-time"), "", n5.l());
        } catch (IOException e5) {
            g f6 = g.f();
            f6.c("Could not persist report for session " + i5, e5);
        }
    }
}
