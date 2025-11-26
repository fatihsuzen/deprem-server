package Z1;

import Y1.C2260d;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import kotlin.jvm.internal.t;

/* renamed from: Z1.a  reason: case insensitive filesystem */
public final class C2261a {

    /* renamed from: a  reason: collision with root package name */
    private i f20227a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final C2263c f20228b;

    /* renamed from: c  reason: collision with root package name */
    private Thread f20229c;

    /* renamed from: Z1.a$a  reason: collision with other inner class name */
    private final class C0198a implements Runnable {
        public C0198a() {
        }

        public void run() {
            if (C2261a.this.d("FileReceived")) {
                C2261a.this.c().w();
            }
        }
    }

    /* renamed from: Z1.a$b */
    private final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final File f20231a;

        public b(File file) {
            this.f20231a = file;
        }

        public void run() {
            try {
                if (this.f20231a != null) {
                    C2261a.this.c().u(this.f20231a);
                    byte[] bArr = new byte[8192];
                    FileInputStream fileInputStream = new FileInputStream(this.f20231a);
                    Socket g5 = C2261a.this.f20228b.g();
                    t.b(g5);
                    OutputStream outputStream = g5.getOutputStream();
                    int available = fileInputStream.available();
                    long j5 = 0;
                    int i5 = 0;
                    int i6 = 0;
                    while (true) {
                        int read = fileInputStream.read(bArr, 0, 8192);
                        if (read > 0) {
                            outputStream.write(bArr, 0, read);
                            i5 += read;
                            if (available > 0) {
                                int i7 = (int) ((((double) i5) * 100.0d) / ((double) available));
                                if (i7 <= i6 + 5) {
                                    if (System.currentTimeMillis() > ((long) 1000) + j5 && i7 > i6) {
                                    }
                                }
                                j5 = System.currentTimeMillis();
                                C2261a.this.c().o(i7);
                                i6 = i7;
                            }
                        } else {
                            C2261a.this.c().o(100);
                            fileInputStream.close();
                            outputStream.flush();
                            C2261a.this.c().l();
                            return;
                        }
                    }
                }
            } catch (Exception e5) {
                if (e5.getMessage() != null) {
                    i c5 = C2261a.this.c();
                    String message = e5.getMessage();
                    t.b(message);
                    c5.x(message);
                    return;
                }
                C2261a.this.c().x("Exception");
            }
        }
    }

    /* renamed from: Z1.a$c */
    public final class c implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final boolean f20233a;

        public c(boolean z4) {
            this.f20233a = z4;
        }

        public void run() {
            String str;
            if (this.f20233a) {
                str = "OK";
            } else {
                str = "KO";
            }
            if (!C2261a.this.d(str)) {
                return;
            }
            if (this.f20233a) {
                C2261a.this.f20228b.i().n();
            } else {
                C2261a.this.f20228b.i().l();
            }
        }
    }

    /* renamed from: Z1.a$d */
    private final class d implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final String f20235a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2261a f20236b;

        public d(C2261a aVar, String str) {
            t.e(str, "serviceName");
            this.f20236b = aVar;
            this.f20235a = str;
        }

        public void run() {
            if (this.f20236b.d("resolveService:" + this.f20235a)) {
                this.f20236b.f20228b.i().l();
            }
        }
    }

    /* renamed from: Z1.a$e */
    private final class e implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        private final C2260d f20237a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ C2261a f20238b;

        public e(C2261a aVar, C2260d dVar) {
            t.e(dVar, "ftiToSend");
            this.f20238b = aVar;
            this.f20237a = dVar;
        }

        public void run() {
            if (this.f20238b.d(this.f20237a.i())) {
                this.f20238b.c().k(this.f20237a);
            }
        }
    }

    public C2261a(i iVar, C2263c cVar) {
        t.e(iVar, "nsdListener");
        t.e(cVar, "nsdConnectionManager");
        this.f20227a = iVar;
        this.f20228b = cVar;
    }

    /* access modifiers changed from: private */
    public final boolean d(String str) {
        try {
            if (this.f20228b.f() == null) {
                this.f20227a.p("Socket is closed");
                return false;
            }
            Socket f5 = this.f20228b.f();
            t.b(f5);
            if (f5.isClosed()) {
                this.f20227a.p("Socket is closed");
                return false;
            }
            Socket f6 = this.f20228b.f();
            t.b(f6);
            DataOutputStream dataOutputStream = new DataOutputStream(f6.getOutputStream());
            dataOutputStream.writeUTF(str);
            dataOutputStream.flush();
            return true;
        } catch (UnknownHostException e5) {
            e5.printStackTrace();
            this.f20227a.p("Unknown Host");
            return false;
        } catch (IOException e6) {
            e6.printStackTrace();
            this.f20227a.p("I/O Exception");
            return false;
        } catch (Exception e7) {
            e7.printStackTrace();
            this.f20227a.p("Error3");
            return false;
        }
    }

    public final i c() {
        return this.f20227a;
    }

    public final void e() {
        new Thread(new C0198a()).start();
    }

    public final void f(File file) {
        t.e(file, "file");
        Thread thread = new Thread(new b(file));
        this.f20229c = thread;
        t.b(thread);
        thread.start();
    }

    public final void g(boolean z4) {
        new Thread(new c(z4)).start();
    }

    public final void h(String str) {
        t.e(str, "serviceName");
        new Thread(new d(this, str)).start();
    }

    public final void i(C2260d dVar) {
        t.e(dVar, "ftiToSend");
        new Thread(new e(this, dVar)).start();
    }
}
