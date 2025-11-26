package com.mbridge.msdk.video.signal;

import android.app.Activity;
import com.mbridge.msdk.out.NativeListener;
import com.mbridge.msdk.videocommon.d.c;
import u1.b;

public interface a extends e {

    /* renamed from: com.mbridge.msdk.video.signal.a$a  reason: collision with other inner class name */
    public interface C0112a extends NativeListener.NativeTrackingListener {
        void a();

        void a(int i5, String str);

        void a(boolean z4);

        void b();
    }

    int a();

    void a(int i5);

    void a(int i5, String str);

    void a(Activity activity);

    void a(C0112a aVar);

    void a(c cVar);

    void a(String str);

    void a(u1.a aVar);

    void a(b bVar);

    void a(v1.b bVar);

    void a(boolean z4);

    void b(int i5);

    void b(String str);

    void b(boolean z4);

    boolean b();

    String c();

    void c(int i5);

    void d();

    void d(int i5);

    void e();

    void e(int i5);

    void f();

    void f(int i5);

    int g();

    String g(int i5);

    int h();

    void h(int i5);

    String i();
}
