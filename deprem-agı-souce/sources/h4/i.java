package h4;

import g4.b;
import g4.e;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.LinkedBlockingQueue;
import p4.a;

public class i {

    /* renamed from: g  reason: collision with root package name */
    private static final String f23767g = b.i(i.class);

    /* renamed from: a  reason: collision with root package name */
    private final LinkedBlockingQueue f23768a = new LinkedBlockingQueue();

    /* renamed from: b  reason: collision with root package name */
    private final File f23769b;

    /* renamed from: c  reason: collision with root package name */
    private final long f23770c;

    /* renamed from: d  reason: collision with root package name */
    private final long f23771d;

    /* renamed from: e  reason: collision with root package name */
    private long f23772e = 0;

    /* renamed from: f  reason: collision with root package name */
    private boolean f23773f;

    public i(e eVar) {
        this.f23773f = false;
        this.f23770c = eVar.e();
        this.f23771d = eVar.f();
        try {
            File file = new File(new File(eVar.c().c().getCacheDir(), "piwik_cache"), new URL(eVar.a()).getHost());
            this.f23769b = file;
            File[] listFiles = file.listFiles();
            if (listFiles != null) {
                Arrays.sort(listFiles);
                for (File file2 : listFiles) {
                    this.f23772e += file2.length();
                    this.f23768a.add(file2);
                }
            }
        } catch (MalformedURLException e5) {
            throw new RuntimeException(e5);
        }
    }

