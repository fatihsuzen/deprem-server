package e2;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import c2.C2314a;
import com.mbridge.msdk.playercommon.exoplayer2.util.MimeTypes;
import java.io.IOException;

/* renamed from: e2.a  reason: case insensitive filesystem */
public abstract class C2347a {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f21431a = false;

    /* renamed from: b  reason: collision with root package name */
    protected Context f21432b = null;

    /* renamed from: c  reason: collision with root package name */
    public int f21433c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f21434d = 0;

    /* renamed from: e  reason: collision with root package name */
    c f21435e = null;

    /* renamed from: f  reason: collision with root package name */
    Handler f21436f = null;

    /* renamed from: g  reason: collision with root package name */
    protected boolean f21437g = false;

    /* renamed from: h  reason: collision with root package name */
    boolean f21438h = false;

    /* renamed from: i  reason: collision with root package name */
    String[] f21439i = new String[0];

    /* renamed from: j  reason: collision with root package name */
    boolean f21440j = false;

    /* renamed from: k  reason: collision with root package name */
    boolean f21441k = false;

    /* renamed from: l  reason: collision with root package name */
    boolean f21442l = true;

    /* renamed from: m  reason: collision with root package name */
    int f21443m = -1;

    /* renamed from: n  reason: collision with root package name */
    int f21444n = 0;

    /* renamed from: o  reason: collision with root package name */
    int f21445o = C2314a.f20797b;

    /* renamed from: e2.a$b */
    private class b extends Handler {
        private b() {
        }

        public final void handleMessage(Message message) {
            int i5 = message.getData().getInt("action");
            String string = message.getData().getString(MimeTypes.BASE_TYPE_TEXT);
            if (i5 == 1) {
                C2347a aVar = C2347a.this;
                aVar.c(aVar.f21444n, string);
            } else if (i5 == 2) {
                C2347a aVar2 = C2347a.this;
                aVar2.a(aVar2.f21444n, aVar2.f21443m);
            } else if (i5 == 3) {
                C2347a aVar3 = C2347a.this;
                aVar3.d(aVar3.f21444n, string);
            }
        }
    }

    /* renamed from: e2.a$c */
    private class c extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private final C2347a f21447a;

        public c(C2347a aVar) {
            this.f21447a = aVar;
        }

        public void run() {
            C2347a aVar = this.f21447a;
            if (aVar.f21445o > 0) {
                synchronized (aVar) {
                    try {
                        C2314a.c("Command " + this.f21447a.f21444n + " is waiting for: " + this.f21447a.f21445o);
                        C2347a aVar2 = this.f21447a;
                        aVar2.wait((long) aVar2.f21445o);
                    } catch (InterruptedException e5) {
                        C2314a.c("Exception: " + e5);
                    }
                    if (!this.f21447a.i()) {
                        C2314a.c("Timeout Exception has occurred for command: " + this.f21447a.f21444n + ".");
                        C2347a.this.m("Timeout Exception");
                    }
                }
            }
        }
    }

    public C2347a(int i5, boolean z4, String... strArr) {
        this.f21439i = strArr;
        this.f21444n = i5;
        e(z4);
    }

    private void e(boolean z4) {
        this.f21442l = z4;
        if (Looper.myLooper() == null || !z4) {
            C2314a.c("CommandHandler not created");
            return;
        }
        C2314a.c("CommandHandler created");
        this.f21436f = new b();
    }

    /* access modifiers changed from: protected */
    public final void b() {
        if (!this.f21441k) {
            synchronized (this) {
                try {
                    Handler handler = this.f21436f;
                    if (handler == null || !this.f21442l) {
                        a(this.f21444n, this.f21443m);
                    } else {
                        Message obtainMessage = handler.obtainMessage();
                        Bundle bundle = new Bundle();
                        bundle.putInt("action", 2);
                        obtainMessage.setData(bundle);
                        this.f21436f.sendMessage(obtainMessage);
                    }
                    C2314a.c("Command " + this.f21444n + " finished.");
                    f();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public void c(int i5, String str) {
        C2314a.e("Command", "ID: " + i5 + ", " + str);
        this.f21434d = this.f21434d + 1;
    }

    /* access modifiers changed from: protected */
    public final void f() {
        this.f21438h = false;
        this.f21440j = true;
        notifyAll();
    }

    public final String g() {
        StringBuilder sb = new StringBuilder();
        for (int i5 = 0; i5 < this.f21439i.length; i5++) {
            if (i5 > 0) {
                sb.append(10);
            }
            sb.append(this.f21439i[i5]);
        }
        return sb.toString();
    }

    public final boolean h() {
        return this.f21438h;
    }

    public final boolean i() {
        return this.f21440j;
    }

    /* access modifiers changed from: protected */
    public final void j(int i5, String str) {
        this.f21433c++;
        Handler handler = this.f21436f;
        if (handler == null || !this.f21442l) {
            c(i5, str);
            return;
        }
        Message obtainMessage = handler.obtainMessage();
        Bundle bundle = new Bundle();
        bundle.putInt("action", 1);
        bundle.putString(MimeTypes.BASE_TYPE_TEXT, str);
        obtainMessage.setData(bundle);
        this.f21436f.sendMessage(obtainMessage);
    }

    /* access modifiers changed from: protected */
    public final void k(int i5) {
        synchronized (this) {
            this.f21443m = i5;
        }
    }

    /* access modifiers changed from: protected */
    public final void l() {
        this.f21437g = true;
        c cVar = new c(this);
        this.f21435e = cVar;
        cVar.setPriority(1);
        this.f21435e.start();
        this.f21438h = true;
    }

    /* access modifiers changed from: protected */
    public final void m(String str) {
        try {
            C2348b.z();
            C2314a.c("Terminating all shells.");
            n(str);
        } catch (IOException unused) {
        }
    }

    /* access modifiers changed from: protected */
    public final void n(String str) {
        synchronized (this) {
            try {
                Handler handler = this.f21436f;
                if (handler == null || !this.f21442l) {
                    d(this.f21444n, str);
                } else {
                    Message obtainMessage = handler.obtainMessage();
                    Bundle bundle = new Bundle();
                    bundle.putInt("action", 3);
                    bundle.putString(MimeTypes.BASE_TYPE_TEXT, str);
                    obtainMessage.setData(bundle);
                    this.f21436f.sendMessage(obtainMessage);
                }
                C2314a.c("Command " + this.f21444n + " did not finish because it was terminated. Termination reason: " + str);
                k(-1);
                this.f21441k = true;
                f();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void a(int i5, int i6) {
    }

    public void d(int i5, String str) {
    }
}
