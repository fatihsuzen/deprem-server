package D0;

import android.content.Context;
import java.io.File;
import java.io.FilenameFilter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import u0.j;
import x0.C1914j;

public class g {

    /* renamed from: a  reason: collision with root package name */
    final String f2365a;

    /* renamed from: b  reason: collision with root package name */
    private final File f2366b;

    /* renamed from: c  reason: collision with root package name */
    private final File f2367c;

    /* renamed from: d  reason: collision with root package name */
    private final File f2368d;

    /* renamed from: e  reason: collision with root package name */
    private final File f2369e;

    /* renamed from: f  reason: collision with root package name */
    private final File f2370f;

    /* renamed from: g  reason: collision with root package name */
    private final File f2371g;

    public g(Context context) {
        String str;
        String d5 = j.f16663a.e(context).d();
        this.f2365a = d5;
        File filesDir = context.getFilesDir();
        this.f2366b = filesDir;
        if (x()) {
            str = ".crashlytics.v3" + File.separator + w(d5);
        } else {
            str = ".com.google.firebase.crashlytics.files.v1";
        }
        File s5 = s(new File(filesDir, str));
        this.f2367c = s5;
        this.f2368d = s(new File(s5, "open-sessions"));
        this.f2369e = s(new File(s5, "reports"));
        this.f2370f = s(new File(s5, "priority-reports"));
        this.f2371g = s(new File(s5, "native-reports"));
    }

    private void b(String str) {
        File file = new File(this.f2366b, str);
        if (file.exists() && u(file)) {
            u0.g f5 = u0.g.f();
            f5.b("Deleted previous Crashlytics file system: " + file.getPath());
        }
    }

    private void c(String str) {
        String[] list;
        if (this.f2366b.exists() && (list = this.f2366b.list(new f(str))) != null) {
            for (String b5 : list) {
                b(b5);
            }
        }
    }

    private File p(String str) {
        return t(new File(this.f2368d, str));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0053, code lost:
        return r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static synchronized java.io.File s(java.io.File r4) {
        /*
            java.lang.Class<D0.g> r0 = D0.g.class
            monitor-enter(r0)
            boolean r1 = r4.exists()     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x0034
            boolean r1 = r4.isDirectory()     // Catch:{ all -> 0x0032 }
            if (r1 == 0) goto L_0x0011
            monitor-exit(r0)
            return r4
        L_0x0011:
            u0.g r1 = u0.g.f()     // Catch:{ all -> 0x0032 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0032 }
            r2.<init>()     // Catch:{ all -> 0x0032 }
            java.lang.String r3 = "Unexpected non-directory file: "
            r2.append(r3)     // Catch:{ all -> 0x0032 }
            r2.append(r4)     // Catch:{ all -> 0x0032 }
            java.lang.String r3 = "; deleting file and creating new directory."
            r2.append(r3)     // Catch:{ all -> 0x0032 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0032 }
            r1.b(r2)     // Catch:{ all -> 0x0032 }
            r4.delete()     // Catch:{ all -> 0x0032 }
            goto L_0x0034
        L_0x0032:
            r4 = move-exception
            goto L_0x0054
        L_0x0034:
            boolean r1 = r4.mkdirs()     // Catch:{ all -> 0x0032 }
            if (r1 != 0) goto L_0x0052
            u0.g r1 = u0.g.f()     // Catch:{ all -> 0x0032 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0032 }
            r2.<init>()     // Catch:{ all -> 0x0032 }
            java.lang.String r3 = "Could not create Crashlytics-specific directory: "
            r2.append(r3)     // Catch:{ all -> 0x0032 }
            r2.append(r4)     // Catch:{ all -> 0x0032 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0032 }
            r1.d(r2)     // Catch:{ all -> 0x0032 }
        L_0x0052:
            monitor-exit(r0)
            return r4
        L_0x0054:
            monitor-exit(r0)     // Catch:{ all -> 0x0032 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: D0.g.s(java.io.File):java.io.File");
    }

    private static File t(File file) {
        file.mkdirs();
        return file;
    }

    static boolean u(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null) {
            for (File u5 : listFiles) {
                u(u5);
            }
        }
        return file.delete();
    }

    private static List v(Object[] objArr) {
        if (objArr == null) {
            return Collections.EMPTY_LIST;
        }
        return Arrays.asList(objArr);
    }

    static String w(String str) {
        if (str.length() > 40) {
            return C1914j.A(str);
        }
        return str.replaceAll("[^a-zA-Z0-9.]", "_");
    }

    private boolean x() {
        return !this.f2365a.isEmpty();
    }

    public void d() {
        b(".com.google.firebase.crashlytics");
        b(".com.google.firebase.crashlytics-ndk");
        if (x()) {
            b(".com.google.firebase.crashlytics.files.v1");
            c(".com.google.firebase.crashlytics.files.v2" + File.pathSeparator);
        }
    }

    public boolean e(String str) {
        return u(new File(this.f2368d, str));
    }

    public List f() {
        return v(this.f2368d.list());
    }

    public File g(String str) {
        return new File(this.f2367c, str);
    }

    public List h(FilenameFilter filenameFilter) {
        return v(this.f2367c.listFiles(filenameFilter));
    }

    public File i(String str) {
        return new File(this.f2371g, str);
    }

    public List j() {
        return v(this.f2371g.listFiles());
    }

    public File k(String str) {
        return t(new File(p(str), "native"));
    }

    public File l(String str) {
        return new File(this.f2370f, str);
    }

    public List m() {
        return v(this.f2370f.listFiles());
    }

    public File n(String str) {
        return new File(this.f2369e, str);
    }

    public List o() {
        return v(this.f2369e.listFiles());
    }

    public File q(String str, String str2) {
        return new File(p(str), str2);
    }

    public List r(String str, FilenameFilter filenameFilter) {
        return v(p(str).listFiles(filenameFilter));
    }
}