    private void b() {
        long j5;
        long j6;
        long currentTimeMillis = System.currentTimeMillis();
        long j7 = this.f23770c;
        long j8 = 0;
        if (j7 < 0) {
            a.b(f23767g).a("Caching is disabled.", new Object[0]);
            while (!this.f23768a.isEmpty()) {
                File file = (File) this.f23768a.poll();
                if (file.delete()) {
                    a.b(f23767g).c("Deleted cache container %s", file.getPath());
                }
            }
        } else if (j7 > 0) {
            Iterator it = this.f23768a.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                File file2 = (File) it.next();
                try {
                    j6 = Long.parseLong(file2.getName().split("_")[1]);
                } catch (Exception e5) {
                    a.b(f23767g).d(e5);
                    j6 = j8;
                }
                j5 = j8;
                if (j6 >= System.currentTimeMillis() - this.f23770c) {
                    break;
                }
                if (file2.delete()) {
                    a.b(f23767g).c("Deleted cache container %s", file2.getPath());
                } else {
                    a.b(f23767g).c("Failed to delete cache container %s", file2.getPath());
                }
                it.remove();
                j8 = j5;
            }
        }
        j5 = j8;
        if (this.f23771d != j5) {
            Iterator it2 = this.f23768a.iterator();
            while (it2.hasNext() && this.f23772e > this.f23771d) {
                File file3 = (File) it2.next();
                this.f23772e -= file3.length();
                it2.remove();
                if (file3.delete()) {
                    a.b(f23767g).c("Deleted cache container %s", file3.getPath());
                } else {
                    a.b(f23767g).c("Failed to delete cache container %s", file3.getPath());
                }
            }
        }
        a.b(f23767g).a("Cache check took %dms", Long.valueOf(System.currentTimeMillis() - currentTimeMillis));
    }

    private boolean c() {
        if (this.f23770c >= 0) {
            return true;
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x0077, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0078, code lost:
        r2 = r0;
        r4 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x007b, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
        p4.a.b(f23767g).d(r0);
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0077 A[ExcHandler: all (r0v10 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:9:0x0017] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00ab A[SYNTHETIC, Splitter:B:51:0x00ab] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00d0 A[SYNTHETIC, Splitter:B:56:0x00d0] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List e(java.io.File r17) {
        /*
            r16 = this;
            r1 = r16
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            boolean r0 = r17.exists()
            if (r0 != 0) goto L_0x000e
            return r2
        L_0x000e:
            r3 = 0
            r4 = 0
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ IOException -> 0x009d }
            r6 = r17
            r5.<init>(r6)     // Catch:{ IOException -> 0x009b }
            java.io.InputStreamReader r0 = new java.io.InputStreamReader     // Catch:{ IOException -> 0x0086, all -> 0x0077 }
            r0.<init>(r5)     // Catch:{ IOException -> 0x0086, all -> 0x0077 }
            java.io.BufferedReader r4 = new java.io.BufferedReader     // Catch:{ IOException -> 0x0086, all -> 0x0077 }
            r4.<init>(r0)     // Catch:{ IOException -> 0x0086, all -> 0x0077 }
            java.lang.String r0 = r4.readLine()     // Catch:{ IOException -> 0x0086, all -> 0x0077 }
            java.lang.String r7 = "1"
            boolean r0 = r7.equals(r0)     // Catch:{ IOException -> 0x0086, all -> 0x0077 }
            if (r0 != 0) goto L_0x003c
            r5.close()     // Catch:{ IOException -> 0x0031 }
            return r2
        L_0x0031:
            r0 = move-exception
            java.lang.String r3 = f23767g
            p4.a$b r3 = p4.a.b(r3)
            r3.d(r0)
            return r2
        L_0x003c:
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0086, all -> 0x0077 }
            long r9 = r1.f23770c     // Catch:{ IOException -> 0x0086, all -> 0x0077 }
            long r7 = r7 - r9
        L_0x0043:
            java.lang.String r0 = r4.readLine()     // Catch:{ IOException -> 0x0086, all -> 0x0077 }
            if (r0 == 0) goto L_0x0089
            java.lang.String r9 = " "
            int r9 = r0.indexOf(r9)     // Catch:{ IOException -> 0x0086, all -> 0x0077 }
            r10 = -1
            if (r9 != r10) goto L_0x0053
            goto L_0x0043
        L_0x0053:
            java.lang.String r10 = r0.substring(r3, r9)     // Catch:{ Exception -> 0x007b, all -> 0x0077 }
            long r10 = java.lang.Long.parseLong(r10)     // Catch:{ Exception -> 0x007b, all -> 0x0077 }
            long r12 = r1.f23770c     // Catch:{ Exception -> 0x007b, all -> 0x0077 }
            r14 = 0
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 <= 0) goto L_0x0068
            int r12 = (r10 > r7 ? 1 : (r10 == r7 ? 0 : -1))
            if (r12 >= 0) goto L_0x0068
            goto L_0x0043
        L_0x0068:
            int r9 = r9 + 1
            java.lang.String r0 = r0.substring(r9)     // Catch:{ Exception -> 0x007b, all -> 0x0077 }
            h4.g r9 = new h4.g     // Catch:{ Exception -> 0x007b, all -> 0x0077 }
            r9.<init>(r10, r0)     // Catch:{ Exception -> 0x007b, all -> 0x0077 }
            r2.add(r9)     // Catch:{ Exception -> 0x007b, all -> 0x0077 }
            goto L_0x0043
        L_0x0077:
            r0 = move-exception
            r2 = r0
            r4 = r5
            goto L_0x00ce
        L_0x007b:
            r0 = move-exception
            java.lang.String r9 = f23767g     // Catch:{ IOException -> 0x0086, all -> 0x0077 }
            p4.a$b r9 = p4.a.b(r9)     // Catch:{ IOException -> 0x0086, all -> 0x0077 }
            r9.d(r0)     // Catch:{ IOException -> 0x0086, all -> 0x0077 }
            goto L_0x0043
        L_0x0086:
            r0 = move-exception
            r4 = r5
            goto L_0x00a0
        L_0x0089:
            r5.close()     // Catch:{ IOException -> 0x008d }
            goto L_0x00ae
        L_0x008d:
            r0 = move-exception
            java.lang.String r4 = f23767g
            p4.a$b r4 = p4.a.b(r4)
            r4.d(r0)
            goto L_0x00ae
        L_0x0098:
            r0 = move-exception
            r2 = r0
            goto L_0x00ce
        L_0x009b:
            r0 = move-exception
            goto L_0x00a0
        L_0x009d:
            r0 = move-exception
            r6 = r17
        L_0x00a0:
            java.lang.String r5 = f23767g     // Catch:{ all -> 0x0098 }
            p4.a$b r5 = p4.a.b(r5)     // Catch:{ all -> 0x0098 }
            r5.d(r0)     // Catch:{ all -> 0x0098 }
            if (r4 == 0) goto L_0x00ae
            r4.close()     // Catch:{ IOException -> 0x008d }
        L_0x00ae:
            java.lang.String r0 = f23767g
            p4.a$b r0 = p4.a.b(r0)
            int r4 = r2.size()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.String r5 = r6.getPath()
            r6 = 2
            java.lang.Object[] r6 = new java.lang.Object[r6]
            r6[r3] = r4
            r3 = 1
            r6[r3] = r5
            java.lang.String r3 = "Restored %d events from %s"
            r0.a(r3, r6)
            return r2
        L_0x00ce:
            if (r4 == 0) goto L_0x00de
            r4.close()     // Catch:{ IOException -> 0x00d4 }
            goto L_0x00de
        L_0x00d4:
            r0 = move-exception
            java.lang.String r3 = f23767g
            p4.a$b r3 = p4.a.b(r3)
            r3.d(r0)
        L_0x00de:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: h4.i.e(java.io.File):java.util.List");
    }

    /* JADX WARNING: Removed duplicated region for block: B:43:0x00fb A[SYNTHETIC, Splitter:B:43:0x00fb] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x010c A[SYNTHETIC, Splitter:B:49:0x010c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.io.File g(java.util.List r18) {
        /*
            r17 = this;
            r1 = r17
            java.lang.String r0 = "\n"
            boolean r2 = r18.isEmpty()
            r3 = 0
            if (r2 == 0) goto L_0x000c
            return r3
        L_0x000c:
            java.io.File r2 = r1.f23769b
            boolean r2 = r2.exists()
            r4 = 0
            r5 = 1
            if (r2 != 0) goto L_0x002f
            java.io.File r2 = r1.f23769b
            boolean r2 = r2.mkdirs()
            if (r2 != 0) goto L_0x002f
            java.lang.String r2 = f23767g
            p4.a$b r2 = p4.a.b(r2)
            java.io.File r6 = r1.f23769b
            java.lang.Object[] r7 = new java.lang.Object[r5]
            r7[r4] = r6
            java.lang.String r6 = "Failed to make disk-cache dir '%s'"
            r2.c(r6, r7)
        L_0x002f:
            java.io.File r2 = new java.io.File
            java.io.File r6 = r1.f23769b
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "events_"
            r7.append(r8)
            int r8 = r18.size()
            int r8 = r8 - r5
            r9 = r18
            java.lang.Object r8 = r9.get(r8)
            h4.g r8 = (h4.g) r8
            long r10 = r8.b()
            r7.append(r10)
            java.lang.String r7 = r7.toString()
            r2.<init>(r6, r7)
            java.io.FileWriter r6 = new java.io.FileWriter     // Catch:{ IOException -> 0x00eb, all -> 0x00e8 }
            r6.<init>(r2)     // Catch:{ IOException -> 0x00eb, all -> 0x00e8 }
            java.lang.String r7 = "1"
            java.io.Writer r7 = r6.append(r7)     // Catch:{ IOException -> 0x0094 }
            r7.append(r0)     // Catch:{ IOException -> 0x0094 }
            long r7 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0094 }
            long r10 = r1.f23770c     // Catch:{ IOException -> 0x0094 }
            long r7 = r7 - r10
            java.util.Iterator r10 = r9.iterator()     // Catch:{ IOException -> 0x0094 }
            r11 = r4
        L_0x0072:
            boolean r12 = r10.hasNext()     // Catch:{ IOException -> 0x0094 }
            if (r12 == 0) goto L_0x00b5
            java.lang.Object r12 = r10.next()     // Catch:{ IOException -> 0x0094 }
            h4.g r12 = (h4.g) r12     // Catch:{ IOException -> 0x0094 }
            long r13 = r1.f23770c     // Catch:{ IOException -> 0x0094 }
            r15 = 0
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 <= 0) goto L_0x0096
            long r13 = r12.b()     // Catch:{ IOException -> 0x0094 }
            int r13 = (r13 > r7 ? 1 : (r13 == r7 ? 0 : -1))
            if (r13 >= 0) goto L_0x0096
            goto L_0x0072
        L_0x008f:
            r0 = move-exception
            r2 = r0
            r3 = r6
            goto L_0x010a
        L_0x0094:
            r0 = move-exception
            goto L_0x00ed
        L_0x0096:
            long r13 = r12.b()     // Catch:{ IOException -> 0x0094 }
            java.lang.String r11 = java.lang.String.valueOf(r13)     // Catch:{ IOException -> 0x0094 }
            java.io.Writer r11 = r6.append(r11)     // Catch:{ IOException -> 0x0094 }
            java.lang.String r13 = " "
            java.io.Writer r11 = r11.append(r13)     // Catch:{ IOException -> 0x0094 }
            java.lang.String r12 = r12.a()     // Catch:{ IOException -> 0x0094 }
            java.io.Writer r11 = r11.append(r12)     // Catch:{ IOException -> 0x0094 }
            r11.append(r0)     // Catch:{ IOException -> 0x0094 }
            r11 = r5
            goto L_0x0072
        L_0x00b5:
            r6.close()     // Catch:{ IOException -> 0x00b9 }
            goto L_0x00c3
        L_0x00b9:
            r0 = move-exception
            java.lang.String r6 = f23767g
            p4.a$b r6 = p4.a.b(r6)
            r6.d(r0)
        L_0x00c3:
            java.lang.String r0 = f23767g
            p4.a$b r0 = p4.a.b(r0)
            int r6 = r9.size()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.String r7 = r2.getPath()
            r8 = 2
            java.lang.Object[] r8 = new java.lang.Object[r8]
            r8[r4] = r6
            r8[r5] = r7
            java.lang.String r4 = "Saved %d events to %s"
            r0.a(r4, r8)
            if (r11 == 0) goto L_0x00e4
            return r2
        L_0x00e4:
            r2.delete()
            return r3
        L_0x00e8:
            r0 = move-exception
            r2 = r0
            goto L_0x010a
        L_0x00eb:
            r0 = move-exception
            r6 = r3
        L_0x00ed:
            java.lang.String r4 = f23767g     // Catch:{ all -> 0x008f }
            p4.a$b r4 = p4.a.b(r4)     // Catch:{ all -> 0x008f }
            r4.d(r0)     // Catch:{ all -> 0x008f }
            r2.delete()     // Catch:{ all -> 0x008f }
            if (r6 == 0) goto L_0x0109
            r6.close()     // Catch:{ IOException -> 0x00ff }
            goto L_0x0109
        L_0x00ff:
            r0 = move-exception
            java.lang.String r2 = f23767g
            p4.a$b r2 = p4.a.b(r2)
            r2.d(r0)
        L_0x0109:
            return r3
        L_0x010a:
            if (r3 == 0) goto L_0x011a
            r3.close()     // Catch:{ IOException -> 0x0110 }
            goto L_0x011a
        L_0x0110:
            r0 = move-exception
            java.lang.String r3 = f23767g
            p4.a$b r3 = p4.a.b(r3)
            r3.d(r0)
        L_0x011a:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: h4.i.g(java.util.List):java.io.File");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0057, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(java.util.List r8) {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.c()     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x0056
            boolean r0 = r8.isEmpty()     // Catch:{ all -> 0x002a }
            if (r0 == 0) goto L_0x000e
            goto L_0x0056
        L_0x000e:
            r7.b()     // Catch:{ all -> 0x002a }
            long r0 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x002a }
            java.io.File r2 = r7.g(r8)     // Catch:{ all -> 0x002a }
            if (r2 == 0) goto L_0x002c
            java.util.concurrent.LinkedBlockingQueue r3 = r7.f23768a     // Catch:{ all -> 0x002a }
            r3.add(r2)     // Catch:{ all -> 0x002a }
            long r3 = r7.f23772e     // Catch:{ all -> 0x002a }
            long r5 = r2.length()     // Catch:{ all -> 0x002a }
            long r3 = r3 + r5
            r7.f23772e = r3     // Catch:{ all -> 0x002a }
            goto L_0x002c
        L_0x002a:
            r8 = move-exception
            goto L_0x0058
        L_0x002c:
            long r3 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x002a }
            java.lang.String r5 = f23767g     // Catch:{ all -> 0x002a }
            p4.a$b r5 = p4.a.b(r5)     // Catch:{ all -> 0x002a }
            java.lang.String r6 = "Caching of %d events took %dms (%s)"
            int r8 = r8.size()     // Catch:{ all -> 0x002a }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x002a }
            long r3 = r3 - r0
            java.lang.Long r0 = java.lang.Long.valueOf(r3)     // Catch:{ all -> 0x002a }
            r1 = 3
            java.lang.Object[] r1 = new java.lang.Object[r1]     // Catch:{ all -> 0x002a }
            r3 = 0
            r1[r3] = r8     // Catch:{ all -> 0x002a }
            r8 = 1
            r1[r8] = r0     // Catch:{ all -> 0x002a }
            r8 = 2
            r1[r8] = r2     // Catch:{ all -> 0x002a }
            r5.a(r6, r1)     // Catch:{ all -> 0x002a }
            monitor-exit(r7)
            return
        L_0x0056:
            monitor-exit(r7)
            return
        L_0x0058:
            monitor-exit(r7)     // Catch:{ all -> 0x002a }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: h4.i.a(java.util.List):void");
    }

    public synchronized boolean d() {
        try {
            if (!this.f23773f) {
                b();
                this.f23773f = true;
            }
        } catch (Throwable th) {
            while (true) {
                throw th;
            }
        }
        return this.f23768a.isEmpty();
    }

    public synchronized List f() {
        try {
            ArrayList arrayList = new ArrayList();
            if (!c()) {
                return arrayList;
            }
            long currentTimeMillis = System.currentTimeMillis();
            while (!this.f23768a.isEmpty()) {
                File file = (File) this.f23768a.poll();
                if (file != null) {
                    arrayList.addAll(e(file));
                    if (!file.delete()) {
                        a.b(f23767g).c("Failed to delete cache container %s", file.getPath());
                    }
                }
            }
            b();
            long currentTimeMillis2 = System.currentTimeMillis();
            a.b(f23767g).a("Uncaching of %d events took %dms", Integer.valueOf(arrayList.size()), Long.valueOf(currentTimeMillis2 - currentTimeMillis));
            return arrayList;
        } finally {
            while (true) {
            }
        }
    }
}
