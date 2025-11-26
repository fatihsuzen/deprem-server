package Z1;

import Y1.C2260d;
import android.content.Context;
import b2.C2286f;
import b2.C2290j;
import java.io.DataInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import kotlin.jvm.internal.t;
import t3.s;

public final class d {

    /* renamed from: a  reason: collision with root package name */
    private final Context f20246a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final i f20247b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public final C2263c f20248c;

    /* renamed from: d  reason: collision with root package name */
    private int f20249d = -1;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ServerSocket f20250e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Thread f20251f;

    /* renamed from: g  reason: collision with root package name */
    private Thread f20252g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public C2260d f20253h;

    private final class a implements Runnable {
        public a() {
        }

        public void run() {
            try {
                if (d.this.f20248c.f() == null) {
                    d.this.f20247b.b();
                    return;
                }
                Socket f5 = d.this.f20248c.f();
                t.b(f5);
                if (f5.isClosed()) {
                    d.this.f20247b.b();
                    return;
                }
                while (true) {
                    Socket f6 = d.this.f20248c.f();
                    t.b(f6);
                    String readUTF = new DataInputStream(f6.getInputStream()).readUTF();
                    if (readUTF == null) {
                        d.this.f20247b.b();
                    } else if (s.E(readUTF, "OK", true)) {
                        if (d.this.f20248c.e() != null) {
                            i e5 = d.this.f20247b;
                            C2260d e6 = d.this.f20248c.e();
                            t.b(e6);
                            e5.q(e6);
                        }
                    } else if (s.E(readUTF, "KO", true)) {
                        d.this.f20247b.h();
                    } else if (s.E(readUTF, "FileReceived", true)) {
                        d.this.f20247b.r();
                    } else if (s.P(readUTF, "resolveService:", false, 2, (Object) null)) {
                        String substring = readUTF.substring(15);
                        t.d(substring, "substring(...)");
                        d.this.f20247b.s(substring);
                    } else {
                        d.this.f20253h = new C2260d();
                        C2260d a5 = d.this.f20253h;
                        t.b(a5);
                        a5.c(readUTF);
                        i e7 = d.this.f20247b;
                        C2260d a6 = d.this.f20253h;
                        t.b(a6);
                        e7.v(a6);
                    }
                }
            } catch (EOFException unused) {
                d.this.f20247b.j();
            } catch (IOException unused2) {
                d.this.f20247b.b();
            } catch (Exception unused3) {
                d.this.f20247b.b();
            }
        }
    }

    public final class b implements Runnable {
        public b() {
        }

        public void run() {
            d.this.j();
        }
    }

    public final class c implements Runnable {
        public c() {
        }

        public void run() {
            try {
                d.this.f20250e = new ServerSocket(0);
                d dVar = d.this;
                ServerSocket b5 = dVar.f20250e;
                t.b(b5);
                dVar.k(b5.getLocalPort());
                d.this.f20247b.f(d.this.i());
                while (true) {
                    Thread c5 = d.this.f20251f;
                    t.b(c5);
                    if (!c5.isInterrupted()) {
                        ServerSocket b6 = d.this.f20250e;
                        t.b(b6);
                        Socket accept = b6.accept();
                        C2263c d5 = d.this.f20248c;
                        t.b(accept);
                        d5.m(accept);
                        d.this.f20247b.d(accept.getRemoteSocketAddress().toString());
                    } else {
                        return;
                    }
                }
            } catch (IOException e5) {
                e5.printStackTrace();
            } catch (Exception e6) {
                e6.printStackTrace();
            }
        }
    }

    public d(Context context, i iVar, C2263c cVar) {
        t.e(context, "context");
        t.e(iVar, "nsdListener");
        t.e(cVar, "nsdConnectionManager");
        this.f20246a = context;
        this.f20247b = iVar;
        this.f20248c = cVar;
        o();
    }

    /* access modifiers changed from: private */
    public final void j() {
        int read;
        try {
            File f5 = new C2290j().f(this.f20246a);
            C2260d dVar = this.f20253h;
            t.b(dVar);
            if (dVar.e() != null) {
                C2260d dVar2 = this.f20253h;
                t.b(dVar2);
                String e5 = dVar2.e();
                t.b(e5);
                File file = new File(f5, e5);
                Socket g5 = this.f20248c.g();
                t.b(g5);
                InputStream inputStream = g5.getInputStream();
                if (inputStream != null) {
                    int i5 = 8192;
                    byte[] bArr = new byte[8192];
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    C2260d dVar3 = this.f20253h;
                    t.b(dVar3);
                    long h5 = dVar3.h();
                    int i6 = 0;
                    long j5 = 0;
                    int i7 = 0;
                    int i8 = 0;
                    while (((long) i7) < h5 && (read = inputStream.read(bArr, i6, i5)) > 0) {
                        fileOutputStream.write(bArr, i6, read);
                        i7 += read;
                        byte[] bArr2 = bArr;
                        int i9 = (int) ((((double) i7) * 100.0d) / ((double) h5));
                        if (i9 <= i8 + 5) {
                            long j6 = j5;
                            if (System.currentTimeMillis() <= j6 + ((long) 1000) || i9 <= i8) {
                                bArr = bArr2;
                                j5 = j6;
                                i5 = 8192;
                                i6 = 0;
                            }
                        }
                        j5 = System.currentTimeMillis();
                        this.f20247b.n(i9);
                        i8 = i9;
                        bArr = bArr2;
                        i5 = 8192;
                        i6 = 0;
                    }
                    this.f20247b.n(100);
                    fileOutputStream.close();
                    String e6 = C2286f.f20690a.e(file.getAbsolutePath());
                    if (e6 != null) {
                        C2260d dVar4 = this.f20253h;
                        t.b(dVar4);
                        if (s.E(e6, dVar4.g(), true)) {
                            i iVar = this.f20247b;
                            C2260d dVar5 = this.f20253h;
                            t.b(dVar5);
                            String e7 = dVar5.e();
                            t.b(e7);
                            iVar.y(e7, "File Transfer is correct!");
                            return;
                        }
                    }
                    this.f20247b.m("ERROR: File hashes do not macth!");
                    return;
                }
                this.f20247b.m("ERROR: cant create output file");
            }
        } catch (Exception e8) {
            if (e8.getMessage() != null) {
                i iVar2 = this.f20247b;
                String message = e8.getMessage();
                t.b(message);
                iVar2.m(message);
                return;
            }
            this.f20247b.m("Exception");
        }
    }

    private final void o() {
        Thread thread = new Thread(new c());
        this.f20251f = thread;
        t.b(thread);
        thread.start();
    }

    public final int i() {
        return this.f20249d;
    }

    public final void k(int i5) {
        this.f20249d = i5;
    }

    public final void l() {
        Thread thread = this.f20252g;
        if (thread != null) {
            t.b(thread);
            if (thread.isAlive()) {
                return;
            }
        }
        Thread thread2 = new Thread(new a());
        this.f20252g = thread2;
        t.b(thread2);
        thread2.start();
    }

    public final void m(C2260d dVar) {
        this.f20248c.l(dVar);
        l();
    }

    public final void n() {
        new Thread(new b()).start();
    }

    public final void p() {
        Thread thread = this.f20251f;
        if (thread != null) {
            thread.interrupt();
        }
        try {
            ServerSocket serverSocket = this.f20250e;
            if (serverSocket != null) {
                serverSocket.close();
            }
            this.f20250e = null;
        } catch (IOException unused) {
        }
    }
}
